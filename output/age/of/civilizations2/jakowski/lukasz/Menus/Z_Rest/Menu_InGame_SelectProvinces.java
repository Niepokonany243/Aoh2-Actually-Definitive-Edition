/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Button_CivName;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_SelectProvinces
extends Menu {
    public static TypeOfAction typeOfAction = TypeOfAction.TRADE_LEFT;

    public Menu_InGame_SelectProvinces() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD, CFG.PADD, CFG.BUTTON_W * 2, true, false){

            @Override
            public boolean getCheckboxSt() {
                return CFG.brushMode;
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.PADD, CFG.BUTTON_W, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.selectMode;
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W * 3 + CFG.PADD * 3, CFG.PADD, CFG.BUTTON_W, false){

            @Override
            public boolean getIsClickable() {
                return CFG.core.getProvSelected().getProvSize() > 0;
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W * 3 + CFG.PADD * 3, CFG.PADD, CFG.BUTTON_W, false){

            @Override
            public boolean getIsClickable() {
                return CFG.core.getProvSelected().getProvSize() > 0;
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.PADD, CFG.BUTTON_W, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.VIEW_SHOW_VALUES;
            }
        });
        menuElements.add(new Button_CivName(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID, 0, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 3 - Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2), CFG.CIV_INFO_MENU_WIDTH * 3 / 4, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2), true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Brush"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Select"));
        this.getMenuElem(3).setTextE(CFG.lang.get("DeselectAll"));
        this.getMenuElem(4).setTextE(CFG.lang.get("Undo"));
        this.getMenuElem(5).setTextE(CFG.lang.get("Map"));
        this.updateButtonWidth(4, CFG.PADD, CFG.BUTTON_W * 2);
        for (int i = 2; i < 6; ++i) {
            this.updateButtonWidth(i, CFG.PADD, CFG.BUTTON_W);
        }
        this.updateButtonWidth(0, CFG.PADD, CFG.BUTTON_W * 2);
        int tempX = CFG.GAMEWIDTH - this.getMenuElem(2).getWidthE() - CFG.PADD;
        this.getMenuElem(2).setPosX(tempX);
        tempX = tempX - this.getMenuElem(1).getWidthE() - CFG.PADD;
        this.getMenuElem(1).setPosX(tempX);
        tempX = tempX - this.getMenuElem(3).getWidthE() - CFG.PADD;
        this.getMenuElem(3).setPosX(tempX);
        tempX = tempX - this.getMenuElem(4).getWidthE() - CFG.PADD;
        this.getMenuElem(4).setPosX(tempX);
        tempX = tempX - this.getMenuElem(5).getWidthE() - CFG.PADD;
        this.getMenuElem(5).setPosX(tempX);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorButtons_Top_Edge_R_Reflected(oSB, this.getMenuElem(5).getPosXE() - CFG.PADD + iTranslateX, this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH - (this.getMenuElem(5).getPosXE() - CFG.PADD), CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Bot_Edge_R(oSB, this.getMenuElem(0).getPosXE() - CFG.PADD + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() + CFG.PADD, this.getMenuElem(0).getHeightE() + CFG.PADD * 2);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.brushMode = !CFG.brushMode;
                break;
            }
            case 2: {
                CFG.selectMode = !CFG.selectMode;
                break;
            }
            case 3: {
                CFG.setDialogType(DialogType.DESELET_ALL_SELECTED_PROVINCES);
                break;
            }
            case 4: {
                CFG.core.getProvSelected().popProvince();
                if (CFG.core.getProvSelected().getProvSize() != 0) break;
                CFG.selectMode = true;
                break;
            }
            case 5: {
                CFG.VIEW_SHOW_VALUES = !CFG.VIEW_SHOW_VALUES;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.brushMode = false;
        CFG.menus.setMenuID(View.eINGAME);
        RenderProvince.updateDrawProvinces();
        if (typeOfAction == TypeOfAction.TRADE_LEFT) {
            CFG.tradeRequest.listLEFT.lProvinces.clear();
            for (int i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
                CFG.tradeRequest.listLEFT.lProvinces.add(CFG.core.getProvSelected().getProv(i));
            }
            CFG.menus.rebuildInGame_TradeRequest_Just();
        } else if (typeOfAction == TypeOfAction.TRADE_RIGHT) {
            CFG.tradeRequest.listRight.lProvinces.clear();
            for (int i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
                CFG.tradeRequest.listRight.lProvinces.add(CFG.core.getProvSelected().getProv(i));
            }
            CFG.menus.rebuildInGame_TradeRequest_Just();
        } else if (typeOfAction == TypeOfAction.ULTIMATUM) {
            CFG.ultimatum.demandProvinces.clear();
            for (int i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
                CFG.ultimatum.demandProvinces.add(CFG.core.getProvSelected().getProv(i));
            }
        }
        CFG.mapModesManager.setActiveMapModeID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE);
    }

    public static enum TypeOfAction {
        TRADE_LEFT,
        TRADE_RIGHT,
        TRADE_LEFT_DECLAREWAR,
        TRADE_RIGHT_DECLAREWAR,
        TRADE_LEFT_COALITION,
        TRADE_RIGHT_COALITION,
        TRADE_LEFT_PREPAREFORWAR,
        TRADE_RIGHT_PREPAREFORWAR,
        TRADE_LEFT_SANCTION,
        TRADE_RIGHT_SANCTION,
        ULTIMATUM;

    }
}

