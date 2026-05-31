/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Assign.Select;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateScenario_Assign_Select_List
extends Menu {
    private List<Integer> lCivs;

    public Menu_CreateScenario_Assign_Select_List() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.lCivs = new ArrayList<Integer>();
        int j = 0;
        for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.chosenAlphabetCharachter == null) {
                menuElements.add(new Button_Flag(i, 0, CFG.BUTTON_H * i + CFG.PADD * (i + 1), CFG.CIV_FLAG_WIDTH + CFG.PADD * 4, CFG.BUTTON_H, Button_Flag.ButtonFlagType.FLAG_COLOR));
                menuElements.add(new Button_Classic_Classic(CFG.core.getCiv(i).getCivName() + " [" + CFG.core.getCiv(i).getCivTag() + "]", CFG.PADD, CFG.CIV_FLAG_WIDTH + CFG.PADD * 4, CFG.BUTTON_H * i + CFG.PADD * (i + 1), CFG.GAMEWIDTH - CFG.CIV_FLAG_WIDTH - CFG.PADD * 4, CFG.BUTTON_H, true));
                continue;
            }
            if (CFG.core.getCiv(i).getCivName().charAt(0) != CFG.chosenAlphabetCharachter.charAt(0)) continue;
            this.lCivs.add(i);
            menuElements.add(new Button_Flag(i, 0, CFG.BUTTON_H * j + CFG.PADD * (j + 1), CFG.CIV_FLAG_WIDTH + CFG.PADD * 4, CFG.BUTTON_H, Button_Flag.ButtonFlagType.FLAG_COLOR));
            menuElements.add(new Button_Classic_Classic(CFG.core.getCiv(i).getCivName() + " [" + CFG.core.getCiv(i).getCivTag() + "]", CFG.PADD, CFG.CIV_FLAG_WIDTH + CFG.PADD * 4, CFG.BUTTON_H * j + CFG.PADD * (j + 1), CFG.GAMEWIDTH - CFG.CIV_FLAG_WIDTH - CFG.PADD * 4, CFG.BUTTON_H, true));
            ++j;
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4 + CFG.BUTTON_H + CFG.PADD, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.BUTTON_H - CFG.PADD * 2, menuElements, true, false);
        this.updateLang();
    }

    @Override
    public final void actionEL(int iID) {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_ASSIGN);
        if (CFG.chosenAlphabetCharachter == null) {
            if (CFG.createScenarioAssignProvsCiv != iID / 2) {
                CFG.core.disableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv);
                CFG.core.enableDrawCivilizationRegions(iID / 2, 0);
            }
            CFG.createScenarioAssignProvsCiv = iID / 2;
        } else {
            if (CFG.createScenarioAssignProvsCiv != this.lCivs.get(iID / 2)) {
                CFG.core.disableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv);
                CFG.core.enableDrawCivilizationRegions(this.lCivs.get(iID / 2), 0);
            }
            CFG.createScenarioAssignProvsCiv = this.lCivs.get(iID / 2);
        }
    }
}

