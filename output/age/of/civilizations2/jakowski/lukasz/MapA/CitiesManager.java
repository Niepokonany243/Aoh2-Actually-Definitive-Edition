/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MapA;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Province;
import java.util.ArrayList;

public class CitiesManager {
    public static void updateCities() {
        for (int i = 1 + GameCalendar.TURNID % GameValues.gvUpdate.GAME_UPDATE_CITIES_LEVELS_ON_MAP; i < CFG.core.getCivsSize(); i += GameValues.gvUpdate.GAME_UPDATE_CITIES_LEVELS_ON_MAP) {
            CitiesManager.updateCities(i);
        }
    }

    public static void updateCitiesAll() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            CitiesManager.updateCities(i);
        }
    }

    public static void updateCities(int nCivID) {
        Province provinceI;
        int i;
        Civilization civ = CFG.core.getCiv(nCivID);
        int tempNumOfCities = (int)Math.ceil((float)(civ.getNumOfProvs() * CFG.settingsGD.PERCENTAGE_OF_CITIES_ON_MAP) / 100.0f);
        int tMaxPopulation = 1;
        ArrayList<Integer> tempProvinces = new ArrayList<Integer>();
        for (i = 0; i < civ.getNumOfProvs(); ++i) {
            tempProvinces.add(civ.getProvID(i));
            provinceI = CFG.core.getProv(civ.getProvID(i));
            provinceI.setDrawCitiesInProv(provinceI.getLvlOfPort() > 0 || provinceI.getLvlOfArmoury() > 0);
            if (provinceI.isOccupied() || (long)tMaxPopulation >= provinceI.getPop().getPops()) continue;
            tMaxPopulation = (int)provinceI.getPop().getPops();
        }
        for (i = 0; i < civ.getNumOfProvs(); ++i) {
            provinceI = CFG.core.getProv(civ.getProvID(i));
            for (int j = 0; j < provinceI.getCitSize(); ++j) {
                if (provinceI.getCit(j).getCityLevel() == CFG.getEditorCityLevel(0)) continue;
                provinceI.getCit(j).setCityLevel(CitiesManager.getLevelOfCity((float)tMaxPopulation, (float)provinceI.getPop().getPops(), j));
            }
        }
        for (int j = 0; j < tempNumOfCities; ++j) {
            int largestProvinceID = 0;
            long largestPopulation = CFG.core.getProv((Integer)tempProvinces.get(largestProvinceID)).getPop().getPops();
            int iSize = tempProvinces.size();
            for (int i2 = 1; i2 < iSize; ++i2) {
                if (largestPopulation >= CFG.core.getProv((Integer)tempProvinces.get(i2)).getPop().getPops()) continue;
                largestProvinceID = i2;
                largestPopulation = CFG.core.getProv((Integer)tempProvinces.get(i2)).getPop().getPops();
            }
            CFG.core.getProv((Integer)tempProvinces.get(largestProvinceID)).setDrawCitiesInProv(true);
            tempProvinces.remove(largestProvinceID);
        }
        if (civ.getCapitalProvID() >= 0) {
            CFG.core.getProv(civ.getCapitalProvID()).setDrawCitiesInProv(true);
        }
        tempProvinces.clear();
    }

    public static int getLevelOfCity(float nMaxPopulation, float nPopulation, int nCityID) {
        float nScore = nPopulation / nMaxPopulation;
        int out = 4;
        out = nScore >= 0.765f ? 1 : (nScore >= 0.575f ? 2 : (nScore >= 0.325f ? 3 : 4));
        return CFG.getEditorCityLevel(out);
    }

    public static void buildLevelsOfCities() {
        int i;
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            for (int j = 0; j < CFG.core.getProv(i).getCitSize(); ++j) {
                CFG.core.getProv(i).getCit(j).setCityLevel(CFG.getEditorCityLevel(4));
            }
        }
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            CitiesManager.buildLevelsOfCities(i);
        }
    }

    public static void buildLevelsOfCities(int nCivID) {
        int i;
        long tMaxPop = 0L;
        for (i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            if (tMaxPop >= CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getPop().getPops()) continue;
            tMaxPop = CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getPop().getPops();
        }
        for (i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getCitSize(); ++j) {
                CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getCit(j).setCityLevel(CFG.getCityLevel_Population((float)tMaxPop, (float)CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getPop().getPops(), j));
            }
        }
        try {
            if (CFG.core.getCiv(nCivID).getCapitalProvID() >= 0 && CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getCitSize() > 0) {
                CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getCit(0).setCityLevel(CFG.getEditorCityLevel(0));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }
}

