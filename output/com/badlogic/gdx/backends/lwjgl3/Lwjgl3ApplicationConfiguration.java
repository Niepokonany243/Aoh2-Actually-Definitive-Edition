/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3WindowConfiguration;
import com.badlogic.gdx.graphics.glutils.HdpiMode;
import java.io.PrintStream;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;

public class Lwjgl3ApplicationConfiguration
extends Lwjgl3WindowConfiguration {
    boolean disableAudio = false;
    int maxNetThreads = Integer.MAX_VALUE;
    int audioDeviceSimultaneousSources = 16;
    int audioDeviceBufferSize = 512;
    int audioDeviceBufferCount = 9;
    boolean useGL30 = false;
    int gles30ContextMajorVersion = 3;
    int gles30ContextMinorVersion = 2;
    int r = 8;
    int g = 8;
    int b = 8;
    int a = 8;
    int depth = 16;
    int stencil = 0;
    int samples = 0;
    boolean transparentFramebuffer;
    int idleFPS = 60;
    int foregroundFPS = 0;
    String preferencesDirectory = ".prefs/";
    Files.FileType preferencesFileType = Files.FileType.External;
    HdpiMode hdpiMode = HdpiMode.Logical;
    boolean debug = false;
    PrintStream debugStream = System.err;

    static Lwjgl3ApplicationConfiguration copy(Lwjgl3ApplicationConfiguration config) {
        Lwjgl3ApplicationConfiguration copy = new Lwjgl3ApplicationConfiguration();
        copy.set(config);
        return copy;
    }

    void set(Lwjgl3ApplicationConfiguration config) {
        super.setWindowConfiguration(config);
        this.disableAudio = config.disableAudio;
        this.audioDeviceSimultaneousSources = config.audioDeviceSimultaneousSources;
        this.audioDeviceBufferSize = config.audioDeviceBufferSize;
        this.audioDeviceBufferCount = config.audioDeviceBufferCount;
        this.useGL30 = config.useGL30;
        this.gles30ContextMajorVersion = config.gles30ContextMajorVersion;
        this.gles30ContextMinorVersion = config.gles30ContextMinorVersion;
        this.r = config.r;
        this.g = config.g;
        this.b = config.b;
        this.a = config.a;
        this.depth = config.depth;
        this.stencil = config.stencil;
        this.samples = config.samples;
        this.transparentFramebuffer = config.transparentFramebuffer;
        this.idleFPS = config.idleFPS;
        this.foregroundFPS = config.foregroundFPS;
        this.preferencesDirectory = config.preferencesDirectory;
        this.preferencesFileType = config.preferencesFileType;
        this.hdpiMode = config.hdpiMode;
        this.debug = config.debug;
        this.debugStream = config.debugStream;
    }

    @Override
    public void setInitialVisible(boolean visibility) {
        this.initialVisible = visibility;
    }

    public void disableAudio(boolean disableAudio) {
        this.disableAudio = disableAudio;
    }

    public void setMaxNetThreads(int maxNetThreads) {
        this.maxNetThreads = maxNetThreads;
    }

    public void setAudioConfig(int simultaniousSources, int bufferSize, int bufferCount) {
        this.audioDeviceSimultaneousSources = simultaniousSources;
        this.audioDeviceBufferSize = bufferSize;
        this.audioDeviceBufferCount = bufferCount;
    }

    public void useOpenGL3(boolean useGL30, int gles3MajorVersion, int gles3MinorVersion) {
        this.useGL30 = useGL30;
        this.gles30ContextMajorVersion = gles3MajorVersion;
        this.gles30ContextMinorVersion = gles3MinorVersion;
    }

    public void setBackBufferConfig(int r, int g, int b, int a, int depth, int stencil, int samples) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        this.depth = depth;
        this.stencil = stencil;
        this.samples = samples;
    }

    @Deprecated
    public void setTransparentFramebuffer(boolean transparentFramebuffer) {
        this.transparentFramebuffer = transparentFramebuffer;
    }

    public void setIdleFPS(int fps) {
        this.idleFPS = fps;
    }

    public void setForegroundFPS(int fps) {
        this.foregroundFPS = fps;
    }

    public void setPreferencesConfig(String preferencesDirectory, Files.FileType preferencesFileType) {
        this.preferencesDirectory = preferencesDirectory;
        this.preferencesFileType = preferencesFileType;
    }

    public void setHdpiMode(HdpiMode mode) {
        this.hdpiMode = mode;
    }

    public void enableGLDebugOutput(boolean enable, PrintStream debugOutputStream) {
        this.debug = enable;
        this.debugStream = debugOutputStream;
    }

    public static Graphics.DisplayMode getDisplayMode() {
        Lwjgl3Application.initializeGlfw();
        GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        return new Lwjgl3Graphics.Lwjgl3DisplayMode(GLFW.glfwGetPrimaryMonitor(), videoMode.width(), videoMode.height(), videoMode.refreshRate(), videoMode.redBits() + videoMode.greenBits() + videoMode.blueBits());
    }

    public static Graphics.DisplayMode getDisplayMode(Graphics.Monitor monitor) {
        Lwjgl3Application.initializeGlfw();
        GLFWVidMode videoMode = GLFW.glfwGetVideoMode(((Lwjgl3Graphics.Lwjgl3Monitor)monitor).monitorHandle);
        return new Lwjgl3Graphics.Lwjgl3DisplayMode(((Lwjgl3Graphics.Lwjgl3Monitor)monitor).monitorHandle, videoMode.width(), videoMode.height(), videoMode.refreshRate(), videoMode.redBits() + videoMode.greenBits() + videoMode.blueBits());
    }

    public static Graphics.DisplayMode[] getDisplayModes() {
        Lwjgl3Application.initializeGlfw();
        GLFWVidMode.Buffer videoModes = GLFW.glfwGetVideoModes(GLFW.glfwGetPrimaryMonitor());
        Graphics.DisplayMode[] result = new Graphics.DisplayMode[videoModes.limit()];
        for (int i = 0; i < result.length; ++i) {
            GLFWVidMode videoMode = (GLFWVidMode)videoModes.get(i);
            result[i] = new Lwjgl3Graphics.Lwjgl3DisplayMode(GLFW.glfwGetPrimaryMonitor(), videoMode.width(), videoMode.height(), videoMode.refreshRate(), videoMode.redBits() + videoMode.greenBits() + videoMode.blueBits());
        }
        return result;
    }

    public static Graphics.DisplayMode[] getDisplayModes(Graphics.Monitor monitor) {
        Lwjgl3Application.initializeGlfw();
        GLFWVidMode.Buffer videoModes = GLFW.glfwGetVideoModes(((Lwjgl3Graphics.Lwjgl3Monitor)monitor).monitorHandle);
        Graphics.DisplayMode[] result = new Graphics.DisplayMode[videoModes.limit()];
        for (int i = 0; i < result.length; ++i) {
            GLFWVidMode videoMode = (GLFWVidMode)videoModes.get(i);
            result[i] = new Lwjgl3Graphics.Lwjgl3DisplayMode(((Lwjgl3Graphics.Lwjgl3Monitor)monitor).monitorHandle, videoMode.width(), videoMode.height(), videoMode.refreshRate(), videoMode.redBits() + videoMode.greenBits() + videoMode.blueBits());
        }
        return result;
    }

    public static Graphics.Monitor getPrimaryMonitor() {
        Lwjgl3Application.initializeGlfw();
        return Lwjgl3ApplicationConfiguration.toLwjgl3Monitor(GLFW.glfwGetPrimaryMonitor());
    }

    public static Graphics.Monitor[] getMonitors() {
        Lwjgl3Application.initializeGlfw();
        PointerBuffer glfwMonitors = GLFW.glfwGetMonitors();
        Graphics.Monitor[] monitors = new Graphics.Monitor[glfwMonitors.limit()];
        for (int i = 0; i < glfwMonitors.limit(); ++i) {
            monitors[i] = Lwjgl3ApplicationConfiguration.toLwjgl3Monitor(glfwMonitors.get(i));
        }
        return monitors;
    }

    static Lwjgl3Graphics.Lwjgl3Monitor toLwjgl3Monitor(long glfwMonitor) {
        IntBuffer tmp = BufferUtils.createIntBuffer(1);
        IntBuffer tmp2 = BufferUtils.createIntBuffer(1);
        GLFW.glfwGetMonitorPos(glfwMonitor, tmp, tmp2);
        int virtualX = tmp.get(0);
        int virtualY = tmp2.get(0);
        String name = GLFW.glfwGetMonitorName(glfwMonitor);
        return new Lwjgl3Graphics.Lwjgl3Monitor(glfwMonitor, virtualX, virtualY, name);
    }
}

