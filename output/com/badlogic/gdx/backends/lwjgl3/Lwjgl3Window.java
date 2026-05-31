/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationBase;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Cursor;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3WindowListener;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.SharedLibraryLoader;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWDropCallback;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.glfw.GLFWWindowCloseCallback;
import org.lwjgl.glfw.GLFWWindowFocusCallback;
import org.lwjgl.glfw.GLFWWindowIconifyCallback;
import org.lwjgl.glfw.GLFWWindowMaximizeCallback;
import org.lwjgl.glfw.GLFWWindowRefreshCallback;

public class Lwjgl3Window
implements Disposable {
    private long windowHandle;
    final ApplicationListener listener;
    final Lwjgl3ApplicationBase application;
    private boolean listenerInitialized = false;
    Lwjgl3WindowListener windowListener;
    private Lwjgl3Graphics graphics;
    private Lwjgl3Input input;
    private final Lwjgl3ApplicationConfiguration config;
    private final Array<Runnable> runnables = new Array();
    private final Array<Runnable> executedRunnables = new Array();
    private final IntBuffer tmpBuffer;
    private final IntBuffer tmpBuffer2;
    boolean iconified = false;
    private boolean requestRendering = false;
    private final GLFWWindowFocusCallback focusCallback = new GLFWWindowFocusCallback(){

        @Override
        public void invoke(long windowHandle, final boolean focused) {
            Lwjgl3Window.this.postRunnable(new Runnable(){

                @Override
                public void run() {
                    if (Lwjgl3Window.this.windowListener != null) {
                        if (focused) {
                            Lwjgl3Window.this.windowListener.focusGained();
                        } else {
                            Lwjgl3Window.this.windowListener.focusLost();
                        }
                    }
                }
            });
        }
    };
    private final GLFWWindowIconifyCallback iconifyCallback = new GLFWWindowIconifyCallback(){

        @Override
        public void invoke(long windowHandle, final boolean iconified) {
            Lwjgl3Window.this.postRunnable(new Runnable(){

                @Override
                public void run() {
                    if (Lwjgl3Window.this.windowListener != null) {
                        Lwjgl3Window.this.windowListener.iconified(iconified);
                    }
                    Lwjgl3Window.this.iconified = iconified;
                    if (iconified) {
                        Lwjgl3Window.this.listener.pause();
                    } else {
                        Lwjgl3Window.this.listener.resume();
                    }
                }
            });
        }
    };
    private final GLFWWindowMaximizeCallback maximizeCallback = new GLFWWindowMaximizeCallback(){

        @Override
        public void invoke(long windowHandle, final boolean maximized) {
            Lwjgl3Window.this.postRunnable(new Runnable(){

                @Override
                public void run() {
                    if (Lwjgl3Window.this.windowListener != null) {
                        Lwjgl3Window.this.windowListener.maximized(maximized);
                    }
                }
            });
        }
    };
    private final GLFWWindowCloseCallback closeCallback = new GLFWWindowCloseCallback(){

        @Override
        public void invoke(final long windowHandle) {
            Lwjgl3Window.this.postRunnable(new Runnable(){

                @Override
                public void run() {
                    if (Lwjgl3Window.this.windowListener != null && !Lwjgl3Window.this.windowListener.closeRequested()) {
                        GLFW.glfwSetWindowShouldClose(windowHandle, false);
                    }
                }
            });
        }
    };
    private final GLFWDropCallback dropCallback = new GLFWDropCallback(){

        @Override
        public void invoke(long windowHandle, int count, long names) {
            final String[] files = new String[count];
            for (int i = 0; i < count; ++i) {
                files[i] = 5.getName(names, i);
            }
            Lwjgl3Window.this.postRunnable(new Runnable(){

                @Override
                public void run() {
                    if (Lwjgl3Window.this.windowListener != null) {
                        Lwjgl3Window.this.windowListener.filesDropped(files);
                    }
                }
            });
        }
    };
    private final GLFWWindowRefreshCallback refreshCallback = new GLFWWindowRefreshCallback(){

        @Override
        public void invoke(long windowHandle) {
            Lwjgl3Window.this.postRunnable(new Runnable(){

                @Override
                public void run() {
                    if (Lwjgl3Window.this.windowListener != null) {
                        Lwjgl3Window.this.windowListener.refreshRequested();
                    }
                }
            });
        }
    };

    Lwjgl3Window(ApplicationListener listener, Lwjgl3ApplicationConfiguration config, Lwjgl3ApplicationBase application) {
        this.listener = listener;
        this.windowListener = config.windowListener;
        this.config = config;
        this.application = application;
        this.tmpBuffer = BufferUtils.createIntBuffer(1);
        this.tmpBuffer2 = BufferUtils.createIntBuffer(1);
    }

    void create(long windowHandle) {
        this.windowHandle = windowHandle;
        this.input = this.application.createInput(this);
        this.graphics = new Lwjgl3Graphics(this);
        GLFW.glfwSetWindowFocusCallback(windowHandle, this.focusCallback);
        GLFW.glfwSetWindowIconifyCallback(windowHandle, this.iconifyCallback);
        GLFW.glfwSetWindowMaximizeCallback(windowHandle, this.maximizeCallback);
        GLFW.glfwSetWindowCloseCallback(windowHandle, this.closeCallback);
        GLFW.glfwSetDropCallback(windowHandle, this.dropCallback);
        GLFW.glfwSetWindowRefreshCallback(windowHandle, this.refreshCallback);
        if (this.windowListener != null) {
            this.windowListener.created(this);
        }
    }

    public ApplicationListener getListener() {
        return this.listener;
    }

    public Lwjgl3WindowListener getWindowListener() {
        return this.windowListener;
    }

    public void setWindowListener(Lwjgl3WindowListener listener) {
        this.windowListener = listener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void postRunnable(Runnable runnable) {
        Array<Runnable> array = this.runnables;
        synchronized (array) {
            this.runnables.add(runnable);
        }
    }

    public void setPosition(int x, int y) {
        GLFW.glfwSetWindowPos(this.windowHandle, x, y);
    }

    public int getPositionX() {
        GLFW.glfwGetWindowPos(this.windowHandle, this.tmpBuffer, this.tmpBuffer2);
        return this.tmpBuffer.get(0);
    }

    public int getPositionY() {
        GLFW.glfwGetWindowPos(this.windowHandle, this.tmpBuffer, this.tmpBuffer2);
        return this.tmpBuffer2.get(0);
    }

    public void setVisible(boolean visible) {
        if (visible) {
            GLFW.glfwShowWindow(this.windowHandle);
        } else {
            GLFW.glfwHideWindow(this.windowHandle);
        }
    }

    public void closeWindow() {
        GLFW.glfwSetWindowShouldClose(this.windowHandle, true);
    }

    public void iconifyWindow() {
        GLFW.glfwIconifyWindow(this.windowHandle);
    }

    public void restoreWindow() {
        GLFW.glfwRestoreWindow(this.windowHandle);
    }

    public void maximizeWindow() {
        GLFW.glfwMaximizeWindow(this.windowHandle);
    }

    public void focusWindow() {
        GLFW.glfwFocusWindow(this.windowHandle);
    }

    public void setIcon(Pixmap ... image) {
        Lwjgl3Window.setIcon(this.windowHandle, image);
    }

    static void setIcon(long windowHandle, String[] imagePaths, Files.FileType imageFileType) {
        if (SharedLibraryLoader.isMac) {
            return;
        }
        Pixmap[] pixmaps = new Pixmap[imagePaths.length];
        for (int i = 0; i < imagePaths.length; ++i) {
            pixmaps[i] = new Pixmap(Gdx.files.getFileHandle(imagePaths[i], imageFileType));
        }
        Lwjgl3Window.setIcon(windowHandle, pixmaps);
        for (Pixmap pixmap : pixmaps) {
            pixmap.dispose();
        }
    }

    static void setIcon(long windowHandle, Pixmap[] images) {
        if (SharedLibraryLoader.isMac) {
            return;
        }
        GLFWImage.Buffer buffer = GLFWImage.malloc(images.length);
        Pixmap[] tmpPixmaps = new Pixmap[images.length];
        for (int i = 0; i < images.length; ++i) {
            Pixmap pixmap = images[i];
            if (pixmap.getFormat() != Pixmap.Format.RGBA8888) {
                Pixmap rgba = new Pixmap(pixmap.getWidth(), pixmap.getHeight(), Pixmap.Format.RGBA8888);
                rgba.setBlending(Pixmap.Blending.None);
                rgba.drawPixmap(pixmap, 0, 0);
                tmpPixmaps[i] = rgba;
                pixmap = rgba;
            }
            GLFWImage icon = GLFWImage.malloc();
            icon.set(pixmap.getWidth(), pixmap.getHeight(), pixmap.getPixels());
            buffer.put(icon);
            icon.free();
        }
        buffer.position(0);
        GLFW.glfwSetWindowIcon(windowHandle, buffer);
        buffer.free();
        for (Pixmap pixmap : tmpPixmaps) {
            if (pixmap == null) continue;
            pixmap.dispose();
        }
    }

    public void setTitle(CharSequence title) {
        GLFW.glfwSetWindowTitle(this.windowHandle, title);
    }

    public void setSizeLimits(int minWidth, int minHeight, int maxWidth, int maxHeight) {
        Lwjgl3Window.setSizeLimits(this.windowHandle, minWidth, minHeight, maxWidth, maxHeight);
    }

    static void setSizeLimits(long windowHandle, int minWidth, int minHeight, int maxWidth, int maxHeight) {
        GLFW.glfwSetWindowSizeLimits(windowHandle, minWidth > -1 ? minWidth : -1, minHeight > -1 ? minHeight : -1, maxWidth > -1 ? maxWidth : -1, maxHeight > -1 ? maxHeight : -1);
    }

    Lwjgl3Graphics getGraphics() {
        return this.graphics;
    }

    Lwjgl3Input getInput() {
        return this.input;
    }

    public long getWindowHandle() {
        return this.windowHandle;
    }

    void windowHandleChanged(long windowHandle) {
        this.windowHandle = windowHandle;
        this.input.windowHandleChanged(windowHandle);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean update() {
        boolean bl;
        if (!this.listenerInitialized) {
            this.initializeListener();
        }
        Array<Runnable> array = this.runnables;
        synchronized (array) {
            this.executedRunnables.addAll(this.runnables);
            this.runnables.clear();
        }
        for (Runnable runnable : this.executedRunnables) {
            runnable.run();
        }
        boolean shouldRender = this.executedRunnables.size > 0 || this.graphics.isContinuousRendering();
        this.executedRunnables.clear();
        if (!this.iconified) {
            this.input.update();
        }
        Lwjgl3Window lwjgl3Window = this;
        synchronized (lwjgl3Window) {
            bl = this.requestRendering && !this.iconified;
            this.requestRendering = false;
        }
        if (shouldRender |= bl) {
            this.graphics.update();
            this.listener.render();
            GLFW.glfwSwapBuffers(this.windowHandle);
        }
        if (!this.iconified) {
            this.input.prepareNext();
        }
        return shouldRender;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void requestRendering() {
        Lwjgl3Window lwjgl3Window = this;
        synchronized (lwjgl3Window) {
            this.requestRendering = true;
        }
    }

    boolean shouldClose() {
        return GLFW.glfwWindowShouldClose(this.windowHandle);
    }

    Lwjgl3ApplicationConfiguration getConfig() {
        return this.config;
    }

    boolean isListenerInitialized() {
        return this.listenerInitialized;
    }

    void initializeListener() {
        if (!this.listenerInitialized) {
            this.listener.create();
            this.listener.resize(this.graphics.getWidth(), this.graphics.getHeight());
            this.listenerInitialized = true;
        }
    }

    void makeCurrent() {
        Gdx.graphics = this.graphics;
        Gdx.gl30 = this.graphics.getGL30();
        Gdx.gl20 = Gdx.gl30 != null ? Gdx.gl30 : this.graphics.getGL20();
        Gdx.gl = Gdx.gl30 != null ? Gdx.gl30 : Gdx.gl20;
        Gdx.input = this.input;
        GLFW.glfwMakeContextCurrent(this.windowHandle);
    }

    @Override
    public void dispose() {
        this.listener.pause();
        this.listener.dispose();
        Lwjgl3Cursor.dispose(this);
        this.graphics.dispose();
        this.input.dispose();
        GLFW.glfwSetWindowFocusCallback(this.windowHandle, null);
        GLFW.glfwSetWindowIconifyCallback(this.windowHandle, null);
        GLFW.glfwSetWindowCloseCallback(this.windowHandle, null);
        GLFW.glfwSetDropCallback(this.windowHandle, null);
        GLFW.glfwDestroyWindow(this.windowHandle);
        this.focusCallback.free();
        this.iconifyCallback.free();
        this.maximizeCallback.free();
        this.closeCallback.free();
        this.dropCallback.free();
        this.refreshCallback.free();
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + (int)(this.windowHandle ^ this.windowHandle >>> 32);
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Lwjgl3Window other = (Lwjgl3Window)obj;
        return this.windowHandle == other.windowHandle;
    }
}

