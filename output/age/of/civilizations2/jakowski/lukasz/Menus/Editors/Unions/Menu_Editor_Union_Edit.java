
package age.of.civilizations2.jakowski.lukasz.Menus.Editors.Unions;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Remove;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Menu_Editor_Union_Edit
extends Menu {
    public Menu_Editor_Union_Edit() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH / 2, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line(CFG.lang.get("SelectCivilization") + ": " + CFG.lang.getCiv(CFG.unionsManager.createUnion_Data.lCreateCivTag), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line(CFG.lang.get("AddCivilization"), -1, 0, CFG.PADD * 2 + CFG.BUTTON_H, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        for (int i = 0; i < CFG.unionsManager.createUnion_Data.lCivsTags.size(); ++i) {
            menuElements.add(new Button_Classic(CFG.lang.get("Civilization") + ": " + CFG.lang.getCiv(CFG.unionsManager.createUnion_Data.lCivsTags.get(i)), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD * (i + 3) + CFG.BUTTON_H * (i + 2), CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
            menuElements.add(new Button_Classic_Remove(CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.BUTTON_W / 2, CFG.PADD * (i + 3) + CFG.BUTTON_H * (i + 2), CFG.BUTTON_W + CFG.BUTTON_W / 2, CFG.BUTTON_H, true));
        }
        menuElements.add(new Button_Classic_LR_Line(null, -1, CFG.GAMEWIDTH / 2, CFG.PADD, CFG.GAMEWIDTH / 2, CFG.BUTTON_H, true));
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.getMenuElem(this.getMenuElemsSize() - 1).setPosY(this.getMenuElem(0).getPosY());
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(this.getMenuElemsSize() - 1).setTextE(CFG.lang.get("Save"));
        this.getTitleM().setText(CFG.lang.get("Union"));
    }

    @Override
    public final void actionEL(int iID) {
        if (iID == this.getMenuElemsSize() - 1) {
            if (CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID < 0) {
                if (CFG.unionsManager.createUnion_Data.lCreateCivTag.length() > 0 && CFG.unionsManager.createUnion_Data.lCivsTags.size() > 1) {
                    CFG.unionsManager.unions.lUnions.add(CFG.unionsManager.createUnion_Data);
                }
            } else if (CFG.unionsManager.createUnion_Data.lCreateCivTag.length() > 0 && CFG.unionsManager.createUnion_Data.lCivsTags.size() > 1) {
                CFG.unionsManager.unions.lUnions.set(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID, CFG.unionsManager.createUnion_Data);
            }
            CFG.unionsManager.saveUnions();
            this.onBackPressed();
            return;
        }
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -2;
                CFG.menus.setMenuID(View.eEDITOR_UNIONS_ADDCIV);
                return;
            }
            case 2: {
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
                CFG.menus.setMenuID(View.eEDITOR_UNIONS_ADDCIV);
                return;
            }
        }
        if ((iID -= 3) % 2 == 0) {
            CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = iID / 2;
            CFG.menus.setMenuID(View.eEDITOR_UNIONS_ADDCIV);
        } else {
            try {
                CFG.unionsManager.createUnion_Data.lCivsTags.remove(iID / 2);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                
            }
            CFG.menus.setMenuID(View.eEDITOR_UNIONS_EDIT);
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eEDITOR_UNIONS);
        CFG.menus.setBackAnimation(true);
    }
}

