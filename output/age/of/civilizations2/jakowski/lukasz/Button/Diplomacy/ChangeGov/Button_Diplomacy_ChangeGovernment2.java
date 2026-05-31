/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ChangeGov;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class Button_Diplomacy_ChangeGovernment2
extends ButtonM {
    public boolean backAnimation = false;
    public int ideologyID;
    public boolean row = false;
    public String sCost;
    public int iCostWidth;
    public static float ICON_SCALE = 1.0f;
    private Image civFlag = null;
    public TextD taxation;
    public TextD goods;
    public TextD investments;
    public TextD move;
    public TextD recruit;
    public TextD defense;
    public TextD incomeT;
    public TextD incomeP;
    public TextD admin;

    public Button_Diplomacy_ChangeGovernment2(int nIdeologyID, int iPosX, int iPosY, int iWidth, boolean isClickable, int civA) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(CFG.ideologiesMgr.getIdeologyID(nIdeologyID).getName(), 0, iPosX, iPosY, iWidth, CFG.BUTTON_H, isClickable, true, true, false);
        this.ideologyID = nIdeologyID;
        this.taxation = new TextD((int)(CFG.ideologiesMgr.getIdeologyID((int)this.ideologyID).ACCEPTABLE_TAXATION * 100.0f) + "%");
        this.goods = new TextD((int)(CFG.ideologiesMgr.getIdeologyID((int)this.ideologyID).MIN_GOODS * 100.0f) + "%");
        this.investments = new TextD((int)(CFG.ideologiesMgr.getIdeologyID((int)this.ideologyID).MIN_INVESTMENTS * 100.0f) + "%");
        this.move = new TextD((float)CFG.ideologiesMgr.getIdeologyID((int)this.ideologyID).COST_OF_MOVE / 10.0f + "");
        this.recruit = new TextD((float)CFG.ideologiesMgr.getIdeologyID((int)this.ideologyID).COST_OF_RECRUIT / 10.0f + "");
        this.defense = new TextD(CFG.ideologiesMgr.getIdeologyID((int)this.ideologyID).DEFENSE_BONUS + "%");
        this.incomeT = new TextD((int)(CFG.ideologiesMgr.getIdeologyID((int)this.ideologyID).INCOME_TAXATION * 100.0f - 100.0f) + "%");
        this.incomeP = new TextD((int)(CFG.ideologiesMgr.getIdeologyID((int)this.ideologyID).INCOME_PRODUCTION * 100.0f - 100.0f) + "%");
        this.admin = new TextD((int)(CFG.ideologiesMgr.getIdeologyID((int)this.ideologyID).ADMINISTRATION_COST * 100.0f - 100.0f) + "%");
        this.loadFlag(CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(civA).getCivTag()) + CFG.ideologiesMgr.getIdeologyID(nIdeologyID).getExtraTag());
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

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (Button_Diplomacy_ChangeGovernment2.this.getCheckboxSt()) {
                        oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.2f));
                        IMGManager.getIMG(Images.patternSquareTiny).draw2O(oSB, Button_Diplomacy_ChangeGovernment2.this.getPosXE() + iTranslateX, Button_Diplomacy_ChangeGovernment2.this.getPosY() - IMGManager.getIMG(Images.patternSquareTiny).getHeight() + 1 + iTranslateY, ButtonDiplomacy.iDiploWidth, Button_Diplomacy_ChangeGovernment2.this.getHeightE() - 2, true, false);
                        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
                        IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Diplomacy_ChangeGovernment2.this.getPosXE() + iTranslateX, Button_Diplomacy_ChangeGovernment2.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, ButtonDiplomacy.iDiploWidth, Button_Diplomacy_ChangeGovernment2.this.getHeightE() / 4, false, false);
                        IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Diplomacy_ChangeGovernment2.this.getPosXE() + iTranslateX, Button_Diplomacy_ChangeGovernment2.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + Button_Diplomacy_ChangeGovernment2.this.getHeightE() - 1 + iTranslateY - Button_Diplomacy_ChangeGovernment2.this.getHeightE() / 4, ButtonDiplomacy.iDiploWidth, Button_Diplomacy_ChangeGovernment2.this.getHeightE() / 4, false, true);
                        oSB.setColor(Color.WHITE);
                    }
                    oSB.setColor(new Color(CFG.ideologiesMgr.getIdeologyID((int)Button_Diplomacy_ChangeGovernment2.this.ideologyID).getColor().r, CFG.ideologiesMgr.getIdeologyID((int)Button_Diplomacy_ChangeGovernment2.this.ideologyID).getColor().g, CFG.ideologiesMgr.getIdeologyID((int)Button_Diplomacy_ChangeGovernment2.this.ideologyID).getColor().b, 1.0f));
                    IMGManager.getIMG(Images.gradientXY).draw2(oSB, Button_Diplomacy_ChangeGovernment2.this.getPosXE() + iTranslateX, Button_Diplomacy_ChangeGovernment2.this.getPosY() + 1 + iTranslateY, ButtonDiplomacy.iDiploWidth, Button_Diplomacy_ChangeGovernment2.this.getHeightE() - 2);
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

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD * 2, this.getHeightE(), false, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
        if (this.row) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.4f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.35f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.35f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.6f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.85f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            if (isActive || this.getIsHovered()) {
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        CFG.ideologiesMgr.getIdeologyID(this.ideologyID).getCrownImageScaled().drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth / 2 - CFG.ideologiesMgr.getIdeologyID(this.ideologyID).getCrownImageScaled().getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.ideologiesMgr.getIdeologyID(this.ideologyID).getCrownImageScaled().getHeight() / 2 + iTranslateY);
        try {
            if (this.civFlag != null) {
                oSB.setShader(Renderer.shaderAlpha);
                int posX = this.getPosXE() + ButtonDiplomacy.iDiploWidth + CFG.PADD * 2 + iTranslateX;
                int posY = this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY;
                this.civFlag.getTexture().bind(1);
                Gdx.gl.glActiveTexture(33984);
                IMGManager.getIMG(Images.flagRect2Mask).draw(oSB, posX, posY, IMGManager.getIMG(Images.flagRect2Mask).getWidth(), IMGManager.getIMG(Images.flagRect2Mask).getHeight());
                oSB.flush();
                oSB.setShader(AoCGame.shaderDef);
                IMGManager.getIMG(Images.flagRect2).draw(oSB, posX, posY, IMGManager.getIMG(Images.flagRect2).getWidth(), IMGManager.getIMG(Images.flagRect2).getHeight());
            }
        }
        catch (Exception posX) {
            // empty catch block
        }
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + ButtonDiplomacy.iDiploWidth + CFG.PADD * 4 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY, this.getColorE(isActive));
        int pX = this.getPosXE() + ButtonDiplomacy.iDiploWidth + CFG.PADD * 4 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX;
        int pYT = this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY;
        int pYI = this.getPosY() + this.getHeightE() / 2 + CFG.PADD + this.getTextHeight() / 2 + iTranslateY;
        int pYT2 = this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY;
        int pYI2 = this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() / 2 + iTranslateY;
        int img = Images.topGold();
        int imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        int imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX, pYI - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.taxation.text, pX += imgW + CFG.PADD, pYT, this.getColorE(isActive));
        img = Images.goods;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX += this.taxation.textW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.goods.text, pX += imgW + CFG.PADD, pYT, this.getColorE(isActive));
        img = Images.development;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        IMGManager.getIMG(img).draw(oSB, pX += this.goods.textW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.investments.text, pX += imgW + CFG.PADD, pYT, this.getColorE(isActive));
        pX += this.investments.textW + CFG.PADD;
        pX = this.getWidthE() - CFG.PADD + iTranslateX;
        img = Images.topMovementPoints;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.move.text, pX -= this.move.textW, pYT2, this.getColorE(isActive));
        IMGManager.getIMG(img).draw(oSB, pX -= imgW + CFG.PADD, pYI2 - imgH / 2, imgW, imgH);
        img = Images.diploArmy;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.recruit.text, pX -= this.recruit.textW + CFG.PADD, pYT2, this.getColorE(isActive));
        IMGManager.getIMG(img).draw(oSB, pX -= imgW + CFG.PADD, pYI2 - imgH / 2, imgW, imgH);
        img = Images.defense;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.defense.text, pX -= this.defense.textW + CFG.PADD, pYT2, this.getColorE(isActive));
        IMGManager.getIMG(img).draw(oSB, pX -= imgW + CFG.PADD, pYI2 - imgH / 2, imgW, imgH);
        pX = this.getWidthE() - CFG.PADD + iTranslateX;
        img = Images.administration;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.admin.text, pX -= this.admin.textW, pYT, this.getColorE(isActive));
        IMGManager.getIMG(img).draw(oSB, pX -= imgW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        img = Images.economy;
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.incomeP.text, pX -= this.incomeP.textW + CFG.PADD, pYT, this.getColorE(isActive));
        IMGManager.getIMG(img).draw(oSB, pX -= imgW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
        img = Images.topGold();
        imgW = (int)((float)IMGManager.getIMG(img).getWidth() * this.getImageScale(img));
        imgH = (int)((float)IMGManager.getIMG(img).getHeight() * this.getImageScale(img));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_REGULAR_SMALL, this.incomeT.text, pX -= this.incomeT.textW + CFG.PADD, pYT, this.getColorE(isActive));
        IMGManager.getIMG(img).draw(oSB, pX -= imgW + CFG.PADD, pYI - imgH / 2, imgW, imgH);
    }

    public float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    public float getImageScale(int nImageID, float nTextScale) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * nTextScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.525f));
    }

    @Override
    public void setCurr(int nCurrent) {
        this.row = nCurrent == 1;
    }

    @Override
    public void buildElemHover() {
        this.menuElemHover = CFG.ideologiesMgr.getIdeologyHover_Just(this.ideologyID);
    }

    @Override
    public int getCurr() {
        return this.ideologyID;
    }

    public class TextD {
        public String text;
        public int textW;

        public TextD(String nText) {
            this.text = nText;
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_REGULAR_SMALL), this.text);
            this.textW = (int)CFG.glyphLay.width;
        }
    }
}

