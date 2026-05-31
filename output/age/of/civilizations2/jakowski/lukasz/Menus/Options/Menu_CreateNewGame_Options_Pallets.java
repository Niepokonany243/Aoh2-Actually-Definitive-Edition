
package age.of.civilizations2.jakowski.lukasz.Menus.Options;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.CNG.Button_CNG_Options;
import age.of.civilizations2.jakowski.lukasz.Button.CNG.Button_CNG_Options2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateNewGame_Options_Pallets
extends Menu {
    public static final int ANIMATION_TIME = 250;
    public static long lTime = 0L;

    public Menu_CreateNewGame_Options_Pallets() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tempMaxH = CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4) - (CFG.BUTTON_H + CFG.PADD * 2) - CFG.PADD;
        int tempElemH = CFG.BUTTON_H * 3 / 4;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_CNG_Options("", -1, 0, 0, tempW, tempElemH, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                CFG.palletManager.drawSampleColors_Standard(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + CFG.PADD * 2 + iTranslateY, this.getWidthE() - CFG.PADD * 4, this.getHeightE() - CFG.PADD * 4, 0, isActive || CFG.palletManager.getActivePalletID() == 0);
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
            }
        });
        for (int i = 0; i < CFG.palletManager.getNumOfPallets(); ++i) {
            try {
                menuElements.add(new Button_CNG_Options("" + CFG.palletManager.getNumOfColorsInPallet(i), -1, 0, tempElemH * (i + 2), tempW, tempElemH, true){
                    int iCurrent;
                    {
                        this.iCurrent = 0;
                    }

                    @Override
                    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        CFG.palletManager.drawSampleColors(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + CFG.PADD * 2 + iTranslateY, this.getWidthE() - CFG.PADD * 4, this.getHeightE() - CFG.PADD * 4, this.getCurr(), isActive || CFG.palletManager.getActivePalletID() == this.getCurr() + 1);
                        oSB.setColor(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.9f);
                        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 - CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 - CFG.CIV_COLOR_W - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getTextWidthU() + CFG.PADD * 4, this.getTextHeight() + CFG.CIV_COLOR_W * 2);
                        oSB.setColor(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 1.0f);
                        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 - CFG.PADD * 2 + iTranslateX, 1 + this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 - CFG.CIV_COLOR_W - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getTextWidthU() + CFG.PADD * 4, 1);
                        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 - CFG.PADD * 2 + iTranslateX, this.getTextHeight() + CFG.CIV_COLOR_W * 2 - 2 + this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 - CFG.CIV_COLOR_W - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getTextWidthU() + CFG.PADD * 4, 1);
                        oSB.setColor(Color.WHITE);
                        super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                    }

                    @Override
                    public void setCurr(int nCurrent) {
                        this.iCurrent = nCurrent;
                    }

                    @Override
                    public int getCurr() {
                        return this.iCurrent;
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PalletCivColors"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("NumberOfColors") + ": "));
                        nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
                continue;
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                
            }
        }
        menuElements.add(new Button_CNG_Options2(null, -1, 0, tempElemH, tempW, tempElemH, true));
        menuElements.add(new Button_CNG_Options(null, -1, 0, tempElemH * menuElements.size(), tempW, tempElemH, true));
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_CreateNewGame_Options_Pallets.this.getPosX() + iTranslateX, Menu_CreateNewGame_Options_Pallets.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_CreateNewGame_Options_Pallets.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.011f, 0.014f, 0.019f, 0.25f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_CreateNewGame_Options_Pallets.this.getPosX() + iTranslateX, Menu_CreateNewGame_Options_Pallets.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightT() * 3 / 4, Menu_CreateNewGame_Options_Pallets.this.getWidthM(), this.getHeightT() * 3 / 4, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_CreateNewGame_Options_Pallets.this.getPosX() + iTranslateX, Menu_CreateNewGame_Options_Pallets.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_CreateNewGame_Options_Pallets.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_CreateNewGame_Options_Pallets.this.getPosX() + iTranslateX, Menu_CreateNewGame_Options_Pallets.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_CreateNewGame_Options_Pallets.this.getWidthM(), 1);
                if (AoCGame.LEFT != 0) {
                    oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
                    IMGManager.getIMG(Images.pix255).draw2O(oSB, Menu_CreateNewGame_Options_Pallets.this.getPosX() + iTranslateX, Menu_CreateNewGame_Options_Pallets.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - this.getHeightT(), 1, this.getHeightT(), true, false);
                    oSB.setColor(Color.WHITE);
                }
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.7f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.8f / 2.0f) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - (int)((float)this.getTextHeight() * 0.8f / 2.0f), CFG.COLOR_TEXT_GRAY_LEFT_NS);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, 0 + AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempW, tempMaxH < tempElemH * menuElements.size() ? tempMaxH : tempElemH * menuElements.size(), menuElements);
        this.setVisibleM(false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("DefaultColors"));
        this.getMenuElem(this.getMenuElemsSize() - 2).setTextE(CFG.lang.get("DownloadMore"));
        this.getMenuElem(this.getMenuElemsSize() - 1).setTextE(CFG.lang.get("Back"));
        this.getTitleM().setText(CFG.lang.get("PalletsOfColors"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + 250L >= System.currentTimeMillis()) {
            iTranslateX += -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / 250.0f));
            CFG.setRenderO(true);
        }
        if (CFG.settingsGD.BETTER_UI) {
            BetterUI_Manager.drawBetterMenuBG(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM());
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            return;
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2 + Core.PADDING, this.getHeightM(), true, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM(), this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM(), this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM(), this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if ((sliderMenuIsActive || this.getScrollModeY()) && !CFG.menus.getSliderMode()) {
            super.drawScrollPos(oSB, iTranslateX - 2, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.mapModesManager.disableAllViews();
                CFG.palletManager.setActivePalletID(0);
                CFG.palletManager.loadCivilizationStandardColors();
                CFG.toastM.addM(CFG.lang.get("Done"));
                return;
            }
        }
        if (iID == this.getMenuElemsSize() - 1) {
            CFG.menus.setVisible_CreateNewGame_Options(true);
            return;
        }
        if (iID == this.getMenuElemsSize() - 2) {
            CFG.core.disableDrawCivlizationsRegions_Players();
            CFG.backToMenu = View.eCREATE_NEW_GAME;
            CFG.menus.setMenuID(View.eDOWNLOAD_PALLETS);
            return;
        }
        CFG.mapModesManager.disableAllViews();
        CFG.palletManager.setActivePalletID(iID);
        CFG.palletManager.loadCivilizationsPaletteOfColors(iID);
        CFG.toastM.addM(CFG.lang.get("Done"));
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        lTime = System.currentTimeMillis();
    }
}

