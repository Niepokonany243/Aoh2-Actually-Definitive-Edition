
package age.of.civilizations2.jakowski.lukasz.Menus.Continents;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Remove;
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
import java.io.IOException;
import java.util.ArrayList;

public class Menu_Continents_CreateNewPackage
extends Menu {
    private String sPackageName;

    public Menu_Continents_CreateNewPackage() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_Continents_CreateNewPackage.this.sPackageName + ": " + super.getTextE();
            }
        });
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        boolean tempClickableRemove = CFG.editor_Package_ContinentsData.getContinentsTagsSize() > 1;
        for (int i = 0; i < CFG.editor_Package_ContinentsData.getContinentsTagsSize(); ++i) {
            menuElements.add(new Button_Classic(CFG.getContinentDataName(CFG.editor_Package_ContinentsData.getContinentTag(i)), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (i + 2) + CFG.PADD * (i + 3), CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
            menuElements.add(new Button_Classic_Remove(CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * (i + 2) + CFG.PADD * (i + 3), CFG.BUTTON_W * 2, CFG.BUTTON_H, tempClickableRemove));
        }
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sPackageName = CFG.lang.get("PackageName");
        this.getMenuElem(0).setTextE(CFG.editor_Package_ContinentsData.getContinentsTagsSize() > 1 ? CFG.lang.get("Save") : CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.editor_Package_ContinentsData.getPackageName());
        this.getMenuElem(2).setTextE(CFG.lang.get("AddNewContinent"));
        this.getMenuElem(3).setClickable(false);
        this.getMenuElem(4).setClickable(false);
        this.getTitleM().setText(CFG.lang.get("CreateNewPackage"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                if (CFG.editor_Package_ContinentsData.getContinentsTagsSize() > 1) {
                    if (this.getMenuElem(1).getTextE().length() == 0) {
                        CFG.showKeyboard(1);
                        CFG.toastM.addM(this.sPackageName);
                        CFG.toastM.setTimeInView(2500);
                        break;
                    }
                    CFG.editor_Package_ContinentsData.setPackageName(this.getMenuElem(1).getTextE());
                    CFG.core.saveContinentPackage();
                    this.onBackPressed();
                    break;
                }
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.showKeyboard();
                break;
            }
            case 2: {
                CFG.menus.setMenuID(View.eMAP_EDITOR_CONTINENTS_ADDNEWCONTINENT_TOPACKAGE);
                break;
            }
            default: {
                if (iID % 2 == 0) {
                    CFG.editor_Package_ContinentsData.removeContinentTag((iID - 3) / 2);
                    CFG.menus.setMenuID(View.eMAP_EDITOR_CREATE_CONTINENTS_PACKAGE);
                    break;
                }
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = CFG.editor_Package_ContinentsData.getContinentTag((iID - 3) / 2);
                try {
                    FileHandle file = FileManager.loadFile("map/data/continents/packges_data/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
                    CFG.editor_Continent_GameData = (Continent_GameData)CFG.deserialize(file.readBytes());
                }
                catch (ClassNotFoundException classNotFoundException) {
                }
                catch (IOException iOException) {
                    
                }
                CFG.backToMenu = View.eMAP_EDITOR_CREATE_CONTINENTS_PACKAGE;
                CFG.menus.setMenuID(View.eMAP_EDITOR_CREATE_NEW_CONTINENT);
                RenderProvince.updateDrawProvinces();
                CFG.menus.getColorPicker().setPosX(CFG.PADD * 3);
                CFG.menus.getColorPicker().setPosY(CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD + CFG.menus.getColorPicker().getPosX());
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.editor_Continent_GameData.getR(), CFG.editor_Continent_GameData.getG(), CFG.editor_Continent_GameData.getB());
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.MAP_EDITOR_CONTINENT_COLOR);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_PACKAGES_CONTINENTS);
        CFG.menus.setBackAnimation(true);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }
}

