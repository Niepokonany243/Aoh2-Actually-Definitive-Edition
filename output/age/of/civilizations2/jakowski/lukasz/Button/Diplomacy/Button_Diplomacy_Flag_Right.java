/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_Flag;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Diplomacy_Flag_Right
extends Button_Diplomacy_Flag {
    public Button_Diplomacy_Flag_Right(int iCivID, int iPosX, int iPosY, int iWidth) {
        super(iCivID, iPosX, iPosY, iWidth);
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
        if (this.civFlag != null) {
            try {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
                oSB.setShader(Renderer.shaderAlpha);
                IMGManager.getIMG(Images.sliderGradient).getTexture().bind(2);
                this.civFlag.getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - (int)((float)this.getHeightE() / 44.0f * 68.0f) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * 68.0f), this.getHeightE(), true, false);
                oSB.setShader(AoCGame.shaderDef);
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.1f));
                oSB.setShader(Renderer.shaderAlpha);
                IMGManager.getIMG(Images.gradient).getTexture().bind(2);
                this.civFlag.getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + this.getWidthE() - (int)((float)this.getHeightE() / 44.0f * 68.0f) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * 68.0f), this.getHeightE(), true, false);
                oSB.setShader(AoCGame.shaderDef);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - (int)((float)this.getHeightE() / 44.0f * 68.0f) + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * 68.0f), this.getHeightE(), true, false);
            }
            catch (NullPointerException ex) {
                oSB.setShader(AoCGame.shaderDef);
            }
        } else {
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
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.PADD + IMGManager.getIMG(Images.diploRivals).getWidth() / 2 + iTranslateX, this.getPosY() + CFG.PADD + CFG.PADD / 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
        try {
            CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getPosXE() + CFG.PADD + 2 + IMGManager.getIMG(Images.diploRivals).getWidth() / 2 + iTranslateX, this.getPosY() + CFG.PADD + CFG.PADD / 2 + (CFG.TEXT_HEIGHT_DEFAULT - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - CFG.core.getCiv(this.iCivID).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + CFG.PADD + 2 + IMGManager.getIMG(Images.diploRivals).getWidth() / 2 + iTranslateX, this.getPosY() + CFG.PADD + CFG.PADD / 2 + (CFG.TEXT_HEIGHT_DEFAULT - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD + 2 + IMGManager.getIMG(Images.diploRivals).getWidth() / 2 + iTranslateX, this.getPosY() + CFG.PADD + CFG.PADD / 2 + (CFG.TEXT_HEIGHT_DEFAULT - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        CFG.fontMain.get(0).getData().setScale(0.75f);
        CFG.drawTextDefaultWithShadow(oSB, this.getTextE(), this.getPosXE() + CFG.PADD * 2 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + 2 + IMGManager.getIMG(Images.diploRivals).getWidth() / 2 + iTranslateX, this.getPosY() + CFG.PADD + CFG.PADD / 2 + (int)(((float)CFG.TEXT_HEIGHT_DEFAULT - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.75f) / 2.0f) + iTranslateY, this.getColorE(isActive));
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }
}

