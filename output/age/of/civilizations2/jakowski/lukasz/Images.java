/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import java.util.ArrayList;
import java.util.List;

public class Images {
    public static Image pix;
    public static int pix2;
    public static int pix255;
    public static int buttonGame;
    public static int buttonGameH;
    public static int terrainOver;
    public static int gradientVertical;
    public static int gradientHorizontal;
    public static int gradientHorizontal2;
    public static int gradientHorizontal3;
    public static int gradientFull;
    public static int gradientFull2;
    public static int gradientXY;
    public static int gradientXYVertical;
    public static int btnMenuH;
    public static int btnHMenuH;
    public static int btnMenu1H;
    public static int btnhMenu1H;
    public static int btnClose;
    public static int btnhClose;
    public static int btnClear;
    public static int btnhClear;
    public static int btnV;
    public static int btnVActive;
    public static int btnX;
    public static int btnXActive;
    public static int arrow;
    public static int arrowActive;
    public static int btnRemove;
    public static int btnUp;
    public static int btnLocalization;
    public static int btnShow;
    public static int btnAdd;
    public static int btnClearCheckboxTrue;
    public static int btnClearCheckboxFalse;
    public static int sliderArmy;
    public static int bgGameMenu;
    public static int bgGameMenuR;
    public static int bgGameMenuRSmall;
    public static int gameMenuOverlay;
    public static int bgGameAction;
    public static int noLeader;
    public static int bgStats;
    public static int city;
    public static int city2;
    public static int city3;
    public static int city4;
    public static int city5;
    public static int mount;
    public static int icon_move_ally;
    public static int icon_move_attack;
    public static int icon_move_sea;
    public static int pattern;
    public static int patternReversed;
    public static int patternExtraAlpha;
    public static int patternSquareTiny;
    public static int botLeft;
    public static int botLeftRed;
    public static int topLeftExtra;
    public static int topFlagFrame;
    public static int topFlagFrameH;
    public static int topCivColor;
    public static int topCivColorShader;
    public static int flagCapitalOver;
    public static int flagCapitalMask;
    public static int topBar;
    public static int topBar2;
    public static int topFlagBG;
    public static int messages;
    public static int messages_g;
    public static int messages_r;
    public static int messages_w;
    public static int top_circle;
    public static int top_view_right;
    public static int top_view_right_h;
    public static int top_view_right_last;
    public static int sliderGradient;
    public static int topGold;
    public static int topGold2;
    public static int topMovementPoints;
    public static int topDiplomacyPoints;
    public static int topGoldOrg;
    public static int topGoldC;
    public static int arUp;
    public static int arDown;
    public static int hreIcon;
    public static int hreFlag;
    public static int hreCrown;
    public static int hreCrownX;
    public static int hreCrownScaled;
    public static int dice;
    public static int diploWar;
    public static int diploWarPreparations;
    public static int diploWeariness;
    public static int diploTruce;
    public static int diploAlliance;
    public static int diploRelations;
    public static int diploRelationsInc;
    public static int diploRelationsDec;
    public static int diploTrade;
    public static int diploDefensivePact;
    public static int diploNonAggression;
    public static int diploGuaranteeHas;
    public static int diploGuaranteeGives;
    public static int diploAccessHas;
    public static int diploAccessGives;
    public static int diploGift;
    public static int diploRevolution;
    public static int diploStability;
    public static int diploUnion;
    public static int diploVassal;
    public static int diploLord;
    public static int diploLoan;
    public static int diploLoan2;
    public static int globalDebt;
    public static int diploPlunder;
    public static int diploArmy;
    public static int diploArmyMove;
    public static int diploArmyDisband;
    public static int diploArmySend;
    public static int diploArmyStar;
    public static int diploArmySend2;
    public static int diploGoldenAge;
    public static int diploGoldenAgeM;
    public static int diploGoldenAgeS;
    public static int diploIntervene;
    public static int mercenaries;
    public static int gov;
    public static int conquered;
    public static int investF;
    public static int investF1;
    public static int investB;
    public static int investB1;
    public static int propaganda;
    public static int propaganda1;
    public static int summit;
    public static int debt;
    public static int loanRe;
    public static int sanctions;
    public static int promoteStability;
    public static int overInvest;
    public static int defensivePosition;
    public static int attack;
    public static int defense;
    public static int actPlunder;
    public static int actAttack;
    public static int actRecruit;
    public static int actMove;
    public static int actMoveTo;
    public static int actMore;
    public static int actMigrate;
    public static int diploMessage;
    public static int diploAZ;
    public static int diploHeart;
    public static int diploRivals;
    public static int diploRivals2;
    public static int diploRivaledBy;
    public static int diploFestival;
    public static int spy;
    public static int transferControl;
    public static int bFort;
    public static int bTower;
    public static int bPort;
    public static int bFarm;
    public static int bLibrary;
    public static int bArmoury;
    public static int bWorkshop;
    public static int bSupply;
    public static int bMarket;
    public static int buildAll;
    public static int nuke;
    public static int botEndLeft;
    public static int botProvName;
    public static int botProvNameLeft;
    public static int botIconsBG;
    public static int stats;
    public static int research;
    public static int technology;
    public static int provinces;
    public static int development;
    public static int investEco;
    public static int investDev;
    public static int developmentDown;
    public static int happiness;
    public static int happiness1;
    public static int happiness2;
    public static int battle;
    public static int neighWar;
    public static int neighTruce;
    public static int infoBox;
    public static int infoDiplomacy;
    public static int infoTech;
    public static int infoWar;
    public static int infoRelations;
    public static int infoStability;
    public static int infoEconomy;
    public static int infoTruce;
    public static int infoDev;
    public static int infoFestival;
    public static int infoBuild;
    public static int infoNuke;
    public static int mapWar;
    public static int skull;
    public static int goods;
    public static int religion;
    public static int administration;
    public static int wonders;
    public static int frontline;
    public static int rank1;
    public static int rank2;
    public static int rank3;
    public static int key;
    public static int core;
    public static int peace;
    public static int portIco;
    public static int towerIco;
    public static int fortIco;
    public static int towerFortIco;
    public static int armouryIco;
    public static int wikipedia;
    public static int titleEdge;
    public static int dialog_title;
    public static int dialog_desc;
    public static int dialog_line;
    public static int mainMenuEdge;
    public static int mainMenuEdge2;
    public static int logo_steam;
    public static int logo_android;
    public static int logo_app;
    public static int logo_fb;
    public static int logo_twit;
    public static int logo_yt;
    public static int editor_top;
    public static int editor_top_line;
    public static int editor_line;
    public static int wasteland;
    public static int slideBG;
    public static int scrollPosition;
    public static int scrollPositionActive;
    public static int gradient;
    public static int circle55;
    public static List<Integer> nukeImg;
    public static int nukeIMGSize;
    public static int gameTop;
    public static int gameTopEdge;
    public static int gameTopEdgeTitle;
    public static int gameTopEdgeLine;
    public static int gameTopEdgeLineHorizontal;
    public static int gameBox;
    public static int gameBoxHover;
    public static int gameBoxLine;
    public static int gameBoxLineHover;
    public static int line11;
    public static int line22;
    public static int line32;
    public static int line33;
    public static int line44;
    public static int line26;
    public static int line62;
    public static int line32Off1;
    public static int line32Vertical;
    public static int mapBorder;
    public static int terrainUnknown;
    public static int terrainUnknown2;
    public static int flagRectSmall;
    public static int flagCircle;
    public static int flagCircleShader;
    public static int flagBigOver;
    public static int flagBigMask;
    public static int flagBigMaskLord;
    public static int flagBigOver2;
    public static int flagBigMask2;
    public static int flagBigMaskLord2;
    public static int flagDiplomacyOver;
    public static int flagDiplomacyMask;
    public static int flagRect2;
    public static int flagRect2Mask;
    public static int armyLeft;
    public static int armyMiddle;
    public static int armyBG;
    public static int army_sea;
    public static int army_16_seaBG;
    public static int army_capital;
    public static int army_capital_frame;
    public static int civNameBG;
    public static int civFlagBG;
    public static int news;
    public static int pop;
    public static int popGrowth;
    public static int economy;
    public static int disease;
    public static int victoryPoints;
    public static int rank;
    public static int time;
    public static int randomCivilizationFlag;
    public static int loading_rect_edge;
    public static int slider_rect_edge;
    public static int editorGame;
    public static int editorMap;
    public static int editorCity;
    public static int editorCiv;
    public static int editorLeaders;
    public static int icon_save;
    public static int gameLogo;
    public static int gameLogoC;
    public static int iconTrue;
    public static int iconFalse;
    public static int pickerSV;
    public static int pickerHUE;
    public static int pickerIcon;
    public static int pickerSVPos;
    public static int pickerEdge;
    public static int statsRectBG;
    public static int statsRectBGBorder;
    public static int statsBox;
    public static int difficultyBox;
    public static int difficultyHeaven;
    public static int difficultyHell;
    public static List<Image> sparks;
    public static int SPARKS_SIZE;
    public static int sparkWidth;
    public static int sparkHeight;

    public static void updateGold() {
        try {
            if (CFG.core.getPlayersSize() == 1 && !CFG.SPECTATOR_MODE && GameCalendar.currYear > GameValues.gvCommands.CURRENCY_IMAGES_MIN_YEAR) {
                if (topGoldOrg == 0) {
                    topGoldOrg = topGold;
                }
                if (topGoldC == 0 && FileManager.loadFile("UI/currency/H/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivTag()) + ".png").exists()) {
                    Core.addSimpleTask(new Core.SimpleTask("LoadGoldC"){

                        @Override
                        public void update() {
                            if (CFG.XXHDPI || CFG.XXXHDPI) {
                                if (FileManager.loadFile("UI/currency/XXH/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivTag()) + ".png").exists()) {
                                    topGold = topGoldC = IMGManager.addIMG("UI/currency/XXH/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivTag()) + ".png");
                                }
                                return;
                            }
                            topGold = topGoldC = IMGManager.addIMG("UI/currency/H/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivTag()) + ".png");
                        }
                    });
                } else {
                    topGold = topGoldOrg;
                }
            } else if (topGoldOrg == 0) {
                topGoldOrg = topGold;
            } else {
                topGold = topGoldOrg;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static int topGold() {
        return topGold;
    }

    static {
        topGoldOrg = 0;
        topGoldC = 0;
        nukeImg = new ArrayList<Integer>();
        nukeIMGSize = 0;
        sparks = new ArrayList<Image>();
        SPARKS_SIZE = 30;
    }
}

