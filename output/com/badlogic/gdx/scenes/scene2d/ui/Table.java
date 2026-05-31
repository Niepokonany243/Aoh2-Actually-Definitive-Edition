/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.SnapshotArray;
import java.util.Arrays;

public class Table
extends WidgetGroup {
    public static Color debugTableColor = new Color(0.0f, 0.0f, 1.0f, 1.0f);
    public static Color debugCellColor = new Color(1.0f, 0.0f, 0.0f, 1.0f);
    public static Color debugActorColor = new Color(0.0f, 1.0f, 0.0f, 1.0f);
    static final Pool<Cell> cellPool = new Pool<Cell>(){

        @Override
        protected Cell newObject() {
            return new Cell();
        }
    };
    private static float[] columnWeightedWidth;
    private static float[] rowWeightedHeight;
    private int columns;
    private int rows;
    private boolean implicitEndRow;
    private final Array<Cell> cells = new Array(4);
    private final Cell cellDefaults;
    private final Array<Cell> columnDefaults = new Array(2);
    private Cell rowDefaults;
    private boolean sizeInvalid = true;
    private float[] columnMinWidth;
    private float[] rowMinHeight;
    private float[] columnPrefWidth;
    private float[] rowPrefHeight;
    private float tableMinWidth;
    private float tableMinHeight;
    private float tablePrefWidth;
    private float tablePrefHeight;
    private float[] columnWidth;
    private float[] rowHeight;
    private float[] expandWidth;
    private float[] expandHeight;
    Value padTop = backgroundTop;
    Value padLeft = backgroundLeft;
    Value padBottom = backgroundBottom;
    Value padRight = backgroundRight;
    int align = 1;
    Debug debug = Debug.none;
    Array<DebugRect> debugRects;
    @Null
    Drawable background;
    private boolean clip;
    @Null
    private Skin skin;
    boolean round = true;
    public static Value backgroundTop;
    public static Value backgroundLeft;
    public static Value backgroundBottom;
    public static Value backgroundRight;

    public Table() {
        this((Skin)null);
    }

    public Table(@Null Skin skin) {
        this.skin = skin;
        this.cellDefaults = this.obtainCell();
        this.setTransform(false);
        this.setTouchable(Touchable.childrenOnly);
    }

    private Cell obtainCell() {
        Cell cell = cellPool.obtain();
        cell.setTable(this);
        return cell;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        this.validate();
        if (this.isTransform()) {
            this.applyTransform(batch, this.computeTransform());
            this.drawBackground(batch, parentAlpha, 0.0f, 0.0f);
            if (this.clip) {
                batch.flush();
                float padLeft = this.padLeft.get(this);
                float padBottom = this.padBottom.get(this);
                if (this.clipBegin(padLeft, padBottom, this.getWidth() - padLeft - this.padRight.get(this), this.getHeight() - padBottom - this.padTop.get(this))) {
                    this.drawChildren(batch, parentAlpha);
                    batch.flush();
                    this.clipEnd();
                }
            } else {
                this.drawChildren(batch, parentAlpha);
            }
            this.resetTransform(batch);
        } else {
            this.drawBackground(batch, parentAlpha, this.getX(), this.getY());
            super.draw(batch, parentAlpha);
        }
    }

    protected void drawBackground(Batch batch, float parentAlpha, float x, float y) {
        if (this.background == null) {
            return;
        }
        Color color = this.getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        this.background.draw(batch, x, y, this.getWidth(), this.getHeight());
    }

    public void setBackground(String drawableName) {
        if (this.skin == null) {
            throw new IllegalStateException("Table must have a skin set to use this method.");
        }
        this.setBackground(this.skin.getDrawable(drawableName));
    }

    public void setBackground(@Null Drawable background) {
        if (this.background == background) {
            return;
        }
        float padTopOld = this.getPadTop();
        float padLeftOld = this.getPadLeft();
        float padBottomOld = this.getPadBottom();
        float padRightOld = this.getPadRight();
        this.background = background;
        float padTopNew = this.getPadTop();
        float padLeftNew = this.getPadLeft();
        float padBottomNew = this.getPadBottom();
        float padRightNew = this.getPadRight();
        if (padTopOld + padBottomOld != padTopNew + padBottomNew || padLeftOld + padRightOld != padLeftNew + padRightNew) {
            this.invalidateHierarchy();
        } else if (padTopOld != padTopNew || padLeftOld != padLeftNew || padBottomOld != padBottomNew || padRightOld != padRightNew) {
            this.invalidate();
        }
    }

    public Table background(@Null Drawable background) {
        this.setBackground(background);
        return this;
    }

    public Table background(String drawableName) {
        this.setBackground(drawableName);
        return this;
    }

    @Null
    public Drawable getBackground() {
        return this.background;
    }

    @Override
    @Null
    public Actor hit(float x, float y, boolean touchable) {
        if (this.clip) {
            if (touchable && this.getTouchable() == Touchable.disabled) {
                return null;
            }
            if (x < 0.0f || x >= this.getWidth() || y < 0.0f || y >= this.getHeight()) {
                return null;
            }
        }
        return super.hit(x, y, touchable);
    }

    public Table clip() {
        this.setClip(true);
        return this;
    }

    public Table clip(boolean enabled) {
        this.setClip(enabled);
        return this;
    }

    public void setClip(boolean enabled) {
        this.clip = enabled;
        this.setTransform(enabled);
        this.invalidate();
    }

    public boolean getClip() {
        return this.clip;
    }

    @Override
    public void invalidate() {
        this.sizeInvalid = true;
        super.invalidate();
    }

    public <T extends Actor> Cell<T> add(@Null T actor) {
        Cell cell;
        block10: {
            int cellCount;
            cell = this.obtainCell();
            cell.actor = actor;
            if (this.implicitEndRow) {
                this.implicitEndRow = false;
                --this.rows;
                this.cells.peek().endRow = false;
            }
            if ((cellCount = this.cells.size) > 0) {
                Cell lastCell = this.cells.peek();
                if (!lastCell.endRow) {
                    cell.column = lastCell.column + lastCell.colspan;
                    cell.row = lastCell.row;
                } else {
                    cell.column = 0;
                    cell.row = lastCell.row + 1;
                }
                if (cell.row > 0) {
                    T[] cells = this.cells.items;
                    for (int i = cellCount - 1; i >= 0; --i) {
                        int column;
                        Cell other = (Cell)cells[i];
                        int nn = column + other.colspan;
                        for (column = other.column; column < nn; ++column) {
                            if (column != cell.column) continue;
                            cell.cellAboveIndex = i;
                            break block10;
                        }
                    }
                }
            } else {
                cell.column = 0;
                cell.row = 0;
            }
        }
        this.cells.add(cell);
        cell.set(this.cellDefaults);
        if (cell.column < this.columnDefaults.size) {
            cell.merge(this.columnDefaults.get(cell.column));
        }
        cell.merge(this.rowDefaults);
        if (actor != null) {
            this.addActor(actor);
        }
        return cell;
    }

    public Table add(Actor ... actors) {
        int n = actors.length;
        for (int i = 0; i < n; ++i) {
            this.add((T)actors[i]);
        }
        return this;
    }

    public Cell<Label> add(@Null CharSequence text) {
        if (this.skin == null) {
            throw new IllegalStateException("Table must have a skin set to use this method.");
        }
        return this.add((T)new Label(text, this.skin));
    }

    public Cell<Label> add(@Null CharSequence text, String labelStyleName) {
        if (this.skin == null) {
            throw new IllegalStateException("Table must have a skin set to use this method.");
        }
        return this.add((T)new Label(text, this.skin.get(labelStyleName, Label.LabelStyle.class)));
    }

    public Cell<Label> add(@Null CharSequence text, String fontName, @Null Color color) {
        if (this.skin == null) {
            throw new IllegalStateException("Table must have a skin set to use this method.");
        }
        return this.add((T)new Label(text, new Label.LabelStyle(this.skin.getFont(fontName), color)));
    }

    public Cell<Label> add(@Null CharSequence text, String fontName, String colorName) {
        if (this.skin == null) {
            throw new IllegalStateException("Table must have a skin set to use this method.");
        }
        return this.add((T)new Label(text, new Label.LabelStyle(this.skin.getFont(fontName), this.skin.getColor(colorName))));
    }

    public Cell add() {
        return this.add((T)null);
    }

    public Cell<Stack> stack(Actor ... actors) {
        Stack stack = new Stack();
        if (actors != null) {
            int n = actors.length;
            for (int i = 0; i < n; ++i) {
                stack.addActor(actors[i]);
            }
        }
        return this.add((T)stack);
    }

    @Override
    public boolean removeActor(Actor actor) {
        return this.removeActor(actor, true);
    }

    @Override
    public boolean removeActor(Actor actor, boolean unfocus) {
        if (!super.removeActor(actor, unfocus)) {
            return false;
        }
        Cell<Actor> cell = this.getCell(actor);
        if (cell != null) {
            cell.actor = null;
        }
        return true;
    }

    @Override
    public Actor removeActorAt(int index, boolean unfocus) {
        Actor actor = super.removeActorAt(index, unfocus);
        Cell<Actor> cell = this.getCell(actor);
        if (cell != null) {
            cell.actor = null;
        }
        return actor;
    }

    @Override
    public void clearChildren(boolean unfocus) {
        T[] cells = this.cells.items;
        for (int i = this.cells.size - 1; i >= 0; --i) {
            Cell cell = (Cell)cells[i];
            Actor actor = cell.actor;
            if (actor == null) continue;
            actor.remove();
        }
        cellPool.freeAll(this.cells);
        this.cells.clear();
        this.rows = 0;
        this.columns = 0;
        if (this.rowDefaults != null) {
            cellPool.free(this.rowDefaults);
        }
        this.rowDefaults = null;
        this.implicitEndRow = false;
        super.clearChildren(unfocus);
    }

    public void reset() {
        this.clearChildren();
        this.padTop = backgroundTop;
        this.padLeft = backgroundLeft;
        this.padBottom = backgroundBottom;
        this.padRight = backgroundRight;
        this.align = 1;
        this.debug(Debug.none);
        this.cellDefaults.reset();
        int n = this.columnDefaults.size;
        for (int i = 0; i < n; ++i) {
            Cell columnCell = this.columnDefaults.get(i);
            if (columnCell == null) continue;
            cellPool.free(columnCell);
        }
        this.columnDefaults.clear();
    }

    public Cell row() {
        if (this.cells.size > 0) {
            if (!this.implicitEndRow) {
                if (this.cells.peek().endRow) {
                    return this.rowDefaults;
                }
                this.endRow();
            }
            this.invalidate();
        }
        this.implicitEndRow = false;
        if (this.rowDefaults != null) {
            cellPool.free(this.rowDefaults);
        }
        this.rowDefaults = this.obtainCell();
        this.rowDefaults.clear();
        return this.rowDefaults;
    }

    private void endRow() {
        T[] cells = this.cells.items;
        int rowColumns = 0;
        for (int i = this.cells.size - 1; i >= 0; --i) {
            Cell cell = (Cell)cells[i];
            if (cell.endRow) break;
            rowColumns += cell.colspan.intValue();
        }
        this.columns = Math.max(this.columns, rowColumns);
        ++this.rows;
        this.cells.peek().endRow = true;
    }

    public Cell columnDefaults(int column) {
        Cell cell;
        Cell cell2 = cell = this.columnDefaults.size > column ? this.columnDefaults.get(column) : null;
        if (cell == null) {
            cell = this.obtainCell();
            cell.clear();
            if (column >= this.columnDefaults.size) {
                for (int i = this.columnDefaults.size; i < column; ++i) {
                    this.columnDefaults.add(null);
                }
                this.columnDefaults.add(cell);
            } else {
                this.columnDefaults.set(column, cell);
            }
        }
        return cell;
    }

    @Null
    public <T extends Actor> Cell<T> getCell(T actor) {
        if (actor == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        T[] cells = this.cells.items;
        int n = this.cells.size;
        for (int i = 0; i < n; ++i) {
            Cell c = (Cell)cells[i];
            if (c.actor != actor) continue;
            return c;
        }
        return null;
    }

    public Array<Cell> getCells() {
        return this.cells;
    }

    @Override
    public float getPrefWidth() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        float width = this.tablePrefWidth;
        if (this.background != null) {
            return Math.max(width, this.background.getMinWidth());
        }
        return width;
    }

    @Override
    public float getPrefHeight() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        float height = this.tablePrefHeight;
        if (this.background != null) {
            return Math.max(height, this.background.getMinHeight());
        }
        return height;
    }

    @Override
    public float getMinWidth() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.tableMinWidth;
    }

    @Override
    public float getMinHeight() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.tableMinHeight;
    }

    public Cell defaults() {
        return this.cellDefaults;
    }

    public Table pad(Value pad) {
        if (pad == null) {
            throw new IllegalArgumentException("pad cannot be null.");
        }
        this.padTop = pad;
        this.padLeft = pad;
        this.padBottom = pad;
        this.padRight = pad;
        this.sizeInvalid = true;
        return this;
    }

    public Table pad(Value top, Value left, Value bottom, Value right) {
        if (top == null) {
            throw new IllegalArgumentException("top cannot be null.");
        }
        if (left == null) {
            throw new IllegalArgumentException("left cannot be null.");
        }
        if (bottom == null) {
            throw new IllegalArgumentException("bottom cannot be null.");
        }
        if (right == null) {
            throw new IllegalArgumentException("right cannot be null.");
        }
        this.padTop = top;
        this.padLeft = left;
        this.padBottom = bottom;
        this.padRight = right;
        this.sizeInvalid = true;
        return this;
    }

    public Table padTop(Value padTop) {
        if (padTop == null) {
            throw new IllegalArgumentException("padTop cannot be null.");
        }
        this.padTop = padTop;
        this.sizeInvalid = true;
        return this;
    }

    public Table padLeft(Value padLeft) {
        if (padLeft == null) {
            throw new IllegalArgumentException("padLeft cannot be null.");
        }
        this.padLeft = padLeft;
        this.sizeInvalid = true;
        return this;
    }

    public Table padBottom(Value padBottom) {
        if (padBottom == null) {
            throw new IllegalArgumentException("padBottom cannot be null.");
        }
        this.padBottom = padBottom;
        this.sizeInvalid = true;
        return this;
    }

    public Table padRight(Value padRight) {
        if (padRight == null) {
            throw new IllegalArgumentException("padRight cannot be null.");
        }
        this.padRight = padRight;
        this.sizeInvalid = true;
        return this;
    }

    public Table pad(float pad) {
        this.pad(Value.Fixed.valueOf(pad));
        return this;
    }

    public Table pad(float top, float left, float bottom, float right) {
        this.padTop = Value.Fixed.valueOf(top);
        this.padLeft = Value.Fixed.valueOf(left);
        this.padBottom = Value.Fixed.valueOf(bottom);
        this.padRight = Value.Fixed.valueOf(right);
        this.sizeInvalid = true;
        return this;
    }

    public Table padTop(float padTop) {
        this.padTop = Value.Fixed.valueOf(padTop);
        this.sizeInvalid = true;
        return this;
    }

    public Table padLeft(float padLeft) {
        this.padLeft = Value.Fixed.valueOf(padLeft);
        this.sizeInvalid = true;
        return this;
    }

    public Table padBottom(float padBottom) {
        this.padBottom = Value.Fixed.valueOf(padBottom);
        this.sizeInvalid = true;
        return this;
    }

    public Table padRight(float padRight) {
        this.padRight = Value.Fixed.valueOf(padRight);
        this.sizeInvalid = true;
        return this;
    }

    public Table align(int align) {
        this.align = align;
        return this;
    }

    public Table center() {
        this.align = 1;
        return this;
    }

    public Table top() {
        this.align |= 2;
        this.align &= 0xFFFFFFFB;
        return this;
    }

    public Table left() {
        this.align |= 8;
        this.align &= 0xFFFFFFEF;
        return this;
    }

    public Table bottom() {
        this.align |= 4;
        this.align &= 0xFFFFFFFD;
        return this;
    }

    public Table right() {
        this.align |= 0x10;
        this.align &= 0xFFFFFFF7;
        return this;
    }

    @Override
    public void setDebug(boolean enabled) {
        this.debug(enabled ? Debug.all : Debug.none);
    }

    @Override
    public Table debug() {
        super.debug();
        return this;
    }

    @Override
    public Table debugAll() {
        super.debugAll();
        return this;
    }

    public Table debugTable() {
        super.setDebug(true);
        if (this.debug != Debug.table) {
            this.debug = Debug.table;
            this.invalidate();
        }
        return this;
    }

    public Table debugCell() {
        super.setDebug(true);
        if (this.debug != Debug.cell) {
            this.debug = Debug.cell;
            this.invalidate();
        }
        return this;
    }

    public Table debugActor() {
        super.setDebug(true);
        if (this.debug != Debug.actor) {
            this.debug = Debug.actor;
            this.invalidate();
        }
        return this;
    }

    public Table debug(Debug debug) {
        super.setDebug(debug != Debug.none);
        if (this.debug != debug) {
            this.debug = debug;
            if (debug == Debug.none) {
                this.clearDebugRects();
            } else {
                this.invalidate();
            }
        }
        return this;
    }

    public Debug getTableDebug() {
        return this.debug;
    }

    public Value getPadTopValue() {
        return this.padTop;
    }

    public float getPadTop() {
        return this.padTop.get(this);
    }

    public Value getPadLeftValue() {
        return this.padLeft;
    }

    public float getPadLeft() {
        return this.padLeft.get(this);
    }

    public Value getPadBottomValue() {
        return this.padBottom;
    }

    public float getPadBottom() {
        return this.padBottom.get(this);
    }

    public Value getPadRightValue() {
        return this.padRight;
    }

    public float getPadRight() {
        return this.padRight.get(this);
    }

    public float getPadX() {
        return this.padLeft.get(this) + this.padRight.get(this);
    }

    public float getPadY() {
        return this.padTop.get(this) + this.padBottom.get(this);
    }

    public int getAlign() {
        return this.align;
    }

    public int getRow(float y) {
        int n = this.cells.size;
        if (n == 0) {
            return -1;
        }
        y += this.getPadTop();
        T[] cells = this.cells.items;
        int i = 0;
        int row = 0;
        while (i < n) {
            Cell c = (Cell)cells[i++];
            if (c.actorY + c.computedPadTop < y) {
                return row;
            }
            if (!c.endRow) continue;
            ++row;
        }
        return -1;
    }

    public void setSkin(@Null Skin skin) {
        this.skin = skin;
    }

    public void setRound(boolean round) {
        this.round = round;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public float getRowHeight(int rowIndex) {
        if (this.rowHeight == null) {
            return 0.0f;
        }
        return this.rowHeight[rowIndex];
    }

    public float getRowMinHeight(int rowIndex) {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.rowMinHeight[rowIndex];
    }

    public float getRowPrefHeight(int rowIndex) {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.rowPrefHeight[rowIndex];
    }

    public float getColumnWidth(int columnIndex) {
        if (this.columnWidth == null) {
            return 0.0f;
        }
        return this.columnWidth[columnIndex];
    }

    public float getColumnMinWidth(int columnIndex) {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.columnMinWidth[columnIndex];
    }

    public float getColumnPrefWidth(int columnIndex) {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.columnPrefWidth[columnIndex];
    }

    private float[] ensureSize(float[] array, int size) {
        if (array == null || array.length < size) {
            return new float[size];
        }
        Arrays.fill(array, 0, size, 0.0f);
        return array;
    }

    private void computeSize() {
        int i;
        Cell c;
        int i2;
        float maxWidth;
        this.sizeInvalid = false;
        T[] cells = this.cells.items;
        int cellCount = this.cells.size;
        if (cellCount > 0 && !((Cell)cells[cellCount - 1]).endRow) {
            this.endRow();
            this.implicitEndRow = true;
        }
        int columns = this.columns;
        int rows = this.rows;
        this.columnMinWidth = this.ensureSize(this.columnMinWidth, columns);
        float[] columnMinWidth = this.columnMinWidth;
        this.rowMinHeight = this.ensureSize(this.rowMinHeight, rows);
        float[] rowMinHeight = this.rowMinHeight;
        this.columnPrefWidth = this.ensureSize(this.columnPrefWidth, columns);
        float[] columnPrefWidth = this.columnPrefWidth;
        this.rowPrefHeight = this.ensureSize(this.rowPrefHeight, rows);
        float[] rowPrefHeight = this.rowPrefHeight;
        this.columnWidth = this.ensureSize(this.columnWidth, columns);
        float[] columnWidth = this.columnWidth;
        this.rowHeight = this.ensureSize(this.rowHeight, rows);
        float[] rowHeight = this.rowHeight;
        this.expandWidth = this.ensureSize(this.expandWidth, columns);
        float[] expandWidth = this.expandWidth;
        this.expandHeight = this.ensureSize(this.expandHeight, rows);
        float[] expandHeight = this.expandHeight;
        float spaceRightLast = 0.0f;
        for (int i3 = 0; i3 < cellCount; ++i3) {
            Cell c2 = (Cell)cells[i3];
            int column = c2.column;
            int row = c2.row;
            int colspan = c2.colspan;
            Actor a = c2.actor;
            if (c2.expandY != 0 && expandHeight[row] == 0.0f) {
                expandHeight[row] = c2.expandY.intValue();
            }
            if (colspan == 1 && c2.expandX != 0 && expandWidth[column] == 0.0f) {
                expandWidth[column] = c2.expandX.intValue();
            }
            c2.computedPadLeft = c2.padLeft.get(a) + (column == 0 ? 0.0f : Math.max(0.0f, c2.spaceLeft.get(a) - spaceRightLast));
            c2.computedPadTop = c2.padTop.get(a);
            if (c2.cellAboveIndex != -1) {
                Cell above = (Cell)cells[c2.cellAboveIndex];
                c2.computedPadTop += Math.max(0.0f, c2.spaceTop.get(a) - above.spaceBottom.get(a));
            }
            float spaceRight = c2.spaceRight.get(a);
            c2.computedPadRight = c2.padRight.get(a) + (column + colspan == columns ? 0.0f : spaceRight);
            c2.computedPadBottom = c2.padBottom.get(a) + (row == rows - 1 ? 0.0f : c2.spaceBottom.get(a));
            spaceRightLast = spaceRight;
            float prefWidth = c2.prefWidth.get(a);
            float prefHeight = c2.prefHeight.get(a);
            float minWidth = c2.minWidth.get(a);
            float minHeight = c2.minHeight.get(a);
            maxWidth = c2.maxWidth.get(a);
            float maxHeight = c2.maxHeight.get(a);
            if (prefWidth < minWidth) {
                prefWidth = minWidth;
            }
            if (prefHeight < minHeight) {
                prefHeight = minHeight;
            }
            if (maxWidth > 0.0f && prefWidth > maxWidth) {
                prefWidth = maxWidth;
            }
            if (maxHeight > 0.0f && prefHeight > maxHeight) {
                prefHeight = maxHeight;
            }
            if (this.round) {
                minWidth = (float)Math.ceil(minWidth);
                minHeight = (float)Math.ceil(minHeight);
                prefWidth = (float)Math.ceil(prefWidth);
                prefHeight = (float)Math.ceil(prefHeight);
            }
            if (colspan == 1) {
                float hpadding = c2.computedPadLeft + c2.computedPadRight;
                columnPrefWidth[column] = Math.max(columnPrefWidth[column], prefWidth + hpadding);
                columnMinWidth[column] = Math.max(columnMinWidth[column], minWidth + hpadding);
            }
            float vpadding = c2.computedPadTop + c2.computedPadBottom;
            rowPrefHeight[row] = Math.max(rowPrefHeight[row], prefHeight + vpadding);
            rowMinHeight[row] = Math.max(rowMinHeight[row], minHeight + vpadding);
        }
        float uniformMinWidth = 0.0f;
        float uniformMinHeight = 0.0f;
        float uniformPrefWidth = 0.0f;
        float uniformPrefHeight = 0.0f;
        for (i2 = 0; i2 < cellCount; ++i2) {
            int column;
            block28: {
                c = (Cell)cells[i2];
                column = c.column;
                int expandX = c.expandX;
                if (expandX != 0) {
                    int ii;
                    int nn = column + c.colspan;
                    for (ii = column; ii < nn; ++ii) {
                        if (expandWidth[ii] == 0.0f) {
                            continue;
                        }
                        break block28;
                    }
                    for (ii = column; ii < nn; ++ii) {
                        expandWidth[ii] = expandX;
                    }
                }
            }
            if (c.uniformX == Boolean.TRUE && c.colspan == 1) {
                float hpadding = c.computedPadLeft + c.computedPadRight;
                uniformMinWidth = Math.max(uniformMinWidth, columnMinWidth[column] - hpadding);
                uniformPrefWidth = Math.max(uniformPrefWidth, columnPrefWidth[column] - hpadding);
            }
            if (c.uniformY != Boolean.TRUE) continue;
            float vpadding = c.computedPadTop + c.computedPadBottom;
            uniformMinHeight = Math.max(uniformMinHeight, rowMinHeight[c.row] - vpadding);
            uniformPrefHeight = Math.max(uniformPrefHeight, rowPrefHeight[c.row] - vpadding);
        }
        if (uniformPrefWidth > 0.0f || uniformPrefHeight > 0.0f) {
            for (i2 = 0; i2 < cellCount; ++i2) {
                c = (Cell)cells[i2];
                if (uniformPrefWidth > 0.0f && c.uniformX == Boolean.TRUE && c.colspan == 1) {
                    float hpadding = c.computedPadLeft + c.computedPadRight;
                    columnMinWidth[c.column] = uniformMinWidth + hpadding;
                    columnPrefWidth[c.column] = uniformPrefWidth + hpadding;
                }
                if (!(uniformPrefHeight > 0.0f) || c.uniformY != Boolean.TRUE) continue;
                float vpadding = c.computedPadTop + c.computedPadBottom;
                rowMinHeight[c.row] = uniformMinHeight + vpadding;
                rowPrefHeight[c.row] = uniformPrefHeight + vpadding;
            }
        }
        for (i2 = 0; i2 < cellCount; ++i2) {
            int ii;
            float spannedMinWidth;
            c = (Cell)cells[i2];
            int colspan = c.colspan;
            if (colspan == 1) continue;
            int column = c.column;
            Actor a = c.actor;
            float minWidth = c.minWidth.get(a);
            float prefWidth = c.prefWidth.get(a);
            maxWidth = c.maxWidth.get(a);
            if (prefWidth < minWidth) {
                prefWidth = minWidth;
            }
            if (maxWidth > 0.0f && prefWidth > maxWidth) {
                prefWidth = maxWidth;
            }
            if (this.round) {
                minWidth = (float)Math.ceil(minWidth);
                prefWidth = (float)Math.ceil(prefWidth);
            }
            float spannedPrefWidth = spannedMinWidth = -(c.computedPadLeft + c.computedPadRight);
            float totalExpandWidth = 0.0f;
            int nn = ii + colspan;
            for (ii = column; ii < nn; ++ii) {
                spannedMinWidth += columnMinWidth[ii];
                spannedPrefWidth += columnPrefWidth[ii];
                totalExpandWidth += expandWidth[ii];
            }
            float extraMinWidth = Math.max(0.0f, minWidth - spannedMinWidth);
            float extraPrefWidth = Math.max(0.0f, prefWidth - spannedPrefWidth);
            int ii2 = column;
            int nn2 = ii2 + colspan;
            while (ii2 < nn2) {
                float ratio = totalExpandWidth == 0.0f ? 1.0f / (float)colspan : expandWidth[ii2] / totalExpandWidth;
                int n = ii2;
                columnMinWidth[n] = columnMinWidth[n] + extraMinWidth * ratio;
                int n2 = ii2++;
                columnPrefWidth[n2] = columnPrefWidth[n2] + extraPrefWidth * ratio;
            }
        }
        float hpadding = this.padLeft.get(this) + this.padRight.get(this);
        float vpadding = this.padTop.get(this) + this.padBottom.get(this);
        this.tableMinWidth = hpadding;
        this.tablePrefWidth = hpadding;
        for (i = 0; i < columns; ++i) {
            this.tableMinWidth += columnMinWidth[i];
            this.tablePrefWidth += columnPrefWidth[i];
        }
        this.tableMinHeight = vpadding;
        this.tablePrefHeight = vpadding;
        for (i = 0; i < rows; ++i) {
            this.tableMinHeight += rowMinHeight[i];
            this.tablePrefHeight += Math.max(rowMinHeight[i], rowPrefHeight[i]);
        }
        this.tablePrefWidth = Math.max(this.tableMinWidth, this.tablePrefWidth);
        this.tablePrefHeight = Math.max(this.tableMinHeight, this.tablePrefHeight);
    }

    @Override
    public void layout() {
        int i;
        float amount;
        int i2;
        float[] rowWeightedHeight;
        float[] columnWeightedWidth;
        if (this.sizeInvalid) {
            this.computeSize();
        }
        float layoutWidth = this.getWidth();
        float layoutHeight = this.getHeight();
        int columns = this.columns;
        int rows = this.rows;
        float[] columnWidth = this.columnWidth;
        float[] rowHeight = this.rowHeight;
        float padLeft = this.padLeft.get(this);
        float hpadding = padLeft + this.padRight.get(this);
        float padTop = this.padTop.get(this);
        float vpadding = padTop + this.padBottom.get(this);
        float totalGrowWidth = this.tablePrefWidth - this.tableMinWidth;
        if (totalGrowWidth == 0.0f) {
            columnWeightedWidth = this.columnMinWidth;
        } else {
            float extraWidth = Math.min(totalGrowWidth, Math.max(0.0f, layoutWidth - this.tableMinWidth));
            Table.columnWeightedWidth = this.ensureSize(Table.columnWeightedWidth, columns);
            columnWeightedWidth = Table.columnWeightedWidth;
            float[] columnMinWidth = this.columnMinWidth;
            float[] columnPrefWidth = this.columnPrefWidth;
            for (int i3 = 0; i3 < columns; ++i3) {
                float growWidth = columnPrefWidth[i3] - columnMinWidth[i3];
                float growRatio = growWidth / totalGrowWidth;
                columnWeightedWidth[i3] = columnMinWidth[i3] + extraWidth * growRatio;
            }
        }
        float totalGrowHeight = this.tablePrefHeight - this.tableMinHeight;
        if (totalGrowHeight == 0.0f) {
            rowWeightedHeight = this.rowMinHeight;
        } else {
            Table.rowWeightedHeight = this.ensureSize(Table.rowWeightedHeight, rows);
            rowWeightedHeight = Table.rowWeightedHeight;
            float extraHeight = Math.min(totalGrowHeight, Math.max(0.0f, layoutHeight - this.tableMinHeight));
            float[] rowMinHeight = this.rowMinHeight;
            float[] rowPrefHeight = this.rowPrefHeight;
            for (int i4 = 0; i4 < rows; ++i4) {
                float growHeight = rowPrefHeight[i4] - rowMinHeight[i4];
                float growRatio = growHeight / totalGrowHeight;
                rowWeightedHeight[i4] = rowMinHeight[i4] + extraHeight * growRatio;
            }
        }
        T[] cells = this.cells.items;
        int cellCount = this.cells.size;
        for (int i5 = 0; i5 < cellCount; ++i5) {
            int ii;
            Cell c = (Cell)cells[i5];
            int column = c.column;
            int row = c.row;
            Actor a = c.actor;
            float spannedWeightedWidth = 0.0f;
            int colspan = c.colspan;
            int nn = ii + colspan;
            for (ii = column; ii < nn; ++ii) {
                spannedWeightedWidth += columnWeightedWidth[ii];
            }
            float weightedHeight = rowWeightedHeight[row];
            float prefWidth = c.prefWidth.get(a);
            float prefHeight = c.prefHeight.get(a);
            float minWidth = c.minWidth.get(a);
            float minHeight = c.minHeight.get(a);
            float maxWidth = c.maxWidth.get(a);
            float maxHeight = c.maxHeight.get(a);
            if (prefWidth < minWidth) {
                prefWidth = minWidth;
            }
            if (prefHeight < minHeight) {
                prefHeight = minHeight;
            }
            if (maxWidth > 0.0f && prefWidth > maxWidth) {
                prefWidth = maxWidth;
            }
            if (maxHeight > 0.0f && prefHeight > maxHeight) {
                prefHeight = maxHeight;
            }
            c.actorWidth = Math.min(spannedWeightedWidth - c.computedPadLeft - c.computedPadRight, prefWidth);
            c.actorHeight = Math.min(weightedHeight - c.computedPadTop - c.computedPadBottom, prefHeight);
            if (colspan == 1) {
                columnWidth[column] = Math.max(columnWidth[column], spannedWeightedWidth);
            }
            rowHeight[row] = Math.max(rowHeight[row], weightedHeight);
        }
        float[] expandWidth = this.expandWidth;
        float[] expandHeight = this.expandHeight;
        float totalExpand = 0.0f;
        for (int i6 = 0; i6 < columns; ++i6) {
            totalExpand += expandWidth[i6];
        }
        if (totalExpand > 0.0f) {
            float extra = layoutWidth - hpadding;
            for (int i7 = 0; i7 < columns; ++i7) {
                extra -= columnWidth[i7];
            }
            if (extra > 0.0f) {
                float used = 0.0f;
                int lastIndex = 0;
                for (i2 = 0; i2 < columns; ++i2) {
                    if (expandWidth[i2] == 0.0f) continue;
                    amount = extra * expandWidth[i2] / totalExpand;
                    int n = i2;
                    columnWidth[n] = columnWidth[n] + amount;
                    used += amount;
                    lastIndex = i2;
                }
                int n = lastIndex;
                columnWidth[n] = columnWidth[n] + (extra - used);
            }
        }
        totalExpand = 0.0f;
        for (int i8 = 0; i8 < rows; ++i8) {
            totalExpand += expandHeight[i8];
        }
        if (totalExpand > 0.0f) {
            float extra = layoutHeight - vpadding;
            for (int i9 = 0; i9 < rows; ++i9) {
                extra -= rowHeight[i9];
            }
            if (extra > 0.0f) {
                float used = 0.0f;
                int lastIndex = 0;
                for (i2 = 0; i2 < rows; ++i2) {
                    if (expandHeight[i2] == 0.0f) continue;
                    amount = extra * expandHeight[i2] / totalExpand;
                    int n = i2;
                    rowHeight[n] = rowHeight[n] + amount;
                    used += amount;
                    lastIndex = i2;
                }
                int n = lastIndex;
                rowHeight[n] = rowHeight[n] + (extra - used);
            }
        }
        for (int i10 = 0; i10 < cellCount; ++i10) {
            int column;
            Cell c = (Cell)cells[i10];
            int colspan = c.colspan;
            if (colspan == 1) continue;
            float extraWidth = 0.0f;
            int nn = column + colspan;
            for (column = c.column; column < nn; ++column) {
                extraWidth += columnWeightedWidth[column] - columnWidth[column];
            }
            extraWidth -= Math.max(0.0f, c.computedPadLeft + c.computedPadRight);
            if (!((extraWidth /= (float)colspan) > 0.0f)) continue;
            column = c.column;
            nn = column + colspan;
            while (column < nn) {
                int n = column++;
                columnWidth[n] = columnWidth[n] + extraWidth;
            }
        }
        float tableWidth = hpadding;
        float tableHeight = vpadding;
        for (i = 0; i < columns; ++i) {
            tableWidth += columnWidth[i];
        }
        for (i = 0; i < rows; ++i) {
            tableHeight += rowHeight[i];
        }
        int align = this.align;
        float x = padLeft;
        if ((align & 0x10) != 0) {
            x += layoutWidth - tableWidth;
        } else if ((align & 8) == 0) {
            x += (layoutWidth - tableWidth) / 2.0f;
        }
        float y = padTop;
        if ((align & 4) != 0) {
            y += layoutHeight - tableHeight;
        } else if ((align & 2) == 0) {
            y += (layoutHeight - tableHeight) / 2.0f;
        }
        float currentX = x;
        float currentY = y;
        for (int i11 = 0; i11 < cellCount; ++i11) {
            int column;
            Cell c = (Cell)cells[i11];
            float spannedCellWidth = 0.0f;
            int nn = column + c.colspan;
            for (column = c.column; column < nn; ++column) {
                spannedCellWidth += columnWidth[column];
            }
            spannedCellWidth -= c.computedPadLeft + c.computedPadRight;
            currentX += c.computedPadLeft;
            float fillX = c.fillX.floatValue();
            float fillY = c.fillY.floatValue();
            if (fillX > 0.0f) {
                c.actorWidth = Math.max(spannedCellWidth * fillX, c.minWidth.get(c.actor));
                float maxWidth = c.maxWidth.get(c.actor);
                if (maxWidth > 0.0f) {
                    c.actorWidth = Math.min(c.actorWidth, maxWidth);
                }
            }
            if (fillY > 0.0f) {
                c.actorHeight = Math.max(rowHeight[c.row] * fillY - c.computedPadTop - c.computedPadBottom, c.minHeight.get(c.actor));
                float maxHeight = c.maxHeight.get(c.actor);
                if (maxHeight > 0.0f) {
                    c.actorHeight = Math.min(c.actorHeight, maxHeight);
                }
            }
            c.actorX = ((align = c.align.intValue()) & 8) != 0 ? currentX : ((align & 0x10) != 0 ? currentX + spannedCellWidth - c.actorWidth : currentX + (spannedCellWidth - c.actorWidth) / 2.0f);
            c.actorY = (align & 2) != 0 ? c.computedPadTop : ((align & 4) != 0 ? rowHeight[c.row] - c.actorHeight - c.computedPadBottom : (rowHeight[c.row] - c.actorHeight + c.computedPadTop - c.computedPadBottom) / 2.0f);
            c.actorY = layoutHeight - currentY - c.actorY - c.actorHeight;
            if (this.round) {
                c.actorWidth = (float)Math.ceil(c.actorWidth);
                c.actorHeight = (float)Math.ceil(c.actorHeight);
                c.actorX = (float)Math.floor(c.actorX);
                c.actorY = (float)Math.floor(c.actorY);
            }
            if (c.actor != null) {
                c.actor.setBounds(c.actorX, c.actorY, c.actorWidth, c.actorHeight);
            }
            if (c.endRow) {
                currentX = x;
                currentY += rowHeight[c.row];
                continue;
            }
            currentX += spannedCellWidth + c.computedPadRight;
        }
        SnapshotArray<Actor> childrenArray = this.getChildren();
        Actor[] children = (Actor[])childrenArray.items;
        int n = childrenArray.size;
        for (int i12 = 0; i12 < n; ++i12) {
            Actor child = children[i12];
            if (!(child instanceof Layout)) continue;
            ((Layout)((Object)child)).validate();
        }
        if (this.debug != Debug.none) {
            this.addDebugRects(x, y, tableWidth - hpadding, tableHeight - vpadding);
        }
    }

    private void addDebugRects(float currentX, float currentY, float width, float height) {
        this.clearDebugRects();
        if (this.debug == Debug.table || this.debug == Debug.all) {
            this.addDebugRect(0.0f, 0.0f, this.getWidth(), this.getHeight(), debugTableColor);
            this.addDebugRect(currentX, this.getHeight() - currentY, width, -height, debugTableColor);
        }
        float x = currentX;
        int n = this.cells.size;
        for (int i = 0; i < n; ++i) {
            int column;
            Cell c = this.cells.get(i);
            if (this.debug == Debug.actor || this.debug == Debug.all) {
                this.addDebugRect(c.actorX, c.actorY, c.actorWidth, c.actorHeight, debugActorColor);
            }
            float spannedCellWidth = 0.0f;
            int nn = column + c.colspan;
            for (column = c.column; column < nn; ++column) {
                spannedCellWidth += this.columnWidth[column];
            }
            spannedCellWidth -= c.computedPadLeft + c.computedPadRight;
            currentX += c.computedPadLeft;
            if (this.debug == Debug.cell || this.debug == Debug.all) {
                float h = this.rowHeight[c.row] - c.computedPadTop - c.computedPadBottom;
                float y = currentY + c.computedPadTop;
                this.addDebugRect(currentX, this.getHeight() - y, spannedCellWidth, -h, debugCellColor);
            }
            if (c.endRow) {
                currentX = x;
                currentY += this.rowHeight[c.row];
                continue;
            }
            currentX += spannedCellWidth + c.computedPadRight;
        }
    }

    private void clearDebugRects() {
        if (this.debugRects == null) {
            this.debugRects = new Array();
        }
        DebugRect.pool.freeAll(this.debugRects);
        this.debugRects.clear();
    }

    private void addDebugRect(float x, float y, float w, float h, Color color) {
        DebugRect rect = DebugRect.pool.obtain();
        rect.color = color;
        rect.set(x, y, w, h);
        this.debugRects.add(rect);
    }

    @Override
    public void drawDebug(ShapeRenderer shapes) {
        if (this.isTransform()) {
            this.applyTransform(shapes, this.computeTransform());
            this.drawDebugRects(shapes);
            if (this.clip) {
                shapes.flush();
                float x = 0.0f;
                float y = 0.0f;
                float width = this.getWidth();
                float height = this.getHeight();
                if (this.background != null) {
                    x = this.padLeft.get(this);
                    y = this.padBottom.get(this);
                    width -= x + this.padRight.get(this);
                    height -= y + this.padTop.get(this);
                }
                if (this.clipBegin(x, y, width, height)) {
                    this.drawDebugChildren(shapes);
                    this.clipEnd();
                }
            } else {
                this.drawDebugChildren(shapes);
            }
            this.resetTransform(shapes);
        } else {
            this.drawDebugRects(shapes);
            super.drawDebug(shapes);
        }
    }

    @Override
    protected void drawDebugBounds(ShapeRenderer shapes) {
    }

    private void drawDebugRects(ShapeRenderer shapes) {
        if (this.debugRects == null || !this.getDebug()) {
            return;
        }
        shapes.set(ShapeRenderer.ShapeType.Line);
        if (this.getStage() != null) {
            shapes.setColor(this.getStage().getDebugColor());
        }
        float x = 0.0f;
        float y = 0.0f;
        if (!this.isTransform()) {
            x = this.getX();
            y = this.getY();
        }
        int n = this.debugRects.size;
        for (int i = 0; i < n; ++i) {
            DebugRect debugRect = this.debugRects.get(i);
            shapes.setColor(debugRect.color);
            shapes.rect(x + debugRect.x, y + debugRect.y, debugRect.width, debugRect.height);
        }
    }

    @Null
    public Skin getSkin() {
        return this.skin;
    }

    static {
        backgroundTop = new Value(){

            @Override
            public float get(@Null Actor context) {
                Drawable background = ((Table)context).background;
                return background == null ? 0.0f : background.getTopHeight();
            }
        };
        backgroundLeft = new Value(){

            @Override
            public float get(@Null Actor context) {
                Drawable background = ((Table)context).background;
                return background == null ? 0.0f : background.getLeftWidth();
            }
        };
        backgroundBottom = new Value(){

            @Override
            public float get(@Null Actor context) {
                Drawable background = ((Table)context).background;
                return background == null ? 0.0f : background.getBottomHeight();
            }
        };
        backgroundRight = new Value(){

            @Override
            public float get(@Null Actor context) {
                Drawable background = ((Table)context).background;
                return background == null ? 0.0f : background.getRightWidth();
            }
        };
    }

    public static enum Debug {
        none,
        all,
        table,
        cell,
        actor;

    }

    public static class DebugRect
    extends Rectangle {
        static Pool<DebugRect> pool = Pools.get(DebugRect.class);
        Color color;
    }
}

