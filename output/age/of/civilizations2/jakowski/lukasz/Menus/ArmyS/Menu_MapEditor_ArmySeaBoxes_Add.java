
package age.of.civilizations2.jakowski.lukasz.Menus.ArmyS;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Point_XY2;
import age.of.civilizations2.jakowski.lukasz.Province_ArmyBox;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_ArmySeaBoxes_Add
extends Menu {
    public static Point_XY2 oFirstPoint = null;
    public static Point_XY2 oSecondPoint = null;

    public Menu_MapEditor_ArmySeaBoxes_Add() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W * 2));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W * 2){

            @Override
            public final Color getColorE(boolean isActive) {
                return isActive ? new Color(0.75f, 0.8f, 0.03f, 1.0f) : (this.getIsClickable() ? new Color(0.941f, 1.0f, 0.0f, 1.0f) : new Color(0.674f, 0.09f, 0.066f, 0.5f));
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, CFG.GAMEWIDTH / 2 - CFG.PADD - CFG.PADD / 2));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH / 2 + CFG.PADD / 2, CFG.PADD, CFG.GAMEWIDTH / 2 - CFG.PADD - CFG.PADD / 2));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Reset") + " [1]");
        this.getMenuElem(3).setTextE(CFG.lang.get("Reset") + " [2]");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.drawEditorButtons_Bot_Edge_R(oSB, iTranslateX, this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorTitle_Edge_LR(oSB, iTranslateX, this.getMenuElem(2).getPosY() - CFG.PADD + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
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
                if (oFirstPoint.getPY() >= 0 && oSecondPoint.getPY() >= 0) {
                    int tempPoint;
                    if (oFirstPoint.getPX() > oSecondPoint.getPX()) {
                        tempPoint = oFirstPoint.getPX();
                        oFirstPoint.setPX(oSecondPoint.getPX());
                        oSecondPoint.setPX(tempPoint);
                    }
                    if (oFirstPoint.getPY() > oSecondPoint.getPY()) {
                        tempPoint = oFirstPoint.getPY();
                        oFirstPoint.setPY(oSecondPoint.getPY());
                        oSecondPoint.setPY(tempPoint);
                    }
                    if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 < 0) {
                        if (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes() == null) {
                            CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).initProvinceArmyBoxes();
                        }
                        ArrayList<Province_ArmyBox> nSet = new ArrayList<Province_ArmyBox>();
                        nSet.add(new Province_ArmyBox(oFirstPoint.getPX(), oFirstPoint.getPY(), oSecondPoint.getPX(), oSecondPoint.getPY()));
                        for (int i = 0; i < CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().size(); ++i) {
                            nSet.add(CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(i));
                        }
                        CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).setProvinceArmyBoxes(nSet);
                    } else {
                        CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().set(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2, new Province_ArmyBox(oFirstPoint.getPX(), oFirstPoint.getPY(), oSecondPoint.getPX(), oSecondPoint.getPY()));
                    }
                    this.onBackPressed();
                } else {
                    CFG.toastM.addM("UPDATE POINTS!");
                }
                return;
            }
            case 2: {
                oFirstPoint.setPX(-1);
                oFirstPoint.setPY(-1);
                return;
            }
            case 3: {
                oSecondPoint.setPX(-1);
                oSecondPoint.setPY(-1);
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_ARMY_SEA_BOXES_EDIT);
        CFG.menus.setBackAnimation(true);
        CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).updateDrawArmyInProv();
    }
}

