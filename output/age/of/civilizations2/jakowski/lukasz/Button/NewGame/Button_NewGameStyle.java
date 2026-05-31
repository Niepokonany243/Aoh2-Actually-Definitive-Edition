
package age.of.civilizations2.jakowski.lukasz.Button.NewGame;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_NewGameStyle
extends ButtonM {
    public static final float BUTTON_PERC_HEIGHT = 0.75f;

    public Button_NewGameStyle(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, CFG.BUTTON_H, isClickable, true, false, false);
    }

    public Button_NewGameStyle(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false);
    }

    public Button_NewGameStyle(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, boolean isClickable, boolean checkBox) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, CFG.BUTTON_H, isClickable, true, true, checkBox);
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
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.215f));
        IMGManager.getIMG(Images.line32Off1).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 2 + iTranslateY, this.getWidthE(), this.getHeightE() - 4);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.325f));
        IMGManager.getIMG(Images.line32Off1).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.line32Off1).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            Renderer.drawText(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + (this.getTextPosElem() < 0 ? (this.getWidthE() - this.getTextWidthU()) / 2 : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        } else {
            Renderer.drawText(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + (this.getTextPosElem() < 0 ? (this.getWidthE() - this.getTextWidthU()) / 2 : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        }
    }

    @Override
    public Color getColorE(boolean isActive) {
        return CFG.getColor_CivInfo_Text(isActive, this.getIsHovered());
    }
}

