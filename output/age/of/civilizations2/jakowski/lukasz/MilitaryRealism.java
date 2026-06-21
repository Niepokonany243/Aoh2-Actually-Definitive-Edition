package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import java.util.Arrays;

public class MilitaryRealism {
    private static int cachedTurnID = -1;
    private static float cachedWorldEcoPerPop = 1.0f;
    private static int[] civCacheTurn = new int[0];
    private static int[] civCacheLevel = new int[0];
    private static long[] civCacheUnits = new long[0];
    private static long[] civCachePop = new long[0];
    private static long[] civCacheEco = new long[0];
    private static float[] civCacheEcoPerPop = new float[0];
    private static float[] civCacheRecruitCostFactor = new float[0];
    private static float[] civCacheUpkeepFactor = new float[0];

    public static boolean isEnabled() {
        return CFG.settingsGD != null && CFG.settingsGD.BAT_PLUS;
    }

    public static int getMobilizationLevel(int civID) {
        if (civID <= 0 || civID >= CFG.core.getCivsSize()) return 0;
        int max = GameValues.gvMilitaryRealism.MOBILIZATION_RECRUIT_COST.length - 1;
        return Math.max(0, Math.min(max, CFG.core.getCiv(civID).civGD.mobilizationLevel));
    }

    public static String getMobilizationName(int civID) {
        int level = getMobilizationLevel(civID);
        if (level < GameValues.gvMilitaryRealism.MOBILIZATION_NAME.length) {
            return GameValues.gvMilitaryRealism.MOBILIZATION_NAME[level];
        }
        return "Peace";
    }

    public static void updateMobilizationAllCivs() {
        if (!isEnabled()) return;
        for (int i = CFG.core.getNextAliveCiv(1); i >= 0; i = CFG.core.getNextAliveCiv(i + 1)) {
            updateMobilization(i);
        }
    }

    public static void updateMobilization(int civID) {
        if (civID <= 0 || civID >= CFG.core.getCivsSize()) return;
        Civilization civ = CFG.core.getCiv(civID);
        if (civ.getNumOfProvs() <= 0) {
            civ.civGD.mobilizationLevel = 0;
            invalidateCiv(civID);
            return;
        }
        int target = getTargetMobilization(civID);
        int current = getMobilizationLevel(civID);
        if (target > current) {
            civ.civGD.mobilizationLevel = target;
            civ.civGD.mobilizationLastChangeTurnID = GameCalendar.TURNID;
            invalidateCiv(civID);
        } else if (target < current && civ.civGD.mobilizationLastChangeTurnID + GameValues.gvMilitaryRealism.DEMOBILIZATION_TURNS <= GameCalendar.TURNID) {
            civ.civGD.mobilizationLevel = Math.max(target, current - 1);
            civ.civGD.mobilizationLastChangeTurnID = GameCalendar.TURNID;
            invalidateCiv(civID);
        }
    }

    public static void forceMobilization(int civID, int level) {
        if (civID <= 0 || civID >= CFG.core.getCivsSize()) return;
        int max = GameValues.gvMilitaryRealism.MOBILIZATION_RECRUIT_COST.length - 1;
        CFG.core.getCiv(civID).civGD.mobilizationLevel = Math.max(0, Math.min(max, level));
        CFG.core.getCiv(civID).civGD.mobilizationLastChangeTurnID = GameCalendar.TURNID;
        invalidateCiv(civID);
    }

    public static void setManualMobilization(int civID, int levelIndex) {
        if (civID <= 0 || civID >= CFG.core.getCivsSize()) return;
        if (levelIndex < 0) {
            CFG.core.getCiv(civID).civGD.mobilizationManualLevel = 0;
            CFG.core.getCiv(civID).civGD.sandboxMilitarise = false;
            updateMobilization(civID);
        } else {
            int max = Math.min(GameValues.gvMilitaryRealism.MOBILIZATION_NAME.length, GameValues.gvMilitaryRealism.MOBILIZATION_RECRUIT_COST.length) - 1;
            levelIndex = Math.max(0, Math.min(max, levelIndex));
            CFG.core.getCiv(civID).civGD.mobilizationManualLevel = levelIndex + 1;
            CFG.core.getCiv(civID).civGD.sandboxMilitarise = false;
            forceMobilization(civID, levelIndex);
        }
        invalidateCiv(civID);
    }

    public static void cycleManualMobilization(int civID) {
        if (civID <= 0 || civID >= CFG.core.getCivsSize()) return;
        int maxManual = Math.min(GameValues.gvMilitaryRealism.MOBILIZATION_NAME.length, GameValues.gvMilitaryRealism.MOBILIZATION_RECRUIT_COST.length);
        int next = CFG.core.getCiv(civID).civGD.mobilizationManualLevel + 1;
        if (next > maxManual) next = 0;
        CFG.core.getCiv(civID).civGD.mobilizationManualLevel = next;
        if (next > 0) {
            CFG.core.getCiv(civID).civGD.sandboxMilitarise = next == 5;
            forceMobilization(civID, next - 1);
        } else {
            CFG.core.getCiv(civID).civGD.sandboxMilitarise = false;
            updateMobilization(civID);
        }
        invalidateCiv(civID);
    }

    public static String getManualMobilizationName(int civID) {
        if (civID <= 0 || civID >= CFG.core.getCivsSize()) return "Auto";
        int manual = CFG.core.getCiv(civID).civGD.mobilizationManualLevel;
        if (manual <= 0) return "Auto";
        int level = Math.max(0, Math.min(GameValues.gvMilitaryRealism.MOBILIZATION_NAME.length - 1, manual - 1));
        return GameValues.gvMilitaryRealism.MOBILIZATION_NAME[level];
    }

    private static int getTargetMobilization(int civID) {
        Civilization civ = CFG.core.getCiv(civID);
        int capital = civ.getCapitalProvID();
        if (capital >= 0 && CFG.core.getProv(capital).getCivId() != civID) return 5;
        for (int i = 0; i < civ.getNumOfProvs(); ++i) {
            if (CFG.core.getProv(civ.getProvID(i)).isOccupied()) return 4;
        }
        if (civ.civGD.mobilizationManualLevel > 0) return civ.civGD.mobilizationManualLevel - 1;
        if (civ.civGD.sandboxMilitarise) return 4;
        if (civ.civGD.civPlans.isPreparingForTheWar()) return 4;
        if (civ.isAtWarC()) return 3;
        return 0;
    }

    public static int getRecruitCost(int provinceID, int civID, boolean instantly) {
        int armouryReduction = CFG.core.getProv(provinceID).getLvlOfArmoury() > 0 ? GameValues.gvBuildingArmoury.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT_REDUCTION * CFG.core.getProv(provinceID).getLvlOfArmoury() : 0;
        float base = (float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT * (instantly ? GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT_CONSCRIPT_EXTRA : 1.0f) - (float)armouryReduction;
        if (!isEnabled()) return Math.max(1, (int)base);
        if (civID <= 0) civID = CFG.core.getProv(provinceID).getCivId();
        return Math.max(1, (int)Math.ceil(base * getRecruitCostFactor(civID)));
    }

    public static float getRecruitCostFactor(int civID) {
        if (!isEnabled() || civID <= 0 || civID >= CFG.core.getCivsSize()) return 1.0f;
        ensureCivCache(civID);
        return civCacheRecruitCostFactor[civID];
    }

    public static float getMilitaryUpkeepFactor(int civID) {
        if (!isEnabled() || civID <= 0 || civID >= CFG.core.getCivsSize()) return 1.0f;
        ensureCivCache(civID);
        return civCacheUpkeepFactor[civID];
    }

    public static float getAttackBonusPercent(int civID) {
        if (!isEnabled()) return 0.0f;
        return getArray(GameValues.gvMilitaryRealism.MOBILIZATION_ATTACK_BONUS, getMobilizationLevel(civID), 0.0f);
    }

    public static float getDefenseBonusPercent(int civID) {
        if (!isEnabled()) return 0.0f;
        return getArray(GameValues.gvMilitaryRealism.MOBILIZATION_DEFENSE_BONUS, getMobilizationLevel(civID), 0.0f);
    }

    private static float getWorldEcoPerPop() {
        if (cachedTurnID == GameCalendar.TURNID) return cachedWorldEcoPerPop;
        long eco = 0L;
        long pop = 0L;
        for (int i = CFG.core.getNextAliveCiv(1); i >= 0; i = CFG.core.getNextAliveCiv(i + 1)) {
            Civilization civ = CFG.core.getCiv(i);
            eco += Math.max(0L, civ.countEco());
            pop += Math.max(0L, civ.countPop());
        }
        cachedWorldEcoPerPop = pop > 0L ? Math.max(0.0001f, (float)eco / (float)pop) : 1.0f;
        cachedTurnID = GameCalendar.TURNID;
        return cachedWorldEcoPerPop;
    }

    private static float getCivEcoPerPop(int civID) {
        ensureCivCache(civID);
        return civCacheEcoPerPop[civID];
    }

    private static void ensureCivCache(int civID) {
        ensureCivCacheSize();
        Civilization civ = CFG.core.getCiv(civID);
        int level = getMobilizationLevel(civID);
        long units = civ.getNumberOfUnits();
        if (civCacheTurn[civID] == GameCalendar.TURNID && civCacheLevel[civID] == level && civCacheUnits[civID] == units) return;
        long pop = Math.max(1L, civ.countPop());
        long eco = Math.max(1L, civ.countEco());
        float ecoPerPop = Math.max(0.0001f, (float)eco / (float)pop);
        float recruitFactor = getArray(GameValues.gvMilitaryRealism.MOBILIZATION_RECRUIT_COST, level, 1.0f);
        float world = getWorldEcoPerPop();
        if (ecoPerPop < world) {
            float poverty = Math.max(0.0f, Math.min(1.0f, 1.0f - ecoPerPop / world));
            recruitFactor *= 1.0f - poverty * GameValues.gvMilitaryRealism.LOW_ECONOMY_RECRUIT_COST_REDUCTION_MAX;
        } else if (world > 0.0f) {
            float wealth = Math.max(0.0f, ecoPerPop / world - 1.0f);
            recruitFactor *= 1.0f + Math.min(GameValues.gvMilitaryRealism.HIGH_ECONOMY_RECRUIT_COST_INCREASE_MAX, wealth * GameValues.gvMilitaryRealism.HIGH_ECONOMY_RECRUIT_COST_INCREASE);
        }
        float upkeepFactor = getArray(GameValues.gvMilitaryRealism.MOBILIZATION_UPKEEP, level, 1.0f);
        if (ecoPerPop < world) {
            float poverty = Math.max(0.0f, Math.min(1.0f, 1.0f - ecoPerPop / world));
            upkeepFactor *= 1.0f - poverty * GameValues.gvMilitaryRealism.LOW_ECONOMY_RECRUIT_COST_REDUCTION_MAX;
        } else if (world > 0.0f) {
            float wealth = Math.max(0.0f, ecoPerPop / world - 1.0f);
            upkeepFactor *= 1.0f + Math.min(GameValues.gvMilitaryRealism.HIGH_ECONOMY_RECRUIT_COST_INCREASE_MAX, wealth * GameValues.gvMilitaryRealism.HIGH_ECONOMY_RECRUIT_COST_INCREASE);
        }
        float armyShare = (float)units / (float)pop;
        float over = Math.max(0.0f, armyShare - GameValues.gvMilitaryRealism.LOGISTICS_ARMY_POPULATION_THRESHOLD);
        upkeepFactor *= 1.0f + Math.min(GameValues.gvMilitaryRealism.LOGISTICS_UPKEEP_MAX, over * GameValues.gvMilitaryRealism.LOGISTICS_UPKEEP_PER_OVER_THRESHOLD);

        civCacheTurn[civID] = GameCalendar.TURNID;
        civCacheLevel[civID] = level;
        civCacheUnits[civID] = units;
        civCachePop[civID] = pop;
        civCacheEco[civID] = eco;
        civCacheEcoPerPop[civID] = ecoPerPop;
        civCacheRecruitCostFactor[civID] = Math.max(0.1f, recruitFactor);
        civCacheUpkeepFactor[civID] = upkeepFactor;
    }

    private static void ensureCivCacheSize() {
        int civsSize = CFG.core.getCivsSize();
        if (civCacheTurn.length >= civsSize) return;
        int oldSize = civCacheTurn.length;
        int newSize = Math.max(civsSize, oldSize * 2 + 8);
        civCacheTurn = Arrays.copyOf(civCacheTurn, newSize);
        civCacheLevel = Arrays.copyOf(civCacheLevel, newSize);
        civCacheUnits = Arrays.copyOf(civCacheUnits, newSize);
        civCachePop = Arrays.copyOf(civCachePop, newSize);
        civCacheEco = Arrays.copyOf(civCacheEco, newSize);
        civCacheEcoPerPop = Arrays.copyOf(civCacheEcoPerPop, newSize);
        civCacheRecruitCostFactor = Arrays.copyOf(civCacheRecruitCostFactor, newSize);
        civCacheUpkeepFactor = Arrays.copyOf(civCacheUpkeepFactor, newSize);
        Arrays.fill(civCacheTurn, oldSize, newSize, -1);
    }

    public static void invalidateCiv(int civID) {
        if (civID > 0 && civID < civCacheTurn.length) {
            civCacheTurn[civID] = -1;
        }
    }

    private static float getArray(float[] values, int index, float fallback) {
        if (values == null || index < 0 || index >= values.length) return fallback;
        return values[index];
    }
}
