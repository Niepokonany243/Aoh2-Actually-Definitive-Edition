/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class Region_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sName = "";
    private float fR;
    private float fG;
    private float fB;

    public final String getName() {
        return this.sName;
    }

    public final void setName(String sName) {
        this.sName = sName;
    }

    public final float getR() {
        return this.fR;
    }

    public final void setR(float fR) {
        this.fR = fR;
    }

    public final float getG() {
        return this.fG;
    }

    public final void setG(float fG) {
        this.fG = fG;
    }

    public final float getB() {
        return this.fB;
    }

    public final void setB(float fB) {
        this.fB = fB;
    }
}

