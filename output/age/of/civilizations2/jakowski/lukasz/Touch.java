/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.TouchManager;

public class Touch {
    private static int mousePosX = 0;
    private static int mousePosY = 0;
    public static boolean sAMD = false;

    public static final void setMousePosXY(int nMousePosX, int nMousePosY) {
        if (CFG.menus.isSomethingHovered()) {
            CFG.setRenderO(true);
        }
        mousePosX = nMousePosX;
        mousePosY = nMousePosY;
    }

    public static final int getMousePosX() {
        return mousePosX;
    }

    public static final int getMousePosY() {
        return mousePosY;
    }

    public final void actionDown(int nPosX, int nPosY, int nPointer, int button) {
        if (nPointer == 0) {
            CFG.menus.resetMobileHover();
            if (!CFG.menus.actionDown(nPosX, nPosY)) {
                if (sAMD) {
                    CFG.map.getTouchMgr().iSBXX = nPosX;
                    CFG.map.getTouchMgr().iSBXY = nPosY;
                    CFG.map.getTouchMgr().iSBXW = 1;
                    CFG.map.getTouchMgr().iSBXH = 1;
                    CFG.map.getTouchMgr();
                    TouchManager.bSMD = true;
                    CFG.brushMode = false;
                    sAMD = false;
                } else {
                    CFG.map.getTouchMgr().actionDown(nPosX, nPosY, nPointer, button);
                }
            }
        }
    }

    public final void actionMove(int nPosX, int nPosY, int nPosX2, int nPosY2) {
        CFG.map.getTouchMgr().actionMove(nPosX, nPosY, nPosX2, nPosY2);
    }

    public final void actionMove(int nPosX, int nPosY, int nPointer) {
        if (nPointer == 0 && !CFG.map.getMpS().getScaleMode() && !CFG.menus.actionMove(nPosX, nPosY)) {
            CFG.map.getTouchMgr().actionMove(nPosX, nPosY);
        }
    }

    public final void actionUp(int nPosX, int nPosY, int nPointer, int button) {
        if (nPointer == 0) {
            if (!CFG.menus.actionUp(nPosX, nPosY, nPointer, button)) {
                CFG.map.getTouchMgr().actionUp(nPosX, nPosY, nPointer, button);
            }
            Touch.resetAllModes();
        } else if (CFG.map.getMpS().getScaleMode()) {
            Touch.resetAllModes();
        }
    }

    public final void actionMove_Hover(int nPosX, int nPosY) {
        if (CFG.menus.getFromViewID() < 0) {
            CFG.menus.actionMove_Hover(nPosX, nPosY);
            CFG.menus.updateHoveredMenuElement_Hover(nPosX, nPosY);
            CFG.menus.updateHoveredProvince_Hover(nPosX, nPosY);
            if (CFG.menus.get_MenuElementHover_IsInView()) {
                CFG.setRenderO(true);
            }
        }
    }

    public static final void resetAllModes() {
        CFG.menus.setActiveMenuID(-1);
        CFG.menus.setActiveMenuElemeID(-1);
        CFG.menus.setSliderMenuMode(false);
        CFG.menus.setSliderMenuTitleMode(false);
        CFG.menus.setSliderMenuResizeMode(false);
        CFG.menus.setSliderMode(false);
        CFG.menus.setSlideMapMode(false);
        CFG.menus.setTextSliderMode(false);
        CFG.menus.setSliderMenuCloseMode(false);
        CFG.menus.setKeyboardMode(false);
        CFG.menus.setFlagEditorMode(false);
        CFG.menus.setGraphMode(false);
        CFG.menus.setGraphButtonMode(false);
        CFG.menus.setGraphButtonModeX(false);
        CFG.menus.setGraphButtonMode2(false);
        CFG.menus.setColorPickerMode(false);
        CFG.map.getTouchMgr().setActionMap(false);
        CFG.map.getMpS().resetScaleInfo();
        CFG.map.getMpSl().resetScrollInfo();
    }
}

