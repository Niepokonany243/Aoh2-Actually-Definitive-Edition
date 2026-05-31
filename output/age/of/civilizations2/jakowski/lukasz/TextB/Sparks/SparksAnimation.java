/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Sparks;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SparksAnimation {
    public static Color sparksColors = new Color(1.0f, 1.0f, 1.0f, 0.25f);
    public static Color sparksColors2 = new Color(1.0f, 1.0f, 1.0f, 0.5f);
    public int currentIMG = 0;
    public long ANIMATION_TIME = 0L;

    public void draw(SpriteBatch oSB, int posX, int posY, int width, int height) {
        Images.sparks.get(this.currentIMG).draw(oSB, posX, posY, width, height);
        this.updateAnimation();
    }

    public void draw(SpriteBatch oSB, int posX, int posY, int width, int height, boolean flipX, boolean flipY) {
        Images.sparks.get(this.currentIMG).draw(oSB, posX, posY, width, height, flipX, flipY);
        this.updateAnimation();
    }

    public void draw2(SpriteBatch oSB, int posX, int posY, int width, int height) {
        Images.sparks.get(this.currentIMG).draw2(oSB, posX, posY, width, height);
        this.updateAnimation();
    }

    public void draw2(SpriteBatch oSB, int posX, int posY, int width, int height, boolean flipX, boolean flipY) {
        Images.sparks.get(this.currentIMG).draw2(oSB, posX, posY, width, height, flipX, flipY);
        this.updateAnimation();
    }

    public void updateAnimation() {
        if (CFG.currentTimeMillis - this.ANIMATION_TIME > 45L) {
            this.ANIMATION_TIME = CFG.currentTimeMillis;
            ++this.currentIMG;
            if (this.currentIMG >= Images.SPARKS_SIZE) {
                this.currentIMG = 0;
            }
        }
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }
}

