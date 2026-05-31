
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import java.util.ArrayList;

public class ColonizationManager {
    public static void autoExpand(int fromProvinceID) {
        if (CFG.oR.nextInt(100) < CFG.COLONIZATION_AUTO_EXPAND_CHANCE) {
            try {
                ArrayList<Integer> possibleExpand = new ArrayList<Integer>();
                for (int i = 0; i < CFG.core.getProv(fromProvinceID).getNeighProvincesSize(); ++i) {
                    if (CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getCivId() != 0 || CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getWastelandLvl() >= 0 || CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getSeaProv()) continue;
                    possibleExpand.add(CFG.core.getProv(fromProvinceID).getNeighProvinces(i));
                }
                if (!possibleExpand.isEmpty()) {
                    int i;
                    ArrayList<Integer> possibleScore = new ArrayList<Integer>();
                    int bestID = 0;
                    for (i = 0; i < possibleExpand.size(); ++i) {
                        int score = 0;
                        boolean isLastNeutral = true;
                        for (int j = 0; j < CFG.core.getProv((Integer)possibleExpand.get(i)).getNeighProvincesSize(); ++j) {
                            if (CFG.core.getProv(CFG.core.getProv((Integer)possibleExpand.get(i)).getNeighProvinces(j)).getCivId() == CFG.core.getProv(fromProvinceID).getCivId()) {
                                score += 10;
                                continue;
                            }
                            if (CFG.core.getProv(CFG.core.getProv((Integer)possibleExpand.get(i)).getNeighProvinces(j)).getCivId() != 0) continue;
                            isLastNeutral = false;
                        }
                        if (isLastNeutral) {
                            score += 500;
                        }
                        possibleScore.add(score);
                    }
                    for (i = 1; i < possibleExpand.size(); ++i) {
                        if ((Integer)possibleScore.get(bestID) >= (Integer)possibleScore.get(i)) continue;
                        bestID = i;
                    }
                    GameManager.colonizeProvince((Integer)possibleExpand.get(bestID), CFG.core.getProv(fromProvinceID).getCivId(), true);
                }
                possibleExpand.clear();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }
}

