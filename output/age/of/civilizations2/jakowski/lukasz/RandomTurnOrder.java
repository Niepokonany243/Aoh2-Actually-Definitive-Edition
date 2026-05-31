/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomTurnOrder {
    private List<Integer> lRandomTurnOrder = new ArrayList<Integer>();
    private int iRTOSize = 0;

    public final void buildRandomOrder() {
        this.lRandomTurnOrder.clear();
        ArrayList<Integer> tempIDs = new ArrayList<Integer>();
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            tempIDs.add(i);
        }
        Collections.shuffle(tempIDs, CFG.oR);
        this.lRandomTurnOrder.addAll(tempIDs);
        this.iRTOSize = this.lRandomTurnOrder.size();
    }

    public final int getRTO(int i) {
        return this.lRandomTurnOrder.get(i);
    }

    public final int getPositionInRTOOfCiv(int nCivID) {
        for (int i = 0; i < this.iRTOSize; ++i) {
            if (nCivID != this.lRandomTurnOrder.get(i)) continue;
            return i + 1;
        }
        return 0;
    }

    public final int getRTOSize() {
        return this.iRTOSize;
    }

    public static String getSGly() {
        return "Age of History 2: Definitive Edition";
    }
}

