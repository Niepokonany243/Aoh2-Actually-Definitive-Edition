/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions;
import age.of.civilizations2.jakowski.lukasz.View;

public class Event_Conditions_EventChance
extends Event_Conditions {
    private static final long serialVersionUID = 6777844131404753890L;
    public long iValue = 40;

    @Override
    public long getValue() {
        return this.iValue;
    }

    @Override
    public void setValue(long iValue) {
        this.iValue = iValue;
    }

    @Override
    public boolean outCondition() {
        return CFG.oR.nextInt(100) <= this.getValue();
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("EventChance") + ": " + this.getValue() + "%";
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("EventChance");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_EVENTCHANCE);
    }
}

