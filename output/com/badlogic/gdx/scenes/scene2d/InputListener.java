/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.Null;

public class InputListener
implements EventListener {
    private static final Vector2 tmpCoords = new Vector2();

    @Override
    public boolean handle(Event e) {
        if (!(e instanceof InputEvent)) {
            return false;
        }
        InputEvent event = (InputEvent)e;
        switch (event.getType()) {
            case keyDown: {
                return this.keyDown(event, event.getKeyCode());
            }
            case keyUp: {
                return this.keyUp(event, event.getKeyCode());
            }
            case keyTyped: {
                return this.keyTyped(event, event.getCharacter());
            }
        }
        event.toCoordinates(event.getListenerActor(), tmpCoords);
        switch (event.getType()) {
            case touchDown: {
                boolean handled = this.touchDown(event, InputListener.tmpCoords.x, InputListener.tmpCoords.y, event.getPointer(), event.getButton());
                if (handled && event.getTouchFocus()) {
                    event.getStage().addTouchFocus(this, event.getListenerActor(), event.getTarget(), event.getPointer(), event.getButton());
                }
                return handled;
            }
            case touchUp: {
                this.touchUp(event, InputListener.tmpCoords.x, InputListener.tmpCoords.y, event.getPointer(), event.getButton());
                return true;
            }
            case touchDragged: {
                this.touchDragged(event, InputListener.tmpCoords.x, InputListener.tmpCoords.y, event.getPointer());
                return true;
            }
            case mouseMoved: {
                return this.mouseMoved(event, InputListener.tmpCoords.x, InputListener.tmpCoords.y);
            }
            case scrolled: {
                return this.scrolled(event, InputListener.tmpCoords.x, InputListener.tmpCoords.y, event.getScrollAmountX(), event.getScrollAmountY());
            }
            case enter: {
                this.enter(event, InputListener.tmpCoords.x, InputListener.tmpCoords.y, event.getPointer(), event.getRelatedActor());
                return false;
            }
            case exit: {
                this.exit(event, InputListener.tmpCoords.x, InputListener.tmpCoords.y, event.getPointer(), event.getRelatedActor());
                return false;
            }
        }
        return false;
    }

    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        return false;
    }

    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
    }

    public void touchDragged(InputEvent event, float x, float y, int pointer) {
    }

    public boolean mouseMoved(InputEvent event, float x, float y) {
        return false;
    }

    public void enter(InputEvent event, float x, float y, int pointer, @Null Actor fromActor) {
    }

    public void exit(InputEvent event, float x, float y, int pointer, @Null Actor toActor) {
    }

    public boolean scrolled(InputEvent event, float x, float y, float amountX, float amountY) {
        return false;
    }

    public boolean keyDown(InputEvent event, int keycode) {
        return false;
    }

    public boolean keyUp(InputEvent event, int keycode) {
        return false;
    }

    public boolean keyTyped(InputEvent event, char character) {
        return false;
    }
}

