
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

public class TextInvestemnts_SliderDescGoods
extends Text {
    private String sText2;
    private int iText2Width;
    private String sPop;
    public int iPopWidth;
    public String sEstimatedPopGrowth = "";
    public int estimatedPopGrowthWidth = 0;
    public String sPopGrowth = "";
    public int popGrowthWidth = 0;
    public Color popGrowthColor = CFG.COLOR_POPULATION_ACTIVE;
    public float goodsSpending = -100.0f;

    public TextInvestemnts_SliderDescGoods(String sText, String sText2, String sPop, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(sText, CFG.PADD, iPosX, iPosY, iWidth, iHeight, CFG.FONT_BOLD_SMALL);
        this.sText2 = sText2;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sText2);
        this.iText2Width = (int)CFG.glyphLay.width;
        this.sPop = sPop;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sPop);
        this.iPopWidth = (int)CFG.glyphLay.width;
        if (!Menu_InGame_Civ.getUseMenu_UI2()) {
            this.sEstimatedPopGrowth = CFG.lang.get("EstimatedPopulationGrowth") + ": ";
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sEstimatedPopGrowth);
            this.estimatedPopGrowthWidth = (int)CFG.glyphLay.width;
        } else {
            this.sEstimatedPopGrowth = "";
            this.estimatedPopGrowthWidth = 0;
        }
    }

    public void updateGoodsSpending_PopGrowth() {
        try {
            if (this.goodsSpending != CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingGoodsB()) {
                this.goodsSpending = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getSpendingGoodsB();
                int popGrowth = NewTurn.getUpdateGameData_PopulationGrowth_WithoutRandom(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                this.sPopGrowth = (popGrowth < 0 ? "-" : (popGrowth > 0 ? "+" : "")) + CFG.getNumberWthSpaces("" + Math.abs(popGrowth));
                this.popGrowthColor = popGrowth < 0 ? CFG.COLOR_NEGATIVE_1 : (popGrowth > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL);
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
        oSB.setColor(new Color(0.08f, 0.08f, 0.08f, 0.3f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE() * 2 / 5, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() * 2 / 5 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE() * 2 / 5, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.275f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() - CFG.PADD + this.getWidthE() + CFG.PADD * 2 - this.getWidthE() / 4 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), true, false);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.5f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, 1);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.pop).drawO(oSB, this.getPosXE() + CFG.PADD + (Menu_InGame_Budget.maxIconWidth - (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(1.0f, Images.pop))) / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pop).getHeight() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(1.0f, Images.pop))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(1.0f, Images.pop)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(1.0f, Images.pop)));
        IMGManager.getIMG(Images.popGrowth).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(Images.popGrowth).getWidth() * this.getImageScale(1.0f, Images.popGrowth)) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.popGrowth).getHeight() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.popGrowth).getHeight() * this.getImageScale(1.0f, Images.popGrowth))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.popGrowth).getWidth() * this.getImageScale(1.0f, Images.popGrowth)), (int)((float)IMGManager.getIMG(Images.popGrowth).getHeight() * this.getImageScale(1.0f, Images.popGrowth)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText2, this.getPosXE() + CFG.PADD * 2 + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sPop, this.getPosXE() + CFG.PADD * 2 + this.iText2Width + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, CFG.COLOR_POPULATION);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.popGrowth).getWidth() * this.getImageScale(1.0f, Images.popGrowth)) - this.getTextWidthU() + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, CFG.COLOR_NEUTRAL);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sEstimatedPopGrowth, this.getPosXE() + CFG.PADD * 2 + this.iText2Width + Menu_InGame_Budget.maxIconWidth + CFG.PADD + this.iPopWidth + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sPopGrowth, this.getPosXE() + CFG.PADD * 2 + this.iText2Width + Menu_InGame_Budget.maxIconWidth + CFG.PADD + this.iPopWidth + this.estimatedPopGrowthWidth + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.popGrowthColor);
        IMGManager.getIMG(Images.pop).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + this.iText2Width + Menu_InGame_Budget.maxIconWidth + CFG.PADD * 2 + this.iPopWidth + this.estimatedPopGrowthWidth + this.popGrowthWidth + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pop).getHeight() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(1.0f, Images.pop))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(1.0f, Images.pop)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(1.0f, Images.pop)));
        this.updateGoodsSpending_PopGrowth();
    }

    private final float getImageScale(float fScale, int nImageID) {
        return (float)this.iTextHeight * fScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }
}

