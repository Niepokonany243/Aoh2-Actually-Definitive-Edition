/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer.shapes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.FloatArray;
import space.earlygrey.shapedrewer.JoinType;
import space.earlygrey.shapedrewer.ShapeUtils;

public interface Shape<T extends Shape> {
    public void draw();

    public T color(Color var1);

    public static interface OutlinedRectangle<T extends OutlinedRectangle<T>>
    extends FilledRectangle<OutlinedRectangle<T>> {
        public OutlinedRectangle joinType(JoinType var1);

        public OutlinedRectangle lineWidth(float var1);
    }

    public static interface FilledRectangle<T extends FilledRectangle<T>>
    extends Shape<T> {
        public T position(float var1, float var2);

        public T position(Vector2 var1);

        public T size(float var1, float var2);

        public T rotation(float var1);

        public T rotate(float var1);
    }

    public static interface Arc<T extends Arc<T>>
    extends Sector<Arc<T>> {
        public Arc joinType(JoinType var1);

        public Arc lineWidth(float var1);
    }

    public static interface Sector<T extends Sector<T>>
    extends Shape<T> {
        public T centre(float var1, float var2);

        public T centre(Vector2 var1);

        public T radius(float var1);

        public T startAngle(float var1);

        public T radians(float var1);

        public T sides(int var1);
    }

    public static interface OutlinedRegularPolygon<T extends OutlinedRegularPolygon<T>>
    extends FilledRegularPolygon<OutlinedRegularPolygon<T>> {
        public OutlinedRegularPolygon joinType(JoinType var1);

        public OutlinedRegularPolygon lineWidth(float var1);
    }

    public static interface FilledRegularPolygon<T extends FilledRegularPolygon<T>>
    extends Shape<T> {
        public T centre(Vector2 var1);

        public T radiusX(float var1);

        public T radiusY(float var1);

        public T radius(float var1);

        public T rotation(float var1);

        public T rotate(float var1);

        public T sides(int var1);
    }

    public static interface PolyLine<T extends PolyLine<T>>
    extends OutlinedPolygon<PolyLine<T>> {
        public PolyLine lineWidth(ShapeUtils.LineWidthFunction var1);
    }

    public static interface OutlinedPolygon<T extends OutlinedPolygon<T>>
    extends FilledPolygon<T> {
        public T joinType(JoinType var1);

        public T lineWidth(float var1);
    }

    public static interface FilledPolygon<T extends FilledPolygon<T>>
    extends Shape<T> {
        public <V extends Vector2> T vertices(Iterable<V> var1);

        public T vertices(FloatArray var1);

        public T vertices(float[] var1);

        public T addVertex(float var1, float var2);

        public T addVertex(Vector2 var1);

        public T offset(float var1, float var2);

        public T scale(float var1, float var2);
    }

    public static interface OutlinedTriangle<T extends OutlinedTriangle<T>>
    extends FilledTriangle<OutlinedTriangle<T>> {
        public OutlinedTriangle joinType(JoinType var1);

        public OutlinedTriangle lineWidth(float var1);
    }

    public static interface FilledTriangle<T extends FilledTriangle<T>>
    extends Shape<T> {
        public T a(float var1, float var2);

        public T b(float var1, float var2);

        public T c(float var1, float var2);

        public T a(Vector2 var1);

        public T b(Vector2 var1);

        public T c(Vector2 var1);
    }

    public static interface Line<T extends Line<T>>
    extends Shape<Line<T>> {
        public Line from(float var1, float var2);

        public Line to(float var1, float var2);

        public Line from(Vector2 var1);

        public Line to(Vector2 var1);

        public Line joinType(JoinType var1);

        public Line lineWidth(float var1);

        public Line startColor(Color var1);

        public Line endColor(Color var1);

        public Line snap(boolean var1);
    }

    public static interface OutlinedEllipse<T extends OutlinedEllipse<T>>
    extends FilledEllipse<OutlinedEllipse<T>> {
        public OutlinedEllipse joinType(JoinType var1);

        public OutlinedEllipse lineWidth(float var1);
    }

    public static interface FilledEllipse<T extends FilledEllipse<T>>
    extends Shape<T> {
        public T centre(float var1, float var2);

        public T centre(Vector2 var1);

        public T radiusX(float var1);

        public T radiusY(float var1);

        public T rotation(float var1);

        public T rotate(float var1);
    }

    public static interface OutlinedCircle<T extends OutlinedCircle<T>>
    extends FilledCircle<OutlinedCircle<T>> {
        public OutlinedCircle joinType(JoinType var1);

        public OutlinedCircle lineWidth(float var1);
    }

    public static interface FilledCircle<T extends FilledCircle<T>>
    extends Shape<T> {
        public T centre(float var1, float var2);

        public T centre(Vector2 var1);

        public T radius(float var1);
    }
}

