
package age.of.civilizations2.jakowski.lukasz.Button.View;

import age.of.civilizations2.jakowski.lukasz.Button.View.ButtonView;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_ViewEnd
extends ButtonView {
    public Button_ViewEnd(String sText, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    @Override
    public final void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(isActive ? Images.top_view_right_h : Images.top_view_right_last).draw2O(oSB, this.getPosXE() + iTranslateX, this.getHeightE() - IMGManager.getIMG(Images.top_view_right_last).getHeight() * 2, this.getWidthE(), IMGManager.getIMG(Images.top_view_right_last).getHeight(), true);
    }
}

