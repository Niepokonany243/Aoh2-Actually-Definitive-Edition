/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization_GameData3;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextServiceRibbon
extends Text {
    private int iSRID;
    private int iLevelID;
    private List<Color> lColors;
    private String sLevel;
    private int iLevelWidth;
    private String sLevel2;
    private int iLevelWidth2;
    private String sNum;

    public TextServiceRibbon(String sText, int iPosX, int iPosY, int iWidth, String nTagID, int nLevelID, int nNum, int modified) {
        super(sText, 0, iPosX, iPosY, iWidth, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.SERVICE_RIBBON_HEIGHT + CFG.PADD * 4), CFG.FONT_BOLD_SMALL);
        Civilization_GameData3 tempSR = null;
        this.iSRID = 0;
        this.iLevelID = 0;
        this.iLevelID = nLevelID;
        this.lColors = new ArrayList<Color>();
        this.sNum = CFG.getNumberWthSpaces("" + nNum);
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
            if (modified != 0) {
                this.iSRID -= modified;
                if (this.iSRID >= CFG.serviceRibbonMgr.getSRSize()) {
                    this.iSRID = CFG.serviceRibbonMgr.getSRSize() - 1;
                }
                if (this.iSRID < 0) {
                    this.iSRID = CFG.serviceRibbonMgr.getSRSize() - Math.abs(modified);
                }
                if (this.iSRID < 0) {
                    this.iSRID = CFG.serviceRibbonMgr.getSRSize() - 1;
                }
            }
            for (int i = 0; i < tempSR.sr_GameData.getColors().size(); ++i) {
                this.lColors.add(new Color(tempSR.sr_GameData.getColor(i).getR(), tempSR.sr_GameData.getColor(i).getG(), tempSR.sr_GameData.getColor(i).getB(), 1.0f));
            }
            if (modified != 0 && this.lColors.size() < CFG.serviceRibbonMgr.getSR(this.iSRID).getSize()) {
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
        this.sLevel = CFG.lang.get("Level") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sLevel);
        this.iLevelWidth = (int)CFG.glyphLay.width;
        this.sLevel2 = "" + (this.iLevelID + 1);
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sLevel2);
        this.iLevelWidth2 = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.175f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE());
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.75f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + CFG.SERVICE_RIBBON_WIDTH + CFG.PADD * 4 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightE());
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, 1, true, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, 1, true, false);
        oSB.setColor(Color.WHITE);
        CFG.serviceRibbonMgr.drawSRLevel(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.SERVICE_RIBBON_HEIGHT / 2 + iTranslateY, this.iLevelID, 0, 0, this.iSRID, this.lColors);
        Renderer.drawText(oSB, this.fontID, this.sLevel, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iLevelWidth - this.iLevelWidth2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS_HOVER);
        Renderer.drawText(oSB, this.fontID, this.sLevel2, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.iLevelWidth2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_NEUTRAL);
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD * 6 + CFG.SERVICE_RIBBON_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColor(isActive));
        Renderer.drawText(oSB, this.fontID, this.sNum, this.getPosXE() + CFG.PADD * 6 + CFG.SERVICE_RIBBON_WIDTH + this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getIsHovered() ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_TEXT_NUM_OF_PROVINCES);
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_HOVERED : CFG.COLOR_NEUTRAL) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
    }
}

