
package age.of.civilizations2.jakowski.lukasz.Menus.Action;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Colonize;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGameProvinceActionColonize
extends Menu {
    public Menu_InGameProvinceActionColonize() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game_Colonize(null, CFG.core.getActiveProvID(), CFG.PADD, CFG.PADD, GameCalendar.getCanColonize_TechLevel(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())){

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.BUTTON_H - CFG.PADD * 2);
                }
            }
        });
        this.initMenu(null, 0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.BUTTON_H - CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2, menuElements, false, false);
        this.updateLang();
        CFG.fMOVE_MENU_PERCENTAGE = 5.0f;
        CFG.lMOVE_MENU_TIME = System.currentTimeMillis();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Colonize"));
        this.updatedButtonsWidth(CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 2);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if ((CFG.fMOVE_MENU_PERCENTAGE += (float)(System.currentTimeMillis() - CFG.lMOVE_MENU_TIME) / 300.0f * 95.0f) > 100.0f) {
            CFG.fMOVE_MENU_PERCENTAGE = 100.0f;
        } else {
            CFG.setRenderO(true);
        }
        CFG.lMOVE_MENU_TIME = System.currentTimeMillis();
        Rectangle clipBounds = new Rectangle(this.getPosX() + iTranslateX, CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - this.getHeightM(), this.getWidthM(), this.getHeightM() + 1);
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        IMGManager.getIMG(Images.bgGameAction).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.bgGameAction).getHeight() + (int)((float)this.getHeightM() * (100.0f - CFG.fMOVE_MENU_PERCENTAGE) / 100.0f) - 1 + iTranslateY, this.getMenuElem(this.getMenuElemsSize() - 1).getPosXE() + this.getMenuElem(this.getMenuElemsSize() - 1).getWidthE() + CFG.PADD + 1, this.getHeightM() + 1, true, false);
        super.draw(oSB, iTranslateX, (int)((float)this.getHeightM() * (100.0f - CFG.fMOVE_MENU_PERCENTAGE) / 100.0f) + iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void beginClipM(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                try {
                    if (CFG.gameAction.canColonizieWasteland_BorderOrArmy(CFG.core.getActiveProvID(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
                        CFG.setDialogType(DialogType.COLONIZE_PROVINCE);
                        break;
                    }
                    this.getMenuElem(iID).setClickable(false);
                    CFG.core.checkProvinceActionMenu();
                    break;
                }
                catch (IndexOutOfBoundsException ex) {
                    CFG.exceptionStack(ex);
                }
            }
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible && this.getVisibleM() != visible) {
            CFG.fMOVE_MENU_PERCENTAGE = 5.0f;
            CFG.lMOVE_MENU_TIME = System.currentTimeMillis();
        }
        super.setVisibleM(visible);
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame();
    }
}

