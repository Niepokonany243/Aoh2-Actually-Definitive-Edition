/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Cond;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_SelectCivAction;
import age.of.civilizations2.jakowski.lukasz.Event_Type;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_Cond_Farm
extends Menu {
    public Menu_CreateScenario_Events_Cond_Farm() {
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
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true, CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).getValue() == 0){

            @Override
            public boolean getCheckboxSt() {
                return CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).getValue() == 0;
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
        this.getMenuElem(4).setTextE(CFG.lang.get("SelectProvinces") + ": " + CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).getProvinces().size());
        this.getMenuElem(5).setTextE(CFG.lang.get("Built"));
        this.getTitleM().setText(CFG.lang.get("Farm"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
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
                CFG.core.getProvSelected().clearSelectedProvinces();
                for (int i = 0; i < CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).getProvinces().size(); ++i) {
                    CFG.core.getProvSelected().addProv(CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).getProvinces().get(i));
                }
                CFG.eventsManager.eSelectCivAction = Event_SelectCivAction.SELECT_PROVINCES_FARM;
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_SELECT_PROVINCES);
                break;
            }
            case 5: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).setValue(CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).getValue() == 0 ? 1 : 0);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_TRIGGER);
        CFG.menus.setBackAnimation(true);
    }
}

