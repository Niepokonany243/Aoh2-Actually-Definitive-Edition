
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextClear;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_History
extends Menu {
    private String sNumofDays;
    private int iNumofDaysWidth;

    public Menu_InGame_History(int iClear) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 3;
        boolean tY = false;
        menuElements.add(new TextScale(CFG.lang.get("----"), -1, 0, CFG.PADD, tempWidth - CFG.PADD * 4, CFG.BUTTON_H * 3 / 4, 0.75f){

            @Override
            public int getWidthE() {
                return Menu_InGame_History.this.getElementW();
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(false);
        int tempMenuPosY = IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 3 / 5 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("History"), CFG.BUTTON_H * 3 / 5, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.24313726f, 0.22352941f, 0.20784314f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.24313726f, 0.22352941f, 0.20784314f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.topDiplomacyPoints).drawO(oSB, nPosX + (nWidth - this.getTextWidth()) / 2 + (IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() + CFG.PADD) / 2 - CFG.PADD - IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() + iTranslateX, 2 + nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + (IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() + CFG.PADD) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, false, true);
        this.updateLang();
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(i % 2);
        }
    }

    public Menu_InGame_History() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 3;
        int tY = 0;
        if (CFG.historyManager.haveHistory()) {
            CFG.historyManager.buildHistoryDates();
            int iSize = CFG.historyManager.getHistorySize();
            for (int i = 0; i < iSize; ++i) {
                int jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (int j = 0; j < jSize; ++j) {
                    menuElements.add(new TextClear(i, j, 0, tY, tempWidth, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

                        @Override
                        public int getWidthE() {
                            return Menu_InGame_History.this.getElementW();
                        }

                        @Override
                        public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                            CFG.historyManager.getHistory(this.getTextPosElem(), this.getCurr()).draw(oSB, this.getTextPosElem(), this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), isActive);
                        }
                    });
                    tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
        }
        if (menuElements.size() == 0) {
            menuElements.add(new TextScale(CFG.lang.get("----"), -1, 0, CFG.PADD, tempWidth - CFG.PADD * 4, CFG.BUTTON_H * 3 / 4, 0.75f){

                @Override
                public int getWidthE() {
                    return Menu_InGame_History.this.getElementW();
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(false);
        }
        int tempMenuPosY = IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 4 / 5 + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("History"), CFG.BUTTON_H * 4 / 5, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.24313726f, 0.22352941f, 0.20784314f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.24313726f, 0.22352941f, 0.20784314f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.topDiplomacyPoints).drawO(oSB, nPosX + (nWidth - this.getTextWidth()) / 2 + (IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() + CFG.PADD) / 2 - CFG.PADD - IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() + iTranslateX, 2 + nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + (IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() + CFG.PADD) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
                IMGManager.getIMG(Images.time).drawO(oSB, nPosX + nWidth - CFG.PADD - 2 - (int)((float)IMGManager.getIMG(Images.time).getWidth() * Menu_InGame_History.this.getImageScale2(Images.time)) + iTranslateX, nPosY - CFG.PADD - (int)((float)IMGManager.getIMG(Images.time).getHeight() * Menu_InGame_History.this.getImageScale2(Images.time)) - IMGManager.getIMG(Images.time).getHeight(), (int)((float)IMGManager.getIMG(Images.time).getWidth() * Menu_InGame_History.this.getImageScale2(Images.time)), (int)((float)IMGManager.getIMG(Images.time).getHeight() * Menu_InGame_History.this.getImageScale2(Images.time)));
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, Menu_InGame_History.this.sNumofDays, nPosX + nWidth - Menu_InGame_History.this.iNumofDaysWidth - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.time).getWidth() * Menu_InGame_History.this.getImageScale2(Images.time)) - 2 + iTranslateX, nPosY - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT, CFG.COLOR_NEUTRAL);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, CFG.gameAges.getAge(GameCalendar.CURRENT_AGEID).getName(), nPosX + CFG.PADD + iTranslateX, nPosY - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT, CFG.COLOR_NEUTRAL);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, false, true);
        this.updateLang();
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(i % 2);
        }
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("History"));
        this.sNumofDays = GameCalendar.TURNID == 1 ? GameCalendar.getCurrDate() : GameCalendar.getNumOfDatesByTurnID(1);
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sNumofDays);
        this.iNumofDaysWidth = (int)CFG.glyphLay.width;
    }

    private final float getImageScale2(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING - 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + 4 + Core.PADDING * 2, this.getHeightM() + 2 + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + 2 + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, true, true);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void drawCloseButton(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.getCloseButtonImage(sliderMenuIsActive).drawO(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.btnClose).getWidth() * 3 / 5 + iTranslateX, this.getPosY() - this.getTitleM().getHeightT() - IMGManager.getIMG(Images.btnClose).getHeight() + iTranslateY, IMGManager.getIMG(Images.btnClose).getWidth() * 3 / 5, IMGManager.getIMG(Images.btnClose).getHeight() * 3 / 5);
    }

    @Override
    public final void actionEL(int iID) {
    }

    public final int getW() {
        return this.getWidthM();
    }

    public final int getElementW() {
        return this.getW();
    }
}

