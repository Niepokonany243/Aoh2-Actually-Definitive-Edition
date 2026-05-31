/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Save;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.Save.Save_CivDiploInfo_GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Save_CivDiplo_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Save_CivDiploInfo_GameData> lNonAggressionPacts = new ArrayList<Save_CivDiploInfo_GameData>();
    public List<Save_CivDiploInfo_GameData> lTruce = new ArrayList<Save_CivDiploInfo_GameData>();
    public List<Save_CivDiploInfo_GameData> lDefensivePact = new ArrayList<Save_CivDiploInfo_GameData>();
    public List<Save_CivDiploInfo_GameData> lGuarantee = new ArrayList<Save_CivDiploInfo_GameData>();
    public List<Save_CivDiploInfo_GameData> lMilitaryAccess = new ArrayList<Save_CivDiploInfo_GameData>();

    public Save_CivDiplo_GameData(int nCivID) {
        for (Map.Entry<Integer, Civilization.DiplomacyData> entry : CFG.core.getCiv((int)nCivID).nonAggressionPact.entrySet()) {
            this.lNonAggressionPacts.add(new Save_CivDiploInfo_GameData(entry.getValue().iCivID, entry.getValue().iTurnID));
        }
        for (Map.Entry<Integer, Civilization.DiplomacyData> entry : CFG.core.getCiv((int)nCivID).truce.entrySet()) {
            this.lTruce.add(new Save_CivDiploInfo_GameData(entry.getValue().iCivID, entry.getValue().iTurnID));
        }
        for (Map.Entry<Integer, Civilization.DiplomacyData> entry : CFG.core.getCiv((int)nCivID).defensivePact.entrySet()) {
            this.lDefensivePact.add(new Save_CivDiploInfo_GameData(entry.getValue().iCivID, entry.getValue().iTurnID));
        }
        for (Map.Entry<Integer, Civilization.DiplomacyData> entry : CFG.core.getCiv((int)nCivID).guarantee.entrySet()) {
            this.lGuarantee.add(new Save_CivDiploInfo_GameData(entry.getValue().iCivID, entry.getValue().iTurnID));
        }
        for (Map.Entry<Integer, Civilization.DiplomacyData> entry : CFG.core.getCiv((int)nCivID).militaryAccess.entrySet()) {
            this.lMilitaryAccess.add(new Save_CivDiploInfo_GameData(entry.getValue().iCivID, entry.getValue().iTurnID));
        }
    }
}

