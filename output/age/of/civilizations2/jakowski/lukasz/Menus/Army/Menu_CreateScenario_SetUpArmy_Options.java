
package age.of.civilizations2.jakowski.lukasz.Menus.Army;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_SetUpArmy_Options
extends Menu {
    public Menu_CreateScenario_SetUpArmy_Options() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, CFG.BUTTON_W * 2, true));
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.PADD, CFG.BUTTON_W, true));
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W * 3 + CFG.PADD * 3, CFG.PADD, CFG.BUTTON_W, true));
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W * 4 + CFG.PADD * 4, CFG.PADD, CFG.BUTTON_W, true));
        this.initMenu(null, 0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight(), CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.map.getMpB().getMinimapHeight(), menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("AddArmy"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Max") + ": -10000");
        this.getMenuElem(2).setTextE(CFG.lang.get("Max") + ": +10000");
        this.getMenuElem(3).setTextE(CFG.lang.get("NeutralArmy"));
        this.updatedButtonsWidth(CFG.PADD, CFG.BUTTON_W);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, this.getWidthM(), CFG.BUTTON_H + CFG.PADD * 2);
        oSB.setColor(CFG.COLOR_MINIMAP_BORDER);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, 1, this.getHeightM());
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                if (CFG.menus.getVisible_CreateScenario_SetUpArmies_Civs()) {
                    CFG.menus.setVisible_CreateScenario_SetUpArmies_Civs(false);
                    break;
                }
                CFG.menus.rebuildCreateScenario_SetUpArmies_Civs();
                break;
            }
            case 1: {
                if ((CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID -= 10000) < 10000) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = 10000;
                }
                ArrayList<String> tMess2 = new ArrayList<String>();
                ArrayList<Color> tColor2 = new ArrayList<Color>();
                tMess2.add(CFG.lang.get("Max"));
                tColor2.add(Color.WHITE);
                tMess2.add(CFG.getNumberWthSpaces("" + CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID));
                tColor2.add(CFG.COLOR_HOVER_TITLE);
                CFG.toastM.addM(tMess2, tColor2);
                CFG.menus.rebuildCreateScenario_SetUpArmies_Sliders();
                return;
            }
            case 2: {
                if ((CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID += 10000) > 1000000) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = 1000000;
                }
                ArrayList<String> tMess = new ArrayList<String>();
                ArrayList<Color> tColor = new ArrayList<Color>();
                tMess.add(CFG.lang.get("Max"));
                tColor.add(Color.WHITE);
                tMess.add(CFG.getNumberWthSpaces("" + CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID));
                tColor.add(CFG.COLOR_HOVER_TITLE);
                CFG.toastM.addM(tMess, tColor);
                CFG.menus.rebuildCreateScenario_SetUpArmies_Sliders();
                return;
            }
            case 3: {
                if (CFG.menus.getVisible_CreateScenario_SetUpArmies_Neutral()) {
                    CFG.menus.setVisible_CreateScenario_SetUpArmies_Neutral(false);
                } else {
                    CFG.menus.rebuildCreateScenario_SetUpArmies_Neutral();
                }
                return;
            }
        }
    }
}

