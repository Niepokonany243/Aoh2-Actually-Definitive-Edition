
package age.of.civilizations2.jakowski.lukasz.Menus.Regions;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_MapRegions;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_Regions_List
extends Menu {
    public Menu_MapEditor_Regions_List() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = (CFG.GAMEWIDTH - CFG.PADD * 2 - CFG.BUTTON_W * 2 - CFG.PADD * 2 - CFG.PADD * (CFG.map.getMapRegions().getRegionsSize() - 1)) / CFG.map.getMapRegions().getRegionsSize();
        if (tempWidth < CFG.BUTTON_W) {
            tempWidth = CFG.BUTTON_W;
        }
        for (int i = 0; i < CFG.map.getMapRegions().getRegionsSize(); ++i) {
            menuElements.add(new Button_Game_Checkbox(CFG.map.getMapRegions().getName(i), -1, CFG.PADD + tempWidth * i + CFG.PADD * i, CFG.PADD, tempWidth, true, false){
                int iCurrent;
                {
                    this.iCurrent = 0;
                }

                @Override
                public boolean getCheckboxSt() {
                    return Editor_MapRegions.iActiveRegionID == this.getCurr();
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.iCurrent = nCurrent;
                }

                @Override
                public int getCurr() {
                    return this.iCurrent;
                }

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.map.getMapRegions().getName(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("NumberOfProvinces") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.countRegionProvinces(this.getCurr())), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException ex) {
                        this.menuElemHover = null;
                    }
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
        }
        this.initMenu(null, CFG.PADD * 2 + CFG.BUTTON_W * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2, CFG.GAMEWIDTH - (CFG.PADD * 2 + CFG.BUTTON_W * 2), CFG.BUTTON_H + CFG.PADD * 2, menuElements);
        if (tempWidth < CFG.BUTTON_W * 2) {
            this.updatedButtonsWidth(CFG.PADD, CFG.BUTTON_W * 2);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, this.getWidthM(), CFG.BUTTON_H + CFG.PADD * 2);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            oSB.setColor(new Color(CFG.map.getMapRegions().getColor((int)i).r, CFG.map.getMapRegions().getColor((int)i).g, CFG.map.getMapRegions().getColor((int)i).b, 1.0f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getWidthE() / 2 - this.getMenuElem(i).getTextWidthU() / 2 + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 + this.getMenuElem(i).getTextHeight() / 2 + CFG.PADD + iTranslateY, CFG.PADD, CFG.CIV_COLOR_W, true, false);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getWidthE() / 2 - this.getMenuElem(i).getTextWidthU() / 2 + CFG.PADD + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 + this.getMenuElem(i).getTextHeight() / 2 + CFG.PADD + iTranslateY, this.getMenuElem(i).getTextWidthU() - CFG.PADD * 2, CFG.CIV_COLOR_W);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getWidthE() / 2 - this.getMenuElem(i).getTextWidthU() / 2 + this.getMenuElem(i).getTextWidthU() - CFG.PADD + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 + this.getMenuElem(i).getTextHeight() / 2 + CFG.PADD + iTranslateY, CFG.PADD, CFG.CIV_COLOR_W);
            oSB.setColor(Color.WHITE);
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public final void actionEL(int iID) {
        Editor_MapRegions.iActiveRegionID = iID;
    }
}

