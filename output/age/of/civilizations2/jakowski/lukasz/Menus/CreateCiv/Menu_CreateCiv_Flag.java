/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.CreateCiv;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Left;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Middle;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Right;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateCiv_Flag
extends Menu {
    public Menu_CreateCiv_Flag() {
        int i;
        int tempW = CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH * 3 / 4;
        int tempH = 100 + CFG.PADD * 4;
        int tPosY = CFG.PADD;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_NewGameStyle(null, -1, CFG.PADD, tPosY, tempW - CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        menuElements.add(new Button_NewGameStyle(null, -1, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, true));
        menuElements.add(new Button_NewGameStyle_Middle("", 0, CFG.PADD + CFG.BUTTON_H, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2 - CFG.BUTTON_H * 2, Math.max(100 + CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f)), true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                oSB.setColor(new Color(CFG.flagManager.flagEdit.lDivisionColors.get(0).getR(), CFG.flagManager.flagEdit.lDivisionColors.get(0).getG(), CFG.flagManager.flagEdit.lDivisionColors.get(0).getB(), 1.0f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - 77 - CFG.PADD - 1 + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, (this.getHeightE() - CFG.PADD * 2) / 2, false, true);
                IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - 77 - CFG.PADD - 1 + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + (this.getHeightE() - CFG.PADD * 2) / 2 + iTranslateY, 1, (this.getHeightE() - CFG.PADD * 2) / 2);
                oSB.setColor(Color.WHITE);
                CFG.flagManager.drawDivision_FlagFrameSize(oSB, this.getPosXE() + this.getWidthE() / 2 - 77 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - 50 + iTranslateY);
            }
        });
        menuElements.add(new Button_NewGameStyle_Left("<<", -1, CFG.PADD, tPosY, CFG.BUTTON_H, Math.max(100 + CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f)), true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Previous"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_NewGameStyle_Right(">>", -1, tempW - CFG.PADD - CFG.BUTTON_H, tPosY, CFG.BUTTON_H, Math.max(100 + CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f)), true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Next"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        for (i = 1; i < CFG.flagManager.lDivisions.get((int)CFG.flagManager.flagEdit.iDivisionID).iLayers; ++i) {
            menuElements.add(new Button_NewGameStyle("", -1, CFG.PADD, tPosY, tempW - CFG.PADD * 2, Math.max(100 + CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f)), true){
                int iCurrent;

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    oSB.setColor(new Color(CFG.flagManager.flagEdit.lDivisionColors.get(this.iCurrent).getR(), CFG.flagManager.flagEdit.lDivisionColors.get(this.iCurrent).getG(), CFG.flagManager.flagEdit.lDivisionColors.get(this.iCurrent).getB(), 1.0f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - 77 - CFG.PADD - 1 + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, (this.getHeightE() - CFG.PADD * 2) / 2, false, true);
                    IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - 77 - CFG.PADD - 1 + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + (this.getHeightE() - CFG.PADD * 2) / 2 + iTranslateY, 1, (this.getHeightE() - CFG.PADD * 2) / 2);
                    oSB.setColor(Color.WHITE);
                    CFG.flagManager.drawDivision_FlagFrameSize(oSB, this.getPosXE() + this.getWidthE() / 2 - 77 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - 50 + iTranslateY, this.iCurrent);
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.iCurrent = nCurrent;
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PickColor"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
        }
        for (i = 0; i < CFG.flagManager.flagEdit.lOverlays.size(); ++i) {
            menuElements.add(new Button_NewGameStyle_Left("", 0, CFG.PADD, tPosY, CFG.BUTTON_H, Math.max(100 + CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f)), true){

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (isActive || this.getIsHovered()) {
                        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.65f));
                    }
                    IMGManager.getIMG(Images.pickerIcon).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnUp).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.pickerIcon).getHeight() - IMGManager.getIMG(Images.btnUp).getWidth() / 2 + iTranslateY, IMGManager.getIMG(Images.btnUp).getWidth(), IMGManager.getIMG(Images.btnUp).getWidth());
                    oSB.setColor(Color.WHITE);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PickColor"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new Button_NewGameStyle_Middle("", 0, CFG.PADD + CFG.BUTTON_H, tPosY, tempW - CFG.PADD * 2 - CFG.BUTTON_H * 3, Math.max(100 + CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f)), true){
                private int iCurrent;

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    CFG.flagManager.drawDivision_FlagFrameSize(oSB, this.getPosXE() + this.getWidthE() / 2 - 77 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - 50 + iTranslateY);
                    CFG.flagManager.drawOverlay_FlagFrameSize(oSB, this.getPosXE() + this.getWidthE() / 2 - 77 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - 50 + iTranslateY, this.iCurrent);
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.iCurrent = nCurrent;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
            menuElements.add(new Button_NewGameStyle_Middle("", 0, tempW - CFG.PADD - CFG.BUTTON_H * 2, tPosY, CFG.BUTTON_H, Math.max(100 + CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f)), true){

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (isActive || this.getIsHovered()) {
                        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.65f));
                    }
                    IMGManager.getIMG(Images.btnUp).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnUp).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnUp).getHeight() / 2 + iTranslateY);
                    oSB.setColor(Color.WHITE);
                }
            });
            menuElements.add(new Button_NewGameStyle_Right("", 0, tempW - CFG.PADD - CFG.BUTTON_H, tPosY, CFG.BUTTON_H, Math.max(100 + CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f)), true){

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (isActive || this.getIsHovered()) {
                        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.65f));
                    }
                    IMGManager.getIMG(Images.btnRemove).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnRemove).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnRemove).getHeight() / 2 + iTranslateY);
                    oSB.setColor(Color.WHITE);
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Remove"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        this.initMenu(null, 0 + AoCGame.LEFT, CFG.BUTTON_H / 2 + (100 + CFG.PADD * 4), tempW, Math.min(tPosY + CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H / 2 + (100 + CFG.PADD * 4) + CFG.PADD)), menuElements);
        this.setVisibleM(false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("AddNewOverlay"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight(), this.getWidthM() + 2, this.getHeightM(), true, false);
        oSB.setColor(new Color(0.011f, 0.014f, 0.019f, 0.25f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthM() * 3 / 4, this.getHeightM(), false, true);
        oSB.setColor(Color.WHITE);
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - IMGManager.getIMG(Images.pix255).getHeight(), this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthM(), 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public final void actionEL(int iID) {
        if (iID > 4 && iID <= 4 + CFG.flagManager.lDivisions.get((int)CFG.flagManager.flagEdit.iDivisionID).iLayers - 1) {
            if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID == iID - 5 + 1 && CFG.menus.getColorPicker().getVisible()) {
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = -1;
                CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID = -1;
                CFG.menus.getColorPicker().setVisible(false, null);
            } else {
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = iID - 5 + 1;
                CFG.menus.getColorPicker().setActiveRGBColor(CFG.flagManager.flagEdit.lDivisionColors.get(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getR(), CFG.flagManager.flagEdit.lDivisionColors.get(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getG(), CFG.flagManager.flagEdit.lDivisionColors.get(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getB());
                CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.EDITOR_CIV_FLAG_DIVISION_COLOR);
            }
        } else if (iID > 4 + CFG.flagManager.lDivisions.get((int)CFG.flagManager.flagEdit.iDivisionID).iLayers - 1) {
            if ((iID - 5 - CFG.flagManager.lDivisions.get((int)CFG.flagManager.flagEdit.iDivisionID).iLayers + 1) % 4 == 0) {
                if (CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID == (iID - 5 - CFG.flagManager.lDivisions.get((int)CFG.flagManager.flagEdit.iDivisionID).iLayers + 1) / 4 && CFG.menus.getColorPicker().getVisible()) {
                    CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID = -1;
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = -1;
                    CFG.menus.getColorPicker().setVisible(false, null);
                } else {
                    CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID = (iID - 5 - CFG.flagManager.lDivisions.get((int)CFG.flagManager.flagEdit.iDivisionID).iLayers + 1) / 4;
                    CFG.menus.getColorPicker().setActiveRGBColor(CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).oColor.getR(), CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).oColor.getG(), CFG.flagManager.flagEdit.lOverlays.get((int)CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).oColor.getB());
                    CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.EDITOR_CIV_FLAG_OVERLAY_COLOR);
                }
            } else if ((iID - 5 - CFG.flagManager.lDivisions.get((int)CFG.flagManager.flagEdit.iDivisionID).iLayers + 1) % 4 == 1) {
                CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID = (iID - 5 - CFG.flagManager.lDivisions.get((int)CFG.flagManager.flagEdit.iDivisionID).iLayers + 1) / 4;
                CFG.menus.getColorPicker().setVisible(false, null);
                CFG.menus.setVisibleCreateCiv_Overlay(true);
                CFG.menus.setVisibleCreateCiv_Flag(false);
            } else if ((iID - 5 - CFG.flagManager.lDivisions.get((int)CFG.flagManager.flagEdit.iDivisionID).iLayers + 1) % 4 == 2) {
                CFG.flagManager.moveOverlayUp((iID - 5 - CFG.flagManager.lDivisions.get((int)CFG.flagManager.flagEdit.iDivisionID).iLayers + 1) / 4);
                CFG.menus.rebuildCreateCiv_Flag();
                CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID = -1;
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = -1;
                CFG.menus.getColorPicker().setVisible(false, null);
            } else if ((iID - 5 - CFG.flagManager.lDivisions.get((int)CFG.flagManager.flagEdit.iDivisionID).iLayers + 1) % 4 == 3) {
                CFG.flagManager.removeOverlay((iID - 5 - CFG.flagManager.lDivisions.get((int)CFG.flagManager.flagEdit.iDivisionID).iLayers + 1) / 4);
                CFG.menus.rebuildCreateCiv_Flag();
                CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID = -1;
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = -1;
                CFG.menus.getColorPicker().setVisible(false, null);
            }
        }
        switch (iID) {
            case 0: {
                CFG.menus.setVisibleCreateCiv_Data(true);
                CFG.menus.setVisibleCreateCiv_Flag(false);
                CFG.menus.getColorPicker().setVisible(false, null);
                return;
            }
            case 1: {
                CFG.flagManager.addOverlay();
                CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID = CFG.flagManager.flagEdit.lOverlays.size() - 1;
                CFG.menus.setVisibleCreateCiv_Overlay(true);
                CFG.menus.setVisibleCreateCiv_Flag(false);
                return;
            }
            case 2: {
                if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID == 0 && CFG.menus.getColorPicker().getVisible()) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = -1;
                    CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID = -1;
                    CFG.menus.getColorPicker().setVisible(false, null);
                } else {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = 0;
                    CFG.menus.getColorPicker().setActiveRGBColor(CFG.flagManager.flagEdit.lDivisionColors.get(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getR(), CFG.flagManager.flagEdit.lDivisionColors.get(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getG(), CFG.flagManager.flagEdit.lDivisionColors.get(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getB());
                    CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.EDITOR_CIV_FLAG_DIVISION_COLOR);
                }
                CFG.toastM.addM("ID: [" + CFG.flagManager.flagEdit.iDivisionID + "/" + (CFG.flagManager.lDivisions.size() - 1) + "]", CFG.COLOR_HOVER_TITLE);
                return;
            }
            case 3: {
                CFG.flagManager.updateDivision(false);
                CFG.menus.rebuildCreateCiv_Flag();
                CFG.toastM.addM("ID: [" + CFG.flagManager.flagEdit.iDivisionID + "/" + (CFG.flagManager.lDivisions.size() - 1) + "]", CFG.COLOR_HOVER_TITLE);
                CFG.menus.getColorPicker().setVisible(false, null);
                return;
            }
            case 4: {
                CFG.flagManager.updateDivision(true);
                CFG.menus.rebuildCreateCiv_Flag();
                CFG.toastM.addM("ID: [" + CFG.flagManager.flagEdit.iDivisionID + "/" + (CFG.flagManager.lDivisions.size() - 1) + "]", CFG.COLOR_HOVER_TITLE);
                CFG.menus.getColorPicker().setVisible(false, null);
                return;
            }
        }
    }
}

