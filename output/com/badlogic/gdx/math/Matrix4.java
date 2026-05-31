/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import java.io.Serializable;

public class Matrix4
implements Serializable {
    private static final long serialVersionUID = -2717655254359579617L;
    public static final int M00 = 0;
    public static final int M01 = 4;
    public static final int M02 = 8;
    public static final int M03 = 12;
    public static final int M10 = 1;
    public static final int M11 = 5;
    public static final int M12 = 9;
    public static final int M13 = 13;
    public static final int M20 = 2;
    public static final int M21 = 6;
    public static final int M22 = 10;
    public static final int M23 = 14;
    public static final int M30 = 3;
    public static final int M31 = 7;
    public static final int M32 = 11;
    public static final int M33 = 15;
    static final Quaternion quat = new Quaternion();
    static final Quaternion quat2 = new Quaternion();
    static final Vector3 l_vez = new Vector3();
    static final Vector3 l_vex = new Vector3();
    static final Vector3 l_vey = new Vector3();
    static final Vector3 tmpVec = new Vector3();
    static final Matrix4 tmpMat = new Matrix4();
    static final Vector3 right = new Vector3();
    static final Vector3 tmpForward = new Vector3();
    static final Vector3 tmpUp = new Vector3();
    public final float[] val = new float[16];

    public Matrix4() {
        this.val[0] = 1.0f;
        this.val[5] = 1.0f;
        this.val[10] = 1.0f;
        this.val[15] = 1.0f;
    }

    public Matrix4(Matrix4 matrix) {
        this.set(matrix);
    }

    public Matrix4(float[] values) {
        this.set(values);
    }

    public Matrix4(Quaternion quaternion) {
        this.set(quaternion);
    }

    public Matrix4(Vector3 position, Quaternion rotation, Vector3 scale) {
        this.set(position, rotation, scale);
    }

    public Matrix4 set(Matrix4 matrix) {
        return this.set(matrix.val);
    }

    public Matrix4 set(float[] values) {
        System.arraycopy(values, 0, this.val, 0, this.val.length);
        return this;
    }

    public Matrix4 set(Quaternion quaternion) {
        return this.set(quaternion.x, quaternion.y, quaternion.z, quaternion.w);
    }

    public Matrix4 set(float quaternionX, float quaternionY, float quaternionZ, float quaternionW) {
        return this.set(0.0f, 0.0f, 0.0f, quaternionX, quaternionY, quaternionZ, quaternionW);
    }

    public Matrix4 set(Vector3 position, Quaternion orientation) {
        return this.set(position.x, position.y, position.z, orientation.x, orientation.y, orientation.z, orientation.w);
    }

    public Matrix4 set(float translationX, float translationY, float translationZ, float quaternionX, float quaternionY, float quaternionZ, float quaternionW) {
        float xs = quaternionX * 2.0f;
        float ys = quaternionY * 2.0f;
        float zs = quaternionZ * 2.0f;
        float wx = quaternionW * xs;
        float wy = quaternionW * ys;
        float wz = quaternionW * zs;
        float xx = quaternionX * xs;
        float xy = quaternionX * ys;
        float xz = quaternionX * zs;
        float yy = quaternionY * ys;
        float yz = quaternionY * zs;
        float zz = quaternionZ * zs;
        this.val[0] = 1.0f - (yy + zz);
        this.val[4] = xy - wz;
        this.val[8] = xz + wy;
        this.val[12] = translationX;
        this.val[1] = xy + wz;
        this.val[5] = 1.0f - (xx + zz);
        this.val[9] = yz - wx;
        this.val[13] = translationY;
        this.val[2] = xz - wy;
        this.val[6] = yz + wx;
        this.val[10] = 1.0f - (xx + yy);
        this.val[14] = translationZ;
        this.val[3] = 0.0f;
        this.val[7] = 0.0f;
        this.val[11] = 0.0f;
        this.val[15] = 1.0f;
        return this;
    }

    public Matrix4 set(Vector3 position, Quaternion orientation, Vector3 scale) {
        return this.set(position.x, position.y, position.z, orientation.x, orientation.y, orientation.z, orientation.w, scale.x, scale.y, scale.z);
    }

    public Matrix4 set(float translationX, float translationY, float translationZ, float quaternionX, float quaternionY, float quaternionZ, float quaternionW, float scaleX, float scaleY, float scaleZ) {
        float xs = quaternionX * 2.0f;
        float ys = quaternionY * 2.0f;
        float zs = quaternionZ * 2.0f;
        float wx = quaternionW * xs;
        float wy = quaternionW * ys;
        float wz = quaternionW * zs;
        float xx = quaternionX * xs;
        float xy = quaternionX * ys;
        float xz = quaternionX * zs;
        float yy = quaternionY * ys;
        float yz = quaternionY * zs;
        float zz = quaternionZ * zs;
        this.val[0] = scaleX * (1.0f - (yy + zz));
        this.val[4] = scaleY * (xy - wz);
        this.val[8] = scaleZ * (xz + wy);
        this.val[12] = translationX;
        this.val[1] = scaleX * (xy + wz);
        this.val[5] = scaleY * (1.0f - (xx + zz));
        this.val[9] = scaleZ * (yz - wx);
        this.val[13] = translationY;
        this.val[2] = scaleX * (xz - wy);
        this.val[6] = scaleY * (yz + wx);
        this.val[10] = scaleZ * (1.0f - (xx + yy));
        this.val[14] = translationZ;
        this.val[3] = 0.0f;
        this.val[7] = 0.0f;
        this.val[11] = 0.0f;
        this.val[15] = 1.0f;
        return this;
    }

    public Matrix4 set(Vector3 xAxis, Vector3 yAxis, Vector3 zAxis, Vector3 pos) {
        this.val[0] = xAxis.x;
        this.val[4] = xAxis.y;
        this.val[8] = xAxis.z;
        this.val[1] = yAxis.x;
        this.val[5] = yAxis.y;
        this.val[9] = yAxis.z;
        this.val[2] = zAxis.x;
        this.val[6] = zAxis.y;
        this.val[10] = zAxis.z;
        this.val[12] = pos.x;
        this.val[13] = pos.y;
        this.val[14] = pos.z;
        this.val[3] = 0.0f;
        this.val[7] = 0.0f;
        this.val[11] = 0.0f;
        this.val[15] = 1.0f;
        return this;
    }

    public Matrix4 cpy() {
        return new Matrix4(this);
    }

    public Matrix4 trn(Vector3 vector) {
        this.val[12] = this.val[12] + vector.x;
        this.val[13] = this.val[13] + vector.y;
        this.val[14] = this.val[14] + vector.z;
        return this;
    }

    public Matrix4 trn(float x, float y, float z) {
        this.val[12] = this.val[12] + x;
        this.val[13] = this.val[13] + y;
        this.val[14] = this.val[14] + z;
        return this;
    }

    public float[] getValues() {
        return this.val;
    }

    public Matrix4 mul(Matrix4 matrix) {
        Matrix4.mul(this.val, matrix.val);
        return this;
    }

    public Matrix4 mulLeft(Matrix4 matrix) {
        tmpMat.set(matrix);
        Matrix4.mul(Matrix4.tmpMat.val, this.val);
        return this.set(tmpMat);
    }

    public Matrix4 tra() {
        float m01 = this.val[4];
        float m02 = this.val[8];
        float m03 = this.val[12];
        float m12 = this.val[9];
        float m13 = this.val[13];
        float m23 = this.val[14];
        this.val[4] = this.val[1];
        this.val[8] = this.val[2];
        this.val[12] = this.val[3];
        this.val[1] = m01;
        this.val[9] = this.val[6];
        this.val[13] = this.val[7];
        this.val[2] = m02;
        this.val[6] = m12;
        this.val[14] = this.val[11];
        this.val[3] = m03;
        this.val[7] = m13;
        this.val[11] = m23;
        return this;
    }

    public Matrix4 idt() {
        this.val[0] = 1.0f;
        this.val[4] = 0.0f;
        this.val[8] = 0.0f;
        this.val[12] = 0.0f;
        this.val[1] = 0.0f;
        this.val[5] = 1.0f;
        this.val[9] = 0.0f;
        this.val[13] = 0.0f;
        this.val[2] = 0.0f;
        this.val[6] = 0.0f;
        this.val[10] = 1.0f;
        this.val[14] = 0.0f;
        this.val[3] = 0.0f;
        this.val[7] = 0.0f;
        this.val[11] = 0.0f;
        this.val[15] = 1.0f;
        return this;
    }

    public Matrix4 inv() {
        float l_det = this.val[3] * this.val[6] * this.val[9] * this.val[12] - this.val[2] * this.val[7] * this.val[9] * this.val[12] - this.val[3] * this.val[5] * this.val[10] * this.val[12] + this.val[1] * this.val[7] * this.val[10] * this.val[12] + this.val[2] * this.val[5] * this.val[11] * this.val[12] - this.val[1] * this.val[6] * this.val[11] * this.val[12] - this.val[3] * this.val[6] * this.val[8] * this.val[13] + this.val[2] * this.val[7] * this.val[8] * this.val[13] + this.val[3] * this.val[4] * this.val[10] * this.val[13] - this.val[0] * this.val[7] * this.val[10] * this.val[13] - this.val[2] * this.val[4] * this.val[11] * this.val[13] + this.val[0] * this.val[6] * this.val[11] * this.val[13] + this.val[3] * this.val[5] * this.val[8] * this.val[14] - this.val[1] * this.val[7] * this.val[8] * this.val[14] - this.val[3] * this.val[4] * this.val[9] * this.val[14] + this.val[0] * this.val[7] * this.val[9] * this.val[14] + this.val[1] * this.val[4] * this.val[11] * this.val[14] - this.val[0] * this.val[5] * this.val[11] * this.val[14] - this.val[2] * this.val[5] * this.val[8] * this.val[15] + this.val[1] * this.val[6] * this.val[8] * this.val[15] + this.val[2] * this.val[4] * this.val[9] * this.val[15] - this.val[0] * this.val[6] * this.val[9] * this.val[15] - this.val[1] * this.val[4] * this.val[10] * this.val[15] + this.val[0] * this.val[5] * this.val[10] * this.val[15];
        if (l_det == 0.0f) {
            throw new RuntimeException("non-invertible matrix");
        }
        float m00 = this.val[9] * this.val[14] * this.val[7] - this.val[13] * this.val[10] * this.val[7] + this.val[13] * this.val[6] * this.val[11] - this.val[5] * this.val[14] * this.val[11] - this.val[9] * this.val[6] * this.val[15] + this.val[5] * this.val[10] * this.val[15];
        float m01 = this.val[12] * this.val[10] * this.val[7] - this.val[8] * this.val[14] * this.val[7] - this.val[12] * this.val[6] * this.val[11] + this.val[4] * this.val[14] * this.val[11] + this.val[8] * this.val[6] * this.val[15] - this.val[4] * this.val[10] * this.val[15];
        float m02 = this.val[8] * this.val[13] * this.val[7] - this.val[12] * this.val[9] * this.val[7] + this.val[12] * this.val[5] * this.val[11] - this.val[4] * this.val[13] * this.val[11] - this.val[8] * this.val[5] * this.val[15] + this.val[4] * this.val[9] * this.val[15];
        float m03 = this.val[12] * this.val[9] * this.val[6] - this.val[8] * this.val[13] * this.val[6] - this.val[12] * this.val[5] * this.val[10] + this.val[4] * this.val[13] * this.val[10] + this.val[8] * this.val[5] * this.val[14] - this.val[4] * this.val[9] * this.val[14];
        float m10 = this.val[13] * this.val[10] * this.val[3] - this.val[9] * this.val[14] * this.val[3] - this.val[13] * this.val[2] * this.val[11] + this.val[1] * this.val[14] * this.val[11] + this.val[9] * this.val[2] * this.val[15] - this.val[1] * this.val[10] * this.val[15];
        float m11 = this.val[8] * this.val[14] * this.val[3] - this.val[12] * this.val[10] * this.val[3] + this.val[12] * this.val[2] * this.val[11] - this.val[0] * this.val[14] * this.val[11] - this.val[8] * this.val[2] * this.val[15] + this.val[0] * this.val[10] * this.val[15];
        float m12 = this.val[12] * this.val[9] * this.val[3] - this.val[8] * this.val[13] * this.val[3] - this.val[12] * this.val[1] * this.val[11] + this.val[0] * this.val[13] * this.val[11] + this.val[8] * this.val[1] * this.val[15] - this.val[0] * this.val[9] * this.val[15];
        float m13 = this.val[8] * this.val[13] * this.val[2] - this.val[12] * this.val[9] * this.val[2] + this.val[12] * this.val[1] * this.val[10] - this.val[0] * this.val[13] * this.val[10] - this.val[8] * this.val[1] * this.val[14] + this.val[0] * this.val[9] * this.val[14];
        float m20 = this.val[5] * this.val[14] * this.val[3] - this.val[13] * this.val[6] * this.val[3] + this.val[13] * this.val[2] * this.val[7] - this.val[1] * this.val[14] * this.val[7] - this.val[5] * this.val[2] * this.val[15] + this.val[1] * this.val[6] * this.val[15];
        float m21 = this.val[12] * this.val[6] * this.val[3] - this.val[4] * this.val[14] * this.val[3] - this.val[12] * this.val[2] * this.val[7] + this.val[0] * this.val[14] * this.val[7] + this.val[4] * this.val[2] * this.val[15] - this.val[0] * this.val[6] * this.val[15];
        float m22 = this.val[4] * this.val[13] * this.val[3] - this.val[12] * this.val[5] * this.val[3] + this.val[12] * this.val[1] * this.val[7] - this.val[0] * this.val[13] * this.val[7] - this.val[4] * this.val[1] * this.val[15] + this.val[0] * this.val[5] * this.val[15];
        float m23 = this.val[12] * this.val[5] * this.val[2] - this.val[4] * this.val[13] * this.val[2] - this.val[12] * this.val[1] * this.val[6] + this.val[0] * this.val[13] * this.val[6] + this.val[4] * this.val[1] * this.val[14] - this.val[0] * this.val[5] * this.val[14];
        float m30 = this.val[9] * this.val[6] * this.val[3] - this.val[5] * this.val[10] * this.val[3] - this.val[9] * this.val[2] * this.val[7] + this.val[1] * this.val[10] * this.val[7] + this.val[5] * this.val[2] * this.val[11] - this.val[1] * this.val[6] * this.val[11];
        float m31 = this.val[4] * this.val[10] * this.val[3] - this.val[8] * this.val[6] * this.val[3] + this.val[8] * this.val[2] * this.val[7] - this.val[0] * this.val[10] * this.val[7] - this.val[4] * this.val[2] * this.val[11] + this.val[0] * this.val[6] * this.val[11];
        float m32 = this.val[8] * this.val[5] * this.val[3] - this.val[4] * this.val[9] * this.val[3] - this.val[8] * this.val[1] * this.val[7] + this.val[0] * this.val[9] * this.val[7] + this.val[4] * this.val[1] * this.val[11] - this.val[0] * this.val[5] * this.val[11];
        float m33 = this.val[4] * this.val[9] * this.val[2] - this.val[8] * this.val[5] * this.val[2] + this.val[8] * this.val[1] * this.val[6] - this.val[0] * this.val[9] * this.val[6] - this.val[4] * this.val[1] * this.val[10] + this.val[0] * this.val[5] * this.val[10];
        float inv_det = 1.0f / l_det;
        this.val[0] = m00 * inv_det;
        this.val[1] = m10 * inv_det;
        this.val[2] = m20 * inv_det;
        this.val[3] = m30 * inv_det;
        this.val[4] = m01 * inv_det;
        this.val[5] = m11 * inv_det;
        this.val[6] = m21 * inv_det;
        this.val[7] = m31 * inv_det;
        this.val[8] = m02 * inv_det;
        this.val[9] = m12 * inv_det;
        this.val[10] = m22 * inv_det;
        this.val[11] = m32 * inv_det;
        this.val[12] = m03 * inv_det;
        this.val[13] = m13 * inv_det;
        this.val[14] = m23 * inv_det;
        this.val[15] = m33 * inv_det;
        return this;
    }

    public float det() {
        return this.val[3] * this.val[6] * this.val[9] * this.val[12] - this.val[2] * this.val[7] * this.val[9] * this.val[12] - this.val[3] * this.val[5] * this.val[10] * this.val[12] + this.val[1] * this.val[7] * this.val[10] * this.val[12] + this.val[2] * this.val[5] * this.val[11] * this.val[12] - this.val[1] * this.val[6] * this.val[11] * this.val[12] - this.val[3] * this.val[6] * this.val[8] * this.val[13] + this.val[2] * this.val[7] * this.val[8] * this.val[13] + this.val[3] * this.val[4] * this.val[10] * this.val[13] - this.val[0] * this.val[7] * this.val[10] * this.val[13] - this.val[2] * this.val[4] * this.val[11] * this.val[13] + this.val[0] * this.val[6] * this.val[11] * this.val[13] + this.val[3] * this.val[5] * this.val[8] * this.val[14] - this.val[1] * this.val[7] * this.val[8] * this.val[14] - this.val[3] * this.val[4] * this.val[9] * this.val[14] + this.val[0] * this.val[7] * this.val[9] * this.val[14] + this.val[1] * this.val[4] * this.val[11] * this.val[14] - this.val[0] * this.val[5] * this.val[11] * this.val[14] - this.val[2] * this.val[5] * this.val[8] * this.val[15] + this.val[1] * this.val[6] * this.val[8] * this.val[15] + this.val[2] * this.val[4] * this.val[9] * this.val[15] - this.val[0] * this.val[6] * this.val[9] * this.val[15] - this.val[1] * this.val[4] * this.val[10] * this.val[15] + this.val[0] * this.val[5] * this.val[10] * this.val[15];
    }

    public float det3x3() {
        return this.val[0] * this.val[5] * this.val[10] + this.val[4] * this.val[9] * this.val[2] + this.val[8] * this.val[1] * this.val[6] - this.val[0] * this.val[9] * this.val[6] - this.val[4] * this.val[1] * this.val[10] - this.val[8] * this.val[5] * this.val[2];
    }

    public Matrix4 setToProjection(float near, float far, float fovy, float aspectRatio) {
        this.idt();
        float l_fd = (float)(1.0 / Math.tan((double)fovy * (Math.PI / 180) / 2.0));
        float l_a1 = (far + near) / (near - far);
        float l_a2 = 2.0f * far * near / (near - far);
        this.val[0] = l_fd / aspectRatio;
        this.val[1] = 0.0f;
        this.val[2] = 0.0f;
        this.val[3] = 0.0f;
        this.val[4] = 0.0f;
        this.val[5] = l_fd;
        this.val[6] = 0.0f;
        this.val[7] = 0.0f;
        this.val[8] = 0.0f;
        this.val[9] = 0.0f;
        this.val[10] = l_a1;
        this.val[11] = -1.0f;
        this.val[12] = 0.0f;
        this.val[13] = 0.0f;
        this.val[14] = l_a2;
        this.val[15] = 0.0f;
        return this;
    }

    public Matrix4 setToProjection(float left, float right, float bottom, float top, float near, float far) {
        float x = 2.0f * near / (right - left);
        float y = 2.0f * near / (top - bottom);
        float a = (right + left) / (right - left);
        float b = (top + bottom) / (top - bottom);
        float l_a1 = (far + near) / (near - far);
        float l_a2 = 2.0f * far * near / (near - far);
        this.val[0] = x;
        this.val[1] = 0.0f;
        this.val[2] = 0.0f;
        this.val[3] = 0.0f;
        this.val[4] = 0.0f;
        this.val[5] = y;
        this.val[6] = 0.0f;
        this.val[7] = 0.0f;
        this.val[8] = a;
        this.val[9] = b;
        this.val[10] = l_a1;
        this.val[11] = -1.0f;
        this.val[12] = 0.0f;
        this.val[13] = 0.0f;
        this.val[14] = l_a2;
        this.val[15] = 0.0f;
        return this;
    }

    public Matrix4 setToOrtho2D(float x, float y, float width, float height) {
        this.setToOrtho(x, x + width, y, y + height, 0.0f, 1.0f);
        return this;
    }

    public Matrix4 setToOrtho2D(float x, float y, float width, float height, float near, float far) {
        this.setToOrtho(x, x + width, y, y + height, near, far);
        return this;
    }

    public Matrix4 setToOrtho(float left, float right, float bottom, float top, float near, float far) {
        float x_orth = 2.0f / (right - left);
        float y_orth = 2.0f / (top - bottom);
        float z_orth = -2.0f / (far - near);
        float tx = -(right + left) / (right - left);
        float ty = -(top + bottom) / (top - bottom);
        float tz = -(far + near) / (far - near);
        this.val[0] = x_orth;
        this.val[1] = 0.0f;
        this.val[2] = 0.0f;
        this.val[3] = 0.0f;
        this.val[4] = 0.0f;
        this.val[5] = y_orth;
        this.val[6] = 0.0f;
        this.val[7] = 0.0f;
        this.val[8] = 0.0f;
        this.val[9] = 0.0f;
        this.val[10] = z_orth;
        this.val[11] = 0.0f;
        this.val[12] = tx;
        this.val[13] = ty;
        this.val[14] = tz;
        this.val[15] = 1.0f;
        return this;
    }

    public Matrix4 setTranslation(Vector3 vector) {
        this.val[12] = vector.x;
        this.val[13] = vector.y;
        this.val[14] = vector.z;
        return this;
    }

    public Matrix4 setTranslation(float x, float y, float z) {
        this.val[12] = x;
        this.val[13] = y;
        this.val[14] = z;
        return this;
    }

    public Matrix4 setToTranslation(Vector3 vector) {
        this.idt();
        this.val[12] = vector.x;
        this.val[13] = vector.y;
        this.val[14] = vector.z;
        return this;
    }

    public Matrix4 setToTranslation(float x, float y, float z) {
        this.idt();
        this.val[12] = x;
        this.val[13] = y;
        this.val[14] = z;
        return this;
    }

    public Matrix4 setToTranslationAndScaling(Vector3 translation, Vector3 scaling) {
        this.idt();
        this.val[12] = translation.x;
        this.val[13] = translation.y;
        this.val[14] = translation.z;
        this.val[0] = scaling.x;
        this.val[5] = scaling.y;
        this.val[10] = scaling.z;
        return this;
    }

    public Matrix4 setToTranslationAndScaling(float translationX, float translationY, float translationZ, float scalingX, float scalingY, float scalingZ) {
        this.idt();
        this.val[12] = translationX;
        this.val[13] = translationY;
        this.val[14] = translationZ;
        this.val[0] = scalingX;
        this.val[5] = scalingY;
        this.val[10] = scalingZ;
        return this;
    }

    public Matrix4 setToRotation(Vector3 axis, float degrees) {
        if (degrees == 0.0f) {
            this.idt();
            return this;
        }
        return this.set(quat.set(axis, degrees));
    }

    public Matrix4 setToRotationRad(Vector3 axis, float radians) {
        if (radians == 0.0f) {
            this.idt();
            return this;
        }
        return this.set(quat.setFromAxisRad(axis, radians));
    }

    public Matrix4 setToRotation(float axisX, float axisY, float axisZ, float degrees) {
        if (degrees == 0.0f) {
            this.idt();
            return this;
        }
        return this.set(quat.setFromAxis(axisX, axisY, axisZ, degrees));
    }

    public Matrix4 setToRotationRad(float axisX, float axisY, float axisZ, float radians) {
        if (radians == 0.0f) {
            this.idt();
            return this;
        }
        return this.set(quat.setFromAxisRad(axisX, axisY, axisZ, radians));
    }

    public Matrix4 setToRotation(Vector3 v1, Vector3 v2) {
        return this.set(quat.setFromCross(v1, v2));
    }

    public Matrix4 setToRotation(float x1, float y1, float z1, float x2, float y2, float z2) {
        return this.set(quat.setFromCross(x1, y1, z1, x2, y2, z2));
    }

    public Matrix4 setFromEulerAngles(float yaw, float pitch, float roll) {
        quat.setEulerAngles(yaw, pitch, roll);
        return this.set(quat);
    }

    public Matrix4 setFromEulerAnglesRad(float yaw, float pitch, float roll) {
        quat.setEulerAnglesRad(yaw, pitch, roll);
        return this.set(quat);
    }

    public Matrix4 setToScaling(Vector3 vector) {
        this.idt();
        this.val[0] = vector.x;
        this.val[5] = vector.y;
        this.val[10] = vector.z;
        return this;
    }

    public Matrix4 setToScaling(float x, float y, float z) {
        this.idt();
        this.val[0] = x;
        this.val[5] = y;
        this.val[10] = z;
        return this;
    }

    public Matrix4 setToLookAt(Vector3 direction, Vector3 up) {
        l_vez.set(direction).nor();
        l_vex.set(direction).crs(up).nor();
        l_vey.set(l_vex).crs(l_vez).nor();
        this.idt();
        this.val[0] = Matrix4.l_vex.x;
        this.val[4] = Matrix4.l_vex.y;
        this.val[8] = Matrix4.l_vex.z;
        this.val[1] = Matrix4.l_vey.x;
        this.val[5] = Matrix4.l_vey.y;
        this.val[9] = Matrix4.l_vey.z;
        this.val[2] = -Matrix4.l_vez.x;
        this.val[6] = -Matrix4.l_vez.y;
        this.val[10] = -Matrix4.l_vez.z;
        return this;
    }

    public Matrix4 setToLookAt(Vector3 position, Vector3 target, Vector3 up) {
        tmpVec.set(target).sub(position);
        this.setToLookAt(tmpVec, up);
        this.mul(tmpMat.setToTranslation(-position.x, -position.y, -position.z));
        return this;
    }

    public Matrix4 setToWorld(Vector3 position, Vector3 forward, Vector3 up) {
        tmpForward.set(forward).nor();
        right.set(tmpForward).crs(up).nor();
        tmpUp.set(right).crs(tmpForward).nor();
        this.set(right, tmpUp, tmpForward.scl(-1.0f), position);
        return this;
    }

    public Matrix4 lerp(Matrix4 matrix, float alpha) {
        for (int i = 0; i < 16; ++i) {
            this.val[i] = this.val[i] * (1.0f - alpha) + matrix.val[i] * alpha;
        }
        return this;
    }

    public Matrix4 avg(Matrix4 other, float w) {
        this.getScale(tmpVec);
        other.getScale(tmpForward);
        this.getRotation(quat);
        other.getRotation(quat2);
        this.getTranslation(tmpUp);
        other.getTranslation(right);
        this.setToScaling(tmpVec.scl(w).add(tmpForward.scl(1.0f - w)));
        this.rotate(quat.slerp(quat2, 1.0f - w));
        this.setTranslation(tmpUp.scl(w).add(right.scl(1.0f - w)));
        return this;
    }

    public Matrix4 avg(Matrix4[] t) {
        float w = 1.0f / (float)t.length;
        tmpVec.set(t[0].getScale(tmpUp).scl(w));
        quat.set(t[0].getRotation(quat2).exp(w));
        tmpForward.set(t[0].getTranslation(tmpUp).scl(w));
        for (int i = 1; i < t.length; ++i) {
            tmpVec.add(t[i].getScale(tmpUp).scl(w));
            quat.mul(t[i].getRotation(quat2).exp(w));
            tmpForward.add(t[i].getTranslation(tmpUp).scl(w));
        }
        quat.nor();
        this.setToScaling(tmpVec);
        this.rotate(quat);
        this.setTranslation(tmpForward);
        return this;
    }

    public Matrix4 avg(Matrix4[] t, float[] w) {
        tmpVec.set(t[0].getScale(tmpUp).scl(w[0]));
        quat.set(t[0].getRotation(quat2).exp(w[0]));
        tmpForward.set(t[0].getTranslation(tmpUp).scl(w[0]));
        for (int i = 1; i < t.length; ++i) {
            tmpVec.add(t[i].getScale(tmpUp).scl(w[i]));
            quat.mul(t[i].getRotation(quat2).exp(w[i]));
            tmpForward.add(t[i].getTranslation(tmpUp).scl(w[i]));
        }
        quat.nor();
        this.setToScaling(tmpVec);
        this.rotate(quat);
        this.setTranslation(tmpForward);
        return this;
    }

    public Matrix4 set(Matrix3 mat) {
        this.val[0] = mat.val[0];
        this.val[1] = mat.val[1];
        this.val[2] = mat.val[2];
        this.val[3] = 0.0f;
        this.val[4] = mat.val[3];
        this.val[5] = mat.val[4];
        this.val[6] = mat.val[5];
        this.val[7] = 0.0f;
        this.val[8] = 0.0f;
        this.val[9] = 0.0f;
        this.val[10] = 1.0f;
        this.val[11] = 0.0f;
        this.val[12] = mat.val[6];
        this.val[13] = mat.val[7];
        this.val[14] = 0.0f;
        this.val[15] = mat.val[8];
        return this;
    }

    public Matrix4 set(Affine2 affine) {
        this.val[0] = affine.m00;
        this.val[1] = affine.m10;
        this.val[2] = 0.0f;
        this.val[3] = 0.0f;
        this.val[4] = affine.m01;
        this.val[5] = affine.m11;
        this.val[6] = 0.0f;
        this.val[7] = 0.0f;
        this.val[8] = 0.0f;
        this.val[9] = 0.0f;
        this.val[10] = 1.0f;
        this.val[11] = 0.0f;
        this.val[12] = affine.m02;
        this.val[13] = affine.m12;
        this.val[14] = 0.0f;
        this.val[15] = 1.0f;
        return this;
    }

    public Matrix4 setAsAffine(Affine2 affine) {
        this.val[0] = affine.m00;
        this.val[1] = affine.m10;
        this.val[4] = affine.m01;
        this.val[5] = affine.m11;
        this.val[12] = affine.m02;
        this.val[13] = affine.m12;
        return this;
    }

    public Matrix4 setAsAffine(Matrix4 mat) {
        this.val[0] = mat.val[0];
        this.val[1] = mat.val[1];
        this.val[4] = mat.val[4];
        this.val[5] = mat.val[5];
        this.val[12] = mat.val[12];
        this.val[13] = mat.val[13];
        return this;
    }

    public Matrix4 scl(Vector3 scale) {
        this.val[0] = this.val[0] * scale.x;
        this.val[5] = this.val[5] * scale.y;
        this.val[10] = this.val[10] * scale.z;
        return this;
    }

    public Matrix4 scl(float x, float y, float z) {
        this.val[0] = this.val[0] * x;
        this.val[5] = this.val[5] * y;
        this.val[10] = this.val[10] * z;
        return this;
    }

    public Matrix4 scl(float scale) {
        this.val[0] = this.val[0] * scale;
        this.val[5] = this.val[5] * scale;
        this.val[10] = this.val[10] * scale;
        return this;
    }

    public Vector3 getTranslation(Vector3 position) {
        position.x = this.val[12];
        position.y = this.val[13];
        position.z = this.val[14];
        return position;
    }

    public Quaternion getRotation(Quaternion rotation, boolean normalizeAxes) {
        return rotation.setFromMatrix(normalizeAxes, this);
    }

    public Quaternion getRotation(Quaternion rotation) {
        return rotation.setFromMatrix(this);
    }

    public float getScaleXSquared() {
        return this.val[0] * this.val[0] + this.val[4] * this.val[4] + this.val[8] * this.val[8];
    }

    public float getScaleYSquared() {
        return this.val[1] * this.val[1] + this.val[5] * this.val[5] + this.val[9] * this.val[9];
    }

    public float getScaleZSquared() {
        return this.val[2] * this.val[2] + this.val[6] * this.val[6] + this.val[10] * this.val[10];
    }

    public float getScaleX() {
        return MathUtils.isZero(this.val[4]) && MathUtils.isZero(this.val[8]) ? Math.abs(this.val[0]) : (float)Math.sqrt(this.getScaleXSquared());
    }

    public float getScaleY() {
        return MathUtils.isZero(this.val[1]) && MathUtils.isZero(this.val[9]) ? Math.abs(this.val[5]) : (float)Math.sqrt(this.getScaleYSquared());
    }

    public float getScaleZ() {
        return MathUtils.isZero(this.val[2]) && MathUtils.isZero(this.val[6]) ? Math.abs(this.val[10]) : (float)Math.sqrt(this.getScaleZSquared());
    }

    public Vector3 getScale(Vector3 scale) {
        return scale.set(this.getScaleX(), this.getScaleY(), this.getScaleZ());
    }

    public Matrix4 toNormalMatrix() {
        this.val[12] = 0.0f;
        this.val[13] = 0.0f;
        this.val[14] = 0.0f;
        return this.inv().tra();
    }

    public String toString() {
        return "[" + this.val[0] + "|" + this.val[4] + "|" + this.val[8] + "|" + this.val[12] + "]\n[" + this.val[1] + "|" + this.val[5] + "|" + this.val[9] + "|" + this.val[13] + "]\n[" + this.val[2] + "|" + this.val[6] + "|" + this.val[10] + "|" + this.val[14] + "]\n[" + this.val[3] + "|" + this.val[7] + "|" + this.val[11] + "|" + this.val[15] + "]\n";
    }

    public static native void mulVec(float[] var0, float[] var1, int var2, int var3, int var4);

    public static native void prj(float[] var0, float[] var1, int var2, int var3, int var4);

    public static native void rot(float[] var0, float[] var1, int var2, int var3, int var4);

    public static void mul(float[] mata, float[] matb) {
        float m00 = mata[0] * matb[0] + mata[4] * matb[1] + mata[8] * matb[2] + mata[12] * matb[3];
        float m01 = mata[0] * matb[4] + mata[4] * matb[5] + mata[8] * matb[6] + mata[12] * matb[7];
        float m02 = mata[0] * matb[8] + mata[4] * matb[9] + mata[8] * matb[10] + mata[12] * matb[11];
        float m03 = mata[0] * matb[12] + mata[4] * matb[13] + mata[8] * matb[14] + mata[12] * matb[15];
        float m10 = mata[1] * matb[0] + mata[5] * matb[1] + mata[9] * matb[2] + mata[13] * matb[3];
        float m11 = mata[1] * matb[4] + mata[5] * matb[5] + mata[9] * matb[6] + mata[13] * matb[7];
        float m12 = mata[1] * matb[8] + mata[5] * matb[9] + mata[9] * matb[10] + mata[13] * matb[11];
        float m13 = mata[1] * matb[12] + mata[5] * matb[13] + mata[9] * matb[14] + mata[13] * matb[15];
        float m20 = mata[2] * matb[0] + mata[6] * matb[1] + mata[10] * matb[2] + mata[14] * matb[3];
        float m21 = mata[2] * matb[4] + mata[6] * matb[5] + mata[10] * matb[6] + mata[14] * matb[7];
        float m22 = mata[2] * matb[8] + mata[6] * matb[9] + mata[10] * matb[10] + mata[14] * matb[11];
        float m23 = mata[2] * matb[12] + mata[6] * matb[13] + mata[10] * matb[14] + mata[14] * matb[15];
        float m30 = mata[3] * matb[0] + mata[7] * matb[1] + mata[11] * matb[2] + mata[15] * matb[3];
        float m31 = mata[3] * matb[4] + mata[7] * matb[5] + mata[11] * matb[6] + mata[15] * matb[7];
        float m32 = mata[3] * matb[8] + mata[7] * matb[9] + mata[11] * matb[10] + mata[15] * matb[11];
        float m33 = mata[3] * matb[12] + mata[7] * matb[13] + mata[11] * matb[14] + mata[15] * matb[15];
        mata[0] = m00;
        mata[1] = m10;
        mata[2] = m20;
        mata[3] = m30;
        mata[4] = m01;
        mata[5] = m11;
        mata[6] = m21;
        mata[7] = m31;
        mata[8] = m02;
        mata[9] = m12;
        mata[10] = m22;
        mata[11] = m32;
        mata[12] = m03;
        mata[13] = m13;
        mata[14] = m23;
        mata[15] = m33;
    }

    public static void mulVec(float[] mat, float[] vec) {
        float x = vec[0] * mat[0] + vec[1] * mat[4] + vec[2] * mat[8] + mat[12];
        float y = vec[0] * mat[1] + vec[1] * mat[5] + vec[2] * mat[9] + mat[13];
        float z = vec[0] * mat[2] + vec[1] * mat[6] + vec[2] * mat[10] + mat[14];
        vec[0] = x;
        vec[1] = y;
        vec[2] = z;
    }

    public static void prj(float[] mat, float[] vec) {
        float inv_w = 1.0f / (vec[0] * mat[3] + vec[1] * mat[7] + vec[2] * mat[11] + mat[15]);
        float x = (vec[0] * mat[0] + vec[1] * mat[4] + vec[2] * mat[8] + mat[12]) * inv_w;
        float y = (vec[0] * mat[1] + vec[1] * mat[5] + vec[2] * mat[9] + mat[13]) * inv_w;
        float z = (vec[0] * mat[2] + vec[1] * mat[6] + vec[2] * mat[10] + mat[14]) * inv_w;
        vec[0] = x;
        vec[1] = y;
        vec[2] = z;
    }

    public static void rot(float[] mat, float[] vec) {
        float x = vec[0] * mat[0] + vec[1] * mat[4] + vec[2] * mat[8];
        float y = vec[0] * mat[1] + vec[1] * mat[5] + vec[2] * mat[9];
        float z = vec[0] * mat[2] + vec[1] * mat[6] + vec[2] * mat[10];
        vec[0] = x;
        vec[1] = y;
        vec[2] = z;
    }

    public static boolean inv(float[] values) {
        float l_det = Matrix4.det(values);
        if (l_det == 0.0f) {
            return false;
        }
        float m00 = values[9] * values[14] * values[7] - values[13] * values[10] * values[7] + values[13] * values[6] * values[11] - values[5] * values[14] * values[11] - values[9] * values[6] * values[15] + values[5] * values[10] * values[15];
        float m01 = values[12] * values[10] * values[7] - values[8] * values[14] * values[7] - values[12] * values[6] * values[11] + values[4] * values[14] * values[11] + values[8] * values[6] * values[15] - values[4] * values[10] * values[15];
        float m02 = values[8] * values[13] * values[7] - values[12] * values[9] * values[7] + values[12] * values[5] * values[11] - values[4] * values[13] * values[11] - values[8] * values[5] * values[15] + values[4] * values[9] * values[15];
        float m03 = values[12] * values[9] * values[6] - values[8] * values[13] * values[6] - values[12] * values[5] * values[10] + values[4] * values[13] * values[10] + values[8] * values[5] * values[14] - values[4] * values[9] * values[14];
        float m10 = values[13] * values[10] * values[3] - values[9] * values[14] * values[3] - values[13] * values[2] * values[11] + values[1] * values[14] * values[11] + values[9] * values[2] * values[15] - values[1] * values[10] * values[15];
        float m11 = values[8] * values[14] * values[3] - values[12] * values[10] * values[3] + values[12] * values[2] * values[11] - values[0] * values[14] * values[11] - values[8] * values[2] * values[15] + values[0] * values[10] * values[15];
        float m12 = values[12] * values[9] * values[3] - values[8] * values[13] * values[3] - values[12] * values[1] * values[11] + values[0] * values[13] * values[11] + values[8] * values[1] * values[15] - values[0] * values[9] * values[15];
        float m13 = values[8] * values[13] * values[2] - values[12] * values[9] * values[2] + values[12] * values[1] * values[10] - values[0] * values[13] * values[10] - values[8] * values[1] * values[14] + values[0] * values[9] * values[14];
        float m20 = values[5] * values[14] * values[3] - values[13] * values[6] * values[3] + values[13] * values[2] * values[7] - values[1] * values[14] * values[7] - values[5] * values[2] * values[15] + values[1] * values[6] * values[15];
        float m21 = values[12] * values[6] * values[3] - values[4] * values[14] * values[3] - values[12] * values[2] * values[7] + values[0] * values[14] * values[7] + values[4] * values[2] * values[15] - values[0] * values[6] * values[15];
        float m22 = values[4] * values[13] * values[3] - values[12] * values[5] * values[3] + values[12] * values[1] * values[7] - values[0] * values[13] * values[7] - values[4] * values[1] * values[15] + values[0] * values[5] * values[15];
        float m23 = values[12] * values[5] * values[2] - values[4] * values[13] * values[2] - values[12] * values[1] * values[6] + values[0] * values[13] * values[6] + values[4] * values[1] * values[14] - values[0] * values[5] * values[14];
        float m30 = values[9] * values[6] * values[3] - values[5] * values[10] * values[3] - values[9] * values[2] * values[7] + values[1] * values[10] * values[7] + values[5] * values[2] * values[11] - values[1] * values[6] * values[11];
        float m31 = values[4] * values[10] * values[3] - values[8] * values[6] * values[3] + values[8] * values[2] * values[7] - values[0] * values[10] * values[7] - values[4] * values[2] * values[11] + values[0] * values[6] * values[11];
        float m32 = values[8] * values[5] * values[3] - values[4] * values[9] * values[3] - values[8] * values[1] * values[7] + values[0] * values[9] * values[7] + values[4] * values[1] * values[11] - values[0] * values[5] * values[11];
        float m33 = values[4] * values[9] * values[2] - values[8] * values[5] * values[2] + values[8] * values[1] * values[6] - values[0] * values[9] * values[6] - values[4] * values[1] * values[10] + values[0] * values[5] * values[10];
        float inv_det = 1.0f / l_det;
        values[0] = m00 * inv_det;
        values[1] = m10 * inv_det;
        values[2] = m20 * inv_det;
        values[3] = m30 * inv_det;
        values[4] = m01 * inv_det;
        values[5] = m11 * inv_det;
        values[6] = m21 * inv_det;
        values[7] = m31 * inv_det;
        values[8] = m02 * inv_det;
        values[9] = m12 * inv_det;
        values[10] = m22 * inv_det;
        values[11] = m32 * inv_det;
        values[12] = m03 * inv_det;
        values[13] = m13 * inv_det;
        values[14] = m23 * inv_det;
        values[15] = m33 * inv_det;
        return true;
    }

    public static float det(float[] values) {
        return values[3] * values[6] * values[9] * values[12] - values[2] * values[7] * values[9] * values[12] - values[3] * values[5] * values[10] * values[12] + values[1] * values[7] * values[10] * values[12] + values[2] * values[5] * values[11] * values[12] - values[1] * values[6] * values[11] * values[12] - values[3] * values[6] * values[8] * values[13] + values[2] * values[7] * values[8] * values[13] + values[3] * values[4] * values[10] * values[13] - values[0] * values[7] * values[10] * values[13] - values[2] * values[4] * values[11] * values[13] + values[0] * values[6] * values[11] * values[13] + values[3] * values[5] * values[8] * values[14] - values[1] * values[7] * values[8] * values[14] - values[3] * values[4] * values[9] * values[14] + values[0] * values[7] * values[9] * values[14] + values[1] * values[4] * values[11] * values[14] - values[0] * values[5] * values[11] * values[14] - values[2] * values[5] * values[8] * values[15] + values[1] * values[6] * values[8] * values[15] + values[2] * values[4] * values[9] * values[15] - values[0] * values[6] * values[9] * values[15] - values[1] * values[4] * values[10] * values[15] + values[0] * values[5] * values[10] * values[15];
    }

    public Matrix4 translate(Vector3 translation) {
        return this.translate(translation.x, translation.y, translation.z);
    }

    public Matrix4 translate(float x, float y, float z) {
        this.val[12] = this.val[12] + (this.val[0] * x + this.val[4] * y + this.val[8] * z);
        this.val[13] = this.val[13] + (this.val[1] * x + this.val[5] * y + this.val[9] * z);
        this.val[14] = this.val[14] + (this.val[2] * x + this.val[6] * y + this.val[10] * z);
        this.val[15] = this.val[15] + (this.val[3] * x + this.val[7] * y + this.val[11] * z);
        return this;
    }

    public Matrix4 rotate(Vector3 axis, float degrees) {
        if (degrees == 0.0f) {
            return this;
        }
        quat.set(axis, degrees);
        return this.rotate(quat);
    }

    public Matrix4 rotateRad(Vector3 axis, float radians) {
        if (radians == 0.0f) {
            return this;
        }
        quat.setFromAxisRad(axis, radians);
        return this.rotate(quat);
    }

    public Matrix4 rotate(float axisX, float axisY, float axisZ, float degrees) {
        if (degrees == 0.0f) {
            return this;
        }
        quat.setFromAxis(axisX, axisY, axisZ, degrees);
        return this.rotate(quat);
    }

    public Matrix4 rotateRad(float axisX, float axisY, float axisZ, float radians) {
        if (radians == 0.0f) {
            return this;
        }
        quat.setFromAxisRad(axisX, axisY, axisZ, radians);
        return this.rotate(quat);
    }

    public Matrix4 rotate(Quaternion rotation) {
        float x = rotation.x;
        float y = rotation.y;
        float z = rotation.z;
        float w = rotation.w;
        float xx = x * x;
        float xy = x * y;
        float xz = x * z;
        float xw = x * w;
        float yy = y * y;
        float yz = y * z;
        float yw = y * w;
        float zz = z * z;
        float zw = z * w;
        float r00 = 1.0f - 2.0f * (yy + zz);
        float r01 = 2.0f * (xy - zw);
        float r02 = 2.0f * (xz + yw);
        float r10 = 2.0f * (xy + zw);
        float r11 = 1.0f - 2.0f * (xx + zz);
        float r12 = 2.0f * (yz - xw);
        float r20 = 2.0f * (xz - yw);
        float r21 = 2.0f * (yz + xw);
        float r22 = 1.0f - 2.0f * (xx + yy);
        float m00 = this.val[0] * r00 + this.val[4] * r10 + this.val[8] * r20;
        float m01 = this.val[0] * r01 + this.val[4] * r11 + this.val[8] * r21;
        float m02 = this.val[0] * r02 + this.val[4] * r12 + this.val[8] * r22;
        float m10 = this.val[1] * r00 + this.val[5] * r10 + this.val[9] * r20;
        float m11 = this.val[1] * r01 + this.val[5] * r11 + this.val[9] * r21;
        float m12 = this.val[1] * r02 + this.val[5] * r12 + this.val[9] * r22;
        float m20 = this.val[2] * r00 + this.val[6] * r10 + this.val[10] * r20;
        float m21 = this.val[2] * r01 + this.val[6] * r11 + this.val[10] * r21;
        float m22 = this.val[2] * r02 + this.val[6] * r12 + this.val[10] * r22;
        float m30 = this.val[3] * r00 + this.val[7] * r10 + this.val[11] * r20;
        float m31 = this.val[3] * r01 + this.val[7] * r11 + this.val[11] * r21;
        float m32 = this.val[3] * r02 + this.val[7] * r12 + this.val[11] * r22;
        this.val[0] = m00;
        this.val[1] = m10;
        this.val[2] = m20;
        this.val[3] = m30;
        this.val[4] = m01;
        this.val[5] = m11;
        this.val[6] = m21;
        this.val[7] = m31;
        this.val[8] = m02;
        this.val[9] = m12;
        this.val[10] = m22;
        this.val[11] = m32;
        return this;
    }

    public Matrix4 rotate(Vector3 v1, Vector3 v2) {
        return this.rotate(quat.setFromCross(v1, v2));
    }

    public Matrix4 rotateTowardDirection(Vector3 direction, Vector3 up) {
        l_vez.set(direction).nor();
        l_vex.set(direction).crs(up).nor();
        l_vey.set(l_vex).crs(l_vez).nor();
        float m00 = this.val[0] * Matrix4.l_vex.x + this.val[4] * Matrix4.l_vex.y + this.val[8] * Matrix4.l_vex.z;
        float m01 = this.val[0] * Matrix4.l_vey.x + this.val[4] * Matrix4.l_vey.y + this.val[8] * Matrix4.l_vey.z;
        float m02 = this.val[0] * -Matrix4.l_vez.x + this.val[4] * -Matrix4.l_vez.y + this.val[8] * -Matrix4.l_vez.z;
        float m10 = this.val[1] * Matrix4.l_vex.x + this.val[5] * Matrix4.l_vex.y + this.val[9] * Matrix4.l_vex.z;
        float m11 = this.val[1] * Matrix4.l_vey.x + this.val[5] * Matrix4.l_vey.y + this.val[9] * Matrix4.l_vey.z;
        float m12 = this.val[1] * -Matrix4.l_vez.x + this.val[5] * -Matrix4.l_vez.y + this.val[9] * -Matrix4.l_vez.z;
        float m20 = this.val[2] * Matrix4.l_vex.x + this.val[6] * Matrix4.l_vex.y + this.val[10] * Matrix4.l_vex.z;
        float m21 = this.val[2] * Matrix4.l_vey.x + this.val[6] * Matrix4.l_vey.y + this.val[10] * Matrix4.l_vey.z;
        float m22 = this.val[2] * -Matrix4.l_vez.x + this.val[6] * -Matrix4.l_vez.y + this.val[10] * -Matrix4.l_vez.z;
        float m30 = this.val[3] * Matrix4.l_vex.x + this.val[7] * Matrix4.l_vex.y + this.val[11] * Matrix4.l_vex.z;
        float m31 = this.val[3] * Matrix4.l_vey.x + this.val[7] * Matrix4.l_vey.y + this.val[11] * Matrix4.l_vey.z;
        float m32 = this.val[3] * -Matrix4.l_vez.x + this.val[7] * -Matrix4.l_vez.y + this.val[11] * -Matrix4.l_vez.z;
        this.val[0] = m00;
        this.val[1] = m10;
        this.val[2] = m20;
        this.val[3] = m30;
        this.val[4] = m01;
        this.val[5] = m11;
        this.val[6] = m21;
        this.val[7] = m31;
        this.val[8] = m02;
        this.val[9] = m12;
        this.val[10] = m22;
        this.val[11] = m32;
        return this;
    }

    public Matrix4 rotateTowardTarget(Vector3 target, Vector3 up) {
        tmpVec.set(target.x - this.val[12], target.y - this.val[13], target.z - this.val[14]);
        return this.rotateTowardDirection(tmpVec, up);
    }

    public Matrix4 scale(float scaleX, float scaleY, float scaleZ) {
        this.val[0] = this.val[0] * scaleX;
        this.val[4] = this.val[4] * scaleY;
        this.val[8] = this.val[8] * scaleZ;
        this.val[1] = this.val[1] * scaleX;
        this.val[5] = this.val[5] * scaleY;
        this.val[9] = this.val[9] * scaleZ;
        this.val[2] = this.val[2] * scaleX;
        this.val[6] = this.val[6] * scaleY;
        this.val[10] = this.val[10] * scaleZ;
        this.val[3] = this.val[3] * scaleX;
        this.val[7] = this.val[7] * scaleY;
        this.val[11] = this.val[11] * scaleZ;
        return this;
    }

    public void extract4x3Matrix(float[] dst) {
        dst[0] = this.val[0];
        dst[1] = this.val[1];
        dst[2] = this.val[2];
        dst[3] = this.val[4];
        dst[4] = this.val[5];
        dst[5] = this.val[6];
        dst[6] = this.val[8];
        dst[7] = this.val[9];
        dst[8] = this.val[10];
        dst[9] = this.val[12];
        dst[10] = this.val[13];
        dst[11] = this.val[14];
    }

    public boolean hasRotationOrScaling() {
        return !MathUtils.isEqual(this.val[0], 1.0f) || !MathUtils.isEqual(this.val[5], 1.0f) || !MathUtils.isEqual(this.val[10], 1.0f) || !MathUtils.isZero(this.val[4]) || !MathUtils.isZero(this.val[8]) || !MathUtils.isZero(this.val[1]) || !MathUtils.isZero(this.val[9]) || !MathUtils.isZero(this.val[2]) || !MathUtils.isZero(this.val[6]);
    }
}

