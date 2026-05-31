/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.glutils.IndexData;
import com.badlogic.gdx.utils.BufferUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class IndexArray
implements IndexData {
    final ShortBuffer buffer;
    final ByteBuffer byteBuffer;
    private final boolean empty;

    public IndexArray(int maxIndices) {
        boolean bl = this.empty = maxIndices == 0;
        if (this.empty) {
            maxIndices = 1;
        }
        this.byteBuffer = BufferUtils.newUnsafeByteBuffer(maxIndices * 2);
        this.buffer = this.byteBuffer.asShortBuffer();
        ((Buffer)this.buffer).flip();
        ((Buffer)this.byteBuffer).flip();
    }

    @Override
    public int getNumIndices() {
        return this.empty ? 0 : this.buffer.limit();
    }

    @Override
    public int getNumMaxIndices() {
        return this.empty ? 0 : this.buffer.capacity();
    }

    @Override
    public void setIndices(short[] indices, int offset, int count) {
        ((Buffer)this.buffer).clear();
        this.buffer.put(indices, offset, count);
        ((Buffer)this.buffer).flip();
        ((Buffer)this.byteBuffer).position(0);
        ((Buffer)this.byteBuffer).limit(count << 1);
    }

    @Override
    public void setIndices(ShortBuffer indices) {
        int pos = indices.position();
        ((Buffer)this.buffer).clear();
        ((Buffer)this.buffer).limit(indices.remaining());
        this.buffer.put(indices);
        ((Buffer)this.buffer).flip();
        ((Buffer)indices).position(pos);
        ((Buffer)this.byteBuffer).position(0);
        ((Buffer)this.byteBuffer).limit(this.buffer.limit() << 1);
    }

    @Override
    public void updateIndices(int targetOffset, short[] indices, int offset, int count) {
        int pos = this.byteBuffer.position();
        ((Buffer)this.byteBuffer).position(targetOffset * 2);
        BufferUtils.copy(indices, offset, (Buffer)this.byteBuffer, count);
        ((Buffer)this.byteBuffer).position(pos);
    }

    @Override
    public ShortBuffer getBuffer() {
        return this.buffer;
    }

    @Override
    public void bind() {
    }

    @Override
    public void unbind() {
    }

    @Override
    public void invalidate() {
    }

    @Override
    public void dispose() {
        BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
    }
}

