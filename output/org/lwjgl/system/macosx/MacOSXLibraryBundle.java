/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.macosx.CoreFoundation;
import org.lwjgl.system.macosx.MacOSXLibrary;

public class MacOSXLibraryBundle
extends MacOSXLibrary {
    public MacOSXLibraryBundle(String name, long bundleRef) {
        super(name, bundleRef);
    }

    /*
     * Loose catch block
     */
    public static MacOSXLibraryBundle getWithIdentifier(String bundleID) {
        long filePath = 0L;
        try {
            try (MemoryStack stack = MemoryStack.stackPush();){
                filePath = MacOSXLibraryBundle.CString2CFString(stack.ASCII(bundleID), 1536);
                long bundleRef = CoreFoundation.CFBundleGetBundleWithIdentifier(filePath);
                if (bundleRef == 0L) {
                    throw new UnsatisfiedLinkError("Failed to retrieve bundle with identifier: " + bundleID);
                }
                CoreFoundation.CFRetain(bundleRef);
                MacOSXLibraryBundle macOSXLibraryBundle = new MacOSXLibraryBundle(bundleID, bundleRef);
                return macOSXLibraryBundle;
            }
            {
                catch (Throwable throwable) {
                    throw throwable;
                }
            }
        }
        finally {
            if (filePath != 0L) {
                CoreFoundation.CFRelease(filePath);
            }
        }
    }

    /*
     * Loose catch block
     */
    public static MacOSXLibraryBundle create(String path) {
        long filePath = 0L;
        long url = 0L;
        try {
            try (MemoryStack stack = MemoryStack.stackPush();){
                filePath = MacOSXLibraryBundle.CString2CFString(stack.UTF8(path), 0x8000100);
                url = Checks.check(CoreFoundation.CFURLCreateWithFileSystemPath(0L, filePath, 0L, true));
                long bundleRef = CoreFoundation.CFBundleCreate(0L, url);
                if (bundleRef == 0L) {
                    throw new UnsatisfiedLinkError("Failed to create bundle: " + path);
                }
                MacOSXLibraryBundle macOSXLibraryBundle = new MacOSXLibraryBundle(path, bundleRef);
                return macOSXLibraryBundle;
            }
            {
                catch (Throwable throwable) {
                    throw throwable;
                }
            }
        }
        finally {
            if (url != 0L) {
                CoreFoundation.CFRelease(url);
            }
            if (filePath != 0L) {
                CoreFoundation.CFRelease(filePath);
            }
        }
    }

    @Override
    @Nullable
    public String getPath() {
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long getFunctionAddress(ByteBuffer functionName) {
        long nameRef = MacOSXLibraryBundle.CString2CFString(functionName, 1536);
        try {
            long l = CoreFoundation.CFBundleGetFunctionPointerForName(this.address(), nameRef);
            return l;
        }
        finally {
            CoreFoundation.CFRelease(nameRef);
        }
    }

    private static long CString2CFString(ByteBuffer name, int encoding) {
        return Checks.check(CoreFoundation.CFStringCreateWithCStringNoCopy(0L, name, encoding, CoreFoundation.kCFAllocatorNull));
    }

    @Override
    public void free() {
        CoreFoundation.CFRelease(this.address());
    }
}

