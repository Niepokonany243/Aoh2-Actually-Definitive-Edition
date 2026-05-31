
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Game_Decline
extends Button_Game {
    public Button_Game_Decline(int iPosX, int iPosY, boolean isClickable) {
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
            IMGManager.getIMG(Images.btnX).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnX).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnX).getHeight() / 2 + iTranslateY);
            
            oSB.setColor(Color.WHITE);
            return;
        }
        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
        if (isActive) {
            IMGManager.getIMG(Images.btnXActive).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnXActive).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnXActive).getHeight() / 2 + iTranslateY);
        } else {
            if (this.getIsHovered()) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
            }
            IMGManager.getIMG(Images.btnX).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnX).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnX).getHeight() / 2 + iTranslateY);
            oSB.setColor(Color.WHITE);
        }
    }
}

