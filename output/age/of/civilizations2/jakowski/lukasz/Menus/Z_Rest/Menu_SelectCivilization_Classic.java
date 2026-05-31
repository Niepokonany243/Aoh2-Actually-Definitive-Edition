/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_SelectCivilization_Classic
extends Menu {
    public Menu_SelectCivilization_Classic() {
        this.initMenu();
    }

    private final void initMenu() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            menuElements.add(new Button_Classic(CFG.core.getCiv(i).getCivName(), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * i + CFG.PADD * (i + 1), CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        }
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("RandomCivilization"));
        this.getTitleM().setText(CFG.lang.get("SelectCivilization"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.core.getCiv(i).getFlagC().drawO(oSB, this.getMenuElem(i + 1).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(i + 1).getPosY() + this.getMenuElem(i + 1).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + this.getMenuPosY() + iTranslateY);
        }
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            default: {
                CFG.menus.setMenuID(View.eNEWGAME_PLAYERS);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eNEWGAME_PLAYERS);
        CFG.menus.setBackAnimation(true);
    }
}

