
package age.of.civilizations2.jakowski.lukasz.AI.FrontLine;

import age.of.civilizations2.jakowski.lukasz.CFG;

public class AI_FrontLine_War {
    public int i;
    public long iFrontArmy = 0L;
    public int iNeighboringProvincesLostScore;

    public AI_FrontLine_War(int nCivID, int i) {
        this.i = i;
        this.iFrontArmy = this.getFrontLineArmy(nCivID);
        this.iNeighboringProvincesLostScore = this.getNeighboringProvincesLostScore(nCivID);
    }

    public final int getWithCivID(int nCivID) {
        return CFG.core.getCiv(nCivID).lFrontLines.get(this.i).iWithCivID;
    }

    public final int getEnemyRating(int nCivID, int withCivID) {
        return (int)((float)CFG.core.getCiv(withCivID).getNumberOfUnits() * 1.125f);
    }

    public final int getFrontScore(int nCivID) {
        return 0 + this.iNeighboringProvincesLostScore + (CFG.core.getCiv(nCivID).getNumberOfUnits() < (long)this.getEnemyRating(nCivID, this.getWithCivID(nCivID)) ? 20 : 0);
    }

    public final long getFrontLineArmy(int nCivID) {
        return CFG.core.getCiv(nCivID).lFrontLines.get(this.i).getFrontLineArmy(nCivID);
    }

    public boolean canRecruitArmy_FrontLine(int nCivID) {
        for (int j = CFG.core.getCiv(nCivID).lFrontLines.get(this.i).lProvinces.size() - 1; j >= 0; --j) {
            if (CFG.core.getProv(CFG.core.getCiv(nCivID).lFrontLines.get(this.i).lProvinces.get(j)).isOccupied()) continue;
            return true;
        }
        return false;
    }

    public final int getImportance_OurRegion(int nCivID) {
        try {
            return CFG.core.getProv(CFG.core.getCiv((int)nCivID).lFrontLines.get((int)this.i).lProvinces.get(0)).getPotentialRegion();
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
            return 0;
        }
    }

    public final int getImportance_Region_NumOfProvinces(int nCivID) {
        try {
            for (int j = CFG.core.getProv(CFG.core.getCiv((int)nCivID).lFrontLines.get((int)this.i).lProvinces.get(0)).getNeighProvincesSize(); j >= 0; --j) {
                if (CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv((int)nCivID).lFrontLines.get((int)this.i).lProvinces.get(0)).getNeighProvinces(j)).getCivId() != this.getWithCivID(nCivID)) continue;
                return CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv((int)nCivID).lFrontLines.get((int)this.i).lProvinces.get(0)).getNeighProvinces(j)).getRegion_NumOfProvinces();
            }
            return CFG.core.getProv(CFG.core.getCiv((int)nCivID).lFrontLines.get((int)this.i).lProvinces.get(0)).getRegion_NumOfProvinces();
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
            return 0;
        }
    }

    public final int getEnemyRegion_Potential(int nCivID) {
        try {
            for (int j = CFG.core.getProv(CFG.core.getCiv((int)nCivID).lFrontLines.get((int)this.i).lProvinces.get(0)).getNeighProvincesSize(); j >= 0; --j) {
                if (CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv((int)nCivID).lFrontLines.get((int)this.i).lProvinces.get(0)).getNeighProvinces(j)).getCivId() != this.getWithCivID(nCivID)) continue;
                return CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv((int)nCivID).lFrontLines.get((int)this.i).lProvinces.get(0)).getNeighProvinces(j)).getPotentialRegion();
            }
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
            return 1;
        }
        return 1;
    }

    public final int getEnemyRegion_NumOfProvinces(int nCivID) {
        try {
            for (int j = CFG.core.getProv(CFG.core.getCiv((int)nCivID).lFrontLines.get((int)this.i).lProvinces.get(0)).getNeighProvincesSize(); j >= 0; --j) {
                if (CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv((int)nCivID).lFrontLines.get((int)this.i).lProvinces.get(0)).getNeighProvinces(j)).getCivId() != this.getWithCivID(nCivID)) continue;
                return CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv((int)nCivID).lFrontLines.get((int)this.i).lProvinces.get(0)).getNeighProvinces(j)).getRegion_NumOfProvinces();
            }
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
            return 1;
        }
        return 1;
    }

    public final int getEnemyRegion_NumOfRegions(int nCivID) {
        try {
            return CFG.core.getCiv(this.getWithCivID(nCivID)).getCivRegionsSize();
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
            return 1;
        }
    }

    public final int getNeighboringProvincesLostScore(int nCivID) {
        int out = 0;
        for (int j = CFG.core.getCiv(nCivID).lFrontLines.get(this.i).lProvinces.size() - 1; j >= 0; --j) {
            if (CFG.core.getProv(CFG.core.getCiv(nCivID).lFrontLines.get(this.i).lProvinces.get(j)).getNeighProvinceOfCivWasLost() <= 0) continue;
            ++out;
        }
        return out;
    }
}

