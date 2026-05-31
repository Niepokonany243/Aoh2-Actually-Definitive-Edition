
package age.of.civilizations2.jakowski.lukasz.Menus.Out;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Sliders.ZRest.Slider_BG;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_Out_GlobalDevPerc
extends Menu {
    public Menu_CreateScenario_Events_Out_GlobalDevPerc() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Slider_BG(0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H - CFG.PADD * 2, -1000, 5000, CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).getValue()){

            @Override
            public String getDrawText() {
                return this.getTextE() + (this.getCurr() > 0 ? "+" : "") + (float)this.getCurr() / 10.0f + "%";
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Percentage") + ": ");
        this.getTitleM().setText(CFG.lang.get("GlobalEvent") + ": " + CFG.lang.get("Development") + " - " + CFG.lang.get("AllCivilizations"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).setValue(this.getMenuElem(iID).getCurr());
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_DECISION);
        CFG.menus.setBackAnimation(true);
    }
}

