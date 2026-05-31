
package age.of.civilizations2.jakowski.lukasz.Button.GameN.Opinion;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
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

public class ButtonN_Opinion
extends ButtonM {
    public long lTime = 0L;
    public float fAlphaMod = 0.0f;
    public boolean backAnimation = false;
    public int iImageID;
    public boolean row = false;
    public String sCost;
    public int iCostWidth;
    public boolean canBuild_MoneyCost;
    public String sMovementCost;
    public int iMovementCostWidth;
    public boolean canBuild_Movement;
    public int iCivA;
    public int iCivB;
    public String sCivBName;
    public String sCurrentRelation;
    public int iCurrentRelationWidth = 0;
    public Color relationColor;
    public SparksAnimation sparksAnimation = new SparksAnimation();

    public ButtonN_Opinion(int iCivA, int iCivB, int nImageID, int nCost, int nDiploCost, int iPosX, int iPosY, int iWidth) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(CFG.lang.get("Opinion") + ": ", 0, iPosX, iPosY, iWidth, CFG.BUTTON_H, true, true, false, false);
        this.iCivA = iCivA;
        this.iCivB = iCivB;
        this.iImageID = nImageID;
        this.sCivBName = CFG.core.getCiv(iCivB).getCivName();
        this.sCurrentRelation = "" + (CFG.core.getCivRelationOfCivB(iCivB, iCivA) > 0.0f ? "+" : "") + (float)((int)(CFG.core.getCivRelationOfCivB(iCivB, iCivA) * 10.0f)) / 10.0f + " ";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sCurrentRelation);
        this.iCurrentRelationWidth = (int)CFG.glyphLay.width;
        this.relationColor = CFG.core.getCivRelationOfCivB(iCivB, iCivA) > 0.0f ? CFG.COLOR_POSITIVE : (CFG.core.getCivRelationOfCivB(iCivB, iCivA) == 0.0f ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2);
        this.canBuild_MoneyCost = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)nCost;
        this.sCost = nCost > 0 ? "" + nCost : "";
        this.canBuild_Movement = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() >= nDiploCost;
        this.sMovementCost = nDiploCost > 0 ? "" + (float)nDiploCost / 10.0f : "";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.sCost);
        this.iCostWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.sMovementCost);
        this.iMovementCostWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (ButtonN_Opinion.this.getCheckboxSt()) {
                        oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.2f));
                        IMGManager.getIMG(Images.patternSquareTiny).draw2O(oSB, ButtonN_Opinion.this.getPosXE() + iTranslateX, ButtonN_Opinion.this.getPosY() - IMGManager.getIMG(Images.patternSquareTiny).getHeight() + 1 + iTranslateY, ButtonDiplomacy.iDiploWidth, ButtonN_Opinion.this.getHeightE() - 2, true, false);
                        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
                        IMGManager.getIMG(Images.gradient).drawO(oSB, ButtonN_Opinion.this.getPosXE() + iTranslateX, ButtonN_Opinion.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, ButtonDiplomacy.iDiploWidth, ButtonN_Opinion.this.getHeightE() / 4, false, false);
                        IMGManager.getIMG(Images.gradient).drawO(oSB, ButtonN_Opinion.this.getPosXE() + iTranslateX, ButtonN_Opinion.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + ButtonN_Opinion.this.getHeightE() - 1 + iTranslateY - ButtonN_Opinion.this.getHeightE() / 4, ButtonDiplomacy.iDiploWidth, ButtonN_Opinion.this.getHeightE() / 4, false, true);
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
        if (this.sCost.length() > 0 && this.sMovementCost.length() > 0) {
            if (this.sCost.length() > 0) {
                IMGManager.getIMG(Images.topGold()).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold(), 1.0f)) - IMGManager.getIMG(Images.topGold()).getHeight() - CFG.PADD / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), 1.0f)), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold(), 1.0f)));
                Renderer.drawTextWithShadow(oSB, this.fontID, this.sCost, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - Math.max((int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints, 1.0f)), (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), 1.0f))) - CFG.PADD - this.iCostWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD / 2 - this.getTextHeight() + iTranslateY, this.canBuild_MoneyCost ? CFG.COLOR_GOLD : CFG.COLOR_NEGATIVE_2);
            }
            if (this.sMovementCost.length() > 0) {
                IMGManager.getIMG(Images.topDiplomacyPoints).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() + CFG.PADD / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints, 1.0f)), (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * this.getImageScale(Images.topDiplomacyPoints, 1.0f)));
                Renderer.drawTextWithShadow(oSB, this.fontID, this.sMovementCost, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iMovementCostWidth - Math.max((int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints, 1.0f)), (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), 1.0f))) - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, this.canBuild_Movement ? CFG.COLOR_DIPLOMACY_POINTS : CFG.COLOR_NEGATIVE_2);
            }
        } else if (this.sMovementCost.length() > 0) {
            IMGManager.getIMG(Images.topDiplomacyPoints).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * this.getImageScale(Images.topDiplomacyPoints, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints, 1.0f)), (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * this.getImageScale(Images.topDiplomacyPoints, 1.0f)));
            Renderer.drawTextWithShadow(oSB, this.fontID, this.sMovementCost, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iMovementCostWidth - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints, 1.0f)) - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.canBuild_Movement ? CFG.COLOR_DIPLOMACY_POINTS : CFG.COLOR_NEGATIVE_2);
        }
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.diploRelations).draw(oSB, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + this.iCurrentRelationWidth + CFG.PADD * 3 / 4 + this.getTextWidthU() + IMGManager.getIMG(Images.flagRect2Mask).getWidth() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(Images.diploRelations).getHeight() * this.getImageScale(Images.diploRelations, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploRelations).getWidth() * this.getImageScale(Images.diploRelations, 1.0f)), (int)((float)IMGManager.getIMG(Images.diploRelations).getHeight() * this.getImageScale(Images.diploRelations, 1.0f)));
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2Mask).getHeight() / 2 + iTranslateY, this.iCivB);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sCivBName, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + IMGManager.getIMG(Images.flagRect2Mask).getWidth() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + IMGManager.getIMG(Images.flagRect2Mask).getWidth() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sCurrentRelation, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + this.getTextWidthU() + IMGManager.getIMG(Images.flagRect2Mask).getWidth() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, this.relationColor);
    }

    public float getImageScale(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    private final float getImageScale(int nImageID) {
        return CFG.TEXT_HEIGHT_DEFAULT / IMGManager.getIMG(nImageID).getHeight();
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.525f));
    }

    @Override
    public void actionElemPPM() {
        try {
            if (this.iCivB > 0 && this.iCivB < CFG.core.getCivsSize() && CFG.core.getCiv(this.iCivB).getCapitalProvID() >= 0) {
                CFG.core.setActiveProvID(CFG.core.getCiv(this.iCivB).getCapitalProvID());
                CFG.map.getMpC().centerToProvID(CFG.core.getCiv(this.iCivB).getCapitalProvID());
            }
        }
        catch (Exception exception) {
            
        }
    }

    @Override
    public void actionElem(int iID) {
        try {
            if (!CFG.getIsDesktop() && this.iCivB > 0 && this.iCivB < CFG.core.getCivsSize() && CFG.core.getCiv(this.iCivB).getCapitalProvID() >= 0) {
                CFG.core.setActiveProvID(CFG.core.getCiv(this.iCivB).getCapitalProvID());
                CFG.map.getMpC().centerToProvID(CFG.core.getCiv(this.iCivB).getCapitalProvID());
            }
        }
        catch (Exception exception) {
            
        }
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
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": "));
        nData.add(new ME_Hover_2Type_Text("-" + this.sMovementCost, CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }
}

