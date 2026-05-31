
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;

public class Button_Diplomacy_Flag
extends ButtonStats {
    public static final float FONT_SCALE = 0.75f;
    public int iCivID;
    public Image civFlag;

    public Button_Diplomacy_Flag(int nCivID, int iPosX, int iPosY, int iWidth) {
        super(CFG.core.getCiv(nCivID).getCivName(), 0, iPosX, iPosY, iWidth, CFG.TEXT_HEIGHT_DEFAULT * 2 + CFG.PADD * 4);
        this.civFlag = null;
        this.iCivID = nCivID;
        if (this.iCivID >= 0) {
            try {
                try {
                    this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + CFG.core.getCiv(this.iCivID).getCivTag() + ".png")), Texture.TextureFilter.Linear);
                }
                catch (GdxRuntimeException e) {
                    try {
                        try {
                            this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.iCivID).getCivTag()) + ".png")), Texture.TextureFilter.Linear);
                        }
                        catch (GdxRuntimeException ex) {
                            try {
                                this.civFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.core.getCiv(this.iCivID).getCivTag() + ".png")), Texture.TextureFilter.Linear);
                            }
                            catch (GdxRuntimeException exr) {
                                this.civFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.iCivID).getCivTag()) + ".png")), Texture.TextureFilter.Linear);
                            }
                        }
                    }
                    catch (GdxRuntimeException er) {
                        if (CFG.isAndroid()) {
                            try {
                                this.civFlag = new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.iCivID).getCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.iCivID).getCivTag()) + "_FLH.png")), Texture.TextureFilter.Linear);
                            }
                            catch (GdxRuntimeException erq) {
                                this.civFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.iCivID).getCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.iCivID).getCivTag()) + "_FLH.png")), Texture.TextureFilter.Linear);
                            }
                        } else {
                            this.civFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.iCivID).getCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.iCivID).getCivTag()) + "_FLH.png")), Texture.TextureFilter.Linear);
                        }
                    }
                }
            }
            catch (GdxRuntimeException ex) {
                this.civFlag = null;
            }
            catch (OutOfMemoryError e) {
                this.civFlag = null;
            }
        } else {
            this.civFlag = null;
        }
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
        if (this.civFlag != null) {
            try {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
                oSB.setShader(Renderer.shaderAlpha);
                IMGManager.getIMG(Images.sliderGradient).getTexture().bind(2);
                this.civFlag.getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * 68.0f), this.getHeightE(), false, false);
                oSB.setShader(AoCGame.shaderDef);
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.1f));
                oSB.setShader(Renderer.shaderAlpha);
                IMGManager.getIMG(Images.gradient).getTexture().bind(2);
                this.civFlag.getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * 68.0f), this.getHeightE(), false, false);
                oSB.setShader(AoCGame.shaderDef);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * 68.0f), this.getHeightE(), false, false);
            }
            catch (NullPointerException ex) {
                oSB.setShader(AoCGame.shaderDef);
            }
        } else {
            oSB.setShader(AoCGame.shaderDef);
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.825f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)this.getHeightE() / 44.0f * (float)CFG.PADD), this.getHeightE(), false, false);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        try {
            oSB.setColor(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 1.0f));
        }
        catch (IndexOutOfBoundsException ex) {
            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 1.0f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - 2 - IMGManager.getIMG(Images.diploRivals).getWidth() / 2 + iTranslateX, this.getPosY() + CFG.PADD + CFG.PADD / 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 2, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        oSB.setColor(Color.WHITE);
        try {
            CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) - IMGManager.getIMG(Images.diploRivals).getWidth() / 2 + iTranslateX, this.getPosY() + CFG.PADD + CFG.PADD / 2 + (CFG.TEXT_HEIGHT_DEFAULT - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - CFG.core.getCiv(this.iCivID).getFlagC().getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        }
        catch (IndexOutOfBoundsException ex) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) - IMGManager.getIMG(Images.diploRivals).getWidth() / 2 + iTranslateX, this.getPosY() + CFG.PADD + CFG.PADD / 2 + (CFG.TEXT_HEIGHT_DEFAULT - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD - 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) - IMGManager.getIMG(Images.diploRivals).getWidth() / 2 + iTranslateX, this.getPosY() + CFG.PADD + CFG.PADD / 2 + (CFG.TEXT_HEIGHT_DEFAULT - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall))) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        CFG.fontMain.get(0).getData().setScale(0.75f);
        CFG.drawTextDefaultWithShadow(oSB, this.getTextE(), this.getPosXE() + this.getWidthE() - CFG.PADD - 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) - IMGManager.getIMG(Images.diploRivals).getWidth() / 2 - (int)((float)this.getTextWidthU() * 0.75f) - CFG.PADD + iTranslateX, this.getPosY() + CFG.PADD + CFG.PADD / 2 + (int)(((float)CFG.TEXT_HEIGHT_DEFAULT - (float)CFG.TEXT_HEIGHT_DEFAULT * 0.75f) / 2.0f) + iTranslateY, this.getColorE(isActive));
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID));
        nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS);
    }

    public final float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    @Override
    public void setVisibleE(boolean isVisible) {
        super.setVisibleE(isVisible);
        if (!isVisible) {
            
        }
    }

    @Override
    public int getCurr() {
        return this.iCivID;
    }
}

