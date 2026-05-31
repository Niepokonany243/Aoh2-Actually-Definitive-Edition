
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_HRE_Emperor
extends ButtonM {
    public long lTime = 0L;
    public float fAlphaMod = 0.0f;
    public boolean backAnimation = false;
    public int iCivID;
    public boolean row = false;
    public String sCivName;
    public int iCivNameWidth;
    public String sPopulation;
    public int iPopulationWidth;
    public String sEconomy;
    public int iEconomyWidth = 0;

    public Button_HRE_Emperor(int nCivID, int iPosX, int iPosY, int iWidth) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(CFG.lang.get("Emperor"), 0, iPosX, iPosY, iWidth, CFG.BUTTON_H * 4 / 5, true, true, false, false);
        this.iCivID = nCivID;
        if (this.iCivID >= 0) {
            this.sCivName = CFG.core.getCiv(this.iCivID).getCivName();
            this.sPopulation = CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.iCivID).countPop());
            this.sEconomy = "" + (float)((int)(CFG.core.getCiv(this.iCivID).getTechLevel() * 100.0f)) / 100.0f;
        } else {
            this.sCivName = CFG.lang.get("Undiscovered");
            this.sPopulation = "---";
            this.sEconomy = "---";
        }
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.sCivName);
        this.iCivNameWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.sPopulation);
        this.iPopulationWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.sEconomy);
        this.iEconomyWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getLEFTWidth() - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), false, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getLEFTWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
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
        Core.drawFlagRect(oSB, this.getPosXE() + this.getLEFTWidth() / 2 - IMGManager.getIMG(Images.flagRect2).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivID);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.pop).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop, 1.0f)) - IMGManager.getIMG(Images.pop).getHeight() - CFG.PADD / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop, 1.0f)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sPopulation, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iPopulationWidth - Math.max((int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology, 1.0f)), (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f))) - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD / 2 - this.getTextHeight() + iTranslateY, CFG.COLOR_POPULATION);
        IMGManager.getIMG(Images.technology).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.technology).getHeight() + CFG.PADD / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology, 1.0f)), (int)((float)IMGManager.getIMG(Images.technology).getHeight() * this.getImageScale(Images.technology, 1.0f)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sEconomy, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iEconomyWidth - Math.max((int)((float)IMGManager.getIMG(Images.technology).getWidth() * this.getImageScale(Images.technology, 1.0f)), (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop, 1.0f))) - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_TECHNOLOGY);
        IMGManager.getIMG(Images.hreFlag).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + this.getLEFTWidth() + this.iCivNameWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 - IMGManager.getIMG(Images.hreFlag).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall, 1.0f)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall, 1.0f)));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + this.getLEFTWidth() + this.iCivNameWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall, 1.0f)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall, 1.0f)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sCivName, this.getPosXE() + CFG.PADD + this.getLEFTWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD + this.getLEFTWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
    }

    public float getImageScale(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    public final int getLEFTWidth() {
        return IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 4;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.525f));
    }

    @Override
    public void actionElem(int iID) {
        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_IMPERIAL_MODE);
        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_IMPERIAL_MODE) {
            CFG.toastM.addM(CFG.lang.get("HolyRomanEmpire"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            try {
                if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(CFG.hreMgr.getHRE().getEmperor()).getCapitalProvID())) {
                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.hreMgr.getHRE().getEmperor()).getCapitalProvID());
                    if (CFG.menus.getVisible_InGame_CivInfo()) {
                        CFG.setActiveCivInfoId(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                        CFG.updateActiveCivilizationInfoInGame();
                    }
                    if (!CFG.core.getProv(CFG.core.getActiveProvID()).getDrawProv()) {
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                    }
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                
            }
        }
    }

    @Override
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Emperor") + ":", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.iCivID).getCivName()));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
    }
}

