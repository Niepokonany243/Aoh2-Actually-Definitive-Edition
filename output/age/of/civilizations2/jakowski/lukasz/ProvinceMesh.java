package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;

public class ProvinceMesh {
    private static Mesh mesh;
    private static ShaderProgram shader;
    private static Texture colorTexture;
    private static Pixmap colorPixmap;
    private static float[] vertices;
    private static short[] indices;
    private static boolean initialized = false;
    
    private static final int VERTICES_PER_PROVINCE = 4;
    private static final int INDICES_PER_PROVINCE = 6;
    private static final int COMPONENTS_PER_VERTEX = 5; // x, y, u, v, provinceID
    public static boolean needsUpdate = true;

    public static void init() {
        if (initialized) dispose();
        
        int numProvinces = CFG.core.getProvinSize();
        if (numProvinces <= 0) return;

        mesh = new Mesh(true, numProvinces * VERTICES_PER_PROVINCE, numProvinces * INDICES_PER_PROVINCE,
                new VertexAttribute(VertexAttributes.Usage.Position, 2, "a_position"),
                new VertexAttribute(VertexAttributes.Usage.TextureCoordinates, 2, "a_texCoord"),
                new VertexAttribute(VertexAttributes.Usage.Generic, 1, "a_provinceID"));

        vertices = new float[numProvinces * VERTICES_PER_PROVINCE * COMPONENTS_PER_VERTEX];
        indices = new short[numProvinces * INDICES_PER_PROVINCE];

        for (int i = 0; i < numProvinces; i++) {
            Province p = CFG.core.getProv(i);
            TextureRegion region = ProvinceAtlas.getRegion(i);
            
            if (region == null) continue;

            float x1 = p.getMiX2();
            float y1 = -(p.getMiY4() + (int)(region.getRegionHeight() * CFG.map.getMpB().getMapExtraScale()));
            float x2 = x1 + (int)(region.getRegionWidth() * CFG.map.getMpB().getMapExtraScale());
            float y2 = -p.getMiY4();
            
            // Note: coordinates in drawing seem to involve MpC.getPY() and other offsets.
            // We might need to adjust these or handle them in the shader.
            // Current drawLandProv uses:
            // x = iTranslateProvincePosX + miX * mapSc3
            // y = -(MpC.getPY() + miY * mapSc3 + regionHeight * mapExtraScale)
            
            // We'll store local coordinates (relative to map 0,0) and pass iTranslateProvincePosX as a uniform or draw offset.

            int vOff = i * VERTICES_PER_PROVINCE * COMPONENTS_PER_VERTEX;
            
            // Bottom Left
            vertices[vOff] = p.getMiX2();
            vertices[vOff + 1] = -(p.getMiY4() + (int)(region.getRegionHeight() * CFG.map.getMpB().getMapExtraScale()));
            vertices[vOff + 2] = region.getU();
            vertices[vOff + 3] = region.getV2();
            vertices[vOff + 4] = i;

            // Top Left
            vertices[vOff + 5] = p.getMiX2();
            vertices[vOff + 6] = -p.getMiY4();
            vertices[vOff + 7] = region.getU();
            vertices[vOff + 8] = region.getV();
            vertices[vOff + 9] = i;

            // Top Right
            vertices[vOff + 10] = p.getMiX2() + (int)(region.getRegionWidth() * CFG.map.getMpB().getMapExtraScale());
            vertices[vOff + 11] = -p.getMiY4();
            vertices[vOff + 12] = region.getU2();
            vertices[vOff + 13] = region.getV();
            vertices[vOff + 14] = i;

            // Bottom Right
            vertices[vOff + 15] = p.getMiX2() + (int)(region.getRegionWidth() * CFG.map.getMpB().getMapExtraScale());
            vertices[vOff + 16] = -(p.getMiY4() + (int)(region.getRegionHeight() * CFG.map.getMpB().getMapExtraScale()));
            vertices[vOff + 17] = region.getU2();
            vertices[vOff + 18] = region.getV2();
            vertices[vOff + 19] = i;

            int iOff = i * INDICES_PER_PROVINCE;
            indices[iOff] = (short)(i * 4);
            indices[iOff + 1] = (short)(i * 4 + 1);
            indices[iOff + 2] = (short)(i * 4 + 2);
            indices[iOff + 3] = (short)(i * 4);
            indices[iOff + 4] = (short)(i * 4 + 2);
            indices[iOff + 5] = (short)(i * 4 + 3);
        }

        mesh.setVertices(vertices);
        mesh.setIndices(indices);

        colorPixmap = new Pixmap(getNextPowerOfTwo(numProvinces), 1, Pixmap.Format.RGBA8888);
        colorTexture = new Texture(colorPixmap);
        colorTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        String vertexShader = "attribute vec2 a_position;\n" +
                              "attribute vec2 a_texCoord;\n" +
                              "attribute float a_provinceID;\n" +
                              "uniform mat4 u_projTrans;\n" +
                              "uniform float u_translateX;\n" +
                              "uniform float u_translateY;\n" +
                              "varying vec2 v_texCoord;\n" +
                              "varying float v_provinceID;\n" +
                              "void main() {\n" +
                              "    v_texCoord = a_texCoord;\n" +
                              "    v_provinceID = a_provinceID;\n" +
                              "    gl_Position = u_projTrans * vec4(a_position.x + u_translateX, a_position.y + u_translateY, 0, 1);\n" +
                              "}";
        
        String fragmentShader = "#ifdef GL_ES\n" +
                                "precision mediump float;\n" +
                                "#endif\n" +
                                "varying vec2 v_texCoord;\n" +
                                "varying float v_provinceID;\n" +
                                "uniform sampler2D u_texture;\n" +
                                "uniform sampler2D u_colors;\n" +
                                "uniform float u_colorStep;\n" +
                                "void main() {\n" +
                                "    vec4 provColor = texture2D(u_colors, vec2((v_provinceID + 0.5) * u_colorStep, 0.5));\n" +
                                "    gl_FragColor = texture2D(u_texture, v_texCoord) * provColor;\n" +
                                "}";

        shader = new ShaderProgram(vertexShader, fragmentShader);
        if (!shader.isCompiled()) {
            Gdx.app.log("ProvinceMesh", "Shader compilation failed: " + shader.getLog());
        }

        initialized = true;
        updateAllStates();
    }

    private static int getNextPowerOfTwo(int value) {
        if (value == 0) return 1;
        value--;
        value |= value >> 1;
        value |= value >> 2;
        value |= value >> 4;
        value |= value >> 8;
        value |= value >> 16;
        return value + 1;
    }

    public static void updateProvinceColor(int provinceID) {
        if (!initialized) return;
        Province p = CFG.core.getProv(provinceID);
        
        if (p.getSeaProv()) {
            colorPixmap.setColor(0, 0, 0, 0);
        } else if (!CFG.getMetProv(provinceID)) {
            float[] c = CFG.settingsGD.COLOR_DISCOVERY_FLOAT;
            colorPixmap.setColor(c[0], c[1], c[2], c[3]);
        } else if (p.getWastelandLvl() >= 0) {
            colorPixmap.setColor(p.getWastelandColor(CFG.settingsGD.PROVINCE_ALPHA_WASTELAND));
        } else {
            int civID = p.getCivId();
            Civilization civ = CFG.core.getCiv(civID);
            float alpha = (civID == 0) ? 0.039215688f : (float)CFG.settingsGD.PROV_ALPHA / 255.0f;
            
            // Handle animation if needed, but for now just use current owner color
            colorPixmap.setColor(civ.colorFloat[0], civ.colorFloat[1], civ.colorFloat[2], alpha);
        }
        colorPixmap.drawPixel(provinceID, 0);
    }
    
    public static void updateAllStates() {
        if (!initialized) return;
        for (int i = 0; i < CFG.core.getProvinSize(); i++) {
            updateProvinceColor(i);
        }
        colorTexture.draw(colorPixmap, 0, 0);
    }
    
    public static void updateTexture() {
        if (initialized) colorTexture.draw(colorPixmap, 0, 0);
    }

    public static void draw(SpriteBatch oSB) {
        if (!initialized) return;
        
        // Finalize SpriteBatch if active
        boolean wasDrawing = oSB.isDrawing();
        if (wasDrawing) oSB.end();
        
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        
        shader.begin();
        shader.setUniformMatrix("u_projTrans", oSB.getProjectionMatrix().cpy().mul(oSB.getTransformMatrix()));
        shader.setUniformf("u_translateX", 0);
        shader.setUniformf("u_translateY", -CFG.map.getMpC().getPY());
        shader.setUniformi("u_texture", 0);
        shader.setUniformi("u_colors", 1);
        shader.setUniformf("u_colorStep", 1.0f / colorTexture.getWidth());
        
        ProvinceAtlas.getTexture().bind(0);
        colorTexture.bind(1);
        
        mesh.render(shader, GL20.GL_TRIANGLES);
        
        if (CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) {
            shader.setUniformf("u_translateX", -CFG.map.getMpB().getWidthM());
            mesh.render(shader, GL20.GL_TRIANGLES);
            
            shader.setUniformf("u_translateX", CFG.map.getMpB().getWidthM());
            mesh.render(shader, GL20.GL_TRIANGLES);
        }
        
        shader.end();
        
        if (wasDrawing) oSB.begin();
    }

    public static void dispose() {
        if (mesh != null) mesh.dispose();
        if (shader != null) shader.dispose();
        if (colorTexture != null) colorTexture.dispose();
        if (colorPixmap != null) colorPixmap.dispose();
        initialized = false;
    }
}
