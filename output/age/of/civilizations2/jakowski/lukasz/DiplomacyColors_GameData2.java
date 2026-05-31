
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import java.io.Serializable;

public class DiplomacyColors_GameData2
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sName = "";
    public Color_GameData COLOR_DIPLOMACY_OWN_PROVINCES;
    public Color_GameData COLOR_DIPLOMACY_AT_WAR;
    public Color_GameData COLOR_DIPLOMACY_ALLIANCE;
    public Color_GameData COLOR_DIPLOMACY_PACT;
    public Color_GameData COLOR_DIPLOMACY_PACT_MAX;
    public Color_GameData COLOR_DIPLOMACY_VASSAL;
    public Color_GameData COLOR_DIPLOMACY_INDEPENDENCE;
    public Color_GameData COLOR_DIPLOMACY_NEUTRAL;
    public Color_GameData[] COLOR_DIPLOMACY_NEGATIVE;
    public Color_GameData[] COLOR_DIPLOMACY_POSITIVE;
    public Color_GameData COLOR_DIPLOMACY_MILITARY_ACCESS;
    public Color_GameData COLOR_DIPLOMACY_DEFENSIVE_PACT;

    public final String getName() {
        return this.sName;
    }

    public final void setName(String sName) {
        this.sName = sName;
    }
}

