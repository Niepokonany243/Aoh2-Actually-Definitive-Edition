/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.glutils.InstanceData;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class InstanceBufferObjectSubData
implements InstanceData {
    final VertexAttributes attributes;
    final FloatBuffer buffer;
    final ByteBuffer byteBuffer;
    int bufferHandle;
    final boolean isDirect;
    final boolean isStatic;
    final int usage;
    boolean isDirty = false;
    boolean isBound = false;

    public InstanceBufferObjectSubData(boolean isStatic, int numInstances, VertexAttribute ... instanceAttributes) {
        this(isStatic, numInstances, new VertexAttributes(instanceAttributes));
    }

    public InstanceBufferObjectSubData(boolean isStatic, int numInstances, VertexAttributes instanceAttributes) {
        this.isStatic = isStatic;
        this.attributes = instanceAttributes;
        this.byteBuffer = BufferUtils.newByteBuffer(this.attributes.vertexSize * numInstances);
        this.isDirect = true;
        this.usage = isStatic ? 35044 : 35048;
        this.buffer = this.byteBuffer.asFloatBuffer();
        this.bufferHandle = this.createBufferObject();
        ((Buffer)this.buffer).flip();
        ((Buffer)this.byteBuffer).flip();
    }

    private int createBufferObject() {
        int result = Gdx.gl20.glGenBuffer();
        Gdx.gl20.glBindBuffer(34962, result);
        Gdx.gl20.glBufferData(34962, this.byteBuffer.capacity(), null, this.usage);
        Gdx.gl20.glBindBuffer(34962, 0);
        return result;
    }

    @Override
    public VertexAttributes getAttributes() {
        return this.attributes;
    }

    @Override
    public int getNumInstances() {
        return this.buffer.limit() * 4 / this.attributes.vertexSize;
    }

    @Override
    public int getNumMaxInstances() {
        return this.byteBuffer.capacity() / this.attributes.vertexSize;
    }

    @Override
    public FloatBuffer getBuffer() {
        this.isDirty = true;
        return this.buffer;
    }

    private void bufferChanged() {
        if (this.isBound) {
            Gdx.gl20.glBufferData(34962, this.byteBuffer.limit(), null, this.usage);
            Gdx.gl20.glBufferSubData(34962, 0, this.byteBuffer.limit(), this.byteBuffer);
            this.isDirty = false;
        }
    }

    @Override
    public void setInstanceData(float[] data, int offset, int count) {
        this.isDirty = true;
        if (this.isDirect) {
            BufferUtils.copy(data, this.byteBuffer, count, offset);
            ((Buffer)this.buffer).position(0);
            ((Buffer)this.buffer).limit(count);
        } else {
            ((Buffer)this.buffer).clear();
            this.buffer.put(data, offset, count);
            ((Buffer)this.buffer).flip();
            ((Buffer)this.byteBuffer).position(0);
            ((Buffer)this.byteBuffer).limit(this.buffer.limit() << 2);
        }
        this.bufferChanged();
    }

    @Override
    public void setInstanceData(FloatBuffer data, int count) {
        this.isDirty = true;
        if (this.isDirect) {
            BufferUtils.copy(data, this.byteBuffer, count);
            ((Buffer)this.buffer).position(0);
            ((Buffer)this.buffer).limit(count);
        } else {
            ((Buffer)this.buffer).clear();
            this.buffer.put(data);
            ((Buffer)this.buffer).flip();
            ((Buffer)this.byteBuffer).position(0);
            ((Buffer)this.byteBuffer).limit(this.buffer.limit() << 2);
        }
        this.bufferChanged();
    }

    @Override
    public void updateInstanceData(int targetOffset, float[] data, int sourceOffset, int count) {
        this.isDirty = true;
        if (!this.isDirect) {
            throw new GdxRuntimeException("Buffer must be allocated direct.");
        }
        int pos = this.byteBuffer.position();
        ((Buffer)this.byteBuffer).position(targetOffset * 4);
        BufferUtils.copy(data, sourceOffset, count, (Buffer)this.byteBuffer);
        ((Buffer)this.byteBuffer).position(pos);
        this.bufferChanged();
    }

    @Override
    public void updateInstanceData(int targetOffset, FloatBuffer data, int sourceOffset, int count) {
        this.isDirty = true;
        if (!this.isDirect) {
            throw new GdxRuntimeException("Buffer must be allocated direct.");
        }
        int pos = this.byteBuffer.position();
        ((Buffer)this.byteBuffer).position(targetOffset * 4);
        ((Buffer)data).position(sourceOffset * 4);
        BufferUtils.copy(data, this.byteBuffer, count);
        ((Buffer)this.byteBuffer).position(pos);
        this.bufferChanged();
    }

    @Override
    public void bind(ShaderProgram shader) {
        this.bind(shader, null);
    }

    @Override
    public void bind(ShaderProgram shader, int[] locations) {
        GL20 gl = Gdx.gl20;
        gl.glBindBuffer(34962, this.bufferHandle);
        if (this.isDirty) {
            ((Buffer)this.byteBuffer).limit(this.buffer.limit() * 4);
            gl.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
        int numAttributes = this.attributes.size();
        if (locations == null) {
            for (int i = 0; i < numAttributes; ++i) {
                VertexAttribute attribute = this.attributes.get(i);
                int location = shader.getAttributeLocation(attribute.alias);
                if (location < 0) continue;
                int unitOffset = attribute.unit;
                shader.enableVertexAttribute(location + unitOffset);
                shader.setVertexAttribute(location + unitOffset, attribute.numComponents, attribute.type, attribute.normalized, this.attributes.vertexSize, attribute.offset);
                Gdx.gl30.glVertexAttribDivisor(location + unitOffset, 1);
            }
        } else {
            for (int i = 0; i < numAttributes; ++i) {
                VertexAttribute attribute = this.attributes.get(i);
                int location = locations[i];
                if (location < 0) continue;
                int unitOffset = attribute.unit;
                shader.enableVertexAttribute(location + unitOffset);
                shader.setVertexAttribute(location + unitOffset, attribute.numComponents, attribute.type, attribute.normalized, this.attributes.vertexSize, attribute.offset);
                Gdx.gl30.glVertexAttribDivisor(location + unitOffset, 1);
            }
        }
        this.isBound = true;
    }

    @Override
    public void unbind(ShaderProgram shader) {
        this.unbind(shader, null);
    }

    @Override
    public void unbind(ShaderProgram shader, int[] locations) {
        GL20 gl = Gdx.gl20;
        int numAttributes = this.attributes.size();
        if (locations == null) {
            for (int i = 0; i < numAttributes; ++i) {
                VertexAttribute attribute = this.attributes.get(i);
                int location = shader.getAttributeLocation(attribute.alias);
                if (location < 0) continue;
                int unitOffset = attribute.unit;
                shader.disableVertexAttribute(location + unitOffset);
            }
        } else {
            for (int i = 0; i < numAttributes; ++i) {
                VertexAttribute attribute = this.attributes.get(i);
                int location = locations[i];
                if (location < 0) continue;
                int unitOffset = attribute.unit;
                shader.enableVertexAttribute(location + unitOffset);
            }
        }
        gl.glBindBuffer(34962, 0);
        this.isBound = false;
    }

    @Override
    public void invalidate() {
        this.bufferHandle = this.createBufferObject();
        this.isDirty = true;
    }

    @Override
    public void dispose() {
        GL20 gl = Gdx.gl20;
        gl.glBindBuffer(34962, 0);
        gl.glDeleteBuffer(this.bufferHandle);
        this.bufferHandle = 0;
    }

    public int getBufferHandle() {
        return this.bufferHandle;
    }
}

