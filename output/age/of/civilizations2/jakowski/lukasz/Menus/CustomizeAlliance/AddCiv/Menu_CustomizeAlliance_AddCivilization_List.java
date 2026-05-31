/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.CustomizeAlliance.AddCiv;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_CivilizationAndFlag;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Menu_CustomizeAlliance_AddCivilization_List
extends Menu {
    private List<Integer> lCivID;

    public Menu_CustomizeAlliance_AddCivilization_List() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.lCivID = new ArrayList<Integer>();
        if (CFG.chosenAlphabetCharachter == null) {
            menuElements.add(new Button_Classic(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
            int nPosY = 0;
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv(i).getAlliance() != 0) continue;
                menuElements.add(new Button_Classic_CivilizationAndFlag(i, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (nPosY + 1) + CFG.PADD * (nPosY + 2), CFG.GAMEWIDTH, CFG.BUTTON_H, true){

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(this.getCurr()).getNumOfProvs(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).countPop()), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).countEco()), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyLevel") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(this.getCurr()).getTechLevel(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                this.lCivID.add(i);
                ++nPosY;
            }
        } else {
            int nPosY = 0;
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv(i).getAlliance() != 0 || CFG.core.getCiv(i).getCivName().charAt(0) != CFG.chosenAlphabetCharachter.charAt(0)) continue;
                menuElements.add(new Button_Classic_CivilizationAndFlag(i, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * nPosY + CFG.PADD * (nPosY + 1), CFG.GAMEWIDTH, CFG.BUTTON_H, true){

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(this.getCurr()).getNumOfProvs(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).countPop()), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.getCurr()).countEco()), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyLevel") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(this.getCurr()).getTechLevel(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                this.lCivID.add(i);
                ++nPosY;
            }
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4 + CFG.BUTTON_H + CFG.PADD, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.BUTTON_H - CFG.PADD * 2, menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        if (CFG.chosenAlphabetCharachter == null) {
            this.getMenuElem(0).setTextE(CFG.lang.get("RandomCivilization"));
        }
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                if (CFG.chosenAlphabetCharachter == null) {
                    Random oR = new Random();
                    int tempRandom = oR.nextInt(this.lCivID.size());
                    CFG.core.getCiv(tempRandom).setAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID);
                    CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).addCivilization(tempRandom);
                    break;
                }
            }
            default: {
                CFG.core.getCiv(this.lCivID.get(iID - (CFG.chosenAlphabetCharachter == null ? 1 : 0))).setAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID);
                CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).addCivilization(this.lCivID.get(iID - (CFG.chosenAlphabetCharachter == null ? 1 : 0)));
            }
        }
        CFG.menus.setMenuID(View.eCUSTOMIZE_ALLIANCE);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }
}

