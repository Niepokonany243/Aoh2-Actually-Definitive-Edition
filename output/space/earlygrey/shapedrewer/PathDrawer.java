/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.FloatArray;
import space.earlygrey.shapedrewer.AbstractShapeDrawer;
import space.earlygrey.shapedrewer.BatchManager;
import space.earlygrey.shapedrewer.DrawerTemplate;
import space.earlygrey.shapedrewer.JoinType;
import space.earlygrey.shapedrewer.Joiner;
import space.earlygrey.shapedrewer.ShapeUtils;

class PathDrawer
extends DrawerTemplate<BatchManager> {
    private FloatArray path = new FloatArray();
    private FloatArray lineWidths = new FloatArray();
    private FloatArray tempPath = new FloatArray();
    private final Vector2 D0 = new Vector2();
    private final Vector2 E0 = new Vector2();
    public static final ShapeUtils.ConstantLineWidth CONSTANT_LINE_WIDTH = new ShapeUtils.ConstantLineWidth();

    PathDrawer(BatchManager batchManager, AbstractShapeDrawer drawer) {
        super(batchManager, drawer);
    }

    <T extends Vector2> void path(Iterable<T> userPath, float lineWidth, JoinType joinType) {
        this.path(userPath, lineWidth, joinType, true);
    }

    <T extends Vector2> void path(Iterable<T> userPath, float lineWidth, JoinType joinType, boolean open) {
        for (Vector2 v : userPath) {
            this.tempPath.add(v.x, v.y);
        }
        this.path(this.tempPath.items, 0, this.tempPath.size, lineWidth, joinType, open);
        this.tempPath.clear();
    }

    <T extends Vector2> void path2(Iterable<T> userPath, float lineWidth, JoinType joinType, boolean open, float offsetX, float offsetY) {
        for (Vector2 v : userPath) {
            this.path.add(v.x + offsetX, v.y + offsetY);
        }
        this.path2(CONSTANT_LINE_WIDTH.width(lineWidth), joinType, open);
    }

    <T extends Vector2> void path2_Double(Iterable<T> userPath, float offsetX, float offsetY) {
        for (Vector2 v : userPath) {
            this.path.add(v.x + offsetX, v.y + offsetY);
        }
    }

    <T extends Vector2> void path2_Double2(float lineWidth, JoinType joinType, boolean open) {
        this.path2_Double(CONSTANT_LINE_WIDTH.width(lineWidth), joinType, open);
    }

    public void path2_Double2_End() {
        this.path.clear();
    }

    <T extends Vector2> void path(Iterable<T> userPath, JoinType joinType, boolean open, ShapeUtils.LineWidthFunction lineWidth) {
        for (Vector2 v : userPath) {
            this.tempPath.add(v.x, v.y);
        }
        this.path(this.tempPath.items, 0, this.tempPath.size, lineWidth, joinType, open);
        this.tempPath.clear();
    }

    void path(FloatArray userPath, ShapeUtils.LineWidthFunction lineWidth, JoinType joinType, boolean open) {
        this.path(userPath.items, 0, userPath.size, lineWidth, joinType, open);
    }

    void path(float[] userPath, float lineWidth, JoinType joinType) {
        this.path(userPath, 0, userPath.length, lineWidth, joinType);
    }

    void path(float[] userPath, float lineWidth, JoinType joinType, boolean open) {
        this.path(userPath, 0, userPath.length, lineWidth, joinType, open);
    }

    void path(float[] userPath, int start, int end, float lineWidth, JoinType joinType) {
        this.path(userPath, start, end, lineWidth, joinType, true);
    }

    void path(float[] userPath, int start, int end, float lineWidth, JoinType joinType, boolean open) {
        this.path(userPath, start, end, CONSTANT_LINE_WIDTH.width(lineWidth), joinType, open);
    }

    void path(float[] userPath, int start, int end, ShapeUtils.LineWidthFunction lineWidth, JoinType joinType, boolean open) {
        this.path(userPath, start, end, lineWidth, joinType, open, 0.0f, 0.0f, 1.0f, 1.0f);
    }

    void path(float[] userPath, int start, int end, ShapeUtils.LineWidthFunction lineWidth, JoinType joinType, boolean open, float offsetX, float offsetY, float scaleX, float scaleY) {
        if (userPath.length < 4) {
            return;
        }
        this.path.add(userPath[start] + offsetX);
        this.path.add(userPath[start + 1] + offsetY);
        for (int i = start + 2; i < end; i += 2) {
            if (ShapeUtils.epsilonEquals(userPath[i - 2], userPath[i]) && ShapeUtils.epsilonEquals(userPath[i - 1], userPath[i + 1])) continue;
            this.path.add(offsetX + scaleX * userPath[i], offsetY + scaleY * userPath[i + 1]);
        }
        if (this.path.size < 4) {
            this.path.clear();
            return;
        }
        if (this.path.size == 4) {
            this.drawer.lineDrawer.line(this.path.items[0], this.path.items[1], this.path.items[2], this.path.items[3], lineWidth.getWidth(0, 0.0f), lineWidth.getWidth(1, 1.0f), false);
            this.path.clear();
            return;
        }
        this.setLineWidths(this.path.items, this.path.size / 2, lineWidth);
        boolean wasCaching = this.batchManager.startCaching();
        if (joinType == JoinType.NONE) {
            this.drawPathNoJoin(open);
        } else {
            this.drawPathWithJoin(open, joinType == JoinType.POINTY);
        }
        if (!wasCaching) {
            this.batchManager.endCaching();
        }
        this.path.clear();
        this.lineWidths.clear();
    }

    void path2(ShapeUtils.LineWidthFunction lineWidth, JoinType joinType, boolean open) {
        if (this.path.size < 4) {
            this.path.clear();
            return;
        }
        if (this.path.size == 4) {
            this.drawer.lineDrawer.line(this.path.items[0], this.path.items[1], this.path.items[2], this.path.items[3], lineWidth.getWidth(0, 0.0f), lineWidth.getWidth(1, 1.0f), false);
            this.path.clear();
            return;
        }
        this.setLineWidths(this.path.items, this.path.size / 2, lineWidth);
        boolean wasCaching = this.batchManager.startCaching();
        if (joinType == JoinType.NONE) {
            this.drawPathNoJoin(open);
        } else {
            this.drawPathWithJoin(open, joinType == JoinType.POINTY);
        }
        if (!wasCaching) {
            this.batchManager.endCaching();
        }
        this.path.clear();
        this.lineWidths.clear();
    }

    void path2_Double(ShapeUtils.LineWidthFunction lineWidth, JoinType joinType, boolean open) {
        if (this.path.size < 4) {
            return;
        }
        if (this.path.size == 4) {
            this.drawer.lineDrawer.line(this.path.items[0], this.path.items[1], this.path.items[2], this.path.items[3], lineWidth.getWidth(0, 0.0f), lineWidth.getWidth(1, 1.0f), false);
            return;
        }
        this.setLineWidths(this.path.items, this.path.size / 2, lineWidth);
        boolean wasCaching = this.batchManager.startCaching();
        if (joinType == JoinType.NONE) {
            this.drawPathNoJoin(open);
        } else {
            this.drawPathWithJoin(open, joinType == JoinType.POINTY);
        }
        if (!wasCaching) {
            this.batchManager.endCaching();
        }
        this.lineWidths.clear();
    }

    private void drawPathNoJoin(boolean open) {
        for (int i = 0; i < this.path.size - 2; i += 2) {
            this.drawer.lineDrawer.pushLine(this.path.get(i), this.path.get(i + 1), this.path.get(i + 2), this.path.get(i + 3), this.lineWidths.get(i / 2), this.lineWidths.get(i / 2 + 1), false);
        }
        if (!open) {
            this.drawer.lineDrawer.pushLine(this.path.get(this.path.size - 2), this.path.get(this.path.size - 1), this.path.get(0), this.path.get(1), this.lineWidths.get(this.lineWidths.size - 1), this.lineWidths.get(0), false);
        }
    }

    private void setLineWidths(float[] path, int size, ShapeUtils.LineWidthFunction lineWidth) {
        if (lineWidth == CONSTANT_LINE_WIDTH) {
            float w = lineWidth.getWidth(0, 0.0f);
            for (int i = 0; i < size; ++i) {
                this.lineWidths.add(w);
            }
            return;
        }
        float totalPathLength = ShapeUtils.pathLength(path);
        float lengthDrawn = 0.0f;
        for (int i = 0; i < size - 1; ++i) {
            float t = lengthDrawn / totalPathLength;
            this.lineWidths.add(lineWidth.getWidth(i, t));
            lengthDrawn += Vector2.dst(path[2 * i], path[2 * i + 1], path[2 * i + 2], path[2 * i + 3]);
        }
        this.lineWidths.add(lineWidth.getWidth(size - 1, 1.0f));
    }

    private void drawPathWithJoin(boolean open, boolean pointyJoin) {
        float y4;
        float x4;
        float y3;
        float x3;
        float c = this.batchManager.floatBits;
        this.batchManager.ensureSpaceForQuad();
        int i = 2;
        int vertexIndex = i / 2;
        float halfWidthA = this.lineWidths.get(vertexIndex - 1) / 2.0f;
        float halfWidthB = this.lineWidths.get(vertexIndex) / 2.0f;
        A.set(this.path.get(i - 2), this.path.get(i - 1));
        B.set(this.path.get(i), this.path.get(i + 1));
        C.set(this.path.get(i + 2), this.path.get(i + 3));
        if (pointyJoin) {
            Joiner.preparePointyJoin(A, B, C, D, E, halfWidthB);
        } else {
            Joiner.prepareSmoothJoin(A, B, C, D, E, halfWidthB, false);
        }
        this.vert3(D);
        this.vert4(E);
        Joiner.prepareFlatEndpoint(this.path.get(2), this.path.get(3), this.path.get(0), this.path.get(1), D, E, halfWidthA);
        this.vert1(E);
        this.vert2(D);
        if (pointyJoin) {
            x3 = this.x3();
            y3 = this.y3();
            x4 = this.x4();
            y4 = this.y4();
        } else {
            Joiner.prepareSmoothJoin(A, B, C, D, E, halfWidthB, true);
            x3 = PathDrawer.D.x;
            y3 = PathDrawer.D.y;
            x4 = PathDrawer.E.x;
            y4 = PathDrawer.E.y;
        }
        this.color(c, c, c, c);
        this.batchManager.pushQuad();
        if (!pointyJoin) {
            this.drawSmoothJoinFill(A, B, C, D, E, halfWidthB);
        }
        this.batchManager.ensureSpaceForQuad();
        this.vert1(x4, y4);
        this.vert2(x3, y3);
        int pSize = this.path.size - 2;
        if (pointyJoin) {
            for (i = 4; i < pSize; i += 2) {
                A.set(this.path.get(i - 2), this.path.get(i - 1));
                B.set(this.path.get(i), this.path.get(i + 1));
                C.set(this.path.get(i + 2), this.path.get(i + 3));
                Joiner.preparePointyJoin(A, B, C, D, E, halfWidthB);
                this.vert3(D);
                this.vert4(E);
                x3 = this.x3();
                y3 = this.y3();
                x4 = this.x4();
                y4 = this.y4();
                this.color(c, c, c, c);
                this.batchManager.pushQuad();
                this.batchManager.ensureSpaceForQuad();
                this.vert1(x4, y4);
                this.vert2(x3, y3);
            }
        } else {
            for (i = 4; i < pSize; i += 2) {
                A.set(this.path.get(i - 2), this.path.get(i - 1));
                B.set(this.path.get(i), this.path.get(i + 1));
                C.set(this.path.get(i + 2), this.path.get(i + 3));
                Joiner.prepareSmoothJoin(A, B, C, D, E, halfWidthB, false);
                this.vert3(D);
                this.vert4(E);
                Joiner.prepareSmoothJoin(A, B, C, D, E, halfWidthB, true);
                x3 = PathDrawer.D.x;
                y3 = PathDrawer.D.y;
                x4 = PathDrawer.E.x;
                y4 = PathDrawer.E.y;
                this.color(c, c, c, c);
                this.batchManager.pushQuad();
                this.drawSmoothJoinFill(A, B, C, D, E, halfWidthB);
                this.batchManager.ensureSpaceForQuad();
                this.vert1(x4, y4);
                this.vert2(x3, y3);
            }
        }
        float halfWidthEnd = this.lineWidths.get(this.lineWidths.size - 1) / 2.0f;
        Joiner.prepareFlatEndpoint(B, C, D, E, halfWidthEnd);
        this.vert3(E);
        this.vert4(D);
        this.color(c, c, c, c);
        this.batchManager.pushQuad();
    }

    private void drawPathWithJoin_Org(boolean open, boolean pointyJoin) {
        float c = this.batchManager.floatBits;
        this.batchManager.ensureSpaceForQuad();
        for (int i = 2; i < this.path.size - 2; i += 2) {
            float y4;
            float x4;
            float y3;
            float x3;
            int vertexIndex = i / 2;
            float halfWidthA = this.lineWidths.get(vertexIndex - 1) / 2.0f;
            float halfWidthB = this.lineWidths.get(vertexIndex) / 2.0f;
            A.set(this.path.get(i - 2), this.path.get(i - 1));
            B.set(this.path.get(i), this.path.get(i + 1));
            C.set(this.path.get(i + 2), this.path.get(i + 3));
            if (pointyJoin) {
                Joiner.preparePointyJoin(A, B, C, D, E, halfWidthB);
            } else {
                Joiner.prepareSmoothJoin(A, B, C, D, E, halfWidthB, false);
            }
            this.vert3(D);
            this.vert4(E);
            if (i == 2) {
                if (open) {
                    Joiner.prepareFlatEndpoint(this.path.get(2), this.path.get(3), this.path.get(0), this.path.get(1), D, E, halfWidthA);
                    this.vert1(E);
                    this.vert2(D);
                } else {
                    vec1.set(this.path.get(this.path.size - 2), this.path.get(this.path.size - 1));
                    if (pointyJoin) {
                        Joiner.preparePointyJoin(vec1, A, B, this.D0, this.E0, halfWidthA);
                    } else {
                        Joiner.prepareSmoothJoin(vec1, A, B, this.D0, this.E0, halfWidthA, true);
                    }
                    this.vert1(this.E0);
                    this.vert2(this.D0);
                }
            }
            if (pointyJoin) {
                x3 = this.x3();
                y3 = this.y3();
                x4 = this.x4();
                y4 = this.y4();
            } else {
                Joiner.prepareSmoothJoin(A, B, C, D, E, halfWidthB, true);
                x3 = PathDrawer.D.x;
                y3 = PathDrawer.D.y;
                x4 = PathDrawer.E.x;
                y4 = PathDrawer.E.y;
            }
            this.color(c, c, c, c);
            this.batchManager.pushQuad();
            if (!pointyJoin) {
                this.drawSmoothJoinFill(A, B, C, D, E, halfWidthB);
            }
            this.batchManager.ensureSpaceForQuad();
            this.vert1(x4, y4);
            this.vert2(x3, y3);
        }
        float halfWidthEnd = this.lineWidths.get(this.lineWidths.size - 1) / 2.0f;
        if (open) {
            Joiner.prepareFlatEndpoint(B, C, D, E, halfWidthEnd);
            this.vert3(E);
            this.vert4(D);
            this.color(c, c, c, c);
            this.batchManager.pushQuad();
        } else {
            float halfWidthStart = this.lineWidths.get(0) / 2.0f;
            if (pointyJoin) {
                A.set(this.path.get(0), this.path.get(1));
                Joiner.preparePointyJoin(B, C, A, D, E, halfWidthEnd);
                this.vert3(D);
                this.vert4(E);
                this.color(c, c, c, c);
                this.batchManager.pushQuad();
                this.batchManager.ensureSpaceForQuad();
                this.vert1(D);
                this.vert2(E);
                this.vert3(this.E0);
                this.vert4(this.D0);
                this.color(c, c, c, c);
                this.batchManager.pushQuad();
            } else {
                A.set(B);
                B.set(C);
                C.set(this.path.get(0), this.path.get(1));
                Joiner.prepareSmoothJoin(A, B, C, D, E, halfWidthEnd, false);
                this.vert3(D);
                this.vert4(E);
                this.color(c, c, c, c);
                this.batchManager.pushQuad();
                this.drawSmoothJoinFill(A, B, C, D, E, halfWidthEnd);
                this.batchManager.ensureSpaceForQuad();
                Joiner.prepareSmoothJoin(A, B, C, D, E, halfWidthEnd, true);
                this.vert3(E);
                this.vert4(D);
                A.set(this.path.get(2), this.path.get(3));
                Joiner.prepareSmoothJoin(B, C, A, D, E, halfWidthStart, false);
                this.vert1(D);
                this.vert2(E);
                this.color(c, c, c, c);
                this.batchManager.pushQuad();
                this.drawSmoothJoinFill(B, C, A, D, E, halfWidthStart);
            }
        }
    }
}

