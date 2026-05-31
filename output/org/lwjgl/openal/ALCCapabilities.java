/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.util.Set;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.ALC11;
import org.lwjgl.openal.EXTCapture;
import org.lwjgl.openal.EXTThreadLocalContext;
import org.lwjgl.openal.SOFTDeviceClock;
import org.lwjgl.openal.SOFTHRTF;
import org.lwjgl.openal.SOFTLoopback;
import org.lwjgl.openal.SOFTPauseDevice;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.FunctionProviderLocal;

public final class ALCCapabilities {
    public final long alcOpenDevice;
    public final long alcCloseDevice;
    public final long alcCreateContext;
    public final long alcMakeContextCurrent;
    public final long alcProcessContext;
    public final long alcSuspendContext;
    public final long alcDestroyContext;
    public final long alcGetCurrentContext;
    public final long alcGetContextsDevice;
    public final long alcIsExtensionPresent;
    public final long alcGetProcAddress;
    public final long alcGetEnumValue;
    public final long alcGetError;
    public final long alcGetString;
    public final long alcGetIntegerv;
    public final long alcCaptureOpenDevice;
    public final long alcCaptureCloseDevice;
    public final long alcCaptureStart;
    public final long alcCaptureStop;
    public final long alcCaptureSamples;
    public final long alcSetThreadContext;
    public final long alcGetThreadContext;
    public final long alcGetInteger64vSOFT;
    public final long alcGetStringiSOFT;
    public final long alcResetDeviceSOFT;
    public final long alcLoopbackOpenDeviceSOFT;
    public final long alcIsRenderFormatSupportedSOFT;
    public final long alcRenderSamplesSOFT;
    public final long alcDevicePauseSOFT;
    public final long alcDeviceResumeSOFT;
    public final boolean OpenALC10;
    public final boolean OpenALC11;
    public final boolean ALC_ENUMERATE_ALL_EXT;
    public final boolean ALC_ENUMERATION_EXT;
    public final boolean ALC_EXT_CAPTURE;
    public final boolean ALC_EXT_DEDICATED;
    public final boolean ALC_EXT_DEFAULT_FILTER_ORDER;
    public final boolean ALC_EXT_disconnect;
    public final boolean ALC_EXT_EFX;
    public final boolean ALC_EXT_thread_local_context;
    public final boolean ALC_LOKI_audio_channel;
    public final boolean ALC_SOFT_device_clock;
    public final boolean ALC_SOFT_HRTF;
    public final boolean ALC_SOFT_loopback;
    public final boolean ALC_SOFT_output_limiter;
    public final boolean ALC_SOFT_pause_device;

    ALCCapabilities(FunctionProviderLocal provider, long device, Set<String> ext) {
        this.alcOpenDevice = provider.getFunctionAddress("alcOpenDevice");
        this.alcCloseDevice = provider.getFunctionAddress("alcCloseDevice");
        this.alcCreateContext = provider.getFunctionAddress("alcCreateContext");
        this.alcMakeContextCurrent = provider.getFunctionAddress("alcMakeContextCurrent");
        this.alcProcessContext = provider.getFunctionAddress("alcProcessContext");
        this.alcSuspendContext = provider.getFunctionAddress("alcSuspendContext");
        this.alcDestroyContext = provider.getFunctionAddress("alcDestroyContext");
        this.alcGetCurrentContext = provider.getFunctionAddress("alcGetCurrentContext");
        this.alcGetContextsDevice = provider.getFunctionAddress("alcGetContextsDevice");
        this.alcIsExtensionPresent = provider.getFunctionAddress("alcIsExtensionPresent");
        this.alcGetProcAddress = provider.getFunctionAddress("alcGetProcAddress");
        this.alcGetEnumValue = provider.getFunctionAddress("alcGetEnumValue");
        this.alcGetError = provider.getFunctionAddress("alcGetError");
        this.alcGetString = provider.getFunctionAddress("alcGetString");
        this.alcGetIntegerv = provider.getFunctionAddress("alcGetIntegerv");
        this.alcCaptureOpenDevice = provider.getFunctionAddress("alcCaptureOpenDevice");
        this.alcCaptureCloseDevice = provider.getFunctionAddress("alcCaptureCloseDevice");
        this.alcCaptureStart = provider.getFunctionAddress("alcCaptureStart");
        this.alcCaptureStop = provider.getFunctionAddress("alcCaptureStop");
        this.alcCaptureSamples = provider.getFunctionAddress("alcCaptureSamples");
        this.alcSetThreadContext = provider.getFunctionAddress(device, "alcSetThreadContext");
        this.alcGetThreadContext = provider.getFunctionAddress(device, "alcGetThreadContext");
        this.alcGetInteger64vSOFT = provider.getFunctionAddress(device, "alcGetInteger64vSOFT");
        this.alcGetStringiSOFT = provider.getFunctionAddress(device, "alcGetStringiSOFT");
        this.alcResetDeviceSOFT = provider.getFunctionAddress(device, "alcResetDeviceSOFT");
        this.alcLoopbackOpenDeviceSOFT = provider.getFunctionAddress(device, "alcLoopbackOpenDeviceSOFT");
        this.alcIsRenderFormatSupportedSOFT = provider.getFunctionAddress(device, "alcIsRenderFormatSupportedSOFT");
        this.alcRenderSamplesSOFT = provider.getFunctionAddress(device, "alcRenderSamplesSOFT");
        this.alcDevicePauseSOFT = provider.getFunctionAddress(device, "alcDevicePauseSOFT");
        this.alcDeviceResumeSOFT = provider.getFunctionAddress(device, "alcDeviceResumeSOFT");
        this.OpenALC10 = ext.contains("OpenALC10") && ALCCapabilities.checkExtension("OpenALC10", ALC10.isAvailable(this));
        this.OpenALC11 = ext.contains("OpenALC11") && ALCCapabilities.checkExtension("OpenALC11", ALC11.isAvailable(this));
        this.ALC_ENUMERATE_ALL_EXT = ext.contains("ALC_ENUMERATE_ALL_EXT");
        this.ALC_ENUMERATION_EXT = ext.contains("ALC_ENUMERATION_EXT");
        this.ALC_EXT_CAPTURE = ext.contains("ALC_EXT_CAPTURE") && ALCCapabilities.checkExtension("ALC_EXT_CAPTURE", EXTCapture.isAvailable(this));
        this.ALC_EXT_DEDICATED = ext.contains("ALC_EXT_DEDICATED");
        this.ALC_EXT_DEFAULT_FILTER_ORDER = ext.contains("ALC_EXT_DEFAULT_FILTER_ORDER");
        this.ALC_EXT_disconnect = ext.contains("ALC_EXT_disconnect");
        this.ALC_EXT_EFX = ext.contains("ALC_EXT_EFX");
        this.ALC_EXT_thread_local_context = ext.contains("ALC_EXT_thread_local_context") && ALCCapabilities.checkExtension("ALC_EXT_thread_local_context", EXTThreadLocalContext.isAvailable(this));
        this.ALC_LOKI_audio_channel = ext.contains("ALC_LOKI_audio_channel");
        this.ALC_SOFT_device_clock = ext.contains("ALC_SOFT_device_clock") && ALCCapabilities.checkExtension("ALC_SOFT_device_clock", SOFTDeviceClock.isAvailable(this));
        this.ALC_SOFT_HRTF = ext.contains("ALC_SOFT_HRTF") && ALCCapabilities.checkExtension("ALC_SOFT_HRTF", SOFTHRTF.isAvailable(this));
        this.ALC_SOFT_loopback = ext.contains("ALC_SOFT_loopback") && ALCCapabilities.checkExtension("ALC_SOFT_loopback", SOFTLoopback.isAvailable(this));
        this.ALC_SOFT_output_limiter = ext.contains("ALC_SOFT_output_limiter");
        this.ALC_SOFT_pause_device = ext.contains("ALC_SOFT_pause_device") && ALCCapabilities.checkExtension("ALC_SOFT_pause_device", SOFTPauseDevice.isAvailable(this));
    }

    private static boolean checkExtension(String extension, boolean supported) {
        if (supported) {
            return true;
        }
        APIUtil.apiLog("[ALC] " + extension + " was reported as available but an entry point is missing.");
        return false;
    }
}

