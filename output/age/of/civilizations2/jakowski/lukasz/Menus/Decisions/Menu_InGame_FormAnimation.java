/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Decisions;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Menu_InGame_FormAnimation
extends Menu {
    public Menu_InGame_FormAnimation() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, true));
        this.initMenuWithBackButton(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuIDWithoutAnim(View.eINGAME);
        CFG.menus.setVisible_InGame_CivInfo(false);
        CFG.map.getMpB().updateWorldMap_Shaders();
        CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
    }
}

