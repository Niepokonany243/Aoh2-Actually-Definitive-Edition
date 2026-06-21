
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.ArmyS.Menu_MapEditor_ArmySeaBoxes_Add;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_CivilizationView;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.GameE.Menu_GameEditor_Regions;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RenderProvince {
    public static DrawProvinces drawProvinces;
    public static long PROVINCE_COLOR_ANIMATION_TIMER;
    public static final float ALPHA_PEACE_TREATY_PROVINCES = 0.25f;

    public static final Color getProvincePortColor(int nProvinceID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.PORT) > 0) {
            return CFG.COLOR_IN_CONSTRUCTION;
        }
        switch (CFG.core.getProv(nProvinceID).getLvlOfPort()) {
            case -1: {
                return CFG.COLOR_PORT_m1;
            }
            case 0: {
                return CFG.COLOR_PORT_0;
            }
        }
        return CFG.COLOR_PORT_1;
    }

    public static final Color getProvince_FortColor(int nProvinceID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.FORT) > 0) {
            return CFG.COLOR_IN_CONSTRUCTION;
        }
        switch (CFG.core.getProv(nProvinceID).getLvlOfFort()) {
            case -1: 
            case 0: {
                return CFG.COLOR_PORT_m1;
            }
            case 1: {
                return CFG.COLOR_FORT_1;
            }
        }
        return CFG.COLOR_FORT_2;
    }

    public static final Color getProvince_WatchTowerColor(int nProvinceID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.TOWER) > 0) {
            return CFG.COLOR_IN_CONSTRUCTION;
        }
        switch (CFG.core.getProv(nProvinceID).getLvlOfWatchTower()) {
            case -1: 
            case 0: {
                return CFG.COLOR_PORT_m1;
            }
        }
        return CFG.COLOR_WATCH_TOWER;
    }

    public static final Color getProvince_FarmColor(int nProvinceID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.FARM) > 0) {
            return CFG.COLOR_IN_CONSTRUCTION;
        }
        switch (CFG.core.getProv(nProvinceID).getLvlOfFarm()) {
            case -1: 
            case 0: {
                return CFG.COLOR_PORT_m1;
            }
            case 1: {
                return CFG.COLOR_FARM1;
            }
            case 2: {
                return CFG.COLOR_FARM2;
            }
            case 3: {
                return CFG.COLOR_FARM3;
            }
            case 4: {
                return CFG.COLOR_FARM4;
            }
        }
        return CFG.COLOR_FARM5;
    }

    public static final Color getProvince_LibraryColor(int nProvinceID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.LIBRARY) > 0) {
            return CFG.COLOR_IN_CONSTRUCTION;
        }
        switch (CFG.core.getProv(nProvinceID).getLvlOfLibrary()) {
            case -1: 
            case 0: {
                return CFG.COLOR_PORT_m1;
            }
            case 1: {
                return CFG.COLOR_LIBRARY3;
            }
            case 2: {
                return CFG.COLOR_LIBRARY4;
            }
        }
        return CFG.COLOR_LIBRARY5;
    }

    public static final Color getProvince_MarketColor(int nProvinceID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.MARKET) > 0) {
            return CFG.COLOR_IN_CONSTRUCTION;
        }
        switch (CFG.core.getProv(nProvinceID).getLvlOfMarket()) {
            case -1: 
            case 0: {
                return CFG.COLOR_PORT_m1;
            }
            case 1: {
                return CFG.COLOR_MARKET3;
            }
            case 2: {
                return CFG.COLOR_MARKET4;
            }
        }
        return CFG.COLOR_MARKET5;
    }

    public static final Color getProvince_NukeColor(int nProvinceID) {
        switch (CFG.core.getCiv((int)CFG.core.getProv((int)nProvinceID).getCivId()).civGD.iNukes) {
            case -1: 
            case 0: {
                return CFG.COLOR_PORT_m1;
            }
        }
        return CFG.COLOR_NUKE;
    }

    public static final Color getProvince_SupplyColor(int nProvinceID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.SUPPLY) > 0) {
            return CFG.COLOR_IN_CONSTRUCTION;
        }
        switch (CFG.core.getProv(nProvinceID).getLvlOfSupply()) {
            case -1: 
            case 0: {
                return CFG.COLOR_PORT_m1;
            }
        }
        return CFG.COLOR_SUPPLY;
    }

    public static final Color getProvince_WonderColor(int nProvinceID) {
        switch (CFG.core.getProv(nProvinceID).getWonderSize()) {
            case -1: 
            case 0: {
                return CFG.COLOR_PORT_m1;
            }
        }
        if (CFG.core.getProv((int)nProvinceID).provGD.wonderBuilt) {
            return CFG.COLOR_WONDERS;
        }
        return CFG.COLOR_IN_CONSTRUCTION;
    }

    public static final Color getProvince_WorkshopColor(int nProvinceID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.WORKSHOP) > 0) {
            return CFG.COLOR_IN_CONSTRUCTION;
        }
        switch (CFG.core.getProv(nProvinceID).getLvlOfWorkshop()) {
            case -1: 
            case 0: {
                return CFG.COLOR_PORT_m1;
            }
            case 1: {
                return CFG.COLOR_WORKSHOP3;
            }
            case 2: {
                return CFG.COLOR_WORKSHOP4;
            }
        }
        return CFG.COLOR_WORKSHOP5;
    }

    public static final Color getProvince_ArmouryColor(int nProvinceID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.ARMOURY) > 0) {
            return CFG.COLOR_IN_CONSTRUCTION;
        }
        switch (CFG.core.getProv(nProvinceID).getLvlOfArmoury()) {
            case -1: 
            case 0: {
                return CFG.COLOR_PORT_m1;
            }
        }
        return CFG.COLOR_ARMOURY;
    }

    public static final Color getProvince_InvestEcoColor(int nProvinceID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInvested(nProvinceID)) {
            return CFG.COLOR_IN_CONSTRUCTION;
        }
        return CFG.COLOR_PORT_m1;
    }

    public static final Color getProvince_InvestDevColor(int nProvinceID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInvestedDev(nProvinceID)) {
            return CFG.COLOR_IN_CONSTRUCTION;
        }
        return CFG.COLOR_PORT_m1;
    }

    public static final Color getProvince_AssimilationColor(int nProvinceID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isAssimilateOrganized(nProvinceID)) {
            return CFG.COLOR_IN_CONSTRUCTION;
        }
        return CFG.COLOR_PORT_m1;
    }

    public static final Color getProvince_FestivalsColor(int nProvinceID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isFestivalOrganized(nProvinceID)) {
            return CFG.COLOR_IN_CONSTRUCTION;
        }
        return CFG.COLOR_PORT_m1;
    }

    public static final void updateDrawProvinces() {
        if (CFG.menus.getInGameView()) {
            if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                drawProvinces = CFG.mapModesManager.getActiveView().drawProvinces;
            } else {
                RenderProvince.updateDrawProvinces_Standard();
            }
        } else if (CFG.menus.getInCreateNewGame()) {
            if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                drawProvinces = CFG.mapModesManager.getActiveView().drawProvinces;
            } else {
                RenderProvince.updateDrawProvinces_Standard();
            }
        } else if (CFG.menus.getInGame_TradeSelectCiv()) {
            RenderProvince.updateDrawProvinces_Standard();
        } else if (CFG.menus.getInGame_CreateAVassal()) {
            if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                drawProvinces = CFG.mapModesManager.getActiveView().drawProvinces;
            } else if (CFG.FOG_OF_WAR == 2) {
                if (!CFG.VIEW_SHOW_VALUES) {
                    drawProvinces = new DrawProvinces(){

                        @Override
                        public void drawProvinces(SpriteBatch oSB) {
                            for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getProv(CFG.core.getPIV(i)).getTrueOwnerOfProv()) {
                                            CFG.core.getProv(CFG.core.getPIV(i)).setProvColor(oSB);
                                        } else {
                                            oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.5f);
                                        }
                                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                        continue;
                                    }
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() <= 0) continue;
                                    oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.5f);
                                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                    continue;
                                }
                                oSB.setColor(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA);
                                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                            }
                        }
                    };
                } else {
                    RenderProvince.updateDrawProvinces_Standard();
                }
            } else if (!CFG.VIEW_SHOW_VALUES) {
                drawProvinces = new DrawProvinces(){

                    @Override
                    public void drawProvinces(SpriteBatch oSB) {
                        for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                            if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                                if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getProv(CFG.core.getPIV(i)).getTrueOwnerOfProv()) {
                                    CFG.core.getProv(CFG.core.getPIV(i)).setProvColor(oSB);
                                } else {
                                    oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.5f);
                                }
                                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                continue;
                            }
                            if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() <= 0) continue;
                            oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.5f);
                            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        }
                    }
                };
            } else {
                RenderProvince.updateDrawProvinces_Standard();
            }
        } else if (CFG.menus.getInGame_SelectProvinces()) {
            if (CFG.FOG_OF_WAR == 2) {
                if (!CFG.VIEW_SHOW_VALUES) {
                    drawProvinces = new DrawProvinces(){

                        @Override
                        public void drawProvinces(SpriteBatch oSB) {
                            for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID) {
                                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getProv(CFG.core.getPIV(i)).getTrueOwnerOfProv()) {
                                            CFG.core.getProv(CFG.core.getPIV(i)).setProvColor(oSB);
                                        } else {
                                            oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.5f);
                                        }
                                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                        continue;
                                    }
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() <= 0) continue;
                                    oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.5f);
                                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                    continue;
                                }
                                oSB.setColor(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA);
                                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                            }
                        }
                    };
                } else {
                    RenderProvince.updateDrawProvinces_Standard();
                }
            } else if (!CFG.VIEW_SHOW_VALUES) {
                drawProvinces = new DrawProvinces(){

                    @Override
                    public void drawProvinces(SpriteBatch oSB) {
                        for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                            if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID) {
                                if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getProv(CFG.core.getPIV(i)).getTrueOwnerOfProv()) {
                                    CFG.core.getProv(CFG.core.getPIV(i)).setProvColor(oSB);
                                } else {
                                    oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.5f);
                                }
                                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                continue;
                            }
                            if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() <= 0) continue;
                            oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.5f);
                            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        }
                    }
                };
            } else {
                RenderProvince.updateDrawProvinces_Standard();
            }
        } else if (CFG.menus.getInGame_ShowProvinces()) {
            drawProvinces = CFG.FOG_OF_WAR == 2 ? new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                            if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID) {
                                oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.7f);
                                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                continue;
                            }
                            if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() <= 0) continue;
                            oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.7f);
                            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                            continue;
                        }
                        oSB.setColor(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA);
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            } : new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID) {
                            oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.7f);
                            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                            continue;
                        }
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() <= 0) continue;
                        oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.7f);
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else if (CFG.menus.getInManageDiplomacy()) {
            if (CFG.menus.getInManageDiplomacy_Pacts3()) {
                drawProvinces = new DrawProvinces(){

                    @Override
                    public void drawProvinces(SpriteBatch oSB) {
                        if (CFG.core.getActiveProvID() < 0 || CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == 0) {
                            if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 < 0) {
                                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                }
                            } else {
                                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1) {
                                        oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY);
                                    } else if (CFG.core.getCivNonAggressionPact(CFG.core.getProv(CFG.core.getPIV(i)).getCivId(), CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1) > 0) {
                                        oSB.setColor(CFG.getPactColor(CFG.core.getCivNonAggressionPact(CFG.core.getProv(CFG.core.getPIV(i)).getCivId(), CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1), CFG.ALPHA_DIPLOMACY));
                                    } else {
                                        int tempRelation = (int)CFG.core.getCivRelationOfCivB(CFG.core.getProv(CFG.core.getPIV(i)).getCivId(), CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1);
                                        if (tempRelation == 0) {
                                            oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                        } else {
                                            oSB.setColor(CFG.getRelationColor(tempRelation, CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f + CFG.ALPHA_DIPLOMACY * 2.0f / 5.0f * ((float)Math.abs(tempRelation) / 100.0f)));
                                        }
                                    }
                                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                }
                            }
                        } else {
                            for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY);
                                } else if (CFG.core.getCivNonAggressionPact(CFG.core.getProv(CFG.core.getPIV(i)).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) > 0) {
                                    oSB.setColor(CFG.getPactColor(CFG.core.getCivNonAggressionPact(CFG.core.getProv(CFG.core.getPIV(i)).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()), CFG.ALPHA_DIPLOMACY));
                                } else {
                                    int tempRelation = (int)CFG.core.getCivRelationOfCivB(CFG.core.getProv(CFG.core.getPIV(i)).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                                    if (tempRelation == 0) {
                                        oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                    } else {
                                        oSB.setColor(CFG.getRelationColor(tempRelation, CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f + CFG.ALPHA_DIPLOMACY * 2.0f / 5.0f * ((float)Math.abs(tempRelation) / 100.0f)));
                                    }
                                }
                                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                            }
                        }
                    }
                };
            } else if (CFG.menus.getInManageDiplomacy_Truces()) {
                drawProvinces = new DrawProvinces(){

                    @Override
                    public void drawProvinces(SpriteBatch oSB) {
                        if (CFG.core.getActiveProvID() < 0 || CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == 0) {
                            if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 < 0) {
                                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                }
                            } else {
                                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1) {
                                        oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY);
                                    } else if (CFG.core.getCivTruce(CFG.core.getProv(CFG.core.getPIV(i)).getCivId(), CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1) > 0) {
                                        oSB.setColor(CFG.getTruceColor(CFG.ALPHA_DIPLOMACY));
                                    } else {
                                        int tempRelation = (int)CFG.core.getCivRelationOfCivB(CFG.core.getProv(CFG.core.getPIV(i)).getCivId(), CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1);
                                        if (tempRelation == 0) {
                                            oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                        } else {
                                            oSB.setColor(CFG.getRelationColor(tempRelation, CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f + CFG.ALPHA_DIPLOMACY * 2.0f / 5.0f * ((float)Math.abs(tempRelation) / 100.0f)));
                                        }
                                    }
                                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                }
                            }
                        } else {
                            for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY);
                                } else if (CFG.core.getCivTruce(CFG.core.getProv(CFG.core.getPIV(i)).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) > 0) {
                                    oSB.setColor(CFG.getTruceColor(CFG.ALPHA_DIPLOMACY));
                                } else {
                                    int tempRelation = (int)CFG.core.getCivRelationOfCivB(CFG.core.getProv(CFG.core.getPIV(i)).getCivId(), CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                                    if (tempRelation == 0) {
                                        oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                    } else {
                                        oSB.setColor(CFG.getRelationColor(tempRelation, CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f + CFG.ALPHA_DIPLOMACY * 2.0f / 5.0f * ((float)Math.abs(tempRelation) / 100.0f)));
                                    }
                                }
                                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                            }
                        }
                    }
                };
            } else if (CFG.menus.getInManageDiplomacy_Guarantee()) {
                drawProvinces = new DrawProvinces(){

                    @Override
                    public void drawProvinces(SpriteBatch oSB) {
                        if (CFG.core.getActiveProvID() < 0 || CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == 0) {
                            if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 < 0) {
                                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                }
                            } else {
                                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1) {
                                        oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY);
                                    } else if (CFG.core.getGuarantee(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, CFG.core.getProv(CFG.core.getPIV(i)).getCivId()) > 0) {
                                        oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getB(), CFG.ALPHA_DIPLOMACY);
                                    } else {
                                        oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                    }
                                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                }
                            }
                        } else {
                            for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY);
                                } else if (CFG.core.getGuarantee(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), CFG.core.getProv(CFG.core.getPIV(i)).getCivId()) > 0) {
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getB(), CFG.ALPHA_DIPLOMACY);
                                } else {
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                }
                                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                            }
                        }
                    }
                };
            } else if (CFG.menus.getInManageDiplomacy_DefensivePact()) {
                drawProvinces = new DrawProvinces(){

                    @Override
                    public void drawProvinces(SpriteBatch oSB) {
                        if (CFG.core.getActiveProvID() < 0 || CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == 0) {
                            if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 < 0) {
                                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                }
                            } else {
                                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1) {
                                        oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY);
                                    } else if (CFG.core.getDefensivePact(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, CFG.core.getProv(CFG.core.getPIV(i)).getCivId()) > 0) {
                                        oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getB(), CFG.ALPHA_DIPLOMACY);
                                    } else {
                                        oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                    }
                                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                }
                            }
                        } else {
                            for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY);
                                } else if (CFG.core.getDefensivePact(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), CFG.core.getProv(CFG.core.getPIV(i)).getCivId()) > 0) {
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getB(), CFG.ALPHA_DIPLOMACY);
                                } else {
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                }
                                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                            }
                        }
                    }
                };
            } else if (CFG.menus.getInManageDiplomacy_MilitaryAccess()) {
                drawProvinces = new DrawProvinces(){

                    @Override
                    public void drawProvinces(SpriteBatch oSB) {
                        if (CFG.core.getActiveProvID() < 0 || CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == 0) {
                            if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 < 0) {
                                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                }
                            } else {
                                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1) {
                                        oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY);
                                    } else if (CFG.core.getMilitaryAccess(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1, CFG.core.getProv(CFG.core.getPIV(i)).getCivId()) > 0) {
                                        oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getB(), CFG.ALPHA_DIPLOMACY);
                                    } else {
                                        oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                    }
                                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                                }
                            }
                        } else {
                            for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                                if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                                if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()) {
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY);
                                } else if (CFG.core.getMilitaryAccess(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), CFG.core.getProv(CFG.core.getPIV(i)).getCivId()) > 0) {
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getB(), CFG.ALPHA_DIPLOMACY);
                                } else {
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                }
                                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                            }
                        }
                    }
                };
            } else if (CFG.menus.getInManageDiplomacy_Relations_Interactive()) {
                drawProvinces = new DrawProvinces(){

                    @Override
                    public void drawProvinces(SpriteBatch oSB) {
                        for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                            if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                            if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID) {
                                oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY);
                            } else {
                                int tempRelation = (int)CFG.core.getCivRelationOfCivB(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID, CFG.core.getProv(CFG.core.getPIV(i)).getCivId());
                                if (tempRelation == 0) {
                                    oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                                } else {
                                    oSB.setColor(CFG.getRelationColor(tempRelation, CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f + CFG.ALPHA_DIPLOMACY * 2.0f / 5.0f * ((float)Math.abs(tempRelation) / 100.0f)));
                                }
                            }
                            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        }
                    }
                };
            } else if (CFG.menus.getInGame_Timeline() || CFG.menus.getInVictory()) {
                drawProvinces = new DrawProvinces(){

                    @Override
                    public void drawProvinces(SpriteBatch oSB) {
                    }
                };
            } else if (CFG.menus.getInManageDiplomacy_Vassals()) {
                drawProvinces = new DrawProvinces(){

                    @Override
                    public void drawProvinces(SpriteBatch oSB) {
                        int nActiveCivID = 0;
                        if (CFG.core.getActiveProvID() >= 0) {
                            nActiveCivID = CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getPuppetOfCiv();
                        }
                        for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                            if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                            if (nActiveCivID == CFG.core.getProv(CFG.core.getPIV(i)).getCivId()) {
                                oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY);
                            } else if (nActiveCivID == CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getPuppetOfCiv()) {
                                oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getB(), CFG.ALPHA_DIPLOMACY);
                            } else {
                                oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                            }
                            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        }
                    }
                };
            } else if (CFG.menus.getInManageDiplomacy_Alliances()) {
                RenderProvince.updateDrawProvinces_ManageDiplomacyAlliances();
            } else {
                RenderProvince.updateDrawProvinces_Standard();
            }
        } else if (CFG.menus.getIn_CustomizeAlliance()) {
            RenderProvince.updateDrawProvinces_ManageDiplomacyAlliances();
        } else if (CFG.menus.getInMapEditor_Create_NewContinent()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    oSB.setColor(CFG.editor_Continent_GameData.getR(), CFG.editor_Continent_GameData.getG(), CFG.editor_Continent_GameData.getB(), 0.7f);
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else if (CFG.menus.getInMapEditor_Create_NewRegion()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    oSB.setColor(CFG.editor_Region_GameData.getR(), CFG.editor_Region_GameData.getG(), CFG.editor_Region_GameData.getB(), 0.45f);
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else if (CFG.menus.getInGameEditor_Create_DiplomacyPackage()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    oSB.setColor(CFG.menus.getColorPicker().getActiveColor().r, CFG.menus.getColorPicker().getActiveColor().g, CFG.menus.getColorPicker().getActiveColor().b, CFG.ALPHA_DIPLOMACY);
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else if (CFG.menus.getInCreateScenario_TechnologyLevels()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() <= 0) continue;
                        oSB.setColor(CFG.getTechnologyLevelColor((int)(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getTechLevel() * (float)CFG.getCreateScenario_TechnologyLevelsByContinents_Continent(CFG.core.getProv(CFG.core.getPIV(i)).getCivId() - 1, CFG.core.getProv(CFG.core.getPIV(i)).getRegion())), CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else if (CFG.menus.getInCreateScenario_Happiness()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() <= 0) continue;
                        oSB.setColor(CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getHappiness(), 100, 0.5f));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else if (CFG.menus.getInCreateScenario_StartingMoney()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        int tempMoney = (int)(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getGold() == -999999L ? (long)CFG.core.getGameScenars().getScenario_StartingMoney() : CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getGold());
                        if (tempMoney < 0) {
                            oSB.setColor(CFG.getColorStep(CFG.COLOR_STARTINGMONEY_0, CFG.COLOR_STARTINGMONEY_MIN, -tempMoney, 100000, CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL));
                        } else {
                            oSB.setColor(CFG.getColorStep(CFG.COLOR_STARTINGMONEY_0, CFG.COLOR_STARTINGMONEY_MAX, tempMoney, 100000, CFG.PROVINCE_ALPHA_TECHNOLOGY_LEVEL));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else if (CFG.menus.getInEditor_GameCivs()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    oSB.setColor((float)CFG.editorCivilization_GameData.getR() / 255.0f, (float)CFG.editorCivilization_GameData.getG() / 255.0f, (float)CFG.editorCivilization_GameData.getB() / 255.0f, CFG.ALPHA_DIPLOMACY);
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else if (CFG.menus.getInCreateCivilization()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    oSB.setColor((float)CFG.editorCivilization_GameData.getR() / 255.0f, (float)CFG.editorCivilization_GameData.getG() / 255.0f, (float)CFG.editorCivilization_GameData.getB() / 255.0f, CFG.ALPHA_DIPLOMACY);
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else if (CFG.menus.getInRandomGame()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                }
            };
        } else if (CFG.menus.getInGameEditor_TerrainAdd()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    oSB.setColor(CFG.editorTerrain_Data2.getColor().getR(), CFG.editorTerrain_Data2.getColor().getG(), CFG.editorTerrain_Data2.getColor().getB(), 0.55f);
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else if (CFG.menus.getInMapEditor_Terrain()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        oSB.setColor(CFG.terrainTypesManager.getColor(CFG.core.getProv(CFG.core.getPIV(i)).getTerrainTypeID()));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else if (CFG.menus.getInMapEditor_Continents()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        oSB.setColor(CFG.map.getMapContinents().getColor(CFG.core.getProv(CFG.core.getPIV(i)).getContinent()));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else if (CFG.menus.getInMapEditor_Regions()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        oSB.setColor(CFG.map.getMapRegions().getColor(CFG.core.getProv(CFG.core.getPIV(i)).getRegion()));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else if (CFG.menus.getInMapEditor_GrowthRate()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        oSB.setColor(CFG.getGrowthRateColor((int)(CFG.core.getProv(CFG.core.getPIV(i)).getGrowthRate_Pop() * 100.0f), 0.5f));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else if (CFG.menus.getInPrintAMap()) {
            drawProvinces = new DrawProvinces(){

                @Override
                public void drawProvinces(SpriteBatch oSB) {
                    oSB.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            };
        } else {
            RenderProvince.updateDrawProvinces_Standard();
        }
    }

    private static final void updateDrawProvinces_Standard() {
        drawProvinces = CFG.FOG_OF_WAR == 2 ? new DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int lastCivID = -1;
                boolean lastMet = false;
                for (int i = 0; i < CFG.core.sortedPIV.size(); ++i) {
                    int provinceID = CFG.core.sortedPIV.get(i);
                    Province province = CFG.core.getProv(provinceID);
                    boolean met = CFG.getMetProv(provinceID);
                    if (!met) {
                        if (lastMet || lastCivID == -1) {
                            float[] c = CFG.settingsGD.COLOR_DISCOVERY_FLOAT;
                            oSB.setColor(c[0], c[1], c[2], c[3]);
                        }
                        lastCivID = -2;
                    } else {
                        if (province.isColorAnimated()) {
                            province.setProvColor(oSB);
                            lastCivID = -1;
                        } else if (province.getCivId() != lastCivID || !lastMet) {
                            province.setCivilizationProvinceColor(oSB, province.getCivId());
                            lastCivID = province.getCivId();
                        }
                    }
                    province.drawLandProv(oSB);
                    lastMet = met;
                }
                RenderProvince.drawOccupiedProvinces_FogOfWar(oSB);
            }
        } : new DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int lastCivID = -1;
                for (int i = 0; i < CFG.core.sortedPIV.size(); ++i) {
                    int provinceID = CFG.core.sortedPIV.get(i);
                    Province province = CFG.core.getProv(provinceID);
                    int civID = province.getCivId();
                    if (civID == 0) continue;
                    if (province.isColorAnimated()) {
                        province.setProvColor(oSB);
                        lastCivID = -1;
                    } else if (civID != lastCivID) {
                        province.setCivilizationProvinceColor(oSB, civID);
                        lastCivID = civID;
                    }
                    province.drawLandProv(oSB);
                }
                RenderProvince.drawOccupiedProvinces(oSB);
            }
        };
    }

    private static final void updateDrawProvinces_ManageDiplomacyAlliances() {
        drawProvinces = new DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
                    if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance() == 0) {
                        oSB.setColor(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f);
                    } else {
                        oSB.setColor(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance()).getColorOfAlliance().getR(), CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance()).getColorOfAlliance().getG(), CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance()).getColorOfAlliance().getB(), CFG.ALPHA_DIPLOMACY * 1.25f);
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        };
    }

    public static final void drawProvinces(SpriteBatch oSB) {
        CFG.core.updateProvincesInView();
        for (int i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawWastelandProv(oSB);
        }
        int lastCivID = -1;
        for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            int provID = CFG.core.sortedPIV.get(i);
            Province province = CFG.core.getProv(provID);
            int civID = province.getCivId();
            if (civID == 0) continue;
            if (province.isColorAnimated()) {
                province.setProvColor(oSB);
                province.drawLandProv(oSB);
                lastCivID = -1;
            } else {
                if (civID != lastCivID) {
                    province.setCivilizationProvinceColor(oSB, civID);
                    lastCivID = civID;
                }
                province.drawLandProv(oSB);
            }
        }
    }

    public static final void drawOccupiedProvinces(SpriteBatch oSB) {
        oSB.setShader(AoCGame.shaderAlpha3);
        for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            Province province = CFG.core.getProv(CFG.core.getPIV(i));
            if (province.getCivId() == province.getTrueOwnerOfProv()) continue;
            province.drawOccupiedProv(oSB);
        }
        oSB.setShader(AoCGame.shaderDef);
    }

    public static final void drawOccupiedProvinces_FogOfWar(SpriteBatch oSB) {
        oSB.setShader(AoCGame.shaderAlpha3);
        for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            int provID = CFG.core.getPIV(i);
            Province province = CFG.core.getProv(provID);
            if (province.getCivId() == province.getTrueOwnerOfProv() || !CFG.getMetProv(provID)) continue;
            province.drawOccupiedProv(oSB);
        }
        oSB.setShader(AoCGame.shaderDef);
    }

    public static final void drawProvinces_NextPlayer_Turn(SpriteBatch oSB) {
        CFG.core.updateProvincesInView();
        int playerCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
        int lastCivID = -1;
        for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            Province province = CFG.core.getProv(CFG.core.getPIV(i));
            if (province.getCivId() != playerCivID) continue;
            if (province.isColorAnimated()) {
                province.setProvColor(oSB);
                lastCivID = -1;
            } else if (lastCivID != playerCivID) {
                province.setCivilizationProvinceColor(oSB, playerCivID);
                lastCivID = playerCivID;
            }
            province.drawLandProv(oSB);
        }
    }

    public static final void drawProvinces_CivilizationView(SpriteBatch oSB) {
        CFG.core.updateProvincesInView();
        int targetCivID = Menu_InGame_CivilizationView.iCivID;
        int lastCivID = -1;
        for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            Province province = CFG.core.getProv(CFG.core.getPIV(i));
            if (province.getCivId() != targetCivID) continue;
            if (province.isColorAnimated()) {
                province.setProvColor(oSB);
                lastCivID = -1;
            } else if (lastCivID != targetCivID) {
                province.setCivilizationProvinceColor(oSB, targetCivID);
                lastCivID = targetCivID;
            }
            province.drawLandProv(oSB);
        }
    }

    public static final void drawProvinces_CivilizationView_FogOfWar(SpriteBatch oSB) {
        CFG.core.updateProvincesInView();
        for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i)) || CFG.core.getProv(CFG.core.getPIV(i)).getCivId() != Menu_InGame_CivilizationView.iCivID) continue;
            CFG.core.getProv(CFG.core.getPIV(i)).setProvColor(oSB);
            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
        }
    }

    public static final void drawProvinces_FormableCiv(SpriteBatch oSB) {
        int i;
        CFG.core.updateProvincesInView();
        for (i = 0; i < CFG.formableCivs_GameData.getProvincesSize(); ++i) {
            if (!CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getDrawProv() || CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getWastelandLvl() >= 0) continue;
            if (CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getCivId() == CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCivId()) {
                CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).setProvColor(oSB);
            } else {
                oSB.setColor(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.85f);
            }
            CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).drawLandProv(oSB);
            CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).setDrawProv(false);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            if (CFG.core.getProv(CFG.core.getPIV(i)).getDrawProv() && CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCivId()) {
                CFG.core.getProv(CFG.core.getPIV(i)).setProvColor(oSB);
                oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.35f);
                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
            }
            CFG.core.getProv(CFG.core.getPIV(i)).setDrawProv(true);
        }
    }

    public static final void drawProvinces_FormableCiv_FogOfWarDiscovery(SpriteBatch oSB) {
        int i;
        CFG.core.updateProvincesInView();
        for (i = 0; i < CFG.formableCivs_GameData.getProvincesSize(); ++i) {
            if (!CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getDrawProv() || CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getWastelandLvl() >= 0) continue;
            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.formableCivs_GameData.getProvinceID(i)) && CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).getCivId() == CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCivId()) {
                CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).setProvColor(oSB);
            } else if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.formableCivs_GameData.getProvinceID(i))) {
                oSB.setColor(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.85f);
            } else {
                oSB.setColor(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.75f);
            }
            CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).drawLandProv(oSB);
            CFG.core.getProv(CFG.formableCivs_GameData.getProvinceID(i)).setDrawProv(false);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i)) && CFG.core.getProv(CFG.core.getPIV(i)).getDrawProv() && CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getCiv(CFG.MANAGE_DIPLOMACY_CUSTOMIZE_RELATIONS_CIV_ID).getCivId()) {
                oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.35f);
                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
            }
            CFG.core.getProv(CFG.core.getPIV(i)).setDrawProv(true);
        }
    }

    public static final void drawProvinces_LoadAI_RTO(SpriteBatch oSB) {
        CFG.core.updateProvincesInView();
        if (CFG.FOG_OF_WAR == 2) {
            for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
                CFG.core.getProv(CFG.core.getPIV(i)).setProvColor(oSB);
                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
            }
        } else {
            for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                if (!CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getIsPlayer()) continue;
                CFG.core.getProv(CFG.core.getPIV(i)).setProvColor(oSB);
                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
            }
        }
    }

    public static final void drawProvinces_Timeline(SpriteBatch oSB) {
        int i;
        CFG.core.updateProvincesInView();
        int lastCivID = -1;
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            int civID = CFG.timelapseManager.timelineOwners.get(CFG.core.getWPIV(i));
            if (civID <= 0) continue;
            if (civID != lastCivID) {
                CFG.core.getProv(CFG.core.getWPIV(i)).setCivilizationProvinceColor(oSB, civID);
                lastCivID = civID;
            }
            CFG.core.getProv(CFG.core.getWPIV(i)).drawLandProv(oSB);
        }
        lastCivID = -1;
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            int provID = CFG.core.getPIV(i);
            int civID = CFG.timelapseManager.timelineOwners.get(provID);
            if (civID <= 0) continue;
            if (civID != lastCivID) {
                CFG.core.getProv(provID).setCivilizationProvinceColor(oSB, civID);
                lastCivID = civID;
            }
            CFG.core.getProv(provID).drawLandProv(oSB);
        }
        oSB.setShader(AoCGame.shaderAlpha3);
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            if (!CFG.timelapseManager.timelineOwners_IsOccupied.get(CFG.core.getPIV(i)).booleanValue()) continue;
            CFG.core.getProv(CFG.core.getPIV(i)).drawOccupiedProv(oSB);
        }
        oSB.setShader(AoCGame.shaderDef);
    }

    public static final void drawProvinces_Timeline_FogOfWar(SpriteBatch oSB) {
        int i;
        CFG.core.updateProvincesInView();
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            if (CFG.timelapseManager.timelineOwners.get(CFG.core.getWPIV(i)) <= 0) continue;
            CFG.core.getProv(CFG.core.getWPIV(i)).setCivilizationProvinceColor(oSB, CFG.timelapseManager.timelineOwners.get(CFG.core.getWPIV(i)));
            CFG.core.getProv(CFG.core.getWPIV(i)).drawLandProv(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                if (CFG.timelapseManager.timelineOwners.get(CFG.core.getPIV(i)) <= 0) continue;
                CFG.core.getProv(CFG.core.getPIV(i)).setCivilizationProvinceColor(oSB, CFG.timelapseManager.timelineOwners.get(CFG.core.getPIV(i)));
                CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                continue;
            }
            oSB.setColor(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA);
            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
        }
        oSB.setShader(AoCGame.shaderAlpha3);
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            if (!CFG.timelapseManager.timelineOwners_IsOccupied.get(CFG.core.getPIV(i)).booleanValue()) continue;
            CFG.core.getProv(CFG.core.getPIV(i)).drawOccupiedProv(oSB);
        }
        oSB.setShader(AoCGame.shaderDef);
    }

    public static final void drawProvincesBorder_Timeline(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        if (CFG.map.getMapProvBorder(CFG.map.getActiveMapIDN())) {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorderTimeline(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorderTimeline(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorderTimeline_Classic(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorderTimeline_Classic(oSB);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_Timeline_OnlyCivilizationBorder(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        if (CFG.map.getMapProvBorder(CFG.map.getActiveMapIDN())) {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_Timeline_Only_CivilizationBorder(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_Timeline_Only_CivilizationBorder(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_Timeline_Only_CivilizationBorder_Classic(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_Timeline_Only_CivilizationBorder_Classic(oSB);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_PeaceTreaty(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        if (CFG.map.getMapProvBorder(CFG.map.getActiveMapIDN())) {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_PeaceTreaty_Wasteland(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_PeaceTreaty(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_PeaceTreaty_Wasteland_Classic(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_PeaceTreaty_Classic(oSB);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_PeaceTreaty_Only_CivilizationBorder(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        if (CFG.map.getMapProvBorder(CFG.map.getActiveMapIDN())) {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_PeaceTreaty_Wasteland(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_PeaceTreaty_Only_CivilizationBorder(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_PeaceTreaty_Wasteland_Classic(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_PeaceTreaty_Only_CivilizationBorder_Classic(oSB);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_PeaceTreaty_FogOfWarDiscovery(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        if (CFG.map.getMapProvBorder(CFG.map.getActiveMapIDN())) {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_PeaceTreaty_Wasteland(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_PeaceTreaty_FogOfWarDiscovery(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_PeaceTreaty_Wasteland_Classic(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_PeaceTreaty_FogOfWarDiscovery_Classic(oSB);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_PeaceTreaty_FogOfWarDiscovery_Only_CivilizationBorder(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        if (CFG.map.getMapProvBorder(CFG.map.getActiveMapIDN())) {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_PeaceTreaty_Wasteland(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_PeaceTreaty_FogOfWarDiscovery_Only_CivilizationBorder(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_PeaceTreaty_Wasteland_Classic(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_PeaceTreaty_FogOfWarDiscovery_Only_CivilizationBorder_Classic(oSB);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvinces_PeaceTreaty(SpriteBatch oSB) {
        int i;
        CFG.core.updateProvincesInView();
        int lastCivID = -1;
        float lastAlpha = -1.0f;
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            int provID = CFG.core.sortedPIV.get(i);
            Province province = CFG.core.getProv(provID);
            int civID = CFG.peaceTreatyData.drawProvOwners.get(provID).iCivID;
            if (civID == 0) continue;
            
            float currentAlpha;
            int drawCivID;
            if (civID < 0) {
                drawCivID = civID * -1;
                currentAlpha = (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.25f;
            } else {
                if (CFG.peaceTreatyData.drawProvOwners.get(provID).isToTake && CFG.peaceTreatyData.drawProvOwners.get(provID).isTaken <= 0) continue;
                drawCivID = civID;
                currentAlpha = drawCivID == 0 ? 0.039215688f : (float)CFG.settingsGD.PROV_ALPHA / 255.0f;
            }

            if (drawCivID != lastCivID || currentAlpha != lastAlpha) {
                province.setCivilizationProvinceColor(oSB, drawCivID, currentAlpha);
                lastCivID = drawCivID;
                lastAlpha = currentAlpha;
            }
            province.drawLandProv(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawWastelandProv_PeaceTreaty(oSB);
        }
        oSB.setShader(AoCGame.shaderAlpha3);
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            int provID = CFG.core.getPIV(i);
            if (!CFG.peaceTreatyData.drawProvOwners.get(provID).isToTake || CFG.peaceTreatyData.drawProvOwners.get(provID).isTaken >= 0) continue;
            CFG.core.getProv(provID).drawOccupiedProv(oSB);
        }
        oSB.setShader(AoCGame.shaderDef);
    }

    public static final void drawProvinces_PeaceTreaty_FogOfWarDiscovery(SpriteBatch oSB) {
        int i;
        CFG.core.updateProvincesInView();
        int lastCivID = -1;
        float lastAlpha = -1.0f;
        boolean lastMet = false;
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            int provID = CFG.core.sortedPIV.get(i);
            Province province = CFG.core.getProv(provID);
            boolean met = CFG.getMetProv(provID);
            if (met) {
                int civID = CFG.peaceTreatyData.drawProvOwners.get(provID).iCivID;
                if (civID == 0) continue;
                
                float currentAlpha;
                int drawCivID;
                if (civID < 0) {
                    drawCivID = civID * -1;
                    currentAlpha = (float)CFG.settingsGD.PROV_ALPHA / 255.0f * 0.25f;
                } else {
                    if (CFG.peaceTreatyData.drawProvOwners.get(provID).isToTake && CFG.peaceTreatyData.drawProvOwners.get(provID).isTaken <= 0) continue;
                    drawCivID = civID;
                    currentAlpha = drawCivID == 0 ? 0.039215688f : (float)CFG.settingsGD.PROV_ALPHA / 255.0f;
                }

                if (drawCivID != lastCivID || currentAlpha != lastAlpha || !lastMet) {
                    province.setCivilizationProvinceColor(oSB, drawCivID, currentAlpha);
                    lastCivID = drawCivID;
                    lastAlpha = currentAlpha;
                }
                province.drawLandProv(oSB);
            } else {
                if (lastMet || lastCivID == -1) {
                    float currentAlpha = CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA * ((float)CFG.startTheGameData.getProvincesAlpha() / (float)CFG.settingsGD.PROV_ALPHA);
                    float[] c = CFG.settingsGD.COLOR_DISCOVERY_FLOAT;
                    oSB.setColor(c[0], c[1], c[2], currentAlpha);
                    lastCivID = -2;
                }
                province.drawLandProv(oSB);
            }
            lastMet = met;
        }
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawWastelandProv_PeaceTreaty(oSB);
        }
        oSB.setShader(AoCGame.shaderAlpha3);
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            int provID = CFG.core.getPIV(i);
            if (!CFG.peaceTreatyData.drawProvOwners.get(provID).isToTake || CFG.peaceTreatyData.drawProvOwners.get(provID).isTaken >= 0) continue;
            CFG.core.getProv(provID).drawOccupiedProv(oSB);
        }
        oSB.setShader(AoCGame.shaderDef);
    }

    public static final void drawProvincesInCreateNewGameSelectAvailableCivs(SpriteBatch oSB) {
        int i;
        CFG.core.updateProvincesInView();
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawWastelandProv(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) continue;
            if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getIsAvailable()) {
                CFG.core.getProv(CFG.core.getPIV(i)).setProvColor(oSB);
            } else {
                oSB.setColor(0.0f, 0.0f, 0.0f, (float)CFG.settingsGD.PROV_ALPHA * 0.6f / 255.0f);
            }
            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
        }
    }

    public static final void drawProvincesInCreateRandomGame(SpriteBatch oSB) {
        int i;
        CFG.core.updateProvincesInView();
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawWastelandProv(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
        }
    }

    public static final void drawProvincesInGame(SpriteBatch oSB) {
        CFG.core.updateProvincesInView();
        RenderProvince.drawProvincesInGame_StandardWasteland_FogOFWar(oSB);
        drawProvinces.drawProvinces(oSB);
    }

    public static final void drawProvincesInGame_StandardWasteland(SpriteBatch oSB) {
        for (int i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawWastelandProv(oSB);
        }
    }

    public static final void drawProvincesInGame_StandardWasteland_FogOFWar(SpriteBatch oSB) {
        float[] c = CFG.settingsGD.COLOR_DISCOVERY_FLOAT;
        boolean colorSet = false;
        for (int i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            int provID = CFG.core.getWPIV(i);
            Province province = CFG.core.getProv(provID);
            if (CFG.getMetProv(provID)) {
                province.drawWastelandProv(oSB);
                colorSet = false;
            } else {
                if (!colorSet) {
                    oSB.setColor(c[0], c[1], c[2], c[3]);
                    colorSet = true;
                }
                province.drawLandProv(oSB);
            }
        }
    }

    public static final void drawProvinces_InLoad_PreDefinedBorders(SpriteBatch oSB) {
        CFG.core.updateProvincesInView();
        for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() != CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2) continue;
            CFG.core.getProv(CFG.core.getPIV(i)).setProvColor(oSB);
            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
        }
    }

    public static final void drawProvincesInMapEditor_Connections(SpriteBatch oSB) {
        int i;
        CFG.core.updateProvincesInView();
        oSB.setColor(1.0f, 1.0f, 1.0f, 0.1f);
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
        }
        oSB.setColor(1.0f, 1.0f, 1.0f, 0.4f);
        if (CFG.VIEW_SHOW_VALUES) {
            int j;
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                for (j = 0; j < CFG.core.getProv(CFG.core.getPIV(i)).getProvinceBordersLandByLandSize(); ++j) {
                    RenderProvince.drawProvincesInMapEditor_Connections_Line(oSB, Images.pix255, CFG.core.getPIV(i), CFG.core.getProv(CFG.core.getPIV(i)).getProvBordersLandByLand().get(j).getWithProvinceID());
                }
                for (j = 0; j < CFG.core.getProv(CFG.core.getPIV(i)).getProvinceBordersLandBySeaSize(); ++j) {
                    RenderProvince.drawProvincesInMapEditor_Connections_Line(oSB, Images.line33, CFG.core.getPIV(i), CFG.core.getProv(CFG.core.getPIV(i)).getProvBordersLandBySea().get(j).getWithProvinceID());
                }
            }
            for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
                for (j = 0; j < CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceBordersLandBySeaSize(); ++j) {
                    RenderProvince.drawProvincesInMapEditor_Connections_Line(oSB, Images.line33, CFG.core.getPSVI(i), CFG.core.getProv(CFG.core.getPSVI(i)).getProvBordersLandBySea().get(j).getWithProvinceID());
                }
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.25f);
                for (j = 0; j < CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceBordersSeaBySeaSize(); ++j) {
                    RenderProvince.drawProvincesInMapEditor_Connections_Line(oSB, Images.line33, CFG.core.getPSVI(i), CFG.core.getProv(CFG.core.getPSVI(i)).getProvBordersSeaBySea().get(j).getWithProvinceID());
                }
            }
        }
    }

    private static final void drawProvincesInMapEditor_Connections_Line(SpriteBatch oSB, int nImageID, int fromProvinceID, int toProvinceID) {
        if (!CFG.core.getProv(toProvinceID).getDrawProv()) {
            return;
        }
        int iWidth = (int)Math.ceil(Math.sqrt((CFG.core.getProv(toProvinceID).getCeX() + CFG.core.getProv(toProvinceID).getShPX() + CFG.core.getProv(toProvinceID).getTranslateProvPosX() - (CFG.core.getProv(fromProvinceID).getCeX() + CFG.core.getProv(fromProvinceID).getShPX() + CFG.core.getProv(fromProvinceID).getTranslateProvPosX())) * (CFG.core.getProv(toProvinceID).getCeX() + CFG.core.getProv(toProvinceID).getShPX() + CFG.core.getProv(toProvinceID).getTranslateProvPosX() - (CFG.core.getProv(fromProvinceID).getCeX() + CFG.core.getProv(fromProvinceID).getShPX() + CFG.core.getProv(fromProvinceID).getTranslateProvPosX())) + (CFG.core.getProv(fromProvinceID).getCeY() + CFG.core.getProv(fromProvinceID).getShPY() - (CFG.core.getProv(toProvinceID).getCeY() + CFG.core.getProv(toProvinceID).getShPY())) * (CFG.core.getProv(fromProvinceID).getCeY() + CFG.core.getProv(fromProvinceID).getShPY() - (CFG.core.getProv(toProvinceID).getCeY() + CFG.core.getProv(toProvinceID).getShPY()))));
        float fAngle = (float)(Math.atan2(CFG.core.getProv(fromProvinceID).getCeY() + CFG.core.getProv(fromProvinceID).getShPY() - (CFG.core.getProv(toProvinceID).getCeY() + CFG.core.getProv(toProvinceID).getShPY()), -(CFG.core.getProv(fromProvinceID).getCeX() + CFG.core.getProv(fromProvinceID).getShPX() + CFG.core.getProv(fromProvinceID).getTranslateProvPosX()) + (CFG.core.getProv(toProvinceID).getCeX() + CFG.core.getProv(toProvinceID).getShPX() + CFG.core.getProv(toProvinceID).getTranslateProvPosX())) * 180.0 / Math.PI);
        IMGManager.getIMG(nImageID).drawO(oSB, CFG.core.getProv(fromProvinceID).getCeX() + CFG.core.getProv(fromProvinceID).getShPX() + CFG.core.getProv(fromProvinceID).getTranslateProvPosX(), CFG.core.getProv(fromProvinceID).getCeY() + CFG.core.getProv(fromProvinceID).getShPY() + CFG.map.getMpC().getPY(), iWidth, IMGManager.getIMG(nImageID).getHeight(), fAngle, 0);
    }

    public static final void drawProvincesInMapEditor_SeaProvinces(SpriteBatch oSB) {
        int i;
        CFG.core.updateProvincesInView();
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            if (CFG.core.getProv(CFG.core.getWPIV(i)).getLvlOfPort() >= -1) {
                oSB.setColor(0.1254902f, 0.2901961f, 0.043137256f, 0.6f);
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProv_ActiveProv(oSB);
                continue;
            }
            if (CFG.core.getProv(CFG.core.getWPIV(i)).getLvlOfPort() == -1) {
                oSB.setColor(0.02745098f, 0.12941177f, 0.18431373f, 0.6f);
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProv_ActiveProv(oSB);
                continue;
            }
            oSB.setColor(0.007843138f, 0.09411765f, 0.13725491f, 0.6f);
            CFG.core.getProv(CFG.core.getWPIV(i)).drawProv_ActiveProv(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            if (CFG.core.getProv(CFG.core.getPIV(i)).getLvlOfPort() >= -1) {
                oSB.setColor(0.1254902f, 0.2901961f, 0.043137256f, 0.6f);
                CFG.core.getProv(CFG.core.getPIV(i)).drawProv_ActiveProv(oSB);
                continue;
            }
            if (CFG.core.getProv(CFG.core.getPIV(i)).getLvlOfPort() == -1) {
                oSB.setColor(0.02745098f, 0.12941177f, 0.18431373f, 0.6f);
                CFG.core.getProv(CFG.core.getPIV(i)).drawProv_ActiveProv(oSB);
                continue;
            }
            oSB.setColor(0.007843138f, 0.09411765f, 0.13725491f, 0.6f);
            CFG.core.getProv(CFG.core.getPIV(i)).drawProv_ActiveProv(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            if (CFG.core.getProv(CFG.core.getPSVI(i)).getLvlOfPort() >= -1) {
                oSB.setColor(0.1254902f, 0.2901961f, 0.043137256f, 0.6f);
                CFG.core.getProv(CFG.core.getPSVI(i)).drawProv_ActiveProv(oSB);
                continue;
            }
            if (CFG.core.getProv(CFG.core.getPSVI(i)).getLvlOfPort() == -1) {
                oSB.setColor(0.02745098f, 0.12941177f, 0.18431373f, 0.6f);
                CFG.core.getProv(CFG.core.getPSVI(i)).drawProv_ActiveProv(oSB);
                continue;
            }
            oSB.setColor(0.007843138f, 0.09411765f, 0.13725491f, 0.6f);
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProv_ActiveProv(oSB);
        }
    }

    public static final void drawProvincesInGameEditorRegions(SpriteBatch oSB) {
        int i;
        CFG.core.updateProvincesInView();
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            oSB.setColor(Menu_GameEditor_Regions.lColors.get(CFG.core.getRegionID(CFG.core.getWPIV(i))));
            CFG.core.getProv(CFG.core.getWPIV(i)).drawLandProv(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            oSB.setColor(Menu_GameEditor_Regions.lColors.get(CFG.core.getRegionID(CFG.core.getPIV(i))));
            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            oSB.setColor(Menu_GameEditor_Regions.lColors.get(CFG.core.getRegionID(CFG.core.getPSVI(i))));
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProv_ActiveProv(oSB);
        }
        if (CFG.core.getActiveProvID() >= 0) {
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.2f);
            IMGManager.getIMG(Images.pix255).drawO(oSB, CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinX() + CFG.map.getMpC().getPX(), CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinY() + CFG.map.getMpC().getPY(), CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMaxX() - CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinX(), CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMaxY() - CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinY());
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.6f);
            CFG.drawRect(oSB, CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinX() + CFG.map.getMpC().getPX(), CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinY() + CFG.map.getMpC().getPY(), CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMaxX() - CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinX(), CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMaxY() - CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinY());
            if (CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) {
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.2f);
                IMGManager.getIMG(Images.pix255).drawO(oSB, CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinX() + CFG.map.getMpC().getPX() + CFG.map.getMpB().getWidthM(), CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinY() + CFG.map.getMpC().getPY(), CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMaxX() - CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinX(), CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMaxY() - CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinY());
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.6f);
                CFG.drawRect(oSB, CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinX() + CFG.map.getMpC().getPX() + CFG.map.getMpB().getWidthM(), CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinY() + CFG.map.getMpC().getPY(), CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMaxX() - CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinX(), CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMaxY() - CFG.core.getRegions().get(CFG.core.getRegionID(CFG.core.getActiveProvID())).getMinY());
            }
        }
    }

    public static final void drawProvincesInMapEditor_ArmySeaBoxes(SpriteBatch oSB) {
        CFG.core.updateProvincesInView();
        if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv()) {
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.15f);
            IMGManager.getIMG(Images.pix255).drawO(oSB, CFG.core.getProv(CFG.core.getActiveProvID()).getMiX2() + CFG.map.getMpC().getPX(), CFG.core.getProv(CFG.core.getActiveProvID()).getMiY4() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.core.getActiveProvID()).getMaX7() - CFG.core.getProv(CFG.core.getActiveProvID()).getMiX2(), CFG.core.getProv(CFG.core.getActiveProvID()).getMaY6() - CFG.core.getProv(CFG.core.getActiveProvID()).getMiY4());
            oSB.setColor(CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.r, CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.g, CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.b, 0.8f);
            CFG.drawRect(oSB, CFG.core.getProv(CFG.core.getActiveProvID()).getMiX2() + CFG.map.getMpC().getPX(), CFG.core.getProv(CFG.core.getActiveProvID()).getMiY4() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.core.getActiveProvID()).getMaX7() - CFG.core.getProv(CFG.core.getActiveProvID()).getMiX2(), CFG.core.getProv(CFG.core.getActiveProvID()).getMaY6() - CFG.core.getProv(CFG.core.getActiveProvID()).getMiY4());
            if (CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) {
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.15f);
                IMGManager.getIMG(Images.pix255).drawO(oSB, CFG.core.getProv(CFG.core.getActiveProvID()).getMiX2() + CFG.map.getMpC().getPX() + CFG.map.getMpB().getWidthM(), CFG.core.getProv(CFG.core.getActiveProvID()).getMiY4() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.core.getActiveProvID()).getMaX7() - CFG.core.getProv(CFG.core.getActiveProvID()).getMiX2(), CFG.core.getProv(CFG.core.getActiveProvID()).getMaY6() - CFG.core.getProv(CFG.core.getActiveProvID()).getMiY4());
                oSB.setColor(CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.r, CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.g, CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.b, 0.8f);
                CFG.drawRect(oSB, CFG.core.getProv(CFG.core.getActiveProvID()).getMiX2() + CFG.map.getMpC().getPX() + CFG.map.getMpB().getWidthM(), CFG.core.getProv(CFG.core.getActiveProvID()).getMiY4() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.core.getActiveProvID()).getMaX7() - CFG.core.getProv(CFG.core.getActiveProvID()).getMiX2(), CFG.core.getProv(CFG.core.getActiveProvID()).getMaY6() - CFG.core.getProv(CFG.core.getActiveProvID()).getMiY4());
            }
        }
        for (int i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            if (CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes() == null) continue;
            for (int j = CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().size() - 1; j >= 0; --j) {
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.05f);
                IMGManager.getIMG(Images.pix255).drawO(oSB, CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX(), CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosX(), CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosY());
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.075f);
                CFG.drawRect(oSB, CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX(), CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosX(), CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosY());
                if (!CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) continue;
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.05f);
                IMGManager.getIMG(Images.pix255).drawO(oSB, CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX() + CFG.map.getMpB().getWidthM(), CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosX(), CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosY());
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.075f);
                CFG.drawRect(oSB, CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX() + CFG.map.getMpB().getWidthM(), CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosX(), CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.core.getPSVI(i)).getProvinceArmyBoxes().get(j).getStartPosY());
            }
        }
    }

    public static final void drawProvincesInMapEditor_ArmySeaBoxes_Edit(SpriteBatch oSB) {
        int j;
        CFG.core.updateProvincesInView();
        if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 >= 0 && CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getSeaProv()) {
            oSB.setColor(CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.r, CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.g, CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.b, 0.3f);
            CFG.drawRect(oSB, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiX2() + CFG.map.getMpC().getPX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiY4() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMaX7() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiX2(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMaY6() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiY4());
            if (CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) {
                oSB.setColor(CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.r, CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.g, CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.b, 0.3f);
                CFG.drawRect(oSB, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiX2() + CFG.map.getMpC().getPX() + CFG.map.getMpB().getWidthM(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiY4() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMaX7() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiX2(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMaY6() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiY4());
            }
        }
        if (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes() != null) {
            for (j = CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().size() - 1; j >= 0; --j) {
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.05f);
                IMGManager.getIMG(Images.pix255).drawO(oSB, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY());
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.075f);
                CFG.drawRect(oSB, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY());
                if (!CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) continue;
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.05f);
                IMGManager.getIMG(Images.pix255).drawO(oSB, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX() + CFG.map.getMpB().getWidthM(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY());
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.075f);
                CFG.drawRect(oSB, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX() + CFG.map.getMpB().getWidthM(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY());
            }
        }
        if (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes() != null) {
            for (j = CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().size() - 1; j >= 0; --j) {
                CFG.glyphLay.setText(CFG.fontMain.get(0), "" + (j + 1));
                CFG.drawTextDefault(oSB, "" + (j + 1), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX() + (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX()) / 2 - (int)CFG.glyphLay.width / 2, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY() + (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY()) / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2, new Color(1.0f, 1.0f, 1.0f, 0.4f));
                if (!CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) continue;
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesInMapEditor_ArmySeaBoxes_Add(SpriteBatch oSB) {
        int j;
        CFG.core.updateProvincesInView();
        if (CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 >= 0 && CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getSeaProv()) {
            oSB.setColor(CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.r, CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.g, CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.b, 0.3f);
            CFG.drawRect(oSB, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiX2() + CFG.map.getMpC().getPX(), -IMGManager.getIMG(Images.pix255).getHeight() + CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiY4() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMaX7() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiX2(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMaY6() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiY4());
            if (CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) {
                oSB.setColor(CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.r, CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.g, CFG.COLOR_PROVINCE_ACTIVE_PROVINCE_BORDER.b, 0.3f);
                CFG.drawRect(oSB, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiX2() + CFG.map.getMpC().getPX() + CFG.map.getMpB().getWidthM(), -IMGManager.getIMG(Images.pix255).getHeight() + CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiY4() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMaX7() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiX2(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMaY6() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getMiY4());
            }
        }
        if (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes() != null) {
            for (j = CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().size() - 1; j >= 0; --j) {
                if (j == CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2) continue;
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.05f);
                IMGManager.getIMG(Images.pix255).drawO(oSB, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX(), -IMGManager.getIMG(Images.pix255).getHeight() + CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY());
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.075f);
                CFG.drawRect(oSB, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX(), -IMGManager.getIMG(Images.pix255).getHeight() + CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY());
                if (!CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) continue;
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.05f);
                IMGManager.getIMG(Images.pix255).drawO(oSB, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX() + CFG.map.getMpB().getWidthM(), -IMGManager.getIMG(Images.pix255).getHeight() + CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY());
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.075f);
                CFG.drawRect(oSB, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX() + CFG.map.getMpB().getWidthM(), -IMGManager.getIMG(Images.pix255).getHeight() + CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX(), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY());
            }
        }
        if (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes() != null) {
            for (j = CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().size() - 1; j >= 0; --j) {
                if (j == CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2) continue;
                CFG.glyphLay.setText(CFG.fontMain.get(0), "" + (j + 1));
                CFG.drawTextDefault(oSB, "" + (j + 1), CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX() + (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX()) / 2 - (int)CFG.glyphLay.width / 2, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY() + (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY()) / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2, new Color(1.0f, 1.0f, 1.0f, 0.4f));
                if (!CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) continue;
                CFG.drawTextDefault(oSB, "" + (j + 1), CFG.map.getMpB().getWidthM() + CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX() + CFG.map.getMpC().getPX() + (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosX() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosX()) / 2 - (int)CFG.glyphLay.width / 2, CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY() + CFG.map.getMpC().getPY() + (CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getEndPosY() - CFG.core.getProv(CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1).getProvinceArmyBoxes().get(j).getStartPosY()) / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2, new Color(1.0f, 1.0f, 1.0f, 0.4f));
            }
        }
        if (Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY() >= 0 && Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPY() >= 0) {
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.15f);
            IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPX() + CFG.map.getMpC().getPX(), -IMGManager.getIMG(Images.pix255).getHeight() + Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY() + CFG.map.getMpC().getPY(), Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPX() - Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPX(), Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPY() - Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY());
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.45f);
            CFG.drawRect(oSB, Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPX() + CFG.map.getMpC().getPX(), -IMGManager.getIMG(Images.pix255).getHeight() + Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY() + CFG.map.getMpC().getPY(), Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPX() - Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPX(), Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPY() - Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY());
            if (CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) {
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.15f);
                IMGManager.getIMG(Images.pix255).drawO(oSB, CFG.map.getMpB().getWidthM() + Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPX() + CFG.map.getMpC().getPX(), -IMGManager.getIMG(Images.pix255).getHeight() + Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY() + CFG.map.getMpC().getPY(), Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPX() - Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPX(), Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPY() - Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY());
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.45f);
                CFG.drawRect(oSB, CFG.map.getMpB().getWidthM() + Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPX() + CFG.map.getMpC().getPX(), -IMGManager.getIMG(Images.pix255).getHeight() + Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY() + CFG.map.getMpC().getPY(), Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPX() - Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPX(), Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPY() - Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY());
            }
        }
        oSB.setColor(Color.RED);
        if (Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY() >= 0) {
            IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPX() + CFG.map.getMpC().getPX(), Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY() + CFG.map.getMpC().getPY());
            if (CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) {
                IMGManager.getIMG(Images.pix255).drawO(oSB, CFG.map.getMpB().getWidthM() + Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPX() + CFG.map.getMpC().getPX(), Menu_MapEditor_ArmySeaBoxes_Add.oFirstPoint.getPY() + CFG.map.getMpC().getPY());
            }
        }
        if (Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPY() >= 0) {
            IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPX() + CFG.map.getMpC().getPX(), Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPY() + CFG.map.getMpC().getPY());
            if (CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) {
                IMGManager.getIMG(Images.pix255).drawO(oSB, CFG.map.getMpB().getWidthM() + Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPX() + CFG.map.getMpC().getPX(), Menu_MapEditor_ArmySeaBoxes_Add.oSecondPoint.getPY() + CFG.map.getMpC().getPY());
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesInStartGame(SpriteBatch oSB) {
        CFG.core.updateProvincesInView();
        CFG.startTheGameData.updateData();
        for (int i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawWastelandProv(oSB, (float)CFG.startTheGameData.getWastelandAlpha() / 255.0f);
        }
        int lastCivID = -1;
        float lastAlpha = -1.0f;
        float capAlpha = (float)CFG.startTheGameData.getCapitalsAlpha() / 255.0f;
        float regAlpha = (float)CFG.startTheGameData.getProvincesAlpha() / 255.0f;
        for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            int provID = CFG.core.sortedPIV.get(i);
            Province province = CFG.core.getProv(provID);
            int civID = province.getCivId();
            if (civID == 0) continue;
            float currentAlpha = province.isCapital() ? capAlpha : regAlpha;
            if (civID != lastCivID || currentAlpha != lastAlpha) {
                province.setCivilizationProvinceColor(oSB, civID, currentAlpha);
                lastCivID = civID;
                lastAlpha = currentAlpha;
            }
            province.drawLandProv(oSB);
        }
    }

    public static final void drawProvincesInStartGame_FogOfWarDiscovery(SpriteBatch oSB) {
        int i;
        CFG.core.updateProvincesInView();
        CFG.startTheGameData.updateData();
        float discoAlpha = CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA * ((float)CFG.startTheGameData.getProvincesAlpha() / (float)CFG.settingsGD.PROV_ALPHA);
        float[] discoC = CFG.settingsGD.COLOR_DISCOVERY_FLOAT;
        boolean discoColorSet = false;
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            int provID = CFG.core.getWPIV(i);
            if (CFG.getMetProv(provID)) {
                CFG.core.getProv(provID).drawWastelandProv(oSB, (float)CFG.startTheGameData.getWastelandAlpha() / 255.0f);
                discoColorSet = false;
            } else {
                if (!discoColorSet) {
                    oSB.setColor(discoC[0], discoC[1], discoC[2], discoAlpha);
                    discoColorSet = true;
                }
                CFG.core.getProv(provID).drawLandProv(oSB);
            }
        }
        int lastCivID = -1;
        float lastAlpha = -1.0f;
        boolean lastMet = false;
        float capAlpha = (float)CFG.startTheGameData.getCapitalsAlpha() / 255.0f;
        float regAlpha = (float)CFG.startTheGameData.getProvincesAlpha() / 255.0f;
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            int provID = CFG.core.sortedPIV.get(i);
            Province province = CFG.core.getProv(provID);
            boolean met = CFG.getMetProv(provID);
            if (met) {
                int civID = province.getCivId();
                if (civID != 0) {
                    float currentAlpha = province.isCapital() ? capAlpha : regAlpha;
                    if (civID != lastCivID || currentAlpha != lastAlpha || !lastMet) {
                        province.setCivilizationProvinceColor(oSB, civID, currentAlpha);
                        lastCivID = civID;
                        lastAlpha = currentAlpha;
                    }
                    province.drawLandProv(oSB);
                }
            } else {
                if (lastMet || lastCivID == -1) {
                    oSB.setColor(discoC[0], discoC[1], discoC[2], discoAlpha);
                    lastCivID = -2;
                }
                province.drawLandProv(oSB);
            }
            lastMet = met;
        }
    }

    public static final void drawProvinces_PrintAMap(SpriteBatch oSB) {
        int i;
        CFG.core.updateProvincesInView();
        oSB.setColor(Color.WHITE);
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawLandProv(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
        }
    }

    public static final void drawProvincesIn_MapEditor_WastelandMaps(SpriteBatch oSB) {
        CFG.core.updateProvincesInView();
        for (int i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawWastelandProv(oSB);
        }
    }

    public static final void drawProvincesBorder(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinBorder(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPIV(i)).drawProvinBorder(oSB);
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_Only_CivilizationBorder(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_OnlyCivilizationBorder(oSB);
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_Only_CivilizationBorder_InGame(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_OnlyCivilizationBorder(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_OnlyCivilizationBorder(oSB);
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_Only_CivilizationBorder_InGame_AndSea(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_OnlyCivilizationBorder(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_OnlyCivilizationBorder(oSB);
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_Only_CivilizationBorder_Capitals(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_OnlyCivilizationBorder_Capitals(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_OnlyCivilizationBorder_Capitals(oSB);
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_Only_CivilizationBorder_Capitals_FogOfWarDiscovery(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        if (CFG.map.getMapProvBorder(CFG.map.getActiveMapIDN())) {
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_OnlyCivilizationBorder_Capitals_FogOfWarDiscovery(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_OnlyCivilizationBorder_Capitals_FogOfWarDiscoveryWasteland(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_OnlyCivilizationBorder_Capitals_FogOfWarDiscovery_Classic(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_OnlyCivilizationBorder_Capitals_FogOfWarDiscoveryWasteland(oSB);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_NextPlayer(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_NextPlayerTurn(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_NextPlayerTurn(oSB);
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_CivilizationView(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_CivilizationView(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_CivilizationView(oSB);
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_LoadAI_RTO(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        if (CFG.FOG_OF_WAR == 2) {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_LoadAI_RTO_FogOfWarDiscovery(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_LoadAI_RTO_FogOfWarDiscovery(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_LoadAI_RTO(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_LoadAI_RTO(oSB);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_TerrainMode(SpriteBatch oSB) {
        int i;
        if ((CFG.fTerrainMode_LinePercentage += (float)(System.currentTimeMillis() - CFG.lTerrainMode_LineTime) / 700.0f * 100.0f) > 100.0f) {
            CFG.fTerrainMode_LinePercentage = 100.0f;
        }
        CFG.lTerrainMode_LineTime = System.currentTimeMillis();
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        if (CFG.map.getMapProvBorder(CFG.map.getActiveMapIDN())) {
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_TerrainMode(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_TerrainMode_Classic(oSB);
            }
        }
    }

    public static final void drawProvincesBorder_ContinentMode(SpriteBatch oSB) {
        int i;
        if ((CFG.fTerrainMode_LinePercentage += (float)(System.currentTimeMillis() - CFG.lTerrainMode_LineTime) / 700.0f * 100.0f) > 100.0f) {
            CFG.fTerrainMode_LinePercentage = 100.0f;
        }
        CFG.lTerrainMode_LineTime = System.currentTimeMillis();
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        if (CFG.map.getMapProvBorder(CFG.map.getActiveMapIDN())) {
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_ContinentMode(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_ContinentModeWasteland(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_ContinentMode_Classic(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_ContinentModeWasteland_Classic(oSB);
            }
        }
    }

    public static final void drawProvincesBorder_ContinentMode_FogOfWarDiscovey(SpriteBatch oSB) {
        int i;
        if ((CFG.fTerrainMode_LinePercentage += (float)(System.currentTimeMillis() - CFG.lTerrainMode_LineTime) / 700.0f * 100.0f) > 100.0f) {
            CFG.fTerrainMode_LinePercentage = 100.0f;
        }
        CFG.lTerrainMode_LineTime = System.currentTimeMillis();
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        if (CFG.map.getMapProvBorder(CFG.map.getActiveMapIDN())) {
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_ContinentMode_FogOfWarDiscovery(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_ContinentModeWasteland(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_ContinentMode_FogOfWarDiscovery_Classic(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_ContinentModeWasteland_Classic(oSB);
            }
        }
    }

    public static final void drawProvincesBorder_RegionsMode(SpriteBatch oSB) {
        int i;
        if ((CFG.fTerrainMode_LinePercentage += (float)(System.currentTimeMillis() - CFG.lTerrainMode_LineTime) / 700.0f * 100.0f) > 100.0f) {
            CFG.fTerrainMode_LinePercentage = 100.0f;
        }
        CFG.lTerrainMode_LineTime = System.currentTimeMillis();
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        if (CFG.map.getMapProvBorder(CFG.map.getActiveMapIDN())) {
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_RegionMode(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_RegionModeWasteland(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_RegionMode_Classic(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_RegionModeWasteland_Classic(oSB);
            }
        }
    }

    public static final void drawProvincesBorder_RegionsMode_FogOfWarDiscovery(SpriteBatch oSB) {
        int i;
        if ((CFG.fTerrainMode_LinePercentage += (float)(System.currentTimeMillis() - CFG.lTerrainMode_LineTime) / 700.0f * 100.0f) > 100.0f) {
            CFG.fTerrainMode_LinePercentage = 100.0f;
        }
        CFG.lTerrainMode_LineTime = System.currentTimeMillis();
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        if (CFG.map.getMapProvBorder(CFG.map.getActiveMapIDN())) {
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_RegionMode_FogOfWarDiscovery(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_RegionModeWasteland(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_RegionMode_FogOfWarDiscovery_Classic(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_RegionModeWasteland_Classic(oSB);
            }
        }
    }

    public static final void drawProvincesBorderInStartGame(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinceBorderInStartGame(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorderInStartGame_Wasteland(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorderInStartGame(oSB);
        }
    }

    public static final void drawProvincesBorderInStartGame_FogOfWar(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinceBorderInStartGame(oSB);
        }
        if (GameCalendar.getColonizationOfWastelandIsEnabled()) {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorderInStartGame(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorderInStartGame_Wasteland(oSB);
            }
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorderInStartGame(oSB);
        }
    }

    public static final void drawLandProvincesBorder(SpriteBatch oSB) {
        for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPIV(i)).drawProvinBorder(oSB);
        }
    }

    public static final void drawProvincesBorder_PrintAMap(SpriteBatch oSB) {
        if (CFG.map.getMapProvBorder(CFG.map.getActiveMapIDN())) {
            int i;
            for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinceBorder_PrintAMap(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_PrintAMap(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_PrintAMap(oSB);
            }
        } else {
            int i;
            for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinceBorder_PrintAMap_Classic(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_PrintAMap_Classic(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_PrintAMap_Classic(oSB);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_CreateRandomGame(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        if (CFG.map.getMapProvBorder(CFG.map.getActiveMapIDN())) {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_CreateRandomGameWasteland(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_CreateRandomGame(oSB);
            }
        } else {
            for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_CreateRandomGameWasteland(oSB);
            }
            for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_CreateRandomGame(oSB);
            }
        }
        oSB.setColor(Color.WHITE);
    }

    public static final void drawProvincesBorder_DrawJustInnerBorder(SpriteBatch oSB) {
        int i;
        for (i = 0; i < CFG.NUM_OF_SEA_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPSVI(i)).drawProvinBorder(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_WASTELAND_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getWPIV(i)).drawProvinceBorder_CreateRandomGame(oSB);
        }
        for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
            CFG.core.getProv(CFG.core.getPIV(i)).drawProvinceBorder_CreateRandomGame(oSB);
        }
        oSB.setColor(Color.WHITE);
    }

    static {
        PROVINCE_COLOR_ANIMATION_TIMER = 0L;
    }

    public static interface DrawProvinces {
        public void drawProvinces(SpriteBatch var1);
    }
}

