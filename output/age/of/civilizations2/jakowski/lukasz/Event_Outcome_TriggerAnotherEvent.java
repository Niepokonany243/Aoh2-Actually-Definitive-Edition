/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_TriggerAnotherEvent
extends Event_Outcome {
    private static final long serialVersionUID = -2936248442542094524L;
    public String sText = "";

    @Override
    public String getText() {
        return this.sText;
    }

    @Override
    public void setText(String nText) {
        this.sText = nText;
    }

    @Override
    public void outcomeAction() {
        if (this.canMakeAction()) {
            CFG.eventsManager.runEventTag(this.getText());
        }
    }

    public boolean canMakeAction() {
        return !this.sText.equals("");
    }

    @Override
    public String getConditionText() {
        try {
            String tempName = "";
            for (int i = 0; i < CFG.eventsManager.getEventsSize(); ++i) {
                if (!CFG.eventsManager.getEvent(i).getEventTag().equals(this.getText())) continue;
                tempName = CFG.eventsManager.getEvent(i).getEventName();
                break;
            }
            return CFG.lang.get("TriggerAnotherEvent") + ": " + tempName + "[" + this.getText() + "]";
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("TriggerAnotherEvent");
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        return new ArrayList<MEHover_2E>();
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_TRIGGERANOTHEREVENT);
    }
}

