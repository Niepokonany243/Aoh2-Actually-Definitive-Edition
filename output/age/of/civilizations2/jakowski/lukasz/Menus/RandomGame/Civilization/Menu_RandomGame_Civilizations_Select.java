/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.RandomGame.Civilization;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Menu_RandomGame_Civilizations_Select
extends Menu {
    public Menu_RandomGame_Civilizations_Select() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements, true, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getTitleM().setText(CFG.lang.get("SelectCivilization") + " - " + CFG.lang.get("RandomGames"));
    }

    @Override
    public final void actionEL(int iID) {
        this.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eCREATE_RANDOM_GAME);
        CFG.menus.clearRandomGame_SelectCivilizations();
    }

    @Override
    public void actionCloseMenu() {
        this.onBackPressed();
    }
}

