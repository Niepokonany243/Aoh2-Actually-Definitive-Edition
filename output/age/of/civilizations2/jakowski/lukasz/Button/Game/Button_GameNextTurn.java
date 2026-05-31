/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_GameNextTurn
extends Button_Game {
    private long lTime = 0L;
    private float fAlphaMod = 0.0f;
    private boolean backAnimation = false;
    private long lTimeAnimation = System.currentTimeMillis();
    private int animationState = 0;
    public static final int ANIMATION_T = 1000;

    public Button_GameNextTurn(String sText, int iTextPositionX, int iPosX, int iPosY, int nWidth, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, nWidth, isClickable);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
        if (this.getIsClickable() && (this.getIsHovered() || isActive || CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() < 8 || CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.INPUT_ORDERS)) {
            if (this.lTime < System.currentTimeMillis() - 26L) {
                if (this.backAnimation) {
                    this.fAlphaMod -= 0.02f;
                    if (this.fAlphaMod < 0.0f) {
                        this.backAnimation = false;
                    }
                } else {
                    this.fAlphaMod += 0.02f;
                    if (this.fAlphaMod > 0.4f) {
                        this.backAnimation = true;
                    }
                }
                this.lTime = System.currentTimeMillis();
            }
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, (CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.INPUT_ORDERS ? 0.775f : 0.45f) - this.fAlphaMod));
            CFG.setRenderO(true);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
            if (this.animationState >= 0) {
                if (this.animationState == 0) {
                    float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - this.lTimeAnimation) / 1000.0f, 1.0f);
                    oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, this.getIsHovered() ? 0.625f : 0.525f));
                    IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                    IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                    if (this.lTimeAnimation < System.currentTimeMillis() - 1000L) {
                        ++this.animationState;
                        this.lTimeAnimation = System.currentTimeMillis();
                    }
                } else {
                    float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - this.lTimeAnimation) / 1000.0f, 1.0f);
                    oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, this.getIsHovered() ? 0.625f : 0.525f));
                    IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                    IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                    if (this.lTimeAnimation < System.currentTimeMillis() - 1000L) {
                        this.animationState = 0;
                        this.lTimeAnimation = System.currentTimeMillis();
                    }
                }
                CFG.setRenderO(true);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void setIsHovered(boolean isHovered) {
        super.setIsHovered(isHovered);
        this.lTime = System.currentTimeMillis();
    }

    @Override
    public Color getColorE(boolean isActive) {
        if (CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.INPUT_ORDERS) {
            return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
        }
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_HOVERED : CFG.COLOR_BUTTON_GAME_TEXT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
    }
}

