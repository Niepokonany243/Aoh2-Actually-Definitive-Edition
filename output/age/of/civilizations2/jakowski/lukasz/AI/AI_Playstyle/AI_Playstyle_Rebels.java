/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AIPlaystyle;
import age.of.civilizations2.jakowski.lukasz.CFG;
import java.util.ArrayList;

public class AI_Playstyle_Rebels
extends AIPlaystyle {
    public AI_Playstyle_Rebels() {
        this.TAG = "REBELS";
        this.PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = 0.3f;
        this.PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = 20;
    }

    @Override
    public void turnOrders(int nCivID) {
        java.util.HashSet<Integer> neighbors = new java.util.HashSet<Integer>();
        for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            int provID = CFG.core.getCiv(nCivID).getProvID(i);
            if (!((float)CFG.core.getProv(provID).getArmyID(0) < (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * 0.15f * CFG.core.getProv(provID).getGrowthRate_Pop()) || CFG.oR.nextInt(100) >= 24) {
                // empty
            } else {
                CFG.core.getProv(provID).updateArmy4(CFG.core.getProv(provID).getArmyID(0) + (long)Math.max(CFG.oR.nextInt(18), (int)((float)CFG.core.getProv(provID).getArmyID(0) * (0.0125f + (float)CFG.oR.nextInt(78) / 1000.0f))));
            }
            for (int j = 0; j < CFG.core.getProv(provID).getNeighProvincesSize(); ++j) {
                int n1 = CFG.core.getProv(provID).getNeighProvinces(j);
                neighbors.add(n1);
                for (int k = 0; k < CFG.core.getProv(n1).getNeighProvincesSize(); ++k) {
                    neighbors.add(CFG.core.getProv(n1).getNeighProvinces(k));
                }
            }
        }
        /* 
        for (Integer neighID : neighbors) {
            if (CFG.core.getProv(neighID).getCivId() != nCivID) {
                if (CFG.core.getProv(neighID).getRevRisk() < 0.7f) {
                    CFG.core.getProv(neighID).setRevRisk(Math.min(0.7f, CFG.core.getProv(neighID).getRevRisk() + 0.1f));
                }
            }
        }
        */
        this.tryRegroupArmy(nCivID);
    }

    @Override
    public void buildStartingBuildings(int nCivID) {
    }

    public final void tryRegroupArmy(int nCivID) {
        block0: for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            if (CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getDangerLvl() != 0 || CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getArmyID(0) <= 0) continue;
            for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvincesSize(); ++j) {
                if (CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j)).getCivId() != nCivID || CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j)).getDangerLvl() <= 0) continue;
                CFG.gameAction.moveArmyAction(CFG.core.getCiv(nCivID).getProvID(i), CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j), CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getArmyID(0), nCivID, false, true);
                continue block0;
            }
        }
        if (CFG.core.getCiv(nCivID).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE && CFG.oR.nextInt(100) < 65) {
            ArrayList<Integer> tempProvincesFrom = new ArrayList<Integer>();
            ArrayList<Integer> tempProvincesTo = new ArrayList<Integer>();
            for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvincesSize(); ++j) {
                    if (CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j)).getCivId() <= 0 || CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getArmyID(0) <= 0 || CFG.core.getCiv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j)).getCivId()).getNumOfProvs() <= 1 || !CFG.core.getCivsAtWar(nCivID, CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j)).getCivId())) continue;
                    int canBeMoved = 0;
                    for (int k = 0; k < CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j)).getNeighProvincesSize(); ++k) {
                        if (CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j)).getNeighProvinces(k)).getCivId() != CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j)).getCivId() || CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j)).getNeighProvinces(k)).getCivId() != CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j)).getNeighProvinces(k)).getTrueOwnerOfProv()) continue;
                        ++canBeMoved;
                        break;
                    }
                    if (canBeMoved > 0) continue;
                    tempProvincesFrom.add(CFG.core.getCiv(nCivID).getProvID(i));
                    tempProvincesTo.add(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j));
                }
            }
            if (!tempProvincesFrom.isEmpty()) {
                int tRandMove = 0;
                while (!tempProvincesFrom.isEmpty() && CFG.core.getCiv(nCivID).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE && tRandMove < 35) {
                    int tBest = -1;
                    float fBestScore = 0.0f;
                    for (int i = tempProvincesFrom.size() - 1; i >= 0; --i) {
                        if (CFG.core.getCiv(nCivID).isMovingUnitsToProvID((Integer)tempProvincesTo.get(i))) continue;
                        if (tBest < 0) {
                            tBest = i;
                            fBestScore = this.attackProvince_Score(nCivID, (Integer)tempProvincesFrom.get(i), (Integer)tempProvincesTo.get(i));
                            continue;
                        }
                        float tCurrScore = this.attackProvince_Score(nCivID, (Integer)tempProvincesFrom.get(i), (Integer)tempProvincesTo.get(i));
                        if (fBestScore < this.attackProvince_Score(nCivID, (Integer)tempProvincesFrom.get(i), (Integer)tempProvincesTo.get(i))) {
                            tBest = i;
                            fBestScore = tCurrScore;
                            continue;
                        }
                        if (fBestScore != tCurrScore || CFG.oR.nextInt(100) >= 50) continue;
                        tBest = i;
                        fBestScore = tCurrScore;
                    }
                    if (tBest >= 0) {
                        if (CFG.core.getProv((Integer)tempProvincesFrom.get(tBest)).getArmyID(0) > 0) {
                            CFG.gameAction.moveArmyAction((Integer)tempProvincesFrom.get(tBest), (Integer)tempProvincesTo.get(tBest), CFG.core.getProv((Integer)tempProvincesFrom.get(tBest)).getArmyID(0), nCivID, false, true);
                        }
                    } else {
                        return;
                    }
                    tempProvincesFrom.remove(tBest);
                    tempProvincesTo.remove(tBest);
                    tRandMove = CFG.oR.nextInt(100);
                }
            }
        }
    }

    public final float attackProvince_Score(int nCivID, int nFromProvinceID, int toProvinceID) {
        int ownProvinces = 0;
        int enemyProvinces = 0;
        for (int i = 0; i < CFG.core.getProv(toProvinceID).getNeighProvincesSize(); ++i) {
            if (CFG.core.getProv(CFG.core.getProv(toProvinceID).getNeighProvinces(i)).getCivId() == nCivID) {
                ++ownProvinces;
                continue;
            }
            if (!CFG.core.getCivsAtWar(nCivID, CFG.core.getProv(CFG.core.getProv(toProvinceID).getNeighProvinces(i)).getCivId())) continue;
            ++enemyProvinces;
        }
        try {
            return (float)ownProvinces / (float)(ownProvinces + enemyProvinces) + 0.075f * CFG.core.getProv(toProvinceID).getRevRisk();
        }
        catch (ArithmeticException ex) {
            return 0.0f;
        }
    }
}

