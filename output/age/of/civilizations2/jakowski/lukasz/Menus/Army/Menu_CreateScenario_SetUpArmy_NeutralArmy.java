/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Army;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Sliders.LR.Slider_LR_Flag;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateScenario_SetUpArmy_NeutralArmy
extends Menu {
    public Menu_CreateScenario_SetUpArmy_NeutralArmy() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH * 2;
        if (tempW > CFG.GAMEWIDTH - CFG.PADD * 4) {
            tempW = CFG.GAMEWIDTH - CFG.PADD * 4;
        }
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Slider_LR_Flag(0, CFG.PADD, CFG.PADD, tempW - CFG.PADD * 2, CFG.BUTTON_H * 3 / 4, 0L, 400L, (long)(CFG.core.getGameScenars().getScenario_NeutralArmy() / 25)){

            @Override
            public String getDrawText() {
                return "" + this.getCurr() * 25;
            }

            @Override
            public int getWidthE() {
                return Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getW() - CFG.PADD * 2;
            }
        });
        this.initMenu(new TitleM(null, CFG.BUTTON_H / 2, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getPosX() + iTranslateX, Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getPosY() - IMGManager.getIMG(Images.dialog_title).getHeight() - this.getHeightT(), Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getWidthM() - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT(), false, false);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getPosX() + Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getWidthM() - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getPosY() - IMGManager.getIMG(Images.dialog_title).getHeight() - this.getHeightT(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT(), true, false);
                oSB.setColor(new Color(CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.r, CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.g, CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.b, 0.25f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getPosX() + iTranslateX, Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightT() * 3 / 4, Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getWidthM(), this.getHeightT() * 3 / 4, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getPosX() + 2 + iTranslateX, Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getWidthM() - 4);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.85f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getPosX() + 2 + iTranslateX, Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_CreateScenario_SetUpArmy_NeutralArmy.this.getWidthM() - 4, 1);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.75f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.75f / 2.0f) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - (int)((float)this.getTextHeight() * 0.75f / 2.0f), CFG.COLOR_NEUTRAL);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, CFG.PADD * 2, CFG.BUTTON_H * 2 + CFG.PADD * 4 + CFG.PADD + CFG.BUTTON_H / 2, tempW, CFG.BUTTON_H * 3 / 4 + CFG.PADD * 2, menuElements, false, true);
        this.getMenuElem(0).setCurr(this.getMenuElem(0).getCurr());
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("NeutralArmy"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdgeLine).getWidth(), this.getHeightM(), false, true);
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdgeLine).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdgeLine).getWidth(), this.getHeightM(), true, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM(), this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM(), this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM(), this.getWidthM());
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void actionEL(int iID) {
        long nBefore = CFG.core.getGameScenars().getScenario_NeutralArmy();
        CFG.core.getGameScenars().setScenario_NeutralArmy(this.getMenuElem(iID).getCurr() * 25);
        if (nBefore != CFG.core.getGameScenars().getScenario_NeutralArmy()) {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getCivId() != 0 || CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.core.getProv(i).getArmyID(0) != nBefore) continue;
                CFG.core.getProv(i).updateArmy4(CFG.core.getGameScenars().getScenario_NeutralArmy());
            }
        }
    }

    private int getW() {
        return this.getWidthM();
    }
}

