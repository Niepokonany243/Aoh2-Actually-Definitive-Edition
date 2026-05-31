/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Civilizations;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Loans;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IdeologiesManager;
import java.io.Serializable;

public class Civ_Mission_ChangeTypeOfGovernment
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iToIdeologyID;
    public int iCost;

    public Civ_Mission_ChangeTypeOfGovernment(int iToIdeologyID, int nCivID) {
        this.iToIdeologyID = iToIdeologyID;
        this.iCost = IdeologiesManager.getChangeGovernmentCost(nCivID);
        this.action(nCivID);
    }

    public final boolean action(int nCivID) {
        if (CFG.core.getCiv(nCivID).getGold() >= (long)this.iCost) {
            if (!CFG.ideologiesMgr.canBeAdded(nCivID, this.iToIdeologyID)) {
                return true;
            }
            if (GameManager.changeGovernmentType(nCivID, this.iToIdeologyID)) {
                return true;
            }
            this.iCost = IdeologiesManager.getChangeGovernmentCost(nCivID);
            return false;
        }
        if (Loans.canTakeMoreLoans(nCivID) && CFG.core.getCiv(nCivID).getGold() + (long)Loans.takeLoan_MaxValue(nCivID) >= (long)this.iCost) {
            Loans.takeLoan(nCivID, (int)((long)this.iCost - CFG.core.getCiv(nCivID).getGold()), GameValues.gvLoan.LOAN_MIN_DURATION);
            if (!CFG.ideologiesMgr.canBeAdded(nCivID, this.iToIdeologyID)) {
                return true;
            }
            if (GameManager.changeGovernmentType(nCivID, this.iToIdeologyID)) {
                return true;
            }
        }
        return false;
    }
}

