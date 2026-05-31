/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.AgeOf;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Age;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Menu;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;
import java.util.Random;

public class Menu_Scenario_Age_List
extends Menu {
    public Menu_Scenario_Age_List() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        for (int i = 0; i < CFG.gameAges.getAgesSize(); ++i) {
            menuElements.add(new Button_Classic_Age(CFG.gameAges.getYear(CFG.gameAges.getAge(i).getBeginningYear()) + " - " + CFG.gameAges.getYear(CFG.gameAges.getAge(i).getEndYear()), -1, 0, CFG.BUTTON_H * i + CFG.PADD * (i + 1), CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
            menuElements.add(new Button_Classic_ReflectedBG(CFG.gameAges.getAge(i).getName(), CFG.PADD * 5, CFG.BUTTON_W * 2, CFG.BUTTON_H * i + CFG.PADD * (i + 1), CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 2 + CFG.PADD * 5, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - (CFG.BUTTON_H * 2 + CFG.PADD * 5), menuElements);
        this.updateLang();
    }

    @Override
    public boolean getMenuElementIsActive(boolean sliderMenuIsActive, int i) {
        return super.getMenuElementIsActive(sliderMenuIsActive, i) || i % 2 == 0 && i / 2 == CFG.CREATE_SCENARIO_AGE;
    }

    @Override
    public final void actionEL(int iID) {
        if (CFG.CREATE_SCENARIO_AGE != iID / 2) {
            CFG.CREATE_SCENARIO_AGE = iID / 2;
            GameCalendar.currYear = Math.max(Math.abs(CFG.gameAges.getAge(CFG.CREATE_SCENARIO_AGE).getBeginningYear()), Math.abs(CFG.gameAges.getAge(CFG.CREATE_SCENARIO_AGE).getEndYear())) - Math.min(Math.abs(CFG.gameAges.getAge(CFG.CREATE_SCENARIO_AGE).getBeginningYear()), Math.abs(CFG.gameAges.getAge(CFG.CREATE_SCENARIO_AGE).getEndYear()));
            Random oR = new Random();
            GameCalendar.currYear = CFG.gameAges.getAge(CFG.CREATE_SCENARIO_AGE).getBeginningYear() + oR.nextInt(GameCalendar.currYear);
            ArrayList<String> tMess = new ArrayList<String>();
            ArrayList<Color> tColor = new ArrayList<Color>();
            tMess.add(CFG.gameAges.getAge(CFG.CREATE_SCENARIO_AGE).getName());
            tColor.add(Color.WHITE);
            tMess.add(CFG.gameAges.getYear(CFG.gameAges.getAge(CFG.CREATE_SCENARIO_AGE).getBeginningYear()) + " - " + CFG.gameAges.getYear(CFG.gameAges.getAge(CFG.CREATE_SCENARIO_AGE).getEndYear()));
            tColor.add(CFG.COLOR_HOVER_TITLE);
            CFG.toastM.addM(tMess, tColor);
            CFG.menus.updateSelecetScenarioAge_Slider();
        }
    }
}

