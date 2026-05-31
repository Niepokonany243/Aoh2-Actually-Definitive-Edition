package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Game
extends ButtonM {
    public Button_Game(String sText, int iTextPositionX, int iPosX, int iPosY, int nWidth) {
        super.init(sText, iTextPositionX, iPosX, iPosY, nWidth, CFG.BUTTON_H, true, true, false, false, null);
    }

    public Button_Game(String sText, int iTextPositionX, int iPosX, int iPosY, boolean isClickable) {
        super.init(sText, iTextPositionX, iPosX, iPosY, CFG.BUTTON_W, CFG.BUTTON_H, isClickable, true, false, false, null);
    }

    public Button_Game(String sText, int iTextPositionX, int iPosX, int iPosY, int nWidth, boolean isClickable) {
        super.init(sText, iTextPositionX, iPosX, iPosY, nWidth, CFG.BUTTON_H, isClickable, true, false, false, null);
    }

    public Button_Game(String sText, int iTextPositionX, int iPosX, int iPosY, int nWidth, int nHeight, boolean isClickable) {
        super.init(sText, iTextPositionX, iPosX, iPosY, nWidth, nHeight, isClickable, true, false, false, null);
    }

    public Button_Game(String sText, int iTextPositionX, int iPosX, int iPosY, boolean isClickable, boolean isVisible) {
        super.init(sText, iTextPositionX, iPosX, iPosY, CFG.BUTTON_W, CFG.BUTTON_H, isClickable, isVisible, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (CFG.settingsGD.BETTER_UI) {
            Color primary = BetterUI_Manager.getPrimaryColor();
            Color bg = BetterUI_Manager.getBackgroundColor(0.9f);
            
            if (isActive) {
                oSB.setColor(primary.r, primary.g, primary.b, 0.5f);
            } else if (this.getIsHovered()) {
                oSB.setColor(primary.r, primary.g, primary.b, 0.3f);
            } else {
                oSB.setColor(bg);
            }
            Images.pix.draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());

            // Full borders like the map button
            BetterUI_Manager.drawBetterButtonBorder(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), this.getIsHovered(), isActive, this.getIsClickable());
            
            oSB.setColor(Color.WHITE);
            return;
        }
        if (isActive) {
            IMGManager.getIMG(Images.btnhClear).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.btnhClear).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnhClear).getWidth(), IMGManager.getIMG(Images.btnhClear).getHeight());
            IMGManager.getIMG(Images.btnhClear).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnhClear).getWidth() + iTranslateX, this.getPosY() + iTranslateY, true);
        } else {
            IMGManager.getIMG(Images.btnClear).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.btnClear).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnClear).getWidth(), IMGManager.getIMG(Images.btnClear).getHeight());
            IMGManager.getIMG(Images.btnClear).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnClear).getWidth() + iTranslateX, this.getPosY() + iTranslateY, true);
        }
    }

    @Override
    public Color getColorE(boolean isActive) {
        if (CFG.settingsGD.BETTER_UI) {
            if (isActive || this.getIsHovered()) return Color.WHITE;
            return BetterUI_Manager.getPrimaryColor();
        }
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_HOVERED : CFG.COLOR_BUTTON_GAME_TEXT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
    }
}

