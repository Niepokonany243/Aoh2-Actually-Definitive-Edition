
package age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Response;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextPeaceTreaty_Result;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_PeaceTreaty_Response_Civs
extends Menu {
    public final float FONT_SCALE = 0.8f;

    public Menu_PeaceTreaty_Response_Civs() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tMenuWidth = CFG.CIV_INFO_MENU_WIDTH * 2 / 5;
        int tElementH = Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4);
        int tPosY = 0;
        for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.size(); ++i) {
            menuElements.add(new TextPeaceTreaty_Result(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get((int)i).peaceTreatyAccepted, 0, tPosY, tMenuWidth - 2));
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.size(); ++i) {
            menuElements.add(new TextPeaceTreaty_Result(CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).iCivID, CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get((int)i).peaceTreatyAccepted, 0, tPosY, tMenuWidth - 2));
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        int tempPosY = Math.max(Math.max(CFG.BUTTON_H * 4 / 5, Math.max(CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2 + CFG.PADD)) + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD);
        this.initMenu(new TitleM(null, CFG.BUTTON_H / 2, false, false){

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
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.8f) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (int)((float)this.getHeightT() - (float)this.getTextHeight() * 0.8f) / 2, Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, 0, tempPosY + CFG.BUTTON_H / 2, tMenuWidth, Math.min(tElementH * 6, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE()), menuElements, true, false);
        for (int i2 = 0; i2 < this.getMenuElemsSize(); ++i2) {
            this.getMenuElem(i2).setCurr(i2 % 2);
        }
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("Civilizations"));
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

