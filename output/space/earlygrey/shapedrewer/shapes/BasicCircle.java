/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer.shapes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import space.earlygrey.shapedrewer.JoinType;
import space.earlygrey.shapedrewer.ShapeDrawer;
import space.earlygrey.shapedrewer.shapes.BasicEllipse;
import space.earlygrey.shapedrewer.shapes.Shape;

public class BasicCircle
implements Shape.OutlinedCircle {
    private BasicEllipse ellipse;

    protected BasicCircle(ShapeDrawer drawer) {
        this.ellipse = new BasicEllipse(drawer);
    }

    void reset(boolean filled) {
        this.ellipse.reset(filled);
    }

    @Override
    public BasicCircle color(Color color) {
        this.ellipse.color(color);
        return this;
    }

    @Override
    public BasicCircle centre(float x, float y) {
        this.ellipse.centre(x, y);
        return this;
    }

    @Override
    public BasicCircle centre(Vector2 centre) {
        this.ellipse.centre(centre);
        return this;
    }

    @Override
    public BasicCircle radius(float radius) {
        this.ellipse.radiusX(radius);
        this.ellipse.radiusY(radius);
        return this;
    }

    @Override
    public BasicCircle joinType(JoinType joinType) {
        this.ellipse.joinType(joinType);
        return this;
    }

    @Override
    public BasicCircle lineWidth(float width) {
        this.ellipse.setLineWidth(width);
        return this;
    }

    @Override
    public void draw() {
        this.ellipse.draw();
    }
}

