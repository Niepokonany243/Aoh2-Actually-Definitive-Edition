/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.View;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Color;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Terrain;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_View_GrowthRate
extends ButtonM {
    private boolean row = false;
    private int iProvinceID = 0;
    private String sPopulation;
    private int iPopulationWidth = 0;
    private String sPopulationPerc;
    private int iPopulationPercWidth = 0;
    public boolean isAssimiliate = false;
    public String sLevel = "";
    public int iLevelWidth = 0;

    public Button_View_GrowthRate(int iRow, String sText, int nProvinceID, int iPosX, int iPosY, int iWidth, boolean isAssimiliate) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, Menu_InGame_View_Army.getButtonHeight(), true, true, false, false);
        this.row = iRow % 2 == 0;
        this.iProvinceID = nProvinceID;
        this.sPopulation = "" + (int)(CFG.core.getProv(this.iProvinceID).getGrowthRate_Pop_WithFarm_WithTerrain() * 100.0f) + "%";
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), "" + this.sPopulation);
        this.iPopulationWidth = (int)CFG.glyphLay.width;
        this.sPopulationPerc = CFG.getNumberWthSpaces("" + CFG.core.getProv(this.iProvinceID).getPop().getPops());
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sPopulationPerc);
        this.iPopulationPercWidth = (int)CFG.glyphLay.width;
        this.isAssimiliate = isAssimiliate;
        if (CFG.core.getProv(nProvinceID).getLvlOfFarm() > 0) {
            this.sLevel = "" + CFG.core.getProv(nProvinceID).getLvlOfFarm();
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
        if (this.isAssimiliate) {
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
        if (CFG.core.getProv(this.iProvinceID).getLvlOfFarm() > 0) {
            IMGManager.getIMG(Images.bFarm).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.pop).getHeight())) - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.bFarm).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bFarm).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bFarm).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bFarm).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bFarm).getHeight(), (int)((float)IMGManager.getIMG(Images.bFarm).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bFarm).getHeight())), (int)((float)IMGManager.getIMG(Images.bFarm).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bFarm).getHeight())));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sLevel, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.pop).getHeight())) - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.bFarm).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bFarm).getHeight())) - CFG.PADD - this.iLevelWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        }
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getTextE(), this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, "" + this.sPopulation, this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.getGrowthRateColor((int)(CFG.core.getProv(this.iProvinceID).getGrowthRate_Pop_WithFarm() * 100.0f), 1.0f));
        IMGManager.getIMG(Images.popGrowth).draw(oSB, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 3 + this.getTextWidthU() + this.iPopulationWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.popGrowth).getHeight() * this.getImageScale(Images.popGrowth, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.popGrowth).getWidth() * this.getImageScale(Images.popGrowth, 1.0f)), (int)((float)IMGManager.getIMG(Images.popGrowth).getHeight() * this.getImageScale(Images.popGrowth, 1.0f)));
        IMGManager.getIMG(Images.pop).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.pop).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.pop).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.pop).getHeight(), (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.pop).getHeight())), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.pop).getHeight())));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sPopulationPerc, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.pop).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_POPULATION);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.6f));
    }

    @Override
    public int getCurr() {
        return this.iProvinceID;
    }

    public float getImageScale(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    private final float getImageScale(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    private final float getImageScale2(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text_Big((CFG.core.getProv(this.iProvinceID).getName().length() > 0 ? CFG.core.getProv(this.iProvinceID).getName() : CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).getCivName()) + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).getCivName()));
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.iProvinceID).getCivId(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("GrowthRate") + ": "));
        nData.add(new ME_Hover_2Type_Text(this.sPopulation, CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (BuildingsManager.getFarm_GrowthRateBonus(CFG.core.getProv(this.iProvinceID).getLvlOfFarm()) > 0.0f) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Farm") + ": "));
            nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getFarm_GrowthRateBonus(CFG.core.getProv(this.iProvinceID).getLvlOfFarm()) * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image(Images.bFarm, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        if (CFG.terrainTypesManager.getPopulationGrowth(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()) > 0.0f) {
            nData.add(new ME_Hover_2Type_Color(CFG.terrainTypesManager.getColor(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()), 0, 0));
            nData.add(new ME_Hover_2Type_Terrain(CFG.core.getProv(this.iProvinceID).getTerrainTypeID(), 0, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text(CFG.terrainTypesManager.getName(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()) + ": "));
            nData.add(new ME_Hover_2Type_Text("+" + (int)(CFG.terrainTypesManager.getPopulationGrowth(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        } else if (CFG.terrainTypesManager.getPopulationGrowth(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()) < 0.0f) {
            nData.add(new ME_Hover_2Type_Color(CFG.terrainTypesManager.getColor(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()), 0, 0));
            nData.add(new ME_Hover_2Type_Terrain(CFG.core.getProv(this.iProvinceID).getTerrainTypeID(), 0, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text(CFG.terrainTypesManager.getName(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()) + ": "));
            nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.terrainTypesManager.getPopulationGrowth(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()) * 100.0f) + "%", CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        } else {
            nData.add(new ME_Hover_2Type_Color(CFG.terrainTypesManager.getColor(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()), 0, 0));
            nData.add(new ME_Hover_2Type_Terrain(CFG.core.getProv(this.iProvinceID).getTerrainTypeID(), 0, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text(CFG.terrainTypesManager.getName(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()), CFG.COLOR_HOVER_TITLE));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
        nData.add(new ME_Hover_2Type_Text(this.sPopulationPerc, CFG.COLOR_POPULATION));
        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}

