/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

public final class WindowedMean {
    float[] values;
    int added_values = 0;
    int last_value;
    float mean = 0.0f;
    boolean dirty = true;

    public WindowedMean(int window_size) {
        this.values = new float[window_size];
    }

    public boolean hasEnoughData() {
        return this.added_values >= this.values.length;
    }

    public void clear() {
        this.added_values = 0;
        this.last_value = 0;
        for (int i = 0; i < this.values.length; ++i) {
            this.values[i] = 0.0f;
        }
        this.dirty = true;
    }

    public void addValue(float value) {
        if (this.added_values < this.values.length) {
            ++this.added_values;
        }
        this.values[this.last_value++] = value;
        if (this.last_value > this.values.length - 1) {
            this.last_value = 0;
        }
        this.dirty = true;
    }

    public float getMean() {
        if (this.hasEnoughData()) {
            if (this.dirty) {
                float mean = 0.0f;
                for (int i = 0; i < this.values.length; ++i) {
                    mean += this.values[i];
                }
                this.mean = mean / (float)this.values.length;
                this.dirty = false;
            }
            return this.mean;
        }
        return 0.0f;
    }

    public float getOldest() {
        return this.added_values < this.values.length ? this.values[0] : this.values[this.last_value];
    }

    public float getLatest() {
        return this.values[this.last_value - 1 == -1 ? this.values.length - 1 : this.last_value - 1];
    }

    public float standardDeviation() {
        if (!this.hasEnoughData()) {
            return 0.0f;
        }
        float mean = this.getMean();
        float sum = 0.0f;
        for (int i = 0; i < this.values.length; ++i) {
            sum += (this.values[i] - mean) * (this.values[i] - mean);
        }
        return (float)Math.sqrt(sum / (float)this.values.length);
    }

    public float getLowest() {
        float lowest = Float.MAX_VALUE;
        for (int i = 0; i < this.values.length; ++i) {
            lowest = Math.min(lowest, this.values[i]);
        }
        return lowest;
    }

    public float getHighest() {
        float lowest = Float.MIN_NORMAL;
        for (int i = 0; i < this.values.length; ++i) {
            lowest = Math.max(lowest, this.values[i]);
        }
        return lowest;
    }

    public int getValueCount() {
        return this.added_values;
    }

    public int getWindowSize() {
        return this.values.length;
    }

    public float[] getWindowValues() {
        float[] windowValues = new float[this.added_values];
        if (this.hasEnoughData()) {
            for (int i = 0; i < windowValues.length; ++i) {
                windowValues[i] = this.values[(i + this.last_value) % this.values.length];
            }
        } else {
            System.arraycopy(this.values, 0, windowValues, 0, this.added_values);
        }
        return windowValues;
    }
}

