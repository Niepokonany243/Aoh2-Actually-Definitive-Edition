
package age.of.civilizations2.jakowski.lukasz.Menus.Religions.Editor;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_ReligionsEditor
extends Menu {
    public Menu_ReligionsEditor() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("AddNewReligion"));
        for (int i = 1; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(i - 1);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
    }
}

