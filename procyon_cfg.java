// 
// Decompiled by Procyon v0.6.0
// 

package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;
import age.of.civilizations2.jakowski.lukasz.AI.FrontLine.AI_Frontline;
import java.util.Iterator;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.MapA.Challenge.ChallengesManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Challenge.Challenge;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.Menus.Wars.Details.Menu_InGame_WarDetails;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Menu_InGame_AbandonProvince;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_Union;
import age.of.civilizations2.jakowski.lukasz.Menus.Vassal.Menu_InGame_Tribute;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayOutputStream;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Application;
import java.util.ArrayList;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import com.badlogic.gdx.files.FileHandle;
import java.io.IOException;
import age.of.civilizations2.jakowski.lukasz.Save.SaveActiveMap_GameData;
import com.badlogic.gdx.utils.GdxRuntimeException;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import com.badlogic.gdx.Gdx;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import java.io.ObjectInputStream;
import java.io.ByteArrayInputStream;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_FlagPixel_Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import age.of.civilizations2.jakowski.lukasz.MapA.Plagues.PlagueManager;
import age.of.civilizations2.jakowski.lukasz.AI.AI;
import age.of.civilizations2.jakowski.lukasz.Game.GameUpdate;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryManager;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_Data;
import age.of.civilizations2.jakowski.lukasz.Z_Other.TutorialManager;
import age.of.civilizations2.jakowski.lukasz.Timelapse.TimelapseManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Z_Other.Undo.Undo_AssignProvinceCiv;
import java.util.Random;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_CircleDraw;
import java.util.List;
import java.util.HashMap;
import age.of.civilizations2.jakowski.lukasz.Clouds.CloudsManager;
import age.of.civilizations2.jakowski.lukasz.Editor.EditorManager;
import com.badlogic.gdx.graphics.Color;

public class CFG
{
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
    public static int AGE_OF_CHAOS_TURNS;
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
    public static int BUILD_NUKES_EXTRA_COST;
    public static float NUKES_REQUIRED_TECH_LVL;
    public static float PLUNDER_MODIFIER;
    public static boolean AI_PLUNDER_ENABLED;
    public static boolean VASSALS_CAN_DECLARE_INDEPENDENCE;
    public static float ASSIMILATION_COST_MODIFIER;
    public static List<Integer> AGE_OF_CHAOS_CIVS_LIST;
    public static float REBELS_POWER;
    public static int MIN_ARMY_REQUIRED_TO_ATTACK;
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
    public static CFG.TopBox topBox;
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
    public static String KEY_TEMP_INPUT;
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
    public static GlyphLayout glyphLay;
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
    public static CFG.Keyboard_Action keyboardSave;
    public static CFG.Keyboard_Action keyboardDelete;
    public static CFG.Keyboard_Action_Write keyboardWrite;
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
    public static CFG.FlagEditorMode flagEditorMode;
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
    
    public static final Color getColorLine() {
        return CFG.colorLine;
    }
    
    public static boolean getLoadHighTextureMapOverlay() {
        return getIsDesktop() && GameValues.gvMapOverlays.LOAD_HIGH_QUALITY_OVERLAYS;
    }
    
    public static final void loadFormableCiv_GameData(final String s) {
        try {
            try {
                CFG.formableCivs_GameData = (FormableCivs_GameData)deserialize(Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + s).readBytes());
            }
            catch (final GdxRuntimeException ex) {
                CFG.formableCivs_GameData = (FormableCivs_GameData)deserialize(FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + s).readBytes());
            }
        }
        catch (final ClassNotFoundException ex2) {
            exceptionStack(ex2);
        }
        catch (final Exception ex3) {
            exceptionStack(ex3);
        }
    }
    
    public static final boolean doesNotExists_FormableCiv(final String s) {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (s.equals(CFG.core.getCiv(i).getCivTag())) {
                return false;
            }
        }
        return true;
    }
    
    public static final boolean ownAllProvinces_FormableCiv(final int n) {
        for (int i = 0; i < CFG.formableCivs_GameData.getProvincesSize(); ++i) {
            if (CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getWastelandLvl() < 0 && CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getCivId() != n) {
                return false;
            }
        }
        return true;
    }
    
    public static final int ownAllProvinces_FormableCiv_ControlsProvinces(final int n) {
        int n2 = 0;
        for (int i = 0; i < CFG.formableCivs_GameData.getProvincesSize(); ++i) {
            if (CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getWastelandLvl() < 0) {
                if (CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getCivId() == n) {
                    ++n2;
                }
            }
        }
        return n2;
    }
    
    public static final int ownAllProvinces_FormableCiv_NumOfProvinces(final int n) {
        int n2 = 0;
        for (int i = 0; i < CFG.formableCivs_GameData.getProvincesSize(); ++i) {
            if (CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getWastelandLvl() < 0) {
                ++n2;
            }
        }
        return n2;
    }
    
    public static final boolean isInFormableCivs(final String anObject) {
        if (CFG.formableCivs_GameData.getFormableCivTag() != null && CFG.formableCivs_GameData.getFormableCivTag().equals(anObject)) {
            return true;
        }
        for (int i = 0; i < CFG.formableCivs_GameData.getClaimantsSize(); ++i) {
            if (anObject.equals(CFG.formableCivs_GameData.getClaimant(i))) {
                return true;
            }
        }
        return false;
    }
    
    public static final boolean isInLeaderCivs(final String s) {
        for (int i = 0; i < CFG.leaderGameData.getCivsSize(); ++i) {
            if (s.equals(CFG.leaderGameData.getCiv(i))) {
                return true;
            }
        }
        return false;
    }
    
    public static final boolean readLocalFiles() {
        switch (CFG.CFG$83.$SwitchMap$com$badlogic$gdx$Application$ApplicationType[Gdx.app.getType().ordinal()]) {
            case 1:
            case 2: {
                return true;
            }
            case 3: {
                return false;
            }
            default: {
                return false;
            }
        }
    }
    
    public static final Color getPopulationColor(final int n, final float n2) {
        switch (n / 10) {
            case 0: {
                return getColorStep(CFG.COLOR_POP_GRADIENT[0], CFG.COLOR_POP_GRADIENT[1], n % 10, 10, n2);
            }
            case 1: {
                return getColorStep(CFG.COLOR_POP_GRADIENT[1], CFG.COLOR_POP_GRADIENT[2], n % 10, 10, n2);
            }
            case 2: {
                return getColorStep(CFG.COLOR_POP_GRADIENT[2], CFG.COLOR_POP_GRADIENT[3], n % 10, 10, n2);
            }
            case 3: {
                return getColorStep(CFG.COLOR_POP_GRADIENT[3], CFG.COLOR_POP_GRADIENT[4], n % 10, 10, n2);
            }
            case 4: {
                return getColorStep(CFG.COLOR_POP_GRADIENT[4], CFG.COLOR_POP_GRADIENT[5], n % 10, 10, n2);
            }
            case 5: {
                return getColorStep(CFG.COLOR_POP_GRADIENT[5], CFG.COLOR_POP_GRADIENT[6], n % 10, 10, n2);
            }
            case 6: {
                return getColorStep(CFG.COLOR_POP_GRADIENT[6], CFG.COLOR_POP_GRADIENT[7], n % 10, 10, n2);
            }
            case 7: {
                return getColorStep(CFG.COLOR_POP_GRADIENT[7], CFG.COLOR_POP_GRADIENT[8], n % 10, 10, n2);
            }
            case 8: {
                return getColorStep(CFG.COLOR_POP_GRADIENT[8], CFG.COLOR_POP_GRADIENT[9], n % 10, 10, n2);
            }
            case 9: {
                return getColorStep(CFG.COLOR_POP_GRADIENT[9], CFG.COLOR_POP_GRADIENT[10], n % 10, 10, n2);
            }
            case 10: {
                return new Color(CFG.COLOR_POP_GRADIENT[10].r, CFG.COLOR_POP_GRADIENT[10].g, CFG.COLOR_POP_GRADIENT[10].b, n2);
            }
            default: {
                return new Color(CFG.COLOR_POP_GRADIENT[10].r, CFG.COLOR_POP_GRADIENT[10].g, CFG.COLOR_POP_GRADIENT[10].b, n2);
            }
        }
    }
    
    public static Color getWarDeathsColor(final int n, final float n2) {
        switch (n / 10) {
            case 0: {
                return getColorStep(CFG.COLOR_WAR_DEATHS[0], CFG.COLOR_WAR_DEATHS[1], n % 10, 10, n2);
            }
            case 1: {
                return getColorStep(CFG.COLOR_WAR_DEATHS[1], CFG.COLOR_WAR_DEATHS[2], n % 10, 10, n2);
            }
            case 2: {
                return getColorStep(CFG.COLOR_WAR_DEATHS[2], CFG.COLOR_WAR_DEATHS[3], n % 10, 10, n2);
            }
            case 3: {
                return getColorStep(CFG.COLOR_WAR_DEATHS[3], CFG.COLOR_WAR_DEATHS[4], n % 10, 10, n2);
            }
            case 4: {
                return getColorStep(CFG.COLOR_WAR_DEATHS[4], CFG.COLOR_WAR_DEATHS[5], n % 10, 10, n2);
            }
            case 5: {
                return getColorStep(CFG.COLOR_WAR_DEATHS[5], CFG.COLOR_WAR_DEATHS[6], n % 10, 10, n2);
            }
            case 6: {
                return getColorStep(CFG.COLOR_WAR_DEATHS[6], CFG.COLOR_WAR_DEATHS[7], n % 10, 10, n2);
            }
            case 7: {
                return getColorStep(CFG.COLOR_WAR_DEATHS[7], CFG.COLOR_WAR_DEATHS[8], n % 10, 10, n2);
            }
            case 8: {
                return getColorStep(CFG.COLOR_WAR_DEATHS[8], CFG.COLOR_WAR_DEATHS[9], n % 10, 10, n2);
            }
            case 9: {
                return getColorStep(CFG.COLOR_WAR_DEATHS[9], CFG.COLOR_WAR_DEATHS[10], n % 10, 10, n2);
            }
            case 10: {
                return new Color(CFG.COLOR_WAR_DEATHS[10].r, CFG.COLOR_WAR_DEATHS[10].g, CFG.COLOR_WAR_DEATHS[10].b, n2);
            }
            default: {
                return new Color(CFG.COLOR_WAR_DEATHS[10].r, CFG.COLOR_WAR_DEATHS[10].g, CFG.COLOR_WAR_DEATHS[10].b, n2);
            }
        }
    }
    
    public static final Color getPopulationColorRed(final int n, final float n2) {
        switch (n / 10) {
            case 0: {
                return getColorStep(CFG.COLOR_POP_RED[0], CFG.COLOR_POP_RED[1], n % 10, 10, n2);
            }
            case 1: {
                return getColorStep(CFG.COLOR_POP_RED[1], CFG.COLOR_POP_RED[2], n % 10, 10, n2);
            }
            case 2: {
                return getColorStep(CFG.COLOR_POP_RED[2], CFG.COLOR_POP_RED[3], n % 10, 10, n2);
            }
            case 3: {
                return getColorStep(CFG.COLOR_POP_RED[3], CFG.COLOR_POP_RED[4], n % 10, 10, n2);
            }
            case 4: {
                return getColorStep(CFG.COLOR_POP_RED[4], CFG.COLOR_POP_RED[5], n % 10, 10, n2);
            }
            case 5: {
                return getColorStep(CFG.COLOR_POP_RED[5], CFG.COLOR_POP_RED[6], n % 10, 10, n2);
            }
            case 6: {
                return getColorStep(CFG.COLOR_POP_RED[6], CFG.COLOR_POP_RED[7], n % 10, 10, n2);
            }
            case 7: {
                return getColorStep(CFG.COLOR_POP_RED[7], CFG.COLOR_POP_RED[8], n % 10, 10, n2);
            }
            case 8: {
                return getColorStep(CFG.COLOR_POP_RED[8], CFG.COLOR_POP_RED[9], n % 10, 10, n2);
            }
            case 9: {
                return getColorStep(CFG.COLOR_POP_RED[9], CFG.COLOR_POP_RED[10], n % 10, 10, n2);
            }
            case 10: {
                return new Color(CFG.COLOR_POP_RED[10].r, CFG.COLOR_POP_RED[10].g, CFG.COLOR_POP_RED[10].b, n2);
            }
            default: {
                return new Color(CFG.COLOR_POP_RED[10].r, CFG.COLOR_POP_RED[10].g, CFG.COLOR_POP_RED[10].b, n2);
            }
        }
    }
    
    public static final void wikiInforLink(final String s) {
        try {
            try {
                Gdx.net.openURI("https://en.wikipedia.org/wiki/" + FileManager.loadFile("game/civilizations_informations/" + s).readString());
            }
            catch (final GdxRuntimeException ex) {
                Gdx.net.openURI("https://en.wikipedia.org/wiki/" + FileManager.loadFile("game/civilizations_informations/" + CFG.ideologiesMgr.getRealTag(s)).readString());
            }
        }
        catch (final GdxRuntimeException ex2) {
            CFG.toastM.addM(CFG.lang.get("NoData"));
        }
    }
    
    public static final String getwikiinforlink(final String s) {
        try {
            return "https://en.wikipedia.org/wiki/" + FileManager.loadFile("game/civilizations_informations/" + s).readString();
        }
        catch (final GdxRuntimeException ex) {
            try {
                return "https://en.wikipedia.org/wiki/" + FileManager.loadFile("game/civilizations_informations/" + CFG.ideologiesMgr.getRealTag(s)).readString();
            }
            catch (final GdxRuntimeException ex2) {
                return "/";
            }
        }
    }
    
    public static final String getResPath() {
        if (CFG.XXXHDPI) {
            return "interface/XXXH/";
        }
        if (CFG.XXHDPI) {
            return "interface/XXH/";
        }
        if (CFG.XHDPI) {
            return "interface/XH/";
        }
        return "interface/H/";
    }
    
    public static final String getResPathS() {
        if (CFG.XXXHDPI) {
            return "XXXH/";
        }
        if (CFG.XXHDPI) {
            return "XXH/";
        }
        if (CFG.XHDPI) {
            return "XH/";
        }
        return "H/";
    }
    
    public static final String getResPathSH() {
        return "H/";
    }
    
    public static final int getUIScale() {
        if (CFG.XXXHDPI) {
            return 3;
        }
        if (CFG.XXHDPI) {
            return 2;
        }
        if (CFG.XHDPI) {
            return 1;
        }
        return 0;
    }
    
    public static Point_XY2 getRandomPointToCenterTheMap() {
        return new Point_XY2(CFG.oR.nextInt(CFG.map.getMpB().getWidthM() / CFG.map.getMpB().getMapSc3()), CFG.oR.nextInt(CFG.map.getMpB().getHeightM() / CFG.map.getMpB().getMapSc3()));
    }
    
    public static Color getRandomColor() {
        return new Color(CFG.oR.nextInt(256) / 255.0f, CFG.oR.nextInt(256) / 255.0f, CFG.oR.nextInt(256) / 255.0f, 1.0f);
    }
    
    public static Color_GameData getRandomColorGameData() {
        return new Color_GameData(CFG.oR.nextInt(256) / 255.0f, CFG.oR.nextInt(256) / 255.0f, CFG.oR.nextInt(256) / 255.0f);
    }
    
    public static void setRenderO(final boolean b) {
    }
    
    public static boolean getMetProv(final int n) {
        try {
            return CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(n);
        }
        catch (final Exception ex) {
            return true;
        }
    }
    
    public static boolean getMetCiv(final int n) {
        try {
            return CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(n);
        }
        catch (final Exception ex) {
            return true;
        }
    }
    
    public static boolean getMetCiv_AllPlayers(final int n) {
        for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
            if (CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getNumOfProvs() > 0 && CFG.core.getPlayer(i).getMetCiv(n)) {
                return true;
            }
        }
        return false;
    }
    
    public static long getPROVINCE_BORDER_ANIMATION_TIME(final String key) {
        try {
            return CFG.PROVINCE_BORDER_ANIMATION_TIME.get(key);
        }
        catch (final Exception ex) {
            return 0L;
        }
    }
    
    public static final void saveSettings_ActiveMap() {
        try {
            final FileHandle fileHandle = FileManager.IS_MAC ? Gdx.files.external("settings/settings_mapAoH2DE") : Gdx.files.local("settings/settings_mapAoH2DE");
            final SaveActiveMap_GameData saveActiveMap_GameData = new SaveActiveMap_GameData();
            saveActiveMap_GameData.iActiveMapID = CFG.map.getActiveMapIDN();
            saveActiveMap_GameData.iActiveMapScale = CFG.map.getMapScale_PreExtra(CFG.map.getActiveMapIDN());
            fileHandle.writeBytes(serialize(saveActiveMap_GameData), false);
        }
        catch (final IOException ex) {
            if (CFG.LOGs) {
                exceptionStack(ex);
            }
        }
    }
    
    public static final void saveSettings_LoadingStatus() {
    }
    
    public static final void saveSettings() {
        try {
            if (getIsDesktop()) {
                final Json json = EventsJ.getJson();
                json.setTypeName("class");
                json.setUsePrototypes(false);
                json.setOutputType(JsonWriter.OutputType.javascript);
                (FileManager.IS_MAC ? Gdx.files.external("settings/settingsAoH2DE.txt") : Gdx.files.local("settings/settingsAoH2DE.txt")).writeString(json.prettyPrint((Object)CFG.settingsGD), false);
            }
        }
        catch (final Exception ex) {
            if (CFG.LOGs) {
                exceptionStack(ex);
            }
        }
        try {
            (FileManager.IS_MAC ? Gdx.files.external("settings/settingsAoH2DE") : Gdx.files.local("settings/settingsAoH2DE")).writeBytes(serialize(CFG.settingsGD), false);
        }
        catch (final IOException ex2) {
            if (CFG.LOGs) {
                exceptionStack(ex2);
            }
        }
    }
    
    public static final void loadSettings() {
        boolean b = false;
        try {
            final FileHandle loadFile;
            if (getIsDesktop() && (loadFile = FileManager.loadFile("settings/settingsAoH2DE.txt")).exists()) {
                CFG.settingsGD = (SettingsGD)EventsJ.getJson().fromJson((Class)SettingsGD.class, loadFile.readString());
                AoCGame.LEFT += CFG.settingsGD.MENU_EXTRA_LEFT;
                b = true;
            }
        }
        catch (final Exception ex) {
            exceptionStack(ex);
        }
        if (!b) {
            try {
                CFG.settingsGD = (SettingsGD)deserialize(FileManager.loadFile("settings/settingsAoH2DE").readBytes());
                AoCGame.LEFT += CFG.settingsGD.MENU_EXTRA_LEFT;
            }
            catch (final Exception ex2) {
                if (!getIsDesktop()) {
                    CFG.settingsGD.CAPITAL_FLAGS_HIGH = true;
                    CFG.settingsGD.SPROVN = 1;
                    CFG.settingsGD.ANDROID_LOAD_MAP_OVERLAYS = false;
                    CFG.settingsGD.CLOUDS = false;
                }
            }
        }
        try {
            CFG.COLOR_PROVINCE_STRAIGHT = new Color(CFG.settingsGD.borderStraight.getR(), CFG.settingsGD.borderStraight.getG(), CFG.settingsGD.borderStraight.getB(), CFG.COLOR_PROVINCE_STRAIGHT.a);
            CFG.COLOR_PROVINCE_DASHED = new Color(CFG.settingsGD.borderDashed.getR(), CFG.settingsGD.borderDashed.getG(), CFG.settingsGD.borderDashed.getB(), CFG.COLOR_PROVINCE_DASHED.a);
        }
        catch (final Exception ex3) {}
        final Core core = CFG.core;
        Core.updateDrawCapitalFlagMap();
    }
    
    public static Color getColor_CivInfo_Text(final boolean b, final boolean b2) {
        return b ? CFG.COLOR_TEXT_CIV_INFO_ACTIVE : (b2 ? CFG.COLOR_TEXT_CIV_INFO_HOVER : CFG.COLOR_TEXT_CIV_INFO);
    }
    
    public static Color getColor_CivInfo_InGame_Text(final boolean b, final boolean b2) {
        return b ? CFG.COLOR_TEXT_CIV_INFO_ACTIVE : (b2 ? CFG.COLOR_TEXT_CIV_INFO_HOVER : CFG.COLOR_NEUTRAL);
    }
    
    public static final String getWikiInforLinkClear(final String s) {
        try {
            return FileManager.loadFile("game/civilizations_informations/" + s).readString();
        }
        catch (final GdxRuntimeException ex) {
            try {
                return FileManager.loadFile("game/civilizations_informations/" + CFG.ideologiesMgr.getRealTag(s)).readString();
            }
            catch (final GdxRuntimeException ex2) {
                return CFG.lang.get("NoData");
            }
        }
    }
    
    public static final List<String> getFileNames_O(final String s) {
        final ArrayList list = new ArrayList();
        final FileHandle[] list2 = ((Gdx.app.getType() == Application.ApplicationType.Android) ? FileManager.loadFile(s) : FileManager.loadFile(s)).list();
        for (int length = list2.length, i = 0; i < length; ++i) {
            list.add(list2[i].name());
        }
        return list;
    }
    
    public static final List<String> getFileNames_O_Classic(final String s) {
        final ArrayList list = new ArrayList();
        final FileHandle[] list2 = (FileManager.IS_MAC ? Gdx.files.external(s) : ((Gdx.app.getType() == Application.ApplicationType.Android) ? Gdx.files.internal(s) : Gdx.files.internal(s))).list();
        for (int length = list2.length, i = 0; i < length; ++i) {
            list.add(list2[i].name());
        }
        return list;
    }
    
    protected static final List<String> getFileNames_Absolute(final String s) {
        final ArrayList list = new ArrayList();
        final FileHandle[] list2 = Gdx.files.absolute(s).list();
        for (int length = list2.length, i = 0; i < length; ++i) {
            list.add(list2[i].name());
        }
        return list;
    }
    
    public static final List<String> getFileNames2(final String s) {
        final ArrayList list = new ArrayList();
        if (Gdx.app.getType() != Application.ApplicationType.Android) {
            return list;
        }
        if (new ArrayList() == null) {
            return null;
        }
        final FileHandle[] list2 = FileManager.loadFile(s).list();
        for (int length = list2.length, i = 0; i < length; ++i) {
            list.add(list2[i].name());
        }
        final ArrayList<String> list3 = new ArrayList<String>();
        final FileHandle[] list4 = Gdx.files.local(s).list();
        for (int length2 = list4.length, j = 0; j < length2; ++j) {
            list3.add(list4[j].name());
        }
        if (list3.size() > list.size()) {
            return list3;
        }
        return list;
    }
    
    public static final int getFileNames_Length2(final String s) {
        return ((Gdx.app.getType() == Application.ApplicationType.Android) ? FileManager.loadFile(s) : FileManager.loadFile(s)).list().length;
    }
    
    public static final String getDifficultyName(final int n) {
        switch (n) {
            case 0: {
                return CFG.lang.get(GameValues.gvDifficulty.BEGINNER_NAME);
            }
            case 1: {
                return CFG.lang.get(GameValues.gvDifficulty.NORMAL_NAME);
            }
            case 2: {
                return CFG.lang.get(GameValues.gvDifficulty.HARD_NAME);
            }
            case 4: {
                return CFG.lang.get(GameValues.gvDifficulty.EXTREME_NAME);
            }
            default: {
                return CFG.lang.get(GameValues.gvDifficulty.LEGENDARY_NAME);
            }
        }
    }
    
    public static final String getFogOfWarName(final int n) {
        switch (n) {
            case 0: {
                return CFG.lang.get("Off");
            }
            case 2: {
                return CFG.lang.get("Discovery");
            }
            default: {
                return CFG.lang.get("Classic");
            }
        }
    }
    
    public static final boolean isInTheCivGameTag(final String s) {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (s.equals(CFG.core.getCiv(i).getCivTag())) {
                return true;
            }
        }
        return false;
    }
    
    public static final boolean isInTheGame_OrIsFormableCiv(final String s) {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (s.equals(CFG.core.getCiv(i).getCivTag())) {
                return true;
            }
        }
        for (int j = 1; j < CFG.core.getCivsSize(); ++j) {
            for (int k = 0; k < CFG.core.getCiv(j).getTagsCanFormCSize(); ++k) {
                if (s.equals(CFG.core.getCiv(j).getTagsCanFormC(k))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void addRemoveChosenProvinceRegroup(final int n) {
        if (!CFG.chosenProvinces_Regroup.contains(n)) {
            CFG.chosenProvinces_Regroup.add(n);
            return;
        }
        try {
            if (CFG.chosenProvinces_Regroup.size() < 2) {
                return;
            }
            for (int i = CFG.chosenProvinces_Regroup.size() - 1; i >= 0; --i) {
                if (CFG.chosenProvinces_Regroup.get(i) == n) {
                    CFG.chosenProvinces_Regroup.remove(i);
                    return;
                }
            }
        }
        catch (final Exception ex) {
            exceptionStack(ex);
        }
    }
    
    public static void addChosenProvinceRegroup(final int n) {
        if (!CFG.chosenProvinces_Regroup.contains(n)) {
            CFG.chosenProvinces_Regroup.add(n);
        }
    }
    
    public static void removeChosenProvinceRegroup(final int n) {
        try {
            for (int i = CFG.chosenProvinces_Regroup.size() - 1; i >= 0; --i) {
                if (CFG.chosenProvinces_Regroup.get(i) == n) {
                    CFG.chosenProvinces_Regroup.remove(i);
                    return;
                }
            }
        }
        catch (final Exception ex) {
            exceptionStack(ex);
        }
    }
    
    public static void clearChosenProvinceRegroup() {
        CFG.chosenProvinces_Regroup.clear();
    }
    
    public static final int getCostOfRecruitArmyMoney_Instantly(final int n) {
        return (int)(GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT * GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT_CONSCRIPT_EXTRA - ((CFG.core.getProv(n).getLvlOfArmoury() > 0) ? (GameValues.gvBuildingArmoury.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT_REDUCTION * CFG.core.getProv(n).getLvlOfArmoury()) : 0));
    }
    
    public static final int getCostOfRecruitArmyMoney_Mercenaries() {
        return (int)(GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT * GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT_MERCENARIES_EXTRA);
    }
    
    public static final void drawVersion_LEFT_BOT(final SpriteBatch spriteBatch, final int n) {
        Renderer.drawText(spriteBatch, CFG.FONT_REGULAR_SMALL, CFG.sVERSION + ": 2.01 Definitive Edition", CFG.PADD + n, CFG.GAMEHEIGHT - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL, new Color(1.0f, 1.0f, 1.0f, 0.25f));
    }
    
    public static final void drawJakowskiGames_RIGHT_BOT(final SpriteBatch spriteBatch, final int n) {
        Renderer.drawText(spriteBatch, CFG.FONT_REGULAR_SMALL, gLG(), CFG.GAMEWIDTH - CFG.PADD - CFG.iJGW + n, CFG.GAMEHEIGHT - CFG.TEXT_HEIGHT_DEFAULT_SMALL - CFG.PADD, new Color(1.0f, 1.0f, 1.0f, 0.25f));
    }
    
    public static final void drawJakowskiGames_RIGHT_BOT(final SpriteBatch spriteBatch, final int n, final float n2) {
        Renderer.drawText(spriteBatch, CFG.FONT_REGULAR_SMALL, gLG(), CFG.GAMEWIDTH - CFG.PADD - CFG.iJGW + n, CFG.GAMEHEIGHT - CFG.TEXT_HEIGHT_DEFAULT_SMALL - CFG.PADD, new Color(1.0f, 1.0f, 1.0f, 0.25f));
    }
    
    public static void drL0A(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4, final float n5) {
        drL0A(spriteBatch, n, n2, n3, n4, n5, "");
    }
    
    public static void drL0A(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4, float n5, final String s) {
        if (n5 > 1.0f) {
            n5 = 1.0f;
        }
        else if (n5 < 0.0f) {
            n5 = 0.0f;
        }
        if (System.currentTimeMillis() - 2500L > CFG.loaTM) {
            try {
                CFG.sLoadingText = CFG.lang.getLOA("L" + CFG.oR.nextInt(CFG.lang.iLNOT)) + "..";
                CFG.loadingTime = System.currentTimeMillis();
                CFG.glyphLay.setText((BitmapFont)CFG.fontMain.get(0), (CharSequence)CFG.sLoadingText);
                CFG.iLoadingTextWidth = (int)(CFG.glyphLay.width * CFG.LOADING_TEXT_FONT_SCALE);
            }
            catch (final IllegalArgumentException ex) {
                if (CFG.LOGs) {
                    exceptionStack(ex);
                }
            }
        }
        long currentTimeMillis;
        if ((currentTimeMillis = 0L) == 0L) {
            currentTimeMillis = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() < currentTimeMillis) {
            final int n6 = CFG.TEXT_HEIGHT_DEFAULT * 3 + CFG.PADD * 8;
            final int n7 = CFG.GAMEHEIGHT / 2 - n6 / 2;
            spriteBatch.setColor(CFG.COLOR_GRADIENT_MENU_BLUE);
            IMGManager.getIMG(Images.pix255).draw(spriteBatch, 0, n7, CFG.GAMEWIDTH, n6);
            spriteBatch.setColor(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.225f);
            IMGManager.getIMG(Images.line32Off1).draw(spriteBatch, 0, n7, CFG.GAMEWIDTH, n6);
            spriteBatch.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
            IMGManager.getIMG(Images.gradient).draw(spriteBatch, 0, n7, CFG.GAMEWIDTH, CFG.PADD);
            IMGManager.getIMG(Images.gradient).draw(spriteBatch, 0, n7 + n6 - CFG.PADD, CFG.GAMEWIDTH, CFG.PADD, false, true);
            spriteBatch.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.pix255).draw(spriteBatch, 0, n7 + 1, CFG.GAMEWIDTH, 1);
            IMGManager.getIMG(Images.pix255).draw(spriteBatch, 0, n7 + n6 - 2, CFG.GAMEWIDTH, 1);
            spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.325f);
            IMGManager.getIMG(Images.pix255).draw(spriteBatch, 0, n7, CFG.GAMEWIDTH, 1);
            IMGManager.getIMG(Images.pix255).draw(spriteBatch, 0, n7 + n6 - 1, CFG.GAMEWIDTH, 1);
            spriteBatch.setColor(Color.WHITE);
            spriteBatch.setColor(Color.WHITE);
            drawTextDefault(spriteBatch, getLukaszJakowskiGames(), CFG.GAMEWIDTH / 2 - CFG.iJakowskiGamesWidth / 2, n7 + CFG.PADD * 2 + CFG.PADD / 2, CFG.COLOR_HOVER_TITLE);
            drawTextDefault(spriteBatch, "presents", CFG.GAMEWIDTH / 2 - CFG.iJakowskiGames_PresentsWidth / 2, n7 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 3 + CFG.PADD / 2, CFG.COLOR_HOVER_TITLE);
            drawTextDefault(spriteBatch, "Age of History 2: Definitive Edition", CFG.GAMEWIDTH / 2 - CFG.iJakowskiGamesWidth / 2, n7 + CFG.TEXT_HEIGHT_DEFAULT * 2 + CFG.PADD * 5 + CFG.PADD / 2, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            spriteBatch.setColor(Color.WHITE);
        }
        spriteBatch.setColor(new Color(0.019607844f, 0.02745098f, 0.03529412f, 0.75f));
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight(), (int)(n3 * n5), n4);
        spriteBatch.setColor(new Color(0.043137256f, 0.05882353f, 0.07450981f, 0.65f));
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n + (int)(n3 * n5), n2 - IMGManager.getIMG(Images.pix255).getHeight(), n3 - (int)(n3 * n5), n4);
        spriteBatch.setColor(CFG.COLOR_LOADING_SPLIT);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n + (int)(n3 * n5), n2 - IMGManager.getIMG(Images.pix255).getHeight(), 1, n4);
        spriteBatch.setColor(Color.WHITE);
        IMGManager.getIMG(Images.loading_rect_edge).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.loading_rect_edge).getHeight(), n3 - IMGManager.getIMG(Images.loading_rect_edge).getWidth(), n4 - IMGManager.getIMG(Images.loading_rect_edge).getHeight());
        IMGManager.getIMG(Images.loading_rect_edge).draw2O(spriteBatch, n + n3 - IMGManager.getIMG(Images.loading_rect_edge).getWidth(), n2 - IMGManager.getIMG(Images.loading_rect_edge).getHeight(), IMGManager.getIMG(Images.loading_rect_edge).getWidth(), n4 - IMGManager.getIMG(Images.loading_rect_edge).getHeight(), true);
        IMGManager.getIMG(Images.loading_rect_edge).draw2O(spriteBatch, n, n2 + n4 - IMGManager.getIMG(Images.loading_rect_edge).getHeight() * 2, n3 - IMGManager.getIMG(Images.loading_rect_edge).getWidth(), IMGManager.getIMG(Images.loading_rect_edge).getHeight(), false, true);
        IMGManager.getIMG(Images.loading_rect_edge).drawO(spriteBatch, n + n3 - IMGManager.getIMG(Images.loading_rect_edge).getWidth(), n2 + n4 - IMGManager.getIMG(Images.loading_rect_edge).getHeight(), true, true);
        spriteBatch.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.45f));
        IMGManager.getIMG(Images.line32Off1).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.line32Off1).getHeight(), n3, 1);
        IMGManager.getIMG(Images.line32Off1).drawO(spriteBatch, n, n2 + n4 - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), n3, 1);
        Renderer.drawTextWithShadow(spriteBatch, CFG.FONT_BOLD, CFG.sLOATXT, n + n3 / 2 - CFG.iLOADW / 2, n2 + (n4 - CFG.iLOAH) / 2, new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 1.0f));
        Renderer.drawTextWithShadow(spriteBatch, CFG.FONT_BOLD, CFG.sLoading + " " + (int)(n5 * 100.0f) + "%" + s, n, n2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT, new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 1.0f));
        spriteBatch.setColor(new Color(1.0f, 1.0f, 1.0f, 0.35f));
        IMGManager.getIMG(Images.gameLogo).draw2O(spriteBatch, n + n3 - IMGManager.getIMG(Images.gameLogo).getWidth(), n2 - CFG.PADD * 2 - IMGManager.getIMG(Images.gameLogo).getHeight() * 2, IMGManager.getIMG(Images.gameLogo).getWidth(), IMGManager.getIMG(Images.gameLogo).getHeight());
        spriteBatch.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameLogo).draw2O(spriteBatch, n + n3 - IMGManager.getIMG(Images.gameLogo).getWidth(), n2 - CFG.PADD * 2 - IMGManager.getIMG(Images.gameLogo).getHeight() * 2, (int)(IMGManager.getIMG(Images.gameLogo).getWidth() * n5), IMGManager.getIMG(Images.gameLogo).getHeight());
    }
    
    public static final void drawLogo_Square(final SpriteBatch spriteBatch, final int n, final int n2, final int n3) {
        spriteBatch.setColor(Color.BLACK);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight(), n3, n3);
        spriteBatch.setColor(Color.WHITE);
        CFG.map.getMpB().drawMap_LogoSquare(spriteBatch, n, n2, n3, n3);
        spriteBatch.setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
        IMGManager.getIMG(Images.gradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.gradient).getHeight(), n3, (int)(n3 * 0.15f));
        IMGManager.getIMG(Images.gradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.gradient).getHeight() + n3 - (int)(n3 * 0.15f), n3, (int)(n3 * 0.15f), false, true);
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (int)(n3 * 0.15f), n3, false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n + n3 - (int)(n3 * 0.15f), n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), (int)(n3 * 0.15f), n3, true, false);
        spriteBatch.setColor(CFG.COLOR_FLAG_FRAME);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n + 1, n2 - IMGManager.getIMG(Images.pix255).getHeight() + 1, n3 - 2, 1);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n + 1, n2 + n3 - IMGManager.getIMG(Images.pix255).getHeight() - 2, n3 - 2, 1);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n + 1, n2 - IMGManager.getIMG(Images.pix255).getHeight() + 1, 1, n3 - 2);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n + n3 - 2, n2 - IMGManager.getIMG(Images.pix255).getHeight() + 1, 1, n3 - 2);
        spriteBatch.setColor(Color.WHITE);
        if (IMGManager.getIMG(Images.gameLogo).getWidth() > n3 * 0.5f) {
            IMGManager.getIMG(Images.gameLogo).drawO(spriteBatch, n + n3 - CFG.PADD - (int)(IMGManager.getIMG(Images.gameLogo).getWidth() * 0.5f), n2 + n3 - CFG.PADD - IMGManager.getIMG(Images.gameLogo).getHeight() - (int)(IMGManager.getIMG(Images.gameLogo).getHeight() * 0.5f), (int)(IMGManager.getIMG(Images.gameLogo).getWidth() * 0.5f), (int)(IMGManager.getIMG(Images.gameLogo).getHeight() * 0.5f));
        }
        else {
            IMGManager.getIMG(Images.gameLogo).drawO(spriteBatch, n + n3 - CFG.PADD - IMGManager.getIMG(Images.gameLogo).getWidth(), n2 + n3 - CFG.PADD - IMGManager.getIMG(Images.gameLogo).getHeight());
        }
    }
    
    public static final int getActiveCivInfo_BasedOnActiveProvinceID(final int n) {
        if (n < 0) {
            return CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        }
        if (CFG.FOG_OF_WAR == 2) {
            if (CFG.core.getProv(n).getCivId() > 0 && getMetProv(n)) {
                return CFG.core.getProv(n).getCivId();
            }
            return CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        }
        else {
            if (CFG.core.getProv(n).getCivId() > 0) {
                return CFG.core.getProv(n).getCivId();
            }
            return CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        }
    }
    
    public static final int getActiveCivInfoId() {
        return CFG.activeCivInfoId;
    }
    
    public static final void setActiveCivInfoFlag(final Image activeCivFlag) {
        try {
            disposeActiveCivFlagD();
            CFG.activeCivFlag = activeCivFlag;
        }
        catch (final Exception ex) {
            exceptionStack(ex);
        }
    }
    
    public static final void setActiveCivInfoId(final int activeCivInfoId) {
        try {
            disposeActiveCivFlagD();
            CFG.activeCivInfoId = activeCivInfoId;
            if (CFG.core.getCiv(CFG.activeCivInfoId).getCivTag().indexOf(59) > 0) {
                CFG.unionFlagsToGenerate_Manager.lFlags.add(new UnionFlagsToGenerate());
                final int n = CFG.unionFlagsToGenerate_Manager.lFlags.size() - 1;
                final String[] split = CFG.core.getCiv(CFG.activeCivInfoId).getCivTag().split(";");
                for (int i = 0; i < split.length; ++i) {
                    CFG.unionFlagsToGenerate_Manager.lFlags.get(n).lTags.add(split[i]);
                }
                ((UnionFlagsToGenerate)CFG.unionFlagsToGenerate_Manager.lFlags.get(n)).typeOfAction = UnionFlagsToGenerate_TypesOfAction.ACTIVE_CIV_INFO;
                return;
            }
            try {
                if (!CFG.activeCivLeader.isEmpty() && (CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData == null || CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData.getImage().length() == 0 || !CFG.loadedLeader.equals(CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData.getImage()))) {
                    disposeActiveCivLeader();
                }
            }
            catch (final Exception ex) {}
            if (CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData != null && CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData.getImage().length() > 0 && !CFG.loadedLeader.equals(CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData.getImage())) {
                CFG.leaderFrameID = 0;
                CFG.leaderFrameSize = 0;
                CFG.leaderTime = CFG.currentTimeMillis;
                try {
                    CFG.loadedLeader = CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData.getImage();
                    final int lastIndex = CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData.getImage().lastIndexOf(46);
                    if (lastIndex == -1 || !getIsDesktop()) {
                        CFG.activeCivLeader.add(new Image(new Texture(FileManager.loadFile("game/leadersIMG/" + CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData.getImage())), Texture.TextureFilter.Linear));
                        CFG.leaderFrameSize = CFG.activeCivLeader.size();
                    }
                    else {
                        final String substring = CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData.getImage().substring(0, lastIndex);
                        final String substring2 = CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData.getImage().substring(lastIndex);
                        if (FileManager.loadFile("game/leadersIMG/" + substring + "0" + substring2).exists()) {
                            for (int n2 = 0; n2 < 256 && FileManager.loadFile("game/leadersIMG/" + substring + n2 + substring2).exists(); ++n2) {
                                CFG.activeCivLeader.add(new Image(new Texture(FileManager.loadFile("game/leadersIMG/" + substring + n2 + substring2)), Texture.TextureFilter.Linear));
                            }
                        }
                        else {
                            CFG.activeCivLeader.add(new Image(new Texture(FileManager.loadFile("game/leadersIMG/" + CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData.getImage())), Texture.TextureFilter.Linear));
                        }
                        CFG.leaderFrameSize = CFG.activeCivLeader.size();
                    }
                }
                catch (final Exception ex2) {
                    exceptionStack(ex2);
                    disposeActiveCivLeader();
                }
            }
        }
        catch (final Exception ex3) {
            exceptionStack(ex3);
        }
    }
    
    public static final void updateActiveCivInfo_CreateNewGame() {
        CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(1).setTextE(CFG.core.getCiv(CFG.activeCivInfoId).getCivName());
        CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(0).setTextE("" + CFG.core.getCiv(CFG.activeCivInfoId).getRankPos());
        CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(3).setCurr(CFG.activeCivInfoId);
        CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(4).setVisibleE(CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData != null && CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData.getName().length() > 0);
        if (CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(4).getVisibleE()) {
            CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(4).setTextE(CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData.getName());
        }
        if (CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(4).getVisibleE()) {
            CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(3).setHeightE(CFG.PADD * 2 + CFG.TEXT_HEIGHT_DEFAULT);
            CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(4).setHeightE(CFG.PADD * 2 + CFG.TEXT_HEIGHT_DEFAULT);
            Math.min(CFG.menus.getCreate_NewGame_Civ_Info().getHeightM() - (int)(CFG.TEXT_HEIGHT_DEFAULT + CFG.TEXT_HEIGHT_DEFAULT * 0.8f * 2.0f + CFG.PADD * 2), CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY() * 2);
            final int heightE = (CFG.menus.getCreate_NewGame_Civ_Info().getHeightM() - CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY() * 2 - CFG.PADD * 4) / 3;
            CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(1).setPosY(CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY());
            CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(1).setHeightE(heightE);
            CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(3).setPosY(CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY() + CFG.PADD + heightE);
            CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(3).setHeightE(heightE);
            CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(4).setPosY(CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY() + CFG.PADD * 2 + heightE * 2);
            CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(4).setHeightE(heightE);
        }
        else {
            final int n = (CFG.menus.getCreate_NewGame_Civ_Info().getHeightM() - CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY() * 2 - CFG.PADD * 4) / 3;
            CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(1).setPosY(CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY());
            CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(1).setHeightE(n);
            CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(3).setPosY(CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(2).getPosY() + CFG.PADD + n);
            CFG.menus.getCreate_NewGame_Civ_Info().getMenuElem(3).setHeightE(n);
        }
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(1).setTextE(getNumberWthSpaces("" + CFG.core.getCiv(CFG.activeCivInfoId).countPop()));
        try {
            CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(3).setTextE((CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getCapitalProvID()).getCitSize() > 0) ? CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getCapitalProvID()).getCit(0).getCityName() : CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getCapitalProvID()).getName());
        }
        catch (final IndexOutOfBoundsException ex) {
            CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(3).setTextE(CFG.lang.get("NoData"));
        }
        try {
            int curr = CFG.core.getCiv(CFG.activeCivInfoId).getProvID(0);
            for (int i = 1; i < CFG.core.getCiv(CFG.activeCivInfoId).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(curr).getPop().getPops() < CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(i)).getPop().getPops()) {
                    curr = CFG.core.getCiv(CFG.activeCivInfoId).getProvID(i);
                }
            }
            CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(5).setTextE((CFG.core.getProv(curr).getCitSize() > 0) ? CFG.core.getProv(curr).getCit(0).getCityName() : CFG.core.getProv(curr).getName());
            CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(5).setCurr(curr);
        }
        catch (final IndexOutOfBoundsException ex2) {
            CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(5).setTextE(CFG.lang.get("NoData"));
        }
        final ArrayList list = new ArrayList();
        final ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int j = 0; j < CFG.core.getCiv(CFG.activeCivInfoId).getNumOfProvs(); ++j) {
            for (int k = 0; k < CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(j)).getPop().getNatsSize(); ++k) {
                boolean b = true;
                for (int l = 0; l < list.size(); ++l) {
                    if ((int)list.get(l) == CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(j)).getPop().getCivID(k)) {
                        b = false;
                        list2.set(l, list2.get(l) + CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(j)).getPop().getPopulationID(k));
                        break;
                    }
                }
                if (b) {
                    list.add(CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(j)).getPop().getCivID(k));
                    list2.add(CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(j)).getPop().getPopulationID(k));
                }
            }
        }
        if (list.size() == 0) {
            list.add(CFG.activeCivInfoId);
            list2.add(1);
        }
        final boolean isInView = CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(6).getIsInView();
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().setMenuElem(6, (MenuElemUI)new CFG.CFG$1(CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(6).getPosXE(), CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(6).getPosY(), (List)list2, (List)list, (ME_Hover)null));
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(6).setIsInView(isInView);
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(6).setAnotherView(false);
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(6).setCheckboxSt(false);
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(7).setTextE(getPrecision2(CFG.gameAction.getCivMovementPoints(CFG.activeCivInfoId) / 10.0f, 10));
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(8).setTextE("" + (int)(CFG.core.getCiv(CFG.activeCivInfoId).getTechLevel() * 100.0f) / 100.0f);
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(10).setTextE(getNumber_SHORT(CFG.core.getCiv(CFG.activeCivInfoId).countEco()));
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(12).setCurr(getCivDifficulty(CFG.activeCivInfoId));
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(13).setCurr(CFG.core.getCiv(CFG.activeCivInfoId).getHappiness());
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(14).setCurr(CFG.core.getCiv(CFG.activeCivInfoId).getIdeology());
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(15).setCurr(CFG.core.getCiv(CFG.activeCivInfoId).getReligionID());
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(15).setTextE(CFG.religionManager.getReligion(CFG.core.getCiv(CFG.activeCivInfoId).getReligionID()).getName());
        if (CFG.core.getCiv(CFG.activeCivInfoId).getIsPartOfHolyRomanEmpire()) {
            CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(14).setCurr(-1);
            if (CFG.hreMgr.getHRE().getIsEmperor(CFG.activeCivInfoId)) {
                CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(14).setTextE(CFG.lang.get("Emperor"));
            }
            else if (CFG.hreMgr.getHRE().getIsElector(CFG.activeCivInfoId)) {
                CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(14).setTextE(CFG.lang.get("Elector"));
            }
            else {
                CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(14).setTextE(CFG.lang.get("Prince"));
            }
        }
        else {
            CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(14).setCurr(CFG.core.getCiv(CFG.activeCivInfoId).getIdeology());
            CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(14).setTextE(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.activeCivInfoId).getIdeology()).getName());
        }
        CFG.menus.rebuildCreate_NewGame_Civ_Info_Diplomacy();
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(0).setVisibleE(false);
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(2).setVisibleE(false);
        CFG.menus.getCreate_NewGame_Civ_Info_Stats().getMenuElem(4).setVisibleE(false);
    }
    
    public static final int getCivDifficulty(final int n) {
        float n2 = 5.0f;
        if (CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(n).getIdeology()).CAN_BECOME_CIVILIZED > 0) {
            n2 += 10.8f;
        }
        final float n3 = n2 + 65.0f * CFG.core.getCiv(n).getRankPos() / CFG.core.getCivsSize();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < CFG.core.getCiv(n).getNumOfProvs(); ++i) {
            for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(n).getProvID(i)).getNeighProvincesSize(); ++j) {
                if (CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getProvID(i)).getNeighProvinces(j)).getCivId() > 0) {
                    boolean b = false;
                    for (int k = 0; k < list.size(); ++k) {
                        if ((int)list.get(k) == CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getProvID(i)).getNeighProvinces(j)).getCivId()) {
                            b = true;
                            break;
                        }
                    }
                    if (!b) {
                        list.add(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getProvID(i)).getNeighProvinces(j)).getCivId());
                    }
                }
            }
        }
        float n4 = n3 + list.size();
        for (int l = 0; l < list.size(); ++l) {
            n4 += 2.68f * Math.min(CFG.core.getCiv((int)list.get(l)).getRankScore() / (float)CFG.core.getCiv(n).getRankScore(), 1.85f);
        }
        return Math.min((int)n4, 100);
    }
    
    public static final void updateActiveCivilizationInfoInGame() {
        CFG.menus.getInGame_CivInfo().getMenuElem(1).setTextE(CFG.core.getCiv(CFG.activeCivInfoId).getCivName());
        CFG.menus.getInGame_CivInfo().getMenuElem(0).setTextE("" + CFG.core.getCiv(CFG.activeCivInfoId).getRankPos());
        CFG.menus.getInGame_CivInfo().getMenuElem(3).setCurr(CFG.activeCivInfoId);
        CFG.menus.getInGame_CivInfo().getMenuElem(4).setVisibleE(CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData != null && CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData.getName().length() > 0);
        if (CFG.menus.getInGame_CivInfo().getMenuElem(4).getVisibleE()) {
            CFG.menus.getInGame_CivInfo().getMenuElem(4).setTextE(CFG.core.getCiv(CFG.activeCivInfoId).civGD.leaderData.getName());
        }
        if (CFG.menus.getInGame_CivInfo().getMenuElem(4).getVisibleE()) {
            CFG.menus.getInGame_CivInfo().getMenuElem(3).setHeightE(CFG.PADD * 2 + CFG.TEXT_HEIGHT_DEFAULT);
            CFG.menus.getInGame_CivInfo().getMenuElem(4).setHeightE(CFG.PADD * 2 + CFG.TEXT_HEIGHT_DEFAULT);
            Math.min(CFG.menus.getInGame_CivInfo().getHeightM() - (int)(CFG.TEXT_HEIGHT_DEFAULT + CFG.TEXT_HEIGHT_DEFAULT * 0.8f * 2.0f + CFG.PADD * 2), CFG.menus.getInGame_CivInfo().getMenuElem(2).getPosY() * 2);
            final int heightE = (CFG.menus.getInGame_CivInfo().getHeightM() - CFG.menus.getInGame_CivInfo().getMenuElem(2).getPosY() * 2 - CFG.PADD * 4) / 3;
            CFG.menus.getInGame_CivInfo().getMenuElem(1).setPosY(CFG.menus.getInGame_CivInfo().getMenuElem(2).getPosY());
            CFG.menus.getInGame_CivInfo().getMenuElem(1).setHeightE(heightE);
            CFG.menus.getInGame_CivInfo().getMenuElem(3).setPosY(CFG.menus.getInGame_CivInfo().getMenuElem(2).getPosY() + CFG.PADD + heightE);
            CFG.menus.getInGame_CivInfo().getMenuElem(3).setHeightE(heightE);
            CFG.menus.getInGame_CivInfo().getMenuElem(4).setPosY(CFG.menus.getInGame_CivInfo().getMenuElem(2).getPosY() + CFG.PADD * 2 + heightE * 2);
            CFG.menus.getInGame_CivInfo().getMenuElem(4).setHeightE(heightE);
        }
        else {
            CFG.menus.getInGame_CivInfo().getMenuElem(3).setHeightE(CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT);
            final int n = (CFG.menus.getInGame_CivInfo().getHeightM() - CFG.menus.getInGame_CivInfo().getMenuElem(2).getPosY() * 2 - CFG.PADD * 4) / 3;
            CFG.menus.getInGame_CivInfo().getMenuElem(1).setPosY(CFG.menus.getInGame_CivInfo().getMenuElem(2).getPosY());
            CFG.menus.getInGame_CivInfo().getMenuElem(1).setHeightE(n);
            CFG.menus.getInGame_CivInfo().getMenuElem(3).setPosY(CFG.menus.getInGame_CivInfo().getMenuElem(2).getPosY() + CFG.PADD + n);
            CFG.menus.getInGame_CivInfo().getMenuElem(3).setHeightE(n);
        }
        long n2 = 0L;
        long n3 = 0L;
        try {
            int provID = 0;
            if (CFG.core.getCiv(CFG.activeCivInfoId).getNumOfProvs() > 0) {
                provID = -1;
                n2 += CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(0)).getPop().getPops();
                n3 += CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(0)).getEco();
                for (int i = 1; i < CFG.core.getCiv(CFG.activeCivInfoId).getNumOfProvs(); ++i) {
                    n2 += CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(i)).getPop().getPops();
                    n3 += CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(i)).getEco();
                    if (provID < 0 || CFG.core.getProv(provID).getPop().getPops() < CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(i)).getPop().getPops()) {
                        provID = CFG.core.getCiv(CFG.activeCivInfoId).getProvID(i);
                    }
                }
            }
            if (CFG.FOG_OF_WAR == 2) {
                if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(provID)) {
                    CFG.menus.getInGameCivStats().getMenuElem(5).setTextE((CFG.core.getProv(provID).getCitSize() > 0) ? CFG.core.getProv(provID).getCit(0).getCityName() : CFG.core.getProv(provID).getName());
                    CFG.menus.getInGameCivStats().getMenuElem(5).setCurr(provID);
                }
                else {
                    CFG.menus.getInGameCivStats().getMenuElem(5).setTextE(CFG.lang.get("NoData"));
                    CFG.menus.getInGameCivStats().getMenuElem(5).setCurr(-1);
                }
            }
            else {
                CFG.menus.getInGameCivStats().getMenuElem(5).setTextE((CFG.core.getProv(provID).getCitSize() > 0) ? CFG.core.getProv(provID).getCit(0).getCityName() : CFG.core.getProv(provID).getName());
                CFG.menus.getInGameCivStats().getMenuElem(5).setCurr(provID);
            }
        }
        catch (final Exception ex) {
            CFG.menus.getInGameCivStats().getMenuElem(5).setTextE(CFG.lang.get("NoData"));
            CFG.menus.getInGameCivStats().getMenuElem(5).setCurr(-1);
        }
        if (n2 >= 1000000L) {
            CFG.menus.getInGameCivStats().getMenuElem(1).setTextE(getNumber_SHORT(n2));
        }
        else {
            CFG.menus.getInGameCivStats().getMenuElem(1).setTextE(getNumberWthSpaces("" + n2));
        }
        try {
            if (CFG.FOG_OF_WAR == 2) {
                if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(CFG.activeCivInfoId).getCapitalProvID())) {
                    CFG.menus.getInGameCivStats().getMenuElem(3).setTextE((CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getCapitalProvID()).getCitSize() > 0) ? CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getCapitalProvID()).getCit(0).getCityName() : CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getCapitalProvID()).getName());
                }
                else {
                    CFG.menus.getInGameCivStats().getMenuElem(3).setTextE(CFG.lang.get("NoData"));
                    CFG.menus.getInGameCivStats().getMenuElem(3).setCurr(-1);
                }
            }
            else {
                CFG.menus.getInGameCivStats().getMenuElem(3).setTextE((CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getCapitalProvID()).getCitSize() > 0) ? CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getCapitalProvID()).getCit(0).getCityName() : CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getCapitalProvID()).getName());
            }
        }
        catch (final Exception ex2) {
            CFG.menus.getInGameCivStats().getMenuElem(3).setTextE(CFG.lang.get("NoData"));
            CFG.menus.getInGameCivStats().getMenuElem(3).setCurr(-1);
        }
        if (!GameValues.gvInGame.CIV_INFO_POP_GRAPH) {
            CFG.menus.getInGameCivStats().getMenuElem(6).setVisibleE(false);
        }
        else {
            final ArrayList list = new ArrayList();
            final ArrayList<Integer> list2 = new ArrayList<Integer>();
            for (int j = 0; j < CFG.core.getCiv(CFG.activeCivInfoId).getNumOfProvs(); ++j) {
                for (int k = 0; k < CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(j)).getPop().getNatsSize(); ++k) {
                    boolean b = true;
                    for (int l = 0; l < list.size(); ++l) {
                        if ((int)list.get(l) == CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(j)).getPop().getCivID(k)) {
                            b = false;
                            list2.set(l, list2.get(l) + CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(j)).getPop().getPopulationID(k));
                            break;
                        }
                    }
                    if (b) {
                        list.add(CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(j)).getPop().getCivID(k));
                        list2.add(CFG.core.getProv(CFG.core.getCiv(CFG.activeCivInfoId).getProvID(j)).getPop().getPopulationID(k));
                    }
                }
            }
            if (list.isEmpty()) {
                list.add(CFG.activeCivInfoId);
                list2.add(1);
            }
            final boolean isInView = CFG.menus.getInGameCivStats().getMenuElem(6).getIsInView();
            CFG.menus.getInGameCivStats().setMenuElem(6, (MenuElemUI)new CFG.CFG$2(CFG.menus.getInGameCivStats().getMenuElem(6).getPosXE(), CFG.menus.getInGameCivStats().getMenuElem(6).getPosY(), (List)list2, (List)list, (ME_Hover)null));
            CFG.menus.getInGameCivStats().getMenuElem(6).setIsInView(isInView);
        }
        CFG.menus.getInGameCivStats().getMenuElem(7).setTextE(getPrecision2(CFG.gameAction.getCivMovementPoints(CFG.activeCivInfoId) / 10.0f, 10));
        CFG.menus.getInGameCivStats().getMenuElem(8).setTextE("" + (int)(CFG.core.getCiv(CFG.activeCivInfoId).getTechLevel() * 100.0f) / 100.0f);
        CFG.menus.getInGameCivStats().getMenuElem(10).setTextE(getNumber_SHORT(n3));
        CFG.menus.getInGameCivStats().getMenuElem(11).setCurr(CFG.core.getCiv(CFG.activeCivInfoId).getHappiness());
        CFG.menus.getInGameCivStats().getMenuElem(15).setCurr(CFG.core.getCiv(CFG.activeCivInfoId).civGD.iNukes);
        CFG.menus.getInGameCivStats().getMenuElem(15).setPosX(CFG.menus.getInGameCivStats().getMenuElem(11).getPosXE() - CFG.PADD);
        CFG.menus.getInGameCivStats().getMenuElem(15).setVisibleE(CFG.core.getCiv(CFG.activeCivInfoId).civGD.iNukes > 0);
        CFG.menus.getInGameCivStats().getMenuElem(13).setCurr((int)(CFG.core.getCiv(CFG.activeCivInfoId).getStabilityCiv() * 100.0f));
        if (CFG.core.getCiv(CFG.activeCivInfoId).getIsPartOfHolyRomanEmpire()) {
            if (CFG.hreMgr.getHRE().getIsEmperor(CFG.activeCivInfoId)) {
                CFG.menus.getInGameCivStats().getMenuElem(12).setCurr(-1);
                CFG.menus.getInGameCivStats().getMenuElem(12).setTextE(CFG.lang.get("Emperor"));
            }
            else if (CFG.hreMgr.getHRE().getIsElector(CFG.activeCivInfoId)) {
                CFG.menus.getInGameCivStats().getMenuElem(12).setCurr(CFG.core.getCiv(CFG.activeCivInfoId).getIdeology());
                CFG.menus.getInGameCivStats().getMenuElem(12).setTextE(CFG.lang.get("Elector"));
            }
            else {
                CFG.menus.getInGameCivStats().getMenuElem(12).setCurr(CFG.core.getCiv(CFG.activeCivInfoId).getIdeology());
                CFG.menus.getInGameCivStats().getMenuElem(12).setTextE(CFG.lang.get("Prince"));
            }
        }
        else {
            CFG.menus.getInGameCivStats().getMenuElem(12).setCurr(CFG.core.getCiv(CFG.activeCivInfoId).getIdeology());
            CFG.menus.getInGameCivStats().getMenuElem(12).setTextE(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.activeCivInfoId).getIdeology()).getName());
        }
        CFG.menus.getInGameCivStats().getMenuElem(14).setCurr(CFG.core.getCiv(CFG.activeCivInfoId).getReligionID());
        CFG.menus.getInGameCivStats().getMenuElem(14).setTextE(CFG.religionManager.getReligion(CFG.core.getCiv(CFG.activeCivInfoId).getReligionID()).getName());
        CFG.menus.rebuildInGame_Civ_Info_Diplomacy();
        CFG.menus.setVisible_InGame_Civ_Decisions(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == CFG.activeCivInfoId);
        if (CFG.menus.getVisible_InGame_Civ_Opinions()) {
            CFG.menus.rebuildInGame_Civ_Opinions();
        }
        CFG.menus.getInGameCivStats().getMenuElem(0).setVisibleE(false);
        CFG.menus.getInGameCivStats().getMenuElem(2).setVisibleE(false);
        CFG.menus.getInGameCivStats().getMenuElem(4).setVisibleE(false);
    }
    
    public static final void updateCreateAVassalCivInfo() {
        if (CFG.createVassalData.sCivTag != null) {
            CFG.menus.getCreateAVassal_Info().getMenuElem(0).setTextE(CFG.lang.getCiv(CFG.createVassalData.sCivTag));
        }
        CFG.menus.getCreateAVassal_Info().getMenuElem(2).setCurr(CFG.core.getProvSelected().getProvSize());
        int n = 0;
        for (int i = 0; i < CFG.core.getProvSelected().getProvSize(); ++i) {
            n += CFG.core.getProv(CFG.core.getProvSelected().getProv(i)).getPop().getPops();
        }
        CFG.menus.getCreateAVassal_Stats().getMenuElem(1).setTextE(getNumberWthSpaces("" + n));
        if (CFG.createVassalData.iCapitalProvinceID >= 0) {
            CFG.menus.getCreateAVassal_Stats().getMenuElem(3).setTextE((CFG.core.getProv(CFG.createVassalData.iCapitalProvinceID).getCitSize() > 0) ? CFG.core.getProv(CFG.createVassalData.iCapitalProvinceID).getCit(0).getCityName() : CFG.core.getProv(CFG.createVassalData.iCapitalProvinceID).getName());
        }
        else {
            CFG.menus.getCreateAVassal_Stats().getMenuElem(3).setTextE("-");
        }
        int n2 = -1;
        if (CFG.core.getProvSelected().getProvSize() > 0) {
            n2 = 0;
            for (int j = 1; j < CFG.core.getProvSelected().getProvSize(); ++j) {
                if (CFG.core.getProv(CFG.core.getProvSelected().getProv(n2)).getPop().getPops() < CFG.core.getProv(CFG.core.getProvSelected().getProv(j)).getPop().getPops()) {
                    n2 = j;
                }
            }
        }
        if (n2 >= 0) {
            CFG.menus.getCreateAVassal_Stats().getMenuElem(5).setTextE((CFG.core.getProv(CFG.core.getProvSelected().getProv(n2)).getCitSize() > 0) ? CFG.core.getProv(CFG.core.getProvSelected().getProv(n2)).getCit(0).getCityName() : CFG.core.getProv(CFG.core.getProvSelected().getProv(n2)).getName());
            CFG.menus.getCreateAVassal_Stats().getMenuElem(5).setCurr(CFG.core.getProvSelected().getProv(n2));
        }
        else {
            CFG.menus.getCreateAVassal_Stats().getMenuElem(5).setTextE("-");
            CFG.menus.getCreateAVassal_Stats().getMenuElem(5).setCurr(-1);
        }
        final ArrayList list = new ArrayList();
        final ArrayList<Integer> list2 = new ArrayList<Integer>();
        if (CFG.core.getProvSelected().getProvSize() > 0) {
            for (int k = 0; k < CFG.core.getProvSelected().getProvSize(); ++k) {
                for (int l = 0; l < CFG.core.getProv(CFG.core.getProvSelected().getProv(k)).getPop().getNatsSize(); ++l) {
                    boolean b = true;
                    for (int index = 0; index < list.size(); ++index) {
                        if ((int)list.get(index) == CFG.core.getProv(CFG.core.getProvSelected().getProv(k)).getPop().getCivID(l)) {
                            b = false;
                            list2.set(index, list2.get(index) + CFG.core.getProv(CFG.core.getProvSelected().getProv(k)).getPop().getPopulationID(l));
                            break;
                        }
                    }
                    if (b) {
                        list.add(CFG.core.getProv(CFG.core.getProvSelected().getProv(k)).getPop().getCivID(l));
                        list2.add(CFG.core.getProv(CFG.core.getProvSelected().getProv(k)).getPop().getPopulationID(l));
                    }
                }
            }
        }
        else {
            list.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            list2.add(1);
        }
        final boolean isInView = CFG.menus.getCreateAVassal_Stats().getMenuElem(6).getIsInView();
        CFG.menus.getCreateAVassal_Stats().setMenuElem(6, (MenuElemUI)new CFG.CFG$3(CFG.menus.getCreateAVassal_Stats().getMenuElem(6).getPosXE(), CFG.menus.getCreateAVassal_Stats().getMenuElem(6).getPosY(), (List)list2, (List)list, (ME_Hover)null));
        CFG.menus.getCreateAVassal_Stats().getMenuElem(6).setIsInView(isInView);
        CFG.menus.getCreateAVassal_Stats().getMenuElem(8).setTextE("" + (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() * GameValues.gvVassal.RELEASE_VASSAL_PERC_OF_TECH_BASE * 100.0f) / 100.0f);
        int n3 = 0;
        for (int n4 = 0; n4 < CFG.core.getProvSelected().getProvSize(); ++n4) {
            n3 += CFG.core.getProv(CFG.core.getProvSelected().getProv(n4)).getEco();
        }
        CFG.menus.getCreateAVassal_Stats().getMenuElem(10).setTextE(getNumberWthSpaces("" + n3));
        if (CFG.core.getProvSelected().getProvSize() > 0) {
            float n5 = 0.0f;
            for (int n6 = 0; n6 < CFG.core.getProvSelected().getProvSize(); ++n6) {
                n5 += CFG.core.getProv(CFG.core.getProvSelected().getProvSize()).getHappi() * 100.0f;
            }
            CFG.menus.getCreateAVassal_Stats().getMenuElem(11).setCurr((int)(n5 / CFG.core.getProvSelected().getProvSize()));
        }
        else {
            CFG.menus.getCreateAVassal_Stats().getMenuElem(11).setCurr(0);
        }
        if (CFG.createVassalData.sCivTag != null) {
            CFG.menus.getCreateAVassal_Stats().getMenuElem(12).setCurr(CFG.ideologiesMgr.getIdeologyID(CFG.createVassalData.sCivTag));
            CFG.menus.getCreateAVassal_Stats().getMenuElem(12).setTextE(CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.getIdeologyID(CFG.createVassalData.sCivTag)).getName());
        }
        else {
            CFG.menus.getCreateAVassal_Stats().getMenuElem(12).setCurr(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology());
            CFG.menus.getCreateAVassal_Stats().getMenuElem(12).setTextE(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).getName());
        }
    }
    
    public static final void disposeActiveCivLeader() {
        try {
            CFG.loadedLeader = "";
            CFG.leaderFrameID = 0;
            CFG.leaderFrameSize = 0;
            CFG.leaderTime = CFG.currentTimeMillis;
            for (int i = 0; i < CFG.activeCivLeader.size(); ++i) {
                CFG.activeCivLeader.get(i).getTexture().dispose();
            }
            CFG.activeCivLeader.clear();
        }
        catch (final RuntimeException ex) {
            exceptionStack(ex);
        }
        catch (final Exception ex2) {
            exceptionStack(ex2);
        }
    }
    
    public static final void disposeActiveCivFlagD() {
        try {
            if (CFG.activeCivFlag != null) {
                CFG.activeCivFlag.getTexture().dispose();
                CFG.activeCivFlag = null;
                CFG.activeCivInfoId = 0;
            }
        }
        catch (final Exception ex) {
            exceptionStack(ex);
        }
    }
    
    public static final Image getActiveCivFlag() {
        return (CFG.activeCivFlag == null) ? CFG.core.getCiv(CFG.activeCivInfoId).getFlagC() : CFG.activeCivFlag;
    }
    
    public static final String getPercentageOld(final int n, final int n2, final int a) {
        final float n3 = n / (float)n2 * 100.0f;
        if (n3 - Math.floor(n3) == 0.0) {
            return "" + (int)n3;
        }
        return ("" + n3).substring(0, Math.min(a, ("" + n3).length()));
    }
    
    public static final String getPercentage2Old(final int n, final int n2, final int n3) {
        String substring = "" + (int)(n / (float)n2 * 100.0f * n3) / (float)n3;
        try {
            while (substring.length() > 1 && substring.indexOf(46) >= 0 && substring.charAt(substring.length() - 1) == '0') {
                substring = substring.substring(0, substring.length() - 2);
            }
            if (substring.indexOf(46) == substring.length() - 1) {
                return substring.substring(0, substring.length() - 2);
            }
        }
        catch (final Exception ex) {}
        return substring;
    }
    
    public static final String getPercentage2Old(final float n, final float n2, final int n3) {
        String substring = "" + (int)(n / n2 * 100.0f * n3) / (float)n3;
        try {
            while (substring.length() > 1 && substring.indexOf(46) >= 0 && substring.charAt(substring.length() - 1) == '0') {
                substring = substring.substring(0, substring.length() - 2);
            }
            if (substring.indexOf(46) == substring.length() - 1) {
                return substring.substring(0, substring.length() - 2);
            }
        }
        catch (final Exception ex) {}
        return substring;
    }
    
    public static final String getPercentage_Max100(final int n, final int n2, final int a) {
        float n3 = n / (float)n2 * 100.0f;
        if (n3 > 100.0f) {
            n3 = 100.0f;
        }
        if (n3 - Math.floor(n3) == 0.0) {
            return "" + (int)n3;
        }
        return ("" + n3).substring(0, Math.min(a, ("" + n3).length()));
    }
    
    public static final String getPercentageOld(final float n, final float n2, final int a) {
        float n3 = n / n2 * 100.0f;
        if (n3 > 100.0f) {
            n3 = 100.0f;
        }
        return ("" + n3).substring(0, Math.min(a, ("" + n3).length()));
    }
    
    public static final String getPrecision2(final float n, final int n2) {
        String substring = "" + (int)(n * n2) / (float)n2;
        try {
            while (substring.length() > 1 && substring.indexOf(46) >= 0 && substring.charAt(substring.length() - 1) == '0') {
                substring = substring.substring(0, substring.length() - 2);
            }
            if (substring.indexOf(46) == substring.length() - 1) {
                return substring.substring(0, substring.length() - 2);
            }
        }
        catch (final Exception ex) {}
        return substring;
    }
    
    public static final String getPrecision2(final double n, final int n2) {
        String substring = "" + (int)(n * n2) / (float)n2;
        try {
            while (substring.length() > 1 && substring.indexOf(46) >= 0 && substring.charAt(substring.length() - 1) == '0') {
                substring = substring.substring(0, substring.length() - 2);
            }
            if (substring.indexOf(46) == substring.length() - 1) {
                return substring.substring(0, substring.length() - 2);
            }
        }
        catch (final Exception ex) {}
        return substring;
    }
    
    public static final String getPercentage_Max100(final float n, final float n2, final int a) {
        final float n3 = n / n2;
        return ("" + n3).substring(0, Math.min(a, ("" + n3).length()));
    }
    
    public static final String getPercentage_Max100_X100(final float n, final float n2, final int a) {
        final float n3 = n / n2 * 100.0f;
        return ("" + n3).substring(0, Math.min(a, ("" + n3).length()));
    }
    
    public static final int getMetersToFeet(final int n) {
        return (int)(n * 3.2808f);
    }
    
    public static final String getNumberWthSpaces(final String s) {
        String s2 = "";
        for (int i = s.length(); i > 0; i -= 3) {
            s2 = " " + s.substring((i - 3 > 0) ? (i - 3) : 0, i) + s2;
        }
        return (s2.charAt(0) == ' ') ? s2.substring(1, s2.length()) : s2;
    }
    
    public static final String getNumber_SHORT(final int n) {
        if (n < 1000) {
            return "" + n;
        }
        if (n < 1000000) {
            final String s = "" + n / 1000.0f;
            try {
                return "" + ((s.charAt(s.indexOf(".") + 1) == '0') ? (n / 1000 + CFG.lang.get("Value_Thousand")) : (s.substring(0, s.indexOf(".") + 2) + CFG.lang.get("Value_Thousand")));
            }
            catch (final IndexOutOfBoundsException ex) {
                return n / 1000 + CFG.lang.get("Value_Thousand");
            }
        }
        final String s2 = "" + n / 1000000.0f;
        try {
            return "" + ((s2.charAt(s2.indexOf(".") + 1) == '0') ? (n / 1000 + CFG.lang.get("Value_Million")) : (s2.substring(0, s2.indexOf(".") + 2) + CFG.lang.get("Value_Million")));
        }
        catch (final IndexOutOfBoundsException ex2) {
            return n / 1000 + CFG.lang.get("Value_Million");
        }
    }
    
    public static String getNumber_SHORT_ARMY(final int n) {
        if (n < CFG.settingsGD.SHORTEN_ARMY_OVER) {
            return "" + n;
        }
        if (n < 1000000) {
            final String s = "" + n / 1000.0f;
            try {
                return "" + ((s.charAt(s.indexOf(".") + 1) == '0') ? (n / 1000 + CFG.lang.get("Value_Thousand")) : (s.substring(0, s.indexOf(".") + 2) + CFG.lang.get("Value_Thousand")));
            }
            catch (final IndexOutOfBoundsException ex) {
                return n / 1000 + CFG.lang.get("Value_Thousand");
            }
        }
        final String s2 = "" + n / 1000000.0f;
        try {
            return "" + ((s2.charAt(s2.indexOf(".") + 1) == '0') ? (n / 1000 + CFG.lang.get("Value_Million")) : (s2.substring(0, s2.indexOf(".") + 2) + CFG.lang.get("Value_Million")));
        }
        catch (final IndexOutOfBoundsException ex2) {
            return n / 1000 + CFG.lang.get("Value_Million");
        }
    }
    
    public static String getNumber_SHORT(final long n) {
        if (n < 1000L) {
            return "" + n;
        }
        if (n < 1000000L) {
            String s = String.format("%.1f", n / 1000.0f);
            if (s.endsWith(".0")) {
                s = s.substring(0, s.length() - 2);
            }
            return s.replace(',', '.') + CFG.lang.get("Value_Thousand");
        }
        String s2 = String.format("%.1f", n / 1000000.0f);
        if (s2.endsWith(".0")) {
            s2 = s2.substring(0, s2.length() - 2);
        }
        return s2.replace(',', '.') + CFG.lang.get("Value_Million");
    }
    
    public static final int getHappinessImage(final int n) {
        return (n > 60) ? Images.happiness : ((n > 35) ? Images.happiness1 : Images.happiness2);
    }
    
    public static void drLOA(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4, float n5, final String s) {
        if (n5 > 1.0f) {
            n5 = 1.0f;
        }
        else if (n5 < 0.0f) {
            n5 = 0.0f;
        }
        if (System.currentTimeMillis() - 2500L > CFG.loaTM) {
            try {
                CFG.sLOATXT = CFG.lang.getLOA("L" + CFG.oR.nextInt(CFG.lang.iLNOT)) + "..";
                CFG.loaTM = System.currentTimeMillis();
                CFG.glyphLay.setText((BitmapFont)CFG.fontMain.get(CFG.FONT_BOLD), (CharSequence)CFG.sLOATXT);
                CFG.iLOADW = (int)CFG.glyphLay.width;
                CFG.iLOAH = (int)CFG.glyphLay.height;
            }
            catch (final Exception ex) {
                exceptionStack(ex);
            }
        }
        if (CFG.PRT == 0L) {
            CFG.PRT = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() < CFG.PRT + 6500L) {
            final int n6 = CFG.TEXT_HEIGHT_DEFAULT * 3 + CFG.PADD * 8;
            final int n7 = CFG.GAMEHEIGHT / 2 - n6 / 2;
            spriteBatch.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
            IMGManager.getIMG(Images.pix255).draw(spriteBatch, 0, n7, CFG.GAMEWIDTH, n6);
            spriteBatch.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
            IMGManager.getIMG(Images.line32Off1).draw(spriteBatch, 0, n7, CFG.GAMEWIDTH, n6);
            spriteBatch.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
            IMGManager.getIMG(Images.gradient).draw(spriteBatch, 0, n7, CFG.GAMEWIDTH, CFG.PADD);
            IMGManager.getIMG(Images.gradient).draw(spriteBatch, 0, n7 + n6 - CFG.PADD, CFG.GAMEWIDTH, CFG.PADD, false, true);
            spriteBatch.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.85f));
            IMGManager.getIMG(Images.pix255).draw(spriteBatch, 0, n7 + 1, CFG.GAMEWIDTH, 1);
            IMGManager.getIMG(Images.pix255).draw(spriteBatch, 0, n7 + n6 - 2, CFG.GAMEWIDTH, 1);
            spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.325f);
            IMGManager.getIMG(Images.pix255).draw(spriteBatch, 0, n7, CFG.GAMEWIDTH, 1);
            IMGManager.getIMG(Images.pix255).draw(spriteBatch, 0, n7 + n6 - 1, CFG.GAMEWIDTH, 1);
            spriteBatch.setColor(Color.WHITE);
            drawTextDefault(spriteBatch, gLG(), CFG.GAMEWIDTH / 2 - CFG.iJGW / 2, n7 + CFG.PADD * 2 + CFG.PADD / 2, CFG.COLOR_HOVER_TITLE);
            drawTextDefault(spriteBatch, "presents", CFG.GAMEWIDTH / 2 - CFG.iJGPW / 2, n7 + CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 3 + CFG.PADD / 2, CFG.COLOR_HOVER_TITLE);
            drawTextDefault(spriteBatch, "Age of History 2: Definitive Edition", CFG.GAMEWIDTH / 2 - CFG.iDXW / 2, n7 + CFG.TEXT_HEIGHT_DEFAULT * 2 + CFG.PADD * 5 + CFG.PADD / 2, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            spriteBatch.setColor(Color.WHITE);
        }
        spriteBatch.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
        IMGManager.getIMG(Images.gradientXY).draw(spriteBatch, n, n2 - CFG.PADD, n3, CFG.PADD);
        IMGManager.getIMG(Images.gradientXY).draw(spriteBatch, n, n2 + n4, n3, CFG.PADD, false, true);
        spriteBatch.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
        Renderer.drawBox2(spriteBatch, Images.statsRectBG, n, n2, n3, n4, 1.0f);
        spriteBatch.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
        Renderer.drawBox2(spriteBatch, Images.statsRectBG, n + 3, n2 + 3, (int)((n3 - 6) * n5), n4 - 6, 1.0f);
        spriteBatch.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.85f));
        Renderer.drawBox2(spriteBatch, Images.statsRectBGBorder, n + 1, n2 + 1, n3 - 2, n4 - 2, 1.0f);
        spriteBatch.setColor(Color.WHITE);
        Renderer.drawTextWithShadow(spriteBatch, CFG.FONT_BOLD, CFG.sLOATXT, n + n3 / 2 - CFG.iLOADW / 2, n2 + (n4 - CFG.iLOAH) / 2, new Color(CFG.COLOR_HOVER_TITLE.r, CFG.COLOR_HOVER_TITLE.g, CFG.COLOR_HOVER_TITLE.b, 1.0f));
        Renderer.drawTextWithShadow(spriteBatch, CFG.FONT_REGULAR_SMALL, CFG.sLoading + " " + (int)(n5 * 100.0f) + "%" + s, n + CFG.PADD * 2, n2 - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL, new Color(CFG.COLOR_HOVER_TITLE.r, CFG.COLOR_HOVER_TITLE.g, CFG.COLOR_HOVER_TITLE.b, 1.0f));
        spriteBatch.setColor(new Color(1.0f, 1.0f, 1.0f, 0.35f));
        IMGManager.getIMG(Images.gameLogo).draw2O(spriteBatch, n + n3 - CFG.PADD * 2 - IMGManager.getIMG(Images.gameLogo).getWidth(), n2 - CFG.PADD * 2 - IMGManager.getIMG(Images.gameLogo).getHeight() * 2, IMGManager.getIMG(Images.gameLogo).getWidth(), IMGManager.getIMG(Images.gameLogo).getHeight());
        spriteBatch.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameLogo).draw2O(spriteBatch, n + n3 - CFG.PADD * 2 - IMGManager.getIMG(Images.gameLogo).getWidth(), n2 - CFG.PADD * 2 - IMGManager.getIMG(Images.gameLogo).getHeight() * 2, (int)(IMGManager.getIMG(Images.gameLogo).getWidth() * n5), IMGManager.getIMG(Images.gameLogo).getHeight());
        spriteBatch.setColor(Color.WHITE);
    }
    
    public static final boolean compareAlphabetic_TwoString(final String s, final String s2) {
        for (int n = 0; n < s.length() && n < s2.length(); ++n) {
            if (s.charAt(n) < s2.charAt(n)) {
                return false;
            }
            if (s.charAt(n) != s2.charAt(n)) {
                return true;
            }
        }
        return false;
    }
    
    public static void clCPNC() {
        CFG.pNCI.clear();
        CFG.pNC.clear();
        CFG.cNCI.clear();
        CFG.cNC.clear();
    }
    
    public static void aPNC(final int i, final String s) {
        for (int j = 0; j < CFG.pNCI.size(); ++j) {
            if (CFG.pNCI.get(j) == i) {
                CFG.pNC.set(j, s);
                return;
            }
        }
        CFG.pNCI.add(i);
        CFG.pNC.add(s);
    }
    
    public static void aCNC(final int i, final String s) {
        for (int j = 0; j < CFG.cNCI.size(); ++j) {
            if (CFG.cNCI.get(j) == i) {
                CFG.cNC.set(j, s);
                return;
            }
        }
        CFG.cNCI.add(i);
        CFG.cNC.add(s);
    }
    
    public static boolean getIsInFormableCiv(final int n) {
        try {
            for (int i = 0; i < CFG.formableCivs_GameData.getProvincesSize(); ++i) {
                if (CFG.formableCivs_GameData.getProvinceID(i) == n) {
                    return true;
                }
            }
        }
        catch (final Exception ex) {
            if (CFG.LOGs) {
                exceptionStack(ex);
            }
        }
        return false;
    }
    
    public static final String getContinentDataName(final String s) {
        try {
            return ((Continent_GameData)deserialize(FileManager.loadFile("map/data/continents/packges_data/" + s).readBytes())).getName();
        }
        catch (final Exception ex) {
            return s;
        }
    }
    
    public static final String getRegionDataName(final String s) {
        try {
            return ((Region_GameData)deserialize(FileManager.loadFile("map/data/regions/packges_data/" + s).readBytes())).getName();
        }
        catch (final Exception ex) {
            return s;
        }
    }
    
    public static final Color getContinentDataColor(final String s) {
        try {
            final Continent_GameData continent_GameData = (Continent_GameData)deserialize(FileManager.loadFile("map/data/continents/packges_data/" + s).readBytes());
            return new Color(continent_GameData.getR(), continent_GameData.getG(), continent_GameData.getB(), 0.7f);
        }
        catch (final Exception ex) {
            return new Color(1.0f, 1.0f, 1.0f, 0.7f);
        }
    }
    
    public static final Color getRegionDataColor(final String s) {
        try {
            final Region_GameData region_GameData = (Region_GameData)deserialize(FileManager.loadFile("map/data/regions/packges_data/" + s).readBytes());
            return new Color(region_GameData.getR(), region_GameData.getG(), region_GameData.getB(), 0.45f);
        }
        catch (final Exception ex) {
            return new Color(1.0f, 1.0f, 1.0f, 0.45f);
        }
    }
    
    public static final String getPackageContinentDataName(final String s) {
        try {
            return ((Package_ContinentsData)deserialize(FileManager.loadFile("map/data/continents/packges/" + s).readBytes())).getPackageName();
        }
        catch (final Exception ex) {
            return s;
        }
    }
    
    public static final String getPackageRegionDataName(final String s) {
        try {
            return ((Package_RegionsData)deserialize(FileManager.loadFile("map/data/regions/packges/" + s).readBytes())).getPackageName();
        }
        catch (final Exception ex) {
            return s;
        }
    }
    
    public static final String getPackageDiplomacyColorsDataName(final String s) {
        try {
            return ((DiplomacyColors_GameData2)deserialize(FileManager.loadFile("game/diplomacy_colors/packages/" + s).readBytes())).getName();
        }
        catch (final Exception ex) {
            return s;
        }
    }
    
    public static final String getPackageContinentData_AllNames(final String s) {
        try {
            final Package_ContinentsData package_ContinentsData = (Package_ContinentsData)deserialize(FileManager.loadFile("map/data/continents/packges/" + s).readBytes());
            String s2 = "";
            for (int i = 0; i < package_ContinentsData.getContinentsTagsSize(); ++i) {
                s2 = s2 + getContinentDataName(package_ContinentsData.getContinentTag(i)) + ((i < package_ContinentsData.getContinentsTagsSize() - 1) ? ", " : "");
            }
            return s2;
        }
        catch (final Exception ex) {
            return CFG.lang.get("Error");
        }
    }
    
    public static final void drawVersionLB(final SpriteBatch spriteBatch, final int n) {
        Renderer.drawText(spriteBatch, CFG.FONT_REGULAR_SMALL, CFG.sVERSION + ": 2.01 Definitive Edition", CFG.PADD + n, CFG.GAMEHEIGHT - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT_SMALL, new Color(1.0f, 1.0f, 1.0f, 0.25f));
    }
    
    public static final String getPackageRegionsData_AllNames(final String s) {
        try {
            final Package_RegionsData package_RegionsData = (Package_RegionsData)deserialize(FileManager.loadFile("map/data/regions/packges/" + s).readBytes());
            String s2 = "";
            for (int i = 0; i < package_RegionsData.getRegionsTagsSize(); ++i) {
                s2 = s2 + getRegionDataName(package_RegionsData.getRegionTag(i)) + ((i < package_RegionsData.getRegionsTagsSize() - 1) ? ", " : "");
            }
            return s2;
        }
        catch (final Exception ex) {
            return CFG.lang.get("Error");
        }
    }
    
    public static final void drawJakowskiGamesRIGHT_BOT(final SpriteBatch spriteBatch, final int n, final float n2) {
        Renderer.drawText(spriteBatch, CFG.FONT_REGULAR_SMALL, gLG(), CFG.GAMEWIDTH - CFG.PADD - CFG.iJGW + n, CFG.GAMEHEIGHT - CFG.TEXT_HEIGHT_DEFAULT_SMALL - CFG.PADD, new Color(1.0f, 1.0f, 1.0f, 0.25f));
    }
    
    public static final Color getGrowthRateColor(final int n, final float n2) {
        switch (n / 10) {
            case 0: {
                return getColorStep(CFG.COLOR_GROWTH_RATE[0], CFG.COLOR_GROWTH_RATE[1], n % 10, 10, n2);
            }
            case 1: {
                return getColorStep(CFG.COLOR_GROWTH_RATE[1], CFG.COLOR_GROWTH_RATE[2], n % 10, 10, n2);
            }
            case 2: {
                return getColorStep(CFG.COLOR_GROWTH_RATE[2], CFG.COLOR_GROWTH_RATE[3], n % 10, 10, n2);
            }
            case 3: {
                return getColorStep(CFG.COLOR_GROWTH_RATE[3], CFG.COLOR_GROWTH_RATE[4], n % 10, 10, n2);
            }
            case 4: {
                return getColorStep(CFG.COLOR_GROWTH_RATE[4], CFG.COLOR_GROWTH_RATE[5], n % 10, 10, n2);
            }
            case 5: {
                return getColorStep(CFG.COLOR_GROWTH_RATE[5], CFG.COLOR_GROWTH_RATE[6], n % 10, 10, n2);
            }
            case 6: {
                return getColorStep(CFG.COLOR_GROWTH_RATE[6], CFG.COLOR_GROWTH_RATE[7], n % 10, 10, n2);
            }
            case 7: {
                return getColorStep(CFG.COLOR_GROWTH_RATE[7], CFG.COLOR_GROWTH_RATE[8], n % 10, 10, n2);
            }
            case 8: {
                return getColorStep(CFG.COLOR_GROWTH_RATE[8], CFG.COLOR_GROWTH_RATE[9], n % 10, 10, n2);
            }
            case 9: {
                return getColorStep(CFG.COLOR_GROWTH_RATE[9], CFG.COLOR_GROWTH_RATE[10], n % 10, 10, n2);
            }
            case 10: {
                return new Color(CFG.COLOR_GROWTH_RATE[CFG.COLOR_GROWTH_RATE.length - 1].r, CFG.COLOR_GROWTH_RATE[CFG.COLOR_GROWTH_RATE.length - 1].g, CFG.COLOR_GROWTH_RATE[CFG.COLOR_GROWTH_RATE.length - 1].b, n2);
            }
            default: {
                return new Color(CFG.COLOR_GROWTH_RATE[CFG.COLOR_GROWTH_RATE.length - 1].r, CFG.COLOR_GROWTH_RATE[CFG.COLOR_GROWTH_RATE.length - 1].g, CFG.COLOR_GROWTH_RATE[CFG.COLOR_GROWTH_RATE.length - 1].b, n2);
            }
        }
    }
    
    public static final void updateMAX_Army() {
        CFG.MAX_PROVINCE_VALUE = 0;
        if (CFG.FOG_OF_WAR == 0) {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getWastelandLvl() < 0) {
                    if (CFG.core.getProvinceArmy(i) > CFG.MAX_PROVINCE_VALUE) {
                        CFG.MAX_PROVINCE_VALUE = CFG.core.getProvinceArmy(i);
                    }
                }
            }
        }
        else {
            for (int j = 0; j < CFG.core.getProvinSize(); ++j) {
                if (CFG.core.getProv(j).getWastelandLvl() < 0 && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(j)) {
                    if (CFG.core.getProvinceArmy(j) > CFG.MAX_PROVINCE_VALUE) {
                        CFG.MAX_PROVINCE_VALUE = CFG.core.getProvinceArmy(j);
                    }
                }
            }
        }
    }
    
    public static final Color getProvinceArmyColor_Neutral(final int n) {
        return new Color(CFG.COLOR_PROVINCE_ARMY_MAX.r, CFG.COLOR_PROVINCE_ARMY_MAX.g, CFG.COLOR_PROVINCE_ARMY_MAX.b, 0.2875f + 0.2875f * (n / (float)CFG.MAX_PROVINCE_VALUE));
    }
    
    public static final Color getProvinceArmyColor_Own(final int n) {
        return new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), 0.2875f + 0.2875f * (n / (float)CFG.MAX_PROVINCE_VALUE));
    }
    
    public static final Color getProvinceArmyColor_AtWar(final int n) {
        return new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 0.2875f + 0.2875f * (n / (float)CFG.MAX_PROVINCE_VALUE));
    }
    
    public static final Color getProvinceArmyColor_Alliance(final int n) {
        return new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB(), 0.2875f + 0.2875f * (n / (float)CFG.MAX_PROVINCE_VALUE));
    }
    
    public static final void updateMAX_PROVINCE_VALUE() {
        CFG.MAX_PROVINCE_VALUE = 1;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (!CFG.core.getProv(i).getSeaProv() && CFG.core.getProv(i).getWastelandLvl() < 0) {
                if (CFG.core.getProvinceValue(i) > CFG.MAX_PROVINCE_VALUE) {
                    CFG.MAX_PROVINCE_VALUE = CFG.core.getProvinceValue(i);
                }
            }
        }
    }
    
    public static final Color getProvinceValueColor(final int n) {
        return getColorStep(new Color(1.0f, 1.0f, 0.8039216f, 0.75f), new Color(0.9098039f, 0.09411765f, 0.09411765f, 0.75f), n, CFG.MAX_PROVINCE_VALUE, 0.67499995f + 0.075f * (n / (float)CFG.MAX_PROVINCE_VALUE));
    }
    
    public static void drLOA(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4, final float n5) {
        drLOA(spriteBatch, n, n2, n3, n4, n5, "");
    }
    
    public static final Color getEconomyColor(final int n, final float n2) {
        switch (n / 10) {
            case 0: {
                return getColorStep(CFG.COLOR_ECONOMY_GRADIENT[0], CFG.COLOR_ECONOMY_GRADIENT[1], n % 10, 10, n2);
            }
            case 1: {
                return getColorStep(CFG.COLOR_ECONOMY_GRADIENT[1], CFG.COLOR_ECONOMY_GRADIENT[2], n % 10, 10, n2);
            }
            case 2: {
                return getColorStep(CFG.COLOR_ECONOMY_GRADIENT[2], CFG.COLOR_ECONOMY_GRADIENT[3], n % 10, 10, n2);
            }
            case 3: {
                return getColorStep(CFG.COLOR_ECONOMY_GRADIENT[3], CFG.COLOR_ECONOMY_GRADIENT[4], n % 10, 10, n2);
            }
            case 4: {
                return getColorStep(CFG.COLOR_ECONOMY_GRADIENT[4], CFG.COLOR_ECONOMY_GRADIENT[5], n % 10, 10, n2);
            }
            case 5: {
                return getColorStep(CFG.COLOR_ECONOMY_GRADIENT[5], CFG.COLOR_ECONOMY_GRADIENT[6], n % 10, 10, n2);
            }
            case 6: {
                return getColorStep(CFG.COLOR_ECONOMY_GRADIENT[6], CFG.COLOR_ECONOMY_GRADIENT[7], n % 10, 10, n2);
            }
            case 7: {
                return getColorStep(CFG.COLOR_ECONOMY_GRADIENT[7], CFG.COLOR_ECONOMY_GRADIENT[8], n % 10, 10, n2);
            }
            case 8: {
                return getColorStep(CFG.COLOR_ECONOMY_GRADIENT[8], CFG.COLOR_ECONOMY_GRADIENT[9], n % 10, 10, n2);
            }
            case 9: {
                return getColorStep(CFG.COLOR_ECONOMY_GRADIENT[9], CFG.COLOR_ECONOMY_GRADIENT[10], n % 10, 10, n2);
            }
            case 10: {
                return new Color(CFG.COLOR_ECONOMY_GRADIENT[10].r, CFG.COLOR_ECONOMY_GRADIENT[10].g, CFG.COLOR_ECONOMY_GRADIENT[10].b, n2);
            }
            default: {
                return new Color(CFG.COLOR_ECONOMY_GRADIENT[10].r, CFG.COLOR_ECONOMY_GRADIENT[10].g, CFG.COLOR_ECONOMY_GRADIENT[10].b, n2);
            }
        }
    }
    
    public static final Color getTechnologyLevelColor(final int n, final float n2) {
        switch (n / 10) {
            case 0: {
                return getColorStep(CFG.COLOR_TECHNOLOGY_LEVEL[0], CFG.COLOR_TECHNOLOGY_LEVEL[1], n % 10, 10, n2);
            }
            case 1: {
                return getColorStep(CFG.COLOR_TECHNOLOGY_LEVEL[1], CFG.COLOR_TECHNOLOGY_LEVEL[2], n % 10, 10, n2);
            }
            case 2: {
                return getColorStep(CFG.COLOR_TECHNOLOGY_LEVEL[2], CFG.COLOR_TECHNOLOGY_LEVEL[3], n % 10, 10, n2);
            }
            case 3: {
                return getColorStep(CFG.COLOR_TECHNOLOGY_LEVEL[3], CFG.COLOR_TECHNOLOGY_LEVEL[4], n % 10, 10, n2);
            }
            case 4: {
                return getColorStep(CFG.COLOR_TECHNOLOGY_LEVEL[4], CFG.COLOR_TECHNOLOGY_LEVEL[5], n % 10, 10, n2);
            }
            case 5: {
                return getColorStep(CFG.COLOR_TECHNOLOGY_LEVEL[5], CFG.COLOR_TECHNOLOGY_LEVEL[6], n % 10, 10, n2);
            }
            case 6: {
                return getColorStep(CFG.COLOR_TECHNOLOGY_LEVEL[6], CFG.COLOR_TECHNOLOGY_LEVEL[7], n % 10, 10, n2);
            }
            case 7: {
                return getColorStep(CFG.COLOR_TECHNOLOGY_LEVEL[7], CFG.COLOR_TECHNOLOGY_LEVEL[8], n % 10, 10, n2);
            }
            case 8: {
                return getColorStep(CFG.COLOR_TECHNOLOGY_LEVEL[8], CFG.COLOR_TECHNOLOGY_LEVEL[9], n % 10, 10, n2);
            }
            case 9: {
                return getColorStep(CFG.COLOR_TECHNOLOGY_LEVEL[9], CFG.COLOR_TECHNOLOGY_LEVEL[10], n % 10, 10, n2);
            }
            case 10: {
                return new Color(CFG.COLOR_TECHNOLOGY_LEVEL[10].r, CFG.COLOR_TECHNOLOGY_LEVEL[10].g, CFG.COLOR_TECHNOLOGY_LEVEL[10].b, n2);
            }
            default: {
                return new Color(CFG.COLOR_TECHNOLOGY_LEVEL[10].r, CFG.COLOR_TECHNOLOGY_LEVEL[10].g, CFG.COLOR_TECHNOLOGY_LEVEL[10].b, n2);
            }
        }
    }
    
    public static final void initEditdiplomacyColors_GameData() {
        CFG.diplomacyColors_GameData = new DiplomacyColors_GameData2();
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
        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE = new Color_GameData[] { new Color_GameData(0.92941177f, 0.627451f, 0.5882353f), new Color_GameData(0.89411765f, 0.5568628f, 0.45490196f), new Color_GameData(0.85490197f, 0.48235294f, 0.32156864f), new Color_GameData(0.8039216f, 0.40784314f, 0.20784314f), new Color_GameData(0.77254903f, 0.3647059f, 0.2f), new Color_GameData(0.73333335f, 0.3254902f, 0.2f), new Color_GameData(0.69411767f, 0.28627452f, 0.2f), new Color_GameData(0.654902f, 0.2509804f, 0.2f), new Color_GameData(0.62352943f, 0.22352941f, 0.2f), new Color_GameData(0.6f, 0.2f, 0.2f) };
        CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE = new Color_GameData[] { new Color_GameData(0.6f, 0.8f, 0.6f), new Color_GameData(0.5176471f, 0.7607843f, 0.43137255f), new Color_GameData(0.40392157f, 0.70980394f, 0.2627451f), new Color_GameData(0.3019608f, 0.654902f, 0.12156863f), new Color_GameData(0.20392157f, 0.5921569f, 0.003921569f), new Color_GameData(0.14901961f, 0.5647059f, 0.0f), new Color_GameData(0.09411765f, 0.5137255f, 0.0f), new Color_GameData(0.05490196f, 0.46666667f, 0.0f), new Color_GameData(0.023529412f, 0.42745098f, 0.0f), new Color_GameData(0.0f, 0.4f, 0.0f) };
    }
    
    public static final void loadDiplomacyColors_GameData(final String s) {
        try {
            CFG.diplomacyColors_GameData = (DiplomacyColors_GameData2)deserialize(FileManager.loadFile("game/diplomacy_colors/packages/" + s).readBytes());
            return;
        }
        catch (final ClassNotFoundException ex) {}
        catch (final IOException ex2) {}
        initEditdiplomacyColors_GameData();
    }
    
    public static final float getLOAPAD() {
        return (isAndroid() && !CFG.LANDSCAPE) ? 0.1f : 0.2f;
    }
    
    public static final Color getRelationColor(final int n, final float n2) {
        switch (n / 10) {
            case 0: {
                if (n > 0) {
                    return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getB(), n2), n % 10, 10, n2);
                }
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getB(), n2), -n % 10, 10, n2);
            }
            case 1: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[0].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getB(), n2), n % 10, 10, n2);
            }
            case 2: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[1].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getB(), n2), n % 10, 10, n2);
            }
            case 3: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[2].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getB(), n2), n % 10, 10, n2);
            }
            case 4: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[3].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getB(), n2), n % 10, 10, n2);
            }
            case 5: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[4].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getB(), n2), n % 10, 10, n2);
            }
            case 6: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[5].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getB(), n2), n % 10, 10, n2);
            }
            case 7: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[6].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getB(), n2), n % 10, 10, n2);
            }
            case 8: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[7].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getB(), n2), n % 10, 10, n2);
            }
            case 9: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[8].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[9].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[9].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_POSITIVE[9].getB(), n2), n % 10, 10, n2);
            }
            case 10: {
                return new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB(), n2);
            }
            case -1: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[0].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getB(), n2), -n % 10, 10, n2);
            }
            case -2: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[1].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getB(), n2), -n % 10, 10, n2);
            }
            case -3: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[2].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getB(), n2), -n % 10, 10, n2);
            }
            case -4: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[3].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getB(), n2), -n % 10, 10, n2);
            }
            case -5: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[4].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getB(), n2), -n % 10, 10, n2);
            }
            case -6: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[5].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getB(), n2), -n % 10, 10, n2);
            }
            case -7: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[6].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getB(), n2), -n % 10, 10, n2);
            }
            case -8: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[7].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getB(), n2), -n % 10, 10, n2);
            }
            case -9: {
                return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[8].getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[9].getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[9].getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEGATIVE[9].getB(), n2), -n % 10, 10, n2);
            }
            case -10: {
                return new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), n2);
            }
            default: {
                return new Color(0.0f, 0.0f, 0.0f, CFG.ALPHA_DIPLOMACY);
            }
        }
    }
    
    public static final Color getPactColor(final int n, final float n2) {
        return getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT.getB(), n2), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_PACT_MAX.getB(), n2), n, GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT, n2);
    }
    
    public static final Color getTruceColor(final float n) {
        return new Color(1.0f, 1.0f, 1.0f, n);
    }
    
    public static void updateColorDashed() {
        try {
            CFG.COLOR_PROVINCE_DASHED = ((CFG.map.getMpS().getCurrSc() > 1.0f) ? ((CFG.map.getMpS().getCurrSc() < 4.0f) ? new Color(CFG.COLOR_PROVINCE_DASHED.r, CFG.COLOR_PROVINCE_DASHED.g, CFG.COLOR_PROVINCE_DASHED.b, 0.65f - 0.1f * (CFG.map.getMpS().getCurrSc() / 4.0f)) : new Color(CFG.COLOR_PROVINCE_DASHED.r, CFG.COLOR_PROVINCE_DASHED.g, CFG.COLOR_PROVINCE_DASHED.b, 0.54999995f)) : new Color(CFG.COLOR_PROVINCE_DASHED.r, CFG.COLOR_PROVINCE_DASHED.g, CFG.COLOR_PROVINCE_DASHED.b, 0.65f));
        }
        catch (final Exception ex) {
            CFG.COLOR_PROVINCE_DASHED = new Color(CFG.COLOR_PROVINCE_DASHED.r, CFG.COLOR_PROVINCE_DASHED.g, CFG.COLOR_PROVINCE_DASHED.b, 0.65f);
        }
    }
    
    public static final String extraRandomTag() {
        String s = "";
        for (int i = 0; i < 8; ++i) {
            s += (char)(97 + CFG.oR.nextInt(26));
        }
        return s;
    }
    
    public static final String extraRandomTagShort() {
        String s = "";
        for (int i = 0; i < 4; ++i) {
            s += (char)(97 + CFG.oR.nextInt(26));
        }
        return s;
    }
    
    public static final String extraRandm_UPDATE_KEY() {
        String s = "";
        for (int i = 0; i < 14; ++i) {
            s += (char)(97 + CFG.oR.nextInt(26));
        }
        return s;
    }
    
    public static final void buildCreateScenario_TechnologyLevelsByContinents() {
        initCreateScenario_TechnologyLevelsByContinents_Civ();
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.lCreateScenario_TechnologyBContinents.add(new ArrayList<Scenario_GameData_Technology>());
        }
    }
    
    public static final void addCreateScenario_TechnologyLevelsByContinents_Civ() {
        CFG.lCreateScenario_TechnologyBContinents.add(new ArrayList<Scenario_GameData_Technology>());
    }
    
    public static final void initCreateScenario_TechnologyLevelsByContinents_Civ() {
        if (CFG.lCreateScenario_TechnologyBContinents != null) {
            CFG.lCreateScenario_TechnologyBContinents.clear();
            CFG.lCreateScenario_TechnologyBContinents = null;
        }
        CFG.lCreateScenario_TechnologyBContinents = new ArrayList<List<Scenario_GameData_Technology>>();
    }
    
    public static final void addCreateScenario_TechnologyLevelsByContinents_Civ(final List<Scenario_GameData_Technology> list) {
        if (list == null) {
            CFG.lCreateScenario_TechnologyBContinents.add(new ArrayList<Scenario_GameData_Technology>());
        }
        else {
            CFG.lCreateScenario_TechnologyBContinents.add(list);
        }
    }
    
    public static final void removeCreateScenario_TechnologyLevelsByContinents_Civ(final int n) {
        CFG.lCreateScenario_TechnologyBContinents.remove(n);
    }
    
    public static final void setCreateScenario_TechnologyLevelsByContinents_Continent(final int n, final int n2, final int percentage) {
        for (int i = 0; i < CFG.lCreateScenario_TechnologyBContinents.get(n).size(); ++i) {
            if (n2 == CFG.lCreateScenario_TechnologyBContinents.get(n).get(i).getContinentID()) {
                CFG.lCreateScenario_TechnologyBContinents.get(n).get(i).setPercentage(percentage);
                return;
            }
        }
        CFG.lCreateScenario_TechnologyBContinents.get(n).add(new Scenario_GameData_Technology(n2, percentage));
    }
    
    public static final int getCreateScenario_TechnologyLevelsByContinents_Continent(final int n, final int n2) {
        try {
            for (int i = 0; i < CFG.lCreateScenario_TechnologyBContinents.get(n).size(); ++i) {
                if (n2 == CFG.lCreateScenario_TechnologyBContinents.get(n).get(i).getContinentID()) {
                    return CFG.lCreateScenario_TechnologyBContinents.get(n).get(i).getPercentage();
                }
            }
            return 100;
        }
        catch (final Exception ex) {
            if (CFG.lCreateScenario_TechnologyBContinents == null) {
                CFG.lCreateScenario_TechnologyBContinents = new ArrayList<List<Scenario_GameData_Technology>>();
            }
            CFG.lCreateScenario_TechnologyBContinents.add(new ArrayList<Scenario_GameData_Technology>());
            exceptionStack(ex);
            return 100;
        }
    }
    
    public static final void addUndoAssignProvinces(final int n, final int n2) {
        if (CFG.lCreateScenario_UndoAssignProvsCivID.size() > 499) {
            CFG.lCreateScenario_UndoAssignProvsCivID.remove(0);
        }
        CFG.lCreateScenario_UndoAssignProvsCivID.add(new Undo_AssignProvinceCiv(n, n2));
        CFG.menus.setCreate_Scenario_AssignUndoButton(true);
    }
    
    public static void removeUndoAssignProvinces() {
        if (CFG.lCreateScenario_UndoAssignProvsCivID.size() > 0) {
            CFG.lCreateScenario_UndoAssignProvsCivID.remove(CFG.lCreateScenario_UndoAssignProvsCivID.size() - 1);
        }
        if (CFG.lCreateScenario_UndoAssignProvsCivID.size() == 0) {
            CFG.menus.setCreate_Scenario_AssignUndoButton(false);
        }
    }
    
    public static final boolean canFormACiv(final int n, final String s, final boolean b) {
        if (!doesNotExists_FormableCiv(s)) {
            return false;
        }
        if (!CFG.core.isAtPeace(n)) {
            return false;
        }
        if (CFG.core.getCiv(n).getGold() < GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_GOLD) {
            return false;
        }
        if (CFG.core.getCiv(n).getDiploPoints() < GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_DIPLOMACY_POINTS) {
            return false;
        }
        if (CFG.core.getCiv(n).getCivId() != CFG.core.getCiv(n).getPuppetOfCiv()) {
            return false;
        }
        if (b) {
            loadFormableCiv_GameData(s);
        }
        if (!ownAllProvinces_FormableCiv(n)) {
            if (b) {
                CFG.formableCivs_GameData = null;
            }
            return false;
        }
        if (b) {
            CFG.formableCivs_GameData = null;
        }
        return true;
    }
    
    public static final boolean formCiv(final int n) {
        if (canFormACiv(n, CFG.formableCivs_GameData.getFormableCivTag(), false)) {
            CFG.core.getCiv(n).clearTagsCanForm();
            CFG.core.getCiv(n).setCivTag(CFG.formableCivs_GameData.getFormableCivTag());
            CFG.core.getCiv(n).setCivName(CFG.lang.getCiv(CFG.core.getCiv(n).getCivTag()));
            Core.addSimpleTask((Core.SimpleTask)new CFG.CFG$4("formCivLoadFlag" + n, n));
            for (int i = 0; i < CFG.core.getCiv(n).getCivRegionsSize(); ++i) {
                CFG.core.getCiv(n).getCivRegion(i).buildScaleOfText();
            }
            if (CFG.core.getProv(CFG.formableCivs_GameData.getCapitalProvinceID()).getWastelandLvl() < 0 && !CFG.core.getProv(CFG.formableCivs_GameData.getCapitalProvinceID()).getSeaProv() && CFG.formableCivs_GameData.getCapitalProvinceID() != CFG.core.getCiv(n).getCapitalProvID()) {
                if (CFG.core.getCiv(n).getCapitalProvID() >= 0) {
                    for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getCitSize(); ++j) {
                        if (CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getCit(j).getCityLevel() == getEditorCityLevel(0)) {
                            CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getCit(j).setCityLevel(getEditorCityLevel(1));
                        }
                    }
                    CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).setIsCapital(false);
                }
                CFG.core.getCiv(n).setCapitalProvID(CFG.formableCivs_GameData.getCapitalProvinceID());
                CFG.core.getProv(CFG.formableCivs_GameData.getCapitalProvinceID()).setIsCapital(true);
                if (CFG.core.getCiv(n).getCapitalProvID() >= 0) {
                    CFG.core.getCiv(n).setCoreCapitalProvID(CFG.core.getCiv(n).getCapitalProvID());
                    if (CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getCitSize() > 0) {
                        CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getCit(0).setCityLevel(getEditorCityLevel(0));
                    }
                }
            }
            CFG.core.getCiv(n).updateCivilizationIdeology();
            CFG.core.getCiv(n).setGold(CFG.core.getCiv(n).getGold() - GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_GOLD);
            CFG.core.getCiv(n).setDiploPoints(CFG.core.getCiv(n).getDiploPoints() - GameValues.gvFormCiv.COST_OF_FORM_CIVILIZATION_DIPLOMACY_POINTS);
            try {
                try {
                    try {
                        final Civilization_GameData3 civilization_GameData3 = (Civilization_GameData3)deserialize(FileManager.loadFile("game/civilizations/" + CFG.formableCivs_GameData.getFormableCivTag()).readBytes());
                        CFG.core.getCiv(n).setR(civilization_GameData3.getR());
                        CFG.core.getCiv(n).setG(civilization_GameData3.getG());
                        CFG.core.getCiv(n).setB(civilization_GameData3.getB());
                    }
                    catch (final GdxRuntimeException ex) {
                        final Civilization_GameData3 civilization_GameData4 = (Civilization_GameData3)deserialize(FileManager.loadFile("game/civilizations/" + CFG.ideologiesMgr.getRealTag(CFG.formableCivs_GameData.getFormableCivTag())).readBytes());
                        final int ideologyID = CFG.ideologiesMgr.getIdeologyID(CFG.formableCivs_GameData.getFormableCivTag());
                        final Color colorMixed = getColorMixed(new Color(civilization_GameData4.getR() / 255.0f, civilization_GameData4.getG() / 255.0f, civilization_GameData4.getB() / 255.0f, 0.775f), new Color(CFG.ideologiesMgr.getIdeologyID(ideologyID).getColor().r, CFG.ideologiesMgr.getIdeologyID(ideologyID).getColor().g, CFG.ideologiesMgr.getIdeologyID(ideologyID).getColor().b, 0.225f));
                        CFG.core.getCiv(n).setR((int)(colorMixed.r * 255.0f));
                        CFG.core.getCiv(n).setG((int)(colorMixed.g * 255.0f));
                        CFG.core.getCiv(n).setB((int)(colorMixed.b * 255.0f));
                    }
                }
                catch (final GdxRuntimeException ex2) {
                    try {
                        final Civilization_GameData3 civilization_GameData5 = (Civilization_GameData3)deserialize(Gdx.files.local("game/civilizations/" + CFG.formableCivs_GameData.getFormableCivTag()).readBytes());
                        CFG.core.getCiv(n).setR(civilization_GameData5.getR());
                        CFG.core.getCiv(n).setG(civilization_GameData5.getG());
                        CFG.core.getCiv(n).setB(civilization_GameData5.getB());
                    }
                    catch (final GdxRuntimeException ex3) {
                        try {
                            final Civilization_GameData3 civilization_GameData6 = (Civilization_GameData3)deserialize(Gdx.files.local("game/civilizations/" + CFG.ideologiesMgr.getRealTag(CFG.formableCivs_GameData.getFormableCivTag())).readBytes());
                            final int ideologyID2 = CFG.ideologiesMgr.getIdeologyID(CFG.formableCivs_GameData.getFormableCivTag());
                            final Color colorMixed2 = getColorMixed(new Color(civilization_GameData6.getR() / 255.0f, civilization_GameData6.getG() / 255.0f, civilization_GameData6.getB() / 255.0f, 0.775f), new Color(CFG.ideologiesMgr.getIdeologyID(ideologyID2).getColor().r, CFG.ideologiesMgr.getIdeologyID(ideologyID2).getColor().g, CFG.ideologiesMgr.getIdeologyID(ideologyID2).getColor().b, 0.225f));
                            CFG.core.getCiv(n).setR((int)(colorMixed2.r * 255.0f));
                            CFG.core.getCiv(n).setG((int)(colorMixed2.g * 255.0f));
                            CFG.core.getCiv(n).setB((int)(colorMixed2.b * 255.0f));
                        }
                        catch (final GdxRuntimeException ex4) {
                            try {
                                if (isAndroid()) {
                                    try {
                                        final Civilization_GameData3 civilization_GameData7 = (Civilization_GameData3)deserialize(Gdx.files.local("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.formableCivs_GameData.getFormableCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.formableCivs_GameData.getFormableCivTag())).readBytes());
                                        CFG.core.getCiv(n).setR(civilization_GameData7.getR());
                                        CFG.core.getCiv(n).setG(civilization_GameData7.getG());
                                        CFG.core.getCiv(n).setB(civilization_GameData7.getB());
                                    }
                                    catch (final GdxRuntimeException ex5) {
                                        final Civilization_GameData3 civilization_GameData8 = (Civilization_GameData3)deserialize(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.formableCivs_GameData.getFormableCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.formableCivs_GameData.getFormableCivTag())).readBytes());
                                        CFG.core.getCiv(n).setR(civilization_GameData8.getR());
                                        CFG.core.getCiv(n).setG(civilization_GameData8.getG());
                                        CFG.core.getCiv(n).setB(civilization_GameData8.getB());
                                    }
                                }
                                else {
                                    final Civilization_GameData3 civilization_GameData9 = (Civilization_GameData3)deserialize(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.formableCivs_GameData.getFormableCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.formableCivs_GameData.getFormableCivTag())).readBytes());
                                    CFG.core.getCiv(n).setR(civilization_GameData9.getR());
                                    CFG.core.getCiv(n).setG(civilization_GameData9.getG());
                                    CFG.core.getCiv(n).setB(civilization_GameData9.getB());
                                }
                            }
                            catch (final GdxRuntimeException ex6) {}
                        }
                    }
                }
            }
            catch (final ClassNotFoundException ex7) {
                if (CFG.LOGs) {
                    exceptionStack(ex7);
                }
            }
            catch (final IOException ex8) {
                if (CFG.LOGs) {
                    exceptionStack(ex8);
                }
            }
            CFG.gameNewGame.updateFormableCivilizations(n);
            for (int k = 0; k < CFG.core.getCiv(n).getNumOfProvs(); ++k) {
                CFG.core.getProv(CFG.core.getCiv(n).getProvID(k)).setFromCivID(0);
            }
            return true;
        }
        return false;
    }
    
    public static final void addUndoWastelandProvince(final int i) {
        if (CFG.lCreateScenario_UndoWastelandProvinces.size() > 99) {
            CFG.lCreateScenario_UndoWastelandProvinces.remove(0);
        }
        CFG.lCreateScenario_UndoWastelandProvinces.add(i);
        if (CFG.menus.getInCreateScenario_Available_Provinces()) {
            CFG.menus.setCreate_Scenario_AvailableProvinces_UndoButton(true);
        }
        else if (CFG.menus.getInMapEditor_WastelandMaps_Edit()) {
            CFG.menus.setMapEditor_WastelandMaps_Edit_UndoButton(true);
        }
    }
    
    public static void removeUndoWastelandProvince() {
        if (CFG.lCreateScenario_UndoWastelandProvinces.size() > 0) {
            CFG.lCreateScenario_UndoWastelandProvinces.remove(CFG.lCreateScenario_UndoWastelandProvinces.size() - 1);
        }
        if (CFG.lCreateScenario_UndoWastelandProvinces.size() == 0) {
            if (CFG.menus.getInCreateScenario_Available_Provinces()) {
                CFG.menus.setCreate_Scenario_AvailableProvinces_UndoButton(false);
            }
            else if (CFG.menus.getInMapEditor_WastelandMaps_Edit()) {
                CFG.menus.setMapEditor_WastelandMaps_Edit_UndoButton(false);
            }
        }
    }
    
    public static void loadFlagsCh() {
        Core.addSimpleTask((Core.SimpleTask)new CFG.CFG$5("loadFlagsCh"));
    }
    
    public static final void updateNumOfAvailableProvinces() {
        CFG.iNumOfWastelandProvinces = 0;
        CFG.iNumOfAvailableProvinces = 0;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (!CFG.core.getProv(i).getSeaProv()) {
                if (CFG.core.getProv(i).getWastelandLvl() >= 0) {
                    ++CFG.iNumOfWastelandProvinces;
                }
                else {
                    ++CFG.iNumOfAvailableProvinces;
                }
            }
        }
        CFG.glyphLay.setText((BitmapFont)CFG.fontMain.get(0), "" + CFG.iNumOfAvailableProvinces);
        CFG.iNumOfAvailableProvincesWidth = (int)CFG.glyphLay.width;
        CFG.glyphLay.setText((BitmapFont)CFG.fontMain.get(0), "" + CFG.iNumOfWastelandProvinces);
        CFG.iNumOfWastelandProvincesWidth = (int)CFG.glyphLay.width;
    }
    
    public static final void resetManageDiplomacyIDs() {
        CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
        CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = -1;
        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = 1;
        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2 = 0;
    }
    
    public static final void clearFonts() {
        for (int i = 0; i < CFG.fontMain.size(); ++i) {
            CFG.fontMain.get(i).dispose();
            CFG.fontMain.set(i, null);
        }
        CFG.fontMain.clear();
    }
    
    public static final void loadFontMain() {
        clearFonts();
        Renderer.charset = CFG.lang.get("charset");
        loadFont(CFG.lang.get("font"), CFG.lang.get("charset"), CFG.settingsGD.FONT_MAIN_SIZEX);
        CFG.FONT_BOLD = CFG.fontMain.size() - 1;
        loadFont(CFG.lang.get("font"), CFG.lang.get("charset"), (int)Math.floor(CFG.settingsGD.FONT_MAIN_SIZEX * 0.9f));
        CFG.FONT_BOLD_SMALL = CFG.fontMain.size() - 1;
        loadFont(CFG.lang.get("font2"), CFG.lang.get("charset"), (int)Math.floor(CFG.settingsGD.FONT_MAIN_SIZEX * 0.9f));
        CFG.FONT_REGULAR_SMALL = CFG.fontMain.size() - 1;
        CFG.glyphLay.setText((BitmapFont)CFG.fontMain.get(CFG.FONT_BOLD_SMALL), (CharSequence)"Ay\u04cfdZOP38901ERLj");
        CFG.TEXT_HEIGHT_DEFAULT_SMALL = (int)CFG.glyphLay.height;
    }
    
    public static final void loadFont(final String s, final String characters, int a) {
        if (a < 0) {
            a = (int)(GameValues.DEFAULT_FONT_SIZE * CFG.GUI_SCALE);
        }
        FreeTypeFontGenerator freeTypeFontGenerator;
        try {
            freeTypeFontGenerator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/" + s));
        }
        catch (final Exception ex) {
            freeTypeFontGenerator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/rbold.ttf"));
        }
        final FreeTypeFontGenerator.FreeTypeFontParameter freeTypeFontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        freeTypeFontParameter.characters = characters;
        freeTypeFontParameter.size = Math.max(a, 6);
        freeTypeFontParameter.color = Color.WHITE;
        freeTypeFontParameter.minFilter = Texture.TextureFilter.Linear;
        freeTypeFontParameter.magFilter = Texture.TextureFilter.Linear;
        CFG.fontMain.add(freeTypeFontGenerator.generateFont(freeTypeFontParameter));
        freeTypeFontGenerator.dispose();
        if (CFG.fontMain.size() == 1) {
            CFG.glyphLay.setText((BitmapFont)CFG.fontMain.get(0), (CharSequence)"Ay\u04cfdZOP38901ERLj");
            CFG.TEXT_HEIGHT_DEFAULT = (int)CFG.glyphLay.height;
        }
        CFG.settingsGD.updateCitiesFontScale();
    }
    
    public static final void loadFontArmy() {
        if (CFG.fontArmy != null) {
            CFG.fontArmy.dispose();
            CFG.fontArmy = null;
        }
        String value;
        if ((value = CFG.lang.get("fontArmy")).equals("fontArmy")) {
            value = "rbold.ttf";
        }
        FreeTypeFontGenerator freeTypeFontGenerator;
        try {
            freeTypeFontGenerator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/" + value));
        }
        catch (final GdxRuntimeException ex) {
            freeTypeFontGenerator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/rbold.ttf"));
        }
        final FreeTypeFontGenerator.FreeTypeFontParameter freeTypeFontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        freeTypeFontParameter.size = Math.max(CFG.settingsGD.FONT_ARMY_SIZEX, 6);
        freeTypeFontParameter.color = Color.WHITE;
        freeTypeFontParameter.minFilter = Texture.TextureFilter.Linear;
        freeTypeFontParameter.magFilter = Texture.TextureFilter.Linear;
        freeTypeFontParameter.characters = "0123456789+-.,%?!ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        CFG.fontArmy = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
        freeTypeFontGenerator.dispose();
        CFG.glyphLay.setText(CFG.fontArmy, (CharSequence)"-+1234567890");
        CFG.ARMY_HEIGHT = (int)CFG.glyphLay.height;
    }
    
    public static final void loadFontBorder() {
        if (CFG.fontBorder != null) {
            CFG.fontBorder.dispose();
            CFG.fontBorder = null;
        }
        String value;
        if ((value = CFG.lang.get("fontCivNames")).equals("font2")) {
            value = "rbold.ttf";
        }
        FreeTypeFontGenerator freeTypeFontGenerator;
        try {
            freeTypeFontGenerator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/" + value));
        }
        catch (final GdxRuntimeException ex) {
            freeTypeFontGenerator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/rbold.ttf"));
        }
        final FreeTypeFontGenerator.FreeTypeFontParameter freeTypeFontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        freeTypeFontParameter.characters = CFG.lang.get("charset");
        freeTypeFontParameter.size = CFG.settingsGD.FONT_BORDER_SIZEX;
        freeTypeFontParameter.color = new Color(CFG.settingsGD.civNamesFontColor.getR(), CFG.settingsGD.civNamesFontColor.getG(), CFG.settingsGD.civNamesFontColor.getB(), CFG.settingsGD.civNamesFontColor_ALPHA);
        freeTypeFontParameter.minFilter = Texture.TextureFilter.Linear;
        freeTypeFontParameter.magFilter = Texture.TextureFilter.Linear;
        freeTypeFontParameter.borderColor = new Color(CFG.settingsGD.civNamesFontColorBorder.getR(), CFG.settingsGD.civNamesFontColorBorder.getG(), CFG.settingsGD.civNamesFontColorBorder.getB(), CFG.settingsGD.civNamesFontColorBorder_ALPHA);
        freeTypeFontParameter.borderWidth = (float)CFG.settingsGD.FONT_BORDER_WIDTH;
        CFG.fontBorder = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
        freeTypeFontGenerator.dispose();
        loadFontBorder2();
    }
    
    public static final void loadFontBorder2() {
        if (CFG.fontBorder2 != null) {
            CFG.fontBorder2.dispose();
            CFG.fontBorder2 = null;
        }
        String value;
        if ((value = CFG.lang.get("fontCivNames")).equals("font2")) {
            value = "rbold.ttf";
        }
        FreeTypeFontGenerator freeTypeFontGenerator;
        try {
            freeTypeFontGenerator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/" + value));
        }
        catch (final GdxRuntimeException ex) {
            freeTypeFontGenerator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/rbold.ttf"));
        }
        final FreeTypeFontGenerator.FreeTypeFontParameter freeTypeFontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        freeTypeFontParameter.characters = CFG.lang.get("charset");
        freeTypeFontParameter.size = CFG.settingsGD.FONT_BORDER_SIZEX;
        freeTypeFontParameter.color = new Color(CFG.settingsGD.civNamesFontColor.getR(), CFG.settingsGD.civNamesFontColor.getG(), CFG.settingsGD.civNamesFontColor.getB(), CFG.settingsGD.civNamesFontColor_ALPHA);
        freeTypeFontParameter.minFilter = Texture.TextureFilter.Linear;
        freeTypeFontParameter.magFilter = Texture.TextureFilter.Linear;
        freeTypeFontParameter.borderColor = new Color(CFG.settingsGD.civNamesFontColorBorder.getR(), CFG.settingsGD.civNamesFontColorBorder.getG(), CFG.settingsGD.civNamesFontColorBorder.getB(), CFG.settingsGD.civNamesFontColorBorder_ALPHA);
        freeTypeFontParameter.borderWidth = (float)CFG.settingsGD.FONT_BORDER_WIDTH;
        CFG.fontBorder2 = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
        freeTypeFontGenerator.dispose();
    }
    
    public static final void drawTextDefault(final SpriteBatch spriteBatch, final String s, final int n, final int n2, final Color color) {
        try {
            CFG.fontMain.get(0).setColor(color);
            CFG.fontMain.get(0).draw((Batch)spriteBatch, (CharSequence)s, (float)n, (float)(-n2));
        }
        catch (final Exception ex) {}
    }
    
    public static final void drawTextBorder(final SpriteBatch spriteBatch, final String s, final int n, final int n2, final Color color) {
        try {
            CFG.fontBorder.setColor(color);
            CFG.fontBorder.draw((Batch)spriteBatch, (CharSequence)s, (float)n, (float)(-n2));
        }
        catch (final Exception ex) {
            if (CFG.LOGs) {
                exceptionStack(ex);
            }
        }
    }
    
    public static final void drawTextDefaultWithShadow(final SpriteBatch spriteBatch, final String s, final int n, final int n2, final Color color) {
        try {
            CFG.fontMain.get(0).setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
            CFG.fontMain.get(0).draw((Batch)spriteBatch, (CharSequence)s, (float)(n - 1), (float)(-n2 - 1));
            CFG.fontMain.get(0).setColor(color);
            CFG.fontMain.get(0).draw((Batch)spriteBatch, (CharSequence)s, (float)n, (float)(-n2));
        }
        catch (final Exception ex) {}
    }
    
    public static final void drawTextWithShadowRotated(final SpriteBatch spriteBatch, final String s, final int n, final int n2, final Color color, final float n3) {
        final Matrix4 cpy = spriteBatch.getTransformMatrix().cpy();
        try {
            final Matrix4 transformMatrix = new Matrix4();
            transformMatrix.rotate(new Vector3(0.0f, 0.0f, 1.0f), n3);
            transformMatrix.trn((float)n, (float)(-n2), 0.0f);
            spriteBatch.setTransformMatrix(transformMatrix);
            CFG.fontMain.get(0).setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
            CFG.fontMain.get(0).draw((Batch)spriteBatch, (CharSequence)s, -1.0f, -1.0f);
            CFG.fontMain.get(0).setColor(color);
            CFG.fontMain.get(0).draw((Batch)spriteBatch, (CharSequence)s, 0.0f, 0.0f);
        }
        catch (final Exception ex) {
            if (CFG.LOGs) {
                exceptionStack(ex);
            }
        }
        finally {
            spriteBatch.setTransformMatrix(cpy);
        }
    }
    
    public static final void drawTextRotated(final SpriteBatch spriteBatch, final String s, final int n, final int n2, final Color color, final float n3) {
        final Matrix4 cpy = spriteBatch.getTransformMatrix().cpy();
        try {
            final Matrix4 transformMatrix = new Matrix4();
            transformMatrix.rotate(new Vector3(0.0f, 0.0f, 1.0f), n3);
            transformMatrix.trn((float)n, (float)(-n2), 0.0f);
            spriteBatch.setTransformMatrix(transformMatrix);
            CFG.fontMain.get(0).setColor(color);
            CFG.fontMain.get(0).draw((Batch)spriteBatch, (CharSequence)s, 0.0f, 0.0f);
        }
        catch (final Exception ex) {
            if (CFG.LOGs) {
                exceptionStack(ex);
            }
        }
        finally {
            spriteBatch.setTransformMatrix(cpy);
        }
    }
    
    public static final void drawTextRotatedBorder(final SpriteBatch spriteBatch, final String s, final int n, final int n2, final Color color, final float n3) {
        final Matrix4 cpy = spriteBatch.getTransformMatrix().cpy();
        try {
            final Matrix4 transformMatrix = new Matrix4();
            transformMatrix.rotate(new Vector3(0.0f, 0.0f, 1.0f), n3);
            transformMatrix.trn((float)n, (float)(-n2), 0.0f);
            spriteBatch.setTransformMatrix(transformMatrix);
            CFG.fontBorder.setColor(color);
            CFG.fontBorder.draw((Batch)spriteBatch, (CharSequence)s, 0.0f, 0.0f);
        }
        catch (final Exception ex) {
            if (CFG.LOGs) {
                exceptionStack(ex);
            }
        }
        finally {
            spriteBatch.setTransformMatrix(cpy);
        }
    }
    
    public static final void drawArmyText(final SpriteBatch spriteBatch, final String s, final int n, final int n2, final Color color) {
        try {
            CFG.fontArmy.setColor(color);
            CFG.fontArmy.draw((Batch)spriteBatch, (CharSequence)s, (float)n, (float)(-n2));
        }
        catch (final Exception ex) {}
    }
    
    public static final void drawArmyText_WithShadow(final SpriteBatch spriteBatch, final String s, final int n, final int n2, final Color color) {
        try {
            CFG.fontArmy.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
            CFG.fontArmy.draw((Batch)spriteBatch, (CharSequence)s, (float)(n - 1), (float)(-n2 - 1));
            CFG.fontArmy.setColor(color);
            CFG.fontArmy.draw((Batch)spriteBatch, (CharSequence)s, (float)n, (float)(-n2));
        }
        catch (final Exception ex) {
            if (CFG.LOGs) {
                exceptionStack(ex);
            }
        }
    }
    
    public static final int getDarker(final int n, final int n2) {
        return Math.round((float)Math.max(0, n - n2));
    }
    
    public static final Color getDarker(final Color color, final int n, final float n2) {
        return new Color((float)Math.round(Math.max(0.0f, color.r * 255.0f - n) / 255.0f), (float)Math.round(Math.max(0.0f, color.g * 255.0f - n) / 255.0f), (float)Math.round(Math.max(0.0f, color.b * 255.0f - n) / 255.0f), n2);
    }
    
    public static final float getColorStep(final int n, final int n2, final int n3, final int n4) {
        return (n + (n2 - n) * n3 / (float)n4) / 255.0f;
    }
    
    public static final Color getColorStep(final Color color, final Color color2, final int n, final int n2, final float n3) {
        return new Color(color.r + (color2.r - color.r) * n / n2, color.g + (color2.g - color.g) * n / n2, color.b + (color2.b - color.b) * n / n2, n3);
    }
    
    public static final Color getColorStep_WithAlpha(final Color color, final Color color2, final int n, final int n2) {
        return new Color(color.r + (color2.r - color.r) * n / n2, color.g + (color2.g - color.g) * n / n2, color.b + (color2.b - color.b) * n / n2, color.a + (color2.a - color.a) * n / n2);
    }
    
    public static final Color getColorMixed(final Color color, final Color color2) {
        final float n = 1.0f - (1.0f - color.a) * (1.0f - color2.a);
        return new Color(color2.r * color2.a / n + color.r * color.a * (1.0f - color2.a) / n, color2.g * color2.a / n + color.g * color.a * (1.0f - color2.a) / n, color2.b * color2.a / n + color.b * color.a * (1.0f - color2.a) / n, color.a);
    }
    
    public static final float changeAnimationPos(final int n, float n2, final boolean b, final int n3) {
        switch (n) {
            case 0:
            case 1:
            case 12: {
                n2 -= n3 * 2.5f / 100.0f * (b ? -1 : 1);
                break;
            }
            case 2:
            case 3:
            case 10:
            case 11: {
                n2 -= n3 * 5.0f / 100.0f * (b ? -1 : 1);
                break;
            }
            case 4:
            case 5:
            case 8:
            case 9: {
                n2 -= n3 * 10.0f / 100.0f * (b ? -1 : 1);
                break;
            }
            case 6:
            case 7: {
                n2 -= n3 * 15.0f / 100.0f * (b ? -1 : 1);
                break;
            }
            case 13: {
                n2 = (float)(-n3 * (b ? -1 : 1));
                break;
            }
        }
        return n2;
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
        showKeyboard(CFG.menus.getActiveMenuElemeID());
    }
    
    public static final void showKeyboard(final int n) {
        showKeyboard(CFG.menus.getActiveMenuID(), n);
    }
    
    public static final void showKeyboard(final int keyboardActiveSliderMenuID, final int keyboardActiveMenuElementID) {
        try {
            if (Keyboard.colorPickerMode || Keyboard.commandsMode || Keyboard.mapModeSearch || Keyboard.rankSearch) {
                Keyboard.colorPickerMode = false;
                Keyboard.commandsMode = false;
                Keyboard.mapModeSearch = false;
                Keyboard.rankSearch = false;
            }
            updateKeyboard_Actions();
            if (Keyboard.numbers) {
                Keyboard.numbers = false;
                CFG.menus.getKeyboard().actionCloseMenu();
            }
            CFG.menus.setKeyboardActiveSliderMenuID(keyboardActiveSliderMenuID);
            CFG.menus.setKeyboardActiveMenuElementID(keyboardActiveMenuElementID);
            CFG.keybMess = CFG.menus.getActiveMenu().get(CFG.menus.getKeyboardActiveSliderMenuID()).getMenuElem(CFG.menus.getKeyboardActiveMenuElementID()).getTextE();
            CFG.menus.getKeyboard().setVisibleM(true);
        }
        catch (final Exception ex) {
            exceptionStack(ex);
        }
    }
    
    public static final void showKeyboard_Rank() {
        if (!Keyboard.rankSearch) {
            Keyboard.commandsMode = false;
            Keyboard.colorPickerMode = false;
            Keyboard.rankSearch = true;
            Keyboard.mapModeSearch = false;
        }
        updateKeyboard_Actions();
        CFG.menus.setKeyboardActiveMenuElementID(CFG.menus.getActiveMenuElemeID());
        CFG.keybMess = "";
        CFG.menus.getKeyboard().setVisibleM(true);
    }
    
    public static final void showKeyboard_ColorPickerRGB(final String keybMess) {
        if (!Keyboard.colorPickerMode) {
            Keyboard.colorPickerMode = true;
            Keyboard.commandsMode = false;
            Keyboard.mapModeSearch = false;
            Keyboard.rankSearch = false;
        }
        updateKeyboard_Actions();
        Keyboard.numbers = true;
        CFG.menus.getKeyboard().actionCloseMenu();
        CFG.keybMess = keybMess;
        CFG.menus.getKeyboard().setVisibleM(true);
    }
    
    public static final void showKeyboard_Commands() {
        if (!Keyboard.commandsMode) {
            Keyboard.commandsMode = true;
            Keyboard.colorPickerMode = false;
            Keyboard.mapModeSearch = false;
            Keyboard.rankSearch = false;
        }
        updateKeyboard_Actions();
        CFG.menus.setKeyboardActiveMenuElementID(CFG.menus.getActiveMenuElemeID());
        CFG.keybMess = "";
        CFG.menus.getKeyboard().setVisibleM(true);
    }
    
    public static final void showKeyboard_MapModes() {
        if (!Keyboard.mapModeSearch) {
            Keyboard.commandsMode = false;
            Keyboard.colorPickerMode = false;
            Keyboard.rankSearch = false;
            Keyboard.mapModeSearch = true;
        }
        updateKeyboard_Actions();
        CFG.menus.setKeyboardActiveMenuElementID(CFG.menus.getActiveMenuElemeID());
        CFG.keybMess = "";
        CFG.menus.getKeyboard().setVisibleM(true);
    }
    
    public static final void updateKeyboard_Actions() {
        if (Keyboard.colorPickerMode) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$6();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$7();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$8();
        }
        else if (Keyboard.commandsMode) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$9();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$10();
            updateKeyboard_DefaultWrite();
        }
        else if (Keyboard.changeCivilizationNameMode > 0 && CFG.menus.getInGameView()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$11();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$12();
            updateKeyboard_DefaultWrite();
        }
        else if (Keyboard.mapModeSearch && CFG.menus.getInGameView()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$13();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$14();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$15();
        }
        else if (Keyboard.rankSearch && CFG.menus.getInGameView()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$16();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$17();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$18();
        }
        else if (Keyboard.changeProvinceNameMode > 0 && CFG.menus.getInGameView()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$19();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$20();
            updateKeyboard_DefaultWrite();
        }
        else if (CFG.menus.getInCreateScenario_Events() && !CFG.menus.getVisibleCreateScenario_Events_Edit()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$21();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$22();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$23();
        }
        else if (CFG.menus.getInCreateScenario_Civilizations_Select()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$24();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$25();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$26();
        }
        else if (CFG.menus.getInCreateScenario_Cores_AddCore()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$27();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$28();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$29();
        }
        else if (CFG.menus.getInCreateScenario_Cores_AddCiv()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$30();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$31();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$32();
        }
        else if (CFG.menus.getInUnions_AddCiv()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$33();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$34();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$35();
        }
        else if (CFG.menus.getInCreateVassal_Select()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$36();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$37();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$38();
        }
        else if (CFG.menus.getInNewGame_AddCiv_Select()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$39();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$40();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$41();
        }
        else if (CFG.menus.getInMapEditor_FormableCivs_SelectFormable()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$42();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$43();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$44();
        }
        else if (CFG.menus.getInGameCivs()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$45();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$46();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$47();
        }
        else if (CFG.menus.getInGame_AddCiv_Select()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$48();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$49();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$50();
        }
        else if (CFG.menus.getInMapEditor_FormableCivs()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$51();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$52();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$53();
        }
        else if (CFG.menus.getInLeaders()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$54();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$55();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$56();
        }
        else if (CFG.menus.getInLeadersCreateScenario()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$57();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$58();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$59();
        }
        else if (CFG.menus.getInMapEditor_FormableCivs_SelectClaimant()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$60();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$61();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$62();
        }
        else if (CFG.menus.getInLeader_Edit_SelectCivs()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$63();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$64();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$65();
        }
        else if (CFG.menus.getInRandomGame_Civilizations_Select()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$66();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$67();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$68();
        }
        else if (CFG.menus.getInCreateScenario_Events_SelectCiv()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$69();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$70();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$71();
        }
        else if (CFG.menus.getInCreateScenario_Events_AddCiv()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$72();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$73();
            CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$74();
        }
        else if (CFG.menus.getInCreateCity()) {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$75();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$76();
            updateKeyboard_DefaultWrite();
        }
        else {
            CFG.keyboardSave = (CFG.Keyboard_Action)new CFG.CFG$77();
            CFG.keyboardDelete = (CFG.Keyboard_Action)new CFG.CFG$78();
            updateKeyboard_DefaultWrite();
        }
    }
    
    private static final void updateKeyboard_DefaultWrite() {
        CFG.keyboardWrite = (CFG.Keyboard_Action_Write)new CFG.CFG$79();
    }
    
    public static boolean updateKeyboardCheck(final String anObject) {
        return "\n".equals(anObject) || "\r".equals(anObject) || "\\r\\n".equals(anObject);
    }
    
    private static final int getKeyboardMessage_RGB() {
        try {
            int int1 = Integer.parseInt(CFG.keybMess.substring(3, CFG.keybMess.length()));
            if (int1 > 255) {
                int1 = 255;
            }
            else if (int1 < 0) {
                int1 = 0;
            }
            return int1;
        }
        catch (final IllegalArgumentException ex) {
            if (CFG.LOGs) {
                exceptionStack(ex);
            }
        }
        catch (final StringIndexOutOfBoundsException ex2) {
            if (CFG.LOGs) {
                exceptionStack(ex2);
            }
        }
        return 0;
    }
    
    public static final void drawRect(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2, n3, 1);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 + n4 - 1, n3, 1);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 + 1, 1, n4 - 2);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n + n3, n2, 1, n4);
    }
    
    public static final void drawRect_InfoBox_Right_Title(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        spriteBatch.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.pix255).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight(), n3, n4);
        spriteBatch.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.525f));
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3 / 2, n4, false, false);
        spriteBatch.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.525f));
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n + n3 - n3 / 2, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3 / 2, n4, true, false);
        spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.gradient).getHeight(), n3, n4 / 5);
        spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(spriteBatch, n, n2 + n4 - n4 / 5 - IMGManager.getIMG(Images.gradient).getHeight(), n3, n4 / 5, false, true);
        spriteBatch.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE2);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight(), n3, 1, true, false);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 + n4 - 1 - IMGManager.getIMG(Images.pix255).getHeight(), n3, 1, true, false);
        spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.55f);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight() + 1, n3, 1, true, false);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 + n4 - 2 - IMGManager.getIMG(Images.pix255).getHeight(), n3, 1, true, false);
        spriteBatch.setColor(Color.WHITE);
    }
    
    public static final void drawRect_InfoBox_Right_Title2(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        spriteBatch.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.75f));
        IMGManager.getIMG(Images.pix255).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight(), n3, n4);
        spriteBatch.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.525f));
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3 / 2, n4, false, false);
        spriteBatch.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.525f));
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n + n3 - n3 / 2, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3 / 2, n4, true, false);
        spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.gradient).getHeight(), n3, n4 / 5);
        spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(spriteBatch, n, n2 + n4 - n4 / 5 - IMGManager.getIMG(Images.gradient).getHeight(), n3, n4 / 5, false, true);
        spriteBatch.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE2);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight(), n3, 1, true, false);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 + n4 - 1 - IMGManager.getIMG(Images.pix255).getHeight(), n3, 1, true, false);
        spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.55f);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight() + 1, n3, 1, true, false);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 + n4 - 2 - IMGManager.getIMG(Images.pix255).getHeight(), n3, 1, true, false);
        spriteBatch.setColor(Color.WHITE);
    }
    
    public static final byte[] serialize(final Object obj) throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        new ObjectOutputStream(out).writeObject(obj);
        return out.toByteArray();
    }
    
    public static final Object deserialize(final byte[] buf) throws IOException, ClassNotFoundException {
        CFG.b = new ByteArrayInputStream(buf);
        CFG.o = new ObjectInputStream(CFG.b);
        return CFG.o.readUnshared();
    }
    
    public static final void createUnionCivs(int n, int n2) {
        if (n == n2 || n <= 0 || n2 <= 0 || n >= CFG.core.getCivsSize() || n2 >= CFG.core.getCivsSize() || CFG.core.getCivsAtWar(n, n2)) {
            return;
        }
        if (!CFG.core.getCiv(n).getIsPlayer() && (CFG.core.getCiv(n2).getIsPlayer() || CFG.core.getCiv(n).getNumOfProvs() < CFG.core.getCiv(n2).getNumOfProvs())) {
            final int n3 = n;
            n = n2;
            n2 = n3;
        }
        final int i = 0;
        while (i < CFG.core.getCiv(n2).getNumOfProvs()) {
            CFG.core.getProv(CFG.core.getCiv(n2).getProvID(i)).getCores().addNewCore(n, GameCalendar.TURNID);
            try {
                for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(n2).getProvID(i)).getPop().getNatsSize(); ++j) {
                    if (CFG.core.getProv(CFG.core.getCiv(n2).getProvID(i)).getPop().getCivID(j) == n2) {
                        CFG.core.getProv(CFG.core.getCiv(n2).getProvID(i)).getPop().setPopulationOfCivID(n, CFG.core.getProv(CFG.core.getCiv(n2).getProvID(i)).getPop().getPopulationOfCivID(n) + CFG.core.getProv(CFG.core.getCiv(n2).getProvID(i)).getPop().getPopulationOfCivID(n2));
                        CFG.core.getProv(CFG.core.getCiv(n2).getProvID(i)).getPop().setPopulationOfCivID(n2, 0);
                    }
                }
            }
            catch (final Exception ex) {
                exceptionStack(ex);
            }
            try {
                final int provID = CFG.core.getCiv(n2).getProvID(i);
                final int armyCivID1 = CFG.core.getProv(CFG.core.getCiv(n2).getProvID(i)).getArmyCivID1(n);
                final int armyCivID2 = CFG.core.getProv(CFG.core.getCiv(n2).getProvID(i)).getArmyCivID1(n2);
                CFG.core.getProv(CFG.core.getCiv(n2).getProvID(i)).updateArmy4(n, 0);
                CFG.core.getProv(CFG.core.getCiv(n2).getProvID(i)).updateArmy4(n2, 0);
                CFG.core.getProv(CFG.core.getCiv(n2).getProvID(i)).setTrueOwnerOfProv(n);
                CFG.core.getProv(CFG.core.getCiv(n2).getProvID(i)).setCivId(n, false);
                CFG.core.getProv(provID).updateArmy4(n, armyCivID1 + armyCivID2);
            }
            catch (final Exception ex2) {
                exceptionStack(ex2);
            }
        }
        final String unionTag = CFG.unionsManager.getUnionTag(CFG.core.getCiv(n).getCivTag() + ";" + CFG.core.getCiv(n2).getCivTag());
        boolean b = false;
        if (unionTag.length() == 0) {
            final String civTag = CFG.core.getCiv(n).getCivTag() + ";" + CFG.core.getCiv(n2).getCivTag();
            b = true;
            CFG.core.getCiv(n).setR((int)(CFG.core.getCiv(n).getR() / 2.0f + CFG.core.getCiv(n2).getR() / 2.0f));
            CFG.core.getCiv(n).setG((int)(CFG.core.getCiv(n).getG() / 2.0f + CFG.core.getCiv(n2).getG() / 2.0f));
            CFG.core.getCiv(n).setB((int)(CFG.core.getCiv(n).getB() / 2.0f + CFG.core.getCiv(n2).getB() / 2.0f));
            CFG.core.getCiv(n).setCivTag(civTag);
        }
        else {
            CFG.core.getCiv(n).setCivTag(unionTag);
            CFG.palletManager.loadCivilizationStandardColor(n);
        }
        try {
            for (int k = 1; k < CFG.core.getCivsSize(); ++k) {
                if (CFG.core.getCiv(k).getPuppetOfCiv() == n2) {
                    if (n2 != k) {
                        CFG.core.getCiv(k).setPuppetOfCivId(n);
                    }
                }
            }
        }
        catch (final Exception ex3) {
            exceptionStack(ex3);
        }
        try {
            if (CFG.core.getActiveProvID() >= 0) {
                final int activeProvID = CFG.core.getActiveProvID();
                CFG.core.setActiveProvID(-1);
                CFG.core.setActiveProvID(activeProvID);
            }
        }
        catch (final Exception ex4) {
            exceptionStack(ex4);
        }
        try {
            if (CFG.core.getCiv(n2).getAlliance() > 0) {
                CFG.core.getAlliance(CFG.core.getCiv(n2).getAlliance()).removeCivilization(n2);
                CFG.core.getCiv(n2).setAlliance(0);
            }
        }
        catch (final Exception ex5) {
            exceptionStack(ex5);
        }
        Core.addSimpleTask((Core.SimpleTask)new CFG.CFG$80("buildCivilizationRegions" + n, n));
        try {
            for (int l = 0; l < CFG.core.getCiv(n).getNumOfProvs(); ++l) {
                CFG.core.getProv(CFG.core.getCiv(n).getProvID(l)).setFromCivID(0);
            }
        }
        catch (final Exception ex6) {}
        for (int n4 = 0; n4 < CFG.core.getCiv(n2).getArmyInAnotherProvinceSize(); ++n4) {
            CFG.core.getProv(CFG.core.getCiv(n2).getArmyInAnotherProviP(n4)).updateArmy4(n, CFG.core.getProv(CFG.core.getCiv(n2).getArmyInAnotherProviP(n4)).getArmyCivID1(n) + CFG.core.getProv(CFG.core.getCiv(n2).getArmyInAnotherProviP(n4)).getArmyCivID1(n2));
            CFG.core.getProv(CFG.core.getCiv(n2).getArmyInAnotherProviP(n4)).updateArmy4(n2, 0);
        }
        CFG.core.getCiv(n).setNumberOfUnits(0);
        CFG.core.getCiv(n2).setNumberOfUnits(0);
        CFG.core.getCiv(n).updateNumberOfUnits();
        if (CFG.core.getPlayerIDbyCivID(n2) >= 0) {
            CFG.core.removePlayer(CFG.core.getPlayerIDbyCivID(n2));
            CFG.core.getCiv(n2).setIsPlayer(false);
            CFG.PLAYER_TURN_ID = CFG.core.getPlayerIDbyCivID(n);
        }
        for (int n5 = 0; n5 < CFG.core.getCiv(n2).moveUnitsSize(); ++n5) {
            CFG.core.getCiv(n).newMove(CFG.core.getCiv(n2).getMoveUnits(n5).getFromProviID(), CFG.core.getCiv(n2).getMoveUnits(n5).getToProvID(), CFG.core.getCiv(n2).getMoveUnits(n5).getNumberOfUnits(), true);
        }
        for (int n6 = 0; n6 < CFG.core.getCiv(n2).getMoveUnitsPlunderSize(); ++n6) {
            CFG.core.getCiv(n).newPlunder(CFG.core.getCiv(n2).getMoveUnitsPlunder(n6).getFromProvinceID(), CFG.core.getCiv(n2).getMoveUnitsPlunder(n6).getNumOfUnits());
        }
        for (int n7 = 0; n7 < CFG.core.getCiv(n2).getRecruitArmySize(); ++n7) {
            CFG.core.getCiv(n).recruitArmy(CFG.core.getCiv(n2).getRecruitArmy(n7).getProvinceID(), CFG.core.getCiv(n2).getRecruitArmy(n7).getArmy());
        }
        for (int n8 = 0; n8 < CFG.core.getCiv(n2).getConstructionsSize(); ++n8) {
            CFG.core.getCiv(n).addNewConstruction(CFG.core.getCiv(n2).getConstruction(n8));
        }
        CFG.core.getCiv(n2).clearConstructions();
        CFG.core.getCiv(n2).clearMoveUnits();
        CFG.core.getCiv(n2).clearMoveUnits_Plunder();
        CFG.core.getCiv(n2).clearRegroupArmy();
        CFG.core.getCiv(n2).clearRecruitArmy();
        CFG.core.getCiv(n).setGold(CFG.core.getCiv(n).getGold() + CFG.core.getCiv(n2).getGold());
        CFG.core.getCiv(n2).setGold(0L);
        CFG.gameNewGame.updateFormableCivilizations(n);
        CFG.gameNewGame.updateFormableCivilizations(n2);
        if (CFG.core.getCiv(n2).getCapitalProvID() >= 0) {
            for (int n9 = 0; n9 < CFG.core.getProv(CFG.core.getCiv(n2).getCapitalProvID()).getCitSize(); ++n9) {
                if (CFG.core.getProv(CFG.core.getCiv(n2).getCapitalProvID()).getCit(n9).getCityLevel() == getEditorCityLevel(0)) {
                    CFG.core.getProv(CFG.core.getCiv(n2).getCapitalProvID()).getCit(n9).setCityLevel(getEditorCityLevel(1));
                }
            }
            CFG.core.getProv(CFG.core.getCiv(n2).getCapitalProvID()).setIsCapital(false);
        }
        for (int n10 = 1; n10 < CFG.core.getCivsSize(); ++n10) {
            if (n10 != n2 && n10 != n) {
                if (CFG.core.getCiv(n10).getNumOfProvs() > 0) {
                    if (CFG.core.getCivsAtWar(n10, n2)) {
                        final int warID = CFG.core.getWarID(n10, n2);
                        if (warID >= 0) {
                            if (warID < CFG.core.getWarsSize()) {
                                if (CFG.core.getCivsAtWar(n10, n)) {
                                    CFG.core.getWar(warID).updateAfterUnion(n, n2);
                                }
                                else {
                                    CFG.core.war_CheckDiplomacy(n10, n);
                                    CFG.core.setCivRelationOfCivB(n10, n, (float)GameValues.gvDiplomacy.RELATION_AT_WAR);
                                    CFG.core.setCivRelationOfCivB(n, n10, (float)GameValues.gvDiplomacy.RELATION_AT_WAR);
                                    CFG.core.getWar(warID).updateAfterUnion(n, n2);
                                }
                            }
                        }
                    }
                    else if (!CFG.core.getCivsAtWar(n10, n)) {
                        CFG.core.setCivRelationOfCivB(n, n10, (CFG.core.getCivRelationOfCivB(n, n10) + CFG.core.getCivRelationOfCivB(n2, n10)) / 2.0f);
                        CFG.core.setCivRelationOfCivB(n10, n, (CFG.core.getCivRelationOfCivB(n10, n) + CFG.core.getCivRelationOfCivB(n10, n2)) / 2.0f);
                    }
                }
            }
        }
        if (!CFG.core.getCiv(n).getIsPlayer()) {
            CFG.core.getCiv(n).buildCivPersonality();
            try {
                if (CFG.core.getCiv(n).getCivId() != CFG.core.getCiv(n).getPuppetOfCiv() && CFG.core.getCiv(CFG.core.getCiv(n).getPuppetOfCiv()).getIsPlayer()) {
                    Menu_InGame_Tribute.updateVassalsSpendings(n);
                }
            }
            catch (final Exception ex7) {}
        }
        for (int n11 = 0; n11 < CFG.core.getCiv(n2).getLoansSize(); ++n11) {
            CFG.core.getCiv(n).addLoanNew(CFG.core.getCiv(n2).getLoan(n11).iGoldPerTurn, CFG.core.getCiv(n2).getLoan(n11).iTurnsLeft);
        }
        CFG.core.getCiv(n2).clearLoans();
        for (int n12 = CFG.core.getCiv(n2).getFestivalsSize() - 1; n12 >= 0; --n12) {
            CFG.core.getCiv(n).addFestival(CFG.core.getCiv(n2).getFestival(n12));
            CFG.core.getCiv(n2).removeFestival(n12);
        }
        for (int n13 = CFG.core.getCiv(n2).getAssimilatesSize() - 1; n13 >= 0; --n13) {
            CFG.core.getCiv(n).addAssimilate(CFG.core.getCiv(n2).getAssimilate(n13));
            CFG.core.getCiv(n2).removeAssimilate(n13);
        }
        for (int n14 = CFG.core.getCiv(n2).getInvestsSize() - 1; n14 >= 0; --n14) {
            CFG.core.getCiv(n).addInvest(CFG.core.getCiv(n2).getInvest(n14));
            CFG.core.getCiv(n2).removeInvest(n14);
        }
        if ((CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == n || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == n2) && CFG.FOG_OF_WAR > 0) {
            for (int n15 = 0; n15 < CFG.core.getProvinSize(); ++n15) {
                CFG.core.getProv(n15).updateDrawArmyInProv();
            }
        }
        try {
            if (CFG.hreMgr.holyRomanEmpire.getIsEmperor(n2)) {
                CFG.hreMgr.holyRomanEmpire.setEmperor(n);
            }
        }
        catch (final Exception ex8) {
            exceptionStack(ex8);
        }
        CFG.gameAction.buildRank_Score(n);
        CFG.gameAction.buildRank_Score(n2);
        CFG.gameAction.buildRank_Positions();
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == n || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == n2) {
            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        }
        if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
            setActiveCivInfoId(getActiveCivInfoId());
        }
        if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
            CFG.core.getCiv(n).loadFlag();
        }
        else {
            CFG.unionFlagsToGenerate_Manager.addFlagToLoad(n);
        }
        if (b) {
            for (int n16 = 0; n16 < CFG.core.getPlayersSize(); ++n16) {
                if (CFG.core.getPlayer(n16).getCivId() == n || CFG.core.getPlayer(n16).getCivId() == n2) {
                    CFG.unionFlagsToGenerate_Manager.lFlags.add(new UnionFlagsToGenerate());
                    final int n17 = CFG.unionFlagsToGenerate_Manager.lFlags.size() - 1;
                    final String[] split = CFG.core.getCiv(CFG.core.getPlayer(n16).getCivId()).getCivTag().split(";");
                    for (int n18 = 0; n18 < split.length; ++n18) {
                        CFG.unionFlagsToGenerate_Manager.lFlags.get(n17).lTags.add(split[n18]);
                    }
                    ((UnionFlagsToGenerate)CFG.unionFlagsToGenerate_Manager.lFlags.get(n17)).typeOfAction = UnionFlagsToGenerate_TypesOfAction.PLAYER_ID;
                    ((UnionFlagsToGenerate)CFG.unionFlagsToGenerate_Manager.lFlags.get(n17)).iID = CFG.core.getPlayer(n16).getCivId();
                }
            }
        }
        else {
            for (int n19 = 0; n19 < CFG.core.getPlayersSize(); ++n19) {
                if (CFG.core.getPlayer(n19).getCivId() == n || CFG.core.getPlayer(n19).getCivId() == n2) {
                    Core.addSimpleTask((Core.SimpleTask)new CFG.CFG$81("loadPlayersFlag" + n19, n19));
                }
            }
        }
        try {
            if (CFG.hreMgr.getHRE().getEmperor() == n2) {
                CFG.hreMgr.getHRE().addPrince(n);
                CFG.hreMgr.getHRE().setEmperor(n);
            }
        }
        catch (final Exception ex9) {}
        CFG.historyManager.addHistoryLog((HistoryLog)new HistoryLog_Union(n));
    }
    
    public static Object deserializeIgnoringUID(final byte[] buf) throws IOException, ClassNotFoundException {
        return ((ObjectInputStream)new CFG.CFG$82((InputStream)new ByteArrayInputStream(buf))).readObject();
    }
    
    public int getSecondsSinceAppActive() {
        sUM.sUI.getStatI("app_active", 0);
        return 0;
    }
    
    public static void exceptionStack(final Throwable t) {
        if (CFG.LOGs) {
            t.printStackTrace();
            if (GameValues.gvLogs.SAVE_LOGS_TO_FILE) {
                try {
                    final StringWriter out = new StringWriter();
                    final PrintWriter s = new PrintWriter(out);
                    t.printStackTrace(s);
                    s.flush();
                    (FileManager.IS_MAC ? Gdx.files.external("logsAoH2DE.txt") : Gdx.files.local("logsAoH2DE.txt")).writeString("\n" + out.toString(), CFG.append);
                    CFG.append = true;
                    if (CFG.appendNum++ > 999) {
                        CFG.append = false;
                        CFG.appendNum = 0;
                    }
                }
                catch (final Exception ex) {}
            }
        }
    }
    
    public static void LOG(final String s) {
        LOG("DEFAULT", s);
        if (GameValues.gvLogs.SAVE_LOGS_TO_FILE) {
            (FileManager.IS_MAC ? Gdx.files.external("logsAoH2DE.txt") : Gdx.files.local("logsAoH2DE.txt")).writeString("\n" + s, CFG.append);
            CFG.append = true;
            if (CFG.appendNum++ > 999) {
                CFG.append = false;
                CFG.appendNum = 0;
            }
        }
    }
    
    public static void LOG(final String s, final String s2) {
        if (CFG.LOGs) {
            Gdx.app.log(s, s2);
            if (GameValues.gvLogs.SAVE_LOGS_TO_FILE) {
                final FileHandle fileHandle = FileManager.IS_MAC ? Gdx.files.external("logsAoH2DE.txt") : Gdx.files.local("logsAoH2DE.txt");
                fileHandle.writeString("\n[" + s + "] ", CFG.append);
                fileHandle.writeString(s2, CFG.append = true);
                if (CFG.appendNum++ > 999) {
                    CFG.append = false;
                    CFG.appendNum = 0;
                }
            }
        }
    }
    
    public static void LOG(final Throwable t) {
        if (CFG.LOGs) {
            t.printStackTrace();
            if (GameValues.gvLogs.SAVE_LOGS_TO_FILE) {
                final FileHandle fileHandle = FileManager.IS_MAC ? Gdx.files.external("logsAoH2DE.txt") : Gdx.files.local("logsAoH2DE.txt");
                final StringWriter out = new StringWriter();
                t.printStackTrace(new PrintWriter(out));
                fileHandle.writeString(out.toString(), CFG.append);
                CFG.append = true;
                if (CFG.appendNum++ > 999) {
                    CFG.append = false;
                    CFG.appendNum = 0;
                }
            }
        }
    }
    
    public int getImageWidth(final int n) {
        return sUM.sUT.getImageWidth(n);
    }
    
    public int getImageHeight(final int n) {
        return sUM.sUT.getImageHeight(n);
    }
    
    public static void loadRandomProvinceNames() {
        try {
            final String[] split = FileManager.loadFile("game/random/RandomProvinceNames.txt").readString().split("\n");
            for (int i = 0; i < split.length; ++i) {
                CFG.randomProvinceNames.add(split[i]);
            }
        }
        catch (final Exception ex) {
            exceptionStack(ex);
        }
    }
    
    public static final void investAllDevelopment() {
        final int investDevAllProvinces = CFG.core.investDevAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        if (investDevAllProvinces > 0) {
            CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Invest"), CFG.lang.get("Provinces") + ": " + investDevAllProvinces, Images.infoDev);
        }
        else {
            CFG.toastM.addM(CFG.lang.get("Invest") + ": " + CFG.lang.get("Provinces") + ": " + investDevAllProvinces, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            CFG.toastM.setTimeInView(2500);
        }
        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        if (investDevAllProvinces > 0) {
            CFG.gameAction.updateInGame_ProvinceInfo();
            if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                CFG.menus.setVisible_InGame_ProvinceMore(true, true);
            }
            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DEVELOPMENT_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                CFG.menus.setVisible_InGame_ViewDevelopment(true);
            }
            CFG.SFXManager.playSound(age.of.civilizations2.jakowski.lukasz.SFXManager.SFX_WORKSHOP);
        }
    }
    
    public static Color getColorMixed_2(final Color color, final Color color2) {
        return new Color(color2.r * GameValues.gvVassal.VASSAL_COLOR_LORD_PERC + color.r * GameValues.gvVassal.VASSAL_COLOR_VASSAL_PERC, color2.g * GameValues.gvVassal.VASSAL_COLOR_LORD_PERC + color.g * GameValues.gvVassal.VASSAL_COLOR_VASSAL_PERC, color2.b * GameValues.gvVassal.VASSAL_COLOR_LORD_PERC + color.b * GameValues.gvVassal.VASSAL_COLOR_VASSAL_PERC, color.a);
    }
    
    public static void investAllEconomy() {
        final int investEconomyAllProvinces = CFG.core.investEconomyAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        if (investEconomyAllProvinces > 0) {
            CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Invest"), CFG.lang.get("Provinces") + ": " + investEconomyAllProvinces, Images.infoEconomy);
        }
        else {
            CFG.toastM.addM(CFG.lang.get("Invest") + ": " + CFG.lang.get("Provinces") + ": " + investEconomyAllProvinces, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            CFG.toastM.setTimeInView(2500);
        }
        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        if (investEconomyAllProvinces > 0) {
            CFG.gameAction.updateInGame_ProvinceInfo();
            if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                CFG.menus.setVisible_InGame_ProvinceMore(true, true);
            }
            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                CFG.menus.setVisible_InGame_ViewEconomy(true);
            }
            CFG.SFXManager.playSound(age.of.civilizations2.jakowski.lukasz.SFXManager.SFX_WORKSHOP);
        }
    }
    
    public static void festivalAll() {
        final int festivalAllProvinces = CFG.core.festivalAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        if (festivalAllProvinces > 0) {
            CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Festival"), CFG.lang.get("Provinces") + ": " + festivalAllProvinces, Images.infoFestival);
        }
        else {
            CFG.toastM.addM(CFG.lang.get("Festival") + ": " + CFG.lang.get("Provinces") + ": " + festivalAllProvinces, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            CFG.toastM.setTimeInView(2500);
        }
        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        if (festivalAllProvinces > 0) {
            CFG.gameAction.updateInGame_ProvinceInfo();
            if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                CFG.menus.setVisible_InGame_ProvinceMore(true, true);
            }
            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_HAPPINESS_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                CFG.menus.setVisible_InGame_ViewHappiness(true);
            }
        }
    }
    
    public static void assimilateAll() {
        final int assimilateAllProvinces = CFG.core.assimilateAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        if (assimilateAllProvinces > 0) {
            CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Assimilate"), CFG.lang.get("Provinces") + ": " + assimilateAllProvinces, Images.infoStability);
        }
        else {
            CFG.toastM.addM(CFG.lang.get("Assimilate") + ": " + CFG.lang.get("Provinces") + ": " + assimilateAllProvinces, CFG.COLOR_TEXT_NUM_OF_PROVINCES);
            CFG.toastM.setTimeInView(2500);
        }
        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        if (assimilateAllProvinces > 0) {
            CFG.gameAction.updateInGame_ProvinceInfo();
            if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                CFG.menus.setVisible_InGame_ProvinceMore(true, true);
            }
            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_PROVINCE_STABILITY_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                CFG.menus.setVisible_InGame_ViewProvinceStability(true);
            }
            CFG.SFXManager.playSound(age.of.civilizations2.jakowski.lukasz.SFXManager.SFX_ASSIMILATE);
        }
    }
    
    public static final int getCivilizationRanking_IMG_STAR_CIVID(final int n) {
        try {
            if (CFG.core.getCiv(n).getRankPos() <= CFG.numGold) {
                return Images.rank;
            }
            if (CFG.core.getCiv(n).getRankPos() <= CFG.numSilver) {
                return Images.rank1;
            }
            if (CFG.core.getCiv(n).getRankPos() <= CFG.numBronze) {
                return Images.rank2;
            }
        }
        catch (final Exception ex) {}
        return Images.rank3;
    }
    
    public static final void drawRectInfoBox_Left_Title(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        spriteBatch.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.pix255).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight(), n3, n4);
        spriteBatch.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.525f));
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3 / 2, n4, false, false);
        spriteBatch.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.525f));
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n + n3 - n3 / 2, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3 / 2, n4, true, false);
        spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.gradient).getHeight(), n3, n4 / 5);
        spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(spriteBatch, n, n2 + n4 - n4 / 5 - IMGManager.getIMG(Images.gradient).getHeight(), n3, n4 / 5, false, true);
        spriteBatch.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE2);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight(), n3, 1, true, false);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 + n4 - 1 - IMGManager.getIMG(Images.pix255).getHeight(), n3, 1, true, false);
        spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.55f);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight() + 1, n3, 1, true, false);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 + n4 - 2 - IMGManager.getIMG(Images.pix255).getHeight(), n3, 1, true, false);
        spriteBatch.setColor(Color.WHITE);
    }
    
    public static final void drawRect_InfoBox_Left(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        spriteBatch.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.pix255).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight(), n3, n4);
        spriteBatch.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.375f));
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3 / 2, n4, false, false);
        spriteBatch.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.475f));
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n + n3 - n3 / 2, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3 / 2, n4, true, false);
        spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.gradient).getHeight(), n3, n4 / 5);
        spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(spriteBatch, n, n2 + n4 - n4 / 5 - IMGManager.getIMG(Images.gradient).getHeight(), n3, n4 / 5, false, true);
        spriteBatch.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.475f));
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n, n2 + n4 - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3, 1);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n, n2 + 1 - IMGManager.getIMG(Images.pix255).getHeight(), 1, n4 - 2);
        spriteBatch.setColor(new Color(0.0f, 0.0f, 0.0f, 0.175f));
        drawRect(spriteBatch, n - 1, n2 - 2, n3 + 1, n4 + 2);
        spriteBatch.setColor(Color.WHITE);
    }
    
    public static final void drawRect_InfoBox_Right(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        spriteBatch.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.pix255).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight(), n3, n4);
        spriteBatch.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.475f));
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3 / 2, n4, false, false);
        spriteBatch.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, 0.375f));
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n + n3 - n3 / 2, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3 / 2, n4, true, false);
        spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.gradient).getHeight(), n3, n4 / 5);
        spriteBatch.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(spriteBatch, n, n2 + n4 - n4 / 5 - IMGManager.getIMG(Images.gradient).getHeight(), n3, n4 / 5, false, true);
        spriteBatch.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.475f));
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3, 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n, n2 + n4 - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3, 1, true, false);
        IMGManager.getIMG(Images.pix255).drawO(spriteBatch, n + n3 - 1, n2 + 1 - IMGManager.getIMG(Images.pix255).getHeight(), 1, n4 - 2);
        spriteBatch.setColor(new Color(0.0f, 0.0f, 0.0f, 0.175f));
        drawRect(spriteBatch, n - 1, n2 - 2, n3 + 1, n4 + 2);
        spriteBatch.setColor(Color.WHITE);
    }
    
    public static final void drawRect_NewGameBoxDefault(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        IMGManager.getIMG(Images.gameBox).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.gameBox).getHeight(), n3 - IMGManager.getIMG(Images.gameBox).getWidth(), n4 - IMGManager.getIMG(Images.gameBox).getHeight());
        IMGManager.getIMG(Images.gameBox).draw2O(spriteBatch, n + n3 - IMGManager.getIMG(Images.gameBox).getWidth(), n2 - IMGManager.getIMG(Images.gameBox).getHeight(), IMGManager.getIMG(Images.gameBox).getWidth(), n4 - IMGManager.getIMG(Images.gameBox).getHeight(), true);
        IMGManager.getIMG(Images.gameBox).draw2O(spriteBatch, n, n2 + n4 - IMGManager.getIMG(Images.gameBox).getHeight() - IMGManager.getIMG(Images.gameBox).getHeight(), n3 - IMGManager.getIMG(Images.gameBox).getWidth(), IMGManager.getIMG(Images.gameBox).getHeight(), false, true);
        IMGManager.getIMG(Images.gameBox).drawO(spriteBatch, n + n3 - IMGManager.getIMG(Images.gameBox).getWidth(), n2 + n4 - IMGManager.getIMG(Images.gameBox).getHeight(), true, true);
    }
    
    public static final void drawRect_NewGameBoxEDGE(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        IMGManager.getIMG(Images.gameTopEdge).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.gameTopEdge).getHeight(), n3 - IMGManager.getIMG(Images.gameTopEdge).getWidth(), n4 - IMGManager.getIMG(Images.gameTopEdge).getHeight());
        IMGManager.getIMG(Images.gameTopEdge).draw2O(spriteBatch, n + n3 - IMGManager.getIMG(Images.gameTopEdge).getWidth(), n2 - IMGManager.getIMG(Images.gameTopEdge).getHeight(), IMGManager.getIMG(Images.gameTopEdge).getWidth(), n4 - IMGManager.getIMG(Images.gameTopEdge).getHeight(), true, false);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(spriteBatch, n, n2 + n4 - IMGManager.getIMG(Images.gameTopEdge).getHeight() * 2, n3 - IMGManager.getIMG(Images.gameTopEdge).getWidth(), IMGManager.getIMG(Images.gameTopEdge).getHeight(), false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(spriteBatch, n + n3 - IMGManager.getIMG(Images.gameTopEdge).getWidth(), n2 + n4 - IMGManager.getIMG(Images.gameTopEdge).getHeight() * 2, IMGManager.getIMG(Images.gameTopEdge).getWidth(), IMGManager.getIMG(Images.gameTopEdge).getHeight(), true, true);
    }
    
    public static final void drawEditorTitle_EdgeR(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        IMGManager.getIMG(Images.editor_top).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.editor_top).getHeight(), n3, n4 + 1, true, true);
        spriteBatch.setColor(new Color(0.025f, 0.03f, 0.092f, 0.225f));
        IMGManager.getIMG(Images.line32Off1).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.line32Off1).getHeight(), n3, n4 - 2);
        spriteBatch.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.75f));
        IMGManager.getIMG(Images.line32Off1).drawO(spriteBatch, n, n2 + n4 - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), n3, 1);
        spriteBatch.setColor(Color.WHITE);
    }
    
    public static final void drawEditorTitle_Edge_R_Reflected(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        IMGManager.getIMG(Images.editor_top).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.editor_top).getHeight(), n3, n4 + 1, false, true);
        spriteBatch.setColor(new Color(0.025f, 0.03f, 0.092f, 0.225f));
        IMGManager.getIMG(Images.line32Off1).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.line32Off1).getHeight(), n3, n4 - 2);
        spriteBatch.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.75f));
        IMGManager.getIMG(Images.line32Off1).drawO(spriteBatch, n, n2 + n4 - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), n3, 1);
        spriteBatch.setColor(Color.WHITE);
    }
    
    public static final void drawEditorTitle_Edge_LR(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        IMGManager.getIMG(Images.editor_top).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.editor_top).getHeight(), IMGManager.getIMG(Images.editor_top).getWidth(), n4 + 1, false, true);
        IMGManager.getIMG(Images.editor_top).draw2O(spriteBatch, n + IMGManager.getIMG(Images.editor_top).getWidth(), n2 - IMGManager.getIMG(Images.editor_top).getHeight(), n3 - IMGManager.getIMG(Images.editor_top).getWidth(), n4 + 1, true, true);
        spriteBatch.setColor(new Color(0.025f, 0.03f, 0.092f, 0.225f));
        IMGManager.getIMG(Images.line32Off1).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.line32Off1).getHeight(), n3, n4 - 2);
        spriteBatch.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.75f));
        IMGManager.getIMG(Images.line32Off1).drawO(spriteBatch, n, n2 + n4 - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), n3, 1);
        spriteBatch.setColor(Color.WHITE);
    }
    
    public static final void drawEditorTitle_Bot_Edge_LR(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        IMGManager.getIMG(Images.editor_top).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.editor_top).getHeight(), IMGManager.getIMG(Images.editor_top).getWidth(), n4 + 1, false, false);
        IMGManager.getIMG(Images.editor_top).draw2O(spriteBatch, n + IMGManager.getIMG(Images.editor_top).getWidth(), n2 - IMGManager.getIMG(Images.editor_top).getHeight(), n3 - IMGManager.getIMG(Images.editor_top).getWidth(), n4 + 1, true, false);
        spriteBatch.setColor(new Color(0.025f, 0.03f, 0.092f, 0.225f));
        IMGManager.getIMG(Images.line32Off1).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.line32Off1).getHeight() + 2, n3, n4 - 2);
        spriteBatch.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.75f));
        IMGManager.getIMG(Images.line32Off1).drawO(spriteBatch, n, n2 + n4 - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), n3, 1);
        spriteBatch.setColor(Color.WHITE);
    }
    
    public static final void drawEditorButtons_Bot_Edge_R(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        IMGManager.getIMG(Images.editor_top).draw2O(spriteBatch, n, n2 - 1 - IMGManager.getIMG(Images.editor_top).getHeight(), n3, n4 + 1, true, false);
        IMGManager.getIMG(Images.editor_top_line).draw2O(spriteBatch, n + n3 - 1, n2 - 2, IMGManager.getIMG(Images.editor_top_line).getWidth(), n4 + 1, false, true);
        spriteBatch.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.75f));
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3 - CFG.PADD, 1);
        spriteBatch.setColor(Color.WHITE);
    }
    
    public static final void drawEditorButtons_Bot_Edge_R_Reflected(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        IMGManager.getIMG(Images.editor_top).draw2O(spriteBatch, n, n2 - 1 - IMGManager.getIMG(Images.editor_top).getHeight(), n3, n4 + 1, false, false);
        IMGManager.getIMG(Images.editor_top_line).draw2O(spriteBatch, n - 1, n2 - 2, IMGManager.getIMG(Images.editor_top_line).getWidth(), n4 + 1, true, true);
        spriteBatch.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.75f));
        IMGManager.getIMG(Images.sliderGradient).drawO(spriteBatch, n + CFG.PADD, n2 - IMGManager.getIMG(Images.sliderGradient).getHeight(), n3 - CFG.PADD, 1, true, false);
        spriteBatch.setColor(Color.WHITE);
    }
    
    public static final void drawEditorButtons_Top_Edge_R(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        IMGManager.getIMG(Images.editor_top).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.editor_top).getHeight(), n3, n4 + 1, true, true);
        IMGManager.getIMG(Images.editor_top_line).draw2O(spriteBatch, n + n3 - 1, n2 - IMGManager.getIMG(Images.editor_top_line).getHeight(), IMGManager.getIMG(Images.editor_top_line).getWidth(), n4 + 1, false, true);
    }
    
    public static final void drawEditorButtons_Top_Edge_R_Reflected(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        IMGManager.getIMG(Images.editor_top).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.editor_top).getHeight(), n3, n4 + 1, false, true);
        IMGManager.getIMG(Images.editor_top_line).draw2O(spriteBatch, n - 1, n2 - IMGManager.getIMG(Images.editor_top_line).getHeight(), IMGManager.getIMG(Images.editor_top_line).getWidth(), n4 + 1, true, true);
    }
    
    public static final void drawBG_WithGradient(final SpriteBatch spriteBatch, final int n, final int n2, final int n3, final int n4) {
        spriteBatch.setColor(new Color(0.0f, 0.01f, 0.012f, 0.45f));
        IMGManager.getIMG(Images.pix255).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight(), n3, n4);
        spriteBatch.setColor(new Color(0.0f, 0.01f, 0.012f, 0.32f));
        IMGManager.getIMG(Images.patternReversed).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.patternReversed).getHeight(), n3, n4);
        spriteBatch.setColor(new Color(0.0f, 0.01f, 0.012f, 0.75f));
        IMGManager.getIMG(Images.gradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.gradient).getHeight(), n3, n4 / 4);
        IMGManager.getIMG(Images.gradient).drawO(spriteBatch, n, n2 - IMGManager.getIMG(Images.gradient).getHeight() + n4 - n4 / 4, n3, n4, false, true);
        spriteBatch.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight(), n3, 1);
        IMGManager.getIMG(Images.pix255).draw2O(spriteBatch, n, n2 + n4 - 1 - IMGManager.getIMG(Images.pix255).getHeight(), n3, 1);
        spriteBatch.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.pix255).draw2O(spriteBatch, n, n2 - IMGManager.getIMG(Images.pix255).getHeight() - 1, n3, 1);
        IMGManager.getIMG(Images.pix255).draw2O(spriteBatch, n, n2 + n4 - 1 - IMGManager.getIMG(Images.pix255).getHeight() + 1, n3, 1);
        spriteBatch.setColor(Color.WHITE);
    }
    
    public boolean isOverlayEnabled() {
        sUM.sUI.requestCurrentStats();
        return false;
    }
    
    public static final void setDialogType(final DialogType dialogType) {
        CFG.dialogType = dialogType;
        CFG.menus.getDialogMenu().getMenuElem(1).setClickable(true);
        CFG.menus.getDialogMenu().getMenuElem(2).setClickable(true);
        try {
            switch (CFG.CFG$83.$SwitchMap$age$of$civilizations2$jakowski$lukasz$Z_Other$DialogType[CFG.dialogType.ordinal()]) {
                case 1: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("ExitTheGame"));
                    break;
                }
                case 2: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("PlayAs") + " " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                    break;
                }
                case 3: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("AreYouSure") + " " + CFG.lang.get("ExitToMainMenu"));
                    break;
                }
                case 4: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("AreYouSure") + " " + CFG.lang.get("ExitToMainMenu"));
                    break;
                }
                case 5: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Back") + "? " + CFG.lang.get("AreYouSure"));
                    break;
                }
                case 6: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("SendDemands"));
                    break;
                }
                case 7: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("AcceptOffer"));
                    break;
                }
                case 8: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Refuse"));
                    break;
                }
                case 9: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("AbandonProvince") + "? " + CFG.core.getProv(Menu_InGame_AbandonProvince.iProvinceID).getName());
                    break;
                }
                case 10: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("LeaveAlliance") + ": " + CFG.lang.get("HolyRomanEmpire"));
                    break;
                }
                case 11: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("DisolveAlliance") + ": " + CFG.lang.get("HolyRomanEmpire"));
                    break;
                }
                case 12: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("UniteTheAlliance") + ": " + CFG.lang.get("HolyRomanEmpire"));
                    break;
                }
                case 13: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("InviteCivilization") + ": " + CFG.lang.get("HolyRomanEmpire") + "? " + CFG.core.getCiv(getActiveCivInfoId()).getCivName());
                    break;
                }
                case 14: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("JoinAWar") + "? " + CFG.core.getCiv(CFG.core.getWar(Menu_InGame_WarDetails.WAR_ID).getAggressorID(0).getCivID()).getCivName());
                    break;
                }
                case 15: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("JoinAWar") + "? " + CFG.core.getCiv(CFG.core.getWar(Menu_InGame_WarDetails.WAR_ID).getDefenderID(0).getCivID()).getCivName());
                    break;
                }
                case 16: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Colonize"));
                    break;
                }
                case 17: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("SpectatorMode"));
                    break;
                }
                case 18: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("ExitToMainMenu"));
                    break;
                }
                case 19: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("JustOneMoreTurnIPromise"));
                    break;
                }
                case 20: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Back"));
                    break;
                }
                case 21: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("FightTheCoalition") + "? " + CFG.lang.get("DeclareWar"));
                    break;
                }
                case 22: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("ExitScenarioEditor"));
                    break;
                }
                case 23: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID).getCivName() + ". " + CFG.lang.get("TakeAll"));
                    break;
                }
                case 24: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Remove") + " " + CFG.core.getCiv(CFG.core.getProv(CFG.iCreateScenario_ActiveProvinceID).getCivId()).getCivName());
                    break;
                }
                case 25: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Select") + " " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                    break;
                }
                case 26: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Select") + " " + CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCivName());
                    break;
                }
                case 27: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("SaveScenario"));
                    break;
                }
                case 28: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Remove") + "? " + CFG.eventsManager.getEvent(CFG.eventsManager.createEvent_EditEventID).getEventName());
                    break;
                }
                case 29: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Language") + ": " + CFG.lang.get("LANGUAGENAME"));
                    break;
                }
                case 30: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Back"));
                    break;
                }
                case 31: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("SaveEvent"));
                    break;
                }
                case 32: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Surrender") + "? " + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName());
                    break;
                }
                case 33: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("FormX", CFG.lang.getCiv(CFG.formableCivs_GameData.getFormableCivTag())));
                    break;
                }
                case 34:
                case 35:
                case 36: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("DeselectAll"));
                    break;
                }
                case 37: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("NoOrders"));
                    break;
                }
                case 38: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Assimilate") + ": " + CFG.lang.get("AllProvinces"));
                    break;
                }
                case 39: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Festival") + ": " + CFG.lang.get("AllProvinces"));
                    break;
                }
                case 40: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("SpreadPropaganda") + ": " + CFG.lang.get("AllProvinces"));
                    break;
                }
                case 41: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get(BuildingsManager.getFort_Name(1)) + ": " + CFG.lang.get("AllProvinces"));
                    break;
                }
                case 42: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get(BuildingsManager.getTower_Name(1)) + ": " + CFG.lang.get("AllProvinces"));
                    break;
                }
                case 43: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get(BuildingsManager.getFarm_Name(1)) + ": " + CFG.lang.get("AllProvinces"));
                    break;
                }
                case 44: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get(BuildingsManager.getWorkshop_Name(1)) + ": " + CFG.lang.get("AllProvinces"));
                    break;
                }
                case 45: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get(BuildingsManager.getMarket_Name(1)) + ": " + CFG.lang.get("AllProvinces"));
                    break;
                }
                case 46: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get(BuildingsManager.getLibrary_Name(1)) + ": " + CFG.lang.get("AllProvinces"));
                    break;
                }
                case 47: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get(BuildingsManager.getArmoury_Name(1)) + ": " + CFG.lang.get("AllProvinces"));
                    break;
                }
                case 48: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get(BuildingsManager.getSupply_Name(1)) + ": " + CFG.lang.get("AllProvinces"));
                    break;
                }
                case 49: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get(BuildingsManager.getPort_Name(1)) + ": " + CFG.lang.get("AllProvinces"));
                    break;
                }
                case 50: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Invest") + ", " + CFG.lang.get("Economy") + ": " + CFG.lang.get("AllProvinces"));
                    break;
                }
                case 51: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Invest") + ", " + CFG.lang.get("Development") + ": " + CFG.lang.get("AllProvinces"));
                    break;
                }
                case 52: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Reverse"));
                    break;
                }
                case 53: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("SumbitOrders"));
                    break;
                }
                case 54: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("StartTheTutorial"));
                    break;
                }
                case 55: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("AreYouSure"));
                    break;
                }
                case 56: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("AreYouSure"));
                    break;
                }
                case 57:
                case 58: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("SaveTheGame"));
                    break;
                }
                case 59: {
                    try {
                        CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("StartChallenge") + ": #" + ChallengesManager.challengeList.get(ChallengesManager.START_CHALLENGE_ID).ID + " " + CFG.lang.getCiv(ChallengesManager.challengeList.get(ChallengesManager.START_CHALLENGE_ID).PLAY_AS) + " -> " + CFG.lang.getCiv(ChallengesManager.challengeList.get(ChallengesManager.START_CHALLENGE_ID).FORM_TAG));
                    }
                    catch (final Exception ex) {
                        CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Error"));
                    }
                    break;
                }
                case 60: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("RemovePlayer") + ": " + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName());
                    break;
                }
                case 61: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("BecomeAVassal"));
                    break;
                }
                case 62: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("SaveGameAsNew"));
                    break;
                }
                case 63:
                case 64: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("AllNotSavedProgressFromLastGameWillBeLostContinue"));
                    break;
                }
                case 65: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("AgeofCivilizations") + "? " + CFG.lang.get("RandomGame"));
                    break;
                }
                case 66: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Open") + " " + getwikiinforlink(CFG.EDITOR_ACTIVE_GAMEDATA_TAG));
                    break;
                }
                case 67: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Open") + " https://en.wikipedia.org/wiki/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
                    break;
                }
                case 68: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Open") + " " + CFG.GO_TO_LINK);
                    break;
                }
                case 69: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("ReleaseAVassal"));
                    break;
                }
                case 70: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("AddPlayer") + ": " + CFG.core.getCiv(getActiveCivInfoId()).getCivName());
                    break;
                }
                case 71: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("JoinAlliance") + ": " + CFG.lang.get("HolyRomanEmpire"));
                    break;
                }
                case 72: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("ShuffleCivilizations"));
                    break;
                }
                case 73: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("GenerateSuggestedCivilizations"));
                    break;
                }
                case 74: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("GeneratePreDefinedBorders"));
                    break;
                }
                case 75: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("GenerateSeaRoutes"));
                    break;
                }
                case 76: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("AreYouSure"));
                    break;
                }
                case 77: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("DeleteSavedGame"));
                    break;
                }
                case 78: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Remove") + " " + (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 + 1));
                    break;
                }
                case 79: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Remove") + " " + CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID)).getCivName());
                    break;
                }
                case 80:
                case 81: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("AreYouSure") + "? " + CFG.lang.get("Scale") + " " + CFG.map.getMapScale(CFG.map.getActiveMapIDN()) + " -> " + CFG.lang.get("Scale") + " " + CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2);
                    break;
                }
                case 82: {
                    CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Remove") + " " + CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getCivName());
                    break;
                }
                case 83: {
                    final FileHandle loadFile = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "data/cities/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
                    try {
                        CFG.editorCity = (City)deserialize(loadFile.readBytes());
                        CFG.menus.getDialogMenu().getMenuElem(3).setTextE(CFG.lang.get("Remove") + " " + CFG.editorCity.getCityName());
                    }
                    catch (final ClassNotFoundException ex2) {}
                    catch (final IOException ex3) {}
                    break;
                }
            }
        }
        catch (final IndexOutOfBoundsException ex4) {
            exceptionStack(ex4);
        }
        CFG.menus.getDialogMenu().setVisibleM(true);
    }
    
    public static final void dialog_True() {
        System.out.println("CFG.dialog_True() called. DialogType: " + String.valueOf(CFG.dialogType));
        ME_Hover_v2.resetAnimation();
        try {
            switch (CFG.CFG$83.$SwitchMap$age$of$civilizations2$jakowski$lukasz$Z_Other$DialogType[CFG.dialogType.ordinal()]) {
                case 27: {
                    System.out.println("CFG.dialog_True: Executing SAVE_SCENARIO case.");
                    CFG.core.saveScenario();
                    break;
                }
                case 1: {
                    System.out.println("CFG.dialog_True: Executing EXIT_GAME case.");
                    Gdx.app.exit();
                    break;
                }
                default: {
                    System.out.println("CFG.dialog_True: Unhandled case for DialogType: " + String.valueOf(CFG.dialogType));
                    break;
                }
            }
        }
        catch (final Exception ex) {
            System.out.println("CFG.dialog_True: Exception caught: " + ex.getMessage());
            exceptionStack(ex);
        }
    }
    
    public static final void dialog_False() {
        System.out.println("CFG.dialog_False() called. DialogType: " + String.valueOf(CFG.dialogType));
        ME_Hover_v2.resetAnimation();
        switch (CFG.CFG$83.$SwitchMap$age$of$civilizations2$jakowski$lukasz$Z_Other$DialogType[CFG.dialogType.ordinal()]) {
            case 20: {
                System.out.println("CFG.dialog_False: Executing CONTINUE_AFTER_END_GAME case.");
                if (TimelapseManager.PAUSE) {
                    CFG.timelapseManager.pauseUnpause();
                }
                return;
            }
            case 9: {
                System.out.println("CFG.dialog_False: Executing ABADON case.");
                CFG.menus.setVisibleInGame_SendMessage(false);
                return;
            }
            default: {
                System.out.println("CFG.dialog_False: Unhandled case for DialogType: " + String.valueOf(CFG.dialogType));
            }
        }
    }
    
    public static final void updateCreateScenario_Civilizations() {
        if (CFG.core.getActiveProvID() >= 0) {
            if (CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() || CFG.core.getProv(CFG.core.getActiveProvID()).getWastelandLvl() >= 0) {
                CFG.menus.getCreateScenario_Civilizations().getMenuElem(3).setClickable(false);
                CFG.menus.getCreateScenario_Civilizations().getMenuElem(4).setClickable(false);
                CFG.menus.getCreateScenario_Civilizations().getMenuElem(5).setClickable(false);
                CFG.menus.getCreateScenario_Civilizations().getMenuElem(6).setClickable(false);
                CFG.menus.setVisible_CreateScenario_Civilizations_Suggest(false);
                CFG.menus.setVisible_CreateScenario_Civilizations_Ideologies(false);
            }
            else if (CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0) {
                if (CFG.core.getProv(CFG.core.getActiveProvID()).isCapital()) {
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(3).setVisibleE(true);
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(3).setClickable(false);
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(4).setVisibleE(true);
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(4).setClickable(true);
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(5).setVisibleE(true);
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(5).setClickable(false);
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(6).setVisibleE(true);
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(6).setClickable(true);
                    CFG.menus.setVisible_CreateScenario_Civilizations_Suggest(false);
                    CFG.menus.rebuildCreateScenario_Civilizations_Ideologies();
                }
                else {
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(3).setVisibleE(true);
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(3).setClickable(true);
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(4).setVisibleE(true);
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(4).setClickable(true);
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(5).setVisibleE(true);
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(5).setClickable(true);
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(6).setVisibleE(true);
                    CFG.menus.getCreateScenario_Civilizations().getMenuElem(6).setClickable(true);
                    CFG.menus.setVisible_CreateScenario_Civilizations_Ideologies(false);
                    CFG.menus.rebuildCreateScenario_Civilizations_Suggest();
                }
            }
            else {
                CFG.menus.getCreateScenario_Civilizations().getMenuElem(3).setVisibleE(true);
                CFG.menus.getCreateScenario_Civilizations().getMenuElem(3).setClickable(true);
                CFG.menus.getCreateScenario_Civilizations().getMenuElem(4).setVisibleE(true);
                CFG.menus.getCreateScenario_Civilizations().getMenuElem(4).setClickable(false);
                CFG.menus.getCreateScenario_Civilizations().getMenuElem(5).setVisibleE(true);
                CFG.menus.getCreateScenario_Civilizations().getMenuElem(5).setClickable(false);
                CFG.menus.getCreateScenario_Civilizations().getMenuElem(6).setVisibleE(true);
                CFG.menus.getCreateScenario_Civilizations().getMenuElem(6).setClickable(false);
                CFG.menus.setVisible_CreateScenario_Civilizations_Ideologies(false);
                CFG.menus.rebuildCreateScenario_Civilizations_Suggest();
            }
        }
        else {
            CFG.menus.getCreateScenario_Civilizations().getMenuElem(3).setVisibleE(false);
            CFG.menus.getCreateScenario_Civilizations().getMenuElem(4).setVisibleE(false);
            CFG.menus.getCreateScenario_Civilizations().getMenuElem(5).setVisibleE(false);
            CFG.menus.getCreateScenario_Civilizations().getMenuElem(6).setVisibleE(false);
            CFG.menus.setVisible_CreateScenario_Civilizations_Suggest(false);
            CFG.menus.setVisible_CreateScenario_Civilizations_Ideologies(false);
        }
    }
    
    public static final String getAlliances_Random_Names_All_BundleID(final Alliances_Names_GameData alliances_Names_GameData, final int n) {
        String s = "";
        for (int i = 0; i < alliances_Names_GameData.getBundle(n).getWordsSize(); ++i) {
            s = s + alliances_Names_GameData.getBundle(n).getWord(i) + ((i < alliances_Names_GameData.getBundle(n).getWordsSize() - 1) ? ", " : "");
        }
        return s;
    }
    
    public static final String getRandomAllianceName(final Alliances_Names_GameData alliances_Names_GameData) {
        String s = "";
        try {
            for (int i = 0; i < alliances_Names_GameData.getSize(); ++i) {
                s = s + alliances_Names_GameData.getBundle(i).getWord(CFG.oR.nextInt(alliances_Names_GameData.getBundle(i).getWordsSize())) + ((i < alliances_Names_GameData.getSize() - 1) ? " " : "");
            }
        }
        catch (final IllegalArgumentException ex) {
            if (CFG.LOGs) {
                exceptionStack(ex);
            }
        }
        return s;
    }
    
    public static final void loadRandomAlliancesNames() {
        CFG.lRandomAlliancesNamesPackagesTags = new ArrayList<String>();
        try {
            final String string = FileManager.loadFile("game/alliance_names/Age_of_Civilizations.json").readString();
            final Json json = new Json();
            json.setElementType((Class)CFG.ConfigAlliancesData.class, "Data_Random_Alliance_Names", (Class)CFG.Data_Random_Alliance_Names.class);
            final CFG.ConfigAlliancesData configAlliancesData = new CFG.ConfigAlliancesData();
            for (final CFG.Data_Random_Alliance_Names data_Random_Alliance_Names : ((CFG.ConfigAlliancesData)json.fromJson((Class)CFG.ConfigAlliancesData.class, string)).Data_Random_Alliance_Names) {
                if (!data_Random_Alliance_Names.Enabled) {
                    continue;
                }
                CFG.lRandomAlliancesNamesPackagesTags.add(data_Random_Alliance_Names.Tag);
            }
        }
        catch (final GdxRuntimeException ex) {
            if (CFG.LOGs) {
                exceptionStack((Throwable)ex);
            }
        }
    }
    
    public static final boolean isIOS() {
        return Gdx.app.getType() == Application.ApplicationType.iOS;
    }
    
    public static final boolean getIsDesktop() {
        return Gdx.app.getType() == Application.ApplicationType.Desktop;
    }
    
    public static final String getRandomAllianceName(int n) {
        if (n++ > 100) {
            return "";
        }
        try {
            final Alliances_Names_GameData alliances_Names_GameData = (Alliances_Names_GameData)deserialize(FileManager.loadFile("game/alliance_names/" + (String)CFG.lRandomAlliancesNamesPackagesTags.get(CFG.oR.nextInt(CFG.lRandomAlliancesNamesPackagesTags.size()))).readBytes());
            String anObject = "";
            for (int i = 0; i < alliances_Names_GameData.getSize(); ++i) {
                anObject = anObject + alliances_Names_GameData.getBundle(i).getWord(CFG.oR.nextInt(alliances_Names_GameData.getBundle(i).getWordsSize())) + ((i == alliances_Names_GameData.getSize() - 1) ? "" : " ");
            }
            for (int j = 0; j < CFG.core.getAlliancesSize(); ++j) {
                if (CFG.core.getAlliance(j).getAllianceName().equals(anObject)) {
                    return getRandomAllianceName(n);
                }
            }
            return anObject;
        }
        catch (final Exception ex) {
            exceptionStack(ex);
            return "";
        }
    }
    
    public static final int gCARR(final int n) {
        return GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT - ((CFG.core.getProv(n).getLvlOfArmoury() > 0) ? (GameValues.gvBuildingArmoury.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT_REDUCTION * CFG.core.getProv(n).getLvlOfArmoury()) : 0);
    }
    
    public static void mvTFL(final int n, final int n2, final int n3) {
        try {
            if (CFG.core.getProv(n).getArmyCivID1(n2) <= 0) {
                CFG.toastM.addM(CFG.lang.get("Army") + ": 0", CFG.COLOR_NEGATIVE_2);
                return;
            }
            final ArrayList list = new ArrayList();
            final Civilization civ = CFG.core.getCiv(n3);
            for (int i = civ.lFrontLines.size() - 1; i >= 0; --i) {
                if (n2 == ((AI_Frontline)civ.lFrontLines.get(i)).iWithCivID) {
                    for (int j = CFG.core.getCiv(n2).lFrontLines.size() - 1; j >= 0; --j) {
                        if (((AI_Frontline)CFG.core.getCiv(n2).lFrontLines.get(j)).iWithCivID == n3) {
                            for (int k = CFG.core.getCiv(n2).lFrontLines.get(j).lProvinces.size() - 1; k >= 0; --k) {
                                if (!list.contains(CFG.core.getCiv(n2).lFrontLines.get(j).lProvinces.get(k))) {
                                    list.add(CFG.core.getCiv(n2).lFrontLines.get(j).lProvinces.get(k));
                                }
                            }
                        }
                    }
                }
                else if (n2 == CFG.core.getCiv(((AI_Frontline)civ.lFrontLines.get(i)).iWithCivID).getPuppetOfCiv()) {
                    for (int l = CFG.core.getCiv(civ.lFrontLines.get(i).iWithCivID).lFrontLines.size() - 1; l >= 0; --l) {
                        if (((AI_Frontline)CFG.core.getCiv(civ.lFrontLines.get(i).iWithCivID).lFrontLines.get(l)).iWithCivID == n3) {
                            for (int n4 = CFG.core.getCiv(civ.lFrontLines.get(i).iWithCivID).lFrontLines.get(l).lProvinces.size() - 1; n4 >= 0; --n4) {
                                if (!list.contains(CFG.core.getCiv(civ.lFrontLines.get(i).iWithCivID).lFrontLines.get(l).lProvinces.get(n4))) {
                                    list.add(CFG.core.getCiv(civ.lFrontLines.get(i).iWithCivID).lFrontLines.get(l).lProvinces.get(n4));
                                }
                            }
                        }
                    }
                }
            }
            if (list.isEmpty()) {
                CFG.toastM.addM(CFG.lang.get("Provinces") + ": 0", CFG.COLOR_NEGATIVE_2);
            }
            else {
                int armyCivID1 = CFG.core.getProv(n).getArmyCivID1(n2) / list.size();
                if (armyCivID1 <= 0) {
                    CFG.toastM.addM(CFG.lang.get("Army") + ": 0", CFG.COLOR_NEGATIVE_2);
                    return;
                }
                for (int n5 = list.size() - 1; n5 >= 0; --n5) {
                    if (n5 == 0) {
                        armyCivID1 = CFG.core.getProv(n).getArmyCivID1(n2);
                    }
                    final RegroupArmy regroupArmy;
                    if ((regroupArmy = new RegroupArmy(n2, n, (int)list.get(n5))).getRouteSize() == 1) {
                        CFG.gameAction.moveArmyAction(n, (int)list.get(n5), armyCivID1, n2, true, true);
                    }
                    else if (regroupArmy.getRouteSize() > 0) {
                        if (CFG.gameAction.moveArmyAction(n, regroupArmy.getRoute(0), armyCivID1, n2, true, true)) {
                            regroupArmy.setFromProvinceID(regroupArmy.getRoute(0));
                            regroupArmy.removeRoute(0);
                            regroupArmy.setNumOfUnits(armyCivID1);
                            CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).addRegroupArmy(regroupArmy);
                        }
                    }
                }
                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }
        }
        catch (final Exception ex) {
            exceptionStack(ex);
        }
    }
    
    public static final void editorServiceRibbon_Colors_Add() {
        if (CFG.editorServiceRibbon_Colors.size() == 0) {
            CFG.editorServiceRibbon_Colors.add(new Color(0.9843137f, 0.015686275f, 0.0f, 1.0f));
        }
        else if (CFG.editorServiceRibbon_Colors.size() == 1) {
            CFG.editorServiceRibbon_Colors.add(new Color(1.0f, 1.0f, 1.0f, 1.0f));
        }
        else if (CFG.editorServiceRibbon_Colors.size() == 2) {
            CFG.editorServiceRibbon_Colors.add(new Color(0.15294118f, 0.3019608f, 0.60784316f, 1.0f));
        }
        else if (CFG.editorServiceRibbon_Colors.size() == 3) {
            CFG.editorServiceRibbon_Colors.add(new Color(0.08627451f, 0.14901961f, 0.4509804f, 1.0f));
        }
        else {
            CFG.editorServiceRibbon_Colors.add(getRandomColor());
        }
    }
    
    public static String getLukaszJakowski() {
        if (CFG.loadedRobotoFont) {
            return "\u0141ukasz Jakowski";
        }
        return "Lukasz Jakowski";
    }
    
    public static String getLukaszJakowskiGames() {
        if (CFG.loadedRobotoFont) {
            return "\u0141ukasz Jakowski Games";
        }
        return "Lukasz Jakowski Games";
    }
    
    public static final boolean isAndroid() {
        return Gdx.app.getType() == Application.ApplicationType.Android || Gdx.app.getType() == Application.ApplicationType.iOS;
    }
    
    public static String gLI() {
        if (CFG.lRBF) {
            return CFG.jsi;
        }
        return CFG.jsiw;
    }
    
    public static String gLG() {
        if (CFG.lRBF) {
            return CFG.jsig;
        }
        return CFG.jsigw;
    }
    
    public static final String getCityLevelName(final int n) {
        switch (n) {
            case 0: {
                return CFG.lang.get("Capital");
            }
            case 1: {
                return CFG.lang.get("City");
            }
            case 2: {
                return CFG.lang.get("Town");
            }
            case 3: {
                return CFG.lang.get("Village");
            }
            case 4: {
                return CFG.lang.get("Hamlet");
            }
            default: {
                return CFG.lang.get("Hamlet");
            }
        }
    }
    
    public static String getAoHDE() {
        return "Age of History 2: Definitive Edition";
    }
    
    public static final int getEditorCityLevel(final int n) {
        switch (n) {
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
            default: {
                return Images.city2;
            }
        }
    }
    
    public static final int getCityLevel_Population(final float n, final int n2, final int n3) {
        if (n2 / n >= 0.85f + 0.2f * n3) {
            return Images.city2;
        }
        if (n2 / n >= 0.55f + 0.2f * n3) {
            return Images.city3;
        }
        if (n2 / n >= 0.325f + 0.2f * n3) {
            return Images.city4;
        }
        return Images.city5;
    }
    
    public static final int getEditorCityLevel_Ref(final int n) {
        if (n == Images.city) {
            return 0;
        }
        if (n == Images.city2) {
            return 1;
        }
        if (n == Images.city3) {
            return 2;
        }
        if (n == Images.city4) {
            return 3;
        }
        if (n == Images.city5) {
            return 4;
        }
        return 2;
    }
    
    public static String getOpinion_String(final int n) {
        if (n <= GameValues.gvDiplomacy.RELATION_AT_WAR) {
            return "";
        }
        if (n < GameValues.gvDiplomacy.DIPLOMACY_RELATION_UNFAVORABLE) {
            return CFG.lang.get("Unfavorable");
        }
        if (n < GameValues.gvDiplomacy.DIPLOMACY_RELATION_STRAINED) {
            return CFG.lang.get("Strained");
        }
        if (n < GameValues.gvDiplomacy.DIPLOMACY_RELATION_DETACHED) {
            return CFG.lang.get("Detached");
        }
        if (n < GameValues.gvDiplomacy.DIPLOMACY_RELATION_NEUTRAL) {
            return CFG.lang.get("Neutral");
        }
        if (n < GameValues.gvDiplomacy.DIPLOMACY_RELATION_WARM) {
            return CFG.lang.get("Warm");
        }
        if (n < GameValues.gvDiplomacy.DIPLOMACY_RELATION_COOPERATIVE) {
            return CFG.lang.get("Cooperative");
        }
        return CFG.lang.get("Supportive");
    }
    
    static {
        CFG.KEY_TEMP_INPUT = null;
        CFG.LOGs = true;
        CFG.DEBUG_MODE = false;
        CFG.sDEBUG = "#";
        CFG.LANDSCAPE = true;
        CFG.FONT_BOLD = 0;
        CFG.FONT_BOLD_SMALL = 1;
        CFG.FONT_REGULAR_SMALL = 2;
        CFG.sparksColors = new Color(1.0f, 1.0f, 1.0f, 0.25f);
        colorLine = new Color(0.5176471f, 0.43529412f, 0.25882354f, 0.55f);
        CFG.colorGradient = new Color(0.09803922f, 0.15686275f, 0.23529412f, 0.4f);
        CFG.colorGradientHover = new Color(0.19607843f, 0.13725491f, 0.11764706f, 0.75f);
        CFG.rotateXMoveUnits = new int[] { 0, 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 14, 14, 14, 14, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 11, 11, 11, 11, 10, 10, 10, 10, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 0, 0, -1, -1, -1, -2, -2, -2, -3, -3, -3, -4, -4, -4, -5, -5, -5, -5, -5, -6, -6, -6, -7, -7, -7, -7, -8, -8, -8, -8, -8, -8, -8, -8, -9, -9, -9, -10, -10, -11, -11, -11, -11, -12, -12, -12, -13, -13, -13, -13, -13, -13, -13, -14, -14, -14, -14, -14, -14, -14, -14, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -15, -14, -14, -14, -14, -14, -14, -13, -13, -13, -13, -13, -13, -13, -11, -11, -11, -11, -11, -11, -11, -11, -10, -10, -10, -10, -9, -9, -9, -9, -8, -8, -8, -8, -7, -7, -7, -7, -7, -7, -6, -6, -6, -5, -5, -5, -5, -5, -4, -4, -4, -3, -3, -2, -2, -1, -1, -1, -1, -1, 0, 0 };
        CFG.rotateYMoveUnits = new int[] { -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -17, -17, -17, -17, -17, -17, -18, -18, -18, -18, -18, -18, -18, -19, -19, -19, -19, -19, -19, -20, -20, -20, -20, -20, -20, -21, -21, -21, -21, -22, -22, -22, -22, -22, -22, -23, -23, -23, -23, -24, -24, -24, -24, -25, -25, -25, -25, -26, -26, -26, -27, -27, -27, -27, -28, -28, -28, -29, -29, -29, -29, -30, -30, -30, -31, -32, -32, -32, -32, -32, -32, -32, -33, -33, -34, -34, -34, -34, -34, -34, -34, -35, -36, -36, -36, -36, -36, -36, -37, -37, -37, -37, -37, -39, -39, -39, -39, -39, -39, -40, -40, -40, -40, -41, -41, -41, -42, -42, -43, -43, -43, -43, -43, -43, -44, -44, -44, -44, -44, -45, -45, -45, -45, -45, -45, -45, -45, -46, -46, -46, -46, -46, -46, -46, -46, -46, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -47, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -48, -47, -47, -47, -47, -47, -47, -47, -47, -46, -46, -46, -46, -46, -46, -46, -46, -45, -45, -45, -45, -45, -45, -45, -44, -44, -43, -43, -43, -43, -42, -42, -42, -41, -41, -41, -41, -41, -41, -41, -40, -40, -40, -40, -40, -40, -40, -40, -39, -39, -39, -39, -37, -37, -37, -37, -36, -36, -36, -36, -35, -35, -35, -34, -34, -34, -34, -34, -33, -33, -33, -33, -32, -32, -32, -32, -31, -31, -30, -30, -30, -30, -29, -29, -29, -28, -28, -28, -27, -27, -27, -26, -26, -26, -26, -25, -25, -25, -25, -25, -25, -24, -24, -24, -24, -24, -24, -23, -23, -23, -23, -23, -23, -23, -23, -22, -22, -20, -20, -20, -20, -20, -20, -20, -20, -19, -19, -19, -19, -19, -19, -19, -19, -18, -18, -18, -18, -18, -18, -18, -18, -18, -18, -18, -18, -18, -18, -17, -17, -17, -17, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16, -16 };
        CFG.rotateXMoveUnits_64 = new int[] { 0, 0, 0, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 11, 12, 13, 13, 13, 14, 14, 14, 15, 15, 16, 16, 17, 17, 18, 19, 19, 19, 20, 20, 20, 21, 21, 21, 22, 22, 22, 23, 23, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 28, 29, 29, 29, 29, 30, 30, 30, 30, 31, 31, 31, 31, 31, 31, 31, 31, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 31, 31, 31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 30, 30, 30, 30, 29, 29, 29, 29, 29, 29, 29, 28, 28, 27, 27, 26, 26, 26, 26, 26, 26, 25, 25, 25, 25, 24, 24, 24, 23, 23, 23, 22, 22, 21, 21, 20, 20, 19, 19, 18, 18, 17, 16, 16, 15, 14, 14, 13, 12, 12, 11, 10, 10, 9, 8, 8, 7, 7, 6, 6, 5, 5, 4, 4, 4, 3, 3, 2, 2, 1, 1, 0, 0, -1, -1, -2, -3, -3, -4, -5, -5, -6, -7, -7, -8, -9, -9, -9, -10, -10, -11, -12, -12, -13, -13, -14, -14, -15, -15, -15, -15, -16, -16, -16, -16, -17, -18, -18, -19, -20, -21, -21, -22, -22, -23, -23, -24, -25, -25, -25, -26, -26, -26, -26, -27, -27, -27, -28, -28, -28, -28, -28, -29, -29, -29, -29, -30, -30, -30, -30, -30, -30, -30, -30, -30, -30, -31, -31, -31, -31, -31, -31, -31, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -31, -31, -31, -31, -31, -31, -31, -31, -30, -30, -30, -30, -30, -30, -30, -30, -29, -29, -29, -29, -29, -29, -29, -28, -28, -28, -27, -27, -27, -26, -26, -25, -25, -24, -24, -23, -23, -22, -22, -22, -22, -21, -21, -21, -20, -20, -19, -19, -18, -18, -17, -17, -16, -16, -15, -15, -14, -14, -14, -13, -13, -13, -12, -12, -11, -10, -10, -10, -9, -9, -8, -8, -7, -6, -5, -4, -3, -2, -2, -1, -1, -2, 0, 0 };
        CFG.rotateYMoveUnits_64 = new int[] { -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -34, -34, -34, -34, -34, -34, -36, -36, -36, -36, -36, -36, -36, -38, -38, -38, -38, -38, -38, -40, -40, -40, -40, -40, -40, -42, -42, -42, -42, -44, -44, -44, -44, -44, -44, -46, -46, -46, -46, -48, -48, -48, -48, -50, -50, -50, -50, -52, -52, -52, -54, -54, -54, -54, -56, -56, -56, -58, -58, -58, -58, -60, -60, -60, -62, -64, -64, -64, -64, -64, -64, -64, -66, -66, -68, -68, -68, -68, -68, -68, -68, -70, -72, -72, -72, -72, -72, -72, -74, -74, -74, -74, -74, -78, -78, -78, -78, -78, -78, -80, -80, -80, -80, -82, -82, -82, -84, -84, -86, -86, -86, -86, -86, -86, -88, -88, -88, -88, -88, -90, -90, -90, -90, -90, -90, -90, -90, -92, -92, -92, -92, -92, -92, -92, -92, -92, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -94, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -96, -94, -94, -94, -94, -94, -94, -94, -94, -92, -92, -92, -92, -92, -92, -92, -92, -90, -90, -90, -90, -90, -90, -90, -88, -88, -86, -86, -86, -86, -84, -84, -84, -82, -82, -82, -82, -82, -82, -82, -80, -80, -80, -80, -80, -80, -80, -80, -78, -78, -78, -78, -74, -74, -74, -74, -72, -72, -72, -72, -70, -70, -70, -68, -68, -68, -68, -68, -66, -66, -66, -66, -64, -64, -64, -64, -62, -62, -60, -60, -60, -60, -58, -58, -58, -56, -56, -56, -54, -54, -54, -52, -52, -52, -52, -50, -50, -50, -50, -50, -50, -48, -48, -48, -48, -48, -48, -46, -46, -46, -46, -46, -46, -46, -46, -44, -44, -40, -40, -40, -40, -40, -40, -40, -40, -38, -38, -38, -38, -38, -38, -38, -38, -36, -36, -36, -36, -36, -36, -36, -36, -36, -36, -36, -36, -36, -36, -34, -34, -34, -34, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32, -32 };
        CFG.COLOR_POP_GRADIENT = new Color[] { new Color(0.8627451f, 0.93333334f, 0.78039217f, 0.5f), new Color(0.8f, 0.92941177f, 0.7372549f, 0.5f), new Color(0.6901961f, 0.89411765f, 0.59607846f, 0.5f), new Color(0.6117647f, 0.8666667f, 0.49019608f, 0.5f), new Color(0.5647059f, 0.87058824f, 0.3137255f, 0.5f), new Color(0.41568628f, 0.7921569f, 0.23529412f, 0.5f), new Color(0.37254903f, 0.7294118f, 0.19607843f, 0.5f), new Color(0.30588236f, 0.6039216f, 0.16078432f, 0.5f), new Color(0.2509804f, 0.49019608f, 0.13333334f, 0.5f), new Color(0.20392157f, 0.4f, 0.10980392f, 0.5f), new Color(0.14509805f, 0.28627452f, 0.078431375f, 0.5f) };
        CFG.COLOR_WAR_DEATHS = new Color[] { new Color(1.0f, 0.9019608f, 0.9019608f, 0.5f), new Color(1.0f, 0.8f, 0.8f, 0.5f), new Color(1.0f, 0.69803923f, 0.69803923f, 0.5f), new Color(1.0f, 0.6f, 0.6f, 0.5f), new Color(1.0f, 0.47058824f, 0.47058824f, 0.5f), new Color(0.9411765f, 0.3529412f, 0.3529412f, 0.5f), new Color(0.8627451f, 0.25490198f, 0.25490198f, 0.5f), new Color(0.7647059f, 0.1764706f, 0.1764706f, 0.5f), new Color(0.64705884f, 0.11764706f, 0.11764706f, 0.5f), new Color(0.50980395f, 0.078431375f, 0.078431375f, 0.5f), new Color(0.37254903f, 0.039215688f, 0.039215688f, 0.5f) };
        CFG.COLOR_POP_RED = new Color[] { new Color(1.0f, 0.8627451f, 0.8627451f, 0.5f), new Color(1.0f, 0.78431374f, 0.78431374f, 0.5f), new Color(1.0f, 0.6666667f, 0.6666667f, 0.5f), new Color(1.0f, 0.54901963f, 0.54901963f, 0.5f), new Color(1.0f, 0.43137255f, 0.43137255f, 0.5f), new Color(0.9019608f, 0.3137255f, 0.3137255f, 0.5f), new Color(0.8235294f, 0.23529412f, 0.23529412f, 0.5f), new Color(0.7058824f, 0.15686275f, 0.15686275f, 0.5f), new Color(0.54901963f, 0.11764706f, 0.11764706f, 0.5f), new Color(0.39215687f, 0.078431375f, 0.078431375f, 0.5f), new Color(0.27450982f, 0.039215688f, 0.039215688f, 0.5f) };
        CFG.GAMEWIDTH = 1;
        CFG.GAMEHEIGHT = 1;
        CFG.iNumOfFPS = 60;
        BG_COLOR = new Color(0.0f, 0.0f, 0.0f, 1.0f);
        COLOR_MINIMAP_BORDER = new Color(0.251f, 0.192f, 0.09f, 1.0f);
        CFG.GUI_SCALE = 1.0f;
        CFG.DENSITY = 1.0f;
        CFG.XHDPI = false;
        CFG.XXHDPI = false;
        CFG.XXXHDPI = false;
        CFG.cloudsAnimation = new CloudsManager();
        CFG.NUM_OF_PROVINCES_IN_VIEW = 0;
        CFG.NUM_OF_SEA_PROVINCES_IN_VIEW = 0;
        CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW = 0;
        CFG.NUM_OF_REGIONS_IN_VIEW = 0;
        CFG.settingsGD = new SettingsGD();
        CFG.PADD = 5;
        CFG.BUTTON_H = 68;
        CFG.BUTTON_W = 90;
        CFG.PREVIEW_HEIGHT = 194;
        CFG.CIV_COLOR_W = 3;
        CFG.CIV_NAME_BG_EXTRA_WIDTH = 8;
        CFG.CIV_NAME_BG_EXTRA_HEIGHT = 5;
        CFG.OUDH = -1;
        CFG.LPHE = new ArrayList<Integer>();
        CFG.CIV_NAME_BG_EXTRA_WIDTH_ARMY = 6;
        CFG.CIV_NAME_BG_EXTRA_HEIGHT_ARMY = 4;
        CFG.ARMY_BG_EXTRA_WIDTH = 0;
        CFG.ARMY_BG_EXTRA_HEIGHT = 2;
        CFG.ARMY_FLAG_PADDING_X = 3;
        CFG.ARMY_FLAG_PADDING_Y = 2;
        CFG.ARMY_FLAG_WIDTH = 20;
        CFG.ARMY_FLAG_HEIGHT = 10;
        COLOR_RESEARCH = new Color(0.4f, 0.6f, 0.8f, 1.0f);
        CFG.COLOR_DEVELOPMENT = new Color(0.19607843f, 0.19607843f, 0.39215687f, 1.0f);
        CFG.COLOR_POPULATION = new Color(0.23529412f, 0.47058824f, 0.2509804f, 1.0f);
        CFG.COLOR_POPULATION_HOVER = new Color(0.595f, 0.743f, 0.427f, 1.0f);
        CFG.COLOR_POPULATION_ACTIVE = new Color(0.4f, 0.51f, 0.3f, 1.0f);
        CFG.COLOR_POPULATION_GROWTHRATE_MIN = new Color(0.17254902f, 0.67058825f, 0.19607843f, 1.0f);
        CFG.COLOR_POPULATION_GROWTHRATE_MAX = new Color(0.16862746f, 0.44313726f, 0.20784314f, 1.0f);
        CFG.COLOR_HAPPINESS_MIN = new Color(0.7411765f, 0.19215687f, 0.30588236f, 1.0f);
        CFG.COLOR_HAPPINESS_MAX = new Color(0.9843137f, 0.9843137f, 0.019607844f, 1.0f);
        COLOR_RECRUITABLE_MIN = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        COLOR_RECRUITABLE_MAX = new Color(0.11764706f, 0.13725491f, 0.29411766f, 1.0f);
        CFG.COLOR_REVOLUTION_MIN = new Color(0.8235294f, 0.5882353f, 0.29411766f, 1.0f);
        CFG.COLOR_REVOLUTION_MIN_0 = new Color(0.09019608f, 0.39215687f, 0.078431375f, 0.25f);
        CFG.COLOR_REVOLUTION_MAX = new Color(0.50980395f, 0.13725491f, 0.078431375f, 1.0f);
        CFG.COLOR_PROVINCE_STABILITY_MIN = new Color(0.5686275f, 0.13725491f, 0.09803922f, 1.0f);
        CFG.COLOR_TEXT_PROVINCE_STABILITY_MIN_0 = new Color(0.09019608f, 0.39215687f, 0.078431375f, 0.25f);
        CFG.COLOR_PROVINCE_STABILITY_MAX = new Color(0.23529412f, 0.49019608f, 0.11764706f, 1.0f);
        COLOR_DISTANCE_MIN = new Color(0.8627451f, 0.84313726f, 0.1764706f, 1.0f);
        COLOR_DISTANCE_MAX = new Color(0.43137255f, 0.09803922f, 0.09803922f, 1.0f);
        COLOR_TEXT_HAPPINESS_HOVER = new Color(0.99607843f, 0.5137255f, 0.007843138f, 1.0f);
        COLOR_TEXT_HAPPINESS_ACTIVE = new Color(0.9843137f, 0.6901961f, 0.003921569f, 1.0f);
        COLOR_TEXT_CHECKBOX_TRUE = new Color(0.55f, 0.8f, 0.0f, 0.25f);
        COLOR_TEXT_CHECKBOX_FALSE = new Color(0.8f, 0.137f, 0.0f, 0.25f);
        CFG.COLOR_ECONOMY = new Color(0.776f, 0.518f, 0.227f, 1.0f);
        CFG.COLOR_ECONOMY_HOVER = new Color(0.708f, 0.448f, 0.173f, 1.0f);
        CFG.COLOR_ECONOMY_ACTIVE = new Color(0.552f, 0.36f, 0.141f, 1.0f);
        CFG.COLOR_TECHNOLOGY = new Color(0.8f, 0.8f, 0.8f, 1.0f);
        CFG.COLOR_TEXT_CIV_INFO = new Color(0.40392157f, 0.41960785f, 0.43137255f, 1.0f);
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
        CFG.COLOR_NEW_GAME_EDGE_LINE = new Color(0.1882353f, 0.18431373f, 0.16862746f, 1.0f);
        CFG.COLOR_FLAG_FRAME = new Color(0.1882353f, 0.18431373f, 0.16862746f, 1.0f);
        CFG.COLOR_NEW_GAME_EDGE_LINE2 = new Color(0.3882353f, 0.34117648f, 0.19607843f, 1.0f);
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
        CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS = new Color(0.4509804f, 0.32941177f, 0.10980392f, 1.0f);
        CFG.COLOR_GRADIENT_DARK_BLUE = new Color(0.05490196f, 0.07058824f, 0.10980392f, 0.75f);
        CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE = new Color(0.043137256f, 0.101960786f, 0.15686275f, 0.75f);
        CFG.COLOR_GRADIENT_DIPLOMACY = new Color(0.13333334f, 0.18039216f, 0.25490198f, 0.75f);
        CFG.COLOR_NEGATIVE_1 = new Color(0.98039216f, 0.15686275f, 0.15686275f, 1.0f);
        CFG.COLOR_NEGATIVE_2 = new Color(0.7490196f, 0.18431373f, 0.14117648f, 1.0f);
        COLOR_NEGATIVE_HOVER = new Color(0.70980394f, 0.17254902f, 0.1254902f, 1.0f);
        COLOR_NEGATIVE_ACTIVE = new Color(0.6509804f, 0.14117648f, 0.09411765f, 1.0f);
        CFG.COLOR_NEUTRAL = new Color(0.8f, 0.8f, 0.8f, 1.0f);
        CFG.COLOR_NEUTRAL2 = new Color(0.8627451f, 0.78431374f, 0.27450982f, 1.0f);
        CFG.COLOR_POSITIVE = new Color(0.007843138f, 0.5176471f, 0.011764706f, 1.0f);
        COLOR_POSITIVE_HOVER = new Color(0.003921569f, 0.4509804f, 0.007843138f, 1.0f);
        COLOR_POSITIVE_ACTIVE = new Color(0.003921569f, 0.4f, 0.007843138f, 1.0f);
        COLOR_POSITIVE_BUILT = new Color(0.13333334f, 0.54509807f, 0.13333334f, 1.0f);
        COLOR_FREE_MOVE = new Color(0.8980392f, 0.9254902f, 0.02745098f, 1.0f);
        COLOR_FREE_MOVE_ACTIVE = new Color(0.6745098f, 0.68235296f, 0.007843138f, 1.0f);
        COLOR_FREE_MOVE_HOVER = new Color(0.7607843f, 0.7764706f, 0.015686275f, 1.0f);
        CFG.COLOR_PROVINCE_VALUE = new Color(0.784f, 0.588f, 0.196f, 1.0f);
        CFG.COLOR_PROVINCE_VALUE_HOVER = new Color(0.668f, 0.473f, 0.152f, 1.0f);
        CFG.COLOR_PROVINCE_VALUE_ACTIVE = new Color(0.605f, 0.414f, 0.132f, 1.0f);
        COLOR_TEXT_GREEN = new Color(0.173f, 0.671f, 0.196f, 1.0f);
        COLOR_TEXT_CNG_TOP_SCENARIO_NAME = new Color(0.9f, 0.9f, 0.9f, 1.0f);
        COLOR_TEXT_CNG_TOP_SCENARIO_NAME_HOVER = new Color(0.78f, 0.78f, 0.78f, 1.0f);
        COLOR_TEXT_CNG_TOP_SCENARIO_INFO = new Color(0.56f, 0.56f, 0.56f, 1.0f);
        CFG.COLOR_TEXT_GRAY_NS = new Color(0.7372549f, 0.7490196f, 0.7647059f, 1.0f);
        CFG.COLOR_TEXT_GRAY_NS_HOVER = new Color(0.57254905f, 0.58431375f, 0.5921569f, 1.0f);
        CFG.COLOR_TEXT_GRAY_NS_ACTIVE = new Color(0.5019608f, 0.5137255f, 0.5294118f, 1.0f);
        CFG.COLOR_TEXT_GRAY_LEFT_NS = new Color(0.8392157f, 0.8392157f, 0.8392157f, 1.0f);
        CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER = new Color(0.7137255f, 0.7137255f, 0.7137255f, 1.0f);
        CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE = new Color(0.6509804f, 0.6509804f, 0.6509804f, 1.0f);
        COLOR_STARTINGMONEY_MIN = new Color(0.6f, 0.20392157f, 0.023529412f, 1.0f);
        COLOR_STARTINGMONEY_0 = new Color(0.84705883f, 0.9411765f, 0.6509804f, 1.0f);
        COLOR_STARTINGMONEY_MAX = new Color(0.1254902f, 0.5254902f, 0.27058825f, 1.0f);
        COLOR_BUTTON_MENU_HOVER_BG = new Color(1.0f, 1.0f, 1.0f, 0.9f);
        COLOR_BUTTON_MENU_ACTIVE_BG = new Color(1.0f, 1.0f, 1.0f, 0.8f);
        CFG.COLOR_BUTTON_MENU_TEXT = new Color(0.82f, 0.82f, 0.82f, 1.0f);
        CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE = new Color(0.78f, 0.78f, 0.78f, 0.4f);
        CFG.COLOR_BUTTON_MENU_TEXT_HOVERED = new Color(0.71f, 0.715f, 0.72f, 1.0f);
        CFG.COLOR_BUTTON_MENU_TEXT_ACTIVE = new Color(0.1f, 0.1f, 0.1f, 1.0f);
        CFG.COLOR_BUTTON_GAME_TEXT = new Color(0.376f, 0.388f, 0.376f, 1.0f);
        CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE = new Color(0.674f, 0.09f, 0.066f, 0.5f);
        CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE = new Color(0.941f, 1.0f, 0.0f, 1.0f);
        CFG.COLOR_HOVER_TITLE = new Color(0.768f, 0.608f, 0.263f, 1.0f);
        CFG.COLOR_BUTTON_GAME_TEXT_HOVERED = new Color(0.445f, 0.445f, 0.445f, 1.0f);
        CFG.COLOR_BTN_M = new Color(0.38f, 0.38f, 0.38f, 1.0f);
        CFG.COLOR_BTN_M_NOT_CLICKABLE = new Color(0.49f, 0.49f, 0.49f, 0.5f);
        CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT = new Color(0.548f, 0.562f, 0.548f, 1.0f);
        CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_HOVER = new Color(0.665f, 0.682f, 0.665f, 1.0f);
        CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT_ACTIVE = new Color(0.78f, 0.78f, 0.78f, 1.0f);
        CFG.COLOR_TEXT_NUM_OF_PROVINCES = new Color(0.8039216f, 0.59607846f, 0.0f, 1.0f);
        COLOR_TEXT_GOLDEN_AGE = new Color(0.9882353f, 0.8117647f, 0.2509804f, 1.0f);
        CFG.COLOR_GRADIENT_BLUE = new Color(0.14117648f, 0.1882353f, 0.27450982f, 0.775f);
        COLOR_MESSAGE_TITLE = new Color(0.2f, 0.6f, 0.4f, 0.775f);
        COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE = new Color(0.0f, 0.21960784f, 0.61960787f, 0.775f);
        CFG.COLOR_GRADIENT_MENU_BLUE = new Color(0.03529412f, 0.050980393f, 0.12941177f, 0.85f);
        CFG.reverseDirectionX = true;
        CFG.reverseDirectionY = true;
        CFG.DIFFICULTY = 1;
        CFG.FOG_OF_WAR = 1;
        CFG.FILL_THE_MAP = true;
        CFG.RANDOM_PLACEMENT = false;
        CFG.RANDOM_FILL = false;
        CFG.SANDBOX_MODE = false;
        CFG.SANDBOX_MODE_AI = false;
        CFG.PXSX = false;
        CFG.SPECTATOR_MODE = false;
        CFG.SPECTATOR_MODE_LOCK_CIV = false;
        CFG.SPECTATOR_MODE_DECLARE_WAR_MODE = -1;
        CFG.SPECTATOR_MODE_DIPLOMACY_ACTIONS_MODE = false;
        CFG.MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI = false;
        CFG.RECRUIT_AND_COUNTERATTACK = false;
        CFG.SAVED_GAME_LOADED = false;
        CFG.SAVED_GAME_LOADED_2 = false;
        CFG.TOTAL_WARMODE = false;
        CFG.AGE_OF_CHAOS_MODE = false;
        CFG.AGE_OF_CHAOS_TURNS = 50;
        CFG.AGE_OF_CHAOS_CIVS = 4;
        CFG.ENABLE_NUKES = true;
        CFG.LEADERS_CAN_DIE = false;
        CFG.USE_NEW_DECLARE_WAR_SYSTEM = true;
        CFG.USE_OLD_DECLARE_WAR_CHANGE_100 = 0;
        CFG.MAX_PROVINCES_FOR_ALLIANCE_PROPOSAL = 20;
        CFG.PROPOSE_ALLIANCE_CHANCE_100 = 62;
        CFG.ARMY_RETREAT = 0.0f;
        CFG.CAPITULATION = 0.26f;
        CFG.GET_SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_CHANCE_1000 = 58;
        CFG.COLONIZATION_AUTO_EXPAND_CHANCE = 100;
        CFG.NUKES_MIN_YEAR_ENABLED = true;
        CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS = 4;
        CFG.AI_UNIONS_ENABLED = false;
        CFG.AI_CONQUER_VASSALS = false;
        CFG.AI_VASSALS_CAN_DECLARE_WARS = false;
        CFG.AI_CONQUER_OWN_VASSALS_IF_OVER = 50;
        CFG.MOVEMENT_POINTS_EXTRA = 0;
        CFG.MOVEMENT_POINTS_MAX_MODIFIER = 1.5f;
        CFG.DIPLOMACY_POINTS_EXTRA = 0;
        CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE = 100;
        CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK = 110;
        CFG.ASSIMILATION_SPEED_MODIFIER = 1.0f;
        CFG.POPULATION_GROWTH_RATE = 1.0f;
        CFG.ECONOMY_GROWTH_RATE = 1.0f;
        CFG.PEACE_TREATY_VICTORY_POINTS_MODIFIER = 1.0f;
        CFG.BUILD_NUKES_EXTRA_COST = 0;
        CFG.NUKES_REQUIRED_TECH_LVL = 0.75f;
        CFG.PLUNDER_MODIFIER = 1.0f;
        CFG.AI_PLUNDER_ENABLED = true;
        CFG.VASSALS_CAN_DECLARE_INDEPENDENCE = true;
        CFG.ASSIMILATION_COST_MODIFIER = 1.0f;
        CFG.AGE_OF_CHAOS_CIVS_LIST = new ArrayList<Integer>();
        CFG.REBELS_POWER = 1.5f;
        CFG.MIN_ARMY_REQUIRED_TO_ATTACK = 19;
        RANDOM_CIVILIZATION_COLOR = new Color(0.03f, 0.03f, 0.05f, 1.0f);
        CFG.PLAYER_TURN_ID = 0;
        CFG.regroupArmyMode = false;
        CFG.chosenProvinces_Regroup = new ArrayList<Integer>();
        CFG.chooseProvinceMode = false;
        CFG.chosenProvinceID = -1;
        CFG.migrateMode = false;
        CFG.chooseProvinceMode_BEFORE = false;
        CFG.activeProvince_BEFORE = -1;
        CFG.activeCivilizationArmyID = 0;
        CFG.VIEW_SHOW_VALUES = true;
        CFG.SCENARIO_EDITOR_OCCUPATION = false;
        CFG.SHOW_ALL_MOVES = false;
        CFG.SHOW_ONLY_COMBAT_MOVES = true;
        CFG.RANDOM_CIVILIZATION = null;
        CFG.topBox = new CFG.TopBox();
        CFG.sLoading = "Loading";
        CFG.sVERSION = "Version";
        CFG.sAUTHOR = null;
        CFG.oR = new Random();
        CFG.sLoadingText = "";
        CFG.iLoadingTextWidth = 0;
        CFG.loadingTime = 0L;
        CFG.LOADING_TEXT_FONT_SCALE = 0.7f;
        CFG.iDXW = 0;
        CFG.activeCivInfoId = 0;
        CFG.activeCivFlag = null;
        CFG.activeCivLeader = new ArrayList<Image>();
        CFG.leaderFrameID = 0;
        CFG.leaderFrameSize = 0;
        CFG.leaderTime = 0L;
        CFG.leaderFrame = 50L;
        CFG.loadedLeader = "";
        CFG.CIV_INFO_MENU_WIDTH = 320;
        CFG.pNCI = new ArrayList<Integer>();
        CFG.pNC = new ArrayList<String>();
        CFG.cNCI = new ArrayList<Integer>();
        CFG.cNC = new ArrayList<String>();
        CFG.province_CoresGD = null;
        CFG.formableCivs_GameData = null;
        CFG.leaderGameData = null;
        CFG.editorLine_GameData = null;
        CFG.editor_Region_GameData = null;
        CFG.editor_Continent_GameData = null;
        CFG.EDITOR_ACTIVE_GAMEDATA_TAG = null;
        CFG.GO_TO_LINK = "";
        CFG.editor_Package_ContinentsData = null;
        CFG.editor_Package_RegionsData = null;
        CFG.CREATE_PACKAGE_CONTINENT_GAME_DATA_TAG = null;
        COLOR_BUTTON_EXTRA_DESCRIPTION = new Color(1.0f, 1.0f, 1.0f, 0.4f);
        CFG.COLOR_GROWTH_RATE = new Color[] { new Color(1.0f, 0.9764706f, 0.64705884f, 0.5f), new Color(0.99607843f, 0.9607843f, 0.0f, 0.5f), new Color(0.99607843f, 0.8901961f, 0.0f, 0.5f), new Color(0.99607843f, 0.7490196f, 0.0f, 0.5f), new Color(0.99607843f, 0.60784316f, 0.0f, 0.5f), new Color(0.99607843f, 0.42352942f, 0.0f, 0.5f), new Color(0.99607843f, 0.23529412f, 0.0f, 0.5f), new Color(0.8627451f, 0.0f, 0.0f, 0.5f), new Color(0.54901963f, 0.0f, 0.0f, 0.5f), new Color(0.39215687f, 0.0f, 0.0f, 0.5f), new Color(0.3137255f, 0.0f, 0.0f, 0.5f) };
        COLOR_PROVINCE_ARMY_MIN = new Color(0.7058824f, 0.7058824f, 0.78431374f, 0.575f);
        COLOR_PROVINCE_ARMY_MAX = new Color(0.96862745f, 0.9372549f, 0.39215687f, 0.575f);
        CFG.MAX_PROVINCE_VALUE = 10;
        CFG.COLOR_ECONOMY_GRADIENT = new Color[] { new Color(1.0f, 0.92156863f, 0.8f, 0.5f), new Color(1.0f, 0.83137256f, 0.65882355f, 0.5f), new Color(1.0f, 0.77254903f, 0.56078434f, 0.5f), new Color(1.0f, 0.7294118f, 0.47843137f, 0.5f), new Color(1.0f, 0.63529414f, 0.3254902f, 0.5f), new Color(0.96862745f, 0.54509807f, 0.19215687f, 0.5f), new Color(0.9411765f, 0.4627451f, 0.019607844f, 0.5f), new Color(0.88235295f, 0.3882353f, 0.0627451f, 0.5f), new Color(0.7921569f, 0.24313726f, 0.02745098f, 0.5f), new Color(0.7137255f, 0.09803922f, 0.015686275f, 0.5f), new Color(0.654902f, 0.08627451f, 0.011764706f, 0.5f) };
        CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL = 0.45f;
        CFG.COLOR_TECHNOLOGY_LEVEL = new Color[] { new Color(0.94509804f, 0.95686275f, 1.0f, CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.8784314f, 0.8784314f, 0.9647059f, CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.79607844f, 0.8039216f, 1.0f, CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.7019608f, 0.7137255f, 0.9019608f, CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.6117647f, 0.627451f, 0.9411765f, CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.49803922f, 0.5176471f, 0.9529412f, CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.34901962f, 0.38039216f, 0.9019608f, CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.21960784f, 0.2509804f, 0.8509804f, CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.07450981f, 0.101960786f, 0.5803922f, CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.05490196f, 0.08235294f, 0.52156866f, CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL), new Color(0.043137256f, 0.07058824f, 0.43137255f, CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL) };
        CFG.iLOAH = 0;
        CFG.loaTM = 0L;
        CFG.sLOATXT = "";
        CFG.iLOADW = 0;
        CFG.PRT = 0L;
        CFG.ALPHA_DIPLOMACY = 0.35f;
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
        CFG.PROVINCE_BORDER_THICKNESS = 1;
        CFG.PROVINCE_BORDER_DASHED_THICKNESS = 1;
        COLOR_PROVINCE_BORDER_CIV_REGION = new Color(0.9411765f, 0.7529412f, 0.15294118f, 1.0f);
        CFG.COLOR_PROVINCE_DASHED = new Color(0.04f, 0.04f, 0.04f, 0.64705884f);
        CFG.COLOR_PROVINCE_SEABYSEA = new Color(0.94f, 0.94f, 0.95f, 0.07f);
        CFG.COLOR_PROVINCE_STRAIGHT = new Color(0.0f, 0.0f, 0.0f, 1.0f);
        CFG.COLOR_PROVINCE_STRAIGHT2 = new Color(0.0f, 0.0f, 0.0f, 0.3f);
        CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER = new Color(1.0f, 0.91764706f, 0.015686275f, 1.0f);
        CFG.backToMenu = View.eMAINMENU;
        CFG.goToMenu = View.eMAINMENU;
        CFG.goToMenu2 = View.eMAINMENU;
        CFG.CREATE_SCENARIO_GAME_DATA_TAG = null;
        CFG.CREATE_SCENARIO_IS_PART_OF_CAMPAIGN = false;
        CFG.lCREATE_SCENARIO_IS_PART_OF_CAMPAIGN_CIVSIDS = new ArrayList<Integer>();
        CFG.CREATE_SCENARIO_NAME = "";
        CFG.CREATE_SCENARIO_AUTHOR = "";
        CFG.CREATE_SCENARIO_WIKI = "";
        CFG.CREATE_SCENARIO_AGE = 0;
        CFG.createScenarioAssignProvsCiv = -1;
        CFG.RELOAD_SCENARIO = false;
        CFG.chosenAlphabetCharachter = null;
        CFG.sSearch = null;
        CFG.bSetWasteland_AvailableProvinces = true;
        CFG.iNumOfAvailableProvinces = 0;
        CFG.iNumOfAvailableProvincesWidth = 0;
        CFG.iNumOfWastelandProvinces = 0;
        CFG.iNumOfWastelandProvincesWidth = 0;
        CFG.flagOfCivilizationH = new ArrayList<Image>();
        CFG.MANAGE_DIPLOMACY_DRAW_HELP_LINE = true;
        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = 1;
        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID = 1;
        CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID2 = 0;
        CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
        CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
        CFG.sAtWar = null;
        CFG.reportData = null;
        CFG.flagManager = new FlagManager();
        CFG.randomGameManager = null;
        CFG.timelapseManager = new TimelapseManager();
        CFG.tutorialManager = new TutorialManager();
        CFG.peaceTreatyData = new PeaceTreaty_Data();
        CFG.hreMgr = null;
        CFG.unionFlagsToGenerate_Manager = new UnionFlagsToGenerate_Manager();
        CFG.createVassalData = null;
        CFG.tradeRequest = new TradeRequest_GameData();
        CFG.ultimatum = new Ultimatum_GameData();
        CFG.brushMode = false;
        CFG.selectMode = true;
        CFG.COLOR_CITY_NAME = new Color(0.9137255f, 0.9137255f, 0.9137255f, 0.85f);
        CFG.glyphLay = new GlyphLayout();
        CFG.glyphLayoutMoveUnits2 = new GlyphLayout();
        CFG.glyphLayoutMoveUnits = new GlyphLayout();
        CFG.glyphLayoutArmy = new GlyphLayout();
        CFG.fontMain = new ArrayList<BitmapFont>();
        CFG.fontArmy = null;
        CFG.fontBorder = null;
        CFG.fontBorder2 = null;
        CFG.lRBF = false;
        CFG.ARMY_HEIGHT = 1;
        CFG.TEXT_HEIGHT_DEFAULT = 1;
        CFG.TEXT_HEIGHT_DEFAULT_SMALL = 1;
        CFG.iProvinceNameWidth = -1;
        COLOR_ARMYBG = new Color(0.0f, 0.0f, 0.0f, 0.8f);
        COLOR_ARMY_CAPITAL_BG = new Color(0.0f, 0.0f, 0.0f, 1.0f);
        COLOR_ARMY_BG_ACTIVE = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        COLOR_ARMY_BG_SEA = new Color(0.05490196f, 0.1254902f, 0.23529412f, 1.0f);
        COLOR_ARMY_BG_ALLIANCE = new Color(0.019607844f, 0.09803922f, 0.1764706f, 1.0f);
        COLOR_ARMY_TEXT_ALLIANCE = new Color(0.98039216f, 0.99607843f, 0.99607843f, 1.0f);
        COLOR_ARMY_BG_VASSAL = new Color(0.078431375f, 0.23529412f, 0.10980392f, 1.0f);
        COLOR_ARMY_BG_MOVEUNITS = new Color(0.129f, 0.078f, 0.063f, 0.9f);
        CFG.COLOR_ARMY_TEXT = new Color(0.88235295f, 0.88235295f, 0.27450982f, 1.0f);
        CFG.COLOR_ARMY_TEXT_ACTIVE = new Color(0.12156863f, 0.12156863f, 0.12156863f, 1.0f);
        COLOR_ARMY_TEXT_ACTIVE_NON_PLAYER = new Color(0.88235295f, 0.88235295f, 0.27450982f, 1.0f);
        CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE = new Color(0.99215686f, 0.99607843f, 0.99607843f, 1.0f);
        CFG.COLOR_ARMY_TEXT_SEA = new Color(0.8235294f, 0.8235294f, 0.8235294f, 1.0f);
        CFG.COLOR_ARMY_TEXT_SEA_ACTIVE = new Color(0.5294118f, 0.54901963f, 0.5686275f, 1.0f);
        CFG.COLOR_GOLD = new Color(0.87058824f, 0.85882354f, 0.12941177f, 1.0f);
        COLOR_GOLD_HOVER = new Color(0.75686276f, 0.75686276f, 0.0f, 1.0f);
        COLOR_GOLD_ACTIVE = new Color(0.6901961f, 0.6901961f, 0.0f, 1.0f);
        CFG.COLOR_MOVEMENT = new Color(0.25882354f, 0.68235296f, 0.9019608f, 1.0f);
        COLOR_MOVEMENT_HOVER = new Color(0.2f, 0.6f, 0.8f, 1.0f);
        COLOR_MOVEMENT_ACTIVE = new Color(0.16862746f, 0.5411765f, 0.69803923f, 1.0f);
        CFG.COLOR_MOVEMENT_ZERO = new Color(0.7490196f, 0.18431373f, 0.14117648f, 1.0f);
        COLOR_MOVEMENT_ZERO_HOVER = new Color(0.6431373f, 0.10980392f, 0.08235294f, 1.0f);
        COLOR_MOVEMENT_ZERO_ACTIVE = new Color(0.56078434f, 0.06666667f, 0.050980393f, 1.0f);
        CFG.COLOR_DIPLOMACY_POINTS = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        COLOR_DIPLOMACY_POINTS_HOVER = new Color(0.7882353f, 0.7882353f, 0.8f, 1.0f);
        COLOR_DIPLOMACY_POINTS_ACTIVE = new Color(0.7529412f, 0.7529412f, 0.7529412f, 1.0f);
        COLOR_BG_GAME_MENU_SHADOW = new Color(0.0f, 0.0f, 0.0f, 0.65f);
        CFG.keybMess = "";
        CFG.CIV_FLAG_WIDTH = 27;
        CFG.CIV_FLAG_HEIGHT = 18;
        CFG.FLIP_Y_CIV_FLAG = false;
        CFG.FLIP_Y_CIV_FLAG_COUNTER = 0;
        CFG.flagEditorMode = CFG.FlagEditorMode.PENCIL;
        CFG.COLOR_BOX_GRADIENT = new Color(0.14901961f, 0.17254902f, 0.23529412f, 1.0f);
        CFG.jsi = "\u0141ukasz Jakowski";
        CFG.iAgeOfCivilizationsWidth = -1;
        CFG.append = false;
        CFG.appendNum = 0;
        CFG.jsig = "\u0141ukasz Jakowski Games";
        CFG.randomProvinceNames = new ArrayList<String>();
        CFG.numGold = 1;
        CFG.numSilver = 1;
        CFG.numBronze = 1;
        CFG.dialogType = DialogType.EXIT_GAME;
        CFG.iSelectCivilizationPlayerID = 0;
        CFG.editorAlliancesNames_GameData = null;
        CFG.EDIT_ALLIANCE_NAMES_BUNDLE_ID = 0;
        CFG.CREATE_PACKAGE_ALLIANCE_NAMES_GAME_DATA_TAG = null;
        CFG.achievementGD = null;
        CFG.loadedRobotoFont = true;
        CFG.SERVICE_RIBBON_WIDTH = 58;
        CFG.SERVICE_RIBBON_HEIGHT = 16;
        CFG.jsiw = "Lukasz Jakowski";
        CFG.jsigw = "Lukasz Jakowski Games";
    }
}
