
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Alliance
extends ButtonM {
    private int iAllianceID = 0;

    public Button_Alliance(int iAllianceID, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
        this.iAllianceID = iAllianceID;
    }

    @Override
    public final void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.75f));
        } else if (this.getIsHovered()) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
        } else {
            oSB.setColor(Color.WHITE);
        }
        IMGManager.getIMG(Images.btnAdd).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.btnAdd).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnAdd).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.btnAdd).getHeight());
        IMGManager.getIMG(Images.btnAdd).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnAdd).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.btnAdd).getHeight() + iTranslateY, IMGManager.getIMG(Images.btnAdd).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.btnAdd).getHeight(), true);
        IMGManager.getIMG(Images.btnAdd).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.btnAdd).getHeight() * 2 + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnAdd).getWidth(), IMGManager.getIMG(Images.btnAdd).getHeight(), false, true);
        IMGManager.getIMG(Images.btnAdd).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnAdd).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.btnAdd).getHeight() + iTranslateY, true, true);
        if (CFG.core.getAlliance(this.iAllianceID).getCivilizationsSize() * CFG.CIV_FLAG_WIDTH + (CFG.core.getAlliance(this.iAllianceID).getCivilizationsSize() + 1) * CFG.PADD < this.getWidthE()) {
            iTranslateX += (this.getWidthE() - CFG.core.getAlliance(this.iAllianceID).getCivilizationsSize() * CFG.CIV_FLAG_WIDTH - (CFG.core.getAlliance(this.iAllianceID).getCivilizationsSize() - 1) * CFG.PADD) / 2 - CFG.PADD;
        }
        oSB.setColor(new Color(CFG.core.getAlliance(this.iAllianceID).getColorOfAlliance().getR(), CFG.core.getAlliance(this.iAllianceID).getColorOfAlliance().getG(), CFG.core.getAlliance(this.iAllianceID).getColorOfAlliance().getB(), 1.0f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2 + CFG.CIV_COLOR_W - 1 + iTranslateY, CFG.PADD, CFG.CIV_COLOR_W, true, false);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2 + CFG.CIV_COLOR_W - 1 + iTranslateY, CFG.core.getAlliance(this.iAllianceID).getCivilizationsSize() * CFG.CIV_FLAG_WIDTH + (CFG.core.getAlliance(this.iAllianceID).getCivilizationsSize() - 1) * CFG.PADD - CFG.PADD * 2, CFG.CIV_COLOR_W);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + CFG.PADD + CFG.core.getAlliance(this.iAllianceID).getCivilizationsSize() * CFG.CIV_FLAG_WIDTH + (CFG.core.getAlliance(this.iAllianceID).getCivilizationsSize() - 1) * CFG.PADD - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2 + CFG.CIV_COLOR_W - 1 + iTranslateY, CFG.PADD, CFG.CIV_COLOR_W);
        oSB.setColor(Color.WHITE);
        for (int i = 0; i < CFG.core.getAlliance(this.iAllianceID).getCivilizationsSize(); ++i) {
            CFG.core.getCiv(CFG.core.getAlliance(this.iAllianceID).getCivilization(i)).getFlagC().drawO(oSB, this.getPosXE() + CFG.CIV_FLAG_WIDTH * i + CFG.PADD * (i + 1) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD * 2 - CFG.core.getCiv(CFG.core.getAlliance(this.iAllianceID).getCivilization(i)).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.CIV_FLAG_WIDTH * i + CFG.PADD * (i + 1) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD * 2 + iTranslateY);
        }
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            CFG.drawTextDefault(oSB, this.getTextToDrawElem(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - this.getTextWidthU() / 2 : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        } else {
            CFG.drawTextDefaultWithShadow(oSB, this.getTextToDrawElem(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - this.getTextWidthU() / 2 : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        }
    }

    @Override
    public final Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getIsHovered() ? new Color(0.82f, 0.82f, 0.82f, 1.0f) : new Color(0.7f, 0.7f, 0.7f, 1.0f)) : new Color(0.764f, 0.764f, 0.764f, 0.6f));
    }

    @Override
    public void setTextE(String sText) {
        super.setTextE(sText);
        if (this.getTextWidthU() > this.getWidthE() - CFG.PADD * 2) {
            this.setWidthE(this.getTextWidthU() + CFG.PADD * 2);
        }
    }

    @Override
    public int getCurr() {
        return this.iAllianceID;
    }
}

