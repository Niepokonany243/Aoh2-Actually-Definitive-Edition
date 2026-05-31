/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Minimap;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_SelectCivilization
extends Menu {
    public Menu_SelectCivilization() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Minimap(0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight()));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD - CFG.BUTTON_W - CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.BUTTON_W * 2, true));
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(1).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(2).setTextE(CFG.lang.get("RandomCivilization"));
        this.getTitleM().setText(CFG.lang.get("SelectCivilization"));
        this.updateButtonWidth(2, 0, CFG.BUTTON_W);
        this.getMenuElem(2).setPosX(this.getMenuElem(1).getPosXE() - this.getMenuElem(2).getWidthE() - CFG.PADD);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, CFG.map.getMpB().getMinimapWidth() + iTranslateX, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.BUTTON_H + CFG.PADD * 2);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawTitle(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive, int nPosY) {
        super.drawTitle(oSB, iTranslateX, iTranslateY, sliderMenuIsActive, this.getTitleM().getHeightT());
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.iSelectCivilizationPlayerID).getCivId()).getCapitalProvID());
                break;
            }
            case 1: {
                CFG.menus.setMenuID(View.eNEWGAME_PLAYERS);
                break;
            }
            case 2: {
                if (CFG.core.getPlayer(CFG.iSelectCivilizationPlayerID).getCivId() > 0) {
                    CFG.core.disableDrawCivilizationRegions(CFG.core.getPlayer(CFG.iSelectCivilizationPlayerID).getCivId());
                }
                CFG.core.getPlayer(CFG.iSelectCivilizationPlayerID).setCivId(-1);
                CFG.menus.setMenuID(View.eNEWGAME_PLAYERS);
                CFG.core.setActiveProvID(-1);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eNEWGAME_PLAYERS);
    }
}

