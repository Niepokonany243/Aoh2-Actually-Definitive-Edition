/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Managers;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MapA.Distance;
import java.util.ArrayList;
import java.util.List;

public class RivalsManager {
    public static List<Integer> buildRivals(int civID, int rivalsLimit) {
        ArrayList<Integer> rivals = new ArrayList<Integer>();
        ArrayList<Float> distance = new ArrayList<Float>();
        for (int i = CFG.core.getCiv((int)civID).civsInRange.size() - 1; i >= 0; --i) {
            if (CFG.core.getCiv(CFG.core.getCiv((int)civID).civsInRange.get((int)i).iCivID).getNumOfProvs() <= 0) continue;
            rivals.add(CFG.core.getCiv((int)civID).civsInRange.get((int)i).iCivID);
            distance.add(Float.valueOf(CFG.core.getCiv((int)civID).civsInRange.get((int)i).fDistance));
        }
        if (rivals.size() <= rivalsLimit) {
            return rivals;
        }
        ArrayList<Integer> out = new ArrayList<Integer>();
        int iSize = distance.size();
        for (int i = 0; i < iSize; ++i) {
            float tDistance = Math.abs(CFG.core.getCiv(civID).getRankScore() - CFG.core.getCiv((Integer)rivals.get(i)).getRankScore());
            distance.set(i, Float.valueOf(tDistance * GameValues.gvAiRivals.RIVALS_SCORE_MIN + tDistance * GameValues.gvAiRivals.RIVALS_SCORE_DISTANCE * (((Float)distance.get(i)).floatValue() / CFG.gameAges.ages.get((int)GameCalendar.CURRENT_AGEID).RIVALS_DISTANCE)));
        }
        while (out.size() <= rivalsLimit && !rivals.isEmpty()) {
            int bestID = 0;
            int iSize2 = rivals.size();
            for (int i = 1; i < iSize2; ++i) {
                if (!(((Float)distance.get(i)).floatValue() < ((Float)distance.get(bestID)).floatValue())) continue;
                bestID = i;
            }
            out.add((Integer)rivals.get(bestID));
            rivals.remove(bestID);
            distance.remove(bestID);
        }
        return out;
    }

    public static boolean buildRivals_IsInDistance(int civID, int rivalID) {
        if (CFG.core.getCiv(rivalID).getNumOfProvs() <= 0) {
            return false;
        }
        try {
            if (Distance.getDistanceFromAToB_PercOfMax(CFG.core.getCiv(civID).getCapitalProvID(), CFG.core.getCiv(rivalID).getCapitalProvID()) > CFG.gameAges.ages.get((int)GameCalendar.CURRENT_AGEID).RIVALS_DISTANCE) {
                return false;
            }
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }

    public static float buildRivals_IsInDistance_Perc(int civID, int rivalID) {
        float distancePerc;
        if (CFG.core.getCiv(rivalID).getNumOfProvs() <= 0) {
            return -1.0f;
        }
        try {
            distancePerc = Distance.getManhattanDistance_PercOfMax(CFG.core.getCiv(civID).getCapitalProvID(), CFG.core.getCiv(rivalID).getCapitalProvID());
            if (distancePerc > CFG.gameAges.ages.get((int)GameCalendar.CURRENT_AGEID).RIVALS_DISTANCE) {
                return -1.0f;
            }
        }
        catch (Exception ex) {
            return -1.0f;
        }
        return distancePerc;
    }

    public static List<Integer> getRivaledBy(int civID) {
        int i;
        ArrayList<Integer> out = new ArrayList<Integer>();
        for (i = 1; i < civID; ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || !CFG.core.getCiv(i).isRival(civID)) continue;
            out.add(i);
        }
        for (i = civID + 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || !CFG.core.getCiv(i).isRival(civID)) continue;
            out.add(i);
        }
        return out;
    }

    public static List<Float> chooseRivals_BuildScore(int civID, List<Integer> rivals) {
        ArrayList<Float> out = new ArrayList<Float>();
        int iSize = rivals.size();
        for (int i = 0; i < iSize; ++i) {
            if (CFG.core.isAlly(civID, rivals.get(i))) {
                out.add(Float.valueOf(999333.0f + CFG.core.getCiv(civID).getRelationD(rivals.get(i))));
                continue;
            }
            if (CFG.core.getDefensivePact(civID, rivals.get(i)) > 0) {
                out.add(Float.valueOf(899999.0f + CFG.core.getCiv(civID).getRelationD(rivals.get(i))));
                continue;
            }
            float tScore = Math.abs(CFG.core.getCiv(civID).getRankScore() - CFG.core.getCiv(rivals.get(i)).getRankScore());
            out.add(Float.valueOf((tScore * GameValues.gvAiRivals.RIVALS_SCORE_MIN + tScore * GameValues.gvAiRivals.RIVALS_SCORE_DISTANCE * (Distance.getDistanceFromAToB_PercOfMax(CFG.core.getCiv(civID).getCapitalProvID(), CFG.core.getCiv(rivals.get(i)).getCapitalProvID()) / CFG.gameAges.ages.get((int)GameCalendar.CURRENT_AGEID).RIVALS_DISTANCE)) * (Math.max(0.0f, 1.0f - GameValues.gvAiRivals.AI_RIVALS_SCORE_RELATION) + GameValues.gvAiRivals.AI_RIVALS_SCORE_RELATION * RivalsManager.calculateScore(CFG.core.getCiv(civID).getRelationD(rivals.get(i))))));
        }
        return out;
    }

    public static float calculateScore(float value) {
        return (-0.5f * value + 50.0f) / 100.0f;
    }
}

