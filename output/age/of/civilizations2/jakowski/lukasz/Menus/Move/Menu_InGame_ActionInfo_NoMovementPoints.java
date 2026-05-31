
package age.of.civilizations2.jakowski.lukasz.Menus.Move;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

public class Menu_InGame_ActionInfo_NoMovementPoints
extends Menu {
    public Menu_InGame_ActionInfo_NoMovementPoints() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new TextActionInfo(null, 0 + AoCGame.LEFT, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) - CFG.BUTTON_H - CFG.PADD * 2){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_MOVEMENT_ZERO_ACTIVE : (this.getIsHovered() ? CFG.COLOR_MOVEMENT_ZERO_HOVER : CFG.COLOR_MOVEMENT_ZERO);
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("NoMovementPoints") + ".");
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.setVisibleM(false);
            }
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_Recruit();
    }
}

