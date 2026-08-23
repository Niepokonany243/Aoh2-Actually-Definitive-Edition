package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Arrays;

public class OverlayTextCache {
    private static boolean initialized = false;

    private static int[] cachedProvinceIDs;
    private static String[] cachedProvinceTexts;
    private static Color[] cachedProvinceColors;
    private static float[] cachedProvinceX;
    private static float[] cachedProvinceY;
    private static boolean[] cachedProvinceValid;
    private static int cachedProvinceCount;

    private static int[] cachedArmyProvinceIDs;
    private static String[] cachedArmyTexts;
    private static int[] cachedArmyCounts;
    private static Color[] cachedArmyColors;
    private static float[] cachedArmyX;
    private static float[] cachedArmyY;
    private static boolean[] cachedArmyValid;
    private static int cachedArmyCount;

    private static long lastDataStamp;
    private static int lastCivsSize;
    private static int lastProvinSize;

    private static final GlyphLayout layoutPool = new GlyphLayout();

    public static void init(int maxProvinces, int maxArmies) {
        cachedProvinceIDs = new int[maxProvinces];
        cachedProvinceTexts = new String[maxProvinces];
        cachedProvinceColors = new Color[maxProvinces];
        cachedProvinceX = new float[maxProvinces];
        cachedProvinceY = new float[maxProvinces];
        cachedProvinceValid = new boolean[maxProvinces];
        Arrays.fill(cachedProvinceValid, false);

        cachedArmyProvinceIDs = new int[maxArmies];
        cachedArmyTexts = new String[maxArmies];
        cachedArmyCounts = new int[maxArmies];
        cachedArmyColors = new Color[maxArmies];
        cachedArmyX = new float[maxArmies];
        cachedArmyY = new float[maxArmies];
        cachedArmyValid = new boolean[maxArmies];
        Arrays.fill(cachedArmyValid, false);

        initialized = true;
        invalidateAll();
    }

    public static void dispose() {
        initialized = false;
        cachedProvinceIDs = null;
        cachedProvinceTexts = null;
        cachedProvinceColors = null;
        cachedProvinceX = null;
        cachedProvinceY = null;
        cachedProvinceValid = null;
        cachedArmyProvinceIDs = null;
        cachedArmyTexts = null;
        cachedArmyCounts = null;
        cachedArmyColors = null;
        cachedArmyX = null;
        cachedArmyY = null;
        cachedArmyValid = null;
    }

    public static void invalidateAll() {
        if (!initialized) return;
        if (cachedProvinceValid != null) {
            Arrays.fill(cachedProvinceValid, false);
        }
        if (cachedArmyValid != null) {
            Arrays.fill(cachedArmyValid, false);
        }
        cachedProvinceCount = 0;
        cachedArmyCount = 0;
        lastDataStamp = 0;
    }

    public static void invalidateProvinceOverlays() {
        if (!initialized || cachedProvinceValid == null) return;
        Arrays.fill(cachedProvinceValid, false);
        cachedProvinceCount = 0;
    }

    public static void invalidateArmyOverlays() {
        if (!initialized || cachedArmyValid == null) return;
        Arrays.fill(cachedArmyValid, false);
        cachedArmyCount = 0;
    }

    public static void cacheProvinceText(int provinceID, String text, Color color, float x, float y) {
        if (!initialized || cachedProvinceIDs == null) return;
        int idx = findProvinceSlot(provinceID);
        if (idx < 0 && cachedProvinceCount < cachedProvinceIDs.length) {
            idx = cachedProvinceCount++;
        }
        if (idx < 0) return;
        cachedProvinceIDs[idx] = provinceID;
        cachedProvinceTexts[idx] = text;
        if (cachedProvinceColors[idx] == null) {
            cachedProvinceColors[idx] = new Color(color);
        } else {
            cachedProvinceColors[idx].set(color);
        }
        cachedProvinceX[idx] = x;
        cachedProvinceY[idx] = y;
        cachedProvinceValid[idx] = true;
    }

    public static void cacheArmyText(int provinceID, String text, int armyCount, Color color, float x, float y) {
        if (!initialized || cachedArmyProvinceIDs == null) return;
        int idx = findArmySlot(provinceID);
        if (idx < 0 && cachedArmyCount < cachedArmyProvinceIDs.length) {
            idx = cachedArmyCount++;
        }
        if (idx < 0) return;
        cachedArmyProvinceIDs[idx] = provinceID;
        cachedArmyTexts[idx] = text;
        cachedArmyCounts[idx] = armyCount;
        if (cachedArmyColors[idx] == null) {
            cachedArmyColors[idx] = new Color(color);
        } else {
            cachedArmyColors[idx].set(color);
        }
        cachedArmyX[idx] = x;
        cachedArmyY[idx] = y;
        cachedArmyValid[idx] = true;
    }

    public static boolean getCachedProvinceText(int provinceID, String[] outText, Color outColor, float[] outPos) {
        if (!initialized) return false;
        int idx = findProvinceSlot(provinceID);
        if (idx < 0 || !cachedProvinceValid[idx]) return false;
        if (outText != null) outText[0] = cachedProvinceTexts[idx];
        if (outColor != null) outColor.set(cachedProvinceColors[idx]);
        if (outPos != null) { outPos[0] = cachedProvinceX[idx]; outPos[1] = cachedProvinceY[idx]; }
        return true;
    }

    public static boolean getCachedArmyText(int provinceID, String[] outText, int[] outCount, Color outColor, float[] outPos) {
        if (!initialized) return false;
        int idx = findArmySlot(provinceID);
        if (idx < 0 || !cachedArmyValid[idx]) return false;
        if (outText != null) outText[0] = cachedArmyTexts[idx];
        if (outCount != null) outCount[0] = cachedArmyCounts[idx];
        if (outColor != null) outColor.set(cachedArmyColors[idx]);
        if (outPos != null) { outPos[0] = cachedArmyX[idx]; outPos[1] = cachedArmyY[idx]; }
        return true;
    }

    public static float getTextWidth(BitmapFont font, String text) {
        if (text == null || text.isEmpty()) return 0;
        synchronized (layoutPool) {
            layoutPool.setText(font, text);
            return layoutPool.width;
        }
    }

    private static int findProvinceSlot(int provinceID) {
        for (int i = 0; i < cachedProvinceCount; i++) {
            if (cachedProvinceIDs[i] == provinceID) return i;
        }
        return -1;
    }

    private static int findArmySlot(int provinceID) {
        for (int i = 0; i < cachedArmyCount; i++) {
            if (cachedArmyProvinceIDs[i] == provinceID) return i;
        }
        return -1;
    }

    public static boolean isInitialized() {
        return initialized;
    }
}
