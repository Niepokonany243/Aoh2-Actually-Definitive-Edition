
package age.of.civilizations2.jakowski.lukasz.Menus.Cond;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Type;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Sliders.ZRest.Slider_BG;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_Cond_EventChance
extends Menu {
    public Menu_CreateScenario_Events_Cond_EventChance() {
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
        menuElements.add(new Slider_BG(0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H - CFG.PADD * 2, 0, 100, CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).getValue()){

            @Override
            public String getDrawText() {
                return this.getTextE() + ": " + this.getCurr() + "%";
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
        this.getMenuElem(4).setTextE(CFG.lang.get("EventChance"));
        this.getTitleM().setText(CFG.lang.get("EventChance"));
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

