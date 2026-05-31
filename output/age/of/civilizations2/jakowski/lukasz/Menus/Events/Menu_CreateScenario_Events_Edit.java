/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Events;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_NewGameBoxStyle_RIGHT_Remove;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Box_CivID;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Left;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Middle;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_NewGameStyle_Right;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.EventTemplatesMGR;
import age.of.civilizations2.jakowski.lukasz.Event_Decision;
import age.of.civilizations2.jakowski.lukasz.Event_SelectCivAction;
import age.of.civilizations2.jakowski.lukasz.Event_Type;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBudgetTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScrollable;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_Events_Edit
extends Menu {
    private String sEventTitle;
    private int iEventTitleWidth = 0;
    private String sPicture;
    private int iPictureWidth = 0;
    private String sSFX;
    private int iSFXWidth = 0;
    private String sMissionDesc;
    private int iMissionDescWidth = 0;
    public String globalEvent = "";

    public Menu_CreateScenario_Events_Edit() {
        int i;
        int tempW = CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH * 3 / 4;
        int tempElemH = CFG.BUTTON_H * 3 / 4;
        this.globalEvent = CFG.lang.get("GlobalEvent");
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tPosY = CFG.PADD;
        menuElements.add(new Button_NewGameStyle_Left(null, -1, CFG.PADD, tPosY, (tempW - CFG.PADD * 2) / 2 + 1, (int)((float)CFG.BUTTON_H * 0.75f), true));
        menuElements.add(new Button_NewGameStyle_Right(null, -1, tempW - (tempW - CFG.PADD * 2) / 2 - CFG.PADD, tPosY, (tempW - CFG.PADD * 2) / 2, (int)((float)CFG.BUTTON_H * 0.75f), true));
        menuElements.add(new Button_NewGameStyle(CFG.eventsManager.createScenarioEvents.getEventName(), CFG.PADD * 2, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, true){

            @Override
            public void buildElemHover() {
                if (this.getTextE().length() > 0) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                Renderer.drawText(oSB, this.fontID, Menu_CreateScenario_Events_Edit.this.sEventTitle, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS);
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
            }

            @Override
            public int getTextPosElem() {
                return super.getTextPosElem() + Menu_CreateScenario_Events_Edit.this.iEventTitleWidth;
            }
        });
        menuElements.add(new Button_In_Game_Box_CivID(CFG.eventsManager.createScenarioEvents.getCivID(), "", CFG.PADD * 2, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, true){

            @Override
            public String getTextToDrawElem() {
                return this.getTextE() + (this.getCurr() > 0 ? ": " + CFG.core.getCiv(this.getCurr()).getCivName() : (this.getCurr() == 0 ? ": " + Menu_CreateScenario_Events_Edit.this.globalEvent : ""));
            }

            @Override
            public void buildElemHover() {
                if (this.getCurr() >= 0) {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Recipient") + ": "));
                        if (this.getCurr() == 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(Menu_CreateScenario_Events_Edit.this.globalEvent, CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Flag_Big(Images.editorMap, CFG.PADD, 0));
                        } else {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(this.getCurr()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Flag_Big(this.getCurr(), CFG.PADD, 0));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException ex) {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SelectCivilization"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                } else {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SelectCivilization"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            }
        });
        menuElements.add(new Button_NewGameStyle_Left(null, -1, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, (tempW - CFG.PADD * 2) / 2 + 1, (int)((float)CFG.BUTTON_H * 0.5f), true));
        menuElements.add(new Button_NewGameStyle_Right(null, -1, tempW - (tempW - CFG.PADD * 2) / 2 - CFG.PADD, tPosY, (tempW - CFG.PADD * 2) / 2, (int)((float)CFG.BUTTON_H * 0.5f), true));
        menuElements.add(new Button_NewGameStyle(CFG.lang.get("Repeatable"), -1, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, true, CFG.eventsManager.createScenarioEvents.getRepeatable()){

            @Override
            public boolean getCheckboxSt() {
                return CFG.eventsManager.createScenarioEvents.getRepeatable();
            }
        });
        menuElements.add(new TextBudgetTitle(CFG.lang.get("Triggers"), -1, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        menuElements.add(new Button_NewGameStyle(CFG.lang.get("AddNewTrigger"), -1, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        for (i = 0; i < CFG.eventsManager.createScenarioEvents.getTriggersSize(); ++i) {
            menuElements.add(new Button_NewGameStyle_Left(CFG.eventsManager.createScenarioEvents.getTrigger(i).getTriggerText(), CFG.PADD * 2, CFG.PADD, tPosY, tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.6f) * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
            menuElements.add(new Button_NewGameStyle_Middle(CFG.eventsManager.getEventTypeText(CFG.eventsManager.createScenarioEvents.getTrigger((int)i).triggerType), -1, tempW - CFG.PADD - (int)((float)CFG.BUTTON_H * 0.6f) * 2, tPosY, (int)((float)CFG.BUTTON_H * 0.6f), (int)((float)CFG.BUTTON_H * 0.6f), true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElements.add(new Button_Game_NewGameBoxStyle_RIGHT_Remove(tempW - CFG.PADD - (int)((float)CFG.BUTTON_H * 0.6f), tPosY, (int)((float)CFG.BUTTON_H * 0.6f), (int)((float)CFG.BUTTON_H * 0.6f), true){

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
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        menuElements.add(new TextBudgetTitle(CFG.lang.get("PopUp"), -1, 0, tPosY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        menuElements.add(new Button_NewGameStyle(CFG.lang.get("ShowPopUp"), -1, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, true, CFG.eventsManager.createScenarioEvents.getEvent_PopUp().showPopUp){

            @Override
            public boolean getCheckboxSt() {
                return CFG.eventsManager.createScenarioEvents.getEvent_PopUp().showPopUp;
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE((int)((float)CFG.BUTTON_H * 0.75f));
        menuElements.add(new TextScrollable(CFG.eventsManager.createScenarioEvents.getEvent_PopUp().sText, CFG.PADD * 2, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 4, (int)((float)CFG.BUTTON_H * 0.6f), CFG.COLOR_NEUTRAL, 1.0f){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Description") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(this.getTextE())));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("You can use a translation key here, like: ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text("myEventDesc1"));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("And put the translation in the mod file: ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text("mods/YOUR_MOD/languages/Bundle.properties"));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("myEventDesc1 = The text description for the event", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Translation") + " File: ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text("mods/YOUR_MOD/languages/Bundle.properties"));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("Translation mod example: ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text("modsExamples/TranslationModExample/"));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void draw_Element(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_BG.r, Colors.COLOR_NOTIFICATION_BG.g, Colors.COLOR_NOTIFICATION_BG.b, this.getIsHovered() || isActive ? 0.5f : 0.25f));
                Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_OVER.r, Colors.COLOR_NOTIFICATION_OVER.g, Colors.COLOR_NOTIFICATION_OVER.b, 0.3f));
                IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_OVER.r, Colors.COLOR_NOTIFICATION_OVER.g, Colors.COLOR_NOTIFICATION_OVER.b, 0.35f));
                IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_OVER.r, Colors.COLOR_NOTIFICATION_OVER.g, Colors.COLOR_NOTIFICATION_OVER.b, 0.3f));
                IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
                IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), CFG.PADD * 2, false, true);
                IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 + iTranslateY, this.getWidthE(), CFG.PADD * 2);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
                Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_BG.r, Colors.COLOR_NOTIFICATION_BG.g, Colors.COLOR_NOTIFICATION_BG.b, 0.25f));
                Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() - 1 + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() + 2, this.getHeightE() + 2, 1.0f);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 + iTranslateY, this.getWidthE(), 1);
                IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), 1);
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_OVER.r, Colors.COLOR_NOTIFICATION_OVER.g, Colors.COLOR_NOTIFICATION_OVER.b, 0.85f));
                IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 + iTranslateY, this.getWidthE(), 1);
                IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 + iTranslateY, this.getWidthE(), 1);
                IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), 1);
                oSB.setColor(new Color(Colors.COLOR_NOTIFICATION_OVER.r, Colors.COLOR_NOTIFICATION_OVER.g, Colors.COLOR_NOTIFICATION_OVER.b, 0.9f));
                IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 + iTranslateY, this.getWidthE(), 1);
                IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE(), 1);
                oSB.setColor(Color.WHITE);
                super.draw_Element(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
            }
        });
        menuElements.add(new Button_NewGameStyle(CFG.eventsManager.createScenarioEvents.getEventPicture(), CFG.PADD * 2, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Path") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + "SCENARIO_TAG/" + "events/"));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Path") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text("UI/events/" + this.getTextE()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("EventAnimationDesc0")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("EventAnimationDesc1")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("EventAnimationDesc2")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("EventAnimationDesc3")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("EventAnimationDesc4")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                Renderer.drawText(oSB, this.fontID, Menu_CreateScenario_Events_Edit.this.sPicture, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS);
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
            }

            @Override
            public int getTextPosElem() {
                return super.getTextPosElem() + Menu_CreateScenario_Events_Edit.this.iPictureWidth;
            }
        });
        menuElements.add(new TextBudgetTitle(CFG.lang.get("Outcomes"), -1, 0, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        menuElements.add(new Button_NewGameStyle(CFG.lang.get("AddNewOutcome"), -1, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, (int)((float)CFG.BUTTON_H * 0.6f), true));
        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        for (i = 0; i < CFG.eventsManager.createScenarioEvents.lDecisions.size(); ++i) {
            menuElements.add(new Button_NewGameStyle_Left(CFG.eventsManager.createScenarioEvents.lDecisions.get((int)i).sTitle, CFG.PADD * 2, CFG.PADD, tPosY, tempW - CFG.PADD * 2 - (int)((float)CFG.BUTTON_H * 0.6f), (int)((float)CFG.BUTTON_H * 0.6f), true));
            menuElements.add(new Button_Game_NewGameBoxStyle_RIGHT_Remove(tempW - CFG.PADD - (int)((float)CFG.BUTTON_H * 0.6f), tPosY, (int)((float)CFG.BUTTON_H * 0.6f), (int)((float)CFG.BUTTON_H * 0.6f), true));
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        menuElements.add(new Button_NewGameStyle(CFG.eventsManager.createScenarioEvents.sEventSFX == null ? "" : CFG.eventsManager.createScenarioEvents.sEventSFX, CFG.PADD * 2, CFG.PADD, tPosY, tempW - CFG.PADD * 2, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Path") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text("audio/" + this.getTextE()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                Renderer.drawText(oSB, this.fontID, Menu_CreateScenario_Events_Edit.this.sSFX, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS);
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
            }

            @Override
            public int getTextPosElem() {
                return super.getTextPosElem() + Menu_CreateScenario_Events_Edit.this.iSFXWidth;
            }
        });
        menuElements.add(new Button_NewGameStyle(CFG.lang.get("Mission"), -1, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, true, CFG.eventsManager.createScenarioEvents.isMission){

            @Override
            public boolean getCheckboxSt() {
                return CFG.eventsManager.createScenarioEvents.isMission;
            }
        });
        menuElements.add(new Button_NewGameStyle(CFG.eventsManager.createScenarioEvents.missionDesc == null ? "" : CFG.eventsManager.createScenarioEvents.missionDesc, CFG.PADD * 2, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Mission") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Description"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                Renderer.drawText(oSB, this.fontID, Menu_CreateScenario_Events_Edit.this.sMissionDesc, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_GRAY_NS);
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
            }

            @Override
            public int getTextPosElem() {
                return super.getTextPosElem() + Menu_CreateScenario_Events_Edit.this.iMissionDescWidth;
            }
        });
        menuElements.add(new Button_NewGameStyle(CFG.lang.get("EventTemplate") + ": " + (CFG.eventsManager.createScenarioEvents.tempTAG == null || CFG.eventsManager.createScenarioEvents.tempTAG.length() == 0 ? CFG.lang.get("Default") : CFG.eventsManager.createScenarioEvents.tempTAG), CFG.PADD * 2, CFG.PADD, tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - CFG.PADD * 2, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EventTemplate")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight() + Core.PADDING, nWidth + 4 + Core.PADDING, this.getHeightT() + Core.PADDING);
                oSB.setColor(new Color(0.78431374f, 0.0f, 0.0f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.78431374f, 0.0f, 0.0f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + (int)((float)nWidth - (float)this.getTextWidth() * 0.8f) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (int)((float)this.getHeightT() - (float)this.getTextHeight() * 0.8f) / 2, Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, CFG.GAMEWIDTH - tempW, CFG.BUTTON_H + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 5, tempW, Math.min(tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.GAMEHEIGHT - (CFG.BUTTON_H + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 5) - CFG.PADD * 2), menuElements);
        this.updateLang();
        this.setVisibleM(false);
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("AddNewEvent"));
        this.sEventTitle = CFG.lang.get("EventTitle") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sEventTitle);
        this.iEventTitleWidth = (int)CFG.glyphLay.width;
        this.sPicture = CFG.lang.get("Picture") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sPicture);
        this.iPictureWidth = (int)CFG.glyphLay.width;
        this.sSFX = CFG.lang.get("Audio") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sSFX);
        this.iSFXWidth = (int)CFG.glyphLay.width;
        this.sMissionDesc = CFG.lang.get("Mission") + ", " + CFG.lang.get("Description") + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sMissionDesc);
        this.iMissionDescWidth = (int)CFG.glyphLay.width;
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("SaveEvent"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Recipient"));
        CFG.eventsManager.iCreateEvent_Day = CFG.eventsManager.createScenarioEvents.getEventDate_Since().iEventDay;
        CFG.eventsManager.iCreateEvent_Month = CFG.eventsManager.createScenarioEvents.getEventDate_Since().iEventMonth;
        CFG.eventsManager.iCreateEvent_Year = CFG.eventsManager.createScenarioEvents.getEventDate_Since().iEventYear;
        this.getMenuElem(4).setTextE(CFG.lang.get("Since") + ": " + (CFG.eventsManager.iCreateEvent_Year == 9999999 ? CFG.lang.get("NoDate") : GameCalendar.getCurrDate_CreateEvent()));
        CFG.eventsManager.iCreateEvent_Day = CFG.eventsManager.createScenarioEvents.getEventDate_Until().iEventDay;
        CFG.eventsManager.iCreateEvent_Month = CFG.eventsManager.createScenarioEvents.getEventDate_Until().iEventMonth;
        CFG.eventsManager.iCreateEvent_Year = CFG.eventsManager.createScenarioEvents.getEventDate_Until().iEventYear;
        this.getMenuElem(5).setTextE(CFG.lang.get("Until") + ": " + (CFG.eventsManager.iCreateEvent_Year == 9999999 ? CFG.lang.get("NoDate") : GameCalendar.getCurrDate_CreateEvent()));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2 + Core.PADDING, this.getHeightM(), false, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM(), this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM(), this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() + this.getHeightM(), this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    private final void saveEditData() {
        CFG.eventsManager.createScenarioEvents.setEventName(this.getMenuElem(2).getTextE());
        CFG.eventsManager.createScenarioEvents.getEvent_PopUp().sText = this.getMenuElem(11 + CFG.eventsManager.createScenarioEvents.getTriggersSize() * 3).getTextE();
        CFG.eventsManager.createScenarioEvents.setEventPicture(this.getMenuElem(12 + CFG.eventsManager.createScenarioEvents.getTriggersSize() * 3).getTextE());
        CFG.eventsManager.createScenarioEvents.sEventSFX = this.getMenuElem(this.getMenuElemsSize() - 4).getTextE();
        CFG.eventsManager.createScenarioEvents.missionDesc = this.getMenuElem(this.getMenuElemsSize() - 2).getTextE();
    }

    @Override
    public void actionEL(int iID) {
        if (iID == this.getMenuElemsSize() - 4) {
            CFG.showKeyboard();
            return;
        }
        if (iID == this.getMenuElemsSize() - 3) {
            CFG.eventsManager.createScenarioEvents.isMission = !CFG.eventsManager.createScenarioEvents.isMission;
            return;
        }
        if (iID == this.getMenuElemsSize() - 2) {
            CFG.showKeyboard();
            return;
        }
        if (iID == this.getMenuElemsSize() - 1) {
            if (!EventTemplatesMGR.eventTemplates.isEmpty()) {
                if (CFG.eventsManager.createScenarioEvents.tempTAG == null) {
                    CFG.eventsManager.createScenarioEvents.tempTAG = "";
                }
                if (CFG.eventsManager.createScenarioEvents.tempTAG.length() == 0 || CFG.eventsManager.createScenarioEvents.tempTAG.equals("")) {
                    CFG.eventsManager.createScenarioEvents.tempTAG = EventTemplatesMGR.eventTemplates.get((int)0).TAG;
                } else {
                    boolean updated = false;
                    try {
                        for (int a = 0; a < EventTemplatesMGR.eventTemplates.size(); ++a) {
                            if (!EventTemplatesMGR.eventTemplates.get((int)a).TAG.equals(CFG.eventsManager.createScenarioEvents.tempTAG)) continue;
                            if (a == EventTemplatesMGR.eventTemplates.size() - 1) {
                                CFG.eventsManager.createScenarioEvents.tempTAG = "";
                                updated = true;
                            } else {
                                CFG.eventsManager.createScenarioEvents.tempTAG = EventTemplatesMGR.eventTemplates.get((int)(a + 1)).TAG;
                                updated = true;
                            }
                            break;
                        }
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    if (!updated) {
                        CFG.eventsManager.createScenarioEvents.tempTAG = "";
                    }
                }
            } else {
                CFG.eventsManager.createScenarioEvents.tempTAG = "";
            }
            this.getMenuElem(iID).setTextE(CFG.lang.get("EventTemplate") + ": " + (CFG.eventsManager.createScenarioEvents.tempTAG == null || CFG.eventsManager.createScenarioEvents.tempTAG.length() == 0 ? CFG.lang.get("Default") : CFG.eventsManager.createScenarioEvents.tempTAG));
            return;
        }
        if (iID >= 9 && iID < 9 + CFG.eventsManager.createScenarioEvents.getTriggersSize() * 3) {
            this.saveEditData();
            if ((iID -= 9) % 3 == 0) {
                CFG.eventsManager.createEvent_EditTriggerID = iID / 3;
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_TRIGGER);
            } else if (iID % 3 == 1) {
                CFG.eventsManager.createEvent_EditTriggerID = iID / 3;
                CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).triggerType = CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).triggerType == Event_Type.AND ? Event_Type.NOT : (CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).triggerType == Event_Type.NOT ? Event_Type.OR : Event_Type.AND);
                this.getMenuElem(iID + 9).setTextE(CFG.eventsManager.getEventTypeText(CFG.eventsManager.createScenarioEvents.getTrigger((int)CFG.eventsManager.createEvent_EditTriggerID).triggerType));
                CFG.toastM.addM(this.getMenuElem(iID + 9).getTextE(), CFG.COLOR_HOVER_TITLE);
            } else {
                CFG.eventsManager.createScenarioEvents.removeTrigger(iID / 3);
                this.saveEditData();
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS);
                CFG.menus.setVisibleCreateScenario_Events_Edit(true);
            }
            return;
        }
        if (iID == 10 + CFG.eventsManager.createScenarioEvents.getTriggersSize() * 3) {
            CFG.eventsManager.createScenarioEvents.getEvent_PopUp().showPopUp = !CFG.eventsManager.createScenarioEvents.getEvent_PopUp().showPopUp;
            return;
        }
        if (iID == 11 + CFG.eventsManager.createScenarioEvents.getTriggersSize() * 3) {
            CFG.showKeyboard();
            return;
        }
        if (iID == 12 + CFG.eventsManager.createScenarioEvents.getTriggersSize() * 3) {
            CFG.showKeyboard();
            return;
        }
        if (iID == 14 + CFG.eventsManager.createScenarioEvents.getTriggersSize() * 3) {
            this.saveEditData();
            CFG.eventsManager.createScenarioEvents.lDecisions.add(new Event_Decision());
            CFG.eventsManager.createEvent_EditTriggerID = CFG.eventsManager.createScenarioEvents.lDecisions.size() - 1;
            CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_DECISION);
            return;
        }
        if (iID >= 15 + CFG.eventsManager.createScenarioEvents.getTriggersSize() * 3) {
            if ((iID -= 15 + CFG.eventsManager.createScenarioEvents.getTriggersSize() * 3) % 2 == 0) {
                this.saveEditData();
                CFG.eventsManager.createEvent_EditTriggerID = iID / 2;
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_DECISION);
            } else {
                this.saveEditData();
                CFG.eventsManager.createEvent_EditTriggerID = iID / 2;
                CFG.eventsManager.createScenarioEvents.lDecisions.remove(CFG.eventsManager.createEvent_EditTriggerID);
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS);
                CFG.menus.setVisibleCreateScenario_Events_Edit(true);
            }
            return;
        }
        switch (iID) {
            case 0: {
                CFG.menus.getKeyboard().setVisibleM(false);
                this.saveEditData();
                CFG.setDialogType(DialogType.CREATE_SCENARIO_EVENTS_EDIT_BACK);
                break;
            }
            case 1: {
                CFG.menus.getKeyboard().setVisibleM(false);
                this.saveEditData();
                CFG.setDialogType(DialogType.CREATE_SCENARIO_EVENTS_EDIT_SAVE);
                break;
            }
            case 2: {
                CFG.showKeyboard();
                break;
            }
            case 3: {
                this.saveEditData();
                CFG.eventsManager.eSelectCivAction = Event_SelectCivAction.SELECT_RECIPENT;
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_SELECT_CIV);
                break;
            }
            case 4: {
                this.saveEditData();
                CFG.eventsManager.setSinceDate = true;
                CFG.eventsManager.iCreateEvent_Day = CFG.eventsManager.createScenarioEvents.getEventDate_Since().iEventDay;
                CFG.eventsManager.iCreateEvent_Month = CFG.eventsManager.createScenarioEvents.getEventDate_Since().iEventMonth;
                CFG.eventsManager.iCreateEvent_Year = CFG.eventsManager.createScenarioEvents.getEventDate_Since().iEventYear;
                CFG.eventsManager.iCreateEvent_Age = CFG.eventsManager.createScenarioEvents.getEventDate_Since().iEventYear == 9999999 ? GameCalendar.CURRENT_AGEID : CFG.gameAges.getAgeOfYear(CFG.eventsManager.createScenarioEvents.getEventDate_Since().iEventYear);
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_DATE);
                CFG.menus.updateCreateScanerio_Events_Slider();
                break;
            }
            case 5: {
                this.saveEditData();
                CFG.eventsManager.setSinceDate = false;
                CFG.eventsManager.iCreateEvent_Day = CFG.eventsManager.createScenarioEvents.getEventDate_Until().iEventDay;
                CFG.eventsManager.iCreateEvent_Month = CFG.eventsManager.createScenarioEvents.getEventDate_Until().iEventMonth;
                CFG.eventsManager.iCreateEvent_Year = CFG.eventsManager.createScenarioEvents.getEventDate_Until().iEventYear;
                CFG.eventsManager.iCreateEvent_Age = CFG.eventsManager.createScenarioEvents.getEventDate_Until().iEventYear == 9999999 ? GameCalendar.CURRENT_AGEID : CFG.gameAges.getAgeOfYear(CFG.eventsManager.createScenarioEvents.getEventDate_Until().iEventYear);
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_DATE);
                CFG.menus.updateCreateScanerio_Events_Slider();
                break;
            }
            case 6: {
                CFG.eventsManager.createScenarioEvents.setRepeatable(!CFG.eventsManager.createScenarioEvents.getRepeatable());
                break;
            }
            case 8: {
                this.saveEditData();
                CFG.eventsManager.createScenarioEvents.addNewTrigger();
                CFG.eventsManager.createEvent_EditTriggerID = CFG.eventsManager.createScenarioEvents.getTriggersSize() - 1;
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_TRIGGER);
            }
        }
    }
}

