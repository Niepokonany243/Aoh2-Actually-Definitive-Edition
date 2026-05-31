
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FormableCivs_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sFormableCivTag = null;
    private List<String> sClaimants = new ArrayList<String>();
    private List<Integer> lProvinces = new ArrayList<Integer>();
    private int iCapitalProvinceID = -1;
    private float fRequiredPerc = -1.0f;

    public final void addClaimant(String nTag) {
        if (this.sFormableCivTag != null && this.sFormableCivTag.equals(nTag)) {
            return;
        }
        for (int i = 0; i < this.sClaimants.size(); ++i) {
            if (!this.sClaimants.get(i).equals(nTag)) continue;
            return;
        }
        this.sClaimants.add(nTag);
    }

    public final void removeClaimant(int i) {
        this.sClaimants.remove(i);
    }

    public final String getClaimant(int i) {
        return this.sClaimants.get(i);
    }

    public final int getClaimantsSize() {
        return this.sClaimants.size();
    }

    public final void addProvince(int nProvince) {
        this.lProvinces.add(nProvince);
    }

    public final int getProvinceID(int i) {
        return this.lProvinces.get(i);
    }

    public final int getProvincesSize() {
        return this.lProvinces.size();
    }

    public final void clearProvinces() {
        this.lProvinces.clear();
    }

    public final void setCapitalProvinceID(int iCapitalProvinceID) {
        this.iCapitalProvinceID = iCapitalProvinceID;
    }

    public final int getCapitalProvinceID() {
        return this.iCapitalProvinceID;
    }

    public final String getFormableCivTag() {
        return this.sFormableCivTag;
    }

    public final void setFormableCivTag(String sFormableCivTag) {
        this.sFormableCivTag = sFormableCivTag;
    }

    public final float getRequiredPerc() {
        if (this.fRequiredPerc <= 0.0f || this.fRequiredPerc > 1.0f) {
            return 1.0f;
        }
        return this.fRequiredPerc;
    }

    public final void setRequiredPerc(float fRequiredPerc) {
        this.fRequiredPerc = fRequiredPerc;
    }
}

