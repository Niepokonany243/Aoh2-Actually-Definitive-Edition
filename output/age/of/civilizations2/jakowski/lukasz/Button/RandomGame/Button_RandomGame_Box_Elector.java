/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.RandomGame;

import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_RandomGame_Box_Elector
extends Button_InGameBox {
    private int iCivID;

    public Button_RandomGame_Box_Elector(int nCivID, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, isClickable);
        this.iCivID = nCivID;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(Images.gameBoxLineHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight(), true, false);
        IMGManager.getIMG(Images.gameBoxLineHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight() * 2 + iTranslateY, this.getWidthE(), IMGManager.getIMG(Images.gameBoxLineHover).getHeight(), true, true);
        if (CFG.hreMgr.getHRE().getIsElector(this.iCivID) || CFG.hreMgr.getHRE().getIsEmperor(this.iCivID)) {
            if (isActive) {
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.75f);
            } else if (this.getIsHovered()) {
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.85f);
            } else {
                oSB.setColor(1.0f, 1.0f, 1.0f, 1.0f);
            }
        } else if (isActive) {
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.275f);
        } else if (this.getIsHovered()) {
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.35f);
        } else {
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.45f);
        }
        IMGManager.getIMG(Images.hreIcon).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.hreIcon).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.hreIcon).getHeight() / 2 + iTranslateY, true);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + 1 + iTranslateX, this.getPosY() + 2 + iTranslateY, 1, this.getHeightE() - 6);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }

    @Override
    public int getCurr() {
        return this.iCivID;
    }
}

