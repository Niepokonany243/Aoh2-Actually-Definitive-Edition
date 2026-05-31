
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextD;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Technology
extends Button_Build {
    public String sProvinceName;
    public String sDate;
    public int iDateWidth;
    public String sEconomy;
    public int iEconomyWidth;
    public String sTechMax;
    public int iTechMaxWidth;
    public String sPoints;
    public int iPointsWidth;
    public Color oColor = Color.WHITE;
    public int iCivID;
    public TextD attack;
    public TextD defense;

    public Button_Technology(int nCivID, int iPosX, int iPosY, int iWidth) {
        super(CFG.core.getCiv(nCivID).getCivName(), Images.technology, 0, 0, iPosX, iPosY, iWidth, true, false, 0, 0.0f);
        this.iCivID = nCivID;
        this.sDate = CFG.lang.get("TechnologyLevel") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sDate);
        this.iDateWidth = (int)CFG.glyphLay.width;
        this.sEconomy = "" + (float)((int)(CFG.core.getCiv(nCivID).getTechLevel() * 100.0f)) / 100.0f;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sEconomy);
        this.iEconomyWidth = (int)CFG.glyphLay.width;
        this.sTechMax = " / " + (float)((int)(GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL * 100.0f)) / 100.0f;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sTechMax);
        this.iTechMaxWidth = (int)CFG.glyphLay.width;
        this.setMin(CFG.core.getCiv((int)nCivID).civGD.techPoints.getPointsLeft(nCivID));
        this.attack = new TextD("+" + CFG.getPrecision2(CFG.gameAction.getAttackersBonusFromTechnology(nCivID), 100) + "%", CFG.FONT_BOLD_SMALL);
        this.defense = new TextD("+" + CFG.getPrecision2(CFG.gameAction.getDefenseBonusFromTechnology(nCivID), 100) + "%", CFG.FONT_BOLD_SMALL);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        int leftW = Math.max(ButtonDiplomacy.iDiploWidth, IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 4);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + leftW - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), false, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + leftW + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        if (this.inConstruction) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.525f));
            IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + leftW + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, this.getWidthE() - leftW, this.getHeightE());
        }
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
        int leftW = Math.max(ButtonDiplomacy.iDiploWidth, IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 4);
        Core.drawFlagRect(oSB, this.getPosXE() + leftW / 2 - IMGManager.getIMG(Images.flagRect2).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD + leftW + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sDate, this.getPosXE() + CFG.PADD + leftW + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sEconomy, this.getPosXE() + CFG.PADD + leftW + this.iDateWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_TECHNOLOGY);
        IMGManager.getIMG(Images.technology).draw(oSB, this.getPosXE() + CFG.PADD * 2 + this.iEconomyWidth + leftW + this.iDateWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology, ICON_SCALE)), (int)((float)IMGManager.getIMG(Images.technology).getHeight() * this.getImageScale(Images.technology, ICON_SCALE)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sTechMax, this.getPosXE() + CFG.PADD * 2 + this.iEconomyWidth + leftW + this.iDateWidth + (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology, ICON_SCALE)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_NEUTRAL);
        IMGManager.getIMG(Images.technology).draw(oSB, this.getPosXE() + CFG.PADD * 2 + this.iEconomyWidth + leftW + this.iDateWidth + (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology, ICON_SCALE)) + CFG.PADD + this.iTechMaxWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology, ICON_SCALE)), (int)((float)IMGManager.getIMG(Images.technology).getHeight() * this.getImageScale(Images.technology, ICON_SCALE)));
        IMGManager.getIMG(Images.technology).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - IMGManager.getIMG(Images.technology).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.technology).getHeight() / 2 + iTranslateY);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, this.sPoints, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - IMGManager.getIMG(Images.technology).getWidth() - this.iPointsWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, this.oColor);
        int pX = this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - IMGManager.getIMG(Images.technology).getWidth() - this.iPointsWidth + iTranslateX - CFG.PADD * 2;
        int img = Images.attack;
        int imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        int imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX -= imgW, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 - imgH / 2 + iTranslateY, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.attack.text, pX += -this.attack.textW - CFG.PADD, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL - CFG.PADD + iTranslateY, this.getColorE(isActive));
        pX = this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - IMGManager.getIMG(Images.technology).getWidth() - this.iPointsWidth + iTranslateX - CFG.PADD * 2;
        img = Images.defense;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX -= imgW, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 - imgH / 2 + iTranslateY, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.defense.text, pX += -this.defense.textW - CFG.PADD, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, this.getColorE(isActive));
    }

    public float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("PointsLeft") + ": "));
        nData.add(new ME_Hover_2Type_Text_Big(this.sPoints, this.oColor));
        nData.add(new ME_Hover_2Type_Text_Big("/" + (int)(CFG.core.getCiv(this.iCivID).getTechLevel() * 100.0f), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Technology") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(this.iCivID).getTechLevel(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text("/" + GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL, CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Flag(this.iCivID, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MaxTechnologyLevel") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL, CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Flag(this.iCivID, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Attack") + ": "));
        nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(CFG.gameAction.getAttackersBonusFromTechnology(this.iCivID), 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image(Images.attack, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        float fEff = CFG.gameUpdate.getAdministrationEfficiency(this.iCivID);
        int nAdmin = (int)((fEff - 0.5f) * 100.0f);
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Administration") + ": "));
        nData.add(new ME_Hover_2Type_Text((nAdmin >= 0 ? "+" : "") + nAdmin + "%", nAdmin >= 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.administration, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Defense") + ": "));
        nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(CFG.gameAction.getDefenseBonusFromTechnology(this.iCivID), 100) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image(Images.defense, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("AttackDefenseDesc")));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public void setMin(int iMin) {
        this.sPoints = "" + iMin;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD), this.sPoints);
        this.iPointsWidth = (int)CFG.glyphLay.width;
        this.oColor = iMin > 0 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : CFG.COLOR_NEUTRAL;
    }
}


