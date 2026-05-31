/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RendererSpriteBatch {
    public SpriteBatch oSBR;
    private boolean begun = false;

    public void begin() {
        if (!this.begun) {
            try {
                this.oSBR.begin();
                this.begun = true;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public void end() {
        if (this.begun) {
            try {
                this.oSBR.end();
                this.begun = false;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public boolean isBegun() {
        return this.begun;
    }
}

