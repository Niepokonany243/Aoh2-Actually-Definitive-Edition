
package age.of.civilizations2.jakowski.lukasz.Menus.DiplomacyC;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_DiplomacyColors_Create
extends Menu {
    private String sName;
    private int iNameWidth;

    public Menu_DiplomacyColors_Create() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Classic("", -1, CFG.BUTTON_W + CFG.PADD * 2, 0, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.PADD * 2) * 2, CFG.BUTTON_H + CFG.PADD * 2, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? new Color(0.82f, 0.82f, 0.82f, 1.0f) : (this.getIsClickable() ? new Color(1.0f, 1.0f, 1.0f, 1.0f) : new Color(0.84f, 0.84f, 0.84f, 0.7f));
            }

            @Override
            public String getTextToDrawElem() {
                return Menu_DiplomacyColors_Create.this.sName + ": " + super.getTextE();
            }

            @Override
            public int getTextWidthU() {
                return super.getTextWidthU() + Menu_DiplomacyColors_Create.this.iNameWidth;
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sName = CFG.lang.get("PackageName");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sName + ": ");
        this.iNameWidth = (int)CFG.glyphLay.width;
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.diplomacyColors_GameData.getName());
        this.getMenuElem(2).setTextE(CFG.lang.get("Save"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, iTranslateX, -IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2, false, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
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
                if (this.getMenuElem(1).getTextE().equals("")) {
                    CFG.toastM.addM(this.sName);
                    CFG.showKeyboard(1);
                } else {
                    CFG.diplomacyColors_GameData.setName(this.getMenuElem(1).getTextE());
                    CFG.core.saveDiplomacyColors();
                    this.onBackPressed();
                }
                return;
            }
        }
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void onBackPressed() {
        CFG.menus.getColorPicker().setVisible(false, null);
        CFG.menus.setMenuID(View.eGAME_EDITOR_DIPLOMACY_COLORS_PACKAGES);
        CFG.menus.setBackAnimation(true);
        RenderProvince.updateDrawProvinces();
    }
}

