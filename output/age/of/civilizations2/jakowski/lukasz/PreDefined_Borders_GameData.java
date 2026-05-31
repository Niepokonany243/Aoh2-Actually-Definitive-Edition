/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.PreDefined_Borders_Data_GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PreDefined_Borders_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private List<PreDefined_Borders_Data_GameData> lData = new ArrayList<PreDefined_Borders_Data_GameData>();

    public final int getDataSize() {
        return this.lData.size();
    }

    public final PreDefined_Borders_Data_GameData getData(int i) {
        return this.lData.get(i);
    }

    public final void removeData(int i) {
        this.lData.remove(i);
    }

    public final void addData(PreDefined_Borders_Data_GameData nData) {
        this.lData.add(nData);
    }
}

