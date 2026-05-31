/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Graphs;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Graphs.GraphData;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;
import java.util.List;

public class Graph
extends MenuElemUI {
    public static final Color GRAPH_BG_COLOR = new Color(0.04f, 0.02f, 0.03f, 0.4f);
    public static final Color GRAPH_BORDERS_COLOR = new Color(0.95f, 0.95f, 0.95f, 0.75f);
    public static final Color GRAPH_LINES_COLOR = new Color(0.9f, 0.9f, 0.9f, 0.125f);
    public static final Color GRAPH_LINES_DESC = new Color(0.9f, 0.9f, 0.9f, 0.1f);
    public static final Color TEXT_COLOR = new Color(0.9f, 0.9f, 0.9f, 1.0f);
    public static final Color DATA_COLOR = new Color(0.8f, 0.8f, 0.8f, 1.0f);
    public static float POINTS_TEXT_SCALE = 0.65f;
    public List<GraphData> lData;
    private int iDataSize;
    private List<Integer> lSortedData;
    private List<Integer> lPointsPosX;
    private int iPointsPosXSize;
    private int iMaxSize = 0;
    private int iFixPosY;
    private int iHoveredID = -1;
    private int iZeroPosY;
    private long iMinPoint;
    private int iMinTextWidth;
    private int iWorstCivID;
    private long iMaxPoint;
    private int iMaxTextWidth;
    private int iBestCivID;
    private float fAvaragePoint;
    private int iAvaragePosY;
    private byte bDecimal = 0;
    private boolean lessThanTen = false;
    private int iDescOfTurnID = 0;
    private int iWorstDescDataID;
    private int iWorstDescDataTextWidth;
    private int iBestDescDataID;
    private int iBestDescDataTextWidth;
    private String sTextX;
    private String sTextX2;
    private String sTextY;
    private int iWidthTextX;
    private int iWidthTextX2;
    private int iWidthTextY;
    private static final int ANIMATION_TIME = 950;
    private long lTime = 0L;
    private static final int AUTO_MOVE_TURN_TIME = 1450;
    private long lAuto_Move_Turn_Time = 0L;
    private boolean moveable = false;
    private int iButtonsPosY = 0;
    private int iActiveButtonID = -1;

    public static final int getGraphButtonWidth() {
        return CFG.BUTTON_W / 2;
    }

    public static final int getGraphButtonHeight() {
        return CFG.BUTTON_H / 2;
    }

    public Graph(String sTextX, String sTextY, int iPosX, int iPosY, int iWidth, int iHeight, boolean visible, List<Integer> nCivs, int nLoadSize) {
        int i;
        this.sTextX = sTextX;
        this.sTextY = sTextY;
        CFG.fontMain.get(0).getData().setScale(0.7f);
        CFG.glyphLay.setText(CFG.fontMain.get(0), sTextX);
        this.iWidthTextX = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(0), sTextY);
        this.iWidthTextY = (int)CFG.glyphLay.width;
        CFG.fontMain.get(0).getData().setScale(1.0f);
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.setHeightE(iHeight);
        this.setVisibleE(visible);
        this.lData = new ArrayList<GraphData>();
        this.lSortedData = new ArrayList<Integer>();
        this.lPointsPosX = new ArrayList<Integer>();
        this.iFixPosY = 0;
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.GRAPH;
        for (i = 0; i < nCivs.size(); ++i) {
            this.addDataGraph(new GraphData(nCivs.get(i), new ArrayList<Long>(), 0));
        }
        for (i = 0; i < nLoadSize && i < this.lData.size(); ++i) {
            this.loadData(i);
        }
        this.iDataSize = this.lData.size();
    }

    @Override
    public void updateHover(int nPosX, int nPosY, int menuPosX, int menuPosY) {
        for (int i = 0; i < this.iDataSize; ++i) {
            if (this.getPosXE() + this.getWidthE() - Graph.getGraphButtonWidth() + menuPosX > nPosX || this.getPosXE() + this.getWidthE() + menuPosX < nPosX || this.getButtonsPosY(i) + this.iButtonsPosY + menuPosY > nPosY || this.getButtonsPosY(i) + Graph.getGraphButtonHeight() + this.iButtonsPosY + menuPosY < nPosY) continue;
            this.setHoveredID(this.lSortedData.get(i));
            return;
        }
        this.setHoveredID(-1);
    }

    private final void setHoveredID(int nHoveredID) {
        if (this.iHoveredID != nHoveredID) {
            this.iHoveredID = nHoveredID;
            this.buildElemHover();
        }
    }

    @Override
    public void buildElemHover() {
        if (this.iHoveredID >= 0) {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            if (this.lData.get(this.iHoveredID).getCivID() < 0) {
                nData.add(new ME_Hover_2Type_Image_Big(Images.randomCivilizationFlag));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            } else {
                nData.add(new ME_Hover_2Type_Flag_Big(this.lData.get(this.iHoveredID).getCivID()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lData.get(this.iHoveredID).getCivID()).getCivName(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            this.menuElemHover = new ME_Hover_v2(nElements);
        } else {
            ME_Hover_v2.resetAnimation_2();
            this.menuElemHover = null;
        }
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        block62: {
            if (this.lAuto_Move_Turn_Time + 1450L < System.currentTimeMillis()) {
                this.incrementTurnDescInfo();
            }
            oSB.setColor(GRAPH_BG_COLOR);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + iTranslateX, this.getPosY() + iTranslateY, this.getGraphWidth() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2, this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2);
            CFG.fontMain.get(0).getData().setScale(0.7f);
            try {
                CFG.drawTextRotated(oSB, this.sTextY, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.iWidthTextY / 2 + iTranslateY, TEXT_COLOR, 90.0f);
                CFG.drawTextDefault(oSB, this.sTextX, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + (this.getGraphWidth() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) / 2 - (int)((float)(this.iWidthTextX + this.iWidthTextX2) * 0.7f / 2.0f) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + iTranslateY, TEXT_COLOR);
                CFG.drawTextDefault(oSB, this.sTextX2, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + (this.getGraphWidth() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) / 2 - (int)((float)(this.iWidthTextX + this.iWidthTextX2) * 0.7f / 2.0f) + (int)((float)this.iWidthTextX * 0.7f) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            CFG.fontMain.get(0).getData().setScale(1.0f);
            oSB.setColor(GRAPH_LINES_DESC);
            IMGManager.getIMG(Images.line33).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + iTranslateX, this.getPosY() - this.iFixPosY + this.iAvaragePosY + iTranslateY, this.getGraphWidth() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2);
            oSB.setColor(GRAPH_LINES_COLOR);
            try {
                IMGManager.getIMG(Images.line44).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + 1 + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f) + iTranslateY, this.getGraphWidth() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2 - 1);
                IMGManager.getIMG(Images.line44).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + 1 + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f) + iTranslateY, this.getGraphWidth() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2 - 1);
                oSB.setColor(GRAPH_LINES_DESC);
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + this.lPointsPosX.get(this.iDescOfTurnID) + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f) + iTranslateY, 1, -((int)((float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f)));
            }
            catch (ArithmeticException ex) {
                // empty catch block
            }
            if (this.getMinPoint() < 0L && this.iMaxPoint > 0L) {
                oSB.setColor(GRAPH_LINES_COLOR);
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + 1 + iTranslateX, this.getPosY() - this.iFixPosY + this.iZeroPosY + iTranslateY, this.getGraphWidth() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2 - 1);
                oSB.setColor(GRAPH_BORDERS_COLOR);
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + 1 + iTranslateX, this.getPosY() - 1 - this.iFixPosY + this.iZeroPosY + iTranslateY, CFG.PADD - 1);
                CFG.fontMain.get(0).getData().setScale(POINTS_TEXT_SCALE);
                try {
                    CFG.drawTextDefault(oSB, "0", this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) + iTranslateX, this.getPosY() - (int)(2.0f * CFG.GUI_SCALE) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) - this.iFixPosY + this.iZeroPosY - 1 + iTranslateY, DATA_COLOR);
                }
                catch (Exception ex) {
                    // empty catch block
                }
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
            if (this.lTime + 950L > System.currentTimeMillis()) {
                Rectangle clipBounds = new Rectangle(this.getPosXE() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), (int)((float)this.getGraphWidth() * ((float)(System.currentTimeMillis() - this.lTime) / 950.0f)), this.getHeightE());
                oSB.flush();
                ScissorStack.pushScissors(clipBounds);
                this.drawGraphData(oSB, iTranslateX, iTranslateY);
                CFG.setRenderO(true);
                try {
                    oSB.flush();
                    ScissorStack.popScissors();
                }
                catch (IllegalStateException illegalStateException) {}
            } else {
                this.drawGraphData(oSB, iTranslateX, iTranslateY);
            }
            try {
                for (int i = 0; i < this.iDataSize; ++i) {
                    if (!this.lData.get(i).getDrawData() || this.iDescOfTurnID < this.lData.get(i).getBeginTurnID() || this.iDescOfTurnID >= this.lData.get(i).getBeginTurnID() + this.lData.get(i).getPointsSize()) continue;
                    try {
                        oSB.setColor(new Color((float)CFG.core.getCiv(this.lData.get(i).getCivID()).getR() / 255.0f, (float)CFG.core.getCiv(this.lData.get(i).getCivID()).getG() / 255.0f, (float)CFG.core.getCiv(this.lData.get(i).getCivID()).getB() / 255.0f, 0.75f));
                    }
                    catch (IndexOutOfBoundsException ex) {
                        oSB.setColor(new Color(0.05882353f, 0.05882353f, 0.05882353f, 0.75f));
                    }
                    IMGManager.getIMG(Images.circle55).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + this.lPointsPosX.get(this.iDescOfTurnID) - IMGManager.getIMG(Images.circle55).getWidth() / 2 + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(i).getPointY(this.iDescOfTurnID - this.lData.get(i).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)(IMGManager.getIMG(Images.circle55).getHeight() / 2)) + iTranslateY);
                }
            }
            catch (ArithmeticException i) {
                // empty catch block
            }
            oSB.setColor(GRAPH_BORDERS_COLOR);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + iTranslateX, this.getPosY() + 1 + iTranslateY, CFG.PADD - 1);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + iTranslateX, this.getPosY() - 1 - this.iFixPosY + this.iAvaragePosY + iTranslateY, CFG.PADD - 1);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getGraphWidth() - 1 + iTranslateX, this.getPosY() + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - CFG.PADD + 1 + iTranslateY, 1, CFG.PADD - 1);
            CFG.fontMain.get(0).getData().setScale(POINTS_TEXT_SCALE);
            try {
                CFG.drawTextDefault(oSB, "" + this.getMinPoint(), this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) + iTranslateX, this.getPosY() + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - (int)(2.0f * CFG.GUI_SCALE) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) + iTranslateY, DATA_COLOR);
                CFG.drawTextDefault(oSB, "" + this.iMaxPoint, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) + iTranslateX, this.getPosY() + 1 + (int)(2.0f * CFG.GUI_SCALE) + iTranslateY, DATA_COLOR);
                CFG.drawTextDefault(oSB, this.bDecimal == 0 ? "" + (int)this.fAvaragePoint : "" + (int)this.fAvaragePoint + "." + (this.lessThanTen ? "0" + this.bDecimal : Byte.valueOf(this.bDecimal)), this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) + iTranslateX, this.getPosY() - (int)(2.0f * CFG.GUI_SCALE) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) - this.iFixPosY + this.iAvaragePosY - 1 + iTranslateY, DATA_COLOR);
            }
            catch (Exception i) {
                // empty catch block
            }
            oSB.setColor(Color.WHITE);
            try {
                if ((float)(-this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f < (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) + CFG.PADD * 2)) {
                    CFG.drawTextDefault(oSB, "" + this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID()), this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) - this.iBestDescDataTextWidth + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)((int)(2.0f * CFG.GUI_SCALE))) + iTranslateY, DATA_COLOR);
                    if ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) < CFG.CIV_FLAG_HEIGHT) {
                        try {
                            CFG.core.getCiv(this.lData.get(this.iBestDescDataID).getCivID()).getFlagC().drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iBestDescDataTextWidth - (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)) + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)CFG.core.getCiv(this.lData.get(this.iBestDescDataID).getCivID()).getFlagC().getHeight()) + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
                        }
                        catch (IndexOutOfBoundsException ex) {
                            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iBestDescDataTextWidth - (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)) + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)IMGManager.getIMG(Images.randomCivilizationFlag).getHeight()) + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
                        }
                        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iBestDescDataTextWidth - (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)) + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)CFG.CIV_FLAG_HEIGHT) + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
                    } else {
                        try {
                            CFG.core.getCiv(this.lData.get(this.iBestDescDataID).getCivID()).getFlagC().drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iBestDescDataTextWidth - CFG.CIV_FLAG_WIDTH + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)((int)(2.0f * CFG.GUI_SCALE)) + (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2) - (float)(CFG.CIV_FLAG_HEIGHT / 2)) + iTranslateY);
                        }
                        catch (IndexOutOfBoundsException ex) {
                            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iBestDescDataTextWidth - CFG.CIV_FLAG_WIDTH + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)((int)(2.0f * CFG.GUI_SCALE)) + (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2) - (float)(CFG.CIV_FLAG_HEIGHT / 2)) + iTranslateY);
                        }
                        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iBestDescDataTextWidth - CFG.CIV_FLAG_WIDTH + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)((int)(2.0f * CFG.GUI_SCALE)) + (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2) - (float)(CFG.CIV_FLAG_HEIGHT / 2)) + iTranslateY);
                    }
                } else {
                    CFG.drawTextDefault(oSB, "" + this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID()), this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) - this.iBestDescDataTextWidth + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE))) + iTranslateY, DATA_COLOR);
                    if ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) < CFG.CIV_FLAG_HEIGHT) {
                        try {
                            CFG.core.getCiv(this.lData.get(this.iBestDescDataID).getCivID()).getFlagC().drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iBestDescDataTextWidth - (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)) + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE)) - (float)CFG.core.getCiv(this.lData.get(this.iBestDescDataID).getCivID()).getFlagC().getHeight()) + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
                        }
                        catch (IndexOutOfBoundsException ex) {
                            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iBestDescDataTextWidth - (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)) + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE)) - (float)IMGManager.getIMG(Images.randomCivilizationFlag).getHeight()) + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
                        }
                        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iBestDescDataTextWidth - (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)) + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE)) - (float)CFG.CIV_FLAG_HEIGHT) + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
                    } else {
                        try {
                            CFG.core.getCiv(this.lData.get(this.iBestDescDataID).getCivID()).getFlagC().drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iBestDescDataTextWidth - CFG.CIV_FLAG_WIDTH + iTranslateX, (int)((float)(this.getPosY() - CFG.core.getCiv(this.lData.get(this.iBestDescDataID).getCivID()).getFlagC().getHeight() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2) - (float)(CFG.CIV_FLAG_HEIGHT / 2)) + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                        }
                        catch (IndexOutOfBoundsException ex) {
                            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iBestDescDataTextWidth - CFG.CIV_FLAG_WIDTH + iTranslateX, (int)((float)(this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2) - (float)(CFG.CIV_FLAG_HEIGHT / 2)) + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                        }
                        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iBestDescDataTextWidth - CFG.CIV_FLAG_WIDTH + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2) - (float)(CFG.CIV_FLAG_HEIGHT / 2)) + iTranslateY);
                    }
                }
                if ((float)(-this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f > (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) - CFG.PADD * 2)) {
                    CFG.drawTextDefault(oSB, "" + this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID()), this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) - this.iWorstDescDataTextWidth + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE))) + iTranslateY, DATA_COLOR);
                    if ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) < CFG.CIV_FLAG_HEIGHT) {
                        try {
                            CFG.core.getCiv(this.lData.get(this.iWorstDescDataID).getCivID()).getFlagC().drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iWorstDescDataTextWidth - (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)) + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE)) - (float)CFG.core.getCiv(this.lData.get(this.iWorstDescDataID).getCivID()).getFlagC().getHeight()) + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
                        }
                        catch (IndexOutOfBoundsException ex) {
                            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iWorstDescDataTextWidth - (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)) + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE)) - (float)IMGManager.getIMG(Images.randomCivilizationFlag).getHeight()) + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
                        }
                        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iWorstDescDataTextWidth - (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)) + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE)) - (float)CFG.CIV_FLAG_HEIGHT) + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
                        break block62;
                    }
                    try {
                        CFG.core.getCiv(this.lData.get(this.iWorstDescDataID).getCivID()).getFlagC().drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iWorstDescDataTextWidth - CFG.CIV_FLAG_WIDTH + iTranslateX, (int)((float)(this.getPosY() - CFG.core.getCiv(this.lData.get(this.iWorstDescDataID).getCivID()).getFlagC().getHeight() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2) - (float)(CFG.CIV_FLAG_HEIGHT / 2)) + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                    }
                    catch (IndexOutOfBoundsException ex) {
                        IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iWorstDescDataTextWidth - CFG.CIV_FLAG_WIDTH + iTranslateX, (int)((float)(this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2) - (float)(CFG.CIV_FLAG_HEIGHT / 2)) + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                    }
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iWorstDescDataTextWidth - CFG.CIV_FLAG_WIDTH + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2) - (float)(CFG.CIV_FLAG_HEIGHT / 2)) + iTranslateY);
                    break block62;
                }
                CFG.drawTextDefault(oSB, "" + this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID()), this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) - this.iWorstDescDataTextWidth + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)((int)(2.0f * CFG.GUI_SCALE))) + iTranslateY, DATA_COLOR);
                if ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) < CFG.CIV_FLAG_HEIGHT) {
                    try {
                        CFG.core.getCiv(this.lData.get(this.iWorstDescDataID).getCivID()).getFlagC().drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iWorstDescDataTextWidth - (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)) + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)CFG.core.getCiv(this.lData.get(this.iWorstDescDataID).getCivID()).getFlagC().getHeight()) + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
                    }
                    catch (IndexOutOfBoundsException ex) {
                        IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iWorstDescDataTextWidth - (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)) + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)IMGManager.getIMG(Images.randomCivilizationFlag).getHeight()) + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
                    }
                    IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iWorstDescDataTextWidth - (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)) + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)((int)(2.0f * CFG.GUI_SCALE)) - (float)CFG.CIV_FLAG_HEIGHT) + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
                    break block62;
                }
                try {
                    CFG.core.getCiv(this.lData.get(this.iWorstDescDataID).getCivID()).getFlagC().drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iWorstDescDataTextWidth - CFG.CIV_FLAG_WIDTH + iTranslateX, (int)((float)(this.getPosY() - CFG.core.getCiv(this.lData.get(this.iWorstDescDataID).getCivID()).getFlagC().getHeight() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)((int)(2.0f * CFG.GUI_SCALE)) + (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2) - (float)(CFG.CIV_FLAG_HEIGHT / 2)) + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                }
                catch (IndexOutOfBoundsException ex) {
                    IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iWorstDescDataTextWidth - CFG.CIV_FLAG_WIDTH + iTranslateX, (int)((float)(this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)((int)(2.0f * CFG.GUI_SCALE)) + (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2) - (float)(CFG.CIV_FLAG_HEIGHT / 2)) + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                }
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getGraphWidth() - (int)(2.0f * CFG.GUI_SCALE) * 2 - this.iWorstDescDataTextWidth - CFG.CIV_FLAG_WIDTH + iTranslateX, (int)((float)(this.getPosY() - this.iFixPosY + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) - (float)(this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) * (100.0f * (float)this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID())) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f + (float)((int)(2.0f * CFG.GUI_SCALE)) + (float)((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2) - (float)(CFG.CIV_FLAG_HEIGHT / 2)) + iTranslateY);
            }
            catch (ArithmeticException ex) {
                // empty catch block
            }
        }
        CFG.fontMain.get(0).getData().setScale(1.0f);
        oSB.setColor(Color.WHITE);
        if ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) < CFG.CIV_FLAG_HEIGHT) {
            if (this.iMinPoint <= 0) {
                try {
                    CFG.core.getCiv(this.iWorstCivID).getFlagC().drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) * 2 + this.iMinTextWidth + iTranslateX, this.getPosY() + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - (int)(2.0f * CFG.GUI_SCALE) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) - CFG.core.getCiv(this.iWorstCivID).getFlagC().getHeight() + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
                }
                catch (IndexOutOfBoundsException ex) {
                    IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) * 2 + this.iMinTextWidth + iTranslateX, this.getPosY() + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - (int)(2.0f * CFG.GUI_SCALE) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
                }
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) * 2 + this.iMinTextWidth + iTranslateX, this.getPosY() + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - (int)(2.0f * CFG.GUI_SCALE) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) - CFG.CIV_FLAG_HEIGHT + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
            }
            try {
                CFG.core.getCiv(this.iBestCivID).getFlagC().drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) * 2 + this.iMaxTextWidth + iTranslateX, this.getPosY() + 1 + (int)(2.0f * CFG.GUI_SCALE) - CFG.core.getCiv(this.iBestCivID).getFlagC().getHeight() + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
            }
            catch (IndexOutOfBoundsException ex) {
                IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) * 2 + this.iMaxTextWidth + iTranslateX, this.getPosY() + 1 + (int)(2.0f * CFG.GUI_SCALE) - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
            }
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) * 2 + this.iMaxTextWidth + iTranslateX, this.getPosY() + 1 + (int)(2.0f * CFG.GUI_SCALE) - CFG.CIV_FLAG_HEIGHT + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * ((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE / (float)CFG.CIV_FLAG_HEIGHT)));
        } else {
            if (this.iMinPoint <= 0) {
                try {
                    CFG.core.getCiv(this.iWorstCivID).getFlagC().drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) * 2 + this.iMinTextWidth + iTranslateX, this.getPosY() - CFG.core.getCiv(this.iWorstCivID).getFlagC().getHeight() + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - (int)(2.0f * CFG.GUI_SCALE) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                }
                catch (IndexOutOfBoundsException ex) {
                    IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) * 2 + this.iMinTextWidth + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - (int)(2.0f * CFG.GUI_SCALE) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                }
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) * 2 + this.iMinTextWidth + iTranslateX, this.getPosY() + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - (int)(2.0f * CFG.GUI_SCALE) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
            }
            try {
                CFG.core.getCiv(this.iBestCivID).getFlagC().drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) * 2 + this.iMaxTextWidth + iTranslateX, this.getPosY() - CFG.core.getCiv(this.iBestCivID).getFlagC().getHeight() + 1 + (int)(2.0f * CFG.GUI_SCALE) + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
            }
            catch (IndexOutOfBoundsException ex) {
                IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) * 2 + this.iMaxTextWidth + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + 1 + (int)(2.0f * CFG.GUI_SCALE) + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
            }
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) * 2 + this.iMaxTextWidth + iTranslateX, this.getPosY() + 1 + (int)(2.0f * CFG.GUI_SCALE) + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
        }
        oSB.setColor(GRAPH_BORDERS_COLOR);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + iTranslateX, this.getPosY() + iTranslateY, 1, this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2 + CFG.PADD);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2 + iTranslateY, this.getGraphWidth() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2 + CFG.PADD, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getGraphWidth() - CFG.PADD + iTranslateX, this.getPosY() + 1 + iTranslateY, CFG.PADD);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() - 1 + this.getGraphWidth() + iTranslateX, this.getPosY() + 1 + iTranslateY, 1, CFG.PADD - 1);
        if (this.iDescOfTurnID > 0 && this.iDescOfTurnID < this.iPointsPosXSize - 1) {
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + this.lPointsPosX.get(this.iDescOfTurnID) + iTranslateX, this.getPosY() + this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 3 + 1 + iTranslateY, 1, CFG.PADD - 1);
        }
        Rectangle clipBounds = new Rectangle(this.getPosXE() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY, this.getWidthE(), -(this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2 + 2));
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        for (int i = 0; i < this.iDataSize; ++i) {
            if (!this.lData.get(this.lSortedData.get(i)).getVisible()) continue;
            this.lData.get(this.lSortedData.get(i)).drawCivButton(oSB, this.getPosXE() + this.getWidthE() - Graph.getGraphButtonWidth() + iTranslateX, this.getPosY() + (Graph.getGraphButtonHeight() + CFG.PADD) * i + this.iButtonsPosY + iTranslateY, this.iActiveButtonID == i);
        }
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
        oSB.setColor(Color.WHITE);
    }

    private final void drawGraphData(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
        int tempFixPosY;
        int n = tempFixPosY = this.getMinPoint() > 0 ? this.iFixPosY : this.iFixPosY;
        for (int i = 0; i < this.iDataSize; ++i) {
            if (this.lData.get(i).getDrawData()) {
                this.lData.get(i).draw(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + iTranslateX, this.getPosY() + iTranslateY, this.getGraphWidth(), this.getHeightE(), this.lPointsPosX, i, this.iActiveButtonID >= 0 ? this.lSortedData.get(this.iActiveButtonID) == i : (this.iHoveredID >= 0 ? this.lSortedData.get(this.iHoveredID) == i : false), tempFixPosY);
                continue;
            }
            if (!this.lData.get(i).getBackAnimation()) continue;
            if (this.lData.get(i).getTime() + 750L <= System.currentTimeMillis()) {
                this.lData.get(i).setBackAnimation(false);
                continue;
            }
            this.lData.get(i).drawAnimation(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + iTranslateX, this.getPosY() + iTranslateY, this.getGraphWidth(), this.getHeightE(), this.lPointsPosX, i, this.iActiveButtonID == this.lSortedData.get(i) || this.iHoveredID == this.lSortedData.get(i), tempFixPosY);
        }
    }

    @Override
    public final void setDataGraph(List<GraphData> nData) {
        this.lData.clear();
        for (int i = 0; i < nData.size(); ++i) {
            this.lData.add(nData.get(i));
        }
        this.iDataSize = this.lData.size();
        this.buildGraph();
    }

    @Override
    public final void addDataGraph(GraphData nData) {
        for (int i = 0; i < this.iDataSize; ++i) {
            if (this.lData.get(i).getCivID() != nData.getCivID()) continue;
            return;
        }
        this.lData.add(nData);
        this.iDataSize = this.lData.size();
        this.updateMoveable();
        this.buildGraph();
        this.sortCivsByLastPoint();
    }

    @Override
    public final void removeData(int iCivID) {
        if (this.iDataSize > 1) {
            for (int i = 0; i < this.iDataSize; ++i) {
                if (this.lData.get(i).getCivID() != iCivID) continue;
                this.lData.remove(i);
                this.iDataSize = this.lData.size();
                this.updateMoveable();
                this.buildGraph();
                this.updateButtonsInView();
                return;
            }
        }
        this.sortCivsByLastPoint();
    }

    @Override
    public void setMin(int nCivID) {
        for (int i = 0; i < this.lData.size(); ++i) {
            if (this.lData.get(i).getCivID() != nCivID) continue;
            this.lData.get(i).setDrawData(!this.lData.get(i).getDrawData());
            if (!this.lData.get(i).getDrawData()) break;
            this.loadData(i);
            break;
        }
    }

    public void loadData(int i) {
        int nStartTurnID = -1;
        int jSize = CFG.timelapseManager.timelapseStatsProvinces.lProvinces.size();
        for (int j = 0; j < jSize; ++j) {
            if (CFG.timelapseManager.timelapseStatsProvinces.lProvinces.get(j).size() <= this.lData.get(i).getCivID()) continue;
            nStartTurnID = j;
            break;
        }
        ArrayList<Long> tempPoints = new ArrayList<Long>();
        if (nStartTurnID >= 0) {
            int jSize2 = CFG.timelapseManager.timelapseStatsProvinces.lProvinces.size();
            for (int j = nStartTurnID; j < jSize2; ++j) {
                tempPoints.add(((Number)CFG.timelapseManager.timelapseStatsProvinces.lProvinces.get(j).get(this.lData.get(i).getCivID())).longValue());
            }
        }
        if (tempPoints.size() > 0) {
            this.lData.set(i, new GraphData(this.lData.get(i).getCivID(), tempPoints, nStartTurnID));
            this.lData.get(i).setDrawData(true);
            this.updateMoveable();
            this.buildGraph();
        }
    }

    private final void sortCivsByLastPoint() {
        this.lSortedData.clear();
        for (int i = 0; i < this.iDataSize; ++i) {
            this.lSortedData.add(i);
        }
    }

    private final long getDataLastPoint(int id) {
        try {
            return this.lData.get(id).getPointY(this.iPointsPosXSize - 1 - this.lData.get(id).getBeginTurnID());
        }
        catch (IndexOutOfBoundsException ex) {
            return 0L;
        }
    }

    @Override
    public void updateSlider(int nPosX) {
        this.updateMoveTurnTime();
        if (CFG.menus.getGraphButtonMode2()) {
            this.actionUp(nPosX);
        } else {
            if (nPosX < this.getPosXE()) {
                this.iDescOfTurnID = 0;
                this.updateDescInfo();
                return;
            }
            if (nPosX > this.getPosXE() + this.getGraphWidth()) {
                this.iDescOfTurnID = this.iPointsPosXSize - 1;
                this.updateDescInfo();
                return;
            }
            float tempWidth = (float)(this.getGraphWidth() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2) / (float)(this.iPointsPosXSize - 1);
            float tempX = this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2;
            for (int i = 0; i < this.iPointsPosXSize; ++i) {
                tempX = i == 0 ? (tempX += tempWidth / 2.0f) : (tempX += tempWidth);
                if (!((float)nPosX <= tempX)) continue;
                this.iDescOfTurnID = i;
                this.updateDescInfo();
                return;
            }
        }
    }

    public final void updateDescInfo() {
        long tempBestResult = this.getMinPoint();
        long tempWorstResult = this.iMaxPoint;
        for (int i = 0; i < this.iDataSize; ++i) {
            if (!this.lData.get(i).getDrawData() || this.iDescOfTurnID < this.lData.get(i).getBeginTurnID() || this.iDescOfTurnID >= this.lData.get(i).getBeginTurnID() + this.lData.get(i).getPointsSize()) continue;
            if (this.lData.get(i).getPointY(this.iDescOfTurnID - this.lData.get(i).getBeginTurnID()) > tempBestResult) {
                tempBestResult = this.lData.get(i).getPointY(this.iDescOfTurnID - this.lData.get(i).getBeginTurnID());
                this.iBestDescDataID = i;
            }
            if (this.lData.get(i).getPointY(this.iDescOfTurnID - this.lData.get(i).getBeginTurnID()) > tempWorstResult) continue;
            tempWorstResult = this.lData.get(i).getPointY(this.iDescOfTurnID - this.lData.get(i).getBeginTurnID());
            this.iWorstDescDataID = i;
        }
        CFG.fontMain.get(0).getData().setScale(POINTS_TEXT_SCALE);
        try {
            CFG.glyphLay.setText(CFG.fontMain.get(0), "" + this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID()));
            this.iWorstDescDataTextWidth = (int)CFG.glyphLay.width;
            CFG.glyphLay.setText(CFG.fontMain.get(0), "" + this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID()));
            this.iBestDescDataTextWidth = (int)CFG.glyphLay.width;
        }
        catch (Exception i) {
            // empty catch block
        }
        CFG.fontMain.get(0).getData().setScale(1.0f);
        int tempRealTurnID = 1;
        tempRealTurnID = this.iPointsPosXSize < GameCalendar.TURNID ? GameCalendar.TURNID - this.iPointsPosXSize - 1 + (this.iDescOfTurnID + 1) : this.iDescOfTurnID + 1;
        this.sTextX = GameCalendar.getDate_ByTurnID(tempRealTurnID);
        this.sTextX2 = " [" + CFG.lang.get("Turn") + ": " + tempRealTurnID + "]";
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sTextX);
        this.iWidthTextX = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sTextX2);
        this.iWidthTextX2 = (int)CFG.glyphLay.width;
        this.updateMoveTurnTime();
        CFG.setRenderO(true);
    }

    public final void buildGraph() {
        int i;
        this.iMinPoint = this.iMaxPoint = this.lData.get(0).getPointY(0);
        this.fAvaragePoint = 0.0f;
        this.iBestCivID = this.iWorstCivID = this.lData.get(0).getCivID();
        int tempAvarageSize = 0;
        this.iMaxSize = 0;
        for (int i2 = 0; i2 < this.iDataSize; ++i2) {
            if (this.lData.get(i2).getDrawData()) {
                float tempAverage = 0.0f;
                for (int j = 0; j < this.lData.get(i2).getPointsSize(); ++j) {
                    if (this.lData.get(i2).getPointY(j) > this.iMaxPoint) {
                        this.iMaxPoint = this.lData.get(i2).getPointY(j);
                        this.iBestCivID = this.lData.get(i2).getCivID();
                    }
                    if (this.lData.get(i2).getPointY(j) <= this.iMinPoint) {
                        this.iMinPoint = this.lData.get(i2).getPointY(j);
                        this.iWorstCivID = this.lData.get(i2).getCivID();
                    }
                    tempAverage += (float)this.lData.get(i2).getPointY(j);
                }
                this.fAvaragePoint += tempAverage / (float)this.lData.get(i2).getPointsSize();
                ++tempAvarageSize;
                if (this.iMaxSize >= this.lData.get(i2).getPointsSize() + this.lData.get(i2).getBeginTurnID()) continue;
                this.iMaxSize = this.lData.get(i2).getPointsSize() + this.lData.get(i2).getBeginTurnID();
                continue;
            }
            for (int j = 0; j < this.lData.get(i2).getPointsSize(); ++j) {
                if (this.lData.get(i2).getPointY(j) > this.iMaxPoint) {
                    this.iMaxPoint = this.lData.get(i2).getPointY(j);
                    this.iBestCivID = this.lData.get(i2).getCivID();
                }
                if (this.lData.get(i2).getPointY(j) > this.iMinPoint) continue;
                this.iMinPoint = this.lData.get(i2).getPointY(j);
                this.iWorstCivID = this.lData.get(i2).getCivID();
            }
            if (this.iMaxSize >= this.lData.get(i2).getPointsSize() + this.lData.get(i2).getBeginTurnID()) continue;
            this.iMaxSize = this.lData.get(i2).getPointsSize() + this.lData.get(i2).getBeginTurnID();
        }
        this.fAvaragePoint /= (float)tempAvarageSize;
        try {
            if (this.iMinPoint < 0L) {
                this.iFixPosY = -((int)((float)(this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2) * (100.0f * (float)this.getMinPoint()) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f));
                this.iZeroPosY = (int)((float)(this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2) - (float)(this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2) * 0.0f / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f);
            } else {
                this.iFixPosY = this.iMinPoint > 0L ? (int)((float)(this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2) - (float)(this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2) * (100.0f * (float)this.getMinPoint()) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)(this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2)) : 0;
            }
        }
        catch (ArithmeticException ex) {
            this.iFixPosY = 0;
        }
        this.iAvaragePosY = (int)((float)(this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2) - (float)(this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2) * (100.0f * this.fAvaragePoint) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f);
        this.roundAverage();
        this.lPointsPosX.clear();
        this.lPointsPosX.add(0);
        for (i = 1; i < this.iMaxSize - 1; ++i) {
            this.lPointsPosX.add((int)((float)(this.getGraphWidth() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2) * (100.0f * (float)i) / (float)(this.iMaxSize - 1) / 100.0f));
        }
        this.lPointsPosX.add(this.getGraphWidth() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2);
        this.iPointsPosXSize = this.lPointsPosX.size();
        for (i = 0; i < this.iDataSize; ++i) {
            this.lData.get(i).buildGraph(this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2, this.getMinPoint(), this.iMaxPoint, this.lPointsPosX);
        }
        CFG.fontMain.get(0).getData().setScale(POINTS_TEXT_SCALE);
        try {
            CFG.glyphLay.setText(CFG.fontMain.get(0), "" + this.iMinPoint);
            this.iMinTextWidth = (int)CFG.glyphLay.width;
            CFG.glyphLay.setText(CFG.fontMain.get(0), "" + this.iMaxPoint);
            this.iMaxTextWidth = (int)CFG.glyphLay.width;
        }
        catch (Exception exception) {
            // empty catch block
        }
        CFG.fontMain.get(0).getData().setScale(1.0f);
        this.updateDescInfo();
    }

    private final void updateButtonsInView() {
        for (int i = 0; i < this.iDataSize; ++i) {
            if (this.getButtonsPosY(i) + this.iButtonsPosY >= 0 && this.getButtonsPosY(i) + this.iButtonsPosY <= this.getHeightE()) {
                this.lData.get(this.lSortedData.get(i)).setVisible(true);
                continue;
            }
            if (this.getButtonsPosY(i) + Graph.getGraphButtonHeight() + this.iButtonsPosY >= 0 && this.getButtonsPosY(i) + Graph.getGraphButtonHeight() + this.iButtonsPosY <= this.getHeightE()) {
                this.lData.get(this.lSortedData.get(i)).setVisible(true);
                continue;
            }
            this.lData.get(this.lSortedData.get(i)).setVisible(false);
        }
    }

    public final void updateMoveable() {
        if (this.getButtonsHeight() > this.getHeightE()) {
            this.moveable = true;
        } else {
            this.moveable = false;
            this.iButtonsPosY = 0;
        }
    }

    @Override
    public final void setScrollPosY(int nPosY) {
        nPosY -= this.getPosY();
        for (int i = 0; i < this.iDataSize; ++i) {
            if (this.getButtonsPosY(i) + this.iButtonsPosY > nPosY || this.getButtonsPosY(i) + Graph.getGraphButtonHeight() + this.iButtonsPosY < nPosY) continue;
            this.iActiveButtonID = i;
            break;
        }
    }

    private final void actionUp(int nPosY) {
        if (this.iActiveButtonID >= 0 && this.getButtonsPosY(this.iActiveButtonID) + this.iButtonsPosY <= (nPosY -= this.getPosY()) && this.getButtonsPosY(this.iActiveButtonID) + Graph.getGraphButtonHeight() + this.iButtonsPosY >= nPosY) {
            if (!this.lData.get(this.lSortedData.get(this.iActiveButtonID)).getDrawData()) {
                this.lData.get(this.lSortedData.get(this.iActiveButtonID)).setDrawData(!this.lData.get(this.lSortedData.get(this.iActiveButtonID)).getDrawData());
                if (this.lData.get(this.lSortedData.get(this.iActiveButtonID)).getDrawData()) {
                    this.loadData(this.lSortedData.get(this.iActiveButtonID));
                }
                this.buildGraph();
            } else {
                int numOfActiveDatas = 0;
                for (int j = 0; j < this.iDataSize; ++j) {
                    if (!this.lData.get(j).getDrawData()) continue;
                    ++numOfActiveDatas;
                }
                if (numOfActiveDatas > 1) {
                    this.lData.get(this.lSortedData.get(this.iActiveButtonID)).setDrawData(!this.lData.get(this.lSortedData.get(this.iActiveButtonID)).getDrawData());
                    if (this.lData.get(this.lSortedData.get(this.iActiveButtonID)).getDrawData()) {
                        this.loadData(this.lSortedData.get(this.iActiveButtonID));
                    }
                    this.buildGraph();
                }
            }
        }
        this.iActiveButtonID = -1;
    }

    @Override
    public int getCurr() {
        return this.iButtonsPosY;
    }

    @Override
    public void setCurr(int nButtonsPosY) {
        if (nButtonsPosY >= 0) {
            nButtonsPosY = 0;
        } else if (nButtonsPosY <= -(this.getButtonsHeight() - (this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2))) {
            nButtonsPosY = -(this.getButtonsHeight() - (this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2));
        }
        if (this.iButtonsPosY != nButtonsPosY) {
            this.iButtonsPosY = nButtonsPosY;
            this.updateButtonsInView();
            CFG.setRenderO(true);
        }
    }

    @Override
    public boolean isMoveable() {
        return this.moveable;
    }

    private final int getButtonsPosY(int i) {
        return Graph.getGraphButtonHeight() * i + CFG.PADD * i;
    }

    private final int getButtonsHeight() {
        return Graph.getGraphButtonHeight() * this.iDataSize + CFG.PADD * (this.iDataSize - 1);
    }

    private final void roundAverage() {
        if (this.fAvaragePoint - (float)((int)this.fAvaragePoint) != 0.0f) {
            this.bDecimal = (byte)Math.round((this.fAvaragePoint - (float)((int)this.fAvaragePoint)) * 100.0f);
            this.fAvaragePoint -= this.fAvaragePoint - (float)((int)this.fAvaragePoint);
            this.lessThanTen = false;
            if (this.bDecimal % 10 == 0) {
                this.bDecimal = (byte)(this.bDecimal / 10);
            } else if (this.bDecimal < 10) {
                this.lessThanTen = true;
            }
        } else {
            this.bDecimal = 0;
        }
    }

    @Override
    public void setVisibleE(boolean isVisible) {
        if (isVisible) {
            if (this.iDescOfTurnID != 0) {
                this.updateSlider(0);
            }
            this.lTime = System.currentTimeMillis() - 1L;
            CFG.setRenderO(true);
            this.updateMoveTurnTime();
        } else {
            this.lTime = 0L;
            this.iButtonsPosY = 0;
        }
        super.setVisibleE(isVisible);
        this.setHoveredID(-1);
    }

    public final int getGraphWidth() {
        return this.getWidthE() - Graph.getGraphButtonWidth() - CFG.PADD;
    }

    private final long getMinPoint() {
        return this.iMinPoint > 0L ? 0L : this.iMinPoint;
    }

    private final void updateMoveTurnTime() {
        this.lAuto_Move_Turn_Time = System.currentTimeMillis();
    }

    private final void incrementTurnDescInfo() {
        ++this.iDescOfTurnID;
        if (this.iDescOfTurnID >= this.iMaxSize) {
            this.iDescOfTurnID = 0;
        }
        this.updateDescInfo();
        CFG.setRenderO(true);
    }

    @Override
    public void setCheckboxSt(boolean checkboxState) {
        this.buildGraph();
        this.updateMoveable();
        this.updateButtonsInView();
    }
}

