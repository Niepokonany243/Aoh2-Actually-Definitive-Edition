/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3WindowListener;
import com.badlogic.gdx.graphics.Color;
import java.util.Arrays;

public class Lwjgl3WindowConfiguration {
    int windowX = -1;
    int windowY = -1;
    int windowWidth = 640;
    int windowHeight = 480;
    int windowMinWidth = -1;
    int windowMinHeight = -1;
    int windowMaxWidth = -1;
    int windowMaxHeight = -1;
    boolean windowResizable = true;
    boolean windowDecorated = true;
    boolean windowMaximized = false;
    Lwjgl3Graphics.Lwjgl3Monitor maximizedMonitor;
    boolean autoIconify = true;
    Files.FileType windowIconFileType;
    String[] windowIconPaths;
    Lwjgl3WindowListener windowListener;
    Lwjgl3Graphics.Lwjgl3DisplayMode fullscreenMode;
    String title;
    Color initialBackgroundColor = Color.BLACK;
    boolean initialVisible = true;
    boolean vSyncEnabled = true;

    void setWindowConfiguration(Lwjgl3WindowConfiguration config) {
        this.windowX = config.windowX;
        this.windowY = config.windowY;
        this.windowWidth = config.windowWidth;
        this.windowHeight = config.windowHeight;
        this.windowMinWidth = config.windowMinWidth;
        this.windowMinHeight = config.windowMinHeight;
        this.windowMaxWidth = config.windowMaxWidth;
        this.windowMaxHeight = config.windowMaxHeight;
        this.windowResizable = config.windowResizable;
        this.windowDecorated = config.windowDecorated;
        this.windowMaximized = config.windowMaximized;
        this.maximizedMonitor = config.maximizedMonitor;
        this.autoIconify = config.autoIconify;
        this.windowIconFileType = config.windowIconFileType;
        if (config.windowIconPaths != null) {
            this.windowIconPaths = Arrays.copyOf(config.windowIconPaths, config.windowIconPaths.length);
        }
        this.windowListener = config.windowListener;
        this.fullscreenMode = config.fullscreenMode;
        this.title = config.title;
        this.initialBackgroundColor = config.initialBackgroundColor;
        this.initialVisible = config.initialVisible;
        this.vSyncEnabled = config.vSyncEnabled;
    }

    public void setInitialVisible(boolean visibility) {
        this.initialVisible = visibility;
    }

    public void setWindowedMode(int width, int height) {
        this.windowWidth = width;
        this.windowHeight = height;
    }

    public void setResizable(boolean resizable) {
        this.windowResizable = resizable;
    }

    public void setDecorated(boolean decorated) {
        this.windowDecorated = decorated;
    }

    public void setMaximized(boolean maximized) {
        this.windowMaximized = maximized;
    }

    public void setMaximizedMonitor(Graphics.Monitor monitor) {
        this.maximizedMonitor = (Lwjgl3Graphics.Lwjgl3Monitor)monitor;
    }

    public void setAutoIconify(boolean autoIconify) {
        this.autoIconify = autoIconify;
    }

    public void setWindowPosition(int x, int y) {
        this.windowX = x;
        this.windowY = y;
    }

    public void setWindowSizeLimits(int minWidth, int minHeight, int maxWidth, int maxHeight) {
        this.windowMinWidth = minWidth;
        this.windowMinHeight = minHeight;
        this.windowMaxWidth = maxWidth;
        this.windowMaxHeight = maxHeight;
    }

    public void setWindowIcon(String ... filePaths) {
        this.setWindowIcon(Files.FileType.Internal, filePaths);
    }

    public void setWindowIcon(Files.FileType fileType, String ... filePaths) {
        this.windowIconFileType = fileType;
        this.windowIconPaths = filePaths;
    }

    public void setWindowListener(Lwjgl3WindowListener windowListener) {
        this.windowListener = windowListener;
    }

    public void setFullscreenMode(Graphics.DisplayMode mode) {
        this.fullscreenMode = (Lwjgl3Graphics.Lwjgl3DisplayMode)mode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInitialBackgroundColor(Color color) {
        this.initialBackgroundColor = color;
    }

    public void useVsync(boolean vsync) {
        this.vSyncEnabled = vsync;
    }
}

