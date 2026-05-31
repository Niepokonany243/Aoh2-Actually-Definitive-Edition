/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.libc;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class LibCString {
    protected LibCString() {
        throw new UnsupportedOperationException();
    }

    public static native long nmemset(long var0, int var2, long var3);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") ByteBuffer dest, int c) {
        return LibCString.nmemset(MemoryUtil.memAddress(dest), c, (long)dest.remaining());
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") ShortBuffer dest, int c) {
        return LibCString.nmemset(MemoryUtil.memAddress(dest), c, Integer.toUnsignedLong(dest.remaining()) << 1);
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") IntBuffer dest, int c) {
        return LibCString.nmemset(MemoryUtil.memAddress(dest), c, Integer.toUnsignedLong(dest.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") LongBuffer dest, int c) {
        return LibCString.nmemset(MemoryUtil.memAddress(dest), c, Integer.toUnsignedLong(dest.remaining()) << 3);
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") FloatBuffer dest, int c) {
        return LibCString.nmemset(MemoryUtil.memAddress(dest), c, Integer.toUnsignedLong(dest.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") DoubleBuffer dest, int c) {
        return LibCString.nmemset(MemoryUtil.memAddress(dest), c, Integer.toUnsignedLong(dest.remaining()) << 3);
    }

    public static native long nmemcpy(long var0, long var2, long var4);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") ByteBuffer dest, @NativeType(value="void const *") ByteBuffer src) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, src.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), (long)src.remaining());
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") ShortBuffer dest, @NativeType(value="void const *") ShortBuffer src) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, src.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 1);
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") IntBuffer dest, @NativeType(value="void const *") IntBuffer src) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, src.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") LongBuffer dest, @NativeType(value="void const *") LongBuffer src) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, src.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 3);
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") FloatBuffer dest, @NativeType(value="void const *") FloatBuffer src) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, src.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") DoubleBuffer dest, @NativeType(value="void const *") DoubleBuffer src) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, src.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 3);
    }

    public static native long nmemmove(long var0, long var2, long var4);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") ByteBuffer dest, @NativeType(value="void const *") ByteBuffer src) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, src.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), (long)src.remaining());
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") ShortBuffer dest, @NativeType(value="void const *") ShortBuffer src) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, src.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 1);
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") IntBuffer dest, @NativeType(value="void const *") IntBuffer src) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, src.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") LongBuffer dest, @NativeType(value="void const *") LongBuffer src) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, src.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 3);
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") FloatBuffer dest, @NativeType(value="void const *") FloatBuffer src) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, src.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") DoubleBuffer dest, @NativeType(value="void const *") DoubleBuffer src) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, src.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), Integer.toUnsignedLong(src.remaining()) << 3);
    }

    public static native long nmemset(byte[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") byte[] dest, int c) {
        return LibCString.nmemset(dest, c, Integer.toUnsignedLong(dest.length) << 0);
    }

    public static native long nmemset(short[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") short[] dest, int c) {
        return LibCString.nmemset(dest, c, Integer.toUnsignedLong(dest.length) << 1);
    }

    public static native long nmemset(int[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") int[] dest, int c) {
        return LibCString.nmemset(dest, c, Integer.toUnsignedLong(dest.length) << 2);
    }

    public static native long nmemset(long[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") long[] dest, int c) {
        return LibCString.nmemset(dest, c, Integer.toUnsignedLong(dest.length) << 3);
    }

    public static native long nmemset(float[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") float[] dest, int c) {
        return LibCString.nmemset(dest, c, Integer.toUnsignedLong(dest.length) << 2);
    }

    public static native long nmemset(double[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") double[] dest, int c) {
        return LibCString.nmemset(dest, c, Integer.toUnsignedLong(dest.length) << 3);
    }

    public static native long nmemcpy(byte[] var0, byte[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") byte[] dest, @NativeType(value="void const *") byte[] src) {
        if (Checks.CHECKS) {
            Checks.check(dest, src.length);
        }
        return LibCString.nmemcpy(dest, src, Integer.toUnsignedLong(src.length) << 0);
    }

    public static native long nmemcpy(short[] var0, short[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") short[] dest, @NativeType(value="void const *") short[] src) {
        if (Checks.CHECKS) {
            Checks.check(dest, src.length);
        }
        return LibCString.nmemcpy(dest, src, Integer.toUnsignedLong(src.length) << 1);
    }

    public static native long nmemcpy(int[] var0, int[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") int[] dest, @NativeType(value="void const *") int[] src) {
        if (Checks.CHECKS) {
            Checks.check(dest, src.length);
        }
        return LibCString.nmemcpy(dest, src, Integer.toUnsignedLong(src.length) << 2);
    }

    public static native long nmemcpy(long[] var0, long[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") long[] dest, @NativeType(value="void const *") long[] src) {
        if (Checks.CHECKS) {
            Checks.check(dest, src.length);
        }
        return LibCString.nmemcpy(dest, src, Integer.toUnsignedLong(src.length) << 3);
    }

    public static native long nmemcpy(float[] var0, float[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") float[] dest, @NativeType(value="void const *") float[] src) {
        if (Checks.CHECKS) {
            Checks.check(dest, src.length);
        }
        return LibCString.nmemcpy(dest, src, Integer.toUnsignedLong(src.length) << 2);
    }

    public static native long nmemcpy(double[] var0, double[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") double[] dest, @NativeType(value="void const *") double[] src) {
        if (Checks.CHECKS) {
            Checks.check(dest, src.length);
        }
        return LibCString.nmemcpy(dest, src, Integer.toUnsignedLong(src.length) << 3);
    }

    public static native long nmemmove(byte[] var0, byte[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") byte[] dest, @NativeType(value="void const *") byte[] src) {
        if (Checks.CHECKS) {
            Checks.check(dest, src.length);
        }
        return LibCString.nmemmove(dest, src, Integer.toUnsignedLong(src.length) << 0);
    }

    public static native long nmemmove(short[] var0, short[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") short[] dest, @NativeType(value="void const *") short[] src) {
        if (Checks.CHECKS) {
            Checks.check(dest, src.length);
        }
        return LibCString.nmemmove(dest, src, Integer.toUnsignedLong(src.length) << 1);
    }

    public static native long nmemmove(int[] var0, int[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") int[] dest, @NativeType(value="void const *") int[] src) {
        if (Checks.CHECKS) {
            Checks.check(dest, src.length);
        }
        return LibCString.nmemmove(dest, src, Integer.toUnsignedLong(src.length) << 2);
    }

    public static native long nmemmove(long[] var0, long[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") long[] dest, @NativeType(value="void const *") long[] src) {
        if (Checks.CHECKS) {
            Checks.check(dest, src.length);
        }
        return LibCString.nmemmove(dest, src, Integer.toUnsignedLong(src.length) << 3);
    }

    public static native long nmemmove(float[] var0, float[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") float[] dest, @NativeType(value="void const *") float[] src) {
        if (Checks.CHECKS) {
            Checks.check(dest, src.length);
        }
        return LibCString.nmemmove(dest, src, Integer.toUnsignedLong(src.length) << 2);
    }

    public static native long nmemmove(double[] var0, double[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") double[] dest, @NativeType(value="void const *") double[] src) {
        if (Checks.CHECKS) {
            Checks.check(dest, src.length);
        }
        return LibCString.nmemmove(dest, src, Integer.toUnsignedLong(src.length) << 3);
    }

    @NativeType(value="void *")
    public static <T extends CustomBuffer<T>> long memset(@NativeType(value="void *") T dest, @NativeType(value="int") int c) {
        return LibCString.nmemset(MemoryUtil.memAddress(dest), c, Integer.toUnsignedLong(dest.remaining()) * (long)dest.sizeof());
    }

    @NativeType(value="void *")
    public static <T extends CustomBuffer<T>> long memcpy(@NativeType(value="void *") T dest, @NativeType(value="void const *") T src) {
        if (Checks.CHECKS) {
            Checks.check(src, dest.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), (long)src.remaining() * (long)src.sizeof());
    }

    @NativeType(value="void *")
    public static <T extends CustomBuffer<T>> long memmove(@NativeType(value="void *") T dest, @NativeType(value="void const *") T src) {
        if (Checks.CHECKS) {
            Checks.check(src, dest.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(dest), MemoryUtil.memAddress(src), (long)src.remaining() * (long)src.sizeof());
    }

    static {
        Library.initialize();
    }
}

