/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ArmyPos;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_ArrowDown;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_ArrowLeft;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_ArrowRight;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_ArrowUp;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_ShiftArmy;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_ArmyPosition
extends Menu {
    public Menu_MapEditor_ArmyPosition() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W * 2));
        menuElements.add(new Button_Game_ArrowLeft(CFG.GAMEWIDTH - CFG.BUTTON_W * 3 - CFG.PADD * 3, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true));
        menuElements.add(new Button_Game_ArrowDown(CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true));
        menuElements.add(new Button_Game_ArrowRight(CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true));
        menuElements.add(new Button_Game_ArrowUp(CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2 - CFG.PADD * 2, true));
        menuElements.add(new Button_Transparent(CFG.GAMEWIDTH - CFG.BUTTON_W * 3 - CFG.PADD * 4, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2 - CFG.PADD * 3, CFG.BUTTON_W * 3 + CFG.PADD * 4, CFG.BUTTON_H * 2 + CFG.PADD * 3, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Save"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.drawEditorButtons_Bot_Edge_R(oSB, iTranslateX, this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD * 2);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, CFG.GAMEWIDTH - CFG.BUTTON_W * 3 - CFG.PADD * 5 + iTranslateX, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2 - CFG.PADD * 4 - 1 - IMGManager.getIMG(Images.gameTopEdge).getHeight(), CFG.BUTTON_W * 3 + CFG.PADD * 5 + 1, CFG.BUTTON_H * 2 + CFG.PADD * 4 + 1, false, false);
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
                if (CFG.core.getActiveProvID() >= 0) {
                    CFG.core.getProv(CFG.core.getActiveProvID()).setShiftArmyX(CFG.core.getProv(CFG.core.getActiveProvID()).getShPX() - 1);
                    Editor_ShiftArmy.saveArmyPosition();
                }
                return;
            }
            case 2: {
                if (CFG.core.getActiveProvID() >= 0) {
                    CFG.core.getProv(CFG.core.getActiveProvID()).setShiftArmyY(CFG.core.getProv(CFG.core.getActiveProvID()).getShPY() + 1);
                    Editor_ShiftArmy.saveArmyPosition();
                }
                return;
            }
            case 3: {
                if (CFG.core.getActiveProvID() >= 0) {
                    CFG.core.getProv(CFG.core.getActiveProvID()).setShiftArmyX(CFG.core.getProv(CFG.core.getActiveProvID()).getShPX() + 1);
                    Editor_ShiftArmy.saveArmyPosition();
                }
                return;
            }
            case 4: {
                if (CFG.core.getActiveProvID() >= 0) {
                    CFG.core.getProv(CFG.core.getActiveProvID()).setShiftArmyY(CFG.core.getProv(CFG.core.getActiveProvID()).getShPY() - 1);
                    Editor_ShiftArmy.saveArmyPosition();
                }
                return;
            }
        }
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_EDIT);
        CFG.menus.setBackAnimation(true);
        CFG.editorManager.resetInUseEditors();
        RenderProvince.updateDrawProvinces();
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv(i).getArmyObject(0).updateArmyWidth_Just(i);
        }
    }
}

