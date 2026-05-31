
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Diplomacy_InvestReturn
extends ButtonStats {
    private String sInterest;
    private int iInterestWidth = 0;
    private String sInterestGold;
    private int iInterestGoldWidth = 0;
    public SparksAnimation sparksAnimation = new SparksAnimation();

    public Button_Diplomacy_InvestReturn(String sText, int iPosX, int iPosY, int iWidth) {
        super(sText, 0, iPosX, iPosY, iWidth, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.BUTTON_H * 4 / 5), CFG.FONT_BOLD_SMALL);
        this.setCurr(0);
        this.setMin(0);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth - CFG.PADD * 2 + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE() - 2, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE() - 2, false, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - 2);
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
        oSB.setColor(SparksAnimation.sparksColors);
        this.sparksAnimation.draw2(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.45f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - 4, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - 4, 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.topGold()).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth / 2 - IMGManager.getIMG(Images.topGold()).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.topGold()).getHeight() / 2 + iTranslateY);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + ButtonDiplomacy.iDiploWidth + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() / 2.0f) + iTranslateY, CFG.COLOR_HOVER_TITLE);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sInterest, this.getPosXE() + ButtonDiplomacy.iDiploWidth + CFG.PADD + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() / 2.0f) + iTranslateY, CFG.COLOR_NEUTRAL2);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sInterestGold, this.getPosXE() + ButtonDiplomacy.iDiploWidth + CFG.PADD + this.getTextWidthU() + this.iInterestWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() / 2.0f) + iTranslateY, CFG.COLOR_NEUTRAL);
        IMGManager.getIMG(Images.topGold()).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth + CFG.PADD * 2 + this.getTextWidthU() + this.iInterestWidth + this.iInterestGoldWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold())) / 2 - IMGManager.getIMG(Images.topGold()).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold())), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold())));
        oSB.setColor(Color.WHITE);
    }

    private final float getImageScale(int nImageID) {
        return 1.0f;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS);
    }

    @Override
    public void buildElemHover() {
        this.menuElemHover = null;
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }

    @Override
    public void setCurr(int nCurrent) {
        this.sInterest = "" + CFG.getPrecision2((float)nCurrent / 100.0f, 100) + "% ";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sInterest);
        this.iInterestWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void setMin(int iMin) {
        this.sInterestGold = " " + CFG.lang.get("Profit") + ": " + iMin + "";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sInterestGold);
        this.iInterestGoldWidth = (int)CFG.glyphLay.width;
    }
}

