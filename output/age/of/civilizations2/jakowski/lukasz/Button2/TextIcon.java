/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextIcon
extends ButtonM {
    public int imageID;
    public int iconWidth;
    public int iconHeight;

    public TextIcon(String sText, int imageID, int nPosX, int nPosY, int nWidth, int nHeight) {
        this.init(sText, 0, nPosX, nPosY, nWidth, nHeight, true, true, false, false);
        this.imageID = imageID;
        float iconScale = this.getImageScale(imageID);
        this.iconWidth = (int)((float)IMGManager.getIMG(imageID).getWidth() * iconScale);
        this.iconHeight = (int)((float)IMGManager.getIMG(imageID).getHeight() * iconScale);
    }

    public TextIcon(String sText, int imageID, int nPosX, int nPosY, int nWidth, int nHeight, int fontID) {
        this.fontID = fontID;
        this.init(sText, 0, nPosX, nPosY, nWidth, nHeight, true, true, false, false);
        this.imageID = imageID;
        float iconScale = this.getImageScale(imageID);
        this.iconWidth = (int)((float)IMGManager.getIMG(imageID).getWidth() * iconScale);
        this.iconHeight = (int)((float)IMGManager.getIMG(imageID).getHeight() * iconScale);
    }

    public TextIcon(String sText, int imageID, int nPosX, int nPosY, int nWidth, int nHeight, int fontID, boolean dontUseIconScale) {
        this.fontID = fontID;
        this.init(sText, 0, nPosX, nPosY, nWidth, nHeight, true, true, false, false);
        this.imageID = imageID;
        float iconScale = this.getImageScale(imageID);
        this.iconWidth = IMGManager.getIMG(imageID).getWidth();
        this.iconHeight = IMGManager.getIMG(imageID).getHeight();
    }

    public static Color getColor_gradientXY() {
        return new Color(Colors.COLOR_GRADIENT_OVER_BLUE.r, Colors.COLOR_GRADIENT_OVER_BLUE.g, Colors.COLOR_GRADIENT_OVER_BLUE.b, 0.5f);
    }

    public static Color getColor_gradientFull() {
        return new Color(Colors.COLOR_GRADIENT_OVER_BLUE.r, Colors.COLOR_GRADIENT_OVER_BLUE.g, Colors.COLOR_GRADIENT_OVER_BLUE.b, 0.35f);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, this.getIsHovered() || isActive ? 0.6f : 0.5f));
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
        oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, 0.3f));
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() + iTranslateY, this.getWidthE(), this.getTextH(), 1.0f);
        oSB.setColor(Color.WHITE);
        oSB.setColor(TextIcon.getColor_gradientXY());
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() + iTranslateY, this.getWidthE(), this.getTextH());
        oSB.setColor(TextIcon.getColor_gradientFull());
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(Color.WHITE);
        if (this.getIsHovered() || isActive) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
            Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
            oSB.setColor(Color.WHITE);
        }
        IMGManager.getIMG(this.getImageID()).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - this.iconWidth / 2 + iTranslateX, this.getPosY() + (this.getHeightE() - this.getTextH()) / 2 - this.iconHeight / 2 + iTranslateY, this.iconWidth, this.iconHeight);
        Renderer.drawText(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
    }

    public int getTextH() {
        return CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2;
    }

    public int getImageID() {
        return this.imageID;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return Colors.getColorButtonHover(isActive, this.getIsHovered());
    }

    private final float getImageScale(int iImageID) {
        return Math.min(1.0f, (float)(this.getHeightE() - this.getTextH() - CFG.PADD * 2) / (float)IMGManager.getIMG(iImageID).getHeight());
    }
}

