/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Victory;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Speed;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Speed_Right;
import age.of.civilizations2.jakowski.lukasz.Button.Button_VictoryStats;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_2;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.Timelapse.TimelapseManager;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Victory
extends Menu {
    public static boolean VICTORIOUS = false;
    public static final int ANIMATION_TIME = 1000;
    private long lTime = 0L;
    public static final int ANIMATION_TIME_TOP = 725;
    private long lTimeTOP = 0L;
    public static final int ANIMATION_TIME_TOP2 = 2750;
    private long lTimeTOP2 = 0L;
    public boolean backAnimation = false;
    public boolean hideTop = false;
    private String sTopText;
    private int iTopTextWidth = 0;
    private String sTopTextDate;
    private int iTopTextDateWidth = 0;
    public Color topColorBG;

    public Menu_Victory(boolean VICTORIOUS) {
        Menu_Victory.VICTORIOUS = VICTORIOUS;
        this.sTopText = VICTORIOUS ? CFG.lang.get("Victory") : CFG.lang.get("Defeat");
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD), this.sTopText);
        this.iTopTextWidth = (int)CFG.glyphLay.width;
        this.sTopTextDate = GameCalendar.getDate_ByTurnID(1) + " - " + GameCalendar.getCurrDate();
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), this.sTopTextDate);
        this.iTopTextDateWidth = (int)CFG.glyphLay.width;
        this.topColorBG = VICTORIOUS ? Color.WHITE : CFG.COLOR_NEGATIVE_2;
        this.backAnimation = false;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Text(null, 0, 0, CFG.PADD, IMGManager.getIMG(Images.topBar).getHeight(), (float)CFG.FONT_BOLD_SMALL){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + 1 + iTranslateY, this.getColor(isActive));
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER : CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
            }

            @Override
            public int getPosY() {
                return CFG.GAMEHEIGHT - this.getHeightE();
            }

            @Override
            public int getWidthE() {
                return Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 2, (int)((float)this.getTextWidthU() * 0.8f) + CFG.PADD * 4);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Text("Date", 0, 0, CFG.PADD, IMGManager.getIMG(Images.topBar).getHeight(), CFG.FONT_BOLD_SMALL){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + iTranslateY, this.getColor(isActive));
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_CIV_NAME_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_NAME_HOVERED : CFG.COLOR_TEXT_CIV_NAME) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getPosXE() {
                return CFG.GAMEWIDTH - IMGManager.getIMG(Images.topBar).getHeight() - CFG.PADD - Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 2, this.getTextWidthU() + CFG.PADD * 6);
            }

            @Override
            public int getWidthE() {
                return Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 2, this.getTextWidthU() + CFG.PADD * 6);
            }

            @Override
            public int getHeightE() {
                return (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.8f) + CFG.PADD;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                if (TimelapseManager.PAUSE) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ClickToUnpause"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ClickToPause"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.getIsDesktop()) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("ENTER", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        int tempTurnH = IMGManager.getIMG(Images.topBar).getHeight() - CFG.PADD * 3 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.8f);
        for (int i = 0; i < 60 && !((float)CFG.TEXT_HEIGHT_DEFAULT * Menu_InGame_2.fTurnScale <= (float)tempTurnH); ++i) {
            Menu_InGame_2.fTurnScale -= 0.01f;
        }
        menuElements.add(new Text("Turn", 0, 0, CFG.PADD * 2 + CFG.TEXT_HEIGHT_DEFAULT, IMGManager.getIMG(Images.topBar).getHeight()){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + (this.getWidthE() - this.getTextWidthU()) / 2 + iTranslateX, this.getPosY() + iTranslateY, this.getColor(isActive));
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_RANK_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_RANK_HOVER : CFG.COLOR_TEXT_RANK) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getPosXE() {
                return Menu_Victory.this.getMenuElem(1).getPosXE();
            }

            @Override
            public int getWidthE() {
                return Menu_Victory.this.getMenuElem(1).getWidthE();
            }

            @Override
            public int getHeightE() {
                return CFG.TEXT_HEIGHT_DEFAULT;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                if (TimelapseManager.PAUSE) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ClickToUnpause"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                } else {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ClickToPause"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.getIsDesktop()) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("ENTER", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }
        });
        menuElements.add(new Button_Speed("-", -1, 0, 0, IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD, IMGManager.getIMG(Images.topBar).getHeight() - 2, true){

            @Override
            public int getPosXE() {
                return Menu_Victory.this.getMenuElem(1).getPosXE() - this.getWidthE();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DecreaseSpeed"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.getIsDesktop()) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("-", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }
        });
        menuElements.add(new Button_Speed_Right("+", -1, 0, 0, IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD, IMGManager.getIMG(Images.topBar).getHeight() - 2, true){

            @Override
            public int getPosXE() {
                return CFG.GAMEWIDTH - this.getWidthE();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncreaseSpeed"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.getIsDesktop()) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }
        });
        menuElements.add(new Button_VictoryStats(CFG.lang.get("Income") + ": ", CFG.getNumberWthSpaces("75148"), CFG.COLOR_GOLD, Images.topGold(), 0, CFG.GAMEHEIGHT - ((MenuElemUI)menuElements.get(0)).getHeightE() - CFG.PADD * 2 - Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2), CFG.CIV_INFO_MENU_WIDTH * 3 / 4, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2), true));
        menuElements.add(new Button_VictoryStats(CFG.lang.get("Provinces") + ": ", "4", CFG.COLOR_TEXT_NUM_OF_PROVINCES, Images.provinces, 0, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() - Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2), CFG.CIV_INFO_MENU_WIDTH * 3 / 4, Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2), true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.lTime = System.currentTimeMillis();
        this.lTimeTOP = System.currentTimeMillis();
        this.lTimeTOP2 = 0L;
        TimelapseManager.SPEED = 6;
        CFG.timelapseManager.pauseUnpause();
        CFG.map.getMpC().centerToCivilizationBox_Timeline(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), false);
        this.updateLang();
        this.getMenuElem(5).setCurr(0);
        this.getMenuElem(6).setCurr(1);
    }

    @Override
    public void updateLang() {
        this.getMenuElem(1).setTextE(GameCalendar.getDate_ByTurnID(CFG.timelapseManager.iTimelineTurnID + 1));
        this.getMenuElem(2).setTextE(CFG.lang.get("Turn") + ": " + (CFG.timelapseManager.iTimelineTurnID + 1));
        this.getMenuElem(0).setTextE(CFG.lang.get("Continue"));
        this.updateTurnData();
    }

    public void updateTurnData() {
        this.getMenuElem(5).setTextE(CFG.getNumberWthSpaces("" + CFG.timelapseManager.getPlayerIncome(CFG.PLAYER_TURN_ID, CFG.timelapseManager.iTimelineTurnID)));
        this.getMenuElem(6).setTextE(CFG.getNumberWthSpaces("" + CFG.timelapseManager.getNumOfProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.setRenderO(true);
        if (!TimelapseManager.PAUSE) {
            CFG.timelapseManager.updateTime();
            this.updateTurnData();
        }
        if (this.lTime + 1000L >= System.currentTimeMillis()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.05f + 0.325f * ((float)(System.currentTimeMillis() - this.lTime) / 1000.0f)));
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.375f));
        }
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthM(), this.getTopHeight());
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - this.getTopHeight() / 4 - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthM(), this.getTopHeight() / 4, false, true);
        if (this.lTime + 1000L >= System.currentTimeMillis()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.05f + 0.075f * ((float)(System.currentTimeMillis() - this.lTime) / 1000.0f)));
            CFG.setRenderO(true);
        } else {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.125f));
        }
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getTopHeight() / 2, this.getHeightM());
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + this.getWidthM() - this.getTopHeight() / 4 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getTopHeight() / 4, this.getHeightM(), true, false);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.125f));
        IMGManager.getIMG(Images.gameLogo).drawO(oSB, this.getPosX() + this.getWidthM() - CFG.PADD - IMGManager.getIMG(Images.gameLogo).getWidth() + iTranslateX, this.getPosY() + this.getHeightM() - CFG.PADD - IMGManager.getIMG(Images.gameLogo).getHeight());
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(3).getPosXE() - CFG.topBox.topBarPaddingRight + iTranslateX, this.getMenuElem(3).getPosY() + iTranslateY, CFG.GAMEWIDTH - (this.getMenuElem(3).getPosXE() - CFG.topBox.topBarPaddingRight), IMGManager.getIMG(Images.topBar).getHeight());
        IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(3).getPosXE() - CFG.topBox.topBarPaddingRight + iTranslateX, this.getMenuElem(3).getPosY() + iTranslateY, CFG.GAMEWIDTH - (this.getMenuElem(3).getPosXE() - CFG.topBox.topBarPaddingRight), IMGManager.getIMG(Images.topBar).getHeight());
        Menu_Victory.draw_Time(oSB, this.getMenuElem(1).getPosXE() + iTranslateX, 0, this.getMenuElem(1).getWidthE(), IMGManager.getIMG(Images.topBar).getHeight() - 2 - CFG.PADD);
        int tSpeedWidth = (this.getMenuElem(1).getWidthE() - CFG.PADD * 5) / 6;
        int tX = (this.getMenuElem(1).getWidthE() - tSpeedWidth * 6 - CFG.PADD * 5) / 2;
        for (int i = 0; i < TimelapseManager.SPEED; ++i) {
            Menu_InGame_2.draw_Speed(oSB, tX + this.getMenuElem(1).getPosXE() + (tSpeedWidth + CFG.PADD) * i + iTranslateX, IMGManager.getIMG(Images.topBar).getHeight() - 2 - CFG.PADD, tSpeedWidth, CFG.PADD);
        }
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(0).getPosXE() + iTranslateX, this.getMenuElem(0).getPosY() + iTranslateY, this.getMenuElem(0).getWidthE() + CFG.topBox.topBarPaddingRight, IMGManager.getIMG(Images.topBar).getHeight(), true, true);
        if (this.getMenuElem(0).getIsHovered()) {
            IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(0).getPosXE() + iTranslateX, this.getMenuElem(0).getPosY() + iTranslateY, this.getMenuElem(0).getWidthE() + CFG.topBox.topBarPaddingRight, IMGManager.getIMG(Images.topBar).getHeight(), true, true);
        } else {
            IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(0).getPosXE() + iTranslateX, this.getMenuElem(0).getPosY() + iTranslateY, this.getMenuElem(0).getWidthE() + CFG.topBox.topBarPaddingRight, IMGManager.getIMG(Images.topBar).getHeight(), true, true);
        }
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        int extraY = 0;
        if (this.backAnimation && this.lTimeTOP2 + 2750L >= System.currentTimeMillis()) {
            this.lTimeTOP = System.currentTimeMillis();
        } else if (this.lTimeTOP + 725L >= System.currentTimeMillis()) {
            extraY = this.backAnimation ? (int)((float)(-this.getVictoryPosMax()) * ((float)(System.currentTimeMillis() - this.lTimeTOP) / 725.0f)) : (int)((float)(-this.getVictoryPosMax()) + (float)this.getVictoryPosMax() * ((float)(System.currentTimeMillis() - this.lTimeTOP) / 725.0f));
        } else if (!this.backAnimation) {
            this.backAnimation = true;
            this.lTimeTOP = System.currentTimeMillis();
            this.lTimeTOP2 = System.currentTimeMillis();
        } else {
            this.hideTop = true;
        }
        if (!this.hideTop) {
            this.drawVictory(oSB, this.getPosX() + iTranslateX, this.getPosY() + CFG.BUTTON_H / 4 + extraY + iTranslateY, sliderMenuIsActive, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 6);
        }
    }

    public int getVictoryPosMax() {
        return CFG.BUTTON_H / 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 6 + CFG.PADD * 2;
    }

    public static final void draw_Time(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 1.0f));
        IMGManager.getIMG(Images.patternReversed).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.patternReversed).getHeight(), nWidth, nHeight);
        IMGManager.getIMG(Images.patternReversed).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.patternReversed).getHeight(), nWidth, nHeight);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
        IMGManager.getIMG(Images.patternReversed).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.patternReversed).getHeight(), (int)((float)nWidth * CFG.timelapseManager.getTimePerc()), nHeight, 0, TimelapseManager.SOURCE);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.75f));
        IMGManager.getIMG(Images.patternReversed).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.patternReversed).getHeight(), (int)((float)nWidth * CFG.timelapseManager.getTimePerc()), nHeight, 0, TimelapseManager.SOURCE);
        if (!TimelapseManager.PAUSE) {
            --TimelapseManager.SOURCE;
        }
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.4f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, CFG.PADD);
        oSB.setColor(Color.WHITE);
    }

    public final void drawVictory(SpriteBatch oSB, int nX, int nY, boolean sliderMenuIsActive, int titleH) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nX, nY - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthM(), titleH);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.625f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nX, nY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthM(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nX, nY + titleH - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthM(), 1);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nX, nY - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthM(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nX, nY + titleH - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthM(), 1);
        oSB.setColor(Color.WHITE);
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD, this.sTopText, nX + this.getWidthM() / 2 - this.iTopTextWidth / 2, nY + titleH / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2, this.topColorBG);
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sTopTextDate, nX + this.getWidthM() / 2 - this.iTopTextDateWidth / 2, nY + titleH + CFG.PADD + CFG.PADD / 2, new Color(CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.r, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.g, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME.b, 0.425f));
    }

    public int getTopHeight() {
        return CFG.BUTTON_H + CFG.PADD * 4;
    }

    public static final void clickBack() {
        RTS.resetTime();
        RTS.PAUSE = true;
        CFG.menus.setMenuIDWithoutAnim(View.eINGAME);
        CFG.map.getMpSl().stopScrollingTheMap();
        CFG.map.getMpB().updateWorldMap_Shaders();
        if (CFG.menus.getVisibleInGame_WarDetails()) {
            CFG.menus.setVisibleInGame_WarDetails(false);
        }
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                if (!TimelapseManager.PAUSE) {
                    CFG.timelapseManager.pauseUnpause();
                }
                CFG.setDialogType(DialogType.CONTINUE_AFTER_END_GAME);
                break;
            }
            case 1: 
            case 2: {
                CFG.timelapseManager.pauseUnpause();
                CFG.map.getMpC().centerToCivilizationBox_Timeline(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), false);
                return;
            }
            case 3: {
                CFG.timelapseManager.updateSpeed(-1);
                return;
            }
            case 4: {
                CFG.timelapseManager.updateSpeed(1);
                return;
            }
        }
    }

    @Override
    public final void onBackPressed() {
    }

    @Override
    public void onMenuPressed() {
    }
}

