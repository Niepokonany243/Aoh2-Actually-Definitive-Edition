
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Remove;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_AlliancesNames_Create
extends Menu {
    private String sPackageName;
    private long lTime = 0L;

    public Menu_AlliancesNames_Create() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic("", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true){

            @Override
            public String getTextToDrawElem() {
                return Menu_AlliancesNames_Create.this.sPackageName + ": " + super.getTextE();
            }
        });
        menuElements.add(new Button_Classic(null, -1, 0, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        for (int i = 0; i < CFG.editorAlliancesNames_GameData.getSize(); ++i) {
            menuElements.add(new Button_Classic(CFG.getAlliances_Random_Names_All_BundleID(CFG.editorAlliancesNames_GameData, i), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (i + 2) + CFG.PADD * (i + 3), CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? new Color(0.1f, 0.1f, 0.1f, 1.0f) : (this.getIsClickable() ? CFG.COLOR_BUTTON_EXTRA_DESCRIPTION : new Color(0.78f, 0.78f, 0.78f, 0.7f));
                }
            });
            menuElements.add(new Button_Classic_Remove(CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * (i + 2) + CFG.PADD * (i + 3), CFG.BUTTON_W * 2, CFG.BUTTON_H, i > 0));
        }
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sPackageName = CFG.lang.get("PackageName");
        this.getMenuElem(0).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(1).setTextE(CFG.editorAlliancesNames_GameData.getPackageName());
        this.getMenuElem(2).setTextE(CFG.lang.get("CreateNewBundleOfWords"));
        this.getTitleM().setText(CFG.lang.get("CreateNewPackage"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (!CFG.toastM.getInView() && this.lTime + 2000L + 725L < System.currentTimeMillis()) {
            String tempText = CFG.getRandomAllianceName(CFG.editorAlliancesNames_GameData);
            if (!tempText.equals("")) {
                CFG.toastM.addM(tempText);
                this.lTime = System.currentTimeMillis();
            } else {
                this.lTime = System.currentTimeMillis() * 2L;
            }
        }
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                if (this.getMenuElemsSize() > 3 && !this.getMenuElem(3).getTextE().equals("")) {
                    if (this.getMenuElem(1).getTextE().length() == 0) {
                        CFG.showKeyboard(1);
                        CFG.toastM.addM(this.sPackageName);
                        CFG.toastM.setTimeInView(2500);
                        break;
                    }
                    CFG.editorAlliancesNames_GameData.setPackageName(this.getMenuElem(1).getTextE());
                    CFG.core.saveAlliancesNamesPackage();
                    this.onBackPressed();
                    break;
                }
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.showKeyboard();
                break;
            }
            case 2: {
                CFG.editorAlliancesNames_GameData.addBundle("");
                CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID = CFG.editorAlliancesNames_GameData.getSize() - 1;
                CFG.menus.setMenuID(View.eGAME_EDITOR_ALLIANCE_NAMES_PACKAGE_CREATE_BUNDLE);
                CFG.toastM.addM(false);
                break;
            }
            default: {
                if (iID % 2 == 0) {
                    CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID = (iID - 3) / 2;
                    CFG.setDialogType(DialogType.REMOVE_RANDOM_ALLIANCES_NAMES_BUNDLE);
                    break;
                }
                CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID = (iID - 3) / 2;
                CFG.menus.setMenuID(View.eGAME_EDITOR_ALLIANCE_NAMES_PACKAGE_CREATE_BUNDLE);
                CFG.toastM.addM(false);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eGAME_EDITOR_ALLIANCE_NAMES_PACKAGE);
        CFG.menus.setBackAnimation(true);
    }

    @Override
    public void setVisibleM(boolean visible) {
        this.lTime = 0L;
        super.setVisibleM(visible);
    }
}

