
package age.of.civilizations2.jakowski.lukasz.Menus.Turn.Start;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.CivsInRangeT;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameTaskScheduler;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.concurrent.Future;

public class Menu_StartTheGame
extends Menu {
    private String s1 = "";
    private int iWidth1;
    private String s2 = "";
    private int iWidth2;
    public Future<?> civsInRangeTask;

    public Menu_StartTheGame() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Transparent(1, 1, CFG.GAMEWIDTH - 2, CFG.GAMEHEIGHT - 2, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        try {
            this.s1 = CFG.EDITOR_ACTIVE_GAMEDATA_TAG;
            CFG.glyphLay.setText(CFG.fontMain.get(0), this.s1);
            this.iWidth1 = (int)CFG.glyphLay.width;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            this.s2 = GameCalendar.getCurrDate();
            CFG.glyphLay.setText(CFG.fontMain.get(0), this.s2);
            this.iWidth2 = (int)CFG.glyphLay.width;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        this.updateLang();
        this.civsInRangeTask = GameTaskScheduler.submit(new CivsInRangeT());
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        try {
            oSB.setColor(new Color(0.1f, 0.1f, 0.1f, 0.2f - 0.2f * (float)CFG.startTheGameData.getProvincesAlpha()));
            IMGManager.getIMG(Images.pattern).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.pattern).getHeight(), CFG.GAMEWIDTH, CFG.GAMEHEIGHT, 0.0f, 0);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.4f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3);
            IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD * 3 + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3, false, true);
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.65f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.BUTTON_H);
            oSB.setColor(CFG.COLOR_GRADIENT_DARK_BLUE);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), CFG.BUTTON_H);
            oSB.setColor(CFG.COLOR_FLAG_FRAME);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + CFG.BUTTON_H - 2 + iTranslateY, this.getWidthM() - CFG.PADD * 4, 1);
            oSB.setColor(Color.WHITE);
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.35f));
            IMGManager.getIMG(Images.gameLogo).draw2O(oSB, CFG.GAMEWIDTH - IMGManager.getIMG(Images.gameLogo).getWidth() - CFG.PADD + iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gameLogo).getHeight() * 2 - CFG.PADD, IMGManager.getIMG(Images.gameLogo).getWidth(), IMGManager.getIMG(Images.gameLogo).getHeight());
            oSB.setColor(Color.WHITE);
            IMGManager.getIMG(Images.gameLogo).draw2O(oSB, CFG.GAMEWIDTH - IMGManager.getIMG(Images.gameLogo).getWidth() - CFG.PADD + iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gameLogo).getHeight() * 2 - CFG.PADD, (int)((float)(IMGManager.getIMG(Images.gameLogo).getWidth() * CFG.startTheGameData.getProvincesAlpha()) / 100.0f), IMGManager.getIMG(Images.gameLogo).getHeight());
            CFG.drawTextDefault(oSB, this.s1, CFG.GAMEWIDTH / 2 - this.iWidth1 / 2 + iTranslateX, CFG.BUTTON_H / 2 - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD / 2 + iTranslateY, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME);
            CFG.fontMain.get(0).getData().setScale(0.8f);
            CFG.drawTextDefault(oSB, this.s2, CFG.GAMEWIDTH / 2 - (int)((float)this.iWidth2 * 0.8f / 2.0f) + iTranslateX, CFG.BUTTON_H / 2 + CFG.PADD + iTranslateY, CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO);
            CFG.fontMain.get(0).getData().setScale(1.0f);
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            if (CFG.startTheGameData.getIsDone()) {
                this.onBackPressed();
            }
            try {
                if (CivsInRangeT.DONE_CIVS < CFG.core.getCivsSize()) {
                    CFG.fontMain.get(0).getData().setScale(0.8f);
                }
            }
            catch (Exception exception) {
                
            }
            CFG.fontMain.get(0).getData().setScale(1.0f);
        }
        catch (NullPointerException ex) {
            this.onBackPressed();
        }
        catch (IndexOutOfBoundsException ex) {
            this.onBackPressed();
        }
        oSB.setColor(Color.WHITE);
        CFG.setRenderO(true);
    }

    @Override
    public final void actionEL(int iID) {
        try {
            if (CivsInRangeT.DONE_CIVS >= CFG.core.getCivsSize()) {
                Menu_StartTheGame.done();
            }
        }
        catch (NullPointerException nullPointerException) {
            
        }
    }

    @Override
    public final void onBackPressed() {
    }

    public static final void done() {
        try {
            CFG.gameAction.hideExtraViews();
            CFG.menus.setMenuID(View.eINGAME);
            CFG.menus.setVisible_InGame_Options(false);
            CFG.menus.setVisible_InGame_EndOfGame(false);
            CFG.menus.setVisible_InGame_ActionInfo(false);
            CFG.menus.setVisible_InGame_View(false);
            CFG.gameAction.updateInGame_ProvinceInfo();
            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            CFG.menus.rebuildInGame_Messages();
            CFG.menus.rebuildInGame_Strategy();
            CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
            RenderProvince.updateDrawProvinces();
            CFG.core.checkProvinceActionMenu();
            CFG.menus.setOrderOfMenu_InGame();
            CFG.core.updateDrawMoveUnitsArmy();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }
}

