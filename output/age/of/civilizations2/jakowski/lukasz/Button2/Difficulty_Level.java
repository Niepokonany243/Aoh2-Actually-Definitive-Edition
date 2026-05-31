
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Difficulty_Level
extends MenuElemUI {
    public static final Color COLOR_BG = new Color(0.05490196f, 0.07450981f, 0.11764706f, 1.0f);
    private float fPercentage = 1.0f;
    private long lTime = 0L;
    public int iCurrentPosX = 0;

    public Difficulty_Level(int iPosX, int iPosY, int iWidth, int iHeight, float fPercentage) {
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.setHeightE(iHeight);
        this.fPercentage = fPercentage;
        this.updateSlider(-1);
        this.lTime = System.currentTimeMillis();
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.BUTTON;
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (System.currentTimeMillis() < this.lTime + 425L) {
            this.iCurrentPosX = (int)((float)this.getWidthE() * this.fPercentage * ((float)(System.currentTimeMillis() - this.lTime) / 425.0f));
            this.iCurrentPosX = (int)Math.min((float)this.iCurrentPosX, (float)this.getWidthE() * this.fPercentage);
        } else {
            this.iCurrentPosX = (int)((float)this.getWidthE() * this.fPercentage);
        }
        oSB.setColor(COLOR_BG);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.5f));
        Renderer.drawBox3(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() - 1 + iTranslateY, this.iCurrentPosX, this.getHeightE(), 1.0f);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.difficultyBox).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.difficultyBox).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.difficultyBox).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.difficultyBox).getHeight());
        IMGManager.getIMG(Images.difficultyBox).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.difficultyBox).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.difficultyBox).getHeight() + iTranslateY, IMGManager.getIMG(Images.difficultyBox).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.difficultyBox).getHeight(), true);
        IMGManager.getIMG(Images.difficultyBox).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.difficultyBox).getHeight() * 2 + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.difficultyBox).getWidth(), IMGManager.getIMG(Images.difficultyBox).getHeight(), false, true);
        IMGManager.getIMG(Images.difficultyBox).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.difficultyBox).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.difficultyBox).getHeight() + iTranslateY, true, true);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.fPercentage = (float)nCurrent / 100.0f;
        this.lTime = System.currentTimeMillis();
    }

    @Override
    public int getCurr() {
        return (int)(this.fPercentage * 100.0f);
    }
}

