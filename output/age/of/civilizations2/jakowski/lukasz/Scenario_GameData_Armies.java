/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Scenario_GameData_Army;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Scenario_GameData_Armies
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Scenario_GameData_Army> lArmies = new ArrayList<Scenario_GameData_Army>();

    public final void buildData() {
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            int j;
            if (CFG.core.getProv(i).getWastelandLvl() >= 0) continue;
            if (CFG.core.getProv(i).getSeaProv()) {
                for (j = 1; j < CFG.core.getProv(i).getCivsSize(); ++j) {
                    this.lArmies.add(new Scenario_GameData_Army(i, CFG.core.getProv(i).getCivId(j), CFG.core.getProv(i).getArmyID(j)));
                }
                continue;
            }
            if (CFG.core.getProv(i).getCivId() == 0) {
                if (CFG.core.getProv(i).getArmyID(0) == CFG.core.getGameScenars().getScenario_NeutralArmy()) continue;
                this.lArmies.add(new Scenario_GameData_Army(i, CFG.core.getProv(i).getCivId(), CFG.core.getProv(i).getArmyID(0)));
                continue;
            }
            j = 0;
            if (CFG.core.getProv(i).isCapital()) {
                if (CFG.core.getProv(i).getArmyID(0) != CFG.core.getGameScenars().getScenario_StartingArmyInCapitals()) {
                    this.lArmies.add(new Scenario_GameData_Army(i, CFG.core.getProv(i).getCivId(0), CFG.core.getProv(i).getArmyID(0)));
                }
                j = 1;
            }
            while (j < CFG.core.getProv(i).getCivsSize()) {
                if (CFG.core.getProv(i).getArmyID(j) > 0) {
                    this.lArmies.add(new Scenario_GameData_Army(i, CFG.core.getProv(i).getCivId(j), CFG.core.getProv(i).getArmyID(j)));
                }
                ++j;
            }
        }
    }
}

