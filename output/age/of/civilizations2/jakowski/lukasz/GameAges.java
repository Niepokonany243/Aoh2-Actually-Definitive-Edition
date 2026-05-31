/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Age;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import java.util.ArrayList;
import java.util.List;

public class GameAges {
    public List<Age> ages;
    private int agesSize;
    private String sBC;

    public GameAges() {
        this.loadAges();
    }

    public final void loadAges() {
        this.ages = new ArrayList<Age>();
        try {
            FileHandle fileList = FileManager.loadFile("game/Ages.json");
            String fileContent = fileList.readString();
            Json json = new Json();
            json.setElementType(ConfigAgesData.class, "Age", Data_Ages.class);
            ConfigAgesData data = new ConfigAgesData();
            data = json.fromJson(ConfigAgesData.class, fileContent);
            for (Object e : data.Age) {
                Data_Ages tempData = (Data_Ages)e;
                this.ages.add(new Age(tempData.Name, tempData.AGE_BeginningYear, tempData.AGE_EndYear, tempData.POPULATION_GROWTH, tempData.ECONOMY_GROWTH, tempData.FOG_OF_WAR_DISCOVERY_MET_PROVINCES, tempData.DEVELOPMENT_LEVEL_INCREASE, tempData.INCOME_TAXATION_MODIFIER, tempData.INCOME_PRODUCTION_MODIFIER, tempData.EXPENSES_ADMINSTRATION_MODIFIER, tempData.EXPENSES_MILITARY_UPKEEP_MODIFIER, tempData.BASE_MOVEMENT_POINTS, tempData.MOVEMENT_POINTS_MODIFIER, tempData.BASE_DIPLOMACY_POINTS, tempData.EXPENSES_ADMINSTRATION_DISTANCE, tempData.DIPLOMACY_ALLIANCE_PROPOSAL_NAGATIVE_DISTANCE, tempData.BASE_INCOME_TAXATION, tempData.INCOME_TAXATION_PER_TECHNOLOGY_MODIFIER, tempData.BASE_MILITARY_UPKEEP, tempData.GAME_STARTING_DEVELOPMENT, tempData.GAME_DAYS_PER_TURN, tempData.BASE_INCOME_PRODUCTION, tempData.INCOME_PRODUCTIONN_PER_DEVELOPMENT_MODIFIER, tempData.REVOLUTIONARY_RISK_MODIFIER, tempData.DISEASE_CHANCE, tempData.COLONIZATION_COST, tempData.COLONIZE_COST_MOVEMENT_POINTS, tempData.COLONIZE_COST_DIPLOMACY_POINTS, tempData.SHIP_GROUP, tempData.RIVALS_DISTANCE));
            }
        }
        catch (GdxRuntimeException ex) {
            CFG.exceptionStack(ex);
            this.ages.add(new Age("AgeofCivilizations", -5000, -301, 0.3f, 0.2f));
            this.ages.add(new Age("AgeofExpansion", -300, 499, 0.35f, 0.22f));
            this.ages.add(new Age("AgeofDarkness", 500, 1065, 0.4f, 0.22f));
            this.ages.add(new Age("AgeofFeudalism", 1066, 1491, 0.45f, 0.22f));
            this.ages.add(new Age("AgeofDiscovery", 1492, 1749, 0.5f, 0.22f));
            this.ages.add(new Age("AgeofRevolution", 1750, 1835, 0.55f, 0.22f));
            this.ages.add(new Age("AgeofIndustrialisation", 1836, 1860, 0.6f, 0.22f));
            this.ages.add(new Age("AgeofImperialism", 1861, 1918, 0.65f, 0.22f));
            this.ages.add(new Age("AgeofConflict", 1919, 1946, 0.7f, 0.22f));
            this.ages.add(new Age("AgeofBrinkmanship", 1947, 1990, 0.75f, 0.22f));
            this.ages.add(new Age("AgeofInformation", 1991, 2049, 0.8f, 0.22f));
            this.ages.add(new Age("AgeofTomorrow", 2050, 5000, 0.95f, 1.0f));
        }
        this.sBC = CFG.lang.get("BeforeChrist");
        this.agesSize = this.ages.size();
        for (int i = 0; i < this.agesSize; ++i) {
            this.ages.get(i).setName(CFG.lang.get(this.ages.get(i).getName()));
        }
    }

    public final void updateLanguage() {
        this.loadAges();
    }

    public final String getYear(int nYear) {
        return nYear < 0 ? "" + -nYear + " " + this.getBC() : "" + nYear;
    }

    public final int getAgeOfYear(int nYear) {
        if (this.ages.isEmpty()) return 0;
        for (int i = 0; i < this.ages.size() - 1; ++i) {
            if (this.ages.get(i).getBeginningYear() > nYear || this.ages.get(i).getEndYear() < nYear) continue;
            return i;
        }
        return this.ages.size() - 1;
    }

    public final float getAge_FogOfWarDiscovery_MetProvinces(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).FOG_OF_WAR_DISCOVERY_MET_PROVINCES;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_Population_GrowthRate(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).getPopulationGrowthRate();
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_Economy_GrowthRate(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).getEconomyGrowthRate();
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_DevelopmentLevel_Increase(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).DEVELOPMENT_LEVEL_INCREASE;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_TreasuryModifier(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).INCOME_TAXATION_MODIFIER;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_TreasuryModifier_Production(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).INCOME_PRODUCTION_MODIFIER;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_TreasuryModifier_Administration(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).EXPENSES_ADMINSTRATION_MODIFIER;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_TreasuryModifier_MilitaryUpkeep(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).EXPENSES_MILITARY_UPKEEP_MODIFIER;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final int getAge_StartingMovementPoints(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 10;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).BASE_MOVEMENT_POINTS;
        } catch (Exception ex) {
            return 10;
        }
    }

    public final float getAge_MovementPointsModifier(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).MOVEMENT_POINTS_MODIFIER;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final int getAge_StartingDiplomacyPoints(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 2;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).BASE_DIPLOMACY_POINTS;
        } catch (Exception ex) {
            return 2;
        }
    }

    public final float getAge_AdministrationCost_Distance(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).EXPENSES_ADMINSTRATION_DISTANCE;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_DistanceDiplomacy(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return (float)this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).DIPLOMACY_ALLIANCE_PROPOSAL_NAGATIVE_DISTANCE;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_IncomeTaxationBase(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).BASE_INCOME_TAXATION;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_IncomeTaxation_PerTechnology(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).INCOME_TAXATION_PER_TECHNOLOGY_MODIFIER;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_MilitaryUpkeep(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).BASE_MILITARY_UPKEEP;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_StartingDevelopment(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 0.1f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).GAME_STARTING_DEVELOPMENT;
        } catch (Exception ex) {
            return 0.1f;
        }
    }

    public final float getAge_IncomeProductionBase(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).BASE_INCOME_PRODUCTION;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_IncomeProduction_PerDev(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).INCOME_PRODUCTIONN_PER_DEVELOPMENT_MODIFIER;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_RevolutionaryRiskModifier(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 1.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).REVOLUTIONARY_RISK_MODIFIER;
        } catch (Exception ex) {
            return 1.0f;
        }
    }

    public final float getAge_DiseaseChance(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 0.0f;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).DISEASE_CHANCE;
        } catch (Exception ex) {
            return 0.0f;
        }
    }

    public final int getAge_TurnDays(int nAgeID) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return 30;
            return (int)((float)this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, nAgeID))).GAME_DAYS_PER_TURN * GameCalendar.GAME_SPEED);
        } catch (Exception ex) {
            return (int)(30.0f * GameCalendar.GAME_SPEED);
        }
    }

    public final Age getAge(int i) {
        try {
            if (this.ages == null || this.ages.isEmpty()) return null;
            return this.ages.get(Math.max(0, Math.min(this.ages.size() - 1, i)));
        }
        catch (Exception ex) {
            return (this.ages == null || this.ages.isEmpty()) ? null : this.ages.get(this.ages.size() - 1);
        }
    }

    public final String getBC() {
        return this.sBC;
    }

    public final int getAgesSize() {
        return this.agesSize;
    }

    public static class ConfigAgesData {
        public String Age_of_Civilizations;
        public ArrayList Age;
    }

    public static class Data_Ages {
        public String Name;
        public int AGE_BeginningYear;
        public int AGE_EndYear;
        public float POPULATION_GROWTH;
        public float ECONOMY_GROWTH;
        public float DEVELOPMENT_LEVEL_INCREASE;
        public float INCOME_TAXATION_MODIFIER;
        public float INCOME_PRODUCTION_MODIFIER;
        public float EXPENSES_ADMINSTRATION_MODIFIER;
        public float EXPENSES_MILITARY_UPKEEP_MODIFIER;
        public int BASE_MOVEMENT_POINTS;
        public float FOG_OF_WAR_DISCOVERY_MET_PROVINCES;
        public float MOVEMENT_POINTS_MODIFIER;
        public int BASE_DIPLOMACY_POINTS;
        public float EXPENSES_ADMINSTRATION_DISTANCE;
        public int DIPLOMACY_ALLIANCE_PROPOSAL_NAGATIVE_DISTANCE;
        public float BASE_INCOME_TAXATION;
        public float INCOME_TAXATION_PER_TECHNOLOGY_MODIFIER;
        public float BASE_MILITARY_UPKEEP;
        public float GAME_STARTING_DEVELOPMENT;
        public int GAME_DAYS_PER_TURN;
        public float BASE_INCOME_PRODUCTION;
        public float INCOME_PRODUCTIONN_PER_DEVELOPMENT_MODIFIER;
        public float REVOLUTIONARY_RISK_MODIFIER;
        public float COLONIZATION_COST;
        public int COLONIZE_COST_MOVEMENT_POINTS;
        public int COLONIZE_COST_DIPLOMACY_POINTS;
        public float DISEASE_CHANCE;
        public int SHIP_GROUP = 0;
        public float RIVALS_DISTANCE = 1.0f;
    }
}
