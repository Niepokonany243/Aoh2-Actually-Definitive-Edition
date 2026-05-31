/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class ParticleEmitter {
    private static final int UPDATE_SCALE = 1;
    private static final int UPDATE_ANGLE = 2;
    private static final int UPDATE_ROTATION = 4;
    private static final int UPDATE_VELOCITY = 8;
    private static final int UPDATE_WIND = 16;
    private static final int UPDATE_GRAVITY = 32;
    private static final int UPDATE_TINT = 64;
    private static final int UPDATE_SPRITE = 128;
    private RangedNumericValue delayValue = new RangedNumericValue();
    private IndependentScaledNumericValue lifeOffsetValue = new IndependentScaledNumericValue();
    private RangedNumericValue durationValue = new RangedNumericValue();
    private IndependentScaledNumericValue lifeValue = new IndependentScaledNumericValue();
    private ScaledNumericValue emissionValue = new ScaledNumericValue();
    private ScaledNumericValue xScaleValue = new ScaledNumericValue();
    private ScaledNumericValue yScaleValue = new ScaledNumericValue();
    private ScaledNumericValue rotationValue = new ScaledNumericValue();
    private ScaledNumericValue velocityValue = new ScaledNumericValue();
    private ScaledNumericValue angleValue = new ScaledNumericValue();
    private ScaledNumericValue windValue = new ScaledNumericValue();
    private ScaledNumericValue gravityValue = new ScaledNumericValue();
    private ScaledNumericValue transparencyValue = new ScaledNumericValue();
    private GradientColorValue tintValue = new GradientColorValue();
    private RangedNumericValue xOffsetValue = new ScaledNumericValue();
    private RangedNumericValue yOffsetValue = new ScaledNumericValue();
    private ScaledNumericValue spawnWidthValue = new ScaledNumericValue();
    private ScaledNumericValue spawnHeightValue = new ScaledNumericValue();
    private SpawnShapeValue spawnShapeValue = new SpawnShapeValue();
    private RangedNumericValue[] xSizeValues;
    private RangedNumericValue[] ySizeValues;
    private RangedNumericValue[] motionValues;
    private float accumulator;
    private Array<Sprite> sprites;
    private SpriteMode spriteMode = SpriteMode.single;
    private Particle[] particles;
    private int minParticleCount;
    private int maxParticleCount = 4;
    private float x;
    private float y;
    private String name;
    private Array<String> imagePaths;
    private int activeCount;
    private boolean[] active;
    private boolean firstUpdate;
    private boolean flipX;
    private boolean flipY;
    private int updateFlags;
    private boolean allowCompletion;
    private BoundingBox bounds;
    private int emission;
    private int emissionDiff;
    private int emissionDelta;
    private int lifeOffset;
    private int lifeOffsetDiff;
    private int life;
    private int lifeDiff;
    private float spawnWidth;
    private float spawnWidthDiff;
    private float spawnHeight;
    private float spawnHeightDiff;
    public float duration = 1.0f;
    public float durationTimer;
    private float delay;
    private float delayTimer;
    private boolean attached;
    private boolean continuous;
    private boolean aligned;
    private boolean behind;
    private boolean additive = true;
    private boolean premultipliedAlpha = false;
    boolean cleansUpBlendFunction = true;

    public ParticleEmitter() {
        this.initialize();
    }

    public ParticleEmitter(BufferedReader reader) throws IOException {
        this.initialize();
        this.load(reader);
    }

    public ParticleEmitter(ParticleEmitter emitter) {
        this.sprites = new Array<Sprite>(emitter.sprites);
        this.name = emitter.name;
        this.imagePaths = new Array<String>(emitter.imagePaths);
        this.setMaxParticleCount(emitter.maxParticleCount);
        this.minParticleCount = emitter.minParticleCount;
        this.delayValue.load(emitter.delayValue);
        this.durationValue.load(emitter.durationValue);
        this.emissionValue.load(emitter.emissionValue);
        this.lifeValue.load(emitter.lifeValue);
        this.lifeOffsetValue.load(emitter.lifeOffsetValue);
        this.xScaleValue.load(emitter.xScaleValue);
        this.yScaleValue.load(emitter.yScaleValue);
        this.rotationValue.load(emitter.rotationValue);
        this.velocityValue.load(emitter.velocityValue);
        this.angleValue.load(emitter.angleValue);
        this.windValue.load(emitter.windValue);
        this.gravityValue.load(emitter.gravityValue);
        this.transparencyValue.load(emitter.transparencyValue);
        this.tintValue.load(emitter.tintValue);
        this.xOffsetValue.load(emitter.xOffsetValue);
        this.yOffsetValue.load(emitter.yOffsetValue);
        this.spawnWidthValue.load(emitter.spawnWidthValue);
        this.spawnHeightValue.load(emitter.spawnHeightValue);
        this.spawnShapeValue.load(emitter.spawnShapeValue);
        this.attached = emitter.attached;
        this.continuous = emitter.continuous;
        this.aligned = emitter.aligned;
        this.behind = emitter.behind;
        this.additive = emitter.additive;
        this.premultipliedAlpha = emitter.premultipliedAlpha;
        this.cleansUpBlendFunction = emitter.cleansUpBlendFunction;
        this.spriteMode = emitter.spriteMode;
        this.setPosition(emitter.getX(), emitter.getY());
    }

    private void initialize() {
        this.sprites = new Array();
        this.imagePaths = new Array();
        this.durationValue.setAlwaysActive(true);
        this.emissionValue.setAlwaysActive(true);
        this.lifeValue.setAlwaysActive(true);
        this.xScaleValue.setAlwaysActive(true);
        this.transparencyValue.setAlwaysActive(true);
        this.spawnShapeValue.setAlwaysActive(true);
        this.spawnWidthValue.setAlwaysActive(true);
        this.spawnHeightValue.setAlwaysActive(true);
    }

    public void setMaxParticleCount(int maxParticleCount) {
        this.maxParticleCount = maxParticleCount;
        this.active = new boolean[maxParticleCount];
        this.activeCount = 0;
        this.particles = new Particle[maxParticleCount];
    }

    public void addParticle() {
        int activeCount = this.activeCount;
        if (activeCount == this.maxParticleCount) {
            return;
        }
        boolean[] active = this.active;
        int n = active.length;
        for (int i = 0; i < n; ++i) {
            if (active[i]) continue;
            this.activateParticle(i);
            active[i] = true;
            this.activeCount = activeCount + 1;
            break;
        }
    }

    public void addParticles(int count) {
        if ((count = Math.min(count, this.maxParticleCount - this.activeCount)) == 0) {
            return;
        }
        boolean[] active = this.active;
        int index = 0;
        int n = active.length;
        block0: for (int i = 0; i < count; ++i) {
            while (index < n) {
                if (active[index]) {
                    ++index;
                    continue;
                }
                this.activateParticle(index);
                active[index++] = true;
                continue block0;
            }
            break block0;
        }
        this.activeCount += count;
    }

    public void update(float delta) {
        this.accumulator += delta * 1000.0f;
        if (this.accumulator < 1.0f) {
            return;
        }
        int deltaMillis = (int)this.accumulator;
        this.accumulator -= (float)deltaMillis;
        if (this.delayTimer < this.delay) {
            this.delayTimer += (float)deltaMillis;
        } else {
            boolean done = false;
            if (this.firstUpdate) {
                this.firstUpdate = false;
                this.addParticle();
            }
            if (this.durationTimer < this.duration) {
                this.durationTimer += (float)deltaMillis;
            } else if (!this.continuous || this.allowCompletion) {
                done = true;
            } else {
                this.restart();
            }
            if (!done) {
                this.emissionDelta += deltaMillis;
                float emissionTime = (float)this.emission + (float)this.emissionDiff * this.emissionValue.getScale(this.durationTimer / this.duration);
                if (emissionTime > 0.0f && (float)this.emissionDelta >= (emissionTime = 1000.0f / emissionTime)) {
                    int emitCount = (int)((float)this.emissionDelta / emissionTime);
                    emitCount = Math.min(emitCount, this.maxParticleCount - this.activeCount);
                    this.emissionDelta = (int)((float)this.emissionDelta - (float)emitCount * emissionTime);
                    this.emissionDelta = (int)((float)this.emissionDelta % emissionTime);
                    this.addParticles(emitCount);
                }
                if (this.activeCount < this.minParticleCount) {
                    this.addParticles(this.minParticleCount - this.activeCount);
                }
            }
        }
        boolean[] active = this.active;
        int activeCount = this.activeCount;
        Particle[] particles = this.particles;
        int n = active.length;
        for (int i = 0; i < n; ++i) {
            if (!active[i] || this.updateParticle(particles[i], delta, deltaMillis)) continue;
            active[i] = false;
            --activeCount;
        }
        this.activeCount = activeCount;
    }

    public void draw(Batch batch) {
        if (this.premultipliedAlpha) {
            batch.setBlendFunction(1, 771);
        } else if (this.additive) {
            batch.setBlendFunction(770, 1);
        } else {
            batch.setBlendFunction(770, 771);
        }
        Particle[] particles = this.particles;
        boolean[] active = this.active;
        int n = active.length;
        for (int i = 0; i < n; ++i) {
            if (!active[i]) continue;
            particles[i].draw(batch);
        }
        if (this.cleansUpBlendFunction && (this.additive || this.premultipliedAlpha)) {
            batch.setBlendFunction(770, 771);
        }
    }

    public void draw(Batch batch, float delta) {
        this.accumulator += delta * 1000.0f;
        if (this.accumulator < 1.0f) {
            this.draw(batch);
            return;
        }
        int deltaMillis = (int)this.accumulator;
        this.accumulator -= (float)deltaMillis;
        if (this.premultipliedAlpha) {
            batch.setBlendFunction(1, 771);
        } else if (this.additive) {
            batch.setBlendFunction(770, 1);
        } else {
            batch.setBlendFunction(770, 771);
        }
        Particle[] particles = this.particles;
        boolean[] active = this.active;
        int activeCount = this.activeCount;
        int n = active.length;
        for (int i = 0; i < n; ++i) {
            if (!active[i]) continue;
            Particle particle = particles[i];
            if (this.updateParticle(particle, delta, deltaMillis)) {
                particle.draw(batch);
                continue;
            }
            active[i] = false;
            --activeCount;
        }
        this.activeCount = activeCount;
        if (this.cleansUpBlendFunction && (this.additive || this.premultipliedAlpha)) {
            batch.setBlendFunction(770, 771);
        }
        if (this.delayTimer < this.delay) {
            this.delayTimer += (float)deltaMillis;
            return;
        }
        if (this.firstUpdate) {
            this.firstUpdate = false;
            this.addParticle();
        }
        if (this.durationTimer < this.duration) {
            this.durationTimer += (float)deltaMillis;
        } else {
            if (!this.continuous || this.allowCompletion) {
                return;
            }
            this.restart();
        }
        this.emissionDelta += deltaMillis;
        float emissionTime = (float)this.emission + (float)this.emissionDiff * this.emissionValue.getScale(this.durationTimer / this.duration);
        if (emissionTime > 0.0f && (float)this.emissionDelta >= (emissionTime = 1000.0f / emissionTime)) {
            int emitCount = (int)((float)this.emissionDelta / emissionTime);
            emitCount = Math.min(emitCount, this.maxParticleCount - activeCount);
            this.emissionDelta = (int)((float)this.emissionDelta - (float)emitCount * emissionTime);
            this.emissionDelta = (int)((float)this.emissionDelta % emissionTime);
            this.addParticles(emitCount);
        }
        if (activeCount < this.minParticleCount) {
            this.addParticles(this.minParticleCount - activeCount);
        }
    }

    public void start() {
        this.firstUpdate = true;
        this.allowCompletion = false;
        this.restart();
    }

    public void reset() {
        this.emissionDelta = 0;
        this.durationTimer = this.duration;
        boolean[] active = this.active;
        int n = active.length;
        for (int i = 0; i < n; ++i) {
            active[i] = false;
        }
        this.activeCount = 0;
        this.start();
    }

    private void restart() {
        this.delay = this.delayValue.active ? this.delayValue.newLowValue() : 0.0f;
        this.delayTimer = 0.0f;
        this.durationTimer -= this.duration;
        this.duration = this.durationValue.newLowValue();
        this.emission = (int)this.emissionValue.newLowValue();
        this.emissionDiff = (int)this.emissionValue.newHighValue();
        if (!this.emissionValue.isRelative()) {
            this.emissionDiff -= this.emission;
        }
        if (!this.lifeValue.independent) {
            this.generateLifeValues();
        }
        if (!this.lifeOffsetValue.independent) {
            this.generateLifeOffsetValues();
        }
        this.spawnWidth = this.spawnWidthValue.newLowValue();
        this.spawnWidthDiff = this.spawnWidthValue.newHighValue();
        if (!this.spawnWidthValue.isRelative()) {
            this.spawnWidthDiff -= this.spawnWidth;
        }
        this.spawnHeight = this.spawnHeightValue.newLowValue();
        this.spawnHeightDiff = this.spawnHeightValue.newHighValue();
        if (!this.spawnHeightValue.isRelative()) {
            this.spawnHeightDiff -= this.spawnHeight;
        }
        this.updateFlags = 0;
        if (this.angleValue.active && this.angleValue.timeline.length > 1) {
            this.updateFlags |= 2;
        }
        if (this.velocityValue.active) {
            this.updateFlags |= 8;
        }
        if (this.xScaleValue.timeline.length > 1) {
            this.updateFlags |= 1;
        }
        if (this.yScaleValue.active && this.yScaleValue.timeline.length > 1) {
            this.updateFlags |= 1;
        }
        if (this.rotationValue.active && this.rotationValue.timeline.length > 1) {
            this.updateFlags |= 4;
        }
        if (this.windValue.active) {
            this.updateFlags |= 0x10;
        }
        if (this.gravityValue.active) {
            this.updateFlags |= 0x20;
        }
        if (this.tintValue.timeline.length > 1) {
            this.updateFlags |= 0x40;
        }
        if (this.spriteMode == SpriteMode.animated) {
            this.updateFlags |= 0x80;
        }
    }

    protected Particle newParticle(Sprite sprite) {
        return new Particle(sprite);
    }

    protected Particle[] getParticles() {
        return this.particles;
    }

    private void activateParticle(int index) {
        float[] color;
        Sprite sprite = null;
        switch (this.spriteMode) {
            case single: 
            case animated: {
                sprite = this.sprites.first();
                break;
            }
            case random: {
                sprite = this.sprites.random();
            }
        }
        Particle particle = this.particles[index];
        if (particle == null) {
            this.particles[index] = particle = this.newParticle(sprite);
            particle.flip(this.flipX, this.flipY);
        } else {
            particle.set(sprite);
        }
        float percent = this.durationTimer / this.duration;
        int updateFlags = this.updateFlags;
        if (this.lifeValue.independent) {
            this.generateLifeValues();
        }
        if (this.lifeOffsetValue.independent) {
            this.generateLifeOffsetValues();
        }
        particle.currentLife = particle.life = this.life + (int)((float)this.lifeDiff * this.lifeValue.getScale(percent));
        if (this.velocityValue.active) {
            particle.velocity = this.velocityValue.newLowValue();
            particle.velocityDiff = this.velocityValue.newHighValue();
            if (!this.velocityValue.isRelative()) {
                particle.velocityDiff -= particle.velocity;
            }
        }
        particle.angle = this.angleValue.newLowValue();
        particle.angleDiff = this.angleValue.newHighValue();
        if (!this.angleValue.isRelative()) {
            particle.angleDiff -= particle.angle;
        }
        float angle = 0.0f;
        if ((updateFlags & 2) == 0) {
            particle.angle = angle = particle.angle + particle.angleDiff * this.angleValue.getScale(0.0f);
            particle.angleCos = MathUtils.cosDeg(angle);
            particle.angleSin = MathUtils.sinDeg(angle);
        }
        float spriteWidth = sprite.getWidth();
        float spriteHeight = sprite.getHeight();
        particle.xScale = this.xScaleValue.newLowValue() / spriteWidth;
        particle.xScaleDiff = this.xScaleValue.newHighValue() / spriteWidth;
        if (!this.xScaleValue.isRelative()) {
            particle.xScaleDiff -= particle.xScale;
        }
        if (this.yScaleValue.active) {
            particle.yScale = this.yScaleValue.newLowValue() / spriteHeight;
            particle.yScaleDiff = this.yScaleValue.newHighValue() / spriteHeight;
            if (!this.yScaleValue.isRelative()) {
                particle.yScaleDiff -= particle.yScale;
            }
            particle.setScale(particle.xScale + particle.xScaleDiff * this.xScaleValue.getScale(0.0f), particle.yScale + particle.yScaleDiff * this.yScaleValue.getScale(0.0f));
        } else {
            particle.setScale(particle.xScale + particle.xScaleDiff * this.xScaleValue.getScale(0.0f));
        }
        if (this.rotationValue.active) {
            particle.rotation = this.rotationValue.newLowValue();
            particle.rotationDiff = this.rotationValue.newHighValue();
            if (!this.rotationValue.isRelative()) {
                particle.rotationDiff -= particle.rotation;
            }
            float rotation = particle.rotation + particle.rotationDiff * this.rotationValue.getScale(0.0f);
            if (this.aligned) {
                rotation += angle;
            }
            particle.setRotation(rotation);
        }
        if (this.windValue.active) {
            particle.wind = this.windValue.newLowValue();
            particle.windDiff = this.windValue.newHighValue();
            if (!this.windValue.isRelative()) {
                particle.windDiff -= particle.wind;
            }
        }
        if (this.gravityValue.active) {
            particle.gravity = this.gravityValue.newLowValue();
            particle.gravityDiff = this.gravityValue.newHighValue();
            if (!this.gravityValue.isRelative()) {
                particle.gravityDiff -= particle.gravity;
            }
        }
        if ((color = particle.tint) == null) {
            particle.tint = color = new float[3];
        }
        float[] temp = this.tintValue.getColor(0.0f);
        color[0] = temp[0];
        color[1] = temp[1];
        color[2] = temp[2];
        particle.transparency = this.transparencyValue.newLowValue();
        particle.transparencyDiff = this.transparencyValue.newHighValue() - particle.transparency;
        float x = this.x;
        if (this.xOffsetValue.active) {
            x += this.xOffsetValue.newLowValue();
        }
        float y = this.y;
        if (this.yOffsetValue.active) {
            y += this.yOffsetValue.newLowValue();
        }
        switch (this.spawnShapeValue.shape) {
            case square: {
                float width = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(percent);
                float height = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(percent);
                x += MathUtils.random(width) - width / 2.0f;
                y += MathUtils.random(height) - height / 2.0f;
                break;
            }
            case ellipse: {
                float py;
                float px;
                float width = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(percent);
                float height = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(percent);
                float radiusX = width / 2.0f;
                float radiusY = height / 2.0f;
                if (radiusX == 0.0f || radiusY == 0.0f) break;
                float scaleY = radiusX / radiusY;
                if (this.spawnShapeValue.edges) {
                    float spawnAngle;
                    switch (this.spawnShapeValue.side) {
                        case top: {
                            spawnAngle = -MathUtils.random(179.0f);
                            break;
                        }
                        case bottom: {
                            spawnAngle = MathUtils.random(179.0f);
                            break;
                        }
                        default: {
                            spawnAngle = MathUtils.random(360.0f);
                        }
                    }
                    float cosDeg = MathUtils.cosDeg(spawnAngle);
                    float sinDeg = MathUtils.sinDeg(spawnAngle);
                    x += cosDeg * radiusX;
                    y += sinDeg * radiusX / scaleY;
                    if ((updateFlags & 2) != 0) break;
                    particle.angle = spawnAngle;
                    particle.angleCos = cosDeg;
                    particle.angleSin = sinDeg;
                    break;
                }
                float radius2 = radiusX * radiusX;
                while (!((px = MathUtils.random(width) - radiusX) * px + (py = MathUtils.random(width) - radiusX) * py <= radius2)) {
                }
                x += px;
                y += py / scaleY;
                break;
            }
            case line: {
                float width = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(percent);
                float height = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(percent);
                if (width != 0.0f) {
                    float lineX = width * MathUtils.random();
                    x += lineX;
                    y += lineX * (height / width);
                    break;
                }
                y += height * MathUtils.random();
                break;
            }
        }
        particle.setBounds(x - spriteWidth / 2.0f, y - spriteHeight / 2.0f, spriteWidth, spriteHeight);
        int offsetTime = (int)((float)this.lifeOffset + (float)this.lifeOffsetDiff * this.lifeOffsetValue.getScale(percent));
        if (offsetTime > 0) {
            if (offsetTime >= particle.currentLife) {
                offsetTime = particle.currentLife - 1;
            }
            this.updateParticle(particle, (float)offsetTime / 1000.0f, offsetTime);
        }
    }

    private boolean updateParticle(Particle particle, float delta, int deltaMillis) {
        int frame;
        int life = particle.currentLife - deltaMillis;
        if (life <= 0) {
            return false;
        }
        particle.currentLife = life;
        float percent = 1.0f - (float)particle.currentLife / (float)particle.life;
        int updateFlags = this.updateFlags;
        if ((updateFlags & 1) != 0) {
            if (this.yScaleValue.active) {
                particle.setScale(particle.xScale + particle.xScaleDiff * this.xScaleValue.getScale(percent), particle.yScale + particle.yScaleDiff * this.yScaleValue.getScale(percent));
            } else {
                particle.setScale(particle.xScale + particle.xScaleDiff * this.xScaleValue.getScale(percent));
            }
        }
        if ((updateFlags & 8) != 0) {
            float velocityY;
            float velocityX;
            float velocity = (particle.velocity + particle.velocityDiff * this.velocityValue.getScale(percent)) * delta;
            if ((updateFlags & 2) != 0) {
                float angle = particle.angle + particle.angleDiff * this.angleValue.getScale(percent);
                velocityX = velocity * MathUtils.cosDeg(angle);
                velocityY = velocity * MathUtils.sinDeg(angle);
                if ((updateFlags & 4) != 0) {
                    float rotation = particle.rotation + particle.rotationDiff * this.rotationValue.getScale(percent);
                    if (this.aligned) {
                        rotation += angle;
                    }
                    particle.setRotation(rotation);
                }
            } else {
                velocityX = velocity * particle.angleCos;
                velocityY = velocity * particle.angleSin;
                if (this.aligned || (updateFlags & 4) != 0) {
                    float rotation = particle.rotation + particle.rotationDiff * this.rotationValue.getScale(percent);
                    if (this.aligned) {
                        rotation += particle.angle;
                    }
                    particle.setRotation(rotation);
                }
            }
            if ((updateFlags & 0x10) != 0) {
                velocityX += (particle.wind + particle.windDiff * this.windValue.getScale(percent)) * delta;
            }
            if ((updateFlags & 0x20) != 0) {
                velocityY += (particle.gravity + particle.gravityDiff * this.gravityValue.getScale(percent)) * delta;
            }
            particle.translate(velocityX, velocityY);
        } else if ((updateFlags & 4) != 0) {
            particle.setRotation(particle.rotation + particle.rotationDiff * this.rotationValue.getScale(percent));
        }
        float[] color = (updateFlags & 0x40) != 0 ? this.tintValue.getColor(percent) : particle.tint;
        if (this.premultipliedAlpha) {
            float alphaMultiplier = this.additive ? 0.0f : 1.0f;
            float a = particle.transparency + particle.transparencyDiff * this.transparencyValue.getScale(percent);
            particle.setColor(color[0] * a, color[1] * a, color[2] * a, a * alphaMultiplier);
        } else {
            particle.setColor(color[0], color[1], color[2], particle.transparency + particle.transparencyDiff * this.transparencyValue.getScale(percent));
        }
        if ((updateFlags & 0x80) != 0 && particle.frame != (frame = Math.min((int)(percent * (float)this.sprites.size), this.sprites.size - 1))) {
            Sprite sprite = this.sprites.get(frame);
            float prevSpriteWidth = particle.getWidth();
            float prevSpriteHeight = particle.getHeight();
            particle.setRegion(sprite);
            particle.setSize(sprite.getWidth(), sprite.getHeight());
            particle.setOrigin(sprite.getOriginX(), sprite.getOriginY());
            particle.translate((prevSpriteWidth - sprite.getWidth()) / 2.0f, (prevSpriteHeight - sprite.getHeight()) / 2.0f);
            particle.frame = frame;
        }
        return true;
    }

    private void generateLifeValues() {
        this.life = (int)this.lifeValue.newLowValue();
        this.lifeDiff = (int)this.lifeValue.newHighValue();
        if (!this.lifeValue.isRelative()) {
            this.lifeDiff -= this.life;
        }
    }

    private void generateLifeOffsetValues() {
        this.lifeOffset = this.lifeOffsetValue.active ? (int)this.lifeOffsetValue.newLowValue() : 0;
        this.lifeOffsetDiff = (int)this.lifeOffsetValue.newHighValue();
        if (!this.lifeOffsetValue.isRelative()) {
            this.lifeOffsetDiff -= this.lifeOffset;
        }
    }

    public void setPosition(float x, float y) {
        if (this.attached) {
            float xAmount = x - this.x;
            float yAmount = y - this.y;
            boolean[] active = this.active;
            int n = active.length;
            for (int i = 0; i < n; ++i) {
                if (!active[i]) continue;
                this.particles[i].translate(xAmount, yAmount);
            }
        }
        this.x = x;
        this.y = y;
    }

    public void setSprites(Array<Sprite> sprites) {
        this.sprites = sprites;
        if (sprites.size == 0) {
            return;
        }
        for (Particle particle : this.particles) {
            if (particle == null) break;
            Sprite sprite = null;
            switch (this.spriteMode) {
                case single: {
                    sprite = sprites.first();
                    break;
                }
                case random: {
                    sprite = sprites.random();
                    break;
                }
                case animated: {
                    float percent = 1.0f - (float)particle.currentLife / (float)particle.life;
                    particle.frame = Math.min((int)(percent * (float)sprites.size), sprites.size - 1);
                    sprite = sprites.get(particle.frame);
                }
            }
            particle.setRegion(sprite);
            particle.setOrigin(sprite.getOriginX(), sprite.getOriginY());
        }
    }

    public void setSpriteMode(SpriteMode spriteMode) {
        this.spriteMode = spriteMode;
    }

    public void preAllocateParticles() {
        if (this.sprites.isEmpty()) {
            throw new IllegalStateException("ParticleEmitter.setSprites() must have been called before preAllocateParticles()");
        }
        for (int index = 0; index < this.particles.length; ++index) {
            Particle particle = this.particles[index];
            if (particle != null) continue;
            this.particles[index] = particle = this.newParticle(this.sprites.first());
            particle.flip(this.flipX, this.flipY);
        }
    }

    public void allowCompletion() {
        this.allowCompletion = true;
        this.durationTimer = this.duration;
    }

    public Array<Sprite> getSprites() {
        return this.sprites;
    }

    public SpriteMode getSpriteMode() {
        return this.spriteMode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ScaledNumericValue getLife() {
        return this.lifeValue;
    }

    public ScaledNumericValue getXScale() {
        return this.xScaleValue;
    }

    public ScaledNumericValue getYScale() {
        return this.yScaleValue;
    }

    public ScaledNumericValue getRotation() {
        return this.rotationValue;
    }

    public GradientColorValue getTint() {
        return this.tintValue;
    }

    public ScaledNumericValue getVelocity() {
        return this.velocityValue;
    }

    public ScaledNumericValue getWind() {
        return this.windValue;
    }

    public ScaledNumericValue getGravity() {
        return this.gravityValue;
    }

    public ScaledNumericValue getAngle() {
        return this.angleValue;
    }

    public ScaledNumericValue getEmission() {
        return this.emissionValue;
    }

    public ScaledNumericValue getTransparency() {
        return this.transparencyValue;
    }

    public RangedNumericValue getDuration() {
        return this.durationValue;
    }

    public RangedNumericValue getDelay() {
        return this.delayValue;
    }

    public ScaledNumericValue getLifeOffset() {
        return this.lifeOffsetValue;
    }

    public RangedNumericValue getXOffsetValue() {
        return this.xOffsetValue;
    }

    public RangedNumericValue getYOffsetValue() {
        return this.yOffsetValue;
    }

    public ScaledNumericValue getSpawnWidth() {
        return this.spawnWidthValue;
    }

    public ScaledNumericValue getSpawnHeight() {
        return this.spawnHeightValue;
    }

    public SpawnShapeValue getSpawnShape() {
        return this.spawnShapeValue;
    }

    public boolean isAttached() {
        return this.attached;
    }

    public void setAttached(boolean attached) {
        this.attached = attached;
    }

    public boolean isContinuous() {
        return this.continuous;
    }

    public void setContinuous(boolean continuous) {
        this.continuous = continuous;
    }

    public boolean isAligned() {
        return this.aligned;
    }

    public void setAligned(boolean aligned) {
        this.aligned = aligned;
    }

    public boolean isAdditive() {
        return this.additive;
    }

    public void setAdditive(boolean additive) {
        this.additive = additive;
    }

    public boolean cleansUpBlendFunction() {
        return this.cleansUpBlendFunction;
    }

    public void setCleansUpBlendFunction(boolean cleansUpBlendFunction) {
        this.cleansUpBlendFunction = cleansUpBlendFunction;
    }

    public boolean isBehind() {
        return this.behind;
    }

    public void setBehind(boolean behind) {
        this.behind = behind;
    }

    public boolean isPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    public void setPremultipliedAlpha(boolean premultipliedAlpha) {
        this.premultipliedAlpha = premultipliedAlpha;
    }

    public int getMinParticleCount() {
        return this.minParticleCount;
    }

    public void setMinParticleCount(int minParticleCount) {
        this.minParticleCount = minParticleCount;
    }

    public int getMaxParticleCount() {
        return this.maxParticleCount;
    }

    public boolean isComplete() {
        if (this.continuous && !this.allowCompletion) {
            return false;
        }
        if (this.delayTimer < this.delay) {
            return false;
        }
        return this.durationTimer >= this.duration && this.activeCount == 0;
    }

    public float getPercentComplete() {
        if (this.delayTimer < this.delay) {
            return 0.0f;
        }
        return Math.min(1.0f, this.durationTimer / this.duration);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public int getActiveCount() {
        return this.activeCount;
    }

    public Array<String> getImagePaths() {
        return this.imagePaths;
    }

    public void setImagePaths(Array<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public void setFlip(boolean flipX, boolean flipY) {
        this.flipX = flipX;
        this.flipY = flipY;
        if (this.particles == null) {
            return;
        }
        for (Particle particle : this.particles) {
            if (particle == null) continue;
            particle.flip(flipX, flipY);
        }
    }

    public void flipY() {
        this.angleValue.setHigh(-this.angleValue.getHighMin(), -this.angleValue.getHighMax());
        this.angleValue.setLow(-this.angleValue.getLowMin(), -this.angleValue.getLowMax());
        this.gravityValue.setHigh(-this.gravityValue.getHighMin(), -this.gravityValue.getHighMax());
        this.gravityValue.setLow(-this.gravityValue.getLowMin(), -this.gravityValue.getLowMax());
        this.windValue.setHigh(-this.windValue.getHighMin(), -this.windValue.getHighMax());
        this.windValue.setLow(-this.windValue.getLowMin(), -this.windValue.getLowMax());
        this.rotationValue.setHigh(-this.rotationValue.getHighMin(), -this.rotationValue.getHighMax());
        this.rotationValue.setLow(-this.rotationValue.getLowMin(), -this.rotationValue.getLowMax());
        this.yOffsetValue.setLow(-this.yOffsetValue.getLowMin(), -this.yOffsetValue.getLowMax());
    }

    public BoundingBox getBoundingBox() {
        if (this.bounds == null) {
            this.bounds = new BoundingBox();
        }
        Particle[] particles = this.particles;
        boolean[] active = this.active;
        BoundingBox bounds = this.bounds;
        bounds.inf();
        int n = active.length;
        for (int i = 0; i < n; ++i) {
            if (!active[i]) continue;
            Rectangle r = particles[i].getBoundingRectangle();
            bounds.ext(r.x, r.y, 0.0f);
            bounds.ext(r.x + r.width, r.y + r.height, 0.0f);
        }
        return bounds;
    }

    protected RangedNumericValue[] getXSizeValues() {
        if (this.xSizeValues == null) {
            this.xSizeValues = new RangedNumericValue[3];
            this.xSizeValues[0] = this.xScaleValue;
            this.xSizeValues[1] = this.spawnWidthValue;
            this.xSizeValues[2] = this.xOffsetValue;
        }
        return this.xSizeValues;
    }

    protected RangedNumericValue[] getYSizeValues() {
        if (this.ySizeValues == null) {
            this.ySizeValues = new RangedNumericValue[3];
            this.ySizeValues[0] = this.yScaleValue;
            this.ySizeValues[1] = this.spawnHeightValue;
            this.ySizeValues[2] = this.yOffsetValue;
        }
        return this.ySizeValues;
    }

    protected RangedNumericValue[] getMotionValues() {
        if (this.motionValues == null) {
            this.motionValues = new RangedNumericValue[3];
            this.motionValues[0] = this.velocityValue;
            this.motionValues[1] = this.windValue;
            this.motionValues[2] = this.gravityValue;
        }
        return this.motionValues;
    }

    public void scaleSize(float scale) {
        if (scale == 1.0f) {
            return;
        }
        this.scaleSize(scale, scale);
    }

    public void scaleSize(float scaleX, float scaleY) {
        if (scaleX == 1.0f && scaleY == 1.0f) {
            return;
        }
        for (RangedNumericValue value : this.getXSizeValues()) {
            value.scale(scaleX);
        }
        for (RangedNumericValue value : this.getYSizeValues()) {
            value.scale(scaleY);
        }
    }

    public void scaleMotion(float scale) {
        if (scale == 1.0f) {
            return;
        }
        for (RangedNumericValue value : this.getMotionValues()) {
            value.scale(scale);
        }
    }

    public void matchSize(ParticleEmitter template) {
        this.matchXSize(template);
        this.matchYSize(template);
    }

    public void matchXSize(ParticleEmitter template) {
        RangedNumericValue[] values = this.getXSizeValues();
        RangedNumericValue[] templateValues = template.getXSizeValues();
        for (int i = 0; i < values.length; ++i) {
            values[i].set(templateValues[i]);
        }
    }

    public void matchYSize(ParticleEmitter template) {
        RangedNumericValue[] values = this.getYSizeValues();
        RangedNumericValue[] templateValues = template.getYSizeValues();
        for (int i = 0; i < values.length; ++i) {
            values[i].set(templateValues[i]);
        }
    }

    public void matchMotion(ParticleEmitter template) {
        RangedNumericValue[] values = this.getMotionValues();
        RangedNumericValue[] templateValues = template.getMotionValues();
        for (int i = 0; i < values.length; ++i) {
            values[i].set(templateValues[i]);
        }
    }

    public void save(Writer output) throws IOException {
        output.write(this.name + "\n");
        output.write("- Delay -\n");
        this.delayValue.save(output);
        output.write("- Duration - \n");
        this.durationValue.save(output);
        output.write("- Count - \n");
        output.write("min: " + this.minParticleCount + "\n");
        output.write("max: " + this.maxParticleCount + "\n");
        output.write("- Emission - \n");
        this.emissionValue.save(output);
        output.write("- Life - \n");
        this.lifeValue.save(output);
        output.write("- Life Offset - \n");
        this.lifeOffsetValue.save(output);
        output.write("- X Offset - \n");
        this.xOffsetValue.save(output);
        output.write("- Y Offset - \n");
        this.yOffsetValue.save(output);
        output.write("- Spawn Shape - \n");
        this.spawnShapeValue.save(output);
        output.write("- Spawn Width - \n");
        this.spawnWidthValue.save(output);
        output.write("- Spawn Height - \n");
        this.spawnHeightValue.save(output);
        output.write("- X Scale - \n");
        this.xScaleValue.save(output);
        output.write("- Y Scale - \n");
        this.yScaleValue.save(output);
        output.write("- Velocity - \n");
        this.velocityValue.save(output);
        output.write("- Angle - \n");
        this.angleValue.save(output);
        output.write("- Rotation - \n");
        this.rotationValue.save(output);
        output.write("- Wind - \n");
        this.windValue.save(output);
        output.write("- Gravity - \n");
        this.gravityValue.save(output);
        output.write("- Tint - \n");
        this.tintValue.save(output);
        output.write("- Transparency - \n");
        this.transparencyValue.save(output);
        output.write("- Options - \n");
        output.write("attached: " + this.attached + "\n");
        output.write("continuous: " + this.continuous + "\n");
        output.write("aligned: " + this.aligned + "\n");
        output.write("additive: " + this.additive + "\n");
        output.write("behind: " + this.behind + "\n");
        output.write("premultipliedAlpha: " + this.premultipliedAlpha + "\n");
        output.write("spriteMode: " + this.spriteMode.toString() + "\n");
        output.write("- Image Paths -\n");
        for (String imagePath : this.imagePaths) {
            output.write(imagePath + "\n");
        }
        output.write("\n");
    }

    public void load(BufferedReader reader) throws IOException {
        try {
            this.name = ParticleEmitter.readString(reader, "name");
            reader.readLine();
            this.delayValue.load(reader);
            reader.readLine();
            this.durationValue.load(reader);
            reader.readLine();
            this.setMinParticleCount(ParticleEmitter.readInt(reader, "minParticleCount"));
            this.setMaxParticleCount(ParticleEmitter.readInt(reader, "maxParticleCount"));
            reader.readLine();
            this.emissionValue.load(reader);
            reader.readLine();
            this.lifeValue.load(reader);
            reader.readLine();
            this.lifeOffsetValue.load(reader);
            reader.readLine();
            this.xOffsetValue.load(reader);
            reader.readLine();
            this.yOffsetValue.load(reader);
            reader.readLine();
            this.spawnShapeValue.load(reader);
            reader.readLine();
            this.spawnWidthValue.load(reader);
            reader.readLine();
            this.spawnHeightValue.load(reader);
            String line = reader.readLine();
            if (line.trim().equals("- Scale -")) {
                this.xScaleValue.load(reader);
                this.yScaleValue.setActive(false);
            } else {
                this.xScaleValue.load(reader);
                reader.readLine();
                this.yScaleValue.load(reader);
            }
            reader.readLine();
            this.velocityValue.load(reader);
            reader.readLine();
            this.angleValue.load(reader);
            reader.readLine();
            this.rotationValue.load(reader);
            reader.readLine();
            this.windValue.load(reader);
            reader.readLine();
            this.gravityValue.load(reader);
            reader.readLine();
            this.tintValue.load(reader);
            reader.readLine();
            this.transparencyValue.load(reader);
            reader.readLine();
            this.attached = ParticleEmitter.readBoolean(reader, "attached");
            this.continuous = ParticleEmitter.readBoolean(reader, "continuous");
            this.aligned = ParticleEmitter.readBoolean(reader, "aligned");
            this.additive = ParticleEmitter.readBoolean(reader, "additive");
            this.behind = ParticleEmitter.readBoolean(reader, "behind");
            line = reader.readLine();
            if (line.startsWith("premultipliedAlpha")) {
                this.premultipliedAlpha = ParticleEmitter.readBoolean(line);
                line = reader.readLine();
            }
            if (line.startsWith("spriteMode")) {
                this.spriteMode = SpriteMode.valueOf(ParticleEmitter.readString(line));
                line = reader.readLine();
            }
            Array<String> imagePaths = new Array<String>();
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                imagePaths.add(line);
            }
            this.setImagePaths(imagePaths);
        }
        catch (RuntimeException ex) {
            if (this.name == null) {
                throw ex;
            }
            throw new RuntimeException("Error parsing emitter: " + this.name, ex);
        }
    }

    static String readString(String line) throws IOException {
        return line.substring(line.indexOf(":") + 1).trim();
    }

    static String readString(BufferedReader reader, String name) throws IOException {
        String line = reader.readLine();
        if (line == null) {
            throw new IOException("Missing value: " + name);
        }
        return ParticleEmitter.readString(line);
    }

    static boolean readBoolean(String line) throws IOException {
        return Boolean.parseBoolean(ParticleEmitter.readString(line));
    }

    static boolean readBoolean(BufferedReader reader, String name) throws IOException {
        return Boolean.parseBoolean(ParticleEmitter.readString(reader, name));
    }

    static int readInt(BufferedReader reader, String name) throws IOException {
        return Integer.parseInt(ParticleEmitter.readString(reader, name));
    }

    static float readFloat(BufferedReader reader, String name) throws IOException {
        return Float.parseFloat(ParticleEmitter.readString(reader, name));
    }

    public static enum SpriteMode {
        single,
        random,
        animated;

    }

    public static enum SpawnEllipseSide {
        both,
        top,
        bottom;

    }

    public static enum SpawnShape {
        point,
        line,
        square,
        ellipse;

    }

    public static class SpawnShapeValue
    extends ParticleValue {
        SpawnShape shape = SpawnShape.point;
        boolean edges;
        SpawnEllipseSide side = SpawnEllipseSide.both;

        public SpawnShape getShape() {
            return this.shape;
        }

        public void setShape(SpawnShape shape) {
            this.shape = shape;
        }

        public boolean isEdges() {
            return this.edges;
        }

        public void setEdges(boolean edges) {
            this.edges = edges;
        }

        public SpawnEllipseSide getSide() {
            return this.side;
        }

        public void setSide(SpawnEllipseSide side) {
            this.side = side;
        }

        @Override
        public void save(Writer output) throws IOException {
            super.save(output);
            if (!this.active) {
                return;
            }
            output.write("shape: " + (Object)((Object)this.shape) + "\n");
            if (this.shape == SpawnShape.ellipse) {
                output.write("edges: " + this.edges + "\n");
                output.write("side: " + (Object)((Object)this.side) + "\n");
            }
        }

        @Override
        public void load(BufferedReader reader) throws IOException {
            super.load(reader);
            if (!this.active) {
                return;
            }
            this.shape = SpawnShape.valueOf(ParticleEmitter.readString(reader, "shape"));
            if (this.shape == SpawnShape.ellipse) {
                this.edges = ParticleEmitter.readBoolean(reader, "edges");
                this.side = SpawnEllipseSide.valueOf(ParticleEmitter.readString(reader, "side"));
            }
        }

        public void load(SpawnShapeValue value) {
            super.load(value);
            this.shape = value.shape;
            this.edges = value.edges;
            this.side = value.side;
        }
    }

    public static class GradientColorValue
    extends ParticleValue {
        private static float[] temp = new float[4];
        private float[] colors = new float[]{1.0f, 1.0f, 1.0f};
        float[] timeline = new float[]{0.0f};

        public GradientColorValue() {
            this.alwaysActive = true;
        }

        public float[] getTimeline() {
            return this.timeline;
        }

        public void setTimeline(float[] timeline) {
            this.timeline = timeline;
        }

        public float[] getColors() {
            return this.colors;
        }

        public void setColors(float[] colors) {
            this.colors = colors;
        }

        public float[] getColor(float percent) {
            int startIndex = 0;
            int endIndex = -1;
            float[] timeline = this.timeline;
            int n = timeline.length;
            int i = 1;
            while (i < n) {
                float t = timeline[i];
                if (t > percent) {
                    endIndex = i;
                    break;
                }
                startIndex = i++;
            }
            float startTime = timeline[startIndex];
            float r1 = this.colors[startIndex *= 3];
            float g1 = this.colors[startIndex + 1];
            float b1 = this.colors[startIndex + 2];
            if (endIndex == -1) {
                GradientColorValue.temp[0] = r1;
                GradientColorValue.temp[1] = g1;
                GradientColorValue.temp[2] = b1;
                return temp;
            }
            float factor = (percent - startTime) / (timeline[endIndex] - startTime);
            GradientColorValue.temp[0] = r1 + (this.colors[endIndex *= 3] - r1) * factor;
            GradientColorValue.temp[1] = g1 + (this.colors[endIndex + 1] - g1) * factor;
            GradientColorValue.temp[2] = b1 + (this.colors[endIndex + 2] - b1) * factor;
            return temp;
        }

        @Override
        public void save(Writer output) throws IOException {
            int i;
            super.save(output);
            if (!this.active) {
                return;
            }
            output.write("colorsCount: " + this.colors.length + "\n");
            for (i = 0; i < this.colors.length; ++i) {
                output.write("colors" + i + ": " + this.colors[i] + "\n");
            }
            output.write("timelineCount: " + this.timeline.length + "\n");
            for (i = 0; i < this.timeline.length; ++i) {
                output.write("timeline" + i + ": " + this.timeline[i] + "\n");
            }
        }

        @Override
        public void load(BufferedReader reader) throws IOException {
            int i;
            super.load(reader);
            if (!this.active) {
                return;
            }
            this.colors = new float[ParticleEmitter.readInt(reader, "colorsCount")];
            for (i = 0; i < this.colors.length; ++i) {
                this.colors[i] = ParticleEmitter.readFloat(reader, "colors" + i);
            }
            this.timeline = new float[ParticleEmitter.readInt(reader, "timelineCount")];
            for (i = 0; i < this.timeline.length; ++i) {
                this.timeline[i] = ParticleEmitter.readFloat(reader, "timeline" + i);
            }
        }

        public void load(GradientColorValue value) {
            super.load(value);
            this.colors = new float[value.colors.length];
            System.arraycopy(value.colors, 0, this.colors, 0, this.colors.length);
            this.timeline = new float[value.timeline.length];
            System.arraycopy(value.timeline, 0, this.timeline, 0, this.timeline.length);
        }
    }

    public static class IndependentScaledNumericValue
    extends ScaledNumericValue {
        boolean independent;

        public boolean isIndependent() {
            return this.independent;
        }

        public void setIndependent(boolean independent) {
            this.independent = independent;
        }

        @Override
        public void set(RangedNumericValue value) {
            if (value instanceof IndependentScaledNumericValue) {
                this.set((IndependentScaledNumericValue)value);
            } else {
                super.set(value);
            }
        }

        @Override
        public void set(ScaledNumericValue value) {
            if (value instanceof IndependentScaledNumericValue) {
                this.set((IndependentScaledNumericValue)value);
            } else {
                super.set(value);
            }
        }

        public void set(IndependentScaledNumericValue value) {
            super.set(value);
            this.independent = value.independent;
        }

        @Override
        public void save(Writer output) throws IOException {
            super.save(output);
            output.write("independent: " + this.independent + "\n");
        }

        @Override
        public void load(BufferedReader reader) throws IOException {
            String line;
            super.load(reader);
            if (reader.markSupported()) {
                reader.mark(100);
            }
            if ((line = reader.readLine()) == null) {
                throw new IOException("Missing value: independent");
            }
            if (line.contains("independent")) {
                this.independent = Boolean.parseBoolean(ParticleEmitter.readString(line));
            } else if (reader.markSupported()) {
                reader.reset();
            } else {
                String errorMessage = "The loaded particle effect descriptor file uses an old invalid format. Please download the latest version of the Particle Editor tool and recreate the file by loading and saving it again.";
                Gdx.app.error("ParticleEmitter", errorMessage);
                throw new IOException(errorMessage);
            }
        }

        public void load(IndependentScaledNumericValue value) {
            super.load(value);
            this.independent = value.independent;
        }
    }

    public static class ScaledNumericValue
    extends RangedNumericValue {
        private float[] scaling = new float[]{1.0f};
        float[] timeline = new float[]{0.0f};
        private float highMin;
        private float highMax;
        private boolean relative;

        public float newHighValue() {
            return this.highMin + (this.highMax - this.highMin) * MathUtils.random();
        }

        public void setHigh(float value) {
            this.highMin = value;
            this.highMax = value;
        }

        public void setHigh(float min, float max) {
            this.highMin = min;
            this.highMax = max;
        }

        public float getHighMin() {
            return this.highMin;
        }

        public void setHighMin(float highMin) {
            this.highMin = highMin;
        }

        public float getHighMax() {
            return this.highMax;
        }

        public void setHighMax(float highMax) {
            this.highMax = highMax;
        }

        @Override
        public void scale(float scale) {
            super.scale(scale);
            this.highMin *= scale;
            this.highMax *= scale;
        }

        @Override
        public void set(RangedNumericValue value) {
            if (value instanceof ScaledNumericValue) {
                this.set((ScaledNumericValue)value);
            } else {
                super.set(value);
            }
        }

        public void set(ScaledNumericValue value) {
            super.set(value);
            this.highMin = value.highMin;
            this.highMax = value.highMax;
            if (this.scaling.length != value.scaling.length) {
                this.scaling = Arrays.copyOf(value.scaling, value.scaling.length);
            } else {
                System.arraycopy(value.scaling, 0, this.scaling, 0, this.scaling.length);
            }
            if (this.timeline.length != value.timeline.length) {
                this.timeline = Arrays.copyOf(value.timeline, value.timeline.length);
            } else {
                System.arraycopy(value.timeline, 0, this.timeline, 0, this.timeline.length);
            }
            this.relative = value.relative;
        }

        public float[] getScaling() {
            return this.scaling;
        }

        public void setScaling(float[] values) {
            this.scaling = values;
        }

        public float[] getTimeline() {
            return this.timeline;
        }

        public void setTimeline(float[] timeline) {
            this.timeline = timeline;
        }

        public boolean isRelative() {
            return this.relative;
        }

        public void setRelative(boolean relative) {
            this.relative = relative;
        }

        public float getScale(float percent) {
            int endIndex = -1;
            float[] timeline = this.timeline;
            int n = timeline.length;
            for (int i = 1; i < n; ++i) {
                float t = timeline[i];
                if (!(t > percent)) continue;
                endIndex = i;
                break;
            }
            if (endIndex == -1) {
                return this.scaling[n - 1];
            }
            float[] scaling = this.scaling;
            int startIndex = endIndex - 1;
            float startValue = scaling[startIndex];
            float startTime = timeline[startIndex];
            return startValue + (scaling[endIndex] - startValue) * ((percent - startTime) / (timeline[endIndex] - startTime));
        }

        @Override
        public void save(Writer output) throws IOException {
            int i;
            super.save(output);
            if (!this.active) {
                return;
            }
            output.write("highMin: " + this.highMin + "\n");
            output.write("highMax: " + this.highMax + "\n");
            output.write("relative: " + this.relative + "\n");
            output.write("scalingCount: " + this.scaling.length + "\n");
            for (i = 0; i < this.scaling.length; ++i) {
                output.write("scaling" + i + ": " + this.scaling[i] + "\n");
            }
            output.write("timelineCount: " + this.timeline.length + "\n");
            for (i = 0; i < this.timeline.length; ++i) {
                output.write("timeline" + i + ": " + this.timeline[i] + "\n");
            }
        }

        @Override
        public void load(BufferedReader reader) throws IOException {
            int i;
            super.load(reader);
            if (!this.active) {
                return;
            }
            this.highMin = ParticleEmitter.readFloat(reader, "highMin");
            this.highMax = ParticleEmitter.readFloat(reader, "highMax");
            this.relative = ParticleEmitter.readBoolean(reader, "relative");
            this.scaling = new float[ParticleEmitter.readInt(reader, "scalingCount")];
            for (i = 0; i < this.scaling.length; ++i) {
                this.scaling[i] = ParticleEmitter.readFloat(reader, "scaling" + i);
            }
            this.timeline = new float[ParticleEmitter.readInt(reader, "timelineCount")];
            for (i = 0; i < this.timeline.length; ++i) {
                this.timeline[i] = ParticleEmitter.readFloat(reader, "timeline" + i);
            }
        }

        public void load(ScaledNumericValue value) {
            super.load(value);
            this.highMax = value.highMax;
            this.highMin = value.highMin;
            this.scaling = new float[value.scaling.length];
            System.arraycopy(value.scaling, 0, this.scaling, 0, this.scaling.length);
            this.timeline = new float[value.timeline.length];
            System.arraycopy(value.timeline, 0, this.timeline, 0, this.timeline.length);
            this.relative = value.relative;
        }
    }

    public static class RangedNumericValue
    extends ParticleValue {
        private float lowMin;
        private float lowMax;

        public float newLowValue() {
            return this.lowMin + (this.lowMax - this.lowMin) * MathUtils.random();
        }

        public void setLow(float value) {
            this.lowMin = value;
            this.lowMax = value;
        }

        public void setLow(float min, float max) {
            this.lowMin = min;
            this.lowMax = max;
        }

        public float getLowMin() {
            return this.lowMin;
        }

        public void setLowMin(float lowMin) {
            this.lowMin = lowMin;
        }

        public float getLowMax() {
            return this.lowMax;
        }

        public void setLowMax(float lowMax) {
            this.lowMax = lowMax;
        }

        public void scale(float scale) {
            this.lowMin *= scale;
            this.lowMax *= scale;
        }

        public void set(RangedNumericValue value) {
            this.lowMin = value.lowMin;
            this.lowMax = value.lowMax;
        }

        @Override
        public void save(Writer output) throws IOException {
            super.save(output);
            if (!this.active) {
                return;
            }
            output.write("lowMin: " + this.lowMin + "\n");
            output.write("lowMax: " + this.lowMax + "\n");
        }

        @Override
        public void load(BufferedReader reader) throws IOException {
            super.load(reader);
            if (!this.active) {
                return;
            }
            this.lowMin = ParticleEmitter.readFloat(reader, "lowMin");
            this.lowMax = ParticleEmitter.readFloat(reader, "lowMax");
        }

        public void load(RangedNumericValue value) {
            super.load(value);
            this.lowMax = value.lowMax;
            this.lowMin = value.lowMin;
        }
    }

    public static class NumericValue
    extends ParticleValue {
        private float value;

        public float getValue() {
            return this.value;
        }

        public void setValue(float value) {
            this.value = value;
        }

        @Override
        public void save(Writer output) throws IOException {
            super.save(output);
            if (!this.active) {
                return;
            }
            output.write("value: " + this.value + "\n");
        }

        @Override
        public void load(BufferedReader reader) throws IOException {
            super.load(reader);
            if (!this.active) {
                return;
            }
            this.value = ParticleEmitter.readFloat(reader, "value");
        }

        public void load(NumericValue value) {
            super.load(value);
            this.value = value.value;
        }
    }

    public static class ParticleValue {
        boolean active;
        boolean alwaysActive;

        public void setAlwaysActive(boolean alwaysActive) {
            this.alwaysActive = alwaysActive;
        }

        public boolean isAlwaysActive() {
            return this.alwaysActive;
        }

        public boolean isActive() {
            return this.alwaysActive || this.active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public void save(Writer output) throws IOException {
            if (!this.alwaysActive) {
                output.write("active: " + this.active + "\n");
            } else {
                this.active = true;
            }
        }

        public void load(BufferedReader reader) throws IOException {
            this.active = !this.alwaysActive ? ParticleEmitter.readBoolean(reader, "active") : true;
        }

        public void load(ParticleValue value) {
            this.active = value.active;
            this.alwaysActive = value.alwaysActive;
        }
    }

    public static class Particle
    extends Sprite {
        protected int life;
        protected int currentLife;
        protected float xScale;
        protected float xScaleDiff;
        protected float yScale;
        protected float yScaleDiff;
        protected float rotation;
        protected float rotationDiff;
        protected float velocity;
        protected float velocityDiff;
        protected float angle;
        protected float angleDiff;
        protected float angleCos;
        protected float angleSin;
        protected float transparency;
        protected float transparencyDiff;
        protected float wind;
        protected float windDiff;
        protected float gravity;
        protected float gravityDiff;
        protected float[] tint;
        protected int frame;

        public Particle(Sprite sprite) {
            super(sprite);
        }
    }
}

