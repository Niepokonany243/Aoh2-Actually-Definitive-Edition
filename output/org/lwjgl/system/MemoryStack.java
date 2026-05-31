/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.CLongBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.StackWalkUtil;

public class MemoryStack
extends Pointer.Default
implements AutoCloseable {
    private static final int DEFAULT_STACK_SIZE = Configuration.STACK_SIZE.get(64) * 1024;
    private static final int DEFAULT_STACK_FRAMES = 8;
    private static final ThreadLocal<MemoryStack> TLS = ThreadLocal.withInitial(MemoryStack::create);
    @Nullable
    private final ByteBuffer container;
    private final int size;
    private int pointer;
    private int[] frames;
    protected int frameIndex;

    protected MemoryStack(@Nullable ByteBuffer container, long address, int size) {
        super(address);
        this.container = container;
        this.size = size;
        this.pointer = size;
        this.frames = new int[8];
    }

    public static MemoryStack create() {
        return MemoryStack.create(DEFAULT_STACK_SIZE);
    }

    public static MemoryStack create(int capacity) {
        return MemoryStack.create(BufferUtils.createByteBuffer(capacity));
    }

    public static MemoryStack create(ByteBuffer buffer) {
        long address = MemoryUtil.memAddress(buffer);
        int size = buffer.remaining();
        return Configuration.DEBUG_STACK.get(false) != false ? new DebugMemoryStack(buffer, address, size) : new MemoryStack(buffer, address, size);
    }

    public static MemoryStack ncreate(long address, int size) {
        return Configuration.DEBUG_STACK.get(false) != false ? new DebugMemoryStack(null, address, size) : new MemoryStack(null, address, size);
    }

    public MemoryStack push() {
        if (this.frameIndex == this.frames.length) {
            this.frameOverflow();
        }
        this.frames[this.frameIndex++] = this.pointer;
        return this;
    }

    private void frameOverflow() {
        if (Checks.DEBUG) {
            APIUtil.apiLog("[WARNING] Out of frame stack space (" + this.frames.length + ") in thread: " + Thread.currentThread());
        }
        this.frames = Arrays.copyOf(this.frames, this.frames.length * 3 / 2);
    }

    public MemoryStack pop() {
        this.pointer = this.frames[--this.frameIndex];
        return this;
    }

    @Override
    public void close() {
        this.pop();
    }

    public long getAddress() {
        return this.address;
    }

    public int getSize() {
        return this.size;
    }

    public int getFrameIndex() {
        return this.frameIndex;
    }

    public long getPointerAddress() {
        return this.address + ((long)this.pointer & 0xFFFFFFFFL);
    }

    public int getPointer() {
        return this.pointer;
    }

    public void setPointer(int pointer) {
        if (Checks.CHECKS) {
            this.checkPointer(pointer);
        }
        this.pointer = pointer;
    }

    private void checkPointer(int pointer) {
        if (pointer < 0 || this.size < pointer) {
            throw new IndexOutOfBoundsException("Invalid stack pointer");
        }
    }

    private static void checkAlignment(int alignment) {
        if (Integer.bitCount(alignment) != 1) {
            throw new IllegalArgumentException("Alignment must be a power-of-two value.");
        }
    }

    public long nmalloc(int size) {
        return this.nmalloc(1, size);
    }

    public long nmalloc(int alignment, int size) {
        long address = this.address + (long)this.pointer - (long)size & (Integer.toUnsignedLong(alignment - 1) ^ 0xFFFFFFFFFFFFFFFFL);
        this.pointer = (int)(address - this.address);
        if (Checks.CHECKS && this.pointer < 0) {
            throw new OutOfMemoryError("Out of stack space.");
        }
        return address;
    }

    public long ncalloc(int alignment, int num, int size) {
        int bytes = num * size;
        long address = this.nmalloc(alignment, bytes);
        MemoryUtil.memSet(address, 0, bytes);
        return address;
    }

    public ByteBuffer malloc(int alignment, int size) {
        if (Checks.DEBUG) {
            MemoryStack.checkAlignment(alignment);
        }
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, this.nmalloc(alignment, size), size).order(MemoryUtil.NATIVE_ORDER);
    }

    public ByteBuffer calloc(int alignment, int size) {
        if (Checks.DEBUG) {
            MemoryStack.checkAlignment(alignment);
        }
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, this.ncalloc(alignment, size, 1), size).order(MemoryUtil.NATIVE_ORDER);
    }

    public ByteBuffer malloc(int size) {
        return this.malloc(1, size);
    }

    public ByteBuffer calloc(int size) {
        return this.calloc(1, size);
    }

    public ByteBuffer bytes(byte x) {
        return this.malloc(1, 1).put(0, x);
    }

    public ByteBuffer bytes(byte x, byte y) {
        return this.malloc(1, 2).put(0, x).put(1, y);
    }

    public ByteBuffer bytes(byte x, byte y, byte z) {
        return this.malloc(1, 3).put(0, x).put(1, y).put(2, z);
    }

    public ByteBuffer bytes(byte x, byte y, byte z, byte w) {
        return this.malloc(1, 4).put(0, x).put(1, y).put(2, z).put(3, w);
    }

    public ByteBuffer bytes(byte ... values) {
        ByteBuffer buffer = this.malloc(1, values.length).put(values);
        buffer.flip();
        return buffer;
    }

    public ShortBuffer mallocShort(int size) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_SHORT, this.nmalloc(2, size << 1), size);
    }

    public ShortBuffer callocShort(int size) {
        int bytes = size * 2;
        long address = this.nmalloc(2, bytes);
        MemoryUtil.memSet(address, 0, bytes);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_SHORT, address, size);
    }

    public ShortBuffer shorts(short x) {
        return this.mallocShort(1).put(0, x);
    }

    public ShortBuffer shorts(short x, short y) {
        return this.mallocShort(2).put(0, x).put(1, y);
    }

    public ShortBuffer shorts(short x, short y, short z) {
        return this.mallocShort(3).put(0, x).put(1, y).put(2, z);
    }

    public ShortBuffer shorts(short x, short y, short z, short w) {
        return this.mallocShort(4).put(0, x).put(1, y).put(2, z).put(3, w);
    }

    public ShortBuffer shorts(short ... values) {
        ShortBuffer buffer = this.mallocShort(values.length).put(values);
        buffer.flip();
        return buffer;
    }

    public IntBuffer mallocInt(int size) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_INT, this.nmalloc(4, size << 2), size);
    }

    public IntBuffer callocInt(int size) {
        int bytes = size * 4;
        long address = this.nmalloc(4, bytes);
        MemoryUtil.memSet(address, 0, bytes);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_INT, address, size);
    }

    public IntBuffer ints(int x) {
        return this.mallocInt(1).put(0, x);
    }

    public IntBuffer ints(int x, int y) {
        return this.mallocInt(2).put(0, x).put(1, y);
    }

    public IntBuffer ints(int x, int y, int z) {
        return this.mallocInt(3).put(0, x).put(1, y).put(2, z);
    }

    public IntBuffer ints(int x, int y, int z, int w) {
        return this.mallocInt(4).put(0, x).put(1, y).put(2, z).put(3, w);
    }

    public IntBuffer ints(int ... values) {
        IntBuffer buffer = this.mallocInt(values.length).put(values);
        buffer.flip();
        return buffer;
    }

    public LongBuffer mallocLong(int size) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_LONG, this.nmalloc(8, size << 3), size);
    }

    public LongBuffer callocLong(int size) {
        int bytes = size * 8;
        long address = this.nmalloc(8, bytes);
        MemoryUtil.memSet(address, 0, bytes);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_LONG, address, size);
    }

    public LongBuffer longs(long x) {
        return this.mallocLong(1).put(0, x);
    }

    public LongBuffer longs(long x, long y) {
        return this.mallocLong(2).put(0, x).put(1, y);
    }

    public LongBuffer longs(long x, long y, long z) {
        return this.mallocLong(3).put(0, x).put(1, y).put(2, z);
    }

    public LongBuffer longs(long x, long y, long z, long w) {
        return this.mallocLong(4).put(0, x).put(1, y).put(2, z).put(3, w);
    }

    public LongBuffer longs(long ... more) {
        LongBuffer buffer = this.mallocLong(more.length).put(more);
        buffer.flip();
        return buffer;
    }

    public CLongBuffer mallocCLong(int size) {
        return MemoryStack.wrap(CLongBuffer.class, this.nmalloc(CLONG_SIZE, size << CLONG_SHIFT), size);
    }

    public CLongBuffer callocCLong(int size) {
        int bytes = size * CLONG_SIZE;
        long address = this.nmalloc(CLONG_SIZE, bytes);
        MemoryUtil.memSet(address, 0, bytes);
        return MemoryStack.wrap(CLongBuffer.class, address, size);
    }

    public CLongBuffer clongs(long x) {
        return this.mallocCLong(1).put(0, x);
    }

    public CLongBuffer clongs(long x, long y) {
        return this.mallocCLong(2).put(0, x).put(1, y);
    }

    public CLongBuffer clongs(long x, long y, long z) {
        return this.mallocCLong(3).put(0, x).put(1, y).put(2, z);
    }

    public CLongBuffer clongs(long x, long y, long z, long w) {
        return this.mallocCLong(4).put(0, x).put(1, y).put(2, z).put(3, w);
    }

    public CLongBuffer clongs(long ... values) {
        CLongBuffer buffer = this.mallocCLong(values.length).put(values);
        buffer.flip();
        return buffer;
    }

    public FloatBuffer mallocFloat(int size) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_FLOAT, this.nmalloc(4, size << 2), size);
    }

    public FloatBuffer callocFloat(int size) {
        int bytes = size * 4;
        long address = this.nmalloc(4, bytes);
        MemoryUtil.memSet(address, 0, bytes);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_FLOAT, address, size);
    }

    public FloatBuffer floats(float x) {
        return this.mallocFloat(1).put(0, x);
    }

    public FloatBuffer floats(float x, float y) {
        return this.mallocFloat(2).put(0, x).put(1, y);
    }

    public FloatBuffer floats(float x, float y, float z) {
        return this.mallocFloat(3).put(0, x).put(1, y).put(2, z);
    }

    public FloatBuffer floats(float x, float y, float z, float w) {
        return this.mallocFloat(4).put(0, x).put(1, y).put(2, z).put(3, w);
    }

    public FloatBuffer floats(float ... values) {
        FloatBuffer buffer = this.mallocFloat(values.length).put(values);
        buffer.flip();
        return buffer;
    }

    public DoubleBuffer mallocDouble(int size) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_DOUBLE, this.nmalloc(8, size << 3), size);
    }

    public DoubleBuffer callocDouble(int size) {
        int bytes = size * 8;
        long address = this.nmalloc(8, bytes);
        MemoryUtil.memSet(address, 0, bytes);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_DOUBLE, address, size);
    }

    public DoubleBuffer doubles(double x) {
        return this.mallocDouble(1).put(0, x);
    }

    public DoubleBuffer doubles(double x, double y) {
        return this.mallocDouble(2).put(0, x).put(1, y);
    }

    public DoubleBuffer doubles(double x, double y, double z) {
        return this.mallocDouble(3).put(0, x).put(1, y).put(2, z);
    }

    public DoubleBuffer doubles(double x, double y, double z, double w) {
        return this.mallocDouble(4).put(0, x).put(1, y).put(2, z).put(3, w);
    }

    public DoubleBuffer doubles(double ... values) {
        DoubleBuffer buffer = this.mallocDouble(values.length).put(values);
        buffer.flip();
        return buffer;
    }

    public PointerBuffer mallocPointer(int size) {
        return MemoryStack.wrap(PointerBuffer.class, this.nmalloc(POINTER_SIZE, size << POINTER_SHIFT), size);
    }

    public PointerBuffer callocPointer(int size) {
        int bytes = size * POINTER_SIZE;
        long address = this.nmalloc(POINTER_SIZE, bytes);
        MemoryUtil.memSet(address, 0, bytes);
        return MemoryStack.wrap(PointerBuffer.class, address, size);
    }

    public PointerBuffer pointers(long x) {
        return this.mallocPointer(1).put(0, x);
    }

    public PointerBuffer pointers(long x, long y) {
        return this.mallocPointer(2).put(0, x).put(1, y);
    }

    public PointerBuffer pointers(long x, long y, long z) {
        return this.mallocPointer(3).put(0, x).put(1, y).put(2, z);
    }

    public PointerBuffer pointers(long x, long y, long z, long w) {
        return this.mallocPointer(4).put(0, x).put(1, y).put(2, z).put(3, w);
    }

    public PointerBuffer pointers(long ... values) {
        PointerBuffer buffer = this.mallocPointer(values.length).put(values);
        buffer.flip();
        return buffer;
    }

    public PointerBuffer pointers(Pointer x) {
        return this.mallocPointer(1).put(0, x);
    }

    public PointerBuffer pointers(Pointer x, Pointer y) {
        return this.mallocPointer(2).put(0, x).put(1, y);
    }

    public PointerBuffer pointers(Pointer x, Pointer y, Pointer z) {
        return this.mallocPointer(3).put(0, x).put(1, y).put(2, z);
    }

    public PointerBuffer pointers(Pointer x, Pointer y, Pointer z, Pointer w) {
        return this.mallocPointer(4).put(0, x).put(1, y).put(2, z).put(3, w);
    }

    public PointerBuffer pointers(Pointer ... values) {
        PointerBuffer buffer = this.mallocPointer(values.length);
        for (int i = 0; i < values.length; ++i) {
            buffer.put(i, values[i]);
        }
        return buffer;
    }

    public PointerBuffer pointers(Buffer x) {
        return this.mallocPointer(1).put(0, MemoryUtil.memAddress(x));
    }

    public PointerBuffer pointers(Buffer x, Buffer y) {
        return this.mallocPointer(2).put(0, MemoryUtil.memAddress(x)).put(1, MemoryUtil.memAddress(y));
    }

    public PointerBuffer pointers(Buffer x, Buffer y, Buffer z) {
        return this.mallocPointer(3).put(0, MemoryUtil.memAddress(x)).put(1, MemoryUtil.memAddress(y)).put(2, MemoryUtil.memAddress(z));
    }

    public PointerBuffer pointers(Buffer x, Buffer y, Buffer z, Buffer w) {
        return this.mallocPointer(4).put(0, MemoryUtil.memAddress(x)).put(1, MemoryUtil.memAddress(y)).put(2, MemoryUtil.memAddress(z)).put(3, MemoryUtil.memAddress(w));
    }

    public PointerBuffer pointers(Buffer ... values) {
        PointerBuffer buffer = this.mallocPointer(values.length);
        for (int i = 0; i < values.length; ++i) {
            buffer.put(i, MemoryUtil.memAddress(values[i]));
        }
        return buffer;
    }

    public ByteBuffer ASCII(CharSequence text) {
        return this.ASCII(text, true);
    }

    public ByteBuffer ASCII(CharSequence text, boolean nullTerminated) {
        int length = MemoryUtil.memLengthASCII(text, nullTerminated);
        long target = this.nmalloc(1, length);
        MemoryUtil.encodeASCII(text, nullTerminated, target);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, target, length).order(MemoryUtil.NATIVE_ORDER);
    }

    public int nASCII(CharSequence text, boolean nullTerminated) {
        return MemoryUtil.encodeASCII(text, nullTerminated, this.nmalloc(1, MemoryUtil.memLengthASCII(text, nullTerminated)));
    }

    @Nullable
    public ByteBuffer ASCIISafe(@Nullable CharSequence text) {
        return this.ASCIISafe(text, true);
    }

    @Nullable
    public ByteBuffer ASCIISafe(@Nullable CharSequence text, boolean nullTerminated) {
        return text == null ? null : this.ASCII(text, nullTerminated);
    }

    public int nASCIISafe(@Nullable CharSequence text, boolean nullTerminated) {
        return text == null ? 0 : this.nASCII(text, nullTerminated);
    }

    public ByteBuffer UTF8(CharSequence text) {
        return this.UTF8(text, true);
    }

    public ByteBuffer UTF8(CharSequence text, boolean nullTerminated) {
        int length = MemoryUtil.memLengthUTF8(text, nullTerminated);
        long target = this.nmalloc(1, length);
        MemoryUtil.encodeUTF8(text, nullTerminated, target);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, target, length).order(MemoryUtil.NATIVE_ORDER);
    }

    public int nUTF8(CharSequence text, boolean nullTerminated) {
        return MemoryUtil.encodeUTF8(text, nullTerminated, this.nmalloc(1, MemoryUtil.memLengthUTF8(text, nullTerminated)));
    }

    @Nullable
    public ByteBuffer UTF8Safe(@Nullable CharSequence text) {
        return this.UTF8Safe(text, true);
    }

    @Nullable
    public ByteBuffer UTF8Safe(@Nullable CharSequence text, boolean nullTerminated) {
        return text == null ? null : this.UTF8(text, nullTerminated);
    }

    public int nUTF8Safe(@Nullable CharSequence text, boolean nullTerminated) {
        return text == null ? 0 : this.nUTF8(text, nullTerminated);
    }

    public ByteBuffer UTF16(CharSequence text) {
        return this.UTF16(text, true);
    }

    public ByteBuffer UTF16(CharSequence text, boolean nullTerminated) {
        int length = MemoryUtil.memLengthUTF16(text, nullTerminated);
        long target = this.nmalloc(2, length);
        MemoryUtil.encodeUTF16(text, nullTerminated, target);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, target, length).order(MemoryUtil.NATIVE_ORDER);
    }

    public int nUTF16(CharSequence text, boolean nullTerminated) {
        return MemoryUtil.encodeUTF16(text, nullTerminated, this.nmalloc(2, MemoryUtil.memLengthUTF16(text, nullTerminated)));
    }

    @Nullable
    public ByteBuffer UTF16Safe(@Nullable CharSequence text) {
        return this.UTF16Safe(text, true);
    }

    @Nullable
    public ByteBuffer UTF16Safe(@Nullable CharSequence text, boolean nullTerminated) {
        return text == null ? null : this.UTF16(text, nullTerminated);
    }

    public int nUTF16Safe(@Nullable CharSequence text, boolean nullTerminated) {
        return text == null ? 0 : this.nUTF16(text, nullTerminated);
    }

    public static MemoryStack stackGet() {
        return TLS.get();
    }

    public static MemoryStack stackPush() {
        return MemoryStack.stackGet().push();
    }

    public static MemoryStack stackPop() {
        return MemoryStack.stackGet().pop();
    }

    public static long nstackMalloc(int size) {
        return MemoryStack.stackGet().nmalloc(size);
    }

    public static long nstackMalloc(int alignment, int size) {
        return MemoryStack.stackGet().nmalloc(alignment, size);
    }

    public static long nstackCalloc(int alignment, int num, int size) {
        return MemoryStack.stackGet().ncalloc(alignment, num, size);
    }

    public static ByteBuffer stackMalloc(int size) {
        return MemoryStack.stackGet().malloc(size);
    }

    public static ByteBuffer stackCalloc(int size) {
        return MemoryStack.stackGet().calloc(size);
    }

    public static ByteBuffer stackBytes(byte x) {
        return MemoryStack.stackGet().bytes(x);
    }

    public static ByteBuffer stackBytes(byte x, byte y) {
        return MemoryStack.stackGet().bytes(x, y);
    }

    public static ByteBuffer stackBytes(byte x, byte y, byte z) {
        return MemoryStack.stackGet().bytes(x, y, z);
    }

    public static ByteBuffer stackBytes(byte x, byte y, byte z, byte w) {
        return MemoryStack.stackGet().bytes(x, y, z, w);
    }

    public static ByteBuffer stackBytes(byte ... values) {
        return MemoryStack.stackGet().bytes(values);
    }

    public static ShortBuffer stackMallocShort(int size) {
        return MemoryStack.stackGet().mallocShort(size);
    }

    public static ShortBuffer stackCallocShort(int size) {
        return MemoryStack.stackGet().callocShort(size);
    }

    public static ShortBuffer stackShorts(short x) {
        return MemoryStack.stackGet().shorts(x);
    }

    public static ShortBuffer stackShorts(short x, short y) {
        return MemoryStack.stackGet().shorts(x, y);
    }

    public static ShortBuffer stackShorts(short x, short y, short z) {
        return MemoryStack.stackGet().shorts(x, y, z);
    }

    public static ShortBuffer stackShorts(short x, short y, short z, short w) {
        return MemoryStack.stackGet().shorts(x, y, z, w);
    }

    public static ShortBuffer stackShorts(short ... values) {
        return MemoryStack.stackGet().shorts(values);
    }

    public static IntBuffer stackMallocInt(int size) {
        return MemoryStack.stackGet().mallocInt(size);
    }

    public static IntBuffer stackCallocInt(int size) {
        return MemoryStack.stackGet().callocInt(size);
    }

    public static IntBuffer stackInts(int x) {
        return MemoryStack.stackGet().ints(x);
    }

    public static IntBuffer stackInts(int x, int y) {
        return MemoryStack.stackGet().ints(x, y);
    }

    public static IntBuffer stackInts(int x, int y, int z) {
        return MemoryStack.stackGet().ints(x, y, z);
    }

    public static IntBuffer stackInts(int x, int y, int z, int w) {
        return MemoryStack.stackGet().ints(x, y, z, w);
    }

    public static IntBuffer stackInts(int ... values) {
        return MemoryStack.stackGet().ints(values);
    }

    public static LongBuffer stackMallocLong(int size) {
        return MemoryStack.stackGet().mallocLong(size);
    }

    public static LongBuffer stackCallocLong(int size) {
        return MemoryStack.stackGet().callocLong(size);
    }

    public static LongBuffer stackLongs(long x) {
        return MemoryStack.stackGet().longs(x);
    }

    public static LongBuffer stackLongs(long x, long y) {
        return MemoryStack.stackGet().longs(x, y);
    }

    public static LongBuffer stackLongs(long x, long y, long z) {
        return MemoryStack.stackGet().longs(x, y, z);
    }

    public static LongBuffer stackLongs(long x, long y, long z, long w) {
        return MemoryStack.stackGet().longs(x, y, z, w);
    }

    public static LongBuffer stackLongs(long ... values) {
        return MemoryStack.stackGet().longs(values);
    }

    public static CLongBuffer stackMallocCLong(int size) {
        return MemoryStack.stackGet().mallocCLong(size);
    }

    public static CLongBuffer stackCallocCLong(int size) {
        return MemoryStack.stackGet().callocCLong(size);
    }

    public static CLongBuffer stackCLongs(long x) {
        return MemoryStack.stackGet().clongs(x);
    }

    public static CLongBuffer stackCLongs(long x, long y) {
        return MemoryStack.stackGet().clongs(x, y);
    }

    public static CLongBuffer stackCLongs(long x, long y, long z) {
        return MemoryStack.stackGet().clongs(x, y, z);
    }

    public static CLongBuffer stackCLongs(long x, long y, long z, long w) {
        return MemoryStack.stackGet().clongs(x, y, z, w);
    }

    public static CLongBuffer stackCLongs(long ... values) {
        return MemoryStack.stackGet().clongs(values);
    }

    public static FloatBuffer stackMallocFloat(int size) {
        return MemoryStack.stackGet().mallocFloat(size);
    }

    public static FloatBuffer stackCallocFloat(int size) {
        return MemoryStack.stackGet().callocFloat(size);
    }

    public static FloatBuffer stackFloats(float x) {
        return MemoryStack.stackGet().floats(x);
    }

    public static FloatBuffer stackFloats(float x, float y) {
        return MemoryStack.stackGet().floats(x, y);
    }

    public static FloatBuffer stackFloats(float x, float y, float z) {
        return MemoryStack.stackGet().floats(x, y, z);
    }

    public static FloatBuffer stackFloats(float x, float y, float z, float w) {
        return MemoryStack.stackGet().floats(x, y, z, w);
    }

    public static FloatBuffer stackFloats(float ... values) {
        return MemoryStack.stackGet().floats(values);
    }

    public static DoubleBuffer stackMallocDouble(int size) {
        return MemoryStack.stackGet().mallocDouble(size);
    }

    public static DoubleBuffer stackCallocDouble(int size) {
        return MemoryStack.stackGet().callocDouble(size);
    }

    public static DoubleBuffer stackDoubles(double x) {
        return MemoryStack.stackGet().doubles(x);
    }

    public static DoubleBuffer stackDoubles(double x, double y) {
        return MemoryStack.stackGet().doubles(x, y);
    }

    public static DoubleBuffer stackDoubles(double x, double y, double z) {
        return MemoryStack.stackGet().doubles(x, y, z);
    }

    public static DoubleBuffer stackDoubles(double x, double y, double z, double w) {
        return MemoryStack.stackGet().doubles(x, y, z, w);
    }

    public static DoubleBuffer stackDoubles(double ... values) {
        return MemoryStack.stackGet().doubles(values);
    }

    public static PointerBuffer stackMallocPointer(int size) {
        return MemoryStack.stackGet().mallocPointer(size);
    }

    public static PointerBuffer stackCallocPointer(int size) {
        return MemoryStack.stackGet().callocPointer(size);
    }

    public static PointerBuffer stackPointers(long x) {
        return MemoryStack.stackGet().pointers(x);
    }

    public static PointerBuffer stackPointers(long x, long y) {
        return MemoryStack.stackGet().pointers(x, y);
    }

    public static PointerBuffer stackPointers(long x, long y, long z) {
        return MemoryStack.stackGet().pointers(x, y, z);
    }

    public static PointerBuffer stackPointers(long x, long y, long z, long w) {
        return MemoryStack.stackGet().pointers(x, y, z, w);
    }

    public static PointerBuffer stackPointers(long ... values) {
        return MemoryStack.stackGet().pointers(values);
    }

    public static PointerBuffer stackPointers(Pointer x) {
        return MemoryStack.stackGet().pointers(x);
    }

    public static PointerBuffer stackPointers(Pointer x, Pointer y) {
        return MemoryStack.stackGet().pointers(x, y);
    }

    public static PointerBuffer stackPointers(Pointer x, Pointer y, Pointer z) {
        return MemoryStack.stackGet().pointers(x, y, z);
    }

    public static PointerBuffer stackPointers(Pointer x, Pointer y, Pointer z, Pointer w) {
        return MemoryStack.stackGet().pointers(x, y, z, w);
    }

    public static PointerBuffer stackPointers(Pointer ... values) {
        return MemoryStack.stackGet().pointers(values);
    }

    public static ByteBuffer stackASCII(CharSequence text) {
        return MemoryStack.stackGet().ASCII(text);
    }

    public static ByteBuffer stackASCII(CharSequence text, boolean nullTerminated) {
        return MemoryStack.stackGet().ASCII(text, nullTerminated);
    }

    public static ByteBuffer stackUTF8(CharSequence text) {
        return MemoryStack.stackGet().UTF8(text);
    }

    public static ByteBuffer stackUTF8(CharSequence text, boolean nullTerminated) {
        return MemoryStack.stackGet().UTF8(text, nullTerminated);
    }

    public static ByteBuffer stackUTF16(CharSequence text) {
        return MemoryStack.stackGet().UTF16(text);
    }

    public static ByteBuffer stackUTF16(CharSequence text, boolean nullTerminated) {
        return MemoryStack.stackGet().UTF16(text, nullTerminated);
    }

    @Nullable
    public static ByteBuffer stackASCIISafe(@Nullable CharSequence text) {
        return MemoryStack.stackGet().ASCIISafe(text);
    }

    @Nullable
    public static ByteBuffer stackASCIISafe(@Nullable CharSequence text, boolean nullTerminated) {
        return MemoryStack.stackGet().ASCIISafe(text, nullTerminated);
    }

    @Nullable
    public static ByteBuffer stackUTF8Safe(@Nullable CharSequence text) {
        return MemoryStack.stackGet().UTF8Safe(text);
    }

    @Nullable
    public static ByteBuffer stackUTF8Safe(@Nullable CharSequence text, boolean nullTerminated) {
        return MemoryStack.stackGet().UTF8Safe(text, nullTerminated);
    }

    @Nullable
    public static ByteBuffer stackUTF16Safe(@Nullable CharSequence text) {
        return MemoryStack.stackGet().UTF16Safe(text);
    }

    @Nullable
    public static ByteBuffer stackUTF16Safe(@Nullable CharSequence text, boolean nullTerminated) {
        return MemoryStack.stackGet().UTF16Safe(text, nullTerminated);
    }

    static {
        if (DEFAULT_STACK_SIZE < 0) {
            throw new IllegalStateException("Invalid stack size.");
        }
    }

    private static class DebugMemoryStack
    extends MemoryStack {
        private Object[] debugFrames = new Object[8];

        DebugMemoryStack(@Nullable ByteBuffer buffer, long address, int size) {
            super(buffer, address, size);
        }

        @Override
        public MemoryStack push() {
            if (this.frameIndex == this.debugFrames.length) {
                this.frameOverflow();
            }
            this.debugFrames[this.frameIndex] = StackWalkUtil.stackWalkGetMethod(MemoryStack.class);
            return super.push();
        }

        @Override
        private void frameOverflow() {
            this.debugFrames = Arrays.copyOf(this.debugFrames, this.debugFrames.length * 3 / 2);
        }

        @Override
        public MemoryStack pop() {
            Object pushed = this.debugFrames[this.frameIndex - 1];
            Object popped = StackWalkUtil.stackWalkCheckPop(MemoryStack.class, pushed);
            if (popped != null) {
                DebugMemoryStack.reportAsymmetricPop(pushed, popped);
            }
            this.debugFrames[this.frameIndex - 1] = null;
            return super.pop();
        }

        private static void reportAsymmetricPop(Object pushed, Object popped) {
            APIUtil.DEBUG_STREAM.format("[LWJGL] Asymmetric pop detected:\n\tPUSHED: %s\n\tPOPPED: %s\n\tTHREAD: %s\n", pushed.toString(), popped.toString(), Thread.currentThread());
        }
    }
}

