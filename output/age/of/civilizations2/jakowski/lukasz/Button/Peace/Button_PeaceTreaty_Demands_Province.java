/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Peace;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Button_PeaceTreaty_Demands_Province
extends ButtonM {
    public int iProvinceID = 0;
    public boolean row = false;
    public int iImageID;
    public String sValue;
    public int iValueWidth = 0;
    public static int MAX_WDITH_LEFT = 0;

    public Button_PeaceTreaty_Demands_Province(int nProvinceID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init("" + CFG.core.getProv(nProvinceID).getName(), 0, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false);
        this.iProvinceID = nProvinceID;
        this.iImageID = CFG.core.getProv(this.iProvinceID).getCitSize() > 0 ? CFG.core.getProv(this.iProvinceID).getCit(0).getCityLevel() : Images.city5;
        this.sValue = "" + CFG.core.getProvinceValue(this.iProvinceID);
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sValue);
        this.iValueWidth = (int)CFG.glyphLay.width;
        MAX_WDITH_LEFT = Math.max((int)((float)IMGManager.getIMG(Images.city).getWidth() * this.getImageScale(IMGManager.getIMG(Images.city).getHeight())), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale2(Images.flagRectSmall))) + CFG.PADD * 4;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.275f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, MAX_WDITH_LEFT, this.getHeightE());
        oSB.setColor(new Color((float)CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getTrueOwnerOfProv()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getTrueOwnerOfProv()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getTrueOwnerOfProv()).getB() / 255.0f, 0.125f));
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
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    public final float getImageScale2(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
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
            if (CFG.peaceTreatyData.drawProvOwners.get((int)this.iProvinceID).isTaken > 0 && CFG.peaceTreatyData.drawProvOwners.get((int)this.iProvinceID).iCivID > 0) {
                CFG.core.getCiv(CFG.peaceTreatyData.drawProvOwners.get((int)this.iProvinceID).iCivID).getFlagC().drawO(oSB, this.getPosXE() + MAX_WDITH_LEFT / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale2(Images.flagRectSmall)) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale2(Images.flagRectSmall)) / 2 - CFG.core.getCiv(CFG.peaceTreatyData.drawProvOwners.get((int)this.iProvinceID).iCivID).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale2(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale2(Images.flagRectSmall)));
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + MAX_WDITH_LEFT / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale2(Images.flagRectSmall)) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale2(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale2(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale2(Images.flagRectSmall)));
            } else {
                IMGManager.getIMG(this.iImageID).drawO(oSB, this.getPosXE() + MAX_WDITH_LEFT / 2 - IMGManager.getIMG(this.iImageID).getWidth() / 2 + iTranslateX, this.getPosY() + 1 + this.getHeightE() / 2 - IMGManager.getIMG(this.iImageID).getHeight() / 2 + iTranslateY);
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        IMGManager.getIMG(Images.victoryPoints).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(Images.victoryPoints).getWidth() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight())) + iTranslateX, this.getPosY() + 1 + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.victoryPoints).getHeight() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.victoryPoints).getHeight(), (int)((float)IMGManager.getIMG(Images.victoryPoints).getWidth() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight())), (int)((float)IMGManager.getIMG(Images.victoryPoints).getHeight() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight())));
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
        Renderer.drawText(oSB, this.fontID, this.sValue, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iValueWidth - (int)((float)IMGManager.getIMG(Images.victoryPoints).getWidth() * this.getImageScale(IMGManager.getIMG(Images.victoryPoints).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }

    @Override
    public int getCurr() {
        return this.iProvinceID;
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.iProvinceID).getTrueOwnerOfProv()));
        nData.add(new ME_Hover_2Type_Text_Big(this.getTextE()));
        nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public void actionElem(int iID) {
        CFG.core.setActiveProvID(this.getCurr());
        if (!CFG.core.getProv(this.getCurr()).getDrawProv()) {
            CFG.map.getMpC().centerToProvID(this.getCurr());
        }
        CFG.peaceTreatyData.takeProvince(this.getCurr(), CFG.peaceTreatyData.brushCivID, CFG.core.getCiv(CFG.peaceTreatyData.brushCivID).getIsPlayer() ? CFG.peaceTreatyData.brushCivID : CFG.core.getPlayer(CFG.peaceTreatyData.playerTurnID).getCivId());
        if (CFG.core.getProv(this.iProvinceID).getName().length() > 0) {
            CFG.toastM.addM(CFG.core.getCiv(CFG.peaceTreatyData.brushCivID).getCivName() + " - " + CFG.core.getProv(this.iProvinceID).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            CFG.toastM.setTimeInView(1500);
        }
    }

    @Override
    public void actionElemSPM() {
        int targetCivID = CFG.peaceTreatyData.brushCivID;
        int pointsUsedByCivID = CFG.core.getCiv(targetCivID).getIsPlayer() ? targetCivID : CFG.core.getPlayer(CFG.peaceTreatyData.playerTurnID).getCivId();
        int ownerCivID = CFG.core.getProv(this.iProvinceID).getTrueOwnerOfProv();

        for (int i = 0; i < CFG.core.getProvinSize(); i++) {
            if (CFG.core.getProv(i).getTrueOwnerOfProv() == ownerCivID) {
                CFG.peaceTreatyData.takeProvince(i, targetCivID, pointsUsedByCivID);
            }
        }
        
        if (CFG.menus.getInGame_PeaceTreaty()) {
            CFG.menus.rebuildInGame_PeaceTreaty_Provinces();
            CFG.menus.rebuildInGame_PeaceTreaty_Scores();
        }
    }

    @Override
    public void setIsHovered(boolean isHovered) {
        super.setIsHovered(isHovered);
        if (isHovered && CFG.core.getActiveProvID() != this.getCurr()) {
            CFG.core.setActiveProvID(this.getCurr());
        }
    }
}

