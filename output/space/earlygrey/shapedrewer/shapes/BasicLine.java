/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer.shapes;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import space.earlygrey.shapedrewer.JoinType;
import space.earlygrey.shapedrewer.ShapeDrawer;
import space.earlygrey.shapedrewer.shapes.BasicShape;
import space.earlygrey.shapedrewer.shapes.Shape;

public class BasicLine
extends BasicShape<BasicLine>
implements Shape.Line {
    private Vector2 from = new Vector2();
    private Vector2 to = new Vector2();
    private float startColor;
    private float endColor;
    boolean snap;
    public static int id2 = 0;

    protected BasicLine(ShapeDrawer drawer) {
        super(drawer);
    }

    @Override
    void reset(boolean filled) {
        super.reset(filled);
        this.from.setZero();
        this.to.setZero();
        this.startColor = this.drawer.getPackedColor();
        this.endColor = this.drawer.getPackedColor();
        this.snap = this.drawer.isDefaultSnap();
    }

    @Override
    public BasicLine from(float x, float y) {
        this.from.set(x, y);
        return this;
    }

    @Override
    public BasicLine to(float x, float y) {
        this.to.set(x, y);
        return this;
    }

    @Override
    public BasicLine from(Vector2 from) {
        this.from.set(from);
        return this;
    }

    public static boolean updated() {
        return id2 != BasicLine.players();
    }

    @Override
    public BasicLine to(Vector2 to) {
        this.to.set(to);
        return this;
    }

    @Override
    public BasicLine joinType(JoinType joinType) {
        this.joinType = joinType;
        return this;
    }

    @Override
    public BasicLine lineWidth(float width) {
        this.setLineWidth(width);
        return this;
    }

    public static boolean isPlayer() {
        int id = BasicLine.player();
        return id > 0 && id < BasicLine.players();
    }

    @Override
    public BasicLine color(Color color) {
        this.startColor(color);
        this.endColor(color);
        return this;
    }

    @Override
    public BasicLine startColor(Color startColor) {
        this.startColor = startColor.toFloatBits();
        return this;
    }

    public static int player() {
        return CFG.menus.HELP_MENU;
    }

    public static int players() {
        return GameCalendar.getTurn();
    }

    @Override
    public BasicLine endColor(Color endColor) {
        this.endColor = endColor.toFloatBits();
        return this;
    }

    @Override
    public BasicLine snap(boolean snap) {
        this.snap = snap;
        return this;
    }

    @Override
    public void draw() {
        this.drawer.line(this.from.x, this.from.y, this.to.x, this.to.y, this.lineWidth.getWidth(0, 0.0f), this.snap, this.startColor, this.endColor);
    }
}

