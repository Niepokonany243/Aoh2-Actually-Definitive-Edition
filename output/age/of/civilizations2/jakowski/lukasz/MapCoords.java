/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapScale;
import age.of.civilizations2.jakowski.lukasz.Point_XY2;

public class MapCoords {
    private int iPosX = 0;
    private int iPosY = 0;
    private int iNewPosX = 0;
    private int iNewPosY = 0;
    private boolean secondSideOfMap = false;
    private int iSecondSideOfMap_TranslateX = 0;
    private boolean disableMovingTheMap = false;
    private int iMinPosY;
    private int iMaxPosY;
    private int iMinPosScaledY;
    private int iMaxPosScaledY;
    private int iMinPosScaledX;
    private WorldMap worldMap;

    public final void updateWorldMap() {
        this.worldMap = CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN()) ? new WorldMap(){

            @Override
            public void updateSecondSideOfMap() {
                MapCoords.this.secondSideOfMap = (float)(-MapCoords.this.iPosX) + (float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc() >= (float)CFG.map.getMpB().getWidthM();
                if (MapCoords.this.secondSideOfMap) {
                    MapCoords.this.iSecondSideOfMap_TranslateX = CFG.map.getMpB().getWidthM();
                } else {
                    MapCoords.this.iSecondSideOfMap_TranslateX = 0;
                }
            }

            @Override
            public void updateMapPosX() {
                if (Math.abs(MapCoords.this.iNewPosX) > CFG.map.getMpB().getWidthM()) {
                    MapCoords.this.iPosX = CFG.map.getMpB().getWidthM() + MapCoords.this.iNewPosX;
                    CFG.map.getTouchMgr().setUpdateStartMovePosX(true);
                } else if (MapCoords.this.iNewPosX > 0) {
                    MapCoords.this.iPosX = -CFG.map.getMpB().getWidthM() + MapCoords.this.iNewPosX;
                    CFG.map.getTouchMgr().setUpdateStartMovePosX(true);
                } else {
                    MapCoords.this.iPosX = MapCoords.this.iNewPosX;
                }
                MapCoords.this.checkPositionOfMapX();
                this.updateSecondSideOfMap();
            }
        } : new WorldMap(){

            @Override
            public void updateSecondSideOfMap() {
                MapCoords.this.secondSideOfMap = false;
                MapCoords.this.iSecondSideOfMap_TranslateX = 0;
            }

            @Override
            public void updateMapPosX() {
                if ((float)Math.abs(MapCoords.this.iNewPosX) >= (float)CFG.map.getMpB().getWidthM() - (float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc() + (float)MapCoords.this.iMinPosScaledX) {
                    MapCoords.this.iPosX = (int)((float)(-CFG.map.getMpB().getWidthM() - MapCoords.this.iMinPosScaledX) + (float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc());
                    CFG.map.getTouchMgr().setUpdateStartMovePosX(true);
                } else if (MapCoords.this.iNewPosX >= MapCoords.this.iMinPosScaledX) {
                    MapCoords.this.iPosX = MapCoords.this.iMinPosScaledX;
                    CFG.map.getTouchMgr().setUpdateStartMovePosX(true);
                } else {
                    MapCoords.this.iPosX = MapCoords.this.iNewPosX;
                }
                if (MapCoords.this.iPosX >= MapCoords.this.iMinPosScaledX) {
                    MapCoords.this.iPosX = (MapCoords.this.iNewPosX = MapCoords.this.iMinPosScaledX);
                }
                MapCoords.this.checkPositionOfMapX();
            }
        };
    }

    public final void update() {
        this.updateMapPos();
    }

    public final void updateMapPos() {
        if (this.iPosX != this.iNewPosX) {
            CFG.core.setuPRV(true);
            this.worldMap.updateMapPosX();
        }
        if (this.iPosY != this.iNewPosY) {
            CFG.core.setuPRV(true);
            if (this.iNewPosY > (int)(((float)this.iMinPosY + (float)this.iMinPosScaledY * CFG.map.getMpS().getCurrSc()) / CFG.map.getMpS().getCurrSc())) {
                this.iPosY = (int)(((float)this.iMinPosY + (float)this.iMinPosScaledY * CFG.map.getMpS().getCurrSc()) / CFG.map.getMpS().getCurrSc());
                CFG.map.getTouchMgr().setUpdateStartMovePosY(true);
            } else if ((float)(-this.iNewPosY) + (float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc() > (float)CFG.map.getMpB().getHeightM() + ((float)this.iMaxPosY + (float)this.iMaxPosScaledY * CFG.map.getMpS().getCurrSc()) / CFG.map.getMpS().getCurrSc()) {
                this.iPosY = -((int)((float)CFG.map.getMpB().getHeightM() - (float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc() + ((float)this.iMaxPosY + (float)this.iMaxPosScaledY * CFG.map.getMpS().getCurrSc()) / CFG.map.getMpS().getCurrSc()));
                CFG.map.getTouchMgr().setUpdateStartMovePosY(true);
            } else {
                this.iPosY = this.iNewPosY;
            }
            this.checkPositionOfMapY();
        }
    }

    public final void checkPositionOfMapX() {
        if (-this.iNewPosX > CFG.map.getMpB().getWidthM()) {
            this.iPosX %= CFG.map.getMpB().getWidthM();
            this.iNewPosX = this.iPosX;
        } else if (this.iPosX > 0) {
            this.iPosX %= CFG.map.getMpB().getWidthM();
            this.iNewPosX = this.iPosX;
        }
    }

    public final void checkPositionOfMapY() {
        if (-this.iPosY > CFG.map.getMpB().getHeightM()) {
            this.iPosY %= CFG.map.getMpB().getHeightM();
            this.iNewPosY = this.iPosY;
        } else if ((float)this.iPosY > ((float)this.iMinPosY + (float)this.iMinPosScaledY * CFG.map.getMpS().getCurrSc()) / CFG.map.getMpS().getCurrSc()) {
            this.iNewPosY = this.iPosY = (int)(((float)this.iMinPosY + (float)this.iMinPosScaledY * CFG.map.getMpS().getCurrSc()) / CFG.map.getMpS().getCurrSc());
        }
    }

    public final void updateMinMaxPosY() {
        if (CFG.menus.getInGameView()) {
            this.iMinPosY = IMGManager.getIMG(Images.topFlagBG).getHeight();
            this.iMaxPosY = CFG.BUTTON_H + CFG.PADD * 2;
        } else if (CFG.menus.getInCreateScenario_WastelandMap() || CFG.menus.getInCrScAs() || CFG.menus.getInCreateScenario_Available_Provinces() || CFG.menus.getInCreateScenario_Civilizations()) {
            this.iMinPosY = CFG.BUTTON_H + CFG.PADD * 2;
            this.iMaxPosY = CFG.BUTTON_H + CFG.PADD * 2;
        } else if (CFG.menus.getInCreateNewGame()) {
            this.iMinPosY = 0;
            this.iMaxPosY = CFG.BUTTON_H + CFG.PADD * 2;
        } else if (CFG.menus.getInSelectCiv()) {
            this.iMinPosY = CFG.BUTTON_H / 2;
            this.iMaxPosY = CFG.BUTTON_H + CFG.PADD * 2;
        } else if (CFG.menus.getInMapEditor_ArmySeaBoxes() || CFG.menus.getInMapEditor_ArmySeaBoxes_Edit() || CFG.menus.getInMapEditor_ArmySeaBoxes_Add()) {
            this.iMinPosY = CFG.BUTTON_H + CFG.PADD * 2;
            this.iMaxPosY = CFG.BUTTON_H + CFG.PADD * 2;
        } else {
            this.iMinPosY = 0;
            this.iMaxPosY = 0;
        }
        if (CFG.menus.getIn_MainMenu() || CFG.menus.getInNextPlayerTurn() || CFG.menus.getInVictory() || CFG.menus.getIn_Game_CivilizationView() || CFG.menus.getInGame_Formable_Civ_Provinces() || CFG.menus.getInGame_FormAnimation()) {
            this.iMinPosScaledY = 0;
            this.iMaxPosScaledY = 0;
            this.iMinPosScaledX = 0;
        } else {
            this.iMinPosScaledY = IMGManager.getIMG(Images.mapBorder).getHeight();
            this.iMaxPosScaledY = IMGManager.getIMG(Images.mapBorder).getHeight();
            this.iMinPosScaledX = !CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN()) ? IMGManager.getIMG(Images.mapBorder).getHeight() : 0;
        }
    }

    public final void updateSecondSideOfMap() {
        this.worldMap.updateSecondSideOfMap();
    }

    public final void centerToMinimapClick(int nX, int nY) {
        float tempScaleX = CFG.map.getMpB().iMinimapScaled_Width / CFG.map.getMpB().getMinimapWidth();
        float tempScaleY = CFG.map.getMpB().iMinimapScaled_Height / CFG.map.getMpB().getMinimapHeight();
        CFG.map.getMpSl().stopScrollingTheMap();
        CFG.map.getMpSl().setScrollEvent_ToPosition(CFG.map.getMpB().iMinimapScaled_PosX + (int)((float)nX * tempScaleX), CFG.map.getMpB().iMinimapScaled_PosY + (int)((float)nY * tempScaleY));
    }

    public final void centerToCapital_OrMetProvinceCivID(int nCivID) {
        if (nCivID <= 0) {
            return;
        }
        try {
            int nProvinceID = CFG.core.getCiv(nCivID).getCapitalProvID();
            if (nProvinceID >= 0 && CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(nProvinceID)) {
                nProvinceID = -1;
                for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                    if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(nCivID).getProvID(i))) continue;
                    nProvinceID = CFG.core.getCiv(nCivID).getProvID(i);
                    break;
                }
            }
            if (nProvinceID >= 0) {
                CFG.core.setActiveProvID(nProvinceID);
                this.centerToProvID(nProvinceID);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public final void centerToCapital_OrMetProvinceCivID_Just(int nCivID) {
        if (nCivID <= 0) {
            return;
        }
        try {
            int nProvinceID = CFG.core.getCiv(nCivID).getCapitalProvID();
            if (nProvinceID >= 0 && CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(nProvinceID)) {
                nProvinceID = -1;
                for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                    if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(nCivID).getProvID(i))) continue;
                    nProvinceID = CFG.core.getCiv(nCivID).getProvID(i);
                    break;
                }
            }
            if (nProvinceID >= 0) {
                this.centerToProvID(nProvinceID);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public final int getCapital_OrMetProvinceCivID(int nCivID) {
        if (nCivID <= 0) {
            return -1;
        }
        try {
            int nProvinceID = CFG.core.getCiv(nCivID).getCapitalProvID();
            if (nProvinceID >= 0 && CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(nProvinceID)) {
                nProvinceID = -1;
                for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                    if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(nCivID).getProvID(i))) continue;
                    nProvinceID = CFG.core.getCiv(nCivID).getProvID(i);
                    break;
                }
            }
            if (nProvinceID >= 0) {
                return nProvinceID;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return -1;
    }

    public final void centerToProvID(int i) {
        try {
            CFG.map.getMpSl().stopScrollingTheMap();
            CFG.map.getMpSl().setScrollEvent(i);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public final void centerToCivilizationBox(int nCivID, boolean nScroll) {
        this.centerToCivilizationBox(nCivID, nScroll, true);
    }

    public final void centerToCivilizationBox(int nCivID, boolean nScroll, boolean scaleLowerThanOneZero) {
        Point_XY2 min_XY = new Point_XY2(CFG.map.getMpB().getWidthM() * 2, CFG.map.getMpB().getHeightM() * 2);
        Point_XY2 max_XY = new Point_XY2(-CFG.map.getMpB().getWidthM() * 2, -CFG.map.getMpB().getHeightM() * 2);
        for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            if (min_XY.getPX() > CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMiX2()) {
                min_XY.setPX(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMiX2());
            }
            if (min_XY.getPY() > CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMiY4()) {
                min_XY.setPY(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMiY4());
            }
            if (max_XY.getPX() < CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMaX7()) {
                max_XY.setPX(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMaX7());
            }
            if (max_XY.getPY() >= CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMaY6()) continue;
            max_XY.setPY(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMaY6());
        }
        if (CFG.core.getCiv(nCivID).getNumOfProvs() > 0) {
            this.centerToBox(min_XY, max_XY, nScroll, scaleLowerThanOneZero);
        }
    }

    public final void centerToCivilizationBox_Timeline(int nCivID, boolean nScroll) {
        Point_XY2 min_XY = new Point_XY2(CFG.map.getMpB().getWidthM() * 2, CFG.map.getMpB().getHeightM() * 2);
        Point_XY2 max_XY = new Point_XY2(-CFG.map.getMpB().getWidthM() * 2, -CFG.map.getMpB().getHeightM() * 2);
        int numOfProvinces = 0;
        for (int i = CFG.timelapseManager.timelineOwners.size() - 1; i >= 0; --i) {
            if (CFG.timelapseManager.timelineOwners.get(i) != nCivID) continue;
            if (min_XY.getPX() > CFG.core.getProv(i).getMiX2()) {
                min_XY.setPX(CFG.core.getProv(i).getMiX2());
            }
            if (min_XY.getPY() > CFG.core.getProv(i).getMiY4()) {
                min_XY.setPY(CFG.core.getProv(i).getMiY4());
            }
            if (max_XY.getPX() < CFG.core.getProv(i).getMaX7()) {
                max_XY.setPX(CFG.core.getProv(i).getMaX7());
            }
            if (max_XY.getPY() < CFG.core.getProv(i).getMaY6()) {
                max_XY.setPY(CFG.core.getProv(i).getMaY6());
            }
            ++numOfProvinces;
        }
        if (numOfProvinces > 0) {
            this.centerToBox(min_XY, max_XY, nScroll, true);
        }
    }

    public final void centerToCivilizationBox_FogOfWar(int nCivID, boolean nScroll) {
        Point_XY2 min_XY = new Point_XY2(CFG.map.getMpB().getWidthM() * 2, CFG.map.getMpB().getHeightM() * 2);
        Point_XY2 max_XY = new Point_XY2(-CFG.map.getMpB().getWidthM() * 2, -CFG.map.getMpB().getHeightM() * 2);
        for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(nCivID).getProvID(i))) continue;
            if (min_XY.getPX() > CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMiX2()) {
                min_XY.setPX(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMiX2());
            }
            if (min_XY.getPY() > CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMiY4()) {
                min_XY.setPY(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMiY4());
            }
            if (max_XY.getPX() < CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMaX7()) {
                max_XY.setPX(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMaX7());
            }
            if (max_XY.getPY() >= CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMaY6()) continue;
            max_XY.setPY(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getMaY6());
        }
        if (CFG.core.getCiv(nCivID).getNumOfProvs() > 0) {
            this.centerToBox(min_XY, max_XY, nScroll);
        }
    }

    public final void centerToBox(Point_XY2 min_XY, Point_XY2 max_XY, boolean nScroll) {
        this.centerToBox(min_XY, max_XY, nScroll, true);
    }

    public final void centerToBox(Point_XY2 min_XY, Point_XY2 max_XY, boolean nScroll, boolean scaleLowerThanOneZero) {
        float nXScale = (float)CFG.GAMEWIDTH * 0.95f / (float)(max_XY.getPX() - min_XY.getPX());
        float nYScale = ((float)CFG.GAMEHEIGHT * 0.95f - ((float)this.iMinPosY + (float)this.iMinPosScaledY * CFG.map.getMpS().getCurrSc()) - ((float)this.iMaxPosY + (float)this.iMaxPosScaledY * CFG.map.getMpS().getCurrSc())) / (float)(max_XY.getPY() - min_XY.getPY());
        if (scaleLowerThanOneZero || CFG.map.getMpS().getCurrSc() > 1.0f) {
            if (nXScale < nYScale) {
                if (nXScale < MapScale.STANDARD_SCALE) {
                    CFG.map.getMpS().setCurrScale(nXScale);
                } else {
                    CFG.map.getMpS().setCurrScale(MapScale.STANDARD_SCALE);
                }
            } else if (nYScale < MapScale.STANDARD_SCALE) {
                CFG.map.getMpS().setCurrScale(nYScale);
            } else {
                CFG.map.getMpS().setCurrScale(MapScale.STANDARD_SCALE);
            }
        }
        if (nScroll) {
            CFG.map.getMpSl().stopScrollingTheMap();
            CFG.map.getMpSl().setScrollEvent_ToPosition((min_XY.getPX() + max_XY.getPX()) / 2, (min_XY.getPY() + max_XY.getPY()) / 2);
        } else {
            CFG.map.getMpC().setNewPosX(-((int)((float)((min_XY.getPX() + max_XY.getPX()) / 2) - (float)CFG.GAMEWIDTH / CFG.map.getMpS().getCurrSc() / 2.0f)));
            CFG.map.getMpC().setNewPosY(-((int)((float)((min_XY.getPY() + max_XY.getPY()) / 2) - (float)CFG.GAMEHEIGHT / CFG.map.getMpS().getCurrSc() / 2.0f)));
        }
    }

    public final void centerToRandomMapPos() {
        CFG.map.getMpSl().stopScrollingTheMap();
        CFG.map.getMpS().setCurrScale(MapScale.STANDARD_SCALE);
        Point_XY2 tempPointToCenterTheMap = CFG.getRandomPointToCenterTheMap();
        this.setNewPosX(-(tempPointToCenterTheMap.getPX() * CFG.map.getMpB().getMapSc3() - CFG.GAMEWIDTH / 2));
        this.setNewPosY(-(tempPointToCenterTheMap.getPY() * CFG.map.getMpB().getMapSc3() - CFG.GAMEHEIGHT / 2));
        this.updateMapPos();
    }

    public final void setStartingPosX(int iPosX) {
        this.iPosX = iPosX;
        this.iNewPosX = iPosX;
        CFG.core.setuPRV(true);
    }

    public final void setStartingPosY(int iPosY) {
        this.iPosY = iPosY;
        this.iNewPosY = iPosY;
        CFG.core.setuPRV(true);
    }

    public final int getPX() {
        return this.iPosX;
    }

    public final int getPY() {
        return this.iPosY;
    }

    public final int getNewPosX() {
        return this.iNewPosX;
    }

    public final void setNewPosX(int iNewPosX) {
        this.iNewPosX = iNewPosX;
    }

    public final int getNewPosY() {
        return this.iNewPosY;
    }

    public final void setNewPosY(int iNewPosY) {
        this.iNewPosY = iNewPosY;
    }

    public final boolean getSecondSideOfMap() {
        return this.secondSideOfMap;
    }

    public final int getSecondSideOfMap_MoveX() {
        return this.iSecondSideOfMap_TranslateX;
    }

    public final boolean getDisableMovingMap() {
        return this.disableMovingTheMap;
    }

    public final void setDisableMovingMap(boolean disableMovingTheMap) {
        this.disableMovingTheMap = disableMovingTheMap;
    }

    private static interface WorldMap {
        public void updateSecondSideOfMap();

        public void updateMapPosX();
    }
}

