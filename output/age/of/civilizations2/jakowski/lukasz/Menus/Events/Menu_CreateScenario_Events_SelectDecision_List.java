
package age.of.civilizations2.jakowski.lukasz.Menus.Events;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Description;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Menu;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_SelectDecision_List
extends Menu {
    public Menu_CreateScenario_Events_SelectDecision_List() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        ArrayList lTempNames = new ArrayList();
        ArrayList lTempTags = new ArrayList();
        int nPosY = 0;
        for (int i = 0; i < CFG.eventsManager.getEventsSize(); ++i) {
            for (int j = 0; j < CFG.eventsManager.getEvent((int)i).lDecisions.size(); ++j) {
                CFG.eventsManager.iCreateEvent_Day = CFG.eventsManager.getEvent((int)i).getEventDate_Since().iEventDay;
                CFG.eventsManager.iCreateEvent_Month = CFG.eventsManager.getEvent((int)i).getEventDate_Since().iEventMonth;
                CFG.eventsManager.iCreateEvent_Year = CFG.eventsManager.getEvent((int)i).getEventDate_Since().iEventYear;
                menuElements.add(new Button_Classic_Description(CFG.eventsManager.iCreateEvent_Year == 9999999 ? CFG.lang.get("NoDate") : GameCalendar.getCurrDate_CreateEvent(), CFG.eventsManager.getEvent((int)i).lDecisions.get((int)j).sTitle + " - [" + CFG.eventsManager.getEvent(i).getEventName() + ", " + (CFG.eventsManager.getEvent(i).getCivID() >= 0 && CFG.eventsManager.getEvent(i).getCivID() < CFG.core.getCivsSize() ? CFG.core.getCiv(CFG.eventsManager.getEvent(i).getCivID()).getCivName() : CFG.lang.get("AnyCivilization")) + "]", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * nPosY + CFG.PADD * (nPosY + 1), CFG.GAMEWIDTH, CFG.BUTTON_H, i != CFG.eventsManager.createEvent_EditEventID));
                ++nPosY;
            }
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD, menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public final void actionEL(int iID) {
        int tNum = 0;
        for (int i = 0; i < CFG.eventsManager.getEventsSize(); ++i) {
            for (int j = 0; j < CFG.eventsManager.getEvent((int)i).lDecisions.size(); ++j) {
                if (tNum++ != iID) continue;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).setText(CFG.eventsManager.getEvent(i).getEventTag() + "_" + j);
                CFG.eventsManager.selectCivBack();
                return;
            }
        }
        CFG.eventsManager.selectCivBack();
    }
}

