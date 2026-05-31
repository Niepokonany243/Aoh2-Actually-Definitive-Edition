/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Graph;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph;
import age.of.civilizations2.jakowski.lukasz.Graphs.GraphData;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Data;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Data_Type;
import java.util.ArrayList;

public class Menu_InGame_GraphManager {
    public static int iActiveGraphID = 0;

    public static final void setActiveGraphID(int nID) {
        if (iActiveGraphID != nID) {
            iActiveGraphID = nID;
        }
        if (iActiveGraphID == 0) {
            ArrayList<Graph_Vertical_Data> tempData = new ArrayList<Graph_Vertical_Data>();
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.FOG_OF_WAR >= 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i)) continue;
                tempData.add(new Graph_Vertical_Data(i));
            }
            Menu_InGame_GraphManager.updateGraph(new Graph_Vertical(Graph_Vertical_Data_Type.NUM_OF_PROVINCES_BY_CONTINENT, CFG.lang.get("Civilizations"), CFG.lang.get("Provinces"), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosXE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosY(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getWidthE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getHeightE(), true, tempData));
        } else if (iActiveGraphID == 1) {
            ArrayList<Graph_Vertical_Data> tempL = new ArrayList<Graph_Vertical_Data>();
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.FOG_OF_WAR >= 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i)) continue;
                tempL.add(new Graph_Vertical_Data(i));
            }
            Menu_InGame_GraphManager.updateGraph(new Graph_Vertical(Graph_Vertical_Data_Type.POPULATION_OF_CIVILIZATIONS, CFG.lang.get("Civilizations"), CFG.lang.get("Population"), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosXE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosY(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getWidthE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getHeightE(), true, tempL));
        } else if (iActiveGraphID == 10) {
            ArrayList<Graph_Vertical_Data> tempL = new ArrayList<Graph_Vertical_Data>();
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.FOG_OF_WAR >= 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i)) continue;
                tempL.add(new Graph_Vertical_Data(i));
            }
            Menu_InGame_GraphManager.updateGraph(new Graph_Vertical(Graph_Vertical_Data_Type.CONQUERED_PROVINCES, CFG.lang.get("Civilizations"), CFG.lang.get("ConqueredProvinces"), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosXE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosY(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getWidthE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getHeightE(), true, tempL));
        } else if (iActiveGraphID == 11) {
            ArrayList<Graph_Vertical_Data> tempL = new ArrayList<Graph_Vertical_Data>();
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.FOG_OF_WAR >= 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i)) continue;
                tempL.add(new Graph_Vertical_Data(i));
            }
            Menu_InGame_GraphManager.updateGraph(new Graph_Vertical(Graph_Vertical_Data_Type.CONSTRUCTED_BUILDINGS, CFG.lang.get("Civilizations"), CFG.lang.get("ConstructedBuildings"), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosXE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosY(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getWidthE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getHeightE(), true, tempL));
        } else if (iActiveGraphID == 13) {
            ArrayList<Graph_Vertical_Data> tempL = new ArrayList<Graph_Vertical_Data>();
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.FOG_OF_WAR >= 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i)) continue;
                tempL.add(new Graph_Vertical_Data(i));
            }
            Menu_InGame_GraphManager.updateGraph(new Graph_Vertical(Graph_Vertical_Data_Type.ECONOMY_OF_CIVILIZATIONS, CFG.lang.get("Civilizations"), CFG.lang.get("Economy"), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosXE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosY(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getWidthE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getHeightE(), true, tempL));
        } else if (iActiveGraphID == 2) {
            ArrayList<Graph_Vertical_Data> tempL = new ArrayList<Graph_Vertical_Data>();
            for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.FOG_OF_WAR >= 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i)) continue;
                tempL.add(new Graph_Vertical_Data(i));
            }
            Menu_InGame_GraphManager.updateGraph(new Graph_Vertical(Graph_Vertical_Data_Type.POPULATION_OF_CIVILIZATION_BY_NATIONALITIES, CFG.lang.get("EthnicGroups"), CFG.lang.get("EthnicGroups"), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosXE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosY(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getWidthE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getHeightE(), true, tempL));
        } else if (iActiveGraphID == 3) {
            ArrayList<Graph_Vertical_Data> tempL = new ArrayList<Graph_Vertical_Data>();
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.FOG_OF_WAR >= 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i)) continue;
                tempL.add(new Graph_Vertical_Data(i));
            }
            Menu_InGame_GraphManager.updateGraph(new Graph_Vertical(Graph_Vertical_Data_Type.TECHNOLOGY_LEVELS, CFG.lang.get("Technology"), CFG.lang.get("Technology"), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosXE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosY(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getWidthE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getHeightE(), true, tempL));
        } else if (iActiveGraphID == 100) {
            ArrayList<Integer> tempCivs = new ArrayList<Integer>();
            tempCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            Menu_InGame_GraphManager.updateGraph(new Graph(CFG.lang.get("Turn"), CFG.lang.get("Income"), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosXE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosY(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getWidthE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getHeightE(), true, tempCivs, 1){

                @Override
                public void loadData(int i) {
                    block7: {
                        try {
                            if (iActiveGraphID == 100) {
                                int nStartTurnID = -1;
                                int jSize = CFG.timelapseManager.timelapseStatsGD.lPlayers_Income.size();
                                for (int j = 0; j < jSize; ++j) {
                                    if (CFG.timelapseManager.timelapseStatsGD.lPlayers_Income.get(j).size() <= CFG.PLAYER_TURN_ID) continue;
                                    nStartTurnID = j;
                                    break;
                                }
                                ArrayList<Integer> tempPoints = new ArrayList<Integer>();
                                if (nStartTurnID >= 0) {
                                    int jSize2 = CFG.timelapseManager.timelapseStatsGD.lPlayers_Income.size();
                                    for (int j = nStartTurnID; j < jSize2; ++j) {
                                        tempPoints.add(CFG.timelapseManager.timelapseStatsGD.lPlayers_Income.get(j).get(CFG.PLAYER_TURN_ID));
                                    }
                                }
                                if (tempPoints.size() > 0) {
                                    this.lData.set(i, new GraphData(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), tempPoints, nStartTurnID));
                                    ((GraphData)this.lData.get(i)).setDrawData(true);
                                    this.updateMoveable();
                                    this.buildGraph();
                                }
                            }
                        }
                        catch (IndexOutOfBoundsException ex) {
                            if (!CFG.LOGs) break block7;
                            CFG.exceptionStack(ex);
                        }
                    }
                }
            });
        } else if (iActiveGraphID == 111) {
            ArrayList<Integer> tempCivs = new ArrayList<Integer>();
            tempCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            Menu_InGame_GraphManager.updateGraph(new Graph(CFG.lang.get("Turn"), CFG.lang.get("Balance"), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosXE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosY(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getWidthE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getHeightE(), true, tempCivs, 1){

                @Override
                public void loadData(int i) {
                    block7: {
                        try {
                            if (iActiveGraphID == 111) {
                                int nStartTurnID = -1;
                                int jSize = CFG.timelapseManager.timelapseStatsGD.lPlayers_Balance.size();
                                for (int j = 0; j < jSize; ++j) {
                                    if (CFG.timelapseManager.timelapseStatsGD.lPlayers_Balance.get(j).size() <= CFG.PLAYER_TURN_ID) continue;
                                    nStartTurnID = j;
                                    break;
                                }
                                ArrayList<Integer> tempPoints = new ArrayList<Integer>();
                                if (nStartTurnID >= 0) {
                                    int jSize2 = CFG.timelapseManager.timelapseStatsGD.lPlayers_Balance.size();
                                    for (int j = nStartTurnID; j < jSize2; ++j) {
                                        tempPoints.add(CFG.timelapseManager.timelapseStatsGD.lPlayers_Balance.get(j).get(CFG.PLAYER_TURN_ID));
                                    }
                                }
                                if (tempPoints.size() > 0) {
                                    this.lData.set(i, new GraphData(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), tempPoints, nStartTurnID));
                                    ((GraphData)this.lData.get(i)).setDrawData(true);
                                    this.updateMoveable();
                                    this.buildGraph();
                                }
                            }
                        }
                        catch (IndexOutOfBoundsException ex) {
                            if (!CFG.LOGs) break block7;
                            CFG.exceptionStack(ex);
                        }
                    }
                }
            });
        } else if (iActiveGraphID == 102) {
            ArrayList<Integer> tempCivs = new ArrayList<Integer>();
            tempCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            Menu_InGame_GraphManager.updateGraph(new Graph(CFG.lang.get("Turn"), CFG.lang.get("MilitaryUpkeep"), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosXE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosY(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getWidthE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getHeightE(), true, tempCivs, 1){

                @Override
                public void loadData(int i) {
                    try {
                        if (iActiveGraphID == 102) {
                            int nStartTurnID = -1;
                            int jSize = CFG.timelapseManager.timelapseStatsGD.lPlayers_MilitarySpendings.size();
                            for (int j = 0; j < jSize; ++j) {
                                if (CFG.timelapseManager.timelapseStatsGD.lPlayers_MilitarySpendings.get(j).size() <= CFG.PLAYER_TURN_ID) continue;
                                nStartTurnID = j;
                                break;
                            }
                            ArrayList<Integer> tempPoints = new ArrayList<Integer>();
                            if (nStartTurnID >= 0) {
                                int jSize2 = CFG.timelapseManager.timelapseStatsGD.lPlayers_MilitarySpendings.size();
                                for (int j = nStartTurnID; j < jSize2; ++j) {
                                    tempPoints.add(CFG.timelapseManager.timelapseStatsGD.lPlayers_MilitarySpendings.get(j).get(CFG.PLAYER_TURN_ID));
                                }
                            }
                            if (tempPoints.size() > 0) {
                                this.lData.set(i, new GraphData(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), tempPoints, nStartTurnID));
                                ((GraphData)this.lData.get(i)).setDrawData(true);
                                this.updateMoveable();
                                this.buildGraph();
                            }
                        }
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        // empty catch block
                    }
                }
            });
        } else if (iActiveGraphID == 106) {
            ArrayList<Integer> tempCivs = new ArrayList<Integer>();
            tempCivs.add(0);
            tempCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            Menu_InGame_GraphManager.updateGraph(new Graph(CFG.lang.get("Turn"), CFG.lang.get("WorldsPopulation"), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosXE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getPosY(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getWidthE(), CFG.menus.getInGame_FlagActionGraph().getMenuElem(0).getHeightE(), true, tempCivs, 2){

                @Override
                public void loadData(int i) {
                    try {
                        if (iActiveGraphID == 106) {
                            if (i == 0) {
                                ArrayList<Integer> tempPoints = new ArrayList<Integer>();
                                int jSize = CFG.timelapseManager.timelapseStatsPopulation.lPopulation.size();
                                for (int j = 0; j < jSize; ++j) {
                                    int tempTurnPop = 0;
                                    for (int k = 0; k < CFG.timelapseManager.timelapseStatsPopulation.lPopulation.get(j).size(); ++k) {
                                        tempTurnPop += CFG.timelapseManager.timelapseStatsPopulation.lPopulation.get(j).get(k).intValue();
                                    }
                                    tempPoints.add(tempTurnPop);
                                }
                                if (tempPoints.size() > 0) {
                                    this.lData.set(i, new GraphData(0, tempPoints, 0));
                                    ((GraphData)this.lData.get(i)).setDrawData(true);
                                    this.updateMoveable();
                                    this.buildGraph();
                                }
                            } else {
                                int nStartTurnID = -1;
                                int jSize = CFG.timelapseManager.timelapseStatsPopulation.lPopulation.size();
                                for (int j = 0; j < jSize; ++j) {
                                    if (CFG.timelapseManager.timelapseStatsPopulation.lPopulation.get(j).size() <= ((GraphData)this.lData.get(i)).getCivID()) continue;
                                    nStartTurnID = j;
                                    break;
                                }
                                ArrayList<Long> tempPoints = new ArrayList<Long>();
                                if (nStartTurnID >= 0) {
                                    int jSize2 = CFG.timelapseManager.timelapseStatsPopulation.lPopulation.size();
                                    for (int j = nStartTurnID; j < jSize2; ++j) {
                                        tempPoints.add((Long)CFG.timelapseManager.timelapseStatsPopulation.lPopulation.get(j).get(((GraphData)this.lData.get(i)).getCivID()));
                                    }
                                }
                                if (tempPoints.size() > 0) {
                                    this.lData.set(i, new GraphData(((GraphData)this.lData.get(i)).getCivID(), tempPoints, nStartTurnID));
                                    ((GraphData)this.lData.get(i)).setDrawData(true);
                                    this.updateMoveable();
                                    this.buildGraph();
                                }
                            }
                        }
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        // empty catch block
                    }
                }
            });
        }
    }

    private static final void updateGraph(MenuElemUI tElem) {
        CFG.menus.getInGame_FlagActionGraph().setMenuElem(0, tElem);
        CFG.menus.getInGame_FlagActionGraph().updateMenuElements_IsInView();
    }
}

