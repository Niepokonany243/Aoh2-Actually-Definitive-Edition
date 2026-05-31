/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.GameN.Population;

import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ButtonN_Pop_TextRightTop
extends ButtonN_Pop {
    public String sTime;
    public int iTimeWidth;
    public int imageRight = 0;

    public ButtonN_Pop_TextRightTop(Color nColor, String sText, int nCivID, String sTextLeft, String nPop, int iImageID, Color textColor, int iPosX, int iPosY, int iWidth, String textRight, int imageRight) {
        super(nColor, sText, nCivID, sTextLeft, nPop, iImageID, textColor, iPosX, iPosY, iWidth);
        this.imageRight = imageRight;
        this.sTime = textRight;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sTime);
        this.iTimeWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
        IMGManager.getIMG(this.imageRight).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(this.imageRight).getWidth() * this.getImageScale(this.imageRight, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(this.imageRight).getHeight() * this.getImageScale(this.imageRight, 1.0f)) - CFG.PADD / 2 + iTranslateY, (int)((float)IMGManager.getIMG(this.imageRight).getWidth() * this.getImageScale(this.imageRight, 1.0f)), (int)((float)IMGManager.getIMG(this.imageRight).getHeight() * this.getImageScale(this.imageRight, 1.0f)));
        Renderer.drawTextWithShadow(oSB, this.fontID2, this.sTime, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iTimeWidth - (int)((float)IMGManager.getIMG(this.imageRight).getWidth() * this.getImageScale(this.imageRight, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL - CFG.PADD / 2 + iTranslateY, this.getColorRight());
    }

    public Color getColorRight() {
        return CFG.COLOR_TEXT_GRAY_NS_HOVER;
    }
}

