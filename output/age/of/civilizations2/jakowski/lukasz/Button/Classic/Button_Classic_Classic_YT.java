
package age.of.civilizations2.jakowski.lukasz.Button.Classic;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Classic_Classic_YT
extends Button_Classic {
    public Button_Classic_Classic_YT(int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(null, 0, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    public Button_Classic_Classic_YT(int nID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(null, nID, iPosX, iPosY, iWidth, iHeight, isClickable);
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
        }
        if (isActive || this.getIsHovered()) {
            IMGManager.getIMG(Images.btnHMenuH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), true, false);
        } else {
            IMGManager.getIMG(Images.btnMenuH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), true, false);
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }

    @Override
    public int getCurr() {
        return this.iTextPositionX;
    }
}
