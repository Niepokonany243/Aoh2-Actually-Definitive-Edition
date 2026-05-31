
package age.of.civilizations2.jakowski.lukasz.Menus.Packages;

import age.of.civilizations2.jakowski.lukasz.Alliances_Names_GameData;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu_Packages_RandomAllianceNames
extends Menu {
    private List<String> lTags = new ArrayList<String>();
    private List<Boolean> lEnabled = new ArrayList<Boolean>();

    public Menu_Packages_RandomAllianceNames() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        try {
            FileHandle file = FileManager.loadFile("game/alliance_names/Age_of_Civilizations.json");
            String fileContent = file.readString();
            Json json = new Json();
            json.setElementType(CFG.ConfigAlliancesData.class, "Data_Random_Alliance_Names", CFG.Data_Random_Alliance_Names.class);
            CFG.ConfigAlliancesData data = new CFG.ConfigAlliancesData();
            data = json.fromJson(CFG.ConfigAlliancesData.class, fileContent);
            int tempI = 0;
            for (Object e : data.Data_Random_Alliance_Names) {
                CFG.Data_Random_Alliance_Names tempData = (CFG.Data_Random_Alliance_Names)e;
                menuElements.add(new Button_Classic(this.getPackageName(tempData.Tag), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (tempI + 1) + CFG.PADD * (tempI + 2), CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_ReflectedBG(this.getPackageName(tempData.Tag), -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * (tempI + 1) + CFG.PADD * (tempI + 2), CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

                    @Override
                    public final Color getColorE(boolean isActive) {
                        return isActive ? new Color(0.941f, 1.0f, 0.0f, 1.0f) : (this.getIsClickable() ? (this.getCheckboxSt() ? new Color(0.396f, 0.576f, 0.012f, 1.0f) : new Color(0.643f, 0.113f, 0.008f, 1.0f)) : new Color(0.674f, 0.09f, 0.066f, 0.5f));
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCheckboxSt(tempData.Enabled);
                this.lTags.add(tempData.Tag);
                this.lEnabled.add(tempData.Enabled);
                ++tempI;
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("CreateNewPackage"));
        for (int i = 3; i < this.getMenuElemsSize(); i += 2) {
            this.getMenuElem(i).setTextE(this.lEnabled.get((i - 2) / 2) != false ? CFG.lang.get("Disable") : CFG.lang.get("Enable"));
        }
        this.getTitleM().setText(CFG.lang.get("RandomAlliancesNamesPackages"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.editorAlliancesNames_GameData = new Alliances_Names_GameData();
                CFG.CREATE_PACKAGE_ALLIANCE_NAMES_GAME_DATA_TAG = "" + System.currentTimeMillis() + CFG.extraRandomTag();
                CFG.menus.setMenuID(View.eGAME_EDITOR_ALLIANCE_NAMES_PACKAGE_CREATE);
                break;
            }
            default: {
                if (iID % 2 == 0) {
                    try {
                        CFG.CREATE_PACKAGE_ALLIANCE_NAMES_GAME_DATA_TAG = this.lTags.get((iID - 2) / 2);
                        FileHandle file = FileManager.loadFile("game/alliance_names/" + CFG.CREATE_PACKAGE_ALLIANCE_NAMES_GAME_DATA_TAG);
                        CFG.editorAlliancesNames_GameData = (Alliances_Names_GameData)CFG.deserialize(file.readBytes());
                        CFG.menus.setMenuID(View.eGAME_EDITOR_ALLIANCE_NAMES_PACKAGE_CREATE);
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                    }
                    catch (IOException iOException) {}
                    break;
                }
                this.lEnabled.set((iID - 2) / 2, this.lEnabled.get((iID - 2) / 2) == false);
                this.getMenuElem(iID).setTextE(this.lEnabled.get((iID - 2) / 2) != false ? CFG.lang.get("Disable") : CFG.lang.get("Enable"));
                this.getMenuElem(iID).setCheckboxSt(this.lEnabled.get((iID - 2) / 2));
                CFG.toastM.addM(this.lEnabled.get((iID - 2) / 2) != false ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled"));
                this.updateEnabled((iID - 2) / 2, this.lEnabled.get((iID - 2) / 2));
            }
        }
    }

    private final void updateEnabled(int i, boolean nValue) {
        FileHandle file = FileManager.loadFile("game/alliance_names/Age_of_Civilizations.json");
        String fileContent = file.readString();
        Json json = new Json();
        json.setElementType(CFG.ConfigAlliancesData.class, "Data_Random_Alliance_Names", CFG.Data_Random_Alliance_Names.class);
        CFG.ConfigAlliancesData data = new CFG.ConfigAlliancesData();
        data = json.fromJson(CFG.ConfigAlliancesData.class, fileContent);
        CFG.ConfigAlliancesData configData = new CFG.ConfigAlliancesData();
        configData.Age_of_Civilizations = "Data";
        ArrayList dataList = new ArrayList();
        CFG.Data_Random_Alliance_Names tempUpdated = (CFG.Data_Random_Alliance_Names)data.Data_Random_Alliance_Names.get(i);
        tempUpdated.Enabled = nValue;
        data.Data_Random_Alliance_Names.set(i, tempUpdated);
        configData.Data_Random_Alliance_Names = dataList = data.Data_Random_Alliance_Names;
        Json jsonSave = new Json();
        jsonSave.setOutputType(JsonWriter.OutputType.json);
        jsonSave.setElementType(CFG.ConfigAlliancesData.class, "Data_Random_Alliance_Names", CFG.Data_Random_Alliance_Names.class);
        FileHandle fileSave = FileManager.getSaveType("game/alliance_names/Age_of_Civilizations.json");
        fileSave.writeString(jsonSave.prettyPrint(configData), false);
    }

    private final String getPackageName(String nTag) {
        try {
            FileHandle file = FileManager.loadFile("game/alliance_names/" + nTag);
            Alliances_Names_GameData tempAllianceNamesData = (Alliances_Names_GameData)CFG.deserialize(file.readBytes());
            return tempAllianceNamesData.getPackageName();
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (IOException iOException) {
            
        }
        return nTag;
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eGAME_EDITOR);
        CFG.menus.setBackAnimation(true);
        CFG.loadRandomAlliancesNames();
    }
}

