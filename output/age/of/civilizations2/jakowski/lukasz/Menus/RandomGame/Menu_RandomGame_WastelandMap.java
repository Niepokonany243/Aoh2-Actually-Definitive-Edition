/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.RandomGame;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.CNG.Button_CNG_Options;
import age.of.civilizations2.jakowski.lukasz.Button.CNG.Button_CNG_Options_Text2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.WastelandMap_GameData;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu_RandomGame_WastelandMap
extends Menu {
    public static final int ANIMATION_TIME = 250;
    public static long lTime = 0L;

    public Menu_RandomGame_WastelandMap() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tempMaxH = CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4) - (CFG.BUTTON_H + CFG.PADD * 2) - CFG.PADD;
        int tempElemH = CFG.BUTTON_H * 3 / 4;
        int tY = 0;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_CNG_Options(null, -1, 0, tY, tempW, tempElemH, true));
        menuElements.add(new Button_CNG_Options_Text2(CFG.map.getMapName(CFG.map.getActiveMapIDN()), CFG.lang.get("Provinces") + ": " + CFG.core.countLandProvinces(), CFG.PADD * 2, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, tempElemH, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        for (int i = 1; i < CFG.map.getMapContinents().getContinentsSize(); ++i) {
            menuElements.add(new Button_CNG_Options_Text2(CFG.map.getMapContinents().getName(i), CFG.lang.get("Provinces") + ": " + CFG.core.countContinentProvinces(i), CFG.PADD * 2, 0, tY, tempW, tempElemH, true));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        try {
            int i;
            String[] tagsSPLITED = null;
            if (CFG.getIsDesktop() && !FileManager.IS_MAC) {
                int i2;
                List<String> tempFiles = CFG.getFileNames_O("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/");
                int iSize = tempFiles.size();
                for (i2 = 0; i2 < iSize; ++i2) {
                    if (!tempFiles.get(i2).equals("Age_of_Civilizations")) continue;
                    tempFiles.remove(i2);
                    break;
                }
                tagsSPLITED = new String[tempFiles.size()];
                iSize = tempFiles.size();
                for (i2 = 0; i2 < iSize; ++i2) {
                    tagsSPLITED[i2] = tempFiles.get(i2);
                }
            } else {
                FileHandle tempFileT = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + "Age_of_Civilizations");
                String tempT = tempFileT.readString();
                tagsSPLITED = tempT.split(";");
            }
            int tempLandProvinces = 0;
            for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getSeaProv()) continue;
                ++tempLandProvinces;
            }
            for (i = 0; i < tagsSPLITED.length; ++i) {
                FileHandle fileData = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + tagsSPLITED[i]);
                try {
                    WastelandMap_GameData tempGameData = (WastelandMap_GameData)CFG.deserialize(fileData.readBytes());
                    menuElements.add(new Button_CNG_Options_Text2(CFG.lang.get(tempGameData.getName()), CFG.lang.get("Provinces") + ": " + (tempLandProvinces - tempGameData.getWastelandProvincesSize()), CFG.PADD * 2, 0, tY, tempW, tempElemH, true));
                    tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                    continue;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    continue;
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
        }
        catch (GdxRuntimeException tagsSPLITED) {
            // empty catch block
        }
        menuElements.add(new Button_CNG_Options(null, -1, 0, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, tempElemH, true));
        for (int i = 1; i < menuElements.size() - 1; ++i) {
            ((MenuElemUI)menuElements.get(i)).setCurr(i);
        }
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_RandomGame_WastelandMap.this.getPosX() + iTranslateX, Menu_RandomGame_WastelandMap.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_RandomGame_WastelandMap.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.011f, 0.014f, 0.019f, 0.25f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_RandomGame_WastelandMap.this.getPosX() + iTranslateX, Menu_RandomGame_WastelandMap.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightT() * 3 / 4, Menu_RandomGame_WastelandMap.this.getWidthM(), this.getHeightT() * 3 / 4, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_RandomGame_WastelandMap.this.getPosX() + iTranslateX, Menu_RandomGame_WastelandMap.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_RandomGame_WastelandMap.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_RandomGame_WastelandMap.this.getPosX() + iTranslateX, Menu_RandomGame_WastelandMap.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_RandomGame_WastelandMap.this.getWidthM(), 1);
                if (AoCGame.LEFT != 0) {
                    oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
                    IMGManager.getIMG(Images.pix255).draw2O(oSB, Menu_RandomGame_WastelandMap.this.getPosX() + iTranslateX, Menu_RandomGame_WastelandMap.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - this.getHeightT(), 1, this.getHeightT(), true, false);
                    oSB.setColor(Color.WHITE);
                }
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.8f / 2.0f) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - (int)((float)this.getTextHeight() * 0.8f / 2.0f), CFG.COLOR_TEXT_GRAY_LEFT_NS);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, 0 + AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempW, tempMaxH < ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() ? tempMaxH : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), menuElements);
        this.setVisibleM(false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("CustomizeWasteland"));
        this.getMenuElem(this.getMenuElemsSize() - 1).setTextE(CFG.lang.get("Back"));
        this.getTitleM().setText(CFG.lang.get("Maps"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + 250L >= System.currentTimeMillis()) {
            iTranslateX += -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / 250.0f));
            CFG.setRenderO(true);
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2 + Core.PADDING, this.getHeightM(), true, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM(), this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM(), this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM(), this.getWidthM() + 2);
        if (AoCGame.LEFT != 0) {
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM(), true, true);
            oSB.setColor(Color.WHITE);
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if ((sliderMenuIsActive || this.getScrollModeY()) && !CFG.menus.getSliderMode()) {
            super.drawScrollPos(oSB, iTranslateX - 2, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void actionEL(int iID) {
        if (iID == 0) {
            CFG.lCreateScenario_UndoWastelandProvinces = new ArrayList<Integer>();
            CFG.backToMenu = View.eCREATE_RANDOM_GAME;
            CFG.goToMenu = View.eCREATE_RANDOM_GAME;
            CFG.menus.setMenuID(View.eCREATE_SCENARIO_AVAILABLE_PROVINCES);
            CFG.map.getMpC().centerToRandomMapPos();
        } else if (iID == 1) {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getSeaProv()) continue;
                CFG.core.getProv(i).setWastelandLvl(-1);
            }
            ArrayList<String> tMess = new ArrayList<String>();
            ArrayList<Color> tColor = new ArrayList<Color>();
            tMess.add(this.getMenuElem(iID).getTextE());
            tColor.add(Color.WHITE);
            tMess.add(CFG.lang.get("Provinces") + ": " + CFG.core.countLandProvinces());
            tColor.add(CFG.COLOR_HOVER_TITLE);
            CFG.toastM.addM(tMess, tColor);
        } else if (iID == this.getMenuElemsSize() - 1) {
            CFG.randomGameManager.checkCapitals();
            CFG.menus.setVisible_CreateRandomGame_Options(true);
            CFG.map.getMpC().centerToRandomMapPos();
        } else if (iID <= CFG.map.getMapContinents().getContinentsSize()) {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getSeaProv()) continue;
                if (CFG.core.getProv(i).getContinent() == iID - 1) {
                    CFG.core.getProv(i).setWastelandLvl(-1);
                    continue;
                }
                CFG.core.getProv(i).setWastelandLvl(0);
            }
            CFG.core.buildWastelandLevels();
            ArrayList<String> tMess = new ArrayList<String>();
            ArrayList<Color> tColor = new ArrayList<Color>();
            tMess.add(this.getMenuElem(iID).getTextE());
            tColor.add(Color.WHITE);
            tMess.add(CFG.lang.get("Provinces") + ": " + CFG.core.countContinentProvinces(iID - 1));
            tColor.add(CFG.COLOR_HOVER_TITLE);
            CFG.toastM.addM(tMess, tColor);
        } else {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getSeaProv()) continue;
                CFG.core.getProv(i).setWastelandLvl(-1);
            }
            String[] tagsSPLITED = null;
            if (CFG.getIsDesktop() && !FileManager.IS_MAC) {
                int i;
                List<String> tempFiles = CFG.getFileNames_O("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/");
                int iSize = tempFiles.size();
                for (i = 0; i < iSize; ++i) {
                    if (!tempFiles.get(i).equals("Age_of_Civilizations")) continue;
                    tempFiles.remove(i);
                    break;
                }
                tagsSPLITED = new String[tempFiles.size()];
                iSize = tempFiles.size();
                for (i = 0; i < iSize; ++i) {
                    tagsSPLITED[i] = tempFiles.get(i);
                }
            } else {
                FileHandle tempFileT = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + "Age_of_Civilizations");
                String tempT = tempFileT.readString();
                tagsSPLITED = tempT.split(";");
            }
            try {
                FileHandle fileData = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + tagsSPLITED[iID - 1 - CFG.map.getMapContinents().getContinentsSize()]);
                WastelandMap_GameData tempGameData = (WastelandMap_GameData)CFG.deserialize(fileData.readBytes());
                int iSize = tempGameData.getWastelandProvincesSize();
                for (int i = 0; i < iSize; ++i) {
                    CFG.core.getProv(tempGameData.getWastelandProvinceID(i)).setWastelandLvl(0);
                }
            }
            catch (ClassNotFoundException fileData) {
            }
            catch (IOException fileData) {
            }
            catch (IndexOutOfBoundsException fileData) {
                // empty catch block
            }
            CFG.core.buildWastelandLevels();
            ArrayList<String> tMess = new ArrayList<String>();
            ArrayList<Color> tColor = new ArrayList<Color>();
            tMess.add(this.getMenuElem(iID).getTextE());
            tColor.add(Color.WHITE);
            tMess.add(CFG.lang.get("Provinces") + ": " + CFG.core.countLandProvinces_NotWasteland());
            tColor.add(CFG.COLOR_HOVER_TITLE);
            CFG.toastM.addM(tMess, tColor);
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        lTime = System.currentTimeMillis();
    }
}

