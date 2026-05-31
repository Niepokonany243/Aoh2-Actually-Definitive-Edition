
package age.of.civilizations2.jakowski.lukasz.Menus.Military;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Alliance_Clip;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Clip;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Flag_Clip;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Title;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_Stats;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_MilitaryAlliances
extends Menu {
    public static int sortBy = 2;
    private List<Integer> lSorted = new ArrayList<Integer>();

    public Menu_InGame_MilitaryAlliances(int a) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2 + CFG.CIV_INFO_MENU_WIDTH / 2;
        int tempHeight = CFG.BUTTON_H + CFG.BUTTON_H * 3 / 4;
        int tElemHeight = CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        int tElemHeight2 = Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 4);
        menuElements.add(new TextScale(CFG.lang.get("----"), -1, 0, CFG.PADD, tempWidth - CFG.PADD * 4, CFG.BUTTON_H * 3 / 4, 0.75f){

            @Override
            public int getWidthE() {
                return Menu_InGame_MilitaryAlliances.this.getElementW();
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(false);
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("MilitaryAlliances"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.003921569f, 0.12941177f, 0.4117647f, 0.225f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.003921569f, 0.12941177f, 0.4117647f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + (nWidth - 4) - (nWidth - 4) / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.diploAlliance).drawO(oSB, nPosX + (nWidth - this.getTextWidth()) / 2 - CFG.PADD - IMGManager.getIMG(Images.diploAlliance).getWidth() + iTranslateX, 2 + nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.diploAlliance).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2, Menu_InGame_Stats.getMenuY(), tempWidth, tempHeight, menuElements, false, true);
    }

    public Menu_InGame_MilitaryAlliances() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2 + CFG.CIV_INFO_MENU_WIDTH / 2;
        int tempHeight = CFG.BUTTON_H + CFG.BUTTON_H * 3 / 4;
        int tElemHeight = CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        int tElemHeight2 = Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 4);
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Name"), CFG.PADD * 2, 2, 0, CFG.BUTTON_W * 2, tElemHeight){

            @Override
            public int getWidthE() {
                return Menu_InGame_MilitaryAlliances.this.getElementW() * 2 + CFG.PADD * 2 - 2;
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
            public Color getColorE(boolean isActive) {
                return sortBy == 0 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
            }
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Members"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 2, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_MilitaryAlliances.this.getElementW() * 2 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_MilitaryAlliances.this.getElementW();
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
            public Color getColorE(boolean isActive) {
                return sortBy == 1 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
            }
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Provinces"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 3, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_MilitaryAlliances.this.getElementW() * 3 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_MilitaryAlliances.this.getElementW();
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
            public Color getColorE(boolean isActive) {
                return sortBy == 2 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
            }
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Population"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_MilitaryAlliances.this.getElementW() * 4 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_MilitaryAlliances.this.getElementW();
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
            public Color getColorE(boolean isActive) {
                return sortBy == 3 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
            }
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Headquarters"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_MilitaryAlliances.this.getElementW() * 5 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_MilitaryAlliances.this.getElementW();
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
            public Color getColorE(boolean isActive) {
                return sortBy == 4 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
            }
        });
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Formation"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 5, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_MilitaryAlliances.this.getElementW() * 6 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_MilitaryAlliances.this.getW() - Menu_InGame_MilitaryAlliances.this.getElementW() * 6 + CFG.PADD * 2 - 2;
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
            public Color getColorE(boolean isActive) {
                return sortBy == 5 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : super.getColorE(isActive);
            }
        });
        try {
            int i;
            int tAdd;
            int i2;
            int tPosY = CFG.PADD + tElemHeight;
            ArrayList<Integer> tProvinces = new ArrayList<Integer>();
            ArrayList<Long> tPopulation = new ArrayList<Long>();
            for (int i3 = 1; i3 < CFG.core.getAlliancesSize(); ++i3) {
                tProvinces.add(CFG.core.getAlliance(i3).countProvinces());
                tPopulation.add(CFG.core.getAlliance(i3).countPopulation());
            }
            ArrayList<Integer> tempIDs = new ArrayList<Integer>();
            for (i2 = 1; i2 < CFG.core.getAlliancesSize(); ++i2) {
                tempIDs.add(i2);
            }
            if (sortBy == 0) {
                while (tempIDs.size() > 0) {
                    tAdd = 0;
                    for (i = 1; i < tempIDs.size(); ++i) {
                        if (!CFG.compareAlphabetic_TwoString(CFG.core.getAlliance((Integer)tempIDs.get(tAdd)).getAllianceName(), CFG.core.getAlliance((Integer)tempIDs.get(i)).getAllianceName())) continue;
                        tAdd = i;
                    }
                    this.lSorted.add((Integer)tempIDs.get(tAdd));
                    tempIDs.remove(tAdd);
                }
            } else if (sortBy == 1) {
                while (tempIDs.size() > 0) {
                    tAdd = 0;
                    for (i = 1; i < tempIDs.size(); ++i) {
                        if (CFG.core.getAlliance((Integer)tempIDs.get(tAdd)).getCivilizationsSize() >= CFG.core.getAlliance((Integer)tempIDs.get(i)).getCivilizationsSize()) continue;
                        tAdd = i;
                    }
                    this.lSorted.add((Integer)tempIDs.get(tAdd));
                    tempIDs.remove(tAdd);
                }
            } else if (sortBy == 2) {
                while (tempIDs.size() > 0) {
                    tAdd = 0;
                    for (i = 1; i < tempIDs.size(); ++i) {
                        if ((Integer)tProvinces.get((Integer)tempIDs.get(tAdd) - 1) >= (Integer)tProvinces.get((Integer)tempIDs.get(i) - 1)) continue;
                        tAdd = i;
                    }
                    this.lSorted.add((Integer)tempIDs.get(tAdd));
                    tempIDs.remove(tAdd);
                }
            } else if (sortBy == 3) {
                while (tempIDs.size() > 0) {
                    tAdd = 0;
                    for (i = 1; i < tempIDs.size(); ++i) {
                        if ((Long)tPopulation.get((Integer)tempIDs.get(tAdd) - 1) >= (Long)tPopulation.get((Integer)tempIDs.get(i) - 1)) continue;
                        tAdd = i;
                    }
                    this.lSorted.add((Integer)tempIDs.get(tAdd));
                    tempIDs.remove(tAdd);
                }
            } else if (sortBy == 4) {
                while (tempIDs.size() > 0) {
                    tAdd = 0;
                    for (i = 1; i < tempIDs.size(); ++i) {
                        if (!CFG.compareAlphabetic_TwoString(CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance((Integer)tempIDs.get(tAdd)).getCivilization(0)).getCapitalProvID()).getCitSize() > 0 ? CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance((Integer)tempIDs.get(tAdd)).getCivilization(0)).getCapitalProvID()).getCit(0).getCityName() : (CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance((Integer)tempIDs.get(tAdd)).getCivilization(0)).getCapitalProvID()).getName().length() > 0 ? CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance((Integer)tempIDs.get(tAdd)).getCivilization(0)).getCapitalProvID()).getName() : CFG.core.getCiv(CFG.core.getAlliance((Integer)tempIDs.get(tAdd)).getCivilization(0)).getCivName()), CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance((Integer)tempIDs.get(i)).getCivilization(0)).getCapitalProvID()).getCitSize() > 0 ? CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance((Integer)tempIDs.get(i)).getCivilization(0)).getCapitalProvID()).getCit(0).getCityName() : (CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance((Integer)tempIDs.get(i)).getCivilization(0)).getCapitalProvID()).getName().length() > 0 ? CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance((Integer)tempIDs.get(i)).getCivilization(0)).getCapitalProvID()).getName() : CFG.core.getCiv(CFG.core.getAlliance((Integer)tempIDs.get(i)).getCivilization(0)).getCivName()))) continue;
                        tAdd = i;
                    }
                    this.lSorted.add((Integer)tempIDs.get(tAdd));
                    tempIDs.remove(tAdd);
                }
            } else if (sortBy == 5) {
                while (tempIDs.size() > 0) {
                    tAdd = 0;
                    for (i = 1; i < tempIDs.size(); ++i) {
                        if (CFG.core.getAlliance((Integer)tempIDs.get(tAdd)).getFormationTurnID() >= CFG.core.getAlliance((Integer)tempIDs.get(i)).getFormationTurnID()) continue;
                        tAdd = i;
                    }
                    this.lSorted.add((Integer)tempIDs.get(tAdd));
                    tempIDs.remove(tAdd);
                }
            }
            for (i2 = 0; i2 < this.lSorted.size(); ++i2) {
                if (CFG.core.getCiv(CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0)).getCapitalProvID() < 0) continue;
                menuElements.add(new Button_Stats_Alliance_Clip(CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetAlliance(this.lSorted.get(i2)) ? this.lSorted.get(i2) : -1, CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetAlliance(this.lSorted.get(i2)) ? CFG.core.getAlliance(this.lSorted.get(i2)).getAllianceName() : CFG.lang.get("Undiscovered")) : CFG.core.getAlliance(this.lSorted.get(i2)).getAllianceName(), CFG.PADD, CFG.PADD * 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2){

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_MilitaryAlliances.this.getElementW() * 2;
                    }

                    @Override
                    public Color getColorE(boolean isActive) {
                        return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                    }

                    @Override
                    public int getSFXElem() {
                        return SFXManager.SFX_CLICK2;
                    }
                });
                menuElements.add(new ButtonStats("" + CFG.core.getAlliance(this.lSorted.get(i2)).getCivilizationsSize(), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 3, tPosY, CFG.BUTTON_W, tElemHeight2){

                    @Override
                    public int getPosXE() {
                        return Menu_InGame_MilitaryAlliances.this.getElementW() * 2 + CFG.PADD * 2;
                    }

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_MilitaryAlliances.this.getElementW();
                    }
                });
                menuElements.add(new ButtonStats(CFG.getNumberWthSpaces("" + tProvinces.get(this.lSorted.get(i2) - 1)), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, tPosY, CFG.BUTTON_W, tElemHeight2){

                    @Override
                    public int getPosXE() {
                        return Menu_InGame_MilitaryAlliances.this.getElementW() * 3 + CFG.PADD * 2;
                    }

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_MilitaryAlliances.this.getElementW();
                    }
                });
                menuElements.add(new ButtonStats(CFG.getNumberWthSpaces("" + tPopulation.get(this.lSorted.get(i2) - 1)), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, tPosY, CFG.BUTTON_W, tElemHeight2){

                    @Override
                    public int getPosXE() {
                        return Menu_InGame_MilitaryAlliances.this.getElementW() * 4 + CFG.PADD * 2;
                    }

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_MilitaryAlliances.this.getElementW();
                    }
                });
                menuElements.add(new Button_Stats_Flag_Clip(CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0)) ? CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0) : -1) : CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0), CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0)).getCapitalProvID()) ? (CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0)).getCapitalProvID()).getCitSize() > 0 ? CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0)).getCapitalProvID()).getCit(0).getCityName() : (CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0)).getCapitalProvID()).getName().length() > 0 ? CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0)).getCapitalProvID()).getName() : CFG.core.getCiv(CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0)).getCivName())) : CFG.lang.get("Undiscovered")) : (CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0)).getCapitalProvID()).getCitSize() > 0 ? CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0)).getCapitalProvID()).getCit(0).getCityName() : (CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0)).getCapitalProvID()).getName().length() > 0 ? CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0)).getCapitalProvID()).getName() : CFG.core.getCiv(CFG.core.getAlliance(this.lSorted.get(i2)).getCivilization(0)).getCivName())), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 2, tPosY, CFG.BUTTON_W, tElemHeight2){

                    @Override
                    public int getPosXE() {
                        return Menu_InGame_MilitaryAlliances.this.getElementW() * 5 + CFG.PADD * 2;
                    }

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_MilitaryAlliances.this.getElementW();
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
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            
                        }
                    }
                });
                menuElements.add(new Button_Stats_Clip("" + GameCalendar.getDate_ByTurnID(CFG.core.getAlliance(this.lSorted.get(i2)).getFormationTurnID()), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 5, tPosY, CFG.BUTTON_W, tElemHeight2){

                    @Override
                    public int getPosXE() {
                        return Menu_InGame_MilitaryAlliances.this.getElementW() * 6 + CFG.PADD * 2;
                    }

                    @Override
                    public int getWidthE() {
                        return Menu_InGame_MilitaryAlliances.this.getW() - Menu_InGame_MilitaryAlliances.this.getElementW() * 6;
                    }

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Formation") + ": "));
                            nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            
                        }
                    }
                });
                tPosY += tElemHeight2;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("MilitaryAlliances"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.003921569f, 0.12941177f, 0.4117647f, 0.225f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.003921569f, 0.12941177f, 0.4117647f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + (nWidth - 4) - (nWidth - 4) / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.diploAlliance).drawO(oSB, nPosX + (nWidth - this.getTextWidth()) / 2 - CFG.PADD - IMGManager.getIMG(Images.diploAlliance).getWidth() + iTranslateX, 2 + nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.diploAlliance).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2, Menu_InGame_Stats.getMenuY(), tempWidth, tempHeight, menuElements, false, true);
        this.updateLang();
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(i / 6 % 2);
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
        switch (iID) {
            case 0: {
                if (sortBy != iID) {
                    sortBy = iID;
                    CFG.menus.rebuildInGame_MilitaryAlliances();
                }
                return;
            }
            case 1: {
                if (sortBy != iID) {
                    sortBy = iID;
                    CFG.menus.rebuildInGame_MilitaryAlliances();
                }
                return;
            }
            case 2: {
                if (sortBy != iID) {
                    sortBy = iID;
                    CFG.menus.rebuildInGame_MilitaryAlliances();
                }
                return;
            }
            case 3: {
                if (sortBy != iID) {
                    sortBy = iID;
                    CFG.menus.rebuildInGame_MilitaryAlliances();
                }
                return;
            }
            case 4: {
                if (sortBy != iID) {
                    sortBy = iID;
                    CFG.menus.rebuildInGame_MilitaryAlliances();
                }
                return;
            }
            case 5: {
                if (sortBy != iID) {
                    sortBy = iID;
                    CFG.menus.rebuildInGame_MilitaryAlliances();
                }
                return;
            }
        }
        if (iID % 6 == 0 || iID % 6 == 1) {
            CFG.menus.rebuildInGame_Alliance(this.lSorted.get(iID / 6 - 1));
        } else if (iID % 6 == 4 && (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(CFG.core.getAlliance(this.lSorted.get(iID / 6 - 1)).getCivilization(0)).getCapitalProvID()))) {
            CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getAlliance(this.lSorted.get(iID / 6 - 1)).getCivilization(0)).getCapitalProvID());
            CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
        }
    }

    public final int getW() {
        return this.getWidthM() - CFG.PADD * 4;
    }

    public final int getElementW() {
        return this.getW() / 7;
    }
}

