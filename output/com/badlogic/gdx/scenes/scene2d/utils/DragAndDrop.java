/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;

public class DragAndDrop {
    static final Vector2 tmpVector = new Vector2();
    Source dragSource;
    Payload payload;
    Actor dragActor;
    boolean removeDragActor;
    Target target;
    boolean isValidTarget;
    final Array<Target> targets = new Array();
    final ObjectMap<Source, DragListener> sourceListeners = new ObjectMap();
    private float tapSquareSize = 8.0f;
    private int button;
    float dragActorX = 0.0f;
    float dragActorY = 0.0f;
    float touchOffsetX;
    float touchOffsetY;
    long dragValidTime;
    int dragTime = 250;
    int activePointer = -1;
    boolean cancelTouchFocus = true;
    boolean keepWithinStage = true;

    public void addSource(final Source source) {
        DragListener listener = new DragListener(){

            @Override
            public void dragStart(InputEvent event, float x, float y, int pointer) {
                Stage stage;
                if (DragAndDrop.this.activePointer != -1) {
                    event.stop();
                    return;
                }
                DragAndDrop.this.activePointer = pointer;
                DragAndDrop.this.dragValidTime = System.currentTimeMillis() + (long)DragAndDrop.this.dragTime;
                DragAndDrop.this.dragSource = source;
                DragAndDrop.this.payload = source.dragStart(event, this.getTouchDownX(), this.getTouchDownY(), pointer);
                event.stop();
                if (DragAndDrop.this.cancelTouchFocus && DragAndDrop.this.payload != null && (stage = source.getActor().getStage()) != null) {
                    stage.cancelTouchFocusExcept(this, source.getActor());
                }
            }

            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                if (DragAndDrop.this.payload == null) {
                    return;
                }
                if (pointer != DragAndDrop.this.activePointer) {
                    return;
                }
                source.drag(event, x, y, pointer);
                Stage stage = event.getStage();
                Actor oldDragActor = DragAndDrop.this.dragActor;
                float oldDragActorX = 0.0f;
                float oldDragActorY = 0.0f;
                if (oldDragActor != null) {
                    oldDragActorX = oldDragActor.getX();
                    oldDragActorY = oldDragActor.getY();
                    oldDragActor.setPosition(2.1474836E9f, 2.1474836E9f);
                }
                float stageX = event.getStageX() + DragAndDrop.this.touchOffsetX;
                float stageY = event.getStageY() + DragAndDrop.this.touchOffsetY;
                Actor hit = event.getStage().hit(stageX, stageY, true);
                if (hit == null) {
                    hit = event.getStage().hit(stageX, stageY, false);
                }
                if (oldDragActor != null) {
                    oldDragActor.setPosition(oldDragActorX, oldDragActorY);
                }
                Target newTarget = null;
                DragAndDrop.this.isValidTarget = false;
                if (hit != null) {
                    int n = DragAndDrop.this.targets.size;
                    for (int i = 0; i < n; ++i) {
                        Target target = DragAndDrop.this.targets.get(i);
                        if (!target.actor.isAscendantOf(hit)) continue;
                        newTarget = target;
                        target.actor.stageToLocalCoordinates(tmpVector.set(stageX, stageY));
                        break;
                    }
                }
                if (newTarget != DragAndDrop.this.target) {
                    if (DragAndDrop.this.target != null) {
                        DragAndDrop.this.target.reset(source, DragAndDrop.this.payload);
                    }
                    DragAndDrop.this.target = newTarget;
                }
                if (newTarget != null) {
                    DragAndDrop.this.isValidTarget = newTarget.drag(source, DragAndDrop.this.payload, DragAndDrop.tmpVector.x, DragAndDrop.tmpVector.y, pointer);
                }
                Actor actor = null;
                if (DragAndDrop.this.target != null) {
                    Actor actor2 = actor = DragAndDrop.this.isValidTarget ? DragAndDrop.this.payload.validDragActor : DragAndDrop.this.payload.invalidDragActor;
                }
                if (actor == null) {
                    actor = DragAndDrop.this.payload.dragActor;
                }
                if (actor != oldDragActor) {
                    if (oldDragActor != null && DragAndDrop.this.removeDragActor) {
                        oldDragActor.remove();
                    }
                    DragAndDrop.this.dragActor = actor;
                    boolean bl = DragAndDrop.this.removeDragActor = actor.getStage() == null;
                    if (DragAndDrop.this.removeDragActor) {
                        stage.addActor(actor);
                    }
                }
                if (actor == null) {
                    return;
                }
                float actorX = event.getStageX() - actor.getWidth() + DragAndDrop.this.dragActorX;
                float actorY = event.getStageY() + DragAndDrop.this.dragActorY;
                if (DragAndDrop.this.keepWithinStage) {
                    if (actorX < 0.0f) {
                        actorX = 0.0f;
                    }
                    if (actorY < 0.0f) {
                        actorY = 0.0f;
                    }
                    if (actorX + actor.getWidth() > stage.getWidth()) {
                        actorX = stage.getWidth() - actor.getWidth();
                    }
                    if (actorY + actor.getHeight() > stage.getHeight()) {
                        actorY = stage.getHeight() - actor.getHeight();
                    }
                }
                actor.setPosition(actorX, actorY);
            }

            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer) {
                if (pointer != DragAndDrop.this.activePointer) {
                    return;
                }
                DragAndDrop.this.activePointer = -1;
                if (DragAndDrop.this.payload == null) {
                    return;
                }
                if (System.currentTimeMillis() < DragAndDrop.this.dragValidTime) {
                    DragAndDrop.this.isValidTarget = false;
                }
                if (DragAndDrop.this.dragActor != null && DragAndDrop.this.removeDragActor) {
                    DragAndDrop.this.dragActor.remove();
                }
                if (DragAndDrop.this.isValidTarget) {
                    float stageX = event.getStageX() + DragAndDrop.this.touchOffsetX;
                    float stageY = event.getStageY() + DragAndDrop.this.touchOffsetY;
                    DragAndDrop.this.target.actor.stageToLocalCoordinates(tmpVector.set(stageX, stageY));
                    DragAndDrop.this.target.drop(source, DragAndDrop.this.payload, DragAndDrop.tmpVector.x, DragAndDrop.tmpVector.y, pointer);
                }
                source.dragStop(event, x, y, pointer, DragAndDrop.this.payload, DragAndDrop.this.isValidTarget ? DragAndDrop.this.target : null);
                if (DragAndDrop.this.target != null) {
                    DragAndDrop.this.target.reset(source, DragAndDrop.this.payload);
                }
                DragAndDrop.this.dragSource = null;
                DragAndDrop.this.payload = null;
                DragAndDrop.this.target = null;
                DragAndDrop.this.isValidTarget = false;
                DragAndDrop.this.dragActor = null;
            }
        };
        listener.setTapSquareSize(this.tapSquareSize);
        listener.setButton(this.button);
        source.actor.addCaptureListener(listener);
        this.sourceListeners.put(source, listener);
    }

    public void removeSource(Source source) {
        DragListener dragListener = this.sourceListeners.remove(source);
        source.actor.removeCaptureListener(dragListener);
    }

    public void addTarget(Target target) {
        this.targets.add(target);
    }

    public void removeTarget(Target target) {
        this.targets.removeValue(target, true);
    }

    public void clear() {
        this.targets.clear();
        for (ObjectMap.Entry entry : this.sourceListeners.entries()) {
            ((Source)entry.key).actor.removeCaptureListener((EventListener)entry.value);
        }
        this.sourceListeners.clear();
    }

    public void cancelTouchFocusExcept(Source except) {
        DragListener listener = this.sourceListeners.get(except);
        if (listener == null) {
            return;
        }
        Stage stage = except.getActor().getStage();
        if (stage != null) {
            stage.cancelTouchFocusExcept(listener, except.getActor());
        }
    }

    public void setTapSquareSize(float halfTapSquareSize) {
        this.tapSquareSize = halfTapSquareSize;
    }

    public void setButton(int button) {
        this.button = button;
    }

    public void setDragActorPosition(float dragActorX, float dragActorY) {
        this.dragActorX = dragActorX;
        this.dragActorY = dragActorY;
    }

    public void setTouchOffset(float touchOffsetX, float touchOffsetY) {
        this.touchOffsetX = touchOffsetX;
        this.touchOffsetY = touchOffsetY;
    }

    public boolean isDragging() {
        return this.payload != null;
    }

    @Null
    public Actor getDragActor() {
        return this.dragActor;
    }

    @Null
    public Payload getDragPayload() {
        return this.payload;
    }

    @Null
    public Source getDragSource() {
        return this.dragSource;
    }

    public void setDragTime(int dragMillis) {
        this.dragTime = dragMillis;
    }

    public int getDragTime() {
        return this.dragTime;
    }

    public boolean isDragValid() {
        return this.payload != null && System.currentTimeMillis() >= this.dragValidTime;
    }

    public void setCancelTouchFocus(boolean cancelTouchFocus) {
        this.cancelTouchFocus = cancelTouchFocus;
    }

    public void setKeepWithinStage(boolean keepWithinStage) {
        this.keepWithinStage = keepWithinStage;
    }

    public static class Payload {
        @Null
        Actor dragActor;
        @Null
        Actor validDragActor;
        @Null
        Actor invalidDragActor;
        @Null
        Object object;

        public void setDragActor(@Null Actor dragActor) {
            this.dragActor = dragActor;
        }

        @Null
        public Actor getDragActor() {
            return this.dragActor;
        }

        public void setValidDragActor(@Null Actor validDragActor) {
            this.validDragActor = validDragActor;
        }

        @Null
        public Actor getValidDragActor() {
            return this.validDragActor;
        }

        public void setInvalidDragActor(@Null Actor invalidDragActor) {
            this.invalidDragActor = invalidDragActor;
        }

        @Null
        public Actor getInvalidDragActor() {
            return this.invalidDragActor;
        }

        @Null
        public Object getObject() {
            return this.object;
        }

        public void setObject(@Null Object object) {
            this.object = object;
        }
    }

    public static abstract class Target {
        final Actor actor;

        public Target(Actor actor) {
            if (actor == null) {
                throw new IllegalArgumentException("actor cannot be null.");
            }
            this.actor = actor;
            Stage stage = actor.getStage();
            if (stage != null && actor == stage.getRoot()) {
                throw new IllegalArgumentException("The stage root cannot be a drag and drop target.");
            }
        }

        public abstract boolean drag(Source var1, Payload var2, float var3, float var4, int var5);

        public void reset(Source source, Payload payload) {
        }

        public abstract void drop(Source var1, Payload var2, float var3, float var4, int var5);

        public Actor getActor() {
            return this.actor;
        }
    }

    public static abstract class Source {
        final Actor actor;

        public Source(Actor actor) {
            if (actor == null) {
                throw new IllegalArgumentException("actor cannot be null.");
            }
            this.actor = actor;
        }

        @Null
        public abstract Payload dragStart(InputEvent var1, float var2, float var3, int var4);

        public void drag(InputEvent event, float x, float y, int pointer) {
        }

        public void dragStop(InputEvent event, float x, float y, int pointer, @Null Payload payload, @Null Target target) {
        }

        public Actor getActor() {
            return this.actor;
        }
    }
}

