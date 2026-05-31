
package age.of.civilizations2.jakowski.lukasz.Menus.Budget;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_FlagAction_GraphModes;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_Top;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Graph.Menu_InGame_GraphManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_FA_GraphMain_Modes
extends Menu {
    public Menu_InGame_FA_GraphMain_Modes() {
        int tempHeight = CFG.BUTTON_H * 3 / 4;
        int tempWidth = 0;
        tempWidth = CFG.isAndroid() && !CFG.LANDSCAPE ? CFG.GAMEWIDTH - CFG.PADD * 4 - 2 : (int)((float)Menu_InGame_FA_Top.getWindowWidth() - (float)Menu_InGame_FA_Top.getWindowWidth() * GameValues.gvInGame.FLAG_BUDGET_WIDTH - (float)(CFG.PADD * 2));
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_FlagAction_GraphModes(null, 0, 0, 0, CFG.BUTTON_W, --tempHeight, true));
        menuElements.add(new Button_FlagAction_GraphModes(null, 100, 0, 0, CFG.BUTTON_W, tempHeight, true));
        menuElements.add(new Button_FlagAction_GraphModes(null, 111, 0, 0, CFG.BUTTON_W, tempHeight, true));
        menuElements.add(new Button_FlagAction_GraphModes(null, 102, 0, 0, CFG.BUTTON_W, tempHeight, true));
        menuElements.add(new Button_FlagAction_GraphModes(null, 106, 0, 0, CFG.BUTTON_W, tempHeight, true));
        menuElements.add(new Button_FlagAction_GraphModes(null, 1, 0, 0, CFG.BUTTON_W, tempHeight, true));
        menuElements.add(new Button_FlagAction_GraphModes(null, 13, 0, 0, CFG.BUTTON_W, tempHeight, true));
        menuElements.add(new Button_FlagAction_GraphModes(null, 10, 0, 0, CFG.BUTTON_W, tempHeight, true));
        menuElements.add(new Button_FlagAction_GraphModes(null, 11, 0, 0, CFG.BUTTON_W, tempHeight, true));
        menuElements.add(new Button_Transparent(0, 0, tempWidth, tempHeight, true));
        this.initMenu(null, CFG.isAndroid() && !CFG.LANDSCAPE ? CFG.PADD * 2 + 2 : (int)((float)Menu_InGame_FA_Top.getWindowWidth() - (float)Menu_InGame_FA_Top.getWindowWidth() * (1.0f - GameValues.gvInGame.FLAG_BUDGET_WIDTH)) + AoCGame.LEFT, CFG.isAndroid() && !CFG.LANDSCAPE ? IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4 + (CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2) / 2 : IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4), tempWidth - 2, ++tempHeight, menuElements, false, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        int nID = 0;
        this.getMenuElem(nID++).setTextE(CFG.lang.get("Provinces"));
        this.getMenuElem(nID++).setTextE(CFG.lang.get("Income"));
        this.getMenuElem(nID++).setTextE(CFG.lang.get("Balance"));
        this.getMenuElem(nID++).setTextE(CFG.lang.get("MilitaryUpkeep"));
        this.getMenuElem(nID++).setTextE(CFG.lang.get("WorldsPopulation"));
        this.getMenuElem(nID++).setTextE(CFG.lang.get("Population"));
        this.getMenuElem(nID++).setTextE(CFG.lang.get("Economy"));
        this.getMenuElem(nID++).setTextE(CFG.lang.get("ConqueredProvinces"));
        this.getMenuElem(nID++).setTextE(CFG.lang.get("ConstructedBuildings"));
        this.updatedButtonsWidth_Padding(0, CFG.BUTTON_W * 3 / 4, 0);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2 + Core.PADDING, this.getHeightM(), true, true);
        oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.75f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM() / 3);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - this.getHeightM() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM() / 4, false, true);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM());
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM() - 1 + iTranslateY, this.getWidthM(), 1);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.375f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, this.getHeightM(), false, true);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + 1 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + this.getHeightM() - 1 + iTranslateY, this.getWidthM() * 3 / 4, 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_FlagAction();
    }

    @Override
    public void actionEL(int iID) {
        if (iID != this.getMenuElemsSize() - 1) {
            Menu_InGame_GraphManager.setActiveGraphID((int)this.getMenuElem(iID).getCurr());
        }
    }
}

