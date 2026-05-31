
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Event_Conditions;
import age.of.civilizations2.jakowski.lukasz.Event_Type;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Event_Trigger
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Event_Conditions> lConditions = new ArrayList<Event_Conditions>();
    public Event_Type triggerType = Event_Type.AND;

    public final boolean getTriggerOut() {
        int i;
        for (i = 0; i < this.lConditions.size(); ++i) {
            if (this.lConditions.get((int)i).conditionType != Event_Type.OR || !this.lConditions.get(i).outCondition()) continue;
            return true;
        }
        for (i = 0; i < this.lConditions.size(); ++i) {
            if (this.lConditions.get((int)i).conditionType == Event_Type.OR || !(this.lConditions.get((int)i).conditionType == Event_Type.AND ? !this.lConditions.get(i).outCondition() : this.lConditions.get((int)i).conditionType == Event_Type.NOT && this.lConditions.get(i).outCondition())) continue;
            return false;
        }
        return true;
    }

    public final String getTriggerText() {
        String out = "";
        int i = 0;
        while (i < this.lConditions.size() & i < 5) {
            out = out + "" + this.lConditions.get(i).getConditionText() + " ";
            ++i;
        }
        return out;
    }
}

