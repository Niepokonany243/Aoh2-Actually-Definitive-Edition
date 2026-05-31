
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextD;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_SpreadPropaganda
extends ButtonM {
    public long lTime = 0L;
    public float fAlphaMod = 0.0f;
    public boolean backAnimation = false;
    public int iImageID;
    public boolean row = false;
    public static float ICON_SCALE = 1.0f;
    public SparksAnimation sparksAnimation = new SparksAnimation();
    public int provinceID;
    public TextD population;
    public TextD happiness;
    public TextD revRisk;
    public TextD costGold;
    public TextD costDiplomacy;

    public Button_SpreadPropaganda(String sText, int nImageID, int iPosX, int iPosY, int iWidth, int provinceID, int costGold, int costDiplomacy) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(CFG.lang.get(sText), 0, iPosX, iPosY, iWidth, CFG.BUTTON_H, true, true, true, false);
        this.iImageID = nImageID;
        this.provinceID = provinceID;
        this.population = new TextD(CFG.getNumberWthSpaces("" + CFG.core.getProv(provinceID).getPop().getPops()), CFG.FONT_REGULAR_SMALL);
        this.happiness = new TextD(CFG.getPrecision2(CFG.core.getProv(provinceID).getHappi() * 100.0f, 1) + "%", CFG.FONT_REGULAR_SMALL);
        this.revRisk = new TextD(CFG.getPrecision2(CFG.core.getProv(provinceID).getRevRisk() * 100.0f, 1) + "%", CFG.FONT_REGULAR_SMALL);
        this.costGold = new TextD("+" + CFG.getNumberWthSpaces("" + costGold), CFG.FONT_BOLD_SMALL);
        this.costDiplomacy = new TextD("+5.0", CFG.FONT_BOLD_SMALL);
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (Button_SpreadPropaganda.this.getCheckboxSt()) {
                        oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.2f));
                        IMGManager.getIMG(Images.patternSquareTiny).draw2O(oSB, Button_SpreadPropaganda.this.getPosXE() + iTranslateX, Button_SpreadPropaganda.this.getPosY() - IMGManager.getIMG(Images.patternSquareTiny).getHeight() + 1 + iTranslateY, ButtonDiplomacy.iDiploWidth, Button_SpreadPropaganda.this.getHeightE() - 2, true, false);
                        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
                        IMGManager.getIMG(Images.gradient).drawO(oSB, Button_SpreadPropaganda.this.getPosXE() + iTranslateX, Button_SpreadPropaganda.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, ButtonDiplomacy.iDiploWidth, Button_SpreadPropaganda.this.getHeightE() / 4, false, false);
                        IMGManager.getIMG(Images.gradient).drawO(oSB, Button_SpreadPropaganda.this.getPosXE() + iTranslateX, Button_SpreadPropaganda.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + Button_SpreadPropaganda.this.getHeightE() - 1 + iTranslateY - Button_SpreadPropaganda.this.getHeightE() / 4, ButtonDiplomacy.iDiploWidth, Button_SpreadPropaganda.this.getHeightE() / 4, false, true);
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
        IMGManager.getIMG(this.iImageID).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth / 2 - IMGManager.getIMG(this.iImageID).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(this.iImageID).getHeight() / 2 + iTranslateY);
        oSB.setColor(Color.WHITE);
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getProv(this.provinceID).getCivId());
        int img = Images.provinces;
        int imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        int imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, this.getPosXE() + CFG.PADD * 2 + ButtonDiplomacy.iDiploWidth + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 - imgH / 2 - CFG.PADD + iTranslateY, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD * 3 + imgW + ButtonDiplomacy.iDiploWidth + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD + iTranslateY, this.getColorE(isActive));
        int pX = this.getPosXE() + CFG.PADD * 2 + ButtonDiplomacy.iDiploWidth + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX;
        int pYT = this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY;
        int pYI = this.getPosY() + this.getHeightE() / 2 + CFG.PADD + this.getTextHeight() / 2 + iTranslateY;
        img = Images.pop;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX, pYI - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.population.text, pX += imgW + CFG.PADD, pYT, CFG.COLOR_POPULATION);
        img = Images.happiness;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX += this.population.textW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.happiness.text, pX += imgW + CFG.PADD, pYT, CFG.COLOR_TEXT_HAPPINESS_ACTIVE);
        img = Images.diploRevolution;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX += this.happiness.textW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.revRisk.text, pX += imgW + CFG.PADD, pYT, CFG.COLOR_REVOLUTION_MIN);
        pX += this.revRisk.textW + CFG.PADD;
        img = Images.topDiplomacyPoints;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - imgW + iTranslateX, pYI - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.costDiplomacy.text, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - imgW - this.costDiplomacy.textW + iTranslateX, pYT, CFG.COLOR_DIPLOMACY_POINTS);
        img = Images.topGold();
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - imgW + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() / 2 + iTranslateY - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.costGold.text, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - imgW - this.costGold.textW + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY, CFG.COLOR_GOLD);
    }

    public float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    public float getImageScale(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.525f));
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }

    @Override
    public int getCurr() {
        return this.provinceID;
    }
}


