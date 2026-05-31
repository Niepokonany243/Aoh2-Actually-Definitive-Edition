
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Speed;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Speed_Right
extends Button_Speed {
    public Button_Speed_Right(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (!Menu_InGame_2.MENU_AOC_1) {
            oSB.setColor(new Color(Menu_InGame_2.btnCLR_R.r, Menu_InGame_2.btnCLR_R.g, Menu_InGame_2.btnCLR_R.b, isActive ? 0.8f : (this.getIsHovered() ? 0.65f : 0.5f)));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(Menu_InGame_2.btnCLR_R.r, Menu_InGame_2.btnCLR_R.g, Menu_InGame_2.btnCLR_R.b, isActive ? 0.45f : (this.getIsHovered() ? 0.35f : 0.275f)));
            IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD, this.getHeightE());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD, this.getHeightE(), true, false);
            oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE.r, CFG.COLOR_NEW_GAME_EDGE_LINE.b, CFG.COLOR_NEW_GAME_EDGE_LINE.b, 0.45f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightE());
            oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, this.getHeightE() / 2, false, true);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, this.getHeightE() / 2);
        }
        oSB.setColor(Color.WHITE);
    }
}

