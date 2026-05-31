/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBProgramInterfaceQuery {
    public static final int GL_UNIFORM = 37601;
    public static final int GL_UNIFORM_BLOCK = 37602;
    public static final int GL_PROGRAM_INPUT = 37603;
    public static final int GL_PROGRAM_OUTPUT = 37604;
    public static final int GL_BUFFER_VARIABLE = 37605;
    public static final int GL_SHADER_STORAGE_BLOCK = 37606;
    public static final int GL_VERTEX_SUBROUTINE = 37608;
    public static final int GL_TESS_CONTROL_SUBROUTINE = 37609;
    public static final int GL_TESS_EVALUATION_SUBROUTINE = 37610;
    public static final int GL_GEOMETRY_SUBROUTINE = 37611;
    public static final int GL_FRAGMENT_SUBROUTINE = 37612;
    public static final int GL_COMPUTE_SUBROUTINE = 37613;
    public static final int GL_VERTEX_SUBROUTINE_UNIFORM = 37614;
    public static final int GL_TESS_CONTROL_SUBROUTINE_UNIFORM = 37615;
    public static final int GL_TESS_EVALUATION_SUBROUTINE_UNIFORM = 37616;
    public static final int GL_GEOMETRY_SUBROUTINE_UNIFORM = 37617;
    public static final int GL_FRAGMENT_SUBROUTINE_UNIFORM = 37618;
    public static final int GL_COMPUTE_SUBROUTINE_UNIFORM = 37619;
    public static final int GL_TRANSFORM_FEEDBACK_VARYING = 37620;
    public static final int GL_ACTIVE_RESOURCES = 37621;
    public static final int GL_MAX_NAME_LENGTH = 37622;
    public static final int GL_MAX_NUM_ACTIVE_VARIABLES = 37623;
    public static final int GL_MAX_NUM_COMPATIBLE_SUBROUTINES = 37624;
    public static final int GL_NAME_LENGTH = 37625;
    public static final int GL_TYPE = 37626;
    public static final int GL_ARRAY_SIZE = 37627;
    public static final int GL_OFFSET = 37628;
    public static final int GL_BLOCK_INDEX = 37629;
    public static final int GL_ARRAY_STRIDE = 37630;
    public static final int GL_MATRIX_STRIDE = 37631;
    public static final int GL_IS_ROW_MAJOR = 37632;
    public static final int GL_ATOMIC_COUNTER_BUFFER_INDEX = 37633;
    public static final int GL_BUFFER_BINDING = 37634;
    public static final int GL_BUFFER_DATA_SIZE = 37635;
    public static final int GL_NUM_ACTIVE_VARIABLES = 37636;
    public static final int GL_ACTIVE_VARIABLES = 37637;
    public static final int GL_REFERENCED_BY_VERTEX_SHADER = 37638;
    public static final int GL_REFERENCED_BY_TESS_CONTROL_SHADER = 37639;
    public static final int GL_REFERENCED_BY_TESS_EVALUATION_SHADER = 37640;
    public static final int GL_REFERENCED_BY_GEOMETRY_SHADER = 37641;
    public static final int GL_REFERENCED_BY_FRAGMENT_SHADER = 37642;
    public static final int GL_REFERENCED_BY_COMPUTE_SHADER = 37643;
    public static final int GL_TOP_LEVEL_ARRAY_SIZE = 37644;
    public static final int GL_TOP_LEVEL_ARRAY_STRIDE = 37645;
    public static final int GL_LOCATION = 37646;
    public static final int GL_LOCATION_INDEX = 37647;
    public static final int GL_IS_PER_PATCH = 37607;

    protected ARBProgramInterfaceQuery() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGetProgramInterfaceiv, caps.glGetProgramResourceIndex, caps.glGetProgramResourceName, caps.glGetProgramResourceiv, caps.glGetProgramResourceLocation, caps.glGetProgramResourceLocationIndex);
    }

    public static void nglGetProgramInterfaceiv(int program, int programInterface, int pname, long params) {
        GL43C.nglGetProgramInterfaceiv(program, programInterface, pname, params);
    }

    public static void glGetProgramInterfaceiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL43C.glGetProgramInterfaceiv(program, programInterface, pname, params);
    }

    @NativeType(value="void")
    public static int glGetProgramInterfacei(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLenum") int pname) {
        return GL43C.glGetProgramInterfacei(program, programInterface, pname);
    }

    public static int nglGetProgramResourceIndex(int program, int programInterface, long name) {
        return GL43C.nglGetProgramResourceIndex(program, programInterface, name);
    }

    @NativeType(value="GLuint")
    public static int glGetProgramResourceIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLchar const *") ByteBuffer name) {
        return GL43C.glGetProgramResourceIndex(program, programInterface, name);
    }

    @NativeType(value="GLuint")
    public static int glGetProgramResourceIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLchar const *") CharSequence name) {
        return GL43C.glGetProgramResourceIndex(program, programInterface, name);
    }

    public static void nglGetProgramResourceName(int program, int programInterface, int index, int bufSize, long length, long name) {
        GL43C.nglGetProgramResourceName(program, programInterface, index, bufSize, length, name);
    }

    public static void glGetProgramResourceName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer name) {
        GL43C.glGetProgramResourceName(program, programInterface, index, length, name);
    }

    @NativeType(value="void")
    public static String glGetProgramResourceName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int bufSize) {
        return GL43C.glGetProgramResourceName(program, programInterface, index, bufSize);
    }

    @NativeType(value="void")
    public static String glGetProgramResourceName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLuint") int index) {
        return ARBProgramInterfaceQuery.glGetProgramResourceName(program, programInterface, index, ARBProgramInterfaceQuery.glGetProgramInterfacei(program, programInterface, 37622));
    }

    public static void nglGetProgramResourceiv(int program, int programInterface, int index, int propCount, long props, int bufSize, long length, long params) {
        GL43C.nglGetProgramResourceiv(program, programInterface, index, propCount, props, bufSize, length, params);
    }

    public static void glGetProgramResourceiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLuint") int index, @NativeType(value="GLenum const *") IntBuffer props, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLint *") IntBuffer params) {
        GL43C.glGetProgramResourceiv(program, programInterface, index, props, length, params);
    }

    public static int nglGetProgramResourceLocation(int program, int programInterface, long name) {
        return GL43C.nglGetProgramResourceLocation(program, programInterface, name);
    }

    @NativeType(value="GLint")
    public static int glGetProgramResourceLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLchar const *") ByteBuffer name) {
        return GL43C.glGetProgramResourceLocation(program, programInterface, name);
    }

    @NativeType(value="GLint")
    public static int glGetProgramResourceLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLchar const *") CharSequence name) {
        return GL43C.glGetProgramResourceLocation(program, programInterface, name);
    }

    public static int nglGetProgramResourceLocationIndex(int program, int programInterface, long name) {
        return GL43C.nglGetProgramResourceLocationIndex(program, programInterface, name);
    }

    @NativeType(value="GLint")
    public static int glGetProgramResourceLocationIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLchar const *") ByteBuffer name) {
        return GL43C.glGetProgramResourceLocationIndex(program, programInterface, name);
    }

    @NativeType(value="GLint")
    public static int glGetProgramResourceLocationIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLchar const *") CharSequence name) {
        return GL43C.glGetProgramResourceLocationIndex(program, programInterface, name);
    }

    public static void glGetProgramInterfaceiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL43C.glGetProgramInterfaceiv(program, programInterface, pname, params);
    }

    public static void glGetProgramResourceName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer name) {
        GL43C.glGetProgramResourceName(program, programInterface, index, length, name);
    }

    public static void glGetProgramResourceiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLuint") int index, @NativeType(value="GLenum const *") int[] props, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLint *") int[] params) {
        GL43C.glGetProgramResourceiv(program, programInterface, index, props, length, params);
    }

    static {
        GL.initialize();
    }
}

