
package age.of.civilizations2.jakowski.lukasz.Graphs;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Data;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Data_Type;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Info;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;
import java.util.List;

public class Graph_Vertical
extends MenuElemUI {
    private List<Graph_Vertical_Data> lValues;
    private int iValuesSize = 0;
    private int iValuesTotal = 0;
    private int iDataWidth = 0;
    private Graph_Vertical_Info verticalInfo;
    private Graph_Vertical_Data_Type GRAPH_DATA_TYPE;
    private boolean splitBy100 = false;
    private boolean statisticsMode = false;
    private String sTextX;
    private String sTextY;
    private int iWidthTextY;
    private int iMinPoint;
    private int iMaxPoint;
    private float fAvaragePoint;
    private int iAvaragePosY;
    private byte bDecimal = 0;
    private boolean lessThanTen = false;
    private boolean moveable = false;
    private int iButtonsPosX;
    private int iButtonsPosY;
    private int iHoveredID = -1;
    private boolean scrollModeY = false;
    private int iScrollPosX = -1;
    private int iScrollPosX2 = -1;
    private float fScrollNewMenuPosY = 0.0f;
    private DrawStatisticsData drawStatisticsData;

    public Graph_Vertical(Graph_Vertical_Data_Type nType, String sTextX, String sTextY, int iPosX, int iPosY, int iWidth, int iHeight, boolean visible, List<Graph_Vertical_Data> nValues) {
        this.GRAPH_DATA_TYPE = nType;
        if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.NUM_OF_PROVINCES_BY_CONTINENT) {
            this.drawStatisticsData = new DrawStatisticsData(){

                @Override
                public void draw(SpriteBatch oSB, int i, int tempOffsetX, int iTranslateX, int iTranslateY) {
                    for (int j = 0; j < ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValuesSize(); ++j) {
                        Graph_Vertical.this.drawStatisticsValue(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(j), Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * Graph_Vertical.this.verticalInfo.getSortedID(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(j) - 1) + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                    }
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue() + " [" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), Graph_Vertical.this.iValuesTotal, 4) + "%]", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                }

                @Override
                public String getTotal() {
                    return CFG.sTOTAL + " [" + Graph_Vertical.this.iValuesTotal + "]";
                }

                @Override
                public String getStatsLP(int i) {
                    return CFG.core.getCiv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID()).getCivName();
                }

                @Override
                public int getStatsLPCivFlagID(int i) {
                    return ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID();
                }
            };
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.POPULATION_OF_CIVILIZATIONS) {
            this.drawStatisticsData = new DrawStatisticsData(){

                @Override
                public void draw(SpriteBatch oSB, int i, int tempOffsetX, int iTranslateX, int iTranslateY) {
                    try {
                        Graph_Vertical.this.drawStatisticsValue(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(0) + " [" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(0), ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), 4) + "%]", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * 0 + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                        if (((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(1) > 0) {
                            Graph_Vertical.this.drawStatisticsValueWithFlag(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(1) + " [" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(1), ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), 4) + "%]", ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(1), Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * 1 + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                        } else {
                            Graph_Vertical.this.drawStatisticsValue(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(1), Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * 1 + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                        }
                        if (((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(2) > 0) {
                            Graph_Vertical.this.drawStatisticsValue(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(2) + " [" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(2), ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), 4) + "%]", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * 2 + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                        } else {
                            Graph_Vertical.this.drawStatisticsValue(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(2), Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * 2 + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                        }
                        Graph_Vertical.this.drawStatisticsValue(oSB, "" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), Graph_Vertical.this.iValuesTotal, 5) + "%", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                    }
                    catch (IndexOutOfBoundsException ex) {
                        CFG.setRenderO(true);
                    }
                }

                @Override
                public String getTotal() {
                    return CFG.sTOTAL_WORLDS_POPULATION;
                }

                @Override
                public String getStatsLP(int i) {
                    return CFG.core.getCiv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID()).getCivName();
                }

                @Override
                public int getStatsLPCivFlagID(int i) {
                    return ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID();
                }
            };
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.POPULATION_OF_CIVILIZATION_ALL_AROUND_WORLD) {
            this.drawStatisticsData = new DrawStatisticsData(){

                @Override
                public void draw(SpriteBatch oSB, int i, int tempOffsetX, int iTranslateX, int iTranslateY) {
                    for (int j = 0; j < ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValuesSize(); ++j) {
                        Graph_Vertical.this.drawStatisticsValueWithFlag(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(j), ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(j), Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * j + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                    }
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), Graph_Vertical.this.iValuesTotal, 5) + "%", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                }

                @Override
                public String getTotal() {
                    return CFG.sTOTAL;
                }

                @Override
                public String getStatsLP(int i) {
                    return CFG.core.getCiv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID()).getCivName();
                }

                @Override
                public int getStatsLPCivFlagID(int i) {
                    return ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID();
                }
            };
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.ARMIES) {
            this.drawStatisticsData = new DrawStatisticsData(){

                @Override
                public void draw(SpriteBatch oSB, int i, int tempOffsetX, int iTranslateX, int iTranslateY) {
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(0), Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), Graph_Vertical.this.iValuesTotal, 5) + "%", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                }

                @Override
                public String getTotal() {
                    return CFG.sTOTAL + " [" + Graph_Vertical.this.iValuesTotal + "]";
                }

                @Override
                public String getStatsLP(int i) {
                    return CFG.core.getCiv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID()).getCivName();
                }

                @Override
                public int getStatsLPCivFlagID(int i) {
                    return ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID();
                }
            };
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.ARMY_PER_CAPITA) {
            this.drawStatisticsData = new DrawStatisticsData(){

                @Override
                public void draw(SpriteBatch oSB, int i, int tempOffsetX, int iTranslateX, int iTranslateY) {
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + (float)((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(0) / 100.0f, Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), Graph_Vertical.this.iValuesTotal, 5) + "%", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                }

                @Override
                public String getTotal() {
                    return CFG.sTOTAL;
                }

                @Override
                public String getStatsLP(int i) {
                    return CFG.core.getCiv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID()).getCivName();
                }

                @Override
                public int getStatsLPCivFlagID(int i) {
                    return ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID();
                }
            };
            this.splitBy100 = true;
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.TECHNOLOGY_LEVELS) {
            this.drawStatisticsData = new DrawStatisticsData(){

                @Override
                public void draw(SpriteBatch oSB, int i, int tempOffsetX, int iTranslateX, int iTranslateY) {
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + (float)((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(0) / 100.0f, Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + (float)((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(0) / 100.0f + "%", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                }

                @Override
                public String getTotal() {
                    return CFG.sTOTAL;
                }

                @Override
                public String getStatsLP(int i) {
                    return CFG.core.getCiv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID()).getCivName();
                }

                @Override
                public int getStatsLPCivFlagID(int i) {
                    return ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID();
                }
            };
            this.splitBy100 = true;
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.POPULATION_BY_PROVINCES) {
            this.drawStatisticsData = new DrawStatisticsData(){

                @Override
                public void draw(SpriteBatch oSB, int i, int tempOffsetX, int iTranslateX, int iTranslateY) {
                    for (int j = 0; j < ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValuesSize(); ++j) {
                        Graph_Vertical.this.drawStatisticsValue(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(j), Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * j + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                    }
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), Graph_Vertical.this.iValuesTotal, 5) + "%", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                }

                @Override
                public String getTotal() {
                    return CFG.sTOTAL_WORLDS_POPULATION + " [" + Graph_Vertical.this.iValuesTotal + "]";
                }

                @Override
                public String getStatsLP(int i) {
                    return CFG.core.getProv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(0)).getName();
                }

                @Override
                public int getStatsLPCivFlagID(int i) {
                    return CFG.core.getProv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(0)).getCivId();
                }
            };
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.CONQUERED_PROVINCES) {
            this.drawStatisticsData = new DrawStatisticsData(){

                @Override
                public void draw(SpriteBatch oSB, int i, int tempOffsetX, int iTranslateX, int iTranslateY) {
                    for (int j = 0; j < ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValuesSize(); ++j) {
                        Graph_Vertical.this.drawStatisticsValue(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(j), Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * j + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                    }
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), Graph_Vertical.this.iValuesTotal, 5) + "%", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                }

                @Override
                public String getTotal() {
                    return CFG.sTOTAL + " [" + Graph_Vertical.this.iValuesTotal + "]";
                }

                @Override
                public String getStatsLP(int i) {
                    return CFG.core.getCiv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(0)).getCivName();
                }

                @Override
                public int getStatsLPCivFlagID(int i) {
                    return ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(0);
                }
            };
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.CONSTRUCTED_BUILDINGS) {
            this.drawStatisticsData = new DrawStatisticsData(){

                @Override
                public void draw(SpriteBatch oSB, int i, int tempOffsetX, int iTranslateX, int iTranslateY) {
                    for (int j = 0; j < ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValuesSize(); ++j) {
                        Graph_Vertical.this.drawStatisticsValue(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(j), Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * j + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                    }
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), Graph_Vertical.this.iValuesTotal, 5) + "%", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                }

                @Override
                public String getTotal() {
                    return CFG.sTOTAL + " [" + Graph_Vertical.this.iValuesTotal + "]";
                }

                @Override
                public String getStatsLP(int i) {
                    return CFG.core.getCiv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(0)).getCivName();
                }

                @Override
                public int getStatsLPCivFlagID(int i) {
                    return ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(0);
                }
            };
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.ECONOMY_BY_PROVINCES) {
            this.drawStatisticsData = new DrawStatisticsData(){

                @Override
                public void draw(SpriteBatch oSB, int i, int tempOffsetX, int iTranslateX, int iTranslateY) {
                    for (int j = 0; j < ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValuesSize(); ++j) {
                        Graph_Vertical.this.drawStatisticsValue(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(j), Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * j + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                    }
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), Graph_Vertical.this.iValuesTotal, 5) + "%", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                }

                @Override
                public String getTotal() {
                    return CFG.sTOTAL + " [" + Graph_Vertical.this.iValuesTotal + "]";
                }

                @Override
                public String getStatsLP(int i) {
                    return CFG.core.getProv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(0)).getName();
                }

                @Override
                public int getStatsLPCivFlagID(int i) {
                    return CFG.core.getProv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(0)).getCivId();
                }
            };
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.ARMY_BY_PROVINCES) {
            this.drawStatisticsData = new DrawStatisticsData(){

                @Override
                public void draw(SpriteBatch oSB, int i, int tempOffsetX, int iTranslateX, int iTranslateY) {
                    for (int j = 0; j < ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValuesSize(); ++j) {
                        Graph_Vertical.this.drawStatisticsValue(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(j), Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * j + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                    }
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), Graph_Vertical.this.iValuesTotal, 5) + "%", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                }

                @Override
                public String getTotal() {
                    return CFG.sTOTAL + " [" + Graph_Vertical.this.iValuesTotal + "]";
                }

                @Override
                public String getStatsLP(int i) {
                    return CFG.core.getProv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(0)).getName();
                }

                @Override
                public int getStatsLPCivFlagID(int i) {
                    return CFG.core.getProv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(0)).getCivId();
                }
            };
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.TECHNOLOGY_LEVELS_BY_PROVINCES) {
            this.drawStatisticsData = new DrawStatisticsData(){

                @Override
                public void draw(SpriteBatch oSB, int i, int tempOffsetX, int iTranslateX, int iTranslateY) {
                    for (int j = 0; j < ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValuesSize(); ++j) {
                        Graph_Vertical.this.drawStatisticsValue(oSB, "" + (float)((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(j) / 100.0f, Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * j + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                    }
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), Graph_Vertical.this.iValuesTotal, 5) + "%", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                }

                @Override
                public String getTotal() {
                    return CFG.sTOTAL + " [" + Graph_Vertical.this.iValuesTotal + "]";
                }

                @Override
                public String getStatsLP(int i) {
                    return CFG.core.getProv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(0)).getName();
                }

                @Override
                public int getStatsLPCivFlagID(int i) {
                    return CFG.core.getProv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValueDataTypeID(0)).getCivId();
                }
            };
            this.splitBy100 = true;
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.ECONOMY_OF_CIVILIZATIONS) {
            this.drawStatisticsData = new DrawStatisticsData(){

                @Override
                public void draw(SpriteBatch oSB, int i, int tempOffsetX, int iTranslateX, int iTranslateY) {
                    for (int j = 0; j < ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValuesSize(); ++j) {
                        Graph_Vertical.this.drawStatisticsValue(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(j), Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * j + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                    }
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), Graph_Vertical.this.iValuesTotal, 5) + "%", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                }

                @Override
                public String getTotal() {
                    return CFG.sTOTAL + " [" + Graph_Vertical.this.iValuesTotal + "]";
                }

                @Override
                public String getStatsLP(int i) {
                    return CFG.core.getCiv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID()).getCivName();
                }

                @Override
                public int getStatsLPCivFlagID(int i) {
                    return ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID();
                }
            };
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.POPULATION_OF_CIVILIZATION_BY_NATIONALITIES) {
            this.drawStatisticsData = new DrawStatisticsData(){

                @Override
                public void draw(SpriteBatch oSB, int i, int tempOffsetX, int iTranslateX, int iTranslateY) {
                    for (int j = 0; j < ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValuesSize(); ++j) {
                        Graph_Vertical.this.drawStatisticsValue(oSB, "" + ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(j), Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + Graph_Vertical.this.getStatisticsWidth() * 2 + Graph_Vertical.this.getStatisticsWidth() * j + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                    }
                    Graph_Vertical.this.drawStatisticsValue(oSB, "" + CFG.getPercentageOld(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getValue(), Graph_Vertical.this.iValuesTotal, 5) + "%", Graph_Vertical.this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, Graph_Vertical.this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY);
                }

                @Override
                public String getTotal() {
                    return CFG.sTOTAL + " [" + Graph_Vertical.this.iValuesTotal + "]";
                }

                @Override
                public String getStatsLP(int i) {
                    return CFG.core.getCiv(((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID()).getCivName();
                }

                @Override
                public int getStatsLPCivFlagID(int i) {
                    return ((Graph_Vertical_Data)Graph_Vertical.this.lValues.get(i)).getCivID();
                }
            };
        }
        this.iDataWidth = CFG.CIV_FLAG_WIDTH;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.setHeightE(iHeight);
        this.setVisibleE(visible);
        this.sTextX = sTextX;
        this.sTextY = sTextY;
        CFG.fontMain.get(0).getData().setScale(0.7f);
        CFG.glyphLay.setText(CFG.fontMain.get(0), sTextY);
        this.iWidthTextY = (int)CFG.glyphLay.width;
        CFG.fontMain.get(0).getData().setScale(1.0f);
        this.lValues = nValues;
        this.iValuesSize = this.lValues.size();
        this.buildData();
        this.buildValuesHeights();
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.GRAPH_VERTICAL;
    }

    @Override
    public void updateHover(int nPosX, int nPosY, int menuPosX, int menuPosY) {
        if (!this.statisticsMode) {
            if (nPosX >= menuPosX + this.getPosXE() && nPosX <= menuPosX + this.getPosXE() + this.getWidthE() && nPosY >= menuPosY + this.getPosY() && nPosY <= menuPosY + this.getPosY() + this.getHeightE()) {
                for (int i = 0; i < this.iValuesSize; ++i) {
                    if (nPosX < menuPosX + this.getPosXE() + this.getWidthE() - CFG.PADD * (i + 1) - CFG.PADD * i - this.iDataWidth * (i + 1) + this.iButtonsPosX || nPosX > menuPosX + this.getPosXE() + this.getWidthE() - CFG.PADD * (i + 1) - CFG.PADD * i - this.iDataWidth * (i + 1) + this.iButtonsPosX + this.iDataWidth) continue;
                    this.setHoveredID(i);
                    return;
                }
            }
            this.setHoveredID(-1);
        } else {
            if (nPosX >= menuPosX + this.getPosXE() && nPosX <= menuPosX + this.getPosXE() + this.getWidthE() && nPosY >= menuPosY + this.getPosY() && nPosY <= menuPosY + this.getPosY() + this.getHeightE()) {
                for (int i = 0; i < this.iValuesSize; ++i) {
                    if (nPosY < menuPosY + this.getPosY() + this.iButtonsPosY + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * i || nPosY > menuPosY + this.getPosY() + this.iButtonsPosY + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * i + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2))) continue;
                    this.setHoveredID(i);
                    return;
                }
            }
            this.setHoveredID(-1);
        }
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
            if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.NUM_OF_PROVINCES_BY_CONTINENT) {
                if (!this.statisticsMode) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    try {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.lValues.get(this.iHoveredID).getCivID()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lValues.get(this.iHoveredID).getCivID()).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Text_Big(" [" + (this.iHoveredID + 1) + "/" + this.iValuesSize + "]", CFG.COLOR_NEUTRAL));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    catch (IndexOutOfBoundsException ex) {
                        nData.add(new ME_Hover_2Type_Image_Big(Images.randomCivilizationFlag));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Text_Big(" [" + (this.iHoveredID + 1) + "/" + this.iValuesSize + "]", CFG.COLOR_NEUTRAL));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + this.lValues.get(this.iHoveredID).getValue(), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lValues.get(this.iHoveredID).getValuesSize(); ++i) {
                        nData.add(new ME_Hover_2Type_Text("" + CFG.map.getMapContinents().getName(this.lValues.get(this.iHoveredID).getValueDataTypeID(i)) + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + this.lValues.get(this.iHoveredID).getValue(i), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else if (this.iHoveredID - 1 >= 0) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(this.lValues.get(this.iHoveredID - 1).getCivID()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.lValues.get(this.iHoveredID - 1).getCivID()).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Text_Big(" [" + (this.iHoveredID - 1 + 1) + "/" + this.iValuesSize + "]", CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + this.lValues.get(this.iHoveredID - 1).getValue(), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < this.lValues.get(this.iHoveredID - 1).getValuesSize(); ++i) {
                        nData.add(new ME_Hover_2Type_Text("" + CFG.map.getMapContinents().getName(this.lValues.get(this.iHoveredID - 1).getValueDataTypeID(i)) + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + this.lValues.get(this.iHoveredID - 1).getValue(i), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            }
        } else {
            ME_Hover_v2.resetAnimation_2();
            this.menuElemHover = null;
        }
    }

    @Override
    public void setCheckboxSt(boolean checkboxState) {
        this.buildValuesHeights();
        this.updateInView();
        this.verticalInfo.updateMoveable(this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2));
        this.updateMoveable();
        CFG.setRenderO(true);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (this.scrollModeY) {
            if (this.statisticsMode) {
                if (Math.abs(this.fScrollNewMenuPosY) > 1.0f) {
                    this.setCurr(this.iButtonsPosY + (int)this.fScrollNewMenuPosY);
                    this.fScrollNewMenuPosY *= 0.97f;
                } else {
                    this.scrollModeY = false;
                }
            } else if (Math.abs(this.fScrollNewMenuPosY) > 1.0f) {
                this.setCurr(this.iButtonsPosX + (int)this.fScrollNewMenuPosY);
                this.fScrollNewMenuPosY *= 0.97f;
            } else {
                this.scrollModeY = false;
            }
            CFG.setRenderO(true);
        }
        oSB.setColor(Graph.GRAPH_BG_COLOR);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2, this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.075f));
        IMGManager.getIMG(Images.patternReversed).draw2O(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.patternReversed).getHeight() + iTranslateY, this.getWidthE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2, this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2);
        CFG.fontMain.get(0).getData().setScale(0.7f);
        CFG.drawTextRotated(oSB, this.sTextY, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.iWidthTextY / 2 + iTranslateY, Graph.TEXT_COLOR, 90.0f);
        this.verticalInfo.draw(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + iTranslateY, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2));
        CFG.fontMain.get(0).getData().setScale(1.0f);
        if (this.statisticsMode) {
            this.drawStatisticsBegan(oSB, 1 + iTranslateX, iTranslateY, isActive, scrollableY);
        } else {
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + iTranslateX, this.getPosY() + (this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - CFG.CIV_FLAG_HEIGHT - CFG.PADD * 2) / 2 + CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2 + 1 + iTranslateY, CFG.PADD - 1);
            oSB.setColor(Graph.GRAPH_LINES_DESC);
            IMGManager.getIMG(Images.line33).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + iTranslateX, this.getPosY() + CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2 + 1 + iTranslateY, this.getWidthE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2);
            IMGManager.getIMG(Images.line33).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.iAvaragePosY + iTranslateY, this.getWidthE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2, 1, 0.0f, -this.iButtonsPosX);
            Rectangle clipBounds = new Rectangle(this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + 1 + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - 1, this.getHeightE());
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            if (this.getIsHovered() && this.iHoveredID >= 0) {
                oSB.setColor(Graph.GRAPH_LINES_DESC);
                IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 - CFG.PADD * (this.iHoveredID + 1) - CFG.PADD * this.iHoveredID - this.iDataWidth * (this.iHoveredID + 1) + this.iButtonsPosX + iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + this.getPosY() + iTranslateY, this.iDataWidth + 2, this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false, true);
                oSB.setColor(new Color(Graph.GRAPH_LINES_DESC.r, Graph.GRAPH_LINES_DESC.g, Graph.GRAPH_LINES_DESC.b, 0.025f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 - CFG.PADD * (this.iHoveredID + 1) - CFG.PADD * this.iHoveredID - this.iDataWidth * (this.iHoveredID + 1) + this.iButtonsPosX + iTranslateX, -IMGManager.getIMG(Images.sliderGradient).getHeight() + this.getPosY() + iTranslateY, (this.iDataWidth + 2) / 4, this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() + (this.iDataWidth + 2) - (this.iDataWidth + 2) / 4 - 1 - CFG.PADD * (this.iHoveredID + 1) - CFG.PADD * this.iHoveredID - this.iDataWidth * (this.iHoveredID + 1) + this.iButtonsPosX + iTranslateX, -IMGManager.getIMG(Images.sliderGradient).getHeight() + this.getPosY() + iTranslateY, (this.iDataWidth + 2) / 4, this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), true, false);
                oSB.setColor(Color.WHITE);
            }
            if (this.splitBy100) {
                for (int i = 0; i < this.iValuesSize; ++i) {
                    if (!this.lValues.get(i).getInView()) continue;
                    this.lValues.get(i).drawData_ONLY_SPLTTED(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * (i + 1) - CFG.PADD * i - this.iDataWidth * (i + 1) + this.iButtonsPosX + iTranslateX, this.getPosY() + iTranslateY, this.iDataWidth, this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), this.verticalInfo.getColors());
                }
            } else {
                for (int i = 0; i < this.iValuesSize; ++i) {
                    if (!this.lValues.get(i).getInView()) continue;
                    this.lValues.get(i).drawData(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * (i + 1) - CFG.PADD * i - this.iDataWidth * (i + 1) + this.iButtonsPosX + iTranslateX, this.getPosY() + iTranslateY, this.iDataWidth, this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), this.verticalInfo.getColors());
                }
            }
            try {
                oSB.flush();
                ScissorStack.popScissors();
            }
            catch (IllegalStateException illegalStateException) {
                
            }
            CFG.fontMain.get(0).getData().setScale(Graph.POINTS_TEXT_SCALE);
            CFG.drawTextDefault(oSB, "" + this.iMaxPoint, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) + iTranslateX, this.getPosY() + CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2 + 1 + iTranslateY - (int)(2.0f * CFG.GUI_SCALE + Graph.POINTS_TEXT_SCALE * (float)CFG.TEXT_HEIGHT_DEFAULT), Graph.DATA_COLOR);
            CFG.drawTextDefault(oSB, this.bDecimal == 0 ? "" + (int)this.fAvaragePoint : "" + (int)this.fAvaragePoint + "." + (this.lessThanTen ? "0" + this.bDecimal : Byte.valueOf(this.bDecimal)), this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + (int)(2.0f * CFG.GUI_SCALE) + iTranslateX, this.getPosY() - (int)(2.0f * CFG.GUI_SCALE) - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * Graph.POINTS_TEXT_SCALE) + this.iAvaragePosY - 1 + iTranslateY, Graph.DATA_COLOR);
            CFG.fontMain.get(0).getData().setScale(1.0f);
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() - 1 + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + iTranslateX, this.getPosY() + iTranslateY, 1, this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2 + CFG.PADD);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 - CFG.PADD + iTranslateX, this.getPosY() + 1 + this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2 + iTranslateY, this.getWidthE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2 + CFG.PADD, 1);
        oSB.setColor(Graph.GRAPH_BORDERS_COLOR);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + iTranslateX, this.getPosY() + iTranslateY, 1, this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2 + CFG.PADD);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2 + iTranslateY, this.getWidthE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2 + CFG.PADD, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD + iTranslateX, this.getPosY() + 1 + iTranslateY, CFG.PADD);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() - 1 + this.getWidthE() + iTranslateX, this.getPosY() + 1 + iTranslateY, 1, CFG.PADD - 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + 1 + iTranslateX, this.getPosY() + 1 + iTranslateY, CFG.PADD - 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 + iTranslateX, this.getPosY() + this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - CFG.PADD + 1 + iTranslateY, 1, CFG.PADD - 1);
        oSB.setColor(Color.WHITE);
    }

    private final void drawStatisticsBegan(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        CFG.fontMain.get(0).getData().setScale(0.7f);
        int tempOffsetX = 0;
        this.drawStatisticsBoxTitle(oSB, this.sTextX, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + iTranslateX, this.getPosY() + iTranslateY, this.getStatisticsWidth() * 2);
        tempOffsetX += this.getStatisticsWidth() * 2;
        for (int i = 0; i < this.verticalInfo.getTextSize(); ++i) {
            this.drawStatisticsBoxTitle(oSB, this.verticalInfo.getText(i), this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, this.getPosY() + iTranslateY, this.getStatisticsWidth());
            tempOffsetX += this.getStatisticsWidth();
        }
        this.drawStatisticsBoxTitle(oSB, this.drawStatisticsData.getTotal(), this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + tempOffsetX + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE() - tempOffsetX - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2));
        Rectangle clipBounds = new Rectangle(this.getPosXE() + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 + 1 + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - 2 - iTranslateY - (this.getHeightE() - (((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * 2 + 1)), this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - 1, this.getHeightE() - (((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * 2 + 1));
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        this.drawStatisticsEnd(oSB, iTranslateX, this.iButtonsPosY + iTranslateY, isActive, scrollableY, tempOffsetX);
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
        oSB.setColor(Graph.GRAPH_LINES_COLOR);
        for (int i = -1; i < this.verticalInfo.getTextSize() - 1; ++i) {
            IMGManager.getIMG(Images.line32Vertical).draw2O(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + this.getStatisticsWidth() * 2 + this.getStatisticsWidth() * (i + 1) - 1 + iTranslateX, this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * 2, false, true);
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + this.getStatisticsWidth() * 2 + this.getStatisticsWidth() * (this.verticalInfo.getTextSize() - 1 + 1) - 1 + iTranslateX, this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + iTranslateY, 1, this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * 2, false, true);
        oSB.setColor(Color.WHITE);
    }

    private final void drawStatisticsEnd(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY, int tempOffsetX) {
        float tempFlagScale = (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / (float)CFG.CIV_FLAG_HEIGHT;
        for (int i = 0; i < this.iValuesSize; ++i) {
            if (!this.lValues.get(i).getInView()) continue;
            if (i % 2 == 0) {
                this.drawStatisticsRowBG(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + iTranslateX, this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY, this.getWidthE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2);
            }
            if (this.getIsHovered() && i == this.iHoveredID - 1) {
                this.drawStatisticsRowHoverBG(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + iTranslateX, this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY, this.getWidthE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2);
            }
            this.drawStatisticsRowLine(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + iTranslateX, this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY, this.getWidthE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2);
            oSB.setColor(Color.WHITE);
            CFG.core.getCiv(this.drawStatisticsData.getStatsLPCivFlagID(i)).getFlagC().drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)CFG.CIV_COLOR_W) + CFG.PADD * 2) + iTranslateX, this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + CFG.PADD - CFG.core.getCiv(this.drawStatisticsData.getStatsLPCivFlagID(i)).getFlagC().getHeight() + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * tempFlagScale), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * tempFlagScale));
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)CFG.CIV_COLOR_W) + CFG.PADD * 2) + iTranslateX, this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + CFG.PADD - CFG.CIV_FLAG_HEIGHT + iTranslateY, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * tempFlagScale), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * tempFlagScale));
            this.drawStatisticsValue2(oSB, this.drawStatisticsData.getStatsLP(i), this.getPosXE() + (int)((float)CFG.CIV_FLAG_WIDTH * tempFlagScale + (float)CFG.CIV_COLOR_W) + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + iTranslateX, this.getPosY() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * (i + 1) + iTranslateY, this.getStatisticsWidth() * 2 - (int)((float)CFG.CIV_FLAG_WIDTH * tempFlagScale + (float)CFG.CIV_COLOR_W));
            this.drawStatisticsData.draw(oSB, i, tempOffsetX, iTranslateX, iTranslateY);
        }
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    private final void drawStatisticsRowLine(SpriteBatch oSB, int nPosX, int nPosY, int nWidth) {
        oSB.setColor(Graph.GRAPH_LINES_COLOR);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX, nPosY + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2, nWidth, 1);
    }

    private final void drawStatisticsRowBG(SpriteBatch oSB, int nPosX, int nPosY, int nWidth) {
        oSB.setColor(new Color(0.05f, 0.05f, 0.05f, 0.7f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY, nWidth - 1, (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2);
    }

    private final void drawStatisticsRowHoverBG(SpriteBatch oSB, int nPosX, int nPosY, int nWidth) {
        oSB.setColor(new Color(Graph.GRAPH_LINES_DESC.r, Graph.GRAPH_LINES_DESC.g, Graph.GRAPH_LINES_DESC.b, 0.1f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY, nWidth - 1, (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2);
    }

    private final void drawStatisticsBoxTitle(SpriteBatch oSB, String nText, int nPosX, int nPosY, int nWidth) {
        oSB.setColor(new Color(0.05f, 0.05f, 0.05f, 0.7f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY, nWidth, (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2);
        oSB.setColor(new Color(0.094f, 0.094f, 0.4f, 0.6f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight() + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) / 2, nWidth, ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) / 2, false, true);
        oSB.setColor(Graph.GRAPH_BORDERS_COLOR);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2, nWidth, 1);
        oSB.setColor(Graph.GRAPH_LINES_COLOR);
        IMGManager.getIMG(Images.line32Vertical).draw2O(oSB, nPosX - 1 + nWidth, nPosY - IMGManager.getIMG(Images.line32Vertical).getHeight(), 1, (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2);
        Rectangle clipBounds = new Rectangle(nPosX, CFG.GAMEHEIGHT - nPosY - (((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f)) + CFG.PADD * 2), nWidth - CFG.PADD, ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f)) + CFG.PADD * 2);
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        CFG.drawTextDefault(oSB, nText, nPosX + CFG.PADD, nPosY + CFG.PADD, Graph.TEXT_COLOR);
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
    }

    private final void drawStatisticsValue(SpriteBatch oSB, String nText, int nPosX, int nPosY) {
        CFG.drawTextDefault(oSB, nText, nPosX + CFG.PADD, nPosY + CFG.PADD, new Color(1.0f, 1.0f, 1.0f, 0.45f));
    }

    private final void drawStatisticsValueWithFlag(SpriteBatch oSB, String nText, int nCivID, int nPosX, int nPosY) {
        float tempFlagScale = (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / (float)CFG.CIV_FLAG_HEIGHT;
        oSB.setColor(Color.WHITE);
        CFG.core.getCiv(nCivID).getFlagC().drawO(oSB, nPosX + CFG.PADD, nPosY + CFG.PADD - CFG.core.getCiv(nCivID).getFlagC().getHeight(), (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * tempFlagScale), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * tempFlagScale));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, nPosX + CFG.PADD, nPosY + CFG.PADD - CFG.CIV_FLAG_HEIGHT, (int)Math.ceil((float)CFG.CIV_FLAG_WIDTH * tempFlagScale), (int)Math.ceil((float)CFG.CIV_FLAG_HEIGHT * tempFlagScale));
        CFG.drawTextDefault(oSB, nText, nPosX + CFG.PADD * 2 + (int)((float)CFG.CIV_FLAG_WIDTH * tempFlagScale), nPosY + CFG.PADD, new Color(1.0f, 1.0f, 1.0f, 0.45f));
    }

    private final void drawStatisticsValue2(SpriteBatch oSB, String nText, int nPosX, int nPosY, int nWidth) {
        Rectangle clipBounds = new Rectangle(nPosX, CFG.GAMEHEIGHT - nPosY - this.getHeightE(), nWidth - CFG.PADD, this.getHeightE());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        CFG.drawTextDefault(oSB, nText, nPosX + CFG.CIV_COLOR_W, nPosY + CFG.PADD, Graph.DATA_COLOR);
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
    }

    private final int getStatisticsWidth() {
        return (this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) / (this.verticalInfo.getTextSize() + 3);
    }

    public final void updateInView() {
        if (this.statisticsMode) {
            for (int i = 0; i < this.iValuesSize; ++i) {
                if (this.getButtonsPosY(i) + this.iButtonsPosY >= (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 && this.getButtonsPosY(i) + this.iButtonsPosY <= this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * 2) {
                    this.lValues.get(i).setInView(true);
                    continue;
                }
                if (this.getButtonsPosY(i) + this.iButtonsPosY + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) >= 0 && this.getButtonsPosY(i) + ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) + this.iButtonsPosY <= this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * 2) {
                    this.lValues.get(i).setInView(true);
                    continue;
                }
                this.lValues.get(i).setInView(false);
            }
        } else {
            for (int i = 0; i < this.iValuesSize; ++i) {
                if (this.getButtonsPosX(i) + this.iButtonsPosX >= (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 && this.getButtonsPosX(i) + this.iButtonsPosX <= this.getWidthE()) {
                    this.lValues.get(i).setInView(true);
                    continue;
                }
                if (this.getButtonsPosX(i) - this.iDataWidth + this.iButtonsPosX >= (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2 && this.getButtonsPosX(i) - this.iDataWidth + this.iButtonsPosX <= this.getWidthE()) {
                    this.lValues.get(i).setInView(true);
                    continue;
                }
                this.lValues.get(i).setInView(false);
            }
        }
    }

    private final int getButtonsPosX(int i) {
        return this.getWidthE() - this.iDataWidth * i - CFG.PADD - CFG.PADD * 2 * i;
    }

    private final int getButtonsPosY(int i) {
        return (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * i;
    }

    private final void updateMoveable() {
        if (this.statisticsMode) {
            if (this.getButtonsPosY(this.iValuesSize) > this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f + (float)(CFG.PADD * 2)) * 2) {
                this.moveable = true;
            } else {
                this.moveable = false;
                this.iButtonsPosY = 0;
            }
        } else if (this.getButtonsWidth() > this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2)) {
            this.moveable = true;
        } else {
            this.moveable = false;
            this.iButtonsPosX = 0;
        }
    }

    @Override
    public boolean getIsScrollable() {
        return this.moveable;
    }

    @Override
    public void srollByWheel(int nScoll) {
        this.scrollModeY = false;
        this.setCurr(this.getCurr() + nScoll);
    }

    private final int getButtonsWidth() {
        return this.iDataWidth * this.iValuesSize + CFG.PADD * 2 * (this.iValuesSize - 1);
    }

    public final void buildData() {
        int i;
        int nOfCivID;
        int i2;
        if (this.lValues.size() == 0) {
            return;
        }
        ArrayList<String> nTexts = new ArrayList<String>();
        ArrayList<Color> nColors = new ArrayList<Color>();
        if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.NUM_OF_PROVINCES_BY_CONTINENT) {
            for (i2 = 0; i2 < this.iValuesSize; ++i2) {
                this.lValues.get(i2).buildContintentData();
            }
            for (i2 = 0; i2 < CFG.map.getMapContinents().getContinentsSize(); ++i2) {
                if (i2 == CFG.map.getMapContinents().getOceanContinentID()) continue;
                nTexts.add(CFG.map.getMapContinents().getName(i2));
                nColors.add(CFG.map.getMapContinents().getColor(i2));
            }
            this.verticalInfo = new Graph_Vertical_Info(nTexts, nColors, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), true);
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.POPULATION_OF_CIVILIZATIONS) {
            for (i2 = 0; i2 < this.iValuesSize; ++i2) {
                this.lValues.get(i2).buildPopulationData();
            }
            nTexts.add(CFG.lang.get("Native"));
            nColors.add(CFG.COLOR_POP_GRADIENT[(CFG.COLOR_POP_GRADIENT.length - 1) * 3 / 4]);
            nTexts.add(CFG.lang.get("Second"));
            nColors.add(CFG.COLOR_POP_GRADIENT[(CFG.COLOR_POP_GRADIENT.length - 1) / 4]);
            nTexts.add(CFG.lang.get("Rest"));
            nColors.add(CFG.COLOR_POP_GRADIENT[0]);
            this.verticalInfo = new Graph_Vertical_Info(nTexts, nColors, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false);
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.POPULATION_OF_CIVILIZATION_ALL_AROUND_WORLD) {
            nOfCivID = 0;
            nOfCivID = CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 ? CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() : CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
            for (i = 0; i < this.iValuesSize; ++i) {
                this.lValues.get(i).buildPopulationOfCivilizationAllAroundTheWorldData(nOfCivID);
            }
            for (i = this.lValues.size() - 1; i >= 0; --i) {
                if (this.lValues.get(i).getValue() != 0) continue;
                this.lValues.remove(i);
            }
            this.iValuesSize = this.lValues.size();
            nTexts.add("[" + CFG.core.getCiv(nOfCivID).getCivName() + "]");
            nColors.add(new Color((float)CFG.core.getCiv(nOfCivID).getR() / 255.0f, (float)CFG.core.getCiv(nOfCivID).getG() / 255.0f, (float)CFG.core.getCiv(nOfCivID).getB() / 255.0f, 1.0f));
            this.verticalInfo = new Graph_Vertical_Info(nTexts, nColors, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false);
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.ARMIES) {
            for (i2 = 0; i2 < this.iValuesSize; ++i2) {
                this.lValues.get(i2).buildArmiesData();
            }
            nTexts.add(CFG.lang.get("ArmySize"));
            nColors.add(new Color(0.75f, 0.11f, 0.08f, 1.0f));
            this.verticalInfo = new Graph_Vertical_Info(nTexts, nColors, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false);
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.ARMY_PER_CAPITA) {
            for (i2 = 0; i2 < this.iValuesSize; ++i2) {
                this.lValues.get(i2).buildArmyPerCapitaData();
            }
            nTexts.add(CFG.lang.get("ArmyPerCapita"));
            nColors.add(new Color(0.7f, 0.18f, 0.14f, 1.0f));
            this.verticalInfo = new Graph_Vertical_Info(nTexts, nColors, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false);
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.TECHNOLOGY_LEVELS) {
            for (i2 = 0; i2 < this.iValuesSize; ++i2) {
                this.lValues.get(i2).buildTechnologyLevelsData();
            }
            nTexts.add(CFG.lang.get("TechnologyLevels"));
            nColors.add(CFG.COLOR_TECHNOLOGY_LEVEL[(CFG.COLOR_TECHNOLOGY_LEVEL.length - 1) * 3 / 4]);
            this.verticalInfo = new Graph_Vertical_Info(nTexts, nColors, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false);
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.POPULATION_BY_PROVINCES) {
            for (i2 = 0; i2 < this.iValuesSize; ++i2) {
                this.lValues.get(i2).buildPopulationByProvincesData();
            }
            nTexts.add(CFG.lang.get("Population"));
            nColors.add(CFG.COLOR_POP_GRADIENT[(CFG.COLOR_POP_GRADIENT.length - 1) * 3 / 4]);
            this.verticalInfo = new Graph_Vertical_Info(nTexts, nColors, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false);
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.ECONOMY_BY_PROVINCES) {
            for (i2 = 0; i2 < this.iValuesSize; ++i2) {
                this.lValues.get(i2).buildEconomyByProvincesData();
            }
            nTexts.add(CFG.lang.get("Economy"));
            nColors.add(CFG.COLOR_ECONOMY_GRADIENT[(CFG.COLOR_ECONOMY_GRADIENT.length - 1) * 3 / 4]);
            this.verticalInfo = new Graph_Vertical_Info(nTexts, nColors, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false);
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.CONQUERED_PROVINCES) {
            for (i2 = 0; i2 < this.iValuesSize; ++i2) {
                this.lValues.get(i2).buildConqueredProvincesData();
            }
            nTexts.add(CFG.lang.get("ConqueredProvinces"));
            nColors.add(CFG.COLOR_ECONOMY_GRADIENT[(CFG.COLOR_ECONOMY_GRADIENT.length - 1) * 3 / 4]);
            this.verticalInfo = new Graph_Vertical_Info(nTexts, nColors, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false);
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.CONSTRUCTED_BUILDINGS) {
            for (i2 = 0; i2 < this.iValuesSize; ++i2) {
                this.lValues.get(i2).buildConstructedBuildingsData();
            }
            nTexts.add(CFG.lang.get("ConstructedBuildings"));
            nColors.add(CFG.COLOR_ECONOMY_GRADIENT[(CFG.COLOR_ECONOMY_GRADIENT.length - 1) * 3 / 4]);
            this.verticalInfo = new Graph_Vertical_Info(nTexts, nColors, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false);
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.ARMY_BY_PROVINCES) {
            for (i2 = 0; i2 < this.iValuesSize; ++i2) {
                this.lValues.get(i2).buildArmyByProvincesData();
            }
            nTexts.add(CFG.lang.get("Army"));
            nColors.add(new Color(0.7f, 0.18f, 0.14f, 1.0f));
            this.verticalInfo = new Graph_Vertical_Info(nTexts, nColors, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false);
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.TECHNOLOGY_LEVELS_BY_PROVINCES) {
            for (i2 = 0; i2 < this.iValuesSize; ++i2) {
                this.lValues.get(i2).buildTechnologyLevelsByProvincesData();
            }
            nTexts.add(CFG.lang.get("TechnologyLevels"));
            nColors.add(CFG.COLOR_TECHNOLOGY_LEVEL[(CFG.COLOR_TECHNOLOGY_LEVEL.length - 1) * 3 / 4]);
            this.verticalInfo = new Graph_Vertical_Info(nTexts, nColors, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false);
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.ECONOMY_OF_CIVILIZATIONS) {
            for (i2 = 0; i2 < this.iValuesSize; ++i2) {
                this.lValues.get(i2).buildEconomyData();
            }
            nTexts.add(CFG.lang.get("Economy"));
            nColors.add(CFG.COLOR_ECONOMY_GRADIENT[(CFG.COLOR_ECONOMY_GRADIENT.length - 1) * 3 / 4]);
            this.verticalInfo = new Graph_Vertical_Info(nTexts, nColors, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false);
        } else if (this.GRAPH_DATA_TYPE == Graph_Vertical_Data_Type.POPULATION_OF_CIVILIZATION_BY_NATIONALITIES) {
            nOfCivID = 0;
            nOfCivID = CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 ? CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() : CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
            for (i = 0; i < this.iValuesSize; ++i) {
                this.lValues.get(i).buildPopulationOfCivByNationalitiesData(nOfCivID);
            }
            for (i = this.lValues.size() - 1; i >= 0; --i) {
                if (this.lValues.get(i).getValue() != 0) continue;
                this.lValues.remove(i);
            }
            this.iValuesSize = this.lValues.size();
            nTexts.add("[" + CFG.core.getCiv(nOfCivID).getCivName() + "]");
            nColors.add(new Color((float)CFG.core.getCiv(nOfCivID).getR() / 255.0f, (float)CFG.core.getCiv(nOfCivID).getG() / 255.0f, (float)CFG.core.getCiv(nOfCivID).getB() / 255.0f, 1.0f));
            this.verticalInfo = new Graph_Vertical_Info(nTexts, nColors, this.getWidthE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2), false);
        }
        ArrayList<Graph_Vertical_Data> tempData = new ArrayList<Graph_Vertical_Data>();
        for (i = 0; i < this.iValuesSize; ++i) {
            tempData.add(this.lValues.get(i));
        }
        this.lValues.clear();
        while (tempData.size() > 0) {
            int tempMaxID = 0;
            for (int i3 = 1; i3 < tempData.size(); ++i3) {
                if (((Graph_Vertical_Data)tempData.get(i3)).getValue() <= ((Graph_Vertical_Data)tempData.get(tempMaxID)).getValue()) continue;
                tempMaxID = i3;
            }
            this.lValues.add((Graph_Vertical_Data)tempData.get(tempMaxID));
            tempData.remove(tempMaxID);
        }
        try {
            this.iMinPoint = this.iMaxPoint = this.lValues.get(0).getValue();
        }
        catch (IndexOutOfBoundsException ex) {
            this.iMinPoint = 0;
        }
        this.fAvaragePoint = 0.0f;
        long tempAvarage = 0L;
        int tempAvarageSize = 0;
        for (int i4 = 0; i4 < this.iValuesSize; ++i4) {
            if (this.iMaxPoint < this.lValues.get(i4).getValue()) {
                this.iMaxPoint = this.lValues.get(i4).getValue();
            }
            if (this.iMinPoint > this.lValues.get(i4).getValue()) {
                this.iMinPoint = this.lValues.get(i4).getValue();
            }
            if (this.lValues.get(i4).getValue() <= 0) continue;
            ++tempAvarageSize;
            tempAvarage += (long)this.lValues.get(i4).getValue();
        }
        this.fAvaragePoint = (float)tempAvarage / (float)tempAvarageSize;
        this.iAvaragePosY = (int)((float)(this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2) - (float)(this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2) * (100.0f * this.fAvaragePoint) / (float)(this.iMaxPoint - this.iMinPoint) / 100.0f);
        this.roundAverage();
        this.updateMoveable();
        this.updateInView();
        this.countValuesTotal();
    }

    public final void countValuesTotal() {
        this.iValuesTotal = 0;
        for (int i = 0; i < this.iValuesSize; ++i) {
            this.iValuesTotal += this.lValues.get(i).getValue();
        }
    }

    public final void buildValuesHeights() {
        for (int i = 0; i < this.iValuesSize; ++i) {
            this.lValues.get(i).buildHeights(this.getHeightE() - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2 - (CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2), this.iMaxPoint);
        }
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
    public boolean isMoveable() {
        return this.moveable;
    }

    @Override
    public int getCurr() {
        if (this.statisticsMode) {
            return this.iButtonsPosY;
        }
        return this.iButtonsPosX;
    }

    @Override
    public void setCurr(int nButtonsPosX) {
        if (this.statisticsMode) {
            if (nButtonsPosX > 0) {
                nButtonsPosX = 0;
                CFG.menus.setUpdateSliderMenuPosY(true);
                this.scrollModeY = false;
            } else if (nButtonsPosX < -((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * this.iValuesSize + (this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * 2)) {
                nButtonsPosX = -((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * this.iValuesSize + (this.getHeightE() - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + CFG.PADD * 2) * 2);
                CFG.menus.setUpdateSliderMenuPosY(true);
                this.scrollModeY = false;
            }
            if (this.iButtonsPosY != nButtonsPosX) {
                this.iButtonsPosY = nButtonsPosX;
                this.updateInView();
                CFG.setRenderO(true);
            }
        } else {
            if (nButtonsPosX < 0) {
                nButtonsPosX = 0;
                CFG.menus.setUpdateSliderMenuPosX(true);
                this.scrollModeY = false;
            } else if (nButtonsPosX > this.getButtonsWidth() - this.getWidthE() + this.iDataWidth + CFG.PADD - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2)) {
                nButtonsPosX = this.getButtonsWidth() - this.getWidthE() + this.iDataWidth + CFG.PADD - ((int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) - CFG.PADD * 2);
                CFG.menus.setUpdateSliderMenuPosX(true);
                this.scrollModeY = false;
            }
            if (this.iButtonsPosX != nButtonsPosX) {
                this.iButtonsPosX = nButtonsPosX;
                this.updateInView();
                CFG.setRenderO(true);
            }
        }
    }

    @Override
    public final void scrollTheMenu() {
        if (this.moveable && this.iScrollPosX > 0 && this.iScrollPosX2 > 0 && (float)Math.abs(this.iScrollPosX - this.iScrollPosX2) > 3.0f * CFG.DENSITY) {
            this.fScrollNewMenuPosY = (float)(this.iScrollPosX - this.iScrollPosX2) * 1.25f;
            this.scrollModeY = true;
        }
    }

    @Override
    public final void setScrollPosY(int iScrollPosX) {
        this.iScrollPosX2 = this.iScrollPosX;
        this.iScrollPosX = iScrollPosX;
    }

    @Override
    public void setTypeOfButton(ButtonM.TypeOfButton typeOfButton) {
        this.iScrollPosX2 = -1;
        this.iScrollPosX = -1;
        this.scrollModeY = false;
    }

    @Override
    public boolean getAnotherView() {
        return this.statisticsMode;
    }

    @Override
    public void setAnotherView(boolean inAnotherView) {
        this.statisticsMode = inAnotherView;
        this.scrollModeY = false;
        this.iButtonsPosY = 0;
        this.iButtonsPosX = 0;
        if (!this.statisticsMode) {
            for (int i = 0; i < this.iValuesSize; ++i) {
                this.lValues.get(i).resetAnimation();
            }
        }
        this.updateMoveable();
        this.updateInView();
        this.setHoveredID(-1);
    }

    @Override
    public void setVisibleE(boolean isVisible) {
        super.setVisibleE(isVisible);
        this.setHoveredID(-1);
    }

    static interface DrawStatisticsData {
        public void draw(SpriteBatch var1, int var2, int var3, int var4, int var5);

        public String getTotal();

        public String getStatsLP(int var1);

        public int getStatsLPCivFlagID(int var1);
    }
}

