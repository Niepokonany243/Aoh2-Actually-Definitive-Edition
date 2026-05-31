
package age.of.civilizations2.jakowski.lukasz.Menus.Achievements;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.StatsCivGD;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextAchievementCiv;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLogo;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextServiceRibbon;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;

public class Menu_Achievements_Options
extends Menu {
    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    public Menu_Achievements_Options() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tY = CFG.PADD;
        int tempMenuWidth = CFG.GAMEWIDTH - CFG.PADD * 4;
        menuElements.add(new TextLogo("", 0, 0, tY, tempMenuWidth, IMGManager.getIMG(Images.gameLogo).getHeight() + CFG.PADD * 4));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        try {
            int i;
            FileHandle file = FileManager.loadFile("saves/stats/civ/Age_of_Civilizations");
            String tempTags = file.readString();
            String[] tData = tempTags.split(";");
            ArrayList<Integer> sortedIDs = new ArrayList<Integer>();
            ArrayList<Integer> sortedStatsDataIDs = new ArrayList<Integer>();
            ArrayList<Long> sortedStatsData = new ArrayList<Long>();
            for (i = 0; i < tData.length; ++i) {
                try {
                    StatsCivGD tempData = (StatsCivGD)CFG.deserialize(FileManager.loadFile("saves/stats/civ/" + tData[i]).readBytes());
                    sortedStatsData.add(tempData.getTurns());
                    sortedStatsDataIDs.add(i);
                    continue;
                }
                catch (Exception tempData) {
                    
                }
            }
            while (!sortedStatsDataIDs.isEmpty()) {
                int tBest = 0;
                for (int i2 = tBest + 1; i2 < sortedStatsDataIDs.size(); ++i2) {
                    if ((Long)sortedStatsData.get(tBest) >= (Long)sortedStatsData.get(i2)) continue;
                    tBest = i2;
                }
                sortedIDs.add((Integer)sortedStatsDataIDs.get(tBest));
                sortedStatsData.remove(tBest);
                sortedStatsDataIDs.remove(tBest);
            }
            for (i = 0; i < sortedIDs.size(); ++i) {
                try {
                    int tempLevel;
                    int j;
                    StatsCivGD tempData = (StatsCivGD)CFG.deserialize(FileManager.loadFile("saves/stats/civ/" + tData[(Integer)sortedIDs.get(i)]).readBytes());
                    if (CFG.serviceRibbonMgr.getRequestProvinces_Level((long)tempData.getConqueredProvs()) - 1 < 0 && CFG.serviceRibbonMgr.getRequestTurns_Level((long)tempData.getTurns()) - 1 < 0 && CFG.serviceRibbonMgr.getRequestRecruitedArmy_Level((long)tempData.getRecruitedArmy()) - 1 < 0) continue;
                    menuElements.add(new TextAchievementCiv(tempData.sTag, 0, tY, tempMenuWidth, tempData.sTag, tempData.getGamesWon() > 0));
                    tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
                    for (j = tempLevel = CFG.serviceRibbonMgr.getRequestProvinces_Level((long)tempData.getConqueredProvs()) - 1; j >= 0; --j) {
                        menuElements.add(new TextServiceRibbon(CFG.lang.get("ConqueredProvinces") + ": ", 0, tY, tempMenuWidth, tempData.sTag, j, (int)(j == tempLevel ? tempData.getConqueredProvs() : CFG.serviceRibbonMgr.getRequestProvinces(j)), 0));
                        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
                    }
                    for (j = tempLevel = CFG.serviceRibbonMgr.getRequestRecruitedArmy_Level((long)tempData.getRecruitedArmy()) - 1; j >= 0; --j) {
                        menuElements.add(new TextServiceRibbon(CFG.lang.get("RecruitedArmy") + ": ", 0, tY, tempMenuWidth, tempData.sTag, j, (int)(j == tempLevel ? tempData.getRecruitedArmy() : CFG.serviceRibbonMgr.getRequestRecruitedArmy(j)), 1));
                        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
                    }
                    for (j = tempLevel = CFG.serviceRibbonMgr.getRequestTurns_Level((long)tempData.getTurns()) - 1; j >= 0; --j) {
                        menuElements.add(new TextServiceRibbon(CFG.lang.get("Turns") + ": ", 0, tY, tempMenuWidth, tempData.sTag, j, (int)(j == tempLevel ? tempData.getTurns() : CFG.serviceRibbonMgr.getRequestTurns(j)), 2));
                        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
                    }
                    continue;
                }
                catch (Exception exception) {
                    
                }
            }
        }
        catch (GdxRuntimeException ex) {
            menuElements.add(new TextScale(CFG.lang.get("-----"), -1, 0, tY, tempMenuWidth, CFG.BUTTON_H, 0.75f));
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setClickable(false);
        }
        this.initMenu(null, CFG.PADD * 2, CFG.BUTTON_H * 3 / 4 + CFG.PADD * 2, tempMenuWidth, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD * 4, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("MapType"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        CFG.drawRect_NewGameBoxEDGE(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() - 2 + iTranslateY, this.getWidthM() + 4, this.getHeightM() + 4);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.075f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthM(), this.getHeightM());
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public final void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }
}

