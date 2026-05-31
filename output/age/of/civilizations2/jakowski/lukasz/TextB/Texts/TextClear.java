
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextClear
extends Text {
    private int iTurnID = 0;
    private int iLogID = 0;

    public TextClear(int iTurnID, int iLogID, int iPosX, int iPosY, int iWidth, int iHeight) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.iTurnID = iTurnID;
        this.iLogID = iLogID;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.setHeightE(iHeight);
        this.setTextE("");
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
    }

    @Override
    public int getCurr() {
        return this.iLogID;
    }

    @Override
    public int getTextPosElem() {
        return this.iTurnID;
    }
}

