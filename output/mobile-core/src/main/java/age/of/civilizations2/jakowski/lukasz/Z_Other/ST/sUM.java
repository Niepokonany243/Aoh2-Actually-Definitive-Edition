package age.of.civilizations2.jakowski.lukasz.Z_Other.ST;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/** Steam-free compatibility state for legacy content and UI callers on mobile. */
public final class sUM {
    public static final MobileUtils sUT = new MobileUtils();
    public static final MobileStats sUI = new MobileStats();
    public static final MobileSocial uSF = new MobileSocial();
    public static final MobileRemoteStorage sUR = new MobileRemoteStorage();
    public static final List<String> sUF = new ArrayList<String>();
    public static final List<InstalledMod> sUII = new ArrayList<InstalledMod>();
    public static final List<String> sUFA = new ArrayList<String>();
    public static final List<String> sUFAM = new ArrayList<String>();
    public static final List<InstalledMod> sUIF = new ArrayList<InstalledMod>();
    public static final List<String> sUTO = new ArrayList<String>();
    public static int sUFS;
    public static int sUIIS;
    public static boolean DONE;

    private sUM() {
    }

    public static void init() {
    }

    public static void subscribedItems() {
    }

    public static void createItem(String modFolder) {
        DONE = true;
        if (CFG.toastM != null) {
            CFG.toastM.addM("Workshop publishing is not available on mobile");
        }
    }

    public static void loadSubscribedItems() {
        sUF.clear();
        try {
            FileHandle[] files = Gdx.files.local("mods/").list();
            for (FileHandle file : files) {
                if (file.isDirectory()) {
                    sUF.add("mods/" + file.name() + "/");
                }
            }
        } catch (Exception ignored) {
        }
        sUFS = sUF.size();
        readModsTurnedOff();
    }

    public static void addModsTurnedOff(String folder) {
        if (folder == null || folder.isEmpty()) {
            return;
        }
        if (!sUTO.remove(folder)) {
            sUTO.add(folder);
        }
        saveModsTurnedOff();
    }

    public static void removeModsTurnedOff(String folder) {
        if (folder != null && sUTO.remove(folder)) {
            saveModsTurnedOff();
        }
    }

    public static boolean isTurnedOn(String folder) {
        return folder == null || !sUTO.contains(folder);
    }

    public static void saveModsTurnedOff() {
        FileHandle file = FileManager.getSaveType("settings/ModsOff.txt");
        if (sUTO.isEmpty()) {
            if (file.exists()) file.delete();
            return;
        }
        for (int i = 0; i < sUTO.size(); ++i) {
            file.writeString(sUTO.get(i) + ";", i != 0);
        }
    }

    public static void unlockAchievement(String key) {
    }

    public static void readModsTurnedOff() {
        sUFA.clear();
        sUFA.addAll(sUF);
        sUTO.clear();
        FileHandle file = FileManager.getSaveType("settings/ModsOff.txt");
        if (file.exists()) {
            String value = file.readString();
            for (String folder : value.split(";")) {
                if (!folder.isEmpty()) sUTO.add(folder);
            }
            sUF.removeAll(sUTO);
        }
        sUFS = sUF.size();
        sUIIS = 0;
    }

    public static final class InstalledMod {
        private final String folder;

        public InstalledMod(String folder) {
            this.folder = folder;
        }

        public String getFolder() {
            return folder;
        }
    }

    public static final class MobileUtils {
        public int getImageWidth(int image) { return 0; }
        public int getImageHeight(int image) { return 0; }
        public int getAppID() { return 0; }
        public boolean isOverlayEnabled() { return false; }
        public void dispose() { }
    }

    public static final class MobileStats {
        public boolean storeStats() { return false; }
        public boolean requestCurrentStats() { return false; }
        public int getStatI(String key, int defaultValue) { return defaultValue; }
        public float getStatF(String key, float defaultValue) { return defaultValue; }
        public boolean setStatI(String key, int value) { return false; }
        public boolean setStatF(String key, float value) { return false; }
        public boolean setAchievement(String key) { return false; }
        public boolean clearAchievement(String key) { return false; }
        public void dispose() { }
    }

    public static final class MobileSocial {
        public String getPersonaName() { return ""; }
        public boolean setRichPresence(String key, String value) { return false; }
        public void clearRichPresence() { }
    }

    public static final class MobileRemoteStorage {
        public boolean fileWrite(String name, ByteBuffer data) { return false; }
        public int fileRead(String name, ByteBuffer buffer) { return -1; }
        public boolean fileDelete(String name) { return false; }
        public boolean fileExists(String name) { return false; }
        public int getFileSize(String name) { return 0; }
        public int getFileCount() { return 0; }
        public String getFileNameAndSize(int index, int[] size) { return null; }
        public boolean fileForget(String name) { return false; }
        public boolean filePersisted(String name) { return false; }
    }
}
