/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Editor;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Editor {
    private boolean inUse = false;

    public void keyDown(int keycode) {
    }

    public void keyUp(int keycode) {
    }

    public void touchDown(int screenX, int screenY, int pointer, int button) {
    }

    public void touchDragged(int screenX, int screenY, int pointer) {
    }

    public void touchUp(int screenX, int screenY, int pointer, int button) {
    }

    public void draw(SpriteBatch oSB) {
        CFG.fontMain.get(0).getData().setScale(0.9f);
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.toString());
        oSB.setColor(0.08f, 0.012f, 0.038f, 0.95f);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, -IMGManager.getIMG(Images.sliderGradient).getHeight(), (int)CFG.glyphLay.width + CFG.PADD * 6, (int)CFG.glyphLay.height + CFG.PADD * 4);
        oSB.setColor(CFG.COLOR_FLAG_FRAME);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, -IMGManager.getIMG(Images.sliderGradient).getHeight() + 1, (int)CFG.glyphLay.width + CFG.PADD * 6, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, 0, -IMGManager.getIMG(Images.sliderGradient).getHeight() + (int)CFG.glyphLay.height + CFG.PADD * 4 - 2, (int)CFG.glyphLay.width + CFG.PADD * 6, 1);
        oSB.setColor(Color.WHITE);
        CFG.drawTextDefaultWithShadow(oSB, this.toString(), CFG.PADD, CFG.PADD * 2, Color.WHITE);
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    public final boolean getInUse() {
        return this.inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public String toString() {
        return "EDITOR";
    }
}

