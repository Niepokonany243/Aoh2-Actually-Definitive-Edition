/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Save.SaveGameData;

import age.of.civilizations2.jakowski.lukasz.Alliance;
import age.of.civilizations2.jakowski.lukasz.CFG;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Save_GameData_6
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Alliance> lAlliances = new ArrayList<Alliance>();

    public final void buildData() {
        for (int i = 0; i < CFG.core.getAlliancesSize(); ++i) {
            this.lAlliances.add(CFG.core.getAlliance(i));
        }
    }
}

