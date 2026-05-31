/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.View;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
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
import age.of.civilizations2.jakowski.lukasz.Menus.Info.Menu_InGame_ProvInfo;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_View_Population
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
    private int iLargestNationality = 0;
    public boolean isAssimiliate = false;
    public String sLevel = "";
    public int iLevelWidth = 0;

    public Button_View_Population(int iRow, String sText, int nProvinceID, int totalPop, int iPosX, int iPosY, int iWidth, boolean isAssimiliate) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, Menu_InGame_View_Army.getButtonHeight(), true, true, false, false);
        this.row = iRow % 2 == 0;
        this.iProvinceID = nProvinceID;
        for (int i = 1; i < CFG.core.getProv(this.iProvinceID).getPop().getNatsSize(); ++i) {
            if (CFG.core.getProv(this.iProvinceID).getPop().getPopulationID(this.iLargestNationality) >= CFG.core.getProv(this.iProvinceID).getPop().getPopulationID(i)) continue;
            this.iLargestNationality = i;
        }
        this.iLargestNationality = CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.iLargestNationality);
        this.sPopulation = "" + CFG.getNumberWthSpaces("" + CFG.core.getProv(this.iProvinceID).getPop().getPops());
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), "" + this.sPopulation);
        this.iPopulationWidth = (int)CFG.glyphLay.width;
        this.sPopulationPerc = totalPop == 0 ? "" : "" + Math.max(0.0f, Math.min(100.0f, (float)((long)((float)CFG.core.getProv(this.iProvinceID).getPop().getPops() / (float)totalPop * 10000.0f)) / 100.0f)) + "%";
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sPopulationPerc);
        this.iPopulationPercWidth = (int)CFG.glyphLay.width;
        long difference = CFG.core.getProv(this.iProvinceID).getPop().getPops() - CFG.core.getProv((int)this.iProvinceID).provGD.startingPopulation;
        this.sPopulationDiff = (difference > 0L ? "+" : "") + CFG.getNumberWthSpaces("" + difference);
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), "" + this.sPopulationDiff);
        this.iPopulationDiffWidth = (int)CFG.glyphLay.width;
        this.differenceColor = difference > 0L ? CFG.COLOR_POSITIVE : (difference < 0L ? CFG.COLOR_NEGATIVE_1 : CFG.COLOR_NEUTRAL);
        this.isAssimiliate = isAssimiliate;
        if (nProvinceID >= 0 && CFG.core.getProv(nProvinceID).getLvlOfLibrary() > 0) {
            this.sLevel = "" + CFG.core.getProv(nProvinceID).getLvlOfLibrary();
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
        if (CFG.core.getProv(this.iProvinceID).getLvlOfLibrary() > 0) {
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.bLibrary).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.bLibrary).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bLibrary).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bLibrary).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bLibrary).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bLibrary).getHeight(), (int)((float)IMGManager.getIMG(Images.bLibrary).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bLibrary).getHeight())), (int)((float)IMGManager.getIMG(Images.bLibrary).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bLibrary).getHeight())));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sLevel, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.bLibrary).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bLibrary).getHeight())) - CFG.PADD - this.iLevelWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iLargestNationality);
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getTextE(), this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD + iTranslateY, this.getColorE(isActive));
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, "" + this.sPopulation, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_POPULATION);
        IMGManager.getIMG(Images.pop).draw(oSB, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 3 + this.iPopulationWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop, 1.0f)));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, "" + this.sPopulationDiff, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 4 + this.iPopulationWidth + (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, this.differenceColor);
        IMGManager.getIMG(Images.pop).draw(oSB, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 5 + this.iPopulationWidth + this.iPopulationDiffWidth + (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop, 1.0f)));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sPopulationPerc, this.getPosXE() + this.getWidthE() - CFG.PADD - this.iPopulationPercWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_ACTIVE);
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
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    public float getImageScale(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    @Override
    public void buildElemHover() {
        this.menuElemHover = Menu_InGame_ProvInfo.getHoverPopulation(this.iProvinceID);
    }

    public static ME_Hover_v2 getHoverPopulation(int iProvinceID) {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            if (iProvinceID >= 0) {
                int i;
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(iProvinceID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Population") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + CFG.core.getProv(iProvinceID).getPop().getPops()), CFG.COLOR_POPULATION));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                ArrayList<Integer> tSortedCivs = new ArrayList<Integer>();
                ArrayList<Integer> tSortedPop = new ArrayList<Integer>();
                for (i = 0; i < CFG.core.getProv(iProvinceID).getPop().getNatsSize(); ++i) {
                    tSortedCivs.add(CFG.core.getProv(iProvinceID).getPop().getCivID(i));
                    tSortedPop.add((int)CFG.core.getProv(iProvinceID).getPop().getPopulationID(i));
                }
                for (i = 0; i < tSortedCivs.size() - 1; ++i) {
                    for (int j = i + 1; j < tSortedCivs.size(); ++j) {
                        if ((Integer)tSortedPop.get(i) >= (Integer)tSortedPop.get(j)) continue;
                        int tempD = (Integer)tSortedCivs.get(i);
                        tSortedCivs.set(i, (Integer)tSortedCivs.get(j));
                        tSortedCivs.set(j, tempD);
                        tempD = (Integer)tSortedPop.get(i);
                        tSortedPop.set(i, (Integer)tSortedPop.get(j));
                        tSortedPop.set(j, tempD);
                    }
                }
                if (CFG.FOG_OF_WAR == 2) {
                    for (i = 0; i < tSortedCivs.size(); ++i) {
                        nData.add(new ME_Hover_2Type_Flag(CFG.getMetCiv((Integer)tSortedCivs.get(i)) ? (Integer)tSortedCivs.get(i) : -(i + 1)));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tSortedPop.get(i)), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Text(" [" + CFG.getPercentageOld((Integer)tSortedPop.get(i), CFG.core.getProv(iProvinceID).getPop().getPops(), 5) + "%]", CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text(" " + (CFG.getMetCiv((Integer)tSortedCivs.get(i)) ? CFG.core.getCiv((Integer)tSortedCivs.get(i)).getCivName() : CFG.lang.get("Unknown")), Color.WHITE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                } else {
                    for (i = 0; i < tSortedCivs.size(); ++i) {
                        nData.add(new ME_Hover_2Type_Flag((Integer)tSortedCivs.get(i)));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tSortedPop.get(i)), CFG.COLOR_POPULATION));
                        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text("[" + CFG.getPercentageOld((Integer)tSortedPop.get(i), CFG.core.getProv(iProvinceID).getPop().getPops(), 5) + "%]", CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text(" " + CFG.core.getCiv((Integer)tSortedCivs.get(i)).getCivName(), CFG.COLOR_TEXT_RANK_HOVER));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                }
            } else {
                return null;
            }
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }
}

