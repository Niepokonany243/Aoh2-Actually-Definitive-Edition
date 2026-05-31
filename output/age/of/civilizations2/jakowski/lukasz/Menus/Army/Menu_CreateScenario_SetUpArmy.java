
package age.of.civilizations2.jakowski.lukasz.Menus.Army;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Minimap;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slide;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_SetUpArmy
extends Menu {
    public static final int DESELECT_ALL_ID = 4;
    private String sSetUpArmy;
    private int iStepWidth;

    public Menu_CreateScenario_SetUpArmy() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Minimap(CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight()));
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
        menuElements.add(new Slide(CFG.GAMEWIDTH - (CFG.PADD + IMGManager.getIMG(Images.slideBG).getHeight() / 2) - IMGManager.getIMG(Images.slideBG).getHeight() * 2, CFG.BUTTON_H * 2 + CFG.PADD * 5 + IMGManager.getIMG(Images.slideBG).getHeight() / 2, false));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sSetUpArmy = CFG.lang.get("SetUpArmy");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sSetUpArmy);
        this.iStepWidth = (int)CFG.glyphLay.width;
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
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
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_Edge_R_Reflected(oSB, iTranslateX, this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Top_Edge_R_Reflected(oSB, this.getMenuElem(5).getPosXE() - CFG.PADD + iTranslateX, CFG.BUTTON_H + CFG.PADD * 2 + this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH - (this.getMenuElem(5).getPosXE() - CFG.PADD), CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawTextDefaultWithShadow(oSB, this.sSetUpArmy, CFG.GAMEWIDTH / 2 - this.iStepWidth / 2 + iTranslateX, CFG.BUTTON_H / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + CFG.PADD + this.getMenuPosY() + iTranslateY, Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.map.getMpC().centerToMinimapClick(Touch.getMousePosX() - this.getMenuElem(iID).getPosXE() - this.getPosX(), Touch.getMousePosY() - this.getMenuElem(iID).getPosY() - this.getMenuPosY());
                break;
            }
            case 2: {
                CFG.brushMode = !CFG.brushMode;
                this.getMenuElem(iID).setCheckboxSt(CFG.brushMode);
                this.getMenuElem(6).setVisibleE(CFG.brushMode);
                this.getMenuElem(6).setClickable(CFG.brushMode);
                return;
            }
            case 3: {
                CFG.selectMode = !CFG.selectMode;
                return;
            }
            case 4: {
                CFG.core.getProvSelected().clearSelectedProvinces();
                CFG.menus.setVisible_CreateScenario_SetUpArmies_Sliders(false);
                CFG.menus.setVisible_CreateScenario_SetUpArmies_Civs(false);
                CFG.selectMode = true;
                return;
            }
            case 5: {
                CFG.core.getProvSelected().popProvince();
                if (CFG.core.getProvSelected().getProvSize() == 0) {
                    CFG.selectMode = true;
                    CFG.menus.setVisible_CreateScenario_SetUpArmies_Sliders(false);
                    CFG.menus.setVisible_CreateScenario_SetUpArmies_Civs(false);
                } else {
                    CFG.menus.rebuildCreateScenario_SetUpArmies_Sliders();
                    CFG.menus.rebuildCreateScenario_SetUpArmies_Civs();
                }
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.brushMode = false;
        CFG.selectMode = true;
        this.getMenuElem(6).setVisibleE(CFG.brushMode);
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_SETTINGS);
    }
}

