
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.AI.AI;
import age.of.civilizations2.jakowski.lukasz.Achievement_Data;
import age.of.civilizations2.jakowski.lukasz.Alliances_Names_GameData;
import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.City;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.Civilization_GameData3;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_Data;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_GameData_MessageData;
import age.of.civilizations2.jakowski.lukasz.Clouds.CloudsManager;
import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import age.of.civilizations2.jakowski.lukasz.Console.Commands;
import age.of.civilizations2.jakowski.lukasz.Continent_GameData;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.CreateVassal_Data;
import age.of.civilizations2.jakowski.lukasz.DiplomacyColors_GameData2;
import age.of.civilizations2.jakowski.lukasz.Editor.EditorManager;
import age.of.civilizations2.jakowski.lukasz.EventsJ;
import age.of.civilizations2.jakowski.lukasz.EventsManager;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.FlagManager;
import age.of.civilizations2.jakowski.lukasz.FormableCivs_GameData;
import age.of.civilizations2.jakowski.lukasz.Game.GameUpdate;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameAges;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Circle;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_CircleDraw;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_Union;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryManager;
import age.of.civilizations2.jakowski.lukasz.HolyRomanEmpire_Manager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.IdeologiesManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Keyboard;
import age.of.civilizations2.jakowski.lukasz.LangManager;
import age.of.civilizations2.jakowski.lukasz.Leader_GameData;
import age.of.civilizations2.jakowski.lukasz.Line_GameData;
import age.of.civilizations2.jakowski.lukasz.LinesManager;
import age.of.civilizations2.jakowski.lukasz.Map;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Challenge.ChallengesManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Plagues.PlagueManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.MenuManager;
import age.of.civilizations2.jakowski.lukasz.Menus.Events.Menu_CreateScenario_Events_List;
import age.of.civilizations2.jakowski.lukasz.Menus.Editors.Menu_Editor_Cities;
import age.of.civilizations2.jakowski.lukasz.Menus.Rank.Menu_InGameRank;
import age.of.civilizations2.jakowski.lukasz.Menus.Vassal.Menu_InGame_Tribute;
import age.of.civilizations2.jakowski.lukasz.Menus.Wars.Details.Menu_InGame_WarDetails;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.MapModes.Menu_InGame_MapModes;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_FlagPixel_Color;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_InGame_AbandonProvince;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_InGame_ForceMigration;
import age.of.civilizations2.jakowski.lukasz.NewGameManager;
import age.of.civilizations2.jakowski.lukasz.Package_ContinentsData;
import age.of.civilizations2.jakowski.lukasz.Package_RegionsData;
import age.of.civilizations2.jakowski.lukasz.PalletOfCivsColors_Data;
import age.of.civilizations2.jakowski.lukasz.Pallet_Manager;
import age.of.civilizations2.jakowski.lukasz.Point_XY2;
import age.of.civilizations2.jakowski.lukasz.Province_Cores_GameData;
import age.of.civilizations2.jakowski.lukasz.RandomGame_Manager;
import age.of.civilizations2.jakowski.lukasz.Region_GameData;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;
import age.of.civilizations2.jakowski.lukasz.ReligionManager;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Report_Data;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Save.SaveActiveMap_GameData;
import age.of.civilizations2.jakowski.lukasz.Scenario_GameData_Technology;
import age.of.civilizations2.jakowski.lukasz.ServiceRibbon_GameData;
import age.of.civilizations2.jakowski.lukasz.ServiceRibbon_Manager;
import age.of.civilizations2.jakowski.lukasz.SettingsGD;
import age.of.civilizations2.jakowski.lukasz.Start_The_Game_Data;
import age.of.civilizations2.jakowski.lukasz.TerrainTypesManager;
import age.of.civilizations2.jakowski.lukasz.Terrain_GameData3;
import age.of.civilizations2.jakowski.lukasz.Timelapse.TimelapseManager;
import age.of.civilizations2.jakowski.lukasz.Toast;
import age.of.civilizations2.jakowski.lukasz.TradeRequest_GameData;
import age.of.civilizations2.jakowski.lukasz.Ultimatum_GameData;
import age.of.civilizations2.jakowski.lukasz.UnionFlagsToGenerate;
import age.of.civilizations2.jakowski.lukasz.UnionFlagsToGenerate_Manager;
import age.of.civilizations2.jakowski.lukasz.UnionFlagsToGenerate_TypesOfAction;
import age.of.civilizations2.jakowski.lukasz.UnionsManager;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import age.of.civilizations2.jakowski.lukasz.Z_Other.TutorialManager;
import age.of.civilizations2.jakowski.lukasz.Z_Other.Undo.Undo_AssignProvinceCiv;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import age.of.civilizations2.jakowski.lukasz.Z_Other.GlyphLayout_Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Menu_PeaceTreaty;
import age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Response.Menu_PeaceTreaty_Response;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_CivilizationView;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_Games;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_InGame_SelectProvinces;
import age.of.civilizations2.jakowski.lukasz.Menus.RandomGame.Menu_RandomGame;
import age.of.civilizations2.jakowski.lukasz.Menus.Turn.End.Menu_InGame_EndOfGame;
import age.of.civilizations2.jakowski.lukasz.Menus.Victory.Menu_Victory;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Menu_CreateNewGame;
import age.of.civilizations2.jakowski.lukasz.Menus.TradeRequest.Menu_InGame_TradeRequest_SelectCiv;
import age.of.civilizations2.jakowski.lukasz.Z_Other.AchievementsManager;
import age.of.civilizations2.jakowski.lukasz.Menus.Load.Scenario.Menu_LoadScenario;
import age.of.civilizations2.jakowski.lukasz.Menus.Options.Menu_InGame_Options;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Happiness.Menu_InGame_View_Happiness;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Vassals.Menu_InGame_BecomeVassal;
import age.of.civilizations2.jakowski.lukasz.Menus.Turn.Start.Menu_StartTheGame_Reverse;
import age.of.civilizations2.jakowski.lukasz.Menus.Settings.Menu_CreateScenario_Settings;
import age.of.civilizations2.jakowski.lukasz.Messages.Message;
import age.of.civilizations2.jakowski.lukasz.Messages.Alliance.Become.Message_BecomeVassal;
import age.of.civilizations2.jakowski.lukasz.Editor.Editors;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_SaveTheGame;
import age.of.civilizations2.jakowski.lukasz.Menus.Main.Menu_Main2;
import age.of.civilizations2.jakowski.lukasz.PlayerGD;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.MapModes.Menu_InGame_MapModes;
import age.of.civilizations2.jakowski.lukasz.Menus.Action.Menu_InGameProvinceActionColonize;
import age.of.civilizations2.jakowski.lukasz.Menus.Civs.Ideologies.Menu_CreateScenario_Civilizations_Suggest;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.Menus.ProvinceM.More.Menu_InGame_Province_More;
import age.of.civilizations2.jakowski.lukasz.Menus.Load.Menu_LoadGame;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Menu_InGame_Messages;
import age.of.civilizations2.jakowski.lukasz.Menus.HRE.HRE.Menu_InGame_HRE;
import age.of.civilizations2.jakowski.lukasz.Menus.HRE.Menu_CreateScenario_HRE_Princes;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_Infobox;
import age.of.civilizations2.jakowski.lukasz.Menus.Wars.Menu_InGame_WarPreparations;


public class CFG {
    public static long currentTimeMillis;
    public static boolean LOGs;
    public static boolean DEBUG_MODE;
    public static String sDEBUG;
    public static boolean LANDSCAPE;
    public static int FONT_BOLD;
    public static int FONT_BOLD_SMALL;
    public static int FONT_REGULAR_SMALL;
    public static Color sparksColors;
    private static final Color colorLine;
    public static EditorManager editorManager;
    public static final String F_UI_PATH = "UI/";
    public static final String F_GAME_PATH = "game/";
    public static final String F_MAP_PATH = "map/";
    public static final String FILE_MAP_UPDATE_PATH = "update/";
    public static final String FILE_MAP_BACKGROUND_PATH = "backgrounds/";
    public static final String FILE_MAP_CONTINENTS_PATH = "continents/";
    public static final String FILE_MAP_CONTINENTS_PACKGES_PATH = "packges/";
    public static final String FILE_MAP_CONTINENTS_PACKGES_DATA_PATH = "packges_data/";
    public static final String FILE_MAP_REGIONS_PATH = "regions/";
    public static final String FILE_MAP_REGIONS_PACKGES_PATH = "packges/";
    public static final String FILE_MAP_REGIONS_PACKGES_DATA_PATH = "packges_data/";
    public static final String FILE_LANGUAGES_JUST_PATH = "languages/";
    public static final String FILE_LANGUAGES_PATH = "languages/Bundle";
    public static final String FILE_LANGUAGES_CIVS_PATH = "languages/civilizations/Bundle";
    public static final String FILE_LANGUAGES_LOADING_PATH = "languages/loading/Bundle";
    public static final String FILE_MAP_OVERLAYS_PATH = "overlays/";
    public static final String FILE_MAP_OVERLAYS_LOW_PATH = "low/";
    public static final String FILE_MAP_OVERLAYS_HIGH_PATH = "high/";
    public static final String FILE_MAP_OVERLAYS_FILE = "Overlays.json";
    public static final String FILE_GAME_VALUES_PATH = "gameValues/";
    public static final String FILE_BACKGROUND_PATH = "background/";
    public static final String FILE_BACKGROUND_ANIMATED_PATH = "animated/";
    public static final String FILE_RELIGIONS_LIST = "Religions.json";
    public static final String FILE_GFX_RELIGION_PATH = "religion/";
    public static final String FILE_GFX_CLOUDS_PATH = "clouds/";
    public static final String FILE_GAME_SETTINGS = "settings/";
    public static final String FILE_MODS_TURNED_OFF_FILE = "ModsOff.txt";
    public static final String FILE_SETTINGS = "settings/settingsAoH2DE";
    public static final String FILE_SETTINGSJ = "settings/settingsAoH2DE.txt";
    public static final String FILE_SETTINGS_LAST_ACTIVE_MAP = "settings/settings_mapAoH2DE";
    public static final String FILE_CONFIG = "settings/config.txt";
    public static final String FILE_CONFIG_JSON = "Config.json";
    public static final String FILE_IMAGE_NOT_FOUND = "UI/imageNotFound.png";
    public static final String FILE_RANDOM_PATH = "random/";
    public static final String FILE_MODS_PATH = "mods/";
    public static final String FILE_MAP_PROVINCES_IMG = "provinces/";
    public static final String FILE_GAME_LIST = "Age_of_Civilizations";
    public static final String FILE_GAME_LIST2 = "Age_of_History.txt";
    public static final String FILE_GAME_LIST_ACTIVE = "_Active";
    public static final String FILE_AUDIO = "audio/";
    public static final String FILE_MUSIC = "music/";
    public static final String FILE_SOUNDS = "sounds/";
    public static final String FILE_IDEOLOGIES_LIST = "Governments";
    public static final String FILE_AGES_LIST = "Ages";
    public static final String FILE_PLAGUES_LIST = "Diseases";
    public static final String FILE_GAME_FLAGS_EDITOR_PATH = "flags_editor/";
    public static final String FILE_GAME_FLAGS_EDITOR_DIVISIONS_PATH = "divisions/";
    public static final String FILE_GAME_FLAGS_EDITOR_DIVISIONS_LIST = "divisions";
    public static final String FILE_GAME_FLAGS_EDITOR_OVERLAYS_PATH = "overlays/";
    public static final String FILE_GAME_FLAGS_EDITOR_OVERLAYS_LIST = "overlays";
    public static final String FILE_GAME_UNIONS_PATH = "unions/";
    public static final String FILE_GAME_UNIONS_DATA = "data";
    public static final String F_GAME_FORMABLE_PATH = "formableDescription/";
    public static final String FILE_GAME_CIVS_PATH = "civilizations/";
    public static final String FILE_GAME_CIVILIZATIONS_COLORS_PATH = "civilizations_colors/";
    public static final String FILE_GAME_CIVILIZATIONS_FLAGS_DATA_EXTRA_TAG = "_FD";
    public static final String FILE_GAME_CIVILIZATIONS_FLAG_H_EXTRA_TAG = "_FLH.png";
    public static final String FILE_GAME_CIVILIZATIONS_FLAG_EXTRA_TAG = "_FL.png";
    public static final String FILE_GAME_CIVILIZATIONS_EDITOR_NAME = "_NM";
    public static final String FILE_GAME_CIVILIZATIONS_WIKIPEDIA_INFO_PATH = "civilizations_informations/";
    public static final String FILE_PROVINCE_NAME_POINTS = "ProvinceNamePoints.json";
    public static final String FILE_GAME_LEADERS_RANDOM_PATH = "leadersRandom/";
    public static final String FILE_GAME_LEADERS_RANDOM_NAMES_PATH = "names/";
    public static final String FILE_GAME_LEADERS_RANDOM_SURNAMES_PATH = "surnames/";
    public static final String FILE_GAME_LEADERS_PATH = "leaders/";
    public static final String FILE_GAME_LEADERS_IMG_PATH = "leadersIMG/";
    public static final String FILE_GAME_CIVS_EDITOR_PATH = "civilizations_editor/";
    public static final String FILE_GAME_PALLETS_OF_CIVS_COLORS_PATH = "pallets_of_civs_colors/";
    public static final String FILE_GAME_FLAGS_PATH = "flags/";
    public static final String FILE_GAME_FLAGSH_PATH = "flagsH/";
    public static final String FILE_GAME_FLAGSXH_PATH = "flagsXH/";
    public static final String FILE_GAME_SCENARIOS_PTH = "scenarios/";
    public static final String FILE_GAME_SCENARIOS_PROVINCE = "_PD";
    public static final String FILE_GAME_SCENARIOS_HRE = "_HRE";
    public static final String FILE_GAME_SCENARIOS_ARMIES = "_A";
    public static final String FILE_GAME_SAVE_TIMELINE_PATH = "TS/";
    public static final String FILE_GAME_SAVE_TIMELINE_TURNCHANGES_PATH = "TURN/";
    public static final String FILE_GAME_SAVE_TIMELINE = "_T";
    public static final String FILE_GAME_SAVE_TIMELINE_OWNERS = "_O";
    public static final String FILE_GAME_SAVE_TIMELINE_OWNERS_PD = "_OPD";

    public static final String FILE_GAME_SAVE_TIMELINE_TURN_CHANGES = "_C";
    public static final String FILE_GAME_SAVE_TIMELINE_STATS = "_S";
    public static final String FILE_GAME_SAVE_TIMELINE_STATS_HISTORY = "_HIS";
    public static final String FILE_GAME_SAVE_TIMELINE_STATS_POPULATION = "_POP";
    public static final String FILE_GAME_SAVE_TIMELINE_STATS_ECONOMY = "_ECO";
    public static final String FILE_GAME_SAVE_TIMELINE_STATS_PROVINCES = "_PROV";
    public static final String FILE_GAME_SAVE_TIMELINE_STATS_RANK = "_RANK";
    public static final String FILE_GAME_SAVE_TIMELINE_STATS_TECHNOLOGY = "_TECH";
    public static final String FILE_GAME_ALLIANCE_NAMES_PATH = "alliance_names/";
    public static final String FILE_GAME_DIPLOMACY_COLORS_PATH = "diplomacy_colors/";
    public static final String FILE_GAME_DIPLOMACY_COLORS_PACKAGES_PATH = "packages/";
    public static final String FILE_GAME_LINES_PATH = "lines/";
    public static final String FILE_GAME_RELIGIONS_PATH = "religions/";
    public static final String FILE_GAME_TERRAIN_TYPES_PATH = "terrain_types/";
    public static final String FILE_GAME_SERVICE_RIBBONS_PATH = "service_ribbons/";
    public static final String FILE_GAME_STATISTICS_CIV_PATH = "saves/stats/civ/";
    public static final String FILE_SAVES_PATH = "saves/games/";
    public static final String FILE_SAVES_CHALLENGES_COMPLETED = "ChallengesCompleted.txt";
    public static final String FILE_GAME_SCENARIOS_DIPLOMACY = "_D";
    public static final String FILE_GAME_SCENARIOS_INFO = "_INFO";
    public static final String FILE_GAME_SCENARIOS_PREVIEW = "preview.png";
    public static final String FILE_GAME_SCENARIOS_PREVIEW_SPECIAL = "previewSpecial.png";
    public static final String FILE_GAME_SCENARIOS_EVENTS_IMAGES = "events/";
    public static final String FILE_GAME_SCENARIOS_EVENTSJ = "eventsJ/";
    public static final String FILE_GAME_SCENARIOS_WASTELAND = "_W";
    public static final String FILE_GAME_SCENARIOS_CORES = "_C";
    public static final String FILE_GAME_SCENARIOS_OCCUPIED = "_O";
    public static final String FILE_GAME_SCENARIOS_EVENTS = "_E";
    public static final String F_MAP_CITIES = "cities/";
    public static final String FILE_MAP_CITIES_0_JSON = "cities.json";
    public static final String FILE_MAP_CITIES_1_JSON = "cities_1.json";
    public static final String FILE_MAP_CITIES_2_JSON = "cities_2.json";
    public static final String FILE_MAP_CITIES_3_JSON = "cities_3.json";
    public static final String FILE_MAP_CITIES_4_JSON = "cities_4.json";
    public static final String FILE_MAP_WONDERS = "wonders/";
    public static final String FILE_MAP_WONDERS_IMAGES = "images/";
    public static final String FILE_MAP_WONDERS_JSON = "wonders.json";
    public static final String FILE_MAP_MOUNTAINS_JSON = "mountains.json";
    public static final String FILE_MAP_REGIONS = "regions";
    public static final String FILE_MAP_ICON = "ico.png";
    public static Color colorGradient;
    public static Color colorGradientHover;
    public static int[] rotateXMoveUnits;
    public static int[] rotateYMoveUnits;
    public static int[] rotateXMoveUnits_64;
    public static int[] rotateYMoveUnits_64;
    public static final float GRAPH_DESC_TEXT_SCALE = 0.7f;
    public static final float GRAPH_DESC_TEXT_SCALE2 = 0.8f;
    public static final float PROVINCE_ALPHA_POPULATION = 0.5f;
    public static Color[] COLOR_POP_GRADIENT;
    public static Color[] COLOR_WAR_DEATHS;
    public static Color[] COLOR_POP_RED;
    public static final String WWW_WIKI = "https://en.wikipedia.org/wiki/";
    public static final String WWW_LUKASZJAKOWSKI = "http://lukaszjakowski.pl";
    public static final String WWW_AOC_FACEBOOK = "https://www.facebook.com/AgeofCivilizationsJakowski/";
    public static boolean gameLoaded = false;
    public static int GAMEWIDTH;
    public static int GAMEHEIGHT;
    public static int iNumOfFPS;
    public static final int MIN_NUM_OF_FPS = 22;
    public static final Color BG_COLOR;
    public static final Color COLOR_MINIMAP_BORDER;
    public static PalletOfCivsColors_Data editorPalletOfCivsColors_Data;
    public static Terrain_GameData3 editorTerrain_Data2;
    public static float GUI_SCALE;
    public static float DENSITY;
    public static boolean XHDPI;
    public static boolean XXHDPI;
    public static boolean XXXHDPI;
    public static CloudsManager cloudsAnimation;
    public static int NUM_OF_PROVINCES_IN_VIEW;
    public static int NUM_OF_SEA_PROVINCES_IN_VIEW;
    public static int NUM_OF_WASTELAND_PROVINCES_IN_VIEW;
    public static int NUM_OF_REGIONS_IN_VIEW;
    public static HashMap<String, Long> PROVINCE_BORDER_ANIMATION_TIME;
    public static SettingsGD settingsGD;
    public static int PADD;
    public static int BUTTON_H;
    public static int BUTTON_W;
    public static int PREVIEW_HEIGHT;
    public static final int RESIZE_PADDING_XY = 6;
    public static int CIV_COLOR_W;
    public static int CIV_NAME_BG_EXTRA_WIDTH;
    public static int CIV_NAME_BG_EXTRA_HEIGHT;
    public static int OUDH;
    public static List<Integer> LPHE;
    public static int CIV_NAME_BG_EXTRA_WIDTH_ARMY;
    public static int CIV_NAME_BG_EXTRA_HEIGHT_ARMY;
    public static int ARMY_BG_EXTRA_WIDTH;
    public static int ARMY_BG_EXTRA_HEIGHT;
    public static int ARMY_FLAG_PADDING_X;
    public static int ARMY_FLAG_PADDING_Y;
    public static int ARMY_FLAG_WIDTH;
    public static int ARMY_FLAG_HEIGHT;
    public static final Color COLOR_RESEARCH;
    public static Color COLOR_DEVELOPMENT;
    public static Color COLOR_POPULATION;
    public static Color COLOR_POPULATION_HOVER;
    public static Color COLOR_POPULATION_ACTIVE;
    public static Color COLOR_POPULATION_GROWTHRATE_MIN;
    public static Color COLOR_POPULATION_GROWTHRATE_MAX;
    public static final float PROVINCE_ALPHA_HAPPINESS = 0.5f;
    public static Color COLOR_HAPPINESS_MIN;
    public static Color COLOR_HAPPINESS_MAX;
    public static final Color COLOR_RECRUITABLE_MIN;
    public static final Color COLOR_RECRUITABLE_MAX;
    public static Color COLOR_REVOLUTION_MIN;
    public static Color COLOR_REVOLUTION_MIN_0;
    public static Color COLOR_REVOLUTION_MAX;
    public static Color COLOR_PROVINCE_STABILITY_MIN;
    public static Color COLOR_TEXT_PROVINCE_STABILITY_MIN_0;
    public static Color COLOR_PROVINCE_STABILITY_MAX;
    public static final Color COLOR_DISTANCE_MIN;
    public static final Color COLOR_DISTANCE_MAX;
    public static final Color COLOR_TEXT_HAPPINESS_HOVER;
    public static final Color COLOR_TEXT_HAPPINESS_ACTIVE;
    public static final Color COLOR_TEXT_CHECKBOX_TRUE;
    public static final Color COLOR_TEXT_CHECKBOX_FALSE;
    public static Color COLOR_ECONOMY;
    public static Color COLOR_ECONOMY_HOVER;
    public static Color COLOR_ECONOMY_ACTIVE;
    public static Color COLOR_TECHNOLOGY;
    public static Color COLOR_TEXT_CIV_INFO;
    public static final Color COLOR_TEXT_CIV_INFO_HOVER;
    public static final Color COLOR_TEXT_CIV_INFO_ACTIVE;
    public static final Color COLOR_TEXT_CIV_INFO_TITLE;
    public static final Color COLOR_TEXT_TOP_VIEWS;
    public static final Color COLOR_TEXT_TOP_VIEWS_HOVER;
    public static final Color COLOR_TEXT_TOP_VIEWS_ACTIVE;
    public static final Color COLOR_TEXT_TOP_VIEWS_NOT_CLICKABLE;
    public static final Color COLOR_COLOR_PICKER_RGB_BG;
    public static final Color COLOR_LOADING_SPLIT_ACTIVE;
    public static final Color COLOR_LOADING_SPLIT;
    public static Color COLOR_NEW_GAME_EDGE_LINE;
    public static Color COLOR_FLAG_FRAME;
    public static Color COLOR_NEW_GAME_EDGE_LINE2;
    public static final Color COLOR_TEXT_CIV_NAME;
    public static final Color COLOR_TEXT_CIV_NAME_HOVERED;
    public static final Color COLOR_TEXT_CIV_NAME_ACTIVE;
    public static final Color COLOR_TEXT_RANK;
    public static final Color COLOR_TEXT_RANK_HOVER;
    public static final Color COLOR_TEXT_RANK_ACTIVE;
    public static final Color COLOR_SLIDER_LEFT_BG;
    public static final Color COLOR_SLIDER_RIGHT_BG;
    public static final Color COLOR_SLIDER_LEFT_BG2;
    public static final Color COLOR_SLIDER_LEFT_BG3;
    public static final Color COLOR_SLIDER_LEFT_INSTANTLY;
    public static Color COLOR_CREATE_NEW_GAME_BOX_PLAYERS;
    public static Color COLOR_GRADIENT_DARK_BLUE;
    public static Color COLOR_GRADIENT_LIGHTER_DARK_BLUE;
    public static Color COLOR_GRADIENT_DIPLOMACY;
    public static Color COLOR_NEGATIVE_1;
    public static Color COLOR_NEGATIVE_2;
    public static final Color COLOR_NEGATIVE_HOVER;
    public static final Color COLOR_NEGATIVE_ACTIVE;
    public static Color COLOR_NEUTRAL;
    public static Color COLOR_NEUTRAL2;
    public static Color COLOR_POSITIVE;
    public static final Color COLOR_POSITIVE_HOVER;
    public static final Color COLOR_POSITIVE_ACTIVE;
    public static final Color COLOR_POSITIVE_BUILT;
    public static final Color COLOR_FREE_MOVE;
    public static final Color COLOR_FREE_MOVE_ACTIVE;
    public static final Color COLOR_FREE_MOVE_HOVER;
    public static Color COLOR_PROVINCE_VALUE;
    public static Color COLOR_PROVINCE_VALUE_HOVER;
    public static Color COLOR_PROVINCE_VALUE_ACTIVE;
    public static final Color COLOR_TEXT_GREEN;
    public static final Color COLOR_TEXT_CNG_TOP_SCENARIO_NAME;
    public static final Color COLOR_TEXT_CNG_TOP_SCENARIO_NAME_HOVER;
    public static final Color COLOR_TEXT_CNG_TOP_SCENARIO_INFO;
    public static Color COLOR_TEXT_GRAY_NS;
    public static Color COLOR_TEXT_GRAY_NS_HOVER;
    public static Color COLOR_TEXT_GRAY_NS_ACTIVE;
    public static Color COLOR_TEXT_GRAY_LEFT_NS;
    public static Color COLOR_TEXT_GRAY_LEFT_NS_HOVER;
    public static Color COLOR_TEXT_GRAY_LEFT_NS_ACTIVE;
    public static Graph_CircleDraw graphCircleDraw;
    public static final Color COLOR_STARTINGMONEY_MIN;
    public static final Color COLOR_STARTINGMONEY_0;
    public static final Color COLOR_STARTINGMONEY_MAX;
    public static final Color COLOR_BUTTON_MENU_HOVER_BG;
    public static final Color COLOR_BUTTON_MENU_ACTIVE_BG;
    public static Color COLOR_BUTTON_MENU_TEXT;
    public static Color COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE;
    public static Color COLOR_BUTTON_MENU_TEXT_HOVERED;
    public static Color COLOR_BUTTON_MENU_TEXT_ACTIVE;
    public static Color COLOR_BUTTON_GAME_TEXT;
    public static Color COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE;
    public static Color COLOR_BUTTON_GAME_TEXT_ACTIVE;
    public static Color COLOR_HOVER_TITLE;
    public static Color COLOR_BUTTON_GAME_TEXT_HOVERED;
    public static Color COLOR_BTN_M;
    public static Color COLOR_BTN_M_NOT_CLICKABLE;
    public static Color COLOR_BUTTON_GAME_TEXT_IMPORTANT;
    public static Color COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER;
    public static Color COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE;
    public static Color COLOR_TEXT_NUM_OF_PROVINCES;
    public static final Color COLOR_TEXT_GOLDEN_AGE;
    public static Color COLOR_GRADIENT_BLUE;
    public static final Color COLOR_MESSAGE_TITLE;
    public static final Color COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE;
    public static Color COLOR_GRADIENT_MENU_BLUE;
    public static boolean reverseDirectionX;
    public static boolean reverseDirectionY;
    public static int DIFFICULTY;
    public static int FOG_OF_WAR;
    public static boolean FILL_THE_MAP;
    public static boolean RANDOM_PLACEMENT;
    public static boolean RANDOM_FILL;
    public static boolean SANDBOX_MODE;
    public static boolean SANDBOX_MODE_AI;
    public static boolean PXSX;
    public static boolean SPECTATOR_MODE;
    public static boolean SPECTATOR_MODE_LOCK_CIV;
    public static int SPECTATOR_MODE_DECLARE_WAR_MODE;
    public static boolean SPECTATOR_MODE_DIPLOMACY_ACTIONS_MODE;
    public static boolean MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI;
    public static boolean RECRUIT_AND_COUNTERATTACK;
    public static boolean SAVED_GAME_LOADED;
    public static boolean SAVED_GAME_LOADED_2;
    public static boolean TOTAL_WARMODE;
    public static boolean AGE_OF_CHAOS_MODE;
    public static long AGE_OF_CHAOS_TURNS;
    public static int AGE_OF_CHAOS_CIVS;
    public static boolean ENABLE_NUKES;
    public static boolean LEADERS_CAN_DIE;
    public static boolean USE_NEW_DECLARE_WAR_SYSTEM;
    public static int USE_OLD_DECLARE_WAR_CHANGE_100;
    public static int MAX_PROVINCES_FOR_ALLIANCE_PROPOSAL;
    public static int PROPOSE_ALLIANCE_CHANCE_100;
    public static float ARMY_RETREAT;
    public static float CAPITULATION;
    public static int GET_SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_CHANCE_1000;
    public static int COLONIZATION_AUTO_EXPAND_CHANCE;
    public static boolean NUKES_MIN_YEAR_ENABLED;
    public static int WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS;
    public static boolean AI_UNIONS_ENABLED;
    public static boolean AI_CONQUER_VASSALS;
    public static boolean AI_VASSALS_CAN_DECLARE_WARS;
    public static int AI_CONQUER_OWN_VASSALS_IF_OVER;
    public static int MOVEMENT_POINTS_EXTRA;
    public static float MOVEMENT_POINTS_MAX_MODIFIER;
    public static int DIPLOMACY_POINTS_EXTRA;
    public static int TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE;
    public static int TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK;
    public static float ASSIMILATION_SPEED_MODIFIER;
    public static float POPULATION_GROWTH_RATE;
    public static float ECONOMY_GROWTH_RATE;
    public static float PEACE_TREATY_VICTORY_POINTS_MODIFIER;
    public static long BUILD_NUKES_EXTRA_COST;
    public static float NUKES_REQUIRED_TECH_LVL;
    public static float PLUNDER_MODIFIER;
    public static boolean AI_PLUNDER_ENABLED;
    public static float PLUNDER_CHANCE;
    public static float GENOCIDE_CHANCE;
    public static boolean AI_GENOCIDE_ENABLED;
    public static boolean VASSALS_CAN_DECLARE_INDEPENDENCE;
    public static float ASSIMILATION_COST_MODIFIER;
    public static List<Integer> AGE_OF_CHAOS_CIVS_LIST;
    public static float REBELS_POWER;
    public static long MIN_ARMY_REQUIRED_TO_ATTACK;
    public static final int DEFAULT_ARMY_NOT_SET_UPED = -1;
    public static final int DEFAULT_ARMY = 750;
    public static final int DEFAULT_ARMY_MAX = 25000;
    public static final int DEFAULT_POPULATION = 65000;
    public static final int DEFAULT_POPULATION_MAX = 2000000;
    public static final int DEFAULT_ECONOMY = 32000;
    public static final int DEFAULT_ECONOMY_MAX = 1000000;
    public static final int DEFAULT_MONEY = 4500;
    public static final int DEFAULT_MONEY_MIN = -10000;
    public static final int DEFAULT_MONEY_MAX = 75000;
    public static final int DEFAULT_MONEY_MIN2 = -100000;
    public static final int DEFAULT_MONEY_MAX2 = 100000;
    public static final int DEFAULT_MONEY_NOT_SET_UPED = -999999;
    public static final Color RANDOM_CIVILIZATION_COLOR;
    public static final String CIVILIZATION_FLAG_NOT_FOUND = "ran.png";
    public static final float DEFAULT_GOODS_LEVEL = 0.2f;
    public static final float DEFAULT_RESEARCH_LEVEL = 0.0f;
    public static final float DEFAULT_INVESTMENTS_LEVEL = 0.16f;
    public static int PLAYER_TURN_ID;
    public static boolean regroupArmyMode;
    public static List<Integer> chosenProvinces_Regroup;
    public static boolean chooseProvinceMode;
    public static int chosenProvinceID;
    public static boolean migrateMode;
    public static boolean chooseProvinceMode_BEFORE;
    public static int activeProvince_BEFORE;
    public static int ACTIVE_PROVINCE_INFO;
    public static int activeCivilizationArmyID;
    public static boolean VIEW_SHOW_VALUES;
    public static boolean SCENARIO_EDITOR_OCCUPATION;
    public static boolean SHOW_ALL_MOVES;
    public static boolean SHOW_ONLY_COMBAT_MOVES;
    public static final int NUM_OF_GAMES_WON_TON_UNLOCK_SANDBOX_MODE = 0;
    public static final String RANDOM_CIV_TAG = "ran";
    public static String RANDOM_CIVILIZATION;
    public static TopBox topBox;
    public static float fTerrainMode_LinePercentage;
    public static long lTerrainMode_LineTime;
    public static String sLoading;
    public static int iLoadingWidth;
    public static String sVERSION;
    public static String sAUTHOR;
    public static String sTOTAL;
    public static String sTOTAL_WORLDS_POPULATION;
    public static Random oR;
    protected static String sLoadingText;
    protected static int iLoadingTextWidth;
    protected static long loadingTime;
    protected static float LOADING_TEXT_FONT_SCALE;
    protected static final int LOADING_CHANGE_TEXT_TIME = 2500;
    public static int iDXW;
    public static ServiceRibbon_GameData editorServiceRibbon_GameData;
    public static List<Color> editorServiceRibbon_Colors;
    public static final String FILE_MAP_INFORMATION = "config";
    public static final String FILE_MAP_INFORMATION_MOBILE = "config_Mobile";
    public static final String FILE_MAP_DATA = "data/";
    public static final String FILE_MAP_PROVINCES = "provinces/";
    public static final String FILE_MAP_ROUTES = "sea_routes/";
    public static final String FILE_MAP_WASTELAND_MAPS_PATH = "wasteland_maps/";
    public static final String FILE_MAP_FORMABLE_CIVS_PATH = "formable_civs/";
    public static final String FILE_MAP_CITIES_EDITOR = "cities/";
    public static final String FILE_MAP_LINES_SEA = "Lines_Sea.txt";
    public static final String FILE_MAP_DEFINED_SCALES = "DefinedScales.json";
    public static final String FILE_MAP_TRADE_ZONES_PATH = "trade_zones/";
    public static final String FILE_MAP_TRADE_ZONES_ZONES_PATH = "zones/";
    public static final String FILE_MAP_TRADE_ZONES_UPDATES_PATH = "zones_updates/";
    public static final String FILE_MAP_TRADE_ZONES_ROUTES_PATH = "routes/";
    public static final String FILE_MAP_ARMY_BOXES = "army_boxes/";
    public static final String FILE_MAP_SCALES_BG = "scales/";
    public static final String FILE_MAP_SCALE_PROVINCE_BG = "provinces/";
    public static final String FILE_MAP_CENTER_ARMY = "center";
    public static int activeCivInfoId;
    private static Image activeCivFlag;
    public static List<Image> activeCivLeader;
    public static int leaderFrameID;
    public static int leaderFrameSize;
    public static long leaderTime;
    public static long leaderFrame;
    public static String loadedLeader;
    public static int CIV_INFO_MENU_WIDTH;
    public static List<Integer> pNCI;
    public static List<String> pNC;
    public static List<Integer> cNCI;
    public static List<String> cNC;
    public static Province_Cores_GameData province_CoresGD;
    public static FormableCivs_GameData formableCivs_GameData;
    public static Leader_GameData leaderGameData;
    public static Line_GameData editorLine_GameData;
    public static final float ALPHA_PROVINCE_REGIONS = 0.45f;
    public static final float ALPHA_PROVINCE_CONTINENTS = 0.7f;
    public static final float ALPHA_PROVINCE_TRADEZONES = 0.65f;
    public static Region_GameData editor_Region_GameData;
    public static Continent_GameData editor_Continent_GameData;
    public static String EDITOR_ACTIVE_GAMEDATA_TAG;
    public static String GO_TO_LINK;
    public static Package_ContinentsData editor_Package_ContinentsData;
    public static Package_RegionsData editor_Package_RegionsData;
    public static String CREATE_PACKAGE_CONTINENT_GAME_DATA_TAG;
    public static final Color COLOR_BUTTON_EXTRA_DESCRIPTION;
    public static final float PROVINCE_ALPHA_TERRAIN = 0.55f;
    public static ReligionManager religionManager;
    public static TerrainTypesManager terrainTypesManager;
    public static final float PROVINCE_ALPHA_GROWTH_RATE = 0.5f;
    public static final float PROVINCE_ALPHA_GROWTH_RATE_INGAME = 0.5f;
    public static Color[] COLOR_GROWTH_RATE;
    public static final float PROVINCE_ALPHA_DISEASES = 0.725f;
    public static final float PROVINCE_ALPHA_ARMY = 0.575f;
    public static final Color COLOR_PROVINCE_ARMY_MIN;
    public static final Color COLOR_PROVINCE_ARMY_MAX;
    public static final float PROVINCE_ALPHA_PROVINCE_VALUE = 0.75f;
    public static int MAX_PROVINCE_VALUE;
    public static Color[] COLOR_ECONOMY_GRADIENT;
    public static Color[] POP_COLORS_CACHE = new Color[101];
    public static Color[] ECON_COLORS_CACHE = new Color[101];
    public static Color[] TECH_COLORS_CACHE = new Color[101];
    public static Color[] GROWTH_COLORS_CACHE = new Color[101];
    public static Color tmpColor = new Color();
    public static float PROVINCE_ALPHA_TECHNOLOGY_LEVEL;
    public static Color[] COLOR_TECHNOLOGY_LEVEL;
    public static int iLOAH;
    public static long loaTM;
    public static final int LOATIV = 2500;
    public static String sACTIVE_DIPLOMACY_COLORS_TAG;
    public static DiplomacyColors_GameData2 diplomacyColors_GameData;
    public static String sLOATXT;
    public static int iLOADW;
    public static long PRT;
    public static final int PRTIV = 6500;
    public static float ALPHA_DIPLOMACY;
    public static final Color COLOR_SLIDER_BORDER;
    public static final Color COLOR_PORT_m1;
    public static final Color COLOR_PORT_0;
    public static final Color COLOR_PORT_1;
    public static final Color COLOR_FORT_1;
    public static final Color COLOR_FORT_2;
    public static final Color COLOR_WATCH_TOWER;
    public static final Color COLOR_FARM;
    public static final Color COLOR_FARM1;
    public static final Color COLOR_FARM2;
    public static final Color COLOR_FARM3;
    public static final Color COLOR_FARM4;
    public static final Color COLOR_FARM5;
    public static final Color COLOR_IN_CONSTRUCTION;
    public static final Color COLOR_LIBRARY;
    public static final Color COLOR_LIBRARY1;
    public static final Color COLOR_LIBRARY2;
    public static final Color COLOR_LIBRARY3;
    public static final Color COLOR_LIBRARY4;
    public static final Color COLOR_LIBRARY5;
    public static final Color COLOR_MARKET;
    public static final Color COLOR_MARKET1;
    public static final Color COLOR_MARKET2;
    public static final Color COLOR_MARKET3;
    public static final Color COLOR_MARKET4;
    public static final Color COLOR_MARKET5;
    public static final Color COLOR_NUKE;
    public static final Color COLOR_SUPPLY;
    public static final Color COLOR_WORKSHOP;
    public static final Color COLOR_WORKSHOP1;
    public static final Color COLOR_WORKSHOP2;
    public static final Color COLOR_WORKSHOP3;
    public static final Color COLOR_WORKSHOP4;
    public static final Color COLOR_WORKSHOP5;
    public static final Color COLOR_ARMOURY;
    public static final Color COLOR_BUILT;
    public static final Color COLOR_WONDERS;
    public static final Color COLOR_WAR_DARK;
    public static final Color COLOR_WAR_BRIGHT;
    public static final Color COLOR_SANCTIONS;
    public static final Color COLOR_FORTIFICATIONS_0;
    public static final Color COLOR_FORTIFICATIONS_1;
    public static final Color COLOR_FORTIFICATIONS_1_MOUNTAINS;
    public static int PROVINCE_BORDER_THICKNESS;
    public static int PROVINCE_BORDER_DASHED_THICKNESS;
    public static final Color COLOR_PROVINCE_BORDER_CIV_REGION;
    public static final float MAX_SCALE_DASHED = 4.0f;
    public static Color COLOR_PROVINCE_DASHED;
    public static Color COLOR_PROVINCE_SEABYSEA;
    public static Color COLOR_PROVINCE_STRAIGHT;
    public static Color COLOR_PROVINCE_STRAIGHT2;
    public static Color COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER;
    public static float fMOVE_MENU_PERCENTAGE;
    public static long lMOVE_MENU_TIME;
    public static View backToMenu;
    public static View goToMenu;
    public static View goToMenu2;
    public static String CREATE_SCENARIO_GAME_DATA_TAG;
    public static boolean CREATE_SCENARIO_IS_PART_OF_CAMPAIGN;
    public static List<Integer> lCREATE_SCENARIO_IS_PART_OF_CAMPAIGN_CIVSIDS;
    public static String CREATE_SCENARIO_NAME;
    public static String CREATE_SCENARIO_AUTHOR;
    public static String CREATE_SCENARIO_WIKI;
    public static int CREATE_SCENARIO_AGE;
    public static int iCreateScenario_ActiveProvinceID;
    public static int createScenarioAssignProvsCiv;
    public static List<List<Scenario_GameData_Technology>> lCreateScenario_TechnologyBContinents;
    public static boolean RELOAD_SCENARIO;
    public static List<Undo_AssignProvinceCiv> lCreateScenario_UndoAssignProvsCivID;
    public static String chosenAlphabetCharachter;
    public static String KEY_TEMP_INPUT = null;
    public static String sSearch;
    public static List<Integer> lCreateScenario_UndoWastelandProvinces;
    public static boolean bSetWasteland_AvailableProvinces;
    public static int iNumOfAvailableProvinces;
    public static int iNumOfAvailableProvincesWidth;
    public static int iNumOfWastelandProvinces;
    public static int iNumOfWastelandProvincesWidth;
    public static List<Image> flagOfCivilizationH;
    public static boolean MANAGE_DIPLOMACY_DRAW_HELP_LINE;
    public static int MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID;
    public static int MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID;
    public static int MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2;
    public static int MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1;
    public static int MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2;
    public static String sAtWar;
    public static Report_Data reportData;
    public static FlagManager flagManager;
    public static RandomGame_Manager randomGameManager;
    public static GameAges gameAges;
    public static MapModesManager mapModesManager;
    public static TimelapseManager timelapseManager;
    public static TutorialManager tutorialManager;
    public static PeaceTreaty_Data peaceTreatyData;
    public static HistoryManager historyManager;
    public static GameUpdate gameUpdate;
    public static LinesManager linesManager;
    public static LangManager lang;
    public static HolyRomanEmpire_Manager hreMgr;
    public static UnionFlagsToGenerate_Manager unionFlagsToGenerate_Manager;
    public static MenuManager menus;
    public static Map map;
    public static AI oAI;
    public static Toast toastM;
    public static Start_The_Game_Data startTheGameData;
    public static Pallet_Manager palletManager;
    public static IdeologiesManager ideologiesMgr;
    public static PlagueManager plagueManager;
    public static GameAction gameAction;
    public static NewGameManager gameNewGame;
    public static UnionsManager unionsManager;
    public static CreateVassal_Data createVassalData;
    public static TradeRequest_GameData tradeRequest;
    public static Ultimatum_GameData ultimatum;
    public static boolean brushMode;
    public static boolean selectMode;
    public static int slidePosX;
    public static int slidePosY;
    public static Color COLOR_CITY_NAME;
    public static String stripBOM(String s) {
        return s == null ? "" : s;
    }

    public static String stripBOM_JSON(String s) {
        return s == null ? "" : s;
    }

    public static GlyphLayout glyphLay = new GlyphLayout();

    public static void logText(String source, String text) {}

    private static final GlyphLayout glyphLayoutCache = new GlyphLayout();

    public static int getGlyphWidth(BitmapFont font, String text) {
        if (text == null || text.isEmpty() || font == null) return 0;
        synchronized (font.getData()) {
            try {
                glyphLayoutCache.setText(font, text);
                return (int)Math.ceil(glyphLayoutCache.width);
            } catch (Exception ex) {
                return text.length() * 12;
            }
        }
    }

    public static int getGlyphHeight(BitmapFont font, String text) {
        if (text == null || text.isEmpty() || font == null) return 0;
        synchronized (font.getData()) {
            try {
                glyphLayoutCache.setText(font, text);
                return (int)Math.ceil(glyphLayoutCache.height);
            } catch (Exception ex) {
                return 14;
            }
        }
    }
    
    public static void glyphLayoutSetText(BitmapFont font, String text) {
        if (font == null) return;
        synchronized (font.getData()) {
            glyphLay.setText(font, text == null ? "" : text);
        }
    }
    public static GlyphLayout glyphLayoutMoveUnits2;
    public static GlyphLayout glyphLayoutMoveUnits;
    public static GlyphLayout glyphLayoutArmy;
    public static List<BitmapFont> fontMain;
    public static BitmapFont fontArmy;
    public static BitmapFont fontBorder;
    public static BitmapFont fontBorder2;
    public static boolean lRBF;
    public static final float TEXT_SCALE = 0.9f;
    public static SFXManager SFXManager;
    public static final String FILE_UI_FONTS_PATH = "fonts/";
    public static final String FILE_UI_FONT_CHARACTERS_MAIN_PATH = "characters_main";
    public static final String FILE_UI_ICONS_PATH = "icons/";
    public static final String FILE_UI_INFOBOX_PATH = "infoBox/";
    public static final String FILE_UI_BOXES_PATH = "boxes/";
    public static final String FILE_UI_CROWNS_PATH = "crowns/";
    public static final String FILE_UI_BUTTONS_PATH = "buttons/";
    public static final String FILE_UI_GRADIENT_PATH = "gradients/";
    public static final String FILE_UI_SR_PATH = "sr/";
    public static final String FILE_UI_SR_OVER_PATH = "sr_over/";
    public static final String FILE_UI_NUKE_PATH = "nuke/";
    public static final String FILE_UI_TOPBAR_PATH = "top/";
    public static final String FILE_UI_BOTBAR_PATH = "bot/";
    public static final String FILE_UI_LINES_PATH = "lines/";
    public static final String FILE_UI_LOADING_PATH = "loading/";
    public static final String FILE_UI_FLAGS_PATH = "flags/";
    public static final String FILE_UI_TERRAIN_PATH = "terrain/";
    public static final String FILE_UI_BOTTOM_PATH = "bottom/";
    public static final String FILE_UI_EDITOR_PATH = "editor/";
    public static final String FILE_UI_DIALOG_PATH = "dialog/";
    public static final String FILE_UI_TITLE_PATH = "title/";
    public static final String FILE_UI_MAIN_MENU_PATH = "main_menu/";
    public static final String FILE_UI_NEW_GAME_PATH = "new_game/";
    public static final String FILE_UI_SLIDE_PATH = "slide/";
    public static final String FILE_UI_PICKER_PATH = "picker/";
    public static final String FILE_UI_FLAG_CAPITAL_PATH = "flag_capital/";
    public static final String FILE_UI_ARMY_PATH = "army/";
    public static final String FILE_UI_DIFFICULTY_PATH = "difficulty/";
    public static final String FILE_UI_GRAPH_PATH = "graph/";
    public static final String FILE_UI_SHIPS_PATH = "ships/";
    public static final String FILE_LANGUAGES_MOD_PATH = "languages/Bundle";
    public static final String FILE_GFX_SPARKS_PATH = "sparks/";
    public static final String FILE_UI_EVENTS_PATH = "events/";
    public static final String FILE_UI_EVENTS_DEFAULT = "default.png";
    public static final String FILE_UI_EVENTS_TEMPLATES_PATH = "templates/";
    public static final String FILE_UI_EVENTS_TEMPLATES_FILE = "EventTemplates.json";
    public static int ARMY_HEIGHT;
    public static float armyDrawScale = 1.0f;
    public static int TEXT_HEIGHT_DEFAULT;
    public static int TEXT_HEIGHT_DEFAULT_SMALL;
    public static int iProvinceNameWidth;
    public static final Color COLOR_ARMYBG;
    public static final Color COLOR_ARMY_CAPITAL_BG;
    public static final Color COLOR_ARMY_BG_ACTIVE;
    public static final Color COLOR_ARMY_BG_SEA;
    public static final Color COLOR_ARMY_BG_ALLIANCE;
    public static final Color COLOR_ARMY_TEXT_ALLIANCE;
    public static final Color COLOR_ARMY_BG_VASSAL;
    public static final Color COLOR_ARMY_BG_MOVEUNITS;
    public static Color COLOR_ARMY_TEXT;
    public static Color COLOR_ARMY_TEXT_ACTIVE;
    public static final Color COLOR_ARMY_TEXT_ACTIVE_NON_PLAYER;
    public static Color COLOR_ARMY_TEXT_CAPITAL_ACTIVE;
    public static Color COLOR_ARMY_TEXT_SEA;
    public static Color COLOR_ARMY_TEXT_SEA_ACTIVE;
    public static final float TEXT_SCALE_TOP_VIEWS = 0.6f;
    public static Color COLOR_GOLD;
    public static final Color COLOR_GOLD_HOVER;
    public static final Color COLOR_GOLD_ACTIVE;
    public static Color COLOR_MOVEMENT;
    public static final Color COLOR_MOVEMENT_HOVER;
    public static final Color COLOR_MOVEMENT_ACTIVE;
    public static Color COLOR_MOVEMENT_ZERO;
    public static final Color COLOR_MOVEMENT_ZERO_HOVER;
    public static final Color COLOR_MOVEMENT_ZERO_ACTIVE;
    public static Color COLOR_DIPLOMACY_POINTS;
    public static final Color COLOR_DIPLOMACY_POINTS_HOVER;
    public static final Color COLOR_DIPLOMACY_POINTS_ACTIVE;
    public static final Color COLOR_BG_GAME_MENU_SHADOW;
    public static final int REBELS_FLAGS_SIZE = 6;
    public static String keybMess;
    public static Keyboard_Action keyboardSave;
    public static Keyboard_Action keyboardDelete;
    public static Keyboard_Action_Write keyboardWrite;
    public static Menu_FlagPixel_Color flagPixelColor;
    public static int CIV_FLAG_WIDTH;
    public static int CIV_FLAG_HEIGHT;
    public static final int CIV_FLAG_WIDTH_FINAL = 27;
    public static final int CIV_FLAG_HEIGHT_FINAL = 18;
    public static boolean FLIP_Y_CIV_FLAG;
    public static byte FLIP_Y_CIV_FLAG_COUNTER;
    public static final byte FLIP_Y_CIV_FLAG_COUNTER_TRIC = 3;
    public static int flagR;
    public static int flagG;
    public static int flagB;
    public static FlagEditorMode flagEditorMode;
    public static Color COLOR_BOX_GRADIENT;
    private static ByteArrayInputStream b;
    private static ObjectInputStream o;
    public static String jsi;
    public static final String VERSION = "2.01 Definitive Edition";
    public static int iAgeOfCivilizationsWidth;
    public static final String LOGS_FILE = "logsAoH2DE.txt";
    public static boolean append;
    public static int appendNum;
    public static String jsig;
    public static List<String> randomProvinceNames;
    public static int numGold;
    public static int numSilver;
    public static int numBronze;
    public static EventsManager eventsManager;
    public static Core core;
    public static boolean MISSILE_STRIKE_MODE = false;
    public static DialogType dialogType;
    public static int iSelectCivilizationPlayerID;
    public static Alliances_Names_GameData editorAlliancesNames_GameData;
    public static int EDIT_ALLIANCE_NAMES_BUNDLE_ID;
    public static String CREATE_PACKAGE_ALLIANCE_NAMES_GAME_DATA_TAG;
    public static List<String> lRandomAlliancesNamesPackagesTags;
    public static Civilization_GameData3 editorCivilization_GameData;
    public static Achievement_Data achievementGD;
    public static ServiceRibbon_Manager serviceRibbonMgr;
    public static boolean loadedRobotoFont;
    public static final String sJakowski = "\u0141ukasz Jakowski";
    public static final String sJakowski_2 = "Lukasz Jakowski";
    public static final String sJakowskiGames = "\u0141ukasz Jakowski Games";
    public static final String sJakowskiGames_2 = "Lukasz Jakowski Games";
    public static int iJakowskiGamesWidth;
    public static final String sJakowskiGames_Presents = "presents";
    public static int iJakowskiGames_PresentsWidth;
    public static int SERVICE_RIBBON_WIDTH;
    public static int SERVICE_RIBBON_HEIGHT;
    public static final String BU = "Age of History 2: Definitive Edition";
    public static String jsiw;
    public static String jsigw;
    public static int iJGW;
    public static final String sJGP = "presents";
    public static int iJGPW;
    public static City editorCity;
    public static final String FILE_MAP_PROVINCE_NAMES = "province_names/";
    public static final String FILE_MAP_PROVINCE_NAMES_FILE = "names";
    public static final String FILE_MAP_SUGGESTED_OWNERS_PATH = "suggested_owners/";
    public static final String FILE_MAP_PRE_DEFINED_BORDERS_PATH = "predefined_borders/";
    public static final String FILE_MAP_CIVS_TEMPLATE_PATH = "civs_template/";
    public static final String FILE_MAP_CHALLENGES = "Challenges.json";

    public static void resetModes() {
        MISSILE_STRIKE_MODE = false;
        regroupArmyMode = false;
        chooseProvinceMode = false;
        migrateMode = false;
        brushMode = false;
        selectMode = false;
    }

    public static final Color getColorLine() {
        return colorLine;
    }

    public static boolean getLoadHighTextureMapOverlay() {
        if (!CFG.getIsDesktop()) {
            return false;
        }
        return GameValues.gvMapOverlays.LOAD_HIGH_QUALITY_OVERLAYS;
    }

    public static final void loadFormableCiv_GameData(String nCivTag) {
        try {
            try {
                FileHandle file = Gdx.files.local(F_MAP_PATH + map.getFileActiveMapPath() + FILE_MAP_FORMABLE_CIVS_PATH + nCivTag);
                formableCivs_GameData = (FormableCivs_GameData)CFG.deserialize(file.readBytes());
            }
            catch (GdxRuntimeException ex) {
                FileHandle file = FileManager.loadFile(F_MAP_PATH + map.getFileActiveMapPath() + FILE_MAP_FORMABLE_CIVS_PATH + nCivTag);
                formableCivs_GameData = (FormableCivs_GameData)CFG.deserialize(file.readBytes());
            }
        }
        catch (ClassNotFoundException e) {
            CFG.exceptionStack(e);
        }
        catch (Exception e) {
            CFG.exceptionStack(e);
        }
    }

    public static final boolean doesNotExists_FormableCiv(String nCivTag) {
        for (int i = 1; i < core.getCivsSize(); ++i) {
            if (!nCivTag.equals(core.getCiv(i).getCivTag())) continue;
            return false;
        }
        return true;
    }

    public static final Object FONT_LOCK = new Object();
    public static final boolean ownAllProvinces_FormableCiv(int nCivID) {
        FormableCivs_GameData temp = formableCivs_GameData;
        if (temp == null) {
            return false;
        }
        try {
            float requiredPerc = temp.getRequiredPerc();
            if (requiredPerc >= 1.0f) {
                for (int i = 0; i < temp.getProvincesSize(); ++i) {
                    int provID = temp.getProvinceID(i);
                    if (provID >= 0 && provID < core.getProvinSize()) {
                        if (core.getProv(provID).getWastelandLvl() >= 0 || core.getProv(provID).getCivId() == nCivID) continue;
                        return false;
                    }
                }
                return true;
            }
            int owned = 0;
            int total = 0;
            for (int i = 0; i < temp.getProvincesSize(); ++i) {
                int provID = temp.getProvinceID(i);
                if (provID < 0 || provID >= core.getProvinSize()) continue;
                if (core.getProv(provID).getWastelandLvl() >= 0) continue;
                ++total;
                if (core.getProv(provID).getCivId() != nCivID) continue;
                ++owned;
            }
            return total > 0 && (float)owned / (float)total >= requiredPerc;
        }
        catch (Exception ex) {
            return false;
        }
    }

    public static final int ownAllProvinces_FormableCiv_ControlsProvinces(int nCivID) {
        FormableCivs_GameData temp = formableCivs_GameData;
        if (temp == null) return 0;
        int out = 0;
        for (int i = 0; i < temp.getProvincesSize(); ++i) {
            if (core.getProv(temp.getProvinceID(i)).getWastelandLvl() >= 0 || core.getProv(temp.getProvinceID(i)).getCivId() != nCivID) continue;
            ++out;
        }
        return out;
    }

    public static final int ownAllProvinces_FormableCiv_NumOfProvinces(int nCivID) {
        FormableCivs_GameData temp = formableCivs_GameData;
        if (temp == null) return 0;
        int out = 0;
        for (int i = 0; i < temp.getProvincesSize(); ++i) {
            if (core.getProv(temp.getProvinceID(i)).getWastelandLvl() >= 0) continue;
            ++out;
        }
        return out;
    }

    public static final boolean isInFormableCivs(String nCivTag) {
        if (formableCivs_GameData.getFormableCivTag() != null && formableCivs_GameData.getFormableCivTag().equals(nCivTag)) {
            return true;
        }
        for (int i = 0; i < formableCivs_GameData.getClaimantsSize(); ++i) {
            if (!nCivTag.equals(formableCivs_GameData.getClaimant(i))) continue;
            return true;
        }
        return false;
    }

    public static final boolean isInLeaderCivs(String nCivTag) {
        for (int i = 0; i < leaderGameData.getCivsSize(); ++i) {
            if (!nCivTag.equals(leaderGameData.getCiv(i))) continue;
            return true;
        }
        return false;
    }

    public static final boolean readLocalFiles() {
        switch (Gdx.app.getType()) {
            case Android: 
            case iOS: {
                return true;
            }
            case Desktop: {
                return false;
            }
        }
        return false;
    }

    public static final Color getPopulationColor(int nData, float nAlpha) {
        switch (nData / 10) {
            case 0: {
                return CFG.getColorStep(COLOR_POP_GRADIENT[0], COLOR_POP_GRADIENT[1], nData % 10, 10, nAlpha);
            }
            case 1: {
                return CFG.getColorStep(COLOR_POP_GRADIENT[1], COLOR_POP_GRADIENT[2], nData % 10, 10, nAlpha);
            }
            case 2: {
                return CFG.getColorStep(COLOR_POP_GRADIENT[2], COLOR_POP_GRADIENT[3], nData % 10, 10, nAlpha);
            }
            case 3: {
                return CFG.getColorStep(COLOR_POP_GRADIENT[3], COLOR_POP_GRADIENT[4], nData % 10, 10, nAlpha);
            }
            case 4: {
                return CFG.getColorStep(COLOR_POP_GRADIENT[4], COLOR_POP_GRADIENT[5], nData % 10, 10, nAlpha);
            }
            case 5: {
                return CFG.getColorStep(COLOR_POP_GRADIENT[5], COLOR_POP_GRADIENT[6], nData % 10, 10, nAlpha);
            }
            case 6: {
                return CFG.getColorStep(COLOR_POP_GRADIENT[6], COLOR_POP_GRADIENT[7], nData % 10, 10, nAlpha);
            }
            case 7: {
                return CFG.getColorStep(COLOR_POP_GRADIENT[7], COLOR_POP_GRADIENT[8], nData % 10, 10, nAlpha);
            }
            case 8: {
                return CFG.getColorStep(COLOR_POP_GRADIENT[8], COLOR_POP_GRADIENT[9], nData % 10, 10, nAlpha);
            }
            case 9: {
                return CFG.getColorStep(COLOR_POP_GRADIENT[9], COLOR_POP_GRADIENT[10], nData % 10, 10, nAlpha);
            }
            case 10: {
                return new Color(CFG.COLOR_POP_GRADIENT[10].r, CFG.COLOR_POP_GRADIENT[10].g, CFG.COLOR_POP_GRADIENT[10].b, nAlpha);
            }
        }
        return new Color(CFG.COLOR_POP_GRADIENT[10].r, CFG.COLOR_POP_GRADIENT[10].g, CFG.COLOR_POP_GRADIENT[10].b, nAlpha);
    }

    public static Color getWarDeathsColor(int nData, float nAlpha) {
        switch (nData / 10) {
            case 0: {
                return CFG.getColorStep(COLOR_WAR_DEATHS[0], COLOR_WAR_DEATHS[1], nData % 10, 10, nAlpha);
            }
            case 1: {
                return CFG.getColorStep(COLOR_WAR_DEATHS[1], COLOR_WAR_DEATHS[2], nData % 10, 10, nAlpha);
            }
            case 2: {
                return CFG.getColorStep(COLOR_WAR_DEATHS[2], COLOR_WAR_DEATHS[3], nData % 10, 10, nAlpha);
            }
            case 3: {
                return CFG.getColorStep(COLOR_WAR_DEATHS[3], COLOR_WAR_DEATHS[4], nData % 10, 10, nAlpha);
            }
            case 4: {
                return CFG.getColorStep(COLOR_WAR_DEATHS[4], COLOR_WAR_DEATHS[5], nData % 10, 10, nAlpha);
            }
            case 5: {
                return CFG.getColorStep(COLOR_WAR_DEATHS[5], COLOR_WAR_DEATHS[6], nData % 10, 10, nAlpha);
            }
            case 6: {
                return CFG.getColorStep(COLOR_WAR_DEATHS[6], COLOR_WAR_DEATHS[7], nData % 10, 10, nAlpha);
            }
            case 7: {
                return CFG.getColorStep(COLOR_WAR_DEATHS[7], COLOR_WAR_DEATHS[8], nData % 10, 10, nAlpha);
            }
            case 8: {
                return CFG.getColorStep(COLOR_WAR_DEATHS[8], COLOR_WAR_DEATHS[9], nData % 10, 10, nAlpha);
            }
            case 9: {
                return CFG.getColorStep(COLOR_WAR_DEATHS[9], COLOR_WAR_DEATHS[10], nData % 10, 10, nAlpha);
            }
            case 10: {
                return new Color(CFG.COLOR_WAR_DEATHS[10].r, CFG.COLOR_WAR_DEATHS[10].g, CFG.COLOR_WAR_DEATHS[10].b, nAlpha);
            }
        }
        return new Color(CFG.COLOR_WAR_DEATHS[10].r, CFG.COLOR_WAR_DEATHS[10].g, CFG.COLOR_WAR_DEATHS[10].b, nAlpha);
    }

    public static final Color getPopulationColorRed(int nData, float nAlpha) {
        switch (nData / 10) {
            case 0: {
                return CFG.getColorStep(COLOR_POP_RED[0], COLOR_POP_RED[1], nData % 10, 10, nAlpha);
            }
            case 1: {
                return CFG.getColorStep(COLOR_POP_RED[1], COLOR_POP_RED[2], nData % 10, 10, nAlpha);
            }
            case 2: {
                return CFG.getColorStep(COLOR_POP_RED[2], COLOR_POP_RED[3], nData % 10, 10, nAlpha);
            }
            case 3: {
                return CFG.getColorStep(COLOR_POP_RED[3], COLOR_POP_RED[4], nData % 10, 10, nAlpha);
            }
            case 4: {
                return CFG.getColorStep(COLOR_POP_RED[4], COLOR_POP_RED[5], nData % 10, 10, nAlpha);
            }
            case 5: {
                return CFG.getColorStep(COLOR_POP_RED[5], COLOR_POP_RED[6], nData % 10, 10, nAlpha);
            }
            case 6: {
                return CFG.getColorStep(COLOR_POP_RED[6], COLOR_POP_RED[7], nData % 10, 10, nAlpha);
            }
            case 7: {
                return CFG.getColorStep(COLOR_POP_RED[7], COLOR_POP_RED[8], nData % 10, 10, nAlpha);
            }
            case 8: {
                return CFG.getColorStep(COLOR_POP_RED[8], COLOR_POP_RED[9], nData % 10, 10, nAlpha);
            }
            case 9: {
                return CFG.getColorStep(COLOR_POP_RED[9], COLOR_POP_RED[10], nData % 10, 10, nAlpha);
            }
            case 10: {
                return new Color(CFG.COLOR_POP_RED[10].r, CFG.COLOR_POP_RED[10].g, CFG.COLOR_POP_RED[10].b, nAlpha);
            }
        }
        return new Color(CFG.COLOR_POP_RED[10].r, CFG.COLOR_POP_RED[10].g, CFG.COLOR_POP_RED[10].b, nAlpha);
    }

    public static final void wikiInforLink(String sCivTag) {
        try {
            try {
                FileHandle readFile = FileManager.loadFile("game/civilizations_informations/" + sCivTag);
                String sLine = readFile.readString();
                Gdx.net.openURI(WWW_WIKI + sLine);
            }
            catch (GdxRuntimeException e) {
                FileHandle readFile = FileManager.loadFile("game/civilizations_informations/" + ideologiesMgr.getRealTag(sCivTag));
                String sLine = readFile.readString();
                Gdx.net.openURI(WWW_WIKI + sLine);
            }
        }
        catch (GdxRuntimeException ex) {
            toastM.addM(lang.get("NoData"));
        }
    }

    public static final String getwikiinforlink(String sCivTag) {
        try {
            FileHandle readFile = FileManager.loadFile("game/civilizations_informations/" + sCivTag);
            String sLine = readFile.readString();
            return WWW_WIKI + sLine;
        }
        catch (GdxRuntimeException e) {
            try {
                FileHandle readFile = FileManager.loadFile("game/civilizations_informations/" + ideologiesMgr.getRealTag(sCivTag));
                String sLine = readFile.readString();
                return WWW_WIKI + sLine;
            }
            catch (GdxRuntimeException ex) {
                return "/";
            }
        }
    }

    public static final String getResPath() {
        if (XXXHDPI) {
            return "interface/XXXH/";
        }
        if (XXHDPI) {
            return "interface/XXH/";
        }
        if (XHDPI) {
            return "interface/XH/";
        }
        return "interface/H/";
    }

    public static final String getResPathS() {
        if (XXXHDPI) {
            return "XXXH/";
        }
        if (XXHDPI) {
            return "XXH/";
        }
        if (XHDPI) {
            return "XH/";
        }
        return "H/";
    }

    public static final String getResPathSH() {
        return "H/";
    }

    public static final int getUIScale() {
        if (XXXHDPI) {
            return 3;
        }
        if (XXHDPI) {
            return 2;
        }
        if (XHDPI) {
            return 1;
        }
        return 0;
    }

    public static Point_XY2 getRandomPointToCenterTheMap() {
        return new Point_XY2(oR.nextInt(map.getMpB().getWidthM() / map.getMpB().getMapSc3()), oR.nextInt(map.getMpB().getHeightM() / map.getMpB().getMapSc3()));
    }

    public static Color getRandomColor() {
        return new Color((float)oR.nextInt(256) / 255.0f, (float)oR.nextInt(256) / 255.0f, (float)oR.nextInt(256) / 255.0f, 1.0f);
    }

    public static Color_GameData getRandomColorGameData() {
        return new Color_GameData((float)oR.nextInt(256) / 255.0f, (float)oR.nextInt(256) / 255.0f, (float)oR.nextInt(256) / 255.0f);
    }

    public static void setRenderO(boolean nRENDER) {
    }

    public static boolean getMetProv(int nProvinceID) {
        try {
            if (SANDBOX_MODE) {
                return true;
            }
            return core.getPlayer(PLAYER_TURN_ID).getMetProv(nProvinceID);
        }
        catch (Exception ex) {
            return true;
        }
    }

    public static boolean getMetCiv(int nCivID) {
        try {
            if (SANDBOX_MODE) {
                return true;
            }
            return core.getPlayer(PLAYER_TURN_ID).getMetCiv(nCivID);
        }
        catch (Exception ex) {
            return true;
        }
    }

    public static boolean getMetCiv_AllPlayers(int nCivID) {
        for (int i = 0; i < core.getPlayersSize(); ++i) {
            if (core.getCiv(core.getPlayer(i).getCivId()).getNumOfProvs() <= 0 || !core.getPlayer(i).getMetCiv(nCivID)) continue;
            return true;
        }
        return false;
    }

    public static long getPROVINCE_BORDER_ANIMATION_TIME(String nKey) {
        try {
            return PROVINCE_BORDER_ANIMATION_TIME.get(nKey);
        }
        catch (Exception ex) {
            return 0L;
        }
    }

    public static final void saveSettings_ActiveMap() {
        block2: {
            try {
                FileHandle file = FileManager.IS_MAC ? Gdx.files.external(FILE_SETTINGS_LAST_ACTIVE_MAP) : Gdx.files.local(FILE_SETTINGS_LAST_ACTIVE_MAP);
                SaveActiveMap_GameData tempLA = new SaveActiveMap_GameData();
                tempLA.iActiveMapID = map.getActiveMapIDN();
                tempLA.iActiveMapScale = map.getMapScale_PreExtra(map.getActiveMapIDN());
                file.writeBytes(CFG.serialize(tempLA), false);
            }
            catch (IOException ex) {
                if (!LOGs) break block2;
                CFG.exceptionStack(ex);
            }
        }
    }

    public static final void saveSettings_LoadingStatus() {
    }

    public static final void saveSettings() {
        block6: {
            block5: {
                try {
                    if (CFG.getIsDesktop()) {
                        Json json = EventsJ.getJson();
                        json.setTypeName("class");
                        json.setUsePrototypes(false);
                        json.setOutputType(JsonWriter.OutputType.javascript);
                        FileHandle file = FileManager.IS_MAC ? Gdx.files.external(FILE_SETTINGSJ) : Gdx.files.local(FILE_SETTINGSJ);
                        file.writeString(json.prettyPrint(settingsGD), false);
                    }
                }
                catch (Exception ex) {
                    if (!LOGs) break block5;
                    CFG.exceptionStack(ex);
                }
            }
            try {
                FileHandle file = FileManager.IS_MAC ? Gdx.files.external(FILE_SETTINGS) : Gdx.files.local(FILE_SETTINGS);
                file.writeBytes(CFG.serialize(settingsGD), false);
            }
            catch (IOException ex) {
                if (!LOGs) break block6;
                CFG.exceptionStack(ex);
            }
        }
    }

    public static final void loadSettings() {
        block8: {
            boolean settingsLoaded = false;
            try {
                FileHandle fileE;
                if (CFG.getIsDesktop() && (fileE = FileManager.loadFile(FILE_SETTINGSJ)).exists()) {
                    Json json = EventsJ.getJson();
                    settingsGD = json.fromJson(SettingsGD.class, fileE.readString());
                    settingsGD.updateDiscoveryFloat();
                    AoCGame.LEFT += CFG.settingsGD.MENU_EXTRA_LEFT;
                    settingsLoaded = true;
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            if (!settingsLoaded) {
                try {
                    FileHandle fileS = FileManager.loadFile(FILE_SETTINGS);
                    settingsGD = (SettingsGD)CFG.deserialize(fileS.readBytes());
                    settingsGD.updateDiscoveryFloat();
                    AoCGame.LEFT += CFG.settingsGD.MENU_EXTRA_LEFT;
                }
                catch (Exception e) {
                    if (CFG.getIsDesktop()) break block8;
                    CFG.settingsGD.CAPITAL_FLAGS_HIGH = true;
                    CFG.settingsGD.SPROVN = 1;
                    CFG.settingsGD.ANDROID_LOAD_MAP_OVERLAYS = false;
                    CFG.settingsGD.CLOUDS = false;
                }
            }
        }
        try {
            COLOR_PROVINCE_STRAIGHT = new Color(CFG.settingsGD.borderStraight.getR(), CFG.settingsGD.borderStraight.getG(), CFG.settingsGD.borderStraight.getB(), CFG.COLOR_PROVINCE_STRAIGHT.a);
            COLOR_PROVINCE_DASHED = new Color(CFG.settingsGD.borderDashed.getR(), CFG.settingsGD.borderDashed.getG(), CFG.settingsGD.borderDashed.getB(), CFG.COLOR_PROVINCE_DASHED.a);
        }
        catch (Exception exception) {
        }
        core.updateDrawCapitalFlagMap();
    }

    public static Color getColor_CivInfo_Text(boolean isActive, boolean isHovered) {
        return isActive ? COLOR_TEXT_CIV_INFO_ACTIVE : (isHovered ? COLOR_TEXT_CIV_INFO_HOVER : COLOR_TEXT_CIV_INFO);
    }

    public static Color getColor_CivInfo_InGame_Text(boolean isActive, boolean isHovered) {
        return isActive ? COLOR_TEXT_CIV_INFO_ACTIVE : (isHovered ? COLOR_TEXT_CIV_INFO_HOVER : COLOR_NEUTRAL);
    }

    public static final String getWikiInforLinkClear(String sCivTag) {
        try {
            FileHandle readFile = FileManager.loadFile("game/civilizations_informations/" + sCivTag);
            String sLine = readFile.readString();
            return sLine;
        }
        catch (GdxRuntimeException e) {
            try {
                FileHandle readFile = FileManager.loadFile("game/civilizations_informations/" + ideologiesMgr.getRealTag(sCivTag));
                String sLine = readFile.readString();
                return sLine;
            }
            catch (GdxRuntimeException ex) {
                return lang.get("NoData");
            }
        }
    }

    public static final List<String> getFileNames_O(String nPath) {
        ArrayList<String> filesNames = new ArrayList<String>();
        FileHandle dirHandle = Gdx.app.getType() == Application.ApplicationType.Android ? FileManager.loadFile(nPath) : FileManager.loadFile(nPath);
        for (FileHandle entry : dirHandle.list()) {
            filesNames.add(entry.name());
        }
        return filesNames;
    }

    public static final List<String> getFileNames_O_Classic(String nPath) {
        ArrayList<String> filesNames = new ArrayList<String>();
        FileHandle dirHandle = FileManager.IS_MAC ? Gdx.files.external(nPath) : (Gdx.app.getType() == Application.ApplicationType.Android ? Gdx.files.internal(nPath) : Gdx.files.internal(nPath));
        for (FileHandle entry : dirHandle.list()) {
            filesNames.add(entry.name());
        }
        return filesNames;
    }

    protected static final List<String> getFileNames_Absolute(String nPath) {
        ArrayList<String> filesNames = new ArrayList<String>();
        FileHandle dirHandle = Gdx.files.absolute(nPath);
        for (FileHandle entry : dirHandle.list()) {
            filesNames.add(entry.name());
        }
        return filesNames;
    }

    public static final List<String> getFileNames2(String nPath) {
        ArrayList<String> filesNames = new ArrayList<String>();
        if (Gdx.app.getType() == Application.ApplicationType.Android) {
            ArrayList filesNames1 = new ArrayList();
            if (filesNames1 == null) {
                return null;
            }
            FileHandle dirHandle = FileManager.loadFile(nPath);
            for (FileHandle entry : dirHandle.list()) {
                filesNames.add(entry.name());
            }
            ArrayList<String> filesNames2 = new ArrayList<String>();
            FileHandle dirHandle2 = Gdx.files.local(nPath);
            for (FileHandle entry : dirHandle2.list()) {
                filesNames2.add(entry.name());
            }
            if (filesNames2.size() > filesNames.size()) {
                return filesNames2;
            }
            return filesNames;
        }
        return filesNames;
    }

    public static final int getFileNames_Length2(String nPath) {
        FileHandle dirHandle = Gdx.app.getType() == Application.ApplicationType.Android ? FileManager.loadFile(nPath) : FileManager.loadFile(nPath);
        return dirHandle.list().length;
    }

    public static final String getDifficultyName(int i) {
        switch (i) {
            case 0: {
                return lang.get(GameValues.gvDifficulty.BEGINNER_NAME);
            }
            case 1: {
                return lang.get(GameValues.gvDifficulty.NORMAL_NAME);
            }
            case 2: {
                return lang.get(GameValues.gvDifficulty.HARD_NAME);
            }
            case 4: {
                return lang.get(GameValues.gvDifficulty.EXTREME_NAME);
            }
        }
        return lang.get(GameValues.gvDifficulty.LEGENDARY_NAME);
    }

    public static final String getFogOfWarName(int i) {
        switch (i) {
            case 0: {
                return lang.get("Off");
            }
            case 2: {
                return lang.get("Discovery");
            }
        }
        return lang.get("Classic");
    }

    public static final boolean isInTheCivGameTag(String nCivTag) {
        for (int i = 1; i < core.getCivsSize(); ++i) {
            if (!nCivTag.equals(core.getCiv(i).getCivTag())) continue;
            return true;
        }
        return false;
    }

    public static final boolean isInTheGame_OrIsFormableCiv(String nCivTag) {
        int i;
        for (i = 1; i < core.getCivsSize(); ++i) {
            if (!nCivTag.equals(core.getCiv(i).getCivTag())) continue;
            return true;
        }
        for (i = 1; i < core.getCivsSize(); ++i) {
            for (int j = 0; j < core.getCiv(i).getTagsCanFormCSize(); ++j) {
                if (!nCivTag.equals(core.getCiv(i).getTagsCanFormC(j))) continue;
                return true;
            }
        }
        return false;
    }

    public static void addRemoveChosenProvinceRegroup(int id) {
        if (!chosenProvinces_Regroup.contains(id)) {
            chosenProvinces_Regroup.add(id);
            return;
        }
        try {
            if (chosenProvinces_Regroup.size() < 2) {
                return;
            }
            for (int i = chosenProvinces_Regroup.size() - 1; i >= 0; --i) {
                if (chosenProvinces_Regroup.get(i) != id) continue;
                chosenProvinces_Regroup.remove(i);
                return;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void addChosenProvinceRegroup(int id) {
        if (!chosenProvinces_Regroup.contains(id)) {
            chosenProvinces_Regroup.add(id);
        }
    }

    public static void removeChosenProvinceRegroup(int id) {
        try {
            for (int i = chosenProvinces_Regroup.size() - 1; i >= 0; --i) {
                if (chosenProvinces_Regroup.get(i) != id) continue;
                chosenProvinces_Regroup.remove(i);
                return;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void clearChosenProvinceRegroup() {
        chosenProvinces_Regroup.clear();
    }

    public static final int getCostOfRecruitArmyMoney_Instantly(int nProvinceID) {
        return (int)((float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT * GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT_CONSCRIPT_EXTRA - (float)(core.getProv(nProvinceID).getLvlOfArmoury() > 0 ? GameValues.gvBuildingArmoury.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT_REDUCTION * core.getProv(nProvinceID).getLvlOfArmoury() : 0));
    }

    public static final int getCostOfRecruitArmyMoney_Mercenaries() {
        return (int)((float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT * GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT_MERCENARIES_EXTRA);
    }

    public static final void drawVersion_LEFT_BOT(SpriteBatch oSB, int iTranslateX) {
        Renderer.drawText(oSB, FONT_REGULAR_SMALL, sVERSION + ": " + VERSION, PADD + iTranslateX, GAMEHEIGHT - PADD - TEXT_HEIGHT_DEFAULT_SMALL, new Color(1.0f, 1.0f, 1.0f, 0.25f));
    }

    public static final void drawJakowskiGames_RIGHT_BOT(SpriteBatch oSB, int iTranslateX) {
        Renderer.drawText(oSB, FONT_REGULAR_SMALL, CFG.gLG(), GAMEWIDTH - PADD - iJGW + iTranslateX, GAMEHEIGHT - TEXT_HEIGHT_DEFAULT_SMALL - PADD, new Color(1.0f, 1.0f, 1.0f, 0.25f));
    }

    public static final void drawJakowskiGames_RIGHT_BOT(SpriteBatch oSB, int iTranslateX, float nPerc) {
        Renderer.drawText(oSB, FONT_REGULAR_SMALL, CFG.gLG(), GAMEWIDTH - PADD - iJGW + iTranslateX, GAMEHEIGHT - TEXT_HEIGHT_DEFAULT_SMALL - PADD, new Color(1.0f, 1.0f, 1.0f, 0.25f));
    }

    public static void drL0A(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float nProgress) {
        CFG.drL0A(oSB, nPosX, nPosY, nWidth, nHeight, nProgress, "");
    }

    public static void drL0A(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float nProgress, String extraText) {
        long PRESENTS_TIME;
        block8: {
            if (nProgress > 1.0f) {
                nProgress = 1.0f;
            } else if (nProgress < 0.0f) {
                nProgress = 0.0f;
            }
            if (System.currentTimeMillis() - 2500L > loaTM) {
                try {
                    sLoadingText = lang.getLOA("L" + oR.nextInt(CFG.lang.iLNOT)) + "..";
                    loadingTime = System.currentTimeMillis();
                    glyphLay.setText(fontMain.get(0), sLoadingText);
                    iLoadingTextWidth = (int)(CFG.glyphLay.width * LOADING_TEXT_FONT_SCALE);
                }
                catch (IllegalArgumentException ex) {
                    if (!LOGs) break block8;
                    CFG.exceptionStack(ex);
                }
            }
        }
        if ((PRESENTS_TIME = 0L) == 0L) {
            PRESENTS_TIME = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() < PRESENTS_TIME) {
            int tH = TEXT_HEIGHT_DEFAULT * 3 + PADD * 8;
            int tY = GAMEHEIGHT / 2 - tH / 2;
            oSB.setColor(COLOR_GRADIENT_MENU_BLUE);
            IMGManager.getIMG(Images.pix255).draw(oSB, 0, tY, GAMEWIDTH, tH);
            oSB.setColor(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.225f);
            IMGManager.getIMG(Images.line32Off1).draw(oSB, 0, tY, GAMEWIDTH, tH);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
            IMGManager.getIMG(Images.gradient).draw(oSB, 0, tY, GAMEWIDTH, PADD);
            IMGManager.getIMG(Images.gradient).draw(oSB, 0, tY + tH - PADD, GAMEWIDTH, PADD, false, true);
            oSB.setColor(COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.pix255).draw(oSB, 0, tY + 1, GAMEWIDTH, 1);
            IMGManager.getIMG(Images.pix255).draw(oSB, 0, tY + tH - 2, GAMEWIDTH, 1);
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.325f);
            IMGManager.getIMG(Images.pix255).draw(oSB, 0, tY, GAMEWIDTH, 1);
            IMGManager.getIMG(Images.pix255).draw(oSB, 0, tY + tH - 1, GAMEWIDTH, 1);
            oSB.setColor(Color.WHITE);
            oSB.setColor(Color.WHITE);
            CFG.drawTextDefault(oSB, CFG.getLukaszJakowskiGames(), GAMEWIDTH / 2 - iJakowskiGamesWidth / 2, tY + PADD * 2 + PADD / 2, COLOR_HOVER_TITLE);
            CFG.drawTextDefault(oSB, "presents", GAMEWIDTH / 2 - iJakowskiGames_PresentsWidth / 2, tY + TEXT_HEIGHT_DEFAULT + PADD * 3 + PADD / 2, COLOR_HOVER_TITLE);
            CFG.drawTextDefault(oSB, BU, GAMEWIDTH / 2 - iJakowskiGamesWidth / 2, tY + TEXT_HEIGHT_DEFAULT * 2 + PADD * 5 + PADD / 2, COLOR_TEXT_NUM_OF_PROVINCES);
            oSB.setColor(Color.WHITE);
        }
        oSB.setColor(new Color(0.019607844f, 0.02745098f, 0.03529412f, 0.75f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), (int)((float)nWidth * nProgress), nHeight);
        oSB.setColor(new Color(0.043137256f, 0.05882353f, 0.07450981f, 0.65f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + (int)((float)nWidth * nProgress), nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth - (int)((float)nWidth * nProgress), nHeight);
        oSB.setColor(COLOR_LOADING_SPLIT);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + (int)((float)nWidth * nProgress), nPosY - IMGManager.getIMG(Images.pix255).getHeight(), 1, nHeight);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.loading_rect_edge).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.loading_rect_edge).getHeight(), nWidth - IMGManager.getIMG(Images.loading_rect_edge).getWidth(), nHeight - IMGManager.getIMG(Images.loading_rect_edge).getHeight());
        IMGManager.getIMG(Images.loading_rect_edge).draw2O(oSB, nPosX + nWidth - IMGManager.getIMG(Images.loading_rect_edge).getWidth(), nPosY - IMGManager.getIMG(Images.loading_rect_edge).getHeight(), IMGManager.getIMG(Images.loading_rect_edge).getWidth(), nHeight - IMGManager.getIMG(Images.loading_rect_edge).getHeight(), true);
        IMGManager.getIMG(Images.loading_rect_edge).draw2O(oSB, nPosX, nPosY + nHeight - IMGManager.getIMG(Images.loading_rect_edge).getHeight() * 2, nWidth - IMGManager.getIMG(Images.loading_rect_edge).getWidth(), IMGManager.getIMG(Images.loading_rect_edge).getHeight(), false, true);
        IMGManager.getIMG(Images.loading_rect_edge).drawO(oSB, nPosX + nWidth - IMGManager.getIMG(Images.loading_rect_edge).getWidth(), nPosY + nHeight - IMGManager.getIMG(Images.loading_rect_edge).getHeight(), true, true);
        oSB.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.45f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX, nPosY + nHeight - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
        Renderer.drawTextWithShadow(oSB, FONT_BOLD, sLOATXT, nPosX + nWidth / 2 - iLOADW / 2, nPosY + (nHeight - iLOAH) / 2, new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 1.0f));
        Renderer.drawTextWithShadow(oSB, FONT_BOLD, sLoading + " " + (int)(nProgress * 100.0f) + "%" + extraText, nPosX, nPosY - PADD - TEXT_HEIGHT_DEFAULT, new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 1.0f));
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.35f));
        IMGManager.getIMG(Images.gameLogo).draw2O(oSB, nPosX + nWidth - IMGManager.getIMG(Images.gameLogo).getWidth(), nPosY - PADD * 2 - IMGManager.getIMG(Images.gameLogo).getHeight() * 2, IMGManager.getIMG(Images.gameLogo).getWidth(), IMGManager.getIMG(Images.gameLogo).getHeight());
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameLogo).draw2O(oSB, nPosX + nWidth - IMGManager.getIMG(Images.gameLogo).getWidth(), nPosY - PADD * 2 - IMGManager.getIMG(Images.gameLogo).getHeight() * 2, (int)((float)IMGManager.getIMG(Images.gameLogo).getWidth() * nProgress), IMGManager.getIMG(Images.gameLogo).getHeight());
    }

    public static final void drawLogo_Square(SpriteBatch oSB, int nPosX, int nPosY, int tempSize) {
        oSB.setColor(Color.BLACK);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), tempSize, tempSize);
        oSB.setColor(Color.WHITE);
        map.getMpB().drawMap_LogoSquare(oSB, nPosX, nPosY, tempSize, tempSize);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight(), tempSize, (int)((float)tempSize * 0.15f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight() + tempSize - (int)((float)tempSize * 0.15f), tempSize, (int)((float)tempSize * 0.15f), false, true);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), (int)((float)tempSize * 0.15f), tempSize, false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + tempSize - (int)((float)tempSize * 0.15f), nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), (int)((float)tempSize * 0.15f), tempSize, true, false);
        oSB.setColor(COLOR_FLAG_FRAME);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 1, nPosY - IMGManager.getIMG(Images.pix255).getHeight() + 1, tempSize - 2, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 1, nPosY + tempSize - IMGManager.getIMG(Images.pix255).getHeight() - 2, tempSize - 2, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + 1, nPosY - IMGManager.getIMG(Images.pix255).getHeight() + 1, 1, tempSize - 2);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + tempSize - 2, nPosY - IMGManager.getIMG(Images.pix255).getHeight() + 1, 1, tempSize - 2);
        oSB.setColor(Color.WHITE);
        if ((float)IMGManager.getIMG(Images.gameLogo).getWidth() > (float)tempSize * 0.5f) {
            IMGManager.getIMG(Images.gameLogo).drawO(oSB, nPosX + tempSize - PADD - (int)((float)IMGManager.getIMG(Images.gameLogo).getWidth() * 0.5f), nPosY + tempSize - PADD - IMGManager.getIMG(Images.gameLogo).getHeight() - (int)((float)IMGManager.getIMG(Images.gameLogo).getHeight() * 0.5f), (int)((float)IMGManager.getIMG(Images.gameLogo).getWidth() * 0.5f), (int)((float)IMGManager.getIMG(Images.gameLogo).getHeight() * 0.5f));
        } else {
            IMGManager.getIMG(Images.gameLogo).drawO(oSB, nPosX + tempSize - PADD - IMGManager.getIMG(Images.gameLogo).getWidth(), nPosY + tempSize - PADD - IMGManager.getIMG(Images.gameLogo).getHeight());
        }
    }

    public static final int getActiveCivInfo_BasedOnActiveProvinceID(int nProvinceID) {
        if (nProvinceID >= 0) {
            if (FOG_OF_WAR == 2) {
                if (core.getProv(nProvinceID).getCivId() > 0 && CFG.getMetProv(nProvinceID)) {
                    return core.getProv(nProvinceID).getCivId();
                }
                return core.getPlayer(PLAYER_TURN_ID).getCivId();
            }
            if (core.getProv(nProvinceID).getCivId() > 0) {
                return core.getProv(nProvinceID).getCivId();
            }
            return core.getPlayer(PLAYER_TURN_ID).getCivId();
        }
        return core.getPlayer(PLAYER_TURN_ID).getCivId();
    }

    public static final int getActiveCivInfoId() {
        return activeCivInfoId;
    }

    public static final int getActiveCivID_Any() {
        int id = getActiveCivInfoId();
        if (id <= 0 && core.getActiveProvID() >= 0 && core.getProv(core.getActiveProvID()).getCivId() > 0) {
            id = core.getProv(core.getActiveProvID()).getCivId();
        }
        if (id <= 0 && menus != null) {
            if (menus.getHoveredProvinceID() >= 0 && core.getProv(menus.getHoveredProvinceID()).getCivId() > 0) {
                id = core.getProv(menus.getHoveredProvinceID()).getCivId();
            }
        }
        if (id <= 0) {
            id = MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID;
        }
        
        if (id == core.getPlayer(PLAYER_TURN_ID).getCivId()) {
            id = -1;
        }
        return id;
    }

    public static final void setActiveCivInfoFlag(Image nFlag) {
        try {
            CFG.disposeActiveCivFlagD();
            activeCivFlag = nFlag;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void setActiveCivInfoId(int nActiveCivInfo) {
        block13: {
            try {
                CFG.disposeActiveCivFlagD();
                activeCivInfoId = nActiveCivInfo;
                if (core.getCiv(activeCivInfoId).getCivTag().indexOf(59) > 0) {
                    CFG.unionFlagsToGenerate_Manager.lFlags.add(new UnionFlagsToGenerate());
                    int tGenerateID = CFG.unionFlagsToGenerate_Manager.lFlags.size() - 1;
                    String[] tempD = core.getCiv(activeCivInfoId).getCivTag().split(";");
                    for (int i = 0; i < tempD.length; ++i) {
                        CFG.unionFlagsToGenerate_Manager.lFlags.get((int)tGenerateID).lTags.add(tempD[i]);
                    }
                    CFG.unionFlagsToGenerate_Manager.lFlags.get((int)tGenerateID).typeOfAction = UnionFlagsToGenerate_TypesOfAction.ACTIVE_CIV_INFO;
                    return;
                }
                try {
                    if (!(activeCivLeader.isEmpty() || CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData != null && CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData.getImage().length() != 0 && loadedLeader.equals(CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData.getImage()))) {
                        CFG.disposeActiveCivLeader();
                    }
                }
                catch (Exception tGenerateID) {
                    
                }
                if (CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData == null || CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData.getImage().length() <= 0 || loadedLeader.equals(CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData.getImage())) break block13;
                leaderFrameID = 0;
                leaderFrameSize = 0;
                leaderTime = currentTimeMillis;
                try {
                    loadedLeader = CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData.getImage();
                    int dotIndex = CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData.getImage().lastIndexOf(46);
                    if (dotIndex == -1 || !CFG.getIsDesktop()) {
                        activeCivLeader.add(new Image(new Texture(FileManager.loadFile("game/leadersIMG/" + CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData.getImage())), Texture.TextureFilter.Linear));
                        leaderFrameSize = activeCivLeader.size();
                        break block13;
                    }
                    String name = CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData.getImage().substring(0, dotIndex);
                    String extension = CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData.getImage().substring(dotIndex);
                    if (FileManager.loadFile("game/leadersIMG/" + name + "0" + extension).exists()) {
                        for (int i = 0; i < 256 && FileManager.loadFile("game/leadersIMG/" + name + i + extension).exists(); ++i) {
                            activeCivLeader.add(new Image(new Texture(FileManager.loadFile("game/leadersIMG/" + name + i + extension)), Texture.TextureFilter.Linear));
                        }
                    } else {
                        activeCivLeader.add(new Image(new Texture(FileManager.loadFile("game/leadersIMG/" + CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData.getImage())), Texture.TextureFilter.Linear));
                    }
                    leaderFrameSize = activeCivLeader.size();
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                    CFG.disposeActiveCivLeader();
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public static final void updateActiveCivInfo_CreateNewGame() {
        menus.getCreate_NewGame_Civ_Info().getMenuElem(1).setTextE("" + core.getCiv(activeCivInfoId).getCivName());
        menus.getCreate_NewGame_Civ_Info().getMenuElem(0).setTextE("" + core.getCiv(activeCivInfoId).getRankPos());
        menus.getCreate_NewGame_Civ_Info().getMenuElem(3).setCurr(activeCivInfoId);
        menus.getCreate_NewGame_Civ_Info().getMenuElem(4).setVisibleE(CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData != null && CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData.getName().length() > 0);
        if (menus.getCreate_NewGame_Civ_Info().getMenuElem(4).getVisibleE()) {
            menus.getCreate_NewGame_Civ_Info().getMenuElem(4).setTextE(CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData.getName());
        }
        if (menus.getCreate_NewGame_Civ_Info().getMenuElem(4).getVisibleE()) {
            menus.getCreate_NewGame_Civ_Info().getMenuElem(3).setHeightE(PADD * 2 + TEXT_HEIGHT_DEFAULT);
            menus.getCreate_NewGame_Civ_Info().getMenuElem(4).setHeightE(PADD * 2 + TEXT_HEIGHT_DEFAULT);
            int totalH = menus.getCreate_NewGame_Civ_Info().getHeightM();
            int elemH = (int)((float)TEXT_HEIGHT_DEFAULT + (float)TEXT_HEIGHT_DEFAULT * 0.8f * 2.0f + (float)(PADD * 2));
            totalH -= elemH;
            totalH = Math.min(totalH, menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY() * 2);
            int elementH2 = (menus.getCreate_NewGame_Civ_Info().getHeightM() - menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY() * 2 - PADD * 4) / 3;
            menus.getCreate_NewGame_Civ_Info().getMenuElem(1).setPosY(menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY());
            menus.getCreate_NewGame_Civ_Info().getMenuElem(1).setHeightE(elementH2);
            menus.getCreate_NewGame_Civ_Info().getMenuElem(3).setPosY(menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY() + PADD + elementH2);
            menus.getCreate_NewGame_Civ_Info().getMenuElem(3).setHeightE(elementH2);
            menus.getCreate_NewGame_Civ_Info().getMenuElem(4).setPosY(menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY() + PADD * 2 + elementH2 * 2);
            menus.getCreate_NewGame_Civ_Info().getMenuElem(4).setHeightE(elementH2);
        } else {
            int elementH2 = (menus.getCreate_NewGame_Civ_Info().getHeightM() - menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY() * 2 - PADD * 4) / 3;
            menus.getCreate_NewGame_Civ_Info().getMenuElem(1).setPosY(menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY());
            menus.getCreate_NewGame_Civ_Info().getMenuElem(1).setHeightE(elementH2);
            menus.getCreate_NewGame_Civ_Info().getMenuElem(3).setPosY(menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY() + PADD + elementH2);
            menus.getCreate_NewGame_Civ_Info().getMenuElem(3).setHeightE(elementH2);
        }
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(1).setTextE("" + CFG.getNumberWthSpaces("" + core.getCiv(activeCivInfoId).countPop()));
        try {
            menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(3).setTextE("" + (core.getProv(core.getCiv(activeCivInfoId).getCapitalProvID()).getCitSize() > 0 ? core.getProv(core.getCiv(activeCivInfoId).getCapitalProvID()).getCit(0).getCityName() : core.getProv(core.getCiv(activeCivInfoId).getCapitalProvID()).getName()));
        }
        catch (IndexOutOfBoundsException ex) {
            menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(3).setTextE(lang.get("NoData"));
        }
        try {
            if (core.getCiv(activeCivInfoId).getNumOfProvs() > 0) {
                int nLargestCity = core.getCiv(activeCivInfoId).getProvID(0);
                for (int i = 1; i < core.getCiv(activeCivInfoId).getNumOfProvs(); ++i) {
                    if (core.getProv(nLargestCity).getPop().getPops() >= core.getProv(core.getCiv(activeCivInfoId).getProvID(i)).getPop().getPops()) continue;
                    nLargestCity = core.getCiv(activeCivInfoId).getProvID(i);
                }
                menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(5).setTextE(core.getProv(nLargestCity).getCitSize() > 0 ? core.getProv(nLargestCity).getCit(0).getCityName() : core.getProv(nLargestCity).getName());
                menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(5).setCurr(nLargestCity);
            } else {
                menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(5).setTextE(lang.get("NoData"));
            }
        }
        catch (IndexOutOfBoundsException ex) {
            menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(5).setTextE(lang.get("NoData"));
        }
        ArrayList<Integer> nCivs = new ArrayList<Integer>();
        ArrayList<Long> nData = new ArrayList<Long>();
        boolean addNewData = true;
        for (int i = 0; i < core.getCiv(activeCivInfoId).getNumOfProvs(); ++i) {
            for (int j = 0; j < core.getProv(core.getCiv(activeCivInfoId).getProvID(i)).getPop().getNatsSize(); ++j) {
                addNewData = true;
                for (int k = 0; k < nCivs.size(); ++k) {
                    if (((Integer)nCivs.get(k)).intValue() != core.getProv(core.getCiv(activeCivInfoId).getProvID(i)).getPop().getCivID(j)) continue;
                    addNewData = false;
                    nData.set(k, nData.get(k) + core.getProv(core.getCiv(activeCivInfoId).getProvID(i)).getPop().getPopulationID(j));
                    break;
                }
                if (!addNewData) continue;
                nCivs.add(core.getProv(core.getCiv(activeCivInfoId).getProvID(i)).getPop().getCivID(j));
                nData.add(core.getProv(core.getCiv(activeCivInfoId).getProvID(i)).getPop().getPopulationID(j));
            }
        }
        if (nCivs.size() == 0) {
            nCivs.add(activeCivInfoId);
            nData.add(1L);
        }
        addNewData = menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(6).getIsInView();
        menus.getCreate_NewGame_Civ_Info_Stats().setMenuElem(6, new Graph_Circle(menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(6).getPosXE(), menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(6).getPosY(), nData, nCivs, null){

            @Override
            public void buildElemHover() {
                this.menuElemHover = core.getHover_PopulationOfCiv(CFG.getActiveCivInfoId());
            }
        });
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(6).setIsInView(addNewData);
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(6).setAnotherView(false);
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(6).setCheckboxSt(false);
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(7).setTextE("" + CFG.getPrecision2((float)gameAction.getCivMovementPoints(activeCivInfoId) / 10.0f, 10));
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(8).setTextE("" + (float)((int)(core.getCiv(activeCivInfoId).getTechLevel() * 100.0f)) / 100.0f);
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(10).setTextE("" + CFG.getNumber_SHORT(core.getCiv(activeCivInfoId).countEco()));
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(12).setCurr(CFG.getCivDifficulty(activeCivInfoId));
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(13).setCurr(core.getCiv(activeCivInfoId).getHappiness());
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(14).setCurr(core.getCiv(activeCivInfoId).getIdeology());
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(15).setCurr(core.getCiv(activeCivInfoId).getReligionID());
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(15).setTextE("" + religionManager.getReligion(core.getCiv(activeCivInfoId).getReligionID()).getName());
        if (core.getCiv(activeCivInfoId).getIsPartOfHolyRomanEmpire()) {
            menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(14).setCurr(-1);
            if (hreMgr.getHRE().getIsEmperor(activeCivInfoId)) {
                menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(14).setTextE(lang.get("Emperor"));
            } else if (hreMgr.getHRE().getIsElector(activeCivInfoId)) {
                menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(14).setTextE(lang.get("Elector"));
            } else {
                menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(14).setTextE(lang.get("Prince"));
            }
        } else {
            menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(14).setCurr(core.getCiv(activeCivInfoId).getIdeology());
            menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(14).setTextE("" + ideologiesMgr.getIdeologyID(core.getCiv(activeCivInfoId).getIdeology()).getName());
        }
        menus.rebuildCreate_NewGame_Civ_Info_Diplomacy();
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(0).setVisibleE(false);
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(2).setVisibleE(false);
        menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(4).setVisibleE(false);
    }

    public static final int getCivDifficulty(int nCivID) {
        float fOut = 5.0f;
        if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).CAN_BECOME_CIVILIZED > 0) {
            fOut += 10.8f;
        }
        fOut += 65.0f * (float)core.getCiv(nCivID).getRankPos() / (float)core.getCivsSize();
        ArrayList<Integer> tempNeighboors = new ArrayList<Integer>();
        for (int i = 0; i < core.getCiv(nCivID).getNumOfProvs(); ++i) {
            for (int j = 0; j < core.getProv(core.getCiv(nCivID).getProvID(i)).getNeighProvincesSize(); ++j) {
                if (core.getProv(core.getProv(core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j)).getCivId() <= 0) continue;
                boolean wasAdded = false;
                for (int k = 0; k < tempNeighboors.size(); ++k) {
                    if (((Integer)tempNeighboors.get(k)).intValue() != core.getProv(core.getProv(core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j)).getCivId()) continue;
                    wasAdded = true;
                    break;
                }
                if (wasAdded) continue;
                tempNeighboors.add(core.getProv(core.getProv(core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j)).getCivId());
            }
        }
        fOut += (float)tempNeighboors.size();
        for (int k = 0; k < tempNeighboors.size(); ++k) {
            fOut += 2.68f * Math.min((float)core.getCiv((Integer)tempNeighboors.get(k)).getRankScore() / (float)core.getCiv(nCivID).getRankScore(), 1.85f);
        }
        return Math.min((int)fOut, 100);
    }

    public static final void updateActiveCivilizationInfoInGame() {
        menus.getInGame_CivInfo().getMenuElem(1).setTextE("" + core.getCiv(activeCivInfoId).getCivName());
        menus.getInGame_CivInfo().getMenuElem(0).setTextE("" + core.getCiv(activeCivInfoId).getRankPos());
        menus.getInGame_CivInfo().getMenuElem(3).setCurr(activeCivInfoId);
        menus.getInGame_CivInfo().getMenuElem(4).setVisibleE(CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData != null && CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData.getName().length() > 0);
        if (menus.getInGame_CivInfo().getMenuElem(4).getVisibleE()) {
            menus.getInGame_CivInfo().getMenuElem(4).setTextE(CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.leaderData.getName());
        }
        if (menus.getInGame_CivInfo().getMenuElem(4).getVisibleE()) {
            menus.getInGame_CivInfo().getMenuElem(3).setHeightE(PADD * 2 + TEXT_HEIGHT_DEFAULT);
            menus.getInGame_CivInfo().getMenuElem(4).setHeightE(PADD * 2 + TEXT_HEIGHT_DEFAULT);
            int totalH = menus.getInGame_CivInfo().getHeightM();
            int elemH = (int)((float)TEXT_HEIGHT_DEFAULT + (float)TEXT_HEIGHT_DEFAULT * 0.8f * 2.0f + (float)(PADD * 2));
            totalH -= elemH;
            totalH = Math.min(totalH, menus.getInGame_CivInfo().getMenuElem(2).getPosY() * 2);
            int elementH2 = (menus.getInGame_CivInfo().getHeightM() - menus.getInGame_CivInfo().getMenuElem(2).getPosY() * 2 - PADD * 4) / 3;
            menus.getInGame_CivInfo().getMenuElem(1).setPosY(menus.getInGame_CivInfo().getMenuElem(2).getPosY());
            menus.getInGame_CivInfo().getMenuElem(1).setHeightE(elementH2);
            menus.getInGame_CivInfo().getMenuElem(3).setPosY(menus.getInGame_CivInfo().getMenuElem(2).getPosY() + PADD + elementH2);
            menus.getInGame_CivInfo().getMenuElem(3).setHeightE(elementH2);
            menus.getInGame_CivInfo().getMenuElem(4).setPosY(menus.getInGame_CivInfo().getMenuElem(2).getPosY() + PADD * 2 + elementH2 * 2);
            menus.getInGame_CivInfo().getMenuElem(4).setHeightE(elementH2);
        } else {
            menus.getInGame_CivInfo().getMenuElem(3).setHeightE(PADD * 4 + TEXT_HEIGHT_DEFAULT);
            int elementH2 = (menus.getInGame_CivInfo().getHeightM() - menus.getInGame_CivInfo().getMenuElem(2).getPosY() * 2 - PADD * 4) / 3;
            menus.getInGame_CivInfo().getMenuElem(1).setPosY(menus.getInGame_CivInfo().getMenuElem(2).getPosY());
            menus.getInGame_CivInfo().getMenuElem(1).setHeightE(elementH2);
            menus.getInGame_CivInfo().getMenuElem(3).setPosY(menus.getInGame_CivInfo().getMenuElem(2).getPosY() + PADD + elementH2);
            menus.getInGame_CivInfo().getMenuElem(3).setHeightE(elementH2);
        }
        long civPopulation = 0L;
        long civEconomy = 0L;
        try {
            int nLargestCity = 0;
            if (core.getCiv(activeCivInfoId).getNumOfProvs() > 0) {
                nLargestCity = -1;
                civPopulation += (long)core.getProv(core.getCiv(activeCivInfoId).getProvID(0)).getPop().getPops();
                civEconomy += (long)core.getProv(core.getCiv(activeCivInfoId).getProvID(0)).getEco();
                for (int i = 1; i < core.getCiv(activeCivInfoId).getNumOfProvs(); ++i) {
                    civPopulation += (long)core.getProv(core.getCiv(activeCivInfoId).getProvID(i)).getPop().getPops();
                    civEconomy += (long)core.getProv(core.getCiv(activeCivInfoId).getProvID(i)).getEco();
                    if (nLargestCity >= 0 && core.getProv(nLargestCity).getPop().getPops() >= core.getProv(core.getCiv(activeCivInfoId).getProvID(i)).getPop().getPops()) continue;
                    nLargestCity = core.getCiv(activeCivInfoId).getProvID(i);
                }
            }
            if (FOG_OF_WAR == 2) {
                if (core.getPlayer(PLAYER_TURN_ID).getMetProv(nLargestCity)) {
                    menus.getInGameCivStats().getMenuElem(5).setTextE(core.getProv(nLargestCity).getCitSize() > 0 ? core.getProv(nLargestCity).getCit(0).getCityName() : core.getProv(nLargestCity).getName());
                    menus.getInGameCivStats().getMenuElem(5).setCurr(nLargestCity);
                } else {
                    menus.getInGameCivStats().getMenuElem(5).setTextE(lang.get("NoData"));
                    menus.getInGameCivStats().getMenuElem(5).setCurr(-1);
                }
            } else {
                menus.getInGameCivStats().getMenuElem(5).setTextE(core.getProv(nLargestCity).getCitSize() > 0 ? core.getProv(nLargestCity).getCit(0).getCityName() : core.getProv(nLargestCity).getName());
                menus.getInGameCivStats().getMenuElem(5).setCurr(nLargestCity);
            }
        }
        catch (Exception ex) {
            menus.getInGameCivStats().getMenuElem(5).setTextE(lang.get("NoData"));
            menus.getInGameCivStats().getMenuElem(5).setCurr(-1);
        }
        if (civPopulation >= 1000000L) {
            menus.getInGameCivStats().getMenuElem(1).setTextE("" + CFG.getNumber_SHORT(civPopulation));
        } else {
            menus.getInGameCivStats().getMenuElem(1).setTextE("" + CFG.getNumberWthSpaces("" + civPopulation));
        }
        try {
            if (FOG_OF_WAR == 2) {
                if (core.getPlayer(PLAYER_TURN_ID).getMetProv(core.getCiv(activeCivInfoId).getCapitalProvID())) {
                    menus.getInGameCivStats().getMenuElem(3).setTextE("" + (core.getProv(core.getCiv(activeCivInfoId).getCapitalProvID()).getCitSize() > 0 ? core.getProv(core.getCiv(activeCivInfoId).getCapitalProvID()).getCit(0).getCityName() : core.getProv(core.getCiv(activeCivInfoId).getCapitalProvID()).getName()));
                } else {
                    menus.getInGameCivStats().getMenuElem(3).setTextE(lang.get("NoData"));
                    menus.getInGameCivStats().getMenuElem(3).setCurr(-1);
                }
            } else {
                menus.getInGameCivStats().getMenuElem(3).setTextE("" + (core.getProv(core.getCiv(activeCivInfoId).getCapitalProvID()).getCitSize() > 0 ? core.getProv(core.getCiv(activeCivInfoId).getCapitalProvID()).getCit(0).getCityName() : core.getProv(core.getCiv(activeCivInfoId).getCapitalProvID()).getName()));
            }
        }
        catch (Exception ex) {
            menus.getInGameCivStats().getMenuElem(3).setTextE(lang.get("NoData"));
            menus.getInGameCivStats().getMenuElem(3).setCurr(-1);
        }
        if (!GameValues.gvInGame.CIV_INFO_POP_GRAPH) {
            menus.getInGameCivStats().getMenuElem(6).setVisibleE(false);
        } else {
            ArrayList<Integer> nCivs = new ArrayList<Integer>();
            ArrayList<Long> nData = new ArrayList<Long>();
            boolean addNewData = true;
            for (int i = 0; i < core.getCiv(activeCivInfoId).getNumOfProvs(); ++i) {
                for (int j = 0; j < core.getProv(core.getCiv(activeCivInfoId).getProvID(i)).getPop().getNatsSize(); ++j) {
                    addNewData = true;
                    for (int k = 0; k < nCivs.size(); ++k) {
                        if (((Integer)nCivs.get(k)).intValue() != core.getProv(core.getCiv(activeCivInfoId).getProvID(i)).getPop().getCivID(j)) continue;
                        addNewData = false;
                        nData.set(k, nData.get(k) + core.getProv(core.getCiv(activeCivInfoId).getProvID(i)).getPop().getPopulationID(j));
                        break;
                    }
                    if (!addNewData) continue;
                    nCivs.add(core.getProv(core.getCiv(activeCivInfoId).getProvID(i)).getPop().getCivID(j));
                    nData.add(core.getProv(core.getCiv(activeCivInfoId).getProvID(i)).getPop().getPopulationID(j));
                }
            }
            if (nCivs.isEmpty()) {
                nCivs.add(activeCivInfoId);
                nData.add(1L);
            }
            addNewData = menus.getInGameCivStats().getMenuElem(6).getIsInView();
            menus.getInGameCivStats().setMenuElem(6, new Graph_Circle(menus.getInGameCivStats().getMenuElem(6).getPosXE(), menus.getInGameCivStats().getMenuElem(6).getPosY(), nData, nCivs, null){

                @Override
                public void buildElemHover() {
                    this.menuElemHover = core.getHover_PopulationOfCiv(CFG.getActiveCivInfoId());
                }
            });
            menus.getInGameCivStats().getMenuElem(6).setIsInView(addNewData);
        }
        menus.getInGameCivStats().getMenuElem(7).setTextE("" + CFG.getPrecision2((float)gameAction.getCivMovementPoints(activeCivInfoId) / 10.0f, 10));
        menus.getInGameCivStats().getMenuElem(8).setTextE("" + (float)((int)(core.getCiv(activeCivInfoId).getTechLevel() * 100.0f)) / 100.0f);
        menus.getInGameCivStats().getMenuElem(10).setTextE("" + CFG.getNumber_SHORT(civEconomy));
        menus.getInGameCivStats().getMenuElem(11).setCurr(core.getCiv(activeCivInfoId).getHappiness());
        menus.getInGameCivStats().getMenuElem(15).setCurr(CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.iNukes);
        menus.getInGameCivStats().getMenuElem(15).setPosX(menus.getInGameCivStats().getMenuElem(11).getPosXE() - PADD);
        menus.getInGameCivStats().getMenuElem(15).setVisibleE(CFG.core.getCiv((int)CFG.activeCivInfoId).civGD.iNukes > 0);
        menus.getInGameCivStats().getMenuElem(13).setCurr((int)(core.getCiv(activeCivInfoId).getStabilityCiv() * 100.0f));
        if (core.getCiv(activeCivInfoId).getIsPartOfHolyRomanEmpire()) {
            if (hreMgr.getHRE().getIsEmperor(activeCivInfoId)) {
                menus.getInGameCivStats().getMenuElem(12).setCurr(-1);
                menus.getInGameCivStats().getMenuElem(12).setTextE(lang.get("Emperor"));
            } else if (hreMgr.getHRE().getIsElector(activeCivInfoId)) {
                menus.getInGameCivStats().getMenuElem(12).setCurr(core.getCiv(activeCivInfoId).getIdeology());
                menus.getInGameCivStats().getMenuElem(12).setTextE(lang.get("Elector"));
            } else {
                menus.getInGameCivStats().getMenuElem(12).setCurr(core.getCiv(activeCivInfoId).getIdeology());
                menus.getInGameCivStats().getMenuElem(12).setTextE(lang.get("Prince"));
            }
        } else {
            menus.getInGameCivStats().getMenuElem(12).setCurr(core.getCiv(activeCivInfoId).getIdeology());
            menus.getInGameCivStats().getMenuElem(12).setTextE("" + ideologiesMgr.getIdeologyID(core.getCiv(activeCivInfoId).getIdeology()).getName());
        }
        menus.getInGameCivStats().getMenuElem(14).setCurr(core.getCiv(activeCivInfoId).getReligionID());
        menus.getInGameCivStats().getMenuElem(14).setTextE("" + religionManager.getReligion(core.getCiv(activeCivInfoId).getReligionID()).getName());
        menus.rebuildInGame_Civ_Info_Diplomacy();
        menus.setVisible_InGame_Civ_Decisions(core.getPlayer(PLAYER_TURN_ID).getCivId() == activeCivInfoId);
        if (menus.getVisible_InGame_Civ_Opinions()) {
            menus.rebuildInGame_Civ_Opinions();
        }
        menus.getInGameCivStats().getMenuElem(0).setVisibleE(false);
        menus.getInGameCivStats().getMenuElem(2).setVisibleE(false);
        menus.getInGameCivStats().getMenuElem(4).setVisibleE(false);
    }

    public static final void updateCreateAVassalCivInfo() {
        if (CFG.createVassalData.sCivTag != null) {
            menus.getCreateAVassal_Info().getMenuElem(0).setTextE(lang.getCiv(CFG.createVassalData.sCivTag));
        }
        menus.getCreateAVassal_Info().getMenuElem(2).setCurr(core.getProvSelected().getProvSize());
        long tempPopulation = 0L;
        for (int i = 0; i < core.getProvSelected().getProvSize(); ++i) {
            tempPopulation += core.getProv(core.getProvSelected().getProv(i)).getPop().getPops();
        }
        menus.getCreateAVassal_Stats().getMenuElem(1).setTextE("" + CFG.getNumberWthSpaces("" + tempPopulation));
        if (CFG.createVassalData.iCapitalProvinceID >= 0) {
            menus.getCreateAVassal_Stats().getMenuElem(3).setTextE("" + (core.getProv(CFG.createVassalData.iCapitalProvinceID).getCitSize() > 0 ? core.getProv(CFG.createVassalData.iCapitalProvinceID).getCit(0).getCityName() : core.getProv(CFG.createVassalData.iCapitalProvinceID).getName()));
        } else {
            menus.getCreateAVassal_Stats().getMenuElem(3).setTextE("-");
        }
        int nLargestCity = -1;
        if (core.getProvSelected().getProvSize() > 0) {
            nLargestCity = 0;
            for (int i = 1; i < core.getProvSelected().getProvSize(); ++i) {
                if (core.getProv(core.getProvSelected().getProv(nLargestCity)).getPop().getPops() >= core.getProv(core.getProvSelected().getProv(i)).getPop().getPops()) continue;
                nLargestCity = i;
            }
        }
        if (nLargestCity >= 0) {
            menus.getCreateAVassal_Stats().getMenuElem(5).setTextE(core.getProv(core.getProvSelected().getProv(nLargestCity)).getCitSize() > 0 ? core.getProv(core.getProvSelected().getProv(nLargestCity)).getCit(0).getCityName() : core.getProv(core.getProvSelected().getProv(nLargestCity)).getName());
            menus.getCreateAVassal_Stats().getMenuElem(5).setCurr(core.getProvSelected().getProv(nLargestCity));
        } else {
            menus.getCreateAVassal_Stats().getMenuElem(5).setTextE("-");
            menus.getCreateAVassal_Stats().getMenuElem(5).setCurr(-1);
        }
        ArrayList<Integer> nCivs = new ArrayList<Integer>();
        ArrayList<Long> nData = new ArrayList<Long>();
        boolean addNewData = true;
        if (core.getProvSelected().getProvSize() > 0) {
            for (int i = 0; i < core.getProvSelected().getProvSize(); ++i) {
                for (int j = 0; j < core.getProv(core.getProvSelected().getProv(i)).getPop().getNatsSize(); ++j) {
                    addNewData = true;
                    for (int k = 0; k < nCivs.size(); ++k) {
                        if (((Integer)nCivs.get(k)).intValue() != core.getProv(core.getProvSelected().getProv(i)).getPop().getCivID(j)) continue;
                        addNewData = false;
                        nData.set(k, nData.get(k) + core.getProv(core.getProvSelected().getProv(i)).getPop().getPopulationID(j));
                        break;
                    }
                    if (!addNewData) continue;
                    nCivs.add(core.getProv(core.getProvSelected().getProv(i)).getPop().getCivID(j));
                    nData.add(core.getProv(core.getProvSelected().getProv(i)).getPop().getPopulationID(j));
                }
            }
        } else {
            nCivs.add(core.getPlayer(PLAYER_TURN_ID).getCivId());
            nData.add(1L);
        }
        addNewData = menus.getCreateAVassal_Stats().getMenuElem(6).getIsInView();
        menus.getCreateAVassal_Stats().setMenuElem(6, new Graph_Circle(menus.getCreateAVassal_Stats().getMenuElem(6).getPosXE(), menus.getCreateAVassal_Stats().getMenuElem(6).getPosY(), nData, nCivs, null){

            @Override
            public void buildElemHover() {
                this.menuElemHover = core.getHover_PopulationOfCiv_CreateAVassal();
            }
        });
        menus.getCreateAVassal_Stats().getMenuElem(6).setIsInView(addNewData);
        menus.getCreateAVassal_Stats().getMenuElem(8).setTextE("" + (float)((int)(core.getCiv(core.getPlayer(PLAYER_TURN_ID).getCivId()).getTechLevel() * GameValues.gvVassal.RELEASE_VASSAL_PERC_OF_TECH_BASE * 100.0f)) / 100.0f);
        int tempEconomy = 0;
        for (int i = 0; i < core.getProvSelected().getProvSize(); ++i) {
            tempEconomy += core.getProv(core.getProvSelected().getProv(i)).getEco();
        }
        menus.getCreateAVassal_Stats().getMenuElem(10).setTextE("" + CFG.getNumberWthSpaces("" + tempEconomy));
        if (core.getProvSelected().getProvSize() > 0) {
            float tHappiness = 0.0f;
            for (int i = 0; i < core.getProvSelected().getProvSize(); ++i) {
                tHappiness += core.getProv(core.getProvSelected().getProvSize()).getHappi() * 100.0f;
            }
            menus.getCreateAVassal_Stats().getMenuElem(11).setCurr((int)(tHappiness / (float)core.getProvSelected().getProvSize()));
        } else {
            menus.getCreateAVassal_Stats().getMenuElem(11).setCurr(0);
        }
        if (CFG.createVassalData.sCivTag != null) {
            menus.getCreateAVassal_Stats().getMenuElem(12).setCurr(ideologiesMgr.getIdeologyID(CFG.createVassalData.sCivTag));
            menus.getCreateAVassal_Stats().getMenuElem(12).setTextE(ideologiesMgr.getIdeologyID(ideologiesMgr.getIdeologyID(CFG.createVassalData.sCivTag)).getName());
        } else {
            menus.getCreateAVassal_Stats().getMenuElem(12).setCurr(core.getCiv(core.getPlayer(PLAYER_TURN_ID).getCivId()).getIdeology());
            menus.getCreateAVassal_Stats().getMenuElem(12).setTextE(ideologiesMgr.getIdeologyID(core.getCiv(core.getPlayer(PLAYER_TURN_ID).getCivId()).getIdeology()).getName());
        }
    }

    public static final void disposeActiveCivLeader() {
        try {
            loadedLeader = "";
            leaderFrameID = 0;
            leaderFrameSize = 0;
            leaderTime = currentTimeMillis;
            for (int i = 0; i < activeCivLeader.size(); ++i) {
                activeCivLeader.get(i).getTexture().dispose();
            }
            activeCivLeader.clear();
        }
        catch (RuntimeException ex) {
            CFG.exceptionStack(ex);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void disposeActiveCivFlagD() {
        try {
            if (activeCivFlag != null) {
                activeCivFlag.getTexture().dispose();
                activeCivFlag = null;
                activeCivInfoId = 0;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final Image getActiveCivFlag() {
        return activeCivFlag == null ? core.getCiv(activeCivInfoId).getFlagC() : activeCivFlag;
    }

    public static final String getPercentageOld(long nA, long nB, int nPrecision) {
        float nOut = (float)nA / (float)nB * 100.0f;
        if ((double)nOut - Math.floor(nOut) == 0.0) {
            return "" + (int)nOut;
        }
        return ("" + nOut).substring(0, Math.min(nPrecision, ("" + nOut).length()));
    }

    public static final String getPercentage2Old(int nA, int nB, int nPrecision) {
        return CFG.getPercentage2Old((long)nA, (long)nB, nPrecision);
    }

    public static final String getPercentage2Old(long nA, long nB, int nPrecision) {
        String sOut = "" + (float)((int)((float)nA / (float)nB * 100.0f * (float)nPrecision)) / (float)nPrecision;
        try {
            while (sOut.length() > 1 && sOut.indexOf(46) >= 0 && sOut.charAt(sOut.length() - 1) == '0') {
                sOut = sOut.substring(0, sOut.length() - 2);
            }
            if (sOut.indexOf(46) == sOut.length() - 1) {
                return sOut.substring(0, sOut.length() - 2);
            }
        }
        catch (Exception exception) {
            
        }
        return sOut;
    }

    public static final String getPercentage2Old(float nA, float nB, int nPrecision) {
        String sOut = "" + (float)((int)(nA / nB * 100.0f * (float)nPrecision)) / (float)nPrecision;
        try {
            while (sOut.length() > 1 && sOut.indexOf(46) >= 0 && sOut.charAt(sOut.length() - 1) == '0') {
                sOut = sOut.substring(0, sOut.length() - 2);
            }
            if (sOut.indexOf(46) == sOut.length() - 1) {
                return sOut.substring(0, sOut.length() - 2);
            }
        }
        catch (Exception exception) {
            
        }
        return sOut;
    }

    public static final String getPercentage_Max100(int nA, int nB, int nPrecision) {
        float nOut = (float)nA / (float)nB * 100.0f;
        if (nOut > 100.0f) {
            nOut = 100.0f;
        }
        if ((double)nOut - Math.floor(nOut) == 0.0) {
            return "" + (int)nOut;
        }
        return ("" + nOut).substring(0, Math.min(nPrecision, ("" + nOut).length()));
    }

    public static final String getPercentageOld(float nA, float nB, int nPrecision) {
        float nOut = nA / nB * 100.0f;
        if (nOut > 100.0f) {
            nOut = 100.0f;
        }
        return ("" + nOut).substring(0, Math.min(nPrecision, ("" + nOut).length()));
    }

    public static final String getPrecision2(float nPercentage, int nPrecision) {
        String sOut = "" + (float)((int)(nPercentage * (float)nPrecision)) / (float)nPrecision;
        try {
            while (sOut.length() > 1 && sOut.indexOf(46) >= 0 && sOut.charAt(sOut.length() - 1) == '0') {
                sOut = sOut.substring(0, sOut.length() - 2);
            }
            if (sOut.indexOf(46) == sOut.length() - 1) {
                return sOut.substring(0, sOut.length() - 2);
            }
        }
        catch (Exception exception) {
            
        }
        return sOut;
    }

    public static final String getPrecision2(double nPercentage, int nPrecision) {
        String sOut = "" + (float)((int)(nPercentage * (double)nPrecision)) / (float)nPrecision;
        try {
            while (sOut.length() > 1 && sOut.indexOf(46) >= 0 && sOut.charAt(sOut.length() - 1) == '0') {
                sOut = sOut.substring(0, sOut.length() - 2);
            }
            if (sOut.indexOf(46) == sOut.length() - 1) {
                return sOut.substring(0, sOut.length() - 2);
            }
        }
        catch (Exception exception) {
            
        }
        return sOut;
    }

    public static final String getPercentage_Max100(float nA, float nB, int nPrecision) {
        float nOut = nA / nB;
        return ("" + nOut).substring(0, Math.min(nPrecision, ("" + nOut).length()));
    }

    public static final String getPercentage_Max100_X100(float nA, float nB, int nPrecision) {
        float nOut = nA / nB * 100.0f;
        return ("" + nOut).substring(0, Math.min(nPrecision, ("" + nOut).length()));
    }

    public static final int getMetersToFeet(int nValue) {
        return (int)((float)nValue * 3.2808f);
    }

    public static final String getNumberWthSpaces(String nValue) {
        try {
            float val = Float.parseFloat(nValue.replace(" ", ""));
            return getNumber_SHORT_FLOAT(val);
        } catch (Exception e) {
            String nOut = "";
            for (int i = nValue.length(); i > 0; i -= 3) {
                nOut = " " + nValue.substring(i - 3 > 0 ? i - 3 : 0, i) + nOut;
            }
            return nOut.charAt(0) == ' ' ? nOut.substring(1, nOut.length()) : nOut;
        }
    }

    public static final String getNumber_SHORT_FLOAT(float nValue) {
        if (nValue < 1000.0f) {
            return "" + (int)nValue;
        }
        if (nValue < 1000000.0f) {
            float thousands = nValue / 1000.0f;
            String outValue = String.format("%.1f", Float.valueOf(thousands));
            if (outValue.endsWith(".0")) {
                outValue = outValue.substring(0, outValue.length() - 2);
            }
            return outValue.replace(',', '.') + "K";
        }
        if (nValue < 1.0E9f) {
            float millions = nValue / 1000000.0f;
            String outValue = String.format("%.1f", Float.valueOf(millions));
            if (outValue.endsWith(".0")) {
                outValue = outValue.substring(0, outValue.length() - 2);
            }
            return outValue.replace(',', '.') + "M";
        }
        float billions = nValue / 1.0E9f;
        String outValue = String.format("%.1f", Float.valueOf(billions));
        if (outValue.endsWith(".0")) {
            outValue = outValue.substring(0, outValue.length() - 2);
        }
        return outValue.replace(',', '.') + "B";
    }

    public static final String getNumber_SHORT(int nValue) {
        return getNumber_SHORT((long)nValue);
    }

    public static String getNumber_SHORT_ARMY(long nValue) {
        if (nValue < (long)CFG.settingsGD.SHORTEN_ARMY_OVER) {
            return "" + nValue;
        }
        return getNumber_SHORT(nValue);
    }

    public static String getNumber_SHORT_ARMY(int nValue) {
        return getNumber_SHORT_ARMY((long)nValue);
    }

    public static String getNumber_SHORT_ARMY(float f) {
        return getNumber_SHORT_ARMY((long)f);
    }

    public static String getNumber_SHORT(long nValue) {
        if (nValue < 1000L) {
            return "" + nValue;
        }
        if (nValue < 1000000L) {
            float thousands = (float)nValue / 1000.0f;
            String outValue = String.format("%.1f", Float.valueOf(thousands));
            if (outValue.endsWith(".0")) {
                outValue = outValue.substring(0, outValue.length() - 2);
            }
            return outValue.replace(',', '.') + "K";
        }
        if (nValue < 1000000000L) {
            float millions = (float)nValue / 1000000.0f;
            String outValue = String.format("%.1f", Float.valueOf(millions));
            if (outValue.endsWith(".0")) {
                outValue = outValue.substring(0, outValue.length() - 2);
            }
            return outValue.replace(',', '.') + "M";
        }
        float billions = (float)nValue / 1000000000.0f;
        String outValue = String.format("%.1f", Float.valueOf(billions));
        if (outValue.endsWith(".0")) {
            outValue = outValue.substring(0, outValue.length() - 2);
        }
        return outValue.replace(',', '.') + "B";
    }

    public static final int getHappinessImage(int nHappinesss) {
        return nHappinesss > 60 ? Images.happiness : (nHappinesss > 35 ? Images.happiness1 : Images.happiness2);
    }

    public static void drLOA(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float nProgress, String extraText) {
        if (settingsGD != null && settingsGD.BETTER_UI) {
            Color primary = BetterUI_Manager.getPrimaryColor();
            
            
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.8f);
            Images.pix.draw(oSB, nPosX, nPosY, nWidth, nHeight);
            
            
            oSB.setColor(primary.r, primary.g, primary.b, 1.0f);
            Images.pix.draw(oSB, nPosX, nPosY, nWidth, 2); 
            Images.pix.draw(oSB, nPosX, nPosY + nHeight - 2, nWidth, 2); 
            Images.pix.draw(oSB, nPosX, nPosY, 2, nHeight); 
            Images.pix.draw(oSB, nPosX + nWidth - 2, nPosY, 2, nHeight); 
            
            
            oSB.setColor(primary.r, primary.g, primary.b, 0.7f);
            Images.pix.draw(oSB, nPosX + 4, nPosY + 4, (int)((nWidth - 8) * nProgress), nHeight - 8);

            oSB.setColor(Color.WHITE);
            drawTextDefault(oSB, sLOATXT, nPosX + nWidth / 2 - iLOADW / 2, nPosY + (nHeight - iLOAH) / 2, Color.WHITE);
            drawTextDefault(oSB, sLoading + " " + (int)(nProgress * 100.0f) + "%" + extraText, nPosX, nPosY - PADD - TEXT_HEIGHT_DEFAULT_SMALL, primary);
            
            CFG.setRenderO(true);
            return;
        }
        if (nProgress > 1.0f) {
            nProgress = 1.0f;
        } else if (nProgress < 0.0f) {
            nProgress = 0.0f;
        }
        if (System.currentTimeMillis() - 2500L > loaTM) {
            try {
                sLOATXT = lang.getLOA("L" + oR.nextInt(CFG.lang.iLNOT)) + "..";
                loaTM = System.currentTimeMillis();
                glyphLay.setText(fontMain.get(FONT_BOLD), sLOATXT);
                iLOADW = (int)CFG.glyphLay.width;
                iLOAH = (int)CFG.glyphLay.height;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        if (PRT == 0L) {
            PRT = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() < PRT + 6500L) {
            int tH = TEXT_HEIGHT_DEFAULT * 3 + PADD * 8;
            int tY = GAMEHEIGHT / 2 - tH / 2;
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
            IMGManager.getIMG(Images.pix255).draw(oSB, 0, tY, GAMEWIDTH, tH);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
            IMGManager.getIMG(Images.line32Off1).draw(oSB, 0, tY, GAMEWIDTH, tH);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
            IMGManager.getIMG(Images.gradient).draw(oSB, 0, tY, GAMEWIDTH, PADD);
            IMGManager.getIMG(Images.gradient).draw(oSB, 0, tY + tH - PADD, GAMEWIDTH, PADD, false, true);
            oSB.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.85f));
            IMGManager.getIMG(Images.pix255).draw(oSB, 0, tY + 1, GAMEWIDTH, 1);
            IMGManager.getIMG(Images.pix255).draw(oSB, 0, tY + tH - 2, GAMEWIDTH, 1);
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.325f);
            IMGManager.getIMG(Images.pix255).draw(oSB, 0, tY, GAMEWIDTH, 1);
            IMGManager.getIMG(Images.pix255).draw(oSB, 0, tY + tH - 1, GAMEWIDTH, 1);
            oSB.setColor(Color.WHITE);
            CFG.drawTextDefault(oSB, CFG.gLG(), GAMEWIDTH / 2 - iJGW / 2, tY + PADD * 2 + PADD / 2, COLOR_HOVER_TITLE);
            CFG.drawTextDefault(oSB, "presents", GAMEWIDTH / 2 - iJGPW / 2, tY + TEXT_HEIGHT_DEFAULT + PADD * 3 + PADD / 2, COLOR_HOVER_TITLE);
            CFG.drawTextDefault(oSB, BU, GAMEWIDTH / 2 - iDXW / 2, tY + TEXT_HEIGHT_DEFAULT * 2 + PADD * 5 + PADD / 2, COLOR_TEXT_NUM_OF_PROVINCES);
            oSB.setColor(Color.WHITE);
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
        IMGManager.getIMG(Images.gradientXY).draw(oSB, nPosX, nPosY - PADD, nWidth, PADD);
        IMGManager.getIMG(Images.gradientXY).draw(oSB, nPosX, nPosY + nHeight, nWidth, PADD, false, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
        Renderer.drawBox2(oSB, Images.statsRectBG, nPosX, nPosY, nWidth, nHeight, 1.0f);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
        Renderer.drawBox2(oSB, Images.statsRectBG, nPosX + 3, nPosY + 3, (int)((float)(nWidth - 6) * nProgress), nHeight - 6, 1.0f);
        oSB.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.85f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, nPosX + 1, nPosY + 1, nWidth - 2, nHeight - 2, 1.0f);
        oSB.setColor(Color.WHITE);
        Renderer.drawTextWithShadow(oSB, FONT_BOLD, sLOATXT, nPosX + nWidth / 2 - iLOADW / 2, nPosY + (nHeight - iLOAH) / 2, new Color(CFG.COLOR_HOVER_TITLE.r, CFG.COLOR_HOVER_TITLE.g, CFG.COLOR_HOVER_TITLE.b, 1.0f));
        Renderer.drawTextWithShadow(oSB, FONT_REGULAR_SMALL, sLoading + " " + (int)(nProgress * 100.0f) + "%" + extraText, nPosX + PADD * 2, nPosY - PADD - TEXT_HEIGHT_DEFAULT_SMALL, new Color(CFG.COLOR_HOVER_TITLE.r, CFG.COLOR_HOVER_TITLE.g, CFG.COLOR_HOVER_TITLE.b, 1.0f));
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.35f));
        IMGManager.getIMG(Images.gameLogo).draw2O(oSB, nPosX + nWidth - PADD * 2 - IMGManager.getIMG(Images.gameLogo).getWidth(), nPosY - PADD * 2 - IMGManager.getIMG(Images.gameLogo).getHeight() * 2, IMGManager.getIMG(Images.gameLogo).getWidth(), IMGManager.getIMG(Images.gameLogo).getHeight());
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameLogo).draw2O(oSB, nPosX + nWidth - PADD * 2 - IMGManager.getIMG(Images.gameLogo).getWidth(), nPosY - PADD * 2 - IMGManager.getIMG(Images.gameLogo).getHeight() * 2, (int)((float)IMGManager.getIMG(Images.gameLogo).getWidth() * nProgress), IMGManager.getIMG(Images.gameLogo).getHeight());
        oSB.setColor(Color.WHITE);
    }

    public static final boolean compareAlphabetic_TwoString(String a, String b) {
        for (int i = 0; i < a.length() && i < b.length(); ++i) {
            if (a.charAt(i) < b.charAt(i)) {
                return false;
            }
            if (a.charAt(i) == b.charAt(i)) continue;
            return true;
        }
        return false;
    }

    public static void clCPNC() {
        pNCI.clear();
        pNC.clear();
        cNCI.clear();
        cNC.clear();
    }

    public static void aPNC(int id, String name) {
        for (int i = 0; i < pNCI.size(); ++i) {
            if (pNCI.get(i) != id) continue;
            pNC.set(i, name);
            return;
        }
        pNCI.add(id);
        pNC.add(name);
    }

    public static void aCNC(int id, String name) {
        for (int i = 0; i < cNCI.size(); ++i) {
            if (cNCI.get(i) != id) continue;
            cNC.set(i, name);
            return;
        }
        cNCI.add(id);
        cNC.add(name);
    }

    public static boolean getIsInFormableCiv(int nProvinceID) {
        block3: {
            try {
                for (int i = 0; i < formableCivs_GameData.getProvincesSize(); ++i) {
                    if (formableCivs_GameData.getProvinceID(i) != nProvinceID) continue;
                    return true;
                }
            }
            catch (Exception ex) {
                if (!LOGs) break block3;
                CFG.exceptionStack(ex);
            }
        }
        return false;
    }

    public static final String getContinentDataName(String sTag) {
        try {
            FileHandle file = FileManager.loadFile("map/data/continents/packges_data/" + sTag);
            Continent_GameData tempContinentGameData = (Continent_GameData)CFG.deserialize(file.readBytes());
            return tempContinentGameData.getName();
        }
        catch (Exception exception) {
            return sTag;
        }
    }

    public static final String getRegionDataName(String sTag) {
        try {
            FileHandle file = FileManager.loadFile("map/data/regions/packges_data/" + sTag);
            Region_GameData tempRegionGameData = (Region_GameData)CFG.deserialize(file.readBytes());
            return tempRegionGameData.getName();
        }
        catch (Exception exception) {
            return sTag;
        }
    }

    public static final Color getContinentDataColor(String sTag) {
        try {
            FileHandle file = FileManager.loadFile("map/data/continents/packges_data/" + sTag);
            Continent_GameData tempContinentGameData = (Continent_GameData)CFG.deserialize(file.readBytes());
            return new Color(tempContinentGameData.getR(), tempContinentGameData.getG(), tempContinentGameData.getB(), 0.7f);
        }
        catch (Exception exception) {
            return new Color(1.0f, 1.0f, 1.0f, 0.7f);
        }
    }

    public static final Color getRegionDataColor(String sTag) {
        try {
            FileHandle file = FileManager.loadFile("map/data/regions/packges_data/" + sTag);
            Region_GameData tempRegionGameData = (Region_GameData)CFG.deserialize(file.readBytes());
            return new Color(tempRegionGameData.getR(), tempRegionGameData.getG(), tempRegionGameData.getB(), 0.45f);
        }
        catch (Exception exception) {
            return new Color(1.0f, 1.0f, 1.0f, 0.45f);
        }
    }

    public static final String getPackageContinentDataName(String sTag) {
        try {
            FileHandle file = FileManager.loadFile("map/data/continents/packges/" + sTag);
            Package_ContinentsData tempPackageContinentGameData = (Package_ContinentsData)CFG.deserialize(file.readBytes());
            return tempPackageContinentGameData.getPackageName();
        }
        catch (Exception exception) {
            return sTag;
        }
    }

    public static final String getPackageRegionDataName(String sTag) {
        try {
            FileHandle file = FileManager.loadFile("map/data/regions/packges/" + sTag);
            Package_RegionsData tempPackageRegionsGameData = (Package_RegionsData)CFG.deserialize(file.readBytes());
            return tempPackageRegionsGameData.getPackageName();
        }
        catch (Exception exception) {
            return sTag;
        }
    }

    public static final String getPackageDiplomacyColorsDataName(String sTag) {
        try {
            FileHandle file = FileManager.loadFile("game/diplomacy_colors/packages/" + sTag);
            DiplomacyColors_GameData2 tempPackageGameData = (DiplomacyColors_GameData2)CFG.deserialize(file.readBytes());
            return tempPackageGameData.getName();
        }
        catch (Exception exception) {
            return sTag;
        }
    }

    public static final String getPackageContinentData_AllNames(String sTag) {
        try {
            FileHandle file = FileManager.loadFile("map/data/continents/packges/" + sTag);
            Package_ContinentsData tempPackageContinentGameData = (Package_ContinentsData)CFG.deserialize(file.readBytes());
            String tempOutput = "";
            for (int i = 0; i < tempPackageContinentGameData.getContinentsTagsSize(); ++i) {
                tempOutput = tempOutput + CFG.getContinentDataName(tempPackageContinentGameData.getContinentTag(i)) + (i < tempPackageContinentGameData.getContinentsTagsSize() - 1 ? ", " : "");
            }
            return tempOutput;
        }
        catch (Exception exception) {
            return lang.get("Error");
        }
    }

    public static final void drawVersionLB(SpriteBatch oSB, int iTranslateX) {
        Renderer.drawText(oSB, FONT_REGULAR_SMALL, sVERSION + ": " + VERSION, PADD + iTranslateX, GAMEHEIGHT - PADD - TEXT_HEIGHT_DEFAULT_SMALL, new Color(1.0f, 1.0f, 1.0f, 0.25f));
    }

    public static final String getPackageRegionsData_AllNames(String sTag) {
        try {
            FileHandle file = FileManager.loadFile("map/data/regions/packges/" + sTag);
            Package_RegionsData tempPackageRegionGameData = (Package_RegionsData)CFG.deserialize(file.readBytes());
            String tempOutput = "";
            for (int i = 0; i < tempPackageRegionGameData.getRegionsTagsSize(); ++i) {
                tempOutput = tempOutput + CFG.getRegionDataName(tempPackageRegionGameData.getRegionTag(i)) + (i < tempPackageRegionGameData.getRegionsTagsSize() - 1 ? ", " : "");
            }
            return tempOutput;
        }
        catch (Exception exception) {
            return lang.get("Error");
        }
    }

    public static final void drawJakowskiGamesRIGHT_BOT(SpriteBatch oSB, int iTranslateX, float nPerc) {
        if (settingsGD != null && settingsGD.BETTER_UI) {
            Color primary = BetterUI_Manager.getPrimaryColor();
            Renderer.drawText(oSB, FONT_REGULAR_SMALL, CFG.gLG(), GAMEWIDTH - PADD - iJGW + iTranslateX, GAMEHEIGHT - TEXT_HEIGHT_DEFAULT_SMALL - PADD, new Color(primary.r, primary.g, primary.b, 0.45f));
            return;
        }
        Renderer.drawText(oSB, FONT_REGULAR_SMALL, CFG.gLG(), GAMEWIDTH - PADD - iJGW + iTranslateX, GAMEHEIGHT - TEXT_HEIGHT_DEFAULT_SMALL - PADD, new Color(1.0f, 1.0f, 1.0f, 0.25f));
    }

    public static final Color getGrowthRateColor(int nGrowthRate, float nAlpha) {
        switch (nGrowthRate / 10) {
            case 0: {
                return CFG.getColorStep(COLOR_GROWTH_RATE[0], COLOR_GROWTH_RATE[1], nGrowthRate % 10, 10, nAlpha);
            }
            case 1: {
                return CFG.getColorStep(COLOR_GROWTH_RATE[1], COLOR_GROWTH_RATE[2], nGrowthRate % 10, 10, nAlpha);
            }
            case 2: {
                return CFG.getColorStep(COLOR_GROWTH_RATE[2], COLOR_GROWTH_RATE[3], nGrowthRate % 10, 10, nAlpha);
            }
            case 3: {
                return CFG.getColorStep(COLOR_GROWTH_RATE[3], COLOR_GROWTH_RATE[4], nGrowthRate % 10, 10, nAlpha);
            }
            case 4: {
                return CFG.getColorStep(COLOR_GROWTH_RATE[4], COLOR_GROWTH_RATE[5], nGrowthRate % 10, 10, nAlpha);
            }
            case 5: {
                return CFG.getColorStep(COLOR_GROWTH_RATE[5], COLOR_GROWTH_RATE[6], nGrowthRate % 10, 10, nAlpha);
            }
            case 6: {
                return CFG.getColorStep(COLOR_GROWTH_RATE[6], COLOR_GROWTH_RATE[7], nGrowthRate % 10, 10, nAlpha);
            }
            case 7: {
                return CFG.getColorStep(COLOR_GROWTH_RATE[7], COLOR_GROWTH_RATE[8], nGrowthRate % 10, 10, nAlpha);
            }
            case 8: {
                return CFG.getColorStep(COLOR_GROWTH_RATE[8], COLOR_GROWTH_RATE[9], nGrowthRate % 10, 10, nAlpha);
            }
            case 9: {
                return CFG.getColorStep(COLOR_GROWTH_RATE[9], COLOR_GROWTH_RATE[10], nGrowthRate % 10, 10, nAlpha);
            }
            case 10: {
                return new Color(CFG.COLOR_GROWTH_RATE[CFG.COLOR_GROWTH_RATE.length - 1].r, CFG.COLOR_GROWTH_RATE[CFG.COLOR_GROWTH_RATE.length - 1].g, CFG.COLOR_GROWTH_RATE[CFG.COLOR_GROWTH_RATE.length - 1].b, nAlpha);
            }
        }
        return new Color(CFG.COLOR_GROWTH_RATE[CFG.COLOR_GROWTH_RATE.length - 1].r, CFG.COLOR_GROWTH_RATE[CFG.COLOR_GROWTH_RATE.length - 1].g, CFG.COLOR_GROWTH_RATE[CFG.COLOR_GROWTH_RATE.length - 1].b, nAlpha);
    }

    public static final void updateMAX_Army() {
        MAX_PROVINCE_VALUE = 0;
        if (FOG_OF_WAR == 0) {
            for (int i = 0; i < core.getProvinSize(); ++i) {
                if (core.getProv(i).getWastelandLvl() >= 0 || core.getProvinceArmy(i) <= MAX_PROVINCE_VALUE) continue;
                MAX_PROVINCE_VALUE = core.getProvinceArmy(i);
            }
        } else {
            for (int i = 0; i < core.getProvinSize(); ++i) {
                if (core.getProv(i).getWastelandLvl() >= 0 || !core.getPlayer(PLAYER_TURN_ID).getFog(i) || core.getProvinceArmy(i) <= MAX_PROVINCE_VALUE) continue;
                MAX_PROVINCE_VALUE = core.getProvinceArmy(i);
            }
        }
    }

    public static final Color getProvinceArmyColor_Neutral(int nData) {
        return new Color(CFG.COLOR_PROVINCE_ARMY_MAX.r, CFG.COLOR_PROVINCE_ARMY_MAX.g, CFG.COLOR_PROVINCE_ARMY_MAX.b, 0.2875f + 0.2875f * ((float)nData / (float)MAX_PROVINCE_VALUE));
    }

    public static final Color getProvinceArmyColor_Own(int nData) {
        return new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), 0.2875f + 0.2875f * ((float)nData / (float)MAX_PROVINCE_VALUE));
    }

    public static final Color getProvinceArmyColor_AtWar(int nData) {
        return new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 0.2875f + 0.2875f * ((float)nData / (float)MAX_PROVINCE_VALUE));
    }

    public static final Color getProvinceArmyColor_Alliance(int nData) {
        return new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB(), 0.2875f + 0.2875f * ((float)nData / (float)MAX_PROVINCE_VALUE));
    }

    public static final void updateMAX_PROVINCE_VALUE() {
        MAX_PROVINCE_VALUE = 1;
        for (int i = 0; i < core.getProvinSize(); ++i) {
            if (core.getProv(i).getSeaProv() || core.getProv(i).getWastelandLvl() >= 0 || core.getProvinceValue(i) <= MAX_PROVINCE_VALUE) continue;
            MAX_PROVINCE_VALUE = core.getProvinceValue(i);
        }
    }

    public static final Color getProvinceValueColor(int nData) {
        return CFG.getColorStep(new Color(1.0f, 1.0f, 0.8039216f, 0.75f), new Color(0.9098039f, 0.09411765f, 0.09411765f, 0.75f), nData, MAX_PROVINCE_VALUE, 0.67499995f + 0.075f * ((float)nData / (float)MAX_PROVINCE_VALUE));
    }

    public static void drLOA(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight, float nProgress) {
        CFG.drLOA(oSB, nPosX, nPosY, nWidth, nHeight, nProgress, "");
    }

    public static final Color getEconomyColor(int nData, float nAlpha) {
        switch (nData / 10) {
            case 0: {
                return CFG.getColorStep(COLOR_ECONOMY_GRADIENT[0], COLOR_ECONOMY_GRADIENT[1], nData % 10, 10, nAlpha);
            }
            case 1: {
                return CFG.getColorStep(COLOR_ECONOMY_GRADIENT[1], COLOR_ECONOMY_GRADIENT[2], nData % 10, 10, nAlpha);
            }
            case 2: {
                return CFG.getColorStep(COLOR_ECONOMY_GRADIENT[2], COLOR_ECONOMY_GRADIENT[3], nData % 10, 10, nAlpha);
            }
            case 3: {
                return CFG.getColorStep(COLOR_ECONOMY_GRADIENT[3], COLOR_ECONOMY_GRADIENT[4], nData % 10, 10, nAlpha);
            }
            case 4: {
                return CFG.getColorStep(COLOR_ECONOMY_GRADIENT[4], COLOR_ECONOMY_GRADIENT[5], nData % 10, 10, nAlpha);
            }
            case 5: {
                return CFG.getColorStep(COLOR_ECONOMY_GRADIENT[5], COLOR_ECONOMY_GRADIENT[6], nData % 10, 10, nAlpha);
            }
            case 6: {
                return CFG.getColorStep(COLOR_ECONOMY_GRADIENT[6], COLOR_ECONOMY_GRADIENT[7], nData % 10, 10, nAlpha);
            }
            case 7: {
                return CFG.getColorStep(COLOR_ECONOMY_GRADIENT[7], COLOR_ECONOMY_GRADIENT[8], nData % 10, 10, nAlpha);
            }
            case 8: {
                return CFG.getColorStep(COLOR_ECONOMY_GRADIENT[8], COLOR_ECONOMY_GRADIENT[9], nData % 10, 10, nAlpha);
            }
            case 9: {
                return CFG.getColorStep(COLOR_ECONOMY_GRADIENT[9], COLOR_ECONOMY_GRADIENT[10], nData % 10, 10, nAlpha);
            }
            case 10: {
                return new Color(CFG.COLOR_ECONOMY_GRADIENT[10].r, CFG.COLOR_ECONOMY_GRADIENT[10].g, CFG.COLOR_ECONOMY_GRADIENT[10].b, nAlpha);
            }
        }
        return new Color(CFG.COLOR_ECONOMY_GRADIENT[10].r, CFG.COLOR_ECONOMY_GRADIENT[10].g, CFG.COLOR_ECONOMY_GRADIENT[10].b, nAlpha);
    }

    public static final Color getTechnologyLevelColor(int nData, float nAlpha) {
        switch (nData / 10) {
            case 0: {
                return CFG.getColorStep(COLOR_TECHNOLOGY_LEVEL[0], COLOR_TECHNOLOGY_LEVEL[1], nData % 10, 10, nAlpha);
            }
            case 1: {
                return CFG.getColorStep(COLOR_TECHNOLOGY_LEVEL[1], COLOR_TECHNOLOGY_LEVEL[2], nData % 10, 10, nAlpha);
            }
            case 2: {
                return CFG.getColorStep(COLOR_TECHNOLOGY_LEVEL[2], COLOR_TECHNOLOGY_LEVEL[3], nData % 10, 10, nAlpha);
            }
            case 3: {
                return CFG.getColorStep(COLOR_TECHNOLOGY_LEVEL[3], COLOR_TECHNOLOGY_LEVEL[4], nData % 10, 10, nAlpha);
            }
            case 4: {
                return CFG.getColorStep(COLOR_TECHNOLOGY_LEVEL[4], COLOR_TECHNOLOGY_LEVEL[5], nData % 10, 10, nAlpha);
            }
            case 5: {
                return CFG.getColorStep(COLOR_TECHNOLOGY_LEVEL[5], COLOR_TECHNOLOGY_LEVEL[6], nData % 10, 10, nAlpha);
            }
            case 6: {
                return CFG.getColorStep(COLOR_TECHNOLOGY_LEVEL[6], COLOR_TECHNOLOGY_LEVEL[7], nData % 10, 10, nAlpha);
            }
            case 7: {
                return CFG.getColorStep(COLOR_TECHNOLOGY_LEVEL[7], COLOR_TECHNOLOGY_LEVEL[8], nData % 10, 10, nAlpha);
            }
            case 8: {
                return CFG.getColorStep(COLOR_TECHNOLOGY_LEVEL[8], COLOR_TECHNOLOGY_LEVEL[9], nData % 10, 10, nAlpha);
            }
            case 9: {
                return CFG.getColorStep(COLOR_TECHNOLOGY_LEVEL[9], COLOR_TECHNOLOGY_LEVEL[10], nData % 10, 10, nAlpha);
            }
            case 10: {
                return new Color(CFG.COLOR_TECHNOLOGY_LEVEL[10].r, CFG.COLOR_TECHNOLOGY_LEVEL[10].g, CFG.COLOR_TECHNOLOGY_LEVEL[10].b, nAlpha);
            }
        }
        return new Color(CFG.COLOR_TECHNOLOGY_LEVEL[10].r, CFG.COLOR_TECHNOLOGY_LEVEL[10].g, CFG.COLOR_TECHNOLOGY_LEVEL[10].b, nAlpha);
    }

    public static final void initEditdiplomacyColors_GameData() {
        diplomacyColors_GameData = new DiplomacyColors_GameData2();
        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES = new Color_GameData(0.2f, 0.6f, 1.0f);
        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR = new Color_GameData(0.8f, 0.0f, 0.0f);
        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE = new Color_GameData(0.0f, 0.4f, 1.0f);
        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT = new Color_GameData(1.0f, 1.0f, 0.6f);
        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX = new Color_GameData(0.8f, 0.8f, 0.0f);
        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL = new Color_GameData(0.28235295f, 0.47843137f, 0.8627451f);
        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE = new Color_GameData(0.7254902f, 0.28235295f, 0.8627451f);
        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL = new Color_GameData(0.9411765f, 0.9411765f, 0.9411765f);
        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS = new Color_GameData(0.9411765f, 0.9411765f, 0.9411765f);
        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT = new Color_GameData(0.9411765f, 0.9411765f, 0.9411765f);
        Color_GameData[] tempCOLOR_DIPLOMACY_NEGATIVE = new Color_GameData[]{new Color_GameData(0.92941177f, 0.627451f, 0.5882353f), new Color_GameData(0.89411765f, 0.5568628f, 0.45490196f), new Color_GameData(0.85490197f, 0.48235294f, 0.32156864f), new Color_GameData(0.8039216f, 0.40784314f, 0.20784314f), new Color_GameData(0.77254903f, 0.3647059f, 0.2f), new Color_GameData(0.73333335f, 0.3254902f, 0.2f), new Color_GameData(0.69411767f, 0.28627452f, 0.2f), new Color_GameData(0.654902f, 0.2509804f, 0.2f), new Color_GameData(0.62352943f, 0.22352941f, 0.2f), new Color_GameData(0.6f, 0.2f, 0.2f)};
        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE = tempCOLOR_DIPLOMACY_NEGATIVE;
        Color_GameData[] tempCOLOR_DIPLOMACY_POSITIVE = new Color_GameData[]{new Color_GameData(0.6f, 0.8f, 0.6f), new Color_GameData(0.5176471f, 0.7607843f, 0.43137255f), new Color_GameData(0.40392157f, 0.70980394f, 0.2627451f), new Color_GameData(0.3019608f, 0.654902f, 0.12156863f), new Color_GameData(0.20392157f, 0.5921569f, 0.003921569f), new Color_GameData(0.14901961f, 0.5647059f, 0.0f), new Color_GameData(0.09411765f, 0.5137255f, 0.0f), new Color_GameData(0.05490196f, 0.46666667f, 0.0f), new Color_GameData(0.023529412f, 0.42745098f, 0.0f), new Color_GameData(0.0f, 0.4f, 0.0f)};
        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE = tempCOLOR_DIPLOMACY_POSITIVE;
    }

    public static final void loadDiplomacyColors_GameData(String sTag) {
        try {
            FileHandle file = FileManager.loadFile("game/diplomacy_colors/packages/" + sTag);
            diplomacyColors_GameData = (DiplomacyColors_GameData2)CFG.deserialize(file.readBytes());
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (IOException iOException) {
            
        }
        CFG.initEditdiplomacyColors_GameData();
    }

    public static final float getLOAPAD() {
        return CFG.isAndroid() && !LANDSCAPE ? 0.1f : 0.2f;
    }

    public static final Color getRelationColor(int nRelation, float nAlpha) {
        switch (nRelation / 10) {
            case 0: {
                if (nRelation > 0) {
                    return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getB(), nAlpha), nRelation % 10, 10, nAlpha);
                }
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getB(), nAlpha), -nRelation % 10, 10, nAlpha);
            }
            case 1: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getB(), nAlpha), nRelation % 10, 10, nAlpha);
            }
            case 2: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getB(), nAlpha), nRelation % 10, 10, nAlpha);
            }
            case 3: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getB(), nAlpha), nRelation % 10, 10, nAlpha);
            }
            case 4: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getB(), nAlpha), nRelation % 10, 10, nAlpha);
            }
            case 5: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getB(), nAlpha), nRelation % 10, 10, nAlpha);
            }
            case 6: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getB(), nAlpha), nRelation % 10, 10, nAlpha);
            }
            case 7: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getB(), nAlpha), nRelation % 10, 10, nAlpha);
            }
            case 8: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getB(), nAlpha), nRelation % 10, 10, nAlpha);
            }
            case 9: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[9].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[9].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[9].getB(), nAlpha), nRelation % 10, 10, nAlpha);
            }
            case 10: {
                return new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB(), nAlpha);
            }
            case -1: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getB(), nAlpha), -nRelation % 10, 10, nAlpha);
            }
            case -2: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getB(), nAlpha), -nRelation % 10, 10, nAlpha);
            }
            case -3: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getB(), nAlpha), -nRelation % 10, 10, nAlpha);
            }
            case -4: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getB(), nAlpha), -nRelation % 10, 10, nAlpha);
            }
            case -5: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getB(), nAlpha), -nRelation % 10, 10, nAlpha);
            }
            case -6: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getB(), nAlpha), -nRelation % 10, 10, nAlpha);
            }
            case -7: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getB(), nAlpha), -nRelation % 10, 10, nAlpha);
            }
            case -8: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getB(), nAlpha), -nRelation % 10, 10, nAlpha);
            }
            case -9: {
                return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[9].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[9].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[9].getB(), nAlpha), -nRelation % 10, 10, nAlpha);
            }
            case -10: {
                return new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), nAlpha);
            }
        }
        return new Color(0.0f, 0.0f, 0.0f, ALPHA_DIPLOMACY);
    }

    public static final Color getPactColor(int nNumOfTurns, float nAlpha) {
        return CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.getB(), nAlpha), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.getB(), nAlpha), nNumOfTurns, GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT, nAlpha);
    }

    public static final Color getTruceColor(float nAlpha) {
        return new Color(1.0f, 1.0f, 1.0f, nAlpha);
    }

    public static void updateColorDashed() {
        try {
            COLOR_PROVINCE_DASHED = map.getMpS().getCurrSc() > 1.0f ? (map.getMpS().getCurrSc() < 4.0f ? new Color(CFG.COLOR_PROVINCE_DASHED.r, CFG.COLOR_PROVINCE_DASHED.g, CFG.COLOR_PROVINCE_DASHED.b, 0.65f - 0.1f * (map.getMpS().getCurrSc() / 4.0f)) : new Color(CFG.COLOR_PROVINCE_DASHED.r, CFG.COLOR_PROVINCE_DASHED.g, CFG.COLOR_PROVINCE_DASHED.b, 0.54999995f)) : new Color(CFG.COLOR_PROVINCE_DASHED.r, CFG.COLOR_PROVINCE_DASHED.g, CFG.COLOR_PROVINCE_DASHED.b, 0.65f);
        }
        catch (Exception ex) {
            COLOR_PROVINCE_DASHED = new Color(CFG.COLOR_PROVINCE_DASHED.r, CFG.COLOR_PROVINCE_DASHED.g, CFG.COLOR_PROVINCE_DASHED.b, 0.65f);
        }
    }

    public static final String extraRandomTag() {
        String output = "";
        for (int i = 0; i < 8; ++i) {
            output = output + (char)(97 + oR.nextInt(26));
        }
        return output;
    }

    public static final String extraRandomTagShort() {
        String output = "";
        for (int i = 0; i < 4; ++i) {
            output = output + (char)(97 + oR.nextInt(26));
        }
        return output;
    }

    public static final String extraRandm_UPDATE_KEY() {
        String output = "";
        for (int i = 0; i < 14; ++i) {
            output = output + (char)(97 + oR.nextInt(26));
        }
        return output;
    }

    public static final void buildCreateScenario_TechnologyLevelsByContinents() {
        CFG.initCreateScenario_TechnologyLevelsByContinents_Civ();
        for (int i = 1; i < core.getCivsSize(); ++i) {
            lCreateScenario_TechnologyBContinents.add(new ArrayList());
        }
    }

    public static final void addCreateScenario_TechnologyLevelsByContinents_Civ() {
        lCreateScenario_TechnologyBContinents.add(new ArrayList());
    }

    public static final void initCreateScenario_TechnologyLevelsByContinents_Civ() {
        if (lCreateScenario_TechnologyBContinents != null) {
            lCreateScenario_TechnologyBContinents.clear();
            lCreateScenario_TechnologyBContinents = null;
        }
        lCreateScenario_TechnologyBContinents = new ArrayList<List<Scenario_GameData_Technology>>();
    }

    public static final void addCreateScenario_TechnologyLevelsByContinents_Civ(List<Scenario_GameData_Technology> nData) {
        if (nData == null) {
            lCreateScenario_TechnologyBContinents.add(new ArrayList());
        } else {
            lCreateScenario_TechnologyBContinents.add(nData);
        }
    }

    public static final void setCreateScenario_TechnologyLevelsByContinents_Civ(int i, List<Scenario_GameData_Technology> nData) {
        while (lCreateScenario_TechnologyBContinents.size() <= i) {
            lCreateScenario_TechnologyBContinents.add(new ArrayList());
        }
        lCreateScenario_TechnologyBContinents.set(i, nData);
    }

    public static final List<Scenario_GameData_Technology> getCreateScenario_TechnologyLevelsByContinents_Civ(int i) {
        if (i >= 0 && lCreateScenario_TechnologyBContinents != null && i < lCreateScenario_TechnologyBContinents.size()) {
            return lCreateScenario_TechnologyBContinents.get(i);
        }
        return null;
    }

    public static final void removeCreateScenario_TechnologyLevelsByContinents_Civ(int i) {
        lCreateScenario_TechnologyBContinents.remove(i);
    }

    public static final void setCreateScenario_TechnologyLevelsByContinents_Continent(int nCivID, int nContinentID, int nPercentage) {
        if (lCreateScenario_TechnologyBContinents == null) {
            lCreateScenario_TechnologyBContinents = new ArrayList<List<Scenario_GameData_Technology>>();
        }
        while (lCreateScenario_TechnologyBContinents.size() <= nCivID) {
            lCreateScenario_TechnologyBContinents.add(new ArrayList<Scenario_GameData_Technology>());
        }
        if (lCreateScenario_TechnologyBContinents.get(nCivID) == null) {
            lCreateScenario_TechnologyBContinents.set(nCivID, new ArrayList<Scenario_GameData_Technology>());
        }

        for (int i = 0; i < lCreateScenario_TechnologyBContinents.get(nCivID).size(); ++i) {
            if (nContinentID != lCreateScenario_TechnologyBContinents.get(nCivID).get(i).getContinentID()) continue;
            lCreateScenario_TechnologyBContinents.get(nCivID).get(i).setPercentage(nPercentage);
            return;
        }
        lCreateScenario_TechnologyBContinents.get(nCivID).add(new Scenario_GameData_Technology(nContinentID, nPercentage));
    }

    public static final int getCreateScenario_TechnologyLevelsByContinents_Continent(int nCivID, int nContinentID) {
        try {
            if (lCreateScenario_TechnologyBContinents != null && nCivID < lCreateScenario_TechnologyBContinents.size() && lCreateScenario_TechnologyBContinents.get(nCivID) != null) {
                for (int i = 0; i < lCreateScenario_TechnologyBContinents.get(nCivID).size(); ++i) {
                    if (nContinentID != lCreateScenario_TechnologyBContinents.get(nCivID).get(i).getContinentID()) continue;
                    return lCreateScenario_TechnologyBContinents.get(nCivID).get(i).getPercentage();
                }
            }
            return 100;
        }
        catch (Exception ex) {
            if (lCreateScenario_TechnologyBContinents == null) {
                lCreateScenario_TechnologyBContinents = new ArrayList<List<Scenario_GameData_Technology>>();
            }
            lCreateScenario_TechnologyBContinents.add(new ArrayList());
            CFG.exceptionStack(ex);
            return 100;
        }
    }

    public static final void addUndoAssignProvinces(int iProvinceID, int iCivID) {
        if (lCreateScenario_UndoAssignProvsCivID.size() > 499) {
            lCreateScenario_UndoAssignProvsCivID.remove(0);
        }
        lCreateScenario_UndoAssignProvsCivID.add(new Undo_AssignProvinceCiv(iProvinceID, iCivID));
        menus.setCreate_Scenario_AssignUndoButton(true);
    }

    public static void removeUndoAssignProvinces() {
        if (lCreateScenario_UndoAssignProvsCivID.size() > 0) {
            lCreateScenario_UndoAssignProvsCivID.remove(lCreateScenario_UndoAssignProvsCivID.size() - 1);
        }
        if (lCreateScenario_UndoAssignProvsCivID.size() == 0) {
            menus.setCreate_Scenario_AssignUndoButton(false);
        }
    }

    public static final boolean canFormACiv(int nCivID, String nCivTag, boolean bDisposeData) {
        if (!CFG.doesNotExists_FormableCiv(nCivTag)) {
            return false;
        }
        if (core.getCiv(nCivID).isFormableBlocked(nCivTag)) {
            return false;
        }
        if (!core.isAtPeace(nCivID)) {
            return false;
        }
        if (core.getCiv(nCivID).getGold() < (long)GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_GOLD) {
            return false;
        }
        if (core.getCiv(nCivID).getDiploPoints() < GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_DIPLOMACY_POINTS) {
            return false;
        }
        if (core.getCiv(nCivID).getCivId() != core.getCiv(nCivID).getPuppetOfCiv()) {
            return false;
        }
        if (bDisposeData) {
            CFG.loadFormableCiv_GameData(nCivTag);
        }
        if (!FormableRestrictions.canFormInCurrentYear(nCivTag)) {
            if (bDisposeData) {
                formableCivs_GameData = null;
            }
            return false;
        }
        if (!CFG.ownAllProvinces_FormableCiv(nCivID)) {
            if (bDisposeData) {
                formableCivs_GameData = null;
            }
            return false;
        }
        if (bDisposeData) {
            formableCivs_GameData = null;
        }
        return true;
    }

    public static final boolean formCiv(int nCivID) {
        if (CFG.canFormACiv(nCivID, formableCivs_GameData.getFormableCivTag(), false)) {
            block26: {
                core.getCiv(nCivID).clearTagsCanForm();
                core.getCiv(nCivID).setCivTag(formableCivs_GameData.getFormableCivTag());
                core.getCiv(nCivID).setCivName(lang.getCiv(core.getCiv(nCivID).getCivTag()));
                Core.addSimpleTask(new Core.SimpleTask("formCivLoadFlag" + nCivID, nCivID){

                    @Override
                    public void update() {
                        try {
                            core.getCiv(this.id).loadFlag();
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                    }
                });
                for (int i = 0; i < core.getCiv(nCivID).getCivRegionsSize(); ++i) {
                    core.getCiv(nCivID).getCivRegion(i).buildScaleOfText();
                }
                if (core.getProv(formableCivs_GameData.getCapitalProvinceID()).getWastelandLvl() < 0 && !core.getProv(formableCivs_GameData.getCapitalProvinceID()).getSeaProv() && formableCivs_GameData.getCapitalProvinceID() != core.getCiv(nCivID).getCapitalProvID()) {
                    if (core.getCiv(nCivID).getCapitalProvID() >= 0) {
                        for (int k = 0; k < core.getProv(core.getCiv(nCivID).getCapitalProvID()).getCitSize(); ++k) {
                            if (core.getProv(core.getCiv(nCivID).getCapitalProvID()).getCit(k).getCityLevel() != CFG.getEditorCityLevel(0)) continue;
                            core.getProv(core.getCiv(nCivID).getCapitalProvID()).getCit(k).setCityLevel(CFG.getEditorCityLevel(1));
                        }
                        core.getProv(core.getCiv(nCivID).getCapitalProvID()).setIsCapital(false);
                    }
                    core.getCiv(nCivID).setCapitalProvID(formableCivs_GameData.getCapitalProvinceID());
                    core.getProv(formableCivs_GameData.getCapitalProvinceID()).setIsCapital(true);
                    if (core.getCiv(nCivID).getCapitalProvID() >= 0) {
                        core.getCiv(nCivID).setCoreCapitalProvID(core.getCiv(nCivID).getCapitalProvID());
                        if (core.getProv(core.getCiv(nCivID).getCapitalProvID()).getCitSize() > 0) {
                            core.getProv(core.getCiv(nCivID).getCapitalProvID()).getCit(0).setCityLevel(CFG.getEditorCityLevel(0));
                        }
                    }
                }
                core.getCiv(nCivID).updateCivilizationIdeology();
                core.getCiv(nCivID).setGold(core.getCiv(nCivID).getGold() - (long)GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_GOLD);
                core.getCiv(nCivID).setDiploPoints(core.getCiv(nCivID).getDiploPoints() - GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_DIPLOMACY_POINTS);
                try {
                    Civilization_GameData3 tempCivData;
                    try {
                        FileHandle fileCiv;
                        try {
                            fileCiv = FileManager.loadFile("game/civilizations/" + formableCivs_GameData.getFormableCivTag());
                            tempCivData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                            core.getCiv(nCivID).setR(tempCivData.getR());
                            core.getCiv(nCivID).setG(tempCivData.getG());
                            core.getCiv(nCivID).setB(tempCivData.getB());
                        }
                        catch (GdxRuntimeException e) {
                            fileCiv = FileManager.loadFile("game/civilizations/" + ideologiesMgr.getRealTag(formableCivs_GameData.getFormableCivTag()));
                            tempCivData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                            int tempIdeologyID = ideologiesMgr.getIdeologyID(formableCivs_GameData.getFormableCivTag());
                            Color tempColor = CFG.getColorMixed(new Color((float)tempCivData.getR() / 255.0f, (float)tempCivData.getG() / 255.0f, (float)tempCivData.getB() / 255.0f, 0.775f), new Color(CFG.ideologiesMgr.getIdeologyID((int)tempIdeologyID).getColor().r, CFG.ideologiesMgr.getIdeologyID((int)tempIdeologyID).getColor().g, CFG.ideologiesMgr.getIdeologyID((int)tempIdeologyID).getColor().b, 0.225f));
                            core.getCiv(nCivID).setR((int)(tempColor.r * 255.0f));
                            core.getCiv(nCivID).setG((int)(tempColor.g * 255.0f));
                            core.getCiv(nCivID).setB((int)(tempColor.b * 255.0f));
                        }
                    }
                    catch (GdxRuntimeException ex) {
                        try {
                            FileHandle fileCiv = Gdx.files.local("game/civilizations/" + formableCivs_GameData.getFormableCivTag());
                            tempCivData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                            core.getCiv(nCivID).setR(tempCivData.getR());
                            core.getCiv(nCivID).setG(tempCivData.getG());
                            core.getCiv(nCivID).setB(tempCivData.getB());
                        }
                        catch (GdxRuntimeException e) {
                            try {
                                FileHandle fileCiv = Gdx.files.local("game/civilizations/" + ideologiesMgr.getRealTag(formableCivs_GameData.getFormableCivTag()));
                                tempCivData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                                int tempIdeologyID = ideologiesMgr.getIdeologyID(formableCivs_GameData.getFormableCivTag());
                                Color tempColor = CFG.getColorMixed(new Color((float)tempCivData.getR() / 255.0f, (float)tempCivData.getG() / 255.0f, (float)tempCivData.getB() / 255.0f, 0.775f), new Color(CFG.ideologiesMgr.getIdeologyID((int)tempIdeologyID).getColor().r, CFG.ideologiesMgr.getIdeologyID((int)tempIdeologyID).getColor().g, CFG.ideologiesMgr.getIdeologyID((int)tempIdeologyID).getColor().b, 0.225f));
                                core.getCiv(nCivID).setR((int)(tempColor.r * 255.0f));
                                core.getCiv(nCivID).setG((int)(tempColor.g * 255.0f));
                                core.getCiv(nCivID).setB((int)(tempColor.b * 255.0f));
                            }
                            catch (GdxRuntimeException eee) {
                                try {
                                    FileHandle fileCiv;
                                    if (CFG.isAndroid()) {
                                        try {
                                            fileCiv = Gdx.files.local("game/civilizations_editor/" + ideologiesMgr.getRealTag(formableCivs_GameData.getFormableCivTag()) + "/" + ideologiesMgr.getRealTag(formableCivs_GameData.getFormableCivTag()));
                                            tempCivData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                                            core.getCiv(nCivID).setR(tempCivData.getR());
                                            core.getCiv(nCivID).setG(tempCivData.getG());
                                            core.getCiv(nCivID).setB(tempCivData.getB());
                                        }
                                        catch (GdxRuntimeException erq) {
                                            fileCiv = FileManager.loadFile("game/civilizations_editor/" + ideologiesMgr.getRealTag(formableCivs_GameData.getFormableCivTag()) + "/" + ideologiesMgr.getRealTag(formableCivs_GameData.getFormableCivTag()));
                                            tempCivData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                                            core.getCiv(nCivID).setR(tempCivData.getR());
                                            core.getCiv(nCivID).setG(tempCivData.getG());
                                            core.getCiv(nCivID).setB(tempCivData.getB());
                                        }
                                    } else {
                                        fileCiv = FileManager.loadFile("game/civilizations_editor/" + ideologiesMgr.getRealTag(formableCivs_GameData.getFormableCivTag()) + "/" + ideologiesMgr.getRealTag(formableCivs_GameData.getFormableCivTag()));
                                        tempCivData = (Civilization_GameData3)CFG.deserialize(fileCiv.readBytes());
                                        core.getCiv(nCivID).setR(tempCivData.getR());
                                        core.getCiv(nCivID).setG(tempCivData.getG());
                                        core.getCiv(nCivID).setB(tempCivData.getB());
                                    }
                                }
                                catch (GdxRuntimeException gdxRuntimeException) {}
                            }
                        }
                    }
                }
                catch (ClassNotFoundException e) {
                    if (LOGs) {
                        CFG.exceptionStack(e);
                    }
                }
                catch (IOException e) {
                    if (!LOGs) break block26;
                    CFG.exceptionStack(e);
                }
            }
            gameNewGame.updateFormableCivilizations(nCivID);
            for (int i = 0; i < core.getCiv(nCivID).getNumOfProvs(); ++i) {
                core.getProv(core.getCiv(nCivID).getProvID(i)).setFromCivID(0);
            }
            return true;
        }
        return false;
    }

    public static final void addUndoWastelandProvince(int iProvinceID) {
        if (lCreateScenario_UndoWastelandProvinces.size() > 99) {
            lCreateScenario_UndoWastelandProvinces.remove(0);
        }
        lCreateScenario_UndoWastelandProvinces.add(iProvinceID);
        if (menus.getInCreateScenario_Available_Provinces()) {
            menus.setCreate_Scenario_AvailableProvinces_UndoButton(true);
        } else if (menus.getInMapEditor_WastelandMaps_Edit()) {
            menus.setMapEditor_WastelandMaps_Edit_UndoButton(true);
        }
    }

    public static void removeUndoWastelandProvince() {
        if (lCreateScenario_UndoWastelandProvinces.size() > 0) {
            lCreateScenario_UndoWastelandProvinces.remove(lCreateScenario_UndoWastelandProvinces.size() - 1);
        }
        if (lCreateScenario_UndoWastelandProvinces.size() == 0) {
            if (menus.getInCreateScenario_Available_Provinces()) {
                menus.setCreate_Scenario_AvailableProvinces_UndoButton(false);
            } else if (menus.getInMapEditor_WastelandMaps_Edit()) {
                menus.setMapEditor_WastelandMaps_Edit_UndoButton(false);
            }
        }
    }

    public static void loadFlagsCh() {
        Core.addSimpleTask(new Core.SimpleTask("loadFlagsCh"){

            @Override
            public void update() {
                if (flagOfCivilizationH.isEmpty()) {
                    for (int i = 0; i < ChallengesManager.challengeList.size(); ++i) {
                        try {
                            try {
                                flagOfCivilizationH.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + ChallengesManager.challengeList.get((int)i).FORM_TAG + ".png")), Texture.TextureFilter.Linear));
                            }
                            catch (GdxRuntimeException e) {
                                try {
                                    try {
                                        flagOfCivilizationH.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/" + ideologiesMgr.getRealTag(ChallengesManager.challengeList.get((int)i).FORM_TAG) + ".png")), Texture.TextureFilter.Linear));
                                    }
                                    catch (Exception exr) {
                                        try {
                                            flagOfCivilizationH.add(new Image(new Texture(FileManager.loadFile("game/flagsH/" + ChallengesManager.challengeList.get((int)i).FORM_TAG + ".png")), Texture.TextureFilter.Linear));
                                        }
                                        catch (Exception exrrr) {
                                            flagOfCivilizationH.add(new Image(new Texture(FileManager.loadFile("game/flagsH/" + ideologiesMgr.getRealTag(ChallengesManager.challengeList.get((int)i).FORM_TAG) + ".png")), Texture.TextureFilter.Linear));
                                        }
                                    }
                                }
                                catch (GdxRuntimeException exr) {
                                    if (CFG.isAndroid()) {
                                        try {
                                            flagOfCivilizationH.add(new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + ideologiesMgr.getRealTag(ChallengesManager.challengeList.get((int)i).FORM_TAG) + "/" + ideologiesMgr.getRealTag(ChallengesManager.challengeList.get((int)i).FORM_TAG) + CFG.FILE_GAME_CIVILIZATIONS_FLAG_H_EXTRA_TAG)), Texture.TextureFilter.Linear));
                                        }
                                        catch (GdxRuntimeException eq) {
                                            flagOfCivilizationH.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + ideologiesMgr.getRealTag(ChallengesManager.challengeList.get((int)i).FORM_TAG) + "/" + ideologiesMgr.getRealTag(ChallengesManager.challengeList.get((int)i).FORM_TAG) + CFG.FILE_GAME_CIVILIZATIONS_FLAG_H_EXTRA_TAG)), Texture.TextureFilter.Linear));
                                        }
                                        continue;
                                    }
                                    flagOfCivilizationH.add(new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + ideologiesMgr.getRealTag(ChallengesManager.challengeList.get((int)i).FORM_TAG) + "/" + ideologiesMgr.getRealTag(ChallengesManager.challengeList.get((int)i).FORM_TAG) + CFG.FILE_GAME_CIVILIZATIONS_FLAG_H_EXTRA_TAG)), Texture.TextureFilter.Linear));
                                }
                            }
                            continue;
                        }
                        catch (Exception ex) {
                            flagOfCivilizationH.add(new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png")), Texture.TextureFilter.Linear));
                        }
                    }
                }
            }
        });
    }

    public static final void updateNumOfAvailableProvinces() {
        iNumOfWastelandProvinces = 0;
        iNumOfAvailableProvinces = 0;
        for (int i = 0; i < core.getProvinSize(); ++i) {
            if (core.getProv(i).getSeaProv()) continue;
            if (core.getProv(i).getWastelandLvl() >= 0) {
                ++iNumOfWastelandProvinces;
                continue;
            }
            ++iNumOfAvailableProvinces;
        }
        glyphLay.setText(fontMain.get(0), "" + iNumOfAvailableProvinces);
        iNumOfAvailableProvincesWidth = (int)CFG.glyphLay.width;
        glyphLay.setText(fontMain.get(0), "" + iNumOfWastelandProvinces);
        iNumOfWastelandProvincesWidth = (int)CFG.glyphLay.width;
    }

    public static final void resetManageDiplomacyIDs() {
        MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
        MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
        MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = -1;
        MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = 1;
        MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2 = 0;
    }

    public static final void clearFonts() {
        for (int i = 0; i < fontMain.size(); ++i) {
            fontMain.get(i).dispose();
            fontMain.set(i, null);
        }
        fontMain.clear();
    }

    public static final void loadFontMain() {
        CFG.clearFonts();
        Renderer.charset = lang.get("charset");
        CFG.loadFont(lang.get("font"), lang.get("charset"), CFG.settingsGD.FONT_MAIN_SIZEX);
        FONT_BOLD = fontMain.size() - 1;
        CFG.loadFont(lang.get("font"), lang.get("charset"), (int)Math.floor((float)CFG.settingsGD.FONT_MAIN_SIZEX * 0.9f));
        FONT_BOLD_SMALL = fontMain.size() - 1;
        CFG.loadFont(lang.get("font2"), lang.get("charset"), (int)Math.floor((float)CFG.settingsGD.FONT_MAIN_SIZEX * 0.9f));
        FONT_REGULAR_SMALL = fontMain.size() - 1;
        glyphLay.setText(fontMain.get(FONT_BOLD_SMALL), "Ay\u04cfdZOP38901ERLj");
        TEXT_HEIGHT_DEFAULT_SMALL = (int)CFG.glyphLay.height;
    }

    public static final void loadFont(String sFont, String charset, int fontSize) {
        FreeTypeFontGenerator generator = null;
        if (fontSize < 0) {
            fontSize = (int)((float)GameValues.DEFAULT_FONT_SIZE * GUI_SCALE);
        }
        try {
            generator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/" + sFont));
        }
        catch (Exception ex) {
            generator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/rbold.ttf"));
        }
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params.characters = (charset == null || charset.length() == 0) ? FreeTypeFontGenerator.DEFAULT_CHARS : charset;
        params.size = Math.max(fontSize, 6);
        params.color = Color.WHITE;
        params.minFilter = Texture.TextureFilter.Linear;
        params.magFilter = Texture.TextureFilter.Linear;
        fontMain.add(generator.generateFont(params));
        generator.dispose();
        if (fontMain.size() == 1) {
            glyphLay.setText(fontMain.get(0), "Ay\u04cfdZOP38901ERLj");
            TEXT_HEIGHT_DEFAULT = (int)CFG.glyphLay.height;
        }
        settingsGD.updateCitiesFontScale();
    }

    public static final void loadFontArmy() {
        String sFont;
        if (fontArmy != null) {
            fontArmy.dispose();
            fontArmy = null;
        }
        if ((sFont = lang.get("fontArmy")).equals("fontArmy")) {
            sFont = "rbold.ttf";
        }
        FreeTypeFontGenerator genaratorArmy = null;
        try {
            genaratorArmy = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/" + sFont));
        }
        catch (GdxRuntimeException ex) {
            genaratorArmy = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/rbold.ttf"));
        }
        FreeTypeFontGenerator.FreeTypeFontParameter paramsArmy = new FreeTypeFontGenerator.FreeTypeFontParameter();
        paramsArmy.size = Math.max(CFG.settingsGD.FONT_ARMY_SIZEX, 6);
        paramsArmy.color = Color.WHITE;
        paramsArmy.minFilter = Texture.TextureFilter.Linear;
        paramsArmy.magFilter = Texture.TextureFilter.Linear;
        paramsArmy.characters = "0123456789+-.,%?!ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        fontArmy = genaratorArmy.generateFont(paramsArmy);
        genaratorArmy.dispose();
        glyphLay.setText(fontArmy, "-+1234567890");
        ARMY_HEIGHT = (int)CFG.glyphLay.height;
    }

    public static final void loadFontBorder() {
        String sFont;
        if (fontBorder != null) {
            fontBorder.dispose();
            fontBorder = null;
        }
        if ((sFont = lang.get("fontCivNames")).equals("font2")) {
            sFont = "rbold.ttf";
        }
        FreeTypeFontGenerator genarator = null;
        try {
            genarator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/" + sFont));
        }
        catch (GdxRuntimeException ex) {
            genarator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/rbold.ttf"));
        }
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params.characters = lang.get("charset");
        params.size = CFG.settingsGD.FONT_BORDER_SIZEX;
        params.color = new Color(CFG.settingsGD.civNamesFontColor.getR(), CFG.settingsGD.civNamesFontColor.getG(), CFG.settingsGD.civNamesFontColor.getB(), CFG.settingsGD.civNamesFontColor_ALPHA);
        params.minFilter = Texture.TextureFilter.Linear;
        params.magFilter = Texture.TextureFilter.Linear;
        params.borderColor = new Color(CFG.settingsGD.civNamesFontColorBorder.getR(), CFG.settingsGD.civNamesFontColorBorder.getG(), CFG.settingsGD.civNamesFontColorBorder.getB(), CFG.settingsGD.civNamesFontColorBorder_ALPHA);
        params.borderWidth = CFG.settingsGD.FONT_BORDER_WIDTH;
        fontBorder = genarator.generateFont(params);
        genarator.dispose();
        CFG.loadFontBorder2();
    }

    public static final void loadFontBorder2() {
        String sFont;
        if (fontBorder2 != null) {
            fontBorder2.dispose();
            fontBorder2 = null;
        }
        if ((sFont = lang.get("fontCivNames")).equals("font2")) {
            sFont = "rbold.ttf";
        }
        FreeTypeFontGenerator genarator = null;
        try {
            genarator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/" + sFont));
        }
        catch (GdxRuntimeException ex) {
            genarator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/rbold.ttf"));
        }
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params.characters = lang.get("charset");
        params.size = CFG.settingsGD.FONT_BORDER_SIZEX;
        params.color = new Color(CFG.settingsGD.civNamesFontColor.getR(), CFG.settingsGD.civNamesFontColor.getG(), CFG.settingsGD.civNamesFontColor.getB(), CFG.settingsGD.civNamesFontColor_ALPHA);
        params.minFilter = Texture.TextureFilter.Linear;
        params.magFilter = Texture.TextureFilter.Linear;
        params.borderColor = new Color(CFG.settingsGD.civNamesFontColorBorder.getR(), CFG.settingsGD.civNamesFontColorBorder.getG(), CFG.settingsGD.civNamesFontColorBorder.getB(), CFG.settingsGD.civNamesFontColorBorder_ALPHA);
        params.borderWidth = CFG.settingsGD.FONT_BORDER_WIDTH;
        fontBorder2 = genarator.generateFont(params);
        genarator.dispose();
    }

    public static final void drawTextDefault(SpriteBatch oSB, String sText, int nPosX, int nPosY, Color color) {
        try {
            if (sText != null && fontMain.size() > 0) {
                BitmapFont font = fontMain.get(0);
                synchronized(font) {
                    font.setColor(color);
                    font.draw((Batch)oSB, sText, (float)nPosX, (float)(-nPosY));
                }
            }
        }
        catch (Exception exception) {}
    }

    public static final void drawTextBorder(SpriteBatch oSB, String sText, int nPosX, int nPosY, Color color) {
        block2: {
            try {
                if (sText == null || sText.length() == 0 || fontBorder == null) break block2;
                if (settingsGD != null && settingsGD.BETTER_UI) {
                    if (color.equals(Color.WHITE) || color.r > 0.9f && color.g > 0.9f && color.b > 0.9f) {
                        color = BetterUI_Manager.getTextColor();
                    }
                }
                sText = stripBOM(sText);
                fontBorder.setColor(color);
                fontBorder.draw((Batch)oSB, sText, (float)nPosX, (float)(-nPosY));
            }
            catch (Exception ex) {
                if (!LOGs) break block2;
                CFG.exceptionStack(ex);
            }
        }
    }

    public static final void drawTextDefaultWithShadow(SpriteBatch oSB, String sText, int nPosX, int nPosY, Color color) {
        try {
            if (sText != null && fontMain.size() > 0) {
                BitmapFont font = fontMain.get(0);
                synchronized(font) {
                    font.setColor(0.0f, 0.0f, 0.0f, 0.7f * color.a);
                    font.draw((Batch)oSB, sText, (float)(nPosX - 1), (float)(-nPosY - 1));
                    font.setColor(color);
                    font.draw((Batch)oSB, sText, (float)nPosX, (float)(-nPosY));
                }
            }
        }
        catch (Exception exception) {}
    }

    
    public static final void drawTextWithShadowRotated(SpriteBatch oSB, String sText, int nPosX, int nPosY, Color color, float rotate) {
        Matrix4 oldTransformMatrix = oSB.getTransformMatrix().cpy();
        try {
            Matrix4 mx4Font = new Matrix4();
            mx4Font.rotate(new Vector3(0.0f, 0.0f, 1.0f), rotate);
            mx4Font.trn(nPosX, -nPosY, 0.0f);
            oSB.setTransformMatrix(mx4Font);
            sText = stripBOM(sText);
            fontMain.get(0).setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
            fontMain.get(0).draw((Batch)oSB, sText, -1.0f, -1.0f);
            fontMain.get(0).setColor(color);
            fontMain.get(0).draw((Batch)oSB, sText, 0.0f, 0.0f);
        }
        catch (Exception ex) {
            if (LOGs) {
                CFG.exceptionStack(ex);
            }
        }
        finally {
            oSB.setTransformMatrix(oldTransformMatrix);
        }
    }

    
    public static final void drawTextRotated(SpriteBatch oSB, String sText, int nPosX, int nPosY, Color color, float rotate) {
        Matrix4 oldTransformMatrix = oSB.getTransformMatrix().cpy();
        try {
            Matrix4 mx4Font = new Matrix4();
            mx4Font.rotate(new Vector3(0.0f, 0.0f, 1.0f), rotate);
            mx4Font.trn(nPosX, -nPosY, 0.0f);
            oSB.setTransformMatrix(mx4Font);
            sText = stripBOM(sText);
            fontMain.get(0).setColor(color);
            fontMain.get(0).draw((Batch)oSB, sText, 0.0f, 0.0f);
        }
        catch (Exception ex) {
            if (LOGs) {
                CFG.exceptionStack(ex);
            }
        }
        finally {
            oSB.setTransformMatrix(oldTransformMatrix);
        }
    }

    
    public static final void drawTextRotatedBorder(SpriteBatch oSB, String sText, int nPosX, int nPosY, Color color, float rotate) {
        Matrix4 oldTransformMatrix = oSB.getTransformMatrix().cpy();
        try {
            Matrix4 mx4Font = new Matrix4();
            mx4Font.rotate(new Vector3(0.0f, 0.0f, 1.0f), rotate);
            mx4Font.trn(nPosX, -nPosY, 0.0f);
            oSB.setTransformMatrix(mx4Font);
            sText = stripBOM(sText);
            fontBorder.setColor(color);
            fontBorder.draw((Batch)oSB, sText, 0.0f, 0.0f);
        }
        catch (Exception ex) {
            if (LOGs) {
                CFG.exceptionStack(ex);
            }
        }
        finally {
            oSB.setTransformMatrix(oldTransformMatrix);
        }
    }

    public static final void drawArmyText(SpriteBatch oSB, String sText, int nPosX, int nPosY, Color color) {
        float oldScaleX = fontArmy.getData().scaleX;
        float oldScaleY = fontArmy.getData().scaleY;
        try {
            sText = stripBOM(sText);
            fontArmy.getData().setScale(oldScaleX * armyDrawScale, oldScaleY * armyDrawScale);
            fontArmy.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
            int shadowOffset = Math.max(1, (int)armyDrawScale);
            fontArmy.draw((Batch)oSB, sText, (float)(nPosX - shadowOffset), (float)(-nPosY - shadowOffset));
            fontArmy.setColor(color);
            fontArmy.draw((Batch)oSB, sText, (float)nPosX, (float)(-nPosY));
        }
        catch (Exception exception) {
            
        }
        finally {
            fontArmy.getData().setScale(oldScaleX, oldScaleY);
        }
    }

    public static final void drawArmyText_WithShadow(SpriteBatch oSB, String sText, int nPosX, int nPosY, Color color) {
        block2: {
            float oldScaleX = fontArmy.getData().scaleX;
            float oldScaleY = fontArmy.getData().scaleY;
            try {
                sText = stripBOM(sText);
                fontArmy.getData().setScale(oldScaleX * armyDrawScale, oldScaleY * armyDrawScale);
                fontArmy.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
                int shadowOffset = Math.max(1, (int)armyDrawScale);
                fontArmy.draw((Batch)oSB, sText, (float)(nPosX - shadowOffset), (float)(-nPosY - shadowOffset));
                fontArmy.setColor(color);
                fontArmy.draw((Batch)oSB, sText, (float)nPosX, (float)(-nPosY));
            }
            catch (Exception ex) {
                if (!LOGs) break block2;
                CFG.exceptionStack(ex);
            }
            finally {
                fontArmy.getData().setScale(oldScaleX, oldScaleY);
            }
        }
    }

    public static final int getDarker(int iColor, int iMod) {
        return Math.round(Math.max(0, iColor - iMod));
    }

    public static final Color getDarker(Color nColor, int iMod, float nAlpha) {
        return new Color(Math.round(Math.max(0.0f, nColor.r * 255.0f - (float)iMod) / 255.0f), Math.round(Math.max(0.0f, nColor.g * 255.0f - (float)iMod) / 255.0f), Math.round(Math.max(0.0f, nColor.b * 255.0f - (float)iMod) / 255.0f), nAlpha);
    }

    public static final float getColorStep(int iOld, int iNew, int iColorStepID, int numOfSteps) {
        return ((float)iOld + (float)((iNew - iOld) * iColorStepID) / (float)numOfSteps) / 255.0f;
    }

    public static final Color getColorStep(Color iOld, Color iNew, int iColorStepID, int numOfSteps, float fAlpha) {
        return new Color(iOld.r + (iNew.r - iOld.r) * (float)iColorStepID / (float)numOfSteps, iOld.g + (iNew.g - iOld.g) * (float)iColorStepID / (float)numOfSteps, iOld.b + (iNew.b - iOld.b) * (float)iColorStepID / (float)numOfSteps, fAlpha);
    }

    public static final Color getColorStep(Color iOld, Color iNew, long iColorStepID, long numOfSteps, float fAlpha) {
        return new Color(iOld.r + (iNew.r - iOld.r) * (float)iColorStepID / (float)numOfSteps, iOld.g + (iNew.g - iOld.g) * (float)iColorStepID / (float)numOfSteps, iOld.b + (iNew.b - iOld.b) * (float)iColorStepID / (float)numOfSteps, fAlpha);
    }

    public static final Color getColorStep_WithAlpha(Color iOld, Color iNew, int iColorStepID, int numOfSteps) {
        return new Color(iOld.r + (iNew.r - iOld.r) * (float)iColorStepID / (float)numOfSteps, iOld.g + (iNew.g - iOld.g) * (float)iColorStepID / (float)numOfSteps, iOld.b + (iNew.b - iOld.b) * (float)iColorStepID / (float)numOfSteps, iOld.a + (iNew.a - iOld.a) * (float)iColorStepID / (float)numOfSteps);
    }

    public static final Color getColorStep_WithAlpha(Color iOld, Color iNew, long iColorStepID, long numOfSteps) {
        return new Color(iOld.r + (iNew.r - iOld.r) * (float)iColorStepID / (float)numOfSteps, iOld.g + (iNew.g - iOld.g) * (float)iColorStepID / (float)numOfSteps, iOld.b + (iNew.b - iOld.b) * (float)iColorStepID / (float)numOfSteps, iOld.a + (iNew.a - iOld.a) * (float)iColorStepID / (float)numOfSteps);
    }

    public static final Color getColorMixed(Color iOld, Color iNew) {
        float tA = 1.0f - (1.0f - iOld.a) * (1.0f - iNew.a);
        return new Color(iNew.r * iNew.a / tA + iOld.r * iOld.a * (1.0f - iNew.a) / tA, iNew.g * iNew.a / tA + iOld.g * iOld.a * (1.0f - iNew.a) / tA, iNew.b * iNew.a / tA + iOld.b * iOld.a * (1.0f - iNew.a) / tA, iOld.a);
    }

    public static final float changeAnimationPos(int animationStepID, float animationChangeViewPos, boolean backAnimation, int nWidth) {
        switch (animationStepID) {
            case 0: 
            case 1: 
            case 12: {
                animationChangeViewPos -= (float)nWidth * 2.5f / 100.0f * (float)(backAnimation ? -1 : 1);
                break;
            }
            case 2: 
            case 3: 
            case 10: 
            case 11: {
                animationChangeViewPos -= (float)nWidth * 5.0f / 100.0f * (float)(backAnimation ? -1 : 1);
                break;
            }
            case 4: 
            case 5: 
            case 8: 
            case 9: {
                animationChangeViewPos -= (float)nWidth * 10.0f / 100.0f * (float)(backAnimation ? -1 : 1);
                break;
            }
            case 6: 
            case 7: {
                animationChangeViewPos -= (float)nWidth * 15.0f / 100.0f * (float)(backAnimation ? -1 : 1);
                break;
            }
            case 13: {
                animationChangeViewPos = -nWidth * (backAnimation ? -1 : 1);
            }
        }
        return animationChangeViewPos;
    }

    public int getAppID() {
        sUM.sUI.storeStats();
        return 0;
    }

    public int getSecondsSinceComputerActive() {
        sUM.sUI.getStatI("computer_active", 0);
        return 0;
    }

    public int getServerRealTime() {
        sUM.sUI.requestCurrentStats();
        return (int)(System.currentTimeMillis() / 1000L);
    }

    public boolean isSteamRunning() {
        sUM.sUI.storeStats();
        return true;
    }

    public static final void showKeyboard() {
        CFG.showKeyboard(menus.getActiveMenuElemeID());
    }

    public static final void showKeyboard(int nMenuElemenID) {
        CFG.showKeyboard(menus.getActiveMenuID(), nMenuElemenID);
    }

    public static final void showKeyboard(int nActiveSliderMenuID, int nMenuElemenID) {
        try {
            if (Keyboard.colorPickerMode || Keyboard.commandsMode || Keyboard.mapModeSearch || Keyboard.rankSearch) {
                Keyboard.colorPickerMode = false;
                Keyboard.commandsMode = false;
                Keyboard.mapModeSearch = false;
                Keyboard.rankSearch = false;
            }
            CFG.updateKeyboard_Actions();
            if (Keyboard.numbers) {
                Keyboard.numbers = false;
                menus.getKeyboard().actionCloseMenu();
            }
            menus.setKeyboardActiveSliderMenuID(nActiveSliderMenuID);
            menus.setKeyboardActiveMenuElementID(nMenuElemenID);
            keybMess = menus.getActiveMenu().get(menus.getKeyboardActiveSliderMenuID()).getMenuElem(menus.getKeyboardActiveMenuElementID()).getTextE();
            menus.getKeyboard().setVisibleM(true);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void showKeyboard_Rank() {
        if (!Keyboard.rankSearch) {
            Keyboard.commandsMode = false;
            Keyboard.colorPickerMode = false;
            Keyboard.rankSearch = true;
            Keyboard.mapModeSearch = false;
        }
        CFG.updateKeyboard_Actions();
        menus.setKeyboardActiveMenuElementID(menus.getActiveMenuElemeID());
        keybMess = "";
        menus.getKeyboard().setVisibleM(true);
    }

    public static final void showKeyboard_ColorPickerRGB(String nText) {
        if (!Keyboard.colorPickerMode) {
            Keyboard.colorPickerMode = true;
            Keyboard.commandsMode = false;
            Keyboard.mapModeSearch = false;
            Keyboard.rankSearch = false;
        }
        CFG.updateKeyboard_Actions();
        Keyboard.numbers = true;
        menus.getKeyboard().actionCloseMenu();
        keybMess = nText;
        menus.getKeyboard().setVisibleM(true);
    }

    public static final void showKeyboard_Commands() {
        if (!Keyboard.commandsMode) {
            Keyboard.commandsMode = true;
            Keyboard.colorPickerMode = false;
            Keyboard.mapModeSearch = false;
            Keyboard.rankSearch = false;
        }
        CFG.updateKeyboard_Actions();
        menus.setKeyboardActiveMenuElementID(menus.getActiveMenuElemeID());
        keybMess = "";
        menus.getKeyboard().setVisibleM(true);
    }

    public static final void showKeyboard_MapModes() {
        if (!Keyboard.mapModeSearch) {
            Keyboard.commandsMode = false;
            Keyboard.colorPickerMode = false;
            Keyboard.rankSearch = false;
            Keyboard.mapModeSearch = true;
        }
        CFG.updateKeyboard_Actions();
        menus.setKeyboardActiveMenuElementID(menus.getActiveMenuElemeID());
        keybMess = "";
        menus.getKeyboard().setVisibleM(true);
    }

    public static final void updateKeyboard_Actions() {
        if (Keyboard.colorPickerMode) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    menus.getColorPicker().RGBtoHSV(Keyboard.activeColor_RGB_ID == 0 ? CFG.getKeyboardMessage_RGB() : (int)(CFG.menus.getColorPicker().getActiveColor().r * 255.0f), Keyboard.activeColor_RGB_ID == 1 ? CFG.getKeyboardMessage_RGB() : (int)(CFG.menus.getColorPicker().getActiveColor().g * 255.0f), Keyboard.activeColor_RGB_ID == 2 ? CFG.getKeyboardMessage_RGB() : (int)(CFG.menus.getColorPicker().getActiveColor().b * 255.0f));
                    menus.getColorPicker().getColorPickerAction().update();
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 3 && (keybMess = keybMess.substring(0, keybMess.length() - 1)).length() == 3) {
                        keybMess = keybMess + 0;
                    }
                    keyboardSave.action();
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    block8: {
                        try {
                            if (nChar.charAt(0) < '0' || nChar.charAt(0) > '9') break block8;
                            if (keybMess.length() > 2 && keybMess.charAt(3) == '0') {
                                keybMess = keybMess.substring(0, 3) + nChar;
                            } else {
                                if (CFG.updateKeyboardCheck(nChar)) {
                                    return;
                                }
                                keybMess = keybMess + nChar;
                            }
                            try {
                                if (keybMess.length() > 2 && Integer.parseInt(keybMess.substring(3, keybMess.length())) > 255) {
                                    keybMess = keybMess.substring(0, 3) + "255";
                                }
                            }
                            catch (Exception exception) {
                                
                            }
                            keyboardSave.action();
                        }
                        catch (IndexOutOfBoundsException ex) {
                            keybMess = keybMess + nChar;
                        }
                    }
                }
            };
        } else if (Keyboard.commandsMode) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    Commands.execute(keybMess);
                    keybMess = "";
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "";
                }
            };
            CFG.updateKeyboard_DefaultWrite();
        } else if (Keyboard.changeCivilizationNameMode > 0 && menus.getInGameView()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        core.getCiv(Keyboard.changeCivilizationNameMode).setCivName(keybMess);
                        CFG.aCNC(Keyboard.changeCivilizationNameMode, keybMess);
                        core.setActiveProvID(core.getActiveProvID());
                        for (int i = 0; i < core.getCiv(Keyboard.changeCivilizationNameMode).getCivRegionsSize(); ++i) {
                            core.getCiv(Keyboard.changeCivilizationNameMode).getCivRegion(i).buildScaleOfText();
                        }
                        if (menus.getInGameView()) {
                            CFG.updateActiveCivilizationInfoInGame();
                        } else if (menus.getInCreateNewGame()) {
                            CFG.updateActiveCivInfo_CreateNewGame();
                        }
                        Keyboard.changeCivilizationNameMode = -1;
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "";
                }
            };
            CFG.updateKeyboard_DefaultWrite();
        } else if (Keyboard.forceMigrationSearch && menus.getInGameView()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    Menu_InGame_ForceMigration.searchText = keybMess;
                    Menu_InGame_ForceMigration.rebuildSearchMenu();
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "";
                    Menu_InGame_ForceMigration.searchText = keybMess;
                    Menu_InGame_ForceMigration.rebuildSearchMenu();
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    Menu_InGame_ForceMigration.searchText = keybMess = keybMess + nChar;
                    Menu_InGame_ForceMigration.rebuildSearchMenu();
                }
            };
        } else if (Keyboard.cityEditorSearch && menus.getMenuID() == View.eEDITOR_CITIES) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    Menu_Editor_Cities.searchText = keybMess;
                    menus.setMenuID(View.eEDITOR_CITIES);
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "";
                    Menu_Editor_Cities.searchText = keybMess;
                    menus.setMenuID(View.eEDITOR_CITIES);
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    Menu_Editor_Cities.searchText = keybMess = keybMess + nChar;
                    menus.setMenuID(View.eEDITOR_CITIES);
                }
            };
        } else if (Keyboard.mapModeSearch && menus.getInGameView()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        try {
                            Menu_InGame_MapModes.searchText = keybMess;
                            menus.setVisible_InGame_MapModes_ResetTime(true);
                        }
                        catch (Exception exception) {
                            
                        }
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "";
                    Menu_InGame_MapModes.searchText = keybMess;
                    menus.setVisible_InGame_MapModes_ResetTime(true);
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    Menu_InGame_MapModes.searchText = keybMess = keybMess + nChar;
                    menus.setVisible_InGame_MapModes_ResetTime(true);
                }
            };
        } else if (Keyboard.rankSearch && menus.getInGameView()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        try {
                            Menu_InGameRank.searchText = keybMess;
                            menus.rebuildInGame_Rank();
                        }
                        catch (Exception exception) {
                            
                        }
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "";
                    Menu_InGameRank.searchText = keybMess;
                    menus.rebuildInGame_Rank();
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    Menu_InGameRank.searchText = keybMess = keybMess + nChar;
                    menus.rebuildInGame_Rank();
                }
            };
        } else if (Keyboard.changeProvinceNameMode > 0 && menus.getInGameView()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        core.getProv(Keyboard.changeProvinceNameMode).setName2(keybMess);
                        CFG.aPNC(Keyboard.changeProvinceNameMode, keybMess);
                        core.setActiveProvID(Keyboard.changeProvinceNameMode);
                        try {
                            if (Keyboard.changeCityNameIDToo >= 0) {
                                core.getProv(Keyboard.changeProvinceNameMode).getCit(Keyboard.changeCityNameIDToo).setCityName(keybMess);
                            }
                        }
                        catch (Exception exception) {
                            
                        }
                        Keyboard.changeProvinceNameMode = -1;
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "";
                }
            };
            CFG.updateKeyboard_DefaultWrite();
        } else if (menus.getInCreateScenario_Events() && !menus.getVisibleCreateScenario_Events_Edit()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        Menu_CreateScenario_Events_List.searchText = keybMess;
                        if (!menus.getVisibleCreateScenario_Events_Edit()) {
                            menus.setVisibleCreateScenario_Events_List();
                        }
                    } else {
                        Menu_CreateScenario_Events_List.searchText = "";
                        if (!menus.getVisibleCreateScenario_Events_Edit()) {
                            menus.setVisibleCreateScenario_Events_List();
                        }
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        Menu_CreateScenario_Events_List.searchText = keybMess;
                        if (!menus.getVisibleCreateScenario_Events_Edit()) {
                            menus.setVisibleCreateScenario_Events_List();
                        }
                    } else {
                        Menu_CreateScenario_Events_List.searchText = "";
                        if (!menus.getVisibleCreateScenario_Events_Edit()) {
                            menus.setVisibleCreateScenario_Events_List();
                        }
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        Menu_CreateScenario_Events_List.searchText = keybMess;
                        if (!menus.getVisibleCreateScenario_Events_Edit()) {
                            menus.setVisibleCreateScenario_Events_List();
                        }
                    } else {
                        Menu_CreateScenario_Events_List.searchText = "";
                        if (!menus.getVisibleCreateScenario_Events_Edit()) {
                            menus.setVisibleCreateScenario_Events_List();
                        }
                    }
                }
            };
        } else if (menus.getInCreateScenario_Civilizations_Select()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Civilizations_SelectList();
                        menus.getCreateScenario_Civilizations_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Civilizations_SelectList();
                        menus.getCreateScenario_Civilizations_SelectAlphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Civilizations_SelectList();
                        menus.getCreateScenario_Civilizations_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Civilizations_SelectList();
                        menus.getCreateScenario_Civilizations_SelectAlphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Civilizations_SelectList();
                        menus.getCreateScenario_Civilizations_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Civilizations_SelectList();
                        menus.getCreateScenario_Civilizations_SelectAlphabet();
                    }
                }
            };
        } else if (menus.getInCreateScenario_Cores_AddCore()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Cores_AddCore_List();
                        menus.getCreateScenario_Cores_AddCore_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Cores_AddCore_List();
                        menus.getCreateScenario_Cores_AddCore_Alphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Cores_AddCore_List();
                        menus.getCreateScenario_Cores_AddCore_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Cores_AddCore_List();
                        menus.getCreateScenario_Cores_AddCore_Alphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Cores_AddCore_List();
                        menus.getCreateScenario_Cores_AddCore_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Cores_AddCore_List();
                        menus.getCreateScenario_Cores_AddCore_Alphabet();
                    }
                }
            };
        } else if (menus.getInCreateScenario_Cores_AddCiv()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Cores_AddCiv_List();
                        menus.getCreateScenario_Cores_AddCiv_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Cores_AddCiv_List();
                        menus.getCreateScenario_Cores_AddCiv_Alphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Cores_AddCiv_List();
                        menus.getCreateScenario_Cores_AddCiv_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Cores_AddCiv_List();
                        menus.getCreateScenario_Cores_AddCiv_Alphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Cores_AddCiv_List();
                        menus.getCreateScenario_Cores_AddCiv_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Cores_AddCiv_List();
                        menus.getCreateScenario_Cores_AddCiv_Alphabet();
                    }
                }
            };
        } else if (menus.getInUnions_AddCiv()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildUnions_AddCiv_List();
                        menus.getUnions_AddCiv_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildUnions_AddCiv_List();
                        menus.getUnions_AddCiv_Alphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildUnions_AddCiv_List();
                        menus.getUnions_AddCiv_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildUnions_AddCiv_List();
                        menus.getUnions_AddCiv_Alphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildUnions_AddCiv_List();
                        menus.getUnions_AddCiv_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildUnions_AddCiv_List();
                        menus.getUnions_AddCiv_Alphabet();
                    }
                }
            };
        } else if (menus.getInCreateVassal_Select()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateVassal_SelectList();
                        menus.getCreateVassal_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateVassal_SelectList();
                        menus.getCreateVassal_SelectAlphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateVassal_SelectList();
                        menus.getCreateVassal_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateVassal_SelectList();
                        menus.getCreateVassal_SelectAlphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateVassal_SelectList();
                        menus.getCreateVassal_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateVassal_SelectList();
                        menus.getCreateVassal_SelectAlphabet();
                    }
                }
            };
        } else if (menus.getInNewGame_AddCiv_Select()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildNewGame_AddCiv_SelectList();
                        menus.getNewGame_AddCiv_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildNewGame_AddCiv_SelectList();
                        menus.getNewGame_AddCiv_SelectAlphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildNewGame_AddCiv_SelectList();
                        menus.getNewGame_AddCiv_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildNewGame_AddCiv_SelectList();
                        menus.getNewGame_AddCiv_SelectAlphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildNewGame_AddCiv_SelectList();
                        menus.getNewGame_AddCiv_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildNewGame_AddCiv_SelectList();
                        menus.getNewGame_AddCiv_SelectAlphabet();
                    }
                }
            };
        } else if (menus.getInMapEditor_FormableCivs_SelectFormable()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildMapEditor_FormableCivs_SelectList();
                        menus.getMapEditor_FormableCivs_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildMapEditor_FormableCivs_SelectList();
                        menus.getMapEditor_FormableCivs_SelectAlphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildMapEditor_FormableCivs_SelectList();
                        menus.getMapEditor_FormableCivs_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildMapEditor_FormableCivs_SelectList();
                        menus.getMapEditor_FormableCivs_SelectAlphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildMapEditor_FormableCivs_SelectList();
                        menus.getMapEditor_FormableCivs_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildMapEditor_FormableCivs_SelectList();
                        menus.getMapEditor_FormableCivs_SelectAlphabet();
                    }
                }
            };
        } else if (menus.getInGameCivs()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildGameCivs_SelectList();
                        menus.getGameCivs_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildGameCivs_SelectList();
                        menus.getGameCivs_SelectAlphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildGameCivs_SelectList();
                        menus.getGameCivs_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildGameCivs_SelectList();
                        menus.getGameCivs_SelectAlphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildGameCivs_SelectList();
                        menus.getGameCivs_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildGameCivs_SelectList();
                        menus.getGameCivs_SelectAlphabet();
                    }
                }
            };
        } else if (menus.getInGame_AddCiv_Select()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildInGame_AddCiv_SelectList();
                        menus.getInGame_AddCiv_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildInGame_AddCiv_SelectList();
                        menus.getInGame_AddCiv_SelectAlphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildInGame_AddCiv_SelectList();
                        menus.getInGame_AddCiv_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildInGame_AddCiv_SelectList();
                        menus.getInGame_AddCiv_SelectAlphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildInGame_AddCiv_SelectList();
                        menus.getInGame_AddCiv_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildInGame_AddCiv_SelectList();
                        menus.getInGame_AddCiv_SelectAlphabet();
                    }
                }
            };
        } else if (menus.getInMapEditor_FormableCivs()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildMapEditor_FormableCivs();
                        menus.getMapEditor_FormableCivs_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildMapEditor_FormableCivs();
                        menus.getMapEditor_FormableCivs_Alphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildMapEditor_FormableCivs();
                        menus.getMapEditor_FormableCivs_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildMapEditor_FormableCivs();
                        menus.getMapEditor_FormableCivs_Alphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildMapEditor_FormableCivs();
                        menus.getMapEditor_FormableCivs_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildMapEditor_FormableCivs();
                        menus.getMapEditor_FormableCivs_Alphabet();
                    }
                }
            };
        } else if (menus.getInLeaders()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildLeaders();
                        menus.getLeaders_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildLeaders();
                        menus.getLeaders_Alphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildLeaders();
                        menus.getLeaders_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildLeaders();
                        menus.getLeaders_Alphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildLeaders();
                        menus.getLeaders_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildLeaders();
                        menus.getLeaders_Alphabet();
                    }
                }
            };
        } else if (menus.getInLeadersCreateScenario()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildLeadersCreateScenario();
                        menus.getLeaders_AlphabetCreateScenario();
                    } else {
                        sSearch = null;
                        menus.rebuildLeadersCreateScenario();
                        menus.getLeaders_AlphabetCreateScenario();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildLeadersCreateScenario();
                        menus.getLeaders_AlphabetCreateScenario();
                    } else {
                        sSearch = null;
                        menus.rebuildLeadersCreateScenario();
                        menus.getLeaders_AlphabetCreateScenario();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildLeadersCreateScenario();
                        menus.getLeaders_AlphabetCreateScenario();
                    } else {
                        sSearch = null;
                        menus.rebuildLeadersCreateScenario();
                        menus.getLeaders_AlphabetCreateScenario();
                    }
                }
            };
        } else if (menus.getInMapEditor_FormableCivs_SelectClaimant()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildMapEditor_FormableCivs_SelectClaimantList();
                        menus.getMapEditor_FormableCivs_SelectClaimantAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildMapEditor_FormableCivs_SelectClaimantList();
                        menus.getMapEditor_FormableCivs_SelectClaimantAlphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildMapEditor_FormableCivs_SelectClaimantList();
                        menus.getMapEditor_FormableCivs_SelectClaimantAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildMapEditor_FormableCivs_SelectClaimantList();
                        menus.getMapEditor_FormableCivs_SelectClaimantAlphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildMapEditor_FormableCivs_SelectClaimantList();
                        menus.getMapEditor_FormableCivs_SelectClaimantAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildMapEditor_FormableCivs_SelectClaimantList();
                        menus.getMapEditor_FormableCivs_SelectClaimantAlphabet();
                    }
                }
            };
        } else if (menus.getInLeader_Edit_SelectCivs()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildLeader_Edit_SelectCivs_List();
                        menus.getLeaders_SelectCivs_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildLeader_Edit_SelectCivs_List();
                        menus.getLeaders_SelectCivs_Alphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildLeader_Edit_SelectCivs_List();
                        menus.getLeaders_SelectCivs_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildLeader_Edit_SelectCivs_List();
                        menus.getLeaders_SelectCivs_Alphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildLeader_Edit_SelectCivs_List();
                        menus.getLeaders_SelectCivs_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildLeader_Edit_SelectCivs_List();
                        menus.getLeaders_SelectCivs_Alphabet();
                    }
                }
            };
        } else if (menus.getInRandomGame_Civilizations_Select()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildRandomGame_Civilizations_SelectList();
                        menus.getRandomGame_Civilizations_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildRandomGame_Civilizations_SelectList();
                        menus.getRandomGame_Civilizations_SelectAlphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildRandomGame_Civilizations_SelectList();
                        menus.getRandomGame_Civilizations_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildRandomGame_Civilizations_SelectList();
                        menus.getRandomGame_Civilizations_SelectAlphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildRandomGame_Civilizations_SelectList();
                        menus.getRandomGame_Civilizations_SelectAlphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildRandomGame_Civilizations_SelectList();
                        menus.getRandomGame_Civilizations_SelectAlphabet();
                    }
                }
            };
        } else if (menus.getInCreateScenario_Events_SelectCiv()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Events_SelectCiv_List();
                        menus.getCreateScenario_Events_SelectCiv_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Events_SelectCiv_List();
                        menus.getCreateScenario_Events_SelectCiv_Alphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Events_SelectCiv_List();
                        menus.getCreateScenario_Events_SelectCiv_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Events_SelectCiv_List();
                        menus.getCreateScenario_Events_SelectCiv_Alphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Events_SelectCiv_List();
                        menus.getCreateScenario_Events_SelectCiv_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Events_SelectCiv_List();
                        menus.getCreateScenario_Events_SelectCiv_Alphabet();
                    }
                }
            };
        } else if (menus.getInCreateScenario_Events_AddCiv()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    if (keybMess.length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Events_AddCiv_List();
                        menus.getCreateScenario_Events_AddCiv_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Events_AddCiv_List();
                        menus.getCreateScenario_Events_AddCiv_Alphabet();
                    }
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    if ((keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "").length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Events_AddCiv_List();
                        menus.getCreateScenario_Events_AddCiv_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Events_AddCiv_List();
                        menus.getCreateScenario_Events_AddCiv_Alphabet();
                    }
                }
            };
            keyboardWrite = new Keyboard_Action_Write(){

                @Override
                public void action(String nChar) {
                    if (CFG.updateKeyboardCheck(nChar)) {
                        return;
                    }
                    if ((keybMess = keybMess + nChar).length() > 0) {
                        sSearch = keybMess;
                        menus.rebuildCreateScenario_Events_AddCiv_List();
                        menus.getCreateScenario_Events_AddCiv_Alphabet();
                    } else {
                        sSearch = null;
                        menus.rebuildCreateScenario_Events_AddCiv_List();
                        menus.getCreateScenario_Events_SelectCiv_Alphabet();
                    }
                }
            };
        } else if (menus.getInCreateCity()) {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    menus.getActiveMenu().get(menus.getKeyboardActiveSliderMenuID()).getMenuElem(menus.getKeyboardActiveMenuElementID()).setTextE(keybMess);
                    editorCity.setCityName(keybMess);
                    menus.getCreateCity_UpdateSaveButton();
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "";
                    keyboardSave.action();
                    menus.getCreateCity_UpdateSaveButton();
                }
            };
            CFG.updateKeyboard_DefaultWrite();
        } else {
            keyboardSave = new Keyboard_Action(){

                @Override
                public void action() {
                    menus.getActiveMenu().get(menus.getKeyboardActiveSliderMenuID()).getMenuElem(menus.getKeyboardActiveMenuElementID()).setTextE(keybMess);
                }
            };
            keyboardDelete = new Keyboard_Action(){

                @Override
                public void action() {
                    keybMess = keybMess.length() > 1 ? keybMess.substring(0, keybMess.length() - 1) : "";
                }
            };
            CFG.updateKeyboard_DefaultWrite();
        }
    }

    private static final void updateKeyboard_DefaultWrite() {
        keyboardWrite = new Keyboard_Action_Write(){

            @Override
            public void action(String nChar) {
                if (CFG.updateKeyboardCheck(nChar)) {
                    return;
                }
                keybMess = keybMess + nChar;
            }
        };
    }

    public static boolean updateKeyboardCheck(String nChar) {
        return "\n".equals(nChar) || "\r".equals(nChar) || "\\r\\n".equals(nChar);
    }

    private static final int getKeyboardMessage_RGB() {
        block7: {
            try {
                int nRGB = Integer.parseInt(keybMess.substring(3, keybMess.length()));
                if (nRGB > 255) {
                    nRGB = 255;
                } else if (nRGB < 0) {
                    nRGB = 0;
                }
                return nRGB;
            }
            catch (IllegalArgumentException ex) {
                if (LOGs) {
                    CFG.exceptionStack(ex);
                }
            }
            catch (StringIndexOutOfBoundsException ex) {
                if (!LOGs) break block7;
                CFG.exceptionStack(ex);
            }
        }
        return 0;
    }

    public static final void drawRect(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY, nWidth, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY + nHeight - 1, nWidth, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY + 1, 1, nHeight - 2);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + nWidth, nPosY, 1, nHeight);
    }

    public static final void drawRect_InfoBox_Right_Title(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, nHeight);
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.525f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, nHeight, false, false);
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.525f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, nHeight, true, false);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 5);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY + nHeight - nHeight / 5 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 5, false, true);
        oSB.setColor(COLOR_NEW_GAME_EDGE_LINE2);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1, true, false);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY + nHeight - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1, true, false);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight() + 1, nWidth, 1, true, false);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY + nHeight - 2 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1, true, false);
        oSB.setColor(Color.WHITE);
    }

    public static final void drawRect_InfoBox_Right_Title2(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.75f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, nHeight);
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.525f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, nHeight, false, false);
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.525f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, nHeight, true, false);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 5);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY + nHeight - nHeight / 5 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 5, false, true);
        oSB.setColor(COLOR_NEW_GAME_EDGE_LINE2);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1, true, false);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY + nHeight - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1, true, false);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight() + 1, nWidth, 1, true, false);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY + nHeight - 2 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1, true, false);
        oSB.setColor(Color.WHITE);
    }

    public static final byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }

    public static final Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return o.readUnshared();
    }

    public static final Object deserializeLegacyScenario(byte[] bytes) throws IOException, ClassNotFoundException {
        java.io.ByteArrayInputStream b = new java.io.ByteArrayInputStream(bytes);
        java.io.ObjectInputStream o = new java.io.ObjectInputStream(b) {
            @Override
            protected Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
                if ("age.of.civilizations2.jakowski.lukasz.Scenario_GameData".equals(desc.getName())) {
                    return Scenario_GameData_Legacy.class;
                }
                return super.resolveClass(desc);
            }

            @Override
            protected java.io.ObjectStreamClass readClassDescriptor() throws java.io.IOException, java.lang.ClassNotFoundException {
                java.io.ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();
                if (resultClassDescriptor.getName().equals("age.of.civilizations2.jakowski.lukasz.Scenario_GameData")) {
                    return java.io.ObjectStreamClass.lookup(Scenario_GameData_Legacy.class);
                }
                return resultClassDescriptor;
            }
        };
        return o.readUnshared();
    }

    public static final void createUnionCivs(int nCivA, int nCivB) {
        int i;
        int i2;
        if (nCivA == nCivB || nCivA <= 0 || nCivB <= 0 || nCivA >= core.getCivsSize() || nCivB >= core.getCivsSize() || core.getCivsAtWar(nCivA, nCivB)) {
            return;
        }
        if (!core.getCiv(nCivA).getIsPlayer() && (core.getCiv(nCivB).getIsPlayer() || core.getCiv(nCivA).getNumOfProvs() < core.getCiv(nCivB).getNumOfProvs())) {
            int tempD = nCivA;
            nCivA = nCivB;
            nCivB = tempD;
        }
        int i3 = 0;
        while (i3 < core.getCiv(nCivB).getNumOfProvs()) {
            core.getProv(core.getCiv(nCivB).getProvID(i3)).getCores().addNewCore(nCivA, GameCalendar.TURNID);
            try {
                for (int j = 0; j < core.getProv(core.getCiv(nCivB).getProvID(i3)).getPop().getNatsSize(); ++j) {
                    if (core.getProv(core.getCiv(nCivB).getProvID(i3)).getPop().getCivID(j) != nCivB) continue;
                    core.getProv(core.getCiv(nCivB).getProvID(i3)).getPop().setPopulationOfCivID(nCivA, core.getProv(core.getCiv(nCivB).getProvID(i3)).getPop().getPopulationOfCivID(nCivA) + core.getProv(core.getCiv(nCivB).getProvID(i3)).getPop().getPopulationOfCivID(nCivB));
                    core.getProv(core.getCiv(nCivB).getProvID(i3)).getPop().setPopulationOfCivID(nCivB, 0);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                int nProvID = core.getCiv(nCivB).getProvID(i3);
                long nArmyA = core.getProv(core.getCiv(nCivB).getProvID(i3)).getArmyCivID1(nCivA);
                long nArmyB = core.getProv(core.getCiv(nCivB).getProvID(i3)).getArmyCivID1(nCivB);
                core.getProv(core.getCiv(nCivB).getProvID(i3)).updateArmy4(nCivA, 0);
                core.getProv(core.getCiv(nCivB).getProvID(i3)).updateArmy4(nCivB, 0);
                core.getProv(core.getCiv(nCivB).getProvID(i3)).setTrueOwnerOfProv(nCivA);
                core.getProv(core.getCiv(nCivB).getProvID(i3)).setCivId(nCivA, false);
                core.getProv(nProvID).updateArmy4(nCivA, nArmyA + nArmyB);
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        String nUnionTag = unionsManager.getUnionTag(core.getCiv(nCivA).getCivTag() + ";" + core.getCiv(nCivB).getCivTag());
        boolean generateFlag = false;
        if (nUnionTag.length() == 0) {
            nUnionTag = core.getCiv(nCivA).getCivTag() + ";" + core.getCiv(nCivB).getCivTag();
            generateFlag = true;
            core.getCiv(nCivA).setR((int)((float)core.getCiv(nCivA).getR() / 2.0f + (float)core.getCiv(nCivB).getR() / 2.0f));
            core.getCiv(nCivA).setG((int)((float)core.getCiv(nCivA).getG() / 2.0f + (float)core.getCiv(nCivB).getG() / 2.0f));
            core.getCiv(nCivA).setB((int)((float)core.getCiv(nCivA).getB() / 2.0f + (float)core.getCiv(nCivB).getB() / 2.0f));
            core.getCiv(nCivA).setCivTag(nUnionTag);
        } else {
            core.getCiv(nCivA).setCivTag(nUnionTag);
            palletManager.loadCivilizationStandardColor(nCivA);
        }
        try {
            for (int i4 = 1; i4 < core.getCivsSize(); ++i4) {
                if (core.getCiv(i4).getPuppetOfCiv() != nCivB || nCivB == i4) continue;
                core.getCiv(i4).setPuppetOfCivId(nCivA);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (core.getActiveProvID() >= 0) {
                int tD = core.getActiveProvID();
                core.setActiveProvID(-1);
                core.setActiveProvID(tD);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (core.getCiv(nCivB).getAlliance() > 0) {
                core.getAlliance(core.getCiv(nCivB).getAlliance()).removeCivilization(nCivB);
                core.getCiv(nCivB).setAlliance(0);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        Core.addSimpleTask(new Core.SimpleTask("buildCivilizationRegions" + nCivA, nCivA){

            @Override
            public void update() {
                try {
                    core.buildCivilizationRegions(this.id);
                }
                catch (Exception exception) {
                    
                }
            }
        });
        try {
            for (int i5 = 0; i5 < core.getCiv(nCivA).getNumOfProvs(); ++i5) {
                core.getProv(core.getCiv(nCivA).getProvID(i5)).setFromCivID(0);
            }
        }
        catch (Exception i5) {
            
        }
        for (i2 = 0; i2 < core.getCiv(nCivB).getArmyInAnotherProvinceSize(); ++i2) {
            core.getProv(core.getCiv(nCivB).getArmyInAnotherProviP(i2)).updateArmy4(nCivA, core.getProv(core.getCiv(nCivB).getArmyInAnotherProviP(i2)).getArmyCivID1(nCivA) + core.getProv(core.getCiv(nCivB).getArmyInAnotherProviP(i2)).getArmyCivID1(nCivB));
            core.getProv(core.getCiv(nCivB).getArmyInAnotherProviP(i2)).updateArmy4(nCivB, 0);
        }
        core.getCiv(nCivA).setNumberOfUnits(0);
        core.getCiv(nCivB).setNumberOfUnits(0);
        core.getCiv(nCivA).updateNumberOfUnits();
        if (core.getPlayerIDbyCivID(nCivB) >= 0) {
            core.removePlayer(core.getPlayerIDbyCivID(nCivB));
            core.getCiv(nCivB).setIsPlayer(false);
            PLAYER_TURN_ID = core.getPlayerIDbyCivID(nCivA);
        }
        for (i2 = 0; i2 < core.getCiv(nCivB).moveUnitsSize(); ++i2) {
            core.getCiv(nCivA).newMove(core.getCiv(nCivB).getMoveUnits(i2).getFromProviID(), core.getCiv(nCivB).getMoveUnits(i2).getToProvID(), core.getCiv(nCivB).getMoveUnits(i2).getNumberOfUnits(), true);
        }
        for (i2 = 0; i2 < core.getCiv(nCivB).getMoveUnitsPlunderSize(); ++i2) {
            core.getCiv(nCivA).newPlunder(core.getCiv(nCivB).getMoveUnitsPlunder(i2).getFromProvinceID(), core.getCiv(nCivB).getMoveUnitsPlunder(i2).getNumOfUnits());
        }
        for (i2 = 0; i2 < core.getCiv(nCivB).getRecruitArmySize(); ++i2) {
            core.getCiv(nCivA).recruitArmy(core.getCiv(nCivB).getRecruitArmy(i2).getProvinceID(), core.getCiv(nCivB).getRecruitArmy(i2).getArmy());
        }
        for (i2 = 0; i2 < core.getCiv(nCivB).getConstructionsSize(); ++i2) {
            core.getCiv(nCivA).addNewConstruction(core.getCiv(nCivB).getConstruction(i2));
        }
        core.getCiv(nCivB).clearConstructions();
        core.getCiv(nCivB).clearMoveUnits();
        core.getCiv(nCivB).clearMoveUnits_Plunder();
        core.getCiv(nCivB).clearRegroupArmy();
        core.getCiv(nCivB).clearRecruitArmy();
        core.getCiv(nCivA).setGold(core.getCiv(nCivA).getGold() + core.getCiv(nCivB).getGold());
        core.getCiv(nCivB).setGold(0L);
        gameNewGame.updateFormableCivilizations(nCivA);
        gameNewGame.updateFormableCivilizations(nCivB);
        if (core.getCiv(nCivB).getCapitalProvID() >= 0) {
            for (int k = 0; k < core.getProv(core.getCiv(nCivB).getCapitalProvID()).getCitSize(); ++k) {
                if (core.getProv(core.getCiv(nCivB).getCapitalProvID()).getCit(k).getCityLevel() != CFG.getEditorCityLevel(0)) continue;
                core.getProv(core.getCiv(nCivB).getCapitalProvID()).getCit(k).setCityLevel(CFG.getEditorCityLevel(1));
            }
            core.getProv(core.getCiv(nCivB).getCapitalProvID()).setIsCapital(false);
        }
        for (i2 = 1; i2 < core.getCivsSize(); ++i2) {
            if (i2 == nCivB || i2 == nCivA || core.getCiv(i2).getNumOfProvs() <= 0) continue;
            if (core.getCivsAtWar(i2, nCivB)) {
                int nWarID = core.getWarID(i2, nCivB);
                if (nWarID < 0 || nWarID >= core.getWarsSize()) continue;
                if (core.getCivsAtWar(i2, nCivA)) {
                    core.getWar(nWarID).updateAfterUnion(nCivA, nCivB);
                    continue;
                }
                core.war_CheckDiplomacy(i2, nCivA);
                core.setCivRelationOfCivB_AtWar(i2, nCivA);
                core.setCivRelationOfCivB_AtWar(nCivA, i2);
                core.getWar(nWarID).updateAfterUnion(nCivA, nCivB);
                continue;
            }
            if (core.getCivsAtWar(i2, nCivA)) continue;
            core.setCivRelationOfCivB(nCivA, i2, (core.getCivRelationOfCivB(nCivA, i2) + core.getCivRelationOfCivB(nCivB, i2)) / 2.0f);
            core.setCivRelationOfCivB(i2, nCivA, (core.getCivRelationOfCivB(i2, nCivA) + core.getCivRelationOfCivB(i2, nCivB)) / 2.0f);
        }
        if (!core.getCiv(nCivA).getIsPlayer()) {
            core.getCiv(nCivA).buildCivPersonality();
            try {
                if (core.getCiv(nCivA).getCivId() != core.getCiv(nCivA).getPuppetOfCiv() && core.getCiv(core.getCiv(nCivA).getPuppetOfCiv()).getIsPlayer()) {
                    Menu_InGame_Tribute.updateVassalsSpendings(nCivA);
                }
            }
            catch (Exception i6) {
                
            }
        }
        for (i = 0; i < core.getCiv(nCivB).getLoansSize(); ++i) {
            core.getCiv(nCivA).addLoanNew(CFG.core.getCiv((int)nCivB).getLoan((int)i).iGoldPerTurn, CFG.core.getCiv((int)nCivB).getLoan((int)i).iTurnsLeft);
        }
        core.getCiv(nCivB).clearLoans();
        for (i = core.getCiv(nCivB).getFestivalsSize() - 1; i >= 0; --i) {
            core.getCiv(nCivA).addFestival(core.getCiv(nCivB).getFestival(i));
            core.getCiv(nCivB).removeFestival(i);
        }
        for (i = core.getCiv(nCivB).getAssimilatesSize() - 1; i >= 0; --i) {
            core.getCiv(nCivA).addAssimilate(core.getCiv(nCivB).getAssimilate(i));
            core.getCiv(nCivB).removeAssimilate(i);
        }
        for (i = core.getCiv(nCivB).getInvestsSize() - 1; i >= 0; --i) {
            core.getCiv(nCivA).addInvest(core.getCiv(nCivB).getInvest(i));
            core.getCiv(nCivB).removeInvest(i);
        }
        if ((core.getPlayer(PLAYER_TURN_ID).getCivId() == nCivA || core.getPlayer(PLAYER_TURN_ID).getCivId() == nCivB) && FOG_OF_WAR > 0) {
            for (int updateI = 0; updateI < core.getCiv(nCivA).getNumOfProvs(); ++updateI) {
                core.getProv(core.getCiv(nCivA).getProvID(updateI)).updateDrawArmyInProv();
            }
            for (int updateI = 0; updateI < core.getCiv(nCivB).getNumOfProvs(); ++updateI) {
                core.getProv(core.getCiv(nCivB).getProvID(updateI)).updateDrawArmyInProv();
            }
        }
        try {
            if (CFG.hreMgr.holyRomanEmpire.getIsEmperor(nCivB)) {
                CFG.hreMgr.holyRomanEmpire.setEmperor(nCivA);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        gameAction.buildRank_Score(nCivA);
        gameAction.buildRank_Score(nCivB);
        gameAction.buildRank_Positions();
        if (core.getPlayer(PLAYER_TURN_ID).getCivId() == nCivA || core.getPlayer(PLAYER_TURN_ID).getCivId() == nCivB) {
            menus.updateInGameTopAll(core.getPlayer(PLAYER_TURN_ID).getCivId());
        }
        if (gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
            CFG.setActiveCivInfoId(CFG.getActiveCivInfoId());
        }
        if (gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
            core.getCiv(nCivA).loadFlag();
        } else {
            unionFlagsToGenerate_Manager.addFlagToLoad(nCivA);
        }
        if (generateFlag) {
            for (int i7 = 0; i7 < core.getPlayersSize(); ++i7) {
                if (core.getPlayer(i7).getCivId() != nCivA && core.getPlayer(i7).getCivId() != nCivB) continue;
                CFG.unionFlagsToGenerate_Manager.lFlags.add(new UnionFlagsToGenerate());
                int tGenerateID = CFG.unionFlagsToGenerate_Manager.lFlags.size() - 1;
                String[] tempD = core.getCiv(core.getPlayer(i7).getCivId()).getCivTag().split(";");
                for (int j = 0; j < tempD.length; ++j) {
                    CFG.unionFlagsToGenerate_Manager.lFlags.get((int)tGenerateID).lTags.add(tempD[j]);
                }
                CFG.unionFlagsToGenerate_Manager.lFlags.get((int)tGenerateID).typeOfAction = UnionFlagsToGenerate_TypesOfAction.PLAYER_ID;
                CFG.unionFlagsToGenerate_Manager.lFlags.get((int)tGenerateID).iID = core.getPlayer(i7).getCivId();
            }
        } else {
            for (int i8 = 0; i8 < core.getPlayersSize(); ++i8) {
                if (core.getPlayer(i8).getCivId() != nCivA && core.getPlayer(i8).getCivId() != nCivB) continue;
                Core.addSimpleTask(new Core.SimpleTask("loadPlayersFlag" + i8, i8){

                    @Override
                    public void update() {
                        core.getPlayer(this.id).loadPlayersFlag();
                    }
                });
            }
        }
        try {
            if (hreMgr.getHRE().getEmperor() == nCivB) {
                hreMgr.getHRE().addPrince(nCivA);
                hreMgr.getHRE().setEmperor(nCivA);
            }
        }
        catch (Exception exception) {
            
        }
        historyManager.addHistoryLog(new HistoryLog_Union(nCivA));
    }

    public static Object deserializeIgnoringUID(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b){

            @Override
            protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
                ObjectStreamClass incoming = super.readClassDescriptor();
                ObjectStreamClass local = ObjectStreamClass.lookup(Class.forName(incoming.getName()));
                if (local != null && incoming.getSerialVersionUID() != local.getSerialVersionUID()) {
                    return local;
                }
                return incoming;
            }
        };
        return o.readObject();
    }

    public int getSecondsSinceAppActive() {
        sUM.sUI.getStatI("app_active", 0);
        return 0;
    }

    public static void exceptionStack(Throwable e) {
        if (LOGs) {
            e.printStackTrace();
            if (GameValues.gvLogs.SAVE_LOGS_TO_FILE) {
                try {
                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    e.printStackTrace(pw);
                    pw.flush();
                    FileHandle file = FileManager.IS_MAC ? Gdx.files.external(LOGS_FILE) : Gdx.files.local(LOGS_FILE);
                    file.writeString("\n" + sw.toString(), append);
                    append = true;
                    if (appendNum++ > 999) {
                        append = false;
                        appendNum = 0;
                    }
                }
                catch (Exception exception) {
                    
                }
            }
        }
    }

    public static void LOG(String log) {
        CFG.LOG("DEFAULT", log);
        if (GameValues.gvLogs.SAVE_LOGS_TO_FILE) {
            FileHandle file = FileManager.IS_MAC ? Gdx.files.external(LOGS_FILE) : Gdx.files.local(LOGS_FILE);
            file.writeString("\n" + log, append);
            append = true;
            if (appendNum++ > 999) {
                append = false;
                appendNum = 0;
            }
        }
    }

    public static void LOG(String log, String log2) {
        if (LOGs) {
            Gdx.app.log(log, log2);
            if (GameValues.gvLogs.SAVE_LOGS_TO_FILE) {
                FileHandle file = FileManager.IS_MAC ? Gdx.files.external(LOGS_FILE) : Gdx.files.local(LOGS_FILE);
                file.writeString("\n[" + log + "] ", append);
                append = true;
                file.writeString(log2, true);
                if (appendNum++ > 999) {
                    append = false;
                    appendNum = 0;
                }
            }
        }
    }

    public static void LOG(Throwable e) {
        if (LOGs) {
            e.printStackTrace();
            if (GameValues.gvLogs.SAVE_LOGS_TO_FILE) {
                FileHandle file = FileManager.IS_MAC ? Gdx.files.external(LOGS_FILE) : Gdx.files.local(LOGS_FILE);
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                file.writeString(sw.toString(), append);
                append = true;
                if (appendNum++ > 999) {
                    append = false;
                    appendNum = 0;
                }
            }
        }
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    public static void loadRandomProvinceNames() {
        try {
            FileHandle tempFileT = FileManager.loadFile("game/random/RandomProvinceNames.txt");
            String[] tempSplit = tempFileT.readString().split("\n");
            for (int i = 0; i < tempSplit.length; ++i) {
                randomProvinceNames.add(tempSplit[i]);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void investAllDevelopment() {
        int num3 = core.investDevAllProvinces(core.getPlayer(PLAYER_TURN_ID).getCivId());
        if (num3 > 0) {
            menus.rebuildMenu_InGame_Infobox_AllAction(lang.get("Invest"), lang.get("Provinces") + ": " + num3, Images.infoDev);
        } else {
            toastM.addM(lang.get("Invest") + ": " + lang.get("Provinces") + ": " + num3, COLOR_TEXT_NUM_OF_PROVINCES);
            toastM.setTimeInView(2500);
        }
        menus.updateInGameTopAll(core.getPlayer(PLAYER_TURN_ID).getCivId());
        if (num3 > 0) {
            gameAction.updateInGame_ProvinceInfo();
            if (menus.getInGame_ProvincemMore_Visible()) {
                menus.setVisible_InGame_ProvinceMore(true, true);
            }
            if (mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DEVELOPMENT_MODE && menus.getVisible_InGame_View_Stats()) {
                menus.setVisible_InGame_ViewDevelopment(true);
            }
            SFXManager.playSound(age.of.civilizations2.jakowski.lukasz.SFXManager.SFX_WORKSHOP);
        }
    }

    public static Color getColorMixed_2(Color colorVassal, Color colorLord) {
        return new Color(colorLord.r * GameValues.gvVassal.VASSAL_COLOR_LORD_PERC + colorVassal.r * GameValues.gvVassal.VASSAL_COLOR_VASSAL_PERC, colorLord.g * GameValues.gvVassal.VASSAL_COLOR_LORD_PERC + colorVassal.g * GameValues.gvVassal.VASSAL_COLOR_VASSAL_PERC, colorLord.b * GameValues.gvVassal.VASSAL_COLOR_LORD_PERC + colorVassal.b * GameValues.gvVassal.VASSAL_COLOR_VASSAL_PERC, colorVassal.a);
    }

    public static void investAllEconomy() {
        int num2 = core.investEconomyAllProvinces(core.getPlayer(PLAYER_TURN_ID).getCivId());
        if (num2 > 0) {
            menus.rebuildMenu_InGame_Infobox_AllAction(lang.get("Invest"), lang.get("Provinces") + ": " + num2, Images.infoEconomy);
        } else {
            toastM.addM(lang.get("Invest") + ": " + lang.get("Provinces") + ": " + num2, COLOR_TEXT_NUM_OF_PROVINCES);
            toastM.setTimeInView(2500);
        }
        menus.updateInGameTopAll(core.getPlayer(PLAYER_TURN_ID).getCivId());
        if (num2 > 0) {
            gameAction.updateInGame_ProvinceInfo();
            if (menus.getInGame_ProvincemMore_Visible()) {
                menus.setVisible_InGame_ProvinceMore(true, true);
            }
            if (mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE && menus.getVisible_InGame_View_Stats()) {
                menus.setVisible_InGame_ViewEconomy(true);
            }
            SFXManager.playSound(age.of.civilizations2.jakowski.lukasz.SFXManager.SFX_WORKSHOP);
        }
    }

    public static void festivalAll() {
        int num4 = core.festivalAllProvinces(core.getPlayer(PLAYER_TURN_ID).getCivId());
        if (num4 > 0) {
            menus.rebuildMenu_InGame_Infobox_AllAction(lang.get("Festival"), lang.get("Provinces") + ": " + num4, Images.infoFestival);
        } else {
            toastM.addM(lang.get("Festival") + ": " + lang.get("Provinces") + ": " + num4, COLOR_TEXT_NUM_OF_PROVINCES);
            toastM.setTimeInView(2500);
        }
        menus.updateInGameTopAll(core.getPlayer(PLAYER_TURN_ID).getCivId());
        if (num4 > 0) {
            gameAction.updateInGame_ProvinceInfo();
            if (menus.getInGame_ProvincemMore_Visible()) {
                menus.setVisible_InGame_ProvinceMore(true, true);
            }
            if (mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_HAPPINESS_MODE && menus.getVisible_InGame_View_Stats()) {
                menus.setVisible_InGame_ViewHappiness(true);
            }
        }
    }

    public static void assimilateAll() {
        int num = core.assimilateAllProvinces(core.getPlayer(PLAYER_TURN_ID).getCivId());
        if (num > 0) {
            menus.rebuildMenu_InGame_Infobox_AllAction(lang.get("Assimilate"), lang.get("Provinces") + ": " + num, Images.infoStability);
        } else {
            toastM.addM(lang.get("Assimilate") + ": " + lang.get("Provinces") + ": " + num, COLOR_TEXT_NUM_OF_PROVINCES);
            toastM.setTimeInView(2500);
        }
        menus.updateInGameTopAll(core.getPlayer(PLAYER_TURN_ID).getCivId());
        if (num > 0) {
            gameAction.updateInGame_ProvinceInfo();
            if (menus.getInGame_ProvincemMore_Visible()) {
                menus.setVisible_InGame_ProvinceMore(true, true);
            }
            if (mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_PROVINCE_STABILITY_MODE && menus.getVisible_InGame_View_Stats()) {
                menus.setVisible_InGame_ViewProvinceStability(true);
            }
            SFXManager.playSound(age.of.civilizations2.jakowski.lukasz.SFXManager.SFX_ASSIMILATE);
        }
    }

    public static final int getCivilizationRanking_IMG_STAR_CIVID(int iCivID) {
        try {
            if (core.getCiv(iCivID).getRankPos() <= numGold) {
                return Images.rank;
            }
            if (core.getCiv(iCivID).getRankPos() <= numSilver) {
                return Images.rank1;
            }
            if (core.getCiv(iCivID).getRankPos() <= numBronze) {
                return Images.rank2;
            }
        }
        catch (Exception exception) {
            
        }
        return Images.rank3;
    }

    public static final void drawRectInfoBox_Left_Title(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, nHeight);
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.525f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, nHeight, false, false);
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.525f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, nHeight, true, false);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 5);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY + nHeight - nHeight / 5 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 5, false, true);
        oSB.setColor(COLOR_NEW_GAME_EDGE_LINE2);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1, true, false);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY + nHeight - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1, true, false);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.55f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight() + 1, nWidth, 1, true, false);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY + nHeight - 2 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1, true, false);
        oSB.setColor(Color.WHITE);
    }

    public static final void drawRect_InfoBox_Left(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, nHeight);
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.375f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, nHeight, false, false);
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.475f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, nHeight, true, false);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 5);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY + nHeight - nHeight / 5 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 5, false, true);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.475f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY + nHeight - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY + 1 - IMGManager.getIMG(Images.pix255).getHeight(), 1, nHeight - 2);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.175f));
        CFG.drawRect(oSB, nPosX - 1, nPosY - 2, nWidth + 1, nHeight + 2);
        oSB.setColor(Color.WHITE);
    }

    public static final void drawRect_InfoBox_Right(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, nHeight);
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.475f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, nHeight, false, false);
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.375f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, nHeight, true, false);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 5);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY + nHeight - nHeight / 5 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 5, false, true);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.475f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY + nHeight - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth, 1, true, false);
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + nWidth - 1, nPosY + 1 - IMGManager.getIMG(Images.pix255).getHeight(), 1, nHeight - 2);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.175f));
        CFG.drawRect(oSB, nPosX - 1, nPosY - 2, nWidth + 1, nHeight + 2);
        oSB.setColor(Color.WHITE);
    }

    public static final void drawRect_NewGameBoxDefault(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        IMGManager.getIMG(Images.gameBox).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gameBox).getHeight(), nWidth - IMGManager.getIMG(Images.gameBox).getWidth(), nHeight - IMGManager.getIMG(Images.gameBox).getHeight());
        IMGManager.getIMG(Images.gameBox).draw2O(oSB, nPosX + nWidth - IMGManager.getIMG(Images.gameBox).getWidth(), nPosY - IMGManager.getIMG(Images.gameBox).getHeight(), IMGManager.getIMG(Images.gameBox).getWidth(), nHeight - IMGManager.getIMG(Images.gameBox).getHeight(), true);
        IMGManager.getIMG(Images.gameBox).draw2O(oSB, nPosX, nPosY + nHeight - IMGManager.getIMG(Images.gameBox).getHeight() - IMGManager.getIMG(Images.gameBox).getHeight(), nWidth - IMGManager.getIMG(Images.gameBox).getWidth(), IMGManager.getIMG(Images.gameBox).getHeight(), false, true);
        IMGManager.getIMG(Images.gameBox).drawO(oSB, nPosX + nWidth - IMGManager.getIMG(Images.gameBox).getWidth(), nPosY + nHeight - IMGManager.getIMG(Images.gameBox).getHeight(), true, true);
    }

    public static final void drawRect_NewGameBoxEDGE(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gameTopEdge).getHeight(), nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth(), nHeight - IMGManager.getIMG(Images.gameTopEdge).getHeight());
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth(), nPosY - IMGManager.getIMG(Images.gameTopEdge).getHeight(), IMGManager.getIMG(Images.gameTopEdge).getWidth(), nHeight - IMGManager.getIMG(Images.gameTopEdge).getHeight(), true, false);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX, nPosY + nHeight - IMGManager.getIMG(Images.gameTopEdge).getHeight() * 2, nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth(), IMGManager.getIMG(Images.gameTopEdge).getHeight(), false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, nPosX + nWidth - IMGManager.getIMG(Images.gameTopEdge).getWidth(), nPosY + nHeight - IMGManager.getIMG(Images.gameTopEdge).getHeight() * 2, IMGManager.getIMG(Images.gameTopEdge).getWidth(), IMGManager.getIMG(Images.gameTopEdge).getHeight(), true, true);
    }

    public static final void drawEditorTitle_EdgeR(SpriteBatch oSB, int nPosX, int nPosY, int iWidth, int iHeight) {
        IMGManager.getIMG(Images.editor_top).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.editor_top).getHeight(), iWidth, iHeight + 1, true, true);
        oSB.setColor(new Color(0.025f, 0.03f, 0.092f, 0.225f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.line32Off1).getHeight(), iWidth, iHeight - 2);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.75f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX, nPosY + iHeight - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), iWidth, 1);
        oSB.setColor(Color.WHITE);
    }

    public static final void drawEditorTitle_Edge_R_Reflected(SpriteBatch oSB, int nPosX, int nPosY, int iWidth, int iHeight) {
        IMGManager.getIMG(Images.editor_top).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.editor_top).getHeight(), iWidth, iHeight + 1, false, true);
        oSB.setColor(new Color(0.025f, 0.03f, 0.092f, 0.225f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.line32Off1).getHeight(), iWidth, iHeight - 2);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.75f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX, nPosY + iHeight - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), iWidth, 1);
        oSB.setColor(Color.WHITE);
    }

    public static final void drawEditorTitle_Edge_LR(SpriteBatch oSB, int nPosX, int nPosY, int iWidth, int iHeight) {
        IMGManager.getIMG(Images.editor_top).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.editor_top).getHeight(), IMGManager.getIMG(Images.editor_top).getWidth(), iHeight + 1, false, true);
        IMGManager.getIMG(Images.editor_top).draw2O(oSB, nPosX + IMGManager.getIMG(Images.editor_top).getWidth(), nPosY - IMGManager.getIMG(Images.editor_top).getHeight(), iWidth - IMGManager.getIMG(Images.editor_top).getWidth(), iHeight + 1, true, true);
        oSB.setColor(new Color(0.025f, 0.03f, 0.092f, 0.225f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.line32Off1).getHeight(), iWidth, iHeight - 2);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.75f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX, nPosY + iHeight - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), iWidth, 1);
        oSB.setColor(Color.WHITE);
    }

    public static final void drawEditorTitle_Bot_Edge_LR(SpriteBatch oSB, int nPosX, int nPosY, int iWidth, int iHeight) {
        IMGManager.getIMG(Images.editor_top).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.editor_top).getHeight(), IMGManager.getIMG(Images.editor_top).getWidth(), iHeight + 1, false, false);
        IMGManager.getIMG(Images.editor_top).draw2O(oSB, nPosX + IMGManager.getIMG(Images.editor_top).getWidth(), nPosY - IMGManager.getIMG(Images.editor_top).getHeight(), iWidth - IMGManager.getIMG(Images.editor_top).getWidth(), iHeight + 1, true, false);
        oSB.setColor(new Color(0.025f, 0.03f, 0.092f, 0.225f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.line32Off1).getHeight() + 2, iWidth, iHeight - 2);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.75f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX, nPosY + iHeight - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), iWidth, 1);
        oSB.setColor(Color.WHITE);
    }

    public static final void drawEditorButtons_Bot_Edge_R(SpriteBatch oSB, int nPosX, int nPosY, int iWidth, int iHeight) {
        IMGManager.getIMG(Images.editor_top).draw2O(oSB, nPosX, nPosY - 1 - IMGManager.getIMG(Images.editor_top).getHeight(), iWidth, iHeight + 1, true, false);
        IMGManager.getIMG(Images.editor_top_line).draw2O(oSB, nPosX + iWidth - 1, nPosY - 2, IMGManager.getIMG(Images.editor_top_line).getWidth(), iHeight + 1, false, true);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.75f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), iWidth - PADD, 1);
        oSB.setColor(Color.WHITE);
    }

    public static final void drawEditorButtons_Bot_Edge_R_Reflected(SpriteBatch oSB, int nPosX, int nPosY, int iWidth, int iHeight) {
        IMGManager.getIMG(Images.editor_top).draw2O(oSB, nPosX, nPosY - 1 - IMGManager.getIMG(Images.editor_top).getHeight(), iWidth, iHeight + 1, false, false);
        IMGManager.getIMG(Images.editor_top_line).draw2O(oSB, nPosX - 1, nPosY - 2, IMGManager.getIMG(Images.editor_top_line).getWidth(), iHeight + 1, true, true);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.75f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + PADD, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), iWidth - PADD, 1, true, false);
        oSB.setColor(Color.WHITE);
    }

    public static final void drawEditorButtons_Top_Edge_R(SpriteBatch oSB, int nPosX, int nPosY, int iWidth, int iHeight) {
        IMGManager.getIMG(Images.editor_top).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.editor_top).getHeight(), iWidth, iHeight + 1, true, true);
        IMGManager.getIMG(Images.editor_top_line).draw2O(oSB, nPosX + iWidth - 1, nPosY - IMGManager.getIMG(Images.editor_top_line).getHeight(), IMGManager.getIMG(Images.editor_top_line).getWidth(), iHeight + 1, false, true);
    }

    public static final void drawEditorButtons_Top_Edge_R_Reflected(SpriteBatch oSB, int nPosX, int nPosY, int iWidth, int iHeight) {
        IMGManager.getIMG(Images.editor_top).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.editor_top).getHeight(), iWidth, iHeight + 1, false, true);
        IMGManager.getIMG(Images.editor_top_line).draw2O(oSB, nPosX - 1, nPosY - IMGManager.getIMG(Images.editor_top_line).getHeight(), IMGManager.getIMG(Images.editor_top_line).getWidth(), iHeight + 1, true, true);
    }

    public static final void drawBG_WithGradient(SpriteBatch oSB, int nPosX, int nPosY, int iWidth, int iHeight) {
        oSB.setColor(new Color(0.0f, 0.01f, 0.012f, 0.45f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), iWidth, iHeight);
        oSB.setColor(new Color(0.0f, 0.01f, 0.012f, 0.32f));
        IMGManager.getIMG(Images.patternReversed).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.patternReversed).getHeight(), iWidth, iHeight);
        oSB.setColor(new Color(0.0f, 0.01f, 0.012f, 0.75f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight(), iWidth, iHeight / 4);
        IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight() + iHeight - iHeight / 4, iWidth, iHeight, false, true);
        oSB.setColor(COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), iWidth, 1);
        IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX, nPosY + iHeight - 1 - IMGManager.getIMG(Images.pix255).getHeight(), iWidth, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight() - 1, iWidth, 1);
        IMGManager.getIMG(Images.pix255).draw2O(oSB, nPosX, nPosY + iHeight - 1 - IMGManager.getIMG(Images.pix255).getHeight() + 1, iWidth, 1);
        oSB.setColor(Color.WHITE);
    }

    public boolean isOverlayEnabled() {
        sUM.sUI.requestCurrentStats();
        return false;
    }

    public static final void setDialogType(DialogType nDialogType) {
        dialogType = nDialogType;
        logText("DialogType", nDialogType.name());
        menus.getDialogMenu().getMenuElem(1).setClickable(true);
        menus.getDialogMenu().getMenuElem(2).setClickable(true);
        try {
            switch (dialogType) {
                case EXIT_GAME: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("ExitTheGame"));
                    break;
                }
                case SELECT_CIVILIZATION: {
                    String civName = "Unknown";
                    if (core.getActiveProvID() >= 0 && core.getActiveProvID() < core.getProvinSize()) {
                        civName = core.getCiv(core.getProv(core.getActiveProvID()).getCivId()).getCivName();
                    }
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("PlayAs") + " " + civName + "?");
                    break;
                }
                case PAUSE_GAME: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("AreYouSure") + " " + lang.get("ExitToMainMenu") + "?");
                    break;
                }
                case CREATE_RANDOM_GAME_EXIT_MAIN_MENU: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("AreYouSure") + " " + lang.get("ExitToMainMenu") + "?");
                    break;
                }
                case PEACE_TREATY_BACK_ARE_YOU_SURE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Back") + "? " + lang.get("AreYouSure"));
                    break;
                }
                case SEND_DEMANDS: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("SendDemands") + "?");
                    break;
                }
                case PEACE_TREARY_ACCEPT: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("AcceptOffer") + "?");
                    break;
                }
                case PEACE_TREARY_REFUSE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Refuse") + "?");
                    break;
                }
                case ABADON: {
                    String provName = "Province";
                    if (Menu_InGame_AbandonProvince.iProvinceID >= 0 && Menu_InGame_AbandonProvince.iProvinceID < core.getProvinSize()) {
                        provName = core.getProv(Menu_InGame_AbandonProvince.iProvinceID).getName();
                    }
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("AbandonProvince") + "? " + provName);
                    break;
                }
                case LEAVE_HRE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("LeaveAlliance") + ": " + lang.get("HolyRomanEmpire") + "?");
                    break;
                }
                case DISSOLVE_HRE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("DisolveAlliance") + ": " + lang.get("HolyRomanEmpire") + "?");
                    break;
                }
                case UNITE_HRE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("UniteTheAlliance") + ": " + lang.get("HolyRomanEmpire") + "?");
                    break;
                }
                case INVITE_TO_HRE: {
                    int target = getActiveCivInfoId();
                    if (target <= 0 && core.getActiveProvID() >= 0) target = core.getProv(core.getActiveProvID()).getCivId();
                    if (target > 0) MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = target;
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("InviteCivilization") + ": " + lang.get("HolyRomanEmpire") + "? " + core.getCiv(MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getCivName());
                    break;
                }
                case JOIN_A_WAR_AGGRESSORS: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("JoinAWar") + "? " + core.getCiv(core.getWar(Menu_InGame_WarDetails.WAR_ID).getAggressorID(0).getCivID()).getCivName());
                    break;
                }
                case JOIN_A_WAR_DEFENDERS: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("JoinAWar") + "? " + core.getCiv(core.getWar(Menu_InGame_WarDetails.WAR_ID).getDefenderID(0).getCivID()).getCivName());
                    break;
                }
                case COLONIZE_PROVINCE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Colonize") + "?");
                    break;
                }
                case END_GAME_SPECTACTOR: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("SpectatorMode") + "?");
                    break;
                }
                case END_GAME_EXIT_MAIN_MENU: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("ExitToMainMenu") + "?");
                    break;
                }
                case END_GAME_ONE_MORE_TURN: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("JustOneMoreTurnIPromise") + "?");
                    break;
                }
                case CONTINUE_AFTER_END_GAME: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Back") + "?");
                    break;
                }
                case FIGHT_COALITION: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("FightTheCoalition") + "? " + lang.get("DeclareWar") + "?");
                    break;
                }
                case EXIT_CREATOR: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("ExitScenarioEditor") + "?");
                    break;
                }
                case PEACE_TREATY_TAKE_ALL: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(core.getCiv(MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getCivName() + ". " + lang.get("TakeAll") + "?");
                    break;
                }
                case CREATE_SCENARIO_REMOVE_CIVILIZATION: {
                    String civName = "Civilization";
                    if (iCreateScenario_ActiveProvinceID >= 0 && iCreateScenario_ActiveProvinceID < core.getProvinSize()) {
                        civName = core.getCiv(core.getProv(iCreateScenario_ActiveProvinceID).getCivId()).getCivName();
                    }
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Remove") + " " + civName + "?");
                    break;
                }
                case CREATE_SCENARIO_ASSIGN_CIVILIZATION: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Select") + " " + core.getCiv(core.getProv(core.getActiveProvID()).getCivId()).getCivName() + "?");
                    break;
                }
                case TRADE_REQUEST_SELECT_CIV: {
                    String civName = "Unknown";
                    if (core.getActiveProvID() >= 0) {
                        civName = core.getCiv(core.getProv(core.getActiveProvID()).getCivId()).getCivName();
                    }
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Select") + " " + civName + "?");
                    System.out.println("TRADE_DEBUG: setDialogType TRADE_REQUEST_SELECT_CIV activeProvID=" + core.getActiveProvID() + " civName=" + civName + " MANAGE_ID=" + MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID);
                    break;
                }
                case SAVE_SCENARIO: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("SaveScenario") + "?");
                    break;
                }
                case CREATE_SCENARIO_REMOVE_EVENT: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Remove") + "? " + eventsManager.getEvent(CFG.eventsManager.createEvent_EditEventID).getEventName() + "?");
                    break;
                }
                case CONFIRM_LANGUAGE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Language") + ": " + lang.get("LANGUAGENAME") + "?");
                    break;
                }
                case CREATE_SCENARIO_EVENTS_EDIT_BACK: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Back") + "?");
                    break;
                }
                case CREATE_SCENARIO_EVENTS_EDIT_SAVE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("SaveEvent") + "?");
                    break;
                }
                case SURRENDER: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Surrender") + "? " + core.getCiv(core.getPlayer(PLAYER_TURN_ID).getCivId()).getCivName());
                    break;
                }
                case FORM_A_CIV: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("FormX", lang.getCiv(formableCivs_GameData.getFormableCivTag())) + "?");
                    break;
                }
                case DESELET_ALL_SELECTED_PROVINCES: 
                case DESELET_ALL_SELECTED_PROVINCES_CREATE_A_VASSAL: 
                case DESELET_ALL_SELECTED_PROVINCES_CREATE_HOLY_ROMAN_EMPIRE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("DeselectAll") + "?");
                    break;
                }
                case NO_ORDERS: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("NoOrders"));
                    break;
                }
                case ALL_ASSIMILATE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Assimilate") + ": " + lang.get("AllProvinces"));
                    break;
                }
                case ALL_INVEST_FESTIVAL: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Festival") + ": " + lang.get("AllProvinces"));
                    break;
                }
                case ALL_PROPAGANDA: {
                    int target = getActiveCivInfoId();
                    if (target <= 0 && core.getActiveProvID() >= 0) target = core.getProv(core.getActiveProvID()).getCivId();
                    if (target > 0) MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = target;
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("SpreadPropaganda") + ": " + lang.get("AllProvinces"));
                    break;
                }
                case ALL_FORT: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get(BuildingsManager.getFort_Name(1)) + ": " + lang.get("AllProvinces"));
                    break;
                }
                case ALL_TOWER: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get(BuildingsManager.getTower_Name(1)) + ": " + lang.get("AllProvinces"));
                    break;
                }
                case ALL_FARM: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get(BuildingsManager.getFarm_Name(1)) + ": " + lang.get("AllProvinces"));
                    break;
                }
                case ALL_WORKSHOP: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get(BuildingsManager.getWorkshop_Name(1)) + ": " + lang.get("AllProvinces"));
                    break;
                }
                case ALL_MARKET: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get(BuildingsManager.getMarket_Name(1)) + ": " + lang.get("AllProvinces"));
                    break;
                }
                case ALL_LIBRARY: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get(BuildingsManager.getLibrary_Name(1)) + ": " + lang.get("AllProvinces"));
                    break;
                }
                case ALL_ARMOURY: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get(BuildingsManager.getArmoury_Name(1)) + ": " + lang.get("AllProvinces"));
                    break;
                }
                case ALL_SUPPLIES: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get(BuildingsManager.getSupply_Name(1)) + ": " + lang.get("AllProvinces"));
                    break;
                }
                case ALL_AIR_DEFENSE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get(BuildingsManager.getAirDefense_Name(1)) + ": " + lang.get("AllProvinces"));
                    break;
                }
                case ALL_PORT: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get(BuildingsManager.getPort_Name(1)) + ": " + lang.get("AllProvinces"));
                    break;
                }
                case ALL_INVEST_ECO: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Invest") + ", " + lang.get("Economy") + ": " + lang.get("AllProvinces"));
                    break;
                }
                case ALL_INVEST_DEV: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Invest") + ", " + lang.get("Development") + ": " + lang.get("AllProvinces"));
                    break;
                }
                case REVERSE_WASTELAND: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Reverse") + "?");
                    break;
                }
                case CONFIRM_END_TURN: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("SumbitOrders"));
                    break;
                }
                case START_TUTORIAL: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("StartTheTutorial"));
                    break;
                }
                case REMOVE_RANDOM_ALLIANCES_NAMES_BUNDLE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("AreYouSure") + "?");
                    break;
                }
                case REMOVE_TRADE_ZONE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("AreYouSure") + "?");
                    break;
                }
                case SAVE_THE_GAME: 
                case SAVE_THE_GAME_OPTIONS: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("SaveTheGame") + "?");
                    break;
                }
                case START_CHALLENGE_ID: {
                    try {
                        menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("StartChallenge") + ": #" + ChallengesManager.challengeList.get((int)ChallengesManager.START_CHALLENGE_ID).ID + " " + lang.getCiv(ChallengesManager.challengeList.get((int)ChallengesManager.START_CHALLENGE_ID).PLAY_AS) + " -> " + lang.getCiv(ChallengesManager.challengeList.get((int)ChallengesManager.START_CHALLENGE_ID).FORM_TAG) + "?");
                    }
                    catch (Exception ex) {
                        menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Error"));
                    }
                    break;
                }
                case REMOVE_PLAYER: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("RemovePlayer") + ": " + core.getCiv(core.getPlayer(PLAYER_TURN_ID).getCivId()).getCivName() + "?");
                    break;
                }
                case BECOME_VASSAL: {
                    int target = getActiveCivInfoId();
                    if (target <= 0 && core.getActiveProvID() >= 0) target = core.getProv(core.getActiveProvID()).getCivId();
                    if (target > 0) MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = target;
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("BecomeAVassal") + "?");
                    break;
                }
                case SAVE_THE_GAME_AS_NEW: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("SaveGameAsNew") + "?");
                    break;
                }
                case ALL_NOT_SAVED_PROGRESS_WILL_BE_LOST: 
                case ALL_NOT_SAVED_PROGRESS_WILL_BE_LOST2: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("AllNotSavedProgressFromLastGameWillBeLostContinue"));
                    break;
                }
                case AGE_OF_CIVILIZATIONS_MENU: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("AgeofCivilizations") + "? " + lang.get("RandomGame") + "?");
                    break;
                }
                case GO_TO_WIKI: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Open") + " " + getwikiinforlink(EDITOR_ACTIVE_GAMEDATA_TAG) + "?");
                    break;
                }
                case GO_TO_WIKI_SCENARIO: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Open") + " " + WWW_WIKI + EDITOR_ACTIVE_GAMEDATA_TAG + "?");
                    break;
                }
                case GO_TO_LINK: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Open") + " " + GO_TO_LINK + "?");
                    break;
                }
                case RELEASE_A_VASSAL: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("ReleaseAVassal") + "?");
                    break;
                }
                case ADD_PLAYER: {
                    int target = getActiveCivInfoId();
                    if (target <= 0 && core.getActiveProvID() >= 0) target = core.getProv(core.getActiveProvID()).getCivId();
                    if (target > 0) MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = target;
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("AddPlayer") + ": " + core.getCiv(MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getCivName() + "?");
                    break;
                }
                case JOIN_TO_HRE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("JoinAlliance") + ": " + lang.get("HolyRomanEmpire") + "?");
                    break;
                }
                case SHUFFLE_CIVILIZATIONS: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("ShuffleCivilizations") + "?");
                    break;
                }
                case GENERATE_SUGGESTED_OWNERS: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("GenerateSuggestedCivilizations") + "?");
                    break;
                }
                case GENERATE_PRE_DEFINED_BORDERS: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("GeneratePreDefinedBorders") + "?");
                    break;
                }
                case GENERATE_SEA_ROUTES: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("GenerateSeaRoutes") + "?");
                    break;
                }
                case MAP_EDITOR_WASTELAND_MAPS_WORLD_FILL: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("AreYouSure") + "?");
                    break;
                }
                case DELETE_SAVED_GAME: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("DeleteSavedGame"));
                    break;
                }
                case MAP_EDITOR_SEA_ARMY_BOXES_REMOVE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Remove") + " " + (MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 + 1) + "?");
                    break;
                }
                case REMOVE_PRINCE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Remove") + " " + core.getCiv(hreMgr.getHRE().getPrince(MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID)).getCivName() + "?");
                    break;
                }
                case CONVERT_ARMY_POSITION_TO_ANOTHER_SCALE: 
                case CONVERT_PORT_POSITION_TO_ANOTHER_SCALE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("AreYouSure") + "? " + lang.get("Scale") + " " + map.getMapScale(map.getActiveMapIDN()) + " -> " + lang.get("Scale") + " " + MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 + "?");
                    break;
                }
                case MANAGE_DIPLOMACY_REMOVE_CIVILIZATION_FROM_ALLIANCE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Remove") + " " + core.getCiv(MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getCivName() + "?");
                    break;
                }
                case NEW_GAME: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("NewGame") + "?");
                    break;
                }
                case DECLARE_WAR: {
                    int target = getActiveCivID_Any();
                    
                    if (target > 0) {
                        MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = target;
                        menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("DeclareWar") + "? " + core.getCiv(MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getCivName());
                    } else {
                        MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = 0;
                        menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("DeclareWar") + "?");
                    }
                    break;
                }
                case REMOVE_CITY: {
                    FileHandle fileData = FileManager.loadFile(F_MAP_PATH + map.getFileActiveMapPath() + "data/cities/" + EDITOR_ACTIVE_GAMEDATA_TAG);
                    try {
                        editorCity = (City)CFG.deserialize(fileData.readBytes());
                        menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("Remove") + " " + editorCity.getCityName() + "?");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                    }
                    catch (IOException iOException) {}
                    break;
                }
                case SAVE_GAME_AS_SCENARIO: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("SaveScenario") + "? (Standard JSON)");
                    break;
                }
                case SAVE_GAME_AS_SCENARIO_CUSTOM_JSON: {
                    menus.getDialogMenu().getMenuElem(3).setTextE(lang.get("SaveScenario") + "? (Custom JSON)");
                    break;
                }
                case DISABLE_EXPERIMENTAL_BATTLE: {
                    menus.getDialogMenu().getMenuElem(3).setTextE("Disable Experimental Battle System? This will revert to vanilla combat and disable Smart Bat+.");
                    break;
                }
                case DISABLE_BAT_PLUS: {
                    menus.getDialogMenu().getMenuElem(3).setTextE("Disable Smart Bat+?");
                    break;
                }
            }
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
        }
        menus.getDialogMenu().setVisibleM(true);
    }

    public static final void dialog_True() {
        ME_Hover_v2.resetAnimation();
        try {
            switch (dialogType) {
                case PAUSE_GAME: {
                    CFG.map.getMpS().setNewCurrentScaleByButton2(0.175f);
                    CFG.menus.setMenuID(View.eGAMES);
                    CFG.menus.setOrderOfMenu_Games();
                    CFG.map.getMpB().updateWorldMap_Shaders();
                    CFG.mapModesManager.disableAllViews();
                    CFG.tutorialManager.updateDrawTutorial(false);
                    return;
                }
                case EXIT_GAME: {
                    System.exit(0);
                    return;
                }
                case SELECT_CIVILIZATION: {
                    if (CFG.core.getPlayer(CFG.iSelectCivilizationPlayerID).getCivId() > 0) {
                        CFG.core.disableDrawCivilizationRegions(CFG.core.getPlayer(CFG.iSelectCivilizationPlayerID).getCivId());
                    }
                    CFG.core.getPlayer(CFG.iSelectCivilizationPlayerID).setCivId(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                    CFG.core.enableDrawCivilizationRegions(CFG.core.getPlayer(CFG.iSelectCivilizationPlayerID).getCivId(), 0);
                    CFG.menus.setMenuID(View.eNEWGAME_PLAYERS);
                    CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.iSelectCivilizationPlayerID).getCivId()).getCapitalProvID());
                    CFG.core.setActiveProvID(-1);
                    return;
                }
                case SEND_DEMANDS: {
                    if (CFG.peaceTreatyData == null) {
                         return;
                    }
                    boolean playerInvolved = false;
                    for (int pIdx = 0; pIdx < CFG.core.getPlayersSize(); ++pIdx) {
                        int pCivID = CFG.core.getPlayer(pIdx).getCivId();
                        if (CFG.core.getWar(CFG.peaceTreatyData.peaceTreatyGD.iWarID).getIsInAggressors(pCivID) || CFG.core.getWar(CFG.peaceTreatyData.peaceTreatyGD.iWarID).getIsInDefenders(pCivID)) {
                            playerInvolved = true;
                            break;
                        }
                    }

                    int fromCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                    if (CFG.SANDBOX_MODE && CFG.peaceTreatyData.brushCivID > 0) {
                        fromCivID = CFG.peaceTreatyData.brushCivID;
                        for (int i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.size(); i++) {
                            CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get(i).peaceTreatyAccepted = true;
                        }
                        for (int i = 0; i < CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.size(); i++) {
                            CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get(i).peaceTreatyAccepted = true;
                        }
                    } else if (CFG.SANDBOX_MODE && !playerInvolved) {
                        fromCivID = CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.size() > 0 ? CFG.peaceTreatyData.peaceTreatyGD.civsDemandsAggressors.get(0).iCivID : CFG.peaceTreatyData.peaceTreatyGD.civsDemandsDefenders.get(0).iCivID;
                    }
                    CFG.peaceTreatyData.preparePeaceTreatyToSend(fromCivID);
                    CFG.core.lPeaceTreaties.add(new PeaceTreaty_GameData_MessageData(CFG.peaceTreatyData.peaceTreatyGD));
                    String peaceTreatyTag = CFG.core.lPeaceTreaties.get((int)(CFG.core.lPeaceTreaties.size() - 1)).PEACE_TREATY_TAG;
                    
                    if (CFG.SANDBOX_MODE && (CFG.peaceTreatyData.brushCivID > 0 || !playerInvolved)) {
                        GameManager.acceptPeaceTreaty(fromCivID, peaceTreatyTag, true);
                        CFG.toastM.addM(CFG.lang.get("Accepted") + "!", CFG.COLOR_POSITIVE);
                    } else {
                        GameManager.sendPeaceTreaty(CFG.core.getWar(CFG.peaceTreatyData.peaceTreatyGD.iWarID).getIsAggressor(fromCivID), fromCivID, CFG.peaceTreatyData.peaceTreatyGD);
                        CFG.toastM.addM(CFG.lang.get("Sent") + "!", CFG.COLOR_POSITIVE);
                    }
                    Menu_PeaceTreaty.backToInGame();
                    CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                    if (CFG.menus.getVisibleInGame_WarDetails()) {
                        CFG.menus.setVisibleInGame_WarDetails(false);
                    }
                    CFG.toastM.setTimeInView(3500);
                    return;
                }
                case PEACE_TREARY_ACCEPT: {
                    GameManager.acceptPeaceTreaty(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.sRespondToPeaceTreatyID);
                    Menu_PeaceTreaty_Response.backToInGame();
                    CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                    if (CFG.menus.getVisibleInGame_WarDetails()) {
                        CFG.menus.setVisibleInGame_WarDetails(false);
                    }
                    return;
                }
                case PEACE_TREARY_REFUSE: {
                    GameManager.declinePeaceTreaty(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.sRespondToPeaceTreatyID);
                    Menu_PeaceTreaty_Response.backToInGame();
                    CFG.toastM.addM(CFG.lang.get("Refused"), CFG.COLOR_NEGATIVE_2);
                    CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                    if (CFG.menus.getVisibleInGame_WarDetails()) {
                        CFG.menus.setVisibleInGame_WarDetails(false);
                    }
                    return;
                }
                case JOIN_A_WAR_AGGRESSORS: {
                    GameManager.joinAWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getWar(Menu_InGame_WarDetails.WAR_ID).getAggressorID(0).getCivID(), CFG.core.getWar(Menu_InGame_WarDetails.WAR_ID).getDefenderID(0).getCivID());
                    CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                    CFG.menus.rebuildInGame_WarDetails();
                    CFG.menus.rebuildInGame_Messages();
                    CFG.menus.rebuildMenu_InGame_War(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getWar(Menu_InGame_WarDetails.WAR_ID).getDefenderID(0).getCivID());
                    return;
                }
                case LEAVE_HRE: {
                    try {
                        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setIsPartOfHolyRomanEmpire(false);
                        CFG.hreMgr.getHRE().removeElector(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.hreMgr.getHRE().removePrince(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("LeaveAlliance") + ": " + CFG.lang.get("HolyRomanEmpire"), GameCalendar.getCurrDate(), Images.infoDiplomacy);
                    }
                    catch (final Exception ex5) {}
                    return;
                }
                case DISSOLVE_HRE: {
                    try {
                        CFG.hreMgr.getHRE().dissolveHRE();
                        CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("DisolveAlliance") + ": " + CFG.lang.get("HolyRomanEmpire"), GameCalendar.getCurrDate(), Images.infoDiplomacy);
                    }
                    catch (final Exception ex6) {}
                    return;
                }
                case UNITE_HRE: {
                    try {
                        CFG.hreMgr.getHRE().uniteHRE(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("UniteTheAlliance") + ": " + CFG.lang.get("HolyRomanEmpire"), GameCalendar.getCurrDate(), Images.infoDiplomacy);
                        try {
                            if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs() > 0) {
                                Menu_InGame_CivilizationView.iCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                                CFG.core.getPlayer(CFG.PLAYER_TURN_ID).iBefore_PosX = CFG.map.getMpC().getPX();
                                CFG.core.getPlayer(CFG.PLAYER_TURN_ID).iBefore_PosY = CFG.map.getMpC().getPY();
                                CFG.core.getPlayer(CFG.PLAYER_TURN_ID).fBefore_Scale = CFG.map.getMpS().getCurrSc();
                                CFG.core.getPlayer(CFG.PLAYER_TURN_ID).iBefore_ActiveProvince = CFG.core.getActiveProvID();
                                CFG.core.getPlayer(CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                                CFG.mapModesManager.disableAllViews();
                                CFG.menus.setMenuID(View.eINGAME_CIV_VIEW);
                                if (CFG.FOG_OF_WAR == 2) {
                                    CFG.core.enableDrawCivilizationRegions_FogOfWar(Menu_InGame_CivilizationView.iCivID, 0);
                                }
                                else {
                                    CFG.core.enableDrawCivilizationRegions(Menu_InGame_CivilizationView.iCivID, 0);
                                }
                                CFG.map.getMpB().updateWorldMap_Shaders();
                                CFG.toastM.addM(CFG.lang.get("UniteTheAlliance") + ": " + CFG.lang.get("HolyRomanEmpire"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                                CFG.toastM.setTimeInView(1500);
                            }
                        }
                        catch (final Exception ex) {
                            Menu_InGame_CivilizationView.iCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                        }
                    }
                    catch (final Exception ex7) {}
                    return;
                }
                case JOIN_A_WAR_DEFENDERS: {
                    GameManager.joinAWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getWar(Menu_InGame_WarDetails.WAR_ID).getDefenderID(0).getCivID(), CFG.core.getWar(Menu_InGame_WarDetails.WAR_ID).getAggressorID(0).getCivID());
                    CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                    CFG.menus.rebuildInGame_WarDetails();
                    CFG.menus.rebuildInGame_Messages();
                    CFG.menus.rebuildMenu_InGame_War(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getWar(Menu_InGame_WarDetails.WAR_ID).getAggressorID(0).getCivID());
                    return;
                }
                case ABADON: {
                    if (CFG.gameAction.abandonProvince(Menu_InGame_AbandonProvince.iProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
                        CFG.toastM.addM(CFG.lang.get("Abandoned") + "!", CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        CFG.core.setActiveProvID(-1);
                        CFG.core.setActiveProvID(Menu_InGame_AbandonProvince.iProvinceID);
                        if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                            CFG.menus.setVisible_InGame_ProvinceMore(false, false);
                        }
                        CFG.gameAction.buildRank_Score(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        Core.addSimpleTask(new Core.SimpleTask("buildCivilizationRegions" + CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                            @Override
                            public void update() {
                                CFG.core.buildCivilizationRegions(this.id);
                            }
                        });
                    }
                    updateActiveCivilizationInfoInGame();
                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    CFG.menus.setVisibleInGame_SendMessage(false);
                    return;
                }
                case JOIN_TO_HRE: {
                    try {
                        final int civID = getActiveCivInfoId();
                        if (CFG.core.getCiv(civID).getRelationD(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) >= GameValues.gvHre.REQUIRED_RELATION_JOIN) {
                            if (CFG.core.getCiv(civID).getReligionID() == CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getReligionID()) {
                                CFG.hreMgr.getHRE().addPrince(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                                for (int a = 0; a < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs(); ++a) {
                                    CFG.hreMgr.getHRE().addPrince(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(a));
                                }
                                CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("Accepted") + ": " + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), GameCalendar.getCurrDate(), Images.infoDiplomacy);
                                CFG.toastM.addM(CFG.lang.get("Accepted"), CFG.COLOR_POSITIVE);
                            }
                            else {
                                CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("Required") + ": " + CFG.lang.get("Religion") + ": " + CFG.lang.get(CFG.religionManager.getReligion(CFG.core.getCiv(civID).getReligionID()).getName()), GameCalendar.getCurrDate(), Images.infoDiplomacy);
                                CFG.toastM.addM(CFG.lang.get("Required") + ": " + CFG.lang.get("Religion") + ": " + CFG.lang.get(CFG.religionManager.getReligion(CFG.core.getCiv(civID).getReligionID()).getName()), CFG.COLOR_NEGATIVE_1);
                            }
                        }
                        else {
                            CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("JoinAlliance") + ": " + CFG.lang.get("RequiredRelations") + ": " + GameValues.gvHre.REQUIRED_RELATION_JOIN, GameCalendar.getCurrDate(), Images.infoDiplomacy);
                            CFG.toastM.addM(CFG.lang.get("JoinAlliance") + ": " + CFG.lang.get("RequiredRelations") + ": " + GameValues.gvHre.REQUIRED_RELATION_JOIN, CFG.COLOR_NEGATIVE_1);
                        }
                    }
                    catch (final Exception ex8) {}
                    return;
                }
                case INVITE_TO_HRE: {
                    try {
                        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).playerGD.INVITED_CIVS_HRE < GameValues.gvHre.MAX_INVITED_CIVS) {
                            final int civID = getActiveCivInfoId();
                            if (CFG.core.getCiv(civID).getRelationD(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) >= GameValues.gvHre.REQUIRED_RELATION) {
                                final PlayerGD playerGD = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).playerGD;
                                ++playerGD.INVITED_CIVS_HRE;
                                CFG.hreMgr.getHRE().addPrince(civID);
                                for (int a = 0; a < CFG.core.getCiv(civID).getNumOfProvs(); ++a) {
                                    CFG.hreMgr.getHRE().addPrince(CFG.core.getCiv(civID).getProvID(a));
                                }
                                CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("InviteCivilization") + ": " + CFG.lang.get("Accepted") + ": " + CFG.core.getCiv(civID).getCivName(), GameCalendar.getCurrDate(), Images.infoDiplomacy);
                                CFG.toastM.addM(CFG.lang.get("Accepted"), CFG.COLOR_POSITIVE);
                            }
                            else {
                                CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("InviteCivilization") + ": " + CFG.lang.get("RequiredRelations") + ": " + GameValues.gvHre.REQUIRED_RELATION, GameCalendar.getCurrDate(), Images.infoDiplomacy);
                                CFG.toastM.addM(CFG.lang.get("InviteCivilization") + ": " + CFG.lang.get("RequiredRelations") + ": " + GameValues.gvHre.REQUIRED_RELATION, CFG.COLOR_NEGATIVE_1);
                            }
                        }
                        else {
                            CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("InviteCivilization") + ": " + CFG.lang.get("Limit") + ": " + CFG.core.getPlayer(CFG.PLAYER_TURN_ID).playerGD.INVITED_CIVS_HRE + " / " + GameValues.gvHre.MAX_INVITED_CIVS, GameCalendar.getCurrDate(), Images.infoDiplomacy);
                            CFG.toastM.addM(CFG.lang.get("InviteCivilization") + ": " + CFG.lang.get("Limit") + ": " + CFG.core.getPlayer(CFG.PLAYER_TURN_ID).playerGD.INVITED_CIVS_HRE + " / " + GameValues.gvHre.MAX_INVITED_CIVS, CFG.COLOR_NEGATIVE_1);
                        }
                    }
                    catch (final Exception ex9) {}
                    return;
                }
                case AGE_OF_CIVILIZATIONS_MENU: {
                    CFG.map.getMpS().setNewCurrentScaleByButton2(0.175f);
                    CFG.menus.setMenuID(View.eGAMES);
                    CFG.menus.setOrderOfMenu_Games();
                    CFG.map.getMpB().updateWorldMap_Shaders();
                    CFG.mapModesManager.disableAllViews();
                    CFG.tutorialManager.updateDrawTutorial(false);
                    return;
                }
                case END_GAME_EXIT_MAIN_MENU: {
                    try {
                        if (!CFG.SPECTATOR_MODE) {
                            int tNumOfPlayersInGame = 0;
                            for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                                if (CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getNumOfProvs() > 0 && i != CFG.PLAYER_TURN_ID) {
                                    ++tNumOfPlayersInGame;
                                }
                            }
                            if (tNumOfPlayersInGame == 0) {
                                CFG.startTheGameData = new Start_The_Game_Data(true);
                                Menu_StartTheGame_Reverse.END_GAME_MODE = false;
                                CFG.menus.setMenuID(View.eEND_THE_GAME);
                            }
                            else {
                                Menu_InGame_EndOfGame.clickBack();
                            }
                        }
                    }
                    catch (final IndexOutOfBoundsException ex2) {
                        exceptionStack(ex2);
                    }
                    catch (final Exception ex) {
                        exceptionStack(ex);
                    }
                    return;
                }
                case END_GAME_SPECTACTOR: {
                    CFG.startTheGameData = new Start_The_Game_Data(true);
                    Menu_StartTheGame_Reverse.END_GAME_MODE = true;
                    CFG.menus.setMenuID(View.eEND_THE_GAME);
                    return;
                }
                case END_GAME_ONE_MORE_TURN: {
                    Menu_InGame_EndOfGame.clickBack();
                    return;
                }
                case EXIT_CREATOR: {
                    CFG.core.setActiveProvID(-1);
                    CFG.menus.setMenuID(View.eEDITOR_SCENARIOS);
                    CFG.map.getMpC().centerToRandomMapPos();
                    Menu_CreateScenario_Settings.disposePreview();
                    return;
                }
                case COLONIZE_PROVINCE: {
                    final int nProvID = CFG.core.getActiveProvID();
                    if (GameManager.colonizeProvince(nProvID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), false)) {
                        CFG.menus.rebuildMenu_InGame_CityHaveBeenFounded(nProvID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    }
                    CFG.menus.setVisible_InGame_ProvinceAction_Colonize(false);
                    Core.addSimpleTask(new Core.SimpleTask("buildCivilizationRegions" + CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        @Override
                        public void update() {
                            CFG.core.buildCivilizationRegions(this.id);
                        }
                    });
                    final SFXManager sfxManager = CFG.SFXManager;
                    final SFXManager sfxManager2 = CFG.SFXManager;
                    sfxManager.playSound(age.of.civilizations2.jakowski.lukasz.SFXManager.SFX_MOVE_ARMY2);
                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                    return;
                }
                case PEACE_TREATY_TAKE_ALL: {
                    for (int j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.size(); ++j) {
                        if (CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get(j).iCivID == CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID) {
                            for (int k = 0; k < CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get(j).lProvincesLost.size(); ++k) {
                                if (CFG.peaceTreatyData.drawProvOwners.get(CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get(j).lProvincesLost.get(k)).isTaken < 0 && (CFG.core.getProv((int)CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get(j).lProvincesLost.get(k)).getCivId() == CFG.peaceTreatyData.brushCivID || CFG.core.getProv((int)CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get(j).lProvincesLost.get(k)).getTrueOwnerOfProv() == CFG.peaceTreatyData.brushCivID)) {
                                    CFG.peaceTreatyData.takeProvince((int)CFG.peaceTreatyData.peaceTreatyGD.civsDataDefenders.get(j).lProvincesLost.get(k), CFG.peaceTreatyData.brushCivID, CFG.core.getPlayer(CFG.peaceTreatyData.playerTurnID).getCivId());
                                }
                            }
                            return;
                        }
                    }
                    for (int j = 0; j < CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.size(); ++j) {
                        if (CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get(j).iCivID == CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID) {
                            for (int k = 0; k < CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get(j).lProvincesLost.size(); ++k) {
                                if (CFG.peaceTreatyData.drawProvOwners.get(CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get(j).lProvincesLost.get(k)).isTaken < 0 && (CFG.core.getProv((int)CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get(j).lProvincesLost.get(k)).getCivId() == CFG.peaceTreatyData.brushCivID || CFG.core.getProv((int)CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get(j).lProvincesLost.get(k)).getTrueOwnerOfProv() == CFG.peaceTreatyData.brushCivID)) {
                                    CFG.peaceTreatyData.takeProvince((int)CFG.peaceTreatyData.peaceTreatyGD.civsDataAggressors.get(j).lProvincesLost.get(k), CFG.peaceTreatyData.brushCivID, CFG.core.getPlayer(CFG.peaceTreatyData.playerTurnID).getCivId());
                                }
                            }
                            return;
                        }
                    }
                    return;
                }
                case PEACE_TREATY_BACK_ARE_YOU_SURE: {
                    Menu_PeaceTreaty.backToInGame();
                    return;
                }
                case CONTINUE_AFTER_END_GAME: {
                    Menu_Victory.clickBack();
                    CFG.gameAction.hideExtraViews();
                    CFG.menus.setVisible_InGame_EndOfGame(true);
                    return;
                }
                case RELEASE_A_VASSAL: {
                    try {
                        final List<Integer> tempProvinces = new ArrayList<Integer>();
                        for (int i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
                            tempProvinces.add(CFG.core.getProvSelected().getProv(i));
                        }
                        final int nVassalID = CFG.core.releaseVassal(CFG.createVassalData.sCivTag, (List)tempProvinces, CFG.createVassalData.iCapitalProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), false);
                        if (nVassalID >= 0) {
                            CFG.menus.rebuildMenu_InGame_VassalReleased(nVassalID);
                        }
                        if (CFG.createVassalData.playAsVassal) {
                            int nCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                            CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setIsPlayer(false);
                            for (int l = 1; l < CFG.core.getCivsSize(); ++l) {
                                if (CFG.core.getCiv(l).getCivTag().equals(CFG.createVassalData.sCivTag)) {
                                    nCivID = l;
                                    break;
                                }
                            }
                            CFG.core.getPlayer(CFG.PLAYER_TURN_ID).setCivId(nCivID);
                            CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setIsPlayer(true);
                            CFG.core.getPlayer(CFG.PLAYER_TURN_ID).loadPlayersFlag();
                            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        }
                        CFG.gameAction.buildFogOfWar(CFG.PLAYER_TURN_ID);
                        CFG.brushMode = false;
                        CFG.menus.setMenuID(View.eINGAME);
                        RenderProvince.updateDrawProvinces();
                        CFG.map.getMpB().updateWorldMap_Shaders();
                        CFG.createVassalData.dispose();
                        CFG.createVassalData = null;
                        CFG.mapModesManager.setActiveMapModeID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE);
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                        if (CFG.menus.getVisibleInGame_Tribute()) {
                            CFG.menus.rebuildInGame_Tribute();
                        }
                    }
                    catch (final Exception ex10) {
                        CFG.mapModesManager.setActiveMapModeID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE);
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    }
                }
                case GO_TO_WIKI: {
                    wikiInforLink(CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
                    return;
                }
                case GO_TO_WIKI_SCENARIO: {
                    try {
                        Gdx.net.openURI("https://en.wikipedia.org/wiki/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
                    }
                    catch (final GdxRuntimeException ex3) {
                        CFG.toastM.addM(CFG.lang.get("NoData"));
                    }
                    return;
                }
                case GO_TO_LINK: {
                    try {
                        Gdx.net.openURI(CFG.GO_TO_LINK);
                    }
                    catch (final GdxRuntimeException ex3) {
                        CFG.toastM.addM(CFG.lang.get("NoData"));
                    }
                    return;
                }
                case CREATE_SCENARIO_REMOVE_CIVILIZATION: {
                    CFG.toastM.addM(CFG.core.getCiv(CFG.core.getProv(CFG.iCreateScenario_ActiveProvinceID).getCivId()).getCivName() + " - " + CFG.lang.get("Removed"));
                    CFG.toastM.setTimeInView(2500);
                    CFG.core.disableDrawCivilizationRegions(CFG.core.getProv(CFG.iCreateScenario_ActiveProvinceID).getCivId());
                    CFG.core.createScenarioRemoveCivilization(CFG.core.getProv(CFG.iCreateScenario_ActiveProvinceID).getCivId());
                    updateCreateScenario_Civilizations();
                    CFG.menus.rebuildCreateScenario_Civilizations_Suggest();
                    CFG.core.setActiveProvID(CFG.core.getActiveProvID());
                    return;
                }
                case CREATE_SCENARIO_ASSIGN_CIVILIZATION: {
                    CFG.core.disableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv);
                    CFG.createScenarioAssignProvsCiv = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                    CFG.core.enableDrawCivilizationRegions(CFG.createScenarioAssignProvsCiv, 0);
                    return;
                }
                case CONFIRM_LANGUAGE: {
                    CFG.menus.getInSelectLanguage_OnBackPressed();
                    return;
                }
                case SURRENDER: {
                    CFG.menus.setVisible_InGame_Options(false);
                    CFG.menus.setMenuID(View.eDEFEAT);
                    CFG.map.getMpB().updateWorldMap_Shaders();
                    return;
                }
                case NEW_GAME: {
                    if (SaveGameManager.gameCanBeContinued) {
                        CFG.core.setActiveProvID(-1);
                        CFG.RANDOM_FILL = false;
                        CFG.RANDOM_PLACEMENT = false;
                        CFG.PLAYER_TURN_ID = 0;
                        CFG.core.getPlayer(0).initMetProvince(true);
                        CFG.core.loadScenario(false);
                        CFG.core.initPlayers();
                        SaveGameManager.gameCanBeContinued = false;
                        Menu_Games.clickNewGame();
                        CFG.menus.rebuildCivs_Info_Players();
                        RenderProvince.updateDrawProvinces();
                    }
                    CFG.FOG_OF_WAR = 1;
                    CFG.SPECTATOR_MODE = false;
                    CFG.AGE_OF_CHAOS_MODE = false;
                    CFG.core.initPlayers();
                    CFG.PLAYER_TURN_ID = 0;
                    if (CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(0).getCivId()).getIdeology()).CAN_BECOME_CIVILIZED >= 0) {
                        for (int j = 1; j < CFG.core.getCivsSize(); ++j) {
                            if (CFG.core.getCiv(j).getNumOfProvs() > 0 && CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(j).getIdeology()).CAN_BECOME_CIVILIZED < 0) {
                                CFG.core.getPlayer(0).setCivId(j);
                                break;
                            }
                        }
                    }
                    if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getLvlOfPort() >= 0) {
                        CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).setLvlOfPort(1);
                    }
                    for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getNeighProvincesSize(); ++j) {
                        CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getNeighProvinces(j)).setWastelandLvl(-1);
                        CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getNeighProvinces(j)).setCivId(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), false, false);
                    }
                    CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).setLvlOfFarm(1);
                    if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() < 5000L) {
                        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setGold(5000L);
                    }
                    int decWarOn = -1;
                    for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                        if (i != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(i).getNumOfProvs() > 0) {
                            decWarOn = i;
                            break;
                        }
                    }
                    if (decWarOn > 0) {
                        CFG.core.setCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), decWarOn, 0);
                        CFG.core.setCivNonAggressionPact(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), decWarOn, 0);
                        CFG.core.declareWar(decWarOn, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), false);
                    }
                    CFG.core.setActiveProvID(CFG.core.getActiveProvID());
                    Menu_CreateNewGame.newGame();
                    CFG.tutorialManager.startTutorial();
                    if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getArmyID(0) <= 0) {
                        CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).updateArmy4(750);
                    }
                    return;
                }
                case TRADE_REQUEST_SELECT_CIV: {
                    System.out.println("TRADE_DEBUG: dialog_True entered. dialogType=" + dialogType + " typeOfAction=" + Menu_InGame_TradeRequest_SelectCiv.typeOfAction + " MANAGE_ID=" + CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID + " activeProvID=" + CFG.core.getActiveProvID());
                    int selectedCivID = CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID;
                    if (selectedCivID <= 0) {
                        selectedCivID = CFG.core.getActiveProvID() >= 0 ? CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() : -1;
                        System.out.println("TRADE_DEBUG: fell back to activeProvID, selectedCivID=" + selectedCivID);
                    }
                    if (selectedCivID <= 0) {
                        System.out.println("TRADE_DEBUG: selectedCivID <= 0, returning");
                        return;
                    }
                    System.out.println("TRADE_DEBUG: selectedCivID=" + selectedCivID + " typeOfAction=" + Menu_InGame_TradeRequest_SelectCiv.typeOfAction + " TRADE_LEFT_DECLAREWAR=" + Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT_DECLAREWAR);
                    boolean handled = true;
                    if (Menu_InGame_TradeRequest_SelectCiv.typeOfAction == Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT_DECLAREWAR) {
                        System.out.println("TRADE_DEBUG: matched TRADE_LEFT_DECLAREWAR");
                        if (CFG.tradeRequest.listLEFT.lDeclareWarOnCivID.contains(selectedCivID)) {
                            CFG.tradeRequest.listLEFT.lDeclareWarOnCivID.remove((Integer)selectedCivID);
                        } else {
                            CFG.tradeRequest.listLEFT.lDeclareWarOnCivID.add(selectedCivID);
                        }
                    }
                    else if (Menu_InGame_TradeRequest_SelectCiv.typeOfAction == Menu_InGame_SelectProvinces.TypeOfAction.TRADE_RIGHT_DECLAREWAR) {
                        if (CFG.tradeRequest.listRight.lDeclareWarOnCivID.contains(selectedCivID)) {
                            CFG.tradeRequest.listRight.lDeclareWarOnCivID.remove((Integer)selectedCivID);
                        } else {
                            CFG.tradeRequest.listRight.lDeclareWarOnCivID.add(selectedCivID);
                        }
                    }
                    else if (Menu_InGame_TradeRequest_SelectCiv.typeOfAction == Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT_COALITION) {
                        if (CFG.tradeRequest.listLEFT.lFormCoalitionAgainst.contains(selectedCivID)) {
                            CFG.tradeRequest.listLEFT.lFormCoalitionAgainst.remove((Integer)selectedCivID);
                        } else {
                            CFG.tradeRequest.listLEFT.lFormCoalitionAgainst.add(selectedCivID);
                        }
                    }
                    else if (Menu_InGame_TradeRequest_SelectCiv.typeOfAction == Menu_InGame_SelectProvinces.TypeOfAction.TRADE_RIGHT_COALITION) {
                        if (CFG.tradeRequest.listRight.lFormCoalitionAgainst.contains(selectedCivID)) {
                            CFG.tradeRequest.listRight.lFormCoalitionAgainst.remove((Integer)selectedCivID);
                        } else {
                            CFG.tradeRequest.listRight.lFormCoalitionAgainst.add(selectedCivID);
                        }
                    }
                    else if (Menu_InGame_TradeRequest_SelectCiv.typeOfAction == Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT_PREPAREFORWAR) {
                        if (CFG.tradeRequest.listLEFT.lPrepareForWarCivID.contains(selectedCivID)) {
                            CFG.tradeRequest.listLEFT.lPrepareForWarCivID.remove((Integer)selectedCivID);
                        } else {
                            CFG.tradeRequest.listLEFT.lPrepareForWarCivID.add(selectedCivID);
                            CFG.tradeRequest.listLEFT.iPrepareForWarTurns = 25;
                        }
                    }
                    else if (Menu_InGame_TradeRequest_SelectCiv.typeOfAction == Menu_InGame_SelectProvinces.TypeOfAction.TRADE_RIGHT_PREPAREFORWAR) {
                        if (CFG.tradeRequest.listRight.lPrepareForWarCivID.contains(selectedCivID)) {
                            CFG.tradeRequest.listRight.lPrepareForWarCivID.remove((Integer)selectedCivID);
                        } else {
                            CFG.tradeRequest.listRight.lPrepareForWarCivID.add(selectedCivID);
                            CFG.tradeRequest.listRight.iPrepareForWarTurns = 25;
                        }
                    }
                    else if (Menu_InGame_TradeRequest_SelectCiv.typeOfAction == Menu_InGame_SelectProvinces.TypeOfAction.TRADE_LEFT_SANCTION) {
                        if (CFG.tradeRequest.listLEFT.lSanctionCivID.contains(selectedCivID)) {
                            CFG.tradeRequest.listLEFT.lSanctionCivID.remove((Integer)selectedCivID);
                        } else {
                            CFG.tradeRequest.listLEFT.lSanctionCivID.add(selectedCivID);
                            CFG.tradeRequest.listLEFT.iSanctionTurns = 250;
                        }
                    }
                    else if (Menu_InGame_TradeRequest_SelectCiv.typeOfAction == Menu_InGame_SelectProvinces.TypeOfAction.TRADE_RIGHT_SANCTION) {
                        if (CFG.tradeRequest.listRight.lSanctionCivID.contains(selectedCivID)) {
                            CFG.tradeRequest.listRight.lSanctionCivID.remove((Integer)selectedCivID);
                        } else {
                            CFG.tradeRequest.listRight.lSanctionCivID.add(selectedCivID);
                            CFG.tradeRequest.listRight.iSanctionTurns = 250;
                        }
                    } else {
                        handled = false;
                    }
                    if (handled) {
                        CFG.menus.rebuildInGame_TradeRequest(CFG.tradeRequest.iCivRIGHT);
                        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = -1;
                        CFG.menus.setMenuID(View.eINGAME);
                        RenderProvince.updateDrawProvinces();
                        CFG.mapModesManager.setActiveMapModeID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE);
                        return;
                    }
                    System.out.println("TRADE_DEBUG: fallback - no matching typeOfAction, returning to eINGAME");
                    CFG.menus.setMenuID(View.eINGAME);
                    CFG.menus.rebuildInGame_TradeRequest_Just();
                    RenderProvince.updateDrawProvinces();
                    CFG.mapModesManager.setActiveMapModeID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE);
                    return;
                }
                case FIGHT_COALITION: {
                    final int onCivID = CFG.gameAction.fightCoalition(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    try {
                        if (onCivID >= 0) {
                            updateActiveCivilizationInfoInGame();
                            for (int i = 0; i < CFG.core.getCiv(onCivID).getNumOfProvs(); ++i) {
                                CFG.core.getProv(CFG.core.getCiv(onCivID).getProvID(i)).updateDrawArmyInProv();
                            }
                            CFG.menus.rebuildMenu_InGame_War(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), onCivID);
                            CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE) {
                                CFG.mapModesManager.disableAllViews();
                            }
                            if (CFG.menus.getVisibleInGame_WarDetails()) {
                                CFG.menus.rebuildInGame_WarDetails();
                            }
                            if (CFG.menus.getVisibleInGame_WarPreparations()) {
                                CFG.menus.setVisibleInGame_WarPreparations(false);
                            }
                        }
                    }
                    catch (final Exception ex11) {}
                    final SFXManager sfxManager3 = CFG.SFXManager;
                    final SFXManager sfxManager4 = CFG.SFXManager;
                    sfxManager3.playSound(age.of.civilizations2.jakowski.lukasz.SFXManager.SFX_WAR2);
                    return;
                }
                case SAVE_SCENARIO: {
                    CFG.core.saveScenario();
                    CFG.backToMenu = View.eEDITOR_SCENARIOS;
                    CFG.menus.setMenuID(View.eGENERATE_PREVIEW);
                    Menu_CreateScenario_Settings.disposePreview();
                    return;
                }
                case CREATE_SCENARIO_EVENTS_EDIT_BACK: {
                    CFG.eventsManager.removeEvent(CFG.eventsManager.createEvent_EditEventID);
                    CFG.menus.setVisibleCreateScenario_Events_Edit(false);
                    return;
                }
                case CREATE_SCENARIO_EVENTS_EDIT_SAVE: {
                    CFG.eventsManager.setEvent(CFG.eventsManager.createEvent_EditEventID, CFG.eventsManager.createScenarioEvents);
                    CFG.menus.setVisibleCreateScenario_Events_Edit(false);
                    return;
                }
                case FORM_A_CIV: {
                    if (formCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
                        Core.addSimpleTask(new Core.SimpleTask("InfoBoxFormCiv_Player") {
                            @Override
                            public void update() {
                                CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("Formed") + ": " + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), GameCalendar.getCurrDate(), Images.infoDiplomacy);
                            }
                        });
                    }
                    setActiveCivInfoId(CFG.activeCivInfoId);
                    CFG.menus.setMenuIDWithoutAnim(View.eINGAME);
                    CFG.menus.setVisible_InGame_CivInfo(false);
                    CFG.map.getMpB().updateWorldMap_Shaders();
                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                    CFG.core.getPlayer(CFG.PLAYER_TURN_ID).loadPlayersFlag();
                    try {
                        if (!GameValues.gvInGame.CIV_DECISIONS_SHOW_ALL_FORMABLE_CIVS) {
                            CFG.menus.setVisibleInGame_SendMessage(false);
                        }
                    }
                    catch (final Exception ex) {
                        exceptionStack(ex);
                    }
                    AchievementsManager.unlockFormable(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivTag());
                    return;
                }
                case CONFIRM_END_TURN: {
                    CFG.gameAction.nextTurn();
                    return;
                }
                case CREATE_RANDOM_GAME_EXIT_MAIN_MENU: {
                    CFG.core.setActiveProvID(-1);
                    CFG.RANDOM_FILL = false;
                    CFG.RANDOM_PLACEMENT = false;
                    CFG.PLAYER_TURN_ID = 0;
                    CFG.core.getPlayer(0).initMetProvince(true);
                    Menu_LoadScenario.editor = false;
                    Menu_LoadScenario.goToView = null;
                    Menu_LoadScenario.loadActionEND = 2;
                    CFG.menus.setMenuIDWithoutAnim(View.eLOAD_SCENARIO);
                    return;
                }
                case ALL_NOT_SAVED_PROGRESS_WILL_BE_LOST: {
                    Menu_Games.clickNewGame();
                    return;
                }
                case ALL_NOT_SAVED_PROGRESS_WILL_BE_LOST2: {
                    Menu_Games.clickRandomGame();
                    return;
                }
                case NO_ORDERS: {
                    CFG.gameAction.nextTurn();
                    return;
                }
                case ALL_ASSIMILATE: {
                    assimilateAll();
                    if (CFG.menus.getVisible_InGame_CivInfo() && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == CFG.activeCivInfoId) {
                        CFG.menus.rebuildInGame_Civ_Info_Decisions();
                    }
                    return;
                }
                case ALL_INVEST_FESTIVAL: {
                    festivalAll();
                    if (CFG.menus.getVisible_InGame_CivInfo() && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == CFG.activeCivInfoId) {
                        CFG.menus.rebuildInGame_Civ_Info_Decisions();
                    }
                    return;
                }
                case ALL_PROPAGANDA: {
                    GameManager.spreadPropaganda_AllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), Menu_InGame_View_Happiness.iCivID);
                    break;
                }
                case ALL_FORT: {
                    CFG.core.fortAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                        CFG.menus.setVisible_InGame_MoreAll(true, true);
                    }
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_FORTIFICATIONS_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                        CFG.menus.setVisible_InGame_ViewBForts(true);
                    }
                    return;
                }
                case ALL_TOWER: {
                    CFG.core.towerAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                        CFG.menus.setVisible_InGame_MoreAll(true, true);
                    }
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_WATCH_TOWER_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                        CFG.menus.setVisible_InGame_ViewBTowers(true);
                    }
                    return;
                }
                case ALL_FARM: {
                    CFG.core.farmAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                        CFG.menus.setVisible_InGame_MoreAll(true, true);
                    }
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_FARM_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                        CFG.menus.setVisible_InGame_ViewBFarms(true);
                    }
                    return;
                }
                case ALL_WORKSHOP: {
                    CFG.core.workshopAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                        CFG.menus.setVisible_InGame_MoreAll(true, true);
                    }
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_WORKSHOP_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                        CFG.menus.setVisible_InGame_ViewBWorkshop(true);
                    }
                    return;
                }
                case ALL_LIBRARY: {
                    CFG.core.libraryAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                        CFG.menus.setVisible_InGame_MoreAll(true, true);
                    }
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_LIBRARY_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                        CFG.menus.setVisible_InGame_ViewBLibrary(true);
                    }
                    return;
                }
                case ALL_ARMOURY: {
                    CFG.core.armouryAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                        CFG.menus.setVisible_InGame_MoreAll(true, true);
                    }
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_ARMOURY_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                        CFG.menus.setVisible_InGame_ViewBArmoury(true);
                    }
                    return;
                }
                case ALL_SUPPLIES: {
                    CFG.core.suppliesAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                        CFG.menus.setVisible_InGame_MoreAll(true, true);
                    }
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_SUPPLY_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                        CFG.menus.setVisible_InGame_ViewBSupply(true);
                    }
                    return;
                }
                case ALL_AIR_DEFENSE: {
                    CFG.core.airDefenseAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                        CFG.menus.setVisible_InGame_MoreAll(true, true);
                    }
                    return;
                }
                case ALL_MARKET: {
                    CFG.core.marketAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                        CFG.menus.setVisible_InGame_MoreAll(true, true);
                    }
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_MARKET_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                        CFG.menus.setVisible_InGame_ViewBMarket(true);
                    }
                    return;
                }
                case ALL_PORT: {
                    CFG.core.pALPR(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                        CFG.menus.setVisible_InGame_MoreAll(true, true);
                    }
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_PORT_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                        CFG.menus.setVisible_InGame_ViewBPorts(true);
                    }
                    return;
                }
                case ALL_INVEST_ECO: {
                    investAllEconomy();
                    if (CFG.menus.getVisible_InGame_CivInfo() && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == CFG.activeCivInfoId) {
                        CFG.menus.rebuildInGame_Civ_Info_Decisions();
                    }
                    return;
                }
                case ALL_INVEST_DEV: {
                    investAllDevelopment();
                    if (CFG.menus.getVisible_InGame_CivInfo() && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == CFG.activeCivInfoId) {
                        CFG.menus.rebuildInGame_Civ_Info_Decisions();
                    }
                    return;
                }
                case REMOVE_RANDOM_ALLIANCES_NAMES_BUNDLE: {
                    CFG.editorAlliancesNames_GameData.removeBundle(CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID);
                    CFG.menus.setMenuID(View.eGAME_EDITOR_ALLIANCE_NAMES_PACKAGE_CREATE);
                    return;
                }
                case SAVE_THE_GAME: {
                    SaveGameManager.saveRequest = true;
                    CFG.toastM.addM(CFG.lang.get("GameWillBeSavedInNextTurn"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                    CFG.toastM.setTimeInView(4500);
                    CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("GameWillBeSavedInNextTurn"), GameCalendar.getCurrDate(), Images.infoDiplomacy);
                    CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                    return;
                }
                case SAVE_THE_GAME_OPTIONS: {
                    SaveGameManager.saveRequest = true;
                    CFG.toastM.addM(CFG.lang.get("GameWillBeSavedInNextTurn"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                    CFG.toastM.setTimeInView(4500);
                    CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("GameWillBeSavedInNextTurn"), GameCalendar.getCurrDate(), Images.infoDiplomacy);
                    CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                    Menu_InGame_Options.clickBack();
                    return;
                }
                case SAVE_THE_GAME_AS_NEW: {
                    SaveGameManager.saveTag = null;
                    SaveGameManager.saveRequest = true;
                    CFG.toastM.addM(CFG.lang.get("GameWillBeSavedInNextTurn"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                    CFG.toastM.setTimeInView(4500);
                    CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("GameWillBeSavedInNextTurn"), GameCalendar.getCurrDate(), Images.infoDiplomacy);
                    CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                    Menu_InGame_Options.clickBack();
                    return;
                }
                case SAVE_GAME_AS_SCENARIO: {
                    try {
                        CFG.CREATE_SCENARIO_NAME = "InGame_" + GameCalendar.currYear + "_" + GameCalendar.currMonth + "_" + GameCalendar.currDay;
                        CFG.CREATE_SCENARIO_AUTHOR = "Player";
                        CFG.CREATE_SCENARIO_GAME_DATA_TAG = "InGame_" + GameCalendar.currYear + "_" + System.currentTimeMillis();
                        CFG.core.saveScenario();
                        CFG.toastM.addM("Scenario Saved (Standard)!", CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(4500);
                        Menu_InGame_Options.clickBack();
                    } catch (Exception e) {
                        CFG.exceptionStack(e);
                    }
                    return;
                }
                case SAVE_GAME_AS_SCENARIO_CUSTOM_JSON: {
                    try {
                        CFG.CREATE_SCENARIO_NAME = "InGame_" + GameCalendar.currYear + "_" + GameCalendar.currMonth + "_" + GameCalendar.currDay;
                        CFG.CREATE_SCENARIO_AUTHOR = "Player";
                        CFG.CREATE_SCENARIO_GAME_DATA_TAG = "InGame_" + GameCalendar.currYear + "_" + System.currentTimeMillis();
                        CFG.core.saveScenario_CustomJSON();
                        CFG.toastM.addM("Scenario Saved (Custom JSON)!", CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(4500);
                        Menu_InGame_Options.clickBack();
                    } catch (Exception e) {
                        CFG.exceptionStack(e);
                    }
                    return;
                }
                case BECOME_VASSAL: {
                    if (Menu_InGame_BecomeVassal.iOnCivID > 0 && Menu_InGame_BecomeVassal.iOnCivID < CFG.core.getCivsSize() && Menu_InGame_BecomeVassal.iOnCivID != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        if (CFG.core.getCiv(Menu_InGame_BecomeVassal.iOnCivID).getIsPlayer()) {
                            CFG.core.getCiv(Menu_InGame_BecomeVassal.iOnCivID).getCivDiploGD().messageBox.addMessage((Message)new Message_BecomeVassal(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), Menu_InGame_BecomeVassal.iOnCivID));
                            CFG.menus.rebuildMenu_InGame_InfoboxSmallFlags(CFG.lang.get("AskToBecomeAVassal") + ": " + CFG.lang.get("Sent") + "!", GameCalendar.getCurrDate(), Images.infoDiplomacy, Menu_InGame_BecomeVassal.iOnCivID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        }
                        else {
                            CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).setPuppetOfCivId(Menu_InGame_BecomeVassal.iOnCivID);
                            CFG.menus.rebuildMenu_InGame_InfoboxSmallFlags(CFG.lang.get("VassalStatusConfirmed") + ": " + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), GameCalendar.getCurrDate(), Images.infoDiplomacy, Menu_InGame_BecomeVassal.iOnCivID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        }
                    }
                    CFG.menus.setVisibleInGame_MessageView(false);
                    Menu_InGame_Options.clickBack();
                    return;
                }
                case SHUFFLE_CIVILIZATIONS: {
                    CFG.core.shuffleCivilizations();
                    CFG.menus.setVisible_CreateNewGame_Options(false);
                    CFG.menus.setVisible_CreateNewGame_AddCiv(false);
                    CFG.menus.setVisible_CreateNewGame_AddCiv_Gov(false);
                    return;
                }
                case GENERATE_SUGGESTED_OWNERS: {
                    CFG.menus.setMenuID(View.eLOAD_GENERATE_SUGGESTED_OWNERS);
                    return;
                }
                case GENERATE_PRE_DEFINED_BORDERS: {
                    CFG.menus.setMenuID(View.eLOAD_GENERATE_PRE_DEFINED_BORDERS);
                    return;
                }
                case GENERATE_SEA_ROUTES: {
                    CFG.core.deleteSeaPaths();
                    CFG.core.buildSeaPaths();
                    CFG.toastM.addM(CFG.lang.get("Done"));
                    return;
                }
                case MAP_EDITOR_SEA_ARMY_BOXES_REMOVE: {
                    CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().remove(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2);
                    CFG.toastM.addM(CFG.lang.get("Removed"));
                    CFG.menus.setMenuIDWithoutAnim(View.eMAP_EDITOR_ARMY_SEA_BOXES_EDIT);
                    return;
                }
                case CONVERT_ARMY_POSITION_TO_ANOTHER_SCALE: {
                    CFG.core.convertProvincesArmyPositionToAnotherScale(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2);
                    CFG.menus.setMenuID(View.eMAP_EDITOR_ARMY_POSITION);
                    CFG.menus.setBackAnimation(true);
                    CFG.editorManager.setInUse(Editors.eSHIFT_ARMY);
                    return;
                }
                case CONVERT_PORT_POSITION_TO_ANOTHER_SCALE: {
                    CFG.core.convertProvincesPortPositionToAnotherScale(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2);
                    CFG.menus.setMenuID(View.eMAP_EDITOR_PORT_POSITION);
                    CFG.menus.setBackAnimation(true);
                    CFG.editorManager.setInUse(Editors.eSHIFT_PORT);
                    return;
                }
                case MANAGE_DIPLOMACY_REMOVE_CIVILIZATION_FROM_ALLIANCE: {
                    if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 > 0) {
                        CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).setAlliance(0);
                        CFG.core.getAlliance(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).removeCivilization(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1);
                        CFG.menus.setMenuIDWithoutAnim(View.eCUSTOMIZE_ALLIANCE);
                        break;
                    }
                    break;
                }
                case DESELET_ALL_SELECTED_PROVINCES: {
                    CFG.core.getProvSelected().clearSelectedProvinces();
                    CFG.selectMode = true;
                    return;
                }
                case DESELET_ALL_SELECTED_PROVINCES_CREATE_A_VASSAL: {
                    CFG.core.getProvSelected().clearSelectedProvinces();
                    CFG.selectMode = true;
                    CFG.createVassalData.iCapitalProvinceID = -1;
                    updateCreateAVassalCivInfo();
                    return;
                }
                case START_CHALLENGE_ID: {
                    try {
                        CFG.map.getMpC().centerToRandomMapPos();
                    }
                    catch (final Exception ex12) {}
                    try {
                        final int scenarioID = CFG.core.getGameScenars().getScenarioIDbyTag(ChallengesManager.challengeList.get(ChallengesManager.START_CHALLENGE_ID).SCENARIO_TAG);
                        if (scenarioID >= 0) {
                            SaveGameManager.gameCanBeContinued = false;
                            CFG.core.setActiveProvID(-1);
                            CFG.mapModesManager.disableAllViews();
                            CFG.core.setScenarioID(scenarioID);
                            Menu_LoadScenario.editor = false;
                            Menu_LoadScenario.goToView = View.eCREATE_NEW_GAME;
                            Menu_LoadScenario.loadActionEND = 10;
                            CFG.menus.setMenuIDWithoutAnim(View.eLOAD_SCENARIO);
                            ChallengesManager.STARTED_CHALLENGE_ID = ChallengesManager.START_CHALLENGE_ID;
                            Menu_CreateNewGame.CHALLENGE_MODE_NG = ChallengesManager.STARTED_CHALLENGE_ID;
                        }
                        else {
                            CFG.toastM.addM(CFG.lang.get("Scenario") + " " + CFG.lang.get("NotFound"));
                        }
                    }
                    catch (final Exception ex13) {}
                    break;
                }
                case ADD_PLAYER: {
                    try {
                        final int civID = getActiveCivInfoId();
                        if (civID > 0) {
                            if (CFG.SPECTATOR_MODE) {
                                CFG.SPECTATOR_MODE = false;
                                if (CFG.core.getPlayersSize() == 1) {
                                    CFG.core.removePlayer(0);
                                }
                            }
                            CFG.core.addPlayer(civID);
                            CFG.gameAction.buildFogOfWar(CFG.core.getPlayersSize() - 1);
                            if (CFG.FOG_OF_WAR == 2) {
                                CFG.core.getPlayer(CFG.core.getPlayersSize() - 1).buildMetProvsAndCivs();
                            }
                            CFG.core.getPlayer(CFG.core.getPlayersSize() - 1).loadPlayersFlag();
                            CFG.toastM.addM(CFG.lang.get("Added") + ": " + CFG.core.getCiv(civID).getCivName());
                        }
                    }
                    catch (final Exception ex) {
                        exceptionStack(ex);
                        break;
                    }
                }
                case DESELET_ALL_SELECTED_PROVINCES_CREATE_HOLY_ROMAN_EMPIRE: {
                    CFG.core.getProvSelected().clearSelectedProvinces();
                    CFG.selectMode = true;
                    for (int j = 0; j < CFG.core.getProvinSize(); ++j) {
                        CFG.core.getProv(j).setIsPartOfHolyRomanEmpire(false);
                    }
                    for (int j = 1; j < CFG.core.getCivsSize(); ++j) {
                        CFG.core.getCiv(j).setIsPartOfHolyRomanEmpire(false);
                    }
                    CFG.hreMgr.initHolyRomanEmpire();
                    CFG.menus.rebuildCreateScenario_HolyRomanEmpire_Princes();
                    return;
                }
                case REMOVE_PRINCE: {
                    CFG.toastM.addM(CFG.lang.get("Removed") + ": " + CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID)).getCivName(), CFG.COLOR_HOVER_TITLE);
                    CFG.hreMgr.getHRE().removePrince(CFG.hreMgr.getHRE().getPrince(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID));
                    CFG.menus.rebuildCreateScenario_HolyRomanEmpire_Princes();
                    return;
                }
                case MAP_EDITOR_WASTELAND_MAPS_WORLD_FILL: {
                    for (int j = 0; j < CFG.core.getProvinSize(); ++j) {
                        if (!CFG.core.getProv(j).getSeaProv()) {
                            if (CFG.core.getProv(j).getWastelandLvl() < 0) {
                                CFG.core.getProv(j).setWastelandLvl(0);
                            }
                            else {
                                CFG.core.getProv(j).setWastelandLvl(-1);
                            }
                        }
                    }
                    updateNumOfAvailableProvinces();
                    CFG.core.buildWastelandLevels();
                    CFG.toastM.addM(CFG.lang.get("Done"));
                    return;
                }
                case REVERSE_WASTELAND: {
                    int tempWasteland = 0;
                    int tempPlayable = 0;
                    for (int m = 0; m < CFG.core.getProvinSize(); ++m) {
                        if (CFG.core.getProv(m).getWastelandLvl() >= 0) {
                            ++tempWasteland;
                        }
                        else {
                            ++tempPlayable;
                        }
                    }
                    if (tempWasteland > tempPlayable) {
                        for (int m = 0; m < CFG.core.getProvinSize(); ++m) {
                            if (!CFG.core.getProv(m).getSeaProv()) {
                                CFG.core.getProv(m).setWastelandLvl(-1);
                            }
                        }
                    }
                    else {
                        for (int m = 0; m < CFG.core.getProvinSize(); ++m) {
                            if (!CFG.core.getProv(m).getSeaProv()) {
                                CFG.core.getProv(m).setWastelandLvl(0);
                            }
                        }
                        CFG.core.buildWastelandLevels();
                    }
                    CFG.toastM.addM(CFG.lang.get("Done"));
                    return;
                }
                case REMOVE_PLAYER: {
                    if (CFG.core.getPlayersSize() > 1) {
                        final int pTID = CFG.PLAYER_TURN_ID;
                        CFG.core.removePlayer(CFG.PLAYER_TURN_ID);
                        if (pTID > 0) {
                            CFG.PLAYER_TURN_ID = pTID - 1;
                            CFG.gameAction.loadActivePlayerData();
                        }
                        else {
                            CFG.gameAction.loadActivePlayerData();
                        }
                    }
                    return;
                }
                case DELETE_SAVED_GAME: {
                    SaveGameManager.deleteSavedGame(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID);
                    CFG.menus.setMenuID(View.eLOADGAME);
                    return;
                }
                case REMOVE_CITY: {
                    try {
                        if (FileManager.IS_MAC) {
                            Gdx.files.external("map/" + CFG.map.getFileActiveMapPath() + "data/" + "cities/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG).delete();
                        }
                        else {
                            Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "data/" + "cities/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG).delete();
                        }
                    }
                    catch (final Exception ex14) {}
                    try {
                        final FileHandle file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/" + "cities/" + "Age_of_Civilizations");
                        final String tempTags = file.readString();
                        final String[] tSplited = tempTags.split(";");
                        if (tSplited.length <= 1) {
                            if (FileManager.IS_MAC) {
                                Gdx.files.external("map/" + CFG.map.getFileActiveMapPath() + "data/" + "cities/" + "Age_of_Civilizations").delete();
                            }
                            else {
                                Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "data/" + "cities/" + "Age_of_Civilizations").delete();
                            }
                        }
                        else {
                            FileHandle fileSave;
                            if (FileManager.IS_MAC) {
                                fileSave = Gdx.files.external("map/" + CFG.map.getFileActiveMapPath() + "data/" + "cities/" + "Age_of_Civilizations");
                            }
                            else {
                                fileSave = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "data/" + "cities/" + "Age_of_Civilizations");
                            }
                            fileSave.writeString("", false);
                            for (int i2 = 0, iSize = tSplited.length; i2 < iSize; ++i2) {
                                if (!tSplited[i2].equals(CFG.EDITOR_ACTIVE_GAMEDATA_TAG)) {
                                    fileSave.writeString(tSplited[i2] + ";", true);
                                }
                            }
                        }
                    }
                    catch (final GdxRuntimeException ex4) {
                        if (CFG.LOGs) {
                            exceptionStack((Throwable)ex4);
                        }
                    }
                    CFG.menus.setMenuID(View.eEDITOR_CITIES);
                    return;
                }
                case DECLARE_WAR: {
                    int playerID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                    int targetID = CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID;
                    if (targetID <= 0) targetID = getActiveCivID_Any();
                    
                    CFG.customDeclareWar(playerID, targetID);
                    
                    final SFXManager sfxManager5 = CFG.SFXManager;
                    final SFXManager sfxManager6 = CFG.SFXManager;
                    sfxManager5.playSound(age.of.civilizations2.jakowski.lukasz.SFXManager.SFX_WAR2);
                    return;
                }
                case DISABLE_EXPERIMENTAL_BATTLE: {
                    CFG.settingsGD.EXPERIMENTAL_BATTLE_SYSTEM = false;
                    CFG.settingsGD.BAT_PLUS = false;
                    CFG.saveSettings();
                    CFG.menus.setMenuID(View.eSETTINGS);
                    return;
                }
                case DISABLE_BAT_PLUS: {
                    CFG.settingsGD.BAT_PLUS = false;
                    CFG.saveSettings();
                    CFG.menus.setMenuID(View.eSETTINGS);
                    return;
                }
                default: {}
            }
        }
        catch (final Exception ex) {
            exceptionStack(ex);
        }
    }

    public static void customDeclareWar(int nAggressorID, int nDefenderID) {
        if (nAggressorID <= 0 || nDefenderID <= 0 || nAggressorID == nDefenderID) {
            CFG.toastM.addM("           WAR ERROR: Target not found!           ", CFG.COLOR_NEGATIVE_2);
            return;
        }
        
        String aggressorName = CFG.core.getCiv(nAggressorID).getCivName();
        String defenderName = CFG.core.getCiv(nDefenderID).getCivName();
        
        if (defenderName.toLowerCase().contains("neutral")) {
             defenderName = "Enemy Civilization";
        }
        
        CFG.toastM.addM("           " + aggressorName + " declared war on " + defenderName + "           ", CFG.COLOR_NEGATIVE_1);
        
        CFG.core.setCivTruce(nAggressorID, nDefenderID, 0);
        CFG.core.setCivTruce(nDefenderID, nAggressorID, 0);
        CFG.core.setCivNonAggressionPact(nAggressorID, nDefenderID, 0);
        CFG.core.setCivNonAggressionPact(nDefenderID, nAggressorID, 0);
        
        CFG.core.declareWar(nAggressorID, nDefenderID, true);
        
        CFG.updateActiveCivilizationInfoInGame();
        CFG.oAI.buildAI_Data();
        
        for (int i = 0; i < CFG.core.getCiv(nDefenderID).getNumOfProvs(); i++) {
            CFG.core.getProv(CFG.core.getCiv(nDefenderID).getProvID(i)).updateDrawArmyInProv();
        }
        for (int i = 0; i < CFG.core.getCiv(nAggressorID).getNumOfProvs(); i++) {
            CFG.core.getProv(CFG.core.getCiv(nAggressorID).getProvID(i)).updateDrawArmyInProv();
        }
        
        CFG.menus.rebuildMenu_InGame_War(nAggressorID, nDefenderID);
        CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
        
        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE) {
            CFG.mapModesManager.disableAllViews();
        }
        if (CFG.menus.getVisibleInGame_WarDetails()) {
            CFG.menus.rebuildInGame_WarDetails();
        }
        if (CFG.menus.getVisibleInGame_WarPreparations()) {
            CFG.menus.setVisibleInGame_WarPreparations(false);
        }
        
        CFG.menus.updateInGameTopAll(nAggressorID);
        CFG.map.getMpB().updateWorldMap_Shaders();
    }

    public static final void dialog_False() {
        ME_Hover_v2.resetAnimation();
        switch (dialogType) {
            case PAUSE_GAME: {
                if (TimelapseManager.PAUSE) {
                    CFG.timelapseManager.pauseUnpause();
                }
                return;
            }
            case ABADON: {
                CFG.menus.setVisibleInGame_SendMessage(false);
            }
            default: {}
        }
    }

    public static final void updateCreateScenario_Civilizations() {
        if (core.getActiveProvID() >= 0) {
            if (core.getProv(core.getActiveProvID()).getSeaProv() || core.getProv(core.getActiveProvID()).getWastelandLvl() >= 0) {
                menus.getCreateScenario_Civilizations().getMenuElem(3).setClickable(false);
                menus.getCreateScenario_Civilizations().getMenuElem(4).setClickable(false);
                menus.getCreateScenario_Civilizations().getMenuElem(5).setClickable(false);
                menus.getCreateScenario_Civilizations().getMenuElem(6).setClickable(false);
                menus.setVisible_CreateScenario_Civilizations_Suggest(false);
                menus.setVisible_CreateScenario_Civilizations_Ideologies(false);
            } else if (core.getProv(core.getActiveProvID()).getCivId() > 0) {
                if (core.getProv(core.getActiveProvID()).isCapital()) {
                    menus.getCreateScenario_Civilizations().getMenuElem(3).setVisibleE(true);
                    menus.getCreateScenario_Civilizations().getMenuElem(3).setClickable(false);
                    menus.getCreateScenario_Civilizations().getMenuElem(4).setVisibleE(true);
                    menus.getCreateScenario_Civilizations().getMenuElem(4).setClickable(true);
                    menus.getCreateScenario_Civilizations().getMenuElem(5).setVisibleE(true);
                    menus.getCreateScenario_Civilizations().getMenuElem(5).setClickable(false);
                    menus.getCreateScenario_Civilizations().getMenuElem(6).setVisibleE(true);
                    menus.getCreateScenario_Civilizations().getMenuElem(6).setClickable(true);
                    menus.setVisible_CreateScenario_Civilizations_Ideologies(false);
                    menus.rebuildCreateScenario_Civilizations_Suggest();
                } else {
                    menus.getCreateScenario_Civilizations().getMenuElem(3).setVisibleE(true);
                    menus.getCreateScenario_Civilizations().getMenuElem(3).setClickable(true);
                    menus.getCreateScenario_Civilizations().getMenuElem(4).setVisibleE(true);
                    menus.getCreateScenario_Civilizations().getMenuElem(4).setClickable(true);
                    menus.getCreateScenario_Civilizations().getMenuElem(5).setVisibleE(true);
                    menus.getCreateScenario_Civilizations().getMenuElem(5).setClickable(true);
                    menus.getCreateScenario_Civilizations().getMenuElem(6).setVisibleE(true);
                    menus.getCreateScenario_Civilizations().getMenuElem(6).setClickable(true);
                    menus.setVisible_CreateScenario_Civilizations_Ideologies(false);
                    menus.rebuildCreateScenario_Civilizations_Suggest();
                }
            } else {
                menus.getCreateScenario_Civilizations().getMenuElem(3).setVisibleE(true);
                menus.getCreateScenario_Civilizations().getMenuElem(3).setClickable(true);
                menus.getCreateScenario_Civilizations().getMenuElem(4).setVisibleE(true);
                menus.getCreateScenario_Civilizations().getMenuElem(4).setClickable(false);
                menus.getCreateScenario_Civilizations().getMenuElem(5).setVisibleE(true);
                menus.getCreateScenario_Civilizations().getMenuElem(5).setClickable(false);
                menus.getCreateScenario_Civilizations().getMenuElem(6).setVisibleE(true);
                menus.getCreateScenario_Civilizations().getMenuElem(6).setClickable(false);
                menus.setVisible_CreateScenario_Civilizations_Ideologies(false);
                menus.rebuildCreateScenario_Civilizations_Suggest();
            }
        } else {
            menus.getCreateScenario_Civilizations().getMenuElem(3).setVisibleE(false);
            menus.getCreateScenario_Civilizations().getMenuElem(4).setVisibleE(false);
            menus.getCreateScenario_Civilizations().getMenuElem(5).setVisibleE(false);
            menus.getCreateScenario_Civilizations().getMenuElem(6).setVisibleE(false);
            menus.setVisible_CreateScenario_Civilizations_Suggest(false);
            menus.setVisible_CreateScenario_Civilizations_Ideologies(false);
        }
    }

    public static final String getAlliances_Random_Names_All_BundleID(Alliances_Names_GameData nEditorAlliancesNames_GameData, int iID) {
        String output = "";
        for (int i = 0; i < nEditorAlliancesNames_GameData.getBundle(iID).getWordsSize(); ++i) {
            output = output + nEditorAlliancesNames_GameData.getBundle(iID).getWord(i) + (i < nEditorAlliancesNames_GameData.getBundle(iID).getWordsSize() - 1 ? ", " : "");
        }
        return output;
    }

    public static final String getRandomAllianceName(Alliances_Names_GameData nEditorAlliancesNames_GameData) {
        String output;
        block3: {
            output = "";
            try {
                for (int i = 0; i < nEditorAlliancesNames_GameData.getSize(); ++i) {
                    output = output + nEditorAlliancesNames_GameData.getBundle(i).getWord(oR.nextInt(nEditorAlliancesNames_GameData.getBundle(i).getWordsSize())) + (i < nEditorAlliancesNames_GameData.getSize() - 1 ? " " : "");
                }
            }
            catch (IllegalArgumentException ex) {
                if (!LOGs) break block3;
                CFG.exceptionStack(ex);
            }
        }
        return output;
    }

    public static final void loadRandomAlliancesNames() {
        block3: {
            lRandomAlliancesNamesPackagesTags = new ArrayList<String>();
            try {
                FileHandle fileList = FileManager.loadFile("game/alliance_names/Age_of_Civilizations.json");
                String fileContent = fileList.readString();
                Json json = new Json();
                json.setElementType(ConfigAlliancesData.class, "Data_Random_Alliance_Names", Data_Random_Alliance_Names.class);
                ConfigAlliancesData data = new ConfigAlliancesData();
                data = json.fromJson(ConfigAlliancesData.class, fileContent);
                for (Object e : data.Data_Random_Alliance_Names) {
                    Data_Random_Alliance_Names tempData = (Data_Random_Alliance_Names)e;
                    if (!tempData.Enabled) continue;
                    lRandomAlliancesNamesPackagesTags.add(tempData.Tag);
                }
            }
            catch (GdxRuntimeException ex) {
                if (!LOGs) break block3;
                CFG.exceptionStack(ex);
            }
        }
    }

    public static final boolean isIOS() {
        return Gdx.app.getType() == Application.ApplicationType.iOS;
    }

    public static final boolean getIsDesktop() {
        return Gdx.app.getType() == Application.ApplicationType.Desktop;
    }

    public static final String getRandomAllianceName(int inc) {
        if (inc++ > 100) {
            return "";
        }
        try {
            int i;
            FileHandle file = FileManager.loadFile("game/alliance_names/" + lRandomAlliancesNamesPackagesTags.get(oR.nextInt(lRandomAlliancesNamesPackagesTags.size())));
            Alliances_Names_GameData tempGameData = (Alliances_Names_GameData)CFG.deserialize(file.readBytes());
            String output = "";
            for (i = 0; i < tempGameData.getSize(); ++i) {
                output = output + tempGameData.getBundle(i).getWord(oR.nextInt(tempGameData.getBundle(i).getWordsSize())) + (i == tempGameData.getSize() - 1 ? "" : " ");
            }
            for (i = 0; i < core.getAlliancesSize(); ++i) {
                if (!core.getAlliance(i).getAllianceName().equals(output)) continue;
                return CFG.getRandomAllianceName(inc);
            }
            return output;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            return "";
        }
    }

    public static final int gCARR(int nProvinceID) {
        return GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT - (core.getProv(nProvinceID).getLvlOfArmoury() > 0 ? GameValues.gvBuildingArmoury.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT_REDUCTION * core.getProv(nProvinceID).getLvlOfArmoury() : 0);
    }

    public static void mvTFL(int fromProvID, int byCivID, int toCivID) {
        try {
            if (core.getProv(fromProvID).getArmyCivID1(byCivID) <= 0) {
                toastM.addM(lang.get("Army") + ": 0", COLOR_NEGATIVE_2);
                return;
            }
            ArrayList<Integer> fPrv = new ArrayList<Integer>();
            Civilization toCiv = core.getCiv(toCivID);
            for (int i = toCiv.lFrontLines.size() - 1; i >= 0; --i) {
                int c;
                int b;
                if (byCivID == toCiv.lFrontLines.get((int)i).iWithCivID) {
                    for (b = CFG.core.getCiv((int)byCivID).lFrontLines.size() - 1; b >= 0; --b) {
                        if (CFG.core.getCiv((int)byCivID).lFrontLines.get((int)b).iWithCivID != toCivID) continue;
                        for (c = CFG.core.getCiv((int)byCivID).lFrontLines.get((int)b).lProvinces.size() - 1; c >= 0; --c) {
                            if (fPrv.contains(CFG.core.getCiv((int)byCivID).lFrontLines.get((int)b).lProvinces.get(c))) continue;
                            fPrv.add(CFG.core.getCiv((int)byCivID).lFrontLines.get((int)b).lProvinces.get(c));
                        }
                    }
                    continue;
                }
                if (byCivID != core.getCiv(toCiv.lFrontLines.get((int)i).iWithCivID).getPuppetOfCiv()) continue;
                for (b = CFG.core.getCiv((int)toCiv.lFrontLines.get((int)i).iWithCivID).lFrontLines.size() - 1; b >= 0; --b) {
                    if (CFG.core.getCiv((int)toCiv.lFrontLines.get((int)i).iWithCivID).lFrontLines.get((int)b).iWithCivID != toCivID) continue;
                    for (c = CFG.core.getCiv((int)toCiv.lFrontLines.get((int)i).iWithCivID).lFrontLines.get((int)b).lProvinces.size() - 1; c >= 0; --c) {
                        if (fPrv.contains(CFG.core.getCiv((int)toCiv.lFrontLines.get((int)i).iWithCivID).lFrontLines.get((int)b).lProvinces.get(c))) continue;
                        fPrv.add(CFG.core.getCiv((int)toCiv.lFrontLines.get((int)i).iWithCivID).lFrontLines.get((int)b).lProvinces.get(c));
                    }
                }
            }
            if (fPrv.isEmpty()) {
                toastM.addM(lang.get("Provinces") + ": 0", COLOR_NEGATIVE_2);
            } else {
                long armyPerMove = core.getProv(fromProvID).getArmyCivID1(byCivID) / (long)fPrv.size();
                if (armyPerMove <= 0) {
                    toastM.addM(lang.get("Army") + ": 0", COLOR_NEGATIVE_2);
                    return;
                }
                for (int a = fPrv.size() - 1; a >= 0; --a) {
                    RegroupArmy nRegroup;
                    if (a == 0) {
                        armyPerMove = core.getProv(fromProvID).getArmyCivID1(byCivID);
                    }
                    if ((nRegroup = new RegroupArmy(byCivID, fromProvID, (Integer)fPrv.get(a))).getRouteSize() == 1) {
                        gameAction.moveArmyAction(fromProvID, (Integer)fPrv.get(a), armyPerMove, byCivID, true, true);
                        continue;
                    }
                    if (nRegroup.getRouteSize() <= 0 || !gameAction.moveArmyAction(fromProvID, nRegroup.getRoute(0), armyPerMove, byCivID, true, true)) continue;
                    nRegroup.setFromProvinceID(nRegroup.getRoute(0));
                    nRegroup.removeRoute(0);
                    nRegroup.setNumOfUnits(armyPerMove);
                    core.getCiv(core.getPlayer(PLAYER_TURN_ID).getCivId()).addRegroupArmy(nRegroup);
                }
                menus.updateInGameTopAll(core.getPlayer(PLAYER_TURN_ID).getCivId());
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void editorServiceRibbon_Colors_Add() {
        if (editorServiceRibbon_Colors.size() == 0) {
            editorServiceRibbon_Colors.add(new Color(0.9843137f, 0.015686275f, 0.0f, 1.0f));
        } else if (editorServiceRibbon_Colors.size() == 1) {
            editorServiceRibbon_Colors.add(new Color(1.0f, 1.0f, 1.0f, 1.0f));
        } else if (editorServiceRibbon_Colors.size() == 2) {
            editorServiceRibbon_Colors.add(new Color(0.15294118f, 0.3019608f, 0.60784316f, 1.0f));
        } else if (editorServiceRibbon_Colors.size() == 3) {
            editorServiceRibbon_Colors.add(new Color(0.08627451f, 0.14901961f, 0.4509804f, 1.0f));
        } else {
            editorServiceRibbon_Colors.add(CFG.getRandomColor());
        }
    }

    public static String getLukaszJakowski() {
        if (loadedRobotoFont) {
            return sJakowski;
        }
        return sJakowski_2;
    }

    public static String getLukaszJakowskiGames() {
        if (loadedRobotoFont) {
            return sJakowskiGames;
        }
        return sJakowskiGames_2;
    }

    public static final boolean isAndroid() {
        return Gdx.app.getType() == Application.ApplicationType.Android || Gdx.app.getType() == Application.ApplicationType.iOS;
    }

    public static String gLI() {
        if (lRBF) {
            return jsi;
        }
        return jsiw;
    }

    public static String gLG() {
        if (lRBF) {
            return jsig;
        }
        return jsigw;
    }

    public static final String getCityLevelName(int iLevel) {
        switch (iLevel) {
            case 0: {
                return lang.get("Capital");
            }
            case 1: {
                return lang.get("City");
            }
            case 2: {
                return lang.get("Town");
            }
            case 3: {
                return lang.get("Village");
            }
            case 4: {
                return lang.get("Hamlet");
            }
        }
        return lang.get("Hamlet");
    }

    public static String getAoHDE() {
        return BU;
    }

    public static final int getEditorCityLevel(int nLevel) {
        switch (nLevel) {
            case 0: {
                return Images.city;
            }
            case 1: {
                return Images.city2;
            }
            case 2: {
                return Images.city3;
            }
            case 3: {
                return Images.city4;
            }
            case 4: {
                return Images.city5;
            }
        }
        return Images.city2;
    }

    public static final int getCityLevel_Population(float nMax, float nProvincePop, int nCityID) {
        if (nProvincePop / nMax >= 0.85f + 0.2f * (float)nCityID) {
            return Images.city2;
        }
        if ((float)nProvincePop / nMax >= 0.55f + 0.2f * (float)nCityID) {
            return Images.city3;
        }
        if ((float)nProvincePop / nMax >= 0.325f + 0.2f * (float)nCityID) {
            return Images.city4;
        }
        return Images.city5;
    }

    public static final int getEditorCityLevel_Ref(int nLevel) {
        if (nLevel == Images.city) {
            return 0;
        }
        if (nLevel == Images.city2) {
            return 1;
        }
        if (nLevel == Images.city3) {
            return 2;
        }
        if (nLevel == Images.city4) {
            return 3;
        }
        if (nLevel == Images.city5) {
            return 4;
        }
        return 2;
    }

    public static String getOpinion_String(int iOpinion) {
        if (iOpinion <= GameValues.gvDiplomacy.RELATION_AT_WAR) {
            return "";
        }
        if ((float)iOpinion < GameValues.gvDiplomacy.DIPLOMACY_RELATION_UNFAVORABLE) {
            return lang.get("Unfavorable");
        }
        if ((float)iOpinion < GameValues.gvDiplomacy.DIPLOMACY_RELATION_STRAINED) {
            return lang.get("Strained");
        }
        if ((float)iOpinion < GameValues.gvDiplomacy.DIPLOMACY_RELATION_DETACHED) {
            return lang.get("Detached");
        }
        if ((float)iOpinion < GameValues.gvDiplomacy.DIPLOMACY_RELATION_NEUTRAL) {
            return lang.get("Neutral");
        }
        if ((float)iOpinion < GameValues.gvDiplomacy.DIPLOMACY_RELATION_WARM) {
            return lang.get("Warm");
        }
        if ((float)iOpinion < GameValues.gvDiplomacy.DIPLOMACY_RELATION_COOPERATIVE) {
            return lang.get("Cooperative");
        }
        return lang.get("Supportive");
    }

    static {
        LOGs = true;
        DEBUG_MODE = false;
        sDEBUG = "#";
        LANDSCAPE = true;
        FONT_BOLD = 0;
        FONT_BOLD_SMALL = 1;
        FONT_REGULAR_SMALL = 2;
        sparksColors = new Color(1.0f, 1.0f, 1.0f, 0.25f);
        colorLine = new Color(0.5176471f, 0.43529412f, 0.25882354f, 0.55f);
        colorGradient = new Color(0.09803922f, 0.15686275f, 0.23529412f, 0.4f);
        colorGradientHover = new Color(0.19607843f, 0.13725491f, 0.11764706f, 0.75f);
        rotateXMoveUnits = new int[]{0, 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 14, 14, 14, 14, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 11, 11, 11, 11, 10, 10, 10, 10, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 0, 0, -1, -1, -1, -2, -2, -2, -3, -3, -3, -4, -4, -4, -5, -5, -5, -5, -5, -6, -6, -6, -7, -7, -7, -7, -8, -8, -8, -8, -8, -8, -8, -8, -9, -9, -9, -10, -10, -11, -11, -11, -11, -12, -12, -12, -13, -13, -13, -13, -13, -13, -13, -14, -14, -14, -14, -14, -14, -14, -14, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -14, -14, -14, -14, -14, -14, -13, -13, -13, -13, -13, -13, -13, -11, -11, -11, -11, -11, -11, -11, -11, -10, -10, -10, -10, -9, -9, -9, -9, -8, -8, -8, -8, -7, -7, -7, -7, -7, -7, -6, -6, -6, -5, -5, -5, -5, -5, -4, -4, -4, -3, -3, -2, -2, -1, -1, -1, -1, -1, 0, 0};
        rotateYMoveUnits = new int[]{-16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -17, -17, -17, -17, -17, -17, -18, -18, -18, -18, -18, -18, -18, -19, -19, -19, -19, -19, -19, -20, -20, -20, -20, -20, -20, -21, -21, -21, -21, -22, -22, -22, -22, -22, -22, -23, -23, -23, -23, -24, -24, -24, -24, -25, -25, -25, -25, -26, -26, -26, -27, -27, -27, -27, -28, -28, -28, -29, -29, -29, -29, -30, -30, -30, -31, -32, -32, -32, -32, -32, -32, -32, -33, -33, -34, -34, -34, -34, -34, -34, -34, -35, -36, -36, -36, -36, -36, -36, -37, -37, -37, -37, -37, -39, -39, -39, -39, -39, -39, -40, -40, -40, -40, -41, -41, -41, -42, -42, -43, -43, -43, -43, -43, -43, -44, -44, -44, -44, -44, -45, -45, -45, -45, -45, -45, -45, -45, -46, -46, -46, -46, -46, -46, -46, -46, -46, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -47, -47, -47, -47, -47, -47, -47, -47, -46, -46, -46, -46, -46, -46, -46, -46, -45, -45, -45, -45, -45, -45, -45, -44, -44, -43, -43, -43, -43, -42, -42, -42, -41, -41, -41, -41, -41, -41, -41, -40, -40, -40, -40, -40, -40, -40, -40, -39, -39, -39, -39, -37, -37, -37, -37, -36, -36, -36, -36, -35, -35, -35, -34, -34, -34, -34, -34, -33, -33, -33, -33, -32, -32, -32, -32, -31, -31, -30, -30, -30, -30, -29, -29, -29, -28, -28, -28, -27, -27, -27, -26, -26, -26, -26, -25, -25, -25, -25, -25, -25, -24, -24, -24, -24, -24, -24, -23, -23, -23, -23, -23, -23, -23, -23, -22, -22, -20, -20, -20, -20, -20, -20, -20, -20, -19, -19, -19, -19, -19, -19, -19, -19, -18, -18, -18, -18, -18, -18, -18, -18, -18, -18, -18, -18, -18, -18, -17, -17, -17, -17, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16};
        rotateXMoveUnits_64 = new int[]{0, 0, 0, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 11, 12, 13, 13, 13, 14, 14, 14, 15, 15, 16, 16, 17, 17, 18, 19, 19, 19, 20, 20, 20, 21, 21, 21, 22, 22, 22, 23, 23, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 28, 29, 29, 29, 29, 30, 30, 30, 30, 31, 31, 31, 31, 31, 31, 31, 31, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 31, 31, 31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 30, 30, 30, 30, 29, 29, 29, 29, 29, 29, 29, 28, 28, 27, 27, 26, 26, 26, 26, 26, 26, 25, 25, 25, 25, 24, 24, 24, 23, 23, 23, 22, 22, 21, 21, 20, 20, 19, 19, 18, 18, 17, 16, 16, 15, 14, 14, 13, 12, 12, 11, 10, 10, 9, 8, 8, 7, 7, 6, 6, 5, 5, 4, 4, 4, 3, 3, 2, 2, 1, 1, 0, 0, -1, -1, -2, -3, -3, -4, -5, -5, -6, -7, -7, -8, -9, -9, -9, -10, -10, -11, -12, -12, -13, -13, -14, -14, -15, -15, -15, -15, -16, -16, -16, -16, -17, -18, -18, -19, -20, -21, -21, -22, -22, -23, -23, -24, -25, -25, -25, -26, -26, -26, -26, -27, -27, -27, -28, -28, -28, -28, -28, -29, -29, -29, -29, -30, -30, -30, -30, -30, -30, -30, -30, -30, -30, -31, -31, -31, -31, -31, -31, -31, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -31, -31, -31, -31, -31, -31, -31, -31, -30, -30, -30, -30, -30, -30, -30, -30, -29, -29, -29, -29, -29, -29, -29, -28, -28, -28, -27, -27, -27, -26, -26, -25, -25, -24, -24, -23, -23, -22, -22, -22, -22, -21, -21, -21, -20, -20, -19, -19, -18, -18, -17, -17, -16, -16, -15, -15, -14, -14, -14, -13, -13, -13, -12, -12, -11, -10, -10, -10, -9, -9, -8, -8, -7, -6, -5, -4, -3, -2, -2, -1, -1, -2, 0, 0};
        rotateYMoveUnits_64 = new int[]{-32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -34, -34, -34, -34, -34, -34, -36, -36, -36, -36, -36, -36, -36, -38, -38, -38, -38, -38, -38, -40, -40, -40, -40, -40, -40, -42, -42, -42, -42, -44, -44, -44, -44, -44, -44, -46, -46, -46, -46, -48, -48, -48, -48, -50, -50, -50, -50, -52, -52, -52, -54, -54, -54, -54, -56, -56, -56, -58, -58, -58, -58, -60, -60, -60, -62, -64, -64, -64, -64, -64, -64, -64, -66, -66, -68, -68, -68, -68, -68, -68, -68, -70, -72, -72, -72, -72, -72, -72, -74, -74, -74, -74, -74, -78, -78, -78, -78, -78, -78, -80, -80, -80, -80, -82, -82, -82, -84, -84, -86, -86, -86, -86, -86, -86, -88, -88, -88, -88, -88, -90, -90, -90, -90, -90, -90, -90, -90, -92, -92, -92, -92, -92, -92, -92, -92, -92, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -94, -94, -94, -94, -94, -94, -94, -94, -92, -92, -92, -92, -92, -92, -92, -92, -90, -90, -90, -90, -90, -90, -90, -88, -88, -86, -86, -86, -86, -84, -84, -84, -82, -82, -82, -82, -82, -82, -82, -80, -80, -80, -80, -80, -80, -80, -80, -78, -78, -78, -78, -74, -74, -74, -74, -72, -72, -72, -72, -70, -70, -70, -68, -68, -68, -68, -68, -66, -66, -66, -66, -64, -64, -64, -64, -62, -62, -60, -60, -60, -60, -58, -58, -58, -56, -56, -56, -54, -54, -54, -52, -52, -52, -52, -50, -50, -50, -50, -50, -50, -48, -48, -48, -48, -48, -48, -46, -46, -46, -46, -46, -46, -46, -46, -44, -44, -40, -40, -40, -40, -40, -40, -40, -40, -38, -38, -38, -38, -38, -38, -38, -38, -36, -36, -36, -36, -36, -36, -36, -36, -36, -36, -36, -36, -36, -36, -34, -34, -34, -34, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32};
        COLOR_POP_GRADIENT = new Color[]{new Color(0.8627451f, 0.93333334f, 0.78039217f, 0.5f), new Color(0.8f, 0.92941177f, 0.7372549f, 0.5f), new Color(0.6901961f, 0.89411765f, 0.59607846f, 0.5f), new Color(0.6117647f, 0.8666667f, 0.49019608f, 0.5f), new Color(0.5647059f, 0.87058824f, 0.3137255f, 0.5f), new Color(0.41568628f, 0.7921569f, 0.23529412f, 0.5f), new Color(0.37254903f, 0.7294118f, 0.19607843f, 0.5f), new Color(0.30588236f, 0.6039216f, 0.16078432f, 0.5f), new Color(0.2509804f, 0.49019608f, 0.13333334f, 0.5f), new Color(0.20392157f, 0.4f, 0.10980392f, 0.5f), new Color(0.14509805f, 0.28627452f, 0.078431375f, 0.5f)};
        COLOR_WAR_DEATHS = new Color[]{new Color(1.0f, 0.9019608f, 0.9019608f, 0.5f), new Color(1.0f, 0.8f, 0.8f, 0.5f), new Color(1.0f, 0.69803923f, 0.69803923f, 0.5f), new Color(1.0f, 0.6f, 0.6f, 0.5f), new Color(1.0f, 0.47058824f, 0.47058824f, 0.5f), new Color(0.9411765f, 0.3529412f, 0.3529412f, 0.5f), new Color(0.8627451f, 0.25490198f, 0.25490198f, 0.5f), new Color(0.7647059f, 0.1764706f, 0.1764706f, 0.5f), new Color(0.64705884f, 0.11764706f, 0.11764706f, 0.5f), new Color(0.50980395f, 0.078431375f, 0.078431375f, 0.5f), new Color(0.37254903f, 0.039215688f, 0.039215688f, 0.5f)};
        COLOR_POP_RED = new Color[]{new Color(1.0f, 0.8627451f, 0.8627451f, 0.5f), new Color(1.0f, 0.78431374f, 0.78431374f, 0.5f), new Color(1.0f, 0.6666667f, 0.6666667f, 0.5f), new Color(1.0f, 0.54901963f, 0.54901963f, 0.5f), new Color(1.0f, 0.43137255f, 0.43137255f, 0.5f), new Color(0.9019608f, 0.3137255f, 0.3137255f, 0.5f), new Color(0.8235294f, 0.23529412f, 0.23529412f, 0.5f), new Color(0.7058824f, 0.15686275f, 0.15686275f, 0.5f), new Color(0.54901963f, 0.11764706f, 0.11764706f, 0.5f), new Color(0.39215687f, 0.078431375f, 0.078431375f, 0.5f), new Color(0.27450982f, 0.039215688f, 0.039215688f, 0.5f)};
        GAMEWIDTH = 1;
        GAMEHEIGHT = 1;
        iNumOfFPS = 60;
        BG_COLOR = new Color(0.0f, 0.0f, 0.0f, 1.0f);
        COLOR_MINIMAP_BORDER = new Color(0.251f, 0.192f, 0.09f, 1.0f);
        GUI_SCALE = 1.0f;
        DENSITY = 1.0f;
        XHDPI = false;
        XXHDPI = false;
        XXXHDPI = false;
        cloudsAnimation = new CloudsManager();
        NUM_OF_PROVINCES_IN_VIEW = 0;
        NUM_OF_SEA_PROVINCES_IN_VIEW = 0;
        NUM_OF_WASTELAND_PROVINCES_IN_VIEW = 0;
        NUM_OF_REGIONS_IN_VIEW = 0;
        settingsGD = new SettingsGD();
        PADD = 5;
        BUTTON_H = 68;
        BUTTON_W = 90;
        PREVIEW_HEIGHT = 194;
        CIV_COLOR_W = 3;
        CIV_NAME_BG_EXTRA_WIDTH = 8;
        CIV_NAME_BG_EXTRA_HEIGHT = 5;
        OUDH = -1;
        LPHE = new ArrayList<Integer>();
        CIV_NAME_BG_EXTRA_WIDTH_ARMY = 6;
        CIV_NAME_BG_EXTRA_HEIGHT_ARMY = 4;
        ARMY_BG_EXTRA_WIDTH = 0;
        ARMY_BG_EXTRA_HEIGHT = 2;
        ARMY_FLAG_PADDING_X = 4;
        ARMY_FLAG_PADDING_Y = 4;
        ARMY_FLAG_WIDTH = 30;
        ARMY_FLAG_HEIGHT = 18;
        COLOR_RESEARCH = new Color(0.4f, 0.6f, 0.8f, 1.0f);
        COLOR_DEVELOPMENT = new Color(0.19607843f, 0.19607843f, 0.39215687f, 1.0f);
        COLOR_POPULATION = new Color(0.23529412f, 0.47058824f, 0.2509804f, 1.0f);
        COLOR_POPULATION_HOVER = new Color(0.595f, 0.743f, 0.427f, 1.0f);
        COLOR_POPULATION_ACTIVE = new Color(0.4f, 0.51f, 0.3f, 1.0f);
        COLOR_POPULATION_GROWTHRATE_MIN = new Color(0.17254902f, 0.67058825f, 0.19607843f, 1.0f);
        COLOR_POPULATION_GROWTHRATE_MAX = new Color(0.16862746f, 0.44313726f, 0.20784314f, 1.0f);
        COLOR_HAPPINESS_MIN = new Color(0.7411765f, 0.19215687f, 0.30588236f, 1.0f);
        COLOR_HAPPINESS_MAX = new Color(0.9843137f, 0.9843137f, 0.019607844f, 1.0f);
        COLOR_RECRUITABLE_MIN = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        COLOR_RECRUITABLE_MAX = new Color(0.11764706f, 0.13725491f, 0.29411766f, 1.0f);
        COLOR_REVOLUTION_MIN = new Color(0.8235294f, 0.5882353f, 0.29411766f, 1.0f);
        COLOR_REVOLUTION_MIN_0 = new Color(0.09019608f, 0.39215687f, 0.078431375f, 0.25f);
        COLOR_REVOLUTION_MAX = new Color(0.50980395f, 0.13725491f, 0.078431375f, 1.0f);
        COLOR_PROVINCE_STABILITY_MIN = new Color(0.5686275f, 0.13725491f, 0.09803922f, 1.0f);
        COLOR_TEXT_PROVINCE_STABILITY_MIN_0 = new Color(0.09019608f, 0.39215687f, 0.078431375f, 0.25f);
        COLOR_PROVINCE_STABILITY_MAX = new Color(0.23529412f, 0.49019608f, 0.11764706f, 1.0f);
        COLOR_DISTANCE_MIN = new Color(0.8627451f, 0.84313726f, 0.1764706f, 1.0f);
        COLOR_DISTANCE_MAX = new Color(0.43137255f, 0.09803922f, 0.09803922f, 1.0f);
        COLOR_TEXT_HAPPINESS_HOVER = new Color(0.99607843f, 0.5137255f, 0.007843138f, 1.0f);
        COLOR_TEXT_HAPPINESS_ACTIVE = new Color(0.9843137f, 0.6901961f, 0.003921569f, 1.0f);
        COLOR_TEXT_CHECKBOX_TRUE = new Color(0.55f, 0.8f, 0.0f, 0.25f);
        COLOR_TEXT_CHECKBOX_FALSE = new Color(0.8f, 0.137f, 0.0f, 0.25f);
        COLOR_ECONOMY = new Color(0.776f, 0.518f, 0.227f, 1.0f);
        COLOR_ECONOMY_HOVER = new Color(0.708f, 0.448f, 0.173f, 1.0f);
        COLOR_ECONOMY_ACTIVE = new Color(0.552f, 0.36f, 0.141f, 1.0f);
        COLOR_TECHNOLOGY = new Color(0.8f, 0.8f, 0.8f, 1.0f);
        COLOR_TEXT_CIV_INFO = new Color(0.40392157f, 0.41960785f, 0.43137255f, 1.0f);
        COLOR_TEXT_CIV_INFO_HOVER = new Color(0.575f, 0.575f, 0.575f, 1.0f);
        COLOR_TEXT_CIV_INFO_ACTIVE = new Color(0.66f, 0.66f, 0.66f, 1.0f);
        COLOR_TEXT_CIV_INFO_TITLE = new Color(0.6862745f, 0.6862745f, 0.6862745f, 1.0f);
        COLOR_TEXT_TOP_VIEWS = new Color(0.37254903f, 0.37254903f, 0.37254903f, 1.0f);
        COLOR_TEXT_TOP_VIEWS_HOVER = new Color(0.44705883f, 0.4509804f, 0.45490196f, 1.0f);
        COLOR_TEXT_TOP_VIEWS_ACTIVE = new Color(0.85490197f, 0.7490196f, 0.36862746f, 1.0f);
        COLOR_TEXT_TOP_VIEWS_NOT_CLICKABLE = new Color(0.18431373f, 0.19215687f, 0.20784314f, 0.7f);
        COLOR_COLOR_PICKER_RGB_BG = new Color(0.047058824f, 0.0627451f, 0.078431375f, 0.55f);
        COLOR_LOADING_SPLIT_ACTIVE = new Color(0.96862745f, 0.76862746f, 0.41960785f, 0.65f);
        COLOR_LOADING_SPLIT = new Color(0.77254903f, 0.6117647f, 0.2627451f, 0.35f);
        COLOR_NEW_GAME_EDGE_LINE = new Color(0.1882353f, 0.18431373f, 0.16862746f, 1.0f);
        COLOR_FLAG_FRAME = new Color(0.1882353f, 0.18431373f, 0.16862746f, 1.0f);
        COLOR_NEW_GAME_EDGE_LINE2 = new Color(0.3882353f, 0.34117648f, 0.19607843f, 1.0f);
        COLOR_TEXT_CIV_NAME = new Color(0.985f, 0.985f, 0.985f, 1.0f);
        COLOR_TEXT_CIV_NAME_HOVERED = new Color(0.784f, 0.784f, 0.784f, 1.0f);
        COLOR_TEXT_CIV_NAME_ACTIVE = new Color(0.725f, 0.725f, 0.725f, 1.0f);
        COLOR_TEXT_RANK = new Color(0.819f, 0.819f, 0.819f, 1.0f);
        COLOR_TEXT_RANK_HOVER = new Color(0.628f, 0.628f, 0.645f, 1.0f);
        COLOR_TEXT_RANK_ACTIVE = new Color(0.584f, 0.584f, 0.599f, 1.0f);
        COLOR_SLIDER_LEFT_BG = new Color(0.11764706f, 0.13725491f, 0.23529412f, 1.0f);
        COLOR_SLIDER_RIGHT_BG = new Color(0.98039216f, 0.98039216f, 0.98039216f, 1.0f);
        COLOR_SLIDER_LEFT_BG2 = new Color(0.078431375f, 0.23529412f, 0.039215688f, 1.0f);
        COLOR_SLIDER_LEFT_BG3 = new Color(0.29411766f, 0.09803922f, 0.13725491f, 1.0f);
        COLOR_SLIDER_LEFT_INSTANTLY = new Color(0.09803922f, 0.23529412f, 0.15686275f, 1.0f);
        COLOR_CREATE_NEW_GAME_BOX_PLAYERS = new Color(0.4509804f, 0.32941177f, 0.10980392f, 1.0f);
        COLOR_GRADIENT_DARK_BLUE = new Color(0.05490196f, 0.07058824f, 0.10980392f, 0.75f);
        COLOR_GRADIENT_LIGHTER_DARK_BLUE = new Color(0.043137256f, 0.101960786f, 0.15686275f, 0.75f);
        COLOR_GRADIENT_DIPLOMACY = new Color(0.13333334f, 0.18039216f, 0.25490198f, 0.75f);
        COLOR_NEGATIVE_1 = new Color(0.98039216f, 0.15686275f, 0.15686275f, 1.0f);
        COLOR_NEGATIVE_2 = new Color(0.7490196f, 0.18431373f, 0.14117648f, 1.0f);
        COLOR_NEGATIVE_HOVER = new Color(0.70980394f, 0.17254902f, 0.1254902f, 1.0f);
        COLOR_NEGATIVE_ACTIVE = new Color(0.6509804f, 0.14117648f, 0.09411765f, 1.0f);
        COLOR_NEUTRAL = new Color(0.8f, 0.8f, 0.8f, 1.0f);
        COLOR_NEUTRAL2 = new Color(0.8627451f, 0.78431374f, 0.27450982f, 1.0f);
        COLOR_POSITIVE = new Color(0.007843138f, 0.5176471f, 0.011764706f, 1.0f);
        COLOR_POSITIVE_HOVER = new Color(0.003921569f, 0.4509804f, 0.007843138f, 1.0f);
        COLOR_POSITIVE_ACTIVE = new Color(0.003921569f, 0.4f, 0.007843138f, 1.0f);
        COLOR_POSITIVE_BUILT = new Color(0.13333334f, 0.54509807f, 0.13333334f, 1.0f);
        COLOR_FREE_MOVE = new Color(0.8980392f, 0.9254902f, 0.02745098f, 1.0f);
        COLOR_FREE_MOVE_ACTIVE = new Color(0.6745098f, 0.68235296f, 0.007843138f, 1.0f);
        COLOR_FREE_MOVE_HOVER = new Color(0.7607843f, 0.7764706f, 0.015686275f, 1.0f);
        COLOR_PROVINCE_VALUE = new Color(0.784f, 0.588f, 0.196f, 1.0f);
        COLOR_PROVINCE_VALUE_HOVER = new Color(0.668f, 0.473f, 0.152f, 1.0f);
        COLOR_PROVINCE_VALUE_ACTIVE = new Color(0.605f, 0.414f, 0.132f, 1.0f);
        COLOR_TEXT_GREEN = new Color(0.173f, 0.671f, 0.196f, 1.0f);
        COLOR_TEXT_CNG_TOP_SCENARIO_NAME = new Color(0.9f, 0.9f, 0.9f, 1.0f);
        COLOR_TEXT_CNG_TOP_SCENARIO_NAME_HOVER = new Color(0.78f, 0.78f, 0.78f, 1.0f);
        COLOR_TEXT_CNG_TOP_SCENARIO_INFO = new Color(0.56f, 0.56f, 0.56f, 1.0f);
        COLOR_TEXT_GRAY_NS = new Color(0.7372549f, 0.7490196f, 0.7647059f, 1.0f);
        COLOR_TEXT_GRAY_NS_HOVER = new Color(0.57254905f, 0.58431375f, 0.5921569f, 1.0f);
        COLOR_TEXT_GRAY_NS_ACTIVE = new Color(0.5019608f, 0.5137255f, 0.5294118f, 1.0f);
        COLOR_TEXT_GRAY_LEFT_NS = new Color(0.8392157f, 0.8392157f, 0.8392157f, 1.0f);
        COLOR_TEXT_GRAY_LEFT_NS_HOVER = new Color(0.7137255f, 0.7137255f, 0.7137255f, 1.0f);
        COLOR_TEXT_GRAY_LEFT_NS_ACTIVE = new Color(0.6509804f, 0.6509804f, 0.6509804f, 1.0f);
        COLOR_STARTINGMONEY_MIN = new Color(0.6f, 0.20392157f, 0.023529412f, 1.0f);
        COLOR_STARTINGMONEY_0 = new Color(0.84705883f, 0.9411765f, 0.6509804f, 1.0f);
        COLOR_STARTINGMONEY_MAX = new Color(0.1254902f, 0.5254902f, 0.27058825f, 1.0f);
        COLOR_BUTTON_MENU_HOVER_BG = new Color(1.0f, 1.0f, 1.0f, 0.9f);
        COLOR_BUTTON_MENU_ACTIVE_BG = new Color(1.0f, 1.0f, 1.0f, 0.8f);
        COLOR_BUTTON_MENU_TEXT = new Color(0.82f, 0.82f, 0.82f, 1.0f);
        COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE = new Color(0.78f, 0.78f, 0.78f, 0.4f);
        COLOR_BUTTON_MENU_TEXT_HOVERED = new Color(0.71f, 0.715f, 0.72f, 1.0f);
        COLOR_BUTTON_MENU_TEXT_ACTIVE = new Color(0.1f, 0.1f, 0.1f, 1.0f);
        COLOR_BUTTON_GAME_TEXT = new Color(0.376f, 0.388f, 0.376f, 1.0f);
        COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE = new Color(0.674f, 0.09f, 0.066f, 0.5f);
        COLOR_BUTTON_GAME_TEXT_ACTIVE = new Color(0.941f, 1.0f, 0.0f, 1.0f);
        COLOR_HOVER_TITLE = new Color(0.768f, 0.608f, 0.263f, 1.0f);
        COLOR_BUTTON_GAME_TEXT_HOVERED = new Color(0.445f, 0.445f, 0.445f, 1.0f);
        COLOR_BTN_M = new Color(0.38f, 0.38f, 0.38f, 1.0f);
        COLOR_BTN_M_NOT_CLICKABLE = new Color(0.49f, 0.49f, 0.49f, 0.5f);
        COLOR_BUTTON_GAME_TEXT_IMPORTANT = new Color(0.548f, 0.562f, 0.548f, 1.0f);
        COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER = new Color(0.665f, 0.682f, 0.665f, 1.0f);
        COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE = new Color(0.78f, 0.78f, 0.78f, 1.0f);
        COLOR_TEXT_NUM_OF_PROVINCES = new Color(0.8039216f, 0.59607846f, 0.0f, 1.0f);
        COLOR_TEXT_GOLDEN_AGE = new Color(0.9882353f, 0.8117647f, 0.2509804f, 1.0f);
        COLOR_GRADIENT_BLUE = new Color(0.14117648f, 0.1882353f, 0.27450982f, 0.775f);
        COLOR_MESSAGE_TITLE = new Color(0.2f, 0.6f, 0.4f, 0.775f);
        COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE = new Color(0.0f, 0.21960784f, 0.61960787f, 0.775f);
        COLOR_GRADIENT_MENU_BLUE = new Color(0.03529412f, 0.050980393f, 0.12941177f, 0.85f);
        reverseDirectionX = true;
        reverseDirectionY = true;
        DIFFICULTY = 1;
        FOG_OF_WAR = 1;
        FILL_THE_MAP = true;
        RANDOM_PLACEMENT = false;
        RANDOM_FILL = false;
        SANDBOX_MODE = false;
        SANDBOX_MODE_AI = false;
        PXSX = false;
        SPECTATOR_MODE = false;
        SPECTATOR_MODE_LOCK_CIV = false;
        SPECTATOR_MODE_DECLARE_WAR_MODE = -1;
        SPECTATOR_MODE_DIPLOMACY_ACTIONS_MODE = false;
        MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI = false;
        RECRUIT_AND_COUNTERATTACK = false;
        SAVED_GAME_LOADED = false;
        SAVED_GAME_LOADED_2 = false;
        TOTAL_WARMODE = false;
        AGE_OF_CHAOS_MODE = false;
        AGE_OF_CHAOS_TURNS = 50;
        AGE_OF_CHAOS_CIVS = 4;
        ENABLE_NUKES = true;
        LEADERS_CAN_DIE = false;
        USE_NEW_DECLARE_WAR_SYSTEM = true;
        USE_OLD_DECLARE_WAR_CHANGE_100 = 0;
        MAX_PROVINCES_FOR_ALLIANCE_PROPOSAL = 20;
        PROPOSE_ALLIANCE_CHANCE_100 = 62;
        ARMY_RETREAT = 0.0f;
        CAPITULATION = 0.26f;
        GET_SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_CHANCE_1000 = 58;
        COLONIZATION_AUTO_EXPAND_CHANCE = 100;
        NUKES_MIN_YEAR_ENABLED = true;
        WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS = 4;
        AI_UNIONS_ENABLED = false;
        AI_CONQUER_VASSALS = false;
        AI_VASSALS_CAN_DECLARE_WARS = false;
        AI_CONQUER_OWN_VASSALS_IF_OVER = 50;
        MOVEMENT_POINTS_EXTRA = 0;
        MOVEMENT_POINTS_MAX_MODIFIER = 1.5f;
        DIPLOMACY_POINTS_EXTRA = 0;
        TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE = 100;
        TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK = 110;
        ASSIMILATION_SPEED_MODIFIER = 1.0f;
        POPULATION_GROWTH_RATE = 1.0f;
        ECONOMY_GROWTH_RATE = 1.0f;
        PEACE_TREATY_VICTORY_POINTS_MODIFIER = 1.0f;
        BUILD_NUKES_EXTRA_COST = 0;
        NUKES_REQUIRED_TECH_LVL = 0.75f;
        PLUNDER_MODIFIER = 1.0f;
        AI_PLUNDER_ENABLED = true;
        PLUNDER_CHANCE = 0.0f;
        GENOCIDE_CHANCE = 0.0f;
        AI_GENOCIDE_ENABLED = true;
        VASSALS_CAN_DECLARE_INDEPENDENCE = true;
        ASSIMILATION_COST_MODIFIER = 1.0f;
        AGE_OF_CHAOS_CIVS_LIST = new ArrayList<Integer>();
        REBELS_POWER = 1.5f;
        MIN_ARMY_REQUIRED_TO_ATTACK = 19;
        RANDOM_CIVILIZATION_COLOR = new Color(0.03f, 0.03f, 0.05f, 1.0f);
        PLAYER_TURN_ID = 0;
        regroupArmyMode = false;
        chosenProvinces_Regroup = new ArrayList<Integer>();
        chooseProvinceMode = false;
        chosenProvinceID = -1;
        migrateMode = false;
        chooseProvinceMode_BEFORE = false;
        activeProvince_BEFORE = -1;
        activeCivilizationArmyID = 0;
        VIEW_SHOW_VALUES = true;
        SCENARIO_EDITOR_OCCUPATION = false;
        SHOW_ALL_MOVES = false;
        SHOW_ONLY_COMBAT_MOVES = true;
        RANDOM_CIVILIZATION = null;
        topBox = new TopBox();
        sLoading = "Loading";
        sVERSION = "Version";
        sAUTHOR = null;
        oR = new Random();
        sLoadingText = "";
        iLoadingTextWidth = 0;
        loadingTime = 0L;
        LOADING_TEXT_FONT_SCALE = 0.7f;
        iDXW = 0;
        activeCivInfoId = 0;
        activeCivFlag = null;
        activeCivLeader = new ArrayList<Image>();
        leaderFrameID = 0;
        leaderFrameSize = 0;
        leaderTime = 0L;
        leaderFrame = 50L;
        loadedLeader = "";
        CIV_INFO_MENU_WIDTH = 320;
        pNCI = new ArrayList<Integer>();
        pNC = new ArrayList<String>();
        cNCI = new ArrayList<Integer>();
        cNC = new ArrayList<String>();
        province_CoresGD = null;
        formableCivs_GameData = null;
        leaderGameData = null;
        editorLine_GameData = null;
        editor_Region_GameData = null;
        editor_Continent_GameData = null;
        EDITOR_ACTIVE_GAMEDATA_TAG = null;
        GO_TO_LINK = "";
        editor_Package_ContinentsData = null;
        editor_Package_RegionsData = null;
        CREATE_PACKAGE_CONTINENT_GAME_DATA_TAG = null;
        COLOR_BUTTON_EXTRA_DESCRIPTION = new Color(1.0f, 1.0f, 1.0f, 0.4f);
        COLOR_GROWTH_RATE = new Color[]{new Color(1.0f, 0.9764706f, 0.64705884f, 0.5f), new Color(0.99607843f, 0.9607843f, 0.0f, 0.5f), new Color(0.99607843f, 0.8901961f, 0.0f, 0.5f), new Color(0.99607843f, 0.7490196f, 0.0f, 0.5f), new Color(0.99607843f, 0.60784316f, 0.0f, 0.5f), new Color(0.99607843f, 0.42352942f, 0.0f, 0.5f), new Color(0.99607843f, 0.23529412f, 0.0f, 0.5f), new Color(0.8627451f, 0.0f, 0.0f, 0.5f), new Color(0.54901963f, 0.0f, 0.0f, 0.5f), new Color(0.39215687f, 0.0f, 0.0f, 0.5f), new Color(0.3137255f, 0.0f, 0.0f, 0.5f)};
        COLOR_PROVINCE_ARMY_MIN = new Color(0.7058824f, 0.7058824f, 0.78431374f, 0.575f);
        COLOR_PROVINCE_ARMY_MAX = new Color(0.96862745f, 0.9372549f, 0.39215687f, 0.575f);
        MAX_PROVINCE_VALUE = 10;
        COLOR_ECONOMY_GRADIENT = new Color[]{new Color(1.0f, 0.92156863f, 0.8f, 0.5f), new Color(1.0f, 0.83137256f, 0.65882355f, 0.5f), new Color(1.0f, 0.77254903f, 0.56078434f, 0.5f), new Color(1.0f, 0.7294118f, 0.47843137f, 0.5f), new Color(1.0f, 0.63529414f, 0.3254902f, 0.5f), new Color(0.96862745f, 0.54509807f, 0.19215687f, 0.5f), new Color(0.9411765f, 0.4627451f, 0.019607844f, 0.5f), new Color(0.88235295f, 0.3882353f, 0.0627451f, 0.5f), new Color(0.7921569f, 0.24313726f, 0.02745098f, 0.5f), new Color(0.7137255f, 0.09803922f, 0.015686275f, 0.5f), new Color(0.654902f, 0.08627451f, 0.011764706f, 0.5f)};
        PROVINCE_ALPHA_TECHNOLOGY_LEVEL = 0.45f;
        COLOR_TECHNOLOGY_LEVEL = new Color[]{new Color(0.94509804f, 0.95686275f, 1.0f, PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.8784314f, 0.8784314f, 0.9647059f, PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.79607844f, 0.8039216f, 1.0f, PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.7019608f, 0.7137255f, 0.9019608f, PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.6117647f, 0.627451f, 0.9411765f, PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.49803922f, 0.5176471f, 0.9529412f, PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.34901962f, 0.38039216f, 0.9019608f, PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.21960784f, 0.2509804f, 0.8509804f, PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.07450981f, 0.101960786f, 0.5803922f, PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.05490196f, 0.08235294f, 0.52156866f, PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.043137256f, 0.07058824f, 0.43137255f, PROVINCE_ALPHA_TECHNOLOGY_LEVEL)};
        for (int i = 0; i <= 100; ++i) {
            POP_COLORS_CACHE[i] = getPopulationColor(i, 0.5f);
            ECON_COLORS_CACHE[i] = getEconomyColor(i, 0.5f);
            TECH_COLORS_CACHE[i] = getTechnologyLevelColor(i, PROVINCE_ALPHA_TECHNOLOGY_LEVEL);
            GROWTH_COLORS_CACHE[i] = getGrowthRateColor(i, 0.5f);
        }
        iLOAH = 0;
        loaTM = 0L;
        sLOATXT = "";
        iLOADW = 0;
        PRT = 0L;
        ALPHA_DIPLOMACY = 0.35f;
        COLOR_SLIDER_BORDER = new Color(0.42745098f, 0.32941177f, 0.14901961f, 1.0f);
        COLOR_PORT_m1 = new Color(0.9607843f, 0.9607843f, 0.9607843f, 0.25f);
        COLOR_PORT_0 = new Color(0.7607843f, 0.7647059f, 0.8039216f, 0.25f);
        COLOR_PORT_1 = new Color(0.0f, 0.27450982f, 0.50980395f, 0.55f);
        COLOR_FORT_1 = new Color(0.972549f, 0.63529414f, 0.3372549f, 0.55f);
        COLOR_FORT_2 = new Color(0.9490196f, 0.52156866f, 0.14117648f, 0.55f);
        COLOR_WATCH_TOWER = new Color(0.11764706f, 0.21176471f, 0.3372549f, 0.55f);
        COLOR_FARM = new Color(0.11764706f, 0.3529412f, 0.21960784f, 0.55f);
        COLOR_FARM1 = new Color(0.5647059f, 0.93333334f, 0.5647059f, 0.55f);
        COLOR_FARM2 = new Color(0.39215687f, 0.78431374f, 0.47058824f, 0.55f);
        COLOR_FARM3 = new Color(0.23529412f, 0.7019608f, 0.44313726f, 0.55f);
        COLOR_FARM4 = new Color(0.18039216f, 0.54509807f, 0.34117648f, 0.55f);
        COLOR_FARM5 = new Color(0.11764706f, 0.3529412f, 0.21960784f, 0.55f);
        COLOR_IN_CONSTRUCTION = new Color(1.0f, 0.7490196f, 0.0f, 0.55f);
        COLOR_LIBRARY = new Color(0.0f, 0.2f, 0.4f, 0.55f);
        COLOR_LIBRARY1 = new Color(0.6784314f, 0.84705883f, 0.9019608f, 0.55f);
        COLOR_LIBRARY2 = new Color(0.39215687f, 0.58431375f, 0.92941177f, 0.55f);
        COLOR_LIBRARY3 = new Color(0.25490198f, 0.4117647f, 0.88235295f, 0.55f);
        COLOR_LIBRARY4 = new Color(0.0f, 0.29803923f, 0.6f, 0.55f);
        COLOR_LIBRARY5 = new Color(0.0f, 0.2f, 0.4f, 0.55f);
        COLOR_MARKET = new Color(0.27450982f, 0.50980395f, 0.7058824f, 0.55f);
        COLOR_MARKET1 = new Color(0.6901961f, 0.8784314f, 0.9019608f, 0.55f);
        COLOR_MARKET2 = new Color(0.5294118f, 0.80784315f, 0.92156863f, 0.55f);
        COLOR_MARKET3 = new Color(0.39215687f, 0.58431375f, 0.92941177f, 0.55f);
        COLOR_MARKET4 = new Color(0.27450982f, 0.50980395f, 0.7058824f, 0.55f);
        COLOR_MARKET5 = new Color(0.09803922f, 0.09803922f, 0.4392157f, 0.55f);
        COLOR_NUKE = new Color(0.7490196f, 0.18431373f, 0.14117648f, 0.55f);
        COLOR_SUPPLY = new Color(0.41960785f, 0.5568628f, 0.13725491f, 0.55f);
        COLOR_WORKSHOP = new Color(0.4392157f, 0.5019608f, 0.5647059f, 0.55f);
        COLOR_WORKSHOP1 = new Color(0.7529412f, 0.7529412f, 0.7529412f, 0.55f);
        COLOR_WORKSHOP2 = new Color(0.6627451f, 0.6627451f, 0.6627451f, 0.55f);
        COLOR_WORKSHOP3 = new Color(0.4392157f, 0.5019608f, 0.5647059f, 0.55f);
        COLOR_WORKSHOP4 = new Color(0.27450982f, 0.27450982f, 0.27450982f, 0.55f);
        COLOR_WORKSHOP5 = new Color(0.18431373f, 0.30980393f, 0.30980393f, 0.55f);
        COLOR_ARMOURY = new Color(0.6f, 0.0f, 0.0f, 0.55f);
        COLOR_BUILT = new Color(0.2f, 0.4f, 0.8f, 0.45f);
        COLOR_WONDERS = new Color(0.0f, 0.5019608f, 0.2509804f, 0.55f);
        COLOR_WAR_DARK = new Color(0.47058824f, 0.0f, 0.0f, 0.55f);
        COLOR_WAR_BRIGHT = new Color(0.8627451f, 0.078431375f, 0.23529412f, 0.55f);
        COLOR_SANCTIONS = new Color(0.81960785f, 0.36078432f, 0.36078432f, 0.55f);
        COLOR_FORTIFICATIONS_0 = new Color(0.9019608f, 0.9019608f, 0.9019608f, 0.45f);
        COLOR_FORTIFICATIONS_1 = new Color(0.13725491f, 0.5882353f, 0.11764706f, 0.6f);
        COLOR_FORTIFICATIONS_1_MOUNTAINS = new Color(0.105882354f, 0.43137255f, 0.09019608f, 0.6f);
        PROVINCE_BORDER_THICKNESS = 1;
        PROVINCE_BORDER_DASHED_THICKNESS = 1;
        COLOR_PROVINCE_BORDER_CIV_REGION = new Color(0.9411765f, 0.7529412f, 0.15294118f, 1.0f);
        COLOR_PROVINCE_DASHED = new Color(0.04f, 0.04f, 0.04f, 0.64705884f);
        COLOR_PROVINCE_SEABYSEA = new Color(0.94f, 0.94f, 0.95f, 0.07f);
        COLOR_PROVINCE_STRAIGHT = new Color(0.0f, 0.0f, 0.0f, 1.0f);
        COLOR_PROVINCE_STRAIGHT2 = new Color(0.0f, 0.0f, 0.0f, 0.3f);
        COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER = new Color(1.0f, 0.91764706f, 0.015686275f, 1.0f);
        backToMenu = View.eMAINMENU;
        goToMenu = View.eMAINMENU;
        goToMenu2 = View.eMAINMENU;
        CREATE_SCENARIO_GAME_DATA_TAG = null;
        CREATE_SCENARIO_IS_PART_OF_CAMPAIGN = false;
        lCREATE_SCENARIO_IS_PART_OF_CAMPAIGN_CIVSIDS = new ArrayList<Integer>();
        CREATE_SCENARIO_NAME = "";
        CREATE_SCENARIO_AUTHOR = "";
        CREATE_SCENARIO_WIKI = "";
        CREATE_SCENARIO_AGE = 0;
        createScenarioAssignProvsCiv = -1;
        RELOAD_SCENARIO = false;
        chosenAlphabetCharachter = null;
        sSearch = null;
        bSetWasteland_AvailableProvinces = true;
        iNumOfAvailableProvinces = 0;
        iNumOfAvailableProvincesWidth = 0;
        iNumOfWastelandProvinces = 0;
        iNumOfWastelandProvincesWidth = 0;
        flagOfCivilizationH = new ArrayList<Image>();
        MANAGE_DIPLOMACY_DRAW_HELP_LINE = true;
        MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = 1;
        MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = 1;
        MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2 = 0;
        MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
        MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
        sAtWar = null;
        reportData = null;
        flagManager = new FlagManager();
        randomGameManager = null;
        timelapseManager = new TimelapseManager();
        tutorialManager = new TutorialManager();
        peaceTreatyData = new PeaceTreaty_Data();
        hreMgr = null;
        unionFlagsToGenerate_Manager = new UnionFlagsToGenerate_Manager();
        createVassalData = null;
        tradeRequest = new TradeRequest_GameData();
        ultimatum = new Ultimatum_GameData();
        brushMode = false;
        selectMode = true;
        COLOR_CITY_NAME = new Color(0.9137255f, 0.9137255f, 0.9137255f, 0.85f);
        glyphLay = new GlyphLayout();
          glyphLayoutMoveUnits2 = new GlyphLayout();
        glyphLayoutMoveUnits = new GlyphLayout();
        glyphLayoutArmy = new GlyphLayout();
        fontMain = new ArrayList<BitmapFont>();
        fontArmy = null;
        fontBorder = null;
        fontBorder2 = null;
        lRBF = false;
        ARMY_HEIGHT = 1;
        TEXT_HEIGHT_DEFAULT = 1;
        TEXT_HEIGHT_DEFAULT_SMALL = 1;
        iProvinceNameWidth = -1;
        COLOR_ARMYBG = new Color(0.0f, 0.0f, 0.0f, 0.8f);
        COLOR_ARMY_CAPITAL_BG = new Color(0.0f, 0.0f, 0.0f, 1.0f);
        COLOR_ARMY_BG_ACTIVE = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        COLOR_ARMY_BG_SEA = new Color(0.05490196f, 0.1254902f, 0.23529412f, 1.0f);
        COLOR_ARMY_BG_ALLIANCE = new Color(0.019607844f, 0.09803922f, 0.1764706f, 1.0f);
        COLOR_ARMY_TEXT_ALLIANCE = new Color(0.98039216f, 0.99607843f, 0.99607843f, 1.0f);
        COLOR_ARMY_BG_VASSAL = new Color(0.078431375f, 0.23529412f, 0.10980392f, 1.0f);
        COLOR_ARMY_BG_MOVEUNITS = new Color(0.129f, 0.078f, 0.063f, 0.9f);
        COLOR_ARMY_TEXT = new Color(0.88235295f, 0.88235295f, 0.27450982f, 1.0f);
        COLOR_ARMY_TEXT_ACTIVE = new Color(0.12156863f, 0.12156863f, 0.12156863f, 1.0f);
        COLOR_ARMY_TEXT_ACTIVE_NON_PLAYER = new Color(0.88235295f, 0.88235295f, 0.27450982f, 1.0f);
        COLOR_ARMY_TEXT_CAPITAL_ACTIVE = new Color(0.99215686f, 0.99607843f, 0.99607843f, 1.0f);
        COLOR_ARMY_TEXT_SEA = new Color(0.8235294f, 0.8235294f, 0.8235294f, 1.0f);
        COLOR_ARMY_TEXT_SEA_ACTIVE = new Color(0.5294118f, 0.54901963f, 0.5686275f, 1.0f);
        COLOR_GOLD = new Color(0.87058824f, 0.85882354f, 0.12941177f, 1.0f);
        COLOR_GOLD_HOVER = new Color(0.75686276f, 0.75686276f, 0.0f, 1.0f);
        COLOR_GOLD_ACTIVE = new Color(0.6901961f, 0.6901961f, 0.0f, 1.0f);
        COLOR_MOVEMENT = new Color(0.25882354f, 0.68235296f, 0.9019608f, 1.0f);
        COLOR_MOVEMENT_HOVER = new Color(0.2f, 0.6f, 0.8f, 1.0f);
        COLOR_MOVEMENT_ACTIVE = new Color(0.16862746f, 0.5411765f, 0.69803923f, 1.0f);
        COLOR_MOVEMENT_ZERO = new Color(0.7490196f, 0.18431373f, 0.14117648f, 1.0f);
        COLOR_MOVEMENT_ZERO_HOVER = new Color(0.6431373f, 0.10980392f, 0.08235294f, 1.0f);
        COLOR_MOVEMENT_ZERO_ACTIVE = new Color(0.56078434f, 0.06666667f, 0.050980393f, 1.0f);
        COLOR_DIPLOMACY_POINTS = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        COLOR_DIPLOMACY_POINTS_HOVER = new Color(0.7882353f, 0.7882353f, 0.8f, 1.0f);
        COLOR_DIPLOMACY_POINTS_ACTIVE = new Color(0.7529412f, 0.7529412f, 0.7529412f, 1.0f);
        COLOR_BG_GAME_MENU_SHADOW = new Color(0.0f, 0.0f, 0.0f, 0.65f);
        keybMess = "";
        CIV_FLAG_WIDTH = 27;
        CIV_FLAG_HEIGHT = 18;
        FLIP_Y_CIV_FLAG = false;
        FLIP_Y_CIV_FLAG_COUNTER = 0;
        flagEditorMode = FlagEditorMode.PENCIL;
        COLOR_BOX_GRADIENT = new Color(0.14901961f, 0.17254902f, 0.23529412f, 1.0f);
        jsi = sJakowski;
        iAgeOfCivilizationsWidth = -1;
        append = false;
        appendNum = 0;
        jsig = sJakowskiGames;
        randomProvinceNames = new ArrayList<String>();
        numGold = 1;
        numSilver = 1;
        numBronze = 1;
        dialogType = DialogType.EXIT_GAME;
        iSelectCivilizationPlayerID = 0;
        editorAlliancesNames_GameData = null;
        EDIT_ALLIANCE_NAMES_BUNDLE_ID = 0;
        CREATE_PACKAGE_ALLIANCE_NAMES_GAME_DATA_TAG = null;
        achievementGD = null;
        loadedRobotoFont = true;
        SERVICE_RIBBON_WIDTH = 58;
        SERVICE_RIBBON_HEIGHT = 16;
        jsiw = sJakowski_2;
        jsigw = sJakowskiGames_2;
    }

    public static interface Keyboard_Action {
        public void action();
    }

    public static interface Keyboard_Action_Write {
        public void action(String var1);
    }

    public static class ConfigAlliancesData {
        public String Age_of_Civilizations;
        public ArrayList Data_Random_Alliance_Names;
    }

    public static class Data_Random_Alliance_Names {
        public String Tag;
        public boolean Enabled;
    }

    public static class TopBox {
        public int iFlagX;
        public int iFlagY;
        public int iCircleShift;
        public int iCircleShiftY;
        public int topBarPaddingRight;
        public int topFlagBGPaddingButtons;
        public int leftExtraViewPadding;
    }

    public static enum FlagEditorMode {
        PENCIL,
        PAINT_BUCKET;

    }

    public static class Data_Scenario_Info {
        public String Name;
        public String Author;
        public String Wiki;
        public int Civs;
        public int Age;
        public int Year;
        public int Month;
        public int Day;
    }

    public static class ConfigScenarioInfo {
        public String Age_of_Civilizations;
        public ArrayList Data_Scenario_Info;
    }
}


