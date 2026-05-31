/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI.FrontLine;

import age.of.civilizations2.jakowski.lukasz.AI.FrontLine.AI_Frontline;
import java.util.ArrayList;
import java.util.List;

public class AI_Frontline_AI {
    private List<AI_Frontline> lFrontLines = new ArrayList<AI_Frontline>();
    private List<Boolean> lFrontLines_OwnFront = new ArrayList<Boolean>();
    private int iFrontLinesSize = 0;
    private int iWithCivID = 0;

    public AI_Frontline_AI(int iWithCivID, AI_Frontline nFront, boolean ownFront) {
        this.iWithCivID = iWithCivID;
        this.lFrontLines.add(nFront);
        this.lFrontLines_OwnFront.add(ownFront);
        this.iFrontLinesSize = this.lFrontLines.size();
    }

    public final void addFrontLine(AI_Frontline nFront, boolean ownFront) {
        this.lFrontLines.add(nFront);
        this.lFrontLines_OwnFront.add(ownFront);
        this.iFrontLinesSize = this.lFrontLines.size();
    }

    public final AI_Frontline getFrontLine(int id) {
        return this.lFrontLines.get(id);
    }

    public final int getFrontLinesSize() {
        return this.iFrontLinesSize;
    }

    public final int getWithCivID() {
        return this.iWithCivID;
    }

    public boolean ownFront(int i) {
        return this.lFrontLines_OwnFront.get(i);
    }
}

