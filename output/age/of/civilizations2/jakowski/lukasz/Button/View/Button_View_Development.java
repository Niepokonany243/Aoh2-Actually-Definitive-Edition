
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
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_View_Development
extends ButtonM {
    private boolean row = false;
    private int iProvinceID = 0;
    private String sPopulation;
    private int iPopulationWidth = 0;
    private String sPopulationPerc;
    private int iPopulationPercWidth = 0;
    private boolean isAssimiliate = false;
    public String sLevel = "";
    public int iLevelWidth = 0;
    private String sEconomy;
    private int iEconomyWidth = 0;
    private String sPop;
    private int iPopWidth = 0;
    public float fPerc = 0.0f;

    public Button_View_Development(int iRow, String sText, int nProvinceID, int iPosX, int iPosY, int iWidth, boolean isAssimiliate) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, Menu_InGame_View_Army.getButtonHeight(), true, true, false, false);
        this.row = iRow % 2 == 0;
        this.iProvinceID = nProvinceID;
        this.fPerc = CFG.core.getProv(this.iProvinceID).getCivId() == 0 ? -1.0f : Math.min(1.0f, CFG.core.getProv(this.iProvinceID).getDeveLvl() / CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).getTechLevel());
        this.sPopulation = "" + (float)((int)(CFG.core.getProv(this.iProvinceID).getDeveLvl() * 100.0f)) / 100.0f;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), "" + this.sPopulation);
        this.iPopulationWidth = (int)CFG.glyphLay.width;
        this.sPopulationPerc = "" + (float)((int)(CFG.core.getProv(this.iProvinceID).getDeveLvl() / CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).getTechLevel() * 10000.0f)) / 100.0f + "%";
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sPopulationPerc);
        this.iPopulationPercWidth = (int)CFG.glyphLay.width;
        this.isAssimiliate = isAssimiliate;
        this.sEconomy = CFG.getNumberWthSpaces("" + CFG.core.getProv(nProvinceID).getEco());
        this.sPop = CFG.getNumberWthSpaces("" + CFG.core.getProv(nProvinceID).getPop().getPops());
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sEconomy);
        this.iEconomyWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sPop);
        this.iPopWidth = (int)CFG.glyphLay.width;
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
        if (this.isAssimiliate) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.525f));
            IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        if (this.iProvinceID == CFG.core.getActiveProvID()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.825f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        if (CFG.core.getProv(this.iProvinceID).getLvlOfWorkshop() > 0) {
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.bWorkshop).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bWorkshop).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bWorkshop).getHeight(), (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())), (int)((float)IMGManager.getIMG(Images.bWorkshop).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sLevel, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.bWorkshop).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.bWorkshop).getHeight())) - CFG.PADD - this.iLevelWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        }
        oSB.setColor(Color.WHITE);
    }

    public Color getColorProgress() {
        return new Color(CFG.COLOR_NEUTRAL2.r, CFG.COLOR_NEUTRAL2.g, CFG.COLOR_NEUTRAL2.b, 0.7f);
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
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getTextE(), this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD + iTranslateY, this.getColorE(isActive));
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, "" + this.sPopulation, this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD + iTranslateY, CFG.COLOR_NEUTRAL2);
        IMGManager.getIMG(Images.development).draw(oSB, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 3 + this.getTextWidthU() + this.iPopulationWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - (int)((float)IMGManager.getIMG(Images.development).getHeight() * this.getImageScale(Images.development, 1.0f)) + iTranslateY, (int)((float)IMGManager.getIMG(Images.development).getWidth() * this.getImageScale(Images.development, 1.0f)), (int)((float)IMGManager.getIMG(Images.development).getHeight() * this.getImageScale(Images.development, 1.0f)));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sPopulationPerc, this.getPosXE() + this.getWidthE() - CFG.PADD - this.iPopulationPercWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_ACTIVE);
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sPop, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_POPULATION);
        IMGManager.getIMG(Images.pop).draw(oSB, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 3 + this.iPopWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop, 1.0f)));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sEconomy, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 4 + this.iPopWidth + (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_ECONOMY);
        IMGManager.getIMG(Images.economy).draw(oSB, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 5 + this.iEconomyWidth + this.iPopWidth + (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy, 1.0f)), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(Images.economy, 1.0f)));
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

    private final float getImageScale2(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    private final float getImageScale(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.iProvinceID).getCivId()));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(this.iProvinceID).getName().length() > 0 ? CFG.core.getProv(this.iProvinceID).getName() : CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Development") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getProv(this.iProvinceID).getDeveLvl() * 100.0f)) / 100.0f, CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text("[" + this.sPopulationPerc + "] ", CFG.COLOR_NEUTRAL));
        nData.add(new ME_Hover_2Type_Text("/ ", CFG.COLOR_NEUTRAL));
        nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyLevel") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("Development2"), CFG.COLOR_NEUTRAL2));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}

