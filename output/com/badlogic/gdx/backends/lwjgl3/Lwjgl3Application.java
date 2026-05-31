/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.ApplicationLogger;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.backends.lwjgl3.DefaultLwjgl3Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationBase;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationLogger;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Clipboard;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Cursor;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3FileHandle;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3NativesLoader;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Net;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Preferences;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3WindowConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Sync;
import com.badlogic.gdx.backends.lwjgl3.audio.Lwjgl3Audio;
import com.badlogic.gdx.backends.lwjgl3.audio.OpenALLwjgl3Audio;
import com.badlogic.gdx.backends.lwjgl3.audio.mock.MockAudio;
import com.badlogic.gdx.graphics.glutils.GLVersion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Clipboard;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.SharedLibraryLoader;
import java.io.File;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.AMDDebugOutput;
import org.lwjgl.opengl.ARBDebugOutput;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL43;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLUtil;
import org.lwjgl.opengl.KHRDebug;
import org.lwjgl.system.Callback;

public class Lwjgl3Application
implements Lwjgl3ApplicationBase {
    private final Lwjgl3ApplicationConfiguration config;
    final Array<Lwjgl3Window> windows = new Array();
    private volatile Lwjgl3Window currentWindow;
    private Lwjgl3Audio audio;
    private final Files files;
    private final Net net;
    private final ObjectMap<String, Preferences> preferences = new ObjectMap();
    private final Lwjgl3Clipboard clipboard;
    private int logLevel = 2;
    private ApplicationLogger applicationLogger;
    private volatile boolean running = true;
    private final Array<Runnable> runnables = new Array();
    private final Array<Runnable> executedRunnables = new Array();
    private final Array<LifecycleListener> lifecycleListeners = new Array();
    private static GLFWErrorCallback errorCallback;
    private static GLVersion glVersion;
    private static Callback glDebugCallback;
    private final Sync sync;

    static void initializeGlfw() {
        if (errorCallback == null) {
            Lwjgl3NativesLoader.load();
            errorCallback = GLFWErrorCallback.createPrint(System.err);
            GLFW.glfwSetErrorCallback(errorCallback);
            GLFW.glfwInitHint(327681, 0);
            if (!GLFW.glfwInit()) {
                throw new GdxRuntimeException("Unable to initialize GLFW");
            }
        }
    }

    public Lwjgl3Application(ApplicationListener listener, Lwjgl3ApplicationConfiguration config) {
        Lwjgl3Application.initializeGlfw();
        this.setApplicationLogger(new Lwjgl3ApplicationLogger());
        if (config.title == null) {
            config.title = listener.getClass().getSimpleName();
        }
        this.config = config = Lwjgl3ApplicationConfiguration.copy(config);
        Gdx.app = this;
        if (!config.disableAudio) {
            try {
                this.audio = this.createAudio(config);
            }
            catch (Throwable t) {
                this.log("Lwjgl3Application", "Couldn't initialize audio, disabling audio", t);
                this.audio = new MockAudio();
            }
        } else {
            this.audio = new MockAudio();
        }
        Gdx.audio = this.audio;
        this.files = Gdx.files = this.createFiles();
        this.net = Gdx.net = new Lwjgl3Net(config);
        this.clipboard = new Lwjgl3Clipboard();
        this.sync = new Sync();
        Lwjgl3Window window = this.createWindow(config, listener, 0L);
        this.windows.add(window);
        try {
            this.loop();
            this.cleanupWindows();
        }
        catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            throw new GdxRuntimeException(t);
        }
        finally {
            this.cleanup();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void loop() {
        Array<Lwjgl3Window> closedWindows = new Array<Lwjgl3Window>();
        while (this.running && this.windows.size > 0) {
            boolean shouldRequestRendering;
            this.audio.update();
            boolean haveWindowsRendered = false;
            closedWindows.clear();
            int targetFramerate = -2;
            for (Lwjgl3Window window : this.windows) {
                window.makeCurrent();
                this.currentWindow = window;
                if (targetFramerate == -2) {
                    targetFramerate = window.getConfig().foregroundFPS;
                }
                Array<LifecycleListener> array = this.lifecycleListeners;
                synchronized (array) {
                    haveWindowsRendered |= window.update();
                }
                if (!window.shouldClose()) continue;
                closedWindows.add(window);
            }
            GLFW.glfwPollEvents();
            Array<Runnable> array = this.runnables;
            synchronized (array) {
                shouldRequestRendering = this.runnables.size > 0;
                this.executedRunnables.clear();
                this.executedRunnables.addAll(this.runnables);
                this.runnables.clear();
            }
            for (Runnable runnable : this.executedRunnables) {
                runnable.run();
            }
            if (shouldRequestRendering) {
                for (Lwjgl3Window window : this.windows) {
                    if (window.getGraphics().isContinuousRendering()) continue;
                    window.requestRendering();
                }
            }
            for (Lwjgl3Window closedWindow : closedWindows) {
                if (this.windows.size == 1) {
                    for (int i = this.lifecycleListeners.size - 1; i >= 0; --i) {
                        LifecycleListener l = this.lifecycleListeners.get(i);
                        l.pause();
                        l.dispose();
                    }
                    this.lifecycleListeners.clear();
                }
                closedWindow.dispose();
                this.windows.removeValue(closedWindow, false);
            }
            if (!haveWindowsRendered) {
                try {
                    Thread.sleep(1000 / this.config.idleFPS);
                }
                catch (InterruptedException interruptedException) {}
                continue;
            }
            if (targetFramerate <= 0) continue;
            this.sync.sync(targetFramerate);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void cleanupWindows() {
        Array<LifecycleListener> array = this.lifecycleListeners;
        synchronized (array) {
            for (LifecycleListener lifecycleListener : this.lifecycleListeners) {
                lifecycleListener.pause();
                lifecycleListener.dispose();
            }
        }
        for (Lwjgl3Window window : this.windows) {
            window.dispose();
        }
        this.windows.clear();
    }

    protected void cleanup() {
        Lwjgl3Cursor.disposeSystemCursors();
        this.audio.dispose();
        errorCallback.free();
        errorCallback = null;
        if (glDebugCallback != null) {
            glDebugCallback.free();
            glDebugCallback = null;
        }
        GLFW.glfwTerminate();
    }

    @Override
    public ApplicationListener getApplicationListener() {
        return this.currentWindow.getListener();
    }

    @Override
    public Graphics getGraphics() {
        return this.currentWindow.getGraphics();
    }

    @Override
    public Audio getAudio() {
        return this.audio;
    }

    @Override
    public Input getInput() {
        return this.currentWindow.getInput();
    }

    @Override
    public Files getFiles() {
        return this.files;
    }

    @Override
    public Net getNet() {
        return this.net;
    }

    @Override
    public void debug(String tag, String message) {
        if (this.logLevel >= 3) {
            this.getApplicationLogger().debug(tag, message);
        }
    }

    @Override
    public void debug(String tag, String message, Throwable exception) {
        if (this.logLevel >= 3) {
            this.getApplicationLogger().debug(tag, message, exception);
        }
    }

    @Override
    public void log(String tag, String message) {
        if (this.logLevel >= 2) {
            this.getApplicationLogger().log(tag, message);
        }
    }

    @Override
    public void log(String tag, String message, Throwable exception) {
        if (this.logLevel >= 2) {
            this.getApplicationLogger().log(tag, message, exception);
        }
    }

    @Override
    public void error(String tag, String message) {
        if (this.logLevel >= 1) {
            this.getApplicationLogger().error(tag, message);
        }
    }

    @Override
    public void error(String tag, String message, Throwable exception) {
        if (this.logLevel >= 1) {
            this.getApplicationLogger().error(tag, message, exception);
        }
    }

    @Override
    public void setLogLevel(int logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public int getLogLevel() {
        return this.logLevel;
    }

    @Override
    public void setApplicationLogger(ApplicationLogger applicationLogger) {
        this.applicationLogger = applicationLogger;
    }

    @Override
    public ApplicationLogger getApplicationLogger() {
        return this.applicationLogger;
    }

    @Override
    public Application.ApplicationType getType() {
        return Application.ApplicationType.Desktop;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public long getJavaHeap() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    @Override
    public long getNativeHeap() {
        return this.getJavaHeap();
    }

    @Override
    public Preferences getPreferences(String name) {
        if (this.preferences.containsKey(name)) {
            return this.preferences.get(name);
        }
        Lwjgl3Preferences prefs = new Lwjgl3Preferences(new Lwjgl3FileHandle(new File(this.config.preferencesDirectory, name), this.config.preferencesFileType));
        this.preferences.put(name, prefs);
        return prefs;
    }

    @Override
    public Clipboard getClipboard() {
        return this.clipboard;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void postRunnable(Runnable runnable) {
        Array<Runnable> array = this.runnables;
        synchronized (array) {
            this.runnables.add(runnable);
        }
    }

    @Override
    public void exit() {
        this.running = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addLifecycleListener(LifecycleListener listener) {
        Array<LifecycleListener> array = this.lifecycleListeners;
        synchronized (array) {
            this.lifecycleListeners.add(listener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeLifecycleListener(LifecycleListener listener) {
        Array<LifecycleListener> array = this.lifecycleListeners;
        synchronized (array) {
            this.lifecycleListeners.removeValue(listener, true);
        }
    }

    @Override
    public Lwjgl3Audio createAudio(Lwjgl3ApplicationConfiguration config) {
        return new OpenALLwjgl3Audio(config.audioDeviceSimultaneousSources, config.audioDeviceBufferCount, config.audioDeviceBufferSize);
    }

    @Override
    public Lwjgl3Input createInput(Lwjgl3Window window) {
        return new DefaultLwjgl3Input(window);
    }

    protected Files createFiles() {
        return new Lwjgl3Files();
    }

    public Lwjgl3Window newWindow(ApplicationListener listener, Lwjgl3WindowConfiguration config) {
        Lwjgl3ApplicationConfiguration appConfig = Lwjgl3ApplicationConfiguration.copy(this.config);
        appConfig.setWindowConfiguration(config);
        return this.createWindow(appConfig, listener, this.windows.get(0).getWindowHandle());
    }

    private Lwjgl3Window createWindow(final Lwjgl3ApplicationConfiguration config, ApplicationListener listener, final long sharedContext) {
        final Lwjgl3Window window = new Lwjgl3Window(listener, config, this);
        if (sharedContext == 0L) {
            this.createWindow(window, config, sharedContext);
        } else {
            this.postRunnable(new Runnable(){

                @Override
                public void run() {
                    Lwjgl3Application.this.createWindow(window, config, sharedContext);
                    Lwjgl3Application.this.windows.add(window);
                }
            });
        }
        return window;
    }

    void createWindow(Lwjgl3Window window, Lwjgl3ApplicationConfiguration config, long sharedContext) {
        long windowHandle = Lwjgl3Application.createGlfwWindow(config, sharedContext);
        window.create(windowHandle);
        window.setVisible(config.initialVisible);
        for (int i = 0; i < 2; ++i) {
            GL11.glClearColor(config.initialBackgroundColor.r, config.initialBackgroundColor.g, config.initialBackgroundColor.b, config.initialBackgroundColor.a);
            GL11.glClear(16384);
            GLFW.glfwSwapBuffers(windowHandle);
        }
    }

    static long createGlfwWindow(Lwjgl3ApplicationConfiguration config, long sharedContextWindow) {
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(131076, 0);
        GLFW.glfwWindowHint(131075, config.windowResizable ? 1 : 0);
        GLFW.glfwWindowHint(131080, config.windowMaximized ? 1 : 0);
        GLFW.glfwWindowHint(131078, config.autoIconify ? 1 : 0);
        GLFW.glfwWindowHint(135169, config.r);
        GLFW.glfwWindowHint(135170, config.g);
        GLFW.glfwWindowHint(135171, config.b);
        GLFW.glfwWindowHint(135172, config.a);
        GLFW.glfwWindowHint(135174, config.stencil);
        GLFW.glfwWindowHint(135173, config.depth);
        GLFW.glfwWindowHint(135181, config.samples);
        if (config.useGL30) {
            GLFW.glfwWindowHint(139266, config.gles30ContextMajorVersion);
            GLFW.glfwWindowHint(139267, config.gles30ContextMinorVersion);
            if (SharedLibraryLoader.isMac) {
                GLFW.glfwWindowHint(139270, 1);
                GLFW.glfwWindowHint(139272, 204801);
            }
        }
        if (config.transparentFramebuffer) {
            GLFW.glfwWindowHint(131082, 1);
        }
        if (config.debug) {
            GLFW.glfwWindowHint(139271, 1);
        }
        long windowHandle = 0L;
        if (config.fullscreenMode != null) {
            GLFW.glfwWindowHint(135183, config.fullscreenMode.refreshRate);
            windowHandle = GLFW.glfwCreateWindow(config.fullscreenMode.width, config.fullscreenMode.height, config.title, config.fullscreenMode.getMonitor(), sharedContextWindow);
        } else {
            GLFW.glfwWindowHint(131077, config.windowDecorated ? 1 : 0);
            windowHandle = GLFW.glfwCreateWindow(config.windowWidth, config.windowHeight, config.title, 0L, sharedContextWindow);
        }
        if (windowHandle == 0L) {
            throw new GdxRuntimeException("Couldn't create window");
        }
        Lwjgl3Window.setSizeLimits(windowHandle, config.windowMinWidth, config.windowMinHeight, config.windowMaxWidth, config.windowMaxHeight);
        if (config.fullscreenMode == null) {
            if (config.windowX == -1 && config.windowY == -1) {
                int windowWidth = Math.max(config.windowWidth, config.windowMinWidth);
                int windowHeight = Math.max(config.windowHeight, config.windowMinHeight);
                if (config.windowMaxWidth > -1) {
                    windowWidth = Math.min(windowWidth, config.windowMaxWidth);
                }
                if (config.windowMaxHeight > -1) {
                    windowHeight = Math.min(windowHeight, config.windowMaxHeight);
                }
                long monitorHandle = GLFW.glfwGetPrimaryMonitor();
                if (config.windowMaximized && config.maximizedMonitor != null) {
                    monitorHandle = config.maximizedMonitor.monitorHandle;
                }
                IntBuffer areaXPos = BufferUtils.createIntBuffer(1);
                IntBuffer areaYPos = BufferUtils.createIntBuffer(1);
                IntBuffer areaWidth = BufferUtils.createIntBuffer(1);
                IntBuffer areaHeight = BufferUtils.createIntBuffer(1);
                GLFW.glfwGetMonitorWorkarea(monitorHandle, areaXPos, areaYPos, areaWidth, areaHeight);
                GLFW.glfwSetWindowPos(windowHandle, areaXPos.get(0) + areaWidth.get(0) / 2 - windowWidth / 2, areaYPos.get(0) + areaHeight.get(0) / 2 - windowHeight / 2);
            } else {
                GLFW.glfwSetWindowPos(windowHandle, config.windowX, config.windowY);
            }
            if (config.windowMaximized) {
                GLFW.glfwMaximizeWindow(windowHandle);
            }
        }
        if (config.windowIconPaths != null) {
            Lwjgl3Window.setIcon(windowHandle, config.windowIconPaths, config.windowIconFileType);
        }
        GLFW.glfwMakeContextCurrent(windowHandle);
        GLFW.glfwSwapInterval(config.vSyncEnabled ? 1 : 0);
        GL.createCapabilities();
        Lwjgl3Application.initiateGL();
        if (!glVersion.isVersionEqualToOrHigher(2, 0)) {
            throw new GdxRuntimeException("OpenGL 2.0 or higher with the FBO extension is required. OpenGL version: " + GL11.glGetString(7938) + "\n" + glVersion.getDebugVersionString());
        }
        if (!Lwjgl3Application.supportsFBO()) {
            throw new GdxRuntimeException("OpenGL 2.0 or higher with the FBO extension is required. OpenGL version: " + GL11.glGetString(7938) + ", FBO extension: false\n" + glVersion.getDebugVersionString());
        }
        if (config.debug) {
            glDebugCallback = GLUtil.setupDebugMessageCallback(config.debugStream);
            Lwjgl3Application.setGLDebugMessageControl(GLDebugMessageSeverity.NOTIFICATION, false);
        }
        return windowHandle;
    }

    private static void initiateGL() {
        String versionString = GL11.glGetString(7938);
        String vendorString = GL11.glGetString(7936);
        String rendererString = GL11.glGetString(7937);
        glVersion = new GLVersion(Application.ApplicationType.Desktop, versionString, vendorString, rendererString);
    }

    private static boolean supportsFBO() {
        return glVersion.isVersionEqualToOrHigher(3, 0) || GLFW.glfwExtensionSupported("GL_EXT_framebuffer_object") || GLFW.glfwExtensionSupported("GL_ARB_framebuffer_object");
    }

    public static boolean setGLDebugMessageControl(GLDebugMessageSeverity severity, boolean enabled) {
        GLCapabilities caps = GL.getCapabilities();
        int GL_DONT_CARE = 4352;
        if (caps.OpenGL43) {
            GL43.glDebugMessageControl(4352, 4352, severity.gl43, (IntBuffer)null, enabled);
            return true;
        }
        if (caps.GL_KHR_debug) {
            KHRDebug.glDebugMessageControl(4352, 4352, severity.khr, (IntBuffer)null, enabled);
            return true;
        }
        if (caps.GL_ARB_debug_output && severity.arb != -1) {
            ARBDebugOutput.glDebugMessageControlARB(4352, 4352, severity.arb, (IntBuffer)null, enabled);
            return true;
        }
        if (caps.GL_AMD_debug_output && severity.amd != -1) {
            AMDDebugOutput.glDebugMessageEnableAMD(4352, severity.amd, (IntBuffer)null, enabled);
            return true;
        }
        return false;
    }

    public static enum GLDebugMessageSeverity {
        HIGH(37190, 37190, 37190, 37190),
        MEDIUM(37191, 37191, 37191, 37191),
        LOW(37192, 37192, 37192, 37192),
        NOTIFICATION(33387, 33387, -1, -1);

        final int gl43;
        final int khr;
        final int arb;
        final int amd;

        private GLDebugMessageSeverity(int gl43, int khr, int arb, int amd) {
            this.gl43 = gl43;
            this.khr = khr;
            this.arb = arb;
            this.amd = amd;
        }
    }
}

