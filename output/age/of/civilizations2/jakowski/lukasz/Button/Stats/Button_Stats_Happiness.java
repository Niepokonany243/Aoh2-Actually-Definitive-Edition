
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;

public class Button_Stats_Happiness
extends ButtonStats {
    public int iImageID;

    public Button_Stats_Happiness(float nHappiness, int iTextPosX, int iPosX, int iPosY, int iWidth, int iHeight) {
        super("" + (int)nHappiness + "%", iTextPosX, iPosX, iPosY, iWidth, iHeight);
        this.iImageID = CFG.getHappinessImage((int)nHappiness);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Rectangle clipBounds = new Rectangle(this.getPosXE() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.getWidthE(), this.getHeightE());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        IMGManager.getIMG(this.iImageID).drawO(oSB, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale()) / 2 - IMGManager.getIMG(this.iImageID).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale()));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getTextPosElem() + CFG.PADD + (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            
        }
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(this.iImageID).getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(this.iImageID).getHeight() : 1.0f;
    }
}

