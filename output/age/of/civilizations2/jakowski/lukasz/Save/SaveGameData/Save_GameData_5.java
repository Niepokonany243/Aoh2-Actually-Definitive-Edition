/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Save.SaveGameData;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.PlayerGD;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Save_GameData_5
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<PlayerGD> lPlayers = new ArrayList<PlayerGD>();

    public final void buildData() {
        for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
            this.lPlayers.add(CFG.core.getPlayer((int)i).playerGD);
        }
    }
}

