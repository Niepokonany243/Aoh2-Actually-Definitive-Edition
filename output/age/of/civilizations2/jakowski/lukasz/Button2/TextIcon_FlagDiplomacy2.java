
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextIcon_FlagDiplomacy2
extends ButtonM {
    public int civID;
    public int iconWidth;
    public int iconHeight;
    public int maxIconWidth;

    public TextIcon_FlagDiplomacy2(String sText, int civID, int iPosX, int iPosY, int nWidth, int nHeight) {
        this.fontID = CFG.FONT_BOLD;
        this.init(sText, 0, iPosX, iPosY, nWidth, nHeight, true, true, false, false);
        this.civID = civID;
        this.iconWidth = IMGManager.getIMG(Images.flagDiplomacyOver).getWidth();
        this.iconHeight = IMGManager.getIMG(Images.flagDiplomacyOver).getHeight();
        this.maxIconWidth = this.iconWidth;
    }

    public static int getButtonHeight() {
        return IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() + CFG.PADD * 2;
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
        Core.drawFlagDiplomacyGovernment_Wave(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD + iTranslateY, this.civID);
    }

    private final float getImageScale(int iImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(iImageID).getHeight();
    }

    @Override
    public Color getColorE(boolean isActive) {
        return Colors.getColorButtonHover(isActive, this.getIsHovered());
    }

    @Override
    public int getCurr() {
        return this.civID;
    }

    @Override
    public void setCurr(int nCurrent) {
        this.civID = nCurrent;
    }
}

