package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.Gdx;

public class AndroidPerfTracer {
    private static boolean enabled = false;
    private static boolean verbose = false;

    private static long frameStart;
    private static long phaseStart;
    private static long totalFrameMs;
    private static int frameCount;
    private static long gcCount;
    private static long gcTotalMs;
    private static long lastGCDetect;

    private static long timerWorldScaled;
    private static long timerProvinceColor;
    private static long timerDrawWithoutScale;
    private static long timerCivNames;
    private static long timerOverlays;
    private static long timerCapitalFlags;
    private static long timerArmyFlags;
    private static long timerCityIcons;
    private static long timerMinimap;
    private static long timerMenuMM;
    private static long timerMenuInGame2;
    private static long timerAI;
    private static long timerUI;
    private static long timerBordersNs;
    private static long borderRenderCalls;

    private static int countWorldScaled;
    private static int countDrawWithoutScale;
    private static int countMenuMM;
    private static int countMenuInGame2;
    private static int countBorders;

    private static Runtime runtime = Runtime.getRuntime();
    private static long prevUsedMem;
    private static long peakUsedMem;

    private static long lastLogTime;
    private static final long LOG_INTERVAL_MS = 10000;

    private static int sumRenderCalls;
    private static int sumTotalRenderCalls;
    private static int prevTotalRenderCalls;
    private static int maxSpritesInBatch;
    private static int lastDirtyCount;

    public static void setEnabled(boolean e) {
        enabled = e;
        if (!e) {
            resetAll();
        }
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setVerbose(boolean v) {
        verbose = v;
    }

    public static boolean isVerbose() {
        return verbose;
    }

    public static void resetAll() {
        totalFrameMs = 0;
        frameCount = 0;
        gcCount = 0;
        gcTotalMs = 0;
        timerWorldScaled = 0;
        timerProvinceColor = 0;
        timerDrawWithoutScale = 0;
        timerCivNames = 0;
        timerOverlays = 0;
        timerCapitalFlags = 0;
        timerArmyFlags = 0;
        timerCityIcons = 0;
        timerMinimap = 0;
        timerMenuMM = 0;
        timerMenuInGame2 = 0;
        timerAI = 0;
        timerUI = 0;
        timerBordersNs = 0;
        borderRenderCalls = 0;
        countWorldScaled = 0;
        countDrawWithoutScale = 0;
        countMenuMM = 0;
        countMenuInGame2 = 0;
        countBorders = 0;
        peakUsedMem = 0;
        prevUsedMem = 0;
        sumRenderCalls = 0;
        sumTotalRenderCalls = 0;
        prevTotalRenderCalls = 0;
        maxSpritesInBatch = 0;
        lastDirtyCount = 0;
        lastLogTime = System.currentTimeMillis();
    }

    public static void beginFrame() {
        if (!enabled) return;
        frameStart = System.nanoTime();
        phaseStart = frameStart;
        detectGC();
    }

    public static void endPhase(String name) {
        if (!enabled) return;
        long now = System.nanoTime();
        long elapsed = (now - phaseStart) / 1000000L;
        phaseStart = now;
        if (name == null) return;
        switch (name) {
            case "WorldScaled":
                timerWorldScaled += elapsed;
                countWorldScaled++;
                break;
            case "ProvinceColor":
                timerProvinceColor += elapsed;
                break;
            case "DrawWithoutScale":
                timerDrawWithoutScale += elapsed;
                countDrawWithoutScale++;
                break;
            case "CivNames":
                timerCivNames += elapsed;
                break;
            case "Overlays":
                timerOverlays += elapsed;
                break;
            case "CapitalFlags":
                timerCapitalFlags += elapsed;
                break;
            case "ArmyFlags":
                timerArmyFlags += elapsed;
                break;
            case "CityIcons":
                timerCityIcons += elapsed;
                break;
            case "Minimap":
                timerMinimap += elapsed;
                break;
            case "MenuMM":
                timerMenuMM += elapsed;
                countMenuMM++;
                break;
            case "Menu_InGame_2":
                timerMenuInGame2 += elapsed;
                countMenuInGame2++;
                break;
            case "AI":
                timerAI += elapsed;
                break;
            case "UI":
                timerUI += elapsed;
                break;
        }
    }

    public static void beginPhase() {
        if (!enabled) return;
        phaseStart = System.nanoTime();
    }

    public static void recordBorders(long elapsedNs, int renderCalls) {
        if (!enabled) return;
        timerBordersNs += elapsedNs;
        borderRenderCalls += Math.max(0, renderCalls);
        countBorders++;
    }

    public static void recordBatchStats(int renderCalls, int totalRenderCalls, int maxSprites) {
        if (!enabled) return;
        sumRenderCalls += renderCalls;
        int delta = totalRenderCalls - prevTotalRenderCalls;
        if (delta > 0) sumTotalRenderCalls += delta;
        prevTotalRenderCalls = totalRenderCalls;
        if (maxSprites > maxSpritesInBatch) maxSpritesInBatch = maxSprites;
        if (ProvinceMesh.isInitialized()) {
            lastDirtyCount = ProvinceMesh.getDirtyCount();
        }
    }

    public static void endFrame() {
        if (!enabled) return;
        long now = System.nanoTime();
        long frameMs = (now - frameStart) / 1000000L;
        totalFrameMs += frameMs;
        frameCount++;

        long usedMem = (runtime.totalMemory() - runtime.freeMemory()) / 1048576L;
        if (usedMem > peakUsedMem) peakUsedMem = usedMem;

        if (frameCount >= 300 || System.currentTimeMillis() - lastLogTime >= LOG_INTERVAL_MS) {
            logSummary();
            resetAll();
        }
    }

    private static void detectGC() {
        long usedMem = (runtime.totalMemory() - runtime.freeMemory()) / 1048576L;
        if (prevUsedMem > 0 && usedMem < prevUsedMem - 2) {
            long now = System.currentTimeMillis();
            if (lastGCDetect > 0) {
                long gcInterval = now - lastGCDetect;
                gcCount++;
                gcTotalMs += Math.min(gcInterval, 50);
            }
            lastGCDetect = now;
        }
        prevUsedMem = usedMem;
    }

    private static void logSummary() {
        if (frameCount <= 0) return;
        long avgMs = totalFrameMs / frameCount;
        long usedMem = (runtime.totalMemory() - runtime.freeMemory()) / 1048576L;
        long totalMem = runtime.totalMemory() / 1048576L;
        long maxMem = runtime.maxMemory() / 1048576L;

        StringBuilder sb = new StringBuilder();
        sb.append("[PERF] avg=").append(avgMs).append("ms over ").append(frameCount).append(" frames");
        sb.append(" mem=").append(usedMem).append("/").append(totalMem).append("/").append(maxMem).append("MB");
        sb.append(" peak=").append(peakUsedMem).append("MB");
        if (gcCount > 0) {
            sb.append(" gc=").append(gcCount).append("(").append(gcTotalMs).append("ms)");
        }
        sb.append(" zoom=").append(String.format("%.2f", CFG.map != null ? CFG.map.getMpS().getCurrSc() : 0));
        sb.append(" provInView=").append(CFG.NUM_OF_PROVINCES_IN_VIEW);
        sb.append(" civs=").append(CFG.core != null ? CFG.core.getCivsSize() : 0);

        if (countWorldScaled > 0) {
            sb.append(" world=").append(timerWorldScaled / countWorldScaled).append("ms");
        }
        if (countDrawWithoutScale > 0) {
            sb.append(" overlay=").append(timerDrawWithoutScale / countDrawWithoutScale).append("ms");
        }
        if (countBorders > 0) {
            sb.append(" borders=").append(timerBordersNs / countBorders / 1000000L).append("ms");
            sb.append(" borderCalls=").append(borderRenderCalls / countBorders);
        }
        if (timerCapitalFlags > 0) {
            sb.append(" flags=").append(timerCapitalFlags / Math.max(1, frameCount)).append("ms");
        }
        if (timerMinimap > 0) {
            sb.append(" minimap=").append(timerMinimap / Math.max(1, frameCount)).append("ms");
        }
        if (countMenuMM > 0) {
            sb.append(" menuMM=").append(timerMenuMM / countMenuMM).append("ms");
        }
        if (countMenuInGame2 > 0) {
            sb.append(" ingame2=").append(timerMenuInGame2 / countMenuInGame2).append("ms");
        }
        if (timerAI > 0) {
            sb.append(" AI=").append(timerAI / Math.max(1, frameCount)).append("ms");
        }
        if (lastDirtyCount > 0) {
            sb.append(" dirty=").append(lastDirtyCount);
        }
        if (frameCount > 0 && sumRenderCalls > 0) {
            sb.append(" draws=").append(sumRenderCalls / frameCount);
            sb.append(" totalDraws=").append(sumTotalRenderCalls / frameCount);
            sb.append(" maxBatch=").append(maxSpritesInBatch);
        }

        Gdx.app.log("AndroidPerfTracer", sb.toString());
    }

    public static int getDirtyProvinceCount() {
        return lastDirtyCount;
    }
}
