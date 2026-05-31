
package age.of.civilizations2.jakowski.lukasz.Button2;

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
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_NS_Population_Buildings
extends ButtonM {
    public long lTime = 0L;
    public float fAlphaMod = 0.0f;
    public boolean backAnimation = false;
    public boolean row = false;
    public int iCivID = 0;
    public String sDeathsTEXT;
    public int iDeathsTEXTWidth;
    public String sDeaths;
    public int iDeathsWidth;
    public Color oColor;
    public int iImageID;
    public Color textColor;
    public int fontID2 = 0;
    public String sProv;
    public int iProvWidth;

    public Button_NS_Population_Buildings(Color nColor, String sText, int nCivID, String sTextLeft, String nPop, int iImageID, Color textColor, int iPosX, int iPosY, int iWidth, int provinces) {
        this.fontID = CFG.FONT_BOLD;
        this.fontID2 = CFG.FONT_BOLD_SMALL;
        super.init(CFG.lang.get(sText), 0, iPosX, iPosY, iWidth, Math.max(IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 4, CFG.BUTTON_H * 4 / 5), true, true, false, false);
        this.iCivID = nCivID;
        this.oColor = nColor;
        this.iImageID = iImageID;
        this.textColor = textColor;
        this.sDeaths = nPop;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sDeaths);
        this.iDeathsWidth = (int)CFG.glyphLay.width;
        this.sDeathsTEXT = sTextLeft;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sDeathsTEXT);
        this.iDeathsTEXTWidth = (int)CFG.glyphLay.width;
        this.sProv = CFG.getNumberWthSpaces("" + provinces);
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sProv);
        this.iProvWidth = (int)CFG.glyphLay.width;
    }

    public static int getLeftFlagWidth() {
        return IMGManager.getIMG(Images.flagRect2).getWidth() + Button_NS_Population_Buildings.getLeftFlagPadding() * 2;
    }

    public static int getLeftFlagPadding() {
        return CFG.PADD * 2;
    }

    public static int getLeftFlagHeight() {
        return IMGManager.getIMG(Images.flagRect2).getHeight();
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(this.oColor.r, this.oColor.g, this.oColor.b, 0.1f));
        IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, Button_NS_Population_Buildings.getLeftFlagWidth(), this.getHeightE());
        oSB.setColor(new Color(this.oColor.r, this.oColor.g, this.oColor.b, 0.575f));
        IMGManager.getIMG(Images.patternSquareTiny).draw2(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, Button_NS_Population_Buildings.getLeftFlagWidth(), this.getHeightE(), true, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + Button_NS_Population_Buildings.getLeftFlagWidth() - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), false, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + Button_NS_Population_Buildings.getLeftFlagWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        if (this.row) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.4f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.35f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.35f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.6f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.85f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.getIsHovered()) {
            if (this.lTime < System.currentTimeMillis() - 30L) {
                if (this.backAnimation) {
                    this.fAlphaMod -= 0.02f;
                    if (this.fAlphaMod < 0.0f) {
                        this.backAnimation = false;
                    }
                } else {
                    this.fAlphaMod += 0.02f;
                    if (this.fAlphaMod > 0.4f) {
                        this.backAnimation = true;
                    }
                }
                this.lTime = System.currentTimeMillis();
            }
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f - this.fAlphaMod));
            CFG.setRenderO(true);
        } else {
            this.backAnimation = false;
            this.fAlphaMod = 0.0f;
            this.lTime = System.currentTimeMillis();
        }
        Core.drawFlagRectGovernment(oSB, this.getPosXE() + Button_NS_Population_Buildings.getLeftFlagPadding() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - Button_NS_Population_Buildings.getLeftFlagHeight() / 2 + iTranslateY, this.iCivID);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(this.iImageID).draw(oSB, this.getPosXE() + CFG.PADD + Button_NS_Population_Buildings.getLeftFlagWidth() + this.iDeathsWidth + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale(this.iImageID, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale(this.iImageID, 1.0f)), (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale(this.iImageID, 1.0f)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD + Button_NS_Population_Buildings.getLeftFlagWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() * 1.0f) - CFG.PADD + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sDeathsTEXT, this.getPosXE() + this.getWidthE() - CFG.PADD - this.iDeathsTEXTWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_ACTIVE);
        Renderer.drawTextWithShadow(oSB, this.fontID2, this.sDeaths, this.getPosXE() + CFG.PADD + Button_NS_Population_Buildings.getLeftFlagWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, this.textColor);
        Renderer.drawTextWithShadow(oSB, this.fontID2, this.sProv, this.getPosXE() + CFG.PADD * 3 + this.iDeathsWidth + (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale(this.iImageID, 1.0f)) + Button_NS_Population_Buildings.getLeftFlagWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_NEUTRAL);
        IMGManager.getIMG(Images.provinces).draw(oSB, this.getPosXE() + CFG.PADD * 4 + this.iDeathsWidth + this.iProvWidth + (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale(this.iImageID, 1.0f)) + Button_NS_Population_Buildings.getLeftFlagWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(Images.provinces).getHeight() * this.getImageScale(Images.provinces, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * this.getImageScale(Images.provinces, 1.0f)), (int)((float)IMGManager.getIMG(Images.provinces).getHeight() * this.getImageScale(Images.provinces, 1.0f)));
    }

    public float getImageScale(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.525f));
    }

    @Override
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            if (this.iCivID > 0) {
                nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivID).getCivName(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            } else {
                nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Buildings") + ": "));
            nData.add(new ME_Hover_2Type_Text(this.sDeaths, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Image(this.iImageID, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Flag(this.iCivID, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Total") + ": "));
            nData.add(new ME_Hover_2Type_Text(this.sDeathsTEXT, CFG.COLOR_TEXT_GRAY_NS));
            nData.add(new ME_Hover_2Type_Image(Images.buildAll, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Image(Images.editorMap, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
            nData.add(new ME_Hover_2Type_Text(this.sProv, CFG.COLOR_TEXT_GRAY_NS));
            nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Flag(this.iCivID, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
    }

    @Override
    public void actionElem(int iID) {
        CFG.map.getMpC().centerToCapital_OrMetProvinceCivID_Just(this.iCivID);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }
}

