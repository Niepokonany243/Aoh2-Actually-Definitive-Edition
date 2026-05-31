
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_InGame_Plunder;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Diplomacy_Plunder
extends ButtonStats {
    private String sPopulation;
    private long iPopulation = 0L;
    private int iPopulationWidth = 0;
    private String sIncome;
    private long iIncome = 0L;
    private int iIncomeWidth = 0;
    private int iIncomeWidth2 = 0;
    private String sDiploCost;
    private int iDiploCostWidth = 0;
    private String sEfficiency;
    private int iEfficiencyWidth = 0;
    private String sEfficiencyPerc;
    private int iEfficiencyPercWidth = 0;

    public Button_Diplomacy_Plunder(String nDiploCost, long nPopulation, long nIncome, int iPosX, int iPosY, int iWidth) {
        super(CFG.lang.get("Population") + ": ", 0, iPosX, iPosY, iWidth, Math.max(CFG.BUTTON_H, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD), CFG.FONT_BOLD_SMALL);
        this.sDiploCost = nDiploCost;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sDiploCost);
        this.iDiploCostWidth = (int)CFG.glyphLay.width;
        this.iPopulation = nPopulation;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.iPopulation);
        this.iPopulationWidth = (int)CFG.glyphLay.width;
        this.sIncome = CFG.lang.get("ProvinceIncome") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.sIncome);
        this.iIncomeWidth = (int)CFG.glyphLay.width;
        this.iIncome = nIncome;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.iIncome);
        this.iIncomeWidth2 = (int)CFG.glyphLay.width;
        this.sEfficiency = CFG.lang.get("Efficiency") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.sEfficiency);
        this.iEfficiencyWidth = (int)CFG.glyphLay.width;
        this.setCurr(0);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.25f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(Color.WHITE);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() * 3 / 5, false, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.275f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 4 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), true, false);
        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.3f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, true);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.45f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - 4, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - 4, 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getProv(Menu_InGame_Plunder.iProvinceID).getCivId());
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD + this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.iPopulation, IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD + this.getPosXE() + CFG.PADD * 2 + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD + iTranslateY, CFG.COLOR_POPULATION);
        IMGManager.getIMG(Images.pop).drawO(oSB, IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD + this.getPosXE() + CFG.PADD * 3 + this.getTextWidthU() + this.iPopulationWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop)) - IMGManager.getIMG(Images.pop).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sIncome, IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD + this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.iIncome, IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD + this.getPosXE() + CFG.PADD * 2 + this.iIncomeWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_GOLD);
        IMGManager.getIMG(Images.topGold()).drawO(oSB, IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD + this.getPosXE() + CFG.PADD * 3 + this.iIncomeWidth + this.iIncomeWidth2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD - IMGManager.getIMG(Images.topGold()).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold())));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sEfficiencyPerc, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iEfficiencyPercWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT + iTranslateY, CFG.COLOR_NEUTRAL2);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sEfficiency, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iEfficiencyPercWidth - this.iEfficiencyWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT + iTranslateY, Color.WHITE);
        IMGManager.getIMG(Images.topMovementPoints).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * this.getImageScale(Images.topMovementPoints)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD - IMGManager.getIMG(Images.topMovementPoints).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * this.getImageScale(Images.topMovementPoints)), (int)((float)IMGManager.getIMG(Images.topMovementPoints).getHeight() * this.getImageScale(Images.topMovementPoints)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sDiploCost, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - this.iDiploCostWidth - (int)((float)IMGManager.getIMG(Images.topMovementPoints).getWidth() * this.getImageScale(Images.topMovementPoints)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_PLUNDER ? CFG.COLOR_MOVEMENT : CFG.COLOR_NEGATIVE_2);
        oSB.setColor(Color.WHITE);
    }

    private final float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS);
    }

    @Override
    public void buildElemHover() {
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }

    @Override
    public void setCurr(int nCurrent) {
        this.sEfficiencyPerc = "" + nCurrent + "%";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.sEfficiencyPerc);
        this.iEfficiencyPercWidth = (int)CFG.glyphLay.width;
    }
}

