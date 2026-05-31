/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Classic;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Classic_ScenarioLoad
extends Button_Classic {
    private int iLoadID;
    private String sScenarioName;
    private String sScenarioDate;

    public Button_Classic_ScenarioLoad(int iLoadID, String sText, int iNumOfCivs, String sDate, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(CFG.lang.getCiv(sText), (int)(50.0f * CFG.GUI_SCALE), iPosX, iPosY, iWidth, iHeight, isClickable);
        this.iLoadID = iLoadID;
        this.sScenarioName = CFG.lang.get("Civilizations") + ": " + iNumOfCivs;
        this.sScenarioDate = sDate;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(Images.time).drawO(oSB, this.getPosXE() + this.getTextPosElem() / 2 - IMGManager.getIMG(Images.time).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.time).getHeight() / 2 + iTranslateY);
        CFG.fontMain.get(0).getData().setScale(0.9f);
        CFG.drawTextDefault(oSB, this.getTextE(), this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.9f + (float)CFG.PADD + (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) / 2 + iTranslateY, this.getIsHovered() ? CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME_HOVER : CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME);
        CFG.fontMain.get(0).getData().setScale(0.7f);
        CFG.drawTextDefault(oSB, this.sScenarioName, this.getPosXE() + this.getTextPosElem() + CFG.PADD + (int)((float)this.getTextWidthU() * 0.9f) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.9f + (float)CFG.PADD + (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) / 2 + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.9f - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) + iTranslateY, new Color(0.67f, 0.67f, 0.67f, 1.0f));
        CFG.drawTextDefault(oSB, this.sScenarioDate, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.9f + (float)CFG.PADD + (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) / 2 + CFG.PADD + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.9f) + iTranslateY, new Color(0.58f, 0.58f, 0.58f, 1.0f));
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public int getCurr() {
        return this.iLoadID;
    }
}

