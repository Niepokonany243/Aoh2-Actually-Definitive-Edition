
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Scenario_GameData_Diplomacy_AlliancesData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public String sName;
    public Color_GameData oColor;
    public List<Integer> lCivs;

    public Scenario_GameData_Diplomacy_AlliancesData() {
    }

    public Scenario_GameData_Diplomacy_AlliancesData(String sName, Color_GameData oColor) {
        this.setName(sName);
        this.setColor(oColor);
        this.lCivs = new ArrayList<Integer>();
    }

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

    public final List<Integer> getCivs() {
        return this.lCivs;
    }

    public final void addCiv(int nCivID) {
        this.lCivs.add(nCivID);
    }
}

