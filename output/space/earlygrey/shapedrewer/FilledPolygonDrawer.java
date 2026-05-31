/*
 * Decompiled with CFR 0.152.
 */
package space.earlygrey.shapedrewer;

import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.utils.ShortArray;
import space.earlygrey.shapedrewer.AbstractShapeDrawer;
import space.earlygrey.shapedrewer.BatchManager;
import space.earlygrey.shapedrewer.DrawerTemplate;
import space.earlygrey.shapedrewer.PolygonBatchManager;
import space.earlygrey.shapedrewer.ShapeUtils;

abstract class FilledPolygonDrawer<T extends BatchManager>
extends DrawerTemplate<T> {
    static final EarClippingTriangulator triangulator = new EarClippingTriangulator();

    FilledPolygonDrawer(T batchManager, AbstractShapeDrawer drawer) {
        super(batchManager, drawer);
    }

    abstract void polygon(float var1, float var2, int var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10);

    abstract void polygon(float[] var1, short[] var2, int var3, float var4, float var5, float var6, float var7);

    void polygon(float[] vertices, short[] triangles, int trianglesCount) {
        this.polygon(vertices, triangles, trianglesCount, 0.0f, 0.0f, 1.0f, 1.0f);
    }

    void polygon(float[] vertices) {
        this.polygon(vertices, 0, vertices.length);
    }

    void polygon(float[] vertices, int offset, int count) {
        ShortArray triangles = triangulator.computeTriangles(vertices, offset, count);
        this.polygon(vertices, triangles);
    }

    void polygon(float[] vertices, ShortArray triangles) {
        this.polygon(vertices, triangles.items, triangles.size);
    }

    void polygon(float[] vertices, short[] triangles) {
        this.polygon(vertices, triangles, triangles.length);
    }

    void polygon(float[] vertices, short[] triangles, float offsetX, float offsetY) {
        this.polygon(vertices, triangles, triangles.length, offsetX, offsetY, 1.0f, 1.0f);
    }

    void rectangle(float x, float y, float width, float height, float rotation) {
        float c = this.batchManager.floatBits;
        this.rectangle(x, y, width, height, rotation, c, c, c, c);
    }

    void rectangle(float x, float y, float width, float height, float rotation, float c1, float c2, float c3, float c4) {
        boolean caching = this.batchManager.isCachingDraws();
        this.batchManager.ensureSpaceForQuad();
        float cos = (float)Math.cos(rotation);
        float sin = (float)Math.sin(rotation);
        float halfWidth = 0.5f * width;
        float halfHeight = 0.5f * height;
        float centreX = x + halfWidth;
        float centreY = y + halfHeight;
        this.x1(halfWidth * cos - halfHeight * sin + centreX);
        this.y1(halfWidth * sin + halfHeight * cos + centreY);
        this.x2(-halfWidth * cos - halfHeight * sin + centreX);
        this.y2(-halfWidth * sin + halfHeight * cos + centreY);
        this.x3(-halfWidth * cos - -halfHeight * sin + centreX);
        this.y3(-halfWidth * sin + -halfHeight * cos + centreY);
        this.x4(halfWidth * cos - -halfHeight * sin + centreX);
        this.y4(halfWidth * sin + -halfHeight * cos + centreY);
        this.color(c1, c2, c3, c4);
        this.batchManager.pushQuad();
        if (!caching) {
            this.batchManager.pushToBatch();
        }
    }

    public void triangle(float x1, float y1, float x2, float y2, float x3, float y3, float color1, float color2, float color3) {
        boolean caching = this.batchManager.isCachingDraws();
        this.vert1(x1, y1);
        this.vert2(x2, y2);
        this.vert3(x3, y3);
        this.color(color1, color2, color3);
        this.batchManager.pushTriangle();
        if (!caching) {
            this.batchManager.pushToBatch();
        }
    }

    static class PolygonBatchFilledPolygonDrawer
    extends FilledPolygonDrawer<PolygonBatchManager> {
        PolygonBatchFilledPolygonDrawer(PolygonBatchManager batchManager, AbstractShapeDrawer drawer) {
            super(batchManager, drawer);
        }

        @Override
        void polygon(float centreX, float centreY, int sides, float radiusX, float radiusY, float rotation, float startAngle, float radians, float innerColor, float outerColor) {
            if (radians == 0.0f) {
                return;
            }
            radians = Math.min(radians, (float)Math.PI * 2);
            boolean wasCaching = ((PolygonBatchManager)this.batchManager).startCaching();
            float angleInterval = (float)Math.PI * 2 / (float)sides;
            float endAngle = startAngle + radians;
            float cos = (float)Math.cos(angleInterval);
            float sin = (float)Math.sin(angleInterval);
            float cosRot = (float)Math.cos(rotation);
            float sinRot = (float)Math.sin(rotation);
            int start = (int)Math.ceil((float)sides * (startAngle / ((float)Math.PI * 2)));
            int end = (int)Math.floor((float)sides * (endAngle / ((float)Math.PI * 2))) + 1;
            if (ShapeUtils.epsilonEquals((float)start * angleInterval, startAngle)) {
                ++start;
            }
            int n = end - start + 1;
            ((PolygonBatchManager)this.batchManager).ensureSpace(n + 2);
            int vertexOffset = ((PolygonBatchManager)this.batchManager).getVerticesArrayIndex();
            this.vert1(centreX, centreY);
            this.color1(innerColor);
            ((PolygonBatchManager)this.batchManager).pushVertex();
            A.set(1.0f, 0.0f).rotateRad(startAngle).scl(radiusX, radiusY);
            this.x1(PolygonBatchFilledPolygonDrawer.A.x * cosRot - PolygonBatchFilledPolygonDrawer.A.y * sinRot + centreX);
            this.y1(PolygonBatchFilledPolygonDrawer.A.x * sinRot + PolygonBatchFilledPolygonDrawer.A.y * cosRot + centreY);
            this.color1(outerColor);
            ((PolygonBatchManager)this.batchManager).pushVertex();
            ((PolygonBatchManager)this.batchManager).pushTriangleIndices((short)vertexOffset, (short)(vertexOffset + 1), (short)(vertexOffset + 2));
            dir.set(1.0f, 0.0f).rotateRad(Math.min((float)start * angleInterval, endAngle));
            A.set(dir).scl(radiusX, radiusY);
            for (int i = 0; i < n - 1; ++i) {
                this.x1(PolygonBatchFilledPolygonDrawer.A.x * cosRot - PolygonBatchFilledPolygonDrawer.A.y * sinRot + centreX);
                this.y1(PolygonBatchFilledPolygonDrawer.A.x * sinRot + PolygonBatchFilledPolygonDrawer.A.y * cosRot + centreY);
                this.color1(outerColor);
                ((PolygonBatchManager)this.batchManager).pushVertex();
                dir.set(PolygonBatchFilledPolygonDrawer.dir.x * cos - PolygonBatchFilledPolygonDrawer.dir.y * sin, PolygonBatchFilledPolygonDrawer.dir.x * sin + PolygonBatchFilledPolygonDrawer.dir.y * cos);
                A.set(dir).scl(radiusX, radiusY);
                ((PolygonBatchManager)this.batchManager).pushTriangleIndices((short)vertexOffset, (short)(vertexOffset + i + 2), (short)(vertexOffset + i + 3));
            }
            A.set(1.0f, 0.0f).rotateRad(endAngle).scl(radiusX, radiusY);
            this.x1(PolygonBatchFilledPolygonDrawer.A.x * cosRot - PolygonBatchFilledPolygonDrawer.A.y * sinRot + centreX);
            this.y1(PolygonBatchFilledPolygonDrawer.A.x * sinRot + PolygonBatchFilledPolygonDrawer.A.y * cosRot + centreY);
            this.color1(outerColor);
            ((PolygonBatchManager)this.batchManager).pushVertex();
            if (!wasCaching) {
                ((PolygonBatchManager)this.batchManager).endCaching();
            }
        }

        @Override
        void polygon(float[] vertices, short[] triangles, int trianglesCount, float offsetX, float offsetY, float scaleX, float scaleY) {
            int n = vertices.length / 2;
            ((PolygonBatchManager)this.batchManager).ensureSpace(n);
            ((PolygonBatchManager)this.batchManager).pushVertexData(vertices, triangles, trianglesCount, ((PolygonBatchManager)this.batchManager).floatBits, offsetX, offsetY, scaleX, scaleY);
            ((PolygonBatchManager)this.batchManager).pushToBatch();
        }
    }

    static class BatchFilledPolygonDrawer
    extends FilledPolygonDrawer<BatchManager> {
        BatchFilledPolygonDrawer(BatchManager batchManager, AbstractShapeDrawer drawer) {
            super(batchManager, drawer);
        }

        @Override
        void polygon(float centreX, float centreY, int sides, float radiusX, float radiusY, float rotation, float startAngle, float radians, float innerColor, float outerColor) {
            if (radians == 0.0f) {
                return;
            }
            radians = Math.min(radians, (float)Math.PI * 2);
            boolean wasCaching = this.batchManager.startCaching();
            float angleInterval = (float)Math.PI * 2 / (float)sides;
            float endAngle = startAngle + radians;
            float cos = (float)Math.cos(angleInterval);
            float sin = (float)Math.sin(angleInterval);
            float cosRot = (float)Math.cos(rotation);
            float sinRot = (float)Math.sin(rotation);
            int start = (int)Math.ceil((float)sides * (startAngle / ((float)Math.PI * 2)));
            int end = (int)Math.floor((float)sides * (endAngle / ((float)Math.PI * 2))) + 1;
            if (ShapeUtils.epsilonEquals((float)start * angleInterval, startAngle)) {
                ++start;
            }
            B.set(1.0f, 0.0f).rotateRad(startAngle).scl(radiusX, radiusY);
            int n = end - start + 1;
            if (n < 2) {
                this.batchManager.ensureSpaceForTriangle();
                A.set(1.0f, 0.0f).rotateRad(startAngle).scl(radiusX, radiusY);
                B.set(1.0f, 0.0f).rotateRad(endAngle).scl(radiusX, radiusY);
                this.vert1(centreX, centreY);
                this.x2(BatchFilledPolygonDrawer.A.x * cosRot - BatchFilledPolygonDrawer.A.y * sinRot + centreX);
                this.y2(BatchFilledPolygonDrawer.A.x * sinRot + BatchFilledPolygonDrawer.A.y * cosRot + centreY);
                this.x3(BatchFilledPolygonDrawer.B.x * cosRot - BatchFilledPolygonDrawer.B.y * sinRot + centreX);
                this.y3(BatchFilledPolygonDrawer.B.x * sinRot + BatchFilledPolygonDrawer.B.y * cosRot + centreY);
                this.color(innerColor, outerColor, outerColor);
                this.batchManager.pushTriangle();
            } else {
                dir.set(1.0f, 0.0f).rotateRad(Math.min((float)start * angleInterval, endAngle));
                C.set(dir).scl(radiusX, radiusY);
            }
            for (int i = 0; i < n - 1; ++i) {
                A.set(B);
                B.set(C);
                if (i < n - 2) {
                    dir.set(BatchFilledPolygonDrawer.dir.x * cos - BatchFilledPolygonDrawer.dir.y * sin, BatchFilledPolygonDrawer.dir.x * sin + BatchFilledPolygonDrawer.dir.y * cos);
                    C.set(dir).scl(radiusX, radiusY);
                } else {
                    C.set(1.0f, 0.0f).rotateRad(endAngle).scl(radiusX, radiusY);
                }
                if (i % 2 == 0) {
                    this.batchManager.ensureSpaceForQuad();
                    this.vert1(centreX, centreY);
                    this.x2(BatchFilledPolygonDrawer.A.x * cosRot - BatchFilledPolygonDrawer.A.y * sinRot + centreX);
                    this.y2(BatchFilledPolygonDrawer.A.x * sinRot + BatchFilledPolygonDrawer.A.y * cosRot + centreY);
                    this.x3(BatchFilledPolygonDrawer.B.x * cosRot - BatchFilledPolygonDrawer.B.y * sinRot + centreX);
                    this.y3(BatchFilledPolygonDrawer.B.x * sinRot + BatchFilledPolygonDrawer.B.y * cosRot + centreY);
                    this.x4(BatchFilledPolygonDrawer.C.x * cosRot - BatchFilledPolygonDrawer.C.y * sinRot + centreX);
                    this.y4(BatchFilledPolygonDrawer.C.x * sinRot + BatchFilledPolygonDrawer.C.y * cosRot + centreY);
                    this.color(innerColor, outerColor, outerColor, outerColor);
                    this.batchManager.pushQuad();
                    continue;
                }
                if (i != n - 2) continue;
                this.batchManager.ensureSpaceForTriangle();
                C.set(1.0f, 0.0f).rotateRad(endAngle).scl(radiusX, radiusY);
                this.vert1(centreX, centreY);
                this.x2(BatchFilledPolygonDrawer.B.x * cosRot - BatchFilledPolygonDrawer.B.y * sinRot + centreX);
                this.y2(BatchFilledPolygonDrawer.B.x * sinRot + BatchFilledPolygonDrawer.B.y * cosRot + centreY);
                this.x3(BatchFilledPolygonDrawer.C.x * cosRot - BatchFilledPolygonDrawer.C.y * sinRot + centreX);
                this.y3(BatchFilledPolygonDrawer.C.x * sinRot + BatchFilledPolygonDrawer.C.y * cosRot + centreY);
                this.color(innerColor, outerColor, outerColor);
                this.batchManager.pushTriangle();
            }
            if (!wasCaching) {
                this.batchManager.endCaching();
            }
        }

        @Override
        void polygon(float[] vertices, short[] triangles, int trianglesCount, float x, float y, float scaleX, float scaleY) {
            float c = this.batchManager.floatBits;
            for (int i = 0; i < trianglesCount; i += 3) {
                this.batchManager.ensureSpaceForTriangle();
                this.vert1(scaleX * vertices[2 * triangles[i]] + x, scaleY * vertices[2 * triangles[i] + 1] + y);
                this.vert2(scaleX * vertices[2 * triangles[i + 1]] + x, scaleY * vertices[2 * triangles[i + 1] + 1] + y);
                this.vert3(scaleX * vertices[2 * triangles[i + 2]] + x, scaleY * vertices[2 * triangles[i + 2] + 1] + y);
                this.color(c, c, c);
                this.batchManager.pushTriangle();
            }
            this.batchManager.pushToBatch();
        }
    }
}

