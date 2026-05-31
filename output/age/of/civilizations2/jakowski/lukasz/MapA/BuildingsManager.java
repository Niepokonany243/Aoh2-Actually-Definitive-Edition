
package age.of.civilizations2.jakowski.lukasz.MapA;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Armoury;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Farm;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Fort;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Library;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Market;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Supply;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Tower;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Workshop;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Messages.Built.Message_Built_Library;
import age.of.civilizations2.jakowski.lukasz.Messages.Built.Message_Bulit_Armoury;
import age.of.civilizations2.jakowski.lukasz.Messages.Built.Message_Bulit_Farm;
import age.of.civilizations2.jakowski.lukasz.Messages.Built.Message_Bulit_Fort;
import age.of.civilizations2.jakowski.lukasz.Messages.Built.Message_Bulit_Market;
import age.of.civilizations2.jakowski.lukasz.Messages.Built.Message_Bulit_Port;
import age.of.civilizations2.jakowski.lukasz.Messages.Built.Message_Bulit_Supply;
import age.of.civilizations2.jakowski.lukasz.Messages.Built.Message_Bulit_Tower;
import age.of.civilizations2.jakowski.lukasz.Messages.Built.Message_Bulit_Workshop;

public class BuildingsManager {
    public static int iBuildInProvinceID = 0;
    public static boolean buildBySelectingProvinceOnMap = false;

    public static final String getMissileProgram_Name(int nLevel) {
        return "Missile Program";
    }

    public static final int getMissileProgram_BuildCost(int nLevel, int nProvinceID) {
        return 15000;
    }

    public static final int getMissileProgram_BuildMovementCost(int nLevel) {
        return 4;
    }

    public static final float getMissileProgram_TechLevel(int nLevel) {
        return 0.85f;
    }

    public static final int getFort_MaxLevel() {
        return GameValues.gvBuildingFort.FORT_NAMES.length - 1;
    }

    public static final int getFort_MaxLevel_CanBuild(int nCivID) {
        for (int i = 0; i < GameValues.gvBuildingFort.FORT_TECH_LEVEL.length; ++i) {
            if (!(GameValues.gvBuildingFort.FORT_TECH_LEVEL[i] > CFG.core.getCiv(nCivID).getTechLevel())) continue;
            return i - 1;
        }
        return BuildingsManager.getFort_MaxLevel();
    }

    public static final String getFort_Name(int nLevel) {
        try {
            return GameValues.gvBuildingFort.FORT_NAMES[nLevel];
        }
        catch (Exception e) {
            try {
                return GameValues.gvBuildingFort.FORT_NAMES[GameValues.gvBuildingFort.FORT_NAMES.length - 1];
            }
            catch (Exception exr) {
                return "Fort";
            }
        }
    }

    public static final int getFort_BuildCost(int nLevel, int nProvinceID) {
        try {
            int iNumOfBuildings = 0;
            for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).getLvlOfFort() <= 0) continue;
                iNumOfBuildings += CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).getLvlOfFort();
            }
            return Math.max(50, (int)(((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingFort.FORT_BUILD_COST[nLevel] + GameValues.gvBuildingFort.FORT_EXTRA_COST_PER_FORT * (float)iNumOfBuildings) + (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingFort.FORT_COST_DEVELOPMENT_MODIFIER * (1.0f - CFG.core.getProv(nProvinceID).getDeveLvl()))) * (1.0f + CFG.terrainTypesManager.getBuildCost(CFG.core.getProv(nProvinceID).getTerrainTypeID()))));
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getFort_BuildMovementCost(int nLevel) {
        try {
            return GameValues.gvBuildingFort.FORT_BUILD_MOVEMENT_COST[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getFort_DefenseBonus(int nLevel) {
        try {
            return GameValues.gvBuildingFort.FORT_DEFENSE_BONUS[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final float getFort_TechLevel(int nLevel) {
        try {
            return GameValues.gvBuildingFort.FORT_TECH_LEVEL[nLevel];
        }
        catch (Exception e) {
            return 0.0f;
        }
    }

    public static final int getFort_Construction(int nLevel) {
        try {
            return GameValues.gvBuildingFort.FORT_CONSTRUCTION_TURNS[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final boolean canBuildFort(int nProvinceID) {
        return CFG.core.getProv(nProvinceID).getLvlOfFort() < BuildingsManager.getFort_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getFort_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfFort() + 1) && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getMovemPoints() >= BuildingsManager.getFort_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfFort() + 1);
    }

    public static final boolean constructFort(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfFort() < BuildingsManager.getFort_MaxLevel() && CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getFort_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfFort() + 1)) {
            if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.FORT) > 0) {
                return false;
            }
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= BuildingsManager.getFort_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfFort() + 1) && CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getFort_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfFort() + 1, nProvinceID)) {
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - BuildingsManager.getFort_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfFort() + 1));
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getFort_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfFort() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Fort(nProvinceID, BuildingsManager.getFort_Construction(CFG.core.getProv(nProvinceID).getLvlOfFort() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_FORT);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean constructFort_Foreign(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfFort() < BuildingsManager.getFort_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getFort_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfFort() + 1)) {
            if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.FORT) > 0) {
                return false;
            }
            if (CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getFort_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfFort() + 1, nProvinceID)) {
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getFort_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfFort() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Fort(nProvinceID, BuildingsManager.getFort_Construction(CFG.core.getProv(nProvinceID).getLvlOfFort() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_FORT);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean buildFort(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfFort() < BuildingsManager.getFort_MaxLevel()) {
            CFG.core.getProv(nProvinceID).setLvlOfFort(CFG.core.getProv(nProvinceID).getLvlOfFort() + 1);
            ++CFG.core.getCiv((int)nCivID).civGD.numOfBuildingsConstructed;
            for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs() <= 0) continue;
                CFG.core.getProv(nProvinceID).updateFogOfWar(i);
            }
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                CFG.core.getCiv((int)nCivID).getCivDiploGD().messageBox.addMessage(new Message_Bulit_Fort(nCivID, nProvinceID));
            }
            return true;
        }
        return false;
    }

    public static final boolean destroyFort(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfFort() > 0) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= GameValues.gvBuildings.DESTROY_MOVEMENT_COST) {
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - GameValues.gvBuildings.DESTROY_MOVEMENT_COST);
                CFG.core.getProv(nProvinceID).setLvlOfFort(0);
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_TEXT_MODIFIER_NEGATIVE);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean destroyTower(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfWatchTower() > 0) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= GameValues.gvBuildings.DESTROY_MOVEMENT_COST) {
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - GameValues.gvBuildings.DESTROY_MOVEMENT_COST);
                CFG.core.getProv(nProvinceID).setLvlOfWatchTower(0);
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    CFG.core.getProv(nProvinceID).updateFogOfWar(CFG.core.getPlayerIDbyCivID(nCivID));
                }
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_TEXT_MODIFIER_NEGATIVE);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean destroyPort(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfPort() > 0) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= GameValues.gvBuildings.DESTROY_MOVEMENT_COST) {
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - GameValues.gvBuildings.DESTROY_MOVEMENT_COST);
                CFG.core.getProv(nProvinceID).setLvlOfPort(0);
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_TEXT_MODIFIER_NEGATIVE);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean destroyFarm(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfFarm() > 0) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= GameValues.gvBuildings.DESTROY_MOVEMENT_COST) {
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - GameValues.gvBuildings.DESTROY_MOVEMENT_COST);
                CFG.core.getProv(nProvinceID).setLvlOfFarm(0);
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_TEXT_MODIFIER_NEGATIVE);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean destroyWorkshop(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfWorkshop() > 0) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= GameValues.gvBuildings.DESTROY_MOVEMENT_COST) {
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - GameValues.gvBuildings.DESTROY_MOVEMENT_COST);
                CFG.core.getProv(nProvinceID).setLvlOfWorkshop(0);
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_TEXT_MODIFIER_NEGATIVE);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean destroyMarket(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfMarket() > 0) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= GameValues.gvBuildings.DESTROY_MOVEMENT_COST) {
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - GameValues.gvBuildings.DESTROY_MOVEMENT_COST);
                CFG.core.getProv(nProvinceID).setLvlOfMarket(0);
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_TEXT_MODIFIER_NEGATIVE);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean destroyLibrary(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfLibrary() > 0) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= GameValues.gvBuildings.DESTROY_MOVEMENT_COST) {
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - GameValues.gvBuildings.DESTROY_MOVEMENT_COST);
                CFG.core.getProv(nProvinceID).setLvlOfLibrary(0);
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_TEXT_MODIFIER_NEGATIVE);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean destroyArmoury(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfArmoury() > 0) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= GameValues.gvBuildings.DESTROY_MOVEMENT_COST) {
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - GameValues.gvBuildings.DESTROY_MOVEMENT_COST);
                CFG.core.getProv(nProvinceID).setLvlOfArmoury(0);
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_TEXT_MODIFIER_NEGATIVE);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean destroySupply(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfSupply() > 0) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= GameValues.gvBuildings.DESTROY_MOVEMENT_COST) {
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - GameValues.gvBuildings.DESTROY_MOVEMENT_COST);
                CFG.core.getProv(nProvinceID).setLvlOfSupply(0);
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_TEXT_MODIFIER_NEGATIVE);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final int getTower_MaxLevel() {
        return GameValues.gvBuildingWatchTower.TOWER_NAMES.length - 1;
    }

    public static final int getTower_MaxLevel_CanBuild(int nCivID) {
        for (int i = 0; i < GameValues.gvBuildingWatchTower.TOWER_TECHNOLOGY_LEVEL.length; ++i) {
            if (!(GameValues.gvBuildingWatchTower.TOWER_TECHNOLOGY_LEVEL[i] > CFG.core.getCiv(nCivID).getTechLevel())) continue;
            return i - 1;
        }
        return BuildingsManager.getTower_MaxLevel();
    }

    public static final String getTower_Name(int nLevel) {
        try {
            return GameValues.gvBuildingWatchTower.TOWER_NAMES[nLevel];
        }
        catch (Exception e) {
            return GameValues.gvBuildingWatchTower.TOWER_NAMES[GameValues.gvBuildingWatchTower.TOWER_NAMES.length - 1];
        }
    }

    public static final int getTower_BuildCost(int nLevel, int nProvinceID) {
        try {
            int iNumOfBuildigns = 0;
            for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).getLvlOfWatchTower() <= 0) continue;
                ++iNumOfBuildigns;
            }
            return Math.max(50, (int)(((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingWatchTower.TOWER_BUILD_COST[nLevel] + GameValues.gvBuildingWatchTower.TOWER_EXTRA_COST_PER_TOWER * (float)iNumOfBuildigns) + (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingWatchTower.TOWER_COST_DEVELOPMENT_MODIFIER * (1.0f - CFG.core.getProv(nProvinceID).getDeveLvl()))) * (1.0f + CFG.terrainTypesManager.getBuildCost(CFG.core.getProv(nProvinceID).getTerrainTypeID()))));
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getTower_BuildMovementCost(int nLevel) {
        try {
            return GameValues.gvBuildingWatchTower.TOWER_BUILD_MOVEMENT_COST[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final float getTower_TechLevel(int nLevel) {
        try {
            return GameValues.gvBuildingWatchTower.TOWER_TECHNOLOGY_LEVEL[nLevel];
        }
        catch (Exception e) {
            return 0.0f;
        }
    }

    public static final int getTower_DefenseBonus(int nLevel) {
        try {
            return GameValues.gvBuildingWatchTower.TOWER_DEFENSE_BONUS[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getTower_Construction(int nLevel) {
        try {
            return GameValues.gvBuildingWatchTower.TOWER_CONSTRUCTION[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final boolean canBuildTower(int nProvinceID) {
        return CFG.core.getProv(nProvinceID).getLvlOfWatchTower() < BuildingsManager.getTower_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getTower_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfWatchTower() + 1) && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getMovemPoints() >= BuildingsManager.getTower_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfWatchTower() + 1);
    }

    public static final boolean constructTower(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfWatchTower() < BuildingsManager.getTower_MaxLevel() && CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getTower_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfWatchTower() + 1)) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= BuildingsManager.getTower_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfWatchTower() + 1) && CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getTower_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfWatchTower() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.TOWER) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - BuildingsManager.getTower_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfWatchTower() + 1));
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getTower_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfWatchTower() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Tower(nProvinceID, BuildingsManager.getTower_Construction(CFG.core.getProv(nProvinceID).getLvlOfWatchTower() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_TOWER);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean constructTower_Foreign(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfWatchTower() < BuildingsManager.getTower_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getTower_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfWatchTower() + 1)) {
            if (CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getTower_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfWatchTower() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.TOWER) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getTower_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfWatchTower() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Tower(nProvinceID, BuildingsManager.getTower_Construction(CFG.core.getProv(nProvinceID).getLvlOfWatchTower() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_TOWER);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean buildTower(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfWatchTower() < BuildingsManager.getTower_MaxLevel()) {
            CFG.core.getProv(nProvinceID).setLvlOfWatchTower(CFG.core.getProv(nProvinceID).getLvlOfWatchTower() + 1);
            ++CFG.core.getCiv((int)nCivID).civGD.numOfBuildingsConstructed;
            for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs() <= 0) continue;
                for (int j = 0; j < CFG.core.getProv(nProvinceID).getNeighProvincesSize(); ++j) {
                    CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighProvinces(j)).updateFogOfWar(i);
                }
            }
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                CFG.core.getCiv((int)nCivID).getCivDiploGD().messageBox.addMessage(new Message_Bulit_Tower(nCivID, nProvinceID));
            }
            return true;
        }
        return false;
    }

    public static final int getPort_MaxLevel() {
        return GameValues.gvBuildingPort.PORT_NAMES.length - 1;
    }

    public static final String getPort_Name(int nLevel) {
        try {
            return GameValues.gvBuildingPort.PORT_NAMES[nLevel];
        }
        catch (Exception e) {
            return GameValues.gvBuildingPort.PORT_NAMES[GameValues.gvBuildingPort.PORT_NAMES.length - 1];
        }
    }

    public static final int getPort_BuildCost(int nLevel, int nProvinceID) {
        try {
            int iNumOfBuildigns = 0;
            for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).getLvlOfPort() <= 0) continue;
                ++iNumOfBuildigns;
            }
            return Math.max(50, (int)(((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingPort.PORT_BUILD_COST[nLevel] + GameValues.gvBuildingPort.PORT_EXTRA_COST_PER_PORT * (float)iNumOfBuildigns) + (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingPort.PORT_COST_DEVELOPMENT_MODIFIER * (1.0f - CFG.core.getProv(nProvinceID).getDeveLvl()))) * (1.0f + CFG.terrainTypesManager.getBuildCost(CFG.core.getProv(nProvinceID).getTerrainTypeID())) * (CFG.core.getProv(nProvinceID).isOccupied() ? GameValues.gvBuildingPort.BUILD_PORT_IN_OCCUPIED_PROVINCE_MODIFIER : 1.0f)));
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getPort_BuildMovementCost(int nLevel) {
        try {
            return GameValues.gvBuildingPort.PORT_BUILD_MOVEMENT_COST[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getPort_Construction(int nLevel) {
        try {
            return GameValues.gvBuildingPort.PORT_CONSTRUCTION[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final float getPort_TechLevel(int nLevel) {
        try {
            return GameValues.gvBuildingPort.PORT_TECHNOLOGY_LEVEL[nLevel];
        }
        catch (Exception e) {
            return 0.0f;
        }
    }

    public static final float getPort_IncomeProduction(int nLevel) {
        try {
            return GameValues.gvBuildingPort.PORT_INCOME_PRODUCTION[nLevel];
        }
        catch (Exception e) {
            return 0.0f;
        }
    }

    public static final boolean canBuildPort(int nProvinceID) {
        return CFG.core.getProv(nProvinceID).getLvlOfPort() < BuildingsManager.getPort_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getPort_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1) && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getMovemPoints() >= BuildingsManager.getPort_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1) && CFG.core.getProv(nProvinceID).getNeighSeaProvincesSize() > 0;
    }

    public static final boolean constructPort(int nProvinceID, int nCivID) {
        if (CFG.core.getProv(nProvinceID).getLvlOfPort() >= 0 && CFG.core.getProv(nProvinceID).getLvlOfPort() < BuildingsManager.getPort_MaxLevel() && CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getPort_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1)) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= BuildingsManager.getPort_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1) && CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getPort_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.PORT) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - BuildingsManager.getPort_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1));
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getPort_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction(nProvinceID, BuildingsManager.getPort_Construction(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_PORT);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean constructPort_Foreign(int nProvinceID, int nCivID) {
        if (CFG.core.getProv(nProvinceID).getLvlOfPort() >= 0 && CFG.core.getProv(nProvinceID).getLvlOfPort() < BuildingsManager.getPort_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getPort_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1)) {
            if (CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getPort_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.PORT) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getPort_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction(nProvinceID, BuildingsManager.getPort_Construction(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_PORT);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean buildPort(int nProvinceID, int nCivID) {
        if (CFG.core.getProv(nProvinceID).getLvlOfPort() >= 0 && CFG.core.getProv(nProvinceID).getLvlOfPort() < BuildingsManager.getPort_MaxLevel()) {
            CFG.core.getProv(nProvinceID).setLvlOfPort(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1);
            ++CFG.core.getCiv((int)nCivID).civGD.numOfBuildingsConstructed;
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                CFG.core.getCiv((int)nCivID).getCivDiploGD().messageBox.addMessage(new Message_Bulit_Port(nCivID, nProvinceID));
            }
            return true;
        }
        return false;
    }

    public static final int getFarm_MaxLevel() {
        return GameValues.gvBuildingFarm.FARM_NAMES.length - 1;
    }

    public static final int getFarm_MaxLevel_CanBuild(int nCivID) {
        for (int i = 0; i < GameValues.gvBuildingFarm.FARM_TECHNOLOGY_LEVEL.length; ++i) {
            if (!(GameValues.gvBuildingFarm.FARM_TECHNOLOGY_LEVEL[i] > CFG.core.getCiv(nCivID).getTechLevel())) continue;
            return i - 1;
        }
        return BuildingsManager.getFarm_MaxLevel();
    }

    public static final String getFarm_Name(int nLevel) {
        try {
            return GameValues.gvBuildingFarm.FARM_NAMES[nLevel];
        }
        catch (Exception e) {
            return GameValues.gvBuildingFarm.FARM_NAMES[GameValues.gvBuildingFarm.FARM_NAMES.length - 1];
        }
    }

    public static final int getFarm_BuildCost(int nLevel, int nProvinceID) {
        try {
            int iNumOfBuildigns = 0;
            for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).getLvlOfFarm() <= 0) continue;
                iNumOfBuildigns += CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).getLvlOfFarm();
            }
            return Math.max(50, (int)(((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingFarm.FARM_BUILD_COST[nLevel] + GameValues.gvBuildingFarm.FARM_EXTRA_COST_PER_FARM * (float)iNumOfBuildigns) + (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingFarm.FARM_COST_DEVELOPMENT_MODIFIER * (1.0f - CFG.core.getProv(nProvinceID).getDeveLvl()))) * (1.0f + CFG.terrainTypesManager.getBuildCost(CFG.core.getProv(nProvinceID).getTerrainTypeID()))));
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getFarm_Construction(int nLevel) {
        try {
            return GameValues.gvBuildingFarm.FARM_CONSTRUCTION[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getFarm_BuildMovementCost(int nLevel) {
        try {
            return GameValues.gvBuildingFarm.FARM_BUILD_MOVEMENT_COST[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final float getFarm_TechLevel(int nLevel) {
        try {
            return GameValues.gvBuildingFarm.FARM_TECHNOLOGY_LEVEL[nLevel];
        }
        catch (Exception e) {
            return 0.0f;
        }
    }

    public static final float getFarm_GrowthRateBonus(int nLevel) {
        try {
            return GameValues.gvBuildingFarm.FARM_GROWTH_RATE_BONUS[nLevel];
        }
        catch (Exception e) {
            return GameValues.gvBuildingFarm.FARM_GROWTH_RATE_BONUS[GameValues.gvBuildingFarm.FARM_GROWTH_RATE_BONUS.length - 1];
        }
    }

    public static final boolean constructFarm(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfFarm() < BuildingsManager.getFarm_MaxLevel() && CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getFarm_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfFarm() + 1)) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= BuildingsManager.getFarm_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfFarm() + 1) && CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getFarm_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfFarm() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.FARM) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - BuildingsManager.getFarm_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfFarm() + 1));
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getFarm_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfFarm() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Farm(nProvinceID, BuildingsManager.getFarm_Construction(CFG.core.getProv(nProvinceID).getLvlOfFarm() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_FARM);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean constructFarm_Foreign(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfFarm() < BuildingsManager.getFarm_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getFarm_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfFarm() + 1)) {
            if (CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getFarm_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfFarm() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.FARM) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getFarm_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfFarm() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Farm(nProvinceID, BuildingsManager.getFarm_Construction(CFG.core.getProv(nProvinceID).getLvlOfFarm() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_FARM);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean buildFarm(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfFarm() < BuildingsManager.getFarm_MaxLevel()) {
            CFG.core.getProv(nProvinceID).setLvlOfFarm(CFG.core.getProv(nProvinceID).getLvlOfFarm() + 1);
            ++CFG.core.getCiv((int)nCivID).civGD.numOfBuildingsConstructed;
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                CFG.core.getCiv((int)nCivID).getCivDiploGD().messageBox.addMessage(new Message_Bulit_Farm(nCivID, nProvinceID));
            }
            return true;
        }
        return false;
    }

    public static boolean canBuildFarm_Terrain(int nProvinceID) {
        return CFG.terrainTypesManager.getPopulationGrowth(CFG.core.getProv(nProvinceID).getTerrainTypeID()) >= (float)GameValues.gvBuildings.FARM_MIN_TERRAIN_GROWTH_RATE_REQUIRED;
    }

    public static final boolean canBuildFarm(int nProvinceID) {
        return CFG.core.getProv(nProvinceID).getLvlOfFarm() < BuildingsManager.getFarm_MaxLevel() && BuildingsManager.canBuildFarm_Terrain(nProvinceID) && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getFarm_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfFarm() + 1) && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getMovemPoints() >= BuildingsManager.getFarm_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfFarm() + 1);
    }

    public static final int getLibrary_MaxLevel() {
        return GameValues.gvBuildingLibrary.LIBRARY_NAMES.length - 1;
    }

    public static final int getLibrary_MaxLevel_CanBuild(int nCivID) {
        for (int i = 0; i < GameValues.gvBuildingLibrary.LIBRARY_TECH_LEVEL.length; ++i) {
            if (!(GameValues.gvBuildingLibrary.LIBRARY_TECH_LEVEL[i] > CFG.core.getCiv(nCivID).getTechLevel())) continue;
            return i - 1;
        }
        return BuildingsManager.getLibrary_MaxLevel();
    }

    public static final String getLibrary_Name(int nLevel) {
        try {
            return GameValues.gvBuildingLibrary.LIBRARY_NAMES[nLevel];
        }
        catch (Exception e) {
            return GameValues.gvBuildingLibrary.LIBRARY_NAMES[GameValues.gvBuildingLibrary.LIBRARY_NAMES.length - 1];
        }
    }

    public static final int getLibrary_BuildCost(int nLevel, int nProvinceID) {
        try {
            int iNumOfBuildigns = 0;
            for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).getLvlOfLibrary() <= 0) continue;
                iNumOfBuildigns += CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).getLvlOfLibrary();
            }
            return Math.max(50, (int)(((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingLibrary.LIBRARY_BUILD_COST[nLevel] + GameValues.gvBuildingLibrary.LIBRARY_EXTRA_COST_PER_LIBRARY * (float)iNumOfBuildigns) + (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingLibrary.LIBRARY_COST_DEVELOPMENT_MODIFIER * (1.0f - CFG.core.getProv(nProvinceID).getDeveLvl()))) * (1.0f + CFG.terrainTypesManager.getBuildCost(CFG.core.getProv(nProvinceID).getTerrainTypeID()))));
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getLibrary_BuildMovementCost(int nLevel) {
        try {
            return GameValues.gvBuildingLibrary.LIBRARY_BUILD_MOVEMENT_COST[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getLibrary_ResearchPerPopulation(int nLevel) {
        try {
            return GameValues.gvBuildingLibrary.LIBRARY_RESEARCH_PER_POPULATION[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final float getLibrary_TechLevel(int nLevel) {
        try {
            return GameValues.gvBuildingLibrary.LIBRARY_TECH_LEVEL[nLevel];
        }
        catch (Exception e) {
            return 0.0f;
        }
    }

    public static final int getLibrary_Construction(int nLevel) {
        try {
            return GameValues.gvBuildingLibrary.LIBRARY_CONSTRUCTION[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final boolean constructLibrary(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfLibrary() < BuildingsManager.getLibrary_MaxLevel() && CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getLibrary_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfLibrary() + 1)) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= BuildingsManager.getLibrary_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfLibrary() + 1) && CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getLibrary_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfLibrary() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.LIBRARY) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - BuildingsManager.getLibrary_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfLibrary() + 1));
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getLibrary_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfLibrary() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Library(nProvinceID, BuildingsManager.getLibrary_Construction(CFG.core.getProv(nProvinceID).getLvlOfLibrary() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_LIBRARY);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean constructLibrary_Foreign(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfLibrary() < BuildingsManager.getLibrary_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getLibrary_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfLibrary() + 1)) {
            if (CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getLibrary_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfLibrary() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.LIBRARY) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getLibrary_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfLibrary() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Library(nProvinceID, BuildingsManager.getLibrary_Construction(CFG.core.getProv(nProvinceID).getLvlOfLibrary() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_LIBRARY);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean buildLibrary(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfLibrary() < BuildingsManager.getLibrary_MaxLevel()) {
            CFG.core.getProv(nProvinceID).setLvlOfLibrary(CFG.core.getProv(nProvinceID).getLvlOfLibrary() + 1);
            ++CFG.core.getCiv((int)nCivID).civGD.numOfBuildingsConstructed;
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                CFG.core.getCiv((int)nCivID).getCivDiploGD().messageBox.addMessage(new Message_Built_Library(nCivID, nProvinceID));
            }
            return true;
        }
        return false;
    }

    public static final boolean canBuildLibrary(int nProvinceID) {
        return CFG.core.getProv(nProvinceID).getLvlOfLibrary() < BuildingsManager.getLibrary_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getLibrary_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfLibrary() + 1) && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getMovemPoints() >= BuildingsManager.getLibrary_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfLibrary() + 1);
    }

    public static final int getArmoury_MaxLevel() {
        return GameValues.gvBuildingArmoury.ARMOURY_NAMES.length - 1;
    }

    public static final String getArmoury_Name(int nLevel) {
        try {
            return GameValues.gvBuildingArmoury.ARMOURY_NAMES[nLevel];
        }
        catch (Exception e) {
            return GameValues.gvBuildingArmoury.ARMOURY_NAMES[GameValues.gvBuildingArmoury.ARMOURY_NAMES.length - 1];
        }
    }

    public static final int getArmoury_BuildCost(int nLevel, int nProvinceID) {
        try {
            int iNumOfArmouries = 0;
            for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).getLvlOfArmoury() <= 0) continue;
                ++iNumOfArmouries;
            }
            return Math.max(50, (int)(((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingArmoury.ARMOURY_BUILD_COST[nLevel] + GameValues.gvBuildingArmoury.ARMOURY_EXTRA_COST_PER_ARMOURY * (float)iNumOfArmouries) + (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingArmoury.ARMOURY_COST_DEVELOPMENT_MODIFIER * (1.0f - CFG.core.getProv(nProvinceID).getDeveLvl()))) * (1.0f + CFG.terrainTypesManager.getBuildCost(CFG.core.getProv(nProvinceID).getTerrainTypeID()))));
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getArmoury_BuildMovementCost(int nLevel) {
        try {
            return GameValues.gvBuildingArmoury.ARMOURY_BUILD_MOVEMENT_COST[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final float getArmoury_TechLevel(int nLevel) {
        try {
            return GameValues.gvBuildingArmoury.ARMOURY_TECH_LEVEL[nLevel];
        }
        catch (Exception e) {
            return 0.0f;
        }
    }

    public static final int getArmoury_Construction(int nLevel) {
        try {
            return GameValues.gvBuildingArmoury.ARMOURY_CONSTRUCTION[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final boolean constructArmoury(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfArmoury() < BuildingsManager.getArmoury_MaxLevel() && CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getArmoury_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfArmoury() + 1)) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= BuildingsManager.getArmoury_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfArmoury() + 1) && CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getArmoury_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfArmoury() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.ARMOURY) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - BuildingsManager.getArmoury_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfArmoury() + 1));
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getArmoury_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfArmoury() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Armoury(nProvinceID, BuildingsManager.getArmoury_Construction(CFG.core.getProv(nProvinceID).getLvlOfArmoury() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_ARMOURY);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean constructArmoury_Foreign(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfArmoury() < BuildingsManager.getArmoury_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getArmoury_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfArmoury() + 1)) {
            if (CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getArmoury_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfArmoury() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.ARMOURY) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getArmoury_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfArmoury() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Armoury(nProvinceID, BuildingsManager.getArmoury_Construction(CFG.core.getProv(nProvinceID).getLvlOfArmoury() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_ARMOURY);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean buildArmoury(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfArmoury() < BuildingsManager.getArmoury_MaxLevel()) {
            CFG.core.getProv(nProvinceID).setLvlOfArmoury(CFG.core.getProv(nProvinceID).getLvlOfArmoury() + 1);
            ++CFG.core.getCiv((int)nCivID).civGD.numOfBuildingsConstructed;
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                CFG.core.getCiv((int)nCivID).getCivDiploGD().messageBox.addMessage(new Message_Bulit_Armoury(nCivID, nProvinceID));
            }
            return true;
        }
        return false;
    }

    public static final boolean canBuildArmoury(int nProvinceID) {
        return CFG.core.getProv(nProvinceID).getLvlOfArmoury() < BuildingsManager.getArmoury_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getArmoury_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfArmoury() + 1) && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getMovemPoints() >= BuildingsManager.getArmoury_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfArmoury() + 1);
    }

    public static final int getWorkshop_MaxLevel() {
        return GameValues.gvBuildingWorkshop.WORKSHOP_NAMES.length - 1;
    }

    public static final int getWorkshop_MaxLevel_CanBuild(int nCivID) {
        for (int i = 0; i < GameValues.gvBuildingWorkshop.WORKSHOP_TECHNOLOGY_LEVEL.length; ++i) {
            if (!(GameValues.gvBuildingWorkshop.WORKSHOP_TECHNOLOGY_LEVEL[i] > CFG.core.getCiv(nCivID).getTechLevel())) continue;
            return i - 1;
        }
        return BuildingsManager.getWorkshop_MaxLevel();
    }

    public static final String getWorkshop_Name(int nLevel) {
        try {
            return GameValues.gvBuildingWorkshop.WORKSHOP_NAMES[nLevel];
        }
        catch (Exception e) {
            return GameValues.gvBuildingWorkshop.WORKSHOP_NAMES[GameValues.gvBuildingWorkshop.WORKSHOP_NAMES.length - 1];
        }
    }

    public static final int getWorkshop_BuildCost(int nLevel, int nProvinceID) {
        try {
            int iNumOfBuildigns = 0;
            for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).getLvlOfWorkshop() <= 0) continue;
                iNumOfBuildigns += CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).getLvlOfWorkshop();
            }
            return Math.max(50, (int)(((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingWorkshop.WORKSHOP_BUILD_COST[nLevel] + GameValues.gvBuildingWorkshop.WORKSHOP_EXTRA_COST_PER_WORKSHOP * (float)iNumOfBuildigns) + (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingWorkshop.WORKSHOP_COST_DEVELOPMENT_MODIFIER * (1.0f - CFG.core.getProv(nProvinceID).getDeveLvl()))) * (1.0f + CFG.terrainTypesManager.getBuildCost(CFG.core.getProv(nProvinceID).getTerrainTypeID()))));
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getWorkshop_Construction(int nLevel) {
        try {
            return GameValues.gvBuildingWorkshop.WORKSHOP_CONSTRUCTION[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getWorkshop_BuildMovementCost(int nLevel) {
        try {
            return GameValues.gvBuildingWorkshop.WORKSHOP_BUILD_MOVEMENT_COST[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final float getWorkshop_TechLevel(int nLevel) {
        try {
            return GameValues.gvBuildingWorkshop.WORKSHOP_TECHNOLOGY_LEVEL[nLevel];
        }
        catch (Exception e) {
            return 0.0f;
        }
    }

    public static final float getWorkshop_IncomeProduction(int nLevel) {
        try {
            return GameValues.gvBuildingWorkshop.WORKSHOP_INCOME_PRODUCTION[nLevel];
        }
        catch (Exception e) {
            return GameValues.gvBuildingWorkshop.WORKSHOP_INCOME_PRODUCTION[GameValues.gvBuildingWorkshop.WORKSHOP_INCOME_PRODUCTION.length - 1];
        }
    }

    public static final boolean constructWorkshop(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfWorkshop() < BuildingsManager.getWorkshop_MaxLevel() && CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getWorkshop_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfWorkshop() + 1)) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= BuildingsManager.getWorkshop_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfWorkshop() + 1) && CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getWorkshop_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfWorkshop() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.WORKSHOP) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - BuildingsManager.getWorkshop_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfWorkshop() + 1));
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getWorkshop_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfWorkshop() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Workshop(nProvinceID, BuildingsManager.getWorkshop_Construction(CFG.core.getProv(nProvinceID).getLvlOfWorkshop() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_WORKSHOP);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean constructWorkshop_Foreign(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfWorkshop() < BuildingsManager.getWorkshop_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getWorkshop_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfWorkshop() + 1)) {
            if (CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getWorkshop_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfWorkshop() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.WORKSHOP) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getWorkshop_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfWorkshop() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Workshop(nProvinceID, BuildingsManager.getWorkshop_Construction(CFG.core.getProv(nProvinceID).getLvlOfWorkshop() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_WORKSHOP);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean buildWorkshop(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfWorkshop() < BuildingsManager.getWorkshop_MaxLevel()) {
            CFG.core.getProv(nProvinceID).setLvlOfWorkshop(CFG.core.getProv(nProvinceID).getLvlOfWorkshop() + 1);
            ++CFG.core.getCiv((int)nCivID).civGD.numOfBuildingsConstructed;
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                CFG.core.getCiv((int)nCivID).getCivDiploGD().messageBox.addMessage(new Message_Bulit_Workshop(nCivID, nProvinceID));
            }
            return true;
        }
        return false;
    }

    public static final boolean canBuildWorkshop(int nProvinceID) {
        return CFG.core.getProv(nProvinceID).getLvlOfWorkshop() < BuildingsManager.getWorkshop_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getWorkshop_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfWorkshop() + 1) && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getMovemPoints() >= BuildingsManager.getWorkshop_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfWorkshop() + 1);
    }

    public static final int getMarket_MaxLevel() {
        return GameValues.gvBuildingMarket.MARKET_NAMES.length - 1;
    }

    public static final int getMarket_MaxLevel_CanBuild(int nCivID) {
        for (int i = 0; i < GameValues.gvBuildingMarket.MARKET_TECHNOLOGY_LEVEL.length; ++i) {
            if (!(GameValues.gvBuildingMarket.MARKET_TECHNOLOGY_LEVEL[i] > CFG.core.getCiv(nCivID).getTechLevel())) continue;
            return i - 1;
        }
        return BuildingsManager.getMarket_MaxLevel();
    }

    public static final String getMarket_Name(int nLevel) {
        try {
            return GameValues.gvBuildingMarket.MARKET_NAMES[nLevel];
        }
        catch (Exception e) {
            return GameValues.gvBuildingMarket.MARKET_NAMES[GameValues.gvBuildingMarket.MARKET_NAMES.length - 1];
        }
    }

    public static final int getMarket_BuildCost(int nLevel, int nProvinceID) {
        try {
            int iNumOfBuildigns = 0;
            for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).getLvlOfMarket() <= 0) continue;
                iNumOfBuildigns += CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).getLvlOfMarket();
            }
            return Math.max(50, (int)(((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingMarket.MARKET_BUILD_COST[nLevel] + GameValues.gvBuildingMarket.MARKET_EXTRA_COST_PER_MARKET * (float)iNumOfBuildigns) + (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingMarket.MARKET_COST_DEVELOPMENT_MODIFIER * (1.0f - CFG.core.getProv(nProvinceID).getDeveLvl()))) * (1.0f + CFG.terrainTypesManager.getBuildCost(CFG.core.getProv(nProvinceID).getTerrainTypeID()))));
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getMarket_Construction(int nLevel) {
        try {
            return GameValues.gvBuildingMarket.MARKET_CONSTRUCTION[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final int getMarket_BuildMovementCost(int nLevel) {
        try {
            return GameValues.gvBuildingMarket.MARKET_BUILD_MOVEMENT_COST[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final float getMarket_TechLevel(int nLevel) {
        try {
            return GameValues.gvBuildingMarket.MARKET_TECHNOLOGY_LEVEL[nLevel];
        }
        catch (Exception e) {
            return 0.0f;
        }
    }

    public static final float getMarket_IncomeTaxation(int nLevel) {
        try {
            return GameValues.gvBuildingMarket.MARKET_INCOME_TAXATION[nLevel];
        }
        catch (Exception e) {
            return GameValues.gvBuildingMarket.MARKET_INCOME_TAXATION[GameValues.gvBuildingMarket.MARKET_INCOME_TAXATION.length - 1];
        }
    }

    public static final boolean constructMarket(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfMarket() < BuildingsManager.getMarket_MaxLevel() && CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getMarket_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfMarket() + 1)) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= BuildingsManager.getMarket_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfMarket() + 1) && CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getMarket_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfMarket() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.MARKET) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - BuildingsManager.getMarket_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfMarket() + 1));
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getMarket_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfMarket() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Market(nProvinceID, BuildingsManager.getMarket_Construction(CFG.core.getProv(nProvinceID).getLvlOfMarket() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_MARKET);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean constructMarket_Foreign(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfMarket() < BuildingsManager.getMarket_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getMarket_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfMarket() + 1)) {
            if (CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getMarket_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfMarket() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.MARKET) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getMarket_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfMarket() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Market(nProvinceID, BuildingsManager.getMarket_Construction(CFG.core.getProv(nProvinceID).getLvlOfMarket() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_MARKET);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean buildMarket(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfMarket() < BuildingsManager.getMarket_MaxLevel()) {
            CFG.core.getProv(nProvinceID).setLvlOfMarket(CFG.core.getProv(nProvinceID).getLvlOfMarket() + 1);
            ++CFG.core.getCiv((int)nCivID).civGD.numOfBuildingsConstructed;
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                CFG.core.getCiv((int)nCivID).getCivDiploGD().messageBox.addMessage(new Message_Bulit_Market(nCivID, nProvinceID));
            }
            return true;
        }
        return false;
    }

    public static final boolean canBuildMarket(int nProvinceID) {
        return CFG.core.getProv(nProvinceID).getLvlOfMarket() < BuildingsManager.getMarket_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getMarket_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfMarket() + 1) && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getMovemPoints() >= BuildingsManager.getMarket_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfMarket() + 1);
    }

    public static final int getSupply_MaxLevel() {
        return GameValues.gvBuildingSupplyCamp.SUPPLY_NAMES.length - 1;
    }

    public static final String getSupply_Name(int nLevel) {
        try {
            return GameValues.gvBuildingSupplyCamp.SUPPLY_NAMES[nLevel];
        }
        catch (Exception e) {
            return GameValues.gvBuildingSupplyCamp.SUPPLY_NAMES[GameValues.gvBuildingSupplyCamp.SUPPLY_NAMES.length - 1];
        }
    }

    public static final int getSupply_BuildCost(int nLevel, int nProvinceID) {
        try {
            int iNumOfBuildigns = 0;
            for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).getLvlOfSupply() <= 0) continue;
                ++iNumOfBuildigns;
            }
            return Math.max(50, (int)(((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingSupplyCamp.SUPPLY_BUILD_COST[nLevel] + GameValues.gvBuildingSupplyCamp.SUPPLY_EXTRA_COST_PER_SUPPLY * (float)iNumOfBuildigns) + (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvBuildingSupplyCamp.SUPPLY_COST_DEVELOPMENT_MODIFIER * (1.0f - CFG.core.getProv(nProvinceID).getDeveLvl()))) * (1.0f + CFG.terrainTypesManager.getBuildCost(CFG.core.getProv(nProvinceID).getTerrainTypeID()))));
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final float getSupply_Bonus(int nLevel) {
        try {
            return GameValues.gvBuildingSupplyCamp.SUPPLY_BONUS[nLevel];
        }
        catch (Exception e) {
            return GameValues.gvBuildingSupplyCamp.SUPPLY_BONUS[GameValues.gvBuildingSupplyCamp.SUPPLY_BONUS.length - 1];
        }
    }

    public static final int getSupply_BuildMovementCost(int nLevel) {
        try {
            return GameValues.gvBuildingSupplyCamp.SUPPLY_BUILD_MOVEMENT_COST[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final float getSupply_TechLevel(int nLevel) {
        try {
            return GameValues.gvBuildingSupplyCamp.SUPPLY_TECH_LEVEL[nLevel];
        }
        catch (Exception e) {
            return 0.0f;
        }
    }

    public static final int getSupply_Construction(int nLevel) {
        try {
            return GameValues.gvBuildingSupplyCamp.SUPPLY_CONSTRUCTION[nLevel];
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static final boolean constructSupply(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfSupply() < BuildingsManager.getSupply_MaxLevel() && CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getSupply_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfSupply() + 1)) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= BuildingsManager.getSupply_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfSupply() + 1) && CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getSupply_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfSupply() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.SUPPLY) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - BuildingsManager.getSupply_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfSupply() + 1));
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getSupply_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfSupply() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Supply(nProvinceID, BuildingsManager.getSupply_Construction(CFG.core.getProv(nProvinceID).getLvlOfSupply() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_SUPPLY);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean constructSupply_Foreign(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfSupply() < BuildingsManager.getSupply_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getSupply_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfSupply() + 1)) {
            if (CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getSupply_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfSupply() + 1, nProvinceID)) {
                if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, ConstructionType.SUPPLY) > 0) {
                    return false;
                }
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getSupply_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfSupply() + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new BuildingsConstruction__Supply(nProvinceID, BuildingsManager.getSupply_Construction(CFG.core.getProv(nProvinceID).getLvlOfSupply() + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    Core.addProvinceDot(nProvinceID, Colors.COLOR_SUPPLY);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean canBuildSupply(int nProvinceID) {
        return CFG.core.getProv(nProvinceID).getLvlOfSupply() < BuildingsManager.getSupply_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getSupply_TechLevel(CFG.core.getProv(nProvinceID).getLvlOfSupply() + 1) && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getMovemPoints() >= BuildingsManager.getSupply_BuildMovementCost(CFG.core.getProv(nProvinceID).getLvlOfSupply() + 1);
    }

    public static final boolean buildSupply(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).getLvlOfSupply() < BuildingsManager.getSupply_MaxLevel()) {
            CFG.core.getProv(nProvinceID).setLvlOfSupply(CFG.core.getProv(nProvinceID).getLvlOfSupply() + 1);
            ++CFG.core.getCiv((int)nCivID).civGD.numOfBuildingsConstructed;
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                CFG.core.getCiv((int)nCivID).getCivDiploGD().messageBox.addMessage(new Message_Bulit_Supply(nCivID, nProvinceID));
            }
            return true;
        }
        return false;
    }

    public static final boolean buildMissile(int nCivID) {
        Civilization civ = CFG.core.getCiv(nCivID);
        if (civ.civGD.iMissileResearchProgress >= age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvMissiles.MISSILE_RESEARCH_COST && civ.getGold() >= (long)age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvMissiles.MISSILE_COST && civ.civGD.iMissiles < age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvMissiles.MISSILE_MAX_QUANTITY) {
            civ.setGold(civ.getGold() - (long)age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvMissiles.MISSILE_COST);
            synchronized(civ.civGD.missilesConstruction) {
                civ.civGD.missilesConstruction.add(age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvMissiles.MISSILE_PRODUCTION_TURNS);
            }
            if (civ.getIsPlayer()) {
                CFG.menus.updateInGameTopAll(nCivID);
            }
            return true;
        }
        return false;
    }

    public static final int getAirDefense_MaxLevel() {
        return age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvAirDefense.AIR_DEFENSE_TECH_LEVEL.length - 1;
    }

    public static final int getAirDefense_MaxLevel_CanBuild(int nCivID) {
        for (int i = 0; i < age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvAirDefense.AIR_DEFENSE_TECH_LEVEL.length; ++i) {
            if (!(age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvAirDefense.AIR_DEFENSE_TECH_LEVEL[i] > CFG.core.getCiv(nCivID).getTechLevel())) continue;
            return i - 1;
        }
        return BuildingsManager.getAirDefense_MaxLevel();
    }

                public static final String getAirDefense_Name(int nLevel) {
        try {
            return age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvAirDefense.AIR_DEFENSE_NAMES[nLevel];
        } catch (Exception e) {
            return "Air Defense";
        }
    }

    public static final int getAirDefense_BuildCost(int nLevel, int nProvinceID) {
        try {
            int iNumOfBuildings = 0;
            for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).provGD.iAirDefense <= 0) continue;
                iNumOfBuildings += CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getProvID(i)).provGD.iAirDefense;
            }
            return Math.max(100, (int)(((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvAirDefense.AIR_DEFENSE_BUILD_COST[nLevel] + age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvAirDefense.AIR_DEFENSE_EXTRA_COST_PER_BUILDING * (float)iNumOfBuildings) + (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvAirDefense.AIR_DEFENSE_COST_DEVELOPMENT_MODIFIER * (1.0f - CFG.core.getProv(nProvinceID).getDeveLvl()))) * (1.0f + CFG.terrainTypesManager.getBuildCost(CFG.core.getProv(nProvinceID).getTerrainTypeID()))));
        } catch (Exception e) {
            return 1000;
        }
    }

    public static final int getAirDefense_BuildMovementCost(int nLevel) {
        try {
            return age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvAirDefense.AIR_DEFENSE_BUILD_MOVEMENT_COST[nLevel];
        } catch (Exception e) {
            return 10;
        }
    }

    public static final float getAirDefense_TechLevel(int nLevel) {
        try {
            return age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvAirDefense.AIR_DEFENSE_TECH_LEVEL[nLevel];
        } catch (Exception e) {
            return 0.5f;
        }
    }

    public static final int getAirDefense_Construction(int nLevel) {
        try {
            return age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvAirDefense.AIR_DEFENSE_CONSTRUCTION_TURNS[nLevel];
        } catch (Exception e) {
            return 3;
        }
    }

    public static final boolean canBuildAirDefense(int nProvinceID) {
        return CFG.core.getProv(nProvinceID).provGD.iAirDefense < BuildingsManager.getAirDefense_MaxLevel() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() >= BuildingsManager.getAirDefense_TechLevel(CFG.core.getProv(nProvinceID).provGD.iAirDefense + 1) && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getMovemPoints() >= BuildingsManager.getAirDefense_BuildMovementCost(CFG.core.getProv(nProvinceID).provGD.iAirDefense + 1);
    }

    public static final boolean constructAirDefense(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).provGD.iAirDefense < BuildingsManager.getAirDefense_MaxLevel() && CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getAirDefense_TechLevel(CFG.core.getProv(nProvinceID).provGD.iAirDefense + 1)) {
            if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).isInConstruction(nProvinceID, age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType.AIR_DEFENSE) > 0) {
                return false;
            }
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= BuildingsManager.getAirDefense_BuildMovementCost(CFG.core.getProv(nProvinceID).provGD.iAirDefense + 1) && CFG.core.getCiv(nCivID).getGold() >= (long)BuildingsManager.getAirDefense_BuildCost(CFG.core.getProv(nProvinceID).provGD.iAirDefense + 1, nProvinceID)) {
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - BuildingsManager.getAirDefense_BuildMovementCost(CFG.core.getProv(nProvinceID).provGD.iAirDefense + 1));
                CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)BuildingsManager.getAirDefense_BuildCost(CFG.core.getProv(nProvinceID).provGD.iAirDefense + 1, nProvinceID));
                CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addNewConstruction(new age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__AirDefense(nProvinceID, BuildingsManager.getAirDefense_Construction(CFG.core.getProv(nProvinceID).provGD.iAirDefense + 1)));
                if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                    CFG.menus.updateInGameTopAll(nCivID);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static final boolean buildAirDefense(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).provGD.iAirDefense < BuildingsManager.getAirDefense_MaxLevel()) {
            CFG.core.getProv(nProvinceID).provGD.iAirDefense++;
            ++CFG.core.getCiv((int)nCivID).civGD.numOfBuildingsConstructed;
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                CFG.core.getCiv((int)nCivID).getCivDiploGD().messageBox.addMessage(new age.of.civilizations2.jakowski.lukasz.Messages.Built.Message_Built_AirDefense(nCivID, nProvinceID));
            }
            return true;
        }
        return false;
    }

    public static final boolean destroyAirDefense(int nProvinceID, int nCivID) {
        if (!CFG.core.getProv(nProvinceID).getSeaProv() && CFG.core.getProv(nProvinceID).provGD.iAirDefense > 0) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvBuildings.DESTROY_MOVEMENT_COST) {
                CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - age.of.civilizations2.jakowski.lukasz.GameValues.GameValues.gvBuildings.DESTROY_MOVEMENT_COST);
                CFG.core.getProv(nProvinceID).provGD.iAirDefense = 0;
                return true;
            }
            return false;
        }
        return false;
    }
}

