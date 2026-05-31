
package age.of.civilizations2.jakowski.lukasz.Menus.ArmyPos;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editors;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.files.FileHandle;
import java.util.ArrayList;

public class Menu_MapEditor_ArmyPosition_Convert
extends Menu {
    public Menu_MapEditor_ArmyPosition_Convert() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        FileHandle tempFileT = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "scales/" + "provinces/" + "Age_of_Civilizations");
        String tempT = tempFileT.readString();
        String[] tagsSPLITED = tempT.split(";");
        ArrayList<Integer> tempScales = new ArrayList<Integer>();
        for (i = 0; i < tagsSPLITED.length; ++i) {
            tempScales.add(Integer.parseInt(tagsSPLITED[i]));
        }
        for (i = 0; i < tempScales.size(); ++i) {
            if (CFG.map.getMapScale(CFG.map.getActiveMapIDN()) == ((Integer)tempScales.get(i)).intValue()) {
                menuElements.add(new Button_Classic(CFG.lang.get("Scale") + " x" + tempScales.get(i) + " - [" + CFG.map.getMpB().getWidthM() / CFG.map.getMapScale(CFG.map.getActiveMapIDN()) * (Integer)tempScales.get(i) + "x" + CFG.map.getMpB().getHeightM() / CFG.map.getMapScale(CFG.map.getActiveMapIDN()) * (Integer)tempScales.get(i) + "]", 50, 0, CFG.BUTTON_H * i + CFG.PADD * (i + 1), CFG.GAMEWIDTH, CFG.BUTTON_H, true, true));
                continue;
            }
            menuElements.add(new Button_Classic(CFG.lang.get("Scale") + " x" + tempScales.get(i) + " - [" + CFG.map.getMpB().getWidthM() / CFG.map.getMapScale(CFG.map.getActiveMapIDN()) * (Integer)tempScales.get(i) + "x" + CFG.map.getMpB().getHeightM() / CFG.map.getMapScale(CFG.map.getActiveMapIDN()) * (Integer)tempScales.get(i) + "]", 50, 0, CFG.BUTTON_H * i + CFG.PADD * (i + 1), CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        }
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getTitleM().setText(CFG.lang.get("ConvertToAnotherScale"));
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
        }
        FileHandle tempFileT = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "scales/" + "provinces/" + "Age_of_Civilizations");
        String tempT = tempFileT.readString();
        String[] tagsSPLITED = tempT.split(";");
        CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = Integer.parseInt(tagsSPLITED[iID - 1]);
        if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 != CFG.map.getMapScale(CFG.map.getActiveMapIDN())) {
            CFG.setDialogType(DialogType.CONVERT_ARMY_POSITION_TO_ANOTHER_SCALE);
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_ARMY_POSITION);
        CFG.menus.setBackAnimation(true);
        CFG.editorManager.setInUse(Editors.eSHIFT_ARMY);
    }
}

