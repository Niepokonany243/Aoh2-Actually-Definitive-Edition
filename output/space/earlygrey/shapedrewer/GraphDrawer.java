/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.FloatArray;
import space.earlygrey.shapedrewer.JoinType;
import space.earlygrey.shapedrewer.ShapeDrawer;

public class GraphDrawer {
    private ShapeDrawer shapeDrawer;
    private JoinType joinType = JoinType.SMOOTH;
    private int samples = 50;
    private float plotBegin = 0.0f;
    private float plotEnd = 1.0f;
    private float domainBegin = 0.0f;
    private float domainEnd = 1.0f;
    private boolean rescale = true;
    private static final FloatArray path = new FloatArray();

    public GraphDrawer(ShapeDrawer shapeDrawer) {
        this.shapeDrawer = shapeDrawer;
    }

    public void draw(Interpolation interpolation, float x, float y, float width, float height, JoinType joinType, int samples, float plotBegin, float plotEnd, float domainBegin, float domainEnd, boolean rescale) {
        if (plotBegin >= plotEnd) {
            throw new IllegalArgumentException("plotBegin must be less than plotEnd");
        }
        if (domainBegin >= domainEnd) {
            throw new IllegalArgumentException("domainBegin must be less than domainEnd");
        }
        if (samples <= 2) {
            throw new IllegalArgumentException("samples must be greater than 2");
        }
        path.clear();
        float alpha = plotBegin;
        float high = 0.0f;
        float low = 0.0f;
        for (int i = 0; i < samples * 2; i += 2) {
            float pointX = x + (alpha - plotBegin) / (plotEnd - plotBegin) * width;
            float pointY = y + interpolation.apply(alpha) * height;
            if (alpha >= domainBegin) {
                path.add(pointX);
                path.add(pointY);
            }
            if (i == 0) {
                high = pointY;
                low = pointY;
            } else {
                if (pointY > high) {
                    high = pointY;
                }
                if (pointY < low) {
                    low = pointY;
                }
            }
            if (alpha >= plotEnd || alpha >= domainEnd) break;
            if ((alpha += (plotEnd - plotBegin) / (float)(samples - 1)) > plotEnd) {
                alpha = plotEnd;
            }
            if (!(alpha > domainEnd)) continue;
            alpha = domainEnd;
        }
        if (rescale) {
            if (low < y) {
                float dif = y - low;
                for (int i = 1; i < GraphDrawer.path.size; i += 2) {
                    path.set(i, path.get(i) + dif);
                }
                high += dif;
            }
            if (high > y + height) {
                float scale = height / (high - y);
                for (int i = 1; i < GraphDrawer.path.size; i += 2) {
                    path.set(i, (path.get(i) - y) * scale + y);
                }
            }
        }
        this.shapeDrawer.path(path, this.shapeDrawer.getDefaultLineWidth(), joinType, true);
    }

    public void draw(Interpolation interpolation, float x, float y, float width, float height) {
        this.draw(interpolation, x, y, width, height, this.joinType, this.samples, this.plotBegin, this.plotEnd, this.domainBegin, this.domainEnd, this.rescale);
    }

    public void draw(Interpolation interpolation, float x, float y, float width, float height, JoinType joinType) {
        this.draw(interpolation, x, y, width, height, joinType, this.samples, this.plotBegin, this.plotEnd, this.domainBegin, this.domainEnd, this.rescale);
    }

    public void draw(Interpolation interpolation, Rectangle rectangle) {
        this.draw(interpolation, rectangle.x, rectangle.y, rectangle.width, rectangle.height, this.joinType, this.samples, this.plotBegin, this.plotEnd, this.domainBegin, this.domainEnd, this.rescale);
    }

    public void draw(Interpolation interpolation, Rectangle rectangle, JoinType joinType) {
        this.draw(interpolation, rectangle.x, rectangle.y, rectangle.width, rectangle.height, joinType, this.samples, this.plotBegin, this.plotEnd, this.domainBegin, this.domainEnd, this.rescale);
    }

    public ShapeDrawer getShapeDrawer() {
        return this.shapeDrawer;
    }

    public void setShapeDrawer(ShapeDrawer shapeDrawer) {
        this.shapeDrawer = shapeDrawer;
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

