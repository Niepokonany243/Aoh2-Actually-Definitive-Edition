/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class CivTask
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iProvinceID;
    public int iTurnsLeft;

    public CivTask(int iProvinceID, int iTurnsLeft) {
        this.iProvinceID = iProvinceID;
        this.iTurnsLeft = iTurnsLeft;
    }
}

