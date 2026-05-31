
package age.of.civilizations2.jakowski.lukasz.Menus.Packages;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic_ReflectedCheckbox;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import com.badlogic.gdx.files.FileHandle;
import java.util.ArrayList;
import java.util.List;

public class Menu_Packages_DiplomacyColors
extends Menu {
    private List<String> lTags = new ArrayList<String>();

    public Menu_Packages_DiplomacyColors() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        FileHandle tempFileT = FileManager.loadFile("game/diplomacy_colors/packages/Age_of_Civilizations");
        String tempT = tempFileT.readString();
        String[] tagsSPLITED = tempT.split(";");
        for (int i = 0; i < tagsSPLITED.length; ++i) {
            menuElements.add(new Button_Classic(CFG.getPackageDiplomacyColorsDataName(tagsSPLITED[i]), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
            menuElements.add(new Button_Classic_Classic_ReflectedCheckbox(tagsSPLITED[i].equals(CFG.sACTIVE_DIPLOMACY_COLORS_TAG) ? CFG.lang.get("Active") : CFG.lang.get("Enable"), (int)(50.0f * CFG.GUI_SCALE), CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.BUTTON_W * 2, CFG.BUTTON_H, true, tagsSPLITED[i].equals(CFG.sACTIVE_DIPLOMACY_COLORS_TAG)));
            this.lTags.add(tagsSPLITED[i]);
        }
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("CreateNewPackage"));
        this.getTitleM().setText(CFG.lang.get("DiplomacyColorsPackages"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.CREATE_PACKAGE_CONTINENT_GAME_DATA_TAG = "" + System.currentTimeMillis() + CFG.extraRandomTag();
                CFG.initEditdiplomacyColors_GameData();
                CFG.menus.setMenuID(View.eGAME_EDITOR_DIPLOMACY_COLORS_PACKAGES_CREATE);
                RenderProvince.updateDrawProvinces();
                CFG.menus.getColorPicker().setPosX(CFG.BUTTON_W * 2 + CFG.PADD * 5);
                CFG.menus.getColorPicker().setPosY(CFG.BUTTON_H * 2 + CFG.PADD * 7);
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB());
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.COLOR_DIPLOMACY_OWN_PROVINCES);
                break;
            }
            default: {
                if (iID % 2 == 0) {
                    CFG.CREATE_PACKAGE_CONTINENT_GAME_DATA_TAG = this.lTags.get((iID - 2) / 2);
                    CFG.loadDiplomacyColors_GameData(CFG.CREATE_PACKAGE_CONTINENT_GAME_DATA_TAG);
                    CFG.menus.setMenuID(View.eGAME_EDITOR_DIPLOMACY_COLORS_PACKAGES_CREATE);
                    RenderProvince.updateDrawProvinces();
                    CFG.menus.getColorPicker().setPosX(CFG.BUTTON_W * 2 + CFG.PADD * 5);
                    CFG.menus.getColorPicker().setPosY(CFG.BUTTON_H * 2 + CFG.PADD * 7);
                    CFG.menus.getColorPicker().setActiveRGBColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB());
                    CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.COLOR_DIPLOMACY_OWN_PROVINCES);
                    break;
                }
                if (CFG.sACTIVE_DIPLOMACY_COLORS_TAG.equals(this.lTags.get((iID - 2) / 2))) break;
                CFG.sACTIVE_DIPLOMACY_COLORS_TAG = this.lTags.get((iID - 2) / 2);
                FileHandle fileSave = FileManager.getSaveType("game/diplomacy_colors/Age_of_Civilizations_Active");
                fileSave.writeString(CFG.sACTIVE_DIPLOMACY_COLORS_TAG, false);
                CFG.menus.setMenuID(View.eGAME_EDITOR_DIPLOMACY_COLORS_PACKAGES);
                CFG.toastM.addM(CFG.lang.get("Enabled"));
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eGAME_EDITOR);
        CFG.menus.setBackAnimation(true);
        CFG.loadDiplomacyColors_GameData(CFG.sACTIVE_DIPLOMACY_COLORS_TAG);
    }
}

