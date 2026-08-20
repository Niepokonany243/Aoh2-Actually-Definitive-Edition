
package age.of.civilizations2.jakowski.lukasz.AI.AI_Build;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import java.util.ArrayList;
import java.util.List;

public class AI_Build_Port
extends AI_Build {
    private List<Integer> lBuildCost = new ArrayList<Integer>();
    private List<Boolean> haveAccessToBasins = new ArrayList<Boolean>();

    public AI_Build_Port(int nCivID, long nMoney) {
        super(nCivID, nMoney);
        try {
            int i;
            boolean atWar = CFG.core.getCiv(nCivID).isAtWarC() || CFG.core.getCiv(nCivID).civGD.civPlans.isPreparingForTheWar();
            for (i = 0; i < BuildingsManager.getPort_MaxLevel(); ++i) {
                this.lBuildCost.add(BuildingsManager.getPort_BuildCost(i + 1, CFG.core.getCiv(nCivID).getProvID(0)));
                this.lProvincesToBuild.add(new ArrayList());
            }
            if (atWar || nMoney >= (long)this.lBuildCost.get(0).intValue()) {
                for (i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                    if (CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).isOccupied() || !(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getProviStability() > GameValues.gvAiProvince.BUILD_MIN_STABILITY) || !(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getRevRisk() <= GameValues.gvAiProvince.BUILD_MAX_REV_RISK) || !BuildingsManager.canBuildPort(CFG.core.getCiv(nCivID).getProvID(i)) || CFG.core.getCiv(nCivID).isInConstruction(CFG.core.getCiv(nCivID).getProvID(i), ConstructionType.PORT) != 0) continue;
                    try {
                        if (!atWar && nMoney < (long)this.lBuildCost.get(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getLvlOfPort()).intValue()) continue;
                        ((List)this.lProvincesToBuild.get(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getLvlOfPort())).add(CFG.core.getCiv(nCivID).getProvID(i));
                        ++this.iProvincesToBuild_NumOfElements;
                        this.iMaxDangerLevel = Math.max(this.iMaxDangerLevel, CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getDangerLvl());
                        continue;
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        
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
        return CFG.core.getCiv((int)nCivID).numOf_Libraries;
    }

    @Override
    public boolean build(int nCivID, int iteration, boolean out) {
        int j;
        int i;
        int iBestProvinceID = -1;
        float iBestProvinceID_Score = 0.0f;
        for (i = 0; i < CFG.map.numOfBasins; ++i) {
            this.haveAccessToBasins.add(false);
        }
        for (i = CFG.core.getCiv(nCivID).getSeaAccess_Provinces_Size() - 1; i >= 0; --i) {
            for (j = 0; j < CFG.core.getProv(CFG.core.getCiv(nCivID).getSeaAccessProvinces().get(i)).getNeighSeaProvincesSize(); ++j) {
                CFG.basinSet(this.haveAccessToBasins, CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getSeaAccessProvinces().get(i)).getNeighSeaProvinces(j)).getBasinID(), true);
            }
        }
        for (i = this.lProvincesToBuild.size() - 1; i >= 0; --i) {
            for (j = ((List)this.lProvincesToBuild.get(i)).size() - 1; j >= 0; --j) {
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
        if (iBestProvinceID >= 0 && BuildingsManager.constructPort(iBestProvinceID, nCivID)) {
            out = true;
        }
        this.haveAccessToBasins.clear();
        return out;
    }

    public float getProvinceBuildScore(int nCivID, int nProvinceID) {
        if (this.civRegion_HaveBuiltPort(nCivID, nProvinceID)) {
            return (float)CFG.core.getProv(nProvinceID).getPop().getPops() / (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (1.0f - CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_STABILITY_SCORE + CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_STABILITY_SCORE * CFG.core.getProv(nProvinceID).getProviStability()) * (1.0f - CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_DANGER_SCORE * (float)CFG.core.getProv(nProvinceID).getDangerLvl() / (float)this.iMaxDangerLevel) * (1.0f - CFG.core.getProv(nProvinceID).getRevRisk());
        }
        return (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (1.0f + CFG.core.getProv(nProvinceID).getGrowthRate_Pop() * 10.0f);
    }

    public boolean civRegion_HaveBuiltPort(int nCivID, int nProvinceID) {
        try {
            return CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getCivRegion(CFG.core.getProv(nProvinceID).getCivRegionID()).getSeaAccess_HavePort();
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
            return true;
        }
        catch (NullPointerException ex) {
            CFG.exceptionStack(ex);
            return true;
        }
    }

    public boolean haveAccessToBasinWithoutPort(int nProvinceID) {
        boolean out = false;
        for (int i = 0; i < CFG.core.getProv(nProvinceID).getNeighSeaProvincesSize(); ++i) {
            if (CFG.basinGet(this.haveAccessToBasins, CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighSeaProvinces(i)).getBasinID())) continue;
            out = true;
            break;
        }
        return out;
    }
}

