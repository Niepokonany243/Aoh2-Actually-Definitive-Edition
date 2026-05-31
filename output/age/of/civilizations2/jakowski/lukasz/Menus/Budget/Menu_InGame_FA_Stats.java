/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Budget;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Plagues.Nuke.NukeManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Color;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Graph;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Terrain;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Action.Menu_SK;
import age.of.civilizations2.jakowski.lukasz.Menus.Alliance.Menu_FB;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_Top;
import age.of.civilizations2.jakowski.lukasz.Menus.Colonization.Menu_MM;
import age.of.civilizations2.jakowski.lukasz.Menus.Diplomacy.Menu_NV;
import age.of.civilizations2.jakowski.lukasz.Menus.Population.Menu_InGame_View_PopulationCiv;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_2;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_CivilizationView;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextFlagActionStats;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_FA_Stats
extends Menu {
    public Menu_InGame_FA_Stats() {
        int tempHeight = CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        int tempWidth = Menu_InGame_FA_Top.getWindowWidth() - CFG.PADD * 4;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, CFG.PADD, tempHeight, false));
        menuElements.add(new TextFlagActionStats(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())) / 2 - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())));
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight())));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getCitSize() > 0) {
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Capital") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getCit(0).getCityName(), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.getIsDesktop()) {
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                        nData.add(new ME_Hover_2Type_Text("HOME", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getName().length() > 0) {
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Capital") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getName(), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.getIsDesktop()) {
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                        nData.add(new ME_Hover_2Type_Text("HOME", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.flagRectSmall).getHeight()));
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
            }

            @Override
            public void actionElem(int iID) {
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID() >= 0) {
                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getName().length() > 0) {
                        CFG.toastM.addM(CFG.core.getProv(CFG.core.getActiveProvID()).getName(), CFG.COLOR_HOVER_TITLE);
                    }
                    CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                    CFG.mapModesManager.disableAllViews();
                }
            }
        });
        if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() > 0) {
            menuElements.add(new TextFlagActionStats("" + CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getAllianceName(), CFG.PADD, 0){

                @Override
                public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                    super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                    IMGManager.getIMG(Images.diploAlliance).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.diploAlliance).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploAlliance).getHeight())) / 2 - IMGManager.getIMG(Images.diploAlliance).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploAlliance).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploAlliance).getHeight())), (int)((float)IMGManager.getIMG(Images.diploAlliance).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploAlliance).getHeight())));
                }

                @Override
                public int getWidthE() {
                    return super.getWidthE() + this.getTextPosElem();
                }

                @Override
                public int getTextPosElem() {
                    return CFG.PADD + (int)((float)IMGManager.getIMG(Images.diploAlliance).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploAlliance).getHeight()));
                }

                @Override
                public void buildElemHover() {
                    block5: {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            for (int i = 0; i < CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilizationsSize(); ++i) {
                                nData.add(new ME_Hover_2Type_Flag(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilization(i)));
                                nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilization(i)).getCivName(), CFG.COLOR_HOVER_TITLE));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            this.menuElemHover = new ME_Hover_v2(nElements);
                            return;
                        }
                        catch (IndexOutOfBoundsException ex) {
                            if (CFG.LOGs) {
                                CFG.exceptionStack(ex);
                            }
                        }
                        catch (NullPointerException ex) {
                            if (!CFG.LOGs) break block5;
                            CFG.exceptionStack(ex);
                        }
                    }
                    this.menuElemHover = null;
                }
            });
        }
        menuElements.add(new TextFlagActionStats(CFG.lang.get("Provinces") + ": ", "" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs(), CFG.COLOR_TEXT_NUM_OF_PROVINCES, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                IMGManager.getIMG(Images.provinces).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.provinces).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.provinces).getHeight())) / 2 - IMGManager.getIMG(Images.provinces).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.provinces).getHeight())), (int)((float)IMGManager.getIMG(Images.provinces).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.provinces).getHeight())));
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.provinces).getHeight()));
            }

            @Override
            public void actionElem(int iID) {
                try {
                    if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs() > 0) {
                        Menu_InGame_CivilizationView.iCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_PosX = CFG.map.getMpC().getPX();
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_PosY = CFG.map.getMpC().getPY();
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).fBefore_Scale = CFG.map.getMpS().getCurrSc();
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_ActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                        CFG.mapModesManager.disableAllViews();
                        CFG.menus.setMenuID(View.eINGAME_CIV_VIEW);
                        if (CFG.FOG_OF_WAR == 2) {
                            CFG.core.enableDrawCivilizationRegions_FogOfWar(Menu_InGame_CivilizationView.iCivID, 0);
                        } else {
                            CFG.core.enableDrawCivilizationRegions(Menu_InGame_CivilizationView.iCivID, 0);
                        }
                        CFG.map.getMpB().updateWorldMap_Shaders();
                        CFG.toastM.addM(CFG.core.getCiv(Menu_InGame_CivilizationView.iCivID).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                        CFG.toastM.setTimeInView(1500);
                    }
                }
                catch (Exception ex) {
                    Menu_InGame_CivilizationView.iCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                }
            }

            @Override
            public void buildElemHover() {
                int j;
                int i;
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                ArrayList<Integer> tempTerrainTypes = new ArrayList<Integer>();
                ArrayList<Integer> numOfProvinccesByTerrain = new ArrayList<Integer>();
                for (i = 0; i < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs(); ++i) {
                    boolean add = true;
                    for (j = 0; j < tempTerrainTypes.size(); ++j) {
                        if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).getTerrainTypeID() != ((Integer)tempTerrainTypes.get(j)).intValue()) continue;
                        add = false;
                        numOfProvinccesByTerrain.set(j, (Integer)numOfProvinccesByTerrain.get(j) + 1);
                        break;
                    }
                    if (!add) continue;
                    tempTerrainTypes.add(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(i)).getTerrainTypeID());
                    numOfProvinccesByTerrain.add(1);
                }
                int iSize = tempTerrainTypes.size();
                for (i = 0; i < iSize - 1; ++i) {
                    for (j = i + 1; j < iSize; ++j) {
                        if ((Integer)numOfProvinccesByTerrain.get(i) >= (Integer)numOfProvinccesByTerrain.get(j)) continue;
                        int tempD = (Integer)tempTerrainTypes.get(i);
                        tempTerrainTypes.set(i, (Integer)tempTerrainTypes.get(j));
                        tempTerrainTypes.set(j, tempD);
                        tempD = (Integer)numOfProvinccesByTerrain.get(i);
                        numOfProvinccesByTerrain.set(i, (Integer)numOfProvinccesByTerrain.get(j));
                        numOfProvinccesByTerrain.set(j, tempD);
                    }
                }
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Provinces") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                for (i = 0; i < tempTerrainTypes.size(); ++i) {
                    nData.add(new ME_Hover_2Type_Color(new Color(CFG.terrainTypesManager.getColor((int)((Integer)tempTerrainTypes.get((int)i)).intValue()).r, CFG.terrainTypesManager.getColor((int)((Integer)tempTerrainTypes.get((int)i)).intValue()).g, CFG.terrainTypesManager.getColor((int)((Integer)tempTerrainTypes.get((int)i)).intValue()).b, 1.0f)));
                    nData.add(new ME_Hover_2Type_Terrain((Integer)tempTerrainTypes.get(i)));
                    nData.add(new ME_Hover_2Type_Text(CFG.terrainTypesManager.getName((Integer)tempTerrainTypes.get(i)) + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + numOfProvinccesByTerrain.get(i), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = !nElements.isEmpty() ? new ME_Hover_v2(nElements) : null;
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("Population") + ": ", CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).countPop()), CFG.COLOR_POPULATION, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                IMGManager.getIMG(Images.pop).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.pop).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.pop).getHeight())) / 2 - IMGManager.getIMG(Images.pop).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.pop).getHeight())), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.pop).getHeight())));
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.pop).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.pop).getHeight()));
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_PopulationOfCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_FA_Stats.this.hideFlagAction();
                Menu_InGame_View_PopulationCiv.civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_POPULATION_OF_CIV_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_POPULATION_OF_CIV_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Population"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("Army") + ": ", CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits()), CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                IMGManager.getIMG(Images.diploArmy).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.diploArmy).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploArmy).getHeight())) / 2 - IMGManager.getIMG(Images.diploArmy).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploArmy).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploArmy).getHeight())), (int)((float)IMGManager.getIMG(Images.diploArmy).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploArmy).getHeight())));
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.diploArmy).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploArmy).getHeight()));
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_FA_Stats.this.hideFlagAction();
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_ARMY_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_HAPPINESS_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Armies"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Army") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits()), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                int nUpkeep = (int)CFG.gameUpdate.getMilitaryUpkeep_Total(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + nUpkeep, nUpkeep == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("" + (float)((int)((float)nUpkeep / (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits() * 100.0f)) / 100.0f, CFG.COLOR_GOLD));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PerUnit")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("WarWeariness") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getWarWeariness() * 10000.0f)) / 100.0f + "%", CFG.COLOR_NEUTRAL2));
                nData.add(new ME_Hover_2Type_Image(Images.diploWeariness, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("MilitaryUpkeepH1"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("Economy") + ": ", CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).countEco()), CFG.COLOR_ECONOMY, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                IMGManager.getIMG(Images.economy).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.economy).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.economy).getHeight())) / 2 - IMGManager.getIMG(Images.economy).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.economy).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.economy).getHeight())), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.economy).getHeight())));
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.economy).getHeight()));
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_FA_Stats.this.hideFlagAction();
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_ECONOMY_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Economy"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                long tempTotalEco = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).countEco();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Economy") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + tempTotalEco), CFG.COLOR_ECONOMY));
                nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("StartingEconomy") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.startingEconomy), CFG.COLOR_ECONOMY));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, CFG.PADD));
                long difference = tempTotalEco - CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.startingEconomy;
                nData.add(new ME_Hover_2Type_Text((difference > 0L ? "+" : "") + CFG.getNumberWthSpaces("" + difference), difference == 0L ? CFG.COLOR_NEUTRAL : (difference > 0L ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Text(" [" + (difference > 0L ? "+" : "") + CFG.getPercentage2Old(tempTotalEco - CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.startingEconomy, CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.startingEconomy, 100) + "%]", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_ECONOMY, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OverinvestmentPenalty") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(Core.getOverInvestmentsPenalty(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Unemployment") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.gameUpdate.getUnemploymentPop(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) + " ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text_Big("[" + CFG.getPercentageOld((float)CFG.gameUpdate.getUnemploymentPop(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).countPop(), 4) + "%]", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("Technology") + ": ", "" + (float)((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_TECHNOLOGY, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                IMGManager.getIMG(Images.technology).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.technology).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.technology).getHeight())) / 2 - IMGManager.getIMG(Images.technology).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.technology).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.technology).getHeight())), (int)((float)IMGManager.getIMG(Images.technology).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.technology).getHeight())));
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.technology).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.technology).getHeight()));
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_FA_Stats.this.hideFlagAction();
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_TECHNOLOGY_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_TECHNOLOGY_MODE) {
                    CFG.toastM.addM(CFG.lang.get("TechnologyLevel"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Technology") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + (float)((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * 100.0f)) / 100.0f + "/" + GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Tech1"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Tech2"), CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Tech3"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Tech4"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("AverageDevelopment") + ": " + CFG.core.countAverageDevelopmentLevel(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) + " [" + (int)(CFG.core.countAverageDevelopmentLevel_Float(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * 100.0f) + "%]", CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                IMGManager.getIMG(Images.development).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.development).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.development).getHeight())) / 2 - IMGManager.getIMG(Images.development).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.development).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.development).getHeight())), (int)((float)IMGManager.getIMG(Images.development).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.development).getHeight())));
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.development).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.development).getHeight()));
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_FA_Stats.this.hideFlagAction();
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_DEVELOPMENT_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DEVELOPMENT_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Development"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AverageDevelopment") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.core.countAverageDevelopmentLevel(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) + "/" + (float)((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.development, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Tech4"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Tech5"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("OverinvestmentPenalty") + ": +" + CFG.getPrecision2(Core.getOverInvestmentsPenalty(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f, 100) + "%", CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                IMGManager.getIMG(Images.overInvest).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.overInvest).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.overInvest).getHeight())) / 2 - IMGManager.getIMG(Images.overInvest).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.overInvest).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.overInvest).getHeight())), (int)((float)IMGManager.getIMG(Images.overInvest).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.overInvest).getHeight())));
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.overInvest).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.overInvest).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OverinvestmentPenalty") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("+" + CFG.getPrecision2(Core.getOverInvestmentsPenalty(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.getPrecision2(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.numberOfInvestments, 10), CFG.COLOR_ECONOMY));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("TooMuchGoldPouredIntoTheEconomyAtOnceDrivesUpCosts")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ThisPenaltySlowlyDecreasesOverTime")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("Inflation") + ": ", "" + (float)((int)(CFG.gameUpdate.getInflationPerc(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 10000.0f)) / 100.0f + "%", CFG.gameUpdate.getInflationPerc(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) > 0.0f ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                IMGManager.getIMG(Images.developmentDown).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.developmentDown).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.developmentDown).getHeight())) / 2 - IMGManager.getIMG(Images.developmentDown).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.developmentDown).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.developmentDown).getHeight())), (int)((float)IMGManager.getIMG(Images.developmentDown).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.developmentDown).getHeight())));
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.developmentDown).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.developmentDown).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Inflation") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getInflation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), (int)CFG.gameUpdate.getInflation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL2));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topGold(), CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big("[" + (float)((int)(CFG.gameUpdate.getInflationPerc(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 10000.0f)) / 100.0f + "%]", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image_Big(Images.developmentDown, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("InflationH1"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("InflationH2"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("WarWeariness") + ": ", "" + (float)((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getWarWeariness() * 10000.0f)) / 100.0f + "%", CFG.COLOR_NEUTRAL2, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                IMGManager.getIMG(Images.diploWeariness).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.diploWeariness).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploWeariness).getHeight())) / 2 - IMGManager.getIMG(Images.diploWeariness).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploWeariness).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploWeariness).getHeight())), (int)((float)IMGManager.getIMG(Images.diploWeariness).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploWeariness).getHeight())));
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.diploWeariness).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploWeariness).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WarWeariness") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + (float)((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getWarWeariness() * 10000.0f)) / 100.0f + "%", CFG.COLOR_NEUTRAL2));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploWeariness, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("WarWearinessH1"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("WarWearinessH2"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("WarWearinessH3"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("AtomicBombs") + ": ", "" + CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.iNukes + " / " + NukeManager.getAtomicBombsLimit(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), CFG.COLOR_NEUTRAL2, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                IMGManager.getIMG(Images.nuke).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.nuke).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.nuke).getHeight())) / 2 - IMGManager.getIMG(Images.nuke).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.nuke).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.nuke).getHeight())), (int)((float)IMGManager.getIMG(Images.nuke).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.nuke).getHeight())));
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.nuke).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.nuke).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AtomicBombs") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.iNukes + " / " + NukeManager.getAtomicBombsLimit(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.nuke, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RequiredTechnologyLevel") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(CFG.NUKES_REQUIRED_TECH_LVL, 100), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.NUKES_MIN_YEAR_ENABLED) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MinimumYearForNukes") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + GameValues.gvAtomic.ATOMIC_BOMB_MIN_YEAR, GameCalendar.currYear >= GameValues.gvAtomic.ATOMIC_BOMB_MIN_YEAR ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Image(GameCalendar.currYear >= GameValues.gvAtomic.ATOMIC_BOMB_MIN_YEAR ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("Happiness") + ": ", "" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getHappiness() + "%", CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getHappiness(), 100, 1.0f), CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                try {
                    IMGManager.getIMG(CFG.getHappinessImage(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getHappiness())).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.happiness).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.happiness).getHeight())) / 2 - IMGManager.getIMG(Images.happiness).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.happiness).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.happiness).getHeight())), (int)((float)IMGManager.getIMG(Images.happiness).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.happiness).getHeight())));
                }
                catch (Exception ex) {
                    IMGManager.getIMG(Images.happiness).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.happiness).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.happiness).getHeight())) / 2 - IMGManager.getIMG(Images.happiness).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.happiness).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.happiness).getHeight())), (int)((float)IMGManager.getIMG(Images.happiness).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.happiness).getHeight())));
                }
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_FA_Stats.this.hideFlagAction();
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_HAPPINESS_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_HAPPINESS_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Happiness"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.happiness).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.happiness).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Happiness") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getHappiness() + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(CFG.getHappinessImage(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getHappiness()), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Happiness1"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Taxes1"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Taxes2"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Taxes3"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Festival1"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("Stability") + ": ", "" + (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getStabilityCiv() * 100.0f) + "%", CFG.getColorStep(CFG.COLOR_PROVINCE_STABILITY_MIN, CFG.COLOR_PROVINCE_STABILITY_MAX, (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getStabilityCiv() * 100.0f), 100, 1.0f), CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                IMGManager.getIMG(Images.diploStability).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.diploStability).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploStability).getHeight())) / 2 - IMGManager.getIMG(Images.diploStability).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploStability).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploStability).getHeight())), (int)((float)IMGManager.getIMG(Images.diploStability).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploStability).getHeight())));
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.diploStability).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploStability).getHeight()));
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_FA_Stats.this.hideFlagAction();
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_PROVINCE_STABILITY_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_PROVINCE_STABILITY_MODE) {
                    CFG.toastM.addM(CFG.lang.get("ProvinceStability"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Stability") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getStabilityCiv() * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploStability, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Stability1"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Stability2"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Stability3"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("CivRank") + ": ", "" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRankPos(), CFG.COLOR_TEXT_NUM_OF_PROVINCES, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                int rankIMG = CFG.getCivilizationRanking_IMG_STAR_CIVID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                IMGManager.getIMG(rankIMG).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(rankIMG).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(rankIMG).getHeight())) / 2 - IMGManager.getIMG(rankIMG).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(rankIMG).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(rankIMG).getHeight())), (int)((float)IMGManager.getIMG(rankIMG).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(rankIMG).getHeight())));
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_Rank()) {
                    CFG.menus.setVisibleInGame_Rank(false);
                } else {
                    CFG.menus.rebuildInGame_Rank();
                }
            }

            @Override
            public int getTextPosElem() {
                int rankIMG = CFG.getCivilizationRanking_IMG_STAR_CIVID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                return CFG.PADD + (int)((float)IMGManager.getIMG(rankIMG).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(rankIMG).getHeight()));
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_RankOfCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("Sanctions") + ": ", (CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).sanctionsImpact > 0.0f ? "-" : "") + CFG.getPrecision2(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).sanctionsImpact * 100.0f, 100) + "%", CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).sanctionsImpact > 0.0f ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                IMGManager.getIMG(Images.sanctions).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.sanctions).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.sanctions).getHeight())) / 2 - IMGManager.getIMG(Images.sanctions).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.sanctions).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.sanctions).getHeight())), (int)((float)IMGManager.getIMG(Images.sanctions).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.sanctions).getHeight())));
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.sanctions).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.sanctions).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SanctionsImpact") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text_Big((CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).sanctionsImpact > 0.0f ? "-" : "") + CFG.getPrecision2(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).sanctionsImpact * 100.0f, 100) + "%", CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).sanctionsImpact > 0.0f ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image_Big(Images.sanctions, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("Government") + ": ", "" + CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getName(), new Color(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getColor().r, CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getColor().g, CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getColor().b, 1.0f), CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getCrownImageScaled().drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getCrownImageScaled().getHeight() * Menu_InGame_FA_Stats.this.getImageScale(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getCrownImageScaled().getHeight())) / 2 - CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getCrownImageScaled().getHeight() + iTranslateY, (int)((float)CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getCrownImageScaled().getWidth() * Menu_InGame_FA_Stats.this.getImageScale(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getCrownImageScaled().getHeight())), (int)((float)CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getCrownImageScaled().getHeight() * Menu_InGame_FA_Stats.this.getImageScale(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getCrownImageScaled().getHeight())));
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getCrownImageScaled().getWidth() * Menu_InGame_FA_Stats.this.getImageScale(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getCrownImageScaled().getHeight()));
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_FA_Stats.this.hideFlagAction();
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_IDEOLOGIES_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_IDEOLOGIES_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Governments"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.ideologiesMgr.getIdeologyHover(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("Religion") + ": ", "" + CFG.religionManager.getReligion(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getReligionID()).getName(), new Color(CFG.religionManager.getReligion((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getReligionID()).getColor().r, CFG.religionManager.getReligion((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getReligionID()).getColor().g, CFG.religionManager.getReligion((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getReligionID()).getColor().b, 1.0f), CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                CFG.religionManager.religionImages.get(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getReligionID()).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getReligionID()).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(CFG.religionManager.religionImages.get(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getReligionID()).getHeight())) / 2 - CFG.religionManager.religionImages.get(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getReligionID()).getHeight() + iTranslateY, (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getReligionID()).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(CFG.religionManager.religionImages.get(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getReligionID()).getHeight())), (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getReligionID()).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(CFG.religionManager.religionImages.get(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getReligionID()).getHeight())));
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_FA_Stats.this.hideFlagAction();
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_RELIGION_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_RELIGION_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Religion"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getReligionID()).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(CFG.religionManager.religionImages.get(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getReligionID()).getHeight()));
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.religionManager.getReligionHover(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getReligionID());
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("Difficulty") + ": " + CFG.getDifficultyName(CFG.DIFFICULTY), "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.editorMap).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.editorMap).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.editorMap).getHeight())) / 2 - IMGManager.getIMG(Images.editorMap).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.editorMap).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.editorMap).getHeight())), (int)((float)IMGManager.getIMG(Images.editorMap).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.editorMap).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.editorMap).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.editorMap).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Difficulty") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.getDifficultyName(CFG.DIFFICULTY), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("ArmyRetreat") + ": " + (int)(CFG.ARMY_RETREAT * 100.0f) + "%", "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.diploArmyMove).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.diploArmyMove).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploArmyMove).getHeight())) / 2 - IMGManager.getIMG(Images.diploArmyMove).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploArmyMove).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploArmyMove).getHeight())), (int)((float)IMGManager.getIMG(Images.diploArmyMove).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploArmyMove).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.diploArmyMove).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploArmyMove).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ArmyRetreat") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + (int)(CFG.ARMY_RETREAT * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmyMove, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("Capitulation") + ": " + (int)(CFG.CAPITULATION * 100.0f) + "%", "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.diploTruce).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.diploTruce).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploTruce).getHeight())) / 2 - IMGManager.getIMG(Images.diploTruce).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploTruce).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploTruce).getHeight())), (int)((float)IMGManager.getIMG(Images.diploTruce).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploTruce).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.diploTruce).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploTruce).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Capitulation") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + (int)(CFG.CAPITULATION * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploTruce, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ACivilizationWillCapitulateDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("TechnologyAttackModifier") + ": " + (float)CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK / 100.0f, "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.attack).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.attack).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.attack).getHeight())) / 2 - IMGManager.getIMG(Images.attack).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.attack).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.attack).getHeight())), (int)((float)IMGManager.getIMG(Images.attack).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.attack).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.attack).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.attack).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TechnologyAttackModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + (float)CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK / 100.0f, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.attack, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                float fEff = CFG.gameUpdate.getAdministrationEfficiency(Menu_InGame_CivilizationView.iCivID);
                int nAdmin = (int)((fEff - 0.5f) * 100.0f);
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Administration") + ": "));
                nData.add(new ME_Hover_2Type_Text((nAdmin >= 0 ? "+" : "") + nAdmin + "%", nAdmin >= 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.administration, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("AttackDefenseDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("TechnologyDefenseModifier") + ": " + (float)CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE / 100.0f, "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.defense).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.defense).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.defense).getHeight())) / 2 - IMGManager.getIMG(Images.defense).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.defense).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.defense).getHeight())), (int)((float)IMGManager.getIMG(Images.defense).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.defense).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.defense).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.defense).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TechnologyDefenseModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + (float)CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE / 100.0f, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.defense, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                float fEff = CFG.gameUpdate.getAdministrationEfficiency(Menu_InGame_CivilizationView.iCivID);
                int nAdmin = (int)((fEff - 0.5f) * 100.0f);
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Administration") + ": "));
                nData.add(new ME_Hover_2Type_Text((nAdmin >= 0 ? "+" : "") + nAdmin + "%", nAdmin >= 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.administration, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("AttackDefenseDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("PopulationGrowth") + ": " + (int)(CFG.POPULATION_GROWTH_RATE * 100.0f) + "%", "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.popGrowth).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.popGrowth).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.popGrowth).getHeight())) / 2 - IMGManager.getIMG(Images.popGrowth).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.popGrowth).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.popGrowth).getHeight())), (int)((float)IMGManager.getIMG(Images.popGrowth).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.popGrowth).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.popGrowth).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.popGrowth).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PopulationGrowth") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.POPULATION_GROWTH_RATE * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("PopulationGrowthDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("EconomyGrowthModifier") + ": " + (int)(CFG.ECONOMY_GROWTH_RATE * 100.0f) + "%", "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.economy).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.economy).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.economy).getHeight())) / 2 - IMGManager.getIMG(Images.economy).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.economy).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.economy).getHeight())), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.economy).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.economy).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomyGrowthModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.ECONOMY_GROWTH_RATE * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("EconomyGrowthDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("MovementPoints") + ", " + CFG.lang.get("Extra") + ": ", "" + CFG.getPrecision2((float)CFG.MOVEMENT_POINTS_EXTRA / 10.0f, 100), CFG.COLOR_MOVEMENT, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.topMovementPoints).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.topMovementPoints).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.topMovementPoints).getHeight())) / 2 - IMGManager.getIMG(Images.topMovementPoints).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.topMovementPoints).getHeight())), (int)((float)IMGManager.getIMG(Images.topMovementPoints).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.topMovementPoints).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.topMovementPoints).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ", " + CFG.lang.get("Extra") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2((float)CFG.MOVEMENT_POINTS_EXTRA / 10.0f, 100), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("MovementPoints") + ", " + CFG.lang.get("Limit") + ": ", "" + (int)(CFG.MOVEMENT_POINTS_MAX_MODIFIER * 100.0f) + "%", CFG.COLOR_HOVER_TITLE, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.topMovementPoints).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.topMovementPoints).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.topMovementPoints).getHeight())) / 2 - IMGManager.getIMG(Images.topMovementPoints).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.topMovementPoints).getHeight())), (int)((float)IMGManager.getIMG(Images.topMovementPoints).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.topMovementPoints).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.topMovementPoints).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ", " + CFG.lang.get("Limit") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.MOVEMENT_POINTS_MAX_MODIFIER * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PerTurn")));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("DiplomacyPoints") + ", " + CFG.lang.get("Extra") + ": ", "" + CFG.getPrecision2((float)CFG.DIPLOMACY_POINTS_EXTRA / 10.0f, 100), CFG.COLOR_DIPLOMACY_POINTS, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.topDiplomacyPoints).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.topDiplomacyPoints).getHeight())) / 2 - IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.topDiplomacyPoints).getHeight())), (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.topDiplomacyPoints).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.topDiplomacyPoints).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ", " + CFG.lang.get("Extra") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2((float)CFG.DIPLOMACY_POINTS_EXTRA / 10.0f, 100), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PerTurn")));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("UseNewAIWarDeclarationSystem") + ": " + (CFG.USE_NEW_DECLARE_WAR_SYSTEM ? CFG.lang.get("On") : CFG.lang.get("Off")), "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.diploWar).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.diploWar).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploWar).getHeight())) / 2 - IMGManager.getIMG(Images.diploWar).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploWar).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploWar).getHeight())), (int)((float)IMGManager.getIMG(Images.diploWar).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploWar).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.diploWar).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploWar).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("UseNewAIWarDeclarationSystem") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + (CFG.USE_NEW_DECLARE_WAR_SYSTEM ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ChanceToUseOldAIWarDeclarationSystem") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.USE_OLD_DECLARE_WAR_CHANGE_100 + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("EnableNuclearWeapons") + ": " + (CFG.ENABLE_NUKES ? CFG.lang.get("On") : CFG.lang.get("Off")), "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.nuke).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.nuke).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.nuke).getHeight())) / 2 - IMGManager.getIMG(Images.nuke).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.nuke).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.nuke).getHeight())), (int)((float)IMGManager.getIMG(Images.nuke).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.nuke).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.nuke).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.nuke).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("EnableNuclearWeapons") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + (CFG.ENABLE_NUKES ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.nuke, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        menuElements.add(new TextFlagActionStats("AI, " + CFG.lang.get("FormUnion") + ": " + (CFG.AI_UNIONS_ENABLED ? CFG.lang.get("On") : CFG.lang.get("Off")), "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.diploUnion).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.diploUnion).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploUnion).getHeight())) / 2 - IMGManager.getIMG(Images.diploUnion).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploUnion).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploUnion).getHeight())), (int)((float)IMGManager.getIMG(Images.diploUnion).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploUnion).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.diploUnion).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.diploUnion).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big("AI, " + CFG.lang.get("FormUnion") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + (CFG.AI_UNIONS_ENABLED ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploUnion, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
            }
        });
        menuElements.add(new TextFlagActionStats("Age of History 2: Definitive Edition", "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.gameLogo).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.gameLogo).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.gameLogo).getHeight())) / 2 - IMGManager.getIMG(Images.gameLogo).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.gameLogo).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.gameLogo).getHeight())), (int)((float)IMGManager.getIMG(Images.gameLogo).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.gameLogo).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.gameLogo).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.gameLogo).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big("Age of History 2: Definitive Edition"));
                nData.add(new ME_Hover_2Type_Image_Big(Images.gameLogo, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                CFG.GO_TO_LINK = "https://store.steampowered.com/app/3381680/Age_of_History_II_Definitive_Edition/";
                CFG.setDialogType(DialogType.GO_TO_LINK);
            }
        });
        menuElements.add(new TextFlagActionStats("Age of Civilizations 1", "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.core).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.core).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.core).getHeight())) / 2 - IMGManager.getIMG(Images.core).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.core).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.core).getHeight())), (int)((float)IMGManager.getIMG(Images.core).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.core).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.core).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.core).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big("Age of Civilizations 1"));
                nData.add(new ME_Hover_2Type_Image_Big(Images.core, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                boolean bl = Menu_InGame_2.MENU_AOC_1 = !Menu_InGame_2.MENU_AOC_1;
                if (Menu_InGame_2.MENU_AOC_1) {
                    Menu_InGame_2.MENU_AOC_1_BOT = CFG.oR.nextInt(100) < 50;
                    CFG.menus.rebuildMenu_InGame_Infobox_AllAction2("The original Age of Civilizations 1 menu v" + (Menu_InGame_2.MENU_AOC_1_BOT ? "1" : "2"), "Back to September 2014", Menu_InGame_2.MENU_AOC_1_BOT ? Images.infoDiplomacy : Images.infoStability);
                } else {
                    Menu_InGame_2.MENU_AOC_1_BOT = false;
                }
            }

            @Override
            public void actionElemPPM() {
                Menu_FB.goBack = View.eINGAME;
                CFG.menus.setMenuID(View.eFB);
            }
        });
        menuElements.add(new TextFlagActionStats("Fix the Bugs!", "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.disease).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.disease).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.disease).getHeight())) / 2 - IMGManager.getIMG(Images.disease).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.disease).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.disease).getHeight())), (int)((float)IMGManager.getIMG(Images.disease).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.disease).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.disease).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.disease).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big("Fix the Bugs!"));
                nData.add(new ME_Hover_2Type_Image_Big(Images.disease, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                Menu_FB.goBack = View.eINGAME;
                CFG.menus.setMenuID(View.eFB);
            }

            @Override
            public void actionElemPPM() {
                Menu_FB.goBack = View.eINGAME;
                CFG.menus.setMenuID(View.eFB);
            }
        });
        menuElements.add(new TextFlagActionStats("Who Wants to Rule the World? Quiz", "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.randomCivilizationFlag).getHeight())) / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.randomCivilizationFlag).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.randomCivilizationFlag).getHeight())), (int)((float)IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.randomCivilizationFlag).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.randomCivilizationFlag).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.randomCivilizationFlag).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big("Who Wants to Rule the World? Quiz"));
                nData.add(new ME_Hover_2Type_Image_Big(Images.randomCivilizationFlag, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                Menu_MM.goBack = View.eINGAME;
                CFG.menus.setMenuID(View.eMM);
            }

            @Override
            public void actionElemPPM() {
                Menu_MM.goBack = View.eINGAME;
                CFG.menus.setMenuID(View.eMM);
            }
        });
        menuElements.add(new TextFlagActionStats("Mom, can we have the navy.", "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.bPort).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bPort).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.bPort).getHeight())) / 2 - IMGManager.getIMG(Images.bPort).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.bPort).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.bPort).getHeight())), (int)((float)IMGManager.getIMG(Images.bPort).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.bPort).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.bPort).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.bPort).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big("Mom, can we have the navy."));
                nData.add(new ME_Hover_2Type_Image_Big(Images.bPort, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                Menu_NV.goBack = View.eINGAME;
                CFG.menus.setMenuID(View.eNV);
            }

            @Override
            public void actionElemPPM() {
                Menu_NV.goBack = View.eINGAME;
                CFG.menus.setMenuID(View.eNV);
            }
        });
        menuElements.add(new TextFlagActionStats("Flag Snake", "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.bFarm).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bFarm).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.bFarm).getHeight())) / 2 - IMGManager.getIMG(Images.bFarm).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.bFarm).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.bFarm).getHeight())), (int)((float)IMGManager.getIMG(Images.bFarm).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.bFarm).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.bFarm).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.bFarm).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Flag Snake")));
                nData.add(new ME_Hover_2Type_Image_Big(Images.bFarm, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                if (CFG.getIsDesktop()) {
                    Menu_SK.goBack = View.eINGAME;
                    CFG.menus.setMenuID(View.eSK);
                    CFG.map.getMpS().setNewCurrentScaleByButton2(0.175f);
                }
            }

            @Override
            public void actionElemPPM() {
                if (CFG.getIsDesktop()) {
                    Menu_SK.goBack = View.eINGAME;
                    CFG.menus.setMenuID(View.eSK);
                    CFG.map.getMpS().setNewCurrentScaleByButton2(0.175f);
                }
            }
        });
        menuElements.add(new TextFlagActionStats(CFG.lang.get("Wiki"), "", CFG.COLOR_NEUTRAL, CFG.PADD, 0){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
                if (isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                } else {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
                }
                IMGManager.getIMG(Images.wikipedia).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.wikipedia).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.wikipedia).getHeight())) / 2 - IMGManager.getIMG(Images.wikipedia).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.wikipedia).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.wikipedia).getHeight())), (int)((float)IMGManager.getIMG(Images.wikipedia).getHeight() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.wikipedia).getHeight())));
                oSB.setColor(Color.WHITE);
            }

            @Override
            public int getWidthE() {
                return super.getWidthE() + this.getTextPosElem();
            }

            @Override
            public int getTextPosElem() {
                return CFG.PADD + (int)((float)IMGManager.getIMG(Images.wikipedia).getWidth() * Menu_InGame_FA_Stats.this.getImageScale(IMGManager.getIMG(Images.wikipedia).getHeight()));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wiki") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.getWikiInforLinkClear(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivTag()), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.wikipedia, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivTag();
                CFG.setDialogType(DialogType.GO_TO_WIKI);
            }
        });
        menuElements.add(new Button_Transparent(0, 0, CFG.PADD, tempHeight, false));
        int tElementsWidth = 0;
        for (int i = 0; i < menuElements.size(); ++i) {
            tElementsWidth += ((MenuElemUI)menuElements.get(i)).getWidthE();
        }
        int tStartX = 0;
        tStartX = (tElementsWidth += CFG.PADD * 2 * (menuElements.size() - 1)) > tempWidth ? 0 : (tempWidth - tElementsWidth) / 2;
        for (int i = 0; i < menuElements.size(); ++i) {
            ((MenuElemUI)menuElements.get(i)).setPosX(tStartX);
            tStartX += ((MenuElemUI)menuElements.get(i)).getWidthE() + CFG.PADD * 2;
        }
        menuElements.add(new Button_Transparent(0, 0, tempWidth - 4, tempHeight, true));
        this.initMenu(null, CFG.PADD * 2 + 2 + AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4, tempWidth - 4, tempHeight, menuElements, false, false);
    }

    private final float getImageScale(int nImageHeight) {
        return (float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) / (float)nImageHeight;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - Core.PADDING - 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 4 - IMGManager.getIMG(Images.gameTopEdgeLine).getWidth() + Core.PADDING * 2, this.getHeightM(), false, true);
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() + 2 - IMGManager.getIMG(Images.gameTopEdgeLine).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdgeLine).getWidth(), this.getHeightM(), true, true);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.275f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM() / 3);
        oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.225f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthM() / 8, this.getHeightM());
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getWidthM() - this.getWidthM() / 8 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthM() / 8, this.getHeightM(), true, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.9f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM() * 4 / 5);
        oSB.setColor(new Color(0.01f, 0.02f, 0.04f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.PADD, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.85f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM(), 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM(), 1);
        oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM(), 1);
        oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.8f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() / 4, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getWidthM() - this.getWidthM() / 4 + iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() / 4, 1, true, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() / 10, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getWidthM() - this.getWidthM() / 10 + iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() / 10, 1, true, false);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, CFG.PADD, this.getHeightM());
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getWidthM() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, CFG.PADD, this.getHeightM(), true, false);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_FlagAction();
    }

    @Override
    public void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    public void hideFlagAction() {
        CFG.menus.setVisible_InGame_FlagAction(!CFG.menus.getVisible_InGame_FlagAction());
        if (CFG.menus.getVisible_InGame_FlagAction()) {
            CFG.gameAction.hideAllViews();
            if (CFG.chooseProvinceMode) {
                CFG.core.resetChooseProvinceData();
            }
            if (CFG.regroupArmyMode) {
                CFG.core.resetRegroupArmy_Data();
            }
        } else {
            if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                CFG.mapModesManager.getActiveView().enableViewAction();
            }
            CFG.core.checkProvinceActionMenu();
        }
    }
}

