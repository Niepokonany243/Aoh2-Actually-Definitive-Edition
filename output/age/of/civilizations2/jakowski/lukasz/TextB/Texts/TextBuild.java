/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextBuild
extends Text {
    public static final float TEXT_SCALE = 0.7f;

    public TextBuild(String sText, int iPosX, int iPosY) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setHeightE(CFG.TEXT_HEIGHT_DEFAULT);
        this.setTextE(sText);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        CFG.fontMain.get(0).getData().setScale(0.7f);
        CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.7f) / 2.0f) + iTranslateY, this.getColor(isActive));
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }
}

