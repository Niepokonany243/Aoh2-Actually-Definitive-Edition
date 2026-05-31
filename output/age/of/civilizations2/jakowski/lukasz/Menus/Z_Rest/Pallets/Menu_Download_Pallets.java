
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Pallets;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import java.util.ArrayList;

public class Menu_Download_Pallets
extends Menu {
    public Menu_Download_Pallets() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, -1, 0, CFG.PADD, CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.PADD, CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W * 2, CFG.PADD, (CFG.GAMEWIDTH - CFG.BUTTON_W * 4) / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W * 2 + (CFG.GAMEWIDTH - CFG.BUTTON_W * 4) / 2, CFG.PADD, (CFG.GAMEWIDTH - CFG.BUTTON_W * 4) / 2, CFG.BUTTON_H, true));
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE("<<");
        this.getMenuElem(2).setTextE(">>");
        this.getMenuElem(3).setTextE("ByRep");
        this.getMenuElem(4).setTextE("ByNum");
        this.getTitleM().setText(CFG.lang.get("Download") + " - " + CFG.lang.get("PalletsOfColors"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(CFG.backToMenu);
        CFG.menus.setBackAnimation(true);
    }
}

