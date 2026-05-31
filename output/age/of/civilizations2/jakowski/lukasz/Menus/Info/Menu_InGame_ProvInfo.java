/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Info;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_GameNextTurn;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Button_Terrain_ProvinceInfo;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon_Cores;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon_FlagDiplomacy;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon_FlagRect;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon_Horizontal;
import age.of.civilizations2.jakowski.lukasz.Button2.TextIcon_Population;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Festivals.Festival;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph_Circle;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Keyboard;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.MissileManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.Province_Claims;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Color;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big2;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Religion;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Religion_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Terrain;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Wonder;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Diplomacy.Menu_NV;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_2;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Sparks.SparksAnimation;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextIcon_Religion;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import age.of.civilizations2.jakowski.lukasz.Z_Other.Tutorial_ActionType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_InGame_ProvInfo
extends Menu {
    public static int iMaxWidth = 1;
    public static Image provinceIMG = null;
    public static int provinceIMG_ID = -1;
    public static int provinceIMG_ID_Loaded = -1;
    public SparksAnimation sparksAnimation = new SparksAnimation();
    public static int tier3Width = CFG.BUTTON_W;
    public static int tier4Width = CFG.BUTTON_W;
    public static List<Integer> lBuildingsImages = new ArrayList<Integer>();
    public static int iBuildingsWidth = 0;

    public static boolean getUseSmallProvinceInfo() {
        return GameValues.gvInGame.USE_SMALL_PROVINCE_INFO || !CFG.getIsDesktop() && GameValues.gvInGame.USE_SMALL_PROVINCE_INFO_MOBILE;
    }

    public static void loadProvinceIMG() {
        if (!GameValues.gvInGame.LOAD_PROVINCE_IMG || !CFG.getIsDesktop() && !GameValues.gvInGame.LOAD_PROVINCE_IMG_MOBILE) {
            return;
        }
        try {
            if (provinceIMG_ID >= 0 && (provinceIMG == null || provinceIMG_ID != provinceIMG_ID_Loaded)) {
                if (provinceIMG != null) {
                    provinceIMG.dispose();
                    provinceIMG = null;
                }
                provinceIMG = Menu_InGame_ProvInfo.loadProvinceImage();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static Image loadProvinceImage() {
        if (!GameValues.gvInGame.LOAD_PROVINCE_IMG || !CFG.getIsDesktop() && !GameValues.gvInGame.LOAD_PROVINCE_IMG_MOBILE) {
            return null;
        }
        try {
            if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "provinces/" + provinceIMG_ID + ".png").exists()) {
                provinceIMG_ID_Loaded = provinceIMG_ID;
                return new Image(IMGManager.loadTexture_RGB888("map/" + CFG.map.getFileActiveMapPath() + "provinces/" + provinceIMG_ID + ".png"), Texture.TextureFilter.Linear, Texture.TextureWrap.ClampToEdge);
            }
        }
        catch (Exception ex) {
            provinceIMG_ID_Loaded = -1;
            CFG.exceptionStack(ex);
        }
        try {
            if (provinceIMG != null) {
                provinceIMG.dispose();
            }
        }
        catch (Exception exr) {
            CFG.exceptionStack(exr);
        }
        return null;
    }

    public final void updateTurnWidth() {
    }

    public Menu_InGame_ProvInfo() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        CFG.glyphLay.setText(CFG.fontMain.get(0), CFG.lang.get("NextTurn"));
        int tempWidth = CFG.glyphLay.width + (float)(CFG.PADD * 4) > (float)CFG.BUTTON_W ? (int)(CFG.glyphLay.width + (float)(CFG.PADD * 4)) : CFG.BUTTON_W;
        int menuHeight = CFG.map.getMpB().getMinimapHeight();
        int infoLeftWidth = IMGManager.getIMG(Images.terrainUnknown).getWidth();
        int infoLeftWidth2 = (int)((float)IMGManager.getIMG(Images.terrainUnknown).getWidth() * 1.1f);
        tier3Width = CFG.BUTTON_W * 9 / 10;
        tier4Width = CFG.BUTTON_W * 6 / 10;
        menuElements.add(new Button_GameNextTurn(null, -1, CFG.GAMEWIDTH - tempWidth - CFG.PADD - CFG.map.getMpB().getMinimapWidth(), menuHeight - CFG.BUTTON_H - CFG.PADD, tempWidth, true){

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
                Menu_InGame_ProvInfo.this.updateTurnWidth();
            }
        });
        int tierHeight1 = menuHeight - TextIcon_FlagDiplomacy.getButtonHeight() - IMGManager.getIMG(Images.terrainUnknown).getHeight() - CFG.PADD * 4;
        menuElements.add(new TextIcon_FlagRect("0", 0, infoLeftWidth + CFG.PADD * 2, CFG.PADD, infoLeftWidth2, tierHeight1){

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
        menuElements.add(new TextIcon_FlagDiplomacy("", 0, CFG.PADD, CFG.PADD, infoLeftWidth){

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
        int coresH = menuHeight - TextIcon_FlagDiplomacy.getButtonHeight() - IMGManager.getIMG(Images.terrainUnknown).getHeight() - CFG.PADD * 4;
        int coresW = (infoLeftWidth - CFG.PADD) / 2;
        int coresY = TextIcon_FlagDiplomacy.getButtonHeight() + CFG.PADD * 2;
        int coresX = CFG.PADD;
        menuElements.add(new TextIcon_Cores("", new ArrayList(), coresX, coresY, coresW, coresH){

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
        int tierHeight2 = menuHeight - CFG.PADD * 4 - ((MenuElemUI)menuElements.get(1)).getHeightE() - IMGManager.getIMG(Images.terrainUnknown).getHeight();
        menuElements.add(new TextIcon_Population("", Images.pop, CFG.PADD * 2 + infoLeftWidth, ((MenuElemUI)menuElements.get(1)).getPosY() + ((MenuElemUI)menuElements.get(1)).getHeightE() + CFG.PADD, (infoLeftWidth2 - CFG.PADD) / 2, tierHeight2){

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
        menuElements.add(new Graph_Circle(CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth() - ((MenuElemUI)menuElements.get(0)).getWidthE() - CFG.PADD * 2 - CFG.terrainTypesManager.getIcon(0).getWidth() - CFG.PADD * 2 - CFG.PADD, CFG.PADD, nData, nCivs, null){

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setAnotherView(false);
        menuElements.add(new Button_Terrain_ProvinceInfo(CFG.PADD, menuHeight - CFG.PADD - IMGManager.getIMG(Images.terrainUnknown).getHeight()){

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
            public void actionElemPPM() {
                try {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
                        Menu_NV.goBack = View.eINGAME;
                        CFG.menus.setMenuID(View.eNV);
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.popGrowth, CFG.PADD * 2 + infoLeftWidth, ((MenuElemUI)menuElements.get(4)).getPosY() + ((MenuElemUI)menuElements.get(4)).getHeightE() + CFG.PADD, (infoLeftWidth2 - CFG.PADD) / 2, tierHeight, CFG.PADD * 4){
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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.diploRevolution, 0, CFG.PADD, tier3Width, tierHeight1, CFG.PADD * 4){
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
        menuElements.add(new TextIcon_Religion("", 0, CFG.PADD, ((MenuElemUI)menuElements.get(1)).getPosY() + ((MenuElemUI)menuElements.get(1)).getHeightE() + CFG.PADD, tier3Width, tierHeight2, CFG.FONT_BOLD_SMALL){

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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.happiness, ((MenuElemUI)menuElements.get(7)).getPosXE() + ((MenuElemUI)menuElements.get(7)).getWidthE() + CFG.PADD, ((MenuElemUI)menuElements.get(4)).getPosY() + ((MenuElemUI)menuElements.get(4)).getHeightE() + CFG.PADD, (infoLeftWidth2 - CFG.PADD) / 2, tierHeight, CFG.PADD * 4){
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
        menuElements.add(new TextIcon("", Images.economy, CFG.PADD, ((MenuElemUI)menuElements.get(1)).getPosY() + ((MenuElemUI)menuElements.get(1)).getHeightE() + CFG.PADD, tier3Width, tierHeight2, CFG.FONT_BOLD_SMALL){

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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.diploFestival, 0, CFG.PADD, tier4Width, tierHeight1, CFG.PADD * 4){

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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.diploStability, CFG.PADD * 2 + infoLeftWidth, ((MenuElemUI)menuElements.get(4)).getPosY() + ((MenuElemUI)menuElements.get(4)).getHeightE() + CFG.PADD, tier3Width, tierHeight, CFG.PADD * 4){
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
        menuElements.add(new Text("", CFG.PADD, CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth() * 2 - CFG.PADD * 3 - tempWidth, menuHeight - CFG.PADD - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD * 2, CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2){

            @Override
            public int getPosXE() {
                return Menu_InGame_ProvInfo.this.getMenuElem(0).getPosXE() - CFG.PADD - this.getWidthE();
            }

            @Override
            public int getWidthE() {
                return iBuildingsWidth + CFG.PADD;
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
                    IMGManager.getIMG(lBuildingsImages.get(i)).drawO(oSB, this.getPosXE() + CFG.PADD + iExtraX + iTranslateX, this.getPosY() + CFG.PADD - IMGManager.getIMG(lBuildingsImages.get(i)).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(lBuildingsImages.get(i)).getWidth() * Menu_InGame_ProvInfo.getImageScale(lBuildingsImages.get(i))), (int)((float)IMGManager.getIMG(lBuildingsImages.get(i)).getHeight() * Menu_InGame_ProvInfo.getImageScale(lBuildingsImages.get(i))));
                    iExtraX += CFG.PADD + (int)((float)IMGManager.getIMG(lBuildingsImages.get(i)).getWidth() * Menu_InGame_ProvInfo.getImageScale(lBuildingsImages.get(i)));
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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.victoryPoints, 0, CFG.PADD, tier3Width, tierHeight1, CFG.PADD * 4){

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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.diploStability, 0, CFG.PADD, tier4Width, tierHeight1, CFG.PADD * 4){

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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.investEco, 0, CFG.PADD, tier4Width, tierHeight1, CFG.PADD * 4){

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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.investDev, 0, CFG.PADD, tier4Width, tierHeight1, CFG.PADD * 4){

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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.skull, 0, CFG.PADD, tier4Width, tierHeight1, CFG.PADD * 4){

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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.defensivePosition, CFG.PADD * 2 + infoLeftWidth, ((MenuElemUI)menuElements.get(4)).getPosY() + ((MenuElemUI)menuElements.get(4)).getHeightE() + CFG.PADD, tier4Width, tierHeight, CFG.PADD * 4){

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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.disease, 0, CFG.PADD, CFG.BUTTON_W, tierHeight1, CFG.PADD * 4){

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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.editorCity, 0, CFG.PADD, tier4Width, tierHeight1, CFG.PADD * 4){

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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.diploRevolution, 0, CFG.PADD, tier4Width, tierHeight1, CFG.PADD * 4){

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new Text("0", 0, CFG.GAMEWIDTH, CFG.terrainTypesManager.getIcon(0).getHeight() + CFG.PADD * 3, CFG.PADD * 2, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2, CFG.FONT_BOLD_SMALL){

            @Override
            public int getPosXE() {
                return Menu_InGame_ProvInfo.this.getMenuElem(0).getPosXE() - CFG.PADD - this.getWidthE();
            }

            @Override
            public int getWidthE() {
                return CFG.terrainTypesManager.getIcon(0).getWidth() + CFG.PADD * 2;
            }

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + (int)((float)this.getWidthE() / 2.0f - (float)this.getTextWidthU() / 2.0f) + iTranslateX, this.getPosY() + (int)((float)(this.getHeightE() / 2) - (float)CFG.TEXT_HEIGHT_DEFAULT / 2.0f) + iTranslateY, this.getColor(isActive));
            }

            @Override
            public boolean getVisibleE() {
                return false;
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_HOVERED : CFG.COLOR_BUTTON_GAME_TEXT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.development, 0, ((MenuElemUI)menuElements.get(4)).getPosY() + ((MenuElemUI)menuElements.get(4)).getHeightE() + CFG.PADD, tier3Width, tierHeight, CFG.PADD * 4){
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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.topGold(), coresX + CFG.PADD + coresW, coresY, coresW, coresH, CFG.PADD * 2){
            int iCurrent;
            {
                this.iCurrent = 0;
            }

            @Override
            public Color getColorE(boolean isActive) {
                if (this.iCurrent < 0) {
                    return isActive ? CFG.COLOR_NEGATIVE_2 : (this.getIsHovered() ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEGATIVE_1);
                }
                return isActive ? CFG.COLOR_GOLD_ACTIVE : (this.getIsHovered() ? CFG.COLOR_GOLD_HOVER : CFG.COLOR_GOLD);
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
            public void actionElemPPM() {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_INCOME_MODE);
            }

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName().length() > 0 ? CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName() : CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image_Big2(Images.provinces, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    long income = (long)CFG.gameUpdate.getProvIncomeTaxation(CFG.ACTIVE_PROVINCE_INFO);
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Taxation") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + income), CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() > 0) {
                        nData.add(new ME_Hover_2Type_Text(" [" + CFG.getPercentage2Old(income, CFG.core.getCiv((int)CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).getCivId()).incomeTaxation, 100) + "% ", CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), 0, 0));
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId(), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Text("]", CFG.COLOR_NEUTRAL));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    income = (long)CFG.gameUpdate.getProvIncomeProduction(CFG.ACTIVE_PROVINCE_INFO);
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Production") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + income), CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() > 0) {
                        nData.add(new ME_Hover_2Type_Text(" [" + CFG.getPercentage2Old(income, CFG.core.getCiv((int)CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).getCivId()).incomeProduction, 100) + "% ", CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), 0, 0));
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId(), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Text("]", CFG.COLOR_NEUTRAL));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    float fQuality = CFG.gameUpdate.getProvinceAdminQuality(CFG.ACTIVE_PROVINCE_INFO);
                    int nCivID = CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId();
                    float fEfficiency = nCivID > 0 ? CFG.gameUpdate.getAdministrationEfficiency(nCivID) : 0.5f;
                    int nAttackMod = (int)((fEfficiency - 0.5f) * 100.0f);
                    int nDefenseMod = nAttackMod;
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Administration") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + (int)(fQuality * 100.0f) + "%", fQuality > 0.6f ? CFG.COLOR_POSITIVE : (fQuality > 0.3f ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
                    nData.add(new ME_Hover_2Type_Text(" (" + CFG.lang.get("Attack") + ": " + (nAttackMod >= 0 ? "+" : "") + nAttackMod + "%, " + CFG.lang.get("Defense") + ": " + (nDefenseMod >= 0 ? "+" : "") + nDefenseMod + "%)", CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    long tTotal = (long)CFG.gameUpdate.getProvIncomeAndExpenses_Total(CFG.ACTIVE_PROVINCE_INFO);
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Balance") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big((tTotal > 0 ? "+" : "") + CFG.getNumberWthSpaces("" + tTotal), tTotal > 0 ? CFG.COLOR_POSITIVE : (tTotal == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.topGold(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
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
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.investF, 0, CFG.PADD, tier4Width, tierHeight1, CFG.PADD * 4){

            @Override
            public void actionElem(int iID) {
                try {
                    CFG.menus.rebuildInGame_Build_ForeignInvestments(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId());
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ReceivingForeignInvestment"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.investF, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                int iSize = CFG.core.investForeignGold.size();
                for (int i = 0; i < iSize; ++i) {
                    if (CFG.core.investForeignGold.get((int)i).provinceID != CFG.ACTIVE_PROVINCE_INFO) continue;
                    if (CFG.SANDBOX_MODE || CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.investForeignGold.get((int)i).civID)) {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.investForeignGold.get((int)i).civID));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.investForeignGold.get((int)i).civID).getCivName()));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nData.add(new ME_Hover_2Type_Image_Big2(Images.topGold(), CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + CFG.core.investForeignGold.get((int)i).gold), CFG.COLOR_GOLD));
                    nData.add(new ME_Hover_2Type_Image_Big2(Images.time, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(GameCalendar.getDate_ByTurnID(CFG.core.investForeignGold.get((int)i).returnTurnID), CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.investB, 0, CFG.PADD, tier4Width, tierHeight1, CFG.PADD * 4){

            @Override
            public void actionElem(int iID) {
                try {
                    CFG.menus.rebuildInGame_Build_ForeignInvestmentsBuild(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId());
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ReceivingForeignConstruction"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.investB, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                int iSize = CFG.core.buildForeignGold.size();
                for (int i = 0; i < iSize; ++i) {
                    if (CFG.core.buildForeignGold.get((int)i).provinceID != CFG.ACTIVE_PROVINCE_INFO) continue;
                    if (CFG.SANDBOX_MODE || CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.buildForeignGold.get((int)i).civID)) {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.buildForeignGold.get((int)i).civID));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.buildForeignGold.get((int)i).civID).getCivName()));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nData.add(new ME_Hover_2Type_Image_Big2(Images.topGold(), CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + CFG.core.buildForeignGold.get((int)i).gold), CFG.COLOR_GOLD));
                    nData.add(new ME_Hover_2Type_Image_Big2(Images.time, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(GameCalendar.getDate_ByTurnID(CFG.core.buildForeignGold.get((int)i).returnTurnID), CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.propaganda, 0, CFG.PADD, tier4Width, tierHeight1, CFG.PADD * 4){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ReceivingPropaganda"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.propaganda, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                int iSize = CFG.core.propaganda.size();
                for (int i = 0; i < iSize; ++i) {
                    if (CFG.core.propaganda.get((int)i).provinceID != CFG.ACTIVE_PROVINCE_INFO) continue;
                    if (CFG.SANDBOX_MODE || CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.propaganda.get((int)i).byCivID)) {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.propaganda.get((int)i).byCivID));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.propaganda.get((int)i).byCivID).getCivName()));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        menuElements.add(new TextIcon_Horizontal("0", CFG.FONT_BOLD_SMALL, Images.diploArmySend2, 0, CFG.PADD, tier4Width, tierHeight1, CFG.PADD * 4){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AVolunteerArmyHasBeenDeployed"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmySend2, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                int iSize = CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provinceVolunteerArmySent.size();
                for (int i = 0; i < iSize; ++i) {
                    if (CFG.SANDBOX_MODE || CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provinceVolunteerArmySent.get((int)i).fromCivID)) {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provinceVolunteerArmySent.get((int)i).fromCivID));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provinceVolunteerArmySent.get((int)i).fromCivID).getCivName() + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provinceVolunteerArmySent.get((int)i).army), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmySend2, CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text_Big(GameCalendar.getDate_ByTurnID(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provinceVolunteerArmySent.get((int)i).TURN_ID)));
                        nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("Turn") + ": " + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provinceVolunteerArmySent.get((int)i).TURN_ID + "]", CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.time, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered")));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), CFG.GAMEHEIGHT - CFG.map.getMpB().getMinimapHeight());
                }
            }
        });
        
        this.initMenu(null, CFG.map.getMpB().getMinimapWidth(), CFG.GAMEHEIGHT - menuHeight, CFG.GAMEWIDTH - CFG.map.getMpB().getMinimapWidth(), menuHeight, menuElements, true, false);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("NextTurn"));
        this.updateButtonWidth(0, CFG.PADD, CFG.BUTTON_W);
        this.getMenuElem(0).setPosX(CFG.GAMEWIDTH - this.getMenuElem(0).getWidthE() - CFG.PADD - CFG.map.getMpB().getMinimapWidth());
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
        if (CFG.core.getProv(nProvinceID).provGD.iAirDefense > 0) {
            lBuildingsImages.add(Images.bSupply); // Using supply icon for air defense as a placeholder if no specific icon
        }
        iBuildingsWidth = 0;
        for (int i = 0; i < lBuildingsImages.size(); ++i) {
            iBuildingsWidth += (int)((float)IMGManager.getIMG(lBuildingsImages.get(i)).getWidth() * Menu_InGame_ProvInfo.getImageScale(lBuildingsImages.get(i))) + CFG.PADD;
        }
        if (lBuildingsImages.size() > 0) {
            iBuildingsWidth += CFG.PADD * 2;
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        int activeProvinceInfo;
        int n = activeProvinceInfo = CFG.chosenProvinceID >= 0 ? CFG.chosenProvinceID : CFG.core.getActiveProvID();
        if (RTS.SPEED == 6 && !RTS.PAUSE && !RTS.runRTS()) {
            oSB.setColor(Color.WHITE);
            return;
        }
        try {
            if (provinceIMG_ID != activeProvinceInfo) {
                provinceIMG_ID = activeProvinceInfo;
                Menu_InGame_ProvInfo.loadProvinceIMG();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        if (Menu_InGame_2.MENU_AOC_1_BOT) {
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
        } else if (iMaxWidth == 0) {
            if (this.getMenuElem(0).getVisibleE()) {
                IMGManager.getIMG(Images.bgGameMenuR).draw2(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, CFG.GAMEWIDTH - (this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD), this.getMenuElem(0).getHeightE() + CFG.PADD * 2, false, false);
            }
        } else if (iMaxWidth > 0) {
            IMGManager.getIMG(Images.bgGameMenuR).draw2(oSB, this.getPosX() + 1 + iTranslateX, this.getPosY() + iTranslateY, iMaxWidth, this.getHeightM(), true, false);
            IMGManager.getIMG(Images.gameMenuOverlay).draw2(oSB, this.getPosX() + 1 + iTranslateX, this.getPosY() + iTranslateY, iMaxWidth, this.getHeightM(), true, false);
            if (activeProvinceInfo >= 0 && CFG.core.getProv(activeProvinceInfo).isOccupied()) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.3f));
                IMGManager.getIMG(Images.patternReversed).draw2(oSB, this.getPosX() + 1 + iTranslateX, this.getPosY() + iTranslateY, iMaxWidth, this.getHeightM());
                oSB.setColor(Color.WHITE);
            }
            oSB.setColor(SparksAnimation.sparksColors);
            this.sparksAnimation.draw(oSB, this.getPosX() + 1 + iTranslateX, this.getPosY() + iTranslateY, iMaxWidth, this.getHeightM());
            oSB.setColor(Color.WHITE);
            if (this.getMenuElem(0).getVisibleE()) {
                IMGManager.getIMG(Images.bgGameMenuR).draw2(oSB, this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getMenuElem(0).getPosY() - CFG.PADD + iTranslateY, CFG.GAMEWIDTH - (this.getPosX() + this.getMenuElem(0).getPosXE() - CFG.PADD), this.getMenuElem(0).getHeightE() + CFG.PADD * 2, false, false);
            }
            if (!lBuildingsImages.isEmpty()) {
                IMGManager.getIMG(Images.bgGameMenuR).draw2(oSB, this.getPosX() + this.getMenuElem(14).getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getMenuElem(14).getPosY() - CFG.PADD + iTranslateY, this.getMenuElem(14).getWidthE() + CFG.PADD, this.getMenuElem(14).getHeightE() + CFG.PADD * 2, false, false);
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
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
    }

    private static final float getImageScale(int nImage) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImage).getHeight();
    }

    public static final void clickEndTurn() {
        if (CFG.tutorialManager.IN_TUTORIAL && CFG.tutorialManager.tutStep.action(Tutorial_ActionType.NEXT_TURN)) {
            return;
        }
        if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
            if (CFG.settingsGD.CONFIRM_NO_ORDERS && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getNoOrders()) {
                CFG.setDialogType(DialogType.NO_ORDERS);
            } else if (CFG.settingsGD.CONFIRM_END_TURN) {
                CFG.setDialogType(DialogType.CONFIRM_END_TURN);
            } else {
                CFG.gameAction.takeNextTurn();
            }
        } else {
            CFG.gameAction.takeNextTurn();
        }
        if (RTS.isEnabled() && !RTS.PAUSE) {
            RTS.resetTime();
        }
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
                Keyboard.changeAllianceNameMode = -1;
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
            case 11: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_ECONOMY_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ECONOMY_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Economy"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 15: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_PROVINCE_VALUE_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_PROVINCE_VALUE_MODE) {
                    CFG.toastM.addM(CFG.lang.get("ProvinceValue"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 7: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_GROWTH_RATE_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_GROWTH_RATE_MODE) {
                    CFG.toastM.addM(CFG.lang.get("GrowthRate"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 25: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_DEVELOPMENT_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_DEVELOPMENT_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Development"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 9: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_RELIGION_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_RELIGION_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Religion"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 10: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_HAPPINESS_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_HAPPINESS_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Happiness"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 12: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_FESTIVALS_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_FESTIVALS_MODE) {
                    CFG.toastM.addM(CFG.lang.get("Festivals"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 13: {
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
            case 8: 
            case 23: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_REVOLUTION_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_REVOLUTION_MODE) {
                    CFG.toastM.addM(CFG.lang.get("RevolutionaryRisk"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                }
                return;
            }
            case 16: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_ASSIMILATIONS_MODE);
                if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_ASSIMILATIONS_MODE) {
                    CFG.toastM.addM(CFG.lang.get("AssimilationInProgress"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
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
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                return;
            }
            case 26: {
                CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_INCOME_ALL_MODE);
            }
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame();
    }

    public static final ME_Hover_v2 getStabilityHoverOfProvince(int nProvinceID) {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ProvinceStability") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big("" + (int)(CFG.core.getProv(nProvinceID).getProviStability() * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image_Big(Images.diploStability, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            int ownnerPopulation = 0;
            int largestGroup = 0;
            int notOwnerPopulaiton = 0;
            for (int i = 0; i < CFG.core.getProv(nProvinceID).getPop().getNatsSize(); ++i) {
                if (CFG.core.getProv(nProvinceID).getPop().getCivID(i) == CFG.core.getProv(nProvinceID).getCivId()) {
                    ownnerPopulation = (int)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i);
                } else {
                    notOwnerPopulaiton += CFG.core.getProv(nProvinceID).getPop().getPopulationID(i);
                }
                if (CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) <= largestGroup) continue;
                largestGroup = (int)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i);
            }
            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + ownnerPopulation), CFG.COLOR_POPULATION));
            nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(nProvinceID).getCivId(), CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Text(" / ", CFG.COLOR_POPULATION));
            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (ownnerPopulation + notOwnerPopulaiton)), CFG.COLOR_POPULATION));
            nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text("[" + CFG.getPercentage_Max100(ownnerPopulation, ownnerPopulation + notOwnerPopulaiton, 2) + "%]", CFG.COLOR_NEUTRAL));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            if (ownnerPopulation < notOwnerPopulaiton) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OurPopulationIsAMinority"), CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(nProvinceID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getProv(nProvinceID).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getProv(nProvinceID).getProviStability() < 1.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AssimilateTheProvincesToIncreaseStability")));
                nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            float tempScore = Math.min(CFG.core.getProv(nProvinceID).updateStability_Score_Population() * 100.0f, 100.0f);
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
            nData.add(new ME_Hover_2Type_Text("+" + (tempScore != 0.0f ? String.format("%.1f", Float.valueOf(tempScore)).replace(',', '.') : Integer.valueOf((int)tempScore)) + "%", tempScore > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            tempScore = Math.min(CFG.core.getProv(nProvinceID).updateStability_Score_Core() * 100.0f, 100.0f);
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Core") + ": "));
            nData.add(new ME_Hover_2Type_Text("+" + (tempScore != 0.0f ? String.format("%.1f", Float.valueOf(tempScore)).replace(',', '.') : Integer.valueOf((int)tempScore)) + "%", tempScore > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image(Images.core, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            tempScore = Math.min(CFG.core.getProv(nProvinceID).updateStability_Score_Army() * 100.0f, 100.0f);
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Army") + ": "));
            if (CFG.SANDBOX_MODE || CFG.SPECTATOR_MODE || CFG.core.isAlly(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getProv(nProvinceID).getCivId())) {
                nData.add(new ME_Hover_2Type_Text("+" + (tempScore != 0.0f ? String.format("%.1f", Float.valueOf(tempScore)).replace(',', '.') : Integer.valueOf((int)tempScore)) + "%", tempScore > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL));
            } else {
                nData.add(new ME_Hover_2Type_Text("+?", CFG.COLOR_NEUTRAL));
            }
            nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            tempScore = Math.min(CFG.core.getProv(nProvinceID).updateStability_Score_RevRisk() * 100.0f, 100.0f);
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RevolutionaryRisk") + ": "));
            nData.add(new ME_Hover_2Type_Text("-" + (tempScore != 0.0f ? String.format("%.1f", Float.valueOf(tempScore)).replace(',', '.') : Integer.valueOf((int)tempScore)) + "%", tempScore > 0.0f ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            tempScore = Math.min(CFG.core.getProv(nProvinceID).updateStability_Score_Happiness(), 100.0f);
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
            nData.add(new ME_Hover_2Type_Text((tempScore >= 0.0f ? "+" : "") + (tempScore != 0.0f ? String.format("%.1f", Float.valueOf(tempScore)).replace(',', '.') : Integer.valueOf((int)tempScore)) + "%", tempScore > 0.0f ? CFG.COLOR_POSITIVE : (tempScore < 0.0f ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL)));
            nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            tempScore = Math.min(CFG.core.getProv(nProvinceID).updateStability_Score_Occupied(), 100.0f);
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Occupied") + ": "));
            nData.add(new ME_Hover_2Type_Text("+" + (tempScore != 0.0f ? String.format("%.1f", Float.valueOf(tempScore)).replace(',', '.') : Integer.valueOf((int)tempScore)) + "%", tempScore > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            tempScore = Math.min(CFG.core.getProv(nProvinceID).updateStability_Score_Disease() * 100.0f, 100.0f);
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Disease") + ": "));
            nData.add(new ME_Hover_2Type_Text("-" + (tempScore != 0.0f ? String.format("%.1f", Float.valueOf(tempScore)).replace(',', '.') : Integer.valueOf((int)tempScore)) + "%", tempScore > 0.0f ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            return new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverProvince() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            if (CFG.ACTIVE_PROVINCE_INFO >= 0 && CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName().length() > 0) {
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ProvinceName") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName(), CFG.COLOR_HOVER_TITLE));
                if (CFG.FOG_OF_WAR == 2) {
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getMetCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()) ? CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() : -1, CFG.PADD, 0));
                } else {
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId(), CFG.PADD, 0));
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).isOccupied()) {
                    nData.add(new ME_Hover_2Type_Image_Big(Images.pattern, CFG.PADD, 0));
                    if (CFG.FOG_OF_WAR == 2) {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.getMetCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTrueOwnerOfProv()) ? CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTrueOwnerOfProv() : -1, CFG.PADD, 0));
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTrueOwnerOfProv(), CFG.PADD, 0));
                    }
                }
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).isOccupied()) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RightfulOwner") + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTrueOwnerOfProv()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTrueOwnerOfProv(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OccupiedBy") + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Continent") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.map.getMapContinents().getName(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getContinent()), CFG.map.getMapContinents().getColor(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getContinent())));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getMountainsSize() > 0) {
                    for (int i = 0; i < CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getMountainsSize(); ++i) {
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Mountain") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getMountain(i).getName() + " ", CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getMountain(i).getElevation() + "m / " + CFG.getMetersToFeet(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getMountain(i).getElevation()) + "ft", CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Image(Images.mount, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                }
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("StartingPopulation") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.startingPopulation), CFG.COLOR_POPULATION));
                nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, CFG.PADD));
                long difference = CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getPop().getPops() - CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.startingPopulation;
                nData.add(new ME_Hover_2Type_Text((difference > 0L ? "+" : "") + CFG.getNumberWthSpaces("" + difference), difference == 0L ? CFG.COLOR_NEUTRAL : (difference > 0L ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Text(" [" + (difference > 0L ? "+" : "") + CFG.getPercentage2Old(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getPop().getPops() - CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.startingPopulation, CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.startingPopulation, 100) + "%]", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("StartingEconomy") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.startingEconomy), CFG.COLOR_ECONOMY));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, CFG.PADD));
                difference = CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getEco() - CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.startingEconomy;
                nData.add(new ME_Hover_2Type_Text((difference > 0L ? "+" : "") + CFG.getNumberWthSpaces("" + difference), difference == 0L ? CFG.COLOR_NEUTRAL : (difference > 0L ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Text(" [" + (difference > 0L ? "+" : "") + CFG.getPercentage2Old(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getEco() - CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.startingEconomy, CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.startingEconomy, 100) + "%]", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                boolean showsRecruitedArmy = CFG.SPECTATOR_MODE || CFG.SANDBOX_MODE || CFG.FOG_OF_WAR < 1 || CFG.core.isAlly(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()) || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(CFG.ACTIVE_PROVINCE_INFO);
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalUnitsRecruitedFromProvince") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (showsRecruitedArmy ? CFG.getNumberWthSpaces("" + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iNumOfRecruitedArmyTotal) : "?"), CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                if (showsRecruitedArmy) {
                    nData.add(new ME_Hover_2Type_Text(" [" + CFG.getPercentage2Old(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iNumOfRecruitedArmyTotal, CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getPop().getPops() + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iNumOfRecruitedArmyTotal + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iPlaguesDeaths, 100) + "%]", CFG.COLOR_NEUTRAL));
                }
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalArmyCasualtiesInProvince") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.totalCasualtiesInProvince), CFG.COLOR_NEGATIVE_1));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.skull, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalNumberOfAllDiseasesInProvince") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iPlaguesDeaths), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.disease, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalDeathsDueToDiseases") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iPlaguesDeaths), CFG.COLOR_NEGATIVE_1));
                nData.add(new ME_Hover_2Type_Image(Images.disease, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.skull, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Text(" [" + CFG.getPercentage2Old(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iPlaguesDeaths, CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getPop().getPops() + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iNumOfRecruitedArmyTotal + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iPlaguesDeaths, 100) + "%]", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFort() > 0 || CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWatchTower() > 0 || CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfPort() > 0 || CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfLibrary() > 0 || CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFarm() > 0 || CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWorkshop() > 0 || CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfArmoury() > 0 || CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfSupply() > 0 || CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.wonderBuilt) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                try {
                    if (CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.wonderBuilt) {
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).getWonder((int)0).sName) + ": "));
                        nData.add(new ME_Hover_2Type_Text("+" + (int)(GameValues.gvWonder.GROWTH_RATE * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Wonder(CFG.ACTIVE_PROVINCE_INFO, 0, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFort() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFort_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFort())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bFort, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFort(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("HidesTheArmyFromTheSightOfViewOfWatchTower"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + BuildingsManager.getFort_DefenseBonus(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFort()) + "%", CFG.COLOR_POSITIVE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWatchTower() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getTower_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWatchTower())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bTower, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWatchTower(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllowsToSeeTheArmyInNeighboringProvinces"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + BuildingsManager.getTower_DefenseBonus(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWatchTower()) + "%", CFG.COLOR_POSITIVE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfPort() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getPort_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfPort())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bPort, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfPort(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllowsYourArmyGoToTheSea"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.icon_move_sea, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getPort_IncomeProduction(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfPort()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfLibrary() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getLibrary_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfLibrary())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bLibrary, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfLibrary(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("+1"), CFG.COLOR_RESEARCH));
                    nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchPerTurnForEveryXPeopleInProvince", BuildingsManager.getLibrary_ResearchPerPopulation(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfLibrary())), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFarm() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFarm_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFarm())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bFarm, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("GrowthRate") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getFarm_GrowthRateBonus(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFarm()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWorkshop() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getWorkshop_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWorkshop())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bWorkshop, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWorkshop(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getWorkshop_IncomeProduction(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWorkshop()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfArmoury() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getArmoury_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfArmoury())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bArmoury, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfArmoury(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ReducesTheCostOfRecruitmentPerUnitByOneGold"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfSupply() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getSupply_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfSupply())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bSupply, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfSupply(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                    nData.add(new ME_Hover_2Type_Text("-" + (int)(BuildingsManager.getSupply_Bonus(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfSupply()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCitSize() > 1) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (int a = CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCitSize() - 1; a >= 0; --a) {
                        nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCit(a).getCityName(), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCit(a).getCityLevel(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                }
            } else {
                return null;
            }
            return new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverProvinceOwner(int civID) {
        if (civID > 0) {
            try {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                if (CFG.ACTIVE_PROVINCE_INFO >= 0) {
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OpenCloseCivilizationInformationsView") + ".", CFG.COLOR_HOVER_TITLE));
                } else {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OpenCloseCivilizationInformationsView") + ".", CFG.COLOR_HOVER_TITLE));
                }
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.ACTIVE_PROVINCE_INFO >= 0) {
                    if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() > 0) {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getCivName()));
                        nData.add(new ME_Hover_2Type_Ideology_Big(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getIdeology(), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Religion_Big(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getReligionID(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).isOccupied()) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RightfulOwner") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTrueOwnerOfProv()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTrueOwnerOfProv(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OccupiedBy") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Religion") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.religionManager.getReligion((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).getCivId()).getReligionID()).Name, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Religion(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getReligionID(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Government") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getIdeology()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Ideology(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getIdeology(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getCivName()));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                }
                if (CFG.getIsDesktop()) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F2, TAB", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                return new ME_Hover_v2(nElements);
            }
            catch (Exception ex) {
                return null;
            }
        }
        if (civID == 0) {
            try {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                if (CFG.ACTIVE_PROVINCE_INFO >= 0) {
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OpenCloseCivilizationInformationsView") + ".", CFG.COLOR_HOVER_TITLE));
                } else {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OpenCloseCivilizationInformationsView") + ".", CFG.COLOR_HOVER_TITLE));
                }
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getCivName()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.getIsDesktop()) {
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F2, TAB", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                return new ME_Hover_v2(nElements);
            }
            catch (Exception ex) {
                return null;
            }
        }
        if (civID == -1) {
            try {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Terrain(0));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Sea"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                return new ME_Hover_v2(nElements);
            }
            catch (Exception ex) {
                return null;
            }
        }
        if (civID == -2) {
            try {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Image(Images.randomCivilizationFlag));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                return new ME_Hover_v2(nElements);
            }
            catch (Exception ex) {
                return null;
            }
        }
        if (civID == -3) {
            try {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Image(Images.randomCivilizationFlag));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("UndiscoveredProvince"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                return new ME_Hover_v2(nElements);
            }
            catch (Exception ex) {
                return null;
            }
        }
        return null;
    }

    public static ME_Hover_v2 getHoverCores() {
        try {
            int i;
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("CoreIsALegitimatePartOfCivilization"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Image_Big(Images.core, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Cores") + ":", CFG.COLOR_HOVER_TITLE));
            if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getCivsSize() > 0) {
                for (i = 0; i < CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getCivsSize(); ++i) {
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getCivID(i), CFG.PADD, 0));
                }
            } else {
                nData.add(new ME_Hover_2Type_Flag_Big(-1, CFG.PADD, 0));
            }
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getCivsSize() > 0) {
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                for (i = 0; i < CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getCivsSize(); ++i) {
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getCivID(i)));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getCivID(i)).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Religion_Big(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getCivID(i)).getReligionID(), CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(GameCalendar.getDate_ByTurnID(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getSinceTurnID(i)), CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("Turn") + ": " + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getSinceTurnID(i) + "]", CFG.COLOR_TEXT_RANK_HOVER));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                for (i = 0; i < CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_CivsSize(); ++i) {
                    if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getHaveACore(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_CivID(i))) continue;
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_CivID(i)));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("CoreConstruction") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big("" + Math.min((int)((float)CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_NumOfTurns(i) / (float)CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getNumOfTurnsOwnershipToGetACore() * 100.0f), 99) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Text_Big(" " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + Math.max(1, CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getNumOfTurnsOwnershipToGetACore() - CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_NumOfTurns(i))), CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", Math.max(1, CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getNumOfTurnsOwnershipToGetACore() - CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_NumOfTurns(i))) + "]", CFG.COLOR_TEXT_RANK_HOVER));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            } else if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_CivsSize() > 0) {
                for (i = 0; i < CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_CivsSize(); ++i) {
                    if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getHaveACore(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_CivID(i))) continue;
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_CivID(i)));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("CoreConstruction") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big("" + Math.min((int)((float)CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_NumOfTurns(i) / (float)CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getNumOfTurnsOwnershipToGetACore() * 100.0f), 99) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Text_Big(" " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + Math.max(1, CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getNumOfTurnsOwnershipToGetACore() - CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_NumOfTurns(i))), CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", Math.max(1, CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getNumOfTurnsOwnershipToGetACore() - CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_NumOfTurns(i))) + "]", CFG.COLOR_TEXT_RANK_HOVER));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            }
            Province_Claims claims = CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getClaims();
            if (claims != null && claims.getCivsSize() > 0) {
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Claims") + ":", CFG.COLOR_HOVER_TITLE));
                for (int ci = 0; ci < claims.getCivsSize(); ++ci) {
                    nData.add(new ME_Hover_2Type_Flag_Big(claims.getCivID(ci), CFG.PADD, 0));
                }
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                for (int ci = 0; ci < claims.getCivsSize(); ++ci) {
                    nData.add(new ME_Hover_2Type_Flag_Big(claims.getCivID(ci)));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(claims.getCivID(ci)).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Religion_Big(CFG.core.getCiv(claims.getCivID(ci)).getReligionID(), CFG.PADD, CFG.PADD));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            }
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverPopulation() {
        return Menu_InGame_ProvInfo.getHoverPopulation(CFG.ACTIVE_PROVINCE_INFO);
    }

    public static final ME_Hover_v2 getHoverPopulation(int nProvinceID) {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            if (nProvinceID >= 0) {
                int i;
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Population") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + CFG.core.getProv(nProvinceID).getPop().getPops()), CFG.COLOR_POPULATION));
                nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(nProvinceID).getName(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(nProvinceID).getCivId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("StartingPopulation") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv((int)nProvinceID).provGD.startingPopulation), CFG.COLOR_POPULATION));
                nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, CFG.PADD));
                long difference = CFG.core.getProv(nProvinceID).getPop().getPops() - CFG.core.getProv((int)nProvinceID).provGD.startingPopulation;
                nData.add(new ME_Hover_2Type_Text((difference > 0L ? "+" : "") + CFG.getNumberWthSpaces("" + difference), difference == 0L ? CFG.COLOR_NEUTRAL : (difference > 0L ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Text(" [" + (difference > 0L ? "+" : "") + CFG.getPercentage2Old(CFG.core.getProv(nProvinceID).getPop().getPops() - CFG.core.getProv((int)nProvinceID).provGD.startingPopulation, CFG.core.getProv((int)nProvinceID).provGD.startingPopulation, 100) + "%]", CFG.COLOR_NEUTRAL));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                ArrayList<Integer> tSortedCivs = new ArrayList<Integer>();
                ArrayList<Integer> tSortedPop = new ArrayList<Integer>();
                for (i = 0; i < CFG.core.getProv(nProvinceID).getPop().getNatsSize(); ++i) {
                    tSortedCivs.add(CFG.core.getProv(nProvinceID).getPop().getCivID(i));
                    tSortedPop.add((int)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i));
                }
                for (i = 0; i < tSortedCivs.size() - 1; ++i) {
                    for (int j = i + 1; j < tSortedCivs.size(); ++j) {
                        if ((Integer)tSortedPop.get(i) >= (Integer)tSortedPop.get(j)) continue;
                        int tempD = (Integer)tSortedCivs.get(i);
                        tSortedCivs.set(i, (Integer)tSortedCivs.get(j));
                        tSortedCivs.set(j, tempD);
                        tempD = (Integer)tSortedPop.get(i);
                        tSortedPop.set(i, (Integer)tSortedPop.get(j));
                        tSortedPop.set(j, tempD);
                    }
                }
                if (CFG.FOG_OF_WAR == 2) {
                    for (i = 0; i < tSortedCivs.size(); ++i) {
                        nData.add(new ME_Hover_2Type_Flag(CFG.getMetCiv((Integer)tSortedCivs.get(i)) ? (Integer)tSortedCivs.get(i) : -(i + 1)));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tSortedPop.get(i)), CFG.COLOR_POPULATION));
                        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, CFG.PADD));
                        if (CFG.getMetCiv((Integer)tSortedCivs.get(i))) {
                            nData.add(new ME_Hover_2Type_Religion(CFG.core.getCiv((Integer)tSortedCivs.get(i)).getReligionID(), 0, CFG.PADD));
                        }
                        nData.add(new ME_Hover_2Type_Text("[" + CFG.getPercentageOld((Integer)tSortedPop.get(i), CFG.core.getProv(nProvinceID).getPop().getPops(), 5) + "%]", CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text(" " + (CFG.getMetCiv((Integer)tSortedCivs.get(i)) ? CFG.core.getCiv((Integer)tSortedCivs.get(i)).getCivName() : CFG.lang.get("Undiscovered")), CFG.COLOR_TEXT_RANK_HOVER));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                } else {
                    for (i = 0; i < tSortedCivs.size(); ++i) {
                        nData.add(new ME_Hover_2Type_Flag((Integer)tSortedCivs.get(i)));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tSortedPop.get(i)), CFG.COLOR_POPULATION));
                        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Religion(CFG.core.getCiv((Integer)tSortedCivs.get(i)).getReligionID(), 0, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text("[" + CFG.getPercentageOld((Integer)tSortedPop.get(i), CFG.core.getProv(nProvinceID).getPop().getPops(), 5) + "%]", CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text(" " + CFG.core.getCiv((Integer)tSortedCivs.get(i)).getCivName(), CFG.COLOR_TEXT_RANK_HOVER));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                }
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                try {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RecruitablePopulation") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.gameAction.gMARY(nProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Text(" [" + CFG.getPercentageOld(CFG.gameAction.gMARY(nProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), CFG.core.getProv(nProvinceID).getPop().getPops(), 5) + "%]", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                catch (Exception i2) {
                    // empty catch block
                }
                try {
                    boolean showsRecruitedArmy = CFG.SPECTATOR_MODE || CFG.SANDBOX_MODE || CFG.FOG_OF_WAR < 1 || CFG.core.isAlly(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getProv(nProvinceID).getCivId()) || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(nProvinceID);

                    nData.add(new ME_Hover_2Type_Text("" + (showsRecruitedArmy ? CFG.getNumberWthSpaces("" + CFG.core.getProv((int)nProvinceID).provGD.iNumOfRecruitedArmyTotal) : "?"), CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                    if (showsRecruitedArmy) {
                        nData.add(new ME_Hover_2Type_Text(" [" + CFG.getPercentageOld(CFG.core.getProv((int)nProvinceID).provGD.iNumOfRecruitedArmyTotal, CFG.core.getProv(nProvinceID).getPop().getPops() + CFG.core.getProv((int)nProvinceID).provGD.iNumOfRecruitedArmyTotal + CFG.core.getProv((int)nProvinceID).provGD.iPlaguesDeaths, 5) + "%]", CFG.COLOR_NEUTRAL));
                    }
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalArmyCasualtiesInProvince") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv((int)nProvinceID).provGD.totalCasualtiesInProvince), CFG.COLOR_NEGATIVE_1));
                    nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Image(Images.skull, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalNumberOfAllDiseasesInProvince") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv((int)nProvinceID).provGD.iPlaguesDeaths), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.disease, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TotalDeathsDueToDiseases") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv((int)nProvinceID).provGD.iPlaguesDeaths), CFG.COLOR_NEGATIVE_1));
                    nData.add(new ME_Hover_2Type_Image(Images.disease, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Image(Images.skull, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Text(" [" + CFG.getPercentageOld(CFG.core.getProv((int)nProvinceID).provGD.iPlaguesDeaths, CFG.core.getProv(nProvinceID).getPop().getPops() + CFG.core.getProv((int)nProvinceID).provGD.iNumOfRecruitedArmyTotal + CFG.core.getProv((int)nProvinceID).provGD.iPlaguesDeaths, 5) + "%]", CFG.COLOR_NEUTRAL));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                catch (Exception exception) {}
            } else {
                return null;
            }
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverEconomy() {
        return Menu_InGame_ProvInfo.getHoverEconomy(CFG.ACTIVE_PROVINCE_INFO);
    }

    public static final ME_Hover_v2 getHoverEconomy(int nProvinceID) {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            if (nProvinceID < 0) {
                return null;
            }
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Economy") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + CFG.core.getProv(nProvinceID).getEco()), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(nProvinceID).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(nProvinceID).getCivId(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MaximumEconomy") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getMaxProvEconomy(nProvinceID)), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.getPrecision2((float)CFG.core.getProv(nProvinceID).getEco() / CFG.gameUpdate.getMaxProvEconomy(nProvinceID) * 100.0f, 100), CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Text_Big("%]", CFG.COLOR_NEUTRAL));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("StartingEconomy") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv((int)nProvinceID).provGD.startingEconomy), CFG.COLOR_ECONOMY));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, CFG.PADD));
            long difference = CFG.core.getProv(nProvinceID).getEco() - CFG.core.getProv((int)nProvinceID).provGD.startingEconomy;
            nData.add(new ME_Hover_2Type_Text((difference > 0L ? "+" : "") + CFG.getNumberWthSpaces("" + difference), difference == 0L ? CFG.COLOR_NEUTRAL : (difference > 0L ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Text(" [" + (difference > 0L ? "+" : "") + CFG.getPercentage2Old(CFG.core.getProv(nProvinceID).getEco() - CFG.core.getProv((int)nProvinceID).provGD.startingEconomy, CFG.core.getProv((int)nProvinceID).provGD.startingEconomy, 100) + "%]", CFG.COLOR_NEUTRAL));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DevelopmentLevel") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + String.format("%.4f", Float.valueOf(CFG.core.getProv(nProvinceID).getDeveLvl())).replace(',', '.'), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Text(" / " + (float)((int)(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Max") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, CFG.PADD));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(nProvinceID).getCivId()));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyLevel") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() * 100.0f)) / 100.0f + " / " + GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL, CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDeveLvl() >= 0.4f) {
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("Missile Interception Chance: ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text("50% (T1)", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverProvinceValue(String text) {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            if (CFG.ACTIVE_PROVINCE_INFO >= 0) {
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ProvinceValue") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text_Big(text, CFG.COLOR_PROVINCE_VALUE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.victoryPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BaseProvinceValue") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + GameValues.gvProvinceValue.BASE_PROVINCE_VALUE, CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.core.getProvinceValue_Capital(CFG.ACTIVE_PROVINCE_INFO) > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Capital") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.core.getProvinceValue_Capital(CFG.ACTIVE_PROVINCE_INFO), CFG.COLOR_POSITIVE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProvinceValue_PopulationGrowthRate(CFG.ACTIVE_PROVINCE_INFO) > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("GrowthRate") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.core.getProvinceValue_PopulationGrowthRate(CFG.ACTIVE_PROVINCE_INFO), CFG.COLOR_POSITIVE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProvinceValue_DevelopmentLevel(CFG.ACTIVE_PROVINCE_INFO) > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DevelopmentLevel") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.core.getProvinceValue_DevelopmentLevel(CFG.ACTIVE_PROVINCE_INFO), CFG.COLOR_POSITIVE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProvinceValue_Terrain(CFG.ACTIVE_PROVINCE_INFO) > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.terrainTypesManager.getName(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTerrainTypeID()) + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + CFG.core.getProvinceValue_Terrain(CFG.ACTIVE_PROVINCE_INFO), CFG.COLOR_POSITIVE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            } else {
                return null;
            }
            return new ME_Hover_v2(nElements);
        }
        catch (Exception ex) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverGrowthRate() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ProvinceGrowthRate") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big("" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getGrowthRate_Pop() * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image_Big(Images.popGrowth, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            try {
                if (CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.wonderBuilt) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).getWonder((int)0).sName) + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + (int)(GameValues.gvWonder.GROWTH_RATE * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Wonder(CFG.ACTIVE_PROVINCE_INFO, 0, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (BuildingsManager.getFarm_GrowthRateBonus(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFarm()) > 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Farm") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getFarm_GrowthRateBonus(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFarm()) * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.bFarm, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.terrainTypesManager.getPopulationGrowth(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTerrainTypeID()) > 0.0f) {
                nData.add(new ME_Hover_2Type_Color(CFG.terrainTypesManager.getColor(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTerrainTypeID()), 0, 0));
                nData.add(new ME_Hover_2Type_Terrain(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTerrainTypeID(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.terrainTypesManager.getName(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTerrainTypeID()) + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + (int)(CFG.terrainTypesManager.getPopulationGrowth(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTerrainTypeID()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            } else if (CFG.terrainTypesManager.getPopulationGrowth(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTerrainTypeID()) < 0.0f) {
                nData.add(new ME_Hover_2Type_Color(CFG.terrainTypesManager.getColor(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTerrainTypeID()), 0, 0));
                nData.add(new ME_Hover_2Type_Terrain(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTerrainTypeID(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(CFG.terrainTypesManager.getName(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTerrainTypeID()) + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.terrainTypesManager.getPopulationGrowth(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTerrainTypeID()) * 100.0f) + "%", CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getGrowthRate_NewColony() > 0.0f) {
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("NewColony") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getGrowthRate_NewColony() * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.city, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("[" + CFG.lang.get("TurnsX", CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iNewColonyBonus) + "]", CFG.COLOR_NEUTRAL));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverDevelopment() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DevelopmentLevel") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big("" + String.format("%.4f", Float.valueOf(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDeveLvl())).replace(',', '.'), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image_Big(Images.development, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Text_Big(" / " + (float)((int)(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Max") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, CFG.PADD));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyLevel") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getTechLevel() * 100.0f)) / 100.0f + " / " + GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL, CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDeveLvl() >= 0.4f) {
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("Missile Interception Chance: ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text("50% (T1)", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverHappiness(int happinessIMG) {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Happiness") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getPrecision2(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getHappi() * 100.0f, 100) + "%", CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image_Big(Images.happiness, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverFestival() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Festival"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId(), CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Image_Big(Images.diploFestival, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID - GameValues.gvFestival.FESTIVAL_NUM_OF_TURNS + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isFestivalOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO))));
            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isFestivalOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO))));
            nData.add(new ME_Hover_2Type_Text(" [" + CFG.lang.get("TurnsX", CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isFestivalOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO)) + "]", CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
            nData.add(new ME_Hover_2Type_Text("+" + (float)((int)(Festival.festivalHappinessPerTurn(CFG.ACTIVE_PROVINCE_INFO) * 10000.0f)) / 100.0f, CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.happiness, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PerTurn"), CFG.COLOR_NEUTRAL));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("NeighboringProvinces") + ": "));
            nData.add(new ME_Hover_2Type_Text("+" + (float)((int)(Festival.festivalHappinessPerTurn_NeighboringProvinces() * 10000.0f)) / 100.0f, CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.happiness, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PerTurn"), CFG.COLOR_NEUTRAL));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            return new ME_Hover_v2(nElements);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverBuildings() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            if (iBuildingsWidth > 0) {
                try {
                    if (CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.wonderBuilt) {
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).getWonder((int)0).sName) + ": "));
                        nData.add(new ME_Hover_2Type_Text("+" + (int)(GameValues.gvWonder.GROWTH_RATE * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Wonder(CFG.ACTIVE_PROVINCE_INFO, 0, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFort() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFort_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFort())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bFort, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFort(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("HidesTheArmyFromTheSightOfViewOfWatchTower"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + BuildingsManager.getFort_DefenseBonus(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFort()) + "%", CFG.COLOR_POSITIVE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWatchTower() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getTower_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWatchTower())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bTower, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWatchTower(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllowsToSeeTheArmyInNeighboringProvinces"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + BuildingsManager.getTower_DefenseBonus(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWatchTower()) + "%", CFG.COLOR_POSITIVE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfPort() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getPort_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfPort())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bPort, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfPort(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllowsYourArmyGoToTheSea"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.icon_move_sea, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getPort_IncomeProduction(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfPort()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfLibrary() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getLibrary_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfLibrary())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bLibrary, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfLibrary(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("+1"), CFG.COLOR_RESEARCH));
                    nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchPerTurnForEveryXPeopleInProvince", BuildingsManager.getLibrary_ResearchPerPopulation(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfLibrary())), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFarm() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFarm_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFarm())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bFarm, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFarm(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("GrowthRate") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getFarm_GrowthRateBonus(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfFarm()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWorkshop() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getWorkshop_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWorkshop())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bWorkshop, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWorkshop(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getWorkshop_IncomeProduction(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfWorkshop()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfMarket() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getMarket_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfMarket())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bMarket, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfMarket(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeTaxation") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getMarket_IncomeTaxation(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfMarket()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfArmoury() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getArmoury_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfArmoury())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bArmoury, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfArmoury(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ReducesTheCostOfRecruitmentPerUnitByOneGold"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfSupply() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getSupply_Name(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfSupply())), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.bSupply, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Level") + ": ", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfSupply(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(" - "));
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
                    nData.add(new ME_Hover_2Type_Text("-" + (int)(BuildingsManager.getSupply_Bonus(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getLvlOfSupply()) * 100.0f) + "%", CFG.COLOR_POSITIVE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            } else {
                return null;
            }
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverRevolutionaryRisk() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RevolutionaryRisk") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big("" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getRevRisk() * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image_Big(Images.diploRevolution, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            if (CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iSupportRebelsSize > 0) {
                int i;
                ArrayList<Integer> lCivs = new ArrayList<Integer>();
                ArrayList<Integer> lCivsTurnsLeft = new ArrayList<Integer>();
                ArrayList lSupportedByCivs = new ArrayList();
                int iCivsSize = 0;
                for (i = 0; i < CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iSupportRebelsSize; ++i) {
                    boolean wasAdded = false;
                    int tAddID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.lSupportRebels.get((int)i).iRebelsCivID) ? CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.lSupportRebels.get((int)i).iRebelsCivID : CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.lSupportRebels.get((int)i).iRebelsCivID * -1;
                    for (int j = lCivs.size() - 1; j >= 0; --j) {
                        if ((Integer)lCivs.get(j) != tAddID) continue;
                        wasAdded = true;
                        lCivsTurnsLeft.set(j, Math.max((Integer)lCivsTurnsLeft.get(j), CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.lSupportRebels.get((int)i).iTurnsLeft));
                        ((List)lSupportedByCivs.get(j)).add(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.lSupportRebels.get((int)i).iByCivID);
                        break;
                    }
                    if (wasAdded) continue;
                    lCivs.add(tAddID);
                    lCivsTurnsLeft.add(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.lSupportRebels.get((int)i).iTurnsLeft);
                    lSupportedByCivs.add(new ArrayList());
                    ((List)lSupportedByCivs.get(lSupportedByCivs.size() - 1)).add(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.lSupportRebels.get((int)i).iByCivID);
                    if (lCivs.size() >= 4) break;
                }
                iCivsSize = lCivs.size();
                nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()));
                nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Text(" - " + CFG.lang.get("SupportRebels"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploRevolution, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                for (i = 0; i < iCivsSize; ++i) {
                    nData.add(new ME_Hover_2Type_Flag((Integer)lCivs.get(i)));
                    nData.add(new ME_Hover_2Type_Text((Integer)lCivs.get(i) > 0 ? CFG.core.getCiv((Integer)lCivs.get(i)).getCivName() : CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                    for (int k = 0; k < ((List)lSupportedByCivs.get(i)).size() && k < 10; ++k) {
                        nData.add(new ME_Hover_2Type_Flag(CFG.SPECTATOR_MODE || CFG.core.isAlly(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), (Integer)((List)lSupportedByCivs.get(i)).get(k)) ? (Integer)((List)lSupportedByCivs.get(i)).get(k) : -((Integer)((List)lSupportedByCivs.get(i)).get(k)).intValue(), k == 0 ? CFG.PADD : 0, 0));
                    }
                    nData.add(new ME_Hover_2Type_Text(" " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + (Integer)lCivsTurnsLeft.get(i)), CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text(" [" + CFG.lang.get("TurnsX", (Integer)lCivsTurnsLeft.get(i)) + "]", CFG.COLOR_TEXT_RANK_HOVER));
                    nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            }
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverAssimilate() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Assimilate"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId(), CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Image_Big(Images.diploStability, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isAssimilateOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO))));
            nData.add(new ME_Hover_2Type_Text(" [" + CFG.lang.get("TurnsX", CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isAssimilateOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO)) + "]", CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PromoteOurTraditionsAndCulturesInThisProvince")));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("APercentageOfTheLocalsWillConvertToOurNationality")));
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ProvinceStabilityWillBeIncreased"), CFG.COLOR_POSITIVE));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverInvest() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Invest"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Image_Big(Images.economy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
            nData.add(new ME_Hover_2Type_Text("+" + CFG.getNumberWthSpaces("" + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_EconomyLeft(CFG.ACTIVE_PROVINCE_INFO)), CFG.COLOR_ECONOMY));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID - GameValues.gvInvestEconomy.INVEST_ECO_NUM_OF_TURNS + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO))));
            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO))));
            nData.add(new ME_Hover_2Type_Text(" [" + CFG.lang.get("TurnsX", CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO)) + "]", CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverInvestDev() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Invest"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Image_Big(Images.development, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Development") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Text("+" + String.format("%.4f", Float.valueOf(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_EconomyLeft_Development(CFG.ACTIVE_PROVINCE_INFO))).replace(',', '.'), CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID - GameValues.gvInvestEconomy.INVEST_ECO_NUM_OF_TURNS + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_TurnsLeft_Devel(CFG.ACTIVE_PROVINCE_INFO))));
            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_TurnsLeft_Devel(CFG.ACTIVE_PROVINCE_INFO))));
            nData.add(new ME_Hover_2Type_Text(" [" + CFG.lang.get("TurnsX", CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_TurnsLeft_Devel(CFG.ACTIVE_PROVINCE_INFO)) + "]", CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverNotSupplied() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ProvinceIsNotSupplied"), CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image_Big(Images.skull, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text_Big("" + CFG.lang.get("TurnsX", CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getIsNotSuppliedForXTurns()), CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image_Big(Images.time, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": "));
            nData.add(new ME_Hover_2Type_Text("-" + (int)(GameValues.gvProvinceNotSupplied.NOT_SUPPLIED_PROVINCE_DEFENSE_BONUS_DECAY_PER_TURN * 100.0f) + "% " + CFG.lang.get("PerTurn"), CFG.COLOR_NEGATIVE_2));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverDefensivePosition() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DefensivePosition") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big("" + CFG.lang.get("TurnsX", CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDefensivePosition()), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Text_Big(" / " + CFG.lang.get("Max") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big("" + CFG.lang.get("TurnsX", GameValues.gvDefensivePosition.MAX_DEFENSIVE_POSITION), CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Image_Big(Images.time, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
            nData.add(new ME_Hover_2Type_Text("-" + Math.ceil((int)(CFG.gameUpdate.getMilitaryUpkeepDefensivePosition(CFG.ACTIVE_PROVINCE_INFO) * 1000.0f)) / 10.0 + "%", CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverDisease() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Name") + ": "));
            nData.add(new ME_Hover_2Type_Text(CFG.plagueManager.getPlague_InGame(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.provincePlague.iPlagueID_InGame).getPlagueName(), CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.disease, CFG.PADD, CFG.PADD));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Deaths") + ": "));
            nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.provincePlague.iDeaths), CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("OutbreakOfDisease") + ": "));
            nData.add(new ME_Hover_2Type_Text(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.plagueManager.getPlague_InGame(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.provincePlague.iPlagueID_InGame).getOutbreakProvinceID()) ? CFG.core.getProv(CFG.plagueManager.getPlague_InGame(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.provincePlague.iPlagueID_InGame).getOutbreakProvinceID()).getName() : CFG.lang.get("Undiscovered"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.plagueManager.getPlague_InGame(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.provincePlague.iPlagueID_InGame).getOutbreakProvinceID()) ? CFG.core.getProv(CFG.plagueManager.getPlague_InGame(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.provincePlague.iPlagueID_InGame).getOutbreakProvinceID()).getCivId() : -1, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()));
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Disease"), CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Text(" - ", Color.WHITE));
            nData.add(new ME_Hover_2Type_Text("" + GameCalendar.getDate_ByTurnID(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.provincePlague.iSinceTurnID), CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverNewColony() {
        try {
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("NewColony")));
            if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName().length() > 0) {
                nData.add(new ME_Hover_2Type_Text_Big(": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            }
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("GrowthRate") + ": "));
            nData.add(new ME_Hover_2Type_Text("+" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getGrowthRate_NewColony() * 100.0f) + "%", CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iNewColonyBonus) + " "));
            nData.add(new ME_Hover_2Type_Text("[" + CFG.lang.get("TurnsX", CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iNewColonyBonus) + "]", CFG.COLOR_NEUTRAL));
            nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static final ME_Hover_v2 getHoverProvinceConnections() {
        try {
            int i;
            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ProvinceName") + ": "));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName(), CFG.COLOR_HOVER_TITLE));
            if (CFG.FOG_OF_WAR == 2) {
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.getMetCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()) ? CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() : -1, CFG.PADD, 0));
            } else {
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId(), CFG.PADD, 0));
            }
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Continent") + ": "));
            nData.add(new ME_Hover_2Type_Text(CFG.map.getMapContinents().getName(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getContinent()), CFG.map.getMapContinents().getColor(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getContinent())));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getMountainsSize() > 0) {
                for (i = 0; i < CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getMountainsSize(); ++i) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Mountain") + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getMountain(i).getName() + " ", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getMountain(i).getElevation() + "m / " + CFG.getMetersToFeet(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getMountain(i).getElevation()) + "ft", CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Image(Images.mount, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            }
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            for (i = 0; i < CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvincesSize(); ++i) {
                nData.add(new ME_Hover_2Type_Terrain(CFG.core.getProv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvinces(i)).getTerrainTypeID()));
                if (CFG.core.getProv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvinces(i)).getName().length() == 0 && CFG.core.getProv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvinces(i)).getSeaProv()) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Sea")));
                } else {
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvinces(i)).getName()));
                }
                nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvinces(i)).getCivId(), CFG.PADD, 0));
                if (CFG.core.getProv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvinces(i)).getSeaProv()) {
                    nData.add(new ME_Hover_2Type_Image(Images.icon_move_sea, CFG.PADD, 0));
                } else if (CFG.core.isAlly(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getProv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvinces(i)).getCivId())) {
                    nData.add(new ME_Hover_2Type_Image(Images.icon_move_attack, CFG.PADD, 0));
                } else {
                    nData.add(new ME_Hover_2Type_Image(Images.icon_move_ally, CFG.PADD, 0));
                }
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            for (i = 0; i < CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighSeaProvincesSize(); ++i) {
                nData.add(new ME_Hover_2Type_Terrain(CFG.core.getProv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighSeaProvinces(i)).getTerrainTypeID()));
                if (CFG.core.getProv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighSeaProvinces(i)).getName().length() == 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Sea")));
                } else {
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighSeaProvinces(i)).getName()));
                }
                nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighSeaProvinces(i)).getCivId(), CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.icon_move_sea, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
            return new ME_Hover_v2(nElements);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public class Box {
        public int iProvinceName;
    }
}

