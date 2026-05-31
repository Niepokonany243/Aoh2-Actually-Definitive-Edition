
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Stats_FlagName
extends Button_Stats {
    private int iCivID = 0;

    public Button_Stats_FlagName(String sText, float FONT_SCALE, int iPosX, int iPosY, int iMinWidth, int iHeight, boolean isClickable, boolean isVisible) {
        super(sText, FONT_SCALE, iPosX, iPosY, iMinWidth, iHeight, isClickable, isVisible);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.iCivID < 0) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() - CFG.CIV_FLAG_HEIGHT + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
        } else {
            CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() - CFG.CIV_FLAG_HEIGHT + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() - CFG.CIV_FLAG_HEIGHT + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getTextPosElem() + CFG.PADD + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
    }

    @Override
    public int getCurr() {
        return this.iCivID;
    }

    @Override
    public void setCurr(int nCurrent) {
        this.iCivID = nCurrent;
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        this.setWidthE(this.iMinWidth);
        try {
            CFG.glyphLay.setText(CFG.fontMain.get(0), sText);
            this.iTextWidth = (int)CFG.glyphLay.width;
            this.iTextHeight = (int)CFG.glyphLay.height;
            if (super.getWidthE() < this.iTextWidth + CFG.PADD * 2 + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + CFG.PADD) {
                this.setWidthE(this.iTextWidth + CFG.PADD * 2 + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + CFG.PADD);
            }
        }
        catch (Exception exception) {
            
        }
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.CIV_FLAG_HEIGHT;
    }
}

