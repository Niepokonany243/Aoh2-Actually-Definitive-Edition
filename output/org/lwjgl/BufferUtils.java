/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.CLongBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryUtil;

public final class BufferUtils {
    private BufferUtils() {
    }

    public static ByteBuffer createByteBuffer(int capacity) {
        return ByteBuffer.allocateDirect(capacity).order(ByteOrder.nativeOrder());
    }

    static int getAllocationSize(int elements, int elementShift) {
        APIUtil.apiCheckAllocation(elements, APIUtil.apiGetBytes(elements, elementShift), Integer.MAX_VALUE);
        return elements << elementShift;
    }

    public static ShortBuffer createShortBuffer(int capacity) {
        return BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(capacity, 1)).asShortBuffer();
    }

    public static CharBuffer createCharBuffer(int capacity) {
        return BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(capacity, 1)).asCharBuffer();
    }

    public static IntBuffer createIntBuffer(int capacity) {
        return BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(capacity, 2)).asIntBuffer();
    }

    public static LongBuffer createLongBuffer(int capacity) {
        return BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(capacity, 3)).asLongBuffer();
    }

    public static CLongBuffer createCLongBuffer(int capacity) {
        return CLongBuffer.allocateDirect(capacity);
    }

    public static FloatBuffer createFloatBuffer(int capacity) {
        return BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(capacity, 2)).asFloatBuffer();
    }

    public static DoubleBuffer createDoubleBuffer(int capacity) {
        return BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(capacity, 3)).asDoubleBuffer();
    }

    public static PointerBuffer createPointerBuffer(int capacity) {
        return PointerBuffer.allocateDirect(capacity);
    }

    public static void zeroBuffer(ByteBuffer buffer) {
        MemoryUtil.memSet(buffer, 0);
    }

    public static void zeroBuffer(ShortBuffer buffer) {
        MemoryUtil.memSet(buffer, 0);
    }

    public static void zeroBuffer(CharBuffer buffer) {
        MemoryUtil.memSet(buffer, 0);
    }

    public static void zeroBuffer(IntBuffer buffer) {
        MemoryUtil.memSet(buffer, 0);
    }

    public static void zeroBuffer(FloatBuffer buffer) {
        MemoryUtil.memSet(buffer, 0);
    }

    public static void zeroBuffer(LongBuffer buffer) {
        MemoryUtil.memSet(buffer, 0);
    }

    public static void zeroBuffer(DoubleBuffer buffer) {
        MemoryUtil.memSet(buffer, 0);
    }

    public static <T extends CustomBuffer<T>> void zeroBuffer(T buffer) {
        MemoryUtil.memSet(buffer, 0);
    }
}

