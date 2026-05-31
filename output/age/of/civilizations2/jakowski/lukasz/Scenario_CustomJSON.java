package age.of.civilizations2.jakowski.lukasz;

import java.util.ArrayList;
import java.util.List;

public class Scenario_CustomJSON {
    public ScenarioInfo info;
    public Boolean useCustomProvinceData;
    public HREData hre = new HREData();
    public List<CivilizationData> civilizations = new ArrayList<CivilizationData>();
    public List<ProvinceData> unownedProvinces = new ArrayList<ProvinceData>();
    public List<Integer> wastelandProvinces = new ArrayList<Integer>();
    public List<AllianceData> alliances = new ArrayList<AllianceData>();
    public List<WarData> wars = new ArrayList<WarData>();

    public static class ScenarioInfo {
        public String name;
        public String author;
        public String mapPath;
        public String lastSavedFormat = "CUSTOM";
        public Integer year;
        public Integer month;
        public Integer day;
        public Long startingPopulation;
        public Long startingEconomy;
        public Long startingMoney;
        public Long startingArmyInCapitals;
        public Long neutralArmy;
        public Boolean useCustomProvinceData;
        public Float populationGrowthRate_Modifier;
        public Float economyGrowthRate_Modifier;
        public Float diseasesDeathRate_Modifier;
        public Boolean colonization;
        public Boolean colonizationNeutralProvinces;
        public Float colonizationTechLevel;
        public String activePalletTag;
        
        public Boolean isPartOfCampaign;
        public List<Integer> campaingCivsIDs = new ArrayList<Integer>();
    }

    public static class HREData {
        public String emperorTag;
        public List<Integer> provinceIDs = new ArrayList<Integer>();
        public List<String> electorTags = new ArrayList<String>();
        public List<String> memberTags = new ArrayList<String>();
    }

    public static class ProvinceData {
        public Integer id;
        public String name;
        public Long population;
        public Long economy;
        public Float development;
        public Boolean natural;
        public List<String> coreTags = new ArrayList<String>();
        public List<ArmyData> armies = new ArrayList<ArmyData>();

        
        public Integer fort;
        public Integer watchTower;
        public Integer port;
        public Integer farm;
        public Integer library;
        public Integer armoury;
        public Integer workshop;
        public Integer supply;
        public Integer market;
        public Integer airDefense;
    }

    public static class ArmyData {
        public String civTag;
        public Long count;
    }

    public static class CivilizationData {
        public String tag;
        public String name;
        public String description;
        public Integer capitalID;
        public String capitalName;
        public Float technologyLevel;
        public TechData technologyPoints;
        public Long gold;
        public Integer happiness;
        public String ideology;
        public Integer ideologyID;
        public String leaderName;
        public Integer religionID;
        public Integer groupID;
        public Boolean isPlayer;
        public Boolean autoset;
        public Long setpop;
        public Long seteco;
        public Integer missiles;
        
        public String puppetOf; 
        public List<RelationData> relations = new ArrayList<RelationData>();
        public List<RelationData> nonAggressionPacts = new ArrayList<RelationData>();
        public List<RelationData> defensivePacts = new ArrayList<RelationData>();
        public List<RelationData> militaryAccess = new ArrayList<RelationData>();
        public List<RelationData> guarantees = new ArrayList<RelationData>();
        public List<RelationData> truces = new ArrayList<RelationData>();

        public List<TechByContinentData> techByContinents = new ArrayList<TechByContinentData>();
        public List<ProvinceData> provinces = new ArrayList<ProvinceData>();
    }

    public static class TechByContinentData {
        public Integer continentID;
        public Integer percentage;
    }

    public static class TechData {
        public Integer popGrowth;
        public Integer economyGrowth;
        public Integer taxation;
        public Integer production;
        public Integer administration;
        public Integer militaryUpkeep;
        public Integer research;
        public Integer colonization;
        public Integer movement;
        public Integer assimilate;
        public Integer recruitable;
    }

    public static class RelationData {
        public String targetTag;
        public Integer value;
    }

    public static class AllianceData {
        public String name;
        public List<String> members = new ArrayList<String>();
    }

    public static class WarData {
        public List<String> aggressors = new ArrayList<String>();
        public List<String> defenders = new ArrayList<String>();
        public Integer warTurnID;
        public Boolean wasAnyAttack;
    }

    public static class CivilizationAIPopEco {
        public String tag;
        public String name;
        public Boolean autoset;
        public Long setpop;
        public Long seteco;
    }
}
