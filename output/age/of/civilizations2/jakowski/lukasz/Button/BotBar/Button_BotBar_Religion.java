
package age.of.civilizations2.jakowski.lukasz.Button.BotBar;

import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_BotBar_Religion
extends Button_BotBar {
    public int religionID = 0;

    public Button_BotBar_Religion(String sText, float FONT_SCALE, int iPosX, int iPosY, int iMinWidth, boolean isClickable, boolean isVisible) {
        super(sText, FONT_SCALE, iPosX, iPosY, iMinWidth, isClickable, isVisible);
        this.iTextPositionX = CFG.PADD * 2 + IMGManager.getIMG(Images.botLeft).getWidth() / 2;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        CFG.religionManager.religionImages.get(this.religionID).draw(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + (this.getHeightE() - (int)((float)CFG.religionManager.religionImages.get(this.religionID).getHeight() * this.getImageScale2())) / 2 + iTranslateY, (int)((float)CFG.religionManager.religionImages.get(this.religionID).getWidth() * this.getImageScale2()), (int)((float)CFG.religionManager.religionImages.get(this.religionID).getHeight() * this.getImageScale2()));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getTextPosElem() + CFG.PADD + (int)((float)CFG.religionManager.religionImages.get(this.religionID).getWidth() * this.getImageScale2()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
    }

    public final float getImageScale2() {
        return (float)(this.getTextHeight() + 4) / (float)CFG.religionManager.religionImages.get(this.religionID).getHeight();
    }

    @Override
    public int getCurr() {
        return this.religionID;
    }

    @Override
    public void setCurr(int nCurrent) {
        this.religionID = nCurrent;
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
        return this.iTextWidth + CFG.PADD * 2 + 2 + (int)((float)CFG.religionManager.religionImages.get(this.religionID).getWidth() * this.getImageScale2()) + CFG.PADD * 2 + IMGManager.getIMG(Images.botLeft).getWidth() / 2;
    }
}

