/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Event_Decision
implements Serializable {
    private static final long serialVersionUID = 0L;
    public String sTitle = "";
    public List<Event_Outcome> lOutcomes = new ArrayList<Event_Outcome>();
    public int iAIChance = 100;
    public String sDesc = "";

    public final void executeDecision() {
        try {
            for (int i = 0; i < this.lOutcomes.size(); ++i) {
                this.lOutcomes.get(i).outcomeAction();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }
}

