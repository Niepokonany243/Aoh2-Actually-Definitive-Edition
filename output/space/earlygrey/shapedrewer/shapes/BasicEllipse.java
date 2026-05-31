/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer.shapes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import space.earlygrey.shapedrewer.JoinType;
import space.earlygrey.shapedrewer.ShapeDrawer;
import space.earlygrey.shapedrewer.shapes.BasicShape;
import space.earlygrey.shapedrewer.shapes.Shape;

public class BasicEllipse
extends BasicShape
implements Shape.OutlinedEllipse {
    Vector2 centre = new Vector2();
    float radiusX;
    float radiusY;
    float rotation;

    protected BasicEllipse(ShapeDrawer drawer) {
        super(drawer);
    }

    @Override
    void reset(boolean filled) {
        super.reset(filled);
        this.centre.setZero();
        this.radiusX = 1.0f;
        this.radiusY = 1.0f;
        this.rotation = 0.0f;
    }

    @Override
    public BasicEllipse color(Color color) {
        this.color = color.toFloatBits();
        return this;
    }

    @Override
    public BasicEllipse centre(float x, float y) {
        this.centre.set(x, y);
        return this;
    }

    @Override
    public BasicEllipse centre(Vector2 centre) {
        this.centre.set(centre);
        return this;
    }

    @Override
    public BasicEllipse radiusX(float radiusX) {
        this.radiusX = radiusX;
        return this;
    }

    @Override
    public BasicEllipse radiusY(float radiusY) {
        this.radiusY = radiusY;
        return this;
    }

    @Override
    public BasicEllipse rotation(float rotation) {
        this.rotation = rotation;
        return this;
    }

    @Override
    public BasicEllipse rotate(float rotation) {
        this.rotation += rotation;
        return this;
    }

    @Override
    public BasicEllipse joinType(JoinType joinType) {
        this.joinType = joinType;
        return this;
    }

    @Override
    public BasicEllipse lineWidth(float width) {
        this.setLineWidth(width);
        return this;
    }

    @Override
    public void draw() {
        float c = this.drawer.setColor(this.color);
        if (this.filled) {
            this.drawer.filledEllipse(this.centre.x, this.centre.y, this.radiusX, this.radiusY, this.rotation);
        } else {
            this.drawer.ellipse(this.centre.x, this.centre.y, this.radiusX, this.radiusY, this.rotation, this.lineWidth.getWidth(0, 0.0f), this.joinType);
        }
        this.drawer.setColor(c);
    }
}

