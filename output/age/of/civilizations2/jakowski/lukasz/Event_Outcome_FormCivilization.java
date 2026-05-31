
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization_GameData3;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_FormCivilization
extends Event_Outcome {
    private static final long serialVersionUID = 1156723329409849606L;
    public int iCivID = -1;
    public String sTag = "";

    @Override
    public int getCivID() {
        return this.iCivID;
    }

    @Override
    public void setCivID(int nCivID) {
        this.iCivID = nCivID;
    }

    @Override
    public String getText() {
        return this.sTag;
    }

    @Override
    public void setText(String nText) {
        this.sTag = nText;
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
        if (this.canMakeAction()) {
            int i;
            int civAlreadyIsAdded = -1;
            for (i = 0; i < CFG.core.getCivsSize(); ++i) {
                if (!CFG.core.getCiv(i).getCivTag().equals(this.sTag)) continue;
                civAlreadyIsAdded = i;
                if (CFG.core.getCiv(i).getNumOfProvs() <= 0 && civAlreadyIsAdded != this.getCivID()) break;
                return;
            }
            if (civAlreadyIsAdded > 0) {
                int i2;
                int i3;
                String tempTag = CFG.core.getCiv(this.getCivID()).getCivTag();
                CFG.core.getCiv(this.getCivID()).setCivTag(CFG.core.getCiv(civAlreadyIsAdded).getCivTag());
                CFG.core.getCiv(civAlreadyIsAdded).setCivTag(tempTag);
                Core.addSimpleTask(new Core.SimpleTask("loadFlag" + this.getCivID(), this.getCivID()){

                    @Override
                    public void update() {
                        CFG.core.getCiv(this.id).loadFlag();
                    }
                });
                Core.addSimpleTask(new Core.SimpleTask("loadFlag" + civAlreadyIsAdded, civAlreadyIsAdded){

                    @Override
                    public void update() {
                        CFG.core.getCiv(this.id).loadFlag();
                    }
                });
                for (i3 = 0; i3 < CFG.core.getCiv(this.getCivID()).getCivRegionsSize(); ++i3) {
                    CFG.core.getCiv(this.getCivID()).getCivRegion(i3).buildScaleOfText();
                }
                for (i3 = 0; i3 < CFG.core.getCiv(civAlreadyIsAdded).getCivRegionsSize(); ++i3) {
                    CFG.core.getCiv(civAlreadyIsAdded).getCivRegion(i3).buildScaleOfText();
                }
                int tColor = CFG.core.getCiv(this.getCivID()).getR();
                CFG.core.getCiv(this.getCivID()).setR(CFG.core.getCiv(civAlreadyIsAdded).getR());
                CFG.core.getCiv(civAlreadyIsAdded).setR(tColor);
                tColor = CFG.core.getCiv(this.getCivID()).getG();
                CFG.core.getCiv(this.getCivID()).setG(CFG.core.getCiv(civAlreadyIsAdded).getG());
                CFG.core.getCiv(civAlreadyIsAdded).setG(tColor);
                tColor = CFG.core.getCiv(this.getCivID()).getB();
                CFG.core.getCiv(this.getCivID()).setB(CFG.core.getCiv(civAlreadyIsAdded).getB());
                CFG.core.getCiv(civAlreadyIsAdded).setB(tColor);
                CFG.core.getCiv(this.getCivID()).updateCivilizationIdeology();
                CFG.core.getCiv(civAlreadyIsAdded).updateCivilizationIdeology();
                CFG.gameNewGame.updateFormableCivilizations(this.getCivID());
                CFG.gameNewGame.updateFormableCivilizations(civAlreadyIsAdded);
                for (i2 = 0; i2 < CFG.core.getCiv(this.getCivID()).getNumOfProvs(); ++i2) {
                    CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getProvID(i2)).setFromCivID(0);
                }
                for (i2 = 0; i2 < CFG.core.getCiv(civAlreadyIsAdded).getNumOfProvs(); ++i2) {
                    CFG.core.getProv(CFG.core.getCiv(civAlreadyIsAdded).getProvID(i2)).setFromCivID(0);
                }
                for (i2 = 0; i2 < CFG.core.getPlayersSize(); ++i2) {
                    if (CFG.core.getPlayer(i2).getCivId() != this.getCivID() && CFG.core.getPlayer(i2).getCivId() != civAlreadyIsAdded) continue;
                    Core.addSimpleTask(new Core.SimpleTask("updatePlayerFlag" + i2, i2){

                        @Override
                        public void update() {
                            CFG.core.getPlayer(this.id).loadPlayersFlag();
                        }
                    });
                }
                CFG.eventsManager.swapIDsOfCivs(this.getCivID(), civAlreadyIsAdded);
                if (CFG.core.getActiveProvID() >= 0) {
                    int tID = CFG.core.getActiveProvID();
                    CFG.core.setActiveProvID(-1);
                    CFG.core.setActiveProvID(tID);
                }
            } else {
                CFG.core.getCiv(this.getCivID()).setCivTag(this.getText());
                CFG.core.getCiv(this.getCivID()).setCivName(CFG.lang.getCiv(CFG.core.getCiv(this.getCivID()).getCivTag()));
                CFG.core.getCiv(this.getCivID()).loadFlag();
                Core.addSimpleTask(new Core.SimpleTask("loadFlag" + this.getCivID(), this.getCivID()){

                    @Override
                    public void update() {
                        CFG.core.getCiv(this.id).loadFlag();
                    }
                });
                for (i = 0; i < CFG.core.getCiv(this.getCivID()).getCivRegionsSize(); ++i) {
                    CFG.core.getCiv(this.getCivID()).getCivRegion(i).buildScaleOfText();
                }
                CFG.core.getCiv(this.getCivID()).updateCivilizationIdeology();
                try {
                    Civilization_GameData3 tempCivData = Core.loadCivilization(this.getText());
                    if (tempCivData != null) {
                        if (this.getText().equals(CFG.ideologiesMgr.getRealTag(this.getText()))) {
                            CFG.core.getCiv(this.getCivID()).setR(tempCivData.getR());
                            CFG.core.getCiv(this.getCivID()).setG(tempCivData.getG());
                            CFG.core.getCiv(this.getCivID()).setB(tempCivData.getB());
                        } else {
                            int tempIdeologyID = CFG.ideologiesMgr.getIdeologyID(this.getText());
                            Color tempColor = CFG.getColorMixed(new Color((float)tempCivData.getR() / 255.0f, (float)tempCivData.getG() / 255.0f, (float)tempCivData.getB() / 255.0f, 0.775f), new Color(CFG.ideologiesMgr.getIdeologyID((int)tempIdeologyID).getColor().r, CFG.ideologiesMgr.getIdeologyID((int)tempIdeologyID).getColor().g, CFG.ideologiesMgr.getIdeologyID((int)tempIdeologyID).getColor().b, 0.225f));
                            CFG.core.getCiv(this.getCivID()).setR((int)(tempColor.r * 255.0f));
                            CFG.core.getCiv(this.getCivID()).setG((int)(tempColor.g * 255.0f));
                            CFG.core.getCiv(this.getCivID()).setB((int)(tempColor.b * 255.0f));
                        }
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                CFG.gameNewGame.updateFormableCivilizations(this.getCivID());
                for (int i4 = 0; i4 < CFG.core.getCiv(this.getCivID()).getNumOfProvs(); ++i4) {
                    CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getProvID(i4)).setFromCivID(0);
                }
                if (CFG.core.getActiveProvID() >= 0) {
                    int tID = CFG.core.getActiveProvID();
                    CFG.core.setActiveProvID(-1);
                    CFG.core.setActiveProvID(tID);
                }
            }
        }
    }

    public boolean canMakeAction() {
        try {
            for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
                if (!CFG.core.getCiv(i).getCivTag().equals(this.sTag)) continue;
                if (CFG.core.getCiv(i).getNumOfProvs() <= 0) break;
                return false;
            }
            return this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize() && !this.sTag.equals("");
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        try {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            if (this.canMakeAction()) {
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("FormCivilization") + ": ", CFG.COLOR_HOVER_TITLE));
                tData.add(new ME_Hover_2Type_Flag(this.getCivID(), 0, CFG.PADD));
                tData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.getCivID()).getCivName()));
                tData.add(new ME_Hover_2Type_Text(" -> ", CFG.COLOR_NEUTRAL));
                tData.add(new ME_Hover_2Type_Text(CFG.lang.getCiv(this.getText())));
                tElements.add(new MEHover_2E(tData));
                tData.clear();
            }
            return tElements;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            
        }
        return new ArrayList<MEHover_2E>();
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("FormCivilization") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + " -> " + CFG.lang.getCiv(this.getText());
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("FormCivilization");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_FORM_CIV);
    }
}

