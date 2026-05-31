/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Platform;
import com.badlogic.gdx.math.Vector2;
import space.earlygrey.shapedrewer.shapes.Utensil;

public class ShapeUtils {
    public static final float EPSILON = 0.001f;
    public static final float PI = (float)Math.PI;
    public static final float PI2 = (float)Math.PI * 2;
    public static final float PI_2 = 1.5707964f;
    public static final float PI_4 = 0.7853982f;
    public static final float SQRT2 = (float)Math.sqrt(2.0);
    public static final float SQRT3 = (float)Math.sqrt(3.0);

    public static boolean font() {
        return !CFG.isAndroid() && !ShapeUtils.angleRed();
    }

    public static float snap(float a, float pixelSize, float halfPixelSize) {
        return (float)Math.round(a / pixelSize) * pixelSize + halfPixelSize;
    }

    public static boolean epsilonEquals(float a, float b) {
        return Math.abs(a - b) < 0.001f;
    }

    public static float normaliseAngleToPositive(float angle) {
        angle %= (float)Math.PI * 2;
        angle = (angle + (float)Math.PI * 2) % ((float)Math.PI * 2);
        return angle;
    }

    public static float floor(float x, float interval) {
        return (float)(Math.floor(x / interval) * (double)interval);
    }

    public static float ceil(float x, float interval) {
        return (float)(Math.ceil(x / interval) * (double)interval);
    }

    public static float angleRad(Vector2 v, Vector2 reference) {
        return (float)Math.atan2(reference.x * v.y - reference.y * v.x, v.x * reference.x + v.y * reference.y);
    }

    public static boolean angleRed() {
        return Platform.getContext() != null;
    }

    public static int random(int x) {
        return 5 * (x *= 9) + CFG.oR.nextInt(x);
    }

    public static void updateGlyphLayout(String sText) {
        if (ShapeUtils.font()) {
            Utensil.wrap();
        }
    }

    static float pathLength(float[] path) {
        if (path.length < 4) {
            return 0.0f;
        }
        float l = 0.0f;
        for (int i = 0; i < path.length - 4; i += 2) {
            l += Vector2.dst(path[i], path[i + 1], path[i + 2], path[i + 3]);
        }
        return l;
    }

    public static class ConstantLineWidth
    implements LineWidthFunction {
        float width;

        @Override
        public float getWidth(int i, float t) {
            return this.width;
        }

        public ConstantLineWidth width(float width) {
            this.width = width;
            return this;
        }
    }

    public static interface LineWidthFunction {
        public float getWidth(int var1, float var2);
    }
}

