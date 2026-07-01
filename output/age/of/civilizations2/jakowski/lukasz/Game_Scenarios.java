
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.Civilization_GameData3;
import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.EventsJ;
import age.of.civilizations2.jakowski.lukasz.Events_GameData;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MapA.CitiesManager;
import age.of.civilizations2.jakowski.lukasz.Menus.Menu_InitGame;
import age.of.civilizations2.jakowski.lukasz.Province;
import age.of.civilizations2.jakowski.lukasz.Province_Cores_GameData;
import age.of.civilizations2.jakowski.lukasz.Province_GameData_Occupied;
import age.of.civilizations2.jakowski.lukasz.Save.Save_Civ_GameData;
import age.of.civilizations2.jakowski.lukasz.Scenario_GameData;
import age.of.civilizations2.jakowski.lukasz.Scenario_GameData_Armies;
import age.of.civilizations2.jakowski.lukasz.Scenario_GameData_Diplomacy2;
import age.of.civilizations2.jakowski.lukasz.Scenario_GameData_Province2;
import age.of.civilizations2.jakowski.lukasz.Scenario_WastelandProvinces_GameData;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Game_Scenarios {
    public static int SCENARIOS_SIZE;
    public List<String> lScenarios_TagsList = new ArrayList<String>();
    public List<Boolean> isInternal = new ArrayList<Boolean>();
    private List<String> lScenarios_Names = new ArrayList<String>();
    private List<Integer> lScenarios_CivNum = new ArrayList<Integer>();
    private List<String> lScenarios_Authors = new ArrayList<String>();
    private List<Integer> lScenarios_Age = new ArrayList<Integer>();
    private List<Integer> lScenarios_Year = new ArrayList<Integer>();
    private List<Integer> lScenarios_Month = new ArrayList<Integer>();
    private List<Integer> lScenarios_Day = new ArrayList<Integer>();
    private List<String> lScenarios_Wikis = new ArrayList<String>();
    private long iScenario_StartingArmyInCapitals = 750L;
    private long iScenario_NeutralArmy = 150L;
    private long iScenario_StartingPopulation = 65000L;
    private long iScenario_StartingEconomy = 32000L;
    private long iScenario_StartingMoney = 1L;
    private float iScenario_PopulationGrowthRate_Modifier = 0.0f;
    private float iScenario_EconomyGrowthRate_Modifier = 0.0f;
    private float iScenario_DiseasesDeathRate_Modifier = 0.0f;
    private String sScenario_ActivePallet_TAG = null;
    public static String sActiveScenarioTag = "";
    public static Scenario_CustomJSON loadedCustomJSON = null;
    public static Scenario_CustomJSON.ProvinceData[] loadedCustomProvinceDataByID = null;
    public static Scenario_GameData_Province2 loadedCustomProvinceData = null;
    public static boolean loadedCustomUseCustomProvinceData = true;
    public static final float PERC_OF_POPULATION_REQUIRED_TO_GET_A_CORE = 0.18f;

    public static void logJavaHeap(String stage) {
        try {
            Runtime runtime = Runtime.getRuntime();
            long used = runtime.totalMemory() - runtime.freeMemory();
            CFG.LOG("[memory] " + stage + " used=" + used / 1048576L + "MB total=" + runtime.totalMemory() / 1048576L + "MB max=" + runtime.maxMemory() / 1048576L + "MB");
        }
        catch (Exception exception) {
        }
    }

    public static void releaseCustomScenarioJsonAfterDiplomacy() {
        if (loadedCustomJSON != null) {
            loadedCustomJSON = null;
            CFG.LOG("[customJSON] Released scenario parse tree after diplomacy/HRE");
            logJavaHeap("after custom JSON release");
        }
    }

    public static void releaseCustomProvinceJsonCache() {
        if (loadedCustomProvinceDataByID != null) {
            loadedCustomProvinceDataByID = null;
            CFG.LOG("[customJSON] Released province parse cache after armies");
            logJavaHeap("after custom province cache release");
        }
    }

    public int getScenarioIDbyTag(String tag) {
        for (int i = this.lScenarios_TagsList.size() - 1; i >= 0; --i) {
            if (!this.lScenarios_TagsList.get(i).equals(tag)) continue;
            return i;
        }
        return -1;
    }

    public final void loadGame_Scenarios(boolean initMap) {
        int i;
        int i2;
        int i3;
        FileHandle tempFileT;
        if (SCENARIOS_SIZE > 0 || this.lScenarios_TagsList.size() > 0) {
            this.disposeScenarios();
        }
        String defaultScenario = null;
        ArrayList<String> scenarioTags = new ArrayList<String>();
        if (CFG.getIsDesktop()) {
            if (FileManager.IS_MAC) {
                tempFileT = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + "Age_of_Civilizations");
                String tempT = tempFileT.readString();
                String[] tagsSPLITED = tempT.split(";");
                for (i3 = tagsSPLITED.length - 1; i3 >= 0; --i3) {
                    scenarioTags.add(tagsSPLITED[i3]);
                }
            } else {
                int i4;
                List<String> tempFiles = CFG.getFileNames_O_Classic("map/" + CFG.map.getFileActiveMapPath() + "scenarios/");
                if (tempFiles.isEmpty()) {
                    try {
                        for (FileHandle entry : Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/").list()) {
                            tempFiles.add(entry.name());
                        }
                    } catch (Exception ex2) {}
                }
                int iSize = tempFiles.size();
                for (i4 = 0; i4 < iSize; ++i4) {
                    if (!tempFiles.get(i4).equals("Age_of_Civilizations")) continue;
                    tempFiles.remove(i4);
                    break;
                }
                iSize = tempFiles.size();
                for (i4 = 0; i4 < iSize; ++i4) {
                    scenarioTags.add(tempFiles.get(i4));
                }
            }
        } else {
            tempFileT = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + "Age_of_Civilizations");
            String tempT = tempFileT.readString();
            String[] tagsSPLITED = tempT.split(";");
            for (int i5 = tagsSPLITED.length - 1; i5 >= 0; --i5) {
                if (scenarioTags.contains(tagsSPLITED[i5])) continue;
                scenarioTags.add(tagsSPLITED[i5]);
            }
            try {
                FileHandle tempFileT2 = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + "Age_of_Civilizations");
                String tempT2 = tempFileT2.readString();
                String[] tagsSPLITED2 = tempT2.split(";");
                for (int i6 = tagsSPLITED2.length - 1; i6 >= 0; --i6) {
                    if (scenarioTags.contains(tagsSPLITED2[i6])) continue;
                    scenarioTags.add(tagsSPLITED2[i6]);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        for (int a = 0; a < sUM.sUFS; ++a) {
            List<String> tempFiles = CFG.getFileNames_O(sUM.sUF.get(a) + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/");
            int iSize = tempFiles.size();
            for (int i7 = 0; i7 < iSize; ++i7) {
                if (scenarioTags.contains(tempFiles.get(i7))) continue;
                scenarioTags.add(tempFiles.get(i7));
            }
        }
        for (i2 = 0; i2 < sUM.sUFS; ++i2) {
            FileHandle[] files = FileManager.IS_MAC ? Gdx.files.external(sUM.sUF.get(i2) + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/").list() : Gdx.files.internal(sUM.sUF.get(i2) + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/").list();
            for (FileHandle file : files) {
                if (scenarioTags.contains(file.name())) continue;
                scenarioTags.add(file.name());
            }
        }
        for (int a = 0; a < sUM.sUIIS; ++a) {
            List<String> tempFiles = CFG.getFileNames_Absolute(sUM.sUII.get(a).getFolder() + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/");
            int iSize = tempFiles.size();
            for (i3 = 0; i3 < iSize; ++i3) {
                if (scenarioTags.contains(tempFiles.get(i3))) continue;
                scenarioTags.add(tempFiles.get(i3));
            }
        }
        for (i2 = 0; i2 < sUM.sUIIS; ++i2) {
            FileHandle[] files;
            for (FileHandle file : files = Gdx.files.absolute(sUM.sUII.get(i2).getFolder() + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/").list()) {
                if (scenarioTags.contains(file.name())) continue;
                scenarioTags.add(file.name());
            }
        }
        ArrayList<String> tempScenarios_TagsList = new ArrayList<String>();
        ArrayList<Boolean> tempIsInternal = new ArrayList<Boolean>();
        ArrayList<String> tempScenarios_Names = new ArrayList<String>();
        ArrayList<Integer> tempScenarios_CivNum = new ArrayList<Integer>();
        ArrayList<String> tempScenarios_Authors = new ArrayList<String>();
        ArrayList<Integer> tempScenarios_Age = new ArrayList<Integer>();
        ArrayList<Integer> tempScenarios_Year = new ArrayList<Integer>();
        ArrayList<Integer> tempScenarios_Month = new ArrayList<Integer>();
        ArrayList<Integer> tempScenarios_Day = new ArrayList<Integer>();
        ArrayList<String> tempScenarios_Wikis = new ArrayList<String>();
        int iSize = scenarioTags.size();
        for (i = 0; i < iSize; ++i) {
            if (((String)scenarioTags.get(i)).equals("Age_of_Civilizations")) continue;
            tempScenarios_TagsList.add((String)scenarioTags.get(i));
            tempIsInternal.add(true);
        }
        for (i = 0; i < tempScenarios_TagsList.size(); ++i) {
            try {
                CFG.ConfigScenarioInfo data = new CFG.ConfigScenarioInfo();
                Json json = new Json();
                json.setElementType(CFG.ConfigScenarioInfo.class, "Data_Scenario_Info", CFG.Data_Scenario_Info.class);
                com.badlogic.gdx.files.FileHandle infoFile = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + (String)tempScenarios_TagsList.get(i) + "/" + (String)tempScenarios_TagsList.get(i) + "_INFO" + ".json");
                if (!infoFile.exists()) {
                    tempScenarios_TagsList.remove(i);
                    tempIsInternal.remove(i);
                    --i;
                    continue;
                }
                data = json.fromJson(CFG.ConfigScenarioInfo.class, CFG.stripBOM(infoFile.readString("UTF-8")));
                Iterator iterator = data.Data_Scenario_Info.iterator();
                if (!iterator.hasNext()) {
                    tempScenarios_TagsList.remove(i);
                    tempIsInternal.remove(i);
                    --i;
                    continue;
                }
                Object e = iterator.next();
                CFG.Data_Scenario_Info tempData = (CFG.Data_Scenario_Info)e;
                tempScenarios_CivNum.add(tempData.Civs);
                tempScenarios_Names.add(tempData.Name);
                tempScenarios_Authors.add(tempData.Author);
                tempScenarios_Wikis.add(tempData.Wiki);
                tempScenarios_Age.add(tempData.Age);
                tempScenarios_Year.add(tempData.Year);
                tempScenarios_Month.add(tempData.Month);
                tempScenarios_Day.add(tempData.Day);
                continue;
            }
            catch (GdxRuntimeException ex) {
                if (CFG.LOGs) {
                    CFG.exceptionStack(ex);
                }
                tempScenarios_CivNum.add(0);
                tempScenarios_Names.add("ERROR");
                tempScenarios_Authors.add("ERROR");
                tempScenarios_Wikis.add("");
                tempScenarios_Age.add(0);
                tempScenarios_Year.add(0);
                tempScenarios_Month.add(0);
                tempScenarios_Day.add(0);
            }
        }
        if (CFG.readLocalFiles()) {
            try {
                int i8;
                FileHandle tempFileT2 = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + "Age_of_Civilizations");
                String tempT2 = tempFileT2.readString();
                String[] tagsSPLITED2 = tempT2.split(";");
                int nStart = tempScenarios_TagsList.size();
                int iSize2 = tagsSPLITED2.length;
                for (i8 = 0; i8 < iSize2; ++i8) {
                    if (tempScenarios_TagsList.contains(tagsSPLITED2[i8])) continue;
                    tempScenarios_TagsList.add(tagsSPLITED2[i8]);
                    tempIsInternal.add(false);
                }
                for (i8 = nStart; i8 < tempScenarios_TagsList.size(); ++i8) {
                    FileHandle file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + (String)tempScenarios_TagsList.get(i8) + "/" + (String)tempScenarios_TagsList.get(i8) + "_INFO" + ".json");
                    if (!file.exists()) {
                        tempScenarios_TagsList.remove(i8);
                        tempIsInternal.remove(i8);
                        --i8;
                        continue;
                    }
                    String fileContent = file.readString();
                    Json json = new Json();
                    json.setElementType(CFG.ConfigScenarioInfo.class, "Data_Scenario_Info", CFG.Data_Scenario_Info.class);
                    CFG.ConfigScenarioInfo data = new CFG.ConfigScenarioInfo();
                    data = json.fromJson(CFG.ConfigScenarioInfo.class, fileContent);
                    Iterator iterator = data.Data_Scenario_Info.iterator();
                    if (!iterator.hasNext()) {
                        tempScenarios_TagsList.remove(i8);
                        tempIsInternal.remove(i8);
                        --i8;
                        continue;
                    }
                    Object e = iterator.next();
                    CFG.Data_Scenario_Info tempData = (CFG.Data_Scenario_Info)e;
                    tempScenarios_CivNum.add(tempData.Civs);
                    tempScenarios_Names.add(tempData.Name);
                    tempScenarios_Authors.add(tempData.Author);
                    tempScenarios_Wikis.add(tempData.Wiki);
                    tempScenarios_Age.add(tempData.Age);
                    tempScenarios_Year.add(tempData.Year);
                    tempScenarios_Month.add(tempData.Month);
                    tempScenarios_Day.add(tempData.Day);
                }
            }
            catch (GdxRuntimeException tempFileT2) {
                
            }
        }
        if (CFG.core.getScenarioID() == -1) {
            defaultScenario = (String)tempScenarios_TagsList.get(0);
            CFG.core.setScenarioID(0);
        }
        while (tempScenarios_TagsList.size() > 0) {
            int nAdd = 0;
            for (int i9 = 1; i9 < tempScenarios_TagsList.size(); ++i9) {
                if ((Integer)tempScenarios_Year.get(nAdd) >= (Integer)tempScenarios_Year.get(i9)) continue;
                nAdd = i9;
            }
            this.lScenarios_TagsList.add((String)tempScenarios_TagsList.get(nAdd));
            tempScenarios_TagsList.remove(nAdd);
            this.isInternal.add((Boolean)tempIsInternal.get(nAdd));
            tempIsInternal.remove(nAdd);
            this.lScenarios_CivNum.add((Integer)tempScenarios_CivNum.get(nAdd));
            tempScenarios_CivNum.remove(nAdd);
            this.lScenarios_Names.add((String)tempScenarios_Names.get(nAdd));
            tempScenarios_Names.remove(nAdd);
            this.lScenarios_Authors.add((String)tempScenarios_Authors.get(nAdd));
            tempScenarios_Authors.remove(nAdd);
            this.lScenarios_Wikis.add((String)tempScenarios_Wikis.get(nAdd));
            tempScenarios_Wikis.remove(nAdd);
            this.lScenarios_Age.add((Integer)tempScenarios_Age.get(nAdd));
            tempScenarios_Age.remove(nAdd);
            this.lScenarios_Year.add((Integer)tempScenarios_Year.get(nAdd));
            tempScenarios_Year.remove(nAdd);
            this.lScenarios_Month.add((Integer)tempScenarios_Month.get(nAdd));
            tempScenarios_Month.remove(nAdd);
            this.lScenarios_Day.add((Integer)tempScenarios_Day.get(nAdd));
            tempScenarios_Day.remove(nAdd);
        }
        if (defaultScenario != null) {
            for (int i10 = 0; i10 < this.lScenarios_TagsList.size(); ++i10) {
                if (!defaultScenario.equals(this.lScenarios_TagsList.get(i10))) continue;
                CFG.core.setScenarioID(i10);
                break;
            }
        }
        SCENARIOS_SIZE = this.lScenarios_TagsList.size();
        if (initMap) {
            CFG.core.updateDaultScenarioID_ForMap();
        }
    }

    public final void disposeScenarios() {
        this.lScenarios_TagsList.clear();
        this.lScenarios_TagsList = new ArrayList<String>();
        this.lScenarios_Names.clear();
        this.lScenarios_Names = new ArrayList<String>();
        this.lScenarios_CivNum.clear();
        this.lScenarios_CivNum = new ArrayList<Integer>();
        this.lScenarios_Authors.clear();
        this.lScenarios_Authors = new ArrayList<String>();
        this.lScenarios_Wikis.clear();
        this.lScenarios_Wikis = new ArrayList<String>();
        this.lScenarios_Age.clear();
        this.lScenarios_Age = new ArrayList<Integer>();
        this.lScenarios_Year.clear();
        this.lScenarios_Year = new ArrayList<Integer>();
        this.lScenarios_Month.clear();
        this.lScenarios_Month = new ArrayList<Integer>();
        this.lScenarios_Day.clear();
        this.lScenarios_Day = new ArrayList<Integer>();
        this.isInternal.clear();
        this.isInternal = new ArrayList<Boolean>();
        SCENARIOS_SIZE = 0;
    }

    public final List<Civilization> loadCivilizations_RandomGame() {
        Random oR = new Random();
        ArrayList<Civilization> lCivs = new ArrayList<Civilization>();
        lCivs.add(CFG.core.getNeutralCivilization());
        ((Civilization)lCivs.get(0)).setCivId(0);
        ArrayList<String> lRandomGameCivsTags = new ArrayList<String>();
        if (CFG.RANDOM_PLACEMENT) {
            int nR;
            int i;
            FileHandle tempFileT = FileManager.loadFile("game/civilizations/Age_of_Civilizations");
            String tempT = tempFileT.readString();
            String[] tagsSPLITED = tempT.split(";");
            String[] tagsSPLITED_ED = new String[]{};
            try {
                FileHandle tempFileT_ED = null;
                tempFileT_ED = CFG.isAndroid() ? Gdx.files.local("game/civilizations_editor/Age_of_Civilizations") : FileManager.loadFile("game/civilizations_editor/Age_of_Civilizations");
                String tempT_ED = tempFileT_ED.readString();
                tagsSPLITED_ED = tempT_ED.split(";");
            }
            catch (GdxRuntimeException tempFileT_ED) {
                
            }
            ArrayList<String> nCivsTags = new ArrayList<String>();
            int iSize = tagsSPLITED.length;
            for (i = 0; i < iSize; ++i) {
                if (CFG.randomGameManager.isTagTaken(tagsSPLITED[i])) continue;
                nCivsTags.add(tagsSPLITED[i]);
            }
            iSize = tagsSPLITED_ED.length;
            for (i = 0; i < iSize; ++i) {
                if (CFG.randomGameManager.isTagTaken(tagsSPLITED_ED[i])) continue;
                nCivsTags.add(tagsSPLITED[i]);
            }
            for (i = 0; i < CFG.randomGameManager.getPlayersSize(); ++i) {
                if (CFG.randomGameManager.getPlayer(i).getTag() != null) {
                    lRandomGameCivsTags.add(CFG.randomGameManager.getPlayer(i).getTag());
                    continue;
                }
                nR = oR.nextInt(nCivsTags.size());
                lRandomGameCivsTags.add((String)nCivsTags.get(nR));
                nCivsTags.remove(nR);
            }
            try {
                nR = 0;
                for (i = 0; i < CFG.randomGameManager.getCivilizationsSize(); ++i) {
                    nR = oR.nextInt(nCivsTags.size());
                    lRandomGameCivsTags.add((String)nCivsTags.get(nR));
                    nCivsTags.remove(nR);
                }
            }
            catch (Exception i2) {
                
            }
            try {
                String tempTag = null;
                boolean add = true;
                int iSize2 = lRandomGameCivsTags.size();
                for (int i3 = 0; i3 < iSize2; ++i3) {
                    int j;
                    int nRandIdeology = oR.nextInt(CFG.ideologiesMgr.getIdeologiesSize());
                    int nNumOfTries = 0;
                    while ((CFG.ideologiesMgr.getIdeologyID((int)nRandIdeology).REVOLUTIONARY || CFG.ideologiesMgr.getIdeologyID((int)nRandIdeology).CAN_BECOME_CIVILIZED >= 0) && nNumOfTries++ < 8) {
                        nRandIdeology = oR.nextInt(CFG.ideologiesMgr.getIdeologiesSize());
                    }
                    add = true;
                    tempTag = CFG.ideologiesMgr.getRealTag((String)lRandomGameCivsTags.get(i3)) + CFG.ideologiesMgr.getIdeologyID(nRandIdeology).getExtraTag();
                    for (j = i3 + 1; j < iSize2; ++j) {
                        if (!tempTag.equals(lRandomGameCivsTags.get(j))) continue;
                        add = false;
                        break;
                    }
                    if (add) {
                        for (j = i3 - 1; j >= 0; --j) {
                            if (!tempTag.equals(lRandomGameCivsTags.get(j))) continue;
                            add = false;
                            break;
                        }
                        if (add) {
                            lRandomGameCivsTags.set(i3, tempTag);
                        }
                    }
                    Civilization_GameData3 civData = Core.loadCivilization((String)lRandomGameCivsTags.get(i3));
                    int tCapital = 0;
                    tCapital = i3 < CFG.randomGameManager.getPlayersSize() && CFG.randomGameManager.getPlayer(i3).getCapitalProvinceID() >= 0 ? CFG.randomGameManager.getPlayer(i3).getCapitalProvinceID() : -1;
                    lCivs.add(new Civilization((String)lRandomGameCivsTags.get(i3), civData.getR(), civData.getG(), civData.getB(), tCapital, i3 + 1, civData.iReligionID, civData.iGroupID, true));
                    ((Civilization)lCivs.get(i3 + 1)).setCivId(i3 + 1);
                    ((Civilization)lCivs.get(i3 + 1)).setTechLevel((float)(GameValues.gvInGame.RANDOM_GAME_TECHNOLOGY_MIN + Math.min(GameValues.gvInGame.RANDOM_GAME_TECHNOLOGY_PER_AGE * GameCalendar.CURRENT_AGEID, GameValues.gvInGame.RANDOM_GAME_TECHNOLOGY_PER_AGE_MAX) + oR.nextInt(GameValues.gvInGame.RANDOM_GAME_TECHNOLOGY_RANDOM)) / 100.0f);
                    ((Civilization)lCivs.get(i3 + 1)).setHappiness(68 + oR.nextInt(16));
                    if (tCapital >= 0) {
                        CFG.core.getProv(((Civilization)lCivs.get(i3 + 1)).getCapitalProvID()).setCivId_LoadScenario(i3 + 1);
                    }
                    ((Civilization)lCivs.get(i3 + 1)).setGold(CFG.core.getGameScenars().getScenario_StartingMoney());
                }
            }
            catch (Exception e) {
                CFG.exceptionStack(e);
            }
        } else {
            int i;
            int i4;
            FileHandle tempFileT = FileManager.loadFile("game/civilizations/Age_of_Civilizations");
            String tempT = tempFileT.readString();
            String[] tagsSPLITED = tempT.split(";");
            String[] tagsSPLITED_ED = new String[]{};
            try {
                FileHandle tempFileT_ED = null;
                tempFileT_ED = CFG.isAndroid() ? Gdx.files.local("game/civilizations_editor/Age_of_Civilizations") : FileManager.loadFile("game/civilizations_editor/Age_of_Civilizations");
                String tempT_ED = tempFileT_ED.readString();
                tagsSPLITED_ED = tempT_ED.split(";");
            }
            catch (GdxRuntimeException tempFileT_ED) {
                
            }
            ArrayList<String> nCivsTags = new ArrayList<String>();
            ArrayList<RandomGame_AoCMode> civsToAdd = new ArrayList<RandomGame_AoCMode>();
            int iSize = tagsSPLITED.length;
            for (i4 = 0; i4 < iSize; ++i4) {
                if (CFG.randomGameManager.isTagTaken(tagsSPLITED[i4])) continue;
                nCivsTags.add(tagsSPLITED[i4]);
            }
            iSize = tagsSPLITED_ED.length;
            for (i4 = 0; i4 < iSize; ++i4) {
                if (CFG.randomGameManager.isTagTaken(tagsSPLITED_ED[i4])) continue;
                nCivsTags.add(tagsSPLITED[i4]);
            }
            for (i4 = 0; i4 < CFG.randomGameManager.getPlayersSize(); ++i4) {
                if (CFG.randomGameManager.getPlayer(i4).getTag() != null) {
                    civsToAdd.add(new RandomGame_AoCMode(CFG.randomGameManager.getPlayer(i4).getTag(), CFG.randomGameManager.getPlayer(i4).getCapitalProvinceID()));
                    continue;
                }
                if (CFG.randomGameManager.getPlayer(i4).getCapitalProvinceID() < 0) continue;
                int nR = oR.nextInt(nCivsTags.size());
                civsToAdd.add(new RandomGame_AoCMode((String)nCivsTags.get(nR), CFG.randomGameManager.getPlayer(i4).getCapitalProvinceID()));
                nCivsTags.remove(nR);
            }
            for (int o = 0; o < civsToAdd.size(); ++o) {
                try {
                    Civilization_GameData3 civData = Core.loadCivilization(((RandomGame_AoCMode)civsToAdd.get((int)o)).sTag);
                    int tCapital = ((RandomGame_AoCMode)civsToAdd.get((int)o)).iCapitalID;
                    lCivs.add(new Civilization(((RandomGame_AoCMode)civsToAdd.get((int)o)).sTag, civData.getR(), civData.getG(), civData.getB(), tCapital, o + 1, civData.iReligionID, civData.iGroupID, true));
                    ((Civilization)lCivs.get(o + 1)).setCivId(o + 1);
                    ((Civilization)lCivs.get(o + 1)).setTechLevel((float)(20 + Math.min(5 * GameCalendar.CURRENT_AGEID, 25) + oR.nextInt(10)) / 100.0f);
                    ((Civilization)lCivs.get(o + 1)).setHappiness(68 + oR.nextInt(16));
                    if (tCapital >= 0) {
                        CFG.core.getProv(((Civilization)lCivs.get(o + 1)).getCapitalProvID()).setCivId_LoadScenario(o + 1);
                    }
                    ((Civilization)lCivs.get(o + 1)).setGold(CFG.core.getGameScenars().getScenario_StartingMoney());
                    continue;
                }
                catch (Exception civData) {
                    
                }
            }
            ArrayList<Integer> lPossibleCapitals = new ArrayList<Integer>();
            for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getSeaProv()) continue;
                CFG.core.getProv(i).setIsCapital(false);
            }
            for (i = 0; i < CFG.randomGameManager.getPlayersSize(); ++i) {
                if (CFG.randomGameManager.getPlayer(i).getCapitalProvinceID() < 0) continue;
                CFG.core.getProv(CFG.randomGameManager.getPlayer(i).getCapitalProvinceID()).setIsCapital(true);
            }
            for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.core.getProv(i).isCapital()) continue;
                try {
                    if (!FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "suggested_owners/" + i).exists()) continue;
                    lPossibleCapitals.add(i);
                    continue;
                }
                catch (GdxRuntimeException ex) {
                    
                }
            }
            if (lPossibleCapitals.size() < 100) {
                for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                    if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.core.getProv(i).isCapital() || lPossibleCapitals.contains(i)) continue;
                    lPossibleCapitals.add(i);
                }
            }
            try {
                int extraToAddForPlayers = civsToAdd.size() - CFG.randomGameManager.getPlayersSize();
                block36: for (int i5 = 0; i5 < CFG.randomGameManager.getCivilizationsSize() + extraToAddForPlayers && !lPossibleCapitals.isEmpty(); ++i5) {
                    try {
                        int tempCapitalID = 0;
                        int iNumOfItterations = 0;
                        while (true) {
                            int tRandID = CFG.oR.nextInt(lPossibleCapitals.size());
                            tempCapitalID = (Integer)lPossibleCapitals.get(tRandID);
                            ++iNumOfItterations;
                            if (!CFG.core.getProv(tempCapitalID).isCapital()) {
                                boolean found = true;
                                for (int o = 0; o < CFG.core.getProv(tempCapitalID).getNeighProvincesSize(); ++o) {
                                    if (!CFG.core.getProv(CFG.core.getProv(tempCapitalID).getNeighProvinces(o)).getIsCapital_Just()) continue;
                                    found = false;
                                    break;
                                }
                                if (!found && iNumOfItterations <= 18) continue;
                                found = false;
                                ArrayList<String> lPossibleCapitals_Tags = new ArrayList<String>();
                                try {
                                    int j;
                                    FileHandle file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "suggested_owners/" + lPossibleCapitals.get(tRandID));
                                    String sOwners = file.readString();
                                    String[] sRes = sOwners.split(";");
                                    for (j = 0; j < sRes.length; j += 2) {
                                        int nIdeology = CFG.ideologiesMgr.getIdeologyID(sRes[j]);
                                        if (CFG.ideologiesMgr.getIdeologyID((int)nIdeology).CAN_BECOME_CIVILIZED >= 0) {
                                            lPossibleCapitals_Tags.add(CFG.ideologiesMgr.getRealTag(sRes[j]));
                                            continue;
                                        }
                                        lPossibleCapitals_Tags.add(sRes[j]);
                                    }
                                    block40: for (j = lPossibleCapitals_Tags.size() - 1; j >= 0; --j) {
                                        for (int k = civsToAdd.size() - 1; k >= 0; --k) {
                                            if (!((RandomGame_AoCMode)civsToAdd.get((int)k)).sTag.equals(lPossibleCapitals_Tags.get(j))) continue;
                                            lPossibleCapitals_Tags.remove(j);
                                            continue block40;
                                        }
                                    }
                                    if (lPossibleCapitals_Tags.size() == 0) {
                                        lPossibleCapitals.remove(tRandID);
                                        continue;
                                    }
                                    found = true;
                                }
                                catch (GdxRuntimeException ex) {
                                    lPossibleCapitals.remove(tRandID);
                                    continue;
                                }
                                if (!found) continue block36;
                                try {
                                    int nTagIDToAdd = CFG.oR.nextInt(lPossibleCapitals_Tags.size());
                                    Civilization_GameData3 civData = Core.loadCivilization((String)lPossibleCapitals_Tags.get(nTagIDToAdd));
                                    int tCapital = (Integer)lPossibleCapitals.get(tRandID);
                                    civsToAdd.add(new RandomGame_AoCMode((String)lPossibleCapitals_Tags.get(nTagIDToAdd), tCapital));
                                    int tCivID = lCivs.size();
                                    lCivs.add(new Civilization((String)lPossibleCapitals_Tags.get(nTagIDToAdd), civData.getR(), civData.getG(), civData.getB(), tCapital, tCivID, civData.iReligionID, civData.iGroupID, true));
                                    ((Civilization)lCivs.get(tCivID)).setCivId(tCivID);
                                    ((Civilization)lCivs.get(tCivID)).setTechLevel((float)(GameValues.gvInGame.RANDOM_GAME_TECHNOLOGY_MIN + Math.min(GameValues.gvInGame.RANDOM_GAME_TECHNOLOGY_PER_AGE * GameCalendar.CURRENT_AGEID, GameValues.gvInGame.RANDOM_GAME_TECHNOLOGY_PER_AGE_MAX) + oR.nextInt(GameValues.gvInGame.RANDOM_GAME_TECHNOLOGY_RANDOM)) / 100.0f);
                                    ((Civilization)lCivs.get(tCivID)).setHappiness(68 + oR.nextInt(16));
                                    if (tCapital >= 0) {
                                        CFG.core.getProv(((Civilization)lCivs.get(tCivID)).getCapitalProvID()).setCivId_LoadScenario(tCivID);
                                        CFG.core.getProv(tCapital).setIsCapital(true);
                                    }
                                    ((Civilization)lCivs.get(tCivID)).setGold(CFG.core.getGameScenars().getScenario_StartingMoney());
                                    lPossibleCapitals.remove(tRandID);
                                    continue block36;
                                }
                                catch (Exception e) {
                                    lPossibleCapitals.remove(tRandID);
                                    continue;
                                }
                            }
                            lPossibleCapitals.remove(tRandID);
                        }
                    }
                    catch (StackOverflowError ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return lCivs;
    }

    public final List<Civilization> loadCivilizationsLoadGame(List<Save_Civ_GameData> nCivsData, int startCivID) {
        GameCalendar.updateAge(false);
        ArrayList<Civilization> lCivs = new ArrayList<Civilization>();
        if (startCivID == 0) {
            lCivs.add(CFG.core.getNeutralCivilization());
            ((Civilization)lCivs.get(0)).setCivId(0);
        }
        for (int i = 0; i < nCivsData.size(); ++i) {
            lCivs.add(new Civilization(nCivsData.get(i), startCivID + i + (startCivID == 0 ? 1 : 0)));
        }
        CFG.map.getMpB().disposeMinimapOfCivilizations();
        return lCivs;
    }

    public final List<Civilization> loadCivilizations(boolean nEditor) {
        loadedCustomJSON = null;
        loadedCustomProvinceDataByID = null;
        loadedCustomProvinceData = null;
        loadedCustomUseCustomProvinceData = true;
        logJavaHeap("before loadCivilizations");
        FileHandle fileProvince;
        FileHandle file;
        CFG.FILL_THE_MAP = true;
        GameCalendar.CURRENT_AGEID = this.getScenarioAgeID(CFG.core.getScenarioID());
        ArrayList<Civilization> lCivs = new ArrayList<Civilization>();
        lCivs.add(CFG.core.getNeutralCivilization());
        ((Civilization)lCivs.get(0)).setCivId(0);
        if (this.isInternal.get(CFG.core.getScenarioID()).booleanValue()) {
            file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()));
            fileProvince = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_PD");
        } else {
            try {
                file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()));
                fileProvince = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_PD");
            }
            catch (Exception ex) {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()));
                fileProvince = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_PD");
            }
        }
        try {
            Json json = new Json();
            json.setIgnoreUnknownFields(true);
            int i;
            Scenario_GameData tempScenarioGameData = null;
            boolean customJsonControlsProvinceData = false;
            FileHandle jsonFileWrite = Gdx.files.local(file.path() + ".json");
            FileHandle jsonFile = jsonFileWrite.exists() ? jsonFileWrite : FileManager.loadFile(file.path().replace("output/", "") + ".json");
            
            CFG.LOG("[loadCivilizations] nEditor=" + nEditor + " scenarioID=" + CFG.core.getScenarioID() + " tag=" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()));
            
            
            String tagID = this.lScenarios_TagsList.get(CFG.core.getScenarioID());
            String customPath = "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tagID + "/" + tagID + "_CUSTOM.json";
            FileHandle customFileWrite = Gdx.files.local(customPath);
            FileHandle customFile = customFileWrite.exists() ? customFileWrite : FileManager.loadFile(customPath.replace("output/", ""));
            CFG.LOG("[loadCivilizations] customPath=" + customPath + " exists=" + customFile.exists() + " absPath=" + customFile.file().getAbsolutePath());
            if (customFile.exists()) {
                try {
                    Scenario_CustomJSON customData = json.fromJson(Scenario_CustomJSON.class, customFile.reader("UTF-8"));
                    if (customData != null) {
                        loadedCustomJSON = customData;
                        if (customData.civilizations == null) customData.civilizations = new ArrayList<Scenario_CustomJSON.CivilizationData>();
                        if (customData.unownedProvinces == null) customData.unownedProvinces = new ArrayList<Scenario_CustomJSON.ProvinceData>();
                        loadedCustomUseCustomProvinceData = customData.info != null && customData.info.useCustomProvinceData != null ? customData.info.useCustomProvinceData.booleanValue() : (customData.useCustomProvinceData != null ? customData.useCustomProvinceData.booleanValue() : true);
                        customJsonControlsProvinceData = !loadedCustomUseCustomProvinceData;
                        CFG.LOG("[loadCivilizations] Custom JSON loaded successfully civs=" + customData.civilizations.size());
                        tempScenarioGameData = new Scenario_GameData();
                        if (customData.info != null) {
                            tempScenarioGameData.setStartingPopulation(customData.info.startingPopulation != null ? customData.info.startingPopulation : 0L);
                            tempScenarioGameData.setStartingEconomy(customData.info.startingEconomy != null ? customData.info.startingEconomy : 0L);
                            tempScenarioGameData.setStartingMoney(customData.info.startingMoney != null ? customData.info.startingMoney : 0L);
                            tempScenarioGameData.setStartingArmyInCapitals(customData.info.startingArmyInCapitals != null ? customData.info.startingArmyInCapitals : 0L);
                            tempScenarioGameData.setNeutralArmy(customData.info.neutralArmy != null ? customData.info.neutralArmy : 0L);
                            tempScenarioGameData.iPopulationGrowthRate_Modifier = customData.info.populationGrowthRate_Modifier != null ? customData.info.populationGrowthRate_Modifier : 0.0f;
                            tempScenarioGameData.iEconomyGrowthRate_Modifier = customData.info.economyGrowthRate_Modifier != null ? customData.info.economyGrowthRate_Modifier : 0.0f;
                            tempScenarioGameData.iDiseasesDeathRate_Modifier = customData.info.diseasesDeathRate_Modifier != null ? customData.info.diseasesDeathRate_Modifier : 0.0f;
                            tempScenarioGameData.COLONIZATION = customData.info.colonization != null ? customData.info.colonization : true;
                            tempScenarioGameData.ENABLE_COLONIZATION_NEUTRAL_PROVINCES = customData.info.colonizationNeutralProvinces != null ? customData.info.colonizationNeutralProvinces : false;
                            tempScenarioGameData.COLONIZATION_TECH_LEVEL = customData.info.colonizationTechLevel != null ? customData.info.colonizationTechLevel : 0.8f;
                            tempScenarioGameData.ACTIVE_PALLET_OF_COLORS_TAG = customData.info.activePalletTag;
                        }
                        
                        for (Scenario_CustomJSON.CivilizationData c : customData.civilizations) {
                            tempScenarioGameData.lCivsTags.add(c.tag);
                            tempScenarioGameData.lCivsCapitals.add(c.capitalID != null ? c.capitalID : -1);
                            tempScenarioGameData.lTechnologyLevels.add(c.technologyLevel != null ? c.technologyLevel : 0.0f);
                            tempScenarioGameData.lHappiness.add(c.happiness != null ? c.happiness : 50);
                            tempScenarioGameData.lStartingMoney.add(c.gold != null ? c.gold : -999999L);
                            tempScenarioGameData.lTargetPopulation.add(c.setpop != null ? c.setpop : -1L);
                            tempScenarioGameData.lTargetEconomy.add(c.seteco != null ? c.seteco : -1L);
                            
                            List<Scenario_GameData_Technology> tList = new ArrayList<Scenario_GameData_Technology>();
                            if (c.techByContinents != null) {
                                for (Scenario_CustomJSON.TechByContinentData t : c.techByContinents) {
                                    tList.add(new Scenario_GameData_Technology(t.continentID, t.percentage));
                                }
                            }
                            tempScenarioGameData.lTechnologyByContinents.add(tList);
                        }
                        
                        if (loadedCustomUseCustomProvinceData) {
                            int naturalProvinceCount = 0;
                            int fixedProvinceCount = 0;
                            
                            loadedCustomProvinceData = new Scenario_GameData_Province2();
                            loadedCustomProvinceData.lProvinceOwners = new ArrayList<Integer>();
                            loadedCustomProvinceData.lProvincePopulation = new ArrayList<Long>();
                            loadedCustomProvinceData.lProvinceEconomy = new ArrayList<Long>();
                            loadedCustomProvinceData.lProvinceNatural = new ArrayList<Boolean>();
                            loadedCustomProvinceDataByID = new Scenario_CustomJSON.ProvinceData[CFG.core.getProvinSize()];
                            for (int p = 0; p < CFG.core.getProvinSize(); p++) {
                                loadedCustomProvinceData.lProvinceOwners.add(0);
                                loadedCustomProvinceData.lProvincePopulation.add(0L);
                                loadedCustomProvinceData.lProvinceEconomy.add(0L);
                                loadedCustomProvinceData.lProvinceNatural.add(Boolean.TRUE);
                            }
                            
                            for (int iCiv = 0; iCiv < customData.civilizations.size(); iCiv++) {
                                Scenario_CustomJSON.CivilizationData c = customData.civilizations.get(iCiv);
                                if (c.provinces == null) continue;
                                for (Scenario_CustomJSON.ProvinceData p : c.provinces) {
                                    if (p.id != null && p.id >= 0 && p.id < CFG.core.getProvinSize()) {
                                        boolean natural = Boolean.TRUE.equals(p.natural);
                                        loadedCustomProvinceData.lProvinceOwners.set(p.id, iCiv + 1);
                                        loadedCustomProvinceData.lProvincePopulation.set(p.id, p.population != null ? p.population : 0L);
                                        loadedCustomProvinceData.lProvinceEconomy.set(p.id, p.economy != null ? p.economy : 0L);
                                        loadedCustomProvinceData.lProvinceNatural.set(p.id, natural);
                                        loadedCustomProvinceDataByID[p.id] = p;
                                        if (natural) ++naturalProvinceCount; else ++fixedProvinceCount;
                                    }
                                }
                            }
                            for (Scenario_CustomJSON.ProvinceData p : customData.unownedProvinces) {
                                if (p.id != null && p.id >= 0 && p.id < CFG.core.getProvinSize()) {
                                    boolean natural = Boolean.TRUE.equals(p.natural);
                                    loadedCustomProvinceData.lProvinceOwners.set(p.id, 0);
                                    loadedCustomProvinceData.lProvincePopulation.set(p.id, p.population != null ? p.population : 0L);
                                    loadedCustomProvinceData.lProvinceEconomy.set(p.id, p.economy != null ? p.economy : 0L);
                                    loadedCustomProvinceData.lProvinceNatural.set(p.id, natural);
                                    loadedCustomProvinceDataByID[p.id] = p;
                                    if (natural) ++naturalProvinceCount; else ++fixedProvinceCount;
                                }
                            }
                            CFG.LOG("[loadCivilizations] Custom province data enabled fixed=" + fixedProvinceCount + " natural=" + naturalProvinceCount);
                        } else {
                            CFG.LOG("[loadCivilizations] Custom province data disabled by JSON flag");
                        }
                    }
                    logJavaHeap("after custom JSON parse");
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            } else {
                CFG.LOG("[loadCivilizations] Custom JSON NOT FOUND at " + customPath);
            }
            
            
            CFG.LOG("[loadCivilizations] tempScenarioGameData=" + tempScenarioGameData + " jsonFile.exists=" + jsonFile.exists() + " jsonPath=" + jsonFile.path());
            if (tempScenarioGameData == null && jsonFile.exists()) {
                try {
                    tempScenarioGameData = json.fromJson(Scenario_GameData.class, CFG.stripBOM_JSON(jsonFile.readString("UTF-8")));
                    CFG.LOG("[loadCivilizations] Standard JSON loaded result=" + (tempScenarioGameData != null));
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            
            
            CFG.LOG("[loadCivilizations] after JSON tempScenarioGameData=" + tempScenarioGameData + " file.exists=" + file.exists() + " filePath=" + file.path());
            if (tempScenarioGameData == null && file.exists()) {
                try {
                    tempScenarioGameData = (Scenario_GameData)CFG.deserialize(file.readBytes());
                    CFG.LOG("[loadCivilizations] Binary modern loaded result=" + (tempScenarioGameData != null));
                } catch (Exception ex) {
                    try {
                        Scenario_GameData_Legacy legacy = (Scenario_GameData_Legacy)CFG.deserializeLegacyScenario(file.readBytes());
                        tempScenarioGameData = legacy.convertToNew();
                        CFG.LOG("[loadCivilizations] Binary legacy loaded result=" + (tempScenarioGameData != null));
                    } catch (Exception ex2) {
                        CFG.exceptionStack(ex2);
                    }
                }
                if (tempScenarioGameData != null) {
                    try {
                        jsonFileWrite.writeString(json.prettyPrint(tempScenarioGameData), false, "UTF-8");
                    } catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            }
            CFG.LOG("[loadCivilizations] FINAL result=" + (tempScenarioGameData != null) + " startingPop=" + (tempScenarioGameData != null ? tempScenarioGameData.getStartingPopulation() : -1) + " useCustomProvinceData=" + loadedCustomUseCustomProvinceData + " loadedCustomProvinceData=" + (loadedCustomProvinceData != null));

            if (tempScenarioGameData == null) {
                tempScenarioGameData = new Scenario_GameData();
            }
            this.setScenarioStartingArmyInCapitals(tempScenarioGameData.getStartingArmyInCapitals());
            this.setScenario_NeutralArmy(tempScenarioGameData.getNeutralArmy());
            this.setScenarioStartingPopulation(tempScenarioGameData.getStartingPopulation());
            this.setScenarioStartingEconomy(tempScenarioGameData.getStartingEconomy());
            this.setScenarioStartingMoney(tempScenarioGameData.getStartingMoney());
            this.setScenario_PopulationGrowthRate_Modifier(tempScenarioGameData.getPopulationGrowthRate_Modifier());
            this.setScenario_EconomyGrowthRate_Modifier(tempScenarioGameData.getEconomyGrowthRate_Modifier());
            this.setScenario_DiseasesDeathRate_Modifier(tempScenarioGameData.getDiseasesDeathRate_Modifier());
            this.setScenarioActivePallet_TAG(tempScenarioGameData.getActivePalletOfColors_TAG());
            GameCalendar.ENABLE_COLONIZATION = tempScenarioGameData.getColonization();
            GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES = tempScenarioGameData.ENABLE_COLONIZATION_NEUTRAL_PROVINCES;
            GameCalendar.COLONIZATION_TECH_LEVEL = tempScenarioGameData.COLONIZATION_TECH_LEVEL;
            for (i = 0; i < tempScenarioGameData.getCivSize(); ++i) {
                Civilization_GameData3 civData = Core.loadCivilization(tempScenarioGameData.getCivTag(i));
                lCivs.add(new Civilization(tempScenarioGameData.getCivTag(i), civData.getR(), civData.getG(), civData.getB(), tempScenarioGameData.getCivCapital(i), i + 1, civData.iReligionID, civData.iGroupID, false));
                ((Civilization)lCivs.get(i + 1)).civGD.sCivDescription = civData.getDescription();
                ((Civilization)lCivs.get(i + 1)).setCivId(i + 1);
                ((Civilization)lCivs.get(i + 1)).setTechLevel(tempScenarioGameData.getTechnologyLevel(i));
                ((Civilization)lCivs.get(i + 1)).setHappiness(tempScenarioGameData.getHappiness(i));
                if (loadedCustomJSON != null && loadedCustomJSON.civilizations != null && i < loadedCustomJSON.civilizations.size()) {
                    Scenario_CustomJSON.CivilizationData customCiv = loadedCustomJSON.civilizations.get(i);
                    if (customCiv.ideologyID != null) ((Civilization)lCivs.get(i + 1)).setIdeology(customCiv.ideologyID);
                    if (customCiv.religionID != null) ((Civilization)lCivs.get(i + 1)).setReligionID(customCiv.religionID);
                    if (customCiv.groupID != null) ((Civilization)lCivs.get(i + 1)).setGroupID(customCiv.groupID);
                    if (customCiv.isPlayer != null) ((Civilization)lCivs.get(i + 1)).setIsPlayer(customCiv.isPlayer);
                    if (customCiv.description != null) ((Civilization)lCivs.get(i + 1)).civGD.sCivDescription = customCiv.description;
                    if (customCiv.missiles != null) ((Civilization)lCivs.get(i + 1)).civGD.iMissiles = customCiv.missiles;
                    if (customCiv.technologyPoints != null) {
                        if (customCiv.technologyPoints.popGrowth != null) ((Civilization)lCivs.get(i + 1)).civGD.techPoints.POINTS_POP_GROWTH = customCiv.technologyPoints.popGrowth;
                        if (customCiv.technologyPoints.economyGrowth != null) ((Civilization)lCivs.get(i + 1)).civGD.techPoints.POINTS_ECONOMY_GROWTH = customCiv.technologyPoints.economyGrowth;
                        if (customCiv.technologyPoints.taxation != null) ((Civilization)lCivs.get(i + 1)).civGD.techPoints.POINTS_INCOME_TAXATION = customCiv.technologyPoints.taxation;
                        if (customCiv.technologyPoints.production != null) ((Civilization)lCivs.get(i + 1)).civGD.techPoints.POINTS_INCOME_PRODUCTION = customCiv.technologyPoints.production;
                        if (customCiv.technologyPoints.administration != null) ((Civilization)lCivs.get(i + 1)).civGD.techPoints.POINTS_ADMINISTRATION = customCiv.technologyPoints.administration;
                        if (customCiv.technologyPoints.militaryUpkeep != null) ((Civilization)lCivs.get(i + 1)).civGD.techPoints.POINTS_MILITARY_UPKEEP = customCiv.technologyPoints.militaryUpkeep;
                        if (customCiv.technologyPoints.research != null) ((Civilization)lCivs.get(i + 1)).civGD.techPoints.POINTS_RESEARCH = customCiv.technologyPoints.research;
                        if (customCiv.technologyPoints.colonization != null) ((Civilization)lCivs.get(i + 1)).civGD.techPoints.POINTS_COLONIZATION = customCiv.technologyPoints.colonization;
                        if (customCiv.technologyPoints.movement != null) ((Civilization)lCivs.get(i + 1)).civGD.techPoints.POINTS_MOVEMENT = customCiv.technologyPoints.movement;
                        if (customCiv.technologyPoints.assimilate != null) ((Civilization)lCivs.get(i + 1)).civGD.techPoints.POINTS_ASSIMILATE = customCiv.technologyPoints.assimilate;
                        if (customCiv.technologyPoints.recruitable != null) ((Civilization)lCivs.get(i + 1)).civGD.techPoints.POINTS_RECRUITABLE = customCiv.technologyPoints.recruitable;
                    }
                }
                long nStartingGold = tempScenarioGameData.getStartingMoney();
                if (tempScenarioGameData.getStartingMoneyCiv(i) != -999999) {
                    nStartingGold = tempScenarioGameData.getStartingMoneyCiv(i);
                }
                if (nStartingGold < 1) {
                    nStartingGold = 1;
                }
                ((Civilization)lCivs.get(i + 1)).setGold(nStartingGold);
                if (((Civilization)lCivs.get(i + 1)).getCapitalProvID() < 0) continue;
                CFG.core.getProv(((Civilization)lCivs.get(i + 1)).getCapitalProvID()).setCivId_LoadScenario(i + 1);
                if (tempScenarioGameData.getTargetPopulationCivSize() > i) {
                    ((Civilization)lCivs.get(i + 1)).civGD.targetPopulation = tempScenarioGameData.getTargetPopulationCiv(i);
                }
                if (tempScenarioGameData.getTargetEconomyCivSize() > i) {
                    ((Civilization)lCivs.get(i + 1)).civGD.targetEconomy = tempScenarioGameData.getTargetEconomyCiv(i);
                }
            }
            CFG.initCreateScenario_TechnologyLevelsByContinents_Civ();
            for (i = 0; i < tempScenarioGameData.getCivSize(); ++i) {
                CFG.addCreateScenario_TechnologyLevelsByContinents_Civ(tempScenarioGameData.getTechnologyByContinents(i));
            }
            tempScenarioGameData = null;

            FileHandle jsonFilePDWrite = Gdx.files.local(fileProvince.path() + ".json");
            if (loadedCustomProvinceData == null && !customJsonControlsProvinceData) {
                FileHandle jsonFilePD = jsonFilePDWrite.exists() ? jsonFilePDWrite : FileManager.loadFile(fileProvince.path().replace("output/", "") + ".json");
                if (jsonFilePD.exists()) {
                    try {
                        loadedCustomProvinceData = json.fromJson(Scenario_GameData_Province2.class, CFG.stripBOM_JSON(jsonFilePD.readString("UTF-8")));
                        if (loadedCustomProvinceData != null && loadedCustomProvinceData.lProvincePopulation == null) {
                            loadedCustomProvinceData = null;
                        }
                    } catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            }
            if (loadedCustomProvinceData == null && !customJsonControlsProvinceData && fileProvince.exists()) {
                loadedCustomProvinceData = (Scenario_GameData_Province2)CFG.deserialize(fileProvince.readBytes());
                try {
                    jsonFilePDWrite.writeString(json.prettyPrint(loadedCustomProvinceData), false, "UTF-8");
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }

            if (loadedCustomProvinceData != null && loadedCustomProvinceData.lProvinceOwners != null) {
                try {
                    int iSize = loadedCustomProvinceData.lProvinceOwners.size();
                    for (int i2 = 0; i2 < iSize; ++i2) {
                        CFG.core.getProv(i2).setCivId_LoadScenario(loadedCustomProvinceData.lProvinceOwners.get(i2));
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
        }
        catch (Exception e) {
            CFG.exceptionStack(e);
        }
        if (!nEditor) {
            boolean foundRandomCivilization = false;
            int iSize = lCivs.size();
            for (int i = 1; i < iSize; ++i) {
                if (!((Civilization)lCivs.get(i)).getCivTag().equals("ran")) continue;
                foundRandomCivilization = true;
                break;
            }
            if (foundRandomCivilization) {
                FileHandle tempFileT = FileManager.loadFile("game/civilizations/Age_of_Civilizations");
                String tempT = tempFileT.readString();
                String[] tagsSPLITED = tempT.split(";");
                Random oR = new Random();
                int iSize2 = lCivs.size();
                for (int i = 1; i < iSize2; ++i) {
                    int tempTagID;
                    if (!((Civilization)lCivs.get(i)).getCivTag().equals("ran")) continue;
                    while (tagsSPLITED[tempTagID = oR.nextInt(tagsSPLITED.length)].equals("ran") || CFG.isInTheCivGameTag(tagsSPLITED[tempTagID])) {
                    }
                    try {
                        Civilization_GameData3 tempCivData = Core.loadCivilization(tagsSPLITED[tempTagID]);
                        ((Civilization)lCivs.get(i)).setCivTag(tempCivData.getCivTag());
                        ((Civilization)lCivs.get(i)).setCivName(CFG.lang.getCiv(tempCivData.getCivTag()));
                        ((Civilization)lCivs.get(i)).setR(tempCivData.getR());
                        ((Civilization)lCivs.get(i)).setG(tempCivData.getG());
                        ((Civilization)lCivs.get(i)).setB(tempCivData.getB());
                        ((Civilization)lCivs.get(i)).disposeFlag();
                        ((Civilization)lCivs.get(i)).loadFlag();
                        tempCivData = null;
                    }
                    catch (Exception exception) {
                    }
                }
            }
        }
        CFG.map.getMpB().disposeMinimapOfCivilizations();
        try {
            this.sActiveScenarioTag = this.getScenarioTagID(CFG.core.getScenarioID());
        }
        catch (IndexOutOfBoundsException ex) {
            this.sActiveScenarioTag = "";
        }
        logJavaHeap("after loadCivilizations");
        return lCivs;
    }

    public final void loadProvincesData(boolean nEditor) {
        FileHandle file;
        if (this.isInternal.get(CFG.core.getScenarioID()).booleanValue()) {
            file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_W");
        } else {
            try {
                file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_W");
            }
            catch (Exception ex) {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_W");
            }
        }
        try {
            Json json = new Json();
            json.setIgnoreUnknownFields(true);
            Scenario_WastelandProvinces_GameData scenario_WastelandProvinces_GameData = null;
            FileHandle jsonFile = Gdx.files.local(file.path() + ".json");
            if (jsonFile.exists()) {
                try {
                    scenario_WastelandProvinces_GameData = json.fromJson(Scenario_WastelandProvinces_GameData.class, CFG.stripBOM_JSON(jsonFile.readString("UTF-8")));
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            if (scenario_WastelandProvinces_GameData == null && file.exists()) {
                scenario_WastelandProvinces_GameData = (Scenario_WastelandProvinces_GameData)CFG.deserialize(file.readBytes());
                try {
                    jsonFile.writeString(json.prettyPrint(scenario_WastelandProvinces_GameData), false, "UTF-8");
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }

            int iSize = scenario_WastelandProvinces_GameData.getWastelandProvincesSize();
            for (int i = 0; i < iSize; ++i) {
                CFG.core.getProv(scenario_WastelandProvinces_GameData.getWastelandProvinceID(i)).setWastelandLvl(0);
            }
            Object var3_4 = null;
        }
        catch (Exception exception) {
            
        }
        this.buildProvincePopulationAndEconomy(true, nEditor);
    }

    public final void loadEventsData() {
        block13: {
            try {
                CFG.eventsManager.events = new Events_GameData();
                if (!Menu_InitGame.DJE && EventsJ.loadEventsJ()) {
                    CFG.eventsManager.FXABF();
                    break block13;
                }
                try {
                    FileHandle file = null;
                    try {
                        if (this.isInternal.get(CFG.core.getScenarioID()).booleanValue()) {
                            file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + "events/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_E");
                        } else {
                            try {
                                file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + "events/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_E");
                            }
                            catch (Exception ex) {
                                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + "events/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_E");
                            }
                        }
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                    try {
                        Json json = new Json();
                        json.setIgnoreUnknownFields(true);
                        FileHandle jsonFile = Gdx.files.local(file.path() + ".json");
                        if (!jsonFile.exists() && file != null) {
                            jsonFile = FileManager.loadFile(file.path().replace("output/", "") + ".json");
                        }
                        if (jsonFile.exists()) {
                            try {
                                CFG.eventsManager.events = json.fromJson(Events_GameData.class, CFG.stripBOM_JSON(jsonFile.readString("UTF-8")));
                            } catch (Exception ex) {
                                CFG.exceptionStack(ex);
                            }
                        }
                        if (CFG.eventsManager.events == null && file != null && file.exists()) {
                            CFG.eventsManager.events = (Events_GameData)CFG.deserialize(file.readBytes());
                            try {
                                jsonFile.writeString(json.prettyPrint(CFG.eventsManager.events), false, "UTF-8");
                            } catch (Exception ex) {
                                CFG.exceptionStack(ex);
                            }
                        }
                        CFG.eventsManager.FXABF();
                    }
                    catch (Exception e) {
                        CFG.eventsManager.events = new Events_GameData();
                        CFG.eventsManager.FXABF();
                        CFG.exceptionStack(e);
                    }
                }
                catch (Exception ex) {
                    CFG.eventsManager.events = new Events_GameData();
                    CFG.eventsManager.FXABF();
                    CFG.exceptionStack(ex);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public final void loadCoresData() {
        FileHandle file;
        try {
            if (this.isInternal.get(CFG.core.getScenarioID()).booleanValue()) {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_C");
            } else {
                try {
                    file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_C");
                }
                catch (Exception ex) {
                    file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_C");
                }
            }
            try {
                Json json = new Json();
                json.setIgnoreUnknownFields(true);
                FileHandle jsonFile = Gdx.files.local(file.path() + ".json");
                if (jsonFile.exists()) {
                    try {
                        CFG.province_CoresGD = json.fromJson(Province_Cores_GameData.class, CFG.stripBOM_JSON(jsonFile.readString("UTF-8")));
                    } catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            if (CFG.province_CoresGD == null && file.exists()) {
                CFG.province_CoresGD = (Province_Cores_GameData)CFG.deserialize(file.readBytes());
                    try {
                        jsonFile.writeString(json.prettyPrint(CFG.province_CoresGD), false, "UTF-8");
                    } catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            }
            catch (Exception e) {
                CFG.province_CoresGD = new Province_Cores_GameData();
            }
        }
        catch (GdxRuntimeException ex) {
            CFG.province_CoresGD = new Province_Cores_GameData();
        }
        try {
            if (this.isInternal.get(CFG.core.getScenarioID()).booleanValue()) {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_O");
            } else {
                try {
                    file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_O");
                }
                catch (Exception ex) {
                    file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_O");
                }
            }
            Json json = new Json();
            json.setIgnoreUnknownFields(true);
            Province_GameData_Occupied occupied = null;
            FileHandle jsonFile = Gdx.files.local(file.path() + ".json");
            if (jsonFile.exists()) {
                try {
                    occupied = json.fromJson(Province_GameData_Occupied.class, CFG.stripBOM_JSON(jsonFile.readString("UTF-8")));
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            if (occupied == null && file.exists()) {
                occupied = (Province_GameData_Occupied)CFG.deserialize(file.readBytes());
                try {
                    jsonFile.writeString(json.prettyPrint(occupied), false, "UTF-8");
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            for (int i = 0; i < occupied.provinceID.size(); ++i) {
                CFG.core.getProv(occupied.provinceID.get(i)).setTrueOwnerOfProv(occupied.civID.get(i));
                CFG.core.getProv(occupied.provinceID.get(i)).getCores().addNewCore(occupied.civID.get(i), 1);
            }
        }
        catch (Exception exception) {
            
        }
    }

    public final void loadCoresDataEditor() {
        FileHandle file;
        try {
            if (this.isInternal.get(CFG.core.getScenarioID()).booleanValue()) {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_C");
            } else {
                try {
                    file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_C");
                }
                catch (Exception ex) {
                    file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_C");
                }
            }
            try {
                Json json = new Json();
                json.setIgnoreUnknownFields(true);
                FileHandle jsonFile = Gdx.files.local(file.path() + ".json");
                if (jsonFile.exists()) {
                    try {
                        CFG.province_CoresGD = json.fromJson(Province_Cores_GameData.class, CFG.stripBOM_JSON(jsonFile.readString("UTF-8")));
                    } catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            if (CFG.province_CoresGD == null && file.exists()) {
                CFG.province_CoresGD = (Province_Cores_GameData)CFG.deserialize(file.readBytes());
                    try {
                        jsonFile.writeString(json.prettyPrint(CFG.province_CoresGD), false, "UTF-8");
                    } catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            }
            catch (Exception e) {
                CFG.province_CoresGD = new Province_Cores_GameData();
            }
            try {
                for (int i = 0; i < CFG.province_CoresGD.getProvincesSize(); ++i) {
                    CFG.core.getProv(CFG.province_CoresGD.lProvinces.get((int)i).iProvinceID).buildProvinceCore();
                    for (int j = 0; j < CFG.province_CoresGD.lProvinces.get((int)i).lCores.size(); ++j) {
                        CFG.core.getProv(CFG.province_CoresGD.lProvinces.get((int)i).iProvinceID).getCores().addNewCore(CFG.province_CoresGD.lProvinces.get((int)i).lCores.get((int)j).iCivID, GameCalendar.TURNID);
                    }
                }
            }
            catch (Exception i) {
            }
        }
        catch (GdxRuntimeException ex) {
            CFG.province_CoresGD = new Province_Cores_GameData();
        }
        try {
            if (this.isInternal.get(CFG.core.getScenarioID()).booleanValue()) {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_O");
            } else {
                try {
                    file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_O");
                }
                catch (Exception ex) {
                    file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_O");
                }
            }
            Json json = new Json();
            json.setIgnoreUnknownFields(true);
            Province_GameData_Occupied occupied = null;
            FileHandle jsonFile = Gdx.files.local(file.path() + ".json");
            if (jsonFile.exists()) {
                try {
                    occupied = json.fromJson(Province_GameData_Occupied.class, CFG.stripBOM_JSON(jsonFile.readString("UTF-8")));
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            if (occupied == null && file.exists()) {
                occupied = (Province_GameData_Occupied)CFG.deserialize(file.readBytes());
                try {
                    jsonFile.writeString(json.prettyPrint(occupied), false, "UTF-8");
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            for (int i = 0; i < occupied.provinceID.size(); ++i) {
                CFG.core.getProv(occupied.provinceID.get(i)).setTrueOwnerOfProv(occupied.civID.get(i));
            }
        }
        catch (Exception exception) {
            
        }
    }

    public final void buildDiplomacy() {
        CFG.core.buildAlliances();
        CFG.core.buildWars();
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.core.getCiv(i).buildDiplomacy(true);
        }
    }

    public final void loadDiplomacyData(boolean editor) {
        FileHandle file;
        this.buildDiplomacy();
        if (loadedCustomJSON != null) {
            this.applyCustomDiplomacyData(editor);
            GameManager.buildFriendlyCivs();
            return;
        }
        if (this.isInternal.get(CFG.core.getScenarioID()).booleanValue()) {
            file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_D");
        } else {
            try {
                file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_D");
            }
            catch (Exception ex) {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_D");
            }
        }
        try {
            Json json = new Json();
            json.setIgnoreUnknownFields(true);
            int j;
            int i;
            Scenario_GameData_Diplomacy2 scenario_GameData_Diplomacy = null;
            FileHandle jsonFile = Gdx.files.local(file.path() + ".json");
            if (jsonFile.exists()) {
                try {
                    scenario_GameData_Diplomacy = json.fromJson(Scenario_GameData_Diplomacy2.class, CFG.stripBOM_JSON(jsonFile.readString("UTF-8")));
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            if (scenario_GameData_Diplomacy == null && file.exists()) {
                scenario_GameData_Diplomacy = (Scenario_GameData_Diplomacy2)CFG.deserialize(file.readBytes());
                try {
                    jsonFile.writeString(json.prettyPrint(scenario_GameData_Diplomacy), false, "UTF-8");
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            for (i = 0; i < scenario_GameData_Diplomacy.getAlliances().size(); ++i) {
                CFG.core.addAlliance(scenario_GameData_Diplomacy.getAlliances().get(i).getName());
                for (j = 0; j < scenario_GameData_Diplomacy.getAlliances().get(i).getCivs().size(); ++j) {
                    CFG.core.getAlliance(i + 1).addCivilization(scenario_GameData_Diplomacy.getAlliances().get(i).getCivs().get(j));
                    CFG.core.getCiv(scenario_GameData_Diplomacy.getAlliances().get(i).getCivs().get(j)).setAlliance(i + 1);
                }
                CFG.core.getAlliance(i + 1).setColorOfAlliance(new Color_GameData(scenario_GameData_Diplomacy.getAlliances().get(i).getColor().getR(), scenario_GameData_Diplomacy.getAlliances().get(i).getColor().getG(), scenario_GameData_Diplomacy.getAlliances().get(i).getColor().getB()));
            }
            if (editor) {
                for (i = 0; i < scenario_GameData_Diplomacy.getRelations().size(); ++i) {
                    CFG.core.setCivRelationOfCivB(scenario_GameData_Diplomacy.getRelations().get(i).getCivA(), scenario_GameData_Diplomacy.getRelations().get(i).getCivB(), scenario_GameData_Diplomacy.getRelations().get(i).getValue());
                }
            } else {
                for (i = 0; i < scenario_GameData_Diplomacy.getRelations().size(); ++i) {
                    CFG.core.setCivRelationOfCivB(scenario_GameData_Diplomacy.getRelations().get(i).getCivA(), scenario_GameData_Diplomacy.getRelations().get(i).getCivB(), scenario_GameData_Diplomacy.getRelations().get(i).getValue());
                }
                if (GameValues.gvDiplomacy.NEW_GAME_SET_RANDOM_RELATIONS) {
                    for (i = 1; i < CFG.core.getCivsSize() - 1; ++i) {
                        for (j = i + 1; j < CFG.core.getCivsSize(); ++j) {
                            if ((int)CFG.core.getCivRelationOfCivB(i, j) == 0) {
                                CFG.core.setCivRelationOfCivB(i, j, CFG.oR.nextInt(GameValues.gvDiplomacy.NEW_GAME_RANDOM_RELATIONS_RANDOM) - GameValues.gvDiplomacy.NEW_GAME_RANDOM_RELATIONS_BASE_MINUS);
                            }
                            if ((int)CFG.core.getCivRelationOfCivB(j, i) != 0) continue;
                            CFG.core.setCivRelationOfCivB(j, i, CFG.oR.nextInt(GameValues.gvDiplomacy.NEW_GAME_RANDOM_RELATIONS_RANDOM) - GameValues.gvDiplomacy.NEW_GAME_RANDOM_RELATIONS_BASE_MINUS);
                        }
                    }
                }
            }
            for (i = 0; i < scenario_GameData_Diplomacy.getMilitaryAccess().size(); ++i) {
                CFG.core.setMilitaryAccess(scenario_GameData_Diplomacy.getMilitaryAccess().get(i).getCivA(), scenario_GameData_Diplomacy.getMilitaryAccess().get(i).getCivB(), scenario_GameData_Diplomacy.getMilitaryAccess().get(i).getValue());
            }
            for (i = 0; i < scenario_GameData_Diplomacy.getGuarantee().size(); ++i) {
                CFG.core.setGuarantee(scenario_GameData_Diplomacy.getGuarantee().get(i).getCivA(), scenario_GameData_Diplomacy.getGuarantee().get(i).getCivB(), scenario_GameData_Diplomacy.getGuarantee().get(i).getValue());
            }
            for (i = 0; i < scenario_GameData_Diplomacy.getPacts().size(); ++i) {
                CFG.core.setCivNonAggressionPact(scenario_GameData_Diplomacy.getPacts().get(i).getCivA(), scenario_GameData_Diplomacy.getPacts().get(i).getCivB(), scenario_GameData_Diplomacy.getPacts().get(i).getValue());
            }
            for (i = 0; i < scenario_GameData_Diplomacy.getDefensivePacts().size(); ++i) {
                CFG.core.setDefensivePact(scenario_GameData_Diplomacy.getDefensivePacts().get(i).getCivA(), scenario_GameData_Diplomacy.getDefensivePacts().get(i).getCivB(), scenario_GameData_Diplomacy.getDefensivePacts().get(i).getValue());
            }
            for (i = 0; i < scenario_GameData_Diplomacy.getTruces().size(); ++i) {
                CFG.core.setCivTruce(scenario_GameData_Diplomacy.getTruces().get(i).getCivA(), scenario_GameData_Diplomacy.getTruces().get(i).getCivB(), scenario_GameData_Diplomacy.getTruces().get(i).getValue());
            }
            scenario_GameData_Diplomacy = null;
        }
        catch (ClassNotFoundException e) {
            CFG.toastM.addM("Error - Diplomacy Data");
        }
        catch (IOException iOException) {
        }
        catch (Exception exception) {
            
        }
        GameManager.buildFriendlyCivs();
    }

    public final void loadArmiesData() {
        int i;
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv(i).resetArmiesNewGame(0);
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0) continue;
            if (CFG.core.getProv(i).getCivId() == 0) {
                CFG.core.getProv(i).updateArmy4(this.getScenario_NeutralArmy());
                continue;
            }
            if (!CFG.core.getProv(i).isCapital()) continue;
            if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getProv((int)i).getCivId()).getIdeology()).CAN_BECOME_CIVILIZED >= 0) {
                CFG.core.getProv(i).updateArmy4(this.getScenario_StartingArmyInCapitals() / 10);
                continue;
            }
            CFG.core.getProv(i).updateArmy4(this.getScenario_StartingArmyInCapitals());
        }
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv((int)i).provinceVolunteerArmySent.clear();
        }
        if (loadedCustomProvinceDataByID != null) {
            this.applyCustomArmiesData();
            releaseCustomProvinceJsonCache();
            return;
        }
        try {
            FileHandle file;
            if (this.isInternal.get(CFG.core.getScenarioID()).booleanValue()) {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_A");
            } else {
                try {
                    file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_A");
                }
                catch (Exception ex) {
                    file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_A");
                }
            }
            try {
                Json json = new Json();
                json.setIgnoreUnknownFields(true);
                Scenario_GameData_Armies scenario_GameData_Armies = null;
                FileHandle jsonFile = Gdx.files.local(file.path() + ".json");
                if (jsonFile.exists()) {
                    try {
                        scenario_GameData_Armies = json.fromJson(Scenario_GameData_Armies.class, CFG.stripBOM_JSON(jsonFile.readString("UTF-8")));
                    } catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
                if (scenario_GameData_Armies == null && file.exists()) {
                    scenario_GameData_Armies = (Scenario_GameData_Armies)CFG.deserialize(file.readBytes());
                    try {
                        jsonFile.writeString(json.prettyPrint(scenario_GameData_Armies), false, "UTF-8");
                    } catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
                
                int iSize = scenario_GameData_Armies.lArmies.size();
                for (int i2 = 0; i2 < iSize; ++i2) {
                    try {
                        if (CFG.core.getProv(scenario_GameData_Armies.lArmies.get(i2).getProvinceID()).getWastelandLvl() >= 0 || CFG.core.getProv(scenario_GameData_Armies.lArmies.get(i2).getProvinceID()).getCivId() != scenario_GameData_Armies.lArmies.get(i2).getCivID() && !CFG.core.getProv(scenario_GameData_Armies.lArmies.get(i2).getProvinceID()).getSeaProv() && (CFG.core.getCiv(scenario_GameData_Armies.lArmies.get(i2).getCivID()).getAlliance() <= 0 || CFG.core.getCiv(scenario_GameData_Armies.lArmies.get(i2).getCivID()).getAlliance() > 0 != CFG.core.getCiv(CFG.core.getProv(scenario_GameData_Armies.lArmies.get(i2).getProvinceID()).getCivId()).getAlliance() > 0) && CFG.core.getCiv(CFG.core.getProv(scenario_GameData_Armies.lArmies.get(i2).getProvinceID()).getCivId()).getPuppetOfCiv() != scenario_GameData_Armies.lArmies.get(i2).getCivID() && CFG.core.getProv(scenario_GameData_Armies.lArmies.get(i2).getProvinceID()).getCivId() != CFG.core.getCiv(scenario_GameData_Armies.lArmies.get(i2).getCivID()).getPuppetOfCiv() && CFG.core.getMilitaryAccess(scenario_GameData_Armies.lArmies.get(i2).getCivID(), CFG.core.getProv(scenario_GameData_Armies.lArmies.get(i2).getProvinceID()).getCivId()) <= 0) continue;
                        CFG.core.getProv(scenario_GameData_Armies.lArmies.get(i2).getProvinceID()).updateArmy4(scenario_GameData_Armies.lArmies.get(i2).getCivID(), scenario_GameData_Armies.lArmies.get(i2).getArmy());
                        continue;
                    }
                    catch (Exception exception) {
                        
                    }
                }
            }
            catch (Exception exception) {}
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
        releaseCustomProvinceJsonCache();
    }

    private boolean isLoadedCustomProvinceNatural(int provinceID) {
        return loadedCustomProvinceData != null && loadedCustomProvinceData.lProvinceNatural != null && provinceID >= 0 && provinceID < loadedCustomProvinceData.lProvinceNatural.size() && Boolean.TRUE.equals(loadedCustomProvinceData.lProvinceNatural.get(provinceID));
    }

    private boolean isLoadedCustomProvinceFixed(int provinceID) {
        return loadedCustomProvinceData != null && loadedCustomProvinceData.lProvincePopulation != null && provinceID >= 0 && provinceID < loadedCustomProvinceData.lProvincePopulation.size() && !this.isLoadedCustomProvinceNatural(provinceID);
    }

    private boolean civHasFixedCustomProvinceData(Civilization civ) {
        if (civ == null || loadedCustomProvinceData == null || loadedCustomProvinceData.lProvincePopulation == null) return false;
        for (int i = 0; i < civ.getNumOfProvs(); ++i) {
            if (this.isLoadedCustomProvinceFixed(civ.getProvID(i))) return true;
        }
        return false;
    }

    private int getCustomCivID(String tag) {
        if (tag == null || tag.length() == 0) return -1;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (tag.equals(CFG.core.getCiv(i).getCivTag())) return i;
        }
        return -1;
    }

    private void applyCustomProvinceDetails() {
        if (loadedCustomProvinceDataByID == null) return;
        int appliedBuildings = 0;
        int appliedCores = 0;
        for (int i = 0; i < loadedCustomProvinceDataByID.length && i < CFG.core.getProvinSize(); ++i) {
            Scenario_CustomJSON.ProvinceData pData = loadedCustomProvinceDataByID[i];
            if (pData == null || CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0) continue;
            Province province = CFG.core.getProv(i);
            if (pData.fort != null) province.setLvlOfFort(pData.fort);
            if (pData.watchTower != null) province.setLvlOfWatchTower(pData.watchTower);
            if (pData.port != null) province.setLvlOfPort(pData.port);
            if (pData.farm != null) province.setLvlOfFarm(pData.farm);
            if (pData.library != null) province.setLvlOfLibrary(pData.library);
            if (pData.armoury != null) province.setLvlOfArmoury(pData.armoury);
            if (pData.workshop != null) province.setLvlOfWorkshop(pData.workshop);
            if (pData.supply != null) province.setLvlOfSupply(pData.supply);
            if (pData.market != null) province.setLvlOfMarket(pData.market);
            if (pData.airDefense != null) province.provGD.iAirDefense = pData.airDefense;
            ++appliedBuildings;
            if (pData.coreTags != null) {
                for (int j = 0; j < pData.coreTags.size(); ++j) {
                    int coreCivID = this.getCustomCivID(pData.coreTags.get(j));
                    if (coreCivID > 0) {
                        province.getCores().addNewCore(coreCivID, 1);
                        ++appliedCores;
                    }
                }
            }
        }
        CFG.LOG("[customJSON] Applied province details buildings=" + appliedBuildings + " cores=" + appliedCores);
    }

    private void applyCustomDiplomacyData(boolean editor) {
        if (loadedCustomJSON == null) return;
        int alliances = 0;
        int relations = 0;
        int pacts = 0;
        int wars = 0;
        if (loadedCustomJSON.alliances != null) {
            for (int i = 0; i < loadedCustomJSON.alliances.size(); ++i) {
                Scenario_CustomJSON.AllianceData allianceData = loadedCustomJSON.alliances.get(i);
                if (allianceData == null || allianceData.name == null) continue;
                CFG.core.addAlliance(allianceData.name);
                int allianceID = CFG.core.getAlliancesSize() - 1;
                if (allianceData.members != null) {
                    for (int j = 0; j < allianceData.members.size(); ++j) {
                        int civID = this.getCustomCivID(allianceData.members.get(j));
                        if (civID <= 0) continue;
                        CFG.core.getAlliance(allianceID).addCivilization(civID);
                        CFG.core.getCiv(civID).setAlliance(allianceID);
                    }
                }
                ++alliances;
            }
        }
        if (loadedCustomJSON.civilizations != null) {
            for (int i = 0; i < loadedCustomJSON.civilizations.size(); ++i) {
                Scenario_CustomJSON.CivilizationData civData = loadedCustomJSON.civilizations.get(i);
                if (civData == null) continue;
                int civID = this.getCustomCivID(civData.tag);
                if (civID <= 0) continue;
                if (civData.puppetOf != null && civData.puppetOf.length() > 0) {
                    int lordID = this.getCustomCivID(civData.puppetOf);
                    if (lordID > 0) CFG.core.getCiv(civID).setPuppetOfCivId(lordID);
                }
                if (civData.relations != null) {
                    for (int j = 0; j < civData.relations.size(); ++j) {
                        Scenario_CustomJSON.RelationData rel = civData.relations.get(j);
                        int targetID = rel != null ? this.getCustomCivID(rel.targetTag) : -1;
                        if (targetID > 0 && rel.value != null) { CFG.core.setCivRelationOfCivB(civID, targetID, rel.value); ++relations; }
                    }
                }
                if (civData.nonAggressionPacts != null) {
                    for (int j = 0; j < civData.nonAggressionPacts.size(); ++j) {
                        Scenario_CustomJSON.RelationData rel = civData.nonAggressionPacts.get(j);
                        int targetID = rel != null ? this.getCustomCivID(rel.targetTag) : -1;
                        if (targetID > 0 && rel.value != null) { CFG.core.setCivNonAggressionPact(civID, targetID, rel.value); ++pacts; }
                    }
                }
                if (civData.defensivePacts != null) {
                    for (int j = 0; j < civData.defensivePacts.size(); ++j) {
                        Scenario_CustomJSON.RelationData rel = civData.defensivePacts.get(j);
                        int targetID = rel != null ? this.getCustomCivID(rel.targetTag) : -1;
                        if (targetID > 0 && rel.value != null) { CFG.core.setDefensivePact(civID, targetID, rel.value); ++pacts; }
                    }
                }
                if (civData.militaryAccess != null) {
                    for (int j = 0; j < civData.militaryAccess.size(); ++j) {
                        Scenario_CustomJSON.RelationData rel = civData.militaryAccess.get(j);
                        int targetID = rel != null ? this.getCustomCivID(rel.targetTag) : -1;
                        if (targetID > 0 && rel.value != null) { CFG.core.setMilitaryAccess(civID, targetID, rel.value); ++pacts; }
                    }
                }
                if (civData.guarantees != null) {
                    for (int j = 0; j < civData.guarantees.size(); ++j) {
                        Scenario_CustomJSON.RelationData rel = civData.guarantees.get(j);
                        int targetID = rel != null ? this.getCustomCivID(rel.targetTag) : -1;
                        if (targetID > 0 && rel.value != null) { CFG.core.setGuarantee(civID, targetID, rel.value); ++pacts; }
                    }
                }
                if (civData.truces != null) {
                    for (int j = 0; j < civData.truces.size(); ++j) {
                        Scenario_CustomJSON.RelationData rel = civData.truces.get(j);
                        int targetID = rel != null ? this.getCustomCivID(rel.targetTag) : -1;
                        if (targetID > 0 && rel.value != null) { CFG.core.setCivTruce(civID, targetID, rel.value); ++pacts; }
                    }
                }
            }
        }
        if (loadedCustomJSON.wars != null) {
            for (int i = 0; i < loadedCustomJSON.wars.size(); ++i) {
                Scenario_CustomJSON.WarData warData = loadedCustomJSON.wars.get(i);
                if (warData == null || warData.aggressors == null || warData.defenders == null || warData.aggressors.size() == 0 || warData.defenders.size() == 0) continue;
                int firstAggressor = this.getCustomCivID(warData.aggressors.get(0));
                int firstDefender = this.getCustomCivID(warData.defenders.get(0));
                if (firstAggressor <= 0 || firstDefender <= 0) continue;
                CFG.core.addWarData(firstAggressor, firstDefender);
                int warID = CFG.core.getWarIndex(firstAggressor, firstDefender);
                if (warID >= 0) {
                    for (int j = 1; j < warData.aggressors.size(); ++j) {
                        int civID = this.getCustomCivID(warData.aggressors.get(j));
                        if (civID > 0) CFG.core.getWar(warID).addAggressor(civID);
                    }
                    for (int j = 1; j < warData.defenders.size(); ++j) {
                        int civID = this.getCustomCivID(warData.defenders.get(j));
                        if (civID > 0) CFG.core.getWar(warID).addDefender(civID);
                    }
                    for (int a = 0; a < warData.aggressors.size(); ++a) {
                        int aggressorID = this.getCustomCivID(warData.aggressors.get(a));
                        if (aggressorID <= 0) continue;
                        for (int d = 0; d < warData.defenders.size(); ++d) {
                            int defenderID = this.getCustomCivID(warData.defenders.get(d));
                            if (defenderID <= 0) continue;
                            CFG.core.setCivRelationOfCivB_AtWar(aggressorID, defenderID);
                            CFG.core.setCivRelationOfCivB_AtWar(defenderID, aggressorID);
                        }
                    }
                    ++wars;
                }
            }
        }
        CFG.LOG("[customJSON] Applied diplomacy alliances=" + alliances + " relations=" + relations + " pacts=" + pacts + " wars=" + wars);
    }

    private void applyCustomArmiesData() {
        if (loadedCustomProvinceDataByID == null) return;
        int armies = 0;
        for (int i = 0; i < loadedCustomProvinceDataByID.length && i < CFG.core.getProvinSize(); ++i) {
            Scenario_CustomJSON.ProvinceData pData = loadedCustomProvinceDataByID[i];
            if (pData == null || pData.armies == null) continue;
            for (int j = 0; j < pData.armies.size(); ++j) {
                Scenario_CustomJSON.ArmyData armyData = pData.armies.get(j);
                int civID = armyData != null ? this.getCustomCivID(armyData.civTag) : -1;
                if (civID > 0 && armyData.count != null) {
                    CFG.core.getProv(i).updateArmy4(civID, armyData.count);
                    ++armies;
                }
            }
        }
        CFG.LOG("[customJSON] Applied armies=" + armies);
    }

    public final void buildProvincePopulationAndEconomy(boolean loadCoresData, boolean nEditor) {
        CFG.LOG("[buildProvincePopulation] START loadedCustomProvinceData=" + (loadedCustomProvinceData != null) + " popSize=" + (loadedCustomProvinceData != null && loadedCustomProvinceData.lProvincePopulation != null ? loadedCustomProvinceData.lProvincePopulation.size() : -1));
        
        int i;
        Random oR = new Random();
        CFG.core.getCiv(0).setTechLevel(0.1f);
        
        int provSize = CFG.core.getProvinSize();
        int chunks = Math.max(1, Math.min(Runtime.getRuntime().availableProcessors(), provSize));
        int chunkSize = Math.max(1, (provSize + chunks - 1) / chunks);
        java.util.concurrent.CountDownLatch latch1 = new java.util.concurrent.CountDownLatch(chunks);
        for (int chunk = 0; chunk < chunks; ++chunk) {
            final int start = chunk * chunkSize;
            final int end = Math.min(provSize, start + chunkSize);
            Core.EXECUTOR.execute(() -> {
                try {
                    for (int idx = start; idx < end; ++idx) {
                        Province province = CFG.core.getProv(idx);
                        if (!province.getSeaProv()) {
                            province.getPop().clearData();
                            province.setEco(0);
                            province.incomeTaxation = 1.0f;
                            province.incomeProduction = 1.0f;
                            province.administrationCost = 0.0f;
                        }
                        province.setIsPartOfHolyRomanEmpire(false);
                        province.provGD.resetData();
                    }
                } finally {
                    latch1.countDown();
                }
            });
        }
        try { latch1.await(); } catch (InterruptedException e) { CFG.exceptionStack(e); }
        
        java.util.concurrent.CountDownLatch latch2 = new java.util.concurrent.CountDownLatch(chunks);
        for (int chunk = 0; chunk < chunks; ++chunk) {
            final int start = chunk * chunkSize;
            final int end = Math.min(provSize, start + chunkSize);
            Core.EXECUTOR.execute(() -> {
                try {
                    for (int idx = start; idx < end; ++idx) {
                        CFG.core.getProv(idx).buildProvinceCore();
                    }
                } finally {
                    latch2.countDown();
                }
            });
        }
        try { latch2.await(); } catch (InterruptedException e) { CFG.exceptionStack(e); }
        if (loadCoresData) {
            CFG.core.getGameScenars().loadCoresData();
            if (CFG.province_CoresGD != null) {
                for (i = 0; i < CFG.province_CoresGD.getProvincesSize(); ++i) {
                    try {
                        if (CFG.core.getProv(CFG.province_CoresGD.lProvinces.get((int)i).iProvinceID).getSeaProv() || CFG.core.getProv(CFG.province_CoresGD.lProvinces.get((int)i).iProvinceID).getWastelandLvl() >= 0 || CFG.core.getProv(CFG.province_CoresGD.lProvinces.get((int)i).iProvinceID).getCivId() <= 0) continue;
                        for (int j = 0; j < CFG.province_CoresGD.lProvinces.get((int)i).lCores.size(); ++j) {
                            CFG.core.getProv(CFG.province_CoresGD.lProvinces.get((int)i).iProvinceID).getCores().addNewCore(CFG.province_CoresGD.lProvinces.get((int)i).lCores.get((int)j).iCivID, 1);
                        }
                        continue;
                    }
                    catch (Exception j) {
                        
                    }
                }
            }
        }
        if (CFG.province_CoresGD == null) {
            CFG.province_CoresGD = new Province_Cores_GameData();
        }
        this.applyCustomProvinceDetails();
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            Province province = CFG.core.getProv(i);
            if (province.getSeaProv()) continue;
            float tDevelopment = CFG.core.getCiv(province.getCivId()).getTechLevel();
            tDevelopment = tDevelopment * ((1.0f - CFG.gameAges.getAge_StartingDevelopment(GameCalendar.CURRENT_AGEID)) * (province.isCapital() ? 0.7646841f : 0.5746985f)) + tDevelopment * CFG.gameAges.getAge_StartingDevelopment(GameCalendar.CURRENT_AGEID) * province.getGrowthRate_Pop();
            if (province.getCivId() > 0) {
                tDevelopment = tDevelopment * (float)CFG.getCreateScenario_TechnologyLevelsByContinents_Continent(province.getCivId() - 1, province.getRegion()) / 100.0f;
            }
            province.setDevLvl(tDevelopment *= 0.875f + (float)CFG.oR.nextInt(2000) / 10000.0f + CFG.terrainTypesManager.getBaseDevelopmentModifier(province.getTerrainTypeID()));
            if (loadedCustomProvinceDataByID != null && i < loadedCustomProvinceDataByID.length && loadedCustomProvinceDataByID[i] != null && !this.isLoadedCustomProvinceNatural(i) && loadedCustomProvinceDataByID[i].development != null) {
                province.setDevLvl(loadedCustomProvinceDataByID[i].development);
            }
            
            if (this.isLoadedCustomProvinceFixed(i)) {
                if (i == 0) CFG.LOG("[buildProvincePopulation] USING CUSTOM DATA for prov0 pop=" + loadedCustomProvinceData.lProvincePopulation.get(i));
                province.getPop().setPopulationOfCivID(province.getCivId(), loadedCustomProvinceData.lProvincePopulation.get(i));
                if (loadedCustomProvinceData.lProvinceEconomy != null && i < loadedCustomProvinceData.lProvinceEconomy.size()) {
                    province.setEco(loadedCustomProvinceData.lProvinceEconomy.get(i));
                }
                province.setHappi((float)(CFG.core.getCiv(province.getCivId()).getHappiness() + oR.nextInt(12) - 6) / 100.0f);
            } else if (province.getCivId() == 0) {
                province.getPop().setPopulationOfCivID(province.getCivId(), (int)((float)this.getScenario_StartingPopulation() * 0.18275f * (province.getGrowthRate_Pop() * (1.0f + CFG.terrainTypesManager.getPopulationGrowth(province.getTerrainTypeID())))) + oR.nextInt(1 + (int)Math.ceil((float)this.getScenario_StartingPopulation() * ((float)oR.nextInt(25) / 100.0f) * (province.getGrowthRate_Pop() * (1.0f + CFG.terrainTypesManager.getPopulationGrowth(province.getTerrainTypeID()))))) / 4);
                province.setEco((int)((float)this.getScenario_StartingEconomy() * (0.05275f + (float)province.getNeighSeaProvincesSize() * 0.0015f) * (province.getGrowthRate_Pop() * (1.0f + CFG.terrainTypesManager.getEconomyGrowth(province.getTerrainTypeID())))) + oR.nextInt(1 + (int)Math.ceil((float)this.getScenario_StartingEconomy() * ((float)oR.nextInt(10) / 100.0f) * (province.getGrowthRate_Pop() * (1.0f + CFG.terrainTypesManager.getEconomyGrowth(province.getTerrainTypeID())) * province.getDeveLvl()))));
                province.setHappi(0.48f + (float)oR.nextInt(2400) / 10000.0f);
            } else {
                if (province.getCores().getCivsSize() >= 1) {
                    int j;
                    int tempPop = (int)((float)((int)((float)this.getScenario_StartingPopulation() * (0.85f + (province.isCapital() ? 0.0725f : 0.0f)) * ((province.isCapital() ? Math.max(0.2675f, province.getGrowthRate_Pop()) : province.getGrowthRate_Pop()) * (1.0f + CFG.terrainTypesManager.getPopulationGrowth(province.getTerrainTypeID())))) + oR.nextInt(1 + (int)Math.ceil((float)this.getScenario_StartingPopulation() * 0.15f * (province.getGrowthRate_Pop() * (1.0f + CFG.terrainTypesManager.getPopulationGrowth(province.getTerrainTypeID())))))) * (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)province.getCivId()).getIdeology()).CAN_BECOME_CIVILIZED >= 0 ? (CFG.core.getCiv(province.getCivId()).getCapitalProvID() == i ? 0.4f : 0.275f) : 1.0f) * (0.725f + 0.275f * (float)CFG.getCreateScenario_TechnologyLevelsByContinents_Continent(province.getCivId() - 1, province.getRegion()) / 100.0f));
                    province.getPop().clearData();
                    for (j = 0; j < province.getCores().getCivsSize(); ++j) {
                        province.getPop().setPopulationOfCivID(province.getCores().getCivID(j), (int)((float)tempPop * CFG.province_CoresGD.getPercOfPop(i, province.getCores().getCivID(j))));
                    }
                    for (j = 0; j < province.getCores().getCivsSize() && j < 1; ++j) {
                        if (!(CFG.province_CoresGD.getPercOfPop(i, province.getCores().getCivID(j)) < 0.18f)) continue;
                        province.getCores().removeCore(province.getCores().getCivID(j));
                    }
                } else {
                    province.getPop().setPopulationOfCivID(province.getCivId(), (int)((float)((int)((float)this.getScenario_StartingPopulation() * (0.85f + (province.isCapital() ? 0.05f : 0.0f)) * (province.getGrowthRate_Pop() * (1.0f + CFG.terrainTypesManager.getPopulationGrowth(province.getTerrainTypeID())))) + oR.nextInt(1 + (int)Math.ceil((float)this.getScenario_StartingPopulation() * 0.15f * (province.getGrowthRate_Pop() * (1.0f + CFG.terrainTypesManager.getPopulationGrowth(province.getTerrainTypeID())))))) * (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)province.getCivId()).getIdeology()).CAN_BECOME_CIVILIZED >= 0 ? (CFG.core.getCiv(province.getCivId()).getCapitalProvID() == i ? 0.4f : 0.275f) : 1.0f) * (0.725f + 0.275f * (float)CFG.getCreateScenario_TechnologyLevelsByContinents_Continent(province.getCivId() - 1, province.getRegion()) / 100.0f)));
                }
                province.setEco((int)((float)((int)((float)this.getScenario_StartingEconomy() * (province.getDeveLvl() * 1.064498f + (float)province.getNeighSeaProvincesSize() * 0.035f) * (province.getGrowthRate_Pop() * (1.0f + CFG.terrainTypesManager.getEconomyGrowth(province.getTerrainTypeID()))))) + (float)oR.nextInt(1 + Math.max((int)Math.ceil((float)this.getScenario_StartingEconomy() * (1.0f - province.getDeveLvl()) * (province.getGrowthRate_Pop() * (1.0f + CFG.terrainTypesManager.getEconomyGrowth(province.getTerrainTypeID())) * province.getDeveLvl())), 0)) * (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)province.getCivId()).getIdeology()).CAN_BECOME_CIVILIZED >= 0 ? (CFG.core.getCiv(province.getCivId()).getCapitalProvID() == i ? 0.95f : 0.725f) : 1.0f)));
                province.setHappi((float)(CFG.core.getCiv(province.getCivId()).getHappiness() + oR.nextInt(12) - 6) / 100.0f);
            }
            for (int j = 0; j < province.getNeighProvincesSize(); ++j) {
                if (CFG.core.getProv(province.getNeighProvinces(j)).getCivId() <= 0 || CFG.core.getProv(province.getNeighProvinces(j)).getCivId() == province.getCivId()) continue;
                province.getPop().setPopulationOfCivID(CFG.core.getProv(province.getNeighProvinces(j)).getCivId(), province.getPop().getPopulationOfCivID(CFG.core.getProv(province.getNeighProvinces(j)).getCivId()) + (int)((float)province.getPop().getPops() * (0.00874f + (float)CFG.oR.nextInt(345) / 10000.0f)));
            }
        }
        if (!nEditor) {
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)i).getIdeology()).CAN_BECOME_CIVILIZED < 0 || CFG.core.getCiv(i).getCapitalProvID() < 0) continue;
                for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).getNeighProvincesSize(); ++j) {
                    if (CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).getNeighProvinces(j)).getWastelandLvl() >= 0 || CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).getNeighProvinces(j)).getCivId() != 0 && CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getCiv((int)i).getCapitalProvID()).getNeighProvinces((int)j)).getCivId()).getIdeology()).CAN_BECOME_CIVILIZED < 0) continue;
                    CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).getNeighProvinces(j)).getCores().addNewCore(i, 1);
                }
                int tRan = CFG.oR.nextInt(GameValues.gvMigrate.CAN_MIGRATE_EVERY_X_TURNS);
                for (int a = 0; a < tRan; ++a) {
                    CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).getCores().increaseOwnership(i, CFG.core.getCiv(i).getCapitalProvID());
                }
            }
        }
        
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            try {
                Civilization civ = CFG.core.getCiv(i);
                if (civ == null || civ.getNumOfProvs() <= 0) continue;
                long tgtPop = civ.civGD.targetPopulation;
                long tgtEco = civ.civGD.targetEconomy;
                if (tgtPop <= 0L && tgtEco <= 0L) continue;
                
                
                
                
                
                if (this.civHasFixedCustomProvinceData(civ)) { CFG.LOG("[buildProvincePopulation] SKIP rescaling pass - fixed custom province data present for civ=" + civ.getCivTag()); continue; }

                
                long currentPop = 0;
                long currentEco = 0;
                for (int j = 0; j < civ.getNumOfProvs(); ++j) {
                    int pID = civ.getProvID(j);
                    if (pID < 0) continue;
                    Province p = CFG.core.getProv(pID);
                    currentPop += p.getPop().getPops();
                    currentEco += p.getEco();
                }
                
                if (tgtPop > 0 && currentPop > 0) {
                    float popScale = (float) tgtPop / (float) currentPop;
                    for (int j = 0; j < civ.getNumOfProvs(); ++j) {
                        int pID = civ.getProvID(j);
                        if (pID < 0) continue;
                        Province p = CFG.core.getProv(pID);
                        int newPop = Math.max(1, (int)(p.getPop().getPops() * popScale));
                        p.getPop().setPopulationOfCivID(civ.getCivId(), newPop);
                    }
                }
                
                if (tgtEco > 0 && currentEco > 0) {
                    float ecoScale = (float) tgtEco / (float) currentEco;
                    for (int j = 0; j < civ.getNumOfProvs(); ++j) {
                        int pID = civ.getProvID(j);
                        if (pID < 0) continue;
                        Province p = CFG.core.getProv(pID);
                        int newEco = Math.max(1, (int)(p.getEco() * ecoScale));
                        p.setEco(newEco);
                    }
                }
            } catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        
        CFG.province_CoresGD = null;
        Core.addSimpleTask(new Core.SimpleTask("updateCitiesAll"){

            @Override
            public void update() {
                CitiesManager.updateCitiesAll();
            }
        });
    }

    public final void disableFillTheMap() {
        int i;
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).isCapital()) continue;
            CFG.core.getProv(i).setCivId_LoadScenario(0);
            CFG.core.getProv(i).setCivRegionID(-1);
        }
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.core.getCiv(i).clearProvinces_FillTheMap(CFG.core.getCiv(i).getNumOfProvs() > 0);
        }
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            for (int j = 0; j < CFG.core.getProv(i).getProvinceBordersLandByLandSize(); ++j) {
                CFG.core.getProv(i).getProvBordersLandByLand().get(j).setIsCivilizationBorder(false, i);
            }
        }
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).updateProvinceBorder();
        }
        CFG.core.buildCivilizationsRegions();
        CFG.map.getMpB().disposeMinimapOfCivilizations();
    }

    public final void enableFillTheMap() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.core.getCiv(i).clearProvinces_FillTheMap(false);
        }
        FileHandle file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()));
        FileHandle fileProvince = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_PD");
        try {
            Json json = new Json();
            json.setIgnoreUnknownFields(true);
            int i;
            Scenario_GameData tempScenarioGameData = null;
            FileHandle jsonFile = Gdx.files.local(file.path() + ".json");
            if (jsonFile.exists()) {
                try {
                    tempScenarioGameData = json.fromJson(Scenario_GameData.class, CFG.stripBOM_JSON(jsonFile.readString("UTF-8")));
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            if (tempScenarioGameData == null && file.exists()) {
                try {
                    tempScenarioGameData = (Scenario_GameData)CFG.deserialize(file.readBytes());
                } catch (Exception ex) {
                    try {
                        Scenario_GameData_Legacy legacy = (Scenario_GameData_Legacy)CFG.deserializeLegacyScenario(file.readBytes());
                        tempScenarioGameData = legacy.convertToNew();
                    } catch (Exception ex2) {
                        CFG.exceptionStack(ex2);
                    }
                }
                if (tempScenarioGameData != null) {
                    try {
                        jsonFile.writeString(json.prettyPrint(tempScenarioGameData), false, "UTF-8");
                    } catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            }
            if (tempScenarioGameData != null) {
                for (int i2 = 0; i2 < tempScenarioGameData.getCivSize(); ++i2) {
                    CFG.core.getCiv(i2 + 1).setCapitalProvID(tempScenarioGameData.getCivCapital(i2));
                }
            }
            Scenario_GameData_Province2 scenario_GameData_Province = null;
            FileHandle jsonFilePD = Gdx.files.local(fileProvince.path() + ".json");
            if (jsonFilePD.exists()) {
                try {
                    scenario_GameData_Province = json.fromJson(Scenario_GameData_Province2.class, CFG.stripBOM_JSON(jsonFilePD.readString("UTF-8")));
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            if (scenario_GameData_Province == null && fileProvince.exists()) {
                scenario_GameData_Province = (Scenario_GameData_Province2)CFG.deserialize(fileProvince.readBytes());
                try {
                    jsonFilePD.writeString(json.prettyPrint(scenario_GameData_Province), false, "UTF-8");
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            if (scenario_GameData_Province != null && scenario_GameData_Province.getProvinceOwners() != null) {
                int iSize = scenario_GameData_Province.getProvinceOwners().size();
                for (i = 0; i < iSize; ++i) {
                    CFG.core.getProv(i).setCivId_LoadScenario(scenario_GameData_Province.getProvinceOwners().get(i));
                    CFG.core.getCiv(scenario_GameData_Province.getProvinceOwners().get(i)).addProv_Just(i);
                }
            }
            for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                for (int j = 0; j < CFG.core.getProv(i).getProvinceBordersLandByLandSize(); ++j) {
                    CFG.core.getProv(i).getProvBordersLandByLand().get(j).setIsCivilizationBorder(CFG.core.getProv(i).getCivId() != CFG.core.getProv(CFG.core.getProv(i).getProvBordersLandByLand().get(j).getWithProvinceID()).getCivId(), i);
                }
            }
            CFG.core.buildCivilizationsRegions();
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
        CFG.map.getMpB().disposeMinimapOfCivilizations();
    }

    public final void editScenario(int iID) {
        GameCalendar.TURNID = 1;
        CFG.core.setScenarioID(iID);
        CFG.core.loadScenario(true);
        CFG.core.getGameScenars().loadCoresDataEditor();
        CFG.CREATE_SCENARIO_GAME_DATA_TAG = this.lScenarios_TagsList.get(CFG.core.getScenarioID());
        CFG.CREATE_SCENARIO_NAME = this.getScenarioNameID(CFG.core.getScenarioID());
        CFG.CREATE_SCENARIO_AUTHOR = this.getScenarioAuthorID(CFG.core.getScenarioID());
        CFG.CREATE_SCENARIO_AGE = this.getScenarioAgeID(CFG.core.getScenarioID());
        CFG.CREATE_SCENARIO_WIKI = this.getScenarioWiki(CFG.core.getScenarioID());
        GameCalendar.currYear = this.getScenarioYearID(CFG.core.getScenarioID());
        GameCalendar.currMonth = this.getScenarioMonth(CFG.core.getScenarioID());
        GameCalendar.currDay = this.getScenarioDay(CFG.core.getScenarioID());
    }

    public final int getScenarioNumOfCivs(int i) {
        try {
            return this.lScenarios_CivNum.get(i);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            return 0;
        }
    }

    public final void setNumOfCivs(int i, int nNumCivs) {
        try {
            this.lScenarios_CivNum.set(i, nNumCivs);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
    }

    public final String getScenarioNameID(int i) {
        return this.lScenarios_Names.get(i);
    }

    public final void setScenarioName(int i, String nName) {
        try {
            nName = CFG.stripBOM(nName);
            this.lScenarios_Names.set(i, nName);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
    }

    public final String getScenarioWiki(int i) {
        return this.lScenarios_Wikis.get(i);
    }

    public final String getScenarioAuthorID(int i) {
        return this.lScenarios_Authors.get(i);
    }

    public final void setScenarioAuthor(int i, String nAuthor) {
        try {
            nAuthor = CFG.stripBOM(nAuthor);
            this.lScenarios_Authors.set(i, nAuthor);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
    }

    public final String getScenarioTagID(int i) {
        return this.lScenarios_TagsList.get(i);
    }

    public final int getScenarioAgeID(int i) {
        return this.lScenarios_Age.get(i);
    }

    public final void setScenarioAge(int i, int nAge) {
        try {
            this.lScenarios_Age.set(i, nAge);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
    }

    public final int getScenarioYearID(int i) {
        return this.lScenarios_Year.get(i);
    }

    public final int getScenarioMonth(int i) {
        return this.lScenarios_Month.get(i);
    }

    public final int getScenarioDay(int i) {
        return this.lScenarios_Day.get(i);
    }

    public final void setScenarioDay(int i, int nDay) {
        try {
            this.lScenarios_Day.set(i, nDay);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
    }

    public final void setScenarioMonth(int i, int nMonth) {
        try {
            this.lScenarios_Month.set(i, nMonth);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
    }

    public final void setScenarioYear(int i, int nYear) {
        try {
            this.lScenarios_Year.set(i, nYear);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
    }

    public final long getScenario_StartingArmyInCapitals() {
        return this.iScenario_StartingArmyInCapitals;
    }

    public final void setScenarioStartingArmyInCapitals(long iScenario_StartingArmyInCapitals) {
        this.iScenario_StartingArmyInCapitals = iScenario_StartingArmyInCapitals;
    }

    public final float getScenario_PopulationGrowthRate_Modifier() {
        return this.iScenario_PopulationGrowthRate_Modifier;
    }

    public final void setScenario_PopulationGrowthRate_Modifier(float iScenario_PopulationGrowthRate_Modifier) {
        this.iScenario_PopulationGrowthRate_Modifier = iScenario_PopulationGrowthRate_Modifier;
    }

    public final float getScenario_EconomyGrowthRate_Modifier() {
        return this.iScenario_EconomyGrowthRate_Modifier;
    }

    public final void setScenario_EconomyGrowthRate_Modifier(float iScenario_EconomyGrowthRate_Modifier) {
        this.iScenario_EconomyGrowthRate_Modifier = iScenario_EconomyGrowthRate_Modifier;
    }

    public final float getScenario_DiseasesDeathRate_Modifier() {
        return this.iScenario_DiseasesDeathRate_Modifier;
    }

    public final void setScenario_DiseasesDeathRate_Modifier(float iScenario_DiseasesDeathRate_Modifier) {
        this.iScenario_DiseasesDeathRate_Modifier = iScenario_DiseasesDeathRate_Modifier;
    }

    public final long getScenario_NeutralArmy() {
        return this.iScenario_NeutralArmy;
    }

    public final void setScenario_NeutralArmy(long iScenario_NeutralArmy) {
        this.iScenario_NeutralArmy = iScenario_NeutralArmy;
    }

    public final long getScenario_StartingPopulation() {
        return this.iScenario_StartingPopulation;
    }

    public final void setScenarioStartingPopulation(long iScenario_StartingPopulation) {
        this.iScenario_StartingPopulation = iScenario_StartingPopulation;
    }

    public final long getScenario_StartingEconomy() {
        return this.iScenario_StartingEconomy;
    }

    public final void setScenarioStartingEconomy(long iScenario_StartingEconomy) {
        this.iScenario_StartingEconomy = iScenario_StartingEconomy;
    }

    public final long getScenario_StartingMoney() {
        return this.iScenario_StartingMoney;
    }

    public final void setScenarioStartingMoney(long iScenario_StartingMoney) {
        this.iScenario_StartingMoney = iScenario_StartingMoney;
    }

    public final String getScenario_ActivePallet_TAG() {
        return this.sScenario_ActivePallet_TAG;
    }

    public void setScenarioActivePallet_TAG(String sScenario_ActivePallet_TAG) {
        this.sScenario_ActivePallet_TAG = sScenario_ActivePallet_TAG;
    }

    public final boolean getScenarioIsInternal(int i) {
        return this.isInternal.get(i);
    }

    public class RandomGame_AoCMode {
        public String sTag;
        public int iCapitalID = -1;

        public RandomGame_AoCMode(String sTag) {
            this.sTag = sTag;
            this.iCapitalID = -1;
        }

        public RandomGame_AoCMode(String sTag, int iCapitalID) {
            this.sTag = sTag;
            this.iCapitalID = iCapitalID;
        }
    }
}
