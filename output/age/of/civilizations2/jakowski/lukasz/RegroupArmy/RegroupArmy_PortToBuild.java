/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.RegroupArmy;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;
import java.util.ArrayList;
import java.util.List;

public class RegroupArmy_PortToBuild
extends RegroupArmy {
    public RegroupArmy_PortToBuild(int nCivID, int fromProvinceID, int toProvinceID) {
        super(nCivID, fromProvinceID, toProvinceID);
    }

    @Override
    public boolean buildRoute(int nCivID, int fromProvinceID, int toProvinceID) {
        ArrayList<Integer> tP;
        int i;
        this.route.clear();
        this.fromProvinceID = fromProvinceID;
        if (fromProvinceID < 0 || toProvinceID < 0 || CFG.core.getProv(toProvinceID).getWastelandLvl() >= 0) {
            return false;
        }
        if (!CFG.core.getProv(fromProvinceID).getSeaProv() && CFG.core.getProv(fromProvinceID).getNeighProvincesSize() == 0 && CFG.core.getProv(fromProvinceID).getLvlOfPort() <= 0) {
            return false;
        }
        ArrayList<Integer> was = new ArrayList<Integer>();
        was.add(fromProvinceID);
        CFG.core.getProv((int)fromProvinceID).wasInProv = true;
        ArrayList<Integer> in = new ArrayList<Integer>();
        ArrayList<List<Integer>> inPath = new ArrayList<List<Integer>>();
        for (i = 0; i < CFG.core.getProv(fromProvinceID).getNeighProvincesSize(); ++i) {
            if (!RegroupArmy_PortToBuild.canBeUsedInPath(nCivID, CFG.core.getProv(fromProvinceID).getNeighProvinces(i), RegroupArmy_PortToBuild.isFriendlyProvince(nCivID, toProvinceID), toProvinceID)) continue;
            in.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getProvID());
            tP = new ArrayList<Integer>();
            tP.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getProvID());
            inPath.add(tP);
            was.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getProvID());
            CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)fromProvinceID).getNeighProvinces((int)i)).getProvID()).wasInProv = true;
        }
        if (!CFG.core.getProv(fromProvinceID).getSeaProv()) {
            for (i = 0; i < CFG.core.getProv(fromProvinceID).getNeighSeaProvincesSize(); ++i) {
                in.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighSeaProvinces(i)).getProvID());
                tP = new ArrayList();
                tP.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighSeaProvinces(i)).getProvID());
                inPath.add(tP);
                was.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighSeaProvinces(i)).getProvID());
                CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)fromProvinceID).getNeighSeaProvinces((int)i)).getProvID()).wasInProv = true;
            }
        }
        this.buildPath(nCivID, was, in, inPath, fromProvinceID, toProvinceID);
        return true;
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
            int u;
            ArrayList<Integer> tPL;
            int j;
            for (j = 0; j < CFG.core.getProv(in.get(i)).getNeighProvincesSize(); ++j) {
                if (!RegroupArmy_PortToBuild.canBeUsedInPath(nCivID, CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID(), RegroupArmy_PortToBuild.isFriendlyProvince(nCivID, lookingFor), lookingFor) || CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighProvinces((int)j)).getProvID()).wasInProv) continue;
                if (CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID() == lookingFor) {
                    this.setPath(from, lookingFor, inPath.get(i), lookingFor);
                    this.clearWas(was);
                    return true;
                }
                nIN.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                tPL = new ArrayList<Integer>();
                for (u = 0; u < inPath.get(i).size(); ++u) {
                    tPL.add(inPath.get(i).get(u));
                }
                tPL.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                nINPath.add(tPL);
                CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighProvinces((int)j)).getProvID()).wasInProv = true;
                was.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
            }
            if (CFG.core.getProv(in.get(i)).getSeaProv()) continue;
            for (j = 0; j < CFG.core.getProv(in.get(i)).getNeighSeaProvincesSize(); ++j) {
                if (CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighSeaProvinces((int)j)).getProvID()).wasInProv) continue;
                if (CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID() == lookingFor) {
                    this.setPath(from, lookingFor, inPath.get(i), lookingFor);
                    this.clearWas(was);
                    return true;
                }
                nIN.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID());
                tPL = new ArrayList();
                for (u = 0; u < inPath.get(i).size(); ++u) {
                    tPL.add(inPath.get(i).get(u));
                }
                tPL.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID());
                nINPath.add(tPL);
                CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighSeaProvinces((int)j)).getProvID()).wasInProv = true;
                was.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID());
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

