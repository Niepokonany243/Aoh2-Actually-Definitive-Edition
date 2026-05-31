/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Packages;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Package_ContinentsData;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu_Packages_WorldContinents
extends Menu {
    private List<String> lTags = new ArrayList<String>();
    private List<String> lContinents = new ArrayList<String>();

    public Menu_Packages_WorldContinents() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        try {
            List<String> tempTags = CFG.getFileNames_O("map/data/continents/packges/");
            for (int i = 0; i < tempTags.size(); ++i) {
                menuElements.add(new Button_Classic(CFG.getPackageContinentDataName(tempTags.get(i)), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.GAMEWIDTH, CFG.BUTTON_H, true));
                this.lTags.add(tempTags.get(i));
                this.lContinents.add(CFG.getPackageContinentData_AllNames(tempTags.get(i)));
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            // empty catch block
        }
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("CreateNewPackage"));
        this.getTitleM().setText(CFG.lang.get("ContinentsPackages"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        for (int i = 2; i < this.getMenuElemsSize(); ++i) {
            if (!this.getMenuElem(i).getIsInView()) continue;
            CFG.fontMain.get(0).getData().setScale(0.6f);
            CFG.drawTextDefault(oSB, this.lContinents.get(i - 2), this.getMenuElem(i).getTextPosElem() + this.getMenuElem(i).getTextWidthU() + CFG.PADD + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuElem(i).getHeightE() / 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.6f) + this.getMenuPosY() + iTranslateY, CFG.COLOR_BUTTON_EXTRA_DESCRIPTION);
            CFG.fontMain.get(0).getData().setScale(1.0f);
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                break;
            }
            case 1: {
                CFG.editor_Package_ContinentsData = new Package_ContinentsData();
                CFG.editor_Package_ContinentsData.addContinentTag("1486419009922xximucak");
                CFG.CREATE_PACKAGE_CONTINENT_GAME_DATA_TAG = "" + System.currentTimeMillis() + CFG.extraRandomTag();
                CFG.menus.setMenuID(View.eMAP_EDITOR_CREATE_CONTINENTS_PACKAGE);
                break;
            }
            default: {
                CFG.CREATE_PACKAGE_CONTINENT_GAME_DATA_TAG = this.lTags.get(iID - 2);
                try {
                    FileHandle file = FileManager.loadFile("map/data/continents/packges/" + CFG.CREATE_PACKAGE_CONTINENT_GAME_DATA_TAG);
                    CFG.editor_Package_ContinentsData = (Package_ContinentsData)CFG.deserialize(file.readBytes());
                }
                catch (ClassNotFoundException classNotFoundException) {
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                CFG.menus.setMenuID(View.eMAP_EDITOR_CREATE_CONTINENTS_PACKAGE);
            }
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eGAME_EDITOR);
        CFG.menus.setBackAnimation(true);
        CFG.map.getMapContinents().loadContinents(CFG.map.getMapContinentsPackageTag(CFG.map.getActiveMapIDN()));
    }
}

