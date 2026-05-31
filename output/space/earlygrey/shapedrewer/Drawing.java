/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer;

import com.badlogic.gdx.utils.Array;
import space.earlygrey.shapedrewer.BatchManager;
import space.earlygrey.shapedrewer.PolygonBatchManager;

public class Drawing {
    BatchManager batchManager;
    Array<float[]> vertexBatches;
    private float[] tmpVertices;
    private float offsetX;
    private float offsetY;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;

    Drawing(BatchManager batchManager) {
        this.batchManager = batchManager;
        this.vertexBatches = new Array();
    }

    public void draw() {
        this.draw(this.offsetX, this.offsetY);
    }

    public void draw(float x, float y) {
        this.draw(x, y, this.scaleX, this.scaleY);
    }

    public void draw(float x, float y, float scaleX, float scaleY) {
        if (this.batchManager.r == null) {
            throw new IllegalStateException("The texture region is null. Please set a texture region first (e.g. in the constructor or by calling setTextureRegion(TextureRegion region))");
        }
        for (int i = 0; i < this.vertexBatches.size; ++i) {
            float[] vertices = this.vertexBatches.get(i);
            this.getBatchManager().getBatch().draw(this.batchManager.r.getTexture(), this.applyTransformation(vertices, x, y, scaleX, scaleY), 0, vertices.length);
        }
    }

    void pushVertices(float[] vertices, int count) {
        float[] copy = new float[count];
        System.arraycopy(vertices, 0, copy, 0, count);
        this.vertexBatches.add(copy);
    }

    void finalise() {
        this.vertexBatches.setSize(this.vertexBatches.size);
        int max = 0;
        for (int i = 0; i < this.vertexBatches.size; ++i) {
            float[] vertices = this.vertexBatches.get(i);
            if (vertices.length <= max) continue;
            max = vertices.length;
        }
        this.tmpVertices = new float[max];
    }

    float[] applyTransformation(float[] vertices, float x, float y, float scaleX, float scaleY) {
        if (!this.needsTransforming(x, y, scaleX, scaleY)) {
            return vertices;
        }
        for (int i = 0; i < vertices.length; i += 5) {
            this.tmpVertices[i] = x + scaleX * vertices[i];
            this.tmpVertices[i + 1] = y + scaleY * vertices[i + 1];
            this.tmpVertices[i + 2] = vertices[i + 2];
            this.tmpVertices[i + 3] = vertices[i + 3];
            this.tmpVertices[i + 4] = vertices[i + 4];
        }
        return this.tmpVertices;
    }

    boolean needsTransforming(float x, float y, float scaleX, float scaleY) {
        return x != 0.0f || y != 0.0f || scaleX != 1.0f || scaleY != 1.0f;
    }

    BatchManager getBatchManager() {
        return this.batchManager;
    }

    public float getOffsetX() {
        return this.offsetX;
    }

    public void setOffset(float offsetX, float offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public float getOffsetY() {
        return this.offsetY;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public void setScaleX(float scaleX, float scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    static class PolygonDrawing
    extends Drawing {
        Array<short[]> triangleBatches = new Array();

        PolygonDrawing(PolygonBatchManager batchManager) {
            super(batchManager);
        }

        @Override
        public void draw(float x, float y, float scaleX, float scaleY) {
            if (this.batchManager.r == null) {
                throw new IllegalStateException("The texture region is null. Please set a texture region first (e.g. in the constructor or by calling setTextureRegion(TextureRegion region))");
            }
            for (int i = 0; i < this.vertexBatches.size; ++i) {
                float[] vertices = (float[])this.vertexBatches.get(i);
                short[] triangles = this.triangleBatches.get(i);
                this.getBatchManager().getBatch().draw(this.batchManager.r.getTexture(), this.applyTransformation(vertices, x, y, scaleX, scaleY), 0, vertices.length, triangles, 0, triangles.length);
            }
        }

        @Override
        PolygonBatchManager getBatchManager() {
            return (PolygonBatchManager)super.getBatchManager();
        }

        @Override
        void pushVertices(float[] vertices, int count) {
            super.pushVertices(vertices, count);
            short[] triangles = new short[this.getBatchManager().getTrianglesArrayOffset()];
            System.arraycopy(this.getBatchManager().triangles, 0, triangles, 0, triangles.length);
            this.triangleBatches.add(triangles);
        }

        @Override
        void finalise() {
            super.finalise();
            this.triangleBatches.setSize(this.triangleBatches.size);
        }
    }
}

