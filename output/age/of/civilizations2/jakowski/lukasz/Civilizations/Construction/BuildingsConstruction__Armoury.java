
package age.of.civilizations2.jakowski.lukasz.Civilizations.Construction;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;

public class BuildingsConstruction__Armoury
extends BuildingsConstruction {
    public BuildingsConstruction__Armoury(int iProvinceID, int iNumOfTurnsLeft) {
        super(iProvinceID, iNumOfTurnsLeft);
        this.constructionType = ConstructionType.ARMOURY;
    }

    @Override
    public void onConstructedRun(int nCivID) {
        if (CFG.core.getProv(this.iProviID).getCivId() == nCivID || CFG.core.getCiv(CFG.core.getProv(this.iProviID).getCivId()).getPuppetOfCiv() == nCivID) {
            BuildingsManager.buildArmoury(this.iProviID, nCivID);
        }
    }
}

