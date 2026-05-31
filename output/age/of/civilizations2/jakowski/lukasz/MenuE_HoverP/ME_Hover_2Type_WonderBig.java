
package age.of.civilizations2.jakowski.lukasz.MenuE_HoverP;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ME_Hover_2Type_WonderBig
implements ME_Hover_2Type {
    private int iProvinceID;
    private int iWonderID;
    private int offsetLeft;
    private int offsetRight;

    public ME_Hover_2Type_WonderBig(int nProvinceID) {
        this.iProvinceID = nProvinceID;
        this.offsetLeft = 0;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_WonderBig(int nProvinceID, int offsetLeft) {
        this.iProvinceID = nProvinceID;
        this.offsetLeft = offsetLeft;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_WonderBig(int nProvinceID, int iWonderID, int offsetLeft, int offsetRight) {
        this.iProvinceID = nProvinceID;
        this.iWonderID = iWonderID;
        this.offsetLeft = offsetLeft;
        this.offsetRight = offsetRight;
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        try {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha));
            CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getHeight() + IMGManager.getIMG(Images.flagRect2Mask).getHeight() / 2 - (int)((float)CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getHeight() * this.getImageScale() / 2.0f), (int)((float)CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getWidth() * this.getImageScale()), (int)((float)CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getHeight() * this.getImageScale()));
        }
        catch (Exception exception) {
            
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        try {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha));
            CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getHeight() + IMGManager.getIMG(Images.flagRect2Mask).getHeight() / 2 - (int)((float)CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getHeight() * this.getImageScale() / 2.0f), (int)((float)CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getWidth() * this.getImageScale()), (int)((float)CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getHeight() * this.getImageScale()));
        }
        catch (Exception exception) {
            
        }
    }

    @Override
    public int getWidth() {
        try {
            return this.offsetLeft + this.offsetRight + (int)((float)CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getWidth() * this.getImageScale());
        }
        catch (Exception exception) {
            return this.offsetLeft + this.offsetRight;
        }
    }

    @Override
    public int getHeight() {
        return CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD;
    }

    private final float getImageScale() {
        try {
            return Math.min(1.0f, (float)Math.max(IMGManager.getIMG(Images.flagRect2Mask).getHeight(), CFG.TEXT_HEIGHT_DEFAULT) / (float)CFG.core.getProv((int)this.iProvinceID).getWonder((int)this.iWonderID).nImage.getHeight());
        }
        catch (Exception ex) {
            return 1.0f;
        }
    }
}

