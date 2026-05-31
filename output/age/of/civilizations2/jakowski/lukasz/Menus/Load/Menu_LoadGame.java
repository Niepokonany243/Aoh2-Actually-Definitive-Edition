
package age.of.civilizations2.jakowski.lukasz.Menus.Load;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Description;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Remove;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ScenarioLoad;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Load.Menu_LoadSave;
import age.of.civilizations2.jakowski.lukasz.Menus.Main.Menu_Main;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import java.util.ArrayList;

public class Menu_LoadGame
extends Menu {
    public Menu_LoadGame() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempMenuWidth = Menu_Main.getMenuWidth_Default();
        int tY = 0;
        menuElements.add(new Text(null, -1, 0, tY, tempMenuWidth, CFG.BUTTON_H * 3 / 4){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.drawRect_InfoBox_Right_Title(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
                CFG.drawTextDefaultWithShadow(oSB, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_CIV_INFO_TITLE);
            }
        });
        menuElements.add(new Button_Classic_Description(CFG.map.getMapAuthor(CFG.map.getActiveMapIDN()), CFG.lang.get("MapType") + ": " + CFG.map.getMapName(CFG.map.getActiveMapIDN()), (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempMenuWidth, CFG.BUTTON_H, true){

            @Override
            public void setButtonAlpha(SpriteBatch oSB, boolean isActive) {
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.55f);
                if (!this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.4f));
                } else if (!isActive && this.getIsHovered() && this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.485f));
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("LandProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countLandProvinces(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SeaProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countSeaProvinces(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        try {
            FileHandle file2 = CFG.readLocalFiles() ? Gdx.files.local("saves/games/" + CFG.map.getFileActiveMapPath() + "Age_of_Civilizations") : FileManager.loadFile("saves/games/" + CFG.map.getFileActiveMapPath() + "Age_of_Civilizations");
            String tempTags = file2.readString();
            String[] tSplted = tempTags.split(";");
            block6: for (int i = tSplted.length - 1; i >= 0; --i) {
                try {
                    FileHandle file = FileManager.loadFile("saves/games/" + CFG.map.getFileActiveMapPath() + tSplted[i] + "/" + tSplted[i] + ".json");
                    String fileContent = file.readString();
                    Json json = new Json();
                    json.setElementType(SaveGameManager.ConfigSaveInfo.class, "Data_Save_Info", SaveGameManager.Data_Save_Info.class);
                    SaveGameManager.ConfigSaveInfo data = json.fromJson(SaveGameManager.ConfigSaveInfo.class, fileContent);
                    for (Object e : data.Data_Save_Info) {
                        SaveGameManager.Data_Save_Info tempData = (SaveGameManager.Data_Save_Info)e;
                        try {
                            menuElements.add(new Button_Classic_ScenarioLoad(i, tempData.PLAYER_TAG, tempData.Civs, tempData.GameDate + " - " + CFG.lang.get("Turn") + ": " + tempData.Turn, 0, tY, tempMenuWidth - CFG.BUTTON_W, CFG.BUTTON_H, true));
                            menuElements.add(new Button_Classic_Remove(tempMenuWidth - CFG.BUTTON_W, tY, CFG.BUTTON_W, CFG.BUTTON_H, true){

                                @Override
                                public void buildElemHover() {
                                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Delete"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                    this.menuElemHover = new ME_Hover_v2(nElements);
                                }
                            });
                            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
                            continue block6;
                        }
                        catch (Exception exr) {
                            menuElements.add(new Button_Classic_ScenarioLoad(0, CFG.lang.get("Error"), 0, "---", 0, tY, tempMenuWidth - CFG.BUTTON_W, CFG.BUTTON_H, true){

                                @Override
                                public boolean getIsClickable() {
                                    return false;
                                }
                            });
                            menuElements.add(new Button_Classic_Remove(tempMenuWidth - CFG.BUTTON_W, tY, CFG.BUTTON_W, CFG.BUTTON_H, true){

                                @Override
                                public void buildElemHover() {
                                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Delete"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                    this.menuElemHover = new ME_Hover_v2(nElements);
                                }
                            });
                            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
                        }
                    }
                    continue;
                }
                catch (Exception ex) {
                    menuElements.add(new Button_Classic_ScenarioLoad(0, CFG.lang.get("Error"), 0, "---", 0, tY, tempMenuWidth - CFG.BUTTON_W, CFG.BUTTON_H, true){

                        @Override
                        public boolean getIsClickable() {
                            return false;
                        }
                    });
                    menuElements.add(new Button_Classic_Remove(tempMenuWidth - CFG.BUTTON_W, tY, CFG.BUTTON_W, CFG.BUTTON_H, true){

                        @Override
                        public void buildElemHover() {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Delete"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                    });
                    tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
                }
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        this.initMenu(null, Menu_Main.getMenuPosX_Default(), 0, tempMenuWidth, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(this.getLoadGame());
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.map.getIcon(CFG.map.getActiveMapIDN()).drawO(oSB, this.getPosX() + this.getMenuElem(1).getTextPosElem() / 2 - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getWidth() / 2 + iTranslateX, this.getMenuElem(1).getPosY() + this.getMenuElem(1).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + this.getMenuPosY() - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        if (iID == 0) {
            return;
        }
        if (iID == 1) {
            CFG.backToMenu = View.eLOADGAME;
            CFG.menus.setMenuID(View.eSELECT_MAP_TYPE);
            return;
        }
        if ((iID - 2) % 2 == 1) {
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = (this.getMenuElemsSize() - 2) / 2 - 1 - (iID - 2) / 2;
            CFG.setDialogType(DialogType.DELETE_SAVED_GAME);
        } else {
            Menu_LoadSave.loadStepID = 0;
            Menu_LoadSave.loadStepID_TEXT = 1;
            Menu_LoadSave.pause = false;
            Menu_LoadSave.tFileID = 0;
            Menu_LoadSave.tFileID2 = 0;
            CFG.gameNewGame.loadGame((this.getMenuElemsSize() - 2) / 2 - 1 - (iID - 2) / 2);
        }
    }

    public String getLoadGame() {
        return CFG.lang.get("LoadGame") + " - AoH2:DE";
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_LoadGame();
    }
}

