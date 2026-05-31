/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Outliner;

import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag_JustFrame;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_Top;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.TechManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_Army;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_BattleReports;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_CurrentWar;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_Economy;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_Happiness;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_Nukes;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_PartOfHRE;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_Population;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_ResearchProgress;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_SaveGame;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_Stability;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_Stats;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_TechLevel;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_WarPreparations;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_WarWeariness;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Outliner
extends Menu {
    public static final int ANIMATION_TIME = 135;
    public static long lTime = 0L;
    public static boolean hideAnimation = true;

    public Menu_InGame_Outliner(int init) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = CFG.PADD;
        menuElements.add(new Button_Flag_JustFrame(CFG.PADD, tY, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2;
        this.initMenu(new TitleM(CFG.lang.get("Wars"), CFG.BUTTON_H * 3 / 5, true, true), CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, false, true);
        this.updateLang();
    }

    public Menu_InGame_Outliner() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempMaxTextW = 1;
        try {
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), "+100% ");
            tempMaxTextW = (int)CFG.glyphLay.width;
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        int tMenuWidth = IMGManager.getIMG(Images.diploWar).getWidth() / 2 + CFG.PADD + CFG.CIV_FLAG_WIDTH + CFG.PADD + tempMaxTextW + CFG.PADD;
        int tPosY = 0;
        ArrayList<Integer> tempWars = new ArrayList<Integer>();
        int playerCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        for (int i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
            int tWarID;
            if (i2 == playerCivID || !CFG.core.getCivsAtWar(playerCivID, i2) || (tWarID = CFG.core.getWarID(playerCivID, i2)) < 0) continue;
            boolean added = false;
            for (int j = 0; j < tempWars.size(); ++j) {
                if ((Integer)tempWars.get(j) != tWarID) continue;
                added = true;
                break;
            }
            if (added) continue;
            tempWars.add(tWarID);
        }
        ArrayList<Integer> tempSorted = new ArrayList<Integer>();
        while (!tempWars.isEmpty()) {
            int tBest = 0;
            for (i = 1; i < tempWars.size(); ++i) {
                if (CFG.core.getWar((Integer)tempWars.get(i)).getCasualties_Aggressors() + CFG.core.getWar((Integer)tempWars.get(i)).getCasualties_Defenders() <= CFG.core.getWar((Integer)tempWars.get(tBest)).getCasualties_Aggressors() + CFG.core.getWar((Integer)tempWars.get(tBest)).getCasualties_Defenders()) continue;
                tBest = i;
            }
            tempSorted.add((Integer)tempWars.get(tBest));
            tempWars.remove(tBest);
        }
        if (GameValues.gvOutliner.SHOW_STATS && (CFG.getIsDesktop() || GameValues.gvOutliner.SHOW_STATS_MOBILE)) {
            menuElements.add(new TextOutliner_Stats(playerCivID, "" + CFG.lang.get("Stats"), 2, tPosY, tMenuWidth - 2){

                @Override
                public void actionElem(int iID) {
                    if (GameValues.gvInGame.USE_IN_GAME_OLD_STATS_MENU) {
                        Menu_InGame_FA_Top.clickStats();
                    } else {
                        CFG.menus.setVisibleInGame_Stats(!CFG.menus.getVisibleInGame_Stats());
                    }
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (SaveGameManager.gameWillBeSavedInNextTurn()) {
            menuElements.add(new TextOutliner_SaveGame(playerCivID, 2, tPosY, tMenuWidth - 2){});
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        boolean research = true;
        for (i = 0; i < CFG.core.getCiv((int)playerCivID).getCivDiploGD().messageBox.getMessagesSize(); ++i) {
            if (CFG.core.getCiv((int)playerCivID).getCivDiploGD().messageBox.getMessage((int)i).messageType != MessageType.TECHNOLOGY_RESEARCHED) continue;
            menuElements.add(new TextOutliner_TechLevel(playerCivID, "" + (float)((int)(CFG.core.getCiv(playerCivID).getTechLevel() * 100.0f)) / 100.0f, 2, tPosY, tMenuWidth - 2){});
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            break;
        }
        if (research) {
            menuElements.add(new TextOutliner_ResearchProgress(playerCivID, "" + CFG.getPercentage_Max100((int)CFG.core.getCiv(playerCivID).getResearchProgressT(), TechManager.getResearchNextLevel(playerCivID), 4) + "%", 2, tPosY, tMenuWidth - 2){});
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (CFG.ENABLE_NUKES && (GameValues.gvAtomic.SHOW_NUKES_OUTLINER_DESPITE_YEAR_REQUIREMENTS || !CFG.NUKES_MIN_YEAR_ENABLED || GameCalendar.currYear >= GameValues.gvAtomic.ATOMIC_BOMB_MIN_YEAR)) {
            menuElements.add(new TextOutliner_Nukes(playerCivID, "" + CFG.core.getCiv((int)playerCivID).civGD.iNukes + (!CFG.core.getCiv((int)playerCivID).civGD.nukesConstruction.isEmpty() ? "(" + CFG.core.getCiv((int)playerCivID).civGD.nukesConstruction.size() + ")" : ""), 2, tPosY, tMenuWidth - 2){

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_Build_Nuke();
                }
            });
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (GameValues.gvOutliner.SHOW_POPULATION && (CFG.getIsDesktop() || GameValues.gvOutliner.SHOW_POPULATION_MOBILE)) {
            menuElements.add(new TextOutliner_Population(playerCivID, "" + CFG.getNumber_SHORT(CFG.core.getCiv(playerCivID).countPop()), 2, tPosY, tMenuWidth - 2){});
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (GameValues.gvOutliner.SHOW_ECONOMY && (CFG.getIsDesktop() || GameValues.gvOutliner.SHOW_ECONOMY_MOBILE)) {
            menuElements.add(new TextOutliner_Economy(playerCivID, "" + CFG.getNumber_SHORT(CFG.core.getCiv(playerCivID).countEco()), 2, tPosY, tMenuWidth - 2){});
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (GameValues.gvOutliner.SHOW_STABILITY && (CFG.getIsDesktop() || GameValues.gvOutliner.SHOW_STABILITY_MOBILE)) {
            menuElements.add(new TextOutliner_Stability(playerCivID, "" + (int)(CFG.core.getCiv(playerCivID).getStabilityCiv() * 100.0f) + "%", 2, tPosY, tMenuWidth - 2){});
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (GameValues.gvOutliner.SHOW_HAPPINESS && (CFG.getIsDesktop() || GameValues.gvOutliner.SHOW_HAPPINESS_MOBILE)) {
            menuElements.add(new TextOutliner_Happiness(playerCivID, "" + CFG.core.getCiv(playerCivID).getHappiness() + "%", 2, tPosY, tMenuWidth - 2){});
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (GameValues.gvOutliner.SHOW_WAR_WEARINESS) {
            menuElements.add(new TextOutliner_WarWeariness(playerCivID, "" + (float)((int)(CFG.core.getCiv(playerCivID).getWarWeariness() * 10000.0f)) / 100.0f + "%", 2, tPosY, tMenuWidth - 2){});
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (GameValues.gvOutliner.SHOW_ARMY) {
            menuElements.add(new TextOutliner_Army(playerCivID, "" + CFG.getNumber_SHORT(CFG.core.getCiv(playerCivID).getNumberOfUnits()), 2, tPosY, tMenuWidth - 2){});
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (GameValues.gvOutliner.SHOW_BATTLE_REPORTS) {
            menuElements.add(new TextOutliner_BattleReports(playerCivID, "" + CFG.gameAction.battleReports.size(), 2, tPosY, tMenuWidth - 2){});
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        }
        if (research || tempSorted.size() > 0 || CFG.core.getCiv((int)playerCivID).civGD.civPlans.warPreps.size() > 0 || CFG.core.getCiv(playerCivID).getIsPartOfHolyRomanEmpire()) {
            for (i = 0; i < tempSorted.size(); ++i) {
                menuElements.add(new TextOutliner_CurrentWar((int)((Integer)tempSorted.get(i)), 2, tPosY, tMenuWidth - 2){});
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            for (i = 0; i < CFG.core.getCiv((int)playerCivID).civGD.civPlans.iWarPrepsSize; ++i) {
                menuElements.add(new TextOutliner_WarPreparations(CFG.core.getCiv((int)playerCivID).civGD.civPlans.warPreps.get((int)i).onCivID, CFG.core.getCiv((int)playerCivID).civGD.civPlans.warPreps.get((int)i).iNumOfTurnsLeft, 2, tPosY, tMenuWidth - 2){});
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            if (CFG.core.getCiv(playerCivID).getIsPartOfHolyRomanEmpire()) {
                menuElements.add(new TextOutliner_PartOfHRE(CFG.hreMgr.getHRE().getEmperor(), 2, tPosY, tMenuWidth - 2){});
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        } else {
            menuElements.add(new TextOutliner("NoWars", CFG.PADD * 2, 2, tPosY, tMenuWidth - 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){});
            tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setVisibleE(false);
        }
        int menuPosY = CFG.menus.getVisible_Menu_InGame_Outliner() ? CFG.menus.getMenu_InGame_Outliner().getPosY() + CFG.menus.getMenu_InGame_Outliner().getHeightM() : IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2;
        this.initMenu(null, CFG.GAMEWIDTH - tMenuWidth, menuPosY, tMenuWidth, Math.min(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 3 - menuPosY - (CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2) * 4, Math.min(Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.CIV_FLAG_HEIGHT + CFG.PADD * 4) * 50, menuElements.size() > 0 ? ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() : 0)) + 1, menuElements, false, false);
        for (int i3 = 0; i3 < this.getMenuElemsSize(); ++i3) {
            this.getMenuElem(i3).setCurr(i3 % 2);
        }
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + 135L >= System.currentTimeMillis()) {
            iTranslateX = hideAnimation ? (iTranslateX += (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / 135.0f))) : (iTranslateX += this.getWidthM() - (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / 135.0f)));
            CFG.setRenderO(true);
        } else if (hideAnimation) {
            super.setVisibleM(false);
            return;
        }
        super.draw(oSB, iTranslateX, 1 + iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX + CFG.PADD, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void drawCloseButton(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.getCloseButtonImage(sliderMenuIsActive).drawO(oSB, this.getPosX() + this.getWidthM() - IMGManager.getIMG(Images.btnClose).getWidth() * 3 / 5 + iTranslateX, this.getPosY() - this.getTitleM().getHeightT() - IMGManager.getIMG(Images.btnClose).getHeight() + iTranslateY, IMGManager.getIMG(Images.btnClose).getWidth() * 3 / 5, IMGManager.getIMG(Images.btnClose).getHeight() * 3 / 5);
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

    public final void setHideAnimation(boolean hideAnimation) {
        if (hideAnimation != Menu_InGame_Outliner.hideAnimation) {
            lTime = lTime > System.currentTimeMillis() - 135L ? System.currentTimeMillis() - (135L - (System.currentTimeMillis() - lTime)) : System.currentTimeMillis();
            CFG.setRenderO(true);
        }
        Menu_InGame_Outliner.hideAnimation = hideAnimation;
    }
}

