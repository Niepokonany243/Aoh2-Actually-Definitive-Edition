
package age.of.civilizations2.jakowski.lukasz.Button.GameN;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class ButtonN_Battle
extends ButtonM {
    public int iImageID;
    public boolean row = false;
    private int iCivA;
    private int iCivB;
    public SparksAnimation sparksAnimation = new SparksAnimation();
    public int id = 0;
    public String attackersArmy;
    public int attackersArmyWidth;
    public String defendersArmy;
    public int defendersArmyWidth;
    public String attackersArmyDeaths;
    public int attackersArmyDeathsWidth;
    public String defendersArmyDeaths;
    public int defendersArmyDeathsWidth;
    public static int fontID2 = CFG.FONT_BOLD_SMALL;

    public ButtonN_Battle(String text, int iCivA, int iCivB, int iPosX, int iPosY, int iWidth, int id, long iAttackersArmy, long iDefendersArmy, long iAttackersArmyDeaths, long iDefendersArmyDeaths) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        this.id = id;
        super.init(text, 0, iPosX, iPosY, iWidth, CFG.BUTTON_H, true, true, false, false);
        this.iCivA = iCivA;
        this.iCivB = iCivB;
        this.iImageID = Images.battle;
        this.setCurr(id % 2);
        this.attackersArmy = "" + iAttackersArmy;
        CFG.glyphLay.setText(CFG.fontMain.get(fontID2), this.attackersArmy);
        this.attackersArmyWidth = (int)CFG.glyphLay.width;
        this.defendersArmy = "" + iDefendersArmy;
        CFG.glyphLay.setText(CFG.fontMain.get(fontID2), this.defendersArmy);
        this.defendersArmyWidth = (int)CFG.glyphLay.width;
        this.attackersArmyDeaths = "" + iAttackersArmyDeaths;
        CFG.glyphLay.setText(CFG.fontMain.get(fontID2), this.attackersArmyDeaths);
        this.attackersArmyDeathsWidth = (int)CFG.glyphLay.width;
        this.defendersArmyDeaths = "" + iDefendersArmyDeaths;
        CFG.glyphLay.setText(CFG.fontMain.get(fontID2), this.defendersArmyDeaths);
        this.defendersArmyDeathsWidth = (int)CFG.glyphLay.width;
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
        IMGManager.getIMG(this.iImageID).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth / 2 - IMGManager.getIMG(this.iImageID).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(this.iImageID).getHeight() / 2 + iTranslateY);
        oSB.setColor(Color.WHITE);
        Core.drawFlagRect(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - IMGManager.getIMG(Images.flagRect2Mask).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2Mask).getHeight() / 2 + iTranslateY, this.iCivB);
        Renderer.drawTextWithShadow(oSB, fontID2, this.defendersArmy, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - IMGManager.getIMG(Images.flagRect2Mask).getWidth() - this.defendersArmyWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploArmy).getHeight() / 2 - this.getTextHeight() / 2 - CFG.PADD / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
        IMGManager.getIMG(Images.diploArmy).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - IMGManager.getIMG(Images.diploArmy).getWidth() - IMGManager.getIMG(Images.flagRect2Mask).getWidth() - this.defendersArmyWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploArmy).getHeight() - CFG.PADD / 2 + iTranslateY);
        Renderer.drawTextWithShadow(oSB, fontID2, this.attackersArmy, this.getPosXE() + this.getWidthE() - CFG.PADD * 4 - IMGManager.getIMG(Images.diploArmy).getWidth() - IMGManager.getIMG(Images.flagRect2Mask).getWidth() - this.defendersArmyWidth - this.attackersArmyWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploArmy).getHeight() / 2 - this.getTextHeight() / 2 - CFG.PADD / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
        Renderer.drawTextWithShadow(oSB, fontID2, this.defendersArmyDeaths, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - IMGManager.getIMG(Images.flagRect2Mask).getWidth() - this.defendersArmyDeathsWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + IMGManager.getIMG(Images.skull).getHeight() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 + iTranslateY, CFG.COLOR_NEGATIVE_2);
        IMGManager.getIMG(Images.skull).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - IMGManager.getIMG(Images.diploArmy).getWidth() / 2 - IMGManager.getIMG(Images.skull).getWidth() / 2 - IMGManager.getIMG(Images.flagRect2Mask).getWidth() - this.defendersArmyWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY);
        Renderer.drawTextWithShadow(oSB, fontID2, this.attackersArmyDeaths, this.getPosXE() + this.getWidthE() - CFG.PADD * 4 - IMGManager.getIMG(Images.diploArmy).getWidth() - IMGManager.getIMG(Images.flagRect2Mask).getWidth() - this.defendersArmyWidth - this.attackersArmyDeathsWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + IMGManager.getIMG(Images.skull).getHeight() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 + iTranslateY, CFG.COLOR_NEGATIVE_2);
        Core.drawFlagRect(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 5 - IMGManager.getIMG(Images.diploArmy).getWidth() - IMGManager.getIMG(Images.flagRect2Mask).getWidth() * 2 - this.defendersArmyWidth - this.attackersArmyWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2Mask).getHeight() / 2 + iTranslateY, this.iCivA);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
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
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivA, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivA).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text_Big(" - ", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivB).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivB, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image(Images.battle, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag(this.iCivA, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Attackers") + ": "));
        nData.add(new ME_Hover_2Type_Text(this.attackersArmy, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag(this.iCivA, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Casualties") + ": "));
        nData.add(new ME_Hover_2Type_Text(this.attackersArmyDeaths, CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.skull, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag(this.iCivB, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Defenders") + ": "));
        nData.add(new ME_Hover_2Type_Text(this.defendersArmy, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag(this.iCivB, 0, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Casualties") + ": "));
        nData.add(new ME_Hover_2Type_Text(this.defendersArmyDeaths, CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.skull, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }

    @Override
    public int getCurr() {
        return this.id;
    }
}

