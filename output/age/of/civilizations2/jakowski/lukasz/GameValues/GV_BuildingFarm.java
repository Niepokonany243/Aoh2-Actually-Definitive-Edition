
package age.of.civilizations2.jakowski.lukasz.GameValues;

public class GV_BuildingFarm {
    public String[] FARM_NAMES = new String[]{"", "Farm", "VillageFarm", "LargeFarm", "AdvancedFarm", "MechanizedFarm"};
    public float[] FARM_BUILD_COST = new float[]{0.0f, 0.03125f, 0.03825f, 0.05575f, 0.0825f, 0.1075f};
    public int[] FARM_BUILD_MOVEMENT_COST = new int[]{0, 6, 7, 8, 9, 10};
    public float[] FARM_GROWTH_RATE_BONUS = new float[]{0.0f, 0.08f, 0.16f, 0.24f, 0.32f, 0.4f};
    public float[] FARM_TECHNOLOGY_LEVEL = new float[]{0.0f, 0.15f, 0.3f, 0.4f, 0.55f, 0.7f};
    public int[] FARM_CONSTRUCTION = new int[]{0, 1, 2, 3, 4, 5};
    public float FARM_EXTRA_COST_PER_FARM = 0.00215f;
    public float FARM_COST_DEVELOPMENT_MODIFIER = 0.015f;
}

