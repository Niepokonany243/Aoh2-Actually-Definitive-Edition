
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextLeftSide_Icon
extends TextLeftSide {
    private int iImageID;

    public TextLeftSide_Icon(String sText, int iPosX, int iPosY, int iImageID) {
        super(sText, iPosX, iPosY);
        this.iImageID = iImageID;
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        IMGManager.getIMG(this.iImageID).drawO(oSB, this.getPosXE() - CFG.PADD - (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale(IMGManager.getIMG(this.iImageID).getHeight())) + iTranslateX, this.getPosY() + (this.getHeightE() - (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale(IMGManager.getIMG(this.iImageID).getHeight()))) / 2 - IMGManager.getIMG(this.iImageID).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale(IMGManager.getIMG(this.iImageID).getHeight())), (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale(IMGManager.getIMG(this.iImageID).getHeight())));
        super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
    }

    private final float getImageScale(int nImageHeight) {
        return (float)this.getHeightE() / (float)nImageHeight < 1.0f ? (float)this.getHeightE() / (float)nImageHeight : 1.0f;
    }
}

