/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Button_Diplomacy_Civilize
extends ButtonM {
    private boolean row = false;
    private int iCivID = 0;
    private String sTextCostGold;
    private String sTextCostDiplomacy;
    private int iTextCostGoldWidth;
    private int iTextCostDiplomacyWidth;

    public Button_Diplomacy_Civilize(int iCivID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean nCheckbox) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(CFG.lang.get("Civilize"), 0, iPosX, iPosY, iWidth, iHeight, isClickable, true, true, nCheckbox);
        this.iCivID = iCivID;
        this.sTextCostGold = "" + (float)((int)(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)iCivID).getIdeology()).CIVILIZE_TECH_LEVEL * 100.0f)) / 100.0f;
        this.sTextCostDiplomacy = "" + (float)GameValues.gvCivilize.COST_CIVILIZE_DIPLOMACY_POINTS / 10.0f;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sTextCostGold);
        this.iTextCostGoldWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sTextCostDiplomacy);
        this.iTextCostDiplomacyWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
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
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (Button_Diplomacy_Civilize.this.getCheckboxSt()) {
                        oSB.setColor(new Color(0.55f, 0.8f, 0.0f, 0.3f));
                    } else {
                        oSB.setColor(new Color(0.8f, 0.137f, 0.0f, 0.3f));
                    }
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Button_Diplomacy_Civilize.this.getPosXE() + iTranslateX, Button_Diplomacy_Civilize.this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, Button_Diplomacy_Civilize.this.getWidthE() / 6, Button_Diplomacy_Civilize.this.getHeightE() - 2, false, false);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Button_Diplomacy_Civilize.this.getPosXE() + iTranslateX, Button_Diplomacy_Civilize.this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, Button_Diplomacy_Civilize.this.getWidthE() / 10, Button_Diplomacy_Civilize.this.getHeightE() - 2, false, false);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Diplomacy_Civilize.this.getPosXE() + iTranslateX, Button_Diplomacy_Civilize.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, Button_Diplomacy_Civilize.this.getWidthE(), CFG.PADD, false, false);
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Diplomacy_Civilize.this.getPosXE() + iTranslateX, Button_Diplomacy_Civilize.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + Button_Diplomacy_Civilize.this.getHeightE() - 1 + iTranslateY - CFG.PADD, Button_Diplomacy_Civilize.this.getWidthE(), CFG.PADD, false, true);
                    oSB.setColor(Color.WHITE);
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
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        try {
            CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getPosXE() + (ButtonDiplomacy.iDiploWidth - IMGManager.getIMG(Images.flagRectSmall).getWidth()) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(this.iCivID).getFlagC().getHeight() + iTranslateY, IMGManager.getIMG(Images.flagRectSmall).getWidth(), IMGManager.getIMG(Images.flagRectSmall).getHeight());
        }
        catch (NullPointerException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + (ButtonDiplomacy.iDiploWidth - IMGManager.getIMG(Images.flagRectSmall).getWidth()) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, IMGManager.getIMG(Images.flagRectSmall).getWidth(), IMGManager.getIMG(Images.flagRectSmall).getHeight());
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + (ButtonDiplomacy.iDiploWidth - IMGManager.getIMG(Images.flagRectSmall).getWidth()) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, IMGManager.getIMG(Images.flagRectSmall).getWidth(), IMGManager.getIMG(Images.flagRectSmall).getHeight());
        IMGManager.getIMG(Images.technology).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology)) + iTranslateX, this.getPosY() + CFG.PADD / 2 + this.getHeightE() / 2 - this.getHeightE() / 4 - (int)((float)IMGManager.getIMG(Images.technology).getHeight() * this.getImageScale(Images.technology) / 2.0f) - IMGManager.getIMG(Images.technology).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology)), (int)((float)IMGManager.getIMG(Images.technology).getHeight() * this.getImageScale(Images.technology)));
        IMGManager.getIMG(Images.topDiplomacyPoints).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints)) + iTranslateX, this.getPosY() - CFG.PADD / 2 + this.getHeightE() / 2 + this.getHeightE() / 4 - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * this.getImageScale(Images.topDiplomacyPoints) / 2.0f) - IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints)), (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() * this.getImageScale(Images.topDiplomacyPoints)));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sTextCostGold, this.getPosXE() + this.getWidthE() - this.iTextCostGoldWidth - CFG.PADD * 3 - (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology)) + iTranslateX, this.getPosY() + CFG.PADD / 2 + this.getHeightE() / 2 - this.getHeightE() / 4 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, CFG.core.getCiv(this.iCivID).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.iCivID).getIdeology()).CIVILIZE_TECH_LEVEL ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2);
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.sTextCostDiplomacy, this.getPosXE() + this.getWidthE() - this.iTextCostDiplomacyWidth - CFG.PADD * 3 - (int)((float)IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() * this.getImageScale(Images.topDiplomacyPoints)) + iTranslateX, this.getPosY() - CFG.PADD / 2 + this.getHeightE() / 2 + this.getHeightE() / 4 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, CFG.core.getCiv(this.iCivID).getDiploPoints() >= GameValues.gvCivilize.COST_CIVILIZE_DIPLOMACY_POINTS ? CFG.COLOR_DIPLOMACY_POINTS : CFG.COLOR_NEGATIVE_2);
        Rectangle clipBounds = new Rectangle(this.getPosXE() + ButtonDiplomacy.iDiploWidth + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE() - this.getRightWidth() - ButtonDiplomacy.iDiploWidth, this.getHeightE());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
    }

    public final int getRightWidth() {
        return Math.max(this.iTextCostGoldWidth + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology)), this.iTextCostDiplomacyWidth + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.topDiplomacyPoints)));
    }

    private final float getImageScale(int nImageID) {
        return (float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }

    @Override
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ChangeTypeOfGovernment") + "..?", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("WhatIsAGovernmentAnyway")));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ChangeTypeOfGovernmentTo") + ": ", CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Text(CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.iCivID).getIdeology()).CAN_BECOME_CIVILIZED).getName(), CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.iCivID).getIdeology()).CAN_BECOME_CIVILIZED).getColor()));
            nData.add(new ME_Hover_2Type_Ideology(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.iCivID).getIdeology()).CAN_BECOME_CIVILIZED, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RequiredTechnologyLevel") + ": ", CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.iCivID).getIdeology()).CIVILIZE_TECH_LEVEL * 100.0f)) / 100.0f, CFG.COLOR_TECHNOLOGY));
            nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(this.iCivID).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.iCivID).getIdeology()).CIVILIZE_TECH_LEVEL ? Images.iconTrue : Images.iconFalse, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text("[", CFG.core.getCiv(this.iCivID).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.iCivID).getIdeology()).CIVILIZE_TECH_LEVEL ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Flag(this.iCivID, 0, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(this.iCivID).getTechLevel() * 100.0f)) / 100.0f, CFG.core.getCiv(this.iCivID).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.iCivID).getIdeology()).CIVILIZE_TECH_LEVEL ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Text("]", CFG.core.getCiv(this.iCivID).getTechLevel() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.iCivID).getIdeology()).CIVILIZE_TECH_LEVEL ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ": ", CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Text("" + (float)GameValues.gvCivilize.COST_CIVILIZE_DIPLOMACY_POINTS / 10.0f));
            nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(this.iCivID).getDiploPoints() >= GameValues.gvCivilize.COST_CIVILIZE_DIPLOMACY_POINTS ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException ex) {
            this.menuElemHover = null;
        }
    }

    @Override
    public void setMax(int nCurrent) {
        this.row = nCurrent == 1;
    }

    @Override
    public void setVisibleE(boolean isVisible) {
        super.setVisibleE(isVisible);
    }
}

