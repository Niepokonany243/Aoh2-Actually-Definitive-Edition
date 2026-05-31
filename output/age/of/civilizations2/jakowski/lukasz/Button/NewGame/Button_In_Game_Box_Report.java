
package age.of.civilizations2.jakowski.lukasz.Button.NewGame;

import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_In_Game_Box_Report
extends Button_InGameBox {
    private int iCivID;

    public Button_In_Game_Box_Report(int nCivID, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, isClickable);
        this.iCivID = nCivID;
    }

    public Button_In_Game_Box_Report(int nCivID, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
        this.iCivID = nCivID;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + CFG.PADD + IMGManager.getIMG(Images.flagRect2).getWidth()) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
        Renderer.drawText(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + CFG.PADD + IMGManager.getIMG(Images.flagRect2).getWidth()) / 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, this.getColorE(isActive));
    }

    @Override
    public int getCurr() {
        return this.iCivID;
    }
}

