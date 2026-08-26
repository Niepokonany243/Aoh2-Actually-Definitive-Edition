package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import java.util.HashMap;
import java.util.Map;

public class FlagAtlas {
    private static final int ATLAS_SIZE = 2048;
    private static final int FLAG_SIZE = 64;
    private static final int FLAGS_PER_ROW = ATLAS_SIZE / FLAG_SIZE;
    private static final int MAX_FLAGS = FLAGS_PER_ROW * FLAGS_PER_ROW;

    private static Pixmap atlasPixmap;
    private static Texture atlasTexture;
    private static boolean initialized = false;
    private static boolean atlasDirty = false;

    // Fast int[] lookup to avoid HashMap boxing per flag (200* get per frame -> HashMap hit)
    private static int[] civToSlot;
    private static final Map<Integer, FlagRegion> civFlagSlots = new HashMap<Integer, FlagRegion>(1024);
    private static int nextSlot = 0;

    private static class FlagRegion {
        int x, y;
        int civID;
        boolean used;
    }

    public static void init() {
        if (initialized) dispose();
        atlasPixmap = new Pixmap(ATLAS_SIZE, ATLAS_SIZE, Pixmap.Format.RGBA8888);
        atlasPixmap.setColor(0, 0, 0, 0);
        atlasPixmap.fill();
        atlasTexture = new Texture(atlasPixmap);
        atlasTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        initialized = true;
        atlasDirty = true;
        nextSlot = 0;
        civFlagSlots.clear();
        int maxCivs = 4096;
        try { if (CFG.core != null) maxCivs = Math.max(4096, CFG.core.getCivsSize() + 16); } catch (Throwable ignore) {}
        civToSlot = new int[maxCivs];
        for (int i = 0; i < civToSlot.length; i++) civToSlot[i] = -1;
        preloadAllFlags();
    }

    private static void preloadAllFlags() {
        if (CFG.core == null) return;
        int civs = CFG.core.getCivsSize();
        if (civs <= 1) return;
        for (int civID = 1; civID < civs && nextSlot < MAX_FLAGS; civID++) {
            try {
                Civilization civ = CFG.core.getCiv(civID);
                if (civ == null) continue;
                if (civToSlot != null && civID < civToSlot.length && civToSlot[civID] >= 0) continue;
                int slot = nextSlot++;
                int fx = (slot % FLAGS_PER_ROW) * FLAG_SIZE;
                int fy = (slot / FLAGS_PER_ROW) * FLAG_SIZE;
                FlagRegion region = new FlagRegion();
                region.x = fx;
                region.y = fy;
                region.civID = civID;
                region.used = true;
                civFlagSlots.put(civID, region);
                if (civID < civToSlot.length) civToSlot[civID] = slot;
                renderFlagToAtlas(civID, fx, fy);
            } catch (Throwable t) { }
        }
        atlasDirty = true;
        flush();
    }

    public static void dispose() {
        if (atlasTexture != null) atlasTexture.dispose();
        if (atlasPixmap != null) atlasPixmap.dispose();
        atlasTexture = null;
        atlasPixmap = null;
        initialized = false;
        civFlagSlots.clear();
        nextSlot = 0;
        atlasDirty = false;
        civToSlot = null;
    }

    public static Texture getAtlasTexture() { return atlasTexture; }
    public static boolean isInitialized() { return initialized; }

    public static int ensureCivFlag(int civID) {
        if (!initialized || civID <= 0) return -1;
        if (civToSlot != null && civID < civToSlot.length) {
            int s = civToSlot[civID];
            if (s >= 0) return s;
        } else {
            FlagRegion r = civFlagSlots.get(civID);
            if (r != null && r.used) return r.x / FLAG_SIZE + (r.y / FLAG_SIZE) * FLAGS_PER_ROW;
        }
        if (CFG.core != null && civID >= CFG.core.getCivsSize()) return -1;
        if (nextSlot >= MAX_FLAGS) {
            Gdx.app.log("FlagAtlas", "Atlas full, cannot add civ " + civID + " MAX=" + MAX_FLAGS);
            return -1;
        }
        int slot = nextSlot++;
        int fx = (slot % FLAGS_PER_ROW) * FLAG_SIZE;
        int fy = (slot / FLAGS_PER_ROW) * FLAG_SIZE;
        FlagRegion region = new FlagRegion();
        region.x = fx;
        region.y = fy;
        region.civID = civID;
        region.used = true;
        civFlagSlots.put(civID, region);
        if (civID < civToSlot.length) civToSlot[civID] = slot;
        renderFlagToAtlas(civID, fx, fy);
        atlasDirty = true;
        return slot;
    }

    public static void updateCivFlag(int civID) {
        if (!initialized) return;
        int slot = -1;
        if (civToSlot != null && civID < civToSlot.length) slot = civToSlot[civID];
        if (slot < 0) {
            FlagRegion region = civFlagSlots.get(civID);
            if (region == null || !region.used) return;
            slot = region.x / FLAG_SIZE + (region.y / FLAG_SIZE) * FLAGS_PER_ROW;
        }
        FlagRegion region = civFlagSlots.get(civID);
        if (region == null) return;
        renderFlagToAtlas(civID, region.x, region.y);
        atlasDirty = true;
    }

    public static void removeCivFlag(int civID) {
        FlagRegion region = civFlagSlots.remove(civID);
        if (civID < civToSlot.length && civID >= 0) civToSlot[civID] = -1;
        if (region != null && atlasPixmap != null) {
            atlasPixmap.setColor(0, 0, 0, 0);
            atlasPixmap.fillRectangle(region.x, region.y, FLAG_SIZE, FLAG_SIZE);
            atlasDirty = true;
        }
    }

    public static int getFlagSlot(int civID) {
        if (civToSlot != null && civID >= 0 && civID < civToSlot.length) {
            int s = civToSlot[civID];
            if (s >= 0) return s;
        }
        FlagRegion region = civFlagSlots.get(civID);
        if (region == null || !region.used) return -1;
        return region.x / FLAG_SIZE + (region.y / FLAG_SIZE) * FLAGS_PER_ROW;
    }

    public static void getFlagUV(int civID, float[] outUV) {
        int slot = getFlagSlot(civID);
        if (slot < 0 || outUV == null || outUV.length < 4) return;
        int fx = (slot % FLAGS_PER_ROW) * FLAG_SIZE;
        int fy = (slot / FLAGS_PER_ROW) * FLAG_SIZE;
        float invW = 1.0f / ATLAS_SIZE;
        float invH = 1.0f / ATLAS_SIZE;
        outUV[0] = fx * invW;
        outUV[1] = (fy + FLAG_SIZE) * invH;
        outUV[2] = (fx + FLAG_SIZE) * invW;
        outUV[3] = fy * invH;
    }

    public static boolean isDirty() { return atlasDirty; }

    public static void flush() {
        if (!initialized || !atlasDirty || atlasTexture == null || atlasPixmap == null) return;
        atlasTexture.draw(atlasPixmap, 0, 0);
        atlasDirty = false;
    }

    private static void renderFlagToAtlas(int civID, int dstX, int dstY) {
        try {
            Civilization civ = CFG.core.getCiv(civID);
            if (civ == null) return;
            Image flagImg = civ.getFlagC();
            if (flagImg == null || flagImg.getTexture() == null) {
                atlasPixmap.setColor(0, 0, 0, 0);
                atlasPixmap.fillRectangle(dstX, dstY, FLAG_SIZE, FLAG_SIZE);
                return;
            }
            Pixmap flagPixmap = null;
            boolean needsDispose = false;
            try {
                // Try direct pixmap from Image if already a Pixmap-backed texture
                com.badlogic.gdx.graphics.Texture tex = flagImg.getTexture();
                if (tex.getTextureData() != null && tex.getTextureData().isPrepared()) {
                    // For PixmapTextureData this would be fast, but for FileTextureData prepare decodes
                    flagPixmap = tex.getTextureData().consumePixmap();
                    needsDispose = true;
                } else {
                    // Fallback: load from file handle cache if available – try to get path from flag
                    // Last resort: prepare then consume
                    if (!tex.getTextureData().isPrepared()) tex.getTextureData().prepare();
                    flagPixmap = tex.getTextureData().consumePixmap();
                    needsDispose = true;
                }
            } catch (Throwable t) {
                flagPixmap = null;
            }
            if (flagPixmap == null) return;
            try {
                int fw = Math.min(flagPixmap.getWidth(), FLAG_SIZE);
                int fh = Math.min(flagPixmap.getHeight(), FLAG_SIZE);
                atlasPixmap.drawPixmap(flagPixmap, dstX, dstY, 0, 0, fw, fh);
            } finally {
                if (needsDispose) try { flagPixmap.dispose(); } catch (Throwable ignore) {}
            }
        } catch (Exception ex) {
            Gdx.app.log("FlagAtlas", "Error rendering flag for civ " + civID + ": " + ex.getMessage());
        }
    }

    public static int getAtlasSize() { return ATLAS_SIZE; }
    public static int getFlagSize() { return FLAG_SIZE; }
    public static int getFlagsPerRow() { return FLAGS_PER_ROW; }
    public static void clear() {
        civFlagSlots.clear();
        if (civToSlot != null) for (int i=0;i<civToSlot.length;i++) civToSlot[i]=-1;
        nextSlot = 0;
        if (atlasPixmap != null) {
            atlasPixmap.setColor(0, 0, 0, 0);
            atlasPixmap.fill();
            atlasDirty = true;
        }
    }
}
