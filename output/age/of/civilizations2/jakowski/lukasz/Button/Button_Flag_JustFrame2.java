
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Flag_JustFrame2
extends ButtonM {
    public Button_Flag_JustFrame2(int iPosX, int iPosY, boolean isClickable) {
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
        Core.drawFlagDiplomacy(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagDiplomacyOver).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() / 2 + iTranslateY, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.FLIP_Y_CIV_FLAG);
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }
}

