
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import java.io.Serializable;

public class Flag_Overlay_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iOverlayID = 0;
    public Color_GameData oColor = new Color_GameData(1.0f, 1.0f, 1.0f);
    public int iPosX = 0;
    public int iPosY = 0;
    public int iWidth = 0;
    public int iHeight = 0;

    public Flag_Overlay_GameData(int iOverlayID) {
        this.iOverlayID = iOverlayID;
    }
}

