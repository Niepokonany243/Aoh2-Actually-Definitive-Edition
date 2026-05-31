/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Z_Other.ST;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.SteamGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamFriends;
import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamRemoteStorage;
import com.codedisaster.steamworks.SteamUGC;
import com.codedisaster.steamworks.SteamUGCCallback;
import com.codedisaster.steamworks.SteamUGCUpdateHandle;
import com.codedisaster.steamworks.SteamUserStats;
import com.codedisaster.steamworks.SteamUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sUM {
    private static final int APP_ID = 3381680;
    public static boolean sUQ = false;
    public static SteamPublishedFileID sUCP = null;
    public static SteamRemoteStorage sUR = null;
    public static SteamUtils sUT = null;
    public static SteamUserStats sUI = null;
    public static SteamFriends uSF = null;
    public static SteamUGC sU = null;
    public static SteamUGCCallback sUC = null;
    public static SteamGame uSG = null;
    public static List<String> sUF = new ArrayList<String>();
    public static int sUFS = 0;
    public static List<SteamUGC.ItemInstallInfo> sUII = new ArrayList<SteamUGC.ItemInstallInfo>();
    public static int sUIIS = 0;
    public static List<String> sUFA = new ArrayList<String>();
    public static List<String> sUFAM = new ArrayList<String>();
    public static List<SteamUGC.ItemInstallInfo> sUIF = new ArrayList<SteamUGC.ItemInstallInfo>();
    public static List<String> sUTO = new ArrayList<String>();
    public static boolean sUInited = false;
    public static boolean DONE = false;

    public static final void init() {
    }

    public static void subscribedItems() {
        SteamPublishedFileID[] steamPublishedFileIDS = new SteamPublishedFileID[sU.getNumSubscribedItems()];
        int numSubscribed = sU.getSubscribedItems(steamPublishedFileIDS);
        if (steamPublishedFileIDS != null) {
            for (int i = 0; i < steamPublishedFileIDS.length; ++i) {
                SteamUGC.ItemInstallInfo itemInstallInfo = new SteamUGC.ItemInstallInfo();
                sU.getItemInstallInfo(steamPublishedFileIDS[i], itemInstallInfo);
                sUII.add(itemInstallInfo);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void createItem(String modFolder) {
        try {
            String fileContent;
            FileHandle fileList;
            DONE = false;
            if (FileManager.IS_MAC && Gdx.files.external("mods/" + modFolder + "/id.txt").exists()) {
                fileList = Gdx.files.external("mods/" + modFolder + "/id.txt");
                fileContent = fileList.readString();
                sUCP = new SteamPublishedFileID(Long.parseLong(fileContent));
            } else if (Gdx.files.internal("mods/" + modFolder + "/id.txt").exists()) {
                fileList = Gdx.files.internal("mods/" + modFolder + "/id.txt");
                fileContent = fileList.readString();
                sUCP = new SteamPublishedFileID(Long.parseLong(fileContent));
            } else {
                SteamAPICall steamAPICall = sU.createItem(3381680, SteamRemoteStorage.WorkshopFileType.Community);
                while (!DONE) {
                    SteamAPI.runCallbacks();
                    try {
                        Thread.sleep(250L);
                    }
                    catch (InterruptedException e) {
                        throw new SteamException(e);
                    }
                }
                try {
                    FileHandle fileSave = FileManager.getSaveType("mods/" + modFolder + "/id.txt");
                    fileSave.writeString("" + Long.parseLong(sUCP.toString(), 16), false);
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            Json json = new Json();
            FileHandle file = FileManager.IS_MAC ? Gdx.files.external("mods/" + modFolder + "/mod.txt") : Gdx.files.internal("mods/" + modFolder + "/mod.txt");
            ModData modData = json.fromJson(ModData.class, file);
            SteamUGCUpdateHandle updateHandle = sU.startItemUpdate(3381680, sUCP);
            String nPath = new FileHandle("mods/" + modFolder + "/").file().getAbsolutePath();
            sU.setItemContent(updateHandle, nPath);
            sU.setItemTitle(updateHandle, modData.Name);
            sU.setItemTags(updateHandle, modData.Tags);
            sU.setItemDescription(updateHandle, modData.Description);
            sU.setItemPreview(updateHandle, new FileHandle("mods/" + modFolder + "/logo.png").file().getAbsolutePath());
            sU.setItemVisibility(updateHandle, SteamRemoteStorage.PublishedFileVisibility.Public);
            sU.submitItemUpdate(updateHandle, modData.ChangeNote);
            SteamUGC.ItemUpdateInfo updateInfo = new SteamUGC.ItemUpdateInfo();
            sU.getItemUpdateProgress(updateHandle, updateInfo);
            DONE = false;
            while (!DONE) {
                SteamAPI.runCallbacks();
                sU.getItemUpdateProgress(updateHandle, updateInfo);
                CFG.toastM.addM("Progress: " + updateInfo.getBytesProcessed() + "/" + updateInfo.getBytesTotal());
                try {
                    Thread.sleep(250L);
                }
                catch (InterruptedException e) {
                    throw new SteamException(e);
                }
            }
        }
        catch (Exception ex) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            String sUX = sw.toString();
            CFG.toastM.addM(sUX);
            CFG.toastM.addM(sUX);
            CFG.exceptionStack(ex);
            DONE = true;
        }
    }

    public static void loadSubscribedItems() {
        try {
            if (sUQ && CFG.getIsDesktop() && sU != null) {
                int numItems = 0;
                try {
                    numItems = sU.getNumSubscribedItems();
                } catch (Throwable e) {
                    numItems = 0;
                    sUQ = false;
                }
                
                if (numItems > 0) {
                    SteamPublishedFileID[] steamPublishedFileIDS = new SteamPublishedFileID[numItems];
                    int numSubscribed = sU.getSubscribedItems(steamPublishedFileIDS);
                    if (steamPublishedFileIDS != null) {
                        for (int i = 0; i < steamPublishedFileIDS.length; ++i) {
                            SteamUGC.ItemInstallInfo itemInstallInfo = new SteamUGC.ItemInstallInfo();
                            sU.getItemInstallInfo(steamPublishedFileIDS[i], itemInstallInfo);
                            sUII.add(itemInstallInfo);
                        }
                        sUIIS = sUII.size();
                    }
                }
            }
        }
        catch (Throwable steamPublishedFileIDS) {
            sUQ = false;
        }
        try {
            FileHandle[] files = FileManager.IS_MAC ? Gdx.files.external("mods/").list() : Gdx.files.local("mods/").list();
            for (FileHandle file : files) {
                sUF.add("mods/" + file.name() + "/");
            }
            sUFS = sUF.size();
        }
        catch (Exception exception) {
            // empty catch block
        }
        sUM.readModsTurnedOff();
    }

    public static void addModsTurnedOff(String folder) {
        if (folder != null && folder.length() > 0) {
            if (!sUTO.contains(folder)) {
                sUTO.add(folder);
            } else {
                sUM.removeModsTurnedOff(folder);
            }
            sUM.saveModsTurnedOff();
        }
    }

    public static void removeModsTurnedOff(String folder) {
        if (folder.length() > 0) {
            for (int i = sUTO.size() - 1; i >= 0; --i) {
                if (!sUTO.get(i).equals(folder)) continue;
                sUTO.remove(i);
                sUM.saveModsTurnedOff();
                return;
            }
        }
    }

    public static boolean isTurnedOn(String folder) {
        if (folder != null && folder.length() > 0) {
            for (int i = sUTO.size() - 1; i >= 0; --i) {
                if (!sUTO.get(i).equals(folder)) continue;
                return false;
            }
        }
        return true;
    }

    public static void saveModsTurnedOff() {
        FileHandle fileSave = FileManager.getSaveType("settings/ModsOff.txt");
        if (sUTO.isEmpty()) {
            if (FileManager.getSaveType("settings/ModsOff.txt").exists()) {
                FileManager.getSaveType("settings/ModsOff.txt").delete();
            }
        } else {
            for (int i = 0; i < sUTO.size(); ++i) {
                fileSave.writeString(sUTO.get(i) + ";", i != 0);
            }
        }
    }

    public static void unlockAchievement(String key) {
        try {
            sUI.setAchievement(key);
            sUI.storeStats();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static void readModsTurnedOff() {
        int j;
        for (j = 0; j < sUF.size(); ++j) {
            sUFA.add(sUF.get(j));
        }
        for (j = 0; j < sUII.size(); ++j) {
            sUIF.add(sUII.get(j));
            try {
                if (!Gdx.files.absolute(sUII.get(j).getFolder() + "/mod.txt").exists()) continue;
                FileHandle file = Gdx.files.absolute(sUII.get(j).getFolder() + "/mod.txt");
                String tempTags = file.readString();
                Pattern pattern = Pattern.compile("Name:\\s*\"(.*?)\"");
                Matcher matcher = pattern.matcher(tempTags);
                if (matcher.find()) {
                    String name = matcher.group(1);
                    sUFAM.add(name);
                    continue;
                }
                sUFAM.add(sUII.get(j).getFolder());
                continue;
            }
            catch (Exception ex) {
                sUFAM.add(sUII.get(j).getFolder());
            }
        }
        try {
            if (Gdx.files.internal("settings/ModsOff.txt").exists() || FileManager.IS_MAC && Gdx.files.external("settings/ModsOff.txt").exists()) {
                int i;
                FileHandle file = FileManager.IS_MAC ? Gdx.files.external("settings/ModsOff.txt") : Gdx.files.internal("settings/ModsOff.txt");
                String tempTags = file.readString();
                sUTO.clear();
                String[] split = tempTags.split(";");
                for (i = 0; i < split.length; ++i) {
                    sUTO.add(split[i]);
                }
                block7: for (i = 0; i < sUTO.size(); ++i) {
                    int j2;
                    for (j2 = sUF.size() - 1; j2 >= 0; --j2) {
                        if (!sUTO.get(i).equals(sUF.get(j2))) continue;
                        sUF.remove(j2);
                        break;
                    }
                    for (j2 = sUII.size() - 1; j2 >= 0; --j2) {
                        if (!sUTO.get(i).equals(sUII.get(j2).getFolder())) continue;
                        sUII.remove(j2);
                        continue block7;
                    }
                }
                sUFS = sUF.size();
                sUIIS = sUII.size();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static class ModData {
        public String Name;
        public String Description;
        public String[] Tags;
        public String ChangeNote;
    }
}

