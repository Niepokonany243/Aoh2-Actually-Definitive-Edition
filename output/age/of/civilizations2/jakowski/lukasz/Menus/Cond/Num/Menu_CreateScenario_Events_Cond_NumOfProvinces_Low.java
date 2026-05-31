/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Cond.Num;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_SelectCivAction;
import age.of.civilizations2.jakowski.lukasz.Event_Type;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Sliders.ZRest.Slider_BG;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_Cond_NumOfProvinces_Low
extends Menu {
    public Menu_CreateScenario_Events_Cond_NumOfProvinces_Low() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, tY, CFG.GAMEWIDTH / 3, CFG.BUTTON_H, true){

            @Override
            public Color getColorE(boolean isActive) {
                return CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get((int)CFG.eventsManager.createEvent_EditConditionID).conditionType == Event_Type.AND ? CFG.COLOR_POSITIVE : super.getColorE(isActive);
            }
        });
        menuElements.add(new Button_Classic_LR_Line(null, -1, CFG.GAMEWIDTH / 3, tY, CFG.GAMEWIDTH / 3, CFG.BUTTON_H, true){

            @Override
            public Color getColorE(boolean isActive) {
                return CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get((int)CFG.eventsManager.createEvent_EditConditionID).conditionType == Event_Type.NOT ? CFG.COLOR_POSITIVE : super.getColorE(isActive);
            }
        });
        menuElements.add(new Button_Classic_LR_Line(null, -1, CFG.GAMEWIDTH - CFG.GAMEWIDTH / 3, tY, CFG.GAMEWIDTH - CFG.GAMEWIDTH / 3 * 2, CFG.BUTTON_H, true){

            @Override
            public Color getColorE(boolean isActive) {
                return CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get((int)CFG.eventsManager.createEvent_EditConditionID).conditionType == Event_Type.OR ? CFG.COLOR_POSITIVE : super.getColorE(isActive);
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
        int tNum = 0;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv()) continue;
            ++tNum;
        }
        menuElements.add(new Slider_BG(0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H - CFG.PADD * 2, 0, tNum, CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).getValue()){

            @Override
            public String getDrawText() {
                return this.getTextE() + this.getCurr();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(1).setTextE(CFG.lang.get("AND"));
        this.getMenuElem(2).setTextE(CFG.lang.get("NOT"));
        this.getMenuElem(3).setTextE(CFG.lang.get("OR"));
        try {
            this.getMenuElem(4).setTextE(CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).getCivID() > 0 ? CFG.lang.get("Civilization") + ": " + CFG.core.getCiv(CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).getCivID()).getCivName() : CFG.lang.get("SelectCivilization"));
        }
        catch (IndexOutOfBoundsException ex) {
            this.getMenuElem(4).setTextE(CFG.lang.get("SelectCivilization"));
        }
        this.getMenuElem(5).setTextE(CFG.lang.get("NumberOfProvinces") + " < ");
        this.getTitleM().setText(CFG.lang.get("NumberOfProvinces"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        int tempButtonID = 4;
        try {
            CFG.core.getCiv(CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).getCivID()).getFlagC().drawO(oSB, this.getMenuElem(tempButtonID).getPosXE() + this.getMenuElem(tempButtonID).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, -CFG.core.getCiv(CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).getCivID()).getFlagC().getHeight() + this.getMenuElem(tempButtonID).getPosY() + this.getMenuPosY() + this.getMenuElem(tempButtonID).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getMenuElem(tempButtonID).getPosXE() + this.getMenuElem(tempButtonID).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(tempButtonID).getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + this.getMenuPosY() + this.getMenuElem(tempButtonID).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
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
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get((int)CFG.eventsManager.createEvent_EditConditionID).conditionType = Event_Type.AND;
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_HOVER_TITLE);
                break;
            }
            case 2: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get((int)CFG.eventsManager.createEvent_EditConditionID).conditionType = Event_Type.NOT;
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_HOVER_TITLE);
                break;
            }
            case 3: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get((int)CFG.eventsManager.createEvent_EditConditionID).conditionType = Event_Type.OR;
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_HOVER_TITLE);
                break;
            }
            case 4: {
                CFG.eventsManager.eSelectCivAction = Event_SelectCivAction.SELECT_CIV_NUMOFPROVINCES;
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_SELECT_CIV);
                break;
            }
            case 5: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).setValue(this.getMenuElem(iID).getCurr());
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_TRIGGER);
        CFG.menus.setBackAnimation(true);
    }
}

