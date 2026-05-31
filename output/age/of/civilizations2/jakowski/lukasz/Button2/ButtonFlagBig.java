/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameN;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ButtonFlagBig
extends ButtonM {
    public boolean inAnimation = false;
    private long currentTime = 0L;
    private int ANIMATION_TIME = 750;
    public boolean drawLordFlag = true;
    public static int year = 1799;

    public static int getButtonH() {
        return IMGManager.getIMG(Images.flagBigMask).getHeight();
    }

    public static int getButtonW() {
        return IMGManager.getIMG(Images.flagBigMask).getWidth();
    }

    public ButtonFlagBig(int iPosX, int iPosY, boolean isClickable, boolean drawLordFlag) {
        this.init("", this.iTextPositionX, iPosX, iPosY, IMGManager.getIMG(Images.flagBigMask).getWidth(), IMGManager.getIMG(Images.flagBigMask).getHeight(), isClickable, true, false, false);
        this.drawLordFlag = drawLordFlag;
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.BUTTON_FLAG;
        this.updateLanguage();
    }

    protected void drawBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        this.drawBG(oSB, iTranslateX, iTranslateY, isActive);
        Core.drawFlagBigGovernment(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getFlagCivID());
        if (this.inAnimation) {
            if (this.currentTime == 0L) {
                this.currentTime = CFG.currentTimeMillis;
            }
            Renderer.clipView_Start(oSB, iTranslateX, CFG.GAMEHEIGHT - (this.getPosY() + iTranslateY), CFG.GAMEWIDTH, -((int)((float)IMGManager.getIMG(Images.flagBigOver).getHeight() * ((float)(CFG.currentTimeMillis - this.currentTime) / (float)this.ANIMATION_TIME))));
            this.drawFlag(oSB, iTranslateX, iTranslateY, isActive);
            Renderer.clipView_End(oSB);
            if (CFG.currentTimeMillis - this.currentTime > (long)this.ANIMATION_TIME) {
                this.inAnimation = false;
                this.currentTime = 0L;
            }
        } else {
            this.drawFlag(oSB, iTranslateX, iTranslateY, isActive);
        }
    }

    public int getFlagCivID() {
        return CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
    }

    protected void drawFlag(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (GameCalendar.currYear > year) {
            if (CFG.core.getCiv((int)this.getFlagCivID()).isFlagNearest || GameN.FUEVG) {
                oSB.setShader(Renderer.shaderAlpha);
                CFG.core.getCiv(this.getFlagCivID()).getFlagC().getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                IMGManager.getIMG(Images.flagBigMask2).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, IMGManager.getIMG(Images.flagBigMask2).getWidth(), IMGManager.getIMG(Images.flagBigMask2).getHeight());
            } else {
                Renderer.setShaderWater3(oSB);
                Renderer.shaderWater3.setUniformf("u_maskScale", 1.0f);
                Renderer.shaderWater3.setUniformf("u_maskScaleY", 1.0f);
                IMGManager.getIMG(Images.flagBigMask2).getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                CFG.core.getCiv(this.getFlagCivID()).getFlagC().draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, IMGManager.getIMG(Images.flagBigMask2).getWidth(), IMGManager.getIMG(Images.flagBigMask2).getHeight());
            }
            oSB.flush();
            oSB.setShader(AoCGame.shaderDef);
            if (this.drawLordFlag && GameValues.gvVassal.ENABLE_VASSAL_LORD_FLAG && !CFG.core.getCiv((int)this.getFlagCivID()).iFVS && !this.getIsHovered() && CFG.core.getCiv(this.getFlagCivID()).getPuppetOfCiv() != this.getFlagCivID()) {
                if (CFG.core.getCiv((int)CFG.core.getCiv((int)this.getFlagCivID()).getPuppetOfCiv()).isFlagNearest || GameN.FUEVG) {
                    oSB.setShader(Renderer.shaderAlpha);
                    CFG.core.getCiv(CFG.core.getCiv(this.getFlagCivID()).getPuppetOfCiv()).getFlagC().getTexture().bind(1);
                    Gdx.gl.glActiveTexture(33984);
                    IMGManager.getIMG(Images.flagBigMaskLord2).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, IMGManager.getIMG(Images.flagBigMaskLord2).getWidth(), IMGManager.getIMG(Images.flagBigMaskLord2).getHeight());
                } else {
                    Renderer.setShaderWater3(oSB);
                    Renderer.shaderWater3.setUniformf("u_maskScale", 1.0f);
                    Renderer.shaderWater3.setUniformf("u_maskScaleY", 1.0f);
                    IMGManager.getIMG(Images.flagBigMaskLord2).getTexture().bind(1);
                    Gdx.gl.glActiveTexture(33984);
                    CFG.core.getCiv(CFG.core.getCiv(this.getFlagCivID()).getPuppetOfCiv()).getFlagC().draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, IMGManager.getIMG(Images.flagBigMaskLord2).getWidth(), IMGManager.getIMG(Images.flagBigMaskLord2).getHeight());
                }
                oSB.flush();
                oSB.setShader(AoCGame.shaderDef);
            }
            IMGManager.getIMG(Images.flagBigOver2).draw(oSB, this.getPosXE() + (IMGManager.getIMG(Images.flagBigMask2).getWidth() - IMGManager.getIMG(Images.flagBigOver2).getWidth()) / 2 + iTranslateX, this.getPosY() + iTranslateY);
            if (this.getIsHovered() || isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.3f));
                IMGManager.getIMG(Images.flagBigOver2).draw(oSB, this.getPosXE() + (IMGManager.getIMG(Images.flagBigMask2).getWidth() - IMGManager.getIMG(Images.flagBigOver2).getWidth()) / 2 + iTranslateX, this.getPosY() + iTranslateY);
            }
        } else {
            if (CFG.core.getCiv((int)this.getFlagCivID()).isFlagNearest || GameN.FUEVG) {
                oSB.setShader(Renderer.shaderAlpha);
                CFG.core.getCiv(this.getFlagCivID()).getFlagC().getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                IMGManager.getIMG(Images.flagBigMask).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, IMGManager.getIMG(Images.flagBigMask).getWidth(), IMGManager.getIMG(Images.flagBigMask).getHeight());
            } else {
                Renderer.setShaderWater3(oSB);
                Renderer.shaderWater3.setUniformf("u_maskScale", 1.0f);
                Renderer.shaderWater3.setUniformf("u_maskScaleY", 1.0f);
                IMGManager.getIMG(Images.flagBigMask).getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                CFG.core.getCiv(this.getFlagCivID()).getFlagC().draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, IMGManager.getIMG(Images.flagBigMask).getWidth(), IMGManager.getIMG(Images.flagBigMask).getHeight());
            }
            oSB.flush();
            oSB.setShader(AoCGame.shaderDef);
            if (this.drawLordFlag && GameValues.gvVassal.ENABLE_VASSAL_LORD_FLAG && !CFG.core.getCiv((int)this.getFlagCivID()).iFVS && !this.getIsHovered() && CFG.core.getCiv(this.getFlagCivID()).getPuppetOfCiv() != this.getFlagCivID()) {
                if (CFG.core.getCiv((int)CFG.core.getCiv((int)this.getFlagCivID()).getPuppetOfCiv()).isFlagNearest || GameN.FUEVG) {
                    oSB.setShader(Renderer.shaderAlpha);
                    CFG.core.getCiv(CFG.core.getCiv(this.getFlagCivID()).getPuppetOfCiv()).getFlagC().getTexture().bind(1);
                    Gdx.gl.glActiveTexture(33984);
                    IMGManager.getIMG(Images.flagBigMaskLord).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, IMGManager.getIMG(Images.flagBigMaskLord).getWidth(), IMGManager.getIMG(Images.flagBigMaskLord).getHeight());
                } else {
                    Renderer.setShaderWater3(oSB);
                    Renderer.shaderWater3.setUniformf("u_maskScale", 1.0f);
                    Renderer.shaderWater3.setUniformf("u_maskScaleY", 1.0f);
                    IMGManager.getIMG(Images.flagBigMaskLord).getTexture().bind(1);
                    Gdx.gl.glActiveTexture(33984);
                    CFG.core.getCiv(CFG.core.getCiv(this.getFlagCivID()).getPuppetOfCiv()).getFlagC().draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, IMGManager.getIMG(Images.flagBigMaskLord).getWidth(), IMGManager.getIMG(Images.flagBigMaskLord).getHeight());
                }
                oSB.flush();
                oSB.setShader(AoCGame.shaderDef);
            }
            IMGManager.getIMG(Images.flagBigOver).draw(oSB, this.getPosXE() + (IMGManager.getIMG(Images.flagBigMask).getWidth() - IMGManager.getIMG(Images.flagBigOver).getWidth()) / 2 + iTranslateX, this.getPosY() + iTranslateY);
            if (this.getIsHovered() || isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.3f));
                IMGManager.getIMG(Images.flagBigOver).draw(oSB, this.getPosXE() + (IMGManager.getIMG(Images.flagBigMask).getWidth() - IMGManager.getIMG(Images.flagBigOver).getWidth()) / 2 + iTranslateX, this.getPosY() + iTranslateY);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public void updateLanguage() {
        this.inAnimation = true;
        this.currentTime = 0L;
    }

    @Override
    public void setIsHovered(boolean isHovered) {
        super.setIsHovered(isHovered);
    }

    @Override
    public void actionElemPPM() {
    }
}

