/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI.AI_Build;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import java.util.ArrayList;
import java.util.List;

public class AI_Build_Farm
extends AI_Build {
    private List<Integer> lBuildCost = new ArrayList<Integer>();

    public AI_Build_Farm(int nCivID, long nMoney) {
        super(nCivID, nMoney);
        try {
            int i;
            for (i = 0; i < BuildingsManager.getFarm_MaxLevel(); ++i) {
                this.lBuildCost.add(BuildingsManager.getFarm_BuildCost(i + 1, CFG.core.getCiv(nCivID).getProvID(0)));
                this.lProvincesToBuild.add(new ArrayList());
            }
            if (nMoney >= (long)this.lBuildCost.get(0).intValue()) {
                for (i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                    if (CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).isOccupied() || !(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getProviStability() > GameValues.gvAiProvince.BUILD_MIN_STABILITY) || !(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getRevRisk() <= GameValues.gvAiProvince.BUILD_MAX_REV_RISK) || !BuildingsManager.canBuildFarm(CFG.core.getCiv(nCivID).getProvID(i)) || CFG.core.getCiv(nCivID).isInConstruction(CFG.core.getCiv(nCivID).getProvID(i), ConstructionType.FARM) != 0) continue;
                    try {
                        if (nMoney < (long)this.lBuildCost.get(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getLvlOfFarm()).intValue()) continue;
                        ((List)this.lProvincesToBuild.get(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getLvlOfFarm())).add(CFG.core.getCiv(nCivID).getProvID(i));
                        ++this.iProvincesToBuild_NumOfElements;
                        this.iMaxDangerLevel = Math.max(this.iMaxDangerLevel, CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getDangerLvl());
                        continue;
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        // empty catch block
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public int getNumOfAlreadyBuilt(int nCivID) {
        return CFG.core.getCiv((int)nCivID).numOf_Farms;
    }

    @Override
    public boolean build(int nCivID, int iteration, boolean out) {
        int iBestProvinceID = -1;
        float iBestProvinceID_Score = 0.0f;
        for (int i = this.lProvincesToBuild.size() - 1; i >= 0; --i) {
            for (int j = ((List)this.lProvincesToBuild.get(i)).size() - 1; j >= 0; --j) {
                if (iBestProvinceID < 0) {
                    iBestProvinceID = (Integer)((List)this.lProvincesToBuild.get(i)).get(j);
                    iBestProvinceID_Score = this.getProvinceBuildScore(nCivID, iBestProvinceID);
                    continue;
                }
                if (!(this.getProvinceBuildScore(nCivID, (Integer)((List)this.lProvincesToBuild.get(i)).get(j)) > iBestProvinceID_Score)) continue;
                iBestProvinceID = (Integer)((List)this.lProvincesToBuild.get(i)).get(j);
                iBestProvinceID_Score = this.getProvinceBuildScore(nCivID, iBestProvinceID);
            }
        }
        if (iBestProvinceID >= 0 && BuildingsManager.constructFarm(iBestProvinceID, nCivID)) {
            out = true;
            if (this.getMoney(nCivID) > (long)this.lBuildCost.get(0).intValue() && BuildingsManager.getFarm_BuildMovementCost(1) <= CFG.core.getCiv(nCivID).getMovemPoints()) {
                int tSize = 0;
                for (int i = this.lProvincesToBuild.size() - 1; i >= 0; --i) {
                    for (int j = ((List)this.lProvincesToBuild.get(i)).size() - 1; j >= 0; --j) {
                        if ((Integer)((List)this.lProvincesToBuild.get(i)).get(j) == iBestProvinceID) {
                            ((List)this.lProvincesToBuild.get(i)).remove(j);
                            continue;
                        }
                        ++tSize;
                    }
                }
                if (tSize > 0 && iteration < 4) {
                    return this.build(nCivID, ++iteration, out);
                }
            }
        }
        return out;
    }

    public float getProvinceBuildScore(int nCivID, int nProvinceID) {
        return ((float)CFG.core.getProv(nProvinceID).getPop().getPops() * CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_WORKSHOP_POP_SCORE + (float)CFG.core.getProv(nProvinceID).getEco() * CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_WORKSHOP_ECO_SCORE) * (1.0f - CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_STABILITY_SCORE + CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_STABILITY_SCORE * CFG.core.getProv(nProvinceID).getProviStability()) * (1.0f - CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_DANGER_SCORE * (float)CFG.core.getProv(nProvinceID).getDangerLvl() / (float)this.iMaxDangerLevel) * (1.0f - CFG.core.getProv(nProvinceID).getRevRisk());
    }
}

