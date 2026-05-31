
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameN;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ButtonFlagBig_IMG
extends ButtonFlagBig {
    public ButtonFlagBig_IMG(int iPosX, int iPosY, boolean isClickable) {
        super(iPosX, iPosY, isClickable, false);
    }

    @Override
    protected void drawFlag(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (GameCalendar.currYear > year) {
            if (CFG.core.getCiv((int)this.getFlagCivID()).isFlagNearest || GameN.FUEVG) {
                oSB.setShader(Renderer.shaderAlpha);
                this.getFlag().getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                IMGManager.getIMG(Images.flagBigMask2).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, IMGManager.getIMG(Images.flagBigMask2).getWidth(), IMGManager.getIMG(Images.flagBigMask2).getHeight());
            } else {
                Renderer.setShaderWater3(oSB);
                Renderer.shaderWater3.setUniformf("u_maskScale", 1.0f);
                Renderer.shaderWater3.setUniformf("u_maskScaleY", 1.0f);
                IMGManager.getIMG(Images.flagBigMask2).getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                this.getFlag().draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, IMGManager.getIMG(Images.flagBigMask2).getWidth(), IMGManager.getIMG(Images.flagBigMask2).getHeight());
            }
            oSB.flush();
            oSB.setShader(AoCGame.shaderDef);
            if (GameValues.gvVassal.ENABLE_VASSAL_LORD_FLAG && !CFG.core.getCiv((int)this.getFlagCivID()).iFVS && !this.getIsHovered() && CFG.core.getCiv(this.getFlagCivID()).getPuppetOfCiv() != this.getFlagCivID()) {
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
                this.getFlag().getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                IMGManager.getIMG(Images.flagBigMask).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, IMGManager.getIMG(Images.flagBigMask).getWidth(), IMGManager.getIMG(Images.flagBigMask).getHeight());
            } else {
                Renderer.setShaderWater3(oSB);
                Renderer.shaderWater3.setUniformf("u_maskScale", 1.0f);
                Renderer.shaderWater3.setUniformf("u_maskScaleY", 1.0f);
                IMGManager.getIMG(Images.flagBigMask).getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                this.getFlag().draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, IMGManager.getIMG(Images.flagBigMask).getWidth(), IMGManager.getIMG(Images.flagBigMask).getHeight());
            }
            oSB.flush();
            oSB.setShader(AoCGame.shaderDef);
            if (GameValues.gvVassal.ENABLE_VASSAL_LORD_FLAG && !CFG.core.getCiv((int)this.getFlagCivID()).iFVS && !this.getIsHovered() && CFG.core.getCiv(this.getFlagCivID()).getPuppetOfCiv() != this.getFlagCivID()) {
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

    public Image getFlag() {
        try {
            if (CFG.createVassalData.getFlagOfCivH() != null) {
                return CFG.createVassalData.getFlagOfCivH();
            }
            return IMGManager.getIMG(Images.randomCivilizationFlag);
        }
        catch (Exception ex) {
            return IMGManager.getIMG(Images.randomCivilizationFlag);
        }
    }
}

