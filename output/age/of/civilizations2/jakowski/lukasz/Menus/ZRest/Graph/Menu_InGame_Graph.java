/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Graph;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph;
import age.of.civilizations2.jakowski.lukasz.Graphs.GraphData;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_RightRank;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Graph
extends Menu {
    public Menu_InGame_Graph() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tMenuWidth = CFG.GAMEWIDTH / 2;
        int tMenuHeight = CFG.GAMEWIDTH / 4;
        try {
            int i;
            int tBest;
            int i2;
            int i3;
            ArrayList<Boolean> tAdded = new ArrayList<Boolean>();
            for (int i4 = 0; i4 < CFG.core.getCivsSize(); ++i4) {
                tAdded.add(CFG.FOG_OF_WAR >= 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i4));
            }
            ArrayList<Integer> tempCivs = new ArrayList<Integer>();
            int nLoad = 1;
            tAdded.set(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), true);
            tempCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            for (i3 = 1; i3 < CFG.core.getCivsSize(); ++i3) {
                if (((Boolean)tAdded.get(i3)).booleanValue() || !CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), i3)) continue;
                tAdded.set(i3, true);
                tempCivs.add(i3);
                ++nLoad;
            }
            for (i3 = 0; i3 < CFG.core.getPlayersSize(); ++i3) {
                if (i3 == CFG.PLAYER_TURN_ID || CFG.core.getCiv(CFG.core.getPlayer(i3).getCivId()).getNumOfProvs() <= 0 || CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getPlayer(i3).getCivId())) continue;
                tAdded.set(CFG.core.getPlayer(i3).getCivId(), true);
                tempCivs.add(CFG.core.getPlayer(i3).getCivId());
                ++nLoad;
            }
            ArrayList<Integer> tempNeighboors = new ArrayList<Integer>();
            for (i2 = 0; i2 < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs(); ++i2) {
                for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i2)).getNeighProvincesSize(); ++j) {
                    if (CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i2)).getNeighProvinces(j)).getCivId() <= 0 || ((Boolean)tAdded.get(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i2)).getNeighProvinces(j)).getCivId())).booleanValue()) continue;
                    tempNeighboors.add(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i2)).getNeighProvinces(j)).getCivId());
                    tAdded.set(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i2)).getNeighProvinces(j)).getCivId(), true);
                    ++nLoad;
                }
            }
            while (tempNeighboors.size() > 0) {
                tBest = 0;
                for (i = 1; i < tempNeighboors.size(); ++i) {
                    if (CFG.core.getCiv((Integer)tempNeighboors.get(tBest)).getNumOfProvs() >= CFG.core.getCiv((Integer)tempNeighboors.get(i)).getNumOfProvs()) continue;
                    tBest = i;
                }
                tempCivs.add((Integer)tempNeighboors.get(tBest));
                tempNeighboors.remove(tBest);
            }
            tempNeighboors.clear();
            for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                if (((Boolean)tAdded.get(i2)).booleanValue()) continue;
                tempNeighboors.add(i2);
            }
            if (Menu_InGame_FA_RightRank.iViewMode == 0) {
                while (tempNeighboors.size() > 0) {
                    tBest = 0;
                    for (i = 1; i < tempNeighboors.size(); ++i) {
                        if (CFG.core.getCiv((Integer)tempNeighboors.get(tBest)).getNumOfProvs() >= CFG.core.getCiv((Integer)tempNeighboors.get(i)).getNumOfProvs()) continue;
                        tBest = i;
                    }
                    tempCivs.add((Integer)tempNeighboors.get(tBest));
                    tempNeighboors.remove(tBest);
                }
            } else if (Menu_InGame_FA_RightRank.iViewMode == 1) {
                ArrayList<Integer> tempPop = new ArrayList<Integer>();
                for (i = 0; i < tempNeighboors.size(); ++i) {
                    tempPop.add((int)Math.max(1L, CFG.core.getCiv((Integer)tempNeighboors.get(i)).countPop()));
                }
                while (tempNeighboors.size() > 0) {
                    int tBest2 = 0;
                    for (int i5 = 1; i5 < tempNeighboors.size(); ++i5) {
                        if ((Integer)tempPop.get(tBest2) >= (Integer)tempPop.get(i5)) continue;
                        tBest2 = i5;
                    }
                    tempCivs.add((Integer)tempNeighboors.get(tBest2));
                    tempNeighboors.remove(tBest2);
                    tempPop.remove(tBest2);
                }
            } else if (Menu_InGame_FA_RightRank.iViewMode == 2) {
                while (tempNeighboors.size() > 0) {
                    tBest = 0;
                    for (i = 1; i < tempNeighboors.size(); ++i) {
                        if (!(CFG.core.getCiv((Integer)tempNeighboors.get(tBest)).getTechLevel() < CFG.core.getCiv((Integer)tempNeighboors.get(i)).getTechLevel())) continue;
                        tBest = i;
                    }
                    tempCivs.add((Integer)tempNeighboors.get(tBest));
                    tempNeighboors.remove(tBest);
                }
            } else if (Menu_InGame_FA_RightRank.iViewMode == 3) {
                while (tempNeighboors.size() > 0) {
                    tBest = 0;
                    for (i = 1; i < tempNeighboors.size(); ++i) {
                        if (CFG.core.getCiv((Integer)tempNeighboors.get(tBest)).getRankScore() >= CFG.core.getCiv((Integer)tempNeighboors.get(i)).getRankScore()) continue;
                        tBest = i;
                    }
                    tempCivs.add((Integer)tempNeighboors.get(tBest));
                    tempNeighboors.remove(tBest);
                }
            }
            menuElements.add(new Graph(CFG.lang.get("Turn"), Menu_InGame_FA_RightRank.getViewName(), CFG.PADD, CFG.PADD * 2, 150, 225, true, tempCivs, Math.min(nLoad, 1)){

                @Override
                public void loadData(int i) {
                    if (Menu_InGame_FA_RightRank.iViewMode == 0) {
                        super.loadData(i);
                    } else if (Menu_InGame_FA_RightRank.iViewMode == 1) {
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
                                tempPoints.add(CFG.timelapseManager.timelapseStatsPopulation.lPopulation.get(j).get(((GraphData)this.lData.get(i)).getCivID()));
                            }
                        }
                        if (tempPoints.size() > 0) {
                            this.lData.set(i, new GraphData(((GraphData)this.lData.get(i)).getCivID(), tempPoints, nStartTurnID));
                            ((GraphData)this.lData.get(i)).setDrawData(true);
                            this.updateMoveable();
                            this.buildGraph();
                        }
                    } else if (Menu_InGame_FA_RightRank.iViewMode == 2) {
                        int nStartTurnID = -1;
                        int jSize = CFG.timelapseManager.timelapseStatsTechnology.lTechnologyLevel.size();
                        for (int j = 0; j < jSize; ++j) {
                            if (CFG.timelapseManager.timelapseStatsTechnology.lTechnologyLevel.get(j).size() <= ((GraphData)this.lData.get(i)).getCivID()) continue;
                            nStartTurnID = j;
                            break;
                        }
                        ArrayList<Long> tempPoints = new ArrayList<Long>();
                        if (nStartTurnID >= 0) {
                            int jSize3 = CFG.timelapseManager.timelapseStatsTechnology.lTechnologyLevel.size();
                            for (int j = nStartTurnID; j < jSize3; ++j) {
                                tempPoints.add((long)CFG.timelapseManager.timelapseStatsTechnology.lTechnologyLevel.get(j).get(((GraphData)this.lData.get(i)).getCivID()).intValue());
                            }
                        }
                        if (tempPoints.size() > 0) {
                            this.lData.set(i, new GraphData(((GraphData)this.lData.get(i)).getCivID(), tempPoints, nStartTurnID));
                            ((GraphData)this.lData.get(i)).setDrawData(true);
                            this.updateMoveable();
                            this.buildGraph();
                        }
                    } else if (Menu_InGame_FA_RightRank.iViewMode == 3) {
                        int nStartTurnID = -1;
                        int jSize = CFG.timelapseManager.timelapseStatsRank.lRank.size();
                        for (int j = 0; j < jSize; ++j) {
                            if (CFG.timelapseManager.timelapseStatsRank.lRank.get(j).size() <= ((GraphData)this.lData.get(i)).getCivID()) continue;
                            nStartTurnID = j;
                            break;
                        }
                        ArrayList<Long> tempPoints = new ArrayList<Long>();
                        if (nStartTurnID >= 0) {
                            int jSize4 = CFG.timelapseManager.timelapseStatsRank.lRank.size();
                            for (int j = nStartTurnID; j < jSize4; ++j) {
                                tempPoints.add((long)CFG.timelapseManager.timelapseStatsRank.lRank.get(j).get(((GraphData)this.lData.get(i)).getCivID()).intValue());
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

                @Override
                public int getWidthE() {
                    return Menu_InGame_Graph.this.getW() - CFG.PADD * 2;
                }

                @Override
                public int getHeightE() {
                    return Menu_InGame_Graph.this.getH() - CFG.PADD * 4;
                }
            });
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
        }
        this.initMenu(new TitleM(Menu_InGame_FA_RightRank.getViewName(), CFG.BUTTON_H / 2, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.22745098f, 0.4509804f, 0.4509804f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.22745098f, 0.4509804f, 0.4509804f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + (nWidth - 4) - (nWidth - 4) / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.425f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY + 1 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (int)(((float)(nWidth - CFG.PADD * 6) - (float)this.getTextWidth() * 0.8f) / 2.0f), 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth / 2 + CFG.PADD + (int)((float)this.getTextWidth() * 0.8f / 2.0f) + iTranslateX, nPosY + 1 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (int)(((float)(nWidth - CFG.PADD * 6) - (float)this.getTextWidth() * 0.8f) / 2.0f), 1);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + (int)((float)nWidth - (float)this.getTextWidth() * 0.8f) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (int)((float)this.getHeightT() - (float)this.getTextHeight() * 0.8f) / 2, Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, CFG.GAMEWIDTH / 2 - tMenuWidth / 2, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 4, tMenuWidth, tMenuHeight, menuElements, false, true);
        this.updateLang();
        this.getMenuElem(0).setCheckboxSt(true);
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, -IMGManager.getIMG(Images.gameBox).getHeight() + this.getMenuPosY() + iTranslateY, this.getW() - IMGManager.getIMG(Images.gameBox).getWidth() + Core.PADDING * 2, this.getH() + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosX() + Core.PADDING + this.getW() - IMGManager.getIMG(Images.gameBox).getWidth() + iTranslateX, -IMGManager.getIMG(Images.gameBox).getHeight() + this.getMenuPosY() + iTranslateY, IMGManager.getIMG(Images.gameBox).getWidth(), this.getH() + Core.PADDING, true, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            default: 
        }
    }

    public final int getW() {
        return this.getWidthM();
    }

    public final int getH() {
        return this.getHeightM();
    }

    @Override
    public boolean setWidth(int iWidth) {
        boolean out = super.setWidth(iWidth);
        this.getMenuElem(0).setCheckboxSt(true);
        return out;
    }
}

