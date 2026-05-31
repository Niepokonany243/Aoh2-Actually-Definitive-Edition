/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Load;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapScale;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Vassal.Menu_InGame_Tribute;
import age.of.civilizations2.jakowski.lukasz.NewGameManager;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.Render;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.Start_The_Game_Data;
import age.of.civilizations2.jakowski.lukasz.TechManager;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_LoadSave
extends Menu {
    public static int iLoadID;
    public static int loadStepID;
    public static int loadStepID_TEXT;
    public static int tFileID;
    public static int tFileID2;
    public static boolean pause;
    public static int nLoadSubStep;
    public String[] tSplted;

    public Menu_LoadSave() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        loadStepID = 0;
        loadStepID_TEXT = 1;
        pause = false;
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD * 3 + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3, false, true);
        CFG.drLOA(oSB, (int)((float)CFG.GAMEWIDTH * CFG.getLOAPAD()) + iTranslateX, CFG.GAMEHEIGHT - (int)((float)CFG.BUTTON_H * 0.8f) * 2 - CFG.PADD + iTranslateY, (int)((float)CFG.GAMEWIDTH * (1.0f - CFG.getLOAPAD() * 2.0f)), (int)((float)CFG.BUTTON_H * 0.8f), (float)loadStepID / 41.0f, " #" + loadStepID_TEXT);
        CFG.drawJakowskiGames_RIGHT_BOT(oSB, iTranslateX);
        CFG.drawVersionLB(oSB, iTranslateX);
        CFG.setRenderO(true);
        this.loadSave();
    }

    public final void loadSave() {
        block73: {
            try {
                ++loadStepID_TEXT;
                if (pause) {
                    pause = false;
                    return;
                }
                if (loadStepID == 0) {
                    CFG.SAVED_GAME_LOADED = true;
                    CFG.SAVED_GAME_LOADED_2 = true;
                    tFileID = 0;
                    tFileID2 = 0;
                    FileHandle file2 = CFG.readLocalFiles() ? Gdx.files.local("saves/games/" + CFG.map.getFileActiveMapPath() + "Age_of_Civilizations") : FileManager.loadFile("saves/games/" + CFG.map.getFileActiveMapPath() + "Age_of_Civilizations");
                    String tempTags = file2.readString();
                    this.tSplted = tempTags.split(";");
                    break block73;
                }
                if (loadStepID == 1) {
                    CFG.core.loadSavedGame_NEW_1(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 2) {
                    if (CFG.core.loadSavedGame_NEW_2(iLoadID, this.tSplted)) {
                        pause = true;
                        return;
                    }
                    break block73;
                }
                if (loadStepID == 3) {
                    CFG.core.loadSavedGame_NEW_3(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 4) {
                    CFG.core.loadSavedGame_NEW_4(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 5) {
                    CFG.core.loadSavedGame_NEW_5(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 6) {
                    if (CFG.core.loadSavedGame_NEW_6(iLoadID, this.tSplted)) {
                        pause = true;
                        return;
                    }
                    break block73;
                }
                if (loadStepID == 7) {
                    CFG.core.loadSavedGame_NEW_7(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 8) {
                    CFG.core.loadSavedGame_NEW_8(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 9) {
                    CFG.core.loadSavedGame_NEW_9(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 10) {
                    CFG.core.loadSavedGame_NEW_10(iLoadID, this.tSplted);
                    nLoadSubStep = 0;
                    break block73;
                }
                if (loadStepID == 11) {
                    if (nLoadSubStep == 0) {
                        nLoadSubStep = 1;
                    }
                    int batchSize = 3;
                    int processed = 0;
                    while (nLoadSubStep < CFG.core.getCivsSize() && processed < batchSize) {
                        CFG.core.buildCivilizationRegions(nLoadSubStep);
                        nLoadSubStep++;
                        processed++;
                    }
                    if (nLoadSubStep >= CFG.core.getCivsSize()) {
                        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                            CFG.core.getCiv(i).civNeighbors.buildNeighbors(i);
                        }
                        nLoadSubStep = 0;
                        break block73;
                    }
                    pause = true;
                    return;
                }
                if (loadStepID == 12) {
                    if (nLoadSubStep == 0) {
                        CFG.core.loadProvinceTextures_BatchInit();
                        nLoadSubStep = 1;
                    }
                    int provinSize = CFG.core.getProvinSize();
                    if (nLoadSubStep >= 1 && nLoadSubStep <= provinSize) {
                        int start = nLoadSubStep - 1;
                        int batchSize = 500;
                        int end = Math.min(start + batchSize, provinSize);
                        CFG.core.loadProvinceTextures_Batch(start, end);
                        nLoadSubStep = end + 1;
                        if (end < provinSize) {
                            pause = true;
                            return;
                        }
                    }
                    if (nLoadSubStep == provinSize + 1) {
                        CFG.core.loadProvinceTextures_BatchFinalise();
                        CFG.core.buildWastelandLevels();
                        nLoadSubStep = provinSize + 2;
                        pause = true;
                        return;
                    }
                    if (nLoadSubStep >= provinSize + 2) {
                        int borderOffset = nLoadSubStep - (provinSize + 2);
                        int batchSize = 500;
                        int borderEnd = Math.min(borderOffset + batchSize, provinSize);
                        for (int i = borderOffset; i < borderEnd; ++i) {
                            CFG.core.getProv(i).updateProvinceBorder();
                        }
                        nLoadSubStep = provinSize + 2 + borderEnd;
                        if (borderEnd >= provinSize) {
                            nLoadSubStep = 0;
                            break block73;
                        }
                        pause = true;
                        return;
                    }
                    break block73;
                }
                if (loadStepID == 13) {
                    CFG.core.loadSavedGame_NEW_13(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 14) {
                    CFG.core.loadSavedGame_NEW_14(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 15) {
                    CFG.core.loadSavedGame_NEW_15(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 16) {
                    CFG.core.loadSavedGame_NEW_16(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 17) {
                    CFG.core.loadSavedGame_NEW_16_B(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 18) {
                    CFG.core.loadSavedGame_NEW_16_C(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 19) {
                    CFG.core.loadSavedGame_NEW_16_D(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 20) {
                    CFG.core.loadSavedGame_NEW_17(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 21) {
                    CFG.core.loadSavedGame_NEW_18(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 22) {
                    CFG.core.loadSavedGame_NEW_19(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 23) {
                    CFG.core.loadSavedGame_NEW_20(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 24) {
                    CFG.core.loadSavedGame_NEW_20_A(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 25) {
                    CFG.core.loadSavedGame_NEW_20_B(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 26) {
                    CFG.core.loadSavedGame_NEW_20_C(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 27) {
                    CFG.core.loadSavedGame_NEW_20_D(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 28) {
                    CFG.core.loadSavedGame_NEW_20_E(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 29) {
                    CFG.core.loadSavedGame_NEW_21(iLoadID, this.tSplted);
                    break block73;
                }
                if (loadStepID == 30) {
                    CFG.core.sortCivilizationsAZ();
                    NewGameManager.buildFormableCivilizations();
                    break block73;
                }
                if (loadStepID == 31) {
                    if (CFG.SPECTATOR_MODE) {
                        NewGameManager.newGame_InitPlayers_SpectatorMode();
                    } else {
                        int i;
                        for (i = 0; i < CFG.core.getCivsSize(); ++i) {
                            CFG.core.getCiv(i).setIsPlayer(false);
                        }
                        for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
                            CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).setIsPlayer(true);
                        }
                    }
                    break block73;
                }
                if (loadStepID == 32) {
                    CFG.oAI.updateExpand();
                    break block73;
                }
                if (loadStepID == 33) {
                    if (nLoadSubStep == 0) {
                        try {
                            CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getPlayer(0).getCivId()).getCapitalProvID());
                        }
                        catch (IndexOutOfBoundsException i) {}
                        nLoadSubStep = 1;
                    }
                    int batchSize = 15;
                    int processed = 0;
                    while (nLoadSubStep < CFG.core.getCivsSize() && processed < batchSize) {
                        CFG.core.getCiv(nLoadSubStep).updateNumberOfUnits();
                        nLoadSubStep++;
                        processed++;
                    }
                    if (nLoadSubStep >= CFG.core.getCivsSize()) {
                        nLoadSubStep = 0;
                        break block73;
                    }
                    pause = true;
                    return;
                }
                if (loadStepID == 34) {
                    CFG.map.getMpC().setDisableMovingMap(false);
                    if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID() >= 0) {
                        CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                    }
                    break block73;
                }
                if (loadStepID == 35) {
                    if (nLoadSubStep == 0) {
                        CFG.gameAction.updateCivsMovementPoints();
                        nLoadSubStep = 1;
                        pause = true;
                        return;
                    } else {
                        CFG.gameAction.updateIsSupplied();
                        nLoadSubStep = 0;
                        break block73;
                    }
                }
                if (loadStepID == 36) {
                    NewGameManager.build_ArmyInAnotherProvince();
                    try {
                        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                            CFG.core.getCiv(i).buildCivPersonality_NonSavable();
                        }
                        break block73;
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                        break block73;
                    }
                }
                if (loadStepID == 37) {
                    if (CFG.FOG_OF_WAR > 0) {
                        if (CFG.FOG_OF_WAR == 2) {
                            int i;
                            for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
                                CFG.PLAYER_TURN_ID = i;
                                CFG.gameAction.buildFogOfWar(i);
                            }
                            CFG.PLAYER_TURN_ID = 0;
                            for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                                CFG.core.getProv(i).updateProvinceBorder();
                            }
                            Render.updateDrawCivRegionNames_FogOfWar();
                        } else {
                            for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                                CFG.PLAYER_TURN_ID = i;
                                CFG.gameAction.buildFogOfWar(i);
                            }
                            CFG.PLAYER_TURN_ID = 0;
                        }
                    }
                    break block73;
                }
                if (loadStepID == 38) {
                    for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                        CFG.core.getProv(i).updateDrawArmyInProv();
                    }
                    CFG.gameAction.moveRegroupArmy();
                    break block73;
                }
                if (loadStepID == 39) {
                    CFG.gameAction.updateCivsHappiness_AllCivs();
                    CFG.gameUpdate.updateProvinceStabilityAllProvinces();
                    NewGameManager.updateBudgetSpendings();
                    CFG.gameUpdate.updateInflationPeakValueAllCivs();
                    CFG.gameUpdate.updatePlayableProvinces();
                    TechManager.updateAverageTechLevel();
                    break block73;
                }
                if (loadStepID == 40) {
                    if (CFG.SANDBOX_MODE && !CFG.SPECTATOR_MODE) {
                        NewGameManager.sandboxMode();
                    }
                    if (CFG.SANDBOX_MODE_AI) {
                        NewGameManager.sandboxMode_AI();
                    }
                    try {
                        if (!CFG.SPECTATOR_MODE) {
                            Menu_InGame_Tribute.updateVassalsSpendings();
                        }
                    }
                    catch (Exception i) {
                        // empty catch block
                    }
                    CFG.setActiveCivInfoId(0);
                    CFG.map.getMpB().disposeMinimapOfCivilizations();
                    SaveGameManager.gameCanBeContinued = true;
                    try {
                        Images.updateGold();
                    }
                    catch (Exception i) {}
                    break block73;
                }
                if (loadStepID == 41) {
                    RTS.reset();
                    CFG.core.disableDrawCivlizationsRegions_Players();
                    CFG.mapModesManager.disableAllViews();
                    if (CFG.map.getMpS().getCurrSc() < MapScale.STANDARD_SCALE) {
                        CFG.map.getMpS().setCurrScale(MapScale.STANDARD_SCALE);
                    }
                    CFG.EDITOR_ACTIVE_GAMEDATA_TAG = CFG.lang.get("SavedGame");
                    CFG.startTheGameData = new Start_The_Game_Data(false);
                    CFG.menus.setMenuIDWithoutAnim(View.eSTART_THE_GAME);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        ++loadStepID;
    }

    static {
        loadStepID = 0;
        loadStepID_TEXT = 0;
        tFileID = 0;
        tFileID2 = 0;
        pause = false;
    }
}

