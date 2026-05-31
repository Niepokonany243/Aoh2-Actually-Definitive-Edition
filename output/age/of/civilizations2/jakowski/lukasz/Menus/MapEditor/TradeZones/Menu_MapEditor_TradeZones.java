
package age.of.civilizations2.jakowski.lukasz.Menus.MapEditor.TradeZones;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Sliders.ZRest.Slider_Age;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_TradeZones
extends Menu {
    public Menu_MapEditor_TradeZones() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.BUTTON_W * 2));
        menuElements.add(new Button_Game("-", -1, CFG.BUTTON_W * 2 + CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, true));
        menuElements.add(new Slider_Age("", CFG.BUTTON_W * 3 + CFG.PADD * 3, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, CFG.GAMEWIDTH - CFG.BUTTON_W * 4 - CFG.PADD * 5, CFG.BUTTON_H, 0, CFG.gameAges.getAgesSize() - 1, 0){

            @Override
            public String getDrawText() {
                return CFG.gameAges.getAge(this.getCurr()).getName() + ": [" + CFG.gameAges.getYear(CFG.gameAges.getAge(this.getCurr()).getBeginningYear()) + " - " + CFG.gameAges.getYear(CFG.gameAges.getAge(this.getCurr()).getEndYear()) + "]";
            }
        });
        menuElements.add(new Button_Game("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.GAMEHEIGHT - CFG.PADD - CFG.BUTTON_H, true));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 4 - CFG.PADD * 3, CFG.PADD, CFG.BUTTON_W * 2));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2 - CFG.PADD * 2, CFG.PADD, CFG.BUTTON_W));
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, CFG.BUTTON_W));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(4).setTextE(CFG.lang.get("AddNewTradeZone"));
        this.getMenuElem(5).setTextE(CFG.lang.get("Edit"));
        this.getMenuElem(6).setTextE(CFG.lang.get("Remove"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, iTranslateX, this.getMenuElem(0).getPosY() - CFG.PADD - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Top_Edge_R_Reflected(oSB, this.getMenuElem(4).getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + iTranslateY, CFG.GAMEWIDTH - this.getMenuElem(4).getPosXE() + CFG.PADD * 2, CFG.BUTTON_H + CFG.PADD * 2);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
    }

    @Override
    public void onBackPressed() {
        CFG.menus.setMenuID(View.eMAP_EDITOR_EDIT);
        CFG.menus.setBackAnimation(true);
        RenderProvince.updateDrawProvinces();
    }
}

