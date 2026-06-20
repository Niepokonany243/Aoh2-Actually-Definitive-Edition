
package age.of.civilizations2.jakowski.lukasz.Save.SaveGameData;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.VictoryManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Save_GameData_1
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iTurnID;
    public int TURNS_SINCE_LAST_WAR;
    public int iDay;
    public int iMonth;
    public int iYear;
    public int DIFFICULTY;
    public float GAME_SPEED;
    public int FOG_OF_WAR;
    public boolean SPECTATOR_MODE;
    public boolean AGE_OF_CHAOS_MODE;
    public boolean USE_NEW_DECLARE_WAR_SYSTEM;
    public int USE_OLD_DECLARE_WAR_CHANGE_100;
    public boolean ENABLE_NUKES;
    public long MIN_ARMY_REQUIRED_TO_ATTACK;
    public float REBELS_POWER;
    public boolean SANDBOX_MODE;
    public boolean SANDBOX_MODE_AI;
    public boolean LEADERS_CAN_DIE;
    public int MAX_PROVINCES_FOR_ALLIANCE_PROPOSAL;
    public int PROPOSE_ALLIANCE_CHANCE_100;
    public float ARMY_RETREAT;
    public float CAPITULATION;
    public boolean NUKES_MIN_YEAR_ENABLED;
    public boolean AI_UNIONS_ENABLED;
    public boolean AI_CONQUER_VASSALS;
    public boolean AI_VASSALS_CAN_DECLARE_WARS;
    public int AI_CONQUER_OWN_VASSALS_IF_OVER;
    public float POPULATION_GROWTH_RATE;
    public float ECONOMY_GROWTH_RATE;
    public int MOVEMENT_POINTS_EXTRA;
    public float MOVEMENT_POINTS_MAX_MODIFIER;
    public int DIPLOMACY_POINTS_EXTRA;
    public boolean AI_PLUNDER_ENABLED;
    public float PLUNDER_CHANCE = 0.0f;
    public float GENOCIDE_CHANCE = 0.0f;
    public boolean AI_GENOCIDE_ENABLED = true;
    public boolean REBELS_GENOCIDE_ENABLED = false;
    public boolean TOTAL_WARMODE = false;
    public float BAT_PLUS_BREAKTHROUGH_RATIO_GAME = 0.0f;
    public boolean MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI = false;
    public boolean RECRUIT_AND_COUNTERATTACK = false;
    public boolean SPECTATOR_MODE_LOCK_CIV = false;
    public int WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS;
    public float PEACE_TREATY_VICTORY_POINTS_MODIFIER;
    public float ASSIMILATION_SPEED_MODIFIER;
    public boolean VASSALS_CAN_DECLARE_INDEPENDENCE;
    public float ASSIMILATION_COST;
    public int COLONIZATION_AUTO_EXPAND_CHANCE;
    public int GET_SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_CHANCE_1000;
    public long BUILD_NUKES_EXTRA_COST = 0L;
    public float NUKES_REQUIRED_TECH_LVL = 0.0f;
    public float PLUNDER_MODIFIER = 1.0f;
    public int TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE;
    public int TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK;
    public boolean ENABLE_COLONIZATION;
    public boolean ENABLE_COLONIZATION_NEUTRAL_PROVINCES = false;
    public float COLONIZATION_TECH_LEVEL = 0.8f;
    public long STARTING_POPULATION;
    public long STARTING_ECONOMY;
    public float POPULATION_GROWTH_RATE_MODIFIER;
    public float ECONOMY_GROWTH_RATE_MODIFIER;
    public float DISEASES_DEATH_RATE_MODIFIER;
    public int VICTORY_CONTROL_PROVINCES_PERC;
    public int VICTORY_LIMIT_OF_TURNS;
    public float VICTORY_TECHNOLOGY;
    public String sActiveScenarioTag = "";
    public List<Integer> provinceNamesChangedID = new ArrayList<Integer>();
    public List<String> provinceNamesChanged = new ArrayList<String>();
    public List<Integer> civNamesChangedID = new ArrayList<Integer>();
    public List<String> civNamesChanged = new ArrayList<String>();
    public long AGE_OF_CHAOS_TURNS;

    public final void buildData() {
        this.iTurnID = GameCalendar.TURNID;
        this.TURNS_SINCE_LAST_WAR = GameCalendar.TURNS_SINCE_LAST_WAR;
        this.iDay = GameCalendar.currDay;
        this.iMonth = GameCalendar.currMonth;
        this.iYear = GameCalendar.currYear;
        this.GAME_SPEED = GameCalendar.GAME_SPEED;
        this.SANDBOX_MODE = CFG.SANDBOX_MODE;
        this.ENABLE_COLONIZATION = GameCalendar.ENABLE_COLONIZATION;
        this.ENABLE_COLONIZATION_NEUTRAL_PROVINCES = GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES;
        this.COLONIZATION_TECH_LEVEL = GameCalendar.COLONIZATION_TECH_LEVEL;
        this.STARTING_POPULATION = CFG.core.getGameScenars().getScenario_StartingPopulation();
        this.STARTING_ECONOMY = CFG.core.getGameScenars().getScenario_StartingEconomy();
        this.POPULATION_GROWTH_RATE_MODIFIER = CFG.core.getGameScenars().getScenario_PopulationGrowthRate_Modifier();
        this.ECONOMY_GROWTH_RATE_MODIFIER = CFG.core.getGameScenars().getScenario_EconomyGrowthRate_Modifier();
        this.DISEASES_DEATH_RATE_MODIFIER = CFG.core.getGameScenars().getScenario_DiseasesDeathRate_Modifier();
        this.VICTORY_CONTROL_PROVINCES_PERC = VictoryManager.VICTORY_CONTROL_PROVINCES_PERC;
        this.VICTORY_LIMIT_OF_TURNS = VictoryManager.VICTORY_LIMIT_OF_TURNS;
        this.VICTORY_TECHNOLOGY = VictoryManager.VICTORY_TECHNOLOGY;
        this.FOG_OF_WAR = CFG.FOG_OF_WAR;
        this.SPECTATOR_MODE = CFG.SPECTATOR_MODE;
        this.AGE_OF_CHAOS_MODE = CFG.AGE_OF_CHAOS_MODE;
        this.AGE_OF_CHAOS_TURNS = CFG.AGE_OF_CHAOS_TURNS;
        this.LEADERS_CAN_DIE = CFG.LEADERS_CAN_DIE;
        this.ENABLE_NUKES = CFG.ENABLE_NUKES;
        this.MIN_ARMY_REQUIRED_TO_ATTACK = CFG.MIN_ARMY_REQUIRED_TO_ATTACK;
        this.USE_NEW_DECLARE_WAR_SYSTEM = CFG.USE_NEW_DECLARE_WAR_SYSTEM;
        this.USE_OLD_DECLARE_WAR_CHANGE_100 = CFG.USE_OLD_DECLARE_WAR_CHANGE_100;
        this.REBELS_POWER = CFG.REBELS_POWER;
        this.MAX_PROVINCES_FOR_ALLIANCE_PROPOSAL = CFG.MAX_PROVINCES_FOR_ALLIANCE_PROPOSAL;
        this.PROPOSE_ALLIANCE_CHANCE_100 = CFG.PROPOSE_ALLIANCE_CHANCE_100;
        this.ARMY_RETREAT = CFG.ARMY_RETREAT;
        this.CAPITULATION = CFG.CAPITULATION;
        this.COLONIZATION_AUTO_EXPAND_CHANCE = CFG.COLONIZATION_AUTO_EXPAND_CHANCE;
        this.NUKES_MIN_YEAR_ENABLED = CFG.NUKES_MIN_YEAR_ENABLED;
        this.VASSALS_CAN_DECLARE_INDEPENDENCE = CFG.VASSALS_CAN_DECLARE_INDEPENDENCE;
        this.ASSIMILATION_COST = CFG.ASSIMILATION_COST_MODIFIER;
        this.ASSIMILATION_SPEED_MODIFIER = CFG.ASSIMILATION_SPEED_MODIFIER;
        this.MOVEMENT_POINTS_EXTRA = CFG.MOVEMENT_POINTS_EXTRA;
        this.MOVEMENT_POINTS_MAX_MODIFIER = CFG.MOVEMENT_POINTS_MAX_MODIFIER;
        this.DIPLOMACY_POINTS_EXTRA = CFG.DIPLOMACY_POINTS_EXTRA;
        this.POPULATION_GROWTH_RATE = CFG.POPULATION_GROWTH_RATE;
        this.ECONOMY_GROWTH_RATE = CFG.ECONOMY_GROWTH_RATE;
        this.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE = CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE;
        this.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK = CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK;
        this.AI_UNIONS_ENABLED = CFG.AI_UNIONS_ENABLED;
        this.AI_CONQUER_VASSALS = CFG.AI_CONQUER_VASSALS;
        this.AI_VASSALS_CAN_DECLARE_WARS = CFG.AI_VASSALS_CAN_DECLARE_WARS;
        this.AI_CONQUER_OWN_VASSALS_IF_OVER = CFG.AI_CONQUER_OWN_VASSALS_IF_OVER;
        this.BUILD_NUKES_EXTRA_COST = CFG.BUILD_NUKES_EXTRA_COST;
        this.NUKES_REQUIRED_TECH_LVL = CFG.NUKES_REQUIRED_TECH_LVL;
        this.PLUNDER_MODIFIER = CFG.PLUNDER_MODIFIER;
        this.AI_PLUNDER_ENABLED = CFG.AI_PLUNDER_ENABLED;
        this.PLUNDER_CHANCE = CFG.PLUNDER_CHANCE;
        this.GENOCIDE_CHANCE = CFG.GENOCIDE_CHANCE;
        this.AI_GENOCIDE_ENABLED = CFG.AI_GENOCIDE_ENABLED;
        this.REBELS_GENOCIDE_ENABLED = CFG.REBELS_GENOCIDE_ENABLED;
        this.TOTAL_WARMODE = CFG.TOTAL_WARMODE;
        this.BAT_PLUS_BREAKTHROUGH_RATIO_GAME = CFG.BAT_PLUS_BREAKTHROUGH_RATIO_GAME;
        this.MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI = CFG.MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI;
        this.RECRUIT_AND_COUNTERATTACK = CFG.RECRUIT_AND_COUNTERATTACK;
        this.SPECTATOR_MODE_LOCK_CIV = CFG.SPECTATOR_MODE_LOCK_CIV;
        this.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS = CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS;
        this.PEACE_TREATY_VICTORY_POINTS_MODIFIER = CFG.PEACE_TREATY_VICTORY_POINTS_MODIFIER;
        this.GET_SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_CHANCE_1000 = CFG.GET_SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_CHANCE_1000;
        this.SANDBOX_MODE_AI = CFG.SANDBOX_MODE_AI;
        this.DIFFICULTY = CFG.DIFFICULTY;
        if (this.sActiveScenarioTag.length() <= 0) {
            block10: {
                if (CFG.core.getGameScenars().sActiveScenarioTag.length() <= 0) {
                    try {
                        CFG.core.getGameScenars().sActiveScenarioTag = CFG.core.getGameScenars().getScenarioTagID(CFG.core.getScenarioID());
                    }
                    catch (IndexOutOfBoundsException ex) {
                        if (!CFG.LOGs) break block10;
                        CFG.exceptionStack(ex);
                    }
                }
            }
            this.sActiveScenarioTag = CFG.core.getGameScenars().sActiveScenarioTag;
        }
        try {
            if (GameValues.gvInGame.SAVE_CHANGED_PROVINCE_NAMES) {
                for (int i = 0; i < CFG.pNCI.size(); ++i) {
                    if (CFG.pNCI.get(i) >= CFG.core.getProvinSize()) continue;
                    this.provinceNamesChangedID.add(CFG.pNCI.get(i));
                    this.provinceNamesChanged.add(CFG.pNC.get(i));
                }
            }
            if (GameValues.gvInGame.SAVE_CHANGED_CIV_NAMES) {
                for (int i = 0; i < CFG.cNCI.size(); ++i) {
                    if (CFG.cNCI.get(i) >= CFG.core.getCivsSize()) continue;
                    this.civNamesChangedID.add(CFG.cNCI.get(i));
                    this.civNamesChanged.add(CFG.cNC.get(i));
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }
}

