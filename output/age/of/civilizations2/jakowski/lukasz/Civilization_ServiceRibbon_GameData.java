/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Civilization_ServiceRibbon_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sSRTAG;
    private List<Color_GameData> lColors = new ArrayList<Color_GameData>();

    public final String getSRTAG() {
        return this.sSRTAG;
    }

    public final void setSRTAG(String sSRTAG) {
        this.sSRTAG = sSRTAG;
    }

    public final List<Color_GameData> getColors() {
        return this.lColors;
    }

    public final Color_GameData getColor(int i) {
        return this.lColors.get(i);
    }
}

