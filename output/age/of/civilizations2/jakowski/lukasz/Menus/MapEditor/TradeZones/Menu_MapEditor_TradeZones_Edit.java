
package age.of.civilizations2.jakowski.lukasz.Menus.MapEditor.TradeZones;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_ColorPicker;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_TradeZones_Edit
extends Menu {
    private String sName;
    private int iNameWidth;

    public Menu_MapEditor_TradeZones_Edit() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Classic("", -1, CFG.BUTTON_W + CFG.PADD * 2, 0, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.PADD * 2) * 2, CFG.BUTTON_H + CFG.PADD * 2, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? new Color(0.82f, 0.82f, 0.82f, 1.0f) : (this.getIsClickable() ? new Color(1.0f, 1.0f, 1.0f, 1.0f) : new Color(0.84f, 0.84f, 0.84f, 0.7f));
            }

            @Override
            public String getTextToDrawElem() {
                return Menu_MapEditor_TradeZones_Edit.this.sName + ": " + super.getTextE();
            }

            @Override
            public int getTextWidthU() {
                return super.getTextWidthU() + Menu_MapEditor_TradeZones_Edit.this.iNameWidth;
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.BUTTON_W * 2, true));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W * 2, true, CFG.brushMode));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W, true, CFG.selectMode));
        menuElements.add(new Button_Game_ColorPicker(CFG.BUTTON_W * 3 + CFG.PADD * 3, CFG.BUTTON_H + CFG.PADD * 3, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sName = CFG.lang.get("TheNameOfTradeZone");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sName + ": ");
        this.iNameWidth = (int)CFG.glyphLay.width;
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(3).setTextE(CFG.lang.get("CenterOfTrade"));
        this.getMenuElem(4).setTextE(CFG.lang.get("Brush"));
        this.getMenuElem(5).setTextE(CFG.lang.get("Add"));
        this.updateButtonWidth(3, CFG.PADD, CFG.BUTTON_W * 2);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_EdgeR(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Top_Edge_R(oSB, this.getMenuElem(4).getPosXE() - CFG.PADD + iTranslateX, this.getMenuElem(4).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(6).getPosXE() + this.getMenuElem(6).getWidthE() + CFG.PADD, this.getMenuElem(4).getHeightE() + CFG.PADD * 2);
        CFG.drawEditorButtons_Bot_Edge_R(oSB, this.getMenuElem(3).getPosXE() - CFG.PADD + iTranslateX, this.getMenuElem(3).getPosY() + this.getMenuPosY() - CFG.PADD + iTranslateY, this.getMenuElem(3).getWidthE() + CFG.PADD * 2, this.getMenuElem(3).getHeightE() + CFG.PADD * 2);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_TRADE_ZONES);
        CFG.menus.setBackAnimation(true);
        CFG.brushMode = false;
        CFG.menus.getColorPicker().setVisible(false, null);
        RenderProvince.updateDrawProvinces();
    }
}

