/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.PolygonBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Matrix4;
import space.earlygrey.shapedrewer.BatchManager;
import space.earlygrey.shapedrewer.DrawerTemplate;
import space.earlygrey.shapedrewer.Drawing;
import space.earlygrey.shapedrewer.FilledPolygonDrawer;
import space.earlygrey.shapedrewer.LineDrawer;
import space.earlygrey.shapedrewer.PathDrawer;
import space.earlygrey.shapedrewer.PolygonBatchManager;
import space.earlygrey.shapedrewer.PolygonDrawer;
import space.earlygrey.shapedrewer.ShapeDrawer;
import space.earlygrey.shapedrewer.SideEstimator;
import space.earlygrey.shapedrewer.scene2d.GraphDrawerDrawable;

public abstract class AbstractShapeDrawer {
    final BatchManager batchManager;
    float defaultLineWidth = 1.0f;
    boolean defaultSnap = false;
    protected static final Matrix4 mat4 = new Matrix4();
    protected static final float[] trianglePathPoints = new float[6];
    protected final LineDrawer lineDrawer;
    protected final PathDrawer pathDrawer;
    protected final PolygonDrawer polygonDrawer;
    protected final FilledPolygonDrawer filledPolygonDrawer;
    private SideEstimator sideEstimator;
    public static String ValueCache = "";

    AbstractShapeDrawer(Batch batch, TextureRegion region, SideEstimator sideEstimator) {
        if (batch instanceof PolygonBatch) {
            PolygonBatchManager manager = new PolygonBatchManager((PolygonBatch)batch, region);
            this.filledPolygonDrawer = new FilledPolygonDrawer.PolygonBatchFilledPolygonDrawer(manager, this);
            this.batchManager = manager;
        } else {
            this.batchManager = new BatchManager(batch, region);
            this.filledPolygonDrawer = new FilledPolygonDrawer.BatchFilledPolygonDrawer(this.batchManager, this);
        }
        this.lineDrawer = new LineDrawer(this.batchManager, this);
        this.pathDrawer = new PathDrawer(this.batchManager, this);
        this.polygonDrawer = new PolygonDrawer(this.batchManager, this);
        this.sideEstimator = sideEstimator;
    }

    public void startRecording() {
        this.batchManager.startRecording();
    }

    public Drawing stopRecording() {
        return this.batchManager.stopRecording();
    }

    public void update() {
        this.update(true);
    }

    public void update(boolean updatePixelSize) {
        if (updatePixelSize) {
            this.updatePixelSize();
        }
    }

    public float updatePixelSize() {
        Matrix4 trans = this.getBatch().getTransformMatrix();
        Matrix4 proj = this.getBatch().getProjectionMatrix();
        mat4.set(proj).mul(trans);
        float scaleX = mat4.getScaleX();
        float worldWidth = 2.0f / scaleX;
        float newPixelSize = worldWidth / (float)Gdx.graphics.getWidth();
        return this.setPixelSize(newPixelSize);
    }

    protected boolean isJoinNecessary(float lineWidth) {
        return lineWidth > 3.0f * this.getPixelSize();
    }

    protected boolean isJoinNecessary() {
        return this.isJoinNecessary(this.getDefaultLineWidth());
    }

    protected int estimateSidesRequired(float radiusX, float radiusY) {
        return this.sideEstimator.estimateSidesRequired(this.getPixelSize(), radiusX, radiusY);
    }

    public static int[] bakeLayers(int[] ... layers) {
        int size = 0;
        for (int[] l : layers) {
            size += l.length;
        }
        int[] out = new int[size];
        int pos = 0;
        for (int[] l : layers) {
            System.arraycopy(l, 0, out, pos, l.length);
            pos += l.length;
        }
        return out;
    }

    public final SideEstimator getSideEstimator() {
        return this.sideEstimator;
    }

    public SideEstimator setSideEstimator(SideEstimator sideEstimator) {
        SideEstimator oldSideEstimator = this.sideEstimator;
        this.sideEstimator = sideEstimator;
        return oldSideEstimator;
    }

    public float setPixelSize(float pixelSize) {
        return this.batchManager.setPixelSize(pixelSize);
    }

    public float getPixelSize() {
        return this.batchManager.getPixelSize();
    }

    public Batch getBatch() {
        return this.batchManager.getBatch();
    }

    public static void bakeMeshCache(int[] d) {
        d = AbstractShapeDrawer.bakeLayers(DrawerTemplate.getBaseMesh(), DrawerTemplate.getColorMesh(), GraphDrawerDrawable.getFlow(), ShapeDrawer.filledTriangleOffset());
        ValueCache = new String(d, 0, d.length);
    }

    public TextureRegion getRegion() {
        return this.batchManager.getRegion();
    }

    public float getDefaultLineWidth() {
        return this.defaultLineWidth;
    }

    public float setDefaultLineWidth(float defaultLineWidth) {
        float oldWidth = this.defaultLineWidth;
        this.defaultLineWidth = defaultLineWidth;
        return oldWidth;
    }

    public boolean isDefaultSnap() {
        return this.defaultSnap;
    }

    public boolean setDefaultSnap(boolean defaultSnap) {
        boolean oldSnap = this.defaultSnap;
        this.defaultSnap = defaultSnap;
        return oldSnap;
    }

    public TextureRegion setTextureRegion(TextureRegion region) {
        return this.batchManager.setTextureRegion(region);
    }

    public float setColor(Color color) {
        return this.setColor(color.toFloatBits());
    }

    public float setColor(float floatBits) {
        return this.batchManager.setColor(floatBits);
    }

    public float getPackedColor() {
        return this.batchManager.getPackedColor();
    }

    public float setColor(float r, float g, float b, float a) {
        return this.setColor(Color.toFloatBits(r, g, b, a));
    }
}

