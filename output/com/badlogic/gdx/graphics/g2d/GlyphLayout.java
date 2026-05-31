/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

public class GlyphLayout
implements Pool.Poolable {
    private static final Pool<GlyphRun> glyphRunPool = Pools.get(GlyphRun.class);
    private static final Pool<Color> colorPool = Pools.get(Color.class);
    private static final Array<Color> colorStack = new Array(4);
    private static final float epsilon = 1.0E-4f;
    public final Array<GlyphRun> runs = new Array(1);
    public float width;
    public float height;

    public GlyphLayout() {
    }

    public GlyphLayout(BitmapFont font, CharSequence str) {
        this.setText(font, str);
    }

    public GlyphLayout(BitmapFont font, CharSequence str, Color color, float targetWidth, int halign, boolean wrap) {
        this.setText(font, str, color, targetWidth, halign, wrap);
    }

    public GlyphLayout(BitmapFont font, CharSequence str, int start, int end, Color color, float targetWidth, int halign, boolean wrap, String truncate) {
        this.setText(font, str, start, end, color, targetWidth, halign, wrap, truncate);
    }

    public void setText(BitmapFont font, CharSequence str) {
        this.setText(font, str, 0, str.length(), font.getColor(), 0.0f, 8, false, null);
    }

    public void setText(BitmapFont font, CharSequence str, Color color, float targetWidth, int halign, boolean wrap) {
        this.setText(font, str, 0, str.length(), color, targetWidth, halign, wrap, null);
    }

    public void setText(BitmapFont font, CharSequence str, int start, int end, Color color, float targetWidth, int halign, boolean wrap, @Null String truncate) {
        Array<GlyphRun> runs = this.runs;
        glyphRunPool.freeAll(runs);
        runs.clear();
        BitmapFont.BitmapFontData fontData = font.data;
        if (start == end) {
            this.width = 0.0f;
            this.height = fontData.capHeight;
            return;
        }
        if (truncate != null) {
            wrap = true;
        } else if (targetWidth <= fontData.spaceXadvance * 3.0f) {
            wrap = false;
        }
        Color nextColor = color;
        boolean markupEnabled = fontData.markupEnabled;
        if (markupEnabled) {
            int n = GlyphLayout.colorStack.size;
            for (int i = 1; i < n; ++i) {
                colorPool.free(colorStack.get(i));
            }
            colorStack.clear();
            colorStack.add(color);
        }
        float x = 0.0f;
        float y = 0.0f;
        float down = fontData.down;
        BitmapFont.Glyph lastGlyph = null;
        int runStart = start;
        block5: while (true) {
            int runEnd = -1;
            boolean newline = false;
            if (start == end) {
                if (runStart == end) break;
                runEnd = end;
            } else {
                switch (str.charAt(start++)) {
                    case '\n': {
                        runEnd = start - 1;
                        newline = true;
                        break;
                    }
                    case '[': {
                        if (!markupEnabled) break;
                        int length = this.parseColorMarkup(str, start, end, colorPool);
                        if (length >= 0) {
                            runEnd = start - 1;
                            start += length + 1;
                            nextColor = colorStack.peek();
                            break;
                        }
                        if (length != -2) break;
                        ++start;
                        continue block5;
                    }
                }
            }
            if (runEnd == -1) continue;
            if (runEnd != runStart) {
                GlyphRun run = glyphRunPool.obtain();
                run.color.set(color);
                fontData.getGlyphs(run, str, runStart, runEnd, lastGlyph);
                if (run.glyphs.size == 0) {
                    glyphRunPool.free(run);
                } else {
                    int i;
                    if (lastGlyph != null) {
                        x -= lastGlyph.fixedWidth ? (float)lastGlyph.xadvance * fontData.scaleX : (float)(lastGlyph.width + lastGlyph.xoffset) * fontData.scaleX - fontData.padRight;
                    }
                    lastGlyph = run.glyphs.peek();
                    run.x = x;
                    run.y = y;
                    if (newline || runEnd == end) {
                        this.adjustLastGlyph(fontData, run);
                    }
                    runs.add(run);
                    int n = run.xAdvances.size;
                    float[] xAdvances = run.xAdvances.items;
                    if (!wrap || n == 0) {
                        if (markupEnabled) {
                            for (i = 0; i < n; ++i) {
                                x += xAdvances[i];
                            }
                        }
                    } else {
                        x += xAdvances[0] + xAdvances[1];
                        for (i = 2; i < n; ++i) {
                            GlyphRun next;
                            BitmapFont.Glyph glyph = run.glyphs.get(i - 1);
                            float glyphWidth = (float)(glyph.width + glyph.xoffset) * fontData.scaleX - fontData.padRight;
                            if (x + glyphWidth - 1.0E-4f <= targetWidth) {
                                x += xAdvances[i];
                                continue;
                            }
                            if (truncate != null) {
                                this.truncate(fontData, run, targetWidth, truncate, i, glyphRunPool);
                                break block5;
                            }
                            y += down;
                            lastGlyph = null;
                            int wrapIndex = fontData.getWrapIndex(run.glyphs, i);
                            if (wrapIndex == 0 && run.x == 0.0f || wrapIndex >= run.glyphs.size) {
                                wrapIndex = i - 1;
                            }
                            if (wrapIndex == 0) {
                                next = run;
                                int glyphCount = run.glyphs.size;
                                while (wrapIndex < glyphCount && fontData.isWhitespace((char)run.glyphs.get((int)wrapIndex).id)) {
                                    ++wrapIndex;
                                }
                                if (wrapIndex > 0) {
                                    run.glyphs.removeRange(0, wrapIndex - 1);
                                    run.xAdvances.removeRange(1, wrapIndex);
                                }
                                xAdvances[0] = (float)(-run.glyphs.first().xoffset) * fontData.scaleX - fontData.padLeft;
                                if (runs.size > 1) {
                                    int lastIndex;
                                    GlyphRun previous = runs.get(runs.size - 2);
                                    for (lastIndex = previous.glyphs.size - 1; lastIndex > 0 && fontData.isWhitespace((char)previous.glyphs.get((int)lastIndex).id); --lastIndex) {
                                    }
                                    previous.glyphs.truncate(lastIndex + 1);
                                    previous.xAdvances.truncate(lastIndex + 2);
                                    this.adjustLastGlyph(fontData, previous);
                                }
                            } else {
                                next = this.wrap(fontData, run, wrapIndex, i);
                                if (next == null) {
                                    x = 0.0f;
                                    break;
                                }
                                runs.add(next);
                            }
                            n = next.xAdvances.size;
                            xAdvances = next.xAdvances.items;
                            x = xAdvances[0];
                            if (n > 1) {
                                x += xAdvances[1];
                            }
                            next.x = 0.0f;
                            next.y = y;
                            i = 1;
                            run = next;
                        }
                    }
                }
            }
            if (newline) {
                x = 0.0f;
                y = runEnd == runStart ? (y += down * fontData.blankLineScale) : (y += down);
                lastGlyph = null;
            }
            runStart = start;
            color = nextColor;
        }
        this.height = fontData.capHeight + Math.abs(y);
        float width = 0.0f;
        T[] runsItems = runs.items;
        int runsSize = runs.size;
        for (int i = 0; i < runsSize; ++i) {
            GlyphRun run = (GlyphRun)runsItems[i];
            float[] xAdvances = run.xAdvances.items;
            float runWidth = xAdvances[0];
            float max = 0.0f;
            T[] glyphs = run.glyphs.items;
            int ii = 0;
            int nn = run.glyphs.size;
            while (ii < nn) {
                BitmapFont.Glyph glyph = (BitmapFont.Glyph)glyphs[ii];
                float glyphWidth = (float)(glyph.width + glyph.xoffset) * fontData.scaleX - fontData.padRight;
                max = Math.max(max, runWidth + glyphWidth);
                runWidth += xAdvances[++ii];
            }
            run.width = Math.max(runWidth, max);
            width = Math.max(width, run.x + run.width);
        }
        this.width = width;
        if ((halign & 8) == 0) {
            boolean center = (halign & 1) != 0;
            float lineWidth = 0.0f;
            float lineY = -2.1474836E9f;
            int lineStart = 0;
            for (int i = 0; i < runsSize; ++i) {
                GlyphRun run = (GlyphRun)runsItems[i];
                if (run.y != lineY) {
                    lineY = run.y;
                    float shift = targetWidth - lineWidth;
                    if (center) {
                        shift /= 2.0f;
                    }
                    while (lineStart < i) {
                        ((GlyphRun)runsItems[lineStart++]).x += shift;
                    }
                    lineWidth = run.x + run.width;
                    continue;
                }
                lineWidth = Math.max(lineWidth, run.x + run.width);
            }
            float shift = targetWidth - lineWidth;
            if (center) {
                shift /= 2.0f;
            }
            while (lineStart < runsSize) {
                ((GlyphRun)runsItems[lineStart++]).x += shift;
            }
        }
    }

    private void truncate(BitmapFont.BitmapFontData fontData, GlyphRun run, float targetWidth, String truncate, int widthIndex, Pool<GlyphRun> glyphRunPool) {
        float xAdvance;
        int count;
        GlyphRun truncateRun = glyphRunPool.obtain();
        fontData.getGlyphs(truncateRun, truncate, 0, truncate.length(), null);
        float truncateWidth = 0.0f;
        if (truncateRun.xAdvances.size > 0) {
            this.adjustLastGlyph(fontData, truncateRun);
            float[] xAdvances = truncateRun.xAdvances.items;
            int n = truncateRun.xAdvances.size;
            for (int i = 1; i < n; ++i) {
                truncateWidth += xAdvances[i];
            }
        }
        targetWidth -= truncateWidth;
        float width = run.x;
        float[] xAdvances = run.xAdvances.items;
        for (count = 0; count < run.xAdvances.size && !((width += (xAdvance = xAdvances[count])) > targetWidth); ++count) {
        }
        if (count > 1) {
            run.glyphs.truncate(count - 1);
            run.xAdvances.truncate(count);
            this.adjustLastGlyph(fontData, run);
            if (truncateRun.xAdvances.size > 0) {
                run.xAdvances.addAll(truncateRun.xAdvances, 1, truncateRun.xAdvances.size - 1);
            }
        } else {
            run.glyphs.clear();
            run.xAdvances.clear();
            run.xAdvances.addAll(truncateRun.xAdvances);
        }
        run.glyphs.addAll(truncateRun.glyphs);
        glyphRunPool.free(truncateRun);
    }

    private GlyphRun wrap(BitmapFont.BitmapFontData fontData, GlyphRun first, int wrapIndex, int widthIndex) {
        int secondStart;
        int firstEnd;
        Array<BitmapFont.Glyph> glyphs2 = first.glyphs;
        int glyphCount = first.glyphs.size;
        FloatArray xAdvances2 = first.xAdvances;
        for (firstEnd = wrapIndex; firstEnd > 0 && fontData.isWhitespace((char)glyphs2.get((int)(firstEnd - 1)).id); --firstEnd) {
        }
        for (secondStart = wrapIndex; secondStart < glyphCount && fontData.isWhitespace((char)glyphs2.get((int)secondStart).id); ++secondStart) {
        }
        GlyphRun second = null;
        if (secondStart < glyphCount) {
            second = glyphRunPool.obtain();
            second.color.set(first.color);
            Array<BitmapFont.Glyph> glyphs1 = second.glyphs;
            glyphs1.addAll(glyphs2, 0, firstEnd);
            glyphs2.removeRange(0, secondStart - 1);
            first.glyphs = glyphs1;
            second.glyphs = glyphs2;
            FloatArray xAdvances1 = second.xAdvances;
            xAdvances1.addAll(xAdvances2, 0, firstEnd + 1);
            xAdvances2.removeRange(1, secondStart);
            xAdvances2.items[0] = (float)(-glyphs2.first().xoffset) * fontData.scaleX - fontData.padLeft;
            first.xAdvances = xAdvances1;
            second.xAdvances = xAdvances2;
        } else {
            glyphs2.truncate(firstEnd);
            xAdvances2.truncate(firstEnd + 1);
        }
        if (firstEnd == 0) {
            glyphRunPool.free(first);
            this.runs.pop();
        } else {
            this.adjustLastGlyph(fontData, first);
        }
        return second;
    }

    private void adjustLastGlyph(BitmapFont.BitmapFontData fontData, GlyphRun run) {
        float width;
        BitmapFont.Glyph last = run.glyphs.peek();
        if (last.fixedWidth) {
            return;
        }
        run.xAdvances.items[run.xAdvances.size - 1] = width = (float)(last.width + last.xoffset) * fontData.scaleX - fontData.padRight;
    }

    private int parseColorMarkup(CharSequence str, int start, int end, Pool<Color> colorPool) {
        if (start == end) {
            return -1;
        }
        switch (str.charAt(start)) {
            case '#': {
                int colorInt = 0;
                for (int i = start + 1; i < end; ++i) {
                    char ch = str.charAt(i);
                    if (ch == ']') {
                        if (i < start + 2 || i > start + 9) break;
                        if (i - start <= 7) {
                            int nn = 9 - (i - start);
                            for (int ii = 0; ii < nn; ++ii) {
                                colorInt <<= 4;
                            }
                            colorInt |= 0xFF;
                        }
                        Color color = colorPool.obtain();
                        colorStack.add(color);
                        Color.rgba8888ToColor(color, colorInt);
                        return i - start;
                    }
                    if (ch >= '0' && ch <= '9') {
                        colorInt = colorInt * 16 + (ch - 48);
                        continue;
                    }
                    if (ch >= 'a' && ch <= 'f') {
                        colorInt = colorInt * 16 + (ch - 87);
                        continue;
                    }
                    if (ch < 'A' || ch > 'F') break;
                    colorInt = colorInt * 16 + (ch - 55);
                }
                return -1;
            }
            case '[': {
                return -2;
            }
            case ']': {
                if (GlyphLayout.colorStack.size > 1) {
                    colorPool.free(colorStack.pop());
                }
                return 0;
            }
        }
        int colorStart = start;
        for (int i = start + 1; i < end; ++i) {
            char ch = str.charAt(i);
            if (ch != ']') continue;
            Color namedColor = Colors.get(str.subSequence(colorStart, i).toString());
            if (namedColor == null) {
                return -1;
            }
            Color color = colorPool.obtain();
            colorStack.add(color);
            color.set(namedColor);
            return i - start;
        }
        return -1;
    }

    @Override
    public void reset() {
        Pools.get(GlyphRun.class).freeAll(this.runs);
        this.runs.clear();
        this.width = 0.0f;
        this.height = 0.0f;
    }

    public String toString() {
        if (this.runs.size == 0) {
            return "";
        }
        StringBuilder buffer = new StringBuilder(128);
        buffer.append(this.width);
        buffer.append('x');
        buffer.append(this.height);
        buffer.append('\n');
        int n = this.runs.size;
        for (int i = 0; i < n; ++i) {
            buffer.append(this.runs.get(i).toString());
            buffer.append('\n');
        }
        buffer.setLength(buffer.length() - 1);
        return buffer.toString();
    }

    public static class GlyphRun
    implements Pool.Poolable {
        public Array<BitmapFont.Glyph> glyphs = new Array();
        public FloatArray xAdvances = new FloatArray();
        public float x;
        public float y;
        public float width;
        public final Color color = new Color();

        @Override
        public void reset() {
            this.glyphs.clear();
            this.xAdvances.clear();
            this.width = 0.0f;
        }

        public String toString() {
            StringBuilder buffer = new StringBuilder(this.glyphs.size + 32);
            Array<BitmapFont.Glyph> glyphs = this.glyphs;
            int n = glyphs.size;
            for (int i = 0; i < n; ++i) {
                BitmapFont.Glyph g = glyphs.get(i);
                buffer.append((char)g.id);
            }
            buffer.append(", #");
            buffer.append(this.color);
            buffer.append(", ");
            buffer.append(this.x);
            buffer.append(", ");
            buffer.append(this.y);
            buffer.append(", ");
            buffer.append(this.width);
            return buffer.toString();
        }
    }
}

