/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Recruit;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_Cost_Right;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_Cost_Right_Balance;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_Move;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_MovementCost_Right;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_RecruitInstantly;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_Turns;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

public class Menu_InGame_ActionInfo_Recruit
extends Menu {
    public Menu_InGame_ActionInfo_Recruit() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new TextActionInfo_Move("", 0 + AoCGame.LEFT, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) - CFG.BUTTON_H - CFG.PADD * 2){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_POPULATION_ACTIVE : (this.getIsHovered() ? CFG.COLOR_POPULATION_HOVER : CFG.COLOR_POPULATION);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                int turns = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRecruitmentTurns();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Turns") + ": " + turns, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + turns)));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextActionInfo_MovementCost_Right("-" + (float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_RECRUIT / 10.0f, 0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 2 - CFG.PADD - CFG.BUTTON_H - CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + this.getTextE(), CFG.COLOR_MOVEMENT));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextActionInfo_Cost_Right("", 0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) - CFG.BUTTON_H - CFG.PADD * 2){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_GOLD_ACTIVE : (this.getIsHovered() ? CFG.COLOR_GOLD_HOVER : CFG.COLOR_GOLD);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OneUnitCostsXGold", CFG.gCARR(CFG.core.getActiveProvID())), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        int nRecruitmentTurns = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRecruitmentTurns();
        menuElements.add(new TextActionInfo_Turns(nRecruitmentTurns + " " + (nRecruitmentTurns > 1 ? CFG.lang.get("Turns") : CFG.lang.get("Turn")), 0 + AoCGame.LEFT, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 2 - CFG.PADD - CFG.BUTTON_H - CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                int turns = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRecruitmentTurns();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Turns") + ": " + turns, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + turns)));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextActionInfo_RecruitInstantly(CFG.lang.get("Conscript"), 0 + AoCGame.LEFT, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 3 - CFG.PADD - CFG.PADD - CFG.BUTTON_H - CFG.PADD * 2){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RecruitArmyInstantly"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CostOfRecruitingWillBeDoubled"), CFG.COLOR_NEGATIVE_2));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OneUnitCostsXGold", CFG.getCostOfRecruitArmyMoney_Instantly(BuildingsManager.iBuildInProvinceID)), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_RECRUIT / 10.0f, CFG.COLOR_MOVEMENT));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new TextActionInfo_Cost_Right_Balance(CFG.lang.get("Balance") + ": ", 0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 3 - CFG.PADD * 2 - CFG.BUTTON_H - CFG.PADD * 2){});
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements, false, false);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                break;
            }
            case 1: {
                CFG.toastM.addM(CFG.lang.get("MovementPoints") + ": " + this.getMenuElem(1).getTextE(), CFG.COLOR_MOVEMENT_ZERO);
                return;
            }
            case 2: {
                break;
            }
            case 4: {
                CFG.menus.setVisible_InGame_ProviRecruit(false);
                if (CFG.core.getActiveProvID() >= 0) {
                    if (CFG.core.getProv(CFG.core.getActiveProvID()).getTrueOwnerOfProv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getProv(CFG.core.getActiveProvID()).getPop().getPopulationOfCivID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) > 1) {
                        CFG.core.setActiveProvID(CFG.core.getActiveProvID());
                        if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_RECRUIT) {
                            CFG.menus.setVisible_InGame_ActionInfo_NoMovementPoints();
                        } else if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() < (long)CFG.getCostOfRecruitArmyMoney_Instantly(CFG.core.getActiveProvID())) {
                            CFG.menus.setVisible_InGame_ActionInfo_TreasuryIsEmpty();
                        } else {
                            CFG.core.resetChooseProvinceData();
                            CFG.menus.setVisible_InGame_ProvinceAction(false);
                            CFG.gameAction.updateRecruitSlider_Instantly();
                            CFG.menus.setVisible_InGame_ProvinceRecruitInstantly(true);
                            CFG.menus.setVisible_InGame_ActionInfo_RecruitInstantly();
                            Core.LYC();
                            CFG.toastM.addM(CFG.lang.get("CostOfRecruitingWillBeDoubled"), CFG.COLOR_NEGATIVE_2);
                        }
                    } else {
                        CFG.menus.setVisible_InGame_ActionInfo_RecruitOccupied();
                    }
                }
                return;
            }
            case 5: {
                this.getMenuElem(iID).actionElem(iID);
                return;
            }
        }
        CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_HOVER_TITLE);
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_Recruit();
    }
}

