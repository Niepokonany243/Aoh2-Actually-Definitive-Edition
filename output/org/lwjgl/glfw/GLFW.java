/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.EventLoop;
import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWCharCallbackI;
import org.lwjgl.glfw.GLFWCharModsCallback;
import org.lwjgl.glfw.GLFWCharModsCallbackI;
import org.lwjgl.glfw.GLFWCursorEnterCallback;
import org.lwjgl.glfw.GLFWCursorEnterCallbackI;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;
import org.lwjgl.glfw.GLFWDropCallback;
import org.lwjgl.glfw.GLFWDropCallbackI;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWErrorCallbackI;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWFramebufferSizeCallbackI;
import org.lwjgl.glfw.GLFWGamepadState;
import org.lwjgl.glfw.GLFWGammaRamp;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.glfw.GLFWJoystickCallback;
import org.lwjgl.glfw.GLFWJoystickCallbackI;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import org.lwjgl.glfw.GLFWMonitorCallback;
import org.lwjgl.glfw.GLFWMonitorCallbackI;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallbackI;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.glfw.GLFWScrollCallbackI;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowCloseCallback;
import org.lwjgl.glfw.GLFWWindowCloseCallbackI;
import org.lwjgl.glfw.GLFWWindowContentScaleCallback;
import org.lwjgl.glfw.GLFWWindowContentScaleCallbackI;
import org.lwjgl.glfw.GLFWWindowFocusCallback;
import org.lwjgl.glfw.GLFWWindowFocusCallbackI;
import org.lwjgl.glfw.GLFWWindowIconifyCallback;
import org.lwjgl.glfw.GLFWWindowIconifyCallbackI;
import org.lwjgl.glfw.GLFWWindowMaximizeCallback;
import org.lwjgl.glfw.GLFWWindowMaximizeCallbackI;
import org.lwjgl.glfw.GLFWWindowPosCallback;
import org.lwjgl.glfw.GLFWWindowPosCallbackI;
import org.lwjgl.glfw.GLFWWindowRefreshCallback;
import org.lwjgl.glfw.GLFWWindowRefreshCallbackI;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallbackI;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Platform;
import org.lwjgl.system.SharedLibrary;

public class GLFW {
    public static final int GLFW_VERSION_MAJOR = 3;
    public static final int GLFW_VERSION_MINOR = 4;
    public static final int GLFW_VERSION_REVISION = 0;
    public static final int GLFW_TRUE = 1;
    public static final int GLFW_FALSE = 0;
    public static final int GLFW_RELEASE = 0;
    public static final int GLFW_PRESS = 1;
    public static final int GLFW_REPEAT = 2;
    public static final int GLFW_HAT_CENTERED = 0;
    public static final int GLFW_HAT_UP = 1;
    public static final int GLFW_HAT_RIGHT = 2;
    public static final int GLFW_HAT_DOWN = 4;
    public static final int GLFW_HAT_LEFT = 8;
    public static final int GLFW_HAT_RIGHT_UP = 3;
    public static final int GLFW_HAT_RIGHT_DOWN = 6;
    public static final int GLFW_HAT_LEFT_UP = 9;
    public static final int GLFW_HAT_LEFT_DOWN = 12;
    public static final int GLFW_KEY_UNKNOWN = -1;
    public static final int GLFW_KEY_SPACE = 32;
    public static final int GLFW_KEY_APOSTROPHE = 39;
    public static final int GLFW_KEY_COMMA = 44;
    public static final int GLFW_KEY_MINUS = 45;
    public static final int GLFW_KEY_PERIOD = 46;
    public static final int GLFW_KEY_SLASH = 47;
    public static final int GLFW_KEY_0 = 48;
    public static final int GLFW_KEY_1 = 49;
    public static final int GLFW_KEY_2 = 50;
    public static final int GLFW_KEY_3 = 51;
    public static final int GLFW_KEY_4 = 52;
    public static final int GLFW_KEY_5 = 53;
    public static final int GLFW_KEY_6 = 54;
    public static final int GLFW_KEY_7 = 55;
    public static final int GLFW_KEY_8 = 56;
    public static final int GLFW_KEY_9 = 57;
    public static final int GLFW_KEY_SEMICOLON = 59;
    public static final int GLFW_KEY_EQUAL = 61;
    public static final int GLFW_KEY_A = 65;
    public static final int GLFW_KEY_B = 66;
    public static final int GLFW_KEY_C = 67;
    public static final int GLFW_KEY_D = 68;
    public static final int GLFW_KEY_E = 69;
    public static final int GLFW_KEY_F = 70;
    public static final int GLFW_KEY_G = 71;
    public static final int GLFW_KEY_H = 72;
    public static final int GLFW_KEY_I = 73;
    public static final int GLFW_KEY_J = 74;
    public static final int GLFW_KEY_K = 75;
    public static final int GLFW_KEY_L = 76;
    public static final int GLFW_KEY_M = 77;
    public static final int GLFW_KEY_N = 78;
    public static final int GLFW_KEY_O = 79;
    public static final int GLFW_KEY_P = 80;
    public static final int GLFW_KEY_Q = 81;
    public static final int GLFW_KEY_R = 82;
    public static final int GLFW_KEY_S = 83;
    public static final int GLFW_KEY_T = 84;
    public static final int GLFW_KEY_U = 85;
    public static final int GLFW_KEY_V = 86;
    public static final int GLFW_KEY_W = 87;
    public static final int GLFW_KEY_X = 88;
    public static final int GLFW_KEY_Y = 89;
    public static final int GLFW_KEY_Z = 90;
    public static final int GLFW_KEY_LEFT_BRACKET = 91;
    public static final int GLFW_KEY_BACKSLASH = 92;
    public static final int GLFW_KEY_RIGHT_BRACKET = 93;
    public static final int GLFW_KEY_GRAVE_ACCENT = 96;
    public static final int GLFW_KEY_WORLD_1 = 161;
    public static final int GLFW_KEY_WORLD_2 = 162;
    public static final int GLFW_KEY_ESCAPE = 256;
    public static final int GLFW_KEY_ENTER = 257;
    public static final int GLFW_KEY_TAB = 258;
    public static final int GLFW_KEY_BACKSPACE = 259;
    public static final int GLFW_KEY_INSERT = 260;
    public static final int GLFW_KEY_DELETE = 261;
    public static final int GLFW_KEY_RIGHT = 262;
    public static final int GLFW_KEY_LEFT = 263;
    public static final int GLFW_KEY_DOWN = 264;
    public static final int GLFW_KEY_UP = 265;
    public static final int GLFW_KEY_PAGE_UP = 266;
    public static final int GLFW_KEY_PAGE_DOWN = 267;
    public static final int GLFW_KEY_HOME = 268;
    public static final int GLFW_KEY_END = 269;
    public static final int GLFW_KEY_CAPS_LOCK = 280;
    public static final int GLFW_KEY_SCROLL_LOCK = 281;
    public static final int GLFW_KEY_NUM_LOCK = 282;
    public static final int GLFW_KEY_PRINT_SCREEN = 283;
    public static final int GLFW_KEY_PAUSE = 284;
    public static final int GLFW_KEY_F1 = 290;
    public static final int GLFW_KEY_F2 = 291;
    public static final int GLFW_KEY_F3 = 292;
    public static final int GLFW_KEY_F4 = 293;
    public static final int GLFW_KEY_F5 = 294;
    public static final int GLFW_KEY_F6 = 295;
    public static final int GLFW_KEY_F7 = 296;
    public static final int GLFW_KEY_F8 = 297;
    public static final int GLFW_KEY_F9 = 298;
    public static final int GLFW_KEY_F10 = 299;
    public static final int GLFW_KEY_F11 = 300;
    public static final int GLFW_KEY_F12 = 301;
    public static final int GLFW_KEY_F13 = 302;
    public static final int GLFW_KEY_F14 = 303;
    public static final int GLFW_KEY_F15 = 304;
    public static final int GLFW_KEY_F16 = 305;
    public static final int GLFW_KEY_F17 = 306;
    public static final int GLFW_KEY_F18 = 307;
    public static final int GLFW_KEY_F19 = 308;
    public static final int GLFW_KEY_F20 = 309;
    public static final int GLFW_KEY_F21 = 310;
    public static final int GLFW_KEY_F22 = 311;
    public static final int GLFW_KEY_F23 = 312;
    public static final int GLFW_KEY_F24 = 313;
    public static final int GLFW_KEY_F25 = 314;
    public static final int GLFW_KEY_KP_0 = 320;
    public static final int GLFW_KEY_KP_1 = 321;
    public static final int GLFW_KEY_KP_2 = 322;
    public static final int GLFW_KEY_KP_3 = 323;
    public static final int GLFW_KEY_KP_4 = 324;
    public static final int GLFW_KEY_KP_5 = 325;
    public static final int GLFW_KEY_KP_6 = 326;
    public static final int GLFW_KEY_KP_7 = 327;
    public static final int GLFW_KEY_KP_8 = 328;
    public static final int GLFW_KEY_KP_9 = 329;
    public static final int GLFW_KEY_KP_DECIMAL = 330;
    public static final int GLFW_KEY_KP_DIVIDE = 331;
    public static final int GLFW_KEY_KP_MULTIPLY = 332;
    public static final int GLFW_KEY_KP_SUBTRACT = 333;
    public static final int GLFW_KEY_KP_ADD = 334;
    public static final int GLFW_KEY_KP_ENTER = 335;
    public static final int GLFW_KEY_KP_EQUAL = 336;
    public static final int GLFW_KEY_LEFT_SHIFT = 340;
    public static final int GLFW_KEY_LEFT_CONTROL = 341;
    public static final int GLFW_KEY_LEFT_ALT = 342;
    public static final int GLFW_KEY_LEFT_SUPER = 343;
    public static final int GLFW_KEY_RIGHT_SHIFT = 344;
    public static final int GLFW_KEY_RIGHT_CONTROL = 345;
    public static final int GLFW_KEY_RIGHT_ALT = 346;
    public static final int GLFW_KEY_RIGHT_SUPER = 347;
    public static final int GLFW_KEY_MENU = 348;
    public static final int GLFW_KEY_LAST = 348;
    public static final int GLFW_MOD_SHIFT = 1;
    public static final int GLFW_MOD_CONTROL = 2;
    public static final int GLFW_MOD_ALT = 4;
    public static final int GLFW_MOD_SUPER = 8;
    public static final int GLFW_MOD_CAPS_LOCK = 16;
    public static final int GLFW_MOD_NUM_LOCK = 32;
    public static final int GLFW_MOUSE_BUTTON_1 = 0;
    public static final int GLFW_MOUSE_BUTTON_2 = 1;
    public static final int GLFW_MOUSE_BUTTON_3 = 2;
    public static final int GLFW_MOUSE_BUTTON_4 = 3;
    public static final int GLFW_MOUSE_BUTTON_5 = 4;
    public static final int GLFW_MOUSE_BUTTON_6 = 5;
    public static final int GLFW_MOUSE_BUTTON_7 = 6;
    public static final int GLFW_MOUSE_BUTTON_8 = 7;
    public static final int GLFW_MOUSE_BUTTON_LAST = 7;
    public static final int GLFW_MOUSE_BUTTON_LEFT = 0;
    public static final int GLFW_MOUSE_BUTTON_RIGHT = 1;
    public static final int GLFW_MOUSE_BUTTON_MIDDLE = 2;
    public static final int GLFW_JOYSTICK_1 = 0;
    public static final int GLFW_JOYSTICK_2 = 1;
    public static final int GLFW_JOYSTICK_3 = 2;
    public static final int GLFW_JOYSTICK_4 = 3;
    public static final int GLFW_JOYSTICK_5 = 4;
    public static final int GLFW_JOYSTICK_6 = 5;
    public static final int GLFW_JOYSTICK_7 = 6;
    public static final int GLFW_JOYSTICK_8 = 7;
    public static final int GLFW_JOYSTICK_9 = 8;
    public static final int GLFW_JOYSTICK_10 = 9;
    public static final int GLFW_JOYSTICK_11 = 10;
    public static final int GLFW_JOYSTICK_12 = 11;
    public static final int GLFW_JOYSTICK_13 = 12;
    public static final int GLFW_JOYSTICK_14 = 13;
    public static final int GLFW_JOYSTICK_15 = 14;
    public static final int GLFW_JOYSTICK_16 = 15;
    public static final int GLFW_JOYSTICK_LAST = 15;
    public static final int GLFW_GAMEPAD_BUTTON_A = 0;
    public static final int GLFW_GAMEPAD_BUTTON_B = 1;
    public static final int GLFW_GAMEPAD_BUTTON_X = 2;
    public static final int GLFW_GAMEPAD_BUTTON_Y = 3;
    public static final int GLFW_GAMEPAD_BUTTON_LEFT_BUMPER = 4;
    public static final int GLFW_GAMEPAD_BUTTON_RIGHT_BUMPER = 5;
    public static final int GLFW_GAMEPAD_BUTTON_BACK = 6;
    public static final int GLFW_GAMEPAD_BUTTON_START = 7;
    public static final int GLFW_GAMEPAD_BUTTON_GUIDE = 8;
    public static final int GLFW_GAMEPAD_BUTTON_LEFT_THUMB = 9;
    public static final int GLFW_GAMEPAD_BUTTON_RIGHT_THUMB = 10;
    public static final int GLFW_GAMEPAD_BUTTON_DPAD_UP = 11;
    public static final int GLFW_GAMEPAD_BUTTON_DPAD_RIGHT = 12;
    public static final int GLFW_GAMEPAD_BUTTON_DPAD_DOWN = 13;
    public static final int GLFW_GAMEPAD_BUTTON_DPAD_LEFT = 14;
    public static final int GLFW_GAMEPAD_BUTTON_LAST = 14;
    public static final int GLFW_GAMEPAD_BUTTON_CROSS = 0;
    public static final int GLFW_GAMEPAD_BUTTON_CIRCLE = 1;
    public static final int GLFW_GAMEPAD_BUTTON_SQUARE = 2;
    public static final int GLFW_GAMEPAD_BUTTON_TRIANGLE = 3;
    public static final int GLFW_GAMEPAD_AXIS_LEFT_X = 0;
    public static final int GLFW_GAMEPAD_AXIS_LEFT_Y = 1;
    public static final int GLFW_GAMEPAD_AXIS_RIGHT_X = 2;
    public static final int GLFW_GAMEPAD_AXIS_RIGHT_Y = 3;
    public static final int GLFW_GAMEPAD_AXIS_LEFT_TRIGGER = 4;
    public static final int GLFW_GAMEPAD_AXIS_RIGHT_TRIGGER = 5;
    public static final int GLFW_GAMEPAD_AXIS_LAST = 5;
    public static final int GLFW_NO_ERROR = 0;
    public static final int GLFW_NOT_INITIALIZED = 65537;
    public static final int GLFW_NO_CURRENT_CONTEXT = 65538;
    public static final int GLFW_INVALID_ENUM = 65539;
    public static final int GLFW_INVALID_VALUE = 65540;
    public static final int GLFW_OUT_OF_MEMORY = 65541;
    public static final int GLFW_API_UNAVAILABLE = 65542;
    public static final int GLFW_VERSION_UNAVAILABLE = 65543;
    public static final int GLFW_PLATFORM_ERROR = 65544;
    public static final int GLFW_FORMAT_UNAVAILABLE = 65545;
    public static final int GLFW_NO_WINDOW_CONTEXT = 65546;
    public static final int GLFW_FOCUSED = 131073;
    public static final int GLFW_ICONIFIED = 131074;
    public static final int GLFW_RESIZABLE = 131075;
    public static final int GLFW_VISIBLE = 131076;
    public static final int GLFW_DECORATED = 131077;
    public static final int GLFW_AUTO_ICONIFY = 131078;
    public static final int GLFW_FLOATING = 131079;
    public static final int GLFW_MAXIMIZED = 131080;
    public static final int GLFW_CENTER_CURSOR = 131081;
    public static final int GLFW_TRANSPARENT_FRAMEBUFFER = 131082;
    public static final int GLFW_HOVERED = 131083;
    public static final int GLFW_FOCUS_ON_SHOW = 131084;
    public static final int GLFW_CURSOR = 208897;
    public static final int GLFW_STICKY_KEYS = 208898;
    public static final int GLFW_STICKY_MOUSE_BUTTONS = 208899;
    public static final int GLFW_LOCK_KEY_MODS = 208900;
    public static final int GLFW_RAW_MOUSE_MOTION = 208901;
    public static final int GLFW_CURSOR_NORMAL = 212993;
    public static final int GLFW_CURSOR_HIDDEN = 212994;
    public static final int GLFW_CURSOR_DISABLED = 212995;
    public static final int GLFW_ARROW_CURSOR = 221185;
    public static final int GLFW_IBEAM_CURSOR = 221186;
    public static final int GLFW_CROSSHAIR_CURSOR = 221187;
    public static final int GLFW_HAND_CURSOR = 221188;
    public static final int GLFW_HRESIZE_CURSOR = 221189;
    public static final int GLFW_VRESIZE_CURSOR = 221190;
    public static final int GLFW_CONNECTED = 262145;
    public static final int GLFW_DISCONNECTED = 262146;
    public static final int GLFW_JOYSTICK_HAT_BUTTONS = 327681;
    public static final int GLFW_COCOA_CHDIR_RESOURCES = 331777;
    public static final int GLFW_COCOA_MENUBAR = 331778;
    public static final int GLFW_DONT_CARE = -1;
    public static final int GLFW_RED_BITS = 135169;
    public static final int GLFW_GREEN_BITS = 135170;
    public static final int GLFW_BLUE_BITS = 135171;
    public static final int GLFW_ALPHA_BITS = 135172;
    public static final int GLFW_DEPTH_BITS = 135173;
    public static final int GLFW_STENCIL_BITS = 135174;
    public static final int GLFW_ACCUM_RED_BITS = 135175;
    public static final int GLFW_ACCUM_GREEN_BITS = 135176;
    public static final int GLFW_ACCUM_BLUE_BITS = 135177;
    public static final int GLFW_ACCUM_ALPHA_BITS = 135178;
    public static final int GLFW_AUX_BUFFERS = 135179;
    public static final int GLFW_STEREO = 135180;
    public static final int GLFW_SAMPLES = 135181;
    public static final int GLFW_SRGB_CAPABLE = 135182;
    public static final int GLFW_REFRESH_RATE = 135183;
    public static final int GLFW_DOUBLEBUFFER = 135184;
    public static final int GLFW_CLIENT_API = 139265;
    public static final int GLFW_CONTEXT_VERSION_MAJOR = 139266;
    public static final int GLFW_CONTEXT_VERSION_MINOR = 139267;
    public static final int GLFW_CONTEXT_REVISION = 139268;
    public static final int GLFW_CONTEXT_ROBUSTNESS = 139269;
    public static final int GLFW_OPENGL_FORWARD_COMPAT = 139270;
    public static final int GLFW_OPENGL_DEBUG_CONTEXT = 139271;
    public static final int GLFW_OPENGL_PROFILE = 139272;
    public static final int GLFW_CONTEXT_RELEASE_BEHAVIOR = 139273;
    public static final int GLFW_CONTEXT_NO_ERROR = 139274;
    public static final int GLFW_CONTEXT_CREATION_API = 139275;
    public static final int GLFW_SCALE_TO_MONITOR = 139276;
    public static final int GLFW_COCOA_RETINA_FRAMEBUFFER = 143361;
    public static final int GLFW_COCOA_FRAME_NAME = 143362;
    public static final int GLFW_COCOA_GRAPHICS_SWITCHING = 143363;
    public static final int GLFW_X11_CLASS_NAME = 147457;
    public static final int GLFW_X11_INSTANCE_NAME = 147458;
    public static final int GLFW_NO_API = 0;
    public static final int GLFW_OPENGL_API = 196609;
    public static final int GLFW_OPENGL_ES_API = 196610;
    public static final int GLFW_NO_ROBUSTNESS = 0;
    public static final int GLFW_NO_RESET_NOTIFICATION = 200705;
    public static final int GLFW_LOSE_CONTEXT_ON_RESET = 200706;
    public static final int GLFW_OPENGL_ANY_PROFILE = 0;
    public static final int GLFW_OPENGL_CORE_PROFILE = 204801;
    public static final int GLFW_OPENGL_COMPAT_PROFILE = 204802;
    public static final int GLFW_ANY_RELEASE_BEHAVIOR = 0;
    public static final int GLFW_RELEASE_BEHAVIOR_FLUSH = 217089;
    public static final int GLFW_RELEASE_BEHAVIOR_NONE = 217090;
    public static final int GLFW_NATIVE_CONTEXT_API = 221185;
    public static final int GLFW_EGL_CONTEXT_API = 221186;
    public static final int GLFW_OSMESA_CONTEXT_API = 221187;
    private static final SharedLibrary GLFW = Library.loadNative(GLFW.class, "org.lwjgl.glfw", Configuration.GLFW_LIBRARY_NAME.get(Platform.mapLibraryNameBundled("glfw")), true);

    protected GLFW() {
        throw new UnsupportedOperationException();
    }

    public static SharedLibrary getLibrary() {
        return GLFW;
    }

    @NativeType(value="int")
    public static boolean glfwInit() {
        long __functionAddress = Functions.Init;
        return JNI.invokeI(__functionAddress) != 0;
    }

    public static void glfwTerminate() {
        long __functionAddress = Functions.Terminate;
        JNI.invokeV(__functionAddress);
    }

    public static void glfwInitHint(int hint, int value) {
        long __functionAddress = Functions.InitHint;
        JNI.invokeV(hint, value, __functionAddress);
    }

    public static void nglfwGetVersion(long major, long minor, long rev) {
        long __functionAddress = Functions.GetVersion;
        JNI.invokePPPV(major, minor, rev, __functionAddress);
    }

    public static void glfwGetVersion(@Nullable @NativeType(value="int *") IntBuffer major, @Nullable @NativeType(value="int *") IntBuffer minor, @Nullable @NativeType(value="int *") IntBuffer rev) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)major, 1);
            Checks.checkSafe((Buffer)minor, 1);
            Checks.checkSafe((Buffer)rev, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetVersion(MemoryUtil.memAddressSafe(major), MemoryUtil.memAddressSafe(minor), MemoryUtil.memAddressSafe(rev));
    }

    public static long nglfwGetVersionString() {
        long __functionAddress = Functions.GetVersionString;
        return JNI.invokeP(__functionAddress);
    }

    @NativeType(value="char const *")
    public static String glfwGetVersionString() {
        long __result = org.lwjgl.glfw.GLFW.nglfwGetVersionString();
        return MemoryUtil.memASCII(__result);
    }

    public static int nglfwGetError(long description) {
        long __functionAddress = Functions.GetError;
        return JNI.invokePI(description, __functionAddress);
    }

    public static int glfwGetError(@Nullable @NativeType(value="char const **") PointerBuffer description) {
        if (Checks.CHECKS) {
            Checks.checkSafe(description, 1);
        }
        return org.lwjgl.glfw.GLFW.nglfwGetError(MemoryUtil.memAddressSafe(description));
    }

    public static long nglfwSetErrorCallback(long cbfun) {
        long __functionAddress = Functions.SetErrorCallback;
        return JNI.invokePP(cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWerrorfun")
    public static GLFWErrorCallback glfwSetErrorCallback(@Nullable @NativeType(value="GLFWerrorfun") GLFWErrorCallbackI cbfun) {
        return GLFWErrorCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetErrorCallback(MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwGetMonitors(long count) {
        long __functionAddress = Functions.GetMonitors;
        return JNI.invokePP(count, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="GLFWmonitor **")
    public static PointerBuffer glfwGetMonitors() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer count = stack.callocInt(1);
        try {
            long __result = org.lwjgl.glfw.GLFW.nglfwGetMonitors(MemoryUtil.memAddress(count));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, count.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLFWmonitor *")
    public static long glfwGetPrimaryMonitor() {
        long __functionAddress = Functions.GetPrimaryMonitor;
        return JNI.invokeP(__functionAddress);
    }

    public static void nglfwGetMonitorPos(long monitor, long xpos, long ypos) {
        long __functionAddress = Functions.GetMonitorPos;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        JNI.invokePPPV(monitor, xpos, ypos, __functionAddress);
    }

    public static void glfwGetMonitorPos(@NativeType(value="GLFWmonitor *") long monitor, @Nullable @NativeType(value="int *") IntBuffer xpos, @Nullable @NativeType(value="int *") IntBuffer ypos) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)xpos, 1);
            Checks.checkSafe((Buffer)ypos, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetMonitorPos(monitor, MemoryUtil.memAddressSafe(xpos), MemoryUtil.memAddressSafe(ypos));
    }

    public static void nglfwGetMonitorWorkarea(long monitor, long xpos, long ypos, long width, long height) {
        long __functionAddress = Functions.GetMonitorWorkarea;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        JNI.invokePPPPPV(monitor, xpos, ypos, width, height, __functionAddress);
    }

    public static void glfwGetMonitorWorkarea(@NativeType(value="GLFWmonitor *") long monitor, @Nullable @NativeType(value="int *") IntBuffer xpos, @Nullable @NativeType(value="int *") IntBuffer ypos, @Nullable @NativeType(value="int *") IntBuffer width, @Nullable @NativeType(value="int *") IntBuffer height) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)xpos, 1);
            Checks.checkSafe((Buffer)ypos, 1);
            Checks.checkSafe((Buffer)width, 1);
            Checks.checkSafe((Buffer)height, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetMonitorWorkarea(monitor, MemoryUtil.memAddressSafe(xpos), MemoryUtil.memAddressSafe(ypos), MemoryUtil.memAddressSafe(width), MemoryUtil.memAddressSafe(height));
    }

    public static void nglfwGetMonitorPhysicalSize(long monitor, long widthMM, long heightMM) {
        long __functionAddress = Functions.GetMonitorPhysicalSize;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        JNI.invokePPPV(monitor, widthMM, heightMM, __functionAddress);
    }

    public static void glfwGetMonitorPhysicalSize(@NativeType(value="GLFWmonitor *") long monitor, @Nullable @NativeType(value="int *") IntBuffer widthMM, @Nullable @NativeType(value="int *") IntBuffer heightMM) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)widthMM, 1);
            Checks.checkSafe((Buffer)heightMM, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetMonitorPhysicalSize(monitor, MemoryUtil.memAddressSafe(widthMM), MemoryUtil.memAddressSafe(heightMM));
    }

    public static void nglfwGetMonitorContentScale(long monitor, long xscale, long yscale) {
        long __functionAddress = Functions.GetMonitorContentScale;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        JNI.invokePPPV(monitor, xscale, yscale, __functionAddress);
    }

    public static void glfwGetMonitorContentScale(@NativeType(value="GLFWmonitor *") long monitor, @Nullable @NativeType(value="float *") FloatBuffer xscale, @Nullable @NativeType(value="float *") FloatBuffer yscale) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)xscale, 1);
            Checks.checkSafe((Buffer)yscale, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetMonitorContentScale(monitor, MemoryUtil.memAddressSafe(xscale), MemoryUtil.memAddressSafe(yscale));
    }

    public static long nglfwGetMonitorName(long monitor) {
        long __functionAddress = Functions.GetMonitorName;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        return JNI.invokePP(monitor, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glfwGetMonitorName(@NativeType(value="GLFWmonitor *") long monitor) {
        long __result = org.lwjgl.glfw.GLFW.nglfwGetMonitorName(monitor);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static void glfwSetMonitorUserPointer(@NativeType(value="GLFWmonitor *") long monitor, @NativeType(value="void *") long pointer) {
        long __functionAddress = Functions.SetMonitorUserPointer;
        if (Checks.CHECKS) {
            Checks.check(monitor);
            Checks.check(pointer);
        }
        JNI.invokePPV(monitor, pointer, __functionAddress);
    }

    @NativeType(value="void *")
    public static long glfwGetMonitorUserPointer(@NativeType(value="GLFWmonitor *") long monitor) {
        long __functionAddress = Functions.GetMonitorUserPointer;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        return JNI.invokePP(monitor, __functionAddress);
    }

    public static long nglfwSetMonitorCallback(long cbfun) {
        long __functionAddress = Functions.SetMonitorCallback;
        return JNI.invokePP(cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWmonitorfun")
    public static GLFWMonitorCallback glfwSetMonitorCallback(@Nullable @NativeType(value="GLFWmonitorfun") GLFWMonitorCallbackI cbfun) {
        return GLFWMonitorCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetMonitorCallback(MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwGetVideoModes(long monitor, long count) {
        long __functionAddress = Functions.GetVideoModes;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        return JNI.invokePPP(monitor, count, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="GLFWvidmode const *")
    public static GLFWVidMode.Buffer glfwGetVideoModes(@NativeType(value="GLFWmonitor *") long monitor) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer count = stack.callocInt(1);
        try {
            long __result = org.lwjgl.glfw.GLFW.nglfwGetVideoModes(monitor, MemoryUtil.memAddress(count));
            GLFWVidMode.Buffer buffer = GLFWVidMode.createSafe(__result, count.get(0));
            return buffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nglfwGetVideoMode(long monitor) {
        long __functionAddress = Functions.GetVideoMode;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        return JNI.invokePP(monitor, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWvidmode const *")
    public static GLFWVidMode glfwGetVideoMode(@NativeType(value="GLFWmonitor *") long monitor) {
        long __result = org.lwjgl.glfw.GLFW.nglfwGetVideoMode(monitor);
        return GLFWVidMode.createSafe(__result);
    }

    public static void glfwSetGamma(@NativeType(value="GLFWmonitor *") long monitor, float gamma) {
        long __functionAddress = Functions.SetGamma;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        JNI.invokePV(monitor, gamma, __functionAddress);
    }

    public static long nglfwGetGammaRamp(long monitor) {
        long __functionAddress = Functions.GetGammaRamp;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        return JNI.invokePP(monitor, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWgammaramp const *")
    public static GLFWGammaRamp glfwGetGammaRamp(@NativeType(value="GLFWmonitor *") long monitor) {
        long __result = org.lwjgl.glfw.GLFW.nglfwGetGammaRamp(monitor);
        return GLFWGammaRamp.createSafe(__result);
    }

    public static void nglfwSetGammaRamp(long monitor, long ramp) {
        long __functionAddress = Functions.SetGammaRamp;
        if (Checks.CHECKS) {
            Checks.check(monitor);
            GLFWGammaRamp.validate(ramp);
        }
        JNI.invokePPV(monitor, ramp, __functionAddress);
    }

    public static void glfwSetGammaRamp(@NativeType(value="GLFWmonitor *") long monitor, @NativeType(value="GLFWgammaramp const *") GLFWGammaRamp ramp) {
        org.lwjgl.glfw.GLFW.nglfwSetGammaRamp(monitor, ramp.address());
    }

    public static void glfwDefaultWindowHints() {
        long __functionAddress = Functions.DefaultWindowHints;
        JNI.invokeV(__functionAddress);
    }

    public static void glfwWindowHint(int hint, int value) {
        long __functionAddress = Functions.WindowHint;
        JNI.invokeV(hint, value, __functionAddress);
    }

    public static void nglfwWindowHintString(int hint, long value) {
        long __functionAddress = Functions.WindowHintString;
        JNI.invokePV(hint, value, __functionAddress);
    }

    public static void glfwWindowHintString(int hint, @NativeType(value="char const *") ByteBuffer value) {
        if (Checks.CHECKS) {
            Checks.checkNT1(value);
        }
        org.lwjgl.glfw.GLFW.nglfwWindowHintString(hint, MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glfwWindowHintString(int hint, @NativeType(value="char const *") CharSequence value) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(value, true);
            long valueEncoded = stack.getPointerAddress();
            org.lwjgl.glfw.GLFW.nglfwWindowHintString(hint, valueEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nglfwCreateWindow(int width, int height, long title, long monitor, long share) {
        long __functionAddress = Functions.CreateWindow;
        return JNI.invokePPPP(width, height, title, monitor, share, __functionAddress);
    }

    @NativeType(value="GLFWwindow *")
    public static long glfwCreateWindow(int width, int height, @NativeType(value="char const *") ByteBuffer title, @NativeType(value="GLFWmonitor *") long monitor, @NativeType(value="GLFWwindow *") long share) {
        EventLoop.OffScreen.check();
        if (Checks.CHECKS) {
            Checks.checkNT1(title);
        }
        return org.lwjgl.glfw.GLFW.nglfwCreateWindow(width, height, MemoryUtil.memAddress(title), monitor, share);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLFWwindow *")
    public static long glfwCreateWindow(int width, int height, @NativeType(value="char const *") CharSequence title, @NativeType(value="GLFWmonitor *") long monitor, @NativeType(value="GLFWwindow *") long share) {
        EventLoop.OffScreen.check();
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(title, true);
            long titleEncoded = stack.getPointerAddress();
            long l = org.lwjgl.glfw.GLFW.nglfwCreateWindow(width, height, titleEncoded, monitor, share);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glfwDestroyWindow(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.DestroyWindow;
        JNI.invokePV(window, __functionAddress);
    }

    @NativeType(value="int")
    public static boolean glfwWindowShouldClose(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.WindowShouldClose;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePI(window, __functionAddress) != 0;
    }

    public static void glfwSetWindowShouldClose(@NativeType(value="GLFWwindow *") long window, @NativeType(value="int") boolean value) {
        long __functionAddress = Functions.SetWindowShouldClose;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, value ? 1 : 0, __functionAddress);
    }

    public static void nglfwSetWindowTitle(long window, long title) {
        long __functionAddress = Functions.SetWindowTitle;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePPV(window, title, __functionAddress);
    }

    public static void glfwSetWindowTitle(@NativeType(value="GLFWwindow *") long window, @NativeType(value="char const *") ByteBuffer title) {
        if (Checks.CHECKS) {
            Checks.checkNT1(title);
        }
        org.lwjgl.glfw.GLFW.nglfwSetWindowTitle(window, MemoryUtil.memAddress(title));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glfwSetWindowTitle(@NativeType(value="GLFWwindow *") long window, @NativeType(value="char const *") CharSequence title) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(title, true);
            long titleEncoded = stack.getPointerAddress();
            org.lwjgl.glfw.GLFW.nglfwSetWindowTitle(window, titleEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nglfwSetWindowIcon(long window, int count, long images) {
        long __functionAddress = Functions.SetWindowIcon;
        if (Checks.CHECKS) {
            Checks.check(window);
            if (images != 0L) {
                GLFWImage.validate(images, count);
            }
        }
        JNI.invokePPV(window, count, images, __functionAddress);
    }

    public static void glfwSetWindowIcon(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWimage const *") GLFWImage.Buffer images) {
        org.lwjgl.glfw.GLFW.nglfwSetWindowIcon(window, Checks.remainingSafe(images), MemoryUtil.memAddressSafe(images));
    }

    public static void nglfwGetWindowPos(long window, long xpos, long ypos) {
        long __functionAddress = Functions.GetWindowPos;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePPPV(window, xpos, ypos, __functionAddress);
    }

    public static void glfwGetWindowPos(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="int *") IntBuffer xpos, @Nullable @NativeType(value="int *") IntBuffer ypos) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)xpos, 1);
            Checks.checkSafe((Buffer)ypos, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetWindowPos(window, MemoryUtil.memAddressSafe(xpos), MemoryUtil.memAddressSafe(ypos));
    }

    public static void glfwSetWindowPos(@NativeType(value="GLFWwindow *") long window, int xpos, int ypos) {
        long __functionAddress = Functions.SetWindowPos;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, xpos, ypos, __functionAddress);
    }

    public static void nglfwGetWindowSize(long window, long width, long height) {
        long __functionAddress = Functions.GetWindowSize;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePPPV(window, width, height, __functionAddress);
    }

    public static void glfwGetWindowSize(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="int *") IntBuffer width, @Nullable @NativeType(value="int *") IntBuffer height) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)width, 1);
            Checks.checkSafe((Buffer)height, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetWindowSize(window, MemoryUtil.memAddressSafe(width), MemoryUtil.memAddressSafe(height));
    }

    public static void glfwSetWindowSizeLimits(@NativeType(value="GLFWwindow *") long window, int minwidth, int minheight, int maxwidth, int maxheight) {
        long __functionAddress = Functions.SetWindowSizeLimits;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, minwidth, minheight, maxwidth, maxheight, __functionAddress);
    }

    public static void glfwSetWindowAspectRatio(@NativeType(value="GLFWwindow *") long window, int numer, int denom) {
        long __functionAddress = Functions.SetWindowAspectRatio;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, numer, denom, __functionAddress);
    }

    public static void glfwSetWindowSize(@NativeType(value="GLFWwindow *") long window, int width, int height) {
        long __functionAddress = Functions.SetWindowSize;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, width, height, __functionAddress);
    }

    public static void nglfwGetFramebufferSize(long window, long width, long height) {
        long __functionAddress = Functions.GetFramebufferSize;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePPPV(window, width, height, __functionAddress);
    }

    public static void glfwGetFramebufferSize(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="int *") IntBuffer width, @Nullable @NativeType(value="int *") IntBuffer height) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)width, 1);
            Checks.checkSafe((Buffer)height, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetFramebufferSize(window, MemoryUtil.memAddressSafe(width), MemoryUtil.memAddressSafe(height));
    }

    public static void nglfwGetWindowFrameSize(long window, long left, long top, long right, long bottom) {
        long __functionAddress = Functions.GetWindowFrameSize;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePPPPPV(window, left, top, right, bottom, __functionAddress);
    }

    public static void glfwGetWindowFrameSize(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="int *") IntBuffer left, @Nullable @NativeType(value="int *") IntBuffer top, @Nullable @NativeType(value="int *") IntBuffer right, @Nullable @NativeType(value="int *") IntBuffer bottom) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)left, 1);
            Checks.checkSafe((Buffer)top, 1);
            Checks.checkSafe((Buffer)right, 1);
            Checks.checkSafe((Buffer)bottom, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetWindowFrameSize(window, MemoryUtil.memAddressSafe(left), MemoryUtil.memAddressSafe(top), MemoryUtil.memAddressSafe(right), MemoryUtil.memAddressSafe(bottom));
    }

    public static void nglfwGetWindowContentScale(long window, long xscale, long yscale) {
        long __functionAddress = Functions.GetWindowContentScale;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePPPV(window, xscale, yscale, __functionAddress);
    }

    public static void glfwGetWindowContentScale(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="float *") FloatBuffer xscale, @Nullable @NativeType(value="float *") FloatBuffer yscale) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)xscale, 1);
            Checks.checkSafe((Buffer)yscale, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetWindowContentScale(window, MemoryUtil.memAddressSafe(xscale), MemoryUtil.memAddressSafe(yscale));
    }

    public static float glfwGetWindowOpacity(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.GetWindowOpacity;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePF(window, __functionAddress);
    }

    public static void glfwSetWindowOpacity(@NativeType(value="GLFWwindow *") long window, float opacity) {
        long __functionAddress = Functions.SetWindowOpacity;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, opacity, __functionAddress);
    }

    public static void glfwIconifyWindow(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.IconifyWindow;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, __functionAddress);
    }

    public static void glfwRestoreWindow(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.RestoreWindow;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, __functionAddress);
    }

    public static void glfwMaximizeWindow(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.MaximizeWindow;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, __functionAddress);
    }

    public static void glfwShowWindow(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.ShowWindow;
        EventLoop.OnScreen.check();
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, __functionAddress);
    }

    public static void glfwHideWindow(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.HideWindow;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, __functionAddress);
    }

    public static void glfwFocusWindow(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.FocusWindow;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, __functionAddress);
    }

    public static void glfwRequestWindowAttention(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.RequestWindowAttention;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, __functionAddress);
    }

    @NativeType(value="GLFWmonitor *")
    public static long glfwGetWindowMonitor(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.GetWindowMonitor;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePP(window, __functionAddress);
    }

    public static void glfwSetWindowMonitor(@NativeType(value="GLFWwindow *") long window, @NativeType(value="GLFWmonitor *") long monitor, int xpos, int ypos, int width, int height, int refreshRate) {
        long __functionAddress = Functions.SetWindowMonitor;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePPV(window, monitor, xpos, ypos, width, height, refreshRate, __functionAddress);
    }

    public static int glfwGetWindowAttrib(@NativeType(value="GLFWwindow *") long window, int attrib) {
        long __functionAddress = Functions.GetWindowAttrib;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePI(window, attrib, __functionAddress);
    }

    public static void glfwSetWindowAttrib(@NativeType(value="GLFWwindow *") long window, int attrib, int value) {
        long __functionAddress = Functions.SetWindowAttrib;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, attrib, value, __functionAddress);
    }

    public static void glfwSetWindowUserPointer(@NativeType(value="GLFWwindow *") long window, @NativeType(value="void *") long pointer) {
        long __functionAddress = Functions.SetWindowUserPointer;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePPV(window, pointer, __functionAddress);
    }

    @NativeType(value="void *")
    public static long glfwGetWindowUserPointer(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.GetWindowUserPointer;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePP(window, __functionAddress);
    }

    public static long nglfwSetWindowPosCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetWindowPosCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWwindowposfun")
    public static GLFWWindowPosCallback glfwSetWindowPosCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWwindowposfun") GLFWWindowPosCallbackI cbfun) {
        return GLFWWindowPosCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowPosCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetWindowSizeCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetWindowSizeCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWwindowsizefun")
    public static GLFWWindowSizeCallback glfwSetWindowSizeCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWwindowsizefun") GLFWWindowSizeCallbackI cbfun) {
        return GLFWWindowSizeCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowSizeCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetWindowCloseCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetWindowCloseCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWwindowclosefun")
    public static GLFWWindowCloseCallback glfwSetWindowCloseCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWwindowclosefun") GLFWWindowCloseCallbackI cbfun) {
        return GLFWWindowCloseCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowCloseCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetWindowRefreshCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetWindowRefreshCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWwindowrefreshfun")
    public static GLFWWindowRefreshCallback glfwSetWindowRefreshCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWwindowrefreshfun") GLFWWindowRefreshCallbackI cbfun) {
        return GLFWWindowRefreshCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowRefreshCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetWindowFocusCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetWindowFocusCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWwindowfocusfun")
    public static GLFWWindowFocusCallback glfwSetWindowFocusCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWwindowfocusfun") GLFWWindowFocusCallbackI cbfun) {
        return GLFWWindowFocusCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowFocusCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetWindowIconifyCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetWindowIconifyCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWwindowiconifyfun")
    public static GLFWWindowIconifyCallback glfwSetWindowIconifyCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWwindowiconifyfun") GLFWWindowIconifyCallbackI cbfun) {
        return GLFWWindowIconifyCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowIconifyCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetWindowMaximizeCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetWindowMaximizeCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWwindowmaximizefun")
    public static GLFWWindowMaximizeCallback glfwSetWindowMaximizeCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWwindowmaximizefun") GLFWWindowMaximizeCallbackI cbfun) {
        return GLFWWindowMaximizeCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowMaximizeCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetFramebufferSizeCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetFramebufferSizeCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWframebuffersizefun")
    public static GLFWFramebufferSizeCallback glfwSetFramebufferSizeCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWframebuffersizefun") GLFWFramebufferSizeCallbackI cbfun) {
        return GLFWFramebufferSizeCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetFramebufferSizeCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetWindowContentScaleCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetWindowContentScaleCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWwindowcontentscalefun")
    public static GLFWWindowContentScaleCallback glfwSetWindowContentScaleCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWwindowcontentscalefun") GLFWWindowContentScaleCallbackI cbfun) {
        return GLFWWindowContentScaleCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowContentScaleCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static void glfwPollEvents() {
        long __functionAddress = Functions.PollEvents;
        EventLoop.OnScreen.check();
        JNI.invokeV(__functionAddress);
    }

    public static void glfwWaitEvents() {
        long __functionAddress = Functions.WaitEvents;
        EventLoop.OnScreen.check();
        JNI.invokeV(__functionAddress);
    }

    public static void glfwWaitEventsTimeout(double timeout) {
        long __functionAddress = Functions.WaitEventsTimeout;
        EventLoop.OnScreen.check();
        JNI.invokeV(timeout, __functionAddress);
    }

    public static void glfwPostEmptyEvent() {
        long __functionAddress = Functions.PostEmptyEvent;
        JNI.invokeV(__functionAddress);
    }

    public static int glfwGetInputMode(@NativeType(value="GLFWwindow *") long window, int mode) {
        long __functionAddress = Functions.GetInputMode;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePI(window, mode, __functionAddress);
    }

    public static void glfwSetInputMode(@NativeType(value="GLFWwindow *") long window, int mode, int value) {
        long __functionAddress = Functions.SetInputMode;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, mode, value, __functionAddress);
    }

    @NativeType(value="int")
    public static boolean glfwRawMouseMotionSupported() {
        long __functionAddress = Functions.RawMouseMotionSupported;
        return JNI.invokeI(__functionAddress) != 0;
    }

    public static long nglfwGetKeyName(int key, int scancode) {
        long __functionAddress = Functions.GetKeyName;
        return JNI.invokeP(key, scancode, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glfwGetKeyName(int key, int scancode) {
        long __result = org.lwjgl.glfw.GLFW.nglfwGetKeyName(key, scancode);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static int glfwGetKeyScancode(int key) {
        long __functionAddress = Functions.GetKeyScancode;
        return JNI.invokeI(key, __functionAddress);
    }

    public static int glfwGetKey(@NativeType(value="GLFWwindow *") long window, int key) {
        long __functionAddress = Functions.GetKey;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePI(window, key, __functionAddress);
    }

    public static int glfwGetMouseButton(@NativeType(value="GLFWwindow *") long window, int button) {
        long __functionAddress = Functions.GetMouseButton;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePI(window, button, __functionAddress);
    }

    public static void nglfwGetCursorPos(long window, long xpos, long ypos) {
        long __functionAddress = Functions.GetCursorPos;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePPPV(window, xpos, ypos, __functionAddress);
    }

    public static void glfwGetCursorPos(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="double *") DoubleBuffer xpos, @Nullable @NativeType(value="double *") DoubleBuffer ypos) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)xpos, 1);
            Checks.checkSafe((Buffer)ypos, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetCursorPos(window, MemoryUtil.memAddressSafe(xpos), MemoryUtil.memAddressSafe(ypos));
    }

    public static void glfwSetCursorPos(@NativeType(value="GLFWwindow *") long window, double xpos, double ypos) {
        long __functionAddress = Functions.SetCursorPos;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, xpos, ypos, __functionAddress);
    }

    public static long nglfwCreateCursor(long image, int xhot, int yhot) {
        long __functionAddress = Functions.CreateCursor;
        if (Checks.CHECKS) {
            GLFWImage.validate(image);
        }
        return JNI.invokePP(image, xhot, yhot, __functionAddress);
    }

    @NativeType(value="GLFWcursor *")
    public static long glfwCreateCursor(@NativeType(value="GLFWimage const *") GLFWImage image, int xhot, int yhot) {
        return org.lwjgl.glfw.GLFW.nglfwCreateCursor(image.address(), xhot, yhot);
    }

    @NativeType(value="GLFWcursor *")
    public static long glfwCreateStandardCursor(int shape) {
        long __functionAddress = Functions.CreateStandardCursor;
        return JNI.invokeP(shape, __functionAddress);
    }

    public static void glfwDestroyCursor(@NativeType(value="GLFWcursor *") long cursor) {
        long __functionAddress = Functions.DestroyCursor;
        if (Checks.CHECKS) {
            Checks.check(cursor);
        }
        JNI.invokePV(cursor, __functionAddress);
    }

    public static void glfwSetCursor(@NativeType(value="GLFWwindow *") long window, @NativeType(value="GLFWcursor *") long cursor) {
        long __functionAddress = Functions.SetCursor;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePPV(window, cursor, __functionAddress);
    }

    public static long nglfwSetKeyCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetKeyCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWkeyfun")
    public static GLFWKeyCallback glfwSetKeyCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWkeyfun") GLFWKeyCallbackI cbfun) {
        return GLFWKeyCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetKeyCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetCharCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetCharCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWcharfun")
    public static GLFWCharCallback glfwSetCharCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWcharfun") GLFWCharCallbackI cbfun) {
        return GLFWCharCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetCharCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetCharModsCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetCharModsCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWcharmodsfun")
    public static GLFWCharModsCallback glfwSetCharModsCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWcharmodsfun") GLFWCharModsCallbackI cbfun) {
        return GLFWCharModsCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetCharModsCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetMouseButtonCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetMouseButtonCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWmousebuttonfun")
    public static GLFWMouseButtonCallback glfwSetMouseButtonCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWmousebuttonfun") GLFWMouseButtonCallbackI cbfun) {
        return GLFWMouseButtonCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetMouseButtonCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetCursorPosCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetCursorPosCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWcursorposfun")
    public static GLFWCursorPosCallback glfwSetCursorPosCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWcursorposfun") GLFWCursorPosCallbackI cbfun) {
        return GLFWCursorPosCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetCursorPosCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetCursorEnterCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetCursorEnterCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWcursorenterfun")
    public static GLFWCursorEnterCallback glfwSetCursorEnterCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWcursorenterfun") GLFWCursorEnterCallbackI cbfun) {
        return GLFWCursorEnterCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetCursorEnterCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetScrollCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetScrollCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWscrollfun")
    public static GLFWScrollCallback glfwSetScrollCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWscrollfun") GLFWScrollCallbackI cbfun) {
        return GLFWScrollCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetScrollCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    public static long nglfwSetDropCallback(long window, long cbfun) {
        long __functionAddress = Functions.SetDropCallback;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePPP(window, cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWdropfun")
    public static GLFWDropCallback glfwSetDropCallback(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="GLFWdropfun") GLFWDropCallbackI cbfun) {
        return GLFWDropCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetDropCallback(window, MemoryUtil.memAddressSafe(cbfun)));
    }

    @NativeType(value="int")
    public static boolean glfwJoystickPresent(int jid) {
        long __functionAddress = Functions.JoystickPresent;
        return JNI.invokeI(jid, __functionAddress) != 0;
    }

    public static long nglfwGetJoystickAxes(int jid, long count) {
        long __functionAddress = Functions.GetJoystickAxes;
        return JNI.invokePP(jid, count, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="float const *")
    public static FloatBuffer glfwGetJoystickAxes(int jid) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer count = stack.callocInt(1);
        try {
            long __result = org.lwjgl.glfw.GLFW.nglfwGetJoystickAxes(jid, MemoryUtil.memAddress(count));
            FloatBuffer floatBuffer = MemoryUtil.memFloatBufferSafe(__result, count.get(0));
            return floatBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nglfwGetJoystickButtons(int jid, long count) {
        long __functionAddress = Functions.GetJoystickButtons;
        return JNI.invokePP(jid, count, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="unsigned char const *")
    public static ByteBuffer glfwGetJoystickButtons(int jid) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer count = stack.callocInt(1);
        try {
            long __result = org.lwjgl.glfw.GLFW.nglfwGetJoystickButtons(jid, MemoryUtil.memAddress(count));
            ByteBuffer byteBuffer = MemoryUtil.memByteBufferSafe(__result, count.get(0));
            return byteBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nglfwGetJoystickHats(int jid, long count) {
        long __functionAddress = Functions.GetJoystickHats;
        return JNI.invokePP(jid, count, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="unsigned char const *")
    public static ByteBuffer glfwGetJoystickHats(int jid) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer count = stack.callocInt(1);
        try {
            long __result = org.lwjgl.glfw.GLFW.nglfwGetJoystickHats(jid, MemoryUtil.memAddress(count));
            ByteBuffer byteBuffer = MemoryUtil.memByteBufferSafe(__result, count.get(0));
            return byteBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nglfwGetJoystickName(int jid) {
        long __functionAddress = Functions.GetJoystickName;
        return JNI.invokeP(jid, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glfwGetJoystickName(int jid) {
        long __result = org.lwjgl.glfw.GLFW.nglfwGetJoystickName(jid);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static long nglfwGetJoystickGUID(int jid) {
        long __functionAddress = Functions.GetJoystickGUID;
        return JNI.invokeP(jid, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glfwGetJoystickGUID(int jid) {
        long __result = org.lwjgl.glfw.GLFW.nglfwGetJoystickGUID(jid);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static void glfwSetJoystickUserPointer(int jid, @NativeType(value="void *") long pointer) {
        long __functionAddress = Functions.SetJoystickUserPointer;
        if (Checks.CHECKS) {
            Checks.check(pointer);
        }
        JNI.invokePV(jid, pointer, __functionAddress);
    }

    @NativeType(value="void *")
    public static long glfwGetJoystickUserPointer(int jid) {
        long __functionAddress = Functions.GetJoystickUserPointer;
        return JNI.invokeP(jid, __functionAddress);
    }

    @NativeType(value="int")
    public static boolean glfwJoystickIsGamepad(int jid) {
        long __functionAddress = Functions.JoystickIsGamepad;
        return JNI.invokeI(jid, __functionAddress) != 0;
    }

    public static long nglfwSetJoystickCallback(long cbfun) {
        long __functionAddress = Functions.SetJoystickCallback;
        return JNI.invokePP(cbfun, __functionAddress);
    }

    @Nullable
    @NativeType(value="GLFWjoystickfun")
    public static GLFWJoystickCallback glfwSetJoystickCallback(@Nullable @NativeType(value="GLFWjoystickfun") GLFWJoystickCallbackI cbfun) {
        return GLFWJoystickCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetJoystickCallback(MemoryUtil.memAddressSafe(cbfun)));
    }

    public static int nglfwUpdateGamepadMappings(long string) {
        long __functionAddress = Functions.UpdateGamepadMappings;
        return JNI.invokePI(string, __functionAddress);
    }

    @NativeType(value="int")
    public static boolean glfwUpdateGamepadMappings(@NativeType(value="char const *") ByteBuffer string) {
        if (Checks.CHECKS) {
            Checks.checkNT1(string);
        }
        return org.lwjgl.glfw.GLFW.nglfwUpdateGamepadMappings(MemoryUtil.memAddress(string)) != 0;
    }

    public static long nglfwGetGamepadName(int jid) {
        long __functionAddress = Functions.GetGamepadName;
        return JNI.invokeP(jid, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glfwGetGamepadName(int jid) {
        long __result = org.lwjgl.glfw.GLFW.nglfwGetGamepadName(jid);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static int nglfwGetGamepadState(int jid, long state) {
        long __functionAddress = Functions.GetGamepadState;
        return JNI.invokePI(jid, state, __functionAddress);
    }

    @NativeType(value="int")
    public static boolean glfwGetGamepadState(int jid, @NativeType(value="GLFWgamepadstate *") GLFWGamepadState state) {
        return org.lwjgl.glfw.GLFW.nglfwGetGamepadState(jid, state.address()) != 0;
    }

    public static void nglfwSetClipboardString(long window, long string) {
        long __functionAddress = Functions.SetClipboardString;
        JNI.invokePPV(window, string, __functionAddress);
    }

    public static void glfwSetClipboardString(@NativeType(value="GLFWwindow *") long window, @NativeType(value="char const *") ByteBuffer string) {
        if (Checks.CHECKS) {
            Checks.checkNT1(string);
        }
        org.lwjgl.glfw.GLFW.nglfwSetClipboardString(window, MemoryUtil.memAddress(string));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glfwSetClipboardString(@NativeType(value="GLFWwindow *") long window, @NativeType(value="char const *") CharSequence string) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(string, true);
            long stringEncoded = stack.getPointerAddress();
            org.lwjgl.glfw.GLFW.nglfwSetClipboardString(window, stringEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nglfwGetClipboardString(long window) {
        long __functionAddress = Functions.GetClipboardString;
        return JNI.invokePP(window, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glfwGetClipboardString(@NativeType(value="GLFWwindow *") long window) {
        long __result = org.lwjgl.glfw.GLFW.nglfwGetClipboardString(window);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static double glfwGetTime() {
        long __functionAddress = Functions.GetTime;
        return JNI.invokeD(__functionAddress);
    }

    public static void glfwSetTime(double time) {
        long __functionAddress = Functions.SetTime;
        JNI.invokeV(time, __functionAddress);
    }

    @NativeType(value="uint64_t")
    public static long glfwGetTimerValue() {
        long __functionAddress = Functions.GetTimerValue;
        return JNI.invokeJ(__functionAddress);
    }

    @NativeType(value="uint64_t")
    public static long glfwGetTimerFrequency() {
        long __functionAddress = Functions.GetTimerFrequency;
        return JNI.invokeJ(__functionAddress);
    }

    public static void glfwMakeContextCurrent(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.MakeContextCurrent;
        JNI.invokePV(window, __functionAddress);
    }

    @NativeType(value="GLFWwindow *")
    public static long glfwGetCurrentContext() {
        long __functionAddress = Functions.GetCurrentContext;
        return JNI.invokeP(__functionAddress);
    }

    public static void glfwSwapBuffers(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.SwapBuffers;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        JNI.invokePV(window, __functionAddress);
    }

    public static void glfwSwapInterval(int interval) {
        long __functionAddress = Functions.SwapInterval;
        JNI.invokeV(interval, __functionAddress);
    }

    public static int nglfwExtensionSupported(long extension) {
        long __functionAddress = Functions.ExtensionSupported;
        return JNI.invokePI(extension, __functionAddress);
    }

    @NativeType(value="int")
    public static boolean glfwExtensionSupported(@NativeType(value="char const *") ByteBuffer extension) {
        if (Checks.CHECKS) {
            Checks.checkNT1(extension);
        }
        return org.lwjgl.glfw.GLFW.nglfwExtensionSupported(MemoryUtil.memAddress(extension)) != 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="int")
    public static boolean glfwExtensionSupported(@NativeType(value="char const *") CharSequence extension) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(extension, true);
            long extensionEncoded = stack.getPointerAddress();
            boolean bl = org.lwjgl.glfw.GLFW.nglfwExtensionSupported(extensionEncoded) != 0;
            return bl;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nglfwGetProcAddress(long procname) {
        long __functionAddress = Functions.GetProcAddress;
        return JNI.invokePP(procname, __functionAddress);
    }

    @NativeType(value="GLFWglproc")
    public static long glfwGetProcAddress(@NativeType(value="char const *") ByteBuffer procname) {
        if (Checks.CHECKS) {
            Checks.checkNT1(procname);
        }
        return org.lwjgl.glfw.GLFW.nglfwGetProcAddress(MemoryUtil.memAddress(procname));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLFWglproc")
    public static long glfwGetProcAddress(@NativeType(value="char const *") CharSequence procname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(procname, true);
            long procnameEncoded = stack.getPointerAddress();
            long l = org.lwjgl.glfw.GLFW.nglfwGetProcAddress(procnameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glfwGetVersion(@Nullable @NativeType(value="int *") int[] major, @Nullable @NativeType(value="int *") int[] minor, @Nullable @NativeType(value="int *") int[] rev) {
        long __functionAddress = Functions.GetVersion;
        if (Checks.CHECKS) {
            Checks.checkSafe(major, 1);
            Checks.checkSafe(minor, 1);
            Checks.checkSafe(rev, 1);
        }
        JNI.invokePPPV(major, minor, rev, __functionAddress);
    }

    public static void glfwGetMonitorPos(@NativeType(value="GLFWmonitor *") long monitor, @Nullable @NativeType(value="int *") int[] xpos, @Nullable @NativeType(value="int *") int[] ypos) {
        long __functionAddress = Functions.GetMonitorPos;
        if (Checks.CHECKS) {
            Checks.check(monitor);
            Checks.checkSafe(xpos, 1);
            Checks.checkSafe(ypos, 1);
        }
        JNI.invokePPPV(monitor, xpos, ypos, __functionAddress);
    }

    public static void glfwGetMonitorWorkarea(@NativeType(value="GLFWmonitor *") long monitor, @Nullable @NativeType(value="int *") int[] xpos, @Nullable @NativeType(value="int *") int[] ypos, @Nullable @NativeType(value="int *") int[] width, @Nullable @NativeType(value="int *") int[] height) {
        long __functionAddress = Functions.GetMonitorWorkarea;
        if (Checks.CHECKS) {
            Checks.check(monitor);
            Checks.checkSafe(xpos, 1);
            Checks.checkSafe(ypos, 1);
            Checks.checkSafe(width, 1);
            Checks.checkSafe(height, 1);
        }
        JNI.invokePPPPPV(monitor, xpos, ypos, width, height, __functionAddress);
    }

    public static void glfwGetMonitorPhysicalSize(@NativeType(value="GLFWmonitor *") long monitor, @Nullable @NativeType(value="int *") int[] widthMM, @Nullable @NativeType(value="int *") int[] heightMM) {
        long __functionAddress = Functions.GetMonitorPhysicalSize;
        if (Checks.CHECKS) {
            Checks.check(monitor);
            Checks.checkSafe(widthMM, 1);
            Checks.checkSafe(heightMM, 1);
        }
        JNI.invokePPPV(monitor, widthMM, heightMM, __functionAddress);
    }

    public static void glfwGetMonitorContentScale(@NativeType(value="GLFWmonitor *") long monitor, @Nullable @NativeType(value="float *") float[] xscale, @Nullable @NativeType(value="float *") float[] yscale) {
        long __functionAddress = Functions.GetMonitorContentScale;
        if (Checks.CHECKS) {
            Checks.check(monitor);
            Checks.checkSafe(xscale, 1);
            Checks.checkSafe(yscale, 1);
        }
        JNI.invokePPPV(monitor, xscale, yscale, __functionAddress);
    }

    public static void glfwGetWindowPos(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="int *") int[] xpos, @Nullable @NativeType(value="int *") int[] ypos) {
        long __functionAddress = Functions.GetWindowPos;
        if (Checks.CHECKS) {
            Checks.check(window);
            Checks.checkSafe(xpos, 1);
            Checks.checkSafe(ypos, 1);
        }
        JNI.invokePPPV(window, xpos, ypos, __functionAddress);
    }

    public static void glfwGetWindowSize(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="int *") int[] width, @Nullable @NativeType(value="int *") int[] height) {
        long __functionAddress = Functions.GetWindowSize;
        if (Checks.CHECKS) {
            Checks.check(window);
            Checks.checkSafe(width, 1);
            Checks.checkSafe(height, 1);
        }
        JNI.invokePPPV(window, width, height, __functionAddress);
    }

    public static void glfwGetFramebufferSize(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="int *") int[] width, @Nullable @NativeType(value="int *") int[] height) {
        long __functionAddress = Functions.GetFramebufferSize;
        if (Checks.CHECKS) {
            Checks.check(window);
            Checks.checkSafe(width, 1);
            Checks.checkSafe(height, 1);
        }
        JNI.invokePPPV(window, width, height, __functionAddress);
    }

    public static void glfwGetWindowFrameSize(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="int *") int[] left, @Nullable @NativeType(value="int *") int[] top, @Nullable @NativeType(value="int *") int[] right, @Nullable @NativeType(value="int *") int[] bottom) {
        long __functionAddress = Functions.GetWindowFrameSize;
        if (Checks.CHECKS) {
            Checks.check(window);
            Checks.checkSafe(left, 1);
            Checks.checkSafe(top, 1);
            Checks.checkSafe(right, 1);
            Checks.checkSafe(bottom, 1);
        }
        JNI.invokePPPPPV(window, left, top, right, bottom, __functionAddress);
    }

    public static void glfwGetWindowContentScale(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="float *") float[] xscale, @Nullable @NativeType(value="float *") float[] yscale) {
        long __functionAddress = Functions.GetWindowContentScale;
        if (Checks.CHECKS) {
            Checks.check(window);
            Checks.checkSafe(xscale, 1);
            Checks.checkSafe(yscale, 1);
        }
        JNI.invokePPPV(window, xscale, yscale, __functionAddress);
    }

    public static void glfwGetCursorPos(@NativeType(value="GLFWwindow *") long window, @Nullable @NativeType(value="double *") double[] xpos, @Nullable @NativeType(value="double *") double[] ypos) {
        long __functionAddress = Functions.GetCursorPos;
        if (Checks.CHECKS) {
            Checks.check(window);
            Checks.checkSafe(xpos, 1);
            Checks.checkSafe(ypos, 1);
        }
        JNI.invokePPPV(window, xpos, ypos, __functionAddress);
    }

    static /* synthetic */ SharedLibrary access$000() {
        return GLFW;
    }

    public static final class Functions {
        public static final long Init = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwInit");
        public static final long Terminate = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwTerminate");
        public static final long InitHint = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwInitHint");
        public static final long GetVersion = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetVersion");
        public static final long GetVersionString = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetVersionString");
        public static final long GetError = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetError");
        public static final long SetErrorCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetErrorCallback");
        public static final long GetMonitors = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMonitors");
        public static final long GetPrimaryMonitor = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetPrimaryMonitor");
        public static final long GetMonitorPos = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMonitorPos");
        public static final long GetMonitorWorkarea = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMonitorWorkarea");
        public static final long GetMonitorPhysicalSize = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMonitorPhysicalSize");
        public static final long GetMonitorContentScale = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMonitorContentScale");
        public static final long GetMonitorName = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMonitorName");
        public static final long SetMonitorUserPointer = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetMonitorUserPointer");
        public static final long GetMonitorUserPointer = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMonitorUserPointer");
        public static final long SetMonitorCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetMonitorCallback");
        public static final long GetVideoModes = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetVideoModes");
        public static final long GetVideoMode = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetVideoMode");
        public static final long SetGamma = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetGamma");
        public static final long GetGammaRamp = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetGammaRamp");
        public static final long SetGammaRamp = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetGammaRamp");
        public static final long DefaultWindowHints = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwDefaultWindowHints");
        public static final long WindowHint = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwWindowHint");
        public static final long WindowHintString = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwWindowHintString");
        public static final long CreateWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwCreateWindow");
        public static final long DestroyWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwDestroyWindow");
        public static final long WindowShouldClose = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwWindowShouldClose");
        public static final long SetWindowShouldClose = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowShouldClose");
        public static final long SetWindowTitle = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowTitle");
        public static final long SetWindowIcon = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowIcon");
        public static final long GetWindowPos = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowPos");
        public static final long SetWindowPos = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowPos");
        public static final long GetWindowSize = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowSize");
        public static final long SetWindowSizeLimits = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowSizeLimits");
        public static final long SetWindowAspectRatio = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowAspectRatio");
        public static final long SetWindowSize = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowSize");
        public static final long GetFramebufferSize = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetFramebufferSize");
        public static final long GetWindowFrameSize = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowFrameSize");
        public static final long GetWindowContentScale = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowContentScale");
        public static final long GetWindowOpacity = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowOpacity");
        public static final long SetWindowOpacity = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowOpacity");
        public static final long IconifyWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwIconifyWindow");
        public static final long RestoreWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwRestoreWindow");
        public static final long MaximizeWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwMaximizeWindow");
        public static final long ShowWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwShowWindow");
        public static final long HideWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwHideWindow");
        public static final long FocusWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwFocusWindow");
        public static final long RequestWindowAttention = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwRequestWindowAttention");
        public static final long GetWindowMonitor = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowMonitor");
        public static final long SetWindowMonitor = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowMonitor");
        public static final long GetWindowAttrib = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowAttrib");
        public static final long SetWindowAttrib = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowAttrib");
        public static final long SetWindowUserPointer = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowUserPointer");
        public static final long GetWindowUserPointer = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowUserPointer");
        public static final long SetWindowPosCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowPosCallback");
        public static final long SetWindowSizeCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowSizeCallback");
        public static final long SetWindowCloseCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowCloseCallback");
        public static final long SetWindowRefreshCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowRefreshCallback");
        public static final long SetWindowFocusCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowFocusCallback");
        public static final long SetWindowIconifyCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowIconifyCallback");
        public static final long SetWindowMaximizeCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowMaximizeCallback");
        public static final long SetFramebufferSizeCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetFramebufferSizeCallback");
        public static final long SetWindowContentScaleCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowContentScaleCallback");
        public static final long PollEvents = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwPollEvents");
        public static final long WaitEvents = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwWaitEvents");
        public static final long WaitEventsTimeout = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwWaitEventsTimeout");
        public static final long PostEmptyEvent = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwPostEmptyEvent");
        public static final long GetInputMode = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetInputMode");
        public static final long SetInputMode = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetInputMode");
        public static final long RawMouseMotionSupported = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwRawMouseMotionSupported");
        public static final long GetKeyName = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetKeyName");
        public static final long GetKeyScancode = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetKeyScancode");
        public static final long GetKey = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetKey");
        public static final long GetMouseButton = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMouseButton");
        public static final long GetCursorPos = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetCursorPos");
        public static final long SetCursorPos = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetCursorPos");
        public static final long CreateCursor = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwCreateCursor");
        public static final long CreateStandardCursor = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwCreateStandardCursor");
        public static final long DestroyCursor = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwDestroyCursor");
        public static final long SetCursor = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetCursor");
        public static final long SetKeyCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetKeyCallback");
        public static final long SetCharCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetCharCallback");
        public static final long SetCharModsCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetCharModsCallback");
        public static final long SetMouseButtonCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetMouseButtonCallback");
        public static final long SetCursorPosCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetCursorPosCallback");
        public static final long SetCursorEnterCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetCursorEnterCallback");
        public static final long SetScrollCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetScrollCallback");
        public static final long SetDropCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetDropCallback");
        public static final long JoystickPresent = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwJoystickPresent");
        public static final long GetJoystickAxes = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetJoystickAxes");
        public static final long GetJoystickButtons = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetJoystickButtons");
        public static final long GetJoystickHats = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetJoystickHats");
        public static final long GetJoystickName = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetJoystickName");
        public static final long GetJoystickGUID = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetJoystickGUID");
        public static final long SetJoystickUserPointer = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetJoystickUserPointer");
        public static final long GetJoystickUserPointer = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetJoystickUserPointer");
        public static final long JoystickIsGamepad = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwJoystickIsGamepad");
        public static final long SetJoystickCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetJoystickCallback");
        public static final long UpdateGamepadMappings = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwUpdateGamepadMappings");
        public static final long GetGamepadName = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetGamepadName");
        public static final long GetGamepadState = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetGamepadState");
        public static final long SetClipboardString = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetClipboardString");
        public static final long GetClipboardString = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetClipboardString");
        public static final long GetTime = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetTime");
        public static final long SetTime = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetTime");
        public static final long GetTimerValue = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetTimerValue");
        public static final long GetTimerFrequency = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetTimerFrequency");
        public static final long MakeContextCurrent = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwMakeContextCurrent");
        public static final long GetCurrentContext = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetCurrentContext");
        public static final long SwapBuffers = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSwapBuffers");
        public static final long SwapInterval = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSwapInterval");
        public static final long ExtensionSupported = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwExtensionSupported");
        public static final long GetProcAddress = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetProcAddress");

        private Functions() {
        }
    }
}

