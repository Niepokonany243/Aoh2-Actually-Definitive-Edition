/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Save.SaveGameData;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_GameData_MessageData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Save_GameData_8
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<PeaceTreaty_GameData_MessageData> lPeaceTreaties = new ArrayList<PeaceTreaty_GameData_MessageData>();

    public final void buildData() {
        for (int i = 0; i < CFG.core.lPeaceTreaties.size(); ++i) {
            this.lPeaceTreaties.add(CFG.core.lPeaceTreaties.get(i));
        }
    }
}

