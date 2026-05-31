/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.Minimap;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_SelectAvailableCivilizations
extends Menu {
    private String selectAvailableCivilizations;
    private int iTitleWidth;

    public Menu_SelectAvailableCivilizations() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD, CFG.PADD, CFG.BUTTON_W * 2, true));
        menuElements.add(new Minimap(CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight()));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.BUTTON_W * 2, false, false));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        super.updateLang();
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Disable"));
        this.selectAvailableCivilizations = CFG.lang.get("SelectAvailableCivilizations");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.selectAvailableCivilizations + " [XX]");
        this.iTitleWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_Edge_LR(oSB, iTranslateX, this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawTextDefaultWithShadow(oSB, this.selectAvailableCivilizations + " [" + CFG.core.getAvailableCivilizations() + "]", CFG.GAMEWIDTH / 2 - this.iTitleWidth / 2 + iTranslateX, CFG.BUTTON_H / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + CFG.PADD + this.getMenuPosY() + iTranslateY, Color.WHITE);
        if (this.getMenuElem(3).getVisibleE()) {
            CFG.drawEditorButtons_Bot_Edge_R(oSB, iTranslateX, this.getMenuElem(3).getPosY() - CFG.PADD, this.getMenuElem(3).getPosXE() + this.getMenuElem(3).getWidthE() + CFG.PADD, CFG.BUTTON_H + CFG.PADD * 2);
        }
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                if (CFG.core.getActiveProvID() >= 0) {
                    CFG.core.disableDrawCivilizationRegions(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                }
                CFG.core.setActiveProvID(-1);
                CFG.core.disableNonPlayableCivilizations();
                CFG.core.checkPlayersCivilizations();
                CFG.menus.setMenuID(View.eCREATE_NEW_GAME);
                CFG.menus.setVisible_CreateNewGame_AddCiv(false);
                CFG.menus.setVisible_CreateNewGame_AddCiv_Gov(false);
                return;
            }
            case 2: {
                CFG.map.getMpC().centerToMinimapClick(Touch.getMousePosX() - this.getMenuElem(iID).getPosXE() - this.getPosX(), Touch.getMousePosY() - this.getMenuElem(iID).getPosY() - this.getMenuPosY());
                break;
            }
            case 3: {
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                    CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setIsAvailable(!CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getIsAvailable());
                    CFG.core.updateNumOfAvailableCivilizations();
                    this.getMenuElem(iID).setCheckboxSt(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getIsAvailable());
                    if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getIsAvailable()) {
                        this.getMenuElem(iID).setTextE(CFG.lang.get("Disable") + " - " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                        CFG.core.enableDrawCivilizationRegions(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), 0);
                    } else {
                        this.getMenuElem(iID).setTextE(CFG.lang.get("Enable") + " - " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                        CFG.core.disableDrawCivilizationRegions(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                        CFG.core.setActiveProvID(CFG.core.getActiveProvID());
                    }
                    this.updateButtonWidth(iID, CFG.PADD, CFG.BUTTON_W * 2);
                }
                return;
            }
        }
        super.actionEL(iID);
    }

    @Override
    public void onBackPressed() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.core.getCiv(i).setIsAvailable(true);
        }
        if (CFG.core.getActiveProvID() >= 0) {
            CFG.core.disableDrawCivilizationRegions(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
        }
        CFG.core.setActiveProvID(-1);
        CFG.menus.setMenuID(View.eCHOOSE_SCENARIO);
    }
}

