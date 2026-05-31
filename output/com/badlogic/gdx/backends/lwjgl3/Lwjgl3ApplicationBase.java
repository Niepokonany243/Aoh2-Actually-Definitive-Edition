/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;
import com.badlogic.gdx.backends.lwjgl3.audio.Lwjgl3Audio;

public interface Lwjgl3ApplicationBase
extends Application {
    public Lwjgl3Audio createAudio(Lwjgl3ApplicationConfiguration var1);

    public Lwjgl3Input createInput(Lwjgl3Window var1);
}

