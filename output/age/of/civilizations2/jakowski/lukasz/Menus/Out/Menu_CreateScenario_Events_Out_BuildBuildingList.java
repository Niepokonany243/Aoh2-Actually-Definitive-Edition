
package age.of.civilizations2.jakowski.lukasz.Menus.Out;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Out.Menu_CreateScenario_Events_Out_BuildBuilding;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_Out_BuildBuildingList
extends Menu {
    public Menu_CreateScenario_Events_Out_BuildBuildingList() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(Menu_CreateScenario_Events_Out_BuildBuilding.getBName(0), (int)(50.0f * CFG.GUI_SCALE), 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(Menu_CreateScenario_Events_Out_BuildBuilding.getBName(1), (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(Menu_CreateScenario_Events_Out_BuildBuilding.getBName(2), (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(Menu_CreateScenario_Events_Out_BuildBuilding.getBName(3), (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(Menu_CreateScenario_Events_Out_BuildBuilding.getBName(4), (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(Menu_CreateScenario_Events_Out_BuildBuilding.getBName(5), (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(Menu_CreateScenario_Events_Out_BuildBuilding.getBName(6), (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(Menu_CreateScenario_Events_Out_BuildBuilding.getBName(7), (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Save"));
        this.getTitleM().setText(CFG.lang.get("Buildings"));
    }

    public static String getBName(int id) {
        String out = "";
        switch (id) {
            case 0: {
                out = out + CFG.lang.get(BuildingsManager.getFort_Name(1));
                break;
            }
            case 1: {
                out = out + CFG.lang.get(BuildingsManager.getTower_Name(1));
                break;
            }
            case 2: {
                out = out + CFG.lang.get(BuildingsManager.getFarm_Name(1));
                break;
            }
            case 3: {
                out = out + CFG.lang.get(BuildingsManager.getWorkshop_Name(1));
                break;
            }
            case 4: {
                out = out + CFG.lang.get(BuildingsManager.getMarket_Name(1));
                break;
            }
            case 5: {
                out = out + CFG.lang.get(BuildingsManager.getLibrary_Name(1));
                break;
            }
            case 6: {
                out = out + CFG.lang.get(BuildingsManager.getArmoury_Name(1));
                break;
            }
            case 7: {
                out = out + CFG.lang.get(BuildingsManager.getSupply_Name(1));
            }
        }
        return out;
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
        }
        CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).setCivID2(iID - 1);
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_BUILDBUILDING);
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_BUILDBUILDING);
        CFG.menus.setBackAnimation(true);
    }
}

