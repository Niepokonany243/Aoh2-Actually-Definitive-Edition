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
import java.util.ArrayList;
import java.util.List;

public class TextIcon_Population
extends ButtonM {
    private static final int NUM_OF_FLAGS = 2;
    private int iProvinceID = 0;
    private List<Integer> lSorted = new ArrayList<Integer>();
    public int imageID;

    public TextIcon_Population(String sText, int imageID, int nPosX, int nPosY, int nWidth, int nHeight) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        this.init(sText, 0, nPosX, nPosY, nWidth, nHeight, true, true, false, false);
        this.imageID = imageID;
    }

    public static Color getColor_gradientXY() {
        return new Color(Colors.COLOR_GRADIENT_OVER_BLUE.r, Colors.COLOR_GRADIENT_OVER_BLUE.g, Colors.COLOR_GRADIENT_OVER_BLUE.b, 0.7f);
    }

    public static Color getColor_gradientFull() {
        return new Color(Colors.COLOR_GRADIENT_OVER_BLUE.r, Colors.COLOR_GRADIENT_OVER_BLUE.g, Colors.COLOR_GRADIENT_OVER_BLUE.b, 0.45f);
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
        oSB.setColor(TextIcon_Population.getColor_gradientXY());
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() + iTranslateY, this.getWidthE(), this.getTextH());
        oSB.setColor(TextIcon_Population.getColor_gradientFull());
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(Color.WHITE);
        if (this.getIsHovered() || isActive) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
            Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
            oSB.setColor(Color.WHITE);
        }
        IMGManager.getIMG(this.getImageID()).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(this.getImageID()).getWidth() / 2 + iTranslateX, this.getPosY() + (this.getHeightE() - this.getTextH()) / 2 - IMGManager.getIMG(this.getImageID()).getHeight() / 2 + iTranslateY);
        Renderer.drawText(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        try {
            if (CFG.FOG_OF_WAR == 2) {
                for (int i = 0; i < Math.min(this.lSorted.size(), 2); ++i) {
                    if (i == 0) {
                        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i)))) {
                            CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i))).getFlagC().draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() - CFG.PADD - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                        } else {
                            IMGManager.getIMG(Images.randomCivilizationFlag).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() - CFG.PADD - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                        }
                        IMGManager.getIMG(Images.flagRectSmall).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() - CFG.PADD - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                        continue;
                    }
                    if (i != 1) continue;
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i)))) {
                        CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i))).getFlagC().draw(oSB, this.getPosXE() + this.getWidthE() - (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() - CFG.PADD - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                    } else {
                        IMGManager.getIMG(Images.randomCivilizationFlag).draw(oSB, this.getPosXE() + this.getWidthE() - (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() - CFG.PADD - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                    }
                    IMGManager.getIMG(Images.flagRectSmall).draw(oSB, this.getPosXE() + this.getWidthE() - (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() - CFG.PADD - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                }
            } else {
                for (int i = 0; i < Math.min(this.lSorted.size(), 2); ++i) {
                    if (i == 0) {
                        CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i))).getFlagC().draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() - CFG.PADD - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                        IMGManager.getIMG(Images.flagRectSmall).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() - CFG.PADD - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                        continue;
                    }
                    if (i != 1) continue;
                    CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i))).getFlagC().draw(oSB, this.getPosXE() + this.getWidthE() - (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() - CFG.PADD - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                    IMGManager.getIMG(Images.flagRectSmall).draw(oSB, this.getPosXE() + this.getWidthE() - (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextH() - CFG.PADD - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                }
            }
        }
        catch (Exception ex) {
            this.setCurr(this.getCurr());
        }
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

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.CIV_FLAG_HEIGHT;
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

