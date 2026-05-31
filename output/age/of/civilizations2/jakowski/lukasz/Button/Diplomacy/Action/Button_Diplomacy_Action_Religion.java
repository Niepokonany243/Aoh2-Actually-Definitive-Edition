/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Diplomacy_Action_Religion
extends ButtonM {
    public int religionID = 0;
    private boolean row = false;
    public SparksAnimation sparksAnimation;
    public TextD taxation;
    public TextD goods;
    public TextD investments;
    public TextD research;
    public TextD militaryUpkeep;

    public Button_Diplomacy_Action_Religion(int nReligionID, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false);
        this.sparksAnimation = new SparksAnimation();
        this.religionID = nReligionID;
    }

    public Button_Diplomacy_Action_Religion(int nReligionID, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkBox) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, checkBox, false);
        this.sparksAnimation = new SparksAnimation();
        this.religionID = nReligionID;
        if (CFG.religionManager.getReligion((int)nReligionID).ACCEPTABLE_TAXATION != 0.0f) {
            this.taxation = new TextD((CFG.religionManager.getReligion((int)nReligionID).ACCEPTABLE_TAXATION > 0.0f ? "+" : "") + (int)(CFG.religionManager.getReligion((int)nReligionID).ACCEPTABLE_TAXATION * 100.0f) + "%");
        }
        if (CFG.religionManager.getReligion((int)nReligionID).MIN_GOODS != 0.0f) {
            this.goods = new TextD((CFG.religionManager.getReligion((int)nReligionID).MIN_GOODS > 0.0f ? "+" : "") + (int)(CFG.religionManager.getReligion((int)nReligionID).MIN_GOODS * 100.0f) + "%");
        }
        if (CFG.religionManager.getReligion((int)nReligionID).MIN_INVESTMENTS != 0.0f) {
            this.investments = new TextD((CFG.religionManager.getReligion((int)nReligionID).MIN_INVESTMENTS > 0.0f ? "+" : "") + (int)(CFG.religionManager.getReligion((int)nReligionID).MIN_INVESTMENTS * 100.0f) + "%");
        }
        if (CFG.religionManager.getReligion((int)nReligionID).RESEARCH_COST != 0.0f) {
            this.research = new TextD((CFG.religionManager.getReligion((int)nReligionID).RESEARCH_COST > 0.0f ? "+" : "") + (int)(CFG.religionManager.getReligion((int)nReligionID).RESEARCH_COST * 100.0f) + "%");
        }
        if (CFG.religionManager.getReligion((int)nReligionID).MILITARY_UPKEEP != 0.0f) {
            this.militaryUpkeep = new TextD((CFG.religionManager.getReligion((int)nReligionID).MILITARY_UPKEEP > 0.0f ? "+" : "") + (int)(CFG.religionManager.getReligion((int)nReligionID).MILITARY_UPKEEP * 100.0f) + "%");
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
        if (this.getIsHovered()) {
            oSB.setColor(SparksAnimation.sparksColors2);
            this.sparksAnimation.draw2(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        float scale = (float)IMGManager.getIMG(Images.technology).getHeight() / (float)CFG.religionManager.religionImages.get(this.religionID).getHeight();
        CFG.religionManager.religionImages.get(this.religionID).draw(oSB, this.getPosXE() + (ButtonDiplomacy.iDiploWidth - (int)((float)CFG.religionManager.religionImages.get(this.religionID).getWidth() * scale)) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.religionManager.religionImages.get(this.religionID).getHeight() * scale) / 2 + iTranslateY, (int)((float)CFG.religionManager.religionImages.get(this.religionID).getWidth() * scale), (int)((float)CFG.religionManager.religionImages.get(this.religionID).getHeight() * scale));
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        int pX = this.getPosXE() + this.getWidthE() - CFG.PADD * 2 + iTranslateX;
        int pYI = this.getPosY() + this.getHeightE() / 2 + iTranslateY;
        int pYT = this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 + iTranslateY;
        int img = Images.topGold();
        int imgW = 0;
        int imgH = 0;
        if (this.taxation != null) {
            img = Images.topGold();
            imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
            imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.taxation.text, pX -= this.taxation.textW, pYT, this.getColorE(isActive));
            IMGManager.getIMG(img).draw(oSB, pX += -CFG.PADD - imgW, pYI - imgH / 2, imgW, imgH);
            pX += -CFG.PADD;
        }
        if (this.goods != null) {
            img = Images.goods;
            imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
            imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.goods.text, pX -= this.goods.textW, pYT, this.getColorE(isActive));
            IMGManager.getIMG(img).draw(oSB, pX += -CFG.PADD - imgW, pYI - imgH / 2, imgW, imgH);
            pX += -CFG.PADD;
        }
        if (this.investments != null) {
            img = Images.development;
            imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
            imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.investments.text, pX -= this.investments.textW, pYT, this.getColorE(isActive));
            IMGManager.getIMG(img).draw(oSB, pX += -CFG.PADD - imgW, pYI - imgH / 2, imgW, imgH);
            pX += -CFG.PADD;
        }
        if (this.research != null) {
            img = Images.research;
            imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
            imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.research.text, pX -= this.research.textW, pYT, this.getColorE(isActive));
            IMGManager.getIMG(img).draw(oSB, pX += -CFG.PADD - imgW, pYI - imgH / 2, imgW, imgH);
            pX += -CFG.PADD;
        }
        if (this.militaryUpkeep != null) {
            img = Images.diploArmy;
            imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
            imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.militaryUpkeep.text, pX -= this.militaryUpkeep.textW, pYT, this.getColorE(isActive));
            IMGManager.getIMG(img).draw(oSB, pX += -CFG.PADD - imgW, pYI - imgH / 2, imgW, imgH);
            pX += -CFG.PADD;
        }
    }

    public float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.6f));
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }

    @Override
    public int getCurr() {
        return this.religionID;
    }

    public class TextD {
        public String text;
        public int textW;

        public TextD(String nText) {
            this.text = nText;
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.text);
            this.textW = (int)CFG.glyphLay.width;
        }
    }
}

