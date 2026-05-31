/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ActionInfo;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Decline;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_Move;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

public class Menu_InGame_ActionInfo
extends Menu {
    public Menu_InGame_ActionInfo() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game_Decline(CFG.PADD, CFG.PADD, true));
        menuElements.add(new TextActionInfo_Move(null, CFG.BUTTON_W + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD * 2 - CFG.PADD - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2)));
        this.initMenu(null, 0, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - CFG.BUTTON_H - CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2, menuElements, true, false);
        this.updateLang();
        CFG.fMOVE_MENU_PERCENTAGE = 5.0f;
        CFG.lMOVE_MENU_TIME = System.currentTimeMillis();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(1).setTextE(CFG.lang.get("ChooseAProvince"));
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
        IMGManager.getIMG(Images.bgGameAction).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.bgGameAction).getHeight() + (int)((float)this.getHeightM() * (100.0f - CFG.fMOVE_MENU_PERCENTAGE) / 100.0f) - 1 + iTranslateY, this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() + CFG.PADD + 1, this.getHeightM() + 1, true, false);
        super.draw(oSB, iTranslateX, (int)((float)this.getHeightM() * (100.0f - CFG.fMOVE_MENU_PERCENTAGE) / 100.0f) + iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void beginClipM(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.core.resetChooseProvinceData();
                CFG.core.checkProvinceActionMenu();
                break;
            }
            case 1: {
                CFG.toastM.addM(this.getMenuElem(1).getTextE());
            }
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_Recruit();
    }
}

