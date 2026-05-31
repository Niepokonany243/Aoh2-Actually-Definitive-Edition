/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.View.ButtonView;
import age.of.civilizations2.jakowski.lukasz.Button.View.Button_ViewEnd;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Render;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_TopViews
extends Menu {
    public Menu_InGame_TopViews() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = (CFG.GAMEWIDTH - IMGManager.getIMG(Images.topFlagBG).getWidth() + CFG.topBox.leftExtraViewPadding) / 4;
        if (tempWidth > CFG.BUTTON_W * 3) {
            tempWidth = (CFG.GAMEWIDTH - IMGManager.getIMG(Images.topFlagBG).getWidth() + CFG.topBox.leftExtraViewPadding) / 5;
        }
        menuElements.add(new ButtonView(null, 0, 0, tempWidth, IMGManager.getIMG(Images.topFlagBG).getHeight(), true));
        menuElements.add(new ButtonView(null, tempWidth, 0, tempWidth, IMGManager.getIMG(Images.topFlagBG).getHeight(), true));
        menuElements.add(new ButtonView(null, tempWidth * 2, 0, tempWidth, IMGManager.getIMG(Images.topFlagBG).getHeight(), true));
        menuElements.add(new ButtonView(null, tempWidth * 3, 0, tempWidth, IMGManager.getIMG(Images.topFlagBG).getHeight(), true));
        menuElements.add(new ButtonView(null, tempWidth * 4, 0, tempWidth, IMGManager.getIMG(Images.topFlagBG).getHeight(), true));
        menuElements.add(new ButtonView(null, tempWidth * 5, 0, tempWidth, IMGManager.getIMG(Images.topFlagBG).getHeight(), true));
        menuElements.add(new ButtonView(null, tempWidth * 6, 0, tempWidth, IMGManager.getIMG(Images.topFlagBG).getHeight(), true));
        menuElements.add(new ButtonView(null, tempWidth * 7, 0, tempWidth, IMGManager.getIMG(Images.topFlagBG).getHeight(), true));
        menuElements.add(new ButtonView(null, tempWidth * 8, 0, tempWidth, IMGManager.getIMG(Images.topFlagBG).getHeight(), true));
        menuElements.add(new ButtonView(null, tempWidth * 9, 0, tempWidth, IMGManager.getIMG(Images.topFlagBG).getHeight(), true));
        menuElements.add(new ButtonView(null, tempWidth * 10, 0, tempWidth, IMGManager.getIMG(Images.topFlagBG).getHeight(), true));
        menuElements.add(new ButtonView(null, tempWidth * 11, 0, tempWidth, IMGManager.getIMG(Images.topFlagBG).getHeight(), true));
        menuElements.add(new ButtonView(null, tempWidth * 12, 0, tempWidth, IMGManager.getIMG(Images.topFlagBG).getHeight(), true));
        menuElements.add(new Button_ViewEnd(null, tempWidth * 13, 0, tempWidth, IMGManager.getIMG(Images.topFlagBG).getHeight(), true));
        this.initMenu(null, IMGManager.getIMG(Images.topFlagBG).getWidth() - CFG.topBox.leftExtraViewPadding, 0, CFG.GAMEWIDTH - IMGManager.getIMG(Images.topFlagBG).getWidth() + CFG.topBox.leftExtraViewPadding, IMGManager.getIMG(Images.topFlagBG).getHeight() + 1, menuElements);
        this.updateLang();
        this.setVisibleM(false);
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Army"));
        this.getMenuElem(1).setTextE(CFG.lang.get("Economy"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Population"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Diplomacy"));
        this.getMenuElem(4).setTextE(CFG.lang.get("SupplyLines"));
        this.getMenuElem(5).setTextE(CFG.lang.get("TerrainType"));
        this.getMenuElem(6).setTextE(CFG.lang.get("GrowthRate"));
        this.getMenuElem(7).setTextE("Continents");
        this.getMenuElem(8).setTextE("Gold Income");
        this.getMenuElem(9).setTextE(CFG.lang.get("Happiness"));
        this.getMenuElem(10).setTextE("Ports");
        this.getMenuElem(11).setTextE("Fortifications");
        this.getMenuElem(12).setTextE("Watch Towers");
        this.getMenuElem(13).setTextE(CFG.lang.get("TechnologyLevels"));
    }

    @Override
    public void updateMenuElements_IsInView() {
        super.updateMenuElements_IsInView_X();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER = System.currentTimeMillis();
        Render.updateRenderer();
        RenderProvince.updateDrawProvinces();
    }
}

