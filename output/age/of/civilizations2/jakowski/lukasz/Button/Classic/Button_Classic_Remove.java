
package age.of.civilizations2.jakowski.lukasz.Button.Classic;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Classic_Remove
extends Button_Classic {
    public Button_Classic_Remove(int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
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
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        oSB.setColor(Color.WHITE);
        if (isActive) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.45f));
            IMGManager.getIMG(Images.btnRemove).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnRemove).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnRemove).getHeight() / 2 + iTranslateY, true);
            oSB.setColor(Color.WHITE);
        } else {
            IMGManager.getIMG(Images.btnRemove).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnRemove).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnRemove).getHeight() / 2 + iTranslateY, true);
        }
    }
}

