/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.RegroupArmy;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Province;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegroupArmy_Migrate
extends RegroupArmy {
    public RegroupArmy_Migrate(int nCivID, int fromProvinceID, int toProvinceID) {
        super(nCivID, fromProvinceID, toProvinceID);
    }

    @Override
    public final boolean buildRoute(int nCivID, int fromProvinceID, int toProvinceID) {
        this.route.clear();
        this.fromProvinceID = fromProvinceID;
        if (fromProvinceID < 0 || toProvinceID < 0 || CFG.core.getProv(toProvinceID).getWastelandLvl() >= 0) {
            return false;
        }
        if (!CFG.core.getProv(fromProvinceID).getSeaProv() && CFG.core.getProv(fromProvinceID).getNeighProvincesSize() == 0 && CFG.core.getProv(fromProvinceID).getLvlOfPort() <= 0) {
            return false;
        }
        if (GameValues.gvInGame.USE_REGROUP_BUILD_PATH_2) {
            ArrayList<Integer> tP;
            int i;
            ArrayList<Boolean> wasBool = new ArrayList<Boolean>();
            for (int i2 = 0; i2 < CFG.core.getProvinSize(); ++i2) {
                wasBool.add(false);
            }
            wasBool.set(fromProvinceID, true);
            ArrayList<Integer> in = new ArrayList<Integer>();
            ArrayList<List<Integer>> inPath = new ArrayList<List<Integer>>();
            Province provinceA = CFG.core.getProv(fromProvinceID);
            for (i = 0; i < provinceA.getNeighProvincesSize(); ++i) {
                if (!RegroupArmy_Migrate.canBeUsedInPath(nCivID, provinceA.getNeighProvinces(i), RegroupArmy_Migrate.isFriendlyProvince(nCivID, toProvinceID), toProvinceID)) continue;
                in.add(CFG.core.getProv(provinceA.getNeighProvinces(i)).getProvID());
                tP = new ArrayList<Integer>();
                tP.add(CFG.core.getProv(provinceA.getNeighProvinces(i)).getProvID());
                inPath.add(tP);
                wasBool.set(CFG.core.getProv(provinceA.getNeighProvinces(i)).getProvID(), true);
            }
            if (!provinceA.getSeaProv() && provinceA.getLvlOfPort() > 0) {
                for (i = 0; i < provinceA.getNeighSeaProvincesSize(); ++i) {
                    in.add(CFG.core.getProv(provinceA.getNeighSeaProvinces(i)).getProvID());
                    tP = new ArrayList();
                    tP.add(CFG.core.getProv(provinceA.getNeighSeaProvinces(i)).getProvID());
                    inPath.add(tP);
                    wasBool.set(CFG.core.getProv(provinceA.getNeighSeaProvinces(i)).getProvID(), true);
                }
            }
            for (i = 0; i < in.size(); ++i) {
                if (CFG.core.getProv((Integer)in.get(i)).getProvID() != toProvinceID) continue;
                this.setPath(fromProvinceID, toProvinceID, (List)inPath.get(i), toProvinceID);
                return true;
            }
            ArrayList<Integer> nIN = new ArrayList<Integer>();
            ArrayList<List<Integer>> nINPath = new ArrayList<List<Integer>>();
            return this.buildPath2(nCivID, in, inPath, fromProvinceID, toProvinceID, true, false, wasBool, nIN, nINPath);
        }
        ArrayList<Integer> was = new ArrayList<Integer>();
        was.add(fromProvinceID);
        CFG.core.getProv((int)fromProvinceID).wasInProv = true;
        ArrayList<Integer> in = new ArrayList<Integer>();
        ArrayList<List<Integer>> inPath = new ArrayList<List<Integer>>();
        for (int i = 0; i < CFG.core.getProv(fromProvinceID).getNeighProvincesSize(); ++i) {
            if (CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getCivId() != 0) continue;
            in.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getProvID());
            ArrayList<Integer> tP = new ArrayList<Integer>();
            tP.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getProvID());
            inPath.add(tP);
            was.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getProvID());
            CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)fromProvinceID).getNeighProvinces((int)i)).getProvID()).wasInProv = true;
        }
        this.buildPath(nCivID, was, in, inPath, fromProvinceID, toProvinceID);
        return true;
    }

    @Override
    public boolean buildPath2(int civID, List<Integer> in, List<List<Integer>> inPath, int from, int lookingFor, boolean forDirection, boolean landOnly, List<Boolean> wasBool, List<Integer> nIN, List<List<Integer>> nINPath) {
        try {
            nIN.clear();
            nINPath.clear();
            if (forDirection) {
                for (int i = 0; i < in.size(); ++i) {
                    for (int j = 0; j < CFG.core.getProv(in.get(i)).getNeighProvincesSize(); ++j) {
                        if (wasBool.get(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID()).booleanValue() || !RegroupArmy_Migrate.canBeUsedInPath(civID, CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID(), RegroupArmy_Migrate.isFriendlyProvince(civID, lookingFor), lookingFor)) continue;
                        if (CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID() == lookingFor) {
                            this.setPath(from, lookingFor, inPath.get(i), lookingFor);
                            return true;
                        }
                        nIN.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                        ArrayList<Integer> tPL = new ArrayList<Integer>((Collection)inPath.get(i));
                        tPL.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                        nINPath.add(tPL);
                        wasBool.set(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID(), true);
                    }
                }
            } else {
                for (int i = 0; i < in.size(); ++i) {
                    for (int j = CFG.core.getProv(in.get(i)).getNeighProvincesSize() - 1; j >= 0; --j) {
                        if (wasBool.get(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID()).booleanValue() || !RegroupArmy_Migrate.canBeUsedInPath(civID, CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID(), RegroupArmy_Migrate.isFriendlyProvince(civID, lookingFor), lookingFor)) continue;
                        if (CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID() == lookingFor) {
                            this.setPath(from, lookingFor, inPath.get(i), lookingFor);
                            return true;
                        }
                        nIN.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                        ArrayList<Integer> tPL = new ArrayList<Integer>((Collection)inPath.get(i));
                        tPL.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                        nINPath.add(tPL);
                        wasBool.set(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID(), true);
                    }
                }
            }
            if (nIN.isEmpty()) {
                return false;
            }
        }
        catch (Exception ex) {
            return false;
        }
        try {
            return this.buildPath2(civID, nIN, nINPath, from, lookingFor, !forDirection, landOnly, wasBool, in, inPath);
        }
        catch (StackOverflowError ex) {
            return false;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean buildPath(int nCivID, List<Integer> was, List<Integer> in, List<List<Integer>> inPath, int from, int lookingFor) {
        int i;
        ArrayList<Integer> nIN = new ArrayList<Integer>();
        ArrayList<List<Integer>> nINPath = new ArrayList<List<Integer>>();
        for (i = 0; i < in.size(); ++i) {
            if (CFG.core.getProv(in.get(i)).getProvID() != lookingFor) continue;
            this.setPath(from, lookingFor, inPath.get(i), lookingFor);
            this.clearWas(was);
            return true;
        }
        for (i = 0; i < in.size(); ++i) {
            for (int j = 0; j < CFG.core.getProv(in.get(i)).getNeighProvincesSize(); ++j) {
                if (CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID()).getCivId() != 0 || CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighProvinces((int)j)).getProvID()).wasInProv) continue;
                if (CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID() == lookingFor) {
                    this.setPath(from, lookingFor, inPath.get(i), lookingFor);
                    this.clearWas(was);
                    return true;
                }
                nIN.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                ArrayList<Integer> tPL = new ArrayList<Integer>();
                for (int u = 0; u < inPath.get(i).size(); ++u) {
                    tPL.add(inPath.get(i).get(u));
                }
                tPL.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                nINPath.add(tPL);
                CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighProvinces((int)j)).getProvID()).wasInProv = true;
                was.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
            }
        }
        try {
            return this.buildPath(nCivID, was, nIN, nINPath, from, lookingFor);
        }
        catch (StackOverflowError ex) {
            this.clearWas(was);
            return false;
        }
    }
}

