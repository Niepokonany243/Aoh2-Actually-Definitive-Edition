/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextTitleStyle
extends Text {
    public TextTitleStyle(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, CFG.FONT_BOLD_SMALL);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        IMGManager.getIMG(Images.dialog_title).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.dialog_title).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightE());
        IMGManager.getIMG(Images.dialog_title).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.dialog_title).getHeight() + iTranslateY, IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightE(), true, false);
        oSB.setColor(new Color(this.getColor_BG().r, this.getColor_BG().g, this.getColor_BG().b, 0.165f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + 2 + iTranslateX, this.getPosY() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthE() - 4, this.getHeightE() - 2 + iTranslateY, false, true);
        oSB.setColor(new Color(this.getColor_BG().r, this.getColor_BG().g, this.getColor_BG().b, 0.375f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + 2 + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthE() - 4, this.getHeightE() * 2 / 3 + iTranslateY, false, true);
        oSB.setColor(new Color(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.45f)));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + 2 + iTranslateX, this.getPosY() + this.getHeightE() - (this.getHeightE() - 2) * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() - 4, (this.getHeightE() - 2) * 2 / 3, false, true);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + 2 + iTranslateX, this.getPosY() + this.getHeightE() + iTranslateY, this.getWidthE() - 4);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightE() + iTranslateY, this.getWidthE() - 4, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + 2 + iTranslateX, this.getPosY() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightE() + iTranslateY, this.getWidthE() - 4, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + 2 + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightE() + iTranslateY, this.getWidthE() - 4, 1);
        oSB.setColor(Color.WHITE);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColor(isActive));
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_CIV_NAME : (this.getIsClickable() ? Color.WHITE : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    public Color getColor_BG() {
        return new Color(0.38039216f, 0.43137255f, 0.6627451f, 1.0f);
    }
}

