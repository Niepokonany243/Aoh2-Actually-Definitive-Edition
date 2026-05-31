/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Out;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_SelectCivAction;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_Out_BuildBuilding
extends Menu {
    public Menu_CreateScenario_Events_Out_BuildBuilding() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Save"));
        try {
            this.getMenuElem(1).setTextE(CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).getCivID() > 0 ? CFG.lang.get("Civilization") + ": " + CFG.core.getCiv(CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).getCivID()).getCivName() : CFG.lang.get("Civilization") + ": " + CFG.lang.get("All"));
        }
        catch (Exception ex) {
            this.getMenuElem(1).setTextE(CFG.lang.get("Civilization"));
        }
        try {
            this.getMenuElem(2).setTextE(CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).getCivID2() >= 0 ? CFG.lang.get("Building") + ": " + Menu_CreateScenario_Events_Out_BuildBuilding.getBName(CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).getCivID2()) : CFG.lang.get("Building") + ": ?");
        }
        catch (Exception ex) {
            this.getMenuElem(2).setTextE(CFG.lang.get("Building"));
        }
        this.getMenuElem(3).setTextE(CFG.lang.get("SelectProvinces") + ": " + CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).getProvinces().size());
        this.getTitleM().setText(CFG.lang.get("ConstructNewBuilding"));
    }

    public static String getBName(int id) {
        String out = "";
        switch (id) {
            case 0: {
                out = out + CFG.lang.get(BuildingsManager.getFort_Name(1));
                break;
            }
            case 1: {
                out = out + CFG.lang.get(BuildingsManager.getTower_Name(1));
                break;
            }
            case 2: {
                out = out + CFG.lang.get(BuildingsManager.getFarm_Name(1));
                break;
            }
            case 3: {
                out = out + CFG.lang.get(BuildingsManager.getWorkshop_Name(1));
                break;
            }
            case 4: {
                out = out + CFG.lang.get(BuildingsManager.getMarket_Name(1));
                break;
            }
            case 5: {
                out = out + CFG.lang.get(BuildingsManager.getLibrary_Name(1));
                break;
            }
            case 6: {
                out = out + CFG.lang.get(BuildingsManager.getArmoury_Name(1));
                break;
            }
            case 7: {
                out = out + CFG.lang.get(BuildingsManager.getSupply_Name(1));
            }
        }
        return out;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        int tempButtonID = 1;
        try {
            CFG.core.getCiv(CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).getCivID()).getFlagC().drawO(oSB, this.getMenuElem(tempButtonID).getPosXE() + this.getMenuElem(tempButtonID).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, -CFG.core.getCiv(CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).getCivID()).getFlagC().getHeight() + this.getMenuElem(tempButtonID).getPosY() + this.getMenuPosY() + this.getMenuElem(tempButtonID).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getMenuElem(tempButtonID).getPosXE() + this.getMenuElem(tempButtonID).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(tempButtonID).getPosY() + this.getMenuPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + this.getMenuElem(tempButtonID).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getMenuElem(tempButtonID).getPosXE() + this.getMenuElem(tempButtonID).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(tempButtonID).getPosY() + this.getMenuPosY() + this.getMenuElem(tempButtonID).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.eventsManager.eSelectCivAction = Event_SelectCivAction.OUT_SELECTCIV_BUILDBUILDINGS;
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_SELECT_CIV);
                break;
            }
            case 2: {
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_BUILDBUILDINGLIST);
                break;
            }
            case 3: {
                CFG.core.getProvSelected().clearSelectedProvinces();
                for (int i = 0; i < CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).getProvinces().size(); ++i) {
                    CFG.core.getProvSelected().addProv(CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).getProvinces().get(i));
                }
                CFG.eventsManager.eSelectCivAction = Event_SelectCivAction.OUT_SELECTPROVINCES_BUILDBUILDINGS;
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_SELECT_PROVINCES);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_DECISION);
        CFG.menus.setBackAnimation(true);
    }
}

