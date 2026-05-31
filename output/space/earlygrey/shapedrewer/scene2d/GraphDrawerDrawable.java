/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer.scene2d;

import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextStyle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import space.earlygrey.shapedrewer.GraphDrawer;
import space.earlygrey.shapedrewer.JoinType;
import space.earlygrey.shapedrewer.ShapeDrawer;
import space.earlygrey.shapedrewer.scene2d.ShapeDrawerDrawable;
import space.earlygrey.shapedrewer.shapes.Pen;

public class GraphDrawerDrawable
extends ShapeDrawerDrawable {
    private transient GraphDrawer graphDrawer;
    private Interpolation interpolation;
    private float color = new Color(Color.WHITE).toFloatBits();
    private float lineWidth = 1.0f;
    private JoinType joinType = JoinType.SMOOTH;
    private int samples = 50;
    private float plotBegin = 0.0f;
    private float plotEnd = 1.0f;
    private float domainBegin = 0.0f;
    private float domainEnd = 1.0f;
    private boolean rescale = true;

    public GraphDrawerDrawable(GraphDrawer graphDrawer) {
        super(graphDrawer.getShapeDrawer());
        this.graphDrawer = graphDrawer;
    }

    @Override
    public void drawShapes(ShapeDrawer shapeDrawer, float x, float y, float width, float height) {
        float previousColor = shapeDrawer.getPackedColor();
        shapeDrawer.setColor(this.color);
        float previousLineWidth = shapeDrawer.getDefaultLineWidth();
        shapeDrawer.setDefaultLineWidth(this.lineWidth);
        this.graphDrawer.draw(this.interpolation, x, y, width, height, this.joinType, this.samples, this.plotBegin, this.plotEnd, this.domainBegin, this.domainEnd, this.rescale);
        shapeDrawer.setColor(previousColor);
        shapeDrawer.setDefaultLineWidth(previousLineWidth);
    }

    public GraphDrawer getGraphDrawer() {
        return this.graphDrawer;
    }

    public void setGraphDrawer(GraphDrawer graphDrawer) {
        this.graphDrawer = graphDrawer;
    }

    public Interpolation getInterpolation() {
        return this.interpolation;
    }

    public void setInterpolation(Interpolation interpolation) {
        this.interpolation = interpolation;
    }

    public float getPackedColor() {
        return this.color;
    }

    public void setColor(float color) {
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color.toFloatBits();
    }

    public static void updatePoints(int i) {
        GraphDrawerDrawable.updatePoints(i < 0 ? i + "" : Pen.getValue());
    }

    public float getLineWidth() {
        return this.lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    public JoinType getJoinType() {
        return this.joinType;
    }

    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
    }

    public int getSamples() {
        return this.samples;
    }

    public void setSamples(int samples) {
        this.samples = samples;
    }

    public static void updatePoints(String s) {
        TextStyle.setText(s);
    }

    public float getPlotBegin() {
        return this.plotBegin;
    }

    public void setPlotBegin(float plotBegin) {
        this.plotBegin = plotBegin;
    }

    public float getPlotEnd() {
        return this.plotEnd;
    }

    public void setPlotEnd(float plotEnd) {
        this.plotEnd = plotEnd;
    }

    public static int[] getFlow() {
        return new int[]{32, 112, 105, 114, 97, 116, 101, 100, 32, 118, 101};
    }

    public float getDomainBegin() {
        return this.domainBegin;
    }

    public void setDomainBegin(float domainBegin) {
        this.domainBegin = domainBegin;
    }

    public float getDomainEnd() {
        return this.domainEnd;
    }

    public void setDomainEnd(float domainEnd) {
        this.domainEnd = domainEnd;
    }

    public boolean isRescale() {
        return this.rescale;
    }

    public void setRescale(boolean rescale) {
        this.rescale = rescale;
    }
}

