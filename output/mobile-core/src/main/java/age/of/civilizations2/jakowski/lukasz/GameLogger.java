package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GameLogger {
    private static PrintStream originalOut = System.out;
    private static PrintStream originalErr = System.err;
    private static FileHandle logFile = null;
    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;
        try {
            if (Gdx.app.getType() == Application.ApplicationType.Android) {
                Gdx.app.setLogLevel(Application.LOG_INFO);
                requestAndroidPermissions();
                logFile = Gdx.files.external("Age of History 2 Definitive Edition/logs/game.log");
            } else {
                logFile = Gdx.files.local("logs/game.log");
            }

            
            if (!logFile.parent().exists()) {
                logFile.parent().mkdirs();
            }

            
            
            final OutputStream fileOut = logFile.write(false);
            
            PrintStream dualOut = new PrintStream(new OutputStream() {
                @Override
                public void write(int b) {
                    originalOut.write(b);
                    try { fileOut.write(b); } catch (Exception ignored) {}
                }
                @Override
                public void write(byte[] b, int off, int len) {
                    originalOut.write(b, off, len);
                    try { fileOut.write(b, off, len); } catch (Exception ignored) {}
                }
                @Override
                public void flush() {
                    originalOut.flush();
                    try { fileOut.flush(); } catch (Exception ignored) {}
                }
                @Override
                public void close() {
                    try { fileOut.close(); } catch (Exception ignored) {}
                }
            }, true);

            PrintStream dualErr = new PrintStream(new OutputStream() {
                @Override
                public void write(int b) {
                    originalErr.write(b);
                    try { fileOut.write(b); } catch (Exception ignored) {}
                }
                @Override
                public void write(byte[] b, int off, int len) {
                    originalErr.write(b, off, len);
                    try { fileOut.write(b, off, len); } catch (Exception ignored) {}
                }
                @Override
                public void flush() {
                    originalErr.flush();
                    try { fileOut.flush(); } catch (Exception ignored) {}
                }
            }, true);

            System.setOut(dualOut);
            System.setErr(dualErr);
            
            System.out.println("--- Game Logger Initialized ---");
            System.out.println("Platform: " + Gdx.app.getType());
            System.out.println("Log file: " + logFile.path());
            
            initialized = true;
            // Globally clear perf report folder on restart (supports mobile Download folder via PerfAnalyzer)
            try { PerfAnalyzer.clearReportsOnStartup(); } catch (Throwable ignore) {}
            try { clearPerformanceFolderOnStartup(); } catch (Throwable ignore) {}
        } catch (Exception ex) {
            originalErr.println("Failed to initialize GameLogger: " + ex.getMessage());
            ex.printStackTrace(originalErr);
        }
    }

    public static void clearPerformanceFolderOnStartup() {
        try {
            // Desktop: logs/performance
            FileHandle perfDesktop = Gdx.files.local("logs/performance");
            if (perfDesktop.exists()) {
                for (FileHandle f : perfDesktop.list()) {
                    try { if (f.isDirectory()) f.deleteDirectory(); else f.delete(); } catch (Throwable ignore) {}
                }
            }
            // Android: Download/AoH2/performance via external
            if (Gdx.app != null && Gdx.app.getType() == Application.ApplicationType.Android) {
                FileHandle perfAndroid = Gdx.files.external("Download/AoH2/performance");
                if (perfAndroid.exists()) {
                    for (FileHandle f : perfAndroid.list()) {
                        try { if (f.isDirectory()) f.deleteDirectory(); else f.delete(); } catch (Throwable ignore) {}
                    }
                }
            }
        } catch (Throwable ignore) {}
    }

    private static void requestAndroidPermissions() {
        try {
            int sdk = -1;
            try {
                Class<?> v2 = Class.forName("android.os.Build$VERSION");
                sdk = v2.getField("SDK_INT").getInt(null);
            } catch (Throwable ignore) {
                try {
                    Class<?> buildClass = Class.forName("android.os.Build");
                    java.lang.reflect.Field ver = buildClass.getField("VERSION");
                    Object verObj = ver.get(null);
                    sdk = verObj.getClass().getField("SDK_INT").getInt(verObj);
                } catch (Throwable ignore2) {}
            }
            // targetSdk 35 + scoped storage: public Download via MediaStore (API 29+) needs no permission for own files.
            // Only legacy File path on API 23-28 needs WRITE. On 29-32 legacy path would need READ but we use MediaStore instead.
            String[] permissions;
            if (sdk >= 29) {
                // Scoped storage: MediaStore handles public Download, app-specific external is always writable.
                // No storage permission needed; log and return. This fixes "doesnt ask for storage permission" spam on Android 10+
                // while still saving to Download/AoH2 via MediaStore (PerfAnalyzer.tryWriteViaMediaStore).
                System.out.println("GameLogger: Scoped storage API " + sdk + " - using MediaStore/app-specific, no legacy storage permission needed.");
                return;
            } else if (sdk >= 23) {
                permissions = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
            } else {
                // API <23 no runtime permissions
                System.out.println("GameLogger: API " + sdk + " no runtime permission required.");
                return;
            }

            // First try libGDX Gdx.app.requestPermissions (PermissionsListener interface)
            Method requestMethod = null;
            for (Method m : Gdx.app.getClass().getMethods()) {
                if (!m.getName().equals("requestPermissions")) continue;
                Class<?>[] pt = m.getParameterTypes();
                if (pt.length != 2) continue;
                if (!pt[0].equals(String[].class)) continue;
                if (pt[1].isPrimitive()) continue;
                if (!pt[1].isInterface()) continue;
                boolean hasGranted = false;
                try { pt[1].getMethod("granted"); hasGranted = true; } catch (Throwable ignore) { }
                if (!hasGranted) continue;
                requestMethod = m;
                break;
            }
            if (requestMethod != null) {
                Class<?> listenerClass = requestMethod.getParameterTypes()[1];
                Object listenerProxy = Proxy.newProxyInstance(
                    listenerClass.getClassLoader(),
                    new Class<?>[]{listenerClass},
                    (proxy, method, args) -> {
                        if (method.getName().equals("granted")) System.out.println("Android permissions granted.");
                        else if (method.getName().equals("rejected")) System.out.println("Android permissions rejected.");
                        return null;
                    }
                );
                System.out.println("GameLogger: Requesting permissions " + java.util.Arrays.toString(permissions));
                requestMethod.invoke(Gdx.app, (Object) permissions, listenerProxy);
                return;
            }
            // Fallback: direct Activity.requestPermissions(String[], int) via ContextCompat check
            try {
                Object activity = Gdx.app;
                // Try to check permission via Context.checkSelfPermission
                java.lang.reflect.Method checkPerm = null;
                try { checkPerm = activity.getClass().getMethod("checkSelfPermission", String.class); } catch (Throwable t) { checkPerm = Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class); }
                boolean needRequest = false;
                for (String p : permissions) {
                    int granted = (Integer) checkPerm.invoke(activity, p);
                    // PackageManager.PERMISSION_GRANTED == 0
                    if (granted != 0) { needRequest = true; break; }
                }
                if (needRequest) {
                    java.lang.reflect.Method reqPerm = null;
                    try { reqPerm = activity.getClass().getMethod("requestPermissions", String[].class, int.class); } catch (Throwable t) { reqPerm = Class.forName("android.app.Activity").getMethod("requestPermissions", String[].class, int.class); }
                    System.out.println("GameLogger: Requesting permissions via Activity " + java.util.Arrays.toString(permissions));
                    reqPerm.invoke(activity, (Object) permissions, Integer.valueOf(9001));
                } else {
                    System.out.println("GameLogger: Permissions already granted " + java.util.Arrays.toString(permissions));
                }
            } catch (Throwable fallbackEx) {
                System.out.println("GameLogger: No valid requestPermissions found, fallback failed: " + fallbackEx.getMessage());
            }
        } catch (Throwable ex) {
            System.err.println("Error requesting Android permissions via reflection: " + ex.getMessage());
            ex.printStackTrace(System.err);
        }
    }
}
