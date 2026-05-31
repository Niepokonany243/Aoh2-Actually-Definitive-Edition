/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;

public class MapScroll {
    public static final float SCROLL_SLOW = 0.97f;
    private boolean scrollingTheMap = false;
    private int iScrollPosX;
    private int iScrollPosY;
    private int iScrollPosX2 = -1;
    private int iScrollPosY2 = -1;
    private float fScrollNewPosX;
    private float fScrollNewPosY;
    private long moveMapTime = 0L;
    private boolean moveMapDirection = false;
    private int iStepID = 0;
    private int iScrollEvent_PosX;
    private int iScrollEvent_PosY;
    private boolean scrollEvent = false;
    private int iPlayerID = 0;
    private boolean enableBackgroundAnimation = false;
    private BackgroundAnimation backgroundAnimation = new BackgroundAnimation(){

        @Override
        public void updateBackgroundAnimation() {
        }
    };
    private ReverseDirection reverseDirectionX = null;
    private ReverseDirection reverseDirectionY = null;
    private static final int MAX_SCROLLING_SPEED = 500;

    public final void updateEnableBackroundAnimation() {
        boolean bl = this.enableBackgroundAnimation = !CFG.menus.getInGameView() && !CFG.menus.getInSelectCiv() && !CFG.menus.getInCreateScenario_Civilizations() && !CFG.menus.getInCrScAs() && !CFG.menus.getInCreateScenario_Assign_Select() && !CFG.menus.getInCreateScenario_Civilizations_Select() && !CFG.menus.getInCreateScenario_WastelandMap() && !CFG.menus.getInCreateScenario_Available_Provinces() && !CFG.menus.getInCreateScenario_SetUpArmy() && !CFG.menus.getInCreateScenario_TechnologyLevels() && !CFG.menus.getInCreateScenario_Preview() && !CFG.menus.getInCreateScenario_PalletOfColors() && !CFG.menus.getInCreateScenario_StartingMoney() && !CFG.menus.getInCreateScenario_Happiness() && !CFG.menus.getIn_MainMenu() && !CFG.menus.getIn_AboutMenu() && !CFG.menus.getInStartGameMenu() && !CFG.menus.getInEndGameMenu() && !CFG.menus.getInCreateNewGame() && !CFG.menus.getInManageDiplomacy() && !CFG.menus.getInLoadMap() && !CFG.menus.getInLoadSave() && !CFG.menus.getInSelectMapType() && !CFG.menus.getIn_CustomizeAlliance() && !CFG.menus.getInSelectAvailableCivilizations() && !CFG.menus.getInCreateCivilization() && !CFG.menus.getInCreateCity() && !CFG.menus.getInGame_PeaceTreaty() && !CFG.menus.getInGame_PeaceTreaty_Response() && !CFG.menus.getInMapEditor_Create_NewContinent() && !CFG.menus.getInGameEditor_Create_DiplomacyPackage() && !CFG.menus.getInGameEditor_TerrainAdd() && !CFG.menus.getInGameEditor_ReligionAdd() && !CFG.menus.getInChooseScenario() && !CFG.menus.getInSettingsProvince() && !CFG.menus.getInMapEditor_Terrain() && !CFG.menus.getInMapEditor_Continents() && !CFG.menus.getInMapEditor_GrowthRate() && !CFG.menus.getInMapEditor_ArmyPosition() && !CFG.menus.getInMapEditor_TradeZones() && !CFG.menus.getInMapEditor_TradeZones_Edit() && !CFG.menus.getInMapEditor_WastelandMaps_Edit() && !CFG.menus.getInMapEditor_ArmySeaBoxes() && !CFG.menus.getInMapEditor_ArmySeaBoxes_Edit() && !CFG.menus.getInMapEditor_ArmySeaBoxes_Add() && !CFG.menus.getInMapEditor_Connections() && !CFG.menus.getInMapEditor_ProvinceName() && !CFG.menus.getInMapEditor_ProvinceBackground() && !CFG.menus.getInMapEditor_SeaProvinces() && !CFG.menus.getInMapEditor_PortPosition() && !CFG.menus.getInGame_Timeline() && !CFG.menus.getInMapEditor_Create_NewRegion() && !CFG.menus.getInMapEditor_Regions() && !CFG.menus.getInDownloadPallets() && !CFG.menus.getInSelectLanguage() && !CFG.menus.getInMapEditor_LoadSuggestedOwners() && !CFG.menus.getInMapEditor_LoadPreDefinedBorders() && !CFG.menus.getInCreateScenario_Cores() && !CFG.menus.getInPalletOfCivsColorsEdit() && !CFG.menus.getInCreateScenario_Events_SelectProvinces() && !CFG.menus.getInGameEditor_Regions() && !CFG.menus.getInNextPlayerTurn() && !CFG.menus.getInVictory() && !CFG.menus.getIn_Game_CivilizationView() && !CFG.menus.getInPrintAMap() && !CFG.menus.getInRandomGame() && !CFG.menus.getInRandomGame_Civilizations_Select() && !CFG.menus.getCreateScenario_ScenarioAge() && !CFG.menus.getInCreateScenario_HolyRomanEmpire() && !CFG.menus.getInMapEditor_FormableCivs_Edit() && !CFG.menus.getInGame_CreateAVassal() && !CFG.menus.getInGame_SelectProvinces() && !CFG.menus.getInGame_ShowProvinces() && !CFG.menus.getInGame_TradeSelectCiv() && !CFG.menus.getInMapEditor_FormableCivs_SelectFormable() && !CFG.menus.getInMapEditor_FormableCivs_SelectClaimant() && !CFG.menus.getInGame_Formable_Civ_Provinces() && !CFG.menus.getInGame_FormAnimation();
        this.backgroundAnimation = this.enableBackgroundAnimation ? (CFG.menus.getInNewGamePlayers() ? new BackgroundAnimation(){

            @Override
            public void updateBackgroundAnimation() {
                if (!CFG.map.getTouchMgr().getActionMap() && CFG.core.getPlayersSize() > 1 && CFG.menus.getInNewGamePlayers()) {
                    try {
                        if (CFG.core.getPlayer(MapScroll.this.iPlayerID).getCivId() < 0) {
                            ++MapScroll.this.iPlayerID;
                            if (MapScroll.this.iPlayerID >= CFG.core.getPlayersSize()) {
                                MapScroll.this.iPlayerID = 0;
                            }
                            return;
                        }
                    }
                    catch (IndexOutOfBoundsException ex) {
                        MapScroll.this.iPlayerID = 0;
                        return;
                    }
                    if (MapScroll.this.moveMapTime <= System.currentTimeMillis() - 2500L) {
                        try {
                            MapScroll.this.setScrollEvent(CFG.core.getCiv(CFG.core.getPlayer(MapScroll.this.iPlayerID).getCivId()).getCapitalProvID());
                            MapScroll.this.iPlayerID++;
                        }
                        catch (IndexOutOfBoundsException ex) {
                            MapScroll.this.iPlayerID = 0;
                            MapScroll.this.setScrollEvent(CFG.core.getCiv(CFG.core.getPlayer(MapScroll.this.iPlayerID).getCivId()).getCapitalProvID());
                        }
                        if (MapScroll.this.iPlayerID >= CFG.core.getPlayersSize()) {
                            MapScroll.this.iPlayerID = 0;
                        }
                    }
                }
            }
        } : new BackgroundAnimation(){

            @Override
            public void updateBackgroundAnimation() {
            }
        }) : new BackgroundAnimation(){

            @Override
            public void updateBackgroundAnimation() {
            }
        };
    }

    public MapScroll() {
        this.buildReverseDirectionX();
        this.buildReverseDirectionY();
    }

    public final void update() {
        if (this.scrollEvent) {
            if (this.iStepID < 14) {
                CFG.map.getMpC().setNewPosX(CFG.map.getMpC().getPX() - (int)MapScroll.changeAnimationPos(this.iStepID, this.iScrollEvent_PosX));
                CFG.map.getMpC().setNewPosY(CFG.map.getMpC().getPY() - (int)MapScroll.changeAnimationPos(this.iStepID++, this.iScrollEvent_PosY));
                if (this.iStepID == 14) {
                    this.moveMapTime = CFG.currentTimeMillis;
                    this.scrollEvent = false;
                }
            }
        } else if (this.scrollingTheMap && !CFG.map.getMpC().getDisableMovingMap()) {
            if (Math.abs(this.fScrollNewPosX) > 1.0f || Math.abs(this.fScrollNewPosY) > 1.0f) {
                if (Math.abs(this.fScrollNewPosX) > 1.0f) {
                    CFG.map.getMpC().setNewPosX(this.reverseDirectionX.getNewPos((int)this.fScrollNewPosX));
                    this.fScrollNewPosX *= 0.97f;
                }
                if (Math.abs(this.fScrollNewPosY) > 1.0f) {
                    CFG.map.getMpC().setNewPosY(this.reverseDirectionY.getNewPos((int)this.fScrollNewPosY));
                    this.fScrollNewPosY *= 0.97f;
                }
            } else {
                this.stopScrollingTheMap();
            }
        } else {
            this.backgroundAnimation.updateBackgroundAnimation();
        }
    }

    public static final float changeAnimationPos(int animationStepID, int nWidth) {
        switch (animationStepID) {
            case 0: 
            case 1: 
            case 12: 
            case 13: {
                return (float)nWidth * 2.5f / 100.0f;
            }
            case 2: 
            case 3: 
            case 10: 
            case 11: {
                return (float)nWidth * 5.0f / 100.0f;
            }
            case 4: 
            case 5: 
            case 8: 
            case 9: {
                return (float)nWidth * 10.0f / 100.0f;
            }
            case 6: 
            case 7: {
                return (float)nWidth * 15.0f / 100.0f;
            }
        }
        return 0.0f;
    }

    public final void startScrollingTheMap() {
        if (!(CFG.brushMode || this.iScrollPosX2 < 0 && this.iScrollPosY2 < 0)) {
            float f = Math.abs(this.iScrollPosX - this.iScrollPosX2);
            float f2 = CFG.getIsDesktop() ? (float)CFG.PADD * GameValues.gvMapScroll.START_SCROLLING_MAP_MODIFIER_PC : GameValues.gvMapScroll.START_SCROLLING_MAP_MODIFIER_MOBILE;
            if (f > f2 * CFG.DENSITY) {
                this.fScrollNewPosX = (float)(this.iScrollPosX - this.iScrollPosX2) * GameValues.gvMapScroll.START_SCROLLING_SPEED_MODIFIER * (float)(CFG.reverseDirectionX ? 1 : -1);
                this.scrollingTheMap = true;
            }
            float f3 = Math.abs(this.iScrollPosY - this.iScrollPosY2);
            float f4 = CFG.getIsDesktop() ? (float)CFG.PADD * GameValues.gvMapScroll.START_SCROLLING_MAP_MODIFIER_PC : GameValues.gvMapScroll.START_SCROLLING_MAP_MODIFIER_MOBILE;
            if (f3 > f4 * CFG.DENSITY) {
                this.fScrollNewPosY = (float)(this.iScrollPosY - this.iScrollPosY2) * GameValues.gvMapScroll.START_SCROLLING_SPEED_MODIFIER * (float)(CFG.reverseDirectionY ? 1 : -1);
                this.scrollingTheMap = true;
            }
            if (CFG.map.getMpS().getCurrSc() > 1.0f) {
                this.fScrollNewPosX = Math.max(-500.0f, Math.min(500.0f, this.fScrollNewPosX) / CFG.map.getMpS().getCurrSc());
                this.fScrollNewPosY = Math.max(-500.0f, Math.min(500.0f, this.fScrollNewPosY) / CFG.map.getMpS().getCurrSc());
            } else {
                this.fScrollNewPosX = Math.max(-500.0f, Math.min(500.0f, this.fScrollNewPosX));
                this.fScrollNewPosY = Math.max(-500.0f, Math.min(500.0f, this.fScrollNewPosY));
            }
        }
        if (this.iScrollPosX != this.iScrollPosX2) {
            this.updateMoveMapDirection(this.iScrollPosX > this.iScrollPosX2);
        }
        this.resetScrollInfo();
    }

    public final void stopScrollingTheMap() {
        this.scrollingTheMap = false;
        this.resetScrollInfo();
        this.scrollEvent = false;
    }

    public final void updateMoveMapDirection(boolean moveMapDirection) {
        this.moveMapDirection = moveMapDirection;
        this.moveMapTime = 0L;
    }

    public final void resetScrollInfo() {
        this.iScrollPosY2 = -1;
        this.iScrollPosX2 = -1;
        this.iScrollPosY = -1;
        this.iScrollPosX = -1;
    }

    public final void setScrollEvent(int nProvinceID) {
        this.setScrollEvent_Pos((int)((float)(CFG.map.getMpC().getPX() + CFG.core.getProv(nProvinceID).getCeX()) - (float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc() / 2.0f), (int)((float)(CFG.map.getMpC().getPY() + CFG.core.getProv(nProvinceID).getCeY()) - (float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc() / 2.0f));
    }

    public final void setScrollEvent_ToPosition(int nPosX, int nPosY) {
        this.setScrollEvent_Pos((int)((float)(CFG.map.getMpC().getPX() + nPosX) - (float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc() / 2.0f), (int)((float)(CFG.map.getMpC().getPY() + nPosY) - (float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc() / 2.0f));
    }

    private final void setScrollEvent_Pos(int nPosX, int nPosY) {
        if (this.scrollEvent) {
            return;
        }
        this.scrollEvent = true;
        this.iStepID = 0;
        this.iScrollEvent_PosX = nPosX;
        this.iScrollEvent_PosY = nPosY;
        this.moveMapTime = System.currentTimeMillis() + 208L;
    }

    public final void buildReverseDirectionX() {
        this.reverseDirectionX = CFG.reverseDirectionX ? new ReverseDirection(){

            @Override
            public int getNewPos(int nPosX) {
                return CFG.map.getMpC().getNewPosX() + nPosX;
            }
        } : new ReverseDirection(){

            @Override
            public int getNewPos(int nPosX) {
                return CFG.map.getMpC().getNewPosX() - nPosX;
            }
        };
    }

    public final void buildReverseDirectionY() {
        this.reverseDirectionY = CFG.reverseDirectionY ? new ReverseDirection(){

            @Override
            public int getNewPos(int nPosY) {
                return CFG.map.getMpC().getNewPosY() + nPosY;
            }
        } : new ReverseDirection(){

            @Override
            public int getNewPos(int nPosY) {
                return CFG.map.getMpC().getNewPosY() - nPosY;
            }
        };
    }

    public final void setScrollPos(int nPosX, int nPosY) {
        this.iScrollPosX2 = this.iScrollPosX;
        this.iScrollPosY2 = this.iScrollPosY;
        this.iScrollPosX = nPosX;
        this.iScrollPosY = nPosY;
    }

    public boolean getScrollingTheMap() {
        return this.scrollingTheMap;
    }

    static interface BackgroundAnimation {
        public void updateBackgroundAnimation();
    }

    private static interface ReverseDirection {
        public int getNewPos(int var1);
    }
}

