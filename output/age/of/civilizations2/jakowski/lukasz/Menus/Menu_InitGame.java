
package age.of.civilizations2.jakowski.lukasz.Menus;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.AI.AI;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.EventTemplatesMGR;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Game.GameUpdate;
import age.of.civilizations2.jakowski.lukasz.FormableRestrictions;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameAges;
import age.of.civilizations2.jakowski.lukasz.GameN;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_CircleDraw;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryManager;
import age.of.civilizations2.jakowski.lukasz.HolyRomanEmpire_Manager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.IdeologiesManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.LinesManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Challenge.ChallengesManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Plagues.PlagueManager;
import age.of.civilizations2.jakowski.lukasz.MapScale;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.Menus.Load.Menu_LoadMap;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Diplomacy.Menu_InGame_Message_Alliance;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Choose.Menu_ChooseScenario;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_2;
import age.of.civilizations2.jakowski.lukasz.Messages.Gift.R.Menu_Main;
import age.of.civilizations2.jakowski.lukasz.NewGameManager;
import age.of.civilizations2.jakowski.lukasz.Pallet_Manager;
import age.of.civilizations2.jakowski.lukasz.ReligionManager;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Report_Data;
import age.of.civilizations2.jakowski.lukasz.SaveLoad.LoadManager;
import age.of.civilizations2.jakowski.lukasz.ServiceRibbon_Manager;
import age.of.civilizations2.jakowski.lukasz.Ships.ShipManager;
import age.of.civilizations2.jakowski.lukasz.TerrainTypesManager;
import age.of.civilizations2.jakowski.lukasz.UnionsManager;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.PNM;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu_InitGame
extends Menu {
    private int iStepID = 0;
    private int iNumOfSteps = 38;
    public boolean initThread = true;
    public int numToLoad_ProvinceData = 500;
    public int numToLoad_ProvinceBG = 500;
    private boolean loadAssetsQueued = false;
    private int startupTextureStep = -1;
    private int startupProvinceBGStep = 0;
    private boolean startupTextureFinalised = false;
    public static float bgAlpha = 0.0f;
    public static long bgTIME;
    public static long bgTIME_CHANGE;
    public static boolean EAPWS;
    public static boolean EACDG;
    public static boolean PDR;
    public static boolean DJE;
    public static boolean TDSX;
    public static Image background;
    public static int backgroundID;
    public static int backgroundSize;
    public static int backgroundWidth;
    public static int backgroundHeight;
    public static boolean ENDA;
    public static List<Image> animated;
    public static int animatedID;
    public static int animatedSize;
    public static int animatedWidth;
    public static int animatedHeight;
    public static long animatedTime;
    public static long animatedFrame;

    public Menu_InitGame() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (!CFG.getIsDesktop()) {
            this.numToLoad_ProvinceData = 2000;
            this.numToLoad_ProvinceBG = 2000;
        } else {
            this.numToLoad_ProvinceData = 2000;
            this.numToLoad_ProvinceBG = 2000;
        }
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
    }

    public static void loadBackground() {
        try {
            if (animatedSize > 0) {
                for (int i = 0; i < animatedSize; ++i) {
                    animated.add(new Image(IMGManager.loadTexture_RGB888("UI/animated/" + i + ".jpg"), Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge));
                }
                float fScale = Math.max((float)CFG.GAMEWIDTH / (float)animated.get(0).getWidth(), (float)CFG.GAMEHEIGHT / (float)animated.get(0).getHeight());
                animatedWidth = (int)((float)animated.get(0).getWidth() * fScale);
                animatedHeight = (int)((float)animated.get(0).getHeight() * fScale);
                animatedSize = animated.size();
                animatedTime = System.currentTimeMillis();
                return;
            }
        }
        catch (Exception ex) {
            animatedSize = 0;
            animated.clear();
        }
        if (backgroundSize <= 0) {
            return;
        }
        if (background != null) {
            background.dispose();
            background = null;
        }
        for (int i = 0; i < 5; ++i) {
            int newID = CFG.oR.nextInt(backgroundSize);
            if (newID == backgroundID) continue;
            backgroundID = newID;
            break;
        }
        background = new Image(IMGManager.loadTexture_RGB888("UI/background/" + backgroundID + ".png"), Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge);
        float fScale = Math.max((float)CFG.GAMEWIDTH / (float)background.getWidth(), (float)CFG.GAMEHEIGHT / (float)background.getHeight());
        backgroundWidth = (int)((float)background.getWidth() * fScale);
        backgroundHeight = (int)((float)background.getHeight() * fScale);
    }

    private final void loadSparks() {
        try {
            FileHandle tempFileT = FileManager.loadFile("UI/sparks/numberOfImages.txt");
            Images.SPARKS_SIZE = Integer.parseInt(tempFileT.readString());
            for (int i = 0; i < Images.SPARKS_SIZE; ++i) {
                Images.sparks.add(IMGManager.loadImage("UI/sparks/" + i + ".png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat));
            }
            Images.sparkWidth = Images.sparks.get(0).getWidth();
            Images.sparkHeight = Images.sparks.get(0).getHeight();
        }
        catch (GdxRuntimeException ex) {
            CFG.exceptionStack(ex);
        }
        Images.SPARKS_SIZE = Images.sparks.size();
    }

    public int getAppID() {
        return sUM.sUT.getAppID();
    }

    public boolean overlayEnabled() {
        return sUM.sUT.isOverlayEnabled();
    }

    private void queueLoadAssets() {
        if (this.loadAssetsQueued) {
            return;
        }
        this.loadAssetsQueued = true;
        Gdx.app.postRunnable(new Runnable(){
            @Override
            public void run() {
                try {
                    Menu_InitGame.this.loadAssets();
                }
                finally {
                    Menu_InitGame.this.loadAssetsQueued = false;
                }
            }
        });
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (CFG.settingsGD.BETTER_UI) {
            try {
                if (animatedSize > 0) {
                    oSB.setColor(new Color(0.047058824f, 0.047058824f, 0.047058824f, 1.0f));
                    Images.pix.draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                    animated.get(animatedID).draw(oSB, iTranslateX + (CFG.GAMEWIDTH - animatedWidth) / 2, iTranslateY + (CFG.GAMEHEIGHT - animatedHeight) / 2, animatedWidth, animatedHeight);
                    oSB.setColor(Color.WHITE);
                    if (animatedTime + animatedFrame < CFG.currentTimeMillis) {
                        animatedTime = CFG.currentTimeMillis;
                        if (++animatedID >= animatedSize) {
                            animatedID = 0;
                        }
                    }
                } else if (background != null) {
                    oSB.setColor(new Color(0.047058824f, 0.047058824f, 0.047058824f, 1.0f));
                    Images.pix.draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                    background.draw(oSB, iTranslateX + (CFG.GAMEWIDTH - backgroundWidth) / 2, iTranslateY + (CFG.GAMEHEIGHT - backgroundHeight) / 2, backgroundWidth, backgroundHeight);
                    oSB.setColor(Color.WHITE);
                }
            } catch (Exception ex) {}
            
            
            CFG.drLOA(oSB, (int)((float)CFG.GAMEWIDTH * CFG.getLOAPAD()) + iTranslateX, CFG.GAMEHEIGHT - (int)((float)CFG.BUTTON_H * 0.8f) * 2 - CFG.PADD + iTranslateY, (int)((float)CFG.GAMEWIDTH * (1.0f - CFG.getLOAPAD() * 2.0f)), (int)((float)CFG.BUTTON_H * 0.8f), (float)this.iStepID / (float)(this.iNumOfSteps + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2));
            CFG.drawJakowskiGamesRIGHT_BOT(oSB, iTranslateX, (float)this.iStepID / (float)(this.iNumOfSteps + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2));
            CFG.drawVersionLB(oSB, iTranslateX);
            
            this.queueLoadAssets();
            return;
        }
        try {
            if (animatedSize > 0) {
                oSB.setColor(new Color(0.047058824f, 0.047058824f, 0.047058824f, 1.0f));
                Images.pix.draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                animated.get(animatedID).draw(oSB, iTranslateX + (CFG.GAMEWIDTH - animatedWidth) / 2, iTranslateY + (CFG.GAMEHEIGHT - animatedHeight) / 2, animatedWidth, animatedHeight);
                oSB.setColor(Color.WHITE);
                if (animatedTime + animatedFrame < CFG.currentTimeMillis) {
                    animatedTime = CFG.currentTimeMillis;
                    if (++animatedID >= animatedSize) {
                        animatedID = 0;
                    }
                }
            } else if (background != null) {
                oSB.setColor(new Color(0.047058824f, 0.047058824f, 0.047058824f, 1.0f));
                Images.pix.draw(oSB, iTranslateX, iTranslateY, CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
                background.draw(oSB, iTranslateX + (CFG.GAMEWIDTH - backgroundWidth) / 2, iTranslateY + (CFG.GAMEHEIGHT - backgroundHeight) / 2, backgroundWidth, backgroundHeight);
                oSB.setColor(Color.WHITE);
            }
        }
        catch (Exception exception) {
            
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD * 3 + iTranslateY, CFG.GAMEWIDTH, CFG.PADD * 3, false, true);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.drLOA(oSB, (int)((float)CFG.GAMEWIDTH * CFG.getLOAPAD()) + iTranslateX, CFG.GAMEHEIGHT - (int)((float)CFG.BUTTON_H * 0.8f) * 2 - CFG.PADD + iTranslateY, (int)((float)CFG.GAMEWIDTH * (1.0f - CFG.getLOAPAD() * 2.0f)), (int)((float)CFG.BUTTON_H * 0.8f), (float)this.iStepID / (float)(this.iNumOfSteps + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2));
        CFG.drawJakowskiGamesRIGHT_BOT(oSB, iTranslateX, (float)this.iStepID / (float)(this.iNumOfSteps + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2));
        CFG.drawVersionLB(oSB, iTranslateX);
        this.queueLoadAssets();
    }

    private final void loadAssets() {
        block105: {
            try {
                if (this.iStepID == 0) {
                    CFG.glyphLay.setText(CFG.fontMain.get(0), CFG.sLoading);
                    CFG.iLoadingWidth = (int)CFG.glyphLay.width;
                    CFG.sLoading = CFG.lang.get("LoadingMap");
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 1) {
                    Menu_InitGame.loadColors();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 2) {
                    CFG.map.getMpB().loadGameMap();
                    CFG.map.getMpSl().stopScrollingTheMap();
                    CFG.map.getMpS().setCurrScale(MapScale.MINSCALE);
                    CFG.map.getMpC().setNewPosX(-((int)((float)(CFG.map.getMpB().getWidthM() / 2) - (float)CFG.GAMEWIDTH / MapScale.MINSCALE / 2.0f)));
                    CFG.map.getMpC().setNewPosY(-((int)((float)(CFG.map.getMpB().getHeightM() / 2) - (float)CFG.GAMEHEIGHT / MapScale.MINSCALE / 2.0f)));
                    CFG.map.getMpC().updateMapPos();
                    if (CFG.getIsDesktop() && FileManager.loadFile("game/gameValues/ENDA.txt").exists()) {
                        ENDA = true;
                    }
                    if (CFG.getIsDesktop() && FileManager.loadFile("UI/paddingEdge.txt").exists()) {
                        try {
                            FileHandle tempFileT = FileManager.loadFile("UI/paddingEdge.txt");
                            Core.PADDING = Integer.parseInt(tempFileT.readString());
                        }
                        catch (Exception e) {
                            CFG.exceptionStack(e);
                        }
                    }
                    if (CFG.getIsDesktop() && FileManager.loadFile("game/gameValues/ORHS.txt").exists()) {
                        this.numToLoad_ProvinceData = 2000;
                        this.numToLoad_ProvinceBG = 1000;
                    }
                    CFG.palletManager = new Pallet_Manager();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 3) {
                    FileHandle tempFileT;
                    try {
                        if (CFG.getIsDesktop()) {
                            tempFileT = FileManager.loadFile("UI/background/numberOfImages.txt");
                            backgroundSize = Integer.parseInt(tempFileT.readString());
                        } else {
                            tempFileT = FileManager.loadFile("UI/background/numberOfImages_Not_PC.txt");
                            backgroundSize = Integer.parseInt(tempFileT.readString());
                        }
                    }
                    catch (GdxRuntimeException ex) {
                        backgroundSize = 0;
                        CFG.exceptionStack(ex);
                    }
                    try {
                        if (CFG.getIsDesktop() && FileManager.loadFile("UI/animated/numberOfImages.txt").exists()) {
                            tempFileT = FileManager.loadFile("UI/animated/numberOfImages.txt");
                            animatedSize = Integer.parseInt(tempFileT.readString());
                        }
                    }
                    catch (Exception tempFileT2) {
                        
                    }
                    Menu_InitGame.loadBackground();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 4) {
                    GameValues.init();
                    FormableRestrictions.loadRestrictions();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 5) {
                    GameValues.init2();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 6) {
                    CFG.religionManager = new ReligionManager();
                    CFG.religionManager.loadReligions();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 7) {
                    Menu_InGame_Message_Alliance.ANIMATION_TIME = GameValues.gvInGame.MENUS_ANIMATION_TIME_TOP_DOWN;
                    CFG.CIV_INFO_MENU_WIDTH = (int)((float)GameValues.gvInGame.MENUS_LEFT_WIDTH * CFG.GUI_SCALE);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 8) {
                    CFG.map.initMapContinents();
                    CFG.map.initMapRegions();
                    CFG.core.preloadProvinceCache();
                    CFG.loadFontArmy();
                    CFG.oAI = new AI();
                    GameValues.updateCivPersonalityType();
                    CFG.RANDOM_CIVILIZATION = CFG.lang.get("RandomCivilization");
                    CFG.sVERSION = CFG.lang.get("Version");
                    CFG.sAUTHOR = CFG.lang.get("Author");
                    CFG.glyphLay.setText(CFG.fontMain.get(0), CFG.sLoading);
                    CFG.iLoadingWidth = (int)CFG.glyphLay.width;
                    CFG.sLoading = CFG.lang.get("LoadingGraphics");
                    if (Menu_LoadMap.loadMapOverlays()) {
                        Menu_LoadMap.loadMapBG_FileID = 0;
                        CFG.map.mpOv.lO("Overlays.json");
                    }
                    if (!CFG.getIsDesktop()) {
                        GameValues.gvTimelapse.GRAPH_DATA_LIMIT_PROVINCES = (int)((float)GameValues.gvTimelapse.GRAPH_DATA_LIMIT_PROVINCES * GameValues.gvTimelapse.MOBILE_TIMELAPSE_LIMIT_MODIFIER);
                        GameValues.gvTimelapse.GRAPH_DATA_LIMIT_POPULATION = (int)((float)GameValues.gvTimelapse.GRAPH_DATA_LIMIT_POPULATION * GameValues.gvTimelapse.MOBILE_TIMELAPSE_LIMIT_MODIFIER);
                        GameValues.gvTimelapse.GRAPH_DATA_LIMIT_ECONOMY = (int)((float)GameValues.gvTimelapse.GRAPH_DATA_LIMIT_ECONOMY * GameValues.gvTimelapse.MOBILE_TIMELAPSE_LIMIT_MODIFIER);
                        GameValues.gvTimelapse.GRAPH_DATA_LIMIT_RANK = (int)((float)GameValues.gvTimelapse.GRAPH_DATA_LIMIT_RANK * GameValues.gvTimelapse.MOBILE_TIMELAPSE_LIMIT_MODIFIER);
                        GameValues.gvTimelapse.GRAPH_DATA_LIMIT_TECH_LEVEL = (int)((float)GameValues.gvTimelapse.GRAPH_DATA_LIMIT_TECH_LEVEL * GameValues.gvTimelapse.MOBILE_TIMELAPSE_LIMIT_MODIFIER);
                        GameValues.gvTimelapse.GRAPH_DATA_LIMIT_PLAYER_DATA = (int)((float)GameValues.gvTimelapse.GRAPH_DATA_LIMIT_PLAYER_DATA * GameValues.gvTimelapse.MOBILE_TIMELAPSE_LIMIT_PLAYER_DATA_MODIFIER);
                    }
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 9) {
                    if (Menu_LoadMap.loadMapOverlays()) {
                        if (CFG.map.mpOv.lOI()) {
                            return;
                        }
                        Menu_LoadMap.loadMapBG_FileID = 0;
                    }
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 10) {
                    if (Menu_LoadMap.loadMapOverlays()) {
                        if (CFG.map.mpOv.lOI2()) {
                            return;
                        }
                        Menu_LoadMap.loadMapBG_FileID = 0;
                    }
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 11) {
                    Images.btnhClose = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "close_h.png");
                    Images.btnHMenuH = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "menu_h.png");
                    Images.btnhClear = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "clear_h.png");
                    Menu_InitGame.loadArmyBGImages();
                    CFG.gameUpdate = new GameUpdate();
                    CFG.gameAges = new GameAges();
                    CFG.plagueManager = new PlagueManager();
                    CFG.sLoading = CFG.lang.get("LoadingGameData");
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 12) {
                    this.loadSparks();
                    CFG.terrainTypesManager = new TerrainTypesManager();
                    CFG.ideologiesMgr = new IdeologiesManager();
                    CFG.ideologiesMgr.loadIdeologies();
                    CFG.unionsManager = new UnionsManager();
                    PNM.uDPN();
                    if (CFG.getIsDesktop() && FileManager.loadFile("game/gameValues/EAPWS.txt").exists()) {
                        EAPWS = true;
                    }
                    if (CFG.getIsDesktop() && FileManager.loadFile("game/gameValues/EACDG.txt").exists()) {
                        EACDG = true;
                    }
                    if (!CFG.getIsDesktop() || FileManager.loadFile("game/gameValues/DJE.txt").exists()) {
                        DJE = true;
                    }
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 13) {
                    Images.titleEdge = IMGManager.addIMG("UI/" + CFG.getResPath() + "title/" + "title_edge.png");
                    Images.dialog_title = IMGManager.addIMG("UI/" + CFG.getResPath() + "dialog/" + "title.png");
                    Images.dialog_desc = IMGManager.addIMG("UI/" + CFG.getResPath() + "dialog/" + "desc.png");
                    Images.dialog_line = IMGManager.addIMG("UI/" + CFG.getResPath() + "dialog/" + "line_2xdesc.png");
                    Images.mainMenuEdge = IMGManager.addIMG("UI/" + CFG.getResPath() + "main_menu/" + "main_menu_edge.png");

                    CFG.sLoading = CFG.lang.get("LoadingGraphics");
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 14) {
                    ShipManager.loadShipLines();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 15) {
                    Images.slider_rect_edge = IMGManager.addIMG("UI/" + CFG.getResPath() + "loading/" + "slider_edge.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.ClampToEdge);
                    Images.randomCivilizationFlag = IMGManager.addIMG("game/flagsXH/ran.png");
                    CFG.sLoading = CFG.lang.get("LoadingMap");
                    CFG.cloudsAnimation.readSettings();
                    CFG.cloudsAnimation.loCI();
                    CFG.cloudsAnimation.updateCloudsInterface();
                    if (CFG.getIsDesktop() && FileManager.loadFile("game/gameValues/UCSH.txt").exists()) {
                        Menu_ChooseScenario.UCSH = false;
                    }
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID >= 16 && this.iStepID < 16 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN())) {
                    CFG.sLoading = CFG.lang.get("LoadingMap");
                    int nProv = CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN());
                    int startProv = this.iStepID - 16;
                    int endProv = Math.min(startProv + this.numToLoad_ProvinceData, nProv);
                    for (int pv = startProv; pv < endProv; ++pv) {
                        CFG.core.loadProvince(pv);
                    }
                    if (endProv >= nProv) {
                        CFG.core.updateProvincesSize();
                    }
                    this.iStepID = 16 + endProv;
                    break block105;
                }
                if (this.iStepID == 16 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN())) {
                    CFG.sLoading = CFG.lang.get("LoadingProvinces");
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID >= 17 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) && this.iStepID < 17 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.sLoading = CFG.lang.get("LoadingProvinces");
                    int nProv = CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN());
                    if (this.startupTextureStep < 0) {
                        CFG.core.loadProvinceTextures_BatchInit();
                        this.startupTextureStep = 0;
                        this.startupTextureFinalised = false;
                    }
                    if (this.startupTextureStep < nProv) {
                        int end = Math.min(this.startupTextureStep + this.numToLoad_ProvinceBG, nProv);
                        CFG.core.loadProvinceTextures_Batch(this.startupTextureStep, end);
                        this.startupTextureStep = end;
                        this.iStepID = 17 + nProv + (this.startupTextureStep * nProv / Math.max(1, nProv));
                        break block105;
                    }
                    if (!this.startupTextureFinalised) {
                        CFG.core.loadProvinceTextures_BatchFinalise();
                        this.startupTextureFinalised = true;
                        break block105;
                    }
                    this.startupTextureStep = -1;
                    this.startupTextureFinalised = false;
                    this.iStepID = 17 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2;
                    break block105;
                }
                if (this.iStepID == 17 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.hreMgr = new HolyRomanEmpire_Manager();
                    CFG.core.initGameScenarios();
                    Images.btnClearCheckboxTrue = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "clear_checkbox_true.png");
                    Images.btnClearCheckboxFalse = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "clear_checkbox_false.png");
                    Images.btnV = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "v.png");
                    Images.btnVActive = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "v_active.png");
                    Images.btnX = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "x.png");
                    Images.btnXActive = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "x_active.png");
                    Images.btnMenu1H = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "menu_1.png");
                    Images.btnhMenu1H = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "menu_1_h.png");
                    Images.arrow = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "arrow.png");
                    Images.arrowActive = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "arrow_active.png");
                    Images.btnRemove = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "remove.png");
                    Images.btnUp = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "up.png");
                    Images.btnLocalization = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "localization.png");
                    Images.btnShow = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "show.png");
                    Images.btnAdd = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "add.png");
                    Images.bgGameMenu = IMGManager.addIMG("UI/" + CFG.getResPath() + "bg_game_menu.png");
                    Images.bgGameMenuR = IMGManager.addIMG("UI/" + CFG.getResPath() + "bg_game_menu_r.png");
                    Images.bgGameMenuRSmall = IMGManager.addIMG("UI/" + CFG.getResPath() + "bg_game_menu_r2.png");
                    Images.gameMenuOverlay = IMGManager.addIMG("UI/" + CFG.getResPath() + "gameMenuOverlay.png");
                    Images.noLeader = IMGManager.addIMG("UI/" + CFG.getResPath() + "noLeader.png");
                    Images.bgGameAction = IMGManager.addIMG("UI/" + CFG.getResPath() + "bg_game_action.png");
                    Images.bgStats = IMGManager.addIMG("UI/" + CFG.getResPath() + "bg_stats.png");
                    Images.sliderArmy = IMGManager.addIMG("UI/" + CFG.getResPath() + "sliderArmy.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.Repeat);
                    PDR = Gdx.app.getType() == Application.ApplicationType.Desktop;
                    CFG.sLoading = CFG.lang.get("LoadingGraphics");
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 18 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    Images.gameTop = IMGManager.addIMG("UI/" + CFG.getResPath() + "new_game/" + "top.png");
                    Images.gameTopEdge = IMGManager.addIMG("UI/" + CFG.getResPath() + "new_game/" + "top_edge.png");
                    Images.gameTopEdgeTitle = IMGManager.addIMG("UI/" + CFG.getResPath() + "new_game/" + "top_edge_title.png");
                    Images.gameTopEdgeLine = IMGManager.addIMG("UI/" + CFG.getResPath() + "new_game/" + "top_edge_line.png");
                    Images.gameTopEdgeLineHorizontal = IMGManager.addIMG("UI/" + CFG.getResPath() + "new_game/" + "top_edge_line_horizontal.png");
                    Images.gameBox = IMGManager.addIMG("UI/" + CFG.getResPath() + "new_game/" + "box.png");
                    Images.gameBoxHover = IMGManager.addIMG("UI/" + CFG.getResPath() + "new_game/" + "box_hover.png");
                    Images.gameBoxLine = IMGManager.addIMG("UI/" + CFG.getResPath() + "new_game/" + "box_line_end.png");
                    Images.gameBoxLineHover = IMGManager.addIMG("UI/" + CFG.getResPath() + "new_game/" + "box_line_end_hover.png");
                    Images.editor_top = IMGManager.addIMG("UI/" + CFG.getResPath() + "editor/" + "editor_top.png");
                    Images.editor_top_line = IMGManager.addIMG("UI/" + CFG.getResPath() + "editor/" + "editor_top_line.png");
                    Images.editor_line = IMGManager.addIMG("UI/" + CFG.getResPath() + "editor/" + "editor_line.png");
                    Images.botEndLeft = IMGManager.addIMG("UI/" + CFG.getResPath() + "bottom/" + "end_left.png");
                    Images.botProvName = IMGManager.addIMG("UI/" + CFG.getResPath() + "bottom/" + "prov_name.png");
                    Images.botProvNameLeft = IMGManager.addIMG("UI/" + CFG.getResPath() + "bottom/" + "prov_name_left.png");
                    Images.botIconsBG = IMGManager.addIMG("UI/" + CFG.getResPath() + "bottom/" + "icons_bg.png");
                    ChallengesManager.loadChallenges();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 19 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    Images.city = IMGManager.addIMG("UI/icons/city.png");
                    Images.city2 = IMGManager.addIMG("UI/icons/city2.png");
                    Images.city3 = IMGManager.addIMG("UI/icons/city3.png");
                    Images.city4 = IMGManager.addIMG("UI/icons/city4.png");
                    Images.city5 = IMGManager.addIMG("UI/icons/city5.png");
                    Images.mount = IMGManager.addIMG("UI/icons/mount.png");
                    Images.pattern = IMGManager.addIMG("UI/patt.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.Repeat);
                    Images.patternReversed = IMGManager.addIMG("UI/patt2.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.Repeat);
                    Images.patternExtraAlpha = IMGManager.addIMG("UI/patt3.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.Repeat);
                    Images.patternSquareTiny = IMGManager.addIMG("UI/pattsquare.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.Repeat);
                    Images.portIco = IMGManager.addIMG("UI/icons/port.png");
                    Images.towerIco = IMGManager.addIMG("UI/icons/tower.png");
                    Images.fortIco = IMGManager.addIMG("UI/icons/fort.png");
                    Images.towerFortIco = IMGManager.addIMG("UI/icons/towerfort.png");
                    Images.armouryIco = IMGManager.addIMG("UI/icons/armoury.png");
                    Images.line11 = IMGManager.addIMG("UI/lines/line_11.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat);
                    Images.line22 = IMGManager.addIMG("UI/lines/line_22.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat);
                    Images.line32 = IMGManager.addIMG("UI/lines/line_32.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat);
                    Images.line33 = IMGManager.addIMG("UI/lines/line_33.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat);
                    Images.line44 = IMGManager.addIMG("UI/lines/line_44.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat);
                    Images.line26 = IMGManager.addIMG("UI/lines/line_26.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat);
                    Images.line62 = IMGManager.addIMG("UI/lines/line_62.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat);
                    Images.line32Vertical = IMGManager.addIMG("UI/lines/line_32_vertical.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat);
                    if (CFG.getIsDesktop() && FileManager.loadFile("game/gameValues/SANDISINF.txt").exists()) {
                        CFG.PXSX = true;
                    }
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 20 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    Images.army_capital = IMGManager.addIMG("UI/icons/army/army_capital.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.ClampToEdge);
                    Images.army_capital_frame = IMGManager.addIMG("UI/icons/army/army_capital_frame.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.ClampToEdge);
                    Images.civNameBG = IMGManager.addIMG("UI/icons/army/civ_name_bg.png");
                    Images.civFlagBG = IMGManager.addIMG("UI/icons/army/civ_flag_bg.png");
                    Images.circle55 = IMGManager.addIMG("UI/icons/circle_55.png");
                    Images.news = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "news.png");
                    Images.pop = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "population.png");
                    Images.popGrowth = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "population_growth.png");
                    Images.economy = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "economy.png");
                    Images.disease = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "disease.png");
                    Images.victoryPoints = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "victory_points.png");
                    Images.rank = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "rank.png");
                    Images.time = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "time.png");
                    Images.icon_move_attack = IMGManager.addIMG("UI/icons/move_0.png");
                    Images.icon_move_ally = IMGManager.addIMG("UI/icons/move_1.png");
                    Images.icon_move_sea = IMGManager.addIMG("UI/icons/move_2.png");
                    Images.skull = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "skull.png");
                    Images.goods = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "goods.png");
                    Images.religion = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "religion.png");
                    Images.administration = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "administration.png");
                    Images.wonders = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "wonders.png");
                    Images.frontline = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "frontline.png");
                    Images.rank1 = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "rank1.png");
                    Images.rank2 = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "rank2.png");
                    Images.rank3 = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "rank3.png");
                    Images.key = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "key.png");
                    Images.core = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "core.png");
                    Images.peace = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "peace.png");
                    Images.flagRectSmall = IMGManager.addIMG("UI/" + CFG.getResPath() + "flags/" + "rect.png");
                    Images.terrainUnknown = IMGManager.addIMG("UI/" + CFG.getResPath() + "terrain/" + "unknown.png");
                    Images.terrainUnknown2 = IMGManager.addIMG("UI/" + CFG.getResPath() + "terrain/" + "unknown2.png");
                    Images.flagBigMask = IMGManager.addIMG("UI/" + CFG.getResPath() + "flags/" + "flagBigMask.png");
                    Images.flagBigMaskLord = IMGManager.addIMG("UI/" + CFG.getResPath() + "flags/" + "flagBigMaskLord.png");
                    Images.flagBigOver = IMGManager.addIMG("UI/" + CFG.getResPath() + "flags/" + "flagBigOver.png");
                    Images.flagBigMask2 = IMGManager.addIMG("UI/" + CFG.getResPath() + "flags/" + "flagBigMask2.png");
                    Images.flagBigMaskLord2 = IMGManager.addIMG("UI/" + CFG.getResPath() + "flags/" + "flagBigMaskLord2.png");
                    Images.flagBigOver2 = IMGManager.addIMG("UI/" + CFG.getResPath() + "flags/" + "flagBigOver2.png");
                    Images.flagDiplomacyOver = IMGManager.addIMG("UI/" + CFG.getResPath() + "flags/" + "flagDiplomacyOver.png");
                    Images.flagDiplomacyMask = IMGManager.addIMG("UI/" + CFG.getResPath() + "flags/" + "flagDiplomacyMask.png");
                    Images.flagRect2 = IMGManager.addIMG("UI/" + CFG.getResPath() + "flags/" + "flagRect2.png");
                    Images.flagRect2Mask = IMGManager.addIMG("UI/" + CFG.getResPath() + "flags/" + "flagRect2Mask.png");
                    CFG.CIV_FLAG_WIDTH = IMGManager.getIMG(Images.flagRectSmall).getWidth();
                    CFG.CIV_FLAG_HEIGHT = IMGManager.getIMG(Images.flagRectSmall).getHeight();
                    Images.flagCircle = IMGManager.addIMG("UI/" + CFG.getResPath() + "flags/" + "circle.png");
                    Images.flagCircleShader = IMGManager.addIMG("UI/" + CFG.getResPath() + "flags/" + "circle_sh.png");
                    if (!CFG.getIsDesktop() || FileManager.loadFile("game/gameValues/TDSX.txt").exists()) {
                        TDSX = true;
                    }
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 21 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    Images.scrollPosition = IMGManager.addIMG("UI/" + CFG.getResPath() + "scroll_posiotion.png");
                    Images.scrollPositionActive = IMGManager.addIMG("UI/" + CFG.getResPath() + "scroll_posiotion_active.png");
                    Images.slideBG = IMGManager.addIMG("UI/" + CFG.getResPath() + "slide/" + "slide_bg.png");
                    Images.sliderGradient = IMGManager.addIMG("UI/" + CFG.getResPath() + "slider_gradient.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge);
                    Images.pickerSV = IMGManager.addIMG("UI/picker/sv.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge);
                    Images.pickerHUE = IMGManager.addIMG("UI/picker/hue.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge);
                    Images.pickerSVPos = IMGManager.addIMG("UI/picker/pos.png");
                    Images.pickerEdge = IMGManager.addIMG("UI/picker/edge.png");
                    Images.flagCapitalOver = IMGManager.addIMG("UI/flag_capital/flagCapitalOver.png");
                    Images.flagCapitalMask = IMGManager.addIMG("UI/flag_capital/flagCapitalMask.png");
                    CFG.sLoading = CFG.lang.get("LoadingMap");
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 22 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.updateProvincesSize();
                    RenderProvince.updateDrawProvinces();
                    CFG.core.checkLandBySeaProvincesBorders();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 23 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.checkSeaBySeaProvincesBorders();
                    CFG.core.buildProvinceBorder();
                    CFG.sLoading = CFG.lang.get("LoadingGameData");
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 24 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.loadFontBorder();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 25 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 26 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.gameAction = new GameAction();
                    CFG.core.initGameCities();
                    CFG.core.loadCities();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 27 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    ++this.iStepID;
                    CFG.core.buildProvincesNames();
                    LoadManager.loadProvinceNamesPoints();
                    Core.addSimpleTask(new Core.SimpleTask("buildProvNameData"){

                        @Override
                        public void update() {
                            PNM.bPND();
                        }
                    });
                    break block105;
                }
                if (this.iStepID == 28 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_1(false);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 29 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_2(false);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 30 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 31 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 32 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 33 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_2_Flags();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 34 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 35 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_3(false);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 36 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_4(false);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 37 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_5(false);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 38 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_6(false);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 39 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_7(false);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 40 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_8(false);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 41 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_9(false);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 42 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_10(false);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 43 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_11(false);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 44 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_12(false);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 45 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_13(false);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 46 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadScenario_14(false);
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 47 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.initPlayers();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 48 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.buildDrawArmy();
                    CFG.core.buildBasinsOfSeaProvinces();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 49 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.loadProvinceNames_ALL();
                    CFG.core.loadRegions();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 50 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.initGameMountains();
                    CFG.core.loadMountains();
                    Images.botLeft = IMGManager.addIMG("UI/" + CFG.getResPath() + "bot/" + "left.png");
                    Images.botLeftRed = IMGManager.addIMG("UI/" + CFG.getResPath() + "bot/" + "left_red.png");
                    Images.topLeftExtra = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "left_extra.png");
                    Images.topBar = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "topBar.png");
                    Images.topBar2 = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "topBar2.png");
                    Images.topFlagBG = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "topFlagBG.png");
                    Menu_InGame_2.topStatsHeight = IMGManager.getIMG(Images.topBar).getHeight() - 1;
                    Images.messages = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "message.png");
                    Images.messages_g = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "message_g.png");
                    Images.messages_r = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "message_r.png");
                    Images.messages_w = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "message_w.png");
                    Images.top_circle = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "circle.png");
                    Images.topFlagFrame = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "flag_frame.png");
                    Images.topFlagFrameH = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "flag_frame_h.png");
                    Images.topCivColor = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "civ_color.png");
                    Images.topCivColorShader = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "civ_color_sh.png");
                    Images.top_view_right = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "view_right.png");
                    Images.top_view_right_h = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "view_right_h.png");
                    Images.top_view_right_last = IMGManager.addIMG("UI/" + CFG.getResPath() + "top/" + "view_right_last.png");
                    CFG.sLoading = CFG.lang.get("LoadingGraphics");
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 51 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    Images.difficultyBox = IMGManager.addIMG("UI/" + CFG.getResPath() + "difficulty/" + "difficulty_box.png");
                    Images.difficultyHeaven = IMGManager.addIMG("UI/" + CFG.getResPath() + "difficulty/" + "difficulty_heaven.png");
                    Images.difficultyHell = IMGManager.addIMG("UI/" + CFG.getResPath() + "difficulty/" + "difficulty_hell.png");
                    Images.topGold = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "gold.png");
                    Images.topGold2 = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "gold_medium.png");
                    Images.topMovementPoints = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "movement_points.png");
                    Images.topDiplomacyPoints = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "diplomacy_points.png");
                    Images.arUp = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "ar_up.png");
                    Images.arDown = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "ar_down.png");
                    Images.hreIcon = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "hre_icon.png");
                    Images.hreFlag = IMGManager.addIMG("UI/icons/hre_flag.png");
                    Images.hreCrown = IMGManager.addIMG("UI/icons/crowns/hre.png");
                    Images.hreCrownX = IMGManager.addIMG("UI/icons/crowns/hre_x.png");
                    Images.hreCrownScaled = IMGManager.addIMG("UI/" + CFG.getResPath() + "crowns/" + "hre.png");
                    Images.stats = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "stats.png");
                    Images.dice = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "dice.png");
                    FileHandle tempFileT2 = FileManager.loadFile("UI/nuke/numOfImages.txt");
                    int tNukeImages = Integer.parseInt(tempFileT2.readString());
                    for (int i = 0; i < tNukeImages; ++i) {
                        Images.nukeImg.add(IMGManager.addIMG("UI/nuke/" + i + ".png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat));
                    }
                    Images.nukeIMGSize = tNukeImages;
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 52 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    Images.technology = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "technology.png");
                    Images.provinces = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "provinces.png");
                    Images.research = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "research.png");
                    Images.development = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "development.png");
                    Images.investEco = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "investEco.png");
                    Images.investDev = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "investDev.png");
                    Images.developmentDown = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "development_down.png");
                    Images.happiness = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "happiness.png");
                    Images.happiness1 = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "happiness1.png");
                    Images.happiness2 = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "happiness2.png");
                    Images.battle = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "battle.png");
                    Images.neighWar = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "neighWar.png");
                    Images.neighTruce = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "neighTruce.png");
                    Images.infoBox = IMGManager.addIMG("UI/" + CFG.getResPath() + "infoBox/" + "infoBox.png");
                    Images.infoDiplomacy = IMGManager.addIMG("UI/" + CFG.getResPath() + "infoBox/" + "infoDiplomacy.png");
                    Images.infoTech = IMGManager.addIMG("UI/" + CFG.getResPath() + "infoBox/" + "infoTech.png");
                    Images.infoWar = IMGManager.addIMG("UI/" + CFG.getResPath() + "infoBox/" + "infoWar.png");
                    Images.infoRelations = IMGManager.addIMG("UI/" + CFG.getResPath() + "infoBox/" + "infoRelations.png");
                    Images.infoStability = IMGManager.addIMG("UI/" + CFG.getResPath() + "infoBox/" + "infoStability.png");
                    Images.infoEconomy = IMGManager.addIMG("UI/" + CFG.getResPath() + "infoBox/" + "infoEconomy.png");
                    Images.infoTruce = IMGManager.addIMG("UI/" + CFG.getResPath() + "infoBox/" + "infoTruce.png");
                    Images.infoDev = IMGManager.addIMG("UI/" + CFG.getResPath() + "infoBox/" + "infoDev.png");
                    Images.infoFestival = IMGManager.addIMG("UI/" + CFG.getResPath() + "infoBox/" + "infoFestival.png");
                    Images.infoBuild = IMGManager.addIMG("UI/" + CFG.getResPath() + "infoBox/" + "infoBuild.png");
                    Images.infoNuke = IMGManager.addIMG("UI/" + CFG.getResPath() + "infoBox/" + "infoNuke.png");
                    Images.terrainOver = IMGManager.addIMG("UI/" + CFG.getResPath() + "terrain/" + "terrainOver.png");
                    Images.bFort = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "b_fort.png");
                    Images.bTower = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "b_tower.png");
                    Images.bPort = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "b_port.png");
                    Images.bFarm = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "b_farm.png");
                    Images.bLibrary = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "b_library.png");
                    Images.bArmoury = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "b_armoury.png");
                    Images.bWorkshop = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "b_workshop.png");
                    Images.bSupply = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "b_supply.png");
                    Images.bMarket = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "b_market.png");
                    Images.buildAll = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "build_all.png");
                    Images.nuke = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "nuke.png");
                    Images.mapWar = IMGManager.addIMG("UI/icons/mapWar.png");
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 53 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    Images.diploWar = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "war.png");
                    Images.diploWeariness = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "weariness.png");
                    Images.diploWarPreparations = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "war_preparations.png");
                    Images.diploTruce = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "truce.png");
                    Images.diploAlliance = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "alliance.png");
                    Images.diploRelations = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "relations.png");
                    Images.diploRelationsInc = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "relations_inc.png");
                    Images.diploRelationsDec = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "relations_dec.png");
                    Images.diploTrade = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "trade.png");
                    Images.diploDefensivePact = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "defensive.png");
                    Images.diploNonAggression = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "nonagg.png");
                    Images.diploGuaranteeHas = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "indepe.png");
                    Images.diploGuaranteeGives = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "indepe2.png");
                    Images.diploAccessHas = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "military.png");
                    Images.diploAccessGives = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "military2.png");
                    Images.diploGift = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "gift.png");
                    Images.diploIntervene = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "intervene.png");
                    Images.diploRevolution = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "revolution.png");
                    Images.diploStability = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "popstability.png");
                    Images.diploUnion = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "union.png");
                    Images.diploVassal = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "vassal.png");
                    Images.diploLord = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "lord.png");
                    Images.diploLoan = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "loan.png");
                    Images.diploLoan2 = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "loan2.png");
                    Images.globalDebt = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "debt_global.png");
                    Images.diploPlunder = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "plunder.png");
                    Images.diploArmy = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "army.png");
                    Images.diploArmyMove = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "army_move.png");
                    Images.diploArmyDisband = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "army_disband.png");
                    Images.diploGoldenAge = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "goldenage.png");
                    Images.diploGoldenAgeM = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "goldenage_m.png");
                    Images.diploGoldenAgeS = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "goldenage_s.png");
                    Images.mercenaries = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "mercenaries.png");
                    Images.gov = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "gov.png");
                    Images.diploArmySend = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "army_send.png");
                    Images.diploArmySend2 = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "army_send2.png");
                    Images.diploArmyStar = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "army_star.png");
                    Images.conquered = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "conquered.png");
                    Images.investF = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "investF.png");
                    Images.investF1 = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "investF1.png");
                    Images.investB = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "investB.png");
                    Images.investB1 = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "investB1.png");
                    Images.propaganda = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "propaganda.png");
                    Images.propaganda1 = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "propaganda1.png");
                    Images.summit = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "summit.png");
                    Images.debt = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "debt.png");
                    Images.loanRe = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "loanRe.png");
                    Images.sanctions = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "sanctions.png");
                    Images.promoteStability = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "promoteStability.png");
                    Images.overInvest = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "overInvest.png");
                    Images.defensivePosition = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "defensive_position.png");
                    Images.attack = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "attack.png");
                    Images.defense = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "defense.png");
                    Images.diploFestival = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "festival.png");
                    Images.transferControl = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "transfer_control.png");
                    Images.diploHeart = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "heart.png");
                    Images.diploRivals = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "rivals.png");
                    Images.diploRivals2 = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "rivals2.png");
                    Images.diploRivaledBy = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "rivaledBy.png");
                    Images.diploAZ = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "az.png");
                    Images.spy = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "spy.png");
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.topMovementPoints).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploWar).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploTruce).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploAlliance).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploRelations).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploRelationsInc).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploRelationsDec).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploTrade).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploDefensivePact).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploNonAggression).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploAccessHas).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploGuaranteeGives).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploAccessHas).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploAccessGives).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploGift).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploRevolution).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploUnion).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploVassal).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploLord).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploLoan).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploLoan2).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.diploPlunder).getWidth());
                    ButtonDiplomacy.setMaxDiploWidth(IMGManager.getIMG(Images.flagRectSmall).getWidth());
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 54 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    Images.actAttack = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "act_attack.png");
                    Images.actPlunder = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "act_plunder.png");
                    Images.actRecruit = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "act_recruit.png");
                    Images.actMove = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "act_move.png");
                    Images.actMoveTo = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "act_moveto.png");
                    Images.actMore = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "act_more.png");
                    Images.actMigrate = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "act_migrate.png");
                    if (CFG.getIsDesktop() && FileManager.loadFile("game/gameValues/WVFAL.txt").exists()) {
                        GameN.FUEVG = true;
                    }
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 55 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    Images.editorGame = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "editor_game.png");
                    Images.editorMap = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "editor_map.png");
                    Images.editorCity = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "editor_city.png");
                    Images.editorCiv = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "editor_civ.png");
                    Images.icon_save = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "save.png");
                    Images.editorLeaders = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "editor_leaders.png");
                    Images.iconTrue = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "check_true.png");
                    Images.iconFalse = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "check_false.png");
                    CFG.graphCircleDraw = new Graph_CircleDraw("bg.png", "over.png", "frame.png");
                    Images.wikipedia = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "wiki.png");
                    Images.pickerIcon = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "picker_icon.png");
                    Images.diploMessage = IMGManager.addIMG("UI/" + CFG.getResPath() + "icons/" + "message.png");
                    Images.gameLogoC = IMGManager.addIMG2("UI/" + CFG.getResPath() + "game_logo2.png");
                    EventTemplatesMGR.loadEventTemplates();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 56 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    Images.mapBorder = IMGManager.addIMG("UI/lines/map_border.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.Repeat);
                    try {
                        FileHandle file = FileManager.loadFile("game/diplomacy_colors/Age_of_Civilizations_Active");
                        CFG.sACTIVE_DIPLOMACY_COLORS_TAG = file.readString();
                    }
                    catch (GdxRuntimeException ex) {
                        CFG.sACTIVE_DIPLOMACY_COLORS_TAG = "DEFAULT";
                    }
                    CFG.loadDiplomacyColors_GameData(CFG.sACTIVE_DIPLOMACY_COLORS_TAG);
                    CFG.loadRandomAlliancesNames();
                    CFG.menus.getColorPicker().buildColors();
                    CFG.menus.getColorPicker().setHueWidth((int)((float)CFG.BUTTON_W * 0.35f * CFG.GUI_SCALE));
                    CFG.menus.getColorPicker().setSVHeight((int)((float)(IMGManager.getIMG(Images.pickerSV).getHeight() * 2) * CFG.GUI_SCALE));
                    CFG.menus.getColorPicker().setResizeHeight((int)(30.0f * CFG.GUI_SCALE));
                    CFG.PROVINCE_BORDER_ANIMATION_TIME = new HashMap();
                    CFG.sLoading = CFG.lang.get("Loading");
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 57 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.core.updateDrawMoveUnitsArmy();
                    CFG.gameNewGame = new NewGameManager();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 58 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.map.getMpB().loadMinimap();
                    CFG.serviceRibbonMgr = new ServiceRibbon_Manager();
                    if (CFG.getIsDesktop() && FileManager.loadFile("game/gameValues/GLDRCA.txt").exists()) {
                        GameN.GLDRCA = true;
                    }
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 59 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.mapModesManager = new MapModesManager();
                    CFG.linesManager = new LinesManager();
                    ++this.iStepID;
                    break block105;
                }
                if (this.iStepID == 60 + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()) * 2) {
                    CFG.historyManager = new HistoryManager();
                    CFG.reportData = new Report_Data();
                    CFG.reportData.lAttackers_IDs.add(0);
                    CFG.reportData.lAttackers_Armies.add(1L);
                    CFG.reportData.lAttackers_Armies_Lost.add(0L);
                    CFG.reportData.lDefenders_IDs.add(0);
                    CFG.reportData.lDefenders_Armies.add(1L);
                    CFG.reportData.lDefenders_ArmiesLost.add(0L);
                    CFG.map.load_DeleteStatusFile();
                    CFG.FOG_OF_WAR = 2;
                    Menu_Main.SPECIAL_1 = false;
                    Menu_Main.SPECIAL_2 = false;
                    if (CFG.settingsGD.LANG_TAG == null) {
                        CFG.backToMenu = View.eMAINMENU;
                        CFG.menus.setMenuID(View.eSELECT_LANGUAGE);
                        CFG.map.getMpB().updateWorldMap_Shaders();
                        CFG.VIEW_SHOW_VALUES = true;
                    } else {
                        CFG.menus.setMenuIDWithoutAnim(View.eMAINMENU);
                    }
                    ++this.iStepID;
                } else {
                    ++this.iStepID;
                    if (this.iStepID >= 100) {
                        Menu_Main.SPECIAL_1 = false;
                        Menu_Main.SPECIAL_2 = false;
                        if (CFG.settingsGD.LANG_TAG == null) {
                            CFG.backToMenu = View.eMAINMENU;
                            CFG.menus.setMenuID(View.eSELECT_LANGUAGE);
                            CFG.map.getMpB().updateWorldMap_Shaders();
                            CFG.VIEW_SHOW_VALUES = true;
                        } else {
                            CFG.menus.setMenuIDWithoutAnim(View.eMAINMENU);
                        }
                    }
                }
            }
            catch (OutOfMemoryError ex) {
                CFG.toastM.addM("Out of RAM", CFG.COLOR_NEGATIVE_2);
                CFG.toastM.setTimeInView(4500);
            }
        }
    }

    public static final void loadColors() {
        if (CFG.getIsDesktop() && FileManager.loadFile("UI/colors/loadColors.txt").exists()) {
            int tB;
            int tG;
            int tR;
            String tT;
            String[] tData;
            FileHandle file;
            try {
                file = FileManager.loadFile("UI/colors/COLOR_FLAG_FRAME.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_FLAG_FRAME = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_FLAG_FRAME.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_TEXT_NUM_OF_PROVINCES.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_TEXT_NUM_OF_PROVINCES = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_TEXT_NUM_OF_PROVINCES.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_HOVER_TITLE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_HOVER_TITLE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_HOVER_TITLE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_CREATE_NEW_GAME_BOX_PLAYERS.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_NEW_GAME_EDGE_LINE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_NEW_GAME_EDGE_LINE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_NEW_GAME_EDGE_LINE.a);
                    CFG.COLOR_NEW_GAME_EDGE_LINE2 = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_NEW_GAME_EDGE_LINE2.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_NEW_GAME_EDGE_LINE2.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_NEW_GAME_EDGE_LINE2 = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_NEW_GAME_EDGE_LINE2.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_BUTTON_GAME_TEXT.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_BUTTON_GAME_TEXT = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_BUTTON_GAME_TEXT.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_BUTTON_GAME_TEXT_HOVERED.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_BUTTON_GAME_TEXT_HOVERED = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_BUTTON_GAME_TEXT_HOVERED.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_BUTTON_GAME_TEXT_ACTIVE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_BUTTON_GAME_TEXT_IMPORTANT.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_BUTTON_GAME_TEXT_IMPORTANT.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_BTN_M.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_BTN_M = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_BTN_M.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_BTN_M_NOT_CLICKABLE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_BTN_M_NOT_CLICKABLE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_BTN_M_NOT_CLICKABLE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_GRADIENT_DIPLOMACY.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_GRADIENT_DIPLOMACY = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_GRADIENT_DIPLOMACY.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_BOX_GRADIENT.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_BOX_GRADIENT = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_BOX_GRADIENT.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_GRADIENT_BLUE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_GRADIENT_BLUE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_GRADIENT_BLUE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_GRADIENT_DARK_BLUE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_GRADIENT_DARK_BLUE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_GRADIENT_DARK_BLUE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_GRADIENT_LIGHTER_DARK_BLUE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_GRADIENT_MENU_BLUE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_GRADIENT_MENU_BLUE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_GRADIENT_MENU_BLUE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_TEXT_CIV_INFO.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_TEXT_CIV_INFO = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_TEXT_CIV_INFO.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_BUTTON_MENU_TEXT.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_BUTTON_MENU_TEXT = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_BUTTON_MENU_TEXT.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_BUTTON_MENU_TEXT_HOVERED.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_BUTTON_MENU_TEXT_HOVERED = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_BUTTON_MENU_TEXT_HOVERED.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_BUTTON_MENU_TEXT_ACTIVE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_BUTTON_MENU_TEXT_ACTIVE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_BUTTON_MENU_TEXT_ACTIVE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_ECONOMY.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_ECONOMY = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_ECONOMY.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_ECONOMY_HOVER.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_ECONOMY_HOVER = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_ECONOMY_HOVER.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_ECONOMY_ACTIVE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_ECONOMY_ACTIVE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_ECONOMY_ACTIVE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_POPULATION.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_POPULATION = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_POPULATION.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_POPULATION_HOVER.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_POPULATION_HOVER = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_POPULATION_HOVER.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_POPULATION_ACTIVE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_POPULATION_ACTIVE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_POPULATION_ACTIVE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_PROVINCE_VALUE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_PROVINCE_VALUE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_PROVINCE_VALUE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_DEVELOPMENT.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_DEVELOPMENT = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_DEVELOPMENT.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_POPULATION_GROWTHRATE_MIN.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_POPULATION_GROWTHRATE_MIN = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_POPULATION_GROWTHRATE_MIN.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_POPULATION_GROWTHRATE_MAX.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_POPULATION_GROWTHRATE_MAX = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_POPULATION_GROWTHRATE_MAX.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_TECHNOLOGY.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_TECHNOLOGY = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_TECHNOLOGY.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_REVOLUTION_MIN.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_REVOLUTION_MIN = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_REVOLUTION_MIN.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_REVOLUTION_MIN_0.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_REVOLUTION_MIN_0 = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_REVOLUTION_MIN_0.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_REVOLUTION_MAX.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_REVOLUTION_MAX = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_REVOLUTION_MAX.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_PROVINCE_STABILITY_MIN.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_PROVINCE_STABILITY_MIN = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_PROVINCE_STABILITY_MIN.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_PROVINCE_STABILITY_MAX.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_PROVINCE_STABILITY_MAX = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_PROVINCE_STABILITY_MAX.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_HAPPINESS_MIN.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_HAPPINESS_MIN = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_HAPPINESS_MIN.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_HAPPINESS_MAX.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_HAPPINESS_MAX = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_HAPPINESS_MAX.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_GOLD.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_GOLD = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_GOLD.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_MOVEMENT.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_MOVEMENT = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_MOVEMENT.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_MOVEMENT_ZERO.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_MOVEMENT_ZERO = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_MOVEMENT_ZERO.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_DIPLOMACY_POINTS.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_DIPLOMACY_POINTS = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_DIPLOMACY_POINTS.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_NEUTRAL.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_NEUTRAL = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_NEUTRAL.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_NEUTRAL2.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_NEUTRAL2 = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_NEUTRAL2.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_NEGATIVE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_NEGATIVE_1 = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_NEGATIVE_1.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_NEGATIVE2.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_NEGATIVE_2 = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_NEGATIVE_2.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_POSITIVE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_POSITIVE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_POSITIVE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_ARMY_TEXT.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_ARMY_TEXT = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_ARMY_TEXT.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_ARMY_TEXT_ACTIVE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_ARMY_TEXT_ACTIVE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_ARMY_TEXT_ACTIVE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_ARMY_TEXT_CAPITAL_ACTIVE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_ARMY_TEXT_CAPITAL_ACTIVE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_ARMY_TEXT_SEA.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_ARMY_TEXT_SEA = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_ARMY_TEXT_SEA.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_ARMY_TEXT_SEA_ACTIVE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_ARMY_TEXT_SEA_ACTIVE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_ARMY_TEXT_SEA_ACTIVE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/BUTTON_TEXT.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    Colors.BUTTON_TEXT = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, Colors.BUTTON_TEXT.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/BUTTON_TEXT_HOVERED.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    Colors.BUTTON_TEXT_HOVERED = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, Colors.BUTTON_TEXT_HOVERED.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/BUTTON_TEXT_BRIGHT.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    Colors.BUTTON_TEXT_BRIGHT = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, Colors.BUTTON_TEXT_BRIGHT.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/BUTTON_TEXT_ACTIVE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    Colors.BUTTON_TEXT_ACTIVE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, Colors.BUTTON_TEXT_ACTIVE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_TEXT_GRAY_NS.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_TEXT_GRAY_NS = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_TEXT_GRAY_NS.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_TEXT_GRAY_NS_HOVER.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_TEXT_GRAY_NS_HOVER = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_TEXT_GRAY_NS_HOVER.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_TEXT_GRAY_NS_ACTIVE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_TEXT_GRAY_NS_ACTIVE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_TEXT_GRAY_NS_ACTIVE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_TEXT_GRAY_LEFT_NS.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_TEXT_GRAY_LEFT_NS = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_TEXT_GRAY_LEFT_NS.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_TEXT_GRAY_LEFT_NS_HOVER.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_TEXT_GRAY_LEFT_NS_ACTIVE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_GRADIENT.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    Colors.COLOR_GRADIENT = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, Colors.COLOR_GRADIENT.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_GRADIENT_OVER_BLUE.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    Colors.COLOR_GRADIENT_OVER_BLUE = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, Colors.COLOR_GRADIENT_OVER_BLUE.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                file = FileManager.loadFile("UI/colors/COLOR_STATS_RECT_BG.txt");
                if (file.exists() && (tData = (tT = file.readString()).split(";")).length > 2) {
                    tR = Integer.parseInt(tData[0]);
                    tG = Integer.parseInt(tData[1]);
                    tB = Integer.parseInt(tData[2]);
                    Colors.COLOR_STATS_RECT_BG = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, Colors.COLOR_STATS_RECT_BG.a);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public static final void loadArmyBGImages() {
        if (Images.armyLeft <= 0) {
            Images.armyLeft = IMGManager.addIMG("UI/icons/army/armyLeft.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.ClampToEdge);
            Images.armyBG = IMGManager.addIMG("UI/icons/army/armyRight.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.ClampToEdge);
            Images.armyMiddle = IMGManager.addIMG("UI/icons/army/armyMiddle.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.ClampToEdge);
            try {
                Images.army_sea = IMGManager.addIMG("UI/icons/army/" + CFG.settingsGD.FONT_ARMY_SIZEX + "/army_sea.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.ClampToEdge);
            }
            catch (GdxRuntimeException ex) {
                Images.army_sea = IMGManager.addIMG("UI/icons/army/16/army_sea.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.ClampToEdge);
            }
            try {
                Images.army_16_seaBG = IMGManager.addIMG("UI/icons/army/" + CFG.settingsGD.FONT_ARMY_SIZEX + "/army_seabg.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.ClampToEdge);
            }
            catch (GdxRuntimeException ex) {
                Images.army_16_seaBG = IMGManager.addIMG("UI/icons/army/16/army_seabg.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.ClampToEdge);
            }
            CFG.ARMY_FLAG_WIDTH = IMGManager.getIMG(Images.armyLeft).getWidth() - CFG.ARMY_FLAG_PADDING_X * 2;
            CFG.ARMY_FLAG_HEIGHT = IMGManager.getIMG(Images.armyLeft).getHeight() - CFG.ARMY_FLAG_PADDING_Y * 2;
        }
    }

    public void updatePresence(String key, String value) {
        sUM.uSF.setRichPresence(key, value);
    }

    static {
        EAPWS = false;
        EACDG = false;
        PDR = true;
        DJE = false;
        TDSX = false;
        background = null;
        backgroundID = -1;
        backgroundSize = 1;
        backgroundHeight = -1;
        ENDA = false;
        animated = new ArrayList<Image>();
        animatedID = 0;
        animatedSize = 0;
        animatedHeight = -1;
        animatedTime = 0L;
        animatedFrame = 50L;
    }
}

