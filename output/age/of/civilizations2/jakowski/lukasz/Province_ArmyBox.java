
package age.of.civilizations2.jakowski.lukasz;

public class Province_ArmyBox {
    private int iStartPosX;
    private int iStartPosY;
    private int iEndPosX;
    private int iEndPosY;

    public Province_ArmyBox(int iStartPosX, int iStartPosY, int iEndPosX, int iEndPosY) {
        this.iStartPosX = iStartPosX;
        this.iStartPosY = iStartPosY;
        this.iEndPosX = iEndPosX;
        this.iEndPosY = iEndPosY;
    }

    public final int getStartPosX() {
        return this.iStartPosX;
    }

    public final int getStartPosY() {
        return this.iStartPosY;
    }

    public final int getEndPosX() {
        return this.iEndPosX;
    }

    public final int getEndPosY() {
        return this.iEndPosY;
    }
}

