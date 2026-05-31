
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_GameInvestForeign
extends Button_Game {
    public int imgID;

    public Button_GameInvestForeign(String sText, int iTextPositionX, int iPosX, int iPosY, boolean isClickable, int nIMG) {
        super(sText, iTextPositionX, iPosX, iPosY, isClickable);
        this.imgID = nIMG;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(this.imgID).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + CFG.PADD + IMGManager.getIMG(this.imgID).getWidth()) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(this.imgID).getHeight() / 2 + iTranslateY);
        Renderer.drawTextWithShadowAlpha(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + CFG.PADD + IMGManager.getIMG(this.imgID).getWidth()) / 2 + CFG.PADD + IMGManager.getIMG(this.imgID).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
    }
}

