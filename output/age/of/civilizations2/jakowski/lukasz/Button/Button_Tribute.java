
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Tribute
extends Button_Build {
    public String sProvinceName;
    public String sDate;
    public int iDateWidth;
    public String sEconomy;
    public int iEconomyWidth;
    public Color oColor = Color.WHITE;

    public Button_Tribute(String sText, int nImageID, int iPosX, int iPosY, int iWidth) {
        super(sText, nImageID, 0, 0, iPosX, iPosY, iWidth, true, false, 0, 0.0f);
        this.sDate = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName();
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sDate);
        this.iDateWidth = (int)CFG.glyphLay.width;
        this.setMin((int)(GameValues.gvGovernment.CHANGE_GOV_REQUIRED_TECH * 100.0f));
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        CFG.ideologiesMgr.getIdeologyID(this.iImageID).getCrownImageScaled().drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth / 2 - CFG.ideologiesMgr.getIdeologyID(this.iImageID).getCrownImageScaled().getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.ideologiesMgr.getIdeologyID(this.iImageID).getCrownImageScaled().getHeight() / 2 + iTranslateY);
        Core.drawFlagRect(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sEconomy, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() - CFG.PADD / 2 + iTranslateY, this.oColor);
        IMGManager.getIMG(Images.topGold()).drawO(oSB, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + this.getTextWidthU() + CFG.PADD + this.iEconomyWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 - (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold(), ICON_SCALE)) / 2 - CFG.PADD / 2 - IMGManager.getIMG(Images.topGold()).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(Images.topGold(), ICON_SCALE)), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(Images.topGold(), ICON_SCALE)));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sDate, this.getPosXE() + CFG.PADD + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
    }

    @Override
    public void setMin(int iMin) {
        this.sEconomy = (iMin > 0 ? "+" : "") + CFG.getNumberWthSpaces("" + iMin);
        this.oColor = iMin > 0 ? CFG.COLOR_GOLD : CFG.COLOR_NEUTRAL;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sEconomy);
        this.iEconomyWidth = (int)CFG.glyphLay.width;
    }
}


