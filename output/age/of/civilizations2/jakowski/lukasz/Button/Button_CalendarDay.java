
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_CalendarDay
extends ButtonM {
    private int iCurrent = 0;

    public Button_CalendarDay(int iCurrent, int iPosX, int iPosY) {
        super.init("" + iCurrent, -1, iPosX, iPosY, CFG.BUTTON_H * 2 / 3, CFG.BUTTON_H / 2, true, true, false, false, null);
        this.iCurrent = iCurrent;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.475f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.25f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 5);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 5 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 5, false, true);
        oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, this.getIsHovered() ? 0.95f : 0.745f));
        CFG.drawRect(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
        CFG.drawRect(oSB, this.getPosXE() - 1 + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() + 2, this.getHeightE() + 2);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        CFG.drawRect(oSB, this.getPosXE() + 1 + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE() - 2, this.getHeightE() - 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return super.getColorE(isActive || GameCalendar.currDay == this.iCurrent);
    }

    @Override
    public int getCurr() {
        return this.iCurrent;
    }
}

