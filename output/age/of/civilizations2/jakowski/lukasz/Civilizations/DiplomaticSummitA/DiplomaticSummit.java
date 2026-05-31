/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Civilizations.DiplomaticSummitA;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DiplomaticSummit
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int civHostID;
    public List<Integer> invitedCivs = new ArrayList<Integer>();
    public int endTurnID = 0;

    public boolean isInvited(int nCivID) {
        for (int i = this.invitedCivs.size() - 1; i >= 0; --i) {
            if (this.invitedCivs.get(i) != nCivID) continue;
            return true;
        }
        return false;
    }
}

