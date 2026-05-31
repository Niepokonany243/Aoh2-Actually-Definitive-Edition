/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Sliders.InGame;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_Budget;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slider_InGame_Goods
extends Slider_InGame {
    public int iconWidth;
    public int iconHeight;

    public Slider_InGame_Goods(String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super(sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
        int nIMGID = Images.goods;
        float iconScale = Slider_InGame_Goods.getImageScale(nIMGID);
        this.iconWidth = (int)((float)IMGManager.getIMG(nIMGID).getWidth() * iconScale);
        this.iconHeight = (int)((float)IMGManager.getIMG(nIMGID).getHeight() * iconScale);
    }

    public Slider_InGame_Goods(String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this(sText, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    public static final float getImageScale(int iImageID) {
        return Math.min(1.0f, (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(iImageID).getHeight());
    }

    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
        this.drawE(oSB, iTranslateX, iTranslateY, false, false);
    }

    @Override
    public void setCurr(long nCurrent) {
        super.setCurr(nCurrent);
        int tempSpend = (int)CFG.gameUpdate.getGoodsSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget);
        this.drawSpendings = tempSpend != 0;
        this.sSpendings = CFG.getNumberWthSpaces("" + tempSpend);
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sSpendings);
        this.iSpendingsWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void setCurr(int nCurrent) {
        this.setCurr((long)nCurrent);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
    }

    @Override
    public void drawTextLeft(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(Images.goods).draw(oSB, this.getPosXE() + CFG.PADD + (Menu_InGame_Budget.maxIconWidth - this.iconWidth) / 2 + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 - this.getSliderHeight() - this.iconHeight + iTranslateY, this.iconWidth, this.iconHeight);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD * 2 + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 - this.getSliderHeight() - CFG.TEXT_HEIGHT_DEFAULT + iTranslateY, this.getColor(isActive));
    }

    @Override
    public int getSliderHeight() {
        return CFG.PADD * 2;
    }
}
