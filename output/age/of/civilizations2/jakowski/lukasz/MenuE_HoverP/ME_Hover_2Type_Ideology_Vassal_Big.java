
package age.of.civilizations2.jakowski.lukasz.MenuE_HoverP;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ME_Hover_2Type_Ideology_Vassal_Big
implements ME_Hover_2Type {
    private int iIdeologyID;
    private int offsetLeft = 0;
    private int offsetRight = 0;

    public ME_Hover_2Type_Ideology_Vassal_Big(int iIdeologyID) {
        this.iIdeologyID = iIdeologyID;
        this.offsetLeft = 0;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_Ideology_Vassal_Big(int iIdeologyID, int offsetLeft) {
        this.iIdeologyID = iIdeologyID;
        this.offsetLeft = offsetLeft;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_Ideology_Vassal_Big(int iIdeologyID, int offsetLeft, int offsetRight) {
        this.iIdeologyID = iIdeologyID;
        this.offsetLeft = offsetLeft;
        this.offsetRight = offsetRight;
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha));
        CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getiCrownVassalImage().drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getiCrownVassalImage().getHeight() + IMGManager.getIMG(Images.flagRect2Mask).getHeight() / 2 - (int)((float)CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getiCrownVassalImage().getHeight() * this.getImageScale() / 2.0f), (int)((float)CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getiCrownVassalImage().getWidth() * this.getImageScale()), (int)((float)CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getiCrownVassalImage().getHeight() * this.getImageScale()));
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha));
        CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getiCrownVassalImage().drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getiCrownVassalImage().getHeight() + IMGManager.getIMG(Images.flagRect2Mask).getHeight() / 2 - (int)((float)CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getiCrownVassalImage().getHeight() * this.getImageScale() / 2.0f), (int)((float)CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getiCrownVassalImage().getWidth() * this.getImageScale()), (int)((float)CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getiCrownVassalImage().getHeight() * this.getImageScale()));
    }

    @Override
    public int getWidth() {
        return this.offsetRight + this.offsetLeft + (int)((float)CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getiCrownVassalImage().getWidth() * this.getImageScale());
    }

    @Override
    public int getHeight() {
        return IMGManager.getIMG(Images.flagRect2Mask).getHeight() + CFG.PADD;
    }

    private final float getImageScale() {
        return (float)Math.max(IMGManager.getIMG(Images.flagRect2Mask).getHeight(), CFG.TEXT_HEIGHT_DEFAULT) / (float)CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getiCrownVassalImage().getHeight();
    }
}

