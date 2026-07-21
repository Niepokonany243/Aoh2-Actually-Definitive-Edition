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
import java.nio.ByteBuffer;
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
    private static final int ANDROID_DIRTY_BATCH = 2048;
    public static boolean needsUpdate = true;
    private static int totalProvincesRendered = 0;
    private static int logFrameCounter = 0;
    private static long perfDrawTotalNs = 0;
    private static int perfDrawCount = 0;
    private static long perfUpdateTotalNs = 0;
    private static int perfUpdateCount = 0;
    private static Texture flagTexture;
    private static Pixmap flagPixmap;
    private static Texture whiteTexture;
    private static float lastDiscoveryFade = -1f;
    private static boolean[] dirtyFlags;
    private static int[] dirtyList;
    private static int dirtyListSize;
    private static int dirtyCount;
    private static int dirtyArraySize;
    private static int dirtyMin = Integer.MAX_VALUE;
    private static int dirtyMax = -1;
    private static int dirtySweepCursor = -1;
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
            Province p = CFG.core.getProv(i);
            if (p.getSeaProv()) continue;
            TextureRegion region = ProvinceAtlas.getRegion(i);
            Texture tex = region != null ? region.getTexture() : whiteTexture;
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
                float x1, y1, x2, y2, u, v, u2, v2;
                if (region != null) {
                    int w = (int)(region.getRegionWidth() * CFG.map.getMpB().getMapExtraScale());
                    int h = (int)(region.getRegionHeight() * CFG.map.getMpB().getMapExtraScale());
                    x1 = p.getMiX2();
                    y1 = -(p.getMiY4() + h);
                    x2 = x1 + w;
                    y2 = -p.getMiY4();
                    u = region.getU(); v = region.getV(); u2 = region.getU2(); v2 = region.getV2();
                } else {
                    x1 = p.getMiX2();
                    x2 = p.getMaX7();
                    y1 = -p.getMaY6();
                    y2 = -p.getMiY4();
                    u = 0; v = 0; u2 = 1; v2 = 1;
                }
                int vOff = localIdx * VERTICES_PER_PROVINCE * COMPONENTS_PER_VERTEX;
                vertices[vOff] = x1;
                vertices[vOff + 1] = y1;
                vertices[vOff + 2] = u;
                vertices[vOff + 3] = v2;
                vertices[vOff + 4] = provinceID;
                vertices[vOff + 5] = x1;
                vertices[vOff + 6] = y2;
                vertices[vOff + 7] = u;
                vertices[vOff + 8] = v;
                vertices[vOff + 9] = provinceID;
                vertices[vOff + 10] = x2;
                vertices[vOff + 11] = y2;
                vertices[vOff + 12] = u2;
                vertices[vOff + 13] = v;
                vertices[vOff + 14] = provinceID;
                vertices[vOff + 15] = x2;
                vertices[vOff + 16] = y1;
                vertices[vOff + 17] = u2;
                vertices[vOff + 18] = v2;
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
            if (p.getSeaProv()) continue;
            TextureRegion region = ProvinceAtlas.getRegion(i);
            float x1, y1, x2, y2, u, v, u2, v2;
            if (region != null) {
                int w = (int)(region.getRegionWidth() * CFG.map.getMpB().getMapExtraScale());
                int h = (int)(region.getRegionHeight() * CFG.map.getMpB().getMapExtraScale());
                x1 = p.getMiX2();
                y1 = -(p.getMiY4() + h);
                x2 = x1 + w;
                y2 = -p.getMiY4();
                u = region.getU(); v = region.getV(); u2 = region.getU2(); v2 = region.getV2();
            } else {
                x1 = p.getMiX2();
                x2 = p.getMaX7();
                y1 = -p.getMaY6();
                y2 = -p.getMiY4();
                u = 0; v = 0; u2 = 1; v2 = 1;
            }
            int vOff = localIdx * VERTICES_PER_PROVINCE * COMPONENTS_PER_VERTEX;
            vertices[vOff] = x1;
            vertices[vOff + 1] = y1;
            vertices[vOff + 2] = u;
            vertices[vOff + 3] = v2;
            vertices[vOff + 4] = i;
            vertices[vOff + 5] = x1;
            vertices[vOff + 6] = y2;
            vertices[vOff + 7] = u;
            vertices[vOff + 8] = v;
            vertices[vOff + 9] = i;
            vertices[vOff + 10] = x2;
            vertices[vOff + 11] = y2;
            vertices[vOff + 12] = u2;
            vertices[vOff + 13] = v;
            vertices[vOff + 14] = i;
            vertices[vOff + 15] = x2;
            vertices[vOff + 16] = y1;
            vertices[vOff + 17] = u2;
            vertices[vOff + 18] = v2;
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
        int texWidth = numProvinces + 1;
        
        colorPixmap = new Pixmap(texWidth, 1, Pixmap.Format.RGBA8888);
        colorPixmap.setColor(1f, 0f, 1f, 1f);
        colorPixmap.fill();
        colorTexture = new Texture(colorPixmap);
        colorTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        
        flagPixmap = new Pixmap(texWidth, 1, Pixmap.Format.RGBA8888);
        flagTexture = new Texture(flagPixmap);
        flagTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        Pixmap whitePix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        whitePix.setColor(1f, 1f, 1f, 1f);
        whitePix.fill();
        whiteTexture = new Texture(whitePix);
        whitePix.dispose();

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
                                "uniform float u_activeProvinceID;\n" +
                                "void main() {\n" +
                                "    highp float provinceSlot = floor(v_provinceID + 0.5);\n" +
                                "    highp vec2 colorUV = vec2((provinceSlot + 0.5) * u_colorStep, 0.5);\n" +
                                "    vec4 mask = texture2D(u_texture, v_texCoord);\n" +
                                "    vec4 provColor = texture2D(u_colors, colorUV);\n" +
                                "    vec4 flagsData = texture2D(u_flags, colorUV);\n" +
                                "    float wl = flagsData.g * 63.0;\n" +
                                "    float isOccupied = flagsData.b;\n" +
                                "    float finalAlpha = provColor.a;\n" +
                                "    if (flagsData.a > 0.5) {\n" +
                                "        finalAlpha = provColor.a * u_discoveryFade;\n" +
                                "    }\n" +
                                "    if (wl > 0.5) {\n" +
                                "        float wlFactor = wl / 10.0;\n" +
                                "        if (wlFactor > 1.0) wlFactor = 1.0;\n" +
                                "        provColor.rgb *= (1.0 - 0.5 * wlFactor);\n" +
                                "        finalAlpha = provColor.a * 0.6;\n" +
                                "    }\n" +
                                "    if (isOccupied > 0.5) {\n" +
                                "        float stripe = step(0.5, fract(gl_FragCoord.x * 0.025 + gl_FragCoord.y * 0.025));\n" +
                                "        finalAlpha *= mix(0.3, 1.0, stripe);\n" +
                                "    }\n" +
                                "    if (u_activeProvinceID >= 0.0 && abs(provinceSlot - u_activeProvinceID) < 0.5) {\n" +
                                "        provColor.rgb = provColor.rgb * 1.5;\n" +
                                "        finalAlpha = min(finalAlpha * 1.3, 1.0);\n" +
                                "    }\n" +
                                "    gl_FragColor = vec4(provColor.rgb * mask.rgb, finalAlpha * mask.a);\n" +
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
        dirtyList = new int[numProvinces];
        dirtyListSize = 0;
        java.util.Arrays.fill(dirtyFlags, true);
        dirtyCount = numProvinces;
        dirtyMin = 0;
        dirtyMax = numProvinces - 1;
        dirtySweepCursor = -1;
        needsUpdate = true;
        updateAllStates();
    }

    public static synchronized void markDirty(int provinceID) {
        if (!initialized) return;
        if (provinceID >= 0 && provinceID < dirtyArraySize && !dirtyFlags[provinceID]) {
            dirtyFlags[provinceID] = true;
            dirtyList[dirtyListSize++] = provinceID;
            dirtyCount++;
            if (provinceID < dirtyMin) dirtyMin = provinceID;
            if (provinceID > dirtyMax) dirtyMax = provinceID;
            needsUpdate = true;
        }
    }

    public static synchronized void markAllDirty() {
        if (!initialized) return;
        if (dirtyCount == dirtyArraySize) return;
        if (dirtySweepCursor >= 0 && dirtyCount > 0) return;
        java.util.Arrays.fill(dirtyFlags, true);
        dirtyListSize = 0;
        dirtyCount = dirtyArraySize;
        dirtyMin = 0;
        dirtyMax = dirtyArraySize - 1;
        dirtySweepCursor = 0;
        needsUpdate = true;
        VisibleProvinceCache.markOwnershipChanged();
        CapitalFlagRenderer.invalidate();
    }

    public static synchronized void markAllDirtyImmediate() {
        markAllDirtyImmediate(false);
    }

    public static synchronized void markAllDirtyImmediate(boolean force) {
        if (!initialized) return;
        if (!force) {
            if (dirtyCount == dirtyArraySize) return;
            if (dirtySweepCursor >= 0 && dirtyCount > 0) return;
        }
        java.util.Arrays.fill(dirtyFlags, true);
        dirtyListSize = 0;
        dirtyCount = dirtyArraySize;
        dirtyMin = 0;
        dirtyMax = dirtyArraySize - 1;
        dirtySweepCursor = -1;
        needsUpdate = true;
        VisibleProvinceCache.markOwnershipChanged();
        CapitalFlagRenderer.invalidate();
    }

    public static synchronized void markCivDirty(int civID) {
        if (!initialized) return;
        if (CFG.core == null || civID < 0 || civID >= CFG.core.getCivsSize()) {
            markAllDirty();
            return;
        }
        Civilization civ = CFG.core.getCiv(civID);
        if (civ == null) {
            markAllDirty();
            return;
        }
        int numProvs = civ.getNumOfProvs();
        if (numProvs <= 0) return;
        for (int i = 0; i < numProvs; ++i) {
            markDirty(civ.getProvID(i));
        }
    }

    public static void updateProvinceColor(int provinceID) {
        if (!initialized) return;
        if (provinceID < 0 || provinceID >= colorPixmap.getWidth()) return;
        Province p = CFG.core.getProv(provinceID);
        float r, g, b, a, fr = 0, fg = 0, fb = 0, fa = 0;
        
        if (p.getSeaProv()) {
            r = 0; g = 0; b = 0; a = 0;
        } else if (p.getWastelandLvl() >= 0) {
            int wl = p.getWastelandLvl();
            int civID = p.getCivId();
            Civilization civ = CFG.core.getCiv(civID);
            if (civ == null) { r = 1; g = 0; b = 1; a = 0.039f; }
            else { r = (float)civ.getR() / 255.0f; g = (float)civ.getG() / 255.0f; b = (float)civ.getB() / 255.0f; a = (float)CFG.settingsGD.PROV_ALPHA / 255.0f; }
            fr = 0; fg = Math.min(wl, 63) / 63.0f; fb = 0; fa = 0;
        } else if (CFG.FOG_OF_WAR == 2 && !CFG.getMetProv(provinceID)) {
            float[] c = CFG.settingsGD.COLOR_DISCOVERY_FLOAT;
            r = c[0]; g = c[1]; b = c[2];
            a = CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA;
            fr = 1; fg = 1; fb = 1; fa = 1;
        } else if (diplomacyActive && p.getCivId() > 0 && diplomacyPlayerCivID >= 0 && civsAtWarCache != null) {
            int ownerCivID = p.getCivId();
            if (ownerCivID == diplomacyPlayerCivID) {
                r = dipOwnR; g = dipOwnG; b = dipOwnB;
            } else if (ownerCivID >= 0 && ownerCivID < civsAtWarCache.length && civsAtWarCache[ownerCivID]) {
                r = dipWarR; g = dipWarG; b = dipWarB;
            } else if (ownerCivID > 0 && CFG.core.getCiv(ownerCivID).getAlliance() > 0 && CFG.core.getCiv(ownerCivID).getAlliance() == CFG.core.getCiv(diplomacyPlayerCivID).getAlliance()) {
                r = dipAllianceR; g = dipAllianceG; b = dipAllianceB;
            } else {
                r = dipNeutralR; g = dipNeutralG; b = dipNeutralB;
            }
            a = dipAlpha;
        } else {
            int civID = p.getCivId();
            Civilization civ = CFG.core.getCiv(civID);
            a = (civID == 0) ? 0.039215688f : (float)CFG.settingsGD.PROV_ALPHA / 255.0f;
            if (civ == null) {
                r = 1; g = 0; b = 1;
            } else {
                r = (float)civ.getR() / 255.0f;
                g = (float)civ.getG() / 255.0f;
                b = (float)civ.getB() / 255.0f;
            }
            fr = 0; fg = 0;
            fb = (civID != p.getTrueOwnerOfProv() && civID > 0) ? 1.0f : 0.0f;
            fa = 0;
        }
        int off = provinceID * 4;
        ByteBuffer colorBuf = colorPixmap.getPixels();
        colorBuf.put(off, (byte)(r * 255.999f));
        colorBuf.put(off + 1, (byte)(g * 255.999f));
        colorBuf.put(off + 2, (byte)(b * 255.999f));
        colorBuf.put(off + 3, (byte)(a * 255.999f));
        ByteBuffer flagBuf = flagPixmap.getPixels();
        flagBuf.put(off, (byte)(fr * 255.999f));
        flagBuf.put(off + 1, (byte)(fg * 255.999f));
        flagBuf.put(off + 2, (byte)(fb * 255.999f));
        flagBuf.put(off + 3, (byte)(fa * 255.999f));
    }
    
    public static synchronized void updateAllStates() {
        if (!initialized || !needsUpdate) return;
        long t0 = System.nanoTime();
        if (dirtyCount > 0) {
            int numProv = CFG.core.getProvinSize();
            int lim = Math.min(numProv, dirtyArraySize);
            int processed = 0;
            if (dirtyCount == dirtyArraySize) {
                int toProcess = Math.min(lim, ANDROID_DIRTY_BATCH);
                int uploadStart = -1;
                int uploadEnd = -1;
                for (int i = 0; i < toProcess; i++) {
                    if (dirtyFlags[i]) {
                        dirtyFlags[i] = false;
                        updateProvinceColor(i);
                        ++processed;
                        if (uploadStart < 0) uploadStart = i;
                        uploadEnd = i;
                    }
                }
                if (uploadStart >= 0) uploadDirtyTextures(uploadStart, uploadEnd);
                dirtySweepCursor = toProcess >= lim ? -1 : toProcess;
                dirtyListSize = 0;
            } else if (dirtySweepCursor >= 0 || dirtyCount == dirtyArraySize || dirtyListSize == 0) {
                int start = dirtySweepCursor >= 0 ? dirtySweepCursor : 0;
                int end = (dirtySweepCursor >= 0 || dirtyCount == dirtyArraySize) ? Math.min(lim, start + ANDROID_DIRTY_BATCH) : lim;
                int uploadStart = -1;
                int uploadEnd = -1;
                for (int i = start; i < end; i++) {
                    if (dirtyFlags[i]) {
                        dirtyFlags[i] = false;
                        updateProvinceColor(i);
                        ++processed;
                        if (uploadStart < 0) uploadStart = i;
                        uploadEnd = i;
                    }
                }
                if (uploadStart >= 0) {
                    if (start == 0 && end >= lim) {
                        uploadDirtyTextures(0, colorPixmap.getWidth() - 1);
                    } else {
                        uploadDirtyTextures(uploadStart, uploadEnd);
                    }
                }
                dirtySweepCursor = end >= lim ? -1 : end;
            } else {
                java.util.Arrays.sort(dirtyList, 0, dirtyListSize);
                int toProcess = Math.min(dirtyListSize, ANDROID_DIRTY_BATCH);
                int spanStart = -1;
                int spanEnd = -1;
                for (int i = 0; i < toProcess; ++i) {
                    int provinceID = dirtyList[i];
                    if (provinceID < 0 || provinceID >= lim || !dirtyFlags[provinceID]) continue;
                    dirtyFlags[provinceID] = false;
                    updateProvinceColor(provinceID);
                    ++processed;
                    if (spanStart < 0) {
                        spanStart = provinceID;
                        spanEnd = provinceID;
                    } else if (provinceID <= spanEnd + 16) {
                        spanEnd = provinceID;
                    } else {
                        uploadDirtyTextures(spanStart, spanEnd);
                        spanStart = provinceID;
                        spanEnd = provinceID;
                    }
                }
                if (spanStart >= 0) {
                    uploadDirtyTextures(spanStart, spanEnd);
                }
                if (toProcess < dirtyListSize) {
                    System.arraycopy(dirtyList, toProcess, dirtyList, 0, dirtyListSize - toProcess);
                }
                dirtyListSize -= toProcess;
            }
            dirtyCount = Math.max(0, dirtyCount - processed);
            if (dirtySweepCursor < 0 && dirtyListSize == 0 && dirtyCount == 0) {
                dirtyMin = Integer.MAX_VALUE;
                dirtyMax = -1;
            }
        }
        needsUpdate = dirtyCount > 0 || dirtyListSize > 0 || dirtySweepCursor >= 0;
        long dtNs = System.nanoTime() - t0;
        perfUpdateTotalNs += dtNs;
        perfUpdateCount++;
    }

    private static void uploadDirtyTextures(int minProvinceID, int maxProvinceID) {
        if (minProvinceID < 0 || maxProvinceID < minProvinceID || colorTexture == null || flagTexture == null) return;
        int start = Math.max(0, minProvinceID);
        int end = Math.min(colorPixmap.getWidth() - 1, maxProvinceID);
        int width = end - start + 1;
        uploadPixmapRow(colorTexture, colorPixmap, start, width);
        uploadPixmapRow(flagTexture, flagPixmap, start, width);
    }

    private static void uploadPixmapRow(Texture texture, Pixmap pixmap, int x, int width) {
        if (width <= 0) return;
        ByteBuffer pixels = pixmap.getPixels();
        int oldPosition = pixels.position();
        int oldLimit = pixels.limit();
        int bytesPerPixel = getBytesPerPixel(pixmap);
        int byteStart = x * bytesPerPixel;
        int byteEnd = byteStart + width * bytesPerPixel;
        try {
            pixels.position(byteStart);
            pixels.limit(byteEnd);
            ByteBuffer uploadPixels = pixels.slice();
            uploadPixels.limit(width * bytesPerPixel);
            Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
            texture.bind();
            Gdx.gl.glPixelStorei(GL20.GL_UNPACK_ALIGNMENT, 1);
            Gdx.gl.glTexSubImage2D(GL20.GL_TEXTURE_2D, 0, x, 0, width, 1, pixmap.getGLFormat(), pixmap.getGLType(), uploadPixels);
            Gdx.gl.glPixelStorei(GL20.GL_UNPACK_ALIGNMENT, 4);
        }
        finally {
            pixels.position(oldPosition);
            pixels.limit(oldLimit);
        }
    }

    private static int getBytesPerPixel(Pixmap pixmap) {
        switch (pixmap.getFormat()) {
            case Alpha:
            case Intensity:
                return 1;
            case LuminanceAlpha:
            case RGB565:
            case RGBA4444:
                return 2;
            case RGB888:
                return 3;
            case RGBA8888:
            default:
                return 4;
        }
    }
    
    public static boolean isInitialized() {
        return initialized;
    }

    public static int getDirtyCount() {
        return dirtyCount;
    }

    public static boolean canRender() {
        return initialized && renderAvailable && shader != null && colorTexture != null && flagTexture != null && pageMeshes.size() > 0;
    }

    public static boolean canRenderWithColors() {
        return canRender();
    }

    public static void updateTexture() {
        if (initialized) {
            colorTexture.draw(colorPixmap, 0, 0);
            flagTexture.draw(flagPixmap, 0, 0);
        }
    }

    public static void rebuildCapitals() {
        if (!initialized) return;
        int numCivs = CFG.core.getCivsSize();
        if (capitalProvinceIDs == null || capitalProvinceIDs.length < numCivs) {
            capitalProvinceIDs = new int[Math.max(numCivs, 256)];
        }
        capitalCount = 0;
        for (int i = 0; i < numCivs; ++i) {
            Civilization civ = CFG.core.getCiv(i);
            if (civ == null) continue;
            int capID = civ.getCapitalProvID();
            if (capID >= 0 && CFG.core.getProv(capID) != null && CFG.core.getProv(capID).getCivId() == i) {
                capitalProvinceIDs[capitalCount++] = capID;
            }
        }
    }

    public static int[] getCapitalProvinceIDs() {
        return capitalProvinceIDs;
    }

    public static int getCapitalCount() {
        return capitalCount;
    }

    private static float getDiscoveryFade() {
        if (CFG.FOG_OF_WAR == 2) {
            if (CFG.startTheGameData != null && !CFG.startTheGameData.getIsDone()) {
                int provAlpha = CFG.startTheGameData.getProvincesAlpha();
                if (provAlpha > 0) return (float)provAlpha / (float)CFG.settingsGD.PROV_ALPHA;
            }
            return 0.0f;
        }
        return 1.0f;
    }

    private static boolean diplomacyActive = false;
    private static int diplomacyPlayerCivID = -1;
    private static int[] capitalProvinceIDs;
    private static int capitalCount = 0;
    private static boolean[] civsAtWarCache;
    private static float dipAlpha;
    private static float dipOwnR, dipOwnG, dipOwnB;
    private static float dipWarR, dipWarG, dipWarB;
    private static float dipAllianceR, dipAllianceG, dipAllianceB;
    private static float dipNeutralR, dipNeutralG, dipNeutralB;

    private static void getDiplomacyColor(int provinceID, float[] outRGB, float[] outAlpha) {
        int ownerCivID = CFG.core.getProv(provinceID).getCivId();
        outAlpha[0] = CFG.ALPHA_DIPLOMACY;
        if (ownerCivID == diplomacyPlayerCivID) {
            outRGB[0] = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR();
            outRGB[1] = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG();
            outRGB[2] = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB();
        } else if (CFG.core.getCivsAtWar(ownerCivID, diplomacyPlayerCivID)) {
            outRGB[0] = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR();
            outRGB[1] = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG();
            outRGB[2] = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB();
        } else if (CFG.core.getCiv(ownerCivID).getAlliance() > 0 && CFG.core.getCiv(ownerCivID).getAlliance() == CFG.core.getCiv(diplomacyPlayerCivID).getAlliance()) {
            outRGB[0] = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR();
            outRGB[1] = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG();
            outRGB[2] = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB();
        } else {
            outRGB[0] = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR();
            outRGB[1] = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG();
            outRGB[2] = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB();
        }
    }

    public static void setDiplomacyMode(boolean active, int playerCivID) {
        if (active == diplomacyActive && playerCivID == diplomacyPlayerCivID) {
            if (CFG.LOGs) CFG.LOG("[dip]", "setDiplomacyMode: skipped (already in this mode) playerCivID=" + playerCivID);
            return;
        }
        long t0 = CFG.LOGs ? System.nanoTime() : 0L;
        diplomacyActive = active;
        diplomacyPlayerCivID = active ? playerCivID : -1;
        if (initialized) {
            if (active) {
                int nCiv = CFG.core.getCivsSize();
                if (civsAtWarCache == null || civsAtWarCache.length < nCiv) civsAtWarCache = new boolean[Math.max(nCiv, 1)];
                for (int i = 0; i < nCiv; i++) {
                    try { civsAtWarCache[i] = CFG.core.getCivsAtWar(i, playerCivID); }
                    catch (Exception e) { civsAtWarCache[i] = false; }
                }
                dipAlpha = CFG.ALPHA_DIPLOMACY;
                try {
                    dipOwnR = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR();
                    dipOwnG = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG();
                    dipOwnB = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB();
                    dipWarR = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR();
                    dipWarG = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG();
                    dipWarB = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB();
                    dipAllianceR = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR();
                    dipAllianceG = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG();
                    dipAllianceB = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB();
                    dipNeutralR = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR();
                    dipNeutralG = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG();
                    dipNeutralB = CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB();
                } catch (Exception e) {
                    if (CFG.LOGs) CFG.LOG("[dip]", "setDiplomacyMode: failed to read diplomacy colors: " + e.getMessage());
                }
                if (CFG.LOGs) CFG.LOG("[dip]", "setDiplomacyMode: cached civsAtWar[" + nCiv + "] in " + ((System.nanoTime() - t0) / 1000000L) + "ms");
            } else {
                civsAtWarCache = null;
            }
            markAllDirtyImmediate(true);
            if (CFG.LOGs) CFG.LOG("[dip]", "setDiplomacyMode: active=" + active + " playerCivID=" + playerCivID + " total=" + ((System.nanoTime() - t0) / 1000000L) + "ms");
        }
    }

    public static boolean isDiplomacyActive() {
        return diplomacyActive;
    }

    public static int getDiplomacyPlayerCivID() {
        return diplomacyPlayerCivID;
    }

    public static void draw(SpriteBatch oSB) {
        if (!canRender()) return;
        long drawStart = System.nanoTime();

        boolean wasDrawing = oSB.isDrawing();
        if (wasDrawing) oSB.end();
        updateAllStates();
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
            shader.setUniformf("u_activeProvinceID", (float)CFG.core.getActiveProvID());
            
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
        if (whiteTexture != null) whiteTexture.dispose();
        colorPixmap = null;
        colorTexture = null;
        flagPixmap = null;
        flagTexture = null;
        initialized = false;
        renderAvailable = false;
        needsUpdate = true;
        totalProvincesRendered = 0;
        lastDiscoveryFade = -1f;
        dirtyFlags = null;
        dirtyList = null;
        dirtyListSize = 0;
        dirtyCount = 0;
        dirtyArraySize = 0;
        dirtyMin = Integer.MAX_VALUE;
        dirtyMax = -1;
        dirtySweepCursor = -1;
    }
}
