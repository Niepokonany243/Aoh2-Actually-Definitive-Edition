
package age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Provinces;

import age.of.civilizations2.jakowski.lukasz.Button.Button_ShowMenu;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.CivInfo.Menu_Civilization_Info;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_PeaceTreaty_Provinces_Show
extends Menu {
    public Menu_PeaceTreaty_Provinces_Show() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_ShowMenu(0, 0, CFG.BUTTON_W * 3 / 5, CFG.BUTTON_W * 3 / 5, true));
        int tempPosY = Math.max(Math.max(CFG.BUTTON_H * 4 / 5, Math.max(CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD) * 2 + CFG.PADD)) + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD);
        this.initMenu(null, CFG.GAMEWIDTH - CFG.BUTTON_W * 3 / 5, tempPosY, CFG.BUTTON_W * 3 / 5, CFG.BUTTON_W * 3 / 5 + 1, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_Civilization_Info.lTime + 250L >= System.currentTimeMillis()) {
            iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_Civilization_Info.lTime) / 250.0f));
            CFG.setRenderO(true);
        }
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.menus.setVisible_InGamePeaceTreatyProvinces(true);
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

