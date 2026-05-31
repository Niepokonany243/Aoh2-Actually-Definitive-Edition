/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_Data;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Menu_PeaceTreaty;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Button_Stats_WarDetails
extends ButtonStats {
    public int iCivID;
    public String iCivilianDeaths;
    public int iCivilianDeathsWidth;
    public Color oColorCivilianDeaths;
    public String iEconomicLosses;
    public int iEconomicLossesWidth;
    public Color oColorEconomicLosses;
    public String sProvinces;
    public int iParticipation;
    public Color oColorParticipation;
    public boolean canPeaceOut = false;
    public long ANIMATION_TIME = 0L;
    public int ANIMATION_POSX = 0;
    public static final int ANIMATION_TIMER = 175;
    public long lTime = 0L;
    public float fAlphaMod = 0.0f;
    public boolean backAnimation = false;

    public Button_Stats_WarDetails(int nCivID, long iCasualties, long iCivilianDeaths, long iEconomicLosses, int iParticipation, int iProvinces, int iProvincesTotal, int iPosX, int iPosY, int iWidth, boolean canPeaceOut) {
        super(CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(nCivID) ? CFG.core.getCiv(nCivID).getCivName() : CFG.lang.get("Undiscovered")) : CFG.core.getCiv(nCivID).getCivName(), 0, iPosX, iPosY, iWidth, Math.max(CFG.BUTTON_H, CFG.TEXT_HEIGHT_DEFAULT * 2 + CFG.PADD * 4), CFG.FONT_BOLD_SMALL);
        this.oColorCivilianDeaths = iCivilianDeaths == 0L ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2;
        this.oColorEconomicLosses = iEconomicLosses == 0L ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2;
        this.canPeaceOut = canPeaceOut;
        this.iCivID = CFG.FOG_OF_WAR == 2 ? (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(nCivID) ? nCivID : -1) : nCivID;
        this.iCivilianDeaths = CFG.getNumberWthSpaces("" + iCivilianDeaths);
        this.iEconomicLosses = CFG.getNumberWthSpaces("" + iEconomicLosses);
        this.iParticipation = iParticipation;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.iCivilianDeaths);
        this.iCivilianDeathsWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.iEconomicLosses);
        this.iEconomicLossesWidth = (int)CFG.glyphLay.width;
        this.sProvinces = CFG.lang.get("Provinces") + ": " + iProvinces + "/" + iProvincesTotal + (iProvinces != iProvincesTotal ? (iProvinces > iProvincesTotal ? " [" + (iProvinces - iProvincesTotal) + " " + CFG.lang.get("Occupied") + "]" : " [" + (iProvincesTotal - iProvinces) + " " + CFG.lang.get("Lost") + "]") : "");
        this.oColorParticipation = iParticipation == 0 ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_NEUTRAL;
    }

    public Button_Stats_WarDetails(int nCivID, int iCasualties, int iCivilianDeaths, int iEconomicLosses, int iParticipation, int iProvinces, int iProvincesTotal, int iPosX, int iPosY, int iWidth, boolean canPeaceOut) {
        this(nCivID, (long)iCasualties, (long)iCivilianDeaths, (long)iEconomicLosses, iParticipation, iProvinces, iProvincesTotal, iPosX, iPosY, iWidth, canPeaceOut);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.row) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.135f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.275f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.3f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
        if (isActive || this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, isActive ? 0.345f : 0.265f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.525f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        this.drawFlag(oSB, iTranslateX, iTranslateY, isActive);
        oSB.setColor(new Color(0.06f, 0.06f, 0.1f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
        oSB.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.85f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
        oSB.setColor(Color.WHITE);
    }

    private final void drawFlag(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * 68.0f), this.getHeightE(), false, false);
        try {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
            oSB.setShader(Renderer.shaderAlpha);
            IMGManager.getIMG(Images.sliderGradient).getTexture().bind(2);
            try {
                CFG.core.getCiv(this.iCivID).getFlagC().getTexture().bind(1);
            }
            catch (Exception ex) {
                IMGManager.getIMG(Images.randomCivilizationFlag).getTexture().bind(1);
            }
            Gdx.gl.glActiveTexture(33984);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.ANIMATION_POSX + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * 68.0f), this.getHeightE(), false, false);
            oSB.setShader(AoCGame.shaderDef);
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.1f));
            oSB.setShader(Renderer.shaderAlpha);
            IMGManager.getIMG(Images.gradient).getTexture().bind(2);
            try {
                CFG.core.getCiv(this.iCivID).getFlagC().getTexture().bind(1);
            }
            catch (Exception ex) {
                IMGManager.getIMG(Images.randomCivilizationFlag).getTexture().bind(1);
            }
            Gdx.gl.glActiveTexture(33984);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + this.ANIMATION_POSX + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * 68.0f), this.getHeightE(), false, false);
            oSB.setShader(AoCGame.shaderDef);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.ANIMATION_POSX + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * 68.0f), this.getHeightE(), false, false);
        }
        catch (Exception ex) {
            oSB.setShader(AoCGame.shaderDef);
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.825f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * (float)CFG.PADD), this.getHeightE(), false, false);
    }

    public final int getMaxNameWidth() {
        return this.getWidthE() / 2;
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        try {
            oSB.setColor(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 1.0f));
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 1.0f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.ANIMATION_POSX + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + iTranslateX, this.getPosY() + CFG.PADD + (CFG.TEXT_HEIGHT_DEFAULT - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop)));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT + (CFG.TEXT_HEIGHT_DEFAULT - (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(Images.economy))) / 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(Images.economy)));
        oSB.setColor(Color.WHITE);
        try {
            if (this.iCivID >= 0) {
                CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getPosXE() + this.ANIMATION_POSX + CFG.PADD + 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + (CFG.TEXT_HEIGHT_DEFAULT_SMALL - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - CFG.core.getCiv(this.iCivID).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
            } else {
                IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.ANIMATION_POSX + CFG.PADD + 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + (CFG.TEXT_HEIGHT_DEFAULT_SMALL - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
            }
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.ANIMATION_POSX + CFG.PADD + 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + (CFG.TEXT_HEIGHT_DEFAULT_SMALL - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.ANIMATION_POSX + CFG.PADD + 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + (CFG.TEXT_HEIGHT_DEFAULT_SMALL - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        IMGManager.getIMG(Images.pop).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) / 2 - (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop)) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + (CFG.TEXT_HEIGHT_DEFAULT_SMALL - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.pop).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop)));
        IMGManager.getIMG(Images.economy).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + (CFG.TEXT_HEIGHT_DEFAULT_SMALL - (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(Images.economy))) / 2 - IMGManager.getIMG(Images.economy).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(Images.economy)));
        Rectangle clipBounds = new Rectangle(this.getPosXE() + this.ANIMATION_POSX + CFG.PADD + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + iTranslateX, CFG.GAMEHEIGHT - (this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + iTranslateY) - CFG.TEXT_HEIGHT_DEFAULT, this.getMaxNameWidth(), CFG.TEXT_HEIGHT_DEFAULT);
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.ANIMATION_POSX + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + iTranslateY, this.getColorE(isActive));
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.iCivilianDeaths, this.getPosXE() + this.getWidthE() - this.iCivilianDeathsWidth - CFG.PADD * 3 - (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + iTranslateY, this.oColorCivilianDeaths);
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.iEconomicLosses, this.getPosXE() + this.getWidthE() - this.iEconomicLossesWidth - CFG.PADD * 3 - (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, this.oColorEconomicLosses);
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.iParticipation + "%", this.getPosXE() + this.ANIMATION_POSX + CFG.PADD * 3 + Math.min(this.getMaxNameWidth() - CFG.PADD, this.getTextWidthU()) + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + iTranslateY, this.oColorParticipation);
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.sProvinces, this.getPosXE() + this.ANIMATION_POSX + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, new Color(CFG.COLOR_NEUTRAL.r, CFG.COLOR_NEUTRAL.g, CFG.COLOR_NEUTRAL.b, 0.85f));
        if (this.canPeaceOut && this.getIsHovered()) {
            if (this.ANIMATION_POSX < this.getTruceIconWidth()) {
                this.ANIMATION_POSX = (int)(Math.min((float)(System.currentTimeMillis() - this.ANIMATION_TIME) / 175.0f, 1.0f) * (float)this.getTruceIconWidth());
                CFG.setRenderO(true);
            }
            Rectangle clipBounds2 = new Rectangle(this.getPosXE() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.ANIMATION_POSX, this.getHeightE());
            oSB.flush();
            ScissorStack.pushScissors(clipBounds2);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.325f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getTruceIconWidth(), this.getHeightE());
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getTruceIconWidth(), this.getHeightE());
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.675f));
            IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getTruceIconWidth() - 1 + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - CFG.PADD * 2);
            if (this.lTime < System.currentTimeMillis() - 30L) {
                if (this.backAnimation) {
                    this.fAlphaMod -= 0.02f;
                    if (this.fAlphaMod < 0.0f) {
                        this.backAnimation = false;
                    }
                } else {
                    this.fAlphaMod += 0.02f;
                    if (this.fAlphaMod > 0.4f) {
                        this.backAnimation = true;
                    }
                }
                this.lTime = System.currentTimeMillis();
            }
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f - this.fAlphaMod));
            CFG.setRenderO(true);
            IMGManager.getIMG(Images.diploTruce).drawO(oSB, this.getPosXE() + this.getTruceIconWidth() / 2 - IMGManager.getIMG(Images.diploTruce).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploTruce).getHeight() / 2 + iTranslateY);
            try {
                oSB.flush();
                ScissorStack.popScissors();
            }
            catch (IllegalStateException illegalStateException) {}
        } else {
            this.backAnimation = false;
            this.fAlphaMod = 0.0f;
            this.lTime = System.currentTimeMillis();
        }
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        if (this.canPeaceOut) {
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("PeaceNegotiations"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr(), CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Image_Big(Images.diploTruce, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
        nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text("" + this.sProvinces, CFG.COLOR_NEUTRAL));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Participation") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + this.iParticipation + "%", CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image(Images.diploRivals, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CivilianDeaths") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + this.iCivilianDeaths, CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomicLosses") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + this.iEconomicLosses, CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("WarWeariness") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(this.iCivID).getWarWeariness() * 10000.0f)) / 100.0f + "%", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.diploWeariness, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE);
    }

    public final float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    @Override
    public void setVisibleE(boolean isVisible) {
        super.setVisibleE(isVisible);
    }

    @Override
    public int getCurr() {
        return this.iCivID;
    }

    @Override
    public void setIsHovered(boolean isHovered) {
        super.setIsHovered(isHovered);
        if (this.canPeaceOut) {
            if (this.getIsHovered()) {
                this.ANIMATION_TIME = System.currentTimeMillis();
                this.ANIMATION_POSX = 0;
            } else {
                this.ANIMATION_TIME = 0L;
                this.ANIMATION_POSX = 0;
            }
        }
    }

    public int getTruceIconWidth() {
        return IMGManager.getIMG(Images.diploTruce).getWidth() + CFG.PADD * 4;
    }

    @Override
    public void actionElem(int iID) {
        block13: {
            try {
                if (this.canPeaceOut) {
                    int nWarID = CFG.core.getWarID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.getCurr());
                    if (nWarID < 0) break block13;
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_ActiveProvince = CFG.core.getActiveProvID();
                    CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                    CFG.mapModesManager.disableAllViews();
                    ArrayList<Boolean> lDefenders = new ArrayList<Boolean>();
                    ArrayList<Boolean> lAggressors = new ArrayList<Boolean>();
                    if (CFG.core.getWar(nWarID).getIsAggressor(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
                        int i;
                        for (i = 0; i < CFG.core.getWar(nWarID).getAggressorsSize(); ++i) {
                            lAggressors.add(true);
                        }
                        for (i = 0; i < CFG.core.getWar(nWarID).getDefendersSize(); ++i) {
                            lDefenders.add(CFG.core.getWar(nWarID).getDefenderID(i).getCivID() == this.getCurr());
                        }
                    } else {
                        int i;
                        for (i = 0; i < CFG.core.getWar(nWarID).getAggressorsSize(); ++i) {
                            lAggressors.add(CFG.core.getWar(nWarID).getAggressorID(i).getCivID() == this.getCurr());
                        }
                        for (i = 0; i < CFG.core.getWar(nWarID).getDefendersSize(); ++i) {
                            lDefenders.add(true);
                        }
                    }
                    Menu_PeaceTreaty.WAR_ID = nWarID;
                    CFG.peaceTreatyData = new PeaceTreaty_Data(Menu_PeaceTreaty.WAR_ID, lDefenders, lAggressors, CFG.core.getWar(nWarID).getIsAggressor(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                    CFG.core.resetChooseProvinceData_Immediately();
                    CFG.core.resetRegroupArmy_Data();
                    CFG.menus.setMenuID(View.eINGAME_PEACE_TREATY);
                    break block13;
                }
                CFG.toastM.addM(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                if (CFG.FOG_OF_WAR == 2) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(this.getCurr()) && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(this.getCurr()).getCapitalProvID())) {
                        CFG.core.setActiveProvID(CFG.core.getCiv(this.getCurr()).getCapitalProvID());
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                    }
                } else {
                    CFG.core.setActiveProvID(CFG.core.getCiv(this.getCurr()).getCapitalProvID());
                    CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                }
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE) {
                    CFG.core.disableDrawCivilizationRegions_Active();
                    CFG.core.enableDrawCivilizationRegions_ActiveProvince();
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                // empty catch block
            }
        }
    }

    @Override
    public int getSFXElem() {
        return this.canPeaceOut ? SFXManager.SFX_CLICK2 : super.getSFXElem();
    }
}

