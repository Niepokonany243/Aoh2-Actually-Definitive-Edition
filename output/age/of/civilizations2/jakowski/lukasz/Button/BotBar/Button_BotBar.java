/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.BotBar;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_BotBar
extends ButtonM {
    public int iMinWidth = 0;

    public Button_BotBar(String sText, float FONT_SCALE, int iPosX, int iPosY, int iMinWidth, boolean isClickable, boolean isVisible) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, CFG.PADD, iPosX, iPosY, iMinWidth, IMGManager.getIMG(Images.botLeft).getHeight(), isClickable, isVisible, false, false, null);
        this.iMinWidth = iMinWidth;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(Images.botLeft).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.botLeft).getHeight() + iTranslateY, this.getWidthE() + IMGManager.getIMG(Images.botLeft).getWidth() / 2, this.getHeightE(), true, true);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? new Color(0.56f, 0.56f, 0.56f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? new Color(0.68f, 0.68f, 0.68f, 1.0f) : new Color(0.82f, 0.82f, 0.82f, 1.0f)) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    public final float getImageScale(int iImageID) {
        return (float)(this.getTextHeight() + 4) / (float)IMGManager.getIMG(iImageID).getHeight();
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        this.setWidthE(this.iMinWidth);
        try {
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sText);
            this.iTextWidth = (int)CFG.glyphLay.width;
            this.iTextHeight = (int)CFG.glyphLay.height;
            if (super.getWidthE() < this.iTextWidth + CFG.PADD * 2) {
                this.setWidthE(this.iTextWidth + CFG.PADD * 2);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

