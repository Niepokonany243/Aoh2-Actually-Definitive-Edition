
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Images;

public class GameN {
    public static boolean FUEVG = false;
    public static boolean GLDRCA = false;

    public static void updateLeaderDeath() {
        if (CFG.getIsDesktop()) {
            for (int i = (CFG.core.getCivsSize() - 1) % GameValues.gvLeader.LEADER_DEATH_UPDATE_CIVS_X; i < CFG.core.getCivsSize(); ++i) {
                GameN.updateLeaderDeath(i);
            }
        } else {
            for (int i = (CFG.core.getCivsSize() - 1) % GameValues.gvLeader.LEADER_DEATH_UPDATE_CIVS_X; i < CFG.core.getCivsSize(); ++i) {
                GameN.updateLeaderDeath2(i);
            }
        }
    }

    public static void updateLeaderDeath(int c) {
        if (CFG.core.getCiv((int)c).civGD.leaderData != null && GameN.hiDc(c, CFG.core.getCiv((int)c).civGD.leaderData.getYear())) {
            if (CFG.core.getCiv(c).getIsPlayer()) {
                CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("DeathOfALeader") + ": " + CFG.core.getCiv((int)c).civGD.leaderData.getName(), CFG.core.getCiv(c).getCivName() + " - " + GameCalendar.getCurrDate(), Images.infoDiplomacy);
            }
            CFG.core.getCiv(c).setLeaderN(null);
            if (GameValues.gvLeader.ADD_RANDOM_LEADER_AFTER_DEATH) {
                CFG.core.bLR(c);
            }
        }
    }

    public static void updateLeaderDeath2(int c) {
        if (CFG.core.getCiv((int)c).civGD.leaderData != null && GameN.hiDc(c, CFG.core.getCiv((int)c).civGD.leaderData.getYear())) {
            if (CFG.core.getCiv(c).getIsPlayer()) {
                CFG.menus.rebuildMenu_InGame_Infobox_AllAction(CFG.lang.get("DeathOfALeader") + ": " + CFG.core.getCiv((int)c).civGD.leaderData.getName(), CFG.core.getCiv(c).getCivName() + " - " + GameCalendar.getCurrDate(), Images.infoDiplomacy);
            }
            CFG.core.getCiv(c).setLeaderN(null);
        }
    }

    public static final boolean hiDc(int iCivID, int iBornYear) {
        int chanceID = Math.max(0, Math.min(10, (GameCalendar.currYear - iBornYear - GameValues.gvLeader.LIFE_EXPECTANCY) / 10));
        if (GameCalendar.currYear - iBornYear > 100) {
            return true;
        }
        return (float)CFG.oR.nextInt(10000) < GameValues.gvLeader.CHANCE_OF_DEATH[chanceID] + (GameValues.gvLeader.CHANCE_OF_DEATH[chanceID + 1] - GameValues.gvLeader.CHANCE_OF_DEATH[chanceID]) * ((float)((GameCalendar.currYear - iBornYear) % 10) / 10.0f);
    }
}

