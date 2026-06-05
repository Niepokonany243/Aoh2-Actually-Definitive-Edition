
package age.of.civilizations2.jakowski.lukasz.Menus.Budget;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Graph;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Vassal;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Vassal_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_GraphMain;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_Top;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_2;
import age.of.civilizations2.jakowski.lukasz.NewTurn;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Goods;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Investments;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Military;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Research;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame_Taxes;
import age.of.civilizations2.jakowski.lukasz.TechManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBudgetTitle_TextLeft;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextEconomyTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextEconomy_Balance_Graph;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextEconomy_SliderDesc_Research;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextEconomy_Total;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextEconomy_Value;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextInvestemnts_SliderDesc;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextInvestemnts_SliderDescGoods;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_FA_Budget
extends Menu {
    public Menu_InGame_FA_Budget() {
        int tempHeight = 0;
        int tempWidth = 0;
        int tY = CFG.PADD;
        if (CFG.isAndroid() && !CFG.LANDSCAPE && !CFG.isIOS()) {
            tempWidth = CFG.GAMEWIDTH - CFG.PADD * 4;
            tempHeight = IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4 + (CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2) / 2 - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) + CFG.PADD;
        } else if (CFG.isAndroid() && CFG.LANDSCAPE || CFG.isIOS() || AoCGame.LEFT != 0) {
            tempWidth = (int)((float)Menu_InGame_FA_Top.getWindowWidth() - (float)Menu_InGame_FA_Top.getWindowWidth() * (1.0f - GameValues.gvInGame.FLAG_BUDGET_WIDTH) - (float)(CFG.PADD * 2));
            tempHeight = CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - CFG.PADD * 2;
        } else {
            tempWidth = (int)((float)CFG.GAMEWIDTH - (float)CFG.GAMEWIDTH * (1.0f - GameValues.gvInGame.FLAG_BUDGET_WIDTH) - (float)(CFG.PADD * 2));
            tempHeight = CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2;
        }
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        CFG.gameUpdate.getBalance_UpdateBudgetPrepare(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        long tempBalance = 0L;
        menuElements.add(new TextEconomyTitle(CFG.lang.get("Income"), -1, CFG.PADD * 2, tY, (tempWidth - CFG.PADD * 4) / 2, Math.max(CFG.BUTTON_H / 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 3)){

            @Override
            public void buildElemHover() {
                int i;
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Income")));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_INCOME, CFG.PLAYER_TURN_ID));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                ArrayList<Integer> tempProvs = new ArrayList<Integer>();
                int civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                for (i = 0; i < CFG.core.getCiv(civID).getNumOfProvs(); ++i) {
                    if (CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(civID).getProvID(i))) continue;
                    tempProvs.add(CFG.core.getCiv(civID).getProvID(i));
                }
                i = 0;
                for (int added = 0; i < tempProvs.size() && added < 5; ++added, ++i) {
                    int bestID = 0;
                    for (int a = 1; a < tempProvs.size(); ++a) {
                        if (!(CFG.gameUpdate.getProvIncomeAndExpenses_Total((Integer)tempProvs.get(bestID)) < CFG.gameUpdate.getProvIncomeAndExpenses_Total((Integer)tempProvs.get(a)))) continue;
                        bestID = a;
                    }
                    nData.add(new ME_Hover_2Type_Text(i + 1 + ". " + CFG.core.getProv((Integer)tempProvs.get(bestID)).getProvName() + ": "));
                    int value = (int)CFG.gameUpdate.getProvIncomeAndExpenses_Total((Integer)tempProvs.get(bestID));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + value), value > 0 ? Colors.COLOR_TEXT_MODIFIER_POSITIVE : Colors.COLOR_TEXT_MODIFIER_NEGATIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    tempProvs.remove(bestID);
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        long tempValue = CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).incomeTaxation;
        menuElements.add(new TextEconomy_Value("" + tempValue, CFG.lang.get("Taxation"), CFG.PADD * 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), (tempWidth - CFG.PADD * 4) / 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                int i;
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Population") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).countPop()), CFG.COLOR_POPULATION));
                nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_POPULATION, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Technology") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getHappiness() + "%", CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getHappiness(), 100, 1.0f)));
                nData.add(new ME_Hover_2Type_Image(Images.happiness, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                ArrayList<Integer> tempProvs = new ArrayList<Integer>();
                int civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                for (i = 0; i < CFG.core.getCiv(civID).getNumOfProvs(); ++i) {
                    if (CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(civID).getProvID(i))) continue;
                    tempProvs.add(CFG.core.getCiv(civID).getProvID(i));
                }
                i = 0;
                for (int added = 0; i < tempProvs.size() && added < 5; ++added, ++i) {
                    int bestID = 0;
                    for (int a = 1; a < tempProvs.size(); ++a) {
                        if (!(CFG.gameUpdate.getProvIncomeTaxation((Integer)tempProvs.get(bestID)) < CFG.gameUpdate.getProvIncomeTaxation((Integer)tempProvs.get(a)))) continue;
                        bestID = a;
                    }
                    nData.add(new ME_Hover_2Type_Text(i + 1 + ". " + CFG.core.getProv((Integer)tempProvs.get(bestID)).getProvName() + ": "));
                    long value = (long)CFG.gameUpdate.getProvIncomeTaxation((Integer)tempProvs.get(bestID));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + value), value > 0L ? Colors.COLOR_TEXT_MODIFIER_POSITIVE : Colors.COLOR_TEXT_MODIFIER_NEGATIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    tempProvs.remove(bestID);
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax((int)tempValue);
        tempValue = CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).incomeProduction;
        menuElements.add(new TextEconomy_Value("" + tempValue, CFG.lang.get("Production"), CFG.PADD * 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), (tempWidth - CFG.PADD * 4) / 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                int i;
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Economy") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).countEco()), CFG.COLOR_ECONOMY));
                nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_ECONOMY, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Technology") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AverageDevelopment") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countAverageDevelopmentLevel(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("[" + (int)(CFG.core.countAverageDevelopmentLevel_Float(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * 100.0f) + "%", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Text("]", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                ArrayList<Integer> tempProvs = new ArrayList<Integer>();
                int civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                for (i = 0; i < CFG.core.getCiv(civID).getNumOfProvs(); ++i) {
                    if (CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(civID).getProvID(i))) continue;
                    tempProvs.add(CFG.core.getCiv(civID).getProvID(i));
                }
                i = 0;
                for (int added = 0; i < tempProvs.size() && added < 5; ++added, ++i) {
                    int bestID = 0;
                    for (int a = 1; a < tempProvs.size(); ++a) {
                        if (!(CFG.gameUpdate.getProvIncomeProduction((Integer)tempProvs.get(bestID)) < CFG.gameUpdate.getProvIncomeProduction((Integer)tempProvs.get(a)))) continue;
                        bestID = a;
                    }
                    nData.add(new ME_Hover_2Type_Text(i + 1 + ". " + CFG.core.getProv((Integer)tempProvs.get(bestID)).getProvName() + ": "));
                    int value = (int)CFG.gameUpdate.getProvIncomeProduction((Integer)tempProvs.get(bestID));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + value), value > 0 ? Colors.COLOR_TEXT_MODIFIER_POSITIVE : Colors.COLOR_TEXT_MODIFIER_NEGATIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    tempProvs.remove(bestID);
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax((int)tempValue);
        tempValue = (int)CFG.gameUpdate.getIncome_FromVassalsOfCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) + (int)CFG.gameUpdate.getIncome_Debuff_IsVassal(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) + (int)CFG.gameUpdate.getIncome_BuffWarReparations(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) + (int)CFG.gameUpdate.getIncome_DebuffWarReparations(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        menuElements.add(new TextEconomy_Value("" + tempValue, CFG.lang.get("Others"), CFG.PADD * 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), (tempWidth - CFG.PADD * 4) / 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                int i;
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Vassals"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Ideology_Vassal(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                for (i = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() - 1; i > 0; --i) {
                    if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getCiv(i).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
                    nData.add(new ME_Hover_2Type_Flag(i));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(i).getCivName() + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (int)CFG.gameUpdate.getIncomeVassals(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), i), CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Text(" [" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getVassal_Tribute(i) + "%]", CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                for (i = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() + 1; i < CFG.core.getCivsSize(); ++i) {
                    if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getCiv(i).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
                    nData.add(new ME_Hover_2Type_Flag(i));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(i).getCivName() + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (int)CFG.gameUpdate.getIncomeVassals(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), i), CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Text(" [" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getVassal_Tribute(i) + "%]", CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (nElements.size() <= 1) {
                    nElements.clear();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("NoVassals"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Ideology_Vassal_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivId() != CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv()) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Lord") + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv()).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv(), CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text("-" + (int)CFG.gameUpdate.getIncomeVassals(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Text(" [" + CFG.core.getCiv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv()).getVassal_Tribute(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) + "%]", CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getWarReparationsGetsSize() > 0 || CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getWarReparationsPaysSize() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("WarReparations"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.diploTruce, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (i = 0; i < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getWarReparationsGetsSize(); ++i) {
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getWarReparationsGets((int)i).iFromCivID));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getWarReparationsGets((int)i).iFromCivID).getCivName() + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (int)CFG.gameUpdate.getWarReparations_Money(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getWarReparationsGets((int)i).iFromCivID), CFG.COLOR_POSITIVE));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.lang.get("TurnsX", CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getWarReparationsGets((int)i).iTurnsLeft), CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    for (i = 0; i < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getWarReparationsPaysSize(); ++i) {
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getWarReparationsPays((int)i).iFromCivID));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getWarReparationsPays((int)i).iFromCivID).getCivName() + ": "));
                        nData.add(new ME_Hover_2Type_Text("-" + (int)CFG.gameUpdate.getWarReparations_Money(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.lang.get("TurnsX", CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getWarReparationsPays((int)i).iTurnsLeft), CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax((int)tempValue);
        tempValue = (long)CFG.gameUpdate.getIncome(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        tempBalance = tempValue;
        menuElements.add(new TextEconomy_Total("" + CFG.getNumberWthSpaces("" + tempValue), CFG.lang.get("TotalIncome"), CFG.PADD * 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), (tempWidth - CFG.PADD * 4) / 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 3){

            @Override
            public void buildElemHover() {
                long tempValue;
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                long tempBalance = tempValue = (long)CFG.gameUpdate.getIncome(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Income") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tempValue), tempValue > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                tempValue = (int)CFG.gameUpdate.getExpenses(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Expenses") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tempValue), tempValue > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Balance") + ": "));
                nData.add(new ME_Hover_2Type_Text(((tempBalance -= (long)tempValue) > 0L ? "+" : "") + CFG.getNumberWthSpaces("" + tempBalance), tempBalance > 0L ? CFG.COLOR_POSITIVE : (tempBalance < 0L ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL)));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax((int)tempValue);
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        tY = CFG.PADD;
        menuElements.add(new TextEconomyTitle(CFG.lang.get("Expenses"), -1, CFG.PADD * 2 + (tempWidth - CFG.PADD * 4) / 2, tY, (tempWidth - CFG.PADD * 4) / 2, Math.max(CFG.BUTTON_H / 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 3)){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Expenses")));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_EXPENSES, CFG.PLAYER_TURN_ID));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                try {
                    int i;
                    ArrayList<Integer> tempProvs = new ArrayList<Integer>();
                    int civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                    for (i = 0; i < CFG.core.getCiv(civID).getNumOfProvs(); ++i) {
                        if (CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(civID).getProvID(i))) continue;
                        tempProvs.add(CFG.core.getCiv(civID).getProvID(i));
                    }
                    i = 0;
                    for (int added = 0; i < tempProvs.size() && added < 5; ++added, ++i) {
                        int bestID = 0;
                        for (int a = 1; a < tempProvs.size(); ++a) {
                            if (!(CFG.gameUpdate.getProvinceAdministrationCost((Integer)tempProvs.get(bestID), CFG.core.getCiv(civID).getCapitalProvID()) < CFG.gameUpdate.getProvinceAdministrationCost((Integer)tempProvs.get(a), CFG.core.getCiv(civID).getCapitalProvID()))) continue;
                            bestID = a;
                        }
                        nData.add(new ME_Hover_2Type_Text(i + 1 + ". " + CFG.core.getProv((Integer)tempProvs.get(bestID)).getProvName() + ": "));
                        int value = (int)CFG.gameUpdate.getProvinceAdministrationCost((Integer)tempProvs.get(bestID), CFG.core.getCiv(civID).getCapitalProvID());
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + value), Colors.COLOR_TEXT_MODIFIER_NEGATIVE));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        tempProvs.remove(bestID);
                    }
                }
                catch (Exception exception) {
                    
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        tempValue = -(int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).administrationCosts - (int)CFG.gameUpdate.getInflationInterestCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) - (int)CFG.gameUpdate.getInflation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getLoans_GoldTotalPerTurn() - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getLoansFromCiv_GoldTotalPerTurn();
        menuElements.add(new TextEconomy_Value("" + Math.abs(tempValue), CFG.lang.get("Administration"), CFG.PADD * 2 + (tempWidth - CFG.PADD * 4) / 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), (tempWidth - CFG.PADD * 4) / 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                int i;
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                float fEff = CFG.gameUpdate.getAdministrationEfficiency(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                int nAtk = (int)((fEff - 0.5f) * 100.0f);
                int nDef = nAtk;
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Administration") + ": " + (int)(fEff * 100.0f) + "%", fEff > 0.6f ? CFG.COLOR_POSITIVE : (fEff > 0.3f ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
                nData.add(new ME_Hover_2Type_Text_Big(" (" + CFG.lang.get("Attack") + ": " + (nAtk >= 0 ? "+" : "") + nAtk + "%, " + CFG.lang.get("Defense") + ": " + (nDef >= 0 ? "+" : "") + nDef + "%)", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image_Big(Images.administration, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Inflation") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)CFG.gameUpdate.getInflation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), (int)CFG.gameUpdate.getInflation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("[" + (float)((int)(CFG.gameUpdate.getInflationPerc(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 10000.0f)) / 100.0f + "%]", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Interest") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)CFG.gameUpdate.getInflationInterestCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), (int)CFG.gameUpdate.getInflationInterestCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                for (i = 0; i < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getLoansSize(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Loan") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getLoan((int)i).iGoldPerTurn), CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text("[" + CFG.lang.get("TurnsX", CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getLoan((int)i).iTurnsLeft) + "]", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Image(Images.diploLoan, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                for (i = 0; i < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getLoansFromCivSize(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Loan") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getLoanFromCiv((int)i).iGoldPerTurn), CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text("[" + CFG.lang.get("TurnsX", CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getLoanFromCiv((int)i).iTurnsLeft) + "]", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Image(Images.diploLoan, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getLoanFromCiv((int)i).fromCivID, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getLoanFromCiv((int)i).fromCivID).getCivName()));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                try {
                    int i2;
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    ArrayList<Integer> tempProvs = new ArrayList<Integer>();
                    int civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                    for (i2 = 0; i2 < CFG.core.getCiv(civID).getNumOfProvs(); ++i2) {
                        if (CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(civID).getProvID(i2))) continue;
                        tempProvs.add(CFG.core.getCiv(civID).getProvID(i2));
                    }
                    i2 = 0;
                    for (int added = 0; i2 < tempProvs.size() && added < 5; ++added, ++i2) {
                        int bestID = 0;
                        for (int a = 1; a < tempProvs.size(); ++a) {
                            if (!(CFG.gameUpdate.getProvinceAdministrationCost((Integer)tempProvs.get(bestID), CFG.core.getCiv(civID).getCapitalProvID()) < CFG.gameUpdate.getProvinceAdministrationCost((Integer)tempProvs.get(a), CFG.core.getCiv(civID).getCapitalProvID()))) continue;
                            bestID = a;
                        }
                        nData.add(new ME_Hover_2Type_Text(i2 + 1 + ". " + CFG.core.getProv((Integer)tempProvs.get(bestID)).getProvName() + ": "));
                        int value = (int)CFG.gameUpdate.getProvinceAdministrationCost((Integer)tempProvs.get(bestID), CFG.core.getCiv(civID).getCapitalProvID());
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + value), Colors.COLOR_TEXT_MODIFIER_NEGATIVE));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        tempProvs.remove(bestID);
                    }
                }
                catch (Exception exception) {
                    
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax((int)tempValue);
        tempValue = -((long)CFG.gameUpdate.getMilitaryUpkeep_Total(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
        menuElements.add(new TextEconomy_Value("" + Math.abs(tempValue), CFG.lang.get("Military"), CFG.PADD * 2 + (tempWidth - CFG.PADD * 4) / 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), (tempWidth - CFG.PADD * 4) / 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Army") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits()), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_ARMY_SIZE, CFG.PLAYER_TURN_ID));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                int nUpkeep = (int)CFG.gameUpdate.getMilitaryUpkeep_Total(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + nUpkeep, nUpkeep == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_MILITARY_SPENDING, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
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
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BudgetSpendings") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.gameUpdate.getMilitarySpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget) + "%", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax((int)tempValue);
        tempValue = -((long)CFG.gameUpdate.getInvestments_Total(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget)) - (long)CFG.gameUpdate.getGoodsSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget);
        menuElements.add(new TextEconomy_Value("" + Math.abs(tempValue), CFG.lang.get("Spendings"), CFG.PADD * 2 + (tempWidth - CFG.PADD * 4) / 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), (tempWidth - CFG.PADD * 4) / 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Goods") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)CFG.gameUpdate.getGoodsSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget), (int)CFG.gameUpdate.getGoodsSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget) > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Research") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)CFG.gameUpdate.getResearchSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget), (int)CFG.gameUpdate.getResearchSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget) > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)CFG.gameUpdate.getInvestmentsSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget), (int)CFG.gameUpdate.getInvestmentsSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget) > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax((int)tempValue);
        tempValue = -((long)CFG.gameUpdate.getExpenses(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
        tempBalance += tempValue;
        menuElements.add(new TextEconomy_Total("" + CFG.getNumberWthSpaces("" + Math.abs(tempValue)), CFG.lang.get("TotalExpenses"), CFG.PADD * 2 + (tempWidth - CFG.PADD * 4) / 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), (tempWidth - CFG.PADD * 4) / 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 3){

            @Override
            public void buildElemHover() {
                int tempValue;
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                int tempBalance = tempValue = (int)CFG.gameUpdate.getIncome(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Income") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tempValue), tempValue > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                tempValue = (int)CFG.gameUpdate.getExpenses(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Expenses") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tempValue), tempValue > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Balance") + ": "));
                nData.add(new ME_Hover_2Type_Text(((tempBalance -= (long)tempValue) > 0L ? "+" : "") + CFG.getNumberWthSpaces("" + tempBalance), tempBalance > 0L ? CFG.COLOR_POSITIVE : (tempBalance < 0L ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL)));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax((int)tempValue);
        int balanceY = tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int balanceH = CFG.TEXT_HEIGHT_DEFAULT * 2 + CFG.PADD * 5;
        tempValue = tempBalance;
        menuElements.add(new TextEconomy_Balance_Graph("" + CFG.getNumberWthSpaces("" + tempValue), CFG.lang.get("Balance") + ": ", CFG.PADD * 2 + (tempWidth - CFG.PADD * 4) / 2, tY, (tempWidth - CFG.PADD * 4) / 2, balanceH, Graph2.GraphType.PLAYER_BALANCE){

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_GOLD;
            }

            @Override
            public void buildElemHover() {
                long tempValue;
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                long tempBalance = tempValue = (long)CFG.gameUpdate.getIncome(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Income") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tempValue), tempValue > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_INCOME, CFG.PLAYER_TURN_ID));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                tempValue = (int)CFG.gameUpdate.getExpenses(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Expenses") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tempValue), tempValue > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                tempBalance -= (long)tempValue;
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Balance") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big((tempBalance > 0 ? "+" : "") + CFG.getNumberWthSpaces("" + tempBalance), tempBalance > 0 ? CFG.COLOR_POSITIVE : (tempBalance < 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL)));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_BALANCE, CFG.PLAYER_TURN_ID));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax((int)tempValue);
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        for (int i = 0; i < menuElements.size(); ++i) {
            ((MenuElemUI)menuElements.get(i)).setCurr(i % 2);
        }
        float tFValue = CFG.gameUpdate.getHappinessChange_ByTaxation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        menuElements.add(new Slider_InGame_Taxes("" + (tFValue > 0.0f ? "+" : "") + tFValue, CFG.lang.get("Taxes"), CFG.PADD * 3, tY += CFG.PADD * 2, tempWidth - CFG.PADD * 6, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5, 0, 100, (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTaxationLvl() * 100.0f)){

            @Override
            public String getDrawText() {
                return this.getCurr() + "%";
            }

            @Override
            public Color getColorLEFT() {
                return CFG.getColorStep(new Color(0.023529412f, 0.3254902f, 0.40392157f, 0.65f), new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.65f), (int)this.getCurr(), 100, 0.65f);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_GOLD;
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax(tFValue >= 0.0f ? 0 : (tFValue <= -0.8f ? 2 : 1));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
        String bTextLeft = "";
        try {
            bTextLeft = CFG.lang.get(GameValues.gvAdministrationPolicy.POLICY_NAME[CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.policyID]);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        menuElements.add(new TextBudgetTitle_TextLeft(CFG.lang.get("BudgetSpendings"), -1, 2 + CFG.PADD, tY, tempWidth - 4 - CFG.PADD * 2, CFG.BUTTON_H / 2 + CFG.PADD, bTextLeft, Images.gov){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Budget") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget > 0 ? CFG.COLOR_POSITIVE : (CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topGold(), CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Budget") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.lang.get("TotalIncome") + " ", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Text("- " + CFG.lang.get("AdministrationCost"), CFG.COLOR_NEGATIVE_2));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitarySpendings") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.gameUpdate.getMilitarySpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("GoodsSpendings") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingGoodsB() * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.goods, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchSpendings") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingResearchB() * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("InvestmentsSpendings") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingInvestmentsB() * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        menuElements.add(new Slider_InGame_Goods(CFG.lang.get("Goods"), CFG.PADD * 3, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempWidth - CFG.PADD * 6, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5, 0, 500, (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingGoodsB() * 100.0f)){

            @Override
            public String getDrawText() {
                return this.getCurr() + "%";
            }

            @Override
            public Color getColorLEFT() {
                return this.getCurr() < (int)(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getMin_Goods(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f) ? CFG.getColorStep(new Color(0.54901963f, 0.078431375f, 0.078431375f, 0.65f), new Color(0.7058824f, 0.078431375f, 0.078431375f, 0.65f), (int)(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getMin_Goods(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f) - (int)this.getCurr(), (int)(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getMin_Goods(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f), 0.65f) : CFG.getColorStep(new Color(0.019607844f, 0.39215687f, 0.1764706f, 0.65f), new Color(0.039215688f, 0.5686275f, 0.29411766f, 0.65f), (int)this.getCurr(), 100, 0.65f);
            }

            @Override
            public Color getColor(boolean isActive) {
                return this.getCurr() >= (int)(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getMin_Goods(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f) ? super.getColor(isActive) : CFG.COLOR_NEGATIVE_2;
            }
        });
        menuElements.add(new TextInvestemnts_SliderDescGoods(CFG.lang.get("AverageGrowthRate") + ": " + CFG.core.countAvarageGrowthRate(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) + "%", CFG.lang.get("Population") + ": ", CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).countPop()), CFG.PADD * 3, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - CFG.PADD * 6, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("hGoods"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("hGoods2")));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("hGoods3", "" + (int)(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getMin_Goods(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f))));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("hGoods4")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BudgetSpendings") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingGoodsB() * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Spendings") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getGoodsSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget)), CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).countPop()), CFG.COLOR_POPULATION));
                nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                int popGrowth = NewTurn.getUpdateGameData_PopulationGrowth_WithoutRandom(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                String nPopGrowth = (popGrowth < 0 ? "-" : (popGrowth > 0 ? "+" : "")) + CFG.getNumberWthSpaces("" + Math.abs(popGrowth));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EstimatedPopulationGrowth") + ": "));
                nData.add(new ME_Hover_2Type_Text(nPopGrowth, popGrowth > 0 ? CFG.COLOR_POPULATION : (popGrowth < 0 ? CFG.COLOR_NEGATIVE_1 : CFG.COLOR_NEUTRAL)));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_InGame_Research(CFG.lang.get("Research"), CFG.PADD * 3, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, tempWidth - CFG.PADD * 6, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5, 0, 500, (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingResearchB() * 100.0f), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameValues.gvTechnology.MIN_MONEY_REQUIRED_TO_ENABLE_RESEARCH){

            @Override
            public String getDrawText() {
                return this.getCurr() + "%";
            }

            @Override
            public Color getColorLEFT() {
                return CFG.getColorStep(new Color(0.07058824f, 0.18431373f, 0.3882353f, 0.65f), new Color(0.105882354f, 0.27450982f, 0.57254905f, 0.65f), (int)this.getCurr(), 100, 0.65f);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_TECHNOLOGY;
            }
        });
        menuElements.add(new TextEconomy_SliderDesc_Research(CFG.lang.get("Progress") + ": ", CFG.getNumberWthSpaces("" + (int)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getResearchProgressT()), " / " + CFG.getNumberWthSpaces("" + TechManager.getResearchNextLevel(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) + " ", "[" + CFG.getPercentage_Max100((int)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getResearchProgressT(), TechManager.getResearchNextLevel(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 4) + "%]", (!Menu_InGame_Civ.getUseMenu_UI2() ? CFG.lang.get("TechnologyLevel") + ": " : "") + (float)((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.PADD * 3, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - CFG.PADD * 6, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Tech1"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Tech2")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyLevel") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Max") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchProgress") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getResearchProgressT()) + " / " + CFG.getNumberWthSpaces("" + TechManager.getResearchNextLevel(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.COLOR_NEUTRAL2));
                nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BudgetSpendings") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingResearchB() * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Spendings") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getResearchSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget)), CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_TECHNOLOGY;
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMin((int)(CFG.gameUpdate.getResearchSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget) * (1.0f + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getModifier_Research())));
        menuElements.add(new Slider_InGame_Investments(CFG.lang.get("Investments"), CFG.PADD * 3, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, tempWidth - CFG.PADD * 6, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 5, 0, 500, (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingInvestmentsB() * 100.0f)){

            @Override
            public String getDrawText() {
                return this.getCurr() + "%";
            }

            @Override
            public Color getColorLEFT() {
                return this.getCurr() < (int)(CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f) ? CFG.getColorStep(new Color(0.54901963f, 0.078431375f, 0.078431375f, 0.65f), new Color(0.7058824f, 0.078431375f, 0.078431375f, 0.65f), (int)(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).MIN_INVESTMENTS * 100.0f) - (int)this.getCurr(), (int)(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).MIN_INVESTMENTS * 100.0f), 0.65f) : CFG.getColorStep(new Color(0.105882354f, 0.16078432f, 0.2901961f, 0.65f), new Color(0.20392157f, 0.2784314f, 0.45490196f, 0.65f), (int)this.getCurr(), 100, 0.65f);
            }

            @Override
            public Color getColor(boolean isActive) {
                return this.getCurr() >= (int)(CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 100.0f) ? super.getColor(isActive) : CFG.COLOR_NEGATIVE_2;
            }
        });
        menuElements.add(new TextInvestemnts_SliderDesc(CFG.lang.get("AverageDevelopment") + ": " + CFG.core.countAverageDevelopmentLevel(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) + " [" + (int)(CFG.core.countAverageDevelopmentLevel_Float(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * 100.0f) + "%]", CFG.lang.get("Economy") + ": ", CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).countEco()), CFG.PADD * 3, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - CFG.PADD * 6, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("BuildYourEconomicPowerBySpendingGoldOnInvestments"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.development, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DevelopmentLevelAndEconomyWillBeIncreased")));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AverageDevelopment") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countAverageDevelopmentLevel(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Text(" [" + (int)(CFG.core.countAverageDevelopmentLevel_Float(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * 100.0f) + "%", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image(Images.technology, 0, 0));
                nData.add(new ME_Hover_2Type_Text("]", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Tech4"), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Tech5"), CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BudgetSpendings") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingInvestmentsB() * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Spendings") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getInvestmentsSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget)), CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_InGame_Military(CFG.lang.get("Military"), CFG.PADD * 3, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, tempWidth - CFG.PADD * 6, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.PADD * 4, 0, 100, CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget < 0 && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits() > 0 ? 100 : CFG.gameUpdate.getMilitarySpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget)){

            @Override
            public String getDrawText() {
                return this.getCurr() + "%";
            }

            @Override
            public Color getColorLEFT() {
                return new Color(0.39215687f, 0.078431375f, 0.078431375f, 0.65f);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Army") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_ARMY_SIZE, CFG.PLAYER_TURN_ID));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BudgetSpendings") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.gameUpdate.getMilitarySpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget) + "%", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getMilitaryUpkeep_Total(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                float upkeepPerUnit = 0.0f;
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits() > 0) {
                    upkeepPerUnit = CFG.gameUpdate.getMilitaryUpkeep_Total(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits();
                }
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("UpkeepPerUnit") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(upkeepPerUnit, 100), CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_MILITARY_SPENDING, CFG.PLAYER_TURN_ID));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(false);
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
        int lastElementID_PosY = menuElements.size() - 1;
        menuElements.add(new TextEconomy_Balance_Graph("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold()), CFG.lang.get("Treasury") + ": ", CFG.PADD * 2, balanceY, (tempWidth - CFG.PADD * 4) / 2, balanceH, Graph2.GraphType.PLAYER_TREASURY){

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_GOLD;
            }

            @Override
            public void setMax(int iMax) {
                this.textColor = iMax == 0 ? CFG.COLOR_NEUTRAL2 : (iMax > 0 ? CFG.COLOR_GOLD : CFG.COLOR_NEGATIVE_2);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                long tempValue = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Treasury") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + tempValue), tempValue > 0L ? CFG.COLOR_GOLD : CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_TREASURY, CFG.PLAYER_TURN_ID));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold());
        menuElements.add(new Button_Transparent(0, 0, tempWidth, tempHeight - CFG.PADD < ((MenuElemUI)menuElements.get(lastElementID_PosY)).getPosY() + ((MenuElemUI)menuElements.get(lastElementID_PosY)).getHeightE() ? ((MenuElemUI)menuElements.get(lastElementID_PosY)).getPosY() + ((MenuElemUI)menuElements.get(lastElementID_PosY)).getHeightE() : tempHeight - CFG.PADD, true));
        this.initMenu(null, CFG.PADD * 2 + AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, tempWidth, tempHeight - CFG.PADD, menuElements, false, false);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_InGame_FA_GraphMain.lTime + 225L >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX(), CFG.GAMEHEIGHT - this.getPosY(), this.getWidthM(), -((int)((float)(this.getHeightM() + CFG.PADD) * ((float)(System.currentTimeMillis() - Menu_InGame_FA_GraphMain.lTime) / 225.0f))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            oSB.setColor(Color.WHITE);
            if (CFG.isAndroid() && !CFG.LANDSCAPE) {
                IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdgeLine).getWidth(), this.getHeightM() + CFG.PADD, false, true);
                IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdgeLine).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdgeLine).getWidth(), this.getHeightM() + CFG.PADD, true, true);
            } else {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
            }
            oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.25f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM() + CFG.PADD - 2, true, false);
            oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.75f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 2, CFG.BUTTON_H / 4);
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
            if (CFG.isAndroid() && !CFG.LANDSCAPE) {
                IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdgeLine).getWidth(), this.getHeightM() + CFG.PADD, false, true);
                IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdgeLine).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdgeLine).getWidth(), this.getHeightM() + CFG.PADD, true, true);
            } else {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
            }
            oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.25f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM() + CFG.PADD - 2, true, false);
            oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.75f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 2, CFG.BUTTON_H / 4);
            oSB.setColor(Color.WHITE);
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    private final void updateIncomeAndExpenses() {
        long tempBalance = 0L;
        long tempValue = CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).incomeTaxation;
        this.getMenuElem(1).setTextE("" + tempValue);
        this.getMenuElem(1).setMax((int)tempValue);
        tempValue = CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).incomeProduction;
        this.getMenuElem(2).setTextE("" + tempValue);
        this.getMenuElem(2).setMax((int)tempValue);
        tempValue = (int)CFG.gameUpdate.getIncome_FromVassalsOfCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) + (int)CFG.gameUpdate.getIncome_Debuff_IsVassal(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) + (int)CFG.gameUpdate.getIncome_DebuffWarReparations(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) + (int)CFG.gameUpdate.getIncome_BuffWarReparations(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        this.getMenuElem(3).setTextE("" + tempValue);
        this.getMenuElem(3).setMax((int)tempValue);
        tempValue = (long)CFG.gameUpdate.getIncome(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        tempBalance = tempValue;
        this.getMenuElem(4).setTextE("" + CFG.getNumberWthSpaces("" + Math.abs(tempValue)));
        this.getMenuElem(4).setMax((int)tempValue);
        tempValue = -CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).administrationCosts - (long)CFG.gameUpdate.getInflationInterestCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) - (long)CFG.gameUpdate.getInflation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getLoans_GoldTotalPerTurn() - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getLoansFromCiv_GoldTotalPerTurn();
        this.getMenuElem(6).setTextE("" + Math.abs(tempValue));
        this.getMenuElem(6).setMax((int)tempValue);
        tempValue = -((long)CFG.gameUpdate.getInvestments_Total(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget)) - (long)CFG.gameUpdate.getGoodsSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget);
        this.getMenuElem(8).setTextE("" + Math.abs(tempValue));
        this.getMenuElem(8).setMax((int)tempValue);
        tempValue = -((long)CFG.gameUpdate.getExpenses(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
        this.getMenuElem(9).setTextE("" + CFG.getNumberWthSpaces("" + Math.abs(tempValue)));
        this.getMenuElem(9).setMax((int)tempValue);
        this.getMenuElem(10).setTextE("" + CFG.getNumberWthSpaces("" + (tempBalance += tempValue)));
        this.getMenuElem(10).setMax((int)tempBalance);
        float tFValue = CFG.gameUpdate.getHappinessChange_ByTaxation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        if ((double)tFValue < 0.001 && (double)tFValue > -0.001) {
            tFValue = 0.0f;
        }
        this.getMenuElem(11).setTextE("" + (tFValue > 0.0f ? "+" : "") + tFValue);
        this.getMenuElem(11).setMax(tFValue >= 0.0f ? 0 : (tFValue <= -0.8f ? 2 : 1));
        this.getMenuElem(19).setCurr(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget < 0 && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits() > 0 ? 100 : CFG.gameUpdate.getMilitarySpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget));
        this.getMenuElem(13).setCurr((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingGoodsB() * 100.0f));
        this.getMenuElem(15).setCurr((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingResearchB() * 100.0f));
        this.getMenuElem(16).setMin((int)(CFG.gameUpdate.getResearchSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget) * (1.0f + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getModifier_Research())));
        this.getMenuElem(17).setCurr((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingInvestmentsB() * 100.0f));
        Menu_InGame_2.updateOverBudget();
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_FlagAction();
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                break;
            }
            case 3: {
                if (CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.vassals.size() <= 0) break;
                CFG.menus.rebuildInGame_Tribute();
                CFG.toastM.addM(CFG.lang.get("Vassals"), CFG.COLOR_HOVER_TITLE);
                break;
            }
            case 6: {
                CFG.toastM.addM(CFG.lang.get("hAdministrationCost"), CFG.COLOR_HOVER_TITLE);
                CFG.toastM.setTimeInView(4500);
                break;
            }
            case 11: {
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setTaxationLvl((float)this.getMenuElem(iID).getCurr() / 100.0f);
                CFG.gameUpdate.getBalance_UpdateBudgetPrepare(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                CFG.gameUpdate.updateSpendingOfCivID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget);
                this.updateIncomeAndExpenses();
                if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_INCOME_MODE || !CFG.menus.getVisible_InGame_View_Stats()) break;
                CFG.menus.setVisible_InGame_ViewIncome(true);
                break;
            }
            case 12: {
                CFG.menus.rebuildInGame_AdministrationPolicy();
                CFG.toastM.addM(CFG.lang.get("Budget") + ": " + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget), CFG.COLOR_HOVER_TITLE);
                CFG.toastM.setTimeInView(4500);
                break;
            }
            case 13: {
                if (this.getMenuElem(13).getCurr() + this.getMenuElem(15).getCurr() + this.getMenuElem(17).getCurr() + this.getMenuElem(19).getCurr() > GameValues.gvAiBudget.BUDGET_MAX) {
                    if (this.getMenuElem(15).getCurr() + this.getMenuElem(17).getCurr() > 0) {
                        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setSpendingGoodsB((float)this.getMenuElem(13).getCurr() / 100.0f);
                        CFG.gameUpdate.updateSpendingOfCivID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget);
                        this.getMenuElem(13).setCurr((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingGoodsB() * 100.0f));
                        this.getMenuElem(15).setCurr((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingResearchB() * 100.0f));
                        this.getMenuElem(17).setCurr((int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingInvestmentsB() * 100.0f));
                        if (this.getMenuElem(13).getCurr() + this.getMenuElem(15).getCurr() + this.getMenuElem(17).getCurr() + this.getMenuElem(19).getCurr() > GameValues.gvAiBudget.BUDGET_MAX) {
                            this.getMenuElem(13).setCurr(GameValues.gvAiBudget.BUDGET_MAX - this.getMenuElem(19).getCurr() - this.getMenuElem(15).getCurr() - this.getMenuElem(17).getCurr());
                        }
                    } else {
                        this.getMenuElem(13).setCurr(GameValues.gvAiBudget.BUDGET_MAX - this.getMenuElem(19).getCurr() - this.getMenuElem(15).getCurr() - this.getMenuElem(17).getCurr());
                    }
                }
                this.updateResearchAndInvestments();
                this.getMenuElem(13).setCurr(this.getMenuElem(13).getCurr());
                this.getMenuElem(17).setCurr(this.getMenuElem(17).getCurr());
                this.getMenuElem(16).setMin((int)(CFG.gameUpdate.getResearchSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget) * (1.0f + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getModifier_Research())));
                break;
            }
            case 15: {
                if (this.getMenuElem(15).getCurr() + this.getMenuElem(19).getCurr() + this.getMenuElem(13).getCurr() > GameValues.gvAiBudget.BUDGET_MAX) {
                    this.getMenuElem(15).setCurr(GameValues.gvAiBudget.BUDGET_MAX - this.getMenuElem(19).getCurr() - this.getMenuElem(13).getCurr());
                }
                if (this.getMenuElem(15).getCurr() + this.getMenuElem(17).getCurr() + this.getMenuElem(19).getCurr() + this.getMenuElem(13).getCurr() > GameValues.gvAiBudget.BUDGET_MAX) {
                    this.getMenuElem(17).setCurr(GameValues.gvAiBudget.BUDGET_MAX - this.getMenuElem(15).getCurr() - this.getMenuElem(19).getCurr() - this.getMenuElem(13).getCurr());
                }
                this.updateResearchAndInvestments();
                this.getMenuElem(17).setCurr(this.getMenuElem(17).getCurr());
                this.getMenuElem(16).setMin((int)(CFG.gameUpdate.getResearchSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget) * (1.0f + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getModifier_Research())));
                break;
            }
            case 17: {
                if (this.getMenuElem(17).getCurr() + this.getMenuElem(19).getCurr() + this.getMenuElem(13).getCurr() > GameValues.gvAiBudget.BUDGET_MAX) {
                    this.getMenuElem(17).setCurr(GameValues.gvAiBudget.BUDGET_MAX - this.getMenuElem(19).getCurr() - this.getMenuElem(13).getCurr());
                }
                if (this.getMenuElem(15).getCurr() + this.getMenuElem(17).getCurr() + this.getMenuElem(19).getCurr() + this.getMenuElem(13).getCurr() > GameValues.gvAiBudget.BUDGET_MAX) {
                    this.getMenuElem(15).setCurr(GameValues.gvAiBudget.BUDGET_MAX - this.getMenuElem(17).getCurr() - this.getMenuElem(19).getCurr() - this.getMenuElem(13).getCurr());
                }
                this.updateResearchAndInvestments();
                this.getMenuElem(17).setCurr(this.getMenuElem(17).getCurr());
                this.getMenuElem(16).setMin((int)(CFG.gameUpdate.getResearchSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget) * (1.0f + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getModifier_Research())));
            }
        }
    }

    private final void updateResearchAndInvestments() {
        if (CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget <= 0) {
            this.getMenuElem(13).setCurr(0);
            this.getMenuElem(15).setCurr(0);
            this.getMenuElem(16).setMin(0);
            this.getMenuElem(17).setCurr(0);
        }
        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setSpendingGoodsB((float)this.getMenuElem(13).getCurr() / 100.0f);
        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setSpendingResearchB((float)this.getMenuElem(15).getCurr() / 100.0f);
        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setSpendingInvestmentsB((float)this.getMenuElem(17).getCurr() / 100.0f);
        this.updateIncomeAndExpenses();
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }
}

