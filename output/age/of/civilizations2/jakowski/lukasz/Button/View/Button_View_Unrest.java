
package age.of.civilizations2.jakowski.lukasz.Button.View;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
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
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Button_View_Unrest
extends ButtonM {
    private boolean row = false;
    private int iProvinceID = 0;
    private String sPopulation;
    private int iPopulationWidth = 0;

    public Button_View_Unrest(int iRow, String sText, int nProvinceID, int iPosX, int iPosY, int iWidth) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, 0, iPosX, iPosY, iWidth, Menu_InGame_View_Army.getButtonHeight(), true, true, false, false);
        this.row = iRow % 2 == 0;
        this.iProvinceID = nProvinceID;
        float risk = CFG.core.getProv(this.iProvinceID).getRevRisk();
        int revolutionaryPop = age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvRebels.SPAWN_REVOLUTIONARY_ARMY_BASE + age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvRebels.SPAWN_REVOLUTIONARY_ARMY_RANDOM / 2;
        for (int i = 0; i < CFG.core.getProv(this.iProvinceID).getPop().getNatsSize(); ++i) {
            if (CFG.core.getProv(this.iProvinceID).getPop().getCivID(i) == CFG.core.getProv(this.iProvinceID).getCivId()) {
                revolutionaryPop += (int)((float)CFG.core.getProv(this.iProvinceID).getPop().getPopulationID(i) * age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvRebels.SPAWN_REVOLUTIONARY_ARMY_POP_SUPPORT_FROM_CIV_ID);
            } else {
                revolutionaryPop += (int)((float)CFG.core.getProv(this.iProvinceID).getPop().getPopulationID(i) * age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvRebels.SPAWN_REVOLUTIONARY_ARMY_POP_SUPPORT_ELSE);
            }
        }
        long nArmy = (int)((float)revolutionaryPop * CFG.REBELS_POWER * Math.max(0.05f, risk));
        if (risk > 1.0f) {
            nArmy = (int)((float)nArmy * (1.0f + (risk - 1.0f) * 2.5f));
        }
        nArmy = Math.max(50, nArmy);
        this.sPopulation = "" + (int)(risk * 100.0f) + "% [" + nArmy + "]";
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), "" + this.sPopulation);
        this.iPopulationWidth = (int)CFG.glyphLay.width;
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
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.825f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getProv(this.iProvinceID).getCivId());
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getTextE(), this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, "" + this.sPopulation, this.getPosXE() + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.getColorStep(CFG.COLOR_REVOLUTION_MIN, CFG.COLOR_REVOLUTION_MAX, (int)(CFG.core.getProv(this.iProvinceID).getRevRisk() * 100.0f), 2000, 1.0f));
        IMGManager.getIMG(Images.diploRevolution).drawO(oSB, this.getPosXE() + CFG.PADD * 3 + this.iPopulationWidth + IMGManager.getIMG(Images.flagRect2).getWidth() + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.diploRevolution).getHeight() * this.getImageScale(IMGManager.getIMG(Images.diploRevolution).getHeight())) / 2 + iTranslateY - IMGManager.getIMG(Images.diploRevolution).getHeight(), (int)((float)IMGManager.getIMG(Images.diploRevolution).getWidth() * this.getImageScale(IMGManager.getIMG(Images.diploRevolution).getHeight())), (int)((float)IMGManager.getIMG(Images.diploRevolution).getHeight() * this.getImageScale(IMGManager.getIMG(Images.diploRevolution).getHeight())));
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

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.iProvinceID).getCivId()));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(this.iProvinceID).getName().length() > 0 ? CFG.core.getProv(this.iProvinceID).getName() : CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RevolutionaryRisk") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getProv(this.iProvinceID).getRevRisk() * 100.0f) + "%", CFG.COLOR_ECONOMY));
        if (CFG.core.getProv((int)this.iProvinceID).provGD.iSupportRebelsSize > 0) {
            int i;
            ArrayList<Integer> lCivs = new ArrayList<Integer>();
            ArrayList<Integer> lCivsTurnsLeft = new ArrayList<Integer>();
            ArrayList lSupportedByCivs = new ArrayList();
            int iCivsSize = 0;
            for (i = 0; i < CFG.core.getProv((int)this.iProvinceID).provGD.iSupportRebelsSize; ++i) {
                boolean wasAdded = false;
                int tAddID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getProv((int)this.iProvinceID).provGD.lSupportRebels.get((int)i).iRebelsCivID) ? CFG.core.getProv((int)this.iProvinceID).provGD.lSupportRebels.get((int)i).iRebelsCivID : CFG.core.getProv((int)this.iProvinceID).provGD.lSupportRebels.get((int)i).iRebelsCivID * -1;
                for (int j = lCivs.size() - 1; j >= 0; --j) {
                    if ((Integer)lCivs.get(j) != tAddID) continue;
                    wasAdded = true;
                    lCivsTurnsLeft.set(j, Math.max((Integer)lCivsTurnsLeft.get(j), CFG.core.getProv((int)this.iProvinceID).provGD.lSupportRebels.get((int)i).iTurnsLeft));
                    ((List)lSupportedByCivs.get(j)).add(CFG.core.getProv((int)this.iProvinceID).provGD.lSupportRebels.get((int)i).iByCivID);
                    break;
                }
                if (wasAdded) continue;
                lCivs.add(tAddID);
                lCivsTurnsLeft.add(CFG.core.getProv((int)this.iProvinceID).provGD.lSupportRebels.get((int)i).iTurnsLeft);
                lSupportedByCivs.add(new ArrayList());
                ((List)lSupportedByCivs.get(lSupportedByCivs.size() - 1)).add(CFG.core.getProv((int)this.iProvinceID).provGD.lSupportRebels.get((int)i).iByCivID);
                if (lCivs.size() >= 4) break;
            }
            iCivsSize = lCivs.size();
            nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(this.iProvinceID).getCivId()));
            nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(this.iProvinceID).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Text(" - " + CFG.lang.get("SupportRebels"), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image(Images.diploRevolution, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            for (i = 0; i < iCivsSize; ++i) {
                nData.add(new ME_Hover_2Type_Flag((Integer)lCivs.get(i)));
                nData.add(new ME_Hover_2Type_Text((Integer)lCivs.get(i) > 0 ? CFG.core.getCiv((Integer)lCivs.get(i)).getCivName() : CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                for (int k = 0; k < ((List)lSupportedByCivs.get(i)).size() && k < 10; ++k) {
                    nData.add(new ME_Hover_2Type_Flag(CFG.SPECTATOR_MODE || CFG.core.isAlly(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), (Integer)((List)lSupportedByCivs.get(i)).get(k)) ? (Integer)((List)lSupportedByCivs.get(i)).get(k) : -((Integer)((List)lSupportedByCivs.get(i)).get(k)).intValue(), k == 0 ? CFG.PADD : 0, 0));
                }
                nData.add(new ME_Hover_2Type_Text(" " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + (Integer)lCivsTurnsLeft.get(i)), CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Text(" [" + CFG.lang.get("TurnsX", (Integer)lCivsTurnsLeft.get(i)) + "]", CFG.COLOR_TEXT_RANK_HOVER));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
        }
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}


