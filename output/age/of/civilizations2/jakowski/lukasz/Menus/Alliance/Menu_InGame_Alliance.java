
package age.of.civilizations2.jakowski.lukasz.Menus.Alliance;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Flag_Clip;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Title;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Total;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Keyboard;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_Alliance
extends Menu {
    private long lTime = 0L;
    public static int ALLIANCE_ID = 0;
    public static int sortBy = 0;
    private String sFormDate = "";
    private int iFormDateWidth;

    public Menu_InGame_Alliance() {
        int i;
        int i2;
        int tAddID;
        int i3;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2 + CFG.CIV_INFO_MENU_WIDTH / 4;
        int tempHeight = CFG.BUTTON_H + CFG.BUTTON_H * 3 / 4;
        int tElemHeight = CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        int tElemHeight2 = Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 4);
        this.sFormDate = GameCalendar.getDate_ByTurnID(CFG.core.getAlliance(ALLIANCE_ID).getFormationTurnID());
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sFormDate);
        this.iFormDateWidth = (int)CFG.glyphLay.width;
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Members"), CFG.PADD * 2, 2, 0, CFG.BUTTON_W * 2, tElemHeight){

            @Override
            public int getWidthE() {
                return Menu_InGame_Alliance.this.getElementW() * 2 + CFG.PADD * 2 - 2;
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
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Provinces"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 2, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_Alliance.this.getElementW() * 2 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Alliance.this.getElementW();
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
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Population"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 3, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_Alliance.this.getElementW() * 3 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Alliance.this.getElementW();
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
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Economy"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_Alliance.this.getElementW() * 4 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Alliance.this.getElementW();
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
        menuElements.add(new Button_Stats_Title(CFG.lang.get("Technology"), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 5, 0, CFG.BUTTON_W, tElemHeight){

            @Override
            public int getPosXE() {
                return Menu_InGame_Alliance.this.getElementW() * 5 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Alliance.this.getW() - Menu_InGame_Alliance.this.getElementW() * 5 + CFG.PADD * 2 - 2;
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
        int tPosY = tElemHeight;
        ArrayList<Integer> tCivsSorted = new ArrayList<Integer>();
        if (sortBy == 1) {
            ArrayList<Integer> tempL = new ArrayList<Integer>();
            for (i3 = 0; i3 < CFG.core.getAlliance(ALLIANCE_ID).getCivilizationsSize(); ++i3) {
                tempL.add(CFG.core.getAlliance(ALLIANCE_ID).getCivilization(i3));
            }
            while (tempL.size() > 0) {
                tAddID = 0;
                for (i2 = 1; i2 < tempL.size(); ++i2) {
                    if (CFG.core.getCiv((Integer)tempL.get(tAddID)).getNumOfProvs() >= CFG.core.getCiv((Integer)tempL.get(i2)).getNumOfProvs()) continue;
                    tAddID = i2;
                }
                tCivsSorted.add((Integer)tempL.get(tAddID));
                tempL.remove(tAddID);
            }
        } else if (sortBy == 2) {
            ArrayList<Integer> tempL = new ArrayList<Integer>();
            for (i3 = 0; i3 < CFG.core.getAlliance(ALLIANCE_ID).getCivilizationsSize(); ++i3) {
                tempL.add(CFG.core.getAlliance(ALLIANCE_ID).getCivilization(i3));
            }
            while (tempL.size() > 0) {
                tAddID = 0;
                for (i2 = 1; i2 < tempL.size(); ++i2) {
                    if (CFG.core.getCiv((Integer)tempL.get(tAddID)).countPop() >= CFG.core.getCiv((Integer)tempL.get(i2)).countPop()) continue;
                    tAddID = i2;
                }
                tCivsSorted.add((Integer)tempL.get(tAddID));
                tempL.remove(tAddID);
            }
        } else if (sortBy == 3) {
            ArrayList<Integer> tempL = new ArrayList<Integer>();
            for (i3 = 0; i3 < CFG.core.getAlliance(ALLIANCE_ID).getCivilizationsSize(); ++i3) {
                tempL.add(CFG.core.getAlliance(ALLIANCE_ID).getCivilization(i3));
            }
            while (tempL.size() > 0) {
                tAddID = 0;
                for (i2 = 1; i2 < tempL.size(); ++i2) {
                    if (CFG.core.getCiv((Integer)tempL.get(tAddID)).countEco() >= CFG.core.getCiv((Integer)tempL.get(i2)).countEco()) continue;
                    tAddID = i2;
                }
                tCivsSorted.add((Integer)tempL.get(tAddID));
                tempL.remove(tAddID);
            }
        } else if (sortBy == 4) {
            ArrayList<Integer> tempL = new ArrayList<Integer>();
            for (i3 = 0; i3 < CFG.core.getAlliance(ALLIANCE_ID).getCivilizationsSize(); ++i3) {
                tempL.add(CFG.core.getAlliance(ALLIANCE_ID).getCivilization(i3));
            }
            while (tempL.size() > 0) {
                tAddID = 0;
                for (i2 = 1; i2 < tempL.size(); ++i2) {
                    if (!(CFG.core.getCiv((Integer)tempL.get(tAddID)).getTechLevel() < CFG.core.getCiv((Integer)tempL.get(i2)).getTechLevel())) continue;
                    tAddID = i2;
                }
                tCivsSorted.add((Integer)tempL.get(tAddID));
                tempL.remove(tAddID);
            }
        } else {
            for (int i4 = 0; i4 < CFG.core.getAlliance(ALLIANCE_ID).getCivilizationsSize(); ++i4) {
                tCivsSorted.add(CFG.core.getAlliance(ALLIANCE_ID).getCivilization(i4));
            }
        }
        for (int i5 = 0; i5 < tCivsSorted.size(); ++i5) {
            menuElements.add(new Button_Stats_Flag_Clip(CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)tCivsSorted.get(i5)) ? (Integer)tCivsSorted.get(i5) : -1, CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)tCivsSorted.get(i5)) ? CFG.core.getCiv((Integer)tCivsSorted.get(i5)).getCivName() : CFG.lang.get("Undiscovered"), CFG.PADD, CFG.PADD * 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2){

                @Override
                public int getWidthE() {
                    return Menu_InGame_Alliance.this.getElementW() * 2;
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
            });
            menuElements.add(new ButtonStats(CFG.getNumberWthSpaces("" + CFG.core.getCiv((Integer)tCivsSorted.get(i5)).getNumOfProvs()), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 2, tPosY, CFG.BUTTON_W, tElemHeight2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Alliance.this.getElementW() * 2 + CFG.PADD * 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Alliance.this.getElementW();
                }
            });
            menuElements.add(new ButtonStats(CFG.getNumberWthSpaces("" + CFG.core.getCiv((Integer)tCivsSorted.get(i5)).countPop()), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 3, tPosY, CFG.BUTTON_W, tElemHeight2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Alliance.this.getElementW() * 3 + CFG.PADD * 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Alliance.this.getElementW();
                }
            });
            menuElements.add(new ButtonStats(CFG.getNumberWthSpaces("" + CFG.core.getCiv((Integer)tCivsSorted.get(i5)).countEco()), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, tPosY, CFG.BUTTON_W, tElemHeight2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Alliance.this.getElementW() * 4 + CFG.PADD * 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Alliance.this.getElementW();
                }
            });
            menuElements.add(new ButtonStats("" + (float)((int)(CFG.core.getCiv((Integer)tCivsSorted.get(i5)).getTechLevel() * 100.0f)) / 100.0f, CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 5, tPosY, CFG.BUTTON_W, tElemHeight2){

                @Override
                public int getPosXE() {
                    return Menu_InGame_Alliance.this.getElementW() * 5 + CFG.PADD * 2;
                }

                @Override
                public int getWidthE() {
                    return Menu_InGame_Alliance.this.getW() - Menu_InGame_Alliance.this.getElementW() * 5;
                }
            });
            tPosY += tElemHeight2;
        }
        int tempTotalProvinces = 0;
        int tempTotalPopulation = 0;
        int tempTotalEconomy = 0;
        float tempTotalArmy = 0.0f;
        for (i = 0; i < tCivsSorted.size(); ++i) {
            tempTotalProvinces += CFG.core.getCiv((Integer)tCivsSorted.get(i)).getNumOfProvs();
            tempTotalPopulation = (int)((long)tempTotalPopulation + CFG.core.getCiv((Integer)tCivsSorted.get(i)).countPop());
            tempTotalEconomy = (int)((long)tempTotalEconomy + CFG.core.getCiv((Integer)tCivsSorted.get(i)).countEco());
            tempTotalArmy += CFG.core.getCiv((Integer)tCivsSorted.get(i)).getTechLevel();
        }
        tempTotalArmy /= (float)tCivsSorted.size();
        menuElements.add(new Button_Stats_Total(CFG.lang.get("Total") + ":", CFG.PADD, CFG.PADD * 2, tPosY, CFG.BUTTON_W * 2, tElemHeight2){

            @Override
            public int getWidthE() {
                return Menu_InGame_Alliance.this.getElementW() * 2;
            }

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iTextWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
            }
        });
        menuElements.add(new Button_Stats_Total(CFG.getNumberWthSpaces("" + tempTotalProvinces), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 2, tPosY, CFG.BUTTON_W, tElemHeight2){

            @Override
            public int getPosXE() {
                return Menu_InGame_Alliance.this.getElementW() * 2 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Alliance.this.getElementW();
            }
        });
        menuElements.add(new Button_Stats_Total(CFG.getNumberWthSpaces("" + tempTotalPopulation), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 3, tPosY, CFG.BUTTON_W, tElemHeight2){

            @Override
            public int getPosXE() {
                return Menu_InGame_Alliance.this.getElementW() * 3 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Alliance.this.getElementW();
            }
        });
        menuElements.add(new Button_Stats_Total(CFG.getNumberWthSpaces("" + tempTotalEconomy), CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 4, tPosY, CFG.BUTTON_W, tElemHeight2){

            @Override
            public int getPosXE() {
                return Menu_InGame_Alliance.this.getElementW() * 4 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Alliance.this.getElementW();
            }
        });
        menuElements.add(new Button_Stats_Total("" + (float)((int)(tempTotalArmy * 100.0f)) / 100.0f, CFG.PADD, CFG.PADD * 2 + CFG.BUTTON_W * 5, tPosY, CFG.BUTTON_W, tElemHeight2){

            @Override
            public int getPosXE() {
                return Menu_InGame_Alliance.this.getElementW() * 5 + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Alliance.this.getW() - Menu_InGame_Alliance.this.getElementW() * 5;
            }
        });
        menuElements.add(new Button_Stats_Total(CFG.core.getAlliance(ALLIANCE_ID).getAllianceName(), CFG.PADD, CFG.PADD * 2, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), (tempWidth + CFG.PADD * 4) / 2, tElemHeight2){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Alliance.this.getElementW2();
            }
        });
        menuElements.add(new Button_Stats_Total(CFG.lang.get("ColorOfAlliance"), CFG.PADD, CFG.PADD * 2 + (tempWidth + CFG.PADD * 4) / 2, tPosY, (tempWidth + CFG.PADD * 4) / 2, tElemHeight2){

            @Override
            public Color getColorE(boolean isActive) {
                try {
                    return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : new Color(CFG.core.getAlliance(ALLIANCE_ID).getColorOfAlliance().getR(), CFG.core.getAlliance(ALLIANCE_ID).getColorOfAlliance().getG(), CFG.core.getAlliance(ALLIANCE_ID).getColorOfAlliance().getB(), 1.0f)) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }
                catch (Exception exception) {
                    return CFG.COLOR_TEXT_GRAY_NS;
                }
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
            }

            @Override
            public int getPosXE() {
                return Menu_InGame_Alliance.this.getElementW2() + CFG.PADD * 2;
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_Alliance.this.getElementW2();
            }
        });
        this.initMenu(new TitleM_TextSmall(CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetAlliance(ALLIANCE_ID) ? CFG.core.getAlliance(ALLIANCE_ID).getAllianceName() : CFG.lang.get("Undiscovered"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight() - Core.PADDING, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(CFG.core.getAlliance(ALLIANCE_ID).getColorOfAlliance().getR(), CFG.core.getAlliance(ALLIANCE_ID).getColorOfAlliance().getG(), CFG.core.getAlliance(ALLIANCE_ID).getColorOfAlliance().getB(), 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(CFG.core.getAlliance(ALLIANCE_ID).getColorOfAlliance().getR(), CFG.core.getAlliance(ALLIANCE_ID).getColorOfAlliance().getG(), CFG.core.getAlliance(ALLIANCE_ID).getColorOfAlliance().getB(), 0.375f));
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
                IMGManager.getIMG(Images.time).drawO(oSB, nPosX + nWidth - CFG.PADD - 2 - (int)((float)IMGManager.getIMG(Images.time).getWidth() * Menu_InGame_Alliance.this.getImageScale2(Images.time)) + iTranslateX, nPosY - CFG.PADD - (int)((float)IMGManager.getIMG(Images.time).getHeight() * Menu_InGame_Alliance.this.getImageScale2(Images.time)) - IMGManager.getIMG(Images.time).getHeight(), (int)((float)IMGManager.getIMG(Images.time).getWidth() * Menu_InGame_Alliance.this.getImageScale2(Images.time)), (int)((float)IMGManager.getIMG(Images.time).getHeight() * Menu_InGame_Alliance.this.getImageScale2(Images.time)));
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, Menu_InGame_Alliance.this.sFormDate, nPosX + nWidth - Menu_InGame_Alliance.this.iFormDateWidth - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.time).getWidth() * Menu_InGame_Alliance.this.getImageScale2(Images.time)) - 2 + iTranslateX, nPosY - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL, CFG.COLOR_NEUTRAL);
            }
        }, CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2, IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 3 / 4, tempWidth, tempHeight, menuElements, false, true);
        this.updateLang();
        for (i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(i / 5 % 2);
        }
    }

    @Override
    public void updateLang() {
    }

    private final float getImageScale2(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (this.lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX() - Core.PADDING, CFG.GAMEHEIGHT - this.getPosY(), this.getWidthM() + Core.PADDING * 2, -((int)((float)this.getHeightM() * ((float)(System.currentTimeMillis() - this.lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + Core.PADDING, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + this.getWidthM() + Core.PADDING - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + Core.PADDING, true, true);
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
            try {
                oSB.flush();
                ScissorStack.popScissors();
            }
            catch (IllegalStateException illegalStateException) {
                
            }
            this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            CFG.setRenderO(true);
        } else {
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + Core.PADDING, false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + this.getWidthM() + Core.PADDING - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + Core.PADDING, true, true);
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
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void drawCloseButton(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.getCloseButtonImage(sliderMenuIsActive).drawO(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.btnClose).getWidth() * 3 / 5 + iTranslateX, this.getPosY() - this.getTitleM().getHeightT() - IMGManager.getIMG(Images.btnClose).getHeight() + iTranslateY, IMGManager.getIMG(Images.btnClose).getWidth() * 3 / 5, IMGManager.getIMG(Images.btnClose).getHeight() * 3 / 5);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                if (sortBy != iID) {
                    sortBy = iID;
                    CFG.menus.rebuildInGame_Alliance(ALLIANCE_ID);
                }
                return;
            }
            case 1: {
                if (sortBy != iID) {
                    sortBy = iID;
                    CFG.menus.rebuildInGame_Alliance(ALLIANCE_ID);
                }
                return;
            }
            case 2: {
                if (sortBy != iID) {
                    sortBy = iID;
                    CFG.menus.rebuildInGame_Alliance(ALLIANCE_ID);
                }
                return;
            }
            case 3: {
                if (sortBy != iID) {
                    sortBy = iID;
                    CFG.menus.rebuildInGame_Alliance(ALLIANCE_ID);
                }
                return;
            }
            case 4: {
                if (sortBy != iID) {
                    sortBy = iID;
                    CFG.menus.rebuildInGame_Alliance(ALLIANCE_ID);
                }
                return;
            }
        }
        if (iID == this.getMenuElemsSize() - 1) {
            CFG.menus.getColorPicker().setPosX(CFG.GAMEWIDTH - CFG.menus.getColorPicker().getWidth() - CFG.PADD * 4);
            CFG.menus.getColorPicker().setPosY(this.getPosY() + CFG.PADD * 2);
            CFG.menus.getColorPicker().setVisible(!CFG.menus.getColorPicker().getVisible(), ColorPicker_AoC.PickerAction.ACTIVE_ALLIANCE_COLOR);
            return;
        }
        if (iID == this.getMenuElemsSize() - 2) {
            Keyboard.commandsMode = false;
            Keyboard.changeCivilizationNameMode = -1;
            Keyboard.changeAllianceNameMode = ALLIANCE_ID;
            CFG.updateKeyboard_Actions();
            CFG.showKeyboard();
            return;
        }
        if (iID % 5 == 0 && iID < this.getMenuElemsSize() - 5) {
            try {
                if (this.getMenuElem(iID).getCurr() >= 0) {
                    CFG.setActiveCivInfoId(this.getMenuElem(iID).getCurr());
                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID());
                    CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                    CFG.updateActiveCivilizationInfoInGame();
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                
            }
        }
    }

    public final int getW() {
        return this.getWidthM() - CFG.PADD * 4;
    }

    public final int getElementW() {
        return this.getW() / 6;
    }

    public final int getElementW2() {
        return this.getW() / 2;
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        this.lTime = System.currentTimeMillis();
    }
}

