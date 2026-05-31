
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.HolyRomanEmpire_Manager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class ProvincesDrag {
    private List<Integer> provincesID = new ArrayList<Integer>();
    private int provincesSize;
    public long lTime = 0L;
    public int iAlpha = 50;
    public int iStepID = 0;
    public boolean backAnimation = false;
    public long lTimeBorder = 0L;
    public int iStepIDBorder = 0;
    public int iBorderAlpha = 255;
    public boolean backAnimationBorder = false;

    public void updateColor(SpriteBatch oSB) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, (float)this.iAlpha * 1.6f / 255.0f));
    }

    public final void draw(SpriteBatch oSB) {
        this.update();
        this.updateColor(oSB);
        for (int i = 0; i < this.provincesSize; ++i) {
            if (!CFG.core.getProv(this.provincesID.get(i)).getDrawProv()) continue;
            CFG.core.getProv(this.provincesID.get(i)).drawProv_ActiveProv(oSB);
        }
    }

    public final void draw_CreateAVassal(SpriteBatch oSB) {
        this.update();
        oSB.setColor(new Color(CFG.createVassalData.oColor.r, CFG.createVassalData.oColor.g, CFG.createVassalData.oColor.b, (float)this.iAlpha * 1.6f / 255.0f));
        for (int i = 0; i < this.provincesSize; ++i) {
            if (!CFG.core.getProv(this.provincesID.get(i)).getDrawProv()) continue;
            CFG.core.getProv(this.provincesID.get(i)).drawProv_ActiveProv(oSB);
        }
    }

    public final void draw_HolyRomanEmpire(SpriteBatch oSB) {
        this.update();
        oSB.setColor(new Color(HolyRomanEmpire_Manager.oColorHRE.r, HolyRomanEmpire_Manager.oColorHRE.g, HolyRomanEmpire_Manager.oColorHRE.b, (float)this.iAlpha * (CFG.VIEW_SHOW_VALUES ? 3.0f : 2.4f) / 255.0f));
        for (int i = 0; i < this.provincesSize; ++i) {
            if (!CFG.core.getProv(this.provincesID.get(i)).getDrawProv()) continue;
            CFG.core.getProv(this.provincesID.get(i)).drawProv_ActiveProv(oSB);
        }
    }

    public final boolean addProv(int nProvinceID) {
        for (int i = 0; i < this.provincesSize; ++i) {
            if (this.provincesID.get(i) != nProvinceID) continue;
            return false;
        }
        this.provincesID.add(nProvinceID);
        this.provincesSize = this.provincesID.size();
        return true;
    }

    public final void popProvince() {
        if (this.provincesID.size() > 0) {
            this.removeProv(this.provincesID.get(this.getProvSize() - 1));
        }
    }

    public final boolean removeProv(int nProvinceID) {
        for (int i = 0; i < this.provincesSize; ++i) {
            if (this.provincesID.get(i) != nProvinceID) continue;
            this.provincesID.remove(i);
            this.provincesSize = this.provincesID.size();
            return true;
        }
        return false;
    }

    public final void clearSelectedProvinces() {
        this.provincesID.clear();
        this.provincesSize = 0;
    }

    public final boolean checkIfExists(int nProvinceID) {
        for (int i = 0; i < this.provincesSize; ++i) {
            if (this.provincesID.get(i) != nProvinceID) continue;
            return true;
        }
        return false;
    }

    public final void updateArmies_CivID(int nCivID, long nArmy) {
        for (int i = 0; i < this.getProvSize(); ++i) {
            if (!CFG.gameAction.hasArmyInProvince(this.getProv(i), nCivID) && !this.canAddArmy(nCivID, this.getProv(i)) || nArmy == CFG.core.getProv(this.getProv(i)).getArmyCivID1(nCivID)) continue;
            CFG.core.getProv(this.getProv(i)).updateArmy4(nCivID, nArmy);
        }
    }

    public final boolean canAddArmy(int nCivID, int nProvinceID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getAlliance() == CFG.core.getCiv(nCivID).getAlliance()) {
            return true;
        }
        return CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getPuppetOfCiv() == nCivID;
    }

    public final void update() {
        this.updateProvinceAlpha();
        this.updateBorderAlpha();
    }

    public void updateProvinceAlpha() {
        if (this.lTime < System.currentTimeMillis() - 25L) {
            ++this.iStepID;
            this.iAlpha = this.backAnimation ? ++this.iAlpha : --this.iAlpha;
            this.lTime = System.currentTimeMillis();
            if (this.iStepID == 30) {
                this.iStepID = 0;
                this.backAnimation = !this.backAnimation;
                this.lTime += this.backAnimation ? 450L : 600L;
            }
        }
    }

    public void updateBorderAlpha() {
        if (this.lTimeBorder < System.currentTimeMillis() - 30L) {
            ++this.iStepIDBorder;
            this.iBorderAlpha = this.backAnimationBorder ? (this.iBorderAlpha += 3) : (this.iBorderAlpha -= 3);
            this.lTimeBorder = System.currentTimeMillis();
            if (this.iStepIDBorder == 45) {
                this.iStepIDBorder = 0;
                this.backAnimationBorder = !this.backAnimationBorder;
                this.lTimeBorder += this.backAnimationBorder ? 225L : 300L;
            }
        }
    }

    public final boolean canBeReleasedAsVassal(int nCivID, int nProvinceID) {
        if (CFG.core.getCiv(nCivID).getCapitalProvID() == nProvinceID) {
            return false;
        }
        return CFG.core.getProv(nProvinceID).getCivId() == nCivID && CFG.core.getProv(nProvinceID).getTrueOwnerOfProv() == nCivID;
    }

    public final List<Integer> getProv() {
        return this.provincesID;
    }

    public final int getProv(int i) {
        return this.provincesID.get(i);
    }

    public final int getProvSize() {
        return this.provincesSize;
    }
}

