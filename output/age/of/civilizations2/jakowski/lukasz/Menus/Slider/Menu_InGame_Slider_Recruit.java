
package age.of.civilizations2.jakowski.lukasz.Menus.Slider;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Accept;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Decline;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_2;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Sliders.LR.Slider_LR_PercOver;
import age.of.civilizations2.jakowski.lukasz.Touch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_Slider_Recruit
extends Menu {
    public Menu_InGame_Slider_Recruit() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game_Decline(CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game_Accept(CFG.GAMEWIDTH - CFG.PADD - CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_RECRUIT;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                int turns = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRecruitmentTurns();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Turns") + ": " + turns, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + turns)));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.BUTTON_H - CFG.PADD * 2);
                }
            }
        });
        menuElements.add(new Slider_LR_PercOver(CFG.BUTTON_W + CFG.PADD * 2, CFG.PADD, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD * 4, CFG.BUTTON_H, 0L, 200L, (long)(200.0f * GameValues.gvArmyRecruit.RECRUIT_ARMY_DEFAULT_SLIDER_PERC_OF_MAX)){

            @Override
            public Color getColorLEFT() {
                return CFG.COLOR_SLIDER_LEFT_BG2;
            }
        });
        this.initMenu(null, 0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.BUTTON_H - CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2, menuElements, false, false);
        this.updateLang();
        CFG.fMOVE_MENU_PERCENTAGE = 5.0f;
        CFG.lMOVE_MENU_TIME = System.currentTimeMillis();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if ((CFG.fMOVE_MENU_PERCENTAGE += (float)(System.currentTimeMillis() - CFG.lMOVE_MENU_TIME) / 250.0f * 95.0f) > 100.0f) {
            CFG.fMOVE_MENU_PERCENTAGE = 100.0f;
        } else {
            CFG.setRenderO(true);
        }
        CFG.lMOVE_MENU_TIME = System.currentTimeMillis();
        Rectangle clipBounds = new Rectangle(this.getPosX() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightM(), this.getWidthM(), this.getHeightM());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        
        if (CFG.settingsGD.BETTER_UI) {
            BetterUI_Manager.drawBetterMenuBG(oSB, this.getPosX() + iTranslateX, this.getPosY() + (int)((float)this.getHeightM() * (100.0f - CFG.fMOVE_MENU_PERCENTAGE) / 100.0f) + iTranslateY, this.getWidthM(), this.getHeightM());
        } else {
            IMGManager.getIMG(Images.bgGameMenu).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.bgGameMenu).getHeight() + (int)((float)this.getHeightM() * (100.0f - CFG.fMOVE_MENU_PERCENTAGE) / 100.0f) + iTranslateY, this.getWidthM(), this.getHeightM());
            oSB.setColor(CFG.COLOR_BG_GAME_MENU_SHADOW);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), 1);
        }

        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, (int)((float)this.getHeightM() * (100.0f - CFG.fMOVE_MENU_PERCENTAGE) / 100.0f) + iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void beginClipM(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_Recruit();
    }

    @Override
    public void extraAction() {
        try {
            CFG.menus.setVisible_InGame_ProviRecruit(false);
            for (int i = 0; i < Core.AMRCT.size(); ++i) {
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).recruitArmy(Core.AMRCT.get((int)i).OBC, Core.AMRCT.get((int)i).SPR);
                Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), Core.AMRCT.get((int)i).OBC, Colors.COLOR_TEXT_MODIFIER_POSITIVE);
            }
            CFG.core.checkProvinceActionMenu();
            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            CFG.gameAction.updateInGame_ProvinceInfo();
            if (CFG.menus.getVisibleInGame_CensusOfProvince()) {
                CFG.menus.rebuildInGame_CensusOfProvince(CFG.core.getActiveProvID());
            }
            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ARMY_MODE) {
                CFG.updateMAX_Army();
            }
            CFG.core.getPlayer(CFG.PLAYER_TURN_ID).setNoOrders(false);
            Menu_InGame_2.updateOverBudget();
            if (RTS.isEnabled() && !RTS.PAUSE) {
                RTS.updateTimePast_AfterAction(1.0f);
            }
            CFG.menus.resetHoverActive();
            Core.LYC();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                Core.LYC();
                CFG.menus.setVisible_InGame_ProviRecruit(false);
                CFG.core.checkProvinceActionMenu();
                if (!RTS.isEnabled() || RTS.PAUSE) break;
                RTS.updateTimePast_AfterAction(0.5f);
                break;
            }
            case 1: {
                this.extraAction();
                break;
            }
            case 2: {
                Core.dARA(this.getMenuElem(2).getCurr());
                CFG.menus.updateInGame_ActionInfo_Recruit();
            }
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        if (visible) {
            CFG.fMOVE_MENU_PERCENTAGE = 5.0f;
            CFG.lMOVE_MENU_TIME = System.currentTimeMillis();
        }
    }
}

