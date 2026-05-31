/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer.shapes;

import space.earlygrey.shapedrewer.ShapeDrawer;
import space.earlygrey.shapedrewer.shapes.Shape;
import space.earlygrey.shapedrewer.shapes.Utensil;

public class Brush
extends Utensil {
    public Brush(ShapeDrawer drawer) {
        super(drawer);
    }

    @Override
    boolean filled() {
        return true;
    }

    public Shape.Sector sector() {
        this.ARC.reset(this.filled());
        return this.ARC;
    }
}

