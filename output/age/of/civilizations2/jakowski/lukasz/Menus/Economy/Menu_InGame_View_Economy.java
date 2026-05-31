/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Economy;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_InvestOverPenaltyJust;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_Text;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_ActionAll;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Options.Button_Opt_MapModesNormal;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop_TextRightTop;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.View.Button_View_Economy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Graph;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.Menus.Invest.Menu_InGame_Invest;
import age.of.civilizations2.jakowski.lukasz.Menus.Turn.Menu_NextPlayerTurn;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_Economy
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    private int iCivID = 0;

    public Menu_InGame_View_Economy() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tY = 0;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.iCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(CFG.core.getActiveProvID());
        int extraW = CFG.BUTTON_W * 3 / 4;
        tempW += extraW;
        ArrayList<Integer> tempProvincesSorted = new ArrayList<Integer>();
        ArrayList<Integer> tempProvs = new ArrayList<Integer>();
        int totalPopulation = 0;
        for (int i = 0; i < CFG.core.getCiv(this.iCivID).getNumOfProvs(); ++i) {
            if (CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(this.iCivID).getProvID(i))) continue;
            tempProvs.add(CFG.core.getCiv(this.iCivID).getProvID(i));
            totalPopulation += CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i)).getEco();
        }
        while (!tempProvs.isEmpty()) {
            int tBest = 0;
            for (int i = 1; i < tempProvs.size(); ++i) {
                if (CFG.core.getProv((Integer)tempProvs.get(tBest)).getEco() >= CFG.core.getProv((Integer)tempProvs.get(i)).getEco()) continue;
                tBest = i;
            }
            tempProvincesSorted.add((Integer)tempProvs.get(tBest));
            tempProvs.remove(tBest);
        }
        menuElements.add(new Button_DiplomacyAction(Images.economy, CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": " + CFG.lang.get("TopCivilizations"), 0, 0, tY, tempW, Menu_InGame_Civ_Decisions.getButtonH(), true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setVisible_InGame_ViewEconomyAll(true);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TopCivilizations"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
        menuElements.add(new Button_DiplomacyAction(Images.economy, CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": " + CFG.lang.get("TopProvinces"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, Menu_InGame_Civ_Decisions.getButtonH(), true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setVisible_InGame_ViewEconomyProvinces(true);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TopProvinces"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        menuElements.add(new TextBuildTitle(CFG.lang.get("Civilization"), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (!tempProvincesSorted.isEmpty()) {
            int taxesGraphW = Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 4, (int)((float)(tempW - CFG.PADD * 4) * 0.125f)) - CFG.PADD;
            menuElements.add(new ButtonN_Pop_TextRightTop(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 1.0f), CFG.core.getCiv(this.iCivID).getCivName(), this.iCivID, CFG.lang.get("TotalCost") + ": ", CFG.getNumber_SHORT(CFG.core.getCiv((int)this.iCivID).civGD.iGE), Images.topGold(), CFG.COLOR_GOLD, 0, tY, tempW - taxesGraphW, CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivID).countEco()), Images.economy){

                @Override
                public void actionElem(int iID) {
                    CFG.menus.setVisible_InGame_ViewEconomyAll(true);
                }

                @Override
                public Color getColorRight() {
                    return CFG.COLOR_ECONOMY;
                }

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivID).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivID).countEco()), CFG.COLOR_ECONOMY));
                        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomicInvestments"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Flag(this.iCivID, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Image(Images.investEco, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalEconomicIncrease") + ": "));
                        nData.add(new ME_Hover_2Type_Text("+" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)this.iCivID).civGD.iGEG), CFG.COLOR_ECONOMY));
                        nData.add(new ME_Hover_2Type_Image(Images.investEco, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalCost") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)this.iCivID).civGD.iGE), CFG.COLOR_GOLD));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_ECONOMY, this.iCivID));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        // empty catch block
                    }
                }
            });
            menuElements.add(new Graph2("A", "B", tempW - taxesGraphW, tY, taxesGraphW, CFG.BUTTON_H - 2, true, 1, Graph2.GraphType.CIV_ECONOMY, false, this.iCivID, true){

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        if ((CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(this.id)) && this.id > 0) {
                            long tempTotalEco = CFG.core.getCiv(this.id).countEco();
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Economy") + ": "));
                            nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + tempTotalEco), CFG.COLOR_ECONOMY));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.id).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Flag_Big(this.id, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            if (CFG.menus.getInGameView()) {
                                nData.add(new ME_Hover_2Type_Space());
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                if (CFG.core.getCiv((int)this.id).civGD.startingEconomy > 0L) {
                                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("StartingEconomy") + ": "));
                                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)this.id).civGD.startingEconomy), CFG.COLOR_ECONOMY));
                                    nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, CFG.PADD));
                                    long difference = tempTotalEco - CFG.core.getCiv((int)this.id).civGD.startingEconomy;
                                    nData.add(new ME_Hover_2Type_Text((difference > 0L ? "+" : "") + CFG.getNumberWthSpaces("" + difference), difference == 0L ? CFG.COLOR_NEUTRAL : (difference > 0L ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                                    nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                                    nData.add(new ME_Hover_2Type_Text(" [" + (difference > 0L ? "+" : "") + CFG.getPercentage2Old(tempTotalEco - CFG.core.getCiv((int)this.id).civGD.startingEconomy, CFG.core.getCiv((int)this.id).civGD.startingEconomy, 100) + "%]", CFG.COLOR_NEUTRAL));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                } else {
                                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("StartingEconomy") + ": "));
                                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("1"), CFG.COLOR_ECONOMY));
                                    nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                }
                                nData.add(new ME_Hover_2Type_Space());
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomicInvestments"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nData.add(new ME_Hover_2Type_Flag(this.id, CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Image(Images.investEco, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalEconomicIncrease") + ": "));
                                nData.add(new ME_Hover_2Type_Text("+" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)this.id).civGD.iGEG), CFG.COLOR_ECONOMY));
                                nData.add(new ME_Hover_2Type_Image(Images.investEco, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalCost") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)this.id).civGD.iGE), CFG.COLOR_GOLD));
                                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            } else {
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.id).countEco()), CFG.COLOR_ECONOMY));
                                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_ECONOMY, this.id));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.id));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (Exception ex) {
                        this.menuElemHover = null;
                    }
                }

                @Override
                public int getGraphWidth() {
                    return this.getWidthE() - age.of.civilizations2.jakowski.lukasz.Graphs.Graph.getGraphButtonWidth();
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 2)).getHeightE();
            if (this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get("Invest") + ": " + CFG.lang.get("AllProvinces"), this.iCivID, CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.investEconomyAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.investEconomyAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.investEconomyAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.investEco, CFG.COLOR_ECONOMY, 0, tY, tempW - extraW, CFG.BUTTON_H * 4 / 5){

                    @Override
                    public void actionElem(int iID) {
                        CFG.setDialogType(DialogType.ALL_INVEST_ECO);
                    }

                    @Override
                    public void actionElemPPM() {
                        CFG.investAllEconomy();
                    }
                });
                menuElements.add(new Button_Build_Text(">>", tempW - extraW, tY, extraW, CFG.BUTTON_H * 4 / 5, true, 0){

                    @Override
                    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.getIsHovered()) {
                            IMGManager.getIMG(Images.investEco).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.investEco).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.investEco).getHeight() / 2 + iTranslateY);
                        } else {
                            super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.investAllEconomy();
                    }

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Invest") + ": " + CFG.lang.get("AllProvinces"), Colors.COLOR_TEXT_GOLD));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.investEco, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                        catch (Exception e) {
                            this.menuElemHover = null;
                        }
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 2)).getHeightE();
            }
            menuElements.add(new Button_Build_InvestOverPenaltyJust(CFG.lang.get("OverinvestmentPenalty") + ": ", 0, tY, tempW, "+" + CFG.getPrecision2(Core.getOverInvestmentsPenalty(this.iCivID) * 100.0f, 100) + "%"){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OverinvestmentPenalty") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big("+" + CFG.getPrecision2(Core.getOverInvestmentsPenalty(Menu_InGame_View_Economy.this.iCivID) * 100.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Flag_Big(Menu_InGame_View_Economy.this.iCivID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.getPrecision2(CFG.core.getCiv((int)((Menu_InGame_View_Economy)Menu_InGame_View_Economy.this).iCivID).civGD.numberOfInvestments, 10), CFG.COLOR_ECONOMY));
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
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() ? 0 : 1);
            int buttonH = Math.max(CFG.BUTTON_H * 3 / 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4);
            menuElements.add(new Button_Opt_MapModesNormal(0, CFG.lang.get("InvestBySelectingAProvinceOnTheMap"), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, buttonH, true, true){

                @Override
                public void actionElem(int iID) {
                    BuildingsManager.buildBySelectingProvinceOnMap = !BuildingsManager.buildBySelectingProvinceOnMap;
                }

                @Override
                public boolean getCheckboxSt() {
                    return BuildingsManager.buildBySelectingProvinceOnMap;
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            for (int i = 0; i < tempProvincesSorted.size(); ++i) {
                menuElements.add(new Button_View_Economy(i, i + 1 + ". " + (CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getName().length() > 0 ? CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getName() : CFG.core.getCiv(this.iCivID).getCivName()), (Integer)tempProvincesSorted.get(i), totalPopulation, 0, tY, tempW - extraW, CFG.core.getCiv(this.iCivID).isInvestOrganized((Integer)tempProvincesSorted.get(i))){

                    @Override
                    public void actionElem(int iID) {
                        if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS && this.getCurr() == CFG.core.getActiveProvID() && CFG.core.getProv(this.getCurr()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && !CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInvestOrganized(this.getCurr())) {
                            if (this.getCurr() >= 0) {
                                CFG.menus.rebuildInGame_Invest(this.getCurr());
                            }
                        } else {
                            Menu_NextPlayerTurn.lockExtraAction = true;
                            CFG.core.setActiveProvID(this.getCurr());
                            Menu_NextPlayerTurn.lockExtraAction = false;
                            CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                            if (CFG.core.getProv(CFG.core.getActiveProvID()).getName().length() > 0) {
                                CFG.toastM.addM(CFG.core.getProv(CFG.core.getActiveProvID()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            }
                        }
                    }
                });
                if (CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                    menuElements.add(new Button_Build_Text(">>", tempW - extraW, tY, extraW, Menu_InGame_View_Army.getButtonHeight(), true, (Integer)tempProvincesSorted.get(i)){

                        @Override
                        public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                            if (this.getIsHovered()) {
                                IMGManager.getIMG(Images.investEco).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.investEco).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.investEco).getHeight() / 2 + iTranslateY);
                            } else {
                                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                            }
                        }

                        @Override
                        public void actionElem(int iID) {
                            if (CFG.core.getProv(this.getCurr()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && !CFG.core.getProv(this.getCurr()).isOccupied()) {
                                long maxValue = GameManager.invest_MaxEconomy_Gold(this.getCurr(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                                int actionDone = 0;
                                if (GameManager.invest(this.getCurr(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), maxValue)) {
                                    ++actionDone;
                                    CFG.gameAction.updateInGame_ProvinceInfo();
                                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE) {
                                        CFG.core.getProv((int)this.getCurr()).viewBool = true;
                                        if (CFG.menus.getVisible_InGame_View_Stats()) {
                                            CFG.menus.setVisible_InGame_ViewEconomy(true);
                                        }
                                    }
                                    CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                                }
                                if (actionDone > 0) {
                                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                                    CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                                    CFG.toastM.setTimeInView(3500);
                                }
                            }
                        }

                        @Override
                        public void buildElemHover() {
                            this.menuElemHover = Menu_InGame_Invest.getHoverInvest(this.getCurr());
                        }
                    });
                    ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr((i + 1) % 2);
                } else {
                    menuElements.add(new Button_Build_Text(">>", tempW - extraW, tY, extraW, Menu_InGame_View_Army.getButtonHeight(), true, (Integer)tempProvincesSorted.get(i)){

                        @Override
                        public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                            if (this.getIsHovered()) {
                                IMGManager.getIMG(Images.investF).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.investF).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.investF).getHeight() / 2 + iTranslateY);
                            } else {
                                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                            }
                        }

                        @Override
                        public void actionElem(int iID) {
                            try {
                                long maxInvestGold = GameManager.invest_MaxEconomy_Gold(this.getCurr(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                                if (CFG.core.getProv(this.getCurr()).getCivId() <= 0) {
                                    CFG.toastM.addM(CFG.lang.get("Civilization") + ": " + CFG.lang.get("Neutral"), CFG.COLOR_NEGATIVE_1);
                                } else if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).areSanctionsAdded(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getProv(this.getCurr()).getCivId()) || CFG.core.getCiv(CFG.core.getProv(this.getCurr()).getCivId()).areSanctionsAdded(CFG.core.getProv(this.getCurr()).getCivId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
                                    CFG.toastM.addM(CFG.lang.get("SanctionsBox1"), CFG.COLOR_NEGATIVE_1);
                                } else if (maxInvestGold > 0) {
                                    GameManager.investForeignEconomy(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.getCurr(), maxInvestGold);
                                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                                    CFG.gameAction.updateInGame_ProvinceInfo();
                                    CFG.toastM.addM(CFG.lang.get("Ok") + "!", CFG.COLOR_POSITIVE);
                                    CFG.toastM.setTimeInView(3500);
                                    CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("InvestInForeignProvince"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getProv(this.getCurr()).getCivId(), Images.infoEconomy);
                                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE) {
                                        CFG.core.getProv((int)this.getCurr()).viewBool = true;
                                        if (CFG.menus.getVisible_InGame_View_Stats()) {
                                            CFG.menus.setVisible_InGame_ViewEconomy(true);
                                        }
                                    }
                                } else {
                                    CFG.toastM.addM(CFG.lang.get("Gold") + ": " + maxInvestGold, CFG.COLOR_NEGATIVE_1);
                                }
                            }
                            catch (Exception ex) {
                                CFG.exceptionStack(ex);
                            }
                        }

                        @Override
                        public void buildElemHover() {
                            try {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("InvestInForeignProvince") + ": "));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(this.getCurr()).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.getCurr()).getCivId(), CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.investF1, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                long maxInvestGold = GameManager.invest_MaxEconomy_Gold(this.getCurr(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Gold") + ": "));
                                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + maxInvestGold), CFG.COLOR_GOLD));
                                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + GameManager.invest_EconomyByGold(this.getCurr(), maxInvestGold), CFG.COLOR_ECONOMY));
                                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(this.getCurr()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalReturn") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + GameManager.investForeignEconomy_Return(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.getCurr(), maxInvestGold)), CFG.COLOR_GOLD));
                                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Profit") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (GameManager.investForeignEconomy_Return(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.getCurr(), maxInvestGold) - maxInvestGold)), CFG.COLOR_GOLD));
                                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Duration") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + CFG.lang.get("TurnsX", GameValues.gvInvestForeign.INVEST_ECO_RETURN_TURNS), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Space());
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ForeignInvestYourGoldDirectlyDesc")));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                this.menuElemHover = new ME_Hover_v2(nElements);
                            }
                            catch (Exception ex) {
                                this.menuElemHover = null;
                            }
                        }
                    });
                    ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr((i + 1) % 2);
                }
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        } else {
            menuElements.add(new TextScale(CFG.lang.get("NoData"), -1, 0, tY, tempW, CFG.BUTTON_H * 3 / 4, 0.75f));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Economy"), CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_Economy.this.getPosX() + iTranslateX, Menu_InGame_View_Economy.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_Economy.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color((float)CFG.core.getCiv(Menu_InGame_View_Economy.this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_View_Economy.this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_View_Economy.this.iCivID).getB() / 255.0f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color((float)CFG.core.getCiv(Menu_InGame_View_Economy.this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_View_Economy.this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_View_Economy.this.iCivID).getB() / 255.0f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_Economy.this.getPosX() + iTranslateX, Menu_InGame_View_Economy.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_Economy.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Economy.this.getPosX() + iTranslateX, Menu_InGame_View_Economy.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_Economy.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Economy.this.getPosX() + iTranslateX, Menu_InGame_View_Economy.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_Economy.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Economy.this.getPosX() + iTranslateX, Menu_InGame_View_Economy.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Economy.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Economy.this.getPosX() + Menu_InGame_View_Economy.this.getWidthM() - Menu_InGame_View_Economy.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_Economy.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Economy.this.getWidthM() / 4, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.economy).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, Menu_InGame_View_Economy.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.economy).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 5, tempW, Math.min(tY + 1, CFG.isAndroid() && !CFG.LANDSCAPE ? (CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (CFG.PADD * 2 + CFG.BUTTON_H) * 2)) / 2 : CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (GameValues.gvInGame.MAP_MODES_MENUS_TO_PROVINCE_INFO ? (CFG.PADD * 2 + CFG.BUTTON_H) * 2 : 0))), menuElements, false, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            iTranslateX = hideAnimation ? (iTranslateX -= (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))) : (iTranslateX += -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME)));
            CFG.setRenderO(true);
        } else if (hideAnimation) {
            super.setVisibleM(false);
            return;
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2 + Core.PADDING, this.getHeightM() + CFG.PADD, true, true);
        oSB.setColor(new Color(0.09803922f, 0.05882353f, 0.37254903f, 0.25f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.PADD * 4);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.PADD * 2);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM() + CFG.PADD, this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight() + this.getHeightM() + CFG.PADD, this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() + CFG.PADD, this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible) {
            super.setVisibleM(visible);
            this.setHideAnimation(false);
        } else {
            this.setHideAnimation(true);
        }
    }

    public final void setHideAnimation(boolean nHideAnimation) {
        if (nHideAnimation != hideAnimation) {
            lTime = lTime > System.currentTimeMillis() - (long)GameValues.gvInGame.MENUS_ANIMATION_TIME ? System.currentTimeMillis() - ((long)GameValues.gvInGame.MENUS_ANIMATION_TIME - (System.currentTimeMillis() - lTime)) : System.currentTimeMillis();
            CFG.setRenderO(true);
        }
        hideAnimation = nHideAnimation;
    }
}

