
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_2;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Speed
extends ButtonM {
    protected static final Color DRAW_COLOR = new Color();
    private static final Color DISABLED_TEXT_COLOR = new Color(0.78f, 0.78f, 0.78f, 0.7f);

    public Button_Speed(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (!Menu_InGame_2.MENU_AOC_1) {
            oSB.setColor(DRAW_COLOR.set(Menu_InGame_2.btnCLR_R.r, Menu_InGame_2.btnCLR_R.g, Menu_InGame_2.btnCLR_R.b, isActive ? 0.8f : (this.getIsHovered() ? 0.65f : 0.5f)));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), true, false);
            oSB.setColor(DRAW_COLOR.set(Menu_InGame_2.btnCLR_R.r, Menu_InGame_2.btnCLR_R.g, Menu_InGame_2.btnCLR_R.b, isActive ? 0.45f : (this.getIsHovered() ? 0.35f : 0.275f)));
            IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(DRAW_COLOR.set(0.0f, 0.0f, 0.0f, 0.45f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD, this.getHeightE(), true, false);
            oSB.setColor(DRAW_COLOR.set(0.0f, 0.0f, 0.0f, 0.2f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD, this.getHeightE());
            oSB.setColor(DRAW_COLOR.set(CFG.COLOR_NEW_GAME_EDGE_LINE.r, CFG.COLOR_NEW_GAME_EDGE_LINE.b, CFG.COLOR_NEW_GAME_EDGE_LINE.b, 0.45f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightE());
            oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, this.getHeightE() / 2, false, true);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, this.getHeightE() / 2);
            oSB.setColor(Color.WHITE);
        }
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextDefault(oSB, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - (int)((float)this.getTextWidthU() * 0.8f / 2.0f) : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() * 0.8f / 2.0f) + iTranslateY, this.getColorE(isActive));
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_RANK_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_RANK_HOVER : CFG.COLOR_TEXT_RANK) : DISABLED_TEXT_COLOR);
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }
}

