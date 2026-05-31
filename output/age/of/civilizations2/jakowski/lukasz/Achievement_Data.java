/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization_GameData3;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Achievement_Data {
    private String sText;
    private int iTextWidth;
    private String sTextNum;
    private int iTextNumWidth;
    private int iCivID;
    private int iSROverID;
    private long lTime;
    private int TIME_IN_VIEW;
    private int TIME_IN_VIEW_HIDE_ANIMATION;
    private int iSRID;
    private int iLevelID;
    private List<Color> lColors;

    public Achievement_Data(int nCivID, String nTagID, String nText, String nTextNum, int nLevelID) {
        Civilization_GameData3 tempSR;
        block15: {
            this.iTextWidth = -1;
            this.iTextNumWidth = -1;
            this.iSROverID = 0;
            this.TIME_IN_VIEW = 4500;
            this.TIME_IN_VIEW_HIDE_ANIMATION = 500;
            this.iSRID = 0;
            this.iLevelID = 0;
            this.iCivID = nCivID;
            this.sText = nText;
            this.sTextNum = nTextNum;
            this.iLevelID = nLevelID;
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sText);
            this.iTextWidth = (int)CFG.glyphLay.width;
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sTextNum);
            this.iTextNumWidth = (int)CFG.glyphLay.width;
            this.lColors = new ArrayList<Color>();
            tempSR = null;
            String tempTag = nTagID;
            this.iSROverID = nTagID.charAt(0) % CFG.serviceRibbonMgr.getSROverlayImagesSize();
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
                if (!CFG.LOGs) break block15;
                CFG.exceptionStack(e);
            }
        }
        if (tempSR.sr_GameData != null) {
            this.iSRID = CFG.serviceRibbonMgr.getSRID(tempSR.sr_GameData.getSRTAG());
            for (int i = 0; i < tempSR.sr_GameData.getColors().size(); ++i) {
                this.lColors.add(new Color(tempSR.sr_GameData.getColor(i).getR(), tempSR.sr_GameData.getColor(i).getG(), tempSR.sr_GameData.getColor(i).getB(), 1.0f));
            }
            this.lTime = System.currentTimeMillis();
        }
    }

    private final int getPosX() {
        return CFG.GAMEWIDTH / 2 - this.getWidth() / 2;
    }

    private final int getPosY() {
        return CFG.BUTTON_H * 3 / 4;
    }

    private final int getWidth() {
        return Math.max(this.iTextWidth + this.iTextNumWidth + CFG.PADD * 10, CFG.SERVICE_RIBBON_WIDTH * (this.iLevelID + 1) + CFG.PADD * this.iLevelID + CFG.PADD * 10);
    }

    private final int getHeight() {
        return CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + CFG.SERVICE_RIBBON_HEIGHT + CFG.PADD * 2 + CFG.PADD * 2;
    }

    public final void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY) {
        float tAlpha = this.getAlpha();
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, CFG.COLOR_GRADIENT_DARK_BLUE.a * tAlpha));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth(), this.getHeight());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 1.0f * tAlpha));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - 2 + this.getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f * tAlpha));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - 1 + this.getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f * tAlpha));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + CFG.PADD * 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth(), CFG.SERVICE_RIBBON_HEIGHT);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f * tAlpha));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - 1 + CFG.PADD * 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + CFG.SERVICE_RIBBON_HEIGHT + CFG.PADD * 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidth(), 1);
        oSB.setColor(Color.WHITE);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sText, this.getPosX() + this.getWidth() / 2 - (this.iTextWidth + this.iTextNumWidth) / 2 + iTranslateX, this.getPosY() + CFG.SERVICE_RIBBON_HEIGHT + CFG.PADD * 4 + iTranslateY, new Color(CFG.COLOR_NEUTRAL.r, CFG.COLOR_NEUTRAL.g, CFG.COLOR_NEUTRAL.b, CFG.COLOR_NEUTRAL.a * tAlpha));
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sTextNum, this.getPosX() + this.getWidth() / 2 - (this.iTextWidth + this.iTextNumWidth) / 2 + this.iTextWidth + iTranslateX, this.getPosY() + CFG.SERVICE_RIBBON_HEIGHT + CFG.PADD * 4 + iTranslateY, new Color(CFG.COLOR_TEXT_NUM_OF_PROVINCES.r, CFG.COLOR_TEXT_NUM_OF_PROVINCES.g, CFG.COLOR_TEXT_NUM_OF_PROVINCES.b, CFG.COLOR_TEXT_NUM_OF_PROVINCES.a * tAlpha));
        for (int i = 0; i < this.iLevelID + 1; ++i) {
            CFG.serviceRibbonMgr.drawSRLevel(oSB, this.getPosX() + this.getWidth() / 2 - (CFG.SERVICE_RIBBON_WIDTH * (this.iLevelID + 1) + CFG.PADD * this.iLevelID) / 2 + CFG.SERVICE_RIBBON_WIDTH * i + CFG.PADD * i + iTranslateX, this.getPosY() + CFG.PADD * 2 + iTranslateY, i, 0, this.iSROverID, this.iSRID, this.lColors);
        }
    }

    private final float getAlpha() {
        if (System.currentTimeMillis() > this.lTime + (long)this.TIME_IN_VIEW - (long)this.TIME_IN_VIEW_HIDE_ANIMATION) {
            return Math.max(0.0f, 1.0f - (float)(System.currentTimeMillis() - (this.lTime + (long)this.TIME_IN_VIEW - (long)this.TIME_IN_VIEW_HIDE_ANIMATION)) / (float)this.TIME_IN_VIEW_HIDE_ANIMATION);
        }
        return 1.0f;
    }

    public final boolean canBeDisposed() {
        return System.currentTimeMillis() > this.lTime + (long)this.TIME_IN_VIEW;
    }
}

