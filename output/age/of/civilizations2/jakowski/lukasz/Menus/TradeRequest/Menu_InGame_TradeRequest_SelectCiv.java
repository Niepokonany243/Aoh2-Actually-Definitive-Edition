
package age.of.civilizations2.jakowski.lukasz.Menus.TradeRequest;

import age.of.civilizations2.jakowski.lukasz.Button.Button_CivName;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_InGame_SelectProvinces;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_TradeRequest_SelectCiv
extends Menu {
    public static Menu_InGame_SelectProvinces.TypeOfAction typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT_DECLAREWAR;

    public Menu_InGame_TradeRequest_SelectCiv() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.BUTTON_W * 2, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
            }
        });
        menuElements.add(new Button_CivName(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID, 0, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 3 - Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2), CFG.CIV_INFO_MENU_WIDTH * 3 / 4, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2), true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
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
        }
    }

    @Override
    public void onBackPressed() {
        CFG.brushMode = false;
        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = -1;
        CFG.menus.setMenuID(View.eINGAME);
        RenderProvince.updateDrawProvinces();
        CFG.mapModesManager.setActiveMapModeID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE);
    }
}

