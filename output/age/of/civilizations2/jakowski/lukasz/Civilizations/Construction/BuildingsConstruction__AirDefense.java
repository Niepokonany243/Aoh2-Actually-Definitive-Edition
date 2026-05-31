package age.of.civilizations2.jakowski.lukasz.Civilizations.Construction;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;

public class BuildingsConstruction__AirDefense extends BuildingsConstruction {
    public BuildingsConstruction__AirDefense(int iProvinceID, int iNumOfTurnsLeft) {
        super(iProvinceID, iNumOfTurnsLeft);
        this.constructionType = ConstructionType.AIR_DEFENSE;
    }

    @Override
    public void onConstructedRun(int nCivID) {
        if (CFG.core.getProv(this.iProviID).getCivId() == nCivID || CFG.core.getCiv(CFG.core.getProv(this.iProviID).getCivId()).getPuppetOfCiv() == nCivID) {
            BuildingsManager.buildAirDefense(this.iProviID, nCivID);
        }
    }
}
