
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Game_Checkbox
extends ButtonM {
    public Button_Game_Checkbox(String sText, int iTextPositionX, int iPosX, int iPosY, int nWidth, boolean isClickable, boolean checkBoxState) {
        super.init(sText, iTextPositionX, iPosX, iPosY, nWidth, CFG.BUTTON_H, isClickable, true, false, checkBoxState, null);
        super.setCheckbox(true);
    }

    @Override
    public final void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            if (this.getCheckboxSt()) {
                IMGManager.getIMG(Images.btnClearCheckboxFalse).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.btnhClear).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnhClear).getWidth(), IMGManager.getIMG(Images.btnhClear).getHeight());
                IMGManager.getIMG(Images.btnClearCheckboxFalse).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnhClear).getWidth() + iTranslateX, this.getPosY() + iTranslateY, true);
            } else {
                IMGManager.getIMG(Images.btnClearCheckboxTrue).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.btnhClear).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnhClear).getWidth(), IMGManager.getIMG(Images.btnhClear).getHeight());
                IMGManager.getIMG(Images.btnClearCheckboxTrue).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnhClear).getWidth() + iTranslateX, this.getPosY() + iTranslateY, true);
            }
        } else if (this.getCheckboxSt()) {
            IMGManager.getIMG(Images.btnClearCheckboxTrue).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.btnhClear).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnhClear).getWidth(), IMGManager.getIMG(Images.btnhClear).getHeight());
            IMGManager.getIMG(Images.btnClearCheckboxTrue).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnhClear).getWidth() + iTranslateX, this.getPosY() + iTranslateY, true);
        } else {
            IMGManager.getIMG(Images.btnClearCheckboxFalse).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.btnhClear).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnhClear).getWidth(), IMGManager.getIMG(Images.btnhClear).getHeight());
            IMGManager.getIMG(Images.btnClearCheckboxFalse).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnhClear).getWidth() + iTranslateX, this.getPosY() + iTranslateY, true);
        }
    }

    @Override
    public final Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getCheckboxSt() ? (this.getIsHovered() ? new Color(0.33f, 0.48f, 0.008f, 1.0f) : new Color(0.396f, 0.576f, 0.012f, 1.0f)) : (this.getIsHovered() ? new Color(0.584f, 0.075f, 0.004f, 1.0f) : new Color(0.643f, 0.113f, 0.008f, 1.0f))) : new Color(0.674f, 0.09f, 0.066f, 0.5f));
    }
}

