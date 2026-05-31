
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu_FlagPixel
extends MenuElemUI {
    public Menu_FlagPixel(int iPosX, int iPosY, int iWidth, int iHeight) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.FLAG_PIXEL;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.setHeightE(iHeight);
    }

    @Override
    public final void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, int flagPixelID) {
        oSB.setColor(CFG.flagPixelColor.getR(flagPixelID), CFG.flagPixelColor.getG(flagPixelID), CFG.flagPixelColor.getB(flagPixelID), CFG.flagPixelColor.getA(flagPixelID));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(Color.WHITE);
    }
}

