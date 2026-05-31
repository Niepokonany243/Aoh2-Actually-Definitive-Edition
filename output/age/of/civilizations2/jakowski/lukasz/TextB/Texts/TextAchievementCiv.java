/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization_GameData3;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextAchievementCiv
extends Text {
    private Image civFlag;
    private String sTag;
    private boolean gameWon;
    private int iSRID;
    private List<Color> lColors;

    public TextAchievementCiv(String sTag, int iPosX, int iPosY, int iWidth, String nTagID, boolean gameWon) {
        super(CFG.lang.getCiv(sTag), 0, iPosX, iPosY, iWidth, Math.max(CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4), CFG.FONT_BOLD_SMALL);
        Civilization_GameData3 tempSR = null;
        boolean modified = false;
        this.gameWon = false;
        this.iSRID = 0;
        this.lColors = new ArrayList<Color>();
        this.sTag = sTag;
        this.loadFlag(sTag);
        this.gameWon = gameWon;
        String tempTag = nTagID;
        if (tempTag.indexOf(";") > 0) {
            String[] tData = tempTag.split(";");
            tempTag = tData[0];
        }
        try {
            try {
                FileHandle fileSR = FileManager.loadFile("game/civilizations/" + tempTag);
                tempSR = (Civilization_GameData3)CFG.deserialize(fileSR.readBytes());
            }
            catch (GdxRuntimeException ex) {
                try {
                    FileHandle fileSR = FileManager.loadFile("game/civilizations/" + CFG.ideologiesMgr.getRealTag(tempTag));
                    tempSR = (Civilization_GameData3)CFG.deserialize(fileSR.readBytes());
                }
                catch (GdxRuntimeException esx) {
                    try {
                        FileHandle fileSR = Gdx.files.local("game/civilizations_editor/" + tempTag + "/" + tempTag);
                        tempSR = (Civilization_GameData3)CFG.deserialize(fileSR.readBytes());
                    }
                    catch (GdxRuntimeException exr) {
                        try {
                            FileHandle fileSR = FileManager.loadFile("game/civilizations_editor/" + tempTag + "/" + tempTag);
                            tempSR = (Civilization_GameData3)CFG.deserialize(fileSR.readBytes());
                        }
                        catch (GdxRuntimeException eqr) {
                            try {
                                FileHandle fileSR = Gdx.files.local("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(tempTag) + "/" + CFG.ideologiesMgr.getRealTag(tempTag));
                                tempSR = (Civilization_GameData3)CFG.deserialize(fileSR.readBytes());
                            }
                            catch (GdxRuntimeException eqrt) {
                                FileHandle fileSR = FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(tempTag) + "/" + CFG.ideologiesMgr.getRealTag(tempTag));
                                tempSR = (Civilization_GameData3)CFG.deserialize(fileSR.readBytes());
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            if (CFG.LOGs) {
                CFG.exceptionStack(e);
            }
        }

        if (tempSR != null && tempSR.sr_GameData != null) {
            this.iSRID = CFG.serviceRibbonMgr.getSRID(tempSR.sr_GameData.getSRTAG());
            if (modified) {
                this.iSRID -= 2;
                if (this.iSRID < 0) {
                    this.iSRID = CFG.serviceRibbonMgr.getSRSize() - 1;
                }
            }
            for (int i = 0; i < tempSR.sr_GameData.getColors().size(); ++i) {
                this.lColors.add(new Color(tempSR.sr_GameData.getColor(i).getR(), tempSR.sr_GameData.getColor(i).getG(), tempSR.sr_GameData.getColor(i).getB(), 1.0f));
            }
            if (modified && this.lColors.size() < CFG.serviceRibbonMgr.getSR(this.iSRID).getSize()) {
                int iLeft = CFG.serviceRibbonMgr.getSR(this.iSRID).getSize() - this.lColors.size();
                this.lColors.add(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                int n = --iLeft;
                --iLeft;
                if (n > 0) {
                    this.lColors.add(new Color(0.3137255f, 0.3137255f, 0.3137255f, 1.0f));
                }
                if (iLeft-- > 0) {
                    this.lColors.add(new Color(0.2509804f, 0.32941177f, 0.5882353f, 1.0f));
                }
                if (iLeft-- > 0) {
                    this.lColors.add(new Color(0.88235295f, 0.8156863f, 0.27058825f, 1.0f));
                }
                while (iLeft-- > 0) {
                    this.lColors.add(CFG.getRandomColor());
                }
            }
        }
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.55f));
        IMGManager.getIMG(Images.patternReversed).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.patternReversed).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.175f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
        oSB.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.625f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.CIV_FLAG_WIDTH + CFG.PADD * 4 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.275f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.475f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, 1, true, false);
        oSB.setColor(Color.WHITE);
        CFG.serviceRibbonMgr.drawSRLevel(oSB, this.getPosXE() + this.getWidthE() - CFG.SERVICE_RIBBON_WIDTH - CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.SERVICE_RIBBON_HEIGHT / 2 + iTranslateY, 5, 0, 0, this.iSRID, this.lColors);
        if (!this.gameWon) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.425f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.SERVICE_RIBBON_WIDTH - CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.SERVICE_RIBBON_HEIGHT / 2 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, CFG.SERVICE_RIBBON_WIDTH, CFG.SERVICE_RIBBON_HEIGHT);
            oSB.setColor(Color.WHITE);
        }
        this.civFlag.drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - this.civFlag.getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD * 2 + CFG.CIV_FLAG_WIDTH + CFG.PADD * 4 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColor(isActive));
    }

    public final void loadFlag(String nTag) {
        block13: {
            this.disposeFlag();
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
                            catch (Exception ez) {
                                this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + nTag + ".png")), Texture.TextureFilter.Nearest);
                            }
                        }
                        catch (Exception exrz) {
                            this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(nTag) + ".png")), Texture.TextureFilter.Nearest);
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

    private final void disposeFlag() {
        if (this.civFlag != null) {
            this.civFlag.getTexture().dispose();
            this.civFlag = null;
        }
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_HOVERED : Color.WHITE) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
    }

    @Override
    public void buildElemHover() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Image(Images.wikipedia));
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.getWikiInforLinkClear(this.sTag), CFG.COLOR_HOVER_TITLE));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }

    @Override
    public void actionElem(int iID) {
        CFG.EDITOR_ACTIVE_GAMEDATA_TAG = this.sTag;
        CFG.setDialogType(DialogType.GO_TO_WIKI);
    }
}

