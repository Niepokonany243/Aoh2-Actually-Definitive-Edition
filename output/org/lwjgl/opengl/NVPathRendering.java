/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVPathRendering {
    public static final byte GL_CLOSE_PATH_NV = 0;
    public static final byte GL_MOVE_TO_NV = 2;
    public static final byte GL_RELATIVE_MOVE_TO_NV = 3;
    public static final byte GL_LINE_TO_NV = 4;
    public static final byte GL_RELATIVE_LINE_TO_NV = 5;
    public static final byte GL_HORIZONTAL_LINE_TO_NV = 6;
    public static final byte GL_RELATIVE_HORIZONTAL_LINE_TO_NV = 7;
    public static final byte GL_VERTICAL_LINE_TO_NV = 8;
    public static final byte GL_RELATIVE_VERTICAL_LINE_TO_NV = 9;
    public static final byte GL_QUADRATIC_CURVE_TO_NV = 10;
    public static final byte GL_RELATIVE_QUADRATIC_CURVE_TO_NV = 11;
    public static final byte GL_CUBIC_CURVE_TO_NV = 12;
    public static final byte GL_RELATIVE_CUBIC_CURVE_TO_NV = 13;
    public static final byte GL_SMOOTH_QUADRATIC_CURVE_TO_NV = 14;
    public static final byte GL_RELATIVE_SMOOTH_QUADRATIC_CURVE_TO_NV = 15;
    public static final byte GL_SMOOTH_CUBIC_CURVE_TO_NV = 16;
    public static final byte GL_RELATIVE_SMOOTH_CUBIC_CURVE_TO_NV = 17;
    public static final byte GL_SMALL_CCW_ARC_TO_NV = 18;
    public static final byte GL_RELATIVE_SMALL_CCW_ARC_TO_NV = 19;
    public static final byte GL_SMALL_CW_ARC_TO_NV = 20;
    public static final byte GL_RELATIVE_SMALL_CW_ARC_TO_NV = 21;
    public static final byte GL_LARGE_CCW_ARC_TO_NV = 22;
    public static final byte GL_RELATIVE_LARGE_CCW_ARC_TO_NV = 23;
    public static final byte GL_LARGE_CW_ARC_TO_NV = 24;
    public static final byte GL_RELATIVE_LARGE_CW_ARC_TO_NV = 25;
    public static final byte GL_CONIC_CURVE_TO_NV = 26;
    public static final byte GL_RELATIVE_CONIC_CURVE_TO_NV = 27;
    public static final byte GL_ROUNDED_RECT_NV = -24;
    public static final byte GL_RELATIVE_ROUNDED_RECT_NV = -23;
    public static final byte GL_ROUNDED_RECT2_NV = -22;
    public static final byte GL_RELATIVE_ROUNDED_RECT2_NV = -21;
    public static final byte GL_ROUNDED_RECT4_NV = -20;
    public static final byte GL_RELATIVE_ROUNDED_RECT4_NV = -19;
    public static final byte GL_ROUNDED_RECT8_NV = -18;
    public static final byte GL_RELATIVE_ROUNDED_RECT8_NV = -17;
    public static final byte GL_RESTART_PATH_NV = -16;
    public static final byte GL_DUP_FIRST_CUBIC_CURVE_TO_NV = -14;
    public static final byte GL_DUP_LAST_CUBIC_CURVE_TO_NV = -12;
    public static final byte GL_RECT_NV = -10;
    public static final byte GL_RELATIVE_RECT_NV = -9;
    public static final byte GL_CIRCULAR_CCW_ARC_TO_NV = -8;
    public static final byte GL_CIRCULAR_CW_ARC_TO_NV = -6;
    public static final byte GL_CIRCULAR_TANGENT_ARC_TO_NV = -4;
    public static final byte GL_ARC_TO_NV = -2;
    public static final byte GL_RELATIVE_ARC_TO_NV = -1;
    public static final int GL_PATH_FORMAT_SVG_NV = 36976;
    public static final int GL_PATH_FORMAT_PS_NV = 36977;
    public static final int GL_STANDARD_FONT_NAME_NV = 36978;
    public static final int GL_SYSTEM_FONT_NAME_NV = 36979;
    public static final int GL_FILE_NAME_NV = 36980;
    public static final int GL_STANDARD_FONT_FORMAT_NV = 37740;
    public static final int GL_SKIP_MISSING_GLYPH_NV = 37033;
    public static final int GL_USE_MISSING_GLYPH_NV = 37034;
    public static final int GL_FONT_GLYPHS_AVAILABLE_NV = 37736;
    public static final int GL_FONT_TARGET_UNAVAILABLE_NV = 37737;
    public static final int GL_FONT_UNAVAILABLE_NV = 37738;
    public static final int GL_FONT_UNINTELLIGIBLE_NV = 37739;
    public static final int GL_PATH_STROKE_WIDTH_NV = 36981;
    public static final int GL_PATH_INITIAL_END_CAP_NV = 36983;
    public static final int GL_PATH_TERMINAL_END_CAP_NV = 36984;
    public static final int GL_PATH_JOIN_STYLE_NV = 36985;
    public static final int GL_PATH_MITER_LIMIT_NV = 36986;
    public static final int GL_PATH_INITIAL_DASH_CAP_NV = 36988;
    public static final int GL_PATH_TERMINAL_DASH_CAP_NV = 36989;
    public static final int GL_PATH_DASH_OFFSET_NV = 36990;
    public static final int GL_PATH_CLIENT_LENGTH_NV = 36991;
    public static final int GL_PATH_DASH_OFFSET_RESET_NV = 37044;
    public static final int GL_PATH_FILL_MODE_NV = 36992;
    public static final int GL_PATH_FILL_MASK_NV = 36993;
    public static final int GL_PATH_FILL_COVER_MODE_NV = 36994;
    public static final int GL_PATH_STROKE_COVER_MODE_NV = 36995;
    public static final int GL_PATH_STROKE_MASK_NV = 36996;
    public static final int GL_PATH_STROKE_BOUND_NV = 36998;
    public static final int GL_PATH_END_CAPS_NV = 36982;
    public static final int GL_PATH_DASH_CAPS_NV = 36987;
    public static final int GL_COUNT_UP_NV = 37000;
    public static final int GL_COUNT_DOWN_NV = 37001;
    public static final int GL_PRIMARY_COLOR_NV = 34092;
    public static final int GL_SECONDARY_COLOR_NV = 34093;
    public static final int GL_PATH_OBJECT_BOUNDING_BOX_NV = 37002;
    public static final int GL_CONVEX_HULL_NV = 37003;
    public static final int GL_BOUNDING_BOX_NV = 37005;
    public static final int GL_TRANSLATE_X_NV = 37006;
    public static final int GL_TRANSLATE_Y_NV = 37007;
    public static final int GL_TRANSLATE_2D_NV = 37008;
    public static final int GL_TRANSLATE_3D_NV = 37009;
    public static final int GL_AFFINE_2D_NV = 37010;
    public static final int GL_AFFINE_3D_NV = 37012;
    public static final int GL_TRANSPOSE_AFFINE_2D_NV = 37014;
    public static final int GL_TRANSPOSE_AFFINE_3D_NV = 37016;
    public static final int GL_UTF8_NV = 37018;
    public static final int GL_UTF16_NV = 37019;
    public static final int GL_BOUNDING_BOX_OF_BOUNDING_BOXES_NV = 37020;
    public static final int GL_PATH_COMMAND_COUNT_NV = 37021;
    public static final int GL_PATH_COORD_COUNT_NV = 37022;
    public static final int GL_PATH_DASH_ARRAY_COUNT_NV = 37023;
    public static final int GL_PATH_COMPUTED_LENGTH_NV = 37024;
    public static final int GL_PATH_FILL_BOUNDING_BOX_NV = 37025;
    public static final int GL_PATH_STROKE_BOUNDING_BOX_NV = 37026;
    public static final int GL_SQUARE_NV = 37027;
    public static final int GL_ROUND_NV = 37028;
    public static final int GL_TRIANGULAR_NV = 37029;
    public static final int GL_BEVEL_NV = 37030;
    public static final int GL_MITER_REVERT_NV = 37031;
    public static final int GL_MITER_TRUNCATE_NV = 37032;
    public static final int GL_MOVE_TO_RESETS_NV = 37045;
    public static final int GL_MOVE_TO_CONTINUES_NV = 37046;
    public static final int GL_BOLD_BIT_NV = 1;
    public static final int GL_ITALIC_BIT_NV = 2;
    public static final int GL_PATH_ERROR_POSITION_NV = 37035;
    public static final int GL_PATH_FOG_GEN_MODE_NV = 37036;
    public static final int GL_PATH_STENCIL_FUNC_NV = 37047;
    public static final int GL_PATH_STENCIL_REF_NV = 37048;
    public static final int GL_PATH_STENCIL_VALUE_MASK_NV = 37049;
    public static final int GL_PATH_STENCIL_DEPTH_OFFSET_FACTOR_NV = 37053;
    public static final int GL_PATH_STENCIL_DEPTH_OFFSET_UNITS_NV = 37054;
    public static final int GL_PATH_COVER_DEPTH_FUNC_NV = 37055;
    public static final int GL_GLYPH_WIDTH_BIT_NV = 1;
    public static final int GL_GLYPH_HEIGHT_BIT_NV = 2;
    public static final int GL_GLYPH_HORIZONTAL_BEARING_X_BIT_NV = 4;
    public static final int GL_GLYPH_HORIZONTAL_BEARING_Y_BIT_NV = 8;
    public static final int GL_GLYPH_HORIZONTAL_BEARING_ADVANCE_BIT_NV = 16;
    public static final int GL_GLYPH_VERTICAL_BEARING_X_BIT_NV = 32;
    public static final int GL_GLYPH_VERTICAL_BEARING_Y_BIT_NV = 64;
    public static final int GL_GLYPH_VERTICAL_BEARING_ADVANCE_BIT_NV = 128;
    public static final int GL_GLYPH_HAS_KERNING_BIT_NV = 256;
    public static final int GL_FONT_X_MIN_BOUNDS_BIT_NV = 65536;
    public static final int GL_FONT_Y_MIN_BOUNDS_BIT_NV = 131072;
    public static final int GL_FONT_X_MAX_BOUNDS_BIT_NV = 262144;
    public static final int GL_FONT_Y_MAX_BOUNDS_BIT_NV = 524288;
    public static final int GL_FONT_UNITS_PER_EM_BIT_NV = 0x100000;
    public static final int GL_FONT_ASCENDER_BIT_NV = 0x200000;
    public static final int GL_FONT_DESCENDER_BIT_NV = 0x400000;
    public static final int GL_FONT_HEIGHT_BIT_NV = 0x800000;
    public static final int GL_FONT_MAX_ADVANCE_WIDTH_BIT_NV = 0x1000000;
    public static final int GL_FONT_MAX_ADVANCE_HEIGHT_BIT_NV = 0x2000000;
    public static final int GL_FONT_UNDERLINE_POSITION_BIT_NV = 0x4000000;
    public static final int GL_FONT_UNDERLINE_THICKNESS_BIT_NV = 0x8000000;
    public static final int GL_FONT_HAS_KERNING_BIT_NV = 0x10000000;
    public static final int GL_FONT_NUM_GLYPH_INDICES_BIT_NV = 0x20000000;
    public static final int GL_ACCUM_ADJACENT_PAIRS_NV = 37037;
    public static final int GL_ADJACENT_PAIRS_NV = 37038;
    public static final int GL_FIRST_TO_REST_NV = 37039;
    public static final int GL_PATH_GEN_MODE_NV = 37040;
    public static final int GL_PATH_GEN_COEFF_NV = 37041;
    public static final int GL_PATH_GEN_COLOR_FORMAT_NV = 37042;
    public static final int GL_PATH_GEN_COMPONENTS_NV = 37043;
    public static final int GL_FRAGMENT_INPUT_NV = 37741;
    public static final int GL_PATH_PROJECTION_NV = 5889;
    public static final int GL_PATH_MODELVIEW_NV = 5888;
    public static final int GL_PATH_MODELVIEW_STACK_DEPTH_NV = 2979;
    public static final int GL_PATH_MODELVIEW_MATRIX_NV = 2982;
    public static final int GL_PATH_MAX_MODELVIEW_STACK_DEPTH_NV = 3382;
    public static final int GL_PATH_TRANSPOSE_MODELVIEW_MATRIX_NV = 34019;
    public static final int GL_PATH_PROJECTION_STACK_DEPTH_NV = 2980;
    public static final int GL_PATH_PROJECTION_MATRIX_NV = 2983;
    public static final int GL_PATH_MAX_PROJECTION_STACK_DEPTH_NV = 3384;
    public static final int GL_PATH_TRANSPOSE_PROJECTION_MATRIX_NV = 34020;
    public static final int GL_2_BYTES_NV = 5127;
    public static final int GL_3_BYTES_NV = 5128;
    public static final int GL_4_BYTES_NV = 5129;
    public static final int GL_EYE_LINEAR_NV = 9216;
    public static final int GL_OBJECT_LINEAR_NV = 9217;
    public static final int GL_CONSTANT_NV = 34166;

    protected NVPathRendering() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glPathCommandsNV, caps.glPathCoordsNV, caps.glPathSubCommandsNV, caps.glPathSubCoordsNV, caps.glPathStringNV, caps.glPathGlyphsNV, caps.glPathGlyphRangeNV, caps.glCopyPathNV, caps.glInterpolatePathsNV, caps.glTransformPathNV, caps.glPathParameterivNV, caps.glPathParameteriNV, caps.glPathParameterfvNV, caps.glPathParameterfNV, caps.glPathDashArrayNV, caps.glGenPathsNV, caps.glDeletePathsNV, caps.glIsPathNV, caps.glPathStencilFuncNV, caps.glPathStencilDepthOffsetNV, caps.glStencilFillPathNV, caps.glStencilStrokePathNV, caps.glStencilFillPathInstancedNV, caps.glStencilStrokePathInstancedNV, caps.glPathCoverDepthFuncNV, caps.glCoverFillPathNV, caps.glCoverStrokePathNV, caps.glCoverFillPathInstancedNV, caps.glCoverStrokePathInstancedNV, caps.glGetPathParameterivNV, caps.glGetPathParameterfvNV, caps.glGetPathCommandsNV, caps.glGetPathCoordsNV, caps.glGetPathDashArrayNV, caps.glGetPathMetricsNV, caps.glGetPathMetricRangeNV, caps.glGetPathSpacingNV, caps.glIsPointInFillPathNV, caps.glIsPointInStrokePathNV, caps.glGetPathLengthNV, caps.glPointAlongPathNV);
    }

    public static native void nglPathCommandsNV(int var0, int var1, long var2, int var4, int var5, long var6);

    public static void glPathCommandsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLubyte const *") ByteBuffer commands, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") ByteBuffer coords) {
        NVPathRendering.nglPathCommandsNV(path, commands.remaining(), MemoryUtil.memAddress(commands), coords.remaining() >> GLChecks.typeToByteShift(coordType), coordType, MemoryUtil.memAddress(coords));
    }

    public static void glPathCommandsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLubyte const *") ByteBuffer commands, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") ShortBuffer coords) {
        NVPathRendering.nglPathCommandsNV(path, commands.remaining(), MemoryUtil.memAddress(commands), (int)((long)coords.remaining() << 1 >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
    }

    public static void glPathCommandsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLubyte const *") ByteBuffer commands, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") FloatBuffer coords) {
        NVPathRendering.nglPathCommandsNV(path, commands.remaining(), MemoryUtil.memAddress(commands), (int)((long)coords.remaining() << 2 >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
    }

    public static native void nglPathCoordsNV(int var0, int var1, int var2, long var3);

    public static void glPathCoordsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") ByteBuffer coords) {
        NVPathRendering.nglPathCoordsNV(path, coords.remaining() >> GLChecks.typeToByteShift(coordType), coordType, MemoryUtil.memAddress(coords));
    }

    public static void glPathCoordsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") ShortBuffer coords) {
        NVPathRendering.nglPathCoordsNV(path, (int)((long)coords.remaining() << 1 >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
    }

    public static void glPathCoordsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") FloatBuffer coords) {
        NVPathRendering.nglPathCoordsNV(path, (int)((long)coords.remaining() << 2 >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
    }

    public static native void nglPathSubCommandsNV(int var0, int var1, int var2, int var3, long var4, int var6, int var7, long var8);

    public static void glPathSubCommandsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLsizei") int commandStart, @NativeType(value="GLsizei") int commandsToDelete, @NativeType(value="GLubyte const *") ByteBuffer commands, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") ByteBuffer coords) {
        NVPathRendering.nglPathSubCommandsNV(path, commandStart, commandsToDelete, commands.remaining(), MemoryUtil.memAddress(commands), coords.remaining() >> GLChecks.typeToByteShift(coordType), coordType, MemoryUtil.memAddress(coords));
    }

    public static void glPathSubCommandsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLsizei") int commandStart, @NativeType(value="GLsizei") int commandsToDelete, @NativeType(value="GLubyte const *") ByteBuffer commands, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") ShortBuffer coords) {
        NVPathRendering.nglPathSubCommandsNV(path, commandStart, commandsToDelete, commands.remaining(), MemoryUtil.memAddress(commands), (int)((long)coords.remaining() << 1 >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
    }

    public static void glPathSubCommandsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLsizei") int commandStart, @NativeType(value="GLsizei") int commandsToDelete, @NativeType(value="GLubyte const *") ByteBuffer commands, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") FloatBuffer coords) {
        NVPathRendering.nglPathSubCommandsNV(path, commandStart, commandsToDelete, commands.remaining(), MemoryUtil.memAddress(commands), (int)((long)coords.remaining() << 2 >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
    }

    public static native void nglPathSubCoordsNV(int var0, int var1, int var2, int var3, long var4);

    public static void glPathSubCoordsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLsizei") int coordStart, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") ByteBuffer coords) {
        NVPathRendering.nglPathSubCoordsNV(path, coordStart, coords.remaining() >> GLChecks.typeToByteShift(coordType), coordType, MemoryUtil.memAddress(coords));
    }

    public static void glPathSubCoordsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLsizei") int coordStart, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") ShortBuffer coords) {
        NVPathRendering.nglPathSubCoordsNV(path, coordStart, (int)((long)coords.remaining() << 1 >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
    }

    public static void glPathSubCoordsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLsizei") int coordStart, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") FloatBuffer coords) {
        NVPathRendering.nglPathSubCoordsNV(path, coordStart, (int)((long)coords.remaining() << 2 >> GLChecks.typeToByteShift(coordType)), coordType, MemoryUtil.memAddress(coords));
    }

    public static native void nglPathStringNV(int var0, int var1, int var2, long var3);

    public static void glPathStringNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer pathString) {
        NVPathRendering.nglPathStringNV(path, format, pathString.remaining(), MemoryUtil.memAddress(pathString));
    }

    public static native void nglPathGlyphsNV(int var0, int var1, long var2, int var4, int var5, int var6, long var7, int var9, int var10, float var11);

    public static void glPathGlyphsNV(@NativeType(value="GLuint") int firstPathName, @NativeType(value="GLenum") int fontTarget, @NativeType(value="void const *") ByteBuffer fontName, @NativeType(value="GLbitfield") int fontStyle, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer charcodes, @NativeType(value="GLenum") int handleMissingGlyphs, @NativeType(value="GLuint") int pathParameterTemplate, @NativeType(value="GLfloat") float emScale) {
        if (Checks.CHECKS) {
            Checks.checkNT1(fontName);
        }
        NVPathRendering.nglPathGlyphsNV(firstPathName, fontTarget, MemoryUtil.memAddress(fontName), fontStyle, charcodes.remaining() / NVPathRendering.charcodeTypeToBytes(type), type, MemoryUtil.memAddress(charcodes), handleMissingGlyphs, pathParameterTemplate, emScale);
    }

    public static native void nglPathGlyphRangeNV(int var0, int var1, long var2, int var4, int var5, int var6, int var7, int var8, float var9);

    public static void glPathGlyphRangeNV(@NativeType(value="GLuint") int firstPathName, @NativeType(value="GLenum") int fontTarget, @NativeType(value="void const *") ByteBuffer fontName, @NativeType(value="GLbitfield") int fontStyle, @NativeType(value="GLuint") int firstGlyph, @NativeType(value="GLsizei") int numGlyphs, @NativeType(value="GLenum") int handleMissingGlyphs, @NativeType(value="GLuint") int pathParameterTemplate, @NativeType(value="GLfloat") float emScale) {
        if (Checks.CHECKS) {
            Checks.checkNT1(fontName);
        }
        NVPathRendering.nglPathGlyphRangeNV(firstPathName, fontTarget, MemoryUtil.memAddress(fontName), fontStyle, firstGlyph, numGlyphs, handleMissingGlyphs, pathParameterTemplate, emScale);
    }

    public static native int nglPathGlyphIndexArrayNV(int var0, int var1, long var2, int var4, int var5, int var6, int var7, float var8);

    @NativeType(value="GLenum")
    public static int glPathGlyphIndexArrayNV(@NativeType(value="GLuint") int firstPathName, @NativeType(value="GLenum") int fontTarget, @NativeType(value="void const *") ByteBuffer fontName, @NativeType(value="GLbitfield") int fontStyle, @NativeType(value="GLuint") int firstGlyphIndex, @NativeType(value="GLsizei") int numGlyphs, @NativeType(value="GLuint") int pathParameterTemplate, @NativeType(value="GLfloat") float emScale) {
        if (Checks.CHECKS) {
            Checks.checkNT1(fontName);
        }
        return NVPathRendering.nglPathGlyphIndexArrayNV(firstPathName, fontTarget, MemoryUtil.memAddress(fontName), fontStyle, firstGlyphIndex, numGlyphs, pathParameterTemplate, emScale);
    }

    public static native int nglPathMemoryGlyphIndexArrayNV(int var0, int var1, long var2, long var4, int var6, int var7, int var8, int var9, float var10);

    @NativeType(value="GLenum")
    public static int glPathMemoryGlyphIndexArrayNV(@NativeType(value="GLuint") int firstPathName, @NativeType(value="GLenum") int fontTarget, @NativeType(value="void const *") ByteBuffer fontData, @NativeType(value="GLsizei") int faceIndex, @NativeType(value="GLuint") int firstGlyphIndex, @NativeType(value="GLsizei") int numGlyphs, @NativeType(value="GLuint") int pathParameterTemplate, @NativeType(value="GLfloat") float emScale) {
        return NVPathRendering.nglPathMemoryGlyphIndexArrayNV(firstPathName, fontTarget, fontData.remaining(), MemoryUtil.memAddress(fontData), faceIndex, firstGlyphIndex, numGlyphs, pathParameterTemplate, emScale);
    }

    public static native void glCopyPathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglWeightPathsNV(int var0, int var1, long var2, long var4);

    public static void glWeightPathsNV(@NativeType(value="GLuint") int resultPath, @NativeType(value="GLuint const *") IntBuffer paths, @NativeType(value="GLfloat const *") FloatBuffer weights) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)weights, paths.remaining());
        }
        NVPathRendering.nglWeightPathsNV(resultPath, paths.remaining(), MemoryUtil.memAddress(paths), MemoryUtil.memAddress(weights));
    }

    public static native void glInterpolatePathsNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLfloat") float var3);

    public static native void nglTransformPathNV(int var0, int var1, int var2, long var3);

    public static void glTransformPathNV(@NativeType(value="GLuint") int resultPath, @NativeType(value="GLuint") int srcPath, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat const *") FloatBuffer transformValues) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)transformValues, NVPathRendering.transformTypeToElements(transformType));
        }
        NVPathRendering.nglTransformPathNV(resultPath, srcPath, transformType, MemoryUtil.memAddress(transformValues));
    }

    public static native void nglPathParameterivNV(int var0, int var1, long var2);

    public static void glPathParameterivNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        NVPathRendering.nglPathParameterivNV(path, pname, MemoryUtil.memAddress(value));
    }

    public static native void glPathParameteriNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void nglPathParameterfvNV(int var0, int var1, long var2);

    public static void glPathParameterfvNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        NVPathRendering.nglPathParameterfvNV(path, pname, MemoryUtil.memAddress(value));
    }

    public static native void glPathParameterfNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLfloat") float var2);

    public static native void nglPathDashArrayNV(int var0, int var1, long var2);

    public static void glPathDashArrayNV(@NativeType(value="GLuint") int path, @NativeType(value="GLfloat const *") FloatBuffer dashArray) {
        NVPathRendering.nglPathDashArrayNV(path, dashArray.remaining(), MemoryUtil.memAddress(dashArray));
    }

    @NativeType(value="GLuint")
    public static native int glGenPathsNV(@NativeType(value="GLsizei") int var0);

    public static native void glDeletePathsNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1);

    @NativeType(value="GLboolean")
    public static native boolean glIsPathNV(@NativeType(value="GLuint") int var0);

    public static native void glPathStencilFuncNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glPathStencilDepthOffsetNV(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1);

    public static native void glStencilFillPathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void glStencilStrokePathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2);

    public static native void nglStencilFillPathInstancedNV(int var0, int var1, long var2, int var4, int var5, int var6, int var7, long var8);

    public static void glStencilFillPathInstancedNV(@NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLenum") int fillMode, @NativeType(value="GLuint") int mask, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat const *") FloatBuffer transformValues) {
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check((Buffer)transformValues, numPaths * NVPathRendering.transformTypeToElements(transformType));
        }
        NVPathRendering.nglStencilFillPathInstancedNV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, fillMode, mask, transformType, MemoryUtil.memAddress(transformValues));
    }

    public static native void nglStencilStrokePathInstancedNV(int var0, int var1, long var2, int var4, int var5, int var6, int var7, long var8);

    public static void glStencilStrokePathInstancedNV(@NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLint") int reference, @NativeType(value="GLuint") int mask, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat const *") FloatBuffer transformValues) {
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check((Buffer)transformValues, numPaths * NVPathRendering.transformTypeToElements(transformType));
        }
        NVPathRendering.nglStencilStrokePathInstancedNV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, reference, mask, transformType, MemoryUtil.memAddress(transformValues));
    }

    public static native void glPathCoverDepthFuncNV(@NativeType(value="GLenum") int var0);

    public static native void nglPathColorGenNV(int var0, int var1, int var2, long var3);

    public static void glPathColorGenNV(@NativeType(value="GLenum") int color, @NativeType(value="GLenum") int genMode, @NativeType(value="GLenum") int colorFormat, @NativeType(value="GLfloat const *") FloatBuffer coeffs) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coeffs, NVPathRendering.genModeToElements(genMode) * NVPathRendering.colorFormatToComponents(colorFormat));
        }
        NVPathRendering.nglPathColorGenNV(color, genMode, colorFormat, MemoryUtil.memAddress(coeffs));
    }

    public static native void nglPathTexGenNV(int var0, int var1, int var2, long var3);

    public static void glPathTexGenNV(@NativeType(value="GLenum") int texCoordSet, @NativeType(value="GLenum") int genMode, @NativeType(value="GLint") int components, @NativeType(value="GLfloat const *") FloatBuffer coeffs) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coeffs, NVPathRendering.genModeToElements(genMode) * components);
        }
        NVPathRendering.nglPathTexGenNV(texCoordSet, genMode, components, MemoryUtil.memAddress(coeffs));
    }

    public static native void glPathFogGenNV(@NativeType(value="GLenum") int var0);

    public static native void glCoverFillPathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glCoverStrokePathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglCoverFillPathInstancedNV(int var0, int var1, long var2, int var4, int var5, int var6, long var7);

    public static void glCoverFillPathInstancedNV(@NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLenum") int coverMode, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat const *") FloatBuffer transformValues) {
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check((Buffer)transformValues, numPaths * NVPathRendering.transformTypeToElements(transformType));
        }
        NVPathRendering.nglCoverFillPathInstancedNV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, coverMode, transformType, MemoryUtil.memAddress(transformValues));
    }

    public static native void nglCoverStrokePathInstancedNV(int var0, int var1, long var2, int var4, int var5, int var6, long var7);

    public static void glCoverStrokePathInstancedNV(@NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLenum") int coverMode, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat const *") FloatBuffer transformValues) {
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check((Buffer)transformValues, numPaths * NVPathRendering.transformTypeToElements(transformType));
        }
        NVPathRendering.nglCoverStrokePathInstancedNV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, coverMode, transformType, MemoryUtil.memAddress(transformValues));
    }

    public static native void glStencilThenCoverFillPathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLenum") int var3);

    public static native void glStencilThenCoverStrokePathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLenum") int var3);

    public static native void nglStencilThenCoverFillPathInstancedNV(int var0, int var1, long var2, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glStencilThenCoverFillPathInstancedNV(@NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLenum") int fillMode, @NativeType(value="GLuint") int mask, @NativeType(value="GLenum") int coverMode, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat const *") FloatBuffer transformValues) {
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check((Buffer)transformValues, numPaths * NVPathRendering.transformTypeToElements(transformType));
        }
        NVPathRendering.nglStencilThenCoverFillPathInstancedNV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, fillMode, mask, coverMode, transformType, MemoryUtil.memAddress(transformValues));
    }

    public static native void nglStencilThenCoverStrokePathInstancedNV(int var0, int var1, long var2, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glStencilThenCoverStrokePathInstancedNV(@NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLint") int reference, @NativeType(value="GLuint") int mask, @NativeType(value="GLenum") int coverMode, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat const *") FloatBuffer transformValues) {
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check((Buffer)transformValues, numPaths * NVPathRendering.transformTypeToElements(transformType));
        }
        NVPathRendering.nglStencilThenCoverStrokePathInstancedNV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, reference, mask, coverMode, transformType, MemoryUtil.memAddress(transformValues));
    }

    public static native int nglPathGlyphIndexRangeNV(int var0, long var1, int var3, int var4, float var5, int var6);

    @NativeType(value="GLenum")
    public static int glPathGlyphIndexRangeNV(@NativeType(value="GLenum") int fontTarget, @NativeType(value="void const *") ByteBuffer fontName, @NativeType(value="GLbitfield") int fontStyle, @NativeType(value="GLuint") int pathParameterTemplate, @NativeType(value="GLfloat") float emScale, @NativeType(value="GLuint") int baseAndCount) {
        if (Checks.CHECKS) {
            Checks.checkNT1(fontName);
        }
        return NVPathRendering.nglPathGlyphIndexRangeNV(fontTarget, MemoryUtil.memAddress(fontName), fontStyle, pathParameterTemplate, emScale, baseAndCount);
    }

    public static native void nglProgramPathFragmentInputGenNV(int var0, int var1, int var2, int var3, long var4);

    public static void glProgramPathFragmentInputGenNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLenum") int genMode, @NativeType(value="GLint") int components, @NativeType(value="GLfloat const *") FloatBuffer coeffs) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coeffs, NVPathRendering.genModeToElements(genMode) * components);
        }
        NVPathRendering.nglProgramPathFragmentInputGenNV(program, location, genMode, components, MemoryUtil.memAddress(coeffs));
    }

    public static native void nglGetPathParameterivNV(int var0, int var1, long var2);

    public static void glGetPathParameterivNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        NVPathRendering.nglGetPathParameterivNV(path, pname, MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetPathParameteriNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer value = stack.callocInt(1);
            NVPathRendering.nglGetPathParameterivNV(path, pname, MemoryUtil.memAddress(value));
            int n = value.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetPathParameterfvNV(int var0, int var1, long var2);

    public static void glGetPathParameterfvNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        NVPathRendering.nglGetPathParameterfvNV(path, pname, MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetPathParameterfNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer value = stack.callocFloat(1);
            NVPathRendering.nglGetPathParameterfvNV(path, pname, MemoryUtil.memAddress(value));
            float f = value.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetPathCommandsNV(int var0, long var1);

    public static void glGetPathCommandsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLubyte *") ByteBuffer commands) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)commands, NVPathRendering.glGetPathParameteriNV(path, 37021));
        }
        NVPathRendering.nglGetPathCommandsNV(path, MemoryUtil.memAddress(commands));
    }

    public static native void nglGetPathCoordsNV(int var0, long var1);

    public static void glGetPathCoordsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLfloat *") FloatBuffer coords) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)coords, NVPathRendering.glGetPathParameteriNV(path, 37022));
        }
        NVPathRendering.nglGetPathCoordsNV(path, MemoryUtil.memAddress(coords));
    }

    public static native void nglGetPathDashArrayNV(int var0, long var1);

    public static void glGetPathDashArrayNV(@NativeType(value="GLuint") int path, @NativeType(value="GLfloat *") FloatBuffer dashArray) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)dashArray, NVPathRendering.glGetPathParameteriNV(path, 37023));
        }
        NVPathRendering.nglGetPathDashArrayNV(path, MemoryUtil.memAddress(dashArray));
    }

    public static native void nglGetPathMetricsNV(int var0, int var1, int var2, long var3, int var5, int var6, long var7);

    public static void glGetPathMetricsNV(@NativeType(value="GLbitfield") int metricQueryMask, @NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLsizei") int stride, @NativeType(value="GLfloat *") FloatBuffer metrics) {
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check((Buffer)metrics, numPaths * (stride == 0 ? Integer.bitCount(metricQueryMask) : stride >> 2));
        }
        NVPathRendering.nglGetPathMetricsNV(metricQueryMask, numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, stride, MemoryUtil.memAddress(metrics));
    }

    public static native void nglGetPathMetricRangeNV(int var0, int var1, int var2, int var3, long var4);

    public static void glGetPathMetricRangeNV(@NativeType(value="GLbitfield") int metricQueryMask, @NativeType(value="GLuint") int firstPathName, @NativeType(value="GLsizei") int numPaths, @NativeType(value="GLsizei") int stride, @NativeType(value="GLfloat *") FloatBuffer metrics) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)metrics, numPaths * (stride == 0 ? Integer.bitCount(metricQueryMask) : stride >> 2));
        }
        NVPathRendering.nglGetPathMetricRangeNV(metricQueryMask, firstPathName, numPaths, stride, MemoryUtil.memAddress(metrics));
    }

    public static native void nglGetPathSpacingNV(int var0, int var1, int var2, long var3, int var5, float var6, float var7, int var8, long var9);

    public static void glGetPathSpacingNV(@NativeType(value="GLenum") int pathListMode, @NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLfloat") float advanceScale, @NativeType(value="GLfloat") float kerningScale, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat *") FloatBuffer returnedSpacing) {
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check((Buffer)returnedSpacing, (numPaths - 1) * (transformType == 37006 ? 1 : 2));
        }
        NVPathRendering.nglGetPathSpacingNV(pathListMode, numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, advanceScale, kerningScale, transformType, MemoryUtil.memAddress(returnedSpacing));
    }

    public static native void nglGetPathColorGenivNV(int var0, int var1, long var2);

    public static void glGetPathColorGenivNV(@NativeType(value="GLenum") int color, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        NVPathRendering.nglGetPathColorGenivNV(color, pname, MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetPathColorGeniNV(@NativeType(value="GLenum") int color, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer value = stack.callocInt(1);
            NVPathRendering.nglGetPathColorGenivNV(color, pname, MemoryUtil.memAddress(value));
            int n = value.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetPathColorGenfvNV(int var0, int var1, long var2);

    public static void glGetPathColorGenfvNV(@NativeType(value="GLenum") int color, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        NVPathRendering.nglGetPathColorGenfvNV(color, pname, MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetPathColorGenfNV(@NativeType(value="GLenum") int color, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer value = stack.callocFloat(1);
            NVPathRendering.nglGetPathColorGenfvNV(color, pname, MemoryUtil.memAddress(value));
            float f = value.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetPathTexGenivNV(int var0, int var1, long var2);

    public static void glGetPathTexGenivNV(@NativeType(value="GLenum") int texCoordSet, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        NVPathRendering.nglGetPathTexGenivNV(texCoordSet, pname, MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetPathTexGeniNV(@NativeType(value="GLenum") int texCoordSet, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer value = stack.callocInt(1);
            NVPathRendering.nglGetPathTexGenivNV(texCoordSet, pname, MemoryUtil.memAddress(value));
            int n = value.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetPathTexGenfvNV(int var0, int var1, long var2);

    public static void glGetPathTexGenfvNV(@NativeType(value="GLenum") int texCoordSet, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        NVPathRendering.nglGetPathTexGenfvNV(texCoordSet, pname, MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetPathTexGenfNV(@NativeType(value="GLenum") int texCoordSet, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer value = stack.callocFloat(1);
            NVPathRendering.nglGetPathTexGenfvNV(texCoordSet, pname, MemoryUtil.memAddress(value));
            float f = value.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsPointInFillPathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    @NativeType(value="GLboolean")
    public static native boolean glIsPointInStrokePathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    @NativeType(value="GLfloat")
    public static native float glGetPathLengthNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLsizei") int var2);

    public static native boolean nglPointAlongPathNV(int var0, int var1, int var2, float var3, long var4, long var6, long var8, long var10);

    @NativeType(value="GLboolean")
    public static boolean glPointAlongPathNV(@NativeType(value="GLuint") int path, @NativeType(value="GLsizei") int startSegment, @NativeType(value="GLsizei") int numSegments, @NativeType(value="GLfloat") float distance, @Nullable @NativeType(value="GLfloat *") FloatBuffer x, @Nullable @NativeType(value="GLfloat *") FloatBuffer y, @Nullable @NativeType(value="GLfloat *") FloatBuffer tangentX, @Nullable @NativeType(value="GLfloat *") FloatBuffer tangentY) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)x, 1);
            Checks.checkSafe((Buffer)y, 1);
            Checks.checkSafe((Buffer)tangentX, 1);
            Checks.checkSafe((Buffer)tangentY, 1);
        }
        return NVPathRendering.nglPointAlongPathNV(path, startSegment, numSegments, distance, MemoryUtil.memAddressSafe(x), MemoryUtil.memAddressSafe(y), MemoryUtil.memAddressSafe(tangentX), MemoryUtil.memAddressSafe(tangentY));
    }

    public static native void nglMatrixLoad3x2fNV(int var0, long var1);

    public static void glMatrixLoad3x2fNV(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 6);
        }
        NVPathRendering.nglMatrixLoad3x2fNV(matrixMode, MemoryUtil.memAddress(m));
    }

    public static native void nglMatrixLoad3x3fNV(int var0, long var1);

    public static void glMatrixLoad3x3fNV(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 9);
        }
        NVPathRendering.nglMatrixLoad3x3fNV(matrixMode, MemoryUtil.memAddress(m));
    }

    public static native void nglMatrixLoadTranspose3x3fNV(int var0, long var1);

    public static void glMatrixLoadTranspose3x3fNV(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 9);
        }
        NVPathRendering.nglMatrixLoadTranspose3x3fNV(matrixMode, MemoryUtil.memAddress(m));
    }

    public static native void nglMatrixMult3x2fNV(int var0, long var1);

    public static void glMatrixMult3x2fNV(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 6);
        }
        NVPathRendering.nglMatrixMult3x2fNV(matrixMode, MemoryUtil.memAddress(m));
    }

    public static native void nglMatrixMult3x3fNV(int var0, long var1);

    public static void glMatrixMult3x3fNV(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 9);
        }
        NVPathRendering.nglMatrixMult3x3fNV(matrixMode, MemoryUtil.memAddress(m));
    }

    public static native void nglMatrixMultTranspose3x3fNV(int var0, long var1);

    public static void glMatrixMultTranspose3x3fNV(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 9);
        }
        NVPathRendering.nglMatrixMultTranspose3x3fNV(matrixMode, MemoryUtil.memAddress(m));
    }

    public static native void nglGetProgramResourcefvNV(int var0, int var1, int var2, int var3, long var4, int var6, long var7, long var9);

    public static void glGetProgramResourcefvNV(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLuint") int index, @NativeType(value="GLenum const *") IntBuffer props, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
        }
        NVPathRendering.nglGetProgramResourcefvNV(program, programInterface, index, props.remaining(), MemoryUtil.memAddress(props), params.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(params));
    }

    public static void glPathCommandsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLubyte const *") ByteBuffer commands, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") short[] coords) {
        long __functionAddress = GL.getICD().glPathCommandsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(path, commands.remaining(), MemoryUtil.memAddress(commands), coords.length, coordType, coords, __functionAddress);
    }

    public static void glPathCommandsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLubyte const *") ByteBuffer commands, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") float[] coords) {
        long __functionAddress = GL.getICD().glPathCommandsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(path, commands.remaining(), MemoryUtil.memAddress(commands), coords.length, coordType, coords, __functionAddress);
    }

    public static void glPathCoordsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") short[] coords) {
        long __functionAddress = GL.getICD().glPathCoordsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(path, coords.length, coordType, coords, __functionAddress);
    }

    public static void glPathCoordsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") float[] coords) {
        long __functionAddress = GL.getICD().glPathCoordsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(path, coords.length, coordType, coords, __functionAddress);
    }

    public static void glPathSubCommandsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLsizei") int commandStart, @NativeType(value="GLsizei") int commandsToDelete, @NativeType(value="GLubyte const *") ByteBuffer commands, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") short[] coords) {
        long __functionAddress = GL.getICD().glPathSubCommandsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(path, commandStart, commandsToDelete, commands.remaining(), MemoryUtil.memAddress(commands), coords.length, coordType, coords, __functionAddress);
    }

    public static void glPathSubCommandsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLsizei") int commandStart, @NativeType(value="GLsizei") int commandsToDelete, @NativeType(value="GLubyte const *") ByteBuffer commands, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") float[] coords) {
        long __functionAddress = GL.getICD().glPathSubCommandsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(path, commandStart, commandsToDelete, commands.remaining(), MemoryUtil.memAddress(commands), coords.length, coordType, coords, __functionAddress);
    }

    public static void glPathSubCoordsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLsizei") int coordStart, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") short[] coords) {
        long __functionAddress = GL.getICD().glPathSubCoordsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(path, coordStart, coords.length, coordType, coords, __functionAddress);
    }

    public static void glPathSubCoordsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLsizei") int coordStart, @NativeType(value="GLenum") int coordType, @NativeType(value="void const *") float[] coords) {
        long __functionAddress = GL.getICD().glPathSubCoordsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(path, coordStart, coords.length, coordType, coords, __functionAddress);
    }

    public static void glWeightPathsNV(@NativeType(value="GLuint") int resultPath, @NativeType(value="GLuint const *") int[] paths, @NativeType(value="GLfloat const *") float[] weights) {
        long __functionAddress = GL.getICD().glWeightPathsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(weights, paths.length);
        }
        JNI.callPPV(resultPath, paths.length, paths, weights, __functionAddress);
    }

    public static void glTransformPathNV(@NativeType(value="GLuint") int resultPath, @NativeType(value="GLuint") int srcPath, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat const *") float[] transformValues) {
        long __functionAddress = GL.getICD().glTransformPathNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(transformValues, NVPathRendering.transformTypeToElements(transformType));
        }
        JNI.callPV(resultPath, srcPath, transformType, transformValues, __functionAddress);
    }

    public static void glPathParameterivNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glPathParameterivNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(path, pname, value, __functionAddress);
    }

    public static void glPathParameterfvNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glPathParameterfvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(path, pname, value, __functionAddress);
    }

    public static void glPathDashArrayNV(@NativeType(value="GLuint") int path, @NativeType(value="GLfloat const *") float[] dashArray) {
        long __functionAddress = GL.getICD().glPathDashArrayNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(path, dashArray.length, dashArray, __functionAddress);
    }

    public static void glStencilFillPathInstancedNV(@NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLenum") int fillMode, @NativeType(value="GLuint") int mask, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat const *") float[] transformValues) {
        long __functionAddress = GL.getICD().glStencilFillPathInstancedNV;
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(transformValues, numPaths * NVPathRendering.transformTypeToElements(transformType));
        }
        JNI.callPPV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, fillMode, mask, transformType, transformValues, __functionAddress);
    }

    public static void glStencilStrokePathInstancedNV(@NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLint") int reference, @NativeType(value="GLuint") int mask, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat const *") float[] transformValues) {
        long __functionAddress = GL.getICD().glStencilStrokePathInstancedNV;
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(transformValues, numPaths * NVPathRendering.transformTypeToElements(transformType));
        }
        JNI.callPPV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, reference, mask, transformType, transformValues, __functionAddress);
    }

    public static void glPathColorGenNV(@NativeType(value="GLenum") int color, @NativeType(value="GLenum") int genMode, @NativeType(value="GLenum") int colorFormat, @NativeType(value="GLfloat const *") float[] coeffs) {
        long __functionAddress = GL.getICD().glPathColorGenNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coeffs, NVPathRendering.genModeToElements(genMode) * NVPathRendering.colorFormatToComponents(colorFormat));
        }
        JNI.callPV(color, genMode, colorFormat, coeffs, __functionAddress);
    }

    public static void glPathTexGenNV(@NativeType(value="GLenum") int texCoordSet, @NativeType(value="GLenum") int genMode, @NativeType(value="GLint") int components, @NativeType(value="GLfloat const *") float[] coeffs) {
        long __functionAddress = GL.getICD().glPathTexGenNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coeffs, NVPathRendering.genModeToElements(genMode) * components);
        }
        JNI.callPV(texCoordSet, genMode, components, coeffs, __functionAddress);
    }

    public static void glCoverFillPathInstancedNV(@NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLenum") int coverMode, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat const *") float[] transformValues) {
        long __functionAddress = GL.getICD().glCoverFillPathInstancedNV;
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(transformValues, numPaths * NVPathRendering.transformTypeToElements(transformType));
        }
        JNI.callPPV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, coverMode, transformType, transformValues, __functionAddress);
    }

    public static void glCoverStrokePathInstancedNV(@NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLenum") int coverMode, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat const *") float[] transformValues) {
        long __functionAddress = GL.getICD().glCoverStrokePathInstancedNV;
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(transformValues, numPaths * NVPathRendering.transformTypeToElements(transformType));
        }
        JNI.callPPV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, coverMode, transformType, transformValues, __functionAddress);
    }

    public static void glStencilThenCoverFillPathInstancedNV(@NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLenum") int fillMode, @NativeType(value="GLuint") int mask, @NativeType(value="GLenum") int coverMode, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat const *") float[] transformValues) {
        long __functionAddress = GL.getICD().glStencilThenCoverFillPathInstancedNV;
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(transformValues, numPaths * NVPathRendering.transformTypeToElements(transformType));
        }
        JNI.callPPV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, fillMode, mask, coverMode, transformType, transformValues, __functionAddress);
    }

    public static void glStencilThenCoverStrokePathInstancedNV(@NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLint") int reference, @NativeType(value="GLuint") int mask, @NativeType(value="GLenum") int coverMode, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat const *") float[] transformValues) {
        long __functionAddress = GL.getICD().glStencilThenCoverStrokePathInstancedNV;
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(transformValues, numPaths * NVPathRendering.transformTypeToElements(transformType));
        }
        JNI.callPPV(numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, reference, mask, coverMode, transformType, transformValues, __functionAddress);
    }

    public static void glProgramPathFragmentInputGenNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLenum") int genMode, @NativeType(value="GLint") int components, @NativeType(value="GLfloat const *") float[] coeffs) {
        long __functionAddress = GL.getICD().glProgramPathFragmentInputGenNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coeffs, NVPathRendering.genModeToElements(genMode) * components);
        }
        JNI.callPV(program, location, genMode, components, coeffs, __functionAddress);
    }

    public static void glGetPathParameterivNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] value) {
        long __functionAddress = GL.getICD().glGetPathParameterivNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(path, pname, value, __functionAddress);
    }

    public static void glGetPathParameterfvNV(@NativeType(value="GLuint") int path, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] value) {
        long __functionAddress = GL.getICD().glGetPathParameterfvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(path, pname, value, __functionAddress);
    }

    public static void glGetPathCoordsNV(@NativeType(value="GLuint") int path, @NativeType(value="GLfloat *") float[] coords) {
        long __functionAddress = GL.getICD().glGetPathCoordsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            if (Checks.DEBUG) {
                Checks.check(coords, NVPathRendering.glGetPathParameteriNV(path, 37022));
            }
        }
        JNI.callPV(path, coords, __functionAddress);
    }

    public static void glGetPathDashArrayNV(@NativeType(value="GLuint") int path, @NativeType(value="GLfloat *") float[] dashArray) {
        long __functionAddress = GL.getICD().glGetPathDashArrayNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            if (Checks.DEBUG) {
                Checks.check(dashArray, NVPathRendering.glGetPathParameteriNV(path, 37023));
            }
        }
        JNI.callPV(path, dashArray, __functionAddress);
    }

    public static void glGetPathMetricsNV(@NativeType(value="GLbitfield") int metricQueryMask, @NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLsizei") int stride, @NativeType(value="GLfloat *") float[] metrics) {
        long __functionAddress = GL.getICD().glGetPathMetricsNV;
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(metrics, numPaths * (stride == 0 ? Integer.bitCount(metricQueryMask) : stride >> 2));
        }
        JNI.callPPV(metricQueryMask, numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, stride, metrics, __functionAddress);
    }

    public static void glGetPathMetricRangeNV(@NativeType(value="GLbitfield") int metricQueryMask, @NativeType(value="GLuint") int firstPathName, @NativeType(value="GLsizei") int numPaths, @NativeType(value="GLsizei") int stride, @NativeType(value="GLfloat *") float[] metrics) {
        long __functionAddress = GL.getICD().glGetPathMetricRangeNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(metrics, numPaths * (stride == 0 ? Integer.bitCount(metricQueryMask) : stride >> 2));
        }
        JNI.callPV(metricQueryMask, firstPathName, numPaths, stride, metrics, __functionAddress);
    }

    public static void glGetPathSpacingNV(@NativeType(value="GLenum") int pathListMode, @NativeType(value="GLenum") int pathNameType, @NativeType(value="void const *") ByteBuffer paths, @NativeType(value="GLuint") int pathBase, @NativeType(value="GLfloat") float advanceScale, @NativeType(value="GLfloat") float kerningScale, @NativeType(value="GLenum") int transformType, @NativeType(value="GLfloat *") float[] returnedSpacing) {
        long __functionAddress = GL.getICD().glGetPathSpacingNV;
        int numPaths = paths.remaining() / NVPathRendering.pathNameTypeToBytes(pathNameType);
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(returnedSpacing, (numPaths - 1) * (transformType == 37006 ? 1 : 2));
        }
        JNI.callPPV(pathListMode, numPaths, pathNameType, MemoryUtil.memAddress(paths), pathBase, advanceScale, kerningScale, transformType, returnedSpacing, __functionAddress);
    }

    public static void glGetPathColorGenivNV(@NativeType(value="GLenum") int color, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] value) {
        long __functionAddress = GL.getICD().glGetPathColorGenivNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(color, pname, value, __functionAddress);
    }

    public static void glGetPathColorGenfvNV(@NativeType(value="GLenum") int color, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] value) {
        long __functionAddress = GL.getICD().glGetPathColorGenfvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(color, pname, value, __functionAddress);
    }

    public static void glGetPathTexGenivNV(@NativeType(value="GLenum") int texCoordSet, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] value) {
        long __functionAddress = GL.getICD().glGetPathTexGenivNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(texCoordSet, pname, value, __functionAddress);
    }

    public static void glGetPathTexGenfvNV(@NativeType(value="GLenum") int texCoordSet, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] value) {
        long __functionAddress = GL.getICD().glGetPathTexGenfvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(texCoordSet, pname, value, __functionAddress);
    }

    @NativeType(value="GLboolean")
    public static boolean glPointAlongPathNV(@NativeType(value="GLuint") int path, @NativeType(value="GLsizei") int startSegment, @NativeType(value="GLsizei") int numSegments, @NativeType(value="GLfloat") float distance, @Nullable @NativeType(value="GLfloat *") float[] x, @Nullable @NativeType(value="GLfloat *") float[] y, @Nullable @NativeType(value="GLfloat *") float[] tangentX, @Nullable @NativeType(value="GLfloat *") float[] tangentY) {
        long __functionAddress = GL.getICD().glPointAlongPathNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(x, 1);
            Checks.checkSafe(y, 1);
            Checks.checkSafe(tangentX, 1);
            Checks.checkSafe(tangentY, 1);
        }
        return JNI.callPPPPZ(path, startSegment, numSegments, distance, x, y, tangentX, tangentY, __functionAddress);
    }

    public static void glMatrixLoad3x2fNV(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glMatrixLoad3x2fNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 6);
        }
        JNI.callPV(matrixMode, m, __functionAddress);
    }

    public static void glMatrixLoad3x3fNV(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glMatrixLoad3x3fNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 9);
        }
        JNI.callPV(matrixMode, m, __functionAddress);
    }

    public static void glMatrixLoadTranspose3x3fNV(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glMatrixLoadTranspose3x3fNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 9);
        }
        JNI.callPV(matrixMode, m, __functionAddress);
    }

    public static void glMatrixMult3x2fNV(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glMatrixMult3x2fNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 6);
        }
        JNI.callPV(matrixMode, m, __functionAddress);
    }

    public static void glMatrixMult3x3fNV(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glMatrixMult3x3fNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 9);
        }
        JNI.callPV(matrixMode, m, __functionAddress);
    }

    public static void glMatrixMultTranspose3x3fNV(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glMatrixMultTranspose3x3fNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 9);
        }
        JNI.callPV(matrixMode, m, __functionAddress);
    }

    public static void glGetProgramResourcefvNV(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLuint") int index, @NativeType(value="GLenum const *") int[] props, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetProgramResourcefvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
        }
        JNI.callPPPV(program, programInterface, index, props.length, props, params.length, length, params, __functionAddress);
    }

    private static int charcodeTypeToBytes(int type) {
        switch (type) {
            case 5121: 
            case 37018: {
                return 1;
            }
            case 5123: 
            case 5127: 
            case 37019: {
                return 2;
            }
            case 5128: {
                return 3;
            }
            case 5125: 
            case 5129: {
                return 4;
            }
        }
        throw new IllegalArgumentException(String.format("Unsupported charcode type: 0x%X", type));
    }

    private static int pathNameTypeToBytes(int type) {
        switch (type) {
            case 5120: 
            case 5121: 
            case 37018: {
                return 1;
            }
            case 5122: 
            case 5123: 
            case 5127: 
            case 37019: {
                return 2;
            }
            case 5128: {
                return 3;
            }
            case 5124: 
            case 5125: 
            case 5129: {
                return 4;
            }
        }
        throw new IllegalArgumentException(String.format("Unsupported path name type: 0x%X", type));
    }

    private static int transformTypeToElements(int type) {
        switch (type) {
            case 0: {
                return 0;
            }
            case 37006: 
            case 37007: {
                return 1;
            }
            case 37008: {
                return 2;
            }
            case 37009: {
                return 3;
            }
            case 37010: 
            case 37014: {
                return 6;
            }
            case 37012: 
            case 37016: {
                return 12;
            }
        }
        throw new IllegalArgumentException(String.format("Unsupported transform type: 0x%X", type));
    }

    private static int colorFormatToComponents(int colorFormat) {
        switch (colorFormat) {
            case 6406: 
            case 6409: 
            case 32841: {
                return 1;
            }
            case 6410: {
                return 2;
            }
            case 6407: {
                return 3;
            }
            case 6408: {
                return 4;
            }
        }
        throw new IllegalArgumentException(String.format("Unsupported colorFormat specified: 0x%X", colorFormat));
    }

    private static int genModeToElements(int genMode) {
        switch (genMode) {
            case 0: {
                return 0;
            }
            case 34166: {
                return 1;
            }
            case 9217: 
            case 37002: {
                return 3;
            }
            case 9216: {
                return 4;
            }
        }
        throw new IllegalArgumentException(String.format("Unsupported genMode specified: 0x%X", genMode));
    }

    static {
        GL.initialize();
    }
}

