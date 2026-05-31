/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Games2
extends Menu {
    public Menu_Games2() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempH = CFG.GAMEHEIGHT / 2 - (CFG.BUTTON_H * 10 + CFG.PADD * 11) / 2;
        menuElements.add(new Button_Classic_LR_Main(null, (int)(50.0f * CFG.GUI_SCALE), CFG.GAMEWIDTH / 10, tempH, CFG.GAMEWIDTH - CFG.GAMEWIDTH / 5, CFG.BUTTON_H, false));
        menuElements.add(new Button_Classic_LR_Main(null, (int)(50.0f * CFG.GUI_SCALE), CFG.GAMEWIDTH / 10, tempH + CFG.BUTTON_H + CFG.PADD, CFG.GAMEWIDTH - CFG.GAMEWIDTH / 5, CFG.BUTTON_H, false));
        menuElements.add(new Button_Classic_LR_Main(null, (int)(50.0f * CFG.GUI_SCALE), CFG.GAMEWIDTH / 10, tempH + CFG.BUTTON_H * 2 + CFG.PADD * 2, CFG.GAMEWIDTH - CFG.GAMEWIDTH / 5, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Main(null, (int)(50.0f * CFG.GUI_SCALE), CFG.GAMEWIDTH / 10, tempH + CFG.BUTTON_H * 3 + CFG.PADD * 3, CFG.GAMEWIDTH - CFG.GAMEWIDTH / 5, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Main(null, (int)(50.0f * CFG.GUI_SCALE), CFG.GAMEWIDTH / 10, tempH + CFG.BUTTON_H * 4 + CFG.PADD * 4, CFG.GAMEWIDTH - CFG.GAMEWIDTH / 5, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Main(null, (int)(50.0f * CFG.GUI_SCALE), CFG.GAMEWIDTH / 10, tempH + CFG.BUTTON_H * 5 + CFG.PADD * 5, CFG.GAMEWIDTH - CFG.GAMEWIDTH / 5, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Main(null, (int)(50.0f * CFG.GUI_SCALE), CFG.GAMEWIDTH / 10, tempH + CFG.BUTTON_H * 6 + CFG.PADD * 6, CFG.GAMEWIDTH - CFG.GAMEWIDTH / 5, CFG.BUTTON_H, false));
        menuElements.add(new Button_Classic_LR_Main(null, (int)(50.0f * CFG.GUI_SCALE), CFG.GAMEWIDTH / 10, tempH + CFG.BUTTON_H * 7 + CFG.PADD * 7, CFG.GAMEWIDTH - CFG.GAMEWIDTH / 5, CFG.BUTTON_H, false));
        menuElements.add(new Button_Classic_LR_Main(null, (int)(50.0f * CFG.GUI_SCALE), CFG.GAMEWIDTH / 10, tempH + CFG.BUTTON_H * 8 + CFG.PADD * 8, CFG.GAMEWIDTH - CFG.GAMEWIDTH / 5, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Main(null, -1, CFG.GAMEWIDTH / 10, tempH + CFG.BUTTON_H * 9 + CFG.PADD * 9, CFG.GAMEWIDTH - CFG.GAMEWIDTH / 5, CFG.BUTTON_H, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public final void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("LoadGame"));
        this.getMenuElem(1).setTextE(CFG.lang.get("ContinueGame"));
        this.getMenuElem(2).setTextE(CFG.lang.get("NewGame"));
        this.getMenuElem(3).setTextE(CFG.lang.get("RandomGame"));
        this.getMenuElem(4).setTextE(CFG.lang.get("Tutorial"));
        this.getMenuElem(5).setTextE(CFG.lang.get("Achievements"));
        this.getMenuElem(6).setTextE(CFG.lang.get("HallofFame"));
        this.getMenuElem(7).setTextE(CFG.lang.get("Leaderboards"));
        this.getMenuElem(8).setTextE(CFG.lang.get("Statistics"));
        this.getMenuElem(9).setTextE(CFG.lang.get("Back"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.mainMenuEdge).draw2O(oSB, this.getPosX() - 2 + this.getMenuElem(0).getPosXE() + iTranslateX, this.getMenuPosY() - IMGManager.getIMG(Images.mainMenuEdge).getHeight() * 2 - CFG.PADD + this.getMenuElem(0).getPosY() + iTranslateY, this.getMenuElem(0).getWidthE() + 4 - IMGManager.getIMG(Images.mainMenuEdge).getWidth(), this.getMenuElem(this.getMenuElemsSize() - 1).getPosY() + this.getMenuElem(this.getMenuElemsSize() - 1).getHeightE() - this.getMenuElem(0).getPosY() + (IMGManager.getIMG(Images.mainMenuEdge).getHeight() + CFG.PADD) * 2 - IMGManager.getIMG(Images.mainMenuEdge).getHeight());
        IMGManager.getIMG(Images.mainMenuEdge).draw2O(oSB, this.getPosX() + this.getMenuElem(0).getWidthE() + 4 - IMGManager.getIMG(Images.mainMenuEdge).getWidth() - 2 + this.getMenuElem(0).getPosXE() + iTranslateX, this.getMenuPosY() - IMGManager.getIMG(Images.mainMenuEdge).getHeight() * 2 - CFG.PADD + this.getMenuElem(0).getPosY() + iTranslateY, IMGManager.getIMG(Images.mainMenuEdge).getWidth(), this.getMenuElem(this.getMenuElemsSize() - 1).getPosY() + this.getMenuElem(this.getMenuElemsSize() - 1).getHeightE() - this.getMenuElem(0).getPosY() + (IMGManager.getIMG(Images.mainMenuEdge).getHeight() + CFG.PADD) * 2 - IMGManager.getIMG(Images.mainMenuEdge).getHeight(), true, false);
        IMGManager.getIMG(Images.mainMenuEdge).draw2O(oSB, this.getPosX() - 2 + this.getMenuElem(0).getPosXE() + iTranslateX, this.getMenuPosY() + this.getMenuElem(this.getMenuElemsSize() - 1).getPosY() + this.getMenuElem(this.getMenuElemsSize() - 1).getHeightE() - this.getMenuElem(0).getPosY() + (IMGManager.getIMG(Images.mainMenuEdge).getHeight() + CFG.PADD) * 2 - IMGManager.getIMG(Images.mainMenuEdge).getHeight() - IMGManager.getIMG(Images.mainMenuEdge).getHeight() * 2 - CFG.PADD + this.getMenuElem(0).getPosY() + iTranslateY, this.getMenuElem(0).getWidthE() + 4 - IMGManager.getIMG(Images.mainMenuEdge).getWidth(), IMGManager.getIMG(Images.mainMenuEdge).getHeight(), false, true);
        IMGManager.getIMG(Images.mainMenuEdge).draw2O(oSB, this.getPosX() + this.getMenuElem(0).getWidthE() + 4 - IMGManager.getIMG(Images.mainMenuEdge).getWidth() - 2 + this.getMenuElem(0).getPosXE() + iTranslateX, this.getMenuPosY() + this.getMenuElem(this.getMenuElemsSize() - 1).getPosY() + this.getMenuElem(this.getMenuElemsSize() - 1).getHeightE() - this.getMenuElem(0).getPosY() + (IMGManager.getIMG(Images.mainMenuEdge).getHeight() + CFG.PADD) * 2 - IMGManager.getIMG(Images.mainMenuEdge).getHeight() - IMGManager.getIMG(Images.mainMenuEdge).getHeight() * 2 - CFG.PADD + this.getMenuElem(0).getPosY() + iTranslateY, IMGManager.getIMG(Images.mainMenuEdge).getWidth(), IMGManager.getIMG(Images.mainMenuEdge).getHeight(), true, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 9: {
                this.onBackPressed();
                break;
            }
            case 2: {
                CFG.menus.setMenuID(View.eCREATE_NEW_GAME);
                CFG.menus.setVisible_CreateNewGame_Options(false);
                CFG.menus.setVisible_CreateNewGame_CivInfo(true);
                CFG.menus.setVisible_CreateNewGame_AddCiv(false);
                CFG.menus.setVisible_CreateNewGame_AddCiv_Gov(false);
                break;
            }
            case 3: {
                CFG.showKeyboard();
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuIDWithoutAnim(View.eMAINMENU);
        CFG.menus.setBackAnimation(true);
    }
}

