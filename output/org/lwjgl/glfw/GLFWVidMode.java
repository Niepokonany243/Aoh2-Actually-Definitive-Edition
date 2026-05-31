/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct GLFWvidmode")
public class GLFWVidMode
extends Struct {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int REDBITS;
    public static final int GREENBITS;
    public static final int BLUEBITS;
    public static final int REFRESHRATE;

    public GLFWVidMode(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), GLFWVidMode.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int width() {
        return GLFWVidMode.nwidth(this.address());
    }

    public int height() {
        return GLFWVidMode.nheight(this.address());
    }

    public int redBits() {
        return GLFWVidMode.nredBits(this.address());
    }

    public int greenBits() {
        return GLFWVidMode.ngreenBits(this.address());
    }

    public int blueBits() {
        return GLFWVidMode.nblueBits(this.address());
    }

    public int refreshRate() {
        return GLFWVidMode.nrefreshRate(this.address());
    }

    public static GLFWVidMode create(long address) {
        return GLFWVidMode.wrap(GLFWVidMode.class, address);
    }

    @Nullable
    public static GLFWVidMode createSafe(long address) {
        return address == 0L ? null : GLFWVidMode.wrap(GLFWVidMode.class, address);
    }

    public static Buffer create(long address, int capacity) {
        return GLFWVidMode.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : GLFWVidMode.wrap(Buffer.class, address, capacity);
    }

    public static int nwidth(long struct) {
        return UNSAFE.getInt(null, struct + (long)WIDTH);
    }

    public static int nheight(long struct) {
        return UNSAFE.getInt(null, struct + (long)HEIGHT);
    }

    public static int nredBits(long struct) {
        return UNSAFE.getInt(null, struct + (long)REDBITS);
    }

    public static int ngreenBits(long struct) {
        return UNSAFE.getInt(null, struct + (long)GREENBITS);
    }

    public static int nblueBits(long struct) {
        return UNSAFE.getInt(null, struct + (long)BLUEBITS);
    }

    public static int nrefreshRate(long struct) {
        return UNSAFE.getInt(null, struct + (long)REFRESHRATE);
    }

    static {
        Struct.Layout layout = GLFWVidMode.__struct(GLFWVidMode.__member(4), GLFWVidMode.__member(4), GLFWVidMode.__member(4), GLFWVidMode.__member(4), GLFWVidMode.__member(4), GLFWVidMode.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        WIDTH = layout.offsetof(0);
        HEIGHT = layout.offsetof(1);
        REDBITS = layout.offsetof(2);
        GREENBITS = layout.offsetof(3);
        BLUEBITS = layout.offsetof(4);
        REFRESHRATE = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<GLFWVidMode, Buffer> {
        private static final GLFWVidMode ELEMENT_FACTORY = GLFWVidMode.create(-1L);

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
        protected GLFWVidMode getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int width() {
            return GLFWVidMode.nwidth(this.address());
        }

        public int height() {
            return GLFWVidMode.nheight(this.address());
        }

        public int redBits() {
            return GLFWVidMode.nredBits(this.address());
        }

        public int greenBits() {
            return GLFWVidMode.ngreenBits(this.address());
        }

        public int blueBits() {
            return GLFWVidMode.nblueBits(this.address());
        }

        public int refreshRate() {
            return GLFWVidMode.nrefreshRate(this.address());
        }
    }
}

