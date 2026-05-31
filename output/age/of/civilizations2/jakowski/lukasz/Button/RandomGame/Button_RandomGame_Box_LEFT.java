
package age.of.civilizations2.jakowski.lukasz.Button.RandomGame;

import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;

public class Button_RandomGame_Box_LEFT
extends Button_InGameBox {
    private int iPlayerID = 0;

    public Button_RandomGame_Box_LEFT(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, boolean isClickable, int iPlayerID) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, isClickable);
        this.iPlayerID = iPlayerID;
        if (CFG.randomGameManager.getPlayer(iPlayerID).getTag() == null) {
            this.setTextE(CFG.lang.get("Player") + (CFG.randomGameManager.getPlayersSize() > 1 ? " " + (iPlayerID + 1) : ""));
        } else {
            this.setTextE(CFG.lang.getCiv(CFG.randomGameManager.getPlayer(iPlayerID).getTag()));
        }
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            IMGManager.getIMG(Images.gameBoxHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBoxHover).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - IMGManager.getIMG(Images.gameBoxHover).getHeight());
            IMGManager.getIMG(Images.gameBoxHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBoxHover).getHeight() * 2 + iTranslateY, this.getWidthE(), IMGManager.getIMG(Images.gameBoxHover).getHeight(), false, true);
        } else {
            IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBox).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - IMGManager.getIMG(Images.gameBox).getHeight());
            IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBox).getHeight() * 2 + iTranslateY, this.getWidthE(), IMGManager.getIMG(Images.gameBox).getHeight(), false, true);
        }
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.215f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 4, true, false);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        try {
            CFG.randomGameManager.getPlayer(this.iPlayerID).getFlag().drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.randomGameManager.getPlayer(this.iPlayerID).getFlag().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        catch (NullPointerException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
        Rectangle clipBounds = new Rectangle(this.getPosXE() + CFG.CIV_FLAG_WIDTH + CFG.PADD * 3 + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE() - (CFG.CIV_FLAG_WIDTH + CFG.PADD * 4), this.getHeightE());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextDefault(oSB, this.getTextE(), this.getPosXE() + CFG.CIV_FLAG_WIDTH + CFG.PADD * 3 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.8f / 2.0f) + iTranslateY, this.getColorE(isActive));
        CFG.fontMain.get(0).getData().setScale(1.0f);
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
    }
}

