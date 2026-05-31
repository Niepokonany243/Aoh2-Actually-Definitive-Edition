/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.Render;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_PlayerCiv
extends Event_Outcome {
    private static final long serialVersionUID = 2940259767308827562L;
    public int iCivID = -1;
    public long iValue = 0;

    @Override
    public int getCivID() {
        return this.iCivID;
    }

    @Override
    public void setCivID(int nCivID) {
        this.iCivID = nCivID;
    }

    @Override
    public boolean updateCivIDAfterRemove(int nRemovedCivID) {
        if (this.iCivID == nRemovedCivID) {
            this.iCivID = -1;
            return true;
        }
        if (nRemovedCivID < this.iCivID) {
            --this.iCivID;
        }
        return false;
    }

    @Override
    public void outcomeAction() {
        block10: {
            try {
                if (!this.canMakeAction()) break block10;
                CFG.core.getPlayer(CFG.PLAYER_TURN_ID).setCivId(this.getCivID());
                CFG.menus.setMenuIDWithoutAnim(View.eINGAME);
                try {
                    int i;
                    if (CFG.FOG_OF_WAR == 2) {
                        CFG.gameAction.buildFogOfWar(0);
                        CFG.core.getPlayer(0).buildMetProvsAndCivs();
                        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                            CFG.core.getProv(i).updateProvinceBorder();
                        }
                        Render.updateDrawCivRegionNames_FogOfWar();
                    } else {
                        CFG.gameAction.buildFogOfWar(0);
                    }
                    for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                        CFG.core.getProv(i).updateDrawArmyInProv();
                    }
                    CFG.map.getMpB().disposeMinimapOfCivilizations();
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                try {
                    CFG.gameAction.loadActivePlayerData();
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public boolean canMakeAction() {
        try {
            return this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize() && CFG.core.getCiv(this.getCivID()).getNumOfProvs() > 0;
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("Player") + ", " + CFG.lang.get("Civilization") + " -> " + CFG.core.getCiv(this.getCivID()).getCivName();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("Player") + ", " + CFG.lang.get("Civilization") + " -> ";
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        try {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            if (this.canMakeAction()) {
                tData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Player") + ", " + CFG.lang.get("Civilization") + " -> "));
                tData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.getCivID()).getCivName(), CFG.COLOR_HOVER_TITLE));
                tData.add(new ME_Hover_2Type_Flag(this.getCivID(), CFG.PADD, 0));
                tElements.add(new MEHover_2E(tData));
                tData.clear();
            }
            return tElements;
        }
        catch (Exception exception) {
            return new ArrayList<MEHover_2E>();
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_PLAYERCIV);
    }
}

