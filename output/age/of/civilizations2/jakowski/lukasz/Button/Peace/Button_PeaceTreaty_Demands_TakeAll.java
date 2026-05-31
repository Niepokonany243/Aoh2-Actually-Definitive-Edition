
package age.of.civilizations2.jakowski.lukasz.Button.Peace;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_PeaceTreaty_Demands_TakeAll
extends ButtonM {
    public int iCivID = 0;
    private boolean row = false;

    public Button_PeaceTreaty_Demands_TakeAll(int nCivID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD;
        super.init("" + CFG.core.getCiv(nCivID).getCivName(), 0, iPosX, iPosY, iWidth, Button_PeaceTreaty_Demands_TakeAll.getElemHeight(), isClickable, true, false, false);
        this.iCivID = nCivID;
    }

    public static final int getElemHeight() {
        return CFG.isAndroid() ? Math.max(CFG.BUTTON_H * 3 / 4, Math.max(IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4)) : Math.max(IMGManager.getIMG(Images.flagRect2).getHeight() + CFG.PADD * 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.85f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
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

    private final float getImageScale(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * 0.8f / (float)nHeight;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.375f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + CFG.PADD * 4 - 1 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - CFG.PADD * 2);
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + CFG.PADD * 4 + 1 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - CFG.PADD * 2);
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 - 1 + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - CFG.PADD * 2);
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 + 1 + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - CFG.PADD * 2);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.875f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + CFG.PADD * 4 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(Color.WHITE);
        Core.drawFlagRectGovernment(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 6 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_CIV_NAME_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_NAME_HOVERED : CFG.COLOR_TEXT_CIV_NAME) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }

    @Override
    public int getCurr() {
        return this.iCivID;
    }

    @Override
    public void actionElem(int iID) {
        int i;
        boolean rebuildMenu = false;
        for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.size(); ++i) {
            if (CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).iCivID != this.getCurr()) continue;
            CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).showProvinces = !CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get((int)i).showProvinces;
            rebuildMenu = true;
            break;
        }
        if (!rebuildMenu) {
            for (i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.size(); ++i) {
                if (CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).iCivID != this.getCurr()) continue;
                CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).showProvinces = !CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get((int)i).showProvinces;
                rebuildMenu = true;
                break;
            }
        }
        if (rebuildMenu) {
            CFG.menus.rebuildInGame_PeaceTreaty_Provinces();
        }
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(this.iCivID).getIdeology()).getName(), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Ideology_Big(CFG.core.getCiv(this.iCivID).getIdeology(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}

