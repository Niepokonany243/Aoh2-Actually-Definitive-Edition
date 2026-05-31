
package age.of.civilizations2.jakowski.lukasz.Menus.Population;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.View.Button_View_PopulationCiv;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_PopulationCiv
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    public static int civID;

    public Menu_InGame_View_PopulationCiv(int nCivID) {
        int tempW = CFG.CIV_INFO_MENU_WIDTH + CFG.BUTTON_W * 3 / 4;
        int tY = 0;
        civID = nCivID;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        long civPopulation = CFG.core.getCiv(civID).countPop();
        int taxesGraphW = Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 2, (int)((float)(tempW - CFG.PADD * 4) * 0.125f)) - CFG.PADD;
        menuElements.add(new ButtonN_Pop2(new Color((float)CFG.core.getCiv(civID).getR() / 255.0f, (float)CFG.core.getCiv(civID).getG() / 255.0f, (float)CFG.core.getCiv(civID).getB() / 255.0f, 1.0f), CFG.core.getCiv(civID).getCivName(), civID, "", CFG.getNumberWthSpaces("" + civPopulation), Images.pop, CFG.COLOR_POPULATION, 0, tY, tempW - taxesGraphW){

            @Override
            public void buildElemHover() {
                this.menuElemHover = CFG.core.getHover_PopulationOfCiv(this.iCivID);
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_POPULATION_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_POPULATION_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Population"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            }

            @Override
            public void actionElemPPM() {
                if (this.iCivID > 0) {
                    CFG.map.getMpC().centerToCapital_OrMetProvinceCivID(this.iCivID);
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
        menuElements.add(new Graph2("A", "B", tempW - taxesGraphW, tY, taxesGraphW, CFG.BUTTON_H - 2, true, 1, Graph2.GraphType.CIV_POPULATION, false, civID, true){

            @Override
            public void buildElemHover() {
                boolean metCiv = CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(this.id);
                this.menuElemHover = metCiv ? CFG.core.getHover_PopulationOfCiv(this.id) : CFG.core.getHover_PopulationOfCiv(-1);
            }

            @Override
            public int getGraphWidth() {
                return this.getWidthE() - this.getGraphButtonWidth();
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 2)).getHeightE();
        ArrayList<Integer> tempNat = new ArrayList<Integer>();
        ArrayList<Long> tempNum = new ArrayList<Long>();
        for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getPop().getNatsSize(); ++j) {
                boolean addNew = true;
                for (int k = 0; k < tempNat.size(); ++k) {
                    if (((Integer)tempNat.get(k)).intValue() != CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getPop().getCivID(j)) continue;
                    tempNum.set(k, tempNum.get(k) + CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getPop().getPopulationID(j));
                    addNew = false;
                    break;
                }
                if (!addNew) continue;
                tempNat.add(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getPop().getCivID(j));
                tempNum.add(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getPop().getPopulationID(j));
            }
        }
        ArrayList<Integer> tempSortedNat = new ArrayList<Integer>();
        ArrayList<Long> tempSortedNum = new ArrayList<Long>();
        while (!tempNat.isEmpty()) {
            int nMax = 0;
            for (int i = 1; i < tempNat.size(); ++i) {
                if (tempNum.get(nMax) >= tempNum.get(i)) continue;
                nMax = i;
            }
            tempSortedNat.add(tempNat.get(nMax));
            tempSortedNum.add(tempNum.get(nMax));
            tempNat.remove(nMax);
            tempNum.remove(nMax);
        }
        menuElements.add(new TextBuildTitle(CFG.lang.get("PopulationByOrigin") + ": " + tempSortedNat.size(), -1, 0, tY, tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        for (int i = 0; i < tempSortedNat.size(); ++i) {
            menuElements.add(new Button_View_PopulationCiv(i, i + 1 + ". " + (CFG.getMetCiv(tempSortedNat.get(i)) ? CFG.core.getCiv(tempSortedNat.get(i)).getCivName() : CFG.lang.get("Undiscovered")) + ": ", (int)tempSortedNum.get(i).longValue(), 0, tY, tempW, tempSortedNat.get(i), "" + (float)((long)((float)tempSortedNum.get(i).longValue() / (float)civPopulation * 10000.0f)) / 100.0f + "%"){

                @Override
                public void actionElem(int iID) {
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Population") + ": " + CFG.core.getCiv(civID).getCivName(), CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_PopulationCiv.this.getPosX() + iTranslateX, Menu_InGame_View_PopulationCiv.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_PopulationCiv.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color((float)CFG.core.getCiv(civID).getR() / 255.0f, (float)CFG.core.getCiv(civID).getG() / 255.0f, (float)CFG.core.getCiv(civID).getB() / 255.0f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color((float)CFG.core.getCiv(civID).getR() / 255.0f, (float)CFG.core.getCiv(civID).getG() / 255.0f, (float)CFG.core.getCiv(civID).getB() / 255.0f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_PopulationCiv.this.getPosX() + iTranslateX, Menu_InGame_View_PopulationCiv.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_PopulationCiv.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_PopulationCiv.this.getPosX() + iTranslateX, Menu_InGame_View_PopulationCiv.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_PopulationCiv.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_PopulationCiv.this.getPosX() + iTranslateX, Menu_InGame_View_PopulationCiv.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_PopulationCiv.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_PopulationCiv.this.getPosX() + iTranslateX, Menu_InGame_View_PopulationCiv.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_PopulationCiv.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_PopulationCiv.this.getPosX() + Menu_InGame_View_PopulationCiv.this.getWidthM() - Menu_InGame_View_PopulationCiv.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_PopulationCiv.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_PopulationCiv.this.getWidthM() / 4, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.pop).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, Menu_InGame_View_PopulationCiv.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.pop).getHeight() / 2);
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

