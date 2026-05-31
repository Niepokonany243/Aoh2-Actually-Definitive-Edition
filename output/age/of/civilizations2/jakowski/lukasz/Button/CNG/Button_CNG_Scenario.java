
package age.of.civilizations2.jakowski.lukasz.Button.CNG;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_CNG_Scenario
extends Button_Classic {
    private int iScenarioID = 0;
    private String sScenarioName;
    private String sScenarioDate;

    public Button_CNG_Scenario(int iScenarioID, int iTextPositionX, int iPosX, int iPosY, int iWidth, boolean isClickable) {
        super("", iTextPositionX, iPosX, iPosY, iWidth, CFG.TEXT_HEIGHT_DEFAULT * 2 + CFG.PADD * 5, isClickable);
        this.iScenarioID = iScenarioID;
        this.sScenarioName = CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(iScenarioID));
        this.sScenarioDate = "" + CFG.core.getGameScenars().getScenarioDay(iScenarioID) + " " + GameCalendar.getMonthName(CFG.core.getGameScenars().getScenarioMonth(iScenarioID)) + " " + CFG.gameAges.getYear(CFG.core.getGameScenars().getScenarioYearID(iScenarioID)) + " [" + CFG.core.getGameScenars().getScenarioNumOfCivs(iScenarioID) + " " + CFG.lang.get("Civilizations") + "]";
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.4f));
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.2f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.175f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + this.getHeightE() - this.getHeightE() / 4 + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
        oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.35f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() * 2 + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.75f));
        IMGManager.getIMG(Images.line32).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.line32).getHeight() * 2 + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        CFG.fontMain.get(0).getData().setScale(0.85f);
        CFG.drawTextDefault(oSB, this.sScenarioName, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + CFG.PADD * 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.85f) / 2 + iTranslateY, this.getIsHovered() ? CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME_HOVER : CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME);
        CFG.fontMain.get(0).getData().setScale(0.65f);
        CFG.drawTextDefault(oSB, this.sScenarioDate, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + CFG.PADD * 3 + CFG.TEXT_HEIGHT_DEFAULT + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.65f) / 2 + iTranslateY, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO);
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public int getCurr() {
        return this.iScenarioID;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? new Color(0.66f, 0.658f, 0.665f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_MENU_TEXT_HOVERED : CFG.COLOR_BUTTON_MENU_TEXT) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }
}

