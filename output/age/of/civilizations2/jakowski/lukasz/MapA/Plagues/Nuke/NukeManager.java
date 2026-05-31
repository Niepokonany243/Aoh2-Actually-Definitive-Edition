
package age.of.civilizations2.jakowski.lukasz.MapA.Plagues.Nuke;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Messages.Province.Nuke.Message_Nuke_OurProvince;
import age.of.civilizations2.jakowski.lukasz.Province;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import java.util.ArrayList;

public class NukeManager {
    public static int getAtomicBombCost(int civID) {
        return (int)Math.max(GameValues.gvAtomic.COST_MIN, GameValues.gvAtomic.COST_BASE + (float)CFG.BUILD_NUKES_EXTRA_COST - (float)CFG.core.getCiv(civID).getTechLevelINT() * GameValues.gvAtomic.COST_REDUCTION_PER_TECH_LVL + GameValues.gvAtomic.COST_PER_ATOMIC_BOMB_EXTRA * (float)NukeManager.getAtomicBombs_PlusInConstruction(civID));
    }

    public static int getAtomicBombConstructionTime(int civID) {
        return (int)Math.max(1.0f, GameValues.gvAtomic.CONSTRUCTION_TURNS + GameValues.gvAtomic.CONSTRUCTION_TURNS_EXTRA_PER_ATOMIC_BOMB * (float)NukeManager.getAtomicBombs_PlusInConstruction(civID));
    }

    public static int getAtomicBombs_PlusInConstruction(int civID) {
        return Math.max(0, CFG.core.getCiv((int)civID).civGD.iNukes + CFG.core.getCiv((int)civID).civGD.nukesConstruction.size());
    }

    public static int getAtomicBombsLimit(int civID) {
        return (int)Math.max(1.0f, (float)GameValues.gvAtomic.ATOMIC_BOMBS_LIMIT + (float)CFG.core.getCiv(civID).getTechLevelINT() / (GameValues.gvAtomic.ATOMIC_BOMBS_LIMIT_EXTRA_PER_TECH_LVL * 100.0f));
    }

    public static boolean canBuildMore(int civID) {
        return CFG.ENABLE_NUKES && NukeManager.getAtomicBombs_PlusInConstruction(civID) < NukeManager.getAtomicBombsLimit(civID);
    }

    public static boolean canBuildNuke_TechLvl(int civID) {
        return CFG.NUKES_REQUIRED_TECH_LVL <= CFG.core.getCiv(civID).getTechLevel();
    }

    public static boolean canBuildNuke_Year() {
        return !CFG.NUKES_MIN_YEAR_ENABLED || GameCalendar.currYear >= GameValues.gvAtomic.ATOMIC_BOMB_MIN_YEAR;
    }

    public static boolean buildNuke(int civID) {
        if (!NukeManager.canBuildMore(civID)) {
            return false;
        }
        if (CFG.core.getCiv(civID).getGold() < (long)NukeManager.getAtomicBombCost(civID)) {
            return false;
        }
        if (!NukeManager.canBuildNuke_TechLvl(civID)) {
            return false;
        }
        if (!NukeManager.canBuildNuke_Year()) {
            return false;
        }
        CFG.core.getCiv(civID).setGold(CFG.core.getCiv(civID).getGold() - (long)NukeManager.getAtomicBombCost(civID));
        CFG.core.getCiv((int)civID).civGD.nukesConstruction.add(NukeManager.getAtomicBombConstructionTime(civID));
        return true;
    }

    public static boolean canDropNuke(int civID, int provinceID) {
        if (CFG.ENABLE_NUKES && CFG.core.getCiv((int)civID).civGD.iNukes > 0) {
            if (CFG.core.getProv(provinceID).getTrueOwnerOfProv() == civID) {
                return false;
            }
            if (CFG.core.getCivsAtWar(civID, CFG.core.getProv(provinceID).getTrueOwnerOfProv()) || CFG.core.getCivsAtWar(civID, CFG.core.getProv(provinceID).getCivId())) {
                return true;
            }
        }
        return false;
    }

    public static long dropNuke(int civID, int provinceID) {
        return NukeManager.dropNuke(civID, provinceID, false);
    }

    public static long dropNuke(int civID, int provinceID, boolean free) {
        block27: {
            try {
                if (!NukeManager.canDropNuke(civID, provinceID) && !free) break block27;
                if (!free) {
                    --CFG.core.getCiv((int)civID).civGD.iNukes;
                }
                long out = 0L;
                long armyLosses = 0L;
                Province province = CFG.core.getProv(provinceID);
                try {
                    for (int a = province.getCivsSize() - 1; a >= 0; --a) {
                        long tArmy = province.getArmyID(a);
                        int tArmyCivID = province.getCivId(a);
                        long nArmy = (long)((float)province.getArmyID(a) * GameValues.gvAtomic.NUKE_CASUALTIES_ARMY_PERC);
                        if ((float)nArmy >= GameValues.gvAtomic.NUKE_MIN_SURVIVING_ARMY) {
                            out += province.getArmyID(a) - nArmy;
                            province.updateArmy4(province.getCivId(a), nArmy);
                        } else {
                            out += province.getArmyID(a);
                            province.updateArmy4(province.getCivId(a), 0L);
                        }
                        armyLosses += tArmy - province.getArmyCivID1(tArmyCivID);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                long economyLosses = (long)province.getEco();
                province.setEco((int)((float)province.getEco() * GameValues.gvAtomic.NUKE_ECONOMY_DAMAGE_PERC));
                economyLosses -= (long)province.getEco();
                try {
                    for (int a = province.getPop().getNatsSize() - 1; a >= 0; --a) {
                        long value = (long)((float)province.getPop().getPopulationID(a) * GameValues.gvAtomic.NUKE_POPULATION_DAMAGE_PERC);
                        out += province.getPop().getPopulationID(a) - value;
                        province.getPop().setPopulationOfCivID(province.getPop().getCivID(a), value);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                Renderer.aNK(provinceID);
                CFG.plagueManager.addPlague_Radiation(provinceID);
                if (CFG.core.getCiv(province.getCivId()).getIsPlayer()) {
                    CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("AtomicBombing") + ": " + province.getProvName(), CFG.lang.get("Casualties") + ": " + CFG.getNumberWthSpaces("" + out), Images.infoNuke, civID);
                    CFG.core.getCiv((int)province.getCivId()).getCivDiploGD().messageBox.addMessage(new Message_Nuke_OurProvince(civID, province.getProvID(), out, economyLosses, armyLosses));
                    if (MapModesManager.VIEW_POPULATION_MODE == CFG.mapModesManager.getActiveMapModeID()) {
                        CFG.menus.setVisible_InGame_ViewPopulationAll(true);
                    }
                }
                try {
                    if (GameValues.gvAtomic.PROVINCE_DESTROY_PORT && province.getLvlOfPort() > 0) {
                        province.setLvlOfPort(0);
                    }
                    if (GameValues.gvAtomic.PROVINCE_DESTROY_WORKSHOP && province.getLvlOfWorkshop() > 0) {
                        province.setLvlOfWorkshop(0);
                    }
                    if (GameValues.gvAtomic.PROVINCE_DESTROY_FORT && province.getLvlOfFort() > 0) {
                        province.setLvlOfFort(0);
                    }
                    if (GameValues.gvAtomic.PROVINCE_DESTROY_WATCHTOWER && province.getLvlOfWatchTower() > 0) {
                        province.setLvlOfWatchTower(0);
                    }
                    if (GameValues.gvAtomic.PROVINCE_DESTROY_ARMOURY && province.getLvlOfArmoury() > 0) {
                        province.setLvlOfArmoury(0);
                    }
                    if (GameValues.gvAtomic.PROVINCE_DESTROY_SUPPLY_CAMP && province.getLvlOfSupply() > 0) {
                        province.setLvlOfSupply(0);
                    }
                    if (GameValues.gvAtomic.PROVINCE_DESTROY_LIBRARY && province.getLvlOfLibrary() > 0) {
                        province.setLvlOfLibrary(0);
                    }
                    if (GameValues.gvAtomic.PROVINCE_DESTROY_FARM && province.getLvlOfFarm() > 0) {
                        province.setLvlOfFarm(0);
                    }
                    if (GameValues.gvAtomic.PROVINCE_DESTROY_MARKET && province.getLvlOfMarket() > 0) {
                        province.setLvlOfMarket(0);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                try {
                    int tempWarID = CFG.core.getWarID(civID, province.getTrueOwnerOfProv());
                    if (tempWarID >= 0) {
                        CFG.core.updateWarStatistics(tempWarID, civID, province.getTrueOwnerOfProv(), Math.max(out + armyLosses, 0), Math.max(economyLosses, 0));
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                return out;
            }
            catch (Exception exr) {
                CFG.exceptionStack(exr);
            }
        }
        return 0;
    }

    public static ME_Hover_v2 getHoverNuke() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("BuildAnAtomicBomb"), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Image_Big(Images.nuke, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
        nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + NukeManager.getAtomicBombCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)NukeManager.getAtomicBombCost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) ? CFG.COLOR_GOLD : CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ConstructionWillTakeXurns", NukeManager.getAtomicBombConstructionTime(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()))));
        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + NukeManager.getAtomicBombConstructionTime(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()))));
        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RequiredTechnologyLevel") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + CFG.NUKES_REQUIRED_TECH_LVL, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() >= CFG.NUKES_REQUIRED_TECH_LVL ? CFG.COLOR_TECHNOLOGY : CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() >= CFG.NUKES_REQUIRED_TECH_LVL ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (CFG.NUKES_MIN_YEAR_ENABLED) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MinimumYearForNukes") + ": "));
            nData.add(new ME_Hover_2Type_Text("" + GameValues.gvAtomic.ATOMIC_BOMB_MIN_YEAR, GameCalendar.currYear >= GameValues.gvAtomic.ATOMIC_BOMB_MIN_YEAR ? CFG.COLOR_TEXT_NUM_OF_PROVINCES : CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Image(GameCalendar.currYear >= GameValues.gvAtomic.ATOMIC_BOMB_MIN_YEAR ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EnableNuclearWeapons") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (CFG.ENABLE_NUKES ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.ENABLE_NUKES ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
        nData.add(new ME_Hover_2Type_Image(Images.nuke, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        return new ME_Hover_v2(nElements);
    }
}

