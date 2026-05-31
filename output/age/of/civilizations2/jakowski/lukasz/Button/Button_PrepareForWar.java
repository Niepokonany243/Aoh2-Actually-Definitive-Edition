
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_PrepareForWar
extends Button_Build {
    public int warAgainstCivID;
    public int iFromCivID;
    public String sFromCivName;
    public int iFromCivNameWidth;
    public String sProvinceName;
    public int iProvinceNameWidth;
    public String sDate;
    public int iDateWidth;
    public String sEconomy;
    public int iEconomyWidth;
    public Color oColor = Color.WHITE;

    public Button_PrepareForWar(String nText, int iFromCivID, int warAgainstCivID, int numOfTurns, int iPosX, int iPosY, int iWidth) {
        super(nText, Images.diploWarPreparations, 0, 0, iPosX, iPosY, iWidth, true, false, 0, 0.0f);
        this.warAgainstCivID = warAgainstCivID;
        this.iFromCivID = iFromCivID;
        this.sFromCivName = CFG.core.getCiv(iFromCivID).getCivName();
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sFromCivName);
        this.iFromCivNameWidth = (int)CFG.glyphLay.width;
        this.sProvinceName = CFG.core.getCiv(warAgainstCivID).getCivName();
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sProvinceName);
        this.iProvinceNameWidth = (int)CFG.glyphLay.width;
        this.sDate = CFG.lang.get("PreparationTime") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sDate);
        this.iDateWidth = (int)CFG.glyphLay.width;
        this.sEconomy = CFG.lang.get("TurnsX", numOfTurns);
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sEconomy);
        this.iEconomyWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(this.iImageID).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth / 2 - IMGManager.getIMG(this.iImageID).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(this.iImageID).getHeight() / 2 + iTranslateY);
        CFG.core.getCiv(this.iFromCivID).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.core.getCiv(this.iFromCivID).getFlagC().getHeight() - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall, 1.0f)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall, 1.0f)));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall, 1.0f)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall, 1.0f)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall, 1.0f)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sFromCivName, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - this.iFromCivNameWidth - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall, 1.0f)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        CFG.core.getCiv(this.warAgainstCivID).getFlagC().drawO(oSB, this.getPosXE() + CFG.PADD * 2 + this.iProvinceNameWidth + ButtonDiplomacy.iDiploWidth + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 - CFG.PADD / 2 - CFG.core.getCiv(this.warAgainstCivID).getFlagC().getHeight() - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall, ICON_SCALE)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall, ICON_SCALE)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall, ICON_SCALE)));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + this.iProvinceNameWidth + ButtonDiplomacy.iDiploWidth + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 - CFG.PADD / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall, ICON_SCALE)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall, ICON_SCALE)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall, ICON_SCALE)));
        IMGManager.getIMG(Images.time).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + this.iEconomyWidth + ButtonDiplomacy.iDiploWidth + this.iDateWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 - IMGManager.getIMG(Images.time).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.time).getWidth() * this.getImageScale(Images.time, ICON_SCALE)), (int)((float)IMGManager.getIMG(Images.time).getHeight() * this.getImageScale(Images.time, ICON_SCALE)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sProvinceName, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD / 2 + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sDate, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sEconomy, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + this.iDateWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, this.oColor);
    }
}


