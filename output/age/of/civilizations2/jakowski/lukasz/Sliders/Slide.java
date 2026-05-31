/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Sliders;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slide
extends MenuElemUI {
    public Slide(int iPosX, int iPosY, boolean visible) {
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(IMGManager.getIMG(Images.slideBG).getWidth() * 2);
        this.setHeightE(IMGManager.getIMG(Images.slideBG).getHeight() * 2);
        this.setVisibleE(visible);
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.SLIDE;
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (isActive) {
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.85f);
        }
        IMGManager.getIMG(Images.slideBG).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY);
        IMGManager.getIMG(Images.slideBG).drawO(oSB, this.getPosXE() + IMGManager.getIMG(Images.slideBG).getWidth() + iTranslateX, this.getPosY() + iTranslateY, true);
        IMGManager.getIMG(Images.slideBG).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + IMGManager.getIMG(Images.slideBG).getHeight() + iTranslateY, false, true);
        IMGManager.getIMG(Images.slideBG).drawO(oSB, this.getPosXE() + IMGManager.getIMG(Images.slideBG).getWidth() + iTranslateX, this.getPosY() + IMGManager.getIMG(Images.slideBG).getHeight() + iTranslateY, true, true);
        oSB.setColor(Color.WHITE);
    }
}

