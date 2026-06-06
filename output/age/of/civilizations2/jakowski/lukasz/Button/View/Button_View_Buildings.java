
package age.of.civilizations2.jakowski.lukasz.Button.View;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_View_Buildings
extends ButtonM {
    private boolean row = false;
    private int iProvinceID = 0;
    private String sPopulation;
    private int iPopulationWidth = 0;
    private int iLargestNationality = 0;
    public boolean isAssimiliate = false;

    public Button_View_Buildings(int iRow, String sText, int nProvinceID, int totalPop, int iPosX, int iPosY, int iWidth, boolean isAssimiliate) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, Menu_InGame_View_Army.getButtonHeight(), true, true, false, false);
        this.row = iRow % 2 == 0;
        this.iProvinceID = nProvinceID;
        this.iLargestNationality = CFG.core.getProv(this.iProvinceID).getCivId();
        this.sPopulation = "" + totalPop;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), "" + this.sPopulation);
        this.iPopulationWidth = (int)CFG.glyphLay.width;
        this.isAssimiliate = isAssimiliate;
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
        int nX = 0;
        if (CFG.core.getProv(this.iProvinceID).getLvlOfFort() > 0) {
            IMGManager.getIMG(Images.bFort).drawO(oSB, this.getPosXE() + this.getWidthE() + (nX -= CFG.PADD + (int)((float)IMGManager.getIMG(Images.bFort).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bFort).getHeight()))) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bFort).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bFort).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bFort).getHeight(), (int)((float)IMGManager.getIMG(Images.bFort).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bFort).getHeight())), (int)((float)IMGManager.getIMG(Images.bFort).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bFort).getHeight())));
        }
        if (CFG.core.getProv(this.iProvinceID).getLvlOfWatchTower() > 0) {
            IMGManager.getIMG(Images.bTower).drawO(oSB, this.getPosXE() + this.getWidthE() + (nX -= CFG.PADD + (int)((float)IMGManager.getIMG(Images.bTower).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bTower).getHeight()))) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bTower).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bTower).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bTower).getHeight(), (int)((float)IMGManager.getIMG(Images.bTower).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bTower).getHeight())), (int)((float)IMGManager.getIMG(Images.bTower).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bTower).getHeight())));
        }
        if (CFG.core.getProv(this.iProvinceID).getLvlOfPort() > 0) {
            IMGManager.getIMG(Images.bPort).drawO(oSB, this.getPosXE() + this.getWidthE() + (nX -= CFG.PADD + (int)((float)IMGManager.getIMG(Images.bPort).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bPort).getHeight()))) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bPort).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bPort).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bPort).getHeight(), (int)((float)IMGManager.getIMG(Images.bPort).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bPort).getHeight())), (int)((float)IMGManager.getIMG(Images.bPort).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bPort).getHeight())));
        }
        if (CFG.core.getProv(this.iProvinceID).getLvlOfFarm() > 0) {
            IMGManager.getIMG(Images.bFarm).drawO(oSB, this.getPosXE() + this.getWidthE() + (nX -= CFG.PADD + (int)((float)IMGManager.getIMG(Images.bFarm).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bFarm).getHeight()))) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bFarm).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bFarm).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bFarm).getHeight(), (int)((float)IMGManager.getIMG(Images.bFarm).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bFarm).getHeight())), (int)((float)IMGManager.getIMG(Images.bFarm).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bFarm).getHeight())));
        }
        if (CFG.core.getProv(this.iProvinceID).getLvlOfWorkshop() > 0) {
            IMGManager.getIMG(Images.bWorkshop).drawO(oSB, this.getPosXE() + this.getWidthE() + (nX -= CFG.PADD + (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight()))) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bWorkshop).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bWorkshop).getHeight(), (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())), (int)((float)IMGManager.getIMG(Images.bWorkshop).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())));
        }
        if (CFG.core.getProv(this.iProvinceID).getLvlOfMarket() > 0) {
            IMGManager.getIMG(Images.bMarket).drawO(oSB, this.getPosXE() + this.getWidthE() + (nX -= CFG.PADD + (int)((float)IMGManager.getIMG(Images.bMarket).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bMarket).getHeight()))) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bMarket).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bMarket).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bMarket).getHeight(), (int)((float)IMGManager.getIMG(Images.bMarket).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bMarket).getHeight())), (int)((float)IMGManager.getIMG(Images.bMarket).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bMarket).getHeight())));
        }
        if (CFG.core.getProv(this.iProvinceID).getLvlOfLibrary() > 0) {
            IMGManager.getIMG(Images.bLibrary).drawO(oSB, this.getPosXE() + this.getWidthE() + (nX -= CFG.PADD + (int)((float)IMGManager.getIMG(Images.bLibrary).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bLibrary).getHeight()))) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bLibrary).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bLibrary).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bLibrary).getHeight(), (int)((float)IMGManager.getIMG(Images.bLibrary).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bLibrary).getHeight())), (int)((float)IMGManager.getIMG(Images.bLibrary).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bLibrary).getHeight())));
        }
        if (CFG.core.getProv(this.iProvinceID).getLvlOfArmoury() > 0) {
            IMGManager.getIMG(Images.bArmoury).drawO(oSB, this.getPosXE() + this.getWidthE() + (nX -= CFG.PADD + (int)((float)IMGManager.getIMG(Images.bArmoury).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bArmoury).getHeight()))) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bArmoury).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bArmoury).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bArmoury).getHeight(), (int)((float)IMGManager.getIMG(Images.bArmoury).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bArmoury).getHeight())), (int)((float)IMGManager.getIMG(Images.bArmoury).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bArmoury).getHeight())));
        }
        if (CFG.core.getProv(this.iProvinceID).getLvlOfSupply() > 0) {
            IMGManager.getIMG(Images.bSupply).drawO(oSB, this.getPosXE() + this.getWidthE() + (nX -= CFG.PADD + (int)((float)IMGManager.getIMG(Images.bSupply).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bSupply).getHeight()))) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bSupply).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bSupply).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bSupply).getHeight(), (int)((float)IMGManager.getIMG(Images.bSupply).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bSupply).getHeight())), (int)((float)IMGManager.getIMG(Images.bSupply).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bSupply).getHeight())));
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iLargestNationality);
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getTextE(), this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, "" + this.sPopulation, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.6f));
    }

    @Override
    public int getCurr() {
        return this.iProvinceID;
    }

    private final float getImageScale(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    private final float getImageScale2(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight * 1.2f;
    }

    @Override
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            if (CFG.core.getProv(this.iProvinceID).getLvlOfFort() > 0) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFort_Name(CFG.core.getProv(this.iProvinceID).getLvlOfFort())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.bFort, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(this.iProvinceID).getLvlOfFort(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("HidesTheArmyFromTheSightOfViewOfWatchTower"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + BuildingsManager.getFort_DefenseBonus(CFG.core.getProv(this.iProvinceID).getLvlOfFort()) + "%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getProv(this.iProvinceID).getLvlOfWatchTower() > 0) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getTower_Name(CFG.core.getProv(this.iProvinceID).getLvlOfWatchTower())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.bTower, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(this.iProvinceID).getLvlOfWatchTower(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllowsToSeeTheArmyInNeighboringProvinces"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + BuildingsManager.getTower_DefenseBonus(CFG.core.getProv(this.iProvinceID).getLvlOfWatchTower()) + "%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getProv(this.iProvinceID).getLvlOfPort() > 0) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getPort_Name(CFG.core.getProv(this.iProvinceID).getLvlOfPort())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.bPort, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(this.iProvinceID).getLvlOfPort(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllowsYourArmyGoToTheSea"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.icon_move_sea, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getPort_IncomeProduction(CFG.core.getProv(this.iProvinceID).getLvlOfPort()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getProv(this.iProvinceID).getLvlOfLibrary() > 0) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getLibrary_Name(CFG.core.getProv(this.iProvinceID).getLvlOfLibrary())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.bLibrary, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(this.iProvinceID).getLvlOfLibrary(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("+1"), CFG.COLOR_RESEARCH));
                nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchPerTurnForEveryXPeopleInProvince", BuildingsManager.getLibrary_ResearchPerPopulation(CFG.core.getProv(this.iProvinceID).getLvlOfLibrary())), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getProv(this.iProvinceID).getLvlOfFarm() > 0) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFarm_Name(CFG.core.getProv(this.iProvinceID).getLvlOfFarm())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.bFarm, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(this.iProvinceID).getLvlOfFarm(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("GrowthRate") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getFarm_GrowthRateBonus(CFG.core.getProv(this.iProvinceID).getLvlOfFarm()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getProv(this.iProvinceID).getLvlOfWorkshop() > 0) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getWorkshop_Name(CFG.core.getProv(this.iProvinceID).getLvlOfWorkshop())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.bWorkshop, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(this.iProvinceID).getLvlOfWorkshop(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getWorkshop_IncomeProduction(CFG.core.getProv(this.iProvinceID).getLvlOfWorkshop()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getProv(this.iProvinceID).getLvlOfMarket() > 0) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getMarket_Name(CFG.core.getProv(this.iProvinceID).getLvlOfMarket())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.bMarket, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(this.iProvinceID).getLvlOfMarket(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeTaxation") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getMarket_IncomeTaxation(CFG.core.getProv(this.iProvinceID).getLvlOfMarket()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getProv(this.iProvinceID).getLvlOfArmoury() > 0) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getArmoury_Name(CFG.core.getProv(this.iProvinceID).getLvlOfArmoury())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.bArmoury, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(this.iProvinceID).getLvlOfArmoury(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ReducesTheCostOfRecruitmentPerUnitByOneGold"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getProv(this.iProvinceID).getLvlOfSupply() > 0) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getSupply_Name(CFG.core.getProv(this.iProvinceID).getLvlOfSupply())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.bSupply, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(this.iProvinceID).getLvlOfSupply(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                nData.add(new ME_Hover_2Type_Text("-" + (int)(BuildingsManager.getSupply_Bonus(CFG.core.getProv(this.iProvinceID).getLvlOfSupply()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getProv(this.iProvinceID).provGD.iAirDefense > 0) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getAirDefense_Name(CFG.core.getProv(this.iProvinceID).provGD.iAirDefense)), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.bSupply, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(this.iProvinceID).provGD.iAirDefense, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(" - "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("InterceptionChance") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getAirDefense_ProtectionChance(CFG.core.getProv(this.iProvinceID).provGD.iAirDefense) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
    }
}

