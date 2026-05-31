
package age.of.civilizations2.jakowski.lukasz.Menus.MapEditor;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Description;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor
extends Menu {
    public Menu_MapEditor() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LR_Line(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        for (int i = 0; i < CFG.map.getNumOfMaps(); ++i) {
            menuElements.add(new Button_Classic_Description(CFG.map.getMapAuthor(i), CFG.lang.get("MapType") + ": " + CFG.map.getMapName(i), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * (i + 1) + CFG.PADD * (i + 2), CFG.GAMEWIDTH, CFG.BUTTON_H, true, CFG.map.getActiveMapIDN() == i));
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
        }
        this.initMenuWithBackButton(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false), 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("MapEditor") + ": " + CFG.lang.get("Download"));
        this.getTitleM().setText(CFG.lang.get("MapEditor") + " - Age of History 2: Definitive Edition");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.map.getIcon(0).drawO(oSB, this.getMenuElem(1).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(1).getPosY() + this.getMenuElem(1).getHeightE() / 2 - CFG.map.getIcon(0).getHeight() - CFG.CIV_FLAG_HEIGHT / 2 + this.getMenuPosY() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        for (int i = 0; i < CFG.map.getNumOfMaps(); ++i) {
            if (!this.getMenuElem(i + 2).getIsInView()) continue;
            CFG.map.getIcon(i).drawO(oSB, this.getMenuElem(i + 2).getTextPosElem() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElem(i + 2).getPosY() + this.getMenuElem(i + 2).getHeightE() / 2 - CFG.map.getIcon(i).getHeight() - CFG.CIV_FLAG_HEIGHT / 2 + this.getMenuPosY() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
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
                CFG.GO_TO_LINK = "https://store.steampowered.com/app/3381680/";
                CFG.setDialogType(DialogType.GO_TO_LINK);
                return;
            }
        }
        if (CFG.map.getActiveMapIDN() != iID - 2) {
            CFG.RELOAD_SCENARIO = true;
            CFG.FOG_OF_WAR = 1;
            RenderProvince.updateDrawProvinces();
            CFG.map.setActiveMapIDN(iID - 2);
            CFG.goToMenu = View.eMAP_EDITOR_EDIT;
            CFG.menus.setMenuIDWithoutAnim(View.eLOAD_MAP);
        } else {
            CFG.RELOAD_SCENARIO = true;
            CFG.FOG_OF_WAR = 1;
            RenderProvince.updateDrawProvinces();
            CFG.menus.setMenuID(View.eMAP_EDITOR_EDIT);
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eEDITOR);
        CFG.menus.setBackAnimation(true);
    }
}

