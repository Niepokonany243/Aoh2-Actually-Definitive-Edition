/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.utils.GdxNativesLoader;

public final class Lwjgl3NativesLoader {
    public static void load() {
        GdxNativesLoader.load();
    }

    static {
        System.setProperty("org.lwjgl.input.Mouse.allowNegativeMouseCoords", "true");
    }
}

