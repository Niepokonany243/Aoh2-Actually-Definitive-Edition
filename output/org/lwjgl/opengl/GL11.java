/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Set;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL11 {
    public static final int GL_ACCUM = 256;
    public static final int GL_LOAD = 257;
    public static final int GL_RETURN = 258;
    public static final int GL_MULT = 259;
    public static final int GL_ADD = 260;
    public static final int GL_NEVER = 512;
    public static final int GL_LESS = 513;
    public static final int GL_EQUAL = 514;
    public static final int GL_LEQUAL = 515;
    public static final int GL_GREATER = 516;
    public static final int GL_NOTEQUAL = 517;
    public static final int GL_GEQUAL = 518;
    public static final int GL_ALWAYS = 519;
    public static final int GL_CURRENT_BIT = 1;
    public static final int GL_POINT_BIT = 2;
    public static final int GL_LINE_BIT = 4;
    public static final int GL_POLYGON_BIT = 8;
    public static final int GL_POLYGON_STIPPLE_BIT = 16;
    public static final int GL_PIXEL_MODE_BIT = 32;
    public static final int GL_LIGHTING_BIT = 64;
    public static final int GL_FOG_BIT = 128;
    public static final int GL_DEPTH_BUFFER_BIT = 256;
    public static final int GL_ACCUM_BUFFER_BIT = 512;
    public static final int GL_STENCIL_BUFFER_BIT = 1024;
    public static final int GL_VIEWPORT_BIT = 2048;
    public static final int GL_TRANSFORM_BIT = 4096;
    public static final int GL_ENABLE_BIT = 8192;
    public static final int GL_COLOR_BUFFER_BIT = 16384;
    public static final int GL_HINT_BIT = 32768;
    public static final int GL_EVAL_BIT = 65536;
    public static final int GL_LIST_BIT = 131072;
    public static final int GL_TEXTURE_BIT = 262144;
    public static final int GL_SCISSOR_BIT = 524288;
    public static final int GL_ALL_ATTRIB_BITS = 1048575;
    public static final int GL_POINTS = 0;
    public static final int GL_LINES = 1;
    public static final int GL_LINE_LOOP = 2;
    public static final int GL_LINE_STRIP = 3;
    public static final int GL_TRIANGLES = 4;
    public static final int GL_TRIANGLE_STRIP = 5;
    public static final int GL_TRIANGLE_FAN = 6;
    public static final int GL_QUADS = 7;
    public static final int GL_QUAD_STRIP = 8;
    public static final int GL_POLYGON = 9;
    public static final int GL_ZERO = 0;
    public static final int GL_ONE = 1;
    public static final int GL_SRC_COLOR = 768;
    public static final int GL_ONE_MINUS_SRC_COLOR = 769;
    public static final int GL_SRC_ALPHA = 770;
    public static final int GL_ONE_MINUS_SRC_ALPHA = 771;
    public static final int GL_DST_ALPHA = 772;
    public static final int GL_ONE_MINUS_DST_ALPHA = 773;
    public static final int GL_DST_COLOR = 774;
    public static final int GL_ONE_MINUS_DST_COLOR = 775;
    public static final int GL_SRC_ALPHA_SATURATE = 776;
    public static final int GL_TRUE = 1;
    public static final int GL_FALSE = 0;
    public static final int GL_CLIP_PLANE0 = 12288;
    public static final int GL_CLIP_PLANE1 = 12289;
    public static final int GL_CLIP_PLANE2 = 12290;
    public static final int GL_CLIP_PLANE3 = 12291;
    public static final int GL_CLIP_PLANE4 = 12292;
    public static final int GL_CLIP_PLANE5 = 12293;
    public static final int GL_BYTE = 5120;
    public static final int GL_UNSIGNED_BYTE = 5121;
    public static final int GL_SHORT = 5122;
    public static final int GL_UNSIGNED_SHORT = 5123;
    public static final int GL_INT = 5124;
    public static final int GL_UNSIGNED_INT = 5125;
    public static final int GL_FLOAT = 5126;
    public static final int GL_2_BYTES = 5127;
    public static final int GL_3_BYTES = 5128;
    public static final int GL_4_BYTES = 5129;
    public static final int GL_DOUBLE = 5130;
    public static final int GL_NONE = 0;
    public static final int GL_FRONT_LEFT = 1024;
    public static final int GL_FRONT_RIGHT = 1025;
    public static final int GL_BACK_LEFT = 1026;
    public static final int GL_BACK_RIGHT = 1027;
    public static final int GL_FRONT = 1028;
    public static final int GL_BACK = 1029;
    public static final int GL_LEFT = 1030;
    public static final int GL_RIGHT = 1031;
    public static final int GL_FRONT_AND_BACK = 1032;
    public static final int GL_AUX0 = 1033;
    public static final int GL_AUX1 = 1034;
    public static final int GL_AUX2 = 1035;
    public static final int GL_AUX3 = 1036;
    public static final int GL_NO_ERROR = 0;
    public static final int GL_INVALID_ENUM = 1280;
    public static final int GL_INVALID_VALUE = 1281;
    public static final int GL_INVALID_OPERATION = 1282;
    public static final int GL_STACK_OVERFLOW = 1283;
    public static final int GL_STACK_UNDERFLOW = 1284;
    public static final int GL_OUT_OF_MEMORY = 1285;
    public static final int GL_2D = 1536;
    public static final int GL_3D = 1537;
    public static final int GL_3D_COLOR = 1538;
    public static final int GL_3D_COLOR_TEXTURE = 1539;
    public static final int GL_4D_COLOR_TEXTURE = 1540;
    public static final int GL_PASS_THROUGH_TOKEN = 1792;
    public static final int GL_POINT_TOKEN = 1793;
    public static final int GL_LINE_TOKEN = 1794;
    public static final int GL_POLYGON_TOKEN = 1795;
    public static final int GL_BITMAP_TOKEN = 1796;
    public static final int GL_DRAW_PIXEL_TOKEN = 1797;
    public static final int GL_COPY_PIXEL_TOKEN = 1798;
    public static final int GL_LINE_RESET_TOKEN = 1799;
    public static final int GL_EXP = 2048;
    public static final int GL_EXP2 = 2049;
    public static final int GL_CW = 2304;
    public static final int GL_CCW = 2305;
    public static final int GL_COEFF = 2560;
    public static final int GL_ORDER = 2561;
    public static final int GL_DOMAIN = 2562;
    public static final int GL_CURRENT_COLOR = 2816;
    public static final int GL_CURRENT_INDEX = 2817;
    public static final int GL_CURRENT_NORMAL = 2818;
    public static final int GL_CURRENT_TEXTURE_COORDS = 2819;
    public static final int GL_CURRENT_RASTER_COLOR = 2820;
    public static final int GL_CURRENT_RASTER_INDEX = 2821;
    public static final int GL_CURRENT_RASTER_TEXTURE_COORDS = 2822;
    public static final int GL_CURRENT_RASTER_POSITION = 2823;
    public static final int GL_CURRENT_RASTER_POSITION_VALID = 2824;
    public static final int GL_CURRENT_RASTER_DISTANCE = 2825;
    public static final int GL_POINT_SMOOTH = 2832;
    public static final int GL_POINT_SIZE = 2833;
    public static final int GL_POINT_SIZE_RANGE = 2834;
    public static final int GL_POINT_SIZE_GRANULARITY = 2835;
    public static final int GL_LINE_SMOOTH = 2848;
    public static final int GL_LINE_WIDTH = 2849;
    public static final int GL_LINE_WIDTH_RANGE = 2850;
    public static final int GL_LINE_WIDTH_GRANULARITY = 2851;
    public static final int GL_LINE_STIPPLE = 2852;
    public static final int GL_LINE_STIPPLE_PATTERN = 2853;
    public static final int GL_LINE_STIPPLE_REPEAT = 2854;
    public static final int GL_LIST_MODE = 2864;
    public static final int GL_MAX_LIST_NESTING = 2865;
    public static final int GL_LIST_BASE = 2866;
    public static final int GL_LIST_INDEX = 2867;
    public static final int GL_POLYGON_MODE = 2880;
    public static final int GL_POLYGON_SMOOTH = 2881;
    public static final int GL_POLYGON_STIPPLE = 2882;
    public static final int GL_EDGE_FLAG = 2883;
    public static final int GL_CULL_FACE = 2884;
    public static final int GL_CULL_FACE_MODE = 2885;
    public static final int GL_FRONT_FACE = 2886;
    public static final int GL_LIGHTING = 2896;
    public static final int GL_LIGHT_MODEL_LOCAL_VIEWER = 2897;
    public static final int GL_LIGHT_MODEL_TWO_SIDE = 2898;
    public static final int GL_LIGHT_MODEL_AMBIENT = 2899;
    public static final int GL_SHADE_MODEL = 2900;
    public static final int GL_COLOR_MATERIAL_FACE = 2901;
    public static final int GL_COLOR_MATERIAL_PARAMETER = 2902;
    public static final int GL_COLOR_MATERIAL = 2903;
    public static final int GL_FOG = 2912;
    public static final int GL_FOG_INDEX = 2913;
    public static final int GL_FOG_DENSITY = 2914;
    public static final int GL_FOG_START = 2915;
    public static final int GL_FOG_END = 2916;
    public static final int GL_FOG_MODE = 2917;
    public static final int GL_FOG_COLOR = 2918;
    public static final int GL_DEPTH_RANGE = 2928;
    public static final int GL_DEPTH_TEST = 2929;
    public static final int GL_DEPTH_WRITEMASK = 2930;
    public static final int GL_DEPTH_CLEAR_VALUE = 2931;
    public static final int GL_DEPTH_FUNC = 2932;
    public static final int GL_ACCUM_CLEAR_VALUE = 2944;
    public static final int GL_STENCIL_TEST = 2960;
    public static final int GL_STENCIL_CLEAR_VALUE = 2961;
    public static final int GL_STENCIL_FUNC = 2962;
    public static final int GL_STENCIL_VALUE_MASK = 2963;
    public static final int GL_STENCIL_FAIL = 2964;
    public static final int GL_STENCIL_PASS_DEPTH_FAIL = 2965;
    public static final int GL_STENCIL_PASS_DEPTH_PASS = 2966;
    public static final int GL_STENCIL_REF = 2967;
    public static final int GL_STENCIL_WRITEMASK = 2968;
    public static final int GL_MATRIX_MODE = 2976;
    public static final int GL_NORMALIZE = 2977;
    public static final int GL_VIEWPORT = 2978;
    public static final int GL_MODELVIEW_STACK_DEPTH = 2979;
    public static final int GL_PROJECTION_STACK_DEPTH = 2980;
    public static final int GL_TEXTURE_STACK_DEPTH = 2981;
    public static final int GL_MODELVIEW_MATRIX = 2982;
    public static final int GL_PROJECTION_MATRIX = 2983;
    public static final int GL_TEXTURE_MATRIX = 2984;
    public static final int GL_ATTRIB_STACK_DEPTH = 2992;
    public static final int GL_CLIENT_ATTRIB_STACK_DEPTH = 2993;
    public static final int GL_ALPHA_TEST = 3008;
    public static final int GL_ALPHA_TEST_FUNC = 3009;
    public static final int GL_ALPHA_TEST_REF = 3010;
    public static final int GL_DITHER = 3024;
    public static final int GL_BLEND_DST = 3040;
    public static final int GL_BLEND_SRC = 3041;
    public static final int GL_BLEND = 3042;
    public static final int GL_LOGIC_OP_MODE = 3056;
    public static final int GL_INDEX_LOGIC_OP = 3057;
    public static final int GL_LOGIC_OP = 3057;
    public static final int GL_COLOR_LOGIC_OP = 3058;
    public static final int GL_AUX_BUFFERS = 3072;
    public static final int GL_DRAW_BUFFER = 3073;
    public static final int GL_READ_BUFFER = 3074;
    public static final int GL_SCISSOR_BOX = 3088;
    public static final int GL_SCISSOR_TEST = 3089;
    public static final int GL_INDEX_CLEAR_VALUE = 3104;
    public static final int GL_INDEX_WRITEMASK = 3105;
    public static final int GL_COLOR_CLEAR_VALUE = 3106;
    public static final int GL_COLOR_WRITEMASK = 3107;
    public static final int GL_INDEX_MODE = 3120;
    public static final int GL_RGBA_MODE = 3121;
    public static final int GL_DOUBLEBUFFER = 3122;
    public static final int GL_STEREO = 3123;
    public static final int GL_RENDER_MODE = 3136;
    public static final int GL_PERSPECTIVE_CORRECTION_HINT = 3152;
    public static final int GL_POINT_SMOOTH_HINT = 3153;
    public static final int GL_LINE_SMOOTH_HINT = 3154;
    public static final int GL_POLYGON_SMOOTH_HINT = 3155;
    public static final int GL_FOG_HINT = 3156;
    public static final int GL_TEXTURE_GEN_S = 3168;
    public static final int GL_TEXTURE_GEN_T = 3169;
    public static final int GL_TEXTURE_GEN_R = 3170;
    public static final int GL_TEXTURE_GEN_Q = 3171;
    public static final int GL_PIXEL_MAP_I_TO_I = 3184;
    public static final int GL_PIXEL_MAP_S_TO_S = 3185;
    public static final int GL_PIXEL_MAP_I_TO_R = 3186;
    public static final int GL_PIXEL_MAP_I_TO_G = 3187;
    public static final int GL_PIXEL_MAP_I_TO_B = 3188;
    public static final int GL_PIXEL_MAP_I_TO_A = 3189;
    public static final int GL_PIXEL_MAP_R_TO_R = 3190;
    public static final int GL_PIXEL_MAP_G_TO_G = 3191;
    public static final int GL_PIXEL_MAP_B_TO_B = 3192;
    public static final int GL_PIXEL_MAP_A_TO_A = 3193;
    public static final int GL_PIXEL_MAP_I_TO_I_SIZE = 3248;
    public static final int GL_PIXEL_MAP_S_TO_S_SIZE = 3249;
    public static final int GL_PIXEL_MAP_I_TO_R_SIZE = 3250;
    public static final int GL_PIXEL_MAP_I_TO_G_SIZE = 3251;
    public static final int GL_PIXEL_MAP_I_TO_B_SIZE = 3252;
    public static final int GL_PIXEL_MAP_I_TO_A_SIZE = 3253;
    public static final int GL_PIXEL_MAP_R_TO_R_SIZE = 3254;
    public static final int GL_PIXEL_MAP_G_TO_G_SIZE = 3255;
    public static final int GL_PIXEL_MAP_B_TO_B_SIZE = 3256;
    public static final int GL_PIXEL_MAP_A_TO_A_SIZE = 3257;
    public static final int GL_UNPACK_SWAP_BYTES = 3312;
    public static final int GL_UNPACK_LSB_FIRST = 3313;
    public static final int GL_UNPACK_ROW_LENGTH = 3314;
    public static final int GL_UNPACK_SKIP_ROWS = 3315;
    public static final int GL_UNPACK_SKIP_PIXELS = 3316;
    public static final int GL_UNPACK_ALIGNMENT = 3317;
    public static final int GL_PACK_SWAP_BYTES = 3328;
    public static final int GL_PACK_LSB_FIRST = 3329;
    public static final int GL_PACK_ROW_LENGTH = 3330;
    public static final int GL_PACK_SKIP_ROWS = 3331;
    public static final int GL_PACK_SKIP_PIXELS = 3332;
    public static final int GL_PACK_ALIGNMENT = 3333;
    public static final int GL_MAP_COLOR = 3344;
    public static final int GL_MAP_STENCIL = 3345;
    public static final int GL_INDEX_SHIFT = 3346;
    public static final int GL_INDEX_OFFSET = 3347;
    public static final int GL_RED_SCALE = 3348;
    public static final int GL_RED_BIAS = 3349;
    public static final int GL_ZOOM_X = 3350;
    public static final int GL_ZOOM_Y = 3351;
    public static final int GL_GREEN_SCALE = 3352;
    public static final int GL_GREEN_BIAS = 3353;
    public static final int GL_BLUE_SCALE = 3354;
    public static final int GL_BLUE_BIAS = 3355;
    public static final int GL_ALPHA_SCALE = 3356;
    public static final int GL_ALPHA_BIAS = 3357;
    public static final int GL_DEPTH_SCALE = 3358;
    public static final int GL_DEPTH_BIAS = 3359;
    public static final int GL_MAX_EVAL_ORDER = 3376;
    public static final int GL_MAX_LIGHTS = 3377;
    public static final int GL_MAX_CLIP_PLANES = 3378;
    public static final int GL_MAX_TEXTURE_SIZE = 3379;
    public static final int GL_MAX_PIXEL_MAP_TABLE = 3380;
    public static final int GL_MAX_ATTRIB_STACK_DEPTH = 3381;
    public static final int GL_MAX_MODELVIEW_STACK_DEPTH = 3382;
    public static final int GL_MAX_NAME_STACK_DEPTH = 3383;
    public static final int GL_MAX_PROJECTION_STACK_DEPTH = 3384;
    public static final int GL_MAX_TEXTURE_STACK_DEPTH = 3385;
    public static final int GL_MAX_VIEWPORT_DIMS = 3386;
    public static final int GL_MAX_CLIENT_ATTRIB_STACK_DEPTH = 3387;
    public static final int GL_SUBPIXEL_BITS = 3408;
    public static final int GL_INDEX_BITS = 3409;
    public static final int GL_RED_BITS = 3410;
    public static final int GL_GREEN_BITS = 3411;
    public static final int GL_BLUE_BITS = 3412;
    public static final int GL_ALPHA_BITS = 3413;
    public static final int GL_DEPTH_BITS = 3414;
    public static final int GL_STENCIL_BITS = 3415;
    public static final int GL_ACCUM_RED_BITS = 3416;
    public static final int GL_ACCUM_GREEN_BITS = 3417;
    public static final int GL_ACCUM_BLUE_BITS = 3418;
    public static final int GL_ACCUM_ALPHA_BITS = 3419;
    public static final int GL_NAME_STACK_DEPTH = 3440;
    public static final int GL_AUTO_NORMAL = 3456;
    public static final int GL_MAP1_COLOR_4 = 3472;
    public static final int GL_MAP1_INDEX = 3473;
    public static final int GL_MAP1_NORMAL = 3474;
    public static final int GL_MAP1_TEXTURE_COORD_1 = 3475;
    public static final int GL_MAP1_TEXTURE_COORD_2 = 3476;
    public static final int GL_MAP1_TEXTURE_COORD_3 = 3477;
    public static final int GL_MAP1_TEXTURE_COORD_4 = 3478;
    public static final int GL_MAP1_VERTEX_3 = 3479;
    public static final int GL_MAP1_VERTEX_4 = 3480;
    public static final int GL_MAP2_COLOR_4 = 3504;
    public static final int GL_MAP2_INDEX = 3505;
    public static final int GL_MAP2_NORMAL = 3506;
    public static final int GL_MAP2_TEXTURE_COORD_1 = 3507;
    public static final int GL_MAP2_TEXTURE_COORD_2 = 3508;
    public static final int GL_MAP2_TEXTURE_COORD_3 = 3509;
    public static final int GL_MAP2_TEXTURE_COORD_4 = 3510;
    public static final int GL_MAP2_VERTEX_3 = 3511;
    public static final int GL_MAP2_VERTEX_4 = 3512;
    public static final int GL_MAP1_GRID_DOMAIN = 3536;
    public static final int GL_MAP1_GRID_SEGMENTS = 3537;
    public static final int GL_MAP2_GRID_DOMAIN = 3538;
    public static final int GL_MAP2_GRID_SEGMENTS = 3539;
    public static final int GL_TEXTURE_1D = 3552;
    public static final int GL_TEXTURE_2D = 3553;
    public static final int GL_FEEDBACK_BUFFER_POINTER = 3568;
    public static final int GL_FEEDBACK_BUFFER_SIZE = 3569;
    public static final int GL_FEEDBACK_BUFFER_TYPE = 3570;
    public static final int GL_SELECTION_BUFFER_POINTER = 3571;
    public static final int GL_SELECTION_BUFFER_SIZE = 3572;
    public static final int GL_TEXTURE_WIDTH = 4096;
    public static final int GL_TEXTURE_HEIGHT = 4097;
    public static final int GL_TEXTURE_INTERNAL_FORMAT = 4099;
    public static final int GL_TEXTURE_COMPONENTS = 4099;
    public static final int GL_TEXTURE_BORDER_COLOR = 4100;
    public static final int GL_TEXTURE_BORDER = 4101;
    public static final int GL_DONT_CARE = 4352;
    public static final int GL_FASTEST = 4353;
    public static final int GL_NICEST = 4354;
    public static final int GL_LIGHT0 = 16384;
    public static final int GL_LIGHT1 = 16385;
    public static final int GL_LIGHT2 = 16386;
    public static final int GL_LIGHT3 = 16387;
    public static final int GL_LIGHT4 = 16388;
    public static final int GL_LIGHT5 = 16389;
    public static final int GL_LIGHT6 = 16390;
    public static final int GL_LIGHT7 = 16391;
    public static final int GL_AMBIENT = 4608;
    public static final int GL_DIFFUSE = 4609;
    public static final int GL_SPECULAR = 4610;
    public static final int GL_POSITION = 4611;
    public static final int GL_SPOT_DIRECTION = 4612;
    public static final int GL_SPOT_EXPONENT = 4613;
    public static final int GL_SPOT_CUTOFF = 4614;
    public static final int GL_CONSTANT_ATTENUATION = 4615;
    public static final int GL_LINEAR_ATTENUATION = 4616;
    public static final int GL_QUADRATIC_ATTENUATION = 4617;
    public static final int GL_COMPILE = 4864;
    public static final int GL_COMPILE_AND_EXECUTE = 4865;
    public static final int GL_CLEAR = 5376;
    public static final int GL_AND = 5377;
    public static final int GL_AND_REVERSE = 5378;
    public static final int GL_COPY = 5379;
    public static final int GL_AND_INVERTED = 5380;
    public static final int GL_NOOP = 5381;
    public static final int GL_XOR = 5382;
    public static final int GL_OR = 5383;
    public static final int GL_NOR = 5384;
    public static final int GL_EQUIV = 5385;
    public static final int GL_INVERT = 5386;
    public static final int GL_OR_REVERSE = 5387;
    public static final int GL_COPY_INVERTED = 5388;
    public static final int GL_OR_INVERTED = 5389;
    public static final int GL_NAND = 5390;
    public static final int GL_SET = 5391;
    public static final int GL_EMISSION = 5632;
    public static final int GL_SHININESS = 5633;
    public static final int GL_AMBIENT_AND_DIFFUSE = 5634;
    public static final int GL_COLOR_INDEXES = 5635;
    public static final int GL_MODELVIEW = 5888;
    public static final int GL_PROJECTION = 5889;
    public static final int GL_TEXTURE = 5890;
    public static final int GL_COLOR = 6144;
    public static final int GL_DEPTH = 6145;
    public static final int GL_STENCIL = 6146;
    public static final int GL_COLOR_INDEX = 6400;
    public static final int GL_STENCIL_INDEX = 6401;
    public static final int GL_DEPTH_COMPONENT = 6402;
    public static final int GL_RED = 6403;
    public static final int GL_GREEN = 6404;
    public static final int GL_BLUE = 6405;
    public static final int GL_ALPHA = 6406;
    public static final int GL_RGB = 6407;
    public static final int GL_RGBA = 6408;
    public static final int GL_LUMINANCE = 6409;
    public static final int GL_LUMINANCE_ALPHA = 6410;
    public static final int GL_BITMAP = 6656;
    public static final int GL_POINT = 6912;
    public static final int GL_LINE = 6913;
    public static final int GL_FILL = 6914;
    public static final int GL_RENDER = 7168;
    public static final int GL_FEEDBACK = 7169;
    public static final int GL_SELECT = 7170;
    public static final int GL_FLAT = 7424;
    public static final int GL_SMOOTH = 7425;
    public static final int GL_KEEP = 7680;
    public static final int GL_REPLACE = 7681;
    public static final int GL_INCR = 7682;
    public static final int GL_DECR = 7683;
    public static final int GL_VENDOR = 7936;
    public static final int GL_RENDERER = 7937;
    public static final int GL_VERSION = 7938;
    public static final int GL_EXTENSIONS = 7939;
    public static final int GL_S = 8192;
    public static final int GL_T = 8193;
    public static final int GL_R = 8194;
    public static final int GL_Q = 8195;
    public static final int GL_MODULATE = 8448;
    public static final int GL_DECAL = 8449;
    public static final int GL_TEXTURE_ENV_MODE = 8704;
    public static final int GL_TEXTURE_ENV_COLOR = 8705;
    public static final int GL_TEXTURE_ENV = 8960;
    public static final int GL_EYE_LINEAR = 9216;
    public static final int GL_OBJECT_LINEAR = 9217;
    public static final int GL_SPHERE_MAP = 9218;
    public static final int GL_TEXTURE_GEN_MODE = 9472;
    public static final int GL_OBJECT_PLANE = 9473;
    public static final int GL_EYE_PLANE = 9474;
    public static final int GL_NEAREST = 9728;
    public static final int GL_LINEAR = 9729;
    public static final int GL_NEAREST_MIPMAP_NEAREST = 9984;
    public static final int GL_LINEAR_MIPMAP_NEAREST = 9985;
    public static final int GL_NEAREST_MIPMAP_LINEAR = 9986;
    public static final int GL_LINEAR_MIPMAP_LINEAR = 9987;
    public static final int GL_TEXTURE_MAG_FILTER = 10240;
    public static final int GL_TEXTURE_MIN_FILTER = 10241;
    public static final int GL_TEXTURE_WRAP_S = 10242;
    public static final int GL_TEXTURE_WRAP_T = 10243;
    public static final int GL_CLAMP = 10496;
    public static final int GL_REPEAT = 10497;
    public static final int GL_CLIENT_PIXEL_STORE_BIT = 1;
    public static final int GL_CLIENT_VERTEX_ARRAY_BIT = 2;
    public static final int GL_CLIENT_ALL_ATTRIB_BITS = -1;
    public static final int GL_POLYGON_OFFSET_FACTOR = 32824;
    public static final int GL_POLYGON_OFFSET_UNITS = 10752;
    public static final int GL_POLYGON_OFFSET_POINT = 10753;
    public static final int GL_POLYGON_OFFSET_LINE = 10754;
    public static final int GL_POLYGON_OFFSET_FILL = 32823;
    public static final int GL_ALPHA4 = 32827;
    public static final int GL_ALPHA8 = 32828;
    public static final int GL_ALPHA12 = 32829;
    public static final int GL_ALPHA16 = 32830;
    public static final int GL_LUMINANCE4 = 32831;
    public static final int GL_LUMINANCE8 = 32832;
    public static final int GL_LUMINANCE12 = 32833;
    public static final int GL_LUMINANCE16 = 32834;
    public static final int GL_LUMINANCE4_ALPHA4 = 32835;
    public static final int GL_LUMINANCE6_ALPHA2 = 32836;
    public static final int GL_LUMINANCE8_ALPHA8 = 32837;
    public static final int GL_LUMINANCE12_ALPHA4 = 32838;
    public static final int GL_LUMINANCE12_ALPHA12 = 32839;
    public static final int GL_LUMINANCE16_ALPHA16 = 32840;
    public static final int GL_INTENSITY = 32841;
    public static final int GL_INTENSITY4 = 32842;
    public static final int GL_INTENSITY8 = 32843;
    public static final int GL_INTENSITY12 = 32844;
    public static final int GL_INTENSITY16 = 32845;
    public static final int GL_R3_G3_B2 = 10768;
    public static final int GL_RGB4 = 32847;
    public static final int GL_RGB5 = 32848;
    public static final int GL_RGB8 = 32849;
    public static final int GL_RGB10 = 32850;
    public static final int GL_RGB12 = 32851;
    public static final int GL_RGB16 = 32852;
    public static final int GL_RGBA2 = 32853;
    public static final int GL_RGBA4 = 32854;
    public static final int GL_RGB5_A1 = 32855;
    public static final int GL_RGBA8 = 32856;
    public static final int GL_RGB10_A2 = 32857;
    public static final int GL_RGBA12 = 32858;
    public static final int GL_RGBA16 = 32859;
    public static final int GL_TEXTURE_RED_SIZE = 32860;
    public static final int GL_TEXTURE_GREEN_SIZE = 32861;
    public static final int GL_TEXTURE_BLUE_SIZE = 32862;
    public static final int GL_TEXTURE_ALPHA_SIZE = 32863;
    public static final int GL_TEXTURE_LUMINANCE_SIZE = 32864;
    public static final int GL_TEXTURE_INTENSITY_SIZE = 32865;
    public static final int GL_PROXY_TEXTURE_1D = 32867;
    public static final int GL_PROXY_TEXTURE_2D = 32868;
    public static final int GL_TEXTURE_PRIORITY = 32870;
    public static final int GL_TEXTURE_RESIDENT = 32871;
    public static final int GL_TEXTURE_BINDING_1D = 32872;
    public static final int GL_TEXTURE_BINDING_2D = 32873;
    public static final int GL_VERTEX_ARRAY = 32884;
    public static final int GL_NORMAL_ARRAY = 32885;
    public static final int GL_COLOR_ARRAY = 32886;
    public static final int GL_INDEX_ARRAY = 32887;
    public static final int GL_TEXTURE_COORD_ARRAY = 32888;
    public static final int GL_EDGE_FLAG_ARRAY = 32889;
    public static final int GL_VERTEX_ARRAY_SIZE = 32890;
    public static final int GL_VERTEX_ARRAY_TYPE = 32891;
    public static final int GL_VERTEX_ARRAY_STRIDE = 32892;
    public static final int GL_NORMAL_ARRAY_TYPE = 32894;
    public static final int GL_NORMAL_ARRAY_STRIDE = 32895;
    public static final int GL_COLOR_ARRAY_SIZE = 32897;
    public static final int GL_COLOR_ARRAY_TYPE = 32898;
    public static final int GL_COLOR_ARRAY_STRIDE = 32899;
    public static final int GL_INDEX_ARRAY_TYPE = 32901;
    public static final int GL_INDEX_ARRAY_STRIDE = 32902;
    public static final int GL_TEXTURE_COORD_ARRAY_SIZE = 32904;
    public static final int GL_TEXTURE_COORD_ARRAY_TYPE = 32905;
    public static final int GL_TEXTURE_COORD_ARRAY_STRIDE = 32906;
    public static final int GL_EDGE_FLAG_ARRAY_STRIDE = 32908;
    public static final int GL_VERTEX_ARRAY_POINTER = 32910;
    public static final int GL_NORMAL_ARRAY_POINTER = 32911;
    public static final int GL_COLOR_ARRAY_POINTER = 32912;
    public static final int GL_INDEX_ARRAY_POINTER = 32913;
    public static final int GL_TEXTURE_COORD_ARRAY_POINTER = 32914;
    public static final int GL_EDGE_FLAG_ARRAY_POINTER = 32915;
    public static final int GL_V2F = 10784;
    public static final int GL_V3F = 10785;
    public static final int GL_C4UB_V2F = 10786;
    public static final int GL_C4UB_V3F = 10787;
    public static final int GL_C3F_V3F = 10788;
    public static final int GL_N3F_V3F = 10789;
    public static final int GL_C4F_N3F_V3F = 10790;
    public static final int GL_T2F_V3F = 10791;
    public static final int GL_T4F_V4F = 10792;
    public static final int GL_T2F_C4UB_V3F = 10793;
    public static final int GL_T2F_C3F_V3F = 10794;
    public static final int GL_T2F_N3F_V3F = 10795;
    public static final int GL_T2F_C4F_N3F_V3F = 10796;
    public static final int GL_T4F_C4F_N3F_V4F = 10797;

    protected GL11() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext, boolean fc) {
        return (fc || Checks.checkFunctions(caps.glAccum, caps.glAlphaFunc, caps.glAreTexturesResident, caps.glArrayElement, caps.glBegin, caps.glBitmap, caps.glCallList, caps.glCallLists, caps.glClearAccum, caps.glClearIndex, caps.glClipPlane, caps.glColor3b, caps.glColor3s, caps.glColor3i, caps.glColor3f, caps.glColor3d, caps.glColor3ub, caps.glColor3us, caps.glColor3ui, caps.glColor3bv, caps.glColor3sv, caps.glColor3iv, caps.glColor3fv, caps.glColor3dv, caps.glColor3ubv, caps.glColor3usv, caps.glColor3uiv, caps.glColor4b, caps.glColor4s, caps.glColor4i, caps.glColor4f, caps.glColor4d, caps.glColor4ub, caps.glColor4us, caps.glColor4ui, caps.glColor4bv, caps.glColor4sv, caps.glColor4iv, caps.glColor4fv, caps.glColor4dv, caps.glColor4ubv, caps.glColor4usv, caps.glColor4uiv, caps.glColorMaterial, caps.glColorPointer, caps.glCopyPixels, caps.glDeleteLists, caps.glDrawPixels, caps.glEdgeFlag, caps.glEdgeFlagv, caps.glEdgeFlagPointer, caps.glEnd, caps.glEvalCoord1f, caps.glEvalCoord1fv, caps.glEvalCoord1d, caps.glEvalCoord1dv, caps.glEvalCoord2f, caps.glEvalCoord2fv, caps.glEvalCoord2d, caps.glEvalCoord2dv, caps.glEvalMesh1, caps.glEvalMesh2, caps.glEvalPoint1, caps.glEvalPoint2, caps.glFeedbackBuffer, caps.glFogi, caps.glFogiv, caps.glFogf, caps.glFogfv, caps.glGenLists, caps.glGetClipPlane, caps.glGetLightiv, caps.glGetLightfv, caps.glGetMapiv, caps.glGetMapfv, caps.glGetMapdv, caps.glGetMaterialiv, caps.glGetMaterialfv, caps.glGetPixelMapfv, caps.glGetPixelMapusv, caps.glGetPixelMapuiv, caps.glGetPolygonStipple, caps.glGetTexEnviv, caps.glGetTexEnvfv, caps.glGetTexGeniv, caps.glGetTexGenfv, caps.glGetTexGendv, caps.glIndexi, caps.glIndexub, caps.glIndexs, caps.glIndexf, caps.glIndexd, caps.glIndexiv, caps.glIndexubv, caps.glIndexsv, caps.glIndexfv, caps.glIndexdv, caps.glIndexMask, caps.glIndexPointer, caps.glInitNames, caps.glInterleavedArrays, caps.glIsList, caps.glLightModeli, caps.glLightModelf, caps.glLightModeliv, caps.glLightModelfv, caps.glLighti, caps.glLightf, caps.glLightiv, caps.glLightfv, caps.glLineStipple, caps.glListBase, caps.glLoadMatrixf, caps.glLoadMatrixd, caps.glLoadIdentity, caps.glLoadName, caps.glMap1f, caps.glMap1d, caps.glMap2f, caps.glMap2d, caps.glMapGrid1f, caps.glMapGrid1d, caps.glMapGrid2f, caps.glMapGrid2d, caps.glMateriali, caps.glMaterialf, caps.glMaterialiv, caps.glMaterialfv, caps.glMatrixMode, caps.glMultMatrixf, caps.glMultMatrixd, caps.glFrustum, caps.glNewList, caps.glEndList, caps.glNormal3f, caps.glNormal3b, caps.glNormal3s, caps.glNormal3i, caps.glNormal3d, caps.glNormal3fv, caps.glNormal3bv, caps.glNormal3sv, caps.glNormal3iv, caps.glNormal3dv, caps.glNormalPointer, caps.glOrtho, caps.glPassThrough, caps.glPixelMapfv, caps.glPixelMapusv, caps.glPixelMapuiv, caps.glPixelTransferi, caps.glPixelTransferf, caps.glPixelZoom, caps.glPolygonStipple, caps.glPushAttrib, caps.glPushClientAttrib, caps.glPopAttrib, caps.glPopClientAttrib, caps.glPopMatrix, caps.glPopName, caps.glPrioritizeTextures, caps.glPushMatrix, caps.glPushName, caps.glRasterPos2i, caps.glRasterPos2s, caps.glRasterPos2f, caps.glRasterPos2d, caps.glRasterPos2iv, caps.glRasterPos2sv, caps.glRasterPos2fv, caps.glRasterPos2dv, caps.glRasterPos3i, caps.glRasterPos3s, caps.glRasterPos3f, caps.glRasterPos3d, caps.glRasterPos3iv, caps.glRasterPos3sv, caps.glRasterPos3fv, caps.glRasterPos3dv, caps.glRasterPos4i, caps.glRasterPos4s, caps.glRasterPos4f, caps.glRasterPos4d, caps.glRasterPos4iv, caps.glRasterPos4sv, caps.glRasterPos4fv, caps.glRasterPos4dv, caps.glRecti, caps.glRects, caps.glRectf, caps.glRectd, caps.glRectiv, caps.glRectsv, caps.glRectfv, caps.glRectdv, caps.glRenderMode, caps.glRotatef, caps.glRotated, caps.glScalef, caps.glScaled, caps.glSelectBuffer, caps.glShadeModel, caps.glTexCoord1f, caps.glTexCoord1s, caps.glTexCoord1i, caps.glTexCoord1d, caps.glTexCoord1fv, caps.glTexCoord1sv, caps.glTexCoord1iv, caps.glTexCoord1dv, caps.glTexCoord2f, caps.glTexCoord2s, caps.glTexCoord2i, caps.glTexCoord2d, caps.glTexCoord2fv, caps.glTexCoord2sv, caps.glTexCoord2iv, caps.glTexCoord2dv, caps.glTexCoord3f, caps.glTexCoord3s, caps.glTexCoord3i, caps.glTexCoord3d, caps.glTexCoord3fv, caps.glTexCoord3sv, caps.glTexCoord3iv, caps.glTexCoord3dv, caps.glTexCoord4f, caps.glTexCoord4s, caps.glTexCoord4i, caps.glTexCoord4d, caps.glTexCoord4fv, caps.glTexCoord4sv, caps.glTexCoord4iv, caps.glTexCoord4dv, caps.glTexCoordPointer, caps.glTexEnvi, caps.glTexEnviv, caps.glTexEnvf, caps.glTexEnvfv, caps.glTexGeni, caps.glTexGeniv, caps.glTexGenf, caps.glTexGenfv, caps.glTexGend, caps.glTexGendv, caps.glTranslatef, caps.glTranslated, caps.glVertex2f, caps.glVertex2s, caps.glVertex2i, caps.glVertex2d, caps.glVertex2fv, caps.glVertex2sv, caps.glVertex2iv, caps.glVertex2dv, caps.glVertex3f, caps.glVertex3s, caps.glVertex3i, caps.glVertex3d, caps.glVertex3fv, caps.glVertex3sv, caps.glVertex3iv, caps.glVertex3dv, caps.glVertex4f, caps.glVertex4s, caps.glVertex4i, caps.glVertex4d, caps.glVertex4fv, caps.glVertex4sv, caps.glVertex4iv, caps.glVertex4dv, caps.glVertexPointer)) && Checks.checkFunctions(caps.glEnable, caps.glDisable, caps.glBindTexture, caps.glBlendFunc, caps.glClear, caps.glClearColor, caps.glClearDepth, caps.glClearStencil, caps.glColorMask, caps.glCullFace, caps.glDepthFunc, caps.glDepthMask, caps.glDepthRange, ext.contains("GL_NV_vertex_buffer_unified_memory") ? caps.glDisableClientState : -1L, caps.glDrawArrays, caps.glDrawBuffer, caps.glDrawElements, ext.contains("GL_NV_vertex_buffer_unified_memory") ? caps.glEnableClientState : -1L, caps.glFinish, caps.glFlush, caps.glFrontFace, caps.glGenTextures, caps.glDeleteTextures, caps.glGetBooleanv, caps.glGetFloatv, caps.glGetIntegerv, caps.glGetDoublev, caps.glGetError, caps.glGetPointerv, caps.glGetString, caps.glGetTexImage, caps.glGetTexLevelParameteriv, caps.glGetTexLevelParameterfv, caps.glGetTexParameteriv, caps.glGetTexParameterfv, caps.glHint, caps.glIsEnabled, caps.glIsTexture, caps.glLineWidth, caps.glLogicOp, caps.glPixelStorei, caps.glPixelStoref, caps.glPointSize, caps.glPolygonMode, caps.glPolygonOffset, caps.glReadBuffer, caps.glReadPixels, caps.glScissor, caps.glStencilFunc, caps.glStencilMask, caps.glStencilOp, caps.glTexImage1D, caps.glTexImage2D, caps.glCopyTexImage1D, caps.glCopyTexImage2D, caps.glCopyTexSubImage1D, caps.glCopyTexSubImage2D, caps.glTexParameteri, caps.glTexParameteriv, caps.glTexParameterf, caps.glTexParameterfv, caps.glTexSubImage1D, caps.glTexSubImage2D, caps.glViewport);
    }

    public static void glEnable(@NativeType(value="GLenum") int target) {
        GL11C.glEnable(target);
    }

    public static void glDisable(@NativeType(value="GLenum") int target) {
        GL11C.glDisable(target);
    }

    public static native void glAccum(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1);

    public static native void glAlphaFunc(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1);

    public static native boolean nglAreTexturesResident(int var0, long var1, long var3);

    @NativeType(value="GLboolean")
    public static boolean glAreTexturesResident(@NativeType(value="GLuint const *") IntBuffer textures, @NativeType(value="GLboolean *") ByteBuffer residences) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)residences, textures.remaining());
        }
        return GL11.nglAreTexturesResident(textures.remaining(), MemoryUtil.memAddress(textures), MemoryUtil.memAddress(residences));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLboolean")
    public static boolean glAreTexturesResident(@NativeType(value="GLuint const *") int texture, @NativeType(value="GLboolean *") ByteBuffer residences) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)residences, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer textures = stack.ints(texture);
            boolean bl = GL11.nglAreTexturesResident(1, MemoryUtil.memAddress(textures), MemoryUtil.memAddress(residences));
            return bl;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glArrayElement(@NativeType(value="GLint") int var0);

    public static native void glBegin(@NativeType(value="GLenum") int var0);

    public static void glBindTexture(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int texture) {
        GL11C.glBindTexture(target, texture);
    }

    public static native void nglBitmap(int var0, int var1, float var2, float var3, float var4, float var5, long var6);

    public static void glBitmap(@NativeType(value="GLsizei") int w, @NativeType(value="GLsizei") int h, @NativeType(value="GLfloat") float xOrig, @NativeType(value="GLfloat") float yOrig, @NativeType(value="GLfloat") float xInc, @NativeType(value="GLfloat") float yInc, @Nullable @NativeType(value="GLubyte const *") ByteBuffer data) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)data, (w + 7 >> 3) * h);
        }
        GL11.nglBitmap(w, h, xOrig, yOrig, xInc, yInc, MemoryUtil.memAddressSafe(data));
    }

    public static void glBitmap(@NativeType(value="GLsizei") int w, @NativeType(value="GLsizei") int h, @NativeType(value="GLfloat") float xOrig, @NativeType(value="GLfloat") float yOrig, @NativeType(value="GLfloat") float xInc, @NativeType(value="GLfloat") float yInc, @Nullable @NativeType(value="GLubyte const *") long data) {
        GL11.nglBitmap(w, h, xOrig, yOrig, xInc, yInc, data);
    }

    public static void glBlendFunc(@NativeType(value="GLenum") int sfactor, @NativeType(value="GLenum") int dfactor) {
        GL11C.glBlendFunc(sfactor, dfactor);
    }

    public static native void glCallList(@NativeType(value="GLuint") int var0);

    public static native void nglCallLists(int var0, int var1, long var2);

    public static void glCallLists(@NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer lists) {
        GL11.nglCallLists(lists.remaining() / GLChecks.typeToBytes(type), type, MemoryUtil.memAddress(lists));
    }

    public static void glCallLists(@NativeType(value="void const *") ByteBuffer lists) {
        GL11.nglCallLists(lists.remaining(), 5121, MemoryUtil.memAddress(lists));
    }

    public static void glCallLists(@NativeType(value="void const *") ShortBuffer lists) {
        GL11.nglCallLists(lists.remaining(), 5123, MemoryUtil.memAddress(lists));
    }

    public static void glCallLists(@NativeType(value="void const *") IntBuffer lists) {
        GL11.nglCallLists(lists.remaining(), 5125, MemoryUtil.memAddress(lists));
    }

    public static void glClear(@NativeType(value="GLbitfield") int mask) {
        GL11C.glClear(mask);
    }

    public static native void glClearAccum(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static void glClearColor(@NativeType(value="GLfloat") float red, @NativeType(value="GLfloat") float green, @NativeType(value="GLfloat") float blue, @NativeType(value="GLfloat") float alpha) {
        GL11C.glClearColor(red, green, blue, alpha);
    }

    public static void glClearDepth(@NativeType(value="GLdouble") double depth) {
        GL11C.glClearDepth(depth);
    }

    public static native void glClearIndex(@NativeType(value="GLfloat") float var0);

    public static void glClearStencil(@NativeType(value="GLint") int s) {
        GL11C.glClearStencil(s);
    }

    public static native void nglClipPlane(int var0, long var1);

    public static void glClipPlane(@NativeType(value="GLenum") int plane, @NativeType(value="GLdouble const *") DoubleBuffer equation) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)equation, 4);
        }
        GL11.nglClipPlane(plane, MemoryUtil.memAddress(equation));
    }

    public static native void glColor3b(@NativeType(value="GLbyte") byte var0, @NativeType(value="GLbyte") byte var1, @NativeType(value="GLbyte") byte var2);

    public static native void glColor3s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2);

    public static native void glColor3i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glColor3f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glColor3d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4);

    public static native void glColor3ub(@NativeType(value="GLubyte") byte var0, @NativeType(value="GLubyte") byte var1, @NativeType(value="GLubyte") byte var2);

    public static native void glColor3us(@NativeType(value="GLushort") short var0, @NativeType(value="GLushort") short var1, @NativeType(value="GLushort") short var2);

    public static native void glColor3ui(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void nglColor3bv(long var0);

    public static void glColor3bv(@NativeType(value="GLbyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglColor3bv(MemoryUtil.memAddress(v));
    }

    public static native void nglColor3sv(long var0);

    public static void glColor3sv(@NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglColor3sv(MemoryUtil.memAddress(v));
    }

    public static native void nglColor3iv(long var0);

    public static void glColor3iv(@NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglColor3iv(MemoryUtil.memAddress(v));
    }

    public static native void nglColor3fv(long var0);

    public static void glColor3fv(@NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglColor3fv(MemoryUtil.memAddress(v));
    }

    public static native void nglColor3dv(long var0);

    public static void glColor3dv(@NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglColor3dv(MemoryUtil.memAddress(v));
    }

    public static native void nglColor3ubv(long var0);

    public static void glColor3ubv(@NativeType(value="GLubyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglColor3ubv(MemoryUtil.memAddress(v));
    }

    public static native void nglColor3usv(long var0);

    public static void glColor3usv(@NativeType(value="GLushort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglColor3usv(MemoryUtil.memAddress(v));
    }

    public static native void nglColor3uiv(long var0);

    public static void glColor3uiv(@NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglColor3uiv(MemoryUtil.memAddress(v));
    }

    public static native void glColor4b(@NativeType(value="GLbyte") byte var0, @NativeType(value="GLbyte") byte var1, @NativeType(value="GLbyte") byte var2, @NativeType(value="GLbyte") byte var3);

    public static native void glColor4s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2, @NativeType(value="GLshort") short var3);

    public static native void glColor4i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glColor4f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glColor4d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6);

    public static native void glColor4ub(@NativeType(value="GLubyte") byte var0, @NativeType(value="GLubyte") byte var1, @NativeType(value="GLubyte") byte var2, @NativeType(value="GLubyte") byte var3);

    public static native void glColor4us(@NativeType(value="GLushort") short var0, @NativeType(value="GLushort") short var1, @NativeType(value="GLushort") short var2, @NativeType(value="GLushort") short var3);

    public static native void glColor4ui(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void nglColor4bv(long var0);

    public static void glColor4bv(@NativeType(value="GLbyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL11.nglColor4bv(MemoryUtil.memAddress(v));
    }

    public static native void nglColor4sv(long var0);

    public static void glColor4sv(@NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL11.nglColor4sv(MemoryUtil.memAddress(v));
    }

    public static native void nglColor4iv(long var0);

    public static void glColor4iv(@NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL11.nglColor4iv(MemoryUtil.memAddress(v));
    }

    public static native void nglColor4fv(long var0);

    public static void glColor4fv(@NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL11.nglColor4fv(MemoryUtil.memAddress(v));
    }

    public static native void nglColor4dv(long var0);

    public static void glColor4dv(@NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL11.nglColor4dv(MemoryUtil.memAddress(v));
    }

    public static native void nglColor4ubv(long var0);

    public static void glColor4ubv(@NativeType(value="GLubyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL11.nglColor4ubv(MemoryUtil.memAddress(v));
    }

    public static native void nglColor4usv(long var0);

    public static void glColor4usv(@NativeType(value="GLushort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL11.nglColor4usv(MemoryUtil.memAddress(v));
    }

    public static native void nglColor4uiv(long var0);

    public static void glColor4uiv(@NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL11.nglColor4uiv(MemoryUtil.memAddress(v));
    }

    public static void glColorMask(@NativeType(value="GLboolean") boolean red, @NativeType(value="GLboolean") boolean green, @NativeType(value="GLboolean") boolean blue, @NativeType(value="GLboolean") boolean alpha) {
        GL11C.glColorMask(red, green, blue, alpha);
    }

    public static native void glColorMaterial(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglColorPointer(int var0, int var1, int var2, long var3);

    public static void glColorPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        GL11.nglColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glColorPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        GL11.nglColorPointer(size, type, stride, pointer);
    }

    public static void glColorPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        GL11.nglColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glColorPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        GL11.nglColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glColorPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") FloatBuffer pointer) {
        GL11.nglColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static native void glCopyPixels(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLenum") int var4);

    public static void glCullFace(@NativeType(value="GLenum") int mode) {
        GL11C.glCullFace(mode);
    }

    public static native void glDeleteLists(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1);

    public static void glDepthFunc(@NativeType(value="GLenum") int func) {
        GL11C.glDepthFunc(func);
    }

    public static void glDepthMask(@NativeType(value="GLboolean") boolean flag) {
        GL11C.glDepthMask(flag);
    }

    public static void glDepthRange(@NativeType(value="GLdouble") double zNear, @NativeType(value="GLdouble") double zFar) {
        GL11C.glDepthRange(zNear, zFar);
    }

    public static native void glDisableClientState(@NativeType(value="GLenum") int var0);

    public static void glDrawArrays(@NativeType(value="GLenum") int mode, @NativeType(value="GLint") int first, @NativeType(value="GLsizei") int count) {
        GL11C.glDrawArrays(mode, first, count);
    }

    public static void glDrawBuffer(@NativeType(value="GLenum") int buf) {
        GL11C.glDrawBuffer(buf);
    }

    public static void nglDrawElements(int mode, int count, int type, long indices) {
        GL11C.nglDrawElements(mode, count, type, indices);
    }

    public static void glDrawElements(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei") int count, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indices) {
        GL11C.glDrawElements(mode, count, type, indices);
    }

    public static void glDrawElements(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indices) {
        GL11C.glDrawElements(mode, type, indices);
    }

    public static void glDrawElements(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indices) {
        GL11C.glDrawElements(mode, indices);
    }

    public static void glDrawElements(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ShortBuffer indices) {
        GL11C.glDrawElements(mode, indices);
    }

    public static void glDrawElements(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indices) {
        GL11C.glDrawElements(mode, indices);
    }

    public static native void nglDrawPixels(int var0, int var1, int var2, int var3, long var4);

    public static void glDrawPixels(@NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        GL11.nglDrawPixels(width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glDrawPixels(@NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        GL11.nglDrawPixels(width, height, format, type, pixels);
    }

    public static void glDrawPixels(@NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        GL11.nglDrawPixels(width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glDrawPixels(@NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        GL11.nglDrawPixels(width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glDrawPixels(@NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        GL11.nglDrawPixels(width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static native void glEdgeFlag(@NativeType(value="GLboolean") boolean var0);

    public static native void nglEdgeFlagv(long var0);

    public static void glEdgeFlagv(@NativeType(value="GLboolean const *") ByteBuffer flag) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)flag, 1);
        }
        GL11.nglEdgeFlagv(MemoryUtil.memAddress(flag));
    }

    public static native void nglEdgeFlagPointer(int var0, long var1);

    public static void glEdgeFlagPointer(@NativeType(value="GLsizei") int stride, @NativeType(value="GLboolean const *") ByteBuffer pointer) {
        GL11.nglEdgeFlagPointer(stride, MemoryUtil.memAddress(pointer));
    }

    public static void glEdgeFlagPointer(@NativeType(value="GLsizei") int stride, @NativeType(value="GLboolean const *") long pointer) {
        GL11.nglEdgeFlagPointer(stride, pointer);
    }

    public static native void glEnableClientState(@NativeType(value="GLenum") int var0);

    public static native void glEnd();

    public static native void glEvalCoord1f(@NativeType(value="GLfloat") float var0);

    public static native void nglEvalCoord1fv(long var0);

    public static void glEvalCoord1fv(@NativeType(value="GLfloat const *") FloatBuffer u) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)u, 1);
        }
        GL11.nglEvalCoord1fv(MemoryUtil.memAddress(u));
    }

    public static native void glEvalCoord1d(@NativeType(value="GLdouble") double var0);

    public static native void nglEvalCoord1dv(long var0);

    public static void glEvalCoord1dv(@NativeType(value="GLdouble const *") DoubleBuffer u) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)u, 1);
        }
        GL11.nglEvalCoord1dv(MemoryUtil.memAddress(u));
    }

    public static native void glEvalCoord2f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1);

    public static native void nglEvalCoord2fv(long var0);

    public static void glEvalCoord2fv(@NativeType(value="GLfloat const *") FloatBuffer u) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)u, 2);
        }
        GL11.nglEvalCoord2fv(MemoryUtil.memAddress(u));
    }

    public static native void glEvalCoord2d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2);

    public static native void nglEvalCoord2dv(long var0);

    public static void glEvalCoord2dv(@NativeType(value="GLdouble const *") DoubleBuffer u) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)u, 2);
        }
        GL11.nglEvalCoord2dv(MemoryUtil.memAddress(u));
    }

    public static native void glEvalMesh1(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glEvalMesh2(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void glEvalPoint1(@NativeType(value="GLint") int var0);

    public static native void glEvalPoint2(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1);

    public static native void nglFeedbackBuffer(int var0, int var1, long var2);

    public static void glFeedbackBuffer(@NativeType(value="GLenum") int type, @NativeType(value="GLfloat *") FloatBuffer buffer) {
        GL11.nglFeedbackBuffer(buffer.remaining(), type, MemoryUtil.memAddress(buffer));
    }

    public static void glFinish() {
        GL11C.glFinish();
    }

    public static void glFlush() {
        GL11C.glFlush();
    }

    public static native void glFogi(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1);

    public static native void nglFogiv(int var0, long var1);

    public static void glFogiv(@NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL11.nglFogiv(pname, MemoryUtil.memAddress(params));
    }

    public static native void glFogf(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1);

    public static native void nglFogfv(int var0, long var1);

    public static void glFogfv(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL11.nglFogfv(pname, MemoryUtil.memAddress(params));
    }

    public static void glFrontFace(@NativeType(value="GLenum") int dir) {
        GL11C.glFrontFace(dir);
    }

    @NativeType(value="GLuint")
    public static native int glGenLists(@NativeType(value="GLsizei") int var0);

    public static void nglGenTextures(int n, long textures) {
        GL11C.nglGenTextures(n, textures);
    }

    public static void glGenTextures(@NativeType(value="GLuint *") IntBuffer textures) {
        GL11C.glGenTextures(textures);
    }

    @NativeType(value="void")
    public static int glGenTextures() {
        return GL11C.glGenTextures();
    }

    public static void nglDeleteTextures(int n, long textures) {
        GL11C.nglDeleteTextures(n, textures);
    }

    public static void glDeleteTextures(@NativeType(value="GLuint const *") IntBuffer textures) {
        GL11C.glDeleteTextures(textures);
    }

    public static void glDeleteTextures(@NativeType(value="GLuint const *") int texture) {
        GL11C.glDeleteTextures(texture);
    }

    public static native void nglGetClipPlane(int var0, long var1);

    public static void glGetClipPlane(@NativeType(value="GLenum") int plane, @NativeType(value="GLdouble *") DoubleBuffer equation) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)equation, 4);
        }
        GL11.nglGetClipPlane(plane, MemoryUtil.memAddress(equation));
    }

    public static void nglGetBooleanv(int pname, long params) {
        GL11C.nglGetBooleanv(pname, params);
    }

    public static void glGetBooleanv(@NativeType(value="GLenum") int pname, @NativeType(value="GLboolean *") ByteBuffer params) {
        GL11C.glGetBooleanv(pname, params);
    }

    @NativeType(value="void")
    public static boolean glGetBoolean(@NativeType(value="GLenum") int pname) {
        return GL11C.glGetBoolean(pname);
    }

    public static void nglGetFloatv(int pname, long params) {
        GL11C.nglGetFloatv(pname, params);
    }

    public static void glGetFloatv(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        GL11C.glGetFloatv(pname, params);
    }

    @NativeType(value="void")
    public static float glGetFloat(@NativeType(value="GLenum") int pname) {
        return GL11C.glGetFloat(pname);
    }

    public static void nglGetIntegerv(int pname, long params) {
        GL11C.nglGetIntegerv(pname, params);
    }

    public static void glGetIntegerv(@NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL11C.glGetIntegerv(pname, params);
    }

    @NativeType(value="void")
    public static int glGetInteger(@NativeType(value="GLenum") int pname) {
        return GL11C.glGetInteger(pname);
    }

    public static void nglGetDoublev(int pname, long params) {
        GL11C.nglGetDoublev(pname, params);
    }

    public static void glGetDoublev(@NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") DoubleBuffer params) {
        GL11C.glGetDoublev(pname, params);
    }

    @NativeType(value="void")
    public static double glGetDouble(@NativeType(value="GLenum") int pname) {
        return GL11C.glGetDouble(pname);
    }

    @NativeType(value="GLenum")
    public static int glGetError() {
        return GL11C.glGetError();
    }

    public static native void nglGetLightiv(int var0, int var1, long var2);

    public static void glGetLightiv(@NativeType(value="GLenum") int light, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 4);
        }
        GL11.nglGetLightiv(light, pname, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetLighti(@NativeType(value="GLenum") int light, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer data = stack.callocInt(1);
            GL11.nglGetLightiv(light, pname, MemoryUtil.memAddress(data));
            int n = data.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetLightfv(int var0, int var1, long var2);

    public static void glGetLightfv(@NativeType(value="GLenum") int light, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 4);
        }
        GL11.nglGetLightfv(light, pname, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetLightf(@NativeType(value="GLenum") int light, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer data = stack.callocFloat(1);
            GL11.nglGetLightfv(light, pname, MemoryUtil.memAddress(data));
            float f = data.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetMapiv(int var0, int var1, long var2);

    public static void glGetMapiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLint *") IntBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 4);
        }
        GL11.nglGetMapiv(target, query, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMapi(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer data = stack.callocInt(1);
            GL11.nglGetMapiv(target, query, MemoryUtil.memAddress(data));
            int n = data.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetMapfv(int var0, int var1, long var2);

    public static void glGetMapfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLfloat *") FloatBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 4);
        }
        GL11.nglGetMapfv(target, query, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetMapf(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer data = stack.callocFloat(1);
            GL11.nglGetMapfv(target, query, MemoryUtil.memAddress(data));
            float f = data.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetMapdv(int var0, int var1, long var2);

    public static void glGetMapdv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLdouble *") DoubleBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 4);
        }
        GL11.nglGetMapdv(target, query, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetMapd(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            DoubleBuffer data = stack.callocDouble(1);
            GL11.nglGetMapdv(target, query, MemoryUtil.memAddress(data));
            double d = data.get(0);
            return d;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetMaterialiv(int var0, int var1, long var2);

    public static void glGetMaterialiv(@NativeType(value="GLenum") int face, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 1);
        }
        GL11.nglGetMaterialiv(face, pname, MemoryUtil.memAddress(data));
    }

    public static native void nglGetMaterialfv(int var0, int var1, long var2);

    public static void glGetMaterialfv(@NativeType(value="GLenum") int face, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 1);
        }
        GL11.nglGetMaterialfv(face, pname, MemoryUtil.memAddress(data));
    }

    public static native void nglGetPixelMapfv(int var0, long var1);

    public static void glGetPixelMapfv(@NativeType(value="GLenum") int map, @NativeType(value="GLfloat *") FloatBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 32);
        }
        GL11.nglGetPixelMapfv(map, MemoryUtil.memAddress(data));
    }

    public static void glGetPixelMapfv(@NativeType(value="GLenum") int map, @NativeType(value="GLfloat *") long data) {
        GL11.nglGetPixelMapfv(map, data);
    }

    public static native void nglGetPixelMapusv(int var0, long var1);

    public static void glGetPixelMapusv(@NativeType(value="GLenum") int map, @NativeType(value="GLushort *") ShortBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 32);
        }
        GL11.nglGetPixelMapusv(map, MemoryUtil.memAddress(data));
    }

    public static void glGetPixelMapusv(@NativeType(value="GLenum") int map, @NativeType(value="GLushort *") long data) {
        GL11.nglGetPixelMapusv(map, data);
    }

    public static native void nglGetPixelMapuiv(int var0, long var1);

    public static void glGetPixelMapuiv(@NativeType(value="GLenum") int map, @NativeType(value="GLuint *") IntBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 32);
        }
        GL11.nglGetPixelMapuiv(map, MemoryUtil.memAddress(data));
    }

    public static void glGetPixelMapuiv(@NativeType(value="GLenum") int map, @NativeType(value="GLuint *") long data) {
        GL11.nglGetPixelMapuiv(map, data);
    }

    public static void nglGetPointerv(int pname, long params) {
        GL11C.nglGetPointerv(pname, params);
    }

    public static void glGetPointerv(@NativeType(value="GLenum") int pname, @NativeType(value="void **") PointerBuffer params) {
        GL11C.glGetPointerv(pname, params);
    }

    @NativeType(value="void")
    public static long glGetPointer(@NativeType(value="GLenum") int pname) {
        return GL11C.glGetPointer(pname);
    }

    public static native void nglGetPolygonStipple(long var0);

    public static void glGetPolygonStipple(@NativeType(value="void *") ByteBuffer pattern) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)pattern, 128);
        }
        GL11.nglGetPolygonStipple(MemoryUtil.memAddress(pattern));
    }

    public static void glGetPolygonStipple(@NativeType(value="void *") long pattern) {
        GL11.nglGetPolygonStipple(pattern);
    }

    public static long nglGetString(int name) {
        return GL11C.nglGetString(name);
    }

    @Nullable
    @NativeType(value="GLubyte const *")
    public static String glGetString(@NativeType(value="GLenum") int name) {
        return GL11C.glGetString(name);
    }

    public static native void nglGetTexEnviv(int var0, int var1, long var2);

    public static void glGetTexEnviv(@NativeType(value="GLenum") int env, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 1);
        }
        GL11.nglGetTexEnviv(env, pname, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTexEnvi(@NativeType(value="GLenum") int env, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer data = stack.callocInt(1);
            GL11.nglGetTexEnviv(env, pname, MemoryUtil.memAddress(data));
            int n = data.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTexEnvfv(int var0, int var1, long var2);

    public static void glGetTexEnvfv(@NativeType(value="GLenum") int env, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 1);
        }
        GL11.nglGetTexEnvfv(env, pname, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetTexEnvf(@NativeType(value="GLenum") int env, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer data = stack.callocFloat(1);
            GL11.nglGetTexEnvfv(env, pname, MemoryUtil.memAddress(data));
            float f = data.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTexGeniv(int var0, int var1, long var2);

    public static void glGetTexGeniv(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 1);
        }
        GL11.nglGetTexGeniv(coord, pname, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTexGeni(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer data = stack.callocInt(1);
            GL11.nglGetTexGeniv(coord, pname, MemoryUtil.memAddress(data));
            int n = data.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTexGenfv(int var0, int var1, long var2);

    public static void glGetTexGenfv(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 4);
        }
        GL11.nglGetTexGenfv(coord, pname, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetTexGenf(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer data = stack.callocFloat(1);
            GL11.nglGetTexGenfv(coord, pname, MemoryUtil.memAddress(data));
            float f = data.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTexGendv(int var0, int var1, long var2);

    public static void glGetTexGendv(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") DoubleBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 4);
        }
        GL11.nglGetTexGendv(coord, pname, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetTexGend(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            DoubleBuffer data = stack.callocDouble(1);
            GL11.nglGetTexGendv(coord, pname, MemoryUtil.memAddress(data));
            double d = data.get(0);
            return d;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nglGetTexImage(int tex, int level, int format, int type, long pixels) {
        GL11C.nglGetTexImage(tex, level, format, type, pixels);
    }

    public static void glGetTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer pixels) {
        GL11C.glGetTexImage(tex, level, format, type, pixels);
    }

    public static void glGetTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") long pixels) {
        GL11C.glGetTexImage(tex, level, format, type, pixels);
    }

    public static void glGetTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer pixels) {
        GL11C.glGetTexImage(tex, level, format, type, pixels);
    }

    public static void glGetTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer pixels) {
        GL11C.glGetTexImage(tex, level, format, type, pixels);
    }

    public static void glGetTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer pixels) {
        GL11C.glGetTexImage(tex, level, format, type, pixels);
    }

    public static void glGetTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") DoubleBuffer pixels) {
        GL11C.glGetTexImage(tex, level, format, type, pixels);
    }

    public static void nglGetTexLevelParameteriv(int target, int level, int pname, long params) {
        GL11C.nglGetTexLevelParameteriv(target, level, pname, params);
    }

    public static void glGetTexLevelParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL11C.glGetTexLevelParameteriv(target, level, pname, params);
    }

    @NativeType(value="void")
    public static int glGetTexLevelParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname) {
        return GL11C.glGetTexLevelParameteri(target, level, pname);
    }

    public static void nglGetTexLevelParameterfv(int target, int level, int pname, long params) {
        GL11C.nglGetTexLevelParameterfv(target, level, pname, params);
    }

    public static void glGetTexLevelParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        GL11C.glGetTexLevelParameterfv(target, level, pname, params);
    }

    @NativeType(value="void")
    public static float glGetTexLevelParameterf(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname) {
        return GL11C.glGetTexLevelParameterf(target, level, pname);
    }

    public static void nglGetTexParameteriv(int target, int pname, long params) {
        GL11C.nglGetTexParameteriv(target, pname, params);
    }

    public static void glGetTexParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL11C.glGetTexParameteriv(target, pname, params);
    }

    @NativeType(value="void")
    public static int glGetTexParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        return GL11C.glGetTexParameteri(target, pname);
    }

    public static void nglGetTexParameterfv(int target, int pname, long params) {
        GL11C.nglGetTexParameterfv(target, pname, params);
    }

    public static void glGetTexParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        GL11C.glGetTexParameterfv(target, pname, params);
    }

    @NativeType(value="void")
    public static float glGetTexParameterf(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        return GL11C.glGetTexParameterf(target, pname);
    }

    public static void glHint(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int hint) {
        GL11C.glHint(target, hint);
    }

    public static native void glIndexi(@NativeType(value="GLint") int var0);

    public static native void glIndexub(@NativeType(value="GLubyte") byte var0);

    public static native void glIndexs(@NativeType(value="GLshort") short var0);

    public static native void glIndexf(@NativeType(value="GLfloat") float var0);

    public static native void glIndexd(@NativeType(value="GLdouble") double var0);

    public static native void nglIndexiv(long var0);

    public static void glIndexiv(@NativeType(value="GLint const *") IntBuffer index) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)index, 1);
        }
        GL11.nglIndexiv(MemoryUtil.memAddress(index));
    }

    public static native void nglIndexubv(long var0);

    public static void glIndexubv(@NativeType(value="GLubyte const *") ByteBuffer index) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)index, 1);
        }
        GL11.nglIndexubv(MemoryUtil.memAddress(index));
    }

    public static native void nglIndexsv(long var0);

    public static void glIndexsv(@NativeType(value="GLshort const *") ShortBuffer index) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)index, 1);
        }
        GL11.nglIndexsv(MemoryUtil.memAddress(index));
    }

    public static native void nglIndexfv(long var0);

    public static void glIndexfv(@NativeType(value="GLfloat const *") FloatBuffer index) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)index, 1);
        }
        GL11.nglIndexfv(MemoryUtil.memAddress(index));
    }

    public static native void nglIndexdv(long var0);

    public static void glIndexdv(@NativeType(value="GLdouble const *") DoubleBuffer index) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)index, 1);
        }
        GL11.nglIndexdv(MemoryUtil.memAddress(index));
    }

    public static native void glIndexMask(@NativeType(value="GLuint") int var0);

    public static native void nglIndexPointer(int var0, int var1, long var2);

    public static void glIndexPointer(@NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        GL11.nglIndexPointer(type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glIndexPointer(@NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        GL11.nglIndexPointer(type, stride, pointer);
    }

    public static void glIndexPointer(@NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        GL11.nglIndexPointer(5121, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glIndexPointer(@NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        GL11.nglIndexPointer(5122, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glIndexPointer(@NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        GL11.nglIndexPointer(5124, stride, MemoryUtil.memAddress(pointer));
    }

    public static native void glInitNames();

    public static native void nglInterleavedArrays(int var0, int var1, long var2);

    public static void glInterleavedArrays(@NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        GL11.nglInterleavedArrays(format, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glInterleavedArrays(@NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        GL11.nglInterleavedArrays(format, stride, pointer);
    }

    public static void glInterleavedArrays(@NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        GL11.nglInterleavedArrays(format, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glInterleavedArrays(@NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        GL11.nglInterleavedArrays(format, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glInterleavedArrays(@NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") FloatBuffer pointer) {
        GL11.nglInterleavedArrays(format, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glInterleavedArrays(@NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") DoubleBuffer pointer) {
        GL11.nglInterleavedArrays(format, stride, MemoryUtil.memAddress(pointer));
    }

    @NativeType(value="GLboolean")
    public static boolean glIsEnabled(@NativeType(value="GLenum") int cap) {
        return GL11C.glIsEnabled(cap);
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsList(@NativeType(value="GLuint") int var0);

    @NativeType(value="GLboolean")
    public static boolean glIsTexture(@NativeType(value="GLuint") int texture) {
        return GL11C.glIsTexture(texture);
    }

    public static native void glLightModeli(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1);

    public static native void glLightModelf(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1);

    public static native void nglLightModeliv(int var0, long var1);

    public static void glLightModeliv(@NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL11.nglLightModeliv(pname, MemoryUtil.memAddress(params));
    }

    public static native void nglLightModelfv(int var0, long var1);

    public static void glLightModelfv(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL11.nglLightModelfv(pname, MemoryUtil.memAddress(params));
    }

    public static native void glLighti(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void glLightf(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLfloat") float var2);

    public static native void nglLightiv(int var0, int var1, long var2);

    public static void glLightiv(@NativeType(value="GLenum") int light, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL11.nglLightiv(light, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglLightfv(int var0, int var1, long var2);

    public static void glLightfv(@NativeType(value="GLenum") int light, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL11.nglLightfv(light, pname, MemoryUtil.memAddress(params));
    }

    public static native void glLineStipple(@NativeType(value="GLint") int var0, @NativeType(value="GLushort") short var1);

    public static void glLineWidth(@NativeType(value="GLfloat") float width) {
        GL11C.glLineWidth(width);
    }

    public static native void glListBase(@NativeType(value="GLuint") int var0);

    public static native void nglLoadMatrixf(long var0);

    public static void glLoadMatrixf(@NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        GL11.nglLoadMatrixf(MemoryUtil.memAddress(m));
    }

    public static native void nglLoadMatrixd(long var0);

    public static void glLoadMatrixd(@NativeType(value="GLdouble const *") DoubleBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        GL11.nglLoadMatrixd(MemoryUtil.memAddress(m));
    }

    public static native void glLoadIdentity();

    public static native void glLoadName(@NativeType(value="GLuint") int var0);

    public static void glLogicOp(@NativeType(value="GLenum") int op) {
        GL11C.glLogicOp(op);
    }

    public static native void nglMap1f(int var0, float var1, float var2, int var3, int var4, long var5);

    public static void glMap1f(@NativeType(value="GLenum") int target, @NativeType(value="GLfloat") float u1, @NativeType(value="GLfloat") float u2, @NativeType(value="GLint") int stride, @NativeType(value="GLint") int order, @NativeType(value="GLfloat const *") FloatBuffer points) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)points, order * stride);
        }
        GL11.nglMap1f(target, u1, u2, stride, order, MemoryUtil.memAddress(points));
    }

    public static native void nglMap1d(int var0, double var1, double var3, int var5, int var6, long var7);

    public static void glMap1d(@NativeType(value="GLenum") int target, @NativeType(value="GLdouble") double u1, @NativeType(value="GLdouble") double u2, @NativeType(value="GLint") int stride, @NativeType(value="GLint") int order, @NativeType(value="GLdouble const *") DoubleBuffer points) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)points, stride * order);
        }
        GL11.nglMap1d(target, u1, u2, stride, order, MemoryUtil.memAddress(points));
    }

    public static native void nglMap2f(int var0, float var1, float var2, int var3, int var4, float var5, float var6, int var7, int var8, long var9);

    public static void glMap2f(@NativeType(value="GLenum") int target, @NativeType(value="GLfloat") float u1, @NativeType(value="GLfloat") float u2, @NativeType(value="GLint") int ustride, @NativeType(value="GLint") int uorder, @NativeType(value="GLfloat") float v1, @NativeType(value="GLfloat") float v2, @NativeType(value="GLint") int vstride, @NativeType(value="GLint") int vorder, @NativeType(value="GLfloat const *") FloatBuffer points) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)points, ustride * uorder * vstride * vorder);
        }
        GL11.nglMap2f(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, MemoryUtil.memAddress(points));
    }

    public static native void nglMap2d(int var0, double var1, double var3, int var5, int var6, double var7, double var9, int var11, int var12, long var13);

    public static void glMap2d(@NativeType(value="GLenum") int target, @NativeType(value="GLdouble") double u1, @NativeType(value="GLdouble") double u2, @NativeType(value="GLint") int ustride, @NativeType(value="GLint") int uorder, @NativeType(value="GLdouble") double v1, @NativeType(value="GLdouble") double v2, @NativeType(value="GLint") int vstride, @NativeType(value="GLint") int vorder, @NativeType(value="GLdouble const *") DoubleBuffer points) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)points, ustride * uorder * vstride * vorder);
        }
        GL11.nglMap2d(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, MemoryUtil.memAddress(points));
    }

    public static native void glMapGrid1f(@NativeType(value="GLint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glMapGrid1d(@NativeType(value="GLint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3);

    public static native void glMapGrid2f(@NativeType(value="GLint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLint") int var3, @NativeType(value="GLfloat") float var4, @NativeType(value="GLfloat") float var5);

    public static native void glMapGrid2d(@NativeType(value="GLint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLint") int var5, @NativeType(value="GLdouble") double var6, @NativeType(value="GLdouble") double var8);

    public static native void glMateriali(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void glMaterialf(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLfloat") float var2);

    public static native void nglMaterialiv(int var0, int var1, long var2);

    public static void glMaterialiv(@NativeType(value="GLenum") int face, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL11.nglMaterialiv(face, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglMaterialfv(int var0, int var1, long var2);

    public static void glMaterialfv(@NativeType(value="GLenum") int face, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL11.nglMaterialfv(face, pname, MemoryUtil.memAddress(params));
    }

    public static native void glMatrixMode(@NativeType(value="GLenum") int var0);

    public static native void nglMultMatrixf(long var0);

    public static void glMultMatrixf(@NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        GL11.nglMultMatrixf(MemoryUtil.memAddress(m));
    }

    public static native void nglMultMatrixd(long var0);

    public static void glMultMatrixd(@NativeType(value="GLdouble const *") DoubleBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        GL11.nglMultMatrixd(MemoryUtil.memAddress(m));
    }

    public static native void glFrustum(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6, @NativeType(value="GLdouble") double var8, @NativeType(value="GLdouble") double var10);

    public static native void glNewList(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glEndList();

    public static native void glNormal3f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glNormal3b(@NativeType(value="GLbyte") byte var0, @NativeType(value="GLbyte") byte var1, @NativeType(value="GLbyte") byte var2);

    public static native void glNormal3s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2);

    public static native void glNormal3i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glNormal3d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4);

    public static native void nglNormal3fv(long var0);

    public static void glNormal3fv(@NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglNormal3fv(MemoryUtil.memAddress(v));
    }

    public static native void nglNormal3bv(long var0);

    public static void glNormal3bv(@NativeType(value="GLbyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglNormal3bv(MemoryUtil.memAddress(v));
    }

    public static native void nglNormal3sv(long var0);

    public static void glNormal3sv(@NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglNormal3sv(MemoryUtil.memAddress(v));
    }

    public static native void nglNormal3iv(long var0);

    public static void glNormal3iv(@NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglNormal3iv(MemoryUtil.memAddress(v));
    }

    public static native void nglNormal3dv(long var0);

    public static void glNormal3dv(@NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglNormal3dv(MemoryUtil.memAddress(v));
    }

    public static native void nglNormalPointer(int var0, int var1, long var2);

    public static void glNormalPointer(@NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        GL11.nglNormalPointer(type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glNormalPointer(@NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        GL11.nglNormalPointer(type, stride, pointer);
    }

    public static void glNormalPointer(@NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        GL11.nglNormalPointer(type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glNormalPointer(@NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        GL11.nglNormalPointer(type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glNormalPointer(@NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") FloatBuffer pointer) {
        GL11.nglNormalPointer(type, stride, MemoryUtil.memAddress(pointer));
    }

    public static native void glOrtho(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6, @NativeType(value="GLdouble") double var8, @NativeType(value="GLdouble") double var10);

    public static native void glPassThrough(@NativeType(value="GLfloat") float var0);

    public static native void nglPixelMapfv(int var0, int var1, long var2);

    public static void glPixelMapfv(@NativeType(value="GLenum") int map, @NativeType(value="GLsizei") int size, @NativeType(value="GLfloat const *") long values) {
        GL11.nglPixelMapfv(map, size, values);
    }

    public static void glPixelMapfv(@NativeType(value="GLenum") int map, @NativeType(value="GLfloat const *") FloatBuffer values) {
        GL11.nglPixelMapfv(map, values.remaining(), MemoryUtil.memAddress(values));
    }

    public static native void nglPixelMapusv(int var0, int var1, long var2);

    public static void glPixelMapusv(@NativeType(value="GLenum") int map, @NativeType(value="GLsizei") int size, @NativeType(value="GLushort const *") long values) {
        GL11.nglPixelMapusv(map, size, values);
    }

    public static void glPixelMapusv(@NativeType(value="GLenum") int map, @NativeType(value="GLushort const *") ShortBuffer values) {
        GL11.nglPixelMapusv(map, values.remaining(), MemoryUtil.memAddress(values));
    }

    public static native void nglPixelMapuiv(int var0, int var1, long var2);

    public static void glPixelMapuiv(@NativeType(value="GLenum") int map, @NativeType(value="GLsizei") int size, @NativeType(value="GLuint const *") long values) {
        GL11.nglPixelMapuiv(map, size, values);
    }

    public static void glPixelMapuiv(@NativeType(value="GLenum") int map, @NativeType(value="GLuint const *") IntBuffer values) {
        GL11.nglPixelMapuiv(map, values.remaining(), MemoryUtil.memAddress(values));
    }

    public static void glPixelStorei(@NativeType(value="GLenum") int pname, @NativeType(value="GLint") int param) {
        GL11C.glPixelStorei(pname, param);
    }

    public static void glPixelStoref(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat") float param) {
        GL11C.glPixelStoref(pname, param);
    }

    public static native void glPixelTransferi(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1);

    public static native void glPixelTransferf(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1);

    public static native void glPixelZoom(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1);

    public static void glPointSize(@NativeType(value="GLfloat") float size) {
        GL11C.glPointSize(size);
    }

    public static void glPolygonMode(@NativeType(value="GLenum") int face, @NativeType(value="GLenum") int mode) {
        GL11C.glPolygonMode(face, mode);
    }

    public static void glPolygonOffset(@NativeType(value="GLfloat") float factor, @NativeType(value="GLfloat") float units) {
        GL11C.glPolygonOffset(factor, units);
    }

    public static native void nglPolygonStipple(long var0);

    public static void glPolygonStipple(@NativeType(value="GLubyte const *") ByteBuffer pattern) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)pattern, 128);
        }
        GL11.nglPolygonStipple(MemoryUtil.memAddress(pattern));
    }

    public static void glPolygonStipple(@NativeType(value="GLubyte const *") long pattern) {
        GL11.nglPolygonStipple(pattern);
    }

    public static native void glPushAttrib(@NativeType(value="GLbitfield") int var0);

    public static native void glPushClientAttrib(@NativeType(value="GLbitfield") int var0);

    public static native void glPopAttrib();

    public static native void glPopClientAttrib();

    public static native void glPopMatrix();

    public static native void glPopName();

    public static native void nglPrioritizeTextures(int var0, long var1, long var3);

    public static void glPrioritizeTextures(@NativeType(value="GLuint const *") IntBuffer textures, @NativeType(value="GLfloat const *") FloatBuffer priorities) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)priorities, textures.remaining());
        }
        GL11.nglPrioritizeTextures(textures.remaining(), MemoryUtil.memAddress(textures), MemoryUtil.memAddress(priorities));
    }

    public static native void glPushMatrix();

    public static native void glPushName(@NativeType(value="GLuint") int var0);

    public static native void glRasterPos2i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1);

    public static native void glRasterPos2s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1);

    public static native void glRasterPos2f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1);

    public static native void glRasterPos2d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2);

    public static native void nglRasterPos2iv(long var0);

    public static void glRasterPos2iv(@NativeType(value="GLint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 2);
        }
        GL11.nglRasterPos2iv(MemoryUtil.memAddress(coords));
    }

    public static native void nglRasterPos2sv(long var0);

    public static void glRasterPos2sv(@NativeType(value="GLshort const *") ShortBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 2);
        }
        GL11.nglRasterPos2sv(MemoryUtil.memAddress(coords));
    }

    public static native void nglRasterPos2fv(long var0);

    public static void glRasterPos2fv(@NativeType(value="GLfloat const *") FloatBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 2);
        }
        GL11.nglRasterPos2fv(MemoryUtil.memAddress(coords));
    }

    public static native void nglRasterPos2dv(long var0);

    public static void glRasterPos2dv(@NativeType(value="GLdouble const *") DoubleBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 2);
        }
        GL11.nglRasterPos2dv(MemoryUtil.memAddress(coords));
    }

    public static native void glRasterPos3i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glRasterPos3s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2);

    public static native void glRasterPos3f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glRasterPos3d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4);

    public static native void nglRasterPos3iv(long var0);

    public static void glRasterPos3iv(@NativeType(value="GLint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 3);
        }
        GL11.nglRasterPos3iv(MemoryUtil.memAddress(coords));
    }

    public static native void nglRasterPos3sv(long var0);

    public static void glRasterPos3sv(@NativeType(value="GLshort const *") ShortBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 3);
        }
        GL11.nglRasterPos3sv(MemoryUtil.memAddress(coords));
    }

    public static native void nglRasterPos3fv(long var0);

    public static void glRasterPos3fv(@NativeType(value="GLfloat const *") FloatBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 3);
        }
        GL11.nglRasterPos3fv(MemoryUtil.memAddress(coords));
    }

    public static native void nglRasterPos3dv(long var0);

    public static void glRasterPos3dv(@NativeType(value="GLdouble const *") DoubleBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 3);
        }
        GL11.nglRasterPos3dv(MemoryUtil.memAddress(coords));
    }

    public static native void glRasterPos4i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glRasterPos4s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2, @NativeType(value="GLshort") short var3);

    public static native void glRasterPos4f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glRasterPos4d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6);

    public static native void nglRasterPos4iv(long var0);

    public static void glRasterPos4iv(@NativeType(value="GLint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 4);
        }
        GL11.nglRasterPos4iv(MemoryUtil.memAddress(coords));
    }

    public static native void nglRasterPos4sv(long var0);

    public static void glRasterPos4sv(@NativeType(value="GLshort const *") ShortBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 4);
        }
        GL11.nglRasterPos4sv(MemoryUtil.memAddress(coords));
    }

    public static native void nglRasterPos4fv(long var0);

    public static void glRasterPos4fv(@NativeType(value="GLfloat const *") FloatBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 4);
        }
        GL11.nglRasterPos4fv(MemoryUtil.memAddress(coords));
    }

    public static native void nglRasterPos4dv(long var0);

    public static void glRasterPos4dv(@NativeType(value="GLdouble const *") DoubleBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 4);
        }
        GL11.nglRasterPos4dv(MemoryUtil.memAddress(coords));
    }

    public static void glReadBuffer(@NativeType(value="GLenum") int src) {
        GL11C.glReadBuffer(src);
    }

    public static void nglReadPixels(int x, int y, int width, int height, int format, int type, long pixels) {
        GL11C.nglReadPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer pixels) {
        GL11C.glReadPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") long pixels) {
        GL11C.glReadPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer pixels) {
        GL11C.glReadPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer pixels) {
        GL11C.glReadPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer pixels) {
        GL11C.glReadPixels(x, y, width, height, format, type, pixels);
    }

    public static native void glRecti(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glRects(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2, @NativeType(value="GLshort") short var3);

    public static native void glRectf(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glRectd(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6);

    public static native void nglRectiv(long var0, long var2);

    public static void glRectiv(@NativeType(value="GLint const *") IntBuffer v1, @NativeType(value="GLint const *") IntBuffer v2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v1, 2);
            Checks.check((Buffer)v2, 2);
        }
        GL11.nglRectiv(MemoryUtil.memAddress(v1), MemoryUtil.memAddress(v2));
    }

    public static native void nglRectsv(long var0, long var2);

    public static void glRectsv(@NativeType(value="GLshort const *") ShortBuffer v1, @NativeType(value="GLshort const *") ShortBuffer v2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v1, 2);
            Checks.check((Buffer)v2, 2);
        }
        GL11.nglRectsv(MemoryUtil.memAddress(v1), MemoryUtil.memAddress(v2));
    }

    public static native void nglRectfv(long var0, long var2);

    public static void glRectfv(@NativeType(value="GLfloat const *") FloatBuffer v1, @NativeType(value="GLfloat const *") FloatBuffer v2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v1, 2);
            Checks.check((Buffer)v2, 2);
        }
        GL11.nglRectfv(MemoryUtil.memAddress(v1), MemoryUtil.memAddress(v2));
    }

    public static native void nglRectdv(long var0, long var2);

    public static void glRectdv(@NativeType(value="GLdouble const *") DoubleBuffer v1, @NativeType(value="GLdouble const *") DoubleBuffer v2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v1, 2);
            Checks.check((Buffer)v2, 2);
        }
        GL11.nglRectdv(MemoryUtil.memAddress(v1), MemoryUtil.memAddress(v2));
    }

    @NativeType(value="GLint")
    public static native int glRenderMode(@NativeType(value="GLenum") int var0);

    public static native void glRotatef(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glRotated(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6);

    public static native void glScalef(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glScaled(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4);

    public static void glScissor(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL11C.glScissor(x, y, width, height);
    }

    public static native void nglSelectBuffer(int var0, long var1);

    public static void glSelectBuffer(@NativeType(value="GLuint *") IntBuffer buffer) {
        GL11.nglSelectBuffer(buffer.remaining(), MemoryUtil.memAddress(buffer));
    }

    public static native void glShadeModel(@NativeType(value="GLenum") int var0);

    public static void glStencilFunc(@NativeType(value="GLenum") int func, @NativeType(value="GLint") int ref, @NativeType(value="GLuint") int mask) {
        GL11C.glStencilFunc(func, ref, mask);
    }

    public static void glStencilMask(@NativeType(value="GLuint") int mask) {
        GL11C.glStencilMask(mask);
    }

    public static void glStencilOp(@NativeType(value="GLenum") int sfail, @NativeType(value="GLenum") int dpfail, @NativeType(value="GLenum") int dppass) {
        GL11C.glStencilOp(sfail, dpfail, dppass);
    }

    public static native void glTexCoord1f(@NativeType(value="GLfloat") float var0);

    public static native void glTexCoord1s(@NativeType(value="GLshort") short var0);

    public static native void glTexCoord1i(@NativeType(value="GLint") int var0);

    public static native void glTexCoord1d(@NativeType(value="GLdouble") double var0);

    public static native void nglTexCoord1fv(long var0);

    public static void glTexCoord1fv(@NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        GL11.nglTexCoord1fv(MemoryUtil.memAddress(v));
    }

    public static native void nglTexCoord1sv(long var0);

    public static void glTexCoord1sv(@NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        GL11.nglTexCoord1sv(MemoryUtil.memAddress(v));
    }

    public static native void nglTexCoord1iv(long var0);

    public static void glTexCoord1iv(@NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        GL11.nglTexCoord1iv(MemoryUtil.memAddress(v));
    }

    public static native void nglTexCoord1dv(long var0);

    public static void glTexCoord1dv(@NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        GL11.nglTexCoord1dv(MemoryUtil.memAddress(v));
    }

    public static native void glTexCoord2f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1);

    public static native void glTexCoord2s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1);

    public static native void glTexCoord2i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1);

    public static native void glTexCoord2d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2);

    public static native void nglTexCoord2fv(long var0);

    public static void glTexCoord2fv(@NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        GL11.nglTexCoord2fv(MemoryUtil.memAddress(v));
    }

    public static native void nglTexCoord2sv(long var0);

    public static void glTexCoord2sv(@NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        GL11.nglTexCoord2sv(MemoryUtil.memAddress(v));
    }

    public static native void nglTexCoord2iv(long var0);

    public static void glTexCoord2iv(@NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        GL11.nglTexCoord2iv(MemoryUtil.memAddress(v));
    }

    public static native void nglTexCoord2dv(long var0);

    public static void glTexCoord2dv(@NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        GL11.nglTexCoord2dv(MemoryUtil.memAddress(v));
    }

    public static native void glTexCoord3f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glTexCoord3s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2);

    public static native void glTexCoord3i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glTexCoord3d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4);

    public static native void nglTexCoord3fv(long var0);

    public static void glTexCoord3fv(@NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglTexCoord3fv(MemoryUtil.memAddress(v));
    }

    public static native void nglTexCoord3sv(long var0);

    public static void glTexCoord3sv(@NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglTexCoord3sv(MemoryUtil.memAddress(v));
    }

    public static native void nglTexCoord3iv(long var0);

    public static void glTexCoord3iv(@NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglTexCoord3iv(MemoryUtil.memAddress(v));
    }

    public static native void nglTexCoord3dv(long var0);

    public static void glTexCoord3dv(@NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL11.nglTexCoord3dv(MemoryUtil.memAddress(v));
    }

    public static native void glTexCoord4f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glTexCoord4s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2, @NativeType(value="GLshort") short var3);

    public static native void glTexCoord4i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glTexCoord4d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6);

    public static native void nglTexCoord4fv(long var0);

    public static void glTexCoord4fv(@NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL11.nglTexCoord4fv(MemoryUtil.memAddress(v));
    }

    public static native void nglTexCoord4sv(long var0);

    public static void glTexCoord4sv(@NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL11.nglTexCoord4sv(MemoryUtil.memAddress(v));
    }

    public static native void nglTexCoord4iv(long var0);

    public static void glTexCoord4iv(@NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL11.nglTexCoord4iv(MemoryUtil.memAddress(v));
    }

    public static native void nglTexCoord4dv(long var0);

    public static void glTexCoord4dv(@NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL11.nglTexCoord4dv(MemoryUtil.memAddress(v));
    }

    public static native void nglTexCoordPointer(int var0, int var1, int var2, long var3);

    public static void glTexCoordPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        GL11.nglTexCoordPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glTexCoordPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        GL11.nglTexCoordPointer(size, type, stride, pointer);
    }

    public static void glTexCoordPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        GL11.nglTexCoordPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glTexCoordPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        GL11.nglTexCoordPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glTexCoordPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") FloatBuffer pointer) {
        GL11.nglTexCoordPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static native void glTexEnvi(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void nglTexEnviv(int var0, int var1, long var2);

    public static void glTexEnviv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL11.nglTexEnviv(target, pname, MemoryUtil.memAddress(params));
    }

    public static native void glTexEnvf(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLfloat") float var2);

    public static native void nglTexEnvfv(int var0, int var1, long var2);

    public static void glTexEnvfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL11.nglTexEnvfv(target, pname, MemoryUtil.memAddress(params));
    }

    public static native void glTexGeni(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void nglTexGeniv(int var0, int var1, long var2);

    public static void glTexGeniv(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL11.nglTexGeniv(coord, pname, MemoryUtil.memAddress(params));
    }

    public static native void glTexGenf(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLfloat") float var2);

    public static native void nglTexGenfv(int var0, int var1, long var2);

    public static void glTexGenfv(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL11.nglTexGenfv(coord, pname, MemoryUtil.memAddress(params));
    }

    public static native void glTexGend(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLdouble") double var2);

    public static native void nglTexGendv(int var0, int var1, long var2);

    public static void glTexGendv(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble const *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL11.nglTexGendv(coord, pname, MemoryUtil.memAddress(params));
    }

    public static void nglTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, long pixels) {
        GL11C.nglTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer pixels) {
        GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") long pixels) {
        GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer pixels) {
        GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer pixels) {
        GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer pixels) {
        GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") DoubleBuffer pixels) {
        GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void nglTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, long pixels) {
        GL11C.nglTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer pixels) {
        GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") long pixels) {
        GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer pixels) {
        GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer pixels) {
        GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer pixels) {
        GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") DoubleBuffer pixels) {
        GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glCopyTexImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalFormat, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border) {
        GL11C.glCopyTexImage1D(target, level, internalFormat, x, y, width, border);
    }

    public static void glCopyTexImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalFormat, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border) {
        GL11C.glCopyTexImage2D(target, level, internalFormat, x, y, width, height, border);
    }

    public static void glCopyTexSubImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width) {
        GL11C.glCopyTexSubImage1D(target, level, xoffset, x, y, width);
    }

    public static void glCopyTexSubImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL11C.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
    }

    public static void glTexParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint") int param) {
        GL11C.glTexParameteri(target, pname, param);
    }

    public static void nglTexParameteriv(int target, int pname, long params) {
        GL11C.nglTexParameteriv(target, pname, params);
    }

    public static void glTexParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        GL11C.glTexParameteriv(target, pname, params);
    }

    public static void glTexParameterf(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat") float param) {
        GL11C.glTexParameterf(target, pname, param);
    }

    public static void nglTexParameterfv(int target, int pname, long params) {
        GL11C.nglTexParameterfv(target, pname, params);
    }

    public static void glTexParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        GL11C.glTexParameterfv(target, pname, params);
    }

    public static void nglTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, long pixels) {
        GL11C.nglTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") DoubleBuffer pixels) {
        GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void nglTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, long pixels) {
        GL11C.nglTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") DoubleBuffer pixels) {
        GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static native void glTranslatef(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glTranslated(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4);

    public static native void glVertex2f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1);

    public static native void glVertex2s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1);

    public static native void glVertex2i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1);

    public static native void glVertex2d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2);

    public static native void nglVertex2fv(long var0);

    public static void glVertex2fv(@NativeType(value="GLfloat const *") FloatBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 2);
        }
        GL11.nglVertex2fv(MemoryUtil.memAddress(coords));
    }

    public static native void nglVertex2sv(long var0);

    public static void glVertex2sv(@NativeType(value="GLshort const *") ShortBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 2);
        }
        GL11.nglVertex2sv(MemoryUtil.memAddress(coords));
    }

    public static native void nglVertex2iv(long var0);

    public static void glVertex2iv(@NativeType(value="GLint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 2);
        }
        GL11.nglVertex2iv(MemoryUtil.memAddress(coords));
    }

    public static native void nglVertex2dv(long var0);

    public static void glVertex2dv(@NativeType(value="GLdouble const *") DoubleBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 2);
        }
        GL11.nglVertex2dv(MemoryUtil.memAddress(coords));
    }

    public static native void glVertex3f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glVertex3s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2);

    public static native void glVertex3i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glVertex3d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4);

    public static native void nglVertex3fv(long var0);

    public static void glVertex3fv(@NativeType(value="GLfloat const *") FloatBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 3);
        }
        GL11.nglVertex3fv(MemoryUtil.memAddress(coords));
    }

    public static native void nglVertex3sv(long var0);

    public static void glVertex3sv(@NativeType(value="GLshort const *") ShortBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 3);
        }
        GL11.nglVertex3sv(MemoryUtil.memAddress(coords));
    }

    public static native void nglVertex3iv(long var0);

    public static void glVertex3iv(@NativeType(value="GLint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 3);
        }
        GL11.nglVertex3iv(MemoryUtil.memAddress(coords));
    }

    public static native void nglVertex3dv(long var0);

    public static void glVertex3dv(@NativeType(value="GLdouble const *") DoubleBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 3);
        }
        GL11.nglVertex3dv(MemoryUtil.memAddress(coords));
    }

    public static native void glVertex4f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glVertex4s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2, @NativeType(value="GLshort") short var3);

    public static native void glVertex4i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glVertex4d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6);

    public static native void nglVertex4fv(long var0);

    public static void glVertex4fv(@NativeType(value="GLfloat const *") FloatBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 4);
        }
        GL11.nglVertex4fv(MemoryUtil.memAddress(coords));
    }

    public static native void nglVertex4sv(long var0);

    public static void glVertex4sv(@NativeType(value="GLshort const *") ShortBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 4);
        }
        GL11.nglVertex4sv(MemoryUtil.memAddress(coords));
    }

    public static native void nglVertex4iv(long var0);

    public static void glVertex4iv(@NativeType(value="GLint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 4);
        }
        GL11.nglVertex4iv(MemoryUtil.memAddress(coords));
    }

    public static native void nglVertex4dv(long var0);

    public static void glVertex4dv(@NativeType(value="GLdouble const *") DoubleBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 4);
        }
        GL11.nglVertex4dv(MemoryUtil.memAddress(coords));
    }

    public static native void nglVertexPointer(int var0, int var1, int var2, long var3);

    public static void glVertexPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        GL11.nglVertexPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        GL11.nglVertexPointer(size, type, stride, pointer);
    }

    public static void glVertexPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        GL11.nglVertexPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        GL11.nglVertexPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") FloatBuffer pointer) {
        GL11.nglVertexPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glViewport(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int w, @NativeType(value="GLsizei") int h) {
        GL11C.glViewport(x, y, w, h);
    }

    @NativeType(value="GLboolean")
    public static boolean glAreTexturesResident(@NativeType(value="GLuint const *") int[] textures, @NativeType(value="GLboolean *") ByteBuffer residences) {
        long __functionAddress = GL.getICD().glAreTexturesResident;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check((Buffer)residences, textures.length);
        }
        return JNI.callPPZ(textures.length, textures, MemoryUtil.memAddress(residences), __functionAddress);
    }

    public static void glClipPlane(@NativeType(value="GLenum") int plane, @NativeType(value="GLdouble const *") double[] equation) {
        long __functionAddress = GL.getICD().glClipPlane;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(equation, 4);
        }
        JNI.callPV(plane, equation, __functionAddress);
    }

    public static void glColor3sv(@NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glColor3sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glColor3iv(@NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glColor3iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glColor3fv(@NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glColor3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glColor3dv(@NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glColor3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glColor3usv(@NativeType(value="GLushort const *") short[] v) {
        long __functionAddress = GL.getICD().glColor3usv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glColor3uiv(@NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glColor3uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glColor4sv(@NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glColor4sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glColor4iv(@NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glColor4iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glColor4fv(@NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glColor4fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glColor4dv(@NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glColor4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glColor4usv(@NativeType(value="GLushort const *") short[] v) {
        long __functionAddress = GL.getICD().glColor4usv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glColor4uiv(@NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glColor4uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glDrawPixels(@NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glDrawPixels;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(width, height, format, type, pixels, __functionAddress);
    }

    public static void glDrawPixels(@NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glDrawPixels;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(width, height, format, type, pixels, __functionAddress);
    }

    public static void glDrawPixels(@NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glDrawPixels;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(width, height, format, type, pixels, __functionAddress);
    }

    public static void glEvalCoord1fv(@NativeType(value="GLfloat const *") float[] u) {
        long __functionAddress = GL.getICD().glEvalCoord1fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(u, 1);
        }
        JNI.callPV(u, __functionAddress);
    }

    public static void glEvalCoord1dv(@NativeType(value="GLdouble const *") double[] u) {
        long __functionAddress = GL.getICD().glEvalCoord1dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(u, 1);
        }
        JNI.callPV(u, __functionAddress);
    }

    public static void glEvalCoord2fv(@NativeType(value="GLfloat const *") float[] u) {
        long __functionAddress = GL.getICD().glEvalCoord2fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(u, 2);
        }
        JNI.callPV(u, __functionAddress);
    }

    public static void glEvalCoord2dv(@NativeType(value="GLdouble const *") double[] u) {
        long __functionAddress = GL.getICD().glEvalCoord2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(u, 2);
        }
        JNI.callPV(u, __functionAddress);
    }

    public static void glFeedbackBuffer(@NativeType(value="GLenum") int type, @NativeType(value="GLfloat *") float[] buffer) {
        long __functionAddress = GL.getICD().glFeedbackBuffer;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(buffer.length, type, buffer, __functionAddress);
    }

    public static void glFogiv(@NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glFogiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(pname, params, __functionAddress);
    }

    public static void glFogfv(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glFogfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(pname, params, __functionAddress);
    }

    public static void glGenTextures(@NativeType(value="GLuint *") int[] textures) {
        GL11C.glGenTextures(textures);
    }

    public static void glDeleteTextures(@NativeType(value="GLuint const *") int[] textures) {
        GL11C.glDeleteTextures(textures);
    }

    public static void glGetClipPlane(@NativeType(value="GLenum") int plane, @NativeType(value="GLdouble *") double[] equation) {
        long __functionAddress = GL.getICD().glGetClipPlane;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(equation, 4);
        }
        JNI.callPV(plane, equation, __functionAddress);
    }

    public static void glGetFloatv(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        GL11C.glGetFloatv(pname, params);
    }

    public static void glGetIntegerv(@NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL11C.glGetIntegerv(pname, params);
    }

    public static void glGetDoublev(@NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") double[] params) {
        GL11C.glGetDoublev(pname, params);
    }

    public static void glGetLightiv(@NativeType(value="GLenum") int light, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] data) {
        long __functionAddress = GL.getICD().glGetLightiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 4);
        }
        JNI.callPV(light, pname, data, __functionAddress);
    }

    public static void glGetLightfv(@NativeType(value="GLenum") int light, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] data) {
        long __functionAddress = GL.getICD().glGetLightfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 4);
        }
        JNI.callPV(light, pname, data, __functionAddress);
    }

    public static void glGetMapiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLint *") int[] data) {
        long __functionAddress = GL.getICD().glGetMapiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 4);
        }
        JNI.callPV(target, query, data, __functionAddress);
    }

    public static void glGetMapfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLfloat *") float[] data) {
        long __functionAddress = GL.getICD().glGetMapfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 4);
        }
        JNI.callPV(target, query, data, __functionAddress);
    }

    public static void glGetMapdv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLdouble *") double[] data) {
        long __functionAddress = GL.getICD().glGetMapdv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 4);
        }
        JNI.callPV(target, query, data, __functionAddress);
    }

    public static void glGetMaterialiv(@NativeType(value="GLenum") int face, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] data) {
        long __functionAddress = GL.getICD().glGetMaterialiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 1);
        }
        JNI.callPV(face, pname, data, __functionAddress);
    }

    public static void glGetMaterialfv(@NativeType(value="GLenum") int face, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] data) {
        long __functionAddress = GL.getICD().glGetMaterialfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 1);
        }
        JNI.callPV(face, pname, data, __functionAddress);
    }

    public static void glGetPixelMapfv(@NativeType(value="GLenum") int map, @NativeType(value="GLfloat *") float[] data) {
        long __functionAddress = GL.getICD().glGetPixelMapfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 32);
        }
        JNI.callPV(map, data, __functionAddress);
    }

    public static void glGetPixelMapusv(@NativeType(value="GLenum") int map, @NativeType(value="GLushort *") short[] data) {
        long __functionAddress = GL.getICD().glGetPixelMapusv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 32);
        }
        JNI.callPV(map, data, __functionAddress);
    }

    public static void glGetPixelMapuiv(@NativeType(value="GLenum") int map, @NativeType(value="GLuint *") int[] data) {
        long __functionAddress = GL.getICD().glGetPixelMapuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 32);
        }
        JNI.callPV(map, data, __functionAddress);
    }

    public static void glGetTexEnviv(@NativeType(value="GLenum") int env, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] data) {
        long __functionAddress = GL.getICD().glGetTexEnviv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 1);
        }
        JNI.callPV(env, pname, data, __functionAddress);
    }

    public static void glGetTexEnvfv(@NativeType(value="GLenum") int env, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] data) {
        long __functionAddress = GL.getICD().glGetTexEnvfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 1);
        }
        JNI.callPV(env, pname, data, __functionAddress);
    }

    public static void glGetTexGeniv(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] data) {
        long __functionAddress = GL.getICD().glGetTexGeniv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 1);
        }
        JNI.callPV(coord, pname, data, __functionAddress);
    }

    public static void glGetTexGenfv(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] data) {
        long __functionAddress = GL.getICD().glGetTexGenfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 4);
        }
        JNI.callPV(coord, pname, data, __functionAddress);
    }

    public static void glGetTexGendv(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") double[] data) {
        long __functionAddress = GL.getICD().glGetTexGendv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 4);
        }
        JNI.callPV(coord, pname, data, __functionAddress);
    }

    public static void glGetTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] pixels) {
        GL11C.glGetTexImage(tex, level, format, type, pixels);
    }

    public static void glGetTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] pixels) {
        GL11C.glGetTexImage(tex, level, format, type, pixels);
    }

    public static void glGetTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] pixels) {
        GL11C.glGetTexImage(tex, level, format, type, pixels);
    }

    public static void glGetTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") double[] pixels) {
        GL11C.glGetTexImage(tex, level, format, type, pixels);
    }

    public static void glGetTexLevelParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL11C.glGetTexLevelParameteriv(target, level, pname, params);
    }

    public static void glGetTexLevelParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        GL11C.glGetTexLevelParameterfv(target, level, pname, params);
    }

    public static void glGetTexParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL11C.glGetTexParameteriv(target, pname, params);
    }

    public static void glGetTexParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        GL11C.glGetTexParameterfv(target, pname, params);
    }

    public static void glIndexiv(@NativeType(value="GLint const *") int[] index) {
        long __functionAddress = GL.getICD().glIndexiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(index, 1);
        }
        JNI.callPV(index, __functionAddress);
    }

    public static void glIndexsv(@NativeType(value="GLshort const *") short[] index) {
        long __functionAddress = GL.getICD().glIndexsv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(index, 1);
        }
        JNI.callPV(index, __functionAddress);
    }

    public static void glIndexfv(@NativeType(value="GLfloat const *") float[] index) {
        long __functionAddress = GL.getICD().glIndexfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(index, 1);
        }
        JNI.callPV(index, __functionAddress);
    }

    public static void glIndexdv(@NativeType(value="GLdouble const *") double[] index) {
        long __functionAddress = GL.getICD().glIndexdv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(index, 1);
        }
        JNI.callPV(index, __functionAddress);
    }

    public static void glInterleavedArrays(@NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") short[] pointer) {
        long __functionAddress = GL.getICD().glInterleavedArrays;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(format, stride, pointer, __functionAddress);
    }

    public static void glInterleavedArrays(@NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") int[] pointer) {
        long __functionAddress = GL.getICD().glInterleavedArrays;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(format, stride, pointer, __functionAddress);
    }

    public static void glInterleavedArrays(@NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") float[] pointer) {
        long __functionAddress = GL.getICD().glInterleavedArrays;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(format, stride, pointer, __functionAddress);
    }

    public static void glInterleavedArrays(@NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") double[] pointer) {
        long __functionAddress = GL.getICD().glInterleavedArrays;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(format, stride, pointer, __functionAddress);
    }

    public static void glLightModeliv(@NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glLightModeliv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(pname, params, __functionAddress);
    }

    public static void glLightModelfv(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glLightModelfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(pname, params, __functionAddress);
    }

    public static void glLightiv(@NativeType(value="GLenum") int light, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glLightiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(light, pname, params, __functionAddress);
    }

    public static void glLightfv(@NativeType(value="GLenum") int light, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glLightfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(light, pname, params, __functionAddress);
    }

    public static void glLoadMatrixf(@NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glLoadMatrixf;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(m, __functionAddress);
    }

    public static void glLoadMatrixd(@NativeType(value="GLdouble const *") double[] m) {
        long __functionAddress = GL.getICD().glLoadMatrixd;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(m, __functionAddress);
    }

    public static void glMap1f(@NativeType(value="GLenum") int target, @NativeType(value="GLfloat") float u1, @NativeType(value="GLfloat") float u2, @NativeType(value="GLint") int stride, @NativeType(value="GLint") int order, @NativeType(value="GLfloat const *") float[] points) {
        long __functionAddress = GL.getICD().glMap1f;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(points, order * stride);
        }
        JNI.callPV(target, u1, u2, stride, order, points, __functionAddress);
    }

    public static void glMap1d(@NativeType(value="GLenum") int target, @NativeType(value="GLdouble") double u1, @NativeType(value="GLdouble") double u2, @NativeType(value="GLint") int stride, @NativeType(value="GLint") int order, @NativeType(value="GLdouble const *") double[] points) {
        long __functionAddress = GL.getICD().glMap1d;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(points, stride * order);
        }
        JNI.callPV(target, u1, u2, stride, order, points, __functionAddress);
    }

    public static void glMap2f(@NativeType(value="GLenum") int target, @NativeType(value="GLfloat") float u1, @NativeType(value="GLfloat") float u2, @NativeType(value="GLint") int ustride, @NativeType(value="GLint") int uorder, @NativeType(value="GLfloat") float v1, @NativeType(value="GLfloat") float v2, @NativeType(value="GLint") int vstride, @NativeType(value="GLint") int vorder, @NativeType(value="GLfloat const *") float[] points) {
        long __functionAddress = GL.getICD().glMap2f;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(points, ustride * uorder * vstride * vorder);
        }
        JNI.callPV(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, __functionAddress);
    }

    public static void glMap2d(@NativeType(value="GLenum") int target, @NativeType(value="GLdouble") double u1, @NativeType(value="GLdouble") double u2, @NativeType(value="GLint") int ustride, @NativeType(value="GLint") int uorder, @NativeType(value="GLdouble") double v1, @NativeType(value="GLdouble") double v2, @NativeType(value="GLint") int vstride, @NativeType(value="GLint") int vorder, @NativeType(value="GLdouble const *") double[] points) {
        long __functionAddress = GL.getICD().glMap2d;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(points, ustride * uorder * vstride * vorder);
        }
        JNI.callPV(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, __functionAddress);
    }

    public static void glMaterialiv(@NativeType(value="GLenum") int face, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glMaterialiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(face, pname, params, __functionAddress);
    }

    public static void glMaterialfv(@NativeType(value="GLenum") int face, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glMaterialfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(face, pname, params, __functionAddress);
    }

    public static void glMultMatrixf(@NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glMultMatrixf;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(m, __functionAddress);
    }

    public static void glMultMatrixd(@NativeType(value="GLdouble const *") double[] m) {
        long __functionAddress = GL.getICD().glMultMatrixd;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(m, __functionAddress);
    }

    public static void glNormal3fv(@NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glNormal3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glNormal3sv(@NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glNormal3sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glNormal3iv(@NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glNormal3iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glNormal3dv(@NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glNormal3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glPixelMapfv(@NativeType(value="GLenum") int map, @NativeType(value="GLfloat const *") float[] values) {
        long __functionAddress = GL.getICD().glPixelMapfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(map, values.length, values, __functionAddress);
    }

    public static void glPixelMapusv(@NativeType(value="GLenum") int map, @NativeType(value="GLushort const *") short[] values) {
        long __functionAddress = GL.getICD().glPixelMapusv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(map, values.length, values, __functionAddress);
    }

    public static void glPixelMapuiv(@NativeType(value="GLenum") int map, @NativeType(value="GLuint const *") int[] values) {
        long __functionAddress = GL.getICD().glPixelMapuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(map, values.length, values, __functionAddress);
    }

    public static void glPrioritizeTextures(@NativeType(value="GLuint const *") int[] textures, @NativeType(value="GLfloat const *") float[] priorities) {
        long __functionAddress = GL.getICD().glPrioritizeTextures;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(priorities, textures.length);
        }
        JNI.callPPV(textures.length, textures, priorities, __functionAddress);
    }

    public static void glRasterPos2iv(@NativeType(value="GLint const *") int[] coords) {
        long __functionAddress = GL.getICD().glRasterPos2iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 2);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glRasterPos2sv(@NativeType(value="GLshort const *") short[] coords) {
        long __functionAddress = GL.getICD().glRasterPos2sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 2);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glRasterPos2fv(@NativeType(value="GLfloat const *") float[] coords) {
        long __functionAddress = GL.getICD().glRasterPos2fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 2);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glRasterPos2dv(@NativeType(value="GLdouble const *") double[] coords) {
        long __functionAddress = GL.getICD().glRasterPos2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 2);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glRasterPos3iv(@NativeType(value="GLint const *") int[] coords) {
        long __functionAddress = GL.getICD().glRasterPos3iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 3);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glRasterPos3sv(@NativeType(value="GLshort const *") short[] coords) {
        long __functionAddress = GL.getICD().glRasterPos3sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 3);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glRasterPos3fv(@NativeType(value="GLfloat const *") float[] coords) {
        long __functionAddress = GL.getICD().glRasterPos3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 3);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glRasterPos3dv(@NativeType(value="GLdouble const *") double[] coords) {
        long __functionAddress = GL.getICD().glRasterPos3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 3);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glRasterPos4iv(@NativeType(value="GLint const *") int[] coords) {
        long __functionAddress = GL.getICD().glRasterPos4iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 4);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glRasterPos4sv(@NativeType(value="GLshort const *") short[] coords) {
        long __functionAddress = GL.getICD().glRasterPos4sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 4);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glRasterPos4fv(@NativeType(value="GLfloat const *") float[] coords) {
        long __functionAddress = GL.getICD().glRasterPos4fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 4);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glRasterPos4dv(@NativeType(value="GLdouble const *") double[] coords) {
        long __functionAddress = GL.getICD().glRasterPos4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 4);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glReadPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] pixels) {
        GL11C.glReadPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] pixels) {
        GL11C.glReadPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] pixels) {
        GL11C.glReadPixels(x, y, width, height, format, type, pixels);
    }

    public static void glRectiv(@NativeType(value="GLint const *") int[] v1, @NativeType(value="GLint const *") int[] v2) {
        long __functionAddress = GL.getICD().glRectiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v1, 2);
            Checks.check(v2, 2);
        }
        JNI.callPPV(v1, v2, __functionAddress);
    }

    public static void glRectsv(@NativeType(value="GLshort const *") short[] v1, @NativeType(value="GLshort const *") short[] v2) {
        long __functionAddress = GL.getICD().glRectsv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v1, 2);
            Checks.check(v2, 2);
        }
        JNI.callPPV(v1, v2, __functionAddress);
    }

    public static void glRectfv(@NativeType(value="GLfloat const *") float[] v1, @NativeType(value="GLfloat const *") float[] v2) {
        long __functionAddress = GL.getICD().glRectfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v1, 2);
            Checks.check(v2, 2);
        }
        JNI.callPPV(v1, v2, __functionAddress);
    }

    public static void glRectdv(@NativeType(value="GLdouble const *") double[] v1, @NativeType(value="GLdouble const *") double[] v2) {
        long __functionAddress = GL.getICD().glRectdv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v1, 2);
            Checks.check(v2, 2);
        }
        JNI.callPPV(v1, v2, __functionAddress);
    }

    public static void glSelectBuffer(@NativeType(value="GLuint *") int[] buffer) {
        long __functionAddress = GL.getICD().glSelectBuffer;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(buffer.length, buffer, __functionAddress);
    }

    public static void glTexCoord1fv(@NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glTexCoord1fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord1sv(@NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glTexCoord1sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord1iv(@NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glTexCoord1iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord1dv(@NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glTexCoord1dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord2fv(@NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glTexCoord2fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord2sv(@NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glTexCoord2sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord2iv(@NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glTexCoord2iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord2dv(@NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glTexCoord2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord3fv(@NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glTexCoord3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord3sv(@NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glTexCoord3sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord3iv(@NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glTexCoord3iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord3dv(@NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glTexCoord3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord4fv(@NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glTexCoord4fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord4sv(@NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glTexCoord4sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord4iv(@NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glTexCoord4iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord4dv(@NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glTexCoord4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexEnviv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glTexEnviv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glTexEnvfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glTexEnvfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glTexGeniv(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glTexGeniv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(coord, pname, params, __functionAddress);
    }

    public static void glTexGenfv(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glTexGenfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(coord, pname, params, __functionAddress);
    }

    public static void glTexGendv(@NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble const *") double[] params) {
        long __functionAddress = GL.getICD().glTexGendv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(coord, pname, params, __functionAddress);
    }

    public static void glTexImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] pixels) {
        GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] pixels) {
        GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] pixels) {
        GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") double[] pixels) {
        GL11C.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] pixels) {
        GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] pixels) {
        GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] pixels) {
        GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") double[] pixels) {
        GL11C.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        GL11C.glTexParameteriv(target, pname, params);
    }

    public static void glTexParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        GL11C.glTexParameterfv(target, pname, params);
    }

    public static void glTexSubImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") double[] pixels) {
        GL11C.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") double[] pixels) {
        GL11C.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glVertex2fv(@NativeType(value="GLfloat const *") float[] coords) {
        long __functionAddress = GL.getICD().glVertex2fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 2);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glVertex2sv(@NativeType(value="GLshort const *") short[] coords) {
        long __functionAddress = GL.getICD().glVertex2sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 2);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glVertex2iv(@NativeType(value="GLint const *") int[] coords) {
        long __functionAddress = GL.getICD().glVertex2iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 2);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glVertex2dv(@NativeType(value="GLdouble const *") double[] coords) {
        long __functionAddress = GL.getICD().glVertex2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 2);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glVertex3fv(@NativeType(value="GLfloat const *") float[] coords) {
        long __functionAddress = GL.getICD().glVertex3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 3);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glVertex3sv(@NativeType(value="GLshort const *") short[] coords) {
        long __functionAddress = GL.getICD().glVertex3sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 3);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glVertex3iv(@NativeType(value="GLint const *") int[] coords) {
        long __functionAddress = GL.getICD().glVertex3iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 3);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glVertex3dv(@NativeType(value="GLdouble const *") double[] coords) {
        long __functionAddress = GL.getICD().glVertex3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 3);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glVertex4fv(@NativeType(value="GLfloat const *") float[] coords) {
        long __functionAddress = GL.getICD().glVertex4fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 4);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glVertex4sv(@NativeType(value="GLshort const *") short[] coords) {
        long __functionAddress = GL.getICD().glVertex4sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 4);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glVertex4iv(@NativeType(value="GLint const *") int[] coords) {
        long __functionAddress = GL.getICD().glVertex4iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 4);
        }
        JNI.callPV(coords, __functionAddress);
    }

    public static void glVertex4dv(@NativeType(value="GLdouble const *") double[] coords) {
        long __functionAddress = GL.getICD().glVertex4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 4);
        }
        JNI.callPV(coords, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

