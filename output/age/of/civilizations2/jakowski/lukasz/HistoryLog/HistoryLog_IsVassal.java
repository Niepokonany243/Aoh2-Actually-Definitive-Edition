
package age.of.civilizations2.jakowski.lukasz.HistoryLog;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_Types;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HistoryLog_IsVassal
extends HistoryLog {
    private String sMess;
    private int iMessWidth;
    public int iCivAWidth;

    public HistoryLog_IsVassal(int iCivA, int iCivB) {
        this.historyLog_Type = HistoryLog_Types.IS_VASSAL;
        this.iCivA = iCivB;
        this.iCivB = iCivA;
        this.updateLanguage();
    }

    @Override
    public void updateLanguage() {
        try {
            this.sMess = CFG.lang.get("CivBIsNowAPuppetStateOfCivA");
            CFG.glyphLay.setText(CFG.fontMain.get(0), this.sMess);
            this.iMessWidth = (int)(CFG.glyphLay.width * 0.7f);
        }
        catch (Exception exception) {
            
        }
        try {
            CFG.glyphLay.setText(CFG.fontMain.get(0), CFG.core.getCiv(this.iCivA).getCivName() + " ");
            this.iCivAWidth = (int)(CFG.glyphLay.width * 0.7f);
        }
        catch (IndexOutOfBoundsException ex) {
            this.iCivAWidth = 0;
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int nTurnID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isActive) {
        this.drawLeftIconBG(oSB, iPosX, iPosY, iWidth, iHeight, isActive);
        try {
            CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(this.iCivA).getIdeology()).getiCrownVassalImage().drawO(oSB, iPosX + (int)(((float)ICON_WIDTH - (float)CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(this.iCivA).getIdeology()).getiCrownVassalImage().getWidth() * HistoryLog_IsVassal.getImageScale_CrownVassal(CFG.core.getCiv(this.iCivA).getIdeology())) / 2.0f), iPosY + (int)(((float)iHeight - (float)CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(this.iCivA).getIdeology()).getiCrownVassalImage().getHeight() * HistoryLog_IsVassal.getImageScale_CrownVassal(CFG.core.getCiv(this.iCivA).getIdeology())) / 2.0f) - CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(this.iCivA).getIdeology()).getiCrownVassalImage().getHeight(), (int)((float)CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(this.iCivA).getIdeology()).getiCrownVassalImage().getWidth() * HistoryLog_IsVassal.getImageScale_CrownVassal(CFG.core.getCiv(this.iCivA).getIdeology())), (int)((float)CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(this.iCivA).getIdeology()).getiCrownVassalImage().getHeight() * HistoryLog_IsVassal.getImageScale_CrownVassal(CFG.core.getCiv(this.iCivA).getIdeology())));
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.ideologiesMgr.getIdeologyID(0).getiCrownVassalImage().drawO(oSB, iPosX + (int)(((float)ICON_WIDTH - (float)CFG.ideologiesMgr.getIdeologyID(0).getiCrownVassalImage().getWidth() * HistoryLog_IsVassal.getImageScale_CrownVassal(0)) / 2.0f), iPosY + (int)(((float)iHeight - (float)CFG.ideologiesMgr.getIdeologyID(0).getiCrownVassalImage().getHeight() * HistoryLog_IsVassal.getImageScale_CrownVassal(0)) / 2.0f) - CFG.ideologiesMgr.getIdeologyID(0).getiCrownVassalImage().getHeight(), (int)((float)CFG.ideologiesMgr.getIdeologyID(0).getiCrownVassalImage().getWidth() * HistoryLog_IsVassal.getImageScale_CrownVassal(0)), (int)((float)CFG.ideologiesMgr.getIdeologyID(0).getiCrownVassalImage().getHeight() * HistoryLog_IsVassal.getImageScale_CrownVassal(0)));
        }
        super.draw(oSB, nTurnID, iPosX, iPosY, iWidth, iHeight, isActive);
        try {
            oSB.setColor(new Color((float)CFG.core.getCiv(this.iCivA).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivA).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivA).getB() / 255.0f, 0.85f));
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.RANDOM_CIVILIZATION_COLOR.r, CFG.RANDOM_CIVILIZATION_COLOR.g, CFG.RANDOM_CIVILIZATION_COLOR.b, 0.85f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, iPosX + ICON_WIDTH + CFG.PADD + HistoryManager.lHistoryDatesWidth.get(nTurnID), iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) / 2.0f) - IMGManager.getIMG(Images.pix255).getHeight(), 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
        CFG.fontMain.get(0).getData().setScale(0.7f);
        try {
            CFG.core.getCiv(this.iCivA).getFlagC().drawO(oSB, iPosX + 2 + ICON_WIDTH + CFG.PADD + HistoryManager.lHistoryDatesWidth.get(nTurnID), iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) / 2.0f) - CFG.core.getCiv(this.iCivA).getFlagC().getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)));
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, iPosX + 2 + ICON_WIDTH + CFG.PADD + HistoryManager.lHistoryDatesWidth.get(nTurnID), iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) / 2.0f) - IMGManager.getIMG(Images.flagRectSmall).getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)));
            CFG.drawTextDefault(oSB, CFG.core.getCiv(this.iCivA).getCivName(), iPosX + 2 + ICON_WIDTH + CFG.PADD + HistoryManager.lHistoryDatesWidth.get(nTurnID) + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)), iPosY + (int)(((float)iHeight - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) / 2.0f), CFG.COLOR_TEXT_CIV_NAME);
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, iPosX + 2 + ICON_WIDTH + CFG.PADD + HistoryManager.lHistoryDatesWidth.get(nTurnID), iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) / 2.0f) - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)));
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, iPosX + 2 + ICON_WIDTH + CFG.PADD + HistoryManager.lHistoryDatesWidth.get(nTurnID), iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) / 2.0f) - IMGManager.getIMG(Images.flagRectSmall).getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)));
        }
        CFG.drawTextDefault(oSB, this.sMess, iPosX + 2 + ICON_WIDTH + CFG.PADD + HistoryManager.lHistoryDatesWidth.get(nTurnID) + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) + this.iCivAWidth, iPosY + (int)(((float)iHeight - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) / 2.0f), CFG.COLOR_TEXT_RANK);
        try {
            oSB.setColor(new Color((float)CFG.core.getCiv(this.iCivB).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivA).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivA).getB() / 255.0f, 0.85f));
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.RANDOM_CIVILIZATION_COLOR.r, CFG.RANDOM_CIVILIZATION_COLOR.g, CFG.RANDOM_CIVILIZATION_COLOR.b, 0.85f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, iPosX + 2 + ICON_WIDTH + CFG.PADD * 2 + HistoryManager.lHistoryDatesWidth.get(nTurnID) + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) + this.iCivAWidth + this.iMessWidth, iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) / 2.0f) - IMGManager.getIMG(Images.pix255).getHeight(), 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
        try {
            CFG.core.getCiv(this.iCivB).getFlagC().drawO(oSB, iPosX + 4 + ICON_WIDTH + CFG.PADD * 2 + HistoryManager.lHistoryDatesWidth.get(nTurnID) + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) + this.iCivAWidth + this.iMessWidth, iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) / 2.0f) - CFG.core.getCiv(this.iCivA).getFlagC().getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)));
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, iPosX + 4 + ICON_WIDTH + CFG.PADD * 2 + HistoryManager.lHistoryDatesWidth.get(nTurnID) + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) + this.iCivAWidth + this.iMessWidth, iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) / 2.0f) - IMGManager.getIMG(Images.flagRectSmall).getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)));
            CFG.drawTextDefault(oSB, CFG.core.getCiv(this.iCivB).getCivName(), iPosX + 4 + ICON_WIDTH + CFG.PADD * 2 + HistoryManager.lHistoryDatesWidth.get(nTurnID) + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) * 2 + this.iCivAWidth + this.iMessWidth, iPosY + (int)(((float)iHeight - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) / 2.0f), CFG.COLOR_TEXT_CIV_NAME);
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, iPosX + 4 + ICON_WIDTH + CFG.PADD * 2 + HistoryManager.lHistoryDatesWidth.get(nTurnID) + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) + this.iCivAWidth + this.iMessWidth, iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) / 2.0f) - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)));
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, iPosX + 4 + ICON_WIDTH + CFG.PADD * 2 + HistoryManager.lHistoryDatesWidth.get(nTurnID) + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) + this.iCivAWidth + this.iMessWidth, iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)) / 2.0f) - IMGManager.getIMG(Images.flagRectSmall).getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_IsVassal.getImageScale(Images.flagRectSmall)));
        }
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }
}

