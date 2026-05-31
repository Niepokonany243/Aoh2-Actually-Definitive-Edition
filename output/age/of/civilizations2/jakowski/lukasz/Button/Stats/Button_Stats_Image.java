
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Stats_Image
extends Button_Stats {
    private int iImageID = 0;

    public Button_Stats_Image(int iImageID, String sText, float FONT_SCALE, int iPosX, int iPosY, int iMinWidth, int iHeight, boolean isClickable, boolean isVisible) {
        super(sText, FONT_SCALE, iPosX, iPosY, iMinWidth, iHeight, isClickable, isVisible);
        this.iImageID = iImageID;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(this.iImageID).draw(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale()) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale()));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getTextPosElem() + CFG.PADD + (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        this.setWidthE(this.iMinWidth);
        try {
            CFG.glyphLay.setText(CFG.fontMain.get(0), sText);
            this.iTextWidth = (int)CFG.glyphLay.width;
            this.iTextHeight = (int)CFG.glyphLay.height;
            if (super.getWidthE() < this.iTextWidth + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale())) {
                this.setWidthE(this.iTextWidth + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale()));
            }
        }
        catch (Exception exception) {
            
        }
    }

    public final float getImageScale() {
        return (float)(this.getTextHeight() + 4) / (float)IMGManager.getIMG(this.iImageID).getHeight();
    }
}

