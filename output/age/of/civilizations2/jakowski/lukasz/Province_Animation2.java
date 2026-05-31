/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;

public class Province_Animation2 {
    public final int START_PROVINCE_ALPHA = 60;
    public final int START_PROVINCE_BORDER_ALPHA = 255;
    public final int TIME_UPDATE = 60;
    public long lTime = 0L;
    public int fAlpha = 60;
    public int iColorStepID;
    public int iStepID = 0;
    public boolean backAnimation = false;
    public long lTimeBorder = 0L;
    public int iStepIDBorder = 0;
    public int iBorderAlpha = 255;
    public boolean backAnimationBorder = false;

    public final void update() {
        if (this.lTime < System.currentTimeMillis() - 60L) {
            ++this.iStepID;
            if (this.backAnimation) {
                this.fAlpha = (int)((float)this.fAlpha + 2.75f);
                this.iBorderAlpha += 6;
                --this.iColorStepID;
            } else {
                this.fAlpha = (int)((float)this.fAlpha - 2.75f);
                this.iBorderAlpha -= 6;
                ++this.iColorStepID;
            }
            this.lTime = System.currentTimeMillis();
            if (this.iStepID == 20) {
                this.iStepID = 0;
                this.backAnimation = !this.backAnimation;
                this.backAnimationBorder = !this.backAnimationBorder;
                this.lTime += this.backAnimation ? 450L : 600L;
            }
            CFG.setRenderO(true);
        }
    }

    public final void resetAnimationData() {
        this.lTime = 0L;
        this.fAlpha = 60;
        this.iStepID = 0;
        this.backAnimation = false;
        this.iColorStepID = 0;
        this.lTimeBorder = System.currentTimeMillis() + 200L;
        this.iStepIDBorder = 0;
        this.iBorderAlpha = 255;
        this.backAnimationBorder = false;
    }

    public final int getAlpha() {
        return this.fAlpha;
    }

    public final int getBorderAlpha() {
        return this.iBorderAlpha;
    }

    public final boolean getBackAnimation() {
        return this.backAnimation;
    }

    public final int getStepID() {
        return this.iStepID;
    }

    public final int getColorStepID() {
        return this.iColorStepID;
    }
}

