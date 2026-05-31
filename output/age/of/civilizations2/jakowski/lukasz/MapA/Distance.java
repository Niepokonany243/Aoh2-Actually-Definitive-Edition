/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MapA;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Province;

public class Distance {
    public static float getDistanceFromCapital(int nCapital, int toProvinceID) {
        try {
            Province provinceTo = CFG.core.getProv(toProvinceID);
            Province provinceCapital = CFG.core.getProv(nCapital);
            if (CFG.map.getIsMapWorldMap(CFG.map.getActiveMapIDN())) {
                return Math.min(Math.min((float)Math.sqrt(Math.pow(provinceTo.getCeXR() + CFG.map.getMpB().getWidthReal() - provinceCapital.getCeXR(), 2.0) + Math.pow(provinceTo.getCeYR() - provinceCapital.getCeYR(), 2.0)), (float)Math.sqrt(Math.pow(provinceTo.getCeXR() - (provinceCapital.getCeXR() + CFG.map.getMpB().getWidthReal()), 2.0) + Math.pow(provinceTo.getCeYR() - provinceCapital.getCeYR(), 2.0))), (float)Math.sqrt(Math.pow(provinceTo.getCeXR() - provinceCapital.getCeXR(), 2.0) + Math.pow(provinceTo.getCeYR() - provinceCapital.getCeYR(), 2.0)));
            }
            return (float)Math.sqrt(Math.pow(provinceTo.getCeXR() - provinceCapital.getCeXR(), 2.0) + Math.pow(provinceTo.getCeYR() - provinceCapital.getCeYR(), 2.0));
        }
        catch (Exception ex) {
            return CFG.map.getMpB().getMaxDistance();
        }
    }

    public static float getDistanceFromCapital_PercOfMax(int nCapital, int toProvinceID) {
        return Distance.getDistanceFromCapital(nCapital, toProvinceID) / (float)CFG.map.getMpB().getMaxDistance();
    }

    public static float getDistanceFromAToB_PercOfMax(int nProvinceA, int nProvinceB) {
        return Distance.getDistanceFromCapital(nProvinceA, nProvinceB) / (float)CFG.map.getMpB().getMaxDistance();
    }

    public static float getManhattanDistance(int provA, int provB) {
        Province provinceA = CFG.core.getProv(provA);
        Province provinceB = CFG.core.getProv(provB);
        int xDifference = Math.abs(provinceA.getCeXR() - provinceB.getCeXR());
        int yDifference = Math.abs(provinceA.getCeYR() - provinceB.getCeYR());
        return Math.min(xDifference + yDifference, Math.abs(provinceA.getCeXR() + CFG.map.getMpB().getWidthReal() - provinceB.getCeXR()) + Math.abs(provinceA.getCeYR() - provinceB.getCeYR()));
    }

    public static float getManhattanDistance_PercOfMax(int provA, int provB) {
        Province provinceA = CFG.core.getProv(provA);
        Province provinceB = CFG.core.getProv(provB);
        int xDifference = Math.abs(provinceA.getCeXR() - provinceB.getCeXR());
        int yDifference = Math.abs(provinceA.getCeYR() - provinceB.getCeYR());
        return (float)Math.min(xDifference + yDifference, Math.abs(provinceA.getCeXR() + CFG.map.getMpB().getWidthReal() - provinceB.getCeXR()) + Math.abs(provinceA.getCeYR() - provinceB.getCeYR())) / (float)CFG.map.getMpB().getMaxDistance();
    }
}

