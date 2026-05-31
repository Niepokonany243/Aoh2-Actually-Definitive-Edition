/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.MapEditor;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_NeighboringProvinces;
import age.of.civilizations2.jakowski.lukasz.Editor.Editors;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Menu_MapEditor_UpdateProvinceData
extends Menu {
    public Menu_MapEditor_UpdateProvinceData() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        List<String> tempL = CFG.getFileNames_O("map/" + CFG.map.getFileActiveMapPath() + "update/");
        for (int i = 0; i < tempL.size(); ++i) {
            menuElements.add(new Button_Classic(tempL.get(i), 50, 0, CFG.BUTTON_H * i + CFG.PADD * (i + 1), CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
            menuElements.add(new Button_Classic_ReflectedBG("CENTER", (int)(50.0f * CFG.GUI_SCALE), CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * i + CFG.PADD * (i + 1), CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        }
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getTitleM().setText(CFG.lang.get("UpdateProvinceData") + " - " + "map/" + CFG.map.getFileActiveMapPath() + "update/");
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.editorManager.setInUse(Editors.eNEIGHBORING_PROVINCES);
                this.onBackPressed();
                return;
            }
        }
        List<String> tempL = CFG.getFileNames_O("map/" + CFG.map.getFileActiveMapPath() + "update/");
        try {
            if ((iID - 1) % 2 == 0) {
                Editor_NeighboringProvinces.updateProvince(Integer.parseInt(tempL.get((iID - 1) / 2)));
                CFG.core.setActiveProvID(Integer.parseInt(tempL.get((iID - 1) / 2)));
                CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
            } else {
                CFG.core.setActiveProvID(Integer.parseInt(tempL.get((iID - 1) / 2)));
                CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
            }
        }
        catch (IndexOutOfBoundsException e) {
            CFG.toastM.addM("ERROR");
        }
        catch (IllegalArgumentException ex) {
            CFG.toastM.addM("ERROR FILE NAME");
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_CONNECTIONS);
        CFG.menus.setBackAnimation(true);
    }
}

