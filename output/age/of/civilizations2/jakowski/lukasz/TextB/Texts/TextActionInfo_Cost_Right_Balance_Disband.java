
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class TextActionInfo_Cost_Right_Balance_Disband
extends TextActionInfo {
    public long iNumOfUnits = 0;
    private String sBalance;
    private int iBalanceWidth = 0;
    private int iBalance = 0;
    private Color oColorBalance = CFG.COLOR_POSITIVE;

    public TextActionInfo_Cost_Right_Balance_Disband(String sText, int iPosX, int iPosY) {
        super(sText, iPosX, iPosY);
        this.iBalance = (int)CFG.gameUpdate.getIncome(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) - (int)CFG.gameUpdate.getExpenses(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        this.setCurr(0);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.9f));
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + (iTranslateX += (int)((float)this.getWidthE() - (float)this.getWidthE() * CFG.fMOVE_MENU_PERCENTAGE / 100.0f)), this.getPosY() - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - IMGManager.getIMG(Images.civNameBG).getHeight(), false, false);
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.civNameBG).getHeight() - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, this.getWidthE(), IMGManager.getIMG(Images.civNameBG).getHeight(), false, true);
        oSB.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.75f));
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
        oSB.setColor(Color.WHITE);
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextDefaultWithShadow(oSB, this.sBalance, this.getPosXE() + CFG.PADD * 2 + (int)((float)this.iTextWidth * 0.8f) + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.8f) / 2.0f) + iTranslateY, this.oColorBalance);
        CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.8f) / 2.0f) + iTranslateY, this.getColor(isActive));
        CFG.fontMain.get(0).getData().setScale(1.0f);
        IMGManager.getIMG(Images.topGold()).drawO(oSB, this.getPosXE() + CFG.PADD * 3 + (int)((float)this.iTextWidth * 0.8f) + this.iBalanceWidth + iTranslateX, this.getPosY() + (int)((float)this.getHeightE() - (float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(IMGManager.getIMG(Images.topGold()).getHeight())) / 2 - IMGManager.getIMG(Images.topGold()).getHeight(), (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(IMGManager.getIMG(Images.topGold()).getHeight())), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(IMGManager.getIMG(Images.topGold()).getHeight())));
    }

    private final float getImageScale(int nImageHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * 0.8f / (float)nImageHeight < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT * 0.8f / (float)nImageHeight : 1.0f;
    }

    @Override
    public int getPosXE() {
        return CFG.GAMEWIDTH - this.getWidthE();
    }

    @Override
    public int getWidthE() {
        return (int)((float)this.iTextWidth * 0.8f) + this.iBalanceWidth + CFG.PADD * 4 + (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(IMGManager.getIMG(Images.topGold()).getHeight()));
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_GOLD;
    }

    @Override
    public void setCurr(long nCurrent) {
        this.iNumOfUnits = nCurrent;
        int tempNewBalance = (int)((float)this.iBalance - CFG.gameUpdate.getMilitaryUpkeep_WithAllRecruitmentsInProcess_Disband(CFG.core.getActiveProvID(), this.iNumOfUnits, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
        this.sBalance = CFG.getNumberWthSpaces("" + tempNewBalance);
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sBalance);
        this.iBalanceWidth = (int)(CFG.glyphLay.width * 0.8f);
        this.oColorBalance = tempNewBalance > 0 ? CFG.COLOR_POSITIVE : (tempNewBalance == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_2);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.setCurr((long)nCurrent);
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        int tBalance = (int)CFG.gameUpdate.getIncome(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) - (int)CFG.gameUpdate.getExpenses(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Balance") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + tBalance), tBalance > 0 ? CFG.COLOR_POSITIVE : (tBalance == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        int nUpkeep = (int)CFG.gameUpdate.getMilitaryUpkeepP(CFG.core.getActiveProvID(), this.iNumOfUnits, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + nUpkeep), nUpkeep > 0 ? CFG.COLOR_NEGATIVE_2 : (nUpkeep == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_NEUTRAL : (this.getIsClickable() ? Color.WHITE : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    @Override
    public void actionElem(int iID) {
        int tBalance = (int)CFG.gameUpdate.getIncome(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) - (int)CFG.gameUpdate.getExpenses(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        CFG.toastM.addM(CFG.lang.get("Balance: ") + CFG.getNumberWthSpaces("" + tBalance), CFG.COLOR_HOVER_TITLE);
    }
}

