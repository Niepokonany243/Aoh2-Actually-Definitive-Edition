
package age.of.civilizations2.jakowski.lukasz.Button.GameN;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class ButtonN_Civs2
extends ButtonM {
    public boolean row = false;
    private int iCivRight;
    private int iCivLeft;
    public TextValue sProvincesValue_Left;
    public TextValue sProvincesValue_Right;
    public TextValue sPopulation;
    public TextValue sPopulationValue_Left;
    public TextValue sPopulationValue_Right;
    public TextValue sEconomy;
    public TextValue sEconomyValue_Left;
    public TextValue sEconomyValue_Right;
    public TextValue sName_Left;
    public TextValue sName_Right;
    public TextValue sTechValue_Left;
    public TextValue sTechValue_Right;
    public TextValue sReligion_Left;
    public TextValue sReligion_Right;
    public TextValue sAttackValue_Left;
    public TextValue sAttackValue_Right;
    public TextValue sDefense;
    public TextValue sDefenseValue_Left;
    public TextValue sDefenseValue_Right;
    public SparksAnimation sparksAnimation = new SparksAnimation();

    public ButtonN_Civs2(int nCivRight, int nCivLeft, int iPosX, int iPosY, int iWidth) {
        this.fontID = CFG.FONT_REGULAR_SMALL;
        super.init(CFG.lang.get("Provinces"), 0, iPosX, iPosY, iWidth, Math.max(CFG.BUTTON_H, CFG.PADD * 2 + CFG.TEXT_HEIGHT_DEFAULT * 4 + this.textPadding() * 3), true, true, false, false);
        this.iCivRight = nCivRight;
        this.iCivLeft = nCivLeft;
        this.sName_Left = new TextValue(CFG.core.getCiv(this.iCivLeft).getCivName(), CFG.FONT_BOLD_SMALL);
        this.sName_Right = new TextValue(CFG.core.getCiv(this.iCivRight).getCivName(), CFG.FONT_BOLD_SMALL);
        this.sProvincesValue_Left = new TextValue(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivLeft).getNumOfProvs()), CFG.FONT_REGULAR_SMALL);
        this.sProvincesValue_Right = new TextValue(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivRight).getNumOfProvs()), CFG.FONT_REGULAR_SMALL);
        this.sPopulation = new TextValue(CFG.lang.get("Population"));
        this.sPopulationValue_Left = new TextValue(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivLeft).countPop()), CFG.FONT_REGULAR_SMALL);
        this.sPopulationValue_Right = new TextValue(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivRight).countPop()), CFG.FONT_REGULAR_SMALL);
        this.sEconomy = new TextValue(CFG.lang.get("Economy"));
        this.sEconomyValue_Left = new TextValue(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivLeft).countEco()), CFG.FONT_REGULAR_SMALL);
        this.sEconomyValue_Right = new TextValue(CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivRight).countEco()), CFG.FONT_REGULAR_SMALL);
        this.sTechValue_Left = new TextValue("" + CFG.getPrecision2(CFG.core.getCiv(this.iCivLeft).getTechLevel(), 100), CFG.FONT_REGULAR_SMALL);
        this.sTechValue_Right = new TextValue("" + CFG.getPrecision2(CFG.core.getCiv(this.iCivRight).getTechLevel(), 100), CFG.FONT_REGULAR_SMALL);
        this.sReligion_Left = new TextValue("" + CFG.religionManager.getReligion((int)CFG.core.getCiv((int)this.iCivLeft).getReligionID()).Name, CFG.FONT_REGULAR_SMALL);
        this.sReligion_Right = new TextValue("" + CFG.religionManager.getReligion((int)CFG.core.getCiv((int)this.iCivRight).getReligionID()).Name, CFG.FONT_REGULAR_SMALL);
        this.sAttackValue_Left = new TextValue(CFG.getPrecision2(CFG.gameAction.getAttackersBonusFromTechnology(this.iCivLeft), 1) + "%", CFG.FONT_REGULAR_SMALL);
        this.sAttackValue_Right = new TextValue(CFG.getPrecision2(CFG.gameAction.getAttackersBonusFromTechnology(this.iCivRight), 1) + "%", CFG.FONT_REGULAR_SMALL);
        this.sDefense = new TextValue(CFG.lang.get("Attack"));
        this.sDefenseValue_Left = new TextValue(CFG.getPrecision2(CFG.gameAction.getDefenseBonusFromTechnology(this.iCivLeft), 1) + "%", CFG.FONT_REGULAR_SMALL);
        this.sDefenseValue_Right = new TextValue(CFG.getPrecision2(CFG.gameAction.getDefenseBonusFromTechnology(this.iCivRight), 1) + "%", CFG.FONT_REGULAR_SMALL);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + ButtonN_Civs2.flagWidthPadding() - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - ButtonN_Civs2.flagWidthPadding() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), true, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + ButtonN_Civs2.flagWidthPadding() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getWidthE() - ButtonN_Civs2.flagWidthPadding() - 1 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        if (this.row) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.2f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(Colors.COLOR_GRADIENT_OVER_BLUE.r, Colors.COLOR_GRADIENT_OVER_BLUE.g, Colors.COLOR_GRADIENT_OVER_BLUE.b, 0.5f));
            IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), false, true);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.35f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.85f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.35f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.3f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(Colors.COLOR_GRADIENT_OVER_BLUE.r, Colors.COLOR_GRADIENT_OVER_BLUE.g, Colors.COLOR_GRADIENT_OVER_BLUE.b, 0.75f));
            IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), false, true);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.2f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.85f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.85f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
        }
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.45f));
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), false, true);
        oSB.setColor(SparksAnimation.sparksColors);
        this.sparksAnimation.draw2(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(Color.WHITE);
    }

    public static int flagPadding() {
        return CFG.PADD * 2;
    }

    public static int flagWidth() {
        return IMGManager.getIMG(Images.flagDiplomacyOver).getWidth();
    }

    public static int flagWidthPadding() {
        return IMGManager.getIMG(Images.flagDiplomacyOver).getWidth() + ButtonN_Civs2.flagPadding() * 2;
    }

    public static int flagHeight() {
        return IMGManager.getIMG(Images.flagDiplomacyOver).getHeight();
    }

    public int textPadding() {
        return CFG.PADD * 2;
    }

    public int topPadding() {
        return (this.getHeightE() - (CFG.TEXT_HEIGHT_DEFAULT * 4 + CFG.PADD * 3)) / 2;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagDiplomacyGovernment(oSB, this.getPosXE() + ButtonN_Civs2.flagPadding() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - ButtonN_Civs2.flagHeight() / 2 + iTranslateY, this.iCivLeft);
        Core.drawFlagDiplomacyGovernment(oSB, this.getPosXE() + this.getWidthE() - ButtonN_Civs2.flagPadding() - ButtonN_Civs2.flagWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - ButtonN_Civs2.flagHeight() / 2 + iTranslateY, this.iCivRight);
        if (this.getIsHovered()) {
            Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + ButtonN_Civs2.flagWidthPadding() + this.textPadding() + iTranslateX, this.getPosY() + this.topPadding() + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            Renderer.drawTextWithShadow(oSB, this.fontID, this.sPopulation.text, this.getPosXE() + ButtonN_Civs2.flagWidthPadding() + this.textPadding() + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            Renderer.drawTextWithShadow(oSB, this.fontID, this.sEconomy.text, this.getPosXE() + ButtonN_Civs2.flagWidthPadding() + this.textPadding() + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            Renderer.drawTextWithShadow(oSB, this.fontID, this.sDefense.text, this.getPosXE() + ButtonN_Civs2.flagWidthPadding() + this.textPadding() + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 3 + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        }
        oSB.setColor(Color.WHITE);
        int imgID = Images.provinces;
        IMGManager.getIMG(imgID).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) / 2 + iTranslateX, this.getPosY() + this.topPadding() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)), (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)));
        imgID = Images.pop;
        IMGManager.getIMG(imgID).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) / 2 + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)), (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)));
        imgID = Images.economy;
        IMGManager.getIMG(imgID).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) / 2 + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)), (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)));
        imgID = Images.attack;
        IMGManager.getIMG(imgID).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) / 2 + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 3 + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)), (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)));
        try {
            if (!this.getIsHovered()) {
                CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivLeft).getReligionID()).draw(oSB, this.getPosXE() + ButtonN_Civs2.flagWidthPadding() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivLeft).getReligionID()).getHeight() * this.getImageScale_H(CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivLeft).getReligionID()).getHeight())) / 2 + iTranslateY, (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivLeft).getReligionID()).getWidth() * this.getImageScale_H(CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivLeft).getReligionID()).getHeight())), (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivLeft).getReligionID()).getHeight() * this.getImageScale_H(CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivLeft).getReligionID()).getHeight())));
                CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivRight).getReligionID()).draw(oSB, this.getPosXE() + this.getWidthE() - ButtonN_Civs2.flagWidthPadding() - CFG.PADD * 2 - (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivRight).getReligionID()).getWidth() * this.getImageScale_H(CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivRight).getReligionID()).getHeight())) + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivRight).getReligionID()).getHeight() * this.getImageScale_H(CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivRight).getReligionID()).getHeight())) / 2 + iTranslateY, (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivRight).getReligionID()).getWidth() * this.getImageScale_H(CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivRight).getReligionID()).getHeight())), (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivRight).getReligionID()).getHeight() * this.getImageScale_H(CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivRight).getReligionID()).getHeight())));
                Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sReligion_Left.text, this.getPosXE() + ButtonN_Civs2.flagWidthPadding() + CFG.PADD * 3 + (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivLeft).getReligionID()).getWidth() * this.getImageScale_H(CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivLeft).getReligionID()).getHeight())) + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sTechValue_Left.iTextH / 2 + iTranslateY, this.getColorE(isActive));
                Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sReligion_Right.text, this.getPosXE() + this.getWidthE() - ButtonN_Civs2.flagWidthPadding() - CFG.PADD * 3 - (int)((float)CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivRight).getReligionID()).getWidth() * this.getImageScale_H(CFG.religionManager.religionImages.get(CFG.core.getCiv(this.iCivRight).getReligionID()).getHeight())) - this.sReligion_Right.iTextW + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sTechValue_Left.iTextH / 2 + iTranslateY, this.getColorE(isActive));
            }
        }
        catch (Exception exception) {
            
        }
        imgID = Images.economy;
        if (!this.getIsHovered()) {
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sName_Left.text, this.getPosXE() + ButtonN_Civs2.flagWidthPadding() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.topPadding() + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sName_Left.iTextH / 2 + iTranslateY, Colors.getColorTopStats(isActive, this.getIsHovered()));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sName_Right.text, this.getPosXE() + this.getWidthE() - ButtonN_Civs2.flagWidthPadding() - CFG.PADD * 2 - this.sName_Right.iTextW + iTranslateX, this.getPosY() + this.topPadding() + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sName_Left.iTextH / 2 + iTranslateY, Colors.getColorTopStats(isActive, this.getIsHovered()));
        }
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sProvincesValue_Left.text, this.getPosXE() + this.getWidthE() / 2 - CFG.PADD - this.sProvincesValue_Left.iTextW - (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) / 2 + iTranslateX, this.getPosY() + this.topPadding() + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sProvincesValue_Left.iTextH / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sProvincesValue_Right.text, this.getPosXE() + this.getWidthE() / 2 + CFG.PADD + (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) / 2 + iTranslateX, this.getPosY() + this.topPadding() + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sProvincesValue_Left.iTextH / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sPopulationValue_Left.text, this.getPosXE() + this.getWidthE() / 2 - CFG.PADD - this.sPopulationValue_Left.iTextW - (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) / 2 + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sPopulationValue_Left.iTextH / 2 + iTranslateY, Colors.getColorPopulation(isActive, this.getIsHovered()));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sPopulationValue_Right.text, this.getPosXE() + this.getWidthE() / 2 + CFG.PADD + (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) / 2 + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sPopulationValue_Left.iTextH / 2 + iTranslateY, Colors.getColorPopulation(isActive, this.getIsHovered()));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sEconomyValue_Left.text, this.getPosXE() + this.getWidthE() / 2 - CFG.PADD - this.sEconomyValue_Left.iTextW - (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) / 2 + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sEconomyValue_Left.iTextH / 2 + iTranslateY, Colors.getColorEconomy(isActive, this.getIsHovered()));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sEconomyValue_Right.text, this.getPosXE() + this.getWidthE() / 2 + CFG.PADD + (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) / 2 + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sEconomyValue_Left.iTextH / 2 + iTranslateY, Colors.getColorEconomy(isActive, this.getIsHovered()));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sAttackValue_Left.text, this.getPosXE() + this.getWidthE() / 2 - CFG.PADD - this.sAttackValue_Left.iTextW - (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) / 2 + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 3 + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sAttackValue_Left.iTextH / 2 + iTranslateY, Colors.getColorTopStats(isActive, this.getIsHovered()));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sAttackValue_Right.text, this.getPosXE() + this.getWidthE() / 2 + CFG.PADD + (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) / 2 + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 3 + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sAttackValue_Right.iTextH / 2 + iTranslateY, Colors.getColorTopStats(isActive, this.getIsHovered()));
        if (!this.getIsHovered()) {
            imgID = Images.technology;
            IMGManager.getIMG(imgID).draw(oSB, this.getPosXE() + ButtonN_Civs2.flagWidthPadding() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)), (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)));
            IMGManager.getIMG(imgID).draw(oSB, this.getPosXE() + this.getWidthE() - ButtonN_Civs2.flagWidthPadding() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)), (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sTechValue_Left.text, this.getPosXE() + ButtonN_Civs2.flagWidthPadding() + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sTechValue_Left.iTextH / 2 + iTranslateY, this.getColorE(isActive));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sTechValue_Right.text, this.getPosXE() + this.getWidthE() - ButtonN_Civs2.flagWidthPadding() - CFG.PADD * 3 - (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) - this.sTechValue_Right.iTextW + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sTechValue_Left.iTextH / 2 + iTranslateY, this.getColorE(isActive));
            imgID = Images.defense;
            IMGManager.getIMG(imgID).draw(oSB, this.getPosXE() + ButtonN_Civs2.flagWidthPadding() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 3 + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)), (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)));
            IMGManager.getIMG(imgID).draw(oSB, this.getPosXE() + this.getWidthE() - ButtonN_Civs2.flagWidthPadding() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 3 + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)), (int)((float)IMGManager.getIMG(imgID).getHeight() * this.getImageScale(imgID)));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sDefenseValue_Left.text, this.getPosXE() + ButtonN_Civs2.flagWidthPadding() + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 3 + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sDefenseValue_Left.iTextH / 2 + iTranslateY, this.getColorE(isActive));
            Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.sDefenseValue_Right.text, this.getPosXE() + this.getWidthE() - ButtonN_Civs2.flagWidthPadding() - CFG.PADD * 3 - (int)((float)IMGManager.getIMG(imgID).getWidth() * this.getImageScale(imgID)) - this.sDefenseValue_Right.iTextW + iTranslateX, this.getPosY() + this.topPadding() + (CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT) * 3 + CFG.TEXT_HEIGHT_DEFAULT / 2 - this.sDefenseValue_Right.iTextH / 2 + iTranslateY, this.getColorE(isActive));
        }
        oSB.setColor(Color.WHITE);
    }

    public float getImageScale(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    private final float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    private final float getImageScale_H(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.525f));
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivLeft, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivLeft).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text_Big(" - ", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivRight).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivRight, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }

    public class TextValue {
        public String text;
        public int iTextW;
        public int iTextH;

        public TextValue(String nText) {
            this.text = nText;
            try {
                if (this.text != null && this.text.length() > 0) {
                    CFG.glyphLay.setText(CFG.fontMain.get(ButtonN_Civs2.this.fontID), this.text);
                    this.iTextW = (int)CFG.glyphLay.width;
                    this.iTextH = (int)CFG.glyphLay.height;
                } else {
                    this.iTextH = 0;
                    this.iTextW = 0;
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }

        public TextValue(String nText, int nFont) {
            this.text = nText;
            try {
                if (this.text != null && this.text.length() > 0) {
                    CFG.glyphLay.setText(CFG.fontMain.get(nFont), this.text);
                    this.iTextW = (int)CFG.glyphLay.width;
                    this.iTextH = (int)CFG.glyphLay.height;
                } else {
                    this.iTextH = 0;
                    this.iTextW = 0;
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }
}

