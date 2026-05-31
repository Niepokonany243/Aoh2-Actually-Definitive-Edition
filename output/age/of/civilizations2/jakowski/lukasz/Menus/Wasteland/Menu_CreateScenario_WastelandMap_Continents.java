/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Wasteland;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_WastelandMap_Continents
extends Menu {
    public Menu_CreateScenario_WastelandMap_Continents() {
        int i;
        ArrayList<Integer> lSortedIDs = new ArrayList<Integer>();
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        ArrayList<Integer> tempIDs = new ArrayList<Integer>();
        for (i = 0; i < CFG.map.getMapContinents().getContinentsSize(); ++i) {
            if (i == CFG.map.getMapContinents().getOceanContinentID()) continue;
            menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD, CFG.PADD, CFG.BUTTON_W, true, true){
                int iCurrent;
                {
                    this.iCurrent = 0;
                }

                @Override
                public int getCurr() {
                    return this.iCurrent;
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.iCurrent = nCurrent;
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.map.getMapContinents().getName(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("NumberOfProvinces") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.countContinentProvinces(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            tempIDs.add(i);
        }
        while (tempIDs.size() > 0) {
            int nMinID = 0;
            for (int i2 = 1; i2 < tempIDs.size(); ++i2) {
                if (!CFG.compareAlphabetic_TwoString(CFG.map.getMapContinents().getName((Integer)tempIDs.get(nMinID)), CFG.map.getMapContinents().getName((Integer)tempIDs.get(i2)))) continue;
                nMinID = i2;
            }
            lSortedIDs.add((Integer)tempIDs.get(nMinID));
            tempIDs.remove(nMinID);
        }
        for (i = 0; i < menuElements.size(); ++i) {
            ((MenuElemUI)menuElements.get(i)).setTextE(CFG.map.getMapContinents().getName((Integer)lSortedIDs.get(i)));
            ((MenuElemUI)menuElements.get(i)).setCurr((Integer)lSortedIDs.get(i));
        }
        this.initMenu(null, 0, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2 - CFG.PADD * 4, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2, menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.updatedButtonsWidth(CFG.PADD, CFG.BUTTON_W);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.bgGameAction).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - 1 - IMGManager.getIMG(Images.bgGameAction).getHeight() + iTranslateY, this.getMenuElem(this.getMenuElemsSize() - 1).getPosXE() + this.getMenuElem(this.getMenuElemsSize() - 1).getWidthE() + CFG.PADD + 1, this.getHeightM() + 1, true, false);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public final void actionEL(int iID) {
        int i;
        int numOfWastelandProvinces = 0;
        int numOfNormalProvinces = 0;
        int chosenContinent = this.getMenuElem(iID).getCurr();
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getContinent() != chosenContinent) continue;
            if (CFG.core.getProv(i).getWastelandLvl() >= 0) {
                ++numOfWastelandProvinces;
                continue;
            }
            ++numOfNormalProvinces;
        }
        this.getMenuElem(iID).setCheckboxSt(numOfWastelandProvinces > numOfNormalProvinces);
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getContinent() != chosenContinent) continue;
            CFG.core.getProv(i).setWastelandLvl(numOfWastelandProvinces < numOfNormalProvinces ? 0 : -1);
        }
        CFG.core.buildWastelandLevels();
        CFG.toastM.addM(this.getMenuElem(iID).getTextE());
    }
}

