
package age.of.civilizations2.jakowski.lukasz.Menus.Editors.GameCivs.Edit;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import age.of.civilizations2.jakowski.lukasz.Z_Other.Undo.Undo_AssignProvinceCiv;
import java.util.ArrayList;

public class Menu_ManageMods
extends Menu {
    public Menu_ManageMods() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int buttonY = CFG.PADD;
        for (i = 0; i < sUM.sUIF.size(); ++i) {
            menuElements.add(new Button_Classic(sUM.sUFAM.get(i), (int)(50.0f * CFG.GUI_SCALE), 0, buttonY, CFG.GAMEWIDTH, CFG.BUTTON_H, true, sUM.isTurnedOn(sUM.sUIF.get(i).getFolder())){
                int id;
                {
                    this.id = 0;
                }

                @Override
                public void actionElem(int iID) {
                    sUM.addModsTurnedOff(sUM.sUIF.get(this.getCurr()).getFolder());
                    this.setCheckboxSt(sUM.isTurnedOn(sUM.sUIF.get(this.getCurr()).getFolder()));
                    CFG.toastM.addM(CFG.lang.get("GameNeedsToBeRestartedToApplyTheChanges"), CFG.COLOR_GOLD);
                    CFG.toastM.setTimeInView(3500);
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.id = nCurrent;
                }

                @Override
                public int getCurr() {
                    return this.id;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
            buttonY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        for (i = 0; i < sUM.sUFA.size(); ++i) {
            menuElements.add(new Button_Classic(sUM.sUFA.get(i), (int)(50.0f * CFG.GUI_SCALE), 0, buttonY, CFG.GAMEWIDTH, CFG.BUTTON_H, true, sUM.isTurnedOn(sUM.sUFA.get(i))){
                int id;
                {
                    this.id = 0;
                }

                @Override
                public void actionElem(int iID) {
                    sUM.addModsTurnedOff(sUM.sUFA.get(this.getCurr()));
                    this.setCheckboxSt(sUM.isTurnedOn(sUM.sUFA.get(this.getCurr())));
                    CFG.toastM.addM(CFG.lang.get("GameNeedsToBeRestartedToApplyTheChanges"), CFG.COLOR_GOLD);
                    CFG.toastM.setTimeInView(3500);
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.id = nCurrent;
                }

                @Override
                public int getCurr() {
                    return this.id;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
            buttonY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD, menuElements);
        this.updateLang();
        CFG.lCreateScenario_UndoAssignProvsCivID = new ArrayList<Undo_AssignProvinceCiv>();
        CFG.lCreateScenario_UndoWastelandProvinces = new ArrayList<Integer>();
    }
}

