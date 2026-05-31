
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
            
            
            
            
        }
        return out;
    }
}

