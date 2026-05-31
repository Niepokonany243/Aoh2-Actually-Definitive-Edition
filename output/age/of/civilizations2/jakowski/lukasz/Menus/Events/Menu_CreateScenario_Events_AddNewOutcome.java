/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Events;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_AddArmy;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_AddCore;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_AdmPolicy;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_BuildBuilding;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_ChangeIdeology;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_ChangeLeader;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_ChangeOwner;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_CreateVassal;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_DeclareWar;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_DefensivePact;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_DevLevel;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_DiplomacyPoints;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_Exp;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_FestivalAll;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_FightCoalition;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_FormCivilization;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_GlobalArmyPerc;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_GlobalDevelopmentPerc;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_GlobalEconomyPerc;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_GlobalHappinessPerc;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_GlobalPopulationPerc;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_GoldenAgeMilitary;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_GoldenAgeProsp;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_GoldenAgeScience;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_ImposeSanctions;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_IncreaseRelation;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_Independence;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_JoinAlliance;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_JoinUnion;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_LeaveAlliance;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_LiberateVassal;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_MilitaryAccess;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_MilitaryAttack;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_MilitaryDefense;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_MilitaryExpertise;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_Money;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_MoveCapital;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_MovementPoints;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_NonAggression;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_NukesProvinces;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_Occupy;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_PlayerCiv;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_ProvokeRebels;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_RandArmoury;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_RandFarms;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_RandFestivals;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_RandFort;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_RandLibrary;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_RandMarkets;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_RandSupply;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_RandTowers;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_RandWorkshop;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_RemoveArmyX;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_RemoveCore;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_RenameCiv;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_RenameProv;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_TechLevel;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_TriggerAnotherEvent;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_UpdateEconomy;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_UpdateEconomyOfCiv;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_UpdateEconomyPerc;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_UpdateHappiness;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_UpdateHappinessOfCiv;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_UpdatePopulation;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_UpdatePopulationOfCiv;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_UpdatePopulationPerc;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_Wasteland;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome_WhitePeace;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios.Event_Outcome_AssimilateAll;
import age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios.Event_Outcome_BuildingDestroy;
import age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios.Event_Outcome_ChangeReligion;
import age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios.Event_Outcome_NukesChange;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_AddNewOutcome
extends Menu {
    public Menu_CreateScenario_Events_AddNewOutcome() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        for (int i = 1; i < 73; ++i) {
            menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("TriggerAnotherEvent"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Annexation"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Occupy"));
        this.getMenuElem(4).setTextE(CFG.lang.get("AddCore"));
        this.getMenuElem(5).setTextE(CFG.lang.get("RemoveCore"));
        this.getMenuElem(6).setTextE(CFG.lang.get("DeclareWar"));
        this.getMenuElem(7).setTextE(CFG.lang.get("WhitePeace") + " " + CFG.lang.get("OR") + " -> " + CFG.lang.get("AllCivilizations") + ": " + CFG.lang.get("AtWar") + " -> " + CFG.lang.get("WhitePeace"));
        this.getMenuElem(8).setTextE(CFG.lang.get("UpdateRelation"));
        this.getMenuElem(9).setTextE(CFG.lang.get("AddCivilization") + " | " + CFG.lang.get("OR") + " | " + CFG.lang.get("CreateAVassal") + " - " + CFG.lang.get("OutComeAddCiv"));
        this.getMenuElem(10).setTextE(CFG.lang.get("LiberateAVassal"));
        this.getMenuElem(11).setTextE(CFG.lang.get("JoinAlliance"));
        this.getMenuElem(12).setTextE(CFG.lang.get("LeaveAlliance"));
        this.getMenuElem(13).setTextE(CFG.lang.get("CreateUnion"));
        this.getMenuElem(14).setTextE(CFG.lang.get("FormCivilization"));
        this.getMenuElem(15).setTextE(CFG.lang.get("NonAggressionPact"));
        this.getMenuElem(16).setTextE(CFG.lang.get("DefensivePact"));
        this.getMenuElem(17).setTextE(CFG.lang.get("GuaranteeIndependence"));
        this.getMenuElem(18).setTextE(CFG.lang.get("MilitaryAccess"));
        this.getMenuElem(19).setTextE(CFG.lang.get("MoveCapital"));
        this.getMenuElem(20).setTextE(CFG.lang.get("ChangeIdeology"));
        this.getMenuElem(21).setTextE(CFG.lang.get("AddArmy"));
        this.getMenuElem(22).setTextE(CFG.lang.get("UpdatePopulation"));
        this.getMenuElem(23).setTextE(CFG.lang.get("UpdatePopulationPercentage"));
        this.getMenuElem(24).setTextE(CFG.lang.get("UpdatePopulationOfCiv") + ": +" + CFG.lang.get("GlobalEvent"));
        this.getMenuElem(25).setTextE(CFG.lang.get("UpdateEconomy"));
        this.getMenuElem(26).setTextE(CFG.lang.get("UpdateEconomyPercentage"));
        this.getMenuElem(27).setTextE(CFG.lang.get("UpdateEconomyOfCiv") + ": +" + CFG.lang.get("GlobalEvent"));
        this.getMenuElem(28).setTextE(CFG.lang.get("UpdateTechnologyLevel") + ": +" + CFG.lang.get("GlobalEvent"));
        this.getMenuElem(29).setTextE(CFG.lang.get("UpdateDevelopmentLevel"));
        this.getMenuElem(30).setTextE(CFG.lang.get("UpdateHappiness"));
        this.getMenuElem(31).setTextE(CFG.lang.get("UpdateHappinessOfCivilization") + ": +" + CFG.lang.get("GlobalEvent"));
        this.getMenuElem(32).setTextE(CFG.lang.get("UpdateMoney") + ": +" + CFG.lang.get("GlobalEvent"));
        this.getMenuElem(33).setTextE(CFG.lang.get("UpdateMovementPoints"));
        this.getMenuElem(34).setTextE(CFG.lang.get("UpdateDiplomacyPoints"));
        this.getMenuElem(35).setTextE(CFG.lang.get("UpdateWastelandProvinces"));
        this.getMenuElem(36).setTextE(CFG.lang.get("ChangeLeader"));
        this.getMenuElem(37).setTextE(CFG.lang.get("ChangeReligion"));
        this.getMenuElem(38).setTextE(CFG.lang.get("FightTheCoalition"));
        this.getMenuElem(39).setTextE(CFG.lang.get("ConstructNewBuilding"));
        this.getMenuElem(40).setTextE(CFG.lang.get("DestroyBuilding"));
        this.getMenuElem(41).setTextE(CFG.lang.get("AtomicBombs"));
        this.getMenuElem(42).setTextE(CFG.lang.get("AtomicBombing") + ": " + CFG.lang.get("SelectProvinces"));
        this.getMenuElem(43).setTextE(CFG.lang.get("ProvokeRebels"));
        this.getMenuElem(44).setTextE(CFG.lang.get("ImposeSanctions"));
        this.getMenuElem(45).setTextE(CFG.lang.get("AdministrationPolicy"));
        this.getMenuElem(46).setTextE(CFG.lang.get("Festival") + ": " + CFG.lang.get("AllProvinces"));
        this.getMenuElem(47).setTextE(CFG.lang.get("Assimilate") + ": " + CFG.lang.get("AllProvinces"));
        this.getMenuElem(48).setTextE(CFG.lang.get("MilitaryExpertise"));
        this.getMenuElem(49).setTextE(CFG.lang.get("MilitaryExpertise") + ", " + CFG.lang.get("Attack"));
        this.getMenuElem(50).setTextE(CFG.lang.get("MilitaryExpertise") + ", " + CFG.lang.get("Defense"));
        this.getMenuElem(51).setTextE(CFG.lang.get("GoldenAge") + ": " + CFG.lang.get("GAProsperity"));
        this.getMenuElem(52).setTextE(CFG.lang.get("GoldenAge") + ": " + CFG.lang.get("GAMilitary"));
        this.getMenuElem(53).setTextE(CFG.lang.get("GoldenAge") + ": " + CFG.lang.get("GAScience"));
        this.getMenuElem(54).setTextE(CFG.lang.get("Build") + " " + CFG.lang.get("OR") + " " + CFG.lang.get("Destroy") + ": " + CFG.lang.get("Farm"));
        this.getMenuElem(55).setTextE(CFG.lang.get("Build") + " " + CFG.lang.get("OR") + " " + CFG.lang.get("Destroy") + ": " + CFG.lang.get("Fort"));
        this.getMenuElem(56).setTextE(CFG.lang.get("Build") + " " + CFG.lang.get("OR") + " " + CFG.lang.get("Destroy") + ": " + CFG.lang.get("WatchTower"));
        this.getMenuElem(57).setTextE(CFG.lang.get("Build") + " " + CFG.lang.get("OR") + " " + CFG.lang.get("Destroy") + ": " + CFG.lang.get("Workshop"));
        this.getMenuElem(58).setTextE(CFG.lang.get("Build") + " " + CFG.lang.get("OR") + " " + CFG.lang.get("Destroy") + ": " + CFG.lang.get("Market"));
        this.getMenuElem(59).setTextE(CFG.lang.get("Build") + " " + CFG.lang.get("OR") + " " + CFG.lang.get("Destroy") + ": " + CFG.lang.get("Library"));
        this.getMenuElem(60).setTextE(CFG.lang.get("Build") + " " + CFG.lang.get("OR") + " " + CFG.lang.get("Destroy") + ": " + CFG.lang.get("Armoury"));
        this.getMenuElem(61).setTextE(CFG.lang.get("Build") + " " + CFG.lang.get("OR") + " " + CFG.lang.get("Destroy") + ": " + CFG.lang.get("SupplyCamp"));
        this.getMenuElem(62).setTextE(CFG.lang.get("Festivals") + ": " + CFG.lang.get("Random") + " " + CFG.lang.get("Provinces"));
        this.getMenuElem(63).setTextE(CFG.lang.get("CivilizationName"));
        this.getMenuElem(64).setTextE(CFG.lang.get("ProvinceName"));
        this.getMenuElem(65).setTextE(CFG.lang.get("Update") + ", " + CFG.lang.get("Army") + ": X%");
        this.getMenuElem(66).setTextE(CFG.lang.get("GlobalEvent") + ": " + CFG.lang.get("UpdateEconomyPercentage") + ": X% - " + CFG.lang.get("AllCivilizations"));
        this.getMenuElem(67).setTextE(CFG.lang.get("GlobalEvent") + ": " + CFG.lang.get("PopulationChange") + ": X% - " + CFG.lang.get("AllCivilizations"));
        this.getMenuElem(68).setTextE(CFG.lang.get("GlobalEvent") + ": " + CFG.lang.get("Development") + ": X% - " + CFG.lang.get("AllCivilizations"));
        this.getMenuElem(69).setTextE(CFG.lang.get("GlobalEvent") + ": " + CFG.lang.get("Happiness") + ": X% - " + CFG.lang.get("AllCivilizations"));
        this.getMenuElem(70).setTextE(CFG.lang.get("GlobalEvent") + ": " + CFG.lang.get("Army") + ": X% - " + CFG.lang.get("AllCivilizations"));
        this.getMenuElem(71).setTextE(CFG.lang.get("Player") + ", " + CFG.lang.get("Civilization") + ": -> X");
        this.getMenuElem(72).setTextE(CFG.lang.get("RevolutionaryMovements") + ", " + CFG.lang.get("Civilization") + ": -> " + CFG.lang.get("Explode"));
        try {
            for (int i = 1; i < this.getMenuElemsSize(); ++i) {
                this.getMenuElem(i).setTextE(i + ". " + this.getMenuElem(i).getTextE());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.getTitleM().setText(CFG.lang.get("AddNewOutcome"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_TriggerAnotherEvent());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 2: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_ChangeOwner());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 3: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_Occupy());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 4: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_AddCore());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 5: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_RemoveCore());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 6: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_DeclareWar());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 7: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_WhitePeace());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 8: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_IncreaseRelation());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 9: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_CreateVassal());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 10: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_LiberateVassal());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 11: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_JoinAlliance());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 12: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_LeaveAlliance());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 13: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_JoinUnion());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 14: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_FormCivilization());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 15: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_NonAggression());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 16: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_DefensivePact());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 17: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_Independence());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 18: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_MilitaryAccess());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 19: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_MoveCapital());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 20: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_ChangeIdeology());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 21: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_AddArmy());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 22: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_UpdatePopulation());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 23: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_UpdatePopulationPerc());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 24: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_UpdatePopulationOfCiv());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 25: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_UpdateEconomy());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 26: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_UpdateEconomyPerc());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 27: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_UpdateEconomyOfCiv());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 28: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_TechLevel());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 29: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_DevLevel());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 30: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_UpdateHappiness());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 31: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_UpdateHappinessOfCiv());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 32: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_Money());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 33: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_MovementPoints());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 34: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_DiplomacyPoints());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 35: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_Wasteland());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 36: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_ChangeLeader());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 37: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_ChangeReligion());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 38: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_FightCoalition());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 39: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_BuildBuilding());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 40: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_BuildingDestroy());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 41: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_NukesChange());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 42: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_NukesProvinces());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 43: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_ProvokeRebels());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 44: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_ImposeSanctions());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 45: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_AdmPolicy());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 46: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_FestivalAll());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 47: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_AssimilateAll());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 48: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_MilitaryExpertise());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 49: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_MilitaryAttack());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 50: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_MilitaryDefense());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 51: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_GoldenAgeProsp());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 52: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_GoldenAgeMilitary());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 53: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_GoldenAgeScience());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 54: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_RandFarms());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 55: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_RandFort());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 56: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_RandTowers());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 57: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_RandWorkshop());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 58: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_RandMarkets());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 59: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_RandLibrary());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 60: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_RandArmoury());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 61: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_RandSupply());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 62: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_RandFestivals());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 63: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_RenameCiv());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 64: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_RenameProv());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 65: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_RemoveArmyX());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 66: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_GlobalEconomyPerc());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 67: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_GlobalPopulationPerc());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 68: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_GlobalDevelopmentPerc());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 69: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_GlobalHappinessPerc());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 70: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_GlobalArmyPerc());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 71: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_PlayerCiv());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
                break;
            }
            case 72: {
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.add(new Event_Outcome_Exp());
                CFG.eventsManager.createEvent_EditConditionID = CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size() - 1;
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_DECISION);
        CFG.menus.setBackAnimation(true);
    }
}

