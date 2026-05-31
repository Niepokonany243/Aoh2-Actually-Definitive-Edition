/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.View;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextD;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_View_ProvinceValue
extends ButtonM {
    private boolean row = false;
    private int iProvinceID = 0;
    private String sPopulation;
    private int iPopulationWidth = 0;
    public boolean isFestivalOrganized = false;
    public String sLevel = "";
    public int iLevelWidth = 0;
    public TextD growth;
    public TextD development;
    public TextD pop;

    public Button_View_ProvinceValue(int iRow, String sText, int nProvinceID, int totalPop, int iPosX, int iPosY, int iWidth, boolean isFestivalOrganized) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, Menu_InGame_View_Army.getButtonHeight(), true, true, false, false);
        this.row = iRow % 2 == 0;
        this.iProvinceID = nProvinceID;
        this.sPopulation = "" + CFG.core.getProvinceValue(this.iProvinceID);
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), "" + this.sPopulation);
        this.iPopulationWidth = (int)CFG.glyphLay.width;
        this.growth = new TextD("" + (int)(CFG.core.getProv(nProvinceID).getGrowthRate_Pop_WithFarm_WithTerrain() * 100.0f) + "%", CFG.FONT_REGULAR_SMALL);
        this.development = new TextD("" + CFG.getPrecision2(CFG.core.getProv(nProvinceID).getDeveLvl(), 100), CFG.FONT_REGULAR_SMALL);
        this.pop = new TextD(CFG.getNumberWthSpaces(CFG.core.getProv(nProvinceID).getPop().getPops() + ""), CFG.FONT_REGULAR_SMALL);
        this.isFestivalOrganized = isFestivalOrganized;
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
        if (this.iProvinceID == CFG.core.getActiveProvID()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.825f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getProv(this.iProvinceID).getCivId());
        IMGManager.getIMG(Images.victoryPoints).draw(oSB, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 3 + this.getTextWidthU() + this.iPopulationWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - (int)((float)IMGManager.getIMG(Images.victoryPoints).getHeight() * this.getImageScale(Images.victoryPoints, 1.0f)) + iTranslateY, (int)((float)IMGManager.getIMG(Images.victoryPoints).getWidth() * this.getImageScale(Images.victoryPoints, 1.0f)), (int)((float)IMGManager.getIMG(Images.victoryPoints).getHeight() * this.getImageScale(Images.victoryPoints, 1.0f)));
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getTextE(), this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY, this.getColorE(isActive));
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, "" + this.sPopulation, this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY, CFG.COLOR_PROVINCE_VALUE);
        int pX = this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX;
        int pYT = this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY;
        int pYI = this.getPosY() + this.getHeightE() / 2 + CFG.PADD + this.getTextHeight() / 2 + iTranslateY;
        int img = Images.pop;
        int imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale3(img));
        int imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale3(img));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.pop.text, pX, pYT, CFG.COLOR_POPULATION);
        IMGManager.getIMG(img).draw(oSB, pX += this.pop.textW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        pX += imgW + CFG.PADD;
        img = Images.popGrowth;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale3(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale3(img));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.growth.text, pX, pYT, CFG.COLOR_POPULATION_GROWTHRATE_MAX);
        IMGManager.getIMG(img).draw(oSB, pX += this.growth.textW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        pX += imgW + CFG.PADD;
        img = Images.development;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale3(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale3(img));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.development.text, pX, pYT, CFG.COLOR_NEUTRAL2);
        IMGManager.getIMG(img).draw(oSB, pX += this.development.textW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        pX += imgW + CFG.PADD;
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

    public float getImageScale(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    public float getImageScale3(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    @Override
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            if (this.iProvinceID >= 0) {
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ProvinceValue") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.core.getProvinceValue(this.iProvinceID), CFG.COLOR_PROVINCE_VALUE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.victoryPoints, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.iProvinceID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BaseProvinceValue") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + GameValues.gvProvinceValue.BASE_PROVINCE_VALUE, CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image(Images.victoryPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.core.getProvinceValue_Capital(this.iProvinceID) > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Capital") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.core.getProvinceValue_Capital(this.iProvinceID), CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.editorCity, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProvinceValue_PopulationGrowthRate(this.iProvinceID) > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("GrowthRate") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.core.getProvinceValue_PopulationGrowthRate(this.iProvinceID), CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProvinceValue_DevelopmentLevel(this.iProvinceID) > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DevelopmentLevel") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.core.getProvinceValue_DevelopmentLevel(this.iProvinceID), CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProvinceValue_Terrain(this.iProvinceID) > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.terrainTypesManager.getName(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()) + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.core.getProvinceValue_Terrain(this.iProvinceID), CFG.COLOR_POSITIVE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            } else {
                this.menuElemHover = null;
                return;
            }
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException ex) {
            this.menuElemHover = null;
        }
    }
}

