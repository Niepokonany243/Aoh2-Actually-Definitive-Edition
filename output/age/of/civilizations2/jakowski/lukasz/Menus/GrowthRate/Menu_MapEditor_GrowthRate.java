
package age.of.civilizations2.jakowski.lukasz.Menus.GrowthRate;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_GrowthRate;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slide;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_GrowthRate
extends Menu {
    public Menu_MapEditor_GrowthRate() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W * 2));
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
                return Editor_GrowthRate.lUndo.size() > 0;
            }
        });
        menuElements.add(new Button_Game("-", -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, true));
        menuElements.add(new Slider(CFG.BUTTON_W * 3 + CFG.PADD * 3, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.GAMEWIDTH - CFG.BUTTON_W * 4 - CFG.PADD * 5, CFG.BUTTON_H, 2, 100, 100){

            @Override
            public void drawSliderBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                super.drawSliderBG_UpdateAnimation();
                oSB.setColor(CFG.getGrowthRateColor(this.getCurr(), 0.7f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.getHeightE());
                oSB.setColor(CFG.getGrowthRateColor(this.getCurr(), 0.9f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.getHeightE(), false, false);
                oSB.setColor(this.getColorRIGHT().r, this.getColorRIGHT().g, this.getColorRIGHT().b, 0.6f);
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() - this.iCurrentPosX - this.iDifference_CurrentPosX, this.getHeightE());
                oSB.setColor(this.getColorRIGHT().r, this.getColorRIGHT().g, this.getColorRIGHT().b, 0.6f);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() - this.iCurrentPosX - this.iDifference_CurrentPosX, this.getHeightE(), true, false);
            }

            @Override
            public String getDrawText() {
                return "" + this.getCurr() + "%";
            }
        });
        menuElements.add(new Button_Game("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, true));
        menuElements.add(new Button_Game_Checkbox(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD, CFG.PADD, CFG.BUTTON_W * 2, true, true){

            @Override
            public boolean getCheckboxSt() {
                return CFG.VIEW_SHOW_VALUES;
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
        this.getMenuElem(7).setTextE(CFG.lang.get("ShowValues"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, iTranslateX, this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Top_Edge_R_Reflected(oSB, this.getMenuElem(3).getPosXE() - CFG.PADD + iTranslateX, iTranslateY, CFG.BUTTON_W * 5 + CFG.PADD * 4, CFG.BUTTON_H + CFG.PADD * 2);
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
                Editor_GrowthRate.popUndo();
                this.getMenuElem(5).setCurr((int)(Editor_GrowthRate.currentGrowthRate * 100.0f));
                return;
            }
            case 4: {
                this.getMenuElem(iID + 1).setCurr(this.getMenuElem(iID + 1).getCurr() - 1);
                Editor_GrowthRate.currentGrowthRate = (float)this.getMenuElem(iID + 1).getCurr() / 100.0f;
                break;
            }
            case 5: {
                Editor_GrowthRate.currentGrowthRate = (float)this.getMenuElem(iID).getCurr() / 100.0f;
                break;
            }
            case 6: {
                this.getMenuElem(iID - 1).setCurr(this.getMenuElem(iID - 1).getCurr() + 1);
                Editor_GrowthRate.currentGrowthRate = (float)this.getMenuElem(iID - 1).getCurr() / 100.0f;
                break;
            }
            case 7: {
                boolean bl = CFG.VIEW_SHOW_VALUES = !CFG.VIEW_SHOW_VALUES;
                if (!CFG.VIEW_SHOW_VALUES) break;
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).getArmyObject(0).updateArmyWidth(CFG.core.getProv(i).getGrowthRate_Pop());
                }
                break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_EDIT);
        CFG.menus.setBackAnimation(true);
        Editor_GrowthRate.lUndo.clear();
        CFG.brushMode = false;
        CFG.editorManager.resetInUseEditors();
        RenderProvince.updateDrawProvinces();
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv(i).getArmyObject(0).updateArmyWidth_Just(i);
        }
    }
}

