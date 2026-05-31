/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_Civs;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.WarCiv_GameData;
import age.of.civilizations2.jakowski.lukasz.War_Points;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class War_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private List<WarCiv_GameData> lAggressors = new ArrayList<WarCiv_GameData>();
    private List<WarCiv_GameData> lDefenders = new ArrayList<WarCiv_GameData>();
    private int iWarTurnID = 1;
    public int iLastFight_InTurns = 0;
    public int iLastTurn_ConqueredProvince = 0;
    public boolean wasAnyAttack = false;
    public String WAR_TAG;

    public War_GameData(int nAggressor, int nDefender) {
        this.addAggressor(nAggressor);
        this.addDefender(nDefender);
        this.iWarTurnID = GameCalendar.TURNID;
        this.WAR_TAG = CFG.core.getCiv(nAggressor).getCivTag() + CFG.core.getCiv(nDefender).getCivTag() + CFG.extraRandomTag() + this.iWarTurnID;
    }

    public final void addAggressor(int nCivID) {
        try {
            int i;
            for (i = 0; i < this.getAggressorsSize(); ++i) {
                if (this.lAggressors.get(i).getCivID() != nCivID) continue;
                return;
            }
            this.lAggressors.add(new WarCiv_GameData(nCivID));
            for (i = 0; i < this.getDefendersSize(); ++i) {
                if (CFG.core.getCivsAtWar(nCivID, this.getDefenderID(i).getCivID())) continue;
                CFG.core.setCivRelationOfCivB_AtWar(nCivID, this.getDefenderID(i).getCivID());
                CFG.core.setCivRelationOfCivB_AtWar(this.getDefenderID(i).getCivID(), nCivID);
            }
            this.iLastFight_InTurns = 0;
            this.iLastTurn_ConqueredProvince = GameCalendar.TURNID;
            CFG.core.getCiv((int)nCivID).uFOL = true;
            if (CFG.core.getCiv(nCivID).getPuppetOfCiv() != nCivID) {
                CFG.core.getCiv((int)CFG.core.getCiv((int)nCivID).getPuppetOfCiv()).uFOL = true;
            }
            for (i = 0; i < CFG.core.getCiv((int)nCivID).civGD.iVassalsSize; ++i) {
                CFG.core.getCiv((int)CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)i).iCivID).uFOL = true;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void removeAggressor(int nCivID) {
        try {
            for (int i = 0; i < this.getAggressorsSize(); ++i) {
                if (this.lAggressors.get(i).getCivID() != nCivID) continue;
                this.lAggressors.remove(i);
                CFG.core.getCiv((int)nCivID).uFOL = true;
                return;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void addDefender(int nCivID) {
        try {
            int i;
            for (i = 0; i < this.getDefendersSize(); ++i) {
                if (this.lDefenders.get(i).getCivID() != nCivID) continue;
                return;
            }
            this.lDefenders.add(new WarCiv_GameData(nCivID));
            for (i = 0; i < this.getAggressorsSize(); ++i) {
                if (CFG.core.getCivsAtWar(nCivID, this.getAggressorID(i).getCivID())) continue;
                CFG.core.setCivRelationOfCivB_AtWar(nCivID, this.getAggressorID(i).getCivID());
                CFG.core.setCivRelationOfCivB_AtWar(this.getAggressorID(i).getCivID(), nCivID);
            }
            this.iLastFight_InTurns = 0;
            this.iLastTurn_ConqueredProvince = GameCalendar.TURNID;
            CFG.core.getCiv((int)nCivID).uFOL = true;
            if (CFG.core.getCiv(nCivID).getPuppetOfCiv() != nCivID) {
                CFG.core.getCiv((int)CFG.core.getCiv((int)nCivID).getPuppetOfCiv()).uFOL = true;
            }
            for (i = 0; i < CFG.core.getCiv((int)nCivID).civGD.iVassalsSize; ++i) {
                CFG.core.getCiv((int)CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)i).iCivID).uFOL = true;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void removeDefender(int nCivID) {
        try {
            for (int i = 0; i < this.getDefendersSize(); ++i) {
                if (this.lDefenders.get(i).getCivID() != nCivID) continue;
                this.lDefenders.remove(i);
                CFG.core.getCiv((int)nCivID).uFOL = true;
                return;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void updateAfterUnion(int nCivA, int nCivB) {
        try {
            int nID;
            if (this.getIsAggressor(nCivA) && this.getIsAggressor(nCivB)) {
                int nID2 = this.getAggressorID_ByCivID(nCivA);
                int nID22 = this.getAggressorID_ByCivID(nCivB);
                if (nID2 >= 0 && nID22 >= 0) {
                    this.getAggressorID(nID2).addCivilianDeaths(this.getAggressorID(nID22).getCivilianDeaths());
                    this.getAggressorID(nID2).addCasualties(this.getAggressorID(nID22).getCasualties());
                    this.getAggressorID(nID2).addEconomicLosses(this.getAggressorID(nID22).getEconomicLosses());
                    this.removeAggressor(nCivB);
                }
            } else if (this.getIsDefender(nCivA) && this.getIsDefender(nCivB)) {
                int nID3 = this.getDefenderID_ByCivID(nCivA);
                int nID2 = this.getDefenderID_ByCivID(nCivB);
                if (nID3 >= 0 && nID2 >= 0) {
                    this.getDefenderID(nID3).addCivilianDeaths(this.getDefenderID(nID2).getCivilianDeaths());
                    this.getDefenderID(nID3).addCasualties(this.getDefenderID(nID2).getCasualties());
                    this.getDefenderID(nID3).addEconomicLosses(this.getDefenderID(nID2).getEconomicLosses());
                    this.removeDefender(nCivB);
                }
            } else if (this.getIsAggressor(nCivB) && !this.getIsDefender(nCivA)) {
                int nID4 = this.getAggressorID_ByCivID(nCivB);
                if (nID4 >= 0) {
                    this.getAggressorID(nID4).setCivID(nCivA);
                }
            } else if (this.getIsDefender(nCivB) && !this.getIsAggressor(nCivA) && (nID = this.getDefenderID_ByCivID(nCivB)) >= 0) {
                this.getDefenderID(nID).setCivID(nCivA);
            }
            CFG.core.getCiv((int)nCivA).uFOL = true;
            CFG.core.getCiv((int)nCivB).uFOL = true;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final boolean getIsAggressor(int nCivID) {
        try {
            for (int i = 0; i < this.getAggressorsSize(); ++i) {
                if (this.getAggressorID(i).getCivID() != nCivID) continue;
                return true;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return false;
    }

    public final boolean getIsDefender(int nCivID) {
        try {
            for (int i = 0; i < this.getDefendersSize(); ++i) {
                if (this.getDefenderID(i).getCivID() != nCivID) continue;
                return true;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return false;
    }

    public final int getWarScore() {
        int k;
        int i;
        int tempNumOfProvincesInWar_Aggrersors = 0;
        int tempNumOfProvincesInWar_Defenders = 0;
        int tempControledEnemyProvinces_ByAggrersors = 0;
        int tempControledEnemyProvinces_ByDefenders = 0;
        for (i = 0; i < this.getAggressorsSize(); ++i) {
            try {
                block9: for (int j = 0; j < CFG.core.getCiv(this.getAggressorID(i).getCivID()).getNumOfProvs(); ++j) {
                    if (this.getAggressorID(i).getCivID() == CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) {
                        tempNumOfProvincesInWar_Aggrersors += CFG.core.getProvinceValue(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j));
                        continue;
                    }
                    for (k = 0; k < this.getDefendersSize(); ++k) {
                        if (this.getDefenderID(k).getCivID() != CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                        tempControledEnemyProvinces_ByAggrersors += CFG.core.getProvinceValue(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j));
                        continue block9;
                    }
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        for (i = 0; i < this.getDefendersSize(); ++i) {
            try {
                block12: for (int j = 0; j < CFG.core.getCiv(this.getDefenderID(i).getCivID()).getNumOfProvs(); ++j) {
                    if (this.getDefenderID(i).getCivID() == CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) {
                        tempNumOfProvincesInWar_Defenders += CFG.core.getProvinceValue(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j));
                        continue;
                    }
                    for (k = 0; k < this.getAggressorsSize(); ++k) {
                        if (this.getAggressorID(k).getCivID() != CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                        tempControledEnemyProvinces_ByDefenders += CFG.core.getProvinceValue(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j));
                        continue block12;
                    }
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        int tempAggressorsPerc = 0;
        int tempDefendersPerc = 0;
        try {
            tempAggressorsPerc = (int)((float)tempControledEnemyProvinces_ByAggrersors / (float)(tempNumOfProvincesInWar_Defenders + tempControledEnemyProvinces_ByDefenders + tempControledEnemyProvinces_ByAggrersors) * 100.0f);
        }
        catch (ArithmeticException ex) {
            tempAggressorsPerc = 0;
        }
        try {
            tempDefendersPerc = (int)((float)tempControledEnemyProvinces_ByDefenders / (float)(tempNumOfProvincesInWar_Aggrersors + tempControledEnemyProvinces_ByAggrersors + tempControledEnemyProvinces_ByDefenders) * 100.0f);
        }
        catch (ArithmeticException ex) {
            tempDefendersPerc = 0;
        }
        return -tempAggressorsPerc + tempDefendersPerc;
    }

    public final int getWarScore_PeaceTreaty() {
        int k;
        int i;
        int tempNumOfProvincesInWar_Aggrersors = 0;
        int tempNumOfProvincesInWar_Defenders = 0;
        int tempControledEnemyProvinces_ByAggrersors = 0;
        int tempControledEnemyProvinces_ByDefenders = 0;
        for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.size(); ++i) {
            try {
                block9: for (int j = 0; j < CFG.core.getCiv(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID).getNumOfProvs(); ++j) {
                    if (CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID == CFG.core.getProv(CFG.core.getCiv(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID).getProvID(j)).getTrueOwnerOfProv()) {
                        tempNumOfProvincesInWar_Aggrersors += CFG.core.getProvinceValue(CFG.core.getCiv(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID).getProvID(j));
                        continue;
                    }
                    for (k = 0; k < CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.size(); ++k) {
                        if (CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)k).iCivID != CFG.core.getProv(CFG.core.getCiv(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID).getProvID(j)).getTrueOwnerOfProv()) continue;
                        tempControledEnemyProvinces_ByAggrersors += CFG.core.getProvinceValue(CFG.core.getCiv(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID).getProvID(j));
                        continue block9;
                    }
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.size(); ++i) {
            try {
                block12: for (int j = 0; j < CFG.core.getCiv(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID).getNumOfProvs(); ++j) {
                    if (CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID == CFG.core.getProv(CFG.core.getCiv(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID).getProvID(j)).getTrueOwnerOfProv()) {
                        tempNumOfProvincesInWar_Defenders += CFG.core.getProvinceValue(CFG.core.getCiv(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID).getProvID(j));
                        continue;
                    }
                    for (k = 0; k < CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.size(); ++k) {
                        if (CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)k).iCivID != CFG.core.getProv(CFG.core.getCiv(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID).getProvID(j)).getTrueOwnerOfProv()) continue;
                        tempControledEnemyProvinces_ByDefenders += CFG.core.getProvinceValue(CFG.core.getCiv(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID).getProvID(j));
                        continue block12;
                    }
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        int tempAggressorsPerc = 0;
        int tempDefendersPerc = 0;
        try {
            tempAggressorsPerc = (int)((float)tempControledEnemyProvinces_ByAggrersors / (float)(tempNumOfProvincesInWar_Defenders + tempControledEnemyProvinces_ByDefenders + tempControledEnemyProvinces_ByAggrersors) * 100.0f);
        }
        catch (ArithmeticException ex) {
            tempAggressorsPerc = 0;
        }
        try {
            tempDefendersPerc = (int)((float)tempControledEnemyProvinces_ByDefenders / (float)(tempNumOfProvincesInWar_Aggrersors + tempControledEnemyProvinces_ByAggrersors + tempControledEnemyProvinces_ByDefenders) * 100.0f);
        }
        catch (ArithmeticException ex) {
            tempDefendersPerc = 0;
        }
        return -tempAggressorsPerc + tempDefendersPerc;
    }

    public final int getWarScore_DefendersInProvinceValue() {
        int k;
        int i;
        int outScore = 0;
        for (i = 0; i < this.getAggressorsSize(); ++i) {
            try {
                block5: for (int j = 0; j < CFG.core.getCiv(this.getAggressorID(i).getCivID()).getNumOfProvs(); ++j) {
                    if (this.getAggressorID(i).getCivID() == CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                    for (k = 0; k < this.getDefendersSize(); ++k) {
                        if (this.getDefenderID(k).getCivID() != CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                        outScore += CFG.core.getProvinceValue(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j));
                        continue block5;
                    }
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        for (i = 0; i < this.getDefendersSize(); ++i) {
            try {
                block8: for (int j = 0; j < CFG.core.getCiv(this.getDefenderID(i).getCivID()).getNumOfProvs(); ++j) {
                    if (this.getDefenderID(i).getCivID() == CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                    for (k = 0; k < this.getAggressorsSize(); ++k) {
                        if (this.getAggressorID(k).getCivID() != CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                        outScore -= CFG.core.getProvinceValue(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j));
                        continue block8;
                    }
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return outScore;
    }

    public final int getWarScore_DefendersInProvinceValue(int id) {
        int outScore = 0;
        for (int i = 0; i < this.getAggressorsSize(); ++i) {
            try {
                for (int j = 0; j < CFG.core.getCiv(this.getAggressorID(i).getCivID()).getNumOfProvs(); ++j) {
                    if (this.getAggressorID(i).getCivID() == CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv() || this.getDefenderID(id).getCivID() != CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                    outScore -= CFG.core.getProvinceValue(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j));
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        block6: for (int j = 0; j < CFG.core.getCiv(this.getDefenderID(id).getCivID()).getNumOfProvs(); ++j) {
            try {
                if (this.getDefenderID(id).getCivID() == CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(id).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                for (int k = 0; k < this.getAggressorsSize(); ++k) {
                    if (this.getAggressorID(k).getCivID() != CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(id).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                    outScore += CFG.core.getProvinceValue(CFG.core.getCiv(this.getDefenderID(id).getCivID()).getProvID(j));
                    continue block6;
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return outScore;
    }

    public final int getWarScore_DefendersInProvinceValue_OnlyPositive(int id, List<Boolean> addDefender, List<Boolean> addAggressor) {
        int outScore = 0;
        int iMinScore = 0;
        ArrayList<War_Points> nPoints = new ArrayList<War_Points>();
        try {
            int i;
            for (int k = 0; k < this.getAggressorsSize(); ++k) {
                nPoints.add(new War_Points(this.getAggressorID(k).getCivID()));
            }
            block9: for (int j = 0; j < CFG.core.getCiv(this.getDefenderID(id).getCivID()).getNumOfProvs(); ++j) {
                try {
                    if (this.getDefenderID(id).getCivID() == CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(id).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                    for (int k = 0; k < this.getAggressorsSize(); ++k) {
                        if (!addAggressor.get(k).booleanValue() || this.getAggressorID(k).getCivID() != CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(id).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                        int nValue = CFG.core.getProvinceValue(CFG.core.getCiv(this.getDefenderID(id).getCivID()).getProvID(j));
                        if (nValue > iMinScore) {
                            iMinScore = nValue;
                        }
                        ((War_Points)nPoints.get(k)).addPoints(nValue);
                        continue block9;
                    }
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            int defenderNumOfTrueProvinces = 0;
            for (i = 0; i < CFG.core.getCiv(this.getDefenderID(id).getCivID()).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(id).getCivID()).getProvID(i)).getTrueOwnerOfProv() != this.getDefenderID(id).getCivID()) continue;
                ++defenderNumOfTrueProvinces;
            }
            for (i = nPoints.size() - 1; i >= 0; --i) {
                try {
                    if ((float)defenderNumOfTrueProvinces >= (float)((War_Points)nPoints.get(i)).getNumOfProvincesTotal() * 2.5f || ((War_Points)nPoints.get(i)).getNumOfProvincesTotal() <= 2 || ((War_Points)nPoints.get((int)i)).iNumOfLostProvinces <= 2) {
                        outScore += ((War_Points)nPoints.get((int)i)).iPoints;
                        continue;
                    }
                    float fModifer = 1.0f;
                    try {
                        fModifer = ((War_Points)nPoints.get(i)).getNumOfProvincesTotal() == 3 ? GameValues.gvWar.WAR_SCORE_MODIFIER_BASE_SMALL_CIV + (1.0f - GameValues.gvWar.WAR_SCORE_MODIFIER_BASE_SMALL_CIV) * (1.0f - Math.min((float)this.getAggressorID(i).getConqueredProvinces() / (float)Math.max(this.getDefenderID(id).getConqueredProvinces(), 1), 1.0f)) : (defenderNumOfTrueProvinces < ((War_Points)nPoints.get(i)).getNumOfProvincesTotal() ? GameValues.gvWar.WAR_SCORE_MODIFIER_BASE_BIGGER_CIV + GameValues.gvWar.WAR_SCORE_MODIFIER_LOST_PROVINCES_WEIGHT * (float)(((War_Points)nPoints.get((int)i)).iNumOfLostProvinces / ((War_Points)nPoints.get(i)).getNumOfProvincesTotal()) + GameValues.gvWar.WAR_SCORE_MODIFIER_EXTRA_IF_SMALLER_CIV_WON * (1.0f - (float)defenderNumOfTrueProvinces / (float)((War_Points)nPoints.get(i)).getNumOfProvincesTotal()) + GameValues.gvWar.WAR_SCORE_MODIFIER_CONQUERED_PROVINCES_WEIGHT * (1.0f - Math.min((float)this.getAggressorID(i).getConqueredProvinces() / (float)Math.max(this.getDefenderID(id).getConqueredProvinces(), 1), 1.0f)) : GameValues.gvWar.WAR_SCORE_MODIFIER_BASE_BIGGER_CIV + GameValues.gvWar.WAR_SCORE_MODIFIER_LOST_PROVINCES_WEIGHT * (float)(((War_Points)nPoints.get((int)i)).iNumOfLostProvinces / ((War_Points)nPoints.get(i)).getNumOfProvincesTotal()) + GameValues.gvWar.WAR_SCORE_MODIFIER_CONQUERED_PROVINCES_WEIGHT * (1.0f - Math.min((float)this.getAggressorID(i).getConqueredProvinces() / (float)Math.max(this.getDefenderID(id).getConqueredProvinces(), 1), 1.0f)));
                    }
                    catch (IllegalArgumentException ex) {
                        fModifer = GameValues.gvWar.WAR_SCORE_MODIFIER_BASE_SMALL_CIV;
                        CFG.exceptionStack(ex);
                    }
                    outScore += (int)Math.max(Math.ceil((float)((War_Points)nPoints.get((int)i)).iPoints * fModifer), (double)((War_Points)nPoints.get((int)i)).iMinScore);
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
        }
        catch (Exception exr) {
            CFG.exceptionStack(exr);
        }
        return (int)((float)Math.max(outScore, iMinScore) * CFG.PEACE_TREATY_VICTORY_POINTS_MODIFIER);
    }

    public final int getWarScore_AggressorsInProvinceValue() {
        int outScore = 0;
        try {
            int k;
            int i;
            for (i = 0; i < this.getAggressorsSize(); ++i) {
                try {
                    block7: for (int j = 0; j < CFG.core.getCiv(this.getAggressorID(i).getCivID()).getNumOfProvs(); ++j) {
                        if (this.getAggressorID(i).getCivID() == CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                        for (k = 0; k < this.getDefendersSize(); ++k) {
                            if (this.getDefenderID(k).getCivID() != CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                            outScore -= CFG.core.getProvinceValue(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j));
                            continue block7;
                        }
                    }
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            for (i = 0; i < this.getDefendersSize(); ++i) {
                try {
                    block10: for (int j = 0; j < CFG.core.getCiv(this.getDefenderID(i).getCivID()).getNumOfProvs(); ++j) {
                        if (this.getDefenderID(i).getCivID() == CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                        for (k = 0; k < this.getAggressorsSize(); ++k) {
                            if (this.getAggressorID(k).getCivID() != CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                            outScore += CFG.core.getProvinceValue(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j));
                            continue block10;
                        }
                    }
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
        }
        catch (Exception exr) {
            CFG.exceptionStack(exr);
        }
        return outScore;
    }

    public final int getWarScore_AggressorsInProvinceValue(int id) {
        int outScore = 0;
        try {
            block6: for (int j = 0; j < CFG.core.getCiv(this.getAggressorID(id).getCivID()).getNumOfProvs(); ++j) {
                try {
                    if (this.getAggressorID(id).getCivID() == CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(id).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                    for (int k = 0; k < this.getDefendersSize(); ++k) {
                        if (this.getDefenderID(k).getCivID() != CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(id).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                        outScore += CFG.core.getProvinceValue(CFG.core.getCiv(this.getAggressorID(id).getCivID()).getProvID(j));
                        continue block6;
                    }
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            for (int i = 0; i < this.getDefendersSize(); ++i) {
                try {
                    for (int j = 0; j < CFG.core.getCiv(this.getDefenderID(i).getCivID()).getNumOfProvs(); ++j) {
                        if (this.getDefenderID(i).getCivID() == CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv() || this.getAggressorID(id).getCivID() != CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                        outScore -= CFG.core.getProvinceValue(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j));
                    }
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
        }
        catch (Exception exr) {
            CFG.exceptionStack(exr);
        }
        return outScore;
    }

    public final int getWarScore_AggressorsInProvinceValue_OnlyPositive(int id, List<Boolean> addDefender, List<Boolean> addAggressor) {
        int outScore = 0;
        int iMinScore = 0;
        ArrayList<War_Points> nPoints = new ArrayList<War_Points>();
        try {
            int i;
            for (int k = 0; k < this.getDefendersSize(); ++k) {
                try {
                    nPoints.add(new War_Points(this.getDefenderID(k).getCivID()));
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            block13: for (int j = 0; j < CFG.core.getCiv(this.getAggressorID(id).getCivID()).getNumOfProvs(); ++j) {
                try {
                    if (this.getAggressorID(id).getCivID() == CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(id).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                    for (int k = 0; k < this.getDefendersSize(); ++k) {
                        if (!addDefender.get(k).booleanValue() || this.getDefenderID(k).getCivID() != CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(id).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                        int nValue = CFG.core.getProvinceValue(CFG.core.getCiv(this.getAggressorID(id).getCivID()).getProvID(j));
                        if (nValue > iMinScore) {
                            iMinScore = nValue;
                        }
                        ((War_Points)nPoints.get(k)).addPoints(nValue);
                        continue block13;
                    }
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            int defenderNumOfTrueProvinces = 0;
            for (i = 0; i < CFG.core.getCiv(this.getAggressorID(id).getCivID()).getNumOfProvs(); ++i) {
                try {
                    if (CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(id).getCivID()).getProvID(i)).getTrueOwnerOfProv() != this.getAggressorID(id).getCivID()) continue;
                    ++defenderNumOfTrueProvinces;
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            for (i = nPoints.size() - 1; i >= 0; --i) {
                try {
                    if ((float)defenderNumOfTrueProvinces >= (float)((War_Points)nPoints.get(i)).getNumOfProvincesTotal() * 2.5f || ((War_Points)nPoints.get(i)).getNumOfProvincesTotal() <= 2 || ((War_Points)nPoints.get((int)i)).iNumOfLostProvinces <= 2) {
                        outScore += ((War_Points)nPoints.get((int)i)).iPoints;
                        continue;
                    }
                    float fModifer = 1.0f;
                    try {
                        fModifer = ((War_Points)nPoints.get(i)).getNumOfProvincesTotal() == 3 ? GameValues.gvWar.WAR_SCORE_MODIFIER_BASE_SMALL_CIV + (1.0f - GameValues.gvWar.WAR_SCORE_MODIFIER_BASE_SMALL_CIV) * (1.0f - Math.min((float)this.getDefenderID(i).getConqueredProvinces() / (float)Math.max(this.getAggressorID(id).getConqueredProvinces(), 1), 1.0f)) : (defenderNumOfTrueProvinces < ((War_Points)nPoints.get(i)).getNumOfProvincesTotal() ? GameValues.gvWar.WAR_SCORE_MODIFIER_BASE_BIGGER_CIV + GameValues.gvWar.WAR_SCORE_MODIFIER_LOST_PROVINCES_WEIGHT * (float)(((War_Points)nPoints.get((int)i)).iNumOfLostProvinces / ((War_Points)nPoints.get(i)).getNumOfProvincesTotal()) + GameValues.gvWar.WAR_SCORE_MODIFIER_EXTRA_IF_SMALLER_CIV_WON * (1.0f - (float)defenderNumOfTrueProvinces / (float)((War_Points)nPoints.get(i)).getNumOfProvincesTotal()) + GameValues.gvWar.WAR_SCORE_MODIFIER_CONQUERED_PROVINCES_WEIGHT * (1.0f - Math.min((float)this.getDefenderID(i).getConqueredProvinces() / (float)Math.max(this.getAggressorID(id).getConqueredProvinces(), 1), 1.0f)) : GameValues.gvWar.WAR_SCORE_MODIFIER_BASE_BIGGER_CIV + GameValues.gvWar.WAR_SCORE_MODIFIER_LOST_PROVINCES_WEIGHT * (float)(((War_Points)nPoints.get((int)i)).iNumOfLostProvinces / ((War_Points)nPoints.get(i)).getNumOfProvincesTotal()) + GameValues.gvWar.WAR_SCORE_MODIFIER_CONQUERED_PROVINCES_WEIGHT * (1.0f - Math.min((float)this.getDefenderID(i).getConqueredProvinces() / (float)Math.max(this.getAggressorID(id).getConqueredProvinces(), 1), 1.0f)));
                    }
                    catch (IllegalArgumentException ex) {
                        fModifer = GameValues.gvWar.WAR_SCORE_MODIFIER_BASE_SMALL_CIV;
                        CFG.exceptionStack(ex);
                    }
                    outScore += (int)Math.max(Math.ceil((float)((War_Points)nPoints.get((int)i)).iPoints * fModifer), (double)((War_Points)nPoints.get((int)i)).iMinScore);
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
        }
        catch (Exception exr) {
            CFG.exceptionStack(exr);
        }
        return (int)((float)Math.max(outScore, iMinScore) * CFG.PEACE_TREATY_VICTORY_POINTS_MODIFIER);
    }

    public final PeaceTreaty_Civs getDefenders_ProvincesLost(int id, List<Boolean> addDefender, List<Boolean> addAggressor) {
        id = Math.max(0, id);
        PeaceTreaty_Civs outPC = new PeaceTreaty_Civs(this.getDefenderID(id).getCivID());
        for (int i = 0; i < this.getAggressorsSize(); ++i) {
            try {
                if (!addAggressor.get(i).booleanValue()) continue;
                for (int j = 0; j < CFG.core.getCiv(this.getAggressorID(i).getCivID()).getNumOfProvs(); ++j) {
                    if (this.getAggressorID(i).getCivID() == CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv() || this.getDefenderID(id).getCivID() != CFG.core.getProv(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                    outPC.lProvincesLost.add(CFG.core.getCiv(this.getAggressorID(i).getCivID()).getProvID(j));
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return outPC;
    }

    public final PeaceTreaty_Civs getAggressors_ProvincesLost(int id, List<Boolean> addDefender, List<Boolean> addAggressor) {
        id = Math.max(0, id);
        PeaceTreaty_Civs outPC = new PeaceTreaty_Civs(this.getAggressorID(id).getCivID());
        for (int i = 0; i < this.getDefendersSize(); ++i) {
            try {
                if (!addDefender.get(i).booleanValue()) continue;
                for (int j = 0; j < CFG.core.getCiv(this.getDefenderID(i).getCivID()).getNumOfProvs(); ++j) {
                    if (this.getDefenderID(i).getCivID() == CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv() || this.getAggressorID(id).getCivID() != CFG.core.getProv(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j)).getTrueOwnerOfProv()) continue;
                    outPC.lProvincesLost.add(CFG.core.getCiv(this.getDefenderID(i).getCivID()).getProvID(j));
                }
                continue;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return outPC;
    }

    public final int getProvinces_Aggressor_Own(int i) {
        int out = 0;
        int civID = this.getAggressorID(i).getCivID();
        Civilization civAgg = CFG.core.getCiv(civID);
        for (int j = 0; j < civAgg.getNumOfProvs(); ++j) {
            int provID = civAgg.getProvID(j);
            int trueOwner = CFG.core.getProv(provID).getTrueOwnerOfProv();
            if (trueOwner == civID) {
                out++;
            } else if (this.getIsInDefenders(trueOwner)) {
                out++;
            }
        }
        return out;
    }

    public final int getProvinces_Aggressor_OwnTotal(int i) {
        int out = 0;
        int civID = this.getAggressorID(i).getCivID();
        for (int j = 0; j < CFG.core.getProvinSize(); ++j) {
            if (CFG.core.getProv(j).getTrueOwnerOfProv() == civID) {
                out++;
            }
        }
        return out;
    }

    public final int getProvinces_Defender_Own(int i) {
        int out = 0;
        int civID = this.getDefenderID(i).getCivID();
        Civilization civDef = CFG.core.getCiv(civID);
        for (int j = 0; j < civDef.getNumOfProvs(); ++j) {
            int provID = civDef.getProvID(j);
            int trueOwner = CFG.core.getProv(provID).getTrueOwnerOfProv();
            if (trueOwner == civID) {
                out++;
            } else if (this.getIsInAggressors(trueOwner)) {
                out++;
            }
        }
        return out;
    }

    public final int getProvinces_Defender_OwnTotal(int i) {
        int out = 0;
        int civID = this.getDefenderID(i).getCivID();
        for (int j = 0; j < CFG.core.getProvinSize(); ++j) {
            if (CFG.core.getProv(j).getTrueOwnerOfProv() == civID) {
                out++;
            }
        }
        return out;
    }

    public final WarCiv_GameData getAggressorID(int i) {
        return this.lAggressors.get(i);
    }

    public final int getAggressorID_ByCivID(int nCivID) {
        try {
            for (int i = 0; i < this.getAggressorsSize(); ++i) {
                if (this.getAggressorID(i).getCivID() != nCivID) continue;
                return i;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return -1;
    }

    public final boolean getIsInAggressors(int nCivID) {
        try {
            for (int i = 0; i < this.getAggressorsSize(); ++i) {
                if (this.getAggressorID(i).getCivID() != nCivID) continue;
                return true;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return false;
    }

    public final int getAggressorsSize() {
        return this.lAggressors.size();
    }

    public final WarCiv_GameData getDefenderID(int i) {
        return this.lDefenders.get(i);
    }

    public final int getDefenderID_ByCivID(int nCivID) {
        try {
            for (int i = 0; i < this.getDefendersSize(); ++i) {
                if (this.getDefenderID(i).getCivID() != nCivID) continue;
                return i;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return -1;
    }

    public final boolean getIsInDefenders(int nCivID) {
        try {
            for (int i = 0; i < this.getDefendersSize(); ++i) {
                if (this.getDefenderID(i).getCivID() != nCivID) continue;
                return true;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return false;
    }

    public final int getDefendersSize() {
        return this.lDefenders.size();
    }

    public final int getParticipation_DefenderID(int nID) {
        long out = 0L;
        for (int i = 0; i < this.getDefendersSize(); ++i) {
            out += this.getDefenderID(i).getCasualties();
        }
        if (out == 0) {
            return 100;
        }
        return (int)(nID == 0 ? Math.ceil((float)this.getDefenderID(nID).getCasualties() / (float)out * 100.0f) : Math.floor((float)this.getDefenderID(nID).getCasualties() / (float)out * 100.0f));
    }

    public final int getParticipation_AggressorID(int nID) {
        long out = 0L;
        for (int i = 0; i < this.getAggressorsSize(); ++i) {
            out += this.getAggressorID(i).getCasualties();
        }
        if (out == 0) {
            return 100;
        }
        return (int)(nID == 0 ? Math.ceil((float)this.getAggressorID(nID).getCasualties() / (float)out * 100.0f) : Math.floor((float)this.getAggressorID(nID).getCasualties() / (float)out * 100.0f));
    }

    public final void addConqueredProvinces(int iCivID) {
        int i;
        this.iLastTurn_ConqueredProvince = GameCalendar.TURNID;
        for (i = 0; i < this.getDefendersSize(); ++i) {
            if (this.getDefenderID(i).getCivID() != iCivID) continue;
            this.getDefenderID(i).addConqueredProvinces();
            return;
        }
        for (i = 0; i < this.getAggressorsSize(); ++i) {
            if (this.getAggressorID(i).getCivID() != iCivID) continue;
            this.getAggressorID(i).addConqueredProvinces();
            return;
        }
    }

    public final void addCasualties(int iCivID, long iCasualties) {
        int i;
        this.iLastFight_InTurns = 0;
        this.wasAnyAttack = true;
        for (i = 0; i < this.getDefendersSize(); ++i) {
            if (this.getDefenderID(i).getCivID() != iCivID) continue;
            this.getDefenderID(i).addCasualties(iCasualties);
            CFG.core.getCiv((int)iCivID).civGD.ttWC += iCasualties;
            return;
        }
        for (i = 0; i < this.getAggressorsSize(); ++i) {
            if (this.getAggressorID(i).getCivID() != iCivID) continue;
            this.getAggressorID(i).addCasualties(iCasualties);
            CFG.core.getCiv((int)iCivID).civGD.ttWC += iCasualties;
            return;
        }
    }

    public final void addCivilianEconomicLosses(int iCivID, long iCivilianDeaths, long iEconomicLosses) {
        int i;
        this.iLastFight_InTurns = 0;
        for (i = 0; i < this.getDefendersSize(); ++i) {
            if (this.getDefenderID(i).getCivID() != iCivID) continue;
            this.getDefenderID(i).addCivilianDeaths(iCivilianDeaths);
            this.getDefenderID(i).addEconomicLosses(iEconomicLosses);
            CFG.core.getCiv((int)iCivID).civGD.ttWC += iCivilianDeaths;
            return;
        }
        for (i = 0; i < this.getAggressorsSize(); ++i) {
            if (this.getAggressorID(i).getCivID() != iCivID) continue;
            this.getAggressorID(i).addCivilianDeaths(iCivilianDeaths);
            this.getAggressorID(i).addEconomicLosses(iEconomicLosses);
            CFG.core.getCiv((int)iCivID).civGD.ttWC += iCivilianDeaths;
            return;
        }
    }

    public final long getCasualties_Defenders() {
        long out = 0L;
        for (int i = 0; i < this.getDefendersSize(); ++i) {
            out += this.getDefenderID(i).getCasualties();
            out += this.getDefenderID(i).getCivilianDeaths();
        }
        return out;
    }

    public final int getCasualties_Defenders_Int() {
        return (int)this.getCasualties_Defenders();
    }

    public final long getCasualties_Aggressors() {
        long out = 0L;
        for (int i = 0; i < this.getAggressorsSize(); ++i) {
            out += this.getAggressorID(i).getCasualties();
            out += this.getAggressorID(i).getCivilianDeaths();
        }
        return out;
    }

    public final int getCasualties_Aggressors_Int() {
        return (int)this.getCasualties_Aggressors();
    }

    public final int getWarTurnID() {
        return this.iWarTurnID;
    }

    public final void setWarTurnID(int iWarTurnID) {
        this.iWarTurnID = iWarTurnID;
    }
}

