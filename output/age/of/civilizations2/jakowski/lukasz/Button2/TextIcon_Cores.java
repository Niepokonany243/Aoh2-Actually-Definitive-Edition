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
import java.util.ArrayList;
import java.util.List;

public class TextIcon_Cores
extends ButtonM {
    public List<Integer> lCivID = new ArrayList<Integer>();
    public int iCivsSize = 0;
    public int flagWidth;
    public int flagHeight;
    public int provinceID;
    public int imageID;
    public int iconWidth;
    public int iconHeight;

    public TextIcon_Cores(String sText, List<Integer> tCivs, int nPosX, int nPosY, int nWidth, int nHeight) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        this.init(sText, 0, nPosX, nPosY, nWidth, nHeight, true, true, false, false);
        this.lCivID = tCivs;
        this.iCivsSize = this.lCivID.size();
        float iconScale = this.getImageScale() * 1.2f;
        this.flagWidth = (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * iconScale);
        this.flagHeight = (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * iconScale);
        this.imageID = Images.core;
        iconScale = this.getImageScale(this.imageID) * 1.0f;
        this.iconWidth = (int)((float)IMGManager.getIMG(this.imageID).getWidth() * iconScale);
        this.iconHeight = (int)((float)IMGManager.getIMG(this.imageID).getHeight() * iconScale);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, 0.5f));
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
        oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, 0.3f));
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.iconWidth + CFG.PADD * 2, this.getHeightE(), 1.0f);
        oSB.setColor(Color.WHITE);
        oSB.setColor(TextIcon.getColor_gradientXY());
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.iconWidth + CFG.PADD * 2, this.getHeightE());
        oSB.setColor(TextIcon.getColor_gradientFull());
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.iconWidth + CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 + iTranslateY, this.iconWidth + CFG.PADD * 2, 1);
        oSB.setColor(Color.WHITE);
        if (this.getIsHovered() || isActive) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
            Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
            oSB.setColor(Color.WHITE);
        }
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(this.imageID).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iconHeight / 2 + iTranslateY, this.iconWidth, this.iconHeight);
        try {
            for (int i = 0; i < this.iCivsSize && (this.flagWidth + CFG.PADD) * i + CFG.PADD * 2 + this.iconWidth + this.flagWidth <= this.getWidthE(); ++i) {
                try {
                    if (this.lCivID.get(i) >= 0) {
                        CFG.core.getCiv(this.lCivID.get(i)).getFlagC().draw(oSB, this.getPosXE() + (this.flagWidth + CFG.PADD) * i + CFG.PADD * 2 + this.iconWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, this.flagWidth, this.flagHeight);
                    } else {
                        IMGManager.getIMG(Images.randomCivilizationFlag).draw(oSB, this.getPosXE() + (this.flagWidth + CFG.PADD) * i + CFG.PADD * 2 + this.iconWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, this.flagWidth, this.flagHeight);
                    }
                }
                catch (IndexOutOfBoundsException e) {
                    IMGManager.getIMG(Images.randomCivilizationFlag).draw(oSB, this.getPosXE() + (this.flagWidth + CFG.PADD) * i + CFG.PADD * 2 + this.iconWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, this.flagWidth, this.flagHeight);
                }
                IMGManager.getIMG(Images.flagRectSmall).draw(oSB, this.getPosXE() + (this.flagWidth + CFG.PADD) * i + CFG.PADD * 2 + this.iconWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, this.flagWidth, this.flagHeight);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public Color getColorE(boolean isActive) {
        return Colors.getColorButtonHover(isActive, this.getIsHovered());
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(Images.flagRectSmall).getHeight();
    }

    private final float getImageScale(int iImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(iImageID).getHeight();
    }

    @Override
    public void setCurr(int nCurrent) {
        this.provinceID = nCurrent;
        this.lCivID.clear();
        this.iCivsSize = 0;
        if (this.provinceID < 0) {
            return;
        }
        try {
            for (int i = 0; i < CFG.core.getProv(this.provinceID).getCores().getCivsSize(); ++i) {
                this.lCivID.add(CFG.core.getProv(this.provinceID).getCores().getCivID(i));
            }
            this.iCivsSize = this.lCivID.size();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

