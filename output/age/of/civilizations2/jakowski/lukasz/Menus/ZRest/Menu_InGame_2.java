
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Rank;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Speed;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Speed_Right;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.Button2.TextTop;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Keyboard;
import age.of.civilizations2.jakowski.lukasz.MapA.Minimap;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Color;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Graph;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Info.Menu_InGame_ProvInfo;
import age.of.civilizations2.jakowski.lukasz.Menus.Info.Menu_InGame_ProvInfoSmall;
import age.of.civilizations2.jakowski.lukasz.Menus.Menu_InitGame;
import age.of.civilizations2.jakowski.lukasz.Menus.ProvinceM.More.Menu_InGame_Province_MoreAll;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Graph.Menu_InGame_GraphManager;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextTop_Graph;
import age.of.civilizations2.jakowski.lukasz.Touch;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.time.LocalDate;
import java.util.ArrayList;

public class Menu_InGame_2
extends Menu {
    public static boolean MENU_AOC_1 = false;
    public static boolean MENU_AOC_1_BOT = false;
    public static float fTurnScale = 0.8f;
    public static boolean BUDGET_OVER = false;
    public static int iTopBalance = 0;
    public static int topStatsHeight = 0;
    public static final int TIME_REQUIRED_TO_CONTINUE = 6;
    public static long TIME_CONTINUE;
    public static LocalDate timeD;
    public static LocalDate timeT;
    public static Color btnCLR;
    public static Color btnCLR_R;
    private static final Color DISABLED_TEXT_COLOR = new Color(0.78f, 0.78f, 0.78f, 0.7f);
    private static final Color INFO_TEXT_COLOR = new Color(1.0f, 1.0f, 1.0f, 0.75f);

    public static final void updateOverBudget() {
        iTopBalance = (int)CFG.gameUpdate.getBalanceCivId(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        BUDGET_OVER = iTopBalance < 0;
        CFG.menus.getInGameMenu().getMenuElem(1).setCurr(iTopBalance);
    }

    public static void initTopBox() {
        if (CFG.XXXHDPI) {
            CFG.topBox.topBarPaddingRight = 26;
            CFG.topBox.topFlagBGPaddingButtons = -10;
            CFG.topBox.iFlagX = 10;
            CFG.topBox.iFlagY = 10;
            CFG.topBox.iCircleShift = -42;
            CFG.topBox.iCircleShiftY = -33;
        } else if (CFG.XXHDPI) {
            CFG.topBox.topBarPaddingRight = 26;
            CFG.topBox.topFlagBGPaddingButtons = -10;
            CFG.topBox.iFlagX = 10;
            CFG.topBox.iFlagY = 10;
            CFG.topBox.iCircleShift = -42;
            CFG.topBox.iCircleShiftY = -33;
        } else if (CFG.XHDPI) {
            CFG.topBox.topBarPaddingRight = 26;
            CFG.topBox.topFlagBGPaddingButtons = -10;
            CFG.topBox.iFlagX = 10;
            CFG.topBox.iFlagY = 10;
            CFG.topBox.iCircleShift = -40;
            CFG.topBox.iCircleShiftY = -32;
        } else {
            CFG.topBox.topBarPaddingRight = 26;
            CFG.topBox.topFlagBGPaddingButtons = -10;
            CFG.topBox.iFlagX = 10;
            CFG.topBox.iFlagY = 10;
            CFG.topBox.iCircleShift = -36;
            CFG.topBox.iCircleShiftY = -27;
            CFG.topBox.leftExtraViewPadding = 10;
        }
        topStatsHeight = IMGManager.getIMG(Images.topBar).getHeight() - 1;
    }

    public Menu_InGame_2() {
        int tB;
        int tG;
        int tR;
        String tempTags;
        String[] tData;
        FileHandle file;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        try {
            file = FileManager.loadFile("UI/topColorsLeft.txt");
            if (file.exists() && (tData = (tempTags = file.readString()).split(";")).length > 2) {
                tR = Integer.parseInt(tData[0]);
                tG = Integer.parseInt(tData[1]);
                tB = Integer.parseInt(tData[2]);
                btnCLR = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, 0.65f);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            file = FileManager.loadFile("UI/topColorsRight.txt");
            if (file.exists() && (tData = (tempTags = file.readString()).split(";")).length > 2) {
                tR = Integer.parseInt(tData[0]);
                tG = Integer.parseInt(tData[1]);
                tB = Integer.parseInt(tData[2]);
                btnCLR_R = new Color((float)tR / 255.0f, (float)tG / 255.0f, (float)tB / 255.0f, 0.65f);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        menuElements.add(new Minimap(0, 0){

            @Override
            public int getPosY() {
                return CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight();
            }

            @Override
            public void actionElem(int iID) {
                CFG.map.getMpC().centerToMinimapClick(Touch.getMousePosX() - Menu_InGame_2.this.getMenuElem(iID).getPosXE() - this.getPosXE(), Touch.getMousePosY() - Menu_InGame_2.this.getMenuElem(iID).getPosY() - Menu_InGame_2.this.getMenuPosY());
            }
        });
        menuElements.add(new TextTop_Graph(Images.topGold(), "2.0", "1", CFG.topBox.iFlagX * 2 + IMGManager.getIMG(Images.topFlagBG).getWidth() + CFG.topBox.topFlagBGPaddingButtons, TextTop.getButtonPadding(), Graph2.GraphType.PLAYER_BALANCE){
            Color cBalance;
            {
                this.cBalance = Color.WHITE;
            }

            @Override
            public void actionElem(int iID) {
                if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                    CFG.menus.setVisible_InGame_Budget(!CFG.menus.getVisible_InGame_Budget());
                    CFG.menus.resetHoverActive();
                }
            }

            @Override
            public void actionElemPPM() {
                super.actionElemPPM();
                CFG.menus.rebuildInGame_TakeLoan(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }

            @Override
            public void setCurr(int nCurrent) {
                try {
                    if (nCurrent >= GameValues.gvInGame.SHORT_TREASURY_BALANCE_IF_OVER) {
                        this.setText2((nCurrent > 0 ? "+" : "") + CFG.getNumber_SHORT(nCurrent));
                    } else {
                        this.setText2((nCurrent > 0 ? "+" : "") + CFG.getNumberWthSpaces("" + nCurrent));
                    }
                    this.cBalance = nCurrent > 0 ? CFG.COLOR_POSITIVE : (nCurrent == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_HOVER);
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }

            @Override
            public Color getColor(boolean isActive) {
                return CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() <= 0L ? CFG.COLOR_NEGATIVE_2 : (isActive ? CFG.COLOR_GOLD_ACTIVE : (this.getIsHovered() ? CFG.COLOR_GOLD_HOVER : CFG.COLOR_GOLD));
            }

            @Override
            public Color getColor2(boolean isActive) {
                return this.cBalance;
            }

            @Override
            public void buildElemHover() {
                int tempValue;
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Treasury") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold()), CFG.COLOR_GOLD));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_TREASURY, CFG.PLAYER_TURN_ID));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if ((int)CFG.gameUpdate.getInflation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Inflation") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getInflation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), (int)CFG.gameUpdate.getInflation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL2));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text("[" + (float)((int)(CFG.gameUpdate.getInflationPerc(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) * 10000.0f)) / 100.0f + "%]", CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                int tempBalance = tempValue = (int)CFG.gameUpdate.getIncome(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Income") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tempValue), tempValue > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                tempValue = (int)CFG.gameUpdate.getExpenses(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Expenses") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tempValue), tempValue > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Balance") + ": "));
                nData.add(new ME_Hover_2Type_Text(((tempBalance -= tempValue) > 0 ? "+" : "") + CFG.getNumberWthSpaces("" + tempBalance), tempBalance > 0 ? CFG.COLOR_POSITIVE : (tempBalance < 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL)));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_BALANCE, CFG.PLAYER_TURN_ID));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }

            @Override
            public int getSFXElem() {
                return CFG.menus.getVisible_InGame_Budget() ? SFXManager.SFX_CLICK2 : SFXManager.SFX_GOLD;
            }
        });
        menuElements.add(new Text("", 0, 0));
        menuElements.add(new Text("", 0, 0));
        menuElements.add(new Text("", 0, 0));
        menuElements.add(new Text("", 0, 0));
        menuElements.add(new Button_Rank("1", IMGManager.getIMG(Images.topFlagBG).getWidth() + CFG.topBox.iCircleShift, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.topBox.iCircleShiftY){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CivRank") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRankPos() + "/" + CFG.core.getCivsSize(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(CFG.getCivilizationRanking_IMG_STAR_CIVID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalScore") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRankScore()), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.rank, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.CIV_RANK, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.getIsDesktop()) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F9", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topFlagBG).getHeight());
                }
            }
        });
        menuElements.add(new ButtonFlagBig(CFG.topBox.iFlagX, CFG.topBox.iFlagY, true, false){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.menus.getVisible_InGame_FlagAction() ? CFG.lang.get("CloseCivilizationView") : CFG.lang.get("OpenCivilizationView"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CivRank") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRankPos() + "/" + CFG.core.getCivsSize(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(CFG.getCivilizationRanking_IMG_STAR_CIVID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.getIsDesktop()) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F1", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void actionElemPPM() {
                try {
                    CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                }
                catch (Exception exception) {
                    
                }
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topFlagBG).getHeight());
                }
            }
        });
        menuElements.add(new Text(null, -1, 0, 0, CFG.BUTTON_W, IMGManager.getIMG(Images.topBar).getHeight(), CFG.FONT_BOLD_SMALL){

            @Override
            public int getPosXE() {
                return Menu_InGame_2.this.getMenuElem(10).getVisibleE() ? Menu_InGame_2.this.getMenuElem(10).getPosXE() + Menu_InGame_2.this.getMenuElem(10).getWidthE() : Menu_InGame_2.this.getMenuElem(3).getPosXE() + Menu_InGame_2.this.getMenuElem(3).getWidthE();
            }

            @Override
            public int getWidthE() {
                return this.getTextWidthU() + CFG.PADD * 2 + CFG.topBox.topBarPaddingRight * 2;
            }

            @Override
            public int getSFXElem() {
                return CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE ? super.getSFXElem() : SFXManager.SFX_DIPLOMACY;
            }

            @Override
            public void buildElemHover() {
                if (CFG.getIsDesktop()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.menus.getVisible_InGame_CivInfo() ? CFG.lang.get("CloseTheDiplomacyView") : CFG.lang.get("OpenTheDiplomacyView"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.topDiplomacyPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F3", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }
        });
        menuElements.add(new Text(null, -1, 0, 0, CFG.BUTTON_W, IMGManager.getIMG(Images.topBar).getHeight(), CFG.FONT_BOLD_SMALL){

            @Override
            public int getPosXE() {
                return Menu_InGame_2.this.getMenuElem(8).getPosXE() + Menu_InGame_2.this.getMenuElem(8).getWidthE();
            }

            @Override
            public int getWidthE() {
                return this.getTextWidthU() + CFG.PADD * 2;
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }

            @Override
            public void actionElemPPM() {
                boolean bl = MENU_AOC_1 = !MENU_AOC_1;
                if (MENU_AOC_1) {
                    MENU_AOC_1_BOT = CFG.oR.nextInt(100) < 50;
                    CFG.menus.rebuildMenu_InGame_Infobox_AllAction2("The original Age of Civilizations 1 menu v" + (MENU_AOC_1_BOT ? "1" : "2"), "Back to September 2014", MENU_AOC_1_BOT ? Images.infoDiplomacy : Images.infoStability);
                } else {
                    MENU_AOC_1_BOT = false;
                }
            }

            @Override
            public void buildElemHover() {
                if (CFG.getIsDesktop()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.menus.getVisible_InGame_MapModes() ? CFG.lang.get("CloseMapModes") : CFG.lang.get("OpenMapModes"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F4", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }
        });
        menuElements.add(new Text("", 0, CFG.topBox.iFlagX * 2 + IMGManager.getIMG(Images.topFlagFrame).getWidth() + CFG.PADD, 0, IMGManager.getIMG(Images.topBar).getHeight()){

            @Override
            public boolean getVisibleE() {
                return false;
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Player") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.PLAYER_TURN_ID + 1), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setVisibleE(false);
        menuElements.add(new Text("", 0, 0));
        menuElements.add(new Button_Speed_Right("+", -1, 0, 0, IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD, IMGManager.getIMG(Images.topBar).getHeight() - 1, true){

            @Override
            public int getPosXE() {
                return CFG.GAMEWIDTH - this.getWidthE();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("IncreaseSpeed"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.getIsDesktop()) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }

            @Override
            public boolean getVisibleE() {
                return RTS.isEnabled();
            }
        });
        menuElements.add(new Text("", 0, 0));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.setMenuElem(2, new TextTop(Images.topMovementPoints, "2.0", "1", CFG.topBox.iFlagX * 2 + IMGManager.getIMG(Images.topFlagFrame).getWidth() + CFG.PADD, TextTop.getButtonPadding()){

            @Override
            public void actionElem(int iID) {
                Menu_InGame_Province_MoreAll.moreTopAction = true;
                CFG.core.resetChooseProvinceData();
                CFG.menus.setVisible_InGame_MoreAll(!CFG.menus.getInGame_ProvincemMore_Visible(), false);
                if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                    if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                        CFG.mapModesManager.setActiveMapModeID(-1);
                    }
                    if (CFG.menus.getVisible_InGame_CivInfo()) {
                        CFG.menus.setVisible_InGame_CivInfo(false);
                    }
                }
                if (CFG.menus.getInGame_Plunder().getVisibleM()) {
                    CFG.menus.getInGame_Plunder().setVisibleM(false);
                }
            }

            @Override
            public int getPosXE() {
                return CFG.menus.getInGameMenu().getMenuElem(1).getPosXE() + CFG.menus.getInGameMenu().getMenuElem(1).getWidthE() + CFG.PADD;
            }

            @Override
            public Color getColor(boolean isActive) {
                return CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getIdeology()).COST_OF_MOVE ? CFG.COLOR_NEGATIVE_2 : (isActive ? CFG.COLOR_MOVEMENT_ACTIVE : (this.getIsHovered() ? CFG.COLOR_MOVEMENT_HOVER : CFG.COLOR_MOVEMENT));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MovementPoints") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text_Big("" + (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() / 10.0f, CFG.COLOR_MOVEMENT));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topMovementPoints, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Text_Big(" / ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text_Big("" + (float)CFG.gameAction.getCivMaxMovementPoints(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / 10.0f, CFG.COLOR_MOVEMENT_HOVER));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BaseValue") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + (float)CFG.gameAction.getMovementPoints_BaseValue(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / 10.0f, CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CivilizationSize") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.gameAction.getMovementPoints_FromCivSize(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == 0 ? "" : "+") + (float)CFG.gameAction.getMovementPoints_FromCivSize(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / 10.0f, CFG.gameAction.getMovementPoints_FromCivSize(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Technology") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.gameAction.getMovementPoints_FromTechnology(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == 0 ? "" : "+") + (float)CFG.gameAction.getMovementPoints_FromTechnology(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / 10.0f, CFG.gameAction.getMovementPoints_FromTechnology(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyPoints") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.gameAction.getMovementPoints_TechnologyPoints(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == 0 ? "" : "+") + (float)CFG.gameAction.getMovementPoints_TechnologyPoints(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / 10.0f, CFG.gameAction.getMovementPoints_TechnologyPoints(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Limit") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (float)CFG.gameAction.getCivMaxMovementPoints(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / 10.0f, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_MOVE_ARMY;
            }
        });
        this.setMenuElem(13, new TextTop(Images.diploArmy, "0", "0", CFG.topBox.iFlagX * 2 + IMGManager.getIMG(Images.topFlagFrame).getWidth() + CFG.PADD, TextTop.getButtonPadding()){

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_ARMY_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_HAPPINESS_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Armies"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            }

            @Override
            public void drawExtra(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                if (CFG.MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI) {
                    oSB.setColor(CFG.COLOR_TEXT_CHECKBOX_TRUE.r, CFG.COLOR_TEXT_CHECKBOX_TRUE.g, CFG.COLOR_TEXT_CHECKBOX_TRUE.b, 0.05f);
                    IMGManager.getIMG(Images.gradientFull).draw(oSB, iTranslateX, iTranslateY, this.getWidthE(), this.getHeightE());
                    oSB.setColor(CFG.COLOR_TEXT_CHECKBOX_TRUE.r, CFG.COLOR_TEXT_CHECKBOX_TRUE.g, CFG.COLOR_TEXT_CHECKBOX_TRUE.b, 0.145f);
                    IMGManager.getIMG(Images.gradientXY).draw(oSB, iTranslateX, iTranslateY + this.getHeightE() / 2, this.getWidthE(), this.getHeightE() / 2);
                    oSB.setColor(Color.WHITE);
                }
            }

            @Override
            public int getPosXE() {
                return CFG.menus.getInGameMenu().getMenuElem(2).getPosXE() + CFG.menus.getInGameMenu().getMenuElem(2).getWidthE() + CFG.PADD;
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_DIPLOMACY_POINTS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_DIPLOMACY_POINTS_HOVER : CFG.COLOR_TEXT_GRAY_NS);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Army") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits()), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_ARMY_SIZE, CFG.PLAYER_TURN_ID));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BudgetSpendings") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.gameUpdate.getMilitarySpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget) + "%", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getMilitaryUpkeep_Total(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                float upkeepPerUnit = 0.0f;
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits() > 0) {
                    upkeepPerUnit = CFG.gameUpdate.getMilitaryUpkeep_Total(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumberOfUnits();
                }
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("UpkeepPerUnit") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(upkeepPerUnit, 100), CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Graph(Graph2.GraphType.PLAYER_MILITARY_SPENDING, CFG.PLAYER_TURN_ID));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_MOVE_ARMY;
            }
        });
        this.setMenuElem(3, new TextTop(Images.topDiplomacyPoints, "2.0", "1", CFG.topBox.iFlagX * 2 + IMGManager.getIMG(Images.topFlagFrame).getWidth() + CFG.PADD, TextTop.getButtonPadding()){

            @Override
            public void actionElem(int iID) {
                Menu_InGame_2.actionDiplomacy();
            }

            @Override
            public int getPosXE() {
                try {
                    return CFG.menus.getInGameMenu().getMenuElem(13).getPosXE() + CFG.menus.getInGameMenu().getMenuElem(13).getWidthE() + CFG.PADD;
                }
                catch (Exception ex) {
                    return 0;
                }
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_DIPLOMACY_POINTS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_DIPLOMACY_POINTS_HOVER : CFG.COLOR_DIPLOMACY_POINTS);
            }

            @Override
            public void buildElemHover() {
                int i;
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DiplomacyPoints") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text_Big("" + (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getDiploPoints() / 10.0f, CFG.COLOR_DIPLOMACY_POINTS));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topDiplomacyPoints, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(" / " + (float)GameAction.getMaxDiplomacyPoints(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / 10.0f));
                nData.add(new ME_Hover_2Type_Image_Big(Images.topDiplomacyPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                int perTurn = CFG.gameAction.getUpdateCivsDiploPoints_INFO_ONLY(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TurnIncrease") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + (float)Math.max(perTurn, 0) / 10.0f, perTurn > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL2));
                nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BaseValue") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + (float)CFG.gameAction.getDiplomacyPoints_BaseValue(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / 10.0f, CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Rank") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.gameAction.getDiplomacyPoints_FromRank(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == 0 ? "" : "+") + (float)CFG.gameAction.getDiplomacyPoints_FromRank(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / 10.0f, CFG.gameAction.getDiplomacyPoints_FromRank(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Technology") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.gameAction.getDiplomacyPoints_FromTechnology(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == 0 ? "" : "+") + (float)CFG.gameAction.getDiplomacyPoints_FromTechnology(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / 10.0f, CFG.gameAction.getDiplomacyPoints_FromTechnology(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Enemies") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getHatedCivsSize(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getHatedCivsSize() > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Text(" / "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.oAI.MIN_NUM_OF_RIVALS, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.diploRivals, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.gameAction.getDiplomacyPoints_FromEnemies(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) <= 0 ? "" : "+") + (float)CFG.gameAction.getDiplomacyPoints_FromEnemies(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / 10.0f, CFG.gameAction.getDiplomacyPoints_FromEnemies(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == 0 ? CFG.COLOR_NEUTRAL : (CFG.gameAction.getDiplomacyPoints_FromEnemies(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) < 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE)));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (GameManager.getCostOfCurrentDiplomaticActions(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) > 0) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() > 0 && CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilizationsSize() > 1) {
                    for (int j = 0; j < CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilizationsSize(); ++j) {
                        if (CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilization(j) == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
                        nData.add(new ME_Hover_2Type_Color(new Color((float)CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilization(j)).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilization(j)).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilization(j)).getB() / 255.0f, 1.0f)));
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilization(j)));
                        break;
                    }
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Alliance")));
                    nData.add(new ME_Hover_2Type_Image(Images.diploAlliance, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_ALLIANCE / 10.0f, CFG.COLOR_NEGATIVE_2));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                int friendlyCost = 0;
                int friendlyNum = 0;
                for (i = 0; i < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFriendlyCivsSize(); ++i) {
                    if (CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getFriendlyCiv((int)i).iCivID).getNumOfProvs() <= 0) continue;
                    friendlyCost += GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_FRIENDLY_CIV;
                    ++friendlyNum;
                }
                if (friendlyNum > 0 && friendlyCost > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("FriendlyCivilizations") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + friendlyNum, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.diploHeart, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text("-" + (float)friendlyCost / 10.0f, CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.iVassalsSize > 0) {
                    nData.add(new ME_Hover_2Type_Color(new Color((float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getB() / 255.0f, 1.0f)));
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Vassals")));
                    nData.add(new ME_Hover_2Type_Image(Images.diploVassal, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text("-" + (float)(GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_VASSAL * CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.iVassalsSize) / 10.0f, CFG.COLOR_NEGATIVE_2));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                    if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || i == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
                    if (CFG.core.getCivNonAggressionPact(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), i) > 0) {
                        nData.add(new ME_Hover_2Type_Color(new Color((float)CFG.core.getCiv(i).getR() / 255.0f, (float)CFG.core.getCiv(i).getG() / 255.0f, (float)CFG.core.getCiv(i).getB() / 255.0f, 1.0f)));
                        nData.add(new ME_Hover_2Type_Flag(i));
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("NonAggressionPact")));
                        nData.add(new ME_Hover_2Type_Image(Images.diploNonAggression, CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_NONAGGRESSION / 10.0f, CFG.COLOR_NEGATIVE_2));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    if (CFG.core.getGuarantee(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), i) > 0) {
                        nData.add(new ME_Hover_2Type_Color(new Color((float)CFG.core.getCiv(i).getR() / 255.0f, (float)CFG.core.getCiv(i).getG() / 255.0f, (float)CFG.core.getCiv(i).getB() / 255.0f, 1.0f)));
                        nData.add(new ME_Hover_2Type_Flag(i));
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("GuaranteeIndependence")));
                        nData.add(new ME_Hover_2Type_Image(Images.diploGuaranteeGives, CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_GUARANTEE / 10.0f, CFG.COLOR_NEGATIVE_2));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    if (CFG.core.getDefensivePact(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), i) > 0) {
                        nData.add(new ME_Hover_2Type_Color(new Color((float)CFG.core.getCiv(i).getR() / 255.0f, (float)CFG.core.getCiv(i).getG() / 255.0f, (float)CFG.core.getCiv(i).getB() / 255.0f, 1.0f)));
                        nData.add(new ME_Hover_2Type_Flag(i));
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefensivePact")));
                        nData.add(new ME_Hover_2Type_Image(Images.diploDefensivePact, CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_DEFENSIVE_PACT / 10.0f, CFG.COLOR_NEGATIVE_2));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    if (CFG.core.getMilitaryAccess(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), i) <= 0) continue;
                    nData.add(new ME_Hover_2Type_Color(new Color((float)CFG.core.getCiv(i).getR() / 255.0f, (float)CFG.core.getCiv(i).getG() / 255.0f, (float)CFG.core.getCiv(i).getB() / 255.0f, 1.0f)));
                    nData.add(new ME_Hover_2Type_Flag(i));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryAccess")));
                    nData.add(new ME_Hover_2Type_Image(Images.diploAccessHas, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_MILITARY_ACCESS / 10.0f, CFG.COLOR_NEGATIVE_2));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getImproveRelationsSize() > 0) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("WeAreImprovingOurRelationsWith") + ": ", CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (i = 0; i < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getImproveRelationsSize(); ++i) {
                        nData.add(new ME_Hover_2Type_Color(new Color((float)CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getImproveRelation((int)i).iWithCivID).getR() / 255.0f, CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getImproveRelation((int)i).iWithCivID).getG() / 255, (float)CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getImproveRelation((int)i).iWithCivID).getB() / 255.0f, 1.0f)));
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getImproveRelation((int)i).iWithCivID));
                        nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getImproveRelation((int)i).iWithCivID).getCivName()));
                        nData.add(new ME_Hover_2Type_Text(" +" + (float)((int)(GameManager.getImproveRelation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getImproveRelation((int)i).iWithCivID) * 100.0f)) / 100.0f, CFG.COLOR_POSITIVE));
                        nData.add(new ME_Hover_2Type_Image(Images.diploRelationsInc, CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text("-" + (float)GameValues.gvRelationImprove.COST_OFFER_IMPROVE_RELATIONS_DIPLOMACY_POINTS / 10.0f, CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PerTurn")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                }
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Limit") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (float)GameAction.getMaxDiplomacyPoints(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / 10.0f, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public int getSFXElem() {
                return CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE ? super.getSFXElem() : SFXManager.SFX_DIPLOMACY;
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }
        });
        this.setMenuElem(4, new Text(null, 0, 0, CFG.PADD, IMGManager.getIMG(Images.topBar).getHeight() / 2, (float)CFG.FONT_BOLD){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColor(isActive));
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_CIV_NAME_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_NAME_HOVERED : CFG.COLOR_TEXT_CIV_NAME) : DISABLED_TEXT_COLOR);
            }

            @Override
            public int getPosXE() {
                return CFG.GAMEWIDTH + (RTS.isEnabled() ? -IMGManager.getIMG(Images.topBar).getHeight() - CFG.PADD - Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 2, this.getTextWidthU() + CFG.PADD * 6) : -this.getTextWidthU() - CFG.PADD);
            }

            @Override
            public int getWidthE() {
                return RTS.isEnabled() ? Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 2, this.getTextWidthU() + CFG.PADD * 6) : this.getTextWidthU();
            }

            @Override
            public int getHeightE() {
                return IMGManager.getIMG(Images.topBar).getHeight() / 2;
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_2.getHoverDate();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        this.setMenuElem(5, new Text(null, 0, 0, IMGManager.getIMG(Images.topBar).getHeight() / 2, IMGManager.getIMG(Images.topBar).getHeight() / 2, (float)CFG.FONT_REGULAR_SMALL){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + (RTS.isEnabled() ? (this.getWidthE() - this.getTextWidthU()) / 2 : this.getWidthE() - this.getTextWidthU() - CFG.PADD) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColor(isActive));
            }

            @Override
            public Color getColor(boolean isActive) {
                if (!RTS.PAUSE) {
                    return CFG.COLOR_TEXT_NUM_OF_PROVINCES;
                }
                return isActive ? CFG.COLOR_TEXT_RANK_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_RANK_HOVER : CFG.COLOR_TEXT_RANK) : DISABLED_TEXT_COLOR);
            }

            @Override
            public int getPosXE() {
                return Menu_InGame_2.this.getMenuElem(4).getPosXE();
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_2.this.getMenuElem(4).getWidthE();
            }

            @Override
            public int getHeightE() {
                return IMGManager.getIMG(Images.topBar).getHeight() / 2;
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_2.getHoverDate();
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }
        });
        this.setMenuElem(11, new Button_Speed("-", -1, 0, 0, IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD, IMGManager.getIMG(Images.topBar).getHeight() - 1, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_2.this.getMenuElem(4).getPosXE() - this.getWidthE();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DecreaseSpeed"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.getIsDesktop()) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("-", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public boolean getVisibleE() {
                return RTS.isEnabled();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Touch.getMousePosX(), IMGManager.getIMG(Images.topBar).getHeight());
                }
            }
        });
        this.updateLang();
        this.updateMenuElements_IsInView();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(4).setTextE(GameCalendar.getCurrDate());
        this.getMenuElem(5).setTextE(CFG.lang.get("Turn") + ": " + GameCalendar.TURNID);
        this.getMenuElem(8).setTextE(CFG.lang.get("Diplomacy"));
        this.getMenuElem(9).setTextE(CFG.lang.get("MapModes"));
    }

    public static final void draw_Time(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        if (!MENU_AOC_1) {
            oSB.setColor(Menu_InGame_2.btnCLR_R.r, Menu_InGame_2.btnCLR_R.g, Menu_InGame_2.btnCLR_R.b, 1.0f);
            IMGManager.getIMG(Images.patternReversed).draw2(oSB, nPosX, nPosY, nWidth, nHeight);
            IMGManager.getIMG(Images.patternReversed).draw2(oSB, nPosX, nPosY, nWidth, nHeight);
            oSB.setColor(1.0f, 1.0f, 1.0f, 1.0f);
            IMGManager.getIMG(Images.patternReversed).draw2(oSB, nPosX, nPosY, (int)((float)nWidth * RTS.getTimePerc()), nHeight, 0, RTS.SOURCE);
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.75f);
            IMGManager.getIMG(Images.patternReversed).draw2(oSB, nPosX, nPosY, (int)((float)nWidth * RTS.getTimePerc()), nHeight, 0, RTS.SOURCE);
            if (!RTS.PAUSE) {
                --RTS.SOURCE;
            }
            oSB.setColor(Menu_InGame_2.btnCLR_R.r, Menu_InGame_2.btnCLR_R.g, Menu_InGame_2.btnCLR_R.b, 0.4f);
            IMGManager.getIMG(Images.gradient).draw(oSB, nPosX, nPosY, nWidth, nHeight, false, true);
            oSB.setColor(0.0f, 0.0f, 0.0f, 0.45f);
            IMGManager.getIMG(Images.gradient).draw(oSB, nPosX, nPosY, nWidth, CFG.PADD);
        } else {
            oSB.setColor(0.15686275f, 0.15686275f, 0.15686275f, 0.25f);
            IMGManager.getIMG(Images.patternReversed).draw2(oSB, nPosX, nPosY, (int)((float)nWidth * RTS.getTimePerc()), nHeight, 0, RTS.SOURCE);
            oSB.setColor(0.15686275f, 0.15686275f, 0.15686275f, 0.15f);
            IMGManager.getIMG(Images.patternReversed).draw2(oSB, nPosX, nPosY, (int)((float)nWidth * RTS.getTimePerc()), nHeight, 0, RTS.SOURCE);
            if (!RTS.PAUSE) {
                --RTS.SOURCE;
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void draw_Speed(SpriteBatch oSB, int nPosX, int nPosY, int nWidth, int nHeight) {
        if (!MENU_AOC_1) {
            oSB.setColor(Menu_InGame_2.btnCLR_R.r, Menu_InGame_2.btnCLR_R.g, Menu_InGame_2.btnCLR_R.b, 0.75f);
            IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, nHeight);
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.075f);
            IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY + nHeight - nHeight / 2 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 2, false, true);
            IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 2, false, false);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.PADD, nHeight);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - CFG.PADD, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.PADD, nHeight, true, false);
        } else {
            oSB.setColor(0.15686275f, 0.15686275f, 0.15686275f, 0.35f);
            IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, nHeight);
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.025f);
            IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY + nHeight - nHeight / 2 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 2, false, true);
            IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, nHeight / 2, false, false);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.PADD, nHeight);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - CFG.PADD, nPosY - IMGManager.getIMG(Images.sliderGradient).getHeight(), CFG.PADD, nHeight, true, false);
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        int nElemWidthID;
        if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.LOADING_NEXT_TURN && TIME_CONTINUE > 0L && TIME_CONTINUE < System.currentTimeMillis() - 6L) {
            TIME_CONTINUE = -1L;
            Menu_InGame_ProvInfo.clickEndTurn();
        }
        int n = nElemWidthID = this.getMenuElem(10).getVisibleE() ? 10 : 3;
        if (!MENU_AOC_1) {
            IMGManager.getIMG(Images.topBar2).draw2(oSB, iTranslateX + this.getMenuElem(8).getPosXE(), iTranslateY, this.getMenuElem(8).getWidthE() + this.getMenuElem(9).getWidthE() + CFG.topBox.topBarPaddingRight, IMGManager.getIMG(Images.topBar2).getHeight(), true, false);
            IMGManager.getIMG(Images.topBar2).draw2(oSB, iTranslateX + this.getMenuElem(nElemWidthID).getPosXE() + this.getMenuElem(nElemWidthID).getWidthE(), iTranslateY, this.getMenuElem(8).getWidthE(), IMGManager.getIMG(Images.topBar2).getHeight(), true, false);
            IMGManager.getIMG(Images.topBar).draw2(oSB, iTranslateX, iTranslateY, this.getMenuElem(nElemWidthID).getPosXE() + this.getMenuElem(nElemWidthID).getWidthE() + CFG.topBox.topBarPaddingRight, IMGManager.getIMG(Images.topBar).getHeight(), true, false);
            IMGManager.getIMG(Images.topFlagBG).draw(oSB, iTranslateX, iTranslateY);
            IMGManager.getIMG(Images.topBar).draw2(oSB, (RTS.isEnabled() ? this.getMenuElem(11).getPosXE() : this.getMenuElem(4).getPosXE()) - CFG.topBox.topBarPaddingRight + iTranslateX, iTranslateY, CFG.topBox.topBarPaddingRight + (CFG.GAMEWIDTH - (RTS.isEnabled() ? this.getMenuElem(11).getPosXE() : this.getMenuElem(4).getPosXE())), IMGManager.getIMG(Images.topBar).getHeight());
        } else {
            oSB.setColor(0.03137255f, 0.03137255f, 0.03137255f, 1.0f);
            IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, CFG.GAMEWIDTH, IMGManager.getIMG(Images.topBar).getHeight());
            oSB.setColor(0.16078432f, 0.15686275f, 0.16862746f, 1.0f);
            IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + IMGManager.getIMG(Images.topBar).getHeight() - 2 + iTranslateY, CFG.GAMEWIDTH, 2);
        }
        if (RTS.isEnabled()) {
            Menu_InGame_2.draw_Time(oSB, this.getMenuElem(4).getPosXE() + iTranslateX, 0, this.getMenuElem(4).getWidthE(), IMGManager.getIMG(Images.topBar).getHeight() - 1 - CFG.PADD);
            int tSpeedWidth = (this.getMenuElem(4).getWidthE() - CFG.PADD * 5) / 6;
            int tX = (this.getMenuElem(4).getWidthE() - tSpeedWidth * 6 - CFG.PADD * 5) / 2;
            for (int i = 0; i < RTS.SPEED; ++i) {
                Menu_InGame_2.draw_Speed(oSB, tX + this.getMenuElem(4).getPosXE() + (tSpeedWidth + CFG.PADD) * i + iTranslateX, IMGManager.getIMG(Images.topBar).getHeight() - 3 - CFG.PADD, tSpeedWidth, CFG.PADD);
            }
        }
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (Menu_InGame_ProvInfo.getUseSmallProvinceInfo()) {
            oSB.setColor(CFG.COLOR_BG_GAME_MENU_SHADOW);
            if (Menu_InGame_ProvInfo.iMaxWidth >= 0) {
                IMGManager.getIMG(Images.pix255).draw(oSB, iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - 1 + iTranslateY, CFG.map.getMpB().getMinimapWidth() + Menu_InGame_ProvInfoSmall.iMaxWidth - IMGManager.getIMG(Images.bgGameMenuRSmall).getWidth() + 1);
                IMGManager.getIMG(Images.line32Off1).draw(oSB, iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - 1 + iTranslateY, CFG.map.getMpB().getMinimapWidth() + Menu_InGame_ProvInfoSmall.iMaxWidth - IMGManager.getIMG(Images.bgGameMenuRSmall).getWidth() + 1, 1);
            } else {
                IMGManager.getIMG(Images.pix255).draw(oSB, iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - 1 + iTranslateY, CFG.GAMEWIDTH);
                IMGManager.getIMG(Images.line32Off1).draw(oSB, iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - 1 + iTranslateY, CFG.GAMEWIDTH, 1);
            }
        }
        oSB.setColor(Color.WHITE);
        if (!Menu_InitGame.PDR && CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.armyExpertiseLevel > 2 && timeD.isAfter(timeT)) {
            Renderer.drawText(oSB, CFG.FONT_BOLD, Menu_InGame_2.getInfo(), CFG.BUTTON_W + iTranslateX, CFG.GAMEHEIGHT / 2 + iTranslateY, INFO_TEXT_COLOR);
        }
    }

    public static final void clickFlagAction() {
        if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
            if (!CFG.menus.getVisible_InGame_FlagAction()) {
                CFG.gameUpdate.updateSpendingOfCivID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget);
                if (RTS.isEnabled() && !RTS.PAUSE) {
                    RTS.updateTimePast_AfterAction(0.4f);
                }
                if (CFG.menus.getVisible_InGame_CivInfo()) {
                    CFG.menus.setVisible_InGame_CivInfo(!CFG.menus.getVisible_InGame_CivInfo());
                }
                int reloadGraph = Menu_InGame_GraphManager.iActiveGraphID;
                Menu_InGame_GraphManager.iActiveGraphID = -1;
                Menu_InGame_GraphManager.setActiveGraphID(reloadGraph);
            }
            CFG.menus.setVisible_InGame_FlagAction(!CFG.menus.getVisible_InGame_FlagAction());
            if (CFG.menus.getVisible_InGame_FlagAction()) {
                CFG.gameAction.hideAllViews();
                if (CFG.chooseProvinceMode) {
                    CFG.core.resetChooseProvinceData();
                }
                if (CFG.regroupArmyMode) {
                    CFG.core.resetRegroupArmy_Data();
                }
            } else {
                if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                    CFG.mapModesManager.getActiveView().enableViewAction();
                }
                CFG.core.checkProvinceActionMenu();
            }
        }
    }

    @Override
    public final void actionEL(int iID) {
        super.actionEL(iID);
        switch (iID) {
            case 4: 
            case 5: {
                if (RTS.isEnabled()) {
                    if (!RTS.PAUSE) {
                        RTS.updateTimePast_AfterAction(0.75f);
                    }
                    RTS.pauseUnpause();
                    break;
                }
                if (CFG.menus.getVisibleInGame_History()) {
                    CFG.menus.setVisibleInGame_History(false);
                } else {
                    CFG.menus.rebuildInGame_History();
                }
                ArrayList<String> tempMess = new ArrayList<String>();
                ArrayList<Color> tempColor = new ArrayList<Color>();
                tempMess.add(CFG.gameAges.getAge(GameCalendar.CURRENT_AGEID).getName());
                tempColor.add(CFG.COLOR_TEXT_RANK);
                tempMess.add(GameCalendar.getCurrDate());
                tempColor.add(CFG.COLOR_TEXT_CIV_NAME);
                CFG.toastM.addM(tempMess, tempColor);
                break;
            }
            case 6: {
                if (CFG.menus.getVisibleInGame_Rank()) {
                    CFG.menus.setVisibleInGame_Rank(false);
                    break;
                }
                CFG.menus.rebuildInGame_Rank();
                break;
            }
            case 7: {
                Menu_InGame_2.clickFlagAction();
                if (CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.INPUT_ORDERS) break;
                this.getMenuElem(iID).buildElemHover();
                break;
            }
            case 8: {
                Menu_InGame_2.actionDiplomacy();
                if (CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.INPUT_ORDERS) break;
                this.getMenuElem(iID).buildElemHover();
                break;
            }
            case 9: {
                CFG.menus.setVisible_InGame_MapModes(!CFG.menus.getInGame_MapModes().getVisibleM());
                try {
                    if (Keyboard.mapModeSearch && CFG.menus.getKeyboard().getVisibleM()) {
                        CFG.menus.getKeyboard().setVisibleM(false);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                if (CFG.menus.getInGame_MapModes().getPosX() < 0) {
                    if (CFG.isAndroid()) {
                        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), "+100% ");
                        int tempMaxTextW = (int)CFG.glyphLay.width;
                        int tMenuWidth = IMGManager.getIMG(Images.diploWar).getWidth() / 2 + CFG.PADD + CFG.CIV_FLAG_WIDTH + CFG.PADD + tempMaxTextW + CFG.PADD;
                        CFG.menus.getInGame_MapModes().setPosX_Force(CFG.GAMEWIDTH - CFG.menus.getInGame_MapModes().getWidthM() - CFG.PADD - tMenuWidth);
                        CFG.menus.getInGame_MapModes().setPosY(CFG.menus.getInGame_MapModes().getTitleM().getHeightT() + this.getMenuElem(iID).getPosY() + this.getMenuElem(iID).getHeightE() + CFG.PADD);
                        if (CFG.menus.getInGame_MapModes().getPosX() + CFG.menus.getInGame_MapModes().getWidthM() > CFG.GAMEWIDTH - CFG.PADD) {
                            CFG.menus.getInGame_MapModes().setPosX_Force(CFG.GAMEWIDTH - CFG.PADD - CFG.menus.getInGame_MapModes().getWidthM());
                        }
                    } else {
                        CFG.menus.getInGame_MapModes().setPosX_Force(CFG.CIV_INFO_MENU_WIDTH + CFG.PADD * 2 + CFG.BUTTON_W * 3 / 4);
                        CFG.menus.getInGame_MapModes().setPosY(CFG.menus.getInGame_MapModes().getTitleM().getHeightT() + IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3);
                        if (CFG.menus.getInGame_MapModes().getPosX() + CFG.menus.getInGame_MapModes().getWidthM() > CFG.GAMEWIDTH - CFG.PADD) {
                            CFG.menus.getInGame_MapModes().setPosX_Force(CFG.GAMEWIDTH - CFG.PADD - CFG.menus.getInGame_MapModes().getWidthM());
                        }
                    }
                }
                if (CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.INPUT_ORDERS) break;
                this.getMenuElem(iID).buildElemHover();
                break;
            }
            case 10: {
                CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                break;
            }
            case 11: {
                RTS.updateSpeed(-1);
                break;
            }
            case 12: {
                RTS.updateSpeed(1);
            }
        }
    }

    public static void actionDiplomacy() {
        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_DIPLOMACY_MODE);
        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DIPLOMACY_MODE) {
            if (CFG.menus.getVisible_InGame_FlagAction()) {
                CFG.menus.setVisible_InGame_FlagAction(false);
            }
            if (CFG.menus.getInGame_Budget().getVisibleM()) {
                CFG.menus.getInGame_Budget().setVisibleM(false);
            }
            CFG.mapModesManager.getActiveView().updateActiveCivInfo_ExtraAction(CFG.getActiveCivInfoId());
        } else {
            CFG.menus.setVisible_InGame_CivInfo(false);
        }
    }

    public static String getInfo() {
        return "This appears to be an unofficial copy of the game.";
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setVisible_InGame_Options(true);
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame();
    }

    public static ME_Hover_v2 getHoverDate() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        if (RTS.isEnabled()) {
            if (RTS.PAUSE) {
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ClickToUnpauseTheGame"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            } else {
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ClickToPauseTheGame"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            nData.add(new ME_Hover_2Type_Text(GameCalendar.getCurrDate()));
            nData.add(new ME_Hover_2Type_Text(" - " + CFG.gameAges.getAge(GameCalendar.CURRENT_AGEID).getName(), CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            if (GameCalendar.TURNID != 1) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PlayingTime") + ": "));
                nData.add(new ME_Hover_2Type_Text(GameCalendar.getNumOfDatesByTurnID(1), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.getIsDesktop()) {
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                nData.add(new ME_Hover_2Type_Text("ENTER", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
        } else {
            nData.add(new ME_Hover_2Type_Text(GameCalendar.getCurrDate()));
            nData.add(new ME_Hover_2Type_Text(" - " + CFG.gameAges.getAge(GameCalendar.CURRENT_AGEID).getName(), CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(GameCalendar.getCurrDate()));
            nData.add(new ME_Hover_2Type_Text(" - " + CFG.lang.get("Turn") + ": "));
            nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + GameCalendar.TURNID), CFG.COLOR_HOVER_TITLE));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            if (GameCalendar.TURNID != 1) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PlayingTime") + ": "));
                nData.add(new ME_Hover_2Type_Text(GameCalendar.getNumOfDatesByTurnID(1), CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.getIsDesktop()) {
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                nData.add(new ME_Hover_2Type_Text("F8", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
        }
        return new ME_Hover_v2(nElements);
    }

    static {
        timeD = LocalDate.now();
        timeT = LocalDate.of(2026, 6, 6);
        btnCLR = Colors.COLOR_GRADIENT_OVER_BLUE;
        btnCLR_R = CFG.COLOR_GRADIENT_BLUE;
    }
}

