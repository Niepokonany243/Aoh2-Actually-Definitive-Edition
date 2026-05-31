
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Game_Accept
extends Button_Game {
    private long lTimeAnimation = 0L;
    private int animationState = 0;
    private final int ANIMATION_T = 750;

    public Button_Game_Accept(int iPosX, int iPosY, boolean isClickable) {
        super("", 0, iPosX, iPosY, isClickable);
    }

    @Override
    public final void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (CFG.settingsGD != null && CFG.settingsGD.BETTER_UI) {
            Color primary = BetterUI_Manager.getPrimaryColor();
            Color bg = BetterUI_Manager.getBackgroundColor(0.9f);
            
            if (isActive) {
                oSB.setColor(primary.r, primary.g, primary.b, 0.5f);
            } else if (this.getIsHovered()) {
                oSB.setColor(primary.r, primary.g, primary.b, 0.25f);
            } else {
                oSB.setColor(bg);
            }
            Images.pix.draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());

            BetterUI_Manager.drawBetterButtonBorder(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), this.getIsHovered(), isActive, this.getIsClickable());

            oSB.setColor(primary.r, primary.g, primary.b, (this.getIsHovered() || isActive) ? 1.0f : 0.75f);
            IMGManager.getIMG(Images.btnV).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnV).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnV).getHeight() / 2 + iTranslateY);
            
            oSB.setColor(Color.WHITE);
            return;
        }
        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
        if (isActive) {
            IMGManager.getIMG(Images.btnVActive).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnVActive).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnVActive).getHeight() / 2 + iTranslateY);
        } else {
            if (this.getIsHovered()) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
            }
            IMGManager.getIMG(Images.btnV).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnV).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnV).getHeight() / 2 + iTranslateY);
            oSB.setColor(Color.WHITE);
        }
        if (this.animationState >= 0) {
            if (this.animationState == 0) {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - this.lTimeAnimation) / 750.0f, 1.0f);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, this.getIsHovered() ? 0.675f : 0.575f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (this.lTimeAnimation < System.currentTimeMillis() - 750L) {
                    ++this.animationState;
                    this.lTimeAnimation = System.currentTimeMillis();
                }
            } else {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - this.lTimeAnimation) / 750.0f, 1.0f);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, this.getIsHovered() ? 0.675f : 0.575f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (this.lTimeAnimation < System.currentTimeMillis() - 750L) {
                    this.animationState = 0;
                    this.lTimeAnimation = System.currentTimeMillis();
                }
            }
            CFG.setRenderO(true);
            oSB.setColor(Color.WHITE);
        }
    }
}

