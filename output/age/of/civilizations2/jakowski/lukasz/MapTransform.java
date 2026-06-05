package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Next-Gen Map Transformation Utility
 * Standardizes coordinate conversions across the codebase.
 */
public class MapTransform {
    private static Vector2 temp = new Vector2();

    /**
     * Converts screen coordinates (0 to width) to world coordinates (map relative).
     */
    public static Vector2 screenToWorld(float screenX, float screenY) {
        float currSc = CFG.map.getMpS().getCurrSc();
        float mapPX = CFG.map.getMpC().getPX();
        float mapPY = CFG.map.getMpC().getPY();
        
        float worldX = (screenX / currSc) - mapPX;
        float worldY = (screenY / currSc) - mapPY;
        
        // Handle map wrap-around
        worldX = wrapWorldX(worldX);
        
        return temp.set(worldX, worldY);
    }

    /**
     * Normalizes world X to be within [0, mapWidth).
     */
    public static float wrapWorldX(float worldX) {
        float mapWidth = CFG.map.getMpB().getWidthM();
        if (worldX < 0) {
            worldX += mapWidth * (Math.floor(Math.abs(worldX) / mapWidth) + 1);
        }
        return worldX % mapWidth;
    }

    /**
     * Converts world coordinates to screen coordinates.
     */
    public static Vector2 worldToScreen(float worldX, float worldY) {
        float currSc = CFG.map.getMpS().getCurrSc();
        float mapPX = CFG.map.getMpC().getPX();
        float mapPY = CFG.map.getMpC().getPY();
        
        float screenX = (worldX + mapPX) * currSc;
        float screenY = (worldY + mapPY) * currSc;
        
        return temp.set(screenX, screenY);
    }
}
