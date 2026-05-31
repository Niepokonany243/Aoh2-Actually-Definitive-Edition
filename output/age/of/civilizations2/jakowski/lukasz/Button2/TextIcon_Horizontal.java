/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextIcon_Horizontal
extends ButtonM {
    public int imageID;
    public int iconWidth;
    public int iconHeight;
    public int maxIconWidth;

    public TextIcon_Horizontal(String sText, int fontID, int imageID, int iPosX, int iPosY, int nWidth, int nHeight, int maxIconWidth) {
        this.fontID = fontID;
        this.init(sText, 0, iPosX, iPosY, nWidth, nHeight, true, true, false, false);
        this.imageID = imageID;
        this.maxIconWidth = maxIconWidth;
        float iconScale = this.getImageScale(imageID) * 1.2f;
        this.iconWidth = (int)((float)IMGManager.getIMG(imageID).getWidth() * iconScale);
        this.iconHeight = (int)((float)IMGManager.getIMG(imageID).getHeight() * iconScale);
    }

    public TextIcon_Horizontal(String sText, int imageID, int iPosX, int iPosY, int nWidth, int nHeight, int maxIconWidth, boolean shortText) {
        this.init(sText, 0, iPosX, iPosY, nWidth, nHeight, true, true, false, false);
        this.imageID = imageID;
        this.maxIconWidth = maxIconWidth;
        float iconScale = this.getImageScale(imageID) * 1.2f;
        this.iconWidth = (int)((float)IMGManager.getIMG(imageID).getWidth() * iconScale);
        this.iconHeight = (int)((float)IMGManager.getIMG(imageID).getHeight() * iconScale);
        int tWMax = 0;
        while (this.iTextWidth > this.getWidthE() - maxIconWidth - CFG.PADD * 2 && this.getTextE().length() > 5 && ++tWMax < 100) {
            this.setTextE(this.getTextE().substring(0, Math.max(1, this.getTextE().length() - 3)) + ".");
        }
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, this.getIsHovered() || isActive ? 0.6f : 0.5f));
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
        oSB.setColor(Color.WHITE);
        oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, 0.3f));
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.maxIconWidth + CFG.PADD * 2, this.getHeightE(), 1.0f);
        oSB.setColor(Color.WHITE);
        oSB.setColor(TextIcon.getColor_gradientXY());
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.maxIconWidth + CFG.PADD * 2, this.getHeightE());
        oSB.setColor(TextIcon.getColor_gradientFull());
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.maxIconWidth + CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 + iTranslateY, this.maxIconWidth + CFG.PADD * 2, 1);
        oSB.setColor(Color.WHITE);
        if (this.getIsHovered() || isActive) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
            Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
            oSB.setColor(Color.WHITE);
        }
    }

    public static final float getBoxAlpha(boolean clickable, boolean isHovered, boolean isActive) {
        return clickable ? (isActive ? 0.85f : (isHovered ? 0.7f : 0.5f)) : 0.2f;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(this.imageID).draw(oSB, this.getPosXE() + CFG.PADD + this.maxIconWidth / 2 - this.iconWidth / 2 + iTranslateX, this.getPosY() + (this.getHeightE() - this.iconHeight) / 2 + iTranslateY, this.iconWidth, this.iconHeight);
        Renderer.drawText(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + CFG.PADD * 2 + this.maxIconWidth + (this.getWidthE() - (CFG.PADD * 2 + this.maxIconWidth)) / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
    }

    private final float getImageScale(int iImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(iImageID).getHeight();
    }

    @Override
    public Color getColorE(boolean isActive) {
        return Colors.getColorButtonHover(isActive, this.getIsHovered());
    }
}

