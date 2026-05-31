
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Remove;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Menu_AlliancesNames_Create_Bundle
extends Menu {
    private String sWord;

    public Menu_AlliancesNames_Create_Bundle() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        for (int i = 0; i < CFG.editorAlliancesNames_GameData.getBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).getWordsSize(); ++i) {
            menuElements.add(new Button_Classic(CFG.editorAlliancesNames_GameData.getBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).getWord(i), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

                @Override
                public String getTextToDrawElem() {
                    return Menu_AlliancesNames_Create_Bundle.this.sWord + ": " + super.getTextE();
                }
            });
            menuElements.add(new Button_Classic_Remove(CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.BUTTON_W * 2, CFG.BUTTON_H, i > 0));
        }
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sWord = CFG.lang.get("Word");
        this.getMenuElem(0).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(1).setTextE(CFG.lang.get("AddNewWord"));
        this.getTitleM().setText(CFG.lang.get("CreateNewBundleOfWords"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.editorAlliancesNames_GameData.getBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).addWord("");
                this.updateBundle();
                CFG.menus.setMenuID(View.eGAME_EDITOR_ALLIANCE_NAMES_PACKAGE_CREATE_BUNDLE);
                CFG.showKeyboard(0, CFG.editorAlliancesNames_GameData.getBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).getWordsSize() * 2);
                CFG.toastM.addM(this.sWord);
                break;
            }
            default: {
                if (iID % 2 == 0) {
                    CFG.showKeyboard();
                    break;
                }
                for (int i = 0; i * 2 + 2 < this.getMenuElemsSize() && i < CFG.editorAlliancesNames_GameData.getBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).getWordsSize(); ++i) {
                    CFG.editorAlliancesNames_GameData.getBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).setWord(i, this.getMenuElem(i * 2 + 2).getTextE());
                }
                CFG.editorAlliancesNames_GameData.getBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).removeWord((iID - 2) / 2);
                CFG.menus.setMenuID(View.eGAME_EDITOR_ALLIANCE_NAMES_PACKAGE_CREATE_BUNDLE);
            }
        }
    }

    private final void updateBundle() {
        for (int i = 0; i * 2 + 2 < this.getMenuElemsSize() && i < CFG.editorAlliancesNames_GameData.getBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).getWordsSize(); ++i) {
            CFG.editorAlliancesNames_GameData.getBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).setWord(i, this.getMenuElem(i * 2 + 2).getTextE());
        }
    }

    @Override
    public final void onBackPressed() {
        this.updateBundle();
        for (int i = 0; i < CFG.editorAlliancesNames_GameData.getBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).getWordsSize(); ++i) {
            if (!CFG.editorAlliancesNames_GameData.getBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).getWord(i).equals("")) continue;
            CFG.editorAlliancesNames_GameData.getBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).removeWord(i);
            --i;
        }
        if (CFG.editorAlliancesNames_GameData.getBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID).getWordsSize() == 0) {
            CFG.editorAlliancesNames_GameData.removeBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID);
        }
        CFG.menus.setMenuID(View.eGAME_EDITOR_ALLIANCE_NAMES_PACKAGE_CREATE);
        CFG.menus.setBackAnimation(true);
    }
}

