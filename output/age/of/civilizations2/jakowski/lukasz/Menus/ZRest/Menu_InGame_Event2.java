
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.EventTemplatesMGR;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_Event;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_Event2
extends Menu {
    public static int TLID = 0;

    public Menu_InGame_Event2() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = (int)(512.0f * CFG.GUI_SCALE) + CFG.PADD * 2;
        if (tempWidth > CFG.GAMEWIDTH) {
            tempWidth = CFG.GAMEWIDTH - CFG.PADD * 4;
        }
        int tY = CFG.PADD;
        Menu_InGame_Event2.loadEventIMG();
        menuElements.add(new Text(CFG.lang.get(CFG.eventsManager.getEvent(Menu_InGame_Event.EVENT_ID).getEventName()), -1, EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).titlePosX, EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).titlePosY, EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).titleWidth, EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).titleHeight, CFG.FONT_BOLD){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawText(oSB, this.fontID, this.sText, this.getPosXE() + this.textPosition.getTextPosition() + iTranslateX, this.getPosY() + (this.getHeightE() - this.getTextHeight()) / 2 + iTranslateY, new Color((float)EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).titleColor[0] / 255.0f, (float)EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).titleColor[1] / 255.0f, (float)EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).titleColor[2] / 255.0f, 1.0f));
            }
        });
        if (CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).getEvent_PopUp().sText != null && CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).getEvent_PopUp().sText.length() > 0) {
            menuElements.add(new Text_Desc(CFG.lang.get(CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).getEvent_PopUp().sText), EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).descPosX, EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).descPosY, EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).descWidth){

                @Override
                protected Color getColor(boolean isActive) {
                    return new Color((float)EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).descColor[0] / 255.0f, (float)EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).descColor[1] / 255.0f, (float)EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).descColor[2] / 255.0f, 1.0f);
                }

                @Override
                public void drawBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
        } else {
            menuElements.add(new Button_Transparent(CFG.PADD, tY, 1, 1, true));
        }
        tY = EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).btnPosY;
        for (int i = 0; i < CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).lDecisions.size(); ++i) {
            menuElements.add(new Button_InGameBox(CFG.lang.get(CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).lDecisions.get((int)i).sTitle), -1, EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).btnPosX, tY, EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).btnWidth, EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).btnHeight, true){
                int iCurrent;
                {
                    this.iCurrent = 0;
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : new Color((float)EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).btnColor[0] / 255.0f, (float)EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).btnColor[1] / 255.0f, (float)EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).btnColor[2] / 255.0f, 1.0f)) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }

                @Override
                public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    oSB.setColor(Color.WHITE);
                    int nPosX = this.getPosXE() + iTranslateX;
                    int nPosY = this.getPosY() + iTranslateY;
                    int nWidth = this.getWidthE();
                    int nHeight = this.getHeightE();
                    int iHCeil = (nHeight + 1) / 2;
                    int iHFloor = nHeight / 2;
                    nWidth = Math.max(nWidth, EventTemplatesMGR.btnTemplates.get(TLID).getWidth() * 2);
                    EventTemplatesMGR.btnTemplates.get(TLID).draw2(oSB, nPosX, nPosY, nWidth - EventTemplatesMGR.btnTemplates.get(TLID).getWidth(), iHCeil);
                    EventTemplatesMGR.btnTemplates.get(TLID).draw2(oSB, nPosX + nWidth - EventTemplatesMGR.btnTemplates.get(TLID).getWidth(), nPosY, EventTemplatesMGR.btnTemplates.get(TLID).getWidth(), iHCeil, true);
                    EventTemplatesMGR.btnTemplates.get(TLID).draw2(oSB, nPosX, nPosY + iHCeil, nWidth - EventTemplatesMGR.btnTemplates.get(TLID).getWidth(), iHFloor, false, true);
                    EventTemplatesMGR.btnTemplates.get(TLID).draw2(oSB, nPosX + nWidth - EventTemplatesMGR.btnTemplates.get(TLID).getWidth(), nPosY + iHCeil, EventTemplatesMGR.btnTemplates.get(TLID).getWidth(), iHFloor, true, true);
                    oSB.setColor(Color.WHITE);
                }

                @Override
                public int getCurr() {
                    return this.iCurrent;
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.iCurrent = nCurrent;
                }

                @Override
                public void actionElem(int iID) {
                    try {
                        if (CFG.eventsManager.getEvent(Menu_InGame_Event.EVENT_ID).getCivID() >= 0) {
                            CFG.core.getCiv(CFG.eventsManager.getEvent(Menu_InGame_Event.EVENT_ID).getCivID()).addEventDecisionTaken(CFG.eventsManager.getEvent(Menu_InGame_Event.EVENT_ID).getEventTag() + "_" + this.getCurr());
                        }
                        CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).lDecisions.get(this.getCurr()).executeDecision();
                    }
                    catch (Exception exception) {
                        
                    }
                    Menu_InGame_Event2.this.setVisibleM(false);
                    CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).runNextEvent2();
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploMessage, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    try {
                        if (CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).lDecisions.get((int)this.getCurr()).sDesc != null && CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).lDecisions.get((int)this.getCurr()).sDesc.length() > 0) {
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get(CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).lDecisions.get((int)this.getCurr()).sDesc)));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    }
                    catch (Exception exception) {
                        
                    }
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int i = 0; i < CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).lDecisions.get((int)this.getCurr()).lOutcomes.size(); ++i) {
                        List<MEHover_2E> tempElements = CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).lDecisions.get((int)this.getCurr()).lOutcomes.get(i).getHoverText();
                        for (int j = 0; j < tempElements.size(); ++j) {
                            nElements.add(tempElements.get(j));
                        }
                        tempElements.clear();
                        tempElements = null;
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
            if (EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).nextButtonBelow) {
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
                continue;
            }
            tY += -CFG.PADD - EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).btnHeight;
        }
        menuElements.add(new Button_Transparent(0, 0, EventTemplatesMGR.bgTemplates.get(TLID).getWidth(), EventTemplatesMGR.bgTemplates.get(TLID).getHeight(), false, 0));
        int tempMenuPosY = IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 4 / 5 + CFG.PADD * 2;
        this.initMenu(null, CFG.GAMEWIDTH / 2 - EventTemplatesMGR.bgTemplates.get(TLID).getWidth() / 2, tempMenuPosY, EventTemplatesMGR.bgTemplates.get(TLID).getWidth(), Math.max(((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, EventTemplatesMGR.bgTemplates.get(TLID).getHeight()), menuElements, true, false);
        this.updateLang();
        try {
            if (CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).sEventSFX != null && CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).sEventSFX.length() > 0) {
                CFG.SFXManager.loadNextMusic(CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).sEventSFX);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        EventTemplatesMGR.bgTemplates.get(TLID).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        try {
            if (Menu_InGame_Event.eventsIMGs.size() == 1) {
                Menu_InGame_Event.eventsIMGs.get(0).draw(oSB, this.getPosX() + EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).imgPosX + iTranslateX, this.getPosY() + EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).imgPosY + iTranslateY, EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).imgWidth, EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).imgHeight);
            } else {
                Menu_InGame_Event.eventsIMGs.get(Menu_InGame_Event.ANIMATION_IMG_ID).draw(oSB, this.getPosX() + EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).imgPosX + iTranslateX, this.getPosY() + EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).imgPosY + iTranslateY, EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).imgWidth, EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).imgHeight);
                if (System.currentTimeMillis() >= Menu_InGame_Event.ANIMATION_TIME + Menu_InGame_Event.ANIMATION_IMG_TIME_IN_VIEW) {
                    if (++Menu_InGame_Event.ANIMATION_IMG_ID >= Menu_InGame_Event.eventsIMGs.size()) {
                        Menu_InGame_Event.ANIMATION_IMG_ID = 0;
                    }
                    Menu_InGame_Event.ANIMATION_TIME = System.currentTimeMillis();
                }
            }
        }
        catch (Exception exception) {
            
        }
        oSB.setColor(Color.WHITE);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    public static void loadEventIMG() {
        block18: {
            try {
                if (CFG.eventsManager.getEvent(Menu_InGame_Event.EVENT_ID).getEventPicture().length() == 0) {
                    try {
                        Menu_InGame_Event.eventsIMGs.add(new Image(new Texture(FileManager.loadFile("UI/events/templates/" + EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).DEFAULT_IMG)), Texture.TextureFilter.Linear));
                    }
                    catch (Exception ex) {
                        Menu_InGame_Event.eventsIMGs.add(new Image(new Texture(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().sActiveScenarioTag + "/" + "events/" + "default.png")), Texture.TextureFilter.Linear));
                    }
                    break block18;
                }
                if (CFG.eventsManager.getEvent(Menu_InGame_Event.EVENT_ID).getEventPicture().contains("QQ0.png")) {
                    String imgName = CFG.eventsManager.getEvent(Menu_InGame_Event.EVENT_ID).getEventPicture().substring(0, CFG.eventsManager.getEvent(Menu_InGame_Event.EVENT_ID).getEventPicture().length() - "QQ0.png".length());
                    if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().sActiveScenarioTag + "/" + "events/" + CFG.eventsManager.getEvent(Menu_InGame_Event.EVENT_ID).getEventPicture()).exists()) {
                        String path = "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().sActiveScenarioTag + "/" + "events/";
                        for (int a = 0; a < GameValues.gvInGame.EVENT_ANIMATION_IMAGES_LIMIT; ++a) {
                            if (!FileManager.loadFile(path + imgName + "QQ" + a + ".png").exists()) continue;
                            Menu_InGame_Event.eventsIMGs.add(new Image(new Texture(FileManager.loadFile(path + imgName + "QQ" + a + ".png")), Texture.TextureFilter.Linear));
                        }
                    } else if (FileManager.loadFile("UI/events/" + CFG.eventsManager.getEvent(Menu_InGame_Event.EVENT_ID).getEventPicture()).exists()) {
                        String path = "UI/events/";
                        for (int a = 0; a < GameValues.gvInGame.EVENT_ANIMATION_IMAGES_LIMIT; ++a) {
                            if (!FileManager.loadFile(path + imgName + "QQ" + a + ".png").exists()) continue;
                            Menu_InGame_Event.eventsIMGs.add(new Image(new Texture(FileManager.loadFile(path + imgName + "QQ" + a + ".png")), Texture.TextureFilter.Linear));
                        }
                    }
                }
                if (Menu_InGame_Event.eventsIMGs.isEmpty()) {
                    Menu_InGame_Event.eventsIMGs.add(new Image(new Texture(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().sActiveScenarioTag + "/" + "events/" + CFG.eventsManager.getEvent(Menu_InGame_Event.EVENT_ID).getEventPicture())), Texture.TextureFilter.Linear));
                }
            }
            catch (GdxRuntimeException ex) {
                try {
                    Menu_InGame_Event.eventsIMGs.add(new Image(new Texture(FileManager.loadFile("UI/events/" + CFG.eventsManager.getEvent(Menu_InGame_Event.EVENT_ID).getEventPicture())), Texture.TextureFilter.Linear));
                }
                catch (GdxRuntimeException exr) {
                    try {
                        try {
                            Menu_InGame_Event.eventsIMGs.add(new Image(new Texture(FileManager.loadFile("UI/events/templates/" + EventTemplatesMGR.eventTemplates.get((int)Menu_InGame_Event2.TLID).DEFAULT_IMG)), Texture.TextureFilter.Linear));
                        }
                        catch (Exception exrz) {
                            Menu_InGame_Event.eventsIMGs.add(new Image(new Texture(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().sActiveScenarioTag + "/" + "events/" + "default.png")), Texture.TextureFilter.Linear));
                        }
                    }
                    catch (GdxRuntimeException exre) {
                        Menu_InGame_Event.eventsIMGs.clear();
                    }
                }
            }
        }
        Menu_InGame_Event.ANIMATION_IMG_ID = 0;
        Menu_InGame_Event.ANIMATION_TIME = System.currentTimeMillis();
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            try {
                if (!Menu_InGame_Event.eventsIMGs.isEmpty()) {
                    for (int i = Menu_InGame_Event.eventsIMGs.size() - 1; i >= 0; --i) {
                        Menu_InGame_Event.eventsIMGs.get(i).getTexture().dispose();
                        Menu_InGame_Event.eventsIMGs.remove(i);
                    }
                }
                Menu_InGame_Event.eventsIMGs.clear();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }
}

