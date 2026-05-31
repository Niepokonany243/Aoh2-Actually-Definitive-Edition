
package age.of.civilizations2.jakowski.lukasz.Menus.Pallet;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.Minimap;
import age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios.Menu_CreateScenario;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_PalletOfColors
extends Menu_CreateScenario {
    private String sTopText;
    private int iStepWidth;

    public Menu_CreateScenario_PalletOfColors() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true));
        menuElements.add(new Minimap(CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight()));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.getMenuElem(2).setVisibleE(false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sTopText = CFG.lang.get("PalletCivColors");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sTopText);
        this.iStepWidth = (int)CFG.glyphLay.width;
        super.updateLang();
        this.getMenuElem(1).setTextE(CFG.lang.get("Save"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_Edge_LR(oSB, iTranslateX, this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawTextDefaultWithShadow(oSB, this.sTopText, CFG.GAMEWIDTH / 2 - this.iStepWidth / 2 + iTranslateX, CFG.BUTTON_H / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + CFG.PADD + this.getMenuPosY() + iTranslateY, Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 1: {
                this.onBackPressed();
                return;
            }
        }
        super.actionEL(iID);
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_SETTINGS);
    }
}

