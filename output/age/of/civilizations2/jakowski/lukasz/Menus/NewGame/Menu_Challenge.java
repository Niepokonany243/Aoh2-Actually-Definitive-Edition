/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.NewGame;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBigCh;
import age.of.civilizations2.jakowski.lukasz.Button2.TextChal;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Challenge.ChallengesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.CivInfo.Menu_Civilization_Info;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Menu_CreateNewGame;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Challenge
extends Menu {
    public Menu_Challenge(int ae) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int textTopH = (int)Math.max((float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4), (float)CFG.BUTTON_H * 0.5f);
        int menuX = CFG.BUTTON_W / 2;
        int menuW = ButtonFlagBigCh.getButtonW() * 3 + CFG.PADD * 4;
        int menuH = ButtonFlagBigCh.getButtonH() + CFG.PADD * 2 + textTopH + CFG.PADD;
        int menuY = 0;
        menuElements.add(new Button_Transparent(1, 1, menuW - 1, menuH, false));
        this.initMenu(null, menuX, menuY, menuW, menuH, menuElements);
        this.updateLang();
        this.setVisibleM(false);
    }

    public Menu_Challenge() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int textTopH = (int)Math.max((float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4), (float)CFG.BUTTON_H * 0.5f);
        int menuW = ButtonFlagBigCh.getButtonW() + CFG.PADD * 2;
        int menuX = CFG.GAMEWIDTH - CFG.CIV_INFO_MENU_WIDTH - menuW - CFG.PADD;
        int menuH = ButtonFlagBigCh.getButtonH() + CFG.PADD * 2 + textTopH + CFG.PADD;
        int menuY = Menu_Civilization_Info.getUseMenu_UI2() ? Menu_Civilization_Info.getMenuY_UI2() : IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2;
        int buttonY = CFG.PADD;
        int buttonX = CFG.PADD;
        boolean nVisible = true;
        if (FileManager.loadFile("game/ChallengesD.txt").exists() || ChallengesManager.challengeList.isEmpty()) {
            menuElements.add(new Text());
            nVisible = false;
        } else {
            menuElements.add(new TextChal(CFG.lang.get("Challenge"), buttonX, buttonY, menuW - CFG.PADD * 2, textTopH){

                @Override
                public void actionElem(int iID) {
                }

                @Override
                public void drawE2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                }
            });
            menuElements.add(new ButtonFlagBigCh(Menu_CreateNewGame.CHALLENGE_MODE_NG, ChallengesManager.challengeList.get((int)Menu_CreateNewGame.CHALLENGE_MODE_NG).FORM_TAG, buttonX, buttonY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, true){

                @Override
                public void actionElem(int iID) {
                }
            });
        }
        int tMaxY = ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        menuElements.add(new Button_Transparent(1, 1, menuW - 1, Math.max(tMaxY, menuH - 1), false));
        this.initMenu(null, menuX, menuY, menuW, menuH, menuElements);
        this.updateLang();
        if (!nVisible) {
            this.setVisibleM(nVisible);
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_MENU_BLUE.r, CFG.COLOR_GRADIENT_MENU_BLUE.g, CFG.COLOR_GRADIENT_MENU_BLUE.b, CFG.COLOR_GRADIENT_MENU_BLUE.a));
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM(), 1.0f);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.75f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosX() + 1 + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthM() - 2, this.getHeightM() - 2, 1.0f);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM(), 1.0f);
        oSB.setColor(Color.WHITE);
        if (Menu_CreateNewGame.CHALLENGE_MODE_NG < 0) {
            this.setVisibleM(false);
        }
    }

    @Override
    public final void onBackPressed() {
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setVisibleE(false);
        }
    }
}

