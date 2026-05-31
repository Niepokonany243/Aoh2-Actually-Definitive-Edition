/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Editors;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Description;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Menu_InitGame;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Editor
extends Menu {
    public Menu_Editor() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.PADD, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.BUTTON_H * 2 + CFG.PADD * 3, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.BUTTON_H * 4 + CFG.PADD * 5, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.BUTTON_H * 3 + CFG.PADD * 4, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.BUTTON_H * 5 + CFG.PADD * 6, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.BUTTON_H * 6 + CFG.PADD * 7, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.BUTTON_H * 7 + CFG.PADD * 8, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true){

            @Override
            public boolean getIsClickable() {
                return CFG.getIsDesktop();
            }
        });
        menuElements.add(new Button_Classic_Description("Age of History 2: Definitive Edition", null, (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.BUTTON_H * 8 + CFG.PADD * 9, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SubmitYourModsToTheSteamWorkshop"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploLord, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public boolean getIsClickable() {
                return CFG.getIsDesktop();
            }
        });
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("CreateaScenario"));
        this.getMenuElem(2).setTextE(CFG.lang.get("CreateaCivilization"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Leaders"));
        this.getMenuElem(4).setTextE(CFG.lang.get("MapEditor"));
        this.getMenuElem(5).setTextE(CFG.lang.get("CreateaCity"));
        this.getMenuElem(6).setTextE(CFG.lang.get("GameEditor"));
        this.getMenuElem(7).setTextE(CFG.lang.get("www.LukaszJakowski.pl"));
        this.getMenuElem(8).setTextE(CFG.lang.get("ManageMods"));
        this.getMenuElem(9).setTextE(CFG.lang.get("SteamWorkshop"));
        this.getTitleM().setText(CFG.lang.get("GameEditor") + " - Age of History 2: Definitive Edition");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        try {
            if (Menu_InitGame.animatedSize > 0) {
                oSB.setColor(new Color(0.047058824f, 0.047058824f, 0.047058824f, 1.0f));
                Images.pix.draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                Menu_InitGame.animated.get(Menu_InitGame.animatedID).draw(oSB, iTranslateX + (CFG.GAMEWIDTH - Menu_InitGame.animatedWidth) / 2, iTranslateY + (CFG.GAMEHEIGHT - Menu_InitGame.animatedHeight) / 2, Menu_InitGame.animatedWidth, Menu_InitGame.animatedHeight);
                oSB.setColor(Color.WHITE);
                if (Menu_InitGame.animatedTime + Menu_InitGame.animatedFrame < CFG.currentTimeMillis) {
                    Menu_InitGame.animatedTime = CFG.currentTimeMillis;
                    if (++Menu_InitGame.animatedID >= Menu_InitGame.animatedSize) {
                        Menu_InitGame.animatedID = 0;
                    }
                }
            } else if (Menu_InitGame.background != null) {
                oSB.setColor(new Color(0.047058824f, 0.047058824f, 0.047058824f, 1.0f));
                Images.pix.draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                Menu_InitGame.background.draw(oSB, iTranslateX + (CFG.GAMEWIDTH - Menu_InitGame.backgroundWidth) / 2, iTranslateY + (CFG.GAMEHEIGHT - Menu_InitGame.backgroundHeight) / 2, Menu_InitGame.backgroundWidth, Menu_InitGame.backgroundHeight);
                oSB.setColor(Color.WHITE);
                if (CFG.currentTimeMillis > Menu_InitGame.bgTIME_CHANGE + (long)GameValues.gvUpdate.MAIN_MENU_BG_CHANGE_BG_EVERY_X_MS) {
                    Menu_InitGame.bgTIME_CHANGE = CFG.currentTimeMillis;
                    Core.addSimpleTask(new Core.SimpleTask("loadBackground"){

                        @Override
                        public void update() {
                            Menu_InitGame.loadBackground();
                            Menu_InitGame.bgTIME = System.currentTimeMillis();
                            Menu_InitGame.bgTIME_CHANGE = System.currentTimeMillis();
                            Menu_InitGame.bgAlpha = 0.0f;
                        }
                    });
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.map.getIcon(0).drawO(oSB, this.getMenuElem(1).getPosXE() + this.getMenuElem(1).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(1).getPosY() + this.getMenuElem(1).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + this.getMenuPosY() - CFG.map.getIcon(0).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        IMGManager.getIMG(Images.editorCiv).drawO(oSB, this.getMenuElem(2).getPosXE() + this.getMenuElem(2).getTextPosElem() / 2 - IMGManager.getIMG(Images.editorCiv).getWidth() / 2 + iTranslateX, this.getMenuElem(2).getPosY() + this.getMenuElem(2).getHeightE() / 2 + this.getMenuPosY() - IMGManager.getIMG(Images.editorCiv).getHeight() / 2 + iTranslateY);
        IMGManager.getIMG(Images.editorCity).drawO(oSB, this.getMenuElem(5).getPosXE() + this.getMenuElem(5).getTextPosElem() / 2 - IMGManager.getIMG(Images.editorCity).getWidth() / 2 + iTranslateX, this.getMenuElem(5).getPosY() + this.getMenuElem(5).getHeightE() / 2 + this.getMenuPosY() - IMGManager.getIMG(Images.editorCity).getHeight() / 2 + iTranslateY);
        IMGManager.getIMG(Images.editorMap).drawO(oSB, this.getMenuElem(4).getPosXE() + this.getMenuElem(4).getTextPosElem() / 2 - IMGManager.getIMG(Images.editorMap).getWidth() / 2 + iTranslateX, this.getMenuElem(4).getPosY() + this.getMenuElem(4).getHeightE() / 2 + this.getMenuPosY() - IMGManager.getIMG(Images.editorMap).getHeight() / 2 + iTranslateY);
        IMGManager.getIMG(Images.editorGame).drawO(oSB, this.getMenuElem(6).getPosXE() + this.getMenuElem(6).getTextPosElem() / 2 - IMGManager.getIMG(Images.editorGame).getWidth() / 2 + iTranslateX, this.getMenuElem(6).getPosY() + this.getMenuElem(6).getHeightE() / 2 + this.getMenuPosY() - IMGManager.getIMG(Images.editorGame).getHeight() / 2 + iTranslateY);
        IMGManager.getIMG(Images.editorLeaders).drawO(oSB, this.getMenuElem(3).getPosXE() + this.getMenuElem(3).getTextPosElem() / 2 - IMGManager.getIMG(Images.editorLeaders).getWidth() / 2 + iTranslateX, this.getMenuElem(3).getPosY() + this.getMenuElem(3).getHeightE() / 2 + this.getMenuPosY() - IMGManager.getIMG(Images.editorLeaders).getHeight() / 2 + iTranslateY);
        IMGManager.getIMG(Images.editorGame).drawO(oSB, this.getMenuElem(7).getPosXE() + this.getMenuElem(7).getTextPosElem() / 2 - IMGManager.getIMG(Images.editorGame).getWidth() / 2 + iTranslateX, this.getMenuElem(7).getPosY() + this.getMenuElem(7).getHeightE() / 2 + this.getMenuPosY() - IMGManager.getIMG(Images.editorGame).getHeight() / 2 + iTranslateY);
        IMGManager.getIMG(Images.diploLord).drawO(oSB, this.getMenuElem(8).getPosXE() + this.getMenuElem(8).getTextPosElem() / 2 - IMGManager.getIMG(Images.diploLord).getWidth() / 2 + iTranslateX, this.getMenuElem(8).getPosY() + this.getMenuElem(8).getHeightE() / 2 + this.getMenuPosY() - IMGManager.getIMG(Images.diploLord).getHeight() / 2 + iTranslateY);
        IMGManager.getIMG(Images.diploLord).drawO(oSB, this.getMenuElem(9).getPosXE() + this.getMenuElem(9).getTextPosElem() / 2 - IMGManager.getIMG(Images.diploLord).getWidth() / 2 + iTranslateX, this.getMenuElem(9).getPosY() + this.getMenuElem(9).getHeightE() / 2 + this.getMenuPosY() - IMGManager.getIMG(Images.diploLord).getHeight() / 2 + iTranslateY);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.PLAYER_TURN_ID = 0;
                CFG.menus.setMenuID(View.eEDITOR_SCENARIOS);
                break;
            }
            case 2: {
                CFG.menus.setMenuID(View.eEDITOR_CIVILIZATIONS);
                break;
            }
            case 3: {
                CFG.RELOAD_SCENARIO = true;
                CFG.menus.setMenuID(View.eGAME_LEADERS);
                break;
            }
            case 4: {
                CFG.menus.setMenuID(View.eMAP_EDITOR);
                break;
            }
            case 5: {
                CFG.menus.setMenuID(View.eEDITOR_CITIES);
                break;
            }
            case 6: {
                CFG.menus.setMenuID(View.eGAME_EDITOR);
                break;
            }
            case 7: {
                CFG.GO_TO_LINK = "https://lukaszjakowski.pl/";
                CFG.setDialogType(DialogType.GO_TO_LINK);
                break;
            }
            case 8: {
                CFG.menus.setMenuID(View.eMANAGE_MODS);
                break;
            }
            case 9: {
                CFG.menus.setMenuID(View.eWORKSHOP);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        if (CFG.lCreateScenario_UndoAssignProvsCivID != null) {
            CFG.lCreateScenario_UndoAssignProvsCivID.clear();
        }
        if (CFG.lCreateScenario_UndoWastelandProvinces != null) {
            CFG.lCreateScenario_UndoWastelandProvinces.clear();
        }
        if (CFG.RELOAD_SCENARIO) {
            Menu_Editor.reloadScenario();
        } else if (SaveGameManager.gameCanBeContinued) {
            CFG.toastM.addM("This slipped through. Now it's a feature.", CFG.COLOR_HOVER_TITLE);
        }
        SaveGameManager.gameCanBeContinued = false;
        CFG.editor_Continent_GameData = null;
        CFG.editor_Package_ContinentsData = null;
        CFG.editorAlliancesNames_GameData = null;
        CFG.editorPalletOfCivsColors_Data = null;
        CFG.editorCivilization_GameData = null;
        CFG.editorTerrain_Data2 = null;
        CFG.editorServiceRibbon_GameData = null;
        CFG.editorCity = null;
        CFG.editorServiceRibbon_Colors = null;
        CFG.editorLine_GameData = null;
        CFG.eventsManager.createScenarioEvents = null;
        CFG.brushMode = false;
        CFG.menus.setMenuIDWithoutAnim(View.eMAINMENU);
        CFG.menus.setBackAnimation(true);
    }

    public static final void reloadScenario() {
        CFG.PLAYER_TURN_ID = 0;
        CFG.FOG_OF_WAR = 2;
        RenderProvince.updateDrawProvinces();
        CFG.core.loadScenario(false);
        CFG.core.initPlayers();
        CFG.RELOAD_SCENARIO = false;
    }
}

