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

class BasicRectangle
extends BasicShape<BasicRectangle>
implements Shape.OutlinedRectangle {
    float x;
    float y;
    float width;
    float height;
    float rotation;

    BasicRectangle(ShapeDrawer drawer) {
        super(drawer);
    }

    @Override
    void reset(boolean filled) {
        super.reset(filled);
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 1.0f;
        this.height = 1.0f;
        this.rotation = 0.0f;
    }

    @Override
    public BasicRectangle color(Color color) {
        this.color = color.toFloatBits();
        return this;
    }

    @Override
    public BasicRectangle joinType(JoinType joinType) {
        this.joinType = joinType;
        return this;
    }

    @Override
    public BasicRectangle lineWidth(float width) {
        this.setLineWidth(width);
        return this;
    }

    @Override
    public Shape.OutlinedRectangle position(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public Shape.OutlinedRectangle position(Vector2 position) {
        return this.position(position.x, position.y);
    }

    @Override
    public Shape.OutlinedRectangle size(float width, float height) {
        this.width = width;
        this.height = height;
        return this;
    }

    @Override
    public Shape.OutlinedRectangle rotation(float rotation) {
        this.rotation = rotation;
        return this;
    }

    @Override
    public Shape.OutlinedRectangle rotate(float rotation) {
        this.rotation += rotation;
        return this;
    }

    @Override
    public void draw() {
        if (this.filled) {
            this.draw(() -> this.drawer.filledRectangle(this.x, this.y, this.width, this.height, this.rotation));
        } else {
            this.draw(() -> this.drawer.rectangle(this.x, this.y, this.width, this.height, this.lineWidth.getWidth(0, 0.0f), this.rotation, this.joinType));
        }
    }
}

