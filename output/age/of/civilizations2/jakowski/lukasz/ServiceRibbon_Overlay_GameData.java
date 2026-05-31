
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class ServiceRibbon_Overlay_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private int iPosX;
    private int iWidth;
    private boolean reflected;

    public ServiceRibbon_Overlay_GameData(int iPosX, int iWidth, boolean reflected) {
        this.iPosX = iPosX;
        this.iWidth = iWidth;
        this.reflected = reflected;
    }

    public final int getPosX() {
        return this.iPosX;
    }

    public final void setPosX(int iPosX) {
        this.iPosX = iPosX;
    }

    public final int getWidth() {
        return this.iWidth;
    }

    public final void setWidth(int iWidth) {
        this.iWidth = iWidth;
    }

    public final boolean getReflected() {
        return this.reflected;
    }

    public final void setReflected(boolean reflected) {
        this.reflected = reflected;
    }
}

