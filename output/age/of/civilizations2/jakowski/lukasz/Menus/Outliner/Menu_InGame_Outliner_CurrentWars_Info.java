/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Outliner;

import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag_JustFrame;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_Types;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_Alliance;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_AllianceLeaves;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_Annexation;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_Disease;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_FriendlyCivs;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_Guarantee;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_HaveMilitaryAccess;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_IsNotVassal;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_IsVassal;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_NewColony;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_SignedDefensivePact;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_SignedNonAggressionPact;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_Truce;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_Union;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextOutliner_DiploInfo_War;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Outliner_CurrentWars_Info
extends Menu {
    public final float FONT_SCALE = 0.7f;
    public static final int ANIMATION_TIME = 135;
    public static long lTime = 0L;
    public static boolean hideAnimation = true;

    public Menu_InGame_Outliner_CurrentWars_Info(int init) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = CFG.PADD;
        menuElements.add(new Button_Flag_JustFrame(CFG.PADD, tY, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2;
        this.initMenu(new TitleM(CFG.lang.get("Wars"), CFG.BUTTON_H * 3 / 5, true, true), CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.BUTTON_H - CFG.PADD * 2 - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * (CFG.getIsDesktop() ? 10 : 6)) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, false, true);
        this.updateLang();
    }

    public Menu_InGame_Outliner_CurrentWars_Info() {
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
        if (CFG.historyManager.getHistorySize() > 0) {
            int iSize;
            int i = iSize = CFG.historyManager.getHistorySize() - 1;
            int tTurn = 0;
            while (i > iSize - 3 && i >= 0) {
                int j;
                int jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.UNION || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_Union(CFG.historyManager.getHistory((int)i, (int)j).iCivA, GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.WAR_DECLARAION || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivB)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_War(CFG.historyManager.getHistory((int)i, (int)j).iCivA, CFG.historyManager.getHistory((int)i, (int)j).iCivB, GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.TRUCE || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivB)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_Truce(CFG.historyManager.getHistory((int)i, (int)j).iCivA, CFG.historyManager.getHistory((int)i, (int)j).iCivB, GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.NEW_COONY || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_NewColony(CFG.historyManager.getHistory((int)i, (int)j).iCivA, CFG.historyManager.getHistory((int)i, (int)j).iCivB, GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.ANNEXATION || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivB)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_Annexation(CFG.historyManager.getHistory((int)i, (int)j).iCivA, CFG.historyManager.getHistory((int)i, (int)j).iCivB, GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.DISEASE || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_Disease(CFG.historyManager.getHistory((int)i, (int)j).iCivA, CFG.historyManager.getHistory((int)i, (int)j).iCivB, CFG.historyManager.getHistory(i, j).getName(), GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.JOINS_ALLIANCE || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_Alliance(CFG.historyManager.getHistory((int)i, (int)j).iCivA, CFG.historyManager.getHistory((int)i, (int)j).iCivB, GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.LEAVES_ALLIANCE || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_AllianceLeaves(CFG.historyManager.getHistory((int)i, (int)j).iCivA, CFG.historyManager.getHistory(i, j).getName(), GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.IS_VASSAL || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivB)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_IsVassal(CFG.historyManager.getHistory((int)i, (int)j).iCivA, CFG.historyManager.getHistory((int)i, (int)j).iCivB, GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.IS_NOT_VASSAL || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivB)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_IsNotVassal(CFG.historyManager.getHistory((int)i, (int)j).iCivA, CFG.historyManager.getHistory((int)i, (int)j).iCivB, GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.FRIENDLY_CIVS || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivB)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_FriendlyCivs(CFG.historyManager.getHistory((int)i, (int)j).iCivA, CFG.historyManager.getHistory((int)i, (int)j).iCivB, GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.SIGNED_DEFENSIVE_PACT || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivB)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_SignedDefensivePact(CFG.historyManager.getHistory((int)i, (int)j).iCivA, CFG.historyManager.getHistory((int)i, (int)j).iCivB, GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.SIGNED_NON_AGGRESSION_PACT || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivB)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_SignedNonAggressionPact(CFG.historyManager.getHistory((int)i, (int)j).iCivA, CFG.historyManager.getHistory((int)i, (int)j).iCivB, GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.GUARANTEE || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivB)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_Guarantee(CFG.historyManager.getHistory((int)i, (int)j).iCivA, CFG.historyManager.getHistory((int)i, (int)j).iCivB, GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                jSize = CFG.historyManager.getHistoryTurnSize(i);
                for (j = 0; j < jSize; ++j) {
                    if (CFG.historyManager.getHistory((int)i, (int)j).historyLog_Type != HistoryLog_Types.HAVE_MILITARY_ACCESS || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivA) && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.historyManager.getHistory((int)i, (int)j).iCivB)) continue;
                    menuElements.add(new TextOutliner_DiploInfo_HaveMilitaryAccess(CFG.historyManager.getHistory((int)i, (int)j).iCivA, CFG.historyManager.getHistory((int)i, (int)j).iCivB, GameCalendar.TURNID - tTurn, 2, tPosY, tMenuWidth - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
                --i;
                ++tTurn;
            }
        }
        this.initMenu(null, CFG.GAMEWIDTH - tMenuWidth, -1 + (CFG.menus.getVisible_Menu_InGame_CurrentWars() ? CFG.menus.getMenu_InGame_CurrentWars().getPosY() + CFG.menus.getMenu_InGame_CurrentWars().getHeightM() : (CFG.menus.getVisible_Menu_InGame_Outliner() ? CFG.menus.getMenu_InGame_Outliner().getPosY() + CFG.menus.getMenu_InGame_Outliner().getHeightM() : IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2)), tMenuWidth, Math.min((CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2) * 4, menuElements.size() > 0 ? ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() : 0) + 1, menuElements, false, false);
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr((CFG.menus.getMenu_InGame_CurrentWars().getMenuElemsSize() + i) % 2);
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
        if (hideAnimation != Menu_InGame_Outliner_CurrentWars_Info.hideAnimation) {
            lTime = lTime > System.currentTimeMillis() - 135L ? System.currentTimeMillis() - (135L - (System.currentTimeMillis() - lTime)) : System.currentTimeMillis();
            CFG.setRenderO(true);
        }
        Menu_InGame_Outliner_CurrentWars_Info.hideAnimation = hideAnimation;
    }
}

