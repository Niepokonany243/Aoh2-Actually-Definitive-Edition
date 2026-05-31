/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ShowProvinces;

import age.of.civilizations2.jakowski.lukasz.Button.Button_ShowProvincesList;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_ShowProvinces_List
extends Menu {
    public Menu_InGame_ShowProvinces_List() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tMenuWidth = CFG.CIV_INFO_MENU_WIDTH * 3 / 4;
        int tElementH = Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2);
        int tPosY = 0;
        for (i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
            menuElements.add(new Button_ShowProvincesList(CFG.core.getProvSelected().getProv(i), 0, tPosY, tMenuWidth, tElementH, true));
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H / 2, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                oSB.setColor(CFG.COLOR_GRADIENT_DARK_BLUE);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, this.getHeightT(), true, false);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2 + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, this.getHeightT(), true, false);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY + 2 - this.getHeightT() - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, 1, true, false);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH - tMenuWidth, Math.max(CFG.BUTTON_H * 4 / 5, Math.max(CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2 + CFG.PADD)) + CFG.PADD * 2 + CFG.BUTTON_H / 2, tMenuWidth, Math.min(CFG.GAMEHEIGHT - (Math.max(CFG.BUTTON_H * 4 / 5, Math.max(CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2 + CFG.PADD)) + CFG.PADD * 2 + CFG.BUTTON_H / 2), ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD), menuElements, true, false);
        for (i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(i % 2);
        }
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("Provinces"));
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void actionEL(int iID) {
        try {
            CFG.core.setActiveProvID(this.getMenuElem(iID).getCurr());
            CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
            if (this.getMenuElem(iID).getTextE().length() > 0) {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_HOVER_TITLE);
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            // empty catch block
        }
    }
}

