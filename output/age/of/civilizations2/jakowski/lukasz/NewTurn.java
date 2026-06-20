
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Province.ForeignInvest;
import age.of.civilizations2.jakowski.lukasz.Ideology;
import java.util.concurrent.ThreadLocalRandom;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Festivals.Festival;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameN;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.CitiesManager;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_2;
import age.of.civilizations2.jakowski.lukasz.Messages.Civilization.Message_MilitaryExpPoints;
import age.of.civilizations2.jakowski.lukasz.Messages.DefensivePact.Response.Message_DefensivePact_Expired;
import age.of.civilizations2.jakowski.lukasz.Messages.Guarantee.Message_IndependenceFrom_Expired;
import age.of.civilizations2.jakowski.lukasz.Messages.Guarantee.Message_Independence_Expired;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_GoodsLow;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_InvestmentsLow;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_RelocateCapital;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_TechPoints;
import age.of.civilizations2.jakowski.lukasz.Messages.Invest.Message_InvestBuildDoneForeign;
import age.of.civilizations2.jakowski.lukasz.Messages.Invest.Message_InvestDoneForeign;
import age.of.civilizations2.jakowski.lukasz.Messages.Message_MigrationComplete;
import age.of.civilizations2.jakowski.lukasz.Messages.MilitaryAccess.Message_MilitaryAccess_ExpireSoon;
import age.of.civilizations2.jakowski.lukasz.Messages.MilitaryAccess.Message_MilitaryAccess_Expired;
import age.of.civilizations2.jakowski.lukasz.Messages.NonAggression.Message_NonAggressionPact_Expired;
import age.of.civilizations2.jakowski.lukasz.Messages.Province.Message_ProvincesOccupiedNotAtWar_LostControl;
import age.of.civilizations2.jakowski.lukasz.Messages.Relations.Summit.Message_SummitIsOver;
import age.of.civilizations2.jakowski.lukasz.Messages.Relations.Vassal.Message_VassalHighLiberty;
import age.of.civilizations2.jakowski.lukasz.Messages.Truce.Message_Truce_Expired;
import age.of.civilizations2.jakowski.lukasz.Messages.War.Message_War;
import age.of.civilizations2.jakowski.lukasz.NewGameManager;
import age.of.civilizations2.jakowski.lukasz.Parallel;
import age.of.civilizations2.jakowski.lukasz.PopulationGrowth;
import age.of.civilizations2.jakowski.lukasz.Province;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import com.badlogic.gdx.Gdx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NewTurn
extends Thread {
    private static long tempTime;
    private static long tempTimeTotal;
    public static float ageRiskModifier;
    public static float ageDevMod;
    public static List<Float> happinessChange_ByTaxation;
    public static List<Float> happinessChange_ByTaxation_Occupied;
    public static List<Float> goodsUpdate;
    public static List<Float> devUpdate;
    public static List<Float> ecoUpdate;
    private static final ThreadLocal<ArrayList<PopulationGrowth>> threadLocalPopGrowth = ThreadLocal.withInitial(() -> new ArrayList<PopulationGrowth>());

    @Override
    public void run() {
        NewTurn.doAction();
    }

    public static void checkOccupiedProvincesIfAreAtWar() {
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            Province province = CFG.core.getProv(i);
            if (province.getSeaProv() || province.getWastelandLvl() >= 0 || !province.isOccupied()) {
                province.provGD.iOccupationTurns = 0;
                continue;
            }
            int civId = province.getCivId();
            int trueOwner = province.getTrueOwnerOfProv();
            if (CFG.core.getCiv(civId).getIdeology() == CFG.ideologiesMgr.REBELS_ID || CFG.core.getCivsAtWar(civId, trueOwner) || CFG.core.getCiv(civId).civGD.civPlans.isPreparingForTheWar(trueOwner) || CFG.core.getCiv(trueOwner).civGD.civPlans.isPreparingForTheWar(civId)) {
                province.provGD.iOccupationTurns = 0;
                continue;
            }
            province.provGD.iOccupationTurns++;
            if (province.provGD.iOccupationTurns < 150) continue;
            {
                if (CFG.core.getCiv(civId).getIsPlayer()) {
                    CFG.core.getCiv(civId).getCivDiploGD().messageBox.addMessage(new Message_ProvincesOccupiedNotAtWar_LostControl(trueOwner, i));
                }
                long tempArmy0 = province.getArmyID(0);
                int tempCiv0 = civId;
                long tempArmyNewOwner = province.getArmyCivID1(trueOwner);
                province.updateArmy4(0);
                province.setCivId(trueOwner, false);
                province.updateArmy4(tempCiv0, tempArmy0);
                province.updateArmy4(trueOwner, tempArmyNewOwner);
                ArrayList<Integer> tempCivsLostAccess = new ArrayList<Integer>();
                for (int j = 0; j < province.getCivsSize(); ++j) {
                    tempCivsLostAccess.add(province.getCivId(j));
                }
                for (int j = 0; j < tempCivsLostAccess.size(); ++j) {
                    int accessCivId = tempCivsLostAccess.get(j);
                    if (CFG.core.getCiv(accessCivId).getPuppetOfCiv() == trueOwner || CFG.core.getCiv(trueOwner).getPuppetOfCiv() == accessCivId || CFG.core.getCiv(accessCivId).getAlliance() > 0 && CFG.core.getCiv(accessCivId).getAlliance() == CFG.core.getCiv(trueOwner).getAlliance() || CFG.core.getMilitaryAccess(accessCivId, trueOwner) > 0) continue;
                    CFG.gameAction.accessLost_MoveArmyToClosetsProvince(accessCivId, i);
                }
                province.provGD.iOccupationTurns = 0;
            }
        }
    }

    public static long lastTurnTime = 0L;
    public static final void doAction() {
        long perfStart = System.currentTimeMillis();
        long perfMark = perfStart;
        CFG.resetModes();
        CFG.core.invalidateWarCache();
        try {
            if (GameCalendar.TURNID % 10 == 0) {
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                                Civilization civ = CFG.core.getCiv(i);
                                if (civ != null) {
                                    civ.setCivName(civ.getCivName());
                                }
                            }
                            CFG.menus.updateLang();
                        } catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                    }
                });
            }
            MilitaryRealism.updateMobilizationAllCivs();
            CFG.gameUpdate.updateCivs_Money();
            long perfNow = System.currentTimeMillis(); if (perfNow - perfMark > 50) { CFG.LOG("PERF", "[doAction] updateCivs_Money: " + (perfNow - perfMark) + "ms"); } perfMark = perfNow;

            for (int civIndex = 1; civIndex < CFG.core.getCivsSize(); ++civIndex) {
                try {
                    Civilization civI = CFG.core.getCiv(civIndex);
                    if (civI == null || (civI.getNumOfProvs() <= 0 && civI.getGold() <= 0 && civI.getNumberOfUnits() <= 0)) continue;

                    civI.runFestivals();
                    civI.runInvests_Development();
                    civI.runInvests();
                    GameManager.processArmyStabilization(civIndex);
                    civI.runAssimilates();
                    civI.runWarReparations();
                    civI.runStrategy();
                    
                    civI.getCivDiploGD().messageBox.updateNextTurn(civIndex);
                    civI.updateBonuses();
                    civI.updateGift_Received();
                    civI.updateNumberOfUnits();
                    
                    civI.getCivDiploGD().updateEmbassyClosed();
                    civI.getCivDiploGD().runImproveRelations(civIndex);
                    civI.updateRevolutionaryTransition();

                    if (!CFG.SPECTATOR_MODE) {
                        for (int pIdx = 0; pIdx < CFG.core.getPlayersSize(); ++pIdx) {
                            if (CFG.core.getPlayer(pIdx).getCivId() == civIndex) {
                                if (civI.getNumOfProvs() > 0) {
                                    CFG.core.getPlayer((int)pIdx).statsCiv.setTurns(CFG.core.getPlayer((int)pIdx).statsCiv.getTurns() + 1);
                                }
                            }
                        }
                    }
                    
                    if (civI.getNumOfProvs() > 0) {
                        for (int j = civI.provincesWithLowStability.size() - 1; j >= 0; --j) {
                            int provID = civI.provincesWithLowStability.get(j);
                            Province p = CFG.core.getProv(provID);
                            if (p.getProviStability() < GameValues.gvRebels.RISE_REVOLT_RISK_IN_PROVINCE_IF_STABILITY_BELOW && !p.isOccupied() && p.getRevRisk() < 0.55f) {
                                p.setRevRisk(p.getRevRisk() + ageRiskModifier * (GameValues.gvRebels.RISE_REVOLT_RISK_IN_PROVINCE_IF_STABILITY_BELOW - p.getProviStability()) * 0.0155f);
                            }
                        }
                    }
                } catch (Exception ex) {}
            }
            long perfNow2 = System.currentTimeMillis(); if (perfNow2 - perfMark > 50) { CFG.LOG("PERF", "[doAction] civLoop: " + (perfNow2 - perfMark) + "ms"); } perfMark = perfNow2;

            CFG.plagueManager.runPlagues();
            CFG.core.cleanupWars();
            long perfNow3 = System.currentTimeMillis(); if (perfNow3 - perfMark > 50) { CFG.LOG("PERF", "[doAction] cleanupWars: " + (perfNow3 - perfMark) + "ms"); } perfMark = perfNow3;

            NewTurn.updateCapitulation();
            NewTurn.checkOccupiedProvincesIfAreAtWar();
            NewTurn.updateGameData();
            
            CFG.gameAction.updateCivsMovementPoints();
            CFG.gameAction.updateCivsDiploPoints();
            NewTurn.updateDiplomacy();
            
            if (GameValues.gvUpdate.USE_OLD_CIV_HAPPINESS_UPDATE) {
                CFG.gameAction.updateCivsHappiness_AllCivs();
            } else {
                CFG.gameAction.updateCivsHappiness_New();
            }
            
            if (GameValues.gvUpdate.USE_OLD_PROVINCE_STABILITY_UPDATE) {
                CFG.gameUpdate.updateProvinceStabilityAllProvinces();
            } else {
                CFG.gameUpdate.updatePrvStability();
            }
            
            CFG.gameUpdate.updateInflationPeakValueAllCivs();
            GameCalendar.updateDateNextTurn();
            NewTurn.updateBuildingsConstruction();
            NewTurn.updateWarWeariness();
            NewTurn.updateForeignInvests();
            NewTurn.updateForeignBuildInvests();
            NewTurn.updateDiplomaticSummits();
            NewTurn.updatePropaganda();
            NewTurn.updateSanctions();
            NewTurn.updateLibertyDesireMessages();
            NewTurn.updateAirDefense();
            
            try {
                GameManager.updateGoldenAge();
                GameManager.sendUncivilizedMessages();
                GameManager.sendLowHappiness();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            
            if (!CFG.SPECTATOR_MODE) {
                for (int i4 = 0; i4 < CFG.core.getPlayersSize(); ++i4) {
                    int pCivID = CFG.core.getPlayer(i4).getCivId();
                    Civilization pCiv = CFG.core.getCiv(pCivID);
                    if (pCiv.getNumOfProvs() <= 0) continue;
                    
                    List<Integer> prepLeaders = new ArrayList<Integer>();
                    List<Integer> prepWarIDs = new ArrayList<Integer>();
                    for (int j = pCiv.civGD.civPlans.warPreps.size() - 1; j >= 0; --j) {
                        if (--pCiv.civGD.civPlans.warPreps.get((int)j).iNumOfTurnsLeft > 0) continue;
                        int tOnCivID = pCiv.civGD.civPlans.warPreps.get((int)j).onCivID;
                        int tLeaderCivID = pCiv.civGD.civPlans.warPreps.get((int)j).iLeaderCivID;
                        int tLeaderID = -1;
                        int tWarID = -1;
                        for (int k = 0; k < prepLeaders.size(); ++k) {
                            if (prepLeaders.get(k) != tLeaderCivID) continue;
                            tLeaderID = k;
                            tWarID = prepWarIDs.get(k);
                            break;
                        }
                        tWarID = GameManager.declareWarInWarGroup(pCivID, tOnCivID, tWarID, false);
                        if (tWarID >= 0) {
                            if (tLeaderID >= 0) {
                                prepWarIDs.set(tLeaderID, tWarID);
                            } else {
                                prepLeaders.add(tLeaderCivID);
                                prepWarIDs.add(tWarID);
                            }
                        }
                        pCiv.getCivDiploGD().messageBox.addMessage(new Message_War(tOnCivID, pCivID));
                        try {
                            pCiv.civGD.civPlans.warPreps.remove(j);
                            pCiv.civGD.civPlans.iWarPrepsSize = pCiv.civGD.civPlans.warPreps.size();
                        }
                        catch (Exception exception) {}
                    }
                    
                    if (pCiv.getCapitalProvID() >= 0 && (CFG.core.getProv(pCiv.getCapitalProvID()).getCivId() == pCivID || CFG.core.getProv(pCiv.getCapitalProvID()).isOccupied())) continue;
                    pCiv.getCivDiploGD().messageBox.addMessage(new Message_RelocateCapital(pCivID));
                }
            }
            
            CFG.gameAction.updateHRE_Elections();
            if (CFG.SANDBOX_MODE && !CFG.SPECTATOR_MODE) {
                CFG.gameNewGame.sandboxMode();
            }
            if (CFG.SANDBOX_MODE_AI) {
                NewGameManager.sandboxMode_AI();
            }
            
            CFG.gameAction.updateRelations();
            Core.updateOverInvestment();
            GameManager.checkCivsHatedCivilizations_IfStillExists();
            GameManager.updatePlayersFriendlyCivs();
            
            for (int warID = 0; warID < CFG.core.getWarsSize(); ++warID) {
                CFG.core.getWar(warID).iLastFight_InTurns++;
            }
            
            NewTurn.updateProvinceVolunteerArmySent();
            try {
                NewTurn.migr();
                NewTurn.checkCoreDegradation();
                GameN.updateLeaderDeath();
            }
            catch (Exception i5) {}

            ++SaveGameManager.iTurnsSinceLastSave;
            if (SaveGameManager.gameWillBeSavedInThisTurn()) {
                SaveGameManager.trySaveGame();
            } else {
                NewTurn.doAction_End();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        finally {
            long perfEnd = System.currentTimeMillis();
            lastTurnTime = perfEnd - perfStart;
            if (lastTurnTime > 100) { CFG.LOG("PERF", "[doAction] TOTAL: " + lastTurnTime + "ms"); }
            CFG.menus.getInGameProvInfo().getMenuElem(0).setClickable(true);
            Menu_InGame_2.TIME_CONTINUE = System.currentTimeMillis();
        }
    }

    public static final void migr() {
        try {
            for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                Player player = CFG.core.getPlayer(i);
                if (player == null || player.playerGD == null) continue;
                
                boolean useNew = player.playerGD.migrationOrders != null && !player.playerGD.migrationOrders.isEmpty();
                boolean useOld = !useNew && player.playerGD.migrationF != null && !player.playerGD.migrationF.isEmpty();
                if (!useNew && !useOld) continue;
                
                int playerCivID = player.getCivId();
                Civilization playerCiv = CFG.core.getCiv(playerCivID);
                if (playerCiv == null) continue;
                
                if (useNew) {
                    List<MigrationOrder> migrationOrders = player.playerGD.migrationOrders;
                    boolean[] removed = new boolean[migrationOrders.size()];
                    for(int r = 0; r < removed.length; r++) removed[r] = true;
                    
                    for (int k = 0; k < playerCiv.getNumOfProvs(); ++k) {
                        int provID = playerCiv.getProvID(k);
                        Province province = CFG.core.getProv(provID);
                        Province_Population pop = province.getPop();
                        
                        for (int o = pop.getNatsSize() - 1; o >= 0; --o) {
                            int natCivID = pop.getCivID(o);
                            long maxPop = pop.getPopulationID(o);
                            if (maxPop <= 0) continue;
                            
                            for(int m = 0; m < migrationOrders.size(); m++) {
                                MigrationOrder order = migrationOrders.get(m);
                                if (order.getNationalityCivID() == natCivID) {
                                    int popTM = (int)Math.min((float)maxPop, Math.max((float)GameValues.gvPopRelocate.MIGRATE_MIN, (float)maxPop * GameValues.gvPopRelocate.MIGRATE_PERC));
                                    float perc = (float)popTM / (float)pop.getPops();
                                    
                                    province.setEco((int)((float)province.getEco() * (1.0f - perc * GameValues.gvPopRelocate.MIGRATE_ECO_MODIFIER)));
                                    province.setRevRisk(province.getRevRisk() + perc * GameValues.gvPopRelocate.MIGRATE_REV_RISK_MODIFIER);
                                    pop.setPopulationOfCivID(natCivID, pop.getPopulationID(o) - popTM);
                                    
                                    int targetCivID = order.getTargetCivID();
                                    if (targetCivID > 0 && CFG.core.getCiv(targetCivID).getNumOfProvs() > 0) {
                                        int toPr = CFG.core.getCiv(targetCivID).getProvID(ThreadLocalRandom.current().nextInt(CFG.core.getCiv(targetCivID).getNumOfProvs()));
                                        CFG.core.getProv(toPr).getPop().setPopulationOfCivID(natCivID, CFG.core.getProv(toPr).getPop().getPopulationOfCivID(natCivID) + popTM);
                                    } else {
                                        Civilization natCiv = CFG.core.getCiv(natCivID);
                                        if (natCiv.getNumOfProvs() > 0) {
                                            int toPr = natCiv.getProvID(ThreadLocalRandom.current().nextInt(natCiv.getNumOfProvs()));
                                            CFG.core.getProv(toPr).getPop().setPopulationOfCivID(natCivID, CFG.core.getProv(toPr).getPop().getPopulationOfCivID(natCivID) + popTM);
                                        } else {
                                            for (int y = 0; y < 25; ++y) {
                                                int rand = ThreadLocalRandom.current().nextInt(CFG.core.getProvinSize());
                                                Province randProv = CFG.core.getProv(rand);
                                                if (randProv.getSeaProv() || randProv.getWastelandLvl() >= 0) continue;
                                                randProv.getPop().setPopulationOfCivID(natCivID, randProv.getPop().getPopulationOfCivID(natCivID) + popTM);
                                                break;
                                            }
                                        }
                                    }
                                    removed[m] = false;
                                }
                            }
                        }
                    }
                    
                    for(int m = migrationOrders.size() - 1; m >= 0; m--) {
                        MigrationOrder order = migrationOrders.get(m);
                        int natCivID = order.getNationalityCivID();
                        int targetCivID = order.getTargetCivID();
                        
                        CFG.core.getCiv(natCivID).setRelationD(playerCivID, CFG.core.getCiv(natCivID).getRelationD(playerCivID) + GameValues.gvPopRelocate.MIGRATE_RELATIONS_CHANGE_PER_TURN);
                        CFG.core.getCiv(playerCivID).setRelationD(natCivID, CFG.core.getCiv(playerCivID).getRelationD(natCivID) + GameValues.gvPopRelocate.MIGRATE_RELATIONS_CHANGE_PER_TURN);
                        
                        if (targetCivID > 0 && targetCivID != natCivID) {
                            CFG.core.getCiv(targetCivID).setRelationD(playerCivID, CFG.core.getCiv(targetCivID).getRelationD(playerCivID) + GameValues.gvPopRelocate.MIGRATE_DEPORT_TARGET_RELATIONS_CHANGE_PER_TURN);
                            CFG.core.getCiv(playerCivID).setRelationD(targetCivID, CFG.core.getCiv(playerCivID).getRelationD(targetCivID) + GameValues.gvPopRelocate.MIGRATE_DEPORT_TARGET_RELATIONS_CHANGE_PER_TURN);
                        }
                        
                        if (removed[m]) {
                            CFG.core.getCiv(playerCivID).getCivDiploGD().messageBox.addMessage(new Message_MigrationComplete(natCivID, targetCivID));
                            player.playerGD.migrationOrders.remove(m);
                        }
                    }
                } else {
                    List<Integer> migrationF = player.playerGD.migrationF;
                    boolean[] removed = new boolean[migrationF.size()];
                    for(int r = 0; r < removed.length; r++) removed[r] = true;
                    
                    for (int k = 0; k < playerCiv.getNumOfProvs(); ++k) {
                        int provID = playerCiv.getProvID(k);
                        Province province = CFG.core.getProv(provID);
                        Province_Population pop = province.getPop();
                        
                        for (int o = pop.getNatsSize() - 1; o >= 0; --o) {
                            int natCivID = pop.getCivID(o);
                            long maxPop = pop.getPopulationID(o);
                            if (maxPop <= 0) continue;
                            
                            for(int m = 0; m < migrationF.size(); m++) {
                                if (migrationF.get(m) == natCivID) {
                                    int popTM = (int)Math.min((float)maxPop, Math.max((float)GameValues.gvPopRelocate.MIGRATE_MIN, (float)maxPop * GameValues.gvPopRelocate.MIGRATE_PERC));
                                    float perc = (float)popTM / (float)pop.getPops();
                                    
                                    province.setEco((int)((float)province.getEco() * (1.0f - perc * GameValues.gvPopRelocate.MIGRATE_ECO_MODIFIER)));
                                    province.setRevRisk(province.getRevRisk() + perc * GameValues.gvPopRelocate.MIGRATE_REV_RISK_MODIFIER);
                                    pop.setPopulationOfCivID(natCivID, pop.getPopulationID(o) - popTM);
                                    
                                    Civilization natCiv = CFG.core.getCiv(natCivID);
                                    if (natCiv.getNumOfProvs() > 0) {
                                        int toPr = natCiv.getProvID(ThreadLocalRandom.current().nextInt(natCiv.getNumOfProvs()));
                                        CFG.core.getProv(toPr).getPop().setPopulationOfCivID(natCivID, CFG.core.getProv(toPr).getPop().getPopulationOfCivID(natCivID) + popTM);
                                    } else {
                                        for (int y = 0; y < 25; ++y) {
                                            int rand = ThreadLocalRandom.current().nextInt(CFG.core.getProvinSize());
                                            Province randProv = CFG.core.getProv(rand);
                                            if (randProv.getSeaProv() || randProv.getWastelandLvl() >= 0) continue;
                                            randProv.getPop().setPopulationOfCivID(natCivID, randProv.getPop().getPopulationOfCivID(natCivID) + popTM);
                                            break;
                                        }
                                    }
                                    removed[m] = false;
                                }
                            }
                        }
                    }
                    
                    for(int m = migrationF.size() - 1; m >= 0; m--) {
                        int targetCiv = migrationF.get(m);
                        CFG.core.getCiv(targetCiv).setRelationD(playerCivID, CFG.core.getCiv(targetCiv).getRelationD(playerCivID) + GameValues.gvPopRelocate.MIGRATE_RELATIONS_CHANGE_PER_TURN);
                        CFG.core.getCiv(playerCivID).setRelationD(targetCiv, CFG.core.getCiv(playerCivID).getRelationD(targetCiv) + GameValues.gvPopRelocate.MIGRATE_RELATIONS_CHANGE_PER_TURN);
                        
                        if (removed[m]) {
                            CFG.core.getCiv(playerCivID).getCivDiploGD().messageBox.addMessage(new Message_MigrationComplete(targetCiv, -1));
                            player.playerGD.migrationF.remove(m);
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void checkCoreDegradation() {
        try {
            if (GameCalendar.TURNID % Math.max(GameValues.gvCore.CORE_CHECK_EVERY_X_TURNS, 1) != 0) return;
            if (GameValues.gvCore.CORE_POPULATION_PERC_THRESHOLD <= 0.0f) return;
            for (int p = 0; p < CFG.core.getProvinSize(); ++p) {
                Province prov = CFG.core.getProv(p);
                if (prov.getSeaProv() || prov.getWastelandLvl() >= 0) continue;
                Province_Core cores = prov.getCores();
                Province_Population pop = prov.getPop();
                if (cores == null || pop == null || pop.getPops() <= 0L) continue;
                int coresSize = cores.getCivsSize();
                if (coresSize <= 0) continue;
                for (int c = coresSize - 1; c >= 0; --c) {
                    int civID = cores.getCivID(c);
                    if (civID <= 0 || civID == prov.getCivId()) continue;
                    long civPop = pop.getPopulationOfCivID(civID);
                    long totalPop = pop.getPops();
                    float perc = totalPop > 0L ? (float)civPop / (float)totalPop : 0.0f;
                    if (perc >= GameValues.gvCore.CORE_POPULATION_PERC_THRESHOLD) continue;
                    prov.getClaims().addClaim(civID);
                    cores.removeCore(civID);
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void doAction_End() {
        long perfStart = System.currentTimeMillis();
        long perfMark = perfStart;
        try {
            tempTime = System.nanoTime();
            for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                CFG.core.getPlayer(i).setNoOrders(true);
            }
            CFG.gameAction.moveRegroupArmy();
            long perfNow = System.currentTimeMillis(); if (perfNow - perfMark > 50) { CFG.LOG("PERF", "[doAction_End] moveRegroupArmy: " + (perfNow - perfMark) + "ms"); } perfMark = perfNow;
            for (int civID = 1; civID < CFG.core.getCivsSize(); ++civID) {
                if (CFG.core.getCiv(civID).getUpdateRegions()) {
                    final int id = civID;
                    Core.addSimpleTask(new Core.SimpleTask("buildCivilizationRegions" + id, id){
                        @Override
                        public void update() {
                            try {
                                CFG.core.getCiv(this.id).setUpdateRegions(false);
                                CFG.core.buildCivilizationRegions(this.id);
                            }
                            catch (Exception exception) {}
                        }
                    });
                    Core.addSimpleTask(new Core.SimpleTask("buildNeighbors" + id, id){
                        @Override
                        public void update() {
                            try {
                                CFG.core.getCiv((int)this.id).civNeighbors.buildNeighbors(this.id);
                            }
                            catch (Exception exception) {}
                        }
                    });
                }
            }
            CFG.gameAction.updateIsSupplied();
            CFG.eventsManager.runEvents();
            ++GameCalendar.TURNS_SINCE_LAST_WAR;
            if (GameCalendar.TURNID % GameValues.gvUpdate.REBUILD_CIV_RANK_SCORES_EVERY_X_TURNS == 0) {
                CFG.gameAction.buildRank_Score();
            }
            CFG.historyManager.addNewTurn();
            CFG.timelapseManager.newTurn();
            CitiesManager.updateCities();
            CFG.core.updateSortedPIV = true;
            CFG.gameAction.checkGameEnd();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        finally {
            long perfEnd = System.currentTimeMillis();
            if (perfEnd - perfStart > 100) { CFG.LOG("PERF", "[doAction_End] TOTAL: " + (perfEnd - perfStart) + "ms"); }
            CFG.menus.getInGameProvInfo().getMenuElem(0).setClickable(true);
            CFG.gameAction.updateInGame_ProvinceInfo();
            Menu_InGame_2.TIME_CONTINUE = System.currentTimeMillis();
        }
    }

    public static void updateNukes() {
        try {
            Parallel.range(1, CFG.core.getCivsSize(), (int i) -> {
                Civilization civ = CFG.core.getCiv(i);
                if (civ == null || civ.civGD == null || civ.civGD.nukesConstruction.isEmpty()) return;
                for (int a = civ.civGD.nukesConstruction.size() - 1; a >= 0; --a) {
                    civ.civGD.nukesConstruction.set(a, civ.civGD.nukesConstruction.get(a) - 1);
                    if (civ.civGD.nukesConstruction.get(a) <= 0) {
                        civ.civGD.nukesConstruction.remove(a);
                        ++civ.civGD.iNukes;
                    }
                }
            });
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void updateMissiles() {
        if (!CFG.settingsGD.MISSILES) return;
        try {
            Parallel.range(1, CFG.core.getCivsSize(), (int i) -> {
                Civilization civ = CFG.core.getCiv(i);
                if (civ == null || civ.civGD == null) return;
                
                if (civ.civGD.iMissiles > 0) {
                    civ.setGold(civ.getGold() - (long)((float)civ.civGD.iMissiles * GameValues.gvMissiles.MISSILE_MAINTENANCE_COST));
                }

                if (civ.civGD.missilesConstruction != null && !civ.civGD.missilesConstruction.isEmpty()) {
                    for (int a = civ.civGD.missilesConstruction.size() - 1; a >= 0; --a) {
                        int stored = civ.civGD.missilesConstruction.get(a);
                        int base = stored >= 200 ? 200 : (stored >= 100 ? 100 : 0);
                        int turnCount = stored - base;
                        turnCount--;
                        if (turnCount <= 0) {
                            civ.civGD.missilesConstruction.remove(a);
                            if (base >= 200) {
                                ++civ.civGD.iMissiles_T3;
                            } else if (base >= 100) {
                                ++civ.civGD.iMissiles_T2;
                            } else {
                                ++civ.civGD.iMissiles;
                            }
                        } else {
                            civ.civGD.missilesConstruction.set(a, base + turnCount);
                        }
                    }
                }
                
                if (!civ.getIsPlayer() && GameCalendar.currYear >= GameValues.gvMissiles.MISSILE_MIN_YEAR) {
                    if (civ.civGD.iMissileResearchProgress < GameValues.gvMissiles.MISSILE_RESEARCH_COST) {
                         if (civ.getGold() > (long)(GameValues.gvMissiles.MISSILE_RESEARCH_COST * 2)) {
                             civ.setGold(civ.getGold() - 500L);
                             civ.civGD.iMissileResearchProgress += 500;
                         }
                    }
                }
            });
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void updateAirDefense() {
        if (!CFG.settingsGD.AIR_DEFENCE_SYSTEMS) return;
        try {
            Parallel.range(1, CFG.core.getCivsSize(), (int i) -> {
                Civilization civ = CFG.core.getCiv(i);
                long maintenance = 0;
                for (int a = 0; a < civ.getNumOfProvs(); a++) {
                    Province p = CFG.core.getProv(civ.getProvID(a));
                    if (p.provGD.iAirDefense > 0) {
                        maintenance += (long)p.provGD.iAirDefense * (long)GameValues.gvAirDefense.AIR_DEFENSE_MAINTENANCE;
                    }
                }
                if (maintenance > 0) {
                    civ.setGold(civ.getGold() - maintenance);
                }
            });
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static int getUpdateGameData_PopulationGrowth(int civID) {
        int out = 0;
        try {
            float civGoodsUpdate = NewTurn.getGoodsUpdate(civID);
            float modifiedStartingPop = (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * GameValues.gvEconomy.POPULATION_GROWTH_STARTING_POPULATION_MODIFIER;
            for (int i = 0; i < CFG.core.getCiv(civID).getNumOfProvs(); ++i) {
                Province province = CFG.core.getProv(CFG.core.getCiv(civID).getProvID(i));
                float tempPopGrowth = (float)province.getPop().getPops() * (GameValues.gvPopulationGrowth.POP_GROWTH_BASE_VALUE + (CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(province.getCivId()).getIdeology()).getMin_Goods(province.getCivId()) < CFG.core.getCiv(province.getCivId()).getSpendingGoodsB() ? (float)CFG.oR.nextInt(GameValues.gvPopulationGrowth.POP_GROWTH_BASE_VALUE_GOODS_SPENDING_BELOW_RANDOM_100_MAX) / 100.0f : GameValues.gvPopulationGrowth.POP_GROWTH_BASE_VALUE_GOODS_SPENDING_OVER)) * civGoodsUpdate * ((GameValues.gvPopulationGrowth.POP_GROWTH_PROVINCE_GROWTH_RATE_BASE + province.getGrowthRate_Pop_WithFarm_WithTerrain() + CFG.core.getCiv(province.getCivId()).getModifier_PopGrowth()) * GameValues.gvPopulationGrowth.POP_GROWTH_PROVINCE_GROWTH_RATE_MODIFIER) * (1.0f + province.getDeveLvl() * GameValues.gvPopulationGrowth.POP_GROWTH_PROVINCE_DEVELOPMENT_MODIFIER + CFG.core.getGameScenars().getScenario_PopulationGrowthRate_Modifier()) * GameCalendar.GAME_SPEED;
                if (tempPopGrowth > 0.0f) {
                    if ((float)province.getPop().getPops() < modifiedStartingPop * province.getGrowthRate_Pop()) {
                        tempPopGrowth += (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvPopulationGrowth.POP_GROWTH_LOW_POPULATION_BONUS_BASE * (1.0f - (float)province.getPop().getPops() / (float)CFG.core.getGameScenars().getScenario_StartingPopulation())) * province.getGrowthRate_Pop() * Math.min(province.getDeveLvl() * GameValues.gvPopulationGrowth.POP_GROWTH_LOW_POPULATION_BONUS_DEVELOPMENT_MODIFIER, GameValues.gvPopulationGrowth.POP_GROWTH_LOW_POPULATION_BONUS_DEVELOPMENT_MODIFIER_LIMIT);
                    }
                    if ((tempPopGrowth = 1.0f + tempPopGrowth * Math.max(GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_STARTING_POPULATION_MIN, 1.0f - 0.4f * (float)province.getPop().getPops() / ((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_STARTING_POPULATION_MODIFIER))) > 0.0f) {
                        tempPopGrowth = tempPopGrowth * GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_FINAL_BASE_PERC + (float)CFG.oR.nextInt(Math.max((int)(tempPopGrowth * GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_FINAL_RANDOM_POSITIVE_PERC * 100.0f), GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_FINAL_RANDOM_POSITIVE_MIN_VALUE)) / 100.0f - (float)CFG.oR.nextInt(Math.max((int)(tempPopGrowth * GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_FINAL_RANDOM_NEGATIVE_PERC * 100.0f), 1)) / 100.0f;
                    }
                }
                if ((tempPopGrowth *= CFG.POPULATION_GROWTH_RATE) > (float)GameValues.gvPopulationGrowth.POP_GROWTH_LIMIT_PER_TURN) {
                    tempPopGrowth = GameValues.gvPopulationGrowth.POP_GROWTH_LIMIT_PER_TURN;
                }
                out += (int)tempPopGrowth;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return out;
    }

    public static int getUpdateGameData_PopulationGrowth_WithoutRandom(int civID) {
        int out = 0;
        try {
            float civGoodsUpdate = NewTurn.getGoodsUpdate(civID);
            float modifiedStartingPop = (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * GameValues.gvEconomy.POPULATION_GROWTH_STARTING_POPULATION_MODIFIER;
            float randomModifier = GameValues.gvPopulationGrowth.POP_GROWTH_BUDGET_TEXT_RANDOM_MODIFIER;
            for (int i = 0; i < CFG.core.getCiv(civID).getNumOfProvs(); ++i) {
                Province province = CFG.core.getProv(CFG.core.getCiv(civID).getProvID(i));
                float tempPopGrowth = (float)province.getPop().getPops() * (GameValues.gvPopulationGrowth.POP_GROWTH_BASE_VALUE + (CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(province.getCivId()).getIdeology()).getMin_Goods(province.getCivId()) < CFG.core.getCiv(province.getCivId()).getSpendingGoodsB() ? (float)GameValues.gvPopulationGrowth.POP_GROWTH_BASE_VALUE_GOODS_SPENDING_BELOW_RANDOM_100_MAX * randomModifier / 100.0f : GameValues.gvPopulationGrowth.POP_GROWTH_BASE_VALUE_GOODS_SPENDING_OVER)) * civGoodsUpdate * ((GameValues.gvPopulationGrowth.POP_GROWTH_PROVINCE_GROWTH_RATE_BASE + province.getGrowthRate_Pop_WithFarm_WithTerrain() + CFG.core.getCiv(province.getCivId()).getModifier_PopGrowth()) * GameValues.gvPopulationGrowth.POP_GROWTH_PROVINCE_GROWTH_RATE_MODIFIER) * (1.0f + province.getDeveLvl() * GameValues.gvPopulationGrowth.POP_GROWTH_PROVINCE_DEVELOPMENT_MODIFIER + CFG.core.getGameScenars().getScenario_PopulationGrowthRate_Modifier()) * GameCalendar.GAME_SPEED;
                if (tempPopGrowth > 0.0f) {
                    if ((float)province.getPop().getPops() < modifiedStartingPop * province.getGrowthRate_Pop()) {
                        tempPopGrowth += (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvPopulationGrowth.POP_GROWTH_LOW_POPULATION_BONUS_BASE * (1.0f - (float)province.getPop().getPops() / (float)CFG.core.getGameScenars().getScenario_StartingPopulation())) * province.getGrowthRate_Pop() * Math.min(province.getDeveLvl() * GameValues.gvPopulationGrowth.POP_GROWTH_LOW_POPULATION_BONUS_DEVELOPMENT_MODIFIER, GameValues.gvPopulationGrowth.POP_GROWTH_LOW_POPULATION_BONUS_DEVELOPMENT_MODIFIER_LIMIT);
                    }
                    if ((tempPopGrowth = 1.0f + tempPopGrowth * Math.max(GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_STARTING_POPULATION_MIN, 1.0f - 0.4f * (float)province.getPop().getPops() / ((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_STARTING_POPULATION_MODIFIER))) > 0.0f) {
                        tempPopGrowth = tempPopGrowth * GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_FINAL_BASE_PERC + (float)Math.max((int)(tempPopGrowth * GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_FINAL_RANDOM_POSITIVE_PERC * 100.0f), GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_FINAL_RANDOM_POSITIVE_MIN_VALUE) * randomModifier / 100.0f - (float)Math.max((int)(tempPopGrowth * GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_FINAL_RANDOM_NEGATIVE_PERC * 100.0f), 1) * randomModifier / 100.0f;
                    }
                }
                if ((tempPopGrowth *= CFG.POPULATION_GROWTH_RATE) > (float)GameValues.gvPopulationGrowth.POP_GROWTH_LIMIT_PER_TURN) {
                    tempPopGrowth = GameValues.gvPopulationGrowth.POP_GROWTH_LIMIT_PER_TURN;
                }
                out += (int)tempPopGrowth;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return out;
    }

    public static int getUpdateGameData_EconomyGrowth_WithoutRandom(int civID) {
        int out = 0;
        try {
            float civInvestsUpdate = NewTurn.getInvestUpdate(civID);
            float modifiedStartingEco = (float)CFG.core.getGameScenars().getScenario_StartingEconomy() * GameValues.gvEconomy.ECONOMY_GROWTH_STARTING_ECONOMY_MODIFIER;
            float randomModifier = GameValues.gvEconomy.ECO_GROWTH_BUDGET_TEXT_RANDOM_MODIFIER;
            for (int i = 0; i < CFG.core.getCiv(civID).getNumOfProvs(); ++i) {
                float tempEco;
                Province province = CFG.core.getProv(CFG.core.getCiv(civID).getProvID(i));
                float tempEcoPop = 0.0f;
                if (CFG.core.getCiv(province.getCivId()).getSpendingGoodsB() < CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(province.getCivId()).getIdeology()).getMin_Goods(province.getCivId())) {
                    tempEcoPop = (float)province.getEco() * GameValues.gvGoods.GOODS_BELOW_MIN_ECONOMY_BASE_MODIFIER * ((CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(province.getCivId()).getIdeology()).getMin_Goods(province.getCivId()) - CFG.core.getCiv(province.getCivId()).getSpendingGoodsB()) / CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(province.getCivId()).getIdeology()).getMin_Goods(province.getCivId())) * (GameValues.gvGoods.GOODS_BELOW_MIN_ECONOMY_BASE_DEV_POP_GROWTH_MODIFIER + province.getDeveLvl() * GameValues.gvGoods.GOODS_BELOW_MIN_ECONOMY_PROVINCE_DEVELOPMENT_MODIFIER + province.getGrowthRate_Pop_WithFarm_WithTerrain() * GameValues.gvGoods.GOODS_BELOW_MIN_ECONOMY_PROVINCE_GROWTH_RATE_MODIFIER);
                }
                if ((tempEco = Math.max((float)province.getEco(), (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * GameValues.gvEconomyGrowth.ECO_GROWTH_STARTING_POPULATION_MODIFIER * province.getGrowthRate_Pop()) * civInvestsUpdate * (GameValues.gvEconomyGrowth.ECO_GROWTH_BASE_VALUE + GameValues.gvEconomyGrowth.ECO_GROWTH_PROV_DEVELOPMENT_PERC_OF_TECH_MODIFIER * (province.getDeveLvl() / CFG.core.getCiv(province.getCivId()).getTechLevel()) + province.getGrowthRate_Pop_WithFarm_WithTerrain() * GameValues.gvEconomyGrowth.ECO_GROWTH_PROV_GROWTH_RATE_MODIFIER) * (1.0f + CFG.core.getCiv(province.getCivId()).getModifier_EconomyGrowth() + CFG.core.getGameScenars().getScenario_EconomyGrowthRate_Modifier()) * GameCalendar.GAME_SPEED) > 0.0f) {
                    if ((float)province.getEco() < modifiedStartingEco * province.getGrowthRate_Pop()) {
                        tempEco += (float)CFG.core.getGameScenars().getScenario_StartingEconomy() * (GameValues.gvEconomyGrowth.ECO_GROWTH_LOW_ECONOMY_BONUS_BASE * (1.0f - (float)province.getPop().getPops() / (float)CFG.core.getGameScenars().getScenario_StartingEconomy())) * province.getGrowthRate_Pop_WithFarm_WithTerrain() * GameValues.gvEconomyGrowth.ECO_GROWTH_LOW_ECONOMY_BONUS_PROV_GROWTH_RATE_MODIFIER * Math.min(province.getDeveLvl() * GameValues.gvEconomyGrowth.ECO_GROWTH_LOW_ECONOMY_BONUS_PROV_DEVELOPMENT_MODIFIER, 1.0f);
                    }
                    if ((tempEco *= Math.max(GameValues.gvEconomyGrowth.ECO_GROWTH_MODIFIER_STARTING_ECONOMY_MIN, 1.0f - GameValues.gvEconomy.ECO_GROWTH_SATURATION_STRENGTH * (float)province.getEco() / ((float)CFG.core.getGameScenars().getScenario_StartingEconomy() * GameValues.gvEconomyGrowth.ECO_GROWTH_MODIFIER_STARTING_ECONOMY_MODIFIER))) > 0.0f) {
                        tempEco = tempEco * GameValues.gvEconomyGrowth.ECO_GROWTH_MODIFIER_FINAL_BASE_PERC + randomModifier * (float)Math.max((int)(tempEco * GameValues.gvEconomyGrowth.ECO_GROWTH_MODIFIER_FINAL_RANDOM_POSITIVE_PERC * 100.0f), GameValues.gvEconomyGrowth.ECO_GROWTH_MODIFIER_FINAL_RANDOM_POSITIVE_MIN_VALUE) / 100.0f - randomModifier * (float)Math.max((int)(tempEco * GameValues.gvEconomyGrowth.ECO_GROWTH_MODIFIER_FINAL_RANDOM_NEGATIVE_PERC * 100.0f), 1) / 100.0f;
                    }
                }
                tempEco = CFG.core.getCiv(civID).getSpendingInvestmentsB() < CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(civID).getIdeology(), civID) ? (tempEco *= CFG.ECONOMY_GROWTH_RATE) : Math.max((float)GameValues.gvEconomy.MIN_ECONOMY_CHANCE, tempEco * CFG.ECONOMY_GROWTH_RATE);
                out += (int)tempEcoPop + (int)tempEco;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return out;
    }

    public static float getGoodsUpdate(int civID) {
        return CFG.core.getCiv(civID).getSpendingGoodsB() < CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(civID).getIdeology()).getMin_Goods(civID) ? GameValues.gvEconomy.GOODS_UNDER_MIN_PENALTY * ((CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(civID).getIdeology()).getMin_Goods(civID) - CFG.core.getCiv(civID).getSpendingGoodsB()) / CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(civID).getIdeology()).getMin_Goods(civID)) : (-CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(civID).getIdeology()).getMin_Goods(civID) + GameValues.gvEconomy.GOODS_OVER_MIN_BASE + CFG.core.getCiv(civID).getSpendingGoodsB()) * CFG.gameAges.getAge_Population_GrowthRate(GameCalendar.CURRENT_AGEID);
    }

    public static float getInvestUpdate(int civID) {
        return CFG.core.getCiv(civID).getSpendingInvestmentsB() < CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(civID).getIdeology(), civID) ? GameValues.gvEconomy.INVEST_UNDER_MIN_ECO_PENALTY * ((CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(civID).getIdeology(), civID) - CFG.core.getCiv(civID).getSpendingInvestmentsB()) / CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)civID).getIdeology()).MIN_INVESTMENTS) : (-CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(civID).getIdeology(), civID) + GameValues.gvEconomy.INVEST_OVER_MIN_ECO_BASE + CFG.core.getCiv(civID).getSpendingInvestmentsB() * GameValues.gvEconomy.INVEST_OVER_INVESTMENTS_MODIFIER) * CFG.gameAges.getAge_Economy_GrowthRate(GameCalendar.CURRENT_AGEID);
    }

    public static final void updateGameData() {
        if (happinessChange_ByTaxation == null || happinessChange_ByTaxation.size() != CFG.core.getCivsSize()) {
            happinessChange_ByTaxation = new ArrayList<Float>(CFG.core.getCivsSize());
            happinessChange_ByTaxation_Occupied = new ArrayList<Float>(CFG.core.getCivsSize());
            goodsUpdate = new ArrayList<Float>(CFG.core.getCivsSize());
            devUpdate = new ArrayList<Float>(CFG.core.getCivsSize());
            ecoUpdate = new ArrayList<Float>(CFG.core.getCivsSize());
            for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
                happinessChange_ByTaxation.add(1.0f);
                happinessChange_ByTaxation_Occupied.add(1.0f);
                goodsUpdate.add(1.0f);
                devUpdate.add(1.0f);
                ecoUpdate.add(1.0f);
            }
        }
        
        ageRiskModifier = CFG.gameAges.getAge_RevolutionaryRiskModifier(GameCalendar.CURRENT_AGEID);
        ageDevMod = CFG.gameAges.getAge_DevelopmentLevel_Increase(GameCalendar.CURRENT_AGEID);

        for (int i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
            Civilization civ = CFG.core.getCiv(i2);
            if (civ != null && civ.getNumOfProvs() > 0) {
                happinessChange_ByTaxation.set(i2, CFG.gameUpdate.getHappinessChange_ByTaxation(i2));
                happinessChange_ByTaxation_Occupied.set(i2, CFG.gameUpdate.getHappinessChange_ByTaxation_Occupied(i2));
                goodsUpdate.set(i2, NewTurn.getGoodsUpdate(i2));
                devUpdate.set(i2, civ.getSpendingInvestmentsB() < CFG.ideologiesMgr.getInvestments(civ.getIdeology(), i2) ? GameValues.gvEconomy.INVEST_UNDER_MIN_DEV_PENALTY * ((CFG.ideologiesMgr.getInvestments(civ.getIdeology(), i2) - civ.getSpendingInvestmentsB()) / (float)CFG.ideologiesMgr.getIdeologyID((int)civ.getIdeology()).MIN_INVESTMENTS) : -CFG.ideologiesMgr.getInvestments(civ.getIdeology(), i2) + GameValues.gvEconomy.INVEST_OVER_MIN_DEV_BASE + civ.getSpendingInvestmentsB());
                ecoUpdate.set(i2, NewTurn.getInvestUpdate(i2));
                civ.civGD.civAggressionLevel = Math.max(0.0f, civ.civGD.civAggressionLevel - GameValues.gvDiplomacy.CIV_AGGRESSION_DECAY_PER_TURN);
            }
        }

        NewTurn.updateNukes();
        NewTurn.updateMissiles();
        float modifiedStartingPop = (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * GameValues.gvEconomy.POPULATION_GROWTH_STARTING_POPULATION_MODIFIER;
        float modifiedStartingEco = (float)CFG.core.getGameScenars().getScenario_StartingEconomy() * GameValues.gvEconomy.ECONOMY_GROWTH_STARTING_ECONOMY_MODIFIER;
        float scenarioStartingPopulation = (float)CFG.core.getGameScenars().getScenario_StartingPopulation();
        float scenarioPopulationGrowthRateModifier = CFG.core.getGameScenars().getScenario_PopulationGrowthRate_Modifier();
        
        final float fModifiedStartingPop = modifiedStartingPop;
        final float fModifiedStartingEco = modifiedStartingEco;
        final float fScenarioStartingPopulation = scenarioStartingPopulation;
        final float fScenarioPopulationGrowthRateModifier = scenarioPopulationGrowthRateModifier;
        
        Parallel.range(CFG.core.getProvinSize(), (int provIndex) -> {
            Province province = CFG.core.getProv(provIndex);
            if (province == null || province.getSeaProv() || province.getWastelandLvl() >= 0 || province.getCivId() <= 0) return;
            
            int civId = province.getCivId();
            Civilization provinceCiv = CFG.core.getCiv(civId);
            Province_Population pop = province.getPop();
            
            ThreadLocalRandom rand = ThreadLocalRandom.current();
            float goodsUpd = goodsUpdate.get(civId);
            float tempPopGrowth = (float)pop.getPops() * (GameValues.gvPopulationGrowth.POP_GROWTH_BASE_VALUE + (CFG.ideologiesMgr.getIdeologyID(provinceCiv.getIdeology()).getMin_Goods(civId) < provinceCiv.getSpendingGoodsB() ? (float)rand.nextInt(GameValues.gvPopulationGrowth.POP_GROWTH_BASE_VALUE_GOODS_SPENDING_BELOW_RANDOM_100_MAX) / 100.0f : GameValues.gvPopulationGrowth.POP_GROWTH_BASE_VALUE_GOODS_SPENDING_OVER)) * goodsUpd * ((GameValues.gvPopulationGrowth.POP_GROWTH_PROVINCE_GROWTH_RATE_BASE + province.getGrowthRate_Pop_WithFarm_WithTerrain() + provinceCiv.getModifier_PopGrowth()) * GameValues.gvPopulationGrowth.POP_GROWTH_PROVINCE_GROWTH_RATE_MODIFIER) * (1.0f + province.getDeveLvl() * GameValues.gvPopulationGrowth.POP_GROWTH_PROVINCE_DEVELOPMENT_MODIFIER + fScenarioPopulationGrowthRateModifier) * GameCalendar.GAME_SPEED;
            
            if (tempPopGrowth > 0.0f) {
                if ((float)pop.getPops() < fModifiedStartingPop * province.getGrowthRate_Pop()) {
                    tempPopGrowth += fScenarioStartingPopulation * (GameValues.gvPopulationGrowth.POP_GROWTH_LOW_POPULATION_BONUS_BASE * (1.0f - (float)pop.getPops() / fScenarioStartingPopulation)) * province.getGrowthRate_Pop() * Math.min(province.getDeveLvl() * GameValues.gvPopulationGrowth.POP_GROWTH_LOW_POPULATION_BONUS_DEVELOPMENT_MODIFIER, GameValues.gvPopulationGrowth.POP_GROWTH_LOW_POPULATION_BONUS_DEVELOPMENT_MODIFIER_LIMIT);
                }
                tempPopGrowth = 1.0f + tempPopGrowth * Math.max(GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_STARTING_POPULATION_MIN, 1.0f - 0.4f * (float)pop.getPops() / (fScenarioStartingPopulation * GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_STARTING_POPULATION_MODIFIER));
                if (tempPopGrowth > 0.0f) {
                    tempPopGrowth = tempPopGrowth * GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_FINAL_BASE_PERC + (float)rand.nextInt(Math.max((int)(tempPopGrowth * GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_FINAL_RANDOM_POSITIVE_PERC * 100.0f), GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_FINAL_RANDOM_POSITIVE_MIN_VALUE)) / 100.0f - (float)rand.nextInt(Math.max((int)(tempPopGrowth * GameValues.gvPopulationGrowth.POP_GROWTH_MODIFIER_FINAL_RANDOM_NEGATIVE_PERC * 100.0f), 1)) / 100.0f;
                }
            }
            
            tempPopGrowth *= CFG.POPULATION_GROWTH_RATE;
            if (tempPopGrowth > (float)GameValues.gvPopulationGrowth.POP_GROWTH_LIMIT_PER_TURN * CFG.POPULATION_GROWTH_RATE) {
                tempPopGrowth = (float)GameValues.gvPopulationGrowth.POP_GROWTH_LIMIT_PER_TURN * CFG.POPULATION_GROWTH_RATE;
            }
            
            if ((int)tempPopGrowth != 0) {
                if (tempPopGrowth > -20.0f && tempPopGrowth < 60.0f) {
                    pop.setPopulationOfCivID(civId, pop.getPopulationOfCivID(civId) + (int)tempPopGrowth);
                } else {
                    ArrayList<PopulationGrowth> localTempCivs = threadLocalPopGrowth.get();
                    localTempCivs.clear();
                    localTempCivs.add(new PopulationGrowth(civId, GameValues.gvPopulationGrowth.POP_GROWTH_NATIONALITY_OWNER_X_STABILITY * province.getProviStability()));
                    if (civId != provinceCiv.getPuppetOfCiv()) {
                        localTempCivs.add(new PopulationGrowth(provinceCiv.getPuppetOfCiv(), GameValues.gvPopulationGrowth.POP_GROWTH_NATIONALITY_LORD));
                    }
                    if (province.isOccupied()) {
                        localTempCivs.add(new PopulationGrowth(province.getTrueOwnerOfProv(), GameValues.gvPopulationGrowth.POP_GROWTH_NATIONALITY_TRUE_OWNER));
                    }
                    for (int j3 = 0; j3 < province.getCores().getCivsSize(); ++j3) {
                        localTempCivs.add(new PopulationGrowth(province.getCores().getCivID(j3), GameValues.gvPopulationGrowth.POP_GROWTH_NATIONALITY_CORE_CIV));
                    }
                    int tempPop = (int)pop.getPops();
                    for (int j2 = 0; j2 < pop.getNatsSize(); ++j2) {
                        localTempCivs.add(new PopulationGrowth(pop.getCivID(j2), (float)pop.getPopulationID(j2) / (float)tempPop * 100.0f));
                    }
                    for (int j2 = 0; j2 < province.getNeighProvincesSize(); ++j2) {
                        int neighborCivId = CFG.core.getProv(province.getNeighProvinces(j2)).getCivId();
                        if (neighborCivId <= 0) continue;
                        localTempCivs.add(new PopulationGrowth(neighborCivId, GameValues.gvPopulationGrowth.POP_GROWTH_NATIONALITY_NEIGHBORING_PROVINCE_CIV));
                    }
                    float tempTotalPoints = 0.0f;
                    for (int j = localTempCivs.size() - 1; j >= 0; --j) {
                        tempTotalPoints += localTempCivs.get(j).fPerc;
                    }
                    if (tempTotalPoints > 0) {
                        for (int j = localTempCivs.size() - 1; j >= 0; --j) {
                            localTempCivs.get(j).fPerc /= tempTotalPoints;
                            pop.setPopulationOfCivID(localTempCivs.get(j).iCivID, pop.getPopulationOfCivID(localTempCivs.get(j).iCivID) + (int)(tempPopGrowth * localTempCivs.get(j).fPerc));
                        }
                    }
                }
            }
            NewTurn.updateGameData_Province(provIndex, fModifiedStartingEco);
        });
        
        if (GameCalendar.TURNID % GameValues.gvUpdate.UPDATE_NEUTRAL_ARMY == 0) {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                Province p = CFG.core.getProv(i);
                if (!p.getSeaProv() && p.getWastelandLvl() < 0 && p.getCivId() == 0 && ThreadLocalRandom.current().nextInt(100) > GameValues.gvProvince.NEUTRAL_ARMY_UPDATE_CHANCE_100) {
                    p.updateArmy4(0, p.getArmyCivID1(0) + (GameValues.gvProvince.NEUTRAL_ARMY_UPDATE_BASE + ThreadLocalRandom.current().nextInt(GameValues.gvProvince.NEUTRAL_ARMY_UPDATE_RANDOM)) * GameCalendar.TURNID % GameValues.gvUpdate.UPDATE_NEUTRAL_ARMY);
                }
            }
        }
    }

    public static void updateGameData_Province(int iProvinceID, float modifiedStartingEco) {
        float tempEco;
        Province province = CFG.core.getProv(iProvinceID);
        int civId = province.getCivId();
        Civilization provinceCiv = CFG.core.getCiv(civId);
        int ideologyId = provinceCiv.getIdeology();
        Ideology ideology = CFG.ideologiesMgr.getIdeologyID(ideologyId);
        int trueOwner = province.getTrueOwnerOfProv();
        
        if (trueOwner == civId && !ideology.REVOLUTIONARY) {
            province.getCores().increaseOwnership(civId, iProvinceID);
            int puppetOfCiv = provinceCiv.getPuppetOfCiv();
            if (puppetOfCiv != civId) {
                province.getCores().increaseOwnership(puppetOfCiv, iProvinceID);
            }
        }
        if (province.getDeveLvl() < 1.0f) {
            if (civId == trueOwner) {
                float tempDevelopmentChange = ageDevMod * devUpdate.get(civId - 1).floatValue() * Math.min(province.getGrowthRate_Pop_WithFarm_WithTerrain() * GameValues.gvDevelopment.DEV_CHANGE_PROVINCE_GROWTH_RATE_MODIFIER, GameValues.gvDevelopment.DEV_CHANGE_MODIFIER_LIMIT);
                province.setDevLvl(province.getDeveLvl() + tempDevelopmentChange);
            } else {
                province.setDevLvl(province.getDeveLvl() - (float)CFG.oR.nextInt(GameValues.gvDevelopment.DEV_CHANGE_OCCUPIED_RANDOM) / GameValues.gvDevelopment.DEV_CHANGE_OCCUPIED_RANDOM_DIVIDE);
            }
        }
        float spendingGoodsB = provinceCiv.getSpendingGoodsB();
        float minGoods = ideology.getMin_Goods(civId);
        if (spendingGoodsB < minGoods) {
            float tempHapp = GameValues.gvGoods.GOODS_BELOW_MIN_HAPPINESS_BASE_MODIFIER * ((minGoods - spendingGoodsB) / minGoods) * (GameValues.gvGoods.GOODS_BELOW_MIN_HAPPINESS_BASE_DEV_POP_GROWTH_MODIFIER + province.getDeveLvl() * GameValues.gvGoods.GOODS_BELOW_MIN_HAPPINESS_PROVINCE_DEVELOPMENT_MODIFIER + province.getGrowthRate_Pop_WithFarm() * GameValues.gvGoods.GOODS_BELOW_MIN_HAPPINESS_PROVINCE_GROWTH_RATE_MODIFIER);
            if (tempHapp > 0.0f) {
                tempHapp *= 1.0f + GameValues.gvGoods.GOODS_BELOW_MIN_HAPPINESS_WAR_WEARiNESS_MODIFIER * provinceCiv.civGD.warWeariness;
            }
            province.setHappi(province.getHappi() + tempHapp);
            float tempEcoPop = (float)province.getEco() * GameValues.gvGoods.GOODS_BELOW_MIN_ECONOMY_BASE_MODIFIER * ((minGoods - spendingGoodsB) / minGoods) * (GameValues.gvGoods.GOODS_BELOW_MIN_ECONOMY_BASE_DEV_POP_GROWTH_MODIFIER + province.getDeveLvl() * GameValues.gvGoods.GOODS_BELOW_MIN_ECONOMY_PROVINCE_DEVELOPMENT_MODIFIER + province.getGrowthRate_Pop_WithFarm_WithTerrain() * GameValues.gvGoods.GOODS_BELOW_MIN_ECONOMY_PROVINCE_GROWTH_RATE_MODIFIER);
            province.setEco((int)((float)province.getEco() + tempEcoPop));
        }
        if ((tempEco = Math.max((float)province.getEco(), (float)CFG.core.getGameScenars().getScenario_StartingPopulation() * GameValues.gvEconomyGrowth.ECO_GROWTH_STARTING_POPULATION_MODIFIER * province.getGrowthRate_Pop()) * ecoUpdate.get(civId - 1).floatValue() * (GameValues.gvEconomyGrowth.ECO_GROWTH_BASE_VALUE + GameValues.gvEconomyGrowth.ECO_GROWTH_PROV_DEVELOPMENT_PERC_OF_TECH_MODIFIER * (province.getDeveLvl() / provinceCiv.getTechLevel()) + province.getGrowthRate_Pop_WithFarm_WithTerrain() * GameValues.gvEconomyGrowth.ECO_GROWTH_PROV_GROWTH_RATE_MODIFIER) * (1.0f + provinceCiv.getModifier_EconomyGrowth() + CFG.core.getGameScenars().getScenario_EconomyGrowthRate_Modifier()) * GameCalendar.GAME_SPEED) > 0.0f) {
            if ((float)province.getEco() < modifiedStartingEco * province.getGrowthRate_Pop()) {
                tempEco += (float)CFG.core.getGameScenars().getScenario_StartingEconomy() * (GameValues.gvEconomyGrowth.ECO_GROWTH_LOW_ECONOMY_BONUS_BASE * (1.0f - (float)province.getPop().getPops() / (float)CFG.core.getGameScenars().getScenario_StartingEconomy())) * province.getGrowthRate_Pop_WithFarm_WithTerrain() * GameValues.gvEconomyGrowth.ECO_GROWTH_LOW_ECONOMY_BONUS_PROV_GROWTH_RATE_MODIFIER * Math.min(province.getDeveLvl() * GameValues.gvEconomyGrowth.ECO_GROWTH_LOW_ECONOMY_BONUS_PROV_DEVELOPMENT_MODIFIER, 1.0f);
            }
            if ((tempEco *= Math.max(GameValues.gvEconomyGrowth.ECO_GROWTH_MODIFIER_STARTING_ECONOMY_MIN, 1.0f - GameValues.gvEconomy.ECO_GROWTH_SATURATION_STRENGTH * (float)province.getEco() / ((float)CFG.core.getGameScenars().getScenario_StartingEconomy() * GameValues.gvEconomyGrowth.ECO_GROWTH_MODIFIER_STARTING_ECONOMY_MODIFIER))) > 0.0f) {
                tempEco = tempEco * GameValues.gvEconomyGrowth.ECO_GROWTH_MODIFIER_FINAL_BASE_PERC + (float)CFG.oR.nextInt(Math.max((int)(tempEco * GameValues.gvEconomyGrowth.ECO_GROWTH_MODIFIER_FINAL_RANDOM_POSITIVE_PERC * 100.0f), GameValues.gvEconomyGrowth.ECO_GROWTH_MODIFIER_FINAL_RANDOM_POSITIVE_MIN_VALUE)) / 100.0f - (float)CFG.oR.nextInt(Math.max((int)(tempEco * GameValues.gvEconomyGrowth.ECO_GROWTH_MODIFIER_FINAL_RANDOM_NEGATIVE_PERC * 100.0f), 1)) / 100.0f;
            }
        }
        float spendingInvestmentsB = provinceCiv.getSpendingInvestmentsB();
        float minInvestments = CFG.ideologiesMgr.getInvestments(ideologyId, civId);
        tempEco = spendingInvestmentsB < minInvestments ? (tempEco *= CFG.ECONOMY_GROWTH_RATE) : Math.max((float)GameValues.gvEconomy.MIN_ECONOMY_CHANCE, tempEco * CFG.ECONOMY_GROWTH_RATE);
        province.setEco((int)((float)province.getEco() + tempEco));
        if (civId == trueOwner) {
            float taxHappiness = happinessChange_ByTaxation.get(civId).floatValue();
            if (taxHappiness > 0.0f) {
                province.setHappi(province.getHappi() + (float)ThreadLocalRandom.current().nextInt((int)(Math.max(taxHappiness, 0.001f) * 1000.0f)) / 100000.0f);
            } else {
                province.setHappi(province.getHappi() + (taxHappiness + taxHappiness * (GameValues.gvHappiness.HAPPINESS_TAXATION_STABILITY_MODIFIER - GameValues.gvHappiness.HAPPINESS_TAXATION_STABILITY_MODIFIER * province.getProviStability())) / 100.0f);
            }
        } else {
            float taxHappyOcc = happinessChange_ByTaxation_Occupied.get(civId).floatValue();
            if (taxHappyOcc > 0.0f) {
                province.setHappi(province.getHappi() + (float)ThreadLocalRandom.current().nextInt(Math.max(1, (int)(taxHappyOcc * 100.0f))) / 10000.0f);
            } else {
                province.setHappi(province.getHappi() + taxHappyOcc / 100.0f);
            }
        }
        if (ideology.REVOLUTIONARY) {
            province.setRevRisk(0.0f);
        } else {
            float fRisk = province.getRevRisk();
            if (fRisk > GameValues.gvRevolutionaryRisk.REVOLT_RISK_DECAY_THRESHOLD) {
                fRisk -= Math.min(fRisk / GameValues.gvRevolutionaryRisk.REVOLT_RISK_DECAY_DIVISOR, GameValues.gvRevolutionaryRisk.REVOLT_RISK_DECAY_MAX) * (1.0f - provinceCiv.getWarWeariness());
            }
            if (province.getHappi() < GameValues.gvRebels.RISE_REVOLT_RISK_IN_PROVINCE_IF_HAPPINESS_BELOW) {
                float nModifier = provinceCiv.getGold() < (long)GameValues.gvRevolutionaryRisk.REVOLT_RISK_BANKRUPTCY_THRESHOLD ? 1.0f : Math.min(GameValues.gvRevolutionaryRisk.REVOLT_RISK_TAXATION_BASE + provinceCiv.getTaxationLvl() / CFG.ideologiesMgr.getAcceptableTaxation(ideologyId, civId), 1.0f);
                float riskBoost = 1.0f;
                if (fRisk > 1.0f) {
                    riskBoost = fRisk * 2.0f;
                }
                fRisk += riskBoost * nModifier * ageRiskModifier * (GameValues.gvRebels.RISE_REVOLT_RISK_IN_PROVINCE_IF_HAPPINESS_BELOW - province.getHappi()) / GameValues.gvRevolutionaryRisk.REVOLT_RISK_HAPPINESS_DIVISOR;
            }
            province.setRevRisk(fRisk);
        }
        province.runSupportRebels();
        province.updateNewColony();
    }

    public static void updateDiplomacy() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            Civilization civI = CFG.core.getCiv(i);
            if (civI == null || (civI.getNumOfProvs() <= 0 && civI.defensivePact.isEmpty() && civI.nonAggressionPact.isEmpty() && civI.guarantee.isEmpty() && civI.militaryAccess.isEmpty() && civI.truce.isEmpty())) continue;
            
            Civilization.DiplomacyData tData;
            Iterator<Map.Entry<Integer, Civilization.DiplomacyData>> it;
            try {
                if (!civI.defensivePact.isEmpty()) {
                    it = civI.defensivePact.entrySet().iterator();
                    while (it.hasNext()) {
                        tData = it.next().getValue();
                        civI.setDiploPoints(civI.getDiploPoints() - GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_DEFENSIVE_PACT);
                        Civilization other = CFG.core.getCiv(tData.iCivID);
                        other.setDiploPoints(other.getDiploPoints() - GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_DEFENSIVE_PACT);
                        if (tData.iTurnID == 1 && civI.getNumOfProvs() > 0 && other.getNumOfProvs() > 0) {
                            civI.getCivDiploGD().messageBox.addMessage(new Message_DefensivePact_Expired(tData.iCivID));
                            other.getCivDiploGD().messageBox.addMessage(new Message_DefensivePact_Expired(i));
                        }
                        civI.setDefensivePact4(tData.iCivID, tData.iTurnID - 1);
                        if (tData.iTurnID == 1) it.remove();
                    }
                }
            } catch (Exception ex) {}
            try {
                if (!civI.nonAggressionPact.isEmpty()) {
                    it = civI.nonAggressionPact.entrySet().iterator();
                    while (it.hasNext()) {
                        tData = it.next().getValue();
                        civI.setDiploPoints(civI.getDiploPoints() - GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_NONAGGRESSION);
                        Civilization other = CFG.core.getCiv(tData.iCivID);
                        other.setDiploPoints(other.getDiploPoints() - GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_NONAGGRESSION);
                        if (tData.iTurnID == 1 && civI.getNumOfProvs() > 0 && other.getNumOfProvs() > 0) {
                            civI.getCivDiploGD().messageBox.addMessage(new Message_NonAggressionPact_Expired(tData.iCivID));
                            other.getCivDiploGD().messageBox.addMessage(new Message_NonAggressionPact_Expired(i));
                        }
                        civI.setNonAggPact(tData.iCivID, tData.iTurnID - 1);
                        if (tData.iTurnID == 1) it.remove();
                    }
                }
            } catch (Exception ex) {}
            try {
                if (!civI.guarantee.isEmpty()) {
                    it = civI.guarantee.entrySet().iterator();
                    while (it.hasNext()) {
                        tData = it.next().getValue();
                        civI.setDiploPoints(civI.getDiploPoints() - GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_GUARANTEE);
                        Civilization other = CFG.core.getCiv(tData.iCivID);
                        other.setDiploPoints(other.getDiploPoints() - GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_GUARANTEE);
                        if (tData.iTurnID == 1 && civI.getNumOfProvs() > 0 && other.getNumOfProvs() > 0) {
                            if (civI.getIsPlayer()) civI.getCivDiploGD().messageBox.addMessage(new Message_IndependenceFrom_Expired(tData.iCivID));
                            if (other.getIsPlayer()) other.getCivDiploGD().messageBox.addMessage(new Message_Independence_Expired(i));
                        }
                        civI.setGuarantee2(tData.iCivID, tData.iTurnID - 1);
                        if (tData.iTurnID == 1) it.remove();
                    }
                }
            } catch (Exception ex) {}
            try {
                if (!civI.militaryAccess.isEmpty()) {
                    it = civI.militaryAccess.entrySet().iterator();
                    while (it.hasNext()) {
                        tData = it.next().getValue();
                        civI.setDiploPoints(civI.getDiploPoints() - GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_MILITARY_ACCESS);
                        Civilization other = CFG.core.getCiv(tData.iCivID);
                        other.setDiploPoints(other.getDiploPoints() - GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_MILITARY_ACCESS);
                        if (tData.iTurnID == 1) {
                            if (civI.getNumOfProvs() > 0 && other.getNumOfProvs() > 0) {
                                if (civI.getIsPlayer()) civI.getCivDiploGD().messageBox.addMessage(new Message_MilitaryAccess_Expired(tData.iCivID));
                                if (other.getIsPlayer()) other.getCivDiploGD().messageBox.addMessage(new Message_MilitaryAccess_Expired(i));
                            }
                        } else if (tData.iTurnID < 4 && civI.getIsPlayer()) {
                            civI.getCivDiploGD().messageBox.addMessage(new Message_MilitaryAccess_ExpireSoon(tData.iCivID, tData.iTurnID - 1));
                        }
                        civI.setMilitaryAccess7(tData.iCivID, tData.iTurnID - 1);
                        if (tData.iTurnID == 1) it.remove();
                    }
                }
            } catch (Exception ex) {}
            try {
                if (!civI.truce.isEmpty()) {
                    it = civI.truce.entrySet().iterator();
                    while (it.hasNext()) {
                        tData = it.next().getValue();
                        Civilization other = CFG.core.getCiv(tData.iCivID);
                        if (tData.iTurnID == 1 && civI.getNumOfProvs() > 0 && other.getNumOfProvs() > 0) {
                            if (civI.getIsPlayer()) civI.getCivDiploGD().messageBox.addMessage(new Message_Truce_Expired(tData.iCivID));
                            if (other.getIsPlayer()) other.getCivDiploGD().messageBox.addMessage(new Message_Truce_Expired(i));
                        }
                        civI.setTruce3(tData.iCivID, tData.iTurnID - 1);
                        if (tData.iTurnID == 1) it.remove();
                    }
                }
            } catch (Exception ex) {}
        }
    }

    public static void updateBuildingsConstruction() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            Civilization civ = CFG.core.getCiv(i);
            if (civ == null || civ.civGD == null) continue;
            civ.runConstructions();
            if (civ.getGold() < (long)GameValues.gvTechnology.MIN_MONEY_REQUIRED_TO_ENABLE_RESEARCH) {
                civ.setSpendingResearchB(0.0f);
            }
            if (civ.civGD.techPoints.getPointsLeft(i) > 0) {
                civ.getCivDiploGD().messageBox.addMessage(new Message_TechPoints(i));
            }
        }
        try {
            for (int a = 0; a < CFG.core.getPlayersSize(); ++a) {
                if (CFG.core.getCiv(CFG.core.getPlayer(a).getCivId()).getNumOfProvs() <= 0) continue;
                if (CFG.core.getCiv(CFG.core.getPlayer(a).getCivId()).getSpendingGoodsB() < CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(a).getCivId()).getIdeology()).getMin_Goods(CFG.core.getPlayer(a).getCivId())) {
                    CFG.core.getCiv((int)CFG.core.getPlayer((int)a).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_GoodsLow(CFG.core.getPlayer(a).getCivId(), (int)(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.core.getPlayer(a).getCivId()).getIdeology()).getMin_Goods(CFG.core.getPlayer(a).getCivId()) * 100.0f)));
                }
                if (CFG.core.getCiv(CFG.core.getPlayer(a).getCivId()).getSpendingInvestmentsB() < CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(CFG.core.getPlayer(a).getCivId()).getIdeology(), CFG.core.getPlayer(a).getCivId())) {
                    CFG.core.getCiv((int)CFG.core.getPlayer((int)a).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_InvestmentsLow(CFG.core.getPlayer(a).getCivId(), (int)(CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(CFG.core.getPlayer(a).getCivId()).getIdeology(), CFG.core.getPlayer(a).getCivId()) * 100.0f)));
                }
                if (CFG.core.armyExpertisePointsLeft(CFG.core.getPlayer(a).getCivId()) <= 0) continue;
                CFG.core.getCiv((int)CFG.core.getPlayer((int)a).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_MilitaryExpPoints(CFG.core.getPlayer(a).getCivId()));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void updateForeignInvests() {
        try {
            for (int i = CFG.core.investForeignGold.size() - 1; i >= 0; --i) {
                if (GameCalendar.TURNID < CFG.core.investForeignGold.get((int)i).returnTurnID) continue;
                ForeignInvest inv = CFG.core.investForeignGold.get(i);
                Civilization civ = CFG.core.getCiv(inv.civID);
                civ.setGold(civ.getGold() + (long)inv.gold);
                if (civ.getIsPlayer()) {
                    civ.getCivDiploGD().messageBox.addMessage(new Message_InvestDoneForeign(inv.inCivID, inv.provinceID, inv.gold, inv.profit));
                }
                CFG.core.investForeignGold.remove(i);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void updateForeignBuildInvests() {
        try {
            for (int i = CFG.core.buildForeignGold.size() - 1; i >= 0; --i) {
                if (GameCalendar.TURNID < CFG.core.buildForeignGold.get((int)i).returnTurnID) continue;
                ForeignInvest inv = CFG.core.buildForeignGold.get(i);
                Civilization civ = CFG.core.getCiv(inv.civID);
                civ.setGold(civ.getGold() + (long)inv.gold);
                if (civ.getIsPlayer()) {
                    civ.getCivDiploGD().messageBox.addMessage(new Message_InvestBuildDoneForeign(inv.inCivID, inv.provinceID, inv.gold, inv.profit));
                }
                CFG.core.buildForeignGold.remove(i);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void updatePropaganda() {
        try {
            for (int i = CFG.core.propaganda.size() - 1; i >= 0; --i) {
                try {
                    age.of.civilizations2.jakowski.lukasz.Civilizations.Province.Propaganda p = CFG.core.propaganda.get(i);
                    Province province = CFG.core.getProv(p.provinceID);
                    if (province.getCivId() == p.byCivID || GameCalendar.TURNID >= p.endTurnID) {
                        CFG.core.propaganda.remove(i);
                        continue;
                    }
                    province.setHappi(province.getHappi() - Festival.festivalHappinessPerTurn(p.provinceID) * GameValues.gvPropaganda.PROPAGANDA_PERC_OF_FESTIVAL_HAPPINESS);
                    for (int j = 0; j < province.getNeighProvincesSize(); ++j) {
                        Province neigh = CFG.core.getProv(province.getNeighProvinces(j));
                        neigh.setHappi(neigh.getHappi() - Festival.festivalHappinessPerTurn_NeighboringProvinces() * GameValues.gvPropaganda.PROPAGANDA_PERC_OF_FESTIVAL_HAPPINESS_NEIGH_PROVINCES);
                    }
                    if (province.getHappi() < GameValues.gvPropaganda.INCREASE_REV_RISK_IF_HAPPINESS_BELOW) {
                        province.setRevRisk(province.getRevRisk() + (float)ThreadLocalRandom.current().nextInt(GameValues.gvPropaganda.INCREASE_REV_RISK_IF_HAPPINESS_BELOW_BY_VALUE_PER_TURN_RANDOM_1000) / 1000.0f);
                    }
                } catch (Exception ex) {}
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void updateSanctions() {
        Parallel.range(1, CFG.core.getCivsSize(), (int i) -> {
            Civilization civ = CFG.core.getCiv(i);
            if (civ != null) {
                civ.updateSanctionsTurns();
            }
        });
    }

    public static void updateDiplomaticSummits() {
        int i;
        try {
            for (i = CFG.core.diplomaticSummits.size() - 1; i >= 0; --i) {
                GameManager.summitImproveRelations(CFG.core.diplomaticSummits.get((int)i).invitedCivs);
                if (CFG.core.diplomaticSummits.get((int)i).endTurnID > GameCalendar.TURNID) continue;
                try {
                    int a;
                    if (CFG.core.getCiv(CFG.core.diplomaticSummits.get((int)i).civHostID).getIsPlayer()) {
                        CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("DiplomaticSummitOver"), CFG.core.getCiv(CFG.core.diplomaticSummits.get((int)i).civHostID).getCivName() + " " + GameCalendar.getCurrDate(), Images.infoDiplomacy);
                    }
                    int civsSize = CFG.core.diplomaticSummits.get((int)i).invitedCivs.size();
                    for (a = 1; a < civsSize; ++a) {
                        Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(CFG.core.diplomaticSummits.get((int)i).invitedCivs.get(0)), CFG.core.getCapitalOrProvince(CFG.core.diplomaticSummits.get((int)i).invitedCivs.get(a)), CFG.COLOR_POSITIVE);
                    }
                    civsSize = CFG.core.diplomaticSummits.get((int)i).invitedCivs.size();
                    for (a = 0; a < civsSize; ++a) {
                        if (!CFG.core.getCiv(CFG.core.diplomaticSummits.get((int)i).invitedCivs.get(a)).getIsPlayer()) continue;
                        CFG.core.getCiv((int)CFG.core.diplomaticSummits.get((int)i).invitedCivs.get((int)a).intValue()).getCivDiploGD().messageBox.addMessage(new Message_SummitIsOver(CFG.core.diplomaticSummits.get((int)i).civHostID));
                    }
                }
                catch (Exception exr) {
                    CFG.exceptionStack(exr);
                }
                CFG.core.diplomaticSummits.remove(i);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            for (i = CFG.core.diplomaticSummitCooldowns.size() - 1; i >= 0; --i) {
                if (CFG.core.diplomaticSummitCooldowns.get((int)i).turnID > GameCalendar.TURNID) continue;
                CFG.core.diplomaticSummitCooldowns.remove(i);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void updateCapitulation() {
        try {
            for (int i = 0; i < CFG.core.getWarsSize(); ++i) {
                War_GameData war = CFG.core.getWar(i);
                int warScore = CFG.core.getCachedWarScore(war);
                if ((float)warScore <= GameValues.gvCapitulation.CAPITULATION_AGGRESSORS_MIN_WAR_SCORE) {
                    for (int j = 0; j < war.getDefendersSize(); ++j) {
                        if (!((float)war.getProvinces_Defender_OwnTotal(j) / (float)war.getProvinces_Defender_Own(j) <= CFG.CAPITULATION)) continue;
                        NewTurn.capitulation(war.getDefenderID(j).getCivID(), war.getAggressorID(0).getCivID());
                    }
                } else if ((float)warScore >= GameValues.gvCapitulation.CAPITULATION_DEFENDERS_MIN_WAR_SCORE) {
                    for (int j = 0; j < war.getAggressorsSize(); ++j) {
                        if (!((float)war.getProvinces_Aggressor_OwnTotal(j) / (float)war.getProvinces_Aggressor_Own(j) <= CFG.CAPITULATION)) continue;
                        NewTurn.capitulation(war.getAggressorID(j).getCivID(), war.getDefenderID(0).getCivID());
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void capitulation(int civID, int toCivID) {
        block11: {
            try {
                int i;
                if (CFG.core.getCiv(civID).getIsPlayer() && !GameValues.gvCapitulation.PLAYER_CAN_CAPITULATE) {
                    return;
                }
                Civilization civ = CFG.core.getCiv(civID);
                if (civ.getNumOfProvs() <= 0) break block11;
                try {
                    for (i = civ.getArmyInAnotherProvinceSize() - 1; i >= 0; --i) {
                        CFG.core.getProv(civ.getArmyInAnotherProviP(i)).updateArmy4(civID, 0);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                try {
                    for (i = civ.getNumOfProvs() - 1; i >= 0; --i) {
                        CFG.core.getProv(civ.getProvID(i)).updateArmy4(civID, 0);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                for (int i2 = civ.getNumOfProvs() - 1; i2 >= 0; --i2) {
                    CFG.core.getProv(civ.getProvID(i2)).setCivId(toCivID, true);
                }
                civ.civGD.iLastWarTurnID = GameCalendar.TURNID;
                if (!CFG.core.getCiv(toCivID).isAtWarC()) {
                    CFG.core.getCiv(toCivID).civGD.iLastWarTurnID = GameCalendar.TURNID;
                }
                if (!CFG.SPECTATOR_MODE && CFG.core.getCiv(toCivID).getIsPlayer()) {
                    CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("Capitulation"), civID, toCivID, Images.infoWar);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public static void updateWarWeariness() {
        try {
            Parallel.range(1, CFG.core.getCivsSize(), (int i) -> {
                Civilization civ = CFG.core.getCiv(i);
                if (civ != null && civ.getNumOfProvs() > 0) {
                    if (civ.isAtWarC()) {
                        boolean atWarWithOnlyRebels = true;
                        for (int a = 0; a < civ.isAtWarWithCivs.size(); ++a) {
                            int enemyID = civ.isAtWarWithCivs.get(a);
                            if ((int)CFG.core.getCivRelationOfCivB(i, enemyID) != GameValues.gvDiplomacy.RELATION_AT_WAR || CFG.core.getCiv(enemyID).getNumOfProvs() <= 0 || CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv(enemyID).getIdeology()).REVOLUTIONARY) continue;
                            atWarWithOnlyRebels = false;
                            break;
                        }
                        if (atWarWithOnlyRebels) {
                            civ.setWarWeariness(civ.getWarWeariness() + GameValues.gvWarWeariness.WAR_WEARINESS_BASE_INCREASE_AT_WAR * Math.min(GameValues.gvWarWeariness.WAR_DURATION_SCALE_LIMIT, (float)civ.civGD.iNumOfTurnsAtWar / (GameValues.gvWarWeariness.WAR_DURATION_SCALE_FACTOR * GameCalendar.GAME_SPEED)) * GameValues.gvWarWeariness.WAR_WEARINESS_AT_WAR_WITH_ONLY_REBELS_MODIFIER);
                        } else {
                            civ.setWarWeariness(civ.getWarWeariness() + GameValues.gvWarWeariness.WAR_WEARINESS_BASE_INCREASE_AT_WAR * Math.min(GameValues.gvWarWeariness.WAR_DURATION_SCALE_LIMIT, (float)civ.civGD.iNumOfTurnsAtWar / (GameValues.gvWarWeariness.WAR_DURATION_SCALE_FACTOR * GameCalendar.GAME_SPEED)));
                        }
                    } else {
                        civ.setWarWeariness(civ.getWarWeariness() - GameValues.gvWarWeariness.WAR_WEARINESS_PEACE_DECREASE);
                    }
                }
            });
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void updateLibertyDesireMessages() {
        try {
            if (GameCalendar.TURNID % GameValues.gvVassalLiberty.SEND_VASSALS_HIGH_LIBERTY_MESSAGE_EVERY_X_TURNS == 0) {
                for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                    for (int j = 0; j < CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.iVassalsSize; ++j) {
                        if (!(CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.vassals.get((int)j).iCivID).getVassalLibertyDesire() > GameValues.gvVassalLiberty.MESSAGE_THE_PLAYER_IF_LIBERTY_OVER)) continue;
                        CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civGD.civDiploGD.messageBox.addMessage(new Message_VassalHighLiberty(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.vassals.get((int)j).iCivID));
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void updateProvinceVolunteerArmySent() {
        try {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (i % GameValues.gvArmyRecruit.VOLUNTEER_ARMY_SEND_RESET_AFTER_X_TURNS == GameCalendar.TURNID % GameValues.gvArmyRecruit.VOLUNTEER_ARMY_SEND_RESET_AFTER_X_TURNS) {
                    Province province = CFG.core.getProv(i);
                    if (!province.provinceVolunteerArmySent.isEmpty()) {
                        for (int j = province.provinceVolunteerArmySent.size() - 1; j >= 0; --j) {
                            if (province.provinceVolunteerArmySent.get((int)j).TURN_ID + GameValues.gvArmyRecruit.VOLUNTEER_ARMY_SEND_RESET_AFTER_X_TURNS <= GameCalendar.TURNID) {
                                province.provinceVolunteerArmySent.remove(j);
                            }
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    static {
        ageRiskModifier = 1.0f;
        ageDevMod = 1.0f;
        happinessChange_ByTaxation = new ArrayList<Float>();
        happinessChange_ByTaxation_Occupied = new ArrayList<Float>();
        goodsUpdate = new ArrayList<Float>();
        devUpdate = new ArrayList<Float>();
        ecoUpdate = new ArrayList<Float>();
    }
}
