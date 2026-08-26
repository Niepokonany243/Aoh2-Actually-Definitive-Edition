package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import java.util.HashMap;
import java.util.Map;

public class FlagAtlas {
    private static final int ATLAS_SIZE = 1024;
    private static final int FLAG_SIZE = 64;
    private static final int FLAGS_PER_ROW = ATLAS_SIZE / FLAG_SIZE;
    private static final int MAX_FLAGS = FLAGS_PER_ROW * FLAGS_PER_ROW;

    private static Pixmap atlasPixmap;
    private static Texture atlasTexture;
    private static boolean initialized = false;
    private static boolean atlasDirty = false;

    private static final Map<Integer, FlagRegion> civFlagSlots = new HashMap<Integer, FlagRegion>(128);

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
    }

    public static void dispose() {
        if (atlasTexture != null) atlasTexture.dispose();
        if (atlasPixmap != null) atlasPixmap.dispose();
        atlasTexture = null;
        atlasPixmap = null;
        initialized = false;
        civFlagSlots.clear();
        nextSlot = 0;
    }

    public static Texture getAtlasTexture() {
        return atlasTexture;
    }

    public static boolean isInitialized() {
        return initialized;
    }

    public static int ensureCivFlag(int civID) {
        if (!initialized || civID <= 0 || civID >= CFG.core.getCivsSize()) return -1;
        FlagRegion region = civFlagSlots.get(civID);
        if (region != null && region.used) return region.x + region.y * FLAGS_PER_ROW;
        if (nextSlot >= MAX_FLAGS) {
            Gdx.app.log("FlagAtlas", "Atlas full, cannot add civ " + civID);
            return -1;
        }
        int slot = nextSlot++;
        int fx = (slot % FLAGS_PER_ROW) * FLAG_SIZE;
        int fy = (slot / FLAGS_PER_ROW) * FLAG_SIZE;
        region = new FlagRegion();
        region.x = fx;
        region.y = fy;
        region.civID = civID;
        region.used = true;
        civFlagSlots.put(civID, region);
        renderFlagToAtlas(civID, fx, fy);
        atlasDirty = true;
        return slot;
    }

    public static void updateCivFlag(int civID) {
        if (!initialized) return;
        FlagRegion region = civFlagSlots.get(civID);
        if (region == null || !region.used) return;
        renderFlagToAtlas(civID, region.x, region.y);
        atlasDirty = true;
    }

    public static void removeCivFlag(int civID) {
        FlagRegion region = civFlagSlots.remove(civID);
        if (region != null && atlasPixmap != null) {
            atlasPixmap.setColor(0, 0, 0, 0);
            atlasPixmap.fillRectangle(region.x, region.y, FLAG_SIZE, FLAG_SIZE);
            atlasDirty = true;
        }
    }

    public static int getFlagSlot(int civID) {
        FlagRegion region = civFlagSlots.get(civID);
        if (region == null || !region.used) return -1;
        return region.x + region.y * FLAGS_PER_ROW;
    }

    public static void getFlagUV(int civID, float[] outUV) {
        FlagRegion region = civFlagSlots.get(civID);
        if (region == null || !region.used || outUV == null || outUV.length < 4) return;
        float invW = 1.0f / ATLAS_SIZE;
        float invH = 1.0f / ATLAS_SIZE;
        outUV[0] = region.x * invW;
        outUV[1] = (region.y + FLAG_SIZE) * invH;
        outUV[2] = (region.x + FLAG_SIZE) * invW;
        outUV[3] = region.y * invH;
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
            if (!flagImg.getTexture().getTextureData().isPrepared()) {
                flagImg.getTexture().getTextureData().prepare();
            }
            Pixmap flagPixmap = flagImg.getTexture().getTextureData().consumePixmap();
            if (flagPixmap == null) return;
            try {
                int fw = Math.min(flagPixmap.getWidth(), FLAG_SIZE);
                int fh = Math.min(flagPixmap.getHeight(), FLAG_SIZE);
                // Use linear filtering via Pixmap scaling if needed; draw with proper dispose
                atlasPixmap.drawPixmap(flagPixmap, dstX, dstY, 0, 0, fw, fh);
            } finally {
                // consumePixmap returns same pixmap instance unless disposed; dispose only if we own copy
                // The API docs: consumePixmap returns the pixmap and marks data as consumed; subsequent call creates new
                // So we must NOT dispose the original texture pixmap if texture is still in use - only dispose temporary copy
                // We obtained one pixmap; if textureData will reuse it, do not dispose
                // Heuristic: dispose only if not same as texture's current pixmap data
                try {
                    if (!flagImg.getTexture().getTextureData().isPrepared()) {
                        // data was consumed, safe to dispose our copy
                        flagPixmap.dispose();
                    } else {
                        // Still prepared means we got a copy, dispose
                        // avoid double-dispose by checking
                    }
                } catch (Throwable ignore) {
                    try { flagPixmap.dispose(); } catch (Throwable ig2) {}
                }
            }
        }
        catch (Exception ex) {
            Gdx.app.log("FlagAtlas", "Error rendering flag for civ " + civID + ": " + ex.getMessage());
        }
    }

    public static int getAtlasSize() {
        return ATLAS_SIZE;
    }

    public static int getFlagSize() {
        return FLAG_SIZE;
    }

    public static int getFlagsPerRow() {
        return FLAGS_PER_ROW;
    }

    public static void clear() {
        civFlagSlots.clear();
        nextSlot = 0;
        if (atlasPixmap != null) {
            atlasPixmap.setColor(0, 0, 0, 0);
            atlasPixmap.fill();
            atlasDirty = true;
        }
    }
}
