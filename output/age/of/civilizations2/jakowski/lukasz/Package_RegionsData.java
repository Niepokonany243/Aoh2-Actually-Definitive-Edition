/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Package_RegionsData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sPackageName = "";
    private List<String> lRegionsTags = new ArrayList<String>();

    public final String getPackageName() {
        return this.sPackageName;
    }

    public final void setPackageName(String sPackageName) {
        this.sPackageName = sPackageName;
    }

    public final String getRegionTag(int i) {
        return this.lRegionsTags.get(i);
    }

    public final int getRegionsTagsSize() {
        return this.lRegionsTags.size();
    }

    public final void addRegionTag(String sTag) {
        this.lRegionsTags.add(sTag);
    }

    public final void removeRegionTag(int i) {
        this.lRegionsTags.remove(i);
    }
}

