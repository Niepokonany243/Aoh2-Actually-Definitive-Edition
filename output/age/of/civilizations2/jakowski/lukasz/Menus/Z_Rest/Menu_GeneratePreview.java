
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_GeneratePreview
extends Menu {
    public Menu_GeneratePreview() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.map.getMpB().saveScenarioMinimapPreviewTexture(oSB);
        CFG.toastM.addM(CFG.lang.get("Saved"), CFG.COLOR_HOVER_TITLE);
        this.onBackPressed();
    }

    @Override
    public void actionEL(int nMenuElementID) {
        this.onBackPressed();
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuIDWithoutAnim(CFG.backToMenu);
        CFG.menus.setBackAnimation(true);
    }
}

