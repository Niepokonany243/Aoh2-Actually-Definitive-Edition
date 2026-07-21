
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;

public class RTS {
    public static final int MAXSPEED = 6;
    public static int SPEED = 1;
    public static boolean PAUSE = true;
    public static boolean PAUSE_BEFORE_NEXT_TURN = true;
    public static int SOURCE = 0;
    public static final int[] TIME_REQUIRED_TO_ACTION = new int[]{1, 6500, 4000, 3000, 2000, 1250, 1};
    public static final int[] TIME_REQUIRED_TO_ACTION_MOVEUNITS = new int[]{1, 1750, 1250, 1000, 1000, 750, 50};
    public static final int[] TIME_REQUIRED_TO_ACTION_REPORT = new int[]{1, 2250, 2000, 1750, 1650, 1500, 50};
    public static final int[] TIME_REQUIRED_TO_ACTION_LOADAI = new int[]{1, 750, 500, 1, 1, 1, 1};
    public static final boolean[] SHOW_REPORT = new boolean[]{true, true, true, true, true, true, false};
    public static long TIME_PAST = 0L;
    public static long TIME_LAST_UPDATE = 0L;

    public static void updateTimePast_AfterAction(float fPerc) {
        if ((TIME_PAST -= (long)((int)((float)TIME_REQUIRED_TO_ACTION[SPEED] * fPerc))) < 0L) {
            TIME_PAST = 0L;
        }
    }

    public static final void updateTime() {
        if (RTS.addTime()) {
            TIME_PAST += System.currentTimeMillis() - TIME_LAST_UPDATE;
            TIME_LAST_UPDATE = System.currentTimeMillis();
        } else {
            TIME_LAST_UPDATE = System.currentTimeMillis();
        }
        if (RTS.timePasted()) {
            TIME_PAST = 0L;
            if (ProvinceMesh.isDiplomacyActive()) { RTS.resetTime(); return; }
            if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
                CFG.gameAction.takeNextTurn();
            } else if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.TURN_ACTIONS) {
                CFG.gameAction.takeNextTurn();
            } else if ((CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.LOAD_AI_RTO || CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.LOADING_NEXT_TURN) && CFG.menus.getInGameProvInfo().getMenuElem(0).getIsClickable()) {
                CFG.gameAction.takeNextTurn();
                RTS.resetTime();
            }
        }
    }

    private static final boolean timePasted() {
        return TIME_PAST > (long)RTS.getRequiredTime();
    }

    public static final int getRequiredTime() {
        if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
            return TIME_REQUIRED_TO_ACTION[SPEED];
        }
        if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.TURN_ACTIONS) {
            if (CFG.gameAction.getCurrentMoveunits() != null) {
                return TIME_REQUIRED_TO_ACTION_MOVEUNITS[SPEED];
            }
            return TIME_REQUIRED_TO_ACTION_REPORT[SPEED];
        }
        if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.LOAD_AI_RTO || CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.LOADING_NEXT_TURN) {
            return TIME_REQUIRED_TO_ACTION_LOADAI[SPEED];
        }
        return TIME_REQUIRED_TO_ACTION[SPEED];
    }

    public static final boolean showReport() {
        return SHOW_REPORT[SPEED];
    }

    public static final boolean addTime() {
        if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) {
            if (CFG.menus.getInGameView_Options() || CFG.menus.getInGameView_EndOfGame()) {
                RTS.resetTime();
                return false;
            }
            if (RTS.runRTS()) {
                return false;
            }
        }
        return true;
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    public static boolean runRTS() {
        return !CFG.SPECTATOR_MODE && (CFG.mapModesManager.getActiveMapModeID() >= 0 && !CFG.mapModesManager.getActiveView().canMoveArmy() && CFG.mapModesManager.getActiveMapModeID() != MapModesManager.VIEW_DISEASES_MODE || CFG.chooseProvinceMode || CFG.menus.getInGame_ProvinceMoveUnits_Visible() || CFG.menus.getInGame_ProvinceRecruit_Visible() || CFG.menus.getInGame_ProvinceRegroupArmy_Visible() || CFG.menus.getInGame_ProvinceDisband_Visible() || CFG.menus.getInGame_ProvincemMore_Visible() || CFG.menus.getInGame_ProvinceChooseProvince_Visible() || CFG.menus.getVisible_InGame_FlagAction() || CFG.menus.getVisible_InGame_Budget() || CFG.menus.getVisibleInGame_Event());
    }

    public static final void resetTime() {
        TIME_PAST = 0L;
        TIME_LAST_UPDATE = System.currentTimeMillis();
    }

    public static final float getTimePerc() {
        return Math.min((float)TIME_PAST / (float)RTS.getRequiredTime(), 1.0f);
    }

    public static final void reset() {
        PAUSE = true;
        RTS.resetTime();
    }

    public static boolean isEnabled() {
        return CFG.core.getPlayersSize() == 1;
    }

    public static void pauseUnpause() {
        PAUSE = !PAUSE;
        if (!PAUSE) {
            TIME_LAST_UPDATE = System.currentTimeMillis();
        }
        CFG.toastM.addM(PAUSE ? CFG.lang.get("Paused") : CFG.lang.get("Unpaused"));
    }

    public static void updateSpeed(int nDiff) {
        float tempTimePastPerc = RTS.getTimePerc();
        if ((SPEED += nDiff) < 1) {
            SPEED = 1;
        } else if (SPEED > 6) {
            SPEED = 6;
        }
        TIME_PAST = (long)((float)TIME_REQUIRED_TO_ACTION[SPEED] * tempTimePastPerc);
        CFG.toastM.addM(CFG.lang.get("Speed") + ": " + SPEED);
    }
}

