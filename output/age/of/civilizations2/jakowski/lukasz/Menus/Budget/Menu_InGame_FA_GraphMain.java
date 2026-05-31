
package age.of.civilizations2.jakowski.lukasz.Menus.Budget;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Data;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Vertical_Data_Type;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_Top;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_FA_GraphMain
extends Menu {
    public static final int ANIMATION_TIME = 225;
    public static long lTime = 0L;

    public Menu_InGame_FA_GraphMain() {
        int tempHeight = 0;
        int tempWidth = 0;
        if (CFG.isAndroid() && !CFG.LANDSCAPE) {
            tempHeight = CFG.GAMEHEIGHT - (CFG.BUTTON_H * 3 / 4 + IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4 + (CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2) / 2) - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2;
            tempHeight *= 2;
            tempWidth = CFG.GAMEWIDTH - CFG.PADD * 4;
        } else if (CFG.isAndroid() && CFG.LANDSCAPE || CFG.isIOS() || AoCGame.LEFT != 0) {
            tempHeight = CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - CFG.PADD * 2 - CFG.BUTTON_H * 3 / 4;
            tempWidth = (int)((float)Menu_InGame_FA_Top.getWindowWidth() - (float)Menu_InGame_FA_Top.getWindowWidth() * GameValues.gvInGame.FLAG_BUDGET_WIDTH - (float)(CFG.PADD * 2));
        } else {
            tempHeight = CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2 - CFG.BUTTON_H * 3 / 4;
            tempWidth = (int)((float)CFG.GAMEWIDTH - (float)CFG.GAMEWIDTH * GameValues.gvInGame.FLAG_BUDGET_WIDTH - (float)(CFG.PADD * 2));
        }
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        ArrayList<Graph_Vertical_Data> tempData = new ArrayList<Graph_Vertical_Data>();
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.FOG_OF_WAR >= 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i)) continue;
            tempData.add(new Graph_Vertical_Data(i));
        }
        menuElements.add(new Graph_Vertical(Graph_Vertical_Data_Type.NUM_OF_PROVINCES_BY_CONTINENT, CFG.lang.get("Civilizations"), CFG.lang.get("Provinces"), CFG.PADD * 2, CFG.PADD * 2, tempWidth - CFG.PADD * 4, tempHeight / 2 - CFG.PADD * 4, true, tempData));
        menuElements.add(new Button_Transparent(0, 0, tempWidth, tempHeight / 2, true));
        this.initMenu(null, CFG.isAndroid() && !CFG.LANDSCAPE ? CFG.PADD * 2 : (int)((float)Menu_InGame_FA_Top.getWindowWidth() - (float)Menu_InGame_FA_Top.getWindowWidth() * (1.0f - GameValues.gvInGame.FLAG_BUDGET_WIDTH)) + AoCGame.LEFT, CFG.isAndroid() && !CFG.LANDSCAPE ? CFG.BUTTON_H * 3 / 4 + IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4 + (CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4) - CFG.map.getMpB().getMinimapHeight() - CFG.PADD * 2) / 2 : IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4 + CFG.BUTTON_H * 3 / 4, tempWidth, tempHeight / 2, menuElements, false, false);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        if (CFG.isAndroid() && !CFG.LANDSCAPE) {
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM(), false, true);
            IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM(), true, true);
        } else {
            IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING, this.getHeightM(), true, true);
            oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.25f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM());
            oSB.setColor(new Color(0.025f, 0.025f, 0.025f, 0.75f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 2, CFG.BUTTON_H / 4);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.BUTTON_H / 4, this.getHeightM() - 2);
            oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM());
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 2, 1);
            oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.375f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, this.getHeightM());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.4f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM() - 2, 1);
            oSB.setColor(Color.WHITE);
        }
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_FlagAction();
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            default: 
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        super.setVisibleM(visible);
        lTime = System.currentTimeMillis();
    }
}

