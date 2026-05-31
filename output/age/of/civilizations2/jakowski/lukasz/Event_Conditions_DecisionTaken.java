/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions;
import age.of.civilizations2.jakowski.lukasz.View;

public class Event_Conditions_DecisionTaken
extends Event_Conditions {
    private static final long serialVersionUID = 2539742223368103510L;
    private String sTag = "";
    private int iCivID = -1;

    @Override
    public String getText() {
        return this.sTag;
    }

    @Override
    public void setText(String nText) {
        this.sTag = nText;
    }

    @Override
    public void setCivID(int nCivID) {
        this.iCivID = nCivID;
    }

    @Override
    public int getCivID() {
        return this.iCivID;
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
        if (this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize()) {
            return CFG.core.getCiv(this.getCivID()).getEventTookDecision(this.getText());
        }
        for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
            if (!CFG.core.getCiv(i).getEventTookDecision(this.getText())) continue;
            return true;
        }
        return false;
    }

    @Override
    public String getConditionText() {
        try {
            String tName = "";
            try {
                if (CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).getText().length() > 0) {
                    String[] tData = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).lConditions.get(CFG.eventsManager.createEvent_EditConditionID).getText().split("_");
                    int tID = Integer.parseInt(tData[1]);
                    for (int i = 0; i < CFG.eventsManager.getEventsSize(); ++i) {
                        if (!tData[0].equals(CFG.eventsManager.getEvent(i).getEventTag())) continue;
                        tName = CFG.eventsManager.getEvent((int)i).lDecisions.get((int)tID).sTitle;
                        try {
                            tName = tName + " - [" + CFG.core.getCiv(CFG.eventsManager.getEvent(i).getCivID()).getCivName() + "]";
                            continue;
                        }
                        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            // empty catch block
                        }
                    }
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            return CFG.lang.get("DecisionTaken") + ": " + (tName.length() == 0 ? "NOT FOUND!" : tName);
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("DecisionTaken");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_DECISIONTAKEN);
    }
}

