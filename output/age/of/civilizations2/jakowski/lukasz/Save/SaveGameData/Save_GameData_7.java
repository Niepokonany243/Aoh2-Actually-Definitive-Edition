/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Save.SaveGameData;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.War_GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Save_GameData_7
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<War_GameData> lWars = new ArrayList<War_GameData>();

    public final void buildData() {
        for (int i = 0; i < CFG.core.getWarsSize(); ++i) {
            this.lWars.add(CFG.core.getWar(i));
        }
    }
}

