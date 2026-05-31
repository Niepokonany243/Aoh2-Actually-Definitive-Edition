
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Wars.Details.Menu_InGame_WarDetails;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class TextOutliner_CurrentWar
extends Text {
    private boolean row = false;
    private int iWarID;
    private int iCivID;
    private Color colorWarScore;
    private boolean sentPeaceTreaty = false;

    public TextOutliner_CurrentWar(int nWarID, int iPosX, int iPosY, int iWidth) {
        super("", CFG.PADD * 2, iPosX, iPosY, iWidth, Math.max(CFG.BUTTON_H / 2, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4)), CFG.FONT_BOLD_SMALL);
        int i;
        this.iWarID = nWarID;
        this.iCivID = CFG.core.getWar(nWarID).getIsAggressor(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) ? CFG.core.getWar(nWarID).getDefenderID(0).getCivID() : CFG.core.getWar(nWarID).getAggressorID(0).getCivID();
        try {
            for (int i2 = 0; i2 < CFG.core.lPeaceTreaties.size(); ++i2) {
                if (!CFG.core.getWar((int)this.iWarID).WAR_TAG.equals(CFG.core.lPeaceTreaties.get((int)i2).peaceTreaty_GameData.WAR_TAG)) continue;
                this.sentPeaceTreaty = true;
                break;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        int tempBest = 0;
        if (CFG.core.getWar(nWarID).getIsAggressor(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
            for (i = 1; i < CFG.core.getWar(nWarID).getDefendersSize(); ++i) {
                if (CFG.core.getCiv(CFG.core.getWar(nWarID).getDefenderID(i).getCivID()).getRankScore() <= CFG.core.getCiv(CFG.core.getWar(nWarID).getDefenderID(tempBest).getCivID()).getRankScore()) continue;
                tempBest = i;
            }
            this.iCivID = CFG.core.getWar(nWarID).getDefenderID(tempBest).getCivID();
        } else {
            for (i = 1; i < CFG.core.getWar(nWarID).getAggressorsSize(); ++i) {
                if (CFG.core.getCiv(CFG.core.getWar(nWarID).getAggressorID(i).getCivID()).getRankScore() <= CFG.core.getCiv(CFG.core.getWar(nWarID).getAggressorID(tempBest).getCivID()).getRankScore()) continue;
                tempBest = i;
            }
            this.iCivID = CFG.core.getWar(nWarID).getAggressorID(tempBest).getCivID();
        }
        int tempWarScore = CFG.core.getWar(nWarID).getWarScore();
        if (CFG.core.getWar(nWarID).getIsAggressor(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
            tempWarScore *= -1;
        }
        this.setTextE((tempWarScore > 0 ? "+" : "") + tempWarScore + "%");
        this.colorWarScore = Math.abs(tempWarScore) >= 100 ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : (tempWarScore > 0 ? CFG.COLOR_POSITIVE : (tempWarScore == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2));
        if (this.getWidthE() > iWidth) {
            this.setWidthE(iWidth);
        }
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (this.row) {
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.8f));
            } else {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.9f));
            }
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), true, false);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
            oSB.setColor(Color.WHITE);
        } else {
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.65f));
            } else {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.75f));
            }
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), true, false);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
            oSB.setColor(Color.WHITE);
        }
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.325f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH, 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + CFG.CIV_FLAG_HEIGHT - 1 + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH, 1, true, false);
        if (isActive) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
        } else if (this.getIsHovered()) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.775f));
        } else {
            oSB.setColor(Color.WHITE);
        }
        IMGManager.getIMG(Images.diploWar).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.diploWar).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploWar).getHeight() / 2 + iTranslateY);
        CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(this.iCivID).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
        oSB.setColor(Color.WHITE);
        if (!this.sentPeaceTreaty || this.getIsHovered() || isActive) {
            Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD - this.getTextWidthU() - CFG.CIV_FLAG_WIDTH - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, isActive ? CFG.COLOR_TEXT_CIV_NAME_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_NAME_HOVERED : this.colorWarScore));
        } else {
            IMGManager.getIMG(Images.diploTruce).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.diploWar).getWidth() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH - CFG.PADD - CFG.PADD / 2 - IMGManager.getIMG(Images.diploTruce).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploTruce).getHeight() / 2 + iTranslateY);
        }
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    @Override
    public void buildElemHover() {
        int i;
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        for (i = 0; i < CFG.core.getWar(this.iWarID).getAggressorsSize() && i < 1; ++i) {
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getWar(this.iWarID).getAggressorID(i).getCivID(), 0, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getWar(this.iWarID).getAggressorID(i).getCivID()).getCivName()));
        }
        nData.add(new ME_Hover_2Type_Image_Big(Images.diploRivals, CFG.PADD, CFG.PADD));
        for (i = 0; i < CFG.core.getWar(this.iWarID).getDefendersSize() && i < 1; ++i) {
            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getWar(this.iWarID).getDefenderID(i).getCivID()).getCivName()));
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getWar(this.iWarID).getDefenderID(i).getCivID(), CFG.PADD, 0));
        }
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        for (i = 0; i < CFG.core.getWar(this.iWarID).getAggressorsSize() && i < 5; ++i) {
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getWar(this.iWarID).getAggressorID(i).getCivID(), 0, 0));
        }
        nData.add(new ME_Hover_2Type_Image_Big(Images.diploRivals, CFG.PADD, CFG.PADD));
        for (i = 0; i < CFG.core.getWar(this.iWarID).getDefendersSize() && i < 5; ++i) {
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getWar(this.iWarID).getDefenderID(i).getCivID(), 0, 0));
        }
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        int tempScore = CFG.core.getWar(this.iWarID).getWarScore();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Score") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (tempScore == 0 ? CFG.lang.get("Balanced") : (tempScore < 0 ? (CFG.core.getWar(this.iWarID).getIsAggressor(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) ? CFG.lang.get("XInFavourOfYourSide", Math.abs(tempScore) + "%") : CFG.lang.get("XInFavourOfEnemySide", Math.abs(tempScore) + "%")) : (CFG.core.getWar(this.iWarID).getIsDefender(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) ? CFG.lang.get("XInFavourOfYourSide", Math.abs(tempScore) + "%") : CFG.lang.get("XInFavourOfEnemySide", Math.abs(tempScore) + "%")))), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        long casualties = CFG.core.getWar(this.iWarID).getCasualties_Aggressors() + CFG.core.getWar(this.iWarID).getCasualties_Defenders();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Casualties") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumber_SHORT((long)casualties), casualties > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.skull, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 0;
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        try {
            CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), sText);
            this.iTextWidth = (int)CFG.glyphLay.width;
            this.iTextHeight = (int)CFG.glyphLay.height;
            if (this.getHeightE() < this.iTextHeight) {
                this.setHeightE(this.iTextHeight);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public void actionElem(int iID) {
        if (CFG.menus.getVisibleInGame_WarDetails() && Menu_InGame_WarDetails.WAR_ID == this.iWarID) {
            CFG.menus.setVisibleInGame_WarDetails(false);
        } else {
            Menu_InGame_WarDetails.WAR_ID = this.iWarID;
            CFG.menus.rebuildInGame_WarDetails();
        }
    }
}

