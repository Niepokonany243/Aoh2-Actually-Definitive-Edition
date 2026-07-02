
package age.of.civilizations2.jakowski.lukasz.Menus.SelectMapType;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Main.Menu_Main;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_SelectMapType_Scale
extends Menu {
    public static int MAP_ID_TO_LOAD = 0;

    public Menu_SelectMapType_Scale() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempMenuWidth = Menu_Main.getMenuWidth_Default();
        int tY = 0;
        menuElements.add(new Button_Classic_LR_Main(null, -1, 0, 0, tempMenuWidth, CFG.BUTTON_H, true));
        menuElements.add(new Text(null, -1, 0, tY, tempMenuWidth, CFG.BUTTON_H * 3 / 4){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.drawRect_InfoBox_Right_Title(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
                CFG.drawTextDefaultWithShadow(oSB, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_CIV_INFO_TITLE);
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        ArrayList<Integer> tempScales = CFG.map.getProvinceTextureScales(MAP_ID_TO_LOAD);
        for (i = 0; i < tempScales.size(); ++i) {
            if (CFG.map.getActiveMapIDN() == MAP_ID_TO_LOAD) {
                if (CFG.map.getMapScale_PreExtra(CFG.map.getActiveMapIDN()) == ((Integer)tempScales.get(i)).intValue()) {
                    menuElements.add(new Button_Classic(CFG.lang.get("Scale") + " x" + tempScales.get(i) + " - [" + CFG.map.getMpB().getWidthM() / CFG.map.getMapScale(CFG.map.getActiveMapIDN()) * (Integer)tempScales.get(i) + "x" + CFG.map.getMpB().getHeightM() / CFG.map.getMapScale(CFG.map.getActiveMapIDN()) * (Integer)tempScales.get(i) + "]", (int)(50.0f * CFG.GUI_SCALE), 0, tY, tempMenuWidth, CFG.BUTTON_H, true, true));
                } else {
                    menuElements.add(new Button_Classic(CFG.lang.get("Scale") + " x" + tempScales.get(i) + " - [" + CFG.map.getMpB().getWidthM() / CFG.map.getMapScale(CFG.map.getActiveMapIDN()) * (Integer)tempScales.get(i) + "x" + CFG.map.getMpB().getHeightM() / CFG.map.getMapScale(CFG.map.getActiveMapIDN()) * (Integer)tempScales.get(i) + "]", (int)(50.0f * CFG.GUI_SCALE), 0, tY, tempMenuWidth, CFG.BUTTON_H, true));
                }
            } else {
                menuElements.add(new Button_Classic(CFG.lang.get("Scale") + " x" + tempScales.get(i) + " - [" + CFG.lang.get("NoData").toUpperCase() + "]", (int)(50.0f * CFG.GUI_SCALE), 0, tY, tempMenuWidth, CFG.BUTTON_H, true));
            }
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        this.initMenuWithBackButton(null, Menu_Main.getMenuPosX_Default(), 0, tempMenuWidth, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("SelectMapScale") + ": AoH2:DE");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        Core.drawMenuBG(oSB, this.getPosX() + iTranslateX, iTranslateY, this.getWidthM(), CFG.GAMEHEIGHT);
        oSB.setColor(Color.WHITE);
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        for (int i = 0; i < this.getMenuElemsSize() - 2; ++i) {
            if (!this.getMenuElem(i + 2).getIsInView()) continue;
            CFG.map.getIcon(CFG.map.getActiveMapIDN()).drawO(oSB, this.getPosX() + this.getMenuElem(i + 2).getTextPosElem() / 2 - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getWidth() / 2 + iTranslateX, this.getMenuElem(i + 2).getPosY() + this.getMenuElem(i + 2).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + this.getMenuPosY() - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        Renderer.drawText(oSB, CFG.FONT_BOLD, "Age of History 2: Definitive Edition", CFG.PADD + iTranslateX, CFG.GAMEHEIGHT - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT, new Color(1.0f, 1.0f, 1.0f, 0.25f));
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
                return;
            }
        }
        ArrayList<Integer> tempScales = CFG.map.getProvinceTextureScales(MAP_ID_TO_LOAD);
        CFG.map.setMapScale(MAP_ID_TO_LOAD, tempScales.get(iID - 2));
        CFG.map.setActiveMapIDN(MAP_ID_TO_LOAD);
        CFG.goToMenu = View.eSELECT_MAP_TYPE;
        CFG.menus.setMenuIDWithoutAnim(View.eLOAD_MAP);
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(View.eSELECT_MAP_TYPE);
        CFG.menus.setBackAnimation(true);
    }
}

