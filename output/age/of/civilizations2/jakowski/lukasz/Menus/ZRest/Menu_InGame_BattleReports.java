/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Battle;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_BattleReports
extends Menu {
    private long lTime = 0L;

    public Menu_InGame_BattleReports() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = (int)((float)CFG.BUTTON_W * 6.5f);
        int tempHeight = CFG.BUTTON_H * 4 + CFG.BUTTON_H * 3 / 4;
        if (tempWidth > CFG.GAMEWIDTH) {
            tempWidth = CFG.GAMEWIDTH - CFG.PADD * 4;
        }
        int tY = 0;
        for (int i = 0; i < CFG.gameAction.battleReports.size(); ++i) {
            menuElements.add(new ButtonN_Battle(CFG.lang.get("Battle") + ": " + CFG.core.getProv(Math.max(0, CFG.gameAction.battleReports.get((int)i).iBattleOfProvinceID)).getProvName(), CFG.gameAction.battleReports.get((int)i).lAttackers_IDs.get(0), CFG.gameAction.battleReports.get((int)i).lDefenders_IDs.get(0), 2, tY, CFG.BUTTON_W * 2, i, CFG.gameAction.battleReports.get(i).getAttackersArmy(), CFG.gameAction.battleReports.get(i).getDefendersArmy(), CFG.gameAction.battleReports.get(i).getAttackersArmy_Lost(), CFG.gameAction.battleReports.get(i).getDefendersArmy_Lost()){

                @Override
                public int getWidthE() {
                    return Menu_InGame_BattleReports.this.getW() - 4;
                }

                @Override
                public void actionElem(int iID) {
                    try {
                        CFG.reportData = CFG.gameAction.battleReports.get(this.getCurr());
                        CFG.menus.rebuildInGame_Report();
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        int tempMaxH = 0;
        for (int i = 0; i < menuElements.size(); ++i) {
            if (((MenuElemUI)menuElements.get(i)).getPosY() + ((MenuElemUI)menuElements.get(i)).getHeightE() <= tempMaxH) continue;
            tempMaxH = ((MenuElemUI)menuElements.get(i)).getPosY() + ((MenuElemUI)menuElements.get(i)).getHeightE();
        }
        menuElements.add(new Button_InGameBox(CFG.lang.get("Close"), -1, CFG.PADD, tempMaxH + CFG.PADD * 2, tempWidth - CFG.PADD * 2, CFG.BUTTON_H * 3 / 4, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_CIV_INFO_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_INFO_HOVER : new Color(0.4509804f, 0.45882353f, 0.4745098f, 1.0f));
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, this.getIsHovered() ? 0.75f : 0.5f));
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_BattleReports.this.getW() - CFG.PADD * 2;
            }
        });
        if (tempHeight > ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD) {
            tempHeight = ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Battles") + ": " + CFG.gameAction.battleReports.size(), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, nPosX + iTranslateX, nPosY - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), nWidth - IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth(), this.getHeightT());
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, nPosX + nWidth - IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth() + iTranslateX, nPosY - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth(), this.getHeightT(), true);
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - (this.getHeightT() - 2) * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, (this.getHeightT() - 2) * 2 / 3, false, true);
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - (int)((float)this.getHeightT() / 2.5f) - IMGManager.getIMG(Images.gradient).getHeight() + 2, nWidth - 4, (int)((float)this.getHeightT() / 2.5f) - 2, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX + 2 + iTranslateX, nPosY - IMGManager.getIMG(Images.pix255).getHeight() * 2, nWidth - 4, IMGManager.getIMG(Images.pix255).getHeight());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - IMGManager.getIMG(Images.pix255).getHeight() * 2, nWidth - 4, 1);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.battle).drawO(oSB, nPosX + nWidth / 2 - this.getTextWidth() / 2 - CFG.PADD - IMGManager.getIMG(Images.battle).getWidth() + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.battle).getHeight() / 2);
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, (CFG.GAMEWIDTH - tempWidth) / 2, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempWidth, tempHeight, menuElements, false, true);
    }

    public final String getRandomBattleName(String sBattleOf) {
        int nR = CFG.oR.nextInt(1000);
        switch (nR % 4) {
            case 1: {
                return CFG.lang.get("ScrambleFor", sBattleOf);
            }
            case 2: {
                return CFG.lang.get("InvasionOf", sBattleOf);
            }
            case 3: {
                return CFG.lang.get("AttackOn", sBattleOf);
            }
        }
        return CFG.lang.get("BattleOf", sBattleOf);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (this.lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX() - Core.PADDING, CFG.GAMEHEIGHT - this.getPosY(), this.getWidthM() + Core.PADDING * 2, -((int)((float)this.getHeightM() * ((float)(System.currentTimeMillis() - this.lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
        }
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + this.getWidthM() + Core.PADDING - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD, true, true);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.475f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + 2 + (this.getWidthM() - 4) / 2 - (this.getWidthM() - 4) / 8 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (this.getWidthM() - 4) / 8, this.getHeightM(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + 2 + (this.getWidthM() - 4) / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (this.getWidthM() - 4) / 8, this.getHeightM());
        oSB.setColor(Color.WHITE);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (this.lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            try {
                oSB.flush();
                ScissorStack.popScissors();
            }
            catch (IllegalStateException illegalStateException) {
                // empty catch block
            }
        }
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public final void actionEL(int iID) {
        if (iID == this.getMenuElemsSize() - 1) {
            this.setVisibleM(false);
        } else {
            super.actionEL(iID);
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        this.lTime = System.currentTimeMillis();
    }

    public final int getW() {
        return this.getWidthM();
    }
}

