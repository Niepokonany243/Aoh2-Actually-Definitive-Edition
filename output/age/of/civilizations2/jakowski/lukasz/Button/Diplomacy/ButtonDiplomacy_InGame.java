/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import java.util.List;

public class ButtonDiplomacy_InGame
extends ButtonDiplomacy {
    public ButtonDiplomacy_InGame(int iDiploImageID, List<Integer> nCivs, int iPosX, int iPosY, int iWidth) {
        super(iDiploImageID, nCivs, iPosX, iPosY, iWidth);
    }

    @Override
    public void setAnotherView(boolean inAnotherView) {
        if (this.iHoveredID >= 0 && (Integer)this.lCivs.get(this.iHoveredID) >= 0) {
            block9: {
                CFG.core.disableDrawCivilizationRegions(CFG.getActiveCivInfoId());
                CFG.setActiveCivInfoId((Integer)this.lCivs.get(this.iHoveredID));
                try {
                    if (CFG.FOG_OF_WAR == 2) {
                        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID())) {
                            CFG.core.setActiveProvID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID());
                            break block9;
                        }
                        for (int i = 0; i < CFG.core.getCiv(CFG.getActiveCivInfoId()).getNumOfProvs(); ++i) {
                            if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getProvID(i))) continue;
                            CFG.core.setActiveProvID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getProvID(i));
                            break block9;
                        }
                        break block9;
                    }
                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID());
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            CFG.updateActiveCivilizationInfoInGame();
            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE) {
                if (CFG.FOG_OF_WAR == 2) {
                    CFG.core.enableDrawCivilizationRegions_FogOfWar(CFG.getActiveCivInfoId(), 1);
                } else {
                    CFG.core.enableDrawCivilizationRegions(CFG.getActiveCivInfoId(), 1);
                }
            }
        }
    }
}

