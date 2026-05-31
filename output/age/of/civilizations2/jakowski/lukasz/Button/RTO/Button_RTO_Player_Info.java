
package age.of.civilizations2.jakowski.lukasz.Button.RTO;

import age.of.civilizations2.jakowski.lukasz.Button.RTO.Button_RTO_Player;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_RTO_Player_Info
extends Button_RTO_Player {
    public Button_RTO_Player_Info(int nID, int nCivID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(nID, nCivID, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        try {
            CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getTextPosElem() + this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getTextPosElem() + this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() / 2 + iTranslateY);
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getTextPosElem() + this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
        CFG.drawTextDefault(oSB, this.getTextE(), this.getTextPosElem() + this.getPosXE() + CFG.CIV_FLAG_WIDTH + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, CFG.COLOR_TEXT_CIV_NAME);
    }

    @Override
    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    @Override
    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }
}

