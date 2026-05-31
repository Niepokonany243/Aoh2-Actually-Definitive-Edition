/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.NewGame;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.Button_ShowMenu;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.CivInfo.Menu_Civilization_Info;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateNewGame_ShowCivInfo
extends Menu {
    public Menu_CreateNewGame_ShowCivInfo() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_ShowMenu(0, 0, CFG.BUTTON_W * 3 / 5, CFG.BUTTON_W * 3 / 5, true));
        this.initMenu(null, CFG.GAMEWIDTH - CFG.BUTTON_W * 3 / 5, IMGManager.getIMG(Images.gameTop).getHeight() + CFG.PADD * 4 + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.6f), CFG.BUTTON_W * 3 / 5, CFG.BUTTON_W * 3 / 5 + 1, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_Civilization_Info.lTime + 250L >= System.currentTimeMillis()) {
            iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_Civilization_Info.lTime) / 250.0f));
            CFG.setRenderO(true);
        }
        if (CFG.settingsGD.BETTER_UI) {
            BetterUI_Manager.drawBetterMenuBG(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM());
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            return;
        }
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.menus.setVisible_CreateNewGame_CivInfo(true);
            }
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible && !this.getVisibleM()) {
            Menu_Civilization_Info.lTime = System.currentTimeMillis();
        }
        super.setVisibleM(visible);
    }
}

