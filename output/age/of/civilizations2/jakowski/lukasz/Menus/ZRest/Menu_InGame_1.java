/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Rank;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Speed;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Speed_Right;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.Button2.TextTop;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
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
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_2;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextTop_Graph;
import age.of.civilizations2.jakowski.lukasz.Touch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_1
extends Menu {
    public Menu_InGame_1() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Minimap(0, 0){

            @Override
            public int getPosY() {
                return CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight();
            }

            @Override
            public void actionElem(int iID) {
                CFG.map.getMpC().centerToMinimapClick(Touch.getMousePosX() - Menu_InGame_1.this.getMenuElem(iID).getPosXE() - this.getPosXE(), Touch.getMousePosY() - Menu_InGame_1.this.getMenuElem(iID).getPosY() - Menu_InGame_1.this.getMenuPosY());
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
                    // empty catch block
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
                return Menu_InGame_1.this.getMenuElem(10).getVisibleE() ? Menu_InGame_1.this.getMenuElem(10).getPosXE() + Menu_InGame_1.this.getMenuElem(10).getWidthE() : Menu_InGame_1.this.getMenuElem(3).getPosXE() + Menu_InGame_1.this.getMenuElem(3).getWidthE();
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
                return Menu_InGame_1.this.getMenuElem(8).getPosXE() + Menu_InGame_1.this.getMenuElem(8).getWidthE();
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
                    oSB.setColor(new Color(CFG.COLOR_TEXT_CHECKBOX_TRUE.r, CFG.COLOR_TEXT_CHECKBOX_TRUE.g, CFG.COLOR_TEXT_CHECKBOX_TRUE.b, 0.05f));
                    IMGManager.getIMG(Images.gradientFull).draw(oSB, iTranslateX, iTranslateY, this.getWidthE(), this.getHeightE());
                    oSB.setColor(new Color(CFG.COLOR_TEXT_CHECKBOX_TRUE.r, CFG.COLOR_TEXT_CHECKBOX_TRUE.g, CFG.COLOR_TEXT_CHECKBOX_TRUE.b, 0.145f));
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
                return isActive ? CFG.COLOR_TEXT_CIV_NAME_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_NAME_HOVERED : CFG.COLOR_TEXT_CIV_NAME) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
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
                return isActive ? CFG.COLOR_TEXT_RANK_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_RANK_HOVER : CFG.COLOR_TEXT_RANK) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getPosXE() {
                return Menu_InGame_1.this.getMenuElem(4).getPosXE();
            }

            @Override
            public int getWidthE() {
                return Menu_InGame_1.this.getMenuElem(4).getWidthE();
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
                return Menu_InGame_1.this.getMenuElem(4).getPosXE() - this.getWidthE();
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
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.03137255f, 0.03137255f, 0.03137255f, 1.0f));
        IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, CFG.GAMEWIDTH, IMGManager.getIMG(Images.topBar).getHeight());
        oSB.setColor(new Color(0.16078432f, 0.15686275f, 0.16862746f, 1.0f));
        IMGManager.getIMG(Images.pix255).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + IMGManager.getIMG(Images.topBar).getHeight() - 2 + iTranslateY, CFG.GAMEWIDTH, 2);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        if (Menu_InGame_ProvInfo.getUseSmallProvinceInfo()) {
            oSB.setColor(CFG.COLOR_BG_GAME_MENU_SHADOW);
            IMGManager.getIMG(Images.pix255).draw(oSB, iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - 1 + iTranslateY, CFG.map.getMpB().getMinimapWidth() + Menu_InGame_ProvInfoSmall.iMaxWidth - IMGManager.getIMG(Images.bgGameMenuRSmall).getWidth() + 1);
            IMGManager.getIMG(Images.line32Off1).draw(oSB, iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() - 1 + iTranslateY, CFG.map.getMpB().getMinimapWidth() + Menu_InGame_ProvInfoSmall.iMaxWidth - IMGManager.getIMG(Images.bgGameMenuRSmall).getWidth() + 1, 1);
        }
        oSB.setColor(Color.WHITE);
        if (!Menu_InitGame.PDR && CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.armyExpertiseLevel > 2 && Menu_InGame_2.timeD.isAfter(Menu_InGame_2.timeT)) {
            Renderer.drawText(oSB, CFG.FONT_BOLD, Menu_InGame_2.getInfo(), CFG.BUTTON_W + iTranslateX, CFG.GAMEHEIGHT / 2 + iTranslateY, new Color(1.0f, 1.0f, 1.0f, 0.75f));
        }
    }

    @Override
    public final void onBackPressed() {
        CFG.menus.setVisible_InGame_Options(true);
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame();
    }
}

