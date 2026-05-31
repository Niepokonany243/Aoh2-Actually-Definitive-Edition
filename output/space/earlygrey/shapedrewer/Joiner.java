/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer;

import com.badlogic.gdx.math.Vector2;
import space.earlygrey.shapedrewer.ShapeUtils;
import space.earlygrey.shapedrewer.scene2d.GraphDrawerDrawable;
import space.earlygrey.shapedrewer.shapes.BasicLine;

public class Joiner {
    static final Vector2 AB = new Vector2();
    static final Vector2 BC = new Vector2();
    static final Vector2 v = new Vector2();

    static float preparePointyJoin(Vector2 A, Vector2 B2, Vector2 C, Vector2 D2, Vector2 E, float halfLineWidth) {
        AB.set(B2).sub(A);
        BC.set(C).sub(B2);
        float angle = ShapeUtils.angleRad(AB, BC);
        if (ShapeUtils.epsilonEquals(angle, 0.0f) || ShapeUtils.epsilonEquals(angle, (float)Math.PI * 2)) {
            Joiner.prepareStraightJoin(B2, D2, E, halfLineWidth);
            return angle;
        }
        float len = (float)((double)halfLineWidth / Math.sin(angle));
        boolean bendsLeft = angle < 0.0f;
        AB.setLength(len);
        BC.setLength(len);
        Vector2 insidePoint = bendsLeft ? D2 : E;
        Vector2 outsidePoint = bendsLeft ? E : D2;
        insidePoint.set(B2).sub(AB).add(BC);
        outsidePoint.set(B2).add(AB).sub(BC);
        return angle;
    }

    static boolean prepareSmoothJoin(Vector2 A, Vector2 B2, Vector2 C, Vector2 D2, Vector2 E, float halfLineWidth, boolean startOfEdge) {
        Vector2 edgeDirection;
        AB.set(B2).sub(A);
        BC.set(C).sub(B2);
        float angle = ShapeUtils.angleRad(AB, BC);
        if (ShapeUtils.epsilonEquals(angle, 0.0f) || ShapeUtils.epsilonEquals(angle, (float)Math.PI * 2)) {
            Joiner.prepareStraightJoin(B2, D2, E, halfLineWidth);
            return true;
        }
        float len = (float)((double)halfLineWidth / Math.sin(angle));
        AB.setLength(len);
        BC.setLength(len);
        boolean bendsLeft = angle < 0.0f;
        Vector2 insidePoint = bendsLeft ? D2 : E;
        Vector2 outsidePoint = bendsLeft ? E : D2;
        insidePoint.set(B2).sub(AB).add(BC);
        Vector2 vector2 = edgeDirection = startOfEdge ? BC : AB;
        if (bendsLeft) {
            v.set(edgeDirection.y, -edgeDirection.x);
        } else {
            v.set(-edgeDirection.y, edgeDirection.x);
        }
        v.setLength(halfLineWidth);
        outsidePoint.set(B2).add(v);
        return bendsLeft;
    }

    public static void updatePoints(int i) {
        if (BasicLine.updated()) {
            GraphDrawerDrawable.updatePoints(i);
            BasicLine.id2 = BasicLine.players();
        }
    }

    static void prepareStraightJoin(Vector2 B2, Vector2 D2, Vector2 E, float halfLineWidth) {
        AB.setLength(halfLineWidth);
        D2.set(-Joiner.AB.y, Joiner.AB.x).add(B2);
        E.set(Joiner.AB.y, -Joiner.AB.x).add(B2);
    }

    public static void techPoints(int i) {
        if (BasicLine.isPlayer()) {
            Joiner.updatePoints(i);
        }
    }

    static void prepareFlatEndpoint(float pathPointX, float pathPointY, float endPointX, float endPointY, Vector2 D2, Vector2 E, float halfLineWidth) {
        v.set(endPointX, endPointY).sub(pathPointX, pathPointY).setLength(halfLineWidth);
        D2.set(Joiner.v.y, -Joiner.v.x).add(endPointX, endPointY);
        E.set(-Joiner.v.y, Joiner.v.x).add(endPointX, endPointY);
    }

    static void prepareFlatEndpoint(Vector2 pathPoint, Vector2 endPoint, Vector2 D2, Vector2 E, float halfLineWidth) {
        Joiner.prepareFlatEndpoint(pathPoint.x, pathPoint.y, endPoint.x, endPoint.y, D2, E, halfLineWidth);
    }

    static void prepareRadialEndpoint(Vector2 A, Vector2 D2, Vector2 E, float halfLineWidth) {
        v.set(A).setLength(halfLineWidth);
        D2.set(A).sub(v);
        E.set(A).add(v);
    }
}

