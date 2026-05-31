
package age.of.civilizations2.jakowski.lukasz.Menus.Victory;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Description;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_GamesTitle;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.VictoryManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_VictoryConditions
extends Menu {
    public Menu_VictoryConditions() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempMenuWidth = Menu_GamesTitle.getMenuWidth();
        int tY = 0;
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, 0, tempMenuWidth, CFG.BUTTON_H, true){

            @Override
            public void actionElem(int iID) {
                Menu_VictoryConditions.this.onBackPressed();
            }
        });
        menuElements.add(new Text(null, -1, 0, tY, tempMenuWidth, CFG.BUTTON_H * 3 / 4){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.drawRect_InfoBox_Right_Title(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_CIV_INFO_TITLE);
            }
        });
        menuElements.add(new Button_Classic_Description(CFG.lang.get("AnnihilateAllOfYourEnemies"), CFG.lang.get("Domination"), (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempMenuWidth, CFG.BUTTON_H, true, true));
        menuElements.add(new Slider("", CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, tempMenuWidth - CFG.PADD * 2, CFG.BUTTON_H - CFG.PADD * 2, 2, 100, VictoryManager.VICTORY_CONTROL_PROVINCES_PERC){

            @Override
            public void drawSliderText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getDrawText(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(0.945f, 0.945f, 0.945f, 1.0f));
            }

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                IMGManager.getIMG(Images.btnMenu1H).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - CFG.PADD + iTranslateY, this.getWidthE() + CFG.PADD * 2);
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
            }

            @Override
            public String getDrawText() {
                return super.getTextE() + ": " + this.getCurr() + "%";
            }

            @Override
            public Color getColorLEFT() {
                return CFG.COLOR_POP_GRADIENT[CFG.COLOR_POP_GRADIENT.length - 1];
            }

            @Override
            public void actionElem(int iID) {
                VictoryManager.VICTORY_CONTROL_PROVINCES_PERC = this.getCurr();
            }
        });
        menuElements.add(new Slider("", CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, tempMenuWidth - CFG.PADD * 2, CFG.BUTTON_H - CFG.PADD * 2, 0, 100, VictoryManager.VICTORY_LIMIT_OF_TURNS / 10){

            @Override
            public void drawSliderText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getDrawText(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(0.945f, 0.945f, 0.945f, 1.0f));
            }

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                IMGManager.getIMG(Images.btnMenu1H).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - CFG.PADD + iTranslateY, this.getWidthE() + CFG.PADD * 2);
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
            }

            @Override
            public String getDrawText() {
                return super.getTextE() + (this.getCurr() == 0 ? CFG.lang.get("NoThanks") : CFG.lang.get("TurnsX", this.getCurr() * 10));
            }

            @Override
            public void actionElem(int iID) {
                VictoryManager.VICTORY_LIMIT_OF_TURNS = this.getCurr() * 10;
            }
        });
        menuElements.add(new Slider("", CFG.PADD, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2, tempMenuWidth - CFG.PADD * 2, CFG.BUTTON_H - CFG.PADD * 2, 0, (int)(GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL * 100.0f), (int)(VictoryManager.VICTORY_TECHNOLOGY * 100.0f)){

            @Override
            public void drawSliderText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getDrawText(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(0.945f, 0.945f, 0.945f, 1.0f));
            }

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                IMGManager.getIMG(Images.btnMenu1H).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - CFG.PADD + iTranslateY, this.getWidthE() + CFG.PADD * 2);
                super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
            }

            @Override
            public String getDrawText() {
                return super.getTextE() + (this.getCurr() == 0 ? CFG.lang.get("NoThanks") : "" + (float)this.getCurr() / 100.0f);
            }

            @Override
            public void actionElem(int iID) {
                VictoryManager.VICTORY_TECHNOLOGY = (float)this.getCurr() / 100.0f;
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD * 2;
        this.initMenuWithBackButton(null, CFG.GAMEWIDTH - tempMenuWidth, 0, tempMenuWidth, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Back"));
        this.getMenuElem(1).setTextE(CFG.lang.get("VictoryConditions"));
        this.getMenuElem(3).setTextE(CFG.lang.get("ControlProvinces"));
        this.getMenuElem(4).setTextE(CFG.lang.get("TurnsLimit") + ": ");
        this.getMenuElem(5).setTextE(CFG.lang.get("TechnologyLevel") + ": ");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD * 3 + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.1f));
        IMGManager.getIMG(Images.patternReversed).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.patternReversed).getHeight(), CFG.GAMEWIDTH, CFG.GAMEHEIGHT, 0.0f, 0);
        oSB.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        IMGManager.getIMG(Images.gameLogo).drawO(oSB, CFG.PADD * 2 + iTranslateX, CFG.GAMEHEIGHT - CFG.PADD * 2 - IMGManager.getIMG(Images.gameLogo).getHeight() + iTranslateY);
        oSB.setColor(1.0f, 1.0f, 1.0f, 0.85f);
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, -IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2 + Core.PADDING, CFG.GAMEHEIGHT);
        oSB.setColor(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.275f);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, -IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), CFG.GAMEHEIGHT);
        oSB.setColor(Color.WHITE);
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (this.getMenuElem(2).getIsInView()) {
            CFG.map.getIcon(CFG.map.getActiveMapIDN()).drawO(oSB, this.getPosX() + this.getMenuElem(2).getTextPosElem() / 2 - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getWidth() / 2 + iTranslateX, this.getMenuElem(2).getPosY() + this.getMenuElem(2).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + this.getMenuPosY() - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setMenuID(CFG.backToMenu);
        CFG.menus.setBackAnimation(true);
    }
}

