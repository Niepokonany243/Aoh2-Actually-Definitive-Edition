
package age.of.civilizations2.jakowski.lukasz.Menus.Stats.WorldPopulation;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Color;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Flag_Clip;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Flag_Clip_ProvinceID;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Title;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Stats.WorldPopulation.Menu_InGame_WorldPopulationContinent;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_WorldPopulation
extends Menu {
    public static int iSort = 0;

    public Menu_InGame_WorldPopulation(int tInit) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 3;
        int tempMenuPosY = IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 3 / 5 + CFG.PADD * 2;
        this.initMenu(null, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, 5, menuElements, false, false);
    }

    public Menu_InGame_WorldPopulation() {
        int i;
        int tAdd;
        int i2;
        int i3;
        int i4;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 3;
        int tElemHeight = CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        int tElemHeight2 = Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 4);
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Name"), CFG.PADD * 2, 2, 0, CFG.BUTTON_W * 2, tElemHeight){

            @Override
            public int getWidthE() {
                return Menu_InGame_WorldPopulation.this.getElementW() * 2 + CFG.PADD * 2 - 2;
            }

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
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Population"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 2, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_WorldPopulation.this.getElementW() * 2 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_WorldPopulation.this.getElementW();
            }

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
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Civilizations"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 3, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_WorldPopulation.this.getElementW() * 3 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_WorldPopulation.this.getElementW();
            }

            @Override
            public Color getColorE(boolean isActive) {
                return iSort == 2 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
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
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Provinces"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_WorldPopulation.this.getElementW() * 4 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_WorldPopulation.this.getElementW();
            }

            @Override
            public Color getColorE(boolean isActive) {
                return iSort == 3 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
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
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("MostPopulous"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_WorldPopulation.this.getElementW() * 5 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_WorldPopulation.this.getElementW();
            }

            @Override
            public Color getColorE(boolean isActive) {
                return iSort == 4 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
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
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("LargestCity"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 5, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_WorldPopulation.this.getElementW() * 6 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_WorldPopulation.this.getW() - Menu_InGame_WorldPopulation.this.getElementW() * 6 + CFG.PADD * 2 - 2;
            }

            @Override
            public Color getColorE(boolean isActive) {
                return iSort == 5 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
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
        });
        int tPosY = CFG.PADD + tElemHeight;
        ArrayList<Long> tPopulation = new ArrayList<Long>();
        ArrayList tCivilizations = new ArrayList();
        ArrayList<Integer> tProvinces = new ArrayList<Integer>();
        ArrayList<Integer> tLargestCity = new ArrayList<Integer>();
        ArrayList tMostPopulous2 = new ArrayList();
        ArrayList<Integer> tMostPopulousID = new ArrayList<Integer>();
        for (i4 = 0; i4 < CFG.map.getMapContinents().getContinentsSize(); ++i4) {
            tPopulation.add(0L);
            tCivilizations.add(new ArrayList());
            tProvinces.add(0);
            tLargestCity.add(-1);
            tMostPopulous2.add(new ArrayList());
            tMostPopulousID.add(0);
        }
        for (i4 = 0; i4 < CFG.core.getProvinSize(); ++i4) {
            if (CFG.core.getProv(i4).getWastelandLvl() >= 0 || CFG.core.getProv(i4).getSeaProv()) continue;
            tPopulation.set(CFG.core.getProv(i4).getContinent(), (Long)tPopulation.get(CFG.core.getProv(i4).getContinent()) + CFG.core.getProv(i4).getPop().getPops());
            tProvinces.set(CFG.core.getProv(i4).getContinent(), (Integer)tProvinces.get(CFG.core.getProv(i4).getContinent()) + 1);
            if (CFG.core.getProv(i4).getCivId() > 0) {
                boolean tAdd2 = true;
                for (int j = 0; j < ((List)tCivilizations.get(CFG.core.getProv(i4).getContinent())).size(); ++j) {
                    if (((Integer)((List)tCivilizations.get(CFG.core.getProv(i4).getContinent())).get(j)).intValue() != CFG.core.getProv(i4).getCivId()) continue;
                    tAdd2 = false;
                    ((List)tMostPopulous2.get(CFG.core.getProv(i4).getContinent())).set(j, (Long)((List)tMostPopulous2.get(CFG.core.getProv(i4).getContinent())).get(j) + CFG.core.getProv(i4).getPop().getPops());
                    break;
                }
                if (tAdd2) {
                    ((List)tCivilizations.get(CFG.core.getProv(i4).getContinent())).add(CFG.core.getProv(i4).getCivId());
                    ((List)tMostPopulous2.get(CFG.core.getProv(i4).getContinent())).add(CFG.core.getProv(i4).getPop().getPops());
                }
            }
            if ((Integer)tLargestCity.get(CFG.core.getProv(i4).getContinent()) < 0) {
                tLargestCity.set(CFG.core.getProv(i4).getContinent(), i4);
                continue;
            }
            if (CFG.core.getProv((Integer)tLargestCity.get(CFG.core.getProv(i4).getContinent())).getPop().getPops() >= CFG.core.getProv(i4).getPop().getPops()) continue;
            tLargestCity.set(CFG.core.getProv(i4).getContinent(), i4);
        }
        for (i4 = 0; i4 < tMostPopulous2.size(); ++i4) {
            for (int j = 1; j < ((List)tMostPopulous2.get(i4)).size(); ++j) {
                if ((Long)((List)tMostPopulous2.get(i4)).get(j) <= (Long)((List)tMostPopulous2.get(i4)).get((Integer)tMostPopulousID.get(i4))) continue;
                tMostPopulousID.set(i4, j);
            }
        }
        int tTotalPop = 0;
        int tCivsTotal = 0;
        int tProvincesTotal = 0;
        int tLargestCityTotal = -1;
        int tMostPopulousTotal = 1;
        int tempMostPopulation = (int)Math.max(1L, CFG.core.getCiv(tMostPopulousTotal).countPop());
        for (i3 = 0; i3 < tPopulation.size(); ++i3) {
            tTotalPop += ((Long)tPopulation.get(i3)).intValue();
            tProvincesTotal += ((Integer)tProvinces.get(i3)).intValue();
            if (tLargestCityTotal < 0) {
                if ((Integer)tLargestCity.get(i3) < 0) continue;
                tLargestCityTotal = (Integer)tLargestCity.get(i3);
                continue;
            }
            if ((Integer)tLargestCity.get(i3) < 0 || CFG.core.getProv(tLargestCityTotal).getPop().getPops() >= CFG.core.getProv((Integer)tLargestCity.get(i3)).getPop().getPops()) continue;
            tLargestCityTotal = (Integer)tLargestCity.get(i3);
        }
        for (i3 = 1; i3 < CFG.core.getCivsSize(); ++i3) {
            if (CFG.core.getCiv(i3).getNumOfProvs() <= 0) continue;
            ++tCivsTotal;
            if (CFG.core.getCiv(i3).countPop() <= (long)tempMostPopulation) continue;
            tMostPopulousTotal = i3;
            tempMostPopulation = (int)Math.max(1L, CFG.core.getCiv(tMostPopulousTotal).countPop());
        }
        menuElements.add(new Button_Stats_Color(new Color(1.0f, 1.0f, 1.0f, 0.95f), "" + CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()), CFG.PADD, CFG.PADD * 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2){

            @Override
            public int getWidthE() {
                return Menu_InGame_WorldPopulation.this.getElementW() * 2;
            }

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonStats(CFG.getNumberWthSpaces("" + tTotalPop), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 2, tPosY, CFG.BUTTON_W, tElemHeight2){

            @Override
            public int getPosXE() {
                return Menu_InGame_WorldPopulation.this.getElementW() * 2 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_WorldPopulation.this.getElementW();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Population") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_POPULATION));
                nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonStats(CFG.getNumberWthSpaces("" + tCivsTotal), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 3, tPosY, CFG.BUTTON_W, tElemHeight2){

            @Override
            public int getPosXE() {
                return Menu_InGame_WorldPopulation.this.getElementW() * 3 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_WorldPopulation.this.getElementW();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Civilizations") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploLord, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new ButtonStats(CFG.getNumberWthSpaces("" + tProvincesTotal), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, tPosY, CFG.BUTTON_W, tElemHeight2){

            @Override
            public int getPosXE() {
                return Menu_InGame_WorldPopulation.this.getElementW() * 4 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_WorldPopulation.this.getElementW();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Provinces") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Stats_Flag_Clip(CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(tMostPopulousTotal) ? tMostPopulousTotal : -1) : tMostPopulousTotal, CFG.getNumberWthSpaces("" + tempMostPopulation), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, tPosY, CFG.BUTTON_W, tElemHeight2){

            @Override
            public int getPosXE() {
                return Menu_InGame_WorldPopulation.this.getElementW() * 5 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_WorldPopulation.this.getElementW();
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (CFG.FOG_OF_WAR == 2) {
                        if (this.getCurr() < 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Flag(this.getCurr()));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).countPop()), CFG.COLOR_POPULATION));
                            nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Flag(this.getCurr()));
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).countPop()), CFG.COLOR_POPULATION));
                        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    
                }
            }
        });
        menuElements.add(new Button_Stats_Flag_Clip_ProvinceID(CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(tLargestCityTotal) ? tLargestCityTotal : -1) : tLargestCityTotal, CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(tLargestCityTotal) ? (CFG.core.getProv(tLargestCityTotal).getCitSize() > 0 ? CFG.core.getProv(tLargestCityTotal).getCit(0).getCityName() : (CFG.core.getProv(tLargestCityTotal).getName().length() > 0 ? CFG.core.getProv(tLargestCityTotal).getName() : CFG.lang.get("NoData"))) : CFG.lang.get("Undiscovered")) : (CFG.core.getProv(tLargestCityTotal).getCitSize() > 0 ? CFG.core.getProv(tLargestCityTotal).getCit(0).getCityName() : (CFG.core.getProv(tLargestCityTotal).getName().length() > 0 ? CFG.core.getProv(tLargestCityTotal).getName() : CFG.lang.get("NoData"))), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 5, tPosY, CFG.BUTTON_W, tElemHeight2){

            @Override
            public int getPosXE() {
                return Menu_InGame_WorldPopulation.this.getElementW() * 6 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_WorldPopulation.this.getW() - Menu_InGame_WorldPopulation.this.getElementW() * 6;
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (CFG.FOG_OF_WAR == 2) {
                        if (this.getCurr() < 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
                            nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.getCurr()).getCivId()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(this.getCurr()).getCivId()).getCivName() + " - " + this.getTextE(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getProv(this.getCurr()).getPop().getPops()), CFG.COLOR_POPULATION));
                            nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.getCurr()).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(this.getCurr()).getCivId()).getCivName() + " - " + this.getTextE(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getProv(this.getCurr()).getPop().getPops()), CFG.COLOR_POPULATION));
                        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
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
        ArrayList<Integer> tSorted = new ArrayList<Integer>();
        ArrayList<Integer> tempIDs = new ArrayList<Integer>();
        for (i2 = 0; i2 < tProvinces.size(); ++i2) {
            if ((Integer)tProvinces.get(i2) <= 0) continue;
            tempIDs.add(i2);
        }
        if (iSort == 0) {
            while (tempIDs.size() > 0) {
                tAdd = 0;
                for (i = 1; i < tempIDs.size(); ++i) {
                    if (!CFG.compareAlphabetic_TwoString(CFG.map.getMapContinents().getName((Integer)tempIDs.get(tAdd)), CFG.map.getMapContinents().getName((Integer)tempIDs.get(i)))) continue;
                    tAdd = i;
                }
                tSorted.add((Integer)tempIDs.get(tAdd));
                tempIDs.remove(tAdd);
            }
        } else if (iSort == 1) {
            while (tempIDs.size() > 0) {
                tAdd = 0;
                for (i = 1; i < tempIDs.size(); ++i) {
                    if ((Long)tPopulation.get((Integer)tempIDs.get(tAdd)) >= (Long)tPopulation.get((Integer)tempIDs.get(i))) continue;
                    tAdd = i;
                }
                tSorted.add((Integer)tempIDs.get(tAdd));
                tempIDs.remove(tAdd);
            }
        } else if (iSort == 2) {
            while (tempIDs.size() > 0) {
                tAdd = 0;
                for (i = 1; i < tempIDs.size(); ++i) {
                    if (((List)tCivilizations.get((Integer)tempIDs.get(tAdd))).size() >= ((List)tCivilizations.get((Integer)tempIDs.get(i))).size()) continue;
                    tAdd = i;
                }
                tSorted.add((Integer)tempIDs.get(tAdd));
                tempIDs.remove(tAdd);
            }
        } else if (iSort == 3) {
            while (tempIDs.size() > 0) {
                tAdd = 0;
                for (i = 1; i < tempIDs.size(); ++i) {
                    if ((Integer)tProvinces.get((Integer)tempIDs.get(tAdd)) >= (Integer)tProvinces.get((Integer)tempIDs.get(i))) continue;
                    tAdd = i;
                }
                tSorted.add((Integer)tempIDs.get(tAdd));
                tempIDs.remove(tAdd);
            }
        } else if (iSort == 4) {
            while (tempIDs.size() > 0) {
                tAdd = 0;
                for (i = 1; i < tempIDs.size(); ++i) {
                    try {
                        if ((Long)((List)tMostPopulous2.get((Integer)tempIDs.get(tAdd))).get((Integer)tMostPopulousID.get((Integer)tempIDs.get(tAdd))) >= (Long)((List)tMostPopulous2.get((Integer)tempIDs.get(i))).get((Integer)tMostPopulousID.get((Integer)tempIDs.get(i)))) continue;
                        tAdd = i;
                        continue;
                    }
                    catch (IndexOutOfBoundsException ex) {
                        if (((List)tMostPopulous2.get((Integer)tempIDs.get(tAdd))).size() != 0) continue;
                        tAdd = i;
                    }
                }
                tSorted.add((Integer)tempIDs.get(tAdd));
                tempIDs.remove(tAdd);
            }
        } else if (iSort == 5) {
            while (tempIDs.size() > 0) {
                tAdd = 0;
                for (i = 1; i < tempIDs.size(); ++i) {
                    if (CFG.core.getProv((Integer)tLargestCity.get((Integer)tempIDs.get(tAdd))).getPop().getPops() >= CFG.core.getProv((Integer)tLargestCity.get((Integer)tempIDs.get(i))).getPop().getPops()) continue;
                    tAdd = i;
                }
                tSorted.add((Integer)tempIDs.get(tAdd));
                tempIDs.remove(tAdd);
            }
        }
        for (i2 = 0; i2 < tSorted.size(); ++i2) {
            menuElements.add(new Button_Stats_Color(CFG.map.getMapContinents().getColor((Integer)tSorted.get(i2)), "" + CFG.map.getMapContinents().getName((Integer)tSorted.get(i2)), CFG.PADD, CFG.PADD * 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_WorldPopulation.this.getElementW() * 2;
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Continent") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new ButtonStats(CFG.getNumberWthSpaces("" + tPopulation.get((Integer)tSorted.get(i2))), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 2, tPosY, CFG.BUTTON_W, tElemHeight2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_WorldPopulation.this.getElementW() * 2 + CFG.PADD * 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_WorldPopulation.this.getElementW();
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Population") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_POPULATION));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new ButtonStats(CFG.getNumberWthSpaces("" + ((List)tCivilizations.get((Integer)tSorted.get(i2))).size()), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 3, tPosY, CFG.BUTTON_W, tElemHeight2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_WorldPopulation.this.getElementW() * 3 + CFG.PADD * 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_WorldPopulation.this.getElementW();
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Civilizations") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploLord, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new ButtonStats(CFG.getNumberWthSpaces("" + tProvinces.get((Integer)tSorted.get(i2))), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, tPosY, CFG.BUTTON_W, tElemHeight2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_WorldPopulation.this.getElementW() * 4 + CFG.PADD * 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_WorldPopulation.this.getElementW();
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Provinces") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            try {
                menuElements.add(new Button_Stats_Flag_Clip(CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)((List)tCivilizations.get((Integer)tSorted.get(i2))).get((Integer)tMostPopulousID.get((Integer)tSorted.get(i2)))) ? (Integer)((List)tCivilizations.get((Integer)tSorted.get(i2))).get((Integer)tMostPopulousID.get((Integer)tSorted.get(i2))) : -1) : (Integer)((List)tCivilizations.get((Integer)tSorted.get(i2))).get((Integer)tMostPopulousID.get((Integer)tSorted.get(i2))), CFG.getNumberWthSpaces("" + ((List)tMostPopulous2.get((Integer)tSorted.get(i2))).get((Integer)tMostPopulousID.get((Integer)tSorted.get(i2)))), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, tPosY, CFG.BUTTON_W, tElemHeight2){

                    @Override
                    public int getPosXE() {
                        return Menu_InGame_WorldPopulation.this.getElementW() * 5 + CFG.PADD * 2;
                    }

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_WorldPopulation.this.getElementW();
                    }

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            if (CFG.FOG_OF_WAR == 2) {
                                if (this.getCurr() < 0) {
                                    nData.add(new ME_Hover_2Type_Flag_Big(-1));
                                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                } else {
                                    nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr()));
                                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                    nData.add(new ME_Hover_2Type_Space());
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                    nData.add(new ME_Hover_2Type_Flag(this.getCurr()));
                                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                                    nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).countPop()), CFG.COLOR_POPULATION));
                                    nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                }
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Space());
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Flag(this.getCurr()));
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).countPop()), CFG.COLOR_POPULATION));
                                nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            
                        }
                    }
                });
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
                menuElements.add(new Button_Stats_Flag_Clip(0, "---", CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, tPosY, CFG.BUTTON_W, tElemHeight2){

                    @Override
                    public int getPosXE() {
                        return Menu_InGame_WorldPopulation.this.getElementW() * 5 + CFG.PADD * 2;
                    }

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_WorldPopulation.this.getElementW();
                    }

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Flag(this.getCurr()));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).countPop()), CFG.COLOR_POPULATION));
                            nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            
                        }
                    }
                });
            }
            menuElements.add(new Button_Stats_Flag_Clip_ProvinceID(CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv((Integer)tLargestCity.get((Integer)tSorted.get(i2))) ? (Integer)tLargestCity.get((Integer)tSorted.get(i2)) : -1) : (Integer)tLargestCity.get((Integer)tSorted.get(i2)), CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv((Integer)tLargestCity.get((Integer)tSorted.get(i2))) ? (CFG.core.getProv((Integer)tLargestCity.get((Integer)tSorted.get(i2))).getCitSize() > 0 ? CFG.core.getProv((Integer)tLargestCity.get((Integer)tSorted.get(i2))).getCit(0).getCityName() : (CFG.core.getProv((Integer)tLargestCity.get((Integer)tSorted.get(i2))).getName().length() > 0 ? CFG.core.getProv((Integer)tLargestCity.get((Integer)tSorted.get(i2))).getName() : CFG.lang.get("NoData"))) : CFG.lang.get("Undiscovered")) : (CFG.core.getProv((Integer)tLargestCity.get((Integer)tSorted.get(i2))).getCitSize() > 0 ? CFG.core.getProv((Integer)tLargestCity.get((Integer)tSorted.get(i2))).getCit(0).getCityName() : (CFG.core.getProv((Integer)tLargestCity.get((Integer)tSorted.get(i2))).getName().length() > 0 ? CFG.core.getProv((Integer)tLargestCity.get((Integer)tSorted.get(i2))).getName() : CFG.lang.get("NoData"))), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 5, tPosY, CFG.BUTTON_W, tElemHeight2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_WorldPopulation.this.getElementW() * 6 + CFG.PADD * 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_WorldPopulation.this.getW() - Menu_InGame_WorldPopulation.this.getElementW() * 6;
                }

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        if (CFG.FOG_OF_WAR == 2) {
                            if (this.getCurr() < 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(-1));
                                nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.getCurr()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(this.getCurr()).getCivId()).getCivName() + " - " + this.getTextE(), CFG.COLOR_HOVER_TITLE));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Space());
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getProv(this.getCurr()).getPop().getPops()), CFG.COLOR_POPULATION));
                                nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.getCurr()).getCivId()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(this.getCurr()).getCivId()).getCivName() + " - " + this.getTextE(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getProv(this.getCurr()).getPop().getPops()), CFG.COLOR_POPULATION));
                            nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
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
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Population"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.0f, 0.627451f, 0.0f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.0f, 0.627451f, 0.0f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + (nWidth - 4) - (nWidth - 4) / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.pop).drawO(oSB, nPosX + (nWidth - this.getTextWidth()) / 2 - CFG.PADD * 2 - IMGManager.getIMG(Images.pop).getWidth() + iTranslateX, 2 + nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.pop).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, tElemHeight2 * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
        for (int i5 = 0; i5 < this.getMenuElemsSize(); ++i5) {
            this.getMenuElem(i5).setCurr(i5 / 6 % 2);
        }
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightM() + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + Core.PADDING, true, true);
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
    public final void actionEL(int iID) {
        block28: {
            switch (iID) {
                case 0: {
                    if (iSort != iID) {
                        iSort = iID;
                        CFG.menus.rebuildInGame_WorldPopulation();
                    }
                    return;
                }
                case 1: {
                    if (iSort != iID) {
                        iSort = iID;
                        CFG.menus.rebuildInGame_WorldPopulation();
                    }
                    return;
                }
                case 2: {
                    if (iSort != iID) {
                        iSort = iID;
                        CFG.menus.rebuildInGame_WorldPopulation();
                    }
                    return;
                }
                case 3: {
                    if (iSort != iID) {
                        iSort = iID;
                        CFG.menus.rebuildInGame_WorldPopulation();
                    }
                    return;
                }
                case 4: {
                    if (iSort != iID) {
                        iSort = iID;
                        CFG.menus.rebuildInGame_WorldPopulation();
                    }
                    return;
                }
                case 5: {
                    if (iSort != iID) {
                        iSort = iID;
                        CFG.menus.rebuildInGame_WorldPopulation();
                    }
                    return;
                }
            }
            if (iID % 6 == 5) {
                try {
                    if (this.getMenuElem(iID).getCurr() >= 0 && (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.getMenuElem(iID).getCurr()))) {
                        CFG.core.setActiveProvID(this.getMenuElem(iID).getCurr());
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                    }
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
            } else if (iID % 6 == 4) {
                try {
                    if (this.getMenuElem(iID).getCurr() >= 0 && (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(this.getMenuElem(iID).getCurr()).getCapitalProvID()))) {
                        CFG.core.setActiveProvID(CFG.core.getCiv(this.getMenuElem(iID).getCurr()).getCapitalProvID());
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                    }
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
            } else if (iID % 6 == 0) {
                try {
                    if (iID / 6 <= 0) break block28;
                    for (int i = 0; i < CFG.map.getMapContinents().getContinentsSize(); ++i) {
                        if (!CFG.map.getMapContinents().getName(i).equals(this.getMenuElem(iID).getTextE())) continue;
                        Menu_InGame_WorldPopulationContinent.CONTINENT_ID = i;
                        CFG.menus.rebuildInGame_ContinentPopulation();
                        break;
                    }
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    
                }
            }
        }
    }

    public final int getW() {
        return this.getWidthM() - CFG.PADD * 4;
    }

    public final int getElementW() {
        return this.getW() / 7;
    }
}



