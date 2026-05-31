/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Graphics;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ConfigINI;
import java.util.ArrayList;

public class Menu_Graphics
extends Menu {
    public Menu_Graphics() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setMenuID(View.eSETTINGS_RESOLUTION);
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true, ConfigINI.fullscreen){

            @Override
            public boolean getCheckboxSt() {
                return ConfigINI.fullscreen;
            }

            @Override
            public void actionElem(int iID) {
                ConfigINI.fullscreen = !ConfigINI.fullscreen;
                ConfigINI.saveConfig();
                CFG.toastM.addM(CFG.lang.get("GameNeedsToBeRestartedToApplyTheChanges"));
                CFG.toastM.setTimeInView(4500);
            }
        });
        menuElements.add(new Button_Classic("-", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true){

            @Override
            public void actionElem(int iID) {
                if (--ConfigINI.iSamples <= 0) {
                    ConfigINI.iSamples = -1;
                }
                ConfigINI.saveConfig();
                Menu_Graphics.this.updateLang();
                CFG.toastM.addM(CFG.lang.get("GameNeedsToBeRestartedToApplyTheChanges"));
                CFG.toastM.setTimeInView(4500);
            }
        });
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2, tY, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2) * 2, CFG.BUTTON_H, true){

            @Override
            public void actionElem(int iID) {
                ConfigINI.iSamples = -1;
                ConfigINI.saveConfig();
                Menu_Graphics.this.updateLang();
                CFG.toastM.addM(CFG.lang.get("GameNeedsToBeRestartedToApplyTheChanges"));
                CFG.toastM.setTimeInView(4500);
            }
        });
        menuElements.add(new Button_Classic_ReflectedBG("+", -1, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.BUTTON_W / 2), tY, CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true){

            @Override
            public void actionElem(int iID) {
                ConfigINI.iSamples = ConfigINI.iSamples <= 0 ? 1 : ++ConfigINI.iSamples;
                ConfigINI.saveConfig();
                Menu_Graphics.this.updateLang();
                CFG.toastM.addM(CFG.lang.get("GameNeedsToBeRestartedToApplyTheChanges"));
                CFG.toastM.setTimeInView(4500);
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true, ConfigINI.vSync){

            @Override
            public boolean getCheckboxSt() {
                return ConfigINI.vSync;
            }

            @Override
            public void actionElem(int iID) {
                ConfigINI.vSync = !ConfigINI.vSync;
                ConfigINI.saveConfig();
                CFG.toastM.addM(CFG.lang.get("GameNeedsToBeRestartedToApplyTheChanges"));
                CFG.toastM.setTimeInView(4500);
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setMenuID(View.eSELECT_UI_SCALE);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        if (ConfigINI.iWidth <= 0 || ConfigINI.iHeight <= 0) {
            this.getMenuElem(0).setTextE(CFG.lang.get("Resolution") + ": " + CFG.GAMEWIDTH + "x" + CFG.GAMEHEIGHT);
        } else {
            this.getMenuElem(0).setTextE(CFG.lang.get("Resolution") + ": " + ConfigINI.iWidth + "x" + ConfigINI.iHeight);
        }
        this.getMenuElem(1).setTextE(CFG.lang.get("Fullscreen"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Antialliasng") + ": " + (ConfigINI.iSamples <= 0 ? CFG.lang.get("Disabled") : Integer.valueOf(ConfigINI.iSamples)));
        this.getMenuElem(5).setTextE(CFG.lang.get("VSync"));
        this.getMenuElem(6).setTextE(CFG.lang.get("UIScale"));
    }

    @Override
    public final void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }
}

