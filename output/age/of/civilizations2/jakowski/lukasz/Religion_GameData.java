
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import java.io.Serializable;

public class Religion_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sName;
    private Color_GameData oColor;
    private String sIconName;

    public final String getName() {
        return this.sName;
    }

    public final void setName(String sName) {
        this.sName = sName;
    }

    public final Color_GameData getColor() {
        return this.oColor;
    }

    public final void setColor(Color_GameData oColor) {
        this.oColor = oColor;
    }

    public String getIconName() {
        return this.sIconName;
    }

    public void setIconName(String sIconName) {
        this.sIconName = sIconName;
    }
}

