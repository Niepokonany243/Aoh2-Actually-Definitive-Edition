/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Events;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Age;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Menu;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;
import java.util.Random;

public class Menu_CreateScenario_Events_Date_List
extends Menu {
    public Menu_CreateScenario_Events_Date_List() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        for (int i = 0; i < CFG.gameAges.getAgesSize(); ++i) {
            menuElements.add(new Button_Classic_Age(CFG.gameAges.getYear(CFG.gameAges.getAge(i).getBeginningYear()) + " - " + CFG.gameAges.getYear(CFG.gameAges.getAge(i).getEndYear()), -1, 0, CFG.BUTTON_H * i + CFG.PADD * (i + 1), CFG.BUTTON_W * 2, CFG.BUTTON_H, GameCalendar.CURRENT_AGEID <= i));
            menuElements.add(new Button_Classic_ReflectedBG(CFG.gameAges.getAge(i).getName(), CFG.PADD * 5, CFG.BUTTON_W * 2, CFG.BUTTON_H * i + CFG.PADD * (i + 1), CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H, GameCalendar.CURRENT_AGEID <= i));
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 2 + CFG.PADD * 5, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - (CFG.BUTTON_H * 2 + CFG.PADD * 5), menuElements);
        this.updateLang();
    }

    @Override
    public boolean getMenuElementIsActive(boolean sliderMenuIsActive, int i) {
        return super.getMenuElementIsActive(sliderMenuIsActive, i) || i % 2 == 0 && i / 2 == CFG.eventsManager.iCreateEvent_Age;
    }

    @Override
    public final void actionEL(int iID) {
        if (CFG.eventsManager.iCreateEvent_Age != iID / 2) {
            CFG.eventsManager.iCreateEvent_Age = iID / 2;
            CFG.eventsManager.iCreateEvent_Year = Math.max(Math.abs(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getBeginningYear()), Math.abs(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getEndYear())) - Math.min(Math.abs(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getBeginningYear()), Math.abs(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getEndYear()));
            Random oR = new Random();
            CFG.eventsManager.iCreateEvent_Year = CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getBeginningYear() + oR.nextInt(CFG.eventsManager.iCreateEvent_Year);
            ArrayList<String> tMess = new ArrayList<String>();
            ArrayList<Color> tColor = new ArrayList<Color>();
            tMess.add(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getName());
            tColor.add(Color.WHITE);
            tMess.add(CFG.gameAges.getYear(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getBeginningYear()) + " - " + CFG.gameAges.getYear(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getEndYear()));
            tColor.add(CFG.COLOR_HOVER_TITLE);
            CFG.toastM.addM(tMess, tColor);
            CFG.menus.updateCreateScanerio_Events_Slider();
        }
    }
}

