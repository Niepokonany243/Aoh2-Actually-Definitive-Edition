
package age.of.civilizations2.jakowski.lukasz.Menus.Slider;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Accept;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Decline;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.Sliders.LR.Slider_LR_PercOver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_Slider
extends Menu {
    public Menu_InGame_Slider() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game_Decline(CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game_Accept(CFG.GAMEWIDTH - CFG.PADD - CFG.BUTTON_W, CFG.PADD, true){

            @Override
            public int getSFXElem() {
                return CFG.SFXManager.playMoveArmy();
            }
        });
        menuElements.add(new Slider_LR_PercOver(CFG.BUTTON_W + CFG.PADD * 2, CFG.PADD, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD * 4, CFG.BUTTON_H, 0L, 200L, 100L));
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
    public void extraAction() {
        block7: {
            try {
                if (CFG.core.getActiveProvID() >= 0 && CFG.chosenProvinceID >= 0) {
                    int moveCivID = CFG.gameAction.getControlledArmyCivIDInProvince(CFG.core.getActiveProvID(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    CFG.gameAction.moveArmyAction(CFG.core.getActiveProvID(), CFG.chosenProvinceID, (long)this.getMenuElem(2).getCurr(), moveCivID, false, true);
                    try {
                        if (GameValues.gvCombat.DYNAMIC_MIN_ARMY_ENABLED) {
                            long minRequired;
                            if (CFG.settingsGD.DYNAMIC_MIN_ARMY) {
                                long pop = CFG.core.getProv(CFG.chosenProvinceID).getPop().getPops();
                                float attackerPopPerc = pop > 0 ? (float)CFG.core.getProv(CFG.chosenProvinceID).getPop().getPopulationOfCivID(moveCivID) / (float)pop : 0f;
                                float minPerc = attackerPopPerc > GameValues.gvCombat.DYNAMIC_MIN_ARMY_OWN_MAJORITY_THRESHOLD
                                    ? GameValues.gvCombat.DYNAMIC_MIN_ARMY_POP_PERCENT_OWNED_MAJORITY
                                    : GameValues.gvCombat.DYNAMIC_MIN_ARMY_POP_PERCENT;
                                minRequired = Math.max(1L, (long)Math.ceil((float)pop * minPerc));
                            } else {
                                minRequired = Math.max(1L, CFG.MIN_ARMY_REQUIRED_TO_ATTACK);
                            }
                            if (this.getMenuElem(2).getCurr() < minRequired && CFG.core.getProv(CFG.chosenProvinceID).getCivId() > 0 && CFG.core.getCivsAtWar(moveCivID, CFG.core.getProv(CFG.chosenProvinceID).getCivId())) {
                                CFG.toastM.addM(CFG.lang.get("MinArmyRequiredToAttack") + ": " + minRequired + " " + CFG.lang.get("Units"), CFG.COLOR_NEGATIVE_2);
                                CFG.toastM.setTimeInView(3500);
                            }
                        }
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        
                    }
                    CFG.core.resetChooseProvinceData();
                    CFG.core.checkProvinceActionMenu();
                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    CFG.core.getPlayer(CFG.PLAYER_TURN_ID).setNoOrders(false);
                    if (RTS.isEnabled() && !RTS.PAUSE) {
                        RTS.updateTimePast_AfterAction(0.75f);
                    }
                    break block7;
                }
                this.setVisibleM(false);
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.core.resetChooseProvinceData();
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
                CFG.menus.updateInGame_ActionInfo_Move();
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

