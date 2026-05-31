/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Colonization;

import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_BuildAll;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_MM
extends Menu {
    public static View goBack = View.eMAINMENU;
    public static int questionID = 0;
    public static int[] money = new int[]{100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000};
    public static int questionCivID = 0;
    public static List<Integer> answers = new ArrayList<Integer>();
    public static int answerChosen = -1;
    public static long answerClickTime = 0L;
    public static boolean isAnimating = false;
    public static boolean textUpdated = false;
    public static boolean gameWon = false;

    public static void nextQuestion() {
        try {
            isAnimating = false;
            textUpdated = false;
            answerChosen = -1;
            answers.clear();
            Menu_MM.getCivByPercentile();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static void getCivByPercentile() {
        ArrayList<CivData> civs = Menu_MM.getSortedCivs();
        try {
            int total = civs.size();
            double percent = questionID <= 2 ? 0.05 : (questionID <= 4 ? 0.1 : (questionID <= 6 ? 0.2 : (questionID <= 8 ? 0.3 : (questionID <= 11 ? 0.5 : 0.1))));
            int rangeSize = Math.max(1, (int)((double)total * percent));
            int startIndex = questionID <= 11 ? 0 : total - rangeSize;
            int index = startIndex + CFG.oR.nextInt(rangeSize);
            answers.add(civs.get((int)index).civID);
            civs.remove(index);
            for (int i = 0; i < 3 && !civs.isEmpty(); ++i) {
                index = CFG.oR.nextInt(civs.size());
                answers.add(civs.get((int)index).civID);
                civs.remove(index);
            }
            questionCivID = answers.get(0);
            Menu_MM.shuffleV();
            return;
        }
        catch (Exception total) {
            int index = CFG.oR.nextInt(civs.size());
            answers.add(civs.get((int)index).civID);
            civs.remove(index);
            for (int i = 0; i < 3 && !civs.isEmpty(); ++i) {
                index = CFG.oR.nextInt(civs.size());
                answers.add(civs.get((int)index).civID);
                civs.remove(index);
            }
            questionCivID = answers.get(0);
            return;
        }
    }

    public static void shuffleV() {
        ArrayList<Integer> tList = new ArrayList<Integer>();
        for (int i = 0; i < answers.size(); ++i) {
            tList.add(answers.get(i));
        }
        answers.clear();
        while (!tList.isEmpty()) {
            int rand = CFG.oR.nextInt(tList.size());
            answers.add((Integer)tList.get(rand));
            tList.remove(rand);
        }
    }

    public static ArrayList<CivData> getSortedCivs() {
        ArrayList<CivData> list = new ArrayList<CivData>();
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)i).getIdeology()).REVOLUTIONARY) continue;
            int provs = CFG.core.getCiv(i).getNumOfProvs();
            list.add(new CivData(i, provs));
        }
        list.sort((a, b) -> Integer.compare(b.provinces, a.provinces));
        return list;
    }

    public Menu_MM() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        Menu_MM.nextQuestion();
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tY = CFG.PADD;
        int tempElemH = Menu_InGame_Civ_Decisions.getButtonH();
        menuElements.add(new Button_InGameBox(CFG.lang.get("Back"), -1, CFG.PADD, tY, tempW - CFG.PADD * 2, true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setMenuIDWithoutAnim(goBack);
            }
        });
        menuElements.add(new TextBuildTitle(CFG.lang.get("Progress"), -1, 2, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempW - 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        for (int i = 0; i < money.length; ++i) {
            menuElements.add(new Button_BuildAll(i + 1 + ". " + CFG.getNumberWthSpaces("" + money[i]), Images.topGold(), 0, tY, tempW){
                int id;
                {
                    this.id = 0;
                }

                @Override
                public Color getColorE(boolean isActive) {
                    if (this.id == questionID) {
                        return CFG.COLOR_HOVER_TITLE;
                    }
                    return super.getColorE(isActive);
                }

                @Override
                public void setMax(int iMax) {
                    this.id = iMax;
                    super.setMax(iMax);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(tempElemH);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i % 2);
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setMax(i);
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        this.initMenu(new TitleM_TextSmall("Money Tree", CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - Core.PADDING + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight(), nWidth + Core.PADDING * 2 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + Core.PADDING + nWidth - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - Core.PADDING - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.0f, 1.0f, 1.0f, 0.075f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth - 4, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.0f, 1.0f, 1.0f, 0.175f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth - 4, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - 4, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + 2 + (nWidth - 4) - (nWidth - 4) / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (nWidth - 4) / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, CFG.GAMEWIDTH - tempW - CFG.PADD - Core.PADDING, IMGManager.getIMG(Images.topBar2).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempW, Math.min(CFG.GAMEHEIGHT - CFG.BUTTON_H, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD), menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING * 2 - IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + 2 + Core.PADDING, true, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    static class CivData {
        int civID;
        int provinces;

        CivData(int civID, int provinces) {
            this.civID = civID;
            this.provinces = provinces;
        }
    }
}

