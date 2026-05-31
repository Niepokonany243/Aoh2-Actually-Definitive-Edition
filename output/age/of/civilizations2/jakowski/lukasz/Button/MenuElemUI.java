/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.GraphData2;
import age.of.civilizations2.jakowski.lukasz.Graphs.GraphData;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Touch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.List;

public class MenuElemUI {
    public TypeOfMenuElemUI typeOfMenuElemUI;
    public int fontID = 0;
    private int iPosX;
    private int iPosY;
    private int iWidth;
    private int iHeight;
    private boolean isClickable = true;
    private boolean isVisible = true;
    private boolean isInView = false;
    private boolean isHovered = false;
    public ME_Hover menuElemHover;

    public void buildElemHover() {
    }

    public void resetElemHover() {
        this.menuElemHover = null;
    }

    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.menuElemHover != null) {
            if (CFG.isAndroid()) {
                this.menuElemHover.drawAlwaysOverMobile(oSB, Touch.getMousePosX(), Touch.getMousePosY() - CFG.menus.getHover_ExtraPosY());
            } else {
                this.menuElemHover.draw(oSB, Touch.getMousePosX() + CFG.menus.getHover_ExtraPosX(), Touch.getMousePosY() + CFG.menus.getHover_ExtraPosY());
            }
        }
    }

    public boolean getMenuElemHover_IsNull() {
        return this.menuElemHover == null;
    }

    public void updateHover(int nPosX, int nPosY, int menuPosX, int menuPosY) {
    }

    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
    }

    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
    }

    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, int flagPixelID) {
    }

    public void setTextE(String sText) {
    }

    public void setText2(String sText) {
    }

    public boolean getCheckboxSt() {
        return false;
    }

    public void setCheckboxSt(boolean checkboxState) {
    }

    public void updateSlider(int nPosX) {
    }

    public void setCurr(long nCurrent) {
    }

    public void setCurr(int nCurrent) {
        this.setCurr((long)nCurrent);
    }

    public int getCurr() {
        return 0;
    }

    public long getCurrLong() {
        return this.getCurr();
    }

    public void setMin(long iMin) {
    }

    public void setMin(int iMin) {
        this.setMin((long)iMin);
    }

    public void setMinMarker(long iMinMarker) {
    }

    public void setMinMarker(int iMinMarker) {
        this.setMinMarker((long)iMinMarker);
    }

    public void setMax(long iMax) {
    }

    public void setMax(int iMax) {
        this.setMax((long)iMax);
    }

    public boolean isMoveable() {
        return false;
    }

    public boolean getAnotherView() {
        return false;
    }

    public void setAnotherView(boolean inAnotherView) {
    }

    public void setScrollPosY(int iScrollPosY) {
    }

    public void scrollTheMenu() {
    }

    public void srollByWheel(int nScoll) {
    }

    public boolean getIsScrollable() {
        return false;
    }

    public void addText(String sText, int extraHeight) {
    }

    public void setDataGraph(List<GraphData> nData) {
    }

    public void addDataGraph(GraphData nData) {
    }

    public void removeData(int iCivID) {
    }

    public void setData2(List<GraphData2> nData) {
    }

    public void addDataGraph2(GraphData2 nData) {
    }

    public void actionElem(int iID) {
    }

    public void actionElemPPM() {
    }

    public void actionElemSPM() {
    }

    public final TypeOfMenuElemUI getTypeOfElement() {
        return this.typeOfMenuElemUI;
    }

    public void setTypeOfButton(ButtonM.TypeOfButton typeOfButton) {
    }

    public boolean getIsClickable() {
        return this.isClickable;
    }

    public final void setClickable(boolean isClickable) {
        this.isClickable = isClickable;
    }

    public boolean getVisibleE() {
        return this.isVisible;
    }

    public void setVisibleE(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public int getPosXE() {
        return this.iPosX;
    }

    public final void setPosX(int iPosX) {
        this.iPosX = iPosX;
    }

    public int getPosY() {
        return this.iPosY;
    }

    public final void setPosY(int iPosY) {
        this.iPosY = iPosY;
    }

    public int getWidthE() {
        return this.iWidth;
    }

    public void setWidthE(int iWidth) {
        this.iWidth = iWidth;
    }

    public int getHeightE() {
        return this.iHeight;
    }

    public final void setHeightE(int iHeight) {
        this.iHeight = iHeight;
    }

    public String getTextToDrawElem() {
        return "";
    }

    public String getTextE() {
        return "";
    }

    public int getTextWidthU() {
        return 0;
    }

    public int getTextHeight() {
        return 0;
    }

    public int getTextPosElem() {
        return 0;
    }

    public final boolean getIsInView() {
        return this.isInView;
    }

    public final void setIsInView(boolean isInView) {
        this.isInView = isInView;
    }

    public final boolean getIsHovered() {
        return this.isHovered;
    }

    public void setIsHovered(boolean isHovered) {
        this.isHovered = isHovered;
    }

    public int getSFXElem() {
        return SFXManager.SFX_CLICK;
    }

    public static enum TypeOfMenuElemUI {
        BUTTON,
        BUTTON_FLAG,
        BUTTON_TRANSPARENT,
        SLIDER,
        SLIDE,
        TEXT,
        TEXT_SLIDER,
        MINIMAP,
        MINIMAPINFO,
        FLAG_PIXEL,
        SPACE,
        DIPLOMACY_INFO,
        GRAPH,
        GRAPH_VERTICAL,
        GRAPH_CIRCLE,
        TRANSPARENT;

    }
}

