/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.CheckIntrinsics;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.CustomBuffer;

public final class Checks {
    public static final boolean CHECKS = Configuration.DISABLE_CHECKS.get(false) == false;
    public static final boolean DEBUG = Configuration.DEBUG.get(false);
    public static final boolean DEBUG_FUNCTIONS = Configuration.DEBUG_FUNCTIONS.get(false);

    private Checks() {
    }

    public static int lengthSafe(@Nullable short[] array) {
        return array == null ? 0 : array.length;
    }

    public static int lengthSafe(@Nullable int[] array) {
        return array == null ? 0 : array.length;
    }

    public static int lengthSafe(@Nullable long[] array) {
        return array == null ? 0 : array.length;
    }

    public static int lengthSafe(@Nullable float[] array) {
        return array == null ? 0 : array.length;
    }

    public static int lengthSafe(@Nullable double[] array) {
        return array == null ? 0 : array.length;
    }

    public static int remainingSafe(@Nullable Buffer buffer) {
        return buffer == null ? 0 : buffer.remaining();
    }

    public static int remainingSafe(@Nullable CustomBuffer<?> buffer) {
        return buffer == null ? 0 : buffer.remaining();
    }

    public static boolean checkFunctions(long ... functions) {
        for (long pointer : functions) {
            if (pointer != 0L) continue;
            return false;
        }
        return true;
    }

    public static long check(long pointer) {
        if (pointer == 0L) {
            throw new NullPointerException();
        }
        return pointer;
    }

    private static void assertNT(boolean found) {
        if (!found) {
            throw new IllegalArgumentException("Missing termination");
        }
    }

    public static void checkNT(int[] buf) {
        Checks.checkBuffer(buf.length, 1);
        Checks.assertNT(buf[buf.length - 1] == 0);
    }

    public static void checkNT(int[] buf, int terminator) {
        Checks.checkBuffer(buf.length, 1);
        Checks.assertNT(buf[buf.length - 1] == terminator);
    }

    public static void checkNT(long[] buf) {
        Checks.checkBuffer(buf.length, 1);
        Checks.assertNT(buf[buf.length - 1] == 0L);
    }

    public static void checkNT(float[] buf) {
        Checks.checkBuffer(buf.length, 1);
        Checks.assertNT(buf[buf.length - 1] == 0.0f);
    }

    public static void checkNT1(ByteBuffer buf) {
        Checks.checkBuffer(buf.remaining(), 1);
        Checks.assertNT(buf.get(buf.limit() - 1) == 0);
    }

    public static void checkNT2(ByteBuffer buf) {
        Checks.checkBuffer(buf.remaining(), 2);
        Checks.assertNT(buf.get(buf.limit() - 2) == 0);
    }

    public static void checkNT(IntBuffer buf) {
        Checks.checkBuffer(buf.remaining(), 1);
        Checks.assertNT(buf.get(buf.limit() - 1) == 0);
    }

    public static void checkNT(IntBuffer buf, int terminator) {
        Checks.checkBuffer(buf.remaining(), 1);
        Checks.assertNT(buf.get(buf.limit() - 1) == terminator);
    }

    public static void checkNT(LongBuffer buf) {
        Checks.checkBuffer(buf.remaining(), 1);
        Checks.assertNT(buf.get(buf.limit() - 1) == 0L);
    }

    public static void checkNT(FloatBuffer buf) {
        Checks.checkBuffer(buf.remaining(), 1);
        Checks.assertNT(buf.get(buf.limit() - 1) == 0.0f);
    }

    public static void checkNT(PointerBuffer buf) {
        Checks.checkBuffer(buf.remaining(), 1);
        Checks.assertNT(buf.get(buf.limit() - 1) == 0L);
    }

    public static void checkNT(PointerBuffer buf, long terminator) {
        Checks.checkBuffer(buf.remaining(), 1);
        Checks.assertNT(buf.get(buf.limit() - 1) == terminator);
    }

    public static void checkNTSafe(@Nullable int[] buf) {
        if (buf != null) {
            Checks.checkBuffer(buf.length, 1);
            Checks.assertNT(buf[buf.length - 1] == 0);
        }
    }

    public static void checkNTSafe(@Nullable int[] buf, int terminator) {
        if (buf != null) {
            Checks.checkBuffer(buf.length, 1);
            Checks.assertNT(buf[buf.length - 1] == terminator);
        }
    }

    public static void checkNTSafe(@Nullable long[] buf) {
        if (buf != null) {
            Checks.checkBuffer(buf.length, 1);
            Checks.assertNT(buf[buf.length - 1] == 0L);
        }
    }

    public static void checkNTSafe(@Nullable float[] buf) {
        if (buf != null) {
            Checks.checkBuffer(buf.length, 1);
            Checks.assertNT(buf[buf.length - 1] == 0.0f);
        }
    }

    public static void checkNT1Safe(@Nullable ByteBuffer buf) {
        if (buf != null) {
            Checks.checkBuffer(buf.remaining(), 1);
            Checks.assertNT(buf.get(buf.limit() - 1) == 0);
        }
    }

    public static void checkNT2Safe(@Nullable ByteBuffer buf) {
        if (buf != null) {
            Checks.checkBuffer(buf.remaining(), 2);
            Checks.assertNT(buf.get(buf.limit() - 2) == 0);
        }
    }

    public static void checkNTSafe(@Nullable IntBuffer buf) {
        if (buf != null) {
            Checks.checkBuffer(buf.remaining(), 1);
            Checks.assertNT(buf.get(buf.limit() - 1) == 0);
        }
    }

    public static void checkNTSafe(@Nullable IntBuffer buf, int terminator) {
        if (buf != null) {
            Checks.checkBuffer(buf.remaining(), 1);
            Checks.assertNT(buf.get(buf.limit() - 1) == terminator);
        }
    }

    public static void checkNTSafe(@Nullable LongBuffer buf) {
        if (buf != null) {
            Checks.checkBuffer(buf.remaining(), 1);
            Checks.assertNT(buf.get(buf.limit() - 1) == 0L);
        }
    }

    public static void checkNTSafe(@Nullable FloatBuffer buf) {
        if (buf != null) {
            Checks.checkBuffer(buf.remaining(), 1);
            Checks.assertNT(buf.get(buf.limit() - 1) == 0.0f);
        }
    }

    public static void checkNTSafe(@Nullable PointerBuffer buf) {
        if (buf != null) {
            Checks.checkBuffer(buf.remaining(), 1);
            Checks.assertNT(buf.get(buf.limit() - 1) == 0L);
        }
    }

    public static void checkNTSafe(@Nullable PointerBuffer buf, long terminator) {
        if (buf != null) {
            Checks.checkBuffer(buf.remaining(), 1);
            Checks.assertNT(buf.get(buf.limit() - 1) == terminator);
        }
    }

    private static void checkBuffer(int bufferSize, int minimumSize) {
        if (bufferSize < minimumSize) {
            Checks.throwIAE(bufferSize, minimumSize);
        }
    }

    public static void check(byte[] buf, int size) {
        Checks.checkBuffer(buf.length, size);
    }

    public static void check(short[] buf, int size) {
        Checks.checkBuffer(buf.length, size);
    }

    public static void check(int[] buf, int size) {
        Checks.checkBuffer(buf.length, size);
    }

    public static void check(long[] buf, int size) {
        Checks.checkBuffer(buf.length, size);
    }

    public static void check(float[] buf, int size) {
        Checks.checkBuffer(buf.length, size);
    }

    public static void check(double[] buf, int size) {
        Checks.checkBuffer(buf.length, size);
    }

    public static void check(CharSequence text, int size) {
        Checks.checkBuffer(text.length(), size);
    }

    public static void check(Buffer buf, int size) {
        Checks.checkBuffer(buf.remaining(), size);
    }

    public static void check(Buffer buf, long size) {
        Checks.checkBuffer(buf.remaining(), (int)size);
    }

    public static void check(CustomBuffer<?> buf, int size) {
        Checks.checkBuffer(buf.remaining(), size);
    }

    public static void check(CustomBuffer<?> buf, long size) {
        Checks.checkBuffer(buf.remaining(), (int)size);
    }

    public static void checkSafe(@Nullable short[] buf, int size) {
        if (buf != null) {
            Checks.checkBuffer(buf.length, size);
        }
    }

    public static void checkSafe(@Nullable int[] buf, int size) {
        if (buf != null) {
            Checks.checkBuffer(buf.length, size);
        }
    }

    public static void checkSafe(@Nullable long[] buf, int size) {
        if (buf != null) {
            Checks.checkBuffer(buf.length, size);
        }
    }

    public static void checkSafe(@Nullable float[] buf, int size) {
        if (buf != null) {
            Checks.checkBuffer(buf.length, size);
        }
    }

    public static void checkSafe(@Nullable double[] buf, int size) {
        if (buf != null) {
            Checks.checkBuffer(buf.length, size);
        }
    }

    public static void checkSafe(@Nullable Buffer buf, int size) {
        if (buf != null) {
            Checks.checkBuffer(buf.remaining(), size);
        }
    }

    public static void checkSafe(@Nullable Buffer buf, long size) {
        if (buf != null) {
            Checks.checkBuffer(buf.remaining(), (int)size);
        }
    }

    public static void checkSafe(@Nullable CustomBuffer<?> buf, int size) {
        if (buf != null) {
            Checks.checkBuffer(buf.remaining(), size);
        }
    }

    public static void checkSafe(@Nullable CustomBuffer<?> buf, long size) {
        if (buf != null) {
            Checks.checkBuffer(buf.remaining(), (int)size);
        }
    }

    public static void check(Object[] array, int size) {
        Checks.checkBuffer(array.length, size);
    }

    private static void checkBufferGT(int bufferSize, int maximumSize) {
        if (maximumSize < bufferSize) {
            Checks.throwIAEGT(bufferSize, maximumSize);
        }
    }

    public static void checkGT(Buffer buf, int size) {
        Checks.checkBufferGT(buf.remaining(), size);
    }

    public static void checkGT(CustomBuffer<?> buf, int size) {
        Checks.checkBufferGT(buf.remaining(), size);
    }

    public static long check(int index, int length) {
        if (CHECKS) {
            CheckIntrinsics.checkIndex(index, length);
        }
        return Integer.toUnsignedLong(index);
    }

    private static void throwIAE(int bufferSize, int minimumSize) {
        throw new IllegalArgumentException("Number of remaining elements is " + bufferSize + ", must be at least " + minimumSize);
    }

    private static void throwIAEGT(int bufferSize, int maximumSize) {
        throw new IllegalArgumentException("Number of remaining buffer elements is " + bufferSize + ", must be at most " + maximumSize);
    }

    static {
        if (DEBUG_FUNCTIONS && !DEBUG) {
            APIUtil.DEBUG_STREAM.println("[LWJGL] The DEBUG_FUNCTIONS option requires DEBUG to produce output.");
        }
    }
}

