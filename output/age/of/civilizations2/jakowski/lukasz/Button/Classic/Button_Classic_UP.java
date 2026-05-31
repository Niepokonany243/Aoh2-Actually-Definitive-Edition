
package age.of.civilizations2.jakowski.lukasz.Button.Classic;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Classic_UP
extends Button_Classic {
    public Button_Classic_UP(int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super("", 0, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    @Override
    public final void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            IMGManager.getIMG(Images.btnhMenu1H).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE());
        } else if (this.getIsHovered() && this.getIsClickable()) {
            oSB.setColor(CFG.COLOR_BUTTON_MENU_HOVER_BG);
            IMGManager.getIMG(Images.btnMenu1H).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE());
            oSB.setColor(Color.WHITE);
        } else {
            IMGManager.getIMG(Images.btnMenu1H).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE());
        }
        if (isActive) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.45f));
            IMGManager.getIMG(Images.btnUp).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnUp).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnUp).getHeight() / 2 + iTranslateY, true);
            oSB.setColor(Color.WHITE);
        } else {
            IMGManager.getIMG(Images.btnUp).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnUp).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnUp).getHeight() / 2 + iTranslateY, true);
        }
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }
}

