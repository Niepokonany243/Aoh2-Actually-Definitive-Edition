
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Diplomacy_AdministrationPolicy
extends ButtonM {
    public boolean backAnimation = false;
    public int policyID;
    public boolean row = false;
    public String sCost;
    public int iCostWidth;
    public static float ICON_SCALE = 1.0f;
    public TextD taxation;
    public TextD goods;
    public TextD investments;
    public TextD research;
    public TextD administration;
    public TextD incomeProduction;
    public TextD militaryUpkeep;
    public float imgScale = 1.0f;
    public int civID;

    public Button_Diplomacy_AdministrationPolicy(int nPolicyID, int iPosX, int iPosY, int iWidth, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(CFG.lang.get(GameValues.gvAdministrationPolicy.POLICY_NAME[nPolicyID]), 0, iPosX, iPosY, iWidth, CFG.BUTTON_H, isClickable, true, true, false);
        this.policyID = nPolicyID;
        this.imgScale = GameValues.gvAdministrationPolicy.POLICY_ICON_SCALE[this.policyID];
        this.civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        this.taxation = new TextD((GameValues.gvAdministrationPolicy.POLICY_ACCEPTABLE_TAXATION[this.policyID] > 0.0f ? "+" : "") + (int)(GameValues.gvAdministrationPolicy.POLICY_ACCEPTABLE_TAXATION[this.policyID] * 100.0f) + "%");
        this.goods = new TextD((GameValues.gvAdministrationPolicy.POLICY_MIN_GOODS[this.policyID] > 0.0f ? "+" : "") + (int)(GameValues.gvAdministrationPolicy.POLICY_MIN_GOODS[this.policyID] * 100.0f) + "%");
        this.investments = new TextD((GameValues.gvAdministrationPolicy.POLICY_MIN_INVESTMENTS[this.policyID] > 0.0f ? "+" : "") + (int)(GameValues.gvAdministrationPolicy.POLICY_MIN_INVESTMENTS[this.policyID] * 100.0f) + "%");
        this.research = new TextD((GameValues.gvAdministrationPolicy.POLICY_RESEARCH_COST[this.policyID] > 0.0f ? "+" : "") + (int)(GameValues.gvAdministrationPolicy.POLICY_RESEARCH_COST[this.policyID] * 100.0f) + "%");
        this.administration = new TextD((GameValues.gvAdministrationPolicy.POLICY_ADMINISTRATION_COST[this.policyID] > 0.0f ? "+" : "") + (int)(GameValues.gvAdministrationPolicy.POLICY_ADMINISTRATION_COST[this.policyID] * 100.0f) + "%");
        this.incomeProduction = new TextD((GameValues.gvAdministrationPolicy.POLICY_INCOME_PRODUCTION[this.policyID] > 0.0f ? "+" : "") + (int)(GameValues.gvAdministrationPolicy.POLICY_INCOME_PRODUCTION[this.policyID] * 100.0f) + "%");
        this.militaryUpkeep = new TextD((GameValues.gvAdministrationPolicy.POLICY_MILITARY_UPKEEP[this.policyID] > 0.0f ? "+" : "") + (int)(GameValues.gvAdministrationPolicy.POLICY_MILITARY_UPKEEP[this.policyID] * 100.0f) + "%");
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (Button_Diplomacy_AdministrationPolicy.this.getCheckboxSt()) {
                        oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.2f));
                        IMGManager.getIMG(Images.patternSquareTiny).draw2O(oSB, Button_Diplomacy_AdministrationPolicy.this.getPosXE() + iTranslateX, Button_Diplomacy_AdministrationPolicy.this.getPosY() - IMGManager.getIMG(Images.patternSquareTiny).getHeight() + 1 + iTranslateY, ButtonDiplomacy.iDiploWidth, Button_Diplomacy_AdministrationPolicy.this.getHeightE() - 2, true, false);
                        oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.15f));
                        IMGManager.getIMG(Images.gradientFull).draw(oSB, Button_Diplomacy_AdministrationPolicy.this.getPosXE() + iTranslateX, Button_Diplomacy_AdministrationPolicy.this.getPosY() + 1 + iTranslateY, ButtonDiplomacy.iDiploWidth, Button_Diplomacy_AdministrationPolicy.this.getHeightE() - 2);
                        IMGManager.getIMG(Images.gradientXY).draw(oSB, Button_Diplomacy_AdministrationPolicy.this.getPosXE() + iTranslateX, Button_Diplomacy_AdministrationPolicy.this.getPosY() + 1 + iTranslateY, ButtonDiplomacy.iDiploWidth, Button_Diplomacy_AdministrationPolicy.this.getHeightE() - 2);
                        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.4f));
                        IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Diplomacy_AdministrationPolicy.this.getPosXE() + iTranslateX, Button_Diplomacy_AdministrationPolicy.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, ButtonDiplomacy.iDiploWidth, Button_Diplomacy_AdministrationPolicy.this.getHeightE() / 4, false, false);
                        IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Diplomacy_AdministrationPolicy.this.getPosXE() + iTranslateX, Button_Diplomacy_AdministrationPolicy.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + Button_Diplomacy_AdministrationPolicy.this.getHeightE() - 1 + iTranslateY - Button_Diplomacy_AdministrationPolicy.this.getHeightE() / 4, ButtonDiplomacy.iDiploWidth, Button_Diplomacy_AdministrationPolicy.this.getHeightE() / 4, false, true);
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
        if (this.getCurr() == CFG.core.getCiv((int)this.civID).civGD.policyID) {
            oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.125f));
        } else {
            oSB.setColor(new Color(CFG.COLOR_NEGATIVE_1.r, CFG.COLOR_NEGATIVE_1.g, CFG.COLOR_NEGATIVE_1.b, 0.025f));
        }
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        int govW = (int)((float)IMGManager.getIMG(Images.gov).getWidth() * this.imgScale);
        int govH = (int)((float)IMGManager.getIMG(Images.gov).getHeight() * this.imgScale);
        IMGManager.getIMG(Images.gov).draw(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth / 2 - govW / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - govH / 2 + iTranslateY, govW, govH);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + ButtonDiplomacy.iDiploWidth + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY, this.getColorE(isActive));
        int pX = this.getPosXE() + ButtonDiplomacy.iDiploWidth + CFG.PADD * 2 + iTranslateX;
        int pYT = this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY;
        int pYI = this.getPosY() + this.getHeightE() / 2 + CFG.PADD + this.getTextHeight() / 2 + iTranslateY;
        int pYT2 = this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY;
        int pYI2 = this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() / 2 + iTranslateY;
        int img = Images.topGold();
        int imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        int imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX, pYI - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.taxation.text, pX += imgW + CFG.PADD, pYT, this.getColorE(isActive));
        img = Images.goods;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX += this.taxation.textW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.goods.text, pX += imgW + CFG.PADD, pYT, this.getColorE(isActive));
        img = Images.development;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX += this.goods.textW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.investments.text, pX += imgW + CFG.PADD, pYT, this.getColorE(isActive));
        img = Images.research;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX += this.investments.textW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.research.text, pX += imgW + CFG.PADD, pYT, this.getColorE(isActive));
        img = Images.administration;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX += this.research.textW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.administration.text, pX += imgW + CFG.PADD, pYT, this.getColorE(isActive));
        img = Images.economy;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX += this.administration.textW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.incomeProduction.text, pX += imgW + CFG.PADD, pYT, this.getColorE(isActive));
        img = Images.diploArmy;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX += this.incomeProduction.textW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.militaryUpkeep.text, pX += imgW + CFG.PADD, pYT, this.getColorE(isActive));
        pX += this.militaryUpkeep.textW + CFG.PADD;
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
    public void buildElemHover() {
        this.menuElemHover = CFG.ideologiesMgr.getHover_AdministrationPolicy(this.policyID, -1);
    }

    @Override
    public int getCurr() {
        return this.policyID;
    }

    public class TextD {
        public String text;
        public int textW;

        public TextD(String nText) {
            this.text = nText;
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.text);
            this.textW = (int)CFG.glyphLay.width;
        }
    }
}

