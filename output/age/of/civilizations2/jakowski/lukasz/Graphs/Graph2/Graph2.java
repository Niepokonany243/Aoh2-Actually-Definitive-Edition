/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Graphs.Graph2;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.GraphData2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Graph2
extends MenuElemUI {
    protected static final Color GRAPH_BG_COLOR = new Color(0.17254902f, 0.14901961f, 0.13333334f, 1.0f);
    protected static final Color GRAPH_BORDERS_COLOR = new Color(0.078431375f, 0.11764706f, 0.17254902f, 1.0f);
    protected static final Color GRAPH_LINES_COLOR = new Color(0.9f, 0.9f, 0.9f, 0.1f);
    protected static final Color GRAPH_LINES_DESC = new Color(0.9f, 0.9f, 0.9f, 0.15f);
    protected static final Color GRAPH_LINE_COLOR = new Color(0.8235294f, 0.8235294f, 0.8235294f, 1.0f);
    protected static final Color TEXT_COLOR = new Color(0.9f, 0.9f, 0.9f, 1.0f);
    protected static final Color DATA_COLOR = new Color(0.6862745f, 0.6862745f, 0.6862745f, 1.0f);
    protected static float POINTS_TEXT_SCALE = 0.8f;
    protected List<GraphData2> lData;
    public int iDataSize;
    public List<Integer> lSortedData;
    public List<Integer> lPointsPosX;
    public int iPointsPosXSize;
    public int iMaxSize = 0;
    public int iFixPosY;
    public int iHoveredID = -1;
    public static final int FONT_ID = 1;
    public int iZeroPosY;
    public long iMinPoint;
    public int iMinTextWidth;
    public int iWorstCivID;
    public long iMaxPoint;
    public long iMaxPoint_Text;
    public int iMaxTextWidth;
    public int iBestCivID;
    public float fAvaragePoint;
    public int iAvaragePosY;
    public byte bDecimal = 0;
    public boolean lessThanTen = false;
    public boolean split100 = false;
    public boolean drawValues = true;
    public int iDescOfTurnID = 0;
    public int iWorstDescDataID;
    public int iWorstDescDataTextWidth;
    public int iBestDescDataID;
    public int iBestDescDataTextWidth;
    public String sTextX;
    public String sTextY;
    public int iWidthTextX;
    public int iWidthTextY;
    public static final int ANIMATION_TIME = 0;
    public long lTime = 0L;
    public static final int AUTO_MOVE_TURN_TIME = 1450;
    public long lAuto_Move_Turn_Time = 0L;
    public boolean moveable = false;
    public int iButtonsPosY = 0;
    public int iActiveButtonID = -1;
    public GraphType graphType;
    public int id;

    protected static final int getGraphButtonWidth() {
        return 0;
    }

    protected static final int getGraphButtonHeight() {
        return CFG.BUTTON_H / 2;
    }

    public Graph2(String sTextX, String sTextY, int iPosX, int iPosY, int iWidth, int iHeight, boolean visible, int nLoadSize, GraphType graphType, boolean split100, int id, boolean drawValues) {
        int i;
        this.sTextX = sTextX;
        this.sTextY = sTextY;
        this.graphType = graphType;
        this.drawValues = drawValues;
        this.split100 = split100;
        this.id = id;
        ArrayList<Integer> nCivs = new ArrayList<Integer>();
        if (graphType == GraphType.PLAYER_BALANCE) {
            nCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        } else if (graphType == GraphType.PLAYER_TREASURY) {
            nCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        } else if (graphType == GraphType.PLAYER_HAPPINESS) {
            nCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        } else if (graphType == GraphType.PLAYER_ARMY_SIZE) {
            nCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        } else if (graphType == GraphType.PLAYER_STABILITY) {
            nCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        } else if (graphType == GraphType.PLAYER_INCOME) {
            nCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        } else if (graphType == GraphType.PLAYER_EXPENSES) {
            nCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        } else if (graphType == GraphType.PLAYER_MILITARY_SPENDING) {
            nCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        } else if (graphType == GraphType.CIV_POPULATION) {
            nCivs.add(id);
        } else if (graphType == GraphType.RELIGION_POPULATION) {
            nCivs.add(id);
        } else if (graphType == GraphType.GOVERNMENT_POPULATION) {
            nCivs.add(id);
        } else if (graphType == GraphType.CIV_ECONOMY) {
            nCivs.add(id);
        } else if (graphType == GraphType.CIV_RANK) {
            nCivs.add(id);
        } else if (graphType == GraphType.CIV_TECHNOLOGY) {
            nCivs.add(id);
        } else if (graphType == GraphType.CIV_PROVINCES) {
            nCivs.add(id);
        } else {
            nCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        }
        CFG.fontMain.get(1).getData().setScale(0.7f);
        Renderer.glyphLayout.setText(CFG.fontMain.get(1), sTextX);
        this.iWidthTextX = (int)Renderer.glyphLayout.width;
        Renderer.glyphLayout.setText(CFG.fontMain.get(1), sTextY);
        this.iWidthTextY = (int)Renderer.glyphLayout.width;
        CFG.fontMain.get(1).getData().setScale(1.0f);
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.setHeightE(iHeight);
        this.setVisibleE(visible);
        this.lData = new ArrayList<GraphData2>();
        this.lSortedData = new ArrayList<Integer>();
        this.lPointsPosX = new ArrayList<Integer>();
        this.iFixPosY = 0;
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.GRAPH;
        for (i = 0; i < nCivs.size(); ++i) {
            this.addDataGraph2(new GraphData2((Integer)nCivs.get(i), new ArrayList<Long>(), 0));
        }
        for (i = 0; i < nLoadSize && i < this.lData.size(); ++i) {
            this.loadData(i);
        }
        this.iDataSize = this.lData.size();
    }

    /*
     * Unable to fully structure code
     */
    protected void loadData(int i) {
        int nStartTurnID;
        List<Long> tempPoints;
        int a;
        int b;

        block68: {
            block79: {
                block77: {
                    block76: {
                        block75: {
                            block74: {
                                block73: {
                                    block72: {
                                        block71: {
                                            block70: {
                                                block69: {
                                                    block67: {
                                                        nStartTurnID = 0;
                                                        tempPoints = new ArrayList<Long>();
                                                        if (this.graphType != GraphType.PLAYER_BALANCE) break block67;
                                                        try {
                                                            for (a = 0; a < CFG.timelapseManager.timelapseStatsGD.lPlayers_Balance.size(); ++a) {
                                                                tempPoints.add(Long.valueOf(CFG.timelapseManager.timelapseStatsGD.lPlayers_Balance.get(a).get(CFG.PLAYER_TURN_ID).intValue()));
                                                            }
                                                            tempPoints.add((long)CFG.gameUpdate.getIncome(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) - (long)((int)CFG.gameUpdate.getExpenses(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())));
                                                        }
                                                        catch (Exception ex) {
                                                            tempPoints.add(1L);
                                                            tempPoints.add(1L);
                                                        }
                                                        break block68;
                                                    }
                                                    if (this.graphType != GraphType.PLAYER_INCOME) break block69;
                                                    try {
                                                        for (a = 0; a < CFG.timelapseManager.timelapseStatsGD.lPlayers_Income.size(); ++a) {
                                                            tempPoints.add(Long.valueOf(CFG.timelapseManager.timelapseStatsGD.lPlayers_Income.get(a).get(CFG.PLAYER_TURN_ID).intValue()));
                                                        }
                                                        tempPoints.add((long)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).incomeTaxation + (long)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).incomeProduction);
                                                    }
                                                    catch (Exception ex) {
                                                        tempPoints.add(1L);
                                                        tempPoints.add(1L);
                                                    }
                                                    break block68;
                                                }
                                                if (this.graphType != GraphType.PLAYER_EXPENSES) break block70;
                                                try {
                                                    for (a = 0; a < CFG.timelapseManager.timelapseStatsGD.lPlayers_Expenses.size(); ++a) {
                                                        tempPoints.add((long)CFG.timelapseManager.timelapseStatsGD.lPlayers_Expenses.get(a).get(CFG.PLAYER_TURN_ID));
                                                    }
                                                    tempPoints.add((long)CFG.gameUpdate.getExpenses(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                                                }
                                                catch (Exception ex) {
                                                    tempPoints.add(1L);
                                                    tempPoints.add(1L);
                                                }
                                                break block68;
                                            }
                                            if (this.graphType != GraphType.PLAYER_MILITARY_SPENDING) break block71;
                                            try {
                                                for (a = 0; a < CFG.timelapseManager.timelapseStatsGD.lPlayers_MilitarySpendings.size(); ++a) {
                                                    tempPoints.add((long)CFG.timelapseManager.timelapseStatsGD.lPlayers_MilitarySpendings.get(a).get(CFG.PLAYER_TURN_ID));
                                                }
                                                tempPoints.add((long)CFG.gameUpdate.getMilitaryUpkeep_Total(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                                            }
                                            catch (Exception ex) {
                                                tempPoints.add(1L);
                                                tempPoints.add(1L);
                                            }
                                            break block68;
                                        }
                                        if (this.graphType != GraphType.PLAYER_TREASURY) break block72;
                                        try {
                                            for (a = 0; a < CFG.timelapseManager.timelapseStatsGD.lPlayers_Treasury.size(); ++a) {
                                                tempPoints.add((long)CFG.timelapseManager.timelapseStatsGD.lPlayers_Treasury.get(a).get(CFG.PLAYER_TURN_ID));
                                            }
                                            tempPoints.add(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold());
                                        }
                                        catch (Exception ex) {
                                            tempPoints.add(1L);
                                            tempPoints.add(1L);
                                        }
                                        break block68;
                                    }
                                    if (this.graphType != GraphType.PLAYER_HAPPINESS) break block73;
                                    try {
                                        for (a = 0; a < CFG.timelapseManager.timelapseStatsGD.lPlayers_Happiness.size(); ++a) {
                                            tempPoints.add((long)CFG.timelapseManager.timelapseStatsGD.lPlayers_Happiness.get(a).get(CFG.PLAYER_TURN_ID));
                                        }
                                        tempPoints.add(Long.valueOf(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getHappiness()));
                                    }
                                    catch (Exception ex) {
                                        tempPoints.add(1L);
                                        tempPoints.add(1L);
                                    }
                                    break block68;
                                }
                                if (this.graphType != GraphType.PLAYER_ARMY_SIZE) break block74;
                                try {
                                    for (a = 0; a < CFG.timelapseManager.timelapseStatsGD.lPlayers_ArmySize.size(); ++a) {
                                        tempPoints.add((long)CFG.timelapseManager.timelapseStatsGD.lPlayers_ArmySize.get(a).get(CFG.PLAYER_TURN_ID));
                                    }
                                    tempPoints.add(Long.valueOf(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits()));
                                }
                                catch (Exception ex) {
                                    tempPoints.add(1L);
                                    tempPoints.add(1L);
                                }
                                break block68;
                            }
                            if (this.graphType != GraphType.PLAYER_STABILITY) break block75;
                            try {
                                for (a = 0; a < CFG.timelapseManager.timelapseStatsGD.lPlayers_Stability.size(); ++a) {
                                    tempPoints.add((long)CFG.timelapseManager.timelapseStatsGD.lPlayers_Stability.get(a).get(CFG.PLAYER_TURN_ID));
                                }
                                tempPoints.add((long)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getStabilityCiv() * 100.0f));
                            }
                            catch (Exception ex) {
                                tempPoints.add(1L);
                                tempPoints.add(1L);
                            }
                            break block68;
                        }
                        if (this.graphType != GraphType.CIV_POPULATION) break block76;
                        try {
                            for (a = 0; a < CFG.timelapseManager.timelapseStatsPopulation.lPopulation.size(); ++a) {
                                tempPoints.add((long)CFG.timelapseManager.timelapseStatsPopulation.lPopulation.get(a).get(this.lData.get(0).getCivID()));
                            }
                            tempPoints.add(CFG.core.getCiv(this.lData.get(0).getCivID()).countPop());
                        }
                        catch (Exception ex) {
                            tempPoints.add(1L);
                            tempPoints.add(1L);
                        }
                        break block68;
                    }
                    if (this.graphType != GraphType.RELIGION_POPULATION) break block77;
lbl148:
                    // 3 sources

                    try {
                        for (a = 1; a < CFG.core.getCivsSize(); ++a) {
                            if (CFG.core.getCiv(a).getReligionID() != this.lData.get(0).getCivID()) continue;
                            try {
                                block78: {
                                    if (!tempPoints.isEmpty()) break block78;
                                    for (b = 0; b < CFG.timelapseManager.timelapseStatsPopulation.lPopulation.size(); ++b) {
                                        tempPoints.add((long)CFG.timelapseManager.timelapseStatsPopulation.lPopulation.get(b).get(a));
                                    }
                                    continue;
                                }
                                for (b = 0; b < CFG.timelapseManager.timelapseStatsPopulation.lPopulation.size(); ++b) {
                                    try {
                                        tempPoints.set(b, tempPoints.get(b) + CFG.timelapseManager.timelapseStatsPopulation.lPopulation.get(b).get(a));
                                        continue;
                                    }
                                    catch (Exception exr) {
                                        tempPoints.add((long)CFG.timelapseManager.timelapseStatsPopulation.lPopulation.get(b).get(a));
                                    }
                                }
                                continue;
                            }
                            catch (Exception ex) {
                                CFG.exceptionStack(ex);
                                tempPoints.add(1L);
                                tempPoints.add(1L);
                            }
                        }
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                        tempPoints.add(1L);
                        tempPoints.add(1L);
                    }
                    break block68;
                }
                if (this.graphType != GraphType.GOVERNMENT_POPULATION) break block79;
lbl186:
                // 3 sources

                try {
                    for (a = 1; a < CFG.core.getCivsSize(); ++a) {
                        if (CFG.core.getCiv(a).getIdeology() != this.lData.get(0).getCivID()) continue;
                        try {
                            block80: {
                                if (!tempPoints.isEmpty()) break block80;
                                for (b = 0; b < CFG.timelapseManager.timelapseStatsPopulation.lPopulation.size(); ++b) {
                                    tempPoints.add((long)CFG.timelapseManager.timelapseStatsPopulation.lPopulation.get(b).get(a));
                                }
                                continue;
                            }
                            for (b = 0; b < CFG.timelapseManager.timelapseStatsPopulation.lPopulation.size(); ++b) {
                                try {
                                    tempPoints.set(b, tempPoints.get(b) + CFG.timelapseManager.timelapseStatsPopulation.lPopulation.get(b).get(a));
                                    continue;
                                }
                                catch (Exception exr) {
                                    tempPoints.add((long)CFG.timelapseManager.timelapseStatsPopulation.lPopulation.get(b).get(a));
                                }
                            }
                            continue;
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                            tempPoints.add(1L);
                            tempPoints.add(1L);
                        }
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                    tempPoints.add(1L);
                    tempPoints.add(1L);
                }
                break block68;
            }
            if (this.graphType == GraphType.CIV_ECONOMY) {
                try {
                    for (a = 0; a < CFG.timelapseManager.timelapseStatsEconomy.lEconomy.size(); ++a) {
                        tempPoints.add((long)CFG.timelapseManager.timelapseStatsEconomy.lEconomy.get(a).get(this.lData.get(0).getCivID()));
                    }
                    tempPoints.add(CFG.core.getCiv(this.lData.get(0).getCivID()).countEco());
                }
                catch (Exception ex) {
                    tempPoints.add(1L);
                    tempPoints.add(1L);
                }
            } else if (this.graphType == GraphType.CIV_RANK) {
                try {
                    for (a = 0; a < CFG.timelapseManager.timelapseStatsRank.lRank.size(); ++a) {
                        tempPoints.add((long)CFG.timelapseManager.timelapseStatsRank.lRank.get(a).get(this.lData.get(0).getCivID()));
                    }
                    tempPoints.add(Long.valueOf(CFG.core.getCiv(this.lData.get(0).getCivID()).getRankScore()));
                }
                catch (Exception ex) {
                    tempPoints.add(1L);
                    tempPoints.add(1L);
                }
            } else if (this.graphType == GraphType.CIV_TECHNOLOGY) {
                try {
                    for (a = 0; a < CFG.timelapseManager.timelapseStatsTechnology.lTechnologyLevel.size(); ++a) {
                        tempPoints.add((long)CFG.timelapseManager.timelapseStatsTechnology.lTechnologyLevel.get(a).get(this.lData.get(0).getCivID()));
                    }
                    tempPoints.add(Long.valueOf(CFG.core.getCiv(this.lData.get(0).getCivID()).getTechLevelINT()));
                }
                catch (Exception ex) {
                    tempPoints.add(1L);
                    tempPoints.add(1L);
                }
            } else if (this.graphType == GraphType.CIV_PROVINCES) {
                try {
                    for (a = 0; a < CFG.timelapseManager.timelapseStatsProvinces.lProvinces.size(); ++a) {
                        tempPoints.add((long)CFG.timelapseManager.timelapseStatsProvinces.lProvinces.get(a).get(this.lData.get(0).getCivID()));
                    }
                    tempPoints.add(Long.valueOf(CFG.core.getCiv(this.lData.get(0).getCivID()).getNumOfProvs()));
                }
                catch (Exception ex) {
                    tempPoints.add(1L);
                    tempPoints.add(1L);
                    tempPoints.add(1L);
                    tempPoints.add(1L);
                }
            } else {
                for (a = 0; a < 5; ++a) {
                    tempPoints.add(100L + (long)CFG.oR.nextInt(1 + CFG.oR.nextInt(1 + CFG.oR.nextInt(100))));
                }
            }
        }
        if (tempPoints.size() > 0) {
            this.lData.set(i, new GraphData2(this.lData.get(i).getCivID(), tempPoints, nStartTurnID));
            this.lData.get(i).setDrawData(true);
            this.updateMoveable();
            this.buildGraph();
        }
    }

    @Override
    public void updateHover(int nPosX, int nPosY, int menuPosX, int menuPosY) {
        for (int i = 0; i < this.iDataSize; ++i) {
            if (this.getPosXE() + this.getWidthE() - Graph2.getGraphButtonWidth() + menuPosX > nPosX || this.getPosXE() + this.getWidthE() + menuPosX < nPosX || this.getButtonsPosY(i) + this.iButtonsPosY + menuPosY > nPosY || this.getButtonsPosY(i) + Graph2.getGraphButtonHeight() + this.iButtonsPosY + menuPosY < nPosY) continue;
            this.setHoveredID(this.lSortedData.get(i));
            return;
        }
        this.setHoveredID(-1);
    }

    public final void setHoveredID(int nHoveredID) {
        if (this.iHoveredID != nHoveredID) {
            this.iHoveredID = nHoveredID;
            this.buildElemHover();
        }
    }

    @Override
    public void buildElemHover() {
    }

    public void drawBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(0.06666667f, 0.07450981f, 0.09019608f, 1.0f));
        Renderer.drawBox2(oSB, -2 + this.getPosXE() + iTranslateX, -2 + this.getPosY() + iTranslateY, 4 + this.getGraphWidth(), 4 + this.getHeightE(), 1.0f);
        oSB.setColor(new Color(Colors.COLOR_GRADIENT_OVER_BLUE.r, Colors.COLOR_GRADIENT_OVER_BLUE.g, Colors.COLOR_GRADIENT_OVER_BLUE.b, 0.8f));
        IMGManager.getIMG(Images.gradientVertical).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getGraphWidth(), this.getHeightE(), false, true);
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getGraphWidth(), this.getHeightE());
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (this.lAuto_Move_Turn_Time + 1450L < CFG.currentTimeMillis) {
            this.incrementTurnDescInfo();
        }
        this.drawBG(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        oSB.setColor(GRAPH_LINES_DESC);
        IMGManager.getIMG(Images.line33).draw2(oSB, this.getPosXE() + iTranslateX, this.getPosY() - this.iFixPosY + this.iAvaragePosY + iTranslateY, this.getGraphWidth());
        if (this.getMinPoint() < 0L && this.iMaxPoint > 0L) {
            oSB.setColor(GRAPH_LINES_COLOR);
            Images.pix.draw(oSB, this.getPosXE() + 1 + iTranslateX, this.getPosY() - this.iFixPosY + this.iZeroPosY + iTranslateY, this.getGraphWidth() - 1);
            oSB.setColor(GRAPH_BORDERS_COLOR);
            Images.pix.draw(oSB, this.getPosXE() + 1 + iTranslateX, this.getPosY() - 1 - this.iFixPosY + this.iZeroPosY + iTranslateY, CFG.PADD - 1);
            CFG.fontMain.get(1).getData().setScale(POINTS_TEXT_SCALE);
            Renderer.drawTextWithShadow(oSB, 1, "0", this.getPosXE() + 1 + (int)(2.0f * CFG.GUI_SCALE) + iTranslateX, this.getPosY() - (int)(2.0f * CFG.GUI_SCALE) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) - this.iFixPosY + this.iZeroPosY - 1 + iTranslateY, DATA_COLOR);
            CFG.fontMain.get(1).getData().setScale(1.0f);
        }
        this.drawGraphData(oSB, iTranslateX, iTranslateY);
        oSB.setColor(GRAPH_BORDERS_COLOR);
        Images.pix.draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, CFG.PADD - 1);
        Images.pix.draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() - this.iFixPosY + this.iAvaragePosY + iTranslateY, CFG.PADD - 1);
        Images.pix.draw(oSB, this.getPosXE() + this.getGraphWidth() - 1 + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD + 1 + iTranslateY, 1, CFG.PADD - 1);
        if (this.drawValues && !this.getIsHovered()) {
            CFG.fontMain.get(1).getData().setScale(POINTS_TEXT_SCALE);
            if (this.split100) {
                Renderer.drawTextWithShadow(oSB, 1, "" + CFG.getPrecision2((float)this.getMinPoint() / 100.0f, 10), this.getPosXE() + 1 + (int)(2.0f * CFG.GUI_SCALE) + iTranslateX, this.getPosY() + this.getHeightE() - (int)(2.0f * CFG.GUI_SCALE) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) + iTranslateY, DATA_COLOR);
                Renderer.drawTextWithShadow(oSB, 1, "" + CFG.getPrecision2((float)this.iMaxPoint_Text / 100.0f, 10), this.getPosXE() + 1 + (int)(2.0f * CFG.GUI_SCALE) + iTranslateX, this.getPosY() + 1 + (int)(2.0f * CFG.GUI_SCALE) + iTranslateY, DATA_COLOR);
            } else {
                Renderer.drawTextWithShadow(oSB, 1, "" + this.getMinPoint(), this.getPosXE() + 1 + (int)(2.0f * CFG.GUI_SCALE) + iTranslateX, this.getPosY() + this.getHeightE() - (int)(2.0f * CFG.GUI_SCALE) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * POINTS_TEXT_SCALE) + iTranslateY, DATA_COLOR);
                Renderer.drawTextWithShadow(oSB, 1, CFG.getNumber_SHORT(this.iMaxPoint_Text), this.getPosXE() + 1 + (int)(2.0f * CFG.GUI_SCALE) + iTranslateX, this.getPosY() + 1 + (int)(2.0f * CFG.GUI_SCALE) + iTranslateY, DATA_COLOR);
            }
            oSB.setColor(Color.WHITE);
            CFG.fontMain.get(1).getData().setScale(1.0f);
        }
        this.drawBorder(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        oSB.setColor(Color.WHITE);
    }

    public void drawBorder(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(GRAPH_BORDERS_COLOR);
        Images.pix.draw(oSB, this.getPosXE() - 1 + iTranslateX, this.getPosY() + iTranslateY, 1, this.getHeightE());
        Images.pix.draw(oSB, this.getPosXE() - 1 + iTranslateX, this.getPosY() + this.getHeightE() + iTranslateY, this.getGraphWidth() + 1, 1);
        Images.pix.draw(oSB, this.getPosXE() + this.getGraphWidth() - CFG.PADD + iTranslateX, this.getPosY() + iTranslateY, CFG.PADD);
        Images.pix.draw(oSB, this.getPosXE() - 1 + this.getGraphWidth() + iTranslateX, this.getPosY() + iTranslateY, 1, CFG.PADD - 1);
    }

    public final void drawGraphData(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
        int tempFixPosY;
        int n = tempFixPosY = this.getMinPoint() > 0L ? this.iFixPosY : this.iFixPosY;
        for (int i = 0; i < this.iDataSize; ++i) {
            if (this.lData.get(i).getDrawData()) {
                this.lData.get(i).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getGraphWidth(), this.getHeightE(), this.lPointsPosX, i, this.iActiveButtonID >= 0 ? this.lSortedData.get(this.iActiveButtonID) == i : (this.iHoveredID >= 0 ? this.lSortedData.get(this.iHoveredID) == i : false), tempFixPosY);
                continue;
            }
            if (!this.lData.get(i).getBackAnimation()) continue;
            this.lData.get(i).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getGraphWidth(), this.getHeightE(), this.lPointsPosX, i, this.iActiveButtonID == this.lSortedData.get(i) || this.iHoveredID == this.lSortedData.get(i), tempFixPosY);
        }
    }

    @Override
    public final void setData2(List<GraphData2> nData) {
        this.lData.clear();
        for (int i = 0; i < nData.size(); ++i) {
            this.lData.add(nData.get(i));
        }
        this.iDataSize = this.lData.size();
        this.buildGraph();
    }

    @Override
    public final void addDataGraph2(GraphData2 nData) {
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

    public final void sortCivsByLastPoint() {
        this.lSortedData.clear();
        for (int i = 0; i < this.iDataSize; ++i) {
            this.lSortedData.add(i);
        }
    }

    public final long getDataLastPoint(int id) {
        try {
            return this.lData.get(id).getPointY(this.iPointsPosXSize - 1 - this.lData.get(id).getBeginTurnID());
        }
        catch (Exception ex) {
            return 0L;
        }
    }

    @Override
    public void updateSlider(int nPosX) {
        this.updateMoveTurnTime();
    }

    protected final void updateDescInfo() {
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
        CFG.fontMain.get(1).getData().setScale(POINTS_TEXT_SCALE);
        Renderer.glyphLayout.setText(CFG.fontMain.get(1), "" + this.lData.get(this.iWorstDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iWorstDescDataID).getBeginTurnID()));
        this.iWorstDescDataTextWidth = (int)Renderer.glyphLayout.width;
        Renderer.glyphLayout.setText(CFG.fontMain.get(1), "" + this.lData.get(this.iBestDescDataID).getPointY(this.iDescOfTurnID - this.lData.get(this.iBestDescDataID).getBeginTurnID()));
        this.iBestDescDataTextWidth = (int)Renderer.glyphLayout.width;
        CFG.fontMain.get(1).getData().setScale(1.0f);
        int tempRealTurnID = 1;
        tempRealTurnID = this.iPointsPosXSize < GameCalendar.TURNID ? GameCalendar.TURNID - this.iPointsPosXSize - 1 + (this.iDescOfTurnID + 1) : this.iDescOfTurnID + 1;
        this.sTextX = GameCalendar.getDate_ByTurnID(0);
        Renderer.glyphLayout.setText(CFG.fontMain.get(1), this.sTextX);
        this.iWidthTextX = (int)Renderer.glyphLayout.width;
        this.updateMoveTurnTime();
    }

    protected final void buildGraph() {
        try {
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
            this.iMaxPoint_Text = this.iMaxPoint;
            this.iMaxPoint = (int)((float)this.iMaxPoint + (float)this.iMaxPoint * 0.05f);
            this.fAvaragePoint /= (float)tempAvarageSize;
            try {
                if (this.iMinPoint < 0L) {
                    this.iFixPosY = -((int)((float)this.getHeightE() * (100.0f * (float)this.getMinPoint()) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f));
                    this.iZeroPosY = (int)((float)this.getHeightE() - (float)this.getHeightE() * 0.0f / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f);
                } else {
                    this.iFixPosY = this.iMinPoint > 0L ? (int)((float)this.getHeightE() - (float)this.getHeightE() * (100.0f * (float)this.getMinPoint()) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f - (float)this.getHeightE()) : 0;
                }
            }
            catch (Exception ex) {
                this.iFixPosY = 0;
                this.iZeroPosY = 0;
            }
            this.iAvaragePosY = (int)((float)this.getHeightE() - (float)this.getHeightE() * (100.0f * this.fAvaragePoint) / (float)(this.iMaxPoint - this.getMinPoint()) / 100.0f);
            this.roundAverage();
            this.lPointsPosX.clear();
            this.lPointsPosX.add(0);
            for (i = 1; i < this.iMaxSize - 1; ++i) {
                this.lPointsPosX.add((int)((float)this.getGraphWidth() * (100.0f * (float)i) / (float)(this.iMaxSize - 1) / 100.0f));
            }
            this.lPointsPosX.add(this.getGraphWidth());
            this.iPointsPosXSize = this.lPointsPosX.size();
            for (i = 0; i < this.iDataSize; ++i) {
                this.lData.get(i).buildGraph(this.getHeightE(), this.getMinPoint(), this.iMaxPoint, this.lPointsPosX);
            }
            CFG.fontMain.get(1).getData().setScale(POINTS_TEXT_SCALE);
            Renderer.glyphLayout.setText(CFG.fontMain.get(1), "" + this.iMinPoint);
            this.iMinTextWidth = (int)Renderer.glyphLayout.width;
            Renderer.glyphLayout.setText(CFG.fontMain.get(1), "" + this.iMaxPoint_Text);
            this.iMaxTextWidth = (int)Renderer.glyphLayout.width;
            CFG.fontMain.get(1).getData().setScale(1.0f);
            this.updateDescInfo();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void updateButtonsInView() {
        for (int i = 0; i < this.iDataSize; ++i) {
            if (this.getButtonsPosY(i) + this.iButtonsPosY >= 0 && this.getButtonsPosY(i) + this.iButtonsPosY <= this.getHeightE()) {
                this.lData.get(this.lSortedData.get(i)).setVisible(true);
                continue;
            }
            if (this.getButtonsPosY(i) + Graph2.getGraphButtonHeight() + this.iButtonsPosY >= 0 && this.getButtonsPosY(i) + Graph2.getGraphButtonHeight() + this.iButtonsPosY <= this.getHeightE()) {
                this.lData.get(this.lSortedData.get(i)).setVisible(true);
                continue;
            }
            this.lData.get(this.lSortedData.get(i)).setVisible(false);
        }
    }

    protected final void updateMoveable() {
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
            if (this.getButtonsPosY(i) + this.iButtonsPosY > nPosY || this.getButtonsPosY(i) + Graph2.getGraphButtonHeight() + this.iButtonsPosY < nPosY) continue;
            this.iActiveButtonID = i;
            break;
        }
    }

    public final void actionUp(int nPosY) {
        if (this.iActiveButtonID >= 0 && this.getButtonsPosY(this.iActiveButtonID) + this.iButtonsPosY <= (nPosY -= this.getPosY()) && this.getButtonsPosY(this.iActiveButtonID) + Graph2.getGraphButtonHeight() + this.iButtonsPosY >= nPosY) {
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
        } else if (nButtonsPosY <= -(this.getButtonsHeight() - this.getHeightE())) {
            nButtonsPosY = -(this.getButtonsHeight() - this.getHeightE());
        }
        if (this.iButtonsPosY != nButtonsPosY) {
            this.iButtonsPosY = nButtonsPosY;
            this.updateButtonsInView();
        }
    }

    @Override
    public boolean isMoveable() {
        return this.moveable;
    }

    public final int getButtonsPosY(int i) {
        return Graph2.getGraphButtonHeight() * i + CFG.PADD * i;
    }

    public final int getButtonsHeight() {
        return Graph2.getGraphButtonHeight() * this.iDataSize + CFG.PADD * (this.iDataSize - 1);
    }

    public final void roundAverage() {
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
            this.lTime = CFG.currentTimeMillis - 1L;
            this.updateMoveTurnTime();
        } else {
            this.lTime = 0L;
            this.iButtonsPosY = 0;
        }
        super.setVisibleE(isVisible);
        this.setHoveredID(-1);
    }

    public int getGraphWidth() {
        return this.getWidthE() - Graph2.getGraphButtonWidth() - CFG.PADD;
    }

    public final long getMinPoint() {
        return this.iMinPoint > 0L ? 0L : this.iMinPoint;
    }

    public final void updateMoveTurnTime() {
        this.lAuto_Move_Turn_Time = CFG.currentTimeMillis;
    }

    public final void incrementTurnDescInfo() {
        ++this.iDescOfTurnID;
        if (this.iDescOfTurnID >= this.iMaxSize) {
            this.iDescOfTurnID = 0;
        }
        this.updateDescInfo();
    }

    @Override
    public void setCheckboxSt(boolean checkboxState) {
        this.buildGraph();
        this.updateMoveable();
        this.updateButtonsInView();
    }

    public static enum GraphType {
        RANDOM,
        PLAYER_BALANCE,
        PLAYER_INCOME,
        PLAYER_EXPENSES,
        PLAYER_TREASURY,
        PLAYER_MILITARY_SPENDING,
        PLAYER_HAPPINESS,
        PLAYER_ARMY_SIZE,
        PLAYER_STABILITY,
        CIV_POPULATION,
        CIV_ECONOMY,
        CIV_RANK,
        CIV_TECHNOLOGY,
        CIV_PROVINCES,
        RELIGION_POPULATION,
        GOVERNMENT_POPULATION;

    }
}




