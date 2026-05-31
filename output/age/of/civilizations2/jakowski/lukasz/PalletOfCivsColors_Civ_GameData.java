
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import java.io.Serializable;

public class PalletOfCivsColors_Civ_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private Color_GameData oColor;

    public PalletOfCivsColors_Civ_GameData(Color_GameData oColor) {
        this.setColor(oColor);
    }

    public final Color_GameData getColor() {
        return this.oColor;
    }

    public final void setColor(Color_GameData oColor) {
        this.oColor = oColor;
    }
}

