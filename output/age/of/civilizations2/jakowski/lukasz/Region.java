
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import java.util.ArrayList;
import java.util.List;

public class Region {
    private List<Integer> lProvinces = new ArrayList<Integer>();
    private int iProvincesSize = 0;
    private int iMinX;
    private int iMaxX;
    private int iMinY;
    private int iMaxY;
    private boolean belowZero = false;

    public final void addProvince(int nProvinceID) {
        this.lProvinces.add(nProvinceID);
    }

    public final void removeProvince(int i) {
        this.lProvinces.remove(i);
        this.iProvincesSize = this.lProvinces.size();
    }

    public final void buildRegionBounds() {
        if (this.lProvinces.size() > 0) {
            this.iMinX = CFG.core.getProv(this.lProvinces.get(0)).getMiX2();
            this.iMaxX = CFG.core.getProv(this.lProvinces.get(0)).getMaX7();
            this.iMinY = CFG.core.getProv(this.lProvinces.get(0)).getMiY4();
            this.iMaxY = CFG.core.getProv(this.lProvinces.get(0)).getMaY6();
            this.iProvincesSize = this.lProvinces.size();
            for (int i = 1; i < this.iProvincesSize; ++i) {
                if (CFG.core.getProv(this.lProvinces.get(i)).getMiX2() < this.iMinX) {
                    this.iMinX = CFG.core.getProv(this.lProvinces.get(i)).getMiX2();
                }
                if (CFG.core.getProv(this.lProvinces.get(i)).getMaX7() > this.iMaxX) {
                    this.iMaxX = CFG.core.getProv(this.lProvinces.get(i)).getMaX7();
                }
                if (CFG.core.getProv(this.lProvinces.get(i)).getMiY4() < this.iMinY) {
                    this.iMinY = CFG.core.getProv(this.lProvinces.get(i)).getMiY4();
                }
                if (CFG.core.getProv(this.lProvinces.get(i)).getMaY6() <= this.iMaxY) continue;
                this.iMaxY = CFG.core.getProv(this.lProvinces.get(i)).getMaY6();
            }
            this.belowZero = this.iMinX < 0;
        }
    }

    public final int getProvince(int i) {
        return this.lProvinces.get(i);
    }

    public final int getProvincesSize() {
        return this.iProvincesSize;
    }

    public final int getProvincesSize2() {
        return this.lProvinces.size();
    }

    public final int getMinX() {
        return this.iMinX;
    }

    public final int getMaxX() {
        return this.iMaxX;
    }

    public final int getMinY() {
        return this.iMinY;
    }

    public final int getMaxY() {
        return this.iMaxY;
    }

    public final boolean getBelowZero() {
        return this.belowZero;
    }
}

