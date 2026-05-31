/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.scenes.scene2d.utils.Selection;
import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectSet;

public class ArraySelection<T>
extends Selection<T> {
    private Array<T> array;
    private boolean rangeSelect = true;
    private T rangeStart;

    public ArraySelection(Array<T> array) {
        this.array = array;
    }

    @Override
    public void choose(T item) {
        if (item == null) {
            throw new IllegalArgumentException("item cannot be null.");
        }
        if (this.isDisabled) {
            return;
        }
        if (!this.rangeSelect || !this.multiple) {
            super.choose(item);
            return;
        }
        if (this.selected.size > 0 && UIUtils.shift()) {
            int rangeStartIndex;
            int n = rangeStartIndex = this.rangeStart == null ? -1 : this.array.indexOf(this.rangeStart, false);
            if (rangeStartIndex != -1) {
                T oldRangeStart = this.rangeStart;
                this.snapshot();
                int start = rangeStartIndex;
                int end = this.array.indexOf(item, false);
                if (start > end) {
                    int temp = end;
                    end = start;
                    start = temp;
                }
                if (!UIUtils.ctrl()) {
                    this.selected.clear(8);
                }
                for (int i = start; i <= end; ++i) {
                    this.selected.add(this.array.get(i));
                }
                if (this.fireChangeEvent()) {
                    this.revert();
                } else {
                    this.changed();
                }
                this.rangeStart = oldRangeStart;
                this.cleanup();
                return;
            }
        }
        super.choose(item);
        this.rangeStart = item;
    }

    @Override
    protected void changed() {
        this.rangeStart = null;
    }

    public boolean getRangeSelect() {
        return this.rangeSelect;
    }

    public void setRangeSelect(boolean rangeSelect) {
        this.rangeSelect = rangeSelect;
    }

    public void validate() {
        Array array = this.array;
        if (array.size == 0) {
            this.clear();
            return;
        }
        boolean changed = false;
        ObjectSet.ObjectSetIterator iter = this.items().iterator();
        while (iter.hasNext()) {
            Object selected = iter.next();
            if (array.contains(selected, false)) continue;
            iter.remove();
            changed = true;
        }
        if (this.required && this.selected.size == 0) {
            this.set(array.first());
        } else if (changed) {
            this.changed();
        }
    }
}

