
package age.of.civilizations2.jakowski.lukasz.Menus.Civilization;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon_Horizontal;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Circle;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
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
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ;
import age.of.civilizations2.jakowski.lukasz.Menus.Population.Menu_InGame_View_PopulationCiv;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextCivInfo;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide_Happiness;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide_Icon;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide_Ideology;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide_Nukes;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide_Religion;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide_Stability;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Civ_Stats
extends Menu {
    public Menu_InGame_Civ_Stats() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int menuW = Menu_InGame_Civ.getMenuCivInfoWidth();
        int circlePosY = CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 3 + CFG.PADD;
        menuElements.add(new TextCivInfo(null, CFG.PADD * 2, CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_PopulationOfCiv(CFG.getActiveCivInfoId());
            }
        });
        menuElements.add(new TextIcon("", Images.pop, IMGManager.getIMG(Images.noLeader).getWidth() + CFG.PADD * 3, CFG.PADD * 2, CFG.BUTTON_W, circlePosY - CFG.PADD * 3, CFG.FONT_BOLD_SMALL){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_PopulationOfCiv(CFG.getActiveCivInfoId());
            }

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_POPULATION_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_POPULATION_HOVER : CFG.COLOR_POPULATION) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        menuElements.add(new TextCivInfo(null, CFG.PADD * 2, CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD)){

            @Override
            public void buildElemHover() {
                try {
                    this.menuElemHover = CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID()) ? CFG.core.getHover_CapitalCity(CFG.getActiveCivInfoId()) : null) : CFG.core.getHover_CapitalCity(CFG.getActiveCivInfoId());
                }
                catch (IndexOutOfBoundsException ex) {
                    this.menuElemHover = null;
                }
            }
        });
        menuElements.add(new TextLeftSide_Icon("3", menuW - CFG.PADD * 2 - 2, CFG.PADD * 2, Images.city){

            @Override
            public void buildElemHover() {
                try {
                    this.menuElemHover = CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID()) ? CFG.core.getHover_CapitalCity(CFG.getActiveCivInfoId()) : null) : CFG.core.getHover_CapitalCity(CFG.getActiveCivInfoId());
                }
                catch (IndexOutOfBoundsException ex) {
                    this.menuElemHover = null;
                }
            }
        });
        menuElements.add(new TextCivInfo(null, CFG.PADD * 2, CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2){

            @Override
            public void buildElemHover() {
                try {
                    this.menuElemHover = CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(Menu_InGame_Civ_Stats.this.getMenuElem(5).getCurr()) ? CFG.core.getHover_LargestCity(Menu_InGame_Civ_Stats.this.getMenuElem(5).getCurr()) : null) : CFG.core.getHover_LargestCity(Menu_InGame_Civ_Stats.this.getMenuElem(5).getCurr());
                }
                catch (IndexOutOfBoundsException ex) {
                    this.menuElemHover = null;
                }
            }
        });
        menuElements.add(new TextLeftSide("3", menuW - CFG.PADD * 2 - 2, CFG.PADD * 2 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD)){
            int iCurrent;

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                this.iCurrent = nCurrent;
            }

            @Override
            public void buildElemHover() {
                try {
                    this.menuElemHover = CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(Menu_InGame_Civ_Stats.this.getMenuElem(5).getCurr()) ? CFG.core.getHover_LargestCity(Menu_InGame_Civ_Stats.this.getMenuElem(5).getCurr()) : null) : CFG.core.getHover_LargestCity(Menu_InGame_Civ_Stats.this.getMenuElem(5).getCurr());
                }
                catch (IndexOutOfBoundsException ex) {
                    this.menuElemHover = null;
                }
            }
        });
        ArrayList<Long> lData = new ArrayList<Long>();
        ArrayList<Integer> lCivs = new ArrayList<Integer>();
        lData.add(18L);
        lCivs.add(1);
        lData.add(7L);
        lCivs.add(2);
        menuElements.add(new Graph_Circle(IMGManager.getIMG(Images.noLeader).getWidth() + CFG.PADD * 3, circlePosY, lData, lCivs, null){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_PopulationOfCiv(CFG.getActiveCivInfoId());
            }
        });
        int tier2_H = CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        int tier2_W = (menuW - CFG.PADD * 4 - 2 - CFG.PADD * 2) / 3;
        menuElements.add(new TextIcon_Horizontal("3.2", CFG.FONT_BOLD_SMALL, Images.topMovementPoints, CFG.PADD * 2 + tier2_W * 2 + CFG.PADD * 2, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 3 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 2, tier2_W, tier2_H, CFG.PADD * 4){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_MOVEMENT_ACTIVE : (this.getIsHovered() ? CFG.COLOR_MOVEMENT_HOVER : CFG.COLOR_MOVEMENT);
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MovementPoints") + ": ", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Text_Big("" + (float)CFG.core.getCiv(CFG.getActiveCivInfoId()).getMovemPoints() / 10.0f, CFG.COLOR_MOVEMENT));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.topMovementPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BaseValue") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + (float)CFG.gameAction.getMovementPoints_BaseValue(CFG.getActiveCivInfoId()) / 10.0f, CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CivilizationSize") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (CFG.gameAction.getMovementPoints_FromCivSize(CFG.getActiveCivInfoId()) == 0 ? "" : "+") + (float)CFG.gameAction.getMovementPoints_FromCivSize(CFG.getActiveCivInfoId()) / 10.0f, CFG.gameAction.getMovementPoints_FromCivSize(CFG.getActiveCivInfoId()) == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Flag(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Technology") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (CFG.gameAction.getMovementPoints_FromTechnology(CFG.getActiveCivInfoId()) == 0 ? "" : "+") + (float)CFG.gameAction.getMovementPoints_FromTechnology(CFG.getActiveCivInfoId()) / 10.0f, CFG.gameAction.getMovementPoints_FromTechnology(CFG.getActiveCivInfoId()) == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (CFG.gameAction.getMovementPoints_TechnologyPoints(CFG.getActiveCivInfoId()) == 0 ? "" : "+") + (float)CFG.gameAction.getMovementPoints_TechnologyPoints(CFG.getActiveCivInfoId()) / 10.0f, CFG.gameAction.getMovementPoints_TechnologyPoints(CFG.getActiveCivInfoId()) == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    
                }
            }
        });
        menuElements.add(new TextIcon_Horizontal("0.84", CFG.FONT_BOLD_SMALL, Images.technology, CFG.PADD * 2 + tier2_W + CFG.PADD, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 3 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 2, tier2_W, tier2_H, CFG.PADD * 4){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_TechnologyLevel(CFG.getActiveCivInfoId());
            }

            @Override
            public void actionElemPPM() {
                CFG.menus.rebuildInGame_Technology(CFG.getActiveCivInfoId());
            }

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TECHNOLOGY);
            }
        });
        menuElements.add(new TextCivInfo("", CFG.PADD * 2, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 4 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 2){

            @Override
            public boolean getVisibleE() {
                return false;
            }
        });
        menuElements.add(new TextIcon_Horizontal("11k", CFG.FONT_BOLD_SMALL, Images.economy, CFG.PADD * 2, CFG.PADD * 3 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 3 + CFG.PADD + CFG.graphCircleDraw.getWidth() + CFG.PADD * 2, tier2_W, tier2_H, CFG.PADD * 4){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_ECONOMY_ACTIVE : (this.getIsHovered() ? CFG.COLOR_ECONOMY_HOVER : CFG.COLOR_ECONOMY);
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    long tempTotalEco = CFG.core.getCiv(CFG.getActiveCivInfoId()).countEco();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Economy") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + tempTotalEco), CFG.COLOR_ECONOMY));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("StartingEconomy") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.startingEconomy), CFG.COLOR_ECONOMY));
                    nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, CFG.PADD));
                    long difference = tempTotalEco - CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.startingEconomy;
                    nData.add(new ME_Hover_2Type_Text((difference > 0L ? "+" : "") + CFG.getNumberWthSpaces("" + difference), difference == 0L ? CFG.COLOR_NEUTRAL : (difference > 0L ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                    nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Text(" [" + (difference > 0L ? "+" : "") + CFG.getPercentage2Old(tempTotalEco - CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.startingEconomy, CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.startingEconomy, 100) + "%]", CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_ECONOMY, CFG.getActiveCivInfoId()));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OverinvestmentPenalty") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(Core.getOverInvestmentsPenalty(CFG.getActiveCivInfoId()) * 100.0f, 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Flag(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomicInvestments"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Flag(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Image(Images.investEco, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalEconomicIncrease") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.iGEG), CFG.COLOR_ECONOMY));
                    nData.add(new ME_Hover_2Type_Image(Images.investEco, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalCost") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.iGE), CFG.COLOR_GOLD));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception ex) {
                    this.menuElemHover = null;
                }
            }
        });
        menuElements.add(new TextLeftSide_Happiness("", menuW - CFG.PADD * 2 - 2, ((MenuElemUI)menuElements.get(6)).getPosY() + ((MenuElemUI)menuElements.get(6)).getHeightE() - CFG.TEXT_HEIGHT_DEFAULT * 3 - CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Happiness") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(CFG.getHappinessImage(CFG.core.getCiv(CFG.getActiveCivInfoId()).getHappiness()), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextLeftSide_Ideology("", menuW - CFG.PADD * 2 - 2, ((MenuElemUI)menuElements.get(6)).getPosY() + ((MenuElemUI)menuElements.get(6)).getHeightE() - CFG.TEXT_HEIGHT_DEFAULT * 2 - CFG.PADD){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.ideologiesMgr.getIdeologyHover(CFG.getActiveCivInfoId());
            }
        });
        menuElements.add(new TextLeftSide_Stability("", menuW - CFG.PADD * 2 - 2, ((MenuElemUI)menuElements.get(6)).getPosY() + ((MenuElemUI)menuElements.get(6)).getHeightE() - CFG.TEXT_HEIGHT_DEFAULT * 4 - CFG.PADD * 3){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Stability") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploStability, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalAssimilationCount") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.aACS), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalAssimilationCost") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.aACSG), CFG.COLOR_GOLD));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextLeftSide_Religion("", menuW - CFG.PADD * 2 - 2, ((MenuElemUI)menuElements.get(6)).getPosY() + ((MenuElemUI)menuElements.get(6)).getHeightE() - CFG.TEXT_HEIGHT_DEFAULT){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.religionManager.getReligionHover(this.getCurr(), CFG.getActiveCivInfoId());
            }
        });
        menuElements.add(new TextLeftSide_Nukes("", menuW - CFG.PADD * 2 - 2, ((MenuElemUI)menuElements.get(6)).getPosY() + ((MenuElemUI)menuElements.get(6)).getHeightE() - CFG.TEXT_HEIGHT_DEFAULT * 3 - CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AtomicBombs") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.nuke, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Transparent(0, 0, menuW, ((MenuElemUI)menuElements.get(menuElements.size() - 6)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 6)).getHeightE() + CFG.PADD, true));
        int tempPosY = ButtonFlagBig.getButtonH() + CFG.PADD * 4 + IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3;
        this.initMenu(null, AoCGame.LEFT, tempPosY, menuW, Math.min(CFG.GAMEHEIGHT - tempPosY - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2 - CFG.BUTTON_H - CFG.PADD, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD), menuElements, false, false);
        this.updateLang();
        try {
            float fScale = ((float)(this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2) - 2.0f) / (float)IMGManager.getIMG(Images.noLeader).getHeight();
            this.getMenuElem(1).setPosX((int)((float)IMGManager.getIMG(Images.noLeader).getWidth() * fScale + (float)(CFG.PADD * 2)));
            this.getMenuElem(6).setPosX((int)((float)IMGManager.getIMG(Images.noLeader).getWidth() * fScale + (float)(CFG.PADD * 2)));
        }
        catch (Exception exception) {
            
        }
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Population"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Capital"));
        this.getMenuElem(4).setTextE(CFG.lang.get("LargestCity"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_InGame_Civ.lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            iTranslateX = Menu_InGame_Civ.hideAnimation ? (iTranslateX -= (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_InGame_Civ.lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))) : (iTranslateX += -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_InGame_Civ.lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME)));
            CFG.setRenderO(true);
        } else if (Menu_InGame_Civ.hideAnimation) {
            super.setVisibleM(false);
            return;
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING, this.getHeightM() + 2, true, true);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        CFG.drawRect_InfoBox_Left(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, this.getWidthM() - CFG.PADD * 2, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2);
        try {
            float fScale = 1.0f;
            if (!CFG.activeCivLeader.isEmpty()) {
                if (CFG.leaderTime + CFG.leaderFrame < CFG.currentTimeMillis) {
                    CFG.leaderTime = CFG.currentTimeMillis;
                    if (++CFG.leaderFrameID >= CFG.leaderFrameSize) {
                        CFG.leaderFrameID = 0;
                    }
                }
                try {
                    fScale = ((float)(this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2) - 2.0f) / (float)CFG.activeCivLeader.get(CFG.leaderFrameID).getHeight();
                    CFG.activeCivLeader.get(CFG.leaderFrameID).draw(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + 1 + iTranslateY, (int)((float)CFG.activeCivLeader.get(CFG.leaderFrameID).getWidth() * fScale), this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.575f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, (int)((float)CFG.activeCivLeader.get(CFG.leaderFrameID).getWidth() * fScale), CFG.PADD);
                    IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + 1 + (this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2) - CFG.PADD + iTranslateY, (int)((float)CFG.activeCivLeader.get(CFG.leaderFrameID).getWidth() * fScale), CFG.PADD, false, true);
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, CFG.PADD, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2);
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + (int)((float)CFG.activeCivLeader.get(CFG.leaderFrameID).getWidth() * fScale) - CFG.PADD + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, CFG.PADD, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2, true, false);
                    oSB.setColor(new Color(CFG.COLOR_TEXT_NUM_OF_PROVINCES.r, CFG.COLOR_TEXT_NUM_OF_PROVINCES.g, CFG.COLOR_TEXT_NUM_OF_PROVINCES.b, 0.175f));
                    CFG.drawRect(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, (int)((float)CFG.activeCivLeader.get(CFG.leaderFrameID).getWidth() * fScale) - 1, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2);
                    oSB.setColor(Color.WHITE);
                }
                catch (Exception exception) {}
            } else {
                fScale = ((float)(this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2) - 2.0f) / (float)IMGManager.getIMG(Images.noLeader).getHeight();
                IMGManager.getIMG(Images.noLeader).draw(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + 1 + iTranslateY, (int)((float)IMGManager.getIMG(Images.noLeader).getWidth() * fScale), this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.575f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, (int)((float)IMGManager.getIMG(Images.noLeader).getWidth() * fScale), CFG.PADD);
                IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + 1 + (this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2) - CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.noLeader).getWidth() * fScale), CFG.PADD, false, true);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, CFG.PADD, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + (int)((float)IMGManager.getIMG(Images.noLeader).getWidth() * fScale) - CFG.PADD + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, CFG.PADD, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2, true, false);
                oSB.setColor(new Color(CFG.COLOR_TEXT_NUM_OF_PROVINCES.r, CFG.COLOR_TEXT_NUM_OF_PROVINCES.g, CFG.COLOR_TEXT_NUM_OF_PROVINCES.b, 0.175f));
                CFG.drawRect(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + 1 + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.noLeader).getWidth() * fScale) - 1, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() - this.getMenuElem(0).getPosY() + CFG.PADD * 2 - 2);
                oSB.setColor(Color.WHITE);
            }
        }
        catch (Exception exception) {
            
        }
        CFG.drawRect_InfoBox_Left(oSB, this.getPosX() + this.getMenuElem(10).getPosXE() - CFG.PADD + iTranslateX, this.getMenuPosY() + this.getMenuElem(10).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(7).getPosXE() + this.getMenuElem(7).getWidthE() - this.getMenuElem(10).getPosXE() + CFG.PADD * 2, this.getMenuElem(10).getHeightE() + CFG.PADD * 2);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (AoCGame.LEFT != 0) {
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM() + 2, true, true);
            oSB.setColor(Color.WHITE);
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_CivInfo();
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: 
            case 1: {
                Menu_InGame_View_PopulationCiv.civID = CFG.getActiveCivInfoId();
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_POPULATION_OF_CIV_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_POPULATION_OF_CIV_MODE) break;
                CFG.toastM.addM(CFG.lang.get("Population"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                break;
            }
            case 2: 
            case 3: {
                try {
                    if (CFG.FOG_OF_WAR == 2) {
                        if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID())) break;
                        CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID());
                        CFG.core.setActiveProvID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID());
                        break;
                    }
                    CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID());
                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID());
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
                break;
            }
            case 4: 
            case 5: {
                try {
                    int nLargestCity = CFG.core.getCiv(CFG.getActiveCivInfoId()).getProvID(0);
                    for (int i = 1; i < CFG.core.getCiv(CFG.getActiveCivInfoId()).getNumOfProvs(); ++i) {
                        if (CFG.core.getProv(nLargestCity).getPop().getPops() >= CFG.core.getProv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getProvID(i)).getPop().getPops()) continue;
                        nLargestCity = CFG.core.getCiv(CFG.getActiveCivInfoId()).getProvID(i);
                    }
                    if (CFG.FOG_OF_WAR == 2) {
                        if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(nLargestCity)) break;
                        CFG.map.getMpC().centerToProvID(nLargestCity);
                        CFG.core.setActiveProvID(nLargestCity);
                        break;
                    }
                    CFG.map.getMpC().centerToProvID(nLargestCity);
                    CFG.core.setActiveProvID(nLargestCity);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
                break;
            }
            case 6: {
                break;
            }
            case 8: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_TECHNOLOGY_MODE, false);
                if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_TECHNOLOGY_MODE) break;
                CFG.toastM.addM(CFG.lang.get("TechnologyLevel"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                break;
            }
            case 9: 
            case 10: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_ECONOMY_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_ECONOMY_MODE) break;
                CFG.toastM.addM(CFG.lang.get("Economy"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                break;
            }
            case 11: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_HAPPINESS_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_HAPPINESS_MODE) break;
                CFG.toastM.addM(CFG.lang.get("Happiness"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                break;
            }
            case 12: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_IDEOLOGIES_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_IDEOLOGIES_MODE) break;
                CFG.toastM.addM(CFG.lang.get("Governments"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                break;
            }
            case 13: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_PROVINCE_STABILITY_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_PROVINCE_STABILITY_MODE) break;
                CFG.toastM.addM(CFG.lang.get("ProvinceStability"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                break;
            }
            case 14: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_RELIGION_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_RELIGION_MODE) break;
                CFG.toastM.addM(CFG.lang.get("Religion"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            }
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible) {
            super.setVisibleM(visible);
        }
    }
}

