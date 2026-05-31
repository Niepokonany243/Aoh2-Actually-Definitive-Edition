
package age.of.civilizations2.jakowski.lukasz.Menus.Civilization;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy_InGame;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_InGameWar;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_LiberityDesire;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_Wiki;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_Wiki_Civ;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Opinion.Button_Diplomacy_OpinionText;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Relations.Button_Diplomacy_ImprovingRelations;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Managers.RivalsManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Alliance.Menu_InGame_Alliance;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_DiplomacyORActions;
import age.of.civilizations2.jakowski.lukasz.Menus.Wars.Details.Menu_InGame_WarDetails;
import age.of.civilizations2.jakowski.lukasz.Messages.Relations.Message_Relations_Increase_Ended;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmallOpinion;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_Civ_Diplomacy
extends Menu {
    public int relationTitleIMG = 0;

    public static int getButtonHeight() {
        return Math.max(CFG.TEXT_HEIGHT_DEFAULT, IMGManager.getIMG(Images.flagRect2Mask).getHeight()) + CFG.PADD * 4;
    }

    public Menu_InGame_Civ_Diplomacy() {
        int i;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int menuW = Menu_InGame_Civ.getMenuCivInfoWidth();
        int tPosY = 0;
        ArrayList<Integer> tData = new ArrayList<Integer>();
        int buttonH = Menu_InGame_Civ_Diplomacy.getButtonHeight();
        boolean wikiBtn = false;
        if (CFG.getActiveCivInfoId() > 0) {
            List<Integer> rivaledBy;
            int i2;
            int i3;
            int a;
            int a2;
            int i4;
            if (!Menu_InGame_Civ_Diplomacy.getOpinionInTitle2()) {
                if (CFG.getActiveCivInfoId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                    menuElements.add(new Button_Diplomacy_OpinionText(CFG.getActiveCivInfoId(), (int)CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 0, 0, tPosY, menuW - 2 - (ButtonDiplomacy.iDiploWidth + CFG.PADD * 2), buttonH, true){

                        @Override
                        public void actionElem(int iID) {
                            int nWarID;
                            if ((int)CFG.core.getCivRelationOfCivB(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) == GameValues.gvDiplomacy.RELATION_AT_WAR && (nWarID = CFG.core.getWarID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) >= 0 && nWarID < CFG.core.getWarsSize()) {
                                Menu_InGame_WarDetails.WAR_ID = nWarID;
                                CFG.menus.rebuildInGame_WarDetails();
                            }
                        }
                    });
                    menuElements.add(new Button_Diplomacy_Wiki(CFG.getActiveCivInfoId(), menuW - 2 - (ButtonDiplomacy.iDiploWidth + CFG.PADD * 2), tPosY, ButtonDiplomacy.iDiploWidth + CFG.PADD * 2, buttonH, true){});
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                    wikiBtn = true;
                } else {
                    menuElements.add(new Button_Diplomacy_Wiki_Civ(CFG.getActiveCivInfoId(), (int)CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 0, 0, tPosY, menuW - 2, buttonH, true){});
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
            if (CFG.getActiveCivInfoId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && !CFG.SPECTATOR_MODE) {
                for (i4 = 0; i4 < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getImproveRelationsSize(); ++i4) {
                    menuElements.add(new Button_Diplomacy_ImprovingRelations(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getImproveRelation((int)i4).iWithCivID, CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getImproveRelation((int)i4).iNumOfTurns, 0, 0, tPosY, menuW - 2, buttonH, true){

                        @Override
                        public void actionElem(int iID) {
                            if (!CFG.SPECTATOR_MODE) {
                                CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_Relations_Increase_Ended(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getImproveRelation((int)(iID - 1)).iWithCivID));
                                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().removeImproveRelations(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), iID - 1);
                                CFG.updateActiveCivilizationInfoInGame();
                                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                                CFG.toastM.addM(CFG.lang.get("Removed"), CFG.COLOR_HOVER_TITLE);
                                CFG.menus.rebuildInGame_Messages();
                            }
                        }
                    });
                    ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr((i4 + (wikiBtn ? 0 : 1)) % 2);
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
            if (!CFG.core.getCiv(CFG.getActiveCivInfoId()).getIsPlayer() && CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv() != CFG.getActiveCivInfoId()) {
                menuElements.add(new Button_Diplomacy_LiberityDesire(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv(), (int)CFG.core.getCiv(CFG.getActiveCivInfoId()).getVassalLibertyDesire(), 0, 0, tPosY, menuW - 2, buttonH, true){

                    @Override
                    public void actionElem(int iID) {
                        if (CFG.core.getCiv(this.getCurr()).getPuppetOfCiv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                            if (CFG.menus.getVisibleInGame_Tribute()) {
                                CFG.menus.setVisibleInGame_Tribute(false);
                            } else {
                                CFG.menus.rebuildInGame_Tribute();
                            }
                        } else {
                            CFG.toastM.addM(CFG.lang.get("Lord") + ": " + CFG.core.getCiv(CFG.core.getCiv(this.getCurr()).getPuppetOfCiv()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                        }
                    }
                });
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i4 = 1; i4 < CFG.core.getCivsSize(); ++i4) {
                if (i4 == CFG.getActiveCivInfoId() || (int)CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), i4) != GameValues.gvDiplomacy.RELATION_AT_WAR || CFG.core.getCiv(i4).getNumOfProvs() <= 0) continue;
                if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i4)) {
                    tData.add(i4);
                    continue;
                }
                tData.add(-1);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new Button_Diplomacy_InGameWar(Images.diploWar, tData, 0, tPosY, menuW - 2){

                    @Override
                    public void actionElem(int iID) {
                        ArrayList<Integer> tWars = new ArrayList<Integer>();
                        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                            if (i == CFG.getActiveCivInfoId() || (int)CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), i) != GameValues.gvDiplomacy.RELATION_AT_WAR || CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
                            int tWarID = CFG.core.getWarID(i, CFG.getActiveCivInfoId());
                            boolean added = false;
                            for (int j = 0; j < tWars.size(); ++j) {
                                if ((Integer)tWars.get(j) != tWarID) continue;
                                added = true;
                                break;
                            }
                            if (added) continue;
                            tWars.add(tWarID);
                        }
                        if (tWars.size() > 0) {
                            if (CFG.menus.getVisibleInGame_WarDetails()) {
                                int nWarID = 0;
                                for (int i = 0; i < tWars.size(); ++i) {
                                    if (Menu_InGame_WarDetails.WAR_ID != (Integer)tWars.get(i)) continue;
                                    nWarID = i + 1;
                                    break;
                                }
                                if (nWarID >= tWars.size()) {
                                    CFG.menus.setVisibleInGame_WarDetails(false);
                                } else {
                                    Menu_InGame_WarDetails.WAR_ID = (Integer)tWars.get(nWarID);
                                    CFG.menus.rebuildInGame_WarDetails();
                                }
                            } else {
                                Menu_InGame_WarDetails.WAR_ID = (Integer)tWars.get(0);
                                CFG.menus.rebuildInGame_WarDetails();
                            }
                        } else {
                            CFG.menus.setVisibleInGame_WarDetails(false);
                        }
                    }
                });
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getAlliance() > 0) {
                tData.clear();
                for (i4 = 0; i4 < CFG.core.getAlliance(CFG.core.getCiv(CFG.getActiveCivInfoId()).getAlliance()).getCivilizationsSize(); ++i4) {
                    if (CFG.core.getAlliance(CFG.core.getCiv(CFG.getActiveCivInfoId()).getAlliance()).getCivilization(i4) == CFG.getActiveCivInfoId()) continue;
                    if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getAlliance(CFG.core.getCiv(CFG.getActiveCivInfoId()).getAlliance()).getCivilization(i4))) {
                        tData.add(CFG.core.getAlliance(CFG.core.getCiv(CFG.getActiveCivInfoId()).getAlliance()).getCivilization(i4));
                        continue;
                    }
                    tData.add(-1);
                }
                if (tData.size() > 0) {
                    menuElements.add(new ButtonDiplomacy_InGame(Images.diploAlliance, tData, 0, tPosY, menuW - 2){

                        @Override
                        public void actionElem(int iID) {
                            try {
                                if (CFG.menus.getVisible_InGame_Alliance() && Menu_InGame_Alliance.ALLIANCE_ID == CFG.core.getCiv(CFG.getActiveCivInfoId()).getAlliance()) {
                                    CFG.menus.setVisible_InGame_Alliance(false);
                                } else {
                                    CFG.menus.rebuildInGame_Alliance(CFG.core.getCiv(CFG.getActiveCivInfoId()).getAlliance());
                                }
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                                
                            }
                        }
                    });
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
            tData.clear();
            for (i4 = 1; i4 < CFG.core.getCivsSize(); ++i4) {
                if (i4 == CFG.getActiveCivInfoId() || CFG.core.getCiv(i4).getNumOfProvs() <= 0 || CFG.core.getCiv(i4).getPuppetOfCiv() != CFG.getActiveCivInfoId()) continue;
                if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i4)) {
                    tData.add(i4);
                    continue;
                }
                tData.add(-1);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploVassal, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i4 = 1; i4 < CFG.core.getCivsSize(); ++i4) {
                if (i4 == CFG.getActiveCivInfoId() || CFG.core.getCiv(i4).getNumOfProvs() <= 0 || CFG.core.getCivTruce(i4, CFG.getActiveCivInfoId()) <= 0) continue;
                if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i4)) {
                    tData.add(i4);
                    continue;
                }
                tData.add(-1);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploTruce, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            if (!CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.lSanctions.isEmpty()) {
                tData.clear();
                for (i4 = 0; i4 < CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.lSanctions.size(); ++i4) {
                    if (CFG.getActiveCivInfoId() != CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.lSanctions.get((int)i4).byCivID) {
                        if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.lSanctions.get((int)i4).byCivID)) {
                            tData.add(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.lSanctions.get((int)i4).byCivID);
                        } else {
                            tData.add(-1);
                        }
                    }
                    if (CFG.getActiveCivInfoId() == CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.lSanctions.get((int)i4).onCivID) continue;
                    if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.lSanctions.get((int)i4).onCivID)) {
                        tData.add(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.lSanctions.get((int)i4).onCivID);
                        continue;
                    }
                    tData.add(-1);
                }
                if (!tData.isEmpty()) {
                    menuElements.add(new ButtonDiplomacy_InGame(Images.sanctions, tData, 0, tPosY, menuW - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
            if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getLoansFromCivSize() > 0) {
                tData.clear();
                for (i4 = 0; i4 < CFG.core.getCiv(CFG.getActiveCivInfoId()).getLoansFromCivSize(); ++i4) {
                    if (CFG.getActiveCivInfoId() == CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getLoanFromCiv((int)i4).fromCivID) continue;
                    if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getLoanFromCiv((int)i4).fromCivID)) {
                        tData.add(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getLoanFromCiv((int)i4).fromCivID);
                        continue;
                    }
                    tData.add(-1);
                }
                if (!tData.isEmpty()) {
                    menuElements.add(new ButtonDiplomacy_InGame(Images.loanRe, tData, 0, tPosY, menuW - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
            tData.clear();
            for (a2 = 0; a2 < CFG.core.investForeignGold.size(); ++a2) {
                if (CFG.core.investForeignGold.get((int)a2).civID != CFG.getActiveCivInfoId() || tData.contains(CFG.core.investForeignGold.get((int)a2).inCivID)) continue;
                tData.add(CFG.core.investForeignGold.get((int)a2).inCivID);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.investF1, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (a2 = 0; a2 < CFG.core.investForeignGold.size(); ++a2) {
                if (CFG.core.investForeignGold.get((int)a2).inCivID != CFG.getActiveCivInfoId() || tData.contains(CFG.core.investForeignGold.get((int)a2).civID)) continue;
                tData.add(CFG.core.investForeignGold.get((int)a2).civID);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.investF, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (a2 = 0; a2 < CFG.core.buildForeignGold.size(); ++a2) {
                if (CFG.core.buildForeignGold.get((int)a2).civID != CFG.getActiveCivInfoId() || tData.contains(CFG.core.buildForeignGold.get((int)a2).inCivID)) continue;
                tData.add(CFG.core.buildForeignGold.get((int)a2).inCivID);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.investB1, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (a2 = 0; a2 < CFG.core.buildForeignGold.size(); ++a2) {
                if (CFG.core.buildForeignGold.get((int)a2).inCivID != CFG.getActiveCivInfoId() || tData.contains(CFG.core.buildForeignGold.get((int)a2).civID)) continue;
                tData.add(CFG.core.buildForeignGold.get((int)a2).civID);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.investB, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            try {
                for (a2 = 0; a2 < CFG.core.propaganda.size(); ++a2) {
                    if (CFG.core.propaganda.get((int)a2).byCivID != CFG.getActiveCivInfoId() || tData.contains(CFG.core.getProv(CFG.core.propaganda.get((int)a2).provinceID).getCivId())) continue;
                    tData.add(CFG.core.getProv(CFG.core.propaganda.get((int)a2).provinceID).getCivId());
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.propaganda1, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            try {
                for (int a3 = 0; a3 < CFG.core.propaganda.size(); ++a3) {
                    if (CFG.core.getProv(CFG.core.propaganda.get((int)a3).provinceID).getCivId() != CFG.getActiveCivInfoId() || tData.contains(CFG.core.propaganda.get((int)a3).byCivID)) continue;
                    tData.add(CFG.core.propaganda.get((int)a3).byCivID);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.propaganda, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (a = 0; a < CFG.core.diplomaticSummits.size(); ++a) {
                if (!CFG.core.diplomaticSummits.get(a).isInvited(CFG.getActiveCivInfoId())) continue;
                for (int b = CFG.core.diplomaticSummits.get((int)a).invitedCivs.size() - 1; b >= 0; --b) {
                    if (CFG.core.diplomaticSummits.get((int)a).invitedCivs.get(b) == CFG.getActiveCivInfoId() || tData.contains(CFG.core.diplomaticSummits.get((int)a).invitedCivs.get(b))) continue;
                    tData.add(CFG.core.diplomaticSummits.get((int)a).invitedCivs.get(b));
                }
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.summit, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (a = 0; a < CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civNeighbors.civsSize; ++a) {
                tData.add(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civNeighbors.civs.get((int)a).civID);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.frontline, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            if (GameValues.gvInGame.CIV_DIPLOMACY_SHOW_NEIGH_AT_WAR) {
                tData.clear();
                for (a = 0; a < CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civNeighbors.civsSize; ++a) {
                    if (!CFG.core.getCiv(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civNeighbors.civs.get((int)a).civID).isAtWarC()) continue;
                    tData.add(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civNeighbors.civs.get((int)a).civID);
                }
                if (!tData.isEmpty()) {
                    menuElements.add(new ButtonDiplomacy_InGame(Images.neighWar, tData, 0, tPosY, menuW - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
            if (GameValues.gvInGame.CIV_DIPLOMACY_SHOW_CONQUERED_CIVS) {
                try {
                    tData.clear();
                    for (int j = 0; j < CFG.core.getCiv(CFG.getActiveCivInfoId()).getNumOfProvs(); ++j) {
                        for (int k = 0; k < CFG.core.getProv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getProvID(j)).getCores().getCivsSize(); ++k) {
                            if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getProvID(j)).getCores().getCivID(k)).getNumOfProvs() != 0 || tData.contains(CFG.core.getProv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getProvID(j)).getCores().getCivID(k))) continue;
                            tData.add(CFG.core.getProv(CFG.core.getCiv(CFG.getActiveCivInfoId()).getProvID(j)).getCores().getCivID(k));
                        }
                    }
                    if (!tData.isEmpty()) {
                        menuElements.add(new ButtonDiplomacy_InGame(Images.conquered, tData, 0, tPosY, menuW - 2));
                        tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            ArrayList<Integer> tempOpinions = new ArrayList<Integer>();
            ArrayList<Integer> tempSortedIDs = new ArrayList<Integer>();
            for (i3 = 1; i3 < CFG.core.getCivsSize(); ++i3) {
                if (CFG.core.getCiv(i3).getNumOfProvs() <= 0 || CFG.getActiveCivInfoId() == i3) continue;
                tempOpinions.add(i3);
            }
            while (!tempOpinions.isEmpty()) {
                int highestID = 0;
                for (i2 = 1; i2 < tempOpinions.size(); ++i2) {
                    if (!(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), (Integer)tempOpinions.get(highestID)) > CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), (Integer)tempOpinions.get(i2)))) continue;
                    highestID = i2;
                }
                tempSortedIDs.add((Integer)tempOpinions.get(highestID));
                tempOpinions.remove(highestID);
            }
            tData.clear();
            i3 = tempSortedIDs.size() - 1;
            for (int j = 0; i3 >= 0 && j < 6 && !(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), (Integer)tempSortedIDs.get(i3)) < 25.0f); --i3, ++j) {
                if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)tempSortedIDs.get(i3))) {
                    tData.add((Integer)tempSortedIDs.get(i3));
                    continue;
                }
                tData.add(-1);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploHeart, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i3 = 0; i3 < CFG.core.getCiv(CFG.getActiveCivInfoId()).getHatedCivsSize(); ++i3) {
                tData.add(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getHatedCiv((int)i3).iCivID);
            }
            for (i3 = 0; i3 < 10 && i3 < tempSortedIDs.size() && !(CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), (Integer)tempSortedIDs.get(i3)) > (float)GameValues.gvRelations.HATED_MIN_RELATION); ++i3) {
                boolean addCiv = true;
                for (int z = tData.size() - 1; z >= 0; --z) {
                    if (!((Integer)tData.get(z)).equals(tempSortedIDs.get(i3))) continue;
                    addCiv = false;
                    break;
                }
                if (!addCiv) continue;
                if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)tempSortedIDs.get(i3))) {
                    tData.add((Integer)tempSortedIDs.get(i3));
                    continue;
                }
                tData.add(-1);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploRivals, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            try {
                tData.clear();
                if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getNumOfProvs() > 0) {
                    for (int j = 0; j < CFG.core.getCiv(CFG.getActiveCivInfoId()).getWarReparationsPaysSize(); ++j) {
                        if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getWarReparationsPays((int)j).iFromCivID)) {
                            tData.add(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getWarReparationsPays((int)j).iFromCivID);
                            continue;
                        }
                        tData.add(-1);
                    }
                }
                if (!tData.isEmpty()) {
                    menuElements.add(new ButtonDiplomacy_InGame(Images.topGold2, tData, 0, tPosY, menuW - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
            catch (IndexOutOfBoundsException j) {
                
            }
            tData.clear();
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (i == CFG.getActiveCivInfoId() || CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getDefensivePact(i, CFG.getActiveCivInfoId()) <= 0) continue;
                if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i)) {
                    tData.add(i);
                    continue;
                }
                tData.add(-1);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploDefensivePact, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (i == CFG.getActiveCivInfoId() || CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getCivNonAggressionPact(i, CFG.getActiveCivInfoId()) <= 0) continue;
                if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i)) {
                    tData.add(i);
                    continue;
                }
                tData.add(-1);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploNonAggression, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (i == CFG.getActiveCivInfoId() || CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getGuarantee(i, CFG.getActiveCivInfoId()) <= 0) continue;
                if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i)) {
                    tData.add(i);
                    continue;
                }
                tData.add(-1);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploGuaranteeHas, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (i == CFG.getActiveCivInfoId() || CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getGuarantee(CFG.getActiveCivInfoId(), i) <= 0) continue;
                if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i)) {
                    tData.add(i);
                    continue;
                }
                tData.add(-1);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploGuaranteeGives, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (i == CFG.getActiveCivInfoId() || CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getMilitaryAccess(i, CFG.getActiveCivInfoId()) <= 0) continue;
                if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i)) {
                    tData.add(i);
                    continue;
                }
                tData.add(-1);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploAccessHas, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (i == CFG.getActiveCivInfoId() || CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getMilitaryAccess(CFG.getActiveCivInfoId(), i) <= 0) continue;
                if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i)) {
                    tData.add(i);
                    continue;
                }
                tData.add(-1);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploAccessGives, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i = 0; i < CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivDiploGD().getEmbassyClosedSize(); ++i) {
                if (i == CFG.getActiveCivInfoId() || CFG.core.getCiv(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getCivDiploGD().getEmbassyClosed((int)i).iCivID).getNumOfProvs() <= 0 || CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getCivDiploGD().getEmbassyClosed((int)i).iNumOfTurns <= 0) continue;
                if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getCivDiploGD().getEmbassyClosed((int)i).iCivID)) {
                    tData.add(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getCivDiploGD().getEmbassyClosed((int)i).iCivID);
                    continue;
                }
                tData.add(-1);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploRelationsDec, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            if (CFG.getActiveCivInfoId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.SPECTATOR_MODE) {
                tData.clear();
                for (i = 0; i < CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivDiploGD().getImproveRelationsSize(); ++i) {
                    if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getCivDiploGD().getImproveRelation((int)i).iWithCivID)) {
                        tData.add(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getCivDiploGD().getImproveRelation((int)i).iWithCivID);
                        continue;
                    }
                    tData.add(-1);
                }
                if (!tData.isEmpty()) {
                    menuElements.add(new ButtonDiplomacy_InGame(Images.diploRelationsInc, tData, 0, tPosY, menuW - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
            tData.clear();
            block43: for (int k = 1; k < CFG.core.getCivsSize(); ++k) {
                if (CFG.core.getCiv(k).getNumOfProvs() <= 0) continue;
                for (i2 = 0; i2 < CFG.core.getCiv(k).getCivDiploGD().getImproveRelationsSize(); ++i2) {
                    if (CFG.getActiveCivInfoId() != CFG.core.getCiv((int)k).getCivDiploGD().getImproveRelation((int)i2).iWithCivID) continue;
                    if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(k)) {
                        tData.add(k);
                        continue block43;
                    }
                    tData.add(-1);
                    continue block43;
                }
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploRelations, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            if (CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.civRivalsSize > 0) {
                tData.clear();
                for (i = 0; i < CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.civRivalsSize; ++i) {
                    if (CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.civRivals.get((int)i).iCivID == CFG.getActiveCivInfoId() || CFG.core.getCiv(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.civRivals.get((int)i).iCivID).getNumOfProvs() <= 0) continue;
                    if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.civRivals.get((int)i).iCivID)) {
                        tData.add(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.civRivals.get((int)i).iCivID);
                        continue;
                    }
                    tData.add(-1);
                }
                if (!tData.isEmpty()) {
                    menuElements.add(new ButtonDiplomacy_InGame(Images.diploRivals2, tData, 0, tPosY, menuW - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
            if (!(rivaledBy = RivalsManager.getRivaledBy(CFG.getActiveCivInfoId())).isEmpty()) {
                tData.clear();
                for (i2 = 0; i2 < rivaledBy.size(); ++i2) {
                    if (rivaledBy.get(i2) == CFG.getActiveCivInfoId() || CFG.core.getCiv(rivaledBy.get(i2)).getNumOfProvs() <= 0) continue;
                    if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(rivaledBy.get(i2))) {
                        tData.add(rivaledBy.get(i2));
                        continue;
                    }
                    tData.add(-1);
                }
                if (!tData.isEmpty()) {
                    menuElements.add(new ButtonDiplomacy_InGame(Images.diploRivaledBy, tData, 0, tPosY, menuW - 2));
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
            if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getIsPartOfHolyRomanEmpire()) {
                tData.clear();
                for (i2 = 0; i2 < CFG.core.getCivsSize(); ++i2) {
                    if (CFG.core.getCiv(i2).getNumOfProvs() <= 0 || i2 == CFG.getActiveCivInfoId() || !CFG.core.getCiv(i2).getIsPartOfHolyRomanEmpire()) continue;
                    if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i2)) {
                        tData.add(i2);
                        continue;
                    }
                    tData.add(-1);
                }
                if (!tData.isEmpty()) {
                    menuElements.add(new ButtonDiplomacy_InGame(Images.hreIcon, tData, 0, tPosY, menuW - 2){

                        @Override
                        public void actionElem(int iID) {
                            if (CFG.menus.getVisibleInGameHRE()) {
                                CFG.menus.setVisible_InGame_HRE(false);
                            } else {
                                CFG.menus.rebuildInGameHRE();
                            }
                        }
                    });
                    tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            }
            tData.clear();
            for (i2 = CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.lGifts_Received.size() - 1; i2 >= 0; --i2) {
                if (i2 == CFG.getActiveCivInfoId()) continue;
                if (CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.lGifts_Received.get((int)i2).iFromCivID)) {
                    tData.add(CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.lGifts_Received.get((int)i2).iFromCivID);
                    continue;
                }
                tData.add(-1);
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploGift, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
            tData.clear();
            for (i2 = CFG.core.getCiv((int)CFG.getActiveCivInfoId()).civGD.loansTaken.size() - 1; i2 >= 0; --i2) {
                tData.add(CFG.getActiveCivInfoId());
            }
            if (!tData.isEmpty()) {
                menuElements.add(new ButtonDiplomacy_InGame(Images.diploLoan, tData, 0, tPosY, menuW - 2));
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        if (Menu_InGame_Civ_Diplomacy.getOpinionInTitle2()) {
            if (CFG.getActiveCivInfoId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                menuElements.add(new Button_Diplomacy_OpinionText(CFG.getActiveCivInfoId(), (int)CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 0, 0, tPosY, menuW - 2 - (ButtonDiplomacy.iDiploWidth + CFG.PADD * 2), buttonH, true){

                    @Override
                    public void actionElem(int iID) {
                        int nWarID;
                        if ((int)CFG.core.getCivRelationOfCivB(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) == GameValues.gvDiplomacy.RELATION_AT_WAR && (nWarID = CFG.core.getWarID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) >= 0 && nWarID < CFG.core.getWarsSize()) {
                            Menu_InGame_WarDetails.WAR_ID = nWarID;
                            CFG.menus.rebuildInGame_WarDetails();
                        }
                    }
                });
                menuElements.add(new Button_Diplomacy_Wiki(CFG.getActiveCivInfoId(), menuW - 2 - (ButtonDiplomacy.iDiploWidth + CFG.PADD * 2), tPosY, ButtonDiplomacy.iDiploWidth + CFG.PADD * 2, buttonH, true){});
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            } else {
                menuElements.add(new Button_Diplomacy_Wiki_Civ(CFG.getActiveCivInfoId(), (int)CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 0, 0, tPosY, menuW - 2, buttonH, true){});
                tPosY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        menuElements.add(new Button_Transparent(0, 0, menuW, (CFG.CIV_FLAG_HEIGHT + CFG.PADD * 2) * 3, true));
        int buttonH2 = Menu_InGame_Civ_DiplomacyORActions.getButtonHeight();
        this.relationTitleIMG = CFG.getActiveCivInfoId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() ? (CFG.core.getCivsAtWar(CFG.getActiveCivInfoId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) ? Images.diploWar : Images.diploRelations) : Images.diploRelations;
        this.initMenu(Menu_InGame_Civ_Diplomacy.getOpinionInTitle() ? new TitleM_TextSmallOpinion(CFG.lang.get("Opinion") + ": ", buttonH2, false, false, (int)CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), CFG.lang.get("Diplomacy")){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, Menu_InGame_Civ_Diplomacy.this.getPosX() + iTranslateX, Menu_InGame_Civ_Diplomacy.this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() - this.getHeightT(), Menu_InGame_Civ_Diplomacy.this.getWidthM() + Core.PADDING, this.getHeightT(), true, false);
                CFG.drawRectInfoBox_Left_Title(oSB, Menu_InGame_Civ_Diplomacy.this.getPosX() + iTranslateX, Menu_InGame_Civ_Diplomacy.this.getPosY() - this.getHeightT(), Menu_InGame_Civ_Diplomacy.this.getWidthM() - 2, this.getHeightT());
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sDiplomacy, nPosX + CFG.PADD * 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - this.getTextHeight() / 2, CFG.COLOR_TEXT_CIV_INFO_TITLE);
                IMGManager.getIMG(Menu_InGame_Civ_Diplomacy.this.relationTitleIMG).draw(oSB, nPosX + nWidth - CFG.PADD * 2 - (int)((float)IMGManager.getIMG(Menu_InGame_Civ_Diplomacy.this.relationTitleIMG).getWidth() * Menu_InGame_Civ_Diplomacy.this.getImageScale(IMGManager.getIMG(Menu_InGame_Civ_Diplomacy.this.relationTitleIMG).getHeight())) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - (int)((float)IMGManager.getIMG(Menu_InGame_Civ_Diplomacy.this.relationTitleIMG).getHeight() * Menu_InGame_Civ_Diplomacy.this.getImageScale(IMGManager.getIMG(Menu_InGame_Civ_Diplomacy.this.relationTitleIMG).getHeight())) / 2, (int)((float)IMGManager.getIMG(Menu_InGame_Civ_Diplomacy.this.relationTitleIMG).getWidth() * Menu_InGame_Civ_Diplomacy.this.getImageScale(IMGManager.getIMG(Menu_InGame_Civ_Diplomacy.this.relationTitleIMG).getHeight())), (int)((float)IMGManager.getIMG(Menu_InGame_Civ_Diplomacy.this.relationTitleIMG).getHeight() * Menu_InGame_Civ_Diplomacy.this.getImageScale(IMGManager.getIMG(Menu_InGame_Civ_Diplomacy.this.relationTitleIMG).getHeight())));
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sText, nPosX + nWidth - CFG.PADD * 3 - this.getTextWidth() - this.iOpinionWidth - (int)((float)IMGManager.getIMG(Menu_InGame_Civ_Diplomacy.this.relationTitleIMG).getWidth() * Menu_InGame_Civ_Diplomacy.this.getImageScale(IMGManager.getIMG(Menu_InGame_Civ_Diplomacy.this.relationTitleIMG).getHeight())) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - this.getTextHeight() / 2, CFG.COLOR_TEXT_CIV_INFO_TITLE);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sOpinion, nPosX + nWidth - CFG.PADD * 3 - this.iOpinionWidth - (int)((float)IMGManager.getIMG(Menu_InGame_Civ_Diplomacy.this.relationTitleIMG).getWidth() * Menu_InGame_Civ_Diplomacy.this.getImageScale(IMGManager.getIMG(Menu_InGame_Civ_Diplomacy.this.relationTitleIMG).getHeight())) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - this.getTextHeight() / 2, this.opinionColor);
            }
        } : new TitleM_TextSmall(CFG.lang.get("Diplomacy"), buttonH2, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, Menu_InGame_Civ_Diplomacy.this.getPosX() + iTranslateX, Menu_InGame_Civ_Diplomacy.this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() - this.getHeightT(), Menu_InGame_Civ_Diplomacy.this.getWidthM() + Core.PADDING, this.getHeightT(), true, false);
                CFG.drawRectInfoBox_Left_Title(oSB, Menu_InGame_Civ_Diplomacy.this.getPosX() + iTranslateX, Menu_InGame_Civ_Diplomacy.this.getPosY() - this.getHeightT(), Menu_InGame_Civ_Diplomacy.this.getWidthM() - 2, this.getHeightT());
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 - this.getTextHeight() / 2, CFG.COLOR_TEXT_CIV_INFO_TITLE);
            }
        }, AoCGame.LEFT, IMGManager.getIMG(Images.gameTop).getHeight() + CFG.PADD * 4 + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.6f) + ButtonFlagBig.getButtonH() + CFG.PADD * 4, menuW, (int)((float)buttonH * (CFG.getIsDesktop() ? GameValues.gvInGame.CIV_VIEW_DIPLOMACY_BUTTONS_LIMIT : GameValues.gvInGame.CIV_VIEW_DIPLOMACY_BUTTONS_LIMIT_MOBILE)), menuElements, false, false);
        this.updateLang();
        if (wikiBtn) {
            this.getMenuElem(0).setCurr(1);
            this.getMenuElem(1).setCurr(1);
        } else {
            this.getMenuElem(0).setCurr(0);
        }
        int n = i = wikiBtn ? 2 : 1;
        while (i < this.getMenuElemsSize()) {
            this.getMenuElem(i).setMax(i % 2);
            ++i;
        }
    }

    public final float getImageScale(int nHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nHeight;
    }

    public static boolean getOpinionInTitle() {
        return Menu_InGame_Civ.getUseMenu_UI2() && CFG.getActiveCivInfoId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
    }

    public static boolean getOpinionInTitle2() {
        return Menu_InGame_Civ.getUseMenu_UI2();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_InGame_Civ.lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            iTranslateX = Menu_InGame_Civ.hideAnimation ? (iTranslateX -= (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_InGame_Civ.lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))) : (iTranslateX += -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_InGame_Civ.lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME)));
            CFG.setRenderO(true);
        } else if (Menu_InGame_Civ.hideAnimation) {
            super.setVisibleM(false);
            return;
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING, this.getHeightM() + 2, true, false);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (AoCGame.LEFT != 0) {
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM() + 2, true, false);
            oSB.setColor(Color.WHITE);
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_CivInfo();
    }

    @Override
    public void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible) {
            super.setVisibleM(visible);
        }
    }
}

