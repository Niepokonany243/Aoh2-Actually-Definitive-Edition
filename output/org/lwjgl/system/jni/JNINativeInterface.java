/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jni;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.jni.JNINativeMethod;

public class JNINativeInterface {
    public static final int JNI_VERSION_1_1 = 65537;
    public static final int JNI_VERSION_1_2 = 65538;
    public static final int JNI_VERSION_1_4 = 65540;
    public static final int JNI_VERSION_1_6 = 65542;
    public static final int JNI_VERSION_1_8 = 65544;
    public static final int JNI_VERSION_9 = 589824;
    public static final int JNI_VERSION_10 = 655360;
    public static final int JNIInvalidRefType = 0;
    public static final int JNILocalRefType = 1;
    public static final int JNIGlobalRefType = 2;
    public static final int JNIWeakGlobalRefType = 3;
    public static final int JNI_FALSE = 0;
    public static final int JNI_TRUE = 1;
    public static final int JNI_OK = 0;
    public static final int JNI_ERR = -1;
    public static final int JNI_EDETACHED = -2;
    public static final int JNI_EVERSION = -3;
    public static final int JNI_ENOMEM = -4;
    public static final int JNI_EEXIST = -5;
    public static final int JNI_EINVAL = -6;
    public static final int JNI_COMMIT = 1;
    public static final int JNI_ABORT = 2;

    protected JNINativeInterface() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="jint")
    public static native int GetVersion();

    @NativeType(value="jmethodID")
    public static native long FromReflectedMethod(@NativeType(value="jobject") Method var0);

    @NativeType(value="jfieldID")
    public static native long FromReflectedField(@NativeType(value="jobject") Field var0);

    @Nullable
    public static native Method nToReflectedMethod(Class<?> var0, long var1, boolean var3);

    @Nullable
    @NativeType(value="jobject")
    public static Method ToReflectedMethod(@NativeType(value="jclass") Class<?> cls, @NativeType(value="jmethodID") long methodID, @NativeType(value="jboolean") boolean isStatic) {
        if (Checks.CHECKS) {
            Checks.check(methodID);
        }
        return JNINativeInterface.nToReflectedMethod(cls, methodID, isStatic);
    }

    @Nullable
    public static native Field nToReflectedField(Class<?> var0, long var1, boolean var3);

    @Nullable
    @NativeType(value="jobject")
    public static Field ToReflectedField(@NativeType(value="jclass") Class<?> cls, @NativeType(value="jfieldID") long fieldID, @NativeType(value="jboolean") boolean isStatic) {
        if (Checks.CHECKS) {
            Checks.check(fieldID);
        }
        return JNINativeInterface.nToReflectedField(cls, fieldID, isStatic);
    }

    @NativeType(value="void *")
    public static native long NewGlobalRef(@NativeType(value="jobject") Object var0);

    public static native void nDeleteGlobalRef(long var0);

    public static void DeleteGlobalRef(@NativeType(value="void *") long globalRef) {
        if (Checks.CHECKS) {
            Checks.check(globalRef);
        }
        JNINativeInterface.nDeleteGlobalRef(globalRef);
    }

    public static native long nGetBooleanArrayElements(byte[] var0, long var1);

    @Nullable
    @NativeType(value="jboolean *")
    public static ByteBuffer GetBooleanArrayElements(@NativeType(value="jbooleanArray") byte[] array, @Nullable @NativeType(value="jboolean *") ByteBuffer isCopy) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)isCopy, 1);
        }
        long __result = JNINativeInterface.nGetBooleanArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
        return MemoryUtil.memByteBufferSafe(__result, array.length);
    }

    public static native void nReleaseBooleanArrayElements(byte[] var0, long var1, int var3);

    public static void ReleaseBooleanArrayElements(@NativeType(value="jbooleanArray") byte[] array, @NativeType(value="jboolean *") ByteBuffer elems, @NativeType(value="jint") int mode) {
        JNINativeInterface.nReleaseBooleanArrayElements(array, MemoryUtil.memAddress(elems), mode);
    }

    public static native long nGetByteArrayElements(byte[] var0, long var1);

    @Nullable
    @NativeType(value="jbyte *")
    public static ByteBuffer GetByteArrayElements(@NativeType(value="jbyteArray") byte[] array, @Nullable @NativeType(value="jboolean *") ByteBuffer isCopy) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)isCopy, 1);
        }
        long __result = JNINativeInterface.nGetByteArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
        return MemoryUtil.memByteBufferSafe(__result, array.length);
    }

    public static native void nReleaseByteArrayElements(byte[] var0, long var1, int var3);

    public static void ReleaseByteArrayElements(@NativeType(value="jbyteArray") byte[] array, @NativeType(value="jbyte *") ByteBuffer elems, @NativeType(value="jint") int mode) {
        JNINativeInterface.nReleaseByteArrayElements(array, MemoryUtil.memAddress(elems), mode);
    }

    public static native long nGetCharArrayElements(char[] var0, long var1);

    @Nullable
    @NativeType(value="jchar *")
    public static ShortBuffer GetCharArrayElements(@NativeType(value="jcharArray") char[] array, @Nullable @NativeType(value="jboolean *") ByteBuffer isCopy) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)isCopy, 1);
        }
        long __result = JNINativeInterface.nGetCharArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
        return MemoryUtil.memShortBufferSafe(__result, array.length);
    }

    public static native void nReleaseCharArrayElements(char[] var0, long var1, int var3);

    public static void ReleaseCharArrayElements(@NativeType(value="jcharArray") char[] array, @NativeType(value="jchar *") ShortBuffer elems, @NativeType(value="jint") int mode) {
        JNINativeInterface.nReleaseCharArrayElements(array, MemoryUtil.memAddress(elems), mode);
    }

    public static native long nGetShortArrayElements(short[] var0, long var1);

    @Nullable
    @NativeType(value="jshort *")
    public static ShortBuffer GetShortArrayElements(@NativeType(value="jshortArray") short[] array, @Nullable @NativeType(value="jboolean *") ByteBuffer isCopy) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)isCopy, 1);
        }
        long __result = JNINativeInterface.nGetShortArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
        return MemoryUtil.memShortBufferSafe(__result, array.length);
    }

    public static native void nReleaseShortArrayElements(short[] var0, long var1, int var3);

    public static void ReleaseShortArrayElements(@NativeType(value="jshortArray") short[] array, @NativeType(value="jshort *") ShortBuffer elems, @NativeType(value="jint") int mode) {
        JNINativeInterface.nReleaseShortArrayElements(array, MemoryUtil.memAddress(elems), mode);
    }

    public static native long nGetIntArrayElements(int[] var0, long var1);

    @Nullable
    @NativeType(value="jint *")
    public static IntBuffer GetIntArrayElements(@NativeType(value="jintArray") int[] array, @Nullable @NativeType(value="jboolean *") ByteBuffer isCopy) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)isCopy, 1);
        }
        long __result = JNINativeInterface.nGetIntArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
        return MemoryUtil.memIntBufferSafe(__result, array.length);
    }

    public static native void nReleaseIntArrayElements(int[] var0, long var1, int var3);

    public static void ReleaseIntArrayElements(@NativeType(value="jintArray") int[] array, @NativeType(value="jint *") IntBuffer elems, @NativeType(value="jint") int mode) {
        JNINativeInterface.nReleaseIntArrayElements(array, MemoryUtil.memAddress(elems), mode);
    }

    public static native long nGetLongArrayElements(long[] var0, long var1);

    @Nullable
    @NativeType(value="jlong *")
    public static LongBuffer GetLongArrayElements(@NativeType(value="jlongArray") long[] array, @Nullable @NativeType(value="jboolean *") ByteBuffer isCopy) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)isCopy, 1);
        }
        long __result = JNINativeInterface.nGetLongArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
        return MemoryUtil.memLongBufferSafe(__result, array.length);
    }

    public static native void nReleaseLongArrayElements(long[] var0, long var1, int var3);

    public static void ReleaseLongArrayElements(@NativeType(value="jlongArray") long[] array, @NativeType(value="jlong *") LongBuffer elems, @NativeType(value="jint") int mode) {
        JNINativeInterface.nReleaseLongArrayElements(array, MemoryUtil.memAddress(elems), mode);
    }

    public static native long nGetFloatArrayElements(float[] var0, long var1);

    @Nullable
    @NativeType(value="jfloat *")
    public static FloatBuffer GetFloatArrayElements(@NativeType(value="jfloatArray") float[] array, @Nullable @NativeType(value="jboolean *") ByteBuffer isCopy) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)isCopy, 1);
        }
        long __result = JNINativeInterface.nGetFloatArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
        return MemoryUtil.memFloatBufferSafe(__result, array.length);
    }

    public static native void nReleaseFloatArrayElements(float[] var0, long var1, int var3);

    public static void ReleaseFloatArrayElements(@NativeType(value="jfloatArray") float[] array, @NativeType(value="jfloat *") FloatBuffer elems, @NativeType(value="jint") int mode) {
        JNINativeInterface.nReleaseFloatArrayElements(array, MemoryUtil.memAddress(elems), mode);
    }

    public static native long nGetDoubleArrayElements(double[] var0, long var1);

    @Nullable
    @NativeType(value="jdouble *")
    public static DoubleBuffer GetDoubleArrayElements(@NativeType(value="jdoubleArray") double[] array, @Nullable @NativeType(value="jboolean *") ByteBuffer isCopy) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)isCopy, 1);
        }
        long __result = JNINativeInterface.nGetDoubleArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
        return MemoryUtil.memDoubleBufferSafe(__result, array.length);
    }

    public static native void nReleaseDoubleArrayElements(double[] var0, long var1, int var3);

    public static void ReleaseDoubleArrayElements(@NativeType(value="jdoubleArray") double[] array, @NativeType(value="jdouble *") DoubleBuffer elems, @NativeType(value="jint") int mode) {
        JNINativeInterface.nReleaseDoubleArrayElements(array, MemoryUtil.memAddress(elems), mode);
    }

    public static native void nGetBooleanArrayRegion(byte[] var0, int var1, int var2, long var3);

    public static void GetBooleanArrayRegion(@NativeType(value="jbooleanArray") byte[] array, @NativeType(value="jsize") int start, @NativeType(value="jboolean *") ByteBuffer buf) {
        JNINativeInterface.nGetBooleanArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nSetBooleanArrayRegion(byte[] var0, int var1, int var2, long var3);

    public static void SetBooleanArrayRegion(@NativeType(value="jbooleanArray") byte[] array, @NativeType(value="jsize") int start, @NativeType(value="jboolean const *") ByteBuffer buf) {
        JNINativeInterface.nSetBooleanArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nGetByteArrayRegion(byte[] var0, int var1, int var2, long var3);

    public static void GetByteArrayRegion(@NativeType(value="jbyteArray") byte[] array, @NativeType(value="jsize") int start, @NativeType(value="jbyte *") ByteBuffer buf) {
        JNINativeInterface.nGetByteArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nSetByteArrayRegion(byte[] var0, int var1, int var2, long var3);

    public static void SetByteArrayRegion(@NativeType(value="jbyteArray") byte[] array, @NativeType(value="jsize") int start, @NativeType(value="jbyte const *") ByteBuffer buf) {
        JNINativeInterface.nSetByteArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nGetCharArrayRegion(char[] var0, int var1, int var2, long var3);

    public static void GetCharArrayRegion(@NativeType(value="jcharArray") char[] array, @NativeType(value="jsize") int start, @NativeType(value="jchar *") ShortBuffer buf) {
        JNINativeInterface.nGetCharArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nSetCharArrayRegion(char[] var0, int var1, int var2, long var3);

    public static void SetCharArrayRegion(@NativeType(value="jcharArray") char[] array, @NativeType(value="jsize") int start, @NativeType(value="jchar const *") ShortBuffer buf) {
        JNINativeInterface.nSetCharArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nGetShortArrayRegion(short[] var0, int var1, int var2, long var3);

    public static void GetShortArrayRegion(@NativeType(value="jshortArray") short[] array, @NativeType(value="jsize") int start, @NativeType(value="jshort *") ShortBuffer buf) {
        JNINativeInterface.nGetShortArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nSetShortArrayRegion(short[] var0, int var1, int var2, long var3);

    public static void SetShortArrayRegion(@NativeType(value="jshortArray") short[] array, @NativeType(value="jsize") int start, @NativeType(value="jshort const *") ShortBuffer buf) {
        JNINativeInterface.nSetShortArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nGetIntArrayRegion(int[] var0, int var1, int var2, long var3);

    public static void GetIntArrayRegion(@NativeType(value="jintArray") int[] array, @NativeType(value="jsize") int start, @NativeType(value="jint *") IntBuffer buf) {
        JNINativeInterface.nGetIntArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nSetIntArrayRegion(int[] var0, int var1, int var2, long var3);

    public static void SetIntArrayRegion(@NativeType(value="jintArray") int[] array, @NativeType(value="jsize") int start, @NativeType(value="jint const *") IntBuffer buf) {
        JNINativeInterface.nSetIntArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nGetLongArrayRegion(long[] var0, int var1, int var2, long var3);

    public static void GetLongArrayRegion(@NativeType(value="jlongArray") long[] array, @NativeType(value="jsize") int start, @NativeType(value="jlong *") LongBuffer buf) {
        JNINativeInterface.nGetLongArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nSetLongArrayRegion(long[] var0, int var1, int var2, long var3);

    public static void SetLongArrayRegion(@NativeType(value="jlongArray") long[] array, @NativeType(value="jsize") int start, @NativeType(value="jlong const *") LongBuffer buf) {
        JNINativeInterface.nSetLongArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nGetFloatArrayRegion(float[] var0, int var1, int var2, long var3);

    public static void GetFloatArrayRegion(@NativeType(value="jfloatArray") float[] array, @NativeType(value="jsize") int start, @NativeType(value="jfloat *") FloatBuffer buf) {
        JNINativeInterface.nGetFloatArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nSetFloatArrayRegion(float[] var0, int var1, int var2, long var3);

    public static void SetFloatArrayRegion(@NativeType(value="jfloatArray") float[] array, @NativeType(value="jsize") int start, @NativeType(value="jfloat const *") FloatBuffer buf) {
        JNINativeInterface.nSetFloatArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nGetDoubleArrayRegion(double[] var0, int var1, int var2, long var3);

    public static void GetDoubleArrayRegion(@NativeType(value="jdoubleArray") double[] array, @NativeType(value="jsize") int start, @NativeType(value="jdouble *") DoubleBuffer buf) {
        JNINativeInterface.nGetDoubleArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native void nSetDoubleArrayRegion(double[] var0, int var1, int var2, long var3);

    public static void SetDoubleArrayRegion(@NativeType(value="jdoubleArray") double[] array, @NativeType(value="jsize") int start, @NativeType(value="jdouble const *") DoubleBuffer buf) {
        JNINativeInterface.nSetDoubleArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    public static native int nRegisterNatives(Class<?> var0, long var1, int var3);

    @NativeType(value="jint")
    public static int RegisterNatives(@NativeType(value="jclass") Class<?> targetClass, @NativeType(value="JNINativeMethod const *") JNINativeMethod.Buffer methods) {
        if (Checks.CHECKS) {
            JNINativeMethod.validate(methods.address(), methods.remaining());
        }
        return JNINativeInterface.nRegisterNatives(targetClass, methods.address(), methods.remaining());
    }

    @NativeType(value="jint")
    public static native int UnregisterNatives(@NativeType(value="jclass") Class<?> var0);

    public static native int nGetJavaVM(long var0);

    @NativeType(value="jint")
    public static int GetJavaVM(@NativeType(value="JavaVM **") PointerBuffer vm) {
        if (Checks.CHECKS) {
            Checks.check(vm, 1);
        }
        return JNINativeInterface.nGetJavaVM(MemoryUtil.memAddress(vm));
    }

    public static native void nGetStringRegion(String var0, int var1, int var2, long var3);

    public static void GetStringRegion(@NativeType(value="jstring") String str, @NativeType(value="jsize") int start, @NativeType(value="jchar *") ByteBuffer buf) {
        JNINativeInterface.nGetStringRegion(str, start, buf.remaining() >> 1, MemoryUtil.memAddress(buf));
    }

    public static native void nGetStringUTFRegion(String var0, int var1, int var2, long var3);

    public static void GetStringUTFRegion(@NativeType(value="jstring") String str, @NativeType(value="jsize") int start, @NativeType(value="jsize") int len, @NativeType(value="char *") ByteBuffer buf) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)buf, len);
        }
        JNINativeInterface.nGetStringUTFRegion(str, start, len, MemoryUtil.memAddress(buf));
    }

    @NativeType(value="void *")
    public static native long NewWeakGlobalRef(@NativeType(value="jobject") Object var0);

    public static native void nDeleteWeakGlobalRef(long var0);

    public static void DeleteWeakGlobalRef(@NativeType(value="void *") long weakGlobalRef) {
        if (Checks.CHECKS) {
            Checks.check(weakGlobalRef);
        }
        JNINativeInterface.nDeleteWeakGlobalRef(weakGlobalRef);
    }

    @Nullable
    public static native ByteBuffer nNewDirectByteBuffer(long var0, long var2);

    @Nullable
    @NativeType(value="jobject")
    public static ByteBuffer NewDirectByteBuffer(@NativeType(value="void *") long address, @NativeType(value="jlong") long capacity) {
        if (Checks.CHECKS) {
            Checks.check(address);
        }
        return JNINativeInterface.nNewDirectByteBuffer(address, capacity);
    }

    @NativeType(value="void *")
    public static native long GetDirectBufferAddress(@NativeType(value="jobject") Buffer var0);

    @NativeType(value="jobjectRefType")
    public static native int GetObjectRefType(@NativeType(value="jobject") Object var0);

    static {
        Library.initialize();
    }
}

