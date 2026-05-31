
package age.of.civilizations2.jakowski.lukasz.Menus.Events;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios.Menu_CreateScenario;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_SelectProvinces
extends Menu_CreateScenario {
    private String assignProvinces;
    private int iStepWidth;

    public Menu_CreateScenario_Events_SelectProvinces() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W * 2, true, false){

            @Override
            public boolean getCheckboxSt() {
                return CFG.brushMode;
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD * 2 + CFG.PADD, CFG.BUTTON_W, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.selectMode;
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD * 2 + CFG.PADD, CFG.BUTTON_W, false){

            @Override
            public boolean getIsClickable() {
                return CFG.core.getProvSelected().getProvSize() > 0;
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W * 3 + CFG.PADD * 3, CFG.BUTTON_H + CFG.PADD * 2 + CFG.PADD, CFG.BUTTON_W, false){

            @Override
            public boolean getIsClickable() {
                return CFG.core.getProvSelected().getProvSize() > 0;
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Brush"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Select"));
        this.getMenuElem(4).setTextE(CFG.lang.get("DeselectAll"));
        this.getMenuElem(5).setTextE(CFG.lang.get("Undo"));
        int extraX = this.updateButtonWidth(2, CFG.PADD, CFG.BUTTON_W * 2) + CFG.PADD;
        for (int i = 3; i < 6; ++i) {
            extraX += this.updateButtonWidth(i, extraX + CFG.PADD, CFG.BUTTON_W) + CFG.PADD;
        }
        int tempX = CFG.GAMEWIDTH - this.getMenuElem(3).getWidthE() - CFG.PADD;
        this.getMenuElem(3).setPosX(tempX);
        tempX = tempX - this.getMenuElem(2).getWidthE() - CFG.PADD;
        this.getMenuElem(2).setPosX(tempX);
        tempX = tempX - this.getMenuElem(4).getWidthE() - CFG.PADD;
        this.getMenuElem(4).setPosX(tempX);
        tempX = tempX - this.getMenuElem(5).getWidthE() - CFG.PADD;
        this.getMenuElem(5).setPosX(tempX);
        this.assignProvinces = CFG.lang.get("SelectProvinces");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.assignProvinces);
        this.iStepWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_EdgeR(oSB, iTranslateX, this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Top_Edge_R_Reflected(oSB, this.getMenuElem(5).getPosXE() - CFG.PADD + iTranslateX, CFG.BUTTON_H + CFG.PADD * 2 + this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH - (this.getMenuElem(5).getPosXE() - CFG.PADD), CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawTextDefaultWithShadow(oSB, this.assignProvinces, CFG.GAMEWIDTH / 2 - (this.iStepWidth + CFG.CIV_FLAG_WIDTH + CFG.PADD) / 2 + CFG.PADD + CFG.CIV_FLAG_WIDTH + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + this.getMenuPosY() + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.b, 0.95f));
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: 
            case 1: {
                this.onBackPressed();
                return;
            }
            case 2: {
                CFG.brushMode = !CFG.brushMode;
                this.getMenuElem(iID).setCheckboxSt(CFG.brushMode);
                return;
            }
            case 3: {
                CFG.selectMode = !CFG.selectMode;
                return;
            }
            case 4: {
                CFG.core.getProvSelected().clearSelectedProvinces();
                CFG.selectMode = true;
                return;
            }
            case 5: {
                CFG.core.getProvSelected().popProvince();
                if (CFG.core.getProvSelected().getProvSize() == 0) {
                    CFG.selectMode = true;
                }
                return;
            }
        }
        super.actionEL(iID);
    }

    @Override
    public void onBackPressed() {
        CFG.brushMode = false;
        CFG.eventsManager.selectCivAction(0);
        CFG.eventsManager.selectCivBack();
        CFG.core.setActiveProvID(-1);
        CFG.core.getProvSelected().clearSelectedProvinces();
    }
}

