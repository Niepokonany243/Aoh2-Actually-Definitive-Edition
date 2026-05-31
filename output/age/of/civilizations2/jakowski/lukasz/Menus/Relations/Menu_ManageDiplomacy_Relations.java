
package age.of.civilizations2.jakowski.lukasz.Menus.Relations;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Diplomacy.Slider_Relations;
import java.util.ArrayList;
import java.util.List;

public class Menu_ManageDiplomacy_Relations
extends Menu {
    public List<Integer> lCivIDs;

    public Menu_ManageDiplomacy_Relations() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.lCivIDs = new ArrayList<Integer>();
        int j = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (i == CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID || CFG.chosenAlphabetCharachter != null && CFG.chosenAlphabetCharachter.charAt(0) != CFG.core.getCiv(i).getCivName().charAt(0)) continue;
            menuElements.add(new Button_Flag(i, 0, CFG.PADD * (j + 1) + CFG.BUTTON_H * j, CFG.CIV_FLAG_WIDTH + (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE) + CFG.PADD * 4, CFG.BUTTON_H, Button_Flag.ButtonFlagType.FLAG_COLOR));
            menuElements.add(new Button_Classic_Classic("-", -1, CFG.CIV_FLAG_WIDTH + (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE) + CFG.PADD * 4, CFG.PADD * (j + 1) + CFG.BUTTON_H * j, CFG.BUTTON_W * 3 / 4, CFG.BUTTON_H, true));
            menuElements.add(new Slider_Relations(CFG.BUTTON_W * 3 / 4 + CFG.CIV_FLAG_WIDTH + (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE) + CFG.PADD * 4, CFG.PADD * (j + 1) + CFG.BUTTON_H * j + CFG.PADD, CFG.GAMEWIDTH - CFG.BUTTON_W * 3 / 4 * 2 - (CFG.CIV_FLAG_WIDTH + (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE) + CFG.PADD * 4), CFG.BUTTON_H - CFG.PADD * 2, -100, 100, (int)CFG.core.getCivRelationOfCivB(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID, i)));
            menuElements.add(new Button_Classic_Classic("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 3 / 4, CFG.PADD * (j + 1) + CFG.BUTTON_H * j, CFG.BUTTON_W * 3 / 4, CFG.BUTTON_H, true));
            this.lCivIDs.add(i);
            ++j;
        }
        this.initMenu(null, 0, CFG.BUTTON_H + CFG.BUTTON_H * 3 / 4 + CFG.PADD, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H * 2 - CFG.PADD * 3, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public final void actionEL(int iID) {
        if (iID % 4 == 0) {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = this.lCivIDs.get(iID / 4);
        } else if (iID % 4 == 1) {
            this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
            CFG.core.setCivRelationOfCivB(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID, this.lCivIDs.get(iID / 4), this.getMenuElem(iID + 1).getCurr());
        } else if (iID % 4 == 2) {
            CFG.core.setCivRelationOfCivB(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID, this.lCivIDs.get(iID / 4), this.getMenuElem(iID).getCurr());
        } else if (iID % 4 == 3) {
            CFG.core.setCivRelationOfCivB(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID, this.lCivIDs.get(iID / 4), this.getMenuElem(iID - 1).getCurr());
            this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
        }
    }
}

