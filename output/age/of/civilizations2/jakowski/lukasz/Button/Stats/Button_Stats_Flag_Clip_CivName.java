
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Flag;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;

public class Button_Stats_Flag_Clip_CivName
extends Button_Stats_Flag {
    private String sCivName;

    public Button_Stats_Flag_Clip_CivName(int iCivID, String sText, String sName, int iTextPosX, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(iCivID, sText, iTextPosX, iPosX, iPosY, iWidth, iHeight);
        this.sCivName = sName;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Rectangle clipBounds = new Rectangle(this.getPosXE() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE(), this.getHeightE());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        try {
            if (this.iCivID >= 0) {
                oSB.setColor(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 0.85f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
                oSB.setColor(Color.WHITE);
                CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, 2 + this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 - CFG.core.getCiv(this.iCivID).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, 2 + this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
            } else {
                oSB.setColor(new Color(CFG.RANDOM_CIVILIZATION_COLOR.r, CFG.RANDOM_CIVILIZATION_COLOR.g, CFG.RANDOM_CIVILIZATION_COLOR.b, 0.85f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, 2 + this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, 2 + this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
            }
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.RANDOM_CIVILIZATION_COLOR.r, CFG.RANDOM_CIVILIZATION_COLOR.g, CFG.RANDOM_CIVILIZATION_COLOR.b, 0.85f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, 2 + this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, 2 + this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale()));
        }
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.textPosition.getTextPosition() + 2 + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sCivName, this.getPosXE() + this.textPosition.getTextPosition() + this.getTextWidthU() + CFG.PADD + 2 + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.iTextHeight * 0.6f / 2.0f) + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_ACTIVE);
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
}

