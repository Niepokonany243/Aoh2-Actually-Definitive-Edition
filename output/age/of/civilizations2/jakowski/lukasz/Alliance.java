
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Alliance
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sAllianceName;
    private Color_GameData allianceColor;
    private List<Integer> lCivilizations;
    private int iCivilizationsSize;
    private int iFormationTurnID = 1;

    public Alliance(String sAllianceName) {
        this.sAllianceName = sAllianceName;
        this.lCivilizations = new ArrayList<Integer>();
        this.iCivilizationsSize = 0;
        this.allianceColor = CFG.getRandomColorGameData();
    }

    public final void addCivilization(int nCivID) {
        int i;
        for (i = 0; i < this.iCivilizationsSize; ++i) {
            if (this.lCivilizations.get(i) != nCivID) continue;
            return;
        }
        this.lCivilizations.add(nCivID);
        this.iCivilizationsSize = this.lCivilizations.size();
        for (i = 0; i < this.iCivilizationsSize - 1; ++i) {
            CFG.core.setCivRelationOfCivB(this.lCivilizations.get(i), nCivID, Math.min(CFG.core.getCivRelationOfCivB(this.lCivilizations.get(i), nCivID), 65.0f));
            CFG.core.setCivRelationOfCivB(nCivID, this.lCivilizations.get(i), Math.min(CFG.core.getCivRelationOfCivB(nCivID, this.lCivilizations.get(i)), 65.0f));
        }
    }

    public final void removeCivilization(int nCivID) {
        for (int i = 0; i < this.iCivilizationsSize; ++i) {
            if (this.lCivilizations.get(i) != nCivID) continue;
            this.lCivilizations.remove(i);
            this.iCivilizationsSize = this.lCivilizations.size();
            for (int a = 0; a < this.iCivilizationsSize; ++a) {
                if (!(CFG.core.getCivRelationOfCivB(this.lCivilizations.get(a), nCivID) > 0.0f) && !(CFG.core.getCivRelationOfCivB(nCivID, this.lCivilizations.get(a)) > 0.0f)) continue;
                CFG.core.setCivRelationOfCivB(this.lCivilizations.get(a), nCivID, 0.0f);
                CFG.core.setCivRelationOfCivB(nCivID, this.lCivilizations.get(a), 0.0f);
            }
            return;
        }
    }

    public final void removeAllCivilizations() {
        this.lCivilizations.clear();
        this.iCivilizationsSize = 0;
    }

    public final void updateCivilizationID(int i, int nNewCivID) {
        block2: {
            try {
                this.lCivilizations.set(i, nNewCivID);
            }
            catch (IndexOutOfBoundsException ex) {
                if (!CFG.LOGs) break block2;
                CFG.exceptionStack(ex);
            }
        }
    }

    public final void moveUp(int iID) {
        if (iID == 0) {
            return;
        }
        int tempCivID = this.lCivilizations.get(iID - 1);
        this.lCivilizations.set(iID - 1, this.lCivilizations.get(iID));
        this.lCivilizations.set(iID, tempCivID);
    }

    public final void moveDown(int iID) {
        int tempCivID = this.lCivilizations.get(iID + 1);
        this.lCivilizations.set(iID + 1, this.lCivilizations.get(iID));
        this.lCivilizations.set(iID, tempCivID);
    }

    public final void updateCivsIDs_AfterRemoveCiv(int nRemovedCivID) {
        for (int i = 0; i < this.getCivilizationsSize(); ++i) {
            if (this.getCivilization(i) <= nRemovedCivID) continue;
            this.lCivilizations.set(i, this.lCivilizations.get(i) - 1);
        }
    }

    public final String getAllianceName() {
        return this.sAllianceName;
    }

    public final void setAllianceName(String sAllianceName) {
        this.sAllianceName = sAllianceName;
    }

    public final int getCivilization(int iID) {
        try {
            return this.lCivilizations.get(iID);
        }
        catch (Exception ex) {
            return 0;
        }
    }

    public final int getCivilizationsSize() {
        return this.iCivilizationsSize;
    }

    public final Color_GameData getColorOfAlliance() {
        return this.allianceColor;
    }

    public final void setColorOfAlliance(Color_GameData allianceColor) {
        this.allianceColor = allianceColor;
    }

    public final int getFormationTurnID() {
        return this.iFormationTurnID;
    }

    public final void setFormationTurnID(int iFormationTurnID) {
        this.iFormationTurnID = iFormationTurnID;
    }

    public final int countProvinces() {
        int out = 0;
        for (int i = 0; i < this.getCivilizationsSize(); ++i) {
            out += CFG.core.getCiv(this.getCivilization(i)).getNumOfProvs();
        }
        return out;
    }

    public final long countPopulation() {
        long out = 0L;
        for (int i = 0; i < this.getCivilizationsSize(); ++i) {
            out += CFG.core.getCiv(this.getCivilization(i)).countPop();
        }
        return out;
    }

    public final long countEconomy() {
        long out = 0L;
        for (int i = 0; i < this.getCivilizationsSize(); ++i) {
            out += CFG.core.getCiv(this.getCivilization(i)).countEco();
        }
        return out;
    }
}

