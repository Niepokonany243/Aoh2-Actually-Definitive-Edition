/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

public class Province_Border_Line {
    private int posX;
    private int posY;
    private int iWidth;
    private float fAngle;

    public Province_Border_Line(int nPosX, int nPosY, int nPosX2, int nPosY2) {
        this.posX = nPosX;
        this.posY = nPosY;
        this.iWidth = (int)Math.ceil(Math.sqrt((nPosX2 - nPosX) * (nPosX2 - nPosX) + (nPosY - nPosY2) * (nPosY - nPosY2)));
        this.fAngle = (float)(Math.atan2(nPosY - nPosY2, -nPosX + nPosX2) * 180.0 / Math.PI);
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public int getWidth() {
        return this.iWidth;
    }

    public float getAngle() {
        return this.fAngle;
    }
}

