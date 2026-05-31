
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.View.Button_View_Terrain;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_Terrain
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    private int iCivID = 0;

    public Menu_InGame_View_Terrain() {
        int i;
        int tempW = (int)((float)CFG.CIV_INFO_MENU_WIDTH * 1.25f);
        int tY = 0;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.iCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(CFG.core.getActiveProvID());
        ArrayList<Integer> tempNum = new ArrayList<Integer>();
        ArrayList<Integer> tempIDs = new ArrayList<Integer>();
        ArrayList<Integer> tempSorted = new ArrayList<Integer>();
        for (i = 0; i < CFG.terrainTypesManager.getTerrainsSize(); ++i) {
            tempNum.add(0);
            tempIDs.add(i);
        }
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(i)) continue;
            tempNum.set(CFG.core.getProv(i).getTerrainTypeID(), (Integer)tempNum.get(CFG.core.getProv(i).getTerrainTypeID()) + 1);
        }
        while (tempIDs.size() > 0) {
            int tBest = 0;
            for (int i2 = 0; i2 < tempIDs.size(); ++i2) {
                if ((Integer)tempNum.get((Integer)tempIDs.get(i2)) <= (Integer)tempNum.get((Integer)tempIDs.get(tBest))) continue;
                tBest = i2;
            }
            tempSorted.add((Integer)tempIDs.get(tBest));
            tempIDs.remove(tBest);
        }
        for (i = 0; i < tempSorted.size(); ++i) {
            if ((Integer)tempNum.get((Integer)tempSorted.get(i)) != 0) continue;
            tempSorted.remove(i--);
        }
        if (tempSorted.size() > 0) {
            for (i = 0; i < tempSorted.size(); ++i) {
                menuElements.add(new Button_View_Terrain(i, (Integer)tempSorted.get(i), (Integer)tempNum.get((Integer)tempSorted.get(i)), 0, tY, tempW){});
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        } else {
            menuElements.add(new TextScale(CFG.lang.get("NoData"), -1, 0, tY, tempW, CFG.BUTTON_H * 3 / 4, 0.75f));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Terrain"), CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_Terrain.this.getPosX() + iTranslateX, Menu_InGame_View_Terrain.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_Terrain.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.29411766f, 0.54901963f, 0.47058824f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.29411766f, 0.54901963f, 0.47058824f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_Terrain.this.getPosX() + iTranslateX, Menu_InGame_View_Terrain.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_Terrain.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Terrain.this.getPosX() + iTranslateX, Menu_InGame_View_Terrain.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_Terrain.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Terrain.this.getPosX() + iTranslateX, Menu_InGame_View_Terrain.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_Terrain.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Terrain.this.getPosX() + iTranslateX, Menu_InGame_View_Terrain.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Terrain.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Terrain.this.getPosX() + Menu_InGame_View_Terrain.this.getWidthM() - Menu_InGame_View_Terrain.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_Terrain.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Terrain.this.getWidthM() / 4, 1, true, false);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 5, tempW, Math.min(tY + 1, CFG.isAndroid() && !CFG.LANDSCAPE ? (CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (CFG.PADD * 2 + CFG.BUTTON_H) * 2)) / 2 : CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (GameValues.gvInGame.MAP_MODES_MENUS_TO_PROVINCE_INFO ? (CFG.PADD * 2 + CFG.BUTTON_H) * 2 : 0))), menuElements, false, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            iTranslateX = hideAnimation ? (iTranslateX -= (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))) : (iTranslateX += -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME)));
            CFG.setRenderO(true);
        } else if (hideAnimation) {
            super.setVisibleM(false);
            return;
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2 + Core.PADDING, this.getHeightM() + CFG.PADD, true, true);
        oSB.setColor(new Color(0.09803922f, 0.05882353f, 0.37254903f, 0.25f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.PADD * 4);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.PADD * 2);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM() + CFG.PADD, this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight() + this.getHeightM() + CFG.PADD, this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() + CFG.PADD, this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible) {
            super.setVisibleM(visible);
            this.setHideAnimation(false);
        } else {
            this.setHideAnimation(true);
        }
    }

    public final void setHideAnimation(boolean nHideAnimation) {
        if (nHideAnimation != hideAnimation) {
            lTime = lTime > System.currentTimeMillis() - (long)GameValues.gvInGame.MENUS_ANIMATION_TIME ? System.currentTimeMillis() - ((long)GameValues.gvInGame.MENUS_ANIMATION_TIME - (System.currentTimeMillis() - lTime)) : System.currentTimeMillis();
            CFG.setRenderO(true);
        }
        hideAnimation = nHideAnimation;
    }
}

