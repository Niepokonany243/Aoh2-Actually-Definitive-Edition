
package age.of.civilizations2.jakowski.lukasz.Menus.RandomGame;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.CNG.Button_CNG_Options;
import age.of.civilizations2.jakowski.lukasz.Button.CNG.Button_CNG_Options2;
import age.of.civilizations2.jakowski.lukasz.Button.CNG.Button_CNG_Options_Text2;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapScale;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Sliders.ZRest.Slider_CNG;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_RandomGame_Options
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;

    public Menu_RandomGame_Options() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tempMaxH = CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4) - (CFG.BUTTON_H + CFG.PADD * 2) - CFG.PADD;
        int tempElemH = CFG.BUTTON_H * 3 / 4;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_CNG_Options(null, CFG.PADD * 2 + CFG.map.getIcon(CFG.map.getActiveMapIDN()).getWidth(), 0, 0, tempW, tempElemH, true){

            @Override
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                oSB.setColor(Color.WHITE);
                CFG.map.getIcon(CFG.map.getActiveMapIDN()).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + Menu_RandomGame_Options.this.getMenuPosY() + this.getHeightE() / 2 - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getHeight() / 2);
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("LandProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countLandProvinces(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SeaProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countSeaProvinces(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AverageGrowthRateOfProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countAvarageGrowthRate() + "%", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 25, 0){

            @Override
            public String getDrawText() {
                return this.getTextE() + ": " + (int)((1.0f + (float)this.getCurr() * 0.1f) * 100.0f) + "%";
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefaultScaleOfMap") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options_Text2(null, CFG.lang.get("LandProvinces") + ": " + CFG.core.countLandProvinces_NotWasteland(), CFG.PADD * 2, 0, tempElemH * 2, tempW, tempElemH, true));
        menuElements.add(new Button_CNG_Options2(null, CFG.PADD * 2, 0, tempElemH * 3, tempW, tempElemH, true));
        menuElements.add(new Button_CNG_Options_Text2(null, CFG.lang.get("Civilizations") + ", " + CFG.lang.get("StartingPopulation") + ", " + CFG.lang.get("StartingEconomy"), CFG.PADD * 2, 0, tempElemH * 4, tempW, tempElemH, true));
        menuElements.add(new Button_CNG_Options_Text2(null, GameCalendar.getCurrDate(), CFG.PADD * 2, 0, tempElemH * 5, tempW, tempElemH, true));
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 6 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 9, CFG.DIFFICULTY * 2 + 1){

            @Override
            public String getDrawText() {
                return this.getTextE();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DifficultyLevel") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.getDifficultyName(CFG.DIFFICULTY)));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Beginner")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Normal")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Hard")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Extreme")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Legendary")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 7 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 5, CFG.FOG_OF_WAR * 2 + 1){

            @Override
            public String getDrawText() {
                return this.getTextE();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Fogofwar") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.getFogOfWarName(CFG.FOG_OF_WAR)));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Off") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TheWholeMapAndSoldiersAreVisibleAtAllTimes") + "."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Classic") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ProvinceOwnershipIsKnownButSoldiersCanOnlyBeSeenInAdjacentProvinces") + "."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Discovery") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TheWorldIsCoveredByFogCivilizationsMustBeDiscoveredBeforeTheyCanBeInteractedWith") + "."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options(null, CFG.PADD * 2, 0, tempElemH * 9, tempW, tempElemH, true, CFG.RANDOM_PLACEMENT){

            @Override
            public boolean getCheckboxSt() {
                return CFG.RANDOM_PLACEMENT;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PlacesCapitalsInRandomProvinces") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2(null, CFG.PADD * 2, 0, tempElemH * 10, tempW, tempElemH, true, CFG.RANDOM_FILL){

            @Override
            public boolean getCheckboxSt() {
                return CFG.RANDOM_FILL;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RandomnlyFillsTheWorldWithDifferentCivilizations") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2(null, CFG.PADD * 2, 0, tempElemH * 11, tempW, tempElemH, true, CFG.SANDBOX_MODE){

            @Override
            public boolean getCheckboxSt() {
                return CFG.SANDBOX_MODE;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SandboxMode"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("WinXGamesToUnlockSandboxMode", 0) + "."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options(null, CFG.PADD * 2, 0, tempElemH * 12, tempW, tempElemH, true, CFG.SPECTATOR_MODE){

            @Override
            public boolean getCheckboxSt() {
                return CFG.SPECTATOR_MODE;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ObserveCivilizationsAndTheirStruggleForSupremacy") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options(null, CFG.PADD * 2, 0, tempElemH * 13, tempW, tempElemH, true, GameCalendar.ENABLE_COLONIZATION){

            @Override
            public boolean getCheckboxSt() {
                return GameCalendar.ENABLE_COLONIZATION;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Enable") + "/" + CFG.lang.get("Disable") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(" " + CFG.lang.get("ColonizationofWastelandProvinces") + "."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options(null, CFG.PADD * 2, 0, tempElemH * 14, tempW, tempElemH, true, GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES){

            @Override
            public boolean getCheckboxSt() {
                return GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES;
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Enable") + "/" + CFG.lang.get("Disable") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ColonizationofNeutralProvinces") + "."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 8 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, (int)(GameCalendar.GAME_SPEED_MIN * 10.0f), (int)(GameCalendar.GAME_SPEED_MAX * 10.0f), (int)(GameCalendar.GAME_SPEED * 10.0f)){

            @Override
            public String getDrawText() {
                return this.getTextE() + this.getCurr() * 10 + "%";
            }
        });
        this.initMenu(new TitleM(null, CFG.BUTTON_H * 3 / 4, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_RandomGame_Options.this.getPosX() + iTranslateX, Menu_RandomGame_Options.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_RandomGame_Options.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.011f, 0.014f, 0.019f, 0.25f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_RandomGame_Options.this.getPosX() + iTranslateX, Menu_RandomGame_Options.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightT() * 3 / 4, Menu_RandomGame_Options.this.getWidthM(), this.getHeightT() * 3 / 4, false, true);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_RandomGame_Options.this.getPosX() + iTranslateX, Menu_RandomGame_Options.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_RandomGame_Options.this.getWidthM(), 1);
                if (AoCGame.LEFT != 0) {
                    oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
                    IMGManager.getIMG(Images.pix255).draw2O(oSB, Menu_RandomGame_Options.this.getPosX() + iTranslateX, Menu_RandomGame_Options.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - this.getHeightT(), 1, this.getHeightT(), true, false);
                    oSB.setColor(Color.WHITE);
                }
                oSB.setColor(Color.WHITE);
                CFG.fontMain.get(0).getData().setScale(0.8f);
                CFG.drawTextDefault(oSB, this.getText(), nPosX + nWidth / 2 - (int)((float)this.getTextWidth() * 0.8f / 2.0f) + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - (int)((float)this.getTextHeight() * 0.8f / 2.0f), CFG.COLOR_TEXT_GRAY_LEFT_NS);
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        }, 0 + AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempW, tempMaxH < tempElemH * menuElements.size() ? tempMaxH : tempElemH * menuElements.size(), menuElements);
        this.setVisibleM(true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        if (CFG.SANDBOX_MODE) {
            CFG.FOG_OF_WAR = 0;
            this.getMenuElem(7).setCurr(1);
        }
        this.getTitleM().setText(CFG.lang.get("RandomGame"));
        this.getMenuElem(0).setTextE(CFG.lang.get("MapType") + ": " + CFG.map.getMapName(CFG.map.getActiveMapIDN()));
        this.getMenuElem(1).setTextE(CFG.lang.get("ScaleOfMap"));
        this.getMenuElem(2).setTextE(CFG.lang.get("CustomizeWasteland"));
        this.getMenuElem(3).setTextE(CFG.lang.get("Players"));
        this.getMenuElem(4).setTextE(CFG.lang.get("Settings"));
        this.getMenuElem(5).setTextE(CFG.lang.get("Date"));
        this.getMenuElem(6).setTextE(CFG.lang.get("Difficulty") + ": " + CFG.getDifficultyName(CFG.DIFFICULTY));
        this.getMenuElem(7).setTextE(CFG.lang.get("Fogofwar") + ": " + CFG.getFogOfWarName(CFG.FOG_OF_WAR));
        this.getMenuElem(8).setTextE(CFG.lang.get("RandomPlacement"));
        this.getMenuElem(9).setTextE(CFG.lang.get("RandomFill"));
        this.getMenuElem(10).setTextE(CFG.lang.get("Sandbox"));
        this.getMenuElem(11).setTextE(CFG.lang.get("SpectatorMode"));
        this.getMenuElem(12).setTextE(CFG.lang.get("ColonizationofWastelandProvinces"));
        this.getMenuElem(13).setTextE(CFG.lang.get("NeutralProvinces") + ": " + (GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES ? CFG.lang.get("Colonization") : CFG.lang.get("Conquering")));
        this.getMenuElem(14).setTextE(CFG.lang.get("GameSpeed") + ": ");
        this.getMenuElem(7).setVisibleE(!CFG.SANDBOX_MODE);
        this.getMenuElem(7).setClickable(!CFG.SANDBOX_MODE);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            iTranslateX = hideAnimation ? (iTranslateX -= (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))) : (iTranslateX += -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME)));
            CFG.setRenderO(true);
        } else if (hideAnimation) {
            super.setVisibleM(false);
            return;
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2 + Core.PADDING, this.getHeightM(), true, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM(), this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM(), this.getWidthM(), 1);

        if (AoCGame.LEFT != 0) {
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM(), true, true);
            oSB.setColor(Color.WHITE);
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if ((sliderMenuIsActive || this.getScrollModeY()) && !CFG.menus.getSliderMode()) {
            super.drawScrollPos(oSB, iTranslateX - 2, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.backToMenu = View.eCREATE_RANDOM_GAME;
                CFG.menus.setMenuID(View.eSELECT_MAP_TYPE);
                break;
            }
            case 1: {
                MapScale.STANDARD_SCALE = 1.0f + (float)this.getMenuElem(iID).getCurr() * 0.1f;
                CFG.map.getMpS().setCurrScale(MapScale.STANDARD_SCALE);
                CFG.map.getMpS().setScaleBeforeReset(MapScale.STANDARD_SCALE >= 3.0f ? 2.0f : (MapScale.STANDARD_SCALE > 1.0f ? 1.0f : 0.5f));
                break;
            }
            case 2: {
                CFG.menus.setVisible_CreateRandomGame_Options(false);
                CFG.menus.setVisible_CreateRandomGame_WastelandMaps(true);
                CFG.menus.setVisible_CreateRandomGame_Setings(false);
                CFG.map.getMpSl().stopScrollingTheMap();
                CFG.map.getMpS().setCurrScale(MapScale.MINSCALE);
                CFG.map.getMpC().setNewPosX(-((int)((float)(CFG.map.getMpB().getWidthM() / 2) - (float)CFG.GAMEWIDTH / MapScale.MINSCALE / 2.0f)));
                CFG.map.getMpC().setNewPosY(-((int)((float)(CFG.map.getMpB().getHeightM() / 2) - (float)CFG.GAMEHEIGHT / MapScale.MINSCALE / 2.0f)));
                break;
            }
            case 3: {
                CFG.menus.setVisible_CreateRandomGame_Players(!CFG.menus.getVisible_CreateRandomGame_Players());
                break;
            }
            case 4: {
                CFG.menus.setVisible_CreateRandomGame_Setings(!CFG.menus.getVisible_CreateRandomGame_Settings());
                break;
            }
            case 5: {
                CFG.backToMenu = View.eCREATE_RANDOM_GAME;
                CFG.menus.setMenuID(View.eSCENARIO_AGE);
                CFG.menus.updateSelecetScenarioAge_Slider();
                break;
            }
            case 6: {
                if (CFG.DIFFICULTY == this.getMenuElem(iID).getCurr() / 2) break;
                CFG.DIFFICULTY = this.getMenuElem(iID).getCurr() / 2;
                this.getMenuElem(iID).setTextE(CFG.lang.get("Difficulty") + ": " + CFG.getDifficultyName(CFG.DIFFICULTY));
                break;
            }
            case 7: {
                if (CFG.SANDBOX_MODE) break;
                if (CFG.FOG_OF_WAR == this.getMenuElem(iID).getCurr() / 2) break;
                CFG.FOG_OF_WAR = this.getMenuElem(iID).getCurr() / 2;
                this.getMenuElem(iID).setTextE(CFG.lang.get("Fogofwar") + ": " + CFG.getFogOfWarName(CFG.FOG_OF_WAR));
                break;
            }
            case 8: {
                CFG.RANDOM_PLACEMENT = !CFG.RANDOM_PLACEMENT;
                this.getMenuElem(iID).setCheckboxSt(CFG.RANDOM_PLACEMENT);
                break;
            }
            case 9: {
                CFG.RANDOM_FILL = !CFG.RANDOM_FILL;
                this.getMenuElem(iID).setCheckboxSt(CFG.RANDOM_FILL);
                break;
            }
            case 10: {
                CFG.SANDBOX_MODE = !CFG.SANDBOX_MODE;
                if (CFG.SANDBOX_MODE) {
                    CFG.FOG_OF_WAR = 0;
                    this.getMenuElem(7).setCurr(1);
                }
                this.getMenuElem(7).setVisibleE(!CFG.SANDBOX_MODE);
                this.getMenuElem(7).setClickable(!CFG.SANDBOX_MODE);
                this.getMenuElem(7).setTextE(CFG.lang.get("Fogofwar") + ": " + CFG.getFogOfWarName(CFG.FOG_OF_WAR));
                this.getMenuElem(iID).setCheckboxSt(CFG.SANDBOX_MODE);
                break;
            }
            case 11: {
                CFG.SPECTATOR_MODE = !CFG.SPECTATOR_MODE;
                break;
            }
            case 12: {
                boolean bl = GameCalendar.ENABLE_COLONIZATION = !GameCalendar.ENABLE_COLONIZATION;
                if (GameCalendar.ENABLE_COLONIZATION) {
                    CFG.toastM.addM(CFG.lang.get("Colonization") + " - " + CFG.lang.get("Enabled"));
                    break;
                }
                CFG.toastM.addM(CFG.lang.get("Colonization") + " - " + CFG.lang.get("Disabled"));
                break;
            }
            case 13: {
                GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES = !GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES;
                this.updateLang();
                CFG.toastM.addM(this.getMenuElem(iID).getTextE());
            }
            case 14: {
                GameCalendar.GAME_SPEED = (float)this.getMenuElem(iID).getCurr() / 10.0f;
            }
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible) {
            super.setVisibleM(visible);
            this.setHideAnimation(false);
        } else {
            this.setHideAnimation(true);
        }
    }

    public final void setHideAnimation(boolean nHideAnimation) {
        if (nHideAnimation != hideAnimation) {
            lTime = lTime > System.currentTimeMillis() - (long)GameValues.gvInGame.MENUS_ANIMATION_TIME ? System.currentTimeMillis() - ((long)GameValues.gvInGame.MENUS_ANIMATION_TIME - (System.currentTimeMillis() - lTime)) : System.currentTimeMillis();
            CFG.setRenderO(true);
        }
        hideAnimation = nHideAnimation;
    }
}

