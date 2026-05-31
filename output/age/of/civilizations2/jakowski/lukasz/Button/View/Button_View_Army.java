/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.View;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
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
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Terrain;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_View_Army
extends ButtonM {
    private boolean row = false;
    private int iProvinceID = 0;
    public long iPopulation = 0;
    private String sPopulation;
    private int iPopulationWidth = 0;
    private int iPopulationPerc;
    private int iPopulationPercWidth = 0;
    private boolean drawSupply = false;
    public String defensivePos;
    public int iDefensivePosWidth = 0;
    public String perUnit;
    public int iPerUnitWidth = 0;

    public Button_View_Army(int iRow, String sText, int nProvinceID, int iCivID, int upkeepCost, int iPosX, int iPosY, int iWidth) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, Menu_InGame_View_Army.getButtonHeight(), true, true, false, false);
        this.row = iRow % 2 == 0;
        this.iProvinceID = nProvinceID;
        this.drawSupply = CFG.core.getProv(this.iProvinceID).getLvlOfSupply() > 0;
        this.iPopulation = CFG.core.getProv(this.iProvinceID).getArmyCivID1((int)iCivID) + (long)CFG.core.getCiv(iCivID).getMoveUnits_NumFromProvince(this.iProvinceID);
        this.sPopulation = CFG.getNumberWthSpaces("" + this.iPopulation);
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sPopulation);
        this.iPopulationWidth = (int)CFG.glyphLay.width;
        this.iPopulationPerc = upkeepCost;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), "" + this.iPopulationPerc);
        this.iPopulationPercWidth = (int)CFG.glyphLay.width;
        this.defensivePos = "" + CFG.core.getProv(this.iProvinceID).getDefensivePosition();
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.defensivePos);
        this.iDefensivePosWidth = (int)CFG.glyphLay.width;
        this.perUnit = "" + (float)((int)((float)this.iPopulationPerc / (float)this.iPopulation * 100.0f)) / 100.0f;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.perUnit);
        this.iPerUnitWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.row) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.1f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.65f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.275f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.35f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.4f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.6f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.45f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.85f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        }
        if (this.iProvinceID == CFG.core.getActiveProvID()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.7f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getProv(this.iProvinceID).getCivId());
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY, this.getColorE(isActive));
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sPopulation, this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        IMGManager.getIMG(Images.diploArmy).draw(oSB, this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + this.iPopulationWidth + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploArmy).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.diploArmy).getHeight())), (int)((float)IMGManager.getIMG(Images.diploArmy).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.diploArmy).getHeight())));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.defensivePos, this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + this.iPopulationWidth + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.diploArmy).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.diploArmy).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_TEXT_GRAY_NS);
        IMGManager.getIMG(Images.defensivePosition).draw(oSB, this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + this.iPopulationWidth + this.iDefensivePosWidth + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(Images.diploArmy).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.diploArmy).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.defensivePosition).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.defensivePosition).getHeight())), (int)((float)IMGManager.getIMG(Images.defensivePosition).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.defensivePosition).getHeight())));
        IMGManager.getIMG(Images.topGold()).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, "" + this.iPopulationPerc, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY, CFG.COLOR_NEGATIVE_2);
        IMGManager.getIMG(Images.topGold()).draw(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())));
        Renderer.drawText(oSB, CFG.FONT_REGULAR_SMALL, this.perUnit, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iPerUnitWidth - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, CFG.COLOR_GOLD);
        if (this.drawSupply) {
            IMGManager.getIMG(Images.bSupply).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - this.iPopulationPercWidth - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale2(IMGManager.getIMG(Images.topGold()).getHeight())) - (int)((float)IMGManager.getIMG(Images.bSupply).getWidth() * this.getImageScale(IMGManager.getIMG(Images.bSupply).getHeight())) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.bSupply).getHeight() * this.getImageScale(IMGManager.getIMG(Images.bSupply).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.bSupply).getHeight(), (int)((float)IMGManager.getIMG(Images.bSupply).getWidth() * this.getImageScale(IMGManager.getIMG(Images.bSupply).getHeight())), (int)((float)IMGManager.getIMG(Images.bSupply).getHeight() * this.getImageScale(IMGManager.getIMG(Images.bSupply).getHeight())));
        }
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.6f));
    }

    @Override
    public int getCurr() {
        return this.iProvinceID;
    }

    private final float getImageScale(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    private final float getImageScale2(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(this.iProvinceID).getName().length() > 0 ? CFG.core.getProv(this.iProvinceID).getName() : CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Army") + ": "));
        nData.add(new ME_Hover_2Type_Text(this.sPopulation, CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + this.iPopulationPerc, CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text("" + (float)((int)((float)this.iPopulationPerc / (float)this.iPopulation * 100.0f)) / 100.0f, CFG.COLOR_GOLD));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, CFG.PADD));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PerUnit")));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(this.iProvinceID).getCivId()));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefensivePosition") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + CFG.lang.get("TurnsX", CFG.core.getProv(this.iProvinceID).getDefensivePosition()), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
        nData.add(new ME_Hover_2Type_Text("-" + Math.ceil((int)(CFG.gameUpdate.getMilitaryUpkeepDefensivePosition(this.iProvinceID) * 1000.0f)) / 10.0 + "%", CFG.COLOR_POSITIVE));
        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Development") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getProv(this.iProvinceID).getDeveLvl() * 100.0f)) / 100.0f, CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (CFG.terrainTypesManager.getMilitaryUpkeep(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()) != 0.0f) {
            nData.add(new ME_Hover_2Type_Terrain(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()));
            nData.add(new ME_Hover_2Type_Text(CFG.terrainTypesManager.getName(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()), CFG.COLOR_HOVER_TITLE));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getMilitaryUpkeep(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getMilitaryUpkeep(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()) * 100.0f) + "%", CFG.terrainTypesManager.getMilitaryUpkeep(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getMilitaryUpkeep(CFG.core.getProv(this.iProvinceID).getTerrainTypeID()) < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2)));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}

