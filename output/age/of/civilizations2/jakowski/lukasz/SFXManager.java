
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SFXManager {
    private static final String CONSOLE_MUSIC_TITLE = "Scheming_Weasel." + (CFG.isIOS() ? "mp3" : "ogg");
    public static boolean isPlayingConsoleMusic = false;
    private static final String START_MUSIC = "Impact_Allegretto." + (CFG.isIOS() ? "mp3" : "ogg");
    public int stationID = 0;
    public List<List<String>> lTitles;
    public List<String> lStations = new ArrayList<String>();
    private Music currentMusic = null;
    private float musicVolume = 0.4f;
    public int iCurrentMusicID = 0;
    private List<Sound> lSounds;
    private float soundsVolume = 0.55f;
    private float masterVolume = 0.0f;
    public static int SFX_CLICK;
    public static int SFX_CLICK2;
    public static int SFX_CLICK3;
    public static int SFX_PROVINCE;
    public static int SFX_NUKE;
    public static int SFX_ACTION_MOVE;
    public static int SFX_MOVE_ARMY;
    public static int SFX_MOVE_ARMY2;
    public static int SFX_MOVE_REGROUP;
    public static int SFX_MOVE_ARMY_0;
    public static int SFX_MOVE_ARMY_1;
    public static int SFX_MOVE_ARMY_2;
    public static int SFX_MOVE_ARMY_3;
    public static int SFX_MOVE_ARMY_4;
    public static int SFX_RECRUIT;
    public static int SFX_GOLD;
    public static int SFX_DIPLOMACY;
    public static int SFX_TECHNOLOGY;
    public static int SFX_WAR;
    public static int SFX_WAR2;
    public static int SFX_BUILD;
    public static int SFX_PLUNDER;
    public static int SFX_CROW;
    public static int SFX_START;
    public static int SFX_SEND;
    public static int SFX_SEND2;
    public static int SFX_SEND3;
    public static int SFX_SEND4;
    public static int SFX_EVENT;
    public static int SFX_ASSIMILATE;
    public static int SFX_WORKSHOP;
    public static int SFX_FARM;
    public static int SFX_PORT;
    public static int SFX_SUPPLY;
    public static int SFX_LIBRARY;
    public static int SFX_RANDOM;
    public static float PERC_VOLUME_SELECT_PROVINCE;
    public static float PERC_VOLUME_KEYBOARD;
    public static String RADIO_PATH;
    public static String RADIO_STATIONS_FILE;
    public static String RADIO_LIST_FILE;

    
    public SFXManager() {
        this.lTitles = new ArrayList<List<String>>();
        this.lSounds = new ArrayList<Sound>();
        ArrayList menuElements = new ArrayList();
        SFX_CLICK = this.addSound("click." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_CLICK2 = this.addSound("click2." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_CLICK3 = this.addSound("click3." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_PROVINCE = SFX_CLICK;
        SFX_NUKE = this.addSound("nuke." + (CFG.isIOS() ? "mp3" : "ogg"));
        this.lStations.add("Age of History 2: Definitive Edition");
        try {
            FileHandle tempFileT = FileManager.loadFile("music/Age_of_Civilizations");
            String tempT = tempFileT.readString();
            String[] tagsSPLITED = tempT.split(";");
            ArrayList<String> titlesDefault = new ArrayList<String>();
            for (int i = 0; i < tagsSPLITED.length; ++i) {
                titlesDefault.add(tagsSPLITED[i]);
            }
            this.lTitles.add(titlesDefault);
        }
        catch (GdxRuntimeException ex) {
            try {
                FileHandle tempFileT = Gdx.files.local("music/Age_of_Civilizations");
                String tempT = tempFileT.readString();
                String[] tagsSPLITED = tempT.split(";");
                ArrayList<String> titlesDefault = new ArrayList<String>();
                for (int i = 0; i < tagsSPLITED.length; ++i) {
                    titlesDefault.add(tagsSPLITED[i]);
                }
                this.lTitles.add(titlesDefault);
            }
            catch (GdxRuntimeException tempFileT) {
                
            }
        }
        try {
            int a;
            ArrayList<String> titlesStation;
            String[] tagsSPLITED;
            String tempT;
            int z;
            String[] stationsSplit;
            String tempT2;
            FileHandle tempFileT2;
            int i = 0;
            while (true) {
                block24: {
                    block25: {
                        block23: {
                            block22: {
                                if (i >= sUM.sUFS) break;
                                if (!Gdx.files.external(sUM.sUF.get(i) + RADIO_PATH + RADIO_STATIONS_FILE).exists()) break block22;
                                tempFileT2 = Gdx.files.external(sUM.sUF.get(i) + RADIO_PATH + RADIO_STATIONS_FILE);
                                tempT2 = tempFileT2.readString();
                                stationsSplit = tempT2.split(";");
                                break block23;
                            }
                            if (!Gdx.files.internal(sUM.sUF.get(i) + RADIO_PATH + RADIO_STATIONS_FILE).exists()) break block24;
                            tempFileT2 = Gdx.files.internal(sUM.sUF.get(i) + RADIO_PATH + RADIO_STATIONS_FILE);
                            tempT2 = tempFileT2.readString();
                            stationsSplit = tempT2.split(";");
                            break block25;
                        }
                        for (z = 0; z < stationsSplit.length; ++z) {
                            if (!Gdx.files.external(sUM.sUF.get(i) + RADIO_PATH + stationsSplit[z] + "/" + RADIO_LIST_FILE).exists()) continue;
                            try {
                                FileHandle tempFileT = Gdx.files.external(sUM.sUF.get(i) + RADIO_PATH + stationsSplit[z] + "/" + RADIO_LIST_FILE);
                                tempT = tempFileT.readString();
                                tagsSPLITED = tempT.split(";");
                                titlesStation = new ArrayList<String>();
                                for (a = 0; a < tagsSPLITED.length; ++a) {
                                    titlesStation.add(tagsSPLITED[a]);
                                }
                                this.lTitles.add(titlesStation);
                                this.lStations.add(stationsSplit[z]);
                                continue;
                            }
                            catch (Exception exr) {
                                CFG.exceptionStack(exr);
                            }
                        }
                        break block24;
                    }
                    for (z = 0; z < stationsSplit.length; ++z) {
                        if (!Gdx.files.internal(sUM.sUF.get(i) + RADIO_PATH + stationsSplit[z] + "/" + RADIO_LIST_FILE).exists()) continue;
                        try {
                            FileHandle tempFileT = Gdx.files.internal(sUM.sUF.get(i) + RADIO_PATH + stationsSplit[z] + "/" + RADIO_LIST_FILE);
                            tempT = tempFileT.readString();
                            tagsSPLITED = tempT.split(";");
                            titlesStation = new ArrayList();
                            for (a = 0; a < tagsSPLITED.length; ++a) {
                                titlesStation.add(tagsSPLITED[a]);
                            }
                            this.lTitles.add(titlesStation);
                            this.lStations.add(stationsSplit[z]);
                            continue;
                        }
                        catch (Exception exr) {
                            CFG.exceptionStack(exr);
                        }
                    }
                }
                ++i;
            }
            for (i = 0; i < sUM.sUIIS; ++i) {
                if (!Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + RADIO_PATH + RADIO_STATIONS_FILE).exists()) continue;
                tempFileT2 = Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + RADIO_PATH + RADIO_STATIONS_FILE);
                tempT2 = tempFileT2.readString();
                stationsSplit = tempT2.split(";");
                for (z = 0; z < stationsSplit.length; ++z) {
                    if (!Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + RADIO_PATH + stationsSplit[z] + "/" + RADIO_LIST_FILE).exists()) continue;
                    try {
                        FileHandle tempFileT = Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + RADIO_PATH + stationsSplit[z] + "/" + RADIO_LIST_FILE);
                        tempT = tempFileT.readString();
                        tagsSPLITED = tempT.split(";");
                        titlesStation = new ArrayList();
                        for (a = 0; a < tagsSPLITED.length; ++a) {
                            titlesStation.add(tagsSPLITED[a]);
                        }
                        this.lTitles.add(titlesStation);
                        this.lStations.add(stationsSplit[z]);
                        continue;
                    }
                    catch (Exception exr) {
                        CFG.exceptionStack(exr);
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        this.randomizePlayList();
        this.loadNextMusic();
        SFX_MOVE_ARMY = this.addSound("move_army." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_MOVE_ARMY2 = this.addSound("move_army2." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_MOVE_REGROUP = this.addSound("move_army_re." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_MOVE_ARMY_0 = this.addSound("move0." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_MOVE_ARMY_1 = this.addSound("move1." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_MOVE_ARMY_2 = this.addSound("move2." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_MOVE_ARMY_3 = this.addSound("move3." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_MOVE_ARMY_4 = this.addSound("move4." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_GOLD = this.addSound("gold2." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_DIPLOMACY = this.addSound("diplomacy." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_TECHNOLOGY = this.addSound("technology." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_ACTION_MOVE = this.addSound("action_move." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_RECRUIT = this.addSound("metal." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_WAR = this.addSound("war." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_WAR2 = this.addSound("war2." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_BUILD = this.addSound("build." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_START = this.addSound("start." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_SEND = this.addSound("send." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_SEND2 = this.addSound("send2." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_SEND3 = this.addSound("send3." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_SEND4 = this.addSound("send4." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_EVENT = this.addSound("event." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_PLUNDER = this.addSound("plunder." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_CROW = this.addSound("crow." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_ASSIMILATE = this.addSound("assimilate." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_WORKSHOP = this.addSound("workshop." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_FARM = this.addSound("farm." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_PORT = this.addSound("port." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_SUPPLY = this.addSound("supply." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_LIBRARY = this.addSound("library." + (CFG.isIOS() ? "mp3" : "ogg"));
        SFX_RANDOM = this.addSound("random." + (CFG.isIOS() ? "mp3" : "ogg"));
        this.masterVolume = CFG.settingsGD.VOLUME_MASTER;
        this.setSoundsVolume(CFG.settingsGD.VOLUME_SOUNDS);
        this.setMusicVolume(CFG.settingsGD.VOLUME_MUSIC);
    }

    public final void randomizePlayList() {
        Random oR = new Random();
        ArrayList<String> tempList = new ArrayList<String>();
        for (int i = 0; i < this.lTitles.get(this.stationID).size(); ++i) {
            tempList.add(this.lTitles.get(this.stationID).get(i));
        }
        this.lTitles.get(this.stationID).clear();
        ArrayList<String> titles = new ArrayList<String>();
        while (!tempList.isEmpty()) {
            int tempR = oR.nextInt(tempList.size());
            titles.add((String)tempList.get(tempR));
            tempList.remove(tempR);
        }
        this.lTitles.set(this.stationID, titles);
    }

    public final void loadNextMusic() {
        block18: {
            try {
                this.disposeCurrentMusic();
                ++this.iCurrentMusicID;
                if (this.iCurrentMusicID >= this.lTitles.get(this.stationID).size()) {
                    this.iCurrentMusicID = 0;
                    this.randomizePlayList();
                }
                try {
                    if (FileManager.loadFile("music/" + this.lTitles.get(this.stationID).get(this.iCurrentMusicID)).exists()) {
                        this.currentMusic = Gdx.audio.newMusic(FileManager.loadFile("music/" + this.lTitles.get(this.stationID).get(this.iCurrentMusicID)));
                        this.currentMusic.setLooping(false);
                        this.currentMusic.play();
                        this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                        this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                            @Override
                            public void onCompletion(Music music) {
                                SFXManager.this.loadNextMusic();
                            }
                        });
                        isPlayingConsoleMusic = false;
                        try {
                            CFG.toastM.addM(this.getCurrentMusicTittle(), CFG.COLOR_NEUTRAL2);
                            CFG.toastM.setTimeInView(3500);
                        }
                        catch (Exception exception) {}
                        break block18;
                    }
                    if (Gdx.files.local("music/" + this.lTitles.get(this.stationID).get(this.iCurrentMusicID)).exists()) {
                        this.currentMusic = Gdx.audio.newMusic(Gdx.files.local("music/" + this.lTitles.get(this.stationID).get(this.iCurrentMusicID)));
                        this.currentMusic.setLooping(false);
                        this.currentMusic.play();
                        this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                        this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                            @Override
                            public void onCompletion(Music music) {
                                SFXManager.this.loadNextMusic();
                            }
                        });
                        isPlayingConsoleMusic = false;
                        try {
                            CFG.toastM.addM(this.getCurrentMusicTittle(), CFG.COLOR_NEUTRAL2);
                            CFG.toastM.setTimeInView(3500);
                        }
                        catch (Exception exception) {}
                        break block18;
                    }
                    for (int z = this.lStations.size() - 1; z > 0; --z) {
                        if (!FileManager.loadFile(RADIO_PATH + this.lStations.get(z) + "/" + this.lTitles.get(this.stationID).get(this.iCurrentMusicID)).exists()) continue;
                        this.currentMusic = Gdx.audio.newMusic(FileManager.loadFile(RADIO_PATH + this.lStations.get(z) + "/" + this.lTitles.get(this.stationID).get(this.iCurrentMusicID)));
                        this.currentMusic.setLooping(false);
                        this.currentMusic.play();
                        this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                        this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                            @Override
                            public void onCompletion(Music music) {
                                SFXManager.this.loadNextMusic();
                            }
                        });
                        isPlayingConsoleMusic = false;
                        try {
                            CFG.toastM.addM(this.getCurrentMusicTittle(), CFG.COLOR_NEUTRAL2);
                            CFG.toastM.setTimeInView(3500);
                        }
                        catch (Exception exception) {}
                        break;
                    }
                }
                catch (Exception ex) {
                    try {
                        this.currentMusic = Gdx.audio.newMusic(Gdx.files.local("music/" + this.lTitles.get(this.stationID).get(this.iCurrentMusicID)));
                        this.currentMusic.setLooping(false);
                        this.currentMusic.play();
                        this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                        this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                            @Override
                            public void onCompletion(Music music) {
                                SFXManager.this.loadNextMusic();
                            }
                        });
                        isPlayingConsoleMusic = false;
                        try {
                            CFG.toastM.addM(this.getCurrentMusicTittle(), CFG.COLOR_NEUTRAL2);
                            CFG.toastM.setTimeInView(3500);
                        }
                        catch (Exception exception) {
                        }
                    }
                    catch (Exception exception) {}
                }
            }
            catch (Exception exception) {
                
            }
        }
    }

    public final void loadPreviousMusic() {
        block19: {
            try {
                this.disposeCurrentMusic();
                --this.iCurrentMusicID;
                if (this.iCurrentMusicID < 0) {
                    this.iCurrentMusicID = 0;
                }
                if (this.iCurrentMusicID >= this.lTitles.get(this.stationID).size()) {
                    this.iCurrentMusicID = 0;
                    this.randomizePlayList();
                }
                try {
                    if (FileManager.loadFile("music/" + this.lTitles.get(this.stationID).get(this.iCurrentMusicID)).exists()) {
                        this.currentMusic = Gdx.audio.newMusic(FileManager.loadFile("music/" + this.lTitles.get(this.stationID).get(this.iCurrentMusicID)));
                        this.currentMusic.setLooping(false);
                        this.currentMusic.play();
                        this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                        this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                            @Override
                            public void onCompletion(Music music) {
                                SFXManager.this.loadNextMusic();
                            }
                        });
                        isPlayingConsoleMusic = false;
                        try {
                            CFG.toastM.addM(this.getCurrentMusicTittle(), CFG.COLOR_NEUTRAL2);
                            CFG.toastM.setTimeInView(3500);
                        }
                        catch (Exception exception) {}
                        break block19;
                    }
                    if (Gdx.files.local("music/" + this.lTitles.get(this.stationID).get(this.iCurrentMusicID)).exists()) {
                        this.currentMusic = Gdx.audio.newMusic(Gdx.files.local("music/" + this.lTitles.get(this.stationID).get(this.iCurrentMusicID)));
                        this.currentMusic.setLooping(false);
                        this.currentMusic.play();
                        this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                        this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                            @Override
                            public void onCompletion(Music music) {
                                SFXManager.this.loadNextMusic();
                            }
                        });
                        isPlayingConsoleMusic = false;
                        try {
                            CFG.toastM.addM(this.getCurrentMusicTittle(), CFG.COLOR_NEUTRAL2);
                            CFG.toastM.setTimeInView(3500);
                        }
                        catch (Exception exception) {}
                        break block19;
                    }
                    for (int z = this.lStations.size() - 1; z > 0; --z) {
                        if (!FileManager.loadFile(RADIO_PATH + this.lStations.get(z) + "/" + this.lTitles.get(this.stationID).get(this.iCurrentMusicID)).exists()) continue;
                        this.currentMusic = Gdx.audio.newMusic(FileManager.loadFile(RADIO_PATH + this.lStations.get(z) + "/" + this.lTitles.get(this.stationID).get(this.iCurrentMusicID)));
                        this.currentMusic.setLooping(false);
                        this.currentMusic.play();
                        this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                        this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                            @Override
                            public void onCompletion(Music music) {
                                SFXManager.this.loadNextMusic();
                            }
                        });
                        isPlayingConsoleMusic = false;
                        try {
                            CFG.toastM.addM(this.getCurrentMusicTittle(), CFG.COLOR_NEUTRAL2);
                            CFG.toastM.setTimeInView(3500);
                        }
                        catch (Exception exception) {}
                        break;
                    }
                }
                catch (Exception ex) {
                    try {
                        this.currentMusic = Gdx.audio.newMusic(Gdx.files.local("music/" + this.lTitles.get(this.stationID).get(this.iCurrentMusicID)));
                        this.currentMusic.setLooping(false);
                        this.currentMusic.play();
                        this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                        this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                            @Override
                            public void onCompletion(Music music) {
                                SFXManager.this.loadNextMusic();
                            }
                        });
                        isPlayingConsoleMusic = false;
                        try {
                            CFG.toastM.addM(this.getCurrentMusicTittle(), CFG.COLOR_NEUTRAL2);
                            CFG.toastM.setTimeInView(3500);
                        }
                        catch (Exception exception) {
                        }
                    }
                    catch (Exception exception) {}
                }
            }
            catch (Exception exception) {
                
            }
        }
    }

    public final void loadNextMusic_Default(String fileName) {
        try {
            block10: {
                try {
                    if (FileManager.loadFile("music/" + fileName).exists()) {
                        this.disposeCurrentMusic();
                        ++this.iCurrentMusicID;
                        if (this.iCurrentMusicID >= this.lTitles.get(this.stationID).size()) {
                            this.iCurrentMusicID = 0;
                            this.randomizePlayList();
                        }
                        this.currentMusic = Gdx.audio.newMusic(FileManager.loadFile("music/" + fileName));
                        this.currentMusic.setLooping(false);
                        this.currentMusic.play();
                        this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                        this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                            @Override
                            public void onCompletion(Music music) {
                                SFXManager.this.loadNextMusic();
                            }
                        });
                        break block10;
                    }
                    if (Gdx.files.local("music/" + fileName).exists()) {
                        this.disposeCurrentMusic();
                        ++this.iCurrentMusicID;
                        if (this.iCurrentMusicID >= this.lTitles.get(this.stationID).size()) {
                            this.iCurrentMusicID = 0;
                            this.randomizePlayList();
                        }
                        this.currentMusic = Gdx.audio.newMusic(Gdx.files.local("music/" + fileName));
                        this.currentMusic.setLooping(false);
                        this.currentMusic.play();
                        this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                        this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                            @Override
                            public void onCompletion(Music music) {
                                SFXManager.this.loadNextMusic();
                            }
                        });
                        break block10;
                    }
                    for (int z = this.lStations.size() - 1; z > 0; --z) {
                        if (!FileManager.loadFile(RADIO_PATH + this.lStations.get(z) + "/" + fileName).exists()) continue;
                        this.disposeCurrentMusic();
                        ++this.iCurrentMusicID;
                        if (this.iCurrentMusicID >= this.lTitles.get(this.stationID).size()) {
                            this.iCurrentMusicID = 0;
                            this.randomizePlayList();
                        }
                        this.currentMusic = Gdx.audio.newMusic(FileManager.loadFile(RADIO_PATH + this.lStations.get(z) + "/" + fileName));
                        this.currentMusic.setLooping(false);
                        this.currentMusic.play();
                        this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                        this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                            @Override
                            public void onCompletion(Music music) {
                                SFXManager.this.loadNextMusic();
                            }
                        });
                        break;
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            return;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            return;
        }
    }

    public final void loadNextMusic(String fileName) {
        try {
            try {
                if (FileManager.loadFile("audio/" + fileName).exists()) {
                    this.disposeCurrentMusic();
                    ++this.iCurrentMusicID;
                    if (this.iCurrentMusicID >= this.lTitles.get(this.stationID).size()) {
                        this.iCurrentMusicID = 0;
                        this.randomizePlayList();
                    }
                    this.currentMusic = Gdx.audio.newMusic(FileManager.loadFile("audio/" + fileName));
                    this.currentMusic.setLooping(false);
                    this.currentMusic.play();
                    this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                    this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                        @Override
                        public void onCompletion(Music music) {
                            SFXManager.this.loadNextMusic();
                        }
                    });
                } else if (Gdx.files.local("audio/" + fileName).exists()) {
                    this.disposeCurrentMusic();
                    ++this.iCurrentMusicID;
                    if (this.iCurrentMusicID >= this.lTitles.get(this.stationID).size()) {
                        this.iCurrentMusicID = 0;
                        this.randomizePlayList();
                    }
                    this.currentMusic = Gdx.audio.newMusic(Gdx.files.local("audio/" + fileName));
                    this.currentMusic.setLooping(false);
                    this.currentMusic.play();
                    this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                    this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                        @Override
                        public void onCompletion(Music music) {
                            SFXManager.this.loadNextMusic();
                        }
                    });
                } else if (FileManager.loadFile("music/" + fileName).exists()) {
                    this.disposeCurrentMusic();
                    ++this.iCurrentMusicID;
                    if (this.iCurrentMusicID >= this.lTitles.get(this.stationID).size()) {
                        this.iCurrentMusicID = 0;
                        this.randomizePlayList();
                    }
                    this.currentMusic = Gdx.audio.newMusic(FileManager.loadFile("music/" + fileName));
                    this.currentMusic.setLooping(false);
                    this.currentMusic.play();
                    this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                    this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                        @Override
                        public void onCompletion(Music music) {
                            SFXManager.this.loadNextMusic();
                        }
                    });
                } else if (Gdx.files.local("music/" + fileName).exists()) {
                    this.disposeCurrentMusic();
                    ++this.iCurrentMusicID;
                    if (this.iCurrentMusicID >= this.lTitles.get(this.stationID).size()) {
                        this.iCurrentMusicID = 0;
                        this.randomizePlayList();
                    }
                    this.currentMusic = Gdx.audio.newMusic(Gdx.files.local("music/" + fileName));
                    this.currentMusic.setLooping(false);
                    this.currentMusic.play();
                    this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
                    this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                        @Override
                        public void onCompletion(Music music) {
                            SFXManager.this.loadNextMusic();
                        }
                    });
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            return;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            return;
        }
    }

    public final void playConsoleMusic() {
        try {
            this.disposeCurrentMusic();
            this.currentMusic = Gdx.audio.newMusic(FileManager.loadFile("music/" + CONSOLE_MUSIC_TITLE));
            this.currentMusic.setLooping(false);
            this.currentMusic.play();
            this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
            this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                @Override
                public void onCompletion(Music music) {
                    SFXManager.this.loadNextMusic();
                }
            });
            isPlayingConsoleMusic = true;
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
    }

    public final void playStartMusic() {
        try {
            this.disposeCurrentMusic();
            this.currentMusic = Gdx.audio.newMusic(FileManager.loadFile("music/" + START_MUSIC));
            this.currentMusic.setLooping(false);
            this.currentMusic.play();
            this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
            this.currentMusic.setOnCompletionListener(new Music.OnCompletionListener(){

                @Override
                public void onCompletion(Music music) {
                    SFXManager.this.loadNextMusic();
                }
            });
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            
        }
    }

    public final void disposeCurrentMusic() {
        if (this.currentMusic != null) {
            this.currentMusic.stop();
            this.currentMusic.dispose();
        }
    }

    public final int addSound(String fileName) {
        try {
            this.lSounds.add(Gdx.audio.newSound(FileManager.loadFile("sounds/" + fileName)));
        }
        catch (GdxRuntimeException ex) {
            ex.printStackTrace();
            try {
                this.lSounds.add(Gdx.audio.newSound(Gdx.files.local("sounds/" + fileName)));
            }
            catch (GdxRuntimeException exr) {
                ex.printStackTrace();
            }
        }
        return this.lSounds.size() - 1;
    }

    public final void playSound(int id) {
        this.playSound(id, 1.0f);
    }

    public final void playSound(int id, float fPercOfVolume) {
        this.lSounds.get(id).stop();
        this.lSounds.get(id).play(this.soundsVolume * this.masterVolume * fPercOfVolume);
    }

    public final int playMoveArmy() {
        int tID = CFG.oR.nextInt(174) % 7;
        switch (tID) {
            case 1: {
                return SFX_MOVE_ARMY2;
            }
            case 2: {
                return SFX_MOVE_ARMY_0;
            }
            case 3: {
                return SFX_MOVE_ARMY_1;
            }
            case 4: {
                return SFX_MOVE_ARMY_2;
            }
            case 5: {
                return SFX_MOVE_ARMY_3;
            }
            case 6: {
                return SFX_MOVE_ARMY_4;
            }
        }
        return SFX_MOVE_ARMY;
    }

    public final int playMoveArmyRegroup() {
        int tID = CFG.oR.nextInt(174) % 8;
        switch (tID) {
            case 1: {
                return SFX_MOVE_ARMY2;
            }
            case 2: {
                return SFX_MOVE_ARMY_0;
            }
            case 3: {
                return SFX_MOVE_ARMY_1;
            }
            case 4: {
                return SFX_MOVE_ARMY_2;
            }
            case 5: {
                return SFX_MOVE_ARMY_3;
            }
            case 6: {
                return SFX_MOVE_ARMY_4;
            }
            case 7: {
                return SFX_MOVE_REGROUP;
            }
        }
        return SFX_MOVE_ARMY;
    }

    public final String getCurrentMusicTittle() {
        return this.lTitles.get(this.stationID).get(this.iCurrentMusicID).substring(0, this.lTitles.get(this.stationID).get(this.iCurrentMusicID).indexOf("." + (CFG.isIOS() ? "mp3" : "ogg")) > 0 ? this.lTitles.get(this.stationID).get(this.iCurrentMusicID).indexOf("." + (CFG.isIOS() ? "mp3" : "ogg")) : this.lTitles.get(this.stationID).get(this.iCurrentMusicID).length()).replace("_", " ");
    }

    public final void setMusicVolume(float nMusicVolume) {
        this.musicVolume = nMusicVolume;
        try {
            this.currentMusic.setVolume(this.musicVolume * this.masterVolume);
            if (this.musicVolume < 0.01f) {
                this.currentMusic.pause();
            } else if (!this.currentMusic.isPlaying()) {
                this.currentMusic.play();
            }
        }
        catch (NullPointerException nullPointerException) {
            
        }
    }

    public final float getMusicVolume() {
        return this.musicVolume;
    }

    public final void setSoundsVolume(float soundsVolume) {
        this.soundsVolume = soundsVolume;
    }

    public final float getSoundsVolume() {
        return this.soundsVolume;
    }

    public final void setMasterVolume(float masterVolume) {
        this.masterVolume = masterVolume;
        this.setMusicVolume(this.getMusicVolume());
    }

    public final float getMasterVolume() {
        return this.masterVolume;
    }

    public final void dispose() {
        for (int i = 0; i < this.lSounds.size(); ++i) {
            this.lSounds.get(i).dispose();
        }
        this.currentMusic.dispose();
    }

    public static final int getSend() {
        switch (CFG.oR.nextInt(4)) {
            case 0: {
                return SFX_SEND;
            }
            case 1: {
                return SFX_SEND2;
            }
            case 2: {
                return SFX_SEND3;
            }
        }
        return SFX_SEND4;
    }

    static {
        PERC_VOLUME_SELECT_PROVINCE = 0.95f;
        PERC_VOLUME_KEYBOARD = 0.9f;
        RADIO_PATH = "radio/";
        RADIO_STATIONS_FILE = "stations.txt";
        RADIO_LIST_FILE = "list.txt";
    }
}

