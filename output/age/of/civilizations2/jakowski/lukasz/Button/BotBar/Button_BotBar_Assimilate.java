
package age.of.civilizations2.jakowski.lukasz.Button.BotBar;

import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_BotBar_Assimilate
extends Button_BotBar {
    public Button_BotBar_Assimilate(String sText, float FONT_SCALE, int iPosX, int iPosY, int iMinWidth, boolean isClickable, boolean isVisible) {
        super(sText, FONT_SCALE, iPosX, iPosY, iMinWidth, isClickable, isVisible);
        this.iTextPositionX = CFG.PADD * 2 + IMGManager.getIMG(Images.botLeft).getWidth() / 2;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(Images.botLeftRed).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.botLeftRed).getHeight() + iTranslateY, this.getWidthE() + IMGManager.getIMG(Images.botLeftRed).getWidth() / 2, this.getHeightE(), true, true);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(Images.diploStability).draw(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.diploStability).getHeight() * this.getImageScale(Images.diploStability))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploStability).getWidth() * this.getImageScale(Images.diploStability)), (int)((float)IMGManager.getIMG(Images.diploStability).getHeight() * this.getImageScale(Images.diploStability)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getTextPosElem() + CFG.PADD + (int)((float)IMGManager.getIMG(Images.diploStability).getWidth() * this.getImageScale(Images.diploStability)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        this.setWidthE(1);
        try {
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sText);
            this.iTextWidth = (int)CFG.glyphLay.width;
            this.iTextHeight = (int)CFG.glyphLay.height;
        }
        catch (Exception exception) {
            
        }
    }

    @Override
    public int getWidthE() {
        return this.iTextWidth + CFG.PADD * 2 + 2 + (int)((float)IMGManager.getIMG(Images.diploStability).getWidth() * this.getImageScale(Images.diploStability)) + CFG.PADD * 2 + IMGManager.getIMG(Images.botLeft).getWidth() / 2;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_HAPPINESS_MAX : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_HAPPINESS_HOVER : CFG.COLOR_TEXT_HAPPINESS_ACTIVE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }
}

