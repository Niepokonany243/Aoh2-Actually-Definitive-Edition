
package age.of.civilizations2.jakowski.lukasz.Button.View;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_View_PopulationEconomy
extends ButtonM {
    private boolean row = false;
    private int iProvinceID = 0;
    private String sPopulation;
    private int iPopulationWidth = 0;
    private String sEconomy;
    private int iEconomyWidth = 0;

    public Button_View_PopulationEconomy(int iRow, String sText, int nProvinceID, int iPosX, int iPosY, int iWidth, boolean isAssimiliate) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, Menu_InGame_View_Army.getButtonHeight(), true, true, false, false);
        this.row = iRow % 2 == 0;
        this.iProvinceID = nProvinceID;
        this.sPopulation = "" + CFG.getNumberWthSpaces("" + CFG.core.getProv(this.iProvinceID).getPop().getPops());
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), "" + this.sPopulation);
        this.iPopulationWidth = (int)CFG.glyphLay.width;
        this.sEconomy = CFG.getNumberWthSpaces("" + CFG.core.getProv(this.iProvinceID).getEco());
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sEconomy);
        this.iEconomyWidth = (int)CFG.glyphLay.width;
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
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getProv(this.iProvinceID).getCivId());
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getTextE(), this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD + iTranslateY, this.getColorE(isActive));
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, "" + this.sPopulation, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_POPULATION);
        IMGManager.getIMG(Images.pop).draw(oSB, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 3 + this.iPopulationWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop, 1.0f)));
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, "" + this.sEconomy, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 4 + this.iPopulationWidth + (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_ECONOMY);
        IMGManager.getIMG(Images.economy).draw(oSB, this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 5 + this.iPopulationWidth + this.iEconomyWidth + (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy, 1.0f)), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(Images.economy, 1.0f)));
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
        this.menuElemHover = Button_View_PopulationEconomy.getHoverPopulation(this.iProvinceID);
    }

    public static ME_Hover_v2 getHoverPopulation(int iProvinceID) {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            if (iProvinceID < 0) {
                return null;
            }
            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(iProvinceID).getProvName()));
            nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
            nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getProv(iProvinceID).getPop().getPops()), CFG.COLOR_POPULATION));
            nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
            nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getProv(iProvinceID).getEco()), CFG.COLOR_ECONOMY));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }
}

