/*
 * Decompiled with CFR 0.152.
 */
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

public class Button_View_Economy
extends ButtonM {
    private boolean row = false;
    private int iProvinceID = 0;
    private String sPopulation;
    private int iPopulationWidth = 0;
    private String sPopulationDiff;
    private int iPopulationDiffWidth = 0;
    public Color differenceColor;
    private String sPopulationPerc;
    private int iPopulationPercWidth = 0;
    public boolean isFestivalOrganized = false;
    public String sLevel = "";
    public int iLevelWidth = 0;
    public float fPerc = 0.0f;

    public Button_View_Economy(int iRow, String sText, int nProvinceID, int totalPop, int iPosX, int iPosY, int iWidth, boolean isFestivalOrganized) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, Menu_InGame_View_Army.getButtonHeight(), true, true, false, false);
        this.row = iRow % 2 == 0;
        this.iProvinceID = nProvinceID;
        this.fPerc = CFG.core.getProv(this.iProvinceID).getCivId() == 0 ? -1.0f : Math.min(1.0f, (float)CFG.core.getProv(this.iProvinceID).getEco() / CFG.gameUpdate.getMaxProvEconomy(this.iProvinceID));
        this.sPopulation = "" + CFG.getNumberWthSpaces("" + CFG.core.getProv(this.iProvinceID).getEco());
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), "" + this.sPopulation);
        this.iPopulationWidth = (int)CFG.glyphLay.width;
        this.sPopulationPerc = totalPop == 0 ? "" : "" + Math.max(0.0f, Math.min(100.0f, (float)((int)((float)CFG.core.getProv(this.iProvinceID).getEco() / (float)totalPop * 10000.0f)) / 100.0f)) + "%";
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sPopulationPerc);
        this.iPopulationPercWidth = (int)CFG.glyphLay.width;
        long difference = CFG.core.getProv(this.iProvinceID).getEco() - CFG.core.getProv((int)this.iProvinceID).provGD.startingEconomy;
        this.sPopulationDiff = (difference > 0L ? "+" : "") + CFG.getNumberWthSpaces("" + difference);
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), "" + this.sPopulationDiff);
        this.iPopulationDiffWidth = (int)CFG.glyphLay.width;
        this.differenceColor = difference > 0L ? CFG.COLOR_POSITIVE : (difference < 0L ? CFG.COLOR_NEGATIVE_1 : CFG.COLOR_NEUTRAL);
        this.isFestivalOrganized = isFestivalOrganized;
        if (CFG.core.getProv(nProvinceID).getLvlOfWorkshop() > 0) {
            this.sLevel = "" + CFG.core.getProv(nProvinceID).getLvlOfWorkshop();
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sLevel);
            this.iLevelWidth = (int)CFG.glyphLay.width;
        }
    }

    public Color getColorProgress() {
        return new Color(CFG.COLOR_ECONOMY.r, CFG.COLOR_ECONOMY.g, CFG.COLOR_ECONOMY.b, 0.7f);
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
        if (CFG.core.getProv(this.iProvinceID).getLvlOfWorkshop() > 0 && this.isFestivalOrganized) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.525f));
            IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        } else if (this.isFestivalOrganized) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.525f));
            IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        if (this.iProvinceID == CFG.core.getActiveProvID()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.825f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        if (CFG.core.getProv(this.iProvinceID).getLvlOfWorkshop() > 0 && this.isFestivalOrganized) {
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.bWorkshop).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bWorkshop).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bWorkshop).getHeight(), (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())), (int)((float)IMGManager.getIMG(Images.bWorkshop).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())));
            IMGManager.getIMG(Images.economy).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - CFG.PADD - (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())) - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.economy).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.economy).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.economy).getHeight(), (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.economy).getHeight())), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.economy).getHeight())));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sLevel, this.getPosXE() + this.getWidthE() - CFG.PADD - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())) - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.economy).getHeight())) - CFG.PADD - this.iLevelWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        } else {
            oSB.setColor(Color.WHITE);
            if (this.isFestivalOrganized) {
                IMGManager.getIMG(Images.economy).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.economy).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.economy).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.economy).getHeight(), (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.economy).getHeight())), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.economy).getHeight())));
            }
            if (CFG.core.getProv(this.iProvinceID).getLvlOfWorkshop() > 0) {
                IMGManager.getIMG(Images.bWorkshop).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bWorkshop).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bWorkshop).getHeight(), (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())), (int)((float)IMGManager.getIMG(Images.bWorkshop).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())));
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sLevel, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())) - CFG.PADD - this.iLevelWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getProv(this.iProvinceID).getCivId());
        if (this.fPerc >= 0.0f) {
            int nW = IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2;
            int nX = this.getPosXE() + this.getWidthE() - CFG.PADD - nW + iTranslateX;
            int nY = this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD + iTranslateY;
            int nH = CFG.PADD;
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.4f));
            IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY, nW, nH);
            oSB.setColor(this.getColorProgress());
            if ((int)((float)nW * this.fPerc) > 0) {
                IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY + 1, (int)((float)nW * this.fPerc), nH - 2);
            }
            oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE.r, CFG.COLOR_NEW_GAME_EDGE_LINE.g, CFG.COLOR_NEW_GAME_EDGE_LINE.b, 0.65f));
            IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY, nW, 1);
            IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY + nH - 1, nW, 1);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
            IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY + 1, nW, 1);
            IMGManager.getIMG(Images.pix255).draw(oSB, nX, nY + nH - 2, nW, 1);
            oSB.setColor(Color.WHITE);
        }
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getTextE(), this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD + iTranslateY, this.getColorE(isActive));
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, "" + this.sPopulation, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_ECONOMY);
        IMGManager.getIMG(Images.economy).draw(oSB, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 3 + this.iPopulationWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy, 1.0f)), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(Images.economy, 1.0f)));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, "" + this.sPopulationDiff, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 4 + this.iPopulationWidth + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, this.differenceColor);
        IMGManager.getIMG(Images.economy).draw(oSB, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 5 + this.iPopulationWidth + this.iPopulationDiffWidth + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy, 1.0f)), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(Images.economy, 1.0f)));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sPopulationPerc, this.getPosXE() + this.getWidthE() - CFG.PADD - this.iPopulationPercWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_ACTIVE);
    }

    public float getImageScale(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    private final float getImageScale2(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.isFestivalOrganized ? CFG.COLOR_POSITIVE : CFG.COLOR_TEXT_GRAY_NS)) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.6f));
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
        this.menuElemHover = Menu_InGame_ProvInfo.getHoverEconomy(this.iProvinceID);
    }
}

