
package age.of.civilizations2.jakowski.lukasz.Menus.Events;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_SelectReligion
extends Menu {
    public Menu_CreateScenario_Events_SelectReligion() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        for (int i = 0; i < CFG.religionManager.getReligionsSize(); ++i) {
            menuElements.add(new Button_Classic(CFG.religionManager.getReligion(i).getName(), (int)(50.0f * CFG.GUI_SCALE), 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getTitleM().setText(CFG.lang.get("Religion"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
        }
        CFG.eventsManager.selectCivAction(iID - 1);
        this.onBackPressed();
    }

    @Override
    public final void onBackPressed() {
        CFG.eventsManager.selectCivBack();
        CFG.menus.setBackAnimation(true);
    }
}

