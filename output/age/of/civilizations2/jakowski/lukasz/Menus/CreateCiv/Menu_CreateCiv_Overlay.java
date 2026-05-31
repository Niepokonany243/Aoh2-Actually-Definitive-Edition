/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.CreateCiv;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Left;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Middle;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Right;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateCiv_Overlay
extends Menu {
    public Menu_CreateCiv_Overlay() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH * 3 / 4;
        int tempH = 100 + CFG.PADD * 4;
        int tPosY = CFG.PADD;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_NewGameStyle(null, -1, CFG.PADD, tPosY, tempW - CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle_Middle("", 0, CFG.PADD + CFG.BUTTON_H, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2 - CFG.BUTTON_H * 2, Math.max(100 + CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f)), true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                CFG.flagManager.drawFlag_FlagFrameSize(oSB, this.getPosXE() + this.getWidthE() / 2 - 77 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - 50 + iTranslateY);
            }
        });
        menuElements.add(new Button_NewGameStyle_Left("<<", -1, CFG.PADD, tPosY, CFG.BUTTON_H, Math.max(100 + CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f)), true));
        menuElements.add(new Button_NewGameStyle_Right(">>", -1, tempW - CFG.PADD - CFG.BUTTON_H, tPosY, CFG.BUTTON_H, Math.max(100 + CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f)), true));
        menuElements.add(new Slider("X: ", CFG.PADD + CFG.BUTTON_H + CFG.BUTTON_H / 2, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2 - CFG.BUTTON_H * 3, (int)((float)CFG.BUTTON_H * 0.7f), -154, 154, 0));
        menuElements.add(new Button_NewGameStyle_Left("-", -1, CFG.PADD, tPosY, CFG.BUTTON_H + CFG.BUTTON_H / 2, (int)((float)CFG.BUTTON_H * 0.7f), true));
        menuElements.add(new Button_NewGameStyle_Right("+", -1, tempW - CFG.PADD - CFG.BUTTON_H - CFG.BUTTON_H / 2, tPosY, CFG.BUTTON_H + CFG.BUTTON_H / 2, (int)((float)CFG.BUTTON_H * 0.7f), true));
        menuElements.add(new Slider("Y: ", CFG.PADD + CFG.BUTTON_H + CFG.BUTTON_H / 2, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2 - CFG.BUTTON_H * 3, (int)((float)CFG.BUTTON_H * 0.7f), -100, 100, 0));
        menuElements.add(new Button_NewGameStyle_Left("-", -1, CFG.PADD, tPosY, CFG.BUTTON_H + CFG.BUTTON_H / 2, (int)((float)CFG.BUTTON_H * 0.7f), true));
        menuElements.add(new Button_NewGameStyle_Right("+", -1, tempW - CFG.PADD - CFG.BUTTON_H - CFG.BUTTON_H / 2, tPosY, CFG.BUTTON_H + CFG.BUTTON_H / 2, (int)((float)CFG.BUTTON_H * 0.7f), true));
        menuElements.add(new Slider("", CFG.PADD + CFG.BUTTON_H + CFG.BUTTON_H / 2, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2 - CFG.BUTTON_H * 3, (int)((float)CFG.BUTTON_H * 0.7f), 1, 154, 1));
        menuElements.add(new Button_NewGameStyle_Left("-", -1, CFG.PADD, tPosY, CFG.BUTTON_H + CFG.BUTTON_H / 2, (int)((float)CFG.BUTTON_H * 0.7f), true));
        menuElements.add(new Button_NewGameStyle_Right("+", -1, tempW - CFG.PADD - CFG.BUTTON_H - CFG.BUTTON_H / 2, tPosY, CFG.BUTTON_H + CFG.BUTTON_H / 2, (int)((float)CFG.BUTTON_H * 0.7f), true));
        menuElements.add(new Slider("", CFG.PADD + CFG.BUTTON_H + CFG.BUTTON_H / 2, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2 - CFG.BUTTON_H * 3, (int)((float)CFG.BUTTON_H * 0.7f), 1, 100, 1));
        menuElements.add(new Button_NewGameStyle_Left("-", -1, CFG.PADD, tPosY, CFG.BUTTON_H + CFG.BUTTON_H / 2, (int)((float)CFG.BUTTON_H * 0.7f), true));
        menuElements.add(new Button_NewGameStyle_Right("+", -1, tempW - CFG.PADD - CFG.BUTTON_H - CFG.BUTTON_H / 2, tPosY, CFG.BUTTON_H + CFG.BUTTON_H / 2, (int)((float)CFG.BUTTON_H * 0.7f), true));
        menuElements.add(new Slider("", CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.7f), 1, 100, 50){

            @Override
            public String getDrawText() {
                return super.getDrawText() + "%";
            }
        });
        menuElements.add(new Button_NewGameStyle(CFG.lang.get("Color"), -1, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.75f), true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).oColor.getR(), CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).oColor.getG(), CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).oColor.getB(), 1.0f);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + Menu_CreateCiv_Overlay.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, CFG.PADD, CFG.CIV_COLOR_W, true, false);
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + CFG.PADD + iTranslateX, this.getPosY() + Menu_CreateCiv_Overlay.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, this.getTextWidthU() - CFG.PADD * 2, CFG.CIV_COLOR_W);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + this.getTextWidthU() - CFG.PADD + iTranslateX, this.getPosY() + Menu_CreateCiv_Overlay.this.getMenuPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_COLOR_W, CFG.PADD, CFG.CIV_COLOR_W);
                oSB.setColor(Color.WHITE);
            }
        });
        menuElements.add(new Button_NewGameStyle_Left(CFG.lang.get("CenterX", "X"), -1, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (tempW - CFG.PADD * 2) / 2, (int)((float)CFG.BUTTON_H * 0.75f), true));
        menuElements.add(new Button_NewGameStyle_Right(CFG.lang.get("CenterX", "Y"), -1, tempW - CFG.PADD * 2 - (tempW - CFG.PADD * 2) / 2, tPosY, (tempW - CFG.PADD * 2) / 2, (int)((float)CFG.BUTTON_H * 0.75f), true));
        menuElements.add(new Button_NewGameStyle("Age of History 2: Definitive Edition", -1, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        this.initMenu(null, 0 + AoCGame.LEFT, CFG.BUTTON_H / 2 + (100 + CFG.PADD * 4), tempW, Math.min((tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD) + CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H / 2 + (100 + CFG.PADD * 4) + CFG.PADD)), menuElements);
        this.setVisibleM(false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        try {
            this.getMenuElem(4).setTextE("X: ");
            this.getMenuElem(4).setCurr(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iPosX);
            this.getMenuElem(7).setTextE("Y: ");
            this.getMenuElem(7).setCurr(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iPosY);
            this.getMenuElem(10).setTextE(CFG.lang.get("Width") + ": ");
            this.getMenuElem(10).setCurr(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iWidth);
            this.getMenuElem(13).setTextE(CFG.lang.get("Height") + ": ");
            this.getMenuElem(13).setCurr(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iHeight);
            this.getMenuElem(16).setTextE(CFG.lang.get("Scale") + ": ");
            this.updateScale();
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            // empty catch block
        }
    }

    private final void updateScale() {
        this.getMenuElem(16).setCurr((int)((float)CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iHeight / (float)CFG.flagManager.getOverlay(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iOverlayID).getHeight() * 100.0f));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight(), this.getWidthM() + 2, this.getHeightM(), true, false);
        oSB.setColor(new Color(0.011f, 0.014f, 0.019f, 0.25f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthM() * 3 / 4, this.getHeightM(), false, true);
        oSB.setColor(Color.WHITE);
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - IMGManager.getIMG(Images.pix255).getHeight(), this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthM(), 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.menus.setVisibleCreateCiv_Overlay(false);
                CFG.menus.rebuildCreateCiv_Flag();
                CFG.menus.getColorPicker().setVisible(false, null);
                return;
            }
            case 2: {
                CFG.flagManager.updateOverlay(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID, false);
                this.updateLang();
                return;
            }
            case 3: {
                CFG.flagManager.updateOverlay(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID, true);
                this.updateLang();
                return;
            }
            case 4: {
                CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iPosX = this.getMenuElem(iID).getCurr();
                return;
            }
            case 5: {
                --CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iPosX;
                this.getMenuElem(4).setCurr(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iPosX);
                return;
            }
            case 6: {
                ++CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iPosX;
                this.getMenuElem(4).setCurr(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iPosX);
                return;
            }
            case 7: {
                CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iPosY = this.getMenuElem(iID).getCurr();
                return;
            }
            case 8: {
                --CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iPosY;
                this.getMenuElem(7).setCurr(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iPosY);
                return;
            }
            case 9: {
                ++CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iPosY;
                this.getMenuElem(7).setCurr(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iPosY);
                return;
            }
            case 10: {
                CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iWidth = this.getMenuElem(iID).getCurr();
                this.updateScale();
                return;
            }
            case 11: {
                --CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iWidth;
                this.getMenuElem(10).setCurr(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iWidth);
                this.updateScale();
                return;
            }
            case 12: {
                ++CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iWidth;
                this.getMenuElem(10).setCurr(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iWidth);
                this.updateScale();
                return;
            }
            case 13: {
                CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iHeight = this.getMenuElem(iID).getCurr();
                return;
            }
            case 14: {
                --CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iHeight;
                this.getMenuElem(13).setCurr(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iHeight);
                return;
            }
            case 15: {
                ++CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iHeight;
                this.getMenuElem(13).setCurr(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iHeight);
                return;
            }
            case 16: {
                CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iWidth = (int)Math.ceil((float)(CFG.flagManager.getOverlay(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iOverlayID).getWidth() * this.getMenuElem(iID).getCurr()) / 100.0f);
                CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iHeight = (int)Math.ceil((float)(CFG.flagManager.getOverlay(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iOverlayID).getHeight() * this.getMenuElem(iID).getCurr()) / 100.0f);
                this.getMenuElem(10).setCurr(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iWidth);
                this.getMenuElem(13).setCurr(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iHeight);
                return;
            }
            case 17: {
                if (CFG.menus.getColorPicker().getVisible()) {
                    CFG.menus.getColorPicker().setVisible(false, null);
                } else {
                    CFG.menus.getColorPicker().setActiveRGBColor(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).oColor.getR(), CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).oColor.getG(), CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).oColor.getB());
                    CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.EDITOR_CIV_FLAG_OVERLAY_COLOR);
                }
                return;
            }
            case 18: {
                CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iPosX = (154 - CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iWidth) / 2;
                return;
            }
            case 19: {
                CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iPosY = (100 - CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).iHeight) / 2;
                return;
            }
        }
    }
}

