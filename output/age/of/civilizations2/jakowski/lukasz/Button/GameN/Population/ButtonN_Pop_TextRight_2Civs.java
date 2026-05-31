
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
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class ButtonN_Pop_TextRight_2Civs
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
    public SparksAnimation sparksAnimation = new SparksAnimation();
    public String sTime;
    public int iTimeWidth;
    public int imageRight = 0;
    public int civID2;

    public ButtonN_Pop_TextRight_2Civs(Color nColor, String sText, int nCivID, String sTextLeft, String nPop, int iImageID, Color textColor, int iPosX, int iPosY, int iWidth, String textRight, int imageRight, int civID2) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        this.fontID2 = CFG.FONT_BOLD_SMALL;
        this.civID2 = civID2;
        super.init(sText, 0, iPosX, iPosY, iWidth, CFG.BUTTON_H, true, true, false, false);
        this.iCivID = nCivID;
        this.oColor = nColor;
        this.iImageID = iImageID;
        this.textColor = textColor;
        this.sDeaths = nPop;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sDeaths);
        this.iDeathsWidth = (int)CFG.glyphLay.width;
        this.sDeathsTEXT = sTextLeft;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sDeathsTEXT);
        this.iDeathsTEXTWidth = (int)CFG.glyphLay.width;
        this.imageRight = imageRight;
        this.sTime = textRight;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sTime);
        this.iTimeWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (ButtonN_Pop_TextRight_2Civs.this.getCheckboxSt()) {
                        oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.2f));
                        IMGManager.getIMG(Images.patternSquareTiny).draw2O(oSB, ButtonN_Pop_TextRight_2Civs.this.getPosXE() + iTranslateX, ButtonN_Pop_TextRight_2Civs.this.getPosY() - IMGManager.getIMG(Images.patternSquareTiny).getHeight() + 1 + iTranslateY, ButtonN_Pop_TextRight_2Civs.getLeftFlagWidth(), ButtonN_Pop_TextRight_2Civs.this.getHeightE() - 2, true, false);
                        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
                        IMGManager.getIMG(Images.gradient).drawO(oSB, ButtonN_Pop_TextRight_2Civs.this.getPosXE() + iTranslateX, ButtonN_Pop_TextRight_2Civs.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, ButtonN_Pop_TextRight_2Civs.getLeftFlagWidth(), ButtonN_Pop_TextRight_2Civs.this.getHeightE() / 4, false, false);
                        IMGManager.getIMG(Images.gradient).drawO(oSB, ButtonN_Pop_TextRight_2Civs.this.getPosXE() + iTranslateX, ButtonN_Pop_TextRight_2Civs.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + ButtonN_Pop_TextRight_2Civs.this.getHeightE() - 1 + iTranslateY - ButtonN_Pop_TextRight_2Civs.this.getHeightE() / 4, ButtonN_Pop_TextRight_2Civs.getLeftFlagWidth(), ButtonN_Pop_TextRight_2Civs.this.getHeightE() / 4, false, true);
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
        return IMGManager.getIMG(Images.flagRect2).getWidth() * 2 + CFG.PADD + ButtonN_Pop_TextRight_2Civs.getLeftFlagPadding() * 2;
    }

    public static int getLeftFlagPadding() {
        return CFG.PADD;
    }

    public static int getLeftFlagHeight() {
        return IMGManager.getIMG(Images.flagRect2).getHeight();
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(this.oColor.r, this.oColor.g, this.oColor.b, 0.06f));
        IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, ButtonN_Pop_TextRight_2Civs.getLeftFlagWidth(), this.getHeightE());
        oSB.setColor(new Color(this.oColor.r, this.oColor.g, this.oColor.b, 0.085f));
        IMGManager.getIMG(Images.patternSquareTiny).draw2(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, ButtonN_Pop_TextRight_2Civs.getLeftFlagWidth(), this.getHeightE(), true, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + ButtonN_Pop_TextRight_2Civs.getLeftFlagWidth() - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), false, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + ButtonN_Pop_TextRight_2Civs.getLeftFlagWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
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
        if (this.getIsHovered()) {
            oSB.setColor(SparksAnimation.sparksColors2);
            this.sparksAnimation.draw2(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
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
        Core.drawFlagRect(oSB, this.getPosXE() + ButtonN_Pop_TextRight_2Civs.getLeftFlagPadding() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - ButtonN_Pop_TextRight_2Civs.getLeftFlagHeight() / 2 + iTranslateY, this.iCivID);
        Core.drawFlagRect(oSB, this.getPosXE() + ButtonN_Pop_TextRight_2Civs.getLeftFlagPadding() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - ButtonN_Pop_TextRight_2Civs.getLeftFlagHeight() / 2 + iTranslateY, this.civID2);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(this.iImageID).draw(oSB, this.getPosXE() + CFG.PADD + ButtonN_Pop_TextRight_2Civs.getLeftFlagWidth() + this.iDeathsWidth + this.iDeathsTEXTWidth + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale(this.iImageID, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale(this.iImageID, 1.0f)), (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale(this.iImageID, 1.0f)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD + ButtonN_Pop_TextRight_2Civs.getLeftFlagWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() * 1.0f) - CFG.PADD / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID2, this.sDeathsTEXT, this.getPosXE() + CFG.PADD + ButtonN_Pop_TextRight_2Civs.getLeftFlagWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
        Renderer.drawTextWithShadow(oSB, this.fontID2, this.sDeaths, this.getPosXE() + CFG.PADD + ButtonN_Pop_TextRight_2Civs.getLeftFlagWidth() + this.iDeathsTEXTWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, this.textColor);
        IMGManager.getIMG(this.imageRight).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(this.imageRight).getWidth() * this.getImageScale(this.imageRight, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(this.imageRight).getHeight() * this.getImageScale(this.imageRight, 1.0f) / 2.0f) + iTranslateY, (int)((float)IMGManager.getIMG(this.imageRight).getWidth() * this.getImageScale(this.imageRight, 1.0f)), (int)((float)IMGManager.getIMG(this.imageRight).getHeight() * this.getImageScale(this.imageRight, 1.0f)));
        Renderer.drawTextWithShadow(oSB, this.fontID2, this.sTime, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iTimeWidth - (int)((float)IMGManager.getIMG(this.imageRight).getWidth() * this.getImageScale(this.imageRight, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
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

    @Override
    public void setMin(int iMin) {
        this.sDeaths = CFG.getNumberWthSpaces("" + iMin);
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sDeaths);
        this.iDeathsWidth = (int)CFG.glyphLay.width;
    }
}

