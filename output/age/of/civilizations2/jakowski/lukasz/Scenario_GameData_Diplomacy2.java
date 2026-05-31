
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import age.of.civilizations2.jakowski.lukasz.Scenario_GameData_Diplomacy_AlliancesData;
import age.of.civilizations2.jakowski.lukasz.Scenario_GameData_Diplomacy_Data;
import age.of.civilizations2.jakowski.lukasz.Scenario_GameData_Diplomacy_VassalsData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Scenario_GameData_Diplomacy2
implements Serializable {
    private static final long serialVersionUID = 0L;
    private List<Scenario_GameData_Diplomacy_AlliancesData> lAlliances;
    private List<Scenario_GameData_Diplomacy_Data> lRelations;
    private List<Scenario_GameData_Diplomacy_Data> lPacts;
    private List<Scenario_GameData_Diplomacy_VassalsData> lVassals;
    private List<Scenario_GameData_Diplomacy_Data> lMilitaryAccess;
    private List<Scenario_GameData_Diplomacy_Data> lDefensivePacts;
    private List<Scenario_GameData_Diplomacy_Data> lGuarantee;
    private List<Scenario_GameData_Diplomacy_Data> lTruces;

    public final void buildData() {
        int j;
        int i;
        this.lAlliances = new ArrayList<Scenario_GameData_Diplomacy_AlliancesData>();
        this.lRelations = new ArrayList<Scenario_GameData_Diplomacy_Data>();
        this.lPacts = new ArrayList<Scenario_GameData_Diplomacy_Data>();
        this.lVassals = new ArrayList<Scenario_GameData_Diplomacy_VassalsData>();
        this.lMilitaryAccess = new ArrayList<Scenario_GameData_Diplomacy_Data>();
        this.lDefensivePacts = new ArrayList<Scenario_GameData_Diplomacy_Data>();
        this.lGuarantee = new ArrayList<Scenario_GameData_Diplomacy_Data>();
        this.lTruces = new ArrayList<Scenario_GameData_Diplomacy_Data>();
        for (i = 1; i < CFG.core.getAlliancesSize(); ++i) {
            this.lAlliances.add(new Scenario_GameData_Diplomacy_AlliancesData(CFG.core.getAlliance(i).getAllianceName(), new Color_GameData(CFG.core.getAlliance(i).getColorOfAlliance().getR(), CFG.core.getAlliance(i).getColorOfAlliance().getG(), CFG.core.getAlliance(i).getColorOfAlliance().getB())));
            for (j = 0; j < CFG.core.getAlliance(i).getCivilizationsSize(); ++j) {
                this.lAlliances.get(i - 1).addCiv(CFG.core.getAlliance(i).getCivilization(j));
            }
        }
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            for (j = 1; j < CFG.core.getCivsSize(); ++j) {
                if (i == j) continue;
                if (CFG.core.getCivRelationOfCivB(i, j) != 0.0f) {
                    this.lRelations.add(new Scenario_GameData_Diplomacy_Data(i, j, (int)CFG.core.getCivRelationOfCivB(i, j)));
                }
                if (CFG.core.getGuarantee(i, j) > 0) {
                    this.lGuarantee.add(new Scenario_GameData_Diplomacy_Data(i, j, CFG.core.getGuarantee(i, j)));
                }
                if (CFG.core.getMilitaryAccess(i, j) <= 0) continue;
                this.lMilitaryAccess.add(new Scenario_GameData_Diplomacy_Data(i, j, CFG.core.getMilitaryAccess(i, j)));
            }
            if (CFG.core.getCiv(i).getCivId() == CFG.core.getCiv(i).getPuppetOfCiv()) continue;
            this.lVassals.add(new Scenario_GameData_Diplomacy_VassalsData(CFG.core.getCiv(i).getCivId(), CFG.core.getCiv(i).getPuppetOfCiv()));
        }
        for (i = 1; i < CFG.core.getCivsSize() - 1; ++i) {
            for (j = i + 1; j < CFG.core.getCivsSize(); ++j) {
                if (CFG.core.getCivNonAggressionPact(i, j) > 0) {
                    this.lPacts.add(new Scenario_GameData_Diplomacy_Data(i, j, CFG.core.getCivNonAggressionPact(i, j)));
                }
                if (CFG.core.getDefensivePact(i, j) > 0) {
                    this.lDefensivePacts.add(new Scenario_GameData_Diplomacy_Data(i, j, CFG.core.getDefensivePact(i, j)));
                }
                if (CFG.core.getCivTruce(i, j) <= 0) continue;
                this.lTruces.add(new Scenario_GameData_Diplomacy_Data(i, j, CFG.core.getCivTruce(i, j)));
            }
        }
    }

    public final List<Scenario_GameData_Diplomacy_AlliancesData> getAlliances() {
        return this.lAlliances;
    }

    public final List<Scenario_GameData_Diplomacy_Data> getRelations() {
        return this.lRelations;
    }

    public final List<Scenario_GameData_Diplomacy_Data> getPacts() {
        return this.lPacts;
    }

    public final List<Scenario_GameData_Diplomacy_Data> getTruces() {
        return this.lTruces;
    }

    public final List<Scenario_GameData_Diplomacy_VassalsData> getVassals() {
        return this.lVassals;
    }

    public final List<Scenario_GameData_Diplomacy_Data> getGuarantee() {
        return this.lGuarantee;
    }

    public final List<Scenario_GameData_Diplomacy_Data> getMilitaryAccess() {
        return this.lMilitaryAccess;
    }

    public final List<Scenario_GameData_Diplomacy_Data> getDefensivePacts() {
        return this.lDefensivePacts;
    }
}

