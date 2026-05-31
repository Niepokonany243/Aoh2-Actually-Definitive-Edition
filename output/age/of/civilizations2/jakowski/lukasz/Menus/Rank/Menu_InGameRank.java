
package age.of.civilizations2.jakowski.lukasz.Menus.Rank;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Options.Button_Opt_NS_MapModes_R2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Flag_Clip2;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Title;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Keyboard;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Graph;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGameRank
extends Menu {
    public static int iSort = 4;
    public static boolean detailsMode = false;
    public static String sSearch = "";
    public static String searchText = "";

    public Menu_InGameRank(int tInit) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH;
        int tempMenuPosY = IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 3 / 5 + CFG.PADD * 2;
        if (tempWidth > CFG.GAMEWIDTH) {
            tempWidth = CFG.GAMEWIDTH - CFG.PADD * 4;
        }
        sSearch = CFG.lang.get("Search") + ": ";
        this.initMenu(null, CFG.PADD * 2 + AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD + CFG.BUTTON_H * 3 / 4, tempWidth, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY - CFG.PADD, menuElements, false, false);
    }

    public Menu_InGameRank() {
        int i;
        int tAddID;
        int i2;
        ArrayList<Long> tempScore;
        int tElemHeight2;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int searchH = (int)((float)CFG.BUTTON_H * 0.7f);
        int tPosY = CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4 + searchH;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH;
        if (tempWidth > CFG.GAMEWIDTH) {
            tempWidth = CFG.GAMEWIDTH - CFG.PADD * 4;
        }
        int tElemHeight = CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        int tElemHeight2_Small = tElemHeight2 = CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 3;
        int tElemHeight_Top3 = Math.max(tElemHeight2_Small, IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 3);
        menuElements.add(new Button_Opt_NS_MapModes_R2(-2, null, CFG.PADD * 2, CFG.PADD, 0, CFG.BUTTON_W - CFG.PADD * 4, (int)((float)CFG.BUTTON_H * 0.7f), true, true, 0){

            @Override
            public int getWidthE() {
                return Menu_InGameRank.this.getWidthM() - this.getPosXE() * 2;
            }

            @Override
            public String getTextToDrawElem() {
                return sSearch + searchText;
            }
        });
        int tYT = ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Civilizations"), CFG.PADD * 2, 2, tYT, CFG.BUTTON_W * 2, tElemHeight){

            @Override
            public int getWidthE() {
                return Menu_InGameRank.this.getElementW() * 4 + CFG.PADD * 2 - 2;
            }

            @Override
            public Color getColorE(boolean isActive) {
                return iSort == 0 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SortBy") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Military"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 2, tYT, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGameRank.this.getElementW() * 4 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGameRank.this.getElementW();
            }

            @Override
            public Color getColorE(boolean isActive) {
                return iSort == 1 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
            }

            @Override
            public void setTextE(String sText) {
                try {
                    super.setTextE(sText);
                    int tWMax = 0;
                    while (this.iTextWidth > this.getWidthE() - CFG.PADD && this.getTextE().length() > 5 && ++tWMax < 100) {
                        super.setTextE(this.getTextE().substring(0, Math.max(1, this.getTextE().length() - 3)) + "..");
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SortBy") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Military"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Military") + " / 25,000, " + CFG.lang.get("TechnologyLevel"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Prestige"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, tYT, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGameRank.this.getElementW() * 5 + CFG.PADD * 2;
            }

            @Override
            public void setTextE(String sText) {
                try {
                    super.setTextE(sText);
                    int tWMax = 0;
                    while (this.iTextWidth > this.getWidthE() - CFG.PADD && this.getTextE().length() > 5 && ++tWMax < 100) {
                        super.setTextE(this.getTextE().substring(0, Math.max(1, this.getTextE().length() - 3)) + "..");
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }

            @Override
            public int getWidthE() {
                return Menu_InGameRank.this.getElementW();
            }

            @Override
            public Color getColorE(boolean isActive) {
                return iSort == 3 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SortBy") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Prestige"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("GrowthRate") + ", " + CFG.lang.get("TechnologyLevel") + ", " + CFG.lang.get("Development"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("TotalScore"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 5, tYT, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGameRank.this.getElementW() * 6 + CFG.PADD * 2;
            }

            @Override
            public void setTextE(String sText) {
                try {
                    super.setTextE(sText);
                    int tWMax = 0;
                    while (this.iTextWidth > this.getWidthE() - CFG.PADD && this.getTextE().length() > 5 && ++tWMax < 100) {
                        super.setTextE(this.getTextE().substring(0, Math.max(1, this.getTextE().length() - 3)) + "..");
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }

            @Override
            public int getWidthE() {
                return Menu_InGameRank.this.getW() - Menu_InGameRank.this.getElementW() * 6 + CFG.PADD * 2 - 2;
            }

            @Override
            public Color getColorE(boolean isActive) {
                return iSort == 4 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SortBy") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TotalScore"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Military") + " + " + CFG.lang.get("Prestige"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ArrayList<Integer> tSorted = new ArrayList<Integer>();
        String tSearchText = searchText.toLowerCase();
        if (iSort == 0) {
            if (!tSearchText.isEmpty()) {
                for (int i3 = 1; i3 < CFG.core.getCivsSize(); ++i3) {
                    if (!CFG.core.getCiv(CFG.core.getSortedCivsAZ(i3 - 1)).getCivName().toLowerCase().contains(tSearchText)) continue;
                    tSorted.add(CFG.core.getSortedCivsAZ(i3 - 1));
                }
            } else {
                for (int i4 = 1; i4 < CFG.core.getCivsSize(); ++i4) {
                    tSorted.add(CFG.core.getSortedCivsAZ(i4 - 1));
                }
            }
        } else if (iSort == 1) {
            ArrayList<Integer> tempIDS = new ArrayList<Integer>();
            tempScore = new ArrayList<Long>();
            if (!tSearchText.isEmpty()) {
                for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                    if (!CFG.core.getCiv(CFG.core.getSortedCivsAZ(i2 - 1)).getCivName().toLowerCase().contains(tSearchText)) continue;
                    tempIDS.add(CFG.core.getSortedCivsAZ(i2 - 1));
                    tempScore.add(CFG.gameAction.buildRank_Score_Military(CFG.core.getSortedCivsAZ(i2 - 1)));
                }
            } else {
                for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                    tempIDS.add(CFG.core.getSortedCivsAZ(i2 - 1));
                    tempScore.add(CFG.gameAction.buildRank_Score_Military(CFG.core.getSortedCivsAZ(i2 - 1)));
                }
            }
            tAddID = 0;
            while (tempIDS.size() > 0) {
                tAddID = 0;
                for (i = 1; i < tempIDS.size(); ++i) {
                    if ((Long)tempScore.get(tAddID) >= (Long)tempScore.get(i)) continue;
                    tAddID = i;
                }
                tSorted.add((Integer)tempIDS.get(tAddID));
                tempIDS.remove(tAddID);
                tempScore.remove(tAddID);
            }
        } else if (iSort == 3) {
            ArrayList<Integer> tempIDS = new ArrayList<Integer>();
            tempScore = new ArrayList<Long>();
            if (!tSearchText.isEmpty()) {
                for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                    if (!CFG.core.getCiv(CFG.core.getSortedCivsAZ(i2 - 1)).getCivName().toLowerCase().contains(tSearchText)) continue;
                    tempIDS.add(CFG.core.getSortedCivsAZ(i2 - 1));
                    tempScore.add(CFG.gameAction.buildRank_Score_Prestige(CFG.core.getSortedCivsAZ(i2 - 1)));
                }
            } else {
                for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                    tempIDS.add(CFG.core.getSortedCivsAZ(i2 - 1));
                    tempScore.add(CFG.gameAction.buildRank_Score_Prestige(CFG.core.getSortedCivsAZ(i2 - 1)));
                }
            }
            tAddID = 0;
            while (tempIDS.size() > 0) {
                tAddID = 0;
                for (i = 1; i < tempIDS.size(); ++i) {
                    if ((Long)tempScore.get(tAddID) >= (Long)tempScore.get(i)) continue;
                    tAddID = i;
                }
                tSorted.add((Integer)tempIDS.get(tAddID));
                tempIDS.remove(tAddID);
                tempScore.remove(tAddID);
            }
        } else {
            ArrayList<Integer> tempIDS = new ArrayList<Integer>();
            tempScore = new ArrayList<Long>();
            try {
                int i5;
                if (!tSearchText.isEmpty()) {
                    for (i5 = 1; i5 < CFG.core.getCivsSize(); ++i5) {
                        if (!CFG.core.getCiv(CFG.core.getSortedCivsAZ(i5 - 1)).getCivName().toLowerCase().contains(tSearchText)) continue;
                        tempIDS.add(CFG.core.getSortedCivsAZ(i5 - 1));
                        tempScore.add((long)CFG.core.getCiv(CFG.core.getSortedCivsAZ(i5 - 1)).getRankScore());
                    }
                } else {
                    for (i5 = 1; i5 < CFG.core.getCivsSize(); ++i5) {
                        tempIDS.add(CFG.core.getSortedCivsAZ(i5 - 1));
                        tempScore.add((long)CFG.core.getCiv(CFG.core.getSortedCivsAZ(i5 - 1)).getRankScore());
                    }
                }
            }
            catch (IndexOutOfBoundsException ex) {
                tempIDS.clear();
                tempScore.clear();
                CFG.core.sortCivilizationsAZ();
                for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                    tempIDS.add(CFG.core.getSortedCivsAZ(i - 1));
                    tempScore.add((long)CFG.core.getCiv(CFG.core.getSortedCivsAZ(i - 1)).getRankScore());
                }
            }
            tAddID = 0;
            while (tempIDS.size() > 0) {
                tAddID = 0;
                for (i = 1; i < tempIDS.size(); ++i) {
                    if ((Long)tempScore.get(tAddID) >= (Long)tempScore.get(i)) continue;
                    tAddID = i;
                }
                tSorted.add((Integer)tempIDS.get(tAddID));
                tempIDS.remove(tAddID);
                tempScore.remove(tAddID);
            }
        }
        int iSize = tSorted.size();
        for (int i6 = 0; i6 < iSize; ++i6) {
            tElemHeight2 = tElemHeight_Top3;
            if (CFG.FOG_OF_WAR == 2) {
                if (CFG.getMetCiv((Integer)tSorted.get(i6))) {
                    menuElements.add(new Button_Stats_Flag_Clip2((Integer)tSorted.get(i6), "" + (i6 + 1) + ". " + CFG.core.getCiv((Integer)tSorted.get(i6)).getCivName(), CFG.PADD, CFG.PADD * 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2, CFG.getCivilizationRanking_IMG_STAR_CIVID((Integer)tSorted.get(i6))){

                        @Override
                        public int getWidthE() {
                            return Menu_InGameRank.this.getElementW() * 4;
                        }

                        @Override
                        public Color getColorE(boolean isActive) {
                            return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                        }
                    });
                } else {
                    menuElements.add(new Button_Stats_Flag_Clip2(-1, "" + (i6 + 1) + ". " + CFG.lang.get("Undiscovered"), CFG.PADD, CFG.PADD * 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2, CFG.getCivilizationRanking_IMG_STAR_CIVID((Integer)tSorted.get(i6))){

                        @Override
                        public int getWidthE() {
                            return Menu_InGameRank.this.getElementW() * 4;
                        }

                        @Override
                        public Color getColorE(boolean isActive) {
                            return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                        }
                    });
                }
            } else {
                menuElements.add(new Button_Stats_Flag_Clip2((Integer)tSorted.get(i6), "" + (i6 + 1) + ". " + CFG.core.getCiv((Integer)tSorted.get(i6)).getCivName(), CFG.PADD, CFG.PADD * 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2, CFG.getCivilizationRanking_IMG_STAR_CIVID((Integer)tSorted.get(i6))){

                    @Override
                    public int getWidthE() {
                        return Menu_InGameRank.this.getElementW() * 4;
                    }

                    @Override
                    public Color getColorE(boolean isActive) {
                        return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                    }
                });
            }
            int buttonCivID = CFG.FOG_OF_WAR == 2 ? (CFG.getMetCiv((Integer)tSorted.get(i6)) ? (Integer)tSorted.get(i6) : -1) : (Integer)tSorted.get(i6);
            menuElements.add(new ButtonStats(buttonCivID, detailsMode ? CFG.getNumber_SHORT(CFG.core.getCiv((Integer)tSorted.get(i6)).getNumberOfUnits()) : CFG.getNumberWthSpaces("" + CFG.gameAction.buildRank_Score_Military((Integer)tSorted.get(i6))), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 2, tPosY, CFG.BUTTON_W, tElemHeight2){

                @Override
                public int getPosXE() {
                    return Menu_InGameRank.this.getElementW() * 4 + CFG.PADD * 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGameRank.this.getElementW();
                }

                @Override
                public void actionElem(int iID) {
                    detailsMode = !detailsMode;
                    CFG.menus.rebuildInGame_Rank();
                }

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        if (this.getCurr() > 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Military") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).getNumberOfUnits()), CFG.COLOR_POPULATION));
                            nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_POPULATION, this.getCurr()));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        
                    }
                }
            });
            menuElements.add(new ButtonStats(buttonCivID, CFG.getNumberWthSpaces("" + (CFG.gameAction.buildRank_Score_Prestige((Integer)tSorted.get(i6)) / 3)), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, tPosY, CFG.BUTTON_W, tElemHeight2){

                @Override
                public int getPosXE() {
                    return Menu_InGameRank.this.getElementW() * 5 + CFG.PADD * 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGameRank.this.getElementW();
                }
            });
            menuElements.add(new ButtonStats(buttonCivID, CFG.getNumberWthSpaces("" + CFG.core.getCiv((Integer)tSorted.get(i6)).getRankScore()), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 5, tPosY, CFG.BUTTON_W, tElemHeight2){

                @Override
                public int getPosXE() {
                    return Menu_InGameRank.this.getElementW() * 6 + CFG.PADD * 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGameRank.this.getW() - Menu_InGameRank.this.getElementW() * 6;
                }

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        if (this.getCurr() > 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalScore") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).getRankScore()), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Image(Images.rank, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_RANK, this.getCurr()));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        
                    }
                }
            });
            tPosY += tElemHeight2;
        }
        int tempMenuPosY = IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 3 / 4 + CFG.PADD * 2;
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.11764706f, 0.30588236f, 0.6039216f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.11764706f, 0.30588236f, 0.6039216f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + (nWidth - 4) - (nWidth - 4) / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.425f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY + 1 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth / 2 + CFG.PADD + this.getTextWidth() / 2 + iTranslateX, nPosY + 1 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.325f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY + 2 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth / 2 + CFG.PADD + this.getTextWidth() / 2 + iTranslateX, nPosY + 2 - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, nPosY - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1, true, false);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth / 2 + CFG.PADD + this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - CFG.PADD * 6 - this.getTextWidth()) / 2, 1);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.PADD * 2 + AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD + CFG.BUTTON_H * 3 / 4, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
        for (int i7 = 0; i7 < this.getMenuElemsSize() - 1; ++i7) {
            this.getMenuElem(i7 + 1).setCurr(i7 / 4 % 2);
        }
    }

    @Override
    public void updateLang() {
        try {
            if (!CFG.SPECTATOR_MODE) {
                try {
                    this.getTitleM().setText(CFG.lang.get("Ranking") + " #" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRankPos());
                }
                catch (Exception exz) {
                    this.getTitleM().setText(CFG.lang.get("Ranking"));
                }
            } else {
                this.getTitleM().setText(CFG.lang.get("Ranking"));
            }
        }
        catch (Exception exception) {
            
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightM() + 2 + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + iTranslateX, this.getMenuPosY() - 1 + this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getMenuElem(0).getHeightE() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getMenuElem(0).getHeightE() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void actionCloseMenu() {
        super.actionCloseMenu();
        Keyboard.rankSearch = false;
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            Keyboard.rankSearch = false;
        }
    }

    @Override
    public final void actionEL(int iID) {
        if (iID == 0) {
            if (CFG.menus.getKeyboard().getVisibleM()) {
                Keyboard.rankSearch = false;
                CFG.menus.getKeyboard().setVisibleM(false);
            } else {
                Keyboard.mapModeSearch = false;
                Keyboard.commandsMode = false;
                Keyboard.changeAllianceNameMode = -1;
                Keyboard.changeCivilizationNameMode = -1;
                Keyboard.rankSearch = true;
                CFG.showKeyboard_Rank();
            }
        }
        switch (iID) {
            case 1: {
                if (iSort != 0) {
                    iSort = 0;
                    CFG.menus.rebuildInGame_Rank();
                }
                return;
            }
            case 2: {
                if (iSort != 1) {
                    iSort = 1;
                    CFG.menus.rebuildInGame_Rank();
                }
                return;
            }
            case 3: {
                if (iSort != 2) {
                    iSort = 2;
                    CFG.menus.rebuildInGame_Rank();
                }
                return;
            }
            case 4: {
                if (iSort != 3) {
                    iSort = 3;
                    CFG.menus.rebuildInGame_Rank();
                }
                return;
            }
            case 5: {
                if (iSort != 4) {
                    iSort = 4;
                    CFG.menus.rebuildInGame_Rank();
                }
                return;
            }
        }
        if ((iID - 1) % 5 == 0) {
            if (this.getMenuElem(iID).getCurr() > 0) {
                CFG.map.getMpC().centerToProvID(CFG.core.getCiv((int)this.getMenuElem(iID).getCurr()).getCapitalProvID());
            } else {
                CFG.toastM.addM(CFG.lang.get("UndiscoveredCivilization"), CFG.COLOR_HOVER_TITLE);
            }
        }
        super.actionEL(iID);
    }

    public final int getW() {
        return this.getWidthM() - CFG.PADD * 4;
    }

    public final int getElementW() {
        return this.getW() / 8;
    }
}

