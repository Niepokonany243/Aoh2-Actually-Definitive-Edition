
package age.of.civilizations2.jakowski.lukasz.Button.BotBar;

import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_BotBar_Cores
extends Button_BotBar {
    private int iProvinceID = 0;

    public Button_BotBar_Cores(String sText, float FONT_SCALE, int iPosX, int iPosY, int iMinWidth, boolean isClickable, boolean isVisible) {
        super(sText, FONT_SCALE, iPosX, iPosY, iMinWidth, isClickable, isVisible);
        this.iTextPositionX = CFG.PADD * 2 + IMGManager.getIMG(Images.botLeft).getWidth() / 2;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (CFG.core.getProv(this.iProvinceID).getCores().getCivsSize() == 0) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getTextPosElem() + this.getTextWidthU() + CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getTextPosElem() + this.getTextWidthU() + CFG.PADD + iTranslateX, this.getPosY() - CFG.CIV_FLAG_HEIGHT + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
        } else {
            for (int i = 0; i < Math.min(3, CFG.core.getProv(this.iProvinceID).getCores().getCivsSize()); ++i) {
                CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCores().getCivID(i)).getFlagC().drawO(oSB, this.getPosXE() + this.getTextPosElem() + this.getTextWidthU() + CFG.PADD + ((int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + CFG.PADD) * i + iTranslateX, this.getPosY() - CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCores().getCivID(i)).getFlagC().getHeight() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getTextPosElem() + this.getTextWidthU() + CFG.PADD + ((int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + CFG.PADD) * i + iTranslateX, this.getPosY() - CFG.CIV_FLAG_HEIGHT + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
            }
        }
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
    }

    @Override
    public int getCurr() {
        return this.iProvinceID;
    }

    @Override
    public void setCurr(int iProvinceID) {
        this.iProvinceID = iProvinceID;
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        this.setWidthE(this.iMinWidth);
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
        return this.iTextWidth + CFG.PADD * 2 + 2 + ((int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + CFG.PADD) * (CFG.core.getProv(this.iProvinceID).getCores().getCivsSize() > 1 ? Math.min(3, CFG.core.getProv(this.iProvinceID).getCores().getCivsSize()) : 1) + CFG.PADD + IMGManager.getIMG(Images.botLeft).getWidth() / 2;
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.CIV_FLAG_HEIGHT;
    }
}

