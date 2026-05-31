/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ProvincesCS;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Minimap;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios.Menu_CreateScenario;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slide;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_AvailableProvinces
extends Menu_CreateScenario {
    private String selectMapOfAvailableProvinces;
    private int iStepWidth;
    private String selectMapOfAvailableProvinces2;
    private int iStepWidth2;
    private String sPlayableProvinces;
    private int iPlayableProvincesWidth;
    private String sWastelandProvinces;
    private int iWastelandProvincesWidth;

    public Menu_CreateScenario_AvailableProvinces() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SelectRegions"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ManageCivilizations"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Minimap(CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight()));
        menuElements.add(new Slide(CFG.GAMEWIDTH - CFG.PADD - IMGManager.getIMG(Images.slideBG).getHeight() / 2 - IMGManager.getIMG(Images.slideBG).getHeight() * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - CFG.PADD - IMGManager.getIMG(Images.slideBG).getHeight() * 2 - IMGManager.getIMG(Images.slideBG).getHeight() / 2, CFG.brushMode));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD, CFG.PADD * 3 + CFG.BUTTON_H, CFG.BUTTON_W * 2, true, CFG.bSetWasteland_AvailableProvinces){

            @Override
            public boolean getCheckboxSt() {
                return CFG.bSetWasteland_AvailableProvinces;
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD * 2 + CFG.BUTTON_W * 2, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W * 2, true, CFG.brushMode){

            @Override
            public boolean getCheckboxSt() {
                return CFG.brushMode;
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.PADD * 3 + CFG.BUTTON_W * 4, CFG.BUTTON_H + CFG.PADD * 3, false));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, true, GameCalendar.ENABLE_COLONIZATION){

            @Override
            public boolean getCheckboxSt() {
                return GameCalendar.ENABLE_COLONIZATION;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Enable") + "/" + CFG.lang.get("Disable") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ColonizationofWastelandProvinces") + "."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W + CFG.BUTTON_W / 2 + CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void updateLang() {
        super.updateLang();
        this.selectMapOfAvailableProvinces = CFG.lang.get("CustomizeWasteland");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.selectMapOfAvailableProvinces);
        this.iStepWidth = (int)CFG.glyphLay.width;
        this.selectMapOfAvailableProvinces2 = CFG.lang.get("SetWhichProvincesOfTheWorldAreWasteland") + ".";
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.selectMapOfAvailableProvinces2);
        this.iStepWidth2 = (int)CFG.glyphLay.width;
        this.getMenuElem(4).setTextE(CFG.lang.get("Wasteland"));
        this.getMenuElem(5).setTextE(CFG.lang.get("Brush"));
        this.getMenuElem(6).setTextE(CFG.lang.get("Undo"));
        this.getMenuElem(7).setTextE(CFG.lang.get("ColonizationofWasteland"));
        this.getMenuElem(8).setTextE(CFG.lang.get("Reverse"));
        this.updatedButtonsWidthFromToID(4, 6, CFG.PADD, CFG.BUTTON_W * 2);
        this.updatedButtonsWidthFromToID(6, 7, this.getMenuElem(5).getPosXE() + this.getMenuElem(5).getWidthE() + CFG.PADD, CFG.BUTTON_W);
        this.updatedButtonsWidthFromToID(7, 8, CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2);
        this.updatedButtonsWidthFromToID(8, 9, CFG.PADD, CFG.BUTTON_W);
        this.getMenuElem(8).setPosX(this.getMenuElem(7).getPosXE() + this.getMenuElem(7).getWidthE() + CFG.PADD);
        this.sPlayableProvinces = CFG.lang.get("Playable");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sPlayableProvinces + ": ");
        this.iPlayableProvincesWidth = (int)CFG.glyphLay.width;
        this.sWastelandProvinces = CFG.lang.get("Wasteland");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sWastelandProvinces + ": ");
        this.iWastelandProvincesWidth = (int)CFG.glyphLay.width;
        int tempX = CFG.GAMEWIDTH - this.getMenuElem(4).getWidthE() - CFG.PADD;
        this.getMenuElem(4).setPosX(tempX);
        tempX = tempX - this.getMenuElem(5).getWidthE() - CFG.PADD;
        this.getMenuElem(5).setPosX(tempX);
        tempX = tempX - this.getMenuElem(6).getWidthE() - CFG.PADD;
        this.getMenuElem(6).setPosX(tempX);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_Edge_R_Reflected(oSB, iTranslateX, this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Top_Edge_R_Reflected(oSB, this.getMenuElem(6).getPosXE() - CFG.PADD + iTranslateX, this.getMenuPosY() + CFG.BUTTON_H + CFG.PADD * 2 + iTranslateY, CFG.GAMEWIDTH - (this.getMenuElem(6).getPosXE() - CFG.PADD), CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Bot_Edge_R(oSB, iTranslateX, this.getMenuPosY() + this.getMenuElem(7).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(8).getPosXE() + this.getMenuElem(8).getWidthE() + CFG.PADD, this.getMenuElem(7).getHeightE() + CFG.PADD * 2);
        CFG.drawTextDefaultWithShadow(oSB, this.selectMapOfAvailableProvinces, CFG.GAMEWIDTH / 2 - this.iStepWidth / 2 + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD / 2 + this.getMenuPosY() + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.b, 0.95f));
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextDefaultWithShadow(oSB, this.selectMapOfAvailableProvinces2, CFG.GAMEWIDTH / 2 - (int)((float)this.iStepWidth2 * 0.8f / 2.0f) + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 + CFG.PADD + this.getMenuPosY() + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.b, 0.75f));
        CFG.fontMain.get(0).getData().setScale(1.0f);
        oSB.setColor(new Color(0.06f, 0.06f, 0.06f, 1.0f));
        CFG.fontMain.get(0).getData().setScale(0.9f);
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, CFG.GAMEWIDTH - (CFG.PADD * 2 + CFG.CIV_NAME_BG_EXTRA_WIDTH + (int)((float)this.iPlayableProvincesWidth * 0.9f) + CFG.iNumOfAvailableProvincesWidth) + iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2 - CFG.TEXT_HEIGHT_DEFAULT * 2 - CFG.CIV_NAME_BG_EXTRA_HEIGHT * 4 - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, CFG.PADD * 2 + CFG.CIV_NAME_BG_EXTRA_WIDTH + (int)((float)this.iPlayableProvincesWidth * 0.9f) + CFG.iNumOfAvailableProvincesWidth, CFG.TEXT_HEIGHT_DEFAULT + CFG.CIV_NAME_BG_EXTRA_HEIGHT * 2 - IMGManager.getIMG(Images.civNameBG).getHeight());
        IMGManager.getIMG(Images.civNameBG).drawO(oSB, CFG.GAMEWIDTH - (CFG.PADD * 2 + CFG.CIV_NAME_BG_EXTRA_WIDTH + (int)((float)this.iPlayableProvincesWidth * 0.9f) + CFG.iNumOfAvailableProvincesWidth) + iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2 - CFG.TEXT_HEIGHT_DEFAULT - CFG.CIV_NAME_BG_EXTRA_HEIGHT * 2 - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, CFG.PADD * 2 + CFG.CIV_NAME_BG_EXTRA_WIDTH + (int)((float)this.iPlayableProvincesWidth * 0.9f) + CFG.iNumOfAvailableProvincesWidth, false, true);
        CFG.drawTextDefaultWithShadow(oSB, this.sPlayableProvinces + ": " + CFG.iNumOfAvailableProvinces, CFG.GAMEWIDTH - (int)((float)this.iPlayableProvincesWidth * 0.9f) - CFG.iNumOfAvailableProvincesWidth - CFG.PADD + iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2 - CFG.TEXT_HEIGHT_DEFAULT * 2 - CFG.CIV_NAME_BG_EXTRA_HEIGHT * 3 + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.b, 0.95f));
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, CFG.GAMEWIDTH - (CFG.PADD * 2 + CFG.CIV_NAME_BG_EXTRA_WIDTH + (int)((float)this.iWastelandProvincesWidth * 0.9f) + CFG.iNumOfWastelandProvincesWidth) + iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT - CFG.CIV_NAME_BG_EXTRA_HEIGHT * 2 - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, CFG.PADD * 2 + CFG.CIV_NAME_BG_EXTRA_WIDTH + (int)((float)this.iWastelandProvincesWidth * 0.9f) + CFG.iNumOfWastelandProvincesWidth, CFG.TEXT_HEIGHT_DEFAULT + CFG.CIV_NAME_BG_EXTRA_HEIGHT * 2 - IMGManager.getIMG(Images.civNameBG).getHeight());
        IMGManager.getIMG(Images.civNameBG).drawO(oSB, CFG.GAMEWIDTH - (CFG.PADD * 2 + CFG.CIV_NAME_BG_EXTRA_WIDTH + (int)((float)this.iWastelandProvincesWidth * 0.9f) + CFG.iNumOfWastelandProvincesWidth) + iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, CFG.PADD * 2 + CFG.CIV_NAME_BG_EXTRA_WIDTH + (int)((float)this.iWastelandProvincesWidth * 0.9f) + CFG.iNumOfWastelandProvincesWidth, false, true);
        CFG.drawTextDefaultWithShadow(oSB, this.sWastelandProvinces + ": " + CFG.iNumOfWastelandProvinces, CFG.GAMEWIDTH - (int)((float)this.iWastelandProvincesWidth * 0.9f) - CFG.iNumOfWastelandProvincesWidth - CFG.PADD + iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT - CFG.CIV_NAME_BG_EXTRA_HEIGHT + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.b, 0.95f));
        CFG.fontMain.get(0).getData().setScale(1.0f);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 1: {
                int i;
                int nPlayableProvinces = 0;
                for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                    if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0) continue;
                    ++nPlayableProvinces;
                }
                if (nPlayableProvinces < 2) {
                    CFG.toastM.addM(CFG.lang.get("Error") + " - " + CFG.lang.get("PlayableProvinces") + ": " + nPlayableProvinces);
                } else {
                    CFG.brushMode = false;
                    CFG.menus.setMenuID(CFG.goToMenu);
                    if (CFG.goToMenu != View.eCREATE_RANDOM_GAME) {
                        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() < 0 || CFG.core.getProv(i).getCivId() <= 0) continue;
                            CFG.core.getProv(i).setCivId(0, false, false);
                        }
                        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                            if (CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).getWastelandLvl() < 0) continue;
                            boolean foundAnotherCapital = false;
                            for (int j = 0; j < CFG.core.getCiv(i).getNumOfProvs(); ++j) {
                                if (CFG.core.getProv(CFG.core.getCiv(i).getProvID(j)).getWastelandLvl() >= 0) continue;
                                CFG.core.getCiv(i).setCapitalProvID(CFG.core.getCiv(i).getProvID(j));
                                foundAnotherCapital = true;
                                break;
                            }
                            if (foundAnotherCapital) continue;
                            CFG.core.createScenarioRemoveCivilization(i);
                        }
                        CFG.core.buildWastelandLevels();
                        CFG.updateCreateScenario_Civilizations();
                        CFG.map.getMpB().disposeMinimapOfCivilizations();
                    } else {
                        CFG.core.buildWastelandLevels();
                    }
                }
                return;
            }
            case 2: {
                CFG.map.getMpC().centerToMinimapClick(Touch.getMousePosX() - this.getMenuElem(iID).getPosXE() - this.getPosX(), Touch.getMousePosY() - this.getMenuElem(iID).getPosY() - this.getMenuPosY());
                break;
            }
            case 4: {
                CFG.bSetWasteland_AvailableProvinces = !CFG.bSetWasteland_AvailableProvinces;
                this.getMenuElem(iID).setCheckboxSt(CFG.bSetWasteland_AvailableProvinces);
                return;
            }
            case 5: {
                CFG.brushMode = !CFG.brushMode;
                this.getMenuElem(iID).setCheckboxSt(CFG.brushMode);
                this.getMenuElem(3).setVisibleE(CFG.brushMode);
                return;
            }
            case 6: {
                if (CFG.lCreateScenario_UndoWastelandProvinces.size() > 0) {
                    CFG.core.getProv(CFG.lCreateScenario_UndoWastelandProvinces.get(CFG.lCreateScenario_UndoWastelandProvinces.size() - 1)).setWastelandLvl(CFG.core.getProv(CFG.lCreateScenario_UndoWastelandProvinces.get(CFG.lCreateScenario_UndoWastelandProvinces.size() - 1)).getWastelandLvl() >= 0 ? -1 : 0);
                    CFG.core.setActiveProvID(CFG.lCreateScenario_UndoWastelandProvinces.get(CFG.lCreateScenario_UndoWastelandProvinces.size() - 1));
                    if (!CFG.core.getProv(CFG.core.getActiveProvID()).getDrawProv()) {
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                    }
                    CFG.removeUndoWastelandProvince();
                    CFG.updateNumOfAvailableProvinces();
                }
                return;
            }
            case 7: {
                boolean bl = GameCalendar.ENABLE_COLONIZATION = !GameCalendar.ENABLE_COLONIZATION;
                if (GameCalendar.ENABLE_COLONIZATION) {
                    CFG.toastM.addM(CFG.lang.get("Colonization") + " - " + CFG.lang.get("Enabled"));
                } else {
                    CFG.toastM.addM(CFG.lang.get("Colonization") + " - " + CFG.lang.get("Disabled"));
                }
                return;
            }
            case 8: {
                CFG.setDialogType(DialogType.REVERSE_WASTELAND);
                return;
            }
        }
        super.actionEL(iID);
    }

    @Override
    public void onBackPressed() {
        CFG.core.setActiveProvID(-1);
        CFG.brushMode = false;
        CFG.menus.setMenuID(CFG.backToMenu);
    }
}

