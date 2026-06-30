
package age.of.civilizations2.jakowski.lukasz.Menus.Settings;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NG;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Keyboard;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.LangManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_Top;
import age.of.civilizations2.jakowski.lukasz.Menus.Load.Menu_LoadMap;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ConfigINI;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import age.of.civilizations2.jakowski.lukasz.Z_Other.PNM;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Settings_Options
extends Menu {
    public Menu_Settings_Options() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;
        int menuW = CFG.settingsGD.BETTER_UI ? (int)Math.min(CFG.GAMEWIDTH * 0.8f, 1200 * CFG.GUI_SCALE) : Menu_InGame_FA_Top.getWindowWidth();
        
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY, menuW, CFG.BUTTON_H, CFG.goToMenu2 == View.eMAINMENU){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("LandProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countLandProvinces(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SeaProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countSeaProvinces(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("Age of History 2: Definitive Edition"));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true));
        int tYProvinces = tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        int tYProvinces2 = tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        int tYProvinces4 = tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        int tYProvinces3 = tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        int tYProvinces5 = tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true){});
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, Gdx.app.getType() == Application.ApplicationType.Android, ConfigINI.landscape){

            @Override
            public boolean getCheckboxSt() {
                return ConfigINI.landscape;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.randomLeaders){

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.randomLeaders;
            }
        });
        menuElements.add(new Button_Classic("-", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG("+", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("-", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG("+", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.showNextPlayerView){

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.showNextPlayerView;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.showOrderOfMovesView){

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.showOrderOfMovesView;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.CONTINUOUS_RENDERING){

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.CONTINUOUS_RENDERING;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.CONFIRM_END_TURN){

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.CONFIRM_END_TURN;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.CONFIRM_NO_ORDERS){

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.CONFIRM_NO_ORDERS;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.reverseDirectionX){

            @Override
            public boolean getCheckboxSt() {
                return CFG.reverseDirectionX;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.reverseDirectionY){

            @Override
            public boolean getCheckboxSt() {
                return CFG.reverseDirectionY;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, LangManager.translationsKeysMode){

            @Override
            public boolean getCheckboxSt() {
                return LangManager.translationsKeysMode;
            }
        });
        menuElements.add(new Button_Classic_LR_Line(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.loadCursor){

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.loadCursor;
            }
        });
        int mapOverlaysY = tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_NG("Age of History 2: Definitive Edition", null, -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_Classic("-", -1, 0, tYProvinces, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tYProvinces, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG("+", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tYProvinces, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_Classic("<<", -1, 0, tYProvinces2, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tYProvinces2, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tYProvinces2, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_Classic("<<", -1, 0, tYProvinces3, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tYProvinces3, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tYProvinces3, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_Classic("<<", -1, 0, tYProvinces4, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tYProvinces4, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tYProvinces4, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_Classic("<<", -1, 0, tYProvinces5, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tYProvinces5, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tYProvinces5, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_Classic("<<", -1, 0, mapOverlaysY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, !CFG.getIsDesktop()));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, mapOverlaysY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, !CFG.getIsDesktop()));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), mapOverlaysY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, !CFG.getIsDesktop()));
        menuElements.add(new Button_Classic("<<", -1, 0, mapOverlaysY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, mapOverlaysY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), mapOverlaysY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        tY = ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        menuElements.add(new Button_Classic("<<", -1, 0, tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("<<", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("<<", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("<<", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("<<", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("<<", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("<<", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("<<", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.BETTER_UI){

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.BETTER_UI;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, CFG.settingsGD.BETTER_UI));
        menuElements.add(new Button_Classic("<<", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("<<", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.ANNEXATION_DELAY){
            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.ANNEXATION_DELAY;
            }
        });
        menuElements.add(new Button_Classic("-", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG("+", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.DISABLE_INFLATION){

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.DISABLE_INFLATION;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.DISABLE_AI_INVESTING){
            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.DISABLE_AI_INVESTING;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.AIR_DEFENCE_SYSTEMS){

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.AIR_DEFENCE_SYSTEMS;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.MISSILES){

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.MISSILES;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.EXPERIMENTAL_BATTLE_SYSTEM){

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.EXPERIMENTAL_BATTLE_SYSTEM;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.BAT_PLUS){
            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.BAT_PLUS;
            }
            @Override
            public boolean getIsClickable() {
                return true;
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.AI_GROUP_UNITS){

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.AI_GROUP_UNITS;
            }
        });
        menuElements.add(new Button_Classic("<<", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("<<", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, menuW - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuW, CFG.BUTTON_H, true, CFG.settingsGD.DYNAMIC_MIN_ARMY){
            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.DYNAMIC_MIN_ARMY;
            }
        });
        if (CFG.settingsGD.BETTER_UI) {
            this.initMenu(null, CFG.GAMEWIDTH / 2 - menuW / 2 + AoCGame.LEFT, CFG.BUTTON_H, menuW, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2, menuElements);
        } else {
            this.initMenu(null, 0 + AoCGame.LEFT, CFG.BUTTON_H * 3 / 4, Menu_InGame_FA_Top.getWindowWidth(), CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD, menuElements);
        }
        this.updateLang();
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (visible) {
            CFG.map.getMpC().addDisableMovingMapRef();
        } else {
            CFG.map.getMpC().removeDisableMovingMapRef();
        }
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("MapType") + ": " + CFG.map.getMapName(CFG.map.getActiveMapIDN()));
        this.getMenuElem(1).setTextE(CFG.lang.get("Language") + ": " + CFG.lang.get("LANGUAGENAME"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Graphics") + " & " + CFG.lang.get("UIScale"));
        this.getMenuElem(3).setTextE(CFG.lang.get("UIScale"));
        this.getMenuElem(4).setTextE(CFG.lang.get("ProvinceSettings"));
        this.getMenuElem(5).setTextE(CFG.lang.get("Audio"));
        this.getMenuElem(6).setTextE(CFG.lang.get("Landscape"));
        this.getMenuElem(7).setTextE(CFG.lang.get("Leaders") + ": " + CFG.lang.get("Random"));
        this.getMenuElem(9).setTextE(CFG.lang.get("FontSize") + ": " + CFG.settingsGD.FONT_MAIN_SIZEX);
        this.getMenuElem(12).setTextE(CFG.lang.get("TurnsBetweenAutosave") + ": " + CFG.settingsGD.TURNS_BETWEEN_AUTOSAVEX);
        this.getMenuElem(14).setTextE(CFG.lang.get("ShowNextPlayerTurnView"));
        this.getMenuElem(15).setTextE(CFG.lang.get("OrderOfMoves"));
        this.getMenuElem(16).setTextE(CFG.lang.get("ContinuousRendering"));
        this.getMenuElem(17).setTextE(CFG.lang.get("ConfirmEndTurn"));
        this.getMenuElem(18).setTextE(CFG.lang.get("ConfirmNoOrders"));
        this.getMenuElem(19).setTextE(CFG.lang.get("InvertXAxis"));
        this.getMenuElem(20).setTextE(CFG.lang.get("InvertYAxis"));
        this.getMenuElem(21).setTextE(CFG.lang.get("TranslationKeys"));
        this.getMenuElem(22).setTextE(CFG.lang.get("CustomCursor"));
        this.getMenuElem(23).setTextE(CFG.lang.get("Defaults"));
        this.getMenuElem(25).setTextE(Menu_Settings_Options.getSettingsText_Names());
        this.getMenuElem(28).setTextE(CFG.lang.get("ShortenArmyOver") + ": " + CFG.settingsGD.SHORTEN_ARMY_OVER);
        this.getMenuElem(31).setTextE(CFG.lang.get("ShowBattleReports") + ": " + (CFG.settingsGD.SHOW_BATTLE_REPORT ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(34).setTextE(CFG.lang.get("ShowCombatMovement") + ": " + (CFG.settingsGD.SHOW_COMBAT_MOVEMENT ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(37).setTextE(CFG.lang.get("Flag") + ", " + CFG.lang.get("Capital") + ": " + (CFG.settingsGD.CAPITAL_FLAGS_HIGH ? CFG.lang.get("High") : CFG.lang.get("Medium")));
        this.getMenuElem(34).setTextE(CFG.lang.get("ShowCombatMovement") + ": " + (CFG.settingsGD.SHOW_COMBAT_MOVEMENT ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(40).setTextE(CFG.lang.get("Map") + ", " + CFG.lang.get("Overlays") + ": " + (Menu_LoadMap.loadMapOverlays() ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(43).setTextE(CFG.lang.get("Ships") + ": " + CFG.settingsGD.SHIPS_ON_MAP + "%");
        this.getMenuElem(46).setTextE(CFG.lang.get("SaveSpeed") + ", " + CFG.lang.get("Provinces") + ": " + CFG.lang.get("NoLimit"));
        this.getMenuElem(49).setTextE(CFG.lang.get("SaveSpeed") + ", " + CFG.lang.get("Civilizations") + ": " + CFG.lang.get("NoLimit"));
        this.getMenuElem(52).setTextE(CFG.lang.get("LoadSpeed") + ", " + CFG.lang.get("Provinces") + ": " + CFG.lang.get("NoLimit"));
        this.getMenuElem(55).setTextE(CFG.lang.get("LoadSpeed") + ", " + CFG.lang.get("Civilizations") + ": " + CFG.lang.get("NoLimit"));
        this.getMenuElem(58).setTextE(CFG.lang.get("UseOldProvinceBorders") + ": " + (CFG.settingsGD.USE_OLD_PROVINCE_BORDER ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(61).setTextE(CFG.lang.get("Menu") + " Extra Left Position: " + CFG.settingsGD.MENU_EXTRA_LEFT + "px");
        this.getMenuElem(64).setTextE(CFG.lang.get("Map") + ": " + CFG.lang.get("DeclareWar") + " - " + CFG.lang.get("GameAnimation") + ": " + (CFG.settingsGD.DRAW_WAR_ON_MAP ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(67).setTextE(CFG.lang.get("ProvinceBorderThickness") + ": " + CFG.getPrecision2(CFG.settingsGD.BORDER_EXTRA_THICKNESS, 100) + "px");
        this.getMenuElem(69).setTextE(CFG.lang.get("ProvinceBorder") + ": " + CFG.lang.get("Color"));
        this.getMenuElem(70).setTextE(CFG.lang.get("InnerBorders") + ": " + CFG.lang.get("Color"));
        this.getMenuElem(71).setTextE("Better UI: " + (CFG.settingsGD.BETTER_UI ? CFG.lang.get("On") : CFG.lang.get("Off")));
        if (CFG.settingsGD.BETTER_UI) {
            String themeName = "Dark";
            if (CFG.settingsGD.UI_THEME == 1) themeName = "Purple";
            else if (CFG.settingsGD.UI_THEME == 2) themeName = "Red";
            this.getMenuElem(72).setTextE("Theme: " + themeName);
            this.getMenuElem(72).setVisibleE(true);
        } else {
            this.getMenuElem(72).setVisibleE(false);
        }
        String[] visNames = new String[]{CFG.lang.get("Close"), CFG.lang.get("Medium"), CFG.lang.get("Far"), CFG.lang.get("VeryFar"), CFG.lang.get("VeryFar+")};
        this.getMenuElem(74).setTextE(CFG.lang.get("ArmyVisibility") + ": " + visNames[Math.min(CFG.settingsGD.ARMY_VISIBILITY_RANGE, 4)]);
        String[] iconNames = new String[]{"0.25x", "0.5x", "0.75x", CFG.lang.get("Default")};
        this.getMenuElem(77).setTextE(CFG.lang.get("ArmyIconSize") + ": " + iconNames[Math.min(CFG.settingsGD.ARMY_ICON_SCALE, 3)]);
        this.getMenuElem(79).setTextE("Annexation Delay: " + (CFG.settingsGD.ANNEXATION_DELAY ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(81).setTextE("Annexation Delay Turns: " + CFG.settingsGD.ANNEXATION_DELAY_TURNS);
        this.getMenuElem(83).setTextE("Disable Inflation: " + (CFG.settingsGD.DISABLE_INFLATION ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(84).setTextE("Disable AI Investing: " + (CFG.settingsGD.DISABLE_AI_INVESTING ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(85).setTextE("Air Defence Systems: " + (CFG.settingsGD.AIR_DEFENCE_SYSTEMS ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(86).setTextE("Missiles: " + (CFG.settingsGD.MISSILES ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(87).setTextE("Game Values Editor");
        this.getMenuElem(88).setTextE("Experimental Battle System: " + (CFG.settingsGD.EXPERIMENTAL_BATTLE_SYSTEM ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(89).setTextE("Smart Bat+: " + (CFG.settingsGD.BAT_PLUS ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(90).setTextE("AI: Group Units: " + (CFG.settingsGD.AI_GROUP_UNITS ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(92).setTextE("Bat+ Breakthrough: " + CFG.getPrecision2(CFG.settingsGD.BAT_PLUS_BREAKTHROUGH_RATIO, 2) + "x");
        this.getMenuElem(95).setTextE("Budget Slider Max: " + GameValues.gvInGame.getBudgetSpendingSliderMax() + "%");
        this.getMenuElem(97).setTextE("Dynamic Minimum Army: " + (CFG.settingsGD.DYNAMIC_MIN_ARMY ? CFG.lang.get("On") : CFG.lang.get("Off")));
    }

    public static String getSettingsText_Names() {
        String out = CFG.lang.get("ProvinceNames") + ": ";
        switch (CFG.settingsGD.SPROVN) {
            case 0: {
                out = out + CFG.lang.get("Off");
                break;
            }
            case 1: {
                out = out + CFG.lang.get("Low");
                break;
            }
            case 2: {
                out = out + CFG.lang.get("Medium");
                break;
            }
            default: {
                out = out + CFG.lang.get("High");
            }
        }
        return out;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (CFG.settingsGD.BETTER_UI) {
            BetterUI_Manager.drawBetterMenuBG(oSB, iTranslateX + this.getPosX(), iTranslateY + this.getPosY(), this.getWidthM(), this.getHeightM());

            super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            
            oSB.setColor(Color.WHITE);
            return;
        }
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.map.getIcon(CFG.map.getActiveMapIDN()).drawO(oSB, this.getMenuElem(0).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE() / 2 - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getHeight() - CFG.CIV_FLAG_HEIGHT / 2 + this.getMenuPosY() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    private void resetDefaults() {
        CFG.settingsGD.PROV_ALPHA = 100;
        CFG.settingsGD.OCCUPIED_PROV_ALPHA = 100;
        CFG.settingsGD.OCCUPIED_STRIPES_SIZE = 2.0f;
        CFG.settingsGD.ENABLE_INNERBORDERS = true;
        CFG.settingsGD.DRAW_MOVE_UNITS_ARMY_IN_EVERYSINGLE_PROVINCE = true;
        CFG.settingsGD.SHOW_COMBAT_MOVEMENT = true;
        CFG.settingsGD.SHOW_BATTLE_REPORT = false;
        CFG.settingsGD.CONTINUOUS_RENDERING = true;
        CFG.settingsGD.CONFIRM_END_TURN = false;
        CFG.settingsGD.CONFIRM_NO_ORDERS = false;
        CFG.settingsGD.ANNEXATION_DELAY = true;
        CFG.settingsGD.ANNEXATION_DELAY_TURNS = 5;
        CFG.settingsGD.DISABLE_INFLATION = true;
        CFG.settingsGD.DISABLE_AI_INVESTING = true;
        CFG.settingsGD.AIR_DEFENCE_SYSTEMS = true;
        CFG.settingsGD.MISSILES = true;
        CFG.settingsGD.BETTER_UI = true;
        CFG.settingsGD.AI_GROUP_UNITS = false;
        CFG.settingsGD.ARMY_VISIBILITY_RANGE = 3;
        CFG.settingsGD.ARMY_ICON_SCALE = 1;
        CFG.settingsGD.BAT_PLUS = true;
        CFG.settingsGD.EXPERIMENTAL_BATTLE_SYSTEM = true;
        CFG.settingsGD.CAPITAL_FLAGS_HIGH = true;
        CFG.settingsGD.SHIPS_ON_MAP = 10;
        CFG.settingsGD.USE_OLD_PROVINCE_BORDER = false;
        CFG.settingsGD.BORDER_EXTRA_THICKNESS = 0.0f;
        CFG.settingsGD.SHORTEN_ARMY_OVER = 1000;
        CFG.settingsGD.TURNS_BETWEEN_AUTOSAVEX = 200;
        CFG.settingsGD.randomLeaders = false;
        this.updateLang();
        CFG.toastM.addM("Settings reset to defaults");
    }

    private void updateBudgetSliderMax(int delta) {
        GameValues.gvInGame.BUDGET_SPENDING_SLIDER_MAX = Math.max(100, GameValues.gvInGame.getBudgetSpendingSliderMax() + delta);
        this.getMenuElem(95).setTextE("Budget Slider Max: " + GameValues.gvInGame.getBudgetSpendingSliderMax() + "%");
        try {
            new Menu_Settings_GameValues.VariableEntry(GameValues.gvInGame, GameValues.gvInGame.getClass().getField("BUDGET_SPENDING_SLIDER_MAX"), "gvInGame", "game/gameValues/gvInGame.json", "UI & Display").save();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public final void actionEL(int iID) {
        CFG.menus.getColorPicker().setVisible(false, null);
        switch (iID) {
            case 0: {
                CFG.backToMenu = View.eSETTINGS;
                CFG.menus.setMenuID(View.eSELECT_MAP_TYPE);
                return;
            }
            case 1: {
                CFG.backToMenu = View.eSETTINGS;
                CFG.menus.setMenuID(View.eSELECT_LANGUAGE);
                CFG.map.getMpB().updateWorldMap_Shaders();
                CFG.VIEW_SHOW_VALUES = true;
                break;
            }
            case 2: {
                CFG.menus.setMenuID(View.eSETTINGS_GRAPHICS);
                break;
            }
            case 3: {
                CFG.menus.setMenuID(View.eSELECT_UI_SCALE);
                return;
            }
            case 4: {
                if (!SaveGameManager.gameCanBeContinued) {
                    for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                        CFG.core.getProv(i).getArmyObject(0).updateArmyWidth(i);
                    }
                }
                CFG.menus.setMenuID(View.eSETTINGS_PROVINCE);
                return;
            }
            case 5: {
                CFG.menus.setVisible_Settings_Audio();
                break;
            }
            case 6: {
                ConfigINI.landscape = !ConfigINI.landscape;
                ConfigINI.saveConfig();
                Preferences prefs = Gdx.app.getPreferences("AND");
                prefs.putBoolean("landscape", ConfigINI.landscape);
                CFG.toastM.addM(CFG.lang.get("GameNeedsToBeRestartedToApplyTheChanges"));
                CFG.toastM.setTimeInView(4500);
                break;
            }
            case 7: {
                CFG.settingsGD.randomLeaders = !CFG.settingsGD.randomLeaders;
                break;
            }
            case 8: {
                --CFG.settingsGD.FONT_MAIN_SIZEX;
                if (CFG.settingsGD.FONT_MAIN_SIZEX < 8) {
                    CFG.settingsGD.FONT_MAIN_SIZEX = 8;
                }
                CFG.loadFontMain();
                this.updateLang();
                CFG.menus.updateLang();
                break;
            }
            case 9: {
                CFG.settingsGD.FONT_MAIN_SIZEX = CFG.XXXHDPI ? 36 : (CFG.XXHDPI ? 32 : (CFG.XHDPI ? 24 : 18));
                CFG.loadFontMain();
                this.updateLang();
                CFG.menus.updateLang();
                break;
            }
            case 10: {
                ++CFG.settingsGD.FONT_MAIN_SIZEX;
                if (CFG.settingsGD.FONT_MAIN_SIZEX > 128) {
                    CFG.settingsGD.FONT_MAIN_SIZEX = 128;
                }
                CFG.loadFontMain();
                this.updateLang();
                CFG.menus.updateLang();
                break;
            }
            case 11: {
                CFG.settingsGD.TURNS_BETWEEN_AUTOSAVEX -= 10;
                if (CFG.settingsGD.TURNS_BETWEEN_AUTOSAVEX < 0) {
                    CFG.settingsGD.TURNS_BETWEEN_AUTOSAVEX = 0;
                }
                this.updateLang();
                break;
            }
            case 12: {
                CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                break;
            }
            case 13: {
                CFG.settingsGD.TURNS_BETWEEN_AUTOSAVEX += 10;
                if (CFG.settingsGD.TURNS_BETWEEN_AUTOSAVEX > 5000) {
                    CFG.settingsGD.TURNS_BETWEEN_AUTOSAVEX = 5000;
                }
                this.updateLang();
                break;
            }
            case 14: {
                CFG.settingsGD.showNextPlayerView = !CFG.settingsGD.showNextPlayerView;
                break;
            }
            case 15: {
                CFG.settingsGD.showOrderOfMovesView = !CFG.settingsGD.showOrderOfMovesView;
                break;
            }
            case 16: {
                CFG.settingsGD.CONTINUOUS_RENDERING = !CFG.settingsGD.CONTINUOUS_RENDERING;
                Gdx.graphics.setContinuousRendering(CFG.settingsGD.CONTINUOUS_RENDERING);
                break;
            }
            case 17: {
                CFG.settingsGD.CONFIRM_END_TURN = !CFG.settingsGD.CONFIRM_END_TURN;
                break;
            }
            case 18: {
                CFG.settingsGD.CONFIRM_NO_ORDERS = !CFG.settingsGD.CONFIRM_NO_ORDERS;
                break;
            }
            case 19: {
                CFG.reverseDirectionX = !CFG.reverseDirectionX;
                CFG.map.getTouchMgr().buildReversePosX();
                CFG.map.getTouchMgr().buildReversePosX2();
                break;
            }
            case 20: {
                CFG.reverseDirectionY = !CFG.reverseDirectionY;
                CFG.map.getTouchMgr().buildReversePosY();
                CFG.map.getTouchMgr().buildReversePosY2();
                break;
            }
            case 21: {
                LangManager.translationsKeysMode = !LangManager.translationsKeysMode;
                CFG.lang.updateKeyOutput();
                CFG.menus.updateLang();
                break;
            }
            case 22: {
                CFG.settingsGD.loadCursor = !CFG.settingsGD.loadCursor;
                AoCGame.loadCursor(false);
                if (!CFG.settingsGD.loadCursor) break;
                CFG.toastM.addM(" --- The cursor may disappear during video recording --- ", CFG.COLOR_NEGATIVE_2);
                break;
            }
            case 23: {
                this.resetDefaults();
                break;
            }
            case 24: {
                --CFG.settingsGD.SPROVN;
                CFG.settingsGD.SPROVN = Math.max(0, CFG.settingsGD.SPROVN);
                this.getMenuElem(25).setTextE(Menu_Settings_Options.getSettingsText_Names());
                PNM.uDPN();
                break;
            }
            case 26: {
                ++CFG.settingsGD.SPROVN;
                CFG.settingsGD.SPROVN = Math.min(3, CFG.settingsGD.SPROVN);
                this.getMenuElem(25).setTextE(Menu_Settings_Options.getSettingsText_Names());
                PNM.uDPN();
                break;
            }
            case 27: {
                CFG.settingsGD.SHORTEN_ARMY_OVER = Math.max(10, Math.max(10, CFG.settingsGD.SHORTEN_ARMY_OVER) / 10);
                this.getMenuElem(28).setTextE(CFG.lang.get("ShortenArmyOver") + ": " + CFG.settingsGD.SHORTEN_ARMY_OVER);
                try {
                    for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                        for (int j = 0; j < CFG.core.getProv(i).getCivsSize(); ++j) {
                            CFG.core.getProv(i).getArmyObject(j).updateArmyWidth_Just(i);
                        }
                    }
                    break;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                    break;
                }
            }
            case 29: {
                CFG.settingsGD.SHORTEN_ARMY_OVER = Math.min(1000000000, Math.max(10, CFG.settingsGD.SHORTEN_ARMY_OVER) * 10);
                this.getMenuElem(28).setTextE(CFG.lang.get("ShortenArmyOver") + ": " + CFG.settingsGD.SHORTEN_ARMY_OVER);
                try {
                    for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                        for (int j = 0; j < CFG.core.getProv(i).getCivsSize(); ++j) {
                            CFG.core.getProv(i).getArmyObject(j).updateArmyWidth_Just(i);
                        }
                    }
                    break;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                    break;
                }
            }
            case 30: 
            case 32: {
                CFG.settingsGD.SHOW_BATTLE_REPORT = !CFG.settingsGD.SHOW_BATTLE_REPORT;
                this.getMenuElem(31).setTextE(CFG.lang.get("ShowBattleReports") + ": " + (CFG.settingsGD.SHOW_BATTLE_REPORT ? CFG.lang.get("On") : CFG.lang.get("Off")));
                break;
            }
            case 33: 
            case 35: {
                CFG.settingsGD.SHOW_COMBAT_MOVEMENT = !CFG.settingsGD.SHOW_COMBAT_MOVEMENT;
                this.getMenuElem(34).setTextE(CFG.lang.get("ShowCombatMovement") + ": " + (CFG.settingsGD.SHOW_COMBAT_MOVEMENT ? CFG.lang.get("On") : CFG.lang.get("Off")));
                break;
            }
            case 36: 
            case 38: {
                CFG.settingsGD.CAPITAL_FLAGS_HIGH = !CFG.settingsGD.CAPITAL_FLAGS_HIGH;
                this.getMenuElem(37).setTextE(CFG.lang.get("Flag") + ", " + CFG.lang.get("Capital") + ": " + (CFG.settingsGD.CAPITAL_FLAGS_HIGH ? CFG.lang.get("High") : CFG.lang.get("Medium")));
                Core.updateDrawCapitalFlagMap();
                break;
            }
            case 39: 
            case 41: {
                CFG.settingsGD.ANDROID_LOAD_MAP_OVERLAYS = !CFG.settingsGD.ANDROID_LOAD_MAP_OVERLAYS;
                this.getMenuElem(40).setTextE(CFG.lang.get("Map") + ", " + CFG.lang.get("Overlays") + ": " + (Menu_LoadMap.loadMapOverlays() ? CFG.lang.get("On") : CFG.lang.get("Off")));
                CFG.toastM.addM(CFG.lang.get("GameNeedsToBeRestartedToApplyTheChanges"));
                CFG.toastM.setTimeInView(4500);
                break;
            }
            case 42: {
                CFG.settingsGD.SHIPS_ON_MAP = Math.max(0, CFG.settingsGD.SHIPS_ON_MAP - 1);
                this.getMenuElem(43).setTextE(CFG.lang.get("Ships") + ": " + CFG.settingsGD.SHIPS_ON_MAP + "%");
                break;
            }
            case 44: {
                CFG.settingsGD.SHIPS_ON_MAP = Math.min(100, CFG.settingsGD.SHIPS_ON_MAP + 1);
                this.getMenuElem(43).setTextE(CFG.lang.get("Ships") + ": " + CFG.settingsGD.SHIPS_ON_MAP + "%");
                break;
            }
            case 45: {
                CFG.settingsGD.SAVE_PROVINCES_SPEED = Integer.MAX_VALUE;
                this.getMenuElem(46).setTextE(CFG.lang.get("SaveSpeed") + ", " + CFG.lang.get("Provinces") + ": " + CFG.lang.get("NoLimit"));
                break;
            }
            case 47: {
                CFG.settingsGD.SAVE_PROVINCES_SPEED = Integer.MAX_VALUE;
                this.getMenuElem(46).setTextE(CFG.lang.get("SaveSpeed") + ", " + CFG.lang.get("Provinces") + ": " + CFG.lang.get("NoLimit"));
                break;
            }
            case 48: {
                CFG.settingsGD.SAVE_CIVS_SPEED = Integer.MAX_VALUE;
                this.getMenuElem(49).setTextE(CFG.lang.get("SaveSpeed") + ", " + CFG.lang.get("Civilizations") + ": " + CFG.lang.get("NoLimit"));
                break;
            }
            case 50: {
                CFG.settingsGD.SAVE_CIVS_SPEED = Integer.MAX_VALUE;
                this.getMenuElem(49).setTextE(CFG.lang.get("SaveSpeed") + ", " + CFG.lang.get("Civilizations") + ": " + CFG.lang.get("NoLimit"));
                break;
            }
            case 51: {
                CFG.settingsGD.LOAD_PROVINCES_SPEED = Integer.MAX_VALUE;
                this.getMenuElem(52).setTextE(CFG.lang.get("LoadSpeed") + ", " + CFG.lang.get("Provinces") + ": " + CFG.lang.get("NoLimit"));
                break;
            }
            case 53: {
                CFG.settingsGD.LOAD_PROVINCES_SPEED = Integer.MAX_VALUE;
                this.getMenuElem(52).setTextE(CFG.lang.get("LoadSpeed") + ", " + CFG.lang.get("Provinces") + ": " + CFG.lang.get("NoLimit"));
                break;
            }
            case 54: {
                CFG.settingsGD.LOAD_CIVS_SPEED = Integer.MAX_VALUE;
                this.getMenuElem(55).setTextE(CFG.lang.get("LoadSpeed") + ", " + CFG.lang.get("Civilizations") + ": " + CFG.lang.get("NoLimit"));
                break;
            }
            case 56: {
                CFG.settingsGD.LOAD_CIVS_SPEED = Integer.MAX_VALUE;
                this.getMenuElem(55).setTextE(CFG.lang.get("LoadSpeed") + ", " + CFG.lang.get("Civilizations") + ": " + CFG.lang.get("NoLimit"));
                break;
            }
            case 57: {
                CFG.settingsGD.USE_OLD_PROVINCE_BORDER = !CFG.settingsGD.USE_OLD_PROVINCE_BORDER;
                this.getMenuElem(58).setTextE(CFG.lang.get("UseOldProvinceBorders") + ": " + (CFG.settingsGD.USE_OLD_PROVINCE_BORDER ? CFG.lang.get("On") : CFG.lang.get("Off")));
                CFG.toastM.addM(CFG.lang.get("GameNeedsToBeRestartedToApplyTheChanges"));
                CFG.toastM.setTimeInView(4500);
                break;
            }
            case 59: {
                CFG.settingsGD.USE_OLD_PROVINCE_BORDER = !CFG.settingsGD.USE_OLD_PROVINCE_BORDER;
                this.getMenuElem(58).setTextE(CFG.lang.get("UseOldProvinceBorders") + ": " + (CFG.settingsGD.USE_OLD_PROVINCE_BORDER ? CFG.lang.get("On") : CFG.lang.get("Off")));
                CFG.toastM.addM(CFG.lang.get("GameNeedsToBeRestartedToApplyTheChanges"));
                CFG.toastM.setTimeInView(4500);
                break;
            }
            case 60: {
                if (CFG.settingsGD.MENU_EXTRA_LEFT > 0) {
                    --CFG.settingsGD.MENU_EXTRA_LEFT;
                    --AoCGame.LEFT;
                }
                this.getMenuElem(61).setTextE(CFG.lang.get("Menu") + " Extra Left Position: " + CFG.settingsGD.MENU_EXTRA_LEFT + "px");
                break;
            }
            case 62: {
                ++CFG.settingsGD.MENU_EXTRA_LEFT;
                this.getMenuElem(61).setTextE(CFG.lang.get("Menu") + " Extra Left Position: " + CFG.settingsGD.MENU_EXTRA_LEFT + "px");
                ++AoCGame.LEFT;
                break;
            }
            case 63: 
            case 65: {
                CFG.settingsGD.DRAW_WAR_ON_MAP = !CFG.settingsGD.DRAW_WAR_ON_MAP;
                this.getMenuElem(64).setTextE(CFG.lang.get("Map") + ": " + CFG.lang.get("DeclareWar") + " - " + CFG.lang.get("GameAnimation") + ": " + (CFG.settingsGD.DRAW_WAR_ON_MAP ? CFG.lang.get("On") : CFG.lang.get("Off")));
                break;
            }
            case 66: {
                CFG.settingsGD.BORDER_EXTRA_THICKNESS -= 0.5f;
                CFG.settingsGD.BORDER_EXTRA_THICKNESS = Math.max(0.0f, CFG.settingsGD.BORDER_EXTRA_THICKNESS);
                this.getMenuElem(67).setTextE(CFG.lang.get("ProvinceBorderThickness") + ": " + CFG.getPrecision2(CFG.settingsGD.BORDER_EXTRA_THICKNESS, 100) + "px");
                break;
            }
            case 68: {
                CFG.settingsGD.BORDER_EXTRA_THICKNESS += 0.5f;
                this.getMenuElem(67).setTextE(CFG.lang.get("ProvinceBorderThickness") + ": " + CFG.getPrecision2(CFG.settingsGD.BORDER_EXTRA_THICKNESS, 100) + "px");
                break;
            }
            case 69: {
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.COLOR_PROVINCE_STRAIGHT.r, CFG.COLOR_PROVINCE_STRAIGHT.g, CFG.COLOR_PROVINCE_STRAIGHT.b);
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.PB_STRA);
                break;
            }
            case 70: {
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.COLOR_PROVINCE_DASHED.r, CFG.COLOR_PROVINCE_DASHED.g, CFG.COLOR_PROVINCE_DASHED.b);
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.PB_DASH);
                break;
            }
            case 71: {
                CFG.settingsGD.BETTER_UI = !CFG.settingsGD.BETTER_UI;
                CFG.menus.setMenuID(View.eSETTINGS);
                return;
            }
            case 72: {
                CFG.settingsGD.UI_THEME++;
                if (CFG.settingsGD.UI_THEME > 2) CFG.settingsGD.UI_THEME = 0;
                this.updateLang();
                break;
            }
            case 73: {
                if (CFG.settingsGD.ARMY_VISIBILITY_RANGE > 0) {
                    CFG.settingsGD.ARMY_VISIBILITY_RANGE--;
                }
                String[] visNames = new String[]{CFG.lang.get("Close"), CFG.lang.get("Medium"), CFG.lang.get("Far"), CFG.lang.get("VeryFar"), CFG.lang.get("VeryFar+")};
                this.getMenuElem(74).setTextE(CFG.lang.get("ArmyVisibility") + ": " + visNames[CFG.settingsGD.ARMY_VISIBILITY_RANGE]);
                CFG.core.buildDrawArmy();
                break;
            }
            case 75: {
                if (CFG.settingsGD.ARMY_VISIBILITY_RANGE < 4) {
                    CFG.settingsGD.ARMY_VISIBILITY_RANGE++;
                }
                String[] visNames = new String[]{CFG.lang.get("Close"), CFG.lang.get("Medium"), CFG.lang.get("Far"), CFG.lang.get("VeryFar"), CFG.lang.get("VeryFar+")};
                this.getMenuElem(74).setTextE(CFG.lang.get("ArmyVisibility") + ": " + visNames[CFG.settingsGD.ARMY_VISIBILITY_RANGE]);
                CFG.core.buildDrawArmy();
                break;
            }
            case 76: {
                if (CFG.settingsGD.ARMY_ICON_SCALE > 0) {
                    CFG.settingsGD.ARMY_ICON_SCALE--;
                }
                String[] iconNames = new String[]{"0.25x", "0.5x", "0.75x", CFG.lang.get("Default")};
                this.getMenuElem(77).setTextE(CFG.lang.get("ArmyIconSize") + ": " + iconNames[CFG.settingsGD.ARMY_ICON_SCALE]);
                CFG.core.buildDrawArmy();
                break;
            }
            case 78: {
                if (CFG.settingsGD.ARMY_ICON_SCALE < 3) {
                    CFG.settingsGD.ARMY_ICON_SCALE++;
                }
                String[] iconNames = new String[]{"0.25x", "0.5x", "0.75x", CFG.lang.get("Default")};
                this.getMenuElem(77).setTextE(CFG.lang.get("ArmyIconSize") + ": " + iconNames[CFG.settingsGD.ARMY_ICON_SCALE]);
                CFG.core.buildDrawArmy();
                break;
            }
            case 79: {
                CFG.settingsGD.ANNEXATION_DELAY = !CFG.settingsGD.ANNEXATION_DELAY;
                this.getMenuElem(79).setTextE("Annexation Delay: " + (CFG.settingsGD.ANNEXATION_DELAY ? CFG.lang.get("On") : CFG.lang.get("Off")));
                break;
            }
            case 80: {
                CFG.settingsGD.ANNEXATION_DELAY_TURNS--;
                if (CFG.settingsGD.ANNEXATION_DELAY_TURNS < 1) CFG.settingsGD.ANNEXATION_DELAY_TURNS = 1;
                this.getMenuElem(81).setTextE("Annexation Delay Turns: " + CFG.settingsGD.ANNEXATION_DELAY_TURNS);
                break;
            }
            case 82: {
                CFG.settingsGD.ANNEXATION_DELAY_TURNS++;
                this.getMenuElem(81).setTextE("Annexation Delay Turns: " + CFG.settingsGD.ANNEXATION_DELAY_TURNS);
                break;
            }
            case 83: {
                CFG.settingsGD.DISABLE_INFLATION = !CFG.settingsGD.DISABLE_INFLATION;
                this.getMenuElem(83).setTextE("Disable Inflation: " + (CFG.settingsGD.DISABLE_INFLATION ? CFG.lang.get("On") : CFG.lang.get("Off")));
                break;
            }
            case 84: {
                CFG.settingsGD.DISABLE_AI_INVESTING = !CFG.settingsGD.DISABLE_AI_INVESTING;
                this.getMenuElem(84).setTextE("Disable AI Investing: " + (CFG.settingsGD.DISABLE_AI_INVESTING ? CFG.lang.get("On") : CFG.lang.get("Off")));
                break;
            }
            case 85: {
                CFG.settingsGD.AIR_DEFENCE_SYSTEMS = !CFG.settingsGD.AIR_DEFENCE_SYSTEMS;
                this.getMenuElem(85).setTextE("Air Defence Systems: " + (CFG.settingsGD.AIR_DEFENCE_SYSTEMS ? CFG.lang.get("On") : CFG.lang.get("Off")));
                break;
            }
            case 86: {
                CFG.settingsGD.MISSILES = !CFG.settingsGD.MISSILES;
                this.getMenuElem(86).setTextE("Missiles: " + (CFG.settingsGD.MISSILES ? CFG.lang.get("On") : CFG.lang.get("Off")));
                break;
            }
            case 87: {
                CFG.menus.setMenuID(View.eSETTINGS_GAMEVALUES);
                break;
            }
            case 88: {
                if (CFG.settingsGD.EXPERIMENTAL_BATTLE_SYSTEM) {
                    CFG.setDialogType(DialogType.DISABLE_EXPERIMENTAL_BATTLE);
                } else {
                    CFG.settingsGD.EXPERIMENTAL_BATTLE_SYSTEM = true;
                    CFG.settingsGD.BAT_PLUS = true;
                    this.updateLang();
                }
                break;
            }
            case 89: {
                if (CFG.settingsGD.BAT_PLUS) {
                    CFG.setDialogType(DialogType.DISABLE_BAT_PLUS);
                } else {
                    CFG.settingsGD.BAT_PLUS = true;
                    CFG.settingsGD.EXPERIMENTAL_BATTLE_SYSTEM = true;
                    this.updateLang();
                }
                break;
            }
            case 90: {
                CFG.settingsGD.AI_GROUP_UNITS = !CFG.settingsGD.AI_GROUP_UNITS;
                this.getMenuElem(90).setTextE("AI: Group Units: " + (CFG.settingsGD.AI_GROUP_UNITS ? CFG.lang.get("On") : CFG.lang.get("Off")));
                break;
            }
            case 91: {
                float newVal = CFG.settingsGD.BAT_PLUS_BREAKTHROUGH_RATIO - 0.5f;
                CFG.settingsGD.BAT_PLUS_BREAKTHROUGH_RATIO = Math.max(2.5f, newVal);
                this.getMenuElem(92).setTextE("Bat+ Breakthrough: " + CFG.getPrecision2(CFG.settingsGD.BAT_PLUS_BREAKTHROUGH_RATIO, 2) + "x");
                break;
            }
            case 92: {
                CFG.keybMess = "" + CFG.settingsGD.BAT_PLUS_BREAKTHROUGH_RATIO;
                Keyboard.colorPickerMode = false;
                Keyboard.commandsMode = false;
                Keyboard.mapModeSearch = false;
                Keyboard.rankSearch = false;
                Keyboard.numbers = true;
                CFG.keyboardSave = new CFG.Keyboard_Action(){
                    @Override
                    public void action() {
                        try {
                            float val = Float.parseFloat(CFG.keybMess.replace(',', '.'));
                            CFG.settingsGD.BAT_PLUS_BREAKTHROUGH_RATIO = Math.max(2.5f, Math.min(50.0f, val));
                            Menu_Settings_Options.this.getMenuElem(92).setTextE("Bat+ Breakthrough: " + CFG.getPrecision2(CFG.settingsGD.BAT_PLUS_BREAKTHROUGH_RATIO, 2) + "x");
                            CFG.keybMess = "";
                        } catch (NumberFormatException e) {}
                    }
                };
                CFG.keyboardDelete = new CFG.Keyboard_Action(){
                    @Override
                    public void action() {
                        CFG.keybMess = CFG.keybMess.length() > 1 ? CFG.keybMess.substring(0, CFG.keybMess.length() - 1) : "";
                    }
                };
                CFG.keyboardWrite = new CFG.Keyboard_Action_Write(){
                    @Override
                    public void action(String nChar) {
                        char c = nChar.charAt(0);
                        if ((c >= '0' && c <= '9') || c == '.' || c == ',') {
                            if (c == ',') c = '.';
                            if (c == '.' && CFG.keybMess.contains(".")) return;
                            CFG.keybMess += c;
                        }
                    }
                };
                CFG.menus.setKeyboardActiveMenuElementID(CFG.menus.getActiveMenuElemeID());
                CFG.menus.getKeyboard().setVisibleM(true);
                break;
            }
            case 93: {
                float newVal = CFG.settingsGD.BAT_PLUS_BREAKTHROUGH_RATIO + 0.5f;
                CFG.settingsGD.BAT_PLUS_BREAKTHROUGH_RATIO = Math.min(50.0f, newVal);
                this.getMenuElem(92).setTextE("Bat+ Breakthrough: " + CFG.getPrecision2(CFG.settingsGD.BAT_PLUS_BREAKTHROUGH_RATIO, 2) + "x");
                break;
            }
            case 94: {
                this.updateBudgetSliderMax(-25);
                break;
            }
            case 96: {
                this.updateBudgetSliderMax(25);
                break;
            }
            case 97: {
                CFG.settingsGD.DYNAMIC_MIN_ARMY = !CFG.settingsGD.DYNAMIC_MIN_ARMY;
                this.getMenuElem(97).setTextE("Dynamic Minimum Army: " + (CFG.settingsGD.DYNAMIC_MIN_ARMY ? CFG.lang.get("On") : CFG.lang.get("Off")));
                break;
            }
        }
        CFG.saveSettings();
    }
}

