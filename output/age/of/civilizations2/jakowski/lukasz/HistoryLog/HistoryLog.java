
package age.of.civilizations2.jakowski.lukasz.HistoryLog;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_Types;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.io.Serializable;

public class HistoryLog
implements Serializable {
    private static final long serialVersionUID = 0L;
    public static final float FONT_SCALE = 0.7f;
    public static int ICON_WIDTH = 0;
    public HistoryLog_Types historyLog_Type = HistoryLog_Types.WAR_DECLARAION;
    public int iCivA;
    public int iCivB;

    public void updateLanguage() {
    }

    public void draw(SpriteBatch oSB, int nTurnID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isActive) {
        CFG.fontMain.get(0).getData().setScale(0.7f);
        CFG.drawTextDefaultWithShadow(oSB, HistoryManager.lHistoryDates.get(nTurnID) + ": ", iPosX + ICON_WIDTH + CFG.PADD, iPosY + (int)(((float)iHeight - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) / 2.0f), CFG.COLOR_TEXT_RANK);
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    public final void drawLeftIconBG(SpriteBatch oSB, int iPosX, int iPosY, int iWidth, int iHeight, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.375f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, iPosX + ICON_WIDTH - ICON_WIDTH / 2, iPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), ICON_WIDTH / 2, iHeight, true, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.225f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, iPosX + ICON_WIDTH, iPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.PADD, iHeight);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.7f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, iPosX + ICON_WIDTH - 1, iPosY - IMGManager.getIMG(Images.line32Vertical).getHeight(), 1, iHeight, true, false);
        oSB.setColor(Color.WHITE);
    }

    public final void drawLeftIcon(SpriteBatch oSB, int nImageID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isActive) {
        this.drawLeftIconBG(oSB, iPosX, iPosY, iWidth, iHeight, isActive);
        IMGManager.getIMG(nImageID).drawO(oSB, iPosX + (int)(((float)ICON_WIDTH - (float)IMGManager.getIMG(nImageID).getWidth() * HistoryLog.getImageScale(nImageID)) / 2.0f), iPosY + (int)(((float)iHeight - (float)IMGManager.getIMG(nImageID).getHeight() * HistoryLog.getImageScale(nImageID)) / 2.0f) - IMGManager.getIMG(nImageID).getHeight(), (int)((float)IMGManager.getIMG(nImageID).getWidth() * HistoryLog.getImageScale(nImageID)), (int)((float)IMGManager.getIMG(nImageID).getHeight() * HistoryLog.getImageScale(nImageID)));
    }

    public static final float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    public static final float getImageScale_CrownVassal(int nIdelogyID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / (float)CFG.ideologiesMgr.getIdeologyID(nIdelogyID).getiCrownVassalImage().getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f / (float)CFG.ideologiesMgr.getIdeologyID(nIdelogyID).getiCrownVassalImage().getHeight() : 1.0f;
    }

    public String getName() {
        return "";
    }
}

