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
        } catch (Exception ex) {
            originalErr.println("Failed to initialize GameLogger: " + ex.getMessage());
            ex.printStackTrace(originalErr);
        }
    }

    private static void requestAndroidPermissions() {
        try {
            
            String[] permissions = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
            
            
            Method requestMethod = null;
            for (Method m : Gdx.app.getClass().getMethods()) {
                if (m.getName().equals("requestPermissions") && m.getParameterTypes().length == 2) {
                    requestMethod = m;
                    break;
                }
            }

            if (requestMethod != null) {
                Class<?> listenerClass = requestMethod.getParameterTypes()[1];
                
                
                Object listenerProxy = Proxy.newProxyInstance(
                    listenerClass.getClassLoader(),
                    new Class<?>[]{listenerClass},
                    (proxy, method, args) -> {
                        if (method.getName().equals("granted")) {
                            System.out.println("Android permissions granted.");
                        } else if (method.getName().equals("rejected")) {
                            System.out.println("Android permissions rejected.");
                        }
                        return null;
                    }
                );

                requestMethod.invoke(Gdx.app, (Object) permissions, listenerProxy);
            }
        } catch (Exception ex) {
            System.err.println("Error requesting Android permissions via reflection: " + ex.getMessage());
        }
    }
}
