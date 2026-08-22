
package age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.ZRest.Slider_BG_ZeroInMiddle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slider_Relations
extends Slider_BG_ZeroInMiddle {
    public Slider_Relations(int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super(iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
    }

    public Slider_Relations(int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this(iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.drawSliderBG_UpdateAnimation();
        IMGManager.getIMG(Images.btnMenu1H).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - CFG.PADD + iTranslateY, this.getWidthE());
        if (this.getCurr() > 0L) {
            oSB.setColor(0.16862746f, 0.3019608f, 0.5137255f, 0.68f);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() - 1 + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX - this.getWidthE() / 2, this.getHeightE());
        } else if (this.getCurr() < 0L) {
            oSB.setColor(0.55f, 0.1f, 0.1f, 0.68f);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() / 2 - (this.iCurrentPosX + this.iDifference_CurrentPosX), this.getHeightE());
        }
        oSB.setColor(new Color(CFG.COLOR_SLIDER_BORDER.r, CFG.COLOR_SLIDER_BORDER.g, CFG.COLOR_SLIDER_BORDER.b, this.getIsClickable() ? 1.0f : 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX - 1 + iTranslateX, this.getPosY() - 1 + iTranslateY, 1, this.getHeightE());
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.7f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - 1 + iTranslateX, this.getPosY() - 1 + iTranslateY, 2, this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE.r, CFG.COLOR_NEW_GAME_EDGE_LINE.g, CFG.COLOR_NEW_GAME_EDGE_LINE.b, 0.4f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 + iTranslateY, 1, this.getHeightE() - 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 + iTranslateX, this.getPosY() - 1 + iTranslateY, 1, this.getHeightE() - 1);
        this.drawSliderText(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        oSB.setColor(Color.WHITE);
        if (this.getIsClickable()) {
            if (this.getIsHovered()) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.15f));
                IMGManager.getIMG(Images.btnMenu1H).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - CFG.PADD + iTranslateY, this.getWidthE());
                oSB.setColor(Color.WHITE);
            }
            if (isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.3f));
                IMGManager.getIMG(Images.btnMenu1H).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - CFG.PADD + iTranslateY, this.getWidthE());
                oSB.setColor(Color.WHITE);
            }
        }
    }

    @Override
    public void drawSliderText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        Renderer.drawText(oSB, this.fontID, this.getDrawText(), this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(0.945f, 0.945f, 0.945f, 1.0f));
        if (this.getCurr() > 0L) {
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "+" + this.getCurr());
            Renderer.drawText(oSB, this.fontID, "+" + this.getCurr(), this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)CFG.glyphLay.width + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(0.16862746f, 0.3019608f, 0.5137255f, 1.0f));
        } else if (this.getCurr() < 0L) {
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.getCurr());
            Renderer.drawText(oSB, this.fontID, "" + this.getCurr(), this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)CFG.glyphLay.width + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(0.55f, 0.1f, 0.1f, 1.0f));
        } else {
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.getCurr());
            Renderer.drawText(oSB, this.fontID, "" + this.getCurr(), this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)CFG.glyphLay.width + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(0.82f, 0.82f, 0.82f, 1.0f));
        }
    }
}
