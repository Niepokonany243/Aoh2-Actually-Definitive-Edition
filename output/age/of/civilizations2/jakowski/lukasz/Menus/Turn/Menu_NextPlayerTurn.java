/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Turn;

import age.of.civilizations2.jakowski.lukasz.Button.Button_Transparent;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag_JustFrame;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_GraphMain;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Menu_InGame_Messages;
import age.of.civilizations2.jakowski.lukasz.Menus.ProvinceM.More.Menu_InGame_Province_More;
import age.of.civilizations2.jakowski.lukasz.Menus.Stats.Menu_InGame_CensusOfProvince;
import age.of.civilizations2.jakowski.lukasz.Menus.Wars.Details.Menu_InGame_WarDetails;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_NextPlayerTurn
extends Menu {
    public static float SCALE_BEFORE_NEXT_PLAYER_MENU = 1.0f;
    private String sPlayer;
    private static String worldsProvinces = "";
    private static long lTime = 0L;
    private static final int ANIMATION_TIME = 3000;
    public static boolean lockExtraAction = false;

    public Menu_NextPlayerTurn() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Flag_JustFrame(CFG.CIV_FLAG_WIDTH / 2, CFG.GAMEHEIGHT / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Hide"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Transparent(0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, true));
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, CFG.GAMEHEIGHT, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.sPlayer = CFG.lang.get("Player");
    }

    public static final void updateData() {
        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() > 0 && !CFG.SPECTATOR_MODE) {
            if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs() > 0) {
                worldsProvinces = CFG.lang.get("XOfAllProvines", "" + CFG.getPercentageOld(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs(), CFG.core.countLandProvinces_NotWasteland(), 4));
                lTime = System.currentTimeMillis();
            } else {
                worldsProvinces = "";
                lTime = 0L;
            }
        } else {
            worldsProvinces = "";
            lTime = 0L;
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H / 2);
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, CFG.GAMEHEIGHT - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, CFG.GAMEWIDTH, CFG.BUTTON_H / 2, false, true);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.125f));
        IMGManager.getIMG(Images.gameLogo).drawO(oSB, this.getPosX() + this.getWidthM() - CFG.PADD - IMGManager.getIMG(Images.gameLogo).getWidth() + iTranslateX, this.getPosY() + this.getHeightM() - CFG.PADD - IMGManager.getIMG(Images.gameLogo).getHeight());
        if (this.getMenuElem(0).getVisibleE()) {
            CFG.glyphLay.setText(CFG.fontMain.get(0), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName());
            int iCivNameWidth = (int)CFG.glyphLay.width;
            oSB.setColor(CFG.COLOR_GRADIENT_DARK_BLUE);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() / 2 - CFG.BUTTON_H - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, iCivNameWidth + IMGManager.getIMG(Images.topFlagFrame).getWidth() + CFG.CIV_FLAG_WIDTH + CFG.PADD * 2, CFG.BUTTON_H * 2);
            oSB.setColor(CFG.COLOR_FLAG_FRAME);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + 1 + this.getHeightM() / 2 - CFG.BUTTON_H - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, iCivNameWidth + IMGManager.getIMG(Images.topFlagFrame).getWidth() + CFG.CIV_FLAG_WIDTH + CFG.PADD * 2, 1);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - 2 + this.getHeightM() / 2 + CFG.BUTTON_H - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, iCivNameWidth + IMGManager.getIMG(Images.topFlagFrame).getWidth() + CFG.CIV_FLAG_WIDTH + CFG.PADD * 2, 1);
            oSB.setColor(Color.WHITE);
            CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFlag().drawO(oSB, this.getPosX() + CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getPosY() + this.getHeightM() / 2 - CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFlag().getHeight() - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight());
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            if (CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.leaderData != null && CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.leaderData.getName().length() > 0) {
                CFG.drawTextDefaultWithShadow(oSB, CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.leaderData.getName(), CFG.CIV_FLAG_WIDTH / 2 + IMGManager.getIMG(Images.topFlagFrame).getWidth() + CFG.PADD + iTranslateX, CFG.GAMEHEIGHT / 2 + CFG.PADD / 2, CFG.COLOR_TEXT_CIV_NAME);
            } else {
                CFG.drawTextDefaultWithShadow(oSB, this.sPlayer + " " + (CFG.PLAYER_TURN_ID + 1), CFG.CIV_FLAG_WIDTH / 2 + IMGManager.getIMG(Images.topFlagFrame).getWidth() + CFG.PADD + iTranslateX, CFG.GAMEHEIGHT / 2 + CFG.PADD / 2, CFG.COLOR_TEXT_CIV_NAME);
            }
            CFG.drawTextDefaultWithShadow(oSB, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.CIV_FLAG_WIDTH / 2 + IMGManager.getIMG(Images.topFlagFrame).getWidth() + CFG.PADD + iTranslateX, CFG.GAMEHEIGHT / 2 - CFG.TEXT_HEIGHT_DEFAULT - CFG.PADD / 2, CFG.COLOR_TEXT_RANK);
            if (lTime > System.currentTimeMillis() - 3000L) {
                CFG.fontMain.get(0).getData().setScale(0.8f);
                float tAlpha = 1.0f;
                if ((float)lTime <= (float)System.currentTimeMillis() - 2000.0f) {
                    tAlpha = 1.0f - ((float)(System.currentTimeMillis() - lTime) - 1000.0f) / 3000.0f * 2.0f / 3.0f;
                }
                CFG.drawTextDefault(oSB, worldsProvinces, CFG.PADD * 2 + iTranslateX, CFG.GAMEHEIGHT - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.8f) - CFG.PADD * 2, new Color(CFG.COLOR_TEXT_NUM_OF_PROVINCES.r, CFG.COLOR_TEXT_NUM_OF_PROVINCES.g, CFG.COLOR_TEXT_NUM_OF_PROVINCES.b, tAlpha));
                CFG.fontMain.get(0).getData().setScale(1.0f);
                CFG.setRenderO(true);
            }
        } else {
            oSB.setColor(Color.WHITE);
        }
    }

    public static final void clickBack() {
        RTS.resetTime();
        CFG.menus.setMenuID(View.eINGAME);
        CFG.map.getMpSl().stopScrollingTheMap();
        CFG.map.getMpB().updateWorldMap_Shaders();
        CFG.core.disableDrawCivilizationRegions(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        Menu_NextPlayerTurn.clickEnd();
        if (RTS.PAUSED_BY_NEXT_TURN) {
            RTS.PAUSE = false;
            RTS.resetTime();
            RTS.PAUSED_BY_NEXT_TURN = false;
        }
    }

    public static final void clickEnd_LoadPlayerData() {
        try {
            if (RTS.isEnabled() && !RTS.PAUSE) {
                if (!CFG.SPECTATOR_MODE || CFG.core.getActiveProvID() < 0) {
                    lockExtraAction = true;
                    CFG.core.setActiveProvID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_ActiveProvince);
                    lockExtraAction = false;
                } else {
                    lockExtraAction = true;
                    int oldActiveProvinceID = CFG.core.getActiveProvID();
                    CFG.core.setActiveProvID(-1);
                    CFG.core.setActiveProvID(oldActiveProvinceID);
                    lockExtraAction = false;
                }
            } else if (!CFG.SPECTATOR_MODE) {
                if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_PosY == -999999) {
                    CFG.map.getMpS().setCurrScale(SCALE_BEFORE_NEXT_PLAYER_MENU);
                    if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                        lockExtraAction = true;
                        CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                        lockExtraAction = false;
                    } else {
                        CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(0));
                        lockExtraAction = true;
                        CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getProvID(0));
                        lockExtraAction = false;
                    }
                } else {
                    if (CFG.gameAction.updatePosOfMap_NewTurn || CFG.gameAction.getNumOfPlayersInGame() > 1) {
                        CFG.map.getMpS().setCurrScale(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).fBefore_Scale);
                        CFG.map.getMpC().setStartingPosX(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_PosX);
                        CFG.map.getMpC().setStartingPosY(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_PosY);
                        CFG.map.getMpC().updateSecondSideOfMap();
                    }
                    if (!CFG.SPECTATOR_MODE || CFG.core.getActiveProvID() < 0) {
                        lockExtraAction = true;
                        CFG.core.setActiveProvID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_ActiveProvince);
                        lockExtraAction = false;
                    } else {
                        lockExtraAction = true;
                        int oldActiveProvinceID = CFG.core.getActiveProvID();
                        CFG.core.setActiveProvID(-1);
                        CFG.core.setActiveProvID(oldActiveProvinceID);
                        lockExtraAction = false;
                    }
                }
            } else if (!CFG.SPECTATOR_MODE || CFG.core.getActiveProvID() < 0) {
                lockExtraAction = true;
                CFG.core.setActiveProvID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_ActiveProvince);
                lockExtraAction = false;
            } else {
                lockExtraAction = true;
                int oldActiveProvinceID = CFG.core.getActiveProvID();
                CFG.core.setActiveProvID(-1);
                CFG.core.setActiveProvID(oldActiveProvinceID);
                lockExtraAction = false;
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_CivInfo >= 0 && GameValues.gvInGame.ENABLE_PLAYER_CIV_INFO_NEW_TURN) {
                CFG.setActiveCivInfoId(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_CivInfo);
                CFG.menus.setVisible_InGame_CivInfo(true);
            }
            CFG.menus.setVisible_Menu_InGame_Outliner(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_Outliner);
            CFG.menus.setVisibleInGame_MilitaryAlliances(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_Alliances);
            CFG.menus.setVisible_InGame_MapModes(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_MapModes);
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_History) {
                CFG.menus.rebuildInGame_History();
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_HRE) {
                CFG.menus.rebuildInGameHRE();
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_WorldPop) {
                CFG.menus.rebuildInGame_WorldPopulation();
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_CensusOfProvince >= 0) {
                CFG.menus.rebuildInGame_CensusOfProvince(Menu_InGame_CensusOfProvince.PROVINCE_ID);
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_Budget) {
                CFG.menus.setVisible_InGame_Budget(true);
                Menu_InGame_FA_GraphMain.lTime = 0L;
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_Alliance >= 0) {
                CFG.menus.rebuildInGame_Alliance(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_Alliance);
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_Rank) {
                CFG.menus.rebuildInGame_Rank();
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_ConqueredProvinces) {
                CFG.menus.rebuildInGame_ConqueredProvinces();
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_VictoryConditions) {
                CFG.menus.rebuildInGame_VictoryConditions();
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_BuildingsConstructed) {
                CFG.menus.rebuildInGame_BuildingsConstructed();
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_Stats) {
                CFG.menus.rebuildInGame_Stats();
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_RecruitedArmy) {
                CFG.menus.rebuildInGame_RecruitedArmy();
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_Tribute) {
                CFG.menus.rebuildInGame_Tribute();
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_Army) {
                CFG.menus.rebuildInGame_Army();
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_Wars) {
                CFG.menus.rebuildInGame_Wars();
            }
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_WarStats >= 0) {
                Menu_InGame_WarDetails.WAR_ID = CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_WarStats;
                CFG.menus.rebuildInGame_WarDetails();
            }
            CFG.mapModesManager.disableAllViews();
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE != MapModesManager.VIEW_DIPLOMACY_MODE || GameValues.gvInGame.ENABLE_DIPLOMACY_NEW_TURN) {
                CFG.mapModesManager.setActiveMapModeID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE);
            }
            CFG.core.checkProvinceActionMenu();
            BuildingsManager.iBuildInProvinceID = CFG.core.getActiveProvID();
            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_BuildingsMore) {
                if (Menu_InGame_Province_More.IN_BUILD_MENU) {
                    CFG.menus.setVisible_InGame_ProvinceMore(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_BuildingsMore, true);
                } else {
                    CFG.menus.setVisible_InGame_MoreAll(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).visible_BuildingsMore, true);
                }
            } else {
                CFG.menus.setVisible_InGame_ProvinceMore(false, false);
            }
            if (SaveGameManager.gameSaved) {
                SaveGameManager.gameSaved = false;
                CFG.menus.rebuildMenu_InGame_SavedGame();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            try {
                int oldActiveProvinceID = CFG.core.getActiveProvID();
                lockExtraAction = true;
                CFG.core.setActiveProvID(-1);
                CFG.core.setActiveProvID(oldActiveProvinceID);
                lockExtraAction = false;
            }
            catch (Exception ex2) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public static final void clickEnd() {
        int i;
        int i2;
        int j;
        Menu_NextPlayerTurn.clickEnd_LoadPlayerData();
        if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() > 0) {
            for (j = 0; j < CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilizationsSize(); ++j) {
                for (i2 = 0; i2 < CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilization(j)).moveUnitsSize(); ++i2) {
                    CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilization(j)).getMoveUnits(i2).getMoveUnits_Line().updateMoveTime();
                }
            }
        } else {
            for (i = 0; i < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).moveUnitsSize(); ++i) {
                CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMoveUnits(i).getMoveUnits_Line().updateMoveTime();
            }
        }
        for (i = 0; i < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMigrateSize(); ++i) {
            CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMigrateMU(i).getMoveUnits_Line().updateMoveTime();
        }
        if (!CFG.SPECTATOR_MODE && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).moveUnitsSize() > 0) {
            CFG.SFXManager.playSound(SFXManager.SFX_MOVE_ARMY);
        }
        for (j = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() - 1; j > 0; --j) {
            if (CFG.core.getCiv(j).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
            for (i2 = 0; i2 < CFG.core.getCiv(j).moveUnitsSize(); ++i2) {
                CFG.core.getCiv(j).getMoveUnits(i2).getMoveUnits_Line().updateMoveTime();
            }
        }
        for (j = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() + 1; j < CFG.core.getCivsSize(); ++j) {
            if (CFG.core.getCiv(j).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
            for (i2 = 0; i2 < CFG.core.getCiv(j).moveUnitsSize(); ++i2) {
                if (CFG.core.getCiv(j).getMoveUnits(i2).getMoveUnits_Line() == null) continue;
                CFG.core.getCiv(j).getMoveUnits(i2).getMoveUnits_Line().updateMoveTime();
            }
        }
        RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER = 0L;
        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).runNextEvent2();
        Menu_InGame_Messages.START_ANIMATION = true;
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.map.getMpSl().stopScrollingTheMap();
                SCALE_BEFORE_NEXT_PLAYER_MENU = CFG.map.getMpS().getCurrSc();
                CFG.map.getMpSl().stopScrollingTheMap();
                CFG.map.getMpC().centerToCivilizationBox(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), true);
                this.getMenuElem(iID).setVisibleE(false);
                break;
            }
            case 1: {
                this.onBackPressed();
            }
        }
    }

    @Override
    public final void onBackPressed() {
        Menu_NextPlayerTurn.clickBack();
    }

    @Override
    public void onMenuPressed() {
        this.onBackPressed();
    }
}

