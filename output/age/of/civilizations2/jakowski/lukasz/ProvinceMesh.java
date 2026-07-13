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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProvinceMesh {
    private static class TexturePageMesh {
        Mesh mesh;
        Texture texture;
        int vertexCount;
        int indexCount;
    }
    private static List<TexturePageMesh> pageMeshes = new ArrayList<TexturePageMesh>();
    private static ShaderProgram shader;
    private static Texture colorTexture;
    private static Pixmap colorPixmap;
    private static boolean initialized = false;
    private static boolean renderAvailable = false;
    
    private static final int VERTICES_PER_PROVINCE = 4;
    private static final int INDICES_PER_PROVINCE = 6;
    private static final int COMPONENTS_PER_VERTEX = 5;
    private static final int VERTEX_LIMIT = 32767;
    public static boolean needsUpdate = true;
    private static int totalProvincesRendered = 0;
    private static int logFrameCounter = 0;
    private static long perfDrawTotalNs = 0;
    private static int perfDrawCount = 0;
    private static long perfUpdateTotalNs = 0;
    private static int perfUpdateCount = 0;
    private static Texture flagTexture;
    private static Pixmap flagPixmap;
    private static float lastDiscoveryFade = -1f;
    private static boolean[] dirtyFlags;
    private static int dirtyCount;
    private static int dirtyArraySize;
    private static final Matrix4 combinedMatrix = new Matrix4();

    public static void init() {
        long t0 = System.nanoTime();
        if (initialized) dispose();
        
        int numProvinces = CFG.core.getProvinSize();
        if (numProvinces <= 0) {
            Gdx.app.log("ProvinceMesh", "init skipped: no provinces");
            return;
        }
        if (numProvinces * VERTICES_PER_PROVINCE > VERTEX_LIMIT || !ProvinceAtlas.usesSingleTexture()) {
            buildMultiPageMeshes();
        } else {
            buildSingleMesh();
        }
        long dtMs = (System.nanoTime() - t0) / 1000000L;
        Gdx.app.log("ProvinceMesh", "[PERF] init completed in " + dtMs + "ms provinces=" + numProvinces + " rendered=" + totalProvincesRendered + " pages=" + pageMeshes.size());
    }

    private static void buildSingleMesh() {
        int numProvinces = CFG.core.getProvinSize();
        TexturePageMesh tpm = new TexturePageMesh();
        tpm.mesh = new Mesh(true, numProvinces * VERTICES_PER_PROVINCE, numProvinces * INDICES_PER_PROVINCE,
                new VertexAttribute(VertexAttributes.Usage.Position, 2, "a_position"),
                new VertexAttribute(VertexAttributes.Usage.TextureCoordinates, 2, "a_texCoord"),
                new VertexAttribute(VertexAttributes.Usage.Generic, 1, "a_provinceID"));
        tpm.texture = ProvinceAtlas.getTexture();
        float[] vertices = new float[numProvinces * VERTICES_PER_PROVINCE * COMPONENTS_PER_VERTEX];
        short[] indices = new short[numProvinces * INDICES_PER_PROVINCE];
        int validCount = buildVertexData(vertices, indices, 0, numProvinces);
        if (validCount > 0) {
            tpm.mesh.setVertices(vertices, 0, validCount * VERTICES_PER_PROVINCE * COMPONENTS_PER_VERTEX);
            tpm.mesh.setIndices(indices, 0, validCount * INDICES_PER_PROVINCE);
            tpm.vertexCount = validCount * VERTICES_PER_PROVINCE;
            tpm.indexCount = validCount * INDICES_PER_PROVINCE;
            pageMeshes.add(tpm);
            totalProvincesRendered = validCount;
        }
        if (pageMeshes.size() > 0) {
            initShaderAndColors();
        }
    }

    private static void buildMultiPageMeshes() {
        Map<Texture, List<Integer>> textureToProvinces = new HashMap<Texture, List<Integer>>();
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            TextureRegion region = ProvinceAtlas.getRegion(i);
            if (region == null || CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0) continue;
            Texture tex = region.getTexture();
            List<Integer> list = textureToProvinces.get(tex);
            if (list == null) {
                list = new ArrayList<Integer>();
                textureToProvinces.put(tex, list);
            }
            list.add(i);
        }
        for (Map.Entry<Texture, List<Integer>> entry : textureToProvinces.entrySet()) {
            List<Integer> provinceIDs = entry.getValue();
            int count = provinceIDs.size();
            TexturePageMesh tpm = new TexturePageMesh();
            tpm.texture = entry.getKey();
            int vertexCapacity = count * VERTICES_PER_PROVINCE;
            int indexCapacity = count * INDICES_PER_PROVINCE;
            tpm.mesh = new Mesh(true, vertexCapacity, indexCapacity,
                    new VertexAttribute(VertexAttributes.Usage.Position, 2, "a_position"),
                    new VertexAttribute(VertexAttributes.Usage.TextureCoordinates, 2, "a_texCoord"),
                    new VertexAttribute(VertexAttributes.Usage.Generic, 1, "a_provinceID"));
            float[] vertices = new float[vertexCapacity * COMPONENTS_PER_VERTEX];
            short[] indices = new short[indexCapacity];
            int localIdx = 0;
            int vi = 0;
            int ii = 0;
            for (int pi = 0; pi < count; ++pi) {
                int provinceID = provinceIDs.get(pi);
                Province p = CFG.core.getProv(provinceID);
                TextureRegion region = ProvinceAtlas.getRegion(provinceID);
                if (region == null) continue;
                float x1 = p.getMiX2();
                float y1 = -(p.getMiY4() + (int)(region.getRegionHeight() * CFG.map.getMpB().getMapExtraScale()));
                float x2 = x1 + (int)(region.getRegionWidth() * CFG.map.getMpB().getMapExtraScale());
                float y2 = -p.getMiY4();
                int vOff = localIdx * VERTICES_PER_PROVINCE * COMPONENTS_PER_VERTEX;
                vertices[vOff] = x1;
                vertices[vOff + 1] = -(p.getMiY4() + (int)(region.getRegionHeight() * CFG.map.getMpB().getMapExtraScale()));
                vertices[vOff + 2] = region.getU();
                vertices[vOff + 3] = region.getV2();
                vertices[vOff + 4] = provinceID;
                vertices[vOff + 5] = x1;
                vertices[vOff + 6] = -p.getMiY4();
                vertices[vOff + 7] = region.getU();
                vertices[vOff + 8] = region.getV();
                vertices[vOff + 9] = provinceID;
                vertices[vOff + 10] = x2;
                vertices[vOff + 11] = -p.getMiY4();
                vertices[vOff + 12] = region.getU2();
                vertices[vOff + 13] = region.getV();
                vertices[vOff + 14] = provinceID;
                vertices[vOff + 15] = x2;
                vertices[vOff + 16] = -(p.getMiY4() + (int)(region.getRegionHeight() * CFG.map.getMpB().getMapExtraScale()));
                vertices[vOff + 17] = region.getU2();
                vertices[vOff + 18] = region.getV2();
                vertices[vOff + 19] = provinceID;
                int iOff = localIdx * INDICES_PER_PROVINCE;
                indices[iOff] = (short)(localIdx * 4);
                indices[iOff + 1] = (short)(localIdx * 4 + 1);
                indices[iOff + 2] = (short)(localIdx * 4 + 2);
                indices[iOff + 3] = (short)(localIdx * 4);
                indices[iOff + 4] = (short)(localIdx * 4 + 2);
                indices[iOff + 5] = (short)(localIdx * 4 + 3);
                ++localIdx;
            }
            if (localIdx > 0) {
                tpm.mesh.setVertices(vertices, 0, localIdx * VERTICES_PER_PROVINCE * COMPONENTS_PER_VERTEX);
                tpm.mesh.setIndices(indices, 0, localIdx * INDICES_PER_PROVINCE);
                tpm.vertexCount = localIdx * VERTICES_PER_PROVINCE;
                tpm.indexCount = localIdx * INDICES_PER_PROVINCE;
                pageMeshes.add(tpm);
                totalProvincesRendered += localIdx;
            }
        }
        if (pageMeshes.size() > 0) {
            initShaderAndColors();
            Gdx.app.log("ProvinceMesh", "Multi-page meshes created pages=" + pageMeshes.size() + " provinces=" + totalProvincesRendered);
        }
    }

    private static int buildVertexData(float[] vertices, short[] indices, int startProvince, int endProvince) {
        int localIdx = 0;
        int numProvinces = CFG.core.getProvinSize();
        for (int i = startProvince; i < endProvince && i < numProvinces; ++i) {
            Province p = CFG.core.getProv(i);
            TextureRegion region = ProvinceAtlas.getRegion(i);
            if (region == null || p.getSeaProv() || p.getWastelandLvl() >= 0) continue;
            float x1 = p.getMiX2();
            float y1 = -(p.getMiY4() + (int)(region.getRegionHeight() * CFG.map.getMpB().getMapExtraScale()));
            float x2 = x1 + (int)(region.getRegionWidth() * CFG.map.getMpB().getMapExtraScale());
            float y2 = -p.getMiY4();
            int vOff = localIdx * VERTICES_PER_PROVINCE * COMPONENTS_PER_VERTEX;
            vertices[vOff] = p.getMiX2();
            vertices[vOff + 1] = -(p.getMiY4() + (int)(region.getRegionHeight() * CFG.map.getMpB().getMapExtraScale()));
            vertices[vOff + 2] = region.getU();
            vertices[vOff + 3] = region.getV2();
            vertices[vOff + 4] = i;
            vertices[vOff + 5] = p.getMiX2();
            vertices[vOff + 6] = -p.getMiY4();
            vertices[vOff + 7] = region.getU();
            vertices[vOff + 8] = region.getV();
            vertices[vOff + 9] = i;
            vertices[vOff + 10] = p.getMiX2() + (int)(region.getRegionWidth() * CFG.map.getMpB().getMapExtraScale());
            vertices[vOff + 11] = -p.getMiY4();
            vertices[vOff + 12] = region.getU2();
            vertices[vOff + 13] = region.getV();
            vertices[vOff + 14] = i;
            vertices[vOff + 15] = p.getMiX2() + (int)(region.getRegionWidth() * CFG.map.getMpB().getMapExtraScale());
            vertices[vOff + 16] = -(p.getMiY4() + (int)(region.getRegionHeight() * CFG.map.getMpB().getMapExtraScale()));
            vertices[vOff + 17] = region.getU2();
            vertices[vOff + 18] = region.getV2();
            vertices[vOff + 19] = i;
            int iOff = localIdx * INDICES_PER_PROVINCE;
            indices[iOff] = (short)(localIdx * 4);
            indices[iOff + 1] = (short)(localIdx * 4 + 1);
            indices[iOff + 2] = (short)(localIdx * 4 + 2);
            indices[iOff + 3] = (short)(localIdx * 4);
            indices[iOff + 4] = (short)(localIdx * 4 + 2);
            indices[iOff + 5] = (short)(localIdx * 4 + 3);
            ++localIdx;
        }
        return localIdx;
    }

    private static void initShaderAndColors() {
        int numProvinces = CFG.core.getProvinSize();
        int texWidth = getNextPowerOfTwo(numProvinces);
        
        colorPixmap = new Pixmap(texWidth, 1, Pixmap.Format.RGBA8888);
        colorTexture = new Texture(colorPixmap);
        colorTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        
        flagPixmap = new Pixmap(texWidth, 1, Pixmap.Format.Alpha);
        flagTexture = new Texture(flagPixmap);
        flagTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        String vertexShader = "attribute vec2 a_position;\n" +
                              "attribute vec2 a_texCoord;\n" +
                              "attribute float a_provinceID;\n" +
                              "uniform mat4 u_projTrans;\n" +
                              "uniform float u_translateX;\n" +
                              "uniform float u_translateY;\n" +
                              "varying highp vec2 v_texCoord;\n" +
                              "varying highp float v_provinceID;\n" +
                              "void main() {\n" +
                              "    v_texCoord = a_texCoord;\n" +
                              "    v_provinceID = a_provinceID;\n" +
                              "    gl_Position = u_projTrans * vec4(a_position.x + u_translateX, a_position.y + u_translateY, 0, 1);\n" +
                              "}";
        
        String fragmentShader = "#ifdef GL_ES\n" +
                                "#ifdef GL_FRAGMENT_PRECISION_HIGH\n" +
                                "precision highp float;\n" +
                                "#else\n" +
                                "precision mediump float;\n" +
                                "#endif\n" +
                                "#endif\n" +
                                "varying highp vec2 v_texCoord;\n" +
                                "varying highp float v_provinceID;\n" +
                                "uniform sampler2D u_texture;\n" +
                                "uniform sampler2D u_colors;\n" +
                                "uniform sampler2D u_flags;\n" +
                                "uniform highp float u_colorStep;\n" +
                                "uniform float u_discoveryFade;\n" +
                                "void main() {\n" +
                                "    highp float provinceSlot = floor(v_provinceID + 0.5);\n" +
                                "    highp vec2 colorUV = vec2((provinceSlot + 0.5) * u_colorStep, 0.5);\n" +
                                "    vec4 mask = texture2D(u_texture, v_texCoord);\n" +
                                "    vec4 provColor = texture2D(u_colors, colorUV);\n" +
                                "    float flag = texture2D(u_flags, colorUV).a;\n" +
                                "    float finalAlpha = provColor.a;\n" +
                                "    if (flag > 0.5) {\n" +
                                "        finalAlpha = provColor.a * u_discoveryFade;\n" +
                                "    }\n" +
                                "    gl_FragColor = vec4(provColor.rgb, finalAlpha * mask.a);\n" +
                                "}";

        shader = new ShaderProgram(vertexShader, fragmentShader);
        if (!shader.isCompiled()) {
            Gdx.app.log("ProvinceMesh", "Shader compilation failed: " + shader.getLog());
            renderAvailable = false;
        } else {
            Gdx.app.log("ProvinceMesh", "Shader compiled successfully. provinces=" + numProvinces + " colorTexWidth=" + texWidth);
            renderAvailable = true;
        }
        initialized = true;
        dirtyArraySize = numProvinces;
        dirtyFlags = new boolean[numProvinces];
        java.util.Arrays.fill(dirtyFlags, true);
        dirtyCount = numProvinces;
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

    public static void markDirty(int provinceID) {
        if (!initialized) return;
        if (provinceID >= 0 && provinceID < dirtyArraySize && !dirtyFlags[provinceID]) {
            dirtyFlags[provinceID] = true;
            dirtyCount++;
            needsUpdate = true;
        }
    }

    public static void markAllDirty() {
        if (!initialized) return;
        if (dirtyCount == dirtyArraySize) return;
        java.util.Arrays.fill(dirtyFlags, true);
        dirtyCount = dirtyArraySize;
        needsUpdate = true;
    }

    public static void updateProvinceColor(int provinceID) {
        if (!initialized) return;
        if (provinceID < 0 || provinceID >= colorPixmap.getWidth()) {
            Gdx.app.log("ProvinceMesh", "WARN: provinceID=" + provinceID + " out of colorPixmap bounds width=" + colorPixmap.getWidth());
            return;
        }
        Province p = CFG.core.getProv(provinceID);
        
        if (p.getSeaProv() || p.getWastelandLvl() >= 0) {
            colorPixmap.setColor(0, 0, 0, 0);
            flagPixmap.setColor(0, 0, 0, 0);
        } else if (CFG.FOG_OF_WAR == 2 && !CFG.getMetProv(provinceID)) {
            float[] c = CFG.settingsGD.COLOR_DISCOVERY_FLOAT;
            colorPixmap.setColor(c[0], c[1], c[2], CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA);
            flagPixmap.setColor(1, 1, 1, 1);
        } else {
            int civID = p.getCivId();
            Civilization civ = CFG.core.getCiv(civID);
            float alpha = (civID == 0) ? 0.039215688f : (float)CFG.settingsGD.PROV_ALPHA / 255.0f;
            if (civ == null) {
                colorPixmap.setColor(1, 0, 1, alpha);
            } else {
                colorPixmap.setColor((float)civ.getR() / 255.0f, (float)civ.getG() / 255.0f, (float)civ.getB() / 255.0f, alpha);
            }
            flagPixmap.setColor(0, 0, 0, 0);
        }
        colorPixmap.drawPixel(provinceID, 0);
        flagPixmap.drawPixel(provinceID, 0);
    }
    
    public static void updateAllStates() {
        if (!initialized || !needsUpdate) return;
        needsUpdate = false;
        long t0 = System.nanoTime();
        if (dirtyCount > 0) {
            int numProv = CFG.core.getProvinSize();
            int lim = Math.min(numProv, dirtyArraySize);
            for (int i = 0; i < lim; i++) {
                if (dirtyFlags[i]) {
                    dirtyFlags[i] = false;
                    updateProvinceColor(i);
                }
            }
            dirtyCount = 0;
            colorTexture.draw(colorPixmap, 0, 0);
            flagTexture.draw(flagPixmap, 0, 0);
        }
        long dtNs = System.nanoTime() - t0;
        perfUpdateTotalNs += dtNs;
        perfUpdateCount++;
    }
    
    public static boolean isInitialized() {
        return initialized;
    }

    public static boolean canRender() {
        return initialized && renderAvailable && shader != null && colorTexture != null && flagTexture != null && pageMeshes.size() > 0;
    }

    public static void updateTexture() {
        if (initialized) colorTexture.draw(colorPixmap, 0, 0);
    }

    private static float getDiscoveryFade() {
        if (CFG.startTheGameData == null || CFG.startTheGameData.getIsDone()) return 1.0f;
        int provAlpha = CFG.startTheGameData.getProvincesAlpha();
        if (provAlpha <= 0) return 0.0f;
        return (float)provAlpha / (float)CFG.settingsGD.PROV_ALPHA;
    }

    public static void draw(SpriteBatch oSB) {
        if (!canRender()) return;
        long drawStart = System.nanoTime();
        
        updateAllStates();
        
        boolean wasDrawing = oSB.isDrawing();
        if (wasDrawing) oSB.end();
        boolean shaderBegun = false;
        try {
            Gdx.gl.glEnable(GL20.GL_BLEND);
            Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
            
            shader.begin();
            shaderBegun = true;
            combinedMatrix.set(oSB.getProjectionMatrix()).mul(oSB.getTransformMatrix());
            shader.setUniformMatrix("u_projTrans", combinedMatrix);
            shader.setUniformf("u_translateY", -CFG.map.getMpC().getPY());
            shader.setUniformi("u_colors", 1);
            shader.setUniformi("u_flags", 2);
            shader.setUniformf("u_colorStep", 1.0f / colorTexture.getWidth());
            shader.setUniformf("u_discoveryFade", getDiscoveryFade());
            
            colorTexture.bind(1);
            flagTexture.bind(2);
            
            boolean worldMap = CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN());
            int pX = CFG.map.getMpC().getPX();
            int pY = CFG.map.getMpC().getPY();
            if (worldMap) {
                float widthM = CFG.map.getMpB().getWidthM();
                int totalIndices = 0;
                for (int p = 0; p < pageMeshes.size(); ++p) {
                    TexturePageMesh tpm = pageMeshes.get(p);
                    if (tpm.mesh == null || tpm.indexCount <= 0) continue;
                    tpm.texture.bind(0);
                    shader.setUniformi("u_texture", 0);
                    totalIndices += tpm.indexCount;
                    shader.setUniformf("u_translateX", pX);
                    tpm.mesh.render(shader, GL20.GL_TRIANGLES);
                    shader.setUniformf("u_translateX", pX - widthM);
                    tpm.mesh.render(shader, GL20.GL_TRIANGLES);
                    shader.setUniformf("u_translateX", pX + widthM);
                    tpm.mesh.render(shader, GL20.GL_TRIANGLES);
                }
                logPerfIfNeeded(drawStart, totalIndices, pX, pY);
            } else {
                int totalIndices = 0;
                shader.setUniformf("u_translateX", pX);
                for (int p = 0; p < pageMeshes.size(); ++p) {
                    TexturePageMesh tpm = pageMeshes.get(p);
                    if (tpm.mesh == null || tpm.indexCount <= 0) continue;
                    tpm.texture.bind(0);
                    shader.setUniformi("u_texture", 0);
                    totalIndices += tpm.indexCount;
                    tpm.mesh.render(shader, GL20.GL_TRIANGLES);
                }
                logPerfIfNeeded(drawStart, totalIndices, pX, pY);
            }
        }
        finally {
            if (shaderBegun) shader.end();
            Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
            if (wasDrawing) oSB.begin();
        }
    }

    private static void logPerfIfNeeded(long drawStart, int totalIndices, int pX, int pY) {
        perfDrawTotalNs += (System.nanoTime() - drawStart);
        perfDrawCount++;
        if (++logFrameCounter % 300 == 0 && CFG.LOG_PERF) {
            float avgDrawMs = (float)(perfDrawTotalNs / Math.max(1, perfDrawCount)) / 1000000.0f;
            float avgUpdateMs = (float)(perfUpdateTotalNs / Math.max(1, perfUpdateCount)) / 1000000.0f;
            Gdx.app.log("ProvinceMesh", "[PERF] avgDraw=" + avgDrawMs + "ms avgColorUpdate=" + avgUpdateMs + "ms pages=" + pageMeshes.size() + " indices=" + totalIndices + " pX=" + pX + " pY=" + pY + " scale=" + CFG.map.getMpS().getCurrSc() + " prov=" + CFG.core.getProvinSize() + " rendered=" + totalProvincesRendered + " canRender=" + canRender());
            perfDrawTotalNs = 0;
            perfDrawCount = 0;
            perfUpdateTotalNs = 0;
            perfUpdateCount = 0;
        }
    }

    public static ShaderProgram getColorShader() {
        return shader;
    }

    public static void dispose() {
        for (int i = 0; i < pageMeshes.size(); ++i) {
            TexturePageMesh tpm = pageMeshes.get(i);
            if (tpm.mesh != null) tpm.mesh.dispose();
        }
        pageMeshes.clear();
        if (shader != null) shader.dispose();
        if (colorTexture != null) colorTexture.dispose();
        if (colorPixmap != null) colorPixmap.dispose();
        if (flagTexture != null) flagTexture.dispose();
        if (flagPixmap != null) flagPixmap.dispose();
        flagPixmap = null;
        flagTexture = null;
        initialized = false;
        renderAvailable = false;
        totalProvincesRendered = 0;
        lastDiscoveryFade = -1f;
        dirtyFlags = null;
        dirtyCount = 0;
        dirtyArraySize = 0;
    }
}
