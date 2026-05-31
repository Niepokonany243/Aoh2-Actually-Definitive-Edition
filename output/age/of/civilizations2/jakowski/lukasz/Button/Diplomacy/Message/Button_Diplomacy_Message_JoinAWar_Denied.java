
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Message;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Diplomacy_Message_JoinAWar_Denied
extends ButtonStats {
    private int iCivA;
    private int warAgainstCivID;
    private int warAgainstCivIDWidth;
    private int iCivB;

    public Button_Diplomacy_Message_JoinAWar_Denied(String sText, int nFromCivID, int warAgainstCivID, int iCivB, int iPosX, int iPosY, int iWidth) {
        super(sText, 0, iPosX, iPosY, iWidth, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.BUTTON_H), CFG.FONT_BOLD);
        this.iCivA = nFromCivID;
        this.warAgainstCivID = warAgainstCivID;
        this.iCivB = iCivB;
        CFG.glyphLay.setText(CFG.fontMain.get(0), CFG.core.getCiv(warAgainstCivID).getCivName());
        this.warAgainstCivIDWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth - CFG.PADD * 2 + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE() - 2, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE() - 2, false, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - 2);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.25f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(Color.WHITE);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() * 3 / 5, false, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.275f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 4 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), true, false);
        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.3f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, true);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.45f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - 4, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - 4, 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.diploRivals).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth / 2 - IMGManager.getIMG(Images.diploRivals).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploRivals).getHeight() / 2 + iTranslateY);
        try {
            oSB.setColor(new Color((float)CFG.core.getCiv(this.iCivA).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivA).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivA).getB() / 255.0f, 1.0f));
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 1.0f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
        CFG.core.getCiv(this.iCivA).getFlagC().drawO(oSB, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - CFG.core.getCiv(this.iCivA).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        CFG.core.getCiv(this.warAgainstCivID).getFlagC().drawO(oSB, this.getPosXE() + CFG.PADD * 3 + ButtonDiplomacy.iDiploWidth + 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - CFG.core.getCiv(this.warAgainstCivID).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD * 3 + ButtonDiplomacy.iDiploWidth + 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        CFG.drawTextDefaultWithShadow(oSB, this.getTextE(), this.getPosXE() + CFG.PADD * 2 + ButtonDiplomacy.iDiploWidth + 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT / 2.0f) + iTranslateY, this.getColorE(isActive));
        CFG.drawTextDefaultWithShadow(oSB, CFG.core.getCiv(this.warAgainstCivID).getCivName(), this.getPosXE() + CFG.PADD * 4 + ButtonDiplomacy.iDiploWidth + 4 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) * 2 + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT / 2.0f) + iTranslateY, CFG.COLOR_NEGATIVE_2);
        IMGManager.getIMG(Images.diploRivals).drawO(oSB, this.getPosXE() + CFG.PADD * 5 + ButtonDiplomacy.iDiploWidth + 2 + this.warAgainstCivIDWidth + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) * 2 + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.diploRivals).getHeight() * this.getImageScale(Images.diploRivals)) / 2 - IMGManager.getIMG(Images.diploRivals).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)), (int)((float)IMGManager.getIMG(Images.diploRivals).getHeight() * this.getImageScale(Images.diploRivals)));
        CFG.core.getCiv(this.iCivB).getFlagC().drawO(oSB, this.getPosXE() + (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) + CFG.PADD * 6 + ButtonDiplomacy.iDiploWidth + 2 + this.warAgainstCivIDWidth + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) * 2 + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - CFG.core.getCiv(this.iCivB).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) + CFG.PADD * 6 + ButtonDiplomacy.iDiploWidth + 2 + this.warAgainstCivIDWidth + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) * 2 + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
    }

    private final float getImageScale(int nImageID) {
        return 1.0f;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS);
    }

    @Override
    public void buildElemHover() {
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }
}

