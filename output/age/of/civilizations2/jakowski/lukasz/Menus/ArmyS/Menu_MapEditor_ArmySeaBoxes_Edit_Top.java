/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ArmyS;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_NewGameBoxStyle_LEFT;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_NewGameBoxStyle_RIGHT_Remove;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.ArmyS.Menu_MapEditor_ArmySeaBoxes_Add;
import age.of.civilizations2.jakowski.lukasz.Point_XY2;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_ArmySeaBoxes_Edit_Top
extends Menu {
    public Menu_MapEditor_ArmySeaBoxes_Edit_Top() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes() != null) {
            for (int j = 0; j < CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().size(); ++j) {
                menuElements.add(new Button_Game_NewGameBoxStyle_LEFT(CFG.lang.get("Edit") + ": " + (j + 1), -1, CFG.PADD * (j + 1) + CFG.BUTTON_W * 2 * j, CFG.PADD, CFG.BUTTON_W + CFG.BUTTON_W / 4, CFG.BUTTON_H * 3 / 4, true));
                menuElements.add(new Button_Game_NewGameBoxStyle_RIGHT_Remove(CFG.PADD * (j + 1) + CFG.BUTTON_W * 2 * j + CFG.BUTTON_W + CFG.BUTTON_W / 4, CFG.PADD, CFG.BUTTON_W * 3 / 4, CFG.BUTTON_H * 3 / 4, true));
            }
        }
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2, menuElements);
        this.updateLang();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (this.getMenuElemsSize() > 0) {
            CFG.drawEditorTitle_Edge_LR(oSB, iTranslateX, this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, CFG.GAMEWIDTH, this.getMenuElem(0).getHeightE() + CFG.PADD * 2);
        }
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        if (iID % 2 == 0) {
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = iID / 2;
            Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint = new Point_XY2(CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2).getStartPosX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2).getStartPosY());
            Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint = new Point_XY2(CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2).getEndPosX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2).getEndPosY());
            CFG.menus.setMenuID(View.eMAP_EDITOR_ARMY_SEA_BOXES_ADD);
        } else {
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = iID / 2;
            CFG.setDialogType(DialogType.MAP_EDITOR_SEA_ARMY_BOXES_REMOVE);
        }
    }
}

