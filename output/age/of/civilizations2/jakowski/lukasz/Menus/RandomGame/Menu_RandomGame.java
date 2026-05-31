
package age.of.civilizations2.jakowski.lukasz.Menus.RandomGame;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Load.Scenario.Menu_LoadScenario;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_RandomGame
extends Menu {
    public Menu_RandomGame() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.BUTTON_W * 2, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2 + CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("PLAY"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Options"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Back"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD * 3 + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3, false, true);
        oSB.setColor(Color.WHITE);
        CFG.drawEditorButtons_Bot_Edge_R(oSB, iTranslateX, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - 1 + iTranslateY, this.getMenuElem(2).getPosXE() + this.getMenuElem(2).getWidthE() + CFG.PADD + 1, CFG.BUTTON_H + CFG.PADD * 2 + 1);
        CFG.drawEditorButtons_Bot_Edge_R_Reflected(oSB, this.getMenuElem(0).getPosXE() - CFG.PADD - 1 + iTranslateX, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - 1 + iTranslateY, this.getMenuElem(0).getWidthE() + CFG.PADD * 2 + 1, CFG.BUTTON_H + CFG.PADD * 2 + 1);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.lCreateScenario_UndoWastelandProvinces = null;
                CFG.SFXManager.playSound(SFXManager.SFX_RANDOM);
                this.newGame();
                break;
            }
            case 1: {
                CFG.menus.setVisible_CreateRandomGame_Options(!CFG.menus.getVisible_CreateRandomGame_Options());
                break;
            }
            case 2: {
                CFG.setDialogType(DialogType.CREATE_RANDOM_GAME_EXIT_MAIN_MENU);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        Menu_RandomGame.backToGames();
    }

    public static final void backToGames() {
        if (CFG.menus.getVisible_CreateRandomGame_WastelandMaps()) {
            CFG.randomGameManager.checkCapitals();
            CFG.menus.setVisible_CreateRandomGame_Options(true);
            CFG.map.getMpC().centerToRandomMapPos();
            return;
        }
        CFG.lCreateScenario_UndoWastelandProvinces = null;
        CFG.randomGameManager = null;
        Menu_LoadScenario.editor = false;
        Menu_LoadScenario.goToView = null;
        Menu_LoadScenario.loadActionEND = 7;
        CFG.menus.setMenuIDWithoutAnim(View.eLOAD_SCENARIO);
    }

    public final void newGame() {
        CFG.menus.setMenuIDWithoutAnim(View.eLOAD_SCENARIO_AOC);
    }
}

