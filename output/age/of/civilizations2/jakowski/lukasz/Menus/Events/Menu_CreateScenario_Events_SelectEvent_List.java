
package age.of.civilizations2.jakowski.lukasz.Menus.Events;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_SelectEvent_List
extends Menu {
    public Menu_CreateScenario_Events_SelectEvent_List() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        ArrayList lTempNames = new ArrayList();
        ArrayList lTempTags = new ArrayList();
        int nPosY = 0;
        for (int i = 0; i < CFG.eventsManager.getEventsSize(); ++i) {
            menuElements.add(new Button_Classic(CFG.eventsManager.getEvent(i).getEventName() + (CFG.eventsManager.getEvent(i).getCivID() >= 0 && CFG.eventsManager.getEvent(i).getCivID() < CFG.core.getCivsSize() ? ", " + CFG.core.getCiv(CFG.eventsManager.getEvent(i).getCivID()).getCivName() : "") + " [" + CFG.eventsManager.getEvent(i).getEventTag() + "]", 50, 0, CFG.BUTTON_H * nPosY + CFG.PADD * (nPosY + 1), CFG.GAMEWIDTH, CFG.BUTTON_H, i != CFG.eventsManager.createEvent_EditEventID));
            ++nPosY;
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD, menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public final void actionEL(int iID) {
        CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).setText(CFG.eventsManager.getEvent(iID).getEventTag());
        CFG.eventsManager.selectCivBack();
    }
}

