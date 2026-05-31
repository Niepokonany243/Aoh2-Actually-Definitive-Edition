
package age.of.civilizations2.jakowski.lukasz.Menus.Terrain;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_TerrainType;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slide;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_Terrain
extends Menu {
    public Menu_MapEditor_Terrain() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W * 2));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD, CFG.PADD, CFG.BUTTON_W * 2, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.brushMode;
            }
        });
        menuElements.add(new Slide(CFG.PADD + IMGManager.getIMG(Images.slideBG).getHeight() / 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 3 - IMGManager.getIMG(Images.slideBG).getHeight() * 2 - IMGManager.getIMG(Images.slideBG).getHeight() / 2, false));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 3 - CFG.PADD * 2, CFG.PADD, CFG.BUTTON_W){

            @Override
            public boolean getIsClickable() {
                return Editor_TerrainType.lUndo.size() > 0;
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Brush"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Undo"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, this.getMenuElem(0).getPosXE() - CFG.PADD + iTranslateX, this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, this.getMenuElem(0).getWidthE() + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Top_Edge_R_Reflected(oSB, this.getMenuElem(3).getPosXE() - CFG.PADD + iTranslateX, iTranslateY, CFG.BUTTON_W * 3 + CFG.PADD * 3, CFG.BUTTON_H + CFG.PADD * 2);
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
                CFG.brushMode = !CFG.brushMode;
                this.getMenuElem(iID).setCheckboxSt(CFG.brushMode);
                this.getMenuElem(iID + 1).setVisibleE(CFG.brushMode);
                return;
            }
            case 3: {
                Editor_TerrainType.popUndo();
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_EDIT);
        CFG.menus.setBackAnimation(true);
        Editor_TerrainType.lUndo.clear();
        CFG.brushMode = false;
        CFG.editorManager.resetInUseEditors();
        RenderProvince.updateDrawProvinces();
    }
}

