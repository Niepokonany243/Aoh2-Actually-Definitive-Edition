
package age.of.civilizations2.jakowski.lukasz.Button.Classic;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Classic_LRMain_TextScale_Important
extends Button_Classic_LR_Main {
    public Button_Classic_LRMain_TextScale_Important(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    public Button_Classic_LRMain_TextScale_Important(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkboxState) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, checkboxState);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            Renderer.drawText(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
        } else {
            Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
        }
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, isActive ? 0.0f : (this.getIsHovered() ? 0.3f : 0.25f)));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (this.getWidthE() - CFG.PADD * 8) / 2 - this.getTextWidthU() / 2, 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (this.getWidthE() - CFG.PADD * 8) / 2 - this.getTextWidthU() / 2, 1, false, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, isActive ? 0.0f : (this.getIsHovered() ? 0.3f : 0.2f)));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() - 1 + this.getHeightE() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (this.getWidthE() - CFG.PADD * 8) / 2 - this.getTextWidthU() / 2, 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + CFG.PADD * 2 + iTranslateX, this.getPosY() - 1 + this.getHeightE() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (this.getWidthE() - CFG.PADD * 8) / 2 - this.getTextWidthU() / 2, 1, false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + 1 + this.getHeightE() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (this.getWidthE() - CFG.PADD * 8) / 2 - this.getTextWidthU() / 2, 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + CFG.PADD * 2 + iTranslateX, this.getPosY() + 1 + this.getHeightE() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (this.getWidthE() - CFG.PADD * 8) / 2 - this.getTextWidthU() / 2, 1, false, false);
        oSB.setColor(Color.WHITE);
    }
}

