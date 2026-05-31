/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ButtonN_ArmyExpertise
extends ButtonM {
    public boolean row = false;
    public int civID;
    public int fontID2 = 0;
    public String sLevel;
    public int iLevelWidth = 0;
    public String sAttack;
    public int iAttackWidth = 0;
    public String sAttackNum;
    public int iAttackNumWidth = 0;
    public String sDefense;
    public int iDefenseWidth = 0;
    public String sDefenseNum;
    public int iDefenseNumWidth = 0;
    public String sTextRight;
    public int iTextRightWidth = 0;

    public ButtonN_ArmyExpertise(int nCivID, int iPosX, int iPosY, int iWidth, int iHeight, String textRight) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        this.civID = nCivID;
        super.init(CFG.lang.get("MilitaryExpertise") + ": ", 0, iPosX, iPosY, iWidth, iHeight, true, true, false, false);
        this.fontID2 = CFG.FONT_REGULAR_SMALL;
        this.sLevel = CFG.core.getCiv((int)this.civID).civGD.armyExpertiseLevel + " / " + GameValues.gvMilitary.MILITARY_EXPERTISE_MAX_LEVEL;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sLevel);
        this.iLevelWidth = (int)CFG.glyphLay.width;
        this.sAttack = CFG.lang.get("Attack") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sAttack);
        this.iAttackWidth = (int)CFG.glyphLay.width;
        this.sAttackNum = "+" + CFG.getPrecision2(CFG.gameAction.getAttackBonusFromMilitaryExpertise(this.civID), 100) + "%";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sAttackNum);
        this.iAttackNumWidth = (int)CFG.glyphLay.width;
        this.sDefense = CFG.lang.get("Defense") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sDefense);
        this.iDefenseWidth = (int)CFG.glyphLay.width;
        this.sDefenseNum = "+" + CFG.getPrecision2(CFG.gameAction.getDefenseBonusFromMilitaryExpertise(this.civID), 100) + "%";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID2), this.sDefenseNum);
        this.iDefenseNumWidth = (int)CFG.glyphLay.width;
        this.sTextRight = textRight;
        if (this.sTextRight.length() > 0) {
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sTextRight);
            this.iTextRightWidth = (int)CFG.glyphLay.width;
        }
    }

    @Override
    public void buildElemHover() {
        this.menuElemHover = Menu_InGame_View_Army.getHoverArmyExpertise(this.civID);
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
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        try {
            IMGManager.getIMG(Images.diploArmyStar).draw(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth / 2 - IMGManager.getIMG(Images.diploArmyStar).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploArmyStar).getHeight() / 2 + iTranslateY);
            oSB.setColor(Color.WHITE);
            int imgDraw = Images.diploArmyStar;
            Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD / 2 + iTranslateY, this.getColorE(isActive));
            Renderer.drawTextWithShadow(oSB, this.fontID, this.sLevel, this.getPosXE() + CFG.PADD + this.getTextWidthU() + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD / 2 + iTranslateY, CFG.COLOR_HOVER_TITLE);
            IMGManager.getIMG(imgDraw).draw(oSB, this.getPosXE() + CFG.PADD * 2 + this.iLevelWidth + this.getTextWidthU() + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD / 2 - (int)((float)IMGManager.getIMG(imgDraw).getHeight() * this.getImageScale2(imgDraw, 1.0f)) + iTranslateY, (int)((float)IMGManager.getIMG(imgDraw).getWidth() * this.getImageScale2(imgDraw, 1.0f)), (int)((float)IMGManager.getIMG(imgDraw).getHeight() * this.getImageScale2(imgDraw, 1.0f)));
            imgDraw = Images.attack;
            Renderer.drawText(oSB, this.fontID2, this.sAttack, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, this.getColorE(isActive));
            Renderer.drawText(oSB, this.fontID2, this.sAttackNum, this.getPosXE() + CFG.PADD + this.iAttackWidth + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_POSITIVE);
            IMGManager.getIMG(imgDraw).draw(oSB, this.getPosXE() + CFG.PADD * 2 + this.iAttackNumWidth + this.iAttackWidth + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(imgDraw).getWidth() * this.getImageScale2(imgDraw, 1.0f)), (int)((float)IMGManager.getIMG(imgDraw).getHeight() * this.getImageScale2(imgDraw, 1.0f)));
            Renderer.drawText(oSB, this.fontID2, this.sDefense, this.getPosXE() + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(Images.attack).getWidth() * this.getImageScale2(Images.attack, 1.0f)) + this.iAttackNumWidth + this.iAttackWidth + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, this.getColorE(isActive));
            Renderer.drawText(oSB, this.fontID2, this.sDefenseNum, this.getPosXE() + CFG.PADD * 3 + this.iDefenseWidth + (int)((float)IMGManager.getIMG(Images.attack).getWidth() * this.getImageScale2(Images.attack, 1.0f)) + this.iAttackNumWidth + this.iAttackWidth + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_POSITIVE);
            imgDraw = Images.defense;
            IMGManager.getIMG(imgDraw).draw(oSB, this.getPosXE() + CFG.PADD * 4 + this.iDefenseNumWidth + this.iDefenseWidth + (int)((float)IMGManager.getIMG(Images.attack).getWidth() * this.getImageScale2(Images.attack, 1.0f)) + this.iAttackNumWidth + this.iAttackWidth + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(imgDraw).getWidth() * this.getImageScale2(imgDraw, 1.0f)), (int)((float)IMGManager.getIMG(imgDraw).getHeight() * this.getImageScale2(imgDraw, 1.0f)));
            if (this.iTextRightWidth > 0) {
                IMGManager.getIMG(Images.diploArmyStar).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - IMGManager.getIMG(Images.diploArmyStar).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploArmyStar).getHeight() / 2 + iTranslateY);
                Renderer.drawTextWithShadow(oSB, this.fontID, this.sTextRight, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - IMGManager.getIMG(Images.diploArmyStar).getWidth() - this.iTextRightWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public float getImageScale2(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    public float getImageScale(int nImageID, float nTextScale) {
        return 1.0f;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.525f));
    }

    @Override
    public void setMin(int iMin) {
        super.setMin(iMin);
        this.sTextRight = "" + CFG.core.armyExpertisePointsLeft(this.civID);
        if (this.sTextRight.length() > 0) {
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sTextRight);
            this.iTextRightWidth = (int)CFG.glyphLay.width;
        }
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }
}

