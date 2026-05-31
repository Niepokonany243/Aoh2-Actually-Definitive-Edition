
package age.of.civilizations2.jakowski.lukasz.HistoryLog;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_Types;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HistoryLog_Disease
extends HistoryLog {
    private String sMess;
    private int iMessWidth;
    public String sAllianceName;
    public int iCivAWidth;

    public HistoryLog_Disease(int iProvinceID) {
        this.historyLog_Type = HistoryLog_Types.DISEASE;
        this.iCivA = CFG.core.getProv(iProvinceID).getCivId();
        this.iCivB = iProvinceID;
        try {
            this.sAllianceName = CFG.plagueManager.getPlague_InGame(CFG.core.getProv((int)iProvinceID).provGD.provincePlague.iPlagueID_InGame).getPlagueName();
        }
        catch (IndexOutOfBoundsException ex) {
            this.sAllianceName = CFG.lang.get("Undiscovered");
        }
        catch (NullPointerException ex) {
            this.sAllianceName = CFG.lang.get("Undiscovered");
        }
        this.updateLanguage();
    }

    @Override
    public void updateLanguage() {
        try {
            this.sMess = CFG.lang.get("Disease") + ":";
            CFG.glyphLay.setText(CFG.fontMain.get(0), this.sMess);
            this.iMessWidth = (int)(CFG.glyphLay.width * 0.7f);
            try {
                CFG.glyphLay.setText(CFG.fontMain.get(0), CFG.core.getCiv(this.iCivA).getCivName() + " ");
                this.iCivAWidth = (int)(CFG.glyphLay.width * 0.7f);
            }
            catch (IndexOutOfBoundsException ex) {
                this.iCivAWidth = 0;
            }
        }
        catch (Exception ex) {
            this.iMessWidth = 0;
            this.iCivAWidth = 0;
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int nTurnID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isActive) {
        this.drawLeftIcon(oSB, Images.disease, iPosX, iPosY, iWidth, iHeight, isActive);
        super.draw(oSB, nTurnID, iPosX, iPosY, iWidth, iHeight, isActive);
        try {
            oSB.setColor(new Color((float)CFG.core.getCiv(this.iCivA).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivA).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivA).getB() / 255.0f, 0.85f));
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.RANDOM_CIVILIZATION_COLOR.r, CFG.RANDOM_CIVILIZATION_COLOR.g, CFG.RANDOM_CIVILIZATION_COLOR.b, 0.85f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, iPosX + ICON_WIDTH + CFG.PADD + HistoryManager.lHistoryDatesWidth.get(nTurnID), iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)) / 2.0f) - IMGManager.getIMG(Images.pix255).getHeight(), 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
        CFG.fontMain.get(0).getData().setScale(0.7f);
        try {
            CFG.core.getCiv(this.iCivA).getFlagC().drawO(oSB, iPosX + 2 + ICON_WIDTH + CFG.PADD + HistoryManager.lHistoryDatesWidth.get(nTurnID), iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)) / 2.0f) - CFG.core.getCiv(this.iCivA).getFlagC().getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)));
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, iPosX + 2 + ICON_WIDTH + CFG.PADD + HistoryManager.lHistoryDatesWidth.get(nTurnID), iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)) / 2.0f) - IMGManager.getIMG(Images.flagRectSmall).getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)));
            CFG.drawTextDefault(oSB, CFG.core.getCiv(this.iCivA).getCivName(), iPosX + 2 + ICON_WIDTH + CFG.PADD + HistoryManager.lHistoryDatesWidth.get(nTurnID) + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)), iPosY + (int)(((float)iHeight - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) / 2.0f), CFG.COLOR_TEXT_CIV_NAME);
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, iPosX + 2 + ICON_WIDTH + CFG.PADD + HistoryManager.lHistoryDatesWidth.get(nTurnID), iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)) / 2.0f) - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)));
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, iPosX + 2 + ICON_WIDTH + CFG.PADD + HistoryManager.lHistoryDatesWidth.get(nTurnID), iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)) / 2.0f) - IMGManager.getIMG(Images.flagRectSmall).getHeight(), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)));
        }
        CFG.drawTextDefault(oSB, this.sMess, iPosX + 2 + ICON_WIDTH + CFG.PADD + HistoryManager.lHistoryDatesWidth.get(nTurnID) + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)) + this.iCivAWidth, iPosY + (int)(((float)iHeight - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) / 2.0f), CFG.COLOR_TEXT_RANK);
        CFG.drawTextDefault(oSB, this.sAllianceName, iPosX + 2 + ICON_WIDTH + CFG.PADD * 2 + HistoryManager.lHistoryDatesWidth.get(nTurnID) + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * HistoryLog_Disease.getImageScale(Images.flagRectSmall)) + this.iCivAWidth + this.iMessWidth, iPosY + (int)(((float)iHeight - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) / 2.0f), CFG.COLOR_TEXT_CIV_NAME);
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public String getName() {
        return this.sAllianceName;
    }
}

