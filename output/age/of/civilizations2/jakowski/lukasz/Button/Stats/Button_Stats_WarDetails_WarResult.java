/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Button_Stats_WarDetails_WarResult
extends ButtonStats {
    private long lTime;
    public static final int ANIMATION_TIME = 375;
    private int iAggressor;
    private int iDefender;
    private int iWarID = 0;
    private float fAttackersPerc;

    public Button_Stats_WarDetails_WarResult(int nAggressor, int nDefender, int nWarID, int iPosX, int iPosY, int iWidth) {
        super(CFG.core.getCiv(nDefender).getCivName(), 0, iPosX, iPosY, iWidth, CFG.PADD * 3);
        if (CFG.FOG_OF_WAR == 2) {
            this.iAggressor = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(nAggressor) ? nAggressor : -1;
            this.iDefender = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(nDefender) ? nDefender : -1;
        } else {
            this.iAggressor = nAggressor;
            this.iDefender = nDefender;
        }
        this.iWarID = nWarID;
        this.fAttackersPerc = 0.5f - 0.5f * ((float)CFG.core.getWar(this.iWarID).getWarScore() / 100.0f);
        if (this.fAttackersPerc != 0.5f) {
            this.lTime = System.currentTimeMillis();
        }
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.3f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        float drawPerc = this.fAttackersPerc;
        if (this.lTime + 375L > System.currentTimeMillis()) {
            drawPerc = 0.5f - (0.5f - this.fAttackersPerc) * (float)(System.currentTimeMillis() - this.lTime) / 375.0f;
            CFG.setRenderO(true);
        }
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
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, (int)((float)this.getWidthE() * drawPerc), this.getHeightE(), false, true);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, (int)((float)this.getWidthE() * drawPerc), CFG.PADD, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, (int)((float)this.getWidthE() * drawPerc), CFG.PADD, false, true);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)this.getWidthE() * drawPerc), this.getHeightE(), true, true);
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
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)this.getWidthE() * drawPerc) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE() - (int)((float)this.getWidthE() * drawPerc), this.getHeightE(), false, true);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + (int)((float)this.getWidthE() * drawPerc) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() - (int)((float)this.getWidthE() * drawPerc), CFG.PADD, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + (int)((float)this.getWidthE() * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() - (int)((float)this.getWidthE() * drawPerc), CFG.PADD, false, true);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + (int)((float)this.getWidthE() * drawPerc) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() - (int)((float)this.getWidthE() * drawPerc), this.getHeightE(), false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
        IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, (int)((float)this.getWidthE() * drawPerc), this.getHeightE(), false, true);
        IMGManager.getIMG(Images.pattern).draw2O(oSB, this.getPosXE() + (int)((float)this.getWidthE() * drawPerc) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pattern).getHeight() + iTranslateY, this.getWidthE() - (int)((float)this.getWidthE() * drawPerc), this.getHeightE(), true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.475f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.785f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + (int)((float)this.getWidthE() * drawPerc) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightE());
        oSB.setColor(Color.WHITE);
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
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public int getCurr() {
        return this.iWarID;
    }
}

