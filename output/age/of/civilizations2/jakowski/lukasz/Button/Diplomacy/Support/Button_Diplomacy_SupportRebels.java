/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Support;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameManager;
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
import age.of.civilizations2.jakowski.lukasz.Menus.Vassal.Rebels.Menu_InGame_SupportRebels;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Button_Diplomacy_SupportRebels
extends ButtonStats {
    public int id;
    public int iCivA;
    public String sPopulation;
    public int iPopulationWidth;
    public int iRevolutionaryRisk;
    public int iRevolutionaryRiskWidth;
    public int iProvinces;
    public int iProvincesWidth;

    public Button_Diplomacy_SupportRebels(int i, int iCivA, long iPopulation, int iRevolutionaryRisk, int nProvinces, int iPosX, int iPosY, int iWidth) {
        super(CFG.core.getCiv(iCivA).getCivName(), CFG.FONT_BOLD_SMALL, 0, iPosX, iPosY, iWidth, Math.max(Menu_InGame_View_Army.getButtonHeight(), CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 6), false);
        this.id = i;
        this.iCivA = iCivA;
        this.row = i % 2 == 0;
        this.sPopulation = CFG.getNumberWthSpaces("" + iPopulation);
        this.iRevolutionaryRisk = iRevolutionaryRisk;
        this.iProvinces = nProvinces;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sPopulation);
        this.iPopulationWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.iProvinces);
        this.iProvincesWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + iRevolutionaryRisk + "%");
        this.iRevolutionaryRiskWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.row) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.15f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 6, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 6 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 6, this.getHeightE(), true, false);
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.05f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 6, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 6 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 6, this.getHeightE(), true, false);
        }
        if (isActive || this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, isActive ? 0.345f : 0.265f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
        }
        if (this.row) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.625f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE());
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.375f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE());
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(Color.WHITE);
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivA);
        IMGManager.getIMG(Images.diploRevolution).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - this.iRevolutionaryRiskWidth - (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.diploRevolution).getHeight() * this.getImageScale(Images.diploRevolution)) / 2 - IMGManager.getIMG(Images.diploRevolution).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)), (int)((float)IMGManager.getIMG(Images.diploRevolution).getHeight() * this.getImageScale(Images.diploRevolution)));
        IMGManager.getIMG(Images.provinces).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 5 - this.iRevolutionaryRiskWidth - this.iProvincesWidth - (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * this.getImageScale(Images.provinces)) - (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.provinces).getHeight() * this.getImageScale(Images.provinces)) / 2 - IMGManager.getIMG(Images.provinces).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * this.getImageScale(Images.provinces)), (int)((float)IMGManager.getIMG(Images.provinces).getHeight() * this.getImageScale(Images.provinces)));
        IMGManager.getIMG(Images.pop).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 7 - this.iRevolutionaryRiskWidth - this.iProvincesWidth - this.iPopulationWidth - (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * this.getImageScale(Images.provinces)) - (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)) - (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop)) / 2 - IMGManager.getIMG(Images.pop).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD * 3 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT / 2.0f) + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.iRevolutionaryRisk + "%", this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iRevolutionaryRiskWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT / 2.0f) + iTranslateY, CFG.getColorStep(CFG.COLOR_REVOLUTION_MIN, CFG.COLOR_REVOLUTION_MAX, this.iRevolutionaryRisk, 2000, 1.0f));
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.iProvinces, this.getPosXE() + this.getWidthE() - CFG.PADD * 4 - this.iRevolutionaryRiskWidth - this.iProvincesWidth - (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT / 2.0f) + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.sPopulation, this.getPosXE() + this.getWidthE() - CFG.PADD * 6 - this.iRevolutionaryRiskWidth - this.iProvincesWidth - this.iPopulationWidth - (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(Images.diploRevolution)) - (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * this.getImageScale(Images.provinces)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT / 2.0f) + iTranslateY, CFG.COLOR_POPULATION);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (Button_Diplomacy_SupportRebels.this.getCheckboxSt()) {
                        oSB.setColor(new Color(0.55f, 0.8f, 0.0f, 0.2f));
                    } else {
                        oSB.setColor(new Color(0.8f, 0.137f, 0.0f, 0.15f));
                    }
                    IMGManager.getIMG(Images.line32Off1).drawO(oSB, Button_Diplomacy_SupportRebels.this.getPosXE() + iTranslateX, Button_Diplomacy_SupportRebels.this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + 1 + iTranslateY, Button_Diplomacy_SupportRebels.this.getWidthE(), Button_Diplomacy_SupportRebels.this.getHeightE() - 2, true, false);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Diplomacy_SupportRebels.this.getPosXE() + iTranslateX, Button_Diplomacy_SupportRebels.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, Button_Diplomacy_SupportRebels.this.getWidthE(), Button_Diplomacy_SupportRebels.this.getHeightE() / 4, false, false);
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Diplomacy_SupportRebels.this.getPosXE() + iTranslateX, Button_Diplomacy_SupportRebels.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + Button_Diplomacy_SupportRebels.this.getHeightE() - 1 + iTranslateY - Button_Diplomacy_SupportRebels.this.getHeightE() / 4, Button_Diplomacy_SupportRebels.this.getWidthE(), Button_Diplomacy_SupportRebels.this.getHeightE() / 4, false, true);
                    oSB.setColor(Color.WHITE);
                }
            };
        }
        return new ButtonM.Checkbox(){

            @Override
            public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
            }
        };
    }

    public final float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS);
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivA, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivA).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
        nData.add(new ME_Hover_2Type_Text(this.sPopulation, CFG.COLOR_POPULATION));
        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RevolutionaryRisk") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + this.iRevolutionaryRisk + "%", CFG.getColorStep(CFG.COLOR_REVOLUTION_MIN, CFG.COLOR_REVOLUTION_MAX, this.iRevolutionaryRisk, 2000, 1.0f)));
        nData.add(new ME_Hover_2Type_Image(Images.diploRevolution, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        List<Integer> rebelsProvinces = GameManager.supportRebels_Provinces(Menu_InGame_SupportRebels.iOnCivID, this.getCurr());
        if (rebelsProvinces.size() > 0) {
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            ArrayList<Integer> tSorted = new ArrayList<Integer>();
            while (rebelsProvinces.size() > 0) {
                int tBest = 0;
                for (int i = 1; i < rebelsProvinces.size(); ++i) {
                    if (CFG.core.getProv(rebelsProvinces.get(tBest)).getPop().getPopulationOfCivID(this.getCurr()) >= CFG.core.getProv(rebelsProvinces.get(i)).getPop().getPopulationOfCivID(this.getCurr())) continue;
                    tBest = i;
                }
                tSorted.add(rebelsProvinces.get(tBest));
                rebelsProvinces.remove(tBest);
            }
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + tSorted.size(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            for (int i = 0; i < tSorted.size() && i < 14; ++i) {
                nData.add(new ME_Hover_2Type_Flag(this.getCurr()));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv((Integer)tSorted.get(i)) ? CFG.core.getProv((Integer)tSorted.get(i)).getName() : CFG.lang.get("Undiscovered")) + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv((Integer)tSorted.get(i)).getPop().getPopulationOfCivID(this.getCurr())), CFG.COLOR_POPULATION));
                nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
        }
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public int getCurr() {
        return this.iCivA;
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }
}

