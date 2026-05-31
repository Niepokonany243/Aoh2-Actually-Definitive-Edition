/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Events;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Sliders.ZRest.Slider_Age;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_Date
extends Menu {
    public Menu_CreateScenario_Events_Date() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
            }
        });
        menuElements.add(new Text(null, -1, CFG.BUTTON_W + CFG.PADD * 2, 0, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.PADD * 2) * 2, CFG.BUTTON_H + CFG.PADD * 2){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? new Color(0.56f, 0.56f, 0.56f, 1.0f) : (this.getIsClickable() ? new Color(0.98f, 0.98f, 0.98f, 1.0f) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getName(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(GameCalendar.getCurrDate_CreateEvent()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game("-", -1, CFG.PADD, CFG.BUTTON_H + CFG.PADD * 4, true));
        menuElements.add(new Slider_Age(null, CFG.BUTTON_W + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD * 4, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.PADD * 2) * 2, CFG.BUTTON_H, -350, 720, 125){

            @Override
            public String getDrawText() {
                return this.getTextE() + CFG.gameAges.getYear(this.getCurr());
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getName(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.gameAges.getYear(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getBeginningYear())));
                nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.gameAges.getYear(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getEndYear())));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void updateSlider(int nX) {
                super.updateSlider(nX);
                this.menuElemHover = null;
            }
        });
        menuElements.add(new Button_Game("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.BUTTON_H + CFG.PADD * 4, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H * 2 + CFG.PADD * 5, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(1).setTextE(CFG.eventsManager.iCreateEvent_Day + " " + GameCalendar.getMonthName(CFG.eventsManager.iCreateEvent_Month));
        this.getMenuElem(2).setTextE(CFG.lang.get("NoDate"));
        this.getMenuElem(4).setTextE(CFG.lang.get("Year") + ": ");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.drawEditorTitle_EdgeR(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawBG_WithGradient(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getMenuPosY() + this.getMenuElem(3).getPosY() - CFG.PADD + iTranslateY, CFG.GAMEWIDTH, this.getMenuElem(3).getHeightE() + CFG.PADD * 2);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                if (CFG.eventsManager.setSinceDate) {
                    CFG.eventsManager.createScenarioEvents.getEventDate_Since().iEventDay = CFG.eventsManager.iCreateEvent_Day;
                    CFG.eventsManager.createScenarioEvents.getEventDate_Since().iEventMonth = CFG.eventsManager.iCreateEvent_Month;
                    CFG.eventsManager.createScenarioEvents.getEventDate_Since().iEventYear = CFG.eventsManager.iCreateEvent_Year;
                } else {
                    CFG.eventsManager.createScenarioEvents.getEventDate_Until().iEventDay = CFG.eventsManager.iCreateEvent_Day;
                    CFG.eventsManager.createScenarioEvents.getEventDate_Until().iEventMonth = CFG.eventsManager.iCreateEvent_Month;
                    CFG.eventsManager.createScenarioEvents.getEventDate_Until().iEventYear = CFG.eventsManager.iCreateEvent_Year;
                }
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.menus.setCreateScenario_Events_Calendar_Visible(!CFG.menus.getCreateScenario_Events_Calendar_Visible());
                return;
            }
            case 2: {
                if (CFG.eventsManager.setSinceDate) {
                    CFG.eventsManager.createScenarioEvents.getEventDate_Since().iEventDay = 1;
                    CFG.eventsManager.createScenarioEvents.getEventDate_Since().iEventMonth = 1;
                    CFG.eventsManager.createScenarioEvents.getEventDate_Since().iEventYear = 9999999;
                } else {
                    CFG.eventsManager.createScenarioEvents.getEventDate_Until().iEventDay = 1;
                    CFG.eventsManager.createScenarioEvents.getEventDate_Until().iEventMonth = 1;
                    CFG.eventsManager.createScenarioEvents.getEventDate_Until().iEventYear = 9999999;
                }
                this.onBackPressed();
                return;
            }
            case 3: {
                this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
                CFG.eventsManager.iCreateEvent_Year = this.getMenuElem(iID + 1).getCurr();
                ArrayList<String> tMess3 = new ArrayList<String>();
                ArrayList<Color> tColor3 = new ArrayList<Color>();
                tMess3.add(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getName());
                tColor3.add(Color.WHITE);
                tMess3.add(GameCalendar.getCurrDate_CreateEvent());
                tColor3.add(CFG.COLOR_HOVER_TITLE);
                CFG.toastM.addM(tMess3, tColor3);
                return;
            }
            case 4: {
                CFG.eventsManager.iCreateEvent_Year = this.getMenuElem(iID).getCurr();
                ArrayList<String> tMess2 = new ArrayList<String>();
                ArrayList<Color> tColor2 = new ArrayList<Color>();
                tMess2.add(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getName());
                tColor2.add(Color.WHITE);
                tMess2.add(GameCalendar.getCurrDate_CreateEvent());
                tColor2.add(CFG.COLOR_HOVER_TITLE);
                CFG.toastM.addM(tMess2, tColor2);
                return;
            }
            case 5: {
                this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
                CFG.eventsManager.iCreateEvent_Year = this.getMenuElem(iID - 1).getCurr();
                ArrayList<String> tMess = new ArrayList<String>();
                ArrayList<Color> tColor = new ArrayList<Color>();
                tMess.add(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getName());
                tColor.add(Color.WHITE);
                tMess.add(GameCalendar.getCurrDate_CreateEvent());
                tColor.add(CFG.COLOR_HOVER_TITLE);
                CFG.toastM.addM(tMess, tColor);
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS);
        CFG.menus.setVisibleCreateScenario_Events_Edit(true);
        CFG.menus.setBackAnimation(true);
    }
}

