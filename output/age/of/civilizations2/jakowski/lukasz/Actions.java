
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.Menus.RTO.Menu_InGame_RTO2;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.Render;
import age.of.civilizations2.jakowski.lukasz.TechManager;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.MoveUnits;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.MoveUnits_Plunder;
import java.util.stream.IntStream;

public class Actions
extends Thread {
    @Override
    public void run() {
        Actions.doActions();
    }

    
    public static void doActions() {
        long perfStart = System.currentTimeMillis();
        long perfMark = perfStart;
        long time = System.nanoTime();
        time = System.nanoTime();
        try {
            CFG.menus.getInGameProvInfo().getMenuElem(0).setTextE(CFG.lang.get("Next"));
            try {
                CFG.gameAction.battleReports.clear();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            if (CFG.getIsDesktop()) {
                Actions.runRevolts();
            }
            long perfNow = System.currentTimeMillis(); if (perfNow - perfMark > 50) { CFG.LOG("PERF", "[Actions] runRevolts: " + (perfNow - perfMark) + "ms"); } perfMark = perfNow;
            time = System.nanoTime();
            time = System.nanoTime();
            time = System.nanoTime();
            time = System.nanoTime();
            time = System.nanoTime();
            CFG.menus.updateBuildProvinceHoverInformation();
            CFG.gameAction.resetCurrentMoveUnits();
            time = System.nanoTime();
            CFG.menus.setVisibleInGame_Messages(false);
            time = System.nanoTime();
            if ((!RTS.isEnabled() || RTS.PAUSE) && CFG.gameAction.showNextPlayerTurnView()) {
                CFG.map.getMpB().updateWorldMap_Shaders();
                Render.updateRenderer();
                if (CFG.FOG_OF_WAR == 2) {
                    CFG.core.enableDrawCivlizationsRegions_Player(CFG.PLAYER_TURN_ID);
                } else {
                    CFG.core.enableDrawCivlizationsRegions_Players();
                }
            }
            time = System.nanoTime();
            CFG.core.clearMoveUnits_JustDraw_AnotherArmies();
            time = System.nanoTime();
            CFG.map.getTouchMgr().ueExA();
            time = System.nanoTime();
            TechManager.updateCivs_ResearchProgress();
            time = System.nanoTime();
            CFG.oAI.setLoadingTurnActionsOfCivID(0);
            time = System.nanoTime();
            CFG.oAI.buildAI_Data();
            long perfNow2 = System.currentTimeMillis(); if (perfNow2 - perfMark > 50) { CFG.LOG("PERF", "[Actions] buildAI_Data: " + (perfNow2 - perfMark) + "ms"); } perfMark = perfNow2;
            time = System.nanoTime();
            try {
                CFG.oAI.turnOrders_0();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                CFG.oAI.turnOrders_1();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                CFG.oAI.turnOrders_2();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                CFG.oAI.turnOrders();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                CFG.oAI.turnOrders_InvestForeign();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            try {
                CFG.oAI.turnOrders_End();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
            long perfNow3 = System.currentTimeMillis(); if (perfNow3 - perfMark > 50) { CFG.LOG("PERF", "[Actions] turnOrders: " + (perfNow3 - perfMark) + "ms"); } perfMark = perfNow3;
            time = System.nanoTime();
            for (int civIndex = 1; civIndex < CFG.core.getCivsSize(); ++civIndex) {
                try {
                    Civilization civLambda = CFG.core.getCiv(civIndex);
                    int moveUnitsSize = civLambda.moveUnitsSize();
                    for (int jIndex = 0; jIndex < moveUnitsSize; ++jIndex) {
                        MoveUnits moveUnit = civLambda.getMoveUnits(jIndex);
                        Province fromProv = CFG.core.getProv(moveUnit.getFromProviID());
                        fromProv.updateArmy4(civIndex, fromProv.getArmyCivID1(civIndex) + moveUnit.getNumberOfUnits());
                    }
                    int moveUnitsPlunderSize = civLambda.getMoveUnitsPlunderSize();
                    for (int jIndex = 0; jIndex < moveUnitsPlunderSize; ++jIndex) {
                        MoveUnits_Plunder plunderUnit = civLambda.getMoveUnitsPlunder(jIndex);
                        Province fromProv = CFG.core.getProv(plunderUnit.getFromProvinceID());
                        fromProv.updateArmy4(civIndex, fromProv.getArmyCivID1(civIndex) + plunderUnit.getNumOfUnits());
                    }
                }
                catch (Exception ex) {}
            }
            time = System.nanoTime();
            time = System.nanoTime();
            time = System.nanoTime();
            CFG.gameAction.setActiveTurnState(GameAction.TurnStates.TURN_ACTIONS);
            time = System.nanoTime();
            CFG.core.disableDrawCivlizationsRegions_Players();
            CFG.map.getTouchMgr().ueExA();
            time = System.nanoTime();
            CFG.map.getMpB().updateWorldMap_Shaders();
            Render.updateRenderer();
            Render.updateDrawMoveUnits();
            CFG.core.updateDrawMoveUnitsArmy();
            time = System.nanoTime();
            CFG.gameAction.SHOW_REPORT = false;
            for (int civIndex = 1; civIndex < CFG.core.getCivsSize(); ++civIndex) {
                try {
                    CFG.core.getCiv(civIndex).runRecruitArmyNT();
                } catch (Exception ex) {}
            }
            CFG.menus.updateBuildProvinceHoverInformation();
            time = System.nanoTime();
        }
        catch (StackOverflowError ex) {
            CFG.exceptionStack(ex);
            try {
                CFG.menus.getInGameProvInfo().getMenuElem(0).setClickable(true);
            }
            catch (Exception exception) {
                
            }
        }
        finally {
            time = System.nanoTime();
            try {
                CFG.menus.getInGameProvInfo().getMenuElem(0).setClickable(true);
            }
            catch (Exception exception) {}
        }
        CFG.setRenderO(true);
        Menu_InGame_RTO2.TIME_CONTINUE = System.currentTimeMillis();
    }

    public static final void runRevolts() {
        long time = System.nanoTime();
        try {
            CFG.core.revoltDeclareIndependence();
            time = System.nanoTime();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        catch (StackOverflowError exr) {
            CFG.exceptionStack(exr);
        }
        try {
            CFG.gameAction.startUprising();
            time = System.nanoTime();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        catch (StackOverflowError exr) {
            CFG.exceptionStack(exr);
        }
    }
}

