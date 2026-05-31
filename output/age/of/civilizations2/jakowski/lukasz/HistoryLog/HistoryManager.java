/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.HistoryLog;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    public static List<String> lHistoryDates = new ArrayList<String>();
    public static List<Integer> lHistoryDatesWidth = new ArrayList<Integer>();
    public static int HISTORY_LIMIT = 200;

    public HistoryManager() {
        CFG.timelapseManager.timelapseStatsHistory.lHistory = new ArrayList<List<HistoryLog>>();
        this.addNewTurn();
        HistoryLog.ICON_WIDTH = (int)((float)IMGManager.getIMG(Images.diploWar).getWidth() * HistoryLog.getImageScale(Images.diploWar));
        if (HistoryLog.ICON_WIDTH < (int)((float)IMGManager.getIMG(Images.diploWar).getWidth() * HistoryLog.getImageScale(Images.diploTruce))) {
            HistoryLog.ICON_WIDTH = (int)((float)IMGManager.getIMG(Images.diploWar).getWidth() * HistoryLog.getImageScale(Images.diploTruce));
        }
        if (HistoryLog.ICON_WIDTH < (int)((float)IMGManager.getIMG(Images.diploWar).getWidth() * HistoryLog.getImageScale(Images.diploAlliance))) {
            HistoryLog.ICON_WIDTH = (int)((float)IMGManager.getIMG(Images.diploWar).getWidth() * HistoryLog.getImageScale(Images.diploAlliance));
        }
        for (int i = 0; i < CFG.ideologiesMgr.getIdeologiesSize(); ++i) {
            if (HistoryLog.ICON_WIDTH >= (int)((float)CFG.ideologiesMgr.getIdeologyID(i).getiCrownVassalImage().getWidth() * HistoryLog.getImageScale_CrownVassal(i))) continue;
            HistoryLog.ICON_WIDTH = (int)((float)CFG.ideologiesMgr.getIdeologyID(i).getiCrownVassalImage().getWidth() * HistoryLog.getImageScale_CrownVassal(i));
        }
        HistoryLog.ICON_WIDTH += CFG.PADD * 3;
        HISTORY_LIMIT = CFG.getIsDesktop() ? 200 : 50;
        this.clearHistory();
    }

    public final void updateLanguage() {
        try {
            synchronized (HistoryManager.class) {
                for (int i = 0; i < CFG.timelapseManager.timelapseStatsHistory.lHistory.size(); ++i) {
                    List<HistoryLog> turnHistory = CFG.timelapseManager.timelapseStatsHistory.lHistory.get(i);
                    if (turnHistory != null) {
                        for (int j = 0; j < turnHistory.size(); ++j) {
                            turnHistory.get(j).updateLanguage();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void buildHistoryDates() {
        int i;
        HistoryManager.clearHistoryDates();
        for (i = 1; i < GameCalendar.TURNID; ++i) {
            lHistoryDates.add(GameCalendar.getDate_ByTurnID(i));
        }
        lHistoryDates.add(GameCalendar.getCurrDate());
        int iSize = lHistoryDates.size();
        for (i = 0; i < iSize; ++i) {
            CFG.glyphLay.setText(CFG.fontMain.get(0), lHistoryDates.get(i) + ": ");
            lHistoryDatesWidth.add((int)(CFG.glyphLay.width * 0.7f));
        }
    }

    public static final void clearHistoryDates() {
        lHistoryDates.clear();
        lHistoryDatesWidth.clear();
    }

    public final boolean haveHistory() {
        synchronized (HistoryManager.class) {
            for (int i = 0; i < CFG.timelapseManager.timelapseStatsHistory.lHistory.size(); ++i) {
                if (CFG.timelapseManager.timelapseStatsHistory.lHistory.get(i).size() <= 0) continue;
                return true;
            }
        }
        return false;
    }

    public final void addNewTurn() {
        synchronized (HistoryManager.class) {
            ArrayList<HistoryLog> turnHistory = new ArrayList<>();
            CFG.timelapseManager.timelapseStatsHistory.lHistory.add(turnHistory);
            if (CFG.timelapseManager.timelapseStatsHistory.lHistory.size() > HISTORY_LIMIT) {
                CFG.timelapseManager.timelapseStatsHistory.lHistory.remove(0);
            }
        }
    }

    public final void addHistoryLog(HistoryLog tHL) {
        synchronized (HistoryManager.class) {
            try {
                CFG.timelapseManager.timelapseStatsHistory.lHistory.get(CFG.timelapseManager.timelapseStatsHistory.lHistory.size() - 1).add(tHL);
                if (CFG.menus.getVisibleInGame_History()) {
                    CFG.menus.rebuildInGame_History();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public final void addHistory(int iTurnID, HistoryLog nHistory) {
        synchronized (HistoryManager.class) {
            try {
                if (iTurnID >= 0 && iTurnID < CFG.timelapseManager.timelapseStatsHistory.lHistory.size()) {
                    CFG.timelapseManager.timelapseStatsHistory.lHistory.get(iTurnID).add(nHistory);
                }
            } catch (Exception ex) {}
        }
    }

    public final HistoryLog getHistory(int iTurnID, int i) {
        synchronized (HistoryManager.class) {
            try {
                return CFG.timelapseManager.timelapseStatsHistory.lHistory.get(iTurnID).get(i);
            } catch (Exception ex) {
                return null;
            }
        }
    }

    public final void clearHistory() {
        synchronized (HistoryManager.class) {
            CFG.timelapseManager.timelapseStatsHistory.lHistory.clear();
        }
    }

    public final int getHistorySize() {
        synchronized (HistoryManager.class) {
            return CFG.timelapseManager.timelapseStatsHistory.lHistory.size();
        }
    }

    public final int getHistoryTurnSize(int iTurnID) {
        synchronized (HistoryManager.class) {
            try {
                return CFG.timelapseManager.timelapseStatsHistory.lHistory.get(iTurnID).size();
            } catch (Exception ex) {
                return 0;
            }
        }
    }
}
