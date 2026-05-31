/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class CGL {
    public static final int kCGLPFAAllRenderers = 1;
    public static final int kCGLPFATripleBuffer = 3;
    public static final int kCGLPFADoubleBuffer = 5;
    public static final int kCGLPFAStereo = 6;
    public static final int kCGLPFAColorSize = 8;
    public static final int kCGLPFAAlphaSize = 11;
    public static final int kCGLPFADepthSize = 12;
    public static final int kCGLPFAStencilSize = 13;
    public static final int kCGLPFAMinimumPolicy = 51;
    public static final int kCGLPFAMaximumPolicy = 52;
    public static final int kCGLPFASampleBuffers = 55;
    public static final int kCGLPFASamples = 56;
    public static final int kCGLPFAColorFloat = 58;
    public static final int kCGLPFAMultisample = 59;
    public static final int kCGLPFASupersample = 60;
    public static final int kCGLPFASampleAlpha = 61;
    public static final int kCGLPFARendererID = 70;
    public static final int kCGLPFASingleRenderer = 71;
    public static final int kCGLPFANoRecovery = 72;
    public static final int kCGLPFAAccelerated = 73;
    public static final int kCGLPFAClosestPolicy = 74;
    public static final int kCGLPFABackingStore = 76;
    public static final int kCGLPFABackingVolatile = 77;
    public static final int kCGLPFADisplayMask = 84;
    public static final int kCGLPFAAllowOfflineRenderers = 96;
    public static final int kCGLPFAAcceleratedCompute = 97;
    public static final int kCGLPFAOpenGLProfile = 99;
    public static final int kCGLPFASupportsAutomaticGraphicsSwitching = 101;
    public static final int kCGLPFAVirtualScreenCount = 128;
    public static final int kCGLPFAAuxBuffers = 7;
    public static final int kCGLPFAAccumSize = 14;
    public static final int kCGLPFAOffScreen = 53;
    public static final int kCGLPFAAuxDepthStencil = 57;
    public static final int kCGLPFAWindow = 80;
    public static final int kCGLPFACompliant = 83;
    public static final int kCGLPFAPBuffer = 90;
    public static final int kCGLPFARemotePBuffer = 91;
    public static final int kCGLPFARobust = 75;
    public static final int kCGLPFAMPSafe = 78;
    public static final int kCGLPFAMultiScreen = 81;
    public static final int kCGLPFAFullScreen = 54;
    public static final int kCGLRPOffScreen = 53;
    public static final int kCGLRPRendererID = 70;
    public static final int kCGLRPAccelerated = 73;
    public static final int kCGLRPBackingStore = 76;
    public static final int kCGLRPWindow = 80;
    public static final int kCGLRPCompliant = 83;
    public static final int kCGLRPDisplayMask = 84;
    public static final int kCGLRPBufferModes = 100;
    public static final int kCGLRPColorModes = 103;
    public static final int kCGLRPAccumModes = 104;
    public static final int kCGLRPDepthModes = 105;
    public static final int kCGLRPStencilModes = 106;
    public static final int kCGLRPMaxAuxBuffers = 107;
    public static final int kCGLRPMaxSampleBuffers = 108;
    public static final int kCGLRPMaxSamples = 109;
    public static final int kCGLRPSampleModes = 110;
    public static final int kCGLRPSampleAlpha = 111;
    public static final int kCGLRPVideoMemory = 120;
    public static final int kCGLRPTextureMemory = 121;
    public static final int kCGLRPGPUVertProcCapable = 122;
    public static final int kCGLRPGPUFragProcCapable = 123;
    public static final int kCGLRPRendererCount = 128;
    public static final int kCGLRPOnline = 129;
    public static final int kCGLRPAcceleratedCompute = 130;
    public static final int kCGLRPVideoMemoryMegabytes = 131;
    public static final int kCGLRPTextureMemoryMegabytes = 132;
    public static final int kCGLRPRobust = 75;
    public static final int kCGLRPMPSafe = 78;
    public static final int kCGLRPMultiScreen = 81;
    public static final int kCGLRPFullScreen = 54;
    public static final int kCGLCESwapRectangle = 201;
    public static final int kCGLCESwapLimit = 203;
    public static final int kCGLCERasterization = 221;
    public static final int kCGLCEStateValidation = 301;
    public static final int kCGLCESurfaceBackingSize = 305;
    public static final int kCGLCEDisplayListOptimization = 307;
    public static final int kCGLCEMPEngine = 313;
    public static final int kCGLCPSwapRectangle = 200;
    public static final int kCGLCPSwapInterval = 222;
    public static final int kCGLCPDispatchTableSize = 224;
    public static final int kCGLCPClientStorage = 226;
    public static final int kCGLCPSurfaceTexture = 228;
    public static final int kCGLCPSurfaceOrder = 235;
    public static final int kCGLCPSurfaceOpacity = 236;
    public static final int kCGLCPSurfaceBackingSize = 304;
    public static final int kCGLCPSurfaceSurfaceVolatile = 306;
    public static final int kCGLCPReclaimResources = 308;
    public static final int kCGLCPCurrentRendererID = 309;
    public static final int kCGLCPGPUVertexProcessing = 310;
    public static final int kCGLCPGPUFragmentProcessing = 311;
    public static final int kCGLCPHasDrawable = 314;
    public static final int kCGLCPMPSwapsInFlight = 315;
    public static final int kCGLGOFormatCacheSize = 501;
    public static final int kCGLGOClearFormatCache = 502;
    public static final int kCGLGORetainRenderers = 503;
    public static final int kCGLGOResetLibrary = 504;
    public static final int kCGLGOUseErrorHandler = 505;
    public static final int kCGLGOUseBuildCache = 506;
    public static final int kCGLOGLPVersion_Legacy = 4096;
    public static final int kCGLOGLPVersion_3_2_Core = 12800;
    public static final int kCGLNoError = 0;
    public static final int kCGLBadAttribute = 10000;
    public static final int kCGLBadProperty = 10001;
    public static final int kCGLBadPixelFormat = 10002;
    public static final int kCGLBadRendererInfo = 10003;
    public static final int kCGLBadContext = 10004;
    public static final int kCGLBadDrawable = 10005;
    public static final int kCGLBadDisplay = 10006;
    public static final int kCGLBadState = 10007;
    public static final int kCGLBadValue = 10008;
    public static final int kCGLBadMatch = 10009;
    public static final int kCGLBadEnumeration = 10010;
    public static final int kCGLBadOffScreen = 10011;
    public static final int kCGLBadFullScreen = 10012;
    public static final int kCGLBadWindow = 10013;
    public static final int kCGLBadAddress = 10014;
    public static final int kCGLBadCodeModule = 10015;
    public static final int kCGLBadAlloc = 10016;
    public static final int kCGLBadConnection = 10017;
    public static final int kCGLMonoscopicBit = 1;
    public static final int kCGLStereoscopicBit = 2;
    public static final int kCGLSingleBufferBit = 4;
    public static final int kCGLDoubleBufferBit = 8;
    public static final int kCGLTripleBufferBit = 16;
    public static final int kCGL0Bit = 1;
    public static final int kCGL1Bit = 2;
    public static final int kCGL2Bit = 4;
    public static final int kCGL3Bit = 8;
    public static final int kCGL4Bit = 16;
    public static final int kCGL5Bit = 32;
    public static final int kCGL6Bit = 64;
    public static final int kCGL8Bit = 128;
    public static final int kCGL10Bit = 256;
    public static final int kCGL12Bit = 512;
    public static final int kCGL16Bit = 1024;
    public static final int kCGL24Bit = 2048;
    public static final int kCGL32Bit = 4096;
    public static final int kCGL48Bit = 8192;
    public static final int kCGL64Bit = 16384;
    public static final int kCGL96Bit = 32768;
    public static final int kCGL128Bit = 65536;
    public static final int kCGLRGB444Bit = 64;
    public static final int kCGLARGB4444Bit = 128;
    public static final int kCGLRGB444A8Bit = 256;
    public static final int kCGLRGB555Bit = 512;
    public static final int kCGLARGB1555Bit = 1024;
    public static final int kCGLRGB555A8Bit = 2048;
    public static final int kCGLRGB565Bit = 4096;
    public static final int kCGLRGB565A8Bit = 8192;
    public static final int kCGLRGB888Bit = 16384;
    public static final int kCGLARGB8888Bit = 32768;
    public static final int kCGLRGB888A8Bit = 65536;
    public static final int kCGLRGB101010Bit = 131072;
    public static final int kCGLARGB2101010Bit = 262144;
    public static final int kCGLRGB101010_A8Bit = 524288;
    public static final int kCGLRGB121212Bit = 0x100000;
    public static final int kCGLARGB12121212Bit = 0x200000;
    public static final int kCGLRGB161616Bit = 0x400000;
    public static final int kCGLRGBA16161616Bit = 0x800000;
    public static final int kCGLRGBFloat64Bit = 0x1000000;
    public static final int kCGLRGBAFloat64Bit = 0x2000000;
    public static final int kCGLRGBFloat128Bit = 0x4000000;
    public static final int kCGLRGBAFloat128Bit = 0x8000000;
    public static final int kCGLRGBFloat256Bit = 0x10000000;
    public static final int kCGLRGBAFloat256Bit = 0x20000000;
    public static final int kCGLSupersampleBit = 1;
    public static final int kCGLMultisampleBit = 2;

    protected CGL() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="CGLContextObj")
    public static long CGLGetCurrentContext() {
        long __functionAddress = Functions.GetCurrentContext;
        return JNI.callP(__functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLSetCurrentContext(@NativeType(value="CGLContextObj") long context) {
        long __functionAddress = Functions.SetCurrentContext;
        return JNI.callPI(context, __functionAddress);
    }

    @NativeType(value="CGLShareGroupObj")
    public static long CGLGetShareGroup(@NativeType(value="CGLContextObj") long ctx) {
        long __functionAddress = Functions.GetShareGroup;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPP(ctx, __functionAddress);
    }

    public static int nCGLChoosePixelFormat(long attribs, long pix, long npix) {
        long __functionAddress = Functions.ChoosePixelFormat;
        return JNI.callPPPI(attribs, pix, npix, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLChoosePixelFormat(@NativeType(value="CGLPixelFormatAttribute const *") IntBuffer attribs, @NativeType(value="CGLPixelFormatObj *") PointerBuffer pix, @NativeType(value="GLint *") IntBuffer npix) {
        if (Checks.CHECKS) {
            Checks.checkNT(attribs);
            Checks.check(pix, 1);
            Checks.check((Buffer)npix, 1);
        }
        return CGL.nCGLChoosePixelFormat(MemoryUtil.memAddress(attribs), MemoryUtil.memAddress(pix), MemoryUtil.memAddress(npix));
    }

    @NativeType(value="CGLError")
    public static int CGLDestroyPixelFormat(@NativeType(value="CGLPixelFormatObj") long pix) {
        long __functionAddress = Functions.DestroyPixelFormat;
        if (Checks.CHECKS) {
            Checks.check(pix);
        }
        return JNI.callPI(pix, __functionAddress);
    }

    public static int nCGLDescribePixelFormat(long pix, int pix_num, int attrib, long value) {
        long __functionAddress = Functions.DescribePixelFormat;
        if (Checks.CHECKS) {
            Checks.check(pix);
        }
        return JNI.callPPI(pix, pix_num, attrib, value, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLDescribePixelFormat(@NativeType(value="CGLPixelFormatObj") long pix, @NativeType(value="GLint") int pix_num, @NativeType(value="CGLPixelFormatAttribute") int attrib, @NativeType(value="GLint *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        return CGL.nCGLDescribePixelFormat(pix, pix_num, attrib, MemoryUtil.memAddress(value));
    }

    public static void CGLReleasePixelFormat(@NativeType(value="CGLPixelFormatObj") long pix) {
        long __functionAddress = Functions.ReleasePixelFormat;
        if (Checks.CHECKS) {
            Checks.check(pix);
        }
        JNI.callPV(pix, __functionAddress);
    }

    @NativeType(value="CGLPixelFormatObj")
    public static long CGLRetainPixelFormat(@NativeType(value="CGLPixelFormatObj") long pix) {
        long __functionAddress = Functions.RetainPixelFormat;
        if (Checks.CHECKS) {
            Checks.check(pix);
        }
        return JNI.callPP(pix, __functionAddress);
    }

    @NativeType(value="GLuint")
    public static int CGLGetPixelFormatRetainCount(@NativeType(value="CGLPixelFormatObj") long pix) {
        long __functionAddress = Functions.GetPixelFormatRetainCount;
        if (Checks.CHECKS) {
            Checks.check(pix);
        }
        return JNI.callPI(pix, __functionAddress);
    }

    public static int nCGLQueryRendererInfo(int display_mask, long rend, long nrend) {
        long __functionAddress = Functions.QueryRendererInfo;
        return JNI.callPPI(display_mask, rend, nrend, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLQueryRendererInfo(@NativeType(value="GLuint") int display_mask, @NativeType(value="CGLRendererInfoObj *") PointerBuffer rend, @NativeType(value="GLint *") IntBuffer nrend) {
        if (Checks.CHECKS) {
            Checks.check(rend, 1);
            Checks.check((Buffer)nrend, 1);
        }
        return CGL.nCGLQueryRendererInfo(display_mask, MemoryUtil.memAddress(rend), MemoryUtil.memAddress(nrend));
    }

    @NativeType(value="CGLError")
    public static int CGLDestroyRendererInfo(@NativeType(value="CGLRendererInfoObj") long rend) {
        long __functionAddress = Functions.DestroyRendererInfo;
        if (Checks.CHECKS) {
            Checks.check(rend);
        }
        return JNI.callPI(rend, __functionAddress);
    }

    public static int nCGLDescribeRenderer(long rend, int rend_num, int prop, long value) {
        long __functionAddress = Functions.DescribeRenderer;
        if (Checks.CHECKS) {
            Checks.check(rend);
        }
        return JNI.callPPI(rend, rend_num, prop, value, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLDescribeRenderer(@NativeType(value="CGLRendererInfoObj") long rend, @NativeType(value="GLint") int rend_num, @NativeType(value="CGLRendererProperty") int prop, @NativeType(value="GLint *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        return CGL.nCGLDescribeRenderer(rend, rend_num, prop, MemoryUtil.memAddress(value));
    }

    public static int nCGLCreateContext(long pix, long share, long ctx) {
        long __functionAddress = Functions.CreateContext;
        if (Checks.CHECKS) {
            Checks.check(pix);
        }
        return JNI.callPPPI(pix, share, ctx, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLCreateContext(@NativeType(value="CGLPixelFormatObj") long pix, @NativeType(value="CGLContextObj") long share, @NativeType(value="CGLContextObj *") PointerBuffer ctx) {
        if (Checks.CHECKS) {
            Checks.check(ctx, 1);
        }
        return CGL.nCGLCreateContext(pix, share, MemoryUtil.memAddress(ctx));
    }

    @NativeType(value="CGLError")
    public static int CGLDestroyContext(@NativeType(value="CGLContextObj") long ctx) {
        long __functionAddress = Functions.DestroyContext;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPI(ctx, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLCopyContext(@NativeType(value="CGLContextObj") long src, @NativeType(value="CGLContextObj") long dst, @NativeType(value="GLbitfield") int mask) {
        long __functionAddress = Functions.CopyContext;
        if (Checks.CHECKS) {
            Checks.check(src);
            Checks.check(dst);
        }
        return JNI.callPPI(src, dst, mask, __functionAddress);
    }

    @NativeType(value="CGLContextObj")
    public static long CGLRetainContext(@NativeType(value="CGLContextObj") long ctx) {
        long __functionAddress = Functions.RetainContext;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPP(ctx, __functionAddress);
    }

    public static void CGLReleaseContext(@NativeType(value="CGLContextObj") long ctx) {
        long __functionAddress = Functions.ReleaseContext;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        JNI.callPV(ctx, __functionAddress);
    }

    @NativeType(value="GLuint")
    public static int CGLGetContextRetainCount(@NativeType(value="CGLContextObj") long ctx) {
        long __functionAddress = Functions.GetContextRetainCount;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPI(ctx, __functionAddress);
    }

    @NativeType(value="CGLPixelFormatObj")
    public static long CGLGetPixelFormat(@NativeType(value="CGLContextObj") long ctx) {
        long __functionAddress = Functions.GetPixelFormat;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPP(ctx, __functionAddress);
    }

    public static int nCGLCreatePBuffer(int width, int height, int target, int internalFormat, int max_level, long pbuffer) {
        long __functionAddress = Functions.CreatePBuffer;
        return JNI.callPI(width, height, target, internalFormat, max_level, pbuffer, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLCreatePBuffer(@NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalFormat, @NativeType(value="GLint") int max_level, @NativeType(value="CGLPBufferObj *") PointerBuffer pbuffer) {
        if (Checks.CHECKS) {
            Checks.check(pbuffer, 1);
        }
        return CGL.nCGLCreatePBuffer(width, height, target, internalFormat, max_level, MemoryUtil.memAddress(pbuffer));
    }

    @NativeType(value="CGLError")
    public static int CGLDestroyPBuffer(@NativeType(value="CGLPBufferObj") long pbuffer) {
        long __functionAddress = Functions.DestroyPBuffer;
        if (Checks.CHECKS) {
            Checks.check(pbuffer);
        }
        return JNI.callPI(pbuffer, __functionAddress);
    }

    public static int nCGLDescribePBuffer(long obj, long width, long height, long target, long internalFormat, long mipmap) {
        long __functionAddress = Functions.DescribePBuffer;
        if (Checks.CHECKS) {
            Checks.check(obj);
        }
        return JNI.callPPPPPPI(obj, width, height, target, internalFormat, mipmap, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLDescribePBuffer(@NativeType(value="CGLPBufferObj") long obj, @NativeType(value="GLsizei *") IntBuffer width, @NativeType(value="GLsizei *") IntBuffer height, @NativeType(value="GLenum *") IntBuffer target, @NativeType(value="GLenum *") IntBuffer internalFormat, @NativeType(value="GLint *") IntBuffer mipmap) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)width, 1);
            Checks.check((Buffer)height, 1);
            Checks.check((Buffer)target, 1);
            Checks.check((Buffer)internalFormat, 1);
            Checks.check((Buffer)mipmap, 1);
        }
        return CGL.nCGLDescribePBuffer(obj, MemoryUtil.memAddress(width), MemoryUtil.memAddress(height), MemoryUtil.memAddress(target), MemoryUtil.memAddress(internalFormat), MemoryUtil.memAddress(mipmap));
    }

    @NativeType(value="CGLError")
    public static int CGLTexImagePBuffer(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="CGLPBufferObj") long pbuffer, @NativeType(value="GLenum") int source) {
        long __functionAddress = Functions.TexImagePBuffer;
        if (Checks.CHECKS) {
            Checks.check(ctx);
            Checks.check(pbuffer);
        }
        return JNI.callPPI(ctx, pbuffer, source, __functionAddress);
    }

    @NativeType(value="CGLPBufferObj")
    public static long CGLRetainPBuffer(@NativeType(value="CGLPBufferObj") long pbuffer) {
        long __functionAddress = Functions.RetainPBuffer;
        if (Checks.CHECKS) {
            Checks.check(pbuffer);
        }
        return JNI.callPP(pbuffer, __functionAddress);
    }

    public static void CGLReleasePBuffer(@NativeType(value="CGLPBufferObj") long pbuffer) {
        long __functionAddress = Functions.ReleasePBuffer;
        if (Checks.CHECKS) {
            Checks.check(pbuffer);
        }
        JNI.callPV(pbuffer, __functionAddress);
    }

    @NativeType(value="GLuint")
    public static int CGLGetPBufferRetainCount(@NativeType(value="CGLPBufferObj") long pbuffer) {
        long __functionAddress = Functions.GetPBufferRetainCount;
        if (Checks.CHECKS) {
            Checks.check(pbuffer);
        }
        return JNI.callPI(pbuffer, __functionAddress);
    }

    public static int nCGLSetOffScreen(long ctx, int width, int height, int rowbytes, long baseaddr) {
        long __functionAddress = Functions.SetOffScreen;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPPI(ctx, width, height, rowbytes, baseaddr, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLSetOffScreen(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int rowbytes, @NativeType(value="void *") ByteBuffer baseaddr) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)baseaddr, rowbytes * height);
        }
        return CGL.nCGLSetOffScreen(ctx, width, height, rowbytes, MemoryUtil.memAddress(baseaddr));
    }

    public static int nCGLGetOffScreen(long ctx, long width, long height, long rowbytes, long baseaddr) {
        long __functionAddress = Functions.GetOffScreen;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPPPPPI(ctx, width, height, rowbytes, baseaddr, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLGetOffScreen(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="GLsizei *") IntBuffer width, @NativeType(value="GLsizei *") IntBuffer height, @NativeType(value="GLint *") IntBuffer rowbytes, @NativeType(value="void **") PointerBuffer baseaddr) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)width, 1);
            Checks.check((Buffer)height, 1);
            Checks.check((Buffer)rowbytes, 1);
            Checks.check(baseaddr, 1);
        }
        return CGL.nCGLGetOffScreen(ctx, MemoryUtil.memAddress(width), MemoryUtil.memAddress(height), MemoryUtil.memAddress(rowbytes), MemoryUtil.memAddress(baseaddr));
    }

    @NativeType(value="CGLError")
    public static int CGLSetFullScreen(@NativeType(value="CGLContextObj") long ctx) {
        long __functionAddress = Functions.SetFullScreen;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPI(ctx, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLSetFullScreenOnDisplay(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="GLuint") int display_mask) {
        long __functionAddress = Functions.SetFullScreenOnDisplay;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPI(ctx, display_mask, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLSetPBuffer(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="CGLPBufferObj") long pbuffer, @NativeType(value="GLenum") int face, @NativeType(value="GLint") int level, @NativeType(value="GLint") int screen) {
        long __functionAddress = Functions.SetPBuffer;
        if (Checks.CHECKS) {
            Checks.check(ctx);
            Checks.check(pbuffer);
        }
        return JNI.callPPI(ctx, pbuffer, face, level, screen, __functionAddress);
    }

    public static int nCGLGetPBuffer(long ctx, long pbuffer, long face, long level, long screen) {
        long __functionAddress = Functions.GetPBuffer;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPPPPPI(ctx, pbuffer, face, level, screen, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLGetPBuffer(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="CGLPBufferObj *") PointerBuffer pbuffer, @NativeType(value="GLenum *") IntBuffer face, @NativeType(value="GLint *") IntBuffer level, @NativeType(value="GLint *") IntBuffer screen) {
        if (Checks.CHECKS) {
            Checks.check(pbuffer, 1);
            Checks.check((Buffer)face, 1);
            Checks.check((Buffer)level, 1);
            Checks.check((Buffer)screen, 1);
        }
        return CGL.nCGLGetPBuffer(ctx, MemoryUtil.memAddress(pbuffer), MemoryUtil.memAddress(face), MemoryUtil.memAddress(level), MemoryUtil.memAddress(screen));
    }

    @NativeType(value="CGLError")
    public static int CGLClearDrawable(@NativeType(value="CGLContextObj") long ctx) {
        long __functionAddress = Functions.ClearDrawable;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPI(ctx, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLFlushDrawable(@NativeType(value="CGLContextObj") long ctx) {
        long __functionAddress = Functions.FlushDrawable;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPI(ctx, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLEnable(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="CGLContextEnable") int pname) {
        long __functionAddress = Functions.Enable;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPI(ctx, pname, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLDisable(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="CGLContextEnable") int pname) {
        long __functionAddress = Functions.Disable;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPI(ctx, pname, __functionAddress);
    }

    public static int nCGLIsEnabled(long ctx, int pname, long enable) {
        long __functionAddress = Functions.IsEnabled;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPPI(ctx, pname, enable, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLIsEnabled(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="CGLContextEnable") int pname, @NativeType(value="GLint *") IntBuffer enable) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)enable, 1);
        }
        return CGL.nCGLIsEnabled(ctx, pname, MemoryUtil.memAddress(enable));
    }

    public static int nCGLSetParameter(long ctx, int pname, long params) {
        long __functionAddress = Functions.SetParameter;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPPI(ctx, pname, params, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLSetParameter(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="CGLContextParameter") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        return CGL.nCGLSetParameter(ctx, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="CGLError")
    public static int CGLSetParameter(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="CGLContextParameter") int pname, @NativeType(value="GLint const *") int param) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.ints(param);
            int n = CGL.nCGLSetParameter(ctx, pname, MemoryUtil.memAddress(params));
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static int nCGLGetParameter(long ctx, int pname, long params) {
        long __functionAddress = Functions.GetParameter;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPPI(ctx, pname, params, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLGetParameter(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="CGLContextParameter") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        return CGL.nCGLGetParameter(ctx, pname, MemoryUtil.memAddress(params));
    }

    @NativeType(value="CGLError")
    public static int CGLSetVirtualScreen(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="GLint") int screen) {
        long __functionAddress = Functions.SetVirtualScreen;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPI(ctx, screen, __functionAddress);
    }

    public static int nCGLGetVirtualScreen(long ctx, long screen) {
        long __functionAddress = Functions.GetVirtualScreen;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPPI(ctx, screen, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLGetVirtualScreen(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="GLint *") IntBuffer screen) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)screen, 1);
        }
        return CGL.nCGLGetVirtualScreen(ctx, MemoryUtil.memAddress(screen));
    }

    @NativeType(value="CGLError")
    public static int CGLUpdateContext(@NativeType(value="CGLContextObj") long ctx) {
        long __functionAddress = Functions.UpdateContext;
        if (Checks.CHECKS) {
            Checks.check(ctx);
        }
        return JNI.callPI(ctx, __functionAddress);
    }

    public static int nCGLSetGlobalOption(int pname, long params) {
        long __functionAddress = Functions.SetGlobalOption;
        return JNI.callPI(pname, params, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLSetGlobalOption(@NativeType(value="CGLGlobalOption") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        return CGL.nCGLSetGlobalOption(pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="CGLError")
    public static int CGLSetGlobalOption(@NativeType(value="CGLGlobalOption") int pname, @NativeType(value="GLint const *") int param) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.ints(param);
            int n = CGL.nCGLSetGlobalOption(pname, MemoryUtil.memAddress(params));
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static int nCGLGetGlobalOption(int pname, long params) {
        long __functionAddress = Functions.GetGlobalOption;
        return JNI.callPI(pname, params, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLGetGlobalOption(@NativeType(value="CGLGlobalOption") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        return CGL.nCGLGetGlobalOption(pname, MemoryUtil.memAddress(params));
    }

    @NativeType(value="CGLError")
    public static int CGLLockContext(@NativeType(value="CGLContextObj") long context) {
        long __functionAddress = Functions.LockContext;
        if (Checks.CHECKS) {
            Checks.check(context);
        }
        return JNI.callPI(context, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLUnlockContext(@NativeType(value="CGLContextObj") long context) {
        long __functionAddress = Functions.UnlockContext;
        if (Checks.CHECKS) {
            Checks.check(context);
        }
        return JNI.callPI(context, __functionAddress);
    }

    public static void nCGLGetVersion(long majorvers, long minorvers) {
        long __functionAddress = Functions.GetVersion;
        JNI.callPPV(majorvers, minorvers, __functionAddress);
    }

    public static void CGLGetVersion(@NativeType(value="GLint *") IntBuffer majorvers, @NativeType(value="GLint *") IntBuffer minorvers) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)majorvers, 1);
            Checks.check((Buffer)minorvers, 1);
        }
        CGL.nCGLGetVersion(MemoryUtil.memAddress(majorvers), MemoryUtil.memAddress(minorvers));
    }

    public static long nCGLErrorString(int error) {
        long __functionAddress = Functions.ErrorString;
        return JNI.callP(error, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String CGLErrorString(@NativeType(value="CGLError") int error) {
        long __result = CGL.nCGLErrorString(error);
        return MemoryUtil.memASCIISafe(__result);
    }

    @NativeType(value="CGLError")
    public static int CGLChoosePixelFormat(@NativeType(value="CGLPixelFormatAttribute const *") int[] attribs, @NativeType(value="CGLPixelFormatObj *") PointerBuffer pix, @NativeType(value="GLint *") int[] npix) {
        long __functionAddress = Functions.ChoosePixelFormat;
        if (Checks.CHECKS) {
            Checks.checkNT(attribs);
            Checks.check(pix, 1);
            Checks.check(npix, 1);
        }
        return JNI.callPPPI(attribs, MemoryUtil.memAddress(pix), npix, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLDescribePixelFormat(@NativeType(value="CGLPixelFormatObj") long pix, @NativeType(value="GLint") int pix_num, @NativeType(value="CGLPixelFormatAttribute") int attrib, @NativeType(value="GLint *") int[] value) {
        long __functionAddress = Functions.DescribePixelFormat;
        if (Checks.CHECKS) {
            Checks.check(pix);
            Checks.check(value, 1);
        }
        return JNI.callPPI(pix, pix_num, attrib, value, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLQueryRendererInfo(@NativeType(value="GLuint") int display_mask, @NativeType(value="CGLRendererInfoObj *") PointerBuffer rend, @NativeType(value="GLint *") int[] nrend) {
        long __functionAddress = Functions.QueryRendererInfo;
        if (Checks.CHECKS) {
            Checks.check(rend, 1);
            Checks.check(nrend, 1);
        }
        return JNI.callPPI(display_mask, MemoryUtil.memAddress(rend), nrend, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLDescribeRenderer(@NativeType(value="CGLRendererInfoObj") long rend, @NativeType(value="GLint") int rend_num, @NativeType(value="CGLRendererProperty") int prop, @NativeType(value="GLint *") int[] value) {
        long __functionAddress = Functions.DescribeRenderer;
        if (Checks.CHECKS) {
            Checks.check(rend);
            Checks.check(value, 1);
        }
        return JNI.callPPI(rend, rend_num, prop, value, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLDescribePBuffer(@NativeType(value="CGLPBufferObj") long obj, @NativeType(value="GLsizei *") int[] width, @NativeType(value="GLsizei *") int[] height, @NativeType(value="GLenum *") int[] target, @NativeType(value="GLenum *") int[] internalFormat, @NativeType(value="GLint *") int[] mipmap) {
        long __functionAddress = Functions.DescribePBuffer;
        if (Checks.CHECKS) {
            Checks.check(obj);
            Checks.check(width, 1);
            Checks.check(height, 1);
            Checks.check(target, 1);
            Checks.check(internalFormat, 1);
            Checks.check(mipmap, 1);
        }
        return JNI.callPPPPPPI(obj, width, height, target, internalFormat, mipmap, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLGetOffScreen(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="GLsizei *") int[] width, @NativeType(value="GLsizei *") int[] height, @NativeType(value="GLint *") int[] rowbytes, @NativeType(value="void **") PointerBuffer baseaddr) {
        long __functionAddress = Functions.GetOffScreen;
        if (Checks.CHECKS) {
            Checks.check(ctx);
            Checks.check(width, 1);
            Checks.check(height, 1);
            Checks.check(rowbytes, 1);
            Checks.check(baseaddr, 1);
        }
        return JNI.callPPPPPI(ctx, width, height, rowbytes, MemoryUtil.memAddress(baseaddr), __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLGetPBuffer(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="CGLPBufferObj *") PointerBuffer pbuffer, @NativeType(value="GLenum *") int[] face, @NativeType(value="GLint *") int[] level, @NativeType(value="GLint *") int[] screen) {
        long __functionAddress = Functions.GetPBuffer;
        if (Checks.CHECKS) {
            Checks.check(ctx);
            Checks.check(pbuffer, 1);
            Checks.check(face, 1);
            Checks.check(level, 1);
            Checks.check(screen, 1);
        }
        return JNI.callPPPPPI(ctx, MemoryUtil.memAddress(pbuffer), face, level, screen, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLIsEnabled(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="CGLContextEnable") int pname, @NativeType(value="GLint *") int[] enable) {
        long __functionAddress = Functions.IsEnabled;
        if (Checks.CHECKS) {
            Checks.check(ctx);
            Checks.check(enable, 1);
        }
        return JNI.callPPI(ctx, pname, enable, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLSetParameter(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="CGLContextParameter") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = Functions.SetParameter;
        if (Checks.CHECKS) {
            Checks.check(ctx);
            Checks.check(params, 1);
        }
        return JNI.callPPI(ctx, pname, params, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLGetParameter(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="CGLContextParameter") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = Functions.GetParameter;
        if (Checks.CHECKS) {
            Checks.check(ctx);
            Checks.check(params, 1);
        }
        return JNI.callPPI(ctx, pname, params, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLGetVirtualScreen(@NativeType(value="CGLContextObj") long ctx, @NativeType(value="GLint *") int[] screen) {
        long __functionAddress = Functions.GetVirtualScreen;
        if (Checks.CHECKS) {
            Checks.check(ctx);
            Checks.check(screen, 1);
        }
        return JNI.callPPI(ctx, screen, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLSetGlobalOption(@NativeType(value="CGLGlobalOption") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = Functions.SetGlobalOption;
        if (Checks.CHECKS) {
            Checks.check(params, 1);
        }
        return JNI.callPI(pname, params, __functionAddress);
    }

    @NativeType(value="CGLError")
    public static int CGLGetGlobalOption(@NativeType(value="CGLGlobalOption") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = Functions.GetGlobalOption;
        if (Checks.CHECKS) {
            Checks.check(params, 1);
        }
        return JNI.callPI(pname, params, __functionAddress);
    }

    public static void CGLGetVersion(@NativeType(value="GLint *") int[] majorvers, @NativeType(value="GLint *") int[] minorvers) {
        long __functionAddress = Functions.GetVersion;
        if (Checks.CHECKS) {
            Checks.check(majorvers, 1);
            Checks.check(minorvers, 1);
        }
        JNI.callPPV(majorvers, minorvers, __functionAddress);
    }

    public static final class Functions {
        public static final long GetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetCurrentContext");
        public static final long SetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetCurrentContext");
        public static final long GetShareGroup = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetShareGroup");
        public static final long ChoosePixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLChoosePixelFormat");
        public static final long DestroyPixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyPixelFormat");
        public static final long DescribePixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDescribePixelFormat");
        public static final long ReleasePixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLReleasePixelFormat");
        public static final long RetainPixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLRetainPixelFormat");
        public static final long GetPixelFormatRetainCount = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPixelFormatRetainCount");
        public static final long QueryRendererInfo = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLQueryRendererInfo");
        public static final long DestroyRendererInfo = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyRendererInfo");
        public static final long DescribeRenderer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDescribeRenderer");
        public static final long CreateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLCreateContext");
        public static final long DestroyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyContext");
        public static final long CopyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLCopyContext");
        public static final long RetainContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLRetainContext");
        public static final long ReleaseContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLReleaseContext");
        public static final long GetContextRetainCount = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetContextRetainCount");
        public static final long GetPixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPixelFormat");
        public static final long CreatePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLCreatePBuffer");
        public static final long DestroyPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyPBuffer");
        public static final long DescribePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDescribePBuffer");
        public static final long TexImagePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLTexImagePBuffer");
        public static final long RetainPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLRetainPBuffer");
        public static final long ReleasePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLReleasePBuffer");
        public static final long GetPBufferRetainCount = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPBufferRetainCount");
        public static final long SetOffScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetOffScreen");
        public static final long GetOffScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetOffScreen");
        public static final long SetFullScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetFullScreen");
        public static final long SetFullScreenOnDisplay = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetFullScreenOnDisplay");
        public static final long SetPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetPBuffer");
        public static final long GetPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPBuffer");
        public static final long ClearDrawable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLClearDrawable");
        public static final long FlushDrawable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLFlushDrawable");
        public static final long Enable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLEnable");
        public static final long Disable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDisable");
        public static final long IsEnabled = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLIsEnabled");
        public static final long SetParameter = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetParameter");
        public static final long GetParameter = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetParameter");
        public static final long SetVirtualScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetVirtualScreen");
        public static final long GetVirtualScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetVirtualScreen");
        public static final long UpdateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLUpdateContext");
        public static final long SetGlobalOption = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetGlobalOption");
        public static final long GetGlobalOption = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetGlobalOption");
        public static final long LockContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLLockContext");
        public static final long UnlockContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLUnlockContext");
        public static final long GetVersion = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetVersion");
        public static final long ErrorString = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLErrorString");

        private Functions() {
        }
    }
}

