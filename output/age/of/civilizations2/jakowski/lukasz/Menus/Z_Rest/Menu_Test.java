
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Sliders.LR.Slider_LR;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Menu_Test
extends Menu {
    public Menu_Test() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic("Back", -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Slider_LR(0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, 0, 7777, 4444));
        for (int i = 1; i < 5; ++i) {
            menuElements.add(new Button_Classic("TEST" + i, -1, 0, CFG.BUTTON_H * i + CFG.PADD * (i + 1), CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        }
        this.initMenuWithBackButton(new TitleM("TEST MENU", CFG.BUTTON_H * 3 / 4, true, true), CFG.BUTTON_H, CFG.GAMEHEIGHT / 2, CFG.GAMEWIDTH / 2, CFG.BUTTON_H * 3, menuElements, true);
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 2: {
                CFG.showKeyboard();
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuIDWithoutAnim(View.eMAINMENU);
        CFG.menus.setBackAnimation(true);
    }
}

