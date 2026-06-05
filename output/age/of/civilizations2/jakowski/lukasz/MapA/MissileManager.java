package age.of.civilizations2.jakowski.lukasz.MapA;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Province;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Messages.Province.Missile.Message_Missile_Strike;
public class MissileManager {
    public static java.util.Map<Integer, Integer> turnInterceptions = new java.util.HashMap<>();
    public static int lastTurnID = -1;
    private static final float MISSILE_RANGE_TIER_1 = 2000.0f;
    private static final float MISSILE_RANGE_TIER_2 = 8000.0f;
    private static final float MISSILE_RANGE_TIER_3 = 16000.0f;
    private static final float DEV_MISSILE_DEFENSE_01 = 0.4f;
    private static final float DEV_MISSILE_DEFENSE_03 = 0.6f;
    private static final float DEV_MISSILE_DEFENSE_05 = 0.8f;
    private static final float DEV_MISSILE_DEFENSE_09 = 0.95f;

    public static long calculateMissileCost(int civID) {
        return calculateMissileCost(civID, CFG.core.getCiv(civID).civGD.iMissileTier);
    }

    public static long calculateMissileCost(int civID, int tier) {
        long taxation = CFG.core.getCiv(civID).incomeTaxation;
        long baseCost = (long)((float)taxation * 0.5f); 
        if (baseCost < 100) baseCost = 100; 

        long tierCost = baseCost;
        if (tier == 2) tierCost = baseCost * 10;
        else if (tier == 3) tierCost = baseCost * 25;
        return multiplyCost(tierCost, getMissileCostRankMultiplier(civID));
    }

    public static int getMissileCostRankMultiplier(int civID) {
        try {
            return Math.max(1, CFG.core.getCiv(civID).getRankPos());
        }
        catch (Exception ex) {
            return 1;
        }
    }

    private static long multiplyCost(long cost, int multiplier) {
        if (multiplier <= 1) return cost;
        if (cost > Long.MAX_VALUE / (long)multiplier) return Long.MAX_VALUE;
        return cost * (long)multiplier;
    }

    public static float getDevelopmentMissileDefense(Province prov) {
        float dev = prov.getDeveLvl();
        if (dev > 0.9f) return DEV_MISSILE_DEFENSE_09;
        if (dev > 0.5f) return DEV_MISSILE_DEFENSE_05;
        if (dev > 0.3f) return DEV_MISSILE_DEFENSE_03;
        if (dev > 0.1f) return DEV_MISSILE_DEFENSE_01;
        return 0.0f;
    }

    public static boolean upgradeMissileTier(int civID) {
        Civilization civ = CFG.core.getCiv(civID);
        if (civ.civGD.iMissileTier >= 3) return false;
        
        long cost = (long)(civ.incomeTaxation * (civ.civGD.iMissileTier == 1 ? 5.0f : 12.5f));
        if (civ.getGold() >= cost) {
            civ.setGold(civ.getGold() - cost);
            if (civ.civGD.iMissileTier == 1) {
                civ.civGD.iMissiles_T2 += civ.civGD.iMissiles;
                civ.civGD.iMissiles = 0;
            } else if (civ.civGD.iMissileTier == 2) {
                civ.civGD.iMissiles_T3 += civ.civGD.iMissiles_T2;
                civ.civGD.iMissiles_T2 = 0;
            }
            civ.civGD.iMissileTier++;
            return true;
        }
        return false;
    }

    public static boolean buildMissile(int civID) {
        Civilization civ = CFG.core.getCiv(civID);
        int tier = civ.civGD.iMissileTier;

        long cost = calculateMissileCost(civID, tier);
        if (civ.getGold() >= cost) {
            civ.setGold(civ.getGold() - cost);
            if (civ.civGD.missilesConstruction == null) civ.civGD.missilesConstruction = new java.util.ArrayList<>();
            
            if (tier == 3) {
                civ.civGD.missilesConstruction.add(200 + 35); 
            } else if (tier == 2) {
                civ.civGD.missilesConstruction.add(100 + 22); 
            } else {
                civ.civGD.missilesConstruction.add(11); 
            }

            if (civ.getIsPlayer()) {
                CFG.menus.updateInGameTopAll(civID);
            }
            return true;
        }
        return false;
    }

    public static boolean buildMissile10(int civID) {
        int added = 0;
        Civilization civ = CFG.core.getCiv(civID);
        int tier = civ.civGD.iMissileTier;
        for (int i = 0; i < 10; i++) {
            long cost = calculateMissileCost(civID, tier);
            if (civ.getGold() >= cost) {
                civ.setGold(civ.getGold() - cost);
                if (civ.civGD.missilesConstruction == null) civ.civGD.missilesConstruction = new java.util.ArrayList<>();
                if (tier == 3) {
                    civ.civGD.missilesConstruction.add(200 + 35);
                } else if (tier == 2) {
                    civ.civGD.missilesConstruction.add(100 + 22);
                } else {
                    civ.civGD.missilesConstruction.add(11);
                }
                added++;
            } else {
                break;
            }
        }
        if (added > 0) {
            if (civ.getIsPlayer()) {
                CFG.menus.updateInGameTopAll(civID);
            }
            return true;
        }
        return false;
    }

    public static void strikeProvince(int attackerCivID, int targetProvinceID) {
        strikeProvince(attackerCivID, targetProvinceID, getBestAvailableTier(attackerCivID));
    }

    public static int getBestAvailableTier(int civID) {
        Civilization civ = CFG.core.getCiv(civID);
        if (civ.civGD.iMissiles_T3 > 0) return 3;
        if (civ.civGD.iMissiles_T2 > 0) return 2;
        if (civ.civGD.iMissiles > 0) return 1;
        return -1;
    }

    private static int getTargetCivID(Province prov) {
        return prov.getTrueOwnerOfProv() > 0 ? prov.getTrueOwnerOfProv() : prov.getCivId();
    }

    public static boolean canStrikeProvince(int attackerCivID, int targetProvinceID, boolean requireWar) {
        if (!CFG.settingsGD.MISSILES || targetProvinceID < 0 || targetProvinceID >= CFG.core.getProvinSize()) return false;
        int tier = getBestAvailableTier(attackerCivID);
        if (tier < 1) return false;
        Province prov = CFG.core.getProv(targetProvinceID);
        if (prov.isOccupied()) return false;
        int defenderCivID = getTargetCivID(prov);
        if (defenderCivID <= 0 || attackerCivID == defenderCivID) return false;
        if (requireWar && !CFG.core.getCivsAtWar(attackerCivID, defenderCivID)) return false;
        Civilization attacker = CFG.core.getCiv(attackerCivID);
        int startProv = attacker.getCapitalProvID();
        if (startProv < 0 && attacker.getNumOfProvs() > 0) startProv = attacker.getProvID(0);
        if (startProv < 0) return false;
        float dist = Distance.getManhattanDistance(startProv, targetProvinceID);
        return tier != 1 || dist <= MISSILE_RANGE_TIER_1 ? (tier != 2 || dist <= MISSILE_RANGE_TIER_2) && (tier != 3 || dist <= MISSILE_RANGE_TIER_3) : false;
    }

    public static void strikeProvince(int attackerCivID, int targetProvinceID, int tier) {
        if (!CFG.settingsGD.MISSILES) return;
        if (tier < 1) return;
        Province prov = CFG.core.getProv(targetProvinceID);
        if (prov.isOccupied()) {
            return;
        }
        int defenderCivID = getTargetCivID(prov);
        
        if (attackerCivID == defenderCivID) {
            return;
        }

        Civilization attacker = CFG.core.getCiv(attackerCivID);
        if (tier == 3 && attacker.civGD.iMissiles_T3 <= 0) {
            return;
        } else if (tier == 2 && attacker.civGD.iMissiles_T2 <= 0) {
            return;
        } else if (tier == 1 && attacker.civGD.iMissiles <= 0) {
            return;
        }
        
        
        int startProv = attacker.getCapitalProvID();
        if (startProv < 0) startProv = attacker.getProvID(0);
        
        float dist = Distance.getManhattanDistance(startProv, targetProvinceID);
        if (tier == 1 && dist > MISSILE_RANGE_TIER_1) return;
        else if (tier == 2 && dist > MISSILE_RANGE_TIER_2) return;
        else if (tier == 3 && dist > MISSILE_RANGE_TIER_3) return;

        if (defenderCivID > 0 && !CFG.core.getCivsAtWar(attackerCivID, defenderCivID)) {
            CFG.core.declareWar_Simple(attackerCivID, defenderCivID);
        }
        
        dropMissile(attackerCivID, targetProvinceID, tier);
    }

    public static void strikeAllEnemies(int attackerCivID) {
        if (!CFG.settingsGD.MISSILES) return;
        Civilization civ = CFG.core.getCiv(attackerCivID);
        
        java.util.List<Integer> targets = new java.util.ArrayList<>();
        for (int i = 0; i < civ.isAtWarWithCivs.size(); i++) {
            Civilization enemy = CFG.core.getCiv(civ.isAtWarWithCivs.get(i));
            for (int j = 0; j < enemy.getNumOfProvs(); j++) {
                if (CFG.core.getProv(enemy.getProvID(j)).isOccupied()) continue;
                targets.add(enemy.getProvID(j));
            }
        }
        
        
        java.util.Collections.sort(targets, new java.util.Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                Province pA = CFG.core.getProv(a);
                Province pB = CFG.core.getProv(b);
                float scoreA = (float)pA.getPop().getPops() * 0.02f + (float)pA.getEco() * 0.15f;
                float scoreB = (float)pB.getPop().getPops() * 0.02f + (float)pB.getEco() * 0.15f;
                return Float.compare(scoreB, scoreA);
            }
        });

        for (Integer targetID : targets) {
            int useTier = -1;
            if (civ.civGD.iMissiles_T3 > 0) useTier = 3;
            else if (civ.civGD.iMissiles_T2 > 0) useTier = 2;
            else if (civ.civGD.iMissiles > 0) useTier = 1;
            
            if (useTier == -1) break;
            
            strikeProvince(attackerCivID, targetID, useTier);
        }
    }

    private static void checkTurn() {
        if (lastTurnID != age.of.civilizations2.jakowski.lukasz.GameCalendar.TURNID) {
            turnInterceptions.clear();
            lastTurnID = age.of.civilizations2.jakowski.lukasz.GameCalendar.TURNID;
        }
    }

    public static long dropMissile(int civID, int provinceID, int tier) {
        checkTurn();
        Province prov = CFG.core.getProv(provinceID);
        Civilization civ = CFG.core.getCiv(civID);
        if (prov.isOccupied()) {
            return 0;
        }
        
        if (tier == 3) {
            if (civ.civGD.iMissiles_T3 <= 0) return 0;
            civ.civGD.iMissiles_T3--;
        } else if (tier == 2) {
            if (civ.civGD.iMissiles_T2 <= 0) return 0;
            civ.civGD.iMissiles_T2--;
        } else {
            if (civ.civGD.iMissiles <= 0) return 0;
            civ.civGD.iMissiles--;
        }
        
        
        float devInterceptionChance = getDevelopmentMissileDefense(prov);

        
        float protectionChance = 0.0f;
        int interceptions = turnInterceptions.getOrDefault(provinceID, 0);
        if (prov.provGD.iAirDefense > 0) {
            protectionChance = age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvAirDefense.AIR_DEFENSE_PROTECTION_CHANCE[prov.provGD.iAirDefense];
        }
        
        float finalChance = (1.0f - (1.0f - protectionChance) * (1.0f - devInterceptionChance)) * (1.0f - (float)interceptions * 0.2f);
        if (finalChance < 0.05f && (protectionChance > 0 || devInterceptionChance > 0)) finalChance = 0.05f; 
        
        if (CFG.oR.nextFloat() < finalChance) {
            
            turnInterceptions.put(provinceID, interceptions + 1);
            return -1;
        }
        
        
        float powerMult = 1.0f;
        if (tier == 2) powerMult = 10.0f;
        else if (tier == 3) powerMult = 25.0f;
        
        long unitsKilled = 0L; 
        
        long popLost = (long)((float)prov.getPop().getPopulationOfCivID(prov.getCivId()) * 0.015f * powerMult);
        int ecoLost = (int)((float)prov.getEco() * 0.05f * powerMult);

        prov.setEco(Math.max(0, prov.getEco() - ecoLost));
        prov.getPop().setPopulationOfCivID(prov.getCivId(), Math.max(0, prov.getPop().getPopulationOfCivID(prov.getCivId()) - popLost));
        
        
        prov.provGD.fRevolutionaryRisk = Math.min(1.0f, prov.provGD.fRevolutionaryRisk + 0.08f * powerMult);
        prov.provGD.fHappiness = Math.max(0.0f, prov.provGD.fHappiness - 0.04f * powerMult);
        
        
        if (prov.provGD.iFort > 0) prov.provGD.iFort -= (int)powerMult;
        if (prov.provGD.iPort > 0) prov.provGD.iPort -= (int)powerMult;
        if (prov.provGD.iWorkshop > 0) prov.provGD.iWorkshop -= (int)powerMult;
        if (prov.provGD.iMarket > 0) prov.provGD.iMarket -= (int)powerMult;
        if (prov.provGD.iFarm > 0) prov.provGD.iFarm -= (int)powerMult;
        
        if (prov.provGD.iFort < 0) prov.provGD.iFort = 0;
        if (prov.provGD.iPort < 0) prov.provGD.iPort = 0;
        if (prov.provGD.iWorkshop < 0) prov.provGD.iWorkshop = 0;
        if (prov.provGD.iMarket < 0) prov.provGD.iMarket = 0;
        if (prov.provGD.iFarm < 0) prov.provGD.iFarm = 0;

        
        Renderer.addMissileFlash(provinceID); 
        CFG.SFXManager.playSound(SFXManager.SFX_NUKE);
        
        
        if (CFG.core.getCiv(prov.getCivId()).getIsPlayer()) {
            CFG.core.getCiv(prov.getCivId()).getCivDiploGD().messageBox.addMessage(new Message_Missile_Strike(civID, provinceID, popLost, ecoLost, unitsKilled));
        }
        
        
        try {
            for (int wi = 0; wi < CFG.core.getWarsSize(); wi++) {
                age.of.civilizations2.jakowski.lukasz.War_GameData war = CFG.core.getWar(wi);
                if (war.getIsInAggressors(civID) && war.getIsInDefenders(prov.getCivId())) {
                    int defIdx = war.getDefenderID_ByCivID(prov.getCivId());
                    if (defIdx >= 0) { war.getDefenderID(defIdx).addCivilianDeaths(popLost); war.getDefenderID(defIdx).addEconomicLosses(ecoLost); }
                    break;
                } else if (war.getIsInDefenders(civID) && war.getIsInAggressors(prov.getCivId())) {
                    int aggIdx = war.getAggressorID_ByCivID(prov.getCivId());
                    if (aggIdx >= 0) { war.getAggressorID(aggIdx).addCivilianDeaths(popLost); war.getAggressorID(aggIdx).addEconomicLosses(ecoLost); }
                    break;
                }
            }
        } catch (Exception ignored) {}

        if (civ.getIsPlayer()) {
            CFG.menus.rebuildInGame_Civ_Info_Decisions();
            CFG.menus.updateInGameTopAll(civID);
        }
        return popLost;
    }
}

