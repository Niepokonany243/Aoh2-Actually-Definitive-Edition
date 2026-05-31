
package age.of.civilizations2.jakowski.lukasz.Menus.Assign;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Minimap;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios.Menu_CreateScenario;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slide;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_Assign
extends Menu_CreateScenario {
    private String assignProvinces;
    private int iStepWidth;
    private String assignProvinces2;
    private int iStepWidth2;

    public Menu_CreateScenario_Assign() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true){

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
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ScenarioSettings"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Minimap(CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight()));
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Tip") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SelectCapital"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.editorCity, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W * 2, true, CFG.brushMode){

            @Override
            public boolean getCheckboxSt() {
                return CFG.brushMode;
            }
        });
        menuElements.add(new Slide(CFG.GAMEWIDTH - CFG.PADD - IMGManager.getIMG(Images.slideBG).getHeight() / 2 - IMGManager.getIMG(Images.slideBG).getHeight() * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 3 - IMGManager.getIMG(Images.slideBG).getHeight() * 2 - IMGManager.getIMG(Images.slideBG).getHeight() / 2, false));
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD * 3, false));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W * 2, true, !CFG.VIEW_SHOW_VALUES){

            @Override
            public boolean getCheckboxSt() {
                return !CFG.VIEW_SHOW_VALUES;
            }
        });
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.PADD, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W * 2, true, CFG.SCENARIO_EDITOR_OCCUPATION){

            @Override
            public boolean getCheckboxSt() {
                return CFG.SCENARIO_EDITOR_OCCUPATION;
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        super.updateLang();
        this.getMenuElem(3).setTextE(CFG.lang.get("SelectCivilization"));
        this.updatedButtonsWidthFromToID(3, 4, CFG.PADD, CFG.BUTTON_W);
        this.assignProvinces = CFG.lang.get("AssignProvinces");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.assignProvinces);
        this.iStepWidth = (int)CFG.glyphLay.width;
        this.assignProvinces2 = CFG.lang.get("ClickAProvinceOnTheMapToAssignProvinceToCivilization") + ".";
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.assignProvinces2);
        this.iStepWidth2 = (int)CFG.glyphLay.width;
        this.getMenuElem(4).setTextE(CFG.lang.get("Brush"));
        this.getMenuElem(6).setTextE(CFG.lang.get("Undo"));
        this.getMenuElem(7).setTextE(CFG.lang.get("Flags"));
        this.getMenuElem(8).setTextE(CFG.lang.get("Occupation"));
        this.updatedButtonsWidthFromToID(4, 5, CFG.PADD, CFG.BUTTON_W * 2);
        this.updatedButtonsWidthFromToID(6, 9, this.getMenuElem(4).getPosXE() + this.getMenuElem(4).getWidthE() + CFG.PADD, CFG.BUTTON_W);
        int tempX = CFG.GAMEWIDTH - this.getMenuElem(8).getWidthE() - CFG.PADD;
        this.getMenuElem(8).setPosX(tempX);
        tempX = tempX - this.getMenuElem(7).getWidthE() - CFG.PADD;
        this.getMenuElem(7).setPosX(tempX);
        tempX = tempX - this.getMenuElem(4).getWidthE() - CFG.PADD;
        this.getMenuElem(4).setPosX(tempX);
        tempX = tempX - this.getMenuElem(6).getWidthE() - CFG.PADD;
        this.getMenuElem(6).setPosX(tempX);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_Edge_R_Reflected(oSB, iTranslateX, this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Top_Edge_R_Reflected(oSB, this.getMenuElem(6).getPosXE() - CFG.PADD + iTranslateX, this.getMenuPosY() + CFG.BUTTON_H + CFG.PADD * 2 + iTranslateY, CFG.GAMEWIDTH - (this.getMenuElem(6).getPosXE() - CFG.PADD), CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Bot_Edge_R(oSB, iTranslateX, this.getMenuPosY() + this.getMenuElem(3).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(3).getPosXE() + this.getMenuElem(3).getWidthE() + CFG.PADD, this.getMenuElem(3).getHeightE() + CFG.PADD * 2);
        CFG.drawTextDefaultWithShadow(oSB, this.assignProvinces, CFG.GAMEWIDTH / 2 - (this.iStepWidth + CFG.CIV_FLAG_WIDTH + CFG.PADD) / 2 + CFG.PADD + CFG.CIV_FLAG_WIDTH + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD / 2 + this.getMenuPosY() + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.b, 0.95f));
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextDefaultWithShadow(oSB, this.assignProvinces2, CFG.GAMEWIDTH / 2 - (int)((float)this.iStepWidth2 * 0.8f / 2.0f) + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 + CFG.PADD + this.getMenuPosY() + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO.b, 0.75f));
        CFG.fontMain.get(0).getData().setScale(1.0f);
        if (CFG.createScenarioAssignProvsCiv >= 0) {
            CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getFlagC().drawO(oSB, CFG.GAMEWIDTH / 2 - (this.iStepWidth + CFG.CIV_FLAG_WIDTH + CFG.PADD) / 2 + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 - CFG.CIV_FLAG_HEIGHT - CFG.PADD / 2 + this.getMenuPosY() - CFG.core.getCiv(CFG.createScenarioAssignProvsCiv).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
            IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, CFG.GAMEWIDTH / 2 - (this.iStepWidth + CFG.CIV_FLAG_WIDTH + CFG.PADD) / 2 + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 - CFG.CIV_FLAG_HEIGHT - CFG.PADD / 2 + this.getMenuPosY() + iTranslateY);
        }
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 1: {
                CFG.core.disableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv);
                CFG.brushMode = false;
                this.getMenuElem(4).setCheckboxSt(CFG.brushMode);
                this.getMenuElem(5).setVisibleE(CFG.brushMode);
                CFG.core.setActiveProvID(-1);
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_SETTINGS);
                CFG.menus.disposeFlagsCreate_Scenario_Assign();
                return;
            }
            case 2: {
                CFG.map.getMpC().centerToMinimapClick(Touch.getMousePosX() - this.getMenuElem(iID).getPosXE() - this.getPosX(), Touch.getMousePosY() - this.getMenuElem(iID).getPosY() - this.getMenuPosY());
                break;
            }
            case 3: {
                CFG.core.setActiveProvID(-1);
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_ASSIGN_SELECT);
                CFG.menus.disposeFlagsCreate_Scenario_Assign();
                return;
            }
            case 4: {
                CFG.brushMode = !CFG.brushMode;
                this.getMenuElem(iID).setCheckboxSt(CFG.brushMode);
                this.getMenuElem(iID + 1).setVisibleE(CFG.brushMode);
                return;
            }
            case 6: {
                if (CFG.lCreateScenario_UndoAssignProvsCivID.size() > 0) {
                    CFG.core.getProv(CFG.lCreateScenario_UndoAssignProvsCivID.get(CFG.lCreateScenario_UndoAssignProvsCivID.size() - 1).getProvinceID()).setCivId(CFG.lCreateScenario_UndoAssignProvsCivID.get(CFG.lCreateScenario_UndoAssignProvsCivID.size() - 1).getCivID(), false);
                    CFG.core.getProv(CFG.lCreateScenario_UndoAssignProvsCivID.get(CFG.lCreateScenario_UndoAssignProvsCivID.size() - 1).getProvinceID()).setTrueOwnerOfProv(CFG.lCreateScenario_UndoAssignProvsCivID.get(CFG.lCreateScenario_UndoAssignProvsCivID.size() - 1).getCivID());
                    CFG.core.getProv(CFG.lCreateScenario_UndoAssignProvsCivID.get(CFG.lCreateScenario_UndoAssignProvsCivID.size() - 1).getProvinceID()).buildProvinceCore();
                    CFG.province_CoresGD.clearCoresData(CFG.lCreateScenario_UndoAssignProvsCivID.get(CFG.lCreateScenario_UndoAssignProvsCivID.size() - 1).getProvinceID());
                    CFG.core.setActiveProvID(CFG.lCreateScenario_UndoAssignProvsCivID.get(CFG.lCreateScenario_UndoAssignProvsCivID.size() - 1).getProvinceID());
                    if (!CFG.core.getProv(CFG.core.getActiveProvID()).getDrawProv()) {
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                    }
                    CFG.removeUndoAssignProvinces();
                }
                return;
            }
            case 7: {
                CFG.VIEW_SHOW_VALUES = !CFG.VIEW_SHOW_VALUES;
                return;
            }
            case 8: {
                CFG.SCENARIO_EDITOR_OCCUPATION = !CFG.SCENARIO_EDITOR_OCCUPATION;
                return;
            }
        }
        super.actionEL(iID);
    }

    @Override
    public void onBackPressed() {
        CFG.core.disableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv);
        CFG.brushMode = false;
        this.getMenuElem(4).setCheckboxSt(CFG.brushMode);
        this.getMenuElem(5).setVisibleE(CFG.brushMode);
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_CIVILIZATIONS);
        CFG.core.setActiveProvID(-1);
        CFG.updateCreateScenario_Civilizations();
        CFG.menus.disposeFlagsCreate_Scenario_Assign();
    }
}

