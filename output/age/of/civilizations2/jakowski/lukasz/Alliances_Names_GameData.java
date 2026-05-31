/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Alliances_Names_GameData_Bundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Alliances_Names_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sPackageName = "";
    private List<Alliances_Names_GameData_Bundle> lBundles = new ArrayList<Alliances_Names_GameData_Bundle>();

    public final Alliances_Names_GameData_Bundle getBundle(int i) {
        return this.lBundles.get(i);
    }

    public final void addBundle(String nWord) {
        this.lBundles.add(new Alliances_Names_GameData_Bundle(nWord));
    }

    public final void removeBundle(int i) {
        this.lBundles.remove(i);
    }

    public final int getSize() {
        return this.lBundles.size();
    }

    public final String getPackageName() {
        return this.sPackageName;
    }

    public final void setPackageName(String sPackageName) {
        this.sPackageName = sPackageName;
    }
}

