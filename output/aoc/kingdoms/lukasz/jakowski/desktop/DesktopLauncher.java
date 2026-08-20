/*
 * Decompiled with CFR 0.152.
 */
package aoc.kingdoms.lukasz.jakowski.desktop;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameTaskScheduler;
import aoc.kingdoms.lukasz.jakowski.AA_Game;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class DesktopLauncher {
    public static void main(String[] arg) {
        int desktopWorkers = Math.max(1, Runtime.getRuntime().availableProcessors() * 2);
        GameTaskScheduler.install(desktopWorkers, Math.max(64, desktopWorkers * 8), "aoh2-desktop");
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Age of History 2: Definitive Edition");
        try {
            config.setWindowIcon(Files.FileType.Internal, "UI/ic_16x16.png");
            config.setWindowIcon(Files.FileType.Internal, "UI/ic_32x32.png");
            config.setWindowIcon(Files.FileType.Internal, "UI/ic_128x128.png");
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        config.setResizable(false);
        int tWidth = -1;
        int tHeight = -1;
        boolean tFullscreen = true;
        int tSamples = -1;
        boolean tValidConfig = false;
        boolean tVSync = false;
        String tOpenGLBackend = "default";
        BufferedReader bfr = null;
        String sLine = "";
        System.out.println("File encoding: " + System.getProperty("file.encoding"));
        try {
            bfr = new BufferedReader(new InputStreamReader(new FileInputStream("settings/config.txt"), StandardCharsets.UTF_8));
            while ((sLine = bfr.readLine()) != null) {
                String[] tempR = sLine.replace(";", "").split("=");
                try {
                    if (tempR[0].equals("FULLSCREEN")) {
                        tFullscreen = Boolean.parseBoolean(tempR[1]);
                        tValidConfig = true;
                        continue;
                    }
                    if (tempR[0].equals("WIDTH")) {
                        tWidth = Integer.parseInt(tempR[1]);
                        tValidConfig = true;
                        continue;
                    }
                    if (tempR[0].equals("HEIGHT")) {
                        tHeight = Integer.parseInt(tempR[1]);
                        tValidConfig = true;
                        continue;
                    }
                    if (tempR[0].equals("ANTIALIASING")) {
                        tSamples = Integer.parseInt(tempR[1]);
                        tValidConfig = true;
                        continue;
                    }
                    if (!tempR[0].equals("VSYNC")) continue;
                    tVSync = Boolean.parseBoolean(tempR[1]);
                    tValidConfig = true;
                }
                catch (Exception ex) {
                    // Skip bad line
                }
                if (sLine.startsWith("OPENGL_BACKEND=")) {
                    try {
                        tOpenGLBackend = sLine.replace(";", "").split("=")[1].trim();
                    }
                    catch (Exception ex2) {
                        // Use default backend on a bad value
                    }
                }
            }
        }
        catch (IOException ex) {
            System.out.println("Config not found or error reading.");
        } finally {
            if (bfr != null) try { bfr.close(); } catch (IOException e) {}
        }
        if (tWidth < 0 && tHeight < 0) {
            config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
        } else {
            config.setWindowedMode(tWidth, tHeight);
            if (tFullscreen) {
                config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
            }
        }
        config.useVsync(tVSync);
        config.setAudioConfig(32, 512, 18);
        config.setForegroundFPS(60);
        if (tOpenGLBackend.equalsIgnoreCase("angle")) {
            config.setOpenGLEmulation(Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES20, 3, 2);
            System.out.println("OpenGL backend: ANGLE (GLES2 over Direct3D)");
        } else {
            System.out.println("OpenGL backend: default (native OpenGL) - set OPENGL_BACKEND=angle in settings/config.txt if OpenGL init fails on this system");
        }
        try {
            new Lwjgl3Application(new AA_Game(), config);
        }
        catch (Throwable ex) {
            System.out.println("Could not start the game window/OpenGL context: " + (ex.getMessage() == null ? ex.toString() : ex.getMessage()));
            System.out.println("If this is an Intel Ivy Bridge (HD 2500/4000) system on Windows 11, set OPENGL_BACKEND=angle in settings/config.txt");
            System.out.println("and make sure libEGL.dll and libGLESv2.dll are present in the game folder and the jre/bin folder. Alternatively place the Mesa software opengl32.dll in jre/bin.");
            CFG.exceptionStack(ex);
            System.exit(1);
        } finally {
            GameTaskScheduler.shutdownAndAwait();
        }
    }
}

