/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Colonization;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import age.of.civilizations2.jakowski.lukasz.Z_Other.Undo.Undo_AssignProvinceCiv;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_Colonization
extends Menu {
    public Menu_CreateScenario_Colonization() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true, GameCalendar.ENABLE_COLONIZATION){

            @Override
            public boolean getCheckboxSt() {
                return GameCalendar.ENABLE_COLONIZATION;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Enable") + "/" + CFG.lang.get("Disable") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ColonizationofWastelandProvinces") + "."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                GameCalendar.ENABLE_COLONIZATION = !GameCalendar.ENABLE_COLONIZATION;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true, GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES){

            @Override
            public boolean getCheckboxSt() {
                return GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Enable") + "/" + CFG.lang.get("Disable") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ColonizationofNeutralProvinces") + "."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElem(int iID) {
                GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES = !GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES;
                Menu_CreateScenario_Colonization.this.updateLang();
            }
        });
        menuElements.add(new Slider(null, CFG.BUTTON_W / 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, CFG.GAMEWIDTH - CFG.BUTTON_W, CFG.BUTTON_H - CFG.PADD * 2, 0, 100, (int)(GameCalendar.COLONIZATION_TECH_LEVEL * 100.0f)){

            @Override
            public String getDrawText() {
                return super.getTextE() + (float)this.getCurr() / 100.0f;
            }

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                IMGManager.getIMG(Images.btnMenu1H).drawO(oSB, this.getPosXE() - CFG.BUTTON_W / 2 + iTranslateX, this.getPosY() - CFG.PADD + iTranslateY, this.getWidthE() + CFG.BUTTON_W);
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
            }

            @Override
            public void setCurr(int nCurrent) {
                GameCalendar.COLONIZATION_TECH_LEVEL = (float)this.getCurr() / 100.0f;
                super.setCurr(nCurrent);
            }

            @Override
            public void actionElem(int iID) {
                GameCalendar.COLONIZATION_TECH_LEVEL = (float)this.getCurr() / 100.0f;
            }
        });
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD, menuElements);
        this.updateLang();
        CFG.lCreateScenario_UndoAssignProvsCivID = new ArrayList<Undo_AssignProvinceCiv>();
        CFG.lCreateScenario_UndoWastelandProvinces = new ArrayList<Integer>();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("ColonizationofWastelandProvinces"));
        this.getMenuElem(1).setTextE(CFG.lang.get("NeutralProvinces") + ": " + (GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES ? CFG.lang.get("Colonization") : CFG.lang.get("Conquering")));
        this.getMenuElem(2).setTextE(CFG.lang.get("RequiredTechnologyLevel") + ": ");
    }

    @Override
    public final void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }
}

