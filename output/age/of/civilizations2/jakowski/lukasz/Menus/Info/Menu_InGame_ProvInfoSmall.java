/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Info;

import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBarFlag;
import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar_Assimilate;
import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar_Cores;
import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar_DefensivePosition;
import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar_Disease;
import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar_Festival;
import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar_ISNotSupplied;
import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar_Invest;
import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar_InvestDevelopment;
import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar_NewColony;
import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar_ProvinceValue;
import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar_Religion;
import age.of.civilizations2.jakowski.lukasz.Button.BotBar.Button_BotBar_SuppRebels;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent_WithHoverEnabled;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_GameNextTurn;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.Button_Stats_Image;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon_FlagDiplomacy2;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon_Population;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Festivals.Festival;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Circle;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Keyboard;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Religion_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Info.Menu_InGame_ProvInfo;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.Touch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_ProvInfoSmall
extends Menu {
    public SparksAnimation sparksAnimation = new SparksAnimation();
    public static int iMaxWidth = 1;
    public static int terrainW = 1;
    public static int terrainH = 1;
    private Box box;
    public static List<Integer> lBuildingsImages = new ArrayList<Integer>();
    public static int iBuildingsWidth = 0;

    public final void updateTurnWidth() {
    }

    public Menu_InGame_ProvInfoSmall() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.box = new Box();
        this.box.iProvinceName = CFG.XXXHDPI ? 6 : (CFG.XXHDPI ? 6 : (CFG.XHDPI ? 5 : 4));
        int tier3Width = (int)((float)CFG.BUTTON_W * 0.88f);
        terrainW = CFG.terrainTypesManager.getIcon(0).getWidth() / 2;
        terrainH = CFG.terrainTypesManager.getIcon(0).getHeight() / 2;
        CFG.glyphLay.setText(CFG.fontMain.get(0), CFG.lang.get("NextTurn"));
        int tempWidth = CFG.glyphLay.width + (float)(CFG.PADD * 4) > (float)CFG.BUTTON_W ? (int)(CFG.glyphLay.width + (float)(CFG.PADD * 4)) : CFG.BUTTON_W;
        if (!CFG.getIsDesktop()) {
            tempWidth = CFG.BUTTON_W * 2;
        }
        menuElements.add(new Button_GameNextTurn(null, -1, CFG.GAMEWIDTH - tempWidth - CFG.PADD - CFG.map.getMpB().getMinimapWidth(), CFG.PADD, tempWidth, true){

            @Override
            public void buildElemHover() {
                if (CFG.getIsDesktop()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("SPACE", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
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
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }

            @Override
            public boolean getIsClickable() {
                return super.getIsClickable() && CFG.chosenProvinceID < 0 && !CFG.menus.getInGame_ProvinceRecruit_Visible() && !CFG.menus.getInGame_ProvinceDisband_Visible() && !CFG.menus.getInGame_ProvinceRecruitInstantly_Visible();
            }

            @Override
            public void setTextE(String sText) {
                super.setTextE(sText);
                Menu_InGame_ProvInfoSmall.this.updateTurnWidth();
            }
        });
        menuElements.add(new Text("", CFG.PADD, CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth() * 2 - CFG.PADD * 3 - tempWidth, CFG.BUTTON_H + CFG.PADD * 2 - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2), CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, CFG.FONT_BOLD_SMALL){

            @Override
            public int getPosXE() {
                return Menu_InGame_ProvInfoSmall.this.getMenuElem(0).getPosXE() - CFG.PADD * 2 - CFG.iProvinceNameWidth;
            }

            @Override
            public int getWidthE() {
                return CFG.PADD * 3 + CFG.iProvinceNameWidth;
            }

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + iTranslateX, this.getPosY() + CFG.PADD + iTranslateY, this.getColor(isActive));
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? new Color(0.56f, 0.56f, 0.56f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? new Color(0.78f, 0.78f, 0.78f, 1.0f) : new Color(0.92f, 0.92f, 0.92f, 1.0f)) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverProvince();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Button_BotBarFlag("", 0.85f, 1, 1, 1, true, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
            }

            @Override
            public void setTextE(String sText) {
                if (sText.length() > (CFG.isAndroid() ? 20 : 30)) {
                    sText = sText.substring(0, Math.min(CFG.isAndroid() ? 20 : 30, sText.length() - 1));
                }
                super.setTextE(sText);
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverProvinceOwner(this.getCurr());
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Button_BotBar_Cores(CFG.lang.get("Cores") + ":", 1.0f, 1, 1, 1, true, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverCores();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        int tierHeight = (int)Math.floor((CFG.map.getMpB().getMinimapHeight() - ((MenuElemUI)menuElements.get(2)).getHeightE() - 2 - CFG.PADD * 3) / 2);
        int tierHeight1 = (int)Math.floor(CFG.map.getMpB().getMinimapHeight() - ((MenuElemUI)menuElements.get(2)).getHeightE() - 2 - CFG.PADD * 2);
        int infoLeftWidth2 = (int)((float)IMGManager.getIMG(Images.terrainUnknown).getWidth() * 1.1f - (float)CFG.PADD) / 2;
        int extraLeftButtonsH = CFG.PADD / 2;
        int flagWLeft = IMGManager.getIMG(Images.flagDiplomacyOver).getWidth() + CFG.PADD * 2;
        menuElements.add(new TextIcon_Population("", Images.pop, CFG.PADD * 2 + flagWLeft, ((MenuElemUI)menuElements.get(2)).getPosY() + ((MenuElemUI)menuElements.get(2)).getHeightE() + extraLeftButtonsH, infoLeftWidth2, tierHeight1 + extraLeftButtonsH * 2){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_POPULATION_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_POPULATION_HOVER : CFG.COLOR_POPULATION) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverPopulation();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        ArrayList<Long> nData = new ArrayList<Long>();
        ArrayList<Integer> nCivs = new ArrayList<Integer>();
        nData.add(1L);
        nCivs.add(0);
        menuElements.add(new Graph_Circle(CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth() - ((MenuElemUI)menuElements.get(0)).getWidthE() - CFG.PADD * 2 - terrainW - CFG.PADD, CFG.PADD, nData, nCivs, null){

            @Override
            public int getPosXE() {
                return super.getPosXE() - this.getWidthE();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setAnotherView(false);
        menuElements.add(new Button_Transparent_WithHoverEnabled(0, 0, terrainW, terrainH + CFG.PADD * 2, true){

            @Override
            public int getPosXE() {
                return Menu_InGame_ProvInfoSmall.this.getMenuElem(0).getPosXE() - CFG.PADD * 2 - this.getWidthE();
            }

            @Override
            public void buildElemHover() {
                try {
                    if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.ACTIVE_PROVINCE_INFO)) {
                        this.menuElemHover = CFG.core.getHover_TerrainTypeInfo(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTerrainTypeID(), CFG.ACTIVE_PROVINCE_INFO);
                    } else {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                }
                catch (Exception ex) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new TextIcon("", Images.economy, CFG.PADD * 3 + flagWLeft + infoLeftWidth2, ((MenuElemUI)menuElements.get(2)).getPosY() + ((MenuElemUI)menuElements.get(2)).getHeightE() + extraLeftButtonsH, tier3Width, tierHeight1 + extraLeftButtonsH * 2, CFG.FONT_BOLD_SMALL, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_ECONOMY_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_ECONOMY_HOVER : CFG.COLOR_ECONOMY) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverEconomy();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }

            @Override
            public void actionElemPPM() {
                try {
                    if (CFG.ACTIVE_PROVINCE_INFO >= 0 && CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        if (GameManager.invest(CFG.ACTIVE_PROVINCE_INFO, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), GameManager.invest_MaxEconomy_Gold(CFG.ACTIVE_PROVINCE_INFO, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()))) {
                            CFG.toastM.addM(CFG.lang.get("Ok") + "!", CFG.COLOR_POSITIVE);
                            CFG.toastM.setTimeInView(3500);
                            CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Invest") + ": " + CFG.lang.get("Economy"), CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName(), Images.infoEconomy);
                            CFG.gameAction.updateInGame_ProvinceInfo();
                            if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                                CFG.menus.setVisible_InGame_ProvinceMore(true, true);
                            }
                            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE) {
                                CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).viewBool = true;
                                if (CFG.menus.getVisible_InGame_View_Stats()) {
                                    CFG.menus.setVisible_InGame_ViewEconomy(true);
                                }
                            }
                            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_INCOME_MODE) {
                                CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).viewBool = true;
                                if (CFG.menus.getVisible_InGame_View_Stats()) {
                                    CFG.menus.setVisible_InGame_ViewIncome(true);
                                }
                            }
                            CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        }
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
        });
        menuElements.add(new Button_BotBar_Religion("0", 1.0f, 1, 1, 1, true, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Religion") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.religionManager.getReligion((int)this.getCurr()).Name, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Religion_Big(this.getCurr(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.religionManager.getReligion((int)this.getCurr()).ACCEPTABLE_TAXATION != 0.0f) {
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AcceptableTaxation") + ": "));
                        nData.add(new ME_Hover_2Type_Text((CFG.religionManager.getReligion((int)this.getCurr()).ACCEPTABLE_TAXATION > 0.0f ? "+" : "") + (int)(CFG.religionManager.getReligion((int)this.getCurr()).ACCEPTABLE_TAXATION * 100.0f) + "%", CFG.religionManager.getReligion((int)this.getCurr()).ACCEPTABLE_TAXATION > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    if (CFG.religionManager.getReligion((int)this.getCurr()).MIN_GOODS != 0.0f) {
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Goods") + ": "));
                        nData.add(new ME_Hover_2Type_Text((CFG.religionManager.getReligion((int)this.getCurr()).MIN_GOODS > 0.0f ? "+" : "") + (int)(CFG.religionManager.getReligion((int)this.getCurr()).MIN_GOODS * 100.0f) + "%", CFG.religionManager.getReligion((int)this.getCurr()).MIN_GOODS < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(Images.goods, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    if (CFG.religionManager.getReligion((int)this.getCurr()).MIN_INVESTMENTS != 0.0f) {
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
                        nData.add(new ME_Hover_2Type_Text((CFG.religionManager.getReligion((int)this.getCurr()).MIN_INVESTMENTS > 0.0f ? "+" : "") + (int)(CFG.religionManager.getReligion((int)this.getCurr()).MIN_INVESTMENTS * 100.0f) + "%", CFG.religionManager.getReligion((int)this.getCurr()).MIN_INVESTMENTS < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    if (CFG.religionManager.getReligion((int)this.getCurr()).RESEARCH_COST != 0.0f) {
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchCost") + ": "));
                        nData.add(new ME_Hover_2Type_Text((CFG.religionManager.getReligion((int)this.getCurr()).RESEARCH_COST > 0.0f ? "+" : "") + (int)(CFG.religionManager.getReligion((int)this.getCurr()).RESEARCH_COST * 100.0f) + "%", CFG.religionManager.getReligion((int)this.getCurr()).RESEARCH_COST < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    if (CFG.religionManager.getReligion((int)this.getCurr()).MILITARY_UPKEEP != 0.0f) {
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                        nData.add(new ME_Hover_2Type_Text((CFG.religionManager.getReligion((int)this.getCurr()).MILITARY_UPKEEP > 0.0f ? "+" : "") + (int)(CFG.religionManager.getReligion((int)this.getCurr()).MILITARY_UPKEEP * 100.0f) + "%", CFG.religionManager.getReligion((int)this.getCurr()).MILITARY_UPKEEP < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                    return;
                }
                catch (Exception exception) {
                    this.menuElemHover = null;
                    return;
                }
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_RELIGION_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_RELIGION_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Religion"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
            }
        });
        menuElements.add(new Button_Stats_Image(Images.popGrowth, "", 1.0f, CFG.PADD, ((MenuElemUI)menuElements.get(4)).getPosY() + extraLeftButtonsH, 1, tierHeight, true, true){
            int iCurrent;
            {
                this.iCurrent = 0;
            }

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_POPULATION_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_POPULATION_HOVER : CFG.getColorStep(CFG.COLOR_POPULATION_GROWTHRATE_MIN, CFG.COLOR_POPULATION_GROWTHRATE_MAX, this.getCurr(), 100, 1.0f)) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                this.iCurrent = nCurrent;
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverGrowthRate();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Button_Stats_Image(Images.development, "", 1.0f, CFG.PADD, ((MenuElemUI)menuElements.get(9)).getPosY() + ((MenuElemUI)menuElements.get(9)).getHeightE() + CFG.PADD, 1, tierHeight, true, true){
            int iCurrent;
            {
                this.iCurrent = 0;
            }

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_POPULATION_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_POPULATION_HOVER : CFG.COLOR_NEUTRAL2) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                this.iCurrent = nCurrent;
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverDevelopment();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }

            @Override
            public void actionElemPPM() {
                try {
                    if (CFG.ACTIVE_PROVINCE_INFO >= 0 && CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        if (GameManager.investDevelopment(CFG.ACTIVE_PROVINCE_INFO, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), GameManager.investMaxDevGold(CFG.ACTIVE_PROVINCE_INFO, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()))) {
                            CFG.toastM.addM(CFG.lang.get("Ok") + "!", CFG.COLOR_POSITIVE);
                            CFG.toastM.setTimeInView(3500);
                            CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Invest") + ": " + CFG.lang.get("Development"), CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName(), Images.infoDev);
                            CFG.gameAction.updateInGame_ProvinceInfo();
                            if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                                CFG.menus.setVisible_InGame_ProvinceMore(true, true);
                            }
                            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE) {
                                CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).viewBool = true;
                                if (CFG.menus.getVisible_InGame_View_Stats()) {
                                    CFG.menus.setVisible_InGame_ViewEconomy(true);
                                }
                            }
                            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_INCOME_MODE) {
                                CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).viewBool = true;
                                if (CFG.menus.getVisible_InGame_View_Stats()) {
                                    CFG.menus.setVisible_InGame_ViewIncome(true);
                                }
                            }
                            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DEVELOPMENT_MODE) {
                                CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).viewBool = true;
                                if (CFG.menus.getVisible_InGame_View_Stats()) {
                                    CFG.menus.setVisible_InGame_ViewDevelopment(true);
                                }
                            }
                            CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        }
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
        });
        menuElements.add(new Button_Stats_Image(Images.happiness, "", 1.0f, CFG.PADD, ((MenuElemUI)menuElements.get(9)).getPosY(), 1, tierHeight, true, true){
            int iCurrent;
            {
                this.iCurrent = 0;
            }

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_HAPPINESS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_HAPPINESS_HOVER : CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, this.getCurr(), 100, 1.0f)) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                this.iCurrent = nCurrent;
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverHappiness(this.getCurr());
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }

            @Override
            public void actionElemPPM() {
                try {
                    if (CFG.ACTIVE_PROVINCE_INFO >= 0 && CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        if (Festival.addFestival(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.ACTIVE_PROVINCE_INFO)) {
                            CFG.toastM.addM(CFG.lang.get("Ok") + "!", CFG.COLOR_POSITIVE);
                            CFG.toastM.setTimeInView(3500);
                            CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Festival"), CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName(), Images.infoFestival);
                            CFG.gameAction.updateInGame_ProvinceInfo();
                            if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                                CFG.menus.setVisible_InGame_ProvinceMore(true, true);
                            }
                            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_HAPPINESS_MODE) {
                                CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).viewBool = true;
                                if (CFG.menus.getVisible_InGame_View_Stats()) {
                                    CFG.menus.setVisible_InGame_ViewHappiness(true);
                                }
                            }
                        }
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
        });
        menuElements.add(new Button_BotBar_Festival("", 1.0f, 1, 1, 1, true, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_PROVINCE_VALUE_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_PROVINCE_VALUE_HOVER : CFG.COLOR_PROVINCE_VALUE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverFestival();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Button_Stats_Image(Images.diploStability, "", 1.0f, CFG.PADD, ((MenuElemUI)menuElements.get(9)).getPosY() + ((MenuElemUI)menuElements.get(9)).getHeightE() + CFG.PADD, 1, tierHeight, true, true){
            int iCurrent;
            {
                this.iCurrent = 0;
            }

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_HAPPINESS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_HAPPINESS_HOVER : CFG.getColorStep(CFG.COLOR_PROVINCE_STABILITY_MIN, CFG.COLOR_PROVINCE_STABILITY_MAX, this.getCurr(), 100, 1.0f)) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                this.iCurrent = nCurrent;
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getStabilityHoverOfProvince(CFG.ACTIVE_PROVINCE_INFO);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }

            @Override
            public void actionElemPPM() {
                try {
                    if (CFG.ACTIVE_PROVINCE_INFO >= 0 && CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        int nMax = 1;
                        if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameManager.assimilateCost(CFG.ACTIVE_PROVINCE_INFO, GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX)) {
                            nMax = GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX;
                        } else {
                            int i = GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX - 1;
                            while (i >= 5) {
                                nMax = i--;
                                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)GameManager.assimilateCost(CFG.ACTIVE_PROVINCE_INFO, nMax)) break;
                            }
                        }
                        if (GameManager.addAssi(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.ACTIVE_PROVINCE_INFO, nMax)) {
                            CFG.toastM.addM(CFG.lang.get("Assimilate") + ": " + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName(), CFG.COLOR_POSITIVE);
                            CFG.toastM.setTimeInView(3500);
                            CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("Assimilate"), CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName(), Images.infoStability);
                            CFG.gameAction.updateInGame_ProvinceInfo();
                            if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                                CFG.menus.setVisible_InGame_ProvinceMore(true, true);
                            }
                            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_PROVINCE_STABILITY_MODE) {
                                CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).viewBool = true;
                                if (CFG.menus.getVisible_InGame_View_Stats()) {
                                    CFG.menus.setVisible_InGame_ViewProvinceStability(true);
                                }
                            }
                            CFG.SFXManager.playSound(SFXManager.SFX_ASSIMILATE);
                        }
                        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
        });
        menuElements.add(new Text("", CFG.PADD, CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth() * 2 - CFG.PADD * 3 - tempWidth, CFG.BUTTON_H + CFG.PADD * 2 - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2), CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

            @Override
            public int getPosXE() {
                return Menu_InGame_ProvInfoSmall.this.getMenuElem(0).getPosXE() - CFG.PADD - CFG.iProvinceNameWidth - this.getWidthE();
            }

            @Override
            public int getWidthE() {
                return iBuildingsWidth + CFG.PADD * 2;
            }

            @Override
            public boolean getVisibleE() {
                return super.getVisibleE() && iBuildingsWidth > 0;
            }

            @Override
            public void setVisibleE(boolean isVisible) {
                super.setVisibleE(isVisible);
                if (!isVisible) {
                    lBuildingsImages.clear();
                    iBuildingsWidth = 0;
                }
            }

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                if (isActive) {
                    oSB.setColor(1.0f, 1.0f, 1.0f, 0.65f);
                } else if (this.getIsHovered()) {
                    oSB.setColor(1.0f, 1.0f, 1.0f, 0.75f);
                }
                int iExtraX = 0;
                for (int i = 0; i < lBuildingsImages.size(); ++i) {
                    IMGManager.getIMG(lBuildingsImages.get(i)).draw(oSB, this.getPosXE() + CFG.PADD + iExtraX + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)IMGManager.getIMG(lBuildingsImages.get(i)).getHeight() * Menu_InGame_ProvInfoSmall.getImageScale(lBuildingsImages.get(i))) / 2 + iTranslateY, (int)((float)IMGManager.getIMG(lBuildingsImages.get(i)).getWidth() * Menu_InGame_ProvInfoSmall.getImageScale(lBuildingsImages.get(i))), (int)((float)IMGManager.getIMG(lBuildingsImages.get(i)).getHeight() * Menu_InGame_ProvInfoSmall.getImageScale(lBuildingsImages.get(i))));
                    iExtraX += CFG.PADD + (int)((float)IMGManager.getIMG(lBuildingsImages.get(i)).getWidth() * Menu_InGame_ProvInfoSmall.getImageScale(lBuildingsImages.get(i)));
                }
                oSB.setColor(Color.WHITE);
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? new Color(0.56f, 0.56f, 0.56f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? new Color(0.78f, 0.78f, 0.78f, 1.0f) : new Color(0.92f, 0.92f, 0.92f, 1.0f)) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverBuildings();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Button_Stats_Image(Images.diploRevolution, "", 1.0f, CFG.PADD, ((MenuElemUI)menuElements.get(9)).getPosY() + ((MenuElemUI)menuElements.get(9)).getHeightE() + CFG.PADD, 1, tierHeight, true, true){
            int iCurrent;
            {
                this.iCurrent = 0;
            }

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_HAPPINESS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_HAPPINESS_HOVER : CFG.getColorStep(CFG.COLOR_REVOLUTION_MIN, CFG.COLOR_REVOLUTION_MAX, this.getCurr(), 100, 1.0f)) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getCurr() {
                return this.iCurrent;
            }

            @Override
            public void setCurr(int nCurrent) {
                this.iCurrent = nCurrent;
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverRevolutionaryRisk();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Button_BotBar_Assimilate("", 1.0f, 1, 1, 1, true, true){

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverAssimilate();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Button_BotBar_Invest("", 1.0f, 1, 1, 1, true, true){

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverInvest();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Button_BotBar_InvestDevelopment("", 1.0f, 1, 1, 1, true, true){

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverInvestDev();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Button_BotBar_ISNotSupplied("", 1.0f, 1, 1, 1, true, true){

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverNotSupplied();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Button_BotBar_DefensivePosition("", 1.0f, 1, 1, 1, true, true){

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverDefensivePosition();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Button_BotBar_Disease("", 1.0f, 1, 1, 1, true, true){

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverDisease();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Button_BotBar_NewColony("", 1.0f, 1, 1, 1, true, true){

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverNewColony();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Button_BotBar_SuppRebels("", 1.0f, 1, 1, 1, true, true){

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Text("0", 0, CFG.GAMEWIDTH, terrainH + CFG.PADD, CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, CFG.FONT_BOLD_SMALL){

            @Override
            public int getPosXE() {
                return Menu_InGame_ProvInfoSmall.this.getMenuElem(0).getPosXE() - CFG.PADD - this.getWidthE();
            }

            @Override
            public int getWidthE() {
                return terrainW;
            }

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 - CFG.PADD + iTranslateX, this.getPosY() + (int)((float)this.getHeightE() / 2.0f - (float)this.getTextHeight() / 2.0f) + iTranslateY, this.getColor(isActive));
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_HOVERED : CFG.COLOR_BUTTON_GAME_TEXT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverProvinceConnections();
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Button_BotBar_ProvinceValue("0", 1.0f, 1, 1, 1, true, true){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_PROVINCE_VALUE_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_PROVINCE_VALUE_HOVER : CFG.COLOR_PROVINCE_VALUE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverProvinceValue(this.getTextE());
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new TextIcon_FlagDiplomacy2("", 1, CFG.PADD, ((MenuElemUI)menuElements.get(2)).getPosY() + ((MenuElemUI)menuElements.get(2)).getHeightE() + extraLeftButtonsH, flagWLeft, tierHeight1 + extraLeftButtonsH * 2){

            @Override
            public Color getColorE(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_LEFT_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_LEFT_NS_HOVER : CFG.COLOR_TEXT_GRAY_LEFT_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
            }

            @Override
            public void buildElemHover() {
                this.menuElemHover = Menu_InGame_ProvInfo.getHoverProvinceOwner(this.getCurr());
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        this.initMenu(null, CFG.map.getMpB().getMinimapWidth(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight(), CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), CFG.BUTTON_H + CFG.PADD * 2, menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("NextTurn"));
        if (!CFG.getIsDesktop()) {
            this.updateButtonWidth(0, CFG.PADD, CFG.BUTTON_W * 2);
            this.getMenuElem(0).setPosX(CFG.GAMEWIDTH - this.getMenuElem(0).getWidthE() - CFG.PADD - CFG.map.getMpB().getMinimapWidth());
        } else {
            this.updateButtonWidth(0, CFG.PADD, CFG.BUTTON_W);
            this.getMenuElem(0).setPosX(CFG.GAMEWIDTH - this.getMenuElem(0).getWidthE() - CFG.PADD - CFG.map.getMpB().getMinimapWidth());
        }
        this.getMenuElem(3).setTextE(CFG.lang.get("Cores") + ":");
    }

    public static final void updateBuildingsList(int nProvinceID) {
        lBuildingsImages.clear();
        if (CFG.core.getProv(nProvinceID).getLvlOfFort() > 0) {
            lBuildingsImages.add(Images.bFort);
        }
        if (CFG.core.getProv(nProvinceID).getLvlOfWatchTower() > 0) {
            lBuildingsImages.add(Images.bTower);
        }
        if (CFG.core.getProv(nProvinceID).getLvlOfPort() > 0) {
            lBuildingsImages.add(Images.bPort);
        }
        if (CFG.core.getProv(nProvinceID).getLvlOfLibrary() > 0) {
            lBuildingsImages.add(Images.bLibrary);
        }
        if (CFG.core.getProv(nProvinceID).getLvlOfFarm() > 0) {
            lBuildingsImages.add(Images.bFarm);
        }
        if (CFG.core.getProv(nProvinceID).getLvlOfWorkshop() > 0) {
            lBuildingsImages.add(Images.bWorkshop);
        }
        if (CFG.core.getProv(nProvinceID).getLvlOfMarket() > 0) {
            lBuildingsImages.add(Images.bMarket);
        }
        if (CFG.core.getProv(nProvinceID).getLvlOfArmoury() > 0) {
            lBuildingsImages.add(Images.bArmoury);
        }
        if (CFG.core.getProv(nProvinceID).getLvlOfSupply() > 0) {
            lBuildingsImages.add(Images.bSupply);
        }
        iBuildingsWidth = 0;
        for (int i = 0; i < lBuildingsImages.size(); ++i) {
            iBuildingsWidth += (int)((float)IMGManager.getIMG(lBuildingsImages.get(i)).getWidth() * Menu_InGame_ProvInfoSmall.getImageScale(lBuildingsImages.get(i))) + CFG.PADD;
        }
        if (lBuildingsImages.size() > 0) {
            iBuildingsWidth += CFG.PADD * 2;
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        try {
            int activeProvinceInfo;
            int n = activeProvinceInfo = CFG.chosenProvinceID >= 0 ? CFG.chosenProvinceID : CFG.core.getActiveProvID();
            if (iMaxWidth != 0) {
                if (iMaxWidth > 0) {
                    IMGManager.getIMG(Images.bgGameMenu).draw2(oSB, this.getPosX() + 1 + iTranslateX, this.getPosY() + iTranslateY, iMaxWidth - IMGManager.getIMG(Images.bgGameMenuRSmall).getWidth(), this.getHeightM());
                    IMGManager.getIMG(Images.bgGameMenuRSmall).draw2(oSB, this.getPosX() + 1 + iMaxWidth - IMGManager.getIMG(Images.bgGameMenuRSmall).getWidth() + iTranslateX, this.getPosY() - 1 + iTranslateY, IMGManager.getIMG(Images.bgGameMenuRSmall).getWidth(), this.getHeightM() + 1, true, false);
                    if (activeProvinceInfo >= 0 && CFG.core.getProv(activeProvinceInfo).isOccupied()) {
                        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.075f));
                        IMGManager.getIMG(Images.patternReversed).draw2(oSB, this.getPosX() + 1 + iTranslateX, this.getPosY() + 1 + iTranslateY, iMaxWidth, this.getHeightM() - 1);
                        oSB.setColor(Color.WHITE);
                    }
                    oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.55f));
                    IMGManager.getIMG(Images.sliderGradient).draw(oSB, this.getPosX() + 1 + iTranslateX, this.getPosY() + 1 + iTranslateY, Math.min(this.getMenuElem(9).getPosXE() + this.getMenuElem(9).getWidthE() + CFG.PADD * 2, iMaxWidth), this.getHeightM() - 1);
                    oSB.setColor(new Color(0.012f, 0.024f, 0.072f, 0.2f));
                    IMGManager.getIMG(Images.gradient).draw(oSB, this.getPosX() + 1 + iTranslateX, this.getPosY() + this.getHeightM() - CFG.PADD + iTranslateY, iMaxWidth, CFG.PADD, false, true);
                    oSB.setColor(Color.WHITE);
                    oSB.setColor(SparksAnimation.sparksColors);
                    this.sparksAnimation.draw(oSB, this.getPosX() + 1 + iTranslateX, this.getPosY() + iTranslateY, iMaxWidth, this.getHeightM());
                    oSB.setColor(Color.WHITE);
                    if (this.getMenuElem(5).getVisibleE()) {
                        IMGManager.getIMG(Images.bgGameMenuR).draw2(oSB, this.getPosX() + this.getMenuElem(5).getPosXE() - CFG.PADD * 2 + iTranslateX, this.getPosY() - 1 + iTranslateY, CFG.GAMEWIDTH - (this.getPosX() + this.getMenuElem(5).getPosXE() - CFG.PADD * 2), this.getHeightM() + 1, false, false);
                    }
                } else {
                    IMGManager.getIMG(Images.bgGameMenu).draw2(oSB, this.getPosX() + 1 + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM() - 1, this.getHeightM());
                    if (activeProvinceInfo >= 0 && CFG.core.getProv(activeProvinceInfo).isOccupied()) {
                        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.1f));
                        IMGManager.getIMG(Images.patternReversed).draw2(oSB, this.getPosX() + 1 + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthM() - 1, this.getHeightM() - 1);
                        oSB.setColor(Color.WHITE);
                    }
                    oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.55f));
                    IMGManager.getIMG(Images.sliderGradient).draw(oSB, this.getPosX() + 1 + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getMenuElem(9).getPosXE() + this.getMenuElem(9).getWidthE() + CFG.PADD * 2, this.getHeightM() - 1);
                    oSB.setColor(new Color(0.012f, 0.024f, 0.072f, 0.2f));
                    IMGManager.getIMG(Images.gradient).draw(oSB, this.getPosX() + 1 + iTranslateX, this.getPosY() + this.getHeightM() - CFG.PADD + iTranslateY, this.getWidthM() - 1, CFG.PADD, false, true);
                    oSB.setColor(Color.WHITE);
                }
            }
            if (CFG.core.getActiveProvID() >= 0) {
                IMGManager.getIMG(Images.botIconsBG).draw2(oSB, CFG.GAMEWIDTH - CFG.PADD * 4 - this.getMenuElem(0).getWidthE() - terrainW + iTranslateX, this.getPosY() + iTranslateY, terrainW + CFG.PADD * 2, this.getHeightM());
                IMGManager.getIMG(Images.botEndLeft).draw2(oSB, CFG.GAMEWIDTH - CFG.PADD * 2 - 1 - this.getMenuElem(0).getWidthE() + iTranslateX, this.getPosY() + iTranslateY, this.getMenuElem(0).getWidthE() + CFG.PADD * 2 + 1, this.getHeightM());
                if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(activeProvinceInfo)) {
                    CFG.terrainTypesManager.getIcon(CFG.core.getProv(activeProvinceInfo).getTerrainTypeID()).draw(oSB, CFG.GAMEWIDTH - CFG.PADD * 2 - this.getMenuElem(0).getWidthE() - CFG.PADD - terrainW + iTranslateX, this.getPosY() + CFG.PADD + iTranslateY, terrainW, terrainH);
                } else {
                    IMGManager.getIMG(Images.terrainUnknown2).draw(oSB, CFG.GAMEWIDTH - CFG.PADD * 2 - this.getMenuElem(0).getWidthE() - CFG.PADD - terrainW + iTranslateX, this.getPosY() + CFG.PADD + iTranslateY, terrainW, terrainH);
                }
                if (this.getMenuElem(14).getVisibleE()) {
                    IMGManager.getIMG(Images.botProvNameLeft).draw2(oSB, CFG.GAMEWIDTH - this.getMenuElem(14).getWidthE() - CFG.PADD - this.getMenuElem(0).getWidthE() - CFG.iProvinceNameWidth - CFG.PADD * 2 + iTranslateX, CFG.GAMEHEIGHT - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD * 2 + iTranslateY, this.getMenuElem(14).getWidthE(), CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + IMGManager.getIMG(Images.botProvNameLeft).getHeight());
                }
                if (this.getMenuElem(1).getVisibleE()) {
                    IMGManager.getIMG(Images.botProvName).draw2(oSB, CFG.GAMEWIDTH - CFG.PADD * 2 - this.getMenuElem(0).getWidthE() - IMGManager.getIMG(Images.botProvName).getWidth() + iTranslateX, CFG.GAMEHEIGHT - (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + this.box.iProvinceName) + iTranslateY, IMGManager.getIMG(Images.botProvName).getWidth(), CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + this.box.iProvinceName);
                    IMGManager.getIMG(Images.botProvNameLeft).draw2(oSB, CFG.GAMEWIDTH - CFG.PADD * 2 - this.getMenuElem(0).getWidthE() - CFG.iProvinceNameWidth - CFG.PADD * 2 + iTranslateX, CFG.GAMEHEIGHT - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD * 2 + iTranslateY, CFG.iProvinceNameWidth + CFG.PADD * 2 - IMGManager.getIMG(Images.botProvName).getWidth(), CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2 + IMGManager.getIMG(Images.botProvNameLeft).getHeight());
                } else {
                    IMGManager.getIMG(Images.botEndLeft).draw2(oSB, CFG.GAMEWIDTH - CFG.PADD * 2 - 1 - this.getMenuElem(0).getWidthE() + iTranslateX, this.getPosY() + iTranslateY, this.getMenuElem(0).getWidthE() + CFG.PADD * 2 + 1, this.getHeightM());
                }
            } else {
                IMGManager.getIMG(Images.botEndLeft).draw2(oSB, CFG.GAMEWIDTH - CFG.PADD * 2 - 1 - this.getMenuElem(0).getWidthE() + iTranslateX, this.getPosY() + iTranslateY, this.getMenuElem(0).getWidthE() + CFG.PADD * 2 + 1, this.getHeightM());
            }
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            if (iMaxWidth >= 0) {
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.7f));
                IMGManager.getIMG(Images.line32Off1).draw(oSB, iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() + iTranslateY, CFG.map.getMpB().getMinimapWidth() + iMaxWidth, 1);
            } else {
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.7f));
                IMGManager.getIMG(Images.line32Off1).draw(oSB, iTranslateX, CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight() + iTranslateY, CFG.GAMEWIDTH, 1);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        oSB.setColor(Color.WHITE);
    }

    private static final float getImageScale(int nImage) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT_SMALL / (float)IMGManager.getIMG(nImage).getHeight();
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                    if (!RTS.PAUSE) {
                        RTS.PAUSED_BY_NEXT_TURN = true;
                    }
                    RTS.PAUSE = true;
                    RTS.resetTime();
                }
                Menu_InGame_ProvInfo.clickEndTurn();
                break;
            }
            case 1: {
                Keyboard.changeCivilizationNameMode = -1;
                Keyboard.changeProvinceNameMode = CFG.core.getActiveProvID();
                Keyboard.changeCityNameIDToo = -1;
                for (int c = 0; c < CFG.core.getProv(Keyboard.changeProvinceNameMode).getCitSize(); ++c) {
                    if (!CFG.core.getProv(Keyboard.changeProvinceNameMode).getCit(c).getCityName().equals(this.getMenuElem(iID).getTextE())) continue;
                    Keyboard.changeCityNameIDToo = c;
                    break;
                }
                CFG.updateKeyboard_Actions();
                CFG.showKeyboard();
                break;
            }
            case 2: {
                if (CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.INPUT_ORDERS || CFG.core.getActiveProvID() < 0 || CFG.menus.getVisible_InGame_FlagAction()) break;
                CFG.menus.setVisible_InGame_CivInfo(!CFG.menus.getVisible_InGame_CivInfo());
                break;
            }
            case 3: {
                if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.ACTIVE_PROVINCE_INFO)) {
                    if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_CORES_MODE) {
                        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_CORES_MODE);
                        CFG.toastM.addM(CFG.lang.get("Cores"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                        CFG.toastM.setTimeInView(1500);
                        try {
                            if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() != CFG.getActiveCivInfoId()) {
                                CFG.setActiveCivInfoId(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId());
                            }
                        }
                        catch (IndexOutOfBoundsException ex) {
                            CFG.exceptionStack(ex);
                        }
                        return;
                    }
                    if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getCivsSize() > 1) {
                        int currID = 0;
                        for (int i = 0; i < CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getCivsSize(); ++i) {
                            if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getCivID(i) != CFG.getActiveCivInfoId()) continue;
                            currID = i;
                            break;
                        }
                        boolean disableView = false;
                        if (++currID >= CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getCivsSize()) {
                            currID = 0;
                            disableView = true;
                        }
                        if (!CFG.menus.getVisible_InGame_CivInfo()) {
                            CFG.menus.setVisible_InGame_CivInfo(!CFG.menus.getVisible_InGame_CivInfo());
                        }
                        CFG.setActiveCivInfoId(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getCivID(currID));
                        CFG.updateActiveCivilizationInfoInGame();
                        if (disableView) {
                            CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_CORES_MODE);
                            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_CORES_MODE) {
                                CFG.toastM.addM(CFG.lang.get("Cores"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                                CFG.toastM.setTimeInView(1500);
                            }
                            CFG.menus.setVisible_InGame_CivInfo(!CFG.menus.getVisible_InGame_CivInfo());
                            break;
                        }
                        if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_CORES_MODE) break;
                        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_CORES_MODE);
                        CFG.toastM.addM(CFG.lang.get("Cores"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                        CFG.toastM.setTimeInView(1500);
                        break;
                    }
                    CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_CORES_MODE);
                    if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_CORES_MODE) break;
                    CFG.toastM.addM(CFG.lang.get("Cores"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                    CFG.toastM.setTimeInView(1500);
                    try {
                        if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() == CFG.getActiveCivInfoId()) break;
                        CFG.setActiveCivInfoId(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId());
                    }
                    catch (IndexOutOfBoundsException ex) {
                        CFG.exceptionStack(ex);
                    }
                    break;
                }
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_CORES_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_CORES_MODE) break;
                CFG.toastM.addM(CFG.lang.get("Cores"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                CFG.toastM.setTimeInView(1500);
                try {
                    if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() == CFG.getActiveCivInfoId()) break;
                    CFG.setActiveCivInfoId(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId());
                }
                catch (IndexOutOfBoundsException ex) {
                    CFG.exceptionStack(ex);
                }
                break;
            }
            case 4: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_POPULATION_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_POPULATION_MODE) break;
                CFG.toastM.addM(CFG.lang.get("Population"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                break;
            }
            case 6: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_TERRAIN_TYPE_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_TERRAIN_TYPE_MODE) {
                    CFG.toastM.addM(CFG.lang.get("TerrainType"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 7: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_ECONOMY_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Economy"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 17: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_INVESTS_ECO_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_INVESTS_ECO_MODE) {
                    CFG.toastM.addM(CFG.lang.get("EconomicInvestments"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 18: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_INVESTS_DEV_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_INVESTS_DEV_MODE) {
                    CFG.toastM.addM(CFG.lang.get("DevelopmentInvestments"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 8: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_PROVINCE_VALUE_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_PROVINCE_VALUE_MODE) {
                    CFG.toastM.addM(CFG.lang.get("ProvinceValue"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 9: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_GROWTH_RATE_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_GROWTH_RATE_MODE) {
                    CFG.toastM.addM(CFG.lang.get("GrowthRate"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 10: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_DEVELOPMENT_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DEVELOPMENT_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Development"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 11: 
            case 12: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_HAPPINESS_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_HAPPINESS_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Happiness"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 13: 
            case 16: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_PROVINCE_STABILITY_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_PROVINCE_STABILITY_MODE) {
                    ArrayList<String> lMess = new ArrayList<String>();
                    ArrayList<Color> lColors = new ArrayList<Color>();
                    lMess.add(CFG.lang.get("ProvinceStability"));
                    lColors.add(CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                    CFG.toastM.addM(lMess, lColors);
                }
                return;
            }
            case 14: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_BUILDINGS_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_BUILDINGS_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Buildings"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 15: 
            case 23: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_REVOLUTION_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_REVOLUTION_MODE) {
                    CFG.toastM.addM(CFG.lang.get("RevolutionaryRisk"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 19: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_SUPPLIES_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_SUPPLIES_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Supplies"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 20: {
                CFG.toastM.addM(CFG.lang.get("MilitaryUpkeep") + ": -" + Math.ceil((int)(CFG.gameUpdate.getMilitaryUpkeepDefensivePosition(CFG.ACTIVE_PROVINCE_INFO) * 1000.0f)) / 10.0 + "%", CFG.COLOR_POSITIVE);
                return;
            }
            case 21: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_DISEASES_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DISEASES_MODE) {
                    try {
                        CFG.toastM.addM(CFG.plagueManager.getPlague_InGame(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.provincePlague.iPlagueID_InGame).getPlagueName(), CFG.COLOR_NEGATIVE_2);
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    }
                    catch (NullPointerException nullPointerException) {
                        // empty catch block
                    }
                }
                return;
            }
            case 26: {
                if (CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.INPUT_ORDERS || CFG.core.getActiveProvID() < 0 || CFG.menus.getVisible_InGame_FlagAction()) break;
                CFG.menus.setVisible_InGame_CivInfo(!CFG.menus.getVisible_InGame_CivInfo());
            }
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame();
    }

    public static class Box {
        public int iProvinceName;
    }
}

