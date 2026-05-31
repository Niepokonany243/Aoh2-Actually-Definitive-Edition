
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menus.Wars.Details.Menu_InGame_WarDetails;
import java.util.List;

public class Button_Diplomacy_InGameWar
extends ButtonDiplomacy {
    public Button_Diplomacy_InGameWar(int iDiploImageID, List<Integer> nCivs, int iPosX, int iPosY, int iWidth) {
        super(iDiploImageID, nCivs, iPosX, iPosY, iWidth);
    }

    @Override
    public void setAnotherView(boolean inAnotherView) {
        if (this.iHoveredID >= 0) {
            int tWarID = CFG.core.getWarID(CFG.getActiveCivInfoId(), (Integer)this.lCivs.get(this.iHoveredID));
            if (tWarID >= 0 && tWarID < CFG.core.getWarsSize()) {
                Menu_InGame_WarDetails.WAR_ID = tWarID;
                CFG.menus.rebuildInGame_WarDetails();
            } else {
                CFG.core.disableDrawCivilizationRegions(CFG.getActiveCivInfoId());
                CFG.setActiveCivInfoId((Integer)this.lCivs.get(this.iHoveredID));
                try {
                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID());
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    
                }
                CFG.updateActiveCivilizationInfoInGame();
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE) {
                    CFG.core.enableDrawCivilizationRegions(CFG.getActiveCivInfoId(), 1);
                }
            }
        }
    }
}

