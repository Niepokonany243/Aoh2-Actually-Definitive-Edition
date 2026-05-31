/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3.audio.mock;

import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.audio.AudioRecorder;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.lwjgl3.audio.Lwjgl3Audio;
import com.badlogic.gdx.backends.lwjgl3.audio.mock.MockAudioDevice;
import com.badlogic.gdx.backends.lwjgl3.audio.mock.MockAudioRecorder;
import com.badlogic.gdx.backends.lwjgl3.audio.mock.MockMusic;
import com.badlogic.gdx.backends.lwjgl3.audio.mock.MockSound;
import com.badlogic.gdx.files.FileHandle;

public class MockAudio
implements Lwjgl3Audio {
    @Override
    public AudioDevice newAudioDevice(int samplingRate, boolean isMono) {
        return new MockAudioDevice();
    }

    @Override
    public AudioRecorder newAudioRecorder(int samplingRate, boolean isMono) {
        return new MockAudioRecorder();
    }

    @Override
    public Sound newSound(FileHandle fileHandle) {
        return new MockSound();
    }

    @Override
    public Music newMusic(FileHandle file) {
        return new MockMusic();
    }

    @Override
    public void update() {
    }

    @Override
    public void dispose() {
    }
}

