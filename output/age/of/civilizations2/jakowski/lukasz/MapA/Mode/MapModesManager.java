
package age.of.civilizations2.jakowski.lukasz.MapA.Mode;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.HolyRomanEmpire_Manager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Distance;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapMode;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Vassal_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Religion_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Wonder;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_WonderBig;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Buildings.Menu_InGame_View_BArmoury;
import age.of.civilizations2.jakowski.lukasz.Menus.Buildings.Menu_InGame_View_BFarms;
import age.of.civilizations2.jakowski.lukasz.Menus.Buildings.Menu_InGame_View_BForts;
import age.of.civilizations2.jakowski.lukasz.Menus.Buildings.Menu_InGame_View_BLibrary;
import age.of.civilizations2.jakowski.lukasz.Menus.Buildings.Menu_InGame_View_BMarket;
import age.of.civilizations2.jakowski.lukasz.Menus.Buildings.Menu_InGame_View_BPort;
import age.of.civilizations2.jakowski.lukasz.Menus.Buildings.Menu_InGame_View_BSupply;
import age.of.civilizations2.jakowski.lukasz.Menus.Buildings.Menu_InGame_View_BTowers;
import age.of.civilizations2.jakowski.lukasz.Menus.Buildings.Menu_InGame_View_BWorkshop;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ;
import age.of.civilizations2.jakowski.lukasz.Menus.Population.Menu_InGame_View_PopulationCiv;
import age.of.civilizations2.jakowski.lukasz.Menus.Turn.Menu_NextPlayerTurn;
import age.of.civilizations2.jakowski.lukasz.Menus.Uncolonized.Menu_InGame_View_F;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.Province;
import age.of.civilizations2.jakowski.lukasz.ProvinceMesh;
import age.of.civilizations2.jakowski.lukasz.Render;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TechManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class MapModesManager {
    private List<MapMode> lMapModes = new ArrayList<MapMode>();
    private int iActiveMapModeID = -1;
    public static int VIEW_POPULATION_MODE = -1;
    public static int VIEW_POPULATION_OF_CIV_MODE = -1;
    public static int VIEW_DEATHS_IN_ALL_WARS_MODE = -1;
    public static int VIEW_ECONOMY_MODE = -1;
    public static int VIEW_POPULATION_CHANGE_MODE = -1;
    public static int VIEW_ECONOMY_CHANGE_MODE = -1;
    public static int VIEW_CONTINENT_MODE = -1;
    public static int VIEW_REGIONS_MODE = -1;
    public static int VIEW_TERRAIN_TYPE_MODE = -1;
    public static int VIEW_FANS_MODE = -1;
    public static int VIEW_HATERS_MODE = -1;
    public static int VIEW_GROWTH_RATE_MODE = -1;
    public static int VIEW_SUPPLIES_MODE = -1;
    public static int VIEW_DEVELOPMENT_MODE = -1;
    public static int VIEW_TECHNOLOGY_MODE = -1;
    public static int VIEW_DIPLOMACY_MODE = -1;
    public static int VIEW_PROVINCE_VALUE_MODE = -1;
    public static int VIEW_IDEOLOGIES_MODE = -1;
    public static int VIEW_DISTANCE_MODE = -1;
    public static int VIEW_INCOME_MODE = -1;
    public static int VIEW_INCOME_ALL_MODE = -1;
    public static int VIEW_INCOME_TAXATION_MODE = -1;
    public static int VIEW_INCOME_PRODUCTION_MODE = -1;
    public static int VIEW_HAPPINESS_MODE = -1;
    public static int VIEW_REVOLUTION_MODE = -1;
    public static int VIEW_PROVINCE_STABILITY_MODE = -1;
    public static int VIEW_ARMY_MODE = -1;
    public static int VIEW_CORES_MODE = -1;
    public static int VIEW_BUILDINGS_MODE = -1;
    public static int VIEW_LEVEL_OF_PORT_MODE = -1;
    public static int VIEW_LEVEL_OF_FORTIFICATIONS_MODE = -1;
    public static int VIEW_LEVEL_OF_WATCH_TOWER_MODE = -1;
    public static int VIEW_LEVEL_OF_FARM_MODE = -1;
    public static int VIEW_LEVEL_OF_LIBRARY_MODE = -1;
    public static int VIEW_LEVEL_OF_ARMOURY_MODE = -1;
    public static int VIEW_LEVEL_OF_MARKET_MODE = -1;
    public static int VIEW_LEVEL_OF_SUPPLY_MODE = -1;
    public static int VIEW_LEVEL_OF_WORKSHOP_MODE = -1;
    public static int VIEW_ALLIANCES_MODE = -1;
    public static int VIEW_IMPERIAL_MODE = -1;
    public static int VIEW_RECRUITABLE_ARMY_MODE = -1;
    public static int VIEW_AI_POTENTIAL_MODE = -1;
    public static int VIEW_AI_DANGER_MODE = -1;
    public static int VIEW_BALANCE_MODE = -1;
    public static int VIEW_TRUE_OWNERS_MODE = -1;
    public static int VIEW_DISEASES_MODE = -1;
    public static int VIEW_RELIGION_MODE = -1;
    public static int VIEW_WONDERS_MODE = -1;
    public static int VIEW_INVESTS_ECO_MODE = -1;
    public static int VIEW_INVESTS_DEV_MODE = -1;
    public static int VIEW_FESTIVALS_MODE = -1;
    public static int VIEW_ASSIMILATIONS_MODE = -1;
    public static int VIEW_WARS_MODE = -1;
    public boolean viewConfig = false;
    public static long POPULATION_MIN = 1L;
    public static long POPULATION_MAX = 1L;
    public static long DEATHS_MAX = 1L;
    public static int POPULATION_OF_CIVID = 0;
    public static long ECONOMY_MAX = 1L;

    public MapModesManager() {
        VIEW_DIPLOMACY_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.provinces, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        int nActiveCivID = 0;
                        nActiveCivID = CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && (CFG.FOG_OF_WAR != 2 || CFG.getMetProv(CFG.core.getActiveProvID())) ? CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() : CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0 && nActiveCivID != CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()) {
                            if ((int)CFG.core.getCivRelationOfCivB(nActiveCivID, CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()) == GameValues.gvDiplomacy.RELATION_AT_WAR) {
                                nData.add(new ME_Hover_2Type_Flag_Big(nActiveCivID, 0, 0));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), 0, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AtWar"), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 1.0f)));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            } else if (CFG.core.getCivsAreAllied(nActiveCivID, CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId())) {
                                nData.add(new ME_Hover_2Type_Flag_Big(nActiveCivID, 0, 0));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.diploAlliance, CFG.PADD, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), 0, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Ally")));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            } else if (CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getPuppetOfCiv() == nActiveCivID) {
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Vassal") + ": "));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Ideology_Vassal_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getIdeology(), CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getPuppetOfCiv(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            } else if (CFG.core.getCiv(nActiveCivID).getPuppetOfCiv() == CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()) {
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Lord") + ": "));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Ideology_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getIdeology(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == nActiveCivID) {
                                int nOpinion = (int)CFG.core.getCivRelationOfCivB(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), nActiveCivID);
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Opinion") + ": "));
                                nData.add(new ME_Hover_2Type_Text_Big((nOpinion > 0 ? "+" : "") + nOpinion, nOpinion > 0 ? CFG.COLOR_POSITIVE : (nOpinion == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_2)));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Flag_Big(nActiveCivID, CFG.PADD, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.getOpinion_String(nOpinion), nOpinion > 0 ? CFG.COLOR_POSITIVE : (nOpinion == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_2)));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            } else {
                                int nOpinion = (int)CFG.core.getCivRelationOfCivB(nActiveCivID, CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId());
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Opinion") + ": "));
                                nData.add(new ME_Hover_2Type_Text_Big((nOpinion > 0 ? "+" : "") + nOpinion, nOpinion > 0 ? CFG.COLOR_POSITIVE : (nOpinion == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_2)));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Flag_Big(nActiveCivID, CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.getOpinion_String(nOpinion), nOpinion > 0 ? CFG.COLOR_POSITIVE : (nOpinion == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_2)));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            if (CFG.core.getCivTruce(nActiveCivID, CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()) > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(nActiveCivID, 0, 0));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.diploTruce, CFG.PADD, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), 0, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Truce")));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            if (CFG.core.getDefensivePact(nActiveCivID, CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()) > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(nActiveCivID, 0, 0));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.diploDefensivePact, CFG.PADD, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), 0, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DefensivePact")));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            if (CFG.core.getCivNonAggressionPact(nActiveCivID, CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()) > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(nActiveCivID, 0, 0));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.diploDefensivePact, CFG.PADD, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), 0, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("NonAggressionPact")));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            if (CFG.core.getGuarantee(nActiveCivID, CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()) > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(nActiveCivID));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("GuaranteeTheirIndependence")));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.diploGuaranteeGives, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            if (CFG.core.getGuarantee(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), nActiveCivID) > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("GuaranteeIndependence")));
                                nData.add(new ME_Hover_2Type_Flag_Big(nActiveCivID, CFG.PADD, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(nActiveCivID).getCivName(), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.diploGuaranteeHas, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            if (CFG.core.getMilitaryAccess(nActiveCivID, CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()) > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(nActiveCivID));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("HaveMilitaryAccess")));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            if (CFG.core.getMilitaryAccess(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), nActiveCivID) > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(nActiveCivID));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("GivesMilitaryAccess")));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                        }
                        try {
                            if (nElements.size() == 2) {
                                nElements.remove(1);
                            }
                        }
                        catch (Exception exception) {}
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                if (CFG.chooseProvinceMode) {
                    CFG.core.resetChooseProvinceData();
                }
                CFG.core.updateActiveProvinceBorder_Style();
                if (CFG.menus.getInGameView() && (!CFG.menus.getVisible_InGame_CivInfo() || Menu_InGame_Civ.hideAnimation)) {
                    CFG.menus.setVisible_InGame_CivInfo(true);
                }
                if (CFG.getActiveCivInfoId() > 0) {
                    if (CFG.FOG_OF_WAR == 2) {
                        CFG.core.enableDrawCivilizationRegions_FogOfWar(CFG.getActiveCivInfoId(), 0);
                    } else {
                        CFG.core.enableDrawCivilizationRegions(CFG.getActiveCivInfoId(), 0);
                    }
                }
            }

            @Override
            public void disableViewAction() {
                CFG.core.updateActiveProvinceBorder_Style();
                CFG.core.disableDrawCivilizationRegions_Active();
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_CivInfo()) {
                    CFG.menus.setVisible_InGame_CivInfo(false);
                }
                if (CFG.core.getActiveProvID() >= 0 && !CFG.chooseProvinceMode && CFG.chosenProvinceID < 0) {
                    int tempAct = CFG.core.getActiveProvID();
                    CFG.core.setActiveProvID(-1);
                    CFG.core.setActiveProvID(tempAct);
                }
            }

            @Override
            public void updateActiveCivInfo_ExtraAction(int newCivID) {
                CFG.core.disableDrawCivilizationRegions_Active();
                if (newCivID > 0) {
                    if (CFG.FOG_OF_WAR == 2) {
                        CFG.core.enableDrawCivilizationRegions_FogOfWar(newCivID, 0);
                    } else {
                        CFG.core.enableDrawCivilizationRegions(newCivID, 0);
                    }
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                RenderProvince.drawOccupiedProvinces_FogOfWar(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                } else {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                RenderProvince.drawOccupiedProvinces(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_Just_OnlyCapitalMode(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, CFG.map.getMpS().getCurrSc());
                } else {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int nActiveCivID = CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.getMetProv(CFG.core.getActiveProvID()) ? CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() : CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                int lastCivID = -1;
                boolean lastMet = false;
                float[] discoC = CFG.settingsGD.COLOR_DISCOVERY_FLOAT;
                for (int i = 0; i < CFG.core.sortedPIV.size(); ++i) {
                    int provinceID = CFG.core.sortedPIV.get(i);
                    Province province = CFG.core.getProv(provinceID);
                    boolean met = CFG.getMetProv(provinceID);
                    if (met) {
                        int civID = province.getCivId();
                        if (civID > 0) {
                            if (civID != lastCivID || !lastMet) {
                                if (civID == nActiveCivID) {
                                    oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY));
                                } else if ((int)CFG.core.getCivRelationOfCivB(nActiveCivID, civID) == GameValues.gvDiplomacy.RELATION_AT_WAR) {
                                    oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), CFG.ALPHA_DIPLOMACY));
                                } else if (CFG.core.getCiv(civID).getPuppetOfCiv() == nActiveCivID) {
                                    oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getB(), CFG.ALPHA_DIPLOMACY));
                                } else if (CFG.core.getCiv(nActiveCivID).getPuppetOfCiv() == civID) {
                                    oSB.setColor(CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getB(), CFG.ALPHA_DIPLOMACY), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY), 50, 100, CFG.ALPHA_DIPLOMACY));
                                } else if (CFG.core.getCiv(nActiveCivID).getAlliance() > 0 && CFG.core.getCiv(civID).getAlliance() == CFG.core.getCiv(nActiveCivID).getAlliance()) {
                                    oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB(), CFG.ALPHA_DIPLOMACY));
                                } else if (CFG.core.getCivTruce(nActiveCivID, civID) > 0) {
                                    oSB.setColor(CFG.getTruceColor(CFG.ALPHA_DIPLOMACY));
                                } else if (CFG.core.getDefensivePact(nActiveCivID, civID) > 0) {
                                    oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getB(), CFG.ALPHA_DIPLOMACY));
                                } else if (CFG.core.getGuarantee(nActiveCivID, civID) > 0) {
                                    oSB.setColor(CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getB(), CFG.ALPHA_DIPLOMACY), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY), 50, 100, CFG.ALPHA_DIPLOMACY));
                                } else if (CFG.core.getGuarantee(civID, nActiveCivID) > 0) {
                                    oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getB(), CFG.ALPHA_DIPLOMACY));
                                } else if (CFG.core.getCivNonAggressionPact(civID, nActiveCivID) > 0) {
                                    oSB.setColor(CFG.getPactColor(CFG.core.getCivNonAggressionPact(civID, nActiveCivID), CFG.ALPHA_DIPLOMACY));
                                } else if (CFG.core.getMilitaryAccess(nActiveCivID, civID) > 0) {
                                    oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getB(), CFG.ALPHA_DIPLOMACY));
                                } else {
                                    int tempRelation = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == nActiveCivID ? (int)CFG.core.getCivRelationOfCivB(civID, nActiveCivID) : (int)CFG.core.getCivRelationOfCivB(nActiveCivID, civID);
                                    if ((tempRelation = Math.min(tempRelation, 99)) == 0) {
                                        oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f));
                                    } else {
                                        oSB.setColor(CFG.getRelationColor(tempRelation, CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f + CFG.ALPHA_DIPLOMACY * 2.0f / 5.0f * ((float)Math.abs(tempRelation) / 100.0f)));
                                    }
                                }
                                lastCivID = civID;
                            }
                            province.drawLandProv(oSB);
                        }
                    } else {
                        if (lastMet || lastCivID == -1) {
                            oSB.setColor(discoC[0], discoC[1], discoC[2], discoC[3]);
                            lastCivID = -2;
                        }
                        province.drawLandProv(oSB);
                    }
                    lastMet = met;
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int nActiveCivID = CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 ? CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() : CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                int lastCivID = -1;
                for (int i = 0; i < CFG.core.sortedPIV.size(); ++i) {
                    int provinceID = CFG.core.sortedPIV.get(i);
                    Province province = CFG.core.getProv(provinceID);
                    int civID = province.getCivId();
                    if (civID <= 0) continue;
                    if (civID != lastCivID) {
                        if (civID == nActiveCivID) {
                            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY));
                        } else if ((int)CFG.core.getCivRelationOfCivB(nActiveCivID, civID) == GameValues.gvDiplomacy.RELATION_AT_WAR) {
                            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), CFG.ALPHA_DIPLOMACY));
                        } else if (CFG.core.getCiv(civID).getPuppetOfCiv() == nActiveCivID) {
                            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getB(), CFG.ALPHA_DIPLOMACY));
                        } else if (CFG.core.getCiv(nActiveCivID).getPuppetOfCiv() == civID) {
                            oSB.setColor(CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_VASSAL.getB(), CFG.ALPHA_DIPLOMACY), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY), 50, 100, CFG.ALPHA_DIPLOMACY));
                        } else if (CFG.core.getCiv(nActiveCivID).getAlliance() > 0 && CFG.core.getCiv(civID).getAlliance() == CFG.core.getCiv(nActiveCivID).getAlliance()) {
                            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_ALLIANCE.getB(), CFG.ALPHA_DIPLOMACY));
                        } else if (CFG.core.getCivTruce(nActiveCivID, civID) > 0) {
                            oSB.setColor(CFG.getTruceColor(CFG.ALPHA_DIPLOMACY));
                        } else if (CFG.core.getDefensivePact(nActiveCivID, civID) > 0) {
                            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_DEFENSIVE_PACT.getB(), CFG.ALPHA_DIPLOMACY));
                        } else if (CFG.core.getGuarantee(nActiveCivID, civID) > 0) {
                            oSB.setColor(CFG.getColorStep(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getB(), CFG.ALPHA_DIPLOMACY), new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_OWN_PROVINCES.getB(), CFG.ALPHA_DIPLOMACY), 50, 100, CFG.ALPHA_DIPLOMACY));
                        } else if (CFG.core.getGuarantee(civID, nActiveCivID) > 0) {
                            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_INDEPENDENCE.getB(), CFG.ALPHA_DIPLOMACY));
                        } else if (CFG.core.getCivNonAggressionPact(civID, nActiveCivID) > 0) {
                            oSB.setColor(CFG.getPactColor(CFG.core.getCivNonAggressionPact(civID, nActiveCivID), CFG.ALPHA_DIPLOMACY));
                        } else if (CFG.core.getMilitaryAccess(nActiveCivID, civID) > 0) {
                            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_MILITARY_ACCESS.getB(), CFG.ALPHA_DIPLOMACY));
                        } else {
                            int tempRelation = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == nActiveCivID ? (int)CFG.core.getCivRelationOfCivB(civID, nActiveCivID) : (int)CFG.core.getCivRelationOfCivB(nActiveCivID, civID);
                            if ((tempRelation = Math.min(tempRelation, 99)) == 0) {
                                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f));
                            } else {
                                oSB.setColor(CFG.getRelationColor(tempRelation, CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f + CFG.ALPHA_DIPLOMACY * 2.0f / 5.0f * ((float)Math.abs(tempRelation) / 100.0f)));
                            }
                        }
                        lastCivID = civID;
                    }
                    province.drawLandProv(oSB);
                }
            }
        });
        VIEW_POPULATION_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getPop().getPops()), CFG.COLOR_POPULATION));
                        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updateMaxPopulation();
                RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER = System.currentTimeMillis();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_View(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_View(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                int newCivID;
                int oldCivID;
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats() && (oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince)) != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                    CFG.menus.setVisible_InGame_View(true);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_Just(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_Just(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int lastColorIndex = -1;
                boolean lastMet = false;
                float[] discoC = CFG.settingsGD.COLOR_DISCOVERY_FLOAT;
                for (int i = 0; i < CFG.core.sortedPIV.size(); ++i) {
                    int provinceID = CFG.core.sortedPIV.get(i);
                    Province province = CFG.core.getProv(provinceID);
                    boolean met = CFG.getMetProv(provinceID);
                    if (met) {
                        int colorIndex = (int)(province.getPop().getPops() / POPULATION_MAX * 100.0f);
                        colorIndex = Math.min(100, Math.max(0, colorIndex));
                        if (colorIndex != lastColorIndex || !lastMet) {
                            oSB.setColor(CFG.POP_COLORS_CACHE[colorIndex]);
                            lastColorIndex = colorIndex;
                        }
                    } else {
                        if (lastMet || lastColorIndex == -1) {
                            oSB.setColor(discoC[0], discoC[1], discoC[2], discoC[3]);
                            lastColorIndex = -2;
                        }
                    }
                    province.drawLandProv(oSB);
                    lastMet = met;
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int lastColorIndex = -1;
                for (int i = 0; i < CFG.core.sortedPIV.size(); ++i) {
                    int provinceID = CFG.core.sortedPIV.get(i);
                    Province province = CFG.core.getProv(provinceID);
                    int colorIndex = (int)(province.getPop().getPops() / POPULATION_MAX * 100.0f);
                    colorIndex = Math.min(100, Math.max(0, colorIndex));
                    if (colorIndex != lastColorIndex) {
                        oSB.setColor(CFG.POP_COLORS_CACHE[colorIndex]);
                        lastColorIndex = colorIndex;
                    }
                    province.drawLandProv(oSB);
                }
            }
        });
        VIEW_DEATHS_IN_ALL_WARS_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DeathsInAllWars") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)CFG.core.getProv((int)CFG.menus.getHoveredProvinceID()).getCivId()).civGD.ttWC), CFG.COLOR_NEGATIVE_2));
                            nData.add(new ME_Hover_2Type_Image(Images.skull, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updateMaxDeaths();
                RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER = System.currentTimeMillis();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewDeathsInAllWars(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewDeathsInAllWars(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_Just(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_Just(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                if (RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER + (long)GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL <= System.currentTimeMillis()) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.getMetProv(CFG.core.getPIV(i))) {
                            oSB.setColor(CFG.getWarDeathsColor((int)((float)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).civGD.ttWC / (float)DEATHS_MAX * 100.0f), 0.5f));
                            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                            continue;
                        }
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                } else {
                    int tempStepID = Math.min((int)(System.currentTimeMillis() - RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER), GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL);
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.getMetProv(CFG.core.getPIV(i))) {
                            oSB.setColor(CFG.getColorStep_WithAlpha(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getRGB((float)CFG.settingsGD.PROV_ALPHA / 255.0f), CFG.getWarDeathsColor((int)((float)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).civGD.ttWC / (float)DEATHS_MAX * 100.0f), 0.5f), tempStepID, GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL));
                            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                            continue;
                        }
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                    CFG.setRenderO(true);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                if (RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER + (long)GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL <= System.currentTimeMillis()) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        oSB.setColor(CFG.getWarDeathsColor((int)((float)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).civGD.ttWC / (float)DEATHS_MAX * 100.0f), 0.5f));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                } else {
                    int tempStepID = Math.min((int)(System.currentTimeMillis() - RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER), GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL);
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        oSB.setColor(CFG.getColorStep_WithAlpha(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getRGB((float)CFG.settingsGD.PROV_ALPHA / 255.0f), CFG.getWarDeathsColor((int)((float)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).civGD.ttWC / (float)DEATHS_MAX * 100.0f), 0.5f), tempStepID, GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                    CFG.setRenderO(true);
                }
            }
        });
        VIEW_CORES_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getCivsSize() > 0) {
                            int i;
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Cores") + ": ", CFG.COLOR_HOVER_TITLE));
                            for (i = 0; i < CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getCivsSize(); ++i) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getCivID(i), 0, 0));
                            }
                            nData.add(new ME_Hover_2Type_Image_Big(Images.core, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            for (i = 0; i < CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getCivsSize(); ++i) {
                                nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getCivID(i)));
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ConsideredAsItsCoreProvinceSince", GameCalendar.getDate_ByTurnID(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getSinceTurnID(i)))));
                                nData.add(new ME_Hover_2Type_Text(" [" + CFG.lang.get("Turn") + ": " + CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getSinceTurnID(i) + "]", CFG.COLOR_NEUTRAL));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            for (i = 0; i < CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getOwnership_CivsSize(); ++i) {
                                if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getHaveACore(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getOwnership_CivID(i))) continue;
                                nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getOwnership_CivID(i)));
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CoreConstruction") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + Math.min((int)((float)CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getOwnership_NumOfTurns(i) / (float)CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getNumOfTurnsOwnershipToGetACore() * 100.0f), 99) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nData.add(new ME_Hover_2Type_Text(" " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + Math.max(1, CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getNumOfTurnsOwnershipToGetACore() - CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_NumOfTurns(i))), CFG.COLOR_NEUTRAL));
                                nData.add(new ME_Hover_2Type_Text(" [" + CFG.lang.get("TurnsX", Math.max(1, CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getNumOfTurnsOwnershipToGetACore() - CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_NumOfTurns(i))) + "]", CFG.COLOR_TEXT_RANK_HOVER));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getOwnership_CivsSize() > 0) {
                            for (int i = 0; i < CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getOwnership_CivsSize(); ++i) {
                                if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getHaveACore(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getOwnership_CivID(i))) continue;
                                nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getOwnership_CivID(i)));
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CoreConstruction") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + Math.min((int)((float)CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getOwnership_NumOfTurns(i) / (float)CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCores().getNumOfTurnsOwnershipToGetACore() * 100.0f), 99) + "%", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nData.add(new ME_Hover_2Type_Text(" " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + Math.max(1, CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getNumOfTurnsOwnershipToGetACore() - CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_NumOfTurns(i))), CFG.COLOR_NEUTRAL));
                                nData.add(new ME_Hover_2Type_Text(" [" + CFG.lang.get("TurnsX", Math.max(1, CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getNumOfTurnsOwnershipToGetACore() - CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCores().getOwnership_NumOfTurns(i))) + "]", CFG.COLOR_TEXT_RANK_HOVER));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                        } else {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("NoCores"), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Flag_Big(0, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
            }

            @Override
            public void setActiveProvinceAction() {
                try {
                    if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() != CFG.getActiveCivInfoId()) {
                        if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() == 0) {
                            CFG.setActiveCivInfoId(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        } else {
                            CFG.setActiveCivInfoId(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId());
                        }
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_Just(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int nActiveCivID = 0;
                nActiveCivID = CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && (CFG.FOG_OF_WAR != 2 || CFG.getMetProv(CFG.core.getActiveProvID())) ? CFG.getActiveCivInfoId() : CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.getMetProv(CFG.core.getPIV(i))) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCores().getHaveACore(nActiveCivID)) {
                            oSB.setColor(new Color((float)CFG.core.getCiv(nActiveCivID).getR() / 255.0f, (float)CFG.core.getCiv(nActiveCivID).getG() / 255.0f, (float)CFG.core.getCiv(nActiveCivID).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f));
                        } else if (CFG.core.getProv(CFG.core.getPIV(i)).getCores().getHaveOwnership(nActiveCivID)) {
                            oSB.setColor(new Color((float)CFG.core.getCiv(nActiveCivID).getR() / 255.0f, (float)CFG.core.getCiv(nActiveCivID).getG() / 255.0f, (float)CFG.core.getCiv(nActiveCivID).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * Math.min((float)CFG.core.getProv(CFG.core.getPIV(i)).getCores().getNumOfOwnership(nActiveCivID) / (float)CFG.core.getProv(CFG.core.getPIV(i)).getCores().getNumOfTurnsOwnershipToGetACore(), 1.0f)));
                        } else {
                            oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                        }
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int nActiveCivID = 0;
                nActiveCivID = CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && (CFG.FOG_OF_WAR != 2 || CFG.getMetProv(CFG.core.getActiveProvID())) ? CFG.getActiveCivInfoId() : CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCores().getHaveACore(nActiveCivID)) {
                        oSB.setColor(new Color((float)CFG.core.getCiv(nActiveCivID).getR() / 255.0f, (float)CFG.core.getCiv(nActiveCivID).getG() / 255.0f, (float)CFG.core.getCiv(nActiveCivID).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f));
                    } else if (CFG.core.getProv(CFG.core.getPIV(i)).getCores().getHaveOwnership(nActiveCivID)) {
                        oSB.setColor(new Color((float)CFG.core.getCiv(nActiveCivID).getR() / 255.0f, (float)CFG.core.getCiv(nActiveCivID).getG() / 255.0f, (float)CFG.core.getCiv(nActiveCivID).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f * Math.min((float)CFG.core.getProv(CFG.core.getPIV(i)).getCores().getNumOfOwnership(nActiveCivID) / (float)CFG.core.getProv(CFG.core.getPIV(i)).getCores().getNumOfTurnsOwnershipToGetACore(), 1.0f)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_ALLIANCES_MODE = this.addViewToTheGame(new MapMode(){

            
            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getAlliance() <= 0) return null;
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getAlliance()).getAllianceName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Formation") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + GameCalendar.getDate_ByTurnID(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getAlliance()).getFormationTurnID()), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Members") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getAlliance()).getCivilizationsSize(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updateMaxPopulation();
                RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER = System.currentTimeMillis();
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllianceMode_FlagAndCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_AlliancesMode_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawAllianceMode_FlagAndCrown_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllianceMode_FlagAndCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_AlliancesMode(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawAllianceMode_FlagAndCrown(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i)) && CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance() > 0) {
                        oSB.setColor(new Color(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance()).getColorOfAlliance().getR(), CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance()).getColorOfAlliance().getG(), CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance()).getColorOfAlliance().getB(), CFG.ALPHA_DIPLOMACY));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance() > 0) {
                        oSB.setColor(new Color(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance()).getColorOfAlliance().getR(), CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance()).getColorOfAlliance().getG(), CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance()).getColorOfAlliance().getB(), CFG.ALPHA_DIPLOMACY));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_SUPPLIES_MODE = this.addViewToTheGame(new MapMode(){

            
            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivsSize() > 1 && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(CFG.menus.getHoveredProvinceID())) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            for (int i = 1; i < CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivsSize(); ++i) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(i)));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(i)).getCivName()));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            return new ME_Hover_v2(nElements);
                        } else {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) return null;
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        return new ME_Hover_v2(nElements);
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_Just(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() > 0 && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getIsSupplied()) {
                            oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f));
                        } else {
                            oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, CFG.ALPHA_DIPLOMACY));
                        }
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() > 0) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getIsSupplied()) {
                            oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f));
                        } else {
                            oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, CFG.ALPHA_DIPLOMACY));
                        }
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_INCOME_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getPuppetOfCiv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getProvName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Taxation") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvIncomeTaxation(CFG.menus.getHoveredProvinceID())), CFG.COLOR_POSITIVE));
                            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Production") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvIncomeProduction(CFG.menus.getHoveredProvinceID())), CFG.COLOR_POSITIVE));
                            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
float fQ = CFG.gameUpdate.getProvinceAdminQuality(CFG.menus.getHoveredProvinceID());
nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Administration") + ": "));
nData.add(new ME_Hover_2Type_Text("" + (int)(fQ * 100.0f) + "%", fQ > 0.6f ? CFG.COLOR_POSITIVE : (fQ > 0.3f ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
                            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            int tTotal = (int)CFG.gameUpdate.getProvIncomeAndExpenses_Total(CFG.menus.getHoveredProvinceID());
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Balance") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tTotal), tTotal > 0 ? CFG.COLOR_POSITIVE : (tTotal == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
                            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updateMaxIncome();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewIncome(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewIncome(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_IncomeMapMode(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawIcnomeMapMode_FlagAndCrown(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_IncomeMapMode(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawIcnomeMapMode_FlagAndCrown(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.getMetProv(CFG.core.getPIV(i))) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getPuppetOfCiv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                            oSB.setColor(CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, (long)CFG.core.getProv(CFG.core.getPIV(i)).getBalance_LastTurn(), POPULATION_MAX, 0.5f));
                            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                            continue;
                        }
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        continue;
                    }
                    oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
                    oSB.setColor(CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, (long)CFG.core.getProv(CFG.core.getPIV(i)).getBalance_LastTurn(), POPULATION_MAX, 0.5f));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_INCOME_PRODUCTION_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getProvName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Taxation") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvIncomeTaxation(CFG.menus.getHoveredProvinceID())), CFG.COLOR_POSITIVE));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Production") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvIncomeProduction(CFG.menus.getHoveredProvinceID())), CFG.COLOR_POSITIVE));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AdministrationCost") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvinceAdministrationCost(CFG.menus.getHoveredProvinceID(), CFG.gameUpdate.getAdministration_Capital(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()))), CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        int tTotal = (int)CFG.gameUpdate.getProvIncomeAndExpenses_Total(CFG.menus.getHoveredProvinceID());
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Balance") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tTotal), tTotal > 0 ? CFG.COLOR_POSITIVE : (tTotal == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updateMaxIncome_All_Production();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewIncome_Production(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewIncome_Production(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, (long)CFG.core.getProv((int)CFG.core.getPIV((int)i)).incomeProduction, POPULATION_MAX, 0.5f));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        continue;
                    }
                    oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, (long)CFG.core.getProv((int)CFG.core.getPIV((int)i)).incomeProduction, POPULATION_MAX, 0.5f));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_INCOME_TAXATION_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getProvName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Taxation") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvIncomeTaxation(CFG.menus.getHoveredProvinceID())), CFG.COLOR_POSITIVE));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Production") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvIncomeProduction(CFG.menus.getHoveredProvinceID())), CFG.COLOR_POSITIVE));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AdministrationCost") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvinceAdministrationCost(CFG.menus.getHoveredProvinceID(), CFG.gameUpdate.getAdministration_Capital(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()))), CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        int tTotal = (int)CFG.gameUpdate.getProvIncomeAndExpenses_Total(CFG.menus.getHoveredProvinceID());
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Balance") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tTotal), tTotal > 0 ? CFG.COLOR_POSITIVE : (tTotal == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updateMaxIncome_All_Taxation();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewIncome_Taxation(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewIncome_Taxation(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, (long)CFG.core.getProv((int)CFG.core.getPIV((int)i)).incomeProduction, POPULATION_MAX, 0.5f));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        continue;
                    }
                    oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, (long)CFG.core.getProv((int)CFG.core.getPIV((int)i)).incomeProduction, POPULATION_MAX, 0.5f));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_INCOME_ALL_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getProvName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Taxation") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvIncomeTaxation(CFG.menus.getHoveredProvinceID())), CFG.COLOR_POSITIVE));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Production") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvIncomeProduction(CFG.menus.getHoveredProvinceID())), CFG.COLOR_POSITIVE));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AdministrationCost") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getProvinceAdministrationCost(CFG.menus.getHoveredProvinceID(), CFG.gameUpdate.getAdministration_Capital(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()))), CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        int tTotal = (int)CFG.gameUpdate.getProvIncomeAndExpenses_Total(CFG.menus.getHoveredProvinceID());
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Balance") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + tTotal), tTotal > 0 ? CFG.COLOR_POSITIVE : (tTotal == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updateMaxIncome_All();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewIncome_All(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewIncome_All(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, (long)CFG.core.getProv(CFG.core.getPIV(i)).getBalance_LastTurn(), POPULATION_MAX, 0.5f));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        continue;
                    }
                    oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, (long)CFG.core.getProv(CFG.core.getPIV(i)).getBalance_LastTurn(), POPULATION_MAX, 0.5f));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_DISTANCE_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getPuppetOfCiv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getProvName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Distance") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + (int)Distance.getDistanceFromCapital(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCapitalProvID(), CFG.menus.getHoveredProvinceID())), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
float fQ = CFG.gameUpdate.getProvinceAdminQuality(CFG.menus.getHoveredProvinceID());
nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Administration") + ": "));
nData.add(new ME_Hover_2Type_Text("" + (int)(fQ * 100.0f) + "%", fQ > 0.6f ? CFG.COLOR_POSITIVE : (fQ > 0.3f ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else {
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updateMaxDistance();
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_IncomeMapMode(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawIcnomeMapMode_FlagAndCrown(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_IncomeMapMode(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawIcnomeMapMode_FlagAndCrown(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.getMetProv(CFG.core.getPIV(i))) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getPuppetOfCiv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                            oSB.setColor(CFG.getColorStep(CFG.COLOR_DISTANCE_MIN, CFG.COLOR_DISTANCE_MAX, (long)Distance.getDistanceFromCapital(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getCapitalProvID(), CFG.core.getPIV(i)), POPULATION_MAX, 0.5f));
                            CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                            continue;
                        }
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        continue;
                    }
                    oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
                    oSB.setColor(CFG.getColorStep(CFG.COLOR_DISTANCE_MIN, CFG.COLOR_DISTANCE_MAX, (long)Distance.getDistanceFromCapital(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getCapitalProvID(), CFG.core.getPIV(i)), POPULATION_MAX, 0.5f));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_HAPPINESS_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getHappi() * 100.0f) + "%", CFG.COLOR_HAPPINESS_MAX));
                        nData.add(new ME_Hover_2Type_Image(CFG.getHappinessImage((int)(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getHappi() * 100.0f)), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER = System.currentTimeMillis();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewHappiness(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewHappiness(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                int newCivID;
                int oldCivID;
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats() && (oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince)) != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                    CFG.menus.setVisible_InGame_ViewHappiness(true);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_Just(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                if (RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER + (long)GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL <= System.currentTimeMillis()) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                            oSB.setColor(CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, (int)(CFG.core.getProv(CFG.core.getPIV(i)).getHappi() * 100.0f), 100, 0.5f));
                        } else {
                            oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                } else {
                    int tempStepID = Math.min((int)(System.currentTimeMillis() - RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER), GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL);
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                            oSB.setColor(CFG.getColorStep_WithAlpha(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getRGB((float)CFG.settingsGD.PROV_ALPHA / 255.0f), CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, (int)(CFG.core.getProv(CFG.core.getPIV(i)).getHappi() * 100.0f), 100, 0.5f), tempStepID, GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL));
                        } else {
                            oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                    CFG.setRenderO(true);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                if (RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER + (long)GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL <= System.currentTimeMillis()) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        oSB.setColor(CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, (int)(CFG.core.getProv(CFG.core.getPIV(i)).getHappi() * 100.0f), 100, 0.5f));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                } else {
                    int tempStepID = Math.min((int)(System.currentTimeMillis() - RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER), GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL);
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        oSB.setColor(CFG.getColorStep_WithAlpha(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getRGB((float)CFG.settingsGD.PROV_ALPHA / 255.0f), CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, (int)(CFG.core.getProv(CFG.core.getPIV(i)).getHappi() * 100.0f), 100, 0.5f), tempStepID, GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                    CFG.setRenderO(true);
                }
            }
        });
        VIEW_REVOLUTION_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RevolutionaryRisk") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getRevRisk() * 100.0f) + "%", CFG.COLOR_HAPPINESS_MAX));
                        nData.add(new ME_Hover_2Type_Image(Images.diploRevolution, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER = System.currentTimeMillis();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewUnrest(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewUnrest(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                int newCivID;
                int oldCivID;
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats() && (oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince)) != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                    CFG.menus.setVisible_InGame_ViewUnrest(true);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor((int)(CFG.core.getProv(CFG.core.getPIV(i)).getRevRisk() * 100.0f) == 0 ? CFG.COLOR_REVOLUTION_MIN_0 : CFG.getColorStep(CFG.COLOR_REVOLUTION_MIN, CFG.COLOR_REVOLUTION_MAX, (int)(CFG.core.getProv(CFG.core.getPIV(i)).getRevRisk() * 100.0f), 100, 0.5f));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor((int)(CFG.core.getProv(CFG.core.getPIV(i)).getRevRisk() * 100.0f) == 0 ? CFG.COLOR_REVOLUTION_MIN_0 : CFG.getColorStep(CFG.COLOR_REVOLUTION_MIN, CFG.COLOR_REVOLUTION_MAX, (int)(CFG.core.getProv(CFG.core.getPIV(i)).getRevRisk() * 100.0f), 100, 0.5f));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_PROVINCE_STABILITY_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ProvinceStability") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getProviStability() * 100.0f) + "%", CFG.COLOR_HAPPINESS_MAX));
                        nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updateMaxPopulation();
                RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER = System.currentTimeMillis();
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv((int)i).viewBool = false;
                }
                for (int j = 1; j < CFG.core.getCivsSize(); ++j) {
                    if (CFG.core.getCiv(j).getNumOfProvs() <= 0) continue;
                    for (int k = 0; k < CFG.core.getCiv(j).getAssimilatesSize(); ++k) {
                        if (CFG.core.getProv(CFG.core.getCiv((int)j).getAssimilate((int)k).iProvinceID).isOccupied()) continue;
                        CFG.core.getProv((int)CFG.core.getCiv((int)j).getAssimilate((int)k).iProvinceID).viewBool = true;
                    }
                }
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewProvinceStability(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewProvinceStability(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                int newCivID;
                int oldCivID;
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats() && (oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince)) != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                    CFG.menus.setVisible_InGame_ViewProvinceStability(true);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int i;
                for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor((int)(CFG.core.getProv(CFG.core.getPIV(i)).getProviStability() * 100.0f) == 0 ? CFG.COLOR_PROVINCE_STABILITY_MAX : CFG.getColorStep(CFG.COLOR_PROVINCE_STABILITY_MIN, CFG.COLOR_PROVINCE_STABILITY_MAX, (int)(CFG.core.getProv(CFG.core.getPIV(i)).getProviStability() * 100.0f), 100, 0.5f));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
                oSB.setShader(AoCGame.shaderAlpha3);
                for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i)) || !CFG.core.getProv((int)CFG.core.getPIV((int)i)).viewBool) continue;
                    CFG.core.getProv(CFG.core.getPIV(i)).drawOccupiedProv(oSB);
                }
                oSB.setShader(AoCGame.shaderDef);
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int i;
                for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor((int)(CFG.core.getProv(CFG.core.getPIV(i)).getProviStability() * 100.0f) == 0 ? CFG.COLOR_PROVINCE_STABILITY_MAX : CFG.getColorStep(CFG.COLOR_PROVINCE_STABILITY_MIN, CFG.COLOR_PROVINCE_STABILITY_MAX, (int)(CFG.core.getProv(CFG.core.getPIV(i)).getProviStability() * 100.0f), 100, 0.5f));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
                oSB.setShader(AoCGame.shaderAlpha3);
                for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (!CFG.core.getProv((int)CFG.core.getPIV((int)i)).viewBool) continue;
                    CFG.core.getProv(CFG.core.getPIV(i)).drawOccupiedProv(oSB);
                }
                oSB.setShader(AoCGame.shaderDef);
            }
        });
        VIEW_ECONOMY_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public boolean canMoveArmy() {
                return super.canMoveArmy() && !BuildingsManager.buildBySelectingProvinceOnMap;
            }

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getEco()), CFG.COLOR_ECONOMY));
                        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updateMaxEconomy();
                RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER = System.currentTimeMillis();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewEconomy(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewEconomy(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats()) {
                    int oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince);
                    int newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince);
                    if (!Menu_NextPlayerTurn.lockExtraAction && BuildingsManager.buildBySelectingProvinceOnMap && oldCivID == newCivID && newProvince >= 0 && CFG.core.getProv(newProvince).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && !CFG.core.getProv(newProvince).isOccupied()) {
                        long maxValue = GameManager.invest_MaxEconomy_Gold(newProvince, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        int actionDone = 0;
                        if (GameManager.invest(newProvince, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), maxValue)) {
                            ++actionDone;
                            CFG.gameAction.updateInGame_ProvinceInfo();
                            if (CFG.mapModesManager.getActiveMapModeID() == VIEW_ECONOMY_MODE) {
                                CFG.core.getProv((int)newProvince).viewBool = true;
                                if (CFG.menus.getVisible_InGame_View_Stats()) {
                                    CFG.menus.setVisible_InGame_ViewEconomy(true);
                                }
                            }
                            CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        }
                        if (actionDone > 0) {
                            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                            CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                            CFG.toastM.setTimeInView(3500);
                        }
                    }
                    if (oldCivID != newCivID) {
                        CFG.menus.setVisible_InGame_ViewEconomy(true);
                    }
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int lastColorIndex = -1;
                boolean lastMet = false;
                float[] discoC = CFG.settingsGD.COLOR_DISCOVERY_FLOAT;
                for (int i = 0; i < CFG.core.sortedPIV.size(); ++i) {
                    int provinceID = CFG.core.sortedPIV.get(i);
                    Province province = CFG.core.getProv(provinceID);
                    boolean met = CFG.getMetProv(provinceID);
                    if (met) {
                        int colorIndex = (int)((float)province.getEco() / (float)ECONOMY_MAX * 100.0f);
                        colorIndex = Math.min(100, Math.max(0, colorIndex));
                        if (colorIndex != lastColorIndex || !lastMet) {
                            oSB.setColor(CFG.ECON_COLORS_CACHE[colorIndex]);
                            lastColorIndex = colorIndex;
                        }
                    } else {
                        if (lastMet || lastColorIndex == -1) {
                            oSB.setColor(discoC[0], discoC[1], discoC[2], discoC[3]);
                            lastColorIndex = -2;
                        }
                    }
                    province.drawLandProv(oSB);
                    if (met && province.getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInvested(provinceID)) {
                        oSB.setShader(AoCGame.shaderAlpha3);
                        province.drawOccupiedProv2(oSB);
                        oSB.setShader(AoCGame.shaderDef);
                        lastColorIndex = -1;
                    }
                    lastMet = met;
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int lastColorIndex = -1;
                for (int i = 0; i < CFG.core.sortedPIV.size(); ++i) {
                    int provinceID = CFG.core.sortedPIV.get(i);
                    Province province = CFG.core.getProv(provinceID);
                    int colorIndex = (int)((float)province.getEco() / (float)ECONOMY_MAX * 100.0f);
                    colorIndex = Math.min(100, Math.max(0, colorIndex));
                    if (colorIndex != lastColorIndex) {
                        oSB.setColor(CFG.ECON_COLORS_CACHE[colorIndex]);
                        lastColorIndex = colorIndex;
                    }
                    province.drawLandProv(oSB);
                    if (province.getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInvested(provinceID)) {
                        oSB.setShader(AoCGame.shaderAlpha3);
                        province.drawOccupiedProv2(oSB);
                        oSB.setShader(AoCGame.shaderDef);
                        lastColorIndex = -1;
                    }
                }
            }
        });
        VIEW_POPULATION_OF_CIV_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                return null;
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updateMaxPopulationOfCivilization(Menu_InGame_View_PopulationCiv.civID);
                RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER = System.currentTimeMillis();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_View_PopulationCiv(true, Menu_InGame_View_PopulationCiv.civID);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_View(false);
                }
            }

            @Override
            public void setActiveProvinceAction() {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() != Menu_InGame_View_PopulationCiv.civID) {
                    Menu_InGame_View_PopulationCiv.civID = CFG.core.getProv(CFG.core.getActiveProvID()).getCivId();
                    MapModesManager.updateMaxPopulationOfCivilization(Menu_InGame_View_PopulationCiv.civID);
                    RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER = System.currentTimeMillis();
                    if (CFG.menus.getInGameView()) {
                        CFG.menus.setVisible_InGame_View_PopulationCiv(true, Menu_InGame_View_PopulationCiv.civID);
                    }
                }
                if (RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER + (long)GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL <= System.currentTimeMillis()) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() != POPULATION_OF_CIVID) continue;
                        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                            oSB.setColor(new Color((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, 0.15f + 0.7f * (float)CFG.core.getProv(CFG.core.getPIV(i)).getPop().getPops() / (float)POPULATION_MAX));
                        } else {
                            oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                } else {
                    int tempStepID = Math.min((int)(System.currentTimeMillis() - RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER), GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL);
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() != POPULATION_OF_CIVID) continue;
                        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                            oSB.setColor(new Color((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (0.15f + 0.7f * (float)CFG.core.getProv(CFG.core.getPIV(i)).getPop().getPops() / (float)POPULATION_MAX) * (float)tempStepID / (float)GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL));
                        } else {
                            oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                    CFG.setRenderO(true);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                if (RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER + (long)GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL <= System.currentTimeMillis()) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() != POPULATION_OF_CIVID) continue;
                        oSB.setColor(new Color((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, 0.15f + 0.7f * (float)CFG.core.getProv(CFG.core.getPIV(i)).getPop().getPops() / (float)POPULATION_MAX));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                } else {
                    int tempStepID = Math.min((int)(System.currentTimeMillis() - RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER), GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL);
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() != POPULATION_OF_CIVID) continue;
                        oSB.setColor(new Color((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getB() / 255.0f, (0.15f + 0.7f * (float)CFG.core.getProv(CFG.core.getPIV(i)).getPop().getPops() / (float)POPULATION_MAX) * (float)tempStepID / (float)GameValues.gvProvinceAnimation.PROVINCE_ANIMATION_VIEW_COLOR_INTERVAL));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                    CFG.setRenderO(true);
                }
            }
        });
        VIEW_CONTINENT_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapContinents().getName(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getContinent())));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                CFG.fTerrainMode_LinePercentage = 0.0f;
                CFG.lTerrainMode_LineTime = System.currentTimeMillis();
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                CFG.core.drawHighlightProvince(oSB);
                CFG.core.updateHighlitghtProvinceBorder(oSB);
                RenderProvince.drawProvincesBorder_ContinentMode_FogOfWarDiscovey(oSB);
                CFG.core.drawActiveProvinceBorder(oSB);
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                CFG.core.drawHighlightProvince(oSB);
                CFG.core.updateHighlitghtProvinceBorder(oSB);
                RenderProvince.drawProvincesBorder_ContinentMode(oSB);
                CFG.core.drawActiveProvinceBorder(oSB);
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                    }
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(new Color(CFG.map.getMapContinents().getColor((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getContinent()).r, CFG.map.getMapContinents().getColor((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getContinent()).g, CFG.map.getMapContinents().getColor((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getContinent()).b, 0.7f));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(new Color(CFG.map.getMapContinents().getColor((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getContinent()).r, CFG.map.getMapContinents().getColor((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getContinent()).g, CFG.map.getMapContinents().getColor((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getContinent()).b, 0.7f));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_REGIONS_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Region") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapRegions().getName(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getRegion()), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                CFG.fTerrainMode_LinePercentage = 0.0f;
                CFG.lTerrainMode_LineTime = System.currentTimeMillis();
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                CFG.core.drawHighlightProvince(oSB);
                CFG.core.updateHighlitghtProvinceBorder(oSB);
                RenderProvince.drawProvincesBorder_RegionsMode_FogOfWarDiscovery(oSB);
                CFG.core.drawActiveProvinceBorder(oSB);
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                CFG.core.drawHighlightProvince(oSB);
                CFG.core.updateHighlitghtProvinceBorder(oSB);
                RenderProvince.drawProvincesBorder_RegionsMode(oSB);
                CFG.core.drawActiveProvinceBorder(oSB);
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                    }
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(new Color(CFG.map.getMapRegions().getColor((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getRegion()).r, CFG.map.getMapRegions().getColor((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getRegion()).g, CFG.map.getMapRegions().getColor((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getRegion()).b, 0.45f));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(new Color(CFG.map.getMapRegions().getColor((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getRegion()).r, CFG.map.getMapRegions().getColor((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getRegion()).g, CFG.map.getMapRegions().getColor((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getRegion()).b, 0.45f));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_TERRAIN_TYPE_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                            return CFG.core.getHover_TerrainTypeInfo(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getTerrainTypeID(), CFG.menus.getHoveredProvinceID());
                        }
                        if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                            return CFG.core.getHover_TerrainTypeInfo(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getTerrainTypeID(), CFG.menus.getHoveredProvinceID());
                        }
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                CFG.fTerrainMode_LinePercentage = 0.0f;
                CFG.lTerrainMode_LineTime = System.currentTimeMillis();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewTerrain(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewTerrain(false);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawMountains_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawMountains_FogOfWarDiscovery(oSB, 1.0f);
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawMountains(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawMountains(oSB, 1.0f);
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(CFG.terrainTypesManager.getColor(CFG.core.getProv(CFG.core.getPIV(i)).getTerrainTypeID()));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        continue;
                    }
                    oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(CFG.terrainTypesManager.getColor(CFG.core.getProv(CFG.core.getPIV(i)).getTerrainTypeID()));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_GROWTH_RATE_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("GrowthRate") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getGrowthRate_Pop() * 100.0f) + "%", CFG.COLOR_POPULATION));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        try {
                            if (CFG.core.getProv((int)CFG.menus.getHoveredProvinceID()).provGD.wonderBuilt) {
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getProv((int)CFG.menus.getHoveredProvinceID()).getWonder((int)0).sName) + ": "));
                                nData.add(new ME_Hover_2Type_Text("+" + (int)(GameValues.gvWonder.GROWTH_RATE * 100.0f) + "%", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Wonder(CFG.menus.getHoveredProvinceID(), 0, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                        }
                        catch (Exception exception) {
                            
                        }
                        if (BuildingsManager.getFarm_GrowthRateBonus(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfFarm()) > 0.0f) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Farm") + ": "));
                            nData.add(new ME_Hover_2Type_Text("+" + (int)(BuildingsManager.getFarm_GrowthRateBonus(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfFarm()) * 100.0f) + "%", CFG.COLOR_POPULATION));
                            nData.add(new ME_Hover_2Type_Image(Images.bFarm, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewGrowthRate(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewGrowthRate(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                int newCivID;
                int oldCivID;
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats() && (oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince)) != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                    CFG.menus.setVisible_InGame_ViewGrowthRate(true);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int lastColorIndex = -1;
                boolean lastMet = false;
                float[] discoC = CFG.settingsGD.COLOR_DISCOVERY_FLOAT;
                for (int i = 0; i < CFG.core.sortedPIV.size(); ++i) {
                    int provinceID = CFG.core.sortedPIV.get(i);
                    Province province = CFG.core.getProv(provinceID);
                    boolean met = CFG.getMetProv(provinceID);
                    if (met) {
                        int colorIndex = (int)((province.getGrowthRate_Pop() + BuildingsManager.getFarm_GrowthRateBonus(province.getLvlOfFarm()) + (province.provGD.wonderBuilt ? GameValues.gvWonder.GROWTH_RATE : 0.0f)) * 100.0f);
                        colorIndex = Math.min(100, Math.max(0, colorIndex));
                        if (colorIndex != lastColorIndex || !lastMet) {
                            oSB.setColor(CFG.GROWTH_COLORS_CACHE[colorIndex]);
                            lastColorIndex = colorIndex;
                        }
                    } else {
                        if (lastMet || lastColorIndex == -1) {
                            oSB.setColor(discoC[0], discoC[1], discoC[2], discoC[3]);
                            lastColorIndex = -2;
                        }
                    }
                    province.drawLandProv(oSB);
                    lastMet = met;
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int lastColorIndex = -1;
                for (int i = 0; i < CFG.core.sortedPIV.size(); ++i) {
                    int provinceID = CFG.core.sortedPIV.get(i);
                    Province province = CFG.core.getProv(provinceID);
                    int colorIndex = (int)((province.getGrowthRate_Pop() + BuildingsManager.getFarm_GrowthRateBonus(province.getLvlOfFarm()) + (province.provGD.wonderBuilt ? GameValues.gvWonder.GROWTH_RATE : 0.0f)) * 100.0f);
                    colorIndex = Math.min(100, Math.max(0, colorIndex));
                    if (colorIndex != lastColorIndex) {
                        oSB.setColor(CFG.GROWTH_COLORS_CACHE[colorIndex]);
                        lastColorIndex = colorIndex;
                    }
                    province.drawLandProv(oSB);
                }
            }
        });
        VIEW_DEVELOPMENT_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public boolean canMoveArmy() {
                return super.canMoveArmy() && !BuildingsManager.buildBySelectingProvinceOnMap;
            }

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).isCapital()) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyLevel") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Development") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getDeveLvl() * 100.0f)) / 100.0f, CFG.COLOR_NEUTRAL2));
                        nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Text(" / ", CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewDevelopment(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewDevelopment(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats()) {
                    int oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince);
                    int newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince);
                    if (!Menu_NextPlayerTurn.lockExtraAction && BuildingsManager.buildBySelectingProvinceOnMap && newProvince >= 0 && oldCivID == newCivID && CFG.core.getProv(newProvince).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && !CFG.core.getProv(newProvince).isOccupied()) {
                        long maxValue = GameManager.investMaxDevGold(newProvince, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        int actionDone = 0;
                        if (GameManager.investDevelopment(newProvince, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), maxValue)) {
                            ++actionDone;
                            CFG.gameAction.updateInGame_ProvinceInfo();
                            if (CFG.mapModesManager.getActiveMapModeID() == VIEW_DEVELOPMENT_MODE) {
                                CFG.core.getProv((int)newProvince).viewBool = true;
                                if (CFG.menus.getVisible_InGame_View_Stats()) {
                                    CFG.menus.setVisible_InGame_ViewDevelopment(true);
                                }
                            }
                            CFG.SFXManager.playSound(SFXManager.SFX_WORKSHOP);
                        }
                        if (actionDone > 0) {
                            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                            CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                            CFG.toastM.setTimeInView(3500);
                        }
                    }
                    if (oldCivID != newCivID) {
                        CFG.menus.setVisible_InGame_ViewDevelopment(true);
                    }
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int lastColorIndex = -1;
                boolean lastMet = false;
                float[] discoC = CFG.settingsGD.COLOR_DISCOVERY_FLOAT;
                for (int i = 0; i < CFG.core.sortedPIV.size(); ++i) {
                    int provinceID = CFG.core.sortedPIV.get(i);
                    Province province = CFG.core.getProv(provinceID);
                    boolean met = CFG.getMetProv(provinceID);
                    if (met) {
                        int colorIndex = (int)(province.getDeveLvl() * 100.0f);
                        colorIndex = Math.min(100, Math.max(0, colorIndex));
                        if (colorIndex != lastColorIndex || !lastMet) {
                            oSB.setColor(CFG.TECH_COLORS_CACHE[colorIndex]);
                            lastColorIndex = colorIndex;
                        }
                    } else {
                        if (lastMet || lastColorIndex == -1) {
                            oSB.setColor(discoC[0], discoC[1], discoC[2], discoC[3]);
                            lastColorIndex = -2;
                        }
                    }
                    province.drawLandProv(oSB);
                    if (met && province.getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInvestedDev(provinceID)) {
                        oSB.setShader(AoCGame.shaderAlpha3);
                        province.drawOccupiedProv2(oSB);
                        oSB.setShader(AoCGame.shaderDef);
                        lastColorIndex = -1;
                    }
                    lastMet = met;
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int lastColorIndex = -1;
                for (int i = 0; i < CFG.core.sortedPIV.size(); ++i) {
                    int provinceID = CFG.core.sortedPIV.get(i);
                    Province province = CFG.core.getProv(provinceID);
                    int colorIndex = (int)(province.getDeveLvl() * 100.0f);
                    colorIndex = Math.min(100, Math.max(0, colorIndex));
                    if (colorIndex != lastColorIndex) {
                        oSB.setColor(CFG.TECH_COLORS_CACHE[colorIndex]);
                        lastColorIndex = colorIndex;
                    }
                    province.drawLandProv(oSB);
                    if (province.getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInvestedDev(provinceID)) {
                        oSB.setShader(AoCGame.shaderAlpha3);
                        province.drawOccupiedProv2(oSB);
                        oSB.setShader(AoCGame.shaderDef);
                        lastColorIndex = -1;
                    }
                }
            }
        });
        VIEW_IMPERIAL_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getIsPartOfHolyRomanEmpire()) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                                if (CFG.hreMgr.getHRE().getIsEmperor(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId())) {
                                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName() + " ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("IsTheEmperor")));
                                    nData.add(new ME_Hover_2Type_Image_Big(Images.hreIcon, CFG.PADD, 0));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                } else if (CFG.hreMgr.getHRE().getIsElector(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId())) {
                                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName() + " ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("IsAnElector")));
                                    nData.add(new ME_Hover_2Type_Image_Big(Images.hreIcon, CFG.PADD, 0));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                } else if (CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getIsPartOfHolyRomanEmpire()) {
                                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName() + " ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("IsAPrince")));
                                    nData.add(new ME_Hover_2Type_Image_Big(Images.hreIcon, CFG.PADD, 0));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                } else {
                                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName() + " ", CFG.COLOR_HOVER_TITLE));
                                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("IsNotAPrince"), CFG.COLOR_NEGATIVE_2));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                }
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ThisProvinceIsPartOfEmpire"), CFG.COLOR_NEUTRAL));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            } else {
                                if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                                    nData.add(new ME_Hover_2Type_Flag_Big(0, CFG.PADD, 0));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                } else {
                                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName()));
                                    nData.add(new ME_Hover_2Type_Flag_Big(0, CFG.PADD, 0));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                }
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ThisProvinceIsPartOfEmpire"), CFG.COLOR_NEUTRAL));
                                nData.add(new ME_Hover_2Type_Image(Images.hreFlag, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Flag_Big(0, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName()));
                            nData.add(new ME_Hover_2Type_Flag_Big(0, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                CFG.map.getMpB().updateWorldMap_Shaders();
            }

            @Override
            public void disableViewAction() {
                CFG.map.getMpB().updateWorldMap_Shaders();
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_Imperial_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawFlagAndCrown_Emperor_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_Imperial_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawFlagAndCrown_Emperor_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_Imperial(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawFlagAndCrown_Emperor(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_Imperial(oSB, 1.0f);
                    }
                    CFG.core.drawFlagAndCrown_Emperor(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getIsPartOfHolyRomanEmpire()) {
                            if (!CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getIsPartOfHolyRomanEmpire()) {
                                oSB.setColor(new Color(HolyRomanEmpire_Manager.oColorHRE_NotControledByEmpire.r, HolyRomanEmpire_Manager.oColorHRE_NotControledByEmpire.g, HolyRomanEmpire_Manager.oColorHRE_NotControledByEmpire.b, (float)CFG.settingsGD.PROV_ALPHA / 255.0f));
                            } else if (CFG.hreMgr.getHRE().getIsEmperor(CFG.core.getProv(CFG.core.getPIV(i)).getCivId())) {
                                oSB.setColor(new Color(HolyRomanEmpire_Manager.oColorHRE.r, HolyRomanEmpire_Manager.oColorHRE.g, HolyRomanEmpire_Manager.oColorHRE.b, (float)CFG.settingsGD.PROV_ALPHA / 255.0f));
                            } else if (CFG.hreMgr.getHRE().getIsElector(CFG.core.getProv(CFG.core.getPIV(i)).getCivId())) {
                                oSB.setColor(new Color(HolyRomanEmpire_Manager.oColorHRE_Electors.r, HolyRomanEmpire_Manager.oColorHRE_Electors.g, HolyRomanEmpire_Manager.oColorHRE_Electors.b, (float)CFG.settingsGD.PROV_ALPHA / 255.0f));
                            } else {
                                oSB.setColor(new Color(HolyRomanEmpire_Manager.oColorHRE_BG.r, HolyRomanEmpire_Manager.oColorHRE_BG.g, HolyRomanEmpire_Manager.oColorHRE_BG.b, (float)CFG.settingsGD.PROV_ALPHA / 255.0f));
                            }
                        } else {
                            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), (float)CFG.settingsGD.PROV_ALPHA * 2.0f / 5.0f / 255.0f));
                        }
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getIsPartOfHolyRomanEmpire()) {
                        if (!CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getIsPartOfHolyRomanEmpire()) {
                            oSB.setColor(new Color(HolyRomanEmpire_Manager.oColorHRE_NotControledByEmpire.r, HolyRomanEmpire_Manager.oColorHRE_NotControledByEmpire.g, HolyRomanEmpire_Manager.oColorHRE_NotControledByEmpire.b, (float)CFG.settingsGD.PROV_ALPHA / 255.0f));
                        } else if (CFG.hreMgr.getHRE().getIsEmperor(CFG.core.getProv(CFG.core.getPIV(i)).getCivId())) {
                            oSB.setColor(new Color(HolyRomanEmpire_Manager.oColorHRE.r, HolyRomanEmpire_Manager.oColorHRE.g, HolyRomanEmpire_Manager.oColorHRE.b, (float)CFG.settingsGD.PROV_ALPHA / 255.0f));
                        } else if (CFG.hreMgr.getHRE().getIsElector(CFG.core.getProv(CFG.core.getPIV(i)).getCivId())) {
                            oSB.setColor(new Color(HolyRomanEmpire_Manager.oColorHRE_Electors.r, HolyRomanEmpire_Manager.oColorHRE_Electors.g, HolyRomanEmpire_Manager.oColorHRE_Electors.b, (float)CFG.settingsGD.PROV_ALPHA / 255.0f));
                        } else {
                            oSB.setColor(new Color(HolyRomanEmpire_Manager.oColorHRE_BG.r, HolyRomanEmpire_Manager.oColorHRE_BG.g, HolyRomanEmpire_Manager.oColorHRE_BG.b, (float)CFG.settingsGD.PROV_ALPHA / 255.0f));
                        }
                    } else {
                        oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), (float)CFG.settingsGD.PROV_ALPHA * 2.0f / 5.0f / 255.0f));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_TECHNOLOGY_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyLevel") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_NEUTRAL2));
                        nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Text(" / ", CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Text("" + (float)((int)(GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL * 100.0f)) / 100.0f, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchProgress") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getPercentage_Max100((int)CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getResearchProgressT(), TechManager.getResearchNextLevel(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()), 4) + "%", CFG.COLOR_RESEARCH));
                        nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    if (!CFG.core.getProv(i).isCapital()) continue;
                    CFG.core.getProv(i).getArmyObject(0).updateArmyWidth((float)((int)(CFG.core.getCiv(CFG.core.getProv(i).getCivId()).getTechLevel() * 100.0f)) / 100.0f);
                }
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewTechnology(true, MapModesManager.this.viewConfig);
                }
            }

            @Override
            public void disableViewAction() {
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    if (!CFG.core.getProv(i).isCapital()) continue;
                    CFG.core.getProv(i).getArmyObject(0).updateArmyWidth_Just(i);
                }
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewTechnology(false, MapModesManager.this.viewConfig);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_Capitals_FogOfWarDiscovery(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvinces_TechnologyLevels_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvinces_TechnologyLevels_FogOfWarDiscovery(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_Capitals(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_Just(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvinces_TechnologyLevels(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                    }
                    CFG.core.drawProvinces_TechnologyLevels(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int lastColorIndex = -1;
                boolean lastMet = false;
                float[] discoC = CFG.settingsGD.COLOR_DISCOVERY_FLOAT;
                for (int i = 0; i < CFG.core.sortedPIV.size(); ++i) {
                    int provinceID = CFG.core.sortedPIV.get(i);
                    Province province = CFG.core.getProv(provinceID);
                    boolean met = CFG.getMetProv(provinceID);
                    if (met) {
                        int civID = province.getCivId();
                        if (civID > 0) {
                            int colorIndex = (int)(CFG.core.getCiv(civID).getTechLevel() * 100.0f);
                            colorIndex = Math.min(100, Math.max(0, colorIndex));
                            if (colorIndex != lastColorIndex || !lastMet) {
                                oSB.setColor(CFG.TECH_COLORS_CACHE[colorIndex]);
                                lastColorIndex = colorIndex;
                            }
                            province.drawLandProv(oSB);
                        }
                    } else {
                        if (lastMet || lastColorIndex == -1) {
                            oSB.setColor(discoC[0], discoC[1], discoC[2], discoC[3]);
                            lastColorIndex = -2;
                        }
                        province.drawLandProv(oSB);
                    }
                    lastMet = met;
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int lastColorIndex = -1;
                for (int i = 0; i < CFG.core.sortedPIV.size(); ++i) {
                    int provinceID = CFG.core.sortedPIV.get(i);
                    Province province = CFG.core.getProv(provinceID);
                    int civID = province.getCivId();
                    if (civID <= 0) continue;
                    int colorIndex = (int)(CFG.core.getCiv(civID).getTechLevel() * 100.0f);
                    colorIndex = Math.min(100, Math.max(0, colorIndex));
                    if (colorIndex != lastColorIndex) {
                        oSB.setColor(CFG.TECH_COLORS_CACHE[colorIndex]);
                        lastColorIndex = colorIndex;
                    }
                    province.drawLandProv(oSB);
                }
            }
        });
        VIEW_PROVINCE_VALUE_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ProvinceValue") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getProvinceValue(CFG.menus.getHoveredProvinceID()), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image(Images.victoryPoints, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BaseProvinceValue") + ": "));
                        nData.add(new ME_Hover_2Type_Text("+" + GameValues.gvProvinceValue.BASE_PROVINCE_VALUE, CFG.COLOR_POSITIVE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        if (CFG.core.getProvinceValue_Capital(CFG.menus.getHoveredProvinceID()) > 0) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Capital") + ": "));
                            nData.add(new ME_Hover_2Type_Text("+" + CFG.core.getProvinceValue_Capital(CFG.menus.getHoveredProvinceID()), CFG.COLOR_POSITIVE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.core.getProvinceValue_PopulationGrowthRate(CFG.menus.getHoveredProvinceID()) > 0) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("GrowthRate") + ": "));
                            nData.add(new ME_Hover_2Type_Text("+" + CFG.core.getProvinceValue_PopulationGrowthRate(CFG.menus.getHoveredProvinceID()), CFG.COLOR_POSITIVE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.core.getProvinceValue_DevelopmentLevel(CFG.menus.getHoveredProvinceID()) > 0) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DevelopmentLevel") + ": "));
                            nData.add(new ME_Hover_2Type_Text("+" + CFG.core.getProvinceValue_DevelopmentLevel(CFG.menus.getHoveredProvinceID()), CFG.COLOR_POSITIVE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.core.getProvinceValue_Terrain(CFG.menus.getHoveredProvinceID()) > 0) {
                            nData.add(new ME_Hover_2Type_Text(CFG.terrainTypesManager.getName(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getTerrainTypeID()) + ": "));
                            nData.add(new ME_Hover_2Type_Text("+" + CFG.core.getProvinceValue_Terrain(CFG.menus.getHoveredProvinceID()), CFG.COLOR_POSITIVE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                CFG.updateMAX_PROVINCE_VALUE();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_View_ProvinceValue(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_View(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                int newCivID;
                int oldCivID;
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats() && (oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince)) != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                    CFG.menus.setVisible_InGame_View_ProvinceValue(true);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(CFG.getProvinceValueColor(CFG.core.getProvinceValue(CFG.core.getPIV(i))));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(CFG.getProvinceValueColor(CFG.core.getProvinceValue(CFG.core.getPIV(i))));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_ARMY_MODE = this.addViewToTheGame(new MapMode(){

            
            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivsSize() > 1 && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(CFG.menus.getHoveredProvinceID())) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            for (int i = 1; i < CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivsSize(); ++i) {
                                nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(i)));
                                nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(i)).getCivName()));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            return new ME_Hover_v2(nElements);
                        } else {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) return null;
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        return new ME_Hover_v2(nElements);
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfSupply() <= 0) return new ME_Hover_v2(nElements);
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getSupply_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfSupply())), CFG.COLOR_NEUTRAL));
                        nData.add(new ME_Hover_2Type_Image(Images.bSupply, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                CFG.updateMAX_Army();
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv((int)i).viewBool = CFG.core.getProv(i).getLvlOfSupply() > 0;
                }
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewArmy(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewArmy(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 0 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int i;
                for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProvinceArmy(CFG.core.getPIV(i)) > 0) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                            oSB.setColor(CFG.getProvinceArmyColor_Own(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                        } else if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) {
                            oSB.setColor(CFG.getProvinceArmyColor_Neutral(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                        } else if ((int)CFG.core.getCivRelationOfCivB(CFG.core.getProv(CFG.core.getPIV(i)).getCivId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == GameValues.gvDiplomacy.RELATION_AT_WAR) {
                            oSB.setColor(CFG.getProvinceArmyColor_AtWar(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                        } else if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance() == CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() || CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivId() == CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getPuppetOfCiv() || CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv() == CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getCivId()) {
                            oSB.setColor(CFG.getProvinceArmyColor_Alliance(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                        } else {
                            oSB.setColor(CFG.getProvinceArmyColor_Neutral(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                        }
                    } else {
                        oSB.setColor(new Color(CFG.COLOR_PROVINCE_ARMY_MIN.r, CFG.COLOR_PROVINCE_ARMY_MIN.g, CFG.COLOR_PROVINCE_ARMY_MIN.b, 0.1725f));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
                oSB.setShader(AoCGame.shaderAlpha3);
                for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (!CFG.core.getProv((int)CFG.core.getPIV((int)i)).viewBool) continue;
                    CFG.core.getProv(CFG.core.getPIV(i)).drawOccupiedProv(oSB);
                }
                oSB.setShader(AoCGame.shaderDef);
            }
        } : (CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int i;
                for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(CFG.core.getPIV(i))) {
                            if (CFG.core.getProvinceArmy(CFG.core.getPIV(i)) > 0) {
                                if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                                    oSB.setColor(CFG.getProvinceArmyColor_Own(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                                } else if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) {
                                    oSB.setColor(CFG.getProvinceArmyColor_Neutral(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                                } else if ((int)CFG.core.getCivRelationOfCivB(CFG.core.getProv(CFG.core.getPIV(i)).getCivId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == GameValues.gvDiplomacy.RELATION_AT_WAR) {
                                    oSB.setColor(CFG.getProvinceArmyColor_AtWar(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                                } else if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance() == CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() || CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivId() == CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getPuppetOfCiv() || CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv() == CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getCivId()) {
                                    oSB.setColor(CFG.getProvinceArmyColor_Alliance(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                                } else {
                                    oSB.setColor(CFG.getProvinceArmyColor_Neutral(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                                }
                            } else {
                                oSB.setColor(new Color(CFG.COLOR_PROVINCE_ARMY_MIN.r, CFG.COLOR_PROVINCE_ARMY_MIN.g, CFG.COLOR_PROVINCE_ARMY_MIN.b, 0.1725f));
                            }
                        } else {
                            oSB.setColor(new Color(CFG.COLOR_PROVINCE_ARMY_MIN.r, CFG.COLOR_PROVINCE_ARMY_MIN.g, CFG.COLOR_PROVINCE_ARMY_MIN.b, 0.0575f));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        continue;
                    }
                    oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
                oSB.setShader(AoCGame.shaderAlpha3);
                for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i)) || !CFG.core.getProv((int)CFG.core.getPIV((int)i)).viewBool) continue;
                    CFG.core.getProv(CFG.core.getPIV(i)).drawOccupiedProv(oSB);
                }
                oSB.setShader(AoCGame.shaderDef);
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int i;
                for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(CFG.core.getPIV(i))) {
                        if (CFG.core.getProvinceArmy(CFG.core.getPIV(i)) > 0) {
                            if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                                oSB.setColor(CFG.getProvinceArmyColor_Own(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                            } else if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() == 0) {
                                oSB.setColor(CFG.getProvinceArmyColor_Neutral(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                            } else if ((int)CFG.core.getCivRelationOfCivB(CFG.core.getProv(CFG.core.getPIV(i)).getCivId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) == GameValues.gvDiplomacy.RELATION_AT_WAR) {
                                oSB.setColor(CFG.getProvinceArmyColor_AtWar(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                            } else if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getAlliance() == CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() || CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivId() == CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getPuppetOfCiv() || CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv() == CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getCivId()) {
                                oSB.setColor(CFG.getProvinceArmyColor_Alliance(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                            } else {
                                oSB.setColor(CFG.getProvinceArmyColor_Neutral(CFG.core.getProvinceArmy(CFG.core.getPIV(i))));
                            }
                        } else {
                            oSB.setColor(new Color(CFG.COLOR_PROVINCE_ARMY_MIN.r, CFG.COLOR_PROVINCE_ARMY_MIN.g, CFG.COLOR_PROVINCE_ARMY_MIN.b, 0.1725f));
                        }
                    } else {
                        oSB.setColor(new Color(CFG.COLOR_PROVINCE_ARMY_MIN.r, CFG.COLOR_PROVINCE_ARMY_MIN.g, CFG.COLOR_PROVINCE_ARMY_MIN.b, 0.0575f));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
                oSB.setShader(AoCGame.shaderAlpha3);
                for (i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (!CFG.core.getProv((int)CFG.core.getPIV((int)i)).viewBool) continue;
                    CFG.core.getProv(CFG.core.getPIV(i)).drawOccupiedProv(oSB);
                }
                oSB.setShader(AoCGame.shaderDef);
            }
        }));
        VIEW_BUILDINGS_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    }
                    if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfFort() > 0) {
                            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFort_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfFort()))));
                            nData.add(new ME_Hover_2Type_Image(Images.bFort, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfWatchTower() > 0) {
                            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getTower_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfWatchTower()))));
                            nData.add(new ME_Hover_2Type_Image(Images.bTower, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfPort() > 0) {
                            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getPort_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfPort()))));
                            nData.add(new ME_Hover_2Type_Image(Images.bPort, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfLibrary() > 0) {
                            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getLibrary_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfLibrary()))));
                            nData.add(new ME_Hover_2Type_Image(Images.bLibrary, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfFarm() > 0) {
                            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFarm_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfFarm()))));
                            nData.add(new ME_Hover_2Type_Image(Images.bFarm, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfWorkshop() > 0) {
                            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getWorkshop_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfWorkshop()))));
                            nData.add(new ME_Hover_2Type_Image(Images.bWorkshop, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfMarket() > 0) {
                            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getMarket_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfMarket()))));
                            nData.add(new ME_Hover_2Type_Image(Images.bMarket, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfArmoury() > 0) {
                            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getArmoury_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfArmoury()))));
                            nData.add(new ME_Hover_2Type_Image(Images.bArmoury, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfSupply() > 0) {
                            nData.add(new ME_Hover_2Type_Text(" - ", CFG.COLOR_NEUTRAL));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getSupply_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfSupply()))));
                            nData.add(new ME_Hover_2Type_Image(Images.bSupply, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (nElements.size() > 0) {
                            return new ME_Hover_v2(nElements);
                        }
                        return null;
                    }
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(-1));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_View_Buildings(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_View_Buildings(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                int newCivID;
                int oldCivID;
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats() && (oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince)) != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                    CFG.menus.setVisible_InGame_View_Buildings(true);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesBuildings_FogOfWar(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesBuildings_FogOfWar(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesBuildings(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesBuildings(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        CFG.core.getProv(CFG.core.getPIV(i)).setProvColor(oSB);
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    CFG.core.getProv(CFG.core.getPIV(i)).setProvColor(oSB);
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_LEVEL_OF_PORT_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                block4: {
                    try {
                        if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfPort() > 0 && CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Image_Big(Images.bPort));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Port") + ": "));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                return new ME_Hover_v2(nElements);
                            }
                            break block4;
                        }
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    }
                    catch (Exception exception) {
                        
                    }
                }
                return null;
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBPorts(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBPorts(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats()) {
                    int newCivID;
                    int oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince);
                    if (oldCivID != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                        CFG.menus.setVisible_InGame_ViewBPorts(true);
                    } else if (BuildingsManager.buildBySelectingProvinceOnMap && !Menu_NextPlayerTurn.lockExtraAction && oldProvince >= 0 && newProvince >= 0 && CFG.core.getProv(newProvince).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        Menu_InGame_View_BPort.build(newProvince);
                    }
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_PortCities_L1_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_PortCities_L1_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_PortCities_L1(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_PortCities_L1(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(RenderProvince.getProvincePortColor(CFG.core.getPIV(i)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(RenderProvince.getProvincePortColor(CFG.core.getPIV(i)));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_LEVEL_OF_FORTIFICATIONS_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public boolean canMoveArmy() {
                return super.canMoveArmy() && !BuildingsManager.buildBySelectingProvinceOnMap;
            }

            @Override
            public ME_Hover getProvinceInformation() {
                block4: {
                    try {
                        if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfFort() > 0 && CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Image_Big(Images.bFort));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(BuildingsManager.getFort_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfFort())) + ": "));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                return new ME_Hover_v2(nElements);
                            }
                            break block4;
                        }
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    }
                    catch (Exception exception) {
                        
                    }
                }
                return null;
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBForts(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBForts(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats()) {
                    int newCivID;
                    int oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince);
                    if (oldCivID != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                        CFG.menus.setVisible_InGame_ViewBForts(true);
                    } else if (BuildingsManager.buildBySelectingProvinceOnMap && !Menu_NextPlayerTurn.lockExtraAction && oldProvince >= 0 && newProvince >= 0 && CFG.core.getProv(newProvince).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        Menu_InGame_View_BForts.build(newProvince);
                    }
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Fort_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Fort_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Fort(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Fort(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(RenderProvince.getProvince_FortColor(CFG.core.getPIV(i)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(RenderProvince.getProvince_FortColor(CFG.core.getPIV(i)));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_LEVEL_OF_WATCH_TOWER_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public boolean canMoveArmy() {
                return super.canMoveArmy() && !BuildingsManager.buildBySelectingProvinceOnMap;
            }

            @Override
            public ME_Hover getProvinceInformation() {
                block4: {
                    try {
                        if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfWatchTower() > 0 && CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Image_Big(Images.bTower));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(BuildingsManager.getTower_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfWatchTower())) + ": "));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                return new ME_Hover_v2(nElements);
                            }
                            break block4;
                        }
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    }
                    catch (Exception exception) {
                        
                    }
                }
                return null;
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBTowers(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBTowers(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats()) {
                    int newCivID;
                    int oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince);
                    if (oldCivID != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                        CFG.menus.setVisible_InGame_ViewBTowers(true);
                    } else if (BuildingsManager.buildBySelectingProvinceOnMap && !Menu_NextPlayerTurn.lockExtraAction && oldProvince >= 0 && newProvince >= 0 && CFG.core.getProv(newProvince).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        Menu_InGame_View_BTowers.build(newProvince);
                    }
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_WatchTower_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_WatchTower_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_WatchTower(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(RenderProvince.getProvince_WatchTowerColor(CFG.core.getPIV(i)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(RenderProvince.getProvince_WatchTowerColor(CFG.core.getPIV(i)));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        this.initFarms();
        this.initLibrary();
        this.initMarket();
        this.initSupply();
        this.initWorkshop();
        this.initArmoury();
        this.initWonders();
        this.initPopulationChange();
        this.initEconomicChange();
        this.initInvestsEco();
        this.initInvestsDev();
        this.initFestivals();
        this.initAssimilations();
        this.initWars();
        VIEW_IDEOLOGIES_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() <= 0) {
                            return null;
                        }
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    }
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getIdeology()).getName(), CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getIdeology()).getColor()));
                    nData.add(new ME_Hover_2Type_Ideology_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getIdeology(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewGovernments(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewGovernments(false);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                CFG.core.drawHighlightProvince(oSB);
                CFG.core.updateHighlitghtProvinceBorder(oSB);
                RenderProvince.drawProvincesBorder_Only_CivilizationBorder_Capitals_FogOfWarDiscovery(oSB);
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                CFG.core.drawHighlightProvince(oSB);
                CFG.core.updateHighlitghtProvinceBorder(oSB);
                RenderProvince.drawProvincesBorder_Only_CivilizationBorder_Capitals(oSB);
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() > 0) {
                        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                            oSB.setColor(CFG.core.getProv(CFG.core.getPIV(i)).isCapital() ? new Color(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getIdeology()).getColor().r, CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getIdeology()).getColor().g, CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getIdeology()).getColor().b, CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getIdeology()).getColor().a * 1.1f) : CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getIdeology()).getColor());
                        } else {
                            oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        continue;
                    }
                    oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() <= 0) continue;
                    oSB.setColor(CFG.core.getProv(CFG.core.getPIV(i)).isCapital() ? new Color(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getIdeology()).getColor().r, CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getIdeology()).getColor().g, CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getIdeology()).getColor().b, CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getIdeology()).getColor().a * 1.1f) : CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getIdeology()).getColor());
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_RELIGION_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() <= 0) {
                            return null;
                        }
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    }
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.religionManager.getReligion(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getReligionID()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Religion_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getReligionID(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewReligions(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewReligions(false);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                CFG.core.drawHighlightProvince(oSB);
                CFG.core.updateHighlitghtProvinceBorder(oSB);
                RenderProvince.drawProvincesBorder_Only_CivilizationBorder_Capitals_FogOfWarDiscovery(oSB);
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                CFG.core.drawActiveProvince(oSB);
                CFG.core.drawHighlightProvince(oSB);
                CFG.core.updateHighlitghtProvinceBorder(oSB);
                RenderProvince.drawProvincesBorder_Only_CivilizationBorder_Capitals(oSB);
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, CFG.map.getMpS().getCurrSc());
                } else if (!Render.DISABLE_CITIES) {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() > 0) {
                        if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                            oSB.setColor(CFG.core.getProv(CFG.core.getPIV(i)).isCapital() ? new Color(CFG.religionManager.getReligion((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getReligionID()).getColor().r, CFG.religionManager.getReligion((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getReligionID()).getColor().g, CFG.religionManager.getReligion((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getReligionID()).getColor().b, CFG.religionManager.getReligion((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getReligionID()).getColor().a * 1.1f) : CFG.religionManager.getReligion(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getReligionID()).getColor());
                        } else {
                            oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        continue;
                    }
                    oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() <= 0) continue;
                    oSB.setColor(CFG.core.getProv(CFG.core.getPIV(i)).isCapital() ? new Color(CFG.religionManager.getReligion((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getReligionID()).getColor().r, CFG.religionManager.getReligion((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getReligionID()).getColor().g, CFG.religionManager.getReligion((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getReligionID()).getColor().b, CFG.religionManager.getReligion((int)CFG.core.getCiv((int)CFG.core.getProv((int)CFG.core.getPIV((int)i)).getCivId()).getReligionID()).getColor().a * 1.1f) : CFG.religionManager.getReligion(CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).getReligionID()).getColor());
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_RECRUITABLE_ARMY_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RecruitablePopulation") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getNumberWthSpaces("" + CFG.gameAction.gMARY(CFG.menus.getHoveredProvinceID(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmy, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updateMaxRecruitable();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewRecruitable(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewRecruitable(false);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    float tRecr = 0.0f;
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        tRecr = (float)CFG.gameAction.gMARY(CFG.core.getPIV(i), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / (float)ECONOMY_MAX;
                        oSB.setColor(CFG.getColorStep(CFG.COLOR_RECRUITABLE_MIN, CFG.COLOR_RECRUITABLE_MAX, (int)(tRecr * 100.0f), 100, 0.5f));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                float tRecr = 0.0f;
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    tRecr = (float)CFG.gameAction.gMARY(CFG.core.getPIV(i), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / (float)ECONOMY_MAX;
                    oSB.setColor(CFG.getColorStep(CFG.COLOR_RECRUITABLE_MIN, CFG.COLOR_RECRUITABLE_MAX, (int)((float)CFG.gameAction.gMARY(CFG.core.getPIV(i), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) / (float)ECONOMY_MAX * 100.0f), 100, 0.5f));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_AI_POTENTIAL_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                return null;
            }

            @Override
            public void enableViewAction() {
                CFG.oAI.buildAI_Data();
                MapModesManager.updateMaxPotential();
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).getArmyObject(0).updateArmyWidth("" + CFG.core.getProv(i).getPotential());
                }
            }

            @Override
            public void disableViewAction() {
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).getArmyObject(0).updateArmyWidth_Just(i);
                }
            }
        }, new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvinces_Potential(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawProvinces_Potential(oSB, 1.0f);
                }
            }
        }, new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(CFG.getColorStep(new Color(1.0f, 1.0f, 1.0f, 1.0f), new Color(0.11764706f, 0.13725491f, 0.29411766f, 1.0f), (int)((float)CFG.core.getProv(CFG.core.getPIV(i)).getPotential() / (float)ECONOMY_MAX * 100.0f), 100, 0.5f));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_AI_DANGER_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                return null;
            }

            @Override
            public void enableViewAction() {
                CFG.oAI.buildAI_Data();
                MapModesManager.updateMaxDanger();
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).getArmyObject(0).updateArmyWidth("" + CFG.core.getProv(i).getDangerLvl());
                }
            }

            @Override
            public void disableViewAction() {
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).getArmyObject(0).updateArmyWidth_Just(i);
                }
            }
        }, new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvinces_Danger(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawProvinces_Danger(oSB, 1.0f);
                }
            }
        }, new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(CFG.getColorStep(new Color(1.0f, 1.0f, 1.0f, 1.0f), new Color(0.7254902f, 0.11764706f, 0.11764706f, 1.0f), (int)((float)CFG.core.getProv(CFG.core.getPIV(i)).getDangerLvl() / (float)ECONOMY_MAX * 100.0f), 100, 0.5f));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_BALANCE_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() <= 0) {
                        return null;
                    }
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Balance") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big("" + CFG.gameUpdate.getBalanceCivId(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updateMaxBalance();
            }

            @Override
            public void disableViewAction() {
            }
        }, new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, 1.0f);
                }
            }
        }, new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() <= 0) continue;
                    oSB.setColor(CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, (int)((float)CFG.gameUpdate.getBalanceCivId(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()) / (float)ECONOMY_MAX * 100.0f), 100, 0.5f));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_TRUE_OWNERS_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getTrueOwnerOfProv()).getCivName(), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getTrueOwnerOfProv(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                return new ME_Hover_v2(nElements);
            }

            @Override
            public void enableViewAction() {
            }

            @Override
            public void disableViewAction() {
            }
        }, new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
            }
        }, new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getTrueOwnerOfProv() == 0) continue;
                    oSB.setColor((float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getTrueOwnerOfProv()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getTrueOwnerOfProv()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getTrueOwnerOfProv()).getB() / 255.0f, (float)CFG.settingsGD.PROV_ALPHA / 255.0f);
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        VIEW_DISEASES_MODE = this.addViewToTheGame(new MapMode(){

            
            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivsSize() > 1 && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(CFG.menus.getHoveredProvinceID())) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            for (int i = 1; i < CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivsSize(); ++i) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(i)));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(i)).getCivName()));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            return new ME_Hover_v2(nElements);
                        } else {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) return null;
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        return new ME_Hover_v2(nElements);
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        if (CFG.core.getProv((int)CFG.menus.getHoveredProvinceID()).provGD.provincePlague == null) return new ME_Hover_v2(nElements);
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Name") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.plagueManager.getPlague_InGame(CFG.core.getProv((int)CFG.menus.getHoveredProvinceID()).provGD.provincePlague.iPlagueID_InGame).getPlagueName(), CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(Images.disease, CFG.PADD, CFG.PADD));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Deaths") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getProv((int)CFG.menus.getHoveredProvinceID()).provGD.provincePlague.iDeaths), CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                CFG.map.getMpB().updateWorldMap_Shaders();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_View_Diseases(true);
                }
            }

            @Override
            public void disableViewAction() {
                CFG.map.getMpB().updateWorldMap_Shaders();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_View_Diseases(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        try {
                            if (CFG.core.getProv((int)CFG.core.getPIV((int)i)).provGD.provincePlague != null) {
                                oSB.setColor(CFG.plagueManager.getPlagueColor_InGame(CFG.core.getPIV(i), CFG.core.getProv((int)CFG.core.getPIV((int)i)).provGD.provincePlague.iPlagueID_InGame, 0.725f));
                            } else {
                                oSB.setColor(new Color(CFG.COLOR_PROVINCE_ARMY_MIN.r, CFG.COLOR_PROVINCE_ARMY_MIN.g, CFG.COLOR_PROVINCE_ARMY_MIN.b, 0.027187502f));
                            }
                        }
                        catch (Exception ex) {
                            oSB.setColor(new Color(CFG.COLOR_PROVINCE_ARMY_MIN.r, CFG.COLOR_PROVINCE_ARMY_MIN.g, CFG.COLOR_PROVINCE_ARMY_MIN.b, 0.027187502f));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        continue;
                    }
                    oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    try {
                        if (CFG.core.getProv((int)CFG.core.getPIV((int)i)).provGD.provincePlague != null) {
                            oSB.setColor(CFG.plagueManager.getPlagueColor_InGame(CFG.core.getPIV(i), CFG.core.getProv((int)CFG.core.getPIV((int)i)).provGD.provincePlague.iPlagueID_InGame, 0.725f));
                        } else {
                            oSB.setColor(new Color(CFG.COLOR_PROVINCE_ARMY_MIN.r, CFG.COLOR_PROVINCE_ARMY_MIN.g, CFG.COLOR_PROVINCE_ARMY_MIN.b, 0.027187502f));
                        }
                    }
                    catch (Exception ex) {
                        oSB.setColor(new Color(CFG.COLOR_PROVINCE_ARMY_MIN.r, CFG.COLOR_PROVINCE_ARMY_MIN.g, CFG.COLOR_PROVINCE_ARMY_MIN.b, 0.027187502f));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
        this.initFans();
        this.lMapModes.get((int)MapModesManager.VIEW_TECHNOLOGY_MODE).drawCivNamesOver = true;
        this.lMapModes.get((int)MapModesManager.VIEW_IDEOLOGIES_MODE).drawCivNamesOver = true;
        this.lMapModes.get((int)MapModesManager.VIEW_RELIGION_MODE).drawCivNamesOver = true;
        this.lMapModes.get((int)MapModesManager.VIEW_DIPLOMACY_MODE).drawCivNamesOver = true;
        this.lMapModes.get((int)MapModesManager.VIEW_ALLIANCES_MODE).drawCivNamesOver = true;
        this.lMapModes.get((int)MapModesManager.VIEW_IMPERIAL_MODE).drawCivNamesOver = true;
        this.lMapModes.get((int)MapModesManager.VIEW_PROVINCE_STABILITY_MODE).drawCivNamesOver = true;
        this.lMapModes.get((int)MapModesManager.VIEW_SUPPLIES_MODE).drawCivNamesOver = true;
        this.lMapModes.get((int)MapModesManager.VIEW_BUILDINGS_MODE).drawCivNamesOver = true;
        this.lMapModes.get((int)MapModesManager.VIEW_INCOME_ALL_MODE).drawCivNamesOver = true;
        this.lMapModes.get((int)MapModesManager.VIEW_INCOME_TAXATION_MODE).drawCivNamesOver = true;
        this.lMapModes.get((int)MapModesManager.VIEW_INCOME_PRODUCTION_MODE).drawCivNamesOver = true;
        this.lMapModes.get((int)MapModesManager.VIEW_RECRUITABLE_ARMY_MODE).drawCivNamesOver = true;
        this.lMapModes.get((int)MapModesManager.VIEW_ARMY_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_ECONOMY_CHANGE_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_POPULATION_CHANGE_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_POPULATION_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_ECONOMY_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_INCOME_ALL_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_INCOME_TAXATION_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_INCOME_PRODUCTION_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_TERRAIN_TYPE_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_GROWTH_RATE_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_RECRUITABLE_ARMY_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_LEVEL_OF_FORTIFICATIONS_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_LEVEL_OF_WATCH_TOWER_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_LEVEL_OF_FARM_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_LEVEL_OF_LIBRARY_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_LEVEL_OF_ARMOURY_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_LEVEL_OF_MARKET_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_LEVEL_OF_SUPPLY_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_WONDERS_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_LEVEL_OF_WORKSHOP_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_LEVEL_OF_PORT_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_DEVELOPMENT_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_REVOLUTION_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_PROVINCE_VALUE_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_PROVINCE_STABILITY_MODE).canMoveArmy = true;
        this.lMapModes.get((int)MapModesManager.VIEW_SUPPLIES_MODE).canMoveArmy = true;
    }

    public void initInvestsEco() {
        VIEW_INVESTS_ECO_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getEco()), CFG.COLOR_ECONOMY));
                        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        long diff = (long)CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getEco() - CFG.core.getProv((int)CFG.menus.getHoveredProvinceID()).provGD.startingEconomy;
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomicChange") + ": "));
                        nData.add(new ME_Hover_2Type_Text((diff > 0 ? "+" : "") + CFG.getNumberWthSpaces("" + diff), diff > 0 ? CFG.COLOR_POSITIVE : (diff == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_1)));
                        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewInvestsEco(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewInvestsEco(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(RenderProvince.getProvince_InvestEcoColor(CFG.core.getPIV(i)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(RenderProvince.getProvince_InvestEcoColor(CFG.core.getPIV(i)));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
    }

    public void initInvestsDev() {
        VIEW_INVESTS_DEV_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).isCapital()) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyLevel") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getTechLevel() * 100.0f)) / 100.0f, CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Development") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (float)((int)(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getDeveLvl() * 100.0f)) / 100.0f, CFG.COLOR_POPULATION));
                        nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewInvestsDev(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewInvestsDev(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(RenderProvince.getProvince_InvestDevColor(CFG.core.getPIV(i)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(RenderProvince.getProvince_InvestDevColor(CFG.core.getPIV(i)));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
    }

    public void initFestivals() {
        VIEW_FESTIVALS_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Happiness") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getHappi() * 100.0f) + "%", CFG.COLOR_HAPPINESS_MAX));
                        nData.add(new ME_Hover_2Type_Image(CFG.getHappinessImage((int)(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getHappi() * 100.0f)), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewFestivals(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewFestivals(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(RenderProvince.getProvince_FestivalsColor(CFG.core.getPIV(i)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(RenderProvince.getProvince_FestivalsColor(CFG.core.getPIV(i)));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
    }

    public void initAssimilations() {
        VIEW_ASSIMILATIONS_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ProvinceStability") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getProviStability() * 100.0f) + "%", CFG.COLOR_HAPPINESS_MAX));
                        nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewAssimilations(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewAssimilations(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(RenderProvince.getProvince_AssimilationColor(CFG.core.getPIV(i)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(RenderProvince.getProvince_AssimilationColor(CFG.core.getPIV(i)));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
    }

    public void initArmoury() {
        VIEW_LEVEL_OF_ARMOURY_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public boolean canMoveArmy() {
                return super.canMoveArmy() && !BuildingsManager.buildBySelectingProvinceOnMap;
            }

            @Override
            public ME_Hover getProvinceInformation() {
                block4: {
                    try {
                        if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfArmoury() > 0 && CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Image_Big(Images.bArmoury, 0, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(BuildingsManager.getArmoury_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfArmoury())) + ": "));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                return new ME_Hover_v2(nElements);
                            }
                            break block4;
                        }
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    }
                    catch (Exception exception) {
                        
                    }
                }
                return null;
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBArmoury(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBArmoury(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats()) {
                    int newCivID;
                    int oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince);
                    if (oldCivID != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                        CFG.menus.setVisible_InGame_ViewBArmoury(true);
                    } else if (BuildingsManager.buildBySelectingProvinceOnMap && !Menu_NextPlayerTurn.lockExtraAction && oldProvince >= 0 && newProvince >= 0 && CFG.core.getProv(newProvince).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        Menu_InGame_View_BArmoury.build(newProvince);
                    }
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Armoury_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Armoury_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Armoury(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(RenderProvince.getProvince_ArmouryColor(CFG.core.getPIV(i)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(RenderProvince.getProvince_ArmouryColor(CFG.core.getPIV(i)));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
    }

    public void initLibrary() {
        VIEW_LEVEL_OF_LIBRARY_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public boolean canMoveArmy() {
                return super.canMoveArmy() && !BuildingsManager.buildBySelectingProvinceOnMap;
            }

            @Override
            public ME_Hover getProvinceInformation() {
                block4: {
                    try {
                        if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfLibrary() > 0 && CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Image_Big(Images.bLibrary, 0, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(BuildingsManager.getLibrary_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfLibrary())) + ": "));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                return new ME_Hover_v2(nElements);
                            }
                            break block4;
                        }
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    }
                    catch (Exception exception) {
                        
                    }
                }
                return null;
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBLibrary(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBLibrary(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats()) {
                    int newCivID;
                    int oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince);
                    if (oldCivID != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                        CFG.menus.setVisible_InGame_ViewBLibrary(true);
                    } else if (BuildingsManager.buildBySelectingProvinceOnMap && !Menu_NextPlayerTurn.lockExtraAction && oldProvince >= 0 && newProvince >= 0 && CFG.core.getProv(newProvince).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        Menu_InGame_View_BLibrary.build(newProvince);
                    }
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Library_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Library_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Library(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(RenderProvince.getProvince_LibraryColor(CFG.core.getPIV(i)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(RenderProvince.getProvince_LibraryColor(CFG.core.getPIV(i)));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
    }

    public void initMarket() {
        VIEW_LEVEL_OF_MARKET_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public boolean canMoveArmy() {
                return super.canMoveArmy() && !BuildingsManager.buildBySelectingProvinceOnMap;
            }

            @Override
            public ME_Hover getProvinceInformation() {
                block4: {
                    try {
                        if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfMarket() > 0 && CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Image_Big(Images.bMarket, 0, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(BuildingsManager.getMarket_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfMarket())) + ": "));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                return new ME_Hover_v2(nElements);
                            }
                            break block4;
                        }
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    }
                    catch (Exception exception) {
                        
                    }
                }
                return null;
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBMarket(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBMarket(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats()) {
                    int newCivID;
                    int oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince);
                    if (oldCivID != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                        CFG.menus.setVisible_InGame_ViewBMarket(true);
                    } else if (BuildingsManager.buildBySelectingProvinceOnMap && !Menu_NextPlayerTurn.lockExtraAction && oldProvince >= 0 && newProvince >= 0 && CFG.core.getProv(newProvince).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        Menu_InGame_View_BMarket.build(newProvince);
                    }
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Market_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Market_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Market(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(RenderProvince.getProvince_MarketColor(CFG.core.getPIV(i)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(RenderProvince.getProvince_MarketColor(CFG.core.getPIV(i)));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
    }

    public void initSupply() {
        VIEW_LEVEL_OF_SUPPLY_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public boolean canMoveArmy() {
                return super.canMoveArmy() && !BuildingsManager.buildBySelectingProvinceOnMap;
            }

            @Override
            public ME_Hover getProvinceInformation() {
                block4: {
                    try {
                        if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfSupply() > 0 && CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Image_Big(Images.bSupply, 0, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(BuildingsManager.getSupply_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfSupply())) + ": "));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                return new ME_Hover_v2(nElements);
                            }
                            break block4;
                        }
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    }
                    catch (Exception exception) {
                        
                    }
                }
                return null;
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBSupply(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBSupply(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats()) {
                    int newCivID;
                    int oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince);
                    if (oldCivID != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                        CFG.menus.setVisible_InGame_ViewBSupply(true);
                    } else if (BuildingsManager.buildBySelectingProvinceOnMap && !Menu_NextPlayerTurn.lockExtraAction && oldProvince >= 0 && newProvince >= 0 && CFG.core.getProv(newProvince).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        Menu_InGame_View_BSupply.build(newProvince);
                    }
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Supply_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Supply_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Supply(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(RenderProvince.getProvince_SupplyColor(CFG.core.getPIV(i)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(RenderProvince.getProvince_SupplyColor(CFG.core.getPIV(i)));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
    }

    public void initWorkshop() {
        VIEW_LEVEL_OF_WORKSHOP_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public boolean canMoveArmy() {
                return super.canMoveArmy() && !BuildingsManager.buildBySelectingProvinceOnMap;
            }

            @Override
            public ME_Hover getProvinceInformation() {
                block4: {
                    try {
                        if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfWorkshop() > 0 && CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Image_Big(Images.bWorkshop, 0, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(BuildingsManager.getWorkshop_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfWorkshop())) + ": "));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                return new ME_Hover_v2(nElements);
                            }
                            break block4;
                        }
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    }
                    catch (Exception exception) {
                        
                    }
                }
                return null;
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBWorkshop(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBWorkshop(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats()) {
                    int newCivID;
                    int oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince);
                    if (oldCivID != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                        CFG.menus.setVisible_InGame_ViewBWorkshop(true);
                    } else if (BuildingsManager.buildBySelectingProvinceOnMap && !Menu_NextPlayerTurn.lockExtraAction && oldProvince >= 0 && newProvince >= 0 && CFG.core.getProv(newProvince).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        Menu_InGame_View_BWorkshop.build(newProvince);
                    }
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Workshop_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Workshop_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Workshop(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(RenderProvince.getProvince_WorkshopColor(CFG.core.getPIV(i)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(RenderProvince.getProvince_WorkshopColor(CFG.core.getPIV(i)));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
    }

    public void initFarms() {
        VIEW_LEVEL_OF_FARM_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public boolean canMoveArmy() {
                return super.canMoveArmy() && !BuildingsManager.buildBySelectingProvinceOnMap;
            }

            @Override
            public ME_Hover getProvinceInformation() {
                block4: {
                    try {
                        if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfFarm() > 0 && CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Image_Big(Images.bFarm, 0, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(BuildingsManager.getFarm_Name(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getLvlOfFarm())) + ": "));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                return new ME_Hover_v2(nElements);
                            }
                            break block4;
                        }
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    }
                    catch (Exception exception) {
                        
                    }
                }
                return null;
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBFarms(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewBFarms(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
                if (CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_View_Stats()) {
                    int newCivID;
                    int oldCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(oldProvince);
                    if (oldCivID != (newCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(newProvince))) {
                        CFG.menus.setVisible_InGame_ViewBFarms(true);
                    } else if (BuildingsManager.buildBySelectingProvinceOnMap && !Menu_NextPlayerTurn.lockExtraAction && oldProvince >= 0 && newProvince >= 0 && CFG.core.getProv(newProvince).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        Menu_InGame_View_BFarms.build(newProvince);
                    }
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Farm_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Farm_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Farm(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(RenderProvince.getProvince_FarmColor(CFG.core.getPIV(i)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(RenderProvince.getProvince_FarmColor(CFG.core.getPIV(i)));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
    }

    public void initWonders() {
        VIEW_WONDERS_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public boolean canMoveArmy() {
                return super.canMoveArmy() && !BuildingsManager.buildBySelectingProvinceOnMap;
            }

            @Override
            public ME_Hover getProvinceInformation() {
                block4: {
                    try {
                        if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWonderSize() > 0) {
                                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(CFG.core.getProv((int)CFG.menus.getHoveredProvinceID()).getWonder((int)0).sName), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nData.add(new ME_Hover_2Type_WonderBig(CFG.menus.getHoveredProvinceID(), 0, CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                return new ME_Hover_v2(nElements);
                            }
                            break block4;
                        }
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        return new ME_Hover_v2(nElements);
                    }
                    catch (Exception exception) {
                        
                    }
                }
                return null;
            }

            @Override
            public void enableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewWonders(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewWonders(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawWonders_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Wonders_FogOfWarDiscovery2(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails() && Render.drawInGame_MapDetails()) {
                    CFG.core.drawWonders_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Wonders_FogOfWarDiscovery2(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                Render.drawInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    CFG.core.drawWonders_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_Wonders2(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    CFG.core.drawWonders_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getPIV(i))) {
                        oSB.setColor(RenderProvince.getProvince_WonderColor(CFG.core.getPIV(i)));
                    } else {
                        oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    oSB.setColor(RenderProvince.getProvince_WonderColor(CFG.core.getPIV(i)));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
    }

    public void initEconomicChange() {
        VIEW_ECONOMY_CHANGE_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public boolean canMoveArmy() {
                return super.canMoveArmy() && !BuildingsManager.buildBySelectingProvinceOnMap;
            }

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getEco()), CFG.COLOR_ECONOMY));
                        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        long diff = (long)CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getEco() - CFG.core.getProv((int)CFG.menus.getHoveredProvinceID()).provGD.startingEconomy;
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomicChange") + ": "));
                        nData.add(new ME_Hover_2Type_Text((diff > 0 ? "+" : "") + CFG.getNumberWthSpaces("" + diff), diff > 0 ? CFG.COLOR_POSITIVE : (diff == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_1)));
                        nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updateEconomicChange();
                RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER = System.currentTimeMillis();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewEconomicChange(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewEconomicChange(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.getMetProv(CFG.core.getPIV(i))) {
                        long popDiff = (long)CFG.core.getProv(CFG.core.getPIV(i)).getEco() - CFG.core.getProv((int)CFG.core.getPIV((int)i)).provGD.startingEconomy;
                        if (popDiff == 0) {
                            oSB.setColor(new Color(CFG.COLOR_PORT_m1.r, CFG.COLOR_PORT_m1.g, CFG.COLOR_PORT_m1.b, 0.5f));
                        } else if (popDiff > 0) {
                            oSB.setColor(CFG.getPopulationColor((int)((float)popDiff / (float)POPULATION_MAX * 100.0f), 0.5f));
                        } else {
                            oSB.setColor(CFG.getPopulationColorRed((int)((float)(-popDiff) / (float)(-POPULATION_MIN) * 100.0f), 0.5f));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        continue;
                    }
                    oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    long popDiff = (long)CFG.core.getProv(CFG.core.getPIV(i)).getEco() - CFG.core.getProv((int)CFG.core.getPIV((int)i)).provGD.startingEconomy;
                    if (popDiff == 0) {
                        oSB.setColor(new Color(CFG.COLOR_PORT_m1.r, CFG.COLOR_PORT_m1.g, CFG.COLOR_PORT_m1.b, 0.5f));
                    } else if (popDiff > 0) {
                        oSB.setColor(CFG.getPopulationColor((int)((float)popDiff / (float)POPULATION_MAX * 100.0f), 0.5f));
                    } else {
                        oSB.setColor(CFG.getPopulationColorRed((int)((float)(-popDiff) / (float)(-POPULATION_MIN) * 100.0f), 0.5f));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
    }

    public void initPopulationChange() {
        VIEW_POPULATION_CHANGE_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            } else {
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getPop().getPops()), CFG.COLOR_POPULATION));
                        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        long diff = (long)CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getPop().getPops() - CFG.core.getProv((int)CFG.menus.getHoveredProvinceID()).provGD.startingPopulation;
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PopulationChange") + ": "));
                        nData.add(new ME_Hover_2Type_Text((diff > 0 ? "+" : "") + CFG.getNumberWthSpaces("" + diff), diff > 0 ? CFG.COLOR_POSITIVE : (diff == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_1)));
                        nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                MapModesManager.updatePopulationChange();
                RenderProvince.PROVINCE_COLOR_ANIMATION_TIMER = System.currentTimeMillis();
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_ViewPopulationChange(true);
                }
            }

            @Override
            public void disableViewAction() {
                if (CFG.menus.getInGameView()) {
                    CFG.menus.setVisible_InGame_View(false);
                }
            }

            @Override
            public void updateActiveProvinceID_ExtraAction(int oldProvince, int newProvince) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_Just(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_Just(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.getMetProv(CFG.core.getPIV(i))) {
                        long popDiff = (long)CFG.core.getProv(CFG.core.getPIV(i)).getPop().getPops() - CFG.core.getProv((int)CFG.core.getPIV((int)i)).provGD.startingPopulation;
                        if (popDiff == 0) {
                            oSB.setColor(new Color(CFG.COLOR_PORT_m1.r, CFG.COLOR_PORT_m1.g, CFG.COLOR_PORT_m1.b, 0.5f));
                        } else if (popDiff > 0) {
                            oSB.setColor(CFG.getPopulationColor((int)((float)popDiff / (float)POPULATION_MAX * 100.0f), 0.5f));
                        } else {
                            oSB.setColor(CFG.getPopulationColorRed((int)((float)(-popDiff) / (float)(-POPULATION_MIN) * 100.0f), 0.5f));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        continue;
                    }
                    oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    long popDiff = (long)CFG.core.getProv(CFG.core.getPIV(i)).getPop().getPops() - CFG.core.getProv((int)CFG.core.getPIV((int)i)).provGD.startingPopulation;
                    if (popDiff == 0) {
                        oSB.setColor(new Color(CFG.COLOR_PORT_m1.r, CFG.COLOR_PORT_m1.g, CFG.COLOR_PORT_m1.b, 0.5f));
                    } else if (popDiff > 0) {
                        oSB.setColor(CFG.getPopulationColor((int)((float)popDiff / (float)POPULATION_MAX * 100.0f), 0.5f));
                    } else {
                        oSB.setColor(CFG.getPopulationColorRed((int)((float)(-popDiff) / (float)(-POPULATION_MIN) * 100.0f), 0.5f));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
    }

    public void initWars() {
        VIEW_WARS_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (!CFG.getMetProv(CFG.menus.getHoveredProvinceID())) {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getWastelandLvl() >= 0) {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Wasteland"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() <= 0) {
                            return null;
                        }
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else if (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.menus.getHoveredProvinceID())) {
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                            if (CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).isAtWarC()) {
                                nData.add(new ME_Hover_2Type_Text_Big(":", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Text_Big(" " + CFG.core.getCiv((int)CFG.core.getProv((int)CFG.menus.getHoveredProvinceID()).getCivId()).isAtWarWithCivs.size()));
                            }
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            if (CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).isAtWarC()) {
                                for (int a = 0; a < CFG.core.getCiv((int)CFG.core.getProv((int)CFG.menus.getHoveredProvinceID()).getCivId()).isAtWarWithCivs.size(); ++a) {
                                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getCiv((int)CFG.core.getProv((int)CFG.menus.getHoveredProvinceID()).getCivId()).isAtWarWithCivs.get(a), 0, CFG.PADD));
                                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getProv((int)CFG.menus.getHoveredProvinceID()).getCivId()).isAtWarWithCivs.get(a)).getCivName()));
                                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                                    nElements.add(new MEHover_2E(nData));
                                    nData.clear();
                                }
                            } else {
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("NoWars")));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.diploTruce, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                        } else if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName().length() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getName(), CFG.COLOR_HOVER_TITLE));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    } else {
                        nData.add(new ME_Hover_2Type_Flag_Big(-1));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Undiscovered"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                CFG.menus.setVisible_InGame_ViewWars(true);
            }

            @Override
            public void disableViewAction() {
                CFG.menus.setVisible_InGame_ViewWars(false);
            }

            @Override
            public void updateActiveCivInfo_ExtraAction(int newCivID) {
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                RenderProvince.drawOccupiedProvinces_FogOfWar(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                } else {
                    CFG.core.drawCities_OnlyCapitals_Images_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                RenderProvince.drawOccupiedProvinces(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_Just_OnlyCapitalMode(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, CFG.map.getMpS().getCurrSc());
                } else {
                    CFG.core.drawCities_OnlyCapitals_Images(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_OnlyCapitals(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawCapitalsArmy_FlagAndCrown(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int nActiveCivID = 0;
                nActiveCivID = CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.getMetProv(CFG.core.getActiveProvID()) ? CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() : CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() > 0) {
                        if (!CFG.getMetProv(CFG.core.getPIV(i))) {
                            oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                        } else if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).isAtWarC()) {
                            if (nActiveCivID == CFG.core.getProv(CFG.core.getPIV(i)).getCivId()) {
                                oSB.setColor(new Color(CFG.COLOR_WAR_DARK.r, CFG.COLOR_WAR_DARK.g, CFG.COLOR_WAR_DARK.b, CFG.ALPHA_DIPLOMACY));
                            } else if (CFG.core.getCivsAtWar(nActiveCivID, CFG.core.getProv(CFG.core.getPIV(i)).getCivId())) {
                                oSB.setColor(new Color(CFG.COLOR_WAR_DARK.r, CFG.COLOR_WAR_DARK.g, CFG.COLOR_WAR_DARK.b, CFG.ALPHA_DIPLOMACY));
                            } else {
                                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), CFG.ALPHA_DIPLOMACY));
                            }
                        } else {
                            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                        continue;
                    }
                    if (CFG.getMetProv(CFG.core.getPIV(i))) continue;
                    oSB.setColor(new Color(CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getR(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getG(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY.getB(), CFG.settingsGD.COLOR_PROVINCE_DISCOVERY_ALPHA));
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                int nActiveCivID = 0;
                nActiveCivID = CFG.core.getActiveProvID() >= 0 && !CFG.core.getProv(CFG.core.getActiveProvID()).getSeaProv() && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() > 0 && CFG.getMetProv(CFG.core.getActiveProvID()) ? CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() : CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                    if (CFG.core.getProv(CFG.core.getPIV(i)).getCivId() <= 0) continue;
                    if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getPIV(i)).getCivId()).isAtWarC()) {
                        if (nActiveCivID == CFG.core.getProv(CFG.core.getPIV(i)).getCivId()) {
                            oSB.setColor(new Color(CFG.COLOR_WAR_DARK.r, CFG.COLOR_WAR_DARK.g, CFG.COLOR_WAR_DARK.b, CFG.ALPHA_DIPLOMACY));
                        } else if (CFG.core.getCivsAtWar(nActiveCivID, CFG.core.getProv(CFG.core.getPIV(i)).getCivId())) {
                            oSB.setColor(new Color(CFG.COLOR_WAR_DARK.r, CFG.COLOR_WAR_DARK.g, CFG.COLOR_WAR_DARK.b, CFG.ALPHA_DIPLOMACY));
                        } else {
                            oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), CFG.ALPHA_DIPLOMACY));
                        }
                    } else {
                        oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_NEUTRAL.getB(), CFG.ALPHA_DIPLOMACY * 3.0f / 5.0f));
                    }
                    CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                }
            }
        });
    }

    private final int addViewToTheGame(MapMode nView, Render.Renderer nRenderer, RenderProvince.DrawProvinces nDrawProvinces) {
        nView.oRenderer = nRenderer;
        nView.drawProvinces = nDrawProvinces;
        this.lMapModes.add(nView);
        return this.lMapModes.size() - 1;
    }

    public final void setActiveMapModeID(int iID, boolean viewConfig) {
        this.viewConfig = viewConfig;
        this.setActiveMapModeID(iID);
    }

    public final void setActiveMapModeID(int iID) {
        try {
            if (this.iActiveMapModeID == iID) {
                int tempActive = this.iActiveMapModeID;
                this.iActiveMapModeID = -1;
                this.lMapModes.get(tempActive).disableViewAction();
            } else if (this.iActiveMapModeID >= 0) {
                int tempActive = this.iActiveMapModeID;
                this.iActiveMapModeID = iID;
                this.lMapModes.get(tempActive).disableViewAction();
                this.lMapModes.get(iID).enableViewAction();
            } else {
                this.iActiveMapModeID = iID;
                this.lMapModes.get(iID).enableViewAction();
            }
        }
        catch (Exception ex) {
            this.iActiveMapModeID = -1;
        }
        if (this.iActiveMapModeID >= 0 && CFG.menus.getInGameView() && CFG.menus.getVisible_InGame_FlagAction()) {
            CFG.menus.setVisible_InGame_FlagAction(false);
        }
        Render.updateRenderer();
        RenderProvince.updateDrawProvinces();
        Render.updateDrawMoveUnits();
        ProvinceMesh.needsUpdate = true;
        CFG.menus.updateBuildProvinceHoverInformation();
        if (RTS.isEnabled() && !RTS.PAUSE) {
            RTS.updateTimePast_AfterAction(0.75f);
        }
    }

    public final void disableAllViews() {
        if (this.iActiveMapModeID >= 0) {
            int tempActive = this.iActiveMapModeID;
            this.iActiveMapModeID = -1;
            this.lMapModes.get(tempActive).disableViewAction();
        }
        Render.updateRenderer();
        RenderProvince.updateDrawProvinces();
        Render.updateDrawMoveUnits();
        ProvinceMesh.needsUpdate = true;
        CFG.menus.updateBuildProvinceHoverInformation();
    }

    public static void updatePopulationChange() {
        POPULATION_MIN = 1L;
        POPULATION_MAX = 1L;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getCivId() <= 0) continue;
            if (CFG.core.getProv(i).getPop().getPops() - CFG.core.getProv((int)i).provGD.startingPopulation > POPULATION_MAX) {
                POPULATION_MAX = CFG.core.getProv(i).getPop().getPops() - CFG.core.getProv((int)i).provGD.startingPopulation;
            }
            if (CFG.core.getProv(i).getPop().getPops() - CFG.core.getProv((int)i).provGD.startingPopulation >= POPULATION_MIN) continue;
            POPULATION_MIN = CFG.core.getProv(i).getPop().getPops() - CFG.core.getProv((int)i).provGD.startingPopulation;
        }
        POPULATION_MIN = (long)((float)POPULATION_MIN * 0.75f);
        POPULATION_MAX = (long)((float)POPULATION_MAX * 0.75f);
        if (POPULATION_MIN >= 0L) {
            POPULATION_MIN = -1L;
        }
    }

    public static void updateEconomicChange() {
        POPULATION_MIN = 1L;
        POPULATION_MAX = 1L;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getCivId() <= 0) continue;
            if (CFG.core.getProv(i).getEco() - CFG.core.getProv((int)i).provGD.startingEconomy > POPULATION_MAX) {
                POPULATION_MAX = CFG.core.getProv(i).getEco() - CFG.core.getProv((int)i).provGD.startingEconomy;
            }
            if (CFG.core.getProv(i).getEco() - CFG.core.getProv((int)i).provGD.startingEconomy >= POPULATION_MIN) continue;
            POPULATION_MIN = CFG.core.getProv(i).getEco() - CFG.core.getProv((int)i).provGD.startingEconomy;
        }
        POPULATION_MIN = (long)((float)POPULATION_MIN * 0.75f);
        POPULATION_MAX = (long)((float)POPULATION_MAX * 0.75f);
        if (POPULATION_MIN >= 0L) {
            POPULATION_MIN = -1L;
        }
    }

    public static void updateMaxDeaths() {
        DEATHS_MAX = 1L;
        if (CFG.menus.getInGameView() && !CFG.SPECTATOR_MODE && CFG.FOG_OF_WAR == 2) {
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(i) || CFG.core.getCiv((int)i).civGD.ttWC <= DEATHS_MAX) continue;
                DEATHS_MAX = CFG.core.getCiv((int)i).civGD.ttWC;
            }
        } else {
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getCiv((int)i).civGD.ttWC <= DEATHS_MAX) continue;
                DEATHS_MAX = CFG.core.getCiv((int)i).civGD.ttWC;
            }
        }
        DEATHS_MAX = (long)((float)DEATHS_MAX * 0.625f);
    }

    public static void updateMaxPopulation() {
        POPULATION_MAX = 1L;
        if (CFG.menus.getInGameView() && !CFG.SPECTATOR_MODE && CFG.FOG_OF_WAR == 2) {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getSeaProv() || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(i) || CFG.core.getProv(i).getPop().getPops() <= POPULATION_MAX) continue;
                POPULATION_MAX = CFG.core.getProv(i).getPop().getPops();
            }
        } else {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getPop().getPops() <= POPULATION_MAX) continue;
                POPULATION_MAX = CFG.core.getProv(i).getPop().getPops();
            }
        }
        POPULATION_MAX = (long)((float)POPULATION_MAX * 0.775f);
    }

    public static final void updateMaxPopulationOfCivilization(int nCivID) {
        POPULATION_OF_CIVID = nCivID;
        POPULATION_MAX = 1L;
        for (int i = 0; i < CFG.core.getCiv(POPULATION_OF_CIVID).getNumOfProvs(); ++i) {
            if (CFG.core.getProv(CFG.core.getCiv(POPULATION_OF_CIVID).getProvID(i)).getSeaProv() || CFG.core.getProv(CFG.core.getCiv(POPULATION_OF_CIVID).getProvID(i)).getPop().getPops() <= POPULATION_MAX) continue;
            POPULATION_MAX = CFG.core.getProv(CFG.core.getCiv(POPULATION_OF_CIVID).getProvID(i)).getPop().getPops();
        }
    }

    public static void updateMaxIncome() {
        POPULATION_MAX = 0L;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.core.getProv(i).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(CFG.core.getProv(i).getCivId()).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
            CFG.core.getProv((int)i).incomeTaxation = CFG.gameUpdate.getProvIncomeTaxation(i);
            CFG.core.getProv((int)i).incomeProduction = CFG.gameUpdate.getProvIncomeProduction(i);
            CFG.core.getProv((int)i).administrationCost = CFG.gameUpdate.getProvinceAdministrationCost(i, CFG.gameUpdate.getAdministration_Capital(CFG.core.getProv(i).getCivId()));
            if ((long)CFG.core.getProv(i).getBalance_LastTurn() <= POPULATION_MAX) continue;
            POPULATION_MAX = (long)CFG.core.getProv(i).getBalance_LastTurn();
        }
    }

    public static void updateMaxIncome_All() {
        POPULATION_MAX = 0L;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(i)) continue;
            CFG.core.getProv((int)i).incomeTaxation = CFG.gameUpdate.getProvIncomeTaxation(i);
            CFG.core.getProv((int)i).incomeProduction = CFG.gameUpdate.getProvIncomeProduction(i);
            CFG.core.getProv((int)i).administrationCost = CFG.gameUpdate.getProvinceAdministrationCost(i, CFG.gameUpdate.getAdministration_Capital(CFG.core.getProv(i).getCivId()));
            if ((long)CFG.core.getProv(i).getBalance_LastTurn() <= POPULATION_MAX) continue;
            POPULATION_MAX = (long)CFG.core.getProv(i).getBalance_LastTurn();
        }
    }

    public static void updateMaxIncome_All_Taxation() {
        POPULATION_MAX = 0L;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(i)) continue;
            CFG.core.getProv((int)i).incomeTaxation = CFG.gameUpdate.getProvIncomeTaxation(i);
            if (!((long)CFG.core.getProv((int)i).incomeTaxation > POPULATION_MAX)) continue;
            POPULATION_MAX = (long)CFG.core.getProv((int)i).incomeTaxation;
        }
    }

    public static void updateMaxIncome_All_Production() {
        POPULATION_MAX = 0L;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(i)) continue;
            CFG.core.getProv((int)i).incomeProduction = CFG.gameUpdate.getProvIncomeProduction(i);
            if (!((long)CFG.core.getProv((int)i).incomeProduction > POPULATION_MAX)) continue;
            POPULATION_MAX = (long)CFG.core.getProv((int)i).incomeProduction;
        }
    }

    public static final void updateMaxDistance() {
        POPULATION_MAX = 0L;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.core.getProv(i).getCivId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(CFG.core.getProv(i).getCivId()).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || !((long)Distance.getDistanceFromCapital(CFG.core.getCiv(CFG.core.getProv(i).getCivId()).getCapitalProvID(), i) > POPULATION_MAX)) continue;
            POPULATION_MAX = (long)Distance.getDistanceFromCapital(CFG.core.getCiv(CFG.core.getProv(i).getCivId()).getCapitalProvID(), i);
        }
    }

    public static final void updateMaxEconomy() {
        ECONOMY_MAX = 1L;
        if (CFG.menus.getInGameView() && !CFG.SPECTATOR_MODE && CFG.FOG_OF_WAR == 2) {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getSeaProv() || !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(i) || (long)CFG.core.getProv(i).getEco() <= ECONOMY_MAX) continue;
                ECONOMY_MAX = (long)CFG.core.getProv(i).getEco();
            }
        } else {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getSeaProv() || (long)CFG.core.getProv(i).getEco() <= ECONOMY_MAX) continue;
                ECONOMY_MAX = (long)CFG.core.getProv(i).getEco();
            }
        }
        ECONOMY_MAX = (long)((float)ECONOMY_MAX * 0.775f);
    }

    public static final void updateMaxPotential() {
        ECONOMY_MAX = 0L;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if ((long)CFG.core.getProv(i).getPotential() <= ECONOMY_MAX) continue;
            ECONOMY_MAX = (long)CFG.core.getProv(i).getPotential();
        }
    }

    public static final void updateMaxDanger() {
        ECONOMY_MAX = 0L;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if ((long)CFG.core.getProv(i).getDangerLvl() <= ECONOMY_MAX) continue;
            ECONOMY_MAX = (long)CFG.core.getProv(i).getDangerLvl();
        }
    }

    public static final void updateMaxBalance() {
        ECONOMY_MAX = 0L;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.gameUpdate.getBalanceCivId(i) <= ECONOMY_MAX) continue;
            ECONOMY_MAX = CFG.gameUpdate.getBalanceCivId(i);
        }
    }

    public static final void updateMaxRecruitable() {
        ECONOMY_MAX = 0L;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.gameAction.gMARY(i, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) <= ECONOMY_MAX) continue;
            ECONOMY_MAX = CFG.gameAction.gMARY(i, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        }
    }

    public final int getActiveMapModeID() {
        return this.iActiveMapModeID;
    }

    public final MapMode getActiveView() {
        return this.lMapModes.get(this.iActiveMapModeID);
    }

    public final void clearData() {
        this.lMapModes.clear();
        this.lMapModes = null;
    }

    public void initFans() {
        VIEW_FANS_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        nData.add(new ME_Hover_2Type_Text_Big("100% fish approve", CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getProvName()));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, CFG.PADD));
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        switch (CFG.menus.getHoveredProvinceID() % 7) {
                            case 0: {
                                nData.add(new ME_Hover_2Type_Text_Big("100% love the game", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                                break;
                            }
                            case 1: {
                                nData.add(new ME_Hover_2Type_Text_Big("100% one more turn", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                                break;
                            }
                            case 2: {
                                nData.add(new ME_Hover_2Type_Text_Big("100% best strategy ever", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                                break;
                            }
                            case 3: {
                                nData.add(new ME_Hover_2Type_Text_Big("100% will sleep later", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                                break;
                            }
                            case 4: {
                                nData.add(new ME_Hover_2Type_Text_Big("100% just one last war", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                                break;
                            }
                            case 5: {
                                nData.add(new ME_Hover_2Type_Text_Big("0% The Game Nobody Wanted", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                                break;
                            }
                            case 6: {
                                nData.add(new ME_Hover_2Type_Text_Big("100% secretly a fan", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                            }
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                CFG.menus.setVisible_InGame_ViewF(true);
            }

            @Override
            public void disableViewAction() {
                CFG.menus.setVisible_InGame_ViewF(false);
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                if (Menu_InGame_View_F.CLICKED) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCeY() < Menu_InGame_View_F.MAX_Y / 2) {
                            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.4f));
                        } else {
                            oSB.setColor(new Color(0.8627451f, 0.078431375f, 0.23529412f, 0.4f));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                } else {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        switch (CFG.core.getPIV(i) % 10) {
                            case 0: {
                                oSB.setColor(new Color(0.4f, 0.8f, 0.4f, 0.25f));
                                break;
                            }
                            case 1: {
                                oSB.setColor(new Color(0.39215687f, 0.78431374f, 0.39215687f, 0.25f));
                                break;
                            }
                            case 2: {
                                oSB.setColor(new Color(0.40784314f, 0.80784315f, 0.40784314f, 0.25f));
                                break;
                            }
                            case 3: {
                                oSB.setColor(new Color(0.38431373f, 0.7921569f, 0.38431373f, 0.25f));
                                break;
                            }
                            case 4: {
                                oSB.setColor(new Color(0.41568628f, 0.8156863f, 0.41568628f, 0.25f));
                                break;
                            }
                            case 5: {
                                oSB.setColor(new Color(0.39607844f, 0.8039216f, 0.39607844f, 0.25f));
                                break;
                            }
                            case 6: {
                                oSB.setColor(new Color(0.40392157f, 0.79607844f, 0.40392157f, 0.25f));
                                break;
                            }
                            case 7: {
                                oSB.setColor(new Color(0.3882353f, 0.7882353f, 0.3882353f, 0.25f));
                                break;
                            }
                            case 8: {
                                oSB.setColor(new Color(0.4117647f, 0.8117647f, 0.4117647f, 0.25f));
                                break;
                            }
                            case 9: {
                                oSB.setColor(new Color(0.4f, 0.8039216f, 0.4f, 0.25f));
                            }
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                if (Menu_InGame_View_F.CLICKED) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCeY() < Menu_InGame_View_F.MAX_Y / 2) {
                            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.4f));
                        } else {
                            oSB.setColor(new Color(0.8627451f, 0.078431375f, 0.23529412f, 0.4f));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                } else {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        switch (CFG.core.getPIV(i) % 10) {
                            case 0: {
                                oSB.setColor(new Color(0.4f, 0.8f, 0.4f, 0.25f));
                                break;
                            }
                            case 1: {
                                oSB.setColor(new Color(0.39215687f, 0.78431374f, 0.39215687f, 0.25f));
                                break;
                            }
                            case 2: {
                                oSB.setColor(new Color(0.40784314f, 0.80784315f, 0.40784314f, 0.25f));
                                break;
                            }
                            case 3: {
                                oSB.setColor(new Color(0.38431373f, 0.7921569f, 0.38431373f, 0.25f));
                                break;
                            }
                            case 4: {
                                oSB.setColor(new Color(0.41568628f, 0.8156863f, 0.41568628f, 0.25f));
                                break;
                            }
                            case 5: {
                                oSB.setColor(new Color(0.39607844f, 0.8039216f, 0.39607844f, 0.25f));
                                break;
                            }
                            case 6: {
                                oSB.setColor(new Color(0.40392157f, 0.79607844f, 0.40392157f, 0.25f));
                                break;
                            }
                            case 7: {
                                oSB.setColor(new Color(0.3882353f, 0.7882353f, 0.3882353f, 0.25f));
                                break;
                            }
                            case 8: {
                                oSB.setColor(new Color(0.4117647f, 0.8117647f, 0.4117647f, 0.25f));
                                break;
                            }
                            case 9: {
                                oSB.setColor(new Color(0.4f, 0.8039216f, 0.4f, 0.25f));
                            }
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            }
        });
        VIEW_HATERS_MODE = this.addViewToTheGame(new MapMode(){

            @Override
            public ME_Hover getProvinceInformation() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getSeaProv()) {
                        nData.add(new ME_Hover_2Type_Text_Big("100% fish approve", CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getProvName()));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId(), CFG.PADD, CFG.PADD));
                        if (CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId() > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getProv(CFG.menus.getHoveredProvinceID()).getCivId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        switch (CFG.menus.getHoveredProvinceID() % 7) {
                            case 0: {
                                nData.add(new ME_Hover_2Type_Text_Big("100% love the game", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                                break;
                            }
                            case 1: {
                                nData.add(new ME_Hover_2Type_Text_Big("100% one more turn", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                                break;
                            }
                            case 2: {
                                nData.add(new ME_Hover_2Type_Text_Big("100% best strategy ever", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                                break;
                            }
                            case 3: {
                                nData.add(new ME_Hover_2Type_Text_Big("100% will sleep later", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                                break;
                            }
                            case 4: {
                                nData.add(new ME_Hover_2Type_Text_Big("100% just one last war", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                                break;
                            }
                            case 5: {
                                nData.add(new ME_Hover_2Type_Text_Big("0% The Game Nobody Wanted", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                                break;
                            }
                            case 6: {
                                nData.add(new ME_Hover_2Type_Text_Big("100% secretly a fan", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                            }
                        }
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    return new ME_Hover_v2(nElements);
                }
                catch (Exception exception) {
                    return null;
                }
            }

            @Override
            public void enableViewAction() {
                CFG.menus.setVisible_InGame_ViewFH(true);
            }

            @Override
            public void disableViewAction() {
                CFG.menus.setVisible_InGame_ViewFH(false);
            }
        }, CFG.FOG_OF_WAR == 2 ? new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown_FogOfWarDiscovery(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities_FogOfWarDiscovery(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince_FogOfWarDiscovery(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        } : new Render.Renderer(){

            @Override
            public void drawRenderer(SpriteBatch oSB) {
                RenderProvince.drawProvincesInGame(oSB);
                if (CFG.map.getMpS().getCurrSc() >= Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawActiveProvince(oSB);
                    CFG.core.drawHighlightProvince(oSB);
                    CFG.core.updateHighlitghtProvinceBorder(oSB);
                    RenderProvince.drawProvincesBorder(oSB);
                } else {
                    RenderProvince.drawProvincesBorder_Only_CivilizationBorder_InGame(oSB);
                }
                CFG.core.drawActiveProvinceBorder(oSB);
                if (CFG.map.getMpS().getCurrSc() < 1.0f && CFG.map.getMpS().getCurrSc() > Render.DISABLE_INNER_BORDERS) {
                    CFG.core.drawAllCivilizations_Flag_InCapitals_WithCrown(oSB, 1.0f);
                }
                Render.oDrawMoveUnits.drawMoveUnits(oSB);
            }

            @Override
            public void drawRendererWithoutScale(SpriteBatch oSB) {
                Render.oDrawMoveUnits.drawMoveUnits_WithoutScale(oSB);
                if (Render.drawInGame_WithoutScale_MapDetails()) {
                    CFG.core.drawProvincesInfo(oSB, CFG.map.getMpS().getCurrSc());
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, CFG.map.getMpS().getCurrSc());
                        CFG.core.drawCities_ActiveProvince(oSB, CFG.map.getMpS().getCurrSc());
                    }
                    CFG.core.drawProvincesArmy(oSB, CFG.map.getMpS().getCurrSc());
                }
            }

            @Override
            public void drawRendererMapDetails(SpriteBatch oSB) {
                if (Render.drawInGame_MapDetails()) {
                    if (!Render.DISABLE_CITIES) {
                        CFG.core.drawCities(oSB, 1.0f);
                        CFG.core.drawCities_ActiveProvince(oSB, 1.0f);
                    }
                    CFG.core.drawProvincesArmy(oSB, 1.0f);
                }
            }
        }, CFG.FOG_OF_WAR == 2 ? new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                if (Menu_InGame_View_F.CLICKED) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCeY() < Menu_InGame_View_F.MAX_Y / 2) {
                            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.4f));
                        } else {
                            oSB.setColor(new Color(0.8627451f, 0.078431375f, 0.23529412f, 0.4f));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                } else {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        oSB.setColor(new Color(0.78431374f, 0.78431374f, 0.78431374f, 0.25f));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            }
        } : new RenderProvince.DrawProvinces(){

            @Override
            public void drawProvinces(SpriteBatch oSB) {
                if (Menu_InGame_View_F.CLICKED) {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        if (CFG.core.getProv(CFG.core.getPIV(i)).getCeY() < Menu_InGame_View_F.MAX_Y / 2) {
                            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.4f));
                        } else {
                            oSB.setColor(new Color(0.8627451f, 0.078431375f, 0.23529412f, 0.4f));
                        }
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                } else {
                    for (int i = 0; i < CFG.NUM_OF_PROVINCES_IN_VIEW; ++i) {
                        oSB.setColor(new Color(0.78431374f, 0.78431374f, 0.78431374f, 0.25f));
                        CFG.core.getProv(CFG.core.getPIV(i)).drawLandProv(oSB);
                    }
                }
            }
        });
    }
}

