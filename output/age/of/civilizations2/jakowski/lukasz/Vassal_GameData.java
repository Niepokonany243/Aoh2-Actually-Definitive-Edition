/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import java.io.Serializable;

public class Vassal_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivID;
    public int iTribute;

    public Vassal_GameData(int iCivID) {
        this.iCivID = iCivID;
        this.setTribute(GameValues.gvVassal.PERCENTAGE_OF_INCOME_FOR_LORD_DEFAULT);
    }

    public final void setTribute(int iTribute) {
        if (iTribute > GameValues.gvVassal.PERCENTAGE_OF_INCOME_FOR_LORD_MAX) {
            iTribute = GameValues.gvVassal.PERCENTAGE_OF_INCOME_FOR_LORD_MAX;
        } else if (iTribute < 0) {
            iTribute = 0;
        }
        this.iTribute = iTribute;
    }
}

