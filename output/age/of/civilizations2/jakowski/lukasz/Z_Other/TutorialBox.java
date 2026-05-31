/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Z_Other;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TutorialBox {
    private String sText;
    private int iTextWidth;

    public TutorialBox(String sText) {
        this.sText = sText;
        CFG.glyphLay.setText(CFG.fontMain.get(0), sText);
        this.iTextWidth = (int)CFG.glyphLay.width;
    }

    public void draw(SpriteBatch oSB) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + CFG.PADD, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), this.getWidth() - CFG.PADD * 2, this.getHeight());
        oSB.setColor(CFG.COLOR_NEUTRAL);
        IMGManager.getIMG(Images.line32).draw2O(oSB, this.getPosX() + CFG.PADD, this.getPosY() + 1 - IMGManager.getIMG(Images.line32).getHeight(), this.getWidth() - CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.line32).draw2O(oSB, this.getPosX() + CFG.PADD, this.getPosY() + this.getHeight() - 2 - IMGManager.getIMG(Images.line32).getHeight(), this.getWidth() - CFG.PADD * 2, 1);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX(), this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.PADD, this.getHeight(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getWidth() - CFG.PADD, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.PADD, this.getHeight());
        CFG.drawTextDefault(oSB, this.sText, this.getPosX() + this.getWidth() / 2 - this.iTextWidth / 2, this.getPosY() + this.getHeight() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2, Color.BLACK);
    }

    public int getPosX() {
        return 0;
    }

    public int getPosY() {
        return 0;
    }

    public int getWidth() {
        return CFG.PADD * 4 + this.iTextWidth;
    }

    public int getHeight() {
        return CFG.PADD * 2 + CFG.TEXT_HEIGHT_DEFAULT;
    }
}

