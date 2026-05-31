/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.AbstractGraphics;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Cursor;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3GL20;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3GL30;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.glutils.GLVersion;
import com.badlogic.gdx.graphics.glutils.HdpiMode;
import com.badlogic.gdx.utils.Disposable;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;

public class Lwjgl3Graphics
extends AbstractGraphics
implements Disposable {
    final Lwjgl3Window window;
    GL20 gl20;
    private GL30 gl30;
    private GLVersion glVersion;
    private volatile int backBufferWidth;
    private volatile int backBufferHeight;
    private volatile int logicalWidth;
    private volatile int logicalHeight;
    private volatile boolean isContinuous = true;
    private Graphics.BufferFormat bufferFormat;
    private long lastFrameTime = -1L;
    private float deltaTime;
    private long frameId;
    private long frameCounterStart = 0L;
    private int frames;
    private int fps;
    private int windowPosXBeforeFullscreen;
    private int windowPosYBeforeFullscreen;
    private int windowWidthBeforeFullscreen;
    private int windowHeightBeforeFullscreen;
    private Graphics.DisplayMode displayModeBeforeFullscreen = null;
    IntBuffer tmpBuffer = BufferUtils.createIntBuffer(1);
    IntBuffer tmpBuffer2 = BufferUtils.createIntBuffer(1);
    IntBuffer tmpBuffer3 = BufferUtils.createIntBuffer(1);
    IntBuffer tmpBuffer4 = BufferUtils.createIntBuffer(1);
    private GLFWFramebufferSizeCallback resizeCallback = new GLFWFramebufferSizeCallback(){

        @Override
        public void invoke(long windowHandle, int width, int height) {
            Lwjgl3Graphics.this.updateFramebufferInfo();
            if (!Lwjgl3Graphics.this.window.isListenerInitialized()) {
                return;
            }
            Lwjgl3Graphics.this.window.makeCurrent();
            Lwjgl3Graphics.this.gl20.glViewport(0, 0, width, height);
            Lwjgl3Graphics.this.window.getListener().resize(Lwjgl3Graphics.this.getWidth(), Lwjgl3Graphics.this.getHeight());
            Lwjgl3Graphics.this.window.getListener().render();
            GLFW.glfwSwapBuffers(windowHandle);
        }
    };

    public Lwjgl3Graphics(Lwjgl3Window window) {
        this.window = window;
        if (window.getConfig().useGL30) {
            this.gl30 = new Lwjgl3GL30();
            this.gl20 = this.gl30;
        } else {
            this.gl20 = new Lwjgl3GL20();
            this.gl30 = null;
        }
        this.updateFramebufferInfo();
        this.initiateGL();
        GLFW.glfwSetFramebufferSizeCallback(window.getWindowHandle(), this.resizeCallback);
    }

    private void initiateGL() {
        String versionString = this.gl20.glGetString(7938);
        String vendorString = this.gl20.glGetString(7936);
        String rendererString = this.gl20.glGetString(7937);
        this.glVersion = new GLVersion(Application.ApplicationType.Desktop, versionString, vendorString, rendererString);
        if (this.supportsCubeMapSeamless()) {
            this.enableCubeMapSeamless(true);
        }
    }

    public boolean supportsCubeMapSeamless() {
        return this.glVersion.isVersionEqualToOrHigher(3, 2) || this.supportsExtension("GL_ARB_seamless_cube_map");
    }

    public void enableCubeMapSeamless(boolean enable) {
        if (enable) {
            this.gl20.glEnable(34895);
        } else {
            this.gl20.glDisable(34895);
        }
    }

    public Lwjgl3Window getWindow() {
        return this.window;
    }

    void updateFramebufferInfo() {
        GLFW.glfwGetFramebufferSize(this.window.getWindowHandle(), this.tmpBuffer, this.tmpBuffer2);
        this.backBufferWidth = this.tmpBuffer.get(0);
        this.backBufferHeight = this.tmpBuffer2.get(0);
        GLFW.glfwGetWindowSize(this.window.getWindowHandle(), this.tmpBuffer, this.tmpBuffer2);
        this.logicalWidth = this.tmpBuffer.get(0);
        this.logicalHeight = this.tmpBuffer2.get(0);
        Lwjgl3ApplicationConfiguration config = this.window.getConfig();
        this.bufferFormat = new Graphics.BufferFormat(config.r, config.g, config.b, config.a, config.depth, config.stencil, config.samples, false);
    }

    void update() {
        long time = System.nanoTime();
        if (this.lastFrameTime == -1L) {
            this.lastFrameTime = time;
        }
        this.deltaTime = (float)(time - this.lastFrameTime) / 1.0E9f;
        this.lastFrameTime = time;
        if (time - this.frameCounterStart >= 1000000000L) {
            this.fps = this.frames;
            this.frames = 0;
            this.frameCounterStart = time;
        }
        ++this.frames;
        ++this.frameId;
    }

    @Override
    public boolean isGL30Available() {
        return this.gl30 != null;
    }

    @Override
    public GL20 getGL20() {
        return this.gl20;
    }

    @Override
    public GL30 getGL30() {
        return this.gl30;
    }

    @Override
    public void setGL20(GL20 gl20) {
        this.gl20 = gl20;
    }

    @Override
    public void setGL30(GL30 gl30) {
        this.gl30 = gl30;
    }

    @Override
    public int getWidth() {
        if (this.window.getConfig().hdpiMode == HdpiMode.Pixels) {
            return this.backBufferWidth;
        }
        return this.logicalWidth;
    }

    @Override
    public int getHeight() {
        if (this.window.getConfig().hdpiMode == HdpiMode.Pixels) {
            return this.backBufferHeight;
        }
        return this.logicalHeight;
    }

    @Override
    public int getBackBufferWidth() {
        return this.backBufferWidth;
    }

    @Override
    public int getBackBufferHeight() {
        return this.backBufferHeight;
    }

    public int getLogicalWidth() {
        return this.logicalWidth;
    }

    public int getLogicalHeight() {
        return this.logicalHeight;
    }

    @Override
    public long getFrameId() {
        return this.frameId;
    }

    @Override
    public float getDeltaTime() {
        return this.deltaTime;
    }

    @Override
    public int getFramesPerSecond() {
        return this.fps;
    }

    @Override
    public Graphics.GraphicsType getType() {
        return Graphics.GraphicsType.LWJGL3;
    }

    @Override
    public GLVersion getGLVersion() {
        return this.glVersion;
    }

    @Override
    public float getPpiX() {
        return this.getPpcX() * 2.54f;
    }

    @Override
    public float getPpiY() {
        return this.getPpcY() * 2.54f;
    }

    @Override
    public float getPpcX() {
        Lwjgl3Monitor monitor = (Lwjgl3Monitor)this.getMonitor();
        GLFW.glfwGetMonitorPhysicalSize(monitor.monitorHandle, this.tmpBuffer, this.tmpBuffer2);
        int sizeX = this.tmpBuffer.get(0);
        Graphics.DisplayMode mode = this.getDisplayMode();
        return (float)mode.width / (float)sizeX * 10.0f;
    }

    @Override
    public float getPpcY() {
        Lwjgl3Monitor monitor = (Lwjgl3Monitor)this.getMonitor();
        GLFW.glfwGetMonitorPhysicalSize(monitor.monitorHandle, this.tmpBuffer, this.tmpBuffer2);
        int sizeY = this.tmpBuffer2.get(0);
        Graphics.DisplayMode mode = this.getDisplayMode();
        return (float)mode.height / (float)sizeY * 10.0f;
    }

    @Override
    public boolean supportsDisplayModeChange() {
        return true;
    }

    @Override
    public Graphics.Monitor getPrimaryMonitor() {
        return Lwjgl3ApplicationConfiguration.toLwjgl3Monitor(GLFW.glfwGetPrimaryMonitor());
    }

    @Override
    public Graphics.Monitor getMonitor() {
        Graphics.Monitor[] monitors = this.getMonitors();
        Graphics.Monitor result = monitors[0];
        GLFW.glfwGetWindowPos(this.window.getWindowHandle(), this.tmpBuffer, this.tmpBuffer2);
        int windowX = this.tmpBuffer.get(0);
        int windowY = this.tmpBuffer2.get(0);
        GLFW.glfwGetWindowSize(this.window.getWindowHandle(), this.tmpBuffer, this.tmpBuffer2);
        int windowWidth = this.tmpBuffer.get(0);
        int windowHeight = this.tmpBuffer2.get(0);
        int bestOverlap = 0;
        for (Graphics.Monitor monitor : monitors) {
            Graphics.DisplayMode mode = this.getDisplayMode(monitor);
            int overlap = Math.max(0, Math.min(windowX + windowWidth, monitor.virtualX + mode.width) - Math.max(windowX, monitor.virtualX)) * Math.max(0, Math.min(windowY + windowHeight, monitor.virtualY + mode.height) - Math.max(windowY, monitor.virtualY));
            if (bestOverlap >= overlap) continue;
            bestOverlap = overlap;
            result = monitor;
        }
        return result;
    }

    @Override
    public Graphics.Monitor[] getMonitors() {
        PointerBuffer glfwMonitors = GLFW.glfwGetMonitors();
        Graphics.Monitor[] monitors = new Graphics.Monitor[glfwMonitors.limit()];
        for (int i = 0; i < glfwMonitors.limit(); ++i) {
            monitors[i] = Lwjgl3ApplicationConfiguration.toLwjgl3Monitor(glfwMonitors.get(i));
        }
        return monitors;
    }

    @Override
    public Graphics.DisplayMode[] getDisplayModes() {
        return Lwjgl3ApplicationConfiguration.getDisplayModes(this.getMonitor());
    }

    @Override
    public Graphics.DisplayMode[] getDisplayModes(Graphics.Monitor monitor) {
        return Lwjgl3ApplicationConfiguration.getDisplayModes(monitor);
    }

    @Override
    public Graphics.DisplayMode getDisplayMode() {
        return Lwjgl3ApplicationConfiguration.getDisplayMode(this.getMonitor());
    }

    @Override
    public Graphics.DisplayMode getDisplayMode(Graphics.Monitor monitor) {
        return Lwjgl3ApplicationConfiguration.getDisplayMode(monitor);
    }

    @Override
    public int getSafeInsetLeft() {
        return 0;
    }

    @Override
    public int getSafeInsetTop() {
        return 0;
    }

    @Override
    public int getSafeInsetBottom() {
        return 0;
    }

    @Override
    public int getSafeInsetRight() {
        return 0;
    }

    @Override
    public boolean setFullscreenMode(Graphics.DisplayMode displayMode) {
        this.window.getInput().resetPollingStates();
        Lwjgl3DisplayMode newMode = (Lwjgl3DisplayMode)displayMode;
        if (this.isFullscreen()) {
            Lwjgl3DisplayMode currentMode = (Lwjgl3DisplayMode)this.getDisplayMode();
            if (currentMode.getMonitor() == newMode.getMonitor() && currentMode.refreshRate == newMode.refreshRate) {
                GLFW.glfwSetWindowSize(this.window.getWindowHandle(), newMode.width, newMode.height);
            } else {
                GLFW.glfwSetWindowMonitor(this.window.getWindowHandle(), newMode.getMonitor(), 0, 0, newMode.width, newMode.height, newMode.refreshRate);
            }
        } else {
            this.storeCurrentWindowPositionAndDisplayMode();
            GLFW.glfwSetWindowMonitor(this.window.getWindowHandle(), newMode.getMonitor(), 0, 0, newMode.width, newMode.height, newMode.refreshRate);
        }
        this.updateFramebufferInfo();
        this.setVSync(this.window.getConfig().vSyncEnabled);
        return true;
    }

    private void storeCurrentWindowPositionAndDisplayMode() {
        this.windowPosXBeforeFullscreen = this.window.getPositionX();
        this.windowPosYBeforeFullscreen = this.window.getPositionY();
        this.windowWidthBeforeFullscreen = this.logicalWidth;
        this.windowHeightBeforeFullscreen = this.logicalHeight;
        this.displayModeBeforeFullscreen = this.getDisplayMode();
    }

    @Override
    public boolean setWindowedMode(int width, int height) {
        this.window.getInput().resetPollingStates();
        if (!this.isFullscreen()) {
            if (width != this.logicalWidth || height != this.logicalHeight) {
                Lwjgl3Monitor monitor = (Lwjgl3Monitor)this.getMonitor();
                GLFW.glfwGetMonitorWorkarea(monitor.monitorHandle, this.tmpBuffer, this.tmpBuffer2, this.tmpBuffer3, this.tmpBuffer4);
                this.window.setPosition(this.tmpBuffer.get(0) + (this.tmpBuffer3.get(0) - width) / 2, this.tmpBuffer2.get(0) + (this.tmpBuffer4.get(0) - height) / 2);
            }
            GLFW.glfwSetWindowSize(this.window.getWindowHandle(), width, height);
        } else {
            if (this.displayModeBeforeFullscreen == null) {
                this.storeCurrentWindowPositionAndDisplayMode();
            }
            if (width != this.windowWidthBeforeFullscreen || height != this.windowHeightBeforeFullscreen) {
                Lwjgl3Monitor monitor = (Lwjgl3Monitor)this.getMonitor();
                GLFW.glfwGetMonitorWorkarea(monitor.monitorHandle, this.tmpBuffer, this.tmpBuffer2, this.tmpBuffer3, this.tmpBuffer4);
                GLFW.glfwSetWindowMonitor(this.window.getWindowHandle(), 0L, this.tmpBuffer.get(0) + (this.tmpBuffer3.get(0) - width) / 2, this.tmpBuffer2.get(0) + (this.tmpBuffer4.get(0) - height) / 2, width, height, this.displayModeBeforeFullscreen.refreshRate);
            } else {
                GLFW.glfwSetWindowMonitor(this.window.getWindowHandle(), 0L, this.windowPosXBeforeFullscreen, this.windowPosYBeforeFullscreen, width, height, this.displayModeBeforeFullscreen.refreshRate);
            }
        }
        this.updateFramebufferInfo();
        return true;
    }

    @Override
    public void setTitle(String title) {
        if (title == null) {
            title = "";
        }
        GLFW.glfwSetWindowTitle(this.window.getWindowHandle(), title);
    }

    @Override
    public void setUndecorated(boolean undecorated) {
        this.getWindow().getConfig().setDecorated(!undecorated);
        GLFW.glfwSetWindowAttrib(this.window.getWindowHandle(), 131077, undecorated ? 0 : 1);
    }

    @Override
    public void setResizable(boolean resizable) {
        this.getWindow().getConfig().setResizable(resizable);
        GLFW.glfwSetWindowAttrib(this.window.getWindowHandle(), 131075, resizable ? 1 : 0);
    }

    @Override
    public void setVSync(boolean vsync) {
        this.getWindow().getConfig().vSyncEnabled = vsync;
        GLFW.glfwSwapInterval(vsync ? 1 : 0);
    }

    @Override
    public void setForegroundFPS(int fps) {
        this.getWindow().getConfig().foregroundFPS = fps;
    }

    @Override
    public Graphics.BufferFormat getBufferFormat() {
        return this.bufferFormat;
    }

    @Override
    public boolean supportsExtension(String extension) {
        return GLFW.glfwExtensionSupported(extension);
    }

    @Override
    public void setContinuousRendering(boolean isContinuous) {
        this.isContinuous = isContinuous;
    }

    @Override
    public boolean isContinuousRendering() {
        return this.isContinuous;
    }

    @Override
    public void requestRendering() {
        this.window.requestRendering();
    }

    @Override
    public boolean isFullscreen() {
        return GLFW.glfwGetWindowMonitor(this.window.getWindowHandle()) != 0L;
    }

    @Override
    public Cursor newCursor(Pixmap pixmap, int xHotspot, int yHotspot) {
        return new Lwjgl3Cursor(this.getWindow(), pixmap, xHotspot, yHotspot);
    }

    @Override
    public void setCursor(Cursor cursor) {
        GLFW.glfwSetCursor(this.getWindow().getWindowHandle(), ((Lwjgl3Cursor)cursor).glfwCursor);
    }

    @Override
    public void setSystemCursor(Cursor.SystemCursor systemCursor) {
        Lwjgl3Cursor.setSystemCursor(this.getWindow().getWindowHandle(), systemCursor);
    }

    @Override
    public void dispose() {
        this.resizeCallback.free();
    }

    public static class Lwjgl3Monitor
    extends Graphics.Monitor {
        final long monitorHandle;

        Lwjgl3Monitor(long monitor, int virtualX, int virtualY, String name) {
            super(virtualX, virtualY, name);
            this.monitorHandle = monitor;
        }

        public long getMonitorHandle() {
            return this.monitorHandle;
        }
    }

    public static class Lwjgl3DisplayMode
    extends Graphics.DisplayMode {
        final long monitorHandle;

        Lwjgl3DisplayMode(long monitor, int width, int height, int refreshRate, int bitsPerPixel) {
            super(width, height, refreshRate, bitsPerPixel);
            this.monitorHandle = monitor;
        }

        public long getMonitor() {
            return this.monitorHandle;
        }
    }
}

