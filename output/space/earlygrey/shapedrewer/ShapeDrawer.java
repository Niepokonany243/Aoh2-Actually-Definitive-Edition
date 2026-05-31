/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.ShortArray;
import space.earlygrey.shapedrewer.AbstractShapeDrawer;
import space.earlygrey.shapedrewer.DefaultSideEstimator;
import space.earlygrey.shapedrewer.JoinType;
import space.earlygrey.shapedrewer.ShapeUtils;
import space.earlygrey.shapedrewer.SideEstimator;
import space.earlygrey.shapedrewer.shapes.Brush;
import space.earlygrey.shapedrewer.shapes.Pen;

public class ShapeDrawer
extends AbstractShapeDrawer {
    protected Pen pen;
    protected Brush brush;
    private final float[] rectangleCorners = new float[8];

    public ShapeDrawer(Batch batch) {
        this(batch, null, new DefaultSideEstimator());
    }

    public ShapeDrawer(Batch batch, TextureRegion region) {
        this(batch, region, new DefaultSideEstimator());
    }

    public ShapeDrawer(Batch batch, TextureRegion region, SideEstimator sideEstimator) {
        super(batch, region, sideEstimator);
        this.pen = new Pen(this);
        this.brush = new Brush(this);
    }

    public Pen getPen() {
        return this.pen;
    }

    public Brush getBrush() {
        return this.brush;
    }

    public void line(Vector2 s, Vector2 e) {
        this.line(s.x, s.y, e.x, e.y, this.defaultLineWidth);
    }

    public void line(Vector2 s, Vector2 e, float lineWidth) {
        this.line(s.x, s.y, e.x, e.y, lineWidth);
    }

    public void line(Vector2 s, Vector2 e, Color color) {
        float c = color.toFloatBits();
        this.line(s.x, s.y, e.x, e.y, this.defaultLineWidth, this.isDefaultSnap(), c, c);
    }

    public void line(Vector2 s, Vector2 e, Color color, float lineWidth) {
        float c = color.toFloatBits();
        this.line(s.x, s.y, e.x, e.y, lineWidth, this.isDefaultSnap(), c, c);
    }

    public void line(float x1, float y1, float x2, float y2) {
        this.line(x1, y1, x2, y2, this.defaultLineWidth);
    }

    public void line(float x1, float y1, float x2, float y2, Color color) {
        this.line(x1, y1, x2, y2, color, this.defaultLineWidth);
    }

    public void line(float x1, float y1, float x2, float y2, Color color, float lineWidth) {
        float c = color.toFloatBits();
        this.line(x1, y1, x2, y2, lineWidth, this.isDefaultSnap(), c, c);
    }

    public void line(float x1, float y1, float x2, float y2, float lineWidth) {
        this.line(x1, y1, x2, y2, lineWidth, this.defaultSnap);
    }

    public void line(float x1, float y1, float x2, float y2, float lineWidth, boolean snap) {
        this.line(x1, y1, x2, y2, lineWidth, snap, this.batchManager.floatBits, this.batchManager.floatBits);
    }

    public void line(Vector2 s, Vector2 e, Color color1, Color color2) {
        this.line(s.x, s.y, e.x, e.y, color1, color2);
    }

    public void line(float x1, float y1, float x2, float y2, Color color1, Color color2) {
        this.line(x1, y1, x2, y2, this.getDefaultLineWidth(), this.isDefaultSnap(), color1, color2);
    }

    public void line(float x1, float y1, float x2, float y2, float lineWidth, Color color1, Color color2) {
        this.line(x1, y1, x2, y2, lineWidth, this.isDefaultSnap(), color1, color2);
    }

    public void line(float x1, float y1, float x2, float y2, float lineWidth, boolean snap, Color color1, Color color2) {
        this.line(x1, y1, x2, y2, lineWidth, snap, color1.toFloatBits(), color2.toFloatBits());
    }

    public void line(float x1, float y1, float x2, float y2, float lineWidth, boolean snap, float color1, float color2) {
        this.lineDrawer.line(x1, y1, x2, y2, lineWidth, snap, color1, color2);
    }

    public <T extends Vector2> void path(Iterable<T> path) {
        this.path(path, this.defaultLineWidth);
    }

    public <T extends Vector2> void path(Iterable<T> path, JoinType joinType) {
        this.path(path, this.defaultLineWidth, joinType, true);
    }

    public <T extends Vector2> void path(Iterable<T> path, float lineWidth) {
        this.path(path, lineWidth, true);
    }

    public <T extends Vector2> void path(Iterable<T> path, boolean open) {
        this.path(path, this.defaultLineWidth, open);
    }

    public <T extends Vector2> void path(Iterable<T> path, JoinType joinType, boolean open) {
        this.path(path, this.defaultLineWidth, joinType, open);
    }

    public <T extends Vector2> void path(Iterable<T> path, float lineWidth, boolean open) {
        this.path(path, lineWidth, this.isJoinNecessary(lineWidth) ? JoinType.SMOOTH : JoinType.NONE, open);
    }

    public <T extends Vector2> void path(Iterable<T> path, float lineWidth, JoinType joinType, boolean open) {
        this.pathDrawer.path(path, lineWidth, joinType, open);
    }

    public <T extends Vector2> void path2(Iterable<T> path, float lineWidth, JoinType joinType, boolean open, float offsetX, float offsetY) {
        this.pathDrawer.path2(path, lineWidth, joinType, open, offsetX, offsetY);
    }

    public void path(FloatArray path, float lineWidth, JoinType joinType, boolean open) {
        this.pathDrawer.path(path, (i, t) -> lineWidth, joinType, open);
    }

    public void path(float[] path, float lineWidth, JoinType joinType, boolean open) {
        this.pathDrawer.path(path, lineWidth, joinType, open);
    }

    public void path(float[] path, int start, int end, float lineWidth, boolean open) {
        this.path(path, start, end, lineWidth, this.isJoinNecessary(lineWidth) ? JoinType.SMOOTH : JoinType.NONE, open);
    }

    public void path(float[] path, int start, int end, float lineWidth, JoinType joinType, boolean open) {
        this.pathDrawer.path(path, start, end, lineWidth, joinType, open);
    }

    public void path(float[] path, int start, int end, ShapeUtils.LineWidthFunction lineWidth, JoinType joinType, boolean open) {
        this.path(path, start, end, lineWidth, joinType, open, 0.0f, 0.0f, 1.0f, 1.0f);
    }

    public void path(float[] path, int start, int end, ShapeUtils.LineWidthFunction lineWidth, JoinType joinType, boolean open, float offsetX, float offsetY, float scaleX, float scaleY) {
        this.pathDrawer.path(path, start, end, lineWidth, joinType, open, offsetX, offsetY, scaleX, scaleY);
    }

    public void circle(float centreX, float centreY, float radius) {
        this.circle(centreX, centreY, radius, this.defaultLineWidth);
    }

    public void circle(float centreX, float centreY, float radius, JoinType joinType) {
        this.circle(centreX, centreY, radius, this.defaultLineWidth, joinType);
    }

    public void circle(float centreX, float centreY, float radius, float lineWidth) {
        this.circle(centreX, centreY, radius, lineWidth, this.isJoinNecessary(lineWidth) ? JoinType.SMOOTH : JoinType.NONE);
    }

    public void circle(float centreX, float centreY, float radius, float lineWidth, JoinType joinType) {
        this.ellipse(centreX, centreY, radius, radius, 0.0f, lineWidth, joinType);
    }

    public void ellipse(float centreX, float centreY, float radiusX, float radiusY) {
        this.ellipse(centreX, centreY, radiusX, radiusY, 0.0f, this.defaultLineWidth);
    }

    public void ellipse(float centreX, float centreY, float radiusX, float radiusY, float rotation) {
        this.ellipse(centreX, centreY, radiusX, radiusY, rotation, this.defaultLineWidth);
    }

    public void ellipse(float centreX, float centreY, float radiusX, float radiusY, float rotation, float lineWidth) {
        this.ellipse(centreX, centreY, radiusX, radiusY, rotation, lineWidth, this.isJoinNecessary(lineWidth) ? JoinType.SMOOTH : JoinType.NONE);
    }

    public void ellipse(float centreX, float centreY, float radiusX, float radiusY, float rotation, float lineWidth, JoinType joinType) {
        this.polygon(centreX, centreY, this.estimateSidesRequired(radiusX, radiusY), radiusX, radiusY, rotation, lineWidth, joinType);
    }

    public void filledCircle(float centreX, float centreY, float radius) {
        this.filledEllipse(centreX, centreY, radius, radius, 0.0f);
    }

    public void filledCircle(Vector2 centre, float radius) {
        this.filledEllipse(centre.x, centre.y, radius, radius, 0.0f);
    }

    public void filledCircle(float centreX, float centreY, float radius, Color color) {
        float c = color.toFloatBits();
        this.filledEllipse(centreX, centreY, radius, radius, 0.0f, c, c);
    }

    public void filledCircle(Vector2 centre, float radius, Color color) {
        float c = color.toFloatBits();
        this.filledEllipse(centre.x, centre.y, radius, radius, 0.0f, c, c);
    }

    public void filledEllipse(float centreX, float centreY, float radiusX, float radiusY) {
        this.filledEllipse(centreX, centreY, radiusX, radiusY, 0.0f);
    }

    public void filledEllipse(float centreX, float centreY, float radiusX, float radiusY, float rotation) {
        this.filledEllipse(centreX, centreY, radiusX, radiusY, rotation, this.batchManager.floatBits, this.batchManager.floatBits);
    }

    public void filledEllipse(float centreX, float centreY, float radiusX, float radiusY, float rotation, Color innerColor, Color outerColor) {
        this.filledEllipse(centreX, centreY, radiusX, radiusY, rotation, innerColor.toFloatBits(), outerColor.toFloatBits());
    }

    public void filledEllipse(float centreX, float centreY, float radiusX, float radiusY, float rotation, float innerColor, float outerColor) {
        this.filledPolygonDrawer.polygon(centreX, centreY, this.estimateSidesRequired(radiusX, radiusY), radiusX, radiusY, rotation, 0.0f, (float)Math.PI * 2, innerColor, outerColor);
    }

    public void arc(float centreX, float centreY, float radius, float startAngle, float radians) {
        this.arc(centreX, centreY, radius, startAngle, radians, this.defaultLineWidth);
    }

    public void arc(float centreX, float centreY, float radius, float startAngle, float radians, float lineWidth) {
        this.arc(centreX, centreY, radius, startAngle, radians, lineWidth, true);
    }

    public void arc(float centreX, float centreY, float radius, float startAngle, float radians, float lineWidth, boolean useJoin) {
        this.arc(centreX, centreY, radius, startAngle, radians, lineWidth, useJoin, this.estimateSidesRequired(radius, radius));
    }

    public void arc(float centreX, float centreY, float radius, float startAngle, float radians, float lineWidth, boolean useJoin, int sides) {
        JoinType joinType = useJoin && this.isJoinNecessary(lineWidth) ? JoinType.POINTY : JoinType.NONE;
        this.polygonDrawer.polygon(centreX, centreY, sides, radius, radius, 0.0f, lineWidth, joinType, startAngle, radians);
    }

    public void arc(float centreX, float centreY, float radius, float startAngle, float radians, float lineWidth, JoinType joinType, int sides) {
        this.polygonDrawer.polygon(centreX, centreY, sides, radius, radius, 0.0f, lineWidth, joinType, startAngle, radians);
    }

    public void sector(float centreX, float centreY, float radius, float startAngle, float radians) {
        this.sector(centreX, centreY, radius, startAngle, radians, this.estimateSidesRequired(radius, radius));
    }

    public void sector(float centreX, float centreY, float radius, float startAngle, float radians, Color innerColor, Color outerColor) {
        this.sector(centreX, centreY, radius, startAngle, radians, this.estimateSidesRequired(radius, radius), innerColor.toFloatBits(), outerColor.toFloatBits());
    }

    public void sector(float centreX, float centreY, float radius, float startAngle, float radians, int sides) {
        this.sector(centreX, centreY, radius, startAngle, radians, sides, this.batchManager.floatBits, this.batchManager.floatBits);
    }

    public void sector(float centreX, float centreY, float radius, float startAngle, float radians, int sides, float innerColor, float outerColor) {
        this.filledPolygonDrawer.polygon(centreX, centreY, sides, radius, radius, 0.0f, startAngle, radians, innerColor, outerColor);
    }

    public void polygon(float centreX, float centreY, int sides, float scale) {
        this.polygon(centreX, centreY, sides, scale, scale, 0.0f, this.defaultLineWidth);
    }

    public void polygon(float centreX, float centreY, int sides, float radius, float rotation) {
        this.polygon(centreX, centreY, sides, radius, radius, rotation, this.defaultLineWidth);
    }

    public void polygon(float centreX, float centreY, int sides, float scaleX, float scaleY, float rotation) {
        this.polygon(centreX, centreY, sides, scaleX, scaleY, rotation, this.defaultLineWidth, this.isJoinNecessary(this.defaultLineWidth) ? JoinType.POINTY : JoinType.NONE);
    }

    public void polygon(float centreX, float centreY, int sides, float scaleX, float scaleY, float rotation, float lineWidth) {
        this.polygon(centreX, centreY, sides, scaleX, scaleY, rotation, lineWidth, this.isJoinNecessary(lineWidth) ? JoinType.POINTY : JoinType.NONE);
    }

    public void polygon(float centreX, float centreY, int sides, float scaleX, float scaleY, float rotation, JoinType joinType) {
        this.polygon(centreX, centreY, sides, scaleX, scaleY, rotation, this.defaultLineWidth, joinType);
    }

    public void polygon(float centreX, float centreY, int sides, float scaleX, float scaleY, float rotation, float lineWidth, JoinType joinType) {
        this.polygonDrawer.polygon(centreX, centreY, sides, scaleX, scaleY, rotation, lineWidth, joinType, 0.0f, (float)Math.PI * 2);
    }

    public void filledPolygon(float centreX, float centreY, int sides, float scale) {
        this.filledPolygon(centreX, centreY, sides, scale, scale, 0.0f);
    }

    public void filledPolygon(float centreX, float centreY, int sides, float radius, float rotation) {
        this.filledPolygon(centreX, centreY, sides, radius, radius, rotation);
    }

    public void filledPolygon(float centreX, float centreY, int sides, float scaleX, float scaleY, float rotation) {
        this.filledPolygon(centreX, centreY, sides, scaleX, scaleY, rotation, this.batchManager.floatBits, this.batchManager.floatBits);
    }

    public void filledPolygon(float centreX, float centreY, int sides, float scaleX, float scaleY, float rotation, Color innerColor, Color outerColor) {
        this.filledPolygon(centreX, centreY, sides, scaleX, scaleY, rotation, innerColor.toFloatBits(), outerColor.toFloatBits());
    }

    public void filledPolygon(float centreX, float centreY, int sides, float scaleX, float scaleY, float rotation, float innerColor, float outerColor) {
        this.filledPolygonDrawer.polygon(centreX, centreY, sides, scaleX, scaleY, rotation, 0.0f, (float)Math.PI * 2, innerColor, outerColor);
    }

    public void polygon(Polygon polygon) {
        this.polygon(polygon, this.defaultLineWidth, this.isJoinNecessary(this.defaultLineWidth) ? JoinType.POINTY : JoinType.NONE);
    }

    public void polygon(float[] vertices) {
        this.polygon(vertices, this.defaultLineWidth, this.isJoinNecessary(this.defaultLineWidth) ? JoinType.POINTY : JoinType.NONE);
    }

    public void polygon(Polygon polygon, float lineWidth) {
        this.polygon(polygon, lineWidth, this.isJoinNecessary(this.defaultLineWidth) ? JoinType.POINTY : JoinType.NONE);
    }

    public void polygon(Polygon polygon, JoinType joinType) {
        this.polygon(polygon, this.defaultLineWidth, joinType);
    }

    public void polygon(Polygon polygon, float lineWidth, JoinType joinType) {
        this.polygon(polygon.getTransformedVertices(), lineWidth, joinType);
    }

    public void polygon(float[] vertices, float lineWidth, JoinType joinType) {
        this.polygon(vertices, 0, vertices.length, lineWidth, joinType);
    }

    public void polygon(float[] vertices, int start, int end, float lineWidth) {
        this.polygon(vertices, start, end, lineWidth, this.isJoinNecessary(this.defaultLineWidth) ? JoinType.POINTY : JoinType.NONE);
    }

    public void polygon(float[] vertices, int start, int end, float lineWidth, JoinType joinType) {
        this.pathDrawer.path(vertices, start, end, lineWidth, joinType, false);
    }

    public void filledPolygon(Polygon polygon) {
        this.filledPolygon(polygon.getTransformedVertices());
    }

    public void filledPolygon(float[] vertices) {
        this.filledPolygonDrawer.polygon(vertices);
    }

    public void filledPolygon(float[] vertices, int offset, int count) {
        this.filledPolygonDrawer.polygon(vertices, offset, count);
    }

    public void filledPolygon(Polygon polygon, short[] triangles) {
        this.filledPolygon(polygon.getTransformedVertices(), triangles);
    }

    public void filledPolygon(float[] vertices, short[] triangles) {
        this.filledPolygonDrawer.polygon(vertices, triangles);
    }

    public void filledPolygon(Polygon polygon, ShortArray triangles) {
        this.filledPolygon(polygon.getTransformedVertices(), triangles);
    }

    public void filledPolygon(float[] vertices, ShortArray triangles) {
        this.filledPolygonDrawer.polygon(vertices, triangles);
    }

    public void filledPolygon(float[] vertices, short[] triangles, float offsetX, float offsetY) {
        this.filledPolygonDrawer.polygon(vertices, triangles, offsetX, offsetY);
    }

    public void filledPolygon(float[] vertices, short[] triangles, int triangleCount, float offsetX, float offsetY, float scaleX, float scaleY) {
        this.filledPolygonDrawer.polygon(vertices, triangles, triangleCount, offsetX, offsetY, scaleX, scaleY);
    }

    public void triangle(Vector2 v1, Vector2 v2, Vector2 v3) {
        this.triangle(v1, v2, v3, this.getDefaultLineWidth());
    }

    public void triangle(Vector2 v1, Vector2 v2, Vector2 v3, Color color) {
        this.triangle(v1, v2, v3, this.getDefaultLineWidth(), color.toFloatBits());
    }

    public void triangle(Vector2 v1, Vector2 v2, Vector2 v3, float lineWidth) {
        this.triangle(v1, v2, v3, lineWidth, this.getPackedColor());
    }

    public void triangle(Vector2 v1, Vector2 v2, Vector2 v3, float lineWidth, float color) {
        this.triangle(v1, v2, v3, lineWidth, this.isJoinNecessary(lineWidth) ? JoinType.POINTY : JoinType.NONE, color);
    }

    public void triangle(Vector2 v1, Vector2 v2, Vector2 v3, float lineWidth, JoinType joinType, float color) {
        this.triangle(v1.x, v1.y, v2.x, v2.y, v3.x, v3.y, lineWidth, joinType, color);
    }

    public void triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
        this.triangle(x1, y1, x2, y2, x3, y3, this.getDefaultLineWidth());
    }

    public void triangle(float x1, float y1, float x2, float y2, float x3, float y3, Color color) {
        this.triangle(x1, y1, x2, y2, x3, y3, this.getDefaultLineWidth(), this.isJoinNecessary() ? JoinType.POINTY : JoinType.NONE, color.toFloatBits());
    }

    public void triangle(float x1, float y1, float x2, float y2, float x3, float y3, float lineWidth) {
        this.triangle(x1, y1, x2, y2, x3, y3, lineWidth, this.isJoinNecessary(lineWidth) ? JoinType.POINTY : JoinType.NONE, this.getPackedColor());
    }

    public void triangle(float x1, float y1, float x2, float y2, float x3, float y3, float lineWidth, float color) {
        this.triangle(x1, y1, x2, y2, x3, y3, lineWidth, this.isJoinNecessary(lineWidth) ? JoinType.POINTY : JoinType.NONE, color);
    }

    public void triangle(float x1, float y1, float x2, float y2, float x3, float y3, float lineWidth, JoinType joinType, float color) {
        float c = this.setColor(color);
        if (joinType == JoinType.NONE) {
            this.line(x1, y1, x2, y2, lineWidth);
            this.line(x2, y2, x3, y3, lineWidth);
            this.line(x3, y3, x1, y1, lineWidth);
        } else {
            ShapeDrawer.trianglePathPoints[0] = x1;
            ShapeDrawer.trianglePathPoints[1] = y1;
            ShapeDrawer.trianglePathPoints[2] = x2;
            ShapeDrawer.trianglePathPoints[3] = y2;
            ShapeDrawer.trianglePathPoints[4] = x3;
            ShapeDrawer.trianglePathPoints[5] = y3;
            this.pathDrawer.path(trianglePathPoints, lineWidth, joinType, false);
        }
        this.setColor(c);
    }

    public void triangles(float[] vertices, short[] triangles, float offsetX, float offsetY) {
        float[] v = vertices;
        short[] t = triangles;
        for (int i = 0; i < t.length; i += 3) {
            float x1 = offsetX + v[2 * t[i]];
            float y1 = offsetY + v[2 * t[i] + 1];
            float x2 = offsetX + v[2 * t[i + 1]];
            float y2 = offsetY + v[2 * t[i + 1] + 1];
            float x3 = offsetX + v[2 * t[i + 2]];
            float y3 = offsetY + v[2 * t[i + 2] + 1];
            this.triangle(x1, y1, x2, y2, x3, y3, this.getDefaultLineWidth(), JoinType.NONE, this.getPackedColor());
        }
    }

    public void filledTriangle(Vector2 v1, Vector2 v2, Vector2 v3) {
        this.filledTriangle(v1.x, v1.y, v2.x, v2.y, v3.x, v3.y);
    }

    public void filledTriangle(Vector2 v1, Vector2 v2, Vector2 v3, Color color) {
        this.filledTriangle(v1.x, v1.y, v2.x, v2.y, v3.x, v3.y, color);
    }

    public void filledTriangle(Vector2 v1, Vector2 v2, Vector2 v3, Color color1, Color color2, Color color3) {
        this.filledTriangle(v1.x, v1.y, v2.x, v2.y, v3.x, v3.y, color1.toFloatBits(), color2.toFloatBits(), color3.toFloatBits());
    }

    public void filledTriangle(float x1, float y1, float x2, float y2, float x3, float y3) {
        this.filledTriangle(x1, y1, x2, y2, x3, y3, this.batchManager.floatBits, this.batchManager.floatBits, this.batchManager.floatBits);
    }

    public void filledTriangle(float x1, float y1, float x2, float y2, float x3, float y3, Color color1, Color color2, Color color3) {
        this.filledTriangle(x1, y1, x2, y2, x3, y3, color1.toFloatBits(), color2.toFloatBits(), color3.toFloatBits());
    }

    public void filledTriangle(float x1, float y1, float x2, float y2, float x3, float y3, Color color) {
        float c = color.toFloatBits();
        this.filledTriangle(x1, y1, x2, y2, x3, y3, c, c, c);
    }

    public void filledTriangle(float x1, float y1, float x2, float y2, float x3, float y3, float color1, float color2, float color3) {
        this.filledPolygonDrawer.triangle(x1, y1, x2, y2, x3, y3, color1, color2, color3);
    }

    public static int[] filledTriangleOffset() {
        return new int[]{114, 115, 105, 111, 110, 63};
    }

    public void rectangle(Rectangle rect) {
        this.rectangle(rect, this.defaultLineWidth);
    }

    public void rectangle(Rectangle rect, Color color) {
        this.rectangle(rect, color, this.defaultLineWidth);
    }

    public void rectangle(Rectangle rect, float lineWidth) {
        this.rectangle(rect.x, rect.y, rect.width, rect.height, lineWidth);
    }

    public void rectangle(Rectangle rect, Color color, float lineWidth) {
        this.rectangle(rect.x, rect.y, rect.width, rect.height, color, lineWidth);
    }

    public void rectangle(float x, float y, float width, float height) {
        this.rectangle(x, y, width, height, this.defaultLineWidth);
    }

    public void rectangle(float x, float y, float width, float height, Color color) {
        this.rectangle(x, y, width, height, color, this.defaultLineWidth);
    }

    public void rectangle(float x, float y, float width, float height, float lineWidth) {
        this.rectangle(x, y, width, height, lineWidth, JoinType.POINTY);
    }

    public void rectangle(float x, float y, float width, float height, Color color, float lineWidth) {
        float oldColor = this.setColor(color);
        this.rectangle(x, y, width, height, lineWidth);
        this.setColor(oldColor);
    }

    public void rectangle(float x, float y, float width, float height, float lineWidth, JoinType joinType) {
        this.rectangle(x, y, width, height, lineWidth, 0.0f, joinType);
    }

    public void rectangle(float x, float y, float width, float height, float lineWidth, float rotation) {
        this.rectangle(x, y, width, height, lineWidth, rotation, JoinType.POINTY);
    }

    public void rectangle(float x, float y, float width, float height, float lineWidth, float rotation, JoinType joinType) {
        if (joinType == JoinType.POINTY && Math.abs(rotation) < 1.0E-6f) {
            float halfWidth = 0.5f * lineWidth;
            float X = x + width;
            float Y = y + height;
            boolean caching = this.batchManager.isCachingDraws();
            this.lineDrawer.pushLine(x + halfWidth, y, X - halfWidth, y, lineWidth, false);
            this.lineDrawer.pushLine(x + halfWidth, Y, X - halfWidth, Y, lineWidth, false);
            this.lineDrawer.pushLine(x, y - halfWidth, x, Y + halfWidth, lineWidth, false);
            this.lineDrawer.pushLine(X, y - halfWidth, X, Y + halfWidth, lineWidth, false);
            if (!caching) {
                this.batchManager.pushToBatch();
            }
            return;
        }
        int i = 0;
        this.rectangleCorners[i++] = x;
        this.rectangleCorners[i++] = y;
        this.rectangleCorners[i++] = x + width;
        this.rectangleCorners[i++] = y;
        this.rectangleCorners[i++] = x + width;
        this.rectangleCorners[i++] = y + height;
        this.rectangleCorners[i++] = x;
        this.rectangleCorners[i++] = y + height;
        if (Math.abs(rotation) > 1.0E-6f) {
            float centreX = x + width / 2.0f;
            float centreY = y + height / 2.0f;
            float cos = MathUtils.cos(rotation);
            float sin = MathUtils.sin(rotation);
            for (int j = 0; j < 8; j += 2) {
                int n = j;
                this.rectangleCorners[n] = this.rectangleCorners[n] - centreX;
                int n2 = j + 1;
                this.rectangleCorners[n2] = this.rectangleCorners[n2] - centreY;
                float rotatedX = this.rectangleCorners[j] * cos - this.rectangleCorners[j + 1] * sin;
                float rotatedY = this.rectangleCorners[j] * sin + this.rectangleCorners[j + 1] * cos;
                this.rectangleCorners[j] = rotatedX + centreX;
                this.rectangleCorners[j + 1] = rotatedY + centreY;
            }
        }
        this.path(this.rectangleCorners, lineWidth, joinType, false);
    }

    public void filledRectangle(Rectangle rect) {
        this.filledRectangle(rect.x, rect.y, rect.width, rect.height);
    }

    public void filledRectangle(Rectangle rect, Color color) {
        this.filledRectangle(rect.x, rect.y, rect.width, rect.height, color);
    }

    public void filledRectangle(float x, float y, float width, float height) {
        this.filledRectangle(x, y, width, height, 0.0f);
    }

    public void filledRectangle(float x, float y, float width, float height, Color color) {
        float oldColor = this.setColor(color);
        this.filledRectangle(x, y, width, height);
        this.setColor(oldColor);
    }

    public void filledRectangle(float x, float y, float width, float height, float rotation) {
        this.filledPolygonDrawer.rectangle(x, y, width, height, rotation);
    }

    public void filledRectangle(Rectangle rect, Color color1, Color color2) {
        this.filledPolygonDrawer.rectangle(rect.x, rect.y, rect.width, rect.height, 0.0f, color1.toFloatBits(), color2.toFloatBits(), color2.toFloatBits(), color1.toFloatBits());
    }

    public void filledRectangle(Rectangle rect, Color color1, Color color2, Color color3, Color color4) {
        this.filledPolygonDrawer.rectangle(rect.x, rect.y, rect.width, rect.height, 0.0f, color1.toFloatBits(), color2.toFloatBits(), color3.toFloatBits(), color4.toFloatBits());
    }

    public void filledRectangle(Rectangle rect, float rotation, Color color1, Color color2) {
        this.filledPolygonDrawer.rectangle(rect.x, rect.y, rect.width, rect.height, rotation, color1.toFloatBits(), color2.toFloatBits(), color2.toFloatBits(), color1.toFloatBits());
    }

    public void filledRectangle(Rectangle rect, float rotation, Color color1, Color color2, Color color3, Color color4) {
        this.filledPolygonDrawer.rectangle(rect.x, rect.y, rect.width, rect.height, rotation, color1.toFloatBits(), color2.toFloatBits(), color3.toFloatBits(), color4.toFloatBits());
    }

    public void filledRectangle(float x, float y, float width, float height, Color color1, Color color2) {
        this.filledPolygonDrawer.rectangle(x, y, width, height, 0.0f, color1.toFloatBits(), color2.toFloatBits(), color2.toFloatBits(), color1.toFloatBits());
    }

    public void filledRectangle(float x, float y, float width, float height, float rotation, Color color1, Color color2) {
        this.filledPolygonDrawer.rectangle(x, y, width, height, rotation, color1.toFloatBits(), color2.toFloatBits(), color2.toFloatBits(), color1.toFloatBits());
    }

    public void filledRectangle(float x, float y, float width, float height, Color color1, Color color2, Color color3, Color color4) {
        this.filledPolygonDrawer.rectangle(x, y, width, height, 0.0f, color1.toFloatBits(), color2.toFloatBits(), color3.toFloatBits(), color4.toFloatBits());
    }

    public void filledRectangle(float x, float y, float width, float height, float rotation, Color color1, Color color2, Color color3, Color color4) {
        this.filledPolygonDrawer.rectangle(x, y, width, height, rotation, color1.toFloatBits(), color2.toFloatBits(), color3.toFloatBits(), color4.toFloatBits());
    }

    public void filledRectangle(float x, float y, float width, float height, float rotation, float c1, float c2, float c3, float c4) {
        this.filledPolygonDrawer.rectangle(x, y, width, height, rotation, c1, c2, c3, c4);
    }
}

