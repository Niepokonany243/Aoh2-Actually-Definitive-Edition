
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.GenerateFlag;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.CivN.Menu_CreateNewGame_AddCiv;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_GenerateFlag
extends Menu {
    public Menu_GenerateFlag() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.flagManager.saveFlagTexture(oSB);
        CFG.toastM.addM(CFG.lang.get("Saved"), CFG.COLOR_HOVER_TITLE);
        this.onBackPressed();
    }

    @Override
    public void actionEL(int nMenuElementID) {
    }

    @Override
    public final void onBackPressed() {
        try {
            if (CFG.backToMenu == View.eINGAME_CREATE_VASSAL) {
                CFG.createVassalData.setCivTag(CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
            } else if (CFG.backToMenu == View.eCREATE_NEW_GAME) {
                Menu_CreateNewGame_AddCiv.civTag = CFG.EDITOR_ACTIVE_GAMEDATA_TAG;
            }
        }
        catch (Exception exception) {
            
        }
        CFG.menus.setMenuIDWithoutAnim(CFG.backToMenu);
        CFG.menus.setBackAnimation(true);
        CFG.map.getMpB().updateWorldMap_Shaders();
        RenderProvince.updateDrawProvinces();
    }
}

