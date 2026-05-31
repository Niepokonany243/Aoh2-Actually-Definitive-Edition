
package age.of.civilizations2.jakowski.lukasz.Menus.Economy;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop_2_PopChangeCost;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
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
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_EconomyChangeCivs
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;

    public Menu_InGame_View_EconomyChangeCivs() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH + CFG.BUTTON_W + CFG.BUTTON_W / 2;
        int tY = 0;
        int playerPos = -1;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_DiplomacyAction(Images.economy, CFG.lang.get("TopProvinces"), 0, 0, tY, tempW, Menu_InGame_Civ_Decisions.getButtonH(), true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setVisible_InGame_ViewEconomicChange(true);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("EconomicChange") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TopProvinces"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
        menuElements.add(new Button_DiplomacyAction(Images.economy, CFG.lang.get("WorstCivilizations"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, Menu_InGame_Civ_Decisions.getButtonH(), true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setVisible_InGame_ViewEconomicChangeCivsWorst(true);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("EconomicChange") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WorstCivilizations"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        menuElements.add(new TextBuildTitle(CFG.lang.get("TopCivilizations"), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int elemBefore = menuElements.size();
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.core.getCiv((int)i).freeValue = CFG.core.getCiv(i).countEco() - CFG.core.getCiv((int)i).civGD.startingEconomy;
        }
        int taxesGraphW = Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 2, (int)((float)(tempW - CFG.PADD * 4) * 0.125f)) - CFG.PADD;
        for (int a = 0; a < GameValues.gvInGame.POP_CHANGE_VIEW_LIMIT; ++a) {
            boolean metCiv;
            int bestID = 0;
            for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv((int)bestID).freeValue >= CFG.core.getCiv((int)i).freeValue) continue;
                bestID = i;
            }
            if (CFG.core.getCiv((int)bestID).freeValue == 0L) break;
            boolean bl = metCiv = CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(bestID);
            if (bestID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                playerPos = a + 1;
            }
            long tempTotalEco = CFG.core.getCiv(bestID).countEco();
            menuElements.add(new ButtonN_Pop_2_PopChangeCost(new Color((float)CFG.core.getCiv(bestID).getR() / 255.0f, (float)CFG.core.getCiv(bestID).getG() / 255.0f, (float)CFG.core.getCiv(bestID).getB() / 255.0f, 1.0f), a + 1 + ". " + (metCiv ? CFG.core.getCiv(bestID).getCivName() : CFG.lang.get("Undiscovered")), metCiv ? bestID : -1, "" + (tempTotalEco - CFG.core.getCiv((int)bestID).civGD.startingEconomy > 0L ? "+" : "") + CFG.getPercentage2Old(tempTotalEco - CFG.core.getCiv((int)bestID).civGD.startingEconomy, CFG.core.getCiv((int)bestID).civGD.startingEconomy, 100) + "%", CFG.getNumberWthSpaces("" + tempTotalEco), Images.economy, CFG.COLOR_ECONOMY, 0, tY, tempW - taxesGraphW, CFG.core.getCiv((int)bestID).freeValue, CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)bestID).civGD.iGE)){

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        if (this.iCivID > 0) {
                            long tempTotalEco = CFG.core.getCiv(this.iCivID).countEco();
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Economy") + ": "));
                            nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + tempTotalEco), CFG.COLOR_ECONOMY));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivID).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            if (CFG.menus.getInGameView()) {
                                nData.add(new ME_Hover_2Type_Space());
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                if (CFG.core.getCiv((int)this.iCivID).civGD.startingEconomy > 0L) {
                                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("StartingEconomy") + ": "));
                                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)this.iCivID).civGD.startingEconomy), CFG.COLOR_ECONOMY));
                                    nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, CFG.PADD));
                                    long difference = tempTotalEco - CFG.core.getCiv((int)this.iCivID).civGD.startingEconomy;
                                    nData.add(new ME_Hover_2Type_Text((difference > 0L ? "+" : "") + CFG.getNumberWthSpaces("" + difference), difference == 0L ? CFG.COLOR_NEUTRAL : (difference > 0L ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                                    nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                                    nData.add(new ME_Hover_2Type_Text(" [" + (difference > 0L ? "+" : "") + CFG.getPercentage2Old(tempTotalEco - CFG.core.getCiv((int)this.iCivID).civGD.startingEconomy, CFG.core.getCiv((int)this.iCivID).civGD.startingEconomy, 100) + "%]", CFG.COLOR_NEUTRAL));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                } else {
                                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("StartingEconomy") + ": "));
                                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("1"), CFG.COLOR_ECONOMY));
                                    nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                }
                            } else {
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivID).countEco()), CFG.COLOR_ECONOMY));
                                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_ECONOMY, this.iCivID));
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
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
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
                public void actionElem(int iID) {
                    if (this.iCivID > 0) {
                        int provinceID = CFG.map.getMpC().getCapital_OrMetProvinceCivID(this.iCivID);
                        CFG.core.setActiveProvID(provinceID);
                    }
                }

                @Override
                public void actionElemPPM() {
                    if (this.iCivID > 0) {
                        CFG.map.getMpC().centerToCapital_OrMetProvinceCivID(this.iCivID);
                    }
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(a % 2);
            menuElements.add(new Graph2("A", "B", tempW - taxesGraphW, tY, taxesGraphW, CFG.BUTTON_H, true, 1, Graph2.GraphType.CIV_ECONOMY, false, bestID, true){

                @Override
                public int getGraphWidth() {
                    return this.getWidthE() - age.of.civilizations2.jakowski.lukasz.Graphs.Graph.getGraphButtonWidth();
                }

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
                            nData.add(new ME_Hover_2Type_Flag_Big(-1));
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
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 2)).getHeightE();
            CFG.core.getCiv((int)bestID).freeValue = 0L;
        }
        if (elemBefore == menuElements.size()) {
            menuElements.add(new TextScale(CFG.lang.get("NoData"), -1, 0, tY, tempW, CFG.BUTTON_H * 3 / 4, 0.75f));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("EconomicChange") + (playerPos > 0 ? " #" + playerPos : ""), CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_EconomyChangeCivs.this.getPosX() + iTranslateX, Menu_InGame_View_EconomyChangeCivs.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_EconomyChangeCivs.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(CFG.COLOR_ECONOMY_HOVER.r, CFG.COLOR_ECONOMY_HOVER.g, CFG.COLOR_ECONOMY_HOVER.b, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(CFG.COLOR_ECONOMY_HOVER.r, CFG.COLOR_ECONOMY_HOVER.g, CFG.COLOR_ECONOMY_HOVER.b, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_EconomyChangeCivs.this.getPosX() + iTranslateX, Menu_InGame_View_EconomyChangeCivs.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_EconomyChangeCivs.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_EconomyChangeCivs.this.getPosX() + iTranslateX, Menu_InGame_View_EconomyChangeCivs.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_EconomyChangeCivs.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_EconomyChangeCivs.this.getPosX() + iTranslateX, Menu_InGame_View_EconomyChangeCivs.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_EconomyChangeCivs.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_EconomyChangeCivs.this.getPosX() + iTranslateX, Menu_InGame_View_EconomyChangeCivs.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_EconomyChangeCivs.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_EconomyChangeCivs.this.getPosX() + Menu_InGame_View_EconomyChangeCivs.this.getWidthM() - Menu_InGame_View_EconomyChangeCivs.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_EconomyChangeCivs.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_EconomyChangeCivs.this.getWidthM() / 4, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.economy).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, Menu_InGame_View_EconomyChangeCivs.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.economy).getHeight() / 2);
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

