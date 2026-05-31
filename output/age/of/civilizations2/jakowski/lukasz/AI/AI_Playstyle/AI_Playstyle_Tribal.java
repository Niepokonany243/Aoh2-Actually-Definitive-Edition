
package age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AIPlaystyle;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_Type;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy_Migrate;
import java.util.ArrayList;

public class AI_Playstyle_Tribal
extends AIPlaystyle {
    private int MIGRATE_MAX_NUM_OF_PROVINCES = 10;

    public AI_Playstyle_Tribal() {
        this.TAG = "UNCIVILIZED";
        this.MIGRATE_MAX_NUM_OF_PROVINCES = 4 + CFG.oR.nextInt(3);
        this.PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = 0.02f;
        this.PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = 9;
        this.PERSONALITY_MIN_HAPPINESS_DEFAULT = 80;
        this.PERSONALITY_MIN_HAPPINESS_RANDOM = 18;
        this.PERSONALITY_FORGIVENESS_DEFAULT = 0.5f;
        this.PERSONALITY_FORGIVENESS_RANDOM = 20;
        this.MIN_TURNS_TO_ABANDON_USELESS_PROVINCE = 25;
    }

    @Override
    public void turnOrders(int nCivID) {
        if (!CFG.core.getCiv(nCivID).isAtWarC() && CFG.core.getCiv(nCivID).getCapitalProvID() >= 0) {
            if (CFG.oR.nextInt(100) < CFG.core.getCiv((int)nCivID).UNCIVILIZED_MIGRATE) {
                if (CFG.core.getCiv(nCivID).getNumOfProvs() < this.MIGRATE_MAX_NUM_OF_PROVINCES) {
                    if (!this.migration(nCivID)) {
                        
                    }
                } else {
                    this.migration_NotConnected(nCivID);
                    this.migration_NotConnected_OLD(nCivID);
                }
            } else {
                this.migration_NotConnected(nCivID);
                this.migration_NotConnected_OLD(nCivID);
            }
        }
        this.civilize(nCivID);
        this.checkBalanceOfProvinces_Tribal(nCivID);
        super.turnOrders(nCivID);
    }

    @Override
    public void armyOverBudget_Disband(int nCivID) {
        for (int k = CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.size() - 1; k >= 0; --k) {
            if (CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.get((int)k).MISSION_TYPE != CivArmyMission_Type.EXPAND_NETURAL_PROVINCE) continue;
            return;
        }
        super.armyOverBudget_Disband(nCivID);
    }

    @Override
    public void buildStartingBuildings(int nCivID) {
        block3: {
            try {
                if (CFG.core.getCiv(nCivID).getCapitalProvID() >= 0 && CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getFarm_TechLevel(1) * 0.88f) {
                    CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).setLvlOfFarm(1);
                }
            }
            catch (IndexOutOfBoundsException ex) {
                if (!CFG.LOGs) break block3;
                CFG.exceptionStack(ex);
            }
        }
    }

    public final boolean migration(int nCivID) {
        if (this.canCivlize(nCivID)) {
            return false;
        }
        ArrayList<Integer> nMigrateFrom = new ArrayList<Integer>();
        for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            if (!Core.uncivilizedCanMigrate_FromProv(CFG.core.getCiv(nCivID).getProvID(i), nCivID)) continue;
            nMigrateFrom.add(CFG.core.getCiv(nCivID).getProvID(i));
        }
        if (nMigrateFrom.size() > 0) {
            int i;
            ArrayList<Integer> nNotConnected = new ArrayList<Integer>();
            for (i = 0; i < nMigrateFrom.size(); ++i) {
                if (((Integer)nMigrateFrom.get(i)).intValue() == CFG.core.getCiv(nCivID).getCapitalProvID()) continue;
                if (Core.provinceBordersWithProvince_LandByLand((Integer)nMigrateFrom.get(i), CFG.core.getCiv(nCivID).getCapitalProvID())) continue;
                nNotConnected.add((Integer)nMigrateFrom.get(i));
            }
            if (nNotConnected.size() > 0) {
                for (i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                    if (CFG.core.getCiv(nCivID).getProvID(i) == CFG.core.getCiv(nCivID).getCapitalProvID()) continue;
                    for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvincesSize(); ++j) {
                        if (!Core.provinceBordersWithProvince_LandByLand(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j), CFG.core.getCiv(nCivID).getCapitalProvID())) continue;
                        CFG.gameAction.migrateToProvince(CFG.core.getCiv(nCivID).getProvID(i), CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j), nCivID, false);
                    }
                }
            } else if (Core.uncivilizedCanMigrate_FromProv(CFG.core.getCiv(nCivID).getCapitalProvID(), nCivID)) {
                ArrayList<Integer> nMigrateTo = new ArrayList<Integer>();
                for (int i2 = 0; i2 < CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getNeighProvincesSize(); ++i2) {
                    if (!Core.uncivilizedCanMigrate(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getNeighProvinces(i2), nCivID)) continue;
                    nMigrateTo.add(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getNeighProvinces(i2));
                }
                if (nMigrateTo.size() > 0) {
                    int i3;
                    int nBestID = 0;
                    for (i3 = 1; i3 < nMigrateTo.size(); ++i3) {
                        if (this.migrationTo_Score((Integer)nMigrateTo.get(nBestID), nCivID) >= this.migrationTo_Score((Integer)nMigrateTo.get(i3), nCivID)) continue;
                        nBestID = i3;
                    }
                    CFG.gameAction.migrateToProvince(CFG.core.getCiv(nCivID).getCapitalProvID(), (Integer)nMigrateTo.get(nBestID), nCivID, false);
                    if (CFG.core.getCiv(nCivID).getNumOfProvs() > 1) {
                        try {
                            for (i3 = 0; i3 < CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(1)).getNeighProvincesSize(); ++i3) {
                                if (CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(1)).getNeighProvinces(i3) != CFG.core.getCiv(nCivID).getCapitalProvID()) continue;
                                CFG.gameAction.migrateToProvince(CFG.core.getCiv(nCivID).getProvID(1), CFG.core.getCiv(nCivID).getCapitalProvID(), nCivID, false);
                            }
                        }
                        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private final void migration_NotConnected_OLD(int nCivID) {
        int i;
        ArrayList<Integer> nMigrateFrom = new ArrayList<Integer>();
        for (int i2 = 0; i2 < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i2) {
            if (!Core.uncivilizedCanMigrate_FromProv(CFG.core.getCiv(nCivID).getProvID(i2), nCivID)) continue;
            nMigrateFrom.add(CFG.core.getCiv(nCivID).getProvID(i2));
        }
        ArrayList<Integer> nNotConnected = new ArrayList<Integer>();
        for (i = 0; i < nMigrateFrom.size(); ++i) {
            if (((Integer)nMigrateFrom.get(i)).intValue() == CFG.core.getCiv(nCivID).getCapitalProvID()) continue;
            if (Core.provinceBordersWithProvince_LandByLand((Integer)nMigrateFrom.get(i), CFG.core.getCiv(nCivID).getCapitalProvID())) continue;
            nNotConnected.add((Integer)nMigrateFrom.get(i));
        }
        if (nNotConnected.size() > 0) {
            for (i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                if (CFG.core.getCiv(nCivID).getProvID(i) == CFG.core.getCiv(nCivID).getCapitalProvID()) continue;
                for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvincesSize(); ++j) {
                    if (!Core.provinceBordersWithProvince_LandByLand(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j), CFG.core.getCiv(nCivID).getCapitalProvID())) continue;
                    CFG.gameAction.migrateToProvince(CFG.core.getCiv(nCivID).getProvID(i), CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j), nCivID, false);
                }
            }
        }
    }

    private final void migration_NotConnected(int nCivID) {
        try {
            if (CFG.core.getCiv(nCivID).getCapitalProvID() >= 0) {
                ArrayList<Integer> nMigrateFrom = new ArrayList<Integer>();
                for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                    if (!Core.uncivilizedCanMigrate_FromProv(CFG.core.getCiv(nCivID).getProvID(i), nCivID) || CFG.core.getCiv(nCivID).migratesFromProvinceID(CFG.core.getCiv(nCivID).getProvID(i))) continue;
                    nMigrateFrom.add(CFG.core.getCiv(nCivID).getProvID(i));
                }
                if (nMigrateFrom.size() > 0) {
                    ArrayList<Integer> nNotConnected = new ArrayList<Integer>();
                    for (int i = 0; i < nMigrateFrom.size(); ++i) {
                        if (CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getCivRegionID() == CFG.core.getProv((Integer)nMigrateFrom.get(i)).getCivRegionID()) continue;
                        nNotConnected.add((Integer)nMigrateFrom.get(i));
                    }
                    if (nNotConnected.size() > 0) {
                        int i;
                        ArrayList<Integer> nMigrateTo = new ArrayList<Integer>();
                        for (i = 0; i < CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getNeighProvincesSize(); ++i) {
                            if (CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getNeighProvinces(i)).getCivId() != 0) continue;
                            nMigrateTo.add(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getNeighProvinces(i));
                        }
                        if (nMigrateTo.size() == 0) {
                            for (i = 0; i < CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getNeighProvincesSize(); ++i) {
                                for (int j = 0; j < CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getNeighProvinces(i)).getNeighProvincesSize(); ++j) {
                                    if (CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getNeighProvinces(i)).getNeighProvinces(j)).getCivId() != 0) continue;
                                    nMigrateTo.add(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getNeighProvinces(i)).getNeighProvinces(j));
                                }
                            }
                        }
                        if (nMigrateTo.size() > 0) {
                            ArrayList<RegroupArmy_Migrate> tMigrate = new ArrayList<RegroupArmy_Migrate>();
                            int nMigrateNotConnectedID = nNotConnected.size() - 1;
                            for (int j = nMigrateTo.size() - 1; j >= 0; --j) {
                                RegroupArmy_Migrate tData = new RegroupArmy_Migrate(nCivID, (Integer)nNotConnected.get(nMigrateNotConnectedID), (Integer)nMigrateTo.get(j));
                                if (tData.getRouteSize() <= 0) continue;
                                tMigrate.add(tData);
                            }
                            if (tMigrate.size() > 0) {
                                int tBestID = 0;
                                for (int i2 = tMigrate.size() - 1; i2 > 0; --i2) {
                                    if (((RegroupArmy_Migrate)tMigrate.get(tBestID)).getRouteSize() > ((RegroupArmy_Migrate)tMigrate.get(i2)).getRouteSize()) {
                                        tBestID = i2;
                                        continue;
                                    }
                                    if (((RegroupArmy_Migrate)tMigrate.get(tBestID)).getRouteSize() != ((RegroupArmy_Migrate)tMigrate.get(i2)).getRouteSize() || CFG.oR.nextInt(100) >= 50) continue;
                                    tBestID = i2;
                                }
                                CFG.gameAction.migrateToProvince((Integer)nNotConnected.get(nMigrateNotConnectedID), ((RegroupArmy_Migrate)tMigrate.get(tBestID)).getRoute(0), nCivID, false);
                            }
                        }
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
        }
    }

    private final int migrationTo_Score(int nProvinceID, int nCivID) {
        int out = 0;
        out += (int)(CFG.core.getProv(nProvinceID).getGrowthRate_Pop_WithFarm() * 100.0f);
        if (CFG.core.getProv(nProvinceID).getCores().getHaveACore(nCivID)) {
            out += 250;
        }
        for (int i = 0; i < CFG.core.getProv(nProvinceID).getNeighProvincesSize(); ++i) {
            out += (int)(CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighProvinces(i)).getGrowthRate_Pop_WithFarm() * 10.0f);
            if (CFG.core.getProv(nProvinceID).getNeighProvinces(i) == CFG.core.getCiv(nCivID).getCapitalProvID()) {
                out += 50;
            }
            if (CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighProvinces(i)).getCivId() <= 0 || CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighProvinces(i)).getCivId() == nCivID) continue;
            out -= 200;
        }
        return out;
    }

    @Override
    public void buildBuildings(int nCivID) {
    }
}

