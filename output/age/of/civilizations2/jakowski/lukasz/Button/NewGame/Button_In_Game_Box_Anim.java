
package age.of.civilizations2.jakowski.lukasz.Button.NewGame;

import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_In_Game_Box_Anim
extends Button_InGameBox {
    public static long lTimeAnimation = 0L;
    public static int animationState = 0;
    public static final int ANIMATION_T = 750;

    public Button_In_Game_Box_Anim(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, isClickable);
    }

    public Button_In_Game_Box_Anim(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            IMGManager.getIMG(Images.gameBoxHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBoxHover).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.gameBoxHover).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.gameBoxHover).getHeight());
            IMGManager.getIMG(Images.gameBoxHover).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.gameBoxHover).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBoxHover).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameBoxHover).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.gameBoxHover).getHeight(), true);
            IMGManager.getIMG(Images.gameBoxHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBoxHover).getHeight() * 2 + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.gameBoxHover).getWidth(), IMGManager.getIMG(Images.gameBoxHover).getHeight(), false, true);
            IMGManager.getIMG(Images.gameBoxHover).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.gameBoxHover).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBoxHover).getHeight() * 2 + iTranslateY, IMGManager.getIMG(Images.gameBoxHover).getWidth(), IMGManager.getIMG(Images.gameBoxHover).getHeight(), true, true);
        } else {
            IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBox).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.gameBox).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.gameBox).getHeight());
            IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.gameBox).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBox).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameBox).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.gameBox).getHeight(), true);
            IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBox).getHeight() * 2 + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.gameBox).getWidth(), IMGManager.getIMG(Images.gameBox).getHeight(), false, true);
            IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.gameBox).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBox).getHeight() * 2 + iTranslateY, IMGManager.getIMG(Images.gameBox).getWidth(), IMGManager.getIMG(Images.gameBox).getHeight(), true, true);
        }
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.215f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 4);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.325f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        if (this.getIsClickable() && this.getIsHovered() && animationState >= 0) {
            if (animationState == 0) {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - lTimeAnimation) / 750.0f, 1.0f);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.375f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (lTimeAnimation < System.currentTimeMillis() - 750L) {
                    ++animationState;
                    lTimeAnimation = System.currentTimeMillis();
                }
            } else {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - lTimeAnimation) / 750.0f, 1.0f);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.375f));
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
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void setIsHovered(boolean isHovered) {
        super.setIsHovered(isHovered);
        lTimeAnimation = System.currentTimeMillis();
        animationState = 0;
    }
}

