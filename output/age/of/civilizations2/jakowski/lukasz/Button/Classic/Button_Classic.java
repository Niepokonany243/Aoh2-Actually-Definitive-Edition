
package age.of.civilizations2.jakowski.lukasz.Button.Classic;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Classic
extends ButtonM {
    public static long lTimeAnimation = 0L;
    public static int animationState = 0;
    public static final int ANIMATION_T = 750;

    public Button_Classic(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
    }

    public Button_Classic(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, int fontID) {
        this.fontID = fontID;
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
    }

    public Button_Classic(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkboxState) {
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, true, checkboxState, null);
    }

    public Button_Classic(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkboxState, int fontID) {
        this.fontID = fontID;
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, true, checkboxState, null);
    }

    public void setButtonAlpha(SpriteBatch oSB, boolean isActive) {
        if (isActive) {
            oSB.setColor(Color.WHITE);
        } else if (this.getIsHovered() && this.getIsClickable()) {
            oSB.setColor(CFG.COLOR_BUTTON_MENU_HOVER_BG);
        } else {
            oSB.setColor(Color.WHITE);
        }
    }

    @Override
    public Color getColorE(boolean isActive) {
        if (CFG.settingsGD.BETTER_UI) {
            Color primary = BetterUI_Manager.getPrimaryColor();
            if (isActive) return Color.WHITE;
            if (!this.getIsClickable()) return new Color(0.5f, 0.5f, 0.5f, 0.5f);
            if (this.getIsHovered()) return Color.WHITE;
            return new Color(primary.r, primary.g, primary.b, 1.0f);
        }
        return isActive ? CFG.COLOR_BUTTON_MENU_TEXT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_MENU_TEXT_HOVERED : CFG.COLOR_BUTTON_MENU_TEXT) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (CFG.settingsGD.BETTER_UI) {
            Color primary = BetterUI_Manager.getPrimaryColor();
            Color bg = BetterUI_Manager.getBackgroundColor(0.9f);
            
            if (isActive) {
                oSB.setColor(primary.r, primary.g, primary.b, 0.45f);
            } else if (this.getIsHovered()) {
                oSB.setColor(primary.r, primary.g, primary.b, 0.2f);
            } else {
                oSB.setColor(bg);
            }
            Images.pix.draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());

            
            BetterUI_Manager.drawBetterButtonBorder(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), this.getIsHovered(), isActive, this.getIsClickable());

            oSB.setColor(Color.WHITE);
            return;
        } else {
            this.setButtonAlpha(oSB, isActive);
            if (isActive) {
                IMGManager.getIMG(Images.btnHMenuH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE());
            } else if (this.getIsHovered() && this.getIsClickable()) {
                IMGManager.getIMG(Images.btnMenuH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE());
            } else {
                IMGManager.getIMG(Images.btnMenuH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE());
            }
            oSB.setColor(Color.WHITE);
        }

        if (!CFG.settingsGD.BETTER_UI && this.getIsClickable() && this.getIsHovered() && !isActive && animationState >= 0) {
            if (animationState == 0) {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - lTimeAnimation) / 750.0f, 1.0f);
                oSB.setColor(Button_Classic.getColorLine());
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (lTimeAnimation < System.currentTimeMillis() - 750L) {
                    ++animationState;
                    lTimeAnimation = System.currentTimeMillis();
                }
            } else {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - lTimeAnimation) / 750.0f, 1.0f);
                oSB.setColor(Button_Classic.getColorLine());
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (lTimeAnimation < System.currentTimeMillis() - 750L) {
                    animationState = 0;
                    lTimeAnimation = System.currentTimeMillis();
                }
            }
            CFG.setRenderO(true);
            oSB.setColor(Color.WHITE);
        }
    }

    @Override
    public void setIsHovered(boolean isHovered) {
        super.setIsHovered(isHovered);
        lTimeAnimation = System.currentTimeMillis();
        animationState = 0;
    }

    public static final Color getColorLine() {
        return new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.675f);
    }
}

