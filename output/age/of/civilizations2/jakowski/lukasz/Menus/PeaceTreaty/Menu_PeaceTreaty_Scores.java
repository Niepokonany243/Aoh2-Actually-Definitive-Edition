
package age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextPeaceTreaty_Scores;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_PeaceTreaty_Scores
extends Menu {
    public final float FONT_SCALE = 0.8f;

    public Menu_PeaceTreaty_Scores() {
        int i;
        int iBest;
        int i2;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tMenuWidth = CFG.CIV_INFO_MENU_WIDTH * 2 / 5;
        int tElementH = Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4);
        int tPosY = 0;
        boolean playerIsDefender = false;
        for (int i3 = 0; i3 < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.size(); ++i3) {
            if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i3).iCivID != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
            playerIsDefender = true;
            break;
        }
        ArrayList<Integer> lSortedDefenders = new ArrayList<Integer>();
        ArrayList<Integer> tempDefenders = new ArrayList<Integer>();
        ArrayList<Integer> lSortedAggressors = new ArrayList<Integer>();
        ArrayList<Integer> tempAggressors = new ArrayList<Integer>();
        for (i2 = 0; i2 < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.size(); ++i2) {
            tempDefenders.add(i2);
        }
        while (tempDefenders.size() > 0) {
            iBest = 0;
            for (i = 1; i < tempDefenders.size(); ++i) {
                if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)((Integer)tempDefenders.get((int)iBest)).intValue()).iVictoryPointsLeft >= CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)((Integer)tempDefenders.get((int)i)).intValue()).iVictoryPointsLeft) continue;
                iBest = i;
            }
            lSortedDefenders.add((Integer)tempDefenders.get(iBest));
            tempDefenders.remove(iBest);
        }
        for (i2 = 0; i2 < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.size(); ++i2) {
            tempAggressors.add(i2);
        }
        while (tempAggressors.size() > 0) {
            iBest = 0;
            for (i = 1; i < tempAggressors.size(); ++i) {
                if (CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)((Integer)tempAggressors.get((int)iBest)).intValue()).iVictoryPointsLeft >= CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)((Integer)tempAggressors.get((int)i)).intValue()).iVictoryPointsLeft) continue;
                iBest = i;
            }
            lSortedAggressors.add((Integer)tempAggressors.get(iBest));
            tempAggressors.remove(iBest);
        }
        if (playerIsDefender) {
            for (i2 = 0; i2 < lSortedDefenders.size(); ++i2) {
                menuElements.add(new TextPeaceTreaty_Scores(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)((Integer)lSortedDefenders.get((int)i2)).intValue()).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)((Integer)lSortedDefenders.get((int)i2)).intValue()).iVictoryPointsLeft, 0, tPosY, tMenuWidth - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            for (i2 = 0; i2 < lSortedAggressors.size(); ++i2) {
                menuElements.add(new TextPeaceTreaty_Scores(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)((Integer)lSortedAggressors.get((int)i2)).intValue()).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)((Integer)lSortedAggressors.get((int)i2)).intValue()).iVictoryPointsLeft, 0, tPosY, tMenuWidth - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        } else {
            for (i2 = 0; i2 < lSortedAggressors.size(); ++i2) {
                menuElements.add(new TextPeaceTreaty_Scores(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)((Integer)lSortedAggressors.get((int)i2)).intValue()).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)((Integer)lSortedAggressors.get((int)i2)).intValue()).iVictoryPointsLeft, 0, tPosY, tMenuWidth - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            for (i2 = 0; i2 < lSortedDefenders.size(); ++i2) {
                menuElements.add(new TextPeaceTreaty_Scores(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)((Integer)lSortedDefenders.get((int)i2)).intValue()).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)((Integer)lSortedDefenders.get((int)i2)).intValue()).iVictoryPointsLeft, 0, tPosY, tMenuWidth - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        int tempPosY = Math.max(Math.max(Math.max(CFG.BUTTON_H, IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() + CFG.PADD * 2), Math.max(CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2 + CFG.PADD)) + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD);
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H / 2, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 1.0f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, this.getHeightT(), false, false);
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.4f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, this.getHeightT(), false, false);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, this.getHeightT(), false, false);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY + 1 - this.getHeightT() - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, 1, false, false);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.7f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY + 1 - this.getHeightT() - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, 1, false, false);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY + 2 - this.getHeightT() - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, 1, false, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, 1, false, false);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + CFG.PADD * 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, 0, tempPosY + CFG.BUTTON_H / 2, tMenuWidth, Math.min(tElementH * 6, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE()), menuElements, true, false);
        for (i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(i % 2);
        }
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("Score"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.draw(oSB, iTranslateX, 1 + iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX + CFG.PADD, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void drawCloseButton(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.getCloseButtonImage(sliderMenuIsActive).drawO(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.btnClose).getWidth() * 3 / 5 + iTranslateX, this.getPosY() - this.getTitleM().getHeightT() - IMGManager.getIMG(Images.btnClose).getHeight() + iTranslateY, IMGManager.getIMG(Images.btnClose).getWidth() * 3 / 5, IMGManager.getIMG(Images.btnClose).getHeight() * 3 / 5);
    }

    @Override
    public void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }
}

