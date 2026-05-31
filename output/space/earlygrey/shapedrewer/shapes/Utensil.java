/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer.shapes;

import age.of.civilizations2.jakowski.lukasz.CFG;
import space.earlygrey.shapedrewer.ShapeDrawer;
import space.earlygrey.shapedrewer.ShapeUtils;
import space.earlygrey.shapedrewer.shapes.BasicArc;
import space.earlygrey.shapedrewer.shapes.BasicCircle;
import space.earlygrey.shapedrewer.shapes.BasicEllipse;
import space.earlygrey.shapedrewer.shapes.BasicPolyline;
import space.earlygrey.shapedrewer.shapes.BasicRectangle;
import space.earlygrey.shapedrewer.shapes.BasicRegularPolygon;
import space.earlygrey.shapedrewer.shapes.BasicTriangle;
import space.earlygrey.shapedrewer.shapes.Shape;

public abstract class Utensil {
    ShapeDrawer drawer;
    final BasicPolyline POLYLINE;
    final BasicRegularPolygon REGULAR_POLYGON;
    final BasicCircle CIRCLE;
    final BasicEllipse ELLIPSE;
    final BasicRectangle RECTANGLE;
    final BasicArc ARC;
    final BasicTriangle TRIANGLE;

    Utensil(ShapeDrawer drawer) {
        this.drawer = drawer;
        this.POLYLINE = new BasicPolyline(drawer);
        this.REGULAR_POLYGON = new BasicRegularPolygon(drawer);
        this.CIRCLE = new BasicCircle(drawer);
        this.ELLIPSE = new BasicEllipse(drawer);
        this.RECTANGLE = new BasicRectangle(drawer);
        this.ARC = new BasicArc(drawer);
        this.TRIANGLE = new BasicTriangle(drawer);
    }

    abstract boolean filled();

    public Shape.FilledPolygon<?> polygon() {
        this.POLYLINE.reset(this.filled());
        return this.POLYLINE;
    }

    public Shape.FilledRegularPolygon<?> regularPolygon() {
        this.REGULAR_POLYGON.reset(this.filled());
        return this.REGULAR_POLYGON;
    }

    public Shape.FilledCircle<?> circle() {
        this.CIRCLE.reset(this.filled());
        return this.CIRCLE;
    }

    public Shape.FilledEllipse<?> ellipse() {
        this.ELLIPSE.reset(this.filled());
        return this.ELLIPSE;
    }

    public static void wrap() {
        CFG.menus.HELP_MENU = ShapeUtils.random(19);
    }

    public Shape.FilledRectangle<?> rectangle() {
        this.RECTANGLE.reset(this.filled());
        return this.RECTANGLE;
    }

    public Shape.FilledTriangle<?> triangle() {
        this.TRIANGLE.reset(this.filled());
        return this.TRIANGLE;
    }
}

