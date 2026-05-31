
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Main.Menu_Main;
import age.of.civilizations2.jakowski.lukasz.Menus.Menu_InitGame;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_GamesTitle
extends Menu {
    public Menu_GamesTitle() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempMenuWidth = Menu_Main.getMenuWidth_Default();
        menuElements.add(new Button_Classic_LR_Main(null, -1, 0, CFG.PADD, tempMenuWidth, CFG.BUTTON_H, true));
        this.initMenuWithBackButton(null, Menu_Main.getMenuPosX_Default(), 0, tempMenuWidth, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    public static final int getMenuPosX_Default() {
        return CFG.GAMEWIDTH - Menu_GamesTitle.getMenuWidth();
    }

    public static final int getMenuWidth() {
        int out = CFG.CIV_INFO_MENU_WIDTH + CFG.CIV_INFO_MENU_WIDTH / 2;
        if (CFG.isAndroid() && !CFG.LANDSCAPE) {
            out = CFG.CIV_INFO_MENU_WIDTH;
        }
        return out;
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        try {
            if (Menu_InitGame.animatedSize > 0) {
                oSB.setColor(new Color(0.047058824f, 0.047058824f, 0.047058824f, 1.0f));
                Images.pix.draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                Menu_InitGame.animated.get(Menu_InitGame.animatedID).draw(oSB, iTranslateX + (CFG.GAMEWIDTH - Menu_InitGame.animatedWidth) / 2, iTranslateY + (CFG.GAMEHEIGHT - Menu_InitGame.animatedHeight) / 2, Menu_InitGame.animatedWidth, Menu_InitGame.animatedHeight);
                oSB.setColor(Color.WHITE);
                if (Menu_InitGame.animatedTime + Menu_InitGame.animatedFrame < CFG.currentTimeMillis) {
                    Menu_InitGame.animatedTime = CFG.currentTimeMillis;
                    if (++Menu_InitGame.animatedID >= Menu_InitGame.animatedSize) {
                        Menu_InitGame.animatedID = 0;
                    }
                }
            } else if (Menu_InitGame.background != null) {
                oSB.setColor(new Color(0.047058824f, 0.047058824f, 0.047058824f, 1.0f));
                Images.pix.draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                Menu_InitGame.background.draw(oSB, iTranslateX + (CFG.GAMEWIDTH - Menu_InitGame.backgroundWidth) / 2, iTranslateY + (CFG.GAMEHEIGHT - Menu_InitGame.backgroundHeight) / 2, Menu_InitGame.backgroundWidth, Menu_InitGame.backgroundHeight);
                oSB.setColor(Color.WHITE);
                if (CFG.currentTimeMillis > Menu_InitGame.bgTIME_CHANGE + (long)GameValues.gvUpdate.MAIN_MENU_BG_CHANGE_BG_EVERY_X_MS) {
                    Menu_InitGame.bgTIME_CHANGE = CFG.currentTimeMillis;
                    Core.addSimpleTask(new Core.SimpleTask("loadBackground"){

                        @Override
                        public void update() {
                            Menu_InitGame.loadBackground();
                            Menu_InitGame.bgTIME = System.currentTimeMillis();
                            Menu_InitGame.bgTIME_CHANGE = System.currentTimeMillis();
                            Menu_InitGame.bgAlpha = 0.0f;
                        }
                    });
                }
            }
        }
        catch (Exception exception) {
            
        }
        Core.drawMenuBG(oSB, this.getPosX() + iTranslateX, iTranslateY, this.getWidthM(), CFG.GAMEHEIGHT);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuIDWithoutAnim(View.eMAINMENU);
        CFG.menus.setBackAnimation(true);
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_Games();
    }
}

