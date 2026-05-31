/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer;

import com.badlogic.gdx.math.Vector2;
import space.earlygrey.shapedrewer.AbstractShapeDrawer;
import space.earlygrey.shapedrewer.BatchManager;
import space.earlygrey.shapedrewer.DrawerTemplate;
import space.earlygrey.shapedrewer.JoinType;
import space.earlygrey.shapedrewer.Joiner;
import space.earlygrey.shapedrewer.ShapeUtils;

class PolygonDrawer
extends DrawerTemplate<BatchManager> {
    static final Vector2 centre = new Vector2();
    static final Vector2 radius = new Vector2();

    PolygonDrawer(BatchManager batchManager, AbstractShapeDrawer drawer) {
        super(batchManager, drawer);
    }

    void polygon(float centreX, float centreY, int sides, float radiusX, float radiusY, float rotation, float lineWidth, JoinType joinType, float startAngle, float radians) {
        if (radians == 0.0f) {
            return;
        }
        radians = Math.min(radians, (float)Math.PI * 2);
        float halfLineWidth = 0.5f * lineWidth;
        centre.set(centreX, centreY);
        radius.set(radiusX, radiusY);
        boolean wasCaching = this.batchManager.startCaching();
        if (joinType == JoinType.NONE) {
            this.drawPolygonNoJoin(centre, sides, lineWidth, rotation, radius, startAngle, radians);
        } else {
            this.drawPolygonWithJoin(centre, sides, halfLineWidth, rotation, radius, startAngle, radians, joinType == JoinType.SMOOTH);
        }
        if (!wasCaching) {
            this.batchManager.endCaching();
        }
    }

    void drawPolygonNoJoin(Vector2 centre, int sides, float lineWidth, float rotation, Vector2 radius, float startAngle, float radians) {
        float angleInterval = (float)Math.PI * 2 / (float)sides;
        float endAngle = startAngle + radians;
        float cos = (float)Math.cos(angleInterval);
        float sin = (float)Math.sin(angleInterval);
        float cosRot = (float)Math.cos(rotation);
        float sinRot = (float)Math.sin(rotation);
        int start = (int)Math.ceil((float)sides * (startAngle / ((float)Math.PI * 2)));
        int end = (int)Math.floor((float)sides * (endAngle / ((float)Math.PI * 2))) + 1;
        dir.set(1.0f, 0.0f).rotateRad(Math.min((float)start * angleInterval, endAngle));
        A.set(1.0f, 0.0f).rotateRad(startAngle).scl(radius);
        B.set(dir).scl(radius);
        for (int i = start; i <= end; ++i) {
            float x1 = PolygonDrawer.A.x * cosRot - PolygonDrawer.A.y * sinRot + centre.x;
            float y1 = PolygonDrawer.A.x * sinRot + PolygonDrawer.A.y * cosRot + centre.y;
            float x2 = PolygonDrawer.B.x * cosRot - PolygonDrawer.B.y * sinRot + centre.x;
            float y2 = PolygonDrawer.B.x * sinRot + PolygonDrawer.B.y * cosRot + centre.y;
            this.drawer.lineDrawer.pushLine(x1, y1, x2, y2, lineWidth, false);
            if (i < end - 1) {
                A.set(B);
                dir.set(PolygonDrawer.dir.x * cos - PolygonDrawer.dir.y * sin, PolygonDrawer.dir.x * sin + PolygonDrawer.dir.y * cos);
                B.set(dir).scl(radius);
                continue;
            }
            if (i != end - 1) continue;
            A.set(B);
            B.set(1.0f, 0.0f).rotateRad(endAngle).scl(radius);
        }
    }

    void drawPolygonWithJoin(Vector2 centre, int sides, float halfLineWidth, float rotation, Vector2 radius, float startAngle, float radians, boolean smooth) {
        int end;
        int start;
        float c = this.batchManager.floatBits;
        boolean full = ShapeUtils.epsilonEquals(radians, (float)Math.PI * 2);
        float angleInterval = (float)Math.PI * 2 / (float)sides;
        float endAngle = startAngle + radians;
        float cos = (float)Math.cos(angleInterval);
        float sin = (float)Math.sin(angleInterval);
        float cosRot = (float)Math.cos(rotation);
        float sinRot = (float)Math.sin(rotation);
        if (full) {
            start = 1;
            end = sides;
            dir.set(1.0f, 0.0f).rotateRad((float)start * angleInterval);
            A.set(1.0f, 0.0f).rotateRad((float)(start - 2) * angleInterval).scl(radius);
            C.set(dir).scl(radius);
            B.set(1.0f, 0.0f).rotateRad((float)(start - 1) * angleInterval).scl(radius);
        } else {
            start = (int)Math.ceil((float)sides * (startAngle / ((float)Math.PI * 2)));
            if (ShapeUtils.epsilonEquals((float)start * angleInterval, startAngle)) {
                ++start;
            }
            end = (int)Math.floor((float)sides * (endAngle / ((float)Math.PI * 2))) + 1;
            end = Math.min(end, start + sides);
            dir.set(1.0f, 0.0f).rotateRad(Math.min((float)start * angleInterval, endAngle));
            A.set(1.0f, 0.0f).rotateRad((float)(start - 1) * angleInterval).scl(radius);
            B.set(1.0f, 0.0f).rotateRad(startAngle).scl(radius);
            C.set(dir).scl(radius);
        }
        for (int i = start; i <= end; ++i) {
            this.batchManager.ensureSpaceForQuad();
            if (!full && i == start) {
                Joiner.prepareRadialEndpoint(B, D, E, halfLineWidth);
            } else if (smooth) {
                Joiner.prepareSmoothJoin(A, B, C, D, E, halfLineWidth, true);
            } else {
                Joiner.preparePointyJoin(A, B, C, D, E, halfLineWidth);
            }
            this.vert1(PolygonDrawer.E.x * cosRot - PolygonDrawer.E.y * sinRot + centre.x, PolygonDrawer.E.x * sinRot + PolygonDrawer.E.y * cosRot + centre.y);
            this.vert2(PolygonDrawer.D.x * cosRot - PolygonDrawer.D.y * sinRot + centre.x, PolygonDrawer.D.x * sinRot + PolygonDrawer.D.y * cosRot + centre.y);
            if (full || i < end) {
                A.set(B);
                B.set(C);
                dir.set(PolygonDrawer.dir.x * cos - PolygonDrawer.dir.y * sin, PolygonDrawer.dir.x * sin + PolygonDrawer.dir.y * cos);
                C.set(dir).scl(radius);
            } else {
                B.set(1.0f, 0.0f).rotateRad(endAngle).scl(radius);
            }
            if (full || i < end) {
                if (smooth) {
                    Joiner.prepareSmoothJoin(A, B, C, D, E, halfLineWidth, false);
                } else {
                    Joiner.preparePointyJoin(A, B, C, D, E, halfLineWidth);
                }
            } else {
                Joiner.prepareRadialEndpoint(B, D, E, halfLineWidth);
            }
            this.vert3(PolygonDrawer.D.x * cosRot - PolygonDrawer.D.y * sinRot + centre.x, PolygonDrawer.D.x * sinRot + PolygonDrawer.D.y * cosRot + centre.y);
            this.vert4(PolygonDrawer.E.x * cosRot - PolygonDrawer.E.y * sinRot + centre.x, PolygonDrawer.E.x * sinRot + PolygonDrawer.E.y * cosRot + centre.y);
            this.color(c, c, c, c);
            this.batchManager.pushQuad();
            if (!smooth || !full && i >= end) continue;
            this.drawSmoothJoinFill(A, B, C, D, E, centre, cosRot, sinRot, halfLineWidth);
        }
    }
}

