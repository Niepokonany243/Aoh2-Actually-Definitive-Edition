
package age.of.civilizations2.jakowski.lukasz.Button.GameN.Population;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class ButtonN_Pop_2_PopChangeCost
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
    public String sCost;
    public int iCostWidth;
    public int iCostHeight;
    public Color oColor;
    public int iImageID;
    public Color textColor;
    public int iImageID2;
    public int fontID2 = 0;
    public String sPopChange;
    public int iPopChangeWidth;
    public Color popChangeColor;

    public ButtonN_Pop_2_PopChangeCost(Color nColor, String sText, int nCivID, String sTextLeft, String nPop, int iImageID, Color textColor, int iPosX, int iPosY, int iWidth, long popChange, String cost) {
        this.fontID = CFG.FONT_BOLD;
        this.fontID2 = CFG.FONT_BOLD_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, CFG.BUTTON_H, true, true, false, false);
        this.iCivID = nCivID;
        this.oColor = nColor;
        this.iImageID = iImageID;
        this.iImageID2 = iImageID;
        this.textColor = textColor;
        this.sDeaths = nPop;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sDeaths);
        this.iDeathsWidth = (int)CFG.glyphLay.width;
        this.sDeathsTEXT = sTextLeft;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sDeathsTEXT);
        this.iDeathsTEXTWidth = (int)CFG.glyphLay.width;
        this.sCost = cost;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sCost);
        this.iCostWidth = (int)CFG.glyphLay.width;
        this.iCostHeight = (int)CFG.glyphLay.height;
        this.popChangeColor = popChange > 0L ? CFG.COLOR_POSITIVE : (popChange < 0L ? CFG.COLOR_NEGATIVE_1 : CFG.COLOR_NEUTRAL);
        this.sPopChange = (popChange < 0L ? "-" : (popChange > 0L ? "+" : "")) + CFG.getNumberWthSpaces("" + Math.abs(popChange));
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sPopChange);
        this.iPopChangeWidth = (int)CFG.glyphLay.width;
    }

    public ButtonN_Pop_2_PopChangeCost(Color nColor, String sText, int nCivID, String sTextLeft, String nPop, int iImageID, Color textColor, int iPosX, int iPosY, int iWidth, long popChange, boolean deaths, int iImageID2, String cost) {
        this.fontID = CFG.FONT_BOLD;
        this.fontID2 = CFG.FONT_BOLD_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, CFG.BUTTON_H, true, true, false, false);
        this.iCivID = nCivID;
        this.oColor = nColor;
        this.iImageID = iImageID;
        this.iImageID2 = iImageID2;
        this.textColor = textColor;
        this.sCost = cost;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sCost);
        this.iCostWidth = (int)CFG.glyphLay.width;
        this.iCostHeight = (int)CFG.glyphLay.height;
        this.sDeaths = nPop;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sDeaths);
        this.iDeathsWidth = (int)CFG.glyphLay.width;
        this.sDeathsTEXT = sTextLeft;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sDeathsTEXT);
        this.iDeathsTEXTWidth = (int)CFG.glyphLay.width;
        this.popChangeColor = popChange == 0L ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_2;
        this.sPopChange = CFG.getNumberWthSpaces("" + Math.abs(popChange));
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sPopChange);
        this.iPopChangeWidth = (int)CFG.glyphLay.width;
    }

    public ButtonN_Pop_2_PopChangeCost(Color nColor, String sText, int nCivID, String sTextLeft, String nPop, int iImageID, Color textColor, int iPosX, int iPosY, int iWidth, long popChange, int img2, Color color2, String cost) {
        this.fontID = CFG.FONT_BOLD;
        this.fontID2 = CFG.FONT_BOLD_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, CFG.BUTTON_H, true, true, false, false);
        this.iCivID = nCivID;
        this.oColor = nColor;
        this.iImageID = iImageID;
        this.iImageID2 = img2;
        this.textColor = textColor;
        this.sCost = cost;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sCost);
        this.iCostWidth = (int)CFG.glyphLay.width;
        this.iCostHeight = (int)CFG.glyphLay.height;
        this.sDeaths = nPop;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sDeaths);
        this.iDeathsWidth = (int)CFG.glyphLay.width;
        this.sDeathsTEXT = sTextLeft;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sDeathsTEXT);
        this.iDeathsTEXTWidth = (int)CFG.glyphLay.width;
        this.popChangeColor = color2;
        this.sPopChange = CFG.getNumberWthSpaces("" + Math.abs(popChange));
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sPopChange);
        this.iPopChangeWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (ButtonN_Pop_2_PopChangeCost.this.getCheckboxSt()) {
                        oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.2f));
                        IMGManager.getIMG(Images.patternSquareTiny).draw2O(oSB, ButtonN_Pop_2_PopChangeCost.this.getPosXE() + iTranslateX, ButtonN_Pop_2_PopChangeCost.this.getPosY() - IMGManager.getIMG(Images.patternSquareTiny).getHeight() + 1 + iTranslateY, ButtonN_Pop_2_PopChangeCost.getLeftFlagWidth(), ButtonN_Pop_2_PopChangeCost.this.getHeightE() - 2, true, false);
                        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
                        IMGManager.getIMG(Images.gradient).drawO(oSB, ButtonN_Pop_2_PopChangeCost.this.getPosXE() + iTranslateX, ButtonN_Pop_2_PopChangeCost.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, ButtonN_Pop_2_PopChangeCost.getLeftFlagWidth(), ButtonN_Pop_2_PopChangeCost.this.getHeightE() / 4, false, false);
                        IMGManager.getIMG(Images.gradient).drawO(oSB, ButtonN_Pop_2_PopChangeCost.this.getPosXE() + iTranslateX, ButtonN_Pop_2_PopChangeCost.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + ButtonN_Pop_2_PopChangeCost.this.getHeightE() - 1 + iTranslateY - ButtonN_Pop_2_PopChangeCost.this.getHeightE() / 4, ButtonN_Pop_2_PopChangeCost.getLeftFlagWidth(), ButtonN_Pop_2_PopChangeCost.this.getHeightE() / 4, false, true);
                        oSB.setColor(Color.WHITE);
                    }
                }
            };
        }
        return new ButtonM.Checkbox(){

            @Override
            public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
            }
        };
    }

    public static int getLeftFlagWidth() {
        return IMGManager.getIMG(Images.flagRect2).getWidth() + ButtonN_Pop_2_PopChangeCost.getLeftFlagPadding() * 2;
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
        IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, ButtonN_Pop_2_PopChangeCost.getLeftFlagWidth(), this.getHeightE());
        oSB.setColor(new Color(this.oColor.r, this.oColor.g, this.oColor.b, 0.575f));
        IMGManager.getIMG(Images.patternSquareTiny).draw2(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, ButtonN_Pop_2_PopChangeCost.getLeftFlagWidth(), this.getHeightE(), true, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + ButtonN_Pop_2_PopChangeCost.getLeftFlagWidth() - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), false, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + ButtonN_Pop_2_PopChangeCost.getLeftFlagWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
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
        Core.drawFlagRectGovernment(oSB, this.getPosXE() + ButtonN_Pop_2_PopChangeCost.getLeftFlagPadding() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - ButtonN_Pop_2_PopChangeCost.getLeftFlagHeight() / 2 + iTranslateY, this.iCivID);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(this.iImageID).draw(oSB, this.getPosXE() + CFG.PADD + ButtonN_Pop_2_PopChangeCost.getLeftFlagWidth() + this.iDeathsWidth + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale(this.iImageID, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale(this.iImageID, 1.0f)), (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale(this.iImageID, 1.0f)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD + ButtonN_Pop_2_PopChangeCost.getLeftFlagWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() * 1.0f) - CFG.PADD + iTranslateY, this.getColorE(isActive));
        IMGManager.getIMG(Images.topGold()).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold(), 1.0f)) + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), 1.0f)), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold(), 1.0f)));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sCost, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), 1.0f)) - this.iCostWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.iCostHeight + iTranslateY, CFG.COLOR_GOLD);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sDeathsTEXT, this.getPosXE() + this.getWidthE() - CFG.PADD - this.iDeathsTEXTWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_ACTIVE);
        Renderer.drawTextWithShadow(oSB, this.fontID2, this.sDeaths, this.getPosXE() + CFG.PADD + ButtonN_Pop_2_PopChangeCost.getLeftFlagWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, this.textColor);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sPopChange, this.getPosXE() + CFG.PADD * 3 + this.iDeathsWidth + (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale(this.iImageID, 1.0f)) + ButtonN_Pop_2_PopChangeCost.getLeftFlagWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, this.popChangeColor);
        IMGManager.getIMG(this.iImageID2).draw(oSB, this.getPosXE() + CFG.PADD * 4 + this.iPopChangeWidth + this.iDeathsWidth + (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale(this.iImageID, 1.0f)) + ButtonN_Pop_2_PopChangeCost.getLeftFlagWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(this.iImageID2).getHeight() * this.getImageScale(this.iImageID2, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(this.iImageID2).getWidth() * this.getImageScale(this.iImageID2, 1.0f)), (int)((float)IMGManager.getIMG(this.iImageID2).getHeight() * this.getImageScale(this.iImageID2, 1.0f)));
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
            nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            if (this.sDeathsTEXT.length() > 0) {
                nData.add(new ME_Hover_2Type_Text(this.sDeathsTEXT));
                nData.add(new ME_Hover_2Type_Text(this.sDeaths));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (Exception e) {
            this.menuElemHover = null;
        }
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }
}

