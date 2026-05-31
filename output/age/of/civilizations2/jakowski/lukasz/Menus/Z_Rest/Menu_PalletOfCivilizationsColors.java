/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_ColorPicker;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.PalletOfCivsColors_Civ_GameData;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;

public class Menu_PalletOfCivilizationsColors
extends Menu {
    public Menu_PalletOfCivilizationsColors() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Classic("", -1, CFG.BUTTON_W + CFG.PADD * 2, 0, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.PADD * 2) * 2, CFG.BUTTON_H + CFG.PADD * 2, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? new Color(0.82f, 0.82f, 0.82f, 1.0f) : (this.getIsClickable() ? new Color(1.0f, 1.0f, 1.0f, 1.0f) : new Color(0.84f, 0.84f, 0.84f, 0.7f));
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game_ColorPicker(CFG.PADD, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W * 2, true){

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (CFG.core.getActiveProvID() < 0) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
                }
                super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(Color.WHITE);
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD * 2 + CFG.BUTTON_W * 2, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W * 2, true, true));
        CFG.menus.getColorPicker().setPosX(CFG.PADD * 3);
        CFG.menus.getColorPicker().setPosY(CFG.BUTTON_H * 2 + CFG.PADD * 7);
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Scenario") + ": " + CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(CFG.core.getScenarioID())));
        this.getMenuElem(2).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(4).setTextE(CFG.lang.get("Colors"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_EdgeR(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Top_Edge_R(oSB, this.getMenuElem(3).getPosXE() - CFG.PADD + iTranslateX + iTranslateY, this.getMenuElem(3).getPosY() - CFG.PADD, this.getMenuElem(4).getPosXE() + this.getMenuElem(4).getWidthE() + CFG.PADD, this.getMenuElem(3).getHeightE() + CFG.PADD * 2);
        if (CFG.core.getActiveProvID() >= 0) {
            CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getFlagC().drawO(oSB, this.getMenuElem(1).getPosXE() + this.getMenuElem(1).getWidthE() / 2 - this.getMenuElem(1).getTextWidthU() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH + iTranslateX, this.getMenuPosY() + this.getMenuElem(1).getPosY() + this.getMenuElem(1).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getMenuElem(1).getPosXE() + this.getMenuElem(1).getWidthE() / 2 - this.getMenuElem(1).getTextWidthU() / 2 - CFG.PADD - CFG.CIV_FLAG_WIDTH + iTranslateX, this.getMenuPosY() + this.getMenuElem(1).getPosY() + this.getMenuElem(1).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
        }
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
                CFG.menus.getColorPicker().setVisible(false, null);
                CFG.menus.setMenuID(View.eCHOOSE_SCENARIO);
                CFG.backToMenu = View.eGAME_EDITOR_PALLETS_OF_CIVS_COLORS_PACKAGES_EDIT;
                CFG.goToMenu = View.eGAME_EDITOR_PALLETS_OF_CIVS_COLORS_PACKAGES_EDIT;
                return;
            }
            case 2: {
                CFG.menus.getColorPicker().setVisible(false, null);
                CFG.editorPalletOfCivsColors_Data.saveData();
                CFG.palletManager.updatePalletsOfCivsColorsTags();
                this.onBackPressed();
                return;
            }
            case 3: {
                if (CFG.menus.getColorPicker().getVisible() || CFG.core.getActiveProvID() < 0) {
                    CFG.menus.getColorPicker().setVisible(false, null);
                } else {
                    CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.PALLET_OF_COLORS);
                }
                return;
            }
            case 4: {
                if (this.getMenuElem(iID).getCheckboxSt()) {
                    CFG.editorPalletOfCivsColors_Data.saveData();
                    for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                        FileHandle file = null;
                        try {
                            file = FileManager.loadFile("game/pallets_of_civs_colors/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.core.getCiv(i).getCivTag());
                            try {
                                PalletOfCivsColors_Civ_GameData nCivColor = (PalletOfCivsColors_Civ_GameData)CFG.deserialize(file.readBytes());
                                CFG.core.getCiv(i).setR((int)(nCivColor.getColor().getR() * 255.0f));
                                CFG.core.getCiv(i).setG((int)(nCivColor.getColor().getG() * 255.0f));
                                CFG.core.getCiv(i).setB((int)(nCivColor.getColor().getB() * 255.0f));
                            }
                            catch (ClassNotFoundException e) {
                                CFG.core.getCiv(i).setR(0);
                                CFG.core.getCiv(i).setG(1);
                                CFG.core.getCiv(i).setB(2);
                            }
                            catch (IOException e) {
                                CFG.core.getCiv(i).setR(0);
                                CFG.core.getCiv(i).setG(1);
                                CFG.core.getCiv(i).setB(2);
                            }
                            continue;
                        }
                        catch (GdxRuntimeException ex) {
                            CFG.core.getCiv(i).setR(0);
                            CFG.core.getCiv(i).setG(1);
                            CFG.core.getCiv(i).setB(2);
                        }
                    }
                    this.getMenuElem(iID).setCheckboxSt(!this.getMenuElem(iID).getCheckboxSt());
                    break;
                }
                CFG.editorPalletOfCivsColors_Data.saveData();
                for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                    FileHandle file = null;
                    try {
                        file = FileManager.loadFile("game/pallets_of_civs_colors/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + "/" + CFG.core.getCiv(i).getCivTag());
                        try {
                            PalletOfCivsColors_Civ_GameData nCivColor = (PalletOfCivsColors_Civ_GameData)CFG.deserialize(file.readBytes());
                            CFG.core.getCiv(i).setR((int)(nCivColor.getColor().getR() * 255.0f));
                            CFG.core.getCiv(i).setG((int)(nCivColor.getColor().getG() * 255.0f));
                            CFG.core.getCiv(i).setB((int)(nCivColor.getColor().getB() * 255.0f));
                        }
                        catch (ClassNotFoundException e) {
                            CFG.palletManager.loadCivilizationStandardColor(i);
                        }
                        catch (IOException e) {
                            CFG.palletManager.loadCivilizationStandardColor(i);
                        }
                        continue;
                    }
                    catch (GdxRuntimeException ex) {
                        CFG.palletManager.loadCivilizationStandardColor(i);
                    }
                }
                this.getMenuElem(iID).setCheckboxSt(!this.getMenuElem(iID).getCheckboxSt());
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eGAME_EDITOR_PALLETS_OF_CIVS_COLORS_PACKAGES);
        CFG.menus.setBackAnimation(true);
        CFG.menus.getColorPicker().setVisible(false, null);
    }
}

