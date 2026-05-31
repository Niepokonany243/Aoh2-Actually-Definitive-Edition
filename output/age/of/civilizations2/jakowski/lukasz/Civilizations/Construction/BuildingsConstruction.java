
package age.of.civilizations2.jakowski.lukasz.Civilizations.Construction;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import java.io.Serializable;

public class BuildingsConstruction
implements Serializable {
    private static final long serialVersionUID = 0L;
    public ConstructionType constructionType = ConstructionType.PORT;
    public int iProviID;
    public int iNumOfTurnsLeft;

    public BuildingsConstruction(int iProviID, int iNumOfTurnsLeft) {
        this.iProviID = iProviID;
        this.iNumOfTurnsLeft = iNumOfTurnsLeft;
    }

    public void onConstructedRun(int nCivID) {
        if (CFG.core.getProv(this.iProviID).getCivId() == nCivID || CFG.core.getCiv(CFG.core.getProv(this.iProviID).getCivId()).getPuppetOfCiv() == nCivID) {
            BuildingsManager.buildPort(this.iProviID, nCivID);
        }
    }
}

