/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Events;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Remove;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios.Menu_CreateScenario;
import age.of.civilizations2.jakowski.lukasz.Sliders.ZRest.Slider_BG;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_Decision
extends Menu_CreateScenario {
    private String assignProvinces;
    private int iStepWidth;
    private String sTitle;
    private String sDescription;

    public Menu_CreateScenario_Events_Decision() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true));
        int tY = CFG.BUTTON_H + CFG.PADD * 3;
        menuElements.add(new Button_Classic_LR_Line(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_CreateScenario_Events_Decision.this.sTitle + super.getTextToDrawElem();
            }
        });
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Slider_BG(0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H - CFG.PADD * 2, 0, 100, CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).iAIChance){

            @Override
            public String getDrawText() {
                return super.getDrawText() + "%";
            }
        });
        menuElements.add(new Button_Classic_LR_Line(null, (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_CreateScenario_Events_Decision.this.sDescription + super.getTextToDrawElem();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        for (int i = 0; i < CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.size(); ++i) {
            menuElements.add(new Button_Classic(CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(i).getConditionText(), (int)(50.0f * CFG.GUI_SCALE), 0, tY, CFG.GAMEWIDTH - CFG.BUTTON_W, CFG.BUTTON_H, true));
            menuElements.add(new Button_Classic_Remove(CFG.GAMEWIDTH - CFG.BUTTON_W, tY, CFG.BUTTON_W, CFG.BUTTON_H, true){

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
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Save"));
        this.assignProvinces = CFG.lang.get("Decision");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.assignProvinces);
        this.iStepWidth = (int)CFG.glyphLay.width;
        if (CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).sDesc == null) {
            CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).sDesc = "";
        }
        this.sTitle = CFG.lang.get("Title") + ": ";
        this.sDescription = CFG.lang.get("Description") + ": ";
        this.getMenuElem(2).setTextE(CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).sTitle);
        this.getMenuElem(3).setTextE(CFG.lang.get("AddNewOutcome"));
        this.getMenuElem(4).setTextE(CFG.lang.get("AIChance") + ": ");
        this.getMenuElem(5).setTextE(CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).sDesc);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_Edge_R_Reflected(oSB, iTranslateX, this.getMenuPosY() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawTextDefaultWithShadow(oSB, this.assignProvinces, CFG.GAMEWIDTH / 2 - (this.iStepWidth + CFG.CIV_FLAG_WIDTH + CFG.PADD) / 2 + CFG.PADD + CFG.CIV_FLAG_WIDTH + iTranslateX, CFG.PADD + CFG.BUTTON_H / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + this.getMenuPosY() + iTranslateY, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.b, 0.95f));
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    public final void saveData() {
        CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).sTitle = this.getMenuElem(2).getTextE();
        CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).sDesc = this.getMenuElem(5).getTextE();
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: 
            case 1: {
                this.saveData();
                this.onBackPressed();
                return;
            }
            case 2: {
                CFG.showKeyboard();
                return;
            }
            case 3: {
                this.saveData();
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_ADD_NEW_OUTCOME);
                return;
            }
            case 4: {
                this.saveData();
                CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).iAIChance = this.getMenuElem(iID).getCurr();
                return;
            }
            case 5: {
                CFG.showKeyboard();
                return;
            }
        }
        if ((iID -= 6) % 2 == 0) {
            this.saveData();
            CFG.eventsManager.createEvent_EditConditionID = iID / 2;
            CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.get(CFG.eventsManager.createEvent_EditConditionID).editViewID();
        } else {
            this.saveData();
            CFG.eventsManager.createEvent_EditConditionID = iID / 2;
            CFG.eventsManager.createScenarioEvents.lDecisions.get((int)CFG.eventsManager.createEvent_EditTriggerID).lOutcomes.remove(CFG.eventsManager.createEvent_EditConditionID);
            CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_DECISION);
        }
    }

    @Override
    public void onBackPressed() {
        CFG.eventsManager.createScenarioEvents.checkDecisions();
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS);
        CFG.menus.setVisibleCreateScenario_Events_Edit(true);
        CFG.menus.setBackAnimation(true);
    }
}

