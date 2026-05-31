
package age.of.civilizations2.jakowski.lukasz.Button.NewGame;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_NewGameStyle_Middle
extends ButtonM {
    public Button_NewGameStyle_Middle(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, (int)((float)CFG.BUTTON_H * 0.75f), isClickable, true, false, false);
    }

    public Button_NewGameStyle_Middle(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            IMGManager.getIMG(Images.gameBoxLineHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.gameBoxLineHover).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight());
            IMGManager.getIMG(Images.gameBoxLineHover).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.gameBoxLineHover).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameBoxLineHover).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight(), true);
            IMGManager.getIMG(Images.gameBoxLineHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight() * 2 + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.gameBoxLineHover).getWidth(), IMGManager.getIMG(Images.gameBoxLineHover).getHeight(), false, true);
            IMGManager.getIMG(Images.gameBoxLineHover).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.gameBoxLineHover).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight() * 2 + iTranslateY, IMGManager.getIMG(Images.gameBoxLineHover).getWidth(), IMGManager.getIMG(Images.gameBoxLineHover).getHeight(), true, true);
        } else {
            IMGManager.getIMG(Images.gameBoxLine).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBoxLine).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.gameBoxLine).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.gameBoxLine).getHeight());
            IMGManager.getIMG(Images.gameBoxLine).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.gameBoxLine).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBoxLine).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameBoxLine).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.gameBoxLine).getHeight(), true);
            IMGManager.getIMG(Images.gameBoxLine).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBoxLine).getHeight() * 2 + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.gameBoxLine).getWidth(), IMGManager.getIMG(Images.gameBoxLine).getHeight(), false, true);
            IMGManager.getIMG(Images.gameBoxLine).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.gameBoxLine).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBoxLine).getHeight() * 2 + iTranslateY, IMGManager.getIMG(Images.gameBoxLine).getWidth(), IMGManager.getIMG(Images.gameBoxLine).getHeight(), true, true);
        }
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.215f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 4);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.325f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
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

