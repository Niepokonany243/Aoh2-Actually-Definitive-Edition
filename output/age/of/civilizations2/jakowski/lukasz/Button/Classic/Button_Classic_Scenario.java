/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Classic;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Choose.Menu_ChooseScenario;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Classic_Scenario
extends Button_Classic {
    private int iScenarioID;
    private String sScenarioName;
    private String sScenarioDate;

    public Button_Classic_Scenario(int iScenarioID, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, CFG.FONT_BOLD_SMALL);
        this.init(iScenarioID);
    }

    public Button_Classic_Scenario(int iScenarioID, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkboxState) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, checkboxState);
        this.init(iScenarioID);
    }

    private final void init(int iScenarioID) {
        this.iScenarioID = iScenarioID;
        this.sScenarioName = "" + CFG.core.getGameScenars().getScenarioDay(iScenarioID) + " " + GameCalendar.getMonthName(CFG.core.getGameScenars().getScenarioMonth(iScenarioID)) + " " + CFG.gameAges.getYear(CFG.core.getGameScenars().getScenarioYearID(iScenarioID));
        this.sScenarioDate = CFG.core.getGameScenars().getScenarioNumOfCivs(iScenarioID) + " " + CFG.lang.get("Civilizations") + " - " + CFG.gameAges.getAge(CFG.core.getGameScenars().getScenarioAgeID(iScenarioID)).getName();
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(Images.time).drawO(oSB, this.getPosXE() + Menu_ChooseScenario.previewW + this.getTextPosElem() / 2 - IMGManager.getIMG(Images.time).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.time).getHeight() / 2 + iTranslateY);
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + Menu_ChooseScenario.previewW + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) / 2 + iTranslateY, this.getIsHovered() ? CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME_HOVER : CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME);
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sScenarioName, this.getPosXE() + Menu_ChooseScenario.previewW + this.getTextPosElem() + CFG.PADD + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) / 2 + (CFG.TEXT_HEIGHT_DEFAULT - CFG.TEXT_HEIGHT_DEFAULT) + iTranslateY, new Color(0.67f, 0.67f, 0.67f, 1.0f));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sScenarioDate, this.getPosXE() + Menu_ChooseScenario.previewW + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + iTranslateY, new Color(0.58f, 0.58f, 0.58f, 1.0f));
        try {
            Menu_ChooseScenario.preview.get(this.iScenarioID).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 + iTranslateY, Menu_ChooseScenario.previewW, Menu_ChooseScenario.previewH);
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (this.getIsHovered()) {
            Menu_ChooseScenario.iFHR = this.iScenarioID;
        }
    }

    @Override
    public int getCurr() {
        return this.iScenarioID;
    }
}

