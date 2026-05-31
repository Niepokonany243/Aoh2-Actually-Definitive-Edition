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

    public static long calculateMissileCost(int civID) {
        return calculateMissileCost(civID, CFG.core.getCiv(civID).civGD.iMissileTier);
    }

    public static long calculateMissileCost(int civID, int tier) {
        long taxation = CFG.core.getCiv(civID).incomeTaxation;
        long baseCost = (long)((float)taxation * 0.5f); // 50% of taxation
        if (baseCost < 100) baseCost = 100; 
        
        if (tier == 2) return baseCost * 10;
        if (tier == 3) return baseCost * 25;
        return baseCost;
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
                civ.civGD.missilesConstruction.add(200 + 35); // Tier 3, 5 turns (3*10 + 5)
            } else if (tier == 2) {
                civ.civGD.missilesConstruction.add(100 + 22); // Tier 2, 2 turns (2*10 + 2)
            } else {
                civ.civGD.missilesConstruction.add(11); // Tier 1, 1 turn (1*10 + 1)
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
        return tier != 1 || dist <= 2000 ? (tier != 2 || dist <= 8000) && (tier != 3 || dist <= 50000) : false;
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
        
        // Range Check
        int startProv = attacker.getCapitalProvID();
        if (startProv < 0) startProv = attacker.getProvID(0);
        
        float dist = Distance.getManhattanDistance(startProv, targetProvinceID);
        if (tier == 1 && dist > 2000) return;
        else if (tier == 2 && dist > 8000) return;
        else if (tier == 3 && dist > 50000) return;

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
        
        // Sort targets by score (eco + pop) descending
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
        
        // Default city interception bonus based on development
        float devInterceptionChance = 0.0f;
        if (prov.getDeveLvl() >= 0.4f) {
            devInterceptionChance = 0.5f;
            if (tier == 2) devInterceptionChance = 0.25f;
            else if (tier == 3) devInterceptionChance = 0.1f;
        }

        // Air Defense check
        float protectionChance = 0.0f;
        int interceptions = turnInterceptions.getOrDefault(provinceID, 0);
        if (prov.provGD.iAirDefense > 0) {
            protectionChance = age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvAirDefense.AIR_DEFENSE_PROTECTION_CHANCE[prov.provGD.iAirDefense];
        }
        
        float finalChance = Math.max(protectionChance, devInterceptionChance) * (1.0f - (float)interceptions * 0.2f);
        if (finalChance < 0.05f && (protectionChance > 0 || devInterceptionChance > 0)) finalChance = 0.05f; 
        
        if (CFG.oR.nextFloat() < finalChance) {
            // Intercepted!
            turnInterceptions.put(provinceID, interceptions + 1);
            return -1;
        }
        
        // Stats before
        float powerMult = 1.0f;
        if (tier == 2) powerMult = 10.0f;
        else if (tier == 3) powerMult = 25.0f;
        
        long unitsKilled = 0L; 
        
        long popLost = (long)((float)prov.getPop().getPopulationOfCivID(prov.getCivId()) * 0.015f * powerMult);
        int ecoLost = (int)((float)prov.getEco() * 0.05f * powerMult);

        prov.setEco(Math.max(0, prov.getEco() - ecoLost));
        prov.getPop().setPopulationOfCivID(prov.getCivId(), Math.max(0, prov.getPop().getPopulationOfCivID(prov.getCivId()) - popLost));
        
        // Unrest
        prov.provGD.fRevolutionaryRisk = Math.min(1.0f, prov.provGD.fRevolutionaryRisk + 0.08f * powerMult);
        prov.provGD.fHappiness = Math.max(0.0f, prov.provGD.fHappiness - 0.04f * powerMult);
        
        // Building destruction
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

        // Visuals and Sound
        Renderer.addMissileFlash(provinceID); // Simple performance friendly effect
        CFG.SFXManager.playSound(SFXManager.SFX_NUKE);
        
        // Notifications
        if (CFG.core.getCiv(prov.getCivId()).getIsPlayer()) {
            CFG.core.getCiv(prov.getCivId()).getCivDiploGD().messageBox.addMessage(new Message_Missile_Strike(civID, provinceID, popLost, ecoLost, unitsKilled));
        }
        
        // Casualty recording
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

