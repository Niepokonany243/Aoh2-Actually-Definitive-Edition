/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Scenario_GameData_Technology;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Scenario_GameData
implements Serializable {
    public Scenario_GameData() {
        this.buildData();
    }
    private static final long serialVersionUID = 0L;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();
        this.lCivsTags = (List<String>)fields.get("lCivsTags", null);
        this.lCivsCapitals = (List<Integer>)fields.get("lCivsCapitals", null);
        this.lTechnologyLevels = (List<Float>)fields.get("lTechnologyLevels", null);
        this.lTechnologyByContinents = (List<List<Scenario_GameData_Technology>>)fields.get("lTechnologyByContinents", null);
        this.lHappiness = (List<Integer>)fields.get("lHappiness", null);
        this.lStartingMoney = (List<Long>)fields.get("lStartingMoney", null);
        this.lTargetPopulation = (List<Long>)fields.get("lTargetPopulation", new ArrayList<Long>());
        this.lTargetEconomy = (List<Long>)fields.get("lTargetEconomy", new ArrayList<Long>());
        this.iStartingArmyInCapitals = fields.get("iStartingArmyInCapitals", 500L);
        this.iNeutralArmy = fields.get("iNeutralArmy", 500L);
        this.iStartingPopulation = fields.get("iStartingPopulation", 500L);
        this.iStartingEconomy = fields.get("iStartingEconomy", 500L);
        this.iStartingMoney = fields.get("iStartingMoney", 1L);
        this.iPopulationGrowthRate_Modifier = fields.get("iPopulationGrowthRate_Modifier", 0.0f);
        this.iEconomyGrowthRate_Modifier = fields.get("iEconomyGrowthRate_Modifier", 0.0f);
        this.iDiseasesDeathRate_Modifier = fields.get("iDiseasesDeathRate_Modifier", 0.0f);
        this.COLONIZATION = fields.get("COLONIZATION", true);
        this.ENABLE_COLONIZATION_NEUTRAL_PROVINCES = fields.get("ENABLE_COLONIZATION_NEUTRAL_PROVINCES", false);
        this.COLONIZATION_TECH_LEVEL = fields.get("COLONIZATION_TECH_LEVEL", 0.8f);
        this.ACTIVE_PALLET_OF_COLORS_TAG = (String)fields.get("ACTIVE_PALLET_OF_COLORS_TAG", null);
        this.isPartOfCampaign = fields.get("isPartOfCampaign", false);
        this.lCampaingCivsIDs = (List<Integer>)fields.get("lCampaingCivsIDs", new ArrayList<Integer>());
    }
    public List<String> lCivsTags;
    public List<Integer> lCivsCapitals;
    public List<Float> lTechnologyLevels;
    public List<List<Scenario_GameData_Technology>> lTechnologyByContinents;
    public List<Integer> lHappiness;
    public List<Long> lStartingMoney;
    public List<Long> lTargetPopulation = new ArrayList<Long>();
    public List<Long> lTargetEconomy = new ArrayList<Long>();
    public long iStartingArmyInCapitals = 500L;
    public long iNeutralArmy = 500L;
    public long iStartingPopulation = 500L;
    public long iStartingEconomy = 500L;
    public long iStartingMoney = 1L;
    public float iPopulationGrowthRate_Modifier = 0.0f;
    public float iEconomyGrowthRate_Modifier = 0.0f;
    public float iDiseasesDeathRate_Modifier = 0.0f;
    public boolean COLONIZATION = true;
    public boolean ENABLE_COLONIZATION_NEUTRAL_PROVINCES = false;
    public float COLONIZATION_TECH_LEVEL = 0.8f;
    public String ACTIVE_PALLET_OF_COLORS_TAG = null;
    public boolean isPartOfCampaign = false;
    public List<Integer> lCampaingCivsIDs = new ArrayList<Integer>();

    public final void buildData() {
        this.lCivsTags = new ArrayList<String>();
        this.lCivsCapitals = new ArrayList<Integer>();
        this.lTechnologyLevels = new ArrayList<Float>();
        this.lTechnologyByContinents = new ArrayList<List<Scenario_GameData_Technology>>();
        this.lHappiness = new ArrayList<Integer>();
        this.lStartingMoney = new ArrayList<Long>();
    }

    public final int getCivSize() {
        return this.lCivsTags.size();
    }

    public final String getCivTag(int i) {
        return this.lCivsTags.get(i);
    }

    public final int getCivCapital(int i) {
        return this.lCivsCapitals.get(i);
    }

    public final float getTechnologyLevel(int i) {
        return this.lTechnologyLevels.get(i).floatValue();
    }

    public final int getHappiness(int i) {
        return this.lHappiness.get(i);
    }

    public final long getStartingMoneyCiv(int i) {
        return this.lStartingMoney.get(i);
    }

    public final long getTargetPopulationCiv(int i) {
        if (this.lTargetPopulation != null && i < this.lTargetPopulation.size()) {
            return this.lTargetPopulation.get(i);
        }
        return -1L;
    }

    public final long getTargetEconomyCiv(int i) {
        if (this.lTargetEconomy != null && i < this.lTargetEconomy.size()) {
            return this.lTargetEconomy.get(i);
        }
        return -1L;
    }

    public final int getTargetPopulationCivSize() {
        try {
            if (this.lTargetPopulation == null) {
                return 0;
            }
            return this.lTargetPopulation.size();
        } catch (Exception ex) {
            return 0;
        }
    }

    public final int getTargetEconomyCivSize() {
        try {
            if (this.lTargetEconomy == null) {
                return 0;
            }
            return this.lTargetEconomy.size();
        } catch (Exception ex) {
            return 0;
        }
    }

    public final long getStartingArmyInCapitals() {
        return this.iStartingArmyInCapitals;
    }

    public final void setStartingArmyInCapitals(long iStartingArmyInCapitals) {
        this.iStartingArmyInCapitals = iStartingArmyInCapitals;
    }

    public final void setStartingArmyInCapitals(int iStartingArmyInCapitals) {
        this.setStartingArmyInCapitals((long)iStartingArmyInCapitals);
    }

    public final long getStartingPopulation() {
        return this.iStartingPopulation;
    }

    public final void setStartingPopulation(long iStartingPopulation) {
        this.iStartingPopulation = iStartingPopulation;
    }

    public final void setStartingPopulation(int iStartingPopulation) {
        this.setStartingPopulation((long)iStartingPopulation);
    }

    public final long getStartingEconomy() {
        return this.iStartingEconomy;
    }

    public final void setStartingEconomy(long iStartingEconomy) {
        this.iStartingEconomy = iStartingEconomy;
    }

    public final void setStartingEconomy(int iStartingEconomy) {
        this.setStartingEconomy((long)iStartingEconomy);
    }

    public final long getStartingMoney() {
        return this.iStartingMoney;
    }

    public final void setStartingMoney(long iStartingMoney) {
        this.iStartingMoney = iStartingMoney;
    }

    public final void setStartingMoney(int iStartingMoney) {
        this.setStartingMoney((long)iStartingMoney);
    }

    public final String getActivePalletOfColors_TAG() {
        return this.ACTIVE_PALLET_OF_COLORS_TAG;
    }

    public final void setActivePalletOfColors_TAG(String aCTIVE_PALLET_OF_COLORS_TAG) {
        this.ACTIVE_PALLET_OF_COLORS_TAG = aCTIVE_PALLET_OF_COLORS_TAG;
    }

    public final boolean getColonization() {
        return this.COLONIZATION;
    }

    public final void setColonization(boolean cOLONIZATION) {
        this.COLONIZATION = cOLONIZATION;
    }

    public final List<Scenario_GameData_Technology> getTechnologyByContinents(int i) {
        return this.lTechnologyByContinents.get(i);
    }

    public final long getNeutralArmy() {
        return this.iNeutralArmy;
    }

    public final void setNeutralArmy(long iNeutralArmy) {
        this.iNeutralArmy = iNeutralArmy;
    }

    public final void setNeutralArmy(int iNeutralArmy) {
        this.setNeutralArmy((long)iNeutralArmy);
    }

    public final float getPopulationGrowthRate_Modifier() {
        return this.iPopulationGrowthRate_Modifier;
    }

    public final float getEconomyGrowthRate_Modifier() {
        return this.iEconomyGrowthRate_Modifier;
    }

    public final float getDiseasesDeathRate_Modifier() {
        return this.iDiseasesDeathRate_Modifier;
    }

    public final void addCampaingCivsIDs(int iCivID) {
        for (int i = 0; i < this.lCampaingCivsIDs.size(); ++i) {
            if (this.lCampaingCivsIDs.get(i) != iCivID) continue;
            return;
        }
        this.lCampaingCivsIDs.add(iCivID);
    }
}
