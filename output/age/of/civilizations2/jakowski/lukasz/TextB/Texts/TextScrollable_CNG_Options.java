/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScrollable;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextScrollable_CNG_Options
extends TextScrollable {
    public TextScrollable_CNG_Options(String sText, int iPosX, int iPosY, int iWidth, Color textColor) {
        super(sText, iPosX, iPosY, iWidth, textColor);
    }

    public TextScrollable_CNG_Options(String sText, int iPosX, int iPosY, int iWidth, Color textColor, float nTextScale) {
        super(sText, iPosX, iPosY, iWidth, textColor, nTextScale);
    }

    public TextScrollable_CNG_Options(String sText, int iPosX, int iPosY, int iWidth, int iHeight, Color textColor, float nTextScale) {
        super(sText, iPosX, iPosY, iWidth, iHeight, textColor, nTextScale);
    }

    @Override
    public void draw_Element(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (isActive) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        } else {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.1f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() * 2 + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.45f));
        IMGManager.getIMG(Images.line32).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.line32).getHeight() * 2 + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(Color.WHITE);
        super.draw_Element(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
    }
}

