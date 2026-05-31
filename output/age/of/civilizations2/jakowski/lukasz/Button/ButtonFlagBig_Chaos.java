/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameN;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Religion;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class ButtonFlagBig_Chaos
extends ButtonM {
    public boolean inAnimation = false;
    private long currentTime = 0L;
    private int ANIMATION_TIME = 750;
    public boolean drawLordFlag = true;
    public int civID = 0;
    public SparksAnimation sparksAnimation = new SparksAnimation();
    public String provinces;
    public int provinceW = 0;

    public static int getButtonH() {
        return IMGManager.getIMG(Images.flagBigOver2).getHeight() + ButtonFlagBig_Chaos.flagPaddingY() * 3 + CFG.TEXT_HEIGHT_DEFAULT * 2 + CFG.PADD * 1;
    }

    public static int flagPaddingY() {
        return CFG.PADD * 2;
    }

    public ButtonFlagBig_Chaos(int civID, int iPosX, int iPosY, int width, int height, boolean isClickable, boolean drawLordFlag) {
        this.init(CFG.core.getCiv(civID).getCivName(), this.iTextPositionX, iPosX, iPosY, width, height, isClickable, true, false, false);
        this.civID = civID;
        this.drawLordFlag = drawLordFlag;
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.BUTTON_FLAG;
        this.provinces = CFG.lang.get("Provinces") + ": " + CFG.getNumberWthSpaces("" + CFG.core.getCiv(civID).getNumOfProvs());
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.provinces);
        this.provinceW = (int)CFG.glyphLay.width;
        this.updateLanguage();
    }

    protected void drawBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Core.drawMenuBG(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        if (this.getIsHovered()) {
            this.sparksAnimation.draw2(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        }
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() * 2 + IMGManager.getIMG(Images.flagBigMask2).getHeight() + iTranslateY, this.getColorE(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.provinces, this.getPosXE() + this.getWidthE() / 2 - this.provinceW / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() * 2 + IMGManager.getIMG(Images.flagBigMask2).getHeight() + CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT + iTranslateY, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        this.drawBG(oSB, iTranslateX, iTranslateY, isActive);
        Core.drawFlagBigGovernment(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagBigMask2).getWidth() / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() + iTranslateY, this.getFlagCivID());
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
        return this.civID;
    }

    protected void drawFlag(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (GameCalendar.currYear > ButtonFlagBig.year) {
            if (CFG.core.getCiv((int)this.getFlagCivID()).isFlagNearest || GameN.FUEVG) {
                oSB.setShader(Renderer.shaderAlpha);
                CFG.core.getCiv(this.getFlagCivID()).getFlagC().getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                IMGManager.getIMG(Images.flagBigMask2).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagBigMask2).getWidth() / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() + iTranslateY, IMGManager.getIMG(Images.flagBigMask2).getWidth(), IMGManager.getIMG(Images.flagBigMask2).getHeight());
            } else {
                Renderer.setShaderWater3(oSB);
                Renderer.shaderWater3.setUniformf("u_maskScale", 1.0f);
                Renderer.shaderWater3.setUniformf("u_maskScaleY", 1.0f);
                IMGManager.getIMG(Images.flagBigMask2).getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                CFG.core.getCiv(this.getFlagCivID()).getFlagC().draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagBigMask2).getWidth() / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() + iTranslateY, IMGManager.getIMG(Images.flagBigMask2).getWidth(), IMGManager.getIMG(Images.flagBigMask2).getHeight());
            }
            oSB.flush();
            oSB.setShader(AoCGame.shaderDef);
            if (this.drawLordFlag && GameValues.gvVassal.ENABLE_VASSAL_LORD_FLAG && !this.getIsHovered() && CFG.core.getCiv(this.getFlagCivID()).getPuppetOfCiv() != this.getFlagCivID()) {
                if (CFG.core.getCiv((int)CFG.core.getCiv((int)this.getFlagCivID()).getPuppetOfCiv()).isFlagNearest || GameN.FUEVG) {
                    oSB.setShader(Renderer.shaderAlpha);
                    CFG.core.getCiv(CFG.core.getCiv(this.getFlagCivID()).getPuppetOfCiv()).getFlagC().getTexture().bind(1);
                    Gdx.gl.glActiveTexture(33984);
                    IMGManager.getIMG(Images.flagBigMaskLord2).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagBigMask2).getWidth() / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() + iTranslateY, IMGManager.getIMG(Images.flagBigMaskLord2).getWidth(), IMGManager.getIMG(Images.flagBigMaskLord2).getHeight());
                } else {
                    Renderer.setShaderWater3(oSB);
                    Renderer.shaderWater3.setUniformf("u_maskScale", 1.0f);
                    Renderer.shaderWater3.setUniformf("u_maskScaleY", 1.0f);
                    IMGManager.getIMG(Images.flagBigMaskLord2).getTexture().bind(1);
                    Gdx.gl.glActiveTexture(33984);
                    CFG.core.getCiv(CFG.core.getCiv(this.getFlagCivID()).getPuppetOfCiv()).getFlagC().draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagBigMask2).getWidth() / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() + iTranslateY, IMGManager.getIMG(Images.flagBigMaskLord2).getWidth(), IMGManager.getIMG(Images.flagBigMaskLord2).getHeight());
                }
                oSB.flush();
                oSB.setShader(AoCGame.shaderDef);
            }
            IMGManager.getIMG(Images.flagBigOver2).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagBigMask2).getWidth() / 2 + (IMGManager.getIMG(Images.flagBigMask2).getWidth() - IMGManager.getIMG(Images.flagBigOver2).getWidth()) / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() + iTranslateY);
            if (this.getIsHovered() || isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.3f));
                IMGManager.getIMG(Images.flagBigOver2).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagBigMask2).getWidth() / 2 + (IMGManager.getIMG(Images.flagBigMask2).getWidth() - IMGManager.getIMG(Images.flagBigOver2).getWidth()) / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() + iTranslateY);
            }
        } else {
            if (CFG.core.getCiv((int)this.getFlagCivID()).isFlagNearest || GameN.FUEVG) {
                oSB.setShader(Renderer.shaderAlpha);
                CFG.core.getCiv(this.getFlagCivID()).getFlagC().getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                IMGManager.getIMG(Images.flagBigMask).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagBigMask2).getWidth() / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() + iTranslateY, IMGManager.getIMG(Images.flagBigMask).getWidth(), IMGManager.getIMG(Images.flagBigMask).getHeight());
            } else {
                Renderer.setShaderWater3(oSB);
                Renderer.shaderWater3.setUniformf("u_maskScale", 1.0f);
                Renderer.shaderWater3.setUniformf("u_maskScaleY", 1.0f);
                IMGManager.getIMG(Images.flagBigMask).getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                CFG.core.getCiv(this.getFlagCivID()).getFlagC().draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagBigMask2).getWidth() / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() + iTranslateY, IMGManager.getIMG(Images.flagBigMask).getWidth(), IMGManager.getIMG(Images.flagBigMask).getHeight());
            }
            oSB.flush();
            oSB.setShader(AoCGame.shaderDef);
            if (this.drawLordFlag && GameValues.gvVassal.ENABLE_VASSAL_LORD_FLAG && !this.getIsHovered() && CFG.core.getCiv(this.getFlagCivID()).getPuppetOfCiv() != this.getFlagCivID()) {
                if (CFG.core.getCiv((int)CFG.core.getCiv((int)this.getFlagCivID()).getPuppetOfCiv()).isFlagNearest || GameN.FUEVG) {
                    oSB.setShader(Renderer.shaderAlpha);
                    CFG.core.getCiv(CFG.core.getCiv(this.getFlagCivID()).getPuppetOfCiv()).getFlagC().getTexture().bind(1);
                    Gdx.gl.glActiveTexture(33984);
                    IMGManager.getIMG(Images.flagBigMaskLord).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagBigMask2).getWidth() / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() + iTranslateY, IMGManager.getIMG(Images.flagBigMaskLord).getWidth(), IMGManager.getIMG(Images.flagBigMaskLord).getHeight());
                } else {
                    Renderer.setShaderWater3(oSB);
                    Renderer.shaderWater3.setUniformf("u_maskScale", 1.0f);
                    Renderer.shaderWater3.setUniformf("u_maskScaleY", 1.0f);
                    IMGManager.getIMG(Images.flagBigMaskLord).getTexture().bind(1);
                    Gdx.gl.glActiveTexture(33984);
                    CFG.core.getCiv(CFG.core.getCiv(this.getFlagCivID()).getPuppetOfCiv()).getFlagC().draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagBigMask2).getWidth() / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() + iTranslateY, IMGManager.getIMG(Images.flagBigMaskLord).getWidth(), IMGManager.getIMG(Images.flagBigMaskLord).getHeight());
                }
                oSB.flush();
                oSB.setShader(AoCGame.shaderDef);
            }
            IMGManager.getIMG(Images.flagBigOver).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagBigMask2).getWidth() / 2 + (IMGManager.getIMG(Images.flagBigMask).getWidth() - IMGManager.getIMG(Images.flagBigOver).getWidth()) / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() + iTranslateY);
            if (this.getIsHovered() || isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.3f));
                IMGManager.getIMG(Images.flagBigOver).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.flagBigMask2).getWidth() / 2 + (IMGManager.getIMG(Images.flagBigMask).getWidth() - IMGManager.getIMG(Images.flagBigOver).getWidth()) / 2 + iTranslateX, this.getPosY() + ButtonFlagBig_Chaos.flagPaddingY() + iTranslateY);
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
    public void buildElemHover() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Flag_Big(this.civID));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.civID).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.civID).getNumOfProvs()), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.civID).countPop()), CFG.COLOR_POPULATION));
            nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(this.civID).countPop()), CFG.COLOR_ECONOMY));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Government") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(this.civID).getIdeology()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Ideology(CFG.core.getCiv(this.civID).getIdeology(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Religion") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + CFG.religionManager.getReligion(CFG.core.getCiv(this.civID).getReligionID()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Religion(CFG.core.getCiv(this.civID).getReligionID(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            int tTotal = (int)CFG.gameUpdate.getProvIncomeAndExpenses_Total(CFG.ACTIVE_PROVINCE_INFO);
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Balance") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tTotal), tTotal > 0 ? CFG.COLOR_POSITIVE : (tTotal == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            this.menuElemHover = new ME_Hover_v2(nElements);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            this.menuElemHover = null;
        }
    }
}

