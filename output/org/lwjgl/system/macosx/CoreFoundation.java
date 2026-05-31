/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class CoreFoundation {
    public static final byte TRUE = 1;
    public static final byte FALSE = 0;
    public static final int kCFStringEncodingMacRoman = 0;
    public static final int kCFStringEncodingWindowsLatin1 = 1280;
    public static final int kCFStringEncodingISOLatin1 = 513;
    public static final int kCFStringEncodingNextStepLatin = 2817;
    public static final int kCFStringEncodingASCII = 1536;
    public static final int kCFStringEncodingUnicode = 256;
    public static final int kCFStringEncodingUTF8 = 0x8000100;
    public static final int kCFStringEncodingNonLossyASCII = 3071;
    public static final int kCFStringEncodingUTF16 = 256;
    public static final int kCFStringEncodingUTF16BE = 0x10000100;
    public static final int kCFStringEncodingUTF16LE = 0x14000100;
    public static final int kCFStringEncodingUTF32 = 0xC000100;
    public static final int kCFStringEncodingUTF32BE = 0x18000100;
    public static final int kCFStringEncodingUTF32LE = 0x1C000100;
    public static final int kCFURLPOSIXPathStyle = 0;
    public static final int kCFURLHFSPathStyle = 1;
    public static final int kCFURLWindowsPathStyle = 2;
    public static final long kCFAllocatorDefault;
    public static final long kCFAllocatorSystemDefault;
    public static final long kCFAllocatorMalloc;
    public static final long kCFAllocatorMallocZone;
    public static final long kCFAllocatorNull;
    public static final long kCFAllocatorUseContext;

    protected CoreFoundation() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="CFAllocatorRef")
    private static native long kCFAllocatorDefault();

    @NativeType(value="CFAllocatorRef")
    private static native long kCFAllocatorSystemDefault();

    @NativeType(value="CFAllocatorRef")
    private static native long kCFAllocatorMalloc();

    @NativeType(value="CFAllocatorRef")
    private static native long kCFAllocatorMallocZone();

    @NativeType(value="CFAllocatorRef")
    private static native long kCFAllocatorNull();

    @NativeType(value="CFAllocatorRef")
    private static native long kCFAllocatorUseContext();

    public static native long nCFRetain(long var0);

    @NativeType(value="CFTypeRef")
    public static long CFRetain(@NativeType(value="CFTypeRef") long cf) {
        if (Checks.CHECKS) {
            Checks.check(cf);
        }
        return CoreFoundation.nCFRetain(cf);
    }

    public static native void nCFRelease(long var0);

    public static void CFRelease(@NativeType(value="CFTypeRef") long cf) {
        if (Checks.CHECKS) {
            Checks.check(cf);
        }
        CoreFoundation.nCFRelease(cf);
    }

    public static native long nCFBundleCreate(long var0, long var2);

    @NativeType(value="CFBundleRef")
    public static long CFBundleCreate(@NativeType(value="CFAllocatorRef") long allocator, @NativeType(value="CFURLRef") long bundleURL) {
        if (Checks.CHECKS) {
            Checks.check(bundleURL);
        }
        return CoreFoundation.nCFBundleCreate(allocator, bundleURL);
    }

    public static native long nCFBundleGetBundleWithIdentifier(long var0);

    @NativeType(value="CFBundleRef")
    public static long CFBundleGetBundleWithIdentifier(@NativeType(value="CFStringRef") long bundleID) {
        if (Checks.CHECKS) {
            Checks.check(bundleID);
        }
        return CoreFoundation.nCFBundleGetBundleWithIdentifier(bundleID);
    }

    public static native long nCFBundleGetFunctionPointerForName(long var0, long var2);

    @NativeType(value="void *")
    public static long CFBundleGetFunctionPointerForName(@NativeType(value="CFBundleRef") long bundle, @NativeType(value="CFStringRef") long functionName) {
        if (Checks.CHECKS) {
            Checks.check(bundle);
            Checks.check(functionName);
        }
        return CoreFoundation.nCFBundleGetFunctionPointerForName(bundle, functionName);
    }

    public static native long nCFStringCreateWithCString(long var0, long var2, int var4);

    @NativeType(value="CFStringRef")
    public static long CFStringCreateWithCString(@NativeType(value="CFAllocatorRef") long allocator, @NativeType(value="char const *") ByteBuffer cStr, @NativeType(value="CFStringEncoding") int encoding) {
        return CoreFoundation.nCFStringCreateWithCString(allocator, MemoryUtil.memAddress(cStr), encoding);
    }

    public static native long nCFStringCreateWithCStringNoCopy(long var0, long var2, int var4, long var5);

    @NativeType(value="CFStringRef")
    public static long CFStringCreateWithCStringNoCopy(@NativeType(value="CFAllocatorRef") long allocator, @NativeType(value="char const *") ByteBuffer cStr, @NativeType(value="CFStringEncoding") int encoding, @NativeType(value="CFAllocatorRef") long contentsDeallocator) {
        return CoreFoundation.nCFStringCreateWithCStringNoCopy(allocator, MemoryUtil.memAddress(cStr), encoding, contentsDeallocator);
    }

    public static native long nCFURLCreateWithFileSystemPath(long var0, long var2, long var4, boolean var6);

    @NativeType(value="CFURLRef")
    public static long CFURLCreateWithFileSystemPath(@NativeType(value="CFAllocatorRef") long allocator, @NativeType(value="CFStringRef") long filePath, @NativeType(value="CFURLPathStyle") long pathStyle, @NativeType(value="Boolean") boolean isDirectory) {
        if (Checks.CHECKS) {
            Checks.check(filePath);
        }
        return CoreFoundation.nCFURLCreateWithFileSystemPath(allocator, filePath, pathStyle, isDirectory);
    }

    static {
        Library.initialize();
        kCFAllocatorDefault = CoreFoundation.kCFAllocatorDefault();
        kCFAllocatorSystemDefault = CoreFoundation.kCFAllocatorSystemDefault();
        kCFAllocatorMalloc = CoreFoundation.kCFAllocatorMalloc();
        kCFAllocatorMallocZone = CoreFoundation.kCFAllocatorMallocZone();
        kCFAllocatorNull = CoreFoundation.kCFAllocatorNull();
        kCFAllocatorUseContext = CoreFoundation.kCFAllocatorUseContext();
    }
}

