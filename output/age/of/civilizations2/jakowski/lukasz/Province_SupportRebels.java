/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class Province_SupportRebels
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iRebelsCivID;
    public int iByCivID;
    public int iTurnsLeft;

    public Province_SupportRebels(int iByCivID, int iRebelsCivID, int iTurnsLeft) {
        this.iByCivID = iByCivID;
        this.iRebelsCivID = iRebelsCivID;
        this.iTurnsLeft = iTurnsLeft;
    }
}

