/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ProvinceAnimationDot {
    public int iProvinceID;
    public Color dotColor;
    public int posX;
    public int posY;
    public static final float ANIMATION_DURATION = 1250.0f;
    public long animationTime = 0L;
    public float fPerc = 1.0f;

    public ProvinceAnimationDot(int nProvinceID, Color nColor) {
        this.iProvinceID = nProvinceID;
        this.dotColor = nColor;
        this.animationTime = CFG.currentTimeMillis;
        if (CFG.core.getProv(nProvinceID).getCitSize() > 0) {
            this.posX = CFG.core.getProv(nProvinceID).getCit(0).getPoX() * CFG.map.getMpB().getMapSc3();
            this.posY = -CFG.core.getProv(nProvinceID).getCit(0).getPosY() * CFG.map.getMpB().getMapSc3();
        } else {
            this.posX = CFG.core.getProv(nProvinceID).getCeX();
            this.posY = -CFG.core.getProv(nProvinceID).getCeY();
        }
    }

    public boolean draw(SpriteBatch oSB, float nScale) {
        boolean out = false;
        this.fPerc -= (float)(CFG.currentTimeMillis - this.animationTime) / 1250.0f;
        this.animationTime = CFG.currentTimeMillis;
        if (this.fPerc <= 0.0f) {
            this.fPerc = 0.0f;
            out = true;
        }
        if (CFG.core.getProv(this.iProvinceID).getDrawProv()) {
            // Renderer.shapeDrawer.setColor(new Color(this.dotColor.r, this.dotColor.g, this.dotColor.b, 0.15f * this.fPerc));
            // Renderer.shapeDrawer.filledCircle((float)(this.posX + CFG.core.getProv(this.iProvinceID).getTranslateProvPosX()) * nScale, (float)(this.posY - CFG.map.getMpC().getPY()) * nScale, 20.0f * nScale * this.fPerc);
            // Renderer.shapeDrawer.setColor(new Color(this.dotColor.r, this.dotColor.g, this.dotColor.b, 0.45f * this.fPerc));
            // Renderer.shapeDrawer.filledCircle((float)(this.posX + CFG.core.getProv(this.iProvinceID).getTranslateProvPosX()) * nScale, (float)(this.posY - CFG.map.getMpC().getPY()) * nScale, 14.0f * nScale * this.fPerc);
        }
        return out;
    }
}

