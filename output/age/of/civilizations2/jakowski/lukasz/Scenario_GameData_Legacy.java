package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Scenario_GameData_Technology;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Legacy version of Scenario_GameData used for loading old binary files.
 */
public class Scenario_GameData_Legacy
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<String> lCivsTags;
    public List<Integer> lCivsCapitals;
    public List<Float> lTechnologyLevels;
    public List<List<Scenario_GameData_Technology>> lTechnologyByContinents;
    public List<Integer> lHappiness;
    public List<Integer> lStartingMoney;
    public transient List<Integer> lTargetPopulation = new ArrayList<Integer>();
    public transient List<Integer> lTargetEconomy = new ArrayList<Integer>();
    public int iStartingArmyInCapitals = 500;
    public int iNeutralArmy = 500;
    public int iStartingPopulation = 500;
    public int iStartingEconomy = 500;
    public int iStartingMoney = 1;
    public float iPopulationGrowthRate_Modifier = 0.0f;
    public float iEconomyGrowthRate_Modifier = 0.0f;
    public float iDiseasesDeathRate_Modifier = 0.0f;
    public boolean COLONIZATION = true;
    public boolean ENABLE_COLONIZATION_NEUTRAL_PROVINCES = false;
    public float COLONIZATION_TECH_LEVEL = 0.8f;
    public String ACTIVE_PALLET_OF_COLORS_TAG = null;
    public boolean isPartOfCampaign = false;
    public List<Integer> lCampaingCivsIDs = new ArrayList<Integer>();

    public Scenario_GameData convertToNew() {
        Scenario_GameData newData = new Scenario_GameData();
        newData.lCivsTags = this.lCivsTags;
        newData.lCivsCapitals = this.lCivsCapitals;
        newData.lTechnologyLevels = this.lTechnologyLevels;
        newData.lTechnologyByContinents = this.lTechnologyByContinents;
        newData.lHappiness = this.lHappiness;
        
        newData.lStartingMoney = new ArrayList<Long>();
        if (this.lStartingMoney != null) {
            for (Integer val : this.lStartingMoney) newData.lStartingMoney.add(val.longValue());
        }
        
        newData.lTargetPopulation = new ArrayList<Long>();
        if (this.lTargetPopulation != null) {
            for (Integer val : this.lTargetPopulation) newData.lTargetPopulation.add(val.longValue());
        }

        newData.lTargetEconomy = new ArrayList<Long>();
        if (this.lTargetEconomy != null) {
            for (Integer val : this.lTargetEconomy) newData.lTargetEconomy.add(val.longValue());
        }

        newData.iStartingArmyInCapitals = (long)this.iStartingArmyInCapitals;
        newData.iNeutralArmy = (long)this.iNeutralArmy;
        newData.iStartingPopulation = (long)this.iStartingPopulation;
        newData.iStartingEconomy = (long)this.iStartingEconomy;
        newData.iStartingMoney = (long)this.iStartingMoney;
        
        newData.iPopulationGrowthRate_Modifier = this.iPopulationGrowthRate_Modifier;
        newData.iEconomyGrowthRate_Modifier = this.iEconomyGrowthRate_Modifier;
        newData.iDiseasesDeathRate_Modifier = this.iDiseasesDeathRate_Modifier;
        newData.COLONIZATION = this.COLONIZATION;
        newData.ENABLE_COLONIZATION_NEUTRAL_PROVINCES = this.ENABLE_COLONIZATION_NEUTRAL_PROVINCES;
        newData.COLONIZATION_TECH_LEVEL = this.COLONIZATION_TECH_LEVEL;
        newData.ACTIVE_PALLET_OF_COLORS_TAG = this.ACTIVE_PALLET_OF_COLORS_TAG;
        newData.isPartOfCampaign = this.isPartOfCampaign;
        newData.lCampaingCivsIDs = this.lCampaingCivsIDs;
        
        return newData;
    }
}
