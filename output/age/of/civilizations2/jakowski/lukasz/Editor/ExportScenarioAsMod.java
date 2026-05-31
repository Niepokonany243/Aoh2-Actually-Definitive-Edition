
package age.of.civilizations2.jakowski.lukasz.Editor;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import com.badlogic.gdx.files.FileHandle;

public class ExportScenarioAsMod {
    public static void exportScenario(String tag, String name, int year) {
        try {
            FileHandle file;
            try {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag);
                file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag));
            }
            catch (Exception exception) {
                
            }
            try {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag);
                file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag));
            }
            catch (Exception exception) {
                
            }
            try {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_PD");
                file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_PD"));
            }
            catch (Exception exception) {
                
            }
            try {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_D");
                file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_D"));
            }
            catch (Exception exception) {
                
            }
            try {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_HRE");
                file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_HRE"));
            }
            catch (Exception exception) {
                
            }
            try {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_W");
                file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_W"));
            }
            catch (Exception exception) {
                
            }
            try {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_C");
                file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_C"));
            }
            catch (Exception exception) {
                
            }
            try {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + "events/" + tag + "_E");
                file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + "events/" + tag + "_E"));
            }
            catch (Exception exception) {
                
            }
            try {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_A");
                file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_A"));
            }
            catch (Exception exception) {
                
            }
            try {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_O");
                file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_O"));
            }
            catch (Exception exception) {
                
            }
            try {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_INFO" + ".json");
                file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + tag + "_INFO" + ".json"));
            }
            catch (Exception exception) {
                
            }
            try {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + "preview.png");
                file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + "preview.png"));
            }
            catch (Exception exception) {
                
            }
            try {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + "previewSpecial.png");
                file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + "previewSpecial.png"));
            }
            catch (Exception exception) {
                
            }
            try {
                FileHandle fileSave = FileManager.getSaveType("mods/" + tag + "/mod.txt");
                fileSave.writeString("{\n", false);
                fileSave.writeString("\tName: \"" + CFG.lang.get(name) + " Year: " + CFG.gameAges.getYear(year) + " New Scenario\",\n", true);
                fileSave.writeString("\tDescription: \"A new Scenario " + CFG.lang.get(name) + " [" + CFG.gameAges.getYear(year) + "] for Age of History 2: Definitive Edition [Map: " + CFG.map.getFile_ActiveMap_Path2() + "]\",\n", true);
                fileSave.writeString("\t\n", true);
                fileSave.writeString("\tTags: [ \"" + CFG.map.getFile_ActiveMap_Path2() + "\", \"Scenario\", \"" + CFG.gameAges.getAge(CFG.gameAges.getAgeOfYear(year)).getName() + " " + CFG.gameAges.getYear(CFG.gameAges.getAge(CFG.gameAges.getAgeOfYear(year)).getBeginningYear()) + " - " + CFG.gameAges.getYear(CFG.gameAges.getAge(CFG.gameAges.getAgeOfYear(year)).getEndYear()) + "\" ],\n", true);
                fileSave.writeString("\t\n", true);
                fileSave.writeString("\tChangeNote: \"First release AoH2:DE\",\n", true);
                fileSave.writeString("}\n", true);
            }
            catch (Exception fileSave) {
                
            }
            try {
                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + tag + "/" + "preview.png");
                file.copyTo(FileManager.getSaveType("mods/" + tag + "/logo.png"));
            }
            catch (Exception fileSave) {
                
            }
            try {
                for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                    boolean added = false;
                    if (FileManager.loadFile("game/civilizations/" + CFG.core.getCiv(i).getCivTag()).exists()) {
                        file = FileManager.loadFile("game/civilizations/" + CFG.core.getCiv(i).getCivTag());
                        file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "game/" + "civilizations/" + CFG.core.getCiv(i).getCivTag()));
                        added = true;
                    } else if (FileManager.loadFile("game/civilizations/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag())).exists()) {
                        file = FileManager.loadFile("game/civilizations/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag()));
                        file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "game/" + "civilizations/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag())));
                        added = true;
                    } else if (FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag())).exists()) {
                        String realTag = CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag());
                        file = FileManager.loadFile("game/civilizations_editor/" + realTag + "/" + realTag);
                        file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "game/" + "civilizations_editor/" + realTag + "/" + realTag));
                        file = FileManager.loadFile("game/civilizations_editor/" + realTag + "/" + realTag + "_FD");
                        file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "game/" + "civilizations_editor/" + realTag + "/" + realTag + "_FD"));
                        file = FileManager.loadFile("game/civilizations_editor/" + realTag + "/" + realTag + "_FLH.png");
                        file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "game/" + "civilizations_editor/" + realTag + "/" + realTag + "_FLH.png"));
                        file = FileManager.loadFile("game/civilizations_editor/" + realTag + "/" + realTag + "_FL.png");
                        file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "game/" + "civilizations_editor/" + realTag + "/" + realTag + "_FL.png"));
                        file = FileManager.loadFile("game/civilizations_editor/" + realTag + "/" + realTag + "_NM");
                        file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "game/" + "civilizations_editor/" + realTag + "/" + realTag + "_NM"));
                    }
                    if (!added) continue;
                    if (FileManager.loadFile("game/flags/" + CFG.core.getCiv(i).getCivTag() + ".png").exists()) {
                        file = FileManager.loadFile("game/flags/" + CFG.core.getCiv(i).getCivTag() + ".png");
                        file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "game/" + "flags/" + CFG.core.getCiv(i).getCivTag() + ".png"));
                    }
                    if (FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag()) + ".png").exists()) {
                        file = FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag()) + ".png");
                        file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "game/" + "flags/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag()) + ".png"));
                    }
                    if (FileManager.loadFile("game/flagsH/" + CFG.core.getCiv(i).getCivTag() + ".png").exists()) {
                        file = FileManager.loadFile("game/flagsH/" + CFG.core.getCiv(i).getCivTag() + ".png");
                        file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "game/" + "flagsH/" + CFG.core.getCiv(i).getCivTag() + ".png"));
                    }
                    if (FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag()) + ".png").exists()) {
                        file = FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag()) + ".png");
                        file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "game/" + "flagsH/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag()) + ".png"));
                    }
                    if (FileManager.loadFile("game/flagsXH/" + CFG.core.getCiv(i).getCivTag() + ".png").exists()) {
                        file = FileManager.loadFile("game/flagsXH/" + CFG.core.getCiv(i).getCivTag() + ".png");
                        file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "game/" + "flagsXH/" + CFG.core.getCiv(i).getCivTag() + ".png"));
                    }
                    if (!FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag()) + ".png").exists()) continue;
                    file = FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag()) + ".png");
                    file.copyTo(FileManager.getSaveType("mods/" + tag + "/" + "game/" + "flagsXH/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(i).getCivTag()) + ".png"));
                }
            }
            catch (Exception exception) {
            }
        }
        catch (Exception ex) {
            CFG.toastM.addM(CFG.lang.get("Error"));
            CFG.exceptionStack(ex);
        }
    }
}

