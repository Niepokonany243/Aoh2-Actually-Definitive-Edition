
package age.of.civilizations2.jakowski.lukasz.RegroupArmy;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Province;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        return bfsFindPath(civID, from, lookingFor, in, false, null, true);
    }

    public boolean buildPath(int nCivID, List<Integer> was, List<Integer> in, List<List<Integer>> inPath, int from, int lookingFor) {
        return bfsFindPath(nCivID, from, lookingFor, in, true, was, false);
    }

    /**
     * Iterative level-synchronous BFS with parent pointers. Replaces the old
     * recursive implementation that copied the entire path list for every
     * expanded neighbor (O(n^2) allocation) and could recurse into a
     * StackOverflowError. Behavior is preserved: the same first-discovered
     * shortest path is returned, and neighbor-iteration direction (forward /
     * backward per level) is replicated for the legacy toggle semantics.
     */
    private boolean bfsFindPath(int nCivID, int from, int lookingFor, List<Integer> initFrontier,
                                boolean useWasInProv, List<Integer> was, boolean toggleDirection) {
        int n = CFG.core.getProvinSize();
        if (n <= 0) return false;
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        java.util.Arrays.fill(parent, -2);

        ArrayList<Integer> frontier = new ArrayList<Integer>(initFrontier.size());
        for (int i = 0; i < initFrontier.size(); ++i) {
            int id = initFrontier.get(i);
            if (id < 0 || id >= n) continue;
            if (parent[id] != -2) continue; // already visited (e.g. from)
            parent[id] = from;
            visited[id] = true;
            if (useWasInProv) { CFG.core.getProv(id).wasInProv = true; was.add(id); }
            frontier.add(id);
        }
        if (from >= 0 && from < n) {
            visited[from] = true;
            parent[from] = -2;
            if (useWasInProv && !was.contains(from)) { CFG.core.getProv(from).wasInProv = true; was.add(from); }
        }

        if (from == lookingFor) {
            this.route.clear();
            this.route.add(lookingFor);
            this.routeSize = this.route.size();
            this.iObsolete = Math.max(10, (int)(this.routeSize * 1.5f + 1.0f));
            if (useWasInProv) clearWas(was);
            return true;
        }
        if (visited[lookingFor]) {
            return finishPath(from, lookingFor, parent, useWasInProv, was);
        }

        boolean forward = toggleDirection;
        ArrayList<Integer> next = new ArrayList<Integer>();
        while (!frontier.isEmpty()) {
            next.clear();
            for (int fi = 0; fi < frontier.size(); ++fi) {
                int pid = frontier.get(fi);
                if (pid < 0 || pid >= n) continue;
                Province p = CFG.core.getProv(pid);

                int nSize = p.getNeighProvincesSize();
                int jStart = forward ? 0 : nSize - 1;
                int jEnd = forward ? nSize : -1;
                int jStep = forward ? 1 : -1;
                for (int j = jStart; j != jEnd; j += jStep) {
                    int v = p.getNeighProvinces(j);
                    if (v < 0 || v >= n || visited[v]) continue;
                    if (!RegroupArmy.canBeUsedInPath(nCivID, v, RegroupArmy.isFriendlyProvince(nCivID, lookingFor), lookingFor)) continue;
                    parent[v] = pid;
                    visited[v] = true;
                    if (v == lookingFor) return finishPath(from, lookingFor, parent, useWasInProv, was);
                    if (useWasInProv) { CFG.core.getProv(v).wasInProv = true; was.add(v); }
                    next.add(v);
                }

                if (p.getSeaProv() || p.getLvlOfPort() <= 0) continue;
                int nSeaSize = p.getNeighSeaProvincesSize();
                int sStart = forward ? 0 : nSeaSize - 1;
                int sEnd = forward ? nSeaSize : -1;
                int sStep = forward ? 1 : -1;
                for (int j = sStart; j != sEnd; j += sStep) {
                    int v = p.getNeighSeaProvinces(j);
                    if (v < 0 || v >= n || visited[v]) continue;
                    parent[v] = pid;
                    visited[v] = true;
                    if (v == lookingFor) return finishPath(from, lookingFor, parent, useWasInProv, was);
                    if (useWasInProv) { CFG.core.getProv(v).wasInProv = true; was.add(v); }
                    next.add(v);
                }
            }
            ArrayList<Integer> tmp = frontier;
            frontier = next;
            next = tmp;
            forward = !forward;
        }

        if (useWasInProv) clearWas(was);
        return false;
    }

    private boolean finishPath(int from, int lookingFor, int[] parent, boolean useWasInProv, List<Integer> was) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        int cur = lookingFor;
        path.add(cur);
        while (cur != from && cur >= 0 && parent[cur] != -2) {
            cur = parent[cur];
            path.add(cur);
        }
        Collections.reverse(path);
        this.route.clear();
        for (int i = 1; i < path.size(); ++i) {
            this.route.add(path.get(i));
        }
        this.routeSize = this.route.size();
        this.iObsolete = Math.max(10, (int)(this.routeSize * 1.5f + 1.0f));
        if (useWasInProv) clearWas(was);
        return true;
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
        Province p = CFG.core.getProv(toProvinceID);
        int pCivId = p.getCivId();
        return pCivId == nCivID || p.getSeaProv() || CFG.core.getCiv(pCivId).getAlliance() > 0 && CFG.core.getCiv(pCivId).getAlliance() == CFG.core.getCiv(nCivID).getAlliance() || CFG.core.getCiv(nCivID).getPuppetOfCiv() == pCivId || CFG.core.getCiv(pCivId).getPuppetOfCiv() == nCivID || CFG.core.getMilitaryAccess(nCivID, pCivId) > 0;
    }

    public static boolean canBeUsedInPath(int nCivID, int nProvinceID, boolean moveToFriendlyProvince, int toProvinceID) {
        Province p = CFG.core.getProv(nProvinceID);
        if (p.getWastelandLvl() >= 0) {
            return false;
        }
        if (nCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.FOG_OF_WAR == 2 && !p.getSeaProv() && nProvinceID != toProvinceID && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(nProvinceID)) {
            return false;
        }
        int pCivId = p.getCivId();
        return pCivId == nCivID || CFG.core.getCiv(pCivId).getPuppetOfCiv() == nCivID || CFG.core.getCiv(nCivID).getPuppetOfCiv() == pCivId || !moveToFriendlyProvince && pCivId == 0 && !GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES && (CFG.FOG_OF_WAR != 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(nProvinceID)) || p.getSeaProv() || CFG.core.getCiv(nCivID).getAlliance() > 0 && CFG.core.getCiv(nCivID).getAlliance() == CFG.core.getCiv(pCivId).getAlliance() || CFG.core.getMilitaryAccess(nCivID, pCivId) > 0 || !moveToFriendlyProvince && (int)CFG.core.getCivRelationOfCivB(nCivID, pCivId) == GameValues.gvDiplomacy.RELATION_AT_WAR;
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

