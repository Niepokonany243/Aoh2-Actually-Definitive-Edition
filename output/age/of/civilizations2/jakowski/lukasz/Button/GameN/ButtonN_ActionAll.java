
package age.of.civilizations2.jakowski.lukasz.Button.GameN;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class ButtonN_ActionAll
extends ButtonM {
    public long lTime = 0L;
    public float fAlphaMod = 0.0f;
    public boolean backAnimation = false;
    public boolean row = true;
    private int iCivID = 0;
    public String sProvincesText;
    public int iProvincesTextWidth;
    public String sProvinceNumText;
    public int iProvincesNumTextWidth;
    public String sCostText;
    public int iCostTextWidth;
    public String sCostText2;
    public int iCostText2Width;
    public int imgCost2;
    public Color oColor;
    public int iImageID;
    public Color textColor;
    public int fontID2 = 0;
    public Color costColor;
    public SparksAnimation sparksAnimation = new SparksAnimation();

    public ButtonN_ActionAll(Color nColor, String sText, int nCivID, String sTextLeft, String nPop, String nCost, String nCost2, int imgCost2, Color costColor, int iImageID, Color textColor, int iPosX, int iPosY, int iWidth, int iHeight) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        this.fontID2 = CFG.FONT_REGULAR_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, iHeight, true, true, false, false);
        this.iCivID = nCivID;
        this.oColor = nColor;
        this.iImageID = iImageID;
        this.textColor = textColor;
        this.costColor = costColor;
        this.sProvinceNumText = nPop;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sProvinceNumText);
        this.iProvincesNumTextWidth = (int)CFG.glyphLay.width;
        this.sProvincesText = sTextLeft;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sProvincesText);
        this.iProvincesTextWidth = (int)CFG.glyphLay.width;
        this.sCostText = nCost;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sCostText);
        this.iCostTextWidth = (int)CFG.glyphLay.width;
        this.sCostText2 = nCost2;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sCostText2);
        this.iCostText2Width = (int)CFG.glyphLay.width;
        this.imgCost2 = imgCost2;
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (ButtonN_ActionAll.this.getCheckboxSt()) {
                        oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.2f));
                        IMGManager.getIMG(Images.patternSquareTiny).draw2O(oSB, ButtonN_ActionAll.this.getPosXE() + iTranslateX, ButtonN_ActionAll.this.getPosY() - IMGManager.getIMG(Images.patternSquareTiny).getHeight() + 1 + iTranslateY, ButtonN_ActionAll.getLeftFlagWidth(), ButtonN_ActionAll.this.getHeightE() - 2, true, false);
                        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
                        IMGManager.getIMG(Images.gradient).drawO(oSB, ButtonN_ActionAll.this.getPosXE() + iTranslateX, ButtonN_ActionAll.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, ButtonN_ActionAll.getLeftFlagWidth(), ButtonN_ActionAll.this.getHeightE() / 4, false, false);
                        IMGManager.getIMG(Images.gradient).drawO(oSB, ButtonN_ActionAll.this.getPosXE() + iTranslateX, ButtonN_ActionAll.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + ButtonN_ActionAll.this.getHeightE() - 1 + iTranslateY - ButtonN_ActionAll.this.getHeightE() / 4, ButtonN_ActionAll.getLeftFlagWidth(), ButtonN_ActionAll.this.getHeightE() / 4, false, true);
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
        return IMGManager.getIMG(Images.flagRect2).getWidth() + ButtonN_ActionAll.getLeftFlagPadding() * 2;
    }

    public static int getLeftFlagPadding() {
        return CFG.PADD * 2;
    }

    public static int getLeftFlagHeight() {
        return IMGManager.getIMG(Images.flagRect2).getHeight();
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRGB(0.0425f));
        IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, ButtonN_ActionAll.getLeftFlagWidth(), this.getHeightE());
        oSB.setColor(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRGB(0.08f));
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, ButtonN_ActionAll.getLeftFlagWidth(), this.getHeightE());
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, ButtonN_ActionAll.getLeftFlagWidth(), this.getHeightE(), false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + ButtonN_ActionAll.getLeftFlagWidth() - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), false, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + ButtonN_ActionAll.getLeftFlagWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + ButtonN_ActionAll.getLeftFlagWidth() - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), false, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + ButtonN_ActionAll.getLeftFlagWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
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
        IMGManager.getIMG(this.iImageID).draw(oSB, this.getPosXE() + ButtonN_ActionAll.getLeftFlagWidth() / 2 - IMGManager.getIMG(this.iImageID).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(this.iImageID).getHeight() / 2 + iTranslateY);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(this.iImageID).drawO(oSB, this.getPosXE() + ButtonN_ActionAll.getLeftFlagWidth() + (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * this.getImageScale(Images.provinces, 1.0f)) + this.iProvincesNumTextWidth + CFG.PADD * 3 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale(this.iImageID, 1.0f)) / 2 - IMGManager.getIMG(this.iImageID).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale(this.iImageID, 1.0f)), (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale(this.iImageID, 1.0f)));
        IMGManager.getIMG(Images.provinces).drawO(oSB, this.getPosXE() + ButtonN_ActionAll.getLeftFlagWidth() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(Images.provinces).getHeight() * this.getImageScale(Images.provinces, 1.0f)) / 2 - IMGManager.getIMG(Images.provinces).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * this.getImageScale(Images.provinces, 1.0f)), (int)((float)IMGManager.getIMG(Images.provinces).getHeight() * this.getImageScale(Images.provinces, 1.0f)));
        IMGManager.getIMG(Images.topGold()).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold(), 1.0f)) / 2 - IMGManager.getIMG(Images.topGold()).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), 1.0f)), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold(), 1.0f)));
        if (this.sCostText2.length() > 0) {
            IMGManager.getIMG(this.imgCost2).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - (int)((float)IMGManager.getIMG(this.imgCost2).getWidth() * this.getImageScale(this.imgCost2, 1.0f)) - this.iCostTextWidth - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(this.imgCost2).getHeight() * this.getImageScale(this.imgCost2, 1.0f)) / 2 - IMGManager.getIMG(this.imgCost2).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(this.imgCost2).getWidth() * this.getImageScale(this.imgCost2, 1.0f)), (int)((float)IMGManager.getIMG(this.imgCost2).getHeight() * this.getImageScale(this.imgCost2, 1.0f)));
        }
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + ButtonN_ActionAll.getLeftFlagWidth() + (this.getWidthE() - ButtonN_ActionAll.getLeftFlagWidth()) / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID2, this.sProvinceNumText, this.getPosXE() + ButtonN_ActionAll.getLeftFlagWidth() + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.provinces).getWidth() * this.getImageScale(Images.provinces, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, this.textColor);
        Renderer.drawTextWithShadow(oSB, this.fontID2, this.sCostText, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), 1.0f)) - CFG.PADD - this.iCostTextWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_GOLD);
        Renderer.drawTextWithShadow(oSB, this.fontID2, this.sCostText2, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), 1.0f)) - (int)((float)IMGManager.getIMG(this.imgCost2).getWidth() * this.getImageScale(this.imgCost2, 1.0f)) - CFG.PADD * 3 - this.iCostTextWidth - this.iCostText2Width + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, this.costColor);
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
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), Colors.COLOR_TEXT_GOLD));
            nData.add(new ME_Hover_2Type_Image_Big(this.iImageID, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(this.sProvincesText));
            nData.add(new ME_Hover_2Type_Text(this.sProvinceNumText, CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
            nData.add(new ME_Hover_2Type_Text(this.sCostText, CFG.COLOR_GOLD));
            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            if (this.imgCost2 == Images.topMovementPoints) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ": "));
            } else if (this.imgCost2 == Images.topDiplomacyPoints) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": "));
            }
            nData.add(new ME_Hover_2Type_Text(this.sCostText2, this.costColor));
            nData.add(new ME_Hover_2Type_Image(this.imgCost2, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
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

