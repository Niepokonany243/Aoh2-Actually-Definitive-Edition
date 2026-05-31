
package age.of.civilizations2.jakowski.lukasz.Button.Flag;

import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_InGameAction;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_InGameAction_War
extends Button_InGameAction {
    private long lTime = 0L;
    private float fAlphaMod = 0.0f;
    private boolean backAnimation = false;
    public SparksAnimation sparksAnimation = new SparksAnimation();

    public Button_InGameAction_War(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, isClickable);
    }

    public Button_InGameAction_War(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(SparksAnimation.sparksColors2);
        this.sparksAnimation.draw2(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(Color.WHITE);
        if (this.getIsHovered()) {
            if (this.lTime < System.currentTimeMillis() - 30L) {
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
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f - this.fAlphaMod));
            CFG.setRenderO(true);
        } else {
            this.backAnimation = false;
            this.fAlphaMod = 0.0f;
            this.lTime = System.currentTimeMillis();
        }
        IMGManager.getIMG(this.getIMG()).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(this.getIMG()).getWidth() + CFG.PADD) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(this.getIMG()).getHeight() / 2 + iTranslateY);
        oSB.setColor(Color.WHITE);
        Renderer.drawTextWithShadowAlpha(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - (this.getTextWidthU() + IMGManager.getIMG(this.getIMG()).getWidth() + CFG.PADD) / 2 + IMGManager.getIMG(this.getIMG()).getWidth() + CFG.PADD : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
    }

    public int getIMG() {
        return Images.diploWar;
    }
}

