
package age.of.civilizations2.jakowski.lukasz.Button.Classic;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Classic_Classic_Search
extends Button_Classic {
    public Button_Classic_Classic_Search(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    public Button_Classic_Classic_Search(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkboxState) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, checkboxState);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
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
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() * 2 / 3, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 + this.getHeightE() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() * 2 / 3, 1);
        oSB.setColor(Color.WHITE);
    }
}

