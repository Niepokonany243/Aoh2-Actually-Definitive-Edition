
package age.of.civilizations2.jakowski.lukasz.Button.CNG;

import age.of.civilizations2.jakowski.lukasz.Button.CNG.Button_CNG_Options;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_CNG_Options_Text2
extends Button_CNG_Options {
    private boolean row = false;
    private String sText2;

    public Button_CNG_Options_Text2(String sText, String sText2, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
        this.sText2 = sText2;
    }

    public Button_CNG_Options_Text2(String sText, String sText2, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkboxState) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, checkboxState);
        this.sText2 = sText2;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.row) {
            if (isActive) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.4f));
            } else {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.2f));
            }
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.175f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + this.getHeightE() - this.getHeightE() / 4 + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.35f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() * 2 + iTranslateY, this.getWidthE(), 1);
            oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.75f));
            IMGManager.getIMG(Images.line32).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.line32).getHeight() * 2 + iTranslateY, this.getWidthE(), 1);
            oSB.setColor(Color.WHITE);
        } else {
            if (isActive) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.25f));
            } else {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.05f));
            }
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.175f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + this.getHeightE() - this.getHeightE() / 4 + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.35f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() * 2 + iTranslateY, this.getWidthE(), 1);
            oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.75f));
            IMGManager.getIMG(Images.line32).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.line32).getHeight() * 2 + iTranslateY, this.getWidthE(), 1);
            oSB.setColor(Color.WHITE);
        }
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        CFG.fontMain.get(0).getData().setScale(0.85f);
        CFG.drawTextDefault(oSB, this.getTextE(), this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + CFG.PADD * 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.85f) / 2 + iTranslateY, this.getIsHovered() ? CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME_HOVER : CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME);
        CFG.fontMain.get(0).getData().setScale(0.65f);
        CFG.drawTextDefault(oSB, this.sText2, this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + CFG.PADD * 3 + CFG.TEXT_HEIGHT_DEFAULT + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.65f) / 2 + iTranslateY, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO);
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent % 2 == 0;
    }
}

