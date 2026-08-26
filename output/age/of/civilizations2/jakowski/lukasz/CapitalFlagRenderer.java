package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class CapitalFlagRenderer {
    private static boolean initialized = false;
    private static boolean valid = false;

    private static int lastCameraPX = Integer.MIN_VALUE;
    private static int lastCameraPY = Integer.MIN_VALUE;
    private static float lastZoom = -1f;
    private static boolean lastFogOfWar;
    private static long lastOwnershipStamp;

    // Pool: avoid per-rebuild allocation of FlagDrawData objects (500+ per frame -> GC).
    private static final List<FlagDrawData> flagData = new ArrayList<FlagDrawData>(1024);
    private static int flagCount;
    private static float currentScale = 1.0f;

    private static class FlagDrawData {
        int provinceID;
        int civID;
        float screenX;
        float screenY;
        int flagSlot;
    }

    // Pre-allocate pool to avoid GC
    private static void ensurePool(int capacity) {
        while (flagData.size() < capacity) flagData.add(new FlagDrawData());
    }

    public static void init() {
        initialized = true;
        ensurePool(1024);
        invalidate();
    }

    public static void dispose() {
        initialized = false;
        valid = false;
        flagCount = 0;
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

        // Fast path: when VisibleProvinceCache is empty (menu), fallback to iterating all capitals but still no cap
        if (visibleProvCount == 0 && capitals.size() == 0 && CFG.core.getCivsSize() > 0) {
            // Fallback: iterate civs to collect capitals (one-time menu case)
            ensurePool(CFG.core.getCivsSize());
            for (int civID = 1; civID < CFG.core.getCivsSize(); civID++) {
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
        for (int i = 0; i < visibleProvCount && i < capitals.size(); i++) {
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

    public static void drawFlags(SpriteBatch oSB) {
        // Delegate to GPU mesh path (1 draw call for all flags) – 100x vs SpriteBatch per-quad
        if (CFG.isAndroid()) {
            try {
                Class.forName("age.of.civilizations2.jakowski.lukasz.MobileCapitalFlagRenderer").getMethod("render", com.badlogic.gdx.graphics.g2d.SpriteBatch.class).invoke(null, oSB);
                return;
            } catch (Throwable t) { }
        }
        if (!initialized || CFG.map == null) return;
        rebuildIfNeeded();
        if (flagCount == 0) return;
        FlagAtlas.flush();
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

    public static int getFlagCount() {
        return flagCount;
    }

    public static boolean isInitialized() {
        return initialized;
    }
}
