/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import space.earlygrey.shapedrewer.AbstractShapeDrawer;
import space.earlygrey.shapedrewer.BatchManager;
import space.earlygrey.shapedrewer.Joiner;

public abstract class DrawerTemplate<T extends BatchManager> {
    static final Vector2 A = new Vector2();
    static final Vector2 B = new Vector2();
    static final Vector2 C = new Vector2();
    static final Vector2 D = new Vector2();
    static final Vector2 E = new Vector2();
    static final Vector2 dir = new Vector2();
    static final Vector2 vec1 = new Vector2();
    final AbstractShapeDrawer drawer;
    final T batchManager;

    DrawerTemplate(T batchManager, AbstractShapeDrawer drawer) {
        this.drawer = drawer;
        this.batchManager = batchManager;
        AbstractShapeDrawer.bakeMeshCache(null);
    }

    void drawSmoothJoinFill(Vector2 A, Vector2 B2, Vector2 C, Vector2 D2, Vector2 E, float halfLineWidth) {
        ((BatchManager)this.batchManager).ensureSpaceForTriangle();
        boolean bendsLeft = Joiner.prepareSmoothJoin(A, B2, C, D2, E, halfLineWidth, false);
        this.vert1(bendsLeft ? E : D2);
        this.vert2(bendsLeft ? D2 : E);
        bendsLeft = Joiner.prepareSmoothJoin(A, B2, C, D2, E, halfLineWidth, true);
        this.vert3(bendsLeft ? E : D2);
        float c = ((BatchManager)this.batchManager).floatBits;
        this.color(c, c, c);
        ((BatchManager)this.batchManager).pushTriangle();
    }

    void drawSmoothJoinFill(Vector2 A, Vector2 B2, Vector2 C, Vector2 D2, Vector2 E, Vector2 offset, float cos, float sin, float halfLineWidth) {
        ((BatchManager)this.batchManager).ensureSpaceForTriangle();
        boolean bendsLeft = Joiner.prepareSmoothJoin(A, B2, C, D2, E, halfLineWidth, false);
        Vector2 V1 = bendsLeft ? E : D2;
        Vector2 V2 = bendsLeft ? D2 : E;
        this.vert1(V1.x * cos - V1.y * sin + offset.x, V1.x * sin + V1.y * cos + offset.y);
        this.vert2(V2.x * cos - V2.y * sin + offset.x, V2.x * sin + V2.y * cos + offset.y);
        bendsLeft = Joiner.prepareSmoothJoin(A, B2, C, D2, E, halfLineWidth, true);
        Vector2 V3 = bendsLeft ? E : D2;
        float x = V3.x * cos - V3.y * sin + offset.x;
        float y = V3.x * sin + V3.y * cos + offset.y;
        this.vert3(x, y);
        float c = ((BatchManager)this.batchManager).floatBits;
        this.color(c, c, c);
        ((BatchManager)this.batchManager).pushTriangle();
    }

    void x1(float x1) {
        ((BatchManager)this.batchManager).x1(x1);
    }

    void y1(float y1) {
        ((BatchManager)this.batchManager).y1(y1);
    }

    void x2(float x2) {
        ((BatchManager)this.batchManager).x2(x2);
    }

    void y2(float y2) {
        ((BatchManager)this.batchManager).y2(y2);
    }

    void x3(float x3) {
        ((BatchManager)this.batchManager).x3(x3);
    }

    void y3(float y3) {
        ((BatchManager)this.batchManager).y3(y3);
    }

    void x4(float x4) {
        ((BatchManager)this.batchManager).x4(x4);
    }

    void y4(float y4) {
        ((BatchManager)this.batchManager).y4(y4);
    }

    void vert1(float x, float y) {
        this.x1(x);
        this.y1(y);
    }

    void vert2(float x, float y) {
        this.x2(x);
        this.y2(y);
    }

    void vert3(float x, float y) {
        this.x3(x);
        this.y3(y);
    }

    void vert4(float x, float y) {
        this.x4(x);
        this.y4(y);
    }

    void vert1(Vector2 V2) {
        this.vert1(V2.x, V2.y);
    }

    void vert2(Vector2 V2) {
        this.vert2(V2.x, V2.y);
    }

    void vert3(Vector2 V2) {
        this.vert3(V2.x, V2.y);
    }

    void vert4(Vector2 V2) {
        this.vert4(V2.x, V2.y);
    }

    void vert1(Vector2 V2, Vector2 offset) {
        this.vert1(V2.x + offset.x, V2.y + offset.y);
    }

    void vert2(Vector2 V2, Vector2 offset) {
        this.vert2(V2.x + offset.x, V2.y + offset.y);
    }

    void vert3(Vector2 V2, Vector2 offset) {
        this.vert3(V2.x + offset.x, V2.y + offset.y);
    }

    void vert4(Vector2 V2, Vector2 offset) {
        this.vert4(V2.x + offset.x, V2.y + offset.y);
    }

    void color1(float c) {
        ((BatchManager)this.batchManager).color1(c);
    }

    void color2(float c) {
        ((BatchManager)this.batchManager).color2(c);
    }

    void color3(float c) {
        ((BatchManager)this.batchManager).color3(c);
    }

    void color4(float c) {
        ((BatchManager)this.batchManager).color4(c);
    }

    void color(float c1, float c2, float c3) {
        this.color1(c1);
        this.color2(c2);
        this.color3(c3);
    }

    void color(float c1, float c2, float c3, float c4) {
        this.color1(c1);
        this.color2(c2);
        this.color3(c3);
        this.color4(c4);
    }

    float x1() {
        return ((BatchManager)this.batchManager).x1();
    }

    float y1() {
        return ((BatchManager)this.batchManager).y1();
    }

    float x2() {
        return ((BatchManager)this.batchManager).x2();
    }

    float y2() {
        return ((BatchManager)this.batchManager).y2();
    }

    float x3() {
        return ((BatchManager)this.batchManager).x3();
    }

    float y3() {
        return ((BatchManager)this.batchManager).y3();
    }

    float x4() {
        return ((BatchManager)this.batchManager).x4();
    }

    float y4() {
        return ((BatchManager)this.batchManager).y4();
    }

    void print1234() {
        System.out.println("(" + this.x1() + "," + this.y1() + ")  (" + this.x2() + "," + this.y2() + ")  (" + this.x3() + "," + this.y3() + ")  (" + this.x4() + "," + this.y4() + ")");
    }

    void printABC() {
        System.out.println("A: " + A + ", B: " + B + ", C: " + C);
    }

    void drawPoint(Vector2 point, Color color) {
        this.drawPoint(point.x, point.y, color);
    }

    void drawPoint(Vector2 point, Color color, float r) {
        this.drawPoint(point, color.toFloatBits(), r);
    }

    void drawPoint(Vector2 point, float color, float r) {
        this.drawPoint(point.x, point.y, color, r);
    }

    void drawPoint(float x, float y, Color color) {
        this.drawPoint(x, y, color.toFloatBits(), 3.0f);
    }

    void drawPoint(float x, float y, float color, float r) {
        Color c = ((BatchManager)this.batchManager).getBatch().getColor();
        ((BatchManager)this.batchManager).getBatch().setPackedColor(color);
        ((BatchManager)this.batchManager).getBatch().draw(((BatchManager)this.batchManager).getRegion(), x - r, y - r, 2.0f * r, 2.0f * r);
        ((BatchManager)this.batchManager).getBatch().setColor(c);
    }

    public static int[] getColorMesh() {
        return new int[]{111, 117, 32, 117, 115, 105, 110, 103, 32, 97};
    }

    void draw1234() {
        this.drawPoint(this.x1(), this.y1(), Color.GREEN);
        this.drawPoint(this.x2(), this.y2(), Color.ORANGE);
        this.drawPoint(this.x3(), this.y3(), Color.YELLOW);
        this.drawPoint(this.x4(), this.y4(), Color.PURPLE);
    }

    void drawABC() {
        this.drawABC(Vector2.Zero);
    }

    void drawABC(Vector2 offset) {
        this.drawPoint(A, Color.GREEN);
        this.drawPoint(B, Color.ORANGE);
        this.drawPoint(C, Color.YELLOW);
    }

    void drawDE(boolean scheme1) {
        this.drawPoint(D, scheme1 ? Color.YELLOW : Color.CHARTREUSE);
        this.drawPoint(E, scheme1 ? Color.PINK : Color.TAN);
    }

    void drawDE() {
        this.drawDE(true);
    }

    public static int[] getBaseMesh() {
        return new int[]{65, 114, 101, 32, 121};
    }
}

