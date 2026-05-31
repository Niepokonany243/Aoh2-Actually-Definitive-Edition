
package age.of.civilizations2.jakowski.lukasz.Button.View;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.Info.Menu_InGame_ProvInfo;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_View_ProvinceStability
extends ButtonM {
    private boolean row = false;
    private int iProvinceID = 0;
    private String sPopulationPerc;
    private int iPopulationPercWidth = 0;
    private int iLargestNationality = 0;
    public Color cColorStability;
    public boolean isAssimiliate = false;
    public String sLevel = "";
    public int iLevelWidth = 0;
    public String sPop;
    public int iPopWidth = 0;
    public String sRevRisk;
    public int iRevRiskWidth = 0;

    public Button_View_ProvinceStability(int iRow, String sText, int nProvinceID, int iPosX, int iPosY, int iWidth, boolean isAssimiliate) {
        try {
            this.fontID = CFG.FONT_BOLD_SMALL;
            super.init(sText, 0, iPosX, iPosY, iWidth, Menu_InGame_View_Army.getButtonHeight(), true, true, false, false);
            this.row = iRow % 2 == 0;
            this.iProvinceID = nProvinceID;
            for (int i = 1; i < CFG.core.getProv(this.iProvinceID).getPop().getNatsSize(); ++i) {
                if (CFG.core.getProv(this.iProvinceID).getPop().getPopulationID(this.iLargestNationality) >= CFG.core.getProv(this.iProvinceID).getPop().getPopulationID(i)) continue;
                this.iLargestNationality = i;
            }
            this.iLargestNationality = CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.iLargestNationality);
            this.sPopulationPerc = "" + (float)((int)(CFG.core.getProv(this.iProvinceID).getProviStability() * 10000.0f)) / 100.0f + "%";
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sPopulationPerc);
            this.iPopulationPercWidth = (int)CFG.glyphLay.width;
            this.cColorStability = (int)(CFG.core.getProv(this.iProvinceID).getProviStability() * 100.0f) == 0 ? CFG.COLOR_PROVINCE_STABILITY_MAX : CFG.getColorStep(CFG.COLOR_PROVINCE_STABILITY_MIN, CFG.COLOR_PROVINCE_STABILITY_MAX, (int)(CFG.core.getProv(this.iProvinceID).getProviStability() * 100.0f), 100, 1.0f);
            this.isAssimiliate = isAssimiliate;
            if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isAssimilateOrganized_TurnsLeft(nProvinceID) > 0) {
                this.sLevel = "" + CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isAssimilateOrganized_TurnsLeft(nProvinceID);
                CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sLevel);
                this.iLevelWidth = (int)CFG.glyphLay.width;
            }
            this.sPop = CFG.getNumber_SHORT(CFG.core.getProv(nProvinceID).getPop().getPops());
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sPop);
            this.iPopWidth = (int)CFG.glyphLay.width;
            this.sRevRisk = (int)(CFG.core.getProv(nProvinceID).getRevRisk() * 100.0f) + "%";
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sRevRisk);
            this.iRevRiskWidth = (int)CFG.glyphLay.width;
        }
        catch (IllegalArgumentException illegalArgumentException) {
        }
        catch (Exception exception) {
            
        }
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.row) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.1f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.65f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.275f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.35f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.4f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.6f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.45f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.85f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        }
        if (this.isAssimiliate) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.525f));
            IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        if (this.iProvinceID == CFG.core.getActiveProvID()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.825f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        if (this.isAssimiliate) {
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.time).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 4 - this.iLevelWidth - (int)((float)IMGManager.getIMG(Images.time).getWidth() * this.getImageScale(Images.time, 1.0f)) - (int)((float)IMGManager.getIMG(Images.diploStability).getWidth() * this.getImageScale(Images.diploStability, 1.0f)) - this.iPopulationPercWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.time).getHeight() * this.getImageScale(Images.time, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.time).getWidth() * this.getImageScale(Images.time, 1.0f)), (int)((float)IMGManager.getIMG(Images.time).getHeight() * this.getImageScale(Images.time, 1.0f)));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sLevel, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.diploStability).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.diploStability).getHeight())) - CFG.PADD - this.iLevelWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        }
        oSB.setColor(Color.WHITE);
    }

    private final float getImageScale2(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iLargestNationality);
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getTextE(), this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD / 2 - this.getTextHeight() + iTranslateY, this.getColorE(isActive));
        IMGManager.getIMG(Images.diploStability).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.diploStability).getWidth() * this.getImageScale(Images.diploStability, 1.0f)) - this.iPopulationPercWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.diploStability).getHeight() * this.getImageScale(Images.diploStability, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploStability).getWidth() * this.getImageScale(Images.diploStability, 1.0f)), (int)((float)IMGManager.getIMG(Images.diploStability).getHeight() * this.getImageScale(Images.diploStability, 1.0f)));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sPopulationPerc, this.getPosXE() + this.getWidthE() - CFG.PADD - this.iPopulationPercWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.cColorStability);
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sPop, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_POPULATION);
        IMGManager.getIMG(Images.pop).draw(oSB, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 3 + this.iPopWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop, 1.0f)));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sRevRisk, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 4 + this.iPopWidth + (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
        IMGManager.getIMG(Images.diploRevolution).draw(oSB, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 5 + this.iPopWidth + this.iRevRiskWidth + (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution, 1.0f)), (int)((float)IMGManager.getIMG(Images.diploRevolution).getHeight() * this.getImageScale(Images.diploRevolution, 1.0f)));
    }

    public float getImageScale(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.isAssimiliate ? CFG.COLOR_POSITIVE : CFG.COLOR_TEXT_GRAY_NS)) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.6f));
    }

    @Override
    public int getCurr() {
        return this.iProvinceID;
    }

    private final float getImageScale(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    @Override
    public void buildElemHover() {
        try {
            this.menuElemHover = Menu_InGame_ProvInfo.getStabilityHoverOfProvince(this.iProvinceID);
        }
        catch (IndexOutOfBoundsException ex) {
            this.menuElemHover = null;
        }
    }
}

