/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ServiceRibbon;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_ColorPicker;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_ServiceRibbon_Editor_Edit_Overlay
extends Menu {
    public Menu_ServiceRibbon_Editor_Edit_Overlay() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game_ColorPicker(CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Classic_Classic("-", -1, 0, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic("", -1, CFG.BUTTON_W * 2, CFG.BUTTON_H + CFG.PADD * 3, CFG.GAMEWIDTH - CFG.BUTTON_W * 4, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic("-", -1, 0, CFG.BUTTON_H * 2 + CFG.PADD * 4, CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic("", -1, CFG.BUTTON_W * 2, CFG.BUTTON_H * 2 + CFG.PADD * 4, CFG.GAMEWIDTH - CFG.BUTTON_W * 4, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * 2 + CFG.PADD * 4, CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic(null, -1, 0, CFG.BUTTON_H * 3 + CFG.PADD * 5, CFG.GAMEWIDTH, CFG.BUTTON_H, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getReflected();
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(1).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Position") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX());
        this.getMenuElem(6).setTextE(CFG.lang.get("Width") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth());
        this.getMenuElem(8).setTextE(CFG.lang.get("Reflected"));
        CFG.glyphLay.setText(CFG.fontMain.get(0), "" + CFG.SERVICE_RIBBON_WIDTH);
        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = (int)CFG.glyphLay.width;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_EdgeR(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.serviceRibbonMgr.drawSR(oSB, CFG.GAMEWIDTH / 2 - CFG.SERVICE_RIBBON_WIDTH * 2 - CFG.PADD + iTranslateX, CFG.BUTTON_H / 2 + CFG.PADD - CFG.SERVICE_RIBBON_HEIGHT, CFG.editorServiceRibbon_GameData, CFG.editorServiceRibbon_Colors, 2);
        CFG.serviceRibbonMgr.drawSR(oSB, CFG.GAMEWIDTH / 2 + CFG.PADD + iTranslateX, CFG.BUTTON_H / 2 + CFG.PADD - CFG.SERVICE_RIBBON_HEIGHT / 2, CFG.editorServiceRibbon_GameData, CFG.editorServiceRibbon_Colors, 1);
        CFG.serviceRibbonMgr.drawSROver(oSB, CFG.GAMEWIDTH / 2 + CFG.PADD + iTranslateX, CFG.BUTTON_H / 2 + CFG.PADD - CFG.SERVICE_RIBBON_HEIGHT / 2, 1);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.75f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, CFG.GAMEWIDTH / 2 + CFG.PADD + iTranslateX, CFG.BUTTON_H / 2 + CFG.PADD + CFG.SERVICE_RIBBON_HEIGHT / 2 + CFG.CIV_COLOR_W - IMGManager.getIMG(Images.line32Off1).getHeight(), CFG.SERVICE_RIBBON_WIDTH, 1);
        oSB.setColor(Color.WHITE);
        CFG.fontMain.get(0).getData().setScale(0.6f);
        CFG.drawTextDefault(oSB, "" + CFG.SERVICE_RIBBON_WIDTH, CFG.GAMEWIDTH / 2 + CFG.PADD + (int)(((float)CFG.SERVICE_RIBBON_WIDTH - (float)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID * 0.6f) / 2.0f) + iTranslateX, CFG.BUTTON_H / 2 + CFG.PADD + CFG.SERVICE_RIBBON_HEIGHT / 2 + CFG.CIV_COLOR_W + CFG.PADD, Color.WHITE);
        CFG.fontMain.get(0).getData().setScale(1.0f);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                if (CFG.menus.getColorPicker().getVisible()) {
                    CFG.menus.getColorPicker().setVisible(false, null);
                } else {
                    CFG.menus.getColorPicker().setActiveRGBColor(CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).r, CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).g, CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).b);
                    CFG.menus.getColorPicker().setPosX(CFG.PADD * 3);
                    CFG.menus.getColorPicker().setPosY(CFG.BUTTON_H * 4 + CFG.PADD * 9);
                    CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.EDITOR_SERVICE_RIBBON_OVERLAY);
                }
                return;
            }
            case 1: {
                this.onBackPressed();
                return;
            }
            case 2: {
                CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setPosX(CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX() - 1);
                if (CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX() < 0) {
                    CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setPosX(0);
                    this.getMenuElem(3).setTextE(CFG.lang.get("Position") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX());
                }
                this.getMenuElem(3).setTextE(CFG.lang.get("Position") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX());
                return;
            }
            case 3: {
                return;
            }
            case 4: {
                CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setPosX(CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX() + 1);
                if (CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getReflected()) {
                    if (CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX() + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth() > CFG.SERVICE_RIBBON_WIDTH / 2) {
                        if (CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX() >= CFG.SERVICE_RIBBON_WIDTH / 2) {
                            CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setPosX(CFG.SERVICE_RIBBON_WIDTH / 2 - 1);
                            CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setWidth(1);
                            this.getMenuElem(3).setTextE(CFG.lang.get("Position") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX());
                            this.getMenuElem(6).setTextE(CFG.lang.get("Width") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth());
                        } else {
                            CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setWidth(CFG.SERVICE_RIBBON_WIDTH / 2 - CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX());
                            this.getMenuElem(6).setTextE(CFG.lang.get("Width") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth());
                        }
                    }
                } else if (CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX() + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth() >= CFG.SERVICE_RIBBON_WIDTH) {
                    if (CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX() >= CFG.SERVICE_RIBBON_WIDTH - 1) {
                        CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setPosX(CFG.SERVICE_RIBBON_WIDTH - 1);
                        CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setWidth(1);
                        this.getMenuElem(3).setTextE(CFG.lang.get("Position") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX());
                        this.getMenuElem(6).setTextE(CFG.lang.get("Width") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth());
                    } else {
                        CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setWidth(CFG.SERVICE_RIBBON_WIDTH - CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX());
                        this.getMenuElem(6).setTextE(CFG.lang.get("Width") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth());
                    }
                }
                this.getMenuElem(3).setTextE(CFG.lang.get("Position") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX());
                return;
            }
            case 5: {
                CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setWidth(CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth() - 1);
                if (CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth() <= 0) {
                    CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setWidth(1);
                }
                this.getMenuElem(6).setTextE(CFG.lang.get("Width") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth());
                return;
            }
            case 7: {
                CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setWidth(CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth() + 1);
                if (CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getReflected()) {
                    if (CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX() + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth() >= CFG.SERVICE_RIBBON_WIDTH / 2) {
                        CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setWidth(CFG.SERVICE_RIBBON_WIDTH / 2 - CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX());
                    }
                } else if (CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX() + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth() >= CFG.SERVICE_RIBBON_WIDTH) {
                    CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setWidth(CFG.SERVICE_RIBBON_WIDTH - CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX());
                }
                this.getMenuElem(6).setTextE(CFG.lang.get("Width") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth());
                return;
            }
            case 8: {
                CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setReflected(!CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getReflected());
                if (CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getReflected() && CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX() + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth() > CFG.SERVICE_RIBBON_WIDTH / 2) {
                    if (CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX() > CFG.SERVICE_RIBBON_WIDTH / 2) {
                        CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setPosX(0);
                        if (CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth() > CFG.SERVICE_RIBBON_WIDTH / 2) {
                            CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setWidth(CFG.SERVICE_RIBBON_WIDTH / 2 - 1);
                            this.getMenuElem(6).setTextE(CFG.lang.get("Width") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth());
                        }
                    } else {
                        CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).setWidth(CFG.SERVICE_RIBBON_WIDTH / 2 - CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getPosX());
                        this.getMenuElem(6).setTextE(CFG.lang.get("Width") + ": " + CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getWidth());
                    }
                }
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.getColorPicker().setVisible(false, null);
        CFG.menus.setMenuID(View.eGAME_EDITOR_SERVICE_RIBBON_EDIT);
        CFG.menus.setBackAnimation(true);
    }
}

