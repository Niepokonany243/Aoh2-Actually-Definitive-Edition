
package age.of.civilizations2.jakowski.lukasz.Button.NewGame;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_NewGameStyle_Clear
extends ButtonM {
    public Button_NewGameStyle_Clear(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, (int)((float)CFG.BUTTON_H * 0.75f), isClickable, true, false, false);
    }

    public Button_NewGameStyle_Clear(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            IMGManager.getIMG(Images.gameBoxHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBoxHover).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.gameBoxHover).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.gameBoxHover).getHeight());
            IMGManager.getIMG(Images.gameBoxHover).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.gameBoxHover).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBoxHover).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameBoxHover).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.gameBoxHover).getHeight(), true);
            IMGManager.getIMG(Images.gameBoxHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBoxHover).getHeight() * 2 + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.gameBoxHover).getWidth(), IMGManager.getIMG(Images.gameBoxHover).getHeight(), false, true);
            IMGManager.getIMG(Images.gameBoxHover).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.gameBoxHover).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBoxHover).getHeight() * 2 + iTranslateY, IMGManager.getIMG(Images.gameBoxHover).getWidth(), IMGManager.getIMG(Images.gameBoxHover).getHeight(), true, true);
        } else {
            IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBox).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.gameBox).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.gameBox).getHeight());
            IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.gameBox).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBox).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameBox).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.gameBox).getHeight(), true);
            IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBox).getHeight() * 2 + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.gameBox).getWidth(), IMGManager.getIMG(Images.gameBox).getHeight(), false, true);
            IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.gameBox).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBox).getHeight() * 2 + iTranslateY, IMGManager.getIMG(Images.gameBox).getWidth(), IMGManager.getIMG(Images.gameBox).getHeight(), true, true);
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - this.getTextWidthU() / 2 : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        } else {
            Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - this.getTextWidthU() / 2 : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        }
    }

    @Override
    public Color getColorE(boolean isActive) {
        return CFG.getColor_CivInfo_Text(isActive, this.getIsHovered());
    }
}

