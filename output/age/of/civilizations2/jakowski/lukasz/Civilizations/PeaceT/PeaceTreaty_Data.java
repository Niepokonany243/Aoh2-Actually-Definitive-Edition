/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_Civs;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_Demands;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_DrawData;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_GameData;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.Vassal.PeaceTreaty_ReleaseableVassals;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MapA.Distance;
import java.util.ArrayList;
import java.util.List;

public class PeaceTreaty_Data {
    public PeaceTreaty_GameData peaceTreatyGD = new PeaceTreaty_GameData();
    public List<PeaceTreaty_DrawData> drawProvOwners = new ArrayList<PeaceTreaty_DrawData>();
    public List<Integer> provsLeftToTake = new ArrayList<Integer>();
    public int iProvsLeftToTakeSize = 0;
    public boolean scoreCountDefenders = false;
    public int brushCivID = -1;
    public int playerTurnID = 0;
    public int iLastTakenID = -1;
    public static final float VASSALIZE_COST = 0.4f;
    public static final float WAR_REPARATIONS_COST = 0.1f;

    public PeaceTreaty_Data() {
    }

    public PeaceTreaty_Data(PeaceTreaty_GameData nPeaceTreaty) {
        this.peaceTreatyGD = nPeaceTreaty;
        this.brushCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        this.playerTurnID = CFG.PLAYER_TURN_ID;
        this.prepareProvinceData(false);
        this.prepareDemansVassalsData();
    }

    public PeaceTreaty_Data(int iWarID, boolean scoreCountDefenders) {
        int i;
        ArrayList<Boolean> addDefender = new ArrayList<Boolean>();
        ArrayList<Boolean> addAggressor = new ArrayList<Boolean>();
        for (i = 0; i < CFG.core.getWar(iWarID).getDefendersSize(); ++i) {
            addDefender.add(true);
        }
        for (i = 0; i < CFG.core.getWar(iWarID).getAggressorsSize(); ++i) {
            addAggressor.add(true);
        }
        this.initPeaceTreatyData(iWarID, addDefender, addAggressor, scoreCountDefenders);
    }

    public PeaceTreaty_Data(int iWarID, List<Boolean> addDefender, List<Boolean> addAggressor, boolean scoreCountDefenders) {
        this.initPeaceTreatyData(iWarID, addDefender, addAggressor, scoreCountDefenders);
    }

    public final void AIUseVictoryPoints() {
        try {
            if (CFG.LOGs) System.out.println("AI: AIUseVictoryPoints called. ProvsLeftToTake: " + this.iProvsLeftToTakeSize);
            if (this.iProvsLeftToTakeSize > 0) {
                int i;
                int iBestCivID = -1;
                int tBestPoints = -1;
                for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                    try {
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft > tBestPoints) {
                            iBestCivID = this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID;
                            tBestPoints = this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft;
                            continue;
                        }
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft != tBestPoints || CFG.oR.nextInt(100) >= 50) continue;
                        iBestCivID = this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID;
                        tBestPoints = this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft;
                        continue;
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
                for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                    try {
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft > tBestPoints) {
                            iBestCivID = this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID;
                            tBestPoints = this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft;
                            continue;
                        }
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft != tBestPoints || CFG.oR.nextInt(100) >= 50) continue;
                        iBestCivID = this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID;
                        tBestPoints = this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft;
                        continue;
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
                if (CFG.LOGs) System.out.println("AI: BestCivID: " + iBestCivID + ", Points: " + tBestPoints);
                if (iBestCivID > 0 && tBestPoints > 0 && !CFG.core.getCiv(iBestCivID).getIsPlayer()) {
                    this.AI_UseVictoryPoints_CivID(iBestCivID, tBestPoints);
                }
            }
        }
        catch (StackOverflowError stackOverflowError) {
            if (CFG.LOGs) System.out.println("AI: AIUseVictoryPoints STACK OVERFLOW");
        }
        catch (Exception exception) {
             if (CFG.LOGs) System.out.println("AI: AIUseVictoryPoints EXCEPTION: " + exception.getMessage());
        }
    }

    public final void AI_UseVictoryPoints_CivID_TakeVassal(int nCivID, int pointsLeft, boolean clearPoints) {
        block19: {
            try {
                int i;
                int o;
                int i2;
                ArrayList<Integer> canVassalizeCivs = new ArrayList<Integer>();
                boolean doneCheck = false;
                for (i2 = 0; i2 < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i2) {
                    try {
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).iCivID != nCivID) continue;
                        for (o = 0; o < this.peaceTreatyGD.civsDemandsAggressors.size(); ++o) {
                            if (this.peaceTreatyGD.civsDemandsAggressors.get((int)o).iWillBecomeVassalOfCivID >= 0 || this.getVassalization_Cost(this.peaceTreatyGD.civsDemandsAggressors.get((int)o).iCivID) > pointsLeft) continue;
                            canVassalizeCivs.add(this.peaceTreatyGD.civsDemandsAggressors.get((int)o).iCivID);
                        }
                        doneCheck = true;
                        break;
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
                if (!doneCheck) {
                    try {
                        for (i2 = 0; i2 < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i2) {
                            if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).iCivID != nCivID) continue;
                            for (o = 0; o < this.peaceTreatyGD.civsDemandsDefenders.size(); ++o) {
                                if (this.peaceTreatyGD.civsDemandsDefenders.get((int)o).iWillBecomeVassalOfCivID >= 0 || this.getVassalization_Cost(this.peaceTreatyGD.civsDemandsDefenders.get((int)o).iCivID) > pointsLeft) continue;
                                canVassalizeCivs.add(this.peaceTreatyGD.civsDemandsDefenders.get((int)o).iCivID);
                            }
                            doneCheck = true;
                            break;
                        }
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
                if (!canVassalizeCivs.isEmpty()) {
                    this.takeVassalize((Integer)canVassalizeCivs.get(CFG.oR.nextInt(canVassalizeCivs.size())), nCivID, nCivID);
                    this.AIUseVictoryPoints();
                    return;
                }
                if (!clearPoints) break block19;
                for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                    try {
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != nCivID) continue;
                        this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft = 0;
                        this.AIUseVictoryPoints();
                        return;
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
                for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                    try {
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != nCivID) continue;
                        this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft = 0;
                        this.AIUseVictoryPoints();
                        return;
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public final void AI_UseVictoryPoints_CivID(int nCivID, int pointsLeft) {
        try {
            if (CFG.LOGs) System.out.println("AI: AI_UseVictoryPoints_CivID for civ: " + nCivID + ", pointsLeft: " + pointsLeft + ", ProvsLeft: " + this.iProvsLeftToTakeSize);
            int i;
            ArrayList<Float> lScores = new ArrayList<Float>();
            ArrayList<Boolean> lNeigh = new ArrayList<Boolean>();
            ArrayList<Integer> toTake = new ArrayList<Integer>();
            boolean canTakeNieghProvince = false;
            float maxDistance = 1.0E-4f;
            for (int i2 = 0; i2 < this.iProvsLeftToTakeSize; ++i2) {
                if (pointsLeft < this.drawProvOwners.get((int)this.provsLeftToTake.get((int)i2).intValue()).iProvinceValue) continue;
                maxDistance = Math.max(maxDistance, Distance.getDistanceFromCapital(CFG.core.getCiv(nCivID).getCapitalProvID(), this.provsLeftToTake.get(i2)));
                if (CFG.core.getProv(this.provsLeftToTake.get(i2)).getTrueOwnerOfProv() == nCivID) {
                    lScores.add(Float.valueOf(this.AI_UseVictoryPoints_CivID_Score(nCivID, this.provsLeftToTake.get(i2), 10.0f)));
                    lNeigh.add(true);
                    toTake.add(this.provsLeftToTake.get(i2));
                    canTakeNieghProvince = true;
                    continue;
                }
                boolean tempProvinceAdded = false;
                for (int j = 0; j < CFG.core.getProv(this.provsLeftToTake.get(i2)).getNeighProvincesSize(); ++j) {
                    if (this.drawProvOwners.get((int)CFG.core.getProv((int)this.provsLeftToTake.get((int)i2).intValue()).getNeighProvinces((int)j)).iCivID != nCivID) continue;
                    if (CFG.core.getProv(this.provsLeftToTake.get(i2)).getCores().getHaveACore(nCivID)) {
                        tempProvinceAdded = true;
                        lScores.add(Float.valueOf(this.AI_UseVictoryPoints_CivID_Score(nCivID, this.provsLeftToTake.get(i2), 5.0f)));
                        lNeigh.add(true);
                        toTake.add(this.provsLeftToTake.get(i2));
                        canTakeNieghProvince = true;
                        break;
                    }
                    lScores.add(Float.valueOf(this.AI_UseVictoryPoints_CivID_Score(nCivID, this.provsLeftToTake.get(i2), 4.25f)));
                    lNeigh.add(true);
                    toTake.add(this.provsLeftToTake.get(i2));
                    tempProvinceAdded = true;
                    canTakeNieghProvince = true;
                    break;
                }
                if (tempProvinceAdded) continue;
                if (CFG.core.getProv(this.provsLeftToTake.get(i2)).getCores().getHaveACore(nCivID)) {
                    lScores.add(Float.valueOf(this.AI_UseVictoryPoints_CivID_Score(nCivID, this.provsLeftToTake.get(i2), 1.75f)));
                    lNeigh.add(true);
                    toTake.add(this.provsLeftToTake.get(i2));
                    canTakeNieghProvince = true;
                    continue;
                }
                if (CFG.core.getProv(this.provsLeftToTake.get(i2)).getNeighSeaProvincesSize() > 0) {
                    lScores.add(Float.valueOf(this.AI_UseVictoryPoints_CivID_Score(nCivID, this.provsLeftToTake.get(i2), 0.325f)));
                    lNeigh.add(true);
                    toTake.add(this.provsLeftToTake.get(i2));
                    canTakeNieghProvince = true;
                    continue;
                }
                lScores.add(Float.valueOf(this.AI_UseVictoryPoints_CivID_Score(nCivID, this.provsLeftToTake.get(i2), 0.025f)));
                lNeigh.add(false);
                toTake.add(this.provsLeftToTake.get(i2));
            }
            if (lNeigh.isEmpty() || toTake.isEmpty()) {
                if (CFG.LOGs) System.out.println("AI: No provinces can be taken by this civ. pointsLeft: " + pointsLeft);
                this.AI_UseVictoryPoints_CivID_TakeVassal(nCivID, pointsLeft, true);
                return;
            }
            if (!canTakeNieghProvince) {
                if (CFG.LOGs) System.out.println("AI: No neighboring provinces can be taken. pointsLeft: " + pointsLeft);
                this.AI_UseVictoryPoints_CivID_TakeVassal(nCivID, pointsLeft, true);
                return;
            }
            int tBest = 0;
            for (i = lScores.size() - 1; i > 0; --i) {
                lScores.set(i, Float.valueOf(((Float)lScores.get(i)).floatValue() * (0.8f + 0.2f * (1.0f - Distance.getDistanceFromCapital(CFG.core.getCiv(nCivID).getCapitalProvID(), (Integer)toTake.get(i)) / maxDistance)) * (this.iLastTakenID == (Integer)toTake.get(i) ? 0.05f : 1.0f)));
            }
            for (i = lScores.size() - 1; i > 0; --i) {
                if (!(((Float)lScores.get(tBest)).floatValue() < ((Float)lScores.get(i)).floatValue())) continue;
                tBest = i;
            }
            if (CFG.LOGs) System.out.println("AI: Taking best province: " + toTake.get(tBest) + ", score: " + lScores.get(tBest));
            if (((Boolean)lNeigh.get(tBest)).booleanValue()) {
                if (!this.takeProvince((Integer)toTake.get(tBest), nCivID, nCivID)) {
                    for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != nCivID) continue;
                        this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft = 0;
                        this.AIUseVictoryPoints();
                        return;
                    }
                    for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != nCivID) continue;
                        this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft = 0;
                        this.AIUseVictoryPoints();
                        return;
                    }
                } else {
                    this.AIUseVictoryPoints();
                    return;
                }
            } else if (toTake.size() == 1) {
                if (!this.takeProvince((Integer)toTake.get(tBest), nCivID, nCivID)) {
                    for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != nCivID) continue;
                        this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft = 0;
                        this.AIUseVictoryPoints();
                        return;
                    }
                    for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != nCivID) continue;
                        this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft = 0;
                        this.AIUseVictoryPoints();
                        return;
                    }
                } else {
                    this.AIUseVictoryPoints();
                    return;
                }
            } else {
                for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != nCivID) continue;
                    this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft = 0;
                    this.AIUseVictoryPoints();
                    return;
                }
                for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != nCivID) continue;
                    this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft = 0;
                    this.AIUseVictoryPoints();
                    return;
                }
            }
            this.AI_UseVictoryPoints_CivID_TakeVassal(nCivID, pointsLeft, true);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final float AI_UseVictoryPoints_CivID_Score(int nCivID, int nProvinceID, float modifier) {
        int neigh_OwnProvinces = 0;
        int neigh_OtherCivsProvinces = 0;
        try {
            for (int i = 0; i < CFG.core.getProv(nProvinceID).getNeighProvincesSize(); ++i) {
                if (CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighProvinces(i)).getWastelandLvl() >= 0 || CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighProvinces(i)).getCivId() <= 0) continue;
                if (this.drawProvOwners.get((int)CFG.core.getProv((int)nProvinceID).getNeighProvinces((int)i)).iCivID == nCivID) {
                    ++neigh_OwnProvinces;
                    continue;
                }
                ++neigh_OtherCivsProvinces;
            }
            if (CFG.core.getProv(nProvinceID).getNeighSeaProvincesSize() > 0) {
                ++neigh_OwnProvinces;
            }
            neigh_OtherCivsProvinces = Math.max(1, neigh_OtherCivsProvinces);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return modifier + ((float)neigh_OwnProvinces * (modifier * 0.125f) + modifier * (float)(neigh_OwnProvinces / (neigh_OwnProvinces + neigh_OtherCivsProvinces)) + 0.125f * (float)CFG.core.getProv(nProvinceID).getPop().getPops() / (float)CFG.core.getGameScenars().getScenario_StartingPopulation() + 0.05f * (float)CFG.core.getProv(nProvinceID).getEco() / (float)CFG.core.getGameScenars().getScenario_StartingEconomy() + 0.0075f * CFG.core.getProv(nProvinceID).getDeveLvl());
    }

    public final void addProvincesLeftToTake(int nProvinceID) {
        for (int i = 0; i < this.iProvsLeftToTakeSize; ++i) {
            if (this.provsLeftToTake.get(i) != nProvinceID) continue;
            return;
        }
        this.provsLeftToTake.add(nProvinceID);
        this.iProvsLeftToTakeSize = this.provsLeftToTake.size();
    }

    public final void removeProvincesLeftToTake(int nProvinceID) {
        for (int i = 0; i < this.iProvsLeftToTakeSize; ++i) {
            if (this.provsLeftToTake.get(i) != nProvinceID) continue;
            this.provsLeftToTake.remove(i);
            this.iProvsLeftToTakeSize = this.provsLeftToTake.size();
            return;
        }
    }

    private final void initPeaceTreatyData(int iWarID, List<Boolean> addDefender, List<Boolean> addAggressor, boolean scoreCountDefenders) {
        try {
            int i;
            this.peaceTreatyGD.iWarID = iWarID;
            this.peaceTreatyGD.WAR_TAG = CFG.core.getWar((int)iWarID).WAR_TAG;
            this.scoreCountDefenders = scoreCountDefenders;
            for (i = 0; i < CFG.core.getWar(iWarID).getDefendersSize(); ++i) {
                try {
                    if (!addDefender.get(i).booleanValue()) continue;
                    this.peaceTreatyGD.civsDataDefenders.add(CFG.core.getWar(iWarID).getDefenders_ProvincesLost(i, addDefender, addAggressor));
                    this.peaceTreatyGD.civsDemandsDefenders.add(new PeaceTreaty_Demands(CFG.core.getWar(iWarID).getDefenderID(i).getCivID(), CFG.core.getWar(iWarID).getWarScore_DefendersInProvinceValue_OnlyPositive(i, addDefender, addAggressor)));
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            for (i = 0; i < CFG.core.getWar(iWarID).getAggressorsSize(); ++i) {
                try {
                    if (!addAggressor.get(i).booleanValue()) continue;
                    this.peaceTreatyGD.civsDataAggressors.add(CFG.core.getWar(iWarID).getAggressors_ProvincesLost(i, addDefender, addAggressor));
                    this.peaceTreatyGD.civsDemandsAggressors.add(new PeaceTreaty_Demands(CFG.core.getWar(iWarID).getAggressorID(i).getCivID(), CFG.core.getWar(iWarID).getWarScore_AggressorsInProvinceValue_OnlyPositive(i, addDefender, addAggressor)));
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            this.redistributePointsToLords();
            this.brushCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
            this.playerTurnID = CFG.PLAYER_TURN_ID;
            this.prepareProvinceData(true);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void redistributePointsToLords() {
        if (GameValues.gvPeaceTreaty.REDISTRIBUTE_VASSAL_POINTS_TO_LORD) {
            int j;
            int i;
            int n = i = GameValues.gvPeaceTreaty.REDISTRIBUTE_VASSAL_POINTS_TO_LORD_WHEN_ARE_WAR_LEADERS ? 0 : 1;
            while (i < this.peaceTreatyGD.civsDemandsDefenders.size()) {
                if (!CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID).getIsPlayer() && CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID).getPuppetOfCiv() != this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID) {
                    for (j = 0; j < this.peaceTreatyGD.civsDemandsDefenders.size(); ++j) {
                        if (i == j || CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID).getPuppetOfCiv() != this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iCivID) continue;
                        this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft += this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft;
                        this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft = 0;
                        break;
                    }
                }
                ++i;
            }
            int n2 = i = GameValues.gvPeaceTreaty.REDISTRIBUTE_VASSAL_POINTS_TO_LORD_WHEN_ARE_WAR_LEADERS ? 0 : 1;
            while (i < this.peaceTreatyGD.civsDemandsAggressors.size()) {
                if (!CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID).getIsPlayer() && CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID).getPuppetOfCiv() != this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID) {
                    for (j = 0; j < this.peaceTreatyGD.civsDemandsAggressors.size(); ++j) {
                        if (i == j || CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID).getPuppetOfCiv() != this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iCivID) continue;
                        this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft += this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft;
                        this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft = 0;
                        break;
                    }
                }
                ++i;
            }
        }
    }

    public final void prepareProvinceData(boolean buildProvincesLost) {
        block121: {
            try {
                int i;
                this.drawProvOwners.clear();
                this.drawProvOwners = new ArrayList<PeaceTreaty_DrawData>();
                ArrayList<Boolean> tempParticipants = new ArrayList<Boolean>();
                for (i = 0; i < CFG.core.getCivsSize(); ++i) {
                    tempParticipants.add(false);
                }
                for (i = 0; i < this.peaceTreatyGD.civsDataDefenders.size(); ++i) {
                    if (this.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID <= 0) continue;
                    tempParticipants.set(this.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID, true);
                }
                for (i = 0; i < this.peaceTreatyGD.civsDataAggressors.size(); ++i) {
                    if (this.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID <= 0) continue;
                    tempParticipants.set(this.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID, true);
                }
                for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                    int provID = CFG.core.getProv(i).getCivId();
                    if (provID >= 0) {
                        if (((Boolean)tempParticipants.get(CFG.core.getProv(i).getCivId())).booleanValue()) {
                            this.drawProvOwners.add(new PeaceTreaty_DrawData(CFG.core.getProv(i).getCivId(), CFG.core.getProvinceValue(i), false));
                            continue;
                        }
                        this.drawProvOwners.add(new PeaceTreaty_DrawData(CFG.core.getProv(i).getCivId() * -1, CFG.core.getProvinceValue(i), false));
                        continue;
                    }
                    this.drawProvOwners.add(new PeaceTreaty_DrawData(CFG.core.getProv(i).getCivId() * -1, CFG.core.getProvinceValue(i), false));
                }
                if (buildProvincesLost) {
                    int j;
                    int k;
                    boolean tAdd;
                    int u;
                    int i2;
                    try {
                        for (i = this.peaceTreatyGD.civsDataDefenders.size() - 1; i >= 0; --i) {
                            try {
                                for (int j2 = this.peaceTreatyGD.civsDataDefenders.get((int)i).lProvincesLost.size() - 1; j2 >= 0; --j2) {
                                    this.drawProvOwners.get((int)this.peaceTreatyGD.civsDataDefenders.get((int)i).lProvincesLost.get((int)j2).intValue()).isToTake = true;
                                    this.drawProvOwners.get((int)this.peaceTreatyGD.civsDataDefenders.get((int)i).lProvincesLost.get((int)j2).intValue()).iCivID = CFG.core.getProv(this.peaceTreatyGD.civsDataDefenders.get((int)i).lProvincesLost.get(j2)).getTrueOwnerOfProv();
                                    this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iTotalNumOfVicotryPoints += CFG.core.getProvinceValue(this.peaceTreatyGD.civsDataDefenders.get((int)i).lProvincesLost.get(j2));
                                }
                            }
                            catch (Exception ex) {
                                CFG.exceptionStack(ex);
                            }
                            try {
                                for (int j3 = 0; j3 < CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID).getNumOfProvs(); ++j3) {
                                    this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iTotalNumOfVicotryPoints += CFG.core.getProvinceValue(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID).getProvID(j3));
                                }
                                continue;
                            }
                            catch (Exception ex) {
                                CFG.exceptionStack(ex);
                            }
                        }
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                    try {
                        for (int i3 = this.peaceTreatyGD.civsDataAggressors.size() - 1; i3 >= 0; --i3) {
                            try {
                                for (int j4 = this.peaceTreatyGD.civsDataAggressors.get((int)i3).lProvincesLost.size() - 1; j4 >= 0; --j4) {
                                    this.drawProvOwners.get((int)this.peaceTreatyGD.civsDataAggressors.get((int)i3).lProvincesLost.get((int)j4).intValue()).isToTake = true;
                                    this.drawProvOwners.get((int)this.peaceTreatyGD.civsDataAggressors.get((int)i3).lProvincesLost.get((int)j4).intValue()).iCivID = CFG.core.getProv(this.peaceTreatyGD.civsDataAggressors.get((int)i3).lProvincesLost.get(j4)).getTrueOwnerOfProv();
                                    this.peaceTreatyGD.civsDemandsAggressors.get((int)i3).iTotalNumOfVicotryPoints += CFG.core.getProvinceValue(this.peaceTreatyGD.civsDataAggressors.get((int)i3).lProvincesLost.get(j4));
                                }
                            }
                            catch (Exception ex) {
                                CFG.exceptionStack(ex);
                            }
                            try {
                                for (int j5 = 0; j5 < CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i3).iCivID).getNumOfProvs(); ++j5) {
                                    this.peaceTreatyGD.civsDemandsAggressors.get((int)i3).iTotalNumOfVicotryPoints += CFG.core.getProvinceValue(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i3).iCivID).getProvID(j5));
                                }
                                continue;
                            }
                            catch (Exception ex) {
                                CFG.exceptionStack(ex);
                            }
                        }
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                    for (i2 = this.peaceTreatyGD.civsDemandsAggressors.size() - 1; i2 >= 0; --i2) {
                        this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).lReleasableCivs = new ArrayList<PeaceTreaty_ReleaseableVassals>();
                        try {
                            for (int j6 = 0; j6 < CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).iCivID).getNumOfProvs(); ++j6) {
                                if (CFG.core.getProv(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).iCivID).getProvID(j6)).isOccupied()) continue;
                                for (u = 0; u < CFG.core.getProv(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).iCivID).getProvID(j6)).getCores().getCivsSize(); ++u) {
                                    if (CFG.core.getProv(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).iCivID).getProvID(j6)).getCores().getCivID(u) == CFG.core.getProv(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).iCivID).getProvID(j6)).getCivId() || CFG.core.getCiv(CFG.core.getProv(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).iCivID).getProvID(j6)).getCores().getCivID(u)).getNumOfProvs() != 0) continue;
                                    tAdd = true;
                                    for (k = this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).lReleasableCivs.size() - 1; k >= 0; --k) {
                                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).lReleasableCivs.get((int)k).iCivID != CFG.core.getProv(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).iCivID).getProvID(j6)).getCores().getCivID(u)) continue;
                                        tAdd = false;
                                        this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).lReleasableCivs.get(k).addProvince(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).iCivID).getProvID(j6));
                                        break;
                                    }
                                    if (!tAdd) continue;
                                    this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).lReleasableCivs.add(new PeaceTreaty_ReleaseableVassals(CFG.core.getProv(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).iCivID).getProvID(j6)).getCores().getCivID(u), CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).iCivID).getProvID(j6)));
                                }
                            }
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                        try {
                            for (int o = this.peaceTreatyGD.civsDataAggressors.get((int)i2).lProvincesLost.size() - 1; o >= 0; --o) {
                                for (j = 0; j < CFG.core.getProv(this.peaceTreatyGD.civsDataAggressors.get((int)i2).lProvincesLost.get(o)).getCores().getCivsSize(); ++j) {
                                    if (CFG.core.getProv(this.peaceTreatyGD.civsDataAggressors.get((int)i2).lProvincesLost.get(o)).getCores().getCivID(j) == CFG.core.getProv(this.peaceTreatyGD.civsDataAggressors.get((int)i2).lProvincesLost.get(o)).getCivId() || CFG.core.getCiv(CFG.core.getProv(this.peaceTreatyGD.civsDataAggressors.get((int)i2).lProvincesLost.get(o)).getCores().getCivID(j)).getNumOfProvs() != 0) continue;
                                    tAdd = true;
                                    for (k = this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).lReleasableCivs.size() - 1; k >= 0; --k) {
                                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).lReleasableCivs.get((int)k).iCivID != CFG.core.getProv(this.peaceTreatyGD.civsDataAggressors.get((int)i2).lProvincesLost.get(o)).getCores().getCivID(j)) continue;
                                        tAdd = false;
                                        this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).lReleasableCivs.get(k).addProvince(this.peaceTreatyGD.civsDataAggressors.get((int)i2).lProvincesLost.get(o));
                                        break;
                                    }
                                    if (!tAdd) continue;
                                    this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).lReleasableCivs.add(new PeaceTreaty_ReleaseableVassals(CFG.core.getProv(this.peaceTreatyGD.civsDataAggressors.get((int)i2).lProvincesLost.get(o)).getCores().getCivID(j), this.peaceTreatyGD.civsDataAggressors.get((int)i2).lProvincesLost.get(o)));
                                }
                            }
                            continue;
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                    }
                    for (i2 = this.peaceTreatyGD.civsDemandsDefenders.size() - 1; i2 >= 0; --i2) {
                        this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).lReleasableCivs = new ArrayList<PeaceTreaty_ReleaseableVassals>();
                        try {
                            for (int j7 = 0; j7 < CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).iCivID).getNumOfProvs(); ++j7) {
                                if (CFG.core.getProv(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).iCivID).getProvID(j7)).isOccupied()) continue;
                                for (u = 0; u < CFG.core.getProv(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).iCivID).getProvID(j7)).getCores().getCivsSize(); ++u) {
                                    if (CFG.core.getProv(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).iCivID).getProvID(j7)).getCores().getCivID(u) == CFG.core.getProv(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).iCivID).getProvID(j7)).getCivId() || CFG.core.getCiv(CFG.core.getProv(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).iCivID).getProvID(j7)).getCores().getCivID(u)).getNumOfProvs() != 0) continue;
                                    tAdd = true;
                                    for (k = this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).lReleasableCivs.size() - 1; k >= 0; --k) {
                                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).lReleasableCivs.get((int)k).iCivID != CFG.core.getProv(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).iCivID).getProvID(j7)).getCores().getCivID(u)) continue;
                                        tAdd = false;
                                        this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).lReleasableCivs.get(k).addProvince(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).iCivID).getProvID(j7));
                                        break;
                                    }
                                    if (!tAdd) continue;
                                    this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).lReleasableCivs.add(new PeaceTreaty_ReleaseableVassals(CFG.core.getProv(CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).iCivID).getProvID(j7)).getCores().getCivID(u), CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).iCivID).getProvID(j7)));
                                }
                            }
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                        try {
                            for (int o = this.peaceTreatyGD.civsDataDefenders.get((int)i2).lProvincesLost.size() - 1; o >= 0; --o) {
                                for (j = 0; j < CFG.core.getProv(this.peaceTreatyGD.civsDataDefenders.get((int)i2).lProvincesLost.get(o)).getCores().getCivsSize(); ++j) {
                                    if (CFG.core.getProv(this.peaceTreatyGD.civsDataDefenders.get((int)i2).lProvincesLost.get(o)).getCores().getCivID(j) == CFG.core.getProv(this.peaceTreatyGD.civsDataDefenders.get((int)i2).lProvincesLost.get(o)).getCivId() || CFG.core.getCiv(CFG.core.getProv(this.peaceTreatyGD.civsDataDefenders.get((int)i2).lProvincesLost.get(o)).getCores().getCivID(j)).getNumOfProvs() != 0) continue;
                                    tAdd = true;
                                    for (k = this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).lReleasableCivs.size() - 1; k >= 0; --k) {
                                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).lReleasableCivs.get((int)k).iCivID != CFG.core.getProv(this.peaceTreatyGD.civsDataDefenders.get((int)i2).lProvincesLost.get(o)).getCores().getCivID(j)) continue;
                                        tAdd = false;
                                        this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).lReleasableCivs.get(k).addProvince(this.peaceTreatyGD.civsDataDefenders.get((int)i2).lProvincesLost.get(o));
                                        break;
                                    }
                                    if (!tAdd) continue;
                                    this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).lReleasableCivs.add(new PeaceTreaty_ReleaseableVassals(CFG.core.getProv(this.peaceTreatyGD.civsDataDefenders.get((int)i2).lProvincesLost.get(o)).getCores().getCivID(j), this.peaceTreatyGD.civsDataDefenders.get((int)i2).lProvincesLost.get(o)));
                                }
                            }
                            continue;
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                    }
                    try {
                        for (i2 = this.drawProvOwners.size() - 1; i2 >= 0; --i2) {
                            if (!this.drawProvOwners.get((int)i2).isToTake) continue;
                            this.provsLeftToTake.add(i2);
                        }
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                    this.iProvsLeftToTakeSize = this.provsLeftToTake.size();
                    break block121;
                }
                try {
                    int o;
                    int k;
                    int i4;
                    int k2;
                    boolean isAdded;
                    boolean addCiv;
                    int i5;
                    ArrayList<Boolean> addDefender = new ArrayList<Boolean>();
                    ArrayList<Boolean> addAggressor = new ArrayList<Boolean>();
                    for (i5 = 0; i5 < CFG.core.getWarsSize(); ++i5) {
                        if (!CFG.core.getWar((int)i5).WAR_TAG.equals(this.peaceTreatyGD.WAR_TAG)) continue;
                        this.peaceTreatyGD.iWarID = i5;
                        break;
                    }
                    for (i5 = 0; i5 < CFG.core.getWar(this.peaceTreatyGD.iWarID).getDefendersSize(); ++i5) {
                        addCiv = false;
                        try {
                            for (int j = this.peaceTreatyGD.civsDataDefenders.size() - 1; j >= 0; --j) {
                                if (CFG.core.getWar(this.peaceTreatyGD.iWarID).getDefenderID(i5).getCivID() != this.peaceTreatyGD.civsDataDefenders.get((int)j).iCivID) continue;
                                addCiv = true;
                                break;
                            }
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                        addDefender.add(addCiv);
                    }
                    for (i5 = 0; i5 < CFG.core.getWar(this.peaceTreatyGD.iWarID).getAggressorsSize(); ++i5) {
                        addCiv = false;
                        try {
                            for (int j = this.peaceTreatyGD.civsDataAggressors.size() - 1; j >= 0; --j) {
                                if (CFG.core.getWar(this.peaceTreatyGD.iWarID).getAggressorID(i5).getCivID() != this.peaceTreatyGD.civsDataAggressors.get((int)j).iCivID) continue;
                                addCiv = true;
                                break;
                            }
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                        addAggressor.add(addCiv);
                    }
                    try {
                        for (i5 = this.peaceTreatyGD.civsDataDefenders.size() - 1; i5 >= 0; --i5) {
                            try {
                                PeaceTreaty_Civs tempLost = CFG.core.getWar(this.peaceTreatyGD.iWarID).getDefenders_ProvincesLost(CFG.core.getWar(this.peaceTreatyGD.iWarID).getDefenderID_ByCivID(this.peaceTreatyGD.civsDataDefenders.get((int)i5).iCivID), addDefender, addAggressor);
                                for (int j = tempLost.lProvincesLost.size() - 1; j >= 0; --j) {
                                    isAdded = false;
                                    for (k2 = this.peaceTreatyGD.civsDataDefenders.get((int)i5).lProvincesLost.size() - 1; k2 >= 0; --k2) {
                                        if (!tempLost.lProvincesLost.get(j).equals(this.peaceTreatyGD.civsDataDefenders.get((int)i5).lProvincesLost.get(k2))) continue;
                                        isAdded = true;
                                        break;
                                    }
                                    if (!isAdded) {
                                        this.peaceTreatyGD.civsDataDefenders.get((int)i5).lProvincesLost.add(tempLost.lProvincesLost.get(j));
                                        this.makeDemand_Province(tempLost.lProvincesLost.get(j), this.peaceTreatyGD.civsDataDefenders.get((int)i5).iCivID, this.peaceTreatyGD.civsDataDefenders.get((int)i5).iCivID, true);
                                    }
                                    tempLost.lProvincesLost.remove(j);
                                }
                                continue;
                            }
                            catch (Exception exr) {
                                CFG.exceptionStack(exr);
                            }
                        }
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                    try {
                        for (int i6 = this.peaceTreatyGD.civsDataAggressors.size() - 1; i6 >= 0; --i6) {
                            try {
                                PeaceTreaty_Civs tempLost = CFG.core.getWar(this.peaceTreatyGD.iWarID).getAggressors_ProvincesLost(CFG.core.getWar(this.peaceTreatyGD.iWarID).getAggressorID_ByCivID(this.peaceTreatyGD.civsDataAggressors.get((int)i6).iCivID), addDefender, addAggressor);
                                for (int j = tempLost.lProvincesLost.size() - 1; j >= 0; --j) {
                                    isAdded = false;
                                    for (k2 = this.peaceTreatyGD.civsDataAggressors.get((int)i6).lProvincesLost.size() - 1; k2 >= 0; --k2) {
                                        if (!tempLost.lProvincesLost.get(j).equals(this.peaceTreatyGD.civsDataAggressors.get((int)i6).lProvincesLost.get(k2))) continue;
                                        isAdded = true;
                                        break;
                                    }
                                    if (!isAdded) {
                                        this.peaceTreatyGD.civsDataAggressors.get((int)i6).lProvincesLost.add(tempLost.lProvincesLost.get(j));
                                        this.makeDemand_Province(tempLost.lProvincesLost.get(j), this.peaceTreatyGD.civsDataAggressors.get((int)i6).iCivID, this.peaceTreatyGD.civsDataAggressors.get((int)i6).iCivID, true);
                                    }
                                    tempLost.lProvincesLost.remove(j);
                                }
                                continue;
                            }
                            catch (Exception exr) {
                                CFG.exceptionStack(exr);
                            }
                        }
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                    for (i4 = this.peaceTreatyGD.civsDataDefenders.size() - 1; i4 >= 0; --i4) {
                        try {
                            if (CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsAggressor(this.peaceTreatyGD.civsDataDefenders.get((int)i4).iCivID) || CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsDefender(this.peaceTreatyGD.civsDataDefenders.get((int)i4).iCivID)) {
                                for (int j = this.peaceTreatyGD.civsDataDefenders.get((int)i4).lProvincesLost.size() - 1; j >= 0; --j) {
                                    boolean removed;
                                    if (CFG.core.getProv(this.peaceTreatyGD.civsDataDefenders.get((int)i4).lProvincesLost.get(j)).isOccupied()) {
                                        if (CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsDefender(CFG.core.getProv(this.peaceTreatyGD.civsDataDefenders.get((int)i4).lProvincesLost.get(j)).getCivId()) || CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsAggressor(CFG.core.getProv(this.peaceTreatyGD.civsDataDefenders.get((int)i4).lProvincesLost.get(j)).getCivId())) {
                                            this.drawProvOwners.get((int)this.peaceTreatyGD.civsDataDefenders.get((int)i4).lProvincesLost.get((int)j).intValue()).isToTake = true;
                                            this.drawProvOwners.get((int)this.peaceTreatyGD.civsDataDefenders.get((int)i4).lProvincesLost.get((int)j).intValue()).iCivID = CFG.core.getProv(this.peaceTreatyGD.civsDataDefenders.get((int)i4).lProvincesLost.get(j)).getTrueOwnerOfProv();
                                            continue;
                                        }
                                        removed = false;
                                        block84: for (k = this.peaceTreatyGD.civsDemandsAggressors.size() - 1; k >= 0; --k) {
                                            for (o = this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lDemands.size() - 1; o >= 0; --o) {
                                                if (this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lDemands.get(o) != this.peaceTreatyGD.civsDataDefenders.get((int)i4).lProvincesLost.get(j)) continue;
                                                this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lDemands.remove(o);
                                                k = -1;
                                                removed = true;
                                                continue block84;
                                            }
                                        }
                                        if (!removed) {
                                            block86: for (k = this.peaceTreatyGD.civsDemandsDefenders.size() - 1; k >= 0; --k) {
                                                for (o = this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lDemands.size() - 1; o >= 0; --o) {
                                                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lDemands.get(o) != this.peaceTreatyGD.civsDataDefenders.get((int)i4).lProvincesLost.get(j)) continue;
                                                    this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lDemands.remove(o);
                                                    k = -1;
                                                    removed = true;
                                                    continue block86;
                                                }
                                            }
                                        }
                                        this.peaceTreatyGD.civsDataDefenders.get((int)i4).lProvincesLost.remove(j);
                                        continue;
                                    }
                                    removed = false;
                                    block88: for (k = this.peaceTreatyGD.civsDemandsAggressors.size() - 1; k >= 0; --k) {
                                        for (o = this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lDemands.size() - 1; o >= 0; --o) {
                                            if (this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lDemands.get(o) != this.peaceTreatyGD.civsDataDefenders.get((int)i4).lProvincesLost.get(j)) continue;
                                            this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lDemands.remove(o);
                                            k = -1;
                                            removed = true;
                                            continue block88;
                                        }
                                    }
                                    if (!removed) {
                                        block90: for (k = this.peaceTreatyGD.civsDemandsDefenders.size() - 1; k >= 0; --k) {
                                            for (o = this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lDemands.size() - 1; o >= 0; --o) {
                                                if (this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lDemands.get(o) != this.peaceTreatyGD.civsDataDefenders.get((int)i4).lProvincesLost.get(j)) continue;
                                                this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lDemands.remove(o);
                                                k = -1;
                                                removed = true;
                                                continue block90;
                                            }
                                        }
                                    }
                                    this.peaceTreatyGD.civsDataDefenders.get((int)i4).lProvincesLost.remove(j);
                                }
                                continue;
                            }
                            this.peaceTreatyGD.civsDataDefenders.remove(i4);
                            this.peaceTreatyGD.civsDemandsDefenders.remove(i4);
                            continue;
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                    }
                    for (i4 = this.peaceTreatyGD.civsDataAggressors.size() - 1; i4 >= 0; --i4) {
                        try {
                            if (CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsAggressor(this.peaceTreatyGD.civsDataAggressors.get((int)i4).iCivID) || CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsDefender(this.peaceTreatyGD.civsDataAggressors.get((int)i4).iCivID)) {
                                for (int j = this.peaceTreatyGD.civsDataAggressors.get((int)i4).lProvincesLost.size() - 1; j >= 0; --j) {
                                    boolean removed;
                                    if (CFG.core.getProv(this.peaceTreatyGD.civsDataAggressors.get((int)i4).lProvincesLost.get(j)).isOccupied()) {
                                        if (CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsDefender(CFG.core.getProv(this.peaceTreatyGD.civsDataAggressors.get((int)i4).lProvincesLost.get(j)).getCivId()) || CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsAggressor(CFG.core.getProv(this.peaceTreatyGD.civsDataAggressors.get((int)i4).lProvincesLost.get(j)).getCivId())) {
                                            this.drawProvOwners.get((int)this.peaceTreatyGD.civsDataAggressors.get((int)i4).lProvincesLost.get((int)j).intValue()).isToTake = true;
                                            this.drawProvOwners.get((int)this.peaceTreatyGD.civsDataAggressors.get((int)i4).lProvincesLost.get((int)j).intValue()).iCivID = CFG.core.getProv(this.peaceTreatyGD.civsDataAggressors.get((int)i4).lProvincesLost.get(j)).getTrueOwnerOfProv();
                                            continue;
                                        }
                                        removed = false;
                                        block94: for (k = this.peaceTreatyGD.civsDemandsDefenders.size() - 1; k >= 0; --k) {
                                            for (o = this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lDemands.size() - 1; o >= 0; --o) {
                                                if (this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lDemands.get(o) != this.peaceTreatyGD.civsDataAggressors.get((int)i4).lProvincesLost.get(j)) continue;
                                                this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lDemands.remove(o);
                                                k = -1;
                                                removed = true;
                                                continue block94;
                                            }
                                        }
                                        if (!removed) {
                                            block96: for (k = this.peaceTreatyGD.civsDemandsAggressors.size() - 1; k >= 0; --k) {
                                                for (o = this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lDemands.size() - 1; o >= 0; --o) {
                                                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lDemands.get(o) != this.peaceTreatyGD.civsDataAggressors.get((int)i4).lProvincesLost.get(j)) continue;
                                                    this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lDemands.remove(o);
                                                    k = -1;
                                                    removed = true;
                                                    continue block96;
                                                }
                                            }
                                        }
                                        this.peaceTreatyGD.civsDataAggressors.get((int)i4).lProvincesLost.remove(j);
                                        continue;
                                    }
                                    removed = false;
                                    block98: for (k = this.peaceTreatyGD.civsDemandsDefenders.size() - 1; k >= 0; --k) {
                                        for (o = this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lDemands.size() - 1; o >= 0; --o) {
                                            if (this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lDemands.get(o) != this.peaceTreatyGD.civsDataAggressors.get((int)i4).lProvincesLost.get(j)) continue;
                                            this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lDemands.remove(o);
                                            k = -1;
                                            removed = true;
                                            continue block98;
                                        }
                                    }
                                    if (!removed) {
                                        block100: for (k = this.peaceTreatyGD.civsDemandsAggressors.size() - 1; k >= 0; --k) {
                                            for (o = this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lDemands.size() - 1; o >= 0; --o) {
                                                if (this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lDemands.get(o) != this.peaceTreatyGD.civsDataAggressors.get((int)i4).lProvincesLost.get(j)) continue;
                                                this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lDemands.remove(o);
                                                k = -1;
                                                removed = true;
                                                continue block100;
                                            }
                                        }
                                    }
                                    this.peaceTreatyGD.civsDataAggressors.get((int)i4).lProvincesLost.remove(j);
                                }
                                continue;
                            }
                            this.peaceTreatyGD.civsDataAggressors.remove(i4);
                            this.peaceTreatyGD.civsDemandsAggressors.remove(i4);
                            continue;
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                    }
                    try {
                        for (i4 = this.peaceTreatyGD.civsDemandsDefenders.size() - 1; i4 >= 0; --i4) {
                            for (int j = this.peaceTreatyGD.civsDemandsDefenders.get((int)i4).lDemands.size() - 1; j >= 0; --j) {
                                this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i4).lDemands.get((int)j).intValue()).isTaken = this.peaceTreatyGD.civsDemandsDefenders.get((int)i4).iCivID;
                                this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i4).lDemands.get((int)j).intValue()).iCivID = this.peaceTreatyGD.civsDemandsDefenders.get((int)i4).iCivID;
                            }
                        }
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                    try {
                        for (int i7 = this.peaceTreatyGD.civsDemandsAggressors.size() - 1; i7 >= 0; --i7) {
                            for (int j = this.peaceTreatyGD.civsDemandsAggressors.get((int)i7).lDemands.size() - 1; j >= 0; --j) {
                                this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i7).lDemands.get((int)j).intValue()).isTaken = this.peaceTreatyGD.civsDemandsAggressors.get((int)i7).iCivID;
                                this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i7).lDemands.get((int)j).intValue()).iCivID = this.peaceTreatyGD.civsDemandsAggressors.get((int)i7).iCivID;
                            }
                        }
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            catch (Exception exr) {
                CFG.exceptionStack(exr);
            }
        }
    }

    public final void prepareDemansVassalsData() {
        int u;
        int o;
        int k;
        int i;
        for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
            try {
                for (int j = 0; j < this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs_TakeControl.size(); ++j) {
                    for (k = 0; k < this.peaceTreatyGD.civsDemandsAggressors.size(); ++k) {
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs_TakeControl.get((int)j).iFromCivID != this.peaceTreatyGD.civsDemandsAggressors.get((int)k).iCivID) continue;
                        for (o = 0; o < this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lReleasableCivs.size(); ++o) {
                            if (this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).iCivID != this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs_TakeControl.get((int)j).iVassalCivID) continue;
                            for (u = 0; u < this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.size(); ++u) {
                                this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get((int)u).intValue()).iCivID = this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs_TakeControl.get((int)j).iVassalCivID;
                            }
                        }
                    }
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
            try {
                for (int j = 0; j < this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs_TakeControl.size(); ++j) {
                    for (k = 0; k < this.peaceTreatyGD.civsDemandsDefenders.size(); ++k) {
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs_TakeControl.get((int)j).iFromCivID != this.peaceTreatyGD.civsDemandsDefenders.get((int)k).iCivID) continue;
                        for (o = 0; o < this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lReleasableCivs.size(); ++o) {
                            if (this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).iCivID != this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs_TakeControl.get((int)j).iVassalCivID) continue;
                            for (u = 0; u < this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.size(); ++u) {
                                this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get((int)u).intValue()).iCivID = this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs_TakeControl.get((int)j).iVassalCivID;
                            }
                        }
                    }
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public final int takeReleaseVassal(int iFromCivID, int nReleaseCivID, int nCivID, int pointsUsedByCivID) {
        boolean ignorePoints = this.isIgnorePoints();
        int k;
        int o;
        int nID;
        int i;
        block4: for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
            try {
                if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != iFromCivID) continue;
                for (int j = 0; j < this.peaceTreatyGD.civsDemandsAggressors.size(); ++j) {
                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iCivID != nCivID) continue;
                    nID = -1;
                    for (o = 0; o < this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.size(); ++o) {
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)o).iCivID != nReleaseCivID) continue;
                        nID = o;
                        break;
                    }
                    if (nID >= 0) {
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).iReleasesToCivID > 0) {
                            if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).iReleasesToCivID == nCivID) {
                                this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).iReleasesToCivID = -1;
                                this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft += this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get(nID).getScoreValue();
                                this.peaceTreatyGD.civsDemandsAggressors.get(j).removeReleaseVassal_TakeControl(iFromCivID, nReleaseCivID);
                                for (k = 0; k < this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.size(); ++k) {
                                    if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isToTake) {
                                        if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken > 0) {
                                            if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken != this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iCivID) {
                                                int u;
                                                for (u = 0; u < this.peaceTreatyGD.civsDemandsAggressors.size(); ++u) {
                                                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)u).iCivID == this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID) {
                                                        this.peaceTreatyGD.civsDemandsAggressors.get(u).removeDemandOnProvince(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get(k));
                                                    }
                                                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)u).iCivID != this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken) continue;
                                                    this.peaceTreatyGD.civsDemandsAggressors.get((int)u).iVictoryPointsLeft += this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iProvinceValue;
                                                }
                                                for (u = 0; u < this.peaceTreatyGD.civsDemandsDefenders.size(); ++u) {
                                                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)u).iCivID == this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID) {
                                                        this.peaceTreatyGD.civsDemandsDefenders.get(u).removeDemandOnProvince(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get(k));
                                                    }
                                                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)u).iCivID != this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken) continue;
                                                    this.peaceTreatyGD.civsDemandsDefenders.get((int)u).iVictoryPointsLeft += this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iProvinceValue;
                                                }
                                                this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft -= this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iProvinceValue;
                                            }
                                        } else {
                                            this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft -= this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iProvinceValue;
                                        }
                                        this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken = -1;
                                        this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID = CFG.core.getProv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get(k)).getCivId();
                                        continue;
                                    }
                                    this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID = CFG.core.getProv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get(k)).getCivId();
                                }
                                return 0;
                            }
                            return this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).iReleasesToCivID;
                        }
                        if (!ignorePoints && this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft < this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get(nID).getScoreValue()) {
                            return 0;
                        }
                        this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).iReleasesToCivID = nCivID;
                        this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft -= this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get(nID).getScoreValue();
                        this.peaceTreatyGD.civsDemandsAggressors.get(j).addReleaseVassal_TakeControl(iFromCivID, nReleaseCivID);
                        for (k = 0; k < this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.size(); ++k) {
                            if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isToTake) {
                                if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken > 0) {
                                    int u;
                                    for (u = 0; u < this.peaceTreatyGD.civsDemandsAggressors.size(); ++u) {
                                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID == this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID) {
                                            this.peaceTreatyGD.civsDemandsAggressors.get(i).removeDemandOnProvince(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get(k));
                                        }
                                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken) continue;
                                        this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft += this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iProvinceValue;
                                    }
                                    for (u = 0; u < this.peaceTreatyGD.civsDemandsDefenders.size(); ++u) {
                                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID == this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID) {
                                            this.peaceTreatyGD.civsDemandsDefenders.get(i).removeDemandOnProvince(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get(k));
                                        }
                                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken) continue;
                                        this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft += this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iProvinceValue;
                                    }
                                    this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken = -1;
                                    this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID = CFG.core.getProv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get(k)).getTrueOwnerOfProv();
                                }
                                this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken = nCivID;
                            }
                            this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID = nReleaseCivID;
                        }
                        return nCivID;
                    }
                    i = this.peaceTreatyGD.civsDemandsDefenders.size();
                    continue block4;
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        block13: for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
            try {
                if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != iFromCivID) continue;
                for (int j = 0; j < this.peaceTreatyGD.civsDemandsDefenders.size(); ++j) {
                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iCivID != nCivID) continue;
                    nID = -1;
                    for (o = 0; o < this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.size(); ++o) {
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)o).iCivID != nReleaseCivID) continue;
                        nID = o;
                        break;
                    }
                    if (nID >= 0) {
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).iReleasesToCivID > 0) {
                            if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).iReleasesToCivID == nCivID) {
                                this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).iReleasesToCivID = -1;
                                this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft += this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get(nID).getScoreValue();
                                this.peaceTreatyGD.civsDemandsDefenders.get(j).removeReleaseVassal_TakeControl(iFromCivID, nReleaseCivID);
                                for (k = 0; k < this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.size(); ++k) {
                                    if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isToTake) {
                                        if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken > 0) {
                                            if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken != this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iCivID) {
                                                int u;
                                                for (u = 0; u < this.peaceTreatyGD.civsDemandsDefenders.size(); ++u) {
                                                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)u).iCivID == this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID) {
                                                        this.peaceTreatyGD.civsDemandsDefenders.get(u).removeDemandOnProvince(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get(k));
                                                    }
                                                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)u).iCivID != this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken) continue;
                                                    this.peaceTreatyGD.civsDemandsDefenders.get((int)u).iVictoryPointsLeft += this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iProvinceValue;
                                                }
                                                for (u = 0; u < this.peaceTreatyGD.civsDemandsAggressors.size(); ++u) {
                                                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)u).iCivID == this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID) {
                                                        this.peaceTreatyGD.civsDemandsAggressors.get(u).removeDemandOnProvince(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get(k));
                                                    }
                                                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)u).iCivID != this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken) continue;
                                                    this.peaceTreatyGD.civsDemandsAggressors.get((int)u).iVictoryPointsLeft += this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iProvinceValue;
                                                }
                                                this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft -= this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iProvinceValue;
                                            }
                                        } else {
                                            this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft -= this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iProvinceValue;
                                        }
                                        this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken = -1;
                                        this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID = CFG.core.getProv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get(k)).getCivId();
                                        continue;
                                    }
                                    this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID = CFG.core.getProv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get(k)).getCivId();
                                }
                                return 0;
                            }
                            return this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).iReleasesToCivID;
                        }
                        if (!ignorePoints && this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get(nID).getScoreValue() > this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft) {
                            return 0;
                        }
                        this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).iReleasesToCivID = nCivID;
                        this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft -= this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get(nID).getScoreValue();
                        this.peaceTreatyGD.civsDemandsDefenders.get(j).addReleaseVassal_TakeControl(iFromCivID, nReleaseCivID);
                        for (k = 0; k < this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.size(); ++k) {
                            if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isToTake) {
                                if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken > 0) {
                                    int u;
                                    for (u = 0; u < this.peaceTreatyGD.civsDemandsDefenders.size(); ++u) {
                                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID == this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID) {
                                            this.peaceTreatyGD.civsDemandsDefenders.get(i).removeDemandOnProvince(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get(k));
                                        }
                                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken) continue;
                                        this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft += this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iProvinceValue;
                                    }
                                    for (u = 0; u < this.peaceTreatyGD.civsDemandsAggressors.size(); ++u) {
                                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID == this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID) {
                                            this.peaceTreatyGD.civsDemandsAggressors.get(i).removeDemandOnProvince(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get(k));
                                        }
                                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken) continue;
                                        this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft += this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iProvinceValue;
                                    }
                                    this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken = -1;
                                    this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID = CFG.core.getProv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get(k)).getTrueOwnerOfProv();
                                }
                                this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).isTaken = nCivID;
                            }
                            this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)nID).lProvinces.get((int)k).intValue()).iCivID = nReleaseCivID;
                        }
                        return nCivID;
                    }
                    i = this.peaceTreatyGD.civsDemandsAggressors.size();
                    continue block13;
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return pointsUsedByCivID;
    }

    public final int getGovernment_Cost(int nCivID) {
        try {
            int i;
            for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != nCivID) continue;
                return (int)Math.max((float)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iTotalNumOfVicotryPoints * GameValues.gvPeaceTreaty.GOVERNMENT_COST, 1.0f);
            }
            for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != nCivID) continue;
                return (int)Math.max((float)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iTotalNumOfVicotryPoints * GameValues.gvPeaceTreaty.GOVERNMENT_COST, 1.0f);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return 1;
    }

    public final int takeGovernment(int nTakeGovernmentFromCivID, int nCivID, int pointsUsedByCivID) {
        boolean ignorePoints = this.isIgnorePoints();
        int i;
        for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
            try {
                if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != nTakeGovernmentFromCivID) continue;
                for (int j = 0; j < this.peaceTreatyGD.civsDemandsAggressors.size(); ++j) {
                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iCivID != nCivID) continue;
                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID > 0) {
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID == nCivID) {
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID = 0;
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft += this.getGovernment_Cost(nTakeGovernmentFromCivID);
                            this.peaceTreatyGD.civsDemandsAggressors.get(j).removeTakeGovernmentFromCivID(nTakeGovernmentFromCivID);
                            return 0;
                        }
                        if (!ignorePoints && this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft < this.getGovernment_Cost(nTakeGovernmentFromCivID)) {
                            return 0;
                        }
                        for (int k = 0; k < this.peaceTreatyGD.civsDemandsAggressors.size(); ++k) {
                            if (this.peaceTreatyGD.civsDemandsAggressors.get((int)k).iCivID != this.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID) continue;
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID = 0;
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)k).iVictoryPointsLeft += this.getGovernment_Cost(nTakeGovernmentFromCivID);
                            this.peaceTreatyGD.civsDemandsAggressors.get(k).removeTakeGovernmentFromCivID(nTakeGovernmentFromCivID);
                            break;
                        }
                    }
                    if (!ignorePoints && this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft < this.getGovernment_Cost(nTakeGovernmentFromCivID)) {
                        return 0;
                    }
                    this.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID = nCivID;
                    this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft -= this.getGovernment_Cost(nTakeGovernmentFromCivID);
                    this.peaceTreatyGD.civsDemandsAggressors.get(j).addTakeGovernmentFromCivID(nTakeGovernmentFromCivID);
                    return nCivID;
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
            try {
                if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != nTakeGovernmentFromCivID) continue;
                for (int j = 0; j < this.peaceTreatyGD.civsDemandsDefenders.size(); ++j) {
                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iCivID != nCivID) continue;
                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID > 0) {
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID == nCivID) {
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID = 0;
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft += this.getGovernment_Cost(nTakeGovernmentFromCivID);
                            this.peaceTreatyGD.civsDemandsDefenders.get(j).removeTakeGovernmentFromCivID(nTakeGovernmentFromCivID);
                            return 0;
                        }
                        if (!ignorePoints && this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft < this.getGovernment_Cost(nTakeGovernmentFromCivID)) {
                            return 0;
                        }
                        for (int k = 0; k < this.peaceTreatyGD.civsDemandsDefenders.size(); ++k) {
                            if (this.peaceTreatyGD.civsDemandsDefenders.get((int)k).iCivID != this.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID) continue;
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID = 0;
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)k).iVictoryPointsLeft += this.getGovernment_Cost(nTakeGovernmentFromCivID);
                            this.peaceTreatyGD.civsDemandsDefenders.get(k).removeTakeGovernmentFromCivID(nTakeGovernmentFromCivID);
                            break;
                        }
                    }
                    if (!ignorePoints && this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft < this.getGovernment_Cost(nTakeGovernmentFromCivID)) {
                        return 0;
                    }
                    this.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID = nCivID;
                    this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft -= this.getGovernment_Cost(nTakeGovernmentFromCivID);
                    this.peaceTreatyGD.civsDemandsDefenders.get(j).addTakeGovernmentFromCivID(nTakeGovernmentFromCivID);
                    return nCivID;
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return pointsUsedByCivID;
    }

    public final int getReligion_Cost(int nCivID) {
        try {
            int i;
            for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != nCivID) continue;
                return (int)Math.max((float)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iTotalNumOfVicotryPoints * GameValues.gvPeaceTreaty.RELIGION_COST, 1.0f);
            }
            for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != nCivID) continue;
                return (int)Math.max((float)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iTotalNumOfVicotryPoints * GameValues.gvPeaceTreaty.RELIGION_COST, 1.0f);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return 1;
    }

    public final int takeReligion(int nTakeReligionFromCivID, int nCivID, int pointsUsedByCivID) {
        boolean ignorePoints = this.isIgnorePoints();
        int i;
        for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
            try {
                if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != nTakeReligionFromCivID) continue;
                for (int j = 0; j < this.peaceTreatyGD.civsDemandsAggressors.size(); ++j) {
                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iCivID != nCivID) continue;
                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeReligionToCivID > 0) {
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeReligionToCivID == nCivID) {
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeReligionToCivID = 0;
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft += this.getReligion_Cost(nTakeReligionFromCivID);
                            this.peaceTreatyGD.civsDemandsAggressors.get(j).removeTakeReligionFromCivID(nTakeReligionFromCivID);
                            return 0;
                        }
                        if (!ignorePoints && this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft < this.getReligion_Cost(nTakeReligionFromCivID)) {
                            return 0;
                        }
                        for (int k = 0; k < this.peaceTreatyGD.civsDemandsAggressors.size(); ++k) {
                            if (this.peaceTreatyGD.civsDemandsAggressors.get((int)k).iCivID != this.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeReligionToCivID) continue;
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeReligionToCivID = 0;
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)k).iVictoryPointsLeft += this.getReligion_Cost(nTakeReligionFromCivID);
                            this.peaceTreatyGD.civsDemandsAggressors.get(k).removeTakeReligionFromCivID(nTakeReligionFromCivID);
                            break;
                        }
                    }
                    if (!ignorePoints && this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft < this.getReligion_Cost(nTakeReligionFromCivID)) {
                        return 0;
                    }
                    this.peaceTreatyGD.civsDemandsDefenders.get((int)i).changeReligionToCivID = nCivID;
                    this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft -= this.getReligion_Cost(nTakeReligionFromCivID);
                    this.peaceTreatyGD.civsDemandsAggressors.get(j).addTakeReligionFromCivID(nTakeReligionFromCivID);
                    return nCivID;
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
            try {
                if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != nTakeReligionFromCivID) continue;
                for (int j = 0; j < this.peaceTreatyGD.civsDemandsDefenders.size(); ++j) {
                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iCivID != nCivID) continue;
                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeReligionToCivID > 0) {
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeReligionToCivID == nCivID) {
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeReligionToCivID = 0;
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft += this.getReligion_Cost(nTakeReligionFromCivID);
                            this.peaceTreatyGD.civsDemandsDefenders.get(j).removeTakeReligionFromCivID(nTakeReligionFromCivID);
                            return 0;
                        }
                        if (!ignorePoints && this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft < this.getReligion_Cost(nTakeReligionFromCivID)) {
                            return 0;
                        }
                        for (int k = 0; k < this.peaceTreatyGD.civsDemandsDefenders.size(); ++k) {
                            if (this.peaceTreatyGD.civsDemandsDefenders.get((int)k).iCivID != this.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeReligionToCivID) continue;
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeReligionToCivID = 0;
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)k).iVictoryPointsLeft += this.getReligion_Cost(nTakeReligionFromCivID);
                            this.peaceTreatyGD.civsDemandsDefenders.get(k).removeTakeReligionFromCivID(nTakeReligionFromCivID);
                            break;
                        }
                    }
                    if (!ignorePoints && this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft < this.getReligion_Cost(nTakeReligionFromCivID)) {
                        return 0;
                    }
                    this.peaceTreatyGD.civsDemandsAggressors.get((int)i).changeReligionToCivID = nCivID;
                    this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft -= this.getReligion_Cost(nTakeReligionFromCivID);
                    this.peaceTreatyGD.civsDemandsDefenders.get(j).addTakeReligionFromCivID(nTakeReligionFromCivID);
                    return nCivID;
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return pointsUsedByCivID;
    }

    public final int getVassalization_Cost(int nCivID) {
        try {
            int i;
            for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != nCivID) continue;
                return (int)Math.max((float)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iTotalNumOfVicotryPoints * 0.4f, 1.0f);
            }
            for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != nCivID) continue;
                return (int)Math.max((float)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iTotalNumOfVicotryPoints * 0.4f, 1.0f);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return 1;
    }

    public final int takeVassalize(int nVasslizeCivID, int nCivID, int pointsUsedByCivID) {
        boolean playerInvolved = false;
        for (int pIdx = 0; pIdx < CFG.core.getPlayersSize(); ++pIdx) {
            int pCivID = CFG.core.getPlayer(pIdx).getCivId();
            if (CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsInAggressors(pCivID) || CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsInDefenders(pCivID)) {
                playerInvolved = true;
                break;
            }
        }
        boolean ignorePoints = CFG.SANDBOX_MODE && !playerInvolved;

        int i;
        for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
            try {
                if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != nVasslizeCivID) continue;
                for (int j = 0; j < this.peaceTreatyGD.civsDemandsAggressors.size(); ++j) {
                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iCivID != nCivID) continue;
                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iWillBecomeVassalOfCivID > 0) {
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iWillBecomeVassalOfCivID == nCivID) {
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iWillBecomeVassalOfCivID = 0;
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft += this.getVassalization_Cost(nVasslizeCivID);
                            this.peaceTreatyGD.civsDemandsAggressors.get(j).removeWillVassalizeCivID(nVasslizeCivID);
                            if (CFG.menus.getInGame_PeaceTreaty()) {
                                if (!CFG.core.getCiv(nCivID).getIsPlayer()) {
                                    CFG.menus.rebuildInGame_PeaceTreaty_Provinces();
                                }
                                CFG.menus.rebuildInGame_PeaceTreaty_Scores();
                            }
                            return 0;
                        }
                        if (!ignorePoints && this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft < this.getVassalization_Cost(nVasslizeCivID)) {
                            if (CFG.menus.getInGame_PeaceTreaty()) {
                                if (!CFG.core.getCiv(nCivID).getIsPlayer()) {
                                    CFG.menus.rebuildInGame_PeaceTreaty_Provinces();
                                }
                                CFG.menus.rebuildInGame_PeaceTreaty_Scores();
                            }
                            return 0;
                        }
                        for (int k = 0; k < this.peaceTreatyGD.civsDemandsAggressors.size(); ++k) {
                            if (this.peaceTreatyGD.civsDemandsAggressors.get((int)k).iCivID != this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iWillBecomeVassalOfCivID) continue;
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iWillBecomeVassalOfCivID = 0;
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)k).iVictoryPointsLeft += this.getVassalization_Cost(nVasslizeCivID);
                            this.peaceTreatyGD.civsDemandsAggressors.get(k).removeWillVassalizeCivID(nVasslizeCivID);
                            break;
                        }
                    }
                    if (!ignorePoints && this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft < this.getVassalization_Cost(nVasslizeCivID)) {
                        if (CFG.menus.getInGame_PeaceTreaty()) {
                            if (!CFG.core.getCiv(nCivID).getIsPlayer()) {
                                CFG.menus.rebuildInGame_PeaceTreaty_Provinces();
                            }
                            CFG.menus.rebuildInGame_PeaceTreaty_Scores();
                        }
                        return 0;
                    }
                    this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iWillBecomeVassalOfCivID = nCivID;
                    this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft -= this.getVassalization_Cost(nVasslizeCivID);
                    this.peaceTreatyGD.civsDemandsAggressors.get(j).addWillVassalizeCivID(nVasslizeCivID);
                    if (CFG.menus.getInGame_PeaceTreaty()) {
                        if (!CFG.core.getCiv(nCivID).getIsPlayer()) {
                            CFG.menus.rebuildInGame_PeaceTreaty_Provinces();
                        }
                        CFG.menus.rebuildInGame_PeaceTreaty_Scores();
                    }
                    return nCivID;
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
            try {
                if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != nVasslizeCivID) continue;
                for (int j = 0; j < this.peaceTreatyGD.civsDemandsDefenders.size(); ++j) {
                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iCivID != nCivID) continue;
                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iWillBecomeVassalOfCivID > 0) {
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iWillBecomeVassalOfCivID == nCivID) {
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iWillBecomeVassalOfCivID = 0;
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft += this.getVassalization_Cost(nVasslizeCivID);
                            this.peaceTreatyGD.civsDemandsDefenders.get(j).removeWillVassalizeCivID(nVasslizeCivID);
                            if (CFG.menus.getInGame_PeaceTreaty()) {
                                if (!CFG.core.getCiv(nCivID).getIsPlayer()) {
                                    CFG.menus.rebuildInGame_PeaceTreaty_Provinces();
                                }
                                CFG.menus.rebuildInGame_PeaceTreaty_Scores();
                            }
                            return 0;
                        }
                        if (!ignorePoints && this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft < this.getVassalization_Cost(nVasslizeCivID)) {
                            if (CFG.menus.getInGame_PeaceTreaty()) {
                                if (!CFG.core.getCiv(nCivID).getIsPlayer()) {
                                    CFG.menus.rebuildInGame_PeaceTreaty_Provinces();
                                }
                                CFG.menus.rebuildInGame_PeaceTreaty_Scores();
                            }
                            return 0;
                        }
                        for (int k = 0; k < this.peaceTreatyGD.civsDemandsDefenders.size(); ++k) {
                            if (this.peaceTreatyGD.civsDemandsDefenders.get((int)k).iCivID != this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iWillBecomeVassalOfCivID) continue;
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iWillBecomeVassalOfCivID = 0;
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)k).iVictoryPointsLeft += this.getVassalization_Cost(nVasslizeCivID);
                            this.peaceTreatyGD.civsDemandsDefenders.get(k).removeWillVassalizeCivID(nVasslizeCivID);
                            break;
                        }
                    }
                    if (!ignorePoints && this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft < this.getVassalization_Cost(nVasslizeCivID)) {
                        if (CFG.menus.getInGame_PeaceTreaty()) {
                            if (!CFG.core.getCiv(nCivID).getIsPlayer()) {
                                CFG.menus.rebuildInGame_PeaceTreaty_Provinces();
                            }
                            CFG.menus.rebuildInGame_PeaceTreaty_Scores();
                        }
                        return 0;
                    }
                    this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iWillBecomeVassalOfCivID = nCivID;
                    this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft -= this.getVassalization_Cost(nVasslizeCivID);
                    this.peaceTreatyGD.civsDemandsDefenders.get(j).addWillVassalizeCivID(nVasslizeCivID);
                    if (CFG.menus.getInGame_PeaceTreaty()) {
                        if (!CFG.core.getCiv(nCivID).getIsPlayer()) {
                            CFG.menus.rebuildInGame_PeaceTreaty_Provinces();
                        }
                        CFG.menus.rebuildInGame_PeaceTreaty_Scores();
                    }
                    return nCivID;
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return pointsUsedByCivID;
    }

    public final int getWarReparation_Cost(int nCivID) {
        try {
            int i;
            for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != nCivID) continue;
                return (int)Math.max((float)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iTotalNumOfVicotryPoints * 0.1f, 1.0f);
            }
            for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != nCivID) continue;
                return (int)Math.max((float)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iTotalNumOfVicotryPoints * 0.1f, 1.0f);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return 1;
    }

    public final int takeWarReparations(int nWarRepartionsFromCivID, int nCivID, int pointsUsedByCivID) {
        boolean playerInvolved = false;
        for (int pIdx = 0; pIdx < CFG.core.getPlayersSize(); ++pIdx) {
            int pCivID = CFG.core.getPlayer(pIdx).getCivId();
            if (CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsInAggressors(pCivID) || CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsInDefenders(pCivID)) {
                playerInvolved = true;
                break;
            }
        }
        boolean ignorePoints = CFG.SANDBOX_MODE && !playerInvolved;

        int i;
        for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
            try {
                if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != nWarRepartionsFromCivID) continue;
                for (int j = 0; j < this.peaceTreatyGD.civsDemandsAggressors.size(); ++j) {
                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iCivID != nCivID) continue;
                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iPaysWarReparationsToCivID > 0) {
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iPaysWarReparationsToCivID == nCivID) {
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iPaysWarReparationsToCivID = 0;
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft += this.getWarReparation_Cost(nWarRepartionsFromCivID);
                            this.peaceTreatyGD.civsDemandsAggressors.get(j).removeWarReparationsFromCivID(nWarRepartionsFromCivID);
                            return 0;
                        }
                        if (!ignorePoints && this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft < this.getWarReparation_Cost(nWarRepartionsFromCivID)) {
                            return 0;
                        }
                        for (int k = 0; k < this.peaceTreatyGD.civsDemandsAggressors.size(); ++k) {
                            if (this.peaceTreatyGD.civsDemandsAggressors.get((int)k).iCivID != this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iPaysWarReparationsToCivID) continue;
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iPaysWarReparationsToCivID = 0;
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)k).iVictoryPointsLeft += this.getWarReparation_Cost(nWarRepartionsFromCivID);
                            this.peaceTreatyGD.civsDemandsAggressors.get(k).removeWarReparationsFromCivID(nWarRepartionsFromCivID);
                            break;
                        }
                    }
                    if (!ignorePoints && this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft < this.getWarReparation_Cost(nWarRepartionsFromCivID)) {
                        return 0;
                    }
                    this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iPaysWarReparationsToCivID = nCivID;
                    this.peaceTreatyGD.civsDemandsAggressors.get((int)j).iVictoryPointsLeft -= this.getWarReparation_Cost(nWarRepartionsFromCivID);
                    this.peaceTreatyGD.civsDemandsAggressors.get(j).addWarReparationsFromCivID(nWarRepartionsFromCivID);
                    return nCivID;
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
            try {
                if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != nWarRepartionsFromCivID) continue;
                for (int j = 0; j < this.peaceTreatyGD.civsDemandsDefenders.size(); ++j) {
                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iCivID != nCivID) continue;
                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iPaysWarReparationsToCivID > 0) {
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iPaysWarReparationsToCivID == nCivID) {
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iPaysWarReparationsToCivID = 0;
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft += this.getWarReparation_Cost(nWarRepartionsFromCivID);
                            this.peaceTreatyGD.civsDemandsDefenders.get(j).removeWarReparationsFromCivID(nWarRepartionsFromCivID);
                            return 0;
                        }
                        if (!ignorePoints && this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft < this.getWarReparation_Cost(nWarRepartionsFromCivID)) {
                            return 0;
                        }
                        for (int k = 0; k < this.peaceTreatyGD.civsDemandsDefenders.size(); ++k) {
                            if (this.peaceTreatyGD.civsDemandsDefenders.get((int)k).iCivID != this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iPaysWarReparationsToCivID) continue;
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iPaysWarReparationsToCivID = 0;
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)k).iVictoryPointsLeft += this.getWarReparation_Cost(nWarRepartionsFromCivID);
                            this.peaceTreatyGD.civsDemandsDefenders.get(k).removeWarReparationsFromCivID(nWarRepartionsFromCivID);
                            break;
                        }
                    }
                    if (!ignorePoints && this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft < this.getWarReparation_Cost(nWarRepartionsFromCivID)) {
                        return 0;
                    }
                    this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iPaysWarReparationsToCivID = nCivID;
                    this.peaceTreatyGD.civsDemandsDefenders.get((int)j).iVictoryPointsLeft -= this.getWarReparation_Cost(nWarRepartionsFromCivID);
                    this.peaceTreatyGD.civsDemandsDefenders.get(j).addWarReparationsFromCivID(nWarRepartionsFromCivID);
                    return nCivID;
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return pointsUsedByCivID;
    }

    public final boolean takeProvince(int nProvinceID, int nCivID, int pointsUsedByCivID) {
        block18: {
            try {
                if (nProvinceID < 0 || CFG.core.getProv(nProvinceID).getSeaProv() || !this.drawProvOwners.get((int)nProvinceID).isToTake) break block18;
                this.iLastTakenID = nProvinceID;
                if (this.drawProvOwners.get((int)nProvinceID).isTaken > 0) {
                    int i;
                    if (this.drawProvOwners.get((int)nProvinceID).iCivID == nCivID) {
                        int i2;
                        for (i2 = 0; i2 < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i2) {
                            if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).iCivID == this.drawProvOwners.get((int)nProvinceID).iCivID) {
                                this.peaceTreatyGD.civsDemandsDefenders.get(i2).removeDemandOnProvince(nProvinceID);
                                this.addProvincesLeftToTake(nProvinceID);
                            }
                            if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).iCivID != this.drawProvOwners.get((int)nProvinceID).isTaken) continue;
                            this.peaceTreatyGD.civsDemandsDefenders.get((int)i2).iVictoryPointsLeft += this.drawProvOwners.get((int)nProvinceID).iProvinceValue;
                            if (!CFG.menus.getInGame_PeaceTreaty()) continue;
                            CFG.menus.rebuildInGame_PeaceTreaty_Scores();
                        }
                        for (i2 = 0; i2 < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i2) {
                            if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).iCivID == this.drawProvOwners.get((int)nProvinceID).iCivID) {
                                this.peaceTreatyGD.civsDemandsAggressors.get(i2).removeDemandOnProvince(nProvinceID);
                                this.addProvincesLeftToTake(nProvinceID);
                            }
                            if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).iCivID != this.drawProvOwners.get((int)nProvinceID).isTaken) continue;
                            this.peaceTreatyGD.civsDemandsAggressors.get((int)i2).iVictoryPointsLeft += this.drawProvOwners.get((int)nProvinceID).iProvinceValue;
                            if (!CFG.menus.getInGame_PeaceTreaty()) continue;
                            CFG.menus.rebuildInGame_PeaceTreaty_Scores();
                        }
                        this.drawProvOwners.get((int)nProvinceID).isTaken = -1;
                        this.drawProvOwners.get((int)nProvinceID).iCivID = CFG.core.getProv(nProvinceID).getTrueOwnerOfProv();
                        break block18;
                    }
                    for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID == this.drawProvOwners.get((int)nProvinceID).iCivID) {
                            this.peaceTreatyGD.civsDemandsDefenders.get(i).removeDemandOnProvince(nProvinceID);
                            this.addProvincesLeftToTake(nProvinceID);
                        }
                        this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft += this.drawProvOwners.get((int)nProvinceID).iProvinceValue;
                    }
                    for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID == this.drawProvOwners.get((int)nProvinceID).iCivID) {
                            this.peaceTreatyGD.civsDemandsAggressors.get(i).removeDemandOnProvince(nProvinceID);
                            this.addProvincesLeftToTake(nProvinceID);
                        }
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != this.drawProvOwners.get((int)nProvinceID).isTaken) continue;
                        this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft += this.drawProvOwners.get((int)nProvinceID).iProvinceValue;
                    }
                    this.drawProvOwners.get((int)nProvinceID).isTaken = -1;
                    if (this.makeDemand_Province(nProvinceID, nCivID, pointsUsedByCivID)) {
                        this.removeProvincesLeftToTake(nProvinceID);
                        CFG.core.setActiveProvID(-1);
                        this.AIUseVictoryPoints();
                        return true;
                    }
                    CFG.core.setActiveProvID(-1);
                    this.AIUseVictoryPoints();
                    return false;
                }
                if (this.makeDemand_Province(nProvinceID, nCivID, pointsUsedByCivID)) {
                    this.removeProvincesLeftToTake(nProvinceID);
                    try {
                        CFG.core.setActiveProvID(-1);
                    }
                    catch (Exception i) {
                        // empty catch block
                    }
                    this.AIUseVictoryPoints();
                    return true;
                }
                try {
                    CFG.core.setActiveProvID(-1);
                }
                catch (Exception i) {
                    // empty catch block
                }
                this.AIUseVictoryPoints();
                return false;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return false;
    }

    public final boolean makeDemand_Province(int nProvinceID, int nCivID, int pointsUsedByCivID) {
        return this.makeDemand_Province(nProvinceID, nCivID, pointsUsedByCivID, false);
    }

    public final boolean makeDemand_Province(int nProvinceID, int nCivID, int pointsUsedByCivID, boolean free_ToTrueOwner) {
        try {
            int i;
            if (nCivID != pointsUsedByCivID && CFG.core.getProv(nProvinceID).getTrueOwnerOfProv() == nCivID) {
                pointsUsedByCivID = nCivID;
            }
            if (!free_ToTrueOwner) {
                boolean playerInvolved = false;
                for (int pIdx = 0; pIdx < CFG.core.getPlayersSize(); ++pIdx) {
                    int pCivID = CFG.core.getPlayer(pIdx).getCivId();
                    if (CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsInAggressors(pCivID) || CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsInDefenders(pCivID)) {
                        playerInvolved = true;
                        break;
                    }
                }

                if (!CFG.SANDBOX_MODE || playerInvolved) {
                    for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                        if (this.drawProvOwners.get((int)nProvinceID).isTaken > 0) {
                            if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != pointsUsedByCivID) continue;
                            if (this.drawProvOwners.get((int)nProvinceID).isTaken == pointsUsedByCivID) break;
                            if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft >= this.drawProvOwners.get((int)nProvinceID).iProvinceValue) continue;
                            return false;
                        }
                        if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != pointsUsedByCivID || this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft >= this.drawProvOwners.get((int)nProvinceID).iProvinceValue) continue;
                        return false;
                    }
                    for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                        if (this.drawProvOwners.get((int)nProvinceID).isTaken > 0) {
                            if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != pointsUsedByCivID) continue;
                            if (this.drawProvOwners.get((int)nProvinceID).isTaken == pointsUsedByCivID) break;
                            if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft >= this.drawProvOwners.get((int)nProvinceID).iProvinceValue) continue;
                            return false;
                        }
                        if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != pointsUsedByCivID || this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft >= this.drawProvOwners.get((int)nProvinceID).iProvinceValue) continue;
                        return false;
                    }
                }
            }
            for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID == nCivID) {
                    this.peaceTreatyGD.civsDemandsDefenders.get(i).addDemandOnProvince(nProvinceID);
                }
                if (this.drawProvOwners.get((int)nProvinceID).isTaken > 0) {
                    if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != this.drawProvOwners.get((int)nProvinceID).iCivID) continue;
                    this.peaceTreatyGD.civsDemandsDefenders.get(i).removeDemandOnProvince(nProvinceID);
                    continue;
                }
                if (this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID != pointsUsedByCivID) continue;
                this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iVictoryPointsLeft -= this.drawProvOwners.get((int)nProvinceID).iProvinceValue;
            }
            for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID == nCivID) {
                    this.peaceTreatyGD.civsDemandsAggressors.get(i).addDemandOnProvince(nProvinceID);
                }
                if (this.drawProvOwners.get((int)nProvinceID).isTaken > 0) {
                    if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != this.drawProvOwners.get((int)nProvinceID).iCivID) continue;
                    this.peaceTreatyGD.civsDemandsAggressors.get(i).removeDemandOnProvince(nProvinceID);
                    continue;
                }
                if (this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID != pointsUsedByCivID) continue;
                this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iVictoryPointsLeft -= this.drawProvOwners.get((int)nProvinceID).iProvinceValue;
            }
            this.drawProvOwners.get((int)nProvinceID).isTaken = pointsUsedByCivID;
            this.drawProvOwners.get((int)nProvinceID).iCivID = nCivID;
            if (CFG.menus.getInGame_PeaceTreaty()) {
                CFG.menus.rebuildInGame_PeaceTreaty_Scores();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return true;
    }

    public final void preparePeaceTreatyToSend(int iFromCivID) {
        try {
            int k;
            int k2;
            int numOfConnections_Enemies;
            int numOfConnections_Own;
            int j;
            int i;
            int j2;
            int i2;
            for (i2 = 0; i2 < this.peaceTreatyGD.civsDataDefenders.size(); ++i2) {
                for (j2 = 0; j2 < this.peaceTreatyGD.civsDataDefenders.get((int)i2).lProvincesLost.size(); ++j2) {
                    if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDataDefenders.get((int)i2).lProvincesLost.get((int)j2).intValue()).isTaken >= 0) continue;
                    this.makeDemand_Province(this.peaceTreatyGD.civsDataDefenders.get((int)i2).lProvincesLost.get(j2), this.peaceTreatyGD.civsDataDefenders.get((int)i2).iCivID, this.peaceTreatyGD.civsDataDefenders.get((int)i2).iCivID, true);
                }
            }
            for (i2 = 0; i2 < this.peaceTreatyGD.civsDataAggressors.size(); ++i2) {
                for (j2 = 0; j2 < this.peaceTreatyGD.civsDataAggressors.get((int)i2).lProvincesLost.size(); ++j2) {
                    if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDataAggressors.get((int)i2).lProvincesLost.get((int)j2).intValue()).isTaken >= 0) continue;
                    this.makeDemand_Province(this.peaceTreatyGD.civsDataAggressors.get((int)i2).lProvincesLost.get(j2), this.peaceTreatyGD.civsDataAggressors.get((int)i2).iCivID, this.peaceTreatyGD.civsDataAggressors.get((int)i2).iCivID, true);
                }
            }
            boolean updateData = false;
            for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                if (CFG.core.getCiv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID).getIsPlayer()) continue;
                for (j = this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.size() - 1; j >= 0; --j) {
                    numOfConnections_Own = 0;
                    numOfConnections_Enemies = 0;
                    for (k2 = 0; k2 < CFG.core.getProv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.get(j)).getNeighProvincesSize(); ++k2) {
                        if (this.drawProvOwners.get((int)CFG.core.getProv((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.get((int)j).intValue()).getNeighProvinces((int)k2)).iCivID == this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID) {
                            ++numOfConnections_Own;
                            continue;
                        }
                        if (this.drawProvOwners.get((int)CFG.core.getProv((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.get((int)j).intValue()).getNeighProvinces((int)k2)).iCivID >= 0 && !CFG.core.getCivsAtWar(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID, this.drawProvOwners.get((int)CFG.core.getProv((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.get((int)j).intValue()).getNeighProvinces((int)k2)).iCivID)) continue;
                        ++numOfConnections_Enemies;
                    }
                    if (numOfConnections_Own > 0 || numOfConnections_Enemies <= 0 || CFG.core.getProv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.get(j)).getNeighProvincesSize() <= 2 && CFG.core.getProv(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.get(j)).getNeighSeaProvincesSize() > 0) continue;
                    this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.get((int)j).intValue()).isTaken = -1;
                    this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.get((int)j).intValue()).iCivID = CFG.core.getProv(i).getCivId() * -1;
                    this.peaceTreatyGD.civsDemandsDefenders.get(i).removeDemandOnProvince(this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lDemands.get(j));
                    updateData = true;
                }
            }
            for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                if (CFG.core.getCiv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID).getIsPlayer()) continue;
                for (j = this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.size() - 1; j >= 0; --j) {
                    numOfConnections_Own = 0;
                    numOfConnections_Enemies = 0;
                    for (k2 = 0; k2 < CFG.core.getProv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.get(j)).getNeighProvincesSize(); ++k2) {
                        if (this.drawProvOwners.get((int)CFG.core.getProv((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.get((int)j).intValue()).getNeighProvinces((int)k2)).iCivID == this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID) {
                            ++numOfConnections_Own;
                            continue;
                        }
                        if (this.drawProvOwners.get((int)CFG.core.getProv((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.get((int)j).intValue()).getNeighProvinces((int)k2)).iCivID >= 0 && !CFG.core.getCivsAtWar(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID, this.drawProvOwners.get((int)CFG.core.getProv((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.get((int)j).intValue()).getNeighProvinces((int)k2)).iCivID)) continue;
                        ++numOfConnections_Enemies;
                    }
                    if (numOfConnections_Own > 0 || numOfConnections_Enemies <= 0 || CFG.core.getProv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.get(j)).getNeighProvincesSize() <= 2 && CFG.core.getProv(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.get(j)).getNeighSeaProvincesSize() > 0) continue;
                    this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.get((int)j).intValue()).isTaken = -1;
                    this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.get((int)j).intValue()).iCivID = CFG.core.getProv(i).getCivId() * -1;
                    this.peaceTreatyGD.civsDemandsAggressors.get(i).removeDemandOnProvince(this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lDemands.get(j));
                    updateData = true;
                }
            }
            if (updateData) {
                for (i = 0; i < this.peaceTreatyGD.civsDataDefenders.size(); ++i) {
                    for (j = 0; j < this.peaceTreatyGD.civsDataDefenders.get((int)i).lProvincesLost.size(); ++j) {
                        if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDataDefenders.get((int)i).lProvincesLost.get((int)j).intValue()).isTaken >= 0) continue;
                        this.makeDemand_Province(this.peaceTreatyGD.civsDataDefenders.get((int)i).lProvincesLost.get(j), this.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID, this.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID, true);
                    }
                }
                for (i = 0; i < this.peaceTreatyGD.civsDataAggressors.size(); ++i) {
                    for (j = 0; j < this.peaceTreatyGD.civsDataAggressors.get((int)i).lProvincesLost.size(); ++j) {
                        if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDataAggressors.get((int)i).lProvincesLost.get((int)j).intValue()).isTaken >= 0) continue;
                        this.makeDemand_Province(this.peaceTreatyGD.civsDataAggressors.get((int)i).lProvincesLost.get(j), this.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID, this.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID, true);
                    }
                }
            }
            for (i = 0; i < this.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
                for (j = 0; j < this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.size(); ++j) {
                    for (k = this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)j).lProvinces.size() - 1; k >= 0; --k) {
                        if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)j).lProvinces.get((int)k).intValue()).iCivID == this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)j).iCivID) continue;
                        this.peaceTreatyGD.civsDemandsDefenders.get((int)i).lReleasableCivs.get((int)j).lProvinces.remove(k);
                    }
                }
                if (iFromCivID != this.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID) continue;
                this.peaceTreatyGD.civsDemandsDefenders.get((int)i).peaceTreatyAccepted = true;
            }
            for (i = 0; i < this.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
                for (j = 0; j < this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.size(); ++j) {
                    for (k = this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)j).lProvinces.size() - 1; k >= 0; --k) {
                        if (this.drawProvOwners.get((int)this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)j).lProvinces.get((int)k).intValue()).iCivID == this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)j).iCivID) continue;
                        this.peaceTreatyGD.civsDemandsAggressors.get((int)i).lReleasableCivs.get((int)j).lProvinces.remove(k);
                    }
                }
                if (iFromCivID != this.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID) continue;
                this.peaceTreatyGD.civsDemandsAggressors.get((int)i).peaceTreatyAccepted = true;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static int getProposal_Positive(boolean scoreCountDefenders) {
        int out = 0;
        return out;
    }

    public static int getProposal_Negative(boolean scoreCountDefenders) {
        int out = 0;
        return out;
    }

    public final boolean isIgnorePoints() {
        if (!CFG.SANDBOX_MODE) return false;
        for (int pIdx = 0; pIdx < CFG.core.getPlayersSize(); ++pIdx) {
            int pCivID = CFG.core.getPlayer(pIdx).getCivId();
            if (CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsInAggressors(pCivID) || CFG.core.getWar(this.peaceTreatyGD.iWarID).getIsInDefenders(pCivID)) {
                return false;
            }
        }
        return true;
    }
}

