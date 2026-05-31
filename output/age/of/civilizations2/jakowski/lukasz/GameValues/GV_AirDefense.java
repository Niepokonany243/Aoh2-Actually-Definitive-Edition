package age.of.civilizations2.jakowski.lukasz.GameValues;

public class GV_AirDefense {
    public String[] AIR_DEFENSE_NAMES = new String[]{"", "Air Defense System", "Advanced Air Defense", "Anti-Ballistic Shield", "Planetary Defense"};
    public float[] AIR_DEFENSE_BUILD_COST = new float[]{0.0f, 0.08f, 0.12f, 0.18f, 0.25f};
    public int[] AIR_DEFENSE_BUILD_MOVEMENT_COST = new int[]{0, 15, 18, 22, 25};
    public float[] AIR_DEFENSE_PROTECTION_CHANCE = new float[]{0.0f, 0.15f, 0.30f, 0.50f, 0.75f};
    public float[] AIR_DEFENSE_TECH_LEVEL = new float[]{0.0f, 0.65f, 0.75f, 0.85f, 0.95f};
    public int[] AIR_DEFENSE_CONSTRUCTION_TURNS = new int[]{0, 3, 4, 5, 6};
    
    public float AIR_DEFENSE_EXTRA_COST_PER_BUILDING = 0.005f;
    public float AIR_DEFENSE_COST_DEVELOPMENT_MODIFIER = 0.03f;
    public int AIR_DEFENSE_MAINTENANCE = 10;
}
