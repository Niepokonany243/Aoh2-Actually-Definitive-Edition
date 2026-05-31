/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.openal;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class AL10 {
    public static final int AL_INVALID = -1;
    public static final int AL_NONE = 0;
    public static final int AL_FALSE = 0;
    public static final int AL_TRUE = 1;
    public static final int AL_NO_ERROR = 0;
    public static final int AL_INVALID_NAME = 40961;
    public static final int AL_INVALID_ENUM = 40962;
    public static final int AL_INVALID_VALUE = 40963;
    public static final int AL_INVALID_OPERATION = 40964;
    public static final int AL_OUT_OF_MEMORY = 40965;
    public static final int AL_DOPPLER_FACTOR = 49152;
    public static final int AL_DISTANCE_MODEL = 53248;
    public static final int AL_VENDOR = 45057;
    public static final int AL_VERSION = 45058;
    public static final int AL_RENDERER = 45059;
    public static final int AL_EXTENSIONS = 45060;
    public static final int AL_INVERSE_DISTANCE = 53249;
    public static final int AL_INVERSE_DISTANCE_CLAMPED = 53250;
    public static final int AL_SOURCE_ABSOLUTE = 513;
    public static final int AL_SOURCE_RELATIVE = 514;
    public static final int AL_POSITION = 4100;
    public static final int AL_VELOCITY = 4102;
    public static final int AL_GAIN = 4106;
    public static final int AL_CONE_INNER_ANGLE = 4097;
    public static final int AL_CONE_OUTER_ANGLE = 4098;
    public static final int AL_PITCH = 4099;
    public static final int AL_DIRECTION = 4101;
    public static final int AL_LOOPING = 4103;
    public static final int AL_BUFFER = 4105;
    public static final int AL_SOURCE_STATE = 4112;
    public static final int AL_CONE_OUTER_GAIN = 4130;
    public static final int AL_SOURCE_TYPE = 4135;
    public static final int AL_INITIAL = 4113;
    public static final int AL_PLAYING = 4114;
    public static final int AL_PAUSED = 4115;
    public static final int AL_STOPPED = 4116;
    public static final int AL_ORIENTATION = 4111;
    public static final int AL_BUFFERS_QUEUED = 4117;
    public static final int AL_BUFFERS_PROCESSED = 4118;
    public static final int AL_MIN_GAIN = 4109;
    public static final int AL_MAX_GAIN = 4110;
    public static final int AL_REFERENCE_DISTANCE = 4128;
    public static final int AL_ROLLOFF_FACTOR = 4129;
    public static final int AL_MAX_DISTANCE = 4131;
    public static final int AL_FREQUENCY = 8193;
    public static final int AL_BITS = 8194;
    public static final int AL_CHANNELS = 8195;
    public static final int AL_SIZE = 8196;
    public static final int AL_FORMAT_MONO8 = 4352;
    public static final int AL_FORMAT_MONO16 = 4353;
    public static final int AL_FORMAT_STEREO8 = 4354;
    public static final int AL_FORMAT_STEREO16 = 4355;
    public static final int AL_UNUSED = 8208;
    public static final int AL_PENDING = 8209;
    public static final int AL_PROCESSED = 8210;

    protected AL10() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(ALCapabilities caps) {
        return Checks.checkFunctions(caps.alGetError, caps.alEnable, caps.alDisable, caps.alIsEnabled, caps.alGetBoolean, caps.alGetInteger, caps.alGetFloat, caps.alGetDouble, caps.alGetBooleanv, caps.alGetIntegerv, caps.alGetFloatv, caps.alGetDoublev, caps.alGetString, caps.alDistanceModel, caps.alDopplerFactor, caps.alDopplerVelocity, caps.alListenerf, caps.alListeneri, caps.alListener3f, caps.alListenerfv, caps.alGetListenerf, caps.alGetListeneri, caps.alGetListener3f, caps.alGetListenerfv, caps.alGenSources, caps.alDeleteSources, caps.alIsSource, caps.alSourcef, caps.alSource3f, caps.alSourcefv, caps.alSourcei, caps.alGetSourcef, caps.alGetSource3f, caps.alGetSourcefv, caps.alGetSourcei, caps.alGetSourceiv, caps.alSourceQueueBuffers, caps.alSourceUnqueueBuffers, caps.alSourcePlay, caps.alSourcePause, caps.alSourceStop, caps.alSourceRewind, caps.alSourcePlayv, caps.alSourcePausev, caps.alSourceStopv, caps.alSourceRewindv, caps.alGenBuffers, caps.alDeleteBuffers, caps.alIsBuffer, caps.alGetBufferf, caps.alGetBufferi, caps.alBufferData, caps.alGetEnumValue, caps.alGetProcAddress, caps.alIsExtensionPresent);
    }

    @NativeType(value="ALenum")
    public static int alGetError() {
        long __functionAddress = AL.getICD().alGetError;
        return JNI.invokeI(__functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alEnable(@NativeType(value="ALenum") int target) {
        long __functionAddress = AL.getICD().alEnable;
        JNI.invokeV(target, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alDisable(@NativeType(value="ALenum") int target) {
        long __functionAddress = AL.getICD().alDisable;
        JNI.invokeV(target, __functionAddress);
    }

    @NativeType(value="ALboolean")
    public static boolean alIsEnabled(@NativeType(value="ALenum") int target) {
        long __functionAddress = AL.getICD().alIsEnabled;
        return JNI.invokeZ(target, __functionAddress);
    }

    @NativeType(value="ALboolean")
    public static boolean alGetBoolean(@NativeType(value="ALenum") int paramName) {
        long __functionAddress = AL.getICD().alGetBoolean;
        return JNI.invokeZ(paramName, __functionAddress);
    }

    @NativeType(value="ALint")
    public static int alGetInteger(@NativeType(value="ALenum") int paramName) {
        long __functionAddress = AL.getICD().alGetInteger;
        return JNI.invokeI(paramName, __functionAddress);
    }

    @NativeType(value="ALfloat")
    public static float alGetFloat(@NativeType(value="ALenum") int paramName) {
        long __functionAddress = AL.getICD().alGetFloat;
        return JNI.invokeF(paramName, __functionAddress);
    }

    @NativeType(value="ALdouble")
    public static double alGetDouble(@NativeType(value="ALenum") int paramName) {
        long __functionAddress = AL.getICD().alGetDouble;
        return JNI.invokeD(paramName, __functionAddress);
    }

    public static void nalGetBooleanv(int paramName, long dest) {
        long __functionAddress = AL.getICD().alGetBooleanv;
        JNI.invokePV(paramName, dest, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetBooleanv(@NativeType(value="ALenum") int paramName, @NativeType(value="ALboolean *") ByteBuffer dest) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, 1);
        }
        AL10.nalGetBooleanv(paramName, MemoryUtil.memAddress(dest));
    }

    public static void nalGetIntegerv(int paramName, long dest) {
        long __functionAddress = AL.getICD().alGetIntegerv;
        JNI.invokePV(paramName, dest, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetIntegerv(@NativeType(value="ALenum") int paramName, @NativeType(value="ALint *") IntBuffer dest) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, 1);
        }
        AL10.nalGetIntegerv(paramName, MemoryUtil.memAddress(dest));
    }

    public static void nalGetFloatv(int paramName, long dest) {
        long __functionAddress = AL.getICD().alGetFloatv;
        JNI.invokePV(paramName, dest, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetFloatv(@NativeType(value="ALenum") int paramName, @NativeType(value="ALfloat *") FloatBuffer dest) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, 1);
        }
        AL10.nalGetFloatv(paramName, MemoryUtil.memAddress(dest));
    }

    public static void nalGetDoublev(int paramName, long dest) {
        long __functionAddress = AL.getICD().alGetDoublev;
        JNI.invokePV(paramName, dest, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetDoublev(@NativeType(value="ALenum") int paramName, @NativeType(value="ALdouble *") DoubleBuffer dest) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dest, 1);
        }
        AL10.nalGetDoublev(paramName, MemoryUtil.memAddress(dest));
    }

    public static long nalGetString(int paramName) {
        long __functionAddress = AL.getICD().alGetString;
        return JNI.invokeP(paramName, __functionAddress);
    }

    @Nullable
    @NativeType(value="ALchar const *")
    public static String alGetString(@NativeType(value="ALenum") int paramName) {
        long __result = AL10.nalGetString(paramName);
        return MemoryUtil.memUTF8Safe(__result);
    }

    @NativeType(value="ALvoid")
    public static void alDistanceModel(@NativeType(value="ALenum") int modelName) {
        long __functionAddress = AL.getICD().alDistanceModel;
        JNI.invokeV(modelName, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alDopplerFactor(@NativeType(value="ALfloat") float dopplerFactor) {
        long __functionAddress = AL.getICD().alDopplerFactor;
        JNI.invokeV(dopplerFactor, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alDopplerVelocity(@NativeType(value="ALfloat") float dopplerVelocity) {
        long __functionAddress = AL.getICD().alDopplerVelocity;
        JNI.invokeV(dopplerVelocity, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alListenerf(@NativeType(value="ALenum") int paramName, @NativeType(value="ALfloat") float value) {
        long __functionAddress = AL.getICD().alListenerf;
        JNI.invokeV(paramName, value, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alListeneri(@NativeType(value="ALenum") int paramName, @NativeType(value="ALint") int values) {
        long __functionAddress = AL.getICD().alListeneri;
        JNI.invokeV(paramName, values, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alListener3f(@NativeType(value="ALenum") int paramName, @NativeType(value="ALfloat") float value1, @NativeType(value="ALfloat") float value2, @NativeType(value="ALfloat") float value3) {
        long __functionAddress = AL.getICD().alListener3f;
        JNI.invokeV(paramName, value1, value2, value3, __functionAddress);
    }

    public static void nalListenerfv(int paramName, long values) {
        long __functionAddress = AL.getICD().alListenerfv;
        JNI.invokePV(paramName, values, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alListenerfv(@NativeType(value="ALenum") int paramName, @NativeType(value="ALfloat const *") FloatBuffer values) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)values, 1);
        }
        AL10.nalListenerfv(paramName, MemoryUtil.memAddress(values));
    }

    public static void nalGetListenerf(int paramName, long value) {
        long __functionAddress = AL.getICD().alGetListenerf;
        JNI.invokePV(paramName, value, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetListenerf(@NativeType(value="ALenum") int paramName, @NativeType(value="ALfloat *") FloatBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        AL10.nalGetListenerf(paramName, MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static float alGetListenerf(@NativeType(value="ALenum") int paramName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer value = stack.callocFloat(1);
            AL10.nalGetListenerf(paramName, MemoryUtil.memAddress(value));
            float f = value.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nalGetListeneri(int paramName, long value) {
        long __functionAddress = AL.getICD().alGetListeneri;
        JNI.invokePV(paramName, value, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetListeneri(@NativeType(value="ALenum") int paramName, @NativeType(value="ALint *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        AL10.nalGetListeneri(paramName, MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static int alGetListeneri(@NativeType(value="ALenum") int paramName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer value = stack.callocInt(1);
            AL10.nalGetListeneri(paramName, MemoryUtil.memAddress(value));
            int n = value.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nalGetListener3f(int paramName, long value1, long value2, long value3) {
        long __functionAddress = AL.getICD().alGetListener3f;
        JNI.invokePPPV(paramName, value1, value2, value3, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetListener3f(@NativeType(value="ALenum") int paramName, @NativeType(value="ALfloat *") FloatBuffer value1, @NativeType(value="ALfloat *") FloatBuffer value2, @NativeType(value="ALfloat *") FloatBuffer value3) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value1, 1);
            Checks.check((Buffer)value2, 1);
            Checks.check((Buffer)value3, 1);
        }
        AL10.nalGetListener3f(paramName, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
    }

    public static void nalGetListenerfv(int paramName, long values) {
        long __functionAddress = AL.getICD().alGetListenerfv;
        JNI.invokePV(paramName, values, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetListenerfv(@NativeType(value="ALenum") int paramName, @NativeType(value="ALfloat *") FloatBuffer values) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)values, 1);
        }
        AL10.nalGetListenerfv(paramName, MemoryUtil.memAddress(values));
    }

    public static void nalGenSources(int n, long srcNames) {
        long __functionAddress = AL.getICD().alGenSources;
        JNI.invokePV(n, srcNames, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGenSources(@NativeType(value="ALuint *") IntBuffer srcNames) {
        AL10.nalGenSources(srcNames.remaining(), MemoryUtil.memAddress(srcNames));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static int alGenSources() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer srcNames = stack.callocInt(1);
            AL10.nalGenSources(1, MemoryUtil.memAddress(srcNames));
            int n = srcNames.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nalDeleteSources(int n, long sources) {
        long __functionAddress = AL.getICD().alDeleteSources;
        JNI.invokePV(n, sources, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alDeleteSources(@NativeType(value="ALuint *") IntBuffer sources) {
        AL10.nalDeleteSources(sources.remaining(), MemoryUtil.memAddress(sources));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static void alDeleteSources(@NativeType(value="ALuint *") int source) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer sources = stack.ints(source);
            AL10.nalDeleteSources(1, MemoryUtil.memAddress(sources));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="ALboolean")
    public static boolean alIsSource(@NativeType(value="ALuint") int sourceName) {
        long __functionAddress = AL.getICD().alIsSource;
        return JNI.invokeZ(sourceName, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourcef(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALfloat") float value) {
        long __functionAddress = AL.getICD().alSourcef;
        JNI.invokeV(source, param, value, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSource3f(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALfloat") float v1, @NativeType(value="ALfloat") float v2, @NativeType(value="ALfloat") float v3) {
        long __functionAddress = AL.getICD().alSource3f;
        JNI.invokeV(source, param, v1, v2, v3, __functionAddress);
    }

    public static void nalSourcefv(int source, int param, long values) {
        long __functionAddress = AL.getICD().alSourcefv;
        JNI.invokePV(source, param, values, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourcefv(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALfloat const *") FloatBuffer values) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)values, 1);
        }
        AL10.nalSourcefv(source, param, MemoryUtil.memAddress(values));
    }

    @NativeType(value="ALvoid")
    public static void alSourcei(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALint") int value) {
        long __functionAddress = AL.getICD().alSourcei;
        JNI.invokeV(source, param, value, __functionAddress);
    }

    public static void nalGetSourcef(int source, int param, long value) {
        long __functionAddress = AL.getICD().alGetSourcef;
        JNI.invokePV(source, param, value, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcef(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALfloat *") FloatBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        AL10.nalGetSourcef(source, param, MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static float alGetSourcef(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer value = stack.callocFloat(1);
            AL10.nalGetSourcef(source, param, MemoryUtil.memAddress(value));
            float f = value.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nalGetSource3f(int source, int param, long v1, long v2, long v3) {
        long __functionAddress = AL.getICD().alGetSource3f;
        JNI.invokePPPV(source, param, v1, v2, v3, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetSource3f(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALfloat *") FloatBuffer v1, @NativeType(value="ALfloat *") FloatBuffer v2, @NativeType(value="ALfloat *") FloatBuffer v3) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v1, 1);
            Checks.check((Buffer)v2, 1);
            Checks.check((Buffer)v3, 1);
        }
        AL10.nalGetSource3f(source, param, MemoryUtil.memAddress(v1), MemoryUtil.memAddress(v2), MemoryUtil.memAddress(v3));
    }

    public static void nalGetSourcefv(int source, int param, long values) {
        long __functionAddress = AL.getICD().alGetSourcefv;
        JNI.invokePV(source, param, values, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcefv(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALfloat *") FloatBuffer values) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)values, 1);
        }
        AL10.nalGetSourcefv(source, param, MemoryUtil.memAddress(values));
    }

    public static void nalGetSourcei(int source, int param, long value) {
        long __functionAddress = AL.getICD().alGetSourcei;
        JNI.invokePV(source, param, value, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcei(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALint *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        AL10.nalGetSourcei(source, param, MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static int alGetSourcei(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer value = stack.callocInt(1);
            AL10.nalGetSourcei(source, param, MemoryUtil.memAddress(value));
            int n = value.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nalGetSourceiv(int source, int param, long values) {
        long __functionAddress = AL.getICD().alGetSourceiv;
        JNI.invokePV(source, param, values, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourceiv(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALint *") IntBuffer values) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)values, 1);
        }
        AL10.nalGetSourceiv(source, param, MemoryUtil.memAddress(values));
    }

    public static void nalSourceQueueBuffers(int sourceName, int numBuffers, long bufferNames) {
        long __functionAddress = AL.getICD().alSourceQueueBuffers;
        JNI.invokePV(sourceName, numBuffers, bufferNames, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourceQueueBuffers(@NativeType(value="ALuint") int sourceName, @NativeType(value="ALuint *") IntBuffer bufferNames) {
        AL10.nalSourceQueueBuffers(sourceName, bufferNames.remaining(), MemoryUtil.memAddress(bufferNames));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static void alSourceQueueBuffers(@NativeType(value="ALuint") int sourceName, @NativeType(value="ALuint *") int bufferName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer bufferNames = stack.ints(bufferName);
            AL10.nalSourceQueueBuffers(sourceName, 1, MemoryUtil.memAddress(bufferNames));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nalSourceUnqueueBuffers(int sourceName, int numEntries, long bufferNames) {
        long __functionAddress = AL.getICD().alSourceUnqueueBuffers;
        JNI.invokePV(sourceName, numEntries, bufferNames, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourceUnqueueBuffers(@NativeType(value="ALuint") int sourceName, @NativeType(value="ALuint *") IntBuffer bufferNames) {
        AL10.nalSourceUnqueueBuffers(sourceName, bufferNames.remaining(), MemoryUtil.memAddress(bufferNames));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static int alSourceUnqueueBuffers(@NativeType(value="ALuint") int sourceName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer bufferNames = stack.callocInt(1);
            AL10.nalSourceUnqueueBuffers(sourceName, 1, MemoryUtil.memAddress(bufferNames));
            int n = bufferNames.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="ALvoid")
    public static void alSourcePlay(@NativeType(value="ALuint") int source) {
        long __functionAddress = AL.getICD().alSourcePlay;
        JNI.invokeV(source, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourcePause(@NativeType(value="ALuint") int source) {
        long __functionAddress = AL.getICD().alSourcePause;
        JNI.invokeV(source, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourceStop(@NativeType(value="ALuint") int source) {
        long __functionAddress = AL.getICD().alSourceStop;
        JNI.invokeV(source, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourceRewind(@NativeType(value="ALuint") int source) {
        long __functionAddress = AL.getICD().alSourceRewind;
        JNI.invokeV(source, __functionAddress);
    }

    public static void nalSourcePlayv(int n, long sources) {
        long __functionAddress = AL.getICD().alSourcePlayv;
        JNI.invokePV(n, sources, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourcePlayv(@NativeType(value="ALuint const *") IntBuffer sources) {
        AL10.nalSourcePlayv(sources.remaining(), MemoryUtil.memAddress(sources));
    }

    public static void nalSourcePausev(int n, long sources) {
        long __functionAddress = AL.getICD().alSourcePausev;
        JNI.invokePV(n, sources, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourcePausev(@NativeType(value="ALuint const *") IntBuffer sources) {
        AL10.nalSourcePausev(sources.remaining(), MemoryUtil.memAddress(sources));
    }

    public static void nalSourceStopv(int n, long sources) {
        long __functionAddress = AL.getICD().alSourceStopv;
        JNI.invokePV(n, sources, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourceStopv(@NativeType(value="ALuint const *") IntBuffer sources) {
        AL10.nalSourceStopv(sources.remaining(), MemoryUtil.memAddress(sources));
    }

    public static void nalSourceRewindv(int n, long sources) {
        long __functionAddress = AL.getICD().alSourceRewindv;
        JNI.invokePV(n, sources, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourceRewindv(@NativeType(value="ALuint const *") IntBuffer sources) {
        AL10.nalSourceRewindv(sources.remaining(), MemoryUtil.memAddress(sources));
    }

    public static void nalGenBuffers(int n, long bufferNames) {
        long __functionAddress = AL.getICD().alGenBuffers;
        JNI.invokePV(n, bufferNames, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGenBuffers(@NativeType(value="ALuint *") IntBuffer bufferNames) {
        AL10.nalGenBuffers(bufferNames.remaining(), MemoryUtil.memAddress(bufferNames));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static int alGenBuffers() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer bufferNames = stack.callocInt(1);
            AL10.nalGenBuffers(1, MemoryUtil.memAddress(bufferNames));
            int n = bufferNames.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nalDeleteBuffers(int n, long bufferNames) {
        long __functionAddress = AL.getICD().alDeleteBuffers;
        JNI.invokePV(n, bufferNames, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alDeleteBuffers(@NativeType(value="ALuint const *") IntBuffer bufferNames) {
        AL10.nalDeleteBuffers(bufferNames.remaining(), MemoryUtil.memAddress(bufferNames));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static void alDeleteBuffers(@NativeType(value="ALuint const *") int bufferName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer bufferNames = stack.ints(bufferName);
            AL10.nalDeleteBuffers(1, MemoryUtil.memAddress(bufferNames));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="ALboolean")
    public static boolean alIsBuffer(@NativeType(value="ALuint") int bufferName) {
        long __functionAddress = AL.getICD().alIsBuffer;
        return JNI.invokeZ(bufferName, __functionAddress);
    }

    public static void nalGetBufferf(int bufferName, int paramName, long value) {
        long __functionAddress = AL.getICD().alGetBufferf;
        JNI.invokePV(bufferName, paramName, value, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferf(@NativeType(value="ALuint") int bufferName, @NativeType(value="ALenum") int paramName, @NativeType(value="ALfloat *") FloatBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        AL10.nalGetBufferf(bufferName, paramName, MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static float alGetBufferf(@NativeType(value="ALuint") int bufferName, @NativeType(value="ALenum") int paramName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer value = stack.callocFloat(1);
            AL10.nalGetBufferf(bufferName, paramName, MemoryUtil.memAddress(value));
            float f = value.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nalGetBufferi(int bufferName, int paramName, long value) {
        long __functionAddress = AL.getICD().alGetBufferi;
        JNI.invokePV(bufferName, paramName, value, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferi(@NativeType(value="ALuint") int bufferName, @NativeType(value="ALenum") int paramName, @NativeType(value="ALint *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        AL10.nalGetBufferi(bufferName, paramName, MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static int alGetBufferi(@NativeType(value="ALuint") int bufferName, @NativeType(value="ALenum") int paramName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer value = stack.callocInt(1);
            AL10.nalGetBufferi(bufferName, paramName, MemoryUtil.memAddress(value));
            int n = value.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nalBufferData(int bufferName, int format, long data, int size, int frequency) {
        long __functionAddress = AL.getICD().alBufferData;
        JNI.invokePV(bufferName, format, data, size, frequency, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alBufferData(@NativeType(value="ALuint") int bufferName, @NativeType(value="ALenum") int format, @NativeType(value="ALvoid const *") ByteBuffer data, @NativeType(value="ALsizei") int frequency) {
        AL10.nalBufferData(bufferName, format, MemoryUtil.memAddress(data), data.remaining(), frequency);
    }

    @NativeType(value="ALvoid")
    public static void alBufferData(@NativeType(value="ALuint") int bufferName, @NativeType(value="ALenum") int format, @NativeType(value="ALvoid const *") ShortBuffer data, @NativeType(value="ALsizei") int frequency) {
        AL10.nalBufferData(bufferName, format, MemoryUtil.memAddress(data), data.remaining() << 1, frequency);
    }

    @NativeType(value="ALvoid")
    public static void alBufferData(@NativeType(value="ALuint") int bufferName, @NativeType(value="ALenum") int format, @NativeType(value="ALvoid const *") IntBuffer data, @NativeType(value="ALsizei") int frequency) {
        AL10.nalBufferData(bufferName, format, MemoryUtil.memAddress(data), data.remaining() << 2, frequency);
    }

    @NativeType(value="ALvoid")
    public static void alBufferData(@NativeType(value="ALuint") int bufferName, @NativeType(value="ALenum") int format, @NativeType(value="ALvoid const *") FloatBuffer data, @NativeType(value="ALsizei") int frequency) {
        AL10.nalBufferData(bufferName, format, MemoryUtil.memAddress(data), data.remaining() << 2, frequency);
    }

    public static int nalGetEnumValue(long enumName) {
        long __functionAddress = AL.getICD().alGetEnumValue;
        return JNI.invokePI(enumName, __functionAddress);
    }

    @NativeType(value="ALuint")
    public static int alGetEnumValue(@NativeType(value="ALchar const *") ByteBuffer enumName) {
        if (Checks.CHECKS) {
            Checks.checkNT1(enumName);
        }
        return AL10.nalGetEnumValue(MemoryUtil.memAddress(enumName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALuint")
    public static int alGetEnumValue(@NativeType(value="ALchar const *") CharSequence enumName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(enumName, true);
            long enumNameEncoded = stack.getPointerAddress();
            int n = AL10.nalGetEnumValue(enumNameEncoded);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nalGetProcAddress(long funcName) {
        long __functionAddress = AL.getICD().alGetProcAddress;
        return JNI.invokePP(funcName, __functionAddress);
    }

    @NativeType(value="void *")
    public static long alGetProcAddress(@NativeType(value="ALchar const *") ByteBuffer funcName) {
        if (Checks.CHECKS) {
            Checks.checkNT1(funcName);
        }
        return AL10.nalGetProcAddress(MemoryUtil.memAddress(funcName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void *")
    public static long alGetProcAddress(@NativeType(value="ALchar const *") CharSequence funcName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(funcName, true);
            long funcNameEncoded = stack.getPointerAddress();
            long l = AL10.nalGetProcAddress(funcNameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static boolean nalIsExtensionPresent(long extName) {
        long __functionAddress = AL.getICD().alIsExtensionPresent;
        return JNI.invokePZ(extName, __functionAddress);
    }

    @NativeType(value="ALCboolean")
    public static boolean alIsExtensionPresent(@NativeType(value="ALchar const *") ByteBuffer extName) {
        if (Checks.CHECKS) {
            Checks.checkNT1(extName);
        }
        return AL10.nalIsExtensionPresent(MemoryUtil.memAddress(extName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCboolean")
    public static boolean alIsExtensionPresent(@NativeType(value="ALchar const *") CharSequence extName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(extName, true);
            long extNameEncoded = stack.getPointerAddress();
            boolean bl = AL10.nalIsExtensionPresent(extNameEncoded);
            return bl;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="ALvoid")
    public static void alGetIntegerv(@NativeType(value="ALenum") int paramName, @NativeType(value="ALint *") int[] dest) {
        long __functionAddress = AL.getICD().alGetIntegerv;
        if (Checks.CHECKS) {
            Checks.check(dest, 1);
        }
        JNI.invokePV(paramName, dest, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetFloatv(@NativeType(value="ALenum") int paramName, @NativeType(value="ALfloat *") float[] dest) {
        long __functionAddress = AL.getICD().alGetFloatv;
        if (Checks.CHECKS) {
            Checks.check(dest, 1);
        }
        JNI.invokePV(paramName, dest, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetDoublev(@NativeType(value="ALenum") int paramName, @NativeType(value="ALdouble *") double[] dest) {
        long __functionAddress = AL.getICD().alGetDoublev;
        if (Checks.CHECKS) {
            Checks.check(dest, 1);
        }
        JNI.invokePV(paramName, dest, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alListenerfv(@NativeType(value="ALenum") int paramName, @NativeType(value="ALfloat const *") float[] values) {
        long __functionAddress = AL.getICD().alListenerfv;
        if (Checks.CHECKS) {
            Checks.check(values, 1);
        }
        JNI.invokePV(paramName, values, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetListenerf(@NativeType(value="ALenum") int paramName, @NativeType(value="ALfloat *") float[] value) {
        long __functionAddress = AL.getICD().alGetListenerf;
        if (Checks.CHECKS) {
            Checks.check(value, 1);
        }
        JNI.invokePV(paramName, value, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetListeneri(@NativeType(value="ALenum") int paramName, @NativeType(value="ALint *") int[] value) {
        long __functionAddress = AL.getICD().alGetListeneri;
        if (Checks.CHECKS) {
            Checks.check(value, 1);
        }
        JNI.invokePV(paramName, value, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetListener3f(@NativeType(value="ALenum") int paramName, @NativeType(value="ALfloat *") float[] value1, @NativeType(value="ALfloat *") float[] value2, @NativeType(value="ALfloat *") float[] value3) {
        long __functionAddress = AL.getICD().alGetListener3f;
        if (Checks.CHECKS) {
            Checks.check(value1, 1);
            Checks.check(value2, 1);
            Checks.check(value3, 1);
        }
        JNI.invokePPPV(paramName, value1, value2, value3, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetListenerfv(@NativeType(value="ALenum") int paramName, @NativeType(value="ALfloat *") float[] values) {
        long __functionAddress = AL.getICD().alGetListenerfv;
        if (Checks.CHECKS) {
            Checks.check(values, 1);
        }
        JNI.invokePV(paramName, values, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGenSources(@NativeType(value="ALuint *") int[] srcNames) {
        long __functionAddress = AL.getICD().alGenSources;
        JNI.invokePV(srcNames.length, srcNames, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alDeleteSources(@NativeType(value="ALuint *") int[] sources) {
        long __functionAddress = AL.getICD().alDeleteSources;
        JNI.invokePV(sources.length, sources, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourcefv(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALfloat const *") float[] values) {
        long __functionAddress = AL.getICD().alSourcefv;
        if (Checks.CHECKS) {
            Checks.check(values, 1);
        }
        JNI.invokePV(source, param, values, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcef(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALfloat *") float[] value) {
        long __functionAddress = AL.getICD().alGetSourcef;
        if (Checks.CHECKS) {
            Checks.check(value, 1);
        }
        JNI.invokePV(source, param, value, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetSource3f(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALfloat *") float[] v1, @NativeType(value="ALfloat *") float[] v2, @NativeType(value="ALfloat *") float[] v3) {
        long __functionAddress = AL.getICD().alGetSource3f;
        if (Checks.CHECKS) {
            Checks.check(v1, 1);
            Checks.check(v2, 1);
            Checks.check(v3, 1);
        }
        JNI.invokePPPV(source, param, v1, v2, v3, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcefv(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALfloat *") float[] values) {
        long __functionAddress = AL.getICD().alGetSourcefv;
        if (Checks.CHECKS) {
            Checks.check(values, 1);
        }
        JNI.invokePV(source, param, values, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcei(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALint *") int[] value) {
        long __functionAddress = AL.getICD().alGetSourcei;
        if (Checks.CHECKS) {
            Checks.check(value, 1);
        }
        JNI.invokePV(source, param, value, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourceiv(@NativeType(value="ALuint") int source, @NativeType(value="ALenum") int param, @NativeType(value="ALint *") int[] values) {
        long __functionAddress = AL.getICD().alGetSourceiv;
        if (Checks.CHECKS) {
            Checks.check(values, 1);
        }
        JNI.invokePV(source, param, values, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourceQueueBuffers(@NativeType(value="ALuint") int sourceName, @NativeType(value="ALuint *") int[] bufferNames) {
        long __functionAddress = AL.getICD().alSourceQueueBuffers;
        JNI.invokePV(sourceName, bufferNames.length, bufferNames, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourceUnqueueBuffers(@NativeType(value="ALuint") int sourceName, @NativeType(value="ALuint *") int[] bufferNames) {
        long __functionAddress = AL.getICD().alSourceUnqueueBuffers;
        JNI.invokePV(sourceName, bufferNames.length, bufferNames, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourcePlayv(@NativeType(value="ALuint const *") int[] sources) {
        long __functionAddress = AL.getICD().alSourcePlayv;
        JNI.invokePV(sources.length, sources, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourcePausev(@NativeType(value="ALuint const *") int[] sources) {
        long __functionAddress = AL.getICD().alSourcePausev;
        JNI.invokePV(sources.length, sources, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourceStopv(@NativeType(value="ALuint const *") int[] sources) {
        long __functionAddress = AL.getICD().alSourceStopv;
        JNI.invokePV(sources.length, sources, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alSourceRewindv(@NativeType(value="ALuint const *") int[] sources) {
        long __functionAddress = AL.getICD().alSourceRewindv;
        JNI.invokePV(sources.length, sources, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGenBuffers(@NativeType(value="ALuint *") int[] bufferNames) {
        long __functionAddress = AL.getICD().alGenBuffers;
        JNI.invokePV(bufferNames.length, bufferNames, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alDeleteBuffers(@NativeType(value="ALuint const *") int[] bufferNames) {
        long __functionAddress = AL.getICD().alDeleteBuffers;
        JNI.invokePV(bufferNames.length, bufferNames, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferf(@NativeType(value="ALuint") int bufferName, @NativeType(value="ALenum") int paramName, @NativeType(value="ALfloat *") float[] value) {
        long __functionAddress = AL.getICD().alGetBufferf;
        if (Checks.CHECKS) {
            Checks.check(value, 1);
        }
        JNI.invokePV(bufferName, paramName, value, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferi(@NativeType(value="ALuint") int bufferName, @NativeType(value="ALenum") int paramName, @NativeType(value="ALint *") int[] value) {
        long __functionAddress = AL.getICD().alGetBufferi;
        if (Checks.CHECKS) {
            Checks.check(value, 1);
        }
        JNI.invokePV(bufferName, paramName, value, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alBufferData(@NativeType(value="ALuint") int bufferName, @NativeType(value="ALenum") int format, @NativeType(value="ALvoid const *") short[] data, @NativeType(value="ALsizei") int frequency) {
        long __functionAddress = AL.getICD().alBufferData;
        JNI.invokePV(bufferName, format, data, data.length << 1, frequency, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alBufferData(@NativeType(value="ALuint") int bufferName, @NativeType(value="ALenum") int format, @NativeType(value="ALvoid const *") int[] data, @NativeType(value="ALsizei") int frequency) {
        long __functionAddress = AL.getICD().alBufferData;
        JNI.invokePV(bufferName, format, data, data.length << 2, frequency, __functionAddress);
    }

    @NativeType(value="ALvoid")
    public static void alBufferData(@NativeType(value="ALuint") int bufferName, @NativeType(value="ALenum") int format, @NativeType(value="ALvoid const *") float[] data, @NativeType(value="ALsizei") int frequency) {
        long __functionAddress = AL.getICD().alBufferData;
        JNI.invokePV(bufferName, format, data, data.length << 2, frequency, __functionAddress);
    }
}

