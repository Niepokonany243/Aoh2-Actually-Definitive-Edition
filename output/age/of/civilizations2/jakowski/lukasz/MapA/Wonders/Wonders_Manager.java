/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MapA.Wonders;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Wonders.Wonder;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_WonderBig;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import java.util.ArrayList;
import java.util.List;

public class Wonders_Manager {
    public List<Wonder> lWonders = null;
    public List<Integer> wondersProvinceIDs = new ArrayList<Integer>();

    public final void buildWondersProvinceID() {
        this.wondersProvinceIDs.clear();
        for (int j = 0; j < CFG.core.getProvinSize(); ++j) {
            CFG.core.getProv(j).clearWonders();
        }
        int iSize = this.lWonders.size();
        block1: for (int i = 0; i < iSize; ++i) {
            for (int j = 0; j < CFG.core.getProvinSize(); ++j) {
                if (CFG.core.getProv(j).getMiX2() > this.lWonders.get((int)i).iPosX * CFG.map.getMpB().getMapSc3() || CFG.core.getProv(j).getMaX7() < this.lWonders.get((int)i).iPosX * CFG.map.getMpB().getMapSc3() || CFG.core.getProv(j).getMiY4() > this.lWonders.get((int)i).iPosY * CFG.map.getMpB().getMapSc3() || CFG.core.getProv(j).getMaY6() < this.lWonders.get((int)i).iPosY * CFG.map.getMpB().getMapSc3() || !CFG.core.ptCS(j, this.lWonders.get((int)i).iPosX * CFG.map.getMpB().getMapSc3(), this.lWonders.get((int)i).iPosY * CFG.map.getMpB().getMapSc3())) continue;
                CFG.core.getProv(j).addWonder(this.lWonders.get(i));
                this.wondersProvinceIDs.add(j);
                continue block1;
            }
        }
        this.lWonders.clear();
        this.lWonders = null;
    }

    public static boolean buildWonder(int iProvinceID) {
        if (CFG.core.getProv((int)iProvinceID).provGD.wonderBuilt) {
            return false;
        }
        if (CFG.core.getCiv(CFG.core.getProv(iProvinceID).getCivId()).getGold() > (long)Wonders_Manager.getWonderCost(iProvinceID)) {
            CFG.core.getCiv(CFG.core.getProv(iProvinceID).getCivId()).setGold(CFG.core.getCiv(CFG.core.getProv(iProvinceID).getCivId()).getGold() - (long)Wonders_Manager.getWonderCost(iProvinceID));
            CFG.core.getProv((int)iProvinceID).provGD.wonderBuilt = true;
            return true;
        }
        return false;
    }

    public static int getWonderCost(int provinceID) {
        return (int)((float)GameValues.gvWonder.BUILD_COST - (float)GameValues.gvWonder.BUILD_COST * Math.min(GameValues.gvWonder.BUILD_COST_DEVELOPMENT_MAX, CFG.core.getProv(provinceID).getDeveLvl() * GameValues.gvWonder.BUILD_COST_DEVELOPMENT_MODIFIER));
    }

    public static ME_Hover_v2 getHoverWonder(int iProvinceID, int iWonderID) {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(CFG.core.getProv((int)iProvinceID).getWonder((int)iWonderID).sName), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_WonderBig(iProvinceID, iWonderID, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(iProvinceID).getCivId() >= 0 && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(iProvinceID) ? CFG.core.getProv(iProvinceID).getProvName() : CFG.lang.get("Undiscovered")));
        if (CFG.core.getProv(iProvinceID).getCivId() >= 0 && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(iProvinceID)) {
            nData.add(new ME_Hover_2Type_Text_Big(": "));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(iProvinceID).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        }
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(iProvinceID).getCivId() >= 0 && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(iProvinceID) ? CFG.core.getProv(iProvinceID).getCivId() : -1, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("WonderConstructed")));
        nData.add(new ME_Hover_2Type_Image(CFG.core.getProv((int)iProvinceID).provGD.wonderBuilt ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (!CFG.core.getProv((int)iProvinceID).provGD.wonderBuilt) {
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
            nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces(Wonders_Manager.getWonderCost(iProvinceID) + ""), CFG.COLOR_GOLD));
            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeTaxation") + ": "));
        nData.add(new ME_Hover_2Type_Text("+" + CFG.getPrecision2(GameValues.gvWonder.INCOME_TAXATION, 10), CFG.COLOR_GOLD));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("GrowthRate") + ": "));
        nData.add(new ME_Hover_2Type_Text("+" + (int)(GameValues.gvWonder.GROWTH_RATE * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        return new ME_Hover_v2(nElements);
    }
}

