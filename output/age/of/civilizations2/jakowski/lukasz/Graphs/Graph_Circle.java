
package age.of.civilizations2.jakowski.lukasz.Graphs;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_CircleData;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;
import java.util.List;

public class Graph_Circle
extends MenuElemUI {
    public static final int ANIMATION_TIME = 300;
    private long lTime = 0L;
    private List<Graph_CircleData> lData = new ArrayList<Graph_CircleData>();
    private int iDataSize;
    public boolean isDescriptionActive = true;
    public boolean hideAnimation = false;
    private boolean moveable = false;
    private int iButtonsPosY = 0;
    private int iExtraWidth = 0;
    private static final float TEXT_SCALE = 0.7f;

    public Graph_Circle(int iPosX, int iPosY, List<Long> nValues, List<Integer> nCivIDs, ME_Hover menuElementHover) {
        int i;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(CFG.graphCircleDraw.getWidth());
        this.setHeightE(CFG.graphCircleDraw.getWidth());
        this.menuElemHover = menuElementHover;
        this.iDataSize = nValues.size();
        ArrayList<Long> tempSortedValues = new ArrayList<Long>();
        ArrayList<Integer> tempSortedCivs = new ArrayList<Integer>();
        while (!nValues.isEmpty()) {
            int nMinID = 0;
            for (i = 1; i < nValues.size(); ++i) {
                if (nValues.get(nMinID) >= nValues.get(i)) continue;
                nMinID = i;
            }
            tempSortedValues.add(nValues.get(nMinID));
            tempSortedCivs.add(nCivIDs.get(nMinID));
            nValues.remove(nMinID);
            nCivIDs.remove(nMinID);
        }
        long countValues = 0L;
        for (i = 0; i < this.iDataSize; ++i) {
            countValues += tempSortedValues.get(i);
        }
        for (i = 0; i < this.iDataSize; ++i) {
            this.lData.add(new Graph_CircleData(tempSortedCivs.get(i), (float)tempSortedValues.get(i).longValue() * 100.0f / (float)countValues));
        }
        this.updateMoveable();
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.GRAPH_CIRCLE;
        try {
            float nMaxWidth = 0.0f;
            for (int i2 = 0; i2 < this.iDataSize; ++i2) {
                CFG.glyphLay.setText(CFG.fontMain.get(0), "" + this.getPercentage(this.lData.get(i2).getPercentage(), 4) + "%");
                if (!(nMaxWidth < CFG.glyphLay.width)) continue;
                nMaxWidth = CFG.glyphLay.width;
            }
            this.iExtraWidth = (int)((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) / (float)CFG.CIV_FLAG_HEIGHT) + CFG.PADD * 4 + (int)(nMaxWidth * 0.7f);
        }
        catch (Exception ex) {
            this.iExtraWidth = super.getWidthE();
        }
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.drawGraph(oSB, iTranslateX, iTranslateY, isActive, scrollableY, this.getPosXE(), this.getPosY(), this.getWidth_PercStrings(super.getWidthE()), this.getHeight_Perc(), CFG.graphCircleDraw.getWidth());
    }

    
    public final void drawGraph(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY, int nPosX, int nPosY, int nWidth, int nHeight, int nWidth_LEFT) {
        CFG.graphCircleDraw.draw(oSB, nPosX + iTranslateX, nPosY + iTranslateY, this.lData, isActive || this.getIsHovered());
        if (this.isDescriptionActive || this.hideAnimation) {
            try {
                try {
                    Rectangle clipBounds = new Rectangle(nPosX + iTranslateX, CFG.GAMEHEIGHT - nPosY - iTranslateY - nHeight, nWidth, nHeight);
                    oSB.flush();
                    ScissorStack.pushScissors(clipBounds);
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                CFG.fontMain.get(0).getData().setScale(0.7f);
                iTranslateY += this.iButtonsPosY;
                try {
                    float tempFlagScale = (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / (float)CFG.CIV_FLAG_HEIGHT;
                    for (int i = 0; i < this.iDataSize; ++i) {
                        try {
                            oSB.setColor(new Color((float)CFG.core.getCiv(this.lData.get(i).getDataID()).getR() / 255.0f, (float)CFG.core.getCiv(this.lData.get(i).getDataID()).getG() / 255.0f, (float)CFG.core.getCiv(this.lData.get(i).getDataID()).getB() / 255.0f, 0.45f));
                            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth_LEFT + CFG.PADD + iTranslateX, -IMGManager.getIMG(Images.sliderGradient).getHeight() + nPosY + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * i + CFG.PADD * i + iTranslateY, CFG.CIV_COLOR_W + nWidth - nWidth_LEFT, (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)));
                            oSB.setColor(new Color((float)CFG.core.getCiv(this.lData.get(i).getDataID()).getR() / 255.0f, (float)CFG.core.getCiv(this.lData.get(i).getDataID()).getG() / 255.0f, (float)CFG.core.getCiv(this.lData.get(i).getDataID()).getB() / 255.0f, 0.2f));
                            IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + nWidth_LEFT + CFG.PADD + iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + nPosY + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * i + CFG.PADD * i + iTranslateY, CFG.CIV_COLOR_W + nWidth - nWidth_LEFT, (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) / 4);
                            IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + nWidth_LEFT + CFG.PADD + iTranslateX, (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) / 4 - IMGManager.getIMG(Images.gradient).getHeight() + nPosY + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * i + CFG.PADD * i + iTranslateY, CFG.CIV_COLOR_W + nWidth - nWidth_LEFT, (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) / 4, false, true);
                            oSB.setColor(Color.WHITE);
                            CFG.core.getCiv(this.lData.get(i).getDataID()).getFlagC().drawO(oSB, nPosX + nWidth_LEFT + CFG.PADD + CFG.PADD + iTranslateX, nPosY + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * i + CFG.PADD * i + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / 2.0f) - CFG.core.getCiv(this.lData.get(i).getDataID()).getFlagC().getHeight() + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * tempFlagScale), (int)((float)CFG.CIV_FLAG_HEIGHT * tempFlagScale));
                        }
                        catch (IndexOutOfBoundsException ex) {
                            oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), 0.45f));
                            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth_LEFT + CFG.PADD + iTranslateX, -IMGManager.getIMG(Images.sliderGradient).getHeight() + nPosY + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * i + CFG.PADD * i + iTranslateY, CFG.CIV_COLOR_W + nWidth - nWidth_LEFT, (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)));
                            oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), 0.2f));
                            IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + nWidth_LEFT + CFG.PADD + iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + nPosY + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * i + CFG.PADD * i + iTranslateY, CFG.CIV_COLOR_W + nWidth - nWidth_LEFT, (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) / 4);
                            IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + nWidth_LEFT + CFG.PADD + iTranslateX, (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) / 4 - IMGManager.getIMG(Images.gradient).getHeight() + nPosY + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * i + CFG.PADD * i + iTranslateY, CFG.CIV_COLOR_W + nWidth - nWidth_LEFT, (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) / 4, false, true);
                            oSB.setColor(Color.WHITE);
                            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, nPosX + nWidth_LEFT + CFG.PADD + CFG.PADD + iTranslateX, nPosY + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * i + CFG.PADD * i + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / 2.0f) - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * tempFlagScale), (int)((float)CFG.CIV_FLAG_HEIGHT * tempFlagScale));
                        }
                        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, nPosX + nWidth_LEFT + CFG.PADD + CFG.PADD + iTranslateX, nPosY + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * i + CFG.PADD * i + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / 2.0f) - CFG.CIV_FLAG_HEIGHT + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * tempFlagScale), (int)((float)CFG.CIV_FLAG_HEIGHT * tempFlagScale));
                        CFG.drawTextDefaultWithShadow(oSB, "" + this.getPercentage(this.lData.get(i).getPercentage(), 4) + "%", (int)((float)CFG.CIV_FLAG_WIDTH * tempFlagScale) + CFG.PADD + nPosX + nWidth_LEFT + CFG.PADD + CFG.PADD + iTranslateX, nPosY + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * i + CFG.PADD * i + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / 2.0f) + iTranslateY, CFG.COLOR_NEUTRAL);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            catch (Exception exr) {
                CFG.exceptionStack(exr);
            }
            finally {
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
            try {
                oSB.flush();
                ScissorStack.popScissors();
            }
            catch (IllegalStateException illegalStateException) {
                
            }
        }
    }

    private final void updateMoveable() {
        if (this.getMaxHeight() > this.getHeight_Perc()) {
            this.moveable = true;
        } else {
            this.moveable = false;
            this.iButtonsPosY = 0;
        }
    }

    public final int getMaxHeight() {
        return (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * this.iDataSize + CFG.PADD * (this.iDataSize - 1);
    }

    @Override
    public int getCurr() {
        return this.iButtonsPosY;
    }

    @Override
    public void setCurr(int nButtonsPosX) {
        if (nButtonsPosX > 0) {
            nButtonsPosX = 0;
            CFG.menus.setUpdateSliderMenuPosY(true);
        } else if (nButtonsPosX < -this.getMaxHeight() + this.getHeight_Perc()) {
            nButtonsPosX = -this.getMaxHeight() + this.getHeight_Perc();
            CFG.menus.setUpdateSliderMenuPosY(true);
        }
        if (this.iButtonsPosY != nButtonsPosX) {
            this.iButtonsPosY = nButtonsPosX;
            CFG.setRenderO(true);
        }
    }

    public int getHeight_Perc() {
        return CFG.graphCircleDraw.getWidth();
    }

    @Override
    public int getWidthE() {
        return this.getWidth_PercStrings(super.getWidthE());
    }

    public int getWidth_PercStrings(int nWidth) {
        if (this.isDescriptionActive) {
            if (this.lTime + 300L >= System.currentTimeMillis()) {
                CFG.setRenderO(true);
                return nWidth + (int)((float)this.iExtraWidth * ((float)(System.currentTimeMillis() - this.lTime) / 300.0f));
            }
            return nWidth + this.iExtraWidth;
        }
        if (this.hideAnimation) {
            if (this.lTime + 300L >= System.currentTimeMillis()) {
                CFG.setRenderO(true);
                return nWidth + this.iExtraWidth - (int)((float)this.iExtraWidth * ((float)(System.currentTimeMillis() - this.lTime) / 300.0f));
            }
            this.hideAnimation = false;
            return nWidth;
        }
        return nWidth;
    }

    @Override
    public boolean isMoveable() {
        return this.moveable;
    }

    public void setMoveable(boolean moveable) {
        this.moveable = moveable;
    }

    @Override
    public boolean getAnotherView() {
        return this.isDescriptionActive;
    }

    @Override
    public void setAnotherView(boolean inAnotherView) {
        this.isDescriptionActive = inAnotherView;
        if (this.getVisibleE()) {
            this.hideAnimation = !this.isDescriptionActive;
            this.lTime = System.currentTimeMillis();
        } else {
            this.lTime = 0L;
        }
    }

    @Override
    public void setCheckboxSt(boolean checkboxState) {
        this.lTime = 0L;
    }

    @Override
    public void setVisibleE(boolean isVisible) {
        super.setVisibleE(isVisible);
    }

    private final String getPercentage(float nPerc, int nPrecision) {
        return ("" + nPerc).substring(0, Math.min(nPrecision, ("" + nPerc).length()));
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }
}

