/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_Religion;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_Religions
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;

    public Menu_InGame_View_Religions() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH + CFG.BUTTON_W * 3 / 4;
        int tY = 0;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        ArrayList<Integer> tempReligions = new ArrayList<Integer>();
        ArrayList<Integer> tempReligionsIDs = new ArrayList<Integer>();
        ArrayList<Long> tempReligionPopulation = new ArrayList<Long>();
        ArrayList<Integer> tempBestCivID = new ArrayList<Integer>();
        ArrayList<Long> tempBestPopulation = new ArrayList<Long>();
        ArrayList<Integer> tSorted = new ArrayList<Integer>();
        try {
            int i;
            for (i = 0; i < CFG.religionManager.getReligionsSize(); ++i) {
                tempReligions.add(0);
                tempReligionsIDs.add(i);
                tempBestCivID.add(0);
                tempBestPopulation.add(0L);
                tempReligionPopulation.add(0L);
            }
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
                tempReligions.set(CFG.core.getCiv(i).getReligionID(), (Integer)tempReligions.get(CFG.core.getCiv(i).getReligionID()) + 1);
                long tPop = CFG.core.getCiv(i).countPop();
                tempReligionPopulation.set(CFG.core.getCiv(i).getReligionID(), (Long)tempReligionPopulation.get(CFG.core.getCiv(i).getReligionID()) + tPop);
                if (tPop <= (Long)tempBestPopulation.get(CFG.core.getCiv(i).getReligionID())) continue;
                tempBestCivID.set(CFG.core.getCiv(i).getReligionID(), i);
                tempBestPopulation.set(CFG.core.getCiv(i).getReligionID(), tPop);
            }
            while (!tempReligionsIDs.isEmpty()) {
                int tBest = 0;
                for (int i2 = 1; i2 < tempReligionsIDs.size(); ++i2) {
                    if ((Long)tempReligionPopulation.get((Integer)tempReligionsIDs.get(i2)) <= (Long)tempReligionPopulation.get((Integer)tempReligionsIDs.get(tBest))) continue;
                    tBest = i2;
                }
                tSorted.add((Integer)tempReligionsIDs.get(tBest));
                tempReligionsIDs.remove(tBest);
            }
            for (i = tSorted.size() - 1; i >= 0; --i) {
                if ((Integer)tempReligions.get((Integer)tSorted.get(i)) != 0) continue;
                tSorted.remove(i);
            }
            if (!tSorted.isEmpty()) {
                int taxesGraphW = Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 4, (int)((float)(tempW - CFG.PADD * 4) * 0.125f)) - CFG.PADD;
                for (int i3 = 0; i3 < tSorted.size(); ++i3) {
                    menuElements.add(new ButtonN_Religion(CFG.religionManager.getReligion((Integer)tSorted.get(i3)).getColor(), i3 + 1 + ". " + CFG.religionManager.getReligion((Integer)tSorted.get(i3)).getName(), (Integer)tSorted.get(i3), CFG.lang.get("Civilizations") + ": ", CFG.getNumberWthSpaces("" + tempReligions.get((Integer)tSorted.get(i3))), Images.provinces, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tY, tempW - taxesGraphW, (Integer)tempBestCivID.get((Integer)tSorted.get(i3)), CFG.getNumber_SHORT((Long)tempReligionPopulation.get((Integer)tSorted.get(i3)))){

                        @Override
                        public void actionElem(int iID) {
                            CFG.menus.setVisible_InGame_ViewReligionsSelected(true, this.religionID);
                        }
                    });
                    ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i3 % 2);
                    menuElements.add(new Graph2("A", "B", tempW - taxesGraphW, tY, taxesGraphW, CFG.BUTTON_H - 2, true, 1, Graph2.GraphType.RELIGION_POPULATION, false, (Integer)tSorted.get(i3), true){

                        @Override
                        public void buildElemHover() {
                            this.menuElemHover = null;
                        }

                        @Override
                        public int getGraphWidth() {
                            return this.getWidthE() - 2 * Graph2.getGraphButtonWidth();
                        }
                    });
                    tY += ((MenuElemUI)menuElements.get(menuElements.size() - 2)).getHeightE();
                }
            } else {
                menuElements.add(new TextScale(CFG.lang.get("NoData"), -1, 0, tY, tempW, CFG.BUTTON_H * 3 / 4, 0.75f));
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
        }
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Religion"), CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_Religions.this.getPosX() + iTranslateX, Menu_InGame_View_Religions.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_Religions.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.28235295f, 0.5294118f, 0.37254903f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.28235295f, 0.5294118f, 0.37254903f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_Religions.this.getPosX() + iTranslateX, Menu_InGame_View_Religions.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_Religions.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Religions.this.getPosX() + iTranslateX, Menu_InGame_View_Religions.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_Religions.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Religions.this.getPosX() + iTranslateX, Menu_InGame_View_Religions.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_Religions.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Religions.this.getPosX() + iTranslateX, Menu_InGame_View_Religions.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Religions.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Religions.this.getPosX() + Menu_InGame_View_Religions.this.getWidthM() - Menu_InGame_View_Religions.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_Religions.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Religions.this.getWidthM() / 4, 1, true, false);
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

