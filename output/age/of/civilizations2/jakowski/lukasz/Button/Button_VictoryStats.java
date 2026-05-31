
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_VictoryStats
extends ButtonM {
    private boolean row = true;
    private String sPopulation;
    private int iPopulationWidth = 0;
    private Color colorRight;
    private int iImageID = -1;

    public Button_VictoryStats(String sLeft, String nRight, Color colorRight, int iImageID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(nRight, 0, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
        this.colorRight = colorRight;
        this.iImageID = iImageID;
        this.sPopulation = sLeft;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sPopulation);
        this.iPopulationWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive || this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.65f));
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.9f));
        }
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), false, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() * 4 / 5, this.getHeightE(), false, false);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
        oSB.setColor(Color.WHITE);
        try {
            CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        catch (NullPointerException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sPopulation, this.getPosXE() + CFG.PADD * 3 + CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD * 3 + CFG.CIV_FLAG_WIDTH + this.iPopulationWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.colorRight);
        if (this.iImageID >= 0) {
            IMGManager.getIMG(this.iImageID).drawO(oSB, this.getPosXE() + CFG.PADD * 3 + CFG.CIV_FLAG_WIDTH + this.getTextWidthU() + this.iPopulationWidth + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(this.iImageID).getHeight() / 2 + iTranslateY);
        }
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? new Color(0.56f, 0.56f, 0.56f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? new Color(0.68f, 0.68f, 0.68f, 1.0f) : new Color(0.82f, 0.82f, 0.82f, 1.0f)) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 0;
    }

    @Override
    public int getWidthE() {
        return Math.max(super.getWidthE(), CFG.PADD * 3 + CFG.CIV_FLAG_WIDTH + (this.getTextWidthU() + this.iPopulationWidth) + CFG.PADD * 2) + (this.iImageID >= 0 ? CFG.PADD + IMGManager.getIMG(this.iImageID).getWidth() : 0);
    }
}

