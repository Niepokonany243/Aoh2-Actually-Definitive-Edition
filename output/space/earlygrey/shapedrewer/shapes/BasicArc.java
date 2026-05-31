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

public class BasicArc
extends BasicShape<BasicArc>
implements Shape.Arc {
    Vector2 centre = new Vector2();
    float radius;
    float startAngle;
    float radians;
    int sides;

    protected BasicArc(ShapeDrawer drawer) {
        super(drawer);
    }

    @Override
    void reset(boolean filled) {
        super.reset(filled);
        this.centre.setZero();
        this.radians = (float)Math.PI;
        this.startAngle = 0.0f;
        this.radius = 1.0f;
        this.sides = 6;
    }

    @Override
    public BasicArc color(Color color) {
        this.color = color.toFloatBits();
        return this;
    }

    @Override
    public BasicArc joinType(JoinType joinType) {
        this.joinType = joinType;
        return this;
    }

    @Override
    public BasicArc lineWidth(float width) {
        this.setLineWidth(width);
        return this;
    }

    @Override
    public BasicArc centre(float x, float y) {
        this.centre.set(x, y);
        return this;
    }

    @Override
    public BasicArc centre(Vector2 centre) {
        this.centre.set(centre);
        return this;
    }

    @Override
    public BasicArc radius(float radius) {
        this.radius = radius;
        return this;
    }

    @Override
    public BasicArc startAngle(float startAngle) {
        this.startAngle = startAngle;
        return this;
    }

    @Override
    public BasicArc radians(float radians) {
        this.radians = radians;
        return this;
    }

    @Override
    public BasicArc sides(int sides) {
        this.sides = sides;
        return this;
    }

    @Override
    public void draw() {
        if (this.filled) {
            this.draw(() -> this.drawer.sector(this.centre.x, this.centre.y, this.radius, this.startAngle, this.radians, this.sides));
        } else {
            this.draw(() -> this.drawer.arc(this.centre.x, this.centre.y, this.radius, this.startAngle, this.radians, this.lineWidth.getWidth(0, 0.0f), this.joinType, this.sides));
        }
    }
}

