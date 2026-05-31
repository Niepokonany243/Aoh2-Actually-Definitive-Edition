/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLNVDXInterop {
    public static final int WGL_ACCESS_READ_ONLY_NV = 0;
    public static final int WGL_ACCESS_READ_WRITE_NV = 1;
    public static final int WGL_ACCESS_WRITE_DISCARD_NV = 2;

    protected WGLNVDXInterop() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(WGLCapabilities caps) {
        return Checks.checkFunctions(caps.wglDXSetResourceShareHandleNV, caps.wglDXOpenDeviceNV, caps.wglDXCloseDeviceNV, caps.wglDXRegisterObjectNV, caps.wglDXUnregisterObjectNV, caps.wglDXObjectAccessNV, caps.wglDXLockObjectsNV, caps.wglDXUnlockObjectsNV);
    }

    @NativeType(value="BOOL")
    public static boolean wglDXSetResourceShareHandleNV(@NativeType(value="void *") long dxObject, @NativeType(value="HANDLE") long shareHandle) {
        long __functionAddress = GL.getCapabilitiesWGL().wglDXSetResourceShareHandleNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(dxObject);
            Checks.check(shareHandle);
        }
        return JNI.callPPI(dxObject, shareHandle, __functionAddress) != 0;
    }

    @NativeType(value="HANDLE")
    public static long wglDXOpenDeviceNV(@NativeType(value="void *") long dxDevice) {
        long __functionAddress = GL.getCapabilitiesWGL().wglDXOpenDeviceNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(dxDevice);
        }
        return JNI.callPP(dxDevice, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglDXCloseDeviceNV(@NativeType(value="HANDLE") long device) {
        long __functionAddress = GL.getCapabilitiesWGL().wglDXCloseDeviceNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        return JNI.callPI(device, __functionAddress) != 0;
    }

    @NativeType(value="HANDLE")
    public static long wglDXRegisterObjectNV(@NativeType(value="HANDLE") long device, @NativeType(value="void *") long dxResource, @NativeType(value="GLuint") int name, @NativeType(value="GLenum") int type, @NativeType(value="GLenum") int access) {
        long __functionAddress = GL.getCapabilitiesWGL().wglDXRegisterObjectNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
            Checks.check(dxResource);
        }
        return JNI.callPPP(device, dxResource, name, type, access, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglDXUnregisterObjectNV(@NativeType(value="HANDLE") long device, @NativeType(value="HANDLE") long object) {
        long __functionAddress = GL.getCapabilitiesWGL().wglDXUnregisterObjectNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
            Checks.check(object);
        }
        return JNI.callPPI(device, object, __functionAddress) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglDXObjectAccessNV(@NativeType(value="HANDLE") long object, @NativeType(value="GLenum") int access) {
        long __functionAddress = GL.getCapabilitiesWGL().wglDXObjectAccessNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(object);
        }
        return JNI.callPI(object, access, __functionAddress) != 0;
    }

    public static int nwglDXLockObjectsNV(long device, int count, long objects) {
        long __functionAddress = GL.getCapabilitiesWGL().wglDXLockObjectsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        return JNI.callPPI(device, count, objects, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglDXLockObjectsNV(@NativeType(value="HANDLE") long device, @NativeType(value="HANDLE *") PointerBuffer objects) {
        return WGLNVDXInterop.nwglDXLockObjectsNV(device, objects.remaining(), MemoryUtil.memAddress(objects)) != 0;
    }

    public static int nwglDXUnlockObjectsNV(long device, int count, long objects) {
        long __functionAddress = GL.getCapabilitiesWGL().wglDXUnlockObjectsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        return JNI.callPPI(device, count, objects, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglDXUnlockObjectsNV(@NativeType(value="HANDLE") long device, @NativeType(value="HANDLE *") PointerBuffer objects) {
        return WGLNVDXInterop.nwglDXUnlockObjectsNV(device, objects.remaining(), MemoryUtil.memAddress(objects)) != 0;
    }
}

