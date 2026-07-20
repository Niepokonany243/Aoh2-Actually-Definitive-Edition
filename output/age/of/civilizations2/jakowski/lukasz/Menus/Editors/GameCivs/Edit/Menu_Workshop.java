
package age.of.civilizations2.jakowski.lukasz.Menus.Editors.GameCivs.Edit;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Editors.GameCivs.Edit.Menu_Workshop_Load;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sSPT;
import age.of.civilizations2.jakowski.lukasz.GameTaskScheduler;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import age.of.civilizations2.jakowski.lukasz.Z_Other.Undo.Undo_AssignProvinceCiv;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.util.ArrayList;
import java.util.List;

public class Menu_Workshop
extends Menu {
    public static List<String> lMods = new ArrayList<String>();

    public Menu_Workshop() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int buttonY = CFG.PADD;
        lMods.clear();
        FileHandle[] files = FileManager.IS_MAC ? Gdx.files.external("mods/").list() : Gdx.files.local("mods/").list();
        for (FileHandle file : files) {
            lMods.add(file.name());
        }
        for (int i = 0; i < lMods.size(); ++i) {
            if (lMods.get(i).equals("GameCivs")) continue;
            menuElements.add(new Button_Classic(lMods.get(i), (int)(50.0f * CFG.GUI_SCALE), 0, buttonY, CFG.GAMEWIDTH, CFG.BUTTON_H, true){
                int id;
                {
                    this.id = 0;
                }

                @Override
                public void actionElem(int iID) {
                    if (Gdx.files.internal("mods/" + lMods.get(this.getCurr()) + "/mod.txt").exists() || FileManager.IS_MAC && Gdx.files.external("mods/" + lMods.get(this.getCurr()) + "/mod.txt").exists()) {
                        Menu_Workshop_Load.uploaded = false;
                        CFG.menus.setMenuIDWithoutAnim(View.eLOAD_WORKSHOP_PUBLISH);
                        GameTaskScheduler.submit(new sSPT(lMods.get(this.getCurr())));
                    } else {
                        CFG.toastM.addM(CFG.lang.get("MissingFile") + ": mods/" + lMods.get(this.getCurr()) + "/mod.txt", CFG.COLOR_NEGATIVE_1);
                        CFG.toastM.setTimeInView(3500);
                    }
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.id = nCurrent;
                }

                @Override
                public int getCurr() {
                    return this.id;
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Publish")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
            buttonY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        if (menuElements.isEmpty()) {
            menuElements.add(new Button_Classic_LR_Line(CFG.lang.get("None"), -1, AoCGame.LEFT, buttonY, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true){

                @Override
                public void actionElem(int iID) {
                }
            });
            buttonY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD, menuElements);
        this.updateLang();
        CFG.lCreateScenario_UndoAssignProvsCivID = new ArrayList<Undo_AssignProvinceCiv>();
        CFG.lCreateScenario_UndoWastelandProvinces = new ArrayList<Integer>();
    }

    public boolean createItem(String name, int type) {
        sUM.sUI.setAchievement(name);
        return true;
    }

    public boolean submitItemUpdate(String itemId, String contentPath) {
        sUM.sUI.getStatI(itemId, 0);
        return true;
    }

    public boolean downloadItem(String itemId) {
        sUM.sUI.getStatF(itemId, 0.0f);
        return true;
    }

    public boolean subscribeItem(String itemId) {
        sUM.sUI.setStatI(itemId, itemId.length());
        return true;
    }

    public boolean unsubscribeItem(String itemId) {
        sUM.sUI.clearAchievement(itemId);
        return true;
    }

    public boolean enumerateItems(int startIndex, int count) {
        sUM.sUI.setStatI("items", startIndex + count);
        return true;
    }
}

