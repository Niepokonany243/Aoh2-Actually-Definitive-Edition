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

public class TextIcon_PopulationHorizontal
extends ButtonM {
    private static final int NUM_OF_FLAGS = 2;
    private int iProvinceID = 0;
    private List<Integer> lSorted = new ArrayList<Integer>();
    public int imageID;
    public int iconWidth;
    public int iconHeight;
    public int maxIconWidth;

    public TextIcon_PopulationHorizontal(String sText, int imageID, int iPosX, int iPosY, int nWidth, int nHeight, int maxIconWidth) {
        this.init(sText, 0, iPosX, iPosY, nWidth, nHeight, true, true, false, false);
        this.imageID = imageID;
        this.maxIconWidth = maxIconWidth;
        float iconScale = this.getImageScale(imageID) * 1.2f;
        this.iconWidth = (int)((float)IMGManager.getIMG(imageID).getWidth() * iconScale);
        this.iconHeight = (int)((float)IMGManager.getIMG(imageID).getHeight() * iconScale);
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
        try {
            if (CFG.FOG_OF_WAR == 2) {
                for (int i = 0; i < Math.min(this.lSorted.size(), 2); ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i)))) {
                        CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i))).getFlagC().drawO(oSB, this.getPosXE() + this.getTextPosElem() + CFG.PADD + IMGManager.getIMG(Images.economy).getWidth() + iTranslateX + this.getTextWidthU() + CFG.PADD * (i + 1) + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) * i, this.getPosY() - CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i))).getFlagC().getHeight() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                    } else {
                        IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getTextPosElem() + CFG.PADD + IMGManager.getIMG(Images.economy).getWidth() + iTranslateX + this.getTextWidthU() + CFG.PADD * (i + 1) + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) * i, this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                    }
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getTextPosElem() + CFG.PADD + IMGManager.getIMG(Images.economy).getWidth() + iTranslateX + this.getTextWidthU() + CFG.PADD * (i + 1) + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) * i, this.getPosY() - CFG.CIV_FLAG_HEIGHT + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                }
            } else {
                for (int i = 0; i < Math.min(this.lSorted.size(), 2); ++i) {
                    CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i))).getFlagC().drawO(oSB, this.getPosXE() + this.getTextPosElem() + CFG.PADD + IMGManager.getIMG(Images.economy).getWidth() + iTranslateX + this.getTextWidthU() + CFG.PADD * (i + 1) + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) * i, this.getPosY() - CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i))).getFlagC().getHeight() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getTextPosElem() + CFG.PADD + IMGManager.getIMG(Images.economy).getWidth() + iTranslateX + this.getTextWidthU() + CFG.PADD * (i + 1) + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) * i, this.getPosY() - CFG.CIV_FLAG_HEIGHT + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                }
            }
        }
        catch (Exception ex) {
            this.setCurr(this.getCurr());
        }
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.CIV_FLAG_HEIGHT;
    }

    private final float getImageScale(int iImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(iImageID).getHeight();
    }

    @Override
    public Color getColorE(boolean isActive) {
        return Colors.getColorButtonHover(isActive, this.getIsHovered());
    }

    @Override
    public void setTextE(String sText) {
        super.setTextE(sText);
        if (super.getWidthE() < this.iTextWidth + CFG.PADD * 2 + IMGManager.getIMG(Images.economy).getWidth() + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale() + (float)CFG.PADD) * Math.min(this.lSorted.size(), 2)) {
            this.setWidthE(this.iTextWidth + CFG.PADD * 2 + IMGManager.getIMG(Images.economy).getWidth() + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale() + (float)CFG.PADD) * Math.min(this.lSorted.size(), 2));
        }
    }

    @Override
    public int getCurr() {
        return this.iProvinceID;
    }

    @Override
    public void setCurr(int nCurrent) {
        this.iProvinceID = nCurrent;
        this.lSorted.clear();
        ArrayList<Integer> tempIDs = new ArrayList<Integer>();
        for (int i = 0; i < CFG.core.getProv(this.iProvinceID).getPop().getNatsSize(); ++i) {
            tempIDs.add(i);
        }
        while (tempIDs.size() > 0) {
            int tIDAdd = 0;
            for (int i = 1; i < tempIDs.size(); ++i) {
                if (CFG.core.getProv(this.iProvinceID).getPop().getPopulationID((Integer)tempIDs.get(tIDAdd)) >= CFG.core.getProv(this.iProvinceID).getPop().getPopulationID((Integer)tempIDs.get(i))) continue;
                tIDAdd = i;
            }
            this.lSorted.add((Integer)tempIDs.get(tIDAdd));
            tempIDs.remove(tIDAdd);
        }
    }
}

