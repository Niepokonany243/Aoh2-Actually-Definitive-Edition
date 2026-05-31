/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ArmyS;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_ArmySeaBoxes
extends Menu {
    public Menu_MapEditor_ArmySeaBoxes() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W * 2));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W * 2));
        menuElements.add(new Text(null, -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.GAMEWIDTH - (CFG.BUTTON_W * 2 + CFG.PADD * 2) * 2, CFG.BUTTON_H){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? new Color(0.82f, 0.82f, 0.82f, 1.0f) : (this.getIsClickable() ? new Color(1.0f, 1.0f, 1.0f, 1.0f) : new Color(0.84f, 0.84f, 0.84f, 0.7f));
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Edit"));
        this.getMenuElem(2).setTextE(CFG.lang.get("SeaArmyBoxesEditor"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.drawEditorButtons_Bot_Edge_R(oSB, iTranslateX, this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                    CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = CFG.core.getActiveProvID();
                    if (!CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getDrawProv()) {
                        CFG.map.getMpC().centerToProvID(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1);
                    }
                    CFG.toastM.addM(CFG.lang.get("Province") + " " + CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1);
                    CFG.menus.setMenuID(View.eMAP_EDITOR_ARMY_SEA_BOXES_EDIT);
                } else {
                    CFG.toastM.addM(CFG.lang.get("SelectProvince"));
                }
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_EDIT);
        CFG.menus.setBackAnimation(true);
    }
}

