/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Civilizations.Construction;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;

public class BuildingsConstruction__Farm
extends BuildingsConstruction {
    public BuildingsConstruction__Farm(int iProvinceID, int iNumOfTurnsLeft) {
        super(iProvinceID, iNumOfTurnsLeft);
        this.constructionType = ConstructionType.FARM;
    }

    @Override
    public void onConstructedRun(int nCivID) {
        if (CFG.core.getProv(this.iProviID).getCivId() == nCivID || CFG.core.getCiv(CFG.core.getProv(this.iProviID).getCivId()).getPuppetOfCiv() == nCivID) {
            BuildingsManager.buildFarm(this.iProviID, nCivID);
        }
    }
}

