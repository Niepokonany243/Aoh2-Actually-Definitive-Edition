/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.AbstractInput;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputEventQueue;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;
import com.badlogic.gdx.graphics.glutils.HdpiMode;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;

public class DefaultLwjgl3Input
extends AbstractInput
implements Lwjgl3Input {
    final Lwjgl3Window window;
    private InputProcessor inputProcessor;
    final InputEventQueue eventQueue = new InputEventQueue();
    int mouseX;
    int mouseY;
    int mousePressed;
    int deltaX;
    int deltaY;
    boolean justTouched;
    final boolean[] justPressedButtons = new boolean[5];
    char lastCharacter;
    private GLFWKeyCallback keyCallback = new GLFWKeyCallback(){

        @Override
        public void invoke(long window, int key, int scancode, int action, int mods) {
            DefaultLwjgl3Input.this.keyCallback(window, key, scancode, action, mods);
        }
    };
    GLFWCharCallback charCallback = new GLFWCharCallback(){

        @Override
        public void invoke(long window, int codepoint) {
            if ((codepoint & 0xFF00) == 63232) {
                return;
            }
            DefaultLwjgl3Input.this.lastCharacter = (char)codepoint;
            DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
            DefaultLwjgl3Input.this.eventQueue.keyTyped((char)codepoint, System.nanoTime());
        }
    };
    private GLFWScrollCallback scrollCallback = new GLFWScrollCallback(){

        @Override
        public void invoke(long window, double scrollX, double scrollY) {
            DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
            DefaultLwjgl3Input.this.eventQueue.scrolled(-((float)scrollX), -((float)scrollY), System.nanoTime());
        }
    };
    private GLFWCursorPosCallback cursorPosCallback = new GLFWCursorPosCallback(){
        private int logicalMouseY;
        private int logicalMouseX;

        @Override
        public void invoke(long windowHandle, double x, double y) {
            DefaultLwjgl3Input.this.deltaX = (int)x - this.logicalMouseX;
            DefaultLwjgl3Input.this.deltaY = (int)y - this.logicalMouseY;
            DefaultLwjgl3Input.this.mouseX = this.logicalMouseX = (int)x;
            DefaultLwjgl3Input.this.mouseY = this.logicalMouseY = (int)y;
            if (DefaultLwjgl3Input.this.window.getConfig().hdpiMode == HdpiMode.Pixels) {
                float xScale = (float)DefaultLwjgl3Input.this.window.getGraphics().getBackBufferWidth() / (float)DefaultLwjgl3Input.this.window.getGraphics().getLogicalWidth();
                float yScale = (float)DefaultLwjgl3Input.this.window.getGraphics().getBackBufferHeight() / (float)DefaultLwjgl3Input.this.window.getGraphics().getLogicalHeight();
                DefaultLwjgl3Input.this.deltaX = (int)((float)DefaultLwjgl3Input.this.deltaX * xScale);
                DefaultLwjgl3Input.this.deltaY = (int)((float)DefaultLwjgl3Input.this.deltaY * yScale);
                DefaultLwjgl3Input.this.mouseX = (int)((float)DefaultLwjgl3Input.this.mouseX * xScale);
                DefaultLwjgl3Input.this.mouseY = (int)((float)DefaultLwjgl3Input.this.mouseY * yScale);
            }
            DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
            long time = System.nanoTime();
            if (DefaultLwjgl3Input.this.mousePressed > 0) {
                DefaultLwjgl3Input.this.eventQueue.touchDragged(DefaultLwjgl3Input.this.mouseX, DefaultLwjgl3Input.this.mouseY, 0, time);
            } else {
                DefaultLwjgl3Input.this.eventQueue.mouseMoved(DefaultLwjgl3Input.this.mouseX, DefaultLwjgl3Input.this.mouseY, time);
            }
        }
    };
    private GLFWMouseButtonCallback mouseButtonCallback = new GLFWMouseButtonCallback(){

        @Override
        public void invoke(long window, int button, int action, int mods) {
            int gdxButton = this.toGdxButton(button);
            if (button != -1 && gdxButton == -1) {
                return;
            }
            long time = System.nanoTime();
            if (action == 1) {
                ++DefaultLwjgl3Input.this.mousePressed;
                DefaultLwjgl3Input.this.justTouched = true;
                DefaultLwjgl3Input.this.justPressedButtons[gdxButton] = true;
                DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
                DefaultLwjgl3Input.this.eventQueue.touchDown(DefaultLwjgl3Input.this.mouseX, DefaultLwjgl3Input.this.mouseY, 0, gdxButton, time);
            } else {
                DefaultLwjgl3Input.this.mousePressed = Math.max(0, DefaultLwjgl3Input.this.mousePressed - 1);
                DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
                DefaultLwjgl3Input.this.eventQueue.touchUp(DefaultLwjgl3Input.this.mouseX, DefaultLwjgl3Input.this.mouseY, 0, gdxButton, time);
            }
        }

        private int toGdxButton(int button) {
            if (button == 0) {
                return 0;
            }
            if (button == 1) {
                return 1;
            }
            if (button == 2) {
                return 2;
            }
            if (button == 3) {
                return 3;
            }
            if (button == 4) {
                return 4;
            }
            return -1;
        }
    };

    public DefaultLwjgl3Input(Lwjgl3Window window) {
        this.window = window;
        this.windowHandleChanged(window.getWindowHandle());
    }

    void keyCallback(long window, int key, int scancode, int action, int mods) {
        switch (action) {
            case 1: {
                key = this.getGdxKeyCode(key);
                this.eventQueue.keyDown(key, System.nanoTime());
                ++this.pressedKeyCount;
                this.keyJustPressed = true;
                this.pressedKeys[key] = true;
                this.justPressedKeys[key] = true;
                this.window.getGraphics().requestRendering();
                this.lastCharacter = '\u0000';
                char character = this.characterForKeyCode(key);
                if (character == '\u0000') break;
                this.charCallback.invoke(window, character);
                break;
            }
            case 0: {
                key = this.getGdxKeyCode(key);
                --this.pressedKeyCount;
                this.pressedKeys[key] = false;
                this.window.getGraphics().requestRendering();
                this.eventQueue.keyUp(key, System.nanoTime());
                break;
            }
            case 2: {
                if (this.lastCharacter == '\u0000') break;
                this.window.getGraphics().requestRendering();
                this.eventQueue.keyTyped(this.lastCharacter, System.nanoTime());
            }
        }
    }

    @Override
    public void resetPollingStates() {
        int i;
        this.justTouched = false;
        this.keyJustPressed = false;
        for (i = 0; i < this.justPressedKeys.length; ++i) {
            this.justPressedKeys[i] = false;
        }
        for (i = 0; i < this.justPressedButtons.length; ++i) {
            this.justPressedButtons[i] = false;
        }
        this.eventQueue.drain(null);
    }

    @Override
    public void windowHandleChanged(long windowHandle) {
        this.resetPollingStates();
        GLFW.glfwSetKeyCallback(this.window.getWindowHandle(), this.keyCallback);
        GLFW.glfwSetCharCallback(this.window.getWindowHandle(), this.charCallback);
        GLFW.glfwSetScrollCallback(this.window.getWindowHandle(), this.scrollCallback);
        GLFW.glfwSetCursorPosCallback(this.window.getWindowHandle(), this.cursorPosCallback);
        GLFW.glfwSetMouseButtonCallback(this.window.getWindowHandle(), this.mouseButtonCallback);
    }

    @Override
    public void update() {
        this.eventQueue.drain(this.inputProcessor);
    }

    @Override
    public void prepareNext() {
        int i;
        if (this.justTouched) {
            this.justTouched = false;
            for (i = 0; i < this.justPressedButtons.length; ++i) {
                this.justPressedButtons[i] = false;
            }
        }
        if (this.keyJustPressed) {
            this.keyJustPressed = false;
            for (i = 0; i < this.justPressedKeys.length; ++i) {
                this.justPressedKeys[i] = false;
            }
        }
        this.deltaX = 0;
        this.deltaY = 0;
    }

    @Override
    public int getMaxPointers() {
        return 1;
    }

    @Override
    public int getX() {
        return this.mouseX;
    }

    @Override
    public int getX(int pointer) {
        return pointer == 0 ? this.mouseX : 0;
    }

    @Override
    public int getDeltaX() {
        return this.deltaX;
    }

    @Override
    public int getDeltaX(int pointer) {
        return pointer == 0 ? this.deltaX : 0;
    }

    @Override
    public int getY() {
        return this.mouseY;
    }

    @Override
    public int getY(int pointer) {
        return pointer == 0 ? this.mouseY : 0;
    }

    @Override
    public int getDeltaY() {
        return this.deltaY;
    }

    @Override
    public int getDeltaY(int pointer) {
        return pointer == 0 ? this.deltaY : 0;
    }

    @Override
    public boolean isTouched() {
        return GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 0) == 1 || GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 1) == 1 || GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 2) == 1 || GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 3) == 1 || GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 4) == 1;
    }

    @Override
    public boolean justTouched() {
        return this.justTouched;
    }

    @Override
    public boolean isTouched(int pointer) {
        return pointer == 0 ? this.isTouched() : false;
    }

    @Override
    public float getPressure() {
        return this.getPressure(0);
    }

    @Override
    public float getPressure(int pointer) {
        return this.isTouched(pointer) ? 1.0f : 0.0f;
    }

    @Override
    public boolean isButtonPressed(int button) {
        return GLFW.glfwGetMouseButton(this.window.getWindowHandle(), button) == 1;
    }

    @Override
    public boolean isButtonJustPressed(int button) {
        if (button < 0 || button >= this.justPressedButtons.length) {
            return false;
        }
        return this.justPressedButtons[button];
    }

    @Override
    public void getTextInput(Input.TextInputListener listener, String title, String text, String hint) {
        this.getTextInput(listener, title, text, hint, Input.OnscreenKeyboardType.Default);
    }

    @Override
    public void getTextInput(Input.TextInputListener listener, String title, String text, String hint, Input.OnscreenKeyboardType type) {
        listener.canceled();
    }

    @Override
    public long getCurrentEventTime() {
        return this.eventQueue.getCurrentEventTime();
    }

    @Override
    public void setInputProcessor(InputProcessor processor) {
        this.inputProcessor = processor;
    }

    @Override
    public InputProcessor getInputProcessor() {
        return this.inputProcessor;
    }

    @Override
    public void setCursorCatched(boolean catched) {
        GLFW.glfwSetInputMode(this.window.getWindowHandle(), 208897, catched ? 212995 : 212993);
    }

    @Override
    public boolean isCursorCatched() {
        return GLFW.glfwGetInputMode(this.window.getWindowHandle(), 208897) == 212995;
    }

    @Override
    public void setCursorPosition(int x, int y) {
        if (this.window.getConfig().hdpiMode == HdpiMode.Pixels) {
            float xScale = (float)this.window.getGraphics().getLogicalWidth() / (float)this.window.getGraphics().getBackBufferWidth();
            float yScale = (float)this.window.getGraphics().getLogicalHeight() / (float)this.window.getGraphics().getBackBufferHeight();
            x = (int)((float)x * xScale);
            y = (int)((float)y * yScale);
        }
        GLFW.glfwSetCursorPos(this.window.getWindowHandle(), x, y);
    }

    protected char characterForKeyCode(int key) {
        switch (key) {
            case 67: {
                return '\b';
            }
            case 61: {
                return '\t';
            }
            case 112: {
                return '\u007f';
            }
            case 66: 
            case 160: {
                return '\n';
            }
        }
        return '\u0000';
    }

    public int getGdxKeyCode(int lwjglKeyCode) {
        switch (lwjglKeyCode) {
            case 32: {
                return 62;
            }
            case 39: {
                return 75;
            }
            case 44: {
                return 55;
            }
            case 45: {
                return 69;
            }
            case 46: {
                return 56;
            }
            case 47: {
                return 76;
            }
            case 48: {
                return 7;
            }
            case 49: {
                return 8;
            }
            case 50: {
                return 9;
            }
            case 51: {
                return 10;
            }
            case 52: {
                return 11;
            }
            case 53: {
                return 12;
            }
            case 54: {
                return 13;
            }
            case 55: {
                return 14;
            }
            case 56: {
                return 15;
            }
            case 57: {
                return 16;
            }
            case 59: {
                return 74;
            }
            case 61: {
                return 70;
            }
            case 65: {
                return 29;
            }
            case 66: {
                return 30;
            }
            case 67: {
                return 31;
            }
            case 68: {
                return 32;
            }
            case 69: {
                return 33;
            }
            case 70: {
                return 34;
            }
            case 71: {
                return 35;
            }
            case 72: {
                return 36;
            }
            case 73: {
                return 37;
            }
            case 74: {
                return 38;
            }
            case 75: {
                return 39;
            }
            case 76: {
                return 40;
            }
            case 77: {
                return 41;
            }
            case 78: {
                return 42;
            }
            case 79: {
                return 43;
            }
            case 80: {
                return 44;
            }
            case 81: {
                return 45;
            }
            case 82: {
                return 46;
            }
            case 83: {
                return 47;
            }
            case 84: {
                return 48;
            }
            case 85: {
                return 49;
            }
            case 86: {
                return 50;
            }
            case 87: {
                return 51;
            }
            case 88: {
                return 52;
            }
            case 89: {
                return 53;
            }
            case 90: {
                return 54;
            }
            case 91: {
                return 71;
            }
            case 92: {
                return 73;
            }
            case 93: {
                return 72;
            }
            case 96: {
                return 68;
            }
            case 161: 
            case 162: {
                return 0;
            }
            case 256: {
                return 111;
            }
            case 257: {
                return 66;
            }
            case 258: {
                return 61;
            }
            case 259: {
                return 67;
            }
            case 260: {
                return 124;
            }
            case 261: {
                return 112;
            }
            case 262: {
                return 22;
            }
            case 263: {
                return 21;
            }
            case 264: {
                return 20;
            }
            case 265: {
                return 19;
            }
            case 266: {
                return 92;
            }
            case 267: {
                return 93;
            }
            case 268: {
                return 3;
            }
            case 269: {
                return 123;
            }
            case 280: {
                return 115;
            }
            case 281: {
                return 116;
            }
            case 283: {
                return 120;
            }
            case 284: {
                return 121;
            }
            case 290: {
                return 131;
            }
            case 291: {
                return 132;
            }
            case 292: {
                return 133;
            }
            case 293: {
                return 134;
            }
            case 294: {
                return 135;
            }
            case 295: {
                return 136;
            }
            case 296: {
                return 137;
            }
            case 297: {
                return 138;
            }
            case 298: {
                return 139;
            }
            case 299: {
                return 140;
            }
            case 300: {
                return 141;
            }
            case 301: {
                return 142;
            }
            case 302: {
                return 183;
            }
            case 303: {
                return 184;
            }
            case 304: {
                return 185;
            }
            case 305: {
                return 186;
            }
            case 306: {
                return 187;
            }
            case 307: {
                return 188;
            }
            case 308: {
                return 189;
            }
            case 309: {
                return 190;
            }
            case 310: {
                return 191;
            }
            case 311: {
                return 192;
            }
            case 312: {
                return 193;
            }
            case 313: {
                return 194;
            }
            case 314: {
                return 0;
            }
            case 282: {
                return 143;
            }
            case 320: {
                return 144;
            }
            case 321: {
                return 145;
            }
            case 322: {
                return 146;
            }
            case 323: {
                return 147;
            }
            case 324: {
                return 148;
            }
            case 325: {
                return 149;
            }
            case 326: {
                return 150;
            }
            case 327: {
                return 151;
            }
            case 328: {
                return 152;
            }
            case 329: {
                return 153;
            }
            case 330: {
                return 158;
            }
            case 331: {
                return 154;
            }
            case 332: {
                return 155;
            }
            case 333: {
                return 156;
            }
            case 334: {
                return 157;
            }
            case 335: {
                return 160;
            }
            case 336: {
                return 161;
            }
            case 340: {
                return 59;
            }
            case 341: {
                return 129;
            }
            case 342: {
                return 57;
            }
            case 343: {
                return 63;
            }
            case 344: {
                return 60;
            }
            case 345: {
                return 130;
            }
            case 346: {
                return 58;
            }
            case 347: {
                return 63;
            }
            case 348: {
                return 82;
            }
        }
        return 0;
    }

    @Override
    public void dispose() {
        this.keyCallback.free();
        this.charCallback.free();
        this.scrollCallback.free();
        this.cursorPosCallback.free();
        this.mouseButtonCallback.free();
    }

    @Override
    public float getAccelerometerX() {
        return 0.0f;
    }

    @Override
    public float getAccelerometerY() {
        return 0.0f;
    }

    @Override
    public float getAccelerometerZ() {
        return 0.0f;
    }

    @Override
    public boolean isPeripheralAvailable(Input.Peripheral peripheral) {
        return peripheral == Input.Peripheral.HardwareKeyboard;
    }

    @Override
    public int getRotation() {
        return 0;
    }

    @Override
    public Input.Orientation getNativeOrientation() {
        return Input.Orientation.Landscape;
    }

    @Override
    public void setOnscreenKeyboardVisible(boolean visible) {
    }

    @Override
    public void setOnscreenKeyboardVisible(boolean visible, Input.OnscreenKeyboardType type) {
    }

    @Override
    public void vibrate(int milliseconds) {
    }

    @Override
    public void vibrate(long[] pattern, int repeat) {
    }

    @Override
    public void cancelVibrate() {
    }

    @Override
    public float getAzimuth() {
        return 0.0f;
    }

    @Override
    public float getPitch() {
        return 0.0f;
    }

    @Override
    public float getRoll() {
        return 0.0f;
    }

    @Override
    public void getRotationMatrix(float[] matrix) {
    }

    @Override
    public float getGyroscopeX() {
        return 0.0f;
    }

    @Override
    public float getGyroscopeY() {
        return 0.0f;
    }

    @Override
    public float getGyroscopeZ() {
        return 0.0f;
    }
}

