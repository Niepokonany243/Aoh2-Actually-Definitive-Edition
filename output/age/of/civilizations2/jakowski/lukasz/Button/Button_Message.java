
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Message
extends ButtonM {
    public static final float BUTTON_PERC_HEIGHT = 0.7f;
    private long lTime = 0L;
    private float fAlphaMod = 0.0f;
    private boolean backAnimation = false;
    private int iMessageID = 0;
    private int iFromCivID = 0;
    private int iImageID;
    private int iBGImageID;
    private long lTimeAnimation = 0L;
    private int animationState = 0;
    public static final int ANIMATION_T = 750;

    public Button_Message(int iPosX, int iPosY, int iMessageID, int iFromCivID, int iImageID, int iBGImageID) {
        super.init("", -1, iPosX, iPosY, ButtonDiplomacy.iDiploWidth + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 4, (int)((float)CFG.BUTTON_H * 0.7f), true, true, false, false);
        this.iMessageID = iMessageID;
        this.iFromCivID = iFromCivID;
        this.iImageID = iImageID;
        this.iBGImageID = iBGImageID;
        this.lTimeAnimation = System.currentTimeMillis();
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
        IMGManager.getIMG(this.iBGImageID).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(this.iBGImageID).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(this.iBGImageID).getWidth(), this.getHeightE() - IMGManager.getIMG(this.iBGImageID).getHeight(), false, false);
        IMGManager.getIMG(this.iBGImageID).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(this.iBGImageID).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(this.iBGImageID).getHeight() + iTranslateY, IMGManager.getIMG(this.iBGImageID).getWidth(), this.getHeightE() - IMGManager.getIMG(this.iBGImageID).getHeight(), true, false);
        IMGManager.getIMG(this.iBGImageID).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(this.iBGImageID).getHeight() - IMGManager.getIMG(this.iBGImageID).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(this.iBGImageID).getWidth(), IMGManager.getIMG(this.iBGImageID).getHeight(), false, true);
        IMGManager.getIMG(this.iBGImageID).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(this.iBGImageID).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(this.iBGImageID).getHeight() - IMGManager.getIMG(this.iBGImageID).getHeight() + iTranslateY, IMGManager.getIMG(this.iBGImageID).getWidth(), IMGManager.getIMG(this.iBGImageID).getHeight(), true, true);
        if (this.getIsHovered() || isActive) {
            if (this.iBGImageID == Images.messages_r) {
                oSB.setColor(new Color(0.3137255f, 0.13725491f, 0.047058824f, 0.475f - this.fAlphaMod));
            } else if (this.iBGImageID == Images.messages_g) {
                oSB.setColor(new Color(0.13333334f, 0.23529412f, 0.02745098f, 0.475f - this.fAlphaMod));
            } else {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.475f - this.fAlphaMod));
            }
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 4);
        }
        if (this.animationState >= 0) {
            if (this.animationState == 0) {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - this.lTimeAnimation) / 750.0f, 1.0f);
                oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE2.r, CFG.COLOR_NEW_GAME_EDGE_LINE2.g, CFG.COLOR_NEW_GAME_EDGE_LINE2.b, 0.65f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (this.lTimeAnimation < System.currentTimeMillis() - 750L) {
                    ++this.animationState;
                    this.lTimeAnimation = System.currentTimeMillis();
                }
            } else {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - this.lTimeAnimation) / 750.0f, 1.0f);
                oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE2.r, CFG.COLOR_NEW_GAME_EDGE_LINE2.g, CFG.COLOR_NEW_GAME_EDGE_LINE2.b, 0.65f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (this.lTimeAnimation < System.currentTimeMillis() - 750L) {
                    this.animationState = 0;
                    this.lTimeAnimation = System.currentTimeMillis();
                }
            }
            CFG.setRenderO(true);
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawFlagRect(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.flagRect2).getWidth() - CFG.PADD * 3 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iFromCivID);
        if (this.getIsHovered() || this.iImageID == Images.diploWar) {
            if (this.lTime < System.currentTimeMillis() - 30L) {
                if (this.backAnimation) {
                    this.fAlphaMod -= 0.02f;
                    if (this.fAlphaMod < 0.0f) {
                        this.backAnimation = false;
                    }
                } else {
                    this.fAlphaMod += 0.02f;
                    if (this.fAlphaMod >= 0.5f) {
                        this.backAnimation = true;
                    }
                }
                this.lTime = System.currentTimeMillis();
            }
            if (this.iImageID == Images.diploWar) {
                oSB.setColor(new Color(0.39215687f, 0.19607843f, 0.078431375f, 1.0f - this.fAlphaMod));
                IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + 2 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD, false, true);
                IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - 2 + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD);
            }
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f - this.fAlphaMod));
        } else {
            this.backAnimation = false;
            this.fAlphaMod = 0.0f;
            this.lTime = System.currentTimeMillis();
        }
        IMGManager.getIMG(this.iImageID).drawO(oSB, this.getPosXE() + CFG.PADD * 3 + (ButtonDiplomacy.iDiploWidth - CFG.PADD * 4) / 2 - IMGManager.getIMG(this.iImageID).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(this.iImageID).getHeight() / 2 + iTranslateY);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return this.getIsClickable() ? (isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_INFO_HOVER : CFG.COLOR_TEXT_CIV_INFO)) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.65f);
    }

    @Override
    public int getCurr() {
        return this.iMessageID;
    }

    @Override
    public void buildElemHover() {
        try {
            this.menuElemHover = CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage(this.iMessageID).getHover();
        }
        catch (IndexOutOfBoundsException ex) {
            this.menuElemHover = null;
        }
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }

    @Override
    public void actionElemPPM() {
        CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.removeMessage(this.iMessageID);
        CFG.menus.rebuildInGame_Messages();
    }
}

