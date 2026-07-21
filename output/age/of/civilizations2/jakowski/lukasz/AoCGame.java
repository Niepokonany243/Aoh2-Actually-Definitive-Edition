
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.GameValues.RankingSettings;
import age.of.civilizations2.jakowski.lukasz.Game_Scenarios;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.InitGame;
import age.of.civilizations2.jakowski.lukasz.Keyboard;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MenuManager;
import age.of.civilizations2.jakowski.lukasz.Menus.Action.Menu_InGameProvAction;
import age.of.civilizations2.jakowski.lukasz.Menus.Action.Menu_InGameProvinceActionForeign;
import age.of.civilizations2.jakowski.lukasz.Menus.Action.Menu_SK;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_Top;
import age.of.civilizations2.jakowski.lukasz.Menus.Info.Menu_InGame_ProvInfo;
import age.of.civilizations2.jakowski.lukasz.Menus.Menu_InitGame;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Choose.Menu_ChooseScenario_Title;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Menu_CreateNewGame;
import age.of.civilizations2.jakowski.lukasz.Menus.Options.Menu_InGame_Options;
import age.of.civilizations2.jakowski.lukasz.Menus.Top.Menu_CreateNewGame_Top;
import age.of.civilizations2.jakowski.lukasz.Menus.Turn.Menu_NextPlayerTurn;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_2;
import age.of.civilizations2.jakowski.lukasz.Platform;
import age.of.civilizations2.jakowski.lukasz.ProvinceBorder;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.Render;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.RendererSpriteBatch;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.TouchManager;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ConfigINI;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import java.util.List;

public class AoCGame {
    public static final boolean STEAM_BUILD = true;
    public static final boolean INIT_STEAM = true;
    private Touch touch = new Touch();
    public static int TOP = 0;
    public static int BOTTOM = 0;
    public static int LEFT = 0;
    public static int RIGHT = 0;
    public static OrthographicCamera cameraOrt;
    public static Viewport viewport;
    private RendererSpriteBatch oSB = new RendererSpriteBatch();
    private SpriteBatch oSBNames;
    private long lTimeFPS;
    private int iNumOfFPS = 0;
    public static boolean drawFPS;
    private long perfRenderTotalNs;
    private int perfRenderCount;
    private long androidContinuousUntil;
    private RequestRendering requestRendering;
    public static ShaderProgram shaderDef;
    public static ShaderProgram blackWhiteShdr;
    public static ShaderProgram nextPlayerTurnShdr;
    public static ShaderProgram shaderAlpha3;
    public static ShaderProgram shaderAlpha4;
    private final String VERTEX = "attribute vec4 a_position;attribute vec4 a_color;attribute vec2 a_texCoord0;uniform mat4 u_projTrans;varying vec4 vColor;varying vec2 vTexCoord;void main() {\tvColor = a_color;\tvTexCoord = a_texCoord0;\tgl_Position =  u_projTrans * a_position;}";
    private String vertexShader;
    private String fragmentShader;
    PerspectiveCamera cam;
    CameraInputController camController;
    private boolean MAP_MOVE_LEFT = false;
    private boolean MAP_MOVE_RIGHT = false;
    private boolean MAP_MOVE_TOP = false;
    private boolean MAP_MOVE_BOT = false;
    private static final int DEFAULT_SCROLL_MAP = 12;
    private float iScroll_MAP = 12.0f;
    private long lScrollTime_MAP = 0L;
    private float iScroll_MAPY = 12.0f;
    private long lScrollTime_MAPY = 0L;
    public static final int TYPE_NUMBER_RESET_TIME = 625;
    public static long TYPE_NUMER_TIME;
    public static int TYPE_NUMBER;
    public static boolean CTRL_CLICKED;
    private static final int DEFAULT_SCROLL = 15;
    private int iScroll = 15;
    private long lScrollTime = 0L;

    public void Hi_HowAreYou() {
        int state = 1;
        String author = "\u0141ukasz Jakowski";
        String projectName = "Age of History 2: Definitive Edition";
        String buildStatus = "stable";
        String version = "2.01";
        int checksum = (projectName + version).hashCode();
        int validation = checksum ^ state;
        if (validation != 0 && buildStatus.equals("stable")) {
            System.out.println("System ready.");
        }
    }

    private final void updateRequestRendering(boolean enable) {
        this.requestRendering = enable ? new RequestRendering(){

            @Override
            public void update() {
                if (CFG.renderRequested) {
                    CFG.renderRequested = false;
                    Gdx.graphics.requestRendering();
                }
            }
        } : new RequestRendering(){

            @Override
            public void update() {
                if (CFG.renderRequested) {
                    CFG.renderRequested = false;
                    Gdx.graphics.requestRendering();
                }
            }
        };
    }

    private final void updateAndroidRenderMode() {
        if (!CFG.isAndroid()) return;
        boolean continuous = this.shouldAndroidRenderContinuously();
        long now = System.currentTimeMillis();
        if (continuous) {
            this.androidContinuousUntil = now + 1000L;
        } else {
            continuous = now < this.androidContinuousUntil;
        }
        if (Gdx.graphics.isContinuousRendering() != continuous) {
            Gdx.graphics.setContinuousRendering(continuous);
            Gdx.graphics.requestRendering();
        }
    }

    private final boolean shouldAndroidRenderContinuously() {
        try {
            if (CFG.menus == null || CFG.gameAction == null) return true;
            if (Gdx.input != null && Gdx.input.isTouched()) return true;
            if (RTS.isEnabled() && !RTS.PAUSE) return true;
            if (CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.INPUT_ORDERS) return true;
            if (ProvinceMesh.needsUpdate) return true;
            if (Render.iDiploAnimationsSize > 0) return true;
            if (CFG.achievementGD != null) return true;
            if (CFG.toastM != null && CFG.toastM.getInView()) return true;
            return false;
        }
        catch (Exception ex) {
            return true;
        }
    }

    private Vector2 getIOSSafeAreaInsets() {
        if (Gdx.app.getType() == Application.ApplicationType.iOS) {
            try {
                Class<?> IOSLauncher = Class.forName("age.of.civilizations2.jakowski.lukasz.IOSLauncher");
                return (Vector2)IOSLauncher.getDeclaredMethod("getSafeAreaInsets", new Class[0]).invoke(null, new Object[0]);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Vector2();
    }

    private Vector2 getIOSSafeAreaInsets_LeftRight() {
        if (Gdx.app.getType() == Application.ApplicationType.iOS) {
            try {
                Class<?> IOSLauncher = Class.forName("age.of.civilizations2.jakowski.lukasz.IOSLauncher");
                return (Vector2)IOSLauncher.getDeclaredMethod("getSafeAreaInsets_LeftRight", new Class[0]).invoke(null, new Object[0]);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Vector2();
    }

    public void create() {
        Vector2 a;
        FileManager.initLoadInterface();
        ConfigINI.readConfig();
        if (CFG.isAndroid()) {
            CFG.LOG_PERF = true;
            CFG.LOG_PERF_VERBOSE = false;
            AndroidPerfTracer.setEnabled(true);
            AndroidPerfTracer.setVerbose(false);
        }
        CFG.LANDSCAPE = ConfigINI.landscape;
        if (CFG.isAndroid()) {
            if (CFG.LANDSCAPE) {
                CFG.GAMEWIDTH = Gdx.graphics.getWidth();
                CFG.GAMEHEIGHT = Gdx.graphics.getHeight();
            } else if (Gdx.graphics.getHeight() < Gdx.graphics.getWidth()) {
                CFG.GAMEWIDTH = Gdx.graphics.getHeight();
                CFG.GAMEHEIGHT = Gdx.graphics.getWidth();
            } else {
                CFG.GAMEWIDTH = Gdx.graphics.getWidth();
                CFG.GAMEHEIGHT = Gdx.graphics.getHeight();
            }
        } else {
            CFG.GAMEWIDTH = Gdx.graphics.getWidth();
            CFG.GAMEHEIGHT = Gdx.graphics.getHeight();
        }
        try {
            a = this.getIOSSafeAreaInsets();
            TOP = (int)a.x;
            BOTTOM = (int)a.y;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            a = this.getIOSSafeAreaInsets_LeftRight();
            LEFT = (int)a.x;
            RIGHT = (int)a.y;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        cameraOrt = new OrthographicCamera(CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
        cameraOrt.setToOrtho(false, CFG.GAMEWIDTH, -CFG.GAMEHEIGHT);
        viewport = new FitViewport(CFG.GAMEWIDTH, (float)CFG.GAMEHEIGHT, cameraOrt);
        Renderer.init();
        this.updateRequestRendering(true);
        CFG.loadSettings();
        if (CFG.isAndroid()) {
            Gdx.graphics.setForegroundFPS(0);
        }
        Gdx.graphics.setContinuousRendering(true);
        RankingSettings.load();
        CFG.DENSITY = Gdx.graphics.getDensity();
        if (CFG.DENSITY < 1.0f) {
            CFG.DENSITY = 1.0f;
        }
        if (ConfigINI.iUIScale <= 0) {
            if (CFG.isAndroid()) {
                float mobilePpi = Math.max(Gdx.graphics.getPpiX(), Gdx.graphics.getPpiY());
                int longSide = Math.max(CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                CFG.XHDPI = mobilePpi >= 280.0f || longSide >= 1200;
                CFG.XXHDPI = mobilePpi >= 380.0f || longSide >= 1800;
                CFG.XXXHDPI = mobilePpi >= 480.0f || longSide >= 2600;
            } else if (CFG.getIsDesktop()) {
                CFG.XHDPI = CFG.GAMEWIDTH >= 2400;
            }
        } else if (ConfigINI.iUIScale == 1) {
            CFG.XHDPI = false;
            CFG.XXHDPI = false;
            CFG.XXXHDPI = false;
        } else if (ConfigINI.iUIScale == 2) {
            CFG.XHDPI = true;
            CFG.XXHDPI = false;
            CFG.XXXHDPI = false;
        } else if (ConfigINI.iUIScale == 3) {
            CFG.XHDPI = true;
            CFG.XXHDPI = true;
            CFG.XXXHDPI = false;
        } else if (ConfigINI.iUIScale == 4) {
            CFG.XHDPI = true;
            CFG.XXHDPI = true;
            CFG.XXXHDPI = true;
        } else if (ConfigINI.iUIScale == 5) {
            CFG.XHDPI = true;
            CFG.XXHDPI = true;
            CFG.XXXHDPI = true;
        }
        this.oSB.oSBR = CFG.isAndroid() ? new CpuSpriteBatch(8191) : new SpriteBatch();
        this.oSBNames = CFG.isAndroid() ? new CpuSpriteBatch(8191) : new SpriteBatch();
        this.initInput();
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
        Platform.init();
        Images.btnMenuH = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "menu.png");
        Images.btnClear = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "clear.png");
        Images.btnClose = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "close.png");
        Images.buttonGame = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "buttonGame.png");
        Images.buttonGameH = IMGManager.addIMG("UI/" + CFG.getResPath() + "buttons/" + "buttonGameH.png");
        Images.gradientVertical = IMGManager.addIMG("UI/gradients/gradientVertical.png");
        Images.gradientHorizontal = IMGManager.addIMG("UI/gradients/gradientHorizontal.png");
        Images.gradientHorizontal2 = IMGManager.addIMG("UI/gradients/gradientHorizontal2.png");
        Images.gradientHorizontal3 = IMGManager.addIMG("UI/gradients/gradientHorizontal3.png");
        Images.gradientFull = IMGManager.addIMG("UI/gradients/gradientFull.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear);
        Images.gradientFull2 = IMGManager.addIMG("UI/gradients/gradientFull2.png");
        Images.gradientXY = IMGManager.addIMG("UI/gradients/gradientXY.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear);
        Images.gradientXYVertical = IMGManager.addIMG("UI/gradients/gradientXYVertical.png");
        Images.statsRectBG = IMGManager.addIMG("UI/" + CFG.getResPath() + "boxes/" + "statsRectBG.png");
        Images.statsRectBGBorder = IMGManager.addIMG("UI/" + CFG.getResPath() + "boxes/" + "statsRectBGBorder.png");
        Images.line32Off1 = IMGManager.addIMG("UI/lines/line_32_off1.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat);
        Images.gradient = IMGManager.addIMG("UI/" + CFG.getResPath() + "gradient.png");
        Images.loading_rect_edge = IMGManager.addIMG("UI/" + CFG.getResPath() + "loading/" + "loading_edge.png", Pixmap.Format.RGBA8888, Texture.TextureFilter.Nearest, Texture.TextureWrap.ClampToEdge);
        Images.pix255 = IMGManager.addIMG("UI/pix", Pixmap.Format.RGBA8888, Texture.TextureFilter.Linear, Texture.TextureWrap.Repeat);
        CFG.BUTTON_H = IMGManager.getIMG(Images.btnMenuH).getHeight();
        CFG.BUTTON_W = CFG.XXXHDPI ? 180 : (CFG.XXHDPI ? 160 : (CFG.XHDPI ? 120 : 90));
        CFG.GUI_SCALE = 100.0f * (float)CFG.BUTTON_H / 68.0f / 100.0f;
        CFG.PADD = (int)(5.0f * CFG.GUI_SCALE);
        if (CFG.isAndroid()) {
            CFG.PADD = Math.max(CFG.PADD, (int)(6.0f * CFG.GUI_SCALE));
            CFG.BUTTON_W = Math.max(CFG.BUTTON_W, (int)(96.0f * CFG.GUI_SCALE));
        }
        CFG.CIV_INFO_MENU_WIDTH = (int)((float)CFG.CIV_INFO_MENU_WIDTH * CFG.GUI_SCALE);
        CFG.CIV_COLOR_W = (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE);
        CFG.SERVICE_RIBBON_WIDTH = (int)((float)CFG.SERVICE_RIBBON_WIDTH * CFG.GUI_SCALE);
        CFG.SERVICE_RIBBON_HEIGHT = (int)((float)CFG.SERVICE_RIBBON_HEIGHT * CFG.GUI_SCALE);
        if (CFG.settingsGD.FONT_MAIN_SIZEX < 0) {
            CFG.settingsGD.FONT_MAIN_SIZEX = (int)(18.0f * CFG.GUI_SCALE);
        }
        AoCGame.updateArmyFontSize();
        Images.gameLogo = IMGManager.addIMG2("UI/" + CFG.getResPath() + "game_logo.png");
        CFG.menus = new MenuManager();
        Render.updateRenderer();
        Render.updateDrawMoveUnits();
        CFG.SFXManager = new SFXManager();
        new InitGame();
        ShaderProgram.pedantic = false;
        String defaultVertex = FileManager.loadFile("game/shader/default_vertex.glsl").readString();
        String flagFragment = FileManager.loadFile("game/shader/flag_fragment.glsl").readString();
        String nextPlayerTurnVertex = FileManager.loadFile("game/shader/nextPlayerTurn_vertex.glsl").readString();
        shaderAlpha4 = new ShaderProgram("attribute vec4 a_position;attribute vec4 a_color;attribute vec2 a_texCoord0;uniform mat4 u_projTrans;varying vec4 vColor;varying vec2 vTexCoord;void main() {\tvColor = a_color;\tvTexCoord = a_texCoord0;\tgl_Position =  u_projTrans * a_position;}", flagFragment);
        shaderAlpha4.begin();
        shaderAlpha4.setUniformi("u_texture1", 1);
        shaderAlpha4.setUniformi("u_mask", 2);
        shaderAlpha4.end();
        this.vertexShader = "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projTrans * a_position;\n}\n";
        this.fragmentShader = "#ifdef GL_ES\nprecision mediump float;\n#endif\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nuniform sampler2D u_texture2;\nuniform float u_maskScale;\nuniform float u_useMask;\nuniform vec2 u_maskOffset;\nvoid main()                                  \n{                                            \n vec2 newCoords = -1.0 * (u_maskScale - 1.0)/2.0 + (u_maskScale * v_texCoords) + u_maskOffset;\n vec4 mask = vec4(1.0, 1.0, 1.0, 1.0); \nif(u_useMask > 0.5) \n\tmask = texture2D(u_texture2, v_texCoords);\n vec4 color = v_color * texture2D(u_texture, newCoords);\n  gl_FragColor = vec4(color.rgb, color.a * mask.r);\n}";
        shaderAlpha3 = new ShaderProgram(this.vertexShader, this.fragmentShader);
        shaderAlpha3.begin();
        shaderAlpha3.setUniformi("u_texture", 0);
        shaderAlpha3.setUniformi("u_texture2", 1);
        shaderAlpha3.setUniformf("u_useMask", 1.0f);
        shaderAlpha3.setUniformf("u_maskScale", 20.0f);
        shaderAlpha3.setUniformf("u_maskOffset", 0.0f, 0.0f);
        Images.statsBox = Images.gameLogo;
        String defaultFragment = FileManager.loadFile("game/shader/default_fragment.glsl").readString();
        String blackWhiteFragment = FileManager.loadFile("game/shader/blackWhite_fragment.glsl").readString();
        String nextPlayerTurnFragment = FileManager.loadFile("game/shader/nextPlayerTurn_fragment.glsl").readString();
        shaderDef = new ShaderProgram(defaultVertex, defaultFragment);
        blackWhiteShdr = new ShaderProgram(defaultVertex, blackWhiteFragment);
        nextPlayerTurnShdr = new ShaderProgram(nextPlayerTurnVertex, nextPlayerTurnFragment);
        ProvinceBorder.initBatch();
        AoCGame.loadCursor(true);
        Menu_InGame_2.initTopBox();
        if (CFG.isAndroid()) {
            VisibleProvinceCache.init();
            String renderer = Gdx.gl.glGetString(GL20.GL_RENDERER);
            if (renderer == null || !renderer.contains("Mali")) {
                FlagAtlas.init();
                CapitalFlagRenderer.init();
            }
        }
    }

    public static final void loadCursor(boolean inInit) {
        if (CFG.settingsGD.loadCursor) {
            try {
                Pixmap pixmap = new Pixmap(FileManager.loadFile("UI/icons/cursor.png"));
                Cursor cursor = Gdx.graphics.newCursor(pixmap, 0, 0);
                Gdx.graphics.setCursor(cursor);
                pixmap.dispose();
            }
            catch (GdxRuntimeException gdxRuntimeException) {}
        } else if (!inInit) {
            Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
        }
    }

    public static final void updateArmyFontSize() {
        if (CFG.settingsGD.FONT_ARMY_SIZEX < 0) {
            CFG.settingsGD.FONT_ARMY_SIZEX = CFG.XXXHDPI || CFG.XXHDPI ? 22 : 22;
        }
    }

    public void update() {
        CFG.currentTimeMillis = System.currentTimeMillis();
        Renderer.shaderTime2 += Gdx.graphics.getDeltaTime();
        this.countFPS();
        try {
            if (CFG.core == null) {
                return;
            }
            CFG.core.update();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            CFG.map.update();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            CFG.menus.update();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public void render() {
        long renderStart = System.currentTimeMillis();
        if (CFG.isAndroid()) AndroidPerfTracer.beginFrame();
        try { this.update(); this.updateMoveMap(); } catch (Exception ex) {}
        long perfPhase1 = 0L, perfPhase2 = 0L, perfPhase3 = 0L, perfPhase4 = 0L;
        if (CFG.core != null) {
            try { ProvinceBorder.drawProvBorder_Prepare(); } catch (Exception ex) {}
            {
                try {
                    long phaseStart = System.currentTimeMillis();
                    Gdx.gl.glClearColor(CFG.BG_COLOR.r, CFG.BG_COLOR.g, CFG.BG_COLOR.b, CFG.BG_COLOR.a);
                    Gdx.gl.glClear(16640);
                    viewport.setWorldSize((float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc(), (float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc());
                    viewport.apply();
                    cameraOrt.setToOrtho(true, (float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc(), (float)(-CFG.GAMEHEIGHT) / CFG.map.getMpS().getCurrSc());
                    this.oSB.oSBR.setProjectionMatrix(AoCGame.cameraOrt.combined);
                    Renderer.oSBBorder2.oSBR.setProjectionMatrix(AoCGame.cameraOrt.combined);
                    if (this.oSB.oSBR.isDrawing()) this.oSB.end();
                    if (Renderer.oSBBorder2.oSBR.isDrawing()) Renderer.oSBBorder2.end();
                    this.oSB.begin();
                    if (!Renderer.oSBBorder2.oSBR.isDrawing()) Renderer.oSBBorder2.begin();
                    this.oSB.oSBR.setShader(shaderDef);
                    if (CFG.isAndroid()) { AndroidPerfTracer.beginPhase(); Render.draw(this.oSB.oSBR); AndroidPerfTracer.endPhase("WorldScaled"); }
                    else { Render.draw(this.oSB.oSBR); }
                    perfPhase1 = System.currentTimeMillis() - phaseStart;
                    if (this.oSB.oSBR.isDrawing()) this.oSB.end();
                    if (Renderer.oSBBorder2.oSBR.isDrawing()) Renderer.oSBBorder2.end();
                    cameraOrt.setToOrtho(false, CFG.GAMEWIDTH, -CFG.GAMEHEIGHT);
                    viewport.setWorldSize(CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                    viewport.apply();
                    this.oSB.oSBR.setProjectionMatrix(AoCGame.cameraOrt.combined);
                    this.oSBNames.setProjectionMatrix(AoCGame.cameraOrt.combined);
                    Renderer.oSBBorder2.oSBR.setProjectionMatrix(AoCGame.cameraOrt.combined);
                    if (this.oSB.oSBR.isDrawing()) this.oSB.end();
                    if (Renderer.oSBBorder2.oSBR.isDrawing()) Renderer.oSBBorder2.end();
                    this.oSB.begin();
                    if (!this.oSBNames.isDrawing()) this.oSBNames.begin();
                    if (!Renderer.oSBBorder2.oSBR.isDrawing()) Renderer.oSBBorder2.begin();
                    if (CFG.isAndroid()) AndroidPerfTracer.beginPhase();
                    long phase2Start = System.currentTimeMillis();
                    Render.drawWithoutScale(this.oSB.oSBR, this.oSBNames);
                    if (CFG.isAndroid()) AndroidPerfTracer.endPhase("DrawWithoutScale");
                    perfPhase2 = System.currentTimeMillis() - phase2Start;
                    if (this.oSB.oSBR.isDrawing()) this.oSB.end();
                    if (this.oSBNames.isDrawing()) this.oSBNames.end();
                    if (Renderer.oSBBorder2.oSBR.isDrawing()) Renderer.oSBBorder2.end();
                    viewport.setWorldSize((float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc(), (float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc());
                    viewport.apply();
                    cameraOrt.setToOrtho(true, (float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc(), (float)(-CFG.GAMEHEIGHT) / CFG.map.getMpS().getCurrSc());
                    this.oSB.oSBR.setProjectionMatrix(AoCGame.cameraOrt.combined);
                    Renderer.oSBBorder2.oSBR.setProjectionMatrix(AoCGame.cameraOrt.combined);
                    if (this.oSB.oSBR.isDrawing()) this.oSB.end();
                    if (Renderer.oSBBorder2.oSBR.isDrawing()) Renderer.oSBBorder2.end();
                    this.oSB.begin();
                    if (!Renderer.oSBBorder2.oSBR.isDrawing()) Renderer.oSBBorder2.begin();
                    long phase3Start = System.currentTimeMillis();
                    this.oSB.oSBR.setShader(shaderDef);
                    if (CFG.isAndroid()) AndroidPerfTracer.beginPhase();
                    Render.drawMapDetails(this.oSB.oSBR);
                    CFG.cloudsAnimation.cloudsInterface.drawCloudsInterface(this.oSB.oSBR);
                    if (CFG.isAndroid()) AndroidPerfTracer.endPhase("Overlays");
                    perfPhase3 = System.currentTimeMillis() - phase3Start;
                    if (this.oSB.oSBR.isDrawing()) this.oSB.end();
                    if (Renderer.oSBBorder2.oSBR.isDrawing()) Renderer.oSBBorder2.end();
                } catch (IllegalStateException ex) {
                    CFG.exceptionStack(ex);
                    try { if (this.oSB.oSBR.isDrawing()) this.oSB.end(); } catch (Exception ex2) {}
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                    try { if (this.oSB.oSBR.isDrawing()) this.oSB.end(); } catch (Exception ex2) {}
                }
            }
            if (CFG.isAndroid()) AndroidPerfTracer.beginPhase();
            long phase4Start = System.currentTimeMillis();
            cameraOrt.setToOrtho(false, CFG.GAMEWIDTH, -CFG.GAMEHEIGHT);
            viewport.setWorldSize(CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
            viewport.apply();
            this.oSB.oSBR.setProjectionMatrix(AoCGame.cameraOrt.combined);
            Renderer.oSBBorder2.oSBR.setProjectionMatrix(AoCGame.cameraOrt.combined);
            this.oSB.begin();
            this.oSB.oSBR.setColor(Color.WHITE);
            CFG.menus.drawMM(this.oSB.oSBR);
            CFG.editorManager.draw(this.oSB.oSBR);
            if (drawFPS) { try { CFG.drawTextDefaultWithShadow(this.oSB.oSBR, "FPS: " + CFG.iNumOfFPS, CFG.PADD * 2, CFG.PADD * 2, Color.WHITE); } catch (Exception ex) {} }
            this.oSB.oSBR.setColor(Color.WHITE);
            this.oSB.end();
            if (CFG.isAndroid()) {
                AndroidPerfTracer.recordBatchStats(this.oSB.oSBR.renderCalls, this.oSB.oSBR.totalRenderCalls, this.oSB.oSBR.maxSpritesInBatch);
                AndroidPerfTracer.endPhase("MenuMM");
            }
            perfPhase4 = System.currentTimeMillis() - phase4Start;
        } else {
            try {
                Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                Gdx.gl.glClear(16640);
                cameraOrt.setToOrtho(false, CFG.GAMEWIDTH, -CFG.GAMEHEIGHT);
                viewport.setWorldSize(CFG.GAMEWIDTH, CFG.GAMEHEIGHT);
                viewport.apply();
                this.oSB.oSBR.setProjectionMatrix(AoCGame.cameraOrt.combined);
                this.oSB.begin();
                this.oSB.oSBR.setColor(Color.WHITE);
                if (CFG.menus != null) CFG.menus.drawMM(this.oSB.oSBR);
                this.oSB.end();
            } catch (Exception ex) { try { if (this.oSB.oSBR.isDrawing()) this.oSB.end(); } catch (Exception e2) {} }
        }
        this.updateAndroidRenderMode();
        this.requestRendering.update();
        if (CFG.isAndroid()) AndroidPerfTracer.endFrame();
        long renderTotalMs = System.currentTimeMillis() - renderStart;
        perfRenderTotalNs += renderTotalMs;
        if (++perfRenderCount >= 300) {
            if (CFG.LOG_PERF) {
                long avgMs = perfRenderTotalNs / perfRenderCount;
                Runtime rt = Runtime.getRuntime();
                long used = (rt.totalMemory() - rt.freeMemory()) / 1048576L;
                long totalMem = rt.totalMemory() / 1048576L;
                long maxMem = rt.maxMemory() / 1048576L;
                CFG.LOG("PERF", "[avg] " + avgMs + "ms/frame over " + perfRenderCount + " frames  mem=" + used + "/" + totalMem + "/" + maxMem + "MB" + (avgMs > 50 ? "  fps=" + CFG.iNumOfFPS : ""));
            }
            perfRenderTotalNs = 0;
            perfRenderCount = 0;
        }
    }

    private void countFPS() {
        ++this.iNumOfFPS;
        if (System.currentTimeMillis() > this.lTimeFPS + 1000L) {
            this.lTimeFPS = System.currentTimeMillis();
            CFG.iNumOfFPS = this.iNumOfFPS;
            this.iNumOfFPS = 0;
        }
    }

    public void resize(int width, int height) {
        if (CFG.isAndroid()) {
            if (CFG.LANDSCAPE) {
                viewport.update(width, height, false);
            } else {
                viewport.update(-height, -width, false);
            }
        } else {
            viewport.update(width, height, false);
        }
    }

    public static List<Image> disposeImages() {
        return IMGManager.getImages();
    }

    public void dispose() {
        try {
            Platform.shutdown();
            ProvinceBorder.disposeBatch();
            this.oSB.oSBR.dispose();
            this.oSBNames.dispose();
            Renderer.oSBBorder2.oSBR.dispose();
            try {
                for (int a = 0; a < CFG.fontMain.size(); ++a) {
                    CFG.fontMain.get(a).dispose();
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                if (CFG.fontBorder != null) {
                    CFG.fontBorder.dispose();
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                if (CFG.fontBorder2 != null) {
                    CFG.fontBorder2.dispose();
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                for (int i = 0; i < IMGManager.getImagesSize(); ++i) {
                    IMGManager.getIMG(i).getTexture().dispose();
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                for (int i = 0; i < CFG.cloudsAnimation.iCL.size(); ++i) {
                    CFG.cloudsAnimation.iCL.get(i).dispose();
                }
            }
            catch (Exception i) {
                
            }
            try {
                CFG.map.getMpB().disposeGameMap();
            }
            catch (Exception i) {
                
            }
            try {
                if (!CFG.flagOfCivilizationH.isEmpty()) {
                    for (int i = CFG.flagOfCivilizationH.size() - 1; i >= 0; --i) {
                        CFG.flagOfCivilizationH.get(i).dispose();
                    }
                    CFG.flagOfCivilizationH.clear();
                }
            }
            catch (Exception i) {
                
            }
            try {
                CFG.map.mpOv.dispose();
            }
            catch (Exception i) {
                
            }
            try {
                CFG.SFXManager.dispose();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                if (Menu_InitGame.background != null) {
                    Menu_InitGame.background.dispose();
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                VisibleProvinceCache.dispose();
            }
            catch (Exception ex) {
            }
            try {
                FlagAtlas.dispose();
            }
            catch (Exception ex) {
            }
            try {
                CapitalFlagRenderer.dispose();
            }
            catch (Exception ex) {
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    private final void updateMoveMap() {
        block8: {
            try {
                if (this.MAP_MOVE_LEFT) {
                    this.updateScroll_Map();
                    CFG.map.getMpC().setNewPosX(CFG.map.getMpC().getPX() + (int)this.iScroll_MAP);
                } else if (this.MAP_MOVE_RIGHT) {
                    this.updateScroll_Map();
                    CFG.map.getMpC().setNewPosX(CFG.map.getMpC().getPX() - (int)this.iScroll_MAP);
                }
                if (this.MAP_MOVE_TOP) {
                    this.updateScroll_MapY();
                    CFG.map.getMpC().setNewPosY(CFG.map.getMpC().getPY() + (int)this.iScroll_MAPY);
                } else if (this.MAP_MOVE_BOT) {
                    this.updateScroll_MapY();
                    CFG.map.getMpC().setNewPosY(CFG.map.getMpC().getPY() - (int)this.iScroll_MAPY);
                }
            }
            catch (Exception ex) {
                if (!CFG.LOGs) break block8;
                CFG.exceptionStack(ex);
            }
        }
    }

    private final void updateScroll_Map() {
        if (this.lScrollTime_MAP + 150L < System.currentTimeMillis()) {
            this.lScrollTime_MAP = System.currentTimeMillis();
            this.iScroll_MAP += this.iScroll_MAP * 0.475f;
            float f = CFG.map.getMpS().getCurrSc() < 1.0f ? 1.0f + (1.0f - CFG.map.getMpS().getCurrSc()) : 1.0f;
            if (this.iScroll_MAP > 35.0f * f) {
                this.iScroll_MAP = 35.0f * (CFG.map.getMpS().getCurrSc() < 1.0f ? 1.0f + (1.0f - CFG.map.getMpS().getCurrSc()) : 1.0f);
            }
        }
    }

    private final void updateScroll_MapY() {
        if (this.lScrollTime_MAPY + 150L < System.currentTimeMillis()) {
            this.lScrollTime_MAPY = System.currentTimeMillis();
            this.iScroll_MAPY += this.iScroll_MAPY * 0.475f;
            float f = CFG.map.getMpS().getCurrSc() < 1.0f ? 1.0f + (1.0f - CFG.map.getMpS().getCurrSc()) : 1.0f;
            if (this.iScroll_MAPY > 35.0f * f) {
                this.iScroll_MAPY = 35.0f * (CFG.map.getMpS().getCurrSc() < 1.0f ? 1.0f + (1.0f - CFG.map.getMpS().getCurrSc()) : 1.0f);
            }
        }
    }

    public final void typeNumber(int iNum) {
        if (System.currentTimeMillis() - 625L > TYPE_NUMER_TIME) {
            TYPE_NUMBER = iNum;
        } else {
            TYPE_NUMBER *= 10;
            TYPE_NUMBER += iNum;
        }
        TYPE_NUMER_TIME = System.currentTimeMillis();
    }

    public static final void resetTypeNumber() {
        TYPE_NUMER_TIME = 0L;
        TYPE_NUMBER = 0;
    }

    public void initInput() {
        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean keyDown(int keycode) {
                try {
                    if (CFG.menus.getIn_SKMenu()) {
                        if (keycode == 21) {
                            return true;
                        }
                        if (keycode == 22) {
                            return true;
                        }
                        if (keycode == 19) {
                            return true;
                        }
                        if (keycode == 20) {
                            return true;
                        }
                    }
                    if (keycode == 129 || keycode == 130) {
                        CTRL_CLICKED = true;
                    }
                    if (!CFG.menus.getKeyboard().getVisibleM()) {
                        if (CFG.editorManager.keyDown(keycode)) {
                            return true;
                        }
                        if (keycode == 21) {
                            AoCGame.this.MAP_MOVE_LEFT = true;
                            AoCGame.this.MAP_MOVE_RIGHT = false;
                            AoCGame.this.lScrollTime_MAP = System.currentTimeMillis();
                            AoCGame.this.iScroll_MAP = 15.0f;
                        }
                        if (keycode == 22) {
                            AoCGame.this.MAP_MOVE_RIGHT = true;
                            AoCGame.this.MAP_MOVE_LEFT = false;
                            AoCGame.this.lScrollTime_MAP = System.currentTimeMillis();
                            AoCGame.this.iScroll_MAP = 15.0f;
                        }
                        if (keycode == 19) {
                            AoCGame.this.MAP_MOVE_TOP = true;
                            AoCGame.this.MAP_MOVE_BOT = false;
                            AoCGame.this.lScrollTime_MAPY = System.currentTimeMillis();
                            AoCGame.this.iScroll_MAPY = 15.0f;
                        }
                        if (keycode == 20) {
                            AoCGame.this.MAP_MOVE_BOT = true;
                            AoCGame.this.MAP_MOVE_TOP = false;
                            AoCGame.this.lScrollTime_MAPY = System.currentTimeMillis();
                            AoCGame.this.iScroll_MAPY = 15.0f;
                        }
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                return true;
            }

            
            @Override
            public boolean keyUp(int keycode) {
                try {
                    if (CFG.menus.getIn_SKMenu()) {
                        try {
                            if (keycode == 21) {
                                Menu_SK.snakeGame.setDirection(-1, 0);
                                return true;
                            }
                            if (keycode == 22) {
                                Menu_SK.snakeGame.setDirection(1, 0);
                                return true;
                            }
                            if (keycode == 19) {
                                Menu_SK.snakeGame.setDirection(0, -1);
                                return true;
                            }
                            if (keycode == 20) {
                                Menu_SK.snakeGame.setDirection(0, 1);
                                return true;
                            }
                        }
                        catch (Exception ex) {
                            return true;
                        }
                    }
                    if (CTRL_CLICKED) {
                        try {
                            if (CFG.menus.getKeyboard().getVisibleM()) {
                                if (keycode == 50) {
                                    CFG.keybMess = Gdx.app.getClipboard().getContents();
                                    CFG.toastM.addM(CFG.lang.get("Paste") + ": " + CFG.keybMess);
                                    return true;
                                }
                                if (keycode == 31) {
                                    Gdx.app.getClipboard().setContents(CFG.keybMess);
                                    CFG.toastM.addM(CFG.lang.get("Copy") + ": " + CFG.keybMess);
                                    return true;
                                }
                                if (keycode == 52) {
                                    CFG.toastM.addM(CFG.lang.get("Cut") + ": " + CFG.keybMess);
                                    Gdx.app.getClipboard().setContents(CFG.keybMess);
                                    CFG.keybMess = "";
                                    return true;
                                }
                            }
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                    }
                    if (keycode == 129 || keycode == 130) {
                        CTRL_CLICKED = false;
                    }
                    if (!CFG.menus.getKeyboard().getVisibleM()) {
                        if (CFG.editorManager.keyUp(keycode)) {
                            return true;
                        }
                        if (keycode == 21) {
                            AoCGame.this.MAP_MOVE_LEFT = false;
                        }
                        if (keycode == 22) {
                            AoCGame.this.MAP_MOVE_RIGHT = false;
                        }
                        if (keycode == 19) {
                            AoCGame.this.MAP_MOVE_TOP = false;
                        }
                        if (keycode == 20) {
                            AoCGame.this.MAP_MOVE_BOT = false;
                        }
                        if (!CFG.getIsDesktop()) return false;
                        if (CFG.menus.getDialogMenu().getVisibleM()) {
                            if (keycode == 66 || keycode == 160 || keycode == 62) {
                                CFG.menus.getDialogMenu().getMenuElem(1).setClickable(false);
                                CFG.menus.getDialogMenu().getMenuElem(2).setClickable(false);
                                CFG.dialog_True();
                                CFG.menus.getDialogMenu().onBackPressed();
                                return false;
                            } else {
                                if (keycode != 111 && keycode != 67) return false;
                                CFG.menus.getDialogMenu().getMenuElem(1).setClickable(false);
                                CFG.menus.getDialogMenu().getMenuElem(2).setClickable(false);
                                CFG.dialog_False();
                                CFG.menus.getDialogMenu().onBackPressed();
                            }
                            return false;
                        }
                        if (keycode == 141) {
                            CFG.SFXManager.loadNextMusic();
                            return false;
                        }
                        if (CFG.menus.getInGameView()) {
                            if (keycode == 3) {
                                try {
                                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                                    CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE) {
                                        CFG.core.disableDrawCivilizationRegions_Active();
                                        CFG.core.enableDrawCivilizationRegions_ActiveProvince();
                                    }
                                    if (CFG.menus.getVisible_InGame_FlagAction()) {
                                        CFG.menus.setVisible_InGame_FlagAction(false);
                                    }
                                    if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getName().length() <= 0) return false;
                                    CFG.toastM.addM(CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                                    return false;
                                }
                                catch (IndexOutOfBoundsException ex) {
                                    if (!CFG.LOGs) return false;
                                    CFG.exceptionStack(ex);
                                }
                                return false;
                            }
                            if (keycode == 111) {
                                if (CFG.menus.getVisible_InGame_FlagAction()) {
                                    Menu_InGame_2.clickFlagAction();
                                    return false;
                                } else if (CFG.regroupArmyMode) {
                                    CFG.core.resetRegroupArmy_Data();
                                    CFG.core.checkProvinceActionMenu();
                                    return false;
                                } else if (CFG.chooseProvinceMode || CFG.chosenProvinceID >= 0) {
                                    CFG.core.resetChooseProvinceData();
                                    CFG.core.checkProvinceActionMenu();
                                    return false;
                                } else if (CFG.menus.getInGameView_Options()) {
                                    Menu_InGame_Options.clickBack();
                                    return false;
                                } else if (CFG.menus.getInGame_ProvinceRecruit_Visible()) {
                                    CFG.menus.setVisible_InGame_ProviRecruit(false);
                                    CFG.core.checkProvinceActionMenu();
                                    return false;
                                } else if (CFG.menus.getInGame_ProvinceRecruitInstantly_Visible()) {
                                    CFG.menus.setVisible_InGame_ProvinceRecruitInstantly(false);
                                    CFG.core.checkProvinceActionMenu();
                                    return false;
                                } else if (CFG.menus.getInGame_ProvinceDisband_Visible()) {
                                    CFG.menus.setVisible_InGame_ProvinceDisband(false);
                                    CFG.core.checkProvinceActionMenu();
                                    return false;
                                } else {
                                    Menu_InGame_FA_Top.clickOptions();
                                }
                                return false;
                            }
                            if (keycode == 69 || keycode == 156) {
                                RTS.updateSpeed(-1);
                                return false;
                            }
                            if (keycode == 81 || keycode == 157) {
                                RTS.updateSpeed(1);
                                return false;
                            }
                            if (keycode == 66 || keycode == 160) {
                                if (!CFG.menus.getInGameView_Options() && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS && (CFG.menus.getInGame_ProvinceMoveUnits_Visible() || CFG.menus.getInGame_ProvinceRecruit_Visible() || CFG.menus.getInGame_ProvinceRecruitInstantly_Visible() || CFG.menus.getInGame_ProvinceRegroupArmy_Visible() || CFG.menus.getInGame_ProvinceDisband_Visible())) {
                                    if (CFG.menus.getInGame_ProvinceMoveUnits_Visible()) {
                                        CFG.menus.getInGame_ProvinceMoveUnits_Confrim();
                                    }
                                    if (CFG.menus.getInGame_ProvinceRecruit_Visible()) {
                                        CFG.menus.getInGame_ProvinceRecruit_Confrim();
                                    }
                                    if (CFG.menus.getInGame_ProvinceRecruitInstantly_Visible()) {
                                        CFG.menus.getInGame_ProvinceRecruitInstantly_Confrim();
                                    }
                                    if (CFG.menus.getInGame_ProvinceRegroupArmy_Visible()) {
                                        CFG.menus.getInGame_ProvinceRegroupArmy_ConfirmMove();
                                    }
                                    if (!CFG.menus.getInGame_ProvinceDisband_Visible()) return false;
                                    CFG.menus.getInGame_ProvinceDisband_Confrm();
                                    return false;
                                } else {
                                    RTS.pauseUnpause();
                                }
                                return false;
                            }
                            if (CFG.menus.getInGameView_Options()) return false;
                            if (keycode == 62) {
                                if (CFG.menus.getInGame_ProvinceRegroupArmy_Visible()) {
                                    CFG.menus.getInGame_ProvinceRegroupArmy_ConfirmMove();
                                    CFG.SFXManager.playSound(CFG.SFXManager.playMoveArmy());
                                    return true;
                                }
                                if (CFG.menus.getInGame_ProvinceDisband_Visible()) {
                                    CFG.menus.getInGame_ProvinceDisband_Confrm();
                                    CFG.SFXManager.playSound(SFXManager.SFX_CLICK2);
                                    return true;
                                }
                                if (CFG.menus.getInGame_ProvinceRecruitInstantly_Visible()) {
                                    CFG.menus.getInGame_ProvinceRecruitInstantly_Confrim();
                                    CFG.SFXManager.playSound(SFXManager.SFX_RECRUIT);
                                    return true;
                                }
                                if (CFG.menus.getInGame_ProvinceRecruit_Visible()) {
                                    CFG.menus.getInGame_ProvinceRecruit_Confrim();
                                    CFG.SFXManager.playSound(SFXManager.SFX_RECRUIT);
                                    return true;
                                }
                                if (CFG.menus.getInGame_ProvinceMoveUnits_Visible()) {
                                    CFG.menus.getInGame_ProvinceMoveUnits_Confrim();
                                    CFG.SFXManager.playSound(SFXManager.SFX_MOVE_ARMY);
                                    return true;
                                }
                                if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                                    RTS.PAUSE = true;
                                    RTS.resetTime();
                                }
                                try {
                                    if (CFG.menus.getInGameProvInfo().getMenuElem(0).getIsClickable()) {
                                        Menu_InGame_ProvInfo.clickEndTurn();
                                    }
                                }
                                catch (NullPointerException ex) {
                                    CFG.exceptionStack(ex);
                                }
                                catch (IndexOutOfBoundsException ex) {
                                    CFG.exceptionStack(ex);
                                }
                            }
                            if (CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.INPUT_ORDERS) return false;
                            if (CFG.menus.getInGame_ProvinceMoveUnits_Visible() || CFG.menus.getInGame_ProvinceRecruit_Visible() || CFG.menus.getInGame_ProvinceRecruitInstantly_Visible() || CFG.menus.getInGame_ProvinceRegroupArmy_Visible() || CFG.menus.getInGame_ProvinceDisband_Visible()) {
                                if (keycode == 7 || keycode == 144) {
                                    AoCGame.this.typeNumber(0);
                                } else if (keycode == 8 || keycode == 145) {
                                    AoCGame.this.typeNumber(1);
                                } else if (keycode == 9 || keycode == 146) {
                                    AoCGame.this.typeNumber(2);
                                } else if (keycode == 10 || keycode == 147) {
                                    AoCGame.this.typeNumber(3);
                                } else if (keycode == 11 || keycode == 148) {
                                    AoCGame.this.typeNumber(4);
                                } else if (keycode == 12 || keycode == 149) {
                                    AoCGame.this.typeNumber(5);
                                } else if (keycode == 13 || keycode == 150) {
                                    AoCGame.this.typeNumber(6);
                                } else if (keycode == 14 || keycode == 151) {
                                    AoCGame.this.typeNumber(7);
                                } else if (keycode == 15 || keycode == 152) {
                                    AoCGame.this.typeNumber(8);
                                } else if (keycode == 16 || keycode == 153) {
                                    AoCGame.this.typeNumber(9);
                                }
                                if (CFG.menus.getInGame_ProvinceMoveUnits_Visible()) {
                                    CFG.menus.getInGame_ProvinceMoveUnits_Slider().setCurr(TYPE_NUMBER);
                                    CFG.menus.updateInGame_ActionInfo_Move();
                                }
                                if (CFG.menus.getInGame_ProvinceRecruit_Visible()) {
                                    CFG.menus.getInGame_ProvRecruitSlider().setCurr(TYPE_NUMBER);
                                    CFG.menus.updateInGame_ActionInfo_Recruit();
                                }
                                if (CFG.menus.getInGame_ProvinceRecruitInstantly_Visible()) {
                                    CFG.menus.getInGame_ProvinceRecruitInstantly_Slider().setCurr(TYPE_NUMBER);
                                    CFG.menus.updateInGame_ActionInfo_RecruitInstantly();
                                }
                                if (CFG.menus.getInGame_ProvinceRegroupArmy_Visible()) {
                                    CFG.menus.getInGame_RegroupArmy_Slider().setCurr(TYPE_NUMBER);
                                    CFG.menus.updateInGame_ActionInfo_Regroup();
                                }
                                if (CFG.menus.getInGame_ProvinceDisband_Visible()) {
                                    CFG.menus.getInGame_ProvinceDisband_Slider().setCurr(TYPE_NUMBER);
                                    CFG.menus.updateInGame_ActionInfo_Disband();
                                }
                            }
                            if (keycode == 77) {
                                CFG.menus.setVisible_InGame_FlagAction_Console(!CFG.menus.getVisible_InGame_FlagAction_Console());
                            }
                            if (keycode == 131) {
                                Menu_InGame_2.clickFlagAction();
                            } else if (keycode == 132 || keycode == 61) {
                                if (CFG.menus.getVisible_InGame_FlagAction()) {
                                    Menu_InGame_2.clickFlagAction();
                                }
                                CFG.menus.setVisible_InGame_CivInfo(!CFG.menus.getVisible_InGame_CivInfo());
                            } else if (keycode == 133) {
                                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_DIPLOMACY_MODE);
                            } else if (keycode == 134) {
                                CFG.menus.setVisible_InGame_MapModes(!CFG.menus.getInGame_MapModes().getVisibleM());
                                if (CFG.menus.getInGame_MapModes().getPosX() < 0) {
                                    CFG.menus.getInGame_MapModes().setPosX_Force(CFG.menus.getInGameMenu().getMenuElem(9).getPosXE() + CFG.menus.getInGameMenu().getMenuElem(9).getWidthE() / 2 - CFG.menus.getInGame_MapModes().getWidthM() / 2);
                                    CFG.menus.getInGame_MapModes().setPosY(CFG.menus.getInGame_MapModes().getTitleM().getHeightT() + CFG.menus.getInGameMenu().getMenuElem(9).getPosY() + CFG.menus.getInGameMenu().getMenuElem(9).getHeightE() + CFG.PADD);
                                    if (CFG.menus.getInGame_MapModes().getPosX() + CFG.menus.getInGame_MapModes().getWidthM() > CFG.GAMEWIDTH - CFG.PADD) {
                                        CFG.menus.getInGame_MapModes().setPosX_Force(CFG.GAMEWIDTH - CFG.PADD - CFG.menus.getInGame_MapModes().getWidthM());
                                    }
                                }
                            } else if (keycode == 135) {
                                if (GameValues.gvInGame.USE_IN_GAME_OLD_STATS_MENU) {
                                    if (CFG.menus.getVisible_Menu_InGame_Outliner()) {
                                        CFG.menus.setVisible_Menu_InGame_Outliner(false);
                                    } else {
                                        Menu_InGame_FA_Top.clickStats();
                                    }
                                } else {
                                    CFG.menus.setVisibleInGame_Stats(!CFG.menus.getVisibleInGame_Stats());
                                }
                            } else if (keycode == 136) {
                                if (CFG.menus.getVisibleInGame_Wars()) {
                                    CFG.menus.setVisibleInGame_Wars(false);
                                } else {
                                    CFG.menus.rebuildInGame_Wars();
                                }
                            } else if (keycode == 137) {
                                if (CFG.menus.getVisibleInGame_MilitaryAlliances()) {
                                    CFG.menus.setVisibleInGame_MilitaryAlliances(false);
                                } else {
                                    CFG.menus.rebuildInGame_MilitaryAlliances();
                                }
                            } else if (keycode == 138) {
                                if (CFG.menus.getVisibleInGame_History()) {
                                    CFG.menus.setVisibleInGame_History(false);
                                } else {
                                    CFG.menus.rebuildInGame_History();
                                }
                            } else if (keycode == 139) {
                                if (CFG.menus.getVisibleInGame_Rank()) {
                                    CFG.menus.setVisibleInGame_Rank(false);
                                } else {
                                    CFG.menus.rebuildInGame_Rank();
                                }
                            } else if (keycode == 142) {
                                CFG.menus.setVisibleInGame_Playlist(!CFG.menus.getVisibleInGame_Playlist());
                            } else if (keycode != 8) {
                                if (keycode == 45) {
                                    if (CFG.chooseProvinceMode) {
                                        CFG.core.resetChooseProvinceData();
                                        CFG.core.checkProvinceActionMenu();
                                        return true;
                                    }
                                } else if (keycode == 51) {
                                    if (CFG.menus.getInGame_ProvinceRecruit_Visible()) {
                                        CFG.menus.setVisible_InGame_ProviRecruit(false);
                                        CFG.core.checkProvinceActionMenu();
                                        return true;
                                    }
                                } else if (keycode == 33) {
                                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                                        CFG.menus.setVisible_InGame_ProvinceMore(false, false);
                                        return true;
                                    }
                                } else if (keycode == 46) {
                                    if (CFG.menus.getInGame_ProvinceDisband_Visible()) {
                                        CFG.menus.setVisible_InGame_ProvinceDisband(false);
                                        CFG.core.checkProvinceActionMenu();
                                        return true;
                                    }
                                } else if (keycode == 48 && CFG.regroupArmyMode) {
                                    CFG.core.resetRegroupArmy_Data();
                                    CFG.core.checkProvinceActionMenu();
                                    return true;
                                }
                            }
                            if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                                if (keycode == 53) {
                                    Menu_InGameProvAction.clickOffensive();
                                    return true;
                                }
                                if (keycode == 49) {
                                    Menu_InGameProvAction.clickCancelMove();
                                }
                            }
                            if (CFG.menus.getVisible_InGame_ProvinceAction()) {
                                if (keycode == 35) {
                                    Menu_InGameProvAction.recruit(0.0f);
                                    return false;
                                } else if (keycode == 45) {
                                    if (CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.INPUT_ORDERS) return false;
                                    if (!CFG.chooseProvinceMode) {
                                        Menu_InGameProvAction.clickMove();
                                        return false;
                                    } else {
                                        CFG.core.resetChooseProvinceData();
                                        CFG.core.checkProvinceActionMenu();
                                    }
                                    return false;
                                } else if (keycode == 51) {
                                    if (!Menu_InGameProvAction.canRecruit()) return false;
                                    Menu_InGameProvAction.clickRecruit();
                                    return false;
                                } else if (keycode == 33) {
                                    if (!Menu_InGameProvAction.canRecruit()) return false;
                                    Menu_InGameProvAction.clickBuild();
                                    return false;
                                } else if (keycode == 46) {
                                    Menu_InGameProvAction.clickDisband();
                                    return false;
                                } else if (keycode == 48) {
                                    Menu_InGameProvAction.clickMoveTo();
                                    return false;
                                } else if (keycode == 53) {
                                    Menu_InGameProvAction.clickOffensive();
                                    return false;
                                } else if (keycode == 29) {
                                    Menu_InGameProvAction.recruit(0.25f);
                                    return false;
                                } else if (keycode == 47) {
                                    Menu_InGameProvAction.recruit(0.5f);
                                    return false;
                                } else if (keycode == 32) {
                                    Menu_InGameProvAction.recruit(0.75f);
                                    return false;
                                } else {
                                    if (keycode != 34) return false;
                                    Menu_InGameProvAction.recruit(1.0f);
                                }
                                return false;
                            } else if (CFG.menus.getVisible_InGame_ProvinceActionForeign()) {
                                if (keycode == 8) {
                                    Menu_InGameProvinceActionForeign.investForeign();
                                    return false;
                                } else if (keycode == 9) {
                                    Menu_InGameProvinceActionForeign.buildForeign();
                                    return false;
                                } else if (keycode == 31) {
                                    int civID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                                    int targetProvID = CFG.core.getActiveProvID();
                                    if (targetProvID >= 0 && CFG.core.getCivsAtWar(civID, CFG.core.getProv(targetProvID).getCivId())) {
                                        CFG.MISSILE_STRIKE_MODE = !CFG.MISSILE_STRIKE_MODE;
                                    } else {
                                        CFG.MISSILE_STRIKE_MODE = false;
                                    }
                                    CFG.menus.updateInGameTopAll(civID);
                                    return false;
                                } else {
                                    if (keycode != 49) return false;
                                    Menu_InGameProvinceActionForeign.useNuke();
                                }
                                return false;
                            } else {
                                if (TouchManager.lMABX.isEmpty() || keycode != 53) return false;
                                Menu_InGameProvAction.clickOffensive();
                            }
                            return false;
                        }
                        if (CFG.menus.getInNextPlayerTurn()) {
                            if (keycode != 62) return false;
                            Menu_NextPlayerTurn.clickBack();
                            return false;
                        } else if (keycode == 67) {
                            CFG.menus.onBackPressed();
                            return false;
                        } else if (CFG.menus.getInGame_Timeline() || CFG.menus.getInVictory()) {
                            if (keycode == 69 || keycode == 156) {
                                CFG.timelapseManager.updateSpeed(-1);
                                return false;
                            } else if (keycode == 81 || keycode == 157) {
                                CFG.timelapseManager.updateSpeed(1);
                                return false;
                            } else {
                                if (keycode != 66 && keycode != 160) return false;
                                CFG.timelapseManager.pauseUnpause();
                            }
                            return false;
                        } else if (CFG.menus.getInGame_CreateAVassal()) {
                            CFG.menus.setMenuID(View.eINGAME);
                            return false;
                        } else if (CFG.menus.getInCreateNewGame()) {
                            if (keycode == 131) {
                                Menu_CreateNewGame.clickOptions();
                                return false;
                            } else {
                                if (keycode != 61) return false;
                                Menu_CreateNewGame_Top.clickChooseScenario();
                            }
                            return false;
                        } else {
                            if (!CFG.menus.getInChooseScenario()) return false;
                            if (keycode == 66 || keycode == 62) {
                                Menu_ChooseScenario_Title.clickLoadScenario();
                                return false;
                            } else if (keycode == 61) {
                                CFG.menus.setMenuID(View.eCREATE_NEW_GAME);
                                return false;
                            } else if (keycode == 20 || keycode == 22) {
                                CFG.core.getGameScenars();
                                if (++Menu_ChooseScenario_Title.iPreviewScenarioID >= Game_Scenarios.SCENARIOS_SIZE - 1) {
                                    Menu_ChooseScenario_Title.iPreviewScenarioID = 0;
                                }
                                Menu_ChooseScenario_Title.loadPreview();
                                return false;
                            } else {
                                if (keycode != 19 && keycode != 21) return false;
                                if (--Menu_ChooseScenario_Title.iPreviewScenarioID < 0) {
                                    CFG.core.getGameScenars();
                                    Menu_ChooseScenario_Title.iPreviewScenarioID = Game_Scenarios.SCENARIOS_SIZE - 1;
                                }
                                Menu_ChooseScenario_Title.loadPreview();
                            }
                        }
                        return false;
                    }
                    if (keycode != 66) return false;
                    CFG.keyboardSave.action();
                    CFG.menus.getKeyboard().onMenuPressed();
                    CFG.menus.getKeyboard().setVisibleM(false);
                    Keyboard.activeColor_RGB_ID = -1;
                    return false;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                try {
                    if (CFG.menus.getKeyboard().getVisibleM() && character > '\u0000') {
                        if (character == '\u0012' || character == '\b') {
                            CFG.keyboardDelete.action();
                            CFG.menus.getKeyboard().onMenuPressed();
                        } else if (character != '\r' && character != ';' && character != '<') {
                            CFG.keyboardWrite.action("" + character);
                            CFG.menus.getKeyboard().onMenuPressed();
                        }
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                try {
                    CFG.SFXManager.playSound(SFXManager.SFX_CLICK, SFXManager.PERC_VOLUME_KEYBOARD);
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                try {
                    Touch.setMousePosXY(screenX, screenY);
                    AoCGame.this.touch.actionDown(screenX, screenY, pointer, button);
                    CFG.editorManager.touchDown(screenX, screenY, pointer, button);
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                return true;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                try {
                    if (CFG.map == null) {
                        Touch.setMousePosXY(screenX, screenY);
                        return true;
                    }
                    CFG.map.getMpSl().setScrollPos(screenX, screenY);
                    Touch.setMousePosXY(screenX, screenY);
                    if (Gdx.input.isTouched(1) && pointer == 0 && !CFG.getIsDesktop()) {
                        AoCGame.this.touch.actionMove(Gdx.input.getX(0), Gdx.input.getY(0), Gdx.input.getX(1), Gdx.input.getY(1));
                    } else {
                        AoCGame.this.touch.actionMove(screenX, screenY, pointer);
                    }
                    CFG.editorManager.touchDragged(screenX, screenY, pointer);
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                return true;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                try {
                    Touch.setMousePosXY(screenX, screenY);
                    if (CFG.getIsDesktop() && CFG.settingsGD.EDGE_SCROLLING) {
                        if (screenX < CFG.PADD) {
                            if (!AoCGame.this.MAP_MOVE_LEFT) {
                                AoCGame.this.MAP_MOVE_LEFT = true;
                                AoCGame.this.MAP_MOVE_RIGHT = false;
                                AoCGame.this.lScrollTime_MAP = System.currentTimeMillis();
                                AoCGame.this.iScroll_MAP = 15.0f;
                            }
                        } else {
                            AoCGame.this.MAP_MOVE_LEFT = false;
                        }
                        if (screenX > CFG.GAMEWIDTH - CFG.PADD) {
                            if (!AoCGame.this.MAP_MOVE_RIGHT) {
                                AoCGame.this.MAP_MOVE_RIGHT = true;
                                AoCGame.this.MAP_MOVE_LEFT = false;
                                AoCGame.this.lScrollTime_MAP = System.currentTimeMillis();
                                AoCGame.this.iScroll_MAP = 15.0f;
                            }
                        } else {
                            AoCGame.this.MAP_MOVE_RIGHT = false;
                        }
                        if (screenY < CFG.PADD) {
                            if (!AoCGame.this.MAP_MOVE_TOP) {
                                AoCGame.this.MAP_MOVE_TOP = true;
                                AoCGame.this.MAP_MOVE_BOT = false;
                                AoCGame.this.lScrollTime_MAPY = System.currentTimeMillis();
                                AoCGame.this.iScroll_MAPY = 15.0f;
                            }
                        } else {
                            AoCGame.this.MAP_MOVE_TOP = false;
                        }
                        if (screenY > CFG.GAMEHEIGHT - CFG.PADD) {
                            if (!AoCGame.this.MAP_MOVE_BOT) {
                                AoCGame.this.MAP_MOVE_BOT = true;
                                AoCGame.this.MAP_MOVE_TOP = false;
                                AoCGame.this.lScrollTime_MAPY = System.currentTimeMillis();
                                AoCGame.this.iScroll_MAPY = 15.0f;
                            }
                        } else {
                            AoCGame.this.MAP_MOVE_BOT = false;
                        }
                    }
                    AoCGame.this.touch.actionMove_Hover(screenX, screenY);
                    return true;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                    return true;
                }
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                try {
                    block14: {
                        Touch.setMousePosXY(screenX, screenY);
                        try {
                            if (CFG.map == null) {
                                CFG.menus.actionUp(screenX, screenY, pointer, button);
                                Touch.resetAllModes();
                                break block14;
                            }
                            if (CFG.getIsDesktop()) {
                                if (CFG.menus.getInGameView() && CFG.map.getMpS().getCurrSc() >= 0.01f) {
                                    if (button == 1 && CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS && !CFG.menus.getVisible_InGame_FlagAction()) {
                                        if (!(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_MOVE_OWN_PROVINCE && CFG.core.getActiveProvID() >= 0 && CFG.menus.getInGameView() && CFG.map.getMpS().getCurrSc() >= 0.25f && (CFG.gameAction.controlsArmyInProvince(CFG.core.getActiveProvID(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) || TouchManager.lMABX.size() > 0) && CFG.core.setProvinceID_PPM(screenX, screenY) || CFG.menus.actionUp(screenX, screenY, pointer, button))) {
                                            TouchManager.cMABX();
                                            int oldActiveCivID = CFG.getActiveCivInfoId();
                                            CFG.map.getTouchMgr().actionUp_setActiveProvinceID(screenX, screenY);
                                            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE) {
                                                try {
                                                    if (CFG.core.getActiveProvID() >= 0 && oldActiveCivID == CFG.getActiveCivInfoId()) {
                                                        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_DIPLOMACY_MODE, false);
                                                    }
                                                }
                                                catch (Exception ex) {
                                                    CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_DIPLOMACY_MODE, false);
                                                }
                                            } else {
                                                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_DIPLOMACY_MODE, false);
                                            }
                                        }
                                        Touch.resetAllModes();
                                        break block14;
                                    }
                                    AoCGame.this.touch.actionUp(screenX, screenY, pointer, button);
                                    break block14;
                                }
                                AoCGame.this.touch.actionUp(screenX, screenY, pointer, button);
                                break block14;
                            }
                            AoCGame.this.touch.actionUp(screenX, screenY, pointer, button);
                        }
                        catch (Exception ex) {
                            AoCGame.this.touch.actionUp(screenX, screenY, pointer, button);
                            if (!CFG.LOGs) break block14;
                            CFG.exceptionStack(ex);
                        }
                    }
                    CFG.editorManager.touchUp(screenX, screenY, pointer, button);
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                return true;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                try {
                    int amount = (int)(amountX + amountY);
                    if (CFG.menus.getIsScrollableY_MenuHovered()) {
                        AoCGame.this.updateScroll();
                        CFG.menus.scrollHoveredMenu_Y(-AoCGame.this.iScroll * amount);
                    } else if (CFG.menus.getIsScrollableX_MenuHovered()) {
                        AoCGame.this.updateScroll();
                        CFG.menus.scrollHoveredMenu_X(-AoCGame.this.iScroll * amount);
                    } else if (CFG.menus.getIsScrollable_Hovered_MenuElement()) {
                        AoCGame.this.updateScroll();
                        CFG.menus.scrollHoveredMenuElement(amount == 1 ? -AoCGame.this.iScroll : AoCGame.this.iScroll);
                    } else if (CFG.map != null) {
                        CFG.map.getMpS().scrollScale(amount);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                try {
                    CFG.SFXManager.playSound(SFXManager.SFX_CLICK, SFXManager.PERC_VOLUME_KEYBOARD);
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                return true;
            }
        });
    }

    public float getScrolled_ScaleUpdate() {
        if (CFG.map.getMpS().getCurrSc() <= 1.0f) {
            if (CFG.map.getMpS().getCurrSc() >= 0.65f) {
                return 0.05f;
            }
            if (CFG.map.getMpS().getCurrSc() >= 0.4f) {
                return 0.02f;
            }
            return 0.01f;
        }
        return 0.1f;
    }

    private final void updateScroll() {
        if (this.lScrollTime + 50L > System.currentTimeMillis()) {
            this.lScrollTime = System.currentTimeMillis();
            this.iScroll += (int)((float)this.iScroll * 1.2f);
            if (this.iScroll > 75) {
                this.iScroll = 75;
            }
        } else {
            this.lScrollTime = System.currentTimeMillis();
            this.iScroll = 15;
        }
    }

    public void resume() {
        this.updateRequestRendering(true);
        Gdx.graphics.setContinuousRendering(CFG.settingsGD.CONTINUOUS_RENDERING);
        Gdx.graphics.requestRendering();
    }

    public void pause() {
        this.updateRequestRendering(false);
    }

    static {
        drawFPS = false;
        TYPE_NUMER_TIME = 0L;
        TYPE_NUMBER = 0;
        CTRL_CLICKED = false;
    }

    public static interface RequestRendering {
        public void update();
    }
}

