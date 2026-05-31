/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.macosx.EnumerationMutationHandlerI;
import org.lwjgl.system.macosx.ObjCMethodDescription;
import org.lwjgl.system.macosx.ObjCPropertyAttribute;

public class ObjCRuntime {
    public static final long nil = 0L;
    public static final byte YES = 1;
    public static final byte NO = 0;
    public static final char _C_ID = '@';
    public static final char _C_CLASS = '#';
    public static final char _C_SEL = ':';
    public static final char _C_CHR = 'c';
    public static final char _C_UCHR = 'C';
    public static final char _C_SHT = 's';
    public static final char _C_USHT = 'S';
    public static final char _C_INT = 'i';
    public static final char _C_UINT = 'I';
    public static final char _C_LNG = 'l';
    public static final char _C_ULNG = 'L';
    public static final char _C_LNG_LNG = 'q';
    public static final char _C_ULNG_LNG = 'Q';
    public static final char _C_FLT = 'f';
    public static final char _C_DBL = 'd';
    public static final char _C_BFLD = 'b';
    public static final char _C_BOOL = 'B';
    public static final char _C_VOID = 'v';
    public static final char _C_UNDEF = '?';
    public static final char _C_PTR = '^';
    public static final char _C_CHARPTR = '*';
    public static final char _C_ATOM = '%';
    public static final char _C_ARY_B = '[';
    public static final char _C_ARY_E = ']';
    public static final char _C_UNION_B = '(';
    public static final char _C_UNION_E = ')';
    public static final char _C_STRUCT_B = '{';
    public static final char _C_STRUCT_E = '}';
    public static final char _C_VECTOR = '!';
    public static final char _C_CONST = 'r';
    public static final int OBJC_ASSOCIATION_ASSIGN = 0;
    public static final int OBJC_ASSOCIATION_RETAIN_NONATOMIC = 1;
    public static final int OBJC_ASSOCIATION_COPY_NONATOMIC = 3;
    public static final int OBJC_ASSOCIATION_RETAIN = 1401;
    public static final int OBJC_ASSOCIATION_COPY = 1403;
    private static final SharedLibrary OBJC = Library.loadNative(ObjCRuntime.class, "org.lwjgl", "objc");

    protected ObjCRuntime() {
        throw new UnsupportedOperationException();
    }

    public static SharedLibrary getLibrary() {
        return OBJC;
    }

    @NativeType(value="id")
    public static long object_copy(@NativeType(value="id") long obj, @NativeType(value="size_t") long size) {
        long __functionAddress = Functions.object_copy;
        if (Checks.CHECKS) {
            Checks.check(obj);
        }
        return JNI.invokePPP(obj, size, __functionAddress);
    }

    @NativeType(value="id")
    public static long object_dispose(@NativeType(value="id") long obj) {
        long __functionAddress = Functions.object_dispose;
        if (Checks.CHECKS) {
            Checks.check(obj);
        }
        return JNI.invokePP(obj, __functionAddress);
    }

    @NativeType(value="Class")
    public static long object_getClass(@NativeType(value="id") long obj) {
        long __functionAddress = Functions.object_getClass;
        return JNI.invokePP(obj, __functionAddress);
    }

    @NativeType(value="Class")
    public static long object_setClass(@NativeType(value="id") long obj, @NativeType(value="Class") long cls) {
        long __functionAddress = Functions.object_setClass;
        if (Checks.CHECKS) {
            Checks.check(cls);
        }
        return JNI.invokePPP(obj, cls, __functionAddress);
    }

    public static long nobject_getClassName(long obj) {
        long __functionAddress = Functions.object_getClassName;
        return JNI.invokePP(obj, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String object_getClassName(@NativeType(value="id") long obj) {
        long __result = ObjCRuntime.nobject_getClassName(obj);
        return MemoryUtil.memUTF8Safe(__result);
    }

    @NativeType(value="void *")
    public static long object_getIndexedIvars(@NativeType(value="id") long obj) {
        long __functionAddress = Functions.object_getIndexedIvars;
        if (Checks.CHECKS) {
            Checks.check(obj);
        }
        return JNI.invokePP(obj, __functionAddress);
    }

    @NativeType(value="id")
    public static long object_getIvar(@NativeType(value="id") long obj, @NativeType(value="Ivar") long ivar) {
        long __functionAddress = Functions.object_getIvar;
        if (Checks.CHECKS) {
            Checks.check(ivar);
        }
        return JNI.invokePPP(obj, ivar, __functionAddress);
    }

    public static void object_setIvar(@NativeType(value="id") long obj, @NativeType(value="Ivar") long ivar, @NativeType(value="id") long value) {
        long __functionAddress = Functions.object_setIvar;
        if (Checks.CHECKS) {
            Checks.check(obj);
            Checks.check(ivar);
            Checks.check(value);
        }
        JNI.invokePPPV(obj, ivar, value, __functionAddress);
    }

    public static long nobject_setInstanceVariable(long obj, long name, long value) {
        long __functionAddress = Functions.object_setInstanceVariable;
        if (Checks.CHECKS) {
            Checks.check(obj);
        }
        return JNI.invokePPPP(obj, name, value, __functionAddress);
    }

    @NativeType(value="Ivar")
    public static long object_setInstanceVariable(@NativeType(value="id") long obj, @NativeType(value="char const *") ByteBuffer name, @NativeType(value="void *") ByteBuffer value) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ObjCRuntime.nobject_setInstanceVariable(obj, MemoryUtil.memAddress(name), MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="Ivar")
    public static long object_setInstanceVariable(@NativeType(value="id") long obj, @NativeType(value="char const *") CharSequence name, @NativeType(value="void *") ByteBuffer value) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nobject_setInstanceVariable(obj, nameEncoded, MemoryUtil.memAddress(value));
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nobject_getInstanceVariable(long obj, long name, long outValue) {
        long __functionAddress = Functions.object_getInstanceVariable;
        if (Checks.CHECKS) {
            Checks.check(obj);
        }
        return JNI.invokePPPP(obj, name, outValue, __functionAddress);
    }

    @NativeType(value="Ivar")
    public static long object_getInstanceVariable(@NativeType(value="id") long obj, @NativeType(value="char const *") ByteBuffer name, @NativeType(value="void **") PointerBuffer outValue) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
            Checks.check(outValue, 1);
        }
        return ObjCRuntime.nobject_getInstanceVariable(obj, MemoryUtil.memAddress(name), MemoryUtil.memAddress(outValue));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="Ivar")
    public static long object_getInstanceVariable(@NativeType(value="id") long obj, @NativeType(value="char const *") CharSequence name, @NativeType(value="void **") PointerBuffer outValue) {
        if (Checks.CHECKS) {
            Checks.check(outValue, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nobject_getInstanceVariable(obj, nameEncoded, MemoryUtil.memAddress(outValue));
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nobjc_getClass(long name) {
        long __functionAddress = Functions.objc_getClass;
        return JNI.invokePP(name, __functionAddress);
    }

    @NativeType(value="Class")
    public static long objc_getClass(@NativeType(value="char const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ObjCRuntime.nobjc_getClass(MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="Class")
    public static long objc_getClass(@NativeType(value="char const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nobjc_getClass(nameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nobjc_getMetaClass(long name) {
        long __functionAddress = Functions.objc_getMetaClass;
        return JNI.invokePP(name, __functionAddress);
    }

    @NativeType(value="Class")
    public static long objc_getMetaClass(@NativeType(value="char const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ObjCRuntime.nobjc_getMetaClass(MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="Class")
    public static long objc_getMetaClass(@NativeType(value="char const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nobjc_getMetaClass(nameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nobjc_lookUpClass(long name) {
        long __functionAddress = Functions.objc_lookUpClass;
        return JNI.invokePP(name, __functionAddress);
    }

    @NativeType(value="Class")
    public static long objc_lookUpClass(@NativeType(value="char const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ObjCRuntime.nobjc_lookUpClass(MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="Class")
    public static long objc_lookUpClass(@NativeType(value="char const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nobjc_lookUpClass(nameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nobjc_getRequiredClass(long name) {
        long __functionAddress = Functions.objc_getRequiredClass;
        return JNI.invokePP(name, __functionAddress);
    }

    @NativeType(value="Class")
    public static long objc_getRequiredClass(@NativeType(value="char const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ObjCRuntime.nobjc_getRequiredClass(MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="Class")
    public static long objc_getRequiredClass(@NativeType(value="char const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nobjc_getRequiredClass(nameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static int nobjc_getClassList(long buffer, int bufferCount) {
        long __functionAddress = Functions.objc_getClassList;
        return JNI.invokePI(buffer, bufferCount, __functionAddress);
    }

    public static int objc_getClassList(@Nullable @NativeType(value="Class *") PointerBuffer buffer) {
        return ObjCRuntime.nobjc_getClassList(MemoryUtil.memAddressSafe(buffer), Checks.remainingSafe(buffer));
    }

    public static long nobjc_copyClassList(long outCount) {
        long __functionAddress = Functions.objc_copyClassList;
        return JNI.invokePP(outCount, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="Class *")
    public static PointerBuffer objc_copyClassList() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer outCount = stack.callocInt(1);
        try {
            long __result = ObjCRuntime.nobjc_copyClassList(MemoryUtil.memAddress(outCount));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nclass_getName(long cls) {
        long __functionAddress = Functions.class_getName;
        return JNI.invokePP(cls, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String class_getName(@NativeType(value="Class") long cls) {
        long __result = ObjCRuntime.nclass_getName(cls);
        return MemoryUtil.memUTF8Safe(__result);
    }

    @NativeType(value="BOOL")
    public static boolean class_isMetaClass(@NativeType(value="Class") long cls) {
        long __functionAddress = Functions.class_isMetaClass;
        return JNI.invokePZ(cls, __functionAddress);
    }

    @NativeType(value="Class")
    public static long class_getSuperclass(@NativeType(value="Class") long cls) {
        long __functionAddress = Functions.class_getSuperclass;
        return JNI.invokePP(cls, __functionAddress);
    }

    public static int class_getVersion(@NativeType(value="Class") long cls) {
        long __functionAddress = Functions.class_getVersion;
        if (Checks.CHECKS) {
            Checks.check(cls);
        }
        return JNI.invokePI(cls, __functionAddress);
    }

    public static void class_setVersion(@NativeType(value="Class") long cls, int version) {
        long __functionAddress = Functions.class_setVersion;
        if (Checks.CHECKS) {
            Checks.check(cls);
        }
        JNI.invokePV(cls, version, __functionAddress);
    }

    @NativeType(value="size_t")
    public static long class_getInstanceSize(@NativeType(value="Class") long cls) {
        long __functionAddress = Functions.class_getInstanceSize;
        return JNI.invokePP(cls, __functionAddress);
    }

    public static long nclass_getInstanceVariable(long cls, long name) {
        long __functionAddress = Functions.class_getInstanceVariable;
        if (Checks.CHECKS) {
            Checks.check(cls);
        }
        return JNI.invokePPP(cls, name, __functionAddress);
    }

    @NativeType(value="Ivar")
    public static long class_getInstanceVariable(@NativeType(value="Class") long cls, @NativeType(value="char const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ObjCRuntime.nclass_getInstanceVariable(cls, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="Ivar")
    public static long class_getInstanceVariable(@NativeType(value="Class") long cls, @NativeType(value="char const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nclass_getInstanceVariable(cls, nameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nclass_getClassVariable(long cls, long name) {
        long __functionAddress = Functions.class_getClassVariable;
        if (Checks.CHECKS) {
            Checks.check(cls);
        }
        return JNI.invokePPP(cls, name, __functionAddress);
    }

    @NativeType(value="Ivar")
    public static long class_getClassVariable(@NativeType(value="Class") long cls, @NativeType(value="char const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ObjCRuntime.nclass_getClassVariable(cls, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="Ivar")
    public static long class_getClassVariable(@NativeType(value="Class") long cls, @NativeType(value="char const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nclass_getClassVariable(cls, nameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nclass_copyIvarList(long cls, long outCount) {
        long __functionAddress = Functions.class_copyIvarList;
        return JNI.invokePPP(cls, outCount, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="Ivar *")
    public static PointerBuffer class_copyIvarList(@NativeType(value="Class") long cls) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer outCount = stack.callocInt(1);
        try {
            long __result = ObjCRuntime.nclass_copyIvarList(cls, MemoryUtil.memAddress(outCount));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="Method")
    public static long class_getInstanceMethod(@NativeType(value="Class") long cls, @NativeType(value="SEL") long name) {
        long __functionAddress = Functions.class_getInstanceMethod;
        if (Checks.CHECKS) {
            Checks.check(cls);
            Checks.check(name);
        }
        return JNI.invokePPP(cls, name, __functionAddress);
    }

    @NativeType(value="Method")
    public static long class_getClassMethod(@NativeType(value="Class") long cls, @NativeType(value="SEL") long name) {
        long __functionAddress = Functions.class_getClassMethod;
        if (Checks.CHECKS) {
            Checks.check(cls);
            Checks.check(name);
        }
        return JNI.invokePPP(cls, name, __functionAddress);
    }

    @NativeType(value="IMP")
    public static long class_getMethodImplementation(@NativeType(value="Class") long cls, @NativeType(value="SEL") long name) {
        long __functionAddress = Functions.class_getMethodImplementation;
        if (Checks.CHECKS) {
            Checks.check(name);
        }
        return JNI.invokePPP(cls, name, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean class_respondsToSelector(@NativeType(value="Class") long cls, @NativeType(value="SEL") long name) {
        long __functionAddress = Functions.class_respondsToSelector;
        if (Checks.CHECKS) {
            Checks.check(cls);
            Checks.check(name);
        }
        return JNI.invokePPZ(cls, name, __functionAddress);
    }

    public static long nclass_copyMethodList(long cls, long outCount) {
        long __functionAddress = Functions.class_copyMethodList;
        return JNI.invokePPP(cls, outCount, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="Method *")
    public static PointerBuffer class_copyMethodList(@NativeType(value="Class") long cls) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer outCount = stack.callocInt(1);
        try {
            long __result = ObjCRuntime.nclass_copyMethodList(cls, MemoryUtil.memAddress(outCount));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="BOOL")
    public static boolean class_conformsToProtocol(@NativeType(value="Class") long cls, @NativeType(value="Protocol *") long protocol) {
        long __functionAddress = Functions.class_conformsToProtocol;
        if (Checks.CHECKS) {
            Checks.check(cls);
            Checks.check(protocol);
        }
        return JNI.invokePPZ(cls, protocol, __functionAddress);
    }

    public static long nclass_copyProtocolList(long cls, long outCount) {
        long __functionAddress = Functions.class_copyProtocolList;
        return JNI.invokePPP(cls, outCount, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="Protocol **")
    public static PointerBuffer class_copyProtocolList(@NativeType(value="Class") long cls) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer outCount = stack.callocInt(1);
        try {
            long __result = ObjCRuntime.nclass_copyProtocolList(cls, MemoryUtil.memAddress(outCount));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nclass_getProperty(long cls, long name) {
        long __functionAddress = Functions.class_getProperty;
        return JNI.invokePPP(cls, name, __functionAddress);
    }

    @NativeType(value="objc_property_t")
    public static long class_getProperty(@NativeType(value="Class") long cls, @NativeType(value="char const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ObjCRuntime.nclass_getProperty(cls, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="objc_property_t")
    public static long class_getProperty(@NativeType(value="Class") long cls, @NativeType(value="char const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nclass_getProperty(cls, nameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nclass_copyPropertyList(long cls, long outCount) {
        long __functionAddress = Functions.class_copyPropertyList;
        return JNI.invokePPP(cls, outCount, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="objc_property_t *")
    public static PointerBuffer class_copyPropertyList(@NativeType(value="Class") long cls) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer outCount = stack.callocInt(1);
        try {
            long __result = ObjCRuntime.nclass_copyPropertyList(cls, MemoryUtil.memAddress(outCount));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nclass_getIvarLayout(long cls) {
        long __functionAddress = Functions.class_getIvarLayout;
        if (Checks.CHECKS) {
            Checks.check(cls);
        }
        return JNI.invokePP(cls, __functionAddress);
    }

    @Nullable
    @NativeType(value="uint8_t const *")
    public static String class_getIvarLayout(@NativeType(value="Class") long cls) {
        long __result = ObjCRuntime.nclass_getIvarLayout(cls);
        return MemoryUtil.memASCIISafe(__result);
    }

    public static long nclass_getWeakIvarLayout(long cls) {
        long __functionAddress = Functions.class_getWeakIvarLayout;
        if (Checks.CHECKS) {
            Checks.check(cls);
        }
        return JNI.invokePP(cls, __functionAddress);
    }

    @Nullable
    @NativeType(value="uint8_t const *")
    public static String class_getWeakIvarLayout(@NativeType(value="Class") long cls) {
        long __result = ObjCRuntime.nclass_getWeakIvarLayout(cls);
        return MemoryUtil.memASCIISafe(__result);
    }

    public static boolean nclass_addMethod(long cls, long name, long imp, long types) {
        long __functionAddress = Functions.class_addMethod;
        if (Checks.CHECKS) {
            Checks.check(cls);
            Checks.check(name);
            Checks.check(imp);
        }
        return JNI.invokePPPPZ(cls, name, imp, types, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean class_addMethod(@NativeType(value="Class") long cls, @NativeType(value="SEL") long name, @NativeType(value="IMP") long imp, @NativeType(value="char const *") ByteBuffer types) {
        if (Checks.CHECKS) {
            Checks.checkNT1(types);
        }
        return ObjCRuntime.nclass_addMethod(cls, name, imp, MemoryUtil.memAddress(types));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="BOOL")
    public static boolean class_addMethod(@NativeType(value="Class") long cls, @NativeType(value="SEL") long name, @NativeType(value="IMP") long imp, @NativeType(value="char const *") CharSequence types) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(types, true);
            long typesEncoded = stack.getPointerAddress();
            boolean bl = ObjCRuntime.nclass_addMethod(cls, name, imp, typesEncoded);
            return bl;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nclass_replaceMethod(long cls, long name, long imp, long types) {
        long __functionAddress = Functions.class_replaceMethod;
        if (Checks.CHECKS) {
            Checks.check(cls);
            Checks.check(name);
            Checks.check(imp);
        }
        return JNI.invokePPPPP(cls, name, imp, types, __functionAddress);
    }

    @NativeType(value="IMP")
    public static long class_replaceMethod(@NativeType(value="Class") long cls, @NativeType(value="SEL") long name, @NativeType(value="IMP") long imp, @NativeType(value="char const *") ByteBuffer types) {
        if (Checks.CHECKS) {
            Checks.checkNT1(types);
        }
        return ObjCRuntime.nclass_replaceMethod(cls, name, imp, MemoryUtil.memAddress(types));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="IMP")
    public static long class_replaceMethod(@NativeType(value="Class") long cls, @NativeType(value="SEL") long name, @NativeType(value="IMP") long imp, @NativeType(value="char const *") CharSequence types) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(types, true);
            long typesEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nclass_replaceMethod(cls, name, imp, typesEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static boolean nclass_addIvar(long cls, long name, long size, byte alignment, long types) {
        long __functionAddress = Functions.class_addIvar;
        if (Checks.CHECKS) {
            Checks.check(cls);
        }
        return JNI.invokePPPPZ(cls, name, size, alignment, types, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean class_addIvar(@NativeType(value="Class") long cls, @NativeType(value="char const *") ByteBuffer name, @NativeType(value="size_t") long size, @NativeType(value="uint8_t") byte alignment, @NativeType(value="char const *") ByteBuffer types) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
            Checks.checkNT1(types);
        }
        return ObjCRuntime.nclass_addIvar(cls, MemoryUtil.memAddress(name), size, alignment, MemoryUtil.memAddress(types));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="BOOL")
    public static boolean class_addIvar(@NativeType(value="Class") long cls, @NativeType(value="char const *") CharSequence name, @NativeType(value="size_t") long size, @NativeType(value="uint8_t") byte alignment, @NativeType(value="char const *") CharSequence types) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            stack.nUTF8(types, true);
            long typesEncoded = stack.getPointerAddress();
            boolean bl = ObjCRuntime.nclass_addIvar(cls, nameEncoded, size, alignment, typesEncoded);
            return bl;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="BOOL")
    public static boolean class_addProtocol(@NativeType(value="Class") long cls, @NativeType(value="Protocol *") long protocol) {
        long __functionAddress = Functions.class_addProtocol;
        if (Checks.CHECKS) {
            Checks.check(cls);
            Checks.check(protocol);
        }
        return JNI.invokePPZ(cls, protocol, __functionAddress);
    }

    public static boolean nclass_addProperty(long cls, long name, long attributes, int attributeCount) {
        long __functionAddress = Functions.class_addProperty;
        if (Checks.CHECKS) {
            Checks.check(cls);
            ObjCPropertyAttribute.validate(attributes, attributeCount);
        }
        return JNI.invokePPPZ(cls, name, attributes, attributeCount, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean class_addProperty(@NativeType(value="Class") long cls, @NativeType(value="char const *") ByteBuffer name, @NativeType(value="objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer attributes) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ObjCRuntime.nclass_addProperty(cls, MemoryUtil.memAddress(name), attributes.address(), attributes.remaining());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="BOOL")
    public static boolean class_addProperty(@NativeType(value="Class") long cls, @NativeType(value="char const *") CharSequence name, @NativeType(value="objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer attributes) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            boolean bl = ObjCRuntime.nclass_addProperty(cls, nameEncoded, attributes.address(), attributes.remaining());
            return bl;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nclass_replaceProperty(long cls, long name, long attributes, int attributeCount) {
        long __functionAddress = Functions.class_replaceProperty;
        if (Checks.CHECKS) {
            Checks.check(cls);
            ObjCPropertyAttribute.validate(attributes, attributeCount);
        }
        JNI.invokePPPV(cls, name, attributes, attributeCount, __functionAddress);
    }

    public static void class_replaceProperty(@NativeType(value="Class") long cls, @NativeType(value="char const *") ByteBuffer name, @NativeType(value="objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer attributes) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        ObjCRuntime.nclass_replaceProperty(cls, MemoryUtil.memAddress(name), attributes.address(), attributes.remaining());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void class_replaceProperty(@NativeType(value="Class") long cls, @NativeType(value="char const *") CharSequence name, @NativeType(value="objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer attributes) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            ObjCRuntime.nclass_replaceProperty(cls, nameEncoded, attributes.address(), attributes.remaining());
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nclass_setIvarLayout(long cls, long layout) {
        long __functionAddress = Functions.class_setIvarLayout;
        if (Checks.CHECKS) {
            Checks.check(cls);
        }
        JNI.invokePPV(cls, layout, __functionAddress);
    }

    public static void class_setIvarLayout(@NativeType(value="Class") long cls, @NativeType(value="uint8_t const *") ByteBuffer layout) {
        if (Checks.CHECKS) {
            Checks.checkNT1(layout);
        }
        ObjCRuntime.nclass_setIvarLayout(cls, MemoryUtil.memAddress(layout));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void class_setIvarLayout(@NativeType(value="Class") long cls, @NativeType(value="uint8_t const *") CharSequence layout) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(layout, true);
            long layoutEncoded = stack.getPointerAddress();
            ObjCRuntime.nclass_setIvarLayout(cls, layoutEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nclass_setWeakIvarLayout(long cls, long layout) {
        long __functionAddress = Functions.class_setWeakIvarLayout;
        if (Checks.CHECKS) {
            Checks.check(cls);
        }
        JNI.invokePPV(cls, layout, __functionAddress);
    }

    public static void class_setWeakIvarLayout(@NativeType(value="Class") long cls, @NativeType(value="uint8_t const *") ByteBuffer layout) {
        if (Checks.CHECKS) {
            Checks.checkNT1(layout);
        }
        ObjCRuntime.nclass_setWeakIvarLayout(cls, MemoryUtil.memAddress(layout));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void class_setWeakIvarLayout(@NativeType(value="Class") long cls, @NativeType(value="uint8_t const *") CharSequence layout) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(layout, true);
            long layoutEncoded = stack.getPointerAddress();
            ObjCRuntime.nclass_setWeakIvarLayout(cls, layoutEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="id")
    public static long class_createInstance(@NativeType(value="Class") long cls, @NativeType(value="size_t") long extraBytes) {
        long __functionAddress = Functions.class_createInstance;
        if (Checks.CHECKS) {
            Checks.check(cls);
        }
        return JNI.invokePPP(cls, extraBytes, __functionAddress);
    }

    public static long nobjc_constructInstance(long cls, long bytes) {
        long __functionAddress = Functions.objc_constructInstance;
        return JNI.invokePPP(cls, bytes, __functionAddress);
    }

    @NativeType(value="id")
    public static long objc_constructInstance(@NativeType(value="Class") long cls, @Nullable @NativeType(value="void *") ByteBuffer bytes) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.checkSafe((Buffer)bytes, ObjCRuntime.class_getInstanceSize(cls));
        }
        return ObjCRuntime.nobjc_constructInstance(cls, MemoryUtil.memAddressSafe(bytes));
    }

    @NativeType(value="void *")
    public static long objc_destructInstance(@NativeType(value="id") long obj) {
        long __functionAddress = Functions.objc_destructInstance;
        if (Checks.CHECKS) {
            Checks.check(obj);
        }
        return JNI.invokePP(obj, __functionAddress);
    }

    public static long nobjc_allocateClassPair(long superclass, long name, long extraBytes) {
        long __functionAddress = Functions.objc_allocateClassPair;
        return JNI.invokePPPP(superclass, name, extraBytes, __functionAddress);
    }

    @NativeType(value="Class")
    public static long objc_allocateClassPair(@NativeType(value="Class") long superclass, @NativeType(value="char const *") ByteBuffer name, @NativeType(value="size_t") long extraBytes) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ObjCRuntime.nobjc_allocateClassPair(superclass, MemoryUtil.memAddress(name), extraBytes);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="Class")
    public static long objc_allocateClassPair(@NativeType(value="Class") long superclass, @NativeType(value="char const *") CharSequence name, @NativeType(value="size_t") long extraBytes) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nobjc_allocateClassPair(superclass, nameEncoded, extraBytes);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void objc_registerClassPair(@NativeType(value="Class") long cls) {
        long __functionAddress = Functions.objc_registerClassPair;
        if (Checks.CHECKS) {
            Checks.check(cls);
        }
        JNI.invokePV(cls, __functionAddress);
    }

    public static void objc_disposeClassPair(@NativeType(value="Class") long cls) {
        long __functionAddress = Functions.objc_disposeClassPair;
        if (Checks.CHECKS) {
            Checks.check(cls);
        }
        JNI.invokePV(cls, __functionAddress);
    }

    @NativeType(value="SEL")
    public static long method_getName(@NativeType(value="Method") long m) {
        long __functionAddress = Functions.method_getName;
        if (Checks.CHECKS) {
            Checks.check(m);
        }
        return JNI.invokePP(m, __functionAddress);
    }

    @NativeType(value="IMP")
    public static long method_getImplementation(@NativeType(value="Method") long m) {
        long __functionAddress = Functions.method_getImplementation;
        if (Checks.CHECKS) {
            Checks.check(m);
        }
        return JNI.invokePP(m, __functionAddress);
    }

    public static long nmethod_getTypeEncoding(long m) {
        long __functionAddress = Functions.method_getTypeEncoding;
        if (Checks.CHECKS) {
            Checks.check(m);
        }
        return JNI.invokePP(m, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String method_getTypeEncoding(@NativeType(value="Method") long m) {
        long __result = ObjCRuntime.nmethod_getTypeEncoding(m);
        return MemoryUtil.memUTF8Safe(__result);
    }

    @NativeType(value="unsigned int")
    public static int method_getNumberOfArguments(@NativeType(value="Method") long m) {
        long __functionAddress = Functions.method_getNumberOfArguments;
        if (Checks.CHECKS) {
            Checks.check(m);
        }
        return JNI.invokePI(m, __functionAddress);
    }

    public static long nmethod_copyReturnType(long m) {
        long __functionAddress = Functions.method_copyReturnType;
        if (Checks.CHECKS) {
            Checks.check(m);
        }
        return JNI.invokePP(m, __functionAddress);
    }

    @Nullable
    @NativeType(value="char *")
    public static String method_copyReturnType(@NativeType(value="Method") long m) {
        long __result = ObjCRuntime.nmethod_copyReturnType(m);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static long nmethod_copyArgumentType(long m, int index) {
        long __functionAddress = Functions.method_copyArgumentType;
        if (Checks.CHECKS) {
            Checks.check(m);
        }
        return JNI.invokePP(m, index, __functionAddress);
    }

    @Nullable
    @NativeType(value="char *")
    public static String method_copyArgumentType(@NativeType(value="Method") long m, @NativeType(value="unsigned int") int index) {
        long __result = ObjCRuntime.nmethod_copyArgumentType(m, index);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static void nmethod_getReturnType(long m, long dst, long dst_len) {
        long __functionAddress = Functions.method_getReturnType;
        if (Checks.CHECKS) {
            Checks.check(m);
        }
        JNI.invokePPPV(m, dst, dst_len, __functionAddress);
    }

    public static void method_getReturnType(@NativeType(value="Method") long m, @NativeType(value="char *") ByteBuffer dst) {
        ObjCRuntime.nmethod_getReturnType(m, MemoryUtil.memAddress(dst), dst.remaining());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String method_getReturnType(@NativeType(value="Method") long m, @NativeType(value="size_t") long dst_len) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            ByteBuffer dst = stack.malloc((int)dst_len);
            ObjCRuntime.nmethod_getReturnType(m, MemoryUtil.memAddress(dst), dst_len);
            String string = MemoryUtil.memUTF8(MemoryUtil.memByteBufferNT1(MemoryUtil.memAddress(dst), (int)dst_len));
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nmethod_getArgumentType(long m, int index, long dst, long dst_len) {
        long __functionAddress = Functions.method_getArgumentType;
        if (Checks.CHECKS) {
            Checks.check(m);
        }
        JNI.invokePPPV(m, index, dst, dst_len, __functionAddress);
    }

    public static void method_getArgumentType(@NativeType(value="Method") long m, @NativeType(value="unsigned int") int index, @NativeType(value="char *") ByteBuffer dst) {
        ObjCRuntime.nmethod_getArgumentType(m, index, MemoryUtil.memAddress(dst), dst.remaining());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String method_getArgumentType(@NativeType(value="Method") long m, @NativeType(value="unsigned int") int index, @NativeType(value="size_t") long dst_len) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            ByteBuffer dst = stack.malloc((int)dst_len);
            ObjCRuntime.nmethod_getArgumentType(m, index, MemoryUtil.memAddress(dst), dst_len);
            String string = MemoryUtil.memUTF8(MemoryUtil.memByteBufferNT1(MemoryUtil.memAddress(dst), (int)dst_len));
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="IMP")
    public static long method_setImplementation(@NativeType(value="Method") long m, @NativeType(value="IMP") long imp) {
        long __functionAddress = Functions.method_setImplementation;
        if (Checks.CHECKS) {
            Checks.check(m);
            Checks.check(imp);
        }
        return JNI.invokePPP(m, imp, __functionAddress);
    }

    public static void method_exchangeImplementations(@NativeType(value="Method") long m1, @NativeType(value="Method") long m2) {
        long __functionAddress = Functions.method_exchangeImplementations;
        if (Checks.CHECKS) {
            Checks.check(m1);
            Checks.check(m2);
        }
        JNI.invokePPV(m1, m2, __functionAddress);
    }

    public static long nivar_getName(long v) {
        long __functionAddress = Functions.ivar_getName;
        if (Checks.CHECKS) {
            Checks.check(v);
        }
        return JNI.invokePP(v, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String ivar_getName(@NativeType(value="Ivar") long v) {
        long __result = ObjCRuntime.nivar_getName(v);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static long nivar_getTypeEncoding(long v) {
        long __functionAddress = Functions.ivar_getTypeEncoding;
        if (Checks.CHECKS) {
            Checks.check(v);
        }
        return JNI.invokePP(v, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String ivar_getTypeEncoding(@NativeType(value="Ivar") long v) {
        long __result = ObjCRuntime.nivar_getTypeEncoding(v);
        return MemoryUtil.memUTF8Safe(__result);
    }

    @NativeType(value="ptrdiff_t")
    public static long ivar_getOffset(@NativeType(value="Ivar") long v) {
        long __functionAddress = Functions.ivar_getOffset;
        if (Checks.CHECKS) {
            Checks.check(v);
        }
        return JNI.invokePP(v, __functionAddress);
    }

    public static long nproperty_getName(long property) {
        long __functionAddress = Functions.property_getName;
        if (Checks.CHECKS) {
            Checks.check(property);
        }
        return JNI.invokePP(property, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String property_getName(@NativeType(value="objc_property_t") long property) {
        long __result = ObjCRuntime.nproperty_getName(property);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static long nproperty_getAttributes(long property) {
        long __functionAddress = Functions.property_getAttributes;
        if (Checks.CHECKS) {
            Checks.check(property);
        }
        return JNI.invokePP(property, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String property_getAttributes(@NativeType(value="objc_property_t") long property) {
        long __result = ObjCRuntime.nproperty_getAttributes(property);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static long nproperty_copyAttributeList(long property, long outCount) {
        long __functionAddress = Functions.property_copyAttributeList;
        if (Checks.CHECKS) {
            Checks.check(property);
        }
        return JNI.invokePPP(property, outCount, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="objc_property_attribute_t *")
    public static ObjCPropertyAttribute.Buffer property_copyAttributeList(@NativeType(value="objc_property_t") long property) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer outCount = stack.callocInt(1);
        try {
            long __result = ObjCRuntime.nproperty_copyAttributeList(property, MemoryUtil.memAddress(outCount));
            ObjCPropertyAttribute.Buffer buffer = ObjCPropertyAttribute.createSafe(__result, outCount.get(0));
            return buffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nproperty_copyAttributeValue(long property, long attributeName) {
        long __functionAddress = Functions.property_copyAttributeValue;
        if (Checks.CHECKS) {
            Checks.check(property);
        }
        return JNI.invokePPP(property, attributeName, __functionAddress);
    }

    @Nullable
    @NativeType(value="char *")
    public static String property_copyAttributeValue(@NativeType(value="objc_property_t") long property, @NativeType(value="char const *") ByteBuffer attributeName) {
        if (Checks.CHECKS) {
            Checks.checkNT1(attributeName);
        }
        long __result = ObjCRuntime.nproperty_copyAttributeValue(property, MemoryUtil.memAddress(attributeName));
        return MemoryUtil.memUTF8Safe(__result);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="char *")
    public static String property_copyAttributeValue(@NativeType(value="objc_property_t") long property, @NativeType(value="char const *") CharSequence attributeName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(attributeName, true);
            long attributeNameEncoded = stack.getPointerAddress();
            long __result = ObjCRuntime.nproperty_copyAttributeValue(property, attributeNameEncoded);
            String string = MemoryUtil.memUTF8Safe(__result);
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nobjc_getProtocol(long name) {
        long __functionAddress = Functions.objc_getProtocol;
        return JNI.invokePP(name, __functionAddress);
    }

    @NativeType(value="Protocol *")
    public static long objc_getProtocol(@NativeType(value="char const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ObjCRuntime.nobjc_getProtocol(MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="Protocol *")
    public static long objc_getProtocol(@NativeType(value="char const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nobjc_getProtocol(nameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nobjc_copyProtocolList(long outCount) {
        long __functionAddress = Functions.objc_copyProtocolList;
        return JNI.invokePP(outCount, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="Protocol **")
    public static PointerBuffer objc_copyProtocolList() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer outCount = stack.callocInt(1);
        try {
            long __result = ObjCRuntime.nobjc_copyProtocolList(MemoryUtil.memAddress(outCount));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="BOOL")
    public static boolean protocol_conformsToProtocol(@NativeType(value="Protocol *") long proto, @NativeType(value="Protocol *") long other) {
        long __functionAddress = Functions.protocol_conformsToProtocol;
        if (Checks.CHECKS) {
            Checks.check(proto);
            Checks.check(other);
        }
        return JNI.invokePPZ(proto, other, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean protocol_isEqual(@NativeType(value="Protocol *") long proto, @NativeType(value="Protocol *") long other) {
        long __functionAddress = Functions.protocol_isEqual;
        if (Checks.CHECKS) {
            Checks.check(proto);
            Checks.check(other);
        }
        return JNI.invokePPZ(proto, other, __functionAddress);
    }

    public static long nprotocol_getName(long p) {
        long __functionAddress = Functions.protocol_getName;
        if (Checks.CHECKS) {
            Checks.check(p);
        }
        return JNI.invokePP(p, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String protocol_getName(@NativeType(value="Protocol *") long p) {
        long __result = ObjCRuntime.nprotocol_getName(p);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static native void nprotocol_getMethodDescription(long var0, long var2, boolean var4, boolean var5, long var6, long var8);

    public static void nprotocol_getMethodDescription(long p, long aSel, boolean isRequiredMethod, boolean isInstanceMethod, long __result) {
        long __functionAddress = Functions.protocol_getMethodDescription;
        if (Checks.CHECKS) {
            Checks.check(p);
            Checks.check(aSel);
        }
        ObjCRuntime.nprotocol_getMethodDescription(p, aSel, isRequiredMethod, isInstanceMethod, __functionAddress, __result);
    }

    @NativeType(value="struct objc_method_description")
    public static ObjCMethodDescription protocol_getMethodDescription(@NativeType(value="Protocol *") long p, @NativeType(value="SEL") long aSel, @NativeType(value="BOOL") boolean isRequiredMethod, @NativeType(value="BOOL") boolean isInstanceMethod, @NativeType(value="struct objc_method_description") ObjCMethodDescription __result) {
        ObjCRuntime.nprotocol_getMethodDescription(p, aSel, isRequiredMethod, isInstanceMethod, __result.address());
        return __result;
    }

    public static long nprotocol_copyMethodDescriptionList(long p, boolean isRequiredMethod, boolean isInstanceMethod, long outCount) {
        long __functionAddress = Functions.protocol_copyMethodDescriptionList;
        if (Checks.CHECKS) {
            Checks.check(p);
        }
        return JNI.invokePPP(p, isRequiredMethod, isInstanceMethod, outCount, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="struct objc_method_description *")
    public static ObjCMethodDescription.Buffer protocol_copyMethodDescriptionList(@NativeType(value="Protocol *") long p, @NativeType(value="BOOL") boolean isRequiredMethod, @NativeType(value="BOOL") boolean isInstanceMethod) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer outCount = stack.callocInt(1);
        try {
            long __result = ObjCRuntime.nprotocol_copyMethodDescriptionList(p, isRequiredMethod, isInstanceMethod, MemoryUtil.memAddress(outCount));
            ObjCMethodDescription.Buffer buffer = ObjCMethodDescription.createSafe(__result, outCount.get(0));
            return buffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nprotocol_getProperty(long proto, long name, boolean isRequiredProperty, boolean isInstanceProperty) {
        long __functionAddress = Functions.protocol_getProperty;
        if (Checks.CHECKS) {
            Checks.check(proto);
        }
        return JNI.invokePPP(proto, name, isRequiredProperty, isInstanceProperty, __functionAddress);
    }

    @NativeType(value="objc_property_t")
    public static long protocol_getProperty(@NativeType(value="Protocol *") long proto, @NativeType(value="char const *") ByteBuffer name, @NativeType(value="BOOL") boolean isRequiredProperty, @NativeType(value="BOOL") boolean isInstanceProperty) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ObjCRuntime.nprotocol_getProperty(proto, MemoryUtil.memAddress(name), isRequiredProperty, isInstanceProperty);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="objc_property_t")
    public static long protocol_getProperty(@NativeType(value="Protocol *") long proto, @NativeType(value="char const *") CharSequence name, @NativeType(value="BOOL") boolean isRequiredProperty, @NativeType(value="BOOL") boolean isInstanceProperty) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nprotocol_getProperty(proto, nameEncoded, isRequiredProperty, isInstanceProperty);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nprotocol_copyPropertyList(long proto, long outCount) {
        long __functionAddress = Functions.protocol_copyPropertyList;
        if (Checks.CHECKS) {
            Checks.check(proto);
        }
        return JNI.invokePPP(proto, outCount, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="objc_property_t *")
    public static PointerBuffer protocol_copyPropertyList(@NativeType(value="Protocol *") long proto) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer outCount = stack.callocInt(1);
        try {
            long __result = ObjCRuntime.nprotocol_copyPropertyList(proto, MemoryUtil.memAddress(outCount));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nprotocol_copyProtocolList(long proto, long outCount) {
        long __functionAddress = Functions.protocol_copyProtocolList;
        if (Checks.CHECKS) {
            Checks.check(proto);
        }
        return JNI.invokePPP(proto, outCount, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="Protocol **")
    public static PointerBuffer protocol_copyProtocolList(@NativeType(value="Protocol *") long proto) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer outCount = stack.callocInt(1);
        try {
            long __result = ObjCRuntime.nprotocol_copyProtocolList(proto, MemoryUtil.memAddress(outCount));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nobjc_allocateProtocol(long name) {
        long __functionAddress = Functions.objc_allocateProtocol;
        return JNI.invokePP(name, __functionAddress);
    }

    @NativeType(value="Protocol *")
    public static long objc_allocateProtocol(@NativeType(value="char const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ObjCRuntime.nobjc_allocateProtocol(MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="Protocol *")
    public static long objc_allocateProtocol(@NativeType(value="char const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nobjc_allocateProtocol(nameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void objc_registerProtocol(@NativeType(value="Protocol *") long proto) {
        long __functionAddress = Functions.objc_registerProtocol;
        if (Checks.CHECKS) {
            Checks.check(proto);
        }
        JNI.invokePV(proto, __functionAddress);
    }

    public static void nprotocol_addMethodDescription(long proto, long name, long types, boolean isRequiredMethod, boolean isInstanceMethod) {
        long __functionAddress = Functions.protocol_addMethodDescription;
        if (Checks.CHECKS) {
            Checks.check(proto);
            Checks.check(name);
        }
        JNI.invokePPPV(proto, name, types, isRequiredMethod, isInstanceMethod, __functionAddress);
    }

    public static void protocol_addMethodDescription(@NativeType(value="Protocol *") long proto, @NativeType(value="SEL") long name, @NativeType(value="char const *") ByteBuffer types, @NativeType(value="BOOL") boolean isRequiredMethod, @NativeType(value="BOOL") boolean isInstanceMethod) {
        if (Checks.CHECKS) {
            Checks.checkNT1(types);
        }
        ObjCRuntime.nprotocol_addMethodDescription(proto, name, MemoryUtil.memAddress(types), isRequiredMethod, isInstanceMethod);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void protocol_addMethodDescription(@NativeType(value="Protocol *") long proto, @NativeType(value="SEL") long name, @NativeType(value="char const *") CharSequence types, @NativeType(value="BOOL") boolean isRequiredMethod, @NativeType(value="BOOL") boolean isInstanceMethod) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(types, true);
            long typesEncoded = stack.getPointerAddress();
            ObjCRuntime.nprotocol_addMethodDescription(proto, name, typesEncoded, isRequiredMethod, isInstanceMethod);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void protocol_addProtocol(@NativeType(value="Protocol *") long proto, @NativeType(value="Protocol *") long addition) {
        long __functionAddress = Functions.protocol_addProtocol;
        if (Checks.CHECKS) {
            Checks.check(proto);
            Checks.check(addition);
        }
        JNI.invokePPV(proto, addition, __functionAddress);
    }

    public static void nprotocol_addProperty(long proto, long name, long attributes, int attributeCount, boolean isRequiredProperty, boolean isInstanceProperty) {
        long __functionAddress = Functions.protocol_addProperty;
        if (Checks.CHECKS) {
            Checks.check(proto);
            ObjCPropertyAttribute.validate(attributes, attributeCount);
        }
        JNI.invokePPPV(proto, name, attributes, attributeCount, isRequiredProperty, isInstanceProperty, __functionAddress);
    }

    public static void protocol_addProperty(@NativeType(value="Protocol *") long proto, @NativeType(value="char const *") ByteBuffer name, @NativeType(value="objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer attributes, @NativeType(value="BOOL") boolean isRequiredProperty, @NativeType(value="BOOL") boolean isInstanceProperty) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        ObjCRuntime.nprotocol_addProperty(proto, MemoryUtil.memAddress(name), attributes.address(), attributes.remaining(), isRequiredProperty, isInstanceProperty);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void protocol_addProperty(@NativeType(value="Protocol *") long proto, @NativeType(value="char const *") CharSequence name, @NativeType(value="objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer attributes, @NativeType(value="BOOL") boolean isRequiredProperty, @NativeType(value="BOOL") boolean isInstanceProperty) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            ObjCRuntime.nprotocol_addProperty(proto, nameEncoded, attributes.address(), attributes.remaining(), isRequiredProperty, isInstanceProperty);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nobjc_copyImageNames(long outCount) {
        long __functionAddress = Functions.objc_copyImageNames;
        return JNI.invokePP(outCount, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="char const **")
    public static PointerBuffer objc_copyImageNames() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer outCount = stack.callocInt(1);
        try {
            long __result = ObjCRuntime.nobjc_copyImageNames(MemoryUtil.memAddress(outCount));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nclass_getImageName(long cls) {
        long __functionAddress = Functions.class_getImageName;
        if (Checks.CHECKS) {
            Checks.check(cls);
        }
        return JNI.invokePP(cls, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String class_getImageName(@NativeType(value="Class") long cls) {
        long __result = ObjCRuntime.nclass_getImageName(cls);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static long nobjc_copyClassNamesForImage(long image, long outCount) {
        long __functionAddress = Functions.objc_copyClassNamesForImage;
        return JNI.invokePPP(image, outCount, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="char const **")
    public static PointerBuffer objc_copyClassNamesForImage(@NativeType(value="char const *") ByteBuffer image) {
        if (Checks.CHECKS) {
            Checks.checkNT1(image);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer outCount = stack.callocInt(1);
        try {
            long __result = ObjCRuntime.nobjc_copyClassNamesForImage(MemoryUtil.memAddress(image), MemoryUtil.memAddress(outCount));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="char const **")
    public static PointerBuffer objc_copyClassNamesForImage(@NativeType(value="char const *") CharSequence image) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer outCount = stack.callocInt(1);
            stack.nUTF8(image, true);
            long imageEncoded = stack.getPointerAddress();
            long __result = ObjCRuntime.nobjc_copyClassNamesForImage(imageEncoded, MemoryUtil.memAddress(outCount));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nsel_getName(long sel) {
        long __functionAddress = Functions.sel_getName;
        if (Checks.CHECKS) {
            Checks.check(sel);
        }
        return JNI.invokePP(sel, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String sel_getName(@NativeType(value="SEL") long sel) {
        long __result = ObjCRuntime.nsel_getName(sel);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static long nsel_getUid(long str) {
        long __functionAddress = Functions.sel_getUid;
        return JNI.invokePP(str, __functionAddress);
    }

    @NativeType(value="SEL")
    public static long sel_getUid(@NativeType(value="char const *") ByteBuffer str) {
        if (Checks.CHECKS) {
            Checks.checkNT1(str);
        }
        return ObjCRuntime.nsel_getUid(MemoryUtil.memAddress(str));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="SEL")
    public static long sel_getUid(@NativeType(value="char const *") CharSequence str) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(str, true);
            long strEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nsel_getUid(strEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nsel_registerName(long str) {
        long __functionAddress = Functions.sel_registerName;
        return JNI.invokePP(str, __functionAddress);
    }

    @NativeType(value="SEL")
    public static long sel_registerName(@NativeType(value="char const *") ByteBuffer str) {
        if (Checks.CHECKS) {
            Checks.checkNT1(str);
        }
        return ObjCRuntime.nsel_registerName(MemoryUtil.memAddress(str));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="SEL")
    public static long sel_registerName(@NativeType(value="char const *") CharSequence str) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(str, true);
            long strEncoded = stack.getPointerAddress();
            long l = ObjCRuntime.nsel_registerName(strEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="BOOL")
    public static boolean sel_isEqual(@NativeType(value="SEL") long lhs, @NativeType(value="SEL") long rhs) {
        long __functionAddress = Functions.sel_isEqual;
        if (Checks.CHECKS) {
            Checks.check(lhs);
            Checks.check(rhs);
        }
        return JNI.invokePPZ(lhs, rhs, __functionAddress);
    }

    public static void objc_enumerationMutation(@NativeType(value="id") long obj) {
        long __functionAddress = Functions.objc_enumerationMutation;
        if (Checks.CHECKS) {
            Checks.check(obj);
        }
        JNI.invokePV(obj, __functionAddress);
    }

    public static void nobjc_setEnumerationMutationHandler(long handler) {
        long __functionAddress = Functions.objc_setEnumerationMutationHandler;
        JNI.invokePV(handler, __functionAddress);
    }

    public static void objc_setEnumerationMutationHandler(@NativeType(value="EnumerationMutationHandler") EnumerationMutationHandlerI handler) {
        ObjCRuntime.nobjc_setEnumerationMutationHandler(handler.address());
    }

    @NativeType(value="IMP")
    public static long imp_implementationWithBlock(@NativeType(value="id") long block) {
        long __functionAddress = Functions.imp_implementationWithBlock;
        if (Checks.CHECKS) {
            Checks.check(block);
        }
        return JNI.invokePP(block, __functionAddress);
    }

    @NativeType(value="id")
    public static long imp_getBlock(@NativeType(value="IMP") long anImp) {
        long __functionAddress = Functions.imp_getBlock;
        if (Checks.CHECKS) {
            Checks.check(anImp);
        }
        return JNI.invokePP(anImp, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean imp_removeBlock(@NativeType(value="IMP") long anImp) {
        long __functionAddress = Functions.imp_removeBlock;
        if (Checks.CHECKS) {
            Checks.check(anImp);
        }
        return JNI.invokePZ(anImp, __functionAddress);
    }

    public static long nobjc_loadWeak(long location) {
        long __functionAddress = Functions.objc_loadWeak;
        return JNI.invokePP(location, __functionAddress);
    }

    @NativeType(value="id")
    public static long objc_loadWeak(@Nullable @NativeType(value="id *") PointerBuffer location) {
        if (Checks.CHECKS) {
            Checks.checkSafe(location, 1);
        }
        return ObjCRuntime.nobjc_loadWeak(MemoryUtil.memAddressSafe(location));
    }

    public static long nobjc_storeWeak(long location, long obj) {
        long __functionAddress = Functions.objc_storeWeak;
        if (Checks.CHECKS) {
            Checks.check(obj);
        }
        return JNI.invokePPP(location, obj, __functionAddress);
    }

    @NativeType(value="id")
    public static long objc_storeWeak(@NativeType(value="id *") PointerBuffer location, @NativeType(value="id") long obj) {
        if (Checks.CHECKS) {
            Checks.check(location, 1);
        }
        return ObjCRuntime.nobjc_storeWeak(MemoryUtil.memAddress(location), obj);
    }

    public static void objc_setAssociatedObject(@NativeType(value="id") long object, @NativeType(value="void const *") long key, @NativeType(value="id") long value, @NativeType(value="objc_AssociationPolicy") long policy) {
        long __functionAddress = Functions.objc_setAssociatedObject;
        if (Checks.CHECKS) {
            Checks.check(object);
            Checks.check(key);
            Checks.check(value);
        }
        JNI.invokePPPPV(object, key, value, policy, __functionAddress);
    }

    @NativeType(value="id")
    public static long objc_getAssociatedObject(@NativeType(value="id") long object, @NativeType(value="void const *") long key) {
        long __functionAddress = Functions.objc_getAssociatedObject;
        if (Checks.CHECKS) {
            Checks.check(object);
            Checks.check(key);
        }
        return JNI.invokePPP(object, key, __functionAddress);
    }

    public static void objc_removeAssociatedObjects(@NativeType(value="id") long object) {
        long __functionAddress = Functions.objc_removeAssociatedObjects;
        if (Checks.CHECKS) {
            Checks.check(object);
        }
        JNI.invokePV(object, __functionAddress);
    }

    static /* synthetic */ SharedLibrary access$000() {
        return OBJC;
    }

    public static final class Functions {
        public static final long object_copy = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_copy");
        public static final long object_dispose = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_dispose");
        public static final long object_getClass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_getClass");
        public static final long object_setClass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_setClass");
        public static final long object_getClassName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_getClassName");
        public static final long object_getIndexedIvars = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_getIndexedIvars");
        public static final long object_getIvar = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_getIvar");
        public static final long object_setIvar = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_setIvar");
        public static final long object_setInstanceVariable = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_setInstanceVariable");
        public static final long object_getInstanceVariable = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_getInstanceVariable");
        public static final long objc_getClass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_getClass");
        public static final long objc_getMetaClass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_getMetaClass");
        public static final long objc_lookUpClass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_lookUpClass");
        public static final long objc_getRequiredClass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_getRequiredClass");
        public static final long objc_getClassList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_getClassList");
        public static final long objc_copyClassList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_copyClassList");
        public static final long class_getName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getName");
        public static final long class_isMetaClass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_isMetaClass");
        public static final long class_getSuperclass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getSuperclass");
        public static final long class_getVersion = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getVersion");
        public static final long class_setVersion = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_setVersion");
        public static final long class_getInstanceSize = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getInstanceSize");
        public static final long class_getInstanceVariable = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getInstanceVariable");
        public static final long class_getClassVariable = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getClassVariable");
        public static final long class_copyIvarList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_copyIvarList");
        public static final long class_getInstanceMethod = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getInstanceMethod");
        public static final long class_getClassMethod = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getClassMethod");
        public static final long class_getMethodImplementation = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getMethodImplementation");
        public static final long class_respondsToSelector = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_respondsToSelector");
        public static final long class_copyMethodList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_copyMethodList");
        public static final long class_conformsToProtocol = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_conformsToProtocol");
        public static final long class_copyProtocolList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_copyProtocolList");
        public static final long class_getProperty = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getProperty");
        public static final long class_copyPropertyList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_copyPropertyList");
        public static final long class_getIvarLayout = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getIvarLayout");
        public static final long class_getWeakIvarLayout = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getWeakIvarLayout");
        public static final long class_addMethod = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_addMethod");
        public static final long class_replaceMethod = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_replaceMethod");
        public static final long class_addIvar = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_addIvar");
        public static final long class_addProtocol = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_addProtocol");
        public static final long class_addProperty = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_addProperty");
        public static final long class_replaceProperty = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_replaceProperty");
        public static final long class_setIvarLayout = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_setIvarLayout");
        public static final long class_setWeakIvarLayout = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_setWeakIvarLayout");
        public static final long class_createInstance = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_createInstance");
        public static final long objc_constructInstance = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_constructInstance");
        public static final long objc_destructInstance = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_destructInstance");
        public static final long objc_allocateClassPair = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_allocateClassPair");
        public static final long objc_registerClassPair = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_registerClassPair");
        public static final long objc_disposeClassPair = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_disposeClassPair");
        public static final long method_getName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_getName");
        public static final long method_getImplementation = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_getImplementation");
        public static final long method_getTypeEncoding = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_getTypeEncoding");
        public static final long method_getNumberOfArguments = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_getNumberOfArguments");
        public static final long method_copyReturnType = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_copyReturnType");
        public static final long method_copyArgumentType = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_copyArgumentType");
        public static final long method_getReturnType = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_getReturnType");
        public static final long method_getArgumentType = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_getArgumentType");
        public static final long method_setImplementation = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_setImplementation");
        public static final long method_exchangeImplementations = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_exchangeImplementations");
        public static final long ivar_getName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "ivar_getName");
        public static final long ivar_getTypeEncoding = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "ivar_getTypeEncoding");
        public static final long ivar_getOffset = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "ivar_getOffset");
        public static final long property_getName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "property_getName");
        public static final long property_getAttributes = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "property_getAttributes");
        public static final long property_copyAttributeList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "property_copyAttributeList");
        public static final long property_copyAttributeValue = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "property_copyAttributeValue");
        public static final long objc_getProtocol = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_getProtocol");
        public static final long objc_copyProtocolList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_copyProtocolList");
        public static final long protocol_conformsToProtocol = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_conformsToProtocol");
        public static final long protocol_isEqual = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_isEqual");
        public static final long protocol_getName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_getName");
        public static final long protocol_getMethodDescription = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_getMethodDescription");
        public static final long protocol_copyMethodDescriptionList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_copyMethodDescriptionList");
        public static final long protocol_getProperty = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_getProperty");
        public static final long protocol_copyPropertyList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_copyPropertyList");
        public static final long protocol_copyProtocolList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_copyProtocolList");
        public static final long objc_allocateProtocol = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_allocateProtocol");
        public static final long objc_registerProtocol = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_registerProtocol");
        public static final long protocol_addMethodDescription = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_addMethodDescription");
        public static final long protocol_addProtocol = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_addProtocol");
        public static final long protocol_addProperty = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_addProperty");
        public static final long objc_copyImageNames = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_copyImageNames");
        public static final long class_getImageName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getImageName");
        public static final long objc_copyClassNamesForImage = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_copyClassNamesForImage");
        public static final long sel_getName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "sel_getName");
        public static final long sel_getUid = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "sel_getUid");
        public static final long sel_registerName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "sel_registerName");
        public static final long sel_isEqual = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "sel_isEqual");
        public static final long objc_enumerationMutation = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_enumerationMutation");
        public static final long objc_setEnumerationMutationHandler = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_setEnumerationMutationHandler");
        public static final long imp_implementationWithBlock = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "imp_implementationWithBlock");
        public static final long imp_getBlock = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "imp_getBlock");
        public static final long imp_removeBlock = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "imp_removeBlock");
        public static final long objc_loadWeak = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_loadWeak");
        public static final long objc_storeWeak = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_storeWeak");
        public static final long objc_setAssociatedObject = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_setAssociatedObject");
        public static final long objc_getAssociatedObject = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_getAssociatedObject");
        public static final long objc_removeAssociatedObjects = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_removeAssociatedObjects");

        private Functions() {
        }
    }
}

