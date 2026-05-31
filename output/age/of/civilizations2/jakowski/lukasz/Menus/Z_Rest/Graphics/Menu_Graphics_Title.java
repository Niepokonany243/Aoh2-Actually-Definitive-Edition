
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Graphics;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Menu_Graphics_Title
extends Menu {
    public Menu_Graphics_Title() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Save"));
        this.getTitleM().setText(CFG.lang.get("Graphics") + "Age of History 2: Definitive Edition");
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
        CFG.menus.setMenuID(View.eSETTINGS);
        CFG.menus.setBackAnimation(true);
        CFG.toastM.addM(CFG.lang.get("GameNeedsToBeRestartedToApplyTheChanges"));
        CFG.toastM.setTimeInView(4500);
    }
}

