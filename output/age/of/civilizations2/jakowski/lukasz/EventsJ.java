
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_GameData;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

public class EventsJ {
    public static Json getJson() {
        Json json = new Json();
        json.setTypeName("class");
        json.setUsePrototypes(false);
        json.setIgnoreUnknownFields(true);
        json.setOutputType(JsonWriter.OutputType.javascript);
        return json;
    }

    public static boolean loadEventsJ() {
        block10: {
            try {
                FileHandle file;
                if (CFG.core.getGameScenars().isInternal.get(CFG.core.getScenarioID()).booleanValue()) {
                    file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + "eventsJ/" + "Age_of_History.txt");
                } else {
                    try {
                        file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + "eventsJ/" + "Age_of_History.txt");
                    }
                    catch (Exception ex) {
                        file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + "eventsJ/" + "Age_of_History.txt");
                    }
                }
                CFG.eventsManager.events.lEvents.clear();
                CFG.eventsManager.events.iEventsSize = 0;
                if (!file.exists()) break block10;
                String tempTags = file.readString();
                String[] tagsSPLITED = tempTags.split(";");
                Json json = EventsJ.getJson();
                if (CFG.core.getGameScenars().isInternal.get(CFG.core.getScenarioID()).booleanValue()) {
                    int iSize = tagsSPLITED.length;
                    for (int i = 0; i < iSize; ++i) {
                        FileHandle fileE = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + "eventsJ/" + tagsSPLITED[i] + ".txt");
                        if (!fileE.exists()) continue;
                        Event_GameData event = json.fromJson(Event_GameData.class, fileE.readString());
                        CFG.eventsManager.events.lEvents.add(event);
                    }
                } else {
                    int iSize = tagsSPLITED.length;
                    for (int i = 0; i < iSize; ++i) {
                        FileHandle fileE = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + "eventsJ/" + tagsSPLITED[i] + ".txt").exists() ? Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + "eventsJ/" + tagsSPLITED[i] + ".txt") : FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + "eventsJ/" + tagsSPLITED[i] + ".txt");
                        if (!fileE.exists()) continue;
                        Event_GameData event = json.fromJson(Event_GameData.class, fileE.readString());
                        CFG.eventsManager.events.lEvents.add(event);
                    }
                }
                CFG.eventsManager.events.iEventsSize = CFG.eventsManager.events.lEvents.size();
                return true;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return false;
    }

    public static void saveEventsJ() {
        try {
            FileHandle fileSave = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.CREATE_SCENARIO_GAME_DATA_TAG + "/" + "eventsJ/" + "Age_of_History.txt");
            fileSave.writeString("", false);
            FileHandle fileSave2 = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.CREATE_SCENARIO_GAME_DATA_TAG + "/" + "eventsJ/" + "111_EventTagsAndNames.txt");
            fileSave2.writeString("", false);
            int iSize = CFG.eventsManager.events.lEvents.size();
            for (int i = 0; i < iSize; ++i) {
                EventsJ.saveEventJ(i);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void saveEventJ(int i) {
        try {
            Json json = EventsJ.getJson();
            json.setTypeName("class");
            json.setUsePrototypes(false);
            json.setOutputType(JsonWriter.OutputType.javascript);
            FileHandle file = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.CREATE_SCENARIO_GAME_DATA_TAG + "/" + "eventsJ/" + CFG.eventsManager.events.lEvents.get(i).getEventTag() + ".txt");
            file.writeString(json.prettyPrint(CFG.eventsManager.events.lEvents.get(i)), false);
            FileHandle fileSave = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.CREATE_SCENARIO_GAME_DATA_TAG + "/" + "eventsJ/" + "Age_of_History.txt");
            fileSave.writeString("" + CFG.eventsManager.events.lEvents.get(i).getEventTag() + ";", true);
            FileHandle fileSave2 = FileManager.getSaveType("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.CREATE_SCENARIO_GAME_DATA_TAG + "/" + "eventsJ/" + "111_EventTagsAndNames.txt");
            fileSave2.writeString("" + CFG.eventsManager.events.lEvents.get(i).getEventTag() + ".txt -> " + CFG.eventsManager.events.lEvents.get(i).getEventName() + "\n", true);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }
}

