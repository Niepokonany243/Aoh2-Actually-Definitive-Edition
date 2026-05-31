
package age.of.civilizations2.jakowski.lukasz.Ships;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Ships.ShipManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ship2 {
    public static final int IMG_WH = 32;
    public float posX;
    public float posY;
    public int angle;
    public int shipLineID;
    public int shipIMGID;
    public float speed;
    public float currentWidth = 0.0f;
    public int tID = 0;
    public boolean movingBack = false;
    public boolean isInView;
    public boolean remove = false;

    public Ship2(int nShipLineID) {
        this.shipLineID = nShipLineID;
        this.randomize();
    }

    public final void randomize() {
        this.shipIMGID = CFG.oR.nextInt(GameValues.gvShips.SHIP_IMAGES);
        this.speed = GameValues.gvShips.SHIP_SPEED_MIN + (float)CFG.oR.nextInt(GameValues.gvShips.SHIP_SPEED_RANDOM) / 100.0f;
    }

    public final void update() {
        this.currentWidth += this.speed;
        if (this.movingBack) {
            if (this.currentWidth >= (float)ShipManager.shipLines.get((int)this.shipLineID).width.get(this.tID - 1).intValue()) {
                if (--this.tID < 1) {
                    this.tID = 0;
                    this.movingBack = false;
                    this.randomize();
                    this.currentWidth = 0.0f;
                    this.remove = true;
                    return;
                }
                this.currentWidth -= (float)ShipManager.shipLines.get((int)this.shipLineID).width.get(this.tID).intValue();
            }
            this.posX = ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID].x + (ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID - 1].x - ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID].x) * (this.currentWidth / (float)ShipManager.shipLines.get((int)this.shipLineID).width.get(this.tID).intValue());
            this.posY = ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID].y + (ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID - 1].y - ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID].y) * (this.currentWidth / (float)ShipManager.shipLines.get((int)this.shipLineID).width.get(this.tID).intValue());
            this.updateIsInView();
            if (this.isInView) {
                this.angle = (int)Math.abs(360.0 + Math.atan2(ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID].y - ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID - 1].y, -ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID].x + ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID - 1].x) * 180.0 / Math.PI) % 360;
            }
        } else {
            if (this.currentWidth >= (float)ShipManager.shipLines.get((int)this.shipLineID).width.get(this.tID).intValue()) {
                if (++this.tID > GameValues.gvShips.SHIP_LINE_PRECISION - 2) {
                    this.tID = GameValues.gvShips.SHIP_LINE_PRECISION - 1;
                    this.movingBack = true;
                    this.randomize();
                    this.currentWidth = 0.0f;
                    this.remove = true;
                    return;
                }
                this.currentWidth -= (float)ShipManager.shipLines.get((int)this.shipLineID).width.get(this.tID).intValue();
            }
            this.posX = ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID].x + (ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID + 1].x - ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID].x) * (this.currentWidth / (float)ShipManager.shipLines.get((int)this.shipLineID).width.get(this.tID).intValue());
            this.posY = ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID].y + (ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID + 1].y - ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID].y) * (this.currentWidth / (float)ShipManager.shipLines.get((int)this.shipLineID).width.get(this.tID).intValue());
            this.updateIsInView();
            if (this.isInView) {
                this.angle = (int)Math.abs(360.0 + Math.atan2(ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID].y - ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID + 1].y, -ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID].x + ShipManager.shipLines.get((int)this.shipLineID).vPoints[this.tID + 1].x) * 180.0 / Math.PI) % 360;
            }
        }
    }

    public void drawCurrentScale(SpriteBatch oSB, int ageGroup) {
        if (this.isInView) {
            ShipManager.shipImg.get(ageGroup).get(this.shipIMGID).draw2(oSB, (int)(this.posX + (float)CFG.map.getMpC().getPX()) + CFG.rotateXMoveUnits[this.angle], (int)(this.posY + (float)CFG.map.getMpC().getPY()) + CFG.rotateYMoveUnits[this.angle], 32, 32, (float)this.angle, true, false);
        }
    }

    public void draw(SpriteBatch oSB, int ageGroup) {
        if (this.isInView) {
            ShipManager.shipImg.get(ageGroup).get(this.shipIMGID).draw2(oSB, (int)((this.posX + (float)CFG.map.getMpC().getPX()) * CFG.map.getMpS().getCurrSc()) + CFG.rotateXMoveUnits[this.angle], (int)((this.posY + (float)CFG.map.getMpC().getPY()) * CFG.map.getMpS().getCurrSc()) + CFG.rotateYMoveUnits[this.angle], 32, 32, (float)this.angle, true, false);
        }
    }

    public final void updateIsInView() {
        if (this.inViewY() && this.inViewX()) {
            this.isInView = true;
            return;
        }
        this.isInView = false;
    }

    public final boolean inViewY() {
        return (float)(Core.inViewY_CordsY_Height + 32) >= this.posY && (float)(Core.inViewY_CordsY - 32) <= this.posY + 32.0f;
    }

    public final boolean inViewX() {
        return (float)(Core.inViewX_CordsX_Width + 32) >= this.posX && (float)(Core.inViewX_CordsX - 32) <= this.posX + 32.0f;
    }

    public final boolean inViewX2() {
        return (float)(Core.inViewX_CordsX_Width + 32) >= this.posX + (float)CFG.map.getMpB().getWidthM() && (float)(Core.inViewX_CordsX - 32) <= this.posX + (float)CFG.map.getMpB().getWidthM() + 32.0f;
    }
}

