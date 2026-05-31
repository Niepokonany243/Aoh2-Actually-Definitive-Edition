
package age.of.civilizations2.jakowski.lukasz.Menus.Top;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Top.Menu_CreateNewGame_Top;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_CreateNewGame_Top_Views
extends Menu {
    public Menu_CreateNewGame_Top_Views() {
        ArrayList menuElements = new ArrayList();
        this.updateLang();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBox).getHeight() + (iTranslateY -= (int)((float)CFG.GAMEHEIGHT * (100.0f - Menu_CreateNewGame_Top.fMovePercentage) / 100.0f)), this.getWidthM() - IMGManager.getIMG(Images.gameBox).getWidth(), this.getHeightM(), false, true);
        IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.gameBox).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBox).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameBox).getWidth(), this.getHeightM(), true, true);
        this.drawBackgroundMode(oSB, sliderMenuIsActive);
        Rectangle clipBounds = new Rectangle(this.getPosX() + 2 + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightM(), this.getWidthM() - 4, this.getHeightM());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            default: 
        }
    }
}

