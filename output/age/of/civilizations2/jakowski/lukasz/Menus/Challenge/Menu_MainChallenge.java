/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Challenge;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBigCh;
import age.of.civilizations2.jakowski.lukasz.Button2.TextChal;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Challenge.ChallengesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MainChallenge
extends Menu {
    public static int MENU_POSY_H = 0;
    public static boolean FULL_H = false;

    public Menu_MainChallenge() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int textTopH = (int)Math.max((float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4), (float)CFG.BUTTON_H * 0.5f);
        int menuX = CFG.BUTTON_W / 2;
        int menuW = ButtonFlagBigCh.getButtonW() * 3 + CFG.PADD * 4;
        int menuH = ButtonFlagBigCh.getButtonH() + CFG.PADD * 2 + textTopH + CFG.PADD;
        int menuY = 0;
        if (FULL_H) {
            menuH = CFG.GAMEHEIGHT - CFG.BUTTON_W / 2 * 2;
            menuY = CFG.GAMEHEIGHT - CFG.BUTTON_W / 2 - menuH;
        } else {
            if (ChallengesManager.challengeList.size() > 3) {
                menuH = ButtonFlagBigCh.getButtonH() * 2 + CFG.PADD + CFG.PADD * 2 + textTopH + CFG.PADD;
            }
            menuY = CFG.GAMEHEIGHT - CFG.BUTTON_W / 2 - menuH;
        }
        MENU_POSY_H = menuY;
        int buttonY = CFG.PADD;
        int buttonX = CFG.PADD;
        boolean nVisible = true;
        if (FileManager.loadFile("game/ChallengesD.txt").exists() || ChallengesManager.challengeList.isEmpty()) {
            menuElements.add(new Text());
            nVisible = false;
        } else {
            menuElements.add(new TextChal(CFG.lang.get("Challenges"), buttonX, buttonY, menuW - CFG.PADD * 2, textTopH){

                @Override
                public void actionElem(int iID) {
                    FULL_H = !FULL_H;
                    CFG.menus.setMenuIDWithoutAnim(View.eMAINMENU);
                }

                @Override
                public void actionElemPPM() {
                    Menu_MainChallenge.this.setVisibleM(false);
                }
            });
            buttonY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
            int i = ChallengesManager.challengeList.size() - 1;
            int a = 0;
            while (i >= 0) {
                menuElements.add(new ButtonFlagBigCh(i, ChallengesManager.challengeList.get((int)i).FORM_TAG, buttonX, buttonY, true){

                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysOverM(oSB, CFG.BUTTON_W / 2 - CFG.PADD, MENU_POSY_H);
                        }
                    }
                });
                buttonX += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getWidthE() + CFG.PADD;
                if ((a + 1) % 3 == 0) {
                    buttonX = CFG.PADD;
                    buttonY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
                }
                --i;
                ++a;
            }
        }
        int tMaxY = ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        menuElements.add(new Button_Transparent(1, 1, menuW - 1, Math.max(tMaxY, menuH - 1), false));
        this.initMenu(null, menuX, menuY, menuW, menuH, menuElements);
        this.updateLang();
        if (!nVisible) {
            this.setVisibleM(nVisible);
        }
        CFG.loadFlagsCh();
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

