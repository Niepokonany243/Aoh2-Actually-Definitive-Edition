
package age.of.civilizations2.jakowski.lukasz.Menus.Packages;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.PalletOfCivsColors_Data;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Packages_PalletOfCivsColors
extends Menu {
    public Menu_Packages_PalletOfCivsColors() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        for (int i = 0; i < CFG.palletManager.getNumOfPallets(); ++i) {
            menuElements.add(new Button_Classic("", (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.GAMEWIDTH, CFG.BUTTON_H, true){
                int iCurrent;
                {
                    this.iCurrent = 0;
                }

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    CFG.palletManager.drawSampleColors(oSB, this.getPosXE() + this.getWidthE() / 2 - CFG.BUTTON_W + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getHeightE() / 4 + Menu_Packages_PalletOfCivsColors.this.getMenuPosY(), CFG.BUTTON_W * 2, this.getHeightE() / 2, this.iCurrent, isActive);
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.iCurrent = nCurrent;
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
        }
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("CreateNewPackage"));
        this.getTitleM().setText(CFG.lang.get("PalletCivColorsPackages"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.palletManager.loadCivilizationsPaletteOfColors(CFG.palletManager.getActivePalletID());
                CFG.editorPalletOfCivsColors_Data = new PalletOfCivsColors_Data();
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = "" + System.currentTimeMillis() + CFG.extraRandomTag();
                CFG.menus.setMenuID(View.eGAME_EDITOR_PALLETS_OF_CIVS_COLORS_PACKAGES_EDIT);
                break;
            }
            default: {
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = CFG.palletManager.getPalletTag(iID - 2);
                if (CFG.editorPalletOfCivsColors_Data == null) {
                    CFG.editorPalletOfCivsColors_Data = new PalletOfCivsColors_Data();
                }
                CFG.editorPalletOfCivsColors_Data.readData(CFG.palletManager.getIsInternal(iID - 2));
                CFG.menus.setMenuID(View.eGAME_EDITOR_PALLETS_OF_CIVS_COLORS_PACKAGES_EDIT);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.palletManager.loadCivilizationsPaletteOfColors(CFG.palletManager.getActivePalletID());
        CFG.menus.setMenuID(View.eGAME_EDITOR);
        CFG.menus.setBackAnimation(true);
    }
}

