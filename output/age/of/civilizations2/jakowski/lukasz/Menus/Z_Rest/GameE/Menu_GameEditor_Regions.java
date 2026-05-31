/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.GameE;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_Regions;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;
import java.util.List;

public class Menu_GameEditor_Regions
extends Menu {
    public static List<Color> lColors = new ArrayList<Color>();

    public Menu_GameEditor_Regions() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.initMenu(null, 0, 0, CFG.PADD, CFG.PADD, menuElements);
        for (int i = 0; i < CFG.core.getRegions().size(); ++i) {
            lColors.add(CFG.getRandomColor());
        }
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            default: 
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_EDIT);
        CFG.menus.setBackAnimation(true);
        Editor_Regions.lUndo.clear();
        CFG.brushMode = false;
        CFG.editorManager.resetInUseEditors();
        RenderProvince.updateDrawProvinces();
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv(i).getArmyObject(0).updateArmyWidth_Just(i);
        }
    }
}

