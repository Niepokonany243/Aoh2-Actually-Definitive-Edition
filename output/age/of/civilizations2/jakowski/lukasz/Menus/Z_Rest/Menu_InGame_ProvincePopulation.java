/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Circle;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_ProvincePopulation
extends Menu {
    public Menu_InGame_ProvincePopulation() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        ArrayList<Long> nData = new ArrayList<Long>();
        ArrayList<Integer> nCivs = new ArrayList<Integer>();
        for (int i = 1; i < 5; ++i) {
            nData.add((long)CFG.core.getCiv(i).getNumOfProvs());
            nCivs.add(i);
        }
        menuElements.add(new Graph_Circle(CFG.PADD + 2, CFG.PADD + 2, nData, nCivs, null));
        this.initMenu(null, CFG.GAMEWIDTH - CFG.graphCircleDraw.getWidth() - 2 - CFG.PADD * 2, CFG.GAMEHEIGHT - 2 - CFG.map.getMpB().getMinimapHeight() - CFG.graphCircleDraw.getWidth() - CFG.PADD * 2, CFG.graphCircleDraw.getWidth() + CFG.PADD * 2 + 2, CFG.graphCircleDraw.getWidth() + CFG.PADD * 2 + 2, menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.bgGameAction).draw2O(oSB, this.getPosX() + iTranslateX, -IMGManager.getIMG(Images.bgGameAction).getHeight() + this.getMenuPosY() + iTranslateY, this.getWidthM(), this.getHeightM(), false, false);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            default: 
        }
    }

    @Override
    public int getPosX() {
        return CFG.GAMEWIDTH - this.getMenuElem(0).getWidthE() - CFG.PADD * 2 - 2;
    }

    @Override
    public int getMenuPosX() {
        return CFG.GAMEWIDTH - this.getMenuElem(0).getWidthE() - CFG.PADD * 2 - 2;
    }

    @Override
    public int getWidthM() {
        return this.getMenuElem(0).getWidthE() + CFG.PADD * 2 + 2;
    }
}

