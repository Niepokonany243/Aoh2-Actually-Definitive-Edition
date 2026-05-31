/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer;

import com.badlogic.gdx.graphics.g2d.PolygonBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import space.earlygrey.shapedrewer.BatchManager;
import space.earlygrey.shapedrewer.Drawing;

class PolygonBatchManager
extends BatchManager {
    protected short[] triangles;
    protected int triangleCount = 0;

    PolygonBatchManager(PolygonBatch batch, TextureRegion region) {
        super(batch, region);
        int trianglesLength = (int)Math.ceil(this.verts.length / 5 * 3);
        this.triangles = new short[trianglesLength];
    }

    @Override
    public PolygonBatch getBatch() {
        return (PolygonBatch)super.getBatch();
    }

    @Override
    Drawing createDrawing() {
        return new Drawing.PolygonDrawing(this);
    }

    @Override
    void pushQuad() {
        this.pushTriangleIndices((short)this.vertexCount, (short)(this.vertexCount + 1), (short)(this.vertexCount + 2));
        this.pushTriangleIndices((short)this.vertexCount, (short)(this.vertexCount + 2), (short)(this.vertexCount + 3));
        super.pushQuad();
    }

    @Override
    void pushTriangle() {
        this.pushTriangleIndices((short)this.vertexCount, (short)(this.vertexCount + 1), (short)(this.vertexCount + 2));
        this.vertexCount += 3;
    }

    void pushTriangleIndices(short t1, short t2, short t3) {
        int t = this.getTrianglesArrayOffset();
        this.triangles[t] = t1;
        this.triangles[t + 1] = t2;
        this.triangles[t + 2] = t3;
        ++this.triangleCount;
    }

    protected void pushVertexData(float[] vertices, short[] triangles, int trianglesArrayCount, float color) {
        this.pushVertexData(vertices, triangles, trianglesArrayCount, color, 0.0f, 0.0f, 1.0f, 1.0f);
    }

    protected void pushVertexData(float[] vertices, short[] triangles, int trianglesArrayCount, float color, float offsetX, float offsetY, float scaleX, float scaleY) {
        int j;
        int v = this.getVerticesArrayIndex();
        int t = this.getTrianglesArrayOffset();
        int n = trianglesArrayCount;
        for (j = 0; j < n; ++j) {
            this.triangles[t + j] = (short)(this.vertexCount + triangles[j]);
        }
        this.triangleCount += trianglesArrayCount / 3;
        for (j = 0; j < vertices.length; j += 2) {
            float x = scaleX * vertices[j] + offsetX;
            float y = scaleY * vertices[j + 1] + offsetY;
            this.verts[v + 0] = x;
            this.verts[v + 1] = y;
            this.verts[v + 2] = color;
            v += 5;
        }
        this.vertexCount += vertices.length / 2;
    }

    @Override
    void ensureSpaceForTriangle() {
        this.ensureSpace(3);
    }

    @Override
    void pushToBatch() {
        if (this.vertexCount == 0) {
            return;
        }
        if (this.isRecording()) {
            this.drawing.pushVertices(this.verts, this.getVerticesArrayIndex());
        } else {
            this.getBatch().draw(this.r.getTexture(), this.verts, 0, this.getVerticesArrayIndex(), this.triangles, 0, this.getTrianglesArrayOffset());
        }
        this.vertexCount = 0;
        this.triangleCount = 0;
    }

    @Override
    void increaseCacheSize(int minSize) {
        super.increaseCacheSize(minSize);
        int trianglesLength = (int)Math.ceil(this.verts.length / 5 * 3);
        this.triangles = new short[trianglesLength];
    }

    int getTrianglesArrayOffset() {
        return 3 * this.triangleCount;
    }
}

