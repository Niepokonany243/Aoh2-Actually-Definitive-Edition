/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.MinimapInfo;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_MinimapAction
extends Menu {
    private int animationStepID = 0;
    private int animationChangePosY;
    private int animationChangePosX;
    private boolean closeMenu = false;

    public Menu_InGame_MinimapAction() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new MinimapInfo(CFG.PADD, CFG.PADD, CFG.GAMEWIDTH - CFG.PADD * 6));
        this.initMenu(new TitleM("Map", CFG.BUTTON_H / 2, false, false), CFG.PADD * 2, CFG.GAMEHEIGHT / 2 - ((MenuElemUI)menuElements.get(0)).getHeightE() / 2, CFG.GAMEWIDTH - CFG.PADD * 4, ((MenuElemUI)menuElements.get(0)).getHeightE() + CFG.PADD * 2, menuElements, false, true);
    }

    @Override
    public final void draw(SpriteBatch oSB, int iTranslateX, boolean sliderMenuIsActive) {
        if (this.closeMenu) {
            this.updateChangePosX();
        } else {
            this.updateChangePosY();
        }
        super.draw(oSB, iTranslateX + this.animationChangePosX, this.animationChangePosY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            default: 
        }
    }

    @Override
    public final void onBackPressed() {
        this.closeMenu();
    }

    private final void updateChangePosX() {
        switch (this.animationStepID) {
            case 0: 
            case 1: 
            case 12: {
                this.animationChangePosX = (int)((float)this.animationChangePosX + (float)CFG.GAMEWIDTH * 2.5f / 100.0f);
                break;
            }
            case 2: 
            case 3: 
            case 10: 
            case 11: {
                this.animationChangePosX = (int)((float)this.animationChangePosX + (float)CFG.GAMEWIDTH * 5.0f / 100.0f);
                break;
            }
            case 4: 
            case 5: 
            case 8: 
            case 9: {
                this.animationChangePosX = (int)((float)this.animationChangePosX + (float)CFG.GAMEWIDTH * 10.0f / 100.0f);
                break;
            }
            case 6: 
            case 7: {
                this.animationChangePosX = (int)((float)this.animationChangePosX + (float)CFG.GAMEWIDTH * 15.0f / 100.0f);
                break;
            }
            case 13: {
                this.animationChangePosX = CFG.GAMEWIDTH;
            }
        }
        if (CFG.iNumOfFPS < 22) {
            this.animationStepID = 13;
            this.animationChangePosX = CFG.GAMEWIDTH;
        }
        if (this.closeMenu && this.animationStepID == 13) {
            this.animationChangePosX = CFG.GAMEWIDTH;
            super.setVisibleM(false);
        }
        ++this.animationStepID;
        CFG.setRenderO(true);
    }

    private final void updateChangePosY() {
        switch (this.animationStepID) {
            case 0: 
            case 1: 
            case 12: {
                this.animationChangePosY = (int)((float)this.animationChangePosY - (float)(CFG.GAMEHEIGHT - this.getPosY()) * 2.5f / 100.0f * (float)(this.closeMenu ? -1 : 1));
                break;
            }
            case 2: 
            case 3: 
            case 10: 
            case 11: {
                this.animationChangePosY = (int)((float)this.animationChangePosY - (float)(CFG.GAMEHEIGHT - this.getPosY()) * 5.0f / 100.0f * (float)(this.closeMenu ? -1 : 1));
                break;
            }
            case 4: 
            case 5: 
            case 8: 
            case 9: {
                this.animationChangePosY = (int)((float)this.animationChangePosY - (float)(CFG.GAMEHEIGHT - this.getPosY()) * 10.0f / 100.0f * (float)(this.closeMenu ? -1 : 1));
                break;
            }
            case 6: 
            case 7: {
                this.animationChangePosY = (int)((float)this.animationChangePosY - (float)(CFG.GAMEHEIGHT - this.getPosY()) * 15.0f / 100.0f * (float)(this.closeMenu ? -1 : 1));
                break;
            }
            case 13: {
                this.animationChangePosY = 0;
            }
        }
        if (CFG.iNumOfFPS < 22) {
            this.animationStepID = 13;
            this.animationChangePosY = 0;
        }
        if (this.closeMenu && this.animationStepID == 13) {
            this.animationChangePosY = CFG.GAMEHEIGHT / 2 + CFG.BUTTON_H;
            super.setVisibleM(false);
        }
        ++this.animationStepID;
        CFG.setRenderO(true);
    }

    private final void closeMenu() {
        this.closeMenu = true;
        this.resetAnimation();
    }

    @Override
    public final void setVisibleM(boolean visible) {
        if (visible) {
            super.setVisibleM(visible);
        }
        if (!visible && this.closeMenu) {
            super.setVisibleM(visible);
        }
        this.closeMenu = !visible;
        this.resetAnimation();
    }

    private final void resetAnimation() {
        this.animationStepID = 0;
        if (!this.closeMenu) {
            this.animationChangePosY = CFG.GAMEHEIGHT - this.getPosY();
        }
        this.animationChangePosX = 0;
    }
}

