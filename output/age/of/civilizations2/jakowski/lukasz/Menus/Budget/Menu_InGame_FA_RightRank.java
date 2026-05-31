/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Budget;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Flag_Clip;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Title;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Graph;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_Top;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_FA_RightRank
extends Menu {
    public static int iViewMode = 1;
    public static final int iViewsSize = 3;
    public static int iSort = 1;
    public static long lTime = 0L;

    public static final String getViewName() {
        switch (iViewMode) {
            case 0: {
                return CFG.lang.get("Provinces");
            }
            case 1: {
                return CFG.lang.get("Population");
            }
            case 2: {
                return CFG.lang.get("TechnologyLevel");
            }
            case 3: {
                return CFG.lang.get("RankScore");
            }
        }
        return CFG.lang.get("Provinces");
    }

    public Menu_InGame_FA_RightRank() {
        int j;
        int i;
        ArrayList<Integer> tSorted;
        int tempHeight = 0;
        int tempWidth = 0;
        int tElemHeight2 = Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 2);
        if (CFG.isAndroid() && CFG.LANDSCAPE || CFG.isIOS() || AoCGame.LEFT != 0) {
            tempHeight = CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - CFG.PADD * 2 - CFG.BUTTON_H * 3 / 4;
            tempWidth = (int)((float)Menu_InGame_FA_Top.getWindowWidth() - (float)Menu_InGame_FA_Top.getWindowWidth() * GameValues.gvInGame.FLAG_BUDGET_WIDTH - (float)(CFG.PADD * 2));
        } else {
            tempHeight = CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2 - CFG.BUTTON_H * 3 / 4;
            tempWidth = (int)((float)CFG.GAMEWIDTH - (float)CFG.GAMEWIDTH * GameValues.gvInGame.FLAG_BUDGET_WIDTH - (float)(CFG.PADD * 2));
        }
        int tY = 0;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Stats_Title("<", -1, 1, tY, (int)Math.ceil((float)(tempWidth - tempWidth * 7 / 10 - 3) * 0.2f), CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 6){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Previous"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void actionElem(int iID) {
                if (--iViewMode < 0) {
                    iViewMode = 3;
                }
                CFG.menus.rebuildInGame_FlagActionRightBoth();
            }
        });
        menuElements.add(new Button_Stats_Title(Menu_InGame_FA_RightRank.getViewName(), -1, 1 + (int)Math.ceil((float)(tempWidth - tempWidth * 7 / 10 - 3) * 0.2f), tY, (int)((double)(tempWidth - tempWidth * 7 / 10 - 3) - Math.ceil((float)(tempWidth - tempWidth * 7 / 10 - 3) * 0.2f) * 2.0), CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 6){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                CFG.menus.rebuildInGame_FlagActionRightLeft();
            }
        });
        menuElements.add(new Button_Stats_Title(">", -1, 1 + (int)((double)(tempWidth - tempWidth * 7 / 10 - 3) - Math.ceil((float)(tempWidth - tempWidth * 7 / 10 - 3) * 0.2f)), tY, (int)Math.ceil((float)(tempWidth - tempWidth * 7 / 10 - 3) * 0.2f), CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 6){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Next"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void actionElem(int iID) {
                if (++iViewMode > 3) {
                    iViewMode = 0;
                }
                CFG.menus.rebuildInGame_FlagActionRightBoth();
            }
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Name"), CFG.PADD * 2, 1, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), (tempWidth - tempWidth * 7 / 10) * 3 / 5, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColorE(boolean isActive) {
                return iSort == 0 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SortBy") + ": "));
                nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                if (iSort != 0) {
                    iSort = 0;
                    CFG.menus.rebuildInGame_FlagActionRightRight();
                }
            }
        });
        menuElements.add(new Button_Stats_Title(Menu_InGame_FA_RightRank.getViewName(), CFG.PADD * 2, (tempWidth - tempWidth * 7 / 10) * 3 / 5 + 1, tY, tempWidth - tempWidth * 7 / 10 - (tempWidth - tempWidth * 7 / 10) * 3 / 5 - 3, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColorE(boolean isActive) {
                return iSort == 1 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SortBy") + ": "));
                nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                if (iSort != 1) {
                    iSort = 1;
                    CFG.menus.rebuildInGame_FlagActionRightRight();
                }
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (iViewMode == 0) {
            tSorted = new ArrayList<Integer>();
            if (iSort == 0) {
                for (i = 0; i < CFG.core.getSortedCivsSize(); ++i) {
                    tSorted.add(CFG.core.getSortedCivsAZ(i));
                }
            } else {
                ArrayList<Integer> tempCivs = new ArrayList<Integer>();
                for (int i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                    if (CFG.core.getCiv(i2).getNumOfProvs() <= 0) continue;
                    tempCivs.add(i2);
                }
                while (tempCivs.size() > 0) {
                    int tBest = 0;
                    for (j = 1; j < tempCivs.size(); ++j) {
                        if (CFG.core.getCiv((Integer)tempCivs.get(j)).getNumOfProvs() <= CFG.core.getCiv((Integer)tempCivs.get(tBest)).getNumOfProvs()) continue;
                        tBest = j;
                    }
                    tSorted.add((Integer)tempCivs.get(tBest));
                    tempCivs.remove(tBest);
                }
            }
            for (i = 0; i < tSorted.size(); ++i) {
                menuElements.add(new Button_Stats_Flag_Clip(CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)tSorted.get(i)) ? (Integer)tSorted.get(i) : -1, CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)tSorted.get(i)) ? "" + (i + 1) + ". " + CFG.core.getCiv((Integer)tSorted.get(i)).getCivName() : "" + (i + 1) + ". " + CFG.lang.get("Undiscovered"), CFG.PADD, 1, tY, (tempWidth - tempWidth * 7 / 10) * 3 / 5, tElemHeight2){

                    @Override
                    public Color getColorE(boolean isActive) {
                        return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                    }

                    @Override
                    public void actionElem(int iID) {
                        if (this.getCurr() >= 0) {
                            CFG.menus.menuInGame_FlagActionBotRightLeft_LoadData(this.getCurr());
                        }
                    }

                    @Override
                    public void buildElemHover() {
                        if (this.getCurr() >= 0) {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr(), 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            if (this.getCurr() > 0) {
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).getNumOfProvs()), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_PROVINCES, this.getCurr()));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        } else {
                            ME_Hover_v2.resetAnimation_2();
                            this.menuElemHover = null;
                        }
                    }
                });
                menuElements.add(new ButtonStats("" + CFG.core.getCiv((Integer)tSorted.get(i)).getNumOfProvs(), CFG.PADD, (tempWidth - tempWidth * 7 / 10) * 3 / 5 + 1, tY, tempWidth - tempWidth * 7 / 10 - (tempWidth - tempWidth * 7 / 10) * 3 / 5 - 3, tElemHeight2){});
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        } else if (iViewMode == 1) {
            tSorted = new ArrayList();
            if (iSort == 0) {
                for (int i3 = 0; i3 < CFG.core.getSortedCivsSize(); ++i3) {
                    tSorted.add(CFG.core.getSortedCivsAZ(i3));
                }
            } else {
                ArrayList<Integer> tempCivs = new ArrayList<Integer>();
                ArrayList<Integer> tempCivsPop = new ArrayList<Integer>();
                for (int i4 = 1; i4 < CFG.core.getCivsSize(); ++i4) {
                    if (CFG.core.getCiv(i4).getNumOfProvs() <= 0) continue;
                    tempCivs.add(i4);
                    tempCivsPop.add((int)Math.max(1L, CFG.core.getCiv(i4).countPop()));
                }
                while (tempCivs.size() > 0) {
                    int tBest = 0;
                    for (int j2 = 1; j2 < tempCivs.size(); ++j2) {
                        if ((Integer)tempCivsPop.get(j2) <= (Integer)tempCivsPop.get(tBest)) continue;
                        tBest = j2;
                    }
                    tSorted.add((Integer)tempCivs.get(tBest));
                    tempCivs.remove(tBest);
                    tempCivsPop.remove(tBest);
                }
            }
            for (i = 0; i < tSorted.size(); ++i) {
                menuElements.add(new Button_Stats_Flag_Clip(CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)tSorted.get(i)) ? (Integer)tSorted.get(i) : -1, CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)tSorted.get(i)) ? "" + (i + 1) + ". " + CFG.core.getCiv((Integer)tSorted.get(i)).getCivName() : "" + (i + 1) + ". " + CFG.lang.get("Undiscovered"), CFG.PADD, 1, tY, (tempWidth - tempWidth * 7 / 10) * 3 / 5, tElemHeight2){

                    @Override
                    public Color getColorE(boolean isActive) {
                        return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                    }

                    @Override
                    public void actionElem(int iID) {
                        if (this.getCurr() >= 0) {
                            CFG.menus.menuInGame_FlagActionBotRightLeft_LoadData(this.getCurr());
                        }
                    }

                    @Override
                    public void buildElemHover() {
                        if (this.getCurr() >= 0) {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            if (this.getCurr() > 0) {
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).countPop()), CFG.COLOR_POPULATION));
                                nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_POPULATION, this.getCurr()));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        } else {
                            ME_Hover_v2.resetAnimation_2();
                            this.menuElemHover = null;
                        }
                    }
                });
                menuElements.add(new ButtonStats("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((Integer)tSorted.get(i)).countPop()), CFG.PADD, (tempWidth - tempWidth * 7 / 10) * 3 / 5 + 1, tY, tempWidth - tempWidth * 7 / 10 - (tempWidth - tempWidth * 7 / 10) * 3 / 5 - 3, tElemHeight2){});
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        } else if (iViewMode == 2) {
            tSorted = new ArrayList();
            if (iSort == 0) {
                for (int i5 = 0; i5 < CFG.core.getSortedCivsSize(); ++i5) {
                    tSorted.add(CFG.core.getSortedCivsAZ(i5));
                }
            } else {
                ArrayList<Integer> tempCivs = new ArrayList<Integer>();
                for (int i6 = 1; i6 < CFG.core.getCivsSize(); ++i6) {
                    if (!(CFG.core.getCiv(i6).getTechLevel() > 0.0f)) continue;
                    tempCivs.add(i6);
                }
                while (tempCivs.size() > 0) {
                    int tBest = 0;
                    for (j = 1; j < tempCivs.size(); ++j) {
                        if (!(CFG.core.getCiv((Integer)tempCivs.get(j)).getTechLevel() > CFG.core.getCiv((Integer)tempCivs.get(tBest)).getTechLevel())) continue;
                        tBest = j;
                    }
                    tSorted.add((Integer)tempCivs.get(tBest));
                    tempCivs.remove(tBest);
                }
            }
            for (i = 0; i < tSorted.size(); ++i) {
                menuElements.add(new Button_Stats_Flag_Clip(CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)tSorted.get(i)) ? (Integer)tSorted.get(i) : -1, CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)tSorted.get(i)) ? "" + (i + 1) + ". " + CFG.core.getCiv((Integer)tSorted.get(i)).getCivName() : "" + (i + 1) + ". " + CFG.lang.get("Undiscovered"), CFG.PADD, 1, tY, (tempWidth - tempWidth * 7 / 10) * 3 / 5, tElemHeight2){

                    @Override
                    public Color getColorE(boolean isActive) {
                        return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                    }

                    @Override
                    public void actionElem(int iID) {
                        if (this.getCurr() >= 0) {
                            CFG.menus.menuInGame_FlagActionBotRightLeft_LoadData(this.getCurr());
                        }
                    }

                    @Override
                    public void buildElemHover() {
                        if (this.getCurr() >= 0) {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            if (this.getCurr() > 0) {
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyLevel") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(CFG.core.getCiv(this.getCurr()).getTechLevel(), 100), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        } else {
                            ME_Hover_v2.resetAnimation_2();
                            this.menuElemHover = null;
                        }
                    }
                });
                menuElements.add(new ButtonStats("" + (float)((int)(CFG.core.getCiv((Integer)tSorted.get(i)).getTechLevel() * 100.0f)) / 100.0f, CFG.PADD, (tempWidth - tempWidth * 7 / 10) * 3 / 5 + 1, tY, tempWidth - tempWidth * 7 / 10 - (tempWidth - tempWidth * 7 / 10) * 3 / 5 - 3, tElemHeight2){});
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        } else if (iViewMode == 3) {
            tSorted = new ArrayList();
            if (iSort == 0) {
                for (int i7 = 0; i7 < CFG.core.getSortedCivsSize(); ++i7) {
                    tSorted.add(CFG.core.getSortedCivsAZ(i7));
                }
            } else {
                ArrayList<Integer> tempCivs = new ArrayList<Integer>();
                for (int i8 = 1; i8 < CFG.core.getCivsSize(); ++i8) {
                    if (CFG.core.getCiv(i8).getRankScore() <= 0) continue;
                    tempCivs.add(i8);
                }
                while (tempCivs.size() > 0) {
                    int tBest = 0;
                    for (j = 1; j < tempCivs.size(); ++j) {
                        if (CFG.core.getCiv((Integer)tempCivs.get(j)).getRankScore() <= CFG.core.getCiv((Integer)tempCivs.get(tBest)).getRankScore()) continue;
                        tBest = j;
                    }
                    tSorted.add((Integer)tempCivs.get(tBest));
                    tempCivs.remove(tBest);
                }
            }
            for (i = 0; i < tSorted.size(); ++i) {
                menuElements.add(new Button_Stats_Flag_Clip(CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)tSorted.get(i)) ? (Integer)tSorted.get(i) : -1, CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)tSorted.get(i)) ? "" + (i + 1) + ". " + CFG.core.getCiv((Integer)tSorted.get(i)).getCivName() : "" + (i + 1) + ". " + CFG.lang.get("Undiscovered"), CFG.PADD, 1, tY, (tempWidth - tempWidth * 7 / 10) * 3 / 5, tElemHeight2){

                    @Override
                    public Color getColorE(boolean isActive) {
                        return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                    }

                    @Override
                    public void actionElem(int iID) {
                        if (this.getCurr() >= 0) {
                            CFG.menus.menuInGame_FlagActionBotRightLeft_LoadData(this.getCurr());
                        }
                    }

                    @Override
                    public void buildElemHover() {
                        if (this.getCurr() >= 0) {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            if (this.getCurr() > 0) {
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RankScore") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).getRankScore()), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image(Images.victoryPoints, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_RANK, this.getCurr()));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        } else {
                            ME_Hover_v2.resetAnimation_2();
                            this.menuElemHover = null;
                        }
                    }
                });
                menuElements.add(new ButtonStats("" + CFG.core.getCiv((Integer)tSorted.get(i)).getRankScore(), CFG.PADD, (tempWidth - tempWidth * 7 / 10) * 3 / 5 + 1, tY, tempWidth - tempWidth * 7 / 10 - (tempWidth - tempWidth * 7 / 10) * 3 / 5 - 3, tElemHeight2){});
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        menuElements.add(new Button_Transparent(0, 0, tempWidth - tempWidth * 7 / 10, tempHeight - tempHeight / 2 - 2 < ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() ? ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() : tempHeight - tempHeight / 2 - 2, true));
        this.initMenu(null, (int)((float)Menu_InGame_FA_Top.getWindowWidth() - (float)Menu_InGame_FA_Top.getWindowWidth() * (1.0f - GameValues.gvInGame.FLAG_BUDGET_WIDTH) + (float)(tempWidth * 7 / 10) + (float)AoCGame.LEFT), tempHeight / 2 + IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4 + CFG.BUTTON_H * 3 / 4, tempWidth - tempWidth * 7 / 10, tempHeight - tempHeight / 2 - 2, menuElements, false, false);
        for (int i9 = 3; i9 < menuElements.size(); ++i9) {
            this.getMenuElem(i9).setCurr(((i9 - 3) / 2 + 1) % 2);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING, this.getHeightM() + 2 + Core.PADDING, true, true);
        oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.25f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM() + 2);
        oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.75f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 2, CFG.BUTTON_H / 4);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.BUTTON_H / 4, this.getHeightM());
        oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM());
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_FlagAction();
    }

    @Override
    public void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
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

