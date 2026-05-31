/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.RegroupArmy;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Province;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegroupArmy
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int fromProvinceID;
    public List<Integer> route = new ArrayList<Integer>();
    public int routeSize = 0;
    public long numOfUnits = 0L;
    public int iObsolete = 10;

    public RegroupArmy(int nCivID, int fromProvinceID, int toProvinceID) {
        this.buildRoute(nCivID, fromProvinceID, toProvinceID);
    }

    public boolean continueMovingArmy(int nCivID) {
        return true;
    }

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
        if (GameValues.gvInGame.USE_REGROUP_BUILD_PATH_2) {
            ArrayList<Integer> tP2;
            int i2;
            ArrayList<Boolean> wasBool = new ArrayList<Boolean>();
            for (int i3 = 0; i3 < CFG.core.getProvinSize(); ++i3) {
                wasBool.add(false);
            }
            wasBool.set(fromProvinceID, true);
            ArrayList<Integer> in = new ArrayList<Integer>();
            ArrayList<List<Integer>> inPath = new ArrayList<List<Integer>>();
            Province provinceA = CFG.core.getProv(fromProvinceID);
            for (i2 = 0; i2 < provinceA.getNeighProvincesSize(); ++i2) {
                if (!RegroupArmy.canBeUsedInPath(nCivID, provinceA.getNeighProvinces(i2), RegroupArmy.isFriendlyProvince(nCivID, toProvinceID), toProvinceID)) continue;
                in.add(CFG.core.getProv(provinceA.getNeighProvinces(i2)).getProvID());
                tP2 = new ArrayList<Integer>();
                tP2.add(CFG.core.getProv(provinceA.getNeighProvinces(i2)).getProvID());
                inPath.add(tP2);
                wasBool.set(CFG.core.getProv(provinceA.getNeighProvinces(i2)).getProvID(), true);
            }
            if (!provinceA.getSeaProv() && provinceA.getLvlOfPort() > 0) {
                for (i2 = 0; i2 < provinceA.getNeighSeaProvincesSize(); ++i2) {
                    in.add(CFG.core.getProv(provinceA.getNeighSeaProvinces(i2)).getProvID());
                    tP2 = new ArrayList();
                    tP2.add(CFG.core.getProv(provinceA.getNeighSeaProvinces(i2)).getProvID());
                    inPath.add(tP2);
                    wasBool.set(CFG.core.getProv(provinceA.getNeighSeaProvinces(i2)).getProvID(), true);
                }
            }
            for (i2 = 0; i2 < in.size(); ++i2) {
                if (CFG.core.getProv((Integer)in.get(i2)).getProvID() != toProvinceID) continue;
                this.setPath(fromProvinceID, toProvinceID, (List)inPath.get(i2), toProvinceID);
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
        for (i = 0; i < CFG.core.getProv(fromProvinceID).getNeighProvincesSize(); ++i) {
            if (!RegroupArmy.canBeUsedInPath(nCivID, CFG.core.getProv(fromProvinceID).getNeighProvinces(i), RegroupArmy.isFriendlyProvince(nCivID, toProvinceID), toProvinceID)) continue;
            in.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getProvID());
            tP = new ArrayList<Integer>();
            tP.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getProvID());
            inPath.add(tP);
            was.add(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getProvID());
            CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)fromProvinceID).getNeighProvinces((int)i)).getProvID()).wasInProv = true;
        }
        if (!CFG.core.getProv(fromProvinceID).getSeaProv() && CFG.core.getProv(fromProvinceID).getLvlOfPort() > 0) {
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

    public boolean buildPath2(int civID, List<Integer> in, List<List<Integer>> inPath, int from, int lookingFor, boolean forDirection, boolean landOnly, List<Boolean> wasBool, List<Integer> nIN, List<List<Integer>> nINPath) {
        try {
            nIN.clear();
            nINPath.clear();
            if (forDirection) {
                for (int i = 0; i < in.size(); ++i) {
                    ArrayList<Integer> tPL;
                    int j;
                    for (j = 0; j < CFG.core.getProv(in.get(i)).getNeighProvincesSize(); ++j) {
                        if (wasBool.get(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID()).booleanValue() || !RegroupArmy.canBeUsedInPath(civID, CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID(), RegroupArmy.isFriendlyProvince(civID, lookingFor), lookingFor)) continue;
                        if (CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID() == lookingFor) {
                            this.setPath(from, lookingFor, inPath.get(i), lookingFor);
                            return true;
                        }
                        nIN.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                        tPL = new ArrayList<Integer>((Collection)inPath.get(i));
                        tPL.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                        nINPath.add(tPL);
                        wasBool.set(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID(), true);
                    }
                    if (CFG.core.getProv(in.get(i)).getSeaProv() || CFG.core.getProv(in.get(i)).getLvlOfPort() <= 0) continue;
                    for (j = 0; j < CFG.core.getProv(in.get(i)).getNeighSeaProvincesSize(); ++j) {
                        if (wasBool.get(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID()).booleanValue()) continue;
                        if (CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID() == lookingFor) {
                            this.setPath(from, lookingFor, inPath.get(i), lookingFor);
                            return true;
                        }
                        nIN.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID());
                        tPL = new ArrayList(inPath.get(i));
                        tPL.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID());
                        nINPath.add(tPL);
                        wasBool.set(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID(), true);
                    }
                }
            } else {
                for (int i = 0; i < in.size(); ++i) {
                    ArrayList<Integer> tPL;
                    int j;
                    for (j = CFG.core.getProv(in.get(i)).getNeighProvincesSize() - 1; j >= 0; --j) {
                        if (wasBool.get(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID()).booleanValue() || !RegroupArmy.canBeUsedInPath(civID, CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID(), RegroupArmy.isFriendlyProvince(civID, lookingFor), lookingFor)) continue;
                        if (CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID() == lookingFor) {
                            this.setPath(from, lookingFor, inPath.get(i), lookingFor);
                            return true;
                        }
                        nIN.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                        tPL = new ArrayList<Integer>((Collection)inPath.get(i));
                        tPL.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID());
                        nINPath.add(tPL);
                        wasBool.set(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID(), true);
                    }
                    if (CFG.core.getProv(in.get(i)).getSeaProv() || CFG.core.getProv(in.get(i)).getLvlOfPort() <= 0) continue;
                    for (j = CFG.core.getProv(in.get(i)).getNeighSeaProvincesSize() - 1; j >= 0; --j) {
                        if (wasBool.get(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID()).booleanValue()) continue;
                        if (CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID() == lookingFor) {
                            this.setPath(from, lookingFor, inPath.get(i), lookingFor);
                            return true;
                        }
                        nIN.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID());
                        tPL = new ArrayList(inPath.get(i));
                        tPL.add(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID());
                        nINPath.add(tPL);
                        wasBool.set(CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighSeaProvinces(j)).getProvID(), true);
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
                if (!RegroupArmy.canBeUsedInPath(nCivID, CFG.core.getProv(CFG.core.getProv(in.get(i)).getNeighProvinces(j)).getProvID(), RegroupArmy.isFriendlyProvince(nCivID, lookingFor), lookingFor) || CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)in.get((int)i).intValue()).getNeighProvinces((int)j)).getProvID()).wasInProv) continue;
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
            if (CFG.core.getProv(in.get(i)).getSeaProv() || CFG.core.getProv(in.get(i)).getLvlOfPort() <= 0) continue;
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

    public final void clearWas(List<Integer> was) {
        for (int i = was.size() - 1; i >= 0; --i) {
            CFG.core.getProv((int)was.get((int)i).intValue()).wasInProv = false;
        }
    }

    public final void setPath(int p1, int p2, List<Integer> lPath, int toProvinceID) {
        for (int i = 0; i < lPath.size(); ++i) {
            this.route.add(lPath.get(i));
        }
        if (toProvinceID != this.route.get(this.route.size() - 1)) {
            this.route.add(toProvinceID);
        }
        this.routeSize = this.route.size();
        this.iObsolete = Math.max(10, (int)((float)this.routeSize * 1.5f + 1.0f));
    }

    public static final boolean isFriendlyProvince(int nCivID, int toProvinceID) {
        return CFG.core.getProv(toProvinceID).getCivId() == nCivID || CFG.core.getProv(toProvinceID).getSeaProv() || CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getAlliance() == CFG.core.getCiv(nCivID).getAlliance() || CFG.core.getCiv(nCivID).getPuppetOfCiv() == CFG.core.getProv(toProvinceID).getCivId() || CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getPuppetOfCiv() == nCivID || CFG.core.getMilitaryAccess(nCivID, CFG.core.getProv(toProvinceID).getCivId()) > 0;
    }

    public static boolean canBeUsedInPath(int nCivID, int nProvinceID, boolean moveToFriendlyProvince, int toProvinceID) {
        if (CFG.core.getProv(nProvinceID).getWastelandLvl() >= 0) {
            return false;
        }
        if (nCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.FOG_OF_WAR == 2 && !CFG.core.getProv(nProvinceID).getSeaProv() && nProvinceID != toProvinceID && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(nProvinceID)) {
            return false;
        }
        return CFG.core.getProv(nProvinceID).getCivId() == nCivID || CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getPuppetOfCiv() == nCivID || CFG.core.getCiv(nCivID).getPuppetOfCiv() == CFG.core.getProv(nProvinceID).getCivId() || !moveToFriendlyProvince && CFG.core.getProv(nProvinceID).getCivId() == 0 && !GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES && (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(nProvinceID)) || CFG.core.getProv(nProvinceID).getSeaProv() || CFG.core.getCiv(nCivID).getAlliance() > 0 && CFG.core.getCiv(nCivID).getAlliance() == CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getAlliance() || CFG.core.getMilitaryAccess(nCivID, CFG.core.getProv(nProvinceID).getCivId()) > 0 || !moveToFriendlyProvince && (int)CFG.core.getCivRelationOfCivB(nCivID, CFG.core.getProv(nProvinceID).getCivId()) == GameValues.gvDiplomacy.RELATION_AT_WAR;
    }

    public final int getFromProvinceID() {
        return this.fromProvinceID;
    }

    public final void setFromProvinceID(int iFromProvinceID) {
        this.fromProvinceID = iFromProvinceID;
    }

    public final long getNumOfUnits() {
        return this.numOfUnits;
    }

    public final void setNumOfUnits(long iNumOfUnits) {
        this.numOfUnits = iNumOfUnits;
    }

    public final int getRouteSize() {
        return this.routeSize;
    }

    public final int getRoute(int i) {
        return this.route.get(i);
    }

    public final void removeRoute(int i) {
        this.route.remove(i);
        this.routeSize = this.route.size();
    }

    public final int getToProvinceID() {
        return this.route.get(this.getRouteSize() - 1);
    }

    public final int getObsolate() {
        return this.iObsolete;
    }

    public final void updateObsolate() {
        --this.iObsolete;
    }
}

