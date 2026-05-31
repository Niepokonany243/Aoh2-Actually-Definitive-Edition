/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ServiceRibbon;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Remove;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.ServiceRibbon_Overlay_GameData;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_ServiceRibbon_Editor_Edit
extends Menu {
    public Menu_ServiceRibbon_Editor_Edit() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, false){

            @Override
            public boolean getIsClickable() {
                return CFG.editorServiceRibbon_GameData.getSize() > 1;
            }
        });
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD * 3 + CFG.BUTTON_H, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_Classic("", 0, 0, CFG.PADD * 4 + CFG.BUTTON_H * 2, CFG.BUTTON_W, CFG.BUTTON_H, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.85f));
                }
                IMGManager.getIMG(Images.pickerIcon).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.pickerIcon).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.pickerIcon).getHeight() / 2 + Menu_ServiceRibbon_Editor_Edit.this.getMenuPosY() + iTranslateY);
                oSB.setColor(Color.WHITE);
            }
        });
        menuElements.add(new Button_Classic_Classic("", 0, CFG.BUTTON_W, CFG.PADD * 4 + CFG.BUTTON_H * 2, CFG.GAMEWIDTH - CFG.BUTTON_W, CFG.BUTTON_H, true));
        for (int i = 1; i < CFG.editorServiceRibbon_GameData.getSize(); ++i) {
            menuElements.add(new Button_Classic_Classic("", 0, 0, CFG.PADD * (i + 4) + CFG.BUTTON_H * (i + 2), CFG.BUTTON_W, CFG.BUTTON_H, true){

                @Override
                public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                    IMGManager.getIMG(Images.pickerIcon).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.pickerIcon).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.pickerIcon).getHeight() / 2 + Menu_ServiceRibbon_Editor_Edit.this.getMenuPosY() + iTranslateY);
                }
            });
            menuElements.add(new Button_Classic_Classic("", 0, CFG.BUTTON_W, CFG.PADD * (i + 4) + CFG.BUTTON_H * (i + 2), CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H, true));
            menuElements.add(new Button_Classic_Remove(CFG.GAMEWIDTH - CFG.BUTTON_W, CFG.PADD * (i + 4) + CFG.BUTTON_H * (i + 2), CFG.BUTTON_W, CFG.BUTTON_H, true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Delete"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
        }
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(2).setTextE(CFG.lang.get("AddNewOverlay"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.drawEditorTitle_EdgeR(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.serviceRibbonMgr.drawSR(oSB, CFG.GAMEWIDTH / 2 - CFG.SERVICE_RIBBON_WIDTH / 2 + iTranslateX, CFG.BUTTON_H / 2 + CFG.PADD - CFG.SERVICE_RIBBON_HEIGHT / 2, CFG.editorServiceRibbon_GameData, CFG.editorServiceRibbon_Colors, 1);
        CFG.serviceRibbonMgr.drawSROver(oSB, CFG.GAMEWIDTH / 2 - CFG.SERVICE_RIBBON_WIDTH / 2 + iTranslateX, CFG.BUTTON_H / 2 + CFG.PADD - CFG.SERVICE_RIBBON_HEIGHT / 2, 1);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.serviceRibbonMgr.drawSROverlay(oSB, CFG.GAMEWIDTH / 2 - CFG.SERVICE_RIBBON_WIDTH + iTranslateX, this.getMenuElem(4).getPosY() + this.getMenuElem(4).getHeightE() / 2 - CFG.SERVICE_RIBBON_HEIGHT, CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(0), CFG.editorServiceRibbon_Colors.get(0), 2);
        for (int i = 1; i < CFG.editorServiceRibbon_GameData.getSize(); ++i) {
            CFG.serviceRibbonMgr.drawSROverlay(oSB, CFG.GAMEWIDTH / 2 - CFG.SERVICE_RIBBON_WIDTH + iTranslateX, this.getMenuElem(4).getPosY() + this.getMenuElem(4).getHeightE() / 2 + CFG.BUTTON_H * i + CFG.PADD * i - CFG.SERVICE_RIBBON_HEIGHT, CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(0), CFG.editorServiceRibbon_Colors.get(0), 2);
            CFG.serviceRibbonMgr.drawSROverlay(oSB, CFG.GAMEWIDTH / 2 - CFG.SERVICE_RIBBON_WIDTH + iTranslateX, this.getMenuElem(4).getPosY() + this.getMenuElem(4).getHeightE() / 2 + CFG.BUTTON_H * i + CFG.PADD * i - CFG.SERVICE_RIBBON_HEIGHT, CFG.editorServiceRibbon_GameData.getServiceRibbon_Overlay(i), CFG.editorServiceRibbon_Colors.get(i), 2);
        }
        oSB.setColor(Color.WHITE);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.serviceRibbonMgr.saveData();
                CFG.serviceRibbonMgr.loadSR();
                this.onBackPressed();
                return;
            }
            case 2: {
                CFG.menus.getColorPicker().setVisible(false, null);
                CFG.editorServiceRibbon_GameData.addServiceRibbonOverlay(new ServiceRibbon_Overlay_GameData(0, 1, true));
                CFG.editorServiceRibbon_Colors_Add();
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = CFG.editorServiceRibbon_GameData.getSize() - 1;
                CFG.menus.setMenuID(View.eGAME_EDITOR_SERVICE_RIBBON_EDIT_OVERLAY);
                return;
            }
            case 3: {
                if (CFG.menus.getColorPicker().getVisible()) {
                    if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID == 0) {
                        CFG.menus.getColorPicker().setVisible(false, null);
                    } else {
                        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = 0;
                        CFG.menus.getColorPicker().setActiveRGBColor(CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).r, CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).g, CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).b);
                    }
                } else {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = 0;
                    CFG.menus.getColorPicker().setActiveRGBColor(CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).r, CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).g, CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).b);
                    CFG.menus.getColorPicker().setPosX(CFG.BUTTON_W + CFG.PADD * 3);
                    CFG.menus.getColorPicker().setPosY(CFG.BUTTON_H * 2 + CFG.PADD * 7);
                    CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.EDITOR_SERVICE_RIBBON_OVERLAY);
                }
                return;
            }
            case 4: {
                return;
            }
        }
        if (iID % 3 == 1) {
            CFG.menus.getColorPicker().setVisible(false, null);
            CFG.editorServiceRibbon_GameData.removeServiceRibbon_Overlay((iID - 5) / 3 + 1);
            CFG.menus.setMenuID(View.eGAME_EDITOR_SERVICE_RIBBON_EDIT);
        } else if (iID % 3 == 2) {
            if (CFG.menus.getColorPicker().getVisible()) {
                if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID == (iID - 5) / 3 + 1) {
                    CFG.menus.getColorPicker().setVisible(false, null);
                } else {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = (iID - 5) / 3 + 1;
                    CFG.menus.getColorPicker().setActiveRGBColor(CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).r, CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).g, CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).b);
                }
            } else {
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = (iID - 5) / 3 + 1;
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).r, CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).g, CFG.editorServiceRibbon_Colors.get((int)CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).b);
                CFG.menus.getColorPicker().setPosX(CFG.BUTTON_W + CFG.PADD * 3);
                CFG.menus.getColorPicker().setPosY(CFG.BUTTON_H * 2 + CFG.PADD * 7);
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.EDITOR_SERVICE_RIBBON_OVERLAY);
            }
        } else {
            CFG.menus.getColorPicker().setVisible(false, null);
            CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = (iID - 5) / 3 + 1;
            CFG.menus.setMenuID(View.eGAME_EDITOR_SERVICE_RIBBON_EDIT_OVERLAY);
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.getColorPicker().setVisible(false, null);
        CFG.menus.setMenuID(View.eGAME_EDITOR_SERVICE_RIBBON);
        CFG.menus.setBackAnimation(true);
    }
}

