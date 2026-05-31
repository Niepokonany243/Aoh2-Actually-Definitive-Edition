
package age.of.civilizations2.jakowski.lukasz.Menus.Continents;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Continents_CreateNewContinent
extends Menu {
    private String sName;
    private int iNameWidth;

    public Menu_Continents_CreateNewContinent() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Classic("", -1, CFG.BUTTON_W + CFG.PADD * 2, 0, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.PADD * 2) * 2, CFG.BUTTON_H + CFG.PADD * 2, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? new Color(0.82f, 0.82f, 0.82f, 1.0f) : (this.getIsClickable() ? new Color(1.0f, 1.0f, 1.0f, 1.0f) : new Color(0.84f, 0.84f, 0.84f, 0.7f));
            }

            @Override
            public String getTextToDrawElem() {
                return Menu_Continents_CreateNewContinent.this.sName + ": " + super.getTextE();
            }

            @Override
            public int getTextWidthU() {
                return super.getTextWidthU() + Menu_Continents_CreateNewContinent.this.iNameWidth;
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.BUTTON_H + CFG.PADD * 3, CFG.BUTTON_W * 2){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                oSB.setColor(new Color(CFG.editor_Continent_GameData.getR(), CFG.editor_Continent_GameData.getG(), CFG.editor_Continent_GameData.getB(), 1.0f));
                IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2, this.getPosY() + this.getHeightE() / 2 + this.getTextHeight() / 2 + CFG.PADD, this.getTextWidthU(), CFG.CIV_COLOR_W);
                oSB.setColor(Color.WHITE);
            }

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? new Color(CFG.editor_Continent_GameData.getR(), CFG.editor_Continent_GameData.getG(), CFG.editor_Continent_GameData.getB(), 1.0f) : (this.getIsClickable() ? new Color(0.38f, 0.38f, 0.38f, 1.0f) : new Color(0.49f, 0.49f, 0.49f, 0.5f));
            }
        });
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sName = CFG.lang.get("ContinentName");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sName + ": ");
        this.iNameWidth = (int)CFG.glyphLay.width;
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.editor_Continent_GameData.getName());
        this.getMenuElem(2).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Color"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_EdgeR(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        CFG.drawEditorButtons_Top_Edge_R(oSB, iTranslateX, CFG.BUTTON_H + CFG.PADD * 2, this.getMenuElem(3).getWidthE() + CFG.PADD * 2, this.getMenuElem(3).getHeightE() + CFG.PADD * 2);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                this.onBackPressed();
                return;
            }
            case 1: {
                CFG.showKeyboard();
                return;
            }
            case 2: {
                if (this.getMenuElem(1).getTextE().length() > 0) {
                    CFG.editor_Continent_GameData.setName(this.getMenuElem(1).getTextE());
                    CFG.core.saveContinentPackagesData();
                    this.onBackPressed();
                } else {
                    CFG.showKeyboard(1);
                    CFG.toastM.addM(this.sName);
                    CFG.toastM.setTimeInView(2500);
                }
                return;
            }
            case 3: {
                if (CFG.menus.getColorPicker().getVisible()) {
                    CFG.menus.getColorPicker().setVisible(false, null);
                } else {
                    CFG.menus.getColorPicker().setPosX(CFG.PADD * 3);
                    CFG.menus.getColorPicker().setPosY(this.getMenuElem(3).getPosY() + this.getMenuElem(3).getHeightE() + CFG.PADD + CFG.menus.getColorPicker().getPosX());
                    CFG.menus.getColorPicker().setActiveRGBColor(CFG.editor_Continent_GameData.getR(), CFG.editor_Continent_GameData.getG(), CFG.editor_Continent_GameData.getB());
                    CFG.menus.getColorPicker().setVisible(true, ColorPicker_AoC.PickerAction.MAP_EDITOR_CONTINENT_COLOR);
                }
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        CFG.menus.getColorPicker().setVisible(false, null);
        CFG.menus.setMenuID(CFG.backToMenu);
        CFG.menus.setBackAnimation(true);
        RenderProvince.updateDrawProvinces();
    }
}

