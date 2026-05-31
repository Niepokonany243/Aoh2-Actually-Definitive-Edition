
package age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.Minimap;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import java.util.ArrayList;

public class Menu_CreateScenario
extends Menu {
    public Menu_CreateScenario() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true));
        menuElements.add(new Minimap(CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight()));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Next"));
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.setDialogType(DialogType.EXIT_CREATOR);
    }
}

