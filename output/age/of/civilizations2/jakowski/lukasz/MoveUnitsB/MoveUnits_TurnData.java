/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MoveUnitsB;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.MoveUnits;
import java.util.ArrayList;
import java.util.List;

public class MoveUnits_TurnData {
    private List<MoveUnits> lMoveUnits = new ArrayList<MoveUnits>();
    private int iMoveUnitsSize = 0;
    private List<Integer> lCivID = new ArrayList<Integer>();

    public MoveUnits_TurnData(int iCivID) {
    }

    public final int getMoveUnitsSize() {
        return this.iMoveUnitsSize;
    }

    public final void addMoveUnits(MoveUnits nMoveUnits, int nCivID) {
        if (nMoveUnits.getMoveUnits_Line() == null) {
            nMoveUnits.buildMoveUnitsLine();
        }
        this.lMoveUnits.add(nMoveUnits);
        this.lCivID.add(nCivID);
        this.iMoveUnitsSize = this.lMoveUnits.size();
    }

    public final MoveUnits getMoveUnits(int i) {
        return this.lMoveUnits.get(i);
    }

    public final long getMoveUnits_TotalNumOfUnits() {
        long out = 0L;
        for (int i = 0; i < this.iMoveUnitsSize; ++i) {
            out += this.lMoveUnits.get(i).getNumberOfUnits();
        }
        return out;
    }

    public final int getCivID(int i) {
        return this.lCivID.get(i);
    }

    public final boolean isPlayerMoving() {
        for (int i = 0; i < this.iMoveUnitsSize; ++i) {
            if (!CFG.core.getCiv(this.lCivID.get(i)).getIsPlayer()) continue;
            return true;
        }
        return false;
    }
}

