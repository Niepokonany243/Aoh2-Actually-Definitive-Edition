/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Clipboard;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.Timer;

public class TextField
extends Widget
implements Disableable {
    protected static final char BACKSPACE = '\b';
    protected static final char CARRIAGE_RETURN = '\r';
    protected static final char NEWLINE = '\n';
    protected static final char TAB = '\t';
    protected static final char DELETE = '\u007f';
    protected static final char BULLET = '\u0095';
    private static final Vector2 tmp1 = new Vector2();
    private static final Vector2 tmp2 = new Vector2();
    private static final Vector2 tmp3 = new Vector2();
    public static float keyRepeatInitialTime = 0.4f;
    public static float keyRepeatTime = 0.1f;
    protected String text;
    protected int cursor;
    protected int selectionStart;
    protected boolean hasSelection;
    protected boolean writeEnters;
    protected final GlyphLayout layout = new GlyphLayout();
    protected final FloatArray glyphPositions = new FloatArray();
    TextFieldStyle style;
    private String messageText;
    protected CharSequence displayText;
    Clipboard clipboard;
    InputListener inputListener;
    @Null
    TextFieldListener listener;
    @Null
    TextFieldFilter filter;
    OnscreenKeyboard keyboard = new DefaultOnscreenKeyboard();
    boolean focusTraversal = true;
    boolean onlyFontChars = true;
    boolean disabled;
    private int textHAlign = 8;
    private float selectionX;
    private float selectionWidth;
    String undoText = "";
    long lastChangeTime;
    boolean passwordMode;
    private StringBuilder passwordBuffer;
    private char passwordCharacter = (char)149;
    protected float fontOffset;
    protected float textHeight;
    protected float textOffset;
    float renderOffset;
    private int visibleTextStart;
    private int visibleTextEnd;
    private int maxLength;
    boolean focused;
    boolean cursorOn;
    float blinkTime = 0.32f;
    final Timer.Task blinkTask = new Timer.Task(){

        @Override
        public void run() {
            if (TextField.this.getStage() == null) {
                this.cancel();
                return;
            }
            TextField.this.cursorOn = !TextField.this.cursorOn;
            Gdx.graphics.requestRendering();
        }
    };
    final KeyRepeatTask keyRepeatTask = new KeyRepeatTask();
    boolean programmaticChangeEvents;

    public TextField(@Null String text, Skin skin) {
        this(text, skin.get(TextFieldStyle.class));
    }

    public TextField(@Null String text, Skin skin, String styleName) {
        this(text, skin.get(styleName, TextFieldStyle.class));
    }

    public TextField(@Null String text, TextFieldStyle style) {
        this.setStyle(style);
        this.clipboard = Gdx.app.getClipboard();
        this.initialize();
        this.setText(text);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
    }

    protected void initialize() {
        this.inputListener = this.createInputListener();
        this.addListener(this.inputListener);
    }

    protected InputListener createInputListener() {
        return new TextFieldClickListener();
    }

    protected int letterUnderCursor(float x) {
        x -= this.textOffset + this.fontOffset - this.style.font.getData().cursorX - this.glyphPositions.get(this.visibleTextStart);
        Drawable background = this.getBackgroundDrawable();
        if (background != null) {
            x -= this.style.background.getLeftWidth();
        }
        int n = this.glyphPositions.size;
        float[] glyphPositions = this.glyphPositions.items;
        for (int i = 1; i < n; ++i) {
            if (!(glyphPositions[i] > x)) continue;
            if (glyphPositions[i] - x <= x - glyphPositions[i - 1]) {
                return i;
            }
            return i - 1;
        }
        return n - 1;
    }

    protected boolean isWordCharacter(char c) {
        return Character.isLetterOrDigit(c);
    }

    protected int[] wordUnderCursor(int at) {
        String text = this.text;
        int start = at;
        int right = text.length();
        int left = 0;
        if (at >= text.length()) {
            left = text.length();
            right = 0;
        } else {
            int index;
            for (index = start; index < right; ++index) {
                if (this.isWordCharacter(text.charAt(index))) continue;
                right = index;
                break;
            }
            for (index = start - 1; index > -1; --index) {
                if (this.isWordCharacter(text.charAt(index))) continue;
                left = index + 1;
                break;
            }
        }
        return new int[]{left, right};
    }

    int[] wordUnderCursor(float x) {
        return this.wordUnderCursor(this.letterUnderCursor(x));
    }

    boolean withinMaxLength(int size) {
        return this.maxLength <= 0 || size < this.maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void setOnlyFontChars(boolean onlyFontChars) {
        this.onlyFontChars = onlyFontChars;
    }

    public void setStyle(TextFieldStyle style) {
        if (style == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        this.style = style;
        this.textHeight = style.font.getCapHeight() - style.font.getDescent() * 2.0f;
        if (this.text != null) {
            this.updateDisplayText();
        }
        this.invalidateHierarchy();
    }

    public TextFieldStyle getStyle() {
        return this.style;
    }

    protected void calculateOffsets() {
        int end;
        float x;
        float visibleWidth = this.getWidth();
        Drawable background = this.getBackgroundDrawable();
        if (background != null) {
            visibleWidth -= background.getLeftWidth() + background.getRightWidth();
        }
        int glyphCount = this.glyphPositions.size;
        float[] glyphPositions = this.glyphPositions.items;
        float distance = glyphPositions[Math.max(0, this.cursor - 1)] + this.renderOffset;
        if (distance <= 0.0f) {
            this.renderOffset -= distance;
        } else {
            int index = Math.min(glyphCount - 1, this.cursor + 1);
            float minX = glyphPositions[index] - visibleWidth;
            if (-this.renderOffset < minX) {
                this.renderOffset = -minX;
            }
        }
        float maxOffset = 0.0f;
        float width = glyphPositions[glyphCount - 1];
        for (int i = glyphCount - 2; i >= 0 && !(width - (x = glyphPositions[i]) > visibleWidth); --i) {
            maxOffset = x;
        }
        if (-this.renderOffset > maxOffset) {
            this.renderOffset = -maxOffset;
        }
        this.visibleTextStart = 0;
        float startX = 0.0f;
        for (int i = 0; i < glyphCount; ++i) {
            if (!(glyphPositions[i] >= -this.renderOffset)) continue;
            this.visibleTextStart = i;
            startX = glyphPositions[i];
            break;
        }
        float endX = visibleWidth - this.renderOffset;
        int n = Math.min(this.displayText.length(), glyphCount);
        for (end = this.visibleTextStart + 1; end <= n && !(glyphPositions[end] > endX); ++end) {
        }
        this.visibleTextEnd = Math.max(0, end - 1);
        if ((this.textHAlign & 8) == 0) {
            this.textOffset = visibleWidth - glyphPositions[this.visibleTextEnd] - this.fontOffset + startX;
            if ((this.textHAlign & 1) != 0) {
                this.textOffset = Math.round(this.textOffset * 0.5f);
            }
        } else {
            this.textOffset = startX + this.renderOffset;
        }
        if (this.hasSelection) {
            int minIndex = Math.min(this.cursor, this.selectionStart);
            int maxIndex = Math.max(this.cursor, this.selectionStart);
            float minX = Math.max(glyphPositions[minIndex] - glyphPositions[this.visibleTextStart], -this.textOffset);
            float maxX = Math.min(glyphPositions[maxIndex] - glyphPositions[this.visibleTextStart], visibleWidth - this.textOffset);
            this.selectionX = minX;
            this.selectionWidth = maxX - minX - this.style.font.getData().cursorX;
        }
    }

    @Null
    protected Drawable getBackgroundDrawable() {
        if (this.disabled && this.style.disabledBackground != null) {
            return this.style.disabledBackground;
        }
        if (this.style.focusedBackground != null && this.hasKeyboardFocus()) {
            return this.style.focusedBackground;
        }
        return this.style.background;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        float yOffset;
        boolean focused = this.hasKeyboardFocus();
        if (focused != this.focused || focused && !this.blinkTask.isScheduled()) {
            this.focused = focused;
            this.blinkTask.cancel();
            this.cursorOn = focused;
            if (focused) {
                Timer.schedule(this.blinkTask, this.blinkTime, this.blinkTime);
            } else {
                this.keyRepeatTask.cancel();
            }
        } else if (!focused) {
            this.cursorOn = false;
        }
        BitmapFont font = this.style.font;
        Color fontColor = this.disabled && this.style.disabledFontColor != null ? this.style.disabledFontColor : (focused && this.style.focusedFontColor != null ? this.style.focusedFontColor : this.style.fontColor);
        Drawable selection = this.style.selection;
        Drawable cursorPatch = this.style.cursor;
        Drawable background = this.getBackgroundDrawable();
        Color color = this.getColor();
        float x = this.getX();
        float y = this.getY();
        float width = this.getWidth();
        float height = this.getHeight();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        float bgLeftWidth = 0.0f;
        float bgRightWidth = 0.0f;
        if (background != null) {
            background.draw(batch, x, y, width, height);
            bgLeftWidth = background.getLeftWidth();
            bgRightWidth = background.getRightWidth();
        }
        float textY = this.getTextY(font, background);
        this.calculateOffsets();
        if (focused && this.hasSelection && selection != null) {
            this.drawSelection(selection, batch, font, x + bgLeftWidth, y + textY);
        }
        float f = yOffset = font.isFlipped() ? -this.textHeight : 0.0f;
        if (this.displayText.length() == 0) {
            if (!focused && this.messageText != null) {
                BitmapFont messageFont;
                BitmapFont bitmapFont = messageFont = this.style.messageFont != null ? this.style.messageFont : font;
                if (this.style.messageFontColor != null) {
                    messageFont.setColor(this.style.messageFontColor.r, this.style.messageFontColor.g, this.style.messageFontColor.b, this.style.messageFontColor.a * color.a * parentAlpha);
                } else {
                    messageFont.setColor(0.7f, 0.7f, 0.7f, color.a * parentAlpha);
                }
                this.drawMessageText(batch, messageFont, x + bgLeftWidth, y + textY + yOffset, width - bgLeftWidth - bgRightWidth);
            }
        } else {
            font.setColor(fontColor.r, fontColor.g, fontColor.b, fontColor.a * color.a * parentAlpha);
            this.drawText(batch, font, x + bgLeftWidth, y + textY + yOffset);
        }
        if (!this.disabled && this.cursorOn && cursorPatch != null) {
            this.drawCursor(cursorPatch, batch, font, x + bgLeftWidth, y + textY);
        }
    }

    protected float getTextY(BitmapFont font, @Null Drawable background) {
        float height = this.getHeight();
        float textY = this.textHeight / 2.0f + font.getDescent();
        if (background != null) {
            float bottom = background.getBottomHeight();
            textY = textY + (height - background.getTopHeight() - bottom) / 2.0f + bottom;
        } else {
            textY += height / 2.0f;
        }
        if (font.usesIntegerPositions()) {
            textY = (int)textY;
        }
        return textY;
    }

    protected void drawSelection(Drawable selection, Batch batch, BitmapFont font, float x, float y) {
        selection.draw(batch, x + this.textOffset + this.selectionX + this.fontOffset, y - this.textHeight - font.getDescent(), this.selectionWidth, this.textHeight);
    }

    protected void drawText(Batch batch, BitmapFont font, float x, float y) {
        font.draw(batch, this.displayText, x + this.textOffset, y, this.visibleTextStart, this.visibleTextEnd, 0.0f, 8, false);
    }

    protected void drawMessageText(Batch batch, BitmapFont font, float x, float y, float maxWidth) {
        font.draw(batch, this.messageText, x, y, 0, this.messageText.length(), maxWidth, this.textHAlign, false, "...");
    }

    protected void drawCursor(Drawable cursorPatch, Batch batch, BitmapFont font, float x, float y) {
        cursorPatch.draw(batch, x + this.textOffset + this.glyphPositions.get(this.cursor) - this.glyphPositions.get(this.visibleTextStart) + this.fontOffset + font.getData().cursorX, y - this.textHeight - font.getDescent(), cursorPatch.getMinWidth(), this.textHeight);
    }

    void updateDisplayText() {
        BitmapFont font = this.style.font;
        BitmapFont.BitmapFontData data = font.getData();
        String text = this.text;
        int textLength = text.length();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < textLength; ++i) {
            char c = text.charAt(i);
            buffer.append(data.hasGlyph(c) ? c : (char)' ');
        }
        String newDisplayText = buffer.toString();
        if (this.passwordMode && data.hasGlyph(this.passwordCharacter)) {
            if (this.passwordBuffer == null) {
                this.passwordBuffer = new StringBuilder(newDisplayText.length());
            }
            if (this.passwordBuffer.length() > textLength) {
                this.passwordBuffer.setLength(textLength);
            } else {
                for (int i = this.passwordBuffer.length(); i < textLength; ++i) {
                    this.passwordBuffer.append(this.passwordCharacter);
                }
            }
            this.displayText = this.passwordBuffer;
        } else {
            this.displayText = newDisplayText;
        }
        this.layout.setText(font, this.displayText.toString().replace('\r', ' ').replace('\n', ' '));
        this.glyphPositions.clear();
        float x = 0.0f;
        if (this.layout.runs.size > 0) {
            GlyphLayout.GlyphRun run = this.layout.runs.first();
            FloatArray xAdvances = run.xAdvances;
            this.fontOffset = xAdvances.first();
            int n = xAdvances.size;
            for (int i = 1; i < n; ++i) {
                this.glyphPositions.add(x);
                x += xAdvances.get(i);
            }
        } else {
            this.fontOffset = 0.0f;
        }
        this.glyphPositions.add(x);
        this.visibleTextStart = Math.min(this.visibleTextStart, this.glyphPositions.size - 1);
        this.visibleTextEnd = MathUtils.clamp(this.visibleTextEnd, this.visibleTextStart, this.glyphPositions.size - 1);
        if (this.selectionStart > newDisplayText.length()) {
            this.selectionStart = textLength;
        }
    }

    public void copy() {
        if (this.hasSelection && !this.passwordMode) {
            this.clipboard.setContents(this.text.substring(Math.min(this.cursor, this.selectionStart), Math.max(this.cursor, this.selectionStart)));
        }
    }

    public void cut() {
        this.cut(this.programmaticChangeEvents);
    }

    void cut(boolean fireChangeEvent) {
        if (this.hasSelection && !this.passwordMode) {
            this.copy();
            this.cursor = this.delete(fireChangeEvent);
            this.updateDisplayText();
        }
    }

    void paste(@Null String content, boolean fireChangeEvent) {
        if (content == null) {
            return;
        }
        StringBuilder buffer = new StringBuilder();
        int textLength = this.text.length();
        if (this.hasSelection) {
            textLength -= Math.abs(this.cursor - this.selectionStart);
        }
        BitmapFont.BitmapFontData data = this.style.font.getData();
        int n = content.length();
        for (int i = 0; i < n && this.withinMaxLength(textLength + buffer.length()); ++i) {
            char c = content.charAt(i);
            if ((!this.writeEnters || c != '\n' && c != '\r') && (c == '\r' || c == '\n' || this.onlyFontChars && !data.hasGlyph(c) || this.filter != null && !this.filter.acceptChar(this, c))) continue;
            buffer.append(c);
        }
        content = buffer.toString();
        if (this.hasSelection) {
            this.cursor = this.delete(fireChangeEvent);
        }
        if (fireChangeEvent) {
            this.changeText(this.text, this.insert(this.cursor, content, this.text));
        } else {
            this.text = this.insert(this.cursor, content, this.text);
        }
        this.updateDisplayText();
        this.cursor += content.length();
    }

    String insert(int position, CharSequence text, String to) {
        if (to.length() == 0) {
            return text.toString();
        }
        return to.substring(0, position) + text + to.substring(position, to.length());
    }

    int delete(boolean fireChangeEvent) {
        int from = this.selectionStart;
        int to = this.cursor;
        int minIndex = Math.min(from, to);
        int maxIndex = Math.max(from, to);
        String newText = (minIndex > 0 ? this.text.substring(0, minIndex) : "") + (maxIndex < this.text.length() ? this.text.substring(maxIndex, this.text.length()) : "");
        if (fireChangeEvent) {
            this.changeText(this.text, newText);
        } else {
            this.text = newText;
        }
        this.clearSelection();
        return minIndex;
    }

    public void next(boolean up) {
        Stage stage = this.getStage();
        if (stage == null) {
            return;
        }
        TextField current = this;
        Vector2 currentCoords = current.getParent().localToStageCoordinates(tmp2.set(current.getX(), current.getY()));
        Vector2 bestCoords = tmp1;
        while (true) {
            TextField textField;
            if ((textField = current.findNextTextField(stage.getActors(), null, bestCoords, currentCoords, up)) == null) {
                if (up) {
                    currentCoords.set(-3.4028235E38f, -3.4028235E38f);
                } else {
                    currentCoords.set(Float.MAX_VALUE, Float.MAX_VALUE);
                }
                textField = current.findNextTextField(stage.getActors(), null, bestCoords, currentCoords, up);
            }
            if (textField == null) {
                Gdx.input.setOnscreenKeyboardVisible(false);
                break;
            }
            if (stage.setKeyboardFocus(textField)) {
                textField.selectAll();
                break;
            }
            current = textField;
            currentCoords.set(bestCoords);
        }
    }

    @Null
    private TextField findNextTextField(Array<Actor> actors, @Null TextField best, Vector2 bestCoords, Vector2 currentCoords, boolean up) {
        int n = actors.size;
        for (int i = 0; i < n; ++i) {
            Actor actor = actors.get(i);
            if (actor instanceof TextField) {
                boolean better;
                TextField textField;
                if (actor == this || (textField = (TextField)actor).isDisabled() || !textField.focusTraversal || !textField.ascendantsVisible()) continue;
                Vector2 actorCoords = actor.getParent().localToStageCoordinates(tmp3.set(actor.getX(), actor.getY()));
                boolean below = actorCoords.y != currentCoords.y && actorCoords.y < currentCoords.y ^ up;
                boolean right = actorCoords.y == currentCoords.y && actorCoords.x > currentCoords.x ^ up;
                if (!below && !right) continue;
                better = best == null || actorCoords.y != bestCoords.y && actorCoords.y > bestCoords.y ^ up;
                if (!better) {
                    better = actorCoords.y == bestCoords.y && actorCoords.x < bestCoords.x ^ up;
                }
                if (!better) continue;
                best = (TextField)actor;
                bestCoords.set(actorCoords);
                continue;
            }
            if (!(actor instanceof Group)) continue;
            best = this.findNextTextField(((Group)actor).getChildren(), best, bestCoords, currentCoords, up);
        }
        return best;
    }

    public InputListener getDefaultInputListener() {
        return this.inputListener;
    }

    public void setTextFieldListener(@Null TextFieldListener listener) {
        this.listener = listener;
    }

    public void setTextFieldFilter(@Null TextFieldFilter filter) {
        this.filter = filter;
    }

    @Null
    public TextFieldFilter getTextFieldFilter() {
        return this.filter;
    }

    public void setFocusTraversal(boolean focusTraversal) {
        this.focusTraversal = focusTraversal;
    }

    @Null
    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(@Null String messageText) {
        this.messageText = messageText;
    }

    public void appendText(@Null String str) {
        if (str == null) {
            str = "";
        }
        this.clearSelection();
        this.cursor = this.text.length();
        this.paste(str, this.programmaticChangeEvents);
    }

    public void setText(@Null String str) {
        if (str == null) {
            str = "";
        }
        if (str.equals(this.text)) {
            return;
        }
        this.clearSelection();
        String oldText = this.text;
        this.text = "";
        this.paste(str, false);
        if (this.programmaticChangeEvents) {
            this.changeText(oldText, this.text);
        }
        this.cursor = 0;
    }

    public String getText() {
        return this.text;
    }

    boolean changeText(String oldText, String newText) {
        if (newText.equals(oldText)) {
            return false;
        }
        this.text = newText;
        ChangeListener.ChangeEvent changeEvent = Pools.obtain(ChangeListener.ChangeEvent.class);
        boolean cancelled = this.fire(changeEvent);
        if (cancelled) {
            this.text = oldText;
        }
        Pools.free(changeEvent);
        return !cancelled;
    }

    public void setProgrammaticChangeEvents(boolean programmaticChangeEvents) {
        this.programmaticChangeEvents = programmaticChangeEvents;
    }

    public boolean getProgrammaticChangeEvents() {
        return this.programmaticChangeEvents;
    }

    public int getSelectionStart() {
        return this.selectionStart;
    }

    public String getSelection() {
        return this.hasSelection ? this.text.substring(Math.min(this.selectionStart, this.cursor), Math.max(this.selectionStart, this.cursor)) : "";
    }

    public void setSelection(int selectionStart, int selectionEnd) {
        if (selectionStart < 0) {
            throw new IllegalArgumentException("selectionStart must be >= 0");
        }
        if (selectionEnd < 0) {
            throw new IllegalArgumentException("selectionEnd must be >= 0");
        }
        selectionStart = Math.min(this.text.length(), selectionStart);
        selectionEnd = Math.min(this.text.length(), selectionEnd);
        if (selectionEnd == selectionStart) {
            this.clearSelection();
            return;
        }
        if (selectionEnd < selectionStart) {
            int temp = selectionEnd;
            selectionEnd = selectionStart;
            selectionStart = temp;
        }
        this.hasSelection = true;
        this.selectionStart = selectionStart;
        this.cursor = selectionEnd;
    }

    public void selectAll() {
        this.setSelection(0, this.text.length());
    }

    public void clearSelection() {
        this.hasSelection = false;
    }

    public void setCursorPosition(int cursorPosition) {
        if (cursorPosition < 0) {
            throw new IllegalArgumentException("cursorPosition must be >= 0");
        }
        this.clearSelection();
        this.cursor = Math.min(cursorPosition, this.text.length());
    }

    public int getCursorPosition() {
        return this.cursor;
    }

    public OnscreenKeyboard getOnscreenKeyboard() {
        return this.keyboard;
    }

    public void setOnscreenKeyboard(OnscreenKeyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void setClipboard(Clipboard clipboard) {
        this.clipboard = clipboard;
    }

    @Override
    public float getPrefWidth() {
        return 150.0f;
    }

    @Override
    public float getPrefHeight() {
        float topAndBottom = 0.0f;
        float minHeight = 0.0f;
        if (this.style.background != null) {
            topAndBottom = Math.max(topAndBottom, this.style.background.getBottomHeight() + this.style.background.getTopHeight());
            minHeight = Math.max(minHeight, this.style.background.getMinHeight());
        }
        if (this.style.focusedBackground != null) {
            topAndBottom = Math.max(topAndBottom, this.style.focusedBackground.getBottomHeight() + this.style.focusedBackground.getTopHeight());
            minHeight = Math.max(minHeight, this.style.focusedBackground.getMinHeight());
        }
        if (this.style.disabledBackground != null) {
            topAndBottom = Math.max(topAndBottom, this.style.disabledBackground.getBottomHeight() + this.style.disabledBackground.getTopHeight());
            minHeight = Math.max(minHeight, this.style.disabledBackground.getMinHeight());
        }
        return Math.max(topAndBottom + this.textHeight, minHeight);
    }

    public void setAlignment(int alignment) {
        this.textHAlign = alignment;
    }

    public int getAlignment() {
        return this.textHAlign;
    }

    public void setPasswordMode(boolean passwordMode) {
        this.passwordMode = passwordMode;
        this.updateDisplayText();
    }

    public boolean isPasswordMode() {
        return this.passwordMode;
    }

    public void setPasswordCharacter(char passwordCharacter) {
        this.passwordCharacter = passwordCharacter;
        if (this.passwordMode) {
            this.updateDisplayText();
        }
    }

    public void setBlinkTime(float blinkTime) {
        this.blinkTime = blinkTime;
    }

    @Override
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public boolean isDisabled() {
        return this.disabled;
    }

    protected void moveCursor(boolean forward, boolean jump) {
        int charOffset;
        int limit = forward ? this.text.length() : 0;
        int n = charOffset = forward ? 0 : -1;
        while ((forward ? ++this.cursor < limit : --this.cursor > limit) && jump && this.continueCursor(this.cursor, charOffset)) {
        }
    }

    protected boolean continueCursor(int index, int offset) {
        char c = this.text.charAt(index + offset);
        return this.isWordCharacter(c);
    }

    public static class TextFieldStyle {
        public BitmapFont font;
        public Color fontColor;
        @Null
        public Color focusedFontColor;
        @Null
        public Color disabledFontColor;
        @Null
        public Drawable background;
        @Null
        public Drawable focusedBackground;
        @Null
        public Drawable disabledBackground;
        @Null
        public Drawable cursor;
        @Null
        public Drawable selection;
        @Null
        public BitmapFont messageFont;
        @Null
        public Color messageFontColor;

        public TextFieldStyle() {
        }

        public TextFieldStyle(BitmapFont font, Color fontColor, @Null Drawable cursor, @Null Drawable selection, @Null Drawable background) {
            this.font = font;
            this.fontColor = fontColor;
            this.cursor = cursor;
            this.selection = selection;
            this.background = background;
        }

        public TextFieldStyle(TextFieldStyle style) {
            this.font = style.font;
            if (style.fontColor != null) {
                this.fontColor = new Color(style.fontColor);
            }
            if (style.focusedFontColor != null) {
                this.focusedFontColor = new Color(style.focusedFontColor);
            }
            if (style.disabledFontColor != null) {
                this.disabledFontColor = new Color(style.disabledFontColor);
            }
            this.background = style.background;
            this.focusedBackground = style.focusedBackground;
            this.disabledBackground = style.disabledBackground;
            this.cursor = style.cursor;
            this.selection = style.selection;
            this.messageFont = style.messageFont;
            if (style.messageFontColor != null) {
                this.messageFontColor = new Color(style.messageFontColor);
            }
        }
    }

    public class TextFieldClickListener
    extends ClickListener {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            int count = this.getTapCount() % 4;
            if (count == 0) {
                TextField.this.clearSelection();
            }
            if (count == 2) {
                int[] array = TextField.this.wordUnderCursor(x);
                TextField.this.setSelection(array[0], array[1]);
            }
            if (count == 3) {
                TextField.this.selectAll();
            }
        }

        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            if (!super.touchDown(event, x, y, pointer, button)) {
                return false;
            }
            if (pointer == 0 && button != 0) {
                return false;
            }
            if (TextField.this.disabled) {
                return true;
            }
            this.setCursorPosition(x, y);
            TextField.this.selectionStart = TextField.this.cursor;
            Stage stage = TextField.this.getStage();
            if (stage != null) {
                stage.setKeyboardFocus(TextField.this);
            }
            TextField.this.keyboard.show(true);
            TextField.this.hasSelection = true;
            return true;
        }

        @Override
        public void touchDragged(InputEvent event, float x, float y, int pointer) {
            super.touchDragged(event, x, y, pointer);
            this.setCursorPosition(x, y);
        }

        @Override
        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            if (TextField.this.selectionStart == TextField.this.cursor) {
                TextField.this.hasSelection = false;
            }
            super.touchUp(event, x, y, pointer, button);
        }

        protected void setCursorPosition(float x, float y) {
            TextField.this.cursor = TextField.this.letterUnderCursor(x);
            TextField.this.cursorOn = TextField.this.focused;
            TextField.this.blinkTask.cancel();
            if (TextField.this.focused) {
                Timer.schedule(TextField.this.blinkTask, TextField.this.blinkTime, TextField.this.blinkTime);
            }
        }

        protected void goHome(boolean jump) {
            TextField.this.cursor = 0;
        }

        protected void goEnd(boolean jump) {
            TextField.this.cursor = TextField.this.text.length();
        }

        @Override
        public boolean keyDown(InputEvent event, int keycode) {
            boolean handled;
            boolean repeat;
            block30: {
                boolean jump;
                block29: {
                    if (TextField.this.disabled) {
                        return false;
                    }
                    TextField.this.cursorOn = TextField.this.focused;
                    TextField.this.blinkTask.cancel();
                    if (TextField.this.focused) {
                        Timer.schedule(TextField.this.blinkTask, TextField.this.blinkTime, TextField.this.blinkTime);
                    }
                    if (!TextField.this.hasKeyboardFocus()) {
                        return false;
                    }
                    repeat = false;
                    boolean ctrl = UIUtils.ctrl();
                    jump = ctrl && !TextField.this.passwordMode;
                    handled = true;
                    if (ctrl) {
                        switch (keycode) {
                            case 50: {
                                TextField.this.paste(TextField.this.clipboard.getContents(), true);
                                repeat = true;
                                break;
                            }
                            case 31: 
                            case 124: {
                                TextField.this.copy();
                                return true;
                            }
                            case 52: {
                                TextField.this.cut(true);
                                return true;
                            }
                            case 29: {
                                TextField.this.selectAll();
                                return true;
                            }
                            case 54: {
                                String oldText = TextField.this.text;
                                TextField.this.setText(TextField.this.undoText);
                                TextField.this.undoText = oldText;
                                TextField.this.updateDisplayText();
                                return true;
                            }
                            default: {
                                handled = false;
                            }
                        }
                    }
                    if (!UIUtils.shift()) break block29;
                    switch (keycode) {
                        case 124: {
                            TextField.this.paste(TextField.this.clipboard.getContents(), true);
                            break;
                        }
                        case 112: {
                            TextField.this.cut(true);
                        }
                    }
                    int temp = TextField.this.cursor;
                    switch (keycode) {
                        case 21: {
                            TextField.this.moveCursor(false, jump);
                            repeat = true;
                            handled = true;
                            break;
                        }
                        case 22: {
                            TextField.this.moveCursor(true, jump);
                            repeat = true;
                            handled = true;
                            break;
                        }
                        case 3: {
                            this.goHome(jump);
                            handled = true;
                            break;
                        }
                        case 123: {
                            this.goEnd(jump);
                            handled = true;
                            break;
                        }
                        default: {
                            break block30;
                        }
                    }
                    if (!TextField.this.hasSelection) {
                        TextField.this.selectionStart = temp;
                        TextField.this.hasSelection = true;
                    }
                    break block30;
                }
                switch (keycode) {
                    case 21: {
                        TextField.this.moveCursor(false, jump);
                        TextField.this.clearSelection();
                        repeat = true;
                        handled = true;
                        break;
                    }
                    case 22: {
                        TextField.this.moveCursor(true, jump);
                        TextField.this.clearSelection();
                        repeat = true;
                        handled = true;
                        break;
                    }
                    case 3: {
                        this.goHome(jump);
                        TextField.this.clearSelection();
                        handled = true;
                        break;
                    }
                    case 123: {
                        this.goEnd(jump);
                        TextField.this.clearSelection();
                        handled = true;
                    }
                }
            }
            TextField.this.cursor = MathUtils.clamp(TextField.this.cursor, 0, TextField.this.text.length());
            if (repeat) {
                this.scheduleKeyRepeatTask(keycode);
            }
            return handled;
        }

        protected void scheduleKeyRepeatTask(int keycode) {
            if (!TextField.this.keyRepeatTask.isScheduled() || TextField.this.keyRepeatTask.keycode != keycode) {
                TextField.this.keyRepeatTask.keycode = keycode;
                TextField.this.keyRepeatTask.cancel();
                Timer.schedule(TextField.this.keyRepeatTask, keyRepeatInitialTime, keyRepeatTime);
            }
        }

        @Override
        public boolean keyUp(InputEvent event, int keycode) {
            if (TextField.this.disabled) {
                return false;
            }
            TextField.this.keyRepeatTask.cancel();
            return true;
        }

        protected boolean checkFocusTraversal(char character) {
            return !(!TextField.this.focusTraversal || character != '\t' && (character != '\r' && character != '\n' || !UIUtils.isAndroid && !UIUtils.isIos));
        }

        @Override
        public boolean keyTyped(InputEvent event, char character) {
            if (TextField.this.disabled) {
                return false;
            }
            switch (character) {
                case '\b': 
                case '\t': 
                case '\n': 
                case '\r': {
                    break;
                }
                default: {
                    if (character >= ' ') break;
                    return false;
                }
            }
            if (!TextField.this.hasKeyboardFocus()) {
                return false;
            }
            if (UIUtils.isMac && Gdx.input.isKeyPressed(63)) {
                return true;
            }
            if (this.checkFocusTraversal(character)) {
                TextField.this.next(UIUtils.shift());
            } else {
                boolean remove;
                boolean backspace;
                boolean enter = character == '\r' || character == '\n';
                boolean delete = character == '\u007f';
                boolean bl = backspace = character == '\b';
                boolean add = enter ? TextField.this.writeEnters : !TextField.this.onlyFontChars || TextField.this.style.font.getData().hasGlyph(character);
                boolean bl2 = remove = backspace || delete;
                if (add || remove) {
                    String oldText = TextField.this.text;
                    int oldCursor = TextField.this.cursor;
                    if (remove) {
                        if (TextField.this.hasSelection) {
                            TextField.this.cursor = TextField.this.delete(false);
                        } else {
                            if (backspace && TextField.this.cursor > 0) {
                                TextField.this.text = TextField.this.text.substring(0, TextField.this.cursor - 1) + TextField.this.text.substring(TextField.this.cursor--);
                                TextField.this.renderOffset = 0.0f;
                            }
                            if (delete && TextField.this.cursor < TextField.this.text.length()) {
                                TextField.this.text = TextField.this.text.substring(0, TextField.this.cursor) + TextField.this.text.substring(TextField.this.cursor + 1);
                            }
                        }
                    }
                    if (add && !remove) {
                        if (!enter && TextField.this.filter != null && !TextField.this.filter.acceptChar(TextField.this, character)) {
                            return true;
                        }
                        if (!TextField.this.withinMaxLength(TextField.this.text.length() - (TextField.this.hasSelection ? Math.abs(TextField.this.cursor - TextField.this.selectionStart) : 0))) {
                            return true;
                        }
                        if (TextField.this.hasSelection) {
                            TextField.this.cursor = TextField.this.delete(false);
                        }
                        String insertion = enter ? "\n" : String.valueOf(character);
                        TextField.this.text = TextField.this.insert(TextField.this.cursor++, insertion, TextField.this.text);
                    }
                    String tempUndoText = TextField.this.undoText;
                    if (TextField.this.changeText(oldText, TextField.this.text)) {
                        long time = System.currentTimeMillis();
                        if (time - 750L > TextField.this.lastChangeTime) {
                            TextField.this.undoText = oldText;
                        }
                        TextField.this.lastChangeTime = time;
                        TextField.this.updateDisplayText();
                    } else {
                        TextField.this.cursor = oldCursor;
                    }
                }
            }
            if (TextField.this.listener != null) {
                TextField.this.listener.keyTyped(TextField.this, character);
            }
            return true;
        }
    }

    public static class DefaultOnscreenKeyboard
    implements OnscreenKeyboard {
        @Override
        public void show(boolean visible) {
            Gdx.input.setOnscreenKeyboardVisible(visible);
        }
    }

    public static interface OnscreenKeyboard {
        public void show(boolean var1);
    }

    public static interface TextFieldFilter {
        public boolean acceptChar(TextField var1, char var2);

        public static class DigitsOnlyFilter
        implements TextFieldFilter {
            @Override
            public boolean acceptChar(TextField textField, char c) {
                return Character.isDigit(c);
            }
        }
    }

    public static interface TextFieldListener {
        public void keyTyped(TextField var1, char var2);
    }

    class KeyRepeatTask
    extends Timer.Task {
        int keycode;

        KeyRepeatTask() {
        }

        @Override
        public void run() {
            if (TextField.this.getStage() == null) {
                this.cancel();
                return;
            }
            TextField.this.inputListener.keyDown(null, this.keycode);
        }
    }
}

