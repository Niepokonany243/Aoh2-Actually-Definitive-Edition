/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Stats_War_Enforce
extends ButtonStats {
    public static long lTime;
    private int iAggressor;
    private int iDefender;
    private String sDefenderName;
    private int iWarID = 0;
    private float fAttackersPerc;
    private String sCasualtiesTotal;
    private Color oColorCasualtiesTotal;
    private String sWarDate;
    private int iWarDateWidth = 0;

    public Button_Stats_War_Enforce(int nAggressor, int nDefender, int nWarID, int iPosX, int iPosY, int iWidth) {
        super(CFG.FOG_OF_WAR == 2 ? (CFG.core.getWar(nWarID).getAggressorsSize() == 1 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(nAggressor) ? CFG.core.getCiv(nAggressor).getCivName() : CFG.lang.get("Undiscovered")) : (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetAlliance(CFG.core.getCiv(nAggressor).getAlliance()) ? CFG.core.getAlliance(CFG.core.getCiv(nAggressor).getAlliance()).getAllianceName() : (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(nAggressor) ? CFG.core.getCiv(nAggressor).getCivName() : CFG.lang.get("Undiscovered")))) : (CFG.core.getWar(nWarID).getAggressorsSize() == 1 ? CFG.core.getCiv(nAggressor).getCivName() : CFG.core.getAlliance(CFG.core.getCiv(nAggressor).getAlliance()).getAllianceName()), 0, iPosX, iPosY, iWidth, Math.max(CFG.PADD * 6 + Math.max(CFG.TEXT_HEIGHT_DEFAULT, IMGManager.getIMG(Images.flagRect2).getHeight()), CFG.BUTTON_H * 4 / 5), CFG.FONT_BOLD);
        if (CFG.FOG_OF_WAR == 2) {
            this.iAggressor = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(nAggressor) ? nAggressor : -1;
            this.iDefender = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(nDefender) ? nDefender : -1;
            this.sDefenderName = CFG.core.getWar(nWarID).getDefendersSize() == 1 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(nDefender) ? CFG.core.getCiv(nDefender).getCivName() : CFG.lang.get("Undiscovered")) : (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetAlliance(CFG.core.getCiv(nDefender).getAlliance()) ? CFG.core.getAlliance(CFG.core.getCiv(nDefender).getAlliance()).getAllianceName() : (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(nDefender) ? CFG.core.getCiv(nDefender).getCivName() : CFG.lang.get("Undiscovered")));
        } else {
            this.iAggressor = nAggressor;
            this.iDefender = nDefender;
            this.sDefenderName = CFG.core.getWar(nWarID).getDefendersSize() == 1 ? CFG.core.getCiv(nDefender).getCivName() : CFG.core.getAlliance(CFG.core.getCiv(nDefender).getAlliance()).getAllianceName();
        }
        this.iWarID = nWarID;
        long tempCas = CFG.core.getWar(this.iWarID).getCasualties_Aggressors() + CFG.core.getWar(this.iWarID).getCasualties_Defenders();
        this.oColorCasualtiesTotal = tempCas == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2;
        this.sCasualtiesTotal = CFG.getNumber_SHORT(tempCas);
        this.sWarDate = GameCalendar.getDate_ByTurnID(CFG.core.getWar(this.iWarID).getWarTurnID());
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sWarDate);
        this.iWarDateWidth = (int)CFG.glyphLay.width;
        this.fAttackersPerc = 0.5f - 0.5f * ((float)CFG.core.getWar(this.iWarID).getWarScore() / 100.0f);
        lTime = System.currentTimeMillis();
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
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
        float drawPerc = this.fAttackersPerc;
        if (lTime + 375L > System.currentTimeMillis()) {
            drawPerc = 0.5f - (0.5f - this.fAttackersPerc) * (float)(System.currentTimeMillis() - lTime) / 375.0f;
            CFG.setRenderO(true);
        }
        int topH = this.getHeightE() - CFG.PADD * 4;
        IMGManager.getIMG(Images.diploRivals).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 + iTranslateX, this.getPosY() + topH / 2 - (int)((float)IMGManager.getIMG(Images.diploRivals).getHeight() * this.getImageScale(Images.diploRivals)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)), (int)((float)IMGManager.getIMG(Images.diploRivals).getHeight() * this.getImageScale(Images.diploRivals)));
        oSB.setColor(Color.WHITE);
        if (CFG.FOG_OF_WAR == 2) {
            int i;
            for (i = CFG.core.getWar(this.iWarID).getAggressorsSize() - 1; i >= 0; --i) {
                Core.drawFlagRect(oSB, this.getPosXE() + this.getWidthE() / 2 - (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 - CFG.PADD - IMGManager.getIMG(Images.flagRect2).getWidth() - IMGManager.getIMG(Images.flagRect2).getWidth() * 3 / 4 * i + iTranslateX, this.getPosY() + topH / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getWar(this.iWarID).getAggressorID(i).getCivID()) ? CFG.core.getWar(this.iWarID).getAggressorID(i).getCivID() : -1);
            }
            for (i = CFG.core.getWar(this.iWarID).getDefendersSize() - 1; i >= 0; --i) {
                Core.drawFlagRect(oSB, this.getPosXE() + this.getWidthE() / 2 + (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 + CFG.PADD + IMGManager.getIMG(Images.flagRect2).getWidth() * 3 / 4 * i + iTranslateX, this.getPosY() + topH / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getWar(this.iWarID).getDefenderID(i).getCivID()) ? CFG.core.getWar(this.iWarID).getDefenderID(i).getCivID() : -1);
            }
        } else {
            int i;
            for (i = CFG.core.getWar(this.iWarID).getAggressorsSize() - 1; i >= 0; --i) {
                Core.drawFlagRect(oSB, this.getPosXE() + this.getWidthE() / 2 - (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 - CFG.PADD - IMGManager.getIMG(Images.flagRect2).getWidth() - IMGManager.getIMG(Images.flagRect2).getWidth() * 3 / 4 * i + iTranslateX, this.getPosY() + topH / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getWar(this.iWarID).getAggressorID(i).getCivID());
            }
            for (i = CFG.core.getWar(this.iWarID).getDefendersSize() - 1; i >= 0; --i) {
                Core.drawFlagRect(oSB, this.getPosXE() + this.getWidthE() / 2 + (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 + CFG.PADD + IMGManager.getIMG(Images.flagRect2).getWidth() * 3 / 4 * i + iTranslateX, this.getPosY() + topH / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, CFG.core.getWar(this.iWarID).getDefenderID(i).getCivID());
            }
        }
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 - CFG.PADD * 2 - this.getTextWidthU() - IMGManager.getIMG(Images.flagRect2).getWidth() - IMGManager.getIMG(Images.flagRect2).getWidth() * 3 / 4 * (CFG.core.getWar(this.iWarID).getAggressorsSize() - 1) + iTranslateX, this.getPosY() + topH / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sDefenderName, this.getPosXE() + this.getWidthE() / 2 + (int)((float)IMGManager.getIMG(Images.diploRivals).getWidth() * this.getImageScale(Images.diploRivals)) / 2 + CFG.PADD * 2 + IMGManager.getIMG(Images.flagRect2).getWidth() + IMGManager.getIMG(Images.flagRect2).getWidth() * 3 / 4 * (CFG.core.getWar(this.iWarID).getDefendersSize() - 1) + iTranslateX, this.getPosY() + topH / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        IMGManager.getIMG(Images.skull).draw(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + topH / 2 - (int)((float)IMGManager.getIMG(Images.skull).getHeight() * this.getImageScale2(Images.skull)) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(Images.skull).getWidth() * this.getImageScale2(Images.skull)), (int)((float)IMGManager.getIMG(Images.skull).getHeight() * this.getImageScale2(Images.skull)));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sCasualtiesTotal, this.getPosXE() + (int)((float)IMGManager.getIMG(Images.skull).getWidth() * this.getImageScale2(Images.skull)) + CFG.PADD * 3 + iTranslateX, this.getPosY() + topH / 2 - this.getTextHeight() / 2 + iTranslateY, this.oColorCasualtiesTotal);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD * 2, false, true);
        try {
            if (this.iAggressor >= 0) {
                oSB.setColor(new Color((float)CFG.core.getCiv(this.iAggressor).getR() / 255.0f, (float)CFG.core.getCiv(this.iAggressor).getG() / 255.0f, (float)CFG.core.getCiv(this.iAggressor).getB() / 255.0f, 0.45f));
            } else {
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 0.45f));
            }
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 0.45f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD * 2, false, true);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD, false, true);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD * 2, true, true);
        try {
            if (this.iDefender >= 0) {
                oSB.setColor(new Color((float)CFG.core.getCiv(this.iDefender).getR() / 255.0f, (float)CFG.core.getCiv(this.iDefender).getG() / 255.0f, (float)CFG.core.getCiv(this.iDefender).getB() / 255.0f, 0.45f));
            } else {
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB(), 0.45f));
            }
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB(), 0.45f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD * 2, false, true);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD, false, true);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD * 2, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
        IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD * 2, false, true);
        IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), CFG.PADD * 2, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.785f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, CFG.PADD * 2);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2, CFG.PADD * 2, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD * 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2, 1);
        oSB.setColor(Color.WHITE);
    }

    private final float getImageScale(int nImageID) {
        return 1.0f;
    }

    private final float getImageScale2(int nImageID) {
        return 1.0f;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void buildElemHover() {
        int i;
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        if (CFG.FOG_OF_WAR == 2) {
            for (i = 0; i < CFG.core.getWar(this.iWarID).getAggressorsSize() && i < 6; ++i) {
                if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getWar(this.iWarID).getAggressorID(i).getCivID())) {
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getWar(this.iWarID).getAggressorID(i).getCivID(), 0, 0));
                    continue;
                }
                nData.add(new ME_Hover_2Type_Flag(-1, 0, 0));
            }
            nData.add(new ME_Hover_2Type_Image(Images.diploRivals, CFG.PADD, CFG.PADD));
            for (i = 0; i < CFG.core.getWar(this.iWarID).getDefendersSize() && i < 6; ++i) {
                if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getWar(this.iWarID).getDefenderID(i).getCivID())) {
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getWar(this.iWarID).getDefenderID(i).getCivID(), 0, 0));
                    continue;
                }
                nData.add(new ME_Hover_2Type_Flag(-1, 0, 0));
            }
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        } else {
            for (i = 0; i < CFG.core.getWar(this.iWarID).getAggressorsSize() && i < 6; ++i) {
                nData.add(new ME_Hover_2Type_Flag(CFG.core.getWar(this.iWarID).getAggressorID(i).getCivID(), 0, 0));
            }
            nData.add(new ME_Hover_2Type_Image(Images.diploRivals, CFG.PADD, CFG.PADD));
            for (i = 0; i < CFG.core.getWar(this.iWarID).getDefendersSize() && i < 6; ++i) {
                nData.add(new ME_Hover_2Type_Flag(CFG.core.getWar(this.iWarID).getDefenderID(i).getCivID(), 0, 0));
            }
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        int tempScore = CFG.core.getWar(this.iWarID).getWarScore();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Score") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (tempScore == 0 ? CFG.lang.get("Balanced") : (tempScore < 0 ? CFG.lang.get("XInFavorOfAggressors", Math.abs(tempScore) + "%") : CFG.lang.get("XInFavorOfDefenders", Math.abs(tempScore) + "%"))), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Casualties") + ": "));
        nData.add(new ME_Hover_2Type_Text(this.sCasualtiesTotal, this.oColorCasualtiesTotal));
        nData.add(new ME_Hover_2Type_Image(Images.skull, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(this.sWarDate, CFG.COLOR_NEUTRAL));
        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public int getCurr() {
        return this.iWarID;
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }
}

