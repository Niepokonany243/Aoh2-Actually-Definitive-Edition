/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Load;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Main.Menu_Main;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_LoadGame_Title
extends Menu {
    public Menu_LoadGame_Title() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempMenuWidth = Menu_Main.getMenuWidth_Default();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, tempMenuWidth, CFG.BUTTON_H, true));
        this.initMenuWithBackButton(null, Menu_Main.getMenuPosX_Default(), 0, tempMenuWidth, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        Core.drawMenuBG(oSB, this.getPosX() + iTranslateX, iTranslateY, this.getWidthM(), CFG.GAMEHEIGHT);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
            }
        }
        RenderProvince.updateDrawProvinces();
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eGAMES);
        CFG.menus.setBackAnimation(true);
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_LoadGame();
    }
}

