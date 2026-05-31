/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Difficulty;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Menu_NewGame_Difficulty
extends Menu {
    public Menu_NewGame_Difficulty() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 2 + CFG.PADD * 3, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 3 + CFG.PADD * 4, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Easy"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Normal"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Hard"));
        this.getMenuElem(4).setTextE(CFG.lang.get("Extreme"));
        this.getTitleM().setText(CFG.lang.get("SelectDifficultyLevel"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.DIFFICULTY = iID - 1;
                this.onBackPressed();
                break;
            }
            case 2: {
                CFG.DIFFICULTY = iID - 1;
                this.onBackPressed();
                break;
            }
            case 3: {
                CFG.DIFFICULTY = iID - 1;
                this.onBackPressed();
                break;
            }
            case 4: {
                CFG.DIFFICULTY = iID - 1;
                this.onBackPressed();
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eCREATE_NEW_GAME);
        CFG.menus.setBackAnimation(true);
        CFG.menus.setVisible_CreateNewGame_AddCiv(false);
        CFG.menus.setVisible_CreateNewGame_AddCiv_Gov(false);
    }
}

