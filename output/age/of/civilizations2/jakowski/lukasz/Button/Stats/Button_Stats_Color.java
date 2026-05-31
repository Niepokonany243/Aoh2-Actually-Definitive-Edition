
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;

public class Button_Stats_Color
extends ButtonStats {
    public Color oColor;

    public Button_Stats_Color(Color oColor, String sText, int iTextPosX, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(sText, iTextPosX, iPosX, iPosY, iWidth, iHeight);
        this.oColor = oColor;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Rectangle clipBounds = new Rectangle(this.getPosXE() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE(), this.getHeightE());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        oSB.setColor(this.oColor);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 2, this.iTextHeight);
        oSB.setColor(Color.WHITE);
        super.drawTextE(oSB, 2 + CFG.PADD + iTranslateX, iTranslateY, isActive);
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
    }
}

