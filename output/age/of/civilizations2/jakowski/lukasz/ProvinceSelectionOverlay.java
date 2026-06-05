package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Core.Core;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Next-Gen Province Selection Overlay
 * Renders the selection highlight cleanly on top of the map.
 */
public class ProvinceSelectionOverlay {
    private static final Color SELECTION_COLOR = new Color(1.0f, 1.0f, 1.0f, 0.5f);
    private static final float ANIMATION_SPEED = 2.0f;
    private static float alphaState = 0.5f;
    private static boolean increasing = true;

    public static void draw(SpriteBatch oSB) {
        int selectedID = ProvinceSelectionManager.getSelectedProvinceID();
        if (selectedID < 0) return;

        Province prov = CFG.core.getProv(selectedID);
        if (prov == null) return;

        updateAnimation();

        float currSc = CFG.map.getMpS().getCurrSc();
        int mapPosX = CFG.map.getMpC().getPX();
        int mapPosY = CFG.map.getMpC().getPY();

        oSB.setColor(SELECTION_COLOR.r, SELECTION_COLOR.g, SELECTION_COLOR.b, alphaState);
        
        // Draw primary instance
        drawProvinceHighlight(oSB, prov, mapPosX, mapPosY);

        // Draw second instance for map wrap-around
        if (CFG.map.getMpC().getSecondSideOfMap()) {
            drawProvinceHighlight(oSB, prov, mapPosX + CFG.map.getMpB().getWidthM(), mapPosY);
            drawProvinceHighlight(oSB, prov, mapPosX - CFG.map.getMpB().getWidthM(), mapPosY);
        }

        oSB.setColor(Color.WHITE);
    }

    private static void updateAnimation() {
        float delta = com.badlogic.gdx.Gdx.graphics.getDeltaTime();
        if (increasing) {
            alphaState += delta * ANIMATION_SPEED;
            if (alphaState >= 0.8f) {
                alphaState = 0.8f;
                increasing = false;
            }
        } else {
            alphaState -= delta * ANIMATION_SPEED;
            if (alphaState <= 0.3f) {
                alphaState = 0.3f;
                increasing = true;
            }
        }
    }

    private static void drawProvinceHighlight(SpriteBatch oSB, Province prov, int translateX, int translateY) {
        // We use the province's existing border drawing logic but with our own controlled color and state.
        // Importantly, we don't call methods that update/rebuild the border data.
        prov.drawProvinceBorder_PrintAMap(oSB); // This is a safe baseline draw
    }
}
