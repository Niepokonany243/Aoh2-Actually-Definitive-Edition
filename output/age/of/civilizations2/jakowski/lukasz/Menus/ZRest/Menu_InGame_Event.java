
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_In_Game_Box_Anim;
import age.of.civilizations2.jakowski.lukasz.Button2.Text_Desc2_Special;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
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
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_Event
extends Menu {
    public static final String ANIMATION_TAG = "QQ0.png";
    public static final String ANIMATION_TAG_BEGIN = "QQ";
    public static final String ANIMATION_TAG_END = ".png";
    public static int ANIMATION_IMG_ID = 0;
    public static long ANIMATION_TIME = 0L;
    public static long ANIMATION_IMG_TIME_IN_VIEW = 50L;
    public static int EVENT_ID = 0;
    public static List<Image> eventsIMGs = new ArrayList<Image>();
    private String sEventDate = "";
    private int iEventDateWidth = 0;

    public Menu_InGame_Event(int tInit) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = (int)(512.0f * CFG.GUI_SCALE) + CFG.PADD * 2;
        if (tempWidth > CFG.GAMEWIDTH) {
            tempWidth = CFG.GAMEWIDTH - CFG.PADD * 4;
        }
        int tempMenuPosY = IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 4 / 5 + CFG.PADD * 2;
        this.initMenu(null, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, 5, menuElements, false, false);
    }

    public Menu_InGame_Event() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = (int)(512.0f * CFG.GUI_SCALE) + CFG.PADD * 2;
        if (tempWidth > CFG.GAMEWIDTH) {
            tempWidth = CFG.GAMEWIDTH - CFG.PADD * 4;
        }
        int tY = CFG.PADD;
        menuElements.add(new Button_Transparent(CFG.PADD, tY, tempWidth - CFG.PADD * 2, (int)(96.0f * CFG.GUI_SCALE), true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).getEvent_PopUp().sText != null && CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).getEvent_PopUp().sText.length() > 0) {
            menuElements.add(new Text_Desc2_Special(CFG.lang.get(CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).getEvent_PopUp().sText), CFG.PADD, tY, tempWidth - CFG.PADD * 2){

                @Override
                protected Color getColor(boolean isActive) {
                    return Colors.getColorButton(isActive, this.getIsHovered());
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
        } else {
            menuElements.add(new Button_Transparent(CFG.PADD, tY, 1, 1, true));
        }
        for (int i = 0; i < CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).lDecisions.size(); ++i) {
            menuElements.add(new Button_In_Game_Box_Anim(CFG.lang.get(CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).lDecisions.get((int)i).sTitle), -1, CFG.PADD, tY, tempWidth - CFG.PADD * 2, CFG.BUTTON_H / 2, true){
                int iCurrent;
                {
                    this.iCurrent = 0;
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
                }

                @Override
                public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, this.getIsHovered() ? 1.0f : 0.8f));
                    super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
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
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        Menu_InGame_Event.loadEventIMG();
        try {
            if (!eventsIMGs.isEmpty()) {
                int tPosY = (int)((float)eventsIMGs.get(0).getHeight() * CFG.GUI_SCALE);
                ((MenuElemUI)menuElements.get(0)).setHeightE((int)((float)eventsIMGs.get(0).getHeight() * CFG.GUI_SCALE));
                tPosY += CFG.PADD * 2;
                for (int i = 1; i < menuElements.size(); ++i) {
                    ((MenuElemUI)menuElements.get(i)).setPosY(tPosY);
                    tPosY += ((MenuElemUI)menuElements.get(i)).getHeightE() + CFG.PADD;
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        int tempMenuPosY = IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 4 / 5 + CFG.PADD * 2;
        this.initMenu(new TitleM_TextSmall("", CFG.BUTTON_H * 4 / 5, true, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.06666667f, 0.3764706f, 0.7529412f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.06666667f, 0.3764706f, 0.7529412f, 0.375f));
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
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().drawO(oSB, nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(Images.flagRectSmall).getWidth() + CFG.PADD)) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() / 2 - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().getHeight(), CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(Images.flagRectSmall).getWidth() + CFG.PADD)) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.flagRectSmall).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(Images.flagRectSmall).getWidth() + CFG.PADD)) / 2 + IMGManager.getIMG(Images.flagRectSmall).getWidth() + CFG.PADD + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, false);
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
        try {
            this.getTitleM().setText(CFG.lang.get(CFG.eventsManager.getEvent(EVENT_ID).getEventName()));
        }
        catch (Exception ex) {
            try {
                this.getTitleM().setText(CFG.lang.get("Event"));
            }
            catch (NullPointerException nullPointerException) {
                
            }
        }
        try {
            if (CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).getEventDate_Until().iEventYear == 9999999) {
                if (CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).getEventDate_Since().iEventYear == 9999999) {
                    this.sEventDate = GameCalendar.getCurrDate();
                } else {
                    CFG.eventsManager.iCreateEvent_Day = CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).getEventDate_Since().iEventDay;
                    CFG.eventsManager.iCreateEvent_Month = CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).getEventDate_Since().iEventMonth;
                    CFG.eventsManager.iCreateEvent_Year = CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).getEventDate_Since().iEventYear;
                    this.sEventDate = GameCalendar.getCurrDate_CreateEvent();
                }
            } else {
                this.sEventDate = GameCalendar.getCurrDate();
            }
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sEventDate);
            this.iEventDateWidth = (int)CFG.glyphLay.width;
        }
        catch (Exception exception) {
            
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2 + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        try {
            if (this.getMenuElem(0).getIsHovered()) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.9f));
            }
            if (eventsIMGs.size() == 1) {
                eventsIMGs.get(0).draw(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() / 2 - (int)((float)eventsIMGs.get(0).getWidth() * CFG.GUI_SCALE) / 2 + iTranslateX, this.getPosY() + this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE() / 2 - (int)((float)eventsIMGs.get(0).getHeight() * CFG.GUI_SCALE) / 2 + iTranslateY, (int)((float)eventsIMGs.get(0).getWidth() * CFG.GUI_SCALE), (int)((float)eventsIMGs.get(0).getHeight() * CFG.GUI_SCALE));
            } else {
                eventsIMGs.get(ANIMATION_IMG_ID).draw(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() / 2 - (int)((float)eventsIMGs.get(ANIMATION_IMG_ID).getWidth() * CFG.GUI_SCALE) / 2 + iTranslateX, this.getPosY() + this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE() / 2 - (int)((float)eventsIMGs.get(ANIMATION_IMG_ID).getHeight() * CFG.GUI_SCALE) / 2 + iTranslateY, (int)((float)eventsIMGs.get(ANIMATION_IMG_ID).getWidth() * CFG.GUI_SCALE), (int)((float)eventsIMGs.get(ANIMATION_IMG_ID).getHeight() * CFG.GUI_SCALE));
                if (System.currentTimeMillis() >= ANIMATION_TIME + ANIMATION_IMG_TIME_IN_VIEW) {
                    if (++ANIMATION_IMG_ID >= eventsIMGs.size()) {
                        ANIMATION_IMG_ID = 0;
                    }
                    ANIMATION_TIME = System.currentTimeMillis();
                }
            }
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + iTranslateX, this.getPosY() + this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getMenuElem(0).getWidthE(), CFG.TEXT_HEIGHT_DEFAULT_SMALL + CFG.PADD * 2);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.75f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + iTranslateX, this.getPosY() + this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getMenuElem(0).getWidthE() / 3, CFG.TEXT_HEIGHT_DEFAULT_SMALL + CFG.PADD * 2);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() - this.getMenuElem(0).getWidthE() / 3 + iTranslateX, this.getPosY() + this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getMenuElem(0).getWidthE() / 3, CFG.TEXT_HEIGHT_DEFAULT_SMALL + CFG.PADD * 2, true, false);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + iTranslateX, this.getPosY() + CFG.TEXT_HEIGHT_DEFAULT_SMALL + CFG.PADD * 2 - 1 + this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getMenuElem(0).getWidthE() / 3, 1);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() - this.getMenuElem(0).getWidthE() / 3 + iTranslateX, this.getPosY() + CFG.TEXT_HEIGHT_DEFAULT_SMALL + CFG.PADD * 2 - 1 + this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getMenuElem(0).getWidthE() / 3, 1, true, false);
            oSB.setColor(Color.WHITE);
            if (CFG.eventsManager.getEvent(EVENT_ID).getCivID() > 0 && CFG.eventsManager.getEvent(EVENT_ID).getCivID() < CFG.core.getCivsSize() && CFG.core.getCiv(CFG.eventsManager.getEvent(EVENT_ID).getCivID()).getCapitalProvID() >= 0 && CFG.core.getProv(CFG.core.getCiv(CFG.eventsManager.getEvent(EVENT_ID).getCivID()).getCapitalProvID()).getCitSize() > 0) {
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, CFG.core.getProv(CFG.core.getCiv(CFG.eventsManager.getEvent(EVENT_ID).getCivID()).getCapitalProvID()).getCit(0).getCityName(), this.getPosX() + this.getMenuElem(0).getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getMenuElem(0).getPosY() + CFG.PADD + iTranslateY, new Color(1.0f, 1.0f, 1.0f, 0.8f));
            }
            Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sEventDate, this.getPosX() + this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() - CFG.PADD - this.iEventDateWidth + iTranslateX, this.getPosY() + this.getMenuElem(0).getPosY() + CFG.PADD + iTranslateY, new Color(1.0f, 1.0f, 1.0f, 0.8f));
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

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.toastM.addM(this.getTitleM().getText(), CFG.COLOR_HOVER_TITLE);
                return;
            }
            case 1: {
                CFG.toastM.addM(CFG.lang.get(CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).getEvent_PopUp().sText), CFG.COLOR_HOVER_TITLE);
                return;
            }
        }
        CFG.toastM.addM(this.getMenuElem(iID).getTextE(), CFG.COLOR_NEUTRAL2);
        iID -= 2;
        try {
            if (CFG.eventsManager.getEvent(EVENT_ID).getCivID() >= 0) {
                CFG.core.getCiv(CFG.eventsManager.getEvent(EVENT_ID).getCivID()).addEventDecisionTaken(CFG.eventsManager.getEvent(EVENT_ID).getEventTag() + "_" + iID);
            }
            CFG.eventsManager.getEvent((int)Menu_InGame_Event.EVENT_ID).lDecisions.get(iID).executeDecision();
        }
        catch (Exception exception) {
            
        }
        CFG.menus.setVisibleInGame_Event(false);
        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).runNextEvent2();
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (!visible) {
            try {
                if (!eventsIMGs.isEmpty()) {
                    for (int i = eventsIMGs.size() - 1; i >= 0; --i) {
                        eventsIMGs.get(i).getTexture().dispose();
                        eventsIMGs.remove(i);
                    }
                }
                eventsIMGs.clear();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public static void loadEventIMG() {
        block14: {
            try {
                if (CFG.eventsManager.getEvent(EVENT_ID).getEventPicture().length() == 0) {
                    eventsIMGs.add(new Image(new Texture(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().sActiveScenarioTag + "/" + "events/" + "default.png")), Texture.TextureFilter.Linear));
                    break block14;
                }
                if (CFG.eventsManager.getEvent(EVENT_ID).getEventPicture().contains(ANIMATION_TAG)) {
                    String imgName = CFG.eventsManager.getEvent(EVENT_ID).getEventPicture().substring(0, CFG.eventsManager.getEvent(EVENT_ID).getEventPicture().length() - ANIMATION_TAG.length());
                    if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().sActiveScenarioTag + "/" + "events/" + CFG.eventsManager.getEvent(EVENT_ID).getEventPicture()).exists()) {
                        String path = "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().sActiveScenarioTag + "/" + "events/";
                        for (int a = 0; a < GameValues.gvInGame.EVENT_ANIMATION_IMAGES_LIMIT; ++a) {
                            if (!FileManager.loadFile(path + imgName + ANIMATION_TAG_BEGIN + a + ANIMATION_TAG_END).exists()) continue;
                            eventsIMGs.add(new Image(new Texture(FileManager.loadFile(path + imgName + ANIMATION_TAG_BEGIN + a + ANIMATION_TAG_END)), Texture.TextureFilter.Linear));
                        }
                    } else if (FileManager.loadFile("UI/events/" + CFG.eventsManager.getEvent(EVENT_ID).getEventPicture()).exists()) {
                        String path = "UI/events/";
                        for (int a = 0; a < GameValues.gvInGame.EVENT_ANIMATION_IMAGES_LIMIT; ++a) {
                            if (!FileManager.loadFile(path + imgName + ANIMATION_TAG_BEGIN + a + ANIMATION_TAG_END).exists()) continue;
                            eventsIMGs.add(new Image(new Texture(FileManager.loadFile(path + imgName + ANIMATION_TAG_BEGIN + a + ANIMATION_TAG_END)), Texture.TextureFilter.Linear));
                        }
                    }
                }
                if (eventsIMGs.isEmpty()) {
                    eventsIMGs.add(new Image(new Texture(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().sActiveScenarioTag + "/" + "events/" + CFG.eventsManager.getEvent(EVENT_ID).getEventPicture())), Texture.TextureFilter.Linear));
                }
            }
            catch (GdxRuntimeException ex) {
                try {
                    eventsIMGs.add(new Image(new Texture(FileManager.loadFile("UI/events/" + CFG.eventsManager.getEvent(EVENT_ID).getEventPicture())), Texture.TextureFilter.Linear));
                }
                catch (GdxRuntimeException exr) {
                    try {
                        eventsIMGs.add(new Image(new Texture(FileManager.loadFile("UI/events/default.png")), Texture.TextureFilter.Linear));
                    }
                    catch (GdxRuntimeException exre) {
                        eventsIMGs.clear();
                    }
                }
            }
        }
        ANIMATION_IMG_ID = 0;
        ANIMATION_TIME = System.currentTimeMillis();
    }
}

