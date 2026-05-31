/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Save.SaveGameData;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Save.Save_CivDiplo_GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Save_GameData_3
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Save_CivDiplo_GameData> lCivsDiploData = new ArrayList<Save_CivDiplo_GameData>();

    public final void buildData() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            this.lCivsDiploData.add(new Save_CivDiplo_GameData(i));
        }
    }
}

