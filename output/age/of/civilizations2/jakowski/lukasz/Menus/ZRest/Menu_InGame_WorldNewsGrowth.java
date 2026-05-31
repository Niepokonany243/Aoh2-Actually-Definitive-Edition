
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop_2_PopChange;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_WorldNewsGrowth
extends Menu {
    public Menu_InGame_WorldNewsGrowth() {
        long tempTotalPop;
        boolean metCiv;
        int i;
        int bestID;
        int a;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = 0;
        int tempW = (int)((float)CFG.CIV_INFO_MENU_WIDTH * 2.75f);
        if (tempW > CFG.GAMEWIDTH) {
            tempW = CFG.GAMEWIDTH - CFG.PADD * 4;
        }
        int tElemHeight = CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4;
        int tElemHeight2 = CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 3;
        int halfW = (tempW - 4) / 2;
        int graphW = Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 2, (int)((float)(halfW - CFG.PADD * 4) * 0.125f)) - CFG.PADD;
        menuElements.add(new TextBuildTitle(CFG.lang.get("TopCivilizations"), -1, 2, tY, tempW / 2 - 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4));
        menuElements.add(new TextBuildTitle(CFG.lang.get("WorstCivilizations"), -1, tempW / 2, tY, tempW / 2 - 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4));
        int titleYPos = tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        for (int i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
            CFG.core.getCiv((int)i2).freeValue = CFG.core.getCiv(i2).countPop() - CFG.core.getCiv((int)i2).civGD.startingPopulation;
        }
        for (a = 0; a < GameValues.gvPopulationGrowth.GROWTH_AND_DECLINE_MENU_CIVS_LIMIT; ++a) {
            bestID = 0;
            for (i = 0; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv((int)bestID).freeValue >= CFG.core.getCiv((int)i).freeValue) continue;
                bestID = i;
            }
            if (CFG.core.getCiv((int)bestID).freeValue == 0L) break;
            metCiv = CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(bestID);
            tempTotalPop = CFG.core.getCiv(bestID).countPop();
            menuElements.add(new ButtonN_Pop_2_PopChange(new Color((float)CFG.core.getCiv(bestID).getR() / 255.0f, (float)CFG.core.getCiv(bestID).getG() / 255.0f, (float)CFG.core.getCiv(bestID).getB() / 255.0f, 1.0f), a + 1 + ". " + (metCiv ? CFG.core.getCiv(bestID).getCivName() : CFG.lang.get("Undiscovered")), metCiv ? bestID : -1, "" + (tempTotalPop - CFG.core.getCiv((int)bestID).civGD.startingPopulation > 0L ? "+" : "") + CFG.getPercentage2Old(tempTotalPop - CFG.core.getCiv((int)bestID).civGD.startingPopulation, CFG.core.getCiv((int)bestID).civGD.startingPopulation, 100) + "%", CFG.getNumberWthSpaces("" + tempTotalPop), Images.pop, CFG.COLOR_POPULATION, 2, tY, halfW - graphW, CFG.core.getCiv((int)bestID).freeValue){

                @Override
                public void buildElemHover() {
                    this.menuElemHover = CFG.core.getHover_PopulationOfCiv(this.iCivID);
                }

                @Override
                public void actionElem(int iID) {
                    if (this.iCivID > 0) {
                        int provinceID = CFG.map.getMpC().getCapital_OrMetProvinceCivID(this.iCivID);
                        CFG.core.setActiveProvID(provinceID);
                    }
                }

                @Override
                public void actionElemPPM() {
                    if (this.iCivID > 0) {
                        CFG.map.getMpC().centerToCapital_OrMetProvinceCivID(this.iCivID);
                    }
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(a % 2);
            menuElements.add(new Graph2("A", "B", 2 + halfW - graphW, tY, graphW, CFG.BUTTON_H, true, 1, Graph2.GraphType.CIV_POPULATION, false, bestID, true){

                @Override
                public int getGraphWidth() {
                    return this.getWidthE() - this.getGraphButtonWidth();
                }

                @Override
                public void buildElemHover() {
                    boolean metCiv = CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(this.id);
                    this.menuElemHover = metCiv ? CFG.core.getHover_PopulationOfCiv(this.id) : CFG.core.getHover_PopulationOfCiv(-1);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 2)).getHeightE();
            CFG.core.getCiv((int)bestID).freeValue = 0L;
        }
        tY = titleYPos;
        for (a = 0; a < GameValues.gvPopulationGrowth.GROWTH_AND_DECLINE_MENU_CIVS_LIMIT; ++a) {
            bestID = 0;
            for (i = 0; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv((int)bestID).freeValue <= CFG.core.getCiv((int)i).freeValue) continue;
                bestID = i;
            }
            if (CFG.core.getCiv((int)bestID).freeValue >= 0L) break;
            metCiv = CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(bestID);
            tempTotalPop = CFG.core.getCiv(bestID).countPop();
            menuElements.add(new ButtonN_Pop_2_PopChange(new Color((float)CFG.core.getCiv(bestID).getR() / 255.0f, (float)CFG.core.getCiv(bestID).getG() / 255.0f, (float)CFG.core.getCiv(bestID).getB() / 255.0f, 1.0f), a + 1 + ". " + (metCiv ? CFG.core.getCiv(bestID).getCivName() : CFG.lang.get("Undiscovered")), metCiv ? bestID : -1, "" + (tempTotalPop - CFG.core.getCiv((int)bestID).civGD.startingPopulation > 0L ? "+" : "") + CFG.getPercentage2Old(tempTotalPop - CFG.core.getCiv((int)bestID).civGD.startingPopulation, CFG.core.getCiv((int)bestID).civGD.startingPopulation, 100) + "%", CFG.getNumberWthSpaces("" + tempTotalPop), Images.pop, CFG.COLOR_POPULATION, halfW, tY, halfW - graphW - 2, CFG.core.getCiv((int)bestID).freeValue){

                @Override
                public void buildElemHover() {
                    this.menuElemHover = CFG.core.getHover_PopulationOfCiv(this.iCivID);
                }

                @Override
                public void actionElem(int iID) {
                    if (this.iCivID > 0) {
                        int provinceID = CFG.map.getMpC().getCapital_OrMetProvinceCivID(this.iCivID);
                        CFG.core.setActiveProvID(provinceID);
                    }
                }

                @Override
                public void actionElemPPM() {
                    if (this.iCivID > 0) {
                        CFG.map.getMpC().centerToCapital_OrMetProvinceCivID(this.iCivID);
                    }
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(a % 2);
            menuElements.add(new Graph2("A", "B", halfW + halfW - graphW - 2, tY, graphW, CFG.BUTTON_H, true, 1, Graph2.GraphType.CIV_POPULATION, false, bestID, true){

                @Override
                public int getGraphWidth() {
                    return this.getWidthE() - this.getGraphButtonWidth();
                }

                @Override
                public void buildElemHover() {
                    boolean metCiv = CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(this.id);
                    this.menuElemHover = metCiv ? CFG.core.getHover_PopulationOfCiv(this.id) : CFG.core.getHover_PopulationOfCiv(-1);
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 2)).getHeightE();
            CFG.core.getCiv((int)bestID).freeValue = 0L;
        }
        int tempMenuPosY = IMGManager.getIMG(Images.topFlagFrame).getHeight() + CFG.PADD * 4 + CFG.BUTTON_H * 3 / 4 + CFG.PADD * 2;
        this.initMenu(new TitleM_TextSmall(null, CFG.BUTTON_H * 3 / 4, true, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdge).getHeight(), nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.gameTopEdge).getHeight(), IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.11764706f, 0.30588236f, 0.6039216f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.11764706f, 0.30588236f, 0.6039216f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.news).draw(oSB, nPosX + (nWidth - this.getTextWidth()) / 2 - CFG.PADD - IMGManager.getIMG(Images.news).getWidth() + iTranslateX, 2 + nPosY - this.getHeightT() + this.getHeightT() / 2 - IMGManager.getIMG(Images.news).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - this.getTextWidth()) / 2 + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH / 2 - tempW / 2, tempMenuPosY, tempW, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, true, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        try {
            this.getTitleM().setText(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": " + CFG.lang.get("GrowthAndDecline"));
        }
        catch (NullPointerException nullPointerException) {
            
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2, this.getHeightM() + 2 + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + iTranslateX, this.getMenuPosY() - 1 + this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getMenuElem(0).getHeightE() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() + iTranslateX, this.getMenuPosY() + this.getMenuElem(0).getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getMenuElem(0).getHeightE() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    public final int getW() {
        return this.getWidthM() - CFG.PADD * 4;
    }

    public final int getElementW() {
        return this.getW() / 6;
    }
}

