/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_WarDetails;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;

public class Button_Stats_WarDetails_Right
extends Button_Stats_WarDetails {
    public Button_Stats_WarDetails_Right(int iCivID, long iCasualties, long iCivilianDeaths, long iEconomicLosses, int iParticipation, int iProvinces, int iProvincesTotal, int iPosX, int iPosY, int iWidth, boolean canPeaceOut) {
        super(iCivID, iCasualties, iCivilianDeaths, iEconomicLosses, iParticipation, iProvinces, iProvincesTotal, iPosX, iPosY, iWidth, canPeaceOut);
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + this.sProvinces);
        this.iCivilianDeathsWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), "" + iParticipation + "%");
        this.iEconomicLossesWidth = (int)CFG.glyphLay.width;
    }

    public Button_Stats_WarDetails_Right(int iCivID, int iCasualties, int iCivilianDeaths, int iEconomicLosses, int iParticipation, int iProvinces, int iProvincesTotal, int iPosX, int iPosY, int iWidth, boolean canPeaceOut) {
        this(iCivID, (long)iCasualties, (long)iCivilianDeaths, (long)iEconomicLosses, iParticipation, iProvinces, iProvincesTotal, iPosX, iPosY, iWidth, canPeaceOut);
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
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), true, false);
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
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
        oSB.setColor(Color.WHITE);
    }

    private final void drawFlag(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - (int)((float)this.getHeightE() / 44.0f * 68.0f) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * 68.0f), this.getHeightE(), true, false);
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
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.ANIMATION_POSX - (int)((float)this.getHeightE() / 44.0f * 68.0f) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * 68.0f), this.getHeightE(), true, false);
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
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.ANIMATION_POSX - (int)((float)this.getHeightE() / 44.0f * 68.0f) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * 68.0f), this.getHeightE(), true, false);
            oSB.setShader(AoCGame.shaderDef);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.ANIMATION_POSX - (int)((float)this.getHeightE() / 44.0f * 68.0f) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * 68.0f), this.getHeightE(), true, false);
        }
        catch (NullPointerException ex) {
            oSB.setShader(AoCGame.shaderDef);
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.825f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - (int)((float)this.getHeightE() / 44.0f * (float)CFG.PADD) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * (float)CFG.PADD), this.getHeightE(), true, false);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        try {
            oSB.setColor(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 1.0f));
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB(), 1.0f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() - this.ANIMATION_POSX - CFG.PADD - 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + CFG.PADD + (CFG.TEXT_HEIGHT_DEFAULT - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop)));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT + (CFG.TEXT_HEIGHT_DEFAULT - (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(Images.economy))) / 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(Images.economy)));
        oSB.setColor(Color.WHITE);
        try {
            if (this.iCivID >= 0) {
                CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() - this.ANIMATION_POSX - CFG.PADD - 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + (CFG.TEXT_HEIGHT_DEFAULT_SMALL - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - CFG.core.getCiv(this.iCivID).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
            } else {
                IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getWidthE() - this.ANIMATION_POSX - CFG.PADD - 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + (CFG.TEXT_HEIGHT_DEFAULT_SMALL - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
            }
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getWidthE() - this.ANIMATION_POSX - CFG.PADD - 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + (CFG.TEXT_HEIGHT_DEFAULT_SMALL - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() - this.ANIMATION_POSX - CFG.PADD - 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + (CFG.TEXT_HEIGHT_DEFAULT_SMALL - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        IMGManager.getIMG(Images.pop).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) / 2 - (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop)) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + (CFG.TEXT_HEIGHT_DEFAULT_SMALL - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.pop).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.pop).getWidth() * this.getImageScale(Images.pop)), (int)((float)IMGManager.getIMG(Images.pop).getHeight() * this.getImageScale(Images.pop)));
        IMGManager.getIMG(Images.economy).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + (CFG.TEXT_HEIGHT_DEFAULT_SMALL - (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(Images.economy))) / 2 - IMGManager.getIMG(Images.economy).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)), (int)((float)IMGManager.getIMG(Images.economy).getHeight() * this.getImageScale(Images.economy)));
        Rectangle clipBounds = new Rectangle(this.getPosXE() + this.getWidthE() - this.ANIMATION_POSX - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) - this.getMaxNameWidth() + iTranslateX, CFG.GAMEHEIGHT - (this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + iTranslateY) - CFG.TEXT_HEIGHT_DEFAULT, this.getMaxNameWidth(), CFG.TEXT_HEIGHT_DEFAULT);
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() - this.ANIMATION_POSX - Math.min(this.getMaxNameWidth(), this.getTextWidthU()) - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + iTranslateY, this.getColorE(isActive));
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.iCivilianDeaths, this.getPosXE() + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + iTranslateY, this.oColorCivilianDeaths);
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.iEconomicLosses, this.getPosXE() + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(Images.economy).getWidth() * this.getImageScale(Images.economy)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, this.oColorEconomicLosses);
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.iParticipation + "%", this.getPosXE() + this.getWidthE() - this.ANIMATION_POSX - CFG.PADD * 3 - Math.min(this.getMaxNameWidth() - CFG.PADD * 2, this.getTextWidthU()) - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL + iTranslateY, this.oColorParticipation);
        Renderer.drawTextWithShadow(oSB, this.fontID, "" + this.sProvinces, this.getPosXE() + this.getWidthE() - this.ANIMATION_POSX - CFG.PADD - this.iCivilianDeathsWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, new Color(CFG.COLOR_NEUTRAL.r, CFG.COLOR_NEUTRAL.g, CFG.COLOR_NEUTRAL.b, 0.85f));
        if (this.canPeaceOut && this.getIsHovered()) {
            if (this.ANIMATION_POSX < this.getTruceIconWidth()) {
                this.ANIMATION_POSX = (int)(Math.min((float)(System.currentTimeMillis() - this.ANIMATION_TIME) / 175.0f, 1.0f) * (float)this.getTruceIconWidth());
                CFG.setRenderO(true);
            }
            Rectangle clipBounds2 = new Rectangle(this.getPosXE() + this.getWidthE() - this.ANIMATION_POSX + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightE(), this.ANIMATION_POSX, this.getHeightE());
            oSB.flush();
            ScissorStack.pushScissors(clipBounds2);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.325f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getTruceIconWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getTruceIconWidth(), this.getHeightE());
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getTruceIconWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getTruceIconWidth(), this.getHeightE());
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.675f));
            IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getTruceIconWidth() + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE() - CFG.PADD * 2);
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
            IMGManager.getIMG(Images.diploTruce).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getTruceIconWidth() / 2 - IMGManager.getIMG(Images.diploTruce).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.diploTruce).getHeight() / 2 + iTranslateY);
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
}

