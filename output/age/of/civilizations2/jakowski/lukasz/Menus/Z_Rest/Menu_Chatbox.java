
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Chatbox
extends Menu {
    public Menu_Chatbox() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        for (int i = 0; i < 10; ++i) {
            menuElements.add(new Text("Hej" + i, CFG.PADD, CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT * i + CFG.PADD * i));
        }
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H * 2, menuElements);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthM(), this.getHeightM());
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            default: 
        }
    }
}

