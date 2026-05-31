
package age.of.civilizations2.jakowski.lukasz.MoveUnitsB.Line;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Image;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MoveUnits_Line {
    private int fromProvinceID;
    private int toProvinceID;
    public static int MOVE_SRC_X = 0;
    public static int MOVE_WIDTH = 0;
    private int iWidth;
    private float fAngle;
    public int offsetX = 0;
    public int offsetY = 0;
    public long lMovingTime = 0L;
    public float fMovingPercentage = 0.0f;

    public MoveUnits_Line() {
    }

    public MoveUnits_Line(int fromProvinceID, int toProvinceID) {
        this.fromProvinceID = fromProvinceID;
        this.toProvinceID = toProvinceID;
        if (!CFG.core.getProv(fromProvinceID).getDrawProv()) {
            CFG.core.updateDrawProvince(fromProvinceID);
        }
        if (!CFG.core.getProv(toProvinceID).getDrawProv()) {
            CFG.core.updateDrawProvince(toProvinceID);
        }
        this.iWidth = (int)Math.ceil(Math.sqrt((CFG.core.getProv(toProvinceID).getCeX() + CFG.core.getProv(toProvinceID).getShPX() + CFG.core.getProv(toProvinceID).getTranslateProvPosX() - (CFG.core.getProv(fromProvinceID).getCeX() + CFG.core.getProv(fromProvinceID).getShPX() + CFG.core.getProv(fromProvinceID).getTranslateProvPosX())) * (CFG.core.getProv(toProvinceID).getCeX() + CFG.core.getProv(toProvinceID).getShPX() + CFG.core.getProv(toProvinceID).getTranslateProvPosX() - (CFG.core.getProv(fromProvinceID).getCeX() + CFG.core.getProv(fromProvinceID).getShPX() + CFG.core.getProv(fromProvinceID).getTranslateProvPosX())) + (CFG.core.getProv(fromProvinceID).getCeY() + CFG.core.getProv(fromProvinceID).getShPY() - (CFG.core.getProv(toProvinceID).getCeY() + CFG.core.getProv(toProvinceID).getShPY())) * (CFG.core.getProv(fromProvinceID).getCeY() + CFG.core.getProv(fromProvinceID).getShPY() - (CFG.core.getProv(toProvinceID).getCeY() + CFG.core.getProv(toProvinceID).getShPY()))));
        this.fAngle = (float)(Math.atan2(CFG.core.getProv(fromProvinceID).getCeY() + CFG.core.getProv(fromProvinceID).getShPY() - (CFG.core.getProv(toProvinceID).getCeY() + CFG.core.getProv(toProvinceID).getShPY()), -(CFG.core.getProv(fromProvinceID).getCeX() + CFG.core.getProv(fromProvinceID).getShPX() + CFG.core.getProv(fromProvinceID).getTranslateProvPosX()) + (CFG.core.getProv(toProvinceID).getCeX() + CFG.core.getProv(toProvinceID).getShPX() + CFG.core.getProv(toProvinceID).getTranslateProvPosX())) * 180.0 / Math.PI);
        float tempAngle = this.fAngle > 90.0f ? 90.0f - this.fAngle % 90.0f : (this.fAngle < -90.0f ? -(90.0f + this.fAngle % 90.0f) : this.fAngle);
        this.offsetX = -((int)((float)this.getImageID().getHeight() / 2.0f * (tempAngle / 90.0f)));
        this.offsetY = -((int)((float)this.getImageID().getHeight() / 2.0f * ((90.0f - Math.abs(this.fAngle)) / 90.0f)));
        this.lMovingTime = System.currentTimeMillis();
        this.fMovingPercentage = 0.1f;
        MOVE_WIDTH = CFG.linesManager.moveLandImage.getWidth();
    }

    public void updateColor(SpriteBatch oSB) {
        oSB.setColor(Color.WHITE);
    }

    public void updateMovingLine() {
        this.fMovingPercentage += (float)(System.currentTimeMillis() - this.lMovingTime) / 600.0f * 0.9f;
    }

    public void drawLine(SpriteBatch oSB, float nScale) {
        this.updateColor(oSB);
        this.drawLine2(oSB, nScale);
    }

    public void drawLine2(SpriteBatch oSB, float nScale) {
        this.updateMovingLine();
        this.lMovingTime = System.currentTimeMillis();
        if (this.fMovingPercentage >= 1.0f) {
            this.fMovingPercentage = 1.0f;
        } else {
            CFG.setRenderO(true);
        }
        this.getImageID().drawO(oSB, (int)((float)(CFG.core.getProv(this.fromProvinceID).getCeX() + CFG.core.getProv(this.fromProvinceID).getShPX() + CFG.core.getProv(this.fromProvinceID).getTranslateProvPosX()) * nScale) + this.offsetX, (int)((float)(CFG.core.getProv(this.fromProvinceID).getCeY() + CFG.core.getProv(this.fromProvinceID).getShPY() + CFG.map.getMpC().getPY()) * nScale) + this.offsetY, (int)((float)this.iWidth * this.fMovingPercentage * nScale), this.getImageID().getHeight(), this.fAngle, this.getMoveSrcX(), this.getFlipX());
        oSB.setColor(Color.WHITE);
    }

    public int getMoveSrcX() {
        return MOVE_SRC_X;
    }

    public boolean getFlipX() {
        return CFG.linesManager.moveLandFlipX;
    }

    public Image getImageID() {
        return CFG.linesManager.moveLandImage;
    }

    public final int getFromProvinceID() {
        return this.fromProvinceID;
    }

    public final void setFromProvinceID(int fromProvinceID) {
        this.fromProvinceID = fromProvinceID;
    }

    public final int getToProvinceID() {
        return this.toProvinceID;
    }

    public final void setToProvinceID(int toProvinceID) {
        this.toProvinceID = toProvinceID;
    }

    public final int getWidth() {
        return this.iWidth;
    }

    public final void setWidth(int iWidth) {
        this.iWidth = iWidth;
    }

    public final float getAngle() {
        return this.fAngle;
    }

    public final void setAngle(float fAngle) {
        this.fAngle = fAngle;
    }

    public final float getMovingPercentage() {
        return this.fMovingPercentage;
    }

    public final void updateMoveTime() {
        this.lMovingTime = System.currentTimeMillis();
        this.fMovingPercentage = 0.1f;
    }
}

