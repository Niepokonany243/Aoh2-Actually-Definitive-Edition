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

class BasicTriangle
extends BasicShape<BasicTriangle>
implements Shape.OutlinedTriangle {
    Vector2 a = new Vector2();
    Vector2 b = new Vector2();
    Vector2 c = new Vector2();

    BasicTriangle(ShapeDrawer drawer) {
        super(drawer);
    }

    @Override
    void reset(boolean filled) {
        super.reset(filled);
        this.a.set(0.0f, 0.0f);
        this.b.set(0.5f, 1.0f);
        this.c.set(1.0f, 0.0f);
    }

    @Override
    public BasicTriangle color(Color color) {
        this.color = color.toFloatBits();
        return this;
    }

    @Override
    public BasicTriangle joinType(JoinType joinType) {
        this.joinType = joinType;
        return this;
    }

    @Override
    public BasicTriangle lineWidth(float width) {
        this.setLineWidth(width);
        return this;
    }

    @Override
    public Shape.OutlinedTriangle a(float x, float y) {
        this.a.set(x, y);
        return this;
    }

    @Override
    public Shape.OutlinedTriangle b(float x, float y) {
        this.b.set(x, y);
        return this;
    }

    @Override
    public Shape.OutlinedTriangle c(float x, float y) {
        this.c.set(x, y);
        return this;
    }

    @Override
    public Shape.OutlinedTriangle a(Vector2 a) {
        this.a.set(a);
        return this;
    }

    @Override
    public Shape.OutlinedTriangle b(Vector2 b) {
        this.b.set(b);
        return this;
    }

    @Override
    public Shape.OutlinedTriangle c(Vector2 c) {
        this.c.set(c);
        return this;
    }

    @Override
    public void draw() {
        if (this.filled) {
            this.draw(() -> this.drawer.filledTriangle(this.a, this.b, this.c));
        } else {
            this.draw(() -> this.drawer.triangle(this.a, this.b, this.c, this.lineWidth.getWidth(0, 0.0f), this.joinType, this.color));
        }
    }
}

