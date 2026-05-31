/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Load.Scenario;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.CitiesManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Challenge.ChallengesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Choose.Menu_ChooseScenario_Title;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_Games;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class Menu_LoadScenario
extends Menu {
    public static int iStepID = 0;
    public static int iNumOfSteps = 20;
    public static boolean editor = false;
    public static View goToView = View.eCREATE_NEW_GAME;
    public static int loadActionEND = 0;
    public static boolean loadingStarted = false;
    public static CompletableFuture<Void> loadingFuture = null;
    public static int nTextureStep = -1;

    public Menu_LoadScenario() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        this.loadScenario();
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD * 3 + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3, false, true);
        CFG.drLOA(oSB, (int)((float)CFG.GAMEWIDTH * CFG.getLOAPAD()) + iTranslateX, CFG.GAMEHEIGHT - (int)((float)CFG.BUTTON_H * 0.8f) * 2 - CFG.PADD + iTranslateY, (int)((float)CFG.GAMEWIDTH * (1.0f - CFG.getLOAPAD() * 2.0f)), (int)((float)CFG.BUTTON_H * 0.8f), (float)iStepID / (float)iNumOfSteps);
        CFG.drawJakowskiGames_RIGHT_BOT(oSB, iTranslateX);
        CFG.drawVersionLB(oSB, iTranslateX);
    }

    public void loadScenario() {
        try {
            if (iStepID != 0) {
                if (iStepID == 1) {
                    CFG.core.loadScenario_1(editor);
                } else if (iStepID == 2) {
                    CFG.core.loadScenario_2(editor);
                } else if (iStepID == 3 || iStepID == 4 || iStepID == 5) {
                    // Skip or handle as needed, original code had if (iStepID != 3 && iStepID != 4 && iStepID != 5)
                } else if (iStepID == 6) {
                    CFG.core.loadScenario_2_Flags();
                } else if (iStepID == 7) {
                    if (!loadingStarted) {
                        loadingStarted = true;
                        loadingFuture = CompletableFuture.allOf(
                            CompletableFuture.runAsync(() -> CFG.core.loadScenario_3(editor)),
                            CompletableFuture.runAsync(() -> CFG.core.loadScenario_4(editor)),
                            CompletableFuture.runAsync(() -> CFG.core.loadScenario_5(editor)),
                            CompletableFuture.runAsync(() -> CFG.core.loadScenario_6(editor)),
                            CompletableFuture.runAsync(() -> CFG.core.loadScenario_7(editor)),
                            CompletableFuture.runAsync(() -> CFG.core.loadScenario_8(editor)),
                            CompletableFuture.runAsync(() -> CFG.core.loadScenario_9(editor))
                        );
                    }
                    if (loadingFuture.isDone()) {
                        iStepID = 13; // Will be incremented to 14
                        loadingStarted = false;
                    } else {
                        return; // Wait for next frame
                    }
                } else if (iStepID >= 8 && iStepID <= 13) {
                    // Handled by parallel block at step 7
                } else if (iStepID == 14) {
                    CFG.core.loadScenario_10(editor);
                } else if (iStepID == 15) {
                    CFG.core.loadScenario_11(editor);
                } else if (iStepID == 16) {
                    if (nTextureStep < 0) {
                        try {
                            if (CFG.core.getGameScenars().getScenario_ActivePallet_TAG() != null) {
                                for (int i = 0; i < CFG.palletManager.getNumOfPallets(); ++i) {
                                    if (!CFG.palletManager.getPalletTag(i).equals(CFG.core.getGameScenars().getScenario_ActivePallet_TAG())) continue;
                                    CFG.palletManager.setActivePalletID(i + 1);
                                    CFG.palletManager.loadCivilizationsPaletteOfColors(CFG.palletManager.getActivePalletID());
                                    break;
                                }
                            }
                            CitiesManager.buildLevelsOfCities();
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                        CFG.core.loadProvinceTextures_BatchInit();
                        nTextureStep = 0;
                    }
                    int provinSize = CFG.core.getProvinSize();
                    if (nTextureStep < provinSize) {
                        int batchSize = 500;
                        int end = Math.min(nTextureStep + batchSize, provinSize);
                        CFG.core.loadProvinceTextures_Batch(nTextureStep, end);
                        nTextureStep = end;
                        return;
                    } else if (nTextureStep == provinSize) {
                        CFG.core.loadProvinceTextures_BatchFinalise();
                        nTextureStep = provinSize + 1;
                        return;
                    } else if (nTextureStep <= provinSize * 2) {
                        int batchSize = 500;
                        int bgStart = nTextureStep - (provinSize + 1);
                        int bgEnd = Math.min(bgStart + batchSize, provinSize);
                        CFG.core.loadProvinceBG_Batch(bgStart, bgEnd);
                        nTextureStep = provinSize + 1 + bgEnd;
                        return;
                    } else {
                        nTextureStep = -1;
                    }
                } else if (iStepID == 17) {
                    CFG.core.loadScenario_13(editor);
                } else if (iStepID == 18) {
                    CFG.core.loadScenario_14(editor);
                } else if (iStepID == 19) {
                    if (loadActionEND != 0) {
                        if (loadActionEND == 1) {
                            CFG.core.getGameScenars().loadCoresDataEditor();
                            CFG.CREATE_SCENARIO_GAME_DATA_TAG = CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID());
                            CFG.CREATE_SCENARIO_NAME = CFG.core.getGameScenars().getScenarioNameID(CFG.core.getScenarioID());
                            CFG.CREATE_SCENARIO_AUTHOR = CFG.core.getGameScenars().getScenarioAuthorID(CFG.core.getScenarioID());
                            CFG.CREATE_SCENARIO_AGE = CFG.core.getGameScenars().getScenarioAgeID(CFG.core.getScenarioID());
                            CFG.CREATE_SCENARIO_WIKI = CFG.core.getGameScenars().getScenarioWiki(CFG.core.getScenarioID());
                            GameCalendar.currYear = CFG.core.getGameScenars().getScenarioYearID(CFG.core.getScenarioID());
                            GameCalendar.currMonth = CFG.core.getGameScenars().getScenarioMonth(CFG.core.getScenarioID());
                            GameCalendar.currDay = CFG.core.getGameScenars().getScenarioDay(CFG.core.getScenarioID());
                        } else if (loadActionEND == 2) {
                            CFG.core.initPlayers();
                            SaveGameManager.gameCanBeContinued = false;
                            Menu_Games.clickNewGame();
                            CFG.menus.rebuildCivs_Info_Players();
                            RenderProvince.updateDrawProvinces();
                        } else if (loadActionEND == 3) {
                            CFG.core.initPlayers();
                            CFG.core.setActiveProvID(-1);
                            CFG.menus.setMenuID(CFG.backToMenu);
                            CFG.menus.setBackAnimation(true);
                            Menu_ChooseScenario_Title.disposePreview();
                            Menu_ChooseScenario_Title.drawPreview = false;
                            this.onBackPressed();
                            CFG.menus.rebuildCivs_Info_Players();
                        } else if (loadActionEND == 4) {
                            CFG.core.initPlayers();
                            CFG.menus.setMenuID(CFG.goToMenu);
                            Menu_ChooseScenario_Title.drawPreview = false;
                            Menu_ChooseScenario_Title.disposePreview();
                            CFG.menus.disposeChooseScenarioFlags();
                            CFG.menus.rebuildCivs_Info_Players();
                        } else if (loadActionEND == 5) {
                            CFG.core.initPlayers();
                            CFG.setActiveCivInfoId(CFG.core.getPlayer(0).getCivId());
                            CFG.updateActiveCivInfo_CreateNewGame();
                            CFG.core.enableDrawCivlizationsRegions_Players();
                            CFG.menus.rebuildCivs_Info_Players();
                            CFG.menus.getCreateNewGame_CivInfo_updateLanguage();
                            ArrayList<String> tempMess = new ArrayList<String>();
                            tempMess.add(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(CFG.core.getScenarioID())));
                            tempMess.add(GameCalendar.getCurrDate());
                            CFG.toastM.addM(tempMess);
                        } else if (loadActionEND == 6) {
                            CFG.core.initPlayers();
                            CFG.menus.rebuildCivs_Info_Players();
                        } else if (loadActionEND == 7) {
                            SaveGameManager.gameCanBeContinued = false;
                            CFG.core.setActiveProvID(-1);
                            CFG.menus.setMenuID(View.eGAMES);
                            CFG.menus.setBackAnimation(true);
                        } else if (loadActionEND != 8 && loadActionEND != 9 && loadActionEND == 10) {
                            try {
                                if (ChallengesManager.challengeList.get((int)ChallengesManager.START_CHALLENGE_ID).ADD_CIV_PROVINCES != null && ChallengesManager.challengeList.get((int)ChallengesManager.START_CHALLENGE_ID).ADD_CIV_PROVINCES.size() > 0) {
                                    ChallengesManager.addCivilization();
                                }
                                CFG.core.initPlayers();
                                int challengeCivID = ChallengesManager.getChallengeCivID();
                                if (challengeCivID > 0 && CFG.core.getPlayer(0).getCivId() != challengeCivID) {
                                    CFG.core.getPlayer(0).setCivId(challengeCivID);
                                }
                                CFG.menus.rebuildCivs_Info_Players();
                            }
                            catch (Exception ex) {
                                CFG.exceptionStack(ex);
                            }
                        }
                    }
                } else if (goToView != null) {
                    CFG.menus.setMenuIDWithoutAnim(goToView);
                    if (goToView == View.eCREATE_NEW_GAME) {
                        CFG.menus.setVisible_CreateNewGame_AddCiv(false);
                        CFG.menus.setVisible_CreateNewGame_AddCiv_Gov(false);
                    }
                    if (loadActionEND == 10) {
                        CFG.menus.setVisible_CreateNewGame_Options(false);
                        CFG.menus.setVisible_CreateNewGame_CivInfo(true);
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        ++iStepID;
    }
}

