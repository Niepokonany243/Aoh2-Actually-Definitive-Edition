/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.MapBG;
import age.of.civilizations2.jakowski.lukasz.MapCoords;
import age.of.civilizations2.jakowski.lukasz.MapOv;
import age.of.civilizations2.jakowski.lukasz.MapScale;
import age.of.civilizations2.jakowski.lukasz.MapScroll;
import age.of.civilizations2.jakowski.lukasz.Map_Continents;
import age.of.civilizations2.jakowski.lukasz.Map_Regions;
import age.of.civilizations2.jakowski.lukasz.Save.SaveActiveMap_GameData;
import age.of.civilizations2.jakowski.lukasz.TouchManager;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Map {
    private int activeMapID = 0;
    private List<String> sMAP_TAGS;
    private List<String> sMAP_LANG_KEY;
    private List<Integer> iMAP_NUM_OF_PROVINCES;
    private List<Integer> iMAP_SCALE;
    private List<Integer> iMAP_SCALE_PRE_EXTRA;
    private List<Float> iMAP_EXTRA_SCALE;
    private List<Integer> iMAP_DEFAULT_SCALE;
    private List<String> sMAP_BACKGROUND_NAME;
    private List<String> sMAP_CONTINENTS_PACKAGE_TAG;
    private List<String> sMAP_REGIONS_PACKAGE_TAG;
    private List<String> sMAP_AUTHOR;
    private List<Boolean> MAP_WORLD_MAP;
    private List<String> MAP_SCENARIO;
    private List<String> sMAP_WIKI;
    private List<Boolean> MAP_PROVINCE_BORDER;
    private List<Boolean> MAP_PROVINCE_NAMES;
    private List<Image> iMAP_ICON;
    private List<String> iMAP_ICON_PATH;
    private MapBG mpB = null;
    private MapCoords mpC = null;
    private MapScroll mpSl = null;
    private MapScale mpS = null;
    private Map_Continents mapContinents = null;
    private Map_Regions mapRegions = null;
    public MapOv mpOv = new MapOv();
    public int numOfBasins = 0;
    private TouchManager touchMgr = null;

    public Map() {
        Config data = new Config();
        Json json = new Json();
        json.setElementType(Config.class, "Map", Maps.class);
        if (CFG.getIsDesktop()) {
            data = json.fromJson(Config.class, FileManager.loadFile("map/Age_of_Civilizations.json").reader("UTF8"));
        } else {
            try {
                data = json.fromJson(Config.class, FileManager.loadFile("map/Age_of_Civilizations_Mobile.json").reader("UTF8"));
            }
            catch (Exception ex) {
                data = json.fromJson(Config.class, FileManager.loadFile("map/Age_of_Civilizations.json").reader("UTF8"));
            }
        }
        this.sMAP_TAGS = new ArrayList<String>();
        for (Object e : data.Map) {
            this.sMAP_TAGS.add(((Maps)e).Folder);
        }
        if (CFG.getIsDesktop()) {
            int a;
            boolean addMap;
            FileHandle[] files;
            int i;
            for (i = 0; i < sUM.sUFS; ++i) {
                files = FileManager.IS_MAC ? Gdx.files.external(sUM.sUF.get(i) + "map/").list() : Gdx.files.internal(sUM.sUF.get(i) + "map/").list();
                for (FileHandle file : files) {
                    addMap = true;
                    if (file.name().indexOf("jar") >= 0 || file.name().indexOf("txt") >= 0 || file.name().indexOf("json") >= 0 || file.name().equals("backgrounds") || file.name().equals("data")) {
                        addMap = false;
                    }
                    if (addMap) {
                        for (a = 0; a < this.sMAP_TAGS.size(); ++a) {
                            if (!this.sMAP_TAGS.get(a).equals(file.name())) continue;
                            addMap = false;
                            break;
                        }
                    }
                    if (!addMap || !FileManager.loadFile("map/" + file.name() + "/config.json").exists()) continue;
                    this.sMAP_TAGS.add(file.name());
                }
            }
            for (i = 0; i < sUM.sUIIS; ++i) {
                for (FileHandle file : files = Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "map/").list()) {
                    addMap = true;
                    if (file.name().indexOf("jar") >= 0 || file.name().indexOf("txt") >= 0 || file.name().indexOf("json") >= 0 || file.name().equals("backgrounds") || file.name().equals("data")) {
                        addMap = false;
                    }
                    if (addMap) {
                        for (a = 0; a < this.sMAP_TAGS.size(); ++a) {
                            if (!this.sMAP_TAGS.get(a).equals(file.name())) continue;
                            addMap = false;
                            break;
                        }
                    }
                    if (!addMap || !FileManager.loadFile("map/" + file.name() + "/config.json").exists()) continue;
                    this.sMAP_TAGS.add(file.name());
                }
            }
        }
        this.sMAP_LANG_KEY = new ArrayList<String>();
        this.iMAP_NUM_OF_PROVINCES = new ArrayList<Integer>();
        this.iMAP_SCALE = new ArrayList<Integer>();
        this.iMAP_SCALE_PRE_EXTRA = new ArrayList<Integer>();
        this.iMAP_EXTRA_SCALE = new ArrayList<Float>();
        this.iMAP_DEFAULT_SCALE = new ArrayList<Integer>();
        this.sMAP_BACKGROUND_NAME = new ArrayList<String>();
        this.sMAP_AUTHOR = new ArrayList<String>();
        this.sMAP_WIKI = new ArrayList<String>();
        this.sMAP_CONTINENTS_PACKAGE_TAG = new ArrayList<String>();
        this.sMAP_REGIONS_PACKAGE_TAG = new ArrayList<String>();
        this.iMAP_ICON = new ArrayList<Image>();
        this.iMAP_ICON_PATH = new ArrayList<String>();
        this.MAP_WORLD_MAP = new ArrayList<Boolean>();
        this.MAP_SCENARIO = new ArrayList<String>();
        this.MAP_PROVINCE_BORDER = new ArrayList<Boolean>();
        this.MAP_PROVINCE_NAMES = new ArrayList<Boolean>();
        for (int i = 0; i < this.sMAP_TAGS.size(); ++i) {
            try {
                data = new Config();
                json.setElementType(Config.class, "Map", MapInformations.class);
                if (CFG.getIsDesktop()) {
                    data = json.fromJson(Config.class, FileManager.loadFile("map/" + this.sMAP_TAGS.get(i) + "/" + "config" + ".json").reader("UTF8"));
                } else {
                    try {
                        data = json.fromJson(Config.class, FileManager.loadFile("map/" + this.sMAP_TAGS.get(i) + "/" + "config_Mobile" + ".json").reader("UTF8"));
                    }
                    catch (Exception ex) {
                        data = json.fromJson(Config.class, FileManager.loadFile("map/" + this.sMAP_TAGS.get(i) + "/" + "config" + ".json").reader("UTF8"));
                    }
                }
                Iterator ex = data.Map.iterator();
                if (ex.hasNext()) {
                    Object e = ex.next();
                    MapInformations tempMapFolder = (MapInformations)e;
                    this.sMAP_LANG_KEY.add(tempMapFolder.MapName);
                    this.sMAP_AUTHOR.add(tempMapFolder.Author);
                    this.sMAP_BACKGROUND_NAME.add(tempMapFolder.BackgroundName);
                    this.sMAP_CONTINENTS_PACKAGE_TAG.add(tempMapFolder.ContinentsPackage);
                    this.sMAP_REGIONS_PACKAGE_TAG.add(tempMapFolder.RegionsPackage);
                    this.iMAP_NUM_OF_PROVINCES.add(tempMapFolder.NumberOfProvinces);
                    this.iMAP_EXTRA_SCALE.add(Float.valueOf(Math.max(1.0f, tempMapFolder.MapScaleExtra)));
                    this.iMAP_SCALE.add((int)((float)tempMapFolder.MapScale * tempMapFolder.MapScaleExtra));
                    this.iMAP_SCALE_PRE_EXTRA.add(tempMapFolder.MapScale);
                    this.iMAP_DEFAULT_SCALE.add(tempMapFolder.MapScale);
                    this.MAP_WORLD_MAP.add(tempMapFolder.WorldMap);
                    this.MAP_SCENARIO.add(tempMapFolder.Scenario);
                    this.sMAP_WIKI.add(tempMapFolder.Wiki);
                    this.MAP_PROVINCE_BORDER.add(tempMapFolder.ProvinceBorderNew);
                    this.MAP_PROVINCE_NAMES.add(tempMapFolder.ProvinceNames);
                }
                this.iMAP_ICON.add(null);
                this.iMAP_ICON_PATH.add("map/" + this.sMAP_TAGS.get(i) + "/" + "ico.png");
                continue;
            }
            catch (Exception ex) {
                this.sMAP_TAGS.remove(i);
            }
        }
        this.mpB = new MapBG();
        this.mpC = new MapCoords();
        this.touchMgr = new TouchManager();
        this.mpSl = new MapScroll();
        this.mpS = new MapScale();
    }

    public final void loadSettings_ActiveMap() {
        block14: {
            try {
                try {
                    FileHandle file = FileManager.IS_MAC ? Gdx.files.external("settings/settings_mapAoH2DE") : Gdx.files.local("settings/settings_mapAoH2DE");
                    SaveActiveMap_GameData tempActiveMapData = (SaveActiveMap_GameData)CFG.deserialize(file.readBytes());
                    if (tempActiveMapData.iActiveMapID < 0 || tempActiveMapData.iActiveMapID >= this.getNumOfMaps()) break block14;
                    int activeMapScale = tempActiveMapData.iActiveMapScale;
                    try {
                        FileHandle tempFileT = FileManager.loadFile("map/" + CFG.map.getFileMapPath(tempActiveMapData.iActiveMapID) + "data/" + "scales/" + "provinces/" + "Age_of_Civilizations");
                        String tempT = tempFileT.readString();
                        String[] tagsSPLITED = tempT.split(";");
                        ArrayList<Integer> tempScales = new ArrayList<Integer>();
                        for (int i = 0; i < tagsSPLITED.length; ++i) {
                            tempScales.add(Integer.parseInt(tagsSPLITED[i]));
                        }
                        boolean scaleExists = false;
                        for (int i = 0; i < tempScales.size(); ++i) {
                            if ((Integer)tempScales.get(i) != activeMapScale) continue;
                            scaleExists = true;
                            break;
                        }
                        if (!scaleExists) {
                            activeMapScale = (Integer)tempScales.get(tempScales.size() - 1);
                        }
                    }
                    catch (Exception tempFileT) {
                        // empty catch block
                    }
                    CFG.map.setMapScale(tempActiveMapData.iActiveMapID, activeMapScale);
                    CFG.map.setActiveMapIDN(tempActiveMapData.iActiveMapID);
                }
                catch (GdxRuntimeException ex) {
                    FileHandle file = FileManager.loadFile("settings/settings_mapAoH2DE");
                    SaveActiveMap_GameData tempActiveMapData = (SaveActiveMap_GameData)CFG.deserialize(file.readBytes());
                    if (tempActiveMapData.iActiveMapID < 0 || tempActiveMapData.iActiveMapID >= this.getNumOfMaps()) break block14;
                    int activeMapScale = tempActiveMapData.iActiveMapScale;
                    try {
                        FileHandle tempFileT = FileManager.loadFile("map/" + CFG.map.getFileMapPath(tempActiveMapData.iActiveMapScale) + "data/" + "scales/" + "provinces/" + "Age_of_Civilizations");
                        String tempT = tempFileT.readString();
                        String[] tagsSPLITED = tempT.split(";");
                        ArrayList<Integer> tempScales = new ArrayList<Integer>();
                        for (int i = 0; i < tagsSPLITED.length; ++i) {
                            tempScales.add(Integer.parseInt(tagsSPLITED[i]));
                        }
                        boolean scaleExists = false;
                        for (int i = 0; i < tempScales.size(); ++i) {
                            if ((Integer)tempScales.get(i) != activeMapScale) continue;
                            scaleExists = true;
                            break;
                        }
                        if (!scaleExists) {
                            activeMapScale = (Integer)tempScales.get(tempScales.size() - 1);
                        }
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    CFG.map.setMapScale(tempActiveMapData.iActiveMapID, activeMapScale);
                    CFG.map.setActiveMapIDN(tempActiveMapData.iActiveMapID);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public final void load_DeleteStatusFile() {
    }

    public final void initMapContinents() {
        this.mapContinents = new Map_Continents(this.sMAP_CONTINENTS_PACKAGE_TAG.get(this.getActiveMapIDN()));
    }

    public final void initMapRegions() {
        this.mapRegions = new Map_Regions(this.sMAP_REGIONS_PACKAGE_TAG.get(this.getActiveMapIDN()));
    }

    public final void update() {
        this.mpS.update();
        this.mpSl.update();
        this.mpC.update();
    }

    public final void drawMap(SpriteBatch oSB) {
        if (this.mpB.requestToDisposeMinimap) {
            this.mpB.disposeMinimapOfCivilizations_Real();
        }
        this.mpB.drawMinimapTexture_Generate(oSB);
        this.mpB.drawMap(oSB, this.mpC.getPX(), this.mpC.getPY());
        this.mpB.drawMapBorder(oSB, this.mpC.getPX(), this.mpC.getPY());
    }

    public final String getFileActiveMapPath() {
        return this.sMAP_TAGS.get(this.activeMapID) + "/";
    }

    public final String getFile_ActiveMap_Path2() {
        return this.sMAP_TAGS.get(this.activeMapID);
    }

    public final String getFileMapPath(int nMapID) {
        return this.sMAP_TAGS.get(nMapID) + "/";
    }

    public final String getMapName_Just(int i) {
        return CFG.lang.get(this.getMapLangKey(i));
    }

    public final String getMapName(int i) {
        return CFG.lang.get(this.getMapLangKey(i)) + " | " + this.getMapNumOfProvinces(i) + " " + CFG.lang.get("Provinces");
    }

    public final void updateWorldMap() {
        this.mpB.updateWM();
        this.mpC.updateWorldMap();
    }

    public final MapBG getMpB() {
        return this.mpB;
    }

    public final MapCoords getMpC() {
        return this.mpC;
    }

    public final TouchManager getTouchMgr() {
        return this.touchMgr;
    }

    public final MapScroll getMpSl() {
        return this.mpSl;
    }

    public final MapScale getMpS() {
        return this.mpS;
    }

    public final Map_Continents getMapContinents() {
        return this.mapContinents;
    }

    public final Map_Regions getMapRegions() {
        return this.mapRegions;
    }

    public final int getActiveMapIDN() {
        return this.activeMapID;
    }

    public final void setActiveMapIDN(int iActiveMapID) {
        if (this.activeMapID != iActiveMapID) {
            this.activeMapID = iActiveMapID;
            this.updateWorldMap();
        }
    }

    public final String getMapLangKey(int i) {
        return this.sMAP_LANG_KEY.get(i);
    }

    public final int getMapNumOfProvinces(int i) {
        return this.iMAP_NUM_OF_PROVINCES.get(i);
    }

    public final int getNumOfMaps() {
        return this.sMAP_TAGS.size();
    }

    public final Image getIcon(int i) {
        Image icon = this.iMAP_ICON.get(i);
        if (icon == null) {
            try {
                icon = new Image(new Texture(FileManager.loadFile(this.iMAP_ICON_PATH.get(i))));
            } catch (Exception ex2) {
                icon = new Image(new Texture(FileManager.loadFile("UI/imageNotFound.png")));
            }
            this.iMAP_ICON.set(i, icon);
        }
        return icon;
    }

    public final String getMapBGName(int i) {
        return this.sMAP_BACKGROUND_NAME.get(i);
    }

    public final String getMapAuthor(int i) {
        return this.sMAP_AUTHOR.get(i);
    }

    public final String getMapWiki(int i) {
        return this.sMAP_WIKI.get(i);
    }

    public final int setMapScale(int i, int nMapScale) {
        this.iMAP_SCALE_PRE_EXTRA.set(i, nMapScale);
        return this.iMAP_SCALE.set(i, (int)((float)nMapScale * this.getMapExtraScale(i)));
    }

    public final int getMapScale(int i) {
        return this.iMAP_SCALE.get(i);
    }

    public final float getMapExtraScale(int i) {
        return this.iMAP_EXTRA_SCALE.get(i).floatValue();
    }

    public final boolean getMapProvBorder(int i) {
        return this.MAP_PROVINCE_BORDER.get(i) != false && !CFG.settingsGD.USE_OLD_PROVINCE_BORDER;
    }

    public final boolean getMapProvinceNames(int i) {
        return this.MAP_PROVINCE_NAMES.get(i);
    }

    public final int getMapScale_PreExtra(int i) {
        return this.iMAP_SCALE_PRE_EXTRA.get(i);
    }

    public final int getMapDefaultScale(int i) {
        return this.iMAP_DEFAULT_SCALE.get(i);
    }

    public final String getMapContinentsPackageTag(int i) {
        return this.sMAP_CONTINENTS_PACKAGE_TAG.get(i);
    }

    public final String getMapRegionsPackageTag(int i) {
        return this.sMAP_REGIONS_PACKAGE_TAG.get(i);
    }

    public final boolean getIsMapWorldMap(int i) {
        return this.MAP_WORLD_MAP.get(i);
    }

    public final String getMapDefaultScenario(int i) {
        return this.MAP_SCENARIO.get(i);
    }

    public static class Config {
        private String Age_of_Civilizations;
        private ArrayList Map;

        public void setMapData(ArrayList nMap) {
            this.Map = nMap;
        }
    }

    public static class Maps {
        private String Folder;
    }

    public static class MapInformations {
        private String MapName;
        private String Author;
        private String BackgroundName;
        private String ContinentsPackage;
        private String RegionsPackage;
        private int NumberOfProvinces;
        private int MapScale;
        private float MapScaleExtra = 1.0f;
        private boolean ProvinceBorderNew = false;
        private boolean ProvinceNames = false;
        private boolean WorldMap;
        private String Scenario;
        private String Wiki;
    }

    public static class Mapsrr {
        private String Folder;
    }
}

