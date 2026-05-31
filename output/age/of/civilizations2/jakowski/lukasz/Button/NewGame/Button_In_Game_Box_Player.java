
package age.of.civilizations2.jakowski.lukasz.Button.NewGame;

import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Menu_CreateNewGame;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;

public class Button_In_Game_Box_Player
extends Button_InGameBox {
    private long lTime = 0L;
    private float fAlphaMod = 0.0f;
    private boolean backAnimation = false;
    private long lTimeAnimation = 0L;
    private int animationState = 0;
    public static final int ANIMATION_T = 1500;
    public SparksAnimation sparksAnimation = new SparksAnimation();
    public String challenge = CFG.lang.get("Challenge") + ": ";

    public Button_In_Game_Box_Player(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, isClickable);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
        if (this.lTime < System.currentTimeMillis() - 26L) {
            if (this.backAnimation) {
                this.fAlphaMod -= 0.02f;
                if (this.fAlphaMod < 0.0f) {
                    this.backAnimation = false;
                }
            } else {
                this.fAlphaMod += 0.02f;
                if (this.fAlphaMod > 0.3f) {
                    this.backAnimation = true;
                }
            }
            this.lTime = System.currentTimeMillis();
        }
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.225f - this.fAlphaMod));
        CFG.setRenderO(true);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
        IMGManager.getIMG(Images.gradientXY).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.gradientXY).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
        if (this.animationState >= 0) {
            if (this.animationState == 0) {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - this.lTimeAnimation) / 1500.0f, 1.0f);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, this.getIsHovered() ? 0.425f : 0.325f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (this.lTimeAnimation < System.currentTimeMillis() - 1500L) {
                    ++this.animationState;
                    this.lTimeAnimation = System.currentTimeMillis();
                }
            } else {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - this.lTimeAnimation) / 1500.0f, 1.0f);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, this.getIsHovered() ? 0.425f : 0.325f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (this.lTimeAnimation < System.currentTimeMillis() - 1500L) {
                    this.animationState = 0;
                    this.lTimeAnimation = System.currentTimeMillis();
                }
            }
        }
        oSB.setColor(SparksAnimation.sparksColors);
        this.sparksAnimation.draw2(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        try {
            Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getPlayer(0).getCivId());
            Rectangle clipBounds = new Rectangle(this.getPosXE() + CFG.CIV_FLAG_WIDTH + CFG.PADD * 3 + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE() - (CFG.CIV_FLAG_WIDTH + CFG.PADD * 4), this.getHeightE());
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            Renderer.drawText(oSB, this.fontID, CFG.core.getPlayer(0).getCivId() < 0 ? CFG.RANDOM_CIVILIZATION : (Menu_CreateNewGame.CHALLENGE_MODE_NG >= 0 ? this.challenge : "") + CFG.core.getCiv(CFG.core.getPlayer(0).getCivId()).getCivName(), this.getPosXE() + IMGManager.getIMG(Images.flagRect2).getWidth() + CFG.PADD * 3 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, this.getColorE(isActive));
            try {
                oSB.flush();
                ScissorStack.popScissors();
            }
            catch (IllegalStateException illegalStateException) {}
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            
        }
    }

    @Override
    public Color getColorE(boolean isActive) {
        if (Menu_CreateNewGame.CHALLENGE_MODE_NG >= 0 && !this.getIsHovered()) {
            return CFG.COLOR_TEXT_NUM_OF_PROVINCES;
        }
        return Colors.getColorTopStats2(isActive, this.getIsHovered());
    }
}

