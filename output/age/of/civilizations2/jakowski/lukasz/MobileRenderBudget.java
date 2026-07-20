package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.Gdx;

public class MobileRenderBudget {
    private static boolean enabled;
    private static long lastTouchTime;
    private static long lastCameraMoveTime;
    private static boolean isMoving;

    private static int prevPX = Integer.MIN_VALUE;
    private static int prevPY = Integer.MIN_VALUE;
    private static float prevZoom = -1f;

    private static final long SETTLE_TIME_MS = 250L;

    public static void setEnabled(boolean e) {
        enabled = e;
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void update() {
        if (!enabled) return;
        long now = System.currentTimeMillis();
        try {
            if (Gdx.input != null && Gdx.input.isTouched()) {
                lastTouchTime = now;
                isMoving = true;
                return;
            }
            if (CFG.map != null && CFG.map.getMpC() != null) {
                int px = CFG.map.getMpC().getPX();
                int py = CFG.map.getMpC().getPY();
                float zoom = CFG.map.getMpS().getCurrSc();
                if (px != prevPX || py != prevPY || Float.compare(zoom, prevZoom) != 0) {
                    lastCameraMoveTime = now;
                    prevPX = px;
                    prevPY = py;
                    prevZoom = zoom;
                    isMoving = true;
                    return;
                }
            }
            if (isMoving && (now - lastTouchTime > SETTLE_TIME_MS) && (now - lastCameraMoveTime > SETTLE_TIME_MS)) {
                isMoving = false;
            }
        }
        catch (Exception ex) {
            isMoving = false;
        }
    }

    public static boolean isMoving() {
        return isMoving;
    }

    public static boolean shouldRenderFullDetail() {
        return !isMoving;
    }

    public static boolean shouldRenderSecondaryOverlays() {
        if (!isMoving) return true;
        long now = System.currentTimeMillis();
        return (now - lastTouchTime) > 100L || (now - lastCameraMoveTime) > 100L;
    }

    public static boolean shouldRenderLabels() {
        if (!isMoving) return true;
        long now = System.currentTimeMillis();
        return (now - lastTouchTime) > 150L || (now - lastCameraMoveTime) > 150L;
    }

    public static void reset() {
        isMoving = false;
        lastTouchTime = 0;
        lastCameraMoveTime = 0;
        prevPX = Integer.MIN_VALUE;
        prevPY = Integer.MIN_VALUE;
        prevZoom = -1f;
    }
}
