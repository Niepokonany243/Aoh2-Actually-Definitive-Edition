
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Button_DialogAgree;
import age.of.civilizations2.jakowski.lukasz.Button.Button_DialogDisagree;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScrollable;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Dialog_Diplomacy
extends Menu {
    private Color cTitleColor;
    private int iCivIDL = 0;
    private int iCivIDR = 0;

    public Menu_Dialog_Diplomacy(Color nTitleColor, int nCivIDL, int nCivIDR) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tempHeight = CFG.BUTTON_H + CFG.BUTTON_H * 3 / 4;
        this.iCivIDL = nCivIDL;
        this.iCivIDR = nCivIDR;
        this.cTitleColor = nTitleColor;
        menuElements.add(new Button_DialogAgree(null, -1, 0, tempHeight - CFG.BUTTON_H - 1, tempWidth / 2, CFG.BUTTON_H, false));
        menuElements.add(new Button_DialogDisagree(null, -1, tempWidth / 2, tempHeight - CFG.BUTTON_H - 1, tempWidth / 2, CFG.BUTTON_H, false));
        menuElements.add(new TextScrollable("Spain offers us an Alliance", 0, 0, tempWidth, CFG.BUTTON_H * 3 / 4, CFG.COLOR_TEXT_GRAY_NS, 0.8f, -1));
        this.initMenu(new TitleM("Offer Alliance", CFG.BUTTON_H * 3 / 4, true, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(Menu_Dialog_Diplomacy.this.cTitleColor);
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gradient).getHeight() + 2, nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(Color.WHITE);
                CFG.core.getCiv(Menu_Dialog_Diplomacy.this.iCivIDL).getFlagC().drawO(oSB, nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.8f / 2.0f) - CFG.PADD * 2 - CFG.CIV_FLAG_WIDTH + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.8f / 2.0f) - CFG.PADD * 2 - CFG.CIV_FLAG_WIDTH + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                CFG.core.getCiv(Menu_Dialog_Diplomacy.this.iCivIDR).getFlagC().drawO(oSB, nPosX + nWidth / 2 + (int)((float)this.getTextWidth() * 0.8f / 2.0f) + CFG.PADD * 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, nPosX + nWidth / 2 + (int)((float)this.getTextWidth() * 0.8f / 2.0f) + CFG.PADD * 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - CFG.CIV_FLAG_HEIGHT / 2);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, 1);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.8f / 2.0f) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - (int)((float)this.getTextHeight() * 0.8f / 2.0f), Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, 150, 150, tempWidth, tempHeight, menuElements, true, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Procced"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Decline"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.dialog_line).draw2O(oSB, this.getPosX() + this.getMenuElem(2).getPosXE() + iTranslateX, this.getPosY() + this.getMenuElem(2).getPosY() - IMGManager.getIMG(Images.dialog_line).getHeight() + iTranslateY, this.getMenuElem(2).getWidthE() - IMGManager.getIMG(Images.dialog_line).getWidth(), this.getMenuElem(2).getHeightE());
        IMGManager.getIMG(Images.dialog_line).draw2O(oSB, this.getPosX() + this.getMenuElem(2).getWidthE() - IMGManager.getIMG(Images.dialog_line).getWidth() + this.getMenuElem(2).getPosXE() + iTranslateX, this.getPosY() + this.getMenuElem(2).getPosY() - IMGManager.getIMG(Images.dialog_line).getHeight() + iTranslateY, IMGManager.getIMG(Images.dialog_line).getWidth(), this.getMenuElem(2).getHeightE(), true, false);
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.4f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + 2 + this.getMenuElem(2).getPosXE() + iTranslateX, this.getPosY() + this.getMenuElem(2).getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getMenuElem(2).getWidthE() - 4, this.getMenuElem(2).getHeightE());
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + 2 + this.getMenuElem(2).getPosXE() + iTranslateX, this.getPosY() + this.getMenuElem(2).getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getMenuElem(2).getWidthE() - 4, this.getMenuElem(2).getHeightE(), true, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + this.getMenuElem(2).getPosXE() + iTranslateX, this.getPosY() + this.getMenuElem(2).getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getMenuElem(2).getWidthE() - 4, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + this.getMenuElem(2).getPosXE() + iTranslateX, this.getPosY() + this.getMenuElem(2).getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getMenuElem(2).getWidthE() - 4, this.getMenuElem(2).getHeightE() * 3 / 4);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + this.getMenuElem(2).getPosXE() + iTranslateX, this.getPosY() + this.getMenuElem(2).getHeightE() - this.getMenuElem(2).getHeightE() * 3 / 4 + this.getMenuElem(2).getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getMenuElem(2).getWidthE() - 4, this.getMenuElem(2).getHeightE() * 3 / 4, false, true);
        oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + this.getMenuElem(2).getPosXE() + iTranslateX, this.getPosY() + this.getMenuElem(2).getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getMenuElem(2).getHeightE() - 2 + iTranslateY, this.getMenuElem(2).getWidthE() - 4, 1);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.35f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + this.getMenuElem(2).getWidthE() / 4 + this.getMenuElem(2).getPosXE() + iTranslateX, this.getPosY() + this.getMenuElem(2).getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getMenuElem(2).getHeightE() - 2 + iTranslateY, this.getMenuElem(2).getWidthE() - this.getMenuElem(2).getWidthE() / 2, 1);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
    }
}

