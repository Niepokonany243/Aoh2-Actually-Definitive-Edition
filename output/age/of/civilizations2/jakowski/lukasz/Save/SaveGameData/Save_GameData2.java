/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Save.SaveGameData;

import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import java.io.Serializable;

public class Save_GameData2
implements Serializable {
    private static final long serialVersionUID = 0L;
    public float AI_AGGRESSIVENESS;

    public final void buildData() {
        this.AI_AGGRESSIVENESS = GameCalendar.AI_AGGRESSIVENESS;
    }
}

