/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Wasteland;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.WastelandMap_GameData;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu_MapEditor_WastelandMaps
extends Menu {
    public Menu_MapEditor_WastelandMaps() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        try {
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
            for (int i = 0; i < tagsSPLITED.length; ++i) {
                FileHandle fileData = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + tagsSPLITED[i]);
                try {
                    WastelandMap_GameData tempGameData = (WastelandMap_GameData)CFG.deserialize(fileData.readBytes());
                    menuElements.add(new Button_Classic(tempGameData.getName() + ": " + tempGameData.getWastelandProvincesSize() + " " + CFG.lang.get("Provinces"), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.GAMEWIDTH, CFG.BUTTON_H, true){

                        @Override
                        public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                            CFG.map.getIcon(CFG.map.getActiveMapIDN()).drawO(oSB, this.getPosXE() + this.getTextPosElem() / 2 - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getHeight() / 2 + iTranslateY);
                            super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                        }
                    });
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
        catch (GdxRuntimeException gdxRuntimeException) {
            // empty catch block
        }
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("AddNewWastelandMap"));
        this.getTitleM().setText(CFG.lang.get("WastelandMapsEditor"));
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public final void actionEL(int iID) {
        CFG.lCreateScenario_UndoWastelandProvinces = new ArrayList<Integer>();
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.RELOAD_SCENARIO = true;
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    if (CFG.core.getProv(i).getSeaProv()) continue;
                    CFG.core.getProv(i).setWastelandLvl(-1);
                }
                CFG.brushMode = false;
                CFG.bSetWasteland_AvailableProvinces = true;
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = System.currentTimeMillis() + CFG.extraRandomTag();
                CFG.CREATE_SCENARIO_NAME = "";
                CFG.menus.setMenuID(View.eMAP_EDITOR_WASTELAND_MAPS_EDIT);
                return;
            }
        }
        CFG.RELOAD_SCENARIO = true;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv()) continue;
            CFG.core.getProv(i).setWastelandLvl(-1);
        }
        CFG.brushMode = false;
        CFG.bSetWasteland_AvailableProvinces = true;
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
        CFG.EDITOR_ACTIVE_GAMEDATA_TAG = tagsSPLITED[iID - 2];
        CFG.CREATE_SCENARIO_NAME = "";
        FileHandle fileData = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
        try {
            WastelandMap_GameData tempGameData = (WastelandMap_GameData)CFG.deserialize(fileData.readBytes());
            int iSize = tempGameData.getWastelandProvincesSize();
            for (int i = 0; i < iSize; ++i) {
                try {
                    if (CFG.core.getProv(tempGameData.getWastelandProvinceID(i)).getSeaProv()) continue;
                    CFG.core.getProv(tempGameData.getWastelandProvinceID(i)).setWastelandLvl(0);
                    continue;
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    // empty catch block
                }
            }
            CFG.CREATE_SCENARIO_NAME = tempGameData.getName();
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        CFG.core.buildWastelandLevels();
        CFG.menus.setMenuID(View.eMAP_EDITOR_WASTELAND_MAPS_EDIT);
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_EDIT);
        CFG.menus.setBackAnimation(true);
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv(i).setWastelandLvl(-1);
        }
        CFG.lCreateScenario_UndoWastelandProvinces = null;
    }
}

