
package age.of.civilizations2.jakowski.lukasz.Menus.Editors;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Menu_Editor_Translations
extends Menu {
    public Menu_Editor_Translations() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("CreateTranslation"));
        this.getTitleM().setText(CFG.lang.get("TranslationEditor"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.menus.setMenuID(View.eCREATE_TRANSLATION);
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eGAME_EDITOR);
        CFG.menus.setBackAnimation(true);
    }
}

