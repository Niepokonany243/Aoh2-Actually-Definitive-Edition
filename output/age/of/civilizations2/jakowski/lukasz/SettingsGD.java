
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import java.io.Serializable;

public class SettingsGD
implements Serializable {
    private static final long serialVersionUID = 0L;
    public String LANG_TAG = null;
    public int FONT_MAIN_SIZEX = -1;
    public int FONT_BORDER_SIZEX = 72;
    public int FONT_ARMY_SIZEX = -1;
    public float VOLUME_MUSIC = 0.4f;
    public float VOLUME_SOUNDS = 0.55f;
    public float VOLUME_MASTER = 1.0f;
    public int FONT_BORDER_WIDTH = 1;
    public int PROV_ALPHA = 100;
    public int OCCUPIED_PROV_ALPHA = 100;
    public float OCCUPIED_STRIPES_SIZE = 2.0f;
    public boolean ENABLE_INNERBORDERS = true;
    public boolean DRAW_MOVE_UNITS_ARMY_IN_EVERYSINGLE_PROVINCE = true;
    public boolean CONFIRM_END_TURN = false;
    public boolean CONFIRM_NO_ORDERS = false;
    public boolean CONFIRM_NEXT_PLAYER_TURN = true;
    public boolean DRAW_CIVILIZATIONS_NAMES_OVER_PROVINCES_IN_GAME = true;
    public int PERCENTAGE_OF_CITIES_ON_MAP = 22;
    public int TURNS_BETWEEN_AUTOSAVEX = 200;
    public boolean CONTINUOUS_RENDERING = true;
    public float CITIES_FONT_SCALE = 0.35f;
    public final int CITIES_DEFAULT_FONT_SIZE = 10;
    public Color_GameData civNamesFontColor = new Color_GameData(0.0f, 0.0f, 0.0f);
    public float civNamesFontColor_ALPHA = 0.85f;
    public Color_GameData civNamesFontColorBorder = new Color_GameData(0.58f, 0.58f, 0.58f);
    public float civNamesFontColorBorder_ALPHA = 0.45f;
    public float CIV_NAMES_MIN_SCALE_OF_FONT = 0.3f;
    public int CIVILIZATIONS_NAMES_INTERVAL = 1000;
    public Color_GameData COLOR_PROVINCE_BG_WASTELAND = new Color_GameData(0.7882353f, 0.64705884f, 0.5137255f);
    public float PROVINCE_ALPHA_WASTELAND = 0.2f;
    public Color_GameData COLOR_PROVINCE_DISCOVERY = new Color_GameData(0.039215688f, 0.039215688f, 0.11764706f);
    public float COLOR_PROVINCE_DISCOVERY_ALPHA = 0.11764706f;
    public float[] COLOR_DISCOVERY_FLOAT = new float[]{0.039215688f, 0.039215688f, 0.11764706f, 0.11764706f};
    public String sMoveLine = "default";
    public String sHighlightLine = "62";
    public float STOP_SCALING_ARMY = 20.0f;
    public float STOP_SCALING_ARMY_MOBILE = 2.0f;
    public boolean showNextPlayerView = false;
    public boolean showOrderOfMovesView = false;
    public boolean loadCursor = false;
    public boolean gameRated = false;
    public boolean randomLeaders = false;
    public int BORDER_EXTRA_WIDTH = 0;
    public float PROVINCE_NAMES_ALPHA = 0.45f;
    public int SPROVN = 2;
    public float PROVINCE_NAMES_SCALE = 0.06f;
    public boolean EDGE_SCROLLING = false;
    public boolean CLOUDS = true;
    public int SHORTEN_ARMY_OVER = 1000;
    public boolean SHOW_COMBAT_MOVEMENT = true;
    public boolean SHOW_BATTLE_REPORT = false;
    public boolean BETTER_UI = true;
    public boolean DISABLE_INFLATION = true;
    public boolean MISSILES = true;
    public boolean ANNEXATION_DELAY = true;
    public int ANNEXATION_DELAY_TURNS = 5;
    public boolean AIR_DEFENCE_SYSTEMS = true;
    public boolean BAT_PLUS = true;
    public float BAT_PLUS_BREAKTHROUGH_RATIO = 50.0f;
    public int UI_THEME = 0; 
    public boolean EXPERIMENTAL_BATTLE_SYSTEM = true;
    public boolean CAPITAL_FLAGS_HIGH = true;
    public boolean ANDROID_LOAD_MAP_OVERLAYS = false;
    public int SHIPS_ON_MAP = 10;
    public int LOAD_CIVS_SPEED = 2;
    public int LOAD_PROVINCES_SPEED = 2;
    public int SAVE_CIVS_SPEED = 2;
    public int SAVE_PROVINCES_SPEED = 2;
    public boolean USE_OLD_PROVINCE_BORDER = false;
    public int MENU_EXTRA_LEFT = 0;
    public boolean DRAW_WAR_ON_MAP = true;
    public boolean DRAW_2_ON_MAP = true;
    public boolean DRAW_3_ON_MAP = true;
    public boolean DRAW_4_ON_MAP = true;
    public boolean DRAW_5_ON_MAP = true;
    public float BORDER_EXTRA_THICKNESS = 0.0f;
    public Color_GameData borderStraight = new Color_GameData(0.04f, 0.04f, 0.04f);
    public Color_GameData borderDashed = new Color_GameData(0.0f, 0.0f, 0.0f);
    public boolean AI_GROUP_UNITS = false;
    public boolean DISABLE_AI_INVESTING = true;
    public int ARMY_VISIBILITY_RANGE = 3; 
    public int ARMY_ICON_SCALE = 1; 

    public final float getArmyIconFactor() {
        switch (this.ARMY_ICON_SCALE) {
            case 0: { return 0.25f; }
            case 1: { return 0.5f; }
            case 2: { return 0.75f; }
        }
        return 1.0f;
    }

    public final void updateCitiesFontScale() {
        this.CITIES_FONT_SCALE = 10.0f / (float)this.FONT_MAIN_SIZEX;
    }

    public final void updateDiscoveryFloat() {
        this.COLOR_DISCOVERY_FLOAT[0] = this.COLOR_PROVINCE_DISCOVERY.getR();
        this.COLOR_DISCOVERY_FLOAT[1] = this.COLOR_PROVINCE_DISCOVERY.getG();
        this.COLOR_DISCOVERY_FLOAT[2] = this.COLOR_PROVINCE_DISCOVERY.getB();
        this.COLOR_DISCOVERY_FLOAT[3] = this.COLOR_PROVINCE_DISCOVERY_ALPHA;
    }
}

