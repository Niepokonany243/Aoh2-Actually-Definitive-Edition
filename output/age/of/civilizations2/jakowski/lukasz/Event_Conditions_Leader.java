/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions;
import age.of.civilizations2.jakowski.lukasz.View;

public class Event_Conditions_Leader
extends Event_Conditions {
    private static final long serialVersionUID = 425794882670670658L;
    public int iCivID = -1;
    public String leaderName = "";

    @Override
    public int getCivID() {
        return this.iCivID;
    }

    @Override
    public void setCivID(int nCivID) {
        this.iCivID = nCivID;
    }

    @Override
    public void setText(String nText) {
        this.leaderName = nText;
    }

    @Override
    public String getText() {
        return this.leaderName;
    }

    @Override
    public boolean updateCivIDAfterRemove(int nRemovedCivID) {
        if (this.iCivID == nRemovedCivID) {
            this.iCivID = -1;
            return true;
        }
        if (nRemovedCivID < this.iCivID) {
            --this.iCivID;
        }
        return false;
    }

    @Override
    public boolean outCondition() {
        try {
            if (this.leaderName.length() <= 0 && CFG.core.getCiv((int)this.getCivID()).civGD.leaderData == null || CFG.core.getCiv((int)this.getCivID()).civGD.leaderData.getName().length() <= 0) {
                return true;
            }
            return CFG.core.getCiv((int)this.getCivID()).civGD.leaderData.getName().equals(this.leaderName);
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("Leader") + ": " + this.leaderName;
        }
        catch (Exception ex) {
            return CFG.lang.get("Leader");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_LEADER);
    }
}

