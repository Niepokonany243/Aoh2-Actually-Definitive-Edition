/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.CreateVassal;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slide;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_CreateAVassal
extends Menu {
    public Menu_InGame_CreateAVassal() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true){

            @Override
            public boolean getIsClickable() {
                try {
                    return CFG.createVassalData.sCivTag != null && CFG.createVassalData.iCapitalProvinceID >= 0 && CFG.core.getProvSelected().getProvSize() > 0;
                }
                catch (Exception ex) {
                    return false;
                }
            }

            @Override
            public int getTextWidthU() {
                return super.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH;
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (!this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                }
                try {
                    CFG.createVassalData.getFlagOfCiv().drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() - CFG.createVassalData.getFlagOfCiv().getHeight() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                }
                catch (NullPointerException ex) {
                    IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                }
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
                super.drawTextE(oSB, CFG.CIV_FLAG_WIDTH + CFG.PADD + iTranslateX, iTranslateY, isActive);
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD, CFG.PADD, CFG.BUTTON_W * 2, true, false){

            @Override
            public boolean getCheckboxSt() {
                return CFG.brushMode;
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.PADD, CFG.BUTTON_W, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.selectMode;
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W * 3 + CFG.PADD * 3, CFG.PADD, CFG.BUTTON_W, false){

            @Override
            public boolean getIsClickable() {
                return CFG.core.getProvSelected().getProvSize() > 0;
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W * 3 + CFG.PADD * 3, CFG.PADD, CFG.BUTTON_W, false){

            @Override
            public boolean getIsClickable() {
                return CFG.core.getProvSelected().getProvSize() > 0;
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.PADD, CFG.BUTTON_W, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.VIEW_SHOW_VALUES;
            }
        });
        menuElements.add(new Slide(CFG.GAMEWIDTH - CFG.PADD - IMGManager.getIMG(Images.slideBG).getHeight() * 2 - IMGManager.getIMG(Images.slideBG).getHeight() / 2, CFG.GAMEHEIGHT - CFG.PADD - IMGManager.getIMG(Images.slideBG).getHeight() / 2 - IMGManager.getIMG(Images.slideBG).getHeight() * 2, CFG.brushMode));
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.BUTTON_W, true){

            @Override
            public int getTextWidthU() {
                return super.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH;
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (!this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                }
                try {
                    CFG.createVassalData.getFlagOfCiv().drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() - CFG.createVassalData.getFlagOfCiv().getHeight() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                }
                catch (NullPointerException ex) {
                    IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                }
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
                super.drawTextE(oSB, CFG.CIV_FLAG_WIDTH + CFG.PADD + iTranslateX, iTranslateY, isActive);
            }

            @Override
            public Color getColorE(boolean isActive) {
                try {
                    if (CFG.createVassalData.iCapitalProvinceID == -1) {
                        return isActive ? CFG.COLOR_NEGATIVE_1 : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_NEGATIVE_1 : CFG.COLOR_NEGATIVE_2) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
                    }
                    return super.getColorE(isActive);
                }
                catch (NullPointerException ex) {
                    return super.getColorE(isActive);
                }
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.PADD * 2 + CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.BUTTON_W){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.75f));
                }
                IMGManager.getIMG(Images.wikipedia).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.wikipedia).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.wikipedia).getHeight() / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public boolean getIsClickable() {
                try {
                    return CFG.createVassalData.sCivTag != null;
                }
                catch (NullPointerException ex) {
                    return false;
                }
            }
        });
        menuElements.add(new Text(null, -1, 0, 0, IMGManager.getIMG(Images.topBar).getHeight(), (float)CFG.FONT_BOLD_SMALL){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawText(oSB, this.fontID, this.sText, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + (this.getHeightE() - this.getTextHeight()) / 2 + iTranslateY, this.getColor(isActive));
            }

            @Override
            public int getPosXE() {
                return 0;
            }

            @Override
            public int getWidthE() {
                return Math.max(CFG.BUTTON_W, this.getTextWidthU() + CFG.PADD * 2);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("ReleaseAVassal"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Brush"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Select"));
        this.getMenuElem(4).setTextE(CFG.lang.get("DeselectAll"));
        this.getMenuElem(5).setTextE(CFG.lang.get("Undo"));
        this.getMenuElem(6).setTextE(CFG.lang.get("Map"));
        this.getMenuElem(8).setTextE(CFG.lang.get("SetCapital"));
        this.getMenuElem(10).setTextE(CFG.lang.get("MapModes"));
        this.updateButtonWidth(5, CFG.PADD, CFG.BUTTON_W * 2);
        for (int i = 3; i < 7; ++i) {
            this.updateButtonWidth(i, CFG.PADD, CFG.BUTTON_W);
        }
        this.updateButtonWidth(0, CFG.PADD, CFG.BUTTON_W);
        this.updateButtonWidth(8, this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() + CFG.PADD, CFG.BUTTON_W);
        this.updateButtonWidth(1, this.getMenuElem(8).getPosXE() + this.getMenuElem(8).getWidthE() + CFG.PADD, CFG.BUTTON_W);
        this.updateButtonWidth(9, this.getMenuElem(1).getPosXE() + this.getMenuElem(1).getWidthE() + CFG.PADD, CFG.BUTTON_W);
        int tempX = CFG.GAMEWIDTH - this.getMenuElem(3).getWidthE() - CFG.PADD;
        this.getMenuElem(3).setPosX(tempX);
        tempX = tempX - this.getMenuElem(2).getWidthE() - CFG.PADD;
        this.getMenuElem(2).setPosX(tempX);
        tempX = tempX - this.getMenuElem(4).getWidthE() - CFG.PADD;
        this.getMenuElem(4).setPosX(tempX);
        tempX = tempX - this.getMenuElem(5).getWidthE() - CFG.PADD;
        this.getMenuElem(5).setPosX(tempX);
        tempX = tempX - this.getMenuElem(6).getWidthE() - CFG.PADD;
        this.getMenuElem(6).setPosX(tempX);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(10).getPosXE() + iTranslateX, this.getMenuElem(10).getPosY() + iTranslateY, this.getMenuElem(10).getWidthE() + CFG.topBox.topBarPaddingRight, IMGManager.getIMG(Images.topBar).getHeight(), true, false);
        CFG.drawEditorButtons_Top_Edge_R_Reflected(oSB, this.getMenuElem(6).getPosXE() - CFG.PADD + iTranslateX, this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH - (this.getMenuElem(6).getPosXE() - CFG.PADD), CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Bot_Edge_R(oSB, this.getMenuElem(0).getPosXE() - CFG.PADD + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(9).getPosXE() + this.getMenuElem(9).getWidthE() + CFG.PADD, this.getMenuElem(0).getHeightE() + CFG.PADD * 2);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.setDialogType(DialogType.RELEASE_A_VASSAL);
                return;
            }
            case 2: {
                CFG.brushMode = !CFG.brushMode;
                break;
            }
            case 3: {
                CFG.selectMode = !CFG.selectMode;
                break;
            }
            case 4: {
                CFG.setDialogType(DialogType.DESELET_ALL_SELECTED_PROVINCES_CREATE_A_VASSAL);
                break;
            }
            case 5: {
                CFG.core.getProvSelected().popProvince();
                if (CFG.core.getProvSelected().getProvSize() == 0) {
                    CFG.selectMode = true;
                }
                boolean resetCapital = true;
                for (int i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
                    if (CFG.createVassalData.iCapitalProvinceID != CFG.core.getProvSelected().getProv(i)) continue;
                    resetCapital = false;
                    break;
                }
                if (resetCapital) {
                    CFG.createVassalData.iCapitalProvinceID = -1;
                }
                CFG.updateCreateAVassalCivInfo();
                break;
            }
            case 6: {
                CFG.VIEW_SHOW_VALUES = !CFG.VIEW_SHOW_VALUES;
                CFG.map.getMpB().updateWorldMap_Shaders();
                break;
            }
            case 8: {
                if (CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProvSelected().canBeReleasedAsVassal(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getActiveProvID())) {
                    CFG.core.getProvSelected().addProv(CFG.core.getActiveProvID());
                    CFG.createVassalData.iCapitalProvinceID = CFG.core.getActiveProvID();
                    CFG.updateCreateAVassalCivInfo();
                    CFG.toastM.addM(CFG.lang.get("CapitalMoved"), CFG.COLOR_POSITIVE);
                    break;
                }
                CFG.toastM.addM(CFG.lang.get("ChooseAProvince"), CFG.COLOR_NEGATIVE_2);
                break;
            }
            case 9: {
                if (CFG.createVassalData.sCivTag == null) break;
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = CFG.createVassalData.sCivTag;
                CFG.setDialogType(DialogType.GO_TO_WIKI);
                break;
            }
            case 10: {
                CFG.menus.getInGame_CreateAVassal_MapModes().setVisibleM(!CFG.menus.getInGame_CreateAVassal_MapModes().getVisibleM());
                if (!CFG.menus.getInGame_CreateAVassal_MapModes().getVisibleM()) {
                    CFG.mapModesManager.disableAllViews();
                }
                if (CFG.menus.getInGame_CreateAVassal_MapModes().getPosX() >= 0) break;
                CFG.menus.getInGame_CreateAVassal_MapModes().setPosX_Force(CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2);
                CFG.menus.getInGame_CreateAVassal_MapModes().setPosY(CFG.menus.getInGame_CreateAVassal_MapModes().getTitleM().getHeightT() + CFG.BUTTON_W + CFG.PADD * 3);
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.brushMode = false;
        CFG.menus.setMenuID(View.eINGAME);
        RenderProvince.updateDrawProvinces();
        CFG.map.getMpB().updateWorldMap_Shaders();
        CFG.createVassalData.dispose();
        CFG.createVassalData = null;
        CFG.mapModesManager.setActiveMapModeID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE);
    }
}

