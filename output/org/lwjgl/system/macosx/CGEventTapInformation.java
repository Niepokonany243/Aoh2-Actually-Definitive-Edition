/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class CGEventTapInformation
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int EVENTTAPID;
    public static final int TAPPOINT;
    public static final int OPTIONS;
    public static final int EVENTSOFINTEREST;
    public static final int TAPPINGPROCESS;
    public static final int PROCESSBEINGTAPPED;
    public static final int ENABLED;
    public static final int MINUSECLATENCY;
    public static final int AVGUSECLATENCY;
    public static final int MAXUSECLATENCY;

    public CGEventTapInformation(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), CGEventTapInformation.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="uint32_t")
    public int eventTapID() {
        return CGEventTapInformation.neventTapID(this.address());
    }

    @NativeType(value="CGEventTapLocation")
    public int tapPoint() {
        return CGEventTapInformation.ntapPoint(this.address());
    }

    @NativeType(value="CGEventTapOptions")
    public int options() {
        return CGEventTapInformation.noptions(this.address());
    }

    @NativeType(value="CGEventMask")
    public long eventsOfInterest() {
        return CGEventTapInformation.neventsOfInterest(this.address());
    }

    @NativeType(value="pid_t")
    public long tappingProcess() {
        return CGEventTapInformation.ntappingProcess(this.address());
    }

    @NativeType(value="pid_t")
    public long processBeingTapped() {
        return CGEventTapInformation.nprocessBeingTapped(this.address());
    }

    @NativeType(value="bool")
    public boolean enabled() {
        return CGEventTapInformation.nenabled(this.address());
    }

    public float minUsecLatency() {
        return CGEventTapInformation.nminUsecLatency(this.address());
    }

    public float avgUsecLatency() {
        return CGEventTapInformation.navgUsecLatency(this.address());
    }

    public float maxUsecLatency() {
        return CGEventTapInformation.nmaxUsecLatency(this.address());
    }

    public static CGEventTapInformation malloc() {
        return CGEventTapInformation.wrap(CGEventTapInformation.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static CGEventTapInformation calloc() {
        return CGEventTapInformation.wrap(CGEventTapInformation.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static CGEventTapInformation create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return CGEventTapInformation.wrap(CGEventTapInformation.class, MemoryUtil.memAddress(container), container);
    }

    public static CGEventTapInformation create(long address) {
        return CGEventTapInformation.wrap(CGEventTapInformation.class, address);
    }

    @Nullable
    public static CGEventTapInformation createSafe(long address) {
        return address == 0L ? null : CGEventTapInformation.wrap(CGEventTapInformation.class, address);
    }

    public static Buffer malloc(int capacity) {
        return CGEventTapInformation.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(CGEventTapInformation.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return CGEventTapInformation.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = CGEventTapInformation.__create(capacity, SIZEOF);
        return CGEventTapInformation.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return CGEventTapInformation.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : CGEventTapInformation.wrap(Buffer.class, address, capacity);
    }

    public static CGEventTapInformation mallocStack() {
        return CGEventTapInformation.mallocStack(MemoryStack.stackGet());
    }

    public static CGEventTapInformation callocStack() {
        return CGEventTapInformation.callocStack(MemoryStack.stackGet());
    }

    public static CGEventTapInformation mallocStack(MemoryStack stack) {
        return CGEventTapInformation.wrap(CGEventTapInformation.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static CGEventTapInformation callocStack(MemoryStack stack) {
        return CGEventTapInformation.wrap(CGEventTapInformation.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return CGEventTapInformation.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return CGEventTapInformation.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return CGEventTapInformation.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return CGEventTapInformation.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static int neventTapID(long struct) {
        return UNSAFE.getInt(null, struct + (long)EVENTTAPID);
    }

    public static int ntapPoint(long struct) {
        return UNSAFE.getInt(null, struct + (long)TAPPOINT);
    }

    public static int noptions(long struct) {
        return UNSAFE.getInt(null, struct + (long)OPTIONS);
    }

    public static long neventsOfInterest(long struct) {
        return UNSAFE.getLong(null, struct + (long)EVENTSOFINTEREST);
    }

    public static long ntappingProcess(long struct) {
        return MemoryUtil.memGetAddress(struct + (long)TAPPINGPROCESS);
    }

    public static long nprocessBeingTapped(long struct) {
        return MemoryUtil.memGetAddress(struct + (long)PROCESSBEINGTAPPED);
    }

    public static boolean nenabled(long struct) {
        return UNSAFE.getByte(null, struct + (long)ENABLED) != 0;
    }

    public static float nminUsecLatency(long struct) {
        return UNSAFE.getFloat(null, struct + (long)MINUSECLATENCY);
    }

    public static float navgUsecLatency(long struct) {
        return UNSAFE.getFloat(null, struct + (long)AVGUSECLATENCY);
    }

    public static float nmaxUsecLatency(long struct) {
        return UNSAFE.getFloat(null, struct + (long)MAXUSECLATENCY);
    }

    static {
        Struct.Layout layout = CGEventTapInformation.__struct(CGEventTapInformation.__member(4), CGEventTapInformation.__member(4), CGEventTapInformation.__member(4), CGEventTapInformation.__member(8), CGEventTapInformation.__member(POINTER_SIZE), CGEventTapInformation.__member(POINTER_SIZE), CGEventTapInformation.__member(1), CGEventTapInformation.__member(4), CGEventTapInformation.__member(4), CGEventTapInformation.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        EVENTTAPID = layout.offsetof(0);
        TAPPOINT = layout.offsetof(1);
        OPTIONS = layout.offsetof(2);
        EVENTSOFINTEREST = layout.offsetof(3);
        TAPPINGPROCESS = layout.offsetof(4);
        PROCESSBEINGTAPPED = layout.offsetof(5);
        ENABLED = layout.offsetof(6);
        MINUSECLATENCY = layout.offsetof(7);
        AVGUSECLATENCY = layout.offsetof(8);
        MAXUSECLATENCY = layout.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<CGEventTapInformation, Buffer>
    implements NativeResource {
        private static final CGEventTapInformation ELEMENT_FACTORY = CGEventTapInformation.create(-1L);

        public Buffer(ByteBuffer container) {
            super(container, container.remaining() / SIZEOF);
        }

        public Buffer(long address, int cap) {
            super(address, null, -1, 0, cap, cap);
        }

        Buffer(long address, @Nullable ByteBuffer container, int mark, int pos, int lim, int cap) {
            super(address, container, mark, pos, lim, cap);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected CGEventTapInformation getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="uint32_t")
        public int eventTapID() {
            return CGEventTapInformation.neventTapID(this.address());
        }

        @NativeType(value="CGEventTapLocation")
        public int tapPoint() {
            return CGEventTapInformation.ntapPoint(this.address());
        }

        @NativeType(value="CGEventTapOptions")
        public int options() {
            return CGEventTapInformation.noptions(this.address());
        }

        @NativeType(value="CGEventMask")
        public long eventsOfInterest() {
            return CGEventTapInformation.neventsOfInterest(this.address());
        }

        @NativeType(value="pid_t")
        public long tappingProcess() {
            return CGEventTapInformation.ntappingProcess(this.address());
        }

        @NativeType(value="pid_t")
        public long processBeingTapped() {
            return CGEventTapInformation.nprocessBeingTapped(this.address());
        }

        @NativeType(value="bool")
        public boolean enabled() {
            return CGEventTapInformation.nenabled(this.address());
        }

        public float minUsecLatency() {
            return CGEventTapInformation.nminUsecLatency(this.address());
        }

        public float avgUsecLatency() {
            return CGEventTapInformation.navgUsecLatency(this.address());
        }

        public float maxUsecLatency() {
            return CGEventTapInformation.nmaxUsecLatency(this.address());
        }
    }
}

