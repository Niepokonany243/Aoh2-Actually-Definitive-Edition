package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.Gdx;

public class FrameWorkScheduler {
    private static boolean enabled;
    private static long frameBudgetNs;
    private static long frameStartNs;
    private static boolean workInProgress;
    private static long workStartNs;
    private static int workSliceCount;
    private static long totalWorkNs;

    private static final long DEFAULT_BUDGET_NS = 4000000L;
    private static final long INTERACTIVE_BUDGET_NS = 8000000L;
    private static final long BACKGROUND_BUDGET_NS = 16000000L;

    public static void setEnabled(boolean e) {
        enabled = e;
        if (!e) {
            workInProgress = false;
        }
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void beginFrame() {
        if (!enabled) return;
        frameStartNs = System.nanoTime();
        if (isUserInteracting()) {
            frameBudgetNs = INTERACTIVE_BUDGET_NS;
        } else {
            frameBudgetNs = BACKGROUND_BUDGET_NS;
        }
    }

    public static boolean beginWork(String phaseName) {
        if (!enabled) return false;
        if (workInProgress) return false;
        long elapsed = System.nanoTime() - frameStartNs;
        if (elapsed >= frameBudgetNs) return false;
        workInProgress = true;
        workStartNs = System.nanoTime();
        return true;
    }

    public static void endWork(String phaseName) {
        if (!enabled || !workInProgress) return;
        workInProgress = false;
        long elapsed = System.nanoTime() - workStartNs;
        workSliceCount++;
        totalWorkNs += elapsed;
    }

    public static boolean hasBudgetRemaining() {
        if (!enabled) return true;
        return (System.nanoTime() - frameStartNs) < frameBudgetNs;
    }

    public static boolean shouldYield() {
        if (!enabled) return false;
        return (System.nanoTime() - frameStartNs) >= frameBudgetNs;
    }

    public static void logSummary() {
        if (!enabled || workSliceCount <= 0) return;
        Gdx.app.log("FrameWorkScheduler", "[PERF] AI work: " + workSliceCount + " slices, " + (totalWorkNs / 1000000L) + "ms total");
        workSliceCount = 0;
        totalWorkNs = 0;
    }

    private static boolean isUserInteracting() {
        try {
            if (Gdx.input != null && Gdx.input.isTouched()) return true;
            if (CFG.map != null && CFG.map.getMpC() != null) {
                float zoom = CFG.map.getMpS().getCurrSc();
                int px = CFG.map.getMpC().getPX();
                if (Math.abs(px - CFG.map.getMpC().getPX()) > 0) return true;
            }
            return false;
        }
        catch (Exception ex) {
            return true;
        }
    }
}
