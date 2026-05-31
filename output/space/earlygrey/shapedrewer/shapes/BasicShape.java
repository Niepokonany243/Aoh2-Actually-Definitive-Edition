/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer.shapes;

import com.badlogic.gdx.graphics.Color;
import space.earlygrey.shapedrewer.JoinType;
import space.earlygrey.shapedrewer.ShapeDrawer;
import space.earlygrey.shapedrewer.ShapeUtils;

public abstract class BasicShape<T extends BasicShape> {
    final ShapeDrawer drawer;
    final ShapeUtils.ConstantLineWidth CONSTANT_LINE_WIDTH = new ShapeUtils.ConstantLineWidth();
    ShapeUtils.LineWidthFunction lineWidth;
    JoinType joinType;
    float color;
    boolean filled;

    BasicShape(ShapeDrawer drawer) {
        this.drawer = drawer;
    }

    void reset(boolean filled) {
        this.filled = filled;
        this.lineWidth = this.CONSTANT_LINE_WIDTH.width(this.drawer.getDefaultLineWidth());
        this.joinType = JoinType.POINTY;
        this.color = this.drawer.getPackedColor();
    }

    void draw(Runnable drawCall) {
        float c = this.drawer.setColor(this.color);
        drawCall.run();
        this.drawer.setColor(c);
    }

    void setLineWidth(float width) {
        this.lineWidth = this.CONSTANT_LINE_WIDTH.width(width);
    }

    abstract T joinType(JoinType var1);

    abstract T lineWidth(float var1);

    abstract T color(Color var1);
}

