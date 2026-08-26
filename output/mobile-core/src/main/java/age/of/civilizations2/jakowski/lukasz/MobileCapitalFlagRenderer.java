package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import java.util.ArrayList;
import java.util.List;

public class MobileCapitalFlagRenderer {
    private static boolean initialized = false;
    private static boolean valid = false;

    private static int lastCameraPX = Integer.MIN_VALUE;
    private static int lastCameraPY = Integer.MIN_VALUE;
    private static float lastZoom = -1f;
    private static boolean lastFogOfWar;
    private static long lastOwnershipStamp;

    private static class FlagDrawData {
        int provinceID;
        int civID;
        float screenX;
        float screenY;
        int flagSlot;
    }

    private static final List<FlagDrawData> flagData = new ArrayList<FlagDrawData>(2048);
    private static int flagCount;
    private static float currentScale = 1.0f;

    // Mesh path: ONE draw call for all flags (vs SpriteBatch per-quad)
    private static Mesh flagMesh;
    private static ShaderProgram flagShader;
    private static final int MAX_FLAGS = 2048;
    // 4 verts per flag * 4 floats (x,y,u,v) = 16 floats per flag
    private static float[] vertices = new float[MAX_FLAGS * 16];
    private static short[] indices = new short[MAX_FLAGS * 6];
    private static boolean meshReady = false;

    private static final String VERTEX_SHADER = "attribute vec4 a_position;\n" +
            "attribute vec2 a_texCoord0;\n" +
            "uniform mat4 u_projTrans;\n" +
            "varying vec2 v_texCoords;\n" +
            "void main() {\n" +
            "  v_texCoords = a_texCoord0;\n" +
            "  gl_Position = u_projTrans * a_position;\n" +
            "}";

    private static final String FRAGMENT_SHADER = "#ifdef GL_ES\n" +
            "precision mediump float;\n" +
            "#endif\n" +
            "varying vec2 v_texCoords;\n" +
            "uniform sampler2D u_texture;\n" +
            "void main() {\n" +
            "  gl_FragColor = texture2D(u_texture, v_texCoords);\n" +
            "}";

    private static void ensurePool(int capacity) {
        while (flagData.size() < capacity) flagData.add(new FlagDrawData());
    }

    public static void init() {
        initialized = true;
        ensurePool(MAX_FLAGS);
        invalidate();
        createMesh();
    }

    private static void createMesh() {
        if (meshReady) return;
        try {
            flagMesh = new Mesh(false, MAX_FLAGS * 4, MAX_FLAGS * 6,
                    new VertexAttribute(VertexAttributes.Usage.Position, 2, "a_position"),
                    new VertexAttribute(VertexAttributes.Usage.TextureCoordinates, 2, "a_texCoord0"));
            // precompute indices
            for (int i = 0; i < MAX_FLAGS; i++) {
                int v = i * 4;
                int idx = i * 6;
                indices[idx] = (short) v;
                indices[idx + 1] = (short) (v + 1);
                indices[idx + 2] = (short) (v + 2);
                indices[idx + 3] = (short) (v + 2);
                indices[idx + 4] = (short) (v + 3);
                indices[idx + 5] = (short) v;
            }
            flagMesh.setIndices(indices);
            ShaderProgram.pedantic = false;
            flagShader = new ShaderProgram(VERTEX_SHADER, FRAGMENT_SHADER);
            if (!flagShader.isCompiled()) {
                Gdx.app.log("MobileFlag", "Shader compile failed: " + flagShader.getLog());
                flagShader = null;
            }
            meshReady = true;
        } catch (Throwable t) {
            Gdx.app.log("MobileFlag", "createMesh failed: " + t.getMessage());
        }
    }

    public static void dispose() {
        initialized = false;
        valid = false;
        flagCount = 0;
        if (flagMesh != null) try { flagMesh.dispose(); } catch (Throwable ignore) {}
        flagMesh = null;
        if (flagShader != null) try { flagShader.dispose(); } catch (Throwable ignore) {}
        flagShader = null;
        meshReady = false;
    }

    public static void invalidate() {
        valid = false;
        lastCameraPX = Integer.MIN_VALUE;
        lastCameraPY = Integer.MIN_VALUE;
        lastZoom = -1f;
    }

    private static boolean needsRebuild() {
        if (!initialized) return false;
        if (!valid) return true;
        if (CFG.map == null || CFG.core == null) return false;
        int px = CFG.map.getMpC().getPX();
        int py = CFG.map.getMpC().getPY();
        float zoom = CFG.map.getMpS().getCurrSc();
        if (px != lastCameraPX || py != lastCameraPY) return true;
        if (Float.compare(zoom, lastZoom) != 0) return true;
        if ((CFG.FOG_OF_WAR == 2) != lastFogOfWar) return true;
        long ownership = VisibleProvinceCache.getOwnershipStamp();
        if (ownership != lastOwnershipStamp) return true;
        return false;
    }

    public static void rebuildIfNeeded() {
        if (!needsRebuild()) return;
        rebuild();
    }

    private static void rebuild() {
        if (!initialized || CFG.core == null || CFG.map == null) return;
        flagCount = 0;
        int px = CFG.map.getMpC().getPX();
        int py = CFG.map.getMpC().getPY();
        float zoom = CFG.map.getMpS().getCurrSc();
        currentScale = zoom < 1.0f ? zoom : 1.0f;
        if (zoom < 0.05f) { valid = true; flagCount = 0; updateCacheKeys(px, py, zoom); return; }

        int visibleProvCount = VisibleProvinceCache.getVisibleCapitalCount();
        List<Integer> capitals = VisibleProvinceCache.getVisibleCapitals();
        if (visibleProvCount == 0 && capitals.size() == 0 && CFG.core.getCivsSize() > 0) {
            ensurePool(CFG.core.getCivsSize());
            for (int civID = 1; civID < CFG.core.getCivsSize() && flagCount < MAX_FLAGS; civID++) {
                Civilization civ = CFG.core.getCiv(civID);
                if (civ == null) continue;
                int provID = civ.getCapitalProvID();
                if (provID < 0 || provID >= CFG.core.getProvinSize()) continue;
                if (CFG.FOG_OF_WAR == 2 && !CFG.getMetProv(provID)) continue;
                Province p = CFG.core.getProv(provID);
                if (p == null) continue;
                if (p.getCivId() != civID) continue;
                int flagSlot = FlagAtlas.getFlagSlot(civID);
                if (flagSlot < 0) flagSlot = FlagAtlas.ensureCivFlag(civID);
                if (flagSlot < 0) continue;
                FlagDrawData data = flagData.get(flagCount);
                data.provinceID = provID;
                data.civID = civID;
                data.screenX = p.getCeX() + p.getShPX() + p.getTranslateProvPosX() + px;
                data.screenY = p.getCeY() + p.getShPY() + py;
                data.flagSlot = flagSlot;
                flagCount++;
            }
            updateCacheKeys(px, py, zoom);
            valid = true;
            return;
        }
        ensurePool(visibleProvCount + 16);
        for (int i = 0; i < visibleProvCount && i < capitals.size() && flagCount < MAX_FLAGS; i++) {
            int provID = capitals.get(i);
            if (provID < 0 || provID >= CFG.core.getProvinSize()) continue;
            Province p = CFG.core.getProv(provID);
            if (p == null) continue;
            int civID = p.getCivId();
            if (civID <= 0 || civID >= CFG.core.getCivsSize()) continue;
            if (CFG.FOG_OF_WAR == 2 && !CFG.getMetProv(provID)) continue;
            Civilization civ = CFG.core.getCiv(civID);
            if (civ == null) continue;
            if (provID != civ.getCapitalProvID()) continue;
            int flagSlot = FlagAtlas.getFlagSlot(civID);
            if (flagSlot < 0) {
                flagSlot = FlagAtlas.ensureCivFlag(civID);
                if (flagSlot < 0) continue;
            }
            FlagDrawData data = flagData.get(flagCount);
            data.provinceID = provID;
            data.civID = civID;
            data.screenX = p.getCeX() + p.getShPX() + p.getTranslateProvPosX() + px;
            data.screenY = p.getCeY() + p.getShPY() + py;
            data.flagSlot = flagSlot;
            flagCount++;
        }
        updateCacheKeys(px, py, zoom);
        valid = true;
    }

    private static void updateCacheKeys(int px, int py, float zoom) {
        lastCameraPX = px;
        lastCameraPY = py;
        lastZoom = zoom;
        lastFogOfWar = (CFG.FOG_OF_WAR == 2);
        lastOwnershipStamp = VisibleProvinceCache.getOwnershipStamp();
    }

    // Fast path: ONE mesh draw for all flags (no SpriteBatch per-quad, no glBufferData per flag)
    public static void render(SpriteBatch oSB) {
        if (!initialized || CFG.map == null) return;
        rebuildIfNeeded();
        if (flagCount == 0) return;
        FlagAtlas.flush();
        Texture atlas = FlagAtlas.getAtlasTexture();
        if (atlas == null) return;
        if (!meshReady || flagMesh == null || flagShader == null) {
            // Fallback to old SpriteBatch path if mesh not ready (low-end GLES)
            fallbackSpriteBatch(oSB);
            return;
        }

        int flagW = (int)(CFG.CIV_FLAG_WIDTH * currentScale);
        int flagH = (int)(CFG.CIV_FLAG_HEIGHT * currentScale);
        if (flagW < 2 || flagH < 1) return;

        int atlasSize = FlagAtlas.getAtlasSize();
        int flagsPerRow = FlagAtlas.getFlagsPerRow();
        float invAtlasSize = 1.0f / atlasSize;
        int flagTexSize = FlagAtlas.getFlagSize();

        int vertCount = 0;
        int idx = 0;
        for (int i = 0; i < flagCount; i++) {
            FlagDrawData data = flagData.get(i);
            float drawX = data.screenX - flagW / 2f;
            float drawY = data.screenY - flagH / 2f;
            if (drawX + flagW < 0 || drawX > CFG.GAMEWIDTH) continue;
            if (drawY + flagH < 0 || drawY > CFG.GAMEHEIGHT) continue;
            int slot = data.flagSlot;
            int sx = (slot % flagsPerRow) * flagTexSize;
            int sy = (slot / flagsPerRow) * flagTexSize;
            float u = sx * invAtlasSize;
            float v = (sy + flagTexSize) * invAtlasSize;
            float u2 = (sx + flagTexSize) * invAtlasSize;
            float v2 = sy * invAtlasSize;

            float x = drawX;
            float y = drawY;
            float x2 = drawX + flagW;
            float y2 = drawY + flagH;
            // 4 vertices: bottom-left, top-left, top-right, bottom-right
            // bottom-left
            vertices[idx++] = x; vertices[idx++] = y; vertices[idx++] = u; vertices[idx++] = v;
            // top-left
            vertices[idx++] = x; vertices[idx++] = y2; vertices[idx++] = u; vertices[idx++] = v2;
            // top-right
            vertices[idx++] = x2; vertices[idx++] = y2; vertices[idx++] = u2; vertices[idx++] = v2;
            // bottom-right
            vertices[idx++] = x2; vertices[idx++] = y; vertices[idx++] = u2; vertices[idx++] = v;
            vertCount++;
        }
        if (vertCount == 0) return;

        // Flush SpriteBatch before custom GL
        try { oSB.flush(); } catch (Throwable ignore) {}

        // GL state
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        atlas.bind(0);
        flagShader.bind();
        flagShader.setUniformMatrix("u_projTrans", oSB.getProjectionMatrix());
        flagShader.setUniformi("u_texture", 0);

        flagMesh.setVertices(vertices, 0, vertCount * 16);
        // indices already set, but we need to render only vertCount*6 indices
        flagMesh.getIndicesBuffer().position(0);
        flagMesh.getIndicesBuffer().limit(vertCount * 6);
        flagMesh.render(flagShader, GL20.GL_TRIANGLES, 0, vertCount * 6);
    }

    private static void fallbackSpriteBatch(SpriteBatch oSB) {
        Texture atlas = FlagAtlas.getAtlasTexture();
        if (atlas == null) return;
        int flagW = (int)(CFG.CIV_FLAG_WIDTH * currentScale);
        int flagH = (int)(CFG.CIV_FLAG_HEIGHT * currentScale);
        if (flagW < 2 || flagH < 1) return;
        int atlasSize = FlagAtlas.getAtlasSize();
        int flagsPerRow = FlagAtlas.getFlagsPerRow();
        float invAtlasSize = 1.0f / atlasSize;
        int flagTexSize = FlagAtlas.getFlagSize();
        for (int i = 0; i < flagCount; i++) {
            FlagDrawData data = flagData.get(i);
            float drawX = data.screenX - flagW / 2f;
            float drawY = data.screenY - flagH / 2f;
            if (drawX + flagW < 0 || drawX > CFG.GAMEWIDTH) continue;
            if (drawY + flagH < 0 || drawY > CFG.GAMEHEIGHT) continue;
            int slot = data.flagSlot;
            int sx = (slot % flagsPerRow) * flagTexSize;
            int sy = (slot / flagsPerRow) * flagTexSize;
            float u = sx * invAtlasSize;
            float v = (sy + flagTexSize) * invAtlasSize;
            float u2 = (sx + flagTexSize) * invAtlasSize;
            float v2 = sy * invAtlasSize;
            oSB.draw(atlas, drawX, drawY, flagW, flagH, u, v, u2, v2);
        }
    }

    // Keep old name for compatibility
    public static void drawFlags(SpriteBatch oSB) { render(oSB); }

    public static int getFlagCount() { return flagCount; }
    public static boolean isInitialized() { return initialized; }
}
