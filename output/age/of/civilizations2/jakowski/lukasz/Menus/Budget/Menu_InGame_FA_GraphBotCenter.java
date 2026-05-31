/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Budget;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph;
import age.of.civilizations2.jakowski.lukasz.Graphs.GraphData;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_RightRank;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_Top;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_FA_GraphBotCenter
extends Menu {
    public static long lTime = 0L;

    public Menu_InGame_FA_GraphBotCenter() {
        int i;
        int tBest;
        int i2;
        int i3;
        int tempHeight = 0;
        int tempWidth = 0;
        if (CFG.isAndroid() && CFG.LANDSCAPE || CFG.isIOS() || AoCGame.LEFT != 0) {
            tempHeight = CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - CFG.PADD * 2 - CFG.BUTTON_H * 3 / 4;
            tempWidth = (int)((float)Menu_InGame_FA_Top.getWindowWidth() - (float)Menu_InGame_FA_Top.getWindowWidth() * GameValues.gvInGame.FLAG_BUDGET_WIDTH - (float)(CFG.PADD * 2));
        } else {
            tempHeight = CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2 - CFG.BUTTON_H * 3 / 4;
            tempWidth = (int)((float)CFG.GAMEWIDTH - (float)CFG.GAMEWIDTH * GameValues.gvInGame.FLAG_BUDGET_WIDTH - (float)(CFG.PADD * 2));
        }
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
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
        while (!tempNeighboors.isEmpty()) {
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
            while (!tempNeighboors.isEmpty()) {
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
            while (!tempNeighboors.isEmpty()) {
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
            while (!tempNeighboors.isEmpty()) {
                tBest = 0;
                for (i = 1; i < tempNeighboors.size(); ++i) {
                    if (!(CFG.core.getCiv((Integer)tempNeighboors.get(tBest)).getTechLevel() < CFG.core.getCiv((Integer)tempNeighboors.get(i)).getTechLevel())) continue;
                    tBest = i;
                }
                tempCivs.add((Integer)tempNeighboors.get(tBest));
                tempNeighboors.remove(tBest);
            }
        } else if (Menu_InGame_FA_RightRank.iViewMode == 3) {
            while (!tempNeighboors.isEmpty()) {
                tBest = 0;
                for (i = 1; i < tempNeighboors.size(); ++i) {
                    if (CFG.core.getCiv((Integer)tempNeighboors.get(tBest)).getRankScore() >= CFG.core.getCiv((Integer)tempNeighboors.get(i)).getRankScore()) continue;
                    tBest = i;
                }
                tempCivs.add((Integer)tempNeighboors.get(tBest));
                tempNeighboors.remove(tBest);
            }
        }
        try {
            menuElements.add(new Graph(CFG.lang.get("Turn"), Menu_InGame_FA_RightRank.getViewName(), CFG.PADD * 2, CFG.PADD * 2, tempWidth * 7 / 10 - CFG.PADD * 4, tempHeight - tempHeight / 2 - CFG.PADD * 3, true, tempCivs, Math.min(nLoad, CFG.getIsDesktop() ? GameValues.gvInGame.FLAG_MENU_GRAPH_BOT_NUM_OF_CIVS_TO_LOAD : GameValues.gvInGame.FLAG_MENU_GRAPH_BOT_NUM_OF_CIVS_TO_LOAD_MOBILE)){

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
                                tempPoints.add(((Number)CFG.timelapseManager.timelapseStatsPopulation.lPopulation.get(j).get(((GraphData)this.lData.get(i)).getCivID())).longValue());
                            }
                        }
                        if (!tempPoints.isEmpty()) {
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
                                tempPoints.add(((Number)CFG.timelapseManager.timelapseStatsTechnology.lTechnologyLevel.get(j).get(((GraphData)this.lData.get(i)).getCivID())).longValue());
                            }
                        }
                        if (!tempPoints.isEmpty()) {
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
                                tempPoints.add(((Number)CFG.timelapseManager.timelapseStatsRank.lRank.get(j).get(((GraphData)this.lData.get(i)).getCivID())).longValue());
                            }
                        }
                        if (!tempPoints.isEmpty()) {
                            this.lData.set(i, new GraphData(((GraphData)this.lData.get(i)).getCivID(), tempPoints, nStartTurnID));
                            ((GraphData)this.lData.get(i)).setDrawData(true);
                            this.updateMoveable();
                            this.buildGraph();
                        }
                    }
                }
            });
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        menuElements.add(new Button_Transparent(0, 0, tempWidth * 7 / 10, tempHeight - tempHeight / 2, true));
        this.initMenu(null, (int)((float)Menu_InGame_FA_Top.getWindowWidth() - (float)Menu_InGame_FA_Top.getWindowWidth() * (1.0f - GameValues.gvInGame.FLAG_BUDGET_WIDTH) + (float)AoCGame.LEFT), tempHeight / 2 + IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4 + CFG.BUTTON_H * 3 / 4, tempWidth * 7 / 10, tempHeight - tempHeight / 2, menuElements, false, false);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + 225L >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX(), CFG.GAMEHEIGHT - this.getPosY(), this.getWidthM(), -((int)((float)this.getHeightM() * ((float)(System.currentTimeMillis() - lTime) / 225.0f))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.gameTopEdgeLineHorizontal).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLineHorizontal).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM() + Core.PADDING, true, true);
            oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.25f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM());
            oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.75f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 2, CFG.BUTTON_H / 4);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.BUTTON_H / 4, this.getHeightM() - 2);
            oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM() - 2);
            oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.375f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, this.getHeightM() - 2);
            oSB.setColor(Color.WHITE);
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            CFG.setRenderO(true);
            try {
                oSB.flush();
                ScissorStack.popScissors();
            }
            catch (IllegalStateException illegalStateException) {}
        } else {
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.gameTopEdgeLineHorizontal).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLineHorizontal).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM() + Core.PADDING, true, true);
            oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.25f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM());
            oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.75f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 2, CFG.BUTTON_H / 4);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.BUTTON_H / 4, this.getHeightM() - 2);
            oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM() - 2);
            oSB.setColor(Color.WHITE);
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_FlagAction();
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            default: 
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        lTime = System.currentTimeMillis();
    }

    @Override
    public boolean getVisibleM() {
        return CFG.isAndroid() && !CFG.LANDSCAPE ? false : super.getVisibleM();
    }
}

