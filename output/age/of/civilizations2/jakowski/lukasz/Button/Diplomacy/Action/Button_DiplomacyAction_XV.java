
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_DiplomacyAction_XV
extends Button_DiplomacyAction {
    public boolean bV = false;

    public Button_DiplomacyAction_XV(int nImageID, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean bV) {
        super(nImageID, sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
        this.bV = bV;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
        if (this.bV) {
            IMGManager.getIMG(Images.iconTrue).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - IMGManager.getIMG(Images.iconTrue).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.iconTrue).getHeight() / 2 + iTranslateY);
        } else {
            IMGManager.getIMG(Images.iconFalse).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - IMGManager.getIMG(Images.iconFalse).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.iconFalse).getHeight() / 2 + iTranslateY);
        }
    }
}

