
package age.of.civilizations2.jakowski.lukasz.Menus.Continents;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Continent_GameData;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu_Continents_AddNewContinentToPackage
extends Menu {
    private List<String> lTags = new ArrayList<String>();
    private List<Color> lColors = new ArrayList<Color>();

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    public Menu_Continents_AddNewContinentToPackage() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        try {
            FileHandle tempFileT = FileManager.loadFile("map/data/continents/packges_data/Age_of_Civilizations");
            String tempT = tempFileT.readString();
            String[] tagsSPLITED = tempT.split(";");
            int tempAdded = 0;
            for (int i = 0; i < tagsSPLITED.length; ++i) {
                if (this.getIsInPackage(tagsSPLITED[i])) continue;
                menuElements.add(new Button_Classic(CFG.getContinentDataName(tagsSPLITED[i]), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (tempAdded + 1) + CFG.PADD * (tempAdded + 2), CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
                menuElements.add(new Button_Classic_ReflectedBG(CFG.lang.get("Edit"), -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * (tempAdded + 1) + CFG.PADD * (tempAdded + 2), CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
                this.lTags.add(tagsSPLITED[i]);
                ++tempAdded;
                this.lColors.add(CFG.getContinentDataColor(tagsSPLITED[i]));
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
        this.getMenuElem(1).setTextE(CFG.lang.get("CreateNewContinent"));
        this.getTitleM().setText(CFG.lang.get("AddNewContinent"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = "" + System.currentTimeMillis() + CFG.extraRandomTag();
                CFG.editor_Continent_GameData = new Continent_GameData();
                Color tempColor = CFG.getRandomColor();
                CFG.editor_Continent_GameData.setR(tempColor.r);
                CFG.editor_Continent_GameData.setG(tempColor.g);
                CFG.editor_Continent_GameData.setB(tempColor.b);
                this.setView_MAP_EDITOR_CREATE_NEW_CONTINENT();
                break;
            }
            default: {
                if (iID % 2 == 0) {
                    CFG.editor_Package_ContinentsData.addContinentTag(this.lTags.get((iID - 2) / 2));
                    this.onBackPressed();
                    break;
                }
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = this.lTags.get((iID - 2) / 2);
                try {
                    FileHandle file = FileManager.loadFile("map/data/continents/packges_data/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
                    CFG.editor_Continent_GameData = (Continent_GameData)CFG.deserialize(file.readBytes());
                }
                catch (ClassNotFoundException classNotFoundException) {
                }
                catch (IOException iOException) {
                    
                }
                this.setView_MAP_EDITOR_CREATE_NEW_CONTINENT();
            }
        }
    }

    private final void setView_MAP_EDITOR_CREATE_NEW_CONTINENT() {
        CFG.backToMenu = View.eMAP_EDITOR_CONTINENTS_ADDNEWCONTINENT_TOPACKAGE;
        CFG.menus.setMenuID(View.eMAP_EDITOR_CREATE_NEW_CONTINENT);
        RenderProvince.updateDrawProvinces();
        CFG.menus.getColorPicker().setPosX(CFG.PADD * 3);
        CFG.menus.getColorPicker().setPosY(CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD + CFG.menus.getColorPicker().getPosX());
        CFG.menus.getColorPicker().setActiveRGBColor(CFG.editor_Continent_GameData.getR(), CFG.editor_Continent_GameData.getG(), CFG.editor_Continent_GameData.getB());
        CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.MAP_EDITOR_CONTINENT_COLOR);
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_CREATE_CONTINENTS_PACKAGE);
        CFG.menus.setBackAnimation(true);
    }

    private final boolean getIsInPackage(String nTag) {
        for (int i = 0; i < CFG.editor_Package_ContinentsData.getContinentsTagsSize(); ++i) {
            if (!nTag.equals(CFG.editor_Package_ContinentsData.getContinentTag(i))) continue;
            return true;
        }
        return false;
    }
}

