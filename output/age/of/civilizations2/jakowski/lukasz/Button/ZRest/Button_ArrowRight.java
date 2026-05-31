
package age.of.civilizations2.jakowski.lukasz.Button.ZRest;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_ArrowRight
extends ButtonM {
    public Button_ArrowRight(int iPosX, int iPosY, int iWidth, int iHeight) {
        super.init("", 0, iPosX, iPosY, iWidth, iHeight, true, true, false, false, null);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (CFG.settingsGD != null && CFG.settingsGD.BETTER_UI) {
            BetterUI_Manager.drawBetterArrow(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), this.getIsHovered(), isActive, true);
            return;
        }
        if (isActive) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.75f));
            IMGManager.getIMG(Images.btnUp).drawO(oSB, this.getPosXE() - IMGManager.getIMG(Images.btnUp).getHeight() / 2 + this.getWidthE() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + IMGManager.getIMG(Images.btnUp).getWidth() / 2 - IMGManager.getIMG(Images.btnUp).getHeight() + iTranslateY, IMGManager.getIMG(Images.btnUp).getWidth(), IMGManager.getIMG(Images.btnUp).getHeight(), 90.0f);
            oSB.setColor(Color.WHITE);
        } else {
            IMGManager.getIMG(Images.btnUp).drawO(oSB, this.getPosXE() - IMGManager.getIMG(Images.btnUp).getHeight() / 2 + this.getWidthE() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + IMGManager.getIMG(Images.btnUp).getWidth() / 2 - IMGManager.getIMG(Images.btnUp).getHeight() + iTranslateY, IMGManager.getIMG(Images.btnUp).getWidth(), IMGManager.getIMG(Images.btnUp).getHeight(), 90.0f);
        }
    }
}

