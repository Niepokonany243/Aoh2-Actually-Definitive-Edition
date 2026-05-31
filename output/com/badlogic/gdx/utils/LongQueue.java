/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.StringBuilder;
import java.util.NoSuchElementException;

public class LongQueue {
    protected long[] values;
    protected int head = 0;
    protected int tail = 0;
    public int size = 0;

    public LongQueue() {
        this(16);
    }

    public LongQueue(int initialSize) {
        this.values = new long[initialSize];
    }

    public void addLast(long value) {
        long[] values = this.values;
        if (this.size == values.length) {
            this.resize(values.length << 1);
            values = this.values;
        }
        values[this.tail++] = value;
        if (this.tail == values.length) {
            this.tail = 0;
        }
        ++this.size;
    }

    public void addFirst(long value) {
        long[] values = this.values;
        if (this.size == values.length) {
            this.resize(values.length << 1);
            values = this.values;
        }
        int head = this.head;
        if (--head == -1) {
            head = values.length - 1;
        }
        values[head] = value;
        this.head = head;
        ++this.size;
    }

    public void ensureCapacity(int additional) {
        int needed = this.size + additional;
        if (this.values.length < needed) {
            this.resize(needed);
        }
    }

    protected void resize(int newSize) {
        long[] values = this.values;
        int head = this.head;
        int tail = this.tail;
        long[] newArray = new long[newSize];
        if (head < tail) {
            System.arraycopy(values, head, newArray, 0, tail - head);
        } else if (this.size > 0) {
            int rest = values.length - head;
            System.arraycopy(values, head, newArray, 0, rest);
            System.arraycopy(values, 0, newArray, rest, tail);
        }
        this.values = newArray;
        this.head = 0;
        this.tail = this.size;
    }

    public long removeFirst() {
        if (this.size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        long[] values = this.values;
        long result = values[this.head];
        ++this.head;
        if (this.head == values.length) {
            this.head = 0;
        }
        --this.size;
        return result;
    }

    public long removeLast() {
        if (this.size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        long[] values = this.values;
        int tail = this.tail;
        if (--tail == -1) {
            tail = values.length - 1;
        }
        long result = values[tail];
        this.tail = tail;
        --this.size;
        return result;
    }

    public int indexOf(long value) {
        if (this.size == 0) {
            return -1;
        }
        long[] values = this.values;
        int head = this.head;
        int tail = this.tail;
        if (head < tail) {
            for (int i = head; i < tail; ++i) {
                if (values[i] != value) continue;
                return i - head;
            }
        } else {
            int i;
            int n = values.length;
            for (i = head; i < n; ++i) {
                if (values[i] != value) continue;
                return i - head;
            }
            for (i = 0; i < tail; ++i) {
                if (values[i] != value) continue;
                return i + values.length - head;
            }
        }
        return -1;
    }

    public boolean removeValue(long value) {
        int index = this.indexOf(value);
        if (index == -1) {
            return false;
        }
        this.removeIndex(index);
        return true;
    }

    public long removeIndex(int index) {
        long value;
        if (index < 0) {
            throw new IndexOutOfBoundsException("index can't be < 0: " + index);
        }
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + index + " >= " + this.size);
        }
        long[] values = this.values;
        int head = this.head++;
        int tail = this.tail--;
        index += head;
        if (head < tail) {
            value = values[index];
            System.arraycopy(values, index + 1, values, index, tail - index);
        } else if (index >= values.length) {
            value = values[index -= values.length];
            System.arraycopy(values, index + 1, values, index, tail - index);
            --this.tail;
        } else {
            value = values[index];
            System.arraycopy(values, head, values, head + 1, index - head);
            if (this.head == values.length) {
                this.head = 0;
            }
        }
        --this.size;
        return value;
    }

    public boolean notEmpty() {
        return this.size > 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public long first() {
        if (this.size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.values[this.head];
    }

    public long last() {
        if (this.size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        long[] values = this.values;
        int tail = this.tail;
        if (--tail == -1) {
            tail = values.length - 1;
        }
        return values[tail];
    }

    public long get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index can't be < 0: " + index);
        }
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + index + " >= " + this.size);
        }
        int i = this.head + index;
        long[] values = this.values;
        if (i >= values.length) {
            i -= values.length;
        }
        return values[i];
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        long[] values = this.values;
        int head = this.head;
        int tail = this.tail;
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(values[head]);
        int i = (head + 1) % values.length;
        while (i != tail) {
            sb.append(", ").append(values[i]);
            i = (i + 1) % values.length;
        }
        sb.append(']');
        return sb.toString();
    }

    public String toString(String separator) {
        if (this.size == 0) {
            return "";
        }
        long[] values = this.values;
        int head = this.head;
        int tail = this.tail;
        StringBuilder sb = new StringBuilder(64);
        sb.append(values[head]);
        int i = (head + 1) % values.length;
        while (i != tail) {
            sb.append(separator).append(values[i]);
            i = (i + 1) % values.length;
        }
        return sb.toString();
    }

    public int hashCode() {
        int size = this.size;
        long[] values = this.values;
        int backingLength = values.length;
        int index = this.head;
        int hash = size + 1;
        for (int s = 0; s < size; ++s) {
            long value = values[index];
            hash += (int)(value ^ value >>> 32) * 31;
            if (++index != backingLength) continue;
            index = 0;
        }
        return hash;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof LongQueue)) {
            return false;
        }
        LongQueue q = (LongQueue)o;
        int size = this.size;
        if (q.size != size) {
            return false;
        }
        long[] myValues = this.values;
        int myBackingLength = myValues.length;
        long[] itsValues = q.values;
        int itsBackingLength = itsValues.length;
        int myIndex = this.head;
        int itsIndex = q.head;
        for (int s = 0; s < size; ++s) {
            if (myValues[myIndex] != itsValues[itsIndex]) {
                return false;
            }
            ++itsIndex;
            if (++myIndex == myBackingLength) {
                myIndex = 0;
            }
            if (itsIndex != itsBackingLength) continue;
            itsIndex = 0;
        }
        return true;
    }
}

