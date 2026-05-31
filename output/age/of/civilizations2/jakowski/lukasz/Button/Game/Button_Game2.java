
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.RandomTurnOrder;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Game2
extends ButtonM {
    public String sText2 = null;
    public int fontID2 = 1;
    public int iTextWidth2 = -1;
    public int iTextHeight2 = -1;

    public Button_Game2(String sText, String sText2, int iTextPositionX, int iPosX, int iPosY, int nWidth) {
        super.init(sText, iTextPositionX, iPosX, iPosY, nWidth, CFG.BUTTON_H, true, true, false, false, null);
        this.fontID2 = CFG.FONT_REGULAR_SMALL;
        this.setText2(sText2);
    }

    public Button_Game2(String sText, String sText2, int iTextPositionX, int iPosX, int iPosY, boolean isClickable) {
        super.init(sText, iTextPositionX, iPosX, iPosY, CFG.BUTTON_W, CFG.BUTTON_H, isClickable, true, false, false, null);
        this.fontID2 = CFG.FONT_REGULAR_SMALL;
        this.setText2(sText2);
    }

    public Button_Game2(String sText, String sText2, int iTextPositionX, int iPosX, int iPosY, int nWidth, boolean isClickable) {
        super.init(sText, iTextPositionX, iPosX, iPosY, nWidth, CFG.BUTTON_H, isClickable, true, false, false, null);
        this.fontID2 = CFG.FONT_REGULAR_SMALL;
        this.setText2(sText2);
    }

    public Button_Game2(String sText, String sText2, int iTextPositionX, int iPosX, int iPosY, boolean isClickable, boolean isVisible) {
        super.init(sText, iTextPositionX, iPosX, iPosY, CFG.BUTTON_W, CFG.BUTTON_H, isClickable, isVisible, false, false, null);
        this.fontID2 = CFG.FONT_REGULAR_SMALL;
        this.setText2(sText2);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            IMGManager.getIMG(Images.btnhClear).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.btnhClear).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnhClear).getWidth(), IMGManager.getIMG(Images.btnhClear).getHeight());
            IMGManager.getIMG(Images.btnhClear).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnhClear).getWidth() + iTranslateX, this.getPosY() + iTranslateY, true);
        } else {
            IMGManager.getIMG(Images.btnClear).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.btnClear).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnClear).getWidth(), IMGManager.getIMG(Images.btnClear).getHeight());
            IMGManager.getIMG(Images.btnClear).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnClear).getWidth() + iTranslateX, this.getPosY() + iTranslateY, true);
        }
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
        Renderer.drawTextWithShadow(oSB, this.fontID2, this.sText2, iTranslateX + this.getWidthE() / 2 - this.iTextWidth2 / 2, iTranslateY + this.getHeightE() / 2 + this.iTextHeight / 2 + CFG.PADD, this.getColor2(isActive));
    }

    public static String getGlyphText() {
        return RandomTurnOrder.getSGly();
    }

    protected Color getColor2(boolean isActive) {
        return Colors.TEXT_TOP_BOT;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_HOVERED : CFG.COLOR_BUTTON_GAME_TEXT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
    }

    @Override
    public void setText2(String sText2) {
        this.sText2 = sText2;
        try {
            Renderer.glyphLayout.setText(CFG.fontMain.get(this.fontID2), sText2);
            this.iTextWidth2 = (int)Renderer.glyphLayout.width;
            this.iTextHeight2 = (int)Renderer.glyphLayout.height;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }
}

