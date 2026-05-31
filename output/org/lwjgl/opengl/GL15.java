/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class GL15
extends GL14 {
    public static final int GL_FOG_COORD_SRC = 33872;
    public static final int GL_FOG_COORD = 33873;
    public static final int GL_CURRENT_FOG_COORD = 33875;
    public static final int GL_FOG_COORD_ARRAY_TYPE = 33876;
    public static final int GL_FOG_COORD_ARRAY_STRIDE = 33877;
    public static final int GL_FOG_COORD_ARRAY_POINTER = 33878;
    public static final int GL_FOG_COORD_ARRAY = 33879;
    public static final int GL_FOG_COORD_ARRAY_BUFFER_BINDING = 34973;
    public static final int GL_SRC0_RGB = 34176;
    public static final int GL_SRC1_RGB = 34177;
    public static final int GL_SRC2_RGB = 34178;
    public static final int GL_SRC0_ALPHA = 34184;
    public static final int GL_SRC1_ALPHA = 34185;
    public static final int GL_SRC2_ALPHA = 34186;
    public static final int GL_ARRAY_BUFFER = 34962;
    public static final int GL_ELEMENT_ARRAY_BUFFER = 34963;
    public static final int GL_ARRAY_BUFFER_BINDING = 34964;
    public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 34965;
    public static final int GL_VERTEX_ARRAY_BUFFER_BINDING = 34966;
    public static final int GL_NORMAL_ARRAY_BUFFER_BINDING = 34967;
    public static final int GL_COLOR_ARRAY_BUFFER_BINDING = 34968;
    public static final int GL_INDEX_ARRAY_BUFFER_BINDING = 34969;
    public static final int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING = 34970;
    public static final int GL_EDGE_FLAG_ARRAY_BUFFER_BINDING = 34971;
    public static final int GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING = 34972;
    public static final int GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING = 34973;
    public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING = 34974;
    public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 34975;
    public static final int GL_STREAM_DRAW = 35040;
    public static final int GL_STREAM_READ = 35041;
    public static final int GL_STREAM_COPY = 35042;
    public static final int GL_STATIC_DRAW = 35044;
    public static final int GL_STATIC_READ = 35045;
    public static final int GL_STATIC_COPY = 35046;
    public static final int GL_DYNAMIC_DRAW = 35048;
    public static final int GL_DYNAMIC_READ = 35049;
    public static final int GL_DYNAMIC_COPY = 35050;
    public static final int GL_READ_ONLY = 35000;
    public static final int GL_WRITE_ONLY = 35001;
    public static final int GL_READ_WRITE = 35002;
    public static final int GL_BUFFER_SIZE = 34660;
    public static final int GL_BUFFER_USAGE = 34661;
    public static final int GL_BUFFER_ACCESS = 35003;
    public static final int GL_BUFFER_MAPPED = 35004;
    public static final int GL_BUFFER_MAP_POINTER = 35005;
    public static final int GL_SAMPLES_PASSED = 35092;
    public static final int GL_QUERY_COUNTER_BITS = 34916;
    public static final int GL_CURRENT_QUERY = 34917;
    public static final int GL_QUERY_RESULT = 34918;
    public static final int GL_QUERY_RESULT_AVAILABLE = 34919;

    protected GL15() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBindBuffer, caps.glDeleteBuffers, caps.glGenBuffers, caps.glIsBuffer, caps.glBufferData, caps.glBufferSubData, caps.glGetBufferSubData, caps.glMapBuffer, caps.glUnmapBuffer, caps.glGetBufferParameteriv, caps.glGetBufferPointerv, caps.glGenQueries, caps.glDeleteQueries, caps.glIsQuery, caps.glBeginQuery, caps.glEndQuery, caps.glGetQueryiv, caps.glGetQueryObjectiv, caps.glGetQueryObjectuiv);
    }

    public static void glBindBuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int buffer) {
        GL15C.glBindBuffer(target, buffer);
    }

    public static void nglDeleteBuffers(int n, long buffers) {
        GL15C.nglDeleteBuffers(n, buffers);
    }

    public static void glDeleteBuffers(@NativeType(value="GLuint const *") IntBuffer buffers) {
        GL15C.glDeleteBuffers(buffers);
    }

    public static void glDeleteBuffers(@NativeType(value="GLuint const *") int buffer) {
        GL15C.glDeleteBuffers(buffer);
    }

    public static void nglGenBuffers(int n, long buffers) {
        GL15C.nglGenBuffers(n, buffers);
    }

    public static void glGenBuffers(@NativeType(value="GLuint *") IntBuffer buffers) {
        GL15C.glGenBuffers(buffers);
    }

    @NativeType(value="void")
    public static int glGenBuffers() {
        return GL15C.glGenBuffers();
    }

    @NativeType(value="GLboolean")
    public static boolean glIsBuffer(@NativeType(value="GLuint") int buffer) {
        return GL15C.glIsBuffer(buffer);
    }

    public static void nglBufferData(int target, long size, long data, int usage) {
        GL15C.nglBufferData(target, size, data, usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int usage) {
        GL15C.glBufferData(target, size, usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") ByteBuffer data, @NativeType(value="GLenum") int usage) {
        GL15C.glBufferData(target, data, usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") ShortBuffer data, @NativeType(value="GLenum") int usage) {
        GL15C.glBufferData(target, data, usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") IntBuffer data, @NativeType(value="GLenum") int usage) {
        GL15C.glBufferData(target, data, usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") LongBuffer data, @NativeType(value="GLenum") int usage) {
        GL15C.glBufferData(target, data, usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") FloatBuffer data, @NativeType(value="GLenum") int usage) {
        GL15C.glBufferData(target, data, usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") DoubleBuffer data, @NativeType(value="GLenum") int usage) {
        GL15C.glBufferData(target, data, usage);
    }

    public static void nglBufferSubData(int target, long offset, long size, long data) {
        GL15C.nglBufferSubData(target, offset, size, data);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") ByteBuffer data) {
        GL15C.glBufferSubData(target, offset, data);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") ShortBuffer data) {
        GL15C.glBufferSubData(target, offset, data);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") IntBuffer data) {
        GL15C.glBufferSubData(target, offset, data);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") LongBuffer data) {
        GL15C.glBufferSubData(target, offset, data);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") FloatBuffer data) {
        GL15C.glBufferSubData(target, offset, data);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") DoubleBuffer data) {
        GL15C.glBufferSubData(target, offset, data);
    }

    public static void nglGetBufferSubData(int target, long offset, long size, long data) {
        GL15C.nglGetBufferSubData(target, offset, size, data);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") ByteBuffer data) {
        GL15C.glGetBufferSubData(target, offset, data);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") ShortBuffer data) {
        GL15C.glGetBufferSubData(target, offset, data);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") IntBuffer data) {
        GL15C.glGetBufferSubData(target, offset, data);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") LongBuffer data) {
        GL15C.glGetBufferSubData(target, offset, data);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") FloatBuffer data) {
        GL15C.glGetBufferSubData(target, offset, data);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") DoubleBuffer data) {
        GL15C.glGetBufferSubData(target, offset, data);
    }

    public static long nglMapBuffer(int target, int access) {
        return GL15C.nglMapBuffer(target, access);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int access) {
        return GL15C.glMapBuffer(target, access);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int access, @Nullable ByteBuffer old_buffer) {
        return GL15C.glMapBuffer(target, access, old_buffer);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int access, long length, @Nullable ByteBuffer old_buffer) {
        return GL15C.glMapBuffer(target, access, length, old_buffer);
    }

    @NativeType(value="GLboolean")
    public static boolean glUnmapBuffer(@NativeType(value="GLenum") int target) {
        return GL15C.glUnmapBuffer(target);
    }

    public static void nglGetBufferParameteriv(int target, int pname, long params) {
        GL15C.nglGetBufferParameteriv(target, pname, params);
    }

    public static void glGetBufferParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL15C.glGetBufferParameteriv(target, pname, params);
    }

    @NativeType(value="void")
    public static int glGetBufferParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        return GL15C.glGetBufferParameteri(target, pname);
    }

    public static void nglGetBufferPointerv(int target, int pname, long params) {
        GL15C.nglGetBufferPointerv(target, pname, params);
    }

    public static void glGetBufferPointerv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="void **") PointerBuffer params) {
        GL15C.glGetBufferPointerv(target, pname, params);
    }

    @NativeType(value="void")
    public static long glGetBufferPointer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        return GL15C.glGetBufferPointer(target, pname);
    }

    public static void nglGenQueries(int n, long ids) {
        GL15C.nglGenQueries(n, ids);
    }

    public static void glGenQueries(@NativeType(value="GLuint *") IntBuffer ids) {
        GL15C.glGenQueries(ids);
    }

    @NativeType(value="void")
    public static int glGenQueries() {
        return GL15C.glGenQueries();
    }

    public static void nglDeleteQueries(int n, long ids) {
        GL15C.nglDeleteQueries(n, ids);
    }

    public static void glDeleteQueries(@NativeType(value="GLuint const *") IntBuffer ids) {
        GL15C.glDeleteQueries(ids);
    }

    public static void glDeleteQueries(@NativeType(value="GLuint const *") int id) {
        GL15C.glDeleteQueries(id);
    }

    @NativeType(value="GLboolean")
    public static boolean glIsQuery(@NativeType(value="GLuint") int id) {
        return GL15C.glIsQuery(id);
    }

    public static void glBeginQuery(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int id) {
        GL15C.glBeginQuery(target, id);
    }

    public static void glEndQuery(@NativeType(value="GLenum") int target) {
        GL15C.glEndQuery(target);
    }

    public static void nglGetQueryiv(int target, int pname, long params) {
        GL15C.nglGetQueryiv(target, pname, params);
    }

    public static void glGetQueryiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL15C.glGetQueryiv(target, pname, params);
    }

    @NativeType(value="void")
    public static int glGetQueryi(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        return GL15C.glGetQueryi(target, pname);
    }

    public static void nglGetQueryObjectiv(int id, int pname, long params) {
        GL15C.nglGetQueryObjectiv(id, pname, params);
    }

    public static void glGetQueryObjectiv(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL15C.glGetQueryObjectiv(id, pname, params);
    }

    @NativeType(value="void")
    public static int glGetQueryObjecti(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        return GL15C.glGetQueryObjecti(id, pname);
    }

    public static void nglGetQueryObjectuiv(int id, int pname, long params) {
        GL15C.nglGetQueryObjectuiv(id, pname, params);
    }

    public static void glGetQueryObjectuiv(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        GL15C.glGetQueryObjectuiv(id, pname, params);
    }

    @NativeType(value="void")
    public static int glGetQueryObjectui(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        return GL15C.glGetQueryObjectui(id, pname);
    }

    public static void glDeleteBuffers(@NativeType(value="GLuint const *") int[] buffers) {
        GL15C.glDeleteBuffers(buffers);
    }

    public static void glGenBuffers(@NativeType(value="GLuint *") int[] buffers) {
        GL15C.glGenBuffers(buffers);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") short[] data, @NativeType(value="GLenum") int usage) {
        GL15C.glBufferData(target, data, usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") int[] data, @NativeType(value="GLenum") int usage) {
        GL15C.glBufferData(target, data, usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") long[] data, @NativeType(value="GLenum") int usage) {
        GL15C.glBufferData(target, data, usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") float[] data, @NativeType(value="GLenum") int usage) {
        GL15C.glBufferData(target, data, usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") double[] data, @NativeType(value="GLenum") int usage) {
        GL15C.glBufferData(target, data, usage);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") short[] data) {
        GL15C.glBufferSubData(target, offset, data);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") int[] data) {
        GL15C.glBufferSubData(target, offset, data);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") long[] data) {
        GL15C.glBufferSubData(target, offset, data);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") float[] data) {
        GL15C.glBufferSubData(target, offset, data);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") double[] data) {
        GL15C.glBufferSubData(target, offset, data);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") short[] data) {
        GL15C.glGetBufferSubData(target, offset, data);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") int[] data) {
        GL15C.glGetBufferSubData(target, offset, data);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") long[] data) {
        GL15C.glGetBufferSubData(target, offset, data);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") float[] data) {
        GL15C.glGetBufferSubData(target, offset, data);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") double[] data) {
        GL15C.glGetBufferSubData(target, offset, data);
    }

    public static void glGetBufferParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL15C.glGetBufferParameteriv(target, pname, params);
    }

    public static void glGenQueries(@NativeType(value="GLuint *") int[] ids) {
        GL15C.glGenQueries(ids);
    }

    public static void glDeleteQueries(@NativeType(value="GLuint const *") int[] ids) {
        GL15C.glDeleteQueries(ids);
    }

    public static void glGetQueryiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL15C.glGetQueryiv(target, pname, params);
    }

    public static void glGetQueryObjectiv(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL15C.glGetQueryObjectiv(id, pname, params);
    }

    public static void glGetQueryObjectuiv(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        GL15C.glGetQueryObjectuiv(id, pname, params);
    }

    static {
        GL.initialize();
    }
}

