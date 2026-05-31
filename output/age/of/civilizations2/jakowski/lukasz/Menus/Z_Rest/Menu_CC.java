
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_ArrowDown;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_ArrowLeft;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_ArrowRight;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_ArrowUp;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CC
extends Menu {
    private String sName;
    private int iNameWidth;

    public Menu_CC() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Game(null, -1, CFG.PADD, CFG.PADD, true));
        menuElements.add(new Button_Classic("", -1, CFG.BUTTON_W + CFG.PADD * 2, 0, CFG.GAMEWIDTH - (CFG.BUTTON_W + CFG.PADD * 2) * 2, CFG.BUTTON_H + CFG.PADD * 2, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive || this.getIsHovered() ? new Color(0.82f, 0.82f, 0.82f, 1.0f) : (this.getIsClickable() ? new Color(1.0f, 1.0f, 1.0f, 1.0f) : new Color(0.84f, 0.84f, 0.84f, 0.7f));
            }

            @Override
            public String getTextToDrawElem() {
                return Menu_CC.this.sName + ": " + super.getTextE();
            }

            @Override
            public int getTextWidthU() {
                return super.getTextWidthU() + Menu_CC.this.iNameWidth;
            }

            @Override
            public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
            }
        });
        menuElements.add(new Button_Game(null, -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.PADD, false){

            @Override
            public final Color getColorE(boolean isActive) {
                return isActive ? new Color(0.75f, 0.8f, 0.03f, 1.0f) : (this.getIsClickable() ? CFG.COLOR_HOVER_TITLE : new Color(0.674f, 0.09f, 0.066f, 0.5f));
            }
        });
        menuElements.add(new Button_Game("-", -1, CFG.BUTTON_W * 3 + CFG.PADD * 5, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true));
        menuElements.add(new Button_Game("+", -1, CFG.GAMEWIDTH - CFG.BUTTON_W - CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, true));
        menuElements.add(new Slider("", CFG.BUTTON_W * 4 + CFG.PADD * 6, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, CFG.GAMEWIDTH - CFG.BUTTON_W * 5 - CFG.PADD * 8, CFG.BUTTON_H, 0, 4, 2){

            @Override
            public void drawSliderText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(CFG.editorCity.getCityLevel()).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(CFG.editorCity.getCityLevel()).getHeight() / 2);
                super.drawSliderText(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
            }

            @Override
            public String getDrawText() {
                return this.getTextE();
            }
        });
        menuElements.add(new Button_Game_ArrowLeft(CFG.PADD, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, false));
        menuElements.add(new Button_Game_ArrowDown(CFG.BUTTON_W + CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, false));
        menuElements.add(new Button_Game_ArrowRight(CFG.BUTTON_W * 2 + CFG.PADD * 3, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, false));
        menuElements.add(new Button_Game_ArrowUp(CFG.BUTTON_W + CFG.PADD * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2 - CFG.PADD * 2, false));
        menuElements.add(new Button_Transparent(0, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2 - CFG.PADD * 3, CFG.BUTTON_W * 3 + CFG.PADD * 4, CFG.BUTTON_H * 2 + CFG.PADD * 3, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sName = CFG.lang.get("CityName");
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sName + ": ");
        this.iNameWidth = (int)CFG.glyphLay.width;
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Save"));
        this.getMenuElem(5).setTextE(CFG.lang.get("CityLevel") + ": " + CFG.getCityLevelName(this.getMenuElem(5).getCurr()));
        if (CFG.editorCity != null) {
            if (CFG.editorCity.getCityName() != null) {
                this.getMenuElem(1).setTextE(CFG.editorCity.getCityName());
            }
            this.getMenuElem(5).setCurr(CFG.getEditorCityLevel_Ref(CFG.editorCity.getCityLevel()));
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawEditorTitle_EdgeR(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H + CFG.PADD * 2);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, iTranslateX, CFG.GAMEHEIGHT - CFG.BUTTON_H * 2 - CFG.PADD * 3 - 1 - Core.PADDING - IMGManager.getIMG(Images.gameTopEdge).getHeight(), CFG.BUTTON_W * 3 + CFG.PADD * 4 + 1, CFG.BUTTON_H * 2 + CFG.PADD * 3 + 1 + Core.PADDING, true, false);
        IMGManager.getIMG(Images.gameTopEdgeLineHorizontal).draw2O(oSB, CFG.BUTTON_W * 3 + CFG.PADD * 4 + 1 + iTranslateX, CFG.GAMEHEIGHT - Core.PADDING - CFG.BUTTON_H - CFG.PADD * 2 - 1 - IMGManager.getIMG(Images.gameTopEdgeLineHorizontal).getHeight(), CFG.GAMEWIDTH - (CFG.BUTTON_W * 3 + CFG.PADD * 4 + 1), CFG.BUTTON_H + CFG.PADD * 2 + Core.PADDING + 1, true, false);
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
                if (CFG.editorCity.getCityName() != null && CFG.editorCity.getCityName().length() > 0) {
                    if (CFG.backToMenu == View.eINGAME) {
                        CFG.core.saveCityInGame();
                    } else {
                        CFG.core.saveCity();
                    }
                    this.onBackPressed();
                }
                return;
            }
            case 3: {
                this.getMenuElem(5).setCurr(this.getMenuElem(5).getCurr() - 1);
                this.updateEditorCityLevel(this.getMenuElem(5).getCurr());
                this.getMenuElem(5).setTextE(CFG.lang.get("CityLevel") + ": " + CFG.getCityLevelName(this.getMenuElem(5).getCurr()));
                return;
            }
            case 4: {
                this.getMenuElem(5).setCurr(this.getMenuElem(5).getCurr() + 1);
                this.updateEditorCityLevel(this.getMenuElem(5).getCurr());
                this.getMenuElem(5).setTextE(CFG.lang.get("CityLevel") + ": " + CFG.getCityLevelName(this.getMenuElem(5).getCurr()));
                return;
            }
            case 5: {
                this.updateEditorCityLevel(this.getMenuElem(5).getCurr());
                this.getMenuElem(5).setTextE(CFG.lang.get("CityLevel") + ": " + CFG.getCityLevelName(this.getMenuElem(5).getCurr()));
                return;
            }
            case 6: {
                this.updatePosX(-1);
                return;
            }
            case 7: {
                this.updatePosY(1);
                return;
            }
            case 8: {
                this.updatePosX(1);
                return;
            }
            case 9: {
                this.updatePosY(-1);
                return;
            }
        }
    }

    private final void updatePosX(int nDiff) {
        if (CFG.editorCity.getPoX() >= 0) {
            CFG.editorCity.setPosX(CFG.editorCity.getPoX() + nDiff);
            if (CFG.editorCity.getPoX() > CFG.map.getMpB().getWidthM() / CFG.map.getMpB().getMapSc3()) {
                CFG.editorCity.setPosX(CFG.editorCity.getPoX() % (CFG.map.getMpB().getWidthM() / CFG.map.getMpB().getMapSc3()));
            }
            this.updateActiveProvince();
        }
    }

    private final void updatePosY(int nDiff) {
        if (CFG.editorCity.getPosY() >= 0) {
            CFG.editorCity.setPosY(CFG.editorCity.getPosY() + nDiff);
            if (CFG.editorCity.getPosY() > CFG.map.getMpB().getHeightM() / CFG.map.getMpB().getMapSc3()) {
                CFG.editorCity.setPosY(CFG.map.getMpB().getHeightM() / CFG.map.getMpB().getMapSc3());
            } else if (CFG.editorCity.getPosY() < 0) {
                CFG.editorCity.setPosY(0);
            }
            this.updateActiveProvince();
        }
    }

    private final void updateActiveProvince() {
        CFG.core.setProvinceID(CFG.map.getMpC().getPX() + CFG.editorCity.getPoX() * CFG.map.getMpB().getMapSc3(), CFG.map.getMpC().getPY() + CFG.editorCity.getPosY() * CFG.map.getMpB().getMapSc3());
        CFG.menus.getCreateCity_UpdateSaveButton();
        if (CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && !CFG.core.getProv(CFG.core.getActiveProvID()).getDrawProv()) {
            CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
        }
    }

    private final void updateEditorCityLevel(int nLevel) {
        CFG.editorCity.setCityLevel(CFG.getEditorCityLevel(nLevel));
    }

    @Override
    public void onBackPressed() {
        CFG.core.setActiveProvID(-1);
        CFG.menus.setMenuID(CFG.backToMenu);
        CFG.menus.setBackAnimation(true);
        CFG.updateKeyboard_Actions();
    }
}

