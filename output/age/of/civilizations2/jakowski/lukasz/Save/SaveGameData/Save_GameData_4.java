/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Save.SaveGameData;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Save.Province_Save_GD;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Save_GameData_4
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Province_Save_GD> lProvincesData = new ArrayList<Province_Save_GD>();

    public final void buildData(int startID) {
        int i = startID;
        for (int j = 0; i < CFG.core.getProvinSize() && j < SaveGameManager.PROVINCES_PER_FILE; ++i, ++j) {
            this.lProvincesData.add(CFG.core.getProv((int)i).provGD);
        }
    }
}

