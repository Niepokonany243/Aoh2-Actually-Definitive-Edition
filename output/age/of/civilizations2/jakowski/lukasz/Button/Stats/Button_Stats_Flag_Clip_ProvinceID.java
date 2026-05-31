
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Flag;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;

public class Button_Stats_Flag_Clip_ProvinceID
extends Button_Stats_Flag {
    private int iProvinceID;

    public Button_Stats_Flag_Clip_ProvinceID(int iProvinceID, String sText, int iTextPosX, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(iProvinceID, sText, iTextPosX, iPosX, iPosY, iWidth, iHeight);
        this.iProvinceID = iProvinceID;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Rectangle clipBounds = new Rectangle(this.getPosXE() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE(), this.getHeightE());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        Core.drawFlagRect(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iProvinceID >= 0 ? CFG.core.getProv(this.iProvinceID).getCivId() : -1);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.textPosition.getTextPosition() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.CIV_FLAG_HEIGHT;
    }

    @Override
    public int getCurr() {
        return this.iProvinceID;
    }
}

