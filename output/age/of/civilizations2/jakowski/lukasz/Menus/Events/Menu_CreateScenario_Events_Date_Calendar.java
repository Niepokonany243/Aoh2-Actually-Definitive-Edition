/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Events;

import age.of.civilizations2.jakowski.lukasz.Button.Button_CalendarDay;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.ZRest.Button_ArrowLeft;
import age.of.civilizations2.jakowski.lukasz.Button.ZRest.Button_ArrowRight;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_Date_Calendar
extends Menu {
    public Menu_CreateScenario_Events_Date_Calendar() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempW = CFG.PADD * 4 + CFG.BUTTON_H * 2 / 3 * 7 + CFG.PADD * 6;
        menuElements.add(new Button_ArrowLeft(0, CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H * 2 / 3){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(GameCalendar.getMonthName(CFG.eventsManager.iCreateEvent_Month - 1), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_ArrowRight(tempW - CFG.BUTTON_H, CFG.PADD, CFG.BUTTON_H, CFG.BUTTON_H * 2 / 3){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(GameCalendar.getMonthName(CFG.eventsManager.iCreateEvent_Month + 1), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Text(GameCalendar.getMonthName(CFG.eventsManager.iCreateEvent_Month), -1, CFG.BUTTON_H, CFG.PADD, tempW - CFG.BUTTON_H * 2, CFG.BUTTON_H * 2 / 3){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(GameCalendar.getCurrDate_CreateEvent(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        int tX = 0;
        int tH = CFG.BUTTON_H * 2 / 3 + CFG.PADD * 2;
        for (int i = 0; i < GameCalendar.getNumOfDaysInMonth(CFG.eventsManager.iCreateEvent_Month); ++i) {
            menuElements.add(new Button_CalendarDay(i + 1, CFG.PADD * 2 + CFG.BUTTON_H * 2 / 3 * tX + CFG.PADD * tX++, tH){

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive || CFG.eventsManager.iCreateEvent_Day == this.getCurr() ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? new Color(0.38f, 0.38f, 0.38f, 1.0f) : new Color(0.49f, 0.49f, 0.49f, 0.5f));
                }
            });
            if (tX != 7) continue;
            tH += CFG.PADD + CFG.BUTTON_H / 2;
            tX = 0;
        }
        menuElements.add(new Button_Transparent(0, 0, tempW, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), true));
        this.initMenu(new TitleM(CFG.lang.get("Date"), CFG.BUTTON_H * 3 / 5, true, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, nPosX + iTranslateX, nPosY - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), nWidth - IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth(), this.getHeightT());
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, nPosX + nWidth - IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth() + iTranslateX, nPosY - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), IMGManager.getIMG(Images.gameTopEdgeTitle).getWidth(), this.getHeightT(), true);
                oSB.setColor(new Color(0.05490196f, 0.07058824f, 0.14901961f, 0.775f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - (this.getHeightT() - 2) * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, (this.getHeightT() - 2) * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD * 2 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD * 2, false, true);
                oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
                IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX + 2 + iTranslateX, nPosY - IMGManager.getIMG(Images.pix255).getHeight() * 2, nWidth - 4, IMGManager.getIMG(Images.pix255).getHeight());
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - IMGManager.getIMG(Images.pix255).getHeight() * 2, nWidth - 4, 1);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.8f / 2.0f) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - (int)((float)this.getTextHeight() * 0.8f / 2.0f), Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, CFG.GAMEWIDTH - tempW - CFG.PADD * 2, CFG.BUTTON_H * 3 / 5 + CFG.BUTTON_H * 2 + CFG.PADD * 8, tempW, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, menuElements, false, true);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightM() + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + Core.PADDING, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, CFG.PADD * 3);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void actionEL(int iID) {
        if (iID != this.getMenuElemsSize() - 1) {
            if (iID == 0) {
                GameCalendar.minusMonth_CreateEvent();
                CFG.menus.rebuildCreateScenario_Events_Calendar();
                CFG.menus.updateCreateScenario_Events_Age_Date();
                ArrayList<String> tMess = new ArrayList<String>();
                ArrayList<Color> tColor = new ArrayList<Color>();
                tMess.add(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getName());
                tColor.add(Color.WHITE);
                tMess.add(GameCalendar.getCurrDate_CreateEvent());
                tColor.add(CFG.COLOR_HOVER_TITLE);
                CFG.toastM.addM(tMess, tColor);
            } else if (iID == 1) {
                GameCalendar.plusMonth_CreateEvent();
                CFG.menus.rebuildCreateScenario_Events_Calendar();
                CFG.menus.updateCreateScenario_Events_Age_Date();
                ArrayList<String> tMess = new ArrayList<String>();
                ArrayList<Color> tColor = new ArrayList<Color>();
                tMess.add(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getName());
                tColor.add(Color.WHITE);
                tMess.add(GameCalendar.getCurrDate_CreateEvent());
                tColor.add(CFG.COLOR_HOVER_TITLE);
                CFG.toastM.addM(tMess, tColor);
            } else if (iID == 2) {
                CFG.toastM.addM(GameCalendar.getCurrDate_CreateEvent());
                ArrayList<String> tMess = new ArrayList<String>();
                ArrayList<Color> tColor = new ArrayList<Color>();
                tMess.add(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getName());
                tColor.add(Color.WHITE);
                tMess.add(GameCalendar.getCurrDate_CreateEvent());
                tColor.add(CFG.COLOR_HOVER_TITLE);
                CFG.toastM.addM(tMess, tColor);
            } else {
                CFG.eventsManager.iCreateEvent_Day = iID - 2;
                CFG.menus.updateCreateScenario_Events_Age_Date();
                ArrayList<String> tMess = new ArrayList<String>();
                ArrayList<Color> tColor = new ArrayList<Color>();
                tMess.add(CFG.gameAges.getAge(CFG.eventsManager.iCreateEvent_Age).getName());
                tColor.add(Color.WHITE);
                tMess.add(GameCalendar.getCurrDate_CreateEvent());
                tColor.add(CFG.COLOR_HOVER_TITLE);
                CFG.toastM.addM(tMess, tColor);
            }
        }
    }
}

