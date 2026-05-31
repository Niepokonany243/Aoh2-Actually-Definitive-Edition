/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Graph;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Graph_MovementPoints
extends Menu {
    public Menu_InGame_Graph_MovementPoints() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.initMenu(new TitleM(CFG.lang.get("Statistics"), CFG.BUTTON_H / 2, true, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_Graph_MovementPoints.this.getPosX() + iTranslateX, Menu_InGame_Graph_MovementPoints.this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_Graph_MovementPoints.this.getWidthM() - IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth(), this.getHeightT(), false, false);
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_Graph_MovementPoints.this.getPosX() + Menu_InGame_Graph_MovementPoints.this.getWidthM() - IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth() + iTranslateX, Menu_InGame_Graph_MovementPoints.this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth(), this.getHeightT(), true, false);
                oSB.setColor(new Color(0.0627451f, 0.09411765f, 0.25490198f, 0.45f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_InGame_Graph_MovementPoints.this.getPosX() + iTranslateX, Menu_InGame_Graph_MovementPoints.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightT() * 3 / 4, Menu_InGame_Graph_MovementPoints.this.getWidthM(), this.getHeightT() * 3 / 4, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_Graph_MovementPoints.this.getPosX() + 2 + iTranslateX, Menu_InGame_Graph_MovementPoints.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_Graph_MovementPoints.this.getWidthM() - 4);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_Graph_MovementPoints.this.getPosX() + iTranslateX, Menu_InGame_Graph_MovementPoints.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_Graph_MovementPoints.this.getWidthM(), 1);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.6f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.6f / 2.0f) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - (int)((float)this.getTextHeight() * 0.6f / 2.0f), Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, 150, 150, 500, 325, menuElements, true, true);
        this.updateLang();
        this.getMenuElem(0).setCheckboxSt(true);
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, -IMGManager.getIMG(Images.gameBox).getHeight() + this.getMenuPosY() + iTranslateY, this.getW() - IMGManager.getIMG(Images.gameBox).getWidth() + Core.PADDING * 2, this.getH() + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosX() + Core.PADDING + this.getW() - IMGManager.getIMG(Images.gameBox).getWidth() + iTranslateX, -IMGManager.getIMG(Images.gameBox).getHeight() + this.getMenuPosY() + iTranslateY, IMGManager.getIMG(Images.gameBox).getWidth(), this.getH() + Core.PADDING, true, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            default: 
        }
    }

    public final int getW() {
        return this.getWidthM();
    }

    public final int getH() {
        return this.getHeightM();
    }

    @Override
    public boolean setWidth(int iWidth) {
        boolean out = super.setWidth(iWidth);
        this.getMenuElem(0).setCheckboxSt(true);
        return out;
    }
}

