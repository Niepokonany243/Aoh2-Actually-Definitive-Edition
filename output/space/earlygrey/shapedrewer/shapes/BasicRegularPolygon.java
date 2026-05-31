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

class BasicRegularPolygon
extends BasicShape<BasicRegularPolygon>
implements Shape.OutlinedRegularPolygon {
    Vector2 centre = new Vector2();
    float scaleX;
    float scaleY;
    float rotation;
    int sides;

    protected BasicRegularPolygon(ShapeDrawer drawer) {
        super(drawer);
    }

    @Override
    void reset(boolean filled) {
        super.reset(filled);
        this.centre.setZero();
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.rotation = 0.0f;
        this.sides = 6;
    }

    @Override
    public BasicRegularPolygon joinType(JoinType joinType) {
        this.joinType = joinType;
        return this;
    }

    @Override
    public BasicRegularPolygon lineWidth(float width) {
        this.setLineWidth(width);
        return this;
    }

    @Override
    public BasicRegularPolygon color(Color color) {
        this.color = color.toFloatBits();
        return this;
    }

    @Override
    public BasicRegularPolygon centre(Vector2 centre) {
        this.centre.set(centre);
        return this;
    }

    @Override
    public BasicRegularPolygon radiusX(float radiusX) {
        this.scaleX = radiusX;
        return this;
    }

    @Override
    public BasicRegularPolygon radiusY(float radiusY) {
        this.scaleY = radiusY;
        return this;
    }

    @Override
    public BasicRegularPolygon radius(float radius) {
        this.scaleX = radius;
        this.scaleY = radius;
        return this;
    }

    @Override
    public BasicRegularPolygon rotation(float rotation) {
        this.rotation = rotation;
        return this;
    }

    @Override
    public BasicRegularPolygon rotate(float rotation) {
        this.rotation += rotation;
        return this;
    }

    @Override
    public BasicRegularPolygon sides(int sides) {
        this.sides = sides;
        return this;
    }

    @Override
    public void draw() {
        float c = this.drawer.setColor(this.color);
        if (this.filled) {
            this.drawer.filledPolygon(this.centre.x, this.centre.y, this.sides, this.scaleX, this.scaleY, this.rotation);
        } else {
            this.drawer.polygon(this.centre.x, this.centre.y, this.sides, this.scaleX, this.scaleY, this.rotation, this.lineWidth.getWidth(0, 0.0f), this.joinType);
        }
        this.drawer.setColor(c);
    }
}

