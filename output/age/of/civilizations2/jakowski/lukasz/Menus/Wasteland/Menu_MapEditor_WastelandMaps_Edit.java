
package age.of.civilizations2.jakowski.lukasz.Menus.Wasteland;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.WastelandMap_GameData;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class Menu_MapEditor_WastelandMaps_Edit
extends Menu {
    private String sName;
    private int iNameWidth;

    public Menu_MapEditor_WastelandMaps_Edit() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Classic("", -1, CFG.BUTTON_W + CFG.PADD * 2, 0, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.PADD * 2) * 2, CFG.BUTTON_H + CFG.PADD * 2, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive || this.getIsHovered() ? new Color(0.82f, 0.82f, 0.82f, 1.0f) : (this.getIsClickable() ? new Color(1.0f, 1.0f, 1.0f, 1.0f) : new Color(0.84f, 0.84f, 0.84f, 0.7f));
            }

            @Override
            public String getTextToDrawElem() {
                return Menu_MapEditor_WastelandMaps_Edit.this.sName + ": " + super.getTextE();
            }

            @Override
            public int getTextWidthU() {
                return super.getTextWidthU() + Menu_MapEditor_WastelandMaps_Edit.this.iNameWidth;
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD, CFG.PADD * 3 + CFG.BUTTON_H, CFG.BUTTON_W * 2, true, CFG.bSetWasteland_AvailableProvinces));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD * 2 + CFG.BUTTON_W * 2, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W * 2, true, CFG.brushMode));
        menuElements.add(new Button_Game(null, -1, CFG.PADD * 3 + CFG.BUTTON_W * 4, CFG.BUTTON_H + CFG.PADD * 3, false));
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true));
        menuElements.add(new Button_Game(CFG.lang.get("Min") + " X", -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H + CFG.PADD) * 2, true));
        menuElements.add(new Button_Game(CFG.lang.get("Max") + " X", -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H + CFG.PADD) * 3, true));
        menuElements.add(new Button_Game(CFG.lang.get("Min") + " Y", -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H + CFG.PADD) * 4, true));
        menuElements.add(new Button_Game(CFG.lang.get("Max") + " Y", -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H + CFG.PADD) * 5, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sName = CFG.lang.get("Name");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sName + ": ");
        this.iNameWidth = (int)CFG.glyphLay.width;
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.CREATE_SCENARIO_NAME);
        this.getMenuElem(2).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Wasteland"));
        this.getMenuElem(4).setTextE(CFG.lang.get("Brush"));
        this.getMenuElem(5).setTextE(CFG.lang.get("Undo"));
        this.getMenuElem(6).setTextE(CFG.lang.get("World"));
        this.updateButtonWidth(6, 0, CFG.BUTTON_W);
        this.getMenuElem(6).setPosX(CFG.GAMEWIDTH - this.getMenuElem(6).getWidthE() - CFG.PADD);
        int tempX = CFG.GAMEWIDTH - this.getMenuElem(3).getWidthE() - CFG.PADD;
        this.getMenuElem(3).setPosX(tempX);
        tempX = tempX - this.getMenuElem(4).getWidthE() - CFG.PADD;
        this.getMenuElem(4).setPosX(tempX);
        tempX = tempX - this.getMenuElem(5).getWidthE() - CFG.PADD;
        this.getMenuElem(5).setPosX(tempX);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_Edge_R_Reflected(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Top_Edge_R_Reflected(oSB, this.getMenuElem(5).getPosXE() - CFG.PADD + iTranslateX, CFG.BUTTON_H + CFG.PADD * 2 + this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH - (this.getMenuElem(5).getPosXE() - CFG.PADD), CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Bot_Edge_R_Reflected(oSB, this.getMenuElem(6).getPosXE() - CFG.PADD + iTranslateX, this.getMenuElem(10).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(6).getWidthE() + CFG.PADD * 2, CFG.GAMEHEIGHT - this.getMenuElem(10).getPosY() + CFG.PADD);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.showKeyboard();
                return;
            }
            case 2: {
                this.saveData();
                CFG.toastM.addM(CFG.lang.get("Saved"));
                this.onBackPressed();
                return;
            }
            case 3: {
                CFG.bSetWasteland_AvailableProvinces = !CFG.bSetWasteland_AvailableProvinces;
                this.getMenuElem(iID).setCheckboxSt(CFG.bSetWasteland_AvailableProvinces);
                return;
            }
            case 4: {
                CFG.brushMode = !CFG.brushMode;
                this.getMenuElem(iID).setCheckboxSt(CFG.brushMode);
                return;
            }
            case 5: {
                if (CFG.lCreateScenario_UndoWastelandProvinces.size() > 0) {
                    CFG.core.getProv(CFG.lCreateScenario_UndoWastelandProvinces.get(CFG.lCreateScenario_UndoWastelandProvinces.size() - 1)).setWastelandLvl(CFG.core.getProv(CFG.lCreateScenario_UndoWastelandProvinces.get(CFG.lCreateScenario_UndoWastelandProvinces.size() - 1)).getWastelandLvl() >= 0 ? -1 : 0);
                    CFG.core.setActiveProvID(CFG.lCreateScenario_UndoWastelandProvinces.get(CFG.lCreateScenario_UndoWastelandProvinces.size() - 1));
                    if (!CFG.core.getProv(CFG.core.getActiveProvID()).getDrawProv()) {
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                    }
                    CFG.removeUndoWastelandProvince();
                    CFG.updateNumOfAvailableProvinces();
                }
                return;
            }
            case 6: {
                CFG.setDialogType(DialogType.MAP_EDITOR_WASTELAND_MAPS_WORLD_FILL);
                return;
            }
            case 7: {
                int tMinX = CFG.map.getMpB().getWidthM();
                int nProvinceID = 0;
                int tMaxX = -CFG.map.getMpB().getWidthM();
                int tMinY = CFG.map.getMpB().getHeightM();
                boolean tMaxY = false;
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.core.getProv(i).getMiX2() >= tMinX) continue;
                    tMinX = CFG.core.getProv(i).getMiX2();
                    nProvinceID = i;
                }
                CFG.map.getMpC().centerToProvID(nProvinceID);
                CFG.core.setActiveProvID(nProvinceID);
                return;
            }
            case 8: {
                int tMinX = CFG.map.getMpB().getWidthM();
                int nProvinceID = 0;
                int tMaxX = -CFG.map.getMpB().getWidthM();
                int tMinY = CFG.map.getMpB().getHeightM();
                boolean tMaxY = false;
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.core.getProv(i).getMaX7() <= tMaxX) continue;
                    tMaxX = CFG.core.getProv(i).getMaX7();
                    nProvinceID = i;
                }
                CFG.map.getMpC().centerToProvID(nProvinceID);
                CFG.core.setActiveProvID(nProvinceID);
                return;
            }
            case 9: {
                int tMinX = CFG.map.getMpB().getWidthM();
                int nProvinceID = 0;
                int tMaxX = -CFG.map.getMpB().getWidthM();
                int tMinY = CFG.map.getMpB().getHeightM();
                boolean tMaxY = false;
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.core.getProv(i).getMiY4() >= tMinY) continue;
                    tMinY = CFG.core.getProv(i).getMiY4();
                    nProvinceID = i;
                }
                CFG.map.getMpC().centerToProvID(nProvinceID);
                CFG.core.setActiveProvID(nProvinceID);
                return;
            }
            case 10: {
                int tMinX = CFG.map.getMpB().getWidthM();
                int nProvinceID = 0;
                int tMaxX = -CFG.map.getMpB().getWidthM();
                int tMinY = CFG.map.getMpB().getHeightM();
                int tMaxY = 0;
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.core.getProv(i).getMaY6() <= tMaxY) continue;
                    tMaxY = CFG.core.getProv(i).getMaY6();
                    nProvinceID = i;
                }
                CFG.map.getMpC().centerToProvID(nProvinceID);
                CFG.core.setActiveProvID(nProvinceID);
                return;
            }
        }
    }

    
    public final void saveData() {
        WastelandMap_GameData wastelandMap_GameData = new WastelandMap_GameData();
        wastelandMap_GameData.setName(this.getMenuElem(1).getTextE().length() == 0 ? "NO NAME" : this.getMenuElem(1).getTextE());
        wastelandMap_GameData.generateData();
        if (wastelandMap_GameData.getWastelandProvincesSize() > 0) {
            OutputStream os = null;
            try {
                FileHandle fileData = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
                fileData.writeBytes(CFG.serialize(wastelandMap_GameData), false);
            }
            catch (IOException fileData) {
            }
            finally {
                if (os != null) {
                    try {
                        os.close();
                        CFG.toastM.addM(CFG.lang.get("Saved"));
                    }
                    catch (Exception fileData) {}
                }
            }
        }
        try {
            FileHandle file = CFG.readLocalFiles() ? Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + "Age_of_Civilizations") : FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + "Age_of_Civilizations");
            String tempTags = file.readString();
            if (tempTags.indexOf(CFG.EDITOR_ACTIVE_GAMEDATA_TAG) < 0) {
                FileHandle fileSave = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + "Age_of_Civilizations");
                fileSave.writeString(tempTags + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + ";", false);
            }
        }
        catch (GdxRuntimeException ex) {
            FileHandle fileSave = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "data/" + "wasteland_maps/" + "Age_of_Civilizations");
            fileSave.writeString(CFG.EDITOR_ACTIVE_GAMEDATA_TAG + ";", false);
        }
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void onBackPressed() {
        CFG.brushMode = false;
        CFG.core.setActiveProvID(-1);
        CFG.menus.setMenuID(View.eMAP_EDITOR_WASTELAND_MAPS);
        CFG.menus.setBackAnimation(true);
    }
}

