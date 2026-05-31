/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.RTO;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.RTO.Button_RTO;
import age.of.civilizations2.jakowski.lukasz.Button.RTO.Button_RTO2;
import age.of.civilizations2.jakowski.lukasz.Button.RTO.Button_RTO_Player;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Info.Menu_InGame_ProvInfo;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_RTO2
extends Menu {
    public static final int ANIMATION_TIME = 250;
    public static long lTime = 0L;
    private String sLoading;
    public static final int TIME_REQUIRED_TO_CONTINUE = 30;
    public static long TIME_CONTINUE;

    public Menu_InGame_RTO2() {
        int tempRowH = CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 > CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2 ? CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 : CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2;
        int tempW = CFG.CIV_INFO_MENU_WIDTH * 4 / 5;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (CFG.settingsGD.showOrderOfMovesView) {
            if (CFG.FOG_OF_WAR == 2) {
                for (int i = 0; i < CFG.core.getRTO().getRTOSize(); ++i) {
                    if (CFG.core.getCiv(CFG.core.getRTO().getRTO(i)).getIsPlayer()) {
                        menuElements.add(new Button_RTO_Player(i + 1, CFG.core.getRTO().getRTO(i), 0, tempRowH * i, tempW, tempRowH, true));
                        continue;
                    }
                    if (i % 2 == 0) {
                        menuElements.add(new Button_RTO(i + 1, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getRTO().getRTO(i)) ? CFG.core.getRTO().getRTO(i) : -1, 0, tempRowH * i, tempW, tempRowH, true));
                        continue;
                    }
                    menuElements.add(new Button_RTO2(i + 1, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getRTO().getRTO(i)) ? CFG.core.getRTO().getRTO(i) : -1, 0, tempRowH * i, tempW, tempRowH, true));
                }
            } else {
                for (int i = 0; i < CFG.core.getRTO().getRTOSize(); ++i) {
                    if (CFG.core.getCiv(CFG.core.getRTO().getRTO(i)).getIsPlayer()) {
                        menuElements.add(new Button_RTO_Player(i + 1, CFG.core.getRTO().getRTO(i), 0, tempRowH * i, tempW, tempRowH, true));
                        continue;
                    }
                    if (i % 2 == 0) {
                        menuElements.add(new Button_RTO(i + 1, CFG.core.getRTO().getRTO(i), 0, tempRowH * i, tempW, tempRowH, true));
                        continue;
                    }
                    menuElements.add(new Button_RTO2(i + 1, CFG.core.getRTO().getRTO(i), 0, tempRowH * i, tempW, tempRowH, true));
                }
            }
        } else {
            int i = 0;
            if (i < CFG.core.getRTO().getRTOSize()) {
                if (CFG.core.getCiv(CFG.core.getRTO().getRTO(i)).getIsPlayer()) {
                    menuElements.add(new Button_RTO_Player(i + 1, CFG.core.getRTO().getRTO(i), 0, tempRowH * i, tempW, tempRowH, true));
                } else if (i % 2 == 0) {
                    menuElements.add(new Button_RTO(i + 1, CFG.core.getRTO().getRTO(i), 0, tempRowH * i, tempW, tempRowH, true));
                } else {
                    menuElements.add(new Button_RTO2(i + 1, CFG.core.getRTO().getRTO(i), 0, tempRowH * i, tempW, tempRowH, true));
                }
            }
        }
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_RTO2.this.getPosX() + iTranslateX, Menu_InGame_RTO2.this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_RTO2.this.getWidthM(), this.getHeightT());
                oSB.setColor(new Color(0.011f, 0.014f, 0.019f, 0.8f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_InGame_RTO2.this.getPosX() + 2 + iTranslateX, Menu_InGame_RTO2.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightT() * 3 / 4, Menu_InGame_RTO2.this.getWidthM(), this.getHeightT() * 3 / 4, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_RTO2.this.getPosX() + 2 + iTranslateX, Menu_InGame_RTO2.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_RTO2.this.getWidthM() - 2);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_RTO2.this.getPosX() + 2 + iTranslateX, Menu_InGame_RTO2.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_RTO2.this.getWidthM() - 2, 1);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - this.getTextHeight() / 2, CFG.COLOR_TEXT_GRAY_LEFT_NS);
            }
        }, CFG.GAMEWIDTH - tempW, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempW, CFG.GAMEHEIGHT * 4 / 5 - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4) - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2 - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - (CFG.BUTTON_H * 3 / 4 + CFG.PADD * 2) < (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 8 ? CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4) - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2 - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - (CFG.BUTTON_H * 3 / 4 + CFG.PADD * 2) : CFG.GAMEHEIGHT * 4 / 5 - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4) - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2 - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - (CFG.BUTTON_H * 3 / 4 + CFG.PADD * 2), menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("OrderOfMoves"));
        this.sLoading = CFG.lang.get("Loading") + ": ";
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (CFG.settingsGD.showOrderOfMovesView) {
            if (lTime + 250L >= System.currentTimeMillis()) {
                iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / 250.0f));
            }
            IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM(), false, true);
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            if (!CFG.oAI.doneLoadingOrders) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.9f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, this.getLoadPosY() - IMGManager.getIMG(Images.line32Off1).getHeight(), CFG.map.getMpB().getMinimapWidth(), this.getLoadHeight(), false, false);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, this.getLoadPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.map.getMpB().getMinimapWidth() / 2, this.getLoadHeight(), false, false);
                oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, this.getLoadPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.map.getMpB().getMinimapWidth(), 1, false, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, this.getLoadPosY() + this.getLoadHeight() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.map.getMpB().getMinimapWidth(), 1, false, false);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, this.getLoadPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.map.getMpB().getMinimapWidth(), 1, false, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, this.getLoadPosY() + this.getLoadHeight() - 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.map.getMpB().getMinimapWidth(), 1, false, false);
                oSB.setColor(Color.WHITE);
                Core.drawFlagRect(oSB, CFG.PADD * 2, this.getLoadPosY() + this.getLoadHeight() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.oAI.iLoadingTurnActionsOfCivID);
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sLoading + (int)((float)CFG.oAI.iLoadingTurnActionsOfCivID / (float)(CFG.core.getCivsSize() - 1) * 100.0f) + "%", CFG.PADD * 4 + IMGManager.getIMG(Images.flagRect2).getWidth(), this.getLoadPosY() + (this.getLoadHeight() - CFG.TEXT_HEIGHT_DEFAULT_SMALL) / 2, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            } else if (TIME_CONTINUE > 0L && TIME_CONTINUE < System.currentTimeMillis() - 30L) {
                Menu_InGame_ProvInfo.clickEndTurn();
            }
        } else if (!CFG.oAI.doneLoadingOrders) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.9f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, this.getLoadPosY() - IMGManager.getIMG(Images.line32Off1).getHeight(), CFG.map.getMpB().getMinimapWidth(), this.getLoadHeight(), false, false);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, this.getLoadPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.map.getMpB().getMinimapWidth() / 2, this.getLoadHeight(), false, false);
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, this.getLoadPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.map.getMpB().getMinimapWidth(), 1, false, false);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, this.getLoadPosY() + this.getLoadHeight() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.map.getMpB().getMinimapWidth(), 1, false, false);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, this.getLoadPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.map.getMpB().getMinimapWidth(), 1, false, false);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, this.getLoadPosY() + this.getLoadHeight() - 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.map.getMpB().getMinimapWidth(), 1, false, false);
            oSB.setColor(Color.WHITE);
            Core.drawFlagRect(oSB, CFG.PADD * 2, this.getLoadPosY() + this.getLoadHeight() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.oAI.iLoadingTurnActionsOfCivID);
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sLoading + (int)((float)CFG.oAI.iLoadingTurnActionsOfCivID / (float)(CFG.core.getCivsSize() - 1) * 100.0f) + "%", CFG.PADD * 4 + IMGManager.getIMG(Images.flagRect2).getWidth(), this.getLoadPosY() + (this.getLoadHeight() - CFG.TEXT_HEIGHT_DEFAULT_SMALL) / 2, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        } else if (TIME_CONTINUE > 0L && TIME_CONTINUE < System.currentTimeMillis() - 30L) {
            Menu_InGame_ProvInfo.clickEndTurn();
        }
    }

    public final int getLoadPosY() {
        return CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - this.getLoadHeight();
    }

    public final int getLoadHeight() {
        return IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 4;
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive || this.getScrollModeY()) {
            super.drawScrollPos(oSB, iTranslateX - 2, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void actionEL(int nID) {
        if (CFG.FOG_OF_WAR != 2 || CFG.getMetCiv_AllPlayers(CFG.core.getRTO().getRTO(nID))) {
            if (CFG.FOG_OF_WAR != 2 || CFG.getMetProv(CFG.core.getCiv(CFG.core.getRTO().getRTO(nID)).getCapitalProvID())) {
                CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getRTO().getRTO(nID)).getCapitalProvID());
            }
            CFG.toastM.addM(CFG.core.getCiv(CFG.core.getRTO().getRTO(nID)).getCivName(), CFG.COLOR_HOVER_TITLE);
        } else {
            CFG.toastM.addM(CFG.lang.get("UndiscoveredCivilization"), CFG.COLOR_HOVER_TITLE);
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        lTime = System.currentTimeMillis();
        TIME_CONTINUE = -1L;
        if (!visible) {
            CFG.menus.setVisibleInGame_RTOBot(visible);
        }
    }
}

