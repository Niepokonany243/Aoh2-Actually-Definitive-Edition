/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import javax.annotation.Nullable;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.FunctionProviderLocal;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.Platform;
import org.lwjgl.system.SharedLibrary;

public final class ALC {
    @Nullable
    private static FunctionProviderLocal functionProvider;
    @Nullable
    private static ALCCapabilities icd;

    private ALC() {
    }

    public static void create() {
        String libName;
        switch (Platform.get()) {
            case LINUX: 
            case MACOSX: {
                libName = "openal";
                break;
            }
            case WINDOWS: {
                libName = "OpenAL";
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
        ALC.create(Configuration.OPENAL_LIBRARY_NAME.get(Platform.mapLibraryNameBundled(libName)));
    }

    public static void create(String libName) {
        SharedLibrary OPENAL = Library.loadNative(ALC.class, "org.lwjgl.openal", libName, true);
        try {
            ALC.create(new SharedLibraryAL(OPENAL));
        }
        catch (RuntimeException e) {
            OPENAL.free();
            throw e;
        }
    }

    public static void create(FunctionProviderLocal functionProvider) {
        if (ALC.functionProvider != null) {
            throw new IllegalStateException("ALC has already been created.");
        }
        ALC.functionProvider = functionProvider;
        icd = new ALCCapabilities(functionProvider, 0L, Collections.emptySet());
        AL.init();
    }

    public static void destroy() {
        if (functionProvider == null) {
            return;
        }
        AL.destroy();
        icd = null;
        if (functionProvider instanceof NativeResource) {
            ((NativeResource)((Object)functionProvider)).free();
        }
        functionProvider = null;
    }

    static <T> T check(@Nullable T t) {
        if (t == null) {
            throw new IllegalStateException("OpenAL library has not been loaded.");
        }
        return t;
    }

    public static FunctionProviderLocal getFunctionProvider() {
        return ALC.check(functionProvider);
    }

    static ALCCapabilities getICD() {
        return ALC.check(icd);
    }

    public static ALCCapabilities createCapabilities(long device) {
        int minorVersion;
        int majorVersion;
        FunctionProviderLocal functionProvider = ALC.getFunctionProvider();
        long GetIntegerv = functionProvider.getFunctionAddress("alcGetIntegerv");
        long GetString = functionProvider.getFunctionAddress("alcGetString");
        long IsExtensionPresent = functionProvider.getFunctionAddress("alcIsExtensionPresent");
        if (GetIntegerv == 0L || GetString == 0L || IsExtensionPresent == 0L) {
            throw new IllegalStateException("Core ALC functions could not be found. Make sure that OpenAL has been loaded.");
        }
        try (MemoryStack stack = MemoryStack.stackPush();){
            IntBuffer version = stack.mallocInt(1);
            JNI.invokePPV(device, 4096, 1, MemoryUtil.memAddress(version), GetIntegerv);
            majorVersion = version.get(0);
            JNI.invokePPV(device, 4097, 1, MemoryUtil.memAddress(version), GetIntegerv);
            minorVersion = version.get(0);
        }
        int[][] ALC_VERSIONS = new int[][]{{0, 1}};
        HashSet<String> supportedExtensions = new HashSet<String>(16);
        for (int major = 1; major <= ALC_VERSIONS.length; ++major) {
            int[] minors;
            for (int minor : minors = ALC_VERSIONS[major - 1]) {
                if (major >= majorVersion && (major != majorVersion || minor > minorVersion)) continue;
                supportedExtensions.add("OpenALC" + major + minor);
            }
        }
        String extensionsString = MemoryUtil.memASCIISafe(JNI.invokePP(device, 4102, GetString));
        if (extensionsString != null) {
            StringTokenizer tokenizer = new StringTokenizer(extensionsString);
            while (tokenizer.hasMoreTokens()) {
                String extName = tokenizer.nextToken();
                MemoryStack stack = MemoryStack.stackPush();
                Throwable throwable = null;
                try {
                    if (!JNI.invokePPZ(device, MemoryUtil.memAddress(stack.ASCII(extName, true)), IsExtensionPresent)) continue;
                    supportedExtensions.add(extName);
                }
                catch (Throwable throwable2) {
                    throwable = throwable2;
                    throw throwable2;
                }
                finally {
                    if (stack == null) continue;
                    if (throwable != null) {
                        try {
                            stack.close();
                        }
                        catch (Throwable throwable3) {
                            throwable.addSuppressed(throwable3);
                        }
                        continue;
                    }
                    stack.close();
                }
            }
        }
        return new ALCCapabilities(functionProvider, device, supportedExtensions);
    }

    static {
        if (!Configuration.OPENAL_EXPLICIT_INIT.get(false).booleanValue()) {
            ALC.create();
        }
    }

    private static class SharedLibraryAL
    extends SharedLibrary.Delegate
    implements FunctionProviderLocal {
        private final long alcGetProcAddress = this.getFunctionAddress("alcGetProcAddress");

        protected SharedLibraryAL(SharedLibrary library) {
            super(library);
            if (this.alcGetProcAddress == 0L) {
                throw new RuntimeException("A core ALC function is missing. Make sure that the OpenAL library has been loaded correctly.");
            }
        }

        @Override
        public long getFunctionAddress(ByteBuffer functionName) {
            long address = this.library.getFunctionAddress(functionName);
            if (address == 0L && Checks.DEBUG_FUNCTIONS) {
                APIUtil.apiLog("Failed to locate address for ALC core function " + MemoryUtil.memASCII(functionName));
            }
            return address;
        }

        @Override
        public long getFunctionAddress(long handle, ByteBuffer functionName) {
            long address = JNI.invokePPP(handle, MemoryUtil.memAddress(functionName), this.alcGetProcAddress);
            if (address == 0L && Checks.DEBUG_FUNCTIONS) {
                APIUtil.apiLog("Failed to locate address for ALC extension function " + MemoryUtil.memASCII(functionName));
            }
            return address;
        }
    }
}

