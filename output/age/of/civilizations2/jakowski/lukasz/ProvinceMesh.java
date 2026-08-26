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
    private static Texture occupiedTexture;
    private static Pixmap occupiedPixmap;
    private static float lastDiscoveryFade = -1f;
    private static boolean[] dirtyFlags;
    private static int[] dirtyList;
    private static int dirtyListSize;
    private static int dirtyCount;
    private static int dirtyArraySize;
    private static int dirtyMin = Integer.MAX_VALUE;
    private static int dirtyMax = -1;
    private static int dirtySweepCursor = -1;
    private static boolean colorsHaveOwnership = false;
    private static boolean diplomacyActive = false;

    public static void setDiplomacyMode(boolean active, int playerCivID) {
        diplomacyActive = active;
    }
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
        
        flagPixmap = new Pixmap(texWidth, 1, Pixmap.Format.RGBA8888);
        flagTexture = new Texture(flagPixmap);
        flagTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        occupiedPixmap = new Pixmap(texWidth, 1, Pixmap.Format.RGBA8888);
        occupiedTexture = new Texture(occupiedPixmap);
        occupiedTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        String vertexShader = "attribute vec2 a_position;\n" +
                              "attribute vec2 a_texCoord;\n" +
                              "attribute float a_provinceID;\n" +
                              "uniform mat4 u_projTrans;\n" +
                              "uniform float u_translateX;\n" +
                              "uniform float u_translateY;\n" +
                              "varying vec2 v_texCoord;\n" +
                              "varying float v_provinceID;\n" +
                              "varying vec2 v_worldPos;\n" +
                              "void main() {\n" +
                              "    v_texCoord = a_texCoord;\n" +
                              "    v_provinceID = a_provinceID;\n" +
                              "    v_worldPos = a_position.xy + vec2(u_translateX, u_translateY);\n" +
                              "    gl_Position = u_projTrans * vec4(a_position.x + u_translateX, a_position.y + u_translateY, 0, 1);\n" +
                              "}";
        
        String fragmentShader = "#ifdef GL_ES\n" +
                                "#ifdef GL_FRAGMENT_PRECISION_HIGH\n" +
                                "precision highp float;\n" +
                                "#else\n" +
                                "precision mediump float;\n" +
                                "#endif\n" +
                                "#endif\n" +
                                "varying vec2 v_texCoord;\n" +
                                "varying float v_provinceID;\n" +
                                "varying vec2 v_worldPos;\n" +
                                "uniform sampler2D u_texture;\n" +
                                "uniform sampler2D u_colors;\n" +
                                "uniform sampler2D u_flags;\n" +
                                "uniform sampler2D u_occupied;\n" +
                                "uniform float u_colorStep;\n" +
                                "uniform float u_discoveryFade;\n" +
                                "uniform float u_stripeDensity;\n" +
                                "void main() {\n" +
                                "    float provinceSlot = floor(v_provinceID + 0.5);\n" +
                                "    vec2 colorUV = vec2((provinceSlot + 0.5) * u_colorStep, 0.5);\n" +
                                "    vec4 mask = texture2D(u_texture, v_texCoord);\n" +
                                "    vec4 provColor = texture2D(u_colors, colorUV);\n" +
                                "    float flag = texture2D(u_flags, colorUV).a;\n" +
                                "    float finalAlpha = provColor.a;\n" +
                                "    if (flag > 0.5) {\n" +
                                "        finalAlpha = provColor.a * u_discoveryFade;\n" +
                                "    }\n" +
                                "    if (texture2D(u_occupied, colorUV).a > 0.5) {\n" +
                                "        float stripe = step(0.5, fract((v_worldPos.x - v_worldPos.y) * u_stripeDensity));\n" +
                                "        provColor.rgb *= mix(1.0, 0.5, stripe);\n" +
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
        dirtyList = new int[numProvinces];
        dirtyListSize = 0;
        java.util.Arrays.fill(dirtyFlags, true);
        dirtyCount = numProvinces;
        dirtyMin = 0;
        dirtyMax = numProvinces - 1;
        dirtySweepCursor = -1;
        colorsHaveOwnership = false;
        needsUpdate = true;
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
        if (dirtyCount == dirtyArraySize && dirtySweepCursor >= 0) return;
        java.util.Arrays.fill(dirtyFlags, true);
        dirtyListSize = 0;
        dirtyCount = dirtyArraySize;
        dirtyMin = 0;
        dirtyMax = dirtyArraySize - 1;
        dirtySweepCursor = 0;
        needsUpdate = true;
        VisibleProvinceCache.markOwnershipChanged();
    }

    public static synchronized void markAllDirtyImmediate() {
        if (!initialized) return;
        java.util.Arrays.fill(dirtyFlags, true);
        dirtyListSize = 0;
        dirtyCount = dirtyArraySize;
        dirtyMin = 0;
        dirtyMax = dirtyArraySize - 1;
        dirtySweepCursor = -1;
        colorsHaveOwnership = false;
        needsUpdate = true;
        VisibleProvinceCache.markOwnershipChanged();
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
        if (provinceID < 0 || provinceID >= colorPixmap.getWidth()) {
            Gdx.app.log("ProvinceMesh", "WARN: provinceID=" + provinceID + " out of colorPixmap bounds width=" + colorPixmap.getWidth());
            return;
        }
        Province p = CFG.core.getProv(provinceID);
        
        boolean occupied = p.isOccupied();
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
            if (civID > 0) {
                colorsHaveOwnership = true;
            }
            if (civ == null) {
                colorPixmap.setColor(1, 0, 1, alpha);
            } else {
                colorPixmap.setColor((float)civ.getR() / 255.0f, (float)civ.getG() / 255.0f, (float)civ.getB() / 255.0f, alpha);
            }
            flagPixmap.setColor(0, 0, 0, 0);
        }
        occupiedPixmap.setColor(occupied ? 1f : 0f, 0f, 0f, occupied ? 1f : 0f);
        colorPixmap.drawPixel(provinceID, 0);
        flagPixmap.drawPixel(provinceID, 0);
        occupiedPixmap.drawPixel(provinceID, 0);
    }
    
    public static synchronized void updateAllStates() {
        if (!initialized || !needsUpdate) return;
        long t0 = System.nanoTime();
        if (dirtyCount > 0) {
            int numProv = CFG.core.getProvinSize();
            int lim = Math.min(numProv, dirtyArraySize);
            int processed = 0;
            if (dirtySweepCursor >= 0 || dirtyCount == dirtyArraySize || dirtyListSize == 0) {
                int start = dirtySweepCursor >= 0 ? dirtySweepCursor : 0;
                int end = CFG.isAndroid() && dirtySweepCursor >= 0 ? Math.min(lim, start + ANDROID_DIRTY_BATCH) : lim;
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
                        updateTexture();
                    } else {
                        uploadDirtyTextures(uploadStart, uploadEnd);
                    }
                }
                dirtySweepCursor = end >= lim ? -1 : end;
            } else {
                java.util.Arrays.sort(dirtyList, 0, dirtyListSize);
                int toProcess = CFG.isAndroid() ? Math.min(dirtyListSize, ANDROID_DIRTY_BATCH) : dirtyListSize;
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
        uploadPixmapRow(occupiedTexture, occupiedPixmap, start, width);
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
        synchronized (ProvinceMesh.class) {
            if (!initialized) return 0;
            int pendingSweep = dirtySweepCursor >= 0 ? (dirtyArraySize - dirtySweepCursor) : 0;
            return dirtyCount + dirtyListSize + pendingSweep;
        }
    }

    public static boolean isDiplomacyActive() {
        return diplomacyActive;
    }

    public static int getDiplomacyPlayerCivID() {
        return -1;
    }

    public static boolean canRender() {
        return initialized && renderAvailable && shader != null && colorTexture != null && flagTexture != null && pageMeshes.size() > 0;
    }

    public static boolean canRenderWithColors() {
        return canRender() && colorsHaveOwnership;
    }

    public static void updateTexture() {
        if (initialized) {
            colorTexture.draw(colorPixmap, 0, 0);
            flagTexture.draw(flagPixmap, 0, 0);
            occupiedTexture.draw(occupiedPixmap, 0, 0);
        }
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

        boolean wasDrawing = oSB.isDrawing();
        if (wasDrawing) oSB.end();
        // Skip GPU-province triple draw while panning on mobile - saves 2/3 indices
        if (CFG.isAndroid() && MobileRenderBudget.isEnabled() && MobileRenderBudget.isMoving() && CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) {
            // Still need to update dirty colors, but avoid triple render when moving
        }
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
            shader.setUniformi("u_occupied", 3);
            shader.setUniformf("u_colorStep", 1.0f / colorTexture.getWidth());
            shader.setUniformf("u_discoveryFade", getDiscoveryFade());
            shader.setUniformf("u_stripeDensity", CFG.settingsGD.OCCUPIED_STRIPES_SIZE / 60.0f);
            
            colorTexture.bind(1);
            flagTexture.bind(2);
            occupiedTexture.bind(3);
            
            boolean worldMap = CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN());
            int pX = CFG.map.getMpC().getPX();
            int pY = CFG.map.getMpC().getPY();
            // When panning on mobile, skip triple-wrap to cut 2/3 GPU work; single center pass is enough for perceived position
            boolean skipWrap = CFG.isAndroid() && MobileRenderBudget.isEnabled() && MobileRenderBudget.isMoving() && worldMap;
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
                    if (!skipWrap) {
                        shader.setUniformf("u_translateX", pX - widthM);
                        tpm.mesh.render(shader, GL20.GL_TRIANGLES);
                        shader.setUniformf("u_translateX", pX + widthM);
                        tpm.mesh.render(shader, GL20.GL_TRIANGLES);
                    }
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
        if (occupiedTexture != null) occupiedTexture.dispose();
        if (occupiedPixmap != null) occupiedPixmap.dispose();
        colorPixmap = null;
        colorTexture = null;
        flagPixmap = null;
        flagTexture = null;
        occupiedPixmap = null;
        occupiedTexture = null;
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
        colorsHaveOwnership = false;
    }
}
