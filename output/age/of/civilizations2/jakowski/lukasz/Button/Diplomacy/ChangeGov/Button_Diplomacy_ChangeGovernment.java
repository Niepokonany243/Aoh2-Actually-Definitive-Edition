/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ChangeGov;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.IdeologiesManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class Button_Diplomacy_ChangeGovernment
extends ButtonStats {
    private int iIdeologyID;
    private String sAgeName;
    private int iAgeNameWidth;
    private Image civFlag;

    public Button_Diplomacy_ChangeGovernment(int i, int iCivA, int nIdeologyID, int iPosX, int iPosY, int iWidth) {
        super(CFG.ideologiesMgr.getIdeologyID(nIdeologyID).getName(), 0, iPosX, iPosY, iWidth, Math.max(CFG.BUTTON_H * 3 / 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 6), false);
        this.iIdeologyID = nIdeologyID;
        this.row = i % 2 == 0;
        this.sAgeName = CFG.gameAges.getAge(CFG.ideologiesMgr.getIdeologyID((int)this.iIdeologyID).AVAILABLE_SINCE_AGE_ID).getName();
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.sAgeName);
        this.iAgeNameWidth = (int)CFG.glyphLay.width;
        this.loadFlag(CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(iCivA).getCivTag()) + CFG.ideologiesMgr.getIdeologyID(nIdeologyID).getExtraTag());
    }

    public final void loadFlag(String nTag) {
        block13: {
            try {
                try {
                    this.civFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + nTag + ".png")), Texture.TextureFilter.Nearest);
                }
                catch (GdxRuntimeException e) {
                    try {
                        try {
                            try {
                                this.civFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png")), Texture.TextureFilter.Nearest);
                            }
                            catch (Exception exr) {
                                this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + nTag + ".png")), Texture.TextureFilter.Linear);
                            }
                        }
                        catch (Exception exrr) {
                            this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png")), Texture.TextureFilter.Linear);
                        }
                    }
                    catch (GdxRuntimeException ex) {
                        if (CFG.isAndroid()) {
                            try {
                                this.civFlag = new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(nTag) + "/" + CFG.ideologiesMgr.getRealTag(nTag) + "_FL.png")), Texture.TextureFilter.Nearest);
                            }
                            catch (GdxRuntimeException erq) {
                                this.civFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(nTag) + "/" + CFG.ideologiesMgr.getRealTag(nTag) + "_FL.png")), Texture.TextureFilter.Nearest);
                            }
                            break block13;
                        }
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(nTag) + "/" + CFG.ideologiesMgr.getRealTag(nTag) + "_FL.png")), Texture.TextureFilter.Nearest);
                    }
                }
            }
            catch (GdxRuntimeException ex) {
                this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png")), Texture.TextureFilter.Nearest);
            }
        }
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.row) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.15f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 6, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 6 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 6, this.getHeightE(), true, false);
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.05f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 6, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 6 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 6, this.getHeightE(), true, false);
        }
        if (isActive || this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, isActive ? 0.345f : 0.265f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2);
        }
        if (this.row) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.625f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE());
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.375f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE());
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        this.civFlag.drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - this.civFlag.getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)) / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)), (int)((float)IMGManager.getIMG(Images.flagRectSmall).getHeight() * this.getImageScale(Images.flagRectSmall)));
        if (!this.getIsClickable()) {
            oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.675f));
        }
        IMGManager.getIMG(Images.time).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Images.time).getWidth() * this.getImageScale(Images.time)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(Images.time).getHeight() * this.getImageScale(Images.time)) / 2 - IMGManager.getIMG(Images.time).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.time).getWidth() * this.getImageScale(Images.time)), (int)((float)IMGManager.getIMG(Images.time).getHeight() * this.getImageScale(Images.time)));
        oSB.setColor(Color.WHITE);
        if (!this.getIsClickable()) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.65f));
        }
        CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getCrownImageScaled().drawO(oSB, this.getPosXE() + (IdeologiesManager.MAX_CROWN_WIDTH + CFG.PADD * 2) / 2 - (int)((float)CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getCrownImageScaled().getWidth() * this.getImageScale_Ideology()) / 2 + CFG.PADD * 3 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getCrownImageScaled().getHeight() * this.getImageScale_Ideology()) / 2 - CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getCrownImageScaled().getHeight() + iTranslateY, (int)((float)CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getCrownImageScaled().getWidth() * this.getImageScale_Ideology()), (int)((float)CFG.ideologiesMgr.getIdeologyID(this.iIdeologyID).getCrownImageScaled().getHeight() * this.getImageScale_Ideology()));
        oSB.setColor(Color.WHITE);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, "" + this.sAgeName, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - (int)((float)IMGManager.getIMG(Images.time).getWidth() * this.getImageScale(Images.time)) - this.iAgeNameWidth + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() / 2.0f) + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD * 4 + (int)((float)IMGManager.getIMG(Images.flagRectSmall).getWidth() * this.getImageScale(Images.flagRectSmall)) + IdeologiesManager.MAX_CROWN_WIDTH + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() / 2.0f) + iTranslateY, this.getIsClickable() ? new Color(CFG.ideologiesMgr.getIdeologyID((int)this.iIdeologyID).getColor().r, CFG.ideologiesMgr.getIdeologyID((int)this.iIdeologyID).getColor().g, CFG.ideologiesMgr.getIdeologyID((int)this.iIdeologyID).getColor().b, 1.0f) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.35f));
        oSB.setColor(Color.WHITE);
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (Button_Diplomacy_ChangeGovernment.this.getCheckboxSt()) {
                        oSB.setColor(new Color(0.55f, 0.8f, 0.0f, 0.2f));
                    } else {
                        oSB.setColor(new Color(0.8f, 0.137f, 0.0f, 0.15f));
                    }
                    IMGManager.getIMG(Images.line32Off1).drawO(oSB, Button_Diplomacy_ChangeGovernment.this.getPosXE() + iTranslateX, Button_Diplomacy_ChangeGovernment.this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + 1 + iTranslateY, Button_Diplomacy_ChangeGovernment.this.getWidthE(), Button_Diplomacy_ChangeGovernment.this.getHeightE() - 2, true, false);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Diplomacy_ChangeGovernment.this.getPosXE() + iTranslateX, Button_Diplomacy_ChangeGovernment.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, Button_Diplomacy_ChangeGovernment.this.getWidthE(), Button_Diplomacy_ChangeGovernment.this.getHeightE() / 4, false, false);
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Diplomacy_ChangeGovernment.this.getPosXE() + iTranslateX, Button_Diplomacy_ChangeGovernment.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + Button_Diplomacy_ChangeGovernment.this.getHeightE() - 1 + iTranslateY - Button_Diplomacy_ChangeGovernment.this.getHeightE() / 4, Button_Diplomacy_ChangeGovernment.this.getWidthE(), Button_Diplomacy_ChangeGovernment.this.getHeightE() / 4, false, true);
                    oSB.setColor(Color.WHITE);
                }
            };
        }
        return new ButtonM.Checkbox(){

            @Override
            public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
            }
        };
    }

    private final float getImageScale(int nImageID) {
        return 1.0f;
    }

    private final float getImageScale_Ideology() {
        return 1.0f;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS);
    }

    @Override
    public void buildElemHover() {
        this.menuElemHover = CFG.ideologiesMgr.getIdeologyHover_Just(this.iIdeologyID);
    }

    @Override
    public int getCurr() {
        return this.iIdeologyID;
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }

    @Override
    public void setVisibleE(boolean isVisible) {
        super.setVisibleE(isVisible);
        if (!isVisible && this.civFlag != null) {
            this.civFlag.getTexture().dispose();
            this.civFlag = null;
        }
    }
}

