/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.CLongBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.macosx.CGEventTapCallBackI;
import org.lwjgl.system.macosx.CGEventTapInformation;
import org.lwjgl.system.macosx.CGPoint;

public class CoreGraphics {
    public static final int kCGErrorSuccess = 0;
    public static final int kCGErrorFailure = 1000;
    public static final int kCGErrorIllegalArgument = 1001;
    public static final int kCGErrorInvalidConnection = 1002;
    public static final int kCGErrorInvalidContext = 1003;
    public static final int kCGErrorCannotComplete = 1004;
    public static final int kCGErrorNotImplemented = 1006;
    public static final int kCGErrorRangeCheck = 1007;
    public static final int kCGErrorTypeCheck = 1008;
    public static final int kCGErrorInvalidOperation = 1010;
    public static final int kCGErrorNoneAvailable = 1011;
    public static final int kCGEventNull = 0;
    public static final int kCGEventLeftMouseDown = 1;
    public static final int kCGEventLeftMouseUp = 2;
    public static final int kCGEventRightMouseDown = 3;
    public static final int kCGEventRightMouseUp = 4;
    public static final int kCGEventMouseMoved = 5;
    public static final int kCGEventLeftMouseDragged = 6;
    public static final int kCGEventRightMouseDragged = 7;
    public static final int kCGEventKeyDown = 10;
    public static final int kCGEventKeyUp = 11;
    public static final int kCGEventFlagsChanged = 12;
    public static final int kCGEventScrollWheel = 22;
    public static final int kCGEventTabletPointer = 23;
    public static final int kCGEventTabletProximity = 24;
    public static final int kCGEventOtherMouseDown = 25;
    public static final int kCGEventOtherMouseUp = 26;
    public static final int kCGEventOtherMouseDragged = 27;
    public static final int kCGEventTapDisabledByTimeout = -2;
    public static final int kCGEventTapDisabledByUserInput = -1;
    public static final int kCGMouseButtonLeft = 0;
    public static final int kCGMouseButtonRight = 1;
    public static final int kCGMouseButtonCenter = 2;
    public static final int kCGHIDEventTap = 0;
    public static final int kCGSessionEventTap = 1;
    public static final int kCGAnnotatedSessionEventTap = 2;
    public static final int kCGScrollEventUnitPixel = 0;
    public static final int kCGScrollEventUnitLine = 1;
    public static final int kCGMouseEventNumber = 0;
    public static final int kCGMouseEventClickState = 1;
    public static final int kCGMouseEventPressure = 2;
    public static final int kCGMouseEventButtonNumber = 3;
    public static final int kCGMouseEventDeltaX = 4;
    public static final int kCGMouseEventDeltaY = 5;
    public static final int kCGMouseEventInstantMouser = 6;
    public static final int kCGMouseEventSubtype = 7;
    public static final int kCGKeyboardEventAutorepeat = 8;
    public static final int kCGKeyboardEventKeycode = 9;
    public static final int kCGKeyboardEventKeyboardType = 10;
    public static final int kCGScrollWheelEventDeltaAxis1 = 11;
    public static final int kCGScrollWheelEventDeltaAxis2 = 12;
    public static final int kCGScrollWheelEventDeltaAxis3 = 13;
    public static final int kCGScrollWheelEventFixedPtDeltaAxis1 = 93;
    public static final int kCGScrollWheelEventFixedPtDeltaAxis2 = 94;
    public static final int kCGScrollWheelEventFixedPtDeltaAxis3 = 95;
    public static final int kCGScrollWheelEventPointDeltaAxis1 = 96;
    public static final int kCGScrollWheelEventPointDeltaAxis2 = 97;
    public static final int kCGScrollWheelEventPointDeltaAxis3 = 98;
    public static final int kCGScrollWheelEventScrollPhase = 99;
    public static final int kCGScrollWheelEventScrollCount = 100;
    public static final int kCGScrollWheelEventMomentumPhase = 123;
    public static final int kCGScrollWheelEventInstantMouser = 14;
    public static final int kCGTabletEventPointX = 15;
    public static final int kCGTabletEventPointY = 16;
    public static final int kCGTabletEventPointZ = 17;
    public static final int kCGTabletEventPointButtons = 18;
    public static final int kCGTabletEventPointPressure = 19;
    public static final int kCGTabletEventTiltX = 20;
    public static final int kCGTabletEventTiltY = 21;
    public static final int kCGTabletEventRotation = 22;
    public static final int kCGTabletEventTangentialPressure = 23;
    public static final int kCGTabletEventDeviceID = 24;
    public static final int kCGTabletEventVendor1 = 25;
    public static final int kCGTabletEventVendor2 = 26;
    public static final int kCGTabletEventVendor3 = 27;
    public static final int kCGTabletProximityEventVendorID = 28;
    public static final int kCGTabletProximityEventTabletID = 29;
    public static final int kCGTabletProximityEventPointerID = 30;
    public static final int kCGTabletProximityEventDeviceID = 31;
    public static final int kCGTabletProximityEventSystemTabletID = 32;
    public static final int kCGTabletProximityEventVendorPointerType = 33;
    public static final int kCGTabletProximityEventVendorPointerSerialNumber = 34;
    public static final int kCGTabletProximityEventVendorUniqueID = 35;
    public static final int kCGTabletProximityEventCapabilityMask = 36;
    public static final int kCGTabletProximityEventPointerType = 37;
    public static final int kCGTabletProximityEventEnterProximity = 38;
    public static final int kCGEventTargetProcessSerialNumber = 39;
    public static final int kCGEventTargetUnixProcessID = 40;
    public static final int kCGEventSourceUnixProcessID = 41;
    public static final int kCGEventSourceUserData = 42;
    public static final int kCGEventSourceUserID = 43;
    public static final int kCGEventSourceGroupID = 44;
    public static final int kCGEventSourceStateID = 45;
    public static final int kCGScrollWheelEventIsContinuous = 88;
    public static final int kCGMouseEventWindowUnderMousePointer = 91;
    public static final int kCGMouseEventWindowUnderMousePointerThatCanHandleThisEvent = 92;
    public static final int kCGEventMouseSubtypeDefault = 0;
    public static final int kCGEventMouseSubtypeTabletPoint = 1;
    public static final int kCGEventMouseSubtypeTabletProximity = 2;
    private static final SharedLibrary COREGRAPHICS = Library.loadNative(CoreGraphics.class, "org.lwjgl", "/System/Library/Frameworks/CoreGraphics.framework");

    protected CoreGraphics() {
        throw new UnsupportedOperationException();
    }

    public static SharedLibrary getLibrary() {
        return COREGRAPHICS;
    }

    @NativeType(value="CFTypeID")
    public static long CGEventGetTypeID() {
        long __functionAddress = Functions.EventGetTypeID;
        return JNI.invokeJ(__functionAddress);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreate(@NativeType(value="CGEventSourceRef") long source) {
        long __functionAddress = Functions.EventCreate;
        return JNI.invokePP(source, __functionAddress);
    }

    @NativeType(value="CFDataRef")
    public static long CGEventCreateData(@NativeType(value="CFAllocatorRef") long allocator, @NativeType(value="CGEventRef") long event) {
        long __functionAddress = Functions.EventCreateData;
        return JNI.invokePPP(allocator, event, __functionAddress);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateFromData(@NativeType(value="CFAllocatorRef") long allocator, @NativeType(value="CFDataRef") long data) {
        long __functionAddress = Functions.EventCreateFromData;
        return JNI.invokePPP(allocator, data, __functionAddress);
    }

    public static native long nCGEventCreateMouseEvent(long var0, int var2, long var3, int var5, long var6);

    public static long nCGEventCreateMouseEvent(long source, int mouseType, long mouseCursorPosition, int mouseButton) {
        long __functionAddress = Functions.EventCreateMouseEvent;
        return CoreGraphics.nCGEventCreateMouseEvent(source, mouseType, mouseCursorPosition, mouseButton, __functionAddress);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateMouseEvent(@NativeType(value="CGEventSourceRef") long source, @NativeType(value="CGEventType") int mouseType, CGPoint mouseCursorPosition, @NativeType(value="CGMouseButton") int mouseButton) {
        return CoreGraphics.nCGEventCreateMouseEvent(source, mouseType, mouseCursorPosition.address(), mouseButton);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateKeyboardEvent(@NativeType(value="CGEventSourceRef") long source, @NativeType(value="CGKeyCode") short virtualKey, @NativeType(value="bool") boolean keyDown) {
        long __functionAddress = Functions.EventCreateKeyboardEvent;
        return JNI.invokePP(source, virtualKey, keyDown, __functionAddress);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateScrollWheelEvent(@NativeType(value="CGEventSourceRef") long source, @NativeType(value="CGScrollEventUnit") int units, @NativeType(value="uint32_t") int wheelCount, @NativeType(value="int32_t") int wheel1) {
        long __functionAddress = Functions.EventCreateScrollWheelEvent;
        return JNI.invokePP(source, units, wheelCount, wheel1, __functionAddress);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateScrollWheelEvent(@NativeType(value="CGEventSourceRef") long source, @NativeType(value="CGScrollEventUnit") int units, @NativeType(value="int32_t") int wheel1) {
        long __functionAddress = Functions.EventCreateScrollWheelEvent;
        return JNI.invokePP(source, units, 1, wheel1, __functionAddress);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateScrollWheelEvent2(@NativeType(value="CGEventSourceRef") long source, @NativeType(value="CGScrollEventUnit") int units, @NativeType(value="uint32_t") int wheelCount, @NativeType(value="int32_t") int wheel1, @NativeType(value="int32_t") int wheel2, @NativeType(value="int32_t") int wheel3) {
        long __functionAddress = Functions.EventCreateScrollWheelEvent2;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.invokePP(source, units, wheelCount, wheel1, wheel2, wheel3, __functionAddress);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateCopy(@NativeType(value="CGEventRef") long event) {
        long __functionAddress = Functions.EventCreateCopy;
        return JNI.invokePP(event, __functionAddress);
    }

    @NativeType(value="CGEventSourceRef")
    public static long CGEventCreateSourceFromEvent(@NativeType(value="CGEventRef") long event) {
        long __functionAddress = Functions.EventCreateSourceFromEvent;
        return JNI.invokePP(event, __functionAddress);
    }

    public static void CGEventSetSource(@NativeType(value="CGEventRef") long event, @NativeType(value="CGEventSourceRef") long source) {
        long __functionAddress = Functions.EventSetSource;
        JNI.invokePPV(event, source, __functionAddress);
    }

    @NativeType(value="CGEventType")
    public static int CGEventGetType(@NativeType(value="CGEventRef") long event) {
        long __functionAddress = Functions.EventGetType;
        return JNI.invokePI(event, __functionAddress);
    }

    public static void CGEventSetType(@NativeType(value="CGEventRef") long event, @NativeType(value="CGEventType") int type) {
        long __functionAddress = Functions.EventSetType;
        JNI.invokePV(event, type, __functionAddress);
    }

    @NativeType(value="CGEventTimestamp")
    public static long CGEventGetTimestamp(@NativeType(value="CGEventRef") long event) {
        long __functionAddress = Functions.EventGetTimestamp;
        return JNI.invokePJ(event, __functionAddress);
    }

    public static void CGEventSetTimestamp(@NativeType(value="CGEventRef") long event, @NativeType(value="CGEventTimestamp") long timestamp) {
        long __functionAddress = Functions.EventSetTimestamp;
        JNI.invokePJV(event, timestamp, __functionAddress);
    }

    public static native void nCGEventGetLocation(long var0, long var2, long var4);

    public static void nCGEventGetLocation(long event, long __result) {
        long __functionAddress = Functions.EventGetLocation;
        CoreGraphics.nCGEventGetLocation(event, __functionAddress, __result);
    }

    public static CGPoint CGEventGetLocation(@NativeType(value="CGEventRef") long event, CGPoint __result) {
        CoreGraphics.nCGEventGetLocation(event, __result.address());
        return __result;
    }

    public static native void nCGEventGetUnflippedLocation(long var0, long var2, long var4);

    public static void nCGEventGetUnflippedLocation(long event, long __result) {
        long __functionAddress = Functions.EventGetUnflippedLocation;
        CoreGraphics.nCGEventGetUnflippedLocation(event, __functionAddress, __result);
    }

    public static CGPoint CGEventGetUnflippedLocation(@NativeType(value="CGEventRef") long event, CGPoint __result) {
        CoreGraphics.nCGEventGetUnflippedLocation(event, __result.address());
        return __result;
    }

    public static native void nCGEventSetLocation(long var0, long var2, long var4);

    public static void nCGEventSetLocation(long event, long location) {
        long __functionAddress = Functions.EventSetLocation;
        CoreGraphics.nCGEventSetLocation(event, location, __functionAddress);
    }

    public static void CGEventSetLocation(@NativeType(value="CGEventRef") long event, CGPoint location) {
        CoreGraphics.nCGEventSetLocation(event, location.address());
    }

    @NativeType(value="CGEventFlags")
    public static long CGEventGetFlags(@NativeType(value="CGEventRef") long event) {
        long __functionAddress = Functions.EventGetFlags;
        return JNI.invokePJ(event, __functionAddress);
    }

    public static void CGEventSetFlags(@NativeType(value="CGEventRef") long event, @NativeType(value="CGEventFlags") long flags) {
        long __functionAddress = Functions.EventSetFlags;
        JNI.invokePJV(event, flags, __functionAddress);
    }

    public static void nCGEventKeyboardGetUnicodeString(long event, long maxStringLength, long actualStringLength, long unicodeString) {
        long __functionAddress = Functions.EventKeyboardGetUnicodeString;
        JNI.invokePNPPV(event, maxStringLength, actualStringLength, unicodeString, __functionAddress);
    }

    public static void CGEventKeyboardGetUnicodeString(@NativeType(value="CGEventRef") long event, @Nullable @NativeType(value="UniCharCount *") CLongBuffer actualStringLength, @Nullable @NativeType(value="UniChar *") ShortBuffer unicodeString) {
        if (Checks.CHECKS) {
            Checks.checkSafe(actualStringLength, 1);
        }
        CoreGraphics.nCGEventKeyboardGetUnicodeString(event, Checks.remainingSafe(unicodeString), MemoryUtil.memAddressSafe(actualStringLength), MemoryUtil.memAddressSafe(unicodeString));
    }

    public static void nCGEventKeyboardSetUnicodeString(long event, long stringLength, long unicodeString) {
        long __functionAddress = Functions.EventKeyboardSetUnicodeString;
        JNI.invokePNPV(event, stringLength, unicodeString, __functionAddress);
    }

    public static void CGEventKeyboardSetUnicodeString(@NativeType(value="CGEventRef") long event, @NativeType(value="UniChar const *") ShortBuffer unicodeString) {
        CoreGraphics.nCGEventKeyboardSetUnicodeString(event, unicodeString.remaining(), MemoryUtil.memAddress(unicodeString));
    }

    @NativeType(value="int64_t")
    public static long CGEventGetIntegerValueField(@NativeType(value="CGEventRef") long event, @NativeType(value="CGEventField") int field) {
        long __functionAddress = Functions.EventGetIntegerValueField;
        return JNI.invokePJ(event, field, __functionAddress);
    }

    public static void CGEventSetIntegerValueField(@NativeType(value="CGEventRef") long event, @NativeType(value="CGEventField") int field, @NativeType(value="int64_t") long value) {
        long __functionAddress = Functions.EventSetIntegerValueField;
        JNI.invokePJV(event, field, value, __functionAddress);
    }

    public static double CGEventGetDoubleValueField(@NativeType(value="CGEventRef") long event, @NativeType(value="CGEventField") int field) {
        long __functionAddress = Functions.EventGetDoubleValueField;
        return JNI.invokePD(event, field, __functionAddress);
    }

    public static void CGEventSetDoubleValueField(@NativeType(value="CGEventRef") long event, @NativeType(value="CGEventField") int field, double value) {
        long __functionAddress = Functions.EventSetDoubleValueField;
        JNI.invokePV(event, field, value, __functionAddress);
    }

    public static long nCGEventTapCreate(int tap, int place, int options, long eventsOfInterest, long callback, long userInfo) {
        long __functionAddress = Functions.EventTapCreate;
        return JNI.invokeJPPP(tap, place, options, eventsOfInterest, callback, userInfo, __functionAddress);
    }

    @NativeType(value="CFMachPortRef")
    public static long CGEventTapCreate(@NativeType(value="CGEventTapLocation") int tap, @NativeType(value="CGEventTapPlacement") int place, @NativeType(value="CGEventTapOptions") int options, @NativeType(value="CGEventMask") long eventsOfInterest, @NativeType(value="CGEventRef (*) (CGEventTapProxy, CGEventType, CGEventRef, void *)") CGEventTapCallBackI callback, @NativeType(value="void *") long userInfo) {
        return CoreGraphics.nCGEventTapCreate(tap, place, options, eventsOfInterest, callback.address(), userInfo);
    }

    public static long nCGEventTapCreateForPid(long pid, int place, int options, long eventsOfInterest, long callback, long userInfo) {
        long __functionAddress = Functions.EventTapCreateForPid;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(pid);
        }
        return JNI.invokePJPPP(pid, place, options, eventsOfInterest, callback, userInfo, __functionAddress);
    }

    @NativeType(value="CFMachPortRef")
    public static long CGEventTapCreateForPid(@NativeType(value="pid_t") long pid, @NativeType(value="CGEventTapPlacement") int place, @NativeType(value="CGEventTapOptions") int options, @NativeType(value="CGEventMask") long eventsOfInterest, @NativeType(value="CGEventRef (*) (CGEventTapProxy, CGEventType, CGEventRef, void *)") CGEventTapCallBackI callback, @NativeType(value="void *") long userInfo) {
        return CoreGraphics.nCGEventTapCreateForPid(pid, place, options, eventsOfInterest, callback.address(), userInfo);
    }

    public static void CGEventTapEnable(@NativeType(value="CFMachPortRef") long tap, @NativeType(value="bool") boolean enable) {
        long __functionAddress = Functions.EventTapEnable;
        if (Checks.CHECKS) {
            Checks.check(tap);
        }
        JNI.invokePV(tap, enable, __functionAddress);
    }

    @NativeType(value="bool")
    public static boolean CGEventTapIsEnabled(@NativeType(value="CFMachPortRef") long tap) {
        long __functionAddress = Functions.EventTapIsEnabled;
        if (Checks.CHECKS) {
            Checks.check(tap);
        }
        return JNI.invokePZ(tap, __functionAddress);
    }

    public static void CGEventTapPostEvent(@NativeType(value="CGEventTapProxy") long proxy, @NativeType(value="CGEventRef") long event) {
        long __functionAddress = Functions.EventTapPostEvent;
        JNI.invokePPV(proxy, event, __functionAddress);
    }

    public static void CGEventPost(@NativeType(value="CGEventTapLocation") int tap, @NativeType(value="CGEventRef") long event) {
        long __functionAddress = Functions.EventPost;
        if (Checks.CHECKS) {
            Checks.check(event);
        }
        JNI.invokePV(tap, event, __functionAddress);
    }

    public static void CGEventPostToPid(@NativeType(value="pid_t") long pid, @NativeType(value="CGEventRef") long event) {
        long __functionAddress = Functions.EventPostToPid;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(pid);
        }
        JNI.invokePPV(pid, event, __functionAddress);
    }

    public static int nCGGetEventTapList(int maxNumberOfTaps, long tapList, long eventTapCount) {
        long __functionAddress = Functions.GetEventTapList;
        return JNI.invokePPI(maxNumberOfTaps, tapList, eventTapCount, __functionAddress);
    }

    @NativeType(value="CGError")
    public static int CGGetEventTapList(@Nullable @NativeType(value="CGEventTapInformation *") CGEventTapInformation.Buffer tapList, @Nullable @NativeType(value="uint32_t *") IntBuffer eventTapCount) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)eventTapCount, 1);
        }
        return CoreGraphics.nCGGetEventTapList(Checks.remainingSafe(tapList), MemoryUtil.memAddressSafe(tapList), MemoryUtil.memAddressSafe(eventTapCount));
    }

    public static void CGEventKeyboardGetUnicodeString(@NativeType(value="CGEventRef") long event, @Nullable @NativeType(value="UniCharCount *") CLongBuffer actualStringLength, @Nullable @NativeType(value="UniChar *") short[] unicodeString) {
        long __functionAddress = Functions.EventKeyboardGetUnicodeString;
        if (Checks.CHECKS) {
            Checks.checkSafe(actualStringLength, 1);
        }
        JNI.invokePNPPV(event, (long)Checks.lengthSafe(unicodeString), MemoryUtil.memAddressSafe(actualStringLength), unicodeString, __functionAddress);
    }

    public static void CGEventKeyboardSetUnicodeString(@NativeType(value="CGEventRef") long event, @NativeType(value="UniChar const *") short[] unicodeString) {
        long __functionAddress = Functions.EventKeyboardSetUnicodeString;
        JNI.invokePNPV(event, (long)unicodeString.length, unicodeString, __functionAddress);
    }

    @NativeType(value="CGError")
    public static int CGGetEventTapList(@Nullable @NativeType(value="CGEventTapInformation *") CGEventTapInformation.Buffer tapList, @Nullable @NativeType(value="uint32_t *") int[] eventTapCount) {
        long __functionAddress = Functions.GetEventTapList;
        if (Checks.CHECKS) {
            Checks.checkSafe(eventTapCount, 1);
        }
        return JNI.invokePPI(Checks.remainingSafe(tapList), MemoryUtil.memAddressSafe(tapList), eventTapCount, __functionAddress);
    }

    static /* synthetic */ SharedLibrary access$000() {
        return COREGRAPHICS;
    }

    public static final class Functions {
        public static final long EventGetTypeID = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetTypeID");
        public static final long EventCreate = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreate");
        public static final long EventCreateData = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateData");
        public static final long EventCreateFromData = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateFromData");
        public static final long EventCreateMouseEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateMouseEvent");
        public static final long EventCreateKeyboardEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateKeyboardEvent");
        public static final long EventCreateScrollWheelEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateScrollWheelEvent");
        public static final long EventCreateScrollWheelEvent2 = CoreGraphics.access$000().getFunctionAddress("CGEventCreateScrollWheelEvent2");
        public static final long EventCreateCopy = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateCopy");
        public static final long EventCreateSourceFromEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateSourceFromEvent");
        public static final long EventSetSource = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetSource");
        public static final long EventGetType = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetType");
        public static final long EventSetType = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetType");
        public static final long EventGetTimestamp = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetTimestamp");
        public static final long EventSetTimestamp = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetTimestamp");
        public static final long EventGetLocation = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetLocation");
        public static final long EventGetUnflippedLocation = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetUnflippedLocation");
        public static final long EventSetLocation = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetLocation");
        public static final long EventGetFlags = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetFlags");
        public static final long EventSetFlags = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetFlags");
        public static final long EventKeyboardGetUnicodeString = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventKeyboardGetUnicodeString");
        public static final long EventKeyboardSetUnicodeString = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventKeyboardSetUnicodeString");
        public static final long EventGetIntegerValueField = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetIntegerValueField");
        public static final long EventSetIntegerValueField = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetIntegerValueField");
        public static final long EventGetDoubleValueField = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetDoubleValueField");
        public static final long EventSetDoubleValueField = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetDoubleValueField");
        public static final long EventTapCreate = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventTapCreate");
        public static final long EventTapCreateForPid = CoreGraphics.access$000().getFunctionAddress("CGEventTapCreateForPid");
        public static final long EventTapEnable = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventTapEnable");
        public static final long EventTapIsEnabled = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventTapIsEnabled");
        public static final long EventTapPostEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventTapPostEvent");
        public static final long EventPost = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventPost");
        public static final long EventPostToPid = CoreGraphics.access$000().getFunctionAddress("CGEventPostToPid");
        public static final long GetEventTapList = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGGetEventTapList");

        private Functions() {
        }
    }
}

