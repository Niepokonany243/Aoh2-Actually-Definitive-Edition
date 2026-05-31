
package age.of.civilizations2.jakowski.lukasz.Menus.CustomizeAlliance;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Menu_CustomizeAlliance
extends Menu {
    public Menu_CustomizeAlliance() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        this.initMenu(null, 0, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Save"));
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
        CFG.menus.getColorPicker().setVisible(false, null);
        CFG.core.checkAlliances();
        CFG.menus.rebuildManageDiplomacy_Alliances();
        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = 0;
        CFG.menus.setMenuID(View.eMANAGE_DIPLOMACY);
        CFG.menus.setBackAnimation(true);
    }
}

