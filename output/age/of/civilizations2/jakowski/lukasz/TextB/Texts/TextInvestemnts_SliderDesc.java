/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_Budget;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ;
import age.of.civilizations2.jakowski.lukasz.NewTurn;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextInvestemnts_SliderDesc
extends Text {
    private String sText2;
    public int iText2Width = 0;
    private String sTextEco;
    public int iTextEcoWidth = 0;
    public String sEstimatedPopGrowth = "";
    public int estimatedPopGrowthWidth = 0;
    public String sPopGrowth = "";
    public int popGrowthWidth = 0;
    public Color popGrowthColor = CFG.COLOR_POPULATION_ACTIVE;
    public float goodsSpending = -100.0f;
    public float investsSpending = -100.0f;

    public TextInvestemnts_SliderDesc(String sText, String sText2, String sTextEco, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(sText, CFG.PADD, iPosX, iPosY, iWidth, iHeight, CFG.FONT_BOLD_SMALL);
        this.sText2 = sText2;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sText2);
        this.iText2Width = (int)CFG.glyphLay.width;
        this.sTextEco = sTextEco;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sTextEco);
        this.iTextEcoWidth = (int)CFG.glyphLay.width;
        if (!Menu_InGame_Civ.getUseMenu_UI2()) {
            this.sEstimatedPopGrowth = CFG.lang.get("EstimatedEconomyGrowth") + ": ";
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sEstimatedPopGrowth);
            this.estimatedPopGrowthWidth = (int)CFG.glyphLay.width;
        } else {
            this.sEstimatedPopGrowth = "";
            this.estimatedPopGrowthWidth = 0;
        }
    }

    public void updateInvestmentsSpending_EcoGrowth() {
        try {
            if (this.investsSpending != CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingInvestmentsB() || this.goodsSpending != CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingGoodsB()) {
                this.investsSpending = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingInvestmentsB();
                this.goodsSpending = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingGoodsB();
                int ecoGrowth = NewTurn.getUpdateGameData_EconomyGrowth_WithoutRandom(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                this.sPopGrowth = (ecoGrowth < 0 ? "-" : (ecoGrowth > 0 ? "+" : "")) + CFG.getNumberWthSpaces("" + Math.abs(ecoGrowth));
                this.popGrowthColor = ecoGrowth < 0 ? CFG.COLOR_NEGATIVE_1 : (ecoGrowth > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL);
                CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sPopGrowth);
                this.popGrowthWidth = (int)CFG.glyphLay.width;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.15f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE() * 2 / 5, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() * 2 / 5 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE() * 2 / 5, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.275f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() - CFG.PADD + this.getWidthE() + CFG.PADD * 2 - this.getWidthE() / 4 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), true, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, 1);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.economy).drawO(oSB, this.getPosXE() + CFG.PADD + (Menu_InGame_Budget.maxIconWidth - (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(1.0f, Images.economy))) / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.economy).getHeight() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(1.0f, Images.economy))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(1.0f, Images.economy)), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(1.0f, Images.economy)));
        IMGManager.getIMG(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingInvestmentsB() >= CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) ? Images.development : Images.developmentDown).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.development).getWidth() * this.getImageScale(1.0f, Images.development)) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.development).getHeight() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.development).getHeight() * this.getImageScale(1.0f, Images.development))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.development).getWidth() * this.getImageScale(1.0f, Images.development)), (int)((float)IMGManager.getIMG(Images.development).getHeight() * this.getImageScale(1.0f, Images.development)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText2, this.getPosXE() + CFG.PADD * 2 + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sTextEco, this.getPosXE() + this.iText2Width + CFG.PADD * 2 + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, CFG.COLOR_ECONOMY);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - (int)((float)IMGManager.getIMG(Images.development).getWidth() * this.getImageScale(1.0f, Images.development)) - this.getTextWidthU() + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, CFG.COLOR_NEUTRAL);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sEstimatedPopGrowth, this.getPosXE() + this.iText2Width + this.iTextEcoWidth + CFG.PADD * 3 + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sPopGrowth, this.getPosXE() + this.iText2Width + this.iTextEcoWidth + CFG.PADD * 3 + this.estimatedPopGrowthWidth + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.popGrowthColor);
        IMGManager.getIMG(Images.economy).drawO(oSB, this.getPosXE() + this.iText2Width + this.iTextEcoWidth + CFG.PADD * 4 + this.estimatedPopGrowthWidth + this.popGrowthWidth + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.economy).getHeight() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(1.0f, Images.economy))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(1.0f, Images.economy)), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(1.0f, Images.economy)));
        this.updateInvestmentsSpending_EcoGrowth();
    }

    private final float getImageScale(float fScale, int nImageID) {
        return (float)this.iTextHeight * fScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }
}

