
package age.of.civilizations2.jakowski.lukasz.Menus.Civs;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Minimap;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios.Menu_CreateScenario;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_Civilizations
extends Menu_CreateScenario {
    private String selectAProvince;
    private int iStepWidth = 0;
    private String sCivilizations;
    private int iCivilizationsWidth;
    private int iLastKnownNumOfCivs = -1;

    public Menu_CreateScenario_Civilizations() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CustomizeWasteland"), CFG.COLOR_HOVER_TITLE));
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
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AssignProvinces"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Minimap(CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight()));
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, false, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AddNewCivilization") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.PADD * 2 + CFG.BUTTON_W + CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, false, true){

            @Override
            public int getTextWidthU() {
                return super.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH;
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (!this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                }
                CFG.core.getCiv(CFG.core.getActiveProvID() >= 0 ? CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() : 0).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.core.getActiveProvID() >= 0 ? CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() : 0).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
                super.drawTextE(oSB, CFG.CIV_FLAG_WIDTH + CFG.PADD + iTranslateX, iTranslateY, isActive);
            }

            @Override
            public void buildElemHover() {
                try {
                    if (CFG.core.getActiveProvID() < 0) {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SelectProvince") + ".", CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    } else if (this.getIsClickable()) {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RemoveCivilization"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    } else {
                        this.menuElemHover = null;
                    }
                }
                catch (IndexOutOfBoundsException e) {
                    this.menuElemHover = null;
                }
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.PADD * 3 + CFG.BUTTON_W * 2 + CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, false, true){

            @Override
            public int getTextWidthU() {
                return super.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH;
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (!this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.7f));
                }
                CFG.core.getCiv(CFG.core.getActiveProvID() >= 0 ? CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() : 0).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.core.getActiveProvID() >= 0 ? CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() : 0).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
                super.drawTextE(oSB, CFG.CIV_FLAG_WIDTH + CFG.PADD + iTranslateX, iTranslateY, isActive);
            }

            @Override
            public void buildElemHover() {
                try {
                    if (this.getIsClickable() && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getName().length() > 0) {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.core.getActiveProvID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    } else {
                        this.menuElemHover = null;
                    }
                }
                catch (IndexOutOfBoundsException e) {
                    this.menuElemHover = null;
                }
            }
        });
        menuElements.add(new Button_Game("", -1, CFG.PADD * 4 + CFG.BUTTON_W * 3 + CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, false, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.getIsHovered()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.75f));
                }
                IMGManager.getIMG(Images.wikipedia).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.wikipedia).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.wikipedia).getHeight() / 2 + iTranslateY);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                try {
                    if (this.getIsClickable() && CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wiki") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    } else {
                        this.menuElemHover = null;
                    }
                }
                catch (IndexOutOfBoundsException e) {
                    this.menuElemHover = null;
                }
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        super.updateLang();
        this.selectAProvince = CFG.lang.get("ManageCivilizations");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.selectAProvince);
        this.iStepWidth = (int)CFG.glyphLay.width;
        this.getMenuElem(3).setTextE(CFG.lang.get("AddCivilization"));
        this.getMenuElem(4).setTextE(CFG.lang.get("Remove"));
        this.getMenuElem(5).setTextE(CFG.lang.get("SetCapital"));
        this.updatedButtonsWidthFromToID(3, 7, CFG.PADD, CFG.BUTTON_W);
        this.sCivilizations = CFG.lang.get("Civilizations");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_EdgeR(oSB, iTranslateX, this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        if (this.getMenuElem(3).getVisibleE()) {
            CFG.drawEditorButtons_Bot_Edge_R(oSB, iTranslateX, this.getMenuElem(3).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(6).getPosXE() + this.getMenuElem(6).getWidthE() + CFG.PADD, CFG.BUTTON_H + CFG.PADD * 2);
        }
        CFG.drawTextDefaultWithShadow(oSB, this.selectAProvince, CFG.GAMEWIDTH / 2 - this.iStepWidth / 2 + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD / 2 + this.getMenuPosY() + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.b, 0.95f));

        if (this.iLastKnownNumOfCivs != CFG.core.getCivsSize()) {
            CFG.glyphLay.setText(CFG.fontMain.get(0), this.sCivilizations + ": " + (CFG.core.getCivsSize() - 1));
            this.iCivilizationsWidth = (int)CFG.glyphLay.width;
            this.iLastKnownNumOfCivs = CFG.core.getCivsSize();
        }
        oSB.setColor(new Color(0.06f, 0.06f, 0.06f, 1.0f));
        CFG.fontMain.get(0).getData().setScale(0.9f);
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, CFG.GAMEWIDTH - (CFG.PADD * 2 + CFG.CIV_NAME_BG_EXTRA_WIDTH + (int)((float)this.iCivilizationsWidth * 0.9f)) + iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT - CFG.CIV_NAME_BG_EXTRA_HEIGHT * 2 - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, CFG.PADD * 2 + CFG.CIV_NAME_BG_EXTRA_WIDTH + (int)((float)this.iCivilizationsWidth * 0.9f), CFG.TEXT_HEIGHT_DEFAULT + CFG.CIV_NAME_BG_EXTRA_HEIGHT * 2 - IMGManager.getIMG(Images.civNameBG).getHeight());
        IMGManager.getIMG(Images.civNameBG).drawO(oSB, CFG.GAMEWIDTH - (CFG.PADD * 2 + CFG.CIV_NAME_BG_EXTRA_WIDTH + (int)((float)this.iCivilizationsWidth * 0.9f)) + iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, CFG.PADD * 2 + CFG.CIV_NAME_BG_EXTRA_WIDTH + (int)((float)this.iCivilizationsWidth * 0.9f), false, true);
        CFG.drawTextDefaultWithShadow(oSB, this.sCivilizations + ": " + (CFG.core.getCivsSize() - 1), CFG.GAMEWIDTH - (int)((float)this.iCivilizationsWidth * 0.9f) - CFG.PADD + iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT - CFG.CIV_NAME_BG_EXTRA_HEIGHT + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.b, 0.95f));
        CFG.fontMain.get(0).getData().setScale(1.0f);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 1: {
                if (CFG.core.getCivsSize() < 3) {
                    CFG.toastM.addM(CFG.lang.get("Error") + " - " + CFG.lang.get("PlayableCivilizations") + ": " + (CFG.core.getCivsSize() - 1));
                } else {
                    CFG.createScenarioAssignProvsCiv = 0;
                    CFG.lCreateScenario_UndoAssignProvsCivID.clear();
                    if (CFG.core.getActiveProvID() >= 0) {
                        CFG.core.disableDrawCivilizationRegions(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                    }
                    CFG.core.setActiveProvID(-1);
                    CFG.menus.setMenuID(View.eCREATE_SCENARIO_ASSIGN);
                    CFG.menus.setVisible_CreateScenario_Civilizations_Suggest(false);
                }
                return;
            }
            case 2: {
                CFG.map.getMpC().centerToMinimapClick(Touch.getMousePosX() - this.getMenuElem(iID).getPosXE() - this.getPosX(), Touch.getMousePosY() - this.getMenuElem(iID).getPosY() - this.getMenuPosY());
                break;
            }
            case 3: {
                CFG.sSearch = null;
                CFG.iCreateScenario_ActiveProvinceID = CFG.core.getActiveProvID();
                if (!CFG.core.getProv(CFG.core.getActiveProvID()).getDrawProv()) {
                    CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                }
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_CIVILIZATIONS_SELECT);
                CFG.menus.setVisible_CreateScenario_Civilizations_Suggest(false);
                return;
            }
            case 4: {
                CFG.iCreateScenario_ActiveProvinceID = CFG.core.getActiveProvID();
                CFG.setDialogType(DialogType.CREATE_SCENARIO_REMOVE_CIVILIZATION);
                return;
            }
            case 5: {
                if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                    if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCapitalProvID() >= 0) {
                        CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCapitalProvID()).resetArmiesAll(-1);
                        try {
                            CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCapitalProvID()).getCit(0).setCityLevel(CFG.getEditorCityLevel(1));
                        }
                        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            
                        }
                        CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCapitalProvID()).setIsCapital(false);
                    }
                    CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).setCapitalProvID(CFG.core.getActiveProvID());
                    CFG.core.getProv(CFG.core.getActiveProvID()).setIsCapital(true);
                    CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCapitalProvID()).resetArmiesAll(-1);
                    try {
                        CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCapitalProvID()).getCit(0).setCityLevel(CFG.getEditorCityLevel(0));
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        
                    }
                    CFG.updateCreateScenario_Civilizations();
                    CFG.toastM.addM(CFG.lang.get("Capital") + ": " + CFG.core.getProv(CFG.core.getActiveProvID()).getName());
                }
                return;
            }
            case 6: {
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                    CFG.EDITOR_ACTIVE_GAMEDATA_TAG = CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivTag();
                    CFG.setDialogType(DialogType.GO_TO_WIKI);
                }
                return;
            }
        }
        super.actionEL(iID);
    }

    @Override
    public void onBackPressed() {
        CFG.brushMode = false;
        CFG.updateNumOfAvailableProvinces();
        CFG.lCreateScenario_UndoWastelandProvinces.clear();
        if (CFG.core.getActiveProvID() >= 0) {
            CFG.core.disableDrawCivilizationRegions(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
        }
        CFG.core.setActiveProvID(-1);
        CFG.backToMenu = View.eCREATE_SCENARIO_WASTELAND;
        CFG.goToMenu = View.eCREATE_SCENARIO_CIVILIZATIONS;
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_AVAILABLE_PROVINCES);
        CFG.menus.setVisible_CreateScenario_Civilizations_Suggest(false);
    }
}

