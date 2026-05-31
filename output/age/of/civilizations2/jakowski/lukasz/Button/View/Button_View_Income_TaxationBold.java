/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.View;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_View_Income_TaxationBold
extends ButtonM {
    private boolean row = false;
    private int iProvinceID = 0;
    private String sTaxation;
    private int iTaxationWidth = 0;
    public String sProduction;
    public int iProductionWidth = 0;
    private int iBalance;
    private int iPopulationPercWidth = 0;
    public boolean isFestivalOrganized = false;
    public String sLevel = "";
    public int iLevelWidth = 0;

    public Button_View_Income_TaxationBold(int iRow, String sText, int nProvinceID, int iPosX, int iPosY, int iWidth, boolean isFestivalOrganized) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, Menu_InGame_View_Army.getButtonHeight(), true, true, false, false);
        this.row = iRow % 2 == 0;
        this.iProvinceID = nProvinceID;
        this.sTaxation = CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvIncomeTaxation(nProvinceID));
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), "" + this.sTaxation);
        this.iTaxationWidth = (int)CFG.glyphLay.width;
        this.sProduction = CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvIncomeProduction(nProvinceID));
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), "" + this.sProduction);
        this.iProductionWidth = (int)CFG.glyphLay.width;
        this.iBalance = (int)CFG.gameUpdate.getProvIncomeAndExpenses_Total(nProvinceID);
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), (this.iBalance > 0 ? "+" : "") + this.iBalance);
        this.iPopulationPercWidth = (int)CFG.glyphLay.width;
        this.isFestivalOrganized = isFestivalOrganized;
        if (CFG.core.getProv(nProvinceID).getLvlOfWorkshop() > 0) {
            this.sLevel = "" + CFG.core.getProv(nProvinceID).getLvlOfWorkshop();
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sLevel);
            this.iLevelWidth = (int)CFG.glyphLay.width;
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
        if (this.isFestivalOrganized) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.525f));
            IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        if (this.iProvinceID == CFG.core.getActiveProvID()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.825f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getProv(this.iProvinceID).getCivId());
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getTextE(), this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY, this.getColorE(isActive));
        IMGManager.getIMG(Images.topGold()).draw(oSB, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 3 + this.iPopulationPercWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), 1.0f)), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold(), 1.0f)));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, (this.iBalance > 0 ? "+" : "") + this.iBalance, this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, this.iBalance > 0 ? CFG.COLOR_POSITIVE : (this.iBalance == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2));
        int maxW = Math.max((int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.economy).getHeight())), (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.pop).getHeight())));
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sTaxation, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - maxW - this.iTaxationWidth - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY, CFG.COLOR_GOLD);
        IMGManager.getIMG(Images.pop).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - maxW / 2 - (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.pop).getHeight())) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.pop).getHeight())), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.pop).getHeight())));
        IMGManager.getIMG(Images.topGold()).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - maxW - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sProduction, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - maxW - this.iProductionWidth - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_ACTIVE);
        IMGManager.getIMG(Images.economy).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - maxW / 2 - (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.economy).getHeight())) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.economy).getHeight())), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.economy).getHeight())));
        IMGManager.getIMG(Images.topGold()).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - maxW - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())));
        if (CFG.core.getProv(this.iProvinceID).getLvlOfWorkshop() > 0) {
            oSB.setColor(Color.WHITE);
            maxW = Math.min(this.getWidthE() - CFG.PADD * 3 - maxW - this.iProductionWidth - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())), this.getWidthE() - CFG.PADD * 3 - maxW - this.iTaxationWidth - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())));
            IMGManager.getIMG(Images.bWorkshop).drawO(oSB, this.getPosXE() + maxW - CFG.PADD - (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bWorkshop).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bWorkshop).getHeight(), (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())), (int)((float)IMGManager.getIMG(Images.bWorkshop).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sLevel, this.getPosXE() + maxW - CFG.PADD - (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())) - CFG.PADD - this.iLevelWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        }
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.isFestivalOrganized ? CFG.COLOR_POSITIVE : CFG.COLOR_TEXT_GRAY_NS)) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.6f));
    }

    public float getImageScale(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    @Override
    public int getCurr() {
        return this.iProvinceID;
    }

    private final float getImageScale(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    private final float getImageScale2(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight * 1.0f;
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(this.iProvinceID).getName().length() > 0 ? CFG.core.getProv(this.iProvinceID).getName() : CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Taxation") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvIncomeTaxation(this.iProvinceID)), CFG.COLOR_POSITIVE));
        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Production") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvIncomeProduction(this.iProvinceID)), CFG.COLOR_POSITIVE));
        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        float fQ = CFG.gameUpdate.getProvinceAdminQuality(this.iProvinceID);
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Administration") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (int)(fQ * 100.0f) + "%", fQ > 0.6f ? CFG.COLOR_POSITIVE : (fQ > 0.3f ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
        nData.add(new ME_Hover_2Type_Image(Images.administration, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Balance") + ": "));
        nData.add(new ME_Hover_2Type_Text((this.iBalance > 0 ? "+" : "") + this.iBalance, this.iBalance > 0 ? CFG.COLOR_POSITIVE : (this.iBalance == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (this.isFestivalOrganized && CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).isInvestOrganized_TurnsLeft(this.iProvinceID) > 0) {
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Invest"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(this.iProvinceID).getCivId(), CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text("+" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).isInvestOrganized_EconomyLeft(this.iProvinceID)), CFG.COLOR_ECONOMY));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID - GameValues.gvInvestEconomy.INVEST_ECO_NUM_OF_TURNS + CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).isInvestOrganized_TurnsLeft(this.iProvinceID))));
            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).isInvestOrganized_TurnsLeft(this.iProvinceID))));
            nData.add(new ME_Hover_2Type_Text(" [" + CFG.lang.get("TurnsX", CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).isInvestOrganized_TurnsLeft(this.iProvinceID)) + "]", CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}

