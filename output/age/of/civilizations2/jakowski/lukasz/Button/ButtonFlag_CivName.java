
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ButtonFlag_CivName
extends ButtonM {
    public int iCivID;

    public ButtonFlag_CivName(int iCivID, int iPosX, int iPosY, boolean isClickable) {
        this.fontID = CFG.FONT_REGULAR_SMALL;
        this.init(CFG.core.getCiv(iCivID).getCivName(), -1, iPosX, iPosY, IMGManager.getIMG(Images.flagDiplomacyOver).getWidth() + CFG.PADD * 2, IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, isClickable, true, false, false);
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.BUTTON_FLAG;
        this.iCivID = iCivID;
        int tWMax = 0;
        while (this.iTextWidth >= this.getWidthE() - (this.iTextPositionX > 0 ? this.iTextPositionX : 0) - CFG.PADD && this.getTextE().length() > 5 && ++tWMax < 100) {
            this.setTextE(this.getTextE().substring(0, Math.max(1, this.getTextE().length() - 3)) + ".");
        }
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.getIsHovered() || isActive) {
            oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, ButtonFlag_CivName.getBoxAlpha(this.getIsClickable(), this.getIsHovered(), isActive)));
            Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
            oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, 0.5f));
            IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2);
            oSB.setColor(Color.WHITE);
            Core.drawFlagDiplomacy(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagDiplomacyOver).getWidth() / 2 + iTranslateX, this.getPosY() + iTranslateY, this.getFlagCivID());
            Renderer.drawText(oSB, this.fontID, this.sText, this.getPosXE() + this.textPosition.getTextPosition() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getTextHeight() + iTranslateY, this.getColorE(isActive));
        } else {
            int nY = this.getPosY() + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2;
            int nH = this.getHeightE() - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD * 2;
            oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, ButtonFlag_CivName.getBoxAlpha(this.getIsClickable(), this.getIsHovered(), isActive)));
            Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, nY + iTranslateY, this.getWidthE(), nH, 1.0f);
            oSB.setColor(Color.WHITE);
            Core.drawFlagDiplomacy(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagDiplomacyOver).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() + iTranslateY, this.getFlagCivID());
        }
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }

    public static final float getBoxAlpha(boolean clickable, boolean isHovered, boolean isActive) {
        return clickable ? (isActive ? 0.85f : (isHovered ? 0.7f : 0.5f)) : 0.2f;
    }

    public int getFlagCivID() {
        return this.iCivID;
    }

    @Override
    public int getCurr() {
        return this.iCivID;
    }

    @Override
    public void actionElem(int iID) {
        if (CFG.core.getCiv(this.iCivID).getCapitalProvID() >= 0 && CFG.core.getCiv(this.iCivID).getCapitalProvID() < CFG.core.getProvinSize()) {
            CFG.map.getMpC().centerToProvID(CFG.core.getCiv(this.iCivID).getCapitalProvID());
            CFG.core.setActiveProvID(CFG.core.getCiv(this.iCivID).getCapitalProvID());
            CFG.setActiveCivInfoId(this.iCivID);
            CFG.updateActiveCivInfo_CreateNewGame();
        }
        if (!CFG.core.getCiv(this.iCivID).getIsPlayer()) {
            CFG.core.disableDrawCivilizationRegions(CFG.core.getPlayer(0).getCivId());
            CFG.core.getPlayer(0).setCivId(this.iCivID);
            CFG.core.enableDrawCivilizationRegions(CFG.core.getPlayer(0).getCivId(), 0);
        } else if (CFG.core.getPlayer(0).getCivId() != this.iCivID) {
            for (int i = 1; i < CFG.core.getPlayersSize(); ++i) {
                if (CFG.core.getPlayer(i).getCivId() != this.iCivID) continue;
                int tempCiv = CFG.core.getPlayer(0).getCivId();
                CFG.core.getPlayer(0).setCivId(CFG.core.getPlayer(i).getCivId());
                CFG.core.getPlayer(i).setCivId(tempCiv);
                if (CFG.core.getPlayer(0).getCivId() > 0) {
                    CFG.core.getCiv(CFG.core.getPlayer(0).getCivId()).setIsPlayer(true);
                }
                if (CFG.core.getPlayer(i).getCivId() > 0) {
                    CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).setIsPlayer(true);
                }
                return;
            }
        } else if (CFG.core.getPlayer(0).getCivId() > 0) {
            
        }
    }

    @Override
    public void actionElemPPM() {
        if (CFG.core.getCiv(this.iCivID).getCapitalProvID() >= 0 && CFG.core.getCiv(this.iCivID).getCapitalProvID() < CFG.core.getProvinSize()) {
            CFG.map.getMpC().centerToProvID(CFG.core.getCiv(this.iCivID).getCapitalProvID());
        }
    }
}

