package aoc.kingdoms.lukasz.jakowski.android;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;

import aoc.kingdoms.lukasz.jakowski.AA_Game;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            extractBundledAssets();
        } catch (IOException e) {
            throw new RuntimeException("Failed to extract bundled game assets", e);
        }

        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        Process.setThreadPriority(Process.THREAD_PRIORITY_DISPLAY);
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
        config.maxSimultaneousSounds = 24;
        Log.i(TAG, "GL config request rgba=" + config.r + "/" + config.g + "/" + config.b + "/" + config.a
                + " depth=" + config.depth + " stencil=" + config.stencil + " gl30=" + config.useGL30
                + " samples=" + config.numSamples + " immersive=" + config.useImmersiveMode);

        initialize(new AA_Game(), config);
    }

    private void logRuntimeLimits() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        int memoryClass = activityManager == null ? -1 : activityManager.getMemoryClass();
        int largeMemoryClass = activityManager == null ? -1 : activityManager.getLargeMemoryClass();
        Runtime runtime = Runtime.getRuntime();
        Log.i(TAG, "Runtime limits cores=" + runtime.availableProcessors()
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
