
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class Color_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private float fR;
    private float fG;
    private float fB;

    public Color_GameData() {
    }

    public Color_GameData(float fR, float fG, float fB) {
        this.fR = fR;
        this.fB = fB;
        this.fG = fG;
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

