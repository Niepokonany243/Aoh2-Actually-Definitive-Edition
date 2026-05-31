
package age.of.civilizations2.jakowski.lukasz.Button.GameN;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class ButtonN_Diseases
extends ButtonM {
    public long lTime = 0L;
    public float fAlphaMod = 0.0f;
    public boolean backAnimation = false;
    public static final float TEXT_COST_SCALE = 0.7f;
    public static final float TEXT_MOVEMENT_COST_SCALE = 0.7f;
    public boolean row = false;
    private String sDeathsTEXT;
    private int iDeathsTEXTWidth;
    private String sDeaths;
    private int iDeathsWidth;
    private Color relationColor;
    public SparksAnimation sparksAnimation = new SparksAnimation();

    public ButtonN_Diseases(int iPosX, int iPosY, int iWidth) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(CFG.lang.get("Diseases"), 0, iPosX, iPosY, iWidth, CFG.BUTTON_H, true, true, false, false);
        int tempDeaths = 0;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            tempDeaths += CFG.core.getProv((int)i).provGD.iPlaguesDeaths;
        }
        this.sDeaths = CFG.getNumberWthSpaces("" + tempDeaths);
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sDeaths);
        this.iDeathsWidth = (int)CFG.glyphLay.width;
        this.sDeathsTEXT = CFG.lang.get("Deaths") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sDeathsTEXT);
        this.iDeathsTEXTWidth = (int)CFG.glyphLay.width;
        this.relationColor = tempDeaths > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL2;
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (ButtonN_Diseases.this.getCheckboxSt()) {
                        oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.2f));
                        IMGManager.getIMG(Images.patternSquareTiny).draw2O(oSB, ButtonN_Diseases.this.getPosXE() + iTranslateX, ButtonN_Diseases.this.getPosY() - IMGManager.getIMG(Images.patternSquareTiny).getHeight() + 1 + iTranslateY, ButtonDiplomacy.iDiploWidth, ButtonN_Diseases.this.getHeightE() - 2, true, false);
                        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
                        IMGManager.getIMG(Images.gradient).drawO(oSB, ButtonN_Diseases.this.getPosXE() + iTranslateX, ButtonN_Diseases.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, ButtonDiplomacy.iDiploWidth, ButtonN_Diseases.this.getHeightE() / 4, false, false);
                        IMGManager.getIMG(Images.gradient).drawO(oSB, ButtonN_Diseases.this.getPosXE() + iTranslateX, ButtonN_Diseases.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + ButtonN_Diseases.this.getHeightE() - 1 + iTranslateY - ButtonN_Diseases.this.getHeightE() / 4, ButtonDiplomacy.iDiploWidth, ButtonN_Diseases.this.getHeightE() / 4, false, true);
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

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), false, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
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
        IMGManager.getIMG(Images.disease).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth / 2 - IMGManager.getIMG(Images.disease).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.disease).getHeight() / 2 + iTranslateY);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.pop).draw(oSB, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + this.iDeathsWidth + this.iDeathsTEXTWidth + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop, 1.0f)));
        IMGManager.getIMG(Images.disease).draw(oSB, this.getPosXE() + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.disease).getWidth() * this.getImageScale(Images.disease, 1.0f)) + ButtonDiplomacy.iDiploWidth + this.iDeathsWidth + this.iDeathsTEXTWidth + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(Images.disease).getHeight() * this.getImageScale(Images.disease, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.disease).getWidth() * this.getImageScale(Images.disease, 1.0f)), (int)((float)IMGManager.getIMG(Images.disease).getHeight() * this.getImageScale(Images.disease, 1.0f)));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.getTextE(), this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sDeathsTEXT, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sDeaths, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + this.iDeathsTEXTWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, this.relationColor);
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
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Diseases"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image_Big(Images.disease, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Deaths") + ": "));
        nData.add(new ME_Hover_2Type_Text_Big(this.sDeaths, this.relationColor));
        nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }
}

