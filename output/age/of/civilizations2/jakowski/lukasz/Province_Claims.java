package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Province_Claims implements Serializable {
    private static final long serialVersionUID = 0L;
    private List<Integer> lCivs = new ArrayList<Integer>();
    private int iCivsSize = 0;

    public final synchronized void addClaim(int nCivID) {
        for (int i = 0; i < this.iCivsSize; ++i) {
            if (this.lCivs.get(i) != nCivID) continue;
            return;
        }
        this.lCivs.add(nCivID);
        this.iCivsSize = this.lCivs.size();
    }

    public final synchronized void removeClaim(int nCivID) {
        for (int i = 0; i < this.iCivsSize; ++i) {
            if (this.lCivs.get(i) != nCivID) continue;
            this.lCivs.remove(i);
            this.iCivsSize = this.lCivs.size();
            break;
        }
    }

    public final boolean getHaveClaim(int nCivID) {
        for (int i = 0; i < this.getCivsSize(); ++i) {
            if (nCivID != this.getCivID(i)) continue;
            return true;
        }
        return false;
    }

    public final int getCivID(int i) {
        return this.lCivs.get(i);
    }

    public final int getCivsSize() {
        return this.iCivsSize;
    }

    public final synchronized void clearData() {
        this.lCivs = new ArrayList<Integer>();
        this.iCivsSize = 0;
    }
}
