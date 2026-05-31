
package age.of.civilizations2.jakowski.lukasz.Button.Flag;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Flag_JustFrame
extends ButtonM {
    public Button_Flag_JustFrame(int iPosX, int iPosY, boolean isClickable) {
        super.init("", 0, iPosX, iPosY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight(), isClickable, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.getIsHovered()) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0375f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.425f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight() / 5);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 5 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight() / 5, false, true);
            oSB.setColor(Color.WHITE);
        }
        if (isActive) {
            IMGManager.getIMG(Images.topFlagFrameH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY);
        } else {
            IMGManager.getIMG(Images.topFlagFrame).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY);
        }
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }
}

