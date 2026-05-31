
package age.of.civilizations2.jakowski.lukasz.Save;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_SaveTheGame;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameData.Save_GameData2;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameData.Save_GameData_1;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameData.Save_GameData_10;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameData.Save_GameData_11;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameData.Save_GameData_12;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameData.Save_GameData_2;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameData.Save_GameData_3;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameData.Save_GameData_4;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameData.Save_GameData_5;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameData.Save_GameData_6;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameData.Save_GameData_7;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameData.Save_GameData_8;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameData.Save_GameData_9;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import java.util.ArrayList;

public class SaveGameManager {
    public static int CIVS_PER_FILE = 3;
    public static int PROVINCES_PER_FILE = 150;
    public static boolean saveRequest = false;
    public static String saveTag;
    public static boolean gameCanBeContinued;
    public static int iTurnsSinceLastSave;
    public static boolean gameSaved;
    public static boolean forceShowNextPlayerTurnView;

    public static void newGame() {
        saveTag = null;
        iTurnsSinceLastSave = 0;
    }

    public static void trySaveGame() {
        if (SaveGameManager.gameWillBeSavedInThisTurn()) {
            forceShowNextPlayerTurnView = false;
            CFG.menus.setMenuIDWithoutAnim(View.eSAVE_THE_GAME);
        } else {
            forceShowNextPlayerTurnView = false;
        }
    }

    public static boolean gameWillBeSavedInNextTurn() {
        return CFG.settingsGD.TURNS_BETWEEN_AUTOSAVEX > 0 && CFG.settingsGD.TURNS_BETWEEN_AUTOSAVEX <= iTurnsSinceLastSave + 1 || saveRequest;
    }

    public static boolean gameWillBeSavedInThisTurn() {
        return CFG.settingsGD.TURNS_BETWEEN_AUTOSAVEX > 0 && CFG.settingsGD.TURNS_BETWEEN_AUTOSAVEX <= iTurnsSinceLastSave || saveRequest;
    }

    public static void saveGame_0() {
        try {
            CFG.toastM.addM(CFG.lang.get("Saving") + ".", CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            CFG.toastM.setTimeInView(4500);
            Menu_SaveTheGame.firstSaveOfTheGame = false;
            if (!CFG.SPECTATOR_MODE) {
                for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                    if (CFG.core.getPlayer(i).getCivId() <= 0) continue;
                    CFG.serviceRibbonMgr.saveStatistics_Civ(CFG.core.getPlayer((int)i).statsCiv);
                }
            }
            if (saveTag == null) {
                String pTag = "";
                try {
                    pTag = CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivTag());
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                saveTag = "" + System.currentTimeMillis() + pTag + CFG.extraRandomTagShort();
                Menu_SaveTheGame.firstSaveOfTheGame = true;
            }
            try {
                FileHandle file = CFG.readLocalFiles() ? Gdx.files.local("saves/games/" + CFG.map.getFileActiveMapPath() + "Age_of_Civilizations") : FileManager.loadFile("saves/games/" + CFG.map.getFileActiveMapPath() + "Age_of_Civilizations");
                String tempTags = file.readString();
                if (tempTags.indexOf(saveTag) < 0) {
                    FileHandle fileSave = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + "Age_of_Civilizations");
                    fileSave.writeString(tempTags + saveTag + ";", false);
                }
            }
            catch (Exception ex) {
                FileHandle fileSave = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + "Age_of_Civilizations");
                fileSave.writeString(saveTag + ";", false);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static void saveGame_1() {
        try {
            try {
                if (CFG.getIsDesktop()) {
                    if (FileManager.IS_MAC) {
                        FileHandle fileReadData2;
                        FileHandle fileReadData = Gdx.files.external("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag);
                        if (fileReadData.exists()) {
                            fileReadData.copyTo(Gdx.files.external("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_BACKUP"));
                        }
                        if ((fileReadData2 = Gdx.files.external("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + ".json")).exists()) {
                            fileReadData2.copyTo(Gdx.files.external("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + ".json_BACKUP"));
                        }
                    } else {
                        FileHandle fileReadData2;
                        FileHandle fileReadData = Gdx.files.local("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag);
                        if (fileReadData.exists()) {
                            fileReadData.copyTo(Gdx.files.local("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_BACKUP"));
                        }
                        if ((fileReadData2 = Gdx.files.local("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + ".json")).exists()) {
                            fileReadData2.copyTo(Gdx.files.local("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + ".json_BACKUP"));
                        }
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void saveGame_2() {
        try {
            Save_GameData_1 nSaveData = new Save_GameData_1();
            nSaveData.buildData();
            FileHandle file = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_1");
            file.writeBytes(CFG.serialize(nSaveData), false);
            nSaveData = null;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static final boolean saveGame_3(int tFileID) {
        try {
            int i = 1 + tFileID * CIVS_PER_FILE;
            while (i < CFG.core.getCivsSize()) {
                try {
                    Save_GameData_2 nSaveData = new Save_GameData_2();
                    nSaveData.buildData(i);
                    FileHandle file = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_2X" + (tFileID == 0 ? "" : "" + tFileID));
                    file.writeBytes(CFG.serialize(nSaveData), false);
                    nSaveData = null;
                    return true;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                    CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
                    CFG.toastM.setTimeInView(2500);
                    i += CIVS_PER_FILE;
                    ++tFileID;
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
        return false;
    }

    public static final void saveGame_4() {
        try {
            Save_GameData_3 nSaveData = new Save_GameData_3();
            nSaveData.buildData();
            FileHandle file = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_3");
            file.writeBytes(CFG.serialize(nSaveData), false);
            nSaveData = null;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static boolean saveGame_5(int tFileID) {
        try {
            int i = tFileID * PROVINCES_PER_FILE;
            while (i < CFG.core.getProvinSize()) {
                try {
                    Save_GameData_4 nSaveData = new Save_GameData_4();
                    nSaveData.buildData(i);
                    FileHandle file = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_4X" + (tFileID == 0 ? "" : "" + tFileID));
                    file.writeBytes(CFG.serialize(nSaveData), false);
                    nSaveData = null;
                    return true;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                    CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
                    CFG.toastM.setTimeInView(2500);
                    i += PROVINCES_PER_FILE;
                    ++tFileID;
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
        return false;
    }

    public static void saveGame_6() {
        try {
            Save_GameData_5 nSaveData = new Save_GameData_5();
            nSaveData.buildData();
            FileHandle file = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_5");
            file.writeBytes(CFG.serialize(nSaveData), false);
            nSaveData = null;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static void saveGame_7() {
        try {
            Save_GameData_6 nSaveData = new Save_GameData_6();
            nSaveData.buildData();
            FileHandle file = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_6");
            file.writeBytes(CFG.serialize(nSaveData), false);
            nSaveData = null;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static void saveGame_8() {
        try {
            Save_GameData_7 nSaveData = new Save_GameData_7();
            nSaveData.buildData();
            FileHandle file = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_7");
            file.writeBytes(CFG.serialize(nSaveData), false);
            nSaveData = null;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static void saveGame_9() {
        try {
            Save_GameData_8 nSaveData = new Save_GameData_8();
            nSaveData.buildData();
            FileHandle file = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_8");
            file.writeBytes(CFG.serialize(nSaveData), false);
            nSaveData = null;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static final void saveGame_10() {
        try {
            Save_GameData_9 nSaveData = new Save_GameData_9();
            nSaveData.buildData();
            FileHandle file = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_9");
            file.writeBytes(CFG.serialize(nSaveData), false);
            nSaveData = null;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static final void saveGame_10_B() {
        try {
            Save_GameData_12 nSaveData = new Save_GameData_12();
            nSaveData.buildData();
            FileHandle file = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_12");
            file.writeBytes(CFG.serialize(nSaveData), false);
            nSaveData = null;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static void saveGame_11() {
        try {
            Save_GameData_10 nSaveData = new Save_GameData_10();
            nSaveData.buildData();
            FileHandle file = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_10");
            file.writeBytes(CFG.serialize(nSaveData), false);
            nSaveData = null;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static void saveGame_12() {
        try {
            Save_GameData_11 nSaveData = new Save_GameData_11();
            nSaveData.buildData();
            FileHandle file = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_11");
            file.writeBytes(CFG.serialize(nSaveData), false);
            nSaveData = null;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static final void saveGame_13() {
        try {
            try {
                Save_GameData2 nSaveData2 = new Save_GameData2();
                nSaveData2.buildData();
                FileHandle file = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + "_2");
                file.writeBytes(CFG.serialize(nSaveData2), false);
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            SaveGameManager.saveSave_Info();
            if (Menu_SaveTheGame.firstSaveOfTheGame) {
                try {
                    FileHandle file3 = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + "TS/" + saveTag + "_O");
                    file3.writeBytes(CFG.serialize(CFG.timelapseManager.timelapseOwnersGameData), false);
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static void saveGame_14() {
        try {
            FileHandle file2 = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + "TS/" + saveTag + "_T");
            file2.writeBytes(CFG.serialize(CFG.timelapseManager.timelapseGameData), false);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static final void saveGame_15A() {
        try {
            FileHandle file3 = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + "TS/" + saveTag + "_HIS");
            file3.writeBytes(CFG.serialize(CFG.timelapseManager.timelapseStatsHistory), false);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static final void saveGame_15B() {
        FileHandle file3;
        try {
            file3 = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + "TS/" + saveTag + "_POP");
            file3.writeBytes(CFG.serialize(CFG.timelapseManager.timelapseStatsPopulation), false);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
        try {
            file3 = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + "TS/" + saveTag + "_ECO");
            file3.writeBytes(CFG.serialize(CFG.timelapseManager.timelapseStatsEconomy), false);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static final void saveGame_15C() {
        try {
            FileHandle file3 = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + "TS/" + saveTag + "_PROV");
            file3.writeBytes(CFG.serialize(CFG.timelapseManager.timelapseStatsProvinces), false);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static final void saveGame_15D() {
        try {
            FileHandle file3 = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + "TS/" + saveTag + "_RANK");
            file3.writeBytes(CFG.serialize(CFG.timelapseManager.timelapseStatsRank), false);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static final void saveGame_15E() {
        try {
            FileHandle file3 = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + "TS/" + saveTag + "_TECH");
            file3.writeBytes(CFG.serialize(CFG.timelapseManager.timelapseStatsTechnology), false);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static final void saveGame_15() {
        try {
            FileHandle file3 = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + "TS/" + saveTag + "_S");
            file3.writeBytes(CFG.serialize(CFG.timelapseManager.timelapseStatsGD), false);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static final void saveGame_15_1() {
        try {
            int turnSavesID = 0;
            try {
                FileHandle fileReadData3 = null;
                fileReadData3 = CFG.readLocalFiles() ? Gdx.files.local("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + "TS/" + "TURN/" + "Age_of_Civilizations") : FileManager.loadFile("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + "TS/" + "TURN/" + "Age_of_Civilizations");
                String tRead = fileReadData3.readString();
                turnSavesID = Integer.parseInt(tRead) + 1;
                FileHandle fileSave = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + "TS/" + "TURN/" + "Age_of_Civilizations");
                fileSave.writeString("" + turnSavesID, false);
            }
            catch (Exception ex) {
                FileHandle fileSave = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + "TS/" + "TURN/" + "Age_of_Civilizations");
                fileSave.writeString("" + turnSavesID, false);
            }
            try {
                FileHandle file4 = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + "TS/" + "TURN/" + saveTag + "_C" + "_" + turnSavesID);
                file4.writeBytes(CFG.serialize(CFG.timelapseManager.timelapseTurnChanges), false);
                CFG.timelapseManager.timelapseTurnChanges.lTurnChanges.clear();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    public static final void saveGame_16() {
        try {
            saveRequest = false;
            iTurnsSinceLastSave = 0;
            gameSaved = true;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.toastM.addM(CFG.lang.get("Error - Game not saved"), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(2500);
        }
    }

    private static final void saveSave_Info() {
        ConfigSaveInfo configData = new ConfigSaveInfo();
        configData.Age_of_Civilizations = "Data";
        ArrayList<Data_Save_Info> dataList = new ArrayList<Data_Save_Info>();
        dataList = new ArrayList();
        int tNumOfCivs = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            ++tNumOfCivs;
        }
        Data_Save_Info nDataTag = new Data_Save_Info();
        nDataTag.Civs = tNumOfCivs;
        nDataTag.GameDate = GameCalendar.getCurrDate();
        nDataTag.Turn = GameCalendar.TURNID;
        nDataTag.PLAYER_TAG = CFG.core.getCiv(CFG.core.getPlayer(0).getCivId()).getCivTag();
        dataList.add(nDataTag);
        configData.Data_Save_Info = dataList;
        Json jsonSave = new Json();
        jsonSave.setOutputType(JsonWriter.OutputType.json);
        jsonSave.setElementType(ConfigSaveInfo.class, "Data_Save_Info", Data_Save_Info.class);
        FileHandle fileSave = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + saveTag + "/" + saveTag + ".json");
        fileSave.writeString(jsonSave.prettyPrint(configData), false);
    }

    public static final void deleteSavedGame(int i) {
        FileHandle file2 = CFG.readLocalFiles() ? Gdx.files.local("saves/games/" + CFG.map.getFileActiveMapPath() + "Age_of_Civilizations") : FileManager.loadFile("saves/games/" + CFG.map.getFileActiveMapPath() + "Age_of_Civilizations");
        String tempTags = file2.readString();
        String[] tSplted = tempTags.split(";");
        if (i < tSplted.length) {
            try {
                try {
                    String dirPath = "saves/games/" + CFG.map.getFileActiveMapPath() + tSplted[i];
                    FileHandle dir = Gdx.files.local(dirPath);
                    if (dir.exists() && dir.isDirectory()) {
                        dir.deleteDirectory();
                    }
                }
                catch (Exception exrz) {
                    String dirPath = "saves/games/" + CFG.map.getFileActiveMapPath() + tSplted[i];
                    FileHandle dir = Gdx.files.external(dirPath);
                    if (dir.exists() && dir.isDirectory()) {
                        dir.deleteDirectory();
                    }
                }
            }
            catch (Exception exrz) {
                
            }
            String tempTagsNew = "";
            for (int j = 0; j < tSplted.length; ++j) {
                if (i == j) continue;
                tempTagsNew = tempTagsNew + tSplted[j] + ";";
            }
            if (tempTagsNew.length() > 0) {
                FileHandle fileSave = FileManager.getSaveType("saves/games/" + CFG.map.getFileActiveMapPath() + "Age_of_Civilizations");
                fileSave.writeString(tempTagsNew, false);
            } else {
                try {
                    Gdx.files.local("saves/games/" + CFG.map.getFileActiveMapPath() + "Age_of_Civilizations").delete();
                }
                catch (Exception ex) {
                    try {
                        Gdx.files.external("saves/games/" + CFG.map.getFileActiveMapPath() + "Age_of_Civilizations").delete();
                    }
                    catch (Exception exception) {
                        
                    }
                }
            }
        }
    }

    static {
        gameCanBeContinued = false;
        iTurnsSinceLastSave = 0;
        gameSaved = false;
        forceShowNextPlayerTurnView = false;
    }

    public static class ConfigSaveInfo {
        public String Age_of_Civilizations;
        public ArrayList Data_Save_Info;
    }

    public static class Data_Save_Info {
        public String PLAYER_TAG;
        public String GameDate;
        public int Turn;
        public int Civs;
    }
}

