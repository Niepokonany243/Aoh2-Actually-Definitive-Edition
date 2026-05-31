
package age.of.civilizations2.jakowski.lukasz.Button.RTO;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_RTO
extends Button_Classic {
    public int iCivID;

    public Button_RTO(int nID, int nCivID, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(nCivID > 0 ? "" + nID + ". " + CFG.core.getCiv(nCivID).getCivName() : "" + nID + ". " + CFG.lang.get("Undiscovered"), CFG.PADD + CFG.PADD / 2, iPosX + 2, iPosY, iWidth - 2, iHeight, isClickable);
        this.iCivID = nCivID;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive || this.getIsHovered()) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        } else {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.1f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() * 2 + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.45f));
        IMGManager.getIMG(Images.line32).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.line32).getHeight() * 2 + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        try {
            CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getTextPosElem() + this.getPosXE() + iTranslateX, this.getPosY() - CFG.core.getCiv(this.iCivID).getFlagC().getHeight() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getTextPosElem() + this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getTextPosElem() + this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getTextPosElem() + this.getPosXE() + CFG.CIV_FLAG_WIDTH + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
    }

    @Override
    public int getCurr() {
        return this.iCivID;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT : CFG.COLOR_BUTTON_GAME_TEXT_HOVERED) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
    }

    public int getImageWidth2(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight2(int image) {
        return sUM.sUT.getImageHeight(image);
    }
}

