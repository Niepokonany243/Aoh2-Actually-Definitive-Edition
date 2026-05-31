/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.annotation.Nullable;
import org.lwjgl.CLongBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.Library;
import org.lwjgl.system.MathUtil;
import org.lwjgl.system.MemoryManage;
import org.lwjgl.system.MultiReleaseMemCopy;
import org.lwjgl.system.MultiReleaseTextDecoding;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.Struct;
import org.lwjgl.system.jni.JNINativeInterface;
import org.lwjgl.system.libc.LibCString;
import sun.misc.Unsafe;

public final class MemoryUtil {
    public static final long NULL = 0L;
    public static final int PAGE_SIZE;
    public static final int CACHE_LINE_SIZE;
    static final int ARRAY_TLC_SIZE;
    static final ThreadLocal<byte[]> ARRAY_TLC_BYTE;
    static final ThreadLocal<char[]> ARRAY_TLC_CHAR;
    static final Unsafe UNSAFE;
    static final ByteOrder NATIVE_ORDER;
    private static final Charset UTF16;
    static final Class<? extends ByteBuffer> BUFFER_BYTE;
    static final Class<? extends ShortBuffer> BUFFER_SHORT;
    static final Class<? extends CharBuffer> BUFFER_CHAR;
    static final Class<? extends IntBuffer> BUFFER_INT;
    static final Class<? extends LongBuffer> BUFFER_LONG;
    static final Class<? extends FloatBuffer> BUFFER_FLOAT;
    static final Class<? extends DoubleBuffer> BUFFER_DOUBLE;
    private static final long MARK;
    private static final long POSITION;
    private static final long LIMIT;
    private static final long CAPACITY;
    private static final long ADDRESS;
    private static final long PARENT_BYTE;
    private static final long PARENT_SHORT;
    private static final long PARENT_CHAR;
    private static final long PARENT_INT;
    private static final long PARENT_LONG;
    private static final long PARENT_FLOAT;
    private static final long PARENT_DOUBLE;
    private static final NativeShift SHIFT;
    private static final long FILL_PATTERN;
    private static final int MAGIC_CAPACITY = 219540062;
    private static final int MAGIC_POSITION = 16435934;

    private MemoryUtil() {
    }

    public static MemoryAllocator getAllocator() {
        return MemoryUtil.getAllocator(false);
    }

    public static MemoryAllocator getAllocator(boolean tracked) {
        return tracked ? LazyInit.ALLOCATOR : LazyInit.ALLOCATOR_IMPL;
    }

    public static long nmemAlloc(long size) {
        return LazyInit.ALLOCATOR.malloc(size);
    }

    public static long nmemAllocChecked(long size) {
        long address = MemoryUtil.nmemAlloc(size != 0L ? size : 1L);
        if (Checks.CHECKS && address == 0L) {
            throw new OutOfMemoryError();
        }
        return address;
    }

    private static long getAllocationSize(int elements, int elementShift) {
        return APIUtil.apiCheckAllocation(elements, Integer.toUnsignedLong(elements) << elementShift, Pointer.BITS64 ? Long.MAX_VALUE : 0xFFFFFFFFL);
    }

    public static ByteBuffer memAlloc(int size) {
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.nmemAllocChecked(size), size).order(NATIVE_ORDER);
    }

    public static ShortBuffer memAllocShort(int size) {
        return MemoryUtil.wrap(BUFFER_SHORT, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(size, 1)), size);
    }

    public static IntBuffer memAllocInt(int size) {
        return MemoryUtil.wrap(BUFFER_INT, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(size, 2)), size);
    }

    public static FloatBuffer memAllocFloat(int size) {
        return MemoryUtil.wrap(BUFFER_FLOAT, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(size, 2)), size);
    }

    public static LongBuffer memAllocLong(int size) {
        return MemoryUtil.wrap(BUFFER_LONG, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(size, 3)), size);
    }

    public static CLongBuffer memAllocCLong(int size) {
        return Pointer.Default.wrap(CLongBuffer.class, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(size, Pointer.CLONG_SHIFT)), size);
    }

    public static DoubleBuffer memAllocDouble(int size) {
        return MemoryUtil.wrap(BUFFER_DOUBLE, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(size, 3)), size);
    }

    public static PointerBuffer memAllocPointer(int size) {
        return Pointer.Default.wrap(PointerBuffer.class, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(size, Pointer.POINTER_SHIFT)), size);
    }

    public static void nmemFree(long ptr) {
        LazyInit.ALLOCATOR.free(ptr);
    }

    public static void memFree(@Nullable Buffer ptr) {
        if (ptr != null) {
            MemoryUtil.nmemFree(UNSAFE.getLong(ptr, ADDRESS));
        }
    }

    public static void memFree(@Nullable CustomBuffer ptr) {
        if (ptr != null) {
            MemoryUtil.nmemFree(ptr.address);
        }
    }

    public static long nmemCalloc(long num, long size) {
        return LazyInit.ALLOCATOR.calloc(num, size);
    }

    public static long nmemCallocChecked(long num, long size) {
        if (num == 0L || size == 0L) {
            num = 1L;
            size = 1L;
        }
        long address = MemoryUtil.nmemCalloc(num, size);
        if (Checks.CHECKS && address == 0L) {
            throw new OutOfMemoryError();
        }
        return address;
    }

    public static ByteBuffer memCalloc(int num, int size) {
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.nmemCallocChecked(num, size), num * size).order(NATIVE_ORDER);
    }

    public static ByteBuffer memCalloc(int num) {
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.nmemCallocChecked(num, 1L), num).order(NATIVE_ORDER);
    }

    public static ShortBuffer memCallocShort(int num) {
        return MemoryUtil.wrap(BUFFER_SHORT, MemoryUtil.nmemCallocChecked(num, 2L), num);
    }

    public static IntBuffer memCallocInt(int num) {
        return MemoryUtil.wrap(BUFFER_INT, MemoryUtil.nmemCallocChecked(num, 4L), num);
    }

    public static FloatBuffer memCallocFloat(int num) {
        return MemoryUtil.wrap(BUFFER_FLOAT, MemoryUtil.nmemCallocChecked(num, 4L), num);
    }

    public static LongBuffer memCallocLong(int num) {
        return MemoryUtil.wrap(BUFFER_LONG, MemoryUtil.nmemCallocChecked(num, 8L), num);
    }

    public static CLongBuffer memCallocCLong(int num) {
        return Pointer.Default.wrap(CLongBuffer.class, MemoryUtil.nmemCallocChecked(num, Pointer.CLONG_SIZE), num);
    }

    public static DoubleBuffer memCallocDouble(int num) {
        return MemoryUtil.wrap(BUFFER_DOUBLE, MemoryUtil.nmemCallocChecked(num, 8L), num);
    }

    public static PointerBuffer memCallocPointer(int num) {
        return Pointer.Default.wrap(PointerBuffer.class, MemoryUtil.nmemCallocChecked(num, Pointer.POINTER_SIZE), num);
    }

    public static long nmemRealloc(long ptr, long size) {
        return LazyInit.ALLOCATOR.realloc(ptr, size);
    }

    public static long nmemReallocChecked(long ptr, long size) {
        long address = MemoryUtil.nmemRealloc(ptr, size != 0L ? size : 1L);
        if (Checks.CHECKS && address == 0L) {
            throw new OutOfMemoryError();
        }
        return address;
    }

    private static <T extends Buffer> T realloc(@Nullable T old_p, T new_p, int size) {
        if (old_p != null) {
            new_p.position(Math.min(old_p.position(), size));
        }
        return new_p;
    }

    public static ByteBuffer memRealloc(@Nullable ByteBuffer ptr, int size) {
        return MemoryUtil.realloc(ptr, MemoryUtil.memByteBuffer(MemoryUtil.nmemReallocChecked(ptr == null ? 0L : UNSAFE.getLong(ptr, ADDRESS), size), size), size);
    }

    public static ShortBuffer memRealloc(@Nullable ShortBuffer ptr, int size) {
        return MemoryUtil.realloc(ptr, MemoryUtil.memShortBuffer(MemoryUtil.nmemReallocChecked(ptr == null ? 0L : UNSAFE.getLong(ptr, ADDRESS), MemoryUtil.getAllocationSize(size, 1)), size), size);
    }

    public static IntBuffer memRealloc(@Nullable IntBuffer ptr, int size) {
        return MemoryUtil.realloc(ptr, MemoryUtil.memIntBuffer(MemoryUtil.nmemReallocChecked(ptr == null ? 0L : UNSAFE.getLong(ptr, ADDRESS), MemoryUtil.getAllocationSize(size, 2)), size), size);
    }

    public static LongBuffer memRealloc(@Nullable LongBuffer ptr, int size) {
        return MemoryUtil.realloc(ptr, MemoryUtil.memLongBuffer(MemoryUtil.nmemReallocChecked(ptr == null ? 0L : UNSAFE.getLong(ptr, ADDRESS), MemoryUtil.getAllocationSize(size, 3)), size), size);
    }

    public static CLongBuffer memRealloc(@Nullable CLongBuffer ptr, int size) {
        CLongBuffer buffer = MemoryUtil.memCLongBuffer(MemoryUtil.nmemReallocChecked(ptr == null ? 0L : ptr.address, MemoryUtil.getAllocationSize(size, Pointer.CLONG_SIZE)), size);
        if (ptr != null) {
            buffer.position(Math.min(ptr.position(), size));
        }
        return buffer;
    }

    public static FloatBuffer memRealloc(@Nullable FloatBuffer ptr, int size) {
        return MemoryUtil.realloc(ptr, MemoryUtil.memFloatBuffer(MemoryUtil.nmemReallocChecked(ptr == null ? 0L : UNSAFE.getLong(ptr, ADDRESS), MemoryUtil.getAllocationSize(size, 2)), size), size);
    }

    public static DoubleBuffer memRealloc(@Nullable DoubleBuffer ptr, int size) {
        return MemoryUtil.realloc(ptr, MemoryUtil.memDoubleBuffer(MemoryUtil.nmemReallocChecked(ptr == null ? 0L : UNSAFE.getLong(ptr, ADDRESS), MemoryUtil.getAllocationSize(size, 3)), size), size);
    }

    public static PointerBuffer memRealloc(@Nullable PointerBuffer ptr, int size) {
        PointerBuffer buffer = MemoryUtil.memPointerBuffer(MemoryUtil.nmemReallocChecked(ptr == null ? 0L : ptr.address, MemoryUtil.getAllocationSize(size, Pointer.POINTER_SHIFT)), size);
        if (ptr != null) {
            buffer.position(Math.min(ptr.position(), size));
        }
        return buffer;
    }

    public static long nmemAlignedAlloc(long alignment, long size) {
        return LazyInit.ALLOCATOR.aligned_alloc(alignment, size);
    }

    public static long nmemAlignedAllocChecked(long alignment, long size) {
        long address = MemoryUtil.nmemAlignedAlloc(alignment, size != 0L ? size : 1L);
        if (Checks.CHECKS && address == 0L) {
            throw new OutOfMemoryError();
        }
        return address;
    }

    public static ByteBuffer memAlignedAlloc(int alignment, int size) {
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.nmemAlignedAllocChecked(alignment, size), size).order(NATIVE_ORDER);
    }

    public static void nmemAlignedFree(long ptr) {
        LazyInit.ALLOCATOR.aligned_free(ptr);
    }

    public static void memAlignedFree(@Nullable ByteBuffer ptr) {
        if (ptr != null) {
            MemoryUtil.nmemAlignedFree(UNSAFE.getLong(ptr, ADDRESS));
        }
    }

    public static void memReport(MemoryAllocationReport report) {
        MemoryManage.DebugAllocator.report(report);
    }

    public static void memReport(MemoryAllocationReport report, MemoryAllocationReport.Aggregate groupByStackTrace, boolean groupByThread) {
        MemoryManage.DebugAllocator.report(report, groupByStackTrace, groupByThread);
    }

    public static long memAddress0(Buffer buffer) {
        return UNSAFE.getLong(buffer, ADDRESS);
    }

    public static long memAddress(ByteBuffer buffer) {
        return (long)buffer.position() + MemoryUtil.memAddress0(buffer);
    }

    public static long memAddress(ByteBuffer buffer, int position) {
        Objects.requireNonNull(buffer);
        return MemoryUtil.memAddress0(buffer) + Integer.toUnsignedLong(position);
    }

    private static long address(int position, int elementShift, long address) {
        return address + (((long)position & 0xFFFFFFFFL) << elementShift);
    }

    public static long memAddress(ShortBuffer buffer) {
        return MemoryUtil.address(buffer.position(), 1, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddress(ShortBuffer buffer, int position) {
        Objects.requireNonNull(buffer);
        return MemoryUtil.address(position, 1, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddress(CharBuffer buffer) {
        return MemoryUtil.address(buffer.position(), 1, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddress(CharBuffer buffer, int position) {
        Objects.requireNonNull(buffer);
        return MemoryUtil.address(position, 1, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddress(IntBuffer buffer) {
        return MemoryUtil.address(buffer.position(), 2, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddress(IntBuffer buffer, int position) {
        Objects.requireNonNull(buffer);
        return MemoryUtil.address(position, 2, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddress(FloatBuffer buffer) {
        return MemoryUtil.address(buffer.position(), 2, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddress(FloatBuffer buffer, int position) {
        Objects.requireNonNull(buffer);
        return MemoryUtil.address(position, 2, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddress(LongBuffer buffer) {
        return MemoryUtil.address(buffer.position(), 3, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddress(LongBuffer buffer, int position) {
        Objects.requireNonNull(buffer);
        return MemoryUtil.address(position, 3, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddress(DoubleBuffer buffer) {
        return MemoryUtil.address(buffer.position(), 3, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddress(DoubleBuffer buffer, int position) {
        Objects.requireNonNull(buffer);
        return MemoryUtil.address(position, 3, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddress(Buffer buffer) {
        int elementShift = buffer instanceof ByteBuffer ? 0 : (buffer instanceof ShortBuffer || buffer instanceof CharBuffer ? 1 : (buffer instanceof IntBuffer || buffer instanceof FloatBuffer ? 2 : 3));
        return MemoryUtil.address(buffer.position(), elementShift, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddress(CustomBuffer<?> buffer) {
        return buffer.address();
    }

    public static long memAddress(CustomBuffer<?> buffer, int position) {
        return buffer.address(position);
    }

    public static long memAddressSafe(@Nullable ByteBuffer buffer) {
        return buffer == null ? 0L : MemoryUtil.memAddress0(buffer) + (long)buffer.position();
    }

    public static long memAddressSafe(@Nullable ShortBuffer buffer) {
        return buffer == null ? 0L : MemoryUtil.address(buffer.position(), 1, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddressSafe(@Nullable CharBuffer buffer) {
        return buffer == null ? 0L : MemoryUtil.address(buffer.position(), 1, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddressSafe(@Nullable IntBuffer buffer) {
        return buffer == null ? 0L : MemoryUtil.address(buffer.position(), 2, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddressSafe(@Nullable FloatBuffer buffer) {
        return buffer == null ? 0L : MemoryUtil.address(buffer.position(), 2, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddressSafe(@Nullable LongBuffer buffer) {
        return buffer == null ? 0L : MemoryUtil.address(buffer.position(), 3, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddressSafe(@Nullable DoubleBuffer buffer) {
        return buffer == null ? 0L : MemoryUtil.address(buffer.position(), 3, MemoryUtil.memAddress0(buffer));
    }

    public static long memAddressSafe(@Nullable Pointer pointer) {
        return pointer == null ? 0L : pointer.address();
    }

    public static ByteBuffer memByteBuffer(long address, int capacity) {
        if (Checks.CHECKS) {
            Checks.check(address);
        }
        return MemoryUtil.wrap(BUFFER_BYTE, address, capacity).order(NATIVE_ORDER);
    }

    @Nullable
    public static ByteBuffer memByteBufferSafe(long address, int capacity) {
        return address == 0L ? null : MemoryUtil.wrap(BUFFER_BYTE, address, capacity).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(ShortBuffer buffer) {
        if (Checks.CHECKS && 0x3FFFFFFF < buffer.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(buffer), buffer.remaining() << 1).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(CharBuffer buffer) {
        if (Checks.CHECKS && 0x3FFFFFFF < buffer.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(buffer), buffer.remaining() << 1).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(IntBuffer buffer) {
        if (Checks.CHECKS && 0x1FFFFFFF < buffer.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(buffer), buffer.remaining() << 2).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(LongBuffer buffer) {
        if (Checks.CHECKS && 0xFFFFFFF < buffer.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(buffer), buffer.remaining() << 3).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(FloatBuffer buffer) {
        if (Checks.CHECKS && 0x1FFFFFFF < buffer.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(buffer), buffer.remaining() << 2).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(DoubleBuffer buffer) {
        if (Checks.CHECKS && 0xFFFFFFF < buffer.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(buffer), buffer.remaining() << 3).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(CustomBuffer<?> buffer) {
        if (Checks.CHECKS && Integer.MAX_VALUE / buffer.sizeof() < buffer.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(buffer), buffer.remaining() * buffer.sizeof()).order(NATIVE_ORDER);
    }

    public static ShortBuffer memShortBuffer(long address, int capacity) {
        if (Checks.CHECKS) {
            Checks.check(address);
        }
        return MemoryUtil.wrap(BUFFER_SHORT, address, capacity);
    }

    @Nullable
    public static ShortBuffer memShortBufferSafe(long address, int capacity) {
        return address == 0L ? null : MemoryUtil.wrap(BUFFER_SHORT, address, capacity);
    }

    public static CharBuffer memCharBuffer(long address, int capacity) {
        if (Checks.CHECKS) {
            Checks.check(address);
        }
        return MemoryUtil.wrap(BUFFER_CHAR, address, capacity);
    }

    @Nullable
    public static CharBuffer memCharBufferSafe(long address, int capacity) {
        return address == 0L ? null : MemoryUtil.wrap(BUFFER_CHAR, address, capacity);
    }

    public static IntBuffer memIntBuffer(long address, int capacity) {
        if (Checks.CHECKS) {
            Checks.check(address);
        }
        return MemoryUtil.wrap(BUFFER_INT, address, capacity);
    }

    @Nullable
    public static IntBuffer memIntBufferSafe(long address, int capacity) {
        return address == 0L ? null : MemoryUtil.wrap(BUFFER_INT, address, capacity);
    }

    public static LongBuffer memLongBuffer(long address, int capacity) {
        if (Checks.CHECKS) {
            Checks.check(address);
        }
        return MemoryUtil.wrap(BUFFER_LONG, address, capacity);
    }

    @Nullable
    public static LongBuffer memLongBufferSafe(long address, int capacity) {
        return address == 0L ? null : MemoryUtil.wrap(BUFFER_LONG, address, capacity);
    }

    public static CLongBuffer memCLongBuffer(long address, int capacity) {
        if (Checks.CHECKS) {
            Checks.check(address);
        }
        return Pointer.Default.wrap(CLongBuffer.class, address, capacity);
    }

    @Nullable
    public static CLongBuffer memCLongBufferSafe(long address, int capacity) {
        return address == 0L ? null : Pointer.Default.wrap(CLongBuffer.class, address, capacity);
    }

    public static FloatBuffer memFloatBuffer(long address, int capacity) {
        if (Checks.CHECKS) {
            Checks.check(address);
        }
        return MemoryUtil.wrap(BUFFER_FLOAT, address, capacity);
    }

    @Nullable
    public static FloatBuffer memFloatBufferSafe(long address, int capacity) {
        return address == 0L ? null : MemoryUtil.wrap(BUFFER_FLOAT, address, capacity);
    }

    public static DoubleBuffer memDoubleBuffer(long address, int capacity) {
        if (Checks.CHECKS) {
            Checks.check(address);
        }
        return MemoryUtil.wrap(BUFFER_DOUBLE, address, capacity);
    }

    @Nullable
    public static DoubleBuffer memDoubleBufferSafe(long address, int capacity) {
        return address == 0L ? null : MemoryUtil.wrap(BUFFER_DOUBLE, address, capacity);
    }

    public static PointerBuffer memPointerBuffer(long address, int capacity) {
        if (Checks.CHECKS) {
            Checks.check(address);
        }
        return Pointer.Default.wrap(PointerBuffer.class, address, capacity);
    }

    @Nullable
    public static PointerBuffer memPointerBufferSafe(long address, int capacity) {
        return address == 0L ? null : Pointer.Default.wrap(PointerBuffer.class, address, capacity);
    }

    public static ByteBuffer memDuplicate(ByteBuffer buffer) {
        ByteBuffer target;
        try {
            target = (ByteBuffer)UNSAFE.allocateInstance(BUFFER_BYTE);
        }
        catch (InstantiationException e) {
            throw new UnsupportedOperationException(e);
        }
        UNSAFE.putLong(target, ADDRESS, UNSAFE.getLong(buffer, ADDRESS));
        UNSAFE.putInt(target, MARK, UNSAFE.getInt(buffer, MARK));
        UNSAFE.putInt(target, POSITION, UNSAFE.getInt(buffer, POSITION));
        UNSAFE.putInt(target, LIMIT, UNSAFE.getInt(buffer, LIMIT));
        UNSAFE.putInt(target, CAPACITY, UNSAFE.getInt(buffer, CAPACITY));
        Object attachment = UNSAFE.getObject(buffer, PARENT_BYTE);
        UNSAFE.putObject(target, PARENT_BYTE, attachment == null ? buffer : attachment);
        return target.order(buffer.order());
    }

    public static ShortBuffer memDuplicate(ShortBuffer buffer) {
        return MemoryUtil.duplicate(BUFFER_SHORT, buffer, PARENT_SHORT);
    }

    public static CharBuffer memDuplicate(CharBuffer buffer) {
        return MemoryUtil.duplicate(BUFFER_CHAR, buffer, PARENT_CHAR);
    }

    public static IntBuffer memDuplicate(IntBuffer buffer) {
        return MemoryUtil.duplicate(BUFFER_INT, buffer, PARENT_INT);
    }

    public static LongBuffer memDuplicate(LongBuffer buffer) {
        return MemoryUtil.duplicate(BUFFER_LONG, buffer, PARENT_LONG);
    }

    public static FloatBuffer memDuplicate(FloatBuffer buffer) {
        return MemoryUtil.duplicate(BUFFER_FLOAT, buffer, PARENT_FLOAT);
    }

    public static DoubleBuffer memDuplicate(DoubleBuffer buffer) {
        return MemoryUtil.duplicate(BUFFER_DOUBLE, buffer, PARENT_DOUBLE);
    }

    public static ByteBuffer memSlice(ByteBuffer buffer) {
        return MemoryUtil.slice(buffer, MemoryUtil.memAddress0(buffer) + (long)buffer.position(), buffer.remaining());
    }

    public static ShortBuffer memSlice(ShortBuffer buffer) {
        return MemoryUtil.slice(BUFFER_SHORT, buffer, MemoryUtil.address(buffer.position(), 1, MemoryUtil.memAddress0(buffer)), buffer.remaining(), PARENT_SHORT);
    }

    public static CharBuffer memSlice(CharBuffer buffer) {
        return MemoryUtil.slice(BUFFER_CHAR, buffer, MemoryUtil.address(buffer.position(), 1, MemoryUtil.memAddress0(buffer)), buffer.remaining(), PARENT_CHAR);
    }

    public static IntBuffer memSlice(IntBuffer buffer) {
        return MemoryUtil.slice(BUFFER_INT, buffer, MemoryUtil.address(buffer.position(), 2, MemoryUtil.memAddress0(buffer)), buffer.remaining(), PARENT_INT);
    }

    public static LongBuffer memSlice(LongBuffer buffer) {
        return MemoryUtil.slice(BUFFER_LONG, buffer, MemoryUtil.address(buffer.position(), 3, MemoryUtil.memAddress0(buffer)), buffer.remaining(), PARENT_LONG);
    }

    public static FloatBuffer memSlice(FloatBuffer buffer) {
        return MemoryUtil.slice(BUFFER_FLOAT, buffer, MemoryUtil.address(buffer.position(), 2, MemoryUtil.memAddress0(buffer)), buffer.remaining(), PARENT_FLOAT);
    }

    public static DoubleBuffer memSlice(DoubleBuffer buffer) {
        return MemoryUtil.slice(BUFFER_DOUBLE, buffer, MemoryUtil.address(buffer.position(), 3, MemoryUtil.memAddress0(buffer)), buffer.remaining(), PARENT_DOUBLE);
    }

    public static ByteBuffer memSlice(ByteBuffer buffer, int offset, int capacity) {
        int position = buffer.position() + offset;
        if (offset < 0 || buffer.limit() < position) {
            throw new IllegalArgumentException();
        }
        if (capacity < 0 || buffer.capacity() - position < capacity) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(buffer, MemoryUtil.memAddress0(buffer) + (long)position, capacity);
    }

    public static ShortBuffer memSlice(ShortBuffer buffer, int offset, int capacity) {
        int position = buffer.position() + offset;
        if (offset < 0 || buffer.limit() < position) {
            throw new IllegalArgumentException();
        }
        if (capacity < 0 || buffer.capacity() - position < capacity) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_SHORT, buffer, MemoryUtil.address(position, 1, MemoryUtil.memAddress0(buffer)), capacity, PARENT_SHORT);
    }

    public static CharBuffer memSlice(CharBuffer buffer, int offset, int capacity) {
        int position = buffer.position() + offset;
        if (offset < 0 || buffer.limit() < position) {
            throw new IllegalArgumentException();
        }
        if (capacity < 0 || buffer.capacity() - position < capacity) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_CHAR, buffer, MemoryUtil.address(position, 1, MemoryUtil.memAddress0(buffer)), capacity, PARENT_CHAR);
    }

    public static IntBuffer memSlice(IntBuffer buffer, int offset, int capacity) {
        int position = buffer.position() + offset;
        if (offset < 0 || buffer.limit() < position) {
            throw new IllegalArgumentException();
        }
        if (capacity < 0 || buffer.capacity() - position < capacity) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_INT, buffer, MemoryUtil.address(position, 2, MemoryUtil.memAddress0(buffer)), capacity, PARENT_INT);
    }

    public static LongBuffer memSlice(LongBuffer buffer, int offset, int capacity) {
        int position = buffer.position() + offset;
        if (offset < 0 || buffer.limit() < position) {
            throw new IllegalArgumentException();
        }
        if (capacity < 0 || buffer.capacity() - position < capacity) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_LONG, buffer, MemoryUtil.address(position, 3, MemoryUtil.memAddress0(buffer)), capacity, PARENT_LONG);
    }

    public static FloatBuffer memSlice(FloatBuffer buffer, int offset, int capacity) {
        int position = buffer.position() + offset;
        if (offset < 0 || buffer.limit() < position) {
            throw new IllegalArgumentException();
        }
        if (capacity < 0 || buffer.capacity() - position < capacity) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_FLOAT, buffer, MemoryUtil.address(position, 2, MemoryUtil.memAddress0(buffer)), capacity, PARENT_FLOAT);
    }

    public static DoubleBuffer memSlice(DoubleBuffer buffer, int offset, int capacity) {
        int position = buffer.position() + offset;
        if (offset < 0 || buffer.limit() < position) {
            throw new IllegalArgumentException();
        }
        if (capacity < 0 || buffer.capacity() - position < capacity) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_DOUBLE, buffer, MemoryUtil.address(position, 3, MemoryUtil.memAddress0(buffer)), capacity, PARENT_DOUBLE);
    }

    public static <T extends CustomBuffer<T>> T memSlice(T buffer, int offset, int capacity) {
        return buffer.slice(offset, capacity);
    }

    public static void memSet(ByteBuffer ptr, int value) {
        MemoryUtil.memSet(MemoryUtil.memAddress(ptr), value, ptr.remaining());
    }

    public static void memSet(ShortBuffer ptr, int value) {
        MemoryUtil.memSet(MemoryUtil.memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 1));
    }

    public static void memSet(CharBuffer ptr, int value) {
        MemoryUtil.memSet(MemoryUtil.memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 1));
    }

    public static void memSet(IntBuffer ptr, int value) {
        MemoryUtil.memSet(MemoryUtil.memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 2));
    }

    public static void memSet(LongBuffer ptr, int value) {
        MemoryUtil.memSet(MemoryUtil.memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 3));
    }

    public static void memSet(FloatBuffer ptr, int value) {
        MemoryUtil.memSet(MemoryUtil.memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 2));
    }

    public static void memSet(DoubleBuffer ptr, int value) {
        MemoryUtil.memSet(MemoryUtil.memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 3));
    }

    public static <T extends CustomBuffer<T>> void memSet(T ptr, int value) {
        MemoryUtil.memSet(MemoryUtil.memAddress(ptr), value, Integer.toUnsignedLong(ptr.remaining()) * (long)ptr.sizeof());
    }

    public static <T extends Struct> void memSet(T ptr, int value) {
        MemoryUtil.memSet(ptr.address, value, ptr.sizeof());
    }

    public static void memCopy(ByteBuffer src, ByteBuffer dst) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dst, src.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(src), MemoryUtil.memAddress(dst), src.remaining());
    }

    public static void memCopy(ShortBuffer src, ShortBuffer dst) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dst, src.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(src), MemoryUtil.memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 1));
    }

    public static void memCopy(CharBuffer src, CharBuffer dst) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dst, src.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(src), MemoryUtil.memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 1));
    }

    public static void memCopy(IntBuffer src, IntBuffer dst) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dst, src.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(src), MemoryUtil.memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 2));
    }

    public static void memCopy(LongBuffer src, LongBuffer dst) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dst, src.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(src), MemoryUtil.memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 3));
    }

    public static void memCopy(FloatBuffer src, FloatBuffer dst) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dst, src.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(src), MemoryUtil.memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 2));
    }

    public static void memCopy(DoubleBuffer src, DoubleBuffer dst) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dst, src.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(src), MemoryUtil.memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 3));
    }

    public static <T extends CustomBuffer<T>> void memCopy(T src, T dst) {
        if (Checks.CHECKS) {
            Checks.check(dst, src.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(src), MemoryUtil.memAddress(dst), Integer.toUnsignedLong(src.remaining()) * (long)src.sizeof());
    }

    public static <T extends Struct> void memCopy(T src, T dst) {
        MultiReleaseMemCopy.copy(src.address, dst.address, src.sizeof());
    }

    public static void memSet(long ptr, int value, long bytes) {
        int misalignment;
        if (Checks.DEBUG && (ptr == 0L || bytes < 0L)) {
            throw new IllegalArgumentException();
        }
        if (256L <= bytes) {
            LibCString.nmemset(ptr, value, bytes);
            return;
        }
        long fill = (long)(value & 0xFF) * FILL_PATTERN;
        int i = 0;
        int length = (int)bytes & 0xFF;
        if (length != 0 && (misalignment = (int)ptr & 7) != 0) {
            long aligned = ptr - (long)misalignment;
            UNSAFE.putLong(null, aligned, MemoryUtil.merge(UNSAFE.getLong(null, aligned), fill, SHIFT.right(SHIFT.left(-1L, Math.max(0, 8 - length)), misalignment)));
            i += 8 - misalignment;
        }
        while (i <= length - 8) {
            UNSAFE.putLong(null, ptr + (long)i, fill);
            i += 8;
        }
        int tail = length - i;
        if (0 < tail) {
            UNSAFE.putLong(null, ptr + (long)i, MemoryUtil.merge(fill, UNSAFE.getLong(null, ptr + (long)i), SHIFT.right(-1L, tail)));
        }
    }

    static long merge(long a, long b, long mask) {
        return a ^ (a ^ b) & mask;
    }

    public static void memCopy(long src, long dst, long bytes) {
        if (Checks.DEBUG && (src == 0L || dst == 0L || bytes < 0L)) {
            throw new IllegalArgumentException();
        }
        MultiReleaseMemCopy.copy(src, dst, bytes);
    }

    static void memCopyAligned(long src, long dst, int bytes) {
        int i;
        for (i = 0; i <= bytes - 8; i += 8) {
            UNSAFE.putLong(null, dst + (long)i, UNSAFE.getLong(null, src + (long)i));
        }
        if (i < bytes) {
            UNSAFE.putLong(null, dst + (long)i, MemoryUtil.merge(UNSAFE.getLong(null, src + (long)i), UNSAFE.getLong(null, dst + (long)i), SHIFT.right(-1L, bytes - i)));
        }
    }

    public static boolean memGetBoolean(long ptr) {
        return UNSAFE.getByte(null, ptr) != 0;
    }

    public static byte memGetByte(long ptr) {
        return UNSAFE.getByte(null, ptr);
    }

    public static short memGetShort(long ptr) {
        return UNSAFE.getShort(null, ptr);
    }

    public static int memGetInt(long ptr) {
        return UNSAFE.getInt(null, ptr);
    }

    public static long memGetLong(long ptr) {
        return UNSAFE.getLong(null, ptr);
    }

    public static float memGetFloat(long ptr) {
        return UNSAFE.getFloat(null, ptr);
    }

    public static double memGetDouble(long ptr) {
        return UNSAFE.getDouble(null, ptr);
    }

    public static long memGetCLong(long ptr) {
        return Pointer.CLONG_SIZE == 8 ? UNSAFE.getLong(null, ptr) : (long)UNSAFE.getInt(null, ptr);
    }

    public static long memGetAddress(long ptr) {
        return Pointer.BITS64 ? UNSAFE.getLong(null, ptr) : (long)UNSAFE.getInt(null, ptr) & 0xFFFFFFFFL;
    }

    public static void memPutByte(long ptr, byte value) {
        UNSAFE.putByte(null, ptr, value);
    }

    public static void memPutShort(long ptr, short value) {
        UNSAFE.putShort(null, ptr, value);
    }

    public static void memPutInt(long ptr, int value) {
        UNSAFE.putInt(null, ptr, value);
    }

    public static void memPutLong(long ptr, long value) {
        UNSAFE.putLong(null, ptr, value);
    }

    public static void memPutFloat(long ptr, float value) {
        UNSAFE.putFloat(null, ptr, value);
    }

    public static void memPutDouble(long ptr, double value) {
        UNSAFE.putDouble(null, ptr, value);
    }

    public static void memPutCLong(long ptr, long value) {
        if (Pointer.CLONG_SIZE == 8) {
            UNSAFE.putLong(null, ptr, value);
        } else {
            UNSAFE.putInt(null, ptr, (int)value);
        }
    }

    public static void memPutAddress(long ptr, long value) {
        if (Pointer.BITS64) {
            UNSAFE.putLong(null, ptr, value);
        } else {
            UNSAFE.putInt(null, ptr, (int)value);
        }
    }

    public static native <T> T memGlobalRefToObject(long var0);

    @Deprecated
    public static long memNewGlobalRef(Object obj) {
        return JNINativeInterface.NewGlobalRef(obj);
    }

    @Deprecated
    public static void memDeleteGlobalRef(long globalRef) {
        JNINativeInterface.DeleteGlobalRef(globalRef);
    }

    @Deprecated
    public static long memNewWeakGlobalRef(Object obj) {
        return JNINativeInterface.NewWeakGlobalRef(obj);
    }

    @Deprecated
    public static void memDeleteWeakGlobalRef(long globalRef) {
        JNINativeInterface.DeleteWeakGlobalRef(globalRef);
    }

    public static ByteBuffer memASCII(CharSequence text) {
        return MemoryUtil.memASCII(text, true);
    }

    @Nullable
    public static ByteBuffer memASCIISafe(@Nullable CharSequence text) {
        return text == null ? null : MemoryUtil.memASCII(text, true);
    }

    public static ByteBuffer memASCII(CharSequence text, boolean nullTerminated) {
        int length = MemoryUtil.memLengthASCII(text, nullTerminated);
        long target = MemoryUtil.nmemAlloc(length);
        MemoryUtil.encodeASCII(text, nullTerminated, target);
        return MemoryUtil.wrap(BUFFER_BYTE, target, length).order(NATIVE_ORDER);
    }

    @Nullable
    public static ByteBuffer memASCIISafe(@Nullable CharSequence text, boolean nullTerminated) {
        return text == null ? null : MemoryUtil.memASCII(text, nullTerminated);
    }

    public static int memASCII(CharSequence text, boolean nullTerminated, ByteBuffer target) {
        return MemoryUtil.encodeASCII(text, nullTerminated, MemoryUtil.memAddress(target));
    }

    public static int memASCII(CharSequence text, boolean nullTerminated, ByteBuffer target, int offset) {
        return MemoryUtil.encodeASCII(text, nullTerminated, MemoryUtil.memAddress(target, offset));
    }

    static int encodeASCII(CharSequence text, boolean nullTerminated, long target) {
        int len = text.length();
        for (int p = 0; p < len; ++p) {
            UNSAFE.putByte(target + (long)p, (byte)text.charAt(p));
        }
        if (nullTerminated) {
            UNSAFE.putByte(target + (long)len++, (byte)0);
        }
        return len;
    }

    public static int memLengthASCII(CharSequence value, boolean nullTerminated) {
        return value.length() + (nullTerminated ? 1 : 0);
    }

    public static ByteBuffer memUTF8(CharSequence text) {
        return MemoryUtil.memUTF8(text, true);
    }

    @Nullable
    public static ByteBuffer memUTF8Safe(@Nullable CharSequence text) {
        return text == null ? null : MemoryUtil.memUTF8(text, true);
    }

    public static ByteBuffer memUTF8(CharSequence text, boolean nullTerminated) {
        int length = MemoryUtil.memLengthUTF8(text, nullTerminated);
        long target = MemoryUtil.nmemAlloc(length);
        MemoryUtil.encodeUTF8(text, nullTerminated, target);
        return MemoryUtil.wrap(BUFFER_BYTE, target, length).order(NATIVE_ORDER);
    }

    @Nullable
    public static ByteBuffer memUTF8Safe(@Nullable CharSequence text, boolean nullTerminated) {
        return text == null ? null : MemoryUtil.memUTF8(text, nullTerminated);
    }

    public static int memUTF8(CharSequence text, boolean nullTerminated, ByteBuffer target) {
        return MemoryUtil.encodeUTF8(text, nullTerminated, MemoryUtil.memAddress(target));
    }

    public static int memUTF8(CharSequence text, boolean nullTerminated, ByteBuffer target, int offset) {
        return MemoryUtil.encodeUTF8(text, nullTerminated, MemoryUtil.memAddress(target, offset));
    }

    static int encodeUTF8(CharSequence text, boolean nullTerminated, long target) {
        int c;
        int i;
        int len = text.length();
        int p = 0;
        for (i = 0; i < len && (c = text.charAt(i)) < 128; ++i) {
            UNSAFE.putByte(target + (long)p++, (byte)c);
        }
        while (i < len) {
            if ((c = text.charAt(i++)) < 128) {
                UNSAFE.putByte(target + (long)p++, (byte)c);
                continue;
            }
            int cp = c;
            if (c < 2048) {
                UNSAFE.putByte(target + (long)p++, (byte)(0xC0 | cp >> 6));
            } else {
                if (!Character.isHighSurrogate((char)c)) {
                    UNSAFE.putByte(target + (long)p++, (byte)(0xE0 | cp >> 12));
                } else {
                    cp = Character.toCodePoint((char)c, text.charAt(i++));
                    UNSAFE.putByte(target + (long)p++, (byte)(0xF0 | cp >> 18));
                    UNSAFE.putByte(target + (long)p++, (byte)(0x80 | cp >> 12 & 0x3F));
                }
                UNSAFE.putByte(target + (long)p++, (byte)(0x80 | cp >> 6 & 0x3F));
            }
            UNSAFE.putByte(target + (long)p++, (byte)(0x80 | cp & 0x3F));
        }
        if (nullTerminated) {
            UNSAFE.putByte(target + (long)p++, (byte)0);
        }
        return p;
    }

    public static int memLengthUTF8(CharSequence value, boolean nullTerminated) {
        int i;
        int len;
        int bytes = len = value.length();
        for (i = 0; i < len && '\u0080' > value.charAt(i); ++i) {
        }
        while (i < len) {
            char c = value.charAt(i);
            if ('\u0800' <= c) {
                bytes += MemoryUtil.encodeUTF8LengthSlow(value, i, len);
                break;
            }
            bytes += 127 - c >>> 31;
            ++i;
        }
        return bytes + (nullTerminated ? 1 : 0);
    }

    private static int encodeUTF8LengthSlow(CharSequence value, int offset, int len) {
        int bytes = 0;
        for (int i = offset; i < len; ++i) {
            char c = value.charAt(i);
            if (c < '\u0800') {
                bytes += 127 - c >>> 31;
                continue;
            }
            if (c < '\ud800' || '\udfff' < c) {
                bytes += 2;
                continue;
            }
            bytes += 2;
            ++i;
        }
        return bytes;
    }

    public static ByteBuffer memUTF16(CharSequence text) {
        return MemoryUtil.memUTF16(text, true);
    }

    @Nullable
    public static ByteBuffer memUTF16Safe(@Nullable CharSequence text) {
        return text == null ? null : MemoryUtil.memUTF16(text, true);
    }

    public static ByteBuffer memUTF16(CharSequence text, boolean nullTerminated) {
        int length = MemoryUtil.memLengthUTF16(text, nullTerminated);
        long target = MemoryUtil.nmemAlloc(length);
        MemoryUtil.encodeUTF16(text, nullTerminated, target);
        return MemoryUtil.wrap(BUFFER_BYTE, target, length).order(NATIVE_ORDER);
    }

    @Nullable
    public static ByteBuffer memUTF16Safe(@Nullable CharSequence text, boolean nullTerminated) {
        return text == null ? null : MemoryUtil.memUTF16(text, nullTerminated);
    }

    public static int memUTF16(CharSequence text, boolean nullTerminated, ByteBuffer target) {
        return MemoryUtil.encodeUTF16(text, nullTerminated, MemoryUtil.memAddress(target));
    }

    public static int memUTF16(CharSequence text, boolean nullTerminated, ByteBuffer target, int offset) {
        return MemoryUtil.encodeUTF16(text, nullTerminated, MemoryUtil.memAddress(target, offset));
    }

    static int encodeUTF16(CharSequence text, boolean nullTerminated, long target) {
        int len = text.length();
        for (int i = 0; i < len; ++i) {
            UNSAFE.putShort(target + Integer.toUnsignedLong(i) * 2L, (short)text.charAt(i));
        }
        if (nullTerminated) {
            UNSAFE.putShort(target + Integer.toUnsignedLong(len++) * 2L, (short)0);
        }
        return 2 * len;
    }

    public static int memLengthUTF16(CharSequence value, boolean nullTerminated) {
        return value.length() + (nullTerminated ? 1 : 0) << 1;
    }

    private static int memLengthNT1(long address, int maxLength) {
        if (Checks.CHECKS) {
            Checks.check(address);
        }
        return Pointer.BITS64 ? MemoryUtil.strlen64NT1(address, maxLength) : MemoryUtil.strlen32NT1(address, maxLength);
    }

    private static int strlen64NT1(long address, int maxLength) {
        int i;
        if (8 <= maxLength) {
            int misalignment = (int)address & 7;
            if (misalignment != 0) {
                int len = 8 - misalignment;
                for (i = 0; i < len; ++i) {
                    if (UNSAFE.getByte(null, address + (long)i) != 0) continue;
                    return i;
                }
            }
            while (i <= maxLength - 8 && !MathUtil.mathHasZeroByte(UNSAFE.getLong(null, address + (long)i))) {
                i += 8;
            }
        }
        while (i < maxLength && UNSAFE.getByte(null, address + (long)i) != 0) {
            ++i;
        }
        return i;
    }

    private static int strlen32NT1(long address, int maxLength) {
        int i;
        if (4 <= maxLength) {
            int misalignment = (int)address & 3;
            if (misalignment != 0) {
                int len = 4 - misalignment;
                for (i = 0; i < len; ++i) {
                    if (UNSAFE.getByte(null, address + (long)i) != 0) continue;
                    return i;
                }
            }
            while (i <= maxLength - 4 && !MathUtil.mathHasZeroByte(UNSAFE.getInt(null, address + (long)i))) {
                i += 4;
            }
        }
        while (i < maxLength && UNSAFE.getByte(null, address + (long)i) != 0) {
            ++i;
        }
        return i;
    }

    public static int memLengthNT1(ByteBuffer buffer) {
        return MemoryUtil.memLengthNT1(MemoryUtil.memAddress(buffer), buffer.remaining());
    }

    private static int memLengthNT2(long address, int maxLength) {
        if (Checks.CHECKS) {
            Checks.check(address);
        }
        return Pointer.BITS64 ? MemoryUtil.strlen64NT2(address, maxLength) : MemoryUtil.strlen32NT2(address, maxLength);
    }

    private static int strlen64NT2(long address, int maxLength) {
        int i;
        if (8 <= maxLength) {
            int misalignment = (int)address & 7;
            if (misalignment != 0) {
                int len = 8 - misalignment;
                for (i = 0; i < len; i += 2) {
                    if (UNSAFE.getShort(null, address + (long)i) != 0) continue;
                    return i;
                }
            }
            while (i <= maxLength - 8 && !MathUtil.mathHasZeroShort(UNSAFE.getLong(null, address + (long)i))) {
                i += 8;
            }
        }
        while (i < maxLength && UNSAFE.getShort(null, address + (long)i) != 0) {
            i += 2;
        }
        return i;
    }

    private static int strlen32NT2(long address, int maxLength) {
        int i;
        if (4 <= maxLength) {
            int misalignment = (int)address & 3;
            if (misalignment != 0) {
                int len = 4 - misalignment;
                for (i = 0; i < len; i += 2) {
                    if (UNSAFE.getShort(null, address + (long)i) != 0) continue;
                    return i;
                }
            }
            while (i <= maxLength - 4 && !MathUtil.mathHasZeroShort(UNSAFE.getInt(null, address + (long)i))) {
                i += 4;
            }
        }
        while (i < maxLength && UNSAFE.getShort(null, address + (long)i) != 0) {
            i += 2;
        }
        return i;
    }

    public static int memLengthNT2(ByteBuffer buffer) {
        return MemoryUtil.memLengthNT2(MemoryUtil.memAddress(buffer), buffer.remaining());
    }

    public static ByteBuffer memByteBufferNT1(long address) {
        return MemoryUtil.memByteBuffer(address, MemoryUtil.memLengthNT1(address, Integer.MAX_VALUE));
    }

    public static ByteBuffer memByteBufferNT1(long address, int maxLength) {
        return MemoryUtil.memByteBuffer(address, MemoryUtil.memLengthNT1(address, maxLength));
    }

    @Nullable
    public static ByteBuffer memByteBufferNT1Safe(long address) {
        return address == 0L ? null : MemoryUtil.memByteBuffer(address, MemoryUtil.memLengthNT1(address, Integer.MAX_VALUE));
    }

    @Nullable
    public static ByteBuffer memByteBufferNT1Safe(long address, int maxLength) {
        return address == 0L ? null : MemoryUtil.memByteBuffer(address, MemoryUtil.memLengthNT1(address, maxLength));
    }

    public static ByteBuffer memByteBufferNT2(long address) {
        return MemoryUtil.memByteBufferNT2(address, 0x7FFFFFFE);
    }

    public static ByteBuffer memByteBufferNT2(long address, int maxLength) {
        if (Checks.DEBUG && (maxLength & 1) != 0) {
            throw new IllegalArgumentException("The maximum length must be an even number.");
        }
        return MemoryUtil.memByteBuffer(address, MemoryUtil.memLengthNT2(address, maxLength));
    }

    @Nullable
    public static ByteBuffer memByteBufferNT2Safe(long address) {
        return address == 0L ? null : MemoryUtil.memByteBufferNT2(address, 0x7FFFFFFE);
    }

    @Nullable
    public static ByteBuffer memByteBufferNT2Safe(long address, int maxLength) {
        return address == 0L ? null : MemoryUtil.memByteBufferNT2(address, maxLength);
    }

    public static String memASCII(long address) {
        return MemoryUtil.memASCII(address, MemoryUtil.memLengthNT1(address, Integer.MAX_VALUE));
    }

    public static String memASCII(long address, int length) {
        if (length <= 0) {
            return "";
        }
        byte[] ascii = length <= ARRAY_TLC_SIZE ? ARRAY_TLC_BYTE.get() : new byte[length];
        MemoryUtil.memByteBuffer(address, length).get(ascii, 0, length);
        return new String(ascii, 0, 0, length);
    }

    public static String memASCII(ByteBuffer buffer) {
        return MemoryUtil.memASCII(MemoryUtil.memAddress(buffer), buffer.remaining());
    }

    @Nullable
    public static String memASCIISafe(long address) {
        return address == 0L ? null : MemoryUtil.memASCII(address, MemoryUtil.memLengthNT1(address, Integer.MAX_VALUE));
    }

    @Nullable
    public static String memASCIISafe(long address, int length) {
        return address == 0L ? null : MemoryUtil.memASCII(address, length);
    }

    @Nullable
    public static String memASCIISafe(@Nullable ByteBuffer buffer) {
        return buffer == null ? null : MemoryUtil.memASCII(MemoryUtil.memAddress(buffer), buffer.remaining());
    }

    public static String memASCII(ByteBuffer buffer, int length) {
        return MemoryUtil.memASCII(MemoryUtil.memAddress(buffer), length);
    }

    public static String memASCII(ByteBuffer buffer, int length, int offset) {
        return MemoryUtil.memASCII(MemoryUtil.memAddress(buffer, offset), length);
    }

    public static String memUTF8(long address) {
        return MultiReleaseTextDecoding.decodeUTF8(address, MemoryUtil.memLengthNT1(address, Integer.MAX_VALUE));
    }

    public static String memUTF8(long address, int length) {
        return MultiReleaseTextDecoding.decodeUTF8(address, length);
    }

    public static String memUTF8(ByteBuffer buffer) {
        return MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(buffer), buffer.remaining());
    }

    @Nullable
    public static String memUTF8Safe(long address) {
        return address == 0L ? null : MultiReleaseTextDecoding.decodeUTF8(address, MemoryUtil.memLengthNT1(address, Integer.MAX_VALUE));
    }

    @Nullable
    public static String memUTF8Safe(long address, int length) {
        return address == 0L ? null : MultiReleaseTextDecoding.decodeUTF8(address, length);
    }

    @Nullable
    public static String memUTF8Safe(@Nullable ByteBuffer buffer) {
        return buffer == null ? null : MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(buffer), buffer.remaining());
    }

    public static String memUTF8(ByteBuffer buffer, int length) {
        return MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(buffer), length);
    }

    public static String memUTF8(ByteBuffer buffer, int length, int offset) {
        return MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(buffer, offset), length);
    }

    public static String memUTF16(long address) {
        return MemoryUtil.memUTF16(address, MemoryUtil.memLengthNT2(address, 0x7FFFFFFE) >> 1);
    }

    public static String memUTF16(long address, int length) {
        if (length <= 0) {
            return "";
        }
        if (Checks.DEBUG) {
            int len = length << 1;
            byte[] bytes = len <= ARRAY_TLC_SIZE ? ARRAY_TLC_BYTE.get() : new byte[len];
            MemoryUtil.memByteBuffer(address, len).get(bytes, 0, len);
            return new String(bytes, 0, len, UTF16);
        }
        char[] chars = length <= ARRAY_TLC_SIZE ? ARRAY_TLC_CHAR.get() : new char[length];
        MemoryUtil.memCharBuffer(address, length).get(chars, 0, length);
        return new String(chars, 0, length);
    }

    public static String memUTF16(ByteBuffer buffer) {
        return MemoryUtil.memUTF16(MemoryUtil.memAddress(buffer), buffer.remaining() >> 1);
    }

    @Nullable
    public static String memUTF16Safe(long address) {
        return address == 0L ? null : MemoryUtil.memUTF16(address, MemoryUtil.memLengthNT2(address, 0x7FFFFFFE) >> 1);
    }

    @Nullable
    public static String memUTF16Safe(long address, int length) {
        return address == 0L ? null : MemoryUtil.memUTF16(address, length);
    }

    @Nullable
    public static String memUTF16Safe(@Nullable ByteBuffer buffer) {
        return buffer == null ? null : MemoryUtil.memUTF16(MemoryUtil.memAddress(buffer), buffer.remaining() >> 1);
    }

    public static String memUTF16(ByteBuffer buffer, int length) {
        return MemoryUtil.memUTF16(MemoryUtil.memAddress(buffer), length);
    }

    public static String memUTF16(ByteBuffer buffer, int length, int offset) {
        return MemoryUtil.memUTF16(MemoryUtil.memAddress(buffer, offset), length);
    }

    private static Unsafe getUnsafeInstance() {
        Field[] fields;
        for (Field field : fields = Unsafe.class.getDeclaredFields()) {
            int modifiers;
            if (!field.getType().equals(Unsafe.class) || !Modifier.isStatic(modifiers = field.getModifiers()) || !Modifier.isFinal(modifiers)) continue;
            try {
                field.setAccessible(true);
                return (Unsafe)field.get(null);
            }
            catch (Exception exception) {
                break;
            }
        }
        throw new UnsupportedOperationException("LWJGL requires sun.misc.Unsafe to be available.");
    }

    private static long getAddressOffset() {
        long MAGIC_ADDRESS = -2401053090268712947L;
        if (Pointer.BITS32) {
            MAGIC_ADDRESS &= 0xFFFFFFFFL;
        }
        ByteBuffer bb = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(MAGIC_ADDRESS, 0L));
        long offset = 8L;
        while (UNSAFE.getLong(bb, offset) != MAGIC_ADDRESS) {
            offset += 8L;
        }
        return offset;
    }

    private static long getIntFieldOffset(ByteBuffer bb, int magicValue) {
        long offset = 4L;
        while (UNSAFE.getInt(bb, offset) != magicValue) {
            offset += 4L;
        }
        return offset;
    }

    private static long getMarkOffset() {
        ByteBuffer bb = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(1L, 0L));
        return MemoryUtil.getIntFieldOffset(bb, -1);
    }

    private static long getPositionOffset() {
        ByteBuffer bb = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
        bb.position(16435934);
        return MemoryUtil.getIntFieldOffset(bb, 16435934);
    }

    private static long getLimitOffset() {
        ByteBuffer bb = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
        bb.limit(16435934);
        return MemoryUtil.getIntFieldOffset(bb, 16435934);
    }

    private static long getCapacityOffset() {
        ByteBuffer bb = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
        bb.limit(0);
        return MemoryUtil.getIntFieldOffset(bb, 219540062);
    }

    private static <T extends Buffer> long getParentOffset(long offset, int oopSize, T buffer, T bufferWithAttachment) {
        switch (oopSize) {
            case 4: {
                while (true) {
                    if (UNSAFE.getInt(buffer, offset) != UNSAFE.getInt(bufferWithAttachment, offset)) {
                        return offset;
                    }
                    offset += (long)oopSize;
                }
            }
            case 8: {
                while (UNSAFE.getLong(buffer, offset) == UNSAFE.getLong(bufferWithAttachment, offset)) {
                    offset += (long)oopSize;
                }
                return offset;
            }
        }
        throw new IllegalStateException();
    }

    static <T extends Buffer> T wrap(Class<? extends T> clazz, long address, int capacity) {
        Buffer buffer;
        try {
            buffer = (Buffer)UNSAFE.allocateInstance(clazz);
        }
        catch (InstantiationException e) {
            throw new UnsupportedOperationException(e);
        }
        UNSAFE.putLong(buffer, ADDRESS, address);
        UNSAFE.putInt(buffer, MARK, -1);
        UNSAFE.putInt(buffer, LIMIT, capacity);
        UNSAFE.putInt(buffer, CAPACITY, capacity);
        return (T)buffer;
    }

    static ByteBuffer slice(ByteBuffer source, long address, int capacity) {
        ByteBuffer target;
        try {
            target = (ByteBuffer)UNSAFE.allocateInstance(BUFFER_BYTE);
        }
        catch (InstantiationException e) {
            throw new UnsupportedOperationException(e);
        }
        UNSAFE.putLong(target, ADDRESS, address);
        UNSAFE.putInt(target, MARK, -1);
        UNSAFE.putInt(target, LIMIT, capacity);
        UNSAFE.putInt(target, CAPACITY, capacity);
        Object attachment = UNSAFE.getObject(source, PARENT_BYTE);
        UNSAFE.putObject(target, PARENT_BYTE, attachment == null ? source : attachment);
        return target.order(source.order());
    }

    static <T extends Buffer> T slice(Class<? extends T> clazz, T source, long address, int capacity, long attachmentOffset) {
        Buffer target;
        try {
            target = (Buffer)UNSAFE.allocateInstance(clazz);
        }
        catch (InstantiationException e) {
            throw new UnsupportedOperationException(e);
        }
        UNSAFE.putLong(target, ADDRESS, address);
        UNSAFE.putInt(target, MARK, -1);
        UNSAFE.putInt(target, LIMIT, capacity);
        UNSAFE.putInt(target, CAPACITY, capacity);
        UNSAFE.putObject(target, attachmentOffset, UNSAFE.getObject(source, attachmentOffset));
        return (T)target;
    }

    static <T extends Buffer> T duplicate(Class<? extends T> clazz, T source, long attachmentOffset) {
        Buffer target;
        try {
            target = (Buffer)UNSAFE.allocateInstance(clazz);
        }
        catch (InstantiationException e) {
            throw new UnsupportedOperationException(e);
        }
        UNSAFE.putLong(target, ADDRESS, UNSAFE.getLong(source, ADDRESS));
        UNSAFE.putInt(target, MARK, UNSAFE.getInt(source, MARK));
        UNSAFE.putInt(target, POSITION, UNSAFE.getInt(source, POSITION));
        UNSAFE.putInt(target, LIMIT, UNSAFE.getInt(source, LIMIT));
        UNSAFE.putInt(target, CAPACITY, UNSAFE.getInt(source, CAPACITY));
        UNSAFE.putObject(target, attachmentOffset, UNSAFE.getObject(source, attachmentOffset));
        return (T)target;
    }

    static {
        ARRAY_TLC_SIZE = Configuration.ARRAY_TLC_SIZE.get(8192);
        ARRAY_TLC_BYTE = ThreadLocal.withInitial(() -> new byte[ARRAY_TLC_SIZE]);
        ARRAY_TLC_CHAR = ThreadLocal.withInitial(() -> new char[ARRAY_TLC_SIZE]);
        NATIVE_ORDER = ByteOrder.nativeOrder();
        UTF16 = NATIVE_ORDER == ByteOrder.LITTLE_ENDIAN ? StandardCharsets.UTF_16LE : StandardCharsets.UTF_16BE;
        Library.initialize();
        ByteBuffer bb = ByteBuffer.allocateDirect(0).order(NATIVE_ORDER);
        BUFFER_BYTE = bb.getClass();
        BUFFER_SHORT = bb.asShortBuffer().getClass();
        BUFFER_CHAR = bb.asCharBuffer().getClass();
        BUFFER_INT = bb.asIntBuffer().getClass();
        BUFFER_LONG = bb.asLongBuffer().getClass();
        BUFFER_FLOAT = bb.asFloatBuffer().getClass();
        BUFFER_DOUBLE = bb.asDoubleBuffer().getClass();
        UNSAFE = MemoryUtil.getUnsafeInstance();
        try {
            MARK = MemoryUtil.getMarkOffset();
            POSITION = MemoryUtil.getPositionOffset();
            LIMIT = MemoryUtil.getLimitOffset();
            CAPACITY = MemoryUtil.getCapacityOffset();
            ADDRESS = MemoryUtil.getAddressOffset();
            int oopSize = UNSAFE.arrayIndexScale(Object[].class);
            long offset = Math.max(Math.max(Math.max(MARK, POSITION), LIMIT), CAPACITY) + 4L + (long)(oopSize - 1) & (Integer.toUnsignedLong(oopSize - 1) ^ 0xFFFFFFFFFFFFFFFFL);
            long a = MemoryUtil.memAddress(bb);
            PARENT_BYTE = MemoryUtil.getParentOffset(offset, oopSize, bb, bb.duplicate().order(bb.order()));
            PARENT_SHORT = MemoryUtil.getParentOffset(offset, oopSize, MemoryUtil.memShortBuffer(a, 0), bb.asShortBuffer());
            PARENT_CHAR = MemoryUtil.getParentOffset(offset, oopSize, MemoryUtil.memCharBuffer(a, 0), bb.asCharBuffer());
            PARENT_INT = MemoryUtil.getParentOffset(offset, oopSize, MemoryUtil.memIntBuffer(a, 0), bb.asIntBuffer());
            PARENT_LONG = MemoryUtil.getParentOffset(offset, oopSize, MemoryUtil.memLongBuffer(a, 0), bb.asLongBuffer());
            PARENT_FLOAT = MemoryUtil.getParentOffset(offset, oopSize, MemoryUtil.memFloatBuffer(a, 0), bb.asFloatBuffer());
            PARENT_DOUBLE = MemoryUtil.getParentOffset(offset, oopSize, MemoryUtil.memDoubleBuffer(a, 0), bb.asDoubleBuffer());
        }
        catch (Throwable t) {
            throw new UnsupportedOperationException(t);
        }
        PAGE_SIZE = UNSAFE.pageSize();
        CACHE_LINE_SIZE = 64;
        SHIFT = NATIVE_ORDER == ByteOrder.BIG_ENDIAN ? new NativeShift(){

            @Override
            public long left(long value, int bytes) {
                return value << (bytes << 3);
            }

            @Override
            public long right(long value, int bytes) {
                return value >>> (bytes << 3);
            }
        } : new NativeShift(){

            @Override
            public long left(long value, int bytes) {
                return value >>> (bytes << 3);
            }

            @Override
            public long right(long value, int bytes) {
                return value << (bytes << 3);
            }
        };
        FILL_PATTERN = Long.divideUnsigned(-1L, 255L);
    }

    private static interface NativeShift {
        public long left(long var1, int var3);

        public long right(long var1, int var3);
    }

    public static interface MemoryAllocationReport {
        public void invoke(long var1, long var3, long var5, @Nullable String var7, StackTraceElement ... var8);

        public static enum Aggregate {
            ALL,
            GROUP_BY_METHOD,
            GROUP_BY_STACKTRACE;

        }
    }

    public static interface MemoryAllocator {
        public long getMalloc();

        public long getCalloc();

        public long getRealloc();

        public long getFree();

        public long getAlignedAlloc();

        public long getAlignedFree();

        public long malloc(long var1);

        public long calloc(long var1, long var3);

        public long realloc(long var1, long var3);

        public void free(long var1);

        public long aligned_alloc(long var1, long var3);

        public void aligned_free(long var1);
    }

    static final class LazyInit {
        static final MemoryAllocator ALLOCATOR_IMPL = MemoryManage.getInstance();
        static final MemoryAllocator ALLOCATOR = Configuration.DEBUG_MEMORY_ALLOCATOR.get(false) != false ? new MemoryManage.DebugAllocator(ALLOCATOR_IMPL) : ALLOCATOR_IMPL;

        private LazyInit() {
        }

        static {
            APIUtil.apiLog("MemoryUtil allocator: " + ALLOCATOR.getClass().getSimpleName());
        }
    }
}

