
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;

public class VictoryManager {
    public static int VICTORY_CONTROL_PROVINCES_PERC = 100;
    public static int VICTORY_LIMIT_OF_TURNS = 0;
    public static float VICTORY_TECHNOLOGY = 0.0f;
    public static int domination_NumOfCivsInGame = 1;
    public static int controlProvinces_NumOfProvinces = 1;

    public static float getDefault_VictoryTechnology() {
        return 0.0f;
    }

    public static final void checkVictoryConditions() {
        int i;
        VictoryManager.updateVictoryConditions();
        if (VICTORY_TECHNOLOGY > 0.0f) {
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (!(VICTORY_TECHNOLOGY <= CFG.core.getCiv(i).getTechLevel())) continue;
                VICTORY_TECHNOLOGY = CFG.core.getCiv(i).getTechLevel() + 0.01f;
                if (!(CFG.core.getCiv(i).getTechLevel() >= 1.0f)) continue;
                VICTORY_TECHNOLOGY = 0.0f;
                break;
            }
        }
        if (VICTORY_CONTROL_PROVINCES_PERC < 100) {
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (!(VictoryManager.controlProvinces_GetCivScore(i) >= (float)VICTORY_CONTROL_PROVINCES_PERC)) continue;
                VICTORY_CONTROL_PROVINCES_PERC = (int)Math.ceil(VictoryManager.controlProvinces_GetCivScore(i)) + 1;
            }
        }
    }

    public static final void updateVictoryConditions() {
        VictoryManager.domination_UpdateNumOfCivs();
        VictoryManager.controlProvinces_UpdateNumOfProvinces();
    }

    public static final void domination_UpdateNumOfCivs() {
        domination_NumOfCivsInGame = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            ++domination_NumOfCivsInGame;
        }
        domination_NumOfCivsInGame = Math.max(domination_NumOfCivsInGame, 1);
    }

    public static final int domination_CivScore(int nCivID) {
        if (CFG.core.getCiv(nCivID).getNumOfProvs() <= 0) {
            return CFG.core.getCiv(nCivID).getNumOfProvs();
        }
        int out = 1;
        for (int i = CFG.core.getCiv((int)nCivID).civGD.vassals.size() - 1; i >= 0; --i) {
            if (CFG.core.getCiv(CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)i).iCivID).getNumOfProvs() <= 0) continue;
            ++out;
        }
        return out;
    }

    public static final void controlProvinces_UpdateNumOfProvinces() {
        controlProvinces_NumOfProvinces = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            controlProvinces_NumOfProvinces += CFG.core.getCiv(i).getNumOfProvs();
        }
        controlProvinces_NumOfProvinces = Math.max(controlProvinces_NumOfProvinces, 1);
    }

    public static final float controlProvinces_GetCivScore(int nCivID) {
        return (float)CFG.core.getCiv(nCivID).getNumOfProvs() / (float)controlProvinces_NumOfProvinces * 100.0f;
    }

    public static int turnsLimit_TurnsLeft() {
        return VICTORY_LIMIT_OF_TURNS - GameCalendar.TURNID;
    }

    public static int technology_BestCiv() {
        int iBest = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || !(CFG.core.getCiv(iBest).getTechLevel() < CFG.core.getCiv(i).getTechLevel()) && iBest != 0) continue;
            iBest = i;
        }
        return iBest;
    }
}

