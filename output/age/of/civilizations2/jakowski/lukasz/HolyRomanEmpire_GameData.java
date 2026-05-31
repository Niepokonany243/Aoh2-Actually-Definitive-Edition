
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HolyRomanEmpire_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private List<Integer> lProvinces = new ArrayList<Integer>();
    private int iProvincesSize = 0;
    public int iEmperorID = -1;
    private int iEmperorAuthority = 0;
    private List<Integer> lElectors = new ArrayList<Integer>();
    private int iElectorsSize = 0;
    private List<Integer> lPrinces = new ArrayList<Integer>();
    private int iPrincesSize = 0;
    public List<Integer> lVotesFor = new ArrayList<Integer>();
    private int iNextElectionsIn = 30;

    public final void updateHRE_AfterRemoveCivilization(int nCivID) {
        for (int i = 0; i < this.getPrincesSize(); ++i) {
            if (this.getPrince(i) == nCivID) {
                this.removePrince(nCivID);
                --i;
                continue;
            }
            if (this.getPrince(i) <= nCivID) continue;
            this.lPrinces.set(i, this.lPrinces.get(i) - 1);
        }
    }

    public final int getProvinces(int i) {
        return this.lProvinces.get(i);
    }

    public final boolean addProvince(int nProvinceID) {
        for (int i = 0; i < this.getProvincesSize(); ++i) {
            if (this.getProvinces(i) != nProvinceID) continue;
            return false;
        }
        this.lProvinces.add(nProvinceID);
        this.iProvincesSize = this.lProvinces.size();
        CFG.core.getProv(nProvinceID).setIsPartOfHolyRomanEmpire(true);
        return true;
    }

    public final boolean removeProvince(int nProvinceID) {
        for (int i = 0; i < this.getProvincesSize(); ++i) {
            if (this.getProvinces(i) != nProvinceID) continue;
            CFG.core.getProv(nProvinceID).setIsPartOfHolyRomanEmpire(false);
            this.lProvinces.remove(i);
            this.iProvincesSize = this.lProvinces.size();
            return true;
        }
        return false;
    }

    public final int getProvincesSize() {
        return this.iProvincesSize;
    }

    public final boolean getIsImperialProvince(int nProvinceID) {
        for (int i = 0; i < this.getPrincesSize(); ++i) {
            if (this.getProvinces(i) != nProvinceID) continue;
            return true;
        }
        return false;
    }

    public final int getPrince(int i) {
        if (i >= 0 && i < this.lPrinces.size()) {
            return this.lPrinces.get(i);
        }
        return -1;
    }

    public final void addPrince(int nCivID) {
        for (int i = 0; i < this.getPrincesSize(); ++i) {
            if (this.getPrince(i) != nCivID) continue;
            return;
        }
        this.lPrinces.add(nCivID);
        this.iPrincesSize = this.lPrinces.size();
        CFG.core.getCiv(nCivID).setIsPartOfHolyRomanEmpire(true);
    }

    public final void removePrinceID(int nID) {
        this.removePrince(this.getPrince(nID));
    }

    public final void removePrince(int nCivID) {
        for (int i = 0; i < this.getPrincesSize(); ++i) {
            if (this.getPrince(i) != nCivID) continue;
            CFG.core.getCiv(nCivID).setIsPartOfHolyRomanEmpire(false);
            this.removeElector(nCivID);
            this.lPrinces.remove(i);
            this.iPrincesSize = this.lPrinces.size();
            for (int j = 0; j < this.getElectorsSize(); ++j) {
                if (this.lElectors.get(j) <= i) continue;
                this.lElectors.set(j, this.lElectors.get(j) - 1);
            }
            if (this.iEmperorID == i) {
                this.iEmperorID = this.getElectorsSize() > 0 ? this.getElector(0) : -1;
            } else if (this.iEmperorID > i) {
                --this.iEmperorID;
            }
            return;
        }
    }

    public final int getPrincesSize() {
        return this.iPrincesSize;
    }

    public final int getPrincesSize_True() {
        int out = 0;
        for (int i = 0; i < this.getPrincesSize(); ++i) {
            if (CFG.core.getCiv(this.getPrince(i)).getNumOfProvs() <= 0) continue;
            ++out;
        }
        return out;
    }

    public final boolean getIsPrince(int nCivID) {
        for (int i = 0; i < this.getPrincesSize(); ++i) {
            if (this.getPrince(i) != nCivID) continue;
            return true;
        }
        return false;
    }

    public final void dissolveHRE() {
        try {
            int i;
            for (i = this.lPrinces.size() - 1; i >= 0; --i) {
                CFG.core.getCiv(this.lPrinces.get(i)).setIsPartOfHolyRomanEmpire(false);
            }
            for (i = this.lElectors.size() - 1; i >= 0; --i) {
                CFG.core.getCiv(this.lElectors.get(i)).setIsPartOfHolyRomanEmpire(false);
            }
            for (i = this.lProvinces.size() - 1; i >= 0; --i) {
                CFG.core.getProv(this.lProvinces.get(i)).setIsPartOfHolyRomanEmpire(false);
            }
            this.lPrinces.clear();
            this.iPrincesSize = 0;
            this.lElectors.clear();
            this.iElectorsSize = 0;
            this.iEmperorID = -1;
            this.lProvinces.clear();
            this.iProvincesSize = 0;
            this.lVotesFor.clear();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public boolean canUnitHRE() {
        return this.getCivsSizeThatExists() <= GameValues.gvHre.UNITE_CIVS_BELOW;
    }

    public int getCivsSizeThatExists() {
        int out = 0;
        for (int i = this.lPrinces.size() - 1; i >= 0; --i) {
            if (CFG.core.getCiv(this.lPrinces.get(i)).getNumOfProvs() <= 0) continue;
            ++out;
        }
        return out;
    }

    public final void uniteHRE(int civID) {
        try {
            for (int i = this.lPrinces.size() - 1; i >= 0; --i) {
                int j;
                if (this.lPrinces.get(i) == civID) continue;
                ArrayList<Integer> provs = new ArrayList<Integer>();
                for (j = CFG.core.getCiv(this.lPrinces.get(i)).getNumOfProvs() - 1; j >= 0; --j) {
                    provs.add(CFG.core.getCiv(this.lPrinces.get(i)).getProvID(j));
                }
                for (j = provs.size() - 1; j >= 0; --j) {
                    int k;
                    long tempArmy0 = CFG.core.getProv((Integer)provs.get(j)).getArmyID(0);
                    int tempCiv0 = CFG.core.getProv((Integer)provs.get(j)).getCivId();
                    long tempArmyNewOwner = CFG.core.getProv((Integer)provs.get(j)).getArmyCivID1(civID);
                    CFG.core.getProv((Integer)provs.get(j)).updateArmy4(0);
                    if (CFG.core.getCiv(CFG.core.getProv((Integer)provs.get(j)).getTrueOwnerOfProv()).getIsPartOfHolyRomanEmpire()) {
                        CFG.core.getProv((Integer)provs.get(j)).setTrueOwnerOfProv(civID);
                    }
                    CFG.core.getProv((Integer)provs.get(j)).setCivId(civID, false);
                    CFG.core.getProv((Integer)provs.get(j)).updateArmy4(tempCiv0, tempArmy0);
                    CFG.core.getProv((Integer)provs.get(j)).updateArmy4(civID, tempArmyNewOwner);
                    ArrayList<Integer> tempCivsLostAccess = new ArrayList<Integer>();
                    for (k = 0; k < CFG.core.getProv((Integer)provs.get(j)).getCivsSize(); ++k) {
                        tempCivsLostAccess.add(CFG.core.getProv((Integer)provs.get(j)).getCivId(k));
                    }
                    for (k = 0; k < tempCivsLostAccess.size(); ++k) {
                        if (CFG.core.getCiv((Integer)tempCivsLostAccess.get(k)).getPuppetOfCiv() == civID || CFG.core.getCiv(civID).getPuppetOfCiv() == ((Integer)tempCivsLostAccess.get(k)).intValue() || CFG.core.getCiv((Integer)tempCivsLostAccess.get(k)).getAlliance() > 0 && CFG.core.getCiv((Integer)tempCivsLostAccess.get(k)).getAlliance() == CFG.core.getCiv(civID).getAlliance() || CFG.core.getMilitaryAccess((Integer)tempCivsLostAccess.get(k), civID) > 0) continue;
                        CFG.gameAction.accessLost_MoveArmyToClosetsProvince((Integer)tempCivsLostAccess.get(k), (Integer)provs.get(j));
                    }
                    if (CFG.core.getProv((Integer)provs.get(j)).isCapital()) continue;
                    CFG.core.getProv((Integer)provs.get(j)).removeCapitalCityIcon();
                }
            }
            Core.addSimpleTask(new Core.SimpleTask("rebuildRegionsCivs" + civID, civID){

                @Override
                public void update() {
                    CFG.core.buildCivilizationRegions(this.id);
                }
            });
            this.dissolveHRE();
        }
        catch (Exception exception) {
            
        }
    }

    public final int getEmperor() {
        if (this.iEmperorID >= 0 && this.iEmperorID < this.lPrinces.size()) {
            return this.lPrinces.get(this.iEmperorID);
        }
        return -1;
    }

    public final void setEmperor(int nCivID) {
        for (int i = 0; i < this.getPrincesSize(); ++i) {
            if (this.getPrince(i) != nCivID) continue;
            this.iEmperorID = i;
            this.removeElector(nCivID);
            return;
        }
    }

    public final void setEmperorID(int nID) {
        this.iEmperorID = this.iEmperorID == nID || nID >= this.getPrincesSize() ? -1 : nID;
    }

    public final int getEmperorAuthority() {
        return this.iEmperorAuthority;
    }

    public final void setEmperorAuthority(int iEmperorAuthority) {
        this.iEmperorAuthority = iEmperorAuthority;
    }

    public boolean getIsEmperor(int nCivID) {
        if (this.iEmperorID >= 0) {
            return this.getPrince(this.iEmperorID) == nCivID;
        }
        return false;
    }

    public final int getElector(int i) {
        return this.lElectors.get(i);
    }

    public final void addElector(int nCivID) {
        if (this.getElectorsSize() < 7) {
            for (int i = 0; i < this.getPrincesSize(); ++i) {
                if (this.getPrince(i) != nCivID) continue;
                this.lElectors.add(i);
                this.iElectorsSize = this.lElectors.size();
                this.buildVotesFor();
                return;
            }
        }
    }

    public final void removeElector(int nCivID) {
        for (int i = 0; i < this.getElectorsSize(); ++i) {
            if (this.getPrince(this.lElectors.get(i)) != nCivID) continue;
            this.lElectors.remove(i);
            this.iElectorsSize = this.lElectors.size();
            this.buildVotesFor();
            return;
        }
    }

    public final int getElectorsSize() {
        return this.iElectorsSize;
    }

    public final boolean getIsElector(int nCivID) {
        for (int i = 0; i < this.getElectorsSize(); ++i) {
            if (this.getPrince(this.getElector(i)) != nCivID) continue;
            return true;
        }
        return false;
    }

    public final void setElectorID(int nID) {
        if (nID < this.getPrincesSize()) {
            if (this.getIsElector(this.getPrince(nID))) {
                this.removeElector(this.getPrince(nID));
            } else {
                this.addElector(this.getPrince(nID));
            }
        }
    }

    public final void addStrongestPrinceAsElector() {
        ArrayList<Integer> tPossibleElectors = new ArrayList<Integer>();
        for (int i = 0; i < this.getPrincesSize(); ++i) {
            if (CFG.core.getCiv(this.getPrince(i)).getNumOfProvs() <= 0 || this.getIsElector(this.getPrince(i)) || this.getIsEmperor(this.getPrince(i))) continue;
            tPossibleElectors.add(this.getPrince(i));
        }
        if (tPossibleElectors.size() > 0) {
            int tBest = 0;
            for (int i = 0; i < tPossibleElectors.size(); ++i) {
                if (CFG.core.getCiv((Integer)tPossibleElectors.get(i)).countPop() <= CFG.core.getCiv((Integer)tPossibleElectors.get(tBest)).countPop()) continue;
                tBest = i;
            }
            this.addElector((Integer)tPossibleElectors.get(tBest));
        }
    }

    public final void buildVotesFor() {
        if (this.lVotesFor == null) {
            this.lVotesFor = new ArrayList<Integer>();
        }
        if (this.lVotesFor.size() == 0) {
            for (int i = 0; i < this.getElectorsSize(); ++i) {
                this.lVotesFor.add(this.getPrince(this.getElector(i)));
            }
        } else {
            int i;
            ArrayList<Integer> oldVotes = new ArrayList<Integer>();
            for (i = 0; i < this.lVotesFor.size(); ++i) {
                oldVotes.add(this.lVotesFor.get(i));
            }
            this.lVotesFor.clear();
            for (i = 0; i < this.getElectorsSize(); ++i) {
                if (CFG.core.getCiv(this.getPrince(this.getElector(i))).getIsPlayer()) {
                    try {
                        this.lVotesFor.add((Integer)oldVotes.get(i));
                    }
                    catch (IndexOutOfBoundsException ex) {
                        this.lVotesFor.add(this.getPrince(this.getElector(i)));
                    }
                    continue;
                }
                this.lVotesFor.add(this.getPrince(this.getElector(i)));
            }
        }
    }

    public final int getNextElectionsIn() {
        return this.iNextElectionsIn;
    }

    public final void setNextElectionsIn(int iNextElectionsIn) {
        this.iNextElectionsIn = iNextElectionsIn;
    }

    public final void randomNextElections() {
        this.iNextElectionsIn = 32 + CFG.oR.nextInt(60);
    }
}

