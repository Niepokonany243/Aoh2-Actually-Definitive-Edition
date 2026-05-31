
package age.of.civilizations2.jakowski.lukasz.Menus.Turn.End;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Speed;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Speed_Right;
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
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.Timelapse.TimelapseManager;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Timeline
extends Menu {
    public Menu_Timeline() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Text(null, 0, 0, CFG.PADD, IMGManager.getIMG(Images.topBar).getHeight()){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                if (TimelapseManager.PAUSE) {
                    CFG.fontMain.get(0).getData().setScale(0.8f);
                    CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + this.getWidthE() / 2 - (int)((float)this.getTextWidthU() * 0.8f) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() * 0.8f / 2.0f) + 1 + iTranslateY, this.getColor(isActive));
                    CFG.fontMain.get(0).getData().setScale(1.0f);
                }
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
        menuElements.add(new Text("Date", 0, 0, 0, IMGManager.getIMG(Images.topBar).getHeight(), (float)CFG.FONT_BOLD_SMALL){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextHeight() - CFG.PADD + iTranslateY, this.getColor(isActive));
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_CIV_NAME_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_NAME_HOVERED : CFG.COLOR_TEXT_CIV_NAME) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getPosXE() {
                return CFG.GAMEWIDTH - IMGManager.getIMG(Images.topBar).getHeight() - CFG.PADD - Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 2, (int)((float)this.getTextWidthU() * 0.8f) + CFG.PADD * 4);
            }

            @Override
            public int getWidthE() {
                return Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 2, (int)((float)this.getTextWidthU() * 0.8f) + CFG.PADD * 4);
            }

            @Override
            public int getHeightE() {
                return IMGManager.getIMG(Images.topBar).getHeight() / 2;
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
        menuElements.add(new Text("Turn", 0, 0, IMGManager.getIMG(Images.topBar).getHeight() / 2, IMGManager.getIMG(Images.topBar).getHeight(), (float)CFG.FONT_BOLD_SMALL){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + (int)(((float)this.getWidthE() - (float)this.getTextWidthU() * Menu_InGame_2.fTurnScale) / 2.0f) + iTranslateX, this.getPosY() + CFG.PADD + iTranslateY, this.getColor(isActive));
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_RANK_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_RANK_HOVER : CFG.COLOR_TEXT_RANK) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getPosXE() {
                return Menu_Timeline.this.getMenuElem(1).getPosXE();
            }

            @Override
            public int getWidthE() {
                return Menu_Timeline.this.getMenuElem(1).getWidthE();
            }

            @Override
            public int getHeightE() {
                return IMGManager.getIMG(Images.topBar).getHeight() / 2;
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
                return Menu_Timeline.this.getMenuElem(1).getPosXE() - this.getWidthE();
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
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(GameCalendar.getDate_ByTurnID(CFG.timelapseManager.iTimelineTurnID + 1));
        this.getMenuElem(2).setTextE(CFG.lang.get("Turn") + ": " + (CFG.timelapseManager.iTimelineTurnID + 1));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (!TimelapseManager.PAUSE) {
            CFG.timelapseManager.updateTime();
        }
        if (TimelapseManager.PAUSE) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.TEXT_HEIGHT_DEFAULT);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - CFG.TEXT_HEIGHT_DEFAULT - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.TEXT_HEIGHT_DEFAULT, false, true);
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.15f));
            IMGManager.getIMG(Images.gameLogo).drawO(oSB, this.getPosX() + this.getWidthM() - CFG.PADD * 2 - IMGManager.getIMG(Images.gameLogo).getWidth() + iTranslateX, this.getPosY() + this.getHeightM() - CFG.PADD * 2 - IMGManager.getIMG(Images.gameLogo).getHeight() + iTranslateY);
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.topBar).draw2O(oSB, this.getMenuElem(0).getPosXE() + iTranslateX, this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.topBar).getHeight() + iTranslateY, this.getMenuElem(0).getWidthE() + CFG.topBox.topBarPaddingRight, IMGManager.getIMG(Images.topBar).getHeight(), true, true);
            oSB.setColor(Color.WHITE);
        } else {
            CFG.setRenderO(true);
        }
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.topBar).draw2O(oSB, this.getMenuElem(3).getPosXE() - CFG.PADD - CFG.topBox.topBarPaddingRight + iTranslateX, -IMGManager.getIMG(Images.topBar).getHeight() + iTranslateY, CFG.topBox.topBarPaddingRight + CFG.PADD + (CFG.GAMEWIDTH - this.getMenuElem(3).getPosXE()), IMGManager.getIMG(Images.topBar).getHeight());
        Menu_Timeline.draw_Time(oSB, this.getMenuElem(1).getPosXE() + iTranslateX, 0, this.getMenuElem(1).getWidthE(), IMGManager.getIMG(Images.topBar).getHeight() - 2 - CFG.PADD);
        int tSpeedWidth = (this.getMenuElem(1).getWidthE() - CFG.PADD * 5) / 6;
        int tX = (this.getMenuElem(1).getWidthE() - tSpeedWidth * 6 - CFG.PADD * 5) / 2;
        for (int i = 0; i < TimelapseManager.SPEED; ++i) {
            Menu_InGame_2.draw_Speed(oSB, tX + this.getMenuElem(1).getPosXE() + (tSpeedWidth + CFG.PADD) * i + iTranslateX, IMGManager.getIMG(Images.topBar).getHeight() - 2 - CFG.PADD, tSpeedWidth, CFG.PADD);
        }
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
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

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: 
            case 2: {
                CFG.timelapseManager.pauseUnpause();
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
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eINGAME);
        CFG.mapModesManager.setActiveMapModeID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE);
        CFG.timelapseManager.clearTimeline();
    }
}

