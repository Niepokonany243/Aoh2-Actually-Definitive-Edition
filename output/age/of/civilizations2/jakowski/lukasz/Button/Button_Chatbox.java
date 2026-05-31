/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Chatbox
extends ButtonM {
    private String sExtraMessage;
    private int iMenuElementID;

    public Button_Chatbox(String nExtramessage, int nElementID, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        this.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
        this.iMenuElementID = nElementID;
        this.sExtraMessage = nExtramessage;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(0.023f, 0.023f, 0.023f, 0.45f));
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, this.getIsHovered() ? 0.35f : 0.125f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + 1 + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE() - 2, this.getHeightE() - 2, 1.0f);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (CFG.menus.getKeyboard().getVisibleM() && CFG.menus.getKeyboardActiveMenuElementID() == this.iMenuElementID) {
            if (isActive) {
                Renderer.drawText(oSB, this.fontID, CFG.keybMess, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 + iTranslateY, this.getColorE(isActive));
            } else {
                Renderer.drawText(oSB, this.fontID, CFG.keybMess, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 + iTranslateY, this.getColorE(isActive));
            }
        } else {
            Renderer.drawText(oSB, this.fontID, this.sExtraMessage, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT_SMALL / 2 + iTranslateY, this.getColorE(isActive));
        }
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }
}

