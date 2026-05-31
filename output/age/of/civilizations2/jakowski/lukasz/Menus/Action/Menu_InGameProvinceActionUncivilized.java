
package age.of.civilizations2.jakowski.lukasz.Menus.Action;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGameProvinceActionUncivilized
extends Menu {
    public Menu_InGameProvinceActionUncivilized() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true){

            @Override
            public int getTextWidthU() {
                return super.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH;
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                CFG.core.getCiv(CFG.core.getActiveCivID()).getFlagC().drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.core.getActiveCivID()).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                if (isActive) {
                    CFG.drawTextDefault(oSB, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + CFG.PADD + CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
                } else {
                    CFG.drawTextDefaultWithShadow(oSB, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + CFG.PADD + CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
                }
            }

            @Override
            public boolean getIsClickable() {
                return Core.uncivilizedCanMigrate(CFG.core.getActiveProvID(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true){

            @Override
            public int getPosXE() {
                return Menu_InGameProvinceActionUncivilized.this.getMenuElem(0).getPosXE() + Menu_InGameProvinceActionUncivilized.this.getMenuElem(0).getWidthE() + CFG.PADD;
            }

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (isActive) {
                    CFG.drawTextDefault(oSB, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
                } else {
                    CFG.drawTextDefaultWithShadow(oSB, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
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
        this.getMenuElem(0).setTextE(CFG.lang.get("Migrate"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Hunt"));
        this.updatedButtonsWidth(CFG.PADD, CFG.BUTTON_W);
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
            default: 
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

