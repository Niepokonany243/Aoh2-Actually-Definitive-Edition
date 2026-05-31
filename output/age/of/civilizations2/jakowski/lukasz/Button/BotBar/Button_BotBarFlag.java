
package age.of.civilizations2.jakowski.lukasz.Button.BotBar;

import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_BotBarFlag
extends Button_BotBar {
    private int iCivID = 0;

    public Button_BotBarFlag(String sText, float FONT_SCALE, int iPosX, int iPosY, int iMinWidth, boolean isClickable, boolean isVisible) {
        super(sText, FONT_SCALE, iPosX, iPosY, iMinWidth, isClickable, isVisible);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.iCivID < 0) {
            if (this.iCivID == -1) {
                CFG.terrainTypesManager.getIcon(0).drawO(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() - CFG.terrainTypesManager.getIcon(0).getHeight() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
            } else {
                IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
            }
        } else {
            CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() - CFG.core.getCiv(this.iCivID).getFlagC().getHeight() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() - CFG.CIV_FLAG_HEIGHT + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getTextPosElem() + CFG.PADD + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColorE(isActive));
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
        try {
            this.sText = sText;
            this.setWidthE(this.iMinWidth);
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sText);
            this.iTextWidth = (int)CFG.glyphLay.width;
            this.iTextHeight = (int)CFG.glyphLay.height;
            if (super.getWidthE() < this.iTextWidth + CFG.PADD * 2 + 2 + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + CFG.PADD) {
                this.setWidthE(this.iTextWidth + CFG.PADD * 2 + 2 + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + CFG.PADD);
            }
        }
        catch (IllegalArgumentException illegalArgumentException) {
        }
        catch (Exception exception) {
            
        }
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.CIV_FLAG_HEIGHT;
    }
}

