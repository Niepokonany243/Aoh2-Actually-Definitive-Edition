package aoc.kingdoms.lukasz.jakowski.android;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import age.of.civilizations2.jakowski.lukasz.GameTaskScheduler;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class AndroidLauncher extends AndroidApplication {
    private static final String TAG = "AndroidLauncher";
    private static final String ASSET_ARCHIVE = "aoh2-assets.zip";
    private static final String ASSET_MARKER = ".aoh2-assets";
    private static final String[] ASSET_SENTINELS = {
            "game/unions/union_0_0.png",
            "game/languages/Bundle.properties",
            "game/languages/civilizations/Bundle.properties",
            "game/languages/loading/Bundle.properties",
            "game/languages/formable/Bundle.properties",
            "UI/interface/XXH/game_logo.png"
    };

    private static final int REQ_STORAGE = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Runtime storage permission (Android 9 API 23-28 only; 29+ uses MediaStore/app-specific no permission needed)
        requestStoragePermissionIfNeeded();

        // Requirement: globally clear perf report content on every game restart (including Android Download folder)
        clearPerformanceReportsOnRestart();

        try {
            extractBundledAssets();
        } catch (IOException e) {
            throw new RuntimeException("Failed to extract bundled game assets", e);
        }

        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        Process.setThreadPriority(Process.THREAD_PRIORITY_DISPLAY);
        // Dynamic workers: S24 Ultra 8 cores => 4 workers, budget for load + AI
        int cores = Runtime.getRuntime().availableProcessors();
        int workers = Math.max(2, Math.min(4, cores >= 8 ? 4 : cores >= 4 ? 3 : 2));
        int queueCap = 128;
        if (cores >= 8) queueCap = 256;
        GameTaskScheduler.install(workers, queueCap, "aoh2-mobile");
        configureDisplayForSmoothRendering();
        logRuntimeLimits();

        config.useGL30 = true;
        config.r = 8;
        config.g = 8;
        config.b = 8;
        config.a = 8;
        config.depth = 16;
        config.stencil = 0;
        config.useImmersiveMode = true;
        config.useWakelock = true;
        config.useAccelerometer = false;
        config.useCompass = false;
        config.useGyroscope = false;
        config.useRotationVectorSensor = false;
        config.numSamples = 0;
        config.maxSimultaneousSounds = 32;
        Log.i(TAG, "GL config request rgba=" + config.r + "/" + config.g + "/" + config.b + "/" + config.a
                + " depth=" + config.depth + " stencil=" + config.stencil + " gl30=" + config.useGL30
                + " samples=" + config.numSamples + " immersive=" + config.useImmersiveMode);

        initialize(new MobileGame(), config);
    }

    private void configureDisplayForSmoothRendering() {
        Window window = getWindow();
        if (window == null || Build.VERSION.SDK_INT < 23) {
            return;
        }

        Display display = getWindowManager().getDefaultDisplay();
        Display.Mode[] modes = display.getSupportedModes();
        if (modes == null || modes.length == 0) {
            return;
        }

        Display.Mode bestMode = display.getMode();
        for (Display.Mode mode : modes) {
            if (mode.getPhysicalWidth() >= bestMode.getPhysicalWidth()
                    && mode.getPhysicalHeight() >= bestMode.getPhysicalHeight()
                    && mode.getRefreshRate() > bestMode.getRefreshRate()) {
                bestMode = mode;
            }
        }
        // Prefer 120Hz if available (S24 Ultra, etc.), otherwise highest refresh
        Display.Mode mode120 = null;
        for (Display.Mode m : modes) {
            if (Math.abs(m.getRefreshRate() - 120f) < 0.5f) {
                if (mode120 == null || m.getPhysicalWidth() > mode120.getPhysicalWidth()) mode120 = m;
            }
        }
        if (mode120 != null) bestMode = mode120;

        WindowManager.LayoutParams params = window.getAttributes();
        params.preferredDisplayModeId = bestMode.getModeId();
        params.preferredRefreshRate = bestMode.getRefreshRate();
        window.setAttributes(params);
        Log.i(TAG, "Preferred display mode " + bestMode.getPhysicalWidth() + "x"
                + bestMode.getPhysicalHeight() + "@" + bestMode.getRefreshRate() + "Hz");

        // Android 15+ explicit 120Hz request via Window.setFrameRate (One UI 6-9, Android 9-17 compatible via reflection)
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                // Use preferredRefreshRate already, plus try setFrameRate for precise 120
                window.getAttributes().preferredRefreshRate = bestMode.getRefreshRate();
                // Reflective call for compatibility: window.setFrameRate(120, FRAME_RATE_COMPATIBILITY_FIXED_SOURCE, CHANGE_FRAME_RATE_ALWAYS)
                // Constants: FRAME_RATE_COMPATIBILITY_FIXED_SOURCE=2, CHANGE_FRAME_RATE_ALWAYS=1
                try {
                    java.lang.reflect.Method m = Window.class.getMethod("setFrameRate", float.class, int.class, int.class);
                    m.invoke(window, bestMode.getRefreshRate(), 2, 1);
                } catch (Throwable ignore) {}
                // Also via WindowManager.LayoutParams preferredRefreshRate fallback already set
                if (Build.VERSION.SDK_INT >= 31) {
                    try {
                        java.lang.reflect.Method m2 = Window.class.getMethod("setFrameRate", float.class, int.class);
                        m2.invoke(window, bestMode.getRefreshRate(), 1);
                    } catch (Throwable ignore) {}
                }
            }
        } catch (Throwable t) {
            Log.w(TAG, "setFrameRate failed: " + t.getMessage());
        }
    }

    private void requestStoragePermissionIfNeeded() {
        try {
            if (Build.VERSION.SDK_INT < 23) return;
            // Scoped storage API 29+ : MediaStore/app-specific needs no permission (targetSdk 35)
            if (Build.VERSION.SDK_INT >= 29) {
                Log.i(TAG, "Scoped storage API " + Build.VERSION.SDK_INT + " - no legacy storage permission needed (MediaStore)");
                return;
            }
            // API 23-28 (Android 6-9): need WRITE_EXTERNAL_STORAGE for public Download via File
            String perm = Manifest.permission.WRITE_EXTERNAL_STORAGE;
            if (checkSelfPermission(perm) == PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "Storage permission already granted");
                return;
            }
            Log.i(TAG, "Requesting storage permission WRITE_EXTERNAL_STORAGE for Download reports (API " + Build.VERSION.SDK_INT + ")");
            requestPermissions(new String[]{ perm }, REQ_STORAGE);
        } catch (Throwable t) {
            Log.w(TAG, "requestStoragePermission failed: " + t.getMessage());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ_STORAGE) {
            boolean granted = grantResults != null && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED;
            Log.i(TAG, "Storage permission result: " + (granted ? "GRANTED" : "DENIED") + " perms=" + java.util.Arrays.toString(permissions));
        }
    }

    private void clearPerformanceReportsOnRestart() {
        // Try MediaStore delete for public Download on API 29+ (scoped storage)
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                android.content.ContentResolver resolver = getContentResolver();
                android.net.Uri downloadsUri = android.provider.MediaStore.Downloads.EXTERNAL_CONTENT_URI;
                String colRelative = android.provider.MediaStore.MediaColumns.RELATIVE_PATH;
                int deleted = resolver.delete(downloadsUri, colRelative + "=?", new String[]{ "Download/AoH2/performance/" });
                if (deleted > 0) Log.i(TAG, "Cleared Download perf reports via MediaStore: deleted=" + deleted);
            } catch (Throwable t) {
                Log.w(TAG, "MediaStore clear failed (will try File): " + t.getMessage());
            }
        }
        // Legacy File path (works on API 23-28 and as best-effort on 29+ if permission granted)
        try {
            java.io.File downloadPerf = null;
            if (Build.VERSION.SDK_INT >= 29) {
                // Try File path as fallback but may be sandboxed
                try {
                    java.io.File extPub = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS);
                    downloadPerf = new java.io.File(extPub, "AoH2/performance");
                } catch (Throwable ignore) {}
            } else {
                downloadPerf = new java.io.File(android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS), "AoH2/performance");
            }
            if (downloadPerf != null && downloadPerf.exists() && downloadPerf.isDirectory()) {
                java.io.File[] files = downloadPerf.listFiles();
                if (files != null) {
                    for (java.io.File f : files) {
                        try {
                            if (f.isDirectory()) deleteRecursive(f);
                            else f.delete();
                        } catch (Throwable ignore) {}
                    }
                }
                Log.i(TAG, "Cleared Download perf reports via File: " + downloadPerf.getAbsolutePath());
            }
            // Also clear app-scoped external fallback: /Android/data/.../files/Download/AoH2/performance
            try {
                java.io.File scoped = new java.io.File(getExternalFilesDir(null), "Download/AoH2/performance");
                // Gdx.external maps to getExternalFilesDir parent; try parent of files
                java.io.File extRoot = getExternalFilesDir(null);
                if (extRoot != null) {
                    java.io.File alt = new java.io.File(extRoot.getParentFile(), "files/Download/AoH2/performance");
                    // Actually Gdx.external("Download/AoH2/performance") => /storage/emulated/0/Android/data/<pkg>/files/Download/AoH2/performance
                    java.io.File gdxExt = new java.io.File(extRoot, "Download/AoH2/performance");
                    for (java.io.File cand : new java.io.File[]{ scoped, gdxExt, alt }) {
                        if (cand != null && cand.exists() && cand.isDirectory()) {
                            java.io.File[] files = cand.listFiles();
                            if (files != null) for (java.io.File f : files) { try { if (f.isDirectory()) deleteRecursive(f); else f.delete(); } catch (Throwable ignore) {} }
                            Log.i(TAG, "Cleared scoped perf reports: " + cand.getAbsolutePath());
                        }
                    }
                }
            } catch (Throwable ignore) {}
        } catch (Throwable t) {
            Log.w(TAG, "clearPerformanceReports File failed: " + t.getMessage());
        }
    }

    private static void deleteRecursive(java.io.File f) {
        if (f.isDirectory()) {
            java.io.File[] children = f.listFiles();
            if (children != null) for (java.io.File c : children) deleteRecursive(c);
        }
        f.delete();
    }

    private void logRuntimeLimits() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        int memoryClass = activityManager == null ? -1 : activityManager.getMemoryClass();
        int largeMemoryClass = activityManager == null ? -1 : activityManager.getLargeMemoryClass();
        Runtime runtime = Runtime.getRuntime();
        Log.i(TAG, "Runtime limits workers=" + GameTaskScheduler.parallelism()
                + " heapMaxMB=" + (runtime.maxMemory() / 1048576L)
                + " activityMemoryClassMB=" + memoryClass
                + " largeMemoryClassMB=" + largeMemoryClass);
    }

    private void extractBundledAssets() throws IOException {
        File targetDir = getFilesDir();
        String marker = getPackageName() + ":" + getAssetArchiveLength();
        File markerFile = new File(targetDir, ASSET_MARKER);
        if (marker.equals(readMarker(markerFile)) && hasSentinelAssets(targetDir)) {
            Log.i(TAG, "Bundled assets already extracted at " + targetDir + " marker=" + marker);
            return;
        }

        Log.i(TAG, "Extracting bundled assets to " + targetDir);
        int extractedFiles = 0;
        try (ZipInputStream zip = new ZipInputStream(new BufferedInputStream(getAssets().open(ASSET_ARCHIVE)))) {
            ZipEntry entry;
            byte[] buffer = new byte[64 * 1024];
            while ((entry = zip.getNextEntry()) != null) {
                File outFile = safeAssetTarget(targetDir, entry.getName());
                if (entry.isDirectory()) {
                    ensureDirectory(outFile);
                } else {
                    ensureDirectory(outFile.getParentFile());
                    try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFile))) {
                        int read;
                        while ((read = zip.read(buffer)) != -1) {
                            out.write(buffer, 0, read);
                        }
                    }
                    ++extractedFiles;
                }
                zip.closeEntry();
            }
        }

        writeMarker(markerFile, marker);
        Log.i(TAG, "Bundled assets extracted files=" + extractedFiles + " marker=" + marker);
    }

    private boolean hasSentinelAssets(File targetDir) {
        for (String sentinel : ASSET_SENTINELS) {
            if (!new File(targetDir, sentinel).isFile()) {
                Log.w(TAG, "Missing bundled asset sentinel " + sentinel + " under " + targetDir);
                return false;
            }
        }
        return true;
    }

    private long getAssetArchiveLength() throws IOException {
        try (AssetFileDescriptor descriptor = getAssets().openFd(ASSET_ARCHIVE)) {
            return descriptor.getLength();
        }
    }

    private String readMarker(File markerFile) {
        if (!markerFile.isFile()) {
            return null;
        }

        byte[] data = new byte[(int) markerFile.length()];
        try (FileInputStream in = new FileInputStream(markerFile)) {
            int read = in.read(data);
            if (read <= 0) {
                return "";
            }
            return new String(data, 0, read, "UTF-8");
        } catch (IOException e) {
            return null;
        }
    }

    private void writeMarker(File markerFile, String marker) throws IOException {
        try (FileOutputStream out = new FileOutputStream(markerFile)) {
            out.write(marker.getBytes("UTF-8"));
        }
    }

    private File safeAssetTarget(File root, String entryName) throws IOException {
        File outFile = new File(root, entryName);
        String rootPath = root.getCanonicalPath() + File.separator;
        String outPath = outFile.getCanonicalPath();
        if (!outPath.startsWith(rootPath)) {
            throw new IOException("Blocked unsafe asset path: " + entryName);
        }
        return outFile;
    }

    private void ensureDirectory(File dir) throws IOException {
        if (dir != null && !dir.isDirectory() && !dir.mkdirs()) {
            throw new IOException("Failed to create directory: " + dir);
        }
    }
}
