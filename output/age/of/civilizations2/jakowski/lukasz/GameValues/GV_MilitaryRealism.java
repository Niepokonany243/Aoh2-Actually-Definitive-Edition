package age.of.civilizations2.jakowski.lukasz.GameValues;

public class GV_MilitaryRealism {
    public String[] MOBILIZATION_NAME = {"Peace", "Alert", "PartialMobilization", "FullMobilization", "TotalMobilization", "EmergencyLevy", "AdvancedArmy", "ProfessionalArmy", "EliteArmy"};
    public float[] MOBILIZATION_RECRUIT_COST = {1.0f, 0.9f, 0.75f, 0.55f, 0.4f, 0.25f, 1.2f, 1.55f, 2.0f};
    public float[] MOBILIZATION_UPKEEP = {1.0f, 0.9f, 0.8f, 0.7f, 0.6f, 0.5f, 2.5f, 3.25f, 4.25f};
    public float[] MOBILIZATION_ATTACK_BONUS = {0.0f, -2.0f, -6.0f, -12.0f, -20.0f, -35.0f, 5.0f, 12.0f, 22.0f};
    public float[] MOBILIZATION_DEFENSE_BONUS = {0.0f, -1.0f, -4.0f, -8.0f, -15.0f, -25.0f, 4.0f, 10.0f, 18.0f};
    public int DEMOBILIZATION_TURNS = 10;
    public float LOW_ECONOMY_RECRUIT_COST_REDUCTION_MAX = 0.55f;
    public float HIGH_ECONOMY_RECRUIT_COST_INCREASE = 0.15f;
    public float HIGH_ECONOMY_RECRUIT_COST_INCREASE_MAX = 0.4f;
    public float LOGISTICS_ARMY_POPULATION_THRESHOLD = 0.08f;
    public float LOGISTICS_UPKEEP_PER_OVER_THRESHOLD = 3.0f;
    public float LOGISTICS_UPKEEP_MAX = 0.75f;
}
