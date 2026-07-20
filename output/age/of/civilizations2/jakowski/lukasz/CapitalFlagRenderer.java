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
        int px = CFG.map.getMpC().getPX();
        int py = CFG.map.getMpC().getPY();
        float zoom = CFG.map.getMpS().getCurrSc();
        if (px != lastCameraPX || py != lastCameraPY) return true;
        if (Float.compare(zoom, lastZoom) != 0) return true;
        if ((CFG.FOG_OF_WAR == 2) != lastFogOfWar) return true;
        return false;
    }

    public static void rebuildIfNeeded() {
        if (!needsRebuild()) return;
        rebuild();
    }

    private static void rebuild() {
        if (!initialized || CFG.core == null || CFG.map == null) return;
        flagData.clear();
        flagCount = 0;
        int px = CFG.map.getMpC().getPX();
        int py = CFG.map.getMpC().getPY();
        float zoom = CFG.map.getMpS().getCurrSc();
        currentScale = zoom < 1.0f ? zoom : 1.0f;

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
        valid = true;
    }

    public static void drawFlags(SpriteBatch oSB) {
        if (!initialized || flagCount == 0 || CFG.map == null) return;
        rebuildIfNeeded();
        FlagAtlas.flush();
        Texture atlas = FlagAtlas.getAtlasTexture();
        if (atlas == null) return;

        int flagW = (int)(CFG.CIV_FLAG_WIDTH * currentScale);
        int flagH = (int)(CFG.CIV_FLAG_HEIGHT * currentScale);
        if (flagW < 4 || flagH < 2) return;

        int atlasSize = FlagAtlas.getAtlasSize();
        int flagsPerRow = FlagAtlas.getFlagsPerRow();
        float invAtlasSize = 1.0f / atlasSize;
        int flagTexSize = FlagAtlas.getFlagSize();

        for (int i = 0; i < flagCount; i++) {
            FlagDrawData data = flagData.get(i);
            if (!data.visible) continue;
            int slot = data.flagSlot;
            int sx = (slot % flagsPerRow) * flagTexSize;
            int sy = (slot / flagsPerRow) * flagTexSize;
            float u = sx * invAtlasSize;
            float v = (sy + flagTexSize) * invAtlasSize;
            float u2 = (sx + flagTexSize) * invAtlasSize;
            float v2 = sy * invAtlasSize;
            float drawX = data.screenX - flagW / 2f;
            float drawY = data.screenY - flagH / 2f;
            try {
                oSB.draw(atlas, drawX, drawY, flagW, flagH, u, v, u2, v2);
            }
            catch (Exception ex) {
            }
        }
    }

    public static int getFlagCount() {
        return flagCount;
    }

    public static boolean isInitialized() {
        return initialized;
    }
}
