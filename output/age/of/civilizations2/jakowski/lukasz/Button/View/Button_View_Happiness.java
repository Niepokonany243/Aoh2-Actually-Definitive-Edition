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

public class Button_View_Happiness
extends ButtonM {
    private boolean row = false;
    private int iProvinceID = 0;
    private String sPopulationPerc;
    private int iPopulationPercWidth = 0;
    private int iLargestNationality = 0;
    public Color cColorStability;
    public boolean isFestivalOrganized = false;
    public int imgHapp = 0;
    private String sPropaganda;
    private int iPropagandaWidth = 0;

    public Button_View_Happiness(int iRow, String sText, int nProvinceID, int iPosX, int iPosY, int iWidth, boolean isFestivalOrganized) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, Menu_InGame_View_Army.getButtonHeight(), true, true, false, false);
        this.row = iRow % 2 == 0;
        this.iProvinceID = nProvinceID;
        this.isFestivalOrganized = isFestivalOrganized;
        for (int i = 1; i < CFG.core.getProv(this.iProvinceID).getPop().getNatsSize(); ++i) {
            if (CFG.core.getProv(this.iProvinceID).getPop().getPopulationID(this.iLargestNationality) >= CFG.core.getProv(this.iProvinceID).getPop().getPopulationID(i)) continue;
            this.iLargestNationality = i;
        }
        this.iLargestNationality = CFG.core.getProv(this.iProvinceID).getPop().getCivID(this.iLargestNationality);
        if (CFG.core.isPropagandaOrganized(this.iProvinceID) > 0) {
            this.sPropaganda = "" + CFG.core.isPropagandaOrganized(this.iProvinceID);
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sPropaganda);
            this.iPropagandaWidth = (int)CFG.glyphLay.width;
        } else {
            this.sPropaganda = "";
            this.iPropagandaWidth = 0;
        }
        this.sPopulationPerc = "" + (float)((int)(CFG.core.getProv(this.iProvinceID).getHappi() * 10000.0f)) / 100.0f + "%";
        this.imgHapp = CFG.getHappinessImage((int)(CFG.core.getProv(this.iProvinceID).getHappi() * 100.0f));
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sPopulationPerc);
        this.iPopulationPercWidth = (int)CFG.glyphLay.width;
        this.cColorStability = CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, (int)(CFG.core.getProv(this.iProvinceID).getHappi() * 100.0f), 100, 1.0f);
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
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.diploFestival).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.diploFestival).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.diploFestival).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.diploFestival).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.diploFestival).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.diploFestival).getHeight(), (int)((float)IMGManager.getIMG(Images.diploFestival).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.diploFestival).getHeight())), (int)((float)IMGManager.getIMG(Images.diploFestival).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.diploFestival).getHeight())));
        }
        if (this.iProvinceID == CFG.core.getActiveProvID()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.825f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        oSB.setColor(Color.WHITE);
    }

    private final float getImageScale2(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iLargestNationality);
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        IMGManager.getIMG(this.imgHapp).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(this.imgHapp).getWidth() * this.getImageScale(this.imgHapp, 1.0f)) - this.iPopulationPercWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(this.imgHapp).getHeight() * this.getImageScale(this.imgHapp, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(this.imgHapp).getWidth() * this.getImageScale(this.imgHapp, 1.0f)), (int)((float)IMGManager.getIMG(this.imgHapp).getHeight() * this.getImageScale(this.imgHapp, 1.0f)));
        if (CFG.core.isPropagandaOrganized(this.iProvinceID) > 0) {
            IMGManager.getIMG(Images.propaganda).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(this.imgHapp).getWidth() * this.getImageScale(this.imgHapp, 1.0f)) - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.propaganda).getWidth() * this.getImageScale(Images.propaganda, 1.0f)) - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.propaganda).getHeight() * this.getImageScale(Images.propaganda, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.propaganda).getWidth() * this.getImageScale(Images.propaganda, 1.0f)), (int)((float)IMGManager.getIMG(Images.propaganda).getHeight() * this.getImageScale(Images.propaganda, 1.0f)));
            if (this.iPropagandaWidth > 0) {
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sPropaganda, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(this.imgHapp).getWidth() * this.getImageScale(this.imgHapp, 1.0f)) - (int)((float)IMGManager.getIMG(Images.propaganda).getWidth() * this.getImageScale(Images.propaganda, 1.0f)) - this.iPopulationPercWidth - CFG.PADD * 2 - this.iPropagandaWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_NEUTRAL);
            } else {
                try {
                    this.sPropaganda = "" + CFG.core.isPropagandaOrganized(this.iProvinceID);
                    CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sPropaganda);
                    this.iPropagandaWidth = (int)CFG.glyphLay.width;
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sPopulationPerc, this.getPosXE() + this.getWidthE() - CFG.PADD - this.iPopulationPercWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.cColorStability);
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

    @Override
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.iProvinceID).getCivId(), 0, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getProv(this.iProvinceID).getHappi() * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image(CFG.getHappinessImage((int)(CFG.core.getProv(this.iProvinceID).getHappi() * 100.0f)), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            if (CFG.core.isPropagandaOrganized(this.iProvinceID) > 0) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ReceivingPropaganda") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.lang.get("TurnsX", CFG.core.isPropagandaOrganized(this.iProvinceID)), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.propaganda, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).isFestivalOrganized(this.iProvinceID)) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Festival") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.lang.get("TurnsX", CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).isFestivalOrganized_TurnsLeft(this.iProvinceID)), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploFestival, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException ex) {
            this.menuElemHover = null;
        }
    }
}

