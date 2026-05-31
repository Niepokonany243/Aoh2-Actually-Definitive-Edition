
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextSlider;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import java.util.ArrayList;

public class Menu_Help
extends Menu {
    public Menu_Help() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2 - CFG.PADD - CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new TextSlider(CFG.PADD, CFG.PADD, CFG.GAMEWIDTH - CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2 - CFG.PADD * 4 - CFG.BUTTON_H * 3 / 4));
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
        this.getMenuElem(2).addText(CFG.lang.get("WelcomeToTheTutorial"), CFG.PADD);
        this.getMenuElem(2).addText(CFG.lang.get("t0"), CFG.PADD / 2);
        this.getMenuElem(2).addText(CFG.lang.get("t1"), CFG.PADD / 2);
        this.getMenuElem(2).addText(CFG.lang.get("t2"), CFG.TEXT_HEIGHT_DEFAULT / 2 + CFG.PADD);
        this.getMenuElem(2).addText(CFG.lang.get("t7"), CFG.PADD / 2);
        this.getMenuElem(2).addText(CFG.lang.get("t8"), CFG.TEXT_HEIGHT_DEFAULT / 2 + CFG.PADD);
        this.getMenuElem(2).addText(CFG.lang.get("t4"), CFG.PADD / 2);
        this.getMenuElem(2).addText(CFG.lang.get("t5"), CFG.PADD / 2);
        this.getMenuElem(2).addText(CFG.lang.get("t6"), CFG.PADD / 2);
        this.getMenuElem(2).addText(CFG.lang.get("t6a"), CFG.TEXT_HEIGHT_DEFAULT / 2 + CFG.PADD);
        this.getMenuElem(2).addText(CFG.lang.get("h5"), CFG.TEXT_HEIGHT_DEFAULT / 2 + CFG.PADD);
        this.getMenuElem(2).addText(CFG.lang.get("h6"), CFG.TEXT_HEIGHT_DEFAULT / 2 + CFG.PADD);
        this.getMenuElem(2).addText(CFG.lang.get("h7"), CFG.TEXT_HEIGHT_DEFAULT / 2 + CFG.PADD);
        this.getMenuElem(2).addText(CFG.lang.get("h8"), CFG.TEXT_HEIGHT_DEFAULT / 2 + CFG.PADD);
        this.getMenuElem(2).addText(CFG.lang.get("h9"), CFG.TEXT_HEIGHT_DEFAULT / 2 + CFG.PADD);
        this.getMenuElem(2).addText(CFG.lang.get("h10"), CFG.TEXT_HEIGHT_DEFAULT / 2 + CFG.PADD);
        this.getMenuElem(2).addText(CFG.lang.get("h11"), 0);
        this.getMenuElem(2).addText(CFG.lang.get("h12"), 0);
        this.getMenuElem(2).addText(CFG.lang.get("h13"), 0);
        this.getMenuElem(2).addText(CFG.lang.get("h14"), 0);
        this.getMenuElem(2).addText(CFG.lang.get("h15"), 0);
        this.getMenuElem(2).addText(CFG.lang.get("h16"), 0);
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Tutorial"));
        this.getTitleM().setText(CFG.lang.get("Help"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.setDialogType(DialogType.START_TUTORIAL);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuIDWithoutAnim(View.eMAINMENU);
        CFG.menus.setBackAnimation(true);
    }
}

