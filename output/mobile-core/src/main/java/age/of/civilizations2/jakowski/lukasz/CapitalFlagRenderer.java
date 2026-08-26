package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
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

    private static final List<FlagDrawData> flagData = new ArrayList<FlagDrawData>(256);
    private static int flagCount;
    private static float currentScale = 1.0f;

    private static final float[] uvBuffer = new float[4];

    private static class FlagDrawData {
        int provinceID;
        int civID;
        float screenX;
        float screenY;
        int flagSlot;
        boolean hasCrown;
        boolean isHRE;
        boolean isVassal;
        boolean visible;
    }

    public static void init() {
        initialized = true;
        invalidate();
    }

    public static void dispose() {
        initialized = false;
        valid = false;
        flagData.clear();
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
        // Do NOT throttle while panning - stale flag positions cause flash/missing in capitals; rebuild is cheap (VisibleProvinceCache)
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
        rebuildStart = System.nanoTime();
        flagData.clear();
        flagCount = 0;
        int px = CFG.map.getMpC().getPX();
        int py = CFG.map.getMpC().getPY();
        float zoom = CFG.map.getMpS().getCurrSc();
        currentScale = zoom < 1.0f ? zoom : 1.0f;
        // Keep flags down to 0.05 zoom; only cull when truly invisible. New-game menu needs flags at 0.06 zoom.
        if (zoom < 0.05f) { valid = true; flagCount = 0; return; }

        int visibleProvCount = VisibleProvinceCache.getVisibleCapitalCount();
        List<Integer> capitals = VisibleProvinceCache.getVisibleCapitals();

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
            FlagDrawData data = new FlagDrawData();
            data.provinceID = provID;
            data.civID = civID;
            data.screenX = p.getCeX() + p.getShPX() + p.getTranslateProvPosX() + px;
            data.screenY = p.getCeY() + p.getShPY() + py;
            data.flagSlot = flagSlot;
            data.hasCrown = civ.getCapitalProvID() == provID;
            data.isHRE = civ.getIsPartOfHolyRomanEmpire();
            data.isVassal = civ.getPuppetOfCiv() != civ.getCivId();
            data.visible = true;
            flagData.add(data);
            flagCount++;
        }
        lastCameraPX = px;
        lastCameraPY = py;
        lastZoom = zoom;
        lastFogOfWar = (CFG.FOG_OF_WAR == 2);
        lastOwnershipStamp = VisibleProvinceCache.getOwnershipStamp();
        valid = true;
        lastRebuildNano = System.nanoTime();
        if (CFG.LOG_PERF) CFG.LOG("[PERF]", "[CapitalFlags] rebuild capitals=" + flagCount + " zoom=" + zoom + " time=" + (System.nanoTime() - rebuildStart) / 1000000L + "ms");
    }

    private static long rebuildStart = 0L;

    // Budget: allow all visible capitals, frustum cull does the work. 48 cap was causing missing flags.
    private static long lastDrawNano = 0L;
    private static int maxFlagsPerFrame = 256; // show all visible capitals; cull handles off-screen
    private static long lastRebuildNano = 0L;
    // Throttled logging: aggregate per 15s to avoid spam (was per-frame)
    private static long lastFlagLogNano = 0L;
    private static int flagLogAccumDrawn = 0;
    private static int flagLogAccumFlagCount = 0;
    private static int flagLogAccumBudget = 0;
    private static int flagLogFrames = 0;
    private static long flagLogMinDrawn = Integer.MAX_VALUE;
    private static long flagLogMaxDrawn = 0;

    public static void drawFlags(SpriteBatch oSB) {
        if (!initialized || flagCount == 0 || CFG.map == null) return;
        rebuildIfNeeded();
        // Always flush dirty atlas immediately - deferring caused flags invisible for ms while moving / new-game flash
        FlagAtlas.flush();
        Texture atlas = FlagAtlas.getAtlasTexture();
        if (atlas == null) return;

        int flagW = (int)(CFG.CIV_FLAG_WIDTH * currentScale);
        int flagH = (int)(CFG.CIV_FLAG_HEIGHT * currentScale);
        if (flagW < 2 || flagH < 1) return;

        // Show all visible capitals - frustum cull already limits work, no arbitrary 24-48 cap
        int budget = maxFlagsPerFrame; // 256
        int toDraw = Math.min(flagCount, budget);

        int atlasSize = FlagAtlas.getAtlasSize();
        int flagsPerRow = FlagAtlas.getFlagsPerRow();
        float invAtlasSize = 1.0f / atlasSize;
        int flagTexSize = FlagAtlas.getFlagSize();

        // View culling + budget already ensures we don't iterate 275 every frame
        int drawn = 0;
        for (int i = 0; i < flagCount && drawn < toDraw; i++) {
            FlagDrawData data = flagData.get(i);
            if (!data.visible) continue;
            // Frustum cull: skip if off-screen (saves vertex push even when batched)
            float drawX = data.screenX - flagW / 2f;
            float drawY = data.screenY - flagH / 2f;
            if (drawX + flagW < -CFG.GAMEWIDTH || drawX > CFG.GAMEWIDTH * 2) continue;
            if (drawY + flagH < -CFG.GAMEHEIGHT || drawY > CFG.GAMEHEIGHT * 2) continue;
            int slot = data.flagSlot;
            int sx = (slot % flagsPerRow) * flagTexSize;
            int sy = (slot / flagsPerRow) * flagTexSize;
            float u = sx * invAtlasSize;
            float v = (sy + flagTexSize) * invAtlasSize;
            float u2 = (sx + flagTexSize) * invAtlasSize;
            float v2 = sy * invAtlasSize;
            try {
                oSB.draw(atlas, drawX, drawY, flagW, flagH, u, v, u2, v2);
                drawn++;
            }
            catch (Exception ex) {
            }
        }
        // Throttled per-15s summary instead of per-frame spam; also ensures logging continues in-game (was missing after game start when verbose=false)
        if (CFG.LOG_PERF) {
            long now = System.nanoTime();
            flagLogAccumDrawn += drawn;
            flagLogAccumFlagCount += flagCount;
            flagLogAccumBudget += budget;
            flagLogFrames++;
            if (drawn < flagLogMinDrawn) flagLogMinDrawn = drawn;
            if (drawn > flagLogMaxDrawn) flagLogMaxDrawn = drawn;
            long interval = 15000000000L; // 15s
            if (lastFlagLogNano == 0L) lastFlagLogNano = now;
            if (now - lastFlagLogNano >= interval) {
                int avgDrawn = flagLogFrames > 0 ? flagLogAccumDrawn / flagLogFrames : 0;
                int avgCount = flagLogFrames > 0 ? flagLogAccumFlagCount / flagLogFrames : 0;
                int avgBudget = flagLogFrames > 0 ? flagLogAccumBudget / flagLogFrames : 0;
                // Always log summary (detailed per 15s) regardless of VERBOSE; include VERBOSE flag to indicate detailed
                float z = CFG.map != null ? CFG.map.getMpS().getCurrSc() : 0f;
                CFG.LOG("[PERF]", "[flags] summary " + avgDrawn + "/" + avgCount + " capitals flags (min=" + flagLogMinDrawn + " max=" + flagLogMaxDrawn + ") avgBudget=" + avgBudget + " zoom=" + String.format("%.2f", z) + " frames=" + flagLogFrames);
                lastFlagLogNano = now;
                flagLogAccumDrawn = 0; flagLogAccumFlagCount = 0; flagLogAccumBudget = 0; flagLogFrames = 0;
                flagLogMinDrawn = Integer.MAX_VALUE; flagLogMaxDrawn = 0;
            } else if (CFG.LOG_PERF_VERBOSE) {
                // In verbose mode also keep per-15s only; no per-frame log
            }
        }
    }

    private static boolean isAtlasClean() {
        try {
            return !FlagAtlas.isDirty();
        } catch (Throwable t) { return true; }
    }

    public static int getFlagCount() {
        return flagCount;
    }

    public static boolean isInitialized() {
        return initialized;
    }
}
