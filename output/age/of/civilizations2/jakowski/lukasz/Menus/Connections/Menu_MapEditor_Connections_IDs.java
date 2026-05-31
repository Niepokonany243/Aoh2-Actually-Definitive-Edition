/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Connections;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_Connections_IDs
extends Menu {
    public Menu_MapEditor_Connections_IDs(int nProvinceID) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempY = 0;
        if (nProvinceID >= 0) {
            int i;
            for (i = 0; i < CFG.core.getProv(nProvinceID).getNeighProvincesSize(); ++i) {
                menuElements.add(new Button_Game("" + CFG.core.getProv(nProvinceID).getNeighProvinces(i), -1, CFG.PADD, CFG.PADD * (tempY + 1) + CFG.BUTTON_H * tempY, CFG.BUTTON_W));
                ++tempY;
            }
            for (i = 0; i < CFG.core.getProv(nProvinceID).getNeighSeaProvincesSize(); ++i) {
                menuElements.add(new Button_Game("" + CFG.core.getProv(nProvinceID).getNeighSeaProvinces(i), -1, CFG.PADD, CFG.PADD * (tempY + 1) + CFG.BUTTON_H * tempY, CFG.BUTTON_W));
                ++tempY;
            }
        }
        this.initMenu(new TitleM("ACT: " + nProvinceID, CFG.BUTTON_H * 3 / 4, menuElements.size() > 0, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX - 2 + iTranslateX, nPosY - IMGManager.getIMG(Images.gameTopEdge).getHeight() - this.getHeightT(), Menu_MapEditor_Connections_IDs.this.getWidthM() + 2, this.getHeightT());
                oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
                IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX - 1 + iTranslateX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), Menu_MapEditor_Connections_IDs.this.getWidthM() + 1, 1);
                oSB.setColor(Color.WHITE);
                super.drawText(oSB, iTranslateX, nPosX, nPosY, nWidth, sliderMenuIsActive);
            }
        }, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD * 2, CFG.BUTTON_H * 3 / 4, CFG.BUTTON_W + CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (this.getMenuElemsSize() > 0) {
            IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBox).getHeight(), this.getWidthM() + 2, this.getMenuElem(this.getMenuElemsSize() - 1).getPosY() + this.getMenuElem(this.getMenuElemsSize() - 1).getHeightE() + CFG.PADD, false, true);
        }
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        try {
            CFG.core.setActiveProvID(Integer.parseInt(this.getMenuElem(iID).getTextE()));
            CFG.map.getMpC().centerToProvID(Integer.parseInt(this.getMenuElem(iID).getTextE()));
            CFG.toastM.addM(" --" + CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 + " - " + CFG.core.getActiveProvID() + "-- ");
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
    }
}

