
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Button_Stats_Image_Population
extends Button_Stats {
    private static final int NUM_OF_FLAGS = 2;
    private int iProvinceID = 0;
    private List<Integer> lSorted = new ArrayList<Integer>();

    public Button_Stats_Image_Population(String sText, float FONT_SCALE, int iPosX, int iPosY, int iMinWidth, int iHeight, boolean isClickable, boolean isVisible) {
        super(sText, FONT_SCALE, iPosX, iPosY, iMinWidth, iHeight, isClickable, isVisible);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(Images.pop).draw(oSB, this.getPosXE() + this.getTextPosElem() + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) / 2 - (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop)) / 2 + iTranslateX, this.getPosY() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getTextPosElem() + CFG.PADD + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
        try {
            if (CFG.FOG_OF_WAR == 2) {
                for (int i = 0; i < Math.min(this.lSorted.size(), 2); ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i)))) {
                        CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i))).getFlagC().drawO(oSB, this.getPosXE() + this.getTextPosElem() + CFG.PADD + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + iTranslateX + this.getTextWidthU() + CFG.PADD * (i + 1) + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) * i, this.getPosY() - CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i))).getFlagC().getHeight() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                    } else {
                        IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getTextPosElem() + CFG.PADD + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + iTranslateX + this.getTextWidthU() + CFG.PADD * (i + 1) + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) * i, this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                    }
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getTextPosElem() + CFG.PADD + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + iTranslateX + this.getTextWidthU() + CFG.PADD * (i + 1) + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) * i, this.getPosY() - CFG.CIV_FLAG_HEIGHT + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                }
            } else {
                for (int i = 0; i < Math.min(this.lSorted.size(), 2); ++i) {
                    CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i))).getFlagC().drawO(oSB, this.getPosXE() + this.getTextPosElem() + CFG.PADD + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + iTranslateX + this.getTextWidthU() + CFG.PADD * (i + 1) + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) * i, this.getPosY() - CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.lSorted.get(i))).getFlagC().getHeight() + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getTextPosElem() + CFG.PADD + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + iTranslateX + this.getTextWidthU() + CFG.PADD * (i + 1) + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) * i, this.getPosY() - CFG.CIV_FLAG_HEIGHT + this.getHeightE() / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f) + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
                }
            }
        }
        catch (Exception ex) {
            this.setCurr(this.getCurr());
        }
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        this.setWidthE(this.iMinWidth);
        try {
            CFG.glyphLay.setText(CFG.fontMain.get(0), sText);
            this.iTextWidth = (int)CFG.glyphLay.width;
            this.iTextHeight = (int)CFG.glyphLay.height;
            if (super.getWidthE() < this.iTextWidth + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale() + (float)CFG.PADD) * Math.min(this.lSorted.size(), 2)) {
                this.setWidthE(this.iTextWidth + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale() + (float)CFG.PADD) * Math.min(this.lSorted.size(), 2));
            }
        }
        catch (Exception exception) {
            
        }
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.CIV_FLAG_HEIGHT;
    }

    public final float getImageScale(int iImageID) {
        return (float)(this.getTextHeight() + 4) / (float)IMGManager.getIMG(iImageID).getHeight();
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

