
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_Age;
import java.util.ArrayList;
import java.util.List;

public class GameCalendar {
    public static int TURNID = 1;
    public static int TURNS_SINCE_LAST_WAR = 0;
    public static int CURRENT_AGEID = 0;
    public static int currDay = 1;
    public static int currMonth = 1;
    public static int currYear = 2026;
    public static float GAME_SPEED = 1.0f;
    public static float GAME_SPEED_MIN = 0.5f;
    public static float GAME_SPEED_MAX = 2.0f;
    public static float AI_AGGRESSIVENESS = 0.75f;
    public static float AI_AGGRESSIVENESS_DEFAULT = 0.75f;
    public static int MAX_AI_AGGRESSIVENESS = 1000;
    public static boolean ENABLE_COLONIZATION = true;
    public static boolean ENABLE_COLONIZATION_NEUTRAL_PROVINCES = false;
    public static float COLONIZATION_TECH_LEVEL = 0.8f;
    public static final int COLONIZATION_ENABLED_SINCE_AGE_ID = 4;
    private static final int[] NUM_OF_DAYSIN_MONTH = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int NUM_OF_MONTHS = 12;

    public static boolean getColonizationOfWastelandIsEnabled() {
        return ENABLE_COLONIZATION;
    }

    public static boolean getCanColonize_TechLevel(int nCivID) {
        return CFG.core.getCiv(nCivID).getTechLevel() >= COLONIZATION_TECH_LEVEL;
    }

    public static final int getNumOfDaysInMonth(int nMonth) {
        try {
            return NUM_OF_DAYSIN_MONTH[nMonth - 1];
        }
        catch (IndexOutOfBoundsException ex) {
            return 28;
        }
    }

    public static final String getCurrDate() {
        return "" + currDay + " " + GameCalendar.getMonthName(currMonth) + " " + CFG.gameAges.getYear(currYear);
    }

    public static final String getCurrDate2() {
        if (TURNID < 10 && currDay == 1 && currMonth == 4) {
            return "April Fools " + CFG.gameAges.getYear(currYear);
        }
        return "" + currDay + " " + GameCalendar.getMonthName(currMonth) + " " + CFG.gameAges.getYear(currYear);
    }

    public static final String getCurrDate_CreateEvent() {
        return "" + CFG.eventsManager.iCreateEvent_Day + " " + GameCalendar.getMonthName(CFG.eventsManager.iCreateEvent_Month) + " " + CFG.gameAges.getYear(CFG.eventsManager.iCreateEvent_Year);
    }

    public static final String getCurrDate_Simple() {
        return "" + currDay + " " + currMonth + " " + CFG.gameAges.getYear(currYear);
    }

    public static final String getMonthName(int nMonth) {
        switch (nMonth) {
            case 1: {
                return CFG.lang.get("January");
            }
            case 2: {
                return CFG.lang.get("February");
            }
            case 3: {
                return CFG.lang.get("March");
            }
            case 4: {
                return CFG.lang.get("April");
            }
            case 5: {
                return CFG.lang.get("May");
            }
            case 6: {
                return CFG.lang.get("June");
            }
            case 7: {
                return CFG.lang.get("July");
            }
            case 8: {
                return CFG.lang.get("August");
            }
            case 9: {
                return CFG.lang.get("September");
            }
            case 10: {
                return CFG.lang.get("October");
            }
            case 11: {
                return CFG.lang.get("November");
            }
            case 12: {
                return CFG.lang.get("December");
            }
            case 13: {
                return CFG.lang.get("January");
            }
        }
        return CFG.lang.get("December");
    }

    public static void updateDateNextTurn() {
        GameCalendar.nextDays(CFG.gameAges.getAge_TurnDays(CURRENT_AGEID));
    }

    public static void updateAge() {
        GameCalendar.updateAge(true);
    }

    public static void updateAge(boolean sendMessages) {
        int nAgeID = CFG.gameAges.getAgeOfYear(currYear);
        if (sendMessages && CURRENT_AGEID != nAgeID) {
            for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_Age(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
            }
        }
        CURRENT_AGEID = nAgeID;
    }

    private static List<Integer> getNumOfDatesByTurnID(List<Integer> tempDate) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        out.add(0);
        out.add(0);
        out.add(0);
        out.set(2, Math.abs(currYear - tempDate.get(2)));
        tempDate.set(2, currYear);
        if (tempDate.get(1) == currMonth) {
            if (tempDate.get(0) > currDay) {
                out.set(1, (Integer)out.get(1) - 1);
                out.set(0, currDay + (NUM_OF_DAYSIN_MONTH[tempDate.get(1) - 1] - tempDate.get(0)));
                if ((Integer)out.get(1) < 0) {
                    out.set(1, 11);
                    out.set(2, (Integer)out.get(2) - 1);
                    if ((Integer)out.get(2) < 0) {
                        out.set(2, 0);
                    }
                }
            } else {
                out.set(0, currDay - tempDate.get(0));
            }
        } else if (tempDate.get(1) < currMonth) {
            out.set(1, currMonth - tempDate.get(1));
            if (tempDate.get(0) > currDay) {
                out.set(1, (Integer)out.get(1) - 1);
                out.set(0, currDay + (NUM_OF_DAYSIN_MONTH[tempDate.get(1) - 1] - tempDate.get(0)));
            } else {
                out.set(0, currDay - tempDate.get(0));
            }
        } else {
            if ((Integer)out.get(2) > 0) {
                out.set(2, (Integer)out.get(2) - 1);
            }
            out.set(1, currMonth + (12 - tempDate.get(1)));
            if (tempDate.get(0) > currDay) {
                out.set(1, (Integer)out.get(1) - 1);
                out.set(0, currDay + (NUM_OF_DAYSIN_MONTH[tempDate.get(1) - 1] - tempDate.get(0)));
            } else {
                out.set(0, currDay - tempDate.get(0));
            }
        }
        return out;
    }

    public static final String getDate_ByTurnID(int nTurnID) {
        if (nTurnID == TURNID) {
            return GameCalendar.getCurrDate();
        }
        if (nTurnID > TURNID) {
            List<Integer> tempDate = new ArrayList<Integer>();
            tempDate.add(currDay);
            tempDate.add(currMonth);
            tempDate.add(currYear);
            tempDate.add(CURRENT_AGEID);
            tempDate = GameCalendar.forwardDays(tempDate, nTurnID - TURNID);
            return "" + tempDate.get(0) + " " + GameCalendar.getMonthName(tempDate.get(1)) + " " + CFG.gameAges.getYear(tempDate.get(2));
        }
        List<Integer> tempDate = new ArrayList<Integer>();
        tempDate.add(currDay);
        tempDate.add(currMonth);
        tempDate.add(currYear);
        tempDate.add(CURRENT_AGEID);
        tempDate = GameCalendar.backwardsDays(tempDate, TURNID - nTurnID);
        return "" + tempDate.get(0) + " " + GameCalendar.getMonthName(tempDate.get(1)) + " " + CFG.gameAges.getYear(tempDate.get(2));
    }

    public static final String getDate_ByTurnIDOnlyYear(int nTurnID) {
        if (nTurnID == TURNID) {
            return CFG.gameAges.getYear(currYear);
        }
        if (nTurnID > TURNID) {
            List<Integer> tempDate = new ArrayList<Integer>();
            tempDate.add(currDay);
            tempDate.add(currMonth);
            tempDate.add(currYear);
            tempDate.add(CURRENT_AGEID);
            tempDate = GameCalendar.forwardDays(tempDate, nTurnID - TURNID);
            return "" + CFG.gameAges.getYear(tempDate.get(2));
        }
        List<Integer> tempDate = new ArrayList<Integer>();
        tempDate.add(currDay);
        tempDate.add(currMonth);
        tempDate.add(currYear);
        tempDate.add(CURRENT_AGEID);
        tempDate = GameCalendar.backwardsDays(tempDate, TURNID - nTurnID);
        return "" + CFG.gameAges.getYear(tempDate.get(2));
    }

    public static void minusMonth() {
        try {
            if (--currMonth < 1) {
                currMonth = 12;
            }
            if (currDay > NUM_OF_DAYSIN_MONTH[currMonth - 1]) {
                currDay = NUM_OF_DAYSIN_MONTH[currMonth - 1];
            }
        }
        catch (IndexOutOfBoundsException ex) {
            currMonth = 1;
        }
    }

    public static void minusMonth_CreateEvent() {
        try {
            --CFG.eventsManager.iCreateEvent_Month;
            if (CFG.eventsManager.iCreateEvent_Month < 1) {
                CFG.eventsManager.iCreateEvent_Month = 12;
            }
            if (CFG.eventsManager.iCreateEvent_Day > NUM_OF_DAYSIN_MONTH[CFG.eventsManager.iCreateEvent_Month - 1]) {
                CFG.eventsManager.iCreateEvent_Day = NUM_OF_DAYSIN_MONTH[CFG.eventsManager.iCreateEvent_Month - 1];
            }
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.eventsManager.iCreateEvent_Month = 1;
        }
    }

    private static List<Integer> backwardsDays(List<Integer> tempDate, int nTurns) {
        try {
            block2: for (int i = 0; i < nTurns; ++i) {
                for (int nMinDays = CFG.gameAges.getAge_TurnDays(tempDate.get(3)); nMinDays > 0; nMinDays -= tempDate.get(0).intValue()) {
                    if (nMinDays < tempDate.get(0)) {
                        tempDate.set(0, tempDate.get(0) - nMinDays);
                        continue block2;
                    }
                    tempDate.set(1, tempDate.get(1) - 1);
                    if (tempDate.get(1) < 1) {
                        tempDate.set(1, 12);
                        tempDate.set(2, tempDate.get(2) - 1);
                        tempDate.set(3, CFG.gameAges.getAgeOfYear(tempDate.get(2)));
                    }
                    tempDate.set(0, NUM_OF_DAYSIN_MONTH[tempDate.get(1) - 1]);
                }
            }
        }
        catch (IndexOutOfBoundsException ex) {
            tempDate.set(1, 1);
        }
        return tempDate;
    }

    public static void nextDays(int numOfDays) {
        try {
            currDay += numOfDays;
            while (currDay > NUM_OF_DAYSIN_MONTH[currMonth - 1]) {
                currDay -= NUM_OF_DAYSIN_MONTH[currMonth - 1];
                if (++currMonth <= 12) continue;
                currMonth = 1;
                ++currYear;
            }
        }
        catch (IndexOutOfBoundsException ex) {
            currMonth = 1;
        }
        GameCalendar.updateAge();
    }

    public static void plusMonth() {
        try {
            if (++currMonth > 12) {
                currMonth = 1;
            }
            if (currDay > NUM_OF_DAYSIN_MONTH[currMonth - 1]) {
                currDay = NUM_OF_DAYSIN_MONTH[currMonth - 1];
            }
        }
        catch (IndexOutOfBoundsException ex) {
            currMonth = 1;
        }
    }

    public static void plusMonth_CreateEvent() {
        try {
            ++CFG.eventsManager.iCreateEvent_Month;
            if (CFG.eventsManager.iCreateEvent_Month > 12) {
                CFG.eventsManager.iCreateEvent_Month = 1;
            }
            if (CFG.eventsManager.iCreateEvent_Day > NUM_OF_DAYSIN_MONTH[CFG.eventsManager.iCreateEvent_Month - 1]) {
                CFG.eventsManager.iCreateEvent_Day = NUM_OF_DAYSIN_MONTH[CFG.eventsManager.iCreateEvent_Month - 1];
            }
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.eventsManager.iCreateEvent_Month = 1;
        }
    }

    public static void addYears(int numOfYears) {
        currYear += numOfYears;
        GameCalendar.updateAge();
    }

    public static int getTurn() {
        return TURNID;
    }

    private static List<Integer> forwardDays(List<Integer> tempDate, int nTurns) {
        try {
            for (int i = 0; i < nTurns; ++i) {
                tempDate.set(0, tempDate.get(0) + CFG.gameAges.getAge_TurnDays(tempDate.get(3)));
                while (tempDate.get(0) > NUM_OF_DAYSIN_MONTH[tempDate.get(1) - 1]) {
                    tempDate.set(0, tempDate.get(0) - NUM_OF_DAYSIN_MONTH[tempDate.get(1) - 1]);
                    tempDate.set(1, tempDate.get(1) + 1);
                    if (tempDate.get(1) <= 12) continue;
                    tempDate.set(1, 1);
                    tempDate.set(2, tempDate.get(2) + 1);
                    tempDate.set(3, CFG.gameAges.getAgeOfYear(tempDate.get(2)));
                }
            }
        }
        catch (IndexOutOfBoundsException ex) {
            tempDate.set(1, 1);
        }
        return tempDate;
    }

    public static final String getNumOfDatesByTurnID(int nTurnID) {
        if (nTurnID == TURNID) {
            return CFG.lang.get("DaysX", 0);
        }
        if (nTurnID > TURNID) {
            List<Integer> tempDate = new ArrayList<Integer>();
            tempDate.add(currDay);
            tempDate.add(currMonth);
            tempDate.add(currYear);
            tempDate.add(CURRENT_AGEID);
            tempDate = GameCalendar.forwardDays(tempDate, nTurnID - TURNID);
            return "" + tempDate.get(0) + " " + GameCalendar.getMonthName(tempDate.get(1)) + " " + CFG.gameAges.getYear(tempDate.get(2));
        }
        List<Integer> tempDate = new ArrayList<Integer>();
        tempDate.add(currDay);
        tempDate.add(currMonth);
        tempDate.add(currYear);
        tempDate.add(CURRENT_AGEID);
        tempDate = GameCalendar.backwardsDays(tempDate, TURNID - nTurnID);
        List<Integer> tempDateOut = GameCalendar.getNumOfDatesByTurnID(tempDate);
        return "" + (tempDateOut.get(2) > 0 ? CFG.lang.get("YearsX", tempDateOut.get(2)) + (tempDateOut.get(1) > 0 || tempDateOut.get(0) > 0 ? " " : "") : "") + (tempDateOut.get(1) > 0 ? CFG.lang.get("MonthsX", tempDateOut.get(1)) + (tempDateOut.get(0) > 0 ? " " : "") : "") + (tempDateOut.get(0) > 0 ? CFG.lang.get("DaysX", tempDateOut.get(0)) : "");
    }
}

