/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.Vector2;

public abstract class Scaling {
    protected static final Vector2 temp = new Vector2();
    public static final Scaling fit = new Scaling(){

        @Override
        public Vector2 apply(float sourceWidth, float sourceHeight, float targetWidth, float targetHeight) {
            float targetRatio = targetHeight / targetWidth;
            float sourceRatio = sourceHeight / sourceWidth;
            float scale = targetRatio > sourceRatio ? targetWidth / sourceWidth : targetHeight / sourceHeight;
            1.temp.x = sourceWidth * scale;
            1.temp.y = sourceHeight * scale;
            return temp;
        }
    };
    public static final Scaling fill = new Scaling(){

        @Override
        public Vector2 apply(float sourceWidth, float sourceHeight, float targetWidth, float targetHeight) {
            float targetRatio = targetHeight / targetWidth;
            float sourceRatio = sourceHeight / sourceWidth;
            float scale = targetRatio < sourceRatio ? targetWidth / sourceWidth : targetHeight / sourceHeight;
            2.temp.x = sourceWidth * scale;
            2.temp.y = sourceHeight * scale;
            return temp;
        }
    };
    public static final Scaling fillX = new Scaling(){

        @Override
        public Vector2 apply(float sourceWidth, float sourceHeight, float targetWidth, float targetHeight) {
            float scale = targetWidth / sourceWidth;
            3.temp.x = sourceWidth * scale;
            3.temp.y = sourceHeight * scale;
            return temp;
        }
    };
    public static final Scaling fillY = new Scaling(){

        @Override
        public Vector2 apply(float sourceWidth, float sourceHeight, float targetWidth, float targetHeight) {
            float scale = targetHeight / sourceHeight;
            4.temp.x = sourceWidth * scale;
            4.temp.y = sourceHeight * scale;
            return temp;
        }
    };
    public static final Scaling stretch = new Scaling(){

        @Override
        public Vector2 apply(float sourceWidth, float sourceHeight, float targetWidth, float targetHeight) {
            5.temp.x = targetWidth;
            5.temp.y = targetHeight;
            return temp;
        }
    };
    public static final Scaling stretchX = new Scaling(){

        @Override
        public Vector2 apply(float sourceWidth, float sourceHeight, float targetWidth, float targetHeight) {
            6.temp.x = targetWidth;
            6.temp.y = sourceHeight;
            return temp;
        }
    };
    public static final Scaling stretchY = new Scaling(){

        @Override
        public Vector2 apply(float sourceWidth, float sourceHeight, float targetWidth, float targetHeight) {
            7.temp.x = sourceWidth;
            7.temp.y = targetHeight;
            return temp;
        }
    };
    public static final Scaling none = new Scaling(){

        @Override
        public Vector2 apply(float sourceWidth, float sourceHeight, float targetWidth, float targetHeight) {
            8.temp.x = sourceWidth;
            8.temp.y = sourceHeight;
            return temp;
        }
    };

    public abstract Vector2 apply(float var1, float var2, float var3, float var4);
}

