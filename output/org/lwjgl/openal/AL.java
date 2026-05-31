/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.StringTokenizer;
import javax.annotation.Nullable;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALCapabilities;
import org.lwjgl.openal.EXTThreadLocalContext;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.ThreadLocalUtil;

public final class AL {
    @Nullable
    private static FunctionProvider functionProvider;
    @Nullable
    private static ALCapabilities processCaps;
    private static final ThreadLocal<ALCapabilities> capabilitiesTLS;
    private static ICD icd;

    private AL() {
    }

    static void init() {
        functionProvider = new FunctionProvider(){
            private final long alGetProcAddress = ALC.getFunctionProvider().getFunctionAddress("alGetProcAddress");

            @Override
            public long getFunctionAddress(ByteBuffer functionName) {
                long address = JNI.invokePP(MemoryUtil.memAddress(functionName), this.alGetProcAddress);
                if (address == 0L && Checks.DEBUG_FUNCTIONS) {
                    APIUtil.apiLog("Failed to locate address for AL function " + MemoryUtil.memASCII(functionName));
                }
                return address;
            }
        };
    }

    static void destroy() {
        if (functionProvider == null) {
            return;
        }
        AL.setCurrentProcess(null);
        functionProvider = null;
    }

    public static void setCurrentProcess(@Nullable ALCapabilities caps) {
        processCaps = caps;
        capabilitiesTLS.set(null);
        icd.set(caps);
    }

    public static void setCurrentThread(@Nullable ALCapabilities caps) {
        capabilitiesTLS.set(caps);
        icd.set(caps);
    }

    public static ALCapabilities getCapabilities() {
        ALCapabilities caps = capabilitiesTLS.get();
        if (caps == null) {
            caps = processCaps;
        }
        return AL.checkCapabilities(caps);
    }

    private static ALCapabilities checkCapabilities(@Nullable ALCapabilities caps) {
        if (caps == null) {
            throw new IllegalStateException("No ALCapabilities instance set for the current thread or process. Possible solutions:\n\ta) Call AL.createCapabilities() after making a context current.\n\tb) Call AL.setCurrentProcess() or AL.setCurrentThread() if an ALCapabilities instance already exists.");
        }
        return caps;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ALCapabilities createCapabilities(ALCCapabilities alcCaps) {
        ALCapabilities aLCapabilities;
        FunctionProvider functionProvider = ALC.check(AL.functionProvider);
        ALCapabilities caps = null;
        try {
            long GetString = functionProvider.getFunctionAddress("alGetString");
            long GetError = functionProvider.getFunctionAddress("alGetError");
            long IsExtensionPresent = functionProvider.getFunctionAddress("alIsExtensionPresent");
            if (GetString == 0L || GetError == 0L || IsExtensionPresent == 0L) {
                throw new IllegalStateException("Core OpenAL functions could not be found. Make sure that the OpenAL library has been loaded correctly.");
            }
            String versionString = MemoryUtil.memASCIISafe(JNI.invokeP(45058, GetString));
            if (versionString == null || JNI.invokeI(GetError) != 0) {
                throw new IllegalStateException("There is no OpenAL context current in the current thread or process.");
            }
            APIUtil.APIVersion apiVersion = APIUtil.apiParseVersion(versionString);
            int majorVersion = apiVersion.major;
            int minorVersion = apiVersion.minor;
            int[][] AL_VERSIONS = new int[][]{{0, 1}};
            HashSet<String> supportedExtensions = new HashSet<String>(32);
            for (int major = 1; major <= AL_VERSIONS.length; ++major) {
                int[] minors;
                for (int minor : minors = AL_VERSIONS[major - 1]) {
                    if (major >= majorVersion && (major != majorVersion || minor > minorVersion)) continue;
                    supportedExtensions.add("OpenAL" + major + minor);
                }
            }
            String extensionsString = MemoryUtil.memASCIISafe(JNI.invokeP(45060, GetString));
            if (extensionsString != null) {
                MemoryStack stack = MemoryStack.stackGet();
                StringTokenizer tokenizer = new StringTokenizer(extensionsString);
                while (tokenizer.hasMoreTokens()) {
                    String extName = tokenizer.nextToken();
                    MemoryStack frame = stack.push();
                    Throwable throwable = null;
                    try {
                        if (!JNI.invokePZ(MemoryUtil.memAddress(frame.ASCII(extName, true)), IsExtensionPresent)) continue;
                        supportedExtensions.add(extName);
                    }
                    catch (Throwable throwable2) {
                        throwable = throwable2;
                        throw throwable2;
                    }
                    finally {
                        if (frame == null) continue;
                        if (throwable != null) {
                            try {
                                frame.close();
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                            continue;
                        }
                        frame.close();
                    }
                }
            }
            if (alcCaps.ALC_EXT_EFX) {
                supportedExtensions.add("ALC_EXT_EFX");
            }
            aLCapabilities = caps = new ALCapabilities(functionProvider, supportedExtensions);
        }
        catch (Throwable throwable) {
            if (alcCaps.ALC_EXT_thread_local_context && EXTThreadLocalContext.alcGetThreadContext() != 0L) {
                AL.setCurrentThread(caps);
            } else {
                AL.setCurrentProcess(caps);
            }
            throw throwable;
        }
        if (alcCaps.ALC_EXT_thread_local_context && EXTThreadLocalContext.alcGetThreadContext() != 0L) {
            AL.setCurrentThread(caps);
        } else {
            AL.setCurrentProcess(caps);
        }
        return aLCapabilities;
    }

    static ALCapabilities getICD() {
        return ALC.check(icd.get());
    }

    static {
        capabilitiesTLS = new ThreadLocal();
        icd = new ICDStatic();
    }

    private static class ICDStatic
    implements ICD {
        @Nullable
        private static ALCapabilities tempCaps;

        private ICDStatic() {
        }

        @Override
        public void set(@Nullable ALCapabilities caps) {
            if (tempCaps == null) {
                tempCaps = caps;
            } else if (caps != null && caps != tempCaps && ThreadLocalUtil.areCapabilitiesDifferent(ICDStatic.tempCaps.addresses, caps.addresses)) {
                APIUtil.apiLog("[WARNING] Incompatible context detected. Falling back to thread/process lookup for AL contexts.");
                icd = AL::getCapabilities;
            }
        }

        @Override
        @Nullable
        public ALCapabilities get() {
            return WriteOnce.caps;
        }

        static /* synthetic */ ALCapabilities access$200() {
            return tempCaps;
        }

        private static final class WriteOnce {
            @Nullable
            static final ALCapabilities caps = ICDStatic.access$200();

            private WriteOnce() {
            }

            static {
                if (caps == null) {
                    throw new IllegalStateException("No ALCapabilities instance has been set");
                }
            }
        }
    }

    private static interface ICD {
        default public void set(@Nullable ALCapabilities caps) {
        }

        @Nullable
        public ALCapabilities get();
    }
}

