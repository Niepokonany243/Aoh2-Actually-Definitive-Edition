/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTStaticBuffer {
    protected EXTStaticBuffer() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(ALCapabilities caps) {
        return Checks.checkFunctions(caps.alBufferDataStatic);
    }

    public static void nalBufferDataStatic(int buffer, int format, long data, int len, int freq) {
        long __functionAddress = AL.getICD().alBufferDataStatic;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.invokePV(buffer, format, data, len, freq, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alBufferDataStatic(@NativeType(value="ALint") int buffer, @NativeType(value="ALenum") int format, @NativeType(value="ALvoid *") ByteBuffer data, @NativeType(value="ALsizei") int freq) {
        EXTStaticBuffer.nalBufferDataStatic(buffer, format, MemoryUtil.memAddress(data), data.remaining(), freq);
    }

    @NativeType(value="ALvoid")
    public static void alBufferDataStatic(@NativeType(value="ALint") int buffer, @NativeType(value="ALenum") int format, @NativeType(value="ALvoid *") ShortBuffer data, @NativeType(value="ALsizei") int freq) {
        EXTStaticBuffer.nalBufferDataStatic(buffer, format, MemoryUtil.memAddress(data), data.remaining() << 1, freq);
    }

    @NativeType(value="ALvoid")
    public static void alBufferDataStatic(@NativeType(value="ALint") int buffer, @NativeType(value="ALenum") int format, @NativeType(value="ALvoid *") IntBuffer data, @NativeType(value="ALsizei") int freq) {
        EXTStaticBuffer.nalBufferDataStatic(buffer, format, MemoryUtil.memAddress(data), data.remaining() << 2, freq);
    }

    @NativeType(value="ALvoid")
    public static void alBufferDataStatic(@NativeType(value="ALint") int buffer, @NativeType(value="ALenum") int format, @NativeType(value="ALvoid *") FloatBuffer data, @NativeType(value="ALsizei") int freq) {
        EXTStaticBuffer.nalBufferDataStatic(buffer, format, MemoryUtil.memAddress(data), data.remaining() << 2, freq);
    }

    @NativeType(value="ALvoid")
    public static void alBufferDataStatic(@NativeType(value="ALint") int buffer, @NativeType(value="ALenum") int format, @NativeType(value="ALvoid *") short[] data, @NativeType(value="ALsizei") int freq) {
        long __functionAddress = AL.getICD().alBufferDataStatic;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.invokePV(buffer, format, data, data.length << 1, freq, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alBufferDataStatic(@NativeType(value="ALint") int buffer, @NativeType(value="ALenum") int format, @NativeType(value="ALvoid *") int[] data, @NativeType(value="ALsizei") int freq) {
        long __functionAddress = AL.getICD().alBufferDataStatic;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.invokePV(buffer, format, data, data.length << 2, freq, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alBufferDataStatic(@NativeType(value="ALint") int buffer, @NativeType(value="ALenum") int format, @NativeType(value="ALvoid *") float[] data, @NativeType(value="ALsizei") int freq) {
        long __functionAddress = AL.getICD().alBufferDataStatic;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.invokePV(buffer, format, data, data.length << 2, freq, __functionAddress);
    }
}

