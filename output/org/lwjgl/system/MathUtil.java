/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

public final class MathUtil {
    private MathUtil() {
    }

    public static boolean mathIsPoT(int value) {
        return Integer.bitCount(value) == 1;
    }

    public static int mathRoundPoT(int value) {
        return 1 << 32 - Integer.numberOfLeadingZeros(value - 1);
    }

    public static boolean mathHasZeroByte(int value) {
        return (value - 0x1010101 & ~value & 0x80808080) != 0;
    }

    public static boolean mathHasZeroByte(long value) {
        return (value - 0x101010101010101L & (value ^ 0xFFFFFFFFFFFFFFFFL) & 0x8080808080808080L) != 0L;
    }

    public static boolean mathHasZeroShort(int value) {
        return (value & 0xFFFF) == 0 || value >>> 16 == 0;
    }

    public static boolean mathHasZeroShort(long value) {
        return (value - 0x1000100010001L & (value ^ 0xFFFFFFFFFFFFFFFFL) & 0x8000800080008000L) != 0L;
    }

    public static long mathMultiplyHighU64(long x, long y) {
        long x0 = x & 0xFFFFFFFFL;
        long x1 = x >>> 32;
        long y0 = y & 0xFFFFFFFFL;
        long y1 = y >>> 32;
        long t = x1 * y0 + (x0 * y0 >>> 32);
        return x1 * y1 + (t >>> 32) + ((t & 0xFFFFFFFFL) + x0 * y1 >>> 32);
    }

    public static long mathMultiplyHighS64(long x, long y) {
        long x0 = x & 0xFFFFFFFFL;
        long x1 = x >> 32;
        long y0 = y & 0xFFFFFFFFL;
        long y1 = y >> 32;
        long t = x1 * y0 + (x0 * y0 >>> 32);
        return x1 * y1 + (t >> 32) + ((t & 0xFFFFFFFFL) + x0 * y1 >> 32);
    }

    public static long mathDivideUnsigned(long dividend, long divisor) {
        if (0L <= divisor) {
            return 0L <= dividend ? dividend / divisor : MathUtil.udivdi3(dividend, divisor);
        }
        return Long.compareUnsigned(dividend, divisor) < 0 ? 0L : 1L;
    }

    public static long mathRemainderUnsigned(long dividend, long divisor) {
        if (0L < dividend && 0L < divisor) {
            return dividend % divisor;
        }
        return Long.compareUnsigned(dividend, divisor) < 0 ? dividend : dividend - divisor * MathUtil.udivdi3(dividend, divisor);
    }

    private static long udivdi3(long u, long v) {
        if (v >>> 32 == 0L) {
            if (u >>> 32 < v) {
                long q0 = (u >>> 1) / v << Long.numberOfLeadingZeros(v) >>> 31;
                if (u - q0 * v >= v) {
                    ++q0;
                }
                return q0;
            }
            long u1 = u >>> 32;
            long q1 = u1 / v;
            long q0 = (u1 - q1 * v << 32 | u & 0xFFFFFFFFL) / v;
            return q1 << 32 | q0;
        }
        int n = Long.numberOfLeadingZeros(v);
        long q0 = (u >>> 1) / (v << n >>> 32) << n >>> 31;
        if (q0 != 0L) {
            --q0;
        }
        if (Long.compareUnsigned(u - q0 * v, v) >= 0) {
            ++q0;
        }
        return q0;
    }
}

