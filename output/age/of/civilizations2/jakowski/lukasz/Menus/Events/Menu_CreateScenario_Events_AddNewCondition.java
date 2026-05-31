/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Events;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_AdmPolicy;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Allies;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Assimilations;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_AssimilationsCost;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_AssimilationsCostLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_AssimilationsLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_AtWar;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_AveDev;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_AveDevLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_BArmories;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_BFarms;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_BForts;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_BLibraries;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_BMarket;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_BPorts;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_BSupply;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_BTowers;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_BWorkshops;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_BuildingsConstructed;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_BuildingsConstructedLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_CivExist;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_ConquredProvs;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_ConquredProvsLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_ControlledByPlayer;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_ControlsProvinces;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_DecisionTaken;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_DefensivePact;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Development;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Development_Low;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Economy;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Economy_Low;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_EventChance;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Farm;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Festivals;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_FestivalsCost;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_FestivalsCostLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_FestivalsLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Fort;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Happiness;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Happiness_Low;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_HaveArmy;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_HaveCore;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Ideology;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Independence;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Investments;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_InvestmentsLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_InvestsDevCost;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_InvestsDevCostLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_InvestsEcoCost;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_InvestsEcoCostLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_InvestsEcoGained;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_InvestsEcoGainedLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_IsAVassal;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_IsAVassalOfCiv;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_IsAtWar;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_IsCapital;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_IsPartOfHRE;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Leader;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_MilitaryAccess;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_MilitaryExpertise;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_MilitaryExpertiseLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Neutral;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_NonAggression;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Nukes;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_NukesLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_NumOfAllies;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_NumOfAllies_Low;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_NumOfNeighbors;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_NumOfNeighbors_Low;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_NumOfUnits;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_NumOfUnits_Low;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_NumOfVassals;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_NumOfVassals_Low;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_NumOfWars;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_NumOfWars_Low;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_NumberOfProvinces;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_NumberOfProvinces_Low;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_OccupyProvinces;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Population;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Population_Low;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Port;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_RecruitedArmy;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_RecruitedArmyLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Relation;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Relation_Low;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Religion;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Stability;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_StabilityLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Technology;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Technology_Low;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Treasury;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Treasury_Low;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_WarCasu;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_WarCasuLow;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_Wasteland;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions_WatchTower;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_AddNewCondition
extends Menu {
    public Menu_CreateScenario_Events_AddNewCondition() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        for (int i = 0; i < 96; ++i) {
            menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("EventChance"));
        this.getMenuElem(2).setTextE(CFG.lang.get("DecisionTaken"));
        this.getMenuElem(3).setTextE(CFG.lang.get("CivilizationExist"));
        this.getMenuElem(4).setTextE(CFG.lang.get("ControlsProvinces"));
        this.getMenuElem(5).setTextE(CFG.lang.get("OccupiedProvinces"));
        this.getMenuElem(6).setTextE(CFG.lang.get("HaveArmy"));
        this.getMenuElem(7).setTextE(CFG.lang.get("HaveACore"));
        this.getMenuElem(8).setTextE(CFG.lang.get("IsCapital"));
        this.getMenuElem(9).setTextE(CFG.lang.get("NumberOfProvinces") + " >=");
        this.getMenuElem(10).setTextE(CFG.lang.get("NumberOfProvinces") + " <");
        this.getMenuElem(11).setTextE(CFG.lang.get("NumberOfUnits") + " >=");
        this.getMenuElem(12).setTextE(CFG.lang.get("NumberOfUnits") + " <");
        this.getMenuElem(13).setTextE(CFG.lang.get("NumberOfVassals") + " >=");
        this.getMenuElem(14).setTextE(CFG.lang.get("NumberOfVassals") + " <");
        this.getMenuElem(15).setTextE(CFG.lang.get("NumberOfAllies") + " >=");
        this.getMenuElem(16).setTextE(CFG.lang.get("NumberOfAllies") + " <");
        this.getMenuElem(17).setTextE(CFG.lang.get("NumberOfWars") + " >=");
        this.getMenuElem(18).setTextE(CFG.lang.get("NumberOfWars") + " <");
        this.getMenuElem(19).setTextE(CFG.lang.get("NumberOfNeighbors") + " >=");
        this.getMenuElem(20).setTextE(CFG.lang.get("NumberOfNeighbors") + " <");
        this.getMenuElem(21).setTextE(CFG.lang.get("Population") + " >=");
        this.getMenuElem(22).setTextE(CFG.lang.get("Population") + " <");
        this.getMenuElem(23).setTextE(CFG.lang.get("Economy") + " >=");
        this.getMenuElem(24).setTextE(CFG.lang.get("Economy") + " <");
        this.getMenuElem(25).setTextE(CFG.lang.get("Relation") + " >=");
        this.getMenuElem(26).setTextE(CFG.lang.get("Relation") + " <");
        this.getMenuElem(27).setTextE(CFG.lang.get("IaAtWar"));
        this.getMenuElem(28).setTextE(CFG.lang.get("AtWar"));
        this.getMenuElem(29).setTextE(CFG.lang.get("Allies"));
        this.getMenuElem(30).setTextE(CFG.lang.get("NonAggressionPact"));
        this.getMenuElem(31).setTextE(CFG.lang.get("DefensivePact"));
        this.getMenuElem(32).setTextE(CFG.lang.get("GuaranteeIndependence"));
        this.getMenuElem(33).setTextE(CFG.lang.get("MilitaryAccess"));
        this.getMenuElem(34).setTextE(CFG.lang.get("IsAVassal"));
        this.getMenuElem(35).setTextE(CFG.lang.get("IsAVassalOfCiv"));
        this.getMenuElem(36).setTextE(CFG.lang.get("IsPartOfHRE"));
        this.getMenuElem(37).setTextE(CFG.lang.get("Government"));
        this.getMenuElem(38).setTextE(CFG.lang.get("TechnologyLevel") + " >=");
        this.getMenuElem(39).setTextE(CFG.lang.get("TechnologyLevel") + " <");
        this.getMenuElem(40).setTextE(CFG.lang.get("DevelopmentLevel") + " >=");
        this.getMenuElem(41).setTextE(CFG.lang.get("DevelopmentLevel") + " <");
        this.getMenuElem(42).setTextE(CFG.lang.get("Happiness") + " >=");
        this.getMenuElem(43).setTextE(CFG.lang.get("Happiness") + " <");
        this.getMenuElem(44).setTextE(CFG.lang.get("Treasury") + " >=");
        this.getMenuElem(45).setTextE(CFG.lang.get("Treasury") + " <");
        this.getMenuElem(46).setTextE(CFG.lang.get("CivIsControlledByAPlayer"));
        this.getMenuElem(47).setTextE(CFG.lang.get("IsWasteland"));
        this.getMenuElem(48).setTextE(CFG.lang.get("NeutralProvince"));
        this.getMenuElem(49).setTextE(CFG.lang.get("Fort"));
        this.getMenuElem(50).setTextE(CFG.lang.get("Port"));
        this.getMenuElem(51).setTextE(CFG.lang.get("WatchTower"));
        this.getMenuElem(52).setTextE(CFG.lang.get("Farm"));
        this.getMenuElem(53).setTextE(CFG.lang.get("Religion"));
        this.getMenuElem(54).setTextE(CFG.lang.get("Leader"));
        this.getMenuElem(55).setTextE(CFG.lang.get("AdministrationPolicy"));
        this.getMenuElem(56).setTextE(CFG.lang.get("AtomicBombs") + " >=");
        this.getMenuElem(57).setTextE(CFG.lang.get("AtomicBombs") + " <");
        this.getMenuElem(58).setTextE(CFG.lang.get("Investments") + " " + CFG.lang.get("Economy") + " >=");
        this.getMenuElem(59).setTextE(CFG.lang.get("Investments") + " " + CFG.lang.get("Economy") + " <");
        this.getMenuElem(60).setTextE(CFG.lang.get("TotalAssimilationCount") + " >=");
        this.getMenuElem(61).setTextE(CFG.lang.get("TotalAssimilationCount") + " <");
        this.getMenuElem(62).setTextE(CFG.lang.get("Festivals") + " >=");
        this.getMenuElem(63).setTextE(CFG.lang.get("Festivals") + " <");
        this.getMenuElem(64).setTextE(CFG.lang.get("Festivals") + " " + CFG.lang.get("TotalCost") + " >=");
        this.getMenuElem(65).setTextE(CFG.lang.get("Festivals") + " " + CFG.lang.get("TotalCost") + " <");
        this.getMenuElem(66).setTextE(CFG.lang.get("Investments") + " " + CFG.lang.get("Economy") + " " + CFG.lang.get("TotalCost") + " >=");
        this.getMenuElem(67).setTextE(CFG.lang.get("Investments") + " " + CFG.lang.get("Economy") + " " + CFG.lang.get("TotalCost") + " <");
        this.getMenuElem(68).setTextE(CFG.lang.get("DevelopmentInvestments") + " " + CFG.lang.get("TotalCost") + " >=");
        this.getMenuElem(69).setTextE(CFG.lang.get("DevelopmentInvestments") + " " + CFG.lang.get("TotalCost") + " <");
        this.getMenuElem(70).setTextE(CFG.lang.get("TotalEconomicIncrease") + " >=");
        this.getMenuElem(71).setTextE(CFG.lang.get("TotalEconomicIncrease") + " <");
        this.getMenuElem(72).setTextE(CFG.lang.get("TotalAssimilationCost") + " >=");
        this.getMenuElem(73).setTextE(CFG.lang.get("TotalAssimilationCost") + " <");
        this.getMenuElem(74).setTextE(CFG.lang.get("MilitaryExpertise") + " >=");
        this.getMenuElem(75).setTextE(CFG.lang.get("MilitaryExpertise") + " <");
        this.getMenuElem(76).setTextE(CFG.lang.get("DeathsInAllWars") + " >=");
        this.getMenuElem(77).setTextE(CFG.lang.get("DeathsInAllWars") + " <");
        this.getMenuElem(78).setTextE(CFG.lang.get("ConqueredProvinces") + " >=");
        this.getMenuElem(79).setTextE(CFG.lang.get("ConqueredProvinces") + " <");
        this.getMenuElem(80).setTextE(CFG.lang.get("BuildingConstructed") + " >=");
        this.getMenuElem(81).setTextE(CFG.lang.get("BuildingConstructed") + " <");
        this.getMenuElem(82).setTextE(CFG.lang.get("RecruitedArmy") + " >=");
        this.getMenuElem(83).setTextE(CFG.lang.get("RecruitedArmy") + " <");
        this.getMenuElem(84).setTextE(CFG.lang.get("Stability") + " >=");
        this.getMenuElem(85).setTextE(CFG.lang.get("Stability") + " <");
        this.getMenuElem(86).setTextE(CFG.lang.get("AverageDevelopment") + " >=");
        this.getMenuElem(87).setTextE(CFG.lang.get("AverageDevelopment") + " <");
        this.getMenuElem(88).setTextE(CFG.lang.get("Buildings") + " " + CFG.lang.get("Fort") + " >=");
        this.getMenuElem(89).setTextE(CFG.lang.get("Buildings") + " " + CFG.lang.get("WatchTowers") + " >=");
        this.getMenuElem(90).setTextE(CFG.lang.get("Buildings") + " " + CFG.lang.get("Ports") + " >=");
        this.getMenuElem(91).setTextE(CFG.lang.get("Buildings") + " " + CFG.lang.get("Farm") + " >=");
        this.getMenuElem(92).setTextE(CFG.lang.get("Buildings") + " " + CFG.lang.get("Workshop") + " >=");
        this.getMenuElem(93).setTextE(CFG.lang.get("Buildings") + " " + CFG.lang.get("Library") + " >=");
        this.getMenuElem(94).setTextE(CFG.lang.get("Buildings") + " " + CFG.lang.get("Armoury") + " >=");
        this.getMenuElem(95).setTextE(CFG.lang.get("Buildings") + " " + CFG.lang.get("SupplyCamp") + " >=");
        this.getMenuElem(96).setTextE(CFG.lang.get("Buildings") + " " + CFG.lang.get("Market") + " >=");
        try {
            for (int i = 1; i < this.getMenuElemsSize(); ++i) {
                this.getMenuElem(i).setTextE(i + ". " + this.getMenuElem(i).getTextE());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.getTitleM().setText(CFG.lang.get("AddNewCondition"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_EventChance());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 2: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_DecisionTaken());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 3: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_CivExist());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 4: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_ControlsProvinces());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 5: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_OccupyProvinces());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 6: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_HaveArmy());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 7: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_HaveCore());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 8: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_IsCapital());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 9: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_NumberOfProvinces());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 10: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_NumberOfProvinces_Low());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 11: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_NumOfUnits());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 12: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_NumOfUnits_Low());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 13: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_NumOfVassals());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 14: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_NumOfVassals_Low());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 15: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_NumOfAllies());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 16: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_NumOfAllies_Low());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 17: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_NumOfWars());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 18: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_NumOfWars_Low());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 19: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_NumOfNeighbors());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 20: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_NumOfNeighbors_Low());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 21: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Population());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 22: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Population_Low());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 23: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Economy());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 24: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Economy_Low());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 25: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Relation());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 26: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Relation_Low());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 27: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_IsAtWar());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 28: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_AtWar());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 29: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Allies());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 30: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_NonAggression());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 31: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_DefensivePact());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 32: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Independence());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 33: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_MilitaryAccess());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 34: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_IsAVassal());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 35: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_IsAVassalOfCiv());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 36: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_IsPartOfHRE());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 37: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Ideology());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 38: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Technology());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 39: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Technology_Low());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 40: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Development());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 41: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Development_Low());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 42: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Happiness());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 43: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Happiness_Low());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 44: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Treasury());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 45: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Treasury_Low());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 46: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_ControlledByPlayer());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 47: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Wasteland());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 48: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Neutral());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 49: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Fort());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 50: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Port());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 51: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_WatchTower());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 52: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Farm());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 53: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Religion());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 54: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Leader());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 55: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_AdmPolicy());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 56: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Nukes());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 57: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_NukesLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 58: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Investments());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 59: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_InvestmentsLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 60: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Assimilations());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 61: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_AssimilationsLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 62: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Festivals());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 63: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_FestivalsLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 64: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_FestivalsCost());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 65: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_FestivalsCostLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 66: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_InvestsEcoCost());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 67: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_InvestsEcoCostLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 68: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_InvestsDevCost());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 69: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_InvestsDevCostLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 70: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_InvestsEcoGained());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 71: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_InvestsEcoGainedLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 72: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_AssimilationsCost());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 73: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_AssimilationsCostLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 74: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_MilitaryExpertise());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 75: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_MilitaryExpertiseLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 76: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_WarCasu());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 77: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_WarCasuLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 78: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_ConquredProvs());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 79: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_ConquredProvsLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 80: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_BuildingsConstructed());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 81: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_BuildingsConstructedLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 82: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_RecruitedArmy());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 83: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_RecruitedArmyLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 84: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_Stability());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 85: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_StabilityLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 86: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_AveDev());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 87: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_AveDevLow());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 88: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_BForts());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 89: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_BTowers());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 90: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_BPorts());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 91: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_BFarms());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 92: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_BWorkshops());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 93: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_BLibraries());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 94: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_BArmories());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 95: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_BSupply());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 96: {
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.add(new Event_Conditions_BMarket());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.size() - 1;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_TRIGGER);
        CFG.menus.setBackAnimation(true);
    }
}

