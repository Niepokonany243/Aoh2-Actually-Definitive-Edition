/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import java.io.Serializable;

public class Civilization_Diplomacy_ImproveRelations_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iWithCivID = 0;
    public int iNumOfTurns = 0;

    public Civilization_Diplomacy_ImproveRelations_GameData(int iWithCivID, int iNumOfTurns, int byCivID) {
        this.iWithCivID = iWithCivID;
        this.iNumOfTurns = iNumOfTurns;
        GameManager.improveRelationAddMessage(iWithCivID, byCivID);
    }

    public final boolean action(int iCivA) {
        boolean out;
        boolean bl = out = !GameManager.improveRelation(iCivA, this.iWithCivID) || --this.iNumOfTurns <= 0;
        if (CFG.core.getCiv(iCivA).getDiploPoints() >= GameValues.gvRelationImprove.COST_OFFER_IMPROVE_RELATIONS_DIPLOMACY_POINTS) {
            CFG.core.getCiv(iCivA).setDiploPoints(CFG.core.getCiv(iCivA).getDiploPoints() - GameValues.gvRelationImprove.COST_OFFER_IMPROVE_RELATIONS_DIPLOMACY_POINTS);
        }
        return out;
    }
}

