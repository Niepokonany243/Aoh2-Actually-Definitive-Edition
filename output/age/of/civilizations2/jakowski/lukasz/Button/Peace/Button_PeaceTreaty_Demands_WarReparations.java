/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Peace;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Button_PeaceTreaty_Demands_WarReparations
extends ButtonM {
    public int iCivID = 0;
    public int toPayCivID = 0;
    public boolean row = false;
    public String sValue;
    public int iValueWidth = 0;
    public static int MAX_WDITH_LEFT = 0;

    public Button_PeaceTreaty_Demands_WarReparations(int nCivID, int toPayCivID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(CFG.lang.get("WarReparations"), 0, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false);
        this.iCivID = nCivID;
        this.toPayCivID = toPayCivID;
        this.sValue = "" + CFG.peaceTreatyData.getWarReparation_Cost(toPayCivID);
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sValue);
        this.iValueWidth = (int)CFG.glyphLay.width;
        MAX_WDITH_LEFT = Math.max((int)((float)IMGManager.getIMG(Images.city).getWidth() * this.getImageScale(IMGManager.getIMG(Images.city).getHeight())), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale2(Images.flagRectSmall))) + CFG.PADD * 4;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.275f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, MAX_WDITH_LEFT, this.getHeightE());
        oSB.setColor(new Color((float)CFG.core.getCiv(this.toPayCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.toPayCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.toPayCivID).getB() / 255.0f, 0.125f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, MAX_WDITH_LEFT * 3 / 4, this.getHeightE());
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

    public final float getImageScale(int nHeight) {
        return (float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) / (float)nHeight;
    }

    public final float getImageScale2(int nImageID) {
        return (float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.375f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() - 1 + MAX_WDITH_LEFT + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - CFG.PADD * 2);
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + 1 + MAX_WDITH_LEFT + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - CFG.PADD * 2);
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 - 1 + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - CFG.PADD * 2);
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 + 1 + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - CFG.PADD * 2);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.875f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + MAX_WDITH_LEFT + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        oSB.setColor(Color.WHITE);
        try {
            if (this.iCivID > 0) {
                CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getPosXE() + MAX_WDITH_LEFT / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale2(Images.flagRectSmall)) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale2(Images.flagRectSmall)) / 2 - CFG.core.getCiv(this.iCivID).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale2(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale2(Images.flagRectSmall)));
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + MAX_WDITH_LEFT / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale2(Images.flagRectSmall)) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale2(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale2(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale2(Images.flagRectSmall)));
            } else {
                IMGManager.getIMG(Images.topGold()).drawO(oSB, this.getPosXE() + MAX_WDITH_LEFT / 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(IMGManager.getIMG(Images.topGold()).getHeight())) / 2 + iTranslateX, this.getPosY() + 1 + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(IMGManager.getIMG(Images.topGold()).getHeight())) / 2 - IMGManager.getIMG(Images.topGold()).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(IMGManager.getIMG(Images.topGold()).getHeight())), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(IMGManager.getIMG(Images.topGold()).getHeight())));
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        IMGManager.getIMG(Images.victoryPoints).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.victoryPoints).getWidth() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.victoryPoints).getHeight() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.victoryPoints).getHeight(), (int)((float)IMGManager.getIMG(Images.victoryPoints).getWidth() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight())), (int)((float)IMGManager.getIMG(Images.victoryPoints).getHeight() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight())));
        Rectangle clipBounds = new Rectangle(this.getPosXE() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE() - CFG.PADD * 3 - this.iValueWidth - (int)((float)IMGManager.getIMG(Images.victoryPoints).getWidth() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight())), this.getHeightE());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + MAX_WDITH_LEFT + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
        Renderer.drawText(oSB, this.fontID, this.sValue, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - this.iValueWidth - (int)((float)IMGManager.getIMG(Images.victoryPoints).getWidth() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        if (this.iCivID > 0) {
            nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
        }
        nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Image_Big(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Taxation") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (int)(GameValues.gvPeaceTreaty.PERCENTAGE_OF_INCOME_FOR_WAR_REPARATIONS * 100.0f) + "%", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TurnsX", GameValues.gvPeaceTreaty.WAR_REPARATIONS_LENGTH), CFG.COLOR_NEUTRAL));
        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public void actionElem(int iID) {
        this.iCivID = CFG.peaceTreatyData.takeWarReparations(this.toPayCivID, CFG.peaceTreatyData.brushCivID, this.iCivID);
        if (CFG.menus.getInGame_PeaceTreaty()) {
            CFG.menus.rebuildInGame_PeaceTreaty_Scores();
        }
        CFG.toastM.addM(CFG.lang.get("WarReparations"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        CFG.toastM.setTimeInView(1500);
    }

    @Override
    public void setMin(int iMin) {
        this.iCivID = iMin;
    }
}

