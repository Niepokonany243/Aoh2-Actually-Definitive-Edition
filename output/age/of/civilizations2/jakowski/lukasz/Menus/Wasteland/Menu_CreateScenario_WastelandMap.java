/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Wasteland;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Minimap;
import age.of.civilizations2.jakowski.lukasz.MapScale;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios.Menu_CreateScenario;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_WastelandMap
extends Menu_CreateScenario {
    private String selectMapOfAvailableProvinces;
    private int iStepWidth;
    private String selectMapOfAvailableProvinces2;
    private int iStepWidth2;

    public Menu_CreateScenario_WastelandMap() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ExitScenarioEditor"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CustomizeWasteland"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Minimap(CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight()));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        super.updateLang();
        this.selectMapOfAvailableProvinces = CFG.lang.get("SelectRegions");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.selectMapOfAvailableProvinces);
        this.iStepWidth = (int)CFG.glyphLay.width;
        this.selectMapOfAvailableProvinces2 = CFG.lang.get("SetWhichRegionsOfTheWorldAreWasteland") + ".";
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.selectMapOfAvailableProvinces2);
        this.iStepWidth2 = (int)CFG.glyphLay.width;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_Edge_LR(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawTextDefaultWithShadow(oSB, this.selectMapOfAvailableProvinces, CFG.GAMEWIDTH / 2 - this.iStepWidth / 2 + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD / 2 + this.getMenuPosY() + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.b, 0.95f));
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextDefaultWithShadow(oSB, this.selectMapOfAvailableProvinces2, CFG.GAMEWIDTH / 2 - (int)((float)this.iStepWidth2 * 0.8f / 2.0f) + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 + CFG.PADD + this.getMenuPosY() + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.b, 0.75f));
        CFG.fontMain.get(0).getData().setScale(1.0f);
        oSB.setColor(CFG.COLOR_BG_GAME_MENU_SHADOW);
        IMGManager.getIMG(Images.pix255).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - 1 + iTranslateY, CFG.GAMEWIDTH);
        oSB.setColor(Color.WHITE);
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
        switch (iID) {
            case 1: {
                if (CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                    CFG.map.getMpS().setCurrScale(MapScale.STANDARD_SCALE);
                    CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                } else {
                    CFG.core.setActiveProvID(-1);
                    CFG.map.getMpC().centerToRandomMapPos();
                }
                CFG.brushMode = false;
                CFG.updateNumOfAvailableProvinces();
                CFG.lCreateScenario_UndoWastelandProvinces.clear();
                CFG.backToMenu = View.eCREATE_SCENARIO_WASTELAND;
                CFG.goToMenu = View.eCREATE_SCENARIO_CIVILIZATIONS;
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_AVAILABLE_PROVINCES);
                CFG.map.getMpB().disposeMinimapOfCivilizations();
                return;
            }
            case 2: {
                CFG.map.getMpC().centerToMinimapClick(Touch.getMousePosX() - this.getMenuElem(iID).getPosXE() - this.getPosX(), Touch.getMousePosY() - this.getMenuElem(iID).getPosY() - this.getMenuPosY());
            }
        }
        super.actionEL(iID);
    }
}

