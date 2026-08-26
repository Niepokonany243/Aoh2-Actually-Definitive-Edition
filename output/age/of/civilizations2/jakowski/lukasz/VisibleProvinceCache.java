package age.of.civilizations2.jakowski.lukasz;

import java.util.ArrayList;
import java.util.List;

public class VisibleProvinceCache {
    private static boolean initialized = false;
    private static boolean valid = false;

    private static int lastCameraPX = Integer.MIN_VALUE;
    private static int lastCameraPY = Integer.MIN_VALUE;
    private static float lastZoom = -1f;
    private static int lastCivsSize = -1;
    private static int lastProvinSize = -1;
    private static long lastOwnershipStamp = 0L;

    private static final List<Integer> visibleProvinces = new ArrayList<Integer>(1024);
    private static final List<Integer> visibleCapitals = new ArrayList<Integer>(256);
    private static final List<Integer> visibleArmies = new ArrayList<Integer>(512);
    private static final List<Integer> visibleLabels = new ArrayList<Integer>(512);
    private static final List<Integer> visibleCityIcons = new ArrayList<Integer>(256);

    private static int visibleProvinceCount;
    private static int visibleCapitalCount;
    private static int visibleArmyCount;
    private static int visibleLabelCount;
    private static int visibleCityIconCount;

    private static long ownershipModCount;

    public static void init() {
        initialized = true;
        invalidate();
    }

    public static void dispose() {
        initialized = false;
        valid = false;
        visibleProvinces.clear();
        visibleCapitals.clear();
        visibleArmies.clear();
        visibleLabels.clear();
        visibleCityIcons.clear();
        visibleProvinceCount = 0;
        visibleCapitalCount = 0;
        visibleArmyCount = 0;
        visibleLabelCount = 0;
        visibleCityIconCount = 0;
    }

    public static void invalidate() {
        valid = false;
        lastCameraPX = Integer.MIN_VALUE;
        lastCameraPY = Integer.MIN_VALUE;
        lastZoom = -1f;
    }

    public static void markOwnershipChanged() {
        ownershipModCount++;
    }

    private static boolean needsRebuild() {
        if (!initialized) return false;
        if (!valid) return true;
        if (CFG.map == null || CFG.core == null) return false;
        int px = CFG.map.getMpC().getPX();
        int py = CFG.map.getMpC().getPY();
        float zoom = CFG.map.getMpS().getCurrSc();
        int civsSize = CFG.core.getCivsSize();
        int provinSize = CFG.core.getProvinSize();
        if (px != lastCameraPX || py != lastCameraPY) return true;
        if (Float.compare(zoom, lastZoom) != 0) return true;
        if (civsSize != lastCivsSize) return true;
        if (provinSize != lastProvinSize) return true;
        if (ownershipModCount != lastOwnershipStamp) return true;
        return false;
    }

    public static void rebuildIfNeeded() {
        if (!needsRebuild()) return;
        rebuild();
    }

    private static void rebuild() {
        if (!initialized || CFG.core == null || CFG.map == null) return;
        int px = CFG.map.getMpC().getPX();
        int py = CFG.map.getMpC().getPY();
        float zoom = CFG.map.getMpS().getCurrSc();

        visibleProvinces.clear();
        visibleCapitals.clear();
        visibleArmies.clear();
        visibleLabels.clear();
        visibleCityIcons.clear();

        int numProv = CFG.NUM_OF_PROVINCES_IN_VIEW;
        if (numProv > 0) {
            for (int i = 0; i < numProv; i++) {
                int provID = CFG.core.getPIV(i);
                if (provID < 0 || provID >= CFG.core.getProvinSize()) continue;
                Province p = CFG.core.getProv(provID);
                if (p == null) continue;
                visibleProvinces.add(provID);
                int civID = p.getCivId();
                if (civID > 0 && civID < CFG.core.getCivsSize()) {
                    Civilization civ = CFG.core.getCiv(civID);
                    if (civ != null && provID == civ.getCapitalProvID()) {
                        visibleCapitals.add(provID);
                    }
                }
                if (p.getCivsSize() > 0 && p.getArmyID(0) > 0) {
                    visibleArmies.add(provID);
                }
                if (p.getCitSize() > 0) {
                    visibleCityIcons.add(provID);
                }
            }
        } else if (CFG.core != null && CFG.core.getCivsSize() > 0) {
            // Fallback for new-game / menu views where NUM_OF_PROVINCES_IN_VIEW==0 but we still need capitals for flags
            for (int civID = 1; civID < CFG.core.getCivsSize(); civID++) {
                try {
                    Civilization civ = CFG.core.getCiv(civID);
                    if (civ == null) continue;
                    int cap = civ.getCapitalProvID();
                    if (cap < 0 || cap >= CFG.core.getProvinSize()) continue;
                    if (CFG.FOG_OF_WAR == 2 && !CFG.getMetProv(cap)) continue;
                    Province p = CFG.core.getProv(cap);
                    if (p == null) continue;
                    visibleCapitals.add(cap);
                    visibleProvinces.add(cap);
                } catch (Exception ignore) {}
            }
        }

        visibleProvinceCount = visibleProvinces.size();
        visibleCapitalCount = visibleCapitals.size();
        visibleArmyCount = visibleArmies.size();
        visibleCityIconCount = visibleCityIcons.size();

        lastCameraPX = px;
        lastCameraPY = py;
        lastZoom = zoom;
        lastCivsSize = CFG.core.getCivsSize();
        lastProvinSize = CFG.core.getProvinSize();
        lastOwnershipStamp = ownershipModCount;
        valid = true;
    }

    public static boolean isValid() {
        return valid;
    }

    public static List<Integer> getVisibleProvinces() {
        return visibleProvinces;
    }

    public static int getVisibleProvinceCount() {
        return visibleProvinceCount;
    }

    public static List<Integer> getVisibleCapitals() {
        return visibleCapitals;
    }

    public static int getVisibleCapitalCount() {
        return visibleCapitalCount;
    }

    public static List<Integer> getVisibleArmies() {
        return visibleArmies;
    }

    public static int getVisibleArmyCount() {
        return visibleArmyCount;
    }

    public static List<Integer> getVisibleLabels() {
        return visibleLabels;
    }

    public static int getVisibleLabelCount() {
        return visibleLabelCount;
    }

    public static List<Integer> getVisibleCityIcons() {
        return visibleCityIcons;
    }

    public static int getVisibleCityIconCount() {
        return visibleCityIconCount;
    }

    public static boolean hasVisibleCapitals() {
        return visibleCapitalCount > 0;
    }

    public static boolean hasVisibleArmies() {
        return visibleArmyCount > 0;
    }

    public static long getOwnershipStamp() {
        return ownershipModCount;
    }
}
