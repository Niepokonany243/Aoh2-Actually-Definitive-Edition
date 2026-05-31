
package age.of.civilizations2.jakowski.lukasz.Menus.Core;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios.Menu_CreateScenario;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_Cores
extends Menu_CreateScenario {
    private String assignProvinces;
    private int iStepWidth;
    private String assignProvinces2;
    private int iStepWidth2;

    public Menu_CreateScenario_Cores() {
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
        super.updateLang();
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
        this.assignProvinces = CFG.lang.get("SetUpCores");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.assignProvinces);
        this.iStepWidth = (int)CFG.glyphLay.width;
        this.assignProvinces2 = CFG.lang.get("ClickAprovinceOnTheMapToAddOrRemoveCore") + ".";
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.assignProvinces2);
        this.iStepWidth2 = (int)CFG.glyphLay.width;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_EdgeR(oSB, iTranslateX, this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Top_Edge_R_Reflected(oSB, this.getMenuElem(5).getPosXE() - CFG.PADD + iTranslateX, CFG.BUTTON_H + CFG.PADD * 2 + this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH - (this.getMenuElem(5).getPosXE() - CFG.PADD), CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawTextDefaultWithShadow(oSB, this.assignProvinces, CFG.GAMEWIDTH / 2 - (this.iStepWidth + CFG.CIV_FLAG_WIDTH + CFG.PADD) / 2 + CFG.PADD + CFG.CIV_FLAG_WIDTH + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD / 2 + this.getMenuPosY() + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.b, 0.95f));
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextDefaultWithShadow(oSB, this.assignProvinces2, CFG.GAMEWIDTH / 2 - (int)((float)this.iStepWidth2 * 0.8f / 2.0f) + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 + CFG.PADD + this.getMenuPosY() + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.b, 0.75f));
        CFG.fontMain.get(0).getData().setScale(1.0f);
        try {
            CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getFlagC().drawO(oSB, CFG.GAMEWIDTH / 2 - (this.iStepWidth + CFG.CIV_FLAG_WIDTH + CFG.PADD) / 2 + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 - CFG.CIV_FLAG_HEIGHT - CFG.PADD / 2 + this.getMenuPosY() - CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, CFG.GAMEWIDTH / 2 - (this.iStepWidth + CFG.CIV_FLAG_WIDTH + CFG.PADD) / 2 + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 - CFG.CIV_FLAG_HEIGHT - CFG.PADD / 2 + this.getMenuPosY() + iTranslateY);
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, CFG.GAMEWIDTH / 2 - (this.iStepWidth + CFG.CIV_FLAG_WIDTH + CFG.PADD) / 2 + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 - CFG.CIV_FLAG_HEIGHT - CFG.PADD / 2 + this.getMenuPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, CFG.GAMEWIDTH / 2 - (this.iStepWidth + CFG.CIV_FLAG_WIDTH + CFG.PADD) / 2 + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 - CFG.CIV_FLAG_HEIGHT - CFG.PADD / 2 + this.getMenuPosY() + iTranslateY);
        }
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
                if (CFG.brushMode && CFG.core.getProvSelected().getProvSize() < 2) {
                    CFG.core.getProvSelected().clearSelectedProvinces();
                }
                return;
            }
            case 3: {
                CFG.selectMode = !CFG.selectMode;
                return;
            }
            case 4: {
                CFG.core.getProvSelected().clearSelectedProvinces();
                CFG.selectMode = true;
                CFG.menus.rebuildCreateScenario_Cores_SetUp();
                return;
            }
            case 5: {
                CFG.core.getProvSelected().popProvince();
                if (CFG.core.getProvSelected().getProvSize() == 0) {
                    CFG.selectMode = true;
                }
                CFG.menus.rebuildCreateScenario_Cores_SetUp();
                return;
            }
        }
        super.actionEL(iID);
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_SETTINGS);
        CFG.core.setActiveProvID(-1);
        CFG.core.getProvSelected().clearSelectedProvinces();
    }
}

