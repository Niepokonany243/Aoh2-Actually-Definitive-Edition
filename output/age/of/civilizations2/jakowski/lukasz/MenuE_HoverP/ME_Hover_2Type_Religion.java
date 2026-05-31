
package age.of.civilizations2.jakowski.lukasz.MenuE_HoverP;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ME_Hover_2Type_Religion
implements ME_Hover_2Type {
    private int religionID;
    private int offsetLeft = 0;
    private int offsetRight = 0;

    public ME_Hover_2Type_Religion(int religionID) {
        this.religionID = religionID;
        this.offsetLeft = 0;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_Religion(int religionID, int offsetLeft) {
        this.religionID = religionID;
        this.offsetLeft = offsetLeft;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_Religion(int religionID, int offsetLeft, int offsetRight) {
        this.religionID = religionID;
        this.offsetLeft = offsetLeft;
        this.offsetRight = offsetRight;
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha));
        CFG.religionManager.religionImages.get(this.religionID).draw(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.religionManager.religionImages.get(this.religionID).getHeight() * this.getImageScale() / 2.0f), (int)((float)CFG.religionManager.religionImages.get(this.religionID).getWidth() * this.getImageScale()), (int)((float)CFG.religionManager.religionImages.get(this.religionID).getHeight() * this.getImageScale()));
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha));
        CFG.religionManager.religionImages.get(this.religionID).draw(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.religionManager.religionImages.get(this.religionID).getHeight() * this.getImageScale() / 2.0f), (int)((float)CFG.religionManager.religionImages.get(this.religionID).getWidth() * this.getImageScale()), (int)((float)CFG.religionManager.religionImages.get(this.religionID).getHeight() * this.getImageScale()));
    }

    @Override
    public int getWidth() {
        return this.offsetRight + this.offsetLeft + (int)((float)CFG.religionManager.religionImages.get(this.religionID).getWidth() * this.getImageScale());
    }

    @Override
    public int getHeight() {
        return CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD;
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.religionManager.religionImages.get(this.religionID).getHeight();
    }
}

