
package age.of.civilizations2.jakowski.lukasz.Menus.MapEditor;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_Regions;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slide;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_OptimizationRegions
extends Menu {
    public static boolean showValues = true;

    public Menu_MapEditor_OptimizationRegions() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.BUTTON_W + CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 4 - CFG.PADD * 2, CFG.PADD, CFG.BUTTON_W * 2, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.brushMode;
            }
        });
        menuElements.add(new Slide(CFG.PADD + IMGManager.getIMG(Images.slideBG).getHeight() / 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 3 - IMGManager.getIMG(Images.slideBG).getHeight() * 2 - IMGManager.getIMG(Images.slideBG).getHeight() / 2, false));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 5 - CFG.PADD * 3, CFG.PADD, CFG.BUTTON_W){

            @Override
            public boolean getIsClickable() {
                return Editor_Regions.lUndo.size() > 0;
            }
        });
        menuElements.add(new Button_Game("-", -1, CFG.BUTTON_W * 2 + CFG.PADD * 3, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, true));
        menuElements.add(new Slider(CFG.BUTTON_W * 3 + CFG.PADD * 4, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.GAMEWIDTH - CFG.BUTTON_W * 4 - CFG.PADD * 6, CFG.BUTTON_H, 0, CFG.core.getRegions().size(), 0){

            @Override
            public String getDrawText() {
                return "SET TO REGION ID: " + this.getCurr();
            }
        });
        menuElements.add(new Button_Game("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, true));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD, CFG.PADD, CFG.BUTTON_W * 2, true, true){

            @Override
            public boolean getCheckboxSt() {
                return showValues;
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD * 3 - CFG.BUTTON_H * 2, CFG.BUTTON_W * 2));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Brush"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Undo"));
        this.getMenuElem(7).setTextE(CFG.lang.get("ShowValues"));
        this.getMenuElem(8).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(9).setTextE("CENTER TO REGION");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, iTranslateX, this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Top_Edge_R_Reflected(oSB, this.getMenuElem(3).getPosXE() - CFG.PADD + iTranslateX, iTranslateY, CFG.BUTTON_W * 5 + CFG.PADD * 4, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Bot_Edge_R_Reflected(oSB, this.getMenuElem(9).getPosXE() - CFG.PADD + iTranslateX, this.getMenuElem(9).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(9).getWidthE() + CFG.PADD * 2, this.getMenuElem(9).getHeightE() + CFG.PADD * 2);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                Editor_Regions.saveRegions();
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
                Editor_Regions.popUndo();
                this.getMenuElem(5).setCurr(Editor_Regions.activeRegion);
                this.getMenuElem(5).setMax(CFG.core.getRegions().size());
                return;
            }
            case 4: {
                this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
                Editor_Regions.activeRegion = this.getMenuElem(iID + 1).getCurr();
                this.getMenuElem(5).setMax(CFG.core.getRegions().size());
                this.centerToActiveRegionID();
                break;
            }
            case 5: {
                Editor_Regions.activeRegion = this.getMenuElem(iID).getCurr();
                this.getMenuElem(5).setMax(CFG.core.getRegions().size());
                this.centerToActiveRegionID();
                break;
            }
            case 6: {
                this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
                Editor_Regions.activeRegion = this.getMenuElem(iID - 1).getCurr();
                this.getMenuElem(5).setMax(CFG.core.getRegions().size());
                this.centerToActiveRegionID();
                break;
            }
            case 7: {
                boolean bl = showValues = !showValues;
                if (!showValues) break;
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).getArmyObject(0).updateArmyWidth(CFG.core.getRegionID(i));
                }
                break;
            }
            case 8: {
                this.onBackPressed();
                CFG.core.loadRegions();
                break;
            }
            case 9: {
                this.centerToActiveRegionID();
            }
        }
    }

    private final void centerToActiveRegionID() {
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getRegionID(i) != Editor_Regions.activeRegion) continue;
            CFG.map.getMpC().centerToProvID(i);
            CFG.core.setActiveProvID(i);
            return;
        }
        CFG.toastM.addM("0 PROVINCES");
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_EDIT);
        CFG.menus.setBackAnimation(true);
        Editor_Regions.lUndo.clear();
        CFG.brushMode = false;
        CFG.editorManager.resetInUseEditors();
        RenderProvince.updateDrawProvinces();
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv(i).getArmyObject(0).updateArmyWidth_Just(i);
        }
    }
}

