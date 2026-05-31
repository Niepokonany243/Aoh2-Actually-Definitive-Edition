/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Pallets;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import java.util.ArrayList;

public class Menu_Download_Pallets_List
extends Menu {
    public Menu_Download_Pallets_List() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4 + CFG.BUTTON_H, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - (CFG.BUTTON_H * 3 / 4 + CFG.BUTTON_H * 2), menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public final void actionEL(int iID) {
    }
}

