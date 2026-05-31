
package age.of.civilizations2.jakowski.lukasz.Provinces;

public class Point_XY {
    private int iPosX;
    private int iPosY;

    public Point_XY(int nPosX, int nPosY) {
        this.iPosX = nPosX;
        this.iPosY = nPosY;
    }

    public final int getPosX() {
        return this.iPosX;
    }

    public final void setPosX(int iPosX) {
        this.iPosX = iPosX;
    }

    public final int getPosY() {
        return this.iPosY;
    }

    public final void setPosY(int iPosY) {
        this.iPosY = iPosY;
    }
}

