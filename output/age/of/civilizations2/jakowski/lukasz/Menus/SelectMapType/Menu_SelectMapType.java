/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.SelectMapType;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic_Wiki;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Description;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Main.Menu_Main;
import age.of.civilizations2.jakowski.lukasz.Menus.SelectMapType.Menu_SelectMapType_Scale;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_SelectMapType
extends Menu {
    public Menu_SelectMapType() {
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
        for (int i = 0; i < CFG.map.getNumOfMaps(); ++i) {
            menuElements.add(new Button_Classic_Description(CFG.map.getMapAuthor(i), CFG.map.getMapName(i), (int)(50.0f * CFG.GUI_SCALE), 0, tY, tempMenuWidth - CFG.BUTTON_W, CFG.BUTTON_H, true, CFG.map.getActiveMapIDN() == i));
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
            menuElements.add(new Button_Classic_Classic_Wiki(i, tempMenuWidth - CFG.BUTTON_W, tY, CFG.BUTTON_W, CFG.BUTTON_H, true){

                @Override
                public void buildElemHover() {
                    if (this.getIsClickable()) {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wiki") + ": ", CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Text(CFG.map.getMapWiki(this.getCurr())));
                        nData.add(new ME_Hover_2Type_Image(Images.wikipedia, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    } else {
                        this.menuElemHover = null;
                    }
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        }
        this.initMenuWithBackButton(null, Menu_Main.getMenuPosX_Default(), 0, tempMenuWidth, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("SelectMapType") + ": AoH2: DE");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        Core.drawMenuBG(oSB, this.getPosX() + iTranslateX, iTranslateY, this.getWidthM(), CFG.GAMEHEIGHT);
        oSB.setColor(Color.WHITE);
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        for (int i = 0; i < CFG.map.getNumOfMaps(); ++i) {
            if (!this.getMenuElem(i * 2 + 2).getIsInView()) continue;
            CFG.map.getIcon(i).drawO(oSB, this.getPosX() + this.getMenuElem(i * 2 + 2).getTextPosElem() / 2 - CFG.map.getIcon(i).getWidth() / 2 + iTranslateX, this.getMenuElem(i * 2 + 2).getPosY() + this.getMenuElem(i * 2 + 2).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + this.getMenuPosY() - CFG.map.getIcon(i).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        Renderer.drawText(oSB, CFG.FONT_BOLD, "Age of History 2: Definitive Edition", CFG.PADD + iTranslateX, CFG.GAMEHEIGHT - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT, new Color(1.0f, 1.0f, 1.0f, 0.25f));
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
        if (iID % 2 == 0) {
            Menu_SelectMapType_Scale.MAP_ID_TO_LOAD = (iID - 2) / 2;
            CFG.menus.setMenuID(View.eSELECT_MAP_TYPE_SCALE);
        } else if (CFG.map.getMapWiki((iID - 2) / 2).length() > 0) {
            CFG.EDITOR_ACTIVE_GAMEDATA_TAG = CFG.map.getMapWiki((iID - 2) / 2);
            CFG.setDialogType(DialogType.GO_TO_WIKI_SCENARIO);
        } else {
            CFG.toastM.addM(CFG.lang.get("NoData"), CFG.COLOR_NEGATIVE_2);
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(CFG.backToMenu);
        CFG.menus.setBackAnimation(true);
    }
}

