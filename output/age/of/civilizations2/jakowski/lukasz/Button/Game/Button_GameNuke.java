
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_GameNuke
extends Button_Game {
    public Button_GameNuke(String sText, int iTextPositionX, int iPosX, int iPosY, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, isClickable);
    }

    public Button_GameNuke(String sText, int iTextPositionX, int iPosX, int iPosY, int nWidth) {
        super(sText, iTextPositionX, iPosX, iPosY, nWidth);
    }

    public Button_GameNuke(String sText, int iTextPositionX, int iPosX, int iPosY, int nWidth, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, nWidth, isClickable);
    }

    public Button_GameNuke(String sText, int iTextPositionX, int iPosX, int iPosY, boolean isClickable, boolean isVisible) {
        super(sText, iTextPositionX, iPosX, iPosY, isClickable, isVisible);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(Images.nuke).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + CFG.PADD + IMGManager.getIMG(Images.nuke).getWidth()) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.nuke).getHeight() / 2 + iTranslateY);
        Renderer.drawTextWithShadowAlpha(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + CFG.PADD + IMGManager.getIMG(Images.nuke).getWidth()) / 2 + CFG.PADD + IMGManager.getIMG(Images.nuke).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
    }
}

