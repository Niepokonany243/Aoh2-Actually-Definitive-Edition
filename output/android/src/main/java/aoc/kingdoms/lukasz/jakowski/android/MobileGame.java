package aoc.kingdoms.lukasz.jakowski.android;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.GameLogger;
import age.of.civilizations2.jakowski.lukasz.GameTaskScheduler;
import com.badlogic.gdx.ApplicationAdapter;

/** Android-owned composition root for the mobile runtime. */
public final class MobileGame extends ApplicationAdapter {
    private final AoCGame runtime = new AoCGame();

    @Override
    public void create() {
        GameLogger.init();
        runtime.create();
    }

    @Override
    public void render() {
        runtime.render();
    }

    @Override
    public void resize(int width, int height) {
        runtime.resize(width, height);
    }

    @Override
    public void pause() {
        GameTaskScheduler.pause();
        runtime.pause();
    }

    @Override
    public void resume() {
        GameTaskScheduler.resume();
        runtime.resume();
    }

    @Override
    public void dispose() {
        GameTaskScheduler.shutdownAndAwait();
        runtime.dispose();
    }
}
