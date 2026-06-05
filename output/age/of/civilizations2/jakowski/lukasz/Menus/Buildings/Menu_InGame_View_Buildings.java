
package age.of.civilizations2.jakowski.lukasz.Menus.Buildings;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Wonder;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.View.Button_View_Buildings;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_Buildings
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    private int iCivID = 0;

    public static int countBuildings(int civID) {
        int out = 0;
        for (int i = 0; i < CFG.core.getCiv(civID).getNumOfProvs(); ++i) {
            out += Menu_InGame_View_Buildings.countNumOfBuildings(CFG.core.getCiv(civID).getProvID(i));
        }
        return out;
    }

    public static int countNumOfBuildings(int nProvinceID) {
        int out = 0;
        out += CFG.core.getProv(nProvinceID).getLvlOfArmoury();
        out += CFG.core.getProv(nProvinceID).getLvlOfFarm();
        out += CFG.core.getProv(nProvinceID).getLvlOfFort();
        out += CFG.core.getProv(nProvinceID).getLvlOfLibrary();
        out += Math.max(CFG.core.getProv(nProvinceID).getLvlOfPort(), 0);
        out += CFG.core.getProv(nProvinceID).getLvlOfWatchTower();
        out += CFG.core.getProv(nProvinceID).getLvlOfSupply();
        out += CFG.core.getProv(nProvinceID).provGD.iAirDefense;
        return out += CFG.core.getProv(nProvinceID).getLvlOfMarket();
    }

    public Menu_InGame_View_Buildings() {
        int i;
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tY = 0;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.iCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(CFG.core.getActiveProvID());
        ArrayList<Integer> tempProvincesSorted = new ArrayList<Integer>();
        ArrayList<Integer> tempProvs = new ArrayList<Integer>();
        ArrayList<Integer> tempProvincesWithWonders = new ArrayList<Integer>();
        int totalPopulation = 0;
        for (i = 0; i < CFG.core.getCiv(this.iCivID).getNumOfProvs(); ++i) {
            if (CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(this.iCivID).getProvID(i))) continue;
            if (Menu_InGame_View_Buildings.countNumOfBuildings(CFG.core.getCiv(this.iCivID).getProvID(i)) > 0) {
                tempProvs.add(CFG.core.getCiv(this.iCivID).getProvID(i));
                totalPopulation += Menu_InGame_View_Buildings.countNumOfBuildings(CFG.core.getCiv(this.iCivID).getProvID(i));
            }
            if (CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i)).getWonderSize() <= 0) continue;
            tempProvincesWithWonders.add(CFG.core.getCiv(this.iCivID).getProvID(i));
            ++totalPopulation;
        }
        menuElements.add(new Button_DiplomacyAction(Images.buildAll, CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": " + CFG.lang.get("TopCivilizations"), 0, 0, tY, tempW, Menu_InGame_Civ_Decisions.getButtonH(), true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setVisible_InGame_View_BuildingsAll(true);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TopCivilizations"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.buildAll, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
        menuElements.add(new Button_DiplomacyAction(Images.buildAll, CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": " + CFG.lang.get("Buildings"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, Menu_InGame_Civ_Decisions.getButtonH(), true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setVisible_InGame_View_BuildingsTop(true);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Buildings"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.buildAll, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        menuElements.add(new TextBuildTitle(CFG.lang.get("Civilization"), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        java.util.Collections.sort(tempProvs, new java.util.Comparator<Integer>(){

            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(Menu_InGame_View_Buildings.countNumOfBuildings(b), Menu_InGame_View_Buildings.countNumOfBuildings(a));
            }
        });
        tempProvincesSorted.addAll(tempProvs);
        if (!tempProvincesSorted.isEmpty() || !tempProvincesWithWonders.isEmpty()) {
            menuElements.add(new ButtonN_Pop(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 1.0f), CFG.core.getCiv(this.iCivID).getCivName(), this.iCivID, CFG.lang.get("Buildings") + ": ", CFG.getNumberWthSpaces("" + totalPopulation), Images.buildAll, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tY, tempW){

                @Override
                public void actionElem(int iID) {
                    CFG.menus.setVisible_InGame_View_BuildingsAll(true);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            for (i = 0; i < tempProvincesWithWonders.size(); ++i) {
                for (int o = 0; o < CFG.core.getProv((Integer)tempProvincesWithWonders.get(i)).getWonderSize(); ++o) {
                    menuElements.add(new ButtonN_Wonder(new Color(0.09411765f, 0.3137255f, 0.43137255f, 1.0f), (Integer)tempProvincesWithWonders.get(i), o, 0, tY, tempW){

                        @Override
                        public void actionElem(int iID) {
                            CFG.core.setActiveProvID(this.getCurr());
                            CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                            if (CFG.core.getProv(CFG.core.getActiveProvID()).getName().length() > 0) {
                                CFG.toastM.addM(CFG.core.getProv(CFG.core.getActiveProvID()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            }
                        }
                    });
                    tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
            for (i = 0; i < tempProvincesSorted.size(); ++i) {
                menuElements.add(new Button_View_Buildings(i, (CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getName().length() > 0 ? CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getName() : CFG.core.getCiv(this.iCivID).getCivName()) + ": ", (Integer)tempProvincesSorted.get(i), Menu_InGame_View_Buildings.countNumOfBuildings((Integer)tempProvincesSorted.get(i)), 0, tY, CFG.CIV_INFO_MENU_WIDTH, false){

                    @Override
                    public void actionElem(int iID) {
                        CFG.core.setActiveProvID(this.getCurr());
                        CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                        if (CFG.core.getProv(CFG.core.getActiveProvID()).getName().length() > 0) {
                            CFG.toastM.addM(CFG.core.getProv(CFG.core.getActiveProvID()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                        }
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        } else {
            menuElements.add(new TextScale(CFG.lang.get("NoData"), -1, 0, tY, tempW, CFG.BUTTON_H * 3 / 4, 0.75f));
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Buildings"), CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_Buildings.this.getPosX() + iTranslateX, Menu_InGame_View_Buildings.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_Buildings.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color((float)CFG.core.getCiv(Menu_InGame_View_Buildings.this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_View_Buildings.this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_View_Buildings.this.iCivID).getB() / 255.0f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color((float)CFG.core.getCiv(Menu_InGame_View_Buildings.this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_View_Buildings.this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(Menu_InGame_View_Buildings.this.iCivID).getB() / 255.0f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_Buildings.this.getPosX() + iTranslateX, Menu_InGame_View_Buildings.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_Buildings.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Buildings.this.getPosX() + iTranslateX, Menu_InGame_View_Buildings.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_Buildings.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Buildings.this.getPosX() + iTranslateX, Menu_InGame_View_Buildings.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_Buildings.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Buildings.this.getPosX() + iTranslateX, Menu_InGame_View_Buildings.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Buildings.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Buildings.this.getPosX() + Menu_InGame_View_Buildings.this.getWidthM() - Menu_InGame_View_Buildings.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_Buildings.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Buildings.this.getWidthM() / 4, 1, true, false);
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

