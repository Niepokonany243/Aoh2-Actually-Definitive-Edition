/*
 * Decompiled with CFR 0.152.
 */
package aoc.kingdoms.lukasz.jakowski;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.GameTaskScheduler;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

public class AA_Game
extends ApplicationAdapter {
    public static AoCGame aocGame = new AoCGame();

    @Override
    public void create() {
        age.of.civilizations2.jakowski.lukasz.GameLogger.init();
        try { age.of.civilizations2.jakowski.lukasz.PerfAnalyzer.clearReportsOnStartup(); } catch (Throwable ignore) {}
        aocGame.create();
        this.initInput();
    }

    @Override
    public void render() {
        aocGame.render();
    }

    @Override
    public void resize(int width, int height) {
        aocGame.resize(width, height);
    }

    private void initInput() {
        aocGame.initInput();
    }

    @Override
    public void resume() {
        aocGame.resume();
        super.resume();
    }

    @Override
    public void pause() {
        aocGame.pause();
        super.pause();
    }

    @Override
    public void dispose() {
        GameTaskScheduler.shutdownAndAwait();
        aocGame.dispose();
        super.dispose();
        Gdx.app.exit();
    }
}

