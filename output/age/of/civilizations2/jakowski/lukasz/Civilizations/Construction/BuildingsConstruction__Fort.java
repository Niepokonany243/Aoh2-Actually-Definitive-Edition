/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Civilizations.Construction;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;

public class BuildingsConstruction__Fort
extends BuildingsConstruction {
    public BuildingsConstruction__Fort(int iProvinceID, int iNumOfTurnsLeft) {
        super(iProvinceID, iNumOfTurnsLeft);
        this.constructionType = ConstructionType.FORT;
    }

    @Override
    public void onConstructedRun(int nCivID) {
        if (CFG.core.getProv(this.iProviID).getCivId() == nCivID || CFG.core.getCiv(CFG.core.getProv(this.iProviID).getCivId()).getPuppetOfCiv() == nCivID) {
            BuildingsManager.buildFort(this.iProviID, nCivID);
        }
    }
}

